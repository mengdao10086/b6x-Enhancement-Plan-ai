package lr;

import ir.e;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class y1 extends e.b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f40428s = 6;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ir.f[] f40429t = {new v1(ir.d.f35647b)};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public z1 f40430r;

    public class a extends ir.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f40431a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f40432b;

        public a(int i10, long[] jArr) {
            this.f40431a = i10;
            this.f40432b = jArr;
        }

        @Override // ir.g
        public ir.i a(int i10) {
            long[] jArrM = rr.i.m();
            long[] jArrM2 = rr.i.m();
            int i11 = 0;
            for (int i12 = 0; i12 < this.f40431a; i12++) {
                long j10 = ((i12 ^ i10) - 1) >> 31;
                for (int i13 = 0; i13 < 4; i13++) {
                    long j11 = jArrM[i13];
                    long[] jArr = this.f40432b;
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
                long[] jArr = this.f40432b;
                jArrM[i12] = jArr[i11 + i12];
                jArrM2[i12] = jArr[i11 + 4 + i12];
            }
            return d(jArrM, jArrM2);
        }

        @Override // ir.g
        public int c() {
            return this.f40431a;
        }

        public final ir.i d(long[] jArr, long[] jArr2) {
            return y1.this.j(new v1(jArr), new v1(jArr2), y1.f40429t);
        }
    }

    public y1() {
        super(233, 74, 0, 0);
        this.f40430r = new z1(this, null, null);
        this.f35662b = n(BigInteger.valueOf(1L));
        this.f35663c = n(new BigInteger(1, jt.h.d("0066647EDE6C332C7F8C0923BB58213B333B20E9CE4281FE115F7D8F90AD")));
        this.f35664d = new BigInteger(1, jt.h.d("01000000000000000000000000000013E974E72F8A6922031D2603CFE0D7"));
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
        return 74;
    }

    public int R() {
        return 0;
    }

    public int S() {
        return 0;
    }

    public int T() {
        return 233;
    }

    public boolean U() {
        return true;
    }

    @Override // ir.e
    public ir.e d() {
        return new y1();
    }

    @Override // ir.e
    public ir.g f(ir.i[] iVarArr, int i10, int i11) {
        long[] jArr = new long[i11 * 4 * 2];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            ir.i iVar = iVarArr[i10 + i13];
            rr.i.j(((v1) iVar.n()).f40393g, 0, jArr, i12);
            int i14 = i12 + 4;
            rr.i.j(((v1) iVar.o()).f40393g, 0, jArr, i14);
            i12 = i14 + 4;
        }
        return new a(i11, jArr);
    }

    @Override // ir.e
    public ir.i i(ir.f fVar, ir.f fVar2) {
        return new z1(this, fVar, fVar2);
    }

    @Override // ir.e
    public ir.i j(ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        return new z1(this, fVar, fVar2, fVarArr);
    }

    @Override // ir.e
    public ir.f n(BigInteger bigInteger) {
        return new v1(bigInteger);
    }

    @Override // ir.e
    public int v() {
        return 233;
    }

    @Override // ir.e
    public ir.i w() {
        return this.f40430r;
    }
}
