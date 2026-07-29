package lr;

import ir.e;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public class a0 extends e.c {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f40133s = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public d0 f40135q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final BigInteger f40132r = c0.f40160h;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ir.f[] f40134t = {new c0(ir.d.f35647b)};

    public class a extends ir.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f40136a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f40137b;

        public a(int i10, int[] iArr) {
            this.f40136a = i10;
            this.f40137b = iArr;
        }

        @Override // ir.g
        public ir.i a(int i10) {
            int[] iArrJ = rr.h.j();
            int[] iArrJ2 = rr.h.j();
            int i11 = 0;
            for (int i12 = 0; i12 < this.f40136a; i12++) {
                int i13 = ((i12 ^ i10) - 1) >> 31;
                for (int i14 = 0; i14 < 7; i14++) {
                    int i15 = iArrJ[i14];
                    int[] iArr = this.f40137b;
                    iArrJ[i14] = i15 ^ (iArr[i11 + i14] & i13);
                    iArrJ2[i14] = iArrJ2[i14] ^ (iArr[(i11 + 7) + i14] & i13);
                }
                i11 += 14;
            }
            return d(iArrJ, iArrJ2);
        }

        @Override // ir.a, ir.g
        public ir.i b(int i10) {
            int[] iArrJ = rr.h.j();
            int[] iArrJ2 = rr.h.j();
            int i11 = i10 * 7 * 2;
            for (int i12 = 0; i12 < 7; i12++) {
                int[] iArr = this.f40137b;
                iArrJ[i12] = iArr[i11 + i12];
                iArrJ2[i12] = iArr[i11 + 7 + i12];
            }
            return d(iArrJ, iArrJ2);
        }

        @Override // ir.g
        public int c() {
            return this.f40136a;
        }

        public final ir.i d(int[] iArr, int[] iArr2) {
            return a0.this.j(new c0(iArr), new c0(iArr2), a0.f40134t);
        }
    }

    public a0() {
        super(f40132r);
        this.f40135q = new d0(this, null, null);
        this.f35662b = n(new BigInteger(1, jt.h.d("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFE")));
        this.f35663c = n(new BigInteger(1, jt.h.d("B4050A850C04B3ABF54132565044B0B7D7BFD8BA270B39432355FFB4")));
        this.f35664d = new BigInteger(1, jt.h.d("FFFFFFFFFFFFFFFFFFFFFFFFFFFF16A2E0B8F03E13DD29455C5C2A3D"));
        this.f35665e = BigInteger.valueOf(1L);
        this.f35666f = 2;
    }

    @Override // ir.e.c, ir.e
    public ir.f F(SecureRandom secureRandom) {
        int[] iArrJ = rr.h.j();
        b0.l(secureRandom, iArrJ);
        return new c0(iArrJ);
    }

    @Override // ir.e.c, ir.e
    public ir.f G(SecureRandom secureRandom) {
        int[] iArrJ = rr.h.j();
        b0.m(secureRandom, iArrJ);
        return new c0(iArrJ);
    }

    @Override // ir.e
    public boolean H(int i10) {
        return i10 == 2;
    }

    public BigInteger M() {
        return f40132r;
    }

    @Override // ir.e
    public ir.e d() {
        return new a0();
    }

    @Override // ir.e
    public ir.g f(ir.i[] iVarArr, int i10, int i11) {
        int[] iArr = new int[i11 * 7 * 2];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            ir.i iVar = iVarArr[i10 + i13];
            rr.h.h(((c0) iVar.n()).f40161g, 0, iArr, i12);
            int i14 = i12 + 7;
            rr.h.h(((c0) iVar.o()).f40161g, 0, iArr, i14);
            i12 = i14 + 7;
        }
        return new a(i11, iArr);
    }

    @Override // ir.e
    public ir.i i(ir.f fVar, ir.f fVar2) {
        return new d0(this, fVar, fVar2);
    }

    @Override // ir.e
    public ir.i j(ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        return new d0(this, fVar, fVar2, fVarArr);
    }

    @Override // ir.e
    public ir.f n(BigInteger bigInteger) {
        return new c0(bigInteger);
    }

    @Override // ir.e
    public int v() {
        return f40132r.bitLength();
    }

    @Override // ir.e
    public ir.i w() {
        return this.f40135q;
    }
}
