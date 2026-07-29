package jg;

import com.blankj.utilcode.util.i0;
import com.qualcomm.qti.libraries.vmupgrade.packet.VMUException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f36413a = "VMUUtils";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f36414b = 8;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f36415c = 8;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f36416d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f36417e = 2;

    public static void a(int i10, byte[] bArr, int i11, int i12, boolean z10) {
        int i13 = 0;
        if ((i12 < 0) || (i12 > 4)) {
            throw new IndexOutOfBoundsException("Length must be between 0 and 4");
        }
        if (bArr.length < i11 + i12) {
            throw new IndexOutOfBoundsException("The targeted location must be contained in the target array.");
        }
        if (!z10) {
            int i14 = (i12 - 1) * 8;
            while (i13 < i12) {
                bArr[i13 + i11] = (byte) (((255 << i14) & i10) >> i14);
                i14 -= 8;
                i13++;
            }
            return;
        }
        int i15 = 0;
        for (int i16 = i12 - 1; i16 >= 0; i16--) {
            bArr[i15 + i11] = (byte) (((255 << i13) & i10) >> i13);
            i13 += 8;
            i15++;
        }
    }

    public static int b(byte[] bArr, int i10, int i11, boolean z10) {
        int i12 = 0;
        if ((i11 < 0) || (i11 > 4)) {
            throw new IndexOutOfBoundsException("Length must be between 0 and 4");
        }
        int i13 = (i11 - 1) * 8;
        if (z10) {
            for (int i14 = (i11 + i10) - 1; i14 >= i10; i14--) {
                i12 |= (bArr[i14] & 255) << i13;
                i13 -= 8;
            }
        } else {
            for (int i15 = i10; i15 < i10 + i11; i15++) {
                i12 |= (bArr[i15] & 255) << i13;
                i13 -= 8;
            }
        }
        return i12;
    }

    public static long c(byte[] bArr, int i10, int i11, boolean z10) {
        if ((i11 > 8) || (i11 < 0)) {
            throw new IndexOutOfBoundsException("Length must be between 0 and 8");
        }
        long j10 = 0;
        int i12 = (i11 - 1) * 8;
        if (z10) {
            for (int i13 = (i11 + i10) - 1; i13 >= i10; i13--) {
                j10 |= (long) ((bArr[i13] & 255) << i12);
                i12 -= 8;
            }
        } else {
            for (int i14 = i10; i14 < i10 + i11; i14++) {
                j10 |= (long) ((bArr[i14] & 255) << i12);
                i12 -= 8;
            }
        }
        return j10;
    }

    public static short d(byte[] bArr, int i10, int i11, boolean z10) {
        short s10 = 0;
        if ((i11 < 0) || (i11 > 2)) {
            throw new IndexOutOfBoundsException("Length must be between 0 and 2");
        }
        int i12 = (i11 - 1) * 8;
        if (z10) {
            for (int i13 = (i11 + i10) - 1; i13 >= i10; i13--) {
                s10 = (short) (((bArr[i13] & 255) << i12) | s10);
                i12 -= 8;
            }
        } else {
            for (int i14 = i10; i14 < i10 + i11; i14++) {
                s10 = (short) (s10 | ((bArr[i14] & 255) << i12));
                i12 -= 8;
            }
        }
        return s10;
    }

    public static byte[] e(File file) throws VMUException {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            long length = file.length();
            int i10 = (int) length;
            if (i10 != length) {
                throw new VMUException(2);
            }
            byte[] bArr = new byte[i10];
            int i11 = fileInputStream.read(bArr);
            fileInputStream.close();
            if (i11 != i10 && (i11 != -1 || i10 != Integer.MAX_VALUE)) {
                throw new VMUException(3);
            }
            return bArr;
        } catch (IOException e10) {
            throw new VMUException(3, e10.getMessage());
        }
    }

    public static String f(int i10) {
        return String.format("0x%04X", Integer.valueOf(i10 & 65535));
    }

    public static String g(byte[] bArr) {
        if (bArr == null) {
            return i0.f11859x;
        }
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b10 : bArr) {
            sb2.append(String.format("0x%02x ", Byte.valueOf(b10)));
        }
        return sb2.toString();
    }

    public static String h(int i10) {
        return String.format("0x%02X", Integer.valueOf(i10 & 255));
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] i(java.io.File r9) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "Exception: "
            java.lang.String r1 = "Exception occurs when tried to get MD5 check sum for file: "
            r2 = 0
            r3 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            r4.<init>(r9)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4e
            java.lang.String r5 = "MD5"
            java.security.MessageDigest r5 = java.security.MessageDigest.getInstance(r5)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4e
            r6 = 0
        L16:
            r7 = -1
            if (r6 == r7) goto L23
            int r6 = r4.read(r3)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4e
            if (r6 <= 0) goto L16
            r5.update(r3, r2, r6)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4e
            goto L16
        L23:
            byte[] r2 = r5.digest()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4e
            r4.close()     // Catch: java.lang.Exception -> L2b
            goto L4a
        L2b:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            java.lang.String r9 = r9.getName()
            r4.append(r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r0)
            java.lang.String r0 = r3.getMessage()
            r9.append(r0)
        L4a:
            return r2
        L4b:
            r2 = move-exception
            r3 = r4
            goto L9c
        L4e:
            r3 = move-exception
            goto L56
        L50:
            r2 = move-exception
            goto L9c
        L52:
            r4 = move-exception
            r8 = r4
            r4 = r3
            r3 = r8
        L56:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4b
            r5.<init>()     // Catch: java.lang.Throwable -> L4b
            r5.append(r1)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r6 = r9.getName()     // Catch: java.lang.Throwable -> L4b
            r5.append(r6)     // Catch: java.lang.Throwable -> L4b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4b
            r5.<init>()     // Catch: java.lang.Throwable -> L4b
            r5.append(r0)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r3 = r3.getMessage()     // Catch: java.lang.Throwable -> L4b
            r5.append(r3)     // Catch: java.lang.Throwable -> L4b
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L4b
            if (r4 == 0) goto L9b
            r4.close()     // Catch: java.lang.Exception -> L7c
            goto L9b
        L7c:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            java.lang.String r9 = r9.getName()
            r4.append(r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r0)
            java.lang.String r0 = r3.getMessage()
            r9.append(r0)
        L9b:
            return r2
        L9c:
            if (r3 == 0) goto Lc1
            r3.close()     // Catch: java.lang.Exception -> La2
            goto Lc1
        La2:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            java.lang.String r9 = r9.getName()
            r4.append(r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r0)
            java.lang.String r0 = r3.getMessage()
            r9.append(r0)
        Lc1:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: jg.d.i(java.io.File):byte[]");
    }
}
