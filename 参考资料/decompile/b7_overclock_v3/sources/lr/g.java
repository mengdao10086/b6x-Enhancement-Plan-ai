package lr;

import ir.e;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public class g extends e.c {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f40205s = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public j f40207q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final BigInteger f40204r = i.f40230h;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ir.f[] f40206t = {new i(ir.d.f35647b)};

    public class a extends ir.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f40208a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f40209b;

        public a(int i10, int[] iArr) {
            this.f40208a = i10;
            this.f40209b = iArr;
        }

        @Override // ir.g
        public ir.i a(int i10) {
            int[] iArrH = rr.f.h();
            int[] iArrH2 = rr.f.h();
            int i11 = 0;
            for (int i12 = 0; i12 < this.f40208a; i12++) {
                int i13 = ((i12 ^ i10) - 1) >> 31;
                for (int i14 = 0; i14 < 5; i14++) {
                    int i15 = iArrH[i14];
                    int[] iArr = this.f40209b;
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
                int[] iArr = this.f40209b;
                iArrH[i12] = iArr[i11 + i12];
                iArrH2[i12] = iArr[i11 + 5 + i12];
            }
            return d(iArrH, iArrH2);
        }

        @Override // ir.g
        public int c() {
            return this.f40208a;
        }

        public final ir.i d(int[] iArr, int[] iArr2) {
            return g.this.j(new i(iArr), new i(iArr2), g.f40206t);
        }
    }

    public g() {
        super(f40204r);
        this.f40207q = new j(this, null, null);
        this.f35662b = n(new BigInteger(1, jt.h.d("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF7FFFFFFC")));
        this.f35663c = n(new BigInteger(1, jt.h.d("1C97BEFC54BD7A8B65ACF89F81D4D4ADC565FA45")));
        this.f35664d = new BigInteger(1, jt.h.d("0100000000000000000001F4C8F927AED3CA752257"));
        this.f35665e = BigInteger.valueOf(1L);
        this.f35666f = 2;
    }

    @Override // ir.e.c, ir.e
    public ir.f F(SecureRandom secureRandom) {
        int[] iArrH = rr.f.h();
        h.k(secureRandom, iArrH);
        return new i(iArrH);
    }

    @Override // ir.e.c, ir.e
    public ir.f G(SecureRandom secureRandom) {
        int[] iArrH = rr.f.h();
        h.l(secureRandom, iArrH);
        return new i(iArrH);
    }

    @Override // ir.e
    public boolean H(int i10) {
        return i10 == 2;
    }

    public BigInteger M() {
        return f40204r;
    }

    @Override // ir.e
    public ir.e d() {
        return new g();
    }

    @Override // ir.e
    public ir.g f(ir.i[] iVarArr, int i10, int i11) {
        int[] iArr = new int[i11 * 5 * 2];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            ir.i iVar = iVarArr[i10 + i13];
            rr.f.f(((i) iVar.n()).f40231g, 0, iArr, i12);
            int i14 = i12 + 5;
            rr.f.f(((i) iVar.o()).f40231g, 0, iArr, i14);
            i12 = i14 + 5;
        }
        return new a(i11, iArr);
    }

    @Override // ir.e
    public ir.i i(ir.f fVar, ir.f fVar2) {
        return new j(this, fVar, fVar2);
    }

    @Override // ir.e
    public ir.i j(ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        return new j(this, fVar, fVar2, fVarArr);
    }

    @Override // ir.e
    public ir.f n(BigInteger bigInteger) {
        return new i(bigInteger);
    }

    @Override // ir.e
    public int v() {
        return f40204r.bitLength();
    }

    @Override // ir.e
    public ir.i w() {
        return this.f40207q;
    }
}
