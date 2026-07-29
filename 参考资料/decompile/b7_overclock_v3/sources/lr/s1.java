package lr;

import ir.e;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class s1 extends e.b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f40360s = 6;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ir.f[] f40361t = {new p1(ir.d.f35647b)};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public t1 f40362r;

    public class a extends ir.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f40363a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f40364b;

        public a(int i10, long[] jArr) {
            this.f40363a = i10;
            this.f40364b = jArr;
        }

        @Override // ir.g
        public ir.i a(int i10) {
            long[] jArrM = rr.i.m();
            long[] jArrM2 = rr.i.m();
            int i11 = 0;
            for (int i12 = 0; i12 < this.f40363a; i12++) {
                long j10 = ((i12 ^ i10) - 1) >> 31;
                for (int i13 = 0; i13 < 4; i13++) {
                    long j11 = jArrM[i13];
                    long[] jArr = this.f40364b;
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
                long j10 = jArrM[i12];
                long[] jArr = this.f40364b;
                jArrM[i12] = j10 ^ jArr[i11 + i12];
                jArrM2[i12] = jArrM2[i12] ^ jArr[(i11 + 4) + i12];
            }
            return d(jArrM, jArrM2);
        }

        @Override // ir.g
        public int c() {
            return this.f40363a;
        }

        public final ir.i d(long[] jArr, long[] jArr2) {
            return s1.this.j(new p1(jArr), new p1(jArr2), s1.f40361t);
        }
    }

    public s1() {
        super(s0.c.f49294u, 15, 0, 0);
        this.f40362r = new t1(this, null, null);
        this.f35662b = n(new BigInteger(1, jt.h.d("0163F35A5137C2CE3EA6ED8667190B0BC43ECD69977702709B")));
        this.f35663c = n(new BigInteger(1, jt.h.d("00C9BB9E8927D4D64C377E2AB2856A5B16E3EFB7F61D4316AE")));
        this.f35664d = new BigInteger(1, jt.h.d("010000000000000000000000015AAB561B005413CCD4EE99D5"));
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
        return new s1();
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
        return new t1(this, fVar, fVar2);
    }

    @Override // ir.e
    public ir.i j(ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        return new t1(this, fVar, fVar2, fVarArr);
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
        return this.f40362r;
    }
}
