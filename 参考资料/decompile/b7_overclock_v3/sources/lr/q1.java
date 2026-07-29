package lr;

import ir.e;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class q1 extends e.b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f40340s = 6;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ir.f[] f40341t = {new p1(ir.d.f35647b)};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public r1 f40342r;

    public class a extends ir.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f40343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f40344b;

        public a(int i10, long[] jArr) {
            this.f40343a = i10;
            this.f40344b = jArr;
        }

        @Override // ir.g
        public ir.i a(int i10) {
            long[] jArrM = rr.i.m();
            long[] jArrM2 = rr.i.m();
            int i11 = 0;
            for (int i12 = 0; i12 < this.f40343a; i12++) {
                long j10 = ((i12 ^ i10) - 1) >> 31;
                for (int i13 = 0; i13 < 4; i13++) {
                    long j11 = jArrM[i13];
                    long[] jArr = this.f40344b;
                    jArrM[i13] = j11 ^ (jArr[i11 + i13] & j10);
                    jArrM2[i13] = jArrM2[i13] ^ (jArr[(i11 + 4) + i13] & j10);
                }
                i11 += 8;
            }
            return d(jArrM, jArrM2);
        }

        @Override // ir.a, ir.g
        public ir.i b(int i10) {
            long[] jArrM = rr.i.m();
            long[] jArrM2 = rr.i.m();
            int i11 = i10 * 4 * 2;
            for (int i12 = 0; i12 < 4; i12++) {
                long[] jArr = this.f40344b;
                jArrM[i12] = jArr[i11 + i12];
                jArrM2[i12] = jArr[i11 + 4 + i12];
            }
            return d(jArrM, jArrM2);
        }

        @Override // ir.g
        public int c() {
            return this.f40343a;
        }

        public final ir.i d(long[] jArr, long[] jArr2) {
            return q1.this.j(new p1(jArr), new p1(jArr2), q1.f40341t);
        }
    }

    public q1() {
        super(s0.c.f49294u, 15, 0, 0);
        this.f40342r = new r1(this, null, null);
        this.f35662b = n(new BigInteger(1, jt.h.d("0017858FEB7A98975169E171F77B4087DE098AC8A911DF7B01")));
        this.f35663c = n(new BigInteger(1, jt.h.d("00FDFB49BFE6C3A89FACADAA7A1E5BBC7CC1C2E5D831478814")));
        this.f35664d = new BigInteger(1, jt.h.d("01000000000000000000000000C7F34A778F443ACC920EBA49"));
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
        return 15;
    }

    public int R() {
        return 0;
    }

    public int S() {
        return 0;
    }

    public int T() {
        return s0.c.f49294u;
    }

    public boolean U() {
        return true;
    }

    @Override // ir.e
    public ir.e d() {
        return new q1();
    }

    @Override // ir.e
    public ir.g f(ir.i[] iVarArr, int i10, int i11) {
        long[] jArr = new long[i11 * 4 * 2];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            ir.i iVar = iVarArr[i10 + i13];
            rr.i.j(((p1) iVar.n()).f40330g, 0, jArr, i12);
            int i14 = i12 + 4;
            rr.i.j(((p1) iVar.o()).f40330g, 0, jArr, i14);
            i12 = i14 + 4;
        }
        return new a(i11, jArr);
    }

    @Override // ir.e
    public ir.i i(ir.f fVar, ir.f fVar2) {
        return new r1(this, fVar, fVar2);
    }

    @Override // ir.e
    public ir.i j(ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        return new r1(this, fVar, fVar2, fVarArr);
    }

    @Override // ir.e
    public ir.f n(BigInteger bigInteger) {
        return new p1(bigInteger);
    }

    @Override // ir.e
    public int v() {
        return s0.c.f49294u;
    }

    @Override // ir.e
    public ir.i w() {
        return this.f40342r;
    }
}
