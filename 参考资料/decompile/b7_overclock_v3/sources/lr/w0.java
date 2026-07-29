package lr;

import ir.e;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class w0 extends e.b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f40401s = 6;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ir.f[] f40402t = {new v0(ir.d.f35647b)};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public x0 f40403r;

    public class a extends ir.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f40404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f40405b;

        public a(int i10, long[] jArr) {
            this.f40404a = i10;
            this.f40405b = jArr;
        }

        @Override // ir.g
        public ir.i a(int i10) {
            long[] jArrK = rr.e.k();
            long[] jArrK2 = rr.e.k();
            int i11 = 0;
            for (int i12 = 0; i12 < this.f40404a; i12++) {
                long j10 = ((i12 ^ i10) - 1) >> 31;
                for (int i13 = 0; i13 < 2; i13++) {
                    long j11 = jArrK[i13];
                    long[] jArr = this.f40405b;
                    jArrK[i13] = j11 ^ (jArr[i11 + i13] & j10);
                    jArrK2[i13] = jArrK2[i13] ^ (jArr[(i11 + 2) + i13] & j10);
                }
                i11 += 4;
            }
            return d(jArrK, jArrK2);
        }

        @Override // ir.a, ir.g
        public ir.i b(int i10) {
            long[] jArrK = rr.e.k();
            long[] jArrK2 = rr.e.k();
            int i11 = i10 * 2 * 2;
            for (int i12 = 0; i12 < 2; i12++) {
                long[] jArr = this.f40405b;
                jArrK[i12] = jArr[i11 + i12];
                jArrK2[i12] = jArr[i11 + 2 + i12];
            }
            return d(jArrK, jArrK2);
        }

        @Override // ir.g
        public int c() {
            return this.f40404a;
        }

        public final ir.i d(long[] jArr, long[] jArr2) {
            return w0.this.j(new v0(jArr), new v0(jArr2), w0.f40402t);
        }
    }

    public w0() {
        super(113, 9, 0, 0);
        this.f40403r = new x0(this, null, null);
        this.f35662b = n(new BigInteger(1, jt.h.d("003088250CA6E7C7FE649CE85820F7")));
        this.f35663c = n(new BigInteger(1, jt.h.d("00E8BEE4D3E2260744188BE0E9C723")));
        this.f35664d = new BigInteger(1, jt.h.d("0100000000000000D9CCEC8A39E56F"));
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
        return 9;
    }

    public int R() {
        return 0;
    }

    public int S() {
        return 0;
    }

    public int T() {
        return 113;
    }

    public boolean U() {
        return true;
    }

    @Override // ir.e
    public ir.e d() {
        return new w0();
    }

    @Override // ir.e
    public ir.g f(ir.i[] iVarArr, int i10, int i11) {
        long[] jArr = new long[i11 * 2 * 2];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            ir.i iVar = iVarArr[i10 + i13];
            rr.e.h(((v0) iVar.n()).f40392g, 0, jArr, i12);
            int i14 = i12 + 2;
            rr.e.h(((v0) iVar.o()).f40392g, 0, jArr, i14);
            i12 = i14 + 2;
        }
        return new a(i11, jArr);
    }

    @Override // ir.e
    public ir.i i(ir.f fVar, ir.f fVar2) {
        return new x0(this, fVar, fVar2);
    }

    @Override // ir.e
    public ir.i j(ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        return new x0(this, fVar, fVar2, fVarArr);
    }

    @Override // ir.e
    public ir.f n(BigInteger bigInteger) {
        return new v0(bigInteger);
    }

    @Override // ir.e
    public int v() {
        return 113;
    }

    @Override // ir.e
    public ir.i w() {
        return this.f40403r;
    }
}
