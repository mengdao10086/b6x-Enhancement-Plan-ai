package lr;

import ir.e;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public class q0 extends e.c {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f40334s = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public t0 f40336q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final BigInteger f40333r = s0.f40358h;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ir.f[] f40335t = {new s0(ir.d.f35647b)};

    public class a extends ir.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f40337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f40338b;

        public a(int i10, int[] iArr) {
            this.f40337a = i10;
            this.f40338b = iArr;
        }

        @Override // ir.g
        public ir.i a(int i10) {
            int[] iArrD = rr.o.D(17);
            int[] iArrD2 = rr.o.D(17);
            int i11 = 0;
            for (int i12 = 0; i12 < this.f40337a; i12++) {
                int i13 = ((i12 ^ i10) - 1) >> 31;
                for (int i14 = 0; i14 < 17; i14++) {
                    int i15 = iArrD[i14];
                    int[] iArr = this.f40338b;
                    iArrD[i14] = i15 ^ (iArr[i11 + i14] & i13);
                    iArrD2[i14] = iArrD2[i14] ^ (iArr[(i11 + 17) + i14] & i13);
                }
                i11 += 34;
            }
            return d(iArrD, iArrD2);
        }

        @Override // ir.a, ir.g
        public ir.i b(int i10) {
            int[] iArrD = rr.o.D(17);
            int[] iArrD2 = rr.o.D(17);
            int i11 = i10 * 17 * 2;
            for (int i12 = 0; i12 < 17; i12++) {
                int i13 = iArrD[i12];
                int[] iArr = this.f40338b;
                iArrD[i12] = i13 ^ iArr[i11 + i12];
                iArrD2[i12] = iArrD2[i12] ^ iArr[(i11 + 17) + i12];
            }
            return d(iArrD, iArrD2);
        }

        @Override // ir.g
        public int c() {
            return this.f40337a;
        }

        public final ir.i d(int[] iArr, int[] iArr2) {
            return q0.this.j(new s0(iArr), new s0(iArr2), q0.f40335t);
        }
    }

    public q0() {
        super(f40333r);
        this.f40336q = new t0(this, null, null);
        this.f35662b = n(new BigInteger(1, jt.h.d("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC")));
        this.f35663c = n(new BigInteger(1, jt.h.d("0051953EB9618E1C9A1F929A21A0B68540EEA2DA725B99B315F3B8B489918EF109E156193951EC7E937B1652C0BD3BB1BF073573DF883D2C34F1EF451FD46B503F00")));
        this.f35664d = new BigInteger(1, jt.h.d("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFA51868783BF2F966B7FCC0148F709A5D03BB5C9B8899C47AEBB6FB71E91386409"));
        this.f35665e = BigInteger.valueOf(1L);
        this.f35666f = 2;
    }

    @Override // ir.e.c, ir.e
    public ir.f F(SecureRandom secureRandom) {
        int[] iArrD = rr.o.D(17);
        r0.k(secureRandom, iArrD);
        return new s0(iArrD);
    }

    @Override // ir.e.c, ir.e
    public ir.f G(SecureRandom secureRandom) {
        int[] iArrD = rr.o.D(17);
        r0.l(secureRandom, iArrD);
        return new s0(iArrD);
    }

    @Override // ir.e
    public boolean H(int i10) {
        return i10 == 2;
    }

    public BigInteger M() {
        return f40333r;
    }

    @Override // ir.e
    public ir.e d() {
        return new q0();
    }

    @Override // ir.e
    public ir.g f(ir.i[] iVarArr, int i10, int i11) {
        int[] iArr = new int[i11 * 17 * 2];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            ir.i iVar = iVarArr[i10 + i13];
            rr.o.x(17, ((s0) iVar.n()).f40359g, 0, iArr, i12);
            int i14 = i12 + 17;
            rr.o.x(17, ((s0) iVar.o()).f40359g, 0, iArr, i14);
            i12 = i14 + 17;
        }
        return new a(i11, iArr);
    }

    @Override // ir.e
    public ir.i i(ir.f fVar, ir.f fVar2) {
        return new t0(this, fVar, fVar2);
    }

    @Override // ir.e
    public ir.i j(ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        return new t0(this, fVar, fVar2, fVarArr);
    }

    @Override // ir.e
    public ir.f n(BigInteger bigInteger) {
        return new s0(bigInteger);
    }

    @Override // ir.e
    public int v() {
        return f40333r.bitLength();
    }

    @Override // ir.e
    public ir.i w() {
        return this.f40336q;
    }
}
