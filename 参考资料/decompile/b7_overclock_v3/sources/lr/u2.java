package lr;

import ir.e;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class u2 extends e.b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f40384s = 6;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ir.f[] f40385t = {new r2(ir.d.f35647b)};

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final r2 f40386u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final r2 f40387v;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public v2 f40388r;

    public class a extends ir.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f40389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f40390b;

        public a(int i10, long[] jArr) {
            this.f40389a = i10;
            this.f40390b = jArr;
        }

        @Override // ir.g
        public ir.i a(int i10) {
            long[] jArrC = rr.n.c();
            long[] jArrC2 = rr.n.c();
            int i11 = 0;
            for (int i12 = 0; i12 < this.f40389a; i12++) {
                long j10 = ((i12 ^ i10) - 1) >> 31;
                for (int i13 = 0; i13 < 9; i13++) {
                    long j11 = jArrC[i13];
                    long[] jArr = this.f40390b;
                    jArrC[i13] = j11 ^ (jArr[i11 + i13] & j10);
                    jArrC2[i13] = jArrC2[i13] ^ (jArr[(i11 + 9) + i13] & j10);
                }
                i11 += 18;
            }
            return d(jArrC, jArrC2);
        }

        @Override // ir.a, ir.g
        public ir.i b(int i10) {
            long[] jArrC = rr.n.c();
            long[] jArrC2 = rr.n.c();
            int i11 = i10 * 9 * 2;
            for (int i12 = 0; i12 < 9; i12++) {
                long[] jArr = this.f40390b;
                jArrC[i12] = jArr[i11 + i12];
                jArrC2[i12] = jArr[i11 + 9 + i12];
            }
            return d(jArrC, jArrC2);
        }

        @Override // ir.g
        public int c() {
            return this.f40389a;
        }

        public final ir.i d(long[] jArr, long[] jArr2) {
            return u2.this.j(new r2(jArr), new r2(jArr2), u2.f40385t);
        }
    }

    static {
        r2 r2Var = new r2(new BigInteger(1, jt.h.d("02F40E7E2221F295DE297117B7F3D62F5C6A97FFCB8CEFF1CD6BA8CE4A9A18AD84FFABBD8EFA59332BE7AD6756A66E294AFD185A78FF12AA520E4DE739BACA0C7FFEFF7F2955727A")));
        f40386u = r2Var;
        f40387v = (r2) r2Var.o();
    }

    public u2() {
        super(571, 2, 5, 10);
        this.f40388r = new v2(this, null, null);
        this.f35662b = n(BigInteger.valueOf(1L));
        this.f35663c = f40386u;
        this.f35664d = new BigInteger(1, jt.h.d("03FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE661CE18FF55987308059B186823851EC7DD9CA1161DE93D5174D66E8382E9BB2FE84E47"));
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
        return 2;
    }

    public int R() {
        return 5;
    }

    public int S() {
        return 10;
    }

    public int T() {
        return 571;
    }

    public boolean U() {
        return false;
    }

    @Override // ir.e
    public ir.e d() {
        return new u2();
    }

    @Override // ir.e
    public ir.g f(ir.i[] iVarArr, int i10, int i11) {
        long[] jArr = new long[i11 * 9 * 2];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            ir.i iVar = iVarArr[i10 + i13];
            rr.n.a(((r2) iVar.n()).f40350g, 0, jArr, i12);
            int i14 = i12 + 9;
            rr.n.a(((r2) iVar.o()).f40350g, 0, jArr, i14);
            i12 = i14 + 9;
        }
        return new a(i11, jArr);
    }

    @Override // ir.e
    public ir.i i(ir.f fVar, ir.f fVar2) {
        return new v2(this, fVar, fVar2);
    }

    @Override // ir.e
    public ir.i j(ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        return new v2(this, fVar, fVar2, fVarArr);
    }

    @Override // ir.e
    public ir.f n(BigInteger bigInteger) {
        return new r2(bigInteger);
    }

    @Override // ir.e
    public int v() {
        return 571;
    }

    @Override // ir.e
    public ir.i w() {
        return this.f40388r;
    }
}
