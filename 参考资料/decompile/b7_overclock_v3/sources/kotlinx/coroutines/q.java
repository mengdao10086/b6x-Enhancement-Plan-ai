package kotlinx.coroutines;

/* JADX INFO: loaded from: classes5.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38930a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f38931b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f38932c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f38933d = 29;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f38934e = 536870911;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f38935f = 536870911;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final kotlinx.coroutines.internal.o0 f38936g = new kotlinx.coroutines.internal.o0("RESUME_TOKEN");

    public static final int a(int i10, int i11) {
        return (i10 << 29) + i11;
    }

    public static final int b(int i10) {
        return i10 >> 29;
    }

    public static final int c(int i10) {
        return i10 & 536870911;
    }
}
