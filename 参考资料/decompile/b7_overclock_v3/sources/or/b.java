package or;

import java.security.SecureRandom;
import java.util.Objects;
import nr.c;
import org.bouncycastle.crypto.m0;
import rr.o;
import zo.j0;

/* JADX INFO: loaded from: classes6.dex */
public abstract class b {
    public static final int A = 96434764;
    public static final int B = 227822194;
    public static final int C = 149865618;
    public static final int D = 550336261;
    public static final int G = -39081;
    public static final int H = 7;
    public static final int I = 5;
    public static final int J = 5;
    public static final int K = 18;
    public static final int L = 16;
    public static final int M = 15;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f44439a = 67108863;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f44440b = 268435455;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f44441c = 4294967295L;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f44442d = 14;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f44443e = 57;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f44444f = 14;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f44445g = 57;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f44446h = 64;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f44447i = 57;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f44448j = 57;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f44449k = 114;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f44453o = 78101261;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f44454p = 141809365;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f44455q = 175155932;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f44456r = 64542499;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f44457s = 158326419;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f44458t = 191173276;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f44459u = 104575268;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f44460v = 137584065;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f44461w = 43969588;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f44462x = 30366549;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f44463y = 163752818;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f44464z = 258169998;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final byte[] f44450l = {83, 105, 103, 69, 100, 52, 52, 56};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int[] f44451m = {-1, -1, -1, -1, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f44452n = {-1420278541, 595116690, -1916432555, 560775794, -1361693040, -1001465015, 2093622249, -1, -1, -1, -1, -1, -1, 1073741823};
    public static final int[] E = {118276190, 40534716, 9670182, 135141552, 85017403, 259173222, 68333082, 171784774, 174973732, 15824510, 73756743, 57518561, 94773951, 248652241, 107736333, 82941708};
    public static final int[] F = {36764180, 8885695, 130592152, 20104429, 163904957, 30304195, 121295871, 5901357, 125344798, 171541512, 175338348, 209069246, 3626697, 38307682, 24032956, 110359655};
    public static final Object N = new Object();
    public static d[] O = null;
    public static int[] P = null;

    /* JADX INFO: renamed from: or.b$b, reason: collision with other inner class name */
    public static final class C0500b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f44465a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f44466b = 1;
    }

    public static class c extends nr.d {
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f44467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int[] f44468b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int[] f44469c;

        public d() {
            this.f44467a = nr.d.j();
            this.f44468b = nr.d.j();
            this.f44469c = nr.d.j();
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f44470a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int[] f44471b;

        public e() {
            this.f44470a = nr.d.j();
            this.f44471b = nr.d.j();
        }
    }

    public static void A(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, byte b10, byte[] bArr4, int i12, int i13, byte[] bArr5, int i14) {
        if (!b(bArr3)) {
            throw new IllegalArgumentException("ctx");
        }
        m0 m0VarI = i();
        byte[] bArr6 = new byte[114];
        m0VarI.update(bArr, i10, 57);
        m0VarI.f(bArr6, 0, 114);
        byte[] bArr7 = new byte[57];
        Q(bArr6, 0, bArr7);
        y(m0VarI, bArr6, bArr7, bArr2, i11, bArr3, b10, bArr4, i12, i13, bArr5, i14);
    }

    public static boolean B(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, byte b10, byte[] bArr4, int i12, int i13) {
        if (!b(bArr3)) {
            throw new IllegalArgumentException("ctx");
        }
        byte[] bArrG = g(bArr, i10, 57);
        byte[] bArrG2 = g(bArr, i10 + 57, 57);
        if (!e(bArrG)) {
            return false;
        }
        int[] iArr = new int[14];
        if (!f(bArrG2, iArr)) {
            return false;
        }
        d dVar = new d();
        if (!n(bArr2, i11, true, dVar)) {
            return false;
        }
        m0 m0VarI = i();
        byte[] bArr5 = new byte[114];
        p(m0VarI, b10, bArr3);
        m0VarI.update(bArrG, 0, 57);
        m0VarI.update(bArr2, i11, 57);
        m0VarI.update(bArr4, i12, i13);
        m0VarI.f(bArr5, 0, 114);
        int[] iArr2 = new int[14];
        o(R(bArr5), 0, iArr2);
        d dVar2 = new d();
        X(iArr, iArr2, dVar, dVar2);
        byte[] bArr6 = new byte[57];
        return t(dVar2, bArr6, 0) != 0 && org.bouncycastle.util.a.g(bArr6, bArrG);
    }

    public static boolean C(int[] iArr, int[] iArr2, int[] iArr3) {
        return nr.d.D(iArr) && nr.d.e(iArr2, iArr3);
    }

    public static void D(d dVar, d dVar2) {
        int[] iArrJ = nr.d.j();
        int[] iArrJ2 = nr.d.j();
        int[] iArrJ3 = nr.d.j();
        int[] iArrJ4 = nr.d.j();
        int[] iArrJ5 = nr.d.j();
        int[] iArrJ6 = nr.d.j();
        int[] iArrJ7 = nr.d.j();
        int[] iArrJ8 = nr.d.j();
        nr.d.F(dVar.f44469c, dVar2.f44469c, iArrJ);
        nr.d.M(iArrJ, iArrJ2);
        nr.d.F(dVar.f44467a, dVar2.f44467a, iArrJ3);
        nr.d.F(dVar.f44468b, dVar2.f44468b, iArrJ4);
        nr.d.F(iArrJ3, iArrJ4, iArrJ5);
        nr.d.E(iArrJ5, 39081, iArrJ5);
        nr.d.a(iArrJ2, iArrJ5, iArrJ6);
        nr.d.O(iArrJ2, iArrJ5, iArrJ7);
        nr.d.a(dVar.f44467a, dVar.f44468b, iArrJ2);
        nr.d.a(dVar2.f44467a, dVar2.f44468b, iArrJ5);
        nr.d.F(iArrJ2, iArrJ5, iArrJ8);
        nr.d.a(iArrJ4, iArrJ3, iArrJ2);
        nr.d.O(iArrJ4, iArrJ3, iArrJ5);
        nr.d.f(iArrJ2);
        nr.d.O(iArrJ8, iArrJ2, iArrJ8);
        nr.d.F(iArrJ8, iArrJ, iArrJ8);
        nr.d.F(iArrJ5, iArrJ, iArrJ5);
        nr.d.F(iArrJ6, iArrJ8, dVar2.f44467a);
        nr.d.F(iArrJ5, iArrJ7, dVar2.f44468b);
        nr.d.F(iArrJ6, iArrJ7, dVar2.f44469c);
    }

    public static void E(e eVar, d dVar) {
        int[] iArrJ = nr.d.j();
        int[] iArrJ2 = nr.d.j();
        int[] iArrJ3 = nr.d.j();
        int[] iArrJ4 = nr.d.j();
        int[] iArrJ5 = nr.d.j();
        int[] iArrJ6 = nr.d.j();
        int[] iArrJ7 = nr.d.j();
        nr.d.M(dVar.f44469c, iArrJ);
        nr.d.F(eVar.f44470a, dVar.f44467a, iArrJ2);
        nr.d.F(eVar.f44471b, dVar.f44468b, iArrJ3);
        nr.d.F(iArrJ2, iArrJ3, iArrJ4);
        nr.d.E(iArrJ4, 39081, iArrJ4);
        nr.d.a(iArrJ, iArrJ4, iArrJ5);
        nr.d.O(iArrJ, iArrJ4, iArrJ6);
        nr.d.a(eVar.f44470a, eVar.f44471b, iArrJ);
        nr.d.a(dVar.f44467a, dVar.f44468b, iArrJ4);
        nr.d.F(iArrJ, iArrJ4, iArrJ7);
        nr.d.a(iArrJ3, iArrJ2, iArrJ);
        nr.d.O(iArrJ3, iArrJ2, iArrJ4);
        nr.d.f(iArrJ);
        nr.d.O(iArrJ7, iArrJ, iArrJ7);
        nr.d.F(iArrJ7, dVar.f44469c, iArrJ7);
        nr.d.F(iArrJ4, dVar.f44469c, iArrJ4);
        nr.d.F(iArrJ5, iArrJ7, dVar.f44467a);
        nr.d.F(iArrJ4, iArrJ6, dVar.f44468b);
        nr.d.F(iArrJ5, iArrJ6, dVar.f44469c);
    }

    public static void F(boolean z10, d dVar, d dVar2) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] iArrJ = nr.d.j();
        int[] iArrJ2 = nr.d.j();
        int[] iArrJ3 = nr.d.j();
        int[] iArrJ4 = nr.d.j();
        int[] iArrJ5 = nr.d.j();
        int[] iArrJ6 = nr.d.j();
        int[] iArrJ7 = nr.d.j();
        int[] iArrJ8 = nr.d.j();
        if (z10) {
            nr.d.O(dVar.f44468b, dVar.f44467a, iArrJ8);
            iArr2 = iArrJ2;
            iArr = iArrJ5;
            iArr4 = iArrJ6;
            iArr3 = iArrJ7;
        } else {
            nr.d.a(dVar.f44468b, dVar.f44467a, iArrJ8);
            iArr = iArrJ2;
            iArr2 = iArrJ5;
            iArr3 = iArrJ6;
            iArr4 = iArrJ7;
        }
        nr.d.F(dVar.f44469c, dVar2.f44469c, iArrJ);
        nr.d.M(iArrJ, iArrJ2);
        nr.d.F(dVar.f44467a, dVar2.f44467a, iArrJ3);
        nr.d.F(dVar.f44468b, dVar2.f44468b, iArrJ4);
        nr.d.F(iArrJ3, iArrJ4, iArrJ5);
        nr.d.E(iArrJ5, 39081, iArrJ5);
        nr.d.a(iArrJ2, iArrJ5, iArr3);
        nr.d.O(iArrJ2, iArrJ5, iArr4);
        nr.d.a(dVar2.f44467a, dVar2.f44468b, iArrJ5);
        nr.d.F(iArrJ8, iArrJ5, iArrJ8);
        nr.d.a(iArrJ4, iArrJ3, iArr);
        nr.d.O(iArrJ4, iArrJ3, iArr2);
        nr.d.f(iArr);
        nr.d.O(iArrJ8, iArrJ2, iArrJ8);
        nr.d.F(iArrJ8, iArrJ, iArrJ8);
        nr.d.F(iArrJ5, iArrJ, iArrJ5);
        nr.d.F(iArrJ6, iArrJ8, dVar2.f44467a);
        nr.d.F(iArrJ5, iArrJ7, dVar2.f44468b);
        nr.d.F(iArrJ6, iArrJ7, dVar2.f44469c);
    }

    public static d G(d dVar) {
        d dVar2 = new d();
        H(dVar, dVar2);
        return dVar2;
    }

    public static void H(d dVar, d dVar2) {
        nr.d.i(dVar.f44467a, 0, dVar2.f44467a, 0);
        nr.d.i(dVar.f44468b, 0, dVar2.f44468b, 0);
        nr.d.i(dVar.f44469c, 0, dVar2.f44469c, 0);
    }

    public static void I(d dVar) {
        int[] iArrJ = nr.d.j();
        int[] iArrJ2 = nr.d.j();
        int[] iArrJ3 = nr.d.j();
        int[] iArrJ4 = nr.d.j();
        int[] iArrJ5 = nr.d.j();
        int[] iArrJ6 = nr.d.j();
        nr.d.a(dVar.f44467a, dVar.f44468b, iArrJ);
        nr.d.M(iArrJ, iArrJ);
        nr.d.M(dVar.f44467a, iArrJ2);
        nr.d.M(dVar.f44468b, iArrJ3);
        nr.d.a(iArrJ2, iArrJ3, iArrJ4);
        nr.d.f(iArrJ4);
        nr.d.M(dVar.f44469c, iArrJ5);
        nr.d.a(iArrJ5, iArrJ5, iArrJ5);
        nr.d.f(iArrJ5);
        nr.d.O(iArrJ4, iArrJ5, iArrJ6);
        nr.d.O(iArrJ, iArrJ4, iArrJ);
        nr.d.O(iArrJ2, iArrJ3, iArrJ2);
        nr.d.F(iArrJ, iArrJ6, dVar.f44467a);
        nr.d.F(iArrJ4, iArrJ2, dVar.f44468b);
        nr.d.F(iArrJ4, iArrJ6, dVar.f44469c);
    }

    public static void J(d dVar) {
        nr.d.I(dVar.f44469c);
    }

    public static void K(int i10, int i11, e eVar) {
        int i12 = i10 * 16 * 2 * 16;
        for (int i13 = 0; i13 < 16; i13++) {
            int i14 = ((i13 ^ i11) - 1) >> 31;
            nr.d.g(i14, P, i12, eVar.f44470a, 0);
            int i15 = i12 + 16;
            nr.d.g(i14, P, i15, eVar.f44471b, 0);
            i12 = i15 + 16;
        }
    }

    public static void L(int[] iArr, int i10, int[] iArr2, d dVar) {
        int iW = w(iArr, i10);
        int i11 = (iW >>> 3) ^ 1;
        int i12 = (iW ^ (-i11)) & 7;
        int i13 = 0;
        for (int i14 = 0; i14 < 8; i14++) {
            int i15 = ((i14 ^ i12) - 1) >> 31;
            nr.d.g(i15, iArr2, i13, dVar.f44467a, 0);
            int i16 = i13 + 16;
            nr.d.g(i15, iArr2, i16, dVar.f44468b, 0);
            int i17 = i16 + 16;
            nr.d.g(i15, iArr2, i17, dVar.f44469c, 0);
            i13 = i17 + 16;
        }
        nr.d.h(i11, dVar.f44467a);
    }

    public static int[] M(d dVar, int i10) {
        d dVarG = G(dVar);
        d dVarG2 = G(dVarG);
        I(dVarG2);
        int[] iArrK = nr.d.k(i10 * 3);
        int i11 = 0;
        int i12 = 0;
        while (true) {
            nr.d.i(dVarG.f44467a, 0, iArrK, i11);
            int i13 = i11 + 16;
            nr.d.i(dVarG.f44468b, 0, iArrK, i13);
            int i14 = i13 + 16;
            nr.d.i(dVarG.f44469c, 0, iArrK, i14);
            i11 = i14 + 16;
            i12++;
            if (i12 == i10) {
                return iArrK;
            }
            D(dVarG2, dVarG);
        }
    }

    public static d[] N(d dVar, int i10) {
        d dVarG = G(dVar);
        I(dVarG);
        d[] dVarArr = new d[i10];
        dVarArr[0] = G(dVar);
        for (int i11 = 1; i11 < i10; i11++) {
            dVarArr[i11] = G(dVarArr[i11 - 1]);
            F(false, dVarG, dVarArr[i11]);
        }
        return dVarArr;
    }

    public static void O(d dVar) {
        nr.d.Q(dVar.f44467a);
        nr.d.I(dVar.f44468b);
        nr.d.I(dVar.f44469c);
    }

    public static void P() {
        synchronized (N) {
            if (P != null) {
                return;
            }
            d dVar = new d();
            nr.d.i(E, 0, dVar.f44467a, 0);
            nr.d.i(F, 0, dVar.f44468b, 0);
            J(dVar);
            O = N(dVar, 32);
            P = nr.d.k(160);
            int i10 = 0;
            for (int i11 = 0; i11 < 5; i11++) {
                d[] dVarArr = new d[5];
                d dVar2 = new d();
                O(dVar2);
                int i12 = 0;
                while (true) {
                    if (i12 >= 5) {
                        break;
                    }
                    F(true, dVar, dVar2);
                    I(dVar);
                    dVarArr[i12] = G(dVar);
                    if (i11 + i12 != 8) {
                        for (int i13 = 1; i13 < 18; i13++) {
                            I(dVar);
                        }
                    }
                    i12++;
                }
                d[] dVarArr2 = new d[16];
                dVarArr2[0] = dVar2;
                int i14 = 1;
                for (int i15 = 0; i15 < 4; i15++) {
                    int i16 = 1 << i15;
                    int i17 = 0;
                    while (i17 < i16) {
                        dVarArr2[i14] = G(dVarArr2[i14 - i16]);
                        F(false, dVarArr[i15], dVarArr2[i14]);
                        i17++;
                        i14++;
                    }
                }
                int[] iArrK = nr.d.k(16);
                int[] iArrJ = nr.d.j();
                nr.d.i(dVarArr2[0].f44469c, 0, iArrJ, 0);
                nr.d.i(iArrJ, 0, iArrK, 0);
                int i18 = 0;
                while (true) {
                    i18++;
                    if (i18 >= 16) {
                        break;
                    }
                    nr.d.F(iArrJ, dVarArr2[i18].f44469c, iArrJ);
                    nr.d.i(iArrJ, 0, iArrK, i18 * 16);
                }
                nr.d.z(iArrJ, iArrJ);
                int i19 = i18 - 1;
                int[] iArrJ2 = nr.d.j();
                while (i19 > 0) {
                    int i20 = i19 - 1;
                    nr.d.i(iArrK, i20 * 16, iArrJ2, 0);
                    nr.d.F(iArrJ2, iArrJ, iArrJ2);
                    nr.d.i(iArrJ2, 0, iArrK, i19 * 16);
                    nr.d.F(iArrJ, dVarArr2[i19].f44469c, iArrJ);
                    i19 = i20;
                }
                nr.d.i(iArrJ, 0, iArrK, 0);
                for (int i21 = 0; i21 < 16; i21++) {
                    d dVar3 = dVarArr2[i21];
                    nr.d.i(iArrK, i21 * 16, dVar3.f44469c, 0);
                    int[] iArr = dVar3.f44467a;
                    nr.d.F(iArr, dVar3.f44469c, iArr);
                    int[] iArr2 = dVar3.f44468b;
                    nr.d.F(iArr2, dVar3.f44469c, iArr2);
                    nr.d.i(dVar3.f44467a, 0, P, i10);
                    int i22 = i10 + 16;
                    nr.d.i(dVar3.f44468b, 0, P, i22);
                    i10 = i22 + 16;
                }
            }
        }
    }

    public static void Q(byte[] bArr, int i10, byte[] bArr2) {
        System.arraycopy(bArr, i10, bArr2, 0, 56);
        bArr2[0] = (byte) (bArr2[0] & 252);
        bArr2[55] = (byte) (bArr2[55] | 128);
        bArr2[56] = 0;
    }

    public static byte[] R(byte[] bArr) {
        long jL = ((long) l(bArr, 0)) & 4294967295L;
        long jK = ((long) (k(bArr, 4) << 4)) & 4294967295L;
        long jL2 = ((long) l(bArr, 7)) & 4294967295L;
        long jK2 = ((long) (k(bArr, 11) << 4)) & 4294967295L;
        long jL3 = ((long) l(bArr, 14)) & 4294967295L;
        long jK3 = ((long) (k(bArr, 18) << 4)) & 4294967295L;
        long jL4 = ((long) l(bArr, 21)) & 4294967295L;
        long jK4 = ((long) (k(bArr, 25) << 4)) & 4294967295L;
        long jL5 = ((long) l(bArr, 28)) & 4294967295L;
        long jK5 = ((long) (k(bArr, 32) << 4)) & 4294967295L;
        long jL6 = ((long) l(bArr, 35)) & 4294967295L;
        long jK6 = ((long) (k(bArr, 39) << 4)) & 4294967295L;
        long jL7 = ((long) l(bArr, 42)) & 4294967295L;
        long jK7 = ((long) (k(bArr, 46) << 4)) & 4294967295L;
        long jL8 = ((long) l(bArr, 49)) & 4294967295L;
        long jK8 = ((long) (k(bArr, 53) << 4)) & 4294967295L;
        long jL9 = ((long) l(bArr, 56)) & 4294967295L;
        long jK9 = ((long) (k(bArr, 60) << 4)) & 4294967295L;
        long jL10 = ((long) l(bArr, 63)) & 4294967295L;
        long jK10 = ((long) (k(bArr, 67) << 4)) & 4294967295L;
        long jL11 = ((long) l(bArr, 70)) & 4294967295L;
        long jK11 = ((long) (k(bArr, 74) << 4)) & 4294967295L;
        long jL12 = ((long) l(bArr, 77)) & 4294967295L;
        long jK12 = ((long) (k(bArr, 81) << 4)) & 4294967295L;
        long jL13 = ((long) l(bArr, 84)) & 4294967295L;
        long jK13 = ((long) (k(bArr, 88) << 4)) & 4294967295L;
        long jL14 = ((long) l(bArr, 91)) & 4294967295L;
        long jK14 = ((long) (k(bArr, 95) << 4)) & 4294967295L;
        long jL15 = ((long) l(bArr, 98)) & 4294967295L;
        long jK15 = ((long) (k(bArr, 102) << 4)) & 4294967295L;
        long jL16 = ((long) l(bArr, 105)) & 4294967295L;
        long jK16 = ((long) (k(bArr, 109) << 4)) & 4294967295L;
        long j10 = ((long) j(bArr, 112)) & 4294967295L;
        long j11 = jK16 + (jL16 >>> 28);
        long j12 = jL16 & 268435455;
        long j13 = jK11 + (j10 * 227822194) + (j11 * 149865618);
        long j14 = jL12 + (j10 * 149865618) + (j11 * 550336261);
        long j15 = jL8 + (j12 * 43969588);
        long j16 = jK8 + (j11 * 43969588) + (j12 * 30366549);
        long j17 = jL9 + (j10 * 43969588) + (j11 * 30366549) + (j12 * 163752818);
        long j18 = jK9 + (j10 * 30366549) + (j11 * 163752818) + (j12 * 258169998);
        long j19 = jL10 + (j10 * 163752818) + (j11 * 258169998) + (j12 * 96434764);
        long j20 = jK10 + (j10 * 258169998) + (j11 * 96434764) + (j12 * 227822194);
        long j21 = jL11 + (j10 * 96434764) + (j11 * 227822194) + (j12 * 149865618);
        long j22 = jK15 + (jL15 >>> 28);
        long j23 = jL15 & 268435455;
        long j24 = jK7 + (j22 * 43969588);
        long j25 = j20 + (j22 * 149865618);
        long j26 = j21 + (j22 * 550336261);
        long j27 = jL7 + (j23 * 43969588);
        long j28 = j15 + (j22 * 30366549) + (j23 * 163752818);
        long j29 = j16 + (j22 * 163752818) + (j23 * 258169998);
        long j30 = j17 + (j22 * 258169998) + (j23 * 96434764);
        long j31 = j18 + (j22 * 96434764) + (j23 * 227822194);
        long j32 = j19 + (j22 * 227822194) + (j23 * 149865618);
        long j33 = jK14 + (jL14 >>> 28);
        long j34 = jL14 & 268435455;
        long j35 = jK6 + (j33 * 43969588);
        long j36 = j32 + (j33 * 550336261);
        long j37 = jL6 + (j34 * 43969588);
        long j38 = j27 + (j33 * 30366549) + (j34 * 163752818);
        long j39 = j24 + (j23 * 30366549) + (j33 * 163752818) + (j34 * 258169998);
        long j40 = j28 + (j33 * 258169998) + (j34 * 96434764);
        long j41 = j29 + (j33 * 96434764) + (j34 * 227822194);
        long j42 = j30 + (j33 * 227822194) + (j34 * 149865618);
        long j43 = j31 + (j33 * 149865618) + (j34 * 550336261);
        long j44 = jK13 + (jL13 >>> 28);
        long j45 = j13 + (j12 * 550336261) + (j26 >>> 28);
        long j46 = j14 + (j45 >>> 28);
        long j47 = jK12 + (j10 * 550336261) + (j46 >>> 28);
        long j48 = j46 & 268435455;
        long j49 = (jL13 & 268435455) + (j47 >>> 28);
        long j50 = j47 & 268435455;
        long j51 = jK4 + (j50 * 43969588);
        long j52 = jL5 + (j49 * 43969588) + (j50 * 30366549);
        long j53 = jK5 + (j44 * 43969588) + (j49 * 30366549) + (j50 * 163752818);
        long j54 = j37 + (j44 * 30366549) + (j49 * 163752818) + (j50 * 258169998);
        long j55 = j35 + (j34 * 30366549) + (j44 * 163752818) + (j49 * 258169998) + (j50 * 96434764);
        long j56 = j38 + (j44 * 258169998) + (j49 * 96434764) + (j50 * 227822194);
        long j57 = j39 + (j44 * 96434764) + (j49 * 227822194) + (j50 * 149865618);
        long j58 = j40 + (j44 * 227822194) + (j49 * 149865618) + (j50 * 550336261);
        long j59 = jL4 + (j48 * 43969588);
        long j60 = j36 + (j43 >>> 28);
        long j61 = j25 + (j23 * 550336261) + (j60 >>> 28);
        long j62 = (j26 & 268435455) + (j61 >>> 28);
        long j63 = j61 & 268435455;
        long j64 = (j45 & 268435455) + (j62 >>> 28);
        long j65 = j62 & 268435455;
        long j66 = jL3 + (j65 * 43969588);
        long j67 = jK3 + (j64 * 43969588) + (j65 * 30366549);
        long j68 = j59 + (j64 * 30366549) + (j65 * 163752818);
        long j69 = j51 + (j48 * 30366549) + (j64 * 163752818) + (j65 * 258169998);
        long j70 = j52 + (j48 * 163752818) + (j64 * 258169998) + (j65 * 96434764);
        long j71 = j53 + (j48 * 258169998) + (j64 * 96434764) + (j65 * 227822194);
        long j72 = j54 + (j48 * 96434764) + (j64 * 227822194) + (j65 * 149865618);
        long j73 = j55 + (j48 * 227822194) + (j64 * 149865618) + (j65 * 550336261);
        long j74 = j41 + (j44 * 149865618) + (j49 * 550336261) + (j58 >>> 28);
        long j75 = j42 + (j44 * 550336261) + (j74 >>> 28);
        long j76 = j74 & 268435455;
        long j77 = (j43 & 268435455) + (j75 >>> 28);
        long j78 = (j60 & 268435455) + (j77 >>> 28);
        long j79 = j77 & 268435455;
        long j80 = jL2 + (j78 * 43969588);
        long j81 = jK2 + (j63 * 43969588) + (j78 * 30366549);
        long j82 = j66 + (j63 * 30366549) + (j78 * 163752818);
        long j83 = j67 + (j63 * 163752818) + (j78 * 258169998);
        long j84 = j68 + (j63 * 258169998) + (j78 * 96434764);
        long j85 = j69 + (j63 * 96434764) + (j78 * 227822194);
        long j86 = j70 + (j63 * 227822194) + (j78 * 149865618);
        long j87 = j71 + (j63 * 149865618) + (j78 * 550336261);
        long j88 = j76 & f44439a;
        long j89 = ((j75 & 268435455) * 4) + (j76 >>> 26) + 1;
        long j90 = jL + (78101261 * j89);
        long j91 = j80 + (30366549 * j79) + (175155932 * j89);
        long j92 = j81 + (163752818 * j79) + (64542499 * j89);
        long j93 = j82 + (258169998 * j79) + (158326419 * j89);
        long j94 = j83 + (96434764 * j79) + (191173276 * j89);
        long j95 = j84 + (227822194 * j79) + (104575268 * j89);
        long j96 = j85 + (149865618 * j79) + (j89 * 137584065);
        long j97 = jK + (43969588 * j79) + (141809365 * j89) + (j90 >>> 28);
        long j98 = j91 + (j97 >>> 28);
        long j99 = j92 + (j98 >>> 28);
        long j100 = j93 + (j99 >>> 28);
        long j101 = j94 + (j100 >>> 28);
        long j102 = j100 & 268435455;
        long j103 = j95 + (j101 >>> 28);
        long j104 = j101 & 268435455;
        long j105 = j96 + (j103 >>> 28);
        long j106 = j86 + (j79 * 550336261) + (j105 >>> 28);
        long j107 = j105 & 268435455;
        long j108 = j87 + (j106 >>> 28);
        long j109 = j106 & 268435455;
        long j110 = j72 + (j63 * 550336261) + (j108 >>> 28);
        long j111 = j73 + (j110 >>> 28);
        long j112 = j56 + (j48 * 149865618) + (j64 * 550336261) + (j111 >>> 28);
        long j113 = j111 & 268435455;
        long j114 = j57 + (j48 * 550336261) + (j112 >>> 28);
        long j115 = (j58 & 268435455) + (j114 >>> 28);
        long j116 = j88 + (j115 >>> 28);
        long j117 = (j116 >>> 26) - 1;
        long j118 = (j90 & 268435455) - (j117 & 78101261);
        long j119 = ((j97 & 268435455) - (j117 & 141809365)) + (j118 >> 28);
        long j120 = ((j98 & 268435455) - (j117 & 175155932)) + (j119 >> 28);
        long j121 = ((j99 & 268435455) - (j117 & 64542499)) + (j120 >> 28);
        long j122 = j120 & 268435455;
        long j123 = (j102 - (j117 & 158326419)) + (j121 >> 28);
        long j124 = (j104 - (j117 & 191173276)) + (j123 >> 28);
        long j125 = j123 & 268435455;
        long j126 = ((j103 & 268435455) - (j117 & 104575268)) + (j124 >> 28);
        long j127 = j124 & 268435455;
        long j128 = (j107 - (j117 & 137584065)) + (j126 >> 28);
        long j129 = j109 + (j128 >> 28);
        long j130 = j128 & 268435455;
        long j131 = (j108 & 268435455) + (j129 >> 28);
        long j132 = (j110 & 268435455) + (j131 >> 28);
        long j133 = j113 + (j132 >> 28);
        long j134 = (j112 & 268435455) + (j133 >> 28);
        long j135 = (j114 & 268435455) + (j134 >> 28);
        long j136 = (j115 & 268435455) + (j135 >> 28);
        long j137 = (j116 & f44439a) + (j136 >> 28);
        byte[] bArr2 = new byte[57];
        s(((j119 & 268435455) << 28) | (j118 & 268435455), bArr2, 0);
        s(((j121 & 268435455) << 28) | j122, bArr2, 7);
        s(j125 | (j127 << 28), bArr2, 14);
        s((j126 & 268435455) | (j130 << 28), bArr2, 21);
        s((j129 & 268435455) | ((j131 & 268435455) << 28), bArr2, 28);
        s((j132 & 268435455) | ((j133 & 268435455) << 28), bArr2, 35);
        s((j134 & 268435455) | ((j135 & 268435455) << 28), bArr2, 42);
        s((j137 << 28) | (j136 & 268435455), bArr2, 49);
        return bArr2;
    }

    public static void S(byte[] bArr, d dVar, d dVar2) {
        int[] iArr = new int[14];
        o(bArr, 0, iArr);
        o.u0(14, iArr, 2, 0);
        o.t(14, (~iArr[0]) & 1, iArr, f44452n, iArr);
        o.q0(14, iArr, 1);
        int[] iArrM = M(dVar, 8);
        d dVar3 = new d();
        L(iArr, 111, iArrM, dVar2);
        for (int i10 = 110; i10 >= 0; i10--) {
            for (int i11 = 0; i11 < 4; i11++) {
                I(dVar2);
            }
            L(iArr, i10, iArrM, dVar3);
            D(dVar3, dVar2);
        }
        for (int i12 = 0; i12 < 2; i12++) {
            I(dVar2);
        }
    }

    public static void T(byte[] bArr, d dVar) {
        P();
        int[] iArr = new int[15];
        o(bArr, 0, iArr);
        iArr[14] = o.t(14, (~iArr[0]) & 1, iArr, f44452n, iArr) + 4;
        o.q0(15, iArr, 0);
        e eVar = new e();
        O(dVar);
        int i10 = 17;
        while (true) {
            int i11 = i10;
            for (int i12 = 0; i12 < 5; i12++) {
                int i13 = 0;
                for (int i14 = 0; i14 < 5; i14++) {
                    i13 = (i13 & (~(1 << i14))) ^ ((iArr[i11 >>> 5] >>> (i11 & 31)) << i14);
                    i11 += 18;
                }
                int i15 = (i13 >>> 4) & 1;
                K(i12, ((-i15) ^ i13) & 15, eVar);
                nr.d.h(i15, eVar.f44470a);
                E(eVar, dVar);
            }
            i10--;
            if (i10 < 0) {
                return;
            } else {
                I(dVar);
            }
        }
    }

    public static void U(byte[] bArr, byte[] bArr2, int i10) {
        d dVar = new d();
        T(bArr, dVar);
        if (t(dVar, bArr2, i10) == 0) {
            throw new IllegalStateException();
        }
    }

    public static void V(c.b bVar, byte[] bArr, int i10, int[] iArr, int[] iArr2) {
        Objects.requireNonNull(bVar, "This method is only for use by X448");
        byte[] bArr2 = new byte[57];
        Q(bArr, i10, bArr2);
        d dVar = new d();
        T(bArr2, dVar);
        if (d(dVar.f44467a, dVar.f44468b, dVar.f44469c) == 0) {
            throw new IllegalStateException();
        }
        nr.d.i(dVar.f44467a, 0, iArr, 0);
        nr.d.i(dVar.f44468b, 0, iArr2, 0);
    }

    public static void W(d dVar, d dVar2) {
        byte[] bArrX = x(f44452n, 5);
        d[] dVarArrN = N(dVar, 8);
        O(dVar2);
        int i10 = 446;
        while (true) {
            byte b10 = bArrX[i10];
            if (b10 != 0) {
                int i11 = b10 >> 31;
                F(i11 != 0, dVarArrN[(b10 ^ i11) >>> 1], dVar2);
            }
            i10--;
            if (i10 < 0) {
                return;
            } else {
                I(dVar2);
            }
        }
    }

    public static void X(int[] iArr, int[] iArr2, d dVar, d dVar2) {
        P();
        byte[] bArrX = x(iArr, 7);
        byte[] bArrX2 = x(iArr2, 5);
        d[] dVarArrN = N(dVar, 8);
        O(dVar2);
        int i10 = 446;
        while (true) {
            byte b10 = bArrX[i10];
            if (b10 != 0) {
                int i11 = b10 >> 31;
                F(i11 != 0, O[(b10 ^ i11) >>> 1], dVar2);
            }
            byte b11 = bArrX2[i10];
            if (b11 != 0) {
                int i12 = b11 >> 31;
                F(i12 != 0, dVarArrN[(b11 ^ i12) >>> 1], dVar2);
            }
            i10--;
            if (i10 < 0) {
                return;
            } else {
                I(dVar2);
            }
        }
    }

    public static void Y(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, byte[] bArr4, int i12, int i13, byte[] bArr5, int i14) {
        A(bArr, i10, bArr2, i11, bArr3, (byte) 0, bArr4, i12, i13, bArr5, i14);
    }

    public static void Z(byte[] bArr, int i10, byte[] bArr2, byte[] bArr3, int i11, int i12, byte[] bArr4, int i13) {
        z(bArr, i10, bArr2, (byte) 0, bArr3, i11, i12, bArr4, i13);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int[] iArr = new int[28];
        o(bArr, 0, iArr);
        int[] iArr2 = new int[14];
        o(bArr2, 0, iArr2);
        int[] iArr3 = new int[14];
        o(bArr3, 0, iArr3);
        o.l0(14, iArr2, iArr3, iArr);
        byte[] bArr4 = new byte[114];
        for (int i10 = 0; i10 < 28; i10++) {
            r(iArr[i10], bArr4, i10 * 4);
        }
        return R(bArr4);
    }

    public static void a0(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, m0 m0Var, byte[] bArr4, int i12) {
        byte[] bArr5 = new byte[64];
        if (64 != m0Var.f(bArr5, 0, 64)) {
            throw new IllegalArgumentException("ph");
        }
        A(bArr, i10, bArr2, i11, bArr3, (byte) 1, bArr5, 0, 64, bArr4, i12);
    }

    public static boolean b(byte[] bArr) {
        return bArr != null && bArr.length < 256;
    }

    public static void b0(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, byte[] bArr4, int i12, byte[] bArr5, int i13) {
        A(bArr, i10, bArr2, i11, bArr3, (byte) 1, bArr4, i12, 64, bArr5, i13);
    }

    public static int c(int[] iArr, int[] iArr2) {
        int[] iArrJ = nr.d.j();
        int[] iArrJ2 = nr.d.j();
        int[] iArrJ3 = nr.d.j();
        nr.d.M(iArr, iArrJ2);
        nr.d.M(iArr2, iArrJ3);
        nr.d.F(iArrJ2, iArrJ3, iArrJ);
        nr.d.a(iArrJ2, iArrJ3, iArrJ2);
        nr.d.E(iArrJ, 39081, iArrJ);
        nr.d.P(iArrJ);
        nr.d.a(iArrJ, iArrJ2, iArrJ);
        nr.d.H(iArrJ);
        return nr.d.C(iArrJ);
    }

    public static void c0(byte[] bArr, int i10, byte[] bArr2, m0 m0Var, byte[] bArr3, int i11) {
        byte[] bArr4 = new byte[64];
        if (64 != m0Var.f(bArr4, 0, 64)) {
            throw new IllegalArgumentException("ph");
        }
        z(bArr, i10, bArr2, (byte) 1, bArr4, 0, 64, bArr3, i11);
    }

    public static int d(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrJ = nr.d.j();
        int[] iArrJ2 = nr.d.j();
        int[] iArrJ3 = nr.d.j();
        int[] iArrJ4 = nr.d.j();
        nr.d.M(iArr, iArrJ2);
        nr.d.M(iArr2, iArrJ3);
        nr.d.M(iArr3, iArrJ4);
        nr.d.F(iArrJ2, iArrJ3, iArrJ);
        nr.d.a(iArrJ2, iArrJ3, iArrJ2);
        nr.d.F(iArrJ2, iArrJ4, iArrJ2);
        nr.d.M(iArrJ4, iArrJ4);
        nr.d.E(iArrJ, 39081, iArrJ);
        nr.d.O(iArrJ, iArrJ4, iArrJ);
        nr.d.a(iArrJ, iArrJ2, iArrJ);
        nr.d.H(iArrJ);
        return nr.d.C(iArrJ);
    }

    public static void d0(byte[] bArr, int i10, byte[] bArr2, byte[] bArr3, int i11, byte[] bArr4, int i12) {
        z(bArr, i10, bArr2, (byte) 1, bArr3, i11, 64, bArr4, i12);
    }

    public static boolean e(byte[] bArr) {
        if ((bArr[56] & 127) != 0) {
            return false;
        }
        m(bArr, 0, new int[14], 0, 14);
        return !o.X(14, r2, f44451m);
    }

    public static boolean e0(byte[] bArr, int i10) {
        d dVar = new d();
        if (!n(bArr, i10, false, dVar)) {
            return false;
        }
        nr.d.H(dVar.f44467a);
        nr.d.H(dVar.f44468b);
        nr.d.H(dVar.f44469c);
        if (C(dVar.f44467a, dVar.f44468b, dVar.f44469c)) {
            return false;
        }
        d dVar2 = new d();
        W(dVar, dVar2);
        nr.d.H(dVar2.f44467a);
        nr.d.H(dVar2.f44468b);
        nr.d.H(dVar2.f44469c);
        return C(dVar2.f44467a, dVar2.f44468b, dVar2.f44469c);
    }

    public static boolean f(byte[] bArr, int[] iArr) {
        if (bArr[56] != 0) {
            return false;
        }
        o(bArr, 0, iArr);
        return !o.X(14, iArr, f44452n);
    }

    public static boolean f0(byte[] bArr, int i10) {
        return n(bArr, i10, false, new d());
    }

    public static byte[] g(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        return bArr2;
    }

    public static boolean g0(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, byte[] bArr4, int i12, int i13) {
        return B(bArr, i10, bArr2, i11, bArr3, (byte) 0, bArr4, i12, i13);
    }

    public static m0 h() {
        return i();
    }

    public static boolean h0(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, m0 m0Var) {
        byte[] bArr4 = new byte[64];
        if (64 == m0Var.f(bArr4, 0, 64)) {
            return B(bArr, i10, bArr2, i11, bArr3, (byte) 1, bArr4, 0, 64);
        }
        throw new IllegalArgumentException("ph");
    }

    public static m0 i() {
        return new j0(256);
    }

    public static boolean i0(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, byte[] bArr4, int i12) {
        return B(bArr, i10, bArr2, i11, bArr3, (byte) 1, bArr4, i12, 64);
    }

    public static int j(byte[] bArr, int i10) {
        return ((bArr[i10 + 1] & 255) << 8) | (bArr[i10] & 255);
    }

    public static int k(byte[] bArr, int i10) {
        int i11 = bArr[i10] & 255;
        int i12 = i10 + 1;
        return ((bArr[i12 + 1] & 255) << 16) | i11 | ((bArr[i12] & 255) << 8);
    }

    public static int l(byte[] bArr, int i10) {
        int i11 = bArr[i10] & 255;
        int i12 = i10 + 1;
        int i13 = i11 | ((bArr[i12] & 255) << 8);
        int i14 = i12 + 1;
        return (bArr[i14 + 1] << 24) | i13 | ((bArr[i14] & 255) << 16);
    }

    public static void m(byte[] bArr, int i10, int[] iArr, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            iArr[i11 + i13] = l(bArr, (i13 * 4) + i10);
        }
    }

    public static boolean n(byte[] bArr, int i10, boolean z10, d dVar) {
        byte[] bArrG = g(bArr, i10, 57);
        if (!e(bArrG)) {
            return false;
        }
        int i11 = (bArrG[56] & 128) >>> 7;
        bArrG[56] = (byte) (bArrG[56] & 127);
        nr.d.m(bArrG, 0, dVar.f44468b);
        int[] iArrJ = nr.d.j();
        int[] iArrJ2 = nr.d.j();
        nr.d.M(dVar.f44468b, iArrJ);
        nr.d.E(iArrJ, 39081, iArrJ2);
        nr.d.G(iArrJ, iArrJ);
        nr.d.b(iArrJ);
        nr.d.b(iArrJ2);
        if (!nr.d.N(iArrJ, iArrJ2, dVar.f44467a)) {
            return false;
        }
        nr.d.H(dVar.f44467a);
        if (i11 == 1 && nr.d.D(dVar.f44467a)) {
            return false;
        }
        int[] iArr = dVar.f44467a;
        if (z10 ^ (i11 != (iArr[0] & 1))) {
            nr.d.G(iArr, iArr);
        }
        J(dVar);
        return true;
    }

    public static void o(byte[] bArr, int i10, int[] iArr) {
        m(bArr, i10, iArr, 0, 14);
    }

    public static void p(m0 m0Var, byte b10, byte[] bArr) {
        byte[] bArr2 = f44450l;
        int length = bArr2.length;
        int i10 = length + 2;
        int length2 = bArr.length + i10;
        byte[] bArr3 = new byte[length2];
        System.arraycopy(bArr2, 0, bArr3, 0, length);
        bArr3[length] = b10;
        bArr3[length + 1] = (byte) bArr.length;
        System.arraycopy(bArr, 0, bArr3, i10, bArr.length);
        m0Var.update(bArr3, 0, length2);
    }

    public static void q(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) i10;
        int i12 = i11 + 1;
        bArr[i12] = (byte) (i10 >>> 8);
        bArr[i12 + 1] = (byte) (i10 >>> 16);
    }

    public static void r(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) i10;
        int i12 = i11 + 1;
        bArr[i12] = (byte) (i10 >>> 8);
        int i13 = i12 + 1;
        bArr[i13] = (byte) (i10 >>> 16);
        bArr[i13 + 1] = (byte) (i10 >>> 24);
    }

    public static void s(long j10, byte[] bArr, int i10) {
        r((int) j10, bArr, i10);
        q((int) (j10 >>> 32), bArr, i10 + 4);
    }

    public static int t(d dVar, byte[] bArr, int i10) {
        int[] iArrJ = nr.d.j();
        int[] iArrJ2 = nr.d.j();
        nr.d.y(dVar.f44469c, iArrJ2);
        nr.d.F(dVar.f44467a, iArrJ2, iArrJ);
        nr.d.F(dVar.f44468b, iArrJ2, iArrJ2);
        nr.d.H(iArrJ);
        nr.d.H(iArrJ2);
        int iC = c(iArrJ, iArrJ2);
        nr.d.s(iArrJ2, bArr, i10);
        bArr[(i10 + 57) - 1] = (byte) ((iArrJ[0] & 1) << 7);
        return iC;
    }

    public static void u(SecureRandom secureRandom, byte[] bArr) {
        secureRandom.nextBytes(bArr);
    }

    public static void v(byte[] bArr, int i10, byte[] bArr2, int i11) {
        m0 m0VarI = i();
        byte[] bArr3 = new byte[114];
        m0VarI.update(bArr, i10, 57);
        m0VarI.f(bArr3, 0, 114);
        byte[] bArr4 = new byte[57];
        Q(bArr3, 0, bArr4);
        U(bArr4, bArr2, i11);
    }

    public static int w(int[] iArr, int i10) {
        return (iArr[i10 >>> 3] >>> ((i10 & 7) << 2)) & 15;
    }

    public static byte[] x(int[] iArr, int i10) {
        int[] iArr2 = new int[28];
        int i11 = 0;
        int i12 = 14;
        int i13 = 28;
        int i14 = 0;
        while (true) {
            i12--;
            if (i12 < 0) {
                break;
            }
            int i15 = iArr[i12];
            int i16 = i13 - 1;
            iArr2[i16] = (i14 << 16) | (i15 >>> 16);
            i13 = i16 - 1;
            iArr2[i13] = i15;
            i14 = i15;
        }
        byte[] bArr = new byte[447];
        int i17 = 32 - i10;
        int i18 = 0;
        int i19 = 0;
        while (i11 < 28) {
            int i20 = iArr2[i11];
            while (i18 < 16) {
                int i21 = i20 >>> i18;
                if ((i21 & 1) == i19) {
                    i18++;
                } else {
                    int i22 = (i21 | 1) << i17;
                    bArr[(i11 << 4) + i18] = (byte) (i22 >> i17);
                    i18 += i10;
                    i19 = i22 >>> 31;
                }
            }
            i11++;
            i18 -= 16;
        }
        return bArr;
    }

    public static void y(m0 m0Var, byte[] bArr, byte[] bArr2, byte[] bArr3, int i10, byte[] bArr4, byte b10, byte[] bArr5, int i11, int i12, byte[] bArr6, int i13) {
        p(m0Var, b10, bArr4);
        m0Var.update(bArr, 57, 57);
        m0Var.update(bArr5, i11, i12);
        m0Var.f(bArr, 0, bArr.length);
        byte[] bArrR = R(bArr);
        byte[] bArr7 = new byte[57];
        U(bArrR, bArr7, 0);
        p(m0Var, b10, bArr4);
        m0Var.update(bArr7, 0, 57);
        m0Var.update(bArr3, i10, 57);
        m0Var.update(bArr5, i11, i12);
        m0Var.f(bArr, 0, bArr.length);
        byte[] bArrA = a(bArrR, R(bArr), bArr2);
        System.arraycopy(bArr7, 0, bArr6, i13, 57);
        System.arraycopy(bArrA, 0, bArr6, i13 + 57, 57);
    }

    public static void z(byte[] bArr, int i10, byte[] bArr2, byte b10, byte[] bArr3, int i11, int i12, byte[] bArr4, int i13) {
        if (!b(bArr2)) {
            throw new IllegalArgumentException("ctx");
        }
        m0 m0VarI = i();
        byte[] bArr5 = new byte[114];
        m0VarI.update(bArr, i10, 57);
        m0VarI.f(bArr5, 0, 114);
        byte[] bArr6 = new byte[57];
        Q(bArr5, 0, bArr6);
        byte[] bArr7 = new byte[57];
        U(bArr6, bArr7, 0);
        y(m0VarI, bArr5, bArr6, bArr7, 0, bArr2, b10, bArr3, i11, i12, bArr4, i13);
    }
}
