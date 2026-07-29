package kotlinx.coroutines;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nThreadContextElement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThreadContextElement.kt\nkotlinx/coroutines/ThreadContextElementKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,288:1\n266#1:289\n1#2:290\n*S KotlinDebug\n*F\n+ 1 ThreadContextElement.kt\nkotlinx/coroutines/ThreadContextElementKt\n*L\n287#1:289\n*E\n"})
public final class d3 {
    @yt.k
    public static final <T> c3<T> a(@yt.k ThreadLocal<T> threadLocal, T t10) {
        return new kotlinx.coroutines.internal.u0(t10, threadLocal);
    }

    public static /* synthetic */ c3 b(ThreadLocal threadLocal, Object obj, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            obj = threadLocal.get();
        }
        return a(threadLocal, obj);
    }

    @yt.l
    public static final Object c(@yt.k ThreadLocal<?> threadLocal, @yt.k kotlin.coroutines.c<? super kotlin.z1> cVar) {
        if (cVar.b().c(new kotlinx.coroutines.internal.v0(threadLocal)) != null) {
            return kotlin.z1.f38230a;
        }
        throw new IllegalStateException(("ThreadLocal " + threadLocal + " is missing from context " + cVar.b()).toString());
    }

    public static final Object d(ThreadLocal<?> threadLocal, kotlin.coroutines.c<? super kotlin.z1> cVar) {
        kotlin.jvm.internal.c0.e(3);
        throw null;
    }

    @yt.l
    public static final Object e(@yt.k ThreadLocal<?> threadLocal, @yt.k kotlin.coroutines.c<? super Boolean> cVar) {
        return zj.a.a(cVar.b().c(new kotlinx.coroutines.internal.v0(threadLocal)) != null);
    }

    public static final Object f(ThreadLocal<?> threadLocal, kotlin.coroutines.c<? super Boolean> cVar) {
        kotlin.jvm.internal.c0.e(3);
        throw null;
    }
}
