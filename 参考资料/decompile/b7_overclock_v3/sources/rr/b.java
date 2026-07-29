package rr;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f49129a = 1431655765;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f49130b = 6148914691236517205L;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f49131c = -6148914691236517206L;

    public static int a(int i10) {
        int i11 = i10 & 65535;
        int i12 = (i11 | (i11 << 8)) & 16711935;
        int i13 = (i12 | (i12 << 4)) & 252645135;
        int i14 = (i13 | (i13 << 2)) & 858993459;
        return (i14 | (i14 << 1)) & 1431655765;
    }

    public static long b(int i10) {
        int iA = a.a(a.a(a.a(a.a(i10, 65280, 8), 15728880, 4), 202116108, 2), 572662306, 1);
        return ((((long) (iA >>> 1)) & f49129a) << 32) | (f49129a & ((long) iA));
    }

    public static void c(long j10, long[] jArr, int i10) {
        long jB = a.b(a.b(a.b(a.b(a.b(j10, 4294901760L, 16), 280375465148160L, 8), 67555025218437360L, 4), 868082074056920076L, 2), 2459565876494606882L, 1);
        jArr[i10] = jB & f49130b;
        jArr[i10 + 1] = (jB >>> 1) & f49130b;
    }

    public static void d(long[] jArr, int i10, int i11, long[] jArr2, int i12) {
        for (int i13 = 0; i13 < i11; i13++) {
            c(jArr[i10 + i13], jArr2, i12);
            i12 += 2;
        }
    }

    public static void e(long j10, long[] jArr, int i10) {
        long jB = a.b(a.b(a.b(a.b(a.b(j10, 4294901760L, 16), 280375465148160L, 8), 67555025218437360L, 4), 868082074056920076L, 2), 2459565876494606882L, 1);
        jArr[i10] = jB & f49131c;
        jArr[i10 + 1] = (jB << 1) & f49131c;
    }

    public static int f(int i10) {
        int i11 = i10 & 255;
        int i12 = (i11 | (i11 << 4)) & 3855;
        int i13 = (i12 | (i12 << 2)) & 13107;
        return (i13 | (i13 << 1)) & 21845;
    }

    public static int g(int i10) {
        return a.a(a.a(a.a(a.a(i10, 65280, 8), 15728880, 4), 202116108, 2), 572662306, 1);
    }

    public static long h(long j10) {
        return a.b(a.b(a.b(a.b(a.b(j10, 4294901760L, 16), 280375465148160L, 8), 67555025218437360L, 4), 868082074056920076L, 2), 2459565876494606882L, 1);
    }

    public static int i(int i10) {
        return a.a(a.a(a.a(a.a(i10, 11141290, 7), 52428, 14), 15728880, 4), 65280, 8);
    }

    public static long j(long j10) {
        return a.b(a.b(a.b(a.b(j10, 4278255360L, 24), 57421771435671756L, 6), 264913582878960L, 12), 723401728380766730L, 3);
    }

    public static long k(long j10) {
        return a.b(a.b(a.b(j10, 47851476196393130L, 7), 225176545447116L, 14), 4042322160L, 28);
    }

    public static int l(int i10) {
        return a.a(a.a(a.a(a.a(i10, 572662306, 1), 202116108, 2), 15728880, 4), 65280, 8);
    }

    public static long m(long j10) {
        return a.b(a.b(a.b(a.b(a.b(j10, 2459565876494606882L, 1), 868082074056920076L, 2), 67555025218437360L, 4), 280375465148160L, 8), 4294901760L, 16);
    }

    public static int n(int i10) {
        return a.a(a.a(a.a(a.a(i10, 65280, 8), 15728880, 4), 52428, 14), 11141290, 7);
    }

    public static long o(long j10) {
        return a.b(a.b(a.b(a.b(j10, 723401728380766730L, 3), 264913582878960L, 12), 57421771435671756L, 6), 4278255360L, 24);
    }

    public static long p(long j10) {
        return k(j10);
    }
}
