package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.hash.Hashing;
import com.google.common.io.ByteStreams;
import com.google.common.primitives.Ints;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.v1;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@Beta
@GwtIncompatible
public final class InetAddresses {
    private static final int IPV4_PART_COUNT = 4;
    private static final int IPV6_PART_COUNT = 8;
    private static final Splitter IPV4_SPLITTER = Splitter.on('.').limit(4);
    private static final Splitter IPV6_SPLITTER = Splitter.on(':').limit(10);
    private static final Inet4Address LOOPBACK4 = (Inet4Address) forString("127.0.0.1");
    private static final Inet4Address ANY4 = (Inet4Address) forString("0.0.0.0");

    @Beta
    public static final class TeredoInfo {
        private final Inet4Address client;
        private final int flags;
        private final int port;
        private final Inet4Address server;

        public TeredoInfo(@NullableDecl Inet4Address inet4Address, @NullableDecl Inet4Address inet4Address2, int i10, int i11) {
            Preconditions.checkArgument(i10 >= 0 && i10 <= 65535, "port '%s' is out of range (0 <= port <= 0xffff)", i10);
            Preconditions.checkArgument(i11 >= 0 && i11 <= 65535, "flags '%s' is out of range (0 <= flags <= 0xffff)", i11);
            this.server = (Inet4Address) MoreObjects.firstNonNull(inet4Address, InetAddresses.ANY4);
            this.client = (Inet4Address) MoreObjects.firstNonNull(inet4Address2, InetAddresses.ANY4);
            this.port = i10;
            this.flags = i11;
        }

        public Inet4Address getClient() {
            return this.client;
        }

        public int getFlags() {
            return this.flags;
        }

        public int getPort() {
            return this.port;
        }

        public Inet4Address getServer() {
            return this.server;
        }
    }

    private InetAddresses() {
    }

    private static InetAddress bytesToInetAddress(byte[] bArr) {
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e10) {
            throw new AssertionError(e10);
        }
    }

    public static int coerceToInteger(InetAddress inetAddress) {
        return ByteStreams.newDataInput(getCoercedIPv4Address(inetAddress).getAddress()).readInt();
    }

    private static void compressLongestRunOfZeroes(int[] iArr) {
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        for (int i13 = 0; i13 < iArr.length + 1; i13++) {
            if (i13 >= iArr.length || iArr[i13] != 0) {
                if (i12 >= 0) {
                    int i14 = i13 - i12;
                    if (i14 > i10) {
                        i11 = i12;
                        i10 = i14;
                    }
                    i12 = -1;
                }
            } else if (i12 < 0) {
                i12 = i13;
            }
        }
        if (i10 >= 2) {
            Arrays.fill(iArr, i11, i10 + i11, -1);
        }
    }

    @NullableDecl
    private static String convertDottedQuadToHex(String str) {
        int iLastIndexOf = str.lastIndexOf(58) + 1;
        String strSubstring = str.substring(0, iLastIndexOf);
        byte[] bArrTextToNumericFormatV4 = textToNumericFormatV4(str.substring(iLastIndexOf));
        if (bArrTextToNumericFormatV4 == null) {
            return null;
        }
        return strSubstring + Integer.toHexString(((bArrTextToNumericFormatV4[0] & 255) << 8) | (bArrTextToNumericFormatV4[1] & 255)) + ":" + Integer.toHexString((bArrTextToNumericFormatV4[3] & 255) | ((bArrTextToNumericFormatV4[2] & 255) << 8));
    }

    public static InetAddress decrement(InetAddress inetAddress) {
        byte[] address = inetAddress.getAddress();
        int length = address.length - 1;
        while (length >= 0 && address[length] == 0) {
            address[length] = -1;
            length--;
        }
        Preconditions.checkArgument(length >= 0, "Decrementing %s would wrap.", inetAddress);
        address[length] = (byte) (address[length] - 1);
        return bytesToInetAddress(address);
    }

    public static InetAddress forString(String str) {
        byte[] bArrIpStringToBytes = ipStringToBytes(str);
        if (bArrIpStringToBytes != null) {
            return bytesToInetAddress(bArrIpStringToBytes);
        }
        throw formatIllegalArgumentException("'%s' is not an IP string literal.", str);
    }

    public static InetAddress forUriString(String str) {
        InetAddress inetAddressForUriStringNoThrow = forUriStringNoThrow(str);
        if (inetAddressForUriStringNoThrow != null) {
            return inetAddressForUriStringNoThrow;
        }
        throw formatIllegalArgumentException("Not a valid URI IP literal: '%s'", str);
    }

    @NullableDecl
    private static InetAddress forUriStringNoThrow(String str) {
        int i10;
        Preconditions.checkNotNull(str);
        if (str.startsWith("[") && str.endsWith("]")) {
            str = str.substring(1, str.length() - 1);
            i10 = 16;
        } else {
            i10 = 4;
        }
        byte[] bArrIpStringToBytes = ipStringToBytes(str);
        if (bArrIpStringToBytes == null || bArrIpStringToBytes.length != i10) {
            return null;
        }
        return bytesToInetAddress(bArrIpStringToBytes);
    }

    private static IllegalArgumentException formatIllegalArgumentException(String str, Object... objArr) {
        return new IllegalArgumentException(String.format(Locale.ROOT, str, objArr));
    }

    public static Inet4Address fromInteger(int i10) {
        return getInet4Address(Ints.toByteArray(i10));
    }

    public static InetAddress fromLittleEndianByteArray(byte[] bArr) throws UnknownHostException {
        byte[] bArr2 = new byte[bArr.length];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr2[i10] = bArr[(bArr.length - i10) - 1];
        }
        return InetAddress.getByAddress(bArr2);
    }

    public static Inet4Address get6to4IPv4Address(Inet6Address inet6Address) {
        Preconditions.checkArgument(is6to4Address(inet6Address), "Address '%s' is not a 6to4 address.", toAddrString(inet6Address));
        return getInet4Address(Arrays.copyOfRange(inet6Address.getAddress(), 2, 6));
    }

    public static Inet4Address getCoercedIPv4Address(InetAddress inetAddress) {
        boolean z10;
        if (inetAddress instanceof Inet4Address) {
            return (Inet4Address) inetAddress;
        }
        byte[] address = inetAddress.getAddress();
        int i10 = 0;
        while (true) {
            if (i10 >= 15) {
                z10 = true;
                break;
            }
            if (address[i10] != 0) {
                z10 = false;
                break;
            }
            i10++;
        }
        if (z10 && address[15] == 1) {
            return LOOPBACK4;
        }
        if (z10 && address[15] == 0) {
            return ANY4;
        }
        Inet6Address inet6Address = (Inet6Address) inetAddress;
        int iAsInt = Hashing.murmur3_32().hashLong(hasEmbeddedIPv4ClientAddress(inet6Address) ? getEmbeddedIPv4ClientAddress(inet6Address).hashCode() : ByteBuffer.wrap(inet6Address.getAddress(), 0, 8).getLong()).asInt() | (-536870912);
        if (iAsInt == -1) {
            iAsInt = -2;
        }
        return getInet4Address(Ints.toByteArray(iAsInt));
    }

    public static Inet4Address getCompatIPv4Address(Inet6Address inet6Address) {
        Preconditions.checkArgument(isCompatIPv4Address(inet6Address), "Address '%s' is not IPv4-compatible.", toAddrString(inet6Address));
        return getInet4Address(Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }

    public static Inet4Address getEmbeddedIPv4ClientAddress(Inet6Address inet6Address) {
        if (isCompatIPv4Address(inet6Address)) {
            return getCompatIPv4Address(inet6Address);
        }
        if (is6to4Address(inet6Address)) {
            return get6to4IPv4Address(inet6Address);
        }
        if (isTeredoAddress(inet6Address)) {
            return getTeredoInfo(inet6Address).getClient();
        }
        throw formatIllegalArgumentException("'%s' has no embedded IPv4 address.", toAddrString(inet6Address));
    }

    private static Inet4Address getInet4Address(byte[] bArr) {
        Preconditions.checkArgument(bArr.length == 4, "Byte array has invalid length for an IPv4 address: %s != 4.", bArr.length);
        return (Inet4Address) bytesToInetAddress(bArr);
    }

    public static Inet4Address getIsatapIPv4Address(Inet6Address inet6Address) {
        Preconditions.checkArgument(isIsatapAddress(inet6Address), "Address '%s' is not an ISATAP address.", toAddrString(inet6Address));
        return getInet4Address(Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }

    public static TeredoInfo getTeredoInfo(Inet6Address inet6Address) {
        Preconditions.checkArgument(isTeredoAddress(inet6Address), "Address '%s' is not a Teredo address.", toAddrString(inet6Address));
        byte[] address = inet6Address.getAddress();
        Inet4Address inet4Address = getInet4Address(Arrays.copyOfRange(address, 4, 8));
        int i10 = ByteStreams.newDataInput(address, 8).readShort() & v1.f38215d;
        int i11 = 65535 & (~ByteStreams.newDataInput(address, 10).readShort());
        byte[] bArrCopyOfRange = Arrays.copyOfRange(address, 12, 16);
        for (int i12 = 0; i12 < bArrCopyOfRange.length; i12++) {
            bArrCopyOfRange[i12] = (byte) (~bArrCopyOfRange[i12]);
        }
        return new TeredoInfo(inet4Address, getInet4Address(bArrCopyOfRange), i11, i10);
    }

    public static boolean hasEmbeddedIPv4ClientAddress(Inet6Address inet6Address) {
        return isCompatIPv4Address(inet6Address) || is6to4Address(inet6Address) || isTeredoAddress(inet6Address);
    }

    private static String hextetsToIPv6String(int[] iArr) {
        StringBuilder sb2 = new StringBuilder(39);
        int i10 = 0;
        boolean z10 = false;
        while (i10 < iArr.length) {
            boolean z11 = iArr[i10] >= 0;
            if (z11) {
                if (z10) {
                    sb2.append(':');
                }
                sb2.append(Integer.toHexString(iArr[i10]));
            } else if (i10 == 0 || z10) {
                sb2.append("::");
            }
            i10++;
            z10 = z11;
        }
        return sb2.toString();
    }

    public static InetAddress increment(InetAddress inetAddress) {
        byte[] address = inetAddress.getAddress();
        int length = address.length - 1;
        while (true) {
            if (length < 0 || address[length] != -1) {
                break;
            }
            address[length] = 0;
            length--;
        }
        Preconditions.checkArgument(length >= 0, "Incrementing %s would wrap.", inetAddress);
        address[length] = (byte) (address[length] + 1);
        return bytesToInetAddress(address);
    }

    @NullableDecl
    private static byte[] ipStringToBytes(String str) {
        boolean z10 = false;
        boolean z11 = false;
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '.') {
                z11 = true;
            } else if (cCharAt == ':') {
                if (z11) {
                    return null;
                }
                z10 = true;
            } else if (Character.digit(cCharAt, 16) == -1) {
                return null;
            }
        }
        if (!z10) {
            if (z11) {
                return textToNumericFormatV4(str);
            }
            return null;
        }
        if (z11 && (str = convertDottedQuadToHex(str)) == null) {
            return null;
        }
        return textToNumericFormatV6(str);
    }

    public static boolean is6to4Address(Inet6Address inet6Address) {
        byte[] address = inet6Address.getAddress();
        return address[0] == 32 && address[1] == 2;
    }

    public static boolean isCompatIPv4Address(Inet6Address inet6Address) {
        if (!inet6Address.isIPv4CompatibleAddress()) {
            return false;
        }
        byte[] address = inet6Address.getAddress();
        return (address[12] == 0 && address[13] == 0 && address[14] == 0 && (address[15] == 0 || address[15] == 1)) ? false : true;
    }

    public static boolean isInetAddress(String str) {
        return ipStringToBytes(str) != null;
    }

    public static boolean isIsatapAddress(Inet6Address inet6Address) {
        if (isTeredoAddress(inet6Address)) {
            return false;
        }
        byte[] address = inet6Address.getAddress();
        return (address[8] | 3) == 3 && address[9] == 0 && address[10] == 94 && address[11] == -2;
    }

    public static boolean isMappedIPv4Address(String str) {
        byte[] bArrIpStringToBytes = ipStringToBytes(str);
        if (bArrIpStringToBytes == null || bArrIpStringToBytes.length != 16) {
            return false;
        }
        int i10 = 0;
        while (true) {
            if (i10 >= 10) {
                for (int i11 = 10; i11 < 12; i11++) {
                    if (bArrIpStringToBytes[i11] != -1) {
                        return false;
                    }
                }
                return true;
            }
            if (bArrIpStringToBytes[i10] != 0) {
                return false;
            }
            i10++;
        }
    }

    public static boolean isMaximum(InetAddress inetAddress) {
        for (byte b10 : inetAddress.getAddress()) {
            if (b10 != -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isTeredoAddress(Inet6Address inet6Address) {
        byte[] address = inet6Address.getAddress();
        return address[0] == 32 && address[1] == 1 && address[2] == 0 && address[3] == 0;
    }

    public static boolean isUriInetAddress(String str) {
        return forUriStringNoThrow(str) != null;
    }

    private static short parseHextet(String str) {
        int i10 = Integer.parseInt(str, 16);
        if (i10 <= 65535) {
            return (short) i10;
        }
        throw new NumberFormatException();
    }

    private static byte parseOctet(String str) {
        int i10 = Integer.parseInt(str);
        if (i10 > 255 || (str.startsWith("0") && str.length() > 1)) {
            throw new NumberFormatException();
        }
        return (byte) i10;
    }

    @NullableDecl
    private static byte[] textToNumericFormatV4(String str) {
        byte[] bArr = new byte[4];
        try {
            Iterator<String> it2 = IPV4_SPLITTER.split(str).iterator();
            int i10 = 0;
            while (it2.hasNext()) {
                int i11 = i10 + 1;
                bArr[i10] = parseOctet(it2.next());
                i10 = i11;
            }
            if (i10 == 4) {
                return bArr;
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @NullableDecl
    private static byte[] textToNumericFormatV6(String str) {
        int size;
        int size2;
        List<String> listSplitToList = IPV6_SPLITTER.splitToList(str);
        if (listSplitToList.size() < 3 || listSplitToList.size() > 9) {
            return null;
        }
        int i10 = -1;
        for (int i11 = 1; i11 < listSplitToList.size() - 1; i11++) {
            if (listSplitToList.get(i11).length() == 0) {
                if (i10 >= 0) {
                    return null;
                }
                i10 = i11;
            }
        }
        if (i10 >= 0) {
            size2 = (listSplitToList.size() - i10) - 1;
            if (listSplitToList.get(0).length() == 0) {
                size = i10 - 1;
                if (size != 0) {
                    return null;
                }
            } else {
                size = i10;
            }
            if (((String) Iterables.getLast(listSplitToList)).length() == 0 && size2 - 1 != 0) {
                return null;
            }
        } else {
            size = listSplitToList.size();
            size2 = 0;
        }
        int i12 = 8 - (size + size2);
        if (i10 < 0 ? i12 != 0 : i12 < 1) {
            return null;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
        for (int i13 = 0; i13 < size; i13++) {
            try {
                byteBufferAllocate.putShort(parseHextet(listSplitToList.get(i13)));
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        for (int i14 = 0; i14 < i12; i14++) {
            byteBufferAllocate.putShort((short) 0);
        }
        while (size2 > 0) {
            byteBufferAllocate.putShort(parseHextet(listSplitToList.get(listSplitToList.size() - size2)));
            size2--;
        }
        return byteBufferAllocate.array();
    }

    public static String toAddrString(InetAddress inetAddress) {
        Preconditions.checkNotNull(inetAddress);
        if (inetAddress instanceof Inet4Address) {
            return inetAddress.getHostAddress();
        }
        Preconditions.checkArgument(inetAddress instanceof Inet6Address);
        byte[] address = inetAddress.getAddress();
        int[] iArr = new int[8];
        for (int i10 = 0; i10 < 8; i10++) {
            int i11 = i10 * 2;
            iArr[i10] = Ints.fromBytes((byte) 0, (byte) 0, address[i11], address[i11 + 1]);
        }
        compressLongestRunOfZeroes(iArr);
        return hextetsToIPv6String(iArr);
    }

    public static String toUriString(InetAddress inetAddress) {
        if (!(inetAddress instanceof Inet6Address)) {
            return toAddrString(inetAddress);
        }
        return "[" + toAddrString(inetAddress) + "]";
    }
}
