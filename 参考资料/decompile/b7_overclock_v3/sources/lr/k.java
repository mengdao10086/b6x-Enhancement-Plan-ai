package lr;

import ir.e;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public class k extends e.c {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f40257s = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public n f40259q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final BigInteger f40256r = m.f40280h;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ir.f[] f40258t = {new m(ir.d.f35647b)};

    public class a extends ir.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f40260a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f40261b;

        public a(int i10, int[] iArr) {
            this.f40260a = i10;
            this.f40261b = iArr;
        }

        @Override // ir.g
        public ir.i a(int i10) {
            int[] iArrH = rr.f.h();
            int[] iArrH2 = rr.f.h();
            int i11 = 0;
            for (int i12 = 0; i12 < this.f40260a; i12++) {
                int i13 = ((i12 ^ i10) - 1) >> 31;
                for (int i14 = 0; i14 < 5; i14++) {
                    int i15 = iArrH[i14];
                    int[] iArr = this.f40261b;
                    iArrH[i14] = i15 ^ (iArr[i11 + i14] & i13);
                    iArrH2[i14] = iArrH2[i14] ^ (iArr[(i11 + 5) + i14] & i13);
                }
                i11 += 10;
            }
            return d(iArrH, iArrH2);
        }

        @Override // ir.a, ir.g
        public ir.i b(int i10) {
            int[] iArrH = rr.f.h();
            int[] iArrH2 = rr.f.h();
            int i11 = i10 * 5 * 2;
            for (int i12 = 0; i12 < 5; i12++) {
                int[] iArr = this.f40261b;
                iArrH[i12] = iArr[i11 + i12];
                iArrH2[i12] = iArr[i11 + 5 + i12];
            }
            return d(iArrH, iArrH2);
        }

        @Override // ir.g
        public int c() {
            return this.f40260a;
        }

        public final ir.i d(int[] iArr, int[] iArr2) {
            return k.this.j(new m(iArr), new m(iArr2), k.f40258t);
        }
    }

    public k() {
        super(f40256r);
        this.f40259q = new n(this, null, null);
        this.f35662b = n(new BigInteger(1, jt.h.d("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC70")));
        this.f35663c = n(new BigInteger(1, jt.h.d("B4E134D3FB59EB8BAB57274904664D5AF50388BA")));
        this.f35664d = new BigInteger(1, jt.h.d("0100000000000000000000351EE786A818F3A1A16B"));
        this.f35665e = BigInteger.valueOf(1L);
        this.f35666f = 2;
    }

    @Override // ir.e.c, ir.e
    public ir.f F(SecureRandom secureRandom) {
        int[] iArrH = rr.f.h();
        l.k(secureRandom, iArrH);
        return new m(iArrH);
    }

    @Override // ir.e.c, ir.e
    public ir.f G(SecureRandom secureRandom) {
        int[] iArrH = rr.f.h();
        l.l(secureRandom, iArrH);
        return new m(iArrH);
    }

    @Override // ir.e
    public boolean H(int i10) {
        return i10 == 2;
    }

    public BigInteger M() {
        return f40256r;
    }

    @Override // ir.e
    public ir.e d() {
        return new k();
    }

    @Override // ir.e
    public ir.g f(ir.i[] iVarArr, int i10, int i11) {
        int[] iArr = new int[i11 * 5 * 2];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            ir.i iVar = iVarArr[i10 + i13];
            rr.f.f(((m) iVar.n()).f40281g, 0, iArr, i12);
            int i14 = i12 + 5;
            rr.f.f(((m) iVar.o()).f40281g, 0, iArr, i14);
            i12 = i14 + 5;
        }
        return new a(i11, iArr);
    }

    @Override // ir.e
    public ir.i i(ir.f fVar, ir.f fVar2) {
        return new n(this, fVar, fVar2);
    }

    @Override // ir.e
    public ir.i j(ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        return new n(this, fVar, fVar2, fVarArr);
    }

    @Override // ir.e
    public ir.f n(BigInteger bigInteger) {
        return new m(bigInteger);
    }

    @Override // ir.e
    public int v() {
        return f40256r.bitLength();
    }

    @Override // ir.e
    public ir.i w() {
        return this.f40259q;
    }
}
