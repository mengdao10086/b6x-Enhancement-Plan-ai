package kotlinx.coroutines;

/* JADX INFO: loaded from: classes5.dex */
public final class o1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f38915b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f38916c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f38917d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f38918e = 1000000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f38919f = 9223372036854L;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f38920g = 4611686018427387903L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final kotlinx.coroutines.internal.o0 f38914a = new kotlinx.coroutines.internal.o0("REMOVED_TASK");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public static final kotlinx.coroutines.internal.o0 f38921h = new kotlinx.coroutines.internal.o0("CLOSED_EMPTY");

    public static final long c(long j10) {
        return j10 / 1000000;
    }

    public static final long d(long j10) {
        if (j10 <= 0) {
            return 0L;
        }
        if (j10 >= f38919f) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j10;
    }
}
