package lr;

import ir.e;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class s2 extends e.b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f40366s = 6;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ir.f[] f40367t = {new r2(ir.d.f35647b)};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public t2 f40368r;

    public class a extends ir.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f40369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f40370b;

        public a(int i10, long[] jArr) {
            this.f40369a = i10;
            this.f40370b = jArr;
        }

        @Override // ir.g
        public ir.i a(int i10) {
            long[] jArrC = rr.n.c();
            long[] jArrC2 = rr.n.c();
            int i11 = 0;
            for (int i12 = 0; i12 < this.f40369a; i12++) {
                long j10 = ((i12 ^ i10) - 1) >> 31;
                for (int i13 = 0; i13 < 9; i13++) {
                    long j11 = jArrC[i13];
                    long[] jArr = this.f40370b;
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
                long[] jArr = this.f40370b;
                jArrC[i12] = jArr[i11 + i12];
                jArrC2[i12] = jArr[i11 + 9 + i12];
            }
            return d(jArrC, jArrC2);
        }

        @Override // ir.g
        public int c() {
            return this.f40369a;
        }

        public final ir.i d(long[] jArr, long[] jArr2) {
            return s2.this.j(new r2(jArr), new r2(jArr2), s2.f40367t);
        }
    }

    public s2() {
        super(571, 2, 5, 10);
        this.f40368r = new t2(this, null, null);
        this.f35662b = n(BigInteger.valueOf(0L));
        this.f35663c = n(BigInteger.valueOf(1L));
        this.f35664d = new BigInteger(1, jt.h.d("020000000000000000000000000000000000000000000000000000000000000000000000131850E1F19A63E4B391A8DB917F4138B630D84BE5D639381E91DEB45CFE778F637C1001"));
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
        return new s2();
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
    public ir.h g() {
        return new ir.c0();
    }

    @Override // ir.e
    public ir.i i(ir.f fVar, ir.f fVar2) {
        return new t2(this, fVar, fVar2);
    }

    @Override // ir.e
    public ir.i j(ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        return new t2(this, fVar, fVar2, fVarArr);
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
        return this.f40368r;
    }
}
