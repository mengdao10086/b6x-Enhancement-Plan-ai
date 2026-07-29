package lr;

import ir.e;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public class m0 extends e.c {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f40283s = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public p0 f40285q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final BigInteger f40282r = o0.f40314h;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ir.f[] f40284t = {new o0(ir.d.f35647b)};

    public class a extends ir.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f40286a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f40287b;

        public a(int i10, int[] iArr) {
            this.f40286a = i10;
            this.f40287b = iArr;
        }

        @Override // ir.g
        public ir.i a(int i10) {
            int[] iArrD = rr.o.D(12);
            int[] iArrD2 = rr.o.D(12);
            int i11 = 0;
            for (int i12 = 0; i12 < this.f40286a; i12++) {
                int i13 = ((i12 ^ i10) - 1) >> 31;
                for (int i14 = 0; i14 < 12; i14++) {
                    int i15 = iArrD[i14];
                    int[] iArr = this.f40287b;
                    iArrD[i14] = i15 ^ (iArr[i11 + i14] & i13);
                    iArrD2[i14] = iArrD2[i14] ^ (iArr[(i11 + 12) + i14] & i13);
                }
                i11 += 24;
            }
            return d(iArrD, iArrD2);
        }

        @Override // ir.a, ir.g
        public ir.i b(int i10) {
            int[] iArrD = rr.o.D(12);
            int[] iArrD2 = rr.o.D(12);
            int i11 = i10 * 12 * 2;
            for (int i12 = 0; i12 < 12; i12++) {
                int[] iArr = this.f40287b;
                iArrD[i12] = iArr[i11 + i12];
                iArrD2[i12] = iArr[i11 + 12 + i12];
            }
            return d(iArrD, iArrD2);
        }

        @Override // ir.g
        public int c() {
            return this.f40286a;
        }

        public final ir.i d(int[] iArr, int[] iArr2) {
            return m0.this.j(new o0(iArr), new o0(iArr2), m0.f40284t);
        }
    }

    public m0() {
        super(f40282r);
        this.f40285q = new p0(this, null, null);
        this.f35662b = n(new BigInteger(1, jt.h.d("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFC")));
        this.f35663c = n(new BigInteger(1, jt.h.d("B3312FA7E23EE7E4988E056BE3F82D19181D9C6EFE8141120314088F5013875AC656398D8A2ED19D2A85C8EDD3EC2AEF")));
        this.f35664d = new BigInteger(1, jt.h.d("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC7634D81F4372DDF581A0DB248B0A77AECEC196ACCC52973"));
        this.f35665e = BigInteger.valueOf(1L);
        this.f35666f = 2;
    }

    @Override // ir.e.c, ir.e
    public ir.f F(SecureRandom secureRandom) {
        int[] iArrD = rr.o.D(12);
        n0.k(secureRandom, iArrD);
        return new o0(iArrD);
    }

    @Override // ir.e.c, ir.e
    public ir.f G(SecureRandom secureRandom) {
        int[] iArrD = rr.o.D(12);
        n0.l(secureRandom, iArrD);
        return new o0(iArrD);
    }

    @Override // ir.e
    public boolean H(int i10) {
        return i10 == 2;
    }

    public BigInteger M() {
        return f40282r;
    }

    @Override // ir.e
    public ir.e d() {
        return new m0();
    }

    @Override // ir.e
    public ir.g f(ir.i[] iVarArr, int i10, int i11) {
        int[] iArr = new int[i11 * 12 * 2];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            ir.i iVar = iVarArr[i10 + i13];
            rr.o.x(12, ((o0) iVar.n()).f40315g, 0, iArr, i12);
            int i14 = i12 + 12;
            rr.o.x(12, ((o0) iVar.o()).f40315g, 0, iArr, i14);
            i12 = i14 + 12;
        }
        return new a(i11, iArr);
    }

    @Override // ir.e
    public ir.i i(ir.f fVar, ir.f fVar2) {
        return new p0(this, fVar, fVar2);
    }

    @Override // ir.e
    public ir.i j(ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        return new p0(this, fVar, fVar2, fVarArr);
    }

    @Override // ir.e
    public ir.f n(BigInteger bigInteger) {
        return new o0(bigInteger);
    }

    @Override // ir.e
    public int v() {
        return f40282r.bitLength();
    }

    @Override // ir.e
    public ir.i w() {
        return this.f40285q;
    }
}
