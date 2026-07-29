package lr;

import ir.e;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class o2 extends e.b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f40318s = 6;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ir.f[] f40319t = {new l2(ir.d.f35647b)};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public p2 f40320r;

    public class a extends ir.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f40321a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f40322b;

        public a(int i10, long[] jArr) {
            this.f40321a = i10;
            this.f40322b = jArr;
        }

        @Override // ir.g
        public ir.i a(int i10) {
            long[] jArrC = rr.l.c();
            long[] jArrC2 = rr.l.c();
            int i11 = 0;
            for (int i12 = 0; i12 < this.f40321a; i12++) {
                long j10 = ((i12 ^ i10) - 1) >> 31;
                for (int i13 = 0; i13 < 7; i13++) {
                    long j11 = jArrC[i13];
                    long[] jArr = this.f40322b;
                    jArrC[i13] = j11 ^ (jArr[i11 + i13] & j10);
                    jArrC2[i13] = jArrC2[i13] ^ (jArr[(i11 + 7) + i13] & j10);
                }
                i11 += 14;
            }
            return d(jArrC, jArrC2);
        }

        @Override // ir.a, ir.g
        public ir.i b(int i10) {
            long[] jArrC = rr.l.c();
            long[] jArrC2 = rr.l.c();
            int i11 = i10 * 7 * 2;
            for (int i12 = 0; i12 < 7; i12++) {
                long[] jArr = this.f40322b;
                jArrC[i12] = jArr[i11 + i12];
                jArrC2[i12] = jArr[i11 + 7 + i12];
            }
            return d(jArrC, jArrC2);
        }

        @Override // ir.g
        public int c() {
            return this.f40321a;
        }

        public final ir.i d(long[] jArr, long[] jArr2) {
            return o2.this.j(new l2(jArr), new l2(jArr2), o2.f40319t);
        }
    }

    public o2() {
        super(409, 87, 0, 0);
        this.f40320r = new p2(this, null, null);
        this.f35662b = n(BigInteger.valueOf(1L));
        this.f35663c = n(new BigInteger(1, jt.h.d("0021A5C2C8EE9FEB5C4B9A753B7B476B7FD6422EF1F3DD674761FA99D6AC27C8A9A197B272822F6CD57A55AA4F50AE317B13545F")));
        this.f35664d = new BigInteger(1, jt.h.d("010000000000000000000000000000000000000000000000000001E2AAD6A612F33307BE5FA47C3C9E052F838164CD37D9A21173"));
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
        return 87;
    }

    public int R() {
        return 0;
    }

    public int S() {
        return 0;
    }

    public int T() {
        return 409;
    }

    public boolean U() {
        return true;
    }

    @Override // ir.e
    public ir.e d() {
        return new o2();
    }

    @Override // ir.e
    public ir.g f(ir.i[] iVarArr, int i10, int i11) {
        long[] jArr = new long[i11 * 7 * 2];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            ir.i iVar = iVarArr[i10 + i13];
            rr.l.a(((l2) iVar.n()).f40279g, 0, jArr, i12);
            int i14 = i12 + 7;
            rr.l.a(((l2) iVar.o()).f40279g, 0, jArr, i14);
            i12 = i14 + 7;
        }
        return new a(i11, jArr);
    }

    @Override // ir.e
    public ir.i i(ir.f fVar, ir.f fVar2) {
        return new p2(this, fVar, fVar2);
    }

    @Override // ir.e
    public ir.i j(ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        return new p2(this, fVar, fVar2, fVarArr);
    }

    @Override // ir.e
    public ir.f n(BigInteger bigInteger) {
        return new l2(bigInteger);
    }

    @Override // ir.e
    public int v() {
        return 409;
    }

    @Override // ir.e
    public ir.i w() {
        return this.f40320r;
    }
}
