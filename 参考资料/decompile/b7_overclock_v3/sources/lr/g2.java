package lr;

import ir.e;
import java.math.BigInteger;
import no.nordicsemi.android.dfu.DfuBaseService;

/* JADX INFO: loaded from: classes6.dex */
public class g2 extends e.b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f40216s = 6;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ir.f[] f40217t = {new f2(ir.d.f35647b)};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public h2 f40218r;

    public class a extends ir.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f40219a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f40220b;

        public a(int i10, long[] jArr) {
            this.f40219a = i10;
            this.f40220b = jArr;
        }

        @Override // ir.g
        public ir.i a(int i10) {
            long[] jArrC = rr.j.c();
            long[] jArrC2 = rr.j.c();
            int i11 = 0;
            for (int i12 = 0; i12 < this.f40219a; i12++) {
                long j10 = ((i12 ^ i10) - 1) >> 31;
                for (int i13 = 0; i13 < 5; i13++) {
                    long j11 = jArrC[i13];
                    long[] jArr = this.f40220b;
                    jArrC[i13] = j11 ^ (jArr[i11 + i13] & j10);
                    jArrC2[i13] = jArrC2[i13] ^ (jArr[(i11 + 5) + i13] & j10);
                }
                i11 += 10;
            }
            return d(jArrC, jArrC2);
        }

        @Override // ir.a, ir.g
        public ir.i b(int i10) {
            long[] jArrC = rr.j.c();
            long[] jArrC2 = rr.j.c();
            int i11 = i10 * 5 * 2;
            for (int i12 = 0; i12 < 5; i12++) {
                long[] jArr = this.f40220b;
                jArrC[i12] = jArr[i11 + i12];
                jArrC2[i12] = jArr[i11 + 5 + i12];
            }
            return d(jArrC, jArrC2);
        }

        @Override // ir.g
        public int c() {
            return this.f40219a;
        }

        public final ir.i d(long[] jArr, long[] jArr2) {
            return g2.this.j(new f2(jArr), new f2(jArr2), g2.f40217t);
        }
    }

    public g2() {
        super(DfuBaseService.NOTIFICATION_ID, 5, 7, 12);
        this.f40218r = new h2(this, null, null);
        this.f35662b = n(BigInteger.valueOf(0L));
        this.f35663c = n(BigInteger.valueOf(1L));
        this.f35664d = new BigInteger(1, jt.h.d("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE9AE2ED07577265DFF7F94451E061E163C61"));
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
        return 5;
    }

    public int R() {
        return 7;
    }

    public int S() {
        return 12;
    }

    public int T() {
        return DfuBaseService.NOTIFICATION_ID;
    }

    public boolean U() {
        return false;
    }

    @Override // ir.e
    public ir.e d() {
        return new g2();
    }

    @Override // ir.e
    public ir.g f(ir.i[] iVarArr, int i10, int i11) {
        long[] jArr = new long[i11 * 5 * 2];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            ir.i iVar = iVarArr[i10 + i13];
            rr.j.a(((f2) iVar.n()).f40203g, 0, jArr, i12);
            int i14 = i12 + 5;
            rr.j.a(((f2) iVar.o()).f40203g, 0, jArr, i14);
            i12 = i14 + 5;
        }
        return new a(i11, jArr);
    }

    @Override // ir.e
    public ir.h g() {
        return new ir.c0();
    }

    @Override // ir.e
    public ir.i i(ir.f fVar, ir.f fVar2) {
        return new h2(this, fVar, fVar2);
    }

    @Override // ir.e
    public ir.i j(ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        return new h2(this, fVar, fVar2, fVarArr);
    }

    @Override // ir.e
    public ir.f n(BigInteger bigInteger) {
        return new f2(bigInteger);
    }

    @Override // ir.e
    public int v() {
        return DfuBaseService.NOTIFICATION_ID;
    }

    @Override // ir.e
    public ir.i w() {
        return this.f40218r;
    }
}
