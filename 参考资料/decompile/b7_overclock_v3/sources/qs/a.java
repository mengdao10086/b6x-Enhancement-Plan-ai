package qs;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short[][] f47615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public short[] f47616b;

    public short[][] a(short[][] sArr, short[][] sArr2) {
        if (sArr.length != sArr2.length || sArr[0].length != sArr2[0].length) {
            throw new RuntimeException("Addition is not possible!");
        }
        short[][] sArr3 = (short[][]) Array.newInstance((Class<?>) short.class, sArr.length, sArr.length);
        for (int i10 = 0; i10 < sArr.length; i10++) {
            for (int i11 = 0; i11 < sArr2.length; i11++) {
                sArr3[i10][i11] = b.a(sArr[i10][i11], sArr2[i10][i11]);
            }
        }
        return sArr3;
    }

    public short[] b(short[] sArr, short[] sArr2) {
        if (sArr.length != sArr2.length) {
            throw new RuntimeException("Multiplication is not possible!");
        }
        int length = sArr.length;
        short[] sArr3 = new short[length];
        for (int i10 = 0; i10 < length; i10++) {
            sArr3[i10] = b.a(sArr[i10], sArr2[i10]);
        }
        return sArr3;
    }

    public final void c() throws RuntimeException {
        for (int length = this.f47615a.length - 1; length > 0; length--) {
            for (int i10 = length - 1; i10 >= 0; i10--) {
                short[][] sArr = this.f47615a;
                short s10 = sArr[i10][length];
                short sD = b.d(sArr[length][length]);
                if (sD == 0) {
                    throw new RuntimeException("The matrix is not invertible");
                }
                int i11 = length;
                while (true) {
                    short[][] sArr2 = this.f47615a;
                    if (i11 < sArr2.length * 2) {
                        short sE = b.e(s10, b.e(sArr2[length][i11], sD));
                        short[][] sArr3 = this.f47615a;
                        sArr3[i10][i11] = b.a(sArr3[i10][i11], sE);
                        i11++;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0058, code lost:
    
        r0 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(boolean r10) throws java.lang.RuntimeException {
        /*
            r9 = this;
            if (r10 == 0) goto L8
            short[][] r10 = r9.f47615a
            int r10 = r10.length
            int r10 = r10 * 2
            goto Ld
        L8:
            short[][] r10 = r9.f47615a
            int r10 = r10.length
            int r10 = r10 + 1
        Ld:
            r0 = 0
        Le:
            short[][] r1 = r9.f47615a
            int r1 = r1.length
            int r1 = r1 + (-1)
            if (r0 >= r1) goto L5a
            int r1 = r0 + 1
            r2 = r1
        L18:
            short[][] r3 = r9.f47615a
            int r4 = r3.length
            if (r2 >= r4) goto L58
            r4 = r3[r2]
            short r4 = r4[r0]
            r3 = r3[r0]
            short r3 = r3[r0]
            short r3 = qs.b.d(r3)
            if (r3 == 0) goto L50
            r5 = r0
        L2c:
            if (r5 >= r10) goto L4d
            short[][] r6 = r9.f47615a
            r6 = r6[r0]
            short r6 = r6[r5]
            short r6 = qs.b.e(r6, r3)
            short r6 = qs.b.e(r4, r6)
            short[][] r7 = r9.f47615a
            r8 = r7[r2]
            r7 = r7[r2]
            short r7 = r7[r5]
            short r6 = qs.b.a(r7, r6)
            r8[r5] = r6
            int r5 = r5 + 1
            goto L2c
        L4d:
            int r2 = r2 + 1
            goto L18
        L50:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "Matrix not invertible! We have to choose another one!"
            r10.<init>(r0)
            throw r10
        L58:
            r0 = r1
            goto Le
        L5a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: qs.a.d(boolean):void");
    }

    public short[][] e(short[][] sArr) {
        try {
            int i10 = 0;
            this.f47615a = (short[][]) Array.newInstance((Class<?>) short.class, sArr.length, sArr.length * 2);
            if (sArr.length != sArr[0].length) {
                throw new RuntimeException("The matrix is not invertible. Please choose another one!");
            }
            for (int i11 = 0; i11 < sArr.length; i11++) {
                for (int i12 = 0; i12 < sArr.length; i12++) {
                    this.f47615a[i11][i12] = sArr[i11][i12];
                }
                for (int length = sArr.length; length < sArr.length * 2; length++) {
                    this.f47615a[i11][length] = 0;
                }
                short[][] sArr2 = this.f47615a;
                sArr2[i11][sArr2.length + i11] = 1;
            }
            d(true);
            int i13 = 0;
            while (true) {
                short[][] sArr3 = this.f47615a;
                if (i13 >= sArr3.length) {
                    break;
                }
                short sD = b.d(sArr3[i13][i13]);
                int i14 = i13;
                while (true) {
                    short[][] sArr4 = this.f47615a;
                    if (i14 < sArr4.length * 2) {
                        sArr4[i13][i14] = b.e(sArr4[i13][i14], sD);
                        i14++;
                    }
                }
                i13++;
            }
            c();
            short[][] sArr5 = this.f47615a;
            short[][] sArr6 = (short[][]) Array.newInstance((Class<?>) short.class, sArr5.length, sArr5.length);
            while (true) {
                short[][] sArr7 = this.f47615a;
                if (i10 >= sArr7.length) {
                    return sArr6;
                }
                int length2 = sArr7.length;
                while (true) {
                    short[][] sArr8 = this.f47615a;
                    if (length2 < sArr8.length * 2) {
                        sArr6[i10][length2 - sArr8.length] = sArr8[i10][length2];
                        length2++;
                    }
                }
                i10++;
            }
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public short[][] f(short s10, short[][] sArr) {
        short[][] sArr2 = (short[][]) Array.newInstance((Class<?>) short.class, sArr.length, sArr[0].length);
        for (int i10 = 0; i10 < sArr.length; i10++) {
            for (int i11 = 0; i11 < sArr[0].length; i11++) {
                sArr2[i10][i11] = b.e(s10, sArr[i10][i11]);
            }
        }
        return sArr2;
    }

    public short[] g(short s10, short[] sArr) {
        int length = sArr.length;
        short[] sArr2 = new short[length];
        for (int i10 = 0; i10 < length; i10++) {
            sArr2[i10] = b.e(s10, sArr[i10]);
        }
        return sArr2;
    }

    public short[][] h(short[] sArr, short[] sArr2) {
        if (sArr.length != sArr2.length) {
            throw new RuntimeException("Multiplication is not possible!");
        }
        short[][] sArr3 = (short[][]) Array.newInstance((Class<?>) short.class, sArr.length, sArr2.length);
        for (int i10 = 0; i10 < sArr.length; i10++) {
            for (int i11 = 0; i11 < sArr2.length; i11++) {
                sArr3[i10][i11] = b.e(sArr[i10], sArr2[i11]);
            }
        }
        return sArr3;
    }

    public short[] i(short[][] sArr, short[] sArr2) throws RuntimeException {
        if (sArr[0].length != sArr2.length) {
            throw new RuntimeException("Multiplication is not possible!");
        }
        short[] sArr3 = new short[sArr.length];
        for (int i10 = 0; i10 < sArr.length; i10++) {
            for (int i11 = 0; i11 < sArr2.length; i11++) {
                sArr3[i10] = b.a(sArr3[i10], b.e(sArr[i10][i11], sArr2[i11]));
            }
        }
        return sArr3;
    }

    public short[][] j(short[][] sArr, short[][] sArr2) throws RuntimeException {
        if (sArr[0].length != sArr2.length) {
            throw new RuntimeException("Multiplication is not possible!");
        }
        this.f47615a = (short[][]) Array.newInstance((Class<?>) short.class, sArr.length, sArr2[0].length);
        for (int i10 = 0; i10 < sArr.length; i10++) {
            for (int i11 = 0; i11 < sArr2.length; i11++) {
                for (int i12 = 0; i12 < sArr2[0].length; i12++) {
                    short sE = b.e(sArr[i10][i11], sArr2[i11][i12]);
                    short[][] sArr3 = this.f47615a;
                    sArr3[i10][i12] = b.a(sArr3[i10][i12], sE);
                }
            }
        }
        return this.f47615a;
    }

    public short[] k(short[][] sArr, short[] sArr2) {
        if (sArr.length != sArr2.length) {
            return null;
        }
        try {
            this.f47615a = (short[][]) Array.newInstance((Class<?>) short.class, sArr.length, sArr.length + 1);
            this.f47616b = new short[sArr.length];
            for (int i10 = 0; i10 < sArr.length; i10++) {
                for (int i11 = 0; i11 < sArr[0].length; i11++) {
                    this.f47615a[i10][i11] = sArr[i10][i11];
                }
            }
            for (int i12 = 0; i12 < sArr2.length; i12++) {
                short[][] sArr3 = this.f47615a;
                sArr3[i12][sArr2.length] = b.a(sArr2[i12], sArr3[i12][sArr2.length]);
            }
            d(false);
            l();
            return this.f47616b;
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public final void l() throws IllegalStateException {
        short sD = b.d(this.f47615a[r0.length - 1][r0.length - 1]);
        if (sD == 0) {
            throw new IllegalStateException("The equation system is not solvable");
        }
        short[] sArr = this.f47616b;
        short[][] sArr2 = this.f47615a;
        sArr[sArr2.length - 1] = b.e(sArr2[sArr2.length - 1][sArr2.length], sD);
        for (int length = this.f47615a.length - 2; length >= 0; length--) {
            short[][] sArr3 = this.f47615a;
            short sA = sArr3[length][sArr3.length];
            for (int length2 = sArr3.length - 1; length2 > length; length2--) {
                sA = b.a(sA, b.e(this.f47615a[length][length2], this.f47616b[length2]));
            }
            short sD2 = b.d(this.f47615a[length][length]);
            if (sD2 == 0) {
                throw new IllegalStateException("Not solvable equation system");
            }
            this.f47616b[length] = b.e(sA, sD2);
        }
    }
}
