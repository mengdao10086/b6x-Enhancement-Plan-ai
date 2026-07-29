package lr;

import ir.e;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class c2 extends e.b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f40168s = 6;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ir.f[] f40169t = {new b2(ir.d.f35647b)};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public d2 f40170r;

    public class a extends ir.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f40171a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f40172b;

        public a(int i10, long[] jArr) {
            this.f40171a = i10;
            this.f40172b = jArr;
        }

        @Override // ir.g
        public ir.i a(int i10) {
            long[] jArrM = rr.i.m();
            long[] jArrM2 = rr.i.m();
            int i11 = 0;
            for (int i12 = 0; i12 < this.f40171a; i12++) {
                long j10 = ((i12 ^ i10) - 1) >> 31;
                for (int i13 = 0; i13 < 4; i13++) {
                    long j11 = jArrM[i13];
                    long[] jArr = this.f40172b;
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
                long[] jArr = this.f40172b;
                jArrM[i12] = jArr[i11 + i12];
                jArrM2[i12] = jArr[i11 + 4 + i12];
            }
            return d(jArrM, jArrM2);
        }

        @Override // ir.g
        public int c() {
            return this.f40171a;
        }

        public final ir.i d(long[] jArr, long[] jArr2) {
            return c2.this.j(new b2(jArr), new b2(jArr2), c2.f40169t);
        }
    }

    public c2() {
        super(239, 158, 0, 0);
        this.f40170r = new d2(this, null, null);
        this.f35662b = n(BigInteger.valueOf(0L));
        this.f35663c = n(BigInteger.valueOf(1L));
        this.f35664d = new BigInteger(1, jt.h.d("2000000000000000000000000000005A79FEC67CB6E91F1C1DA800E478A5"));
        this.f35665e = BigInteger.valueOf(4L);
        this.f35666f = 6;
    }

    @Override // ir.e
    public boolean H(int i10) {
        return i10 == 6;
    }

    @Override // ir.e.b
    public boolean N() {
        return true;
    }

    public int Q() {
        return 158;
    }

    public int R() {
        return 0;
    }

    public int S() {
        return 0;
    }

    public int T() {
        return 239;
    }

    public boolean U() {
        return true;
    }

    @Override // ir.e
    public ir.e d() {
        return new c2();
    }

    @Override // ir.e
    public ir.g f(ir.i[] iVarArr, int i10, int i11) {
        long[] jArr = new long[i11 * 4 * 2];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            ir.i iVar = iVarArr[i10 + i13];
            rr.i.j(((b2) iVar.n()).f40157g, 0, jArr, i12);
            int i14 = i12 + 4;
            rr.i.j(((b2) iVar.o()).f40157g, 0, jArr, i14);
            i12 = i14 + 4;
        }
        return new a(i11, jArr);
    }

    @Override // ir.e
    public ir.h g() {
        return new ir.c0();
    }

    @Override // ir.e
    public ir.i i(ir.f fVar, ir.f fVar2) {
        return new d2(this, fVar, fVar2);
    }

    @Override // ir.e
    public ir.i j(ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        return new d2(this, fVar, fVar2, fVarArr);
    }

    @Override // ir.e
    public ir.f n(BigInteger bigInteger) {
        return new b2(bigInteger);
    }

    @Override // ir.e
    public int v() {
        return 239;
    }

    @Override // ir.e
    public ir.i w() {
        return this.f40170r;
    }
}
