package or;

import com.blankj.utilcode.util.ThreadUtils;
import java.security.SecureRandom;
import java.util.Objects;
import nr.a;
import org.bouncycastle.crypto.s;
import rr.i;
import rr.o;
import zo.h0;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a {
    public static final int A = 4;
    public static final int B = 8;
    public static final int C = 8;
    public static final int D = 7;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f44396a = 255;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f44397b = 268435455;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f44398c = 4294967295L;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f44399d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f44400e = 32;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f44401f = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f44402g = 32;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f44403h = 64;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f44404i = 32;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f44405j = 32;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f44406k = 64;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f44410o = -50998291;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f44411p = 19280294;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f44412q = 127719000;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f44413r = -6428113;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f44414s = 5343;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f44420y = 7;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f44421z = 8;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final byte[] f44407l = {83, 105, 103, 69, 100, 50, 53, 53, 49, 57, 32, pq.b.f46992i, pq.b.f46991h, 32, 69, 100, 50, 53, 53, 49, 57, 32, 99, pq.b.f46991h, 108, 108, 105, 115, 105, pq.b.f46991h, pq.b.f46992i, 115};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int[] f44408m = {-19, -1, -1, -1, -1, -1, -1, Integer.MAX_VALUE};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f44409n = {1559614445, 1477600026, -1560830762, 350157278, 0, 0, 0, 268435456};

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int[] f44415t = {52811034, 25909283, 8072341, 50637101, 13785486, 30858332, 20483199, 20966410, 43936626, 4379245};

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int[] f44416u = {40265304, 26843545, 6710886, 53687091, 13421772, 40265318, 26843545, 6710886, 53687091, 13421772};

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int[] f44417v = {56195235, 47411844, 25868126, 40503822, 57364, 58321048, 30416477, 31930572, 57760639, 10749657};

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int[] f44418w = {45281625, 27714825, 18181821, 13898781, 114729, 49533232, 60832955, 30306712, 48412415, 4722099};

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int[] f44419x = {23454386, 55429651, 2809210, 27797563, 229458, 31957600, 54557047, 27058993, 29715967, 9444199};
    public static final Object E = new Object();
    public static f[] F = null;
    public static int[] G = null;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f44422a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f44423b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f44424c = 2;
    }

    public static class c extends nr.b {
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f44425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int[] f44426b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int[] f44427c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int[] f44428d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int[] f44429e;

        public d() {
            this.f44425a = nr.b.k();
            this.f44426b = nr.b.k();
            this.f44427c = nr.b.k();
            this.f44428d = nr.b.k();
            this.f44429e = nr.b.k();
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f44430a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int[] f44431b;

        public e() {
            this.f44430a = nr.b.k();
            this.f44431b = nr.b.k();
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f44432a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int[] f44433b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int[] f44434c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int[] f44435d;

        public f() {
            this.f44432a = nr.b.k();
            this.f44433b = nr.b.k();
            this.f44434c = nr.b.k();
            this.f44435d = nr.b.k();
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f44436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int[] f44437b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int[] f44438c;

        public g() {
            this.f44436a = nr.b.k();
            this.f44437b = nr.b.k();
            this.f44438c = nr.b.k();
        }
    }

    public static boolean A(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, byte b10, byte[] bArr4, int i12, int i13) {
        if (!b(bArr3, b10)) {
            throw new IllegalArgumentException("ctx");
        }
        byte[] bArrG = g(bArr, i10, 32);
        byte[] bArrG2 = g(bArr, i10 + 32, 32);
        if (!e(bArrG)) {
            return false;
        }
        int[] iArr = new int[8];
        if (!f(bArrG2, iArr)) {
            return false;
        }
        e eVar = new e();
        if (!m(bArr2, i11, true, eVar)) {
            return false;
        }
        s sVarH = h();
        byte[] bArr5 = new byte[sVarH.h()];
        o(sVarH, b10, bArr3);
        sVarH.update(bArrG, 0, 32);
        sVarH.update(bArr2, i11, 32);
        sVarH.update(bArr4, i12, i13);
        sVarH.c(bArr5, 0);
        int[] iArr2 = new int[8];
        n(Z(bArr5), 0, iArr2);
        d dVar = new d();
        f0(iArr, iArr2, eVar, dVar);
        byte[] bArr6 = new byte[32];
        return s(dVar, bArr6, 0) != 0 && org.bouncycastle.util.a.g(bArr6, bArrG);
    }

    public static boolean B(int[] iArr, int[] iArr2) {
        return nr.b.C(iArr) && nr.b.A(iArr2);
    }

    public static boolean C(int[] iArr, int[] iArr2, int[] iArr3) {
        return nr.b.C(iArr) && nr.b.f(iArr2, iArr3);
    }

    public static void D(f fVar, d dVar) {
        int[] iArrK = nr.b.k();
        int[] iArrK2 = nr.b.k();
        int[] iArrK3 = nr.b.k();
        int[] iArrK4 = nr.b.k();
        int[] iArr = dVar.f44428d;
        int[] iArrK5 = nr.b.k();
        int[] iArrK6 = nr.b.k();
        int[] iArr2 = dVar.f44429e;
        nr.b.d(dVar.f44426b, dVar.f44425a, iArrK2, iArrK);
        nr.b.d(fVar.f44433b, fVar.f44432a, iArrK4, iArrK3);
        nr.b.E(iArrK, iArrK3, iArrK);
        nr.b.E(iArrK2, iArrK4, iArrK2);
        nr.b.E(dVar.f44428d, dVar.f44429e, iArrK3);
        nr.b.E(iArrK3, fVar.f44435d, iArrK3);
        nr.b.E(iArrK3, f44418w, iArrK3);
        nr.b.E(dVar.f44427c, fVar.f44434c, iArrK4);
        nr.b.a(iArrK4, iArrK4, iArrK4);
        nr.b.d(iArrK2, iArrK, iArr2, iArr);
        nr.b.d(iArrK4, iArrK3, iArrK6, iArrK5);
        nr.b.g(iArrK6);
        nr.b.E(iArr, iArrK5, dVar.f44425a);
        nr.b.E(iArrK6, iArr2, dVar.f44426b);
        nr.b.E(iArrK5, iArrK6, dVar.f44427c);
    }

    public static void E(f fVar, f fVar2) {
        int[] iArrK = nr.b.k();
        int[] iArrK2 = nr.b.k();
        int[] iArrK3 = nr.b.k();
        int[] iArrK4 = nr.b.k();
        int[] iArrK5 = nr.b.k();
        int[] iArrK6 = nr.b.k();
        int[] iArrK7 = nr.b.k();
        int[] iArrK8 = nr.b.k();
        nr.b.d(fVar.f44433b, fVar.f44432a, iArrK2, iArrK);
        nr.b.d(fVar2.f44433b, fVar2.f44432a, iArrK4, iArrK3);
        nr.b.E(iArrK, iArrK3, iArrK);
        nr.b.E(iArrK2, iArrK4, iArrK2);
        nr.b.E(fVar.f44435d, fVar2.f44435d, iArrK3);
        nr.b.E(iArrK3, f44418w, iArrK3);
        nr.b.E(fVar.f44434c, fVar2.f44434c, iArrK4);
        nr.b.a(iArrK4, iArrK4, iArrK4);
        nr.b.d(iArrK2, iArrK, iArrK8, iArrK5);
        nr.b.d(iArrK4, iArrK3, iArrK7, iArrK6);
        nr.b.g(iArrK7);
        nr.b.E(iArrK5, iArrK6, fVar2.f44432a);
        nr.b.E(iArrK7, iArrK8, fVar2.f44433b);
        nr.b.E(iArrK6, iArrK7, fVar2.f44434c);
        nr.b.E(iArrK5, iArrK8, fVar2.f44435d);
    }

    public static void F(g gVar, d dVar) {
        int[] iArrK = nr.b.k();
        int[] iArrK2 = nr.b.k();
        int[] iArrK3 = nr.b.k();
        int[] iArr = dVar.f44428d;
        int[] iArrK4 = nr.b.k();
        int[] iArrK5 = nr.b.k();
        int[] iArr2 = dVar.f44429e;
        nr.b.d(dVar.f44426b, dVar.f44425a, iArrK2, iArrK);
        nr.b.E(iArrK, gVar.f44437b, iArrK);
        nr.b.E(iArrK2, gVar.f44436a, iArrK2);
        nr.b.E(dVar.f44428d, dVar.f44429e, iArrK3);
        nr.b.E(iArrK3, gVar.f44438c, iArrK3);
        nr.b.d(iArrK2, iArrK, iArr2, iArr);
        nr.b.d(dVar.f44427c, iArrK3, iArrK5, iArrK4);
        nr.b.g(iArrK5);
        nr.b.E(iArr, iArrK4, dVar.f44425a);
        nr.b.E(iArrK5, iArr2, dVar.f44426b);
        nr.b.E(iArrK4, iArrK5, dVar.f44427c);
    }

    public static void G(boolean z10, f fVar, d dVar) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] iArrK = nr.b.k();
        int[] iArrK2 = nr.b.k();
        int[] iArrK3 = nr.b.k();
        int[] iArrK4 = nr.b.k();
        int[] iArr5 = dVar.f44428d;
        int[] iArrK5 = nr.b.k();
        int[] iArrK6 = nr.b.k();
        int[] iArr6 = dVar.f44429e;
        if (z10) {
            iArr2 = iArrK3;
            iArr = iArrK4;
            iArr4 = iArrK5;
            iArr3 = iArrK6;
        } else {
            iArr = iArrK3;
            iArr2 = iArrK4;
            iArr3 = iArrK5;
            iArr4 = iArrK6;
        }
        nr.b.d(dVar.f44426b, dVar.f44425a, iArrK2, iArrK);
        nr.b.d(fVar.f44433b, fVar.f44432a, iArr2, iArr);
        nr.b.E(iArrK, iArrK3, iArrK);
        nr.b.E(iArrK2, iArrK4, iArrK2);
        nr.b.E(dVar.f44428d, dVar.f44429e, iArrK3);
        nr.b.E(iArrK3, fVar.f44435d, iArrK3);
        nr.b.E(iArrK3, f44418w, iArrK3);
        nr.b.E(dVar.f44427c, fVar.f44434c, iArrK4);
        nr.b.a(iArrK4, iArrK4, iArrK4);
        nr.b.d(iArrK2, iArrK, iArr6, iArr5);
        nr.b.d(iArrK4, iArrK3, iArr4, iArr3);
        nr.b.g(iArr4);
        nr.b.E(iArr5, iArrK5, dVar.f44425a);
        nr.b.E(iArrK6, iArr6, dVar.f44426b);
        nr.b.E(iArrK5, iArrK6, dVar.f44427c);
    }

    public static void H(boolean z10, f fVar, f fVar2, f fVar3) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] iArrK = nr.b.k();
        int[] iArrK2 = nr.b.k();
        int[] iArrK3 = nr.b.k();
        int[] iArrK4 = nr.b.k();
        int[] iArrK5 = nr.b.k();
        int[] iArrK6 = nr.b.k();
        int[] iArrK7 = nr.b.k();
        int[] iArrK8 = nr.b.k();
        if (z10) {
            iArr2 = iArrK3;
            iArr = iArrK4;
            iArr4 = iArrK6;
            iArr3 = iArrK7;
        } else {
            iArr = iArrK3;
            iArr2 = iArrK4;
            iArr3 = iArrK6;
            iArr4 = iArrK7;
        }
        nr.b.d(fVar.f44433b, fVar.f44432a, iArrK2, iArrK);
        nr.b.d(fVar2.f44433b, fVar2.f44432a, iArr2, iArr);
        nr.b.E(iArrK, iArrK3, iArrK);
        nr.b.E(iArrK2, iArrK4, iArrK2);
        nr.b.E(fVar.f44435d, fVar2.f44435d, iArrK3);
        nr.b.E(iArrK3, f44418w, iArrK3);
        nr.b.E(fVar.f44434c, fVar2.f44434c, iArrK4);
        nr.b.a(iArrK4, iArrK4, iArrK4);
        nr.b.d(iArrK2, iArrK, iArrK8, iArrK5);
        nr.b.d(iArrK4, iArrK3, iArr4, iArr3);
        nr.b.g(iArr4);
        nr.b.E(iArrK5, iArrK6, fVar3.f44432a);
        nr.b.E(iArrK7, iArrK8, fVar3.f44433b);
        nr.b.E(iArrK6, iArrK7, fVar3.f44434c);
        nr.b.E(iArrK5, iArrK8, fVar3.f44435d);
    }

    public static f I(d dVar) {
        f fVar = new f();
        nr.b.j(dVar.f44425a, 0, fVar.f44432a, 0);
        nr.b.j(dVar.f44426b, 0, fVar.f44433b, 0);
        nr.b.j(dVar.f44427c, 0, fVar.f44434c, 0);
        nr.b.E(dVar.f44428d, dVar.f44429e, fVar.f44435d);
        return fVar;
    }

    public static f J(e eVar) {
        f fVar = new f();
        nr.b.j(eVar.f44430a, 0, fVar.f44432a, 0);
        nr.b.j(eVar.f44431b, 0, fVar.f44433b, 0);
        P(fVar);
        return fVar;
    }

    public static f K(f fVar) {
        f fVar2 = new f();
        M(fVar, fVar2);
        return fVar2;
    }

    public static void L(e eVar, d dVar) {
        nr.b.j(eVar.f44430a, 0, dVar.f44425a, 0);
        nr.b.j(eVar.f44431b, 0, dVar.f44426b, 0);
        O(dVar);
    }

    public static void M(f fVar, f fVar2) {
        nr.b.j(fVar.f44432a, 0, fVar2.f44432a, 0);
        nr.b.j(fVar.f44433b, 0, fVar2.f44433b, 0);
        nr.b.j(fVar.f44434c, 0, fVar2.f44434c, 0);
        nr.b.j(fVar.f44435d, 0, fVar2.f44435d, 0);
    }

    public static void N(d dVar) {
        int[] iArrK = nr.b.k();
        int[] iArrK2 = nr.b.k();
        int[] iArrK3 = nr.b.k();
        int[] iArr = dVar.f44428d;
        int[] iArrK4 = nr.b.k();
        int[] iArrK5 = nr.b.k();
        int[] iArr2 = dVar.f44429e;
        nr.b.L(dVar.f44425a, iArrK);
        nr.b.L(dVar.f44426b, iArrK2);
        nr.b.L(dVar.f44427c, iArrK3);
        nr.b.a(iArrK3, iArrK3, iArrK3);
        nr.b.d(iArrK, iArrK2, iArr2, iArrK5);
        nr.b.a(dVar.f44425a, dVar.f44426b, iArr);
        nr.b.L(iArr, iArr);
        nr.b.N(iArr2, iArr, iArr);
        nr.b.a(iArrK3, iArrK5, iArrK4);
        nr.b.g(iArrK4);
        nr.b.E(iArr, iArrK4, dVar.f44425a);
        nr.b.E(iArrK5, iArr2, dVar.f44426b);
        nr.b.E(iArrK4, iArrK5, dVar.f44427c);
    }

    public static void O(d dVar) {
        nr.b.H(dVar.f44427c);
        nr.b.j(dVar.f44425a, 0, dVar.f44428d, 0);
        nr.b.j(dVar.f44426b, 0, dVar.f44429e, 0);
    }

    public static void P(f fVar) {
        nr.b.H(fVar.f44434c);
        nr.b.E(fVar.f44432a, fVar.f44433b, fVar.f44435d);
    }

    public static void Q(int i10, int i11, g gVar) {
        int i12 = i10 * 8 * 3 * 10;
        for (int i13 = 0; i13 < 8; i13++) {
            int i14 = ((i13 ^ i11) - 1) >> 31;
            nr.b.h(i14, G, i12, gVar.f44436a, 0);
            int i15 = i12 + 10;
            nr.b.h(i14, G, i15, gVar.f44437b, 0);
            int i16 = i15 + 10;
            nr.b.h(i14, G, i16, gVar.f44438c, 0);
            i12 = i16 + 10;
        }
    }

    public static void R(int[] iArr, int i10, f fVar) {
        int i11 = i10 * 40;
        nr.b.j(iArr, i11, fVar.f44432a, 0);
        int i12 = i11 + 10;
        nr.b.j(iArr, i12, fVar.f44433b, 0);
        int i13 = i12 + 10;
        nr.b.j(iArr, i13, fVar.f44434c, 0);
        nr.b.j(iArr, i13 + 10, fVar.f44435d, 0);
    }

    public static void S(int[] iArr, int i10, int[] iArr2, f fVar) {
        int iV = v(iArr, i10);
        int i11 = (iV >>> 3) ^ 1;
        int i12 = (iV ^ (-i11)) & 7;
        int i13 = 0;
        for (int i14 = 0; i14 < 8; i14++) {
            int i15 = ((i14 ^ i12) - 1) >> 31;
            nr.b.h(i15, iArr2, i13, fVar.f44432a, 0);
            int i16 = i13 + 10;
            nr.b.h(i15, iArr2, i16, fVar.f44433b, 0);
            int i17 = i16 + 10;
            nr.b.h(i15, iArr2, i17, fVar.f44434c, 0);
            int i18 = i17 + 10;
            nr.b.h(i15, iArr2, i18, fVar.f44435d, 0);
            i13 = i18 + 10;
        }
        nr.b.i(i11, fVar.f44432a);
        nr.b.i(i11, fVar.f44435d);
    }

    public static int[] T(e eVar, int i10) {
        f fVarJ = J(eVar);
        f fVarK = K(fVarJ);
        E(fVarJ, fVarK);
        int[] iArrL = nr.b.l(i10 * 4);
        int i11 = 0;
        int i12 = 0;
        while (true) {
            nr.b.j(fVarJ.f44432a, 0, iArrL, i11);
            int i13 = i11 + 10;
            nr.b.j(fVarJ.f44433b, 0, iArrL, i13);
            int i14 = i13 + 10;
            nr.b.j(fVarJ.f44434c, 0, iArrL, i14);
            int i15 = i14 + 10;
            nr.b.j(fVarJ.f44435d, 0, iArrL, i15);
            i11 = i15 + 10;
            i12++;
            if (i12 == i10) {
                return iArrL;
            }
            E(fVarK, fVarJ);
        }
    }

    public static f[] U(f fVar, int i10) {
        f fVar2 = new f();
        H(false, fVar, fVar, fVar2);
        f[] fVarArr = new f[i10];
        fVarArr[0] = K(fVar);
        for (int i11 = 1; i11 < i10; i11++) {
            f fVar3 = fVarArr[i11 - 1];
            f fVar4 = new f();
            fVarArr[i11] = fVar4;
            H(false, fVar3, fVar2, fVar4);
        }
        return fVarArr;
    }

    public static void V(d dVar) {
        nr.b.P(dVar.f44425a);
        nr.b.H(dVar.f44426b);
        nr.b.H(dVar.f44427c);
        nr.b.P(dVar.f44428d);
        nr.b.H(dVar.f44429e);
    }

    public static void W(f fVar) {
        nr.b.P(fVar.f44432a);
        nr.b.H(fVar.f44433b);
        nr.b.H(fVar.f44434c);
        nr.b.P(fVar.f44435d);
    }

    public static void X() {
        int i10;
        synchronized (E) {
            if (G != null) {
                return;
            }
            f fVar = new f();
            int[] iArr = f44415t;
            nr.b.j(iArr, 0, fVar.f44432a, 0);
            int[] iArr2 = f44416u;
            nr.b.j(iArr2, 0, fVar.f44433b, 0);
            P(fVar);
            F = U(fVar, 32);
            d dVar = new d();
            nr.b.j(iArr, 0, dVar.f44425a, 0);
            nr.b.j(iArr2, 0, dVar.f44426b, 0);
            O(dVar);
            G = nr.b.l(192);
            int i11 = 0;
            for (int i12 = 0; i12 < 8; i12++) {
                f[] fVarArr = new f[4];
                f fVar2 = new f();
                W(fVar2);
                int i13 = 0;
                while (true) {
                    i10 = 1;
                    if (i13 >= 4) {
                        break;
                    }
                    H(true, fVar2, I(dVar), fVar2);
                    N(dVar);
                    fVarArr[i13] = I(dVar);
                    if (i12 + i13 != 10) {
                        while (i10 < 8) {
                            N(dVar);
                            i10++;
                        }
                    }
                    i13++;
                }
                f[] fVarArr2 = new f[8];
                fVarArr2[0] = fVar2;
                int i14 = 0;
                int i15 = 1;
                while (i14 < 3) {
                    int i16 = i10 << i14;
                    int i17 = 0;
                    while (i17 < i16) {
                        f fVar3 = fVarArr2[i15 - i16];
                        f fVar4 = fVarArr[i14];
                        f fVar5 = new f();
                        fVarArr2[i15] = fVar5;
                        H(false, fVar3, fVar4, fVar5);
                        i17++;
                        i15++;
                    }
                    i14++;
                    i10 = 1;
                }
                int[] iArrL = nr.b.l(8);
                int[] iArrK = nr.b.k();
                nr.b.j(fVarArr2[0].f44434c, 0, iArrK, 0);
                nr.b.j(iArrK, 0, iArrL, 0);
                int i18 = 0;
                while (true) {
                    i18++;
                    if (i18 >= 8) {
                        break;
                    }
                    nr.b.E(iArrK, fVarArr2[i18].f44434c, iArrK);
                    nr.b.j(iArrK, 0, iArrL, i18 * 10);
                }
                nr.b.a(iArrK, iArrK, iArrK);
                nr.b.y(iArrK, iArrK);
                int i19 = i18 - 1;
                int[] iArrK2 = nr.b.k();
                while (i19 > 0) {
                    int i20 = i19 - 1;
                    nr.b.j(iArrL, i20 * 10, iArrK2, 0);
                    nr.b.E(iArrK2, iArrK, iArrK2);
                    nr.b.j(iArrK2, 0, iArrL, i19 * 10);
                    nr.b.E(iArrK, fVarArr2[i19].f44434c, iArrK);
                    i19 = i20;
                }
                nr.b.j(iArrK, 0, iArrL, 0);
                for (int i21 = 0; i21 < 8; i21++) {
                    f fVar6 = fVarArr2[i21];
                    int[] iArrK3 = nr.b.k();
                    int[] iArrK4 = nr.b.k();
                    nr.b.j(iArrL, i21 * 10, iArrK4, 0);
                    nr.b.E(fVar6.f44432a, iArrK4, iArrK3);
                    nr.b.E(fVar6.f44433b, iArrK4, iArrK4);
                    g gVar = new g();
                    nr.b.d(iArrK4, iArrK3, gVar.f44436a, gVar.f44437b);
                    nr.b.E(iArrK3, iArrK4, gVar.f44438c);
                    int[] iArr3 = gVar.f44438c;
                    nr.b.E(iArr3, f44419x, iArr3);
                    nr.b.G(gVar.f44436a);
                    nr.b.G(gVar.f44437b);
                    nr.b.j(gVar.f44436a, 0, G, i11);
                    int i22 = i11 + 10;
                    nr.b.j(gVar.f44437b, 0, G, i22);
                    int i23 = i22 + 10;
                    nr.b.j(gVar.f44438c, 0, G, i23);
                    i11 = i23 + 10;
                }
            }
        }
    }

    public static void Y(byte[] bArr, int i10, byte[] bArr2) {
        System.arraycopy(bArr, i10, bArr2, 0, 32);
        bArr2[0] = (byte) (bArr2[0] & ThreadUtils.f11619i);
        bArr2[31] = (byte) (bArr2[31] & 127);
        bArr2[31] = (byte) (bArr2[31] | 64);
    }

    public static byte[] Z(byte[] bArr) {
        long jK = ((long) k(bArr, 0)) & 4294967295L;
        long j10 = ((long) (j(bArr, 4) << 4)) & 4294967295L;
        long jK2 = ((long) k(bArr, 7)) & 4294967295L;
        long j11 = ((long) (j(bArr, 11) << 4)) & 4294967295L;
        long jK3 = ((long) k(bArr, 14)) & 4294967295L;
        long j12 = ((long) (j(bArr, 18) << 4)) & 4294967295L;
        long jK4 = ((long) k(bArr, 21)) & 4294967295L;
        long j13 = ((long) (j(bArr, 25) << 4)) & 4294967295L;
        long jK5 = ((long) k(bArr, 28)) & 4294967295L;
        long j14 = ((long) (j(bArr, 32) << 4)) & 4294967295L;
        long jK6 = ((long) k(bArr, 35)) & 4294967295L;
        long j15 = ((long) (j(bArr, 39) << 4)) & 4294967295L;
        long jK7 = ((long) k(bArr, 42)) & 4294967295L;
        long j16 = ((long) (j(bArr, 46) << 4)) & 4294967295L;
        long jK8 = ((long) k(bArr, 49)) & 4294967295L;
        long j17 = ((long) (j(bArr, 53) << 4)) & 4294967295L;
        long jK9 = ((long) k(bArr, 56)) & 4294967295L;
        long j18 = ((long) (j(bArr, 60) << 4)) & 4294967295L;
        long j19 = ((long) bArr[63]) & 255;
        long j20 = j18 + (jK9 >> 28);
        long j21 = jK9 & 268435455;
        long j22 = jK5 - (j20 * (-50998291));
        long j23 = (j14 - (j19 * (-50998291))) - (j20 * 19280294);
        long j24 = (jK6 - (j19 * 19280294)) - (j20 * 127719000);
        long j25 = (j15 - (j19 * 127719000)) - (j20 * (-6428113));
        long j26 = (jK7 - (j19 * (-6428113))) - (j20 * 5343);
        long j27 = j25 - (j21 * 5343);
        long j28 = j17 + (jK8 >> 28);
        long j29 = jK8 & 268435455;
        long j30 = (j24 - (j21 * (-6428113))) - (j28 * 5343);
        long j31 = ((j13 - (j21 * (-50998291))) - (j28 * 19280294)) - (j29 * 127719000);
        long j32 = ((j23 - (j21 * 127719000)) - (j28 * (-6428113))) - (j29 * 5343);
        long j33 = (j16 - (j19 * 5343)) + (j26 >> 28);
        long j34 = (j26 & 268435455) + (j27 >> 28);
        long j35 = j11 - (j34 * (-50998291));
        long j36 = (jK3 - (j33 * (-50998291))) - (j34 * 19280294);
        long j37 = ((j12 - (j29 * (-50998291))) - (j33 * 19280294)) - (j34 * 127719000);
        long j38 = (((jK4 - (j28 * (-50998291))) - (j29 * 19280294)) - (j33 * 127719000)) - (j34 * (-6428113));
        long j39 = (j31 - (j33 * (-6428113))) - (j34 * 5343);
        long j40 = (j27 & 268435455) + (j30 >> 28);
        long j41 = j30 & 268435455;
        long j42 = jK2 - (j40 * (-50998291));
        long j43 = j35 - (j40 * 19280294);
        long j44 = j36 - (j40 * 127719000);
        long j45 = j37 - (j40 * (-6428113));
        long j46 = j38 - (j40 * 5343);
        long j47 = j41 + (j32 >> 28);
        long j48 = j32 & 268435455;
        long j49 = j10 - (j47 * (-50998291));
        long j50 = j42 - (j47 * 19280294);
        long j51 = j43 - (j47 * 127719000);
        long j52 = j44 - (j47 * (-6428113));
        long j53 = j45 - (j47 * 5343);
        long j54 = ((((j22 - (j21 * 19280294)) - (j28 * 127719000)) - (j29 * (-6428113))) - (j33 * 5343)) + (j39 >> 28);
        long j55 = j54 & 268435455;
        long j56 = j55 >>> 27;
        long j57 = j48 + (j54 >> 28) + j56;
        long j58 = jK - (j57 * (-50998291));
        long j59 = (j49 - (j57 * 19280294)) + (j58 >> 28);
        long j60 = j58 & 268435455;
        long j61 = (j50 - (j57 * 127719000)) + (j59 >> 28);
        long j62 = (j51 - (j57 * (-6428113))) + (j61 >> 28);
        long j63 = (j52 - (j57 * 5343)) + (j62 >> 28);
        long j64 = j53 + (j63 >> 28);
        long j65 = j63 & 268435455;
        long j66 = j46 + (j64 >> 28);
        long j67 = (j39 & 268435455) + (j66 >> 28);
        long j68 = j55 + (j67 >> 28);
        long j69 = (j68 >> 28) - j56;
        long j70 = j60 + (j69 & (-50998291));
        long j71 = (j59 & 268435455) + (j69 & 19280294) + (j70 >> 28);
        long j72 = (j61 & 268435455) + (j69 & 127719000) + (j71 >> 28);
        long j73 = (j62 & 268435455) + (j69 & (-6428113)) + (j72 >> 28);
        long j74 = j65 + (j69 & 5343) + (j73 >> 28);
        long j75 = (j64 & 268435455) + (j74 >> 28);
        long j76 = (j66 & 268435455) + (j75 >> 28);
        long j77 = (j67 & 268435455) + (j76 >> 28);
        byte[] bArr2 = new byte[32];
        r((j70 & 268435455) | ((j71 & 268435455) << 28), bArr2, 0);
        r(((j73 & 268435455) << 28) | (j72 & 268435455), bArr2, 7);
        r((j74 & 268435455) | ((j75 & 268435455) << 28), bArr2, 14);
        r((j76 & 268435455) | ((j77 & 268435455) << 28), bArr2, 21);
        q((int) ((j68 & 268435455) + (j77 >> 28)), bArr2, 28);
        return bArr2;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int[] iArr = new int[16];
        n(bArr, 0, iArr);
        int[] iArr2 = new int[8];
        n(bArr2, 0, iArr2);
        int[] iArr3 = new int[8];
        n(bArr3, 0, iArr3);
        i.H(iArr2, iArr3, iArr);
        byte[] bArr4 = new byte[64];
        for (int i10 = 0; i10 < 16; i10++) {
            q(iArr[i10], bArr4, i10 * 4);
        }
        return Z(bArr4);
    }

    public static void a0(byte[] bArr, e eVar, d dVar) {
        int[] iArr = new int[8];
        n(bArr, 0, iArr);
        o.u0(8, iArr, 3, 1);
        o.t(8, (~iArr[0]) & 1, iArr, f44409n, iArr);
        o.q0(8, iArr, 0);
        int[] iArrT = T(eVar, 8);
        f fVar = new f();
        L(eVar, dVar);
        R(iArrT, 7, fVar);
        D(fVar, dVar);
        int i10 = 62;
        while (true) {
            S(iArr, i10, iArrT, fVar);
            D(fVar, dVar);
            N(dVar);
            N(dVar);
            N(dVar);
            i10--;
            if (i10 < 0) {
                return;
            } else {
                N(dVar);
            }
        }
    }

    public static boolean b(byte[] bArr, byte b10) {
        return (bArr == null && b10 == 0) || (bArr != null && bArr.length < 256);
    }

    public static void b0(byte[] bArr, d dVar) {
        X();
        int[] iArr = new int[8];
        n(bArr, 0, iArr);
        o.t(8, (~iArr[0]) & 1, iArr, f44409n, iArr);
        o.q0(8, iArr, 1);
        for (int i10 = 0; i10 < 8; i10++) {
            iArr[i10] = rr.b.i(iArr[i10]);
        }
        g gVar = new g();
        V(dVar);
        int i11 = 28;
        while (true) {
            for (int i12 = 0; i12 < 8; i12++) {
                int i13 = iArr[i12] >>> i11;
                int i14 = (i13 >>> 3) & 1;
                Q(i12, (i13 ^ (-i14)) & 7, gVar);
                nr.b.m(i14, gVar.f44436a, gVar.f44437b);
                nr.b.i(i14, gVar.f44438c);
                F(gVar, dVar);
            }
            i11 -= 4;
            if (i11 < 0) {
                return;
            } else {
                N(dVar);
            }
        }
    }

    public static int c(int[] iArr, int[] iArr2) {
        int[] iArrK = nr.b.k();
        int[] iArrK2 = nr.b.k();
        int[] iArrK3 = nr.b.k();
        nr.b.L(iArr, iArrK2);
        nr.b.L(iArr2, iArrK3);
        nr.b.E(iArrK2, iArrK3, iArrK);
        nr.b.N(iArrK3, iArrK2, iArrK3);
        nr.b.E(iArrK, f44417v, iArrK);
        nr.b.b(iArrK);
        nr.b.N(iArrK, iArrK3, iArrK);
        nr.b.G(iArrK);
        return nr.b.B(iArrK);
    }

    public static void c0(byte[] bArr, byte[] bArr2, int i10) {
        d dVar = new d();
        b0(bArr, dVar);
        if (s(dVar, bArr2, i10) == 0) {
            throw new IllegalStateException();
        }
    }

    public static int d(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrK = nr.b.k();
        int[] iArrK2 = nr.b.k();
        int[] iArrK3 = nr.b.k();
        int[] iArrK4 = nr.b.k();
        nr.b.L(iArr, iArrK2);
        nr.b.L(iArr2, iArrK3);
        nr.b.L(iArr3, iArrK4);
        nr.b.E(iArrK2, iArrK3, iArrK);
        nr.b.N(iArrK3, iArrK2, iArrK3);
        nr.b.E(iArrK3, iArrK4, iArrK3);
        nr.b.L(iArrK4, iArrK4);
        nr.b.E(iArrK, f44417v, iArrK);
        nr.b.a(iArrK, iArrK4, iArrK);
        nr.b.N(iArrK, iArrK3, iArrK);
        nr.b.G(iArrK);
        return nr.b.B(iArrK);
    }

    public static void d0(a.b bVar, byte[] bArr, int i10, int[] iArr, int[] iArr2) {
        Objects.requireNonNull(bVar, "This method is only for use by X25519");
        byte[] bArr2 = new byte[32];
        Y(bArr, i10, bArr2);
        d dVar = new d();
        b0(bArr2, dVar);
        if (d(dVar.f44425a, dVar.f44426b, dVar.f44427c) == 0) {
            throw new IllegalStateException();
        }
        nr.b.j(dVar.f44426b, 0, iArr, 0);
        nr.b.j(dVar.f44427c, 0, iArr2, 0);
    }

    public static boolean e(byte[] bArr) {
        int[] iArr = new int[8];
        l(bArr, 0, iArr, 0, 8);
        iArr[7] = iArr[7] & Integer.MAX_VALUE;
        return !i.w(iArr, f44408m);
    }

    public static void e0(e eVar, d dVar) {
        byte[] bArrW = w(f44409n, 5);
        f[] fVarArrU = U(J(eVar), 8);
        V(dVar);
        int i10 = 252;
        while (true) {
            byte b10 = bArrW[i10];
            if (b10 != 0) {
                int i11 = b10 >> 31;
                G(i11 != 0, fVarArrU[(b10 ^ i11) >>> 1], dVar);
            }
            i10--;
            if (i10 < 0) {
                return;
            } else {
                N(dVar);
            }
        }
    }

    public static boolean f(byte[] bArr, int[] iArr) {
        n(bArr, 0, iArr);
        return !i.w(iArr, f44409n);
    }

    public static void f0(int[] iArr, int[] iArr2, e eVar, d dVar) {
        X();
        byte[] bArrW = w(iArr, 7);
        byte[] bArrW2 = w(iArr2, 5);
        f[] fVarArrU = U(J(eVar), 8);
        V(dVar);
        int i10 = 252;
        while (true) {
            byte b10 = bArrW[i10];
            if (b10 != 0) {
                int i11 = b10 >> 31;
                G(i11 != 0, F[(b10 ^ i11) >>> 1], dVar);
            }
            byte b11 = bArrW2[i10];
            if (b11 != 0) {
                int i12 = b11 >> 31;
                G(i12 != 0, fVarArrU[(b11 ^ i12) >>> 1], dVar);
            }
            i10--;
            if (i10 < 0) {
                return;
            } else {
                N(dVar);
            }
        }
    }

    public static byte[] g(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        return bArr2;
    }

    public static void g0(byte[] bArr, int i10, byte[] bArr2, int i11, int i12, byte[] bArr3, int i13) {
        y(bArr, i10, null, (byte) 0, bArr2, i11, i12, bArr3, i13);
    }

    public static s h() {
        return new h0();
    }

    public static void h0(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, int i12, int i13, byte[] bArr4, int i14) {
        z(bArr, i10, bArr2, i11, null, (byte) 0, bArr3, i12, i13, bArr4, i14);
    }

    public static s i() {
        return h();
    }

    public static void i0(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, byte[] bArr4, int i12, int i13, byte[] bArr5, int i14) {
        z(bArr, i10, bArr2, i11, bArr3, (byte) 0, bArr4, i12, i13, bArr5, i14);
    }

    public static int j(byte[] bArr, int i10) {
        int i11 = bArr[i10] & 255;
        int i12 = i10 + 1;
        return ((bArr[i12 + 1] & 255) << 16) | i11 | ((bArr[i12] & 255) << 8);
    }

    public static void j0(byte[] bArr, int i10, byte[] bArr2, byte[] bArr3, int i11, int i12, byte[] bArr4, int i13) {
        y(bArr, i10, bArr2, (byte) 0, bArr3, i11, i12, bArr4, i13);
    }

    public static int k(byte[] bArr, int i10) {
        int i11 = bArr[i10] & 255;
        int i12 = i10 + 1;
        int i13 = i11 | ((bArr[i12] & 255) << 8);
        int i14 = i12 + 1;
        return (bArr[i14 + 1] << 24) | i13 | ((bArr[i14] & 255) << 16);
    }

    public static void k0(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, s sVar, byte[] bArr4, int i12) {
        byte[] bArr5 = new byte[64];
        if (64 != sVar.c(bArr5, 0)) {
            throw new IllegalArgumentException("ph");
        }
        z(bArr, i10, bArr2, i11, bArr3, (byte) 1, bArr5, 0, 64, bArr4, i12);
    }

    public static void l(byte[] bArr, int i10, int[] iArr, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            iArr[i11 + i13] = k(bArr, (i13 * 4) + i10);
        }
    }

    public static void l0(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, byte[] bArr4, int i12, byte[] bArr5, int i13) {
        z(bArr, i10, bArr2, i11, bArr3, (byte) 1, bArr4, i12, 64, bArr5, i13);
    }

    public static boolean m(byte[] bArr, int i10, boolean z10, e eVar) {
        byte[] bArrG = g(bArr, i10, 32);
        if (!e(bArrG)) {
            return false;
        }
        int i11 = (bArrG[31] & 128) >>> 7;
        bArrG[31] = (byte) (bArrG[31] & 127);
        nr.b.n(bArrG, 0, eVar.f44431b);
        int[] iArrK = nr.b.k();
        int[] iArrK2 = nr.b.k();
        nr.b.L(eVar.f44431b, iArrK);
        nr.b.E(f44417v, iArrK, iArrK2);
        nr.b.O(iArrK);
        nr.b.b(iArrK2);
        if (!nr.b.M(iArrK, iArrK2, eVar.f44430a)) {
            return false;
        }
        nr.b.G(eVar.f44430a);
        if (i11 == 1 && nr.b.C(eVar.f44430a)) {
            return false;
        }
        int[] iArr = eVar.f44430a;
        if (z10 ^ (i11 != (iArr[0] & 1))) {
            nr.b.F(iArr, iArr);
        }
        return true;
    }

    public static void m0(byte[] bArr, int i10, byte[] bArr2, s sVar, byte[] bArr3, int i11) {
        byte[] bArr4 = new byte[64];
        if (64 != sVar.c(bArr4, 0)) {
            throw new IllegalArgumentException("ph");
        }
        y(bArr, i10, bArr2, (byte) 1, bArr4, 0, 64, bArr3, i11);
    }

    public static void n(byte[] bArr, int i10, int[] iArr) {
        l(bArr, i10, iArr, 0, 8);
    }

    public static void n0(byte[] bArr, int i10, byte[] bArr2, byte[] bArr3, int i11, byte[] bArr4, int i12) {
        y(bArr, i10, bArr2, (byte) 1, bArr3, i11, 64, bArr4, i12);
    }

    public static void o(s sVar, byte b10, byte[] bArr) {
        if (bArr != null) {
            byte[] bArr2 = f44407l;
            int length = bArr2.length;
            int i10 = length + 2;
            int length2 = bArr.length + i10;
            byte[] bArr3 = new byte[length2];
            System.arraycopy(bArr2, 0, bArr3, 0, length);
            bArr3[length] = b10;
            bArr3[length + 1] = (byte) bArr.length;
            System.arraycopy(bArr, 0, bArr3, i10, bArr.length);
            sVar.update(bArr3, 0, length2);
        }
    }

    public static boolean o0(byte[] bArr, int i10) {
        e eVar = new e();
        if (!m(bArr, i10, false, eVar)) {
            return false;
        }
        nr.b.G(eVar.f44430a);
        nr.b.G(eVar.f44431b);
        if (B(eVar.f44430a, eVar.f44431b)) {
            return false;
        }
        d dVar = new d();
        e0(eVar, dVar);
        nr.b.G(dVar.f44425a);
        nr.b.G(dVar.f44426b);
        nr.b.G(dVar.f44427c);
        return C(dVar.f44425a, dVar.f44426b, dVar.f44427c);
    }

    public static void p(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) i10;
        int i12 = i11 + 1;
        bArr[i12] = (byte) (i10 >>> 8);
        bArr[i12 + 1] = (byte) (i10 >>> 16);
    }

    public static boolean p0(byte[] bArr, int i10) {
        return m(bArr, i10, false, new e());
    }

    public static void q(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) i10;
        int i12 = i11 + 1;
        bArr[i12] = (byte) (i10 >>> 8);
        int i13 = i12 + 1;
        bArr[i13] = (byte) (i10 >>> 16);
        bArr[i13 + 1] = (byte) (i10 >>> 24);
    }

    public static boolean q0(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, int i12, int i13) {
        return A(bArr, i10, bArr2, i11, null, (byte) 0, bArr3, i12, i13);
    }

    public static void r(long j10, byte[] bArr, int i10) {
        q((int) j10, bArr, i10);
        p((int) (j10 >>> 32), bArr, i10 + 4);
    }

    public static boolean r0(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, byte[] bArr4, int i12, int i13) {
        return A(bArr, i10, bArr2, i11, bArr3, (byte) 0, bArr4, i12, i13);
    }

    public static int s(d dVar, byte[] bArr, int i10) {
        int[] iArrK = nr.b.k();
        int[] iArrK2 = nr.b.k();
        nr.b.x(dVar.f44427c, iArrK2);
        nr.b.E(dVar.f44425a, iArrK2, iArrK);
        nr.b.E(dVar.f44426b, iArrK2, iArrK2);
        nr.b.G(iArrK);
        nr.b.G(iArrK2);
        int iC = c(iArrK, iArrK2);
        nr.b.s(iArrK2, bArr, i10);
        int i11 = (i10 + 32) - 1;
        bArr[i11] = (byte) (((iArrK[0] & 1) << 7) | bArr[i11]);
        return iC;
    }

    public static boolean s0(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, s sVar) {
        byte[] bArr4 = new byte[64];
        if (64 == sVar.c(bArr4, 0)) {
            return A(bArr, i10, bArr2, i11, bArr3, (byte) 1, bArr4, 0, 64);
        }
        throw new IllegalArgumentException("ph");
    }

    public static void t(SecureRandom secureRandom, byte[] bArr) {
        secureRandom.nextBytes(bArr);
    }

    public static boolean t0(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, byte[] bArr4, int i12) {
        return A(bArr, i10, bArr2, i11, bArr3, (byte) 1, bArr4, i12, 64);
    }

    public static void u(byte[] bArr, int i10, byte[] bArr2, int i11) {
        s sVarH = h();
        byte[] bArr3 = new byte[sVarH.h()];
        sVarH.update(bArr, i10, 32);
        sVarH.c(bArr3, 0);
        byte[] bArr4 = new byte[32];
        Y(bArr3, 0, bArr4);
        c0(bArr4, bArr2, i11);
    }

    public static int v(int[] iArr, int i10) {
        return (iArr[i10 >>> 3] >>> ((i10 & 7) << 2)) & 15;
    }

    public static byte[] w(int[] iArr, int i10) {
        int[] iArr2 = new int[16];
        int i11 = 0;
        int i12 = 8;
        int i13 = 16;
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
        byte[] bArr = new byte[253];
        int i17 = 32 - i10;
        int i18 = 0;
        int i19 = 0;
        while (i11 < 16) {
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

    public static void x(s sVar, byte[] bArr, byte[] bArr2, byte[] bArr3, int i10, byte[] bArr4, byte b10, byte[] bArr5, int i11, int i12, byte[] bArr6, int i13) {
        o(sVar, b10, bArr4);
        sVar.update(bArr, 32, 32);
        sVar.update(bArr5, i11, i12);
        sVar.c(bArr, 0);
        byte[] bArrZ = Z(bArr);
        byte[] bArr7 = new byte[32];
        c0(bArrZ, bArr7, 0);
        o(sVar, b10, bArr4);
        sVar.update(bArr7, 0, 32);
        sVar.update(bArr3, i10, 32);
        sVar.update(bArr5, i11, i12);
        sVar.c(bArr, 0);
        byte[] bArrA = a(bArrZ, Z(bArr), bArr2);
        System.arraycopy(bArr7, 0, bArr6, i13, 32);
        System.arraycopy(bArrA, 0, bArr6, i13 + 32, 32);
    }

    public static void y(byte[] bArr, int i10, byte[] bArr2, byte b10, byte[] bArr3, int i11, int i12, byte[] bArr4, int i13) {
        if (!b(bArr2, b10)) {
            throw new IllegalArgumentException("ctx");
        }
        s sVarH = h();
        byte[] bArr5 = new byte[sVarH.h()];
        sVarH.update(bArr, i10, 32);
        sVarH.c(bArr5, 0);
        byte[] bArr6 = new byte[32];
        Y(bArr5, 0, bArr6);
        byte[] bArr7 = new byte[32];
        c0(bArr6, bArr7, 0);
        x(sVarH, bArr5, bArr6, bArr7, 0, bArr2, b10, bArr3, i11, i12, bArr4, i13);
    }

    public static void z(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, byte b10, byte[] bArr4, int i12, int i13, byte[] bArr5, int i14) {
        if (!b(bArr3, b10)) {
            throw new IllegalArgumentException("ctx");
        }
        s sVarH = h();
        byte[] bArr6 = new byte[sVarH.h()];
        sVarH.update(bArr, i10, 32);
        sVarH.c(bArr6, 0);
        byte[] bArr7 = new byte[32];
        Y(bArr6, 0, bArr7);
        x(sVarH, bArr6, bArr7, bArr2, i11, bArr3, b10, bArr4, i12, i13, bArr5, i14);
    }
}
