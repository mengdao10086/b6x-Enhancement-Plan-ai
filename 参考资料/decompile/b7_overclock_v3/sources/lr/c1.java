package lr;

import ir.e;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class c1 extends e.b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f40162s = 6;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ir.f[] f40163t = {new b1(ir.d.f35647b)};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public d1 f40164r;

    public class a extends ir.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f40165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f40166b;

        public a(int i10, long[] jArr) {
            this.f40165a = i10;
            this.f40166b = jArr;
        }

        @Override // ir.g
        public ir.i a(int i10) {
            long[] jArrK = rr.g.k();
            long[] jArrK2 = rr.g.k();
            int i11 = 0;
            for (int i12 = 0; i12 < this.f40165a; i12++) {
                long j10 = ((i12 ^ i10) - 1) >> 31;
                for (int i13 = 0; i13 < 3; i13++) {
                    long j11 = jArrK[i13];
                    long[] jArr = this.f40166b;
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
                long[] jArr = this.f40166b;
                jArrK[i12] = jArr[i11 + i12];
                jArrK2[i12] = jArr[i11 + 3 + i12];
            }
            return d(jArrK, jArrK2);
        }

        @Override // ir.g
        public int c() {
            return this.f40165a;
        }

        public final ir.i d(long[] jArr, long[] jArr2) {
            return c1.this.j(new b1(jArr), new b1(jArr2), c1.f40163t);
        }
    }

    public c1() {
        super(131, 2, 3, 8);
        this.f40164r = new d1(this, null, null);
        this.f35662b = n(new BigInteger(1, jt.h.d("07A11B09A76B562144418FF3FF8C2570B8")));
        this.f35663c = n(new BigInteger(1, jt.h.d("0217C05610884B63B9C6C7291678F9D341")));
        this.f35664d = new BigInteger(1, jt.h.d("0400000000000000023123953A9464B54D"));
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
        return 3;
    }

    public int S() {
        return 8;
    }

    public int T() {
        return 131;
    }

    public boolean U() {
        return false;
    }

    @Override // ir.e
    public ir.e d() {
        return new c1();
    }

    @Override // ir.e
    public ir.g f(ir.i[] iVarArr, int i10, int i11) {
        long[] jArr = new long[i11 * 3 * 2];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            ir.i iVar = iVarArr[i10 + i13];
            rr.g.h(((b1) iVar.n()).f40156g, 0, jArr, i12);
            int i14 = i12 + 3;
            rr.g.h(((b1) iVar.o()).f40156g, 0, jArr, i14);
            i12 = i14 + 3;
        }
        return new a(i11, jArr);
    }

    @Override // ir.e
    public ir.i i(ir.f fVar, ir.f fVar2) {
        return new d1(this, fVar, fVar2);
    }

    @Override // ir.e
    public ir.i j(ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        return new d1(this, fVar, fVar2, fVarArr);
    }

    @Override // ir.e
    public ir.f n(BigInteger bigInteger) {
        return new b1(bigInteger);
    }

    @Override // ir.e
    public int v() {
        return 131;
    }

    @Override // ir.e
    public ir.i w() {
        return this.f40164r;
    }
}
