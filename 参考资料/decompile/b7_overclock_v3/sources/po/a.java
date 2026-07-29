package po;

import et.e;
import gm.j;
import java.io.IOException;
import org.bouncycastle.util.o;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: po.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0532a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f46900d = 64;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f46901a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f46902b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f46903c;

        public AbstractC0532a() {
            this.f46901a = new byte[4];
            this.f46902b = 0;
        }

        public AbstractC0532a(AbstractC0532a abstractC0532a) {
            this.f46901a = new byte[abstractC0532a.f46901a.length];
            a(abstractC0532a);
        }

        public void a(AbstractC0532a abstractC0532a) {
            byte[] bArr = abstractC0532a.f46901a;
            System.arraycopy(bArr, 0, this.f46901a, 0, bArr.length);
            this.f46902b = abstractC0532a.f46902b;
            this.f46903c = abstractC0532a.f46903c;
        }

        public void b() {
            long j10 = this.f46903c << 3;
            byte b10 = -128;
            while (true) {
                g(b10);
                if (this.f46902b == 0) {
                    d(j10);
                    c();
                    return;
                }
                b10 = 0;
            }
        }

        public abstract void c();

        public abstract void d(long j10);

        public abstract void e(byte[] bArr, int i10);

        public void f() {
            this.f46903c = 0L;
            this.f46902b = 0;
            int i10 = 0;
            while (true) {
                byte[] bArr = this.f46901a;
                if (i10 >= bArr.length) {
                    return;
                }
                bArr[i10] = 0;
                i10++;
            }
        }

        public void g(byte b10) {
            byte[] bArr = this.f46901a;
            int i10 = this.f46902b;
            int i11 = i10 + 1;
            this.f46902b = i11;
            bArr[i10] = b10;
            if (i11 == bArr.length) {
                e(bArr, 0);
                this.f46902b = 0;
            }
            this.f46903c++;
        }

        public void h(byte[] bArr, int i10, int i11) {
            while (this.f46902b != 0 && i11 > 0) {
                g(bArr[i10]);
                i10++;
                i11--;
            }
            while (i11 > this.f46901a.length) {
                e(bArr, i10);
                byte[] bArr2 = this.f46901a;
                i10 += bArr2.length;
                i11 -= bArr2.length;
                this.f46903c += (long) bArr2.length;
            }
            while (i11 > 0) {
                g(bArr[i10]);
                i10++;
                i11--;
            }
        }
    }

    public static class b extends AbstractC0532a {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f46904l = 20;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int f46905m = 1518500249;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int f46906n = 1859775393;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final int f46907o = -1894007588;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final int f46908p = -899497514;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f46909e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f46910f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f46911g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f46912h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f46913i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int[] f46914j = new int[80];

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f46915k;

        public b() {
            f();
        }

        @Override // po.a.AbstractC0532a
        public void c() {
            for (int i10 = 16; i10 < 80; i10++) {
                int[] iArr = this.f46914j;
                int i11 = ((iArr[i10 - 3] ^ iArr[i10 - 8]) ^ iArr[i10 - 14]) ^ iArr[i10 - 16];
                iArr[i10] = (i11 >>> 31) | (i11 << 1);
            }
            int iN = this.f46909e;
            int iN2 = this.f46910f;
            int i12 = this.f46911g;
            int i13 = this.f46912h;
            int i14 = this.f46913i;
            int i15 = 0;
            int i16 = 0;
            while (i15 < 4) {
                int i17 = i16 + 1;
                int iJ = i14 + ((iN << 5) | (iN >>> 27)) + j(iN2, i12, i13) + this.f46914j[i16] + 1518500249;
                int i18 = (iN2 >>> 2) | (iN2 << 30);
                int i19 = i17 + 1;
                int iJ2 = i13 + ((iJ << 5) | (iJ >>> 27)) + j(iN, i18, i12) + this.f46914j[i17] + 1518500249;
                int i20 = (iN >>> 2) | (iN << 30);
                int i21 = i19 + 1;
                int iJ3 = i12 + ((iJ2 << 5) | (iJ2 >>> 27)) + j(iJ, i20, i18) + this.f46914j[i19] + 1518500249;
                i14 = (iJ >>> 2) | (iJ << 30);
                int i22 = i21 + 1;
                iN2 = i18 + ((iJ3 << 5) | (iJ3 >>> 27)) + j(iJ2, i14, i20) + this.f46914j[i21] + 1518500249;
                i13 = (iJ2 >>> 2) | (iJ2 << 30);
                iN = i20 + ((iN2 << 5) | (iN2 >>> 27)) + j(iJ3, i13, i14) + this.f46914j[i22] + 1518500249;
                i12 = (iJ3 >>> 2) | (iJ3 << 30);
                i15++;
                i16 = i22 + 1;
            }
            int i23 = 0;
            while (i23 < 4) {
                int i24 = i16 + 1;
                int iN3 = i14 + ((iN << 5) | (iN >>> 27)) + n(iN2, i12, i13) + this.f46914j[i16] + 1859775393;
                int i25 = (iN2 >>> 2) | (iN2 << 30);
                int i26 = i24 + 1;
                int iN4 = i13 + ((iN3 << 5) | (iN3 >>> 27)) + n(iN, i25, i12) + this.f46914j[i24] + 1859775393;
                int i27 = (iN >>> 2) | (iN << 30);
                int i28 = i26 + 1;
                int iN5 = i12 + ((iN4 << 5) | (iN4 >>> 27)) + n(iN3, i27, i25) + this.f46914j[i26] + 1859775393;
                i14 = (iN3 >>> 2) | (iN3 << 30);
                int i29 = i28 + 1;
                iN2 = i25 + ((iN5 << 5) | (iN5 >>> 27)) + n(iN4, i14, i27) + this.f46914j[i28] + 1859775393;
                i13 = (iN4 >>> 2) | (iN4 << 30);
                iN = i27 + ((iN2 << 5) | (iN2 >>> 27)) + n(iN5, i13, i14) + this.f46914j[i29] + 1859775393;
                i12 = (iN5 >>> 2) | (iN5 << 30);
                i23++;
                i16 = i29 + 1;
            }
            int i30 = 0;
            while (i30 < 4) {
                int iK = i14 + (((((iN << 5) | (iN >>> 27)) + k(iN2, i12, i13)) + this.f46914j[i16]) - 1894007588);
                int iK2 = i13 + (((((iK << 5) | (iK >>> 27)) + k(iN, r2, i12)) + this.f46914j[r12]) - 1894007588);
                int iK3 = i12 + (((((iK2 << 5) | (iK2 >>> 27)) + k(iK, r1, r2)) + this.f46914j[r13]) - 1894007588);
                i14 = (iK >>> 2) | (iK << 30);
                iN2 = ((iN2 >>> 2) | (iN2 << 30)) + (((((iK3 << 5) | (iK3 >>> 27)) + k(iK2, i14, r1)) + this.f46914j[r12]) - 1894007588);
                i13 = (iK2 >>> 2) | (iK2 << 30);
                iN = ((iN >>> 2) | (iN << 30)) + (((((iN2 << 5) | (iN2 >>> 27)) + k(iK3, i13, i14)) + this.f46914j[r13]) - 1894007588);
                i12 = (iK3 >>> 2) | (iK3 << 30);
                i30++;
                i16 = i16 + 1 + 1 + 1 + 1 + 1;
            }
            int i31 = 0;
            while (i31 <= 3) {
                int iN6 = i14 + (((((iN << 5) | (iN >>> 27)) + n(iN2, i12, i13)) + this.f46914j[i16]) - 899497514);
                int iN7 = i13 + (((((iN6 << 5) | (iN6 >>> 27)) + n(iN, r2, i12)) + this.f46914j[r11]) - 899497514);
                int iN8 = i12 + (((((iN7 << 5) | (iN7 >>> 27)) + n(iN6, r1, r2)) + this.f46914j[r12]) - 899497514);
                i14 = (iN6 >>> 2) | (iN6 << 30);
                iN2 = ((iN2 >>> 2) | (iN2 << 30)) + (((((iN8 << 5) | (iN8 >>> 27)) + n(iN7, i14, r1)) + this.f46914j[r11]) - 899497514);
                i13 = (iN7 >>> 2) | (iN7 << 30);
                iN = ((iN >>> 2) | (iN << 30)) + (((((iN2 << 5) | (iN2 >>> 27)) + n(iN8, i13, i14)) + this.f46914j[r12]) - 899497514);
                i12 = (iN8 >>> 2) | (iN8 << 30);
                i31++;
                i16 = i16 + 1 + 1 + 1 + 1 + 1;
            }
            this.f46909e += iN;
            this.f46910f += iN2;
            this.f46911g += i12;
            this.f46912h += i13;
            this.f46913i += i14;
            this.f46915k = 0;
            for (int i32 = 0; i32 < 16; i32++) {
                this.f46914j[i32] = 0;
            }
        }

        @Override // po.a.AbstractC0532a
        public void d(long j10) {
            if (this.f46915k > 14) {
                c();
            }
            int[] iArr = this.f46914j;
            iArr[14] = (int) (j10 >>> 32);
            iArr[15] = (int) (j10 & (-1));
        }

        @Override // po.a.AbstractC0532a
        public void e(byte[] bArr, int i10) {
            int i11 = bArr[i10] << 24;
            int i12 = i10 + 1;
            int i13 = i11 | ((bArr[i12] & 255) << 16);
            int i14 = i12 + 1;
            int i15 = (bArr[i14 + 1] & 255) | i13 | ((bArr[i14] & 255) << 8);
            int[] iArr = this.f46914j;
            int i16 = this.f46915k;
            iArr[i16] = i15;
            int i17 = i16 + 1;
            this.f46915k = i17;
            if (i17 == 16) {
                c();
            }
        }

        @Override // po.a.AbstractC0532a
        public void f() {
            super.f();
            this.f46909e = 1732584193;
            this.f46910f = -271733879;
            this.f46911g = -1732584194;
            this.f46912h = 271733878;
            this.f46913i = -1009589776;
            this.f46915k = 0;
            int i10 = 0;
            while (true) {
                int[] iArr = this.f46914j;
                if (i10 == iArr.length) {
                    return;
                }
                iArr[i10] = 0;
                i10++;
            }
        }

        public int i(byte[] bArr, int i10) {
            b();
            o.h(this.f46909e, bArr, i10);
            o.h(this.f46910f, bArr, i10 + 4);
            o.h(this.f46911g, bArr, i10 + 8);
            o.h(this.f46912h, bArr, i10 + 12);
            o.h(this.f46913i, bArr, i10 + 16);
            f();
            return 20;
        }

        public final int j(int i10, int i11, int i12) {
            return ((~i10) & i12) | (i11 & i10);
        }

        public final int k(int i10, int i11, int i12) {
            return (i10 & i12) | (i10 & i11) | (i11 & i12);
        }

        public String l() {
            return e.f27137f;
        }

        public int m() {
            return 20;
        }

        public final int n(int i10, int i11, int i12) {
            return (i10 ^ i11) ^ i12;
        }
    }

    public static byte[] a(c1 c1Var) {
        b bVar = new b();
        byte[] bArr = new byte[bVar.m()];
        try {
            byte[] bArrV = c1Var.v(j.f29713a);
            bVar.h(bArrV, 0, bArrV.length);
            bVar.i(bArr, 0);
            return bArr;
        } catch (IOException unused) {
            return new byte[0];
        }
    }
}
