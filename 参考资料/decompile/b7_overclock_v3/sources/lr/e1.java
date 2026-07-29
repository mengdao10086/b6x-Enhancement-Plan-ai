package lr;

import ir.e;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class e1 extends e.b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f40188s = 6;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ir.f[] f40189t = {new b1(ir.d.f35647b)};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public f1 f40190r;

    public class a extends ir.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f40191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f40192b;

        public a(int i10, long[] jArr) {
            this.f40191a = i10;
            this.f40192b = jArr;
        }

        @Override // ir.g
        public ir.i a(int i10) {
            long[] jArrK = rr.g.k();
            long[] jArrK2 = rr.g.k();
            int i11 = 0;
            for (int i12 = 0; i12 < this.f40191a; i12++) {
                long j10 = ((i12 ^ i10) - 1) >> 31;
                for (int i13 = 0; i13 < 3; i13++) {
                    long j11 = jArrK[i13];
                    long[] jArr = this.f40192b;
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
                long[] jArr = this.f40192b;
                jArrK[i12] = jArr[i11 + i12];
                jArrK2[i12] = jArr[i11 + 3 + i12];
            }
            return d(jArrK, jArrK2);
        }

        @Override // ir.g
        public int c() {
            return this.f40191a;
        }

        public final ir.i d(long[] jArr, long[] jArr2) {
            return e1.this.j(new b1(jArr), new b1(jArr2), e1.f40189t);
        }
    }

    public e1() {
        super(131, 2, 3, 8);
        this.f40190r = new f1(this, null, null);
        this.f35662b = n(new BigInteger(1, jt.h.d("03E5A88919D7CAFCBF415F07C2176573B2")));
        this.f35663c = n(new BigInteger(1, jt.h.d("04B8266A46C55657AC734CE38F018F2192")));
        this.f35664d = new BigInteger(1, jt.h.d("0400000000000000016954A233049BA98F"));
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
        return new e1();
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
        return new f1(this, fVar, fVar2);
    }

    @Override // ir.e
    public ir.i j(ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        return new f1(this, fVar, fVar2, fVarArr);
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
        return this.f40190r;
    }
}
