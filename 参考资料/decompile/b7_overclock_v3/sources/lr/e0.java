package lr;

import ir.e;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public class e0 extends e.c {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f40182s = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public h0 f40184q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final BigInteger f40181r = g0.f40211h;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ir.f[] f40183t = {new g0(ir.d.f35647b)};

    public class a extends ir.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f40185a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f40186b;

        public a(int i10, int[] iArr) {
            this.f40185a = i10;
            this.f40186b = iArr;
        }

        @Override // ir.g
        public ir.i a(int i10) {
            int[] iArrL = rr.i.l();
            int[] iArrL2 = rr.i.l();
            int i11 = 0;
            for (int i12 = 0; i12 < this.f40185a; i12++) {
                int i13 = ((i12 ^ i10) - 1) >> 31;
                for (int i14 = 0; i14 < 8; i14++) {
                    int i15 = iArrL[i14];
                    int[] iArr = this.f40186b;
                    iArrL[i14] = i15 ^ (iArr[i11 + i14] & i13);
                    iArrL2[i14] = iArrL2[i14] ^ (iArr[(i11 + 8) + i14] & i13);
                }
                i11 += 16;
            }
            return d(iArrL, iArrL2);
        }

        @Override // ir.a, ir.g
        public ir.i b(int i10) {
            int[] iArrL = rr.i.l();
            int[] iArrL2 = rr.i.l();
            int i11 = i10 * 8 * 2;
            for (int i12 = 0; i12 < 8; i12++) {
                int[] iArr = this.f40186b;
                iArrL[i12] = iArr[i11 + i12];
                iArrL2[i12] = iArr[i11 + 8 + i12];
            }
            return d(iArrL, iArrL2);
        }

        @Override // ir.g
        public int c() {
            return this.f40185a;
        }

        public final ir.i d(int[] iArr, int[] iArr2) {
            return e0.this.j(new g0(iArr), new g0(iArr2), e0.f40183t);
        }
    }

    public e0() {
        super(f40181r);
        this.f40184q = new h0(this, null, null);
        this.f35662b = n(ir.d.f35646a);
        this.f35663c = n(BigInteger.valueOf(7L));
        this.f35664d = new BigInteger(1, jt.h.d("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141"));
        this.f35665e = BigInteger.valueOf(1L);
        this.f35666f = 2;
    }

    @Override // ir.e.c, ir.e
    public ir.f F(SecureRandom secureRandom) {
        int[] iArrL = rr.i.l();
        f0.k(secureRandom, iArrL);
        return new g0(iArrL);
    }

    @Override // ir.e.c, ir.e
    public ir.f G(SecureRandom secureRandom) {
        int[] iArrL = rr.i.l();
        f0.l(secureRandom, iArrL);
        return new g0(iArrL);
    }

    @Override // ir.e
    public boolean H(int i10) {
        return i10 == 2;
    }

    public BigInteger M() {
        return f40181r;
    }

    @Override // ir.e
    public ir.e d() {
        return new e0();
    }

    @Override // ir.e
    public ir.g f(ir.i[] iVarArr, int i10, int i11) {
        int[] iArr = new int[i11 * 8 * 2];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            ir.i iVar = iVarArr[i10 + i13];
            rr.i.h(((g0) iVar.n()).f40212g, 0, iArr, i12);
            int i14 = i12 + 8;
            rr.i.h(((g0) iVar.o()).f40212g, 0, iArr, i14);
            i12 = i14 + 8;
        }
        return new a(i11, iArr);
    }

    @Override // ir.e
    public ir.i i(ir.f fVar, ir.f fVar2) {
        return new h0(this, fVar, fVar2);
    }

    @Override // ir.e
    public ir.i j(ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        return new h0(this, fVar, fVar2, fVarArr);
    }

    @Override // ir.e
    public ir.f n(BigInteger bigInteger) {
        return new g0(bigInteger);
    }

    @Override // ir.e
    public int v() {
        return f40181r.bitLength();
    }

    @Override // ir.e
    public ir.i w() {
        return this.f40184q;
    }
}
