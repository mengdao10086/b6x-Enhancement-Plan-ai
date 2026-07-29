package lr;

import ir.e;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class k1 extends e.b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f40265s = 6;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ir.f[] f40266t = {new h1(ir.d.f35647b)};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public l1 f40267r;

    public class a extends ir.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f40268a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f40269b;

        public a(int i10, long[] jArr) {
            this.f40268a = i10;
            this.f40269b = jArr;
        }

        @Override // ir.g
        public ir.i a(int i10) {
            long[] jArrK = rr.g.k();
            long[] jArrK2 = rr.g.k();
            int i11 = 0;
            for (int i12 = 0; i12 < this.f40268a; i12++) {
                long j10 = ((i12 ^ i10) - 1) >> 31;
                for (int i13 = 0; i13 < 3; i13++) {
                    long j11 = jArrK[i13];
                    long[] jArr = this.f40269b;
                    jArrK[i13] = j11 ^ (jArr[i11 + i13] & j10);
                    jArrK2[i13] = jArrK2[i13] ^ (jArr[(i11 + 3) + i13] & j10);
                }
                i11 += 6;
            }
            return d(jArrK, jArrK2);
        }

        @Override // ir.a, ir.g
        public ir.i b(int i10) {
            long[] jArrK = rr.g.k();
            long[] jArrK2 = rr.g.k();
            int i11 = i10 * 3 * 2;
            for (int i12 = 0; i12 < 3; i12++) {
                long[] jArr = this.f40269b;
                jArrK[i12] = jArr[i11 + i12];
                jArrK2[i12] = jArr[i11 + 3 + i12];
            }
            return d(jArrK, jArrK2);
        }

        @Override // ir.g
        public int c() {
            return this.f40268a;
        }

        public final ir.i d(long[] jArr, long[] jArr2) {
            return k1.this.j(new h1(jArr), new h1(jArr2), k1.f40266t);
        }
    }

    public k1() {
        super(163, 3, 6, 7);
        this.f40267r = new l1(this, null, null);
        this.f35662b = n(new BigInteger(1, jt.h.d("07B6882CAAEFA84F9554FF8428BD88E246D2782AE2")));
        this.f35663c = n(new BigInteger(1, jt.h.d("0713612DCDDCB40AAB946BDA29CA91F73AF958AFD9")));
        this.f35664d = new BigInteger(1, jt.h.d("03FFFFFFFFFFFFFFFFFFFF48AAB689C29CA710279B"));
        this.f35665e = BigInteger.valueOf(2L);
        this.f35666f = 6;
    }

    @Override // ir.e
    public boolean H(int i10) {
        return i10 == 6;
    }

    @Override // ir.e.b
    public boolean N() {
        return false;
    }

    public int Q() {
        return 3;
    }

    public int R() {
        return 6;
    }

    public int S() {
        return 7;
    }

    public int T() {
        return 163;
    }

    public boolean U() {
        return false;
    }

    @Override // ir.e
    public ir.e d() {
        return new k1();
    }

    @Override // ir.e
    public ir.g f(ir.i[] iVarArr, int i10, int i11) {
        long[] jArr = new long[i11 * 3 * 2];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            ir.i iVar = iVarArr[i10 + i13];
            rr.g.h(((h1) iVar.n()).f40229g, 0, jArr, i12);
            int i14 = i12 + 3;
            rr.g.h(((h1) iVar.o()).f40229g, 0, jArr, i14);
            i12 = i14 + 3;
        }
        return new a(i11, jArr);
    }

    @Override // ir.e
    public ir.i i(ir.f fVar, ir.f fVar2) {
        return new l1(this, fVar, fVar2);
    }

    @Override // ir.e
    public ir.i j(ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        return new l1(this, fVar, fVar2, fVarArr);
    }

    @Override // ir.e
    public ir.f n(BigInteger bigInteger) {
        return new h1(bigInteger);
    }

    @Override // ir.e
    public int v() {
        return 163;
    }

    @Override // ir.e
    public ir.i w() {
        return this.f40267r;
    }
}
