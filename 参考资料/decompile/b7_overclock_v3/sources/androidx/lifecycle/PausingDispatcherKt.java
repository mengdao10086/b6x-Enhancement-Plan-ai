package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes2.dex */
public final class PausingDispatcherKt {
    @kotlin.k(message = "whenCreated has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withCreated for non-suspending work that needs to run only once when the Lifecycle changes.")
    @yt.l
    public static final <T> Object a(@yt.k Lifecycle lifecycle, @yt.k ik.p<? super kotlinx.coroutines.o0, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, @yt.k kotlin.coroutines.c<? super T> cVar) {
        return g(lifecycle, Lifecycle.State.CREATED, pVar, cVar);
    }

    @kotlin.k(message = "whenCreated has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withCreated for non-suspending work that needs to run only once when the Lifecycle changes.")
    @yt.l
    public static final <T> Object b(@yt.k y yVar, @yt.k ik.p<? super kotlinx.coroutines.o0, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, @yt.k kotlin.coroutines.c<? super T> cVar) {
        return a(yVar.e(), pVar, cVar);
    }

    @kotlin.k(message = "whenResumed has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withResumed for non-suspending work that needs to run only once when the Lifecycle changes.")
    @yt.l
    public static final <T> Object c(@yt.k Lifecycle lifecycle, @yt.k ik.p<? super kotlinx.coroutines.o0, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, @yt.k kotlin.coroutines.c<? super T> cVar) {
        return g(lifecycle, Lifecycle.State.RESUMED, pVar, cVar);
    }

    @kotlin.k(message = "whenResumed has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withResumed for non-suspending work that needs to run only once when the Lifecycle changes.")
    @yt.l
    public static final <T> Object d(@yt.k y yVar, @yt.k ik.p<? super kotlinx.coroutines.o0, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, @yt.k kotlin.coroutines.c<? super T> cVar) {
        return c(yVar.e(), pVar, cVar);
    }

    @kotlin.k(message = "whenStarted has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withStarted for non-suspending work that needs to run only once when the Lifecycle changes.")
    @yt.l
    public static final <T> Object e(@yt.k Lifecycle lifecycle, @yt.k ik.p<? super kotlinx.coroutines.o0, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, @yt.k kotlin.coroutines.c<? super T> cVar) {
        return g(lifecycle, Lifecycle.State.STARTED, pVar, cVar);
    }

    @kotlin.k(message = "whenStarted has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withStarted for non-suspending work that needs to run only once when the Lifecycle changes.")
    @yt.l
    public static final <T> Object f(@yt.k y yVar, @yt.k ik.p<? super kotlinx.coroutines.o0, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, @yt.k kotlin.coroutines.c<? super T> cVar) {
        return e(yVar.e(), pVar, cVar);
    }

    @kotlin.k(message = "whenStateAtLeast has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withStateAtLeast for non-suspending work that needs to run only once when the Lifecycle changes.")
    @yt.l
    public static final <T> Object g(@yt.k Lifecycle lifecycle, @yt.k Lifecycle.State state, @yt.k ik.p<? super kotlinx.coroutines.o0, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, @yt.k kotlin.coroutines.c<? super T> cVar) {
        return kotlinx.coroutines.h.h(kotlinx.coroutines.d1.e().o2(), new PausingDispatcherKt$whenStateAtLeast$2(lifecycle, state, pVar, null), cVar);
    }
}
