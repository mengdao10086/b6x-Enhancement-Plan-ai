package lr;

import ir.e;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public class o extends e.c {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f40308s = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public r f40310q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final BigInteger f40307r = q.f40331h;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ir.f[] f40309t = {new q(ir.d.f35647b)};

    public class a extends ir.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f40311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f40312b;

        public a(int i10, int[] iArr) {
            this.f40311a = i10;
            this.f40312b = iArr;
        }

        @Override // ir.g
        public ir.i a(int i10) {
            int[] iArrJ = rr.g.j();
            int[] iArrJ2 = rr.g.j();
            int i11 = 0;
            for (int i12 = 0; i12 < this.f40311a; i12++) {
                int i13 = ((i12 ^ i10) - 1) >> 31;
                for (int i14 = 0; i14 < 6; i14++) {
                    int i15 = iArrJ[i14];
                    int[] iArr = this.f40312b;
                    iArrJ[i14] = i15 ^ (iArr[i11 + i14] & i13);
                    iArrJ2[i14] = iArrJ2[i14] ^ (iArr[(i11 + 6) + i14] & i13);
                }
                i11 += 12;
            }
            return d(iArrJ, iArrJ2);
        }

        @Override // ir.a, ir.g
        public ir.i b(int i10) {
            int[] iArrJ = rr.g.j();
            int[] iArrJ2 = rr.g.j();
            int i11 = i10 * 6 * 2;
            for (int i12 = 0; i12 < 6; i12++) {
                int[] iArr = this.f40312b;
                iArrJ[i12] = iArr[i11 + i12];
                iArrJ2[i12] = iArr[i11 + 6 + i12];
            }
            return d(iArrJ, iArrJ2);
        }

        @Override // ir.g
        public int c() {
            return this.f40311a;
        }

        public final ir.i d(int[] iArr, int[] iArr2) {
            return o.this.j(new q(iArr), new q(iArr2), o.f40309t);
        }
    }

    public o() {
        super(f40307r);
        this.f40310q = new r(this, null, null);
        this.f35662b = n(ir.d.f35646a);
        this.f35663c = n(BigInteger.valueOf(3L));
        this.f35664d = new BigInteger(1, jt.h.d("FFFFFFFFFFFFFFFFFFFFFFFE26F2FC170F69466A74DEFD8D"));
        this.f35665e = BigInteger.valueOf(1L);
        this.f35666f = 2;
    }

    @Override // ir.e.c, ir.e
    public ir.f F(SecureRandom secureRandom) {
        int[] iArrJ = rr.g.j();
        p.k(secureRandom, iArrJ);
        return new q(iArrJ);
    }

    @Override // ir.e.c, ir.e
    public ir.f G(SecureRandom secureRandom) {
        int[] iArrJ = rr.g.j();
        p.l(secureRandom, iArrJ);
        return new q(iArrJ);
    }

    @Override // ir.e
    public boolean H(int i10) {
        return i10 == 2;
    }

    public BigInteger M() {
        return f40307r;
    }

    @Override // ir.e
    public ir.e d() {
        return new o();
    }

    @Override // ir.e
    public ir.g f(ir.i[] iVarArr, int i10, int i11) {
        int[] iArr = new int[i11 * 6 * 2];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            ir.i iVar = iVarArr[i10 + i13];
            rr.g.f(((q) iVar.n()).f40332g, 0, iArr, i12);
            int i14 = i12 + 6;
            rr.g.f(((q) iVar.o()).f40332g, 0, iArr, i14);
            i12 = i14 + 6;
        }
        return new a(i11, iArr);
    }

    @Override // ir.e
    public ir.i i(ir.f fVar, ir.f fVar2) {
        return new r(this, fVar, fVar2);
    }

    @Override // ir.e
    public ir.i j(ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        return new r(this, fVar, fVar2, fVarArr);
    }

    @Override // ir.e
    public ir.f n(BigInteger bigInteger) {
        return new q(bigInteger);
    }

    @Override // ir.e
    public int v() {
        return f40307r.bitLength();
    }

    @Override // ir.e
    public ir.i w() {
        return this.f40310q;
    }
}
