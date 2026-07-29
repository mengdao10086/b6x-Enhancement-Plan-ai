package kotlinx.coroutines.internal;

/* JADX INFO: loaded from: classes5.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38836a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f38837b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f38838c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final Object f38839d = new o0("CONDITION_FALSE");

    @yt.k
    public static final Object a() {
        return f38839d;
    }

    @kotlin.s0
    public static /* synthetic */ void b() {
    }

    @kotlin.s0
    public static /* synthetic */ void c() {
    }

    @kotlin.s0
    public static /* synthetic */ void d() {
    }

    @kotlin.s0
    public static /* synthetic */ void e() {
    }

    @kotlin.s0
    @yt.k
    public static final LockFreeLinkedListNode f(@yt.k Object obj) {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        i0 i0Var = obj instanceof i0 ? (i0) obj : null;
        if (i0Var != null && (lockFreeLinkedListNode = i0Var.f38802a) != null) {
            return lockFreeLinkedListNode;
        }
        kotlin.jvm.internal.f0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        return (LockFreeLinkedListNode) obj;
    }
}
