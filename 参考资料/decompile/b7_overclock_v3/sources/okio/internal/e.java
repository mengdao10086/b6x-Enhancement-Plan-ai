package okio.internal;

import com.flydigi.sdk.bluetooth.l;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.analytics.pro.an;
import java.util.Arrays;
import java.util.Objects;
import kotlin.collections.m;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.text.u;
import m0.k;
import okio.ByteString;
import okio.a1;
import okio.y0;
import okio.z0;
import w.w;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\u0019\n\u0002\b\b\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0080\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0000H\u0080\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0080\b\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\u0080\b\u001a\r\u0010\u0006\u001a\u00020\u0000*\u00020\u0000H\u0080\b\u001a\r\u0010\u0007\u001a\u00020\u0000*\u00020\u0000H\u0080\b\u001a\u001d\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0080\b\u001a\u0015\u0010\u000e\u001a\u00020\r*\u00020\u00002\u0006\u0010\f\u001a\u00020\bH\u0080\b\u001a\r\u0010\u000f\u001a\u00020\b*\u00020\u0000H\u0080\b\u001a\r\u0010\u0011\u001a\u00020\u0010*\u00020\u0000H\u0080\b\u001a\r\u0010\u0012\u001a\u00020\u0010*\u00020\u0000H\u0080\b\u001a-\u0010\u0018\u001a\u00020\u0017*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0080\b\u001a-\u0010\u0019\u001a\u00020\u0017*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0080\b\u001a-\u0010\u001d\u001a\u00020\u001c*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0080\b\u001a\u0015\u0010\u001f\u001a\u00020\u0017*\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0000H\u0080\b\u001a\u0015\u0010 \u001a\u00020\u0017*\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0010H\u0080\b\u001a\u0015\u0010\"\u001a\u00020\u0017*\u00020\u00002\u0006\u0010!\u001a\u00020\u0000H\u0080\b\u001a\u0015\u0010#\u001a\u00020\u0017*\u00020\u00002\u0006\u0010!\u001a\u00020\u0010H\u0080\b\u001a\u001d\u0010%\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\bH\u0080\b\u001a\u001d\u0010&\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\bH\u0080\b\u001a\u001d\u0010'\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\bH\u0080\b\u001a\u0017\u0010)\u001a\u00020\u0017*\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010(H\u0080\b\u001a\r\u0010*\u001a\u00020\b*\u00020\u0000H\u0080\b\u001a\u0015\u0010+\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0000H\u0080\b\u001a\u0011\u0010-\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0010H\u0080\b\u001a\u001d\u0010.\u001a\u00020\u0000*\u00020\u00102\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0080\b\u001a\r\u0010/\u001a\u00020\u0000*\u00020\u0001H\u0080\b\u001a\u000f\u00100\u001a\u0004\u0018\u00010\u0000*\u00020\u0001H\u0080\b\u001a\r\u00101\u001a\u00020\u0000*\u00020\u0001H\u0080\b\u001a$\u00104\u001a\u00020\u001c*\u00020\u00002\u0006\u00103\u001a\u0002022\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0000\u001a\u0010\u00107\u001a\u00020\b2\u0006\u00106\u001a\u000205H\u0002\u001a\r\u00108\u001a\u00020\u0001*\u00020\u0000H\u0080\b\u001a\u0018\u00106\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u00109\u001a\u00020\bH\u0002\" \u0010A\u001a\u00020:8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b;\u0010<\u0012\u0004\b?\u0010@\u001a\u0004\b=\u0010>¨\u0006B"}, d2 = {"Lokio/ByteString;", "", "G", "d", "e", "q", "B", "C", "", "beginIndex", "endIndex", i1.a.W4, "pos", "", "n", "o", "", "D", an.aB, w.c.R, "other", "otherOffset", "byteCount", "", "w", "x", "target", "targetOffset", "Lkotlin/z1;", "g", "prefix", "y", an.aD, "suffix", "k", l.f16298a, "fromIndex", SsManifestParser.e.J, "t", "u", "", k.f40564b, "p", "f", "data", "v", i1.a.S4, xf.j.f55230b, "h", "i", "Lokio/j;", "buffer", "H", "", "c", "I", "F", "codePointCount", "", "a", "[C", "J", "()[C", "getHEX_DIGIT_CHARS$annotations", "()V", "HEX_DIGIT_CHARS", "okio"}, k = 2, mv = {1, 5, 1})
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final char[] f44110a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    @yt.k
    public static final ByteString A(@yt.k ByteString byteString, int i10, int i11) {
        f0.p(byteString, "<this>");
        int iL = a1.l(byteString, i11);
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
        if (iL <= byteString.w().length) {
            if (iL - i10 >= 0) {
                return (i10 == 0 && iL == byteString.w().length) ? byteString : new ByteString(m.G1(byteString.w(), i10, iL));
            }
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
        throw new IllegalArgumentException(("endIndex > length(" + byteString.w().length + ')').toString());
    }

    @yt.k
    public static final ByteString B(@yt.k ByteString byteString) {
        byte b10;
        f0.p(byteString, "<this>");
        for (int i10 = 0; i10 < byteString.w().length; i10++) {
            byte b11 = byteString.w()[i10];
            byte b12 = (byte) 65;
            if (b11 >= b12 && b11 <= (b10 = (byte) 90)) {
                byte[] bArrW = byteString.w();
                byte[] bArrCopyOf = Arrays.copyOf(bArrW, bArrW.length);
                f0.o(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                bArrCopyOf[i10] = (byte) (b11 + 32);
                for (int i11 = i10 + 1; i11 < bArrCopyOf.length; i11++) {
                    byte b13 = bArrCopyOf[i11];
                    if (b13 >= b12 && b13 <= b10) {
                        bArrCopyOf[i11] = (byte) (b13 + 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
        }
        return byteString;
    }

    @yt.k
    public static final ByteString C(@yt.k ByteString byteString) {
        byte b10;
        f0.p(byteString, "<this>");
        for (int i10 = 0; i10 < byteString.w().length; i10++) {
            byte b11 = byteString.w()[i10];
            byte b12 = (byte) 97;
            if (b11 >= b12 && b11 <= (b10 = (byte) 122)) {
                byte[] bArrW = byteString.w();
                byte[] bArrCopyOf = Arrays.copyOf(bArrW, bArrW.length);
                f0.o(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                bArrCopyOf[i10] = (byte) (b11 - 32);
                for (int i11 = i10 + 1; i11 < bArrCopyOf.length; i11++) {
                    byte b13 = bArrCopyOf[i11];
                    if (b13 >= b12 && b13 <= b10) {
                        bArrCopyOf[i11] = (byte) (b13 - 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
        }
        return byteString;
    }

    @yt.k
    public static final byte[] D(@yt.k ByteString byteString) {
        f0.p(byteString, "<this>");
        byte[] bArrW = byteString.w();
        byte[] bArrCopyOf = Arrays.copyOf(bArrW, bArrW.length);
        f0.o(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return bArrCopyOf;
    }

    @yt.k
    public static final ByteString E(@yt.k byte[] bArr, int i10, int i11) {
        f0.p(bArr, "<this>");
        a1.e(bArr.length, i10, i11);
        return new ByteString(m.G1(bArr, i10, i11 + i10));
    }

    @yt.k
    public static final String F(@yt.k ByteString byteString) {
        ByteString byteString2 = byteString;
        f0.p(byteString2, "<this>");
        if (byteString.w().length == 0) {
            return "[size=0]";
        }
        int iC = c(byteString.w(), 64);
        if (iC != -1) {
            String strO0 = byteString.O0();
            Objects.requireNonNull(strO0, "null cannot be cast to non-null type java.lang.String");
            String strSubstring = strO0.substring(0, iC);
            f0.o(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String strL2 = u.l2(u.l2(u.l2(strSubstring, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
            if (iC >= strO0.length()) {
                return "[text=" + strL2 + ']';
            }
            return "[size=" + byteString.w().length + " text=" + strL2 + "…]";
        }
        if (byteString.w().length <= 64) {
            return "[hex=" + byteString.B() + ']';
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[size=");
        sb2.append(byteString.w().length);
        sb2.append(" hex=");
        int iL = a1.l(byteString2, 64);
        if (!(iL <= byteString.w().length)) {
            throw new IllegalArgumentException(("endIndex > length(" + byteString.w().length + ')').toString());
        }
        if (!(iL + 0 >= 0)) {
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
        if (iL != byteString.w().length) {
            byteString2 = new ByteString(m.G1(byteString.w(), 0, iL));
        }
        sb2.append(byteString2.B());
        sb2.append("…]");
        return sb2.toString();
    }

    @yt.k
    public static final String G(@yt.k ByteString byteString) {
        f0.p(byteString, "<this>");
        String strA = byteString.A();
        if (strA != null) {
            return strA;
        }
        String strC = z0.c(byteString.O());
        byteString.t0(strC);
        return strC;
    }

    public static final void H(@yt.k ByteString byteString, @yt.k okio.j buffer, int i10, int i11) {
        f0.p(byteString, "<this>");
        f0.p(buffer, "buffer");
        buffer.write(byteString.w(), i10, i11);
    }

    public static final int I(char c10) {
        if ('0' <= c10 && c10 <= '9') {
            return c10 - '0';
        }
        char c11 = 'a';
        if (!('a' <= c10 && c10 <= 'f')) {
            c11 = 'A';
            if (!('A' <= c10 && c10 <= 'F')) {
                throw new IllegalArgumentException(f0.C("Unexpected hex digit: ", Character.valueOf(c10)));
            }
        }
        return (c10 - c11) + 10;
    }

    @yt.k
    public static final char[] J() {
        return f44110a;
    }

    public static /* synthetic */ void K() {
    }

    /* JADX WARN: Removed duplicated region for block: B:162:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0044 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:261:0x007c A[EDGE_INSN: B:261:0x007c->B:55:0x007c BREAK  A[LOOP:1: B:31:0x004d->B:59:0x0082, LOOP_LABEL: LOOP:0: B:3:0x0008->B:289:0x0008], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:268:0x00d3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0160 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0205 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int c(byte[] r19, int r20) {
        /*
            Method dump skipped, instruction units count: 537
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.e.c(byte[], int):int");
    }

    @yt.k
    public static final String d(@yt.k ByteString byteString) {
        f0.p(byteString, "<this>");
        return y0.c(byteString.w(), null, 1, null);
    }

    @yt.k
    public static final String e(@yt.k ByteString byteString) {
        f0.p(byteString, "<this>");
        return y0.b(byteString.w(), y0.f());
    }

    public static final int f(@yt.k ByteString byteString, @yt.k ByteString other) {
        f0.p(byteString, "<this>");
        f0.p(other, "other");
        int iX0 = byteString.x0();
        int iX02 = other.x0();
        int iMin = Math.min(iX0, iX02);
        for (int i10 = 0; i10 < iMin; i10++) {
            int iV = byteString.v(i10) & 255;
            int iV2 = other.v(i10) & 255;
            if (iV != iV2) {
                return iV < iV2 ? -1 : 1;
            }
        }
        if (iX0 == iX02) {
            return 0;
        }
        return iX0 < iX02 ? -1 : 1;
    }

    public static final void g(@yt.k ByteString byteString, int i10, @yt.k byte[] target, int i11, int i12) {
        f0.p(byteString, "<this>");
        f0.p(target, "target");
        m.W0(byteString.w(), target, i11, i10, i12 + i10);
    }

    @yt.l
    public static final ByteString h(@yt.k String str) {
        f0.p(str, "<this>");
        byte[] bArrA = y0.a(str);
        if (bArrA != null) {
            return new ByteString(bArrA);
        }
        return null;
    }

    @yt.k
    public static final ByteString i(@yt.k String str) {
        f0.p(str, "<this>");
        int i10 = 0;
        if (!(str.length() % 2 == 0)) {
            throw new IllegalArgumentException(f0.C("Unexpected hex string: ", str).toString());
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        int i11 = length - 1;
        if (i11 >= 0) {
            while (true) {
                int i12 = i10 + 1;
                int i13 = i10 * 2;
                bArr[i10] = (byte) ((I(str.charAt(i13)) << 4) + I(str.charAt(i13 + 1)));
                if (i12 > i11) {
                    break;
                }
                i10 = i12;
            }
        }
        return new ByteString(bArr);
    }

    @yt.k
    public static final ByteString j(@yt.k String str) {
        f0.p(str, "<this>");
        ByteString byteString = new ByteString(z0.a(str));
        byteString.t0(str);
        return byteString;
    }

    public static final boolean k(@yt.k ByteString byteString, @yt.k ByteString suffix) {
        f0.p(byteString, "<this>");
        f0.p(suffix, "suffix");
        return byteString.o0(byteString.x0() - suffix.x0(), suffix, 0, suffix.x0());
    }

    public static final boolean l(@yt.k ByteString byteString, @yt.k byte[] suffix) {
        f0.p(byteString, "<this>");
        f0.p(suffix, "suffix");
        return byteString.p0(byteString.x0() - suffix.length, suffix, 0, suffix.length);
    }

    public static final boolean m(@yt.k ByteString byteString, @yt.l Object obj) {
        f0.p(byteString, "<this>");
        if (obj == byteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString2 = (ByteString) obj;
            if (byteString2.x0() == byteString.w().length && byteString2.p0(0, byteString.w(), 0, byteString.w().length)) {
                return true;
            }
        }
        return false;
    }

    public static final byte n(@yt.k ByteString byteString, int i10) {
        f0.p(byteString, "<this>");
        return byteString.w()[i10];
    }

    public static final int o(@yt.k ByteString byteString) {
        f0.p(byteString, "<this>");
        return byteString.w().length;
    }

    public static final int p(@yt.k ByteString byteString) {
        f0.p(byteString, "<this>");
        int iX = byteString.x();
        if (iX != 0) {
            return iX;
        }
        int iHashCode = Arrays.hashCode(byteString.w());
        byteString.r0(iHashCode);
        return iHashCode;
    }

    @yt.k
    public static final String q(@yt.k ByteString byteString) {
        f0.p(byteString, "<this>");
        char[] cArr = new char[byteString.w().length * 2];
        byte[] bArrW = byteString.w();
        int length = bArrW.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            byte b10 = bArrW[i10];
            i10++;
            int i12 = i11 + 1;
            cArr[i11] = J()[(b10 >> 4) & 15];
            i11 = i12 + 1;
            cArr[i12] = J()[b10 & 15];
        }
        return u.u1(cArr);
    }

    public static final int r(@yt.k ByteString byteString, @yt.k byte[] other, int i10) {
        f0.p(byteString, "<this>");
        f0.p(other, "other");
        int length = byteString.w().length - other.length;
        int iMax = Math.max(i10, 0);
        if (iMax > length) {
            return -1;
        }
        while (true) {
            int i11 = iMax + 1;
            if (a1.d(byteString.w(), iMax, other, 0, other.length)) {
                return iMax;
            }
            if (iMax == length) {
                return -1;
            }
            iMax = i11;
        }
    }

    @yt.k
    public static final byte[] s(@yt.k ByteString byteString) {
        f0.p(byteString, "<this>");
        return byteString.w();
    }

    public static final int t(@yt.k ByteString byteString, @yt.k ByteString other, int i10) {
        f0.p(byteString, "<this>");
        f0.p(other, "other");
        return byteString.U(other.O(), i10);
    }

    public static final int u(@yt.k ByteString byteString, @yt.k byte[] other, int i10) {
        f0.p(byteString, "<this>");
        f0.p(other, "other");
        int iMin = Math.min(a1.l(byteString, i10), byteString.w().length - other.length);
        if (iMin < 0) {
            return -1;
        }
        while (true) {
            int i11 = iMin - 1;
            if (a1.d(byteString.w(), iMin, other, 0, other.length)) {
                return iMin;
            }
            if (i11 < 0) {
                return -1;
            }
            iMin = i11;
        }
    }

    @yt.k
    public static final ByteString v(@yt.k byte[] data) {
        f0.p(data, "data");
        byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
        f0.o(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return new ByteString(bArrCopyOf);
    }

    public static final boolean w(@yt.k ByteString byteString, int i10, @yt.k ByteString other, int i11, int i12) {
        f0.p(byteString, "<this>");
        f0.p(other, "other");
        return other.p0(i11, byteString.w(), i10, i12);
    }

    public static final boolean x(@yt.k ByteString byteString, int i10, @yt.k byte[] other, int i11, int i12) {
        f0.p(byteString, "<this>");
        f0.p(other, "other");
        return i10 >= 0 && i10 <= byteString.w().length - i12 && i11 >= 0 && i11 <= other.length - i12 && a1.d(byteString.w(), i10, other, i11, i12);
    }

    public static final boolean y(@yt.k ByteString byteString, @yt.k ByteString prefix) {
        f0.p(byteString, "<this>");
        f0.p(prefix, "prefix");
        return byteString.o0(0, prefix, 0, prefix.x0());
    }

    public static final boolean z(@yt.k ByteString byteString, @yt.k byte[] prefix) {
        f0.p(byteString, "<this>");
        f0.p(prefix, "prefix");
        return byteString.p0(0, prefix, 0, prefix.length);
    }
}
