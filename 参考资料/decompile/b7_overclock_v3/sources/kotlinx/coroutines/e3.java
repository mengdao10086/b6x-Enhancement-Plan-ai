package kotlinx.coroutines;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/ThreadLocalEventLoop\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,543:1\n1#2:544\n*E\n"})
public final class e3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final e3 f38471a = new e3();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final ThreadLocal<k1> f38472b = kotlinx.coroutines.internal.w0.b(new kotlinx.coroutines.internal.o0("ThreadLocalEventLoop"));

    @yt.l
    public final k1 a() {
        return f38472b.get();
    }

    @yt.k
    public final k1 b() {
        ThreadLocal<k1> threadLocal = f38472b;
        k1 k1Var = threadLocal.get();
        if (k1Var != null) {
            return k1Var;
        }
        k1 k1VarA = n1.a();
        threadLocal.set(k1VarA);
        return k1VarA;
    }

    public final void c() {
        f38472b.set(null);
    }

    public final void d(@yt.k k1 k1Var) {
        f38472b.set(k1Var);
    }
}
