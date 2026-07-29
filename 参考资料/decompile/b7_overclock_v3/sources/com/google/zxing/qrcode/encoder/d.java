package com.google.zxing.qrcode.encoder;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f21672a = 3;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f21673b = 3;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f21674c = 40;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f21675d = 10;

    public static int a(b bVar) {
        return b(bVar, true) + b(bVar, false);
    }

    public static int b(b bVar, boolean z10) {
        int iD = z10 ? bVar.d() : bVar.e();
        int iE = z10 ? bVar.e() : bVar.d();
        byte[][] bArrC = bVar.c();
        int i10 = 0;
        for (int i11 = 0; i11 < iD; i11++) {
            byte b10 = -1;
            int i12 = 0;
            for (int i13 = 0; i13 < iE; i13++) {
                byte b11 = z10 ? bArrC[i11][i13] : bArrC[i13][i11];
                if (b11 == b10) {
                    i12++;
                } else {
                    if (i12 >= 5) {
                        i10 += (i12 - 5) + 3;
                    }
                    b10 = b11;
                    i12 = 1;
                }
            }
            if (i12 >= 5) {
                i10 += (i12 - 5) + 3;
            }
        }
        return i10;
    }

    public static int c(b bVar) {
        byte[][] bArrC = bVar.c();
        int iE = bVar.e();
        int iD = bVar.d();
        int i10 = 0;
        for (int i11 = 0; i11 < iD - 1; i11++) {
            byte[] bArr = bArrC[i11];
            int i12 = 0;
            while (i12 < iE - 1) {
                byte b10 = bArr[i12];
                int i13 = i12 + 1;
                if (b10 == bArr[i13]) {
                    int i14 = i11 + 1;
                    if (b10 == bArrC[i14][i12] && b10 == bArrC[i14][i13]) {
                        i10++;
                    }
                }
                i12 = i13;
            }
        }
        return i10 * 3;
    }

    public static int d(b bVar) {
        byte[][] bArrC = bVar.c();
        int iE = bVar.e();
        int iD = bVar.d();
        int i10 = 0;
        for (int i11 = 0; i11 < iD; i11++) {
            for (int i12 = 0; i12 < iE; i12++) {
                byte[] bArr = bArrC[i11];
                int i13 = i12 + 6;
                if (i13 < iE && bArr[i12] == 1 && bArr[i12 + 1] == 0 && bArr[i12 + 2] == 1 && bArr[i12 + 3] == 1 && bArr[i12 + 4] == 1 && bArr[i12 + 5] == 0 && bArr[i13] == 1 && (g(bArr, i12 - 4, i12) || g(bArr, i12 + 7, i12 + 11))) {
                    i10++;
                }
                int i14 = i11 + 6;
                if (i14 < iD && bArrC[i11][i12] == 1 && bArrC[i11 + 1][i12] == 0 && bArrC[i11 + 2][i12] == 1 && bArrC[i11 + 3][i12] == 1 && bArrC[i11 + 4][i12] == 1 && bArrC[i11 + 5][i12] == 0 && bArrC[i14][i12] == 1 && (h(bArrC, i12, i11 - 4, i11) || h(bArrC, i12, i11 + 7, i11 + 11))) {
                    i10++;
                }
            }
        }
        return i10 * 40;
    }

    public static int e(b bVar) {
        byte[][] bArrC = bVar.c();
        int iE = bVar.e();
        int iD = bVar.d();
        int i10 = 0;
        for (int i11 = 0; i11 < iD; i11++) {
            byte[] bArr = bArrC[i11];
            for (int i12 = 0; i12 < iE; i12++) {
                if (bArr[i12] == 1) {
                    i10++;
                }
            }
        }
        int iD2 = bVar.d() * bVar.e();
        return ((Math.abs((i10 * 2) - iD2) * 10) / iD2) * 10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0047 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean f(int r1, int r2, int r3) {
        /*
            r0 = 1
            switch(r1) {
                case 0: goto L41;
                case 1: goto L42;
                case 2: goto L3e;
                case 3: goto L3a;
                case 4: goto L35;
                case 5: goto L2d;
                case 6: goto L24;
                case 7: goto L1b;
                default: goto L4;
            }
        L4:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = "Invalid mask pattern: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L1b:
            int r1 = r3 * r2
            int r1 = r1 % 3
            int r3 = r3 + r2
            r2 = r3 & 1
            int r1 = r1 + r2
            goto L2b
        L24:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
        L2b:
            r1 = r1 & r0
            goto L44
        L2d:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L44
        L35:
            int r3 = r3 / 2
            int r2 = r2 / 3
            goto L41
        L3a:
            int r3 = r3 + r2
            int r1 = r3 % 3
            goto L44
        L3e:
            int r1 = r2 % 3
            goto L44
        L41:
            int r3 = r3 + r2
        L42:
            r1 = r3 & 1
        L44:
            if (r1 != 0) goto L47
            goto L48
        L47:
            r0 = 0
        L48:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.d.f(int, int, int):boolean");
    }

    public static boolean g(byte[] bArr, int i10, int i11) {
        if (i10 < 0 || bArr.length < i11) {
            return false;
        }
        while (i10 < i11) {
            if (bArr[i10] == 1) {
                return false;
            }
            i10++;
        }
        return true;
    }

    public static boolean h(byte[][] bArr, int i10, int i11, int i12) {
        if (i11 < 0 || bArr.length < i12) {
            return false;
        }
        while (i11 < i12) {
            if (bArr[i11][i10] == 1) {
                return false;
            }
            i11++;
        }
        return true;
    }
}
