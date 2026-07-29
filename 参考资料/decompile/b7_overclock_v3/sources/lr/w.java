package lr;

import ir.e;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public class w extends e.c {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f40395s = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public z f40397q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final BigInteger f40394r = y.f40419h;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ir.f[] f40396t = {new y(ir.d.f35647b)};

    public class a extends ir.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f40398a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f40399b;

        public a(int i10, int[] iArr) {
            this.f40398a = i10;
            this.f40399b = iArr;
        }

        @Override // ir.g
        public ir.i a(int i10) {
            int[] iArrJ = rr.h.j();
            int[] iArrJ2 = rr.h.j();
            int i11 = 0;
            for (int i12 = 0; i12 < this.f40398a; i12++) {
                int i13 = ((i12 ^ i10) - 1) >> 31;
                for (int i14 = 0; i14 < 7; i14++) {
                    int i15 = iArrJ[i14];
                    int[] iArr = this.f40399b;
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
            int i11 = 0;
            for (int i12 = 0; i12 < this.f40398a; i12++) {
                int i13 = ((i12 ^ i10) - 1) >> 31;
                for (int i14 = 0; i14 < 7; i14++) {
                    int i15 = iArrJ[i14];
                    int[] iArr = this.f40399b;
                    iArrJ[i14] = i15 ^ (iArr[i11 + i14] & i13);
                    iArrJ2[i14] = iArrJ2[i14] ^ (iArr[(i11 + 7) + i14] & i13);
                }
                i11 += 14;
            }
            return d(iArrJ, iArrJ2);
        }

        @Override // ir.g
        public int c() {
            return this.f40398a;
        }

        public final ir.i d(int[] iArr, int[] iArr2) {
            return w.this.j(new y(iArr), new y(iArr2), w.f40396t);
        }
    }

    public w() {
        super(f40394r);
        this.f40397q = new z(this, null, null);
        this.f35662b = n(ir.d.f35646a);
        this.f35663c = n(BigInteger.valueOf(5L));
        this.f35664d = new BigInteger(1, jt.h.d("010000000000000000000000000001DCE8D2EC6184CAF0A971769FB1F7"));
        this.f35665e = BigInteger.valueOf(1L);
        this.f35666f = 2;
    }

    @Override // ir.e.c, ir.e
    public ir.f F(SecureRandom secureRandom) {
        int[] iArrJ = rr.h.j();
        x.k(secureRandom, iArrJ);
        return new y(iArrJ);
    }

    @Override // ir.e.c, ir.e
    public ir.f G(SecureRandom secureRandom) {
        int[] iArrJ = rr.h.j();
        x.l(secureRandom, iArrJ);
        return new y(iArrJ);
    }

    @Override // ir.e
    public boolean H(int i10) {
        return i10 == 2;
    }

    public BigInteger M() {
        return f40394r;
    }

    @Override // ir.e
    public ir.e d() {
        return new w();
    }

    @Override // ir.e
    public ir.g f(ir.i[] iVarArr, int i10, int i11) {
        int[] iArr = new int[i11 * 7 * 2];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            ir.i iVar = iVarArr[i10 + i13];
            rr.h.h(((y) iVar.n()).f40421g, 0, iArr, i12);
            int i14 = i12 + 7;
            rr.h.h(((y) iVar.o()).f40421g, 0, iArr, i14);
            i12 = i14 + 7;
        }
        return new a(i11, iArr);
    }

    @Override // ir.e
    public ir.i i(ir.f fVar, ir.f fVar2) {
        return new z(this, fVar, fVar2);
    }

    @Override // ir.e
    public ir.i j(ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        return new z(this, fVar, fVar2, fVarArr);
    }

    @Override // ir.e
    public ir.f n(BigInteger bigInteger) {
        return new y(bigInteger);
    }

    @Override // ir.e
    public int v() {
        return f40394r.bitLength();
    }

    @Override // ir.e
    public ir.i w() {
        return this.f40397q;
    }
}
