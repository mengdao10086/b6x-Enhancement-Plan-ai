package xe;

import af.b;
import af.k;
import cf.c;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import ve.l;
import zc.f;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f55175g = {3808, 476, 2107, 1799};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f55176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f55177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f55178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f55179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f55180e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f55181f;

    /* JADX INFO: renamed from: xe.a$a, reason: collision with other inner class name */
    public static final class C0650a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f55182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f55183b;

        public C0650a(int i10, int i11) {
            this.f55182a = i10;
            this.f55183b = i11;
        }

        public int a() {
            return this.f55182a;
        }

        public int b() {
            return this.f55183b;
        }

        public l c() {
            return new l(this.f55182a, this.f55183b);
        }

        public String toString() {
            return "<" + this.f55182a + f.f58383m + this.f55183b + '>';
        }
    }

    public a(b bVar) {
        this.f55176a = bVar;
    }

    public static float c(l lVar, l lVar2) {
        return bf.a.a(lVar.c(), lVar.d(), lVar2.c(), lVar2.d());
    }

    public static float d(C0650a c0650a, C0650a c0650a2) {
        return bf.a.b(c0650a.a(), c0650a.b(), c0650a2.a(), c0650a2.b());
    }

    public static l[] e(l[] lVarArr, int i10, int i11) {
        float f10 = i11 / (i10 * 2.0f);
        float fC = lVarArr[0].c() - lVarArr[2].c();
        float fD = lVarArr[0].d() - lVarArr[2].d();
        float fC2 = (lVarArr[0].c() + lVarArr[2].c()) / 2.0f;
        float fD2 = (lVarArr[0].d() + lVarArr[2].d()) / 2.0f;
        float f11 = fC * f10;
        float f12 = fD * f10;
        l lVar = new l(fC2 + f11, fD2 + f12);
        l lVar2 = new l(fC2 - f11, fD2 - f12);
        float fC3 = lVarArr[1].c() - lVarArr[3].c();
        float fD3 = lVarArr[1].d() - lVarArr[3].d();
        float fC4 = (lVarArr[1].c() + lVarArr[3].c()) / 2.0f;
        float fD4 = (lVarArr[1].d() + lVarArr[3].d()) / 2.0f;
        float f13 = fC3 * f10;
        float f14 = f10 * fD3;
        return new l[]{lVar, new l(fC4 + f13, fD4 + f14), lVar2, new l(fC4 - f13, fD4 - f14)};
    }

    public static int i(long j10, boolean z10) throws NotFoundException {
        int i10;
        int i11;
        if (z10) {
            i10 = 7;
            i11 = 2;
        } else {
            i10 = 10;
            i11 = 4;
        }
        int i12 = i10 - i11;
        int[] iArr = new int[i10];
        for (int i13 = i10 - 1; i13 >= 0; i13--) {
            iArr[i13] = ((int) j10) & 15;
            j10 >>= 4;
        }
        try {
            new c(cf.a.f10937k).a(iArr, i12);
            int i14 = 0;
            for (int i15 = 0; i15 < i11; i15++) {
                i14 = (i14 << 4) + iArr[i15];
            }
            return i14;
        } catch (ReedSolomonException unused) {
            throw NotFoundException.b();
        }
    }

    public static int n(int[] iArr, int i10) throws NotFoundException {
        int i11 = 0;
        for (int i12 : iArr) {
            i11 = (i11 << 3) + ((i12 >> (i10 - 2)) << 1) + (i12 & 1);
        }
        int i13 = ((i11 & 1) << 11) + (i11 >> 1);
        for (int i14 = 0; i14 < 4; i14++) {
            if (Integer.bitCount(f55175g[i14] ^ i13) <= 2) {
                return i14;
            }
        }
        throw NotFoundException.b();
    }

    public we.a a() throws NotFoundException {
        return b(false);
    }

    public we.a b(boolean z10) throws NotFoundException {
        l[] lVarArrG = g(l());
        if (z10) {
            l lVar = lVarArrG[0];
            lVarArrG[0] = lVarArrG[2];
            lVarArrG[2] = lVar;
        }
        f(lVarArrG);
        b bVar = this.f55176a;
        int i10 = this.f55181f;
        return new we.a(r(bVar, lVarArrG[i10 % 4], lVarArrG[(i10 + 1) % 4], lVarArrG[(i10 + 2) % 4], lVarArrG[(i10 + 3) % 4]), m(lVarArrG), this.f55177b, this.f55179d, this.f55178c);
    }

    public final void f(l[] lVarArr) throws NotFoundException {
        long j10;
        long j11;
        if (!p(lVarArr[0]) || !p(lVarArr[1]) || !p(lVarArr[2]) || !p(lVarArr[3])) {
            throw NotFoundException.b();
        }
        int i10 = this.f55180e * 2;
        int[] iArr = {s(lVarArr[0], lVarArr[1], i10), s(lVarArr[1], lVarArr[2], i10), s(lVarArr[2], lVarArr[3], i10), s(lVarArr[3], lVarArr[0], i10)};
        this.f55181f = n(iArr, i10);
        long j12 = 0;
        for (int i11 = 0; i11 < 4; i11++) {
            int i12 = iArr[(this.f55181f + i11) % 4];
            if (this.f55177b) {
                j10 = j12 << 7;
                j11 = (i12 >> 1) & 127;
            } else {
                j10 = j12 << 10;
                j11 = ((i12 >> 2) & 992) + ((i12 >> 1) & 31);
            }
            j12 = j10 + j11;
        }
        int i13 = i(j12, this.f55177b);
        if (this.f55177b) {
            this.f55178c = (i13 >> 6) + 1;
            this.f55179d = (i13 & 63) + 1;
        } else {
            this.f55178c = (i13 >> 11) + 1;
            this.f55179d = (i13 & 2047) + 1;
        }
    }

    public final l[] g(C0650a c0650a) throws NotFoundException {
        this.f55180e = 1;
        C0650a c0650a2 = c0650a;
        C0650a c0650a3 = c0650a2;
        C0650a c0650a4 = c0650a3;
        C0650a c0650a5 = c0650a4;
        boolean z10 = true;
        while (this.f55180e < 9) {
            C0650a c0650aK = k(c0650a2, z10, 1, -1);
            C0650a c0650aK2 = k(c0650a3, z10, 1, 1);
            C0650a c0650aK3 = k(c0650a4, z10, -1, 1);
            C0650a c0650aK4 = k(c0650a5, z10, -1, -1);
            if (this.f55180e > 2) {
                double d10 = (d(c0650aK4, c0650aK) * this.f55180e) / (d(c0650a5, c0650a2) * (this.f55180e + 2));
                if (d10 < 0.75d || d10 > 1.25d || !q(c0650aK, c0650aK2, c0650aK3, c0650aK4)) {
                    break;
                }
            }
            z10 = !z10;
            this.f55180e++;
            c0650a5 = c0650aK4;
            c0650a2 = c0650aK;
            c0650a3 = c0650aK2;
            c0650a4 = c0650aK3;
        }
        int i10 = this.f55180e;
        if (i10 != 5 && i10 != 7) {
            throw NotFoundException.b();
        }
        this.f55177b = i10 == 5;
        l[] lVarArr = {new l(c0650a2.a() + 0.5f, c0650a2.b() - 0.5f), new l(c0650a3.a() + 0.5f, c0650a3.b() + 0.5f), new l(c0650a4.a() - 0.5f, c0650a4.b() + 0.5f), new l(c0650a5.a() - 0.5f, c0650a5.b() - 0.5f)};
        int i11 = this.f55180e;
        return e(lVarArr, (i11 * 2) - 3, i11 * 2);
    }

    public final int h(C0650a c0650a, C0650a c0650a2) {
        float fD = d(c0650a, c0650a2);
        if (fD == 0.0f) {
            return 0;
        }
        float fA = (c0650a2.a() - c0650a.a()) / fD;
        float fB = (c0650a2.b() - c0650a.b()) / fD;
        float fA2 = c0650a.a();
        float fB2 = c0650a.b();
        boolean zF = this.f55176a.f(c0650a.a(), c0650a.b());
        int iFloor = (int) Math.floor(fD);
        int i10 = 0;
        for (int i11 = 0; i11 < iFloor; i11++) {
            if (this.f55176a.f(bf.a.c(fA2), bf.a.c(fB2)) != zF) {
                i10++;
            }
            fA2 += fA;
            fB2 += fB;
        }
        float f10 = i10 / fD;
        if (f10 <= 0.1f || f10 >= 0.9f) {
            return (f10 <= 0.1f) == zF ? 1 : -1;
        }
        return 0;
    }

    public final int j() {
        if (this.f55177b) {
            return (this.f55178c * 4) + 11;
        }
        int i10 = this.f55178c;
        return (i10 * 4) + ((((i10 * 2) + 6) / 15) * 2) + 15;
    }

    public final C0650a k(C0650a c0650a, boolean z10, int i10, int i11) {
        int iA = c0650a.a() + i10;
        int iB = c0650a.b();
        while (true) {
            iB += i11;
            if (!o(iA, iB) || this.f55176a.f(iA, iB) != z10) {
                break;
            }
            iA += i10;
        }
        int i12 = iA - i10;
        int i13 = iB - i11;
        while (o(i12, i13) && this.f55176a.f(i12, i13) == z10) {
            i12 += i10;
        }
        int i14 = i12 - i10;
        while (o(i14, i13) && this.f55176a.f(i14, i13) == z10) {
            i13 += i11;
        }
        return new C0650a(i14, i13 - i11);
    }

    public final C0650a l() {
        l lVarC;
        l lVar;
        l lVar2;
        l lVar3;
        l lVarC2;
        l lVarC3;
        l lVarC4;
        l lVarC5;
        try {
            l[] lVarArrC = new bf.c(this.f55176a).c();
            lVar2 = lVarArrC[0];
            lVar3 = lVarArrC[1];
            lVar = lVarArrC[2];
            lVarC = lVarArrC[3];
        } catch (NotFoundException unused) {
            int iM = this.f55176a.m() / 2;
            int i10 = this.f55176a.i() / 2;
            int i11 = iM + 7;
            int i12 = i10 - 7;
            l lVarC6 = k(new C0650a(i11, i12), false, 1, -1).c();
            int i13 = i10 + 7;
            l lVarC7 = k(new C0650a(i11, i13), false, 1, 1).c();
            int i14 = iM - 7;
            l lVarC8 = k(new C0650a(i14, i13), false, -1, 1).c();
            lVarC = k(new C0650a(i14, i12), false, -1, -1).c();
            lVar = lVarC8;
            lVar2 = lVarC6;
            lVar3 = lVarC7;
        }
        int iC = bf.a.c((((lVar2.c() + lVarC.c()) + lVar3.c()) + lVar.c()) / 4.0f);
        int iC2 = bf.a.c((((lVar2.d() + lVarC.d()) + lVar3.d()) + lVar.d()) / 4.0f);
        try {
            l[] lVarArrC2 = new bf.c(this.f55176a, 15, iC, iC2).c();
            lVarC2 = lVarArrC2[0];
            lVarC3 = lVarArrC2[1];
            lVarC4 = lVarArrC2[2];
            lVarC5 = lVarArrC2[3];
        } catch (NotFoundException unused2) {
            int i15 = iC + 7;
            int i16 = iC2 - 7;
            lVarC2 = k(new C0650a(i15, i16), false, 1, -1).c();
            int i17 = iC2 + 7;
            lVarC3 = k(new C0650a(i15, i17), false, 1, 1).c();
            int i18 = iC - 7;
            lVarC4 = k(new C0650a(i18, i17), false, -1, 1).c();
            lVarC5 = k(new C0650a(i18, i16), false, -1, -1).c();
        }
        return new C0650a(bf.a.c((((lVarC2.c() + lVarC5.c()) + lVarC3.c()) + lVarC4.c()) / 4.0f), bf.a.c((((lVarC2.d() + lVarC5.d()) + lVarC3.d()) + lVarC4.d()) / 4.0f));
    }

    public final l[] m(l[] lVarArr) {
        return e(lVarArr, this.f55180e * 2, j());
    }

    public final boolean o(int i10, int i11) {
        return i10 >= 0 && i10 < this.f55176a.m() && i11 >= 0 && i11 < this.f55176a.i();
    }

    public final boolean p(l lVar) {
        return o(bf.a.c(lVar.c()), bf.a.c(lVar.d()));
    }

    public final boolean q(C0650a c0650a, C0650a c0650a2, C0650a c0650a3, C0650a c0650a4) {
        C0650a c0650a5 = new C0650a(Math.max(0, c0650a.a() - 3), Math.min(this.f55176a.i() - 1, c0650a.b() + 3));
        C0650a c0650a6 = new C0650a(Math.max(0, c0650a2.a() - 3), Math.max(0, c0650a2.b() - 3));
        C0650a c0650a7 = new C0650a(Math.min(this.f55176a.m() - 1, c0650a3.a() + 3), Math.max(0, Math.min(this.f55176a.i() - 1, c0650a3.b() - 3)));
        C0650a c0650a8 = new C0650a(Math.min(this.f55176a.m() - 1, c0650a4.a() + 3), Math.min(this.f55176a.i() - 1, c0650a4.b() + 3));
        int iH = h(c0650a8, c0650a5);
        return iH != 0 && h(c0650a5, c0650a6) == iH && h(c0650a6, c0650a7) == iH && h(c0650a7, c0650a8) == iH;
    }

    public final b r(b bVar, l lVar, l lVar2, l lVar3, l lVar4) throws NotFoundException {
        k kVarB = k.b();
        int iJ = j();
        float f10 = iJ / 2.0f;
        int i10 = this.f55180e;
        float f11 = f10 - i10;
        float f12 = f10 + i10;
        return kVarB.c(bVar, iJ, iJ, f11, f11, f12, f11, f12, f12, f11, f12, lVar.c(), lVar.d(), lVar2.c(), lVar2.d(), lVar3.c(), lVar3.d(), lVar4.c(), lVar4.d());
    }

    public final int s(l lVar, l lVar2, int i10) {
        float fC = c(lVar, lVar2);
        float f10 = fC / i10;
        float fC2 = lVar.c();
        float fD = lVar.d();
        float fC3 = ((lVar2.c() - lVar.c()) * f10) / fC;
        float fD2 = (f10 * (lVar2.d() - lVar.d())) / fC;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            float f11 = i12;
            if (this.f55176a.f(bf.a.c((f11 * fC3) + fC2), bf.a.c((f11 * fD2) + fD))) {
                i11 |= 1 << ((i10 - i12) - 1);
            }
        }
        return i11;
    }
}
