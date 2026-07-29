package lr;

import ir.e;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public class s extends e.c {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f40352s = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public v f40354q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final BigInteger f40351r = u.f40378h;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ir.f[] f40353t = {new u(ir.d.f35647b)};

    public class a extends ir.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f40355a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f40356b;

        public a(int i10, int[] iArr) {
            this.f40355a = i10;
            this.f40356b = iArr;
        }

        @Override // ir.g
        public ir.i a(int i10) {
            int[] iArrJ = rr.g.j();
            int[] iArrJ2 = rr.g.j();
            int i11 = 0;
            for (int i12 = 0; i12 < this.f40355a; i12++) {
                int i13 = ((i12 ^ i10) - 1) >> 31;
                for (int i14 = 0; i14 < 6; i14++) {
                    int i15 = iArrJ[i14];
                    int[] iArr = this.f40356b;
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
                int[] iArr = this.f40356b;
                iArrJ[i12] = iArr[i11 + i12];
                iArrJ2[i12] = iArr[i11 + 6 + i12];
            }
            return d(iArrJ, iArrJ2);
        }

        @Override // ir.g
        public int c() {
            return this.f40355a;
        }

        public final ir.i d(int[] iArr, int[] iArr2) {
            return s.this.j(new u(iArr), new u(iArr2), s.f40353t);
        }
    }

    public s() {
        super(f40351r);
        this.f40354q = new v(this, null, null);
        this.f35662b = n(new BigInteger(1, jt.h.d("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFC")));
        this.f35663c = n(new BigInteger(1, jt.h.d("64210519E59C80E70FA7E9AB72243049FEB8DEECC146B9B1")));
        this.f35664d = new BigInteger(1, jt.h.d("FFFFFFFFFFFFFFFFFFFFFFFF99DEF836146BC9B1B4D22831"));
        this.f35665e = BigInteger.valueOf(1L);
        this.f35666f = 2;
    }

    @Override // ir.e.c, ir.e
    public ir.f F(SecureRandom secureRandom) {
        int[] iArrJ = rr.g.j();
        t.l(secureRandom, iArrJ);
        return new u(iArrJ);
    }

    @Override // ir.e.c, ir.e
    public ir.f G(SecureRandom secureRandom) {
        int[] iArrJ = rr.g.j();
        t.m(secureRandom, iArrJ);
        return new u(iArrJ);
    }

    @Override // ir.e
    public boolean H(int i10) {
        return i10 == 2;
    }

    public BigInteger M() {
        return f40351r;
    }

    @Override // ir.e
    public ir.e d() {
        return new s();
    }

    @Override // ir.e
    public ir.g f(ir.i[] iVarArr, int i10, int i11) {
        int[] iArr = new int[i11 * 6 * 2];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            ir.i iVar = iVarArr[i10 + i13];
            rr.g.f(((u) iVar.n()).f40379g, 0, iArr, i12);
            int i14 = i12 + 6;
            rr.g.f(((u) iVar.o()).f40379g, 0, iArr, i14);
            i12 = i14 + 6;
        }
        return new a(i11, iArr);
    }

    @Override // ir.e
    public ir.i i(ir.f fVar, ir.f fVar2) {
        return new v(this, fVar, fVar2);
    }

    @Override // ir.e
    public ir.i j(ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        return new v(this, fVar, fVar2, fVarArr);
    }

    @Override // ir.e
    public ir.f n(BigInteger bigInteger) {
        return new u(bigInteger);
    }

    @Override // ir.e
    public int v() {
        return f40351r.bitLength();
    }

    @Override // ir.e
    public ir.i w() {
        return this.f40354q;
    }
}
