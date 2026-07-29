package kotlinx.coroutines;

/* JADX INFO: loaded from: classes5.dex */
public final class j2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f38880e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f38881f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f38882g = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final kotlinx.coroutines.internal.o0 f38876a = new kotlinx.coroutines.internal.o0("COMPLETING_ALREADY");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final kotlinx.coroutines.internal.o0 f38877b = new kotlinx.coroutines.internal.o0("COMPLETING_WAITING_CHILDREN");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static final kotlinx.coroutines.internal.o0 f38878c = new kotlinx.coroutines.internal.o0("COMPLETING_RETRY");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final kotlinx.coroutines.internal.o0 f38879d = new kotlinx.coroutines.internal.o0("TOO_LATE_TO_CANCEL");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public static final kotlinx.coroutines.internal.o0 f38883h = new kotlinx.coroutines.internal.o0("SEALED");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.k
    public static final j1 f38884i = new j1(false);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @yt.k
    public static final j1 f38885j = new j1(true);

    @yt.l
    public static final Object g(@yt.l Object obj) {
        return obj instanceof w1 ? new x1((w1) obj) : obj;
    }

    @yt.l
    public static final Object h(@yt.l Object obj) {
        w1 w1Var;
        x1 x1Var = obj instanceof x1 ? (x1) obj : null;
        return (x1Var == null || (w1Var = x1Var.f39081a) == null) ? obj : w1Var;
    }
}
