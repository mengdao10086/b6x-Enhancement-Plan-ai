package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
public final class h {
    @yt.k
    public static final <T> u0<T> a(@yt.k o0 o0Var, @yt.k CoroutineContext coroutineContext, @yt.k CoroutineStart coroutineStart, @yt.k ik.p<? super o0, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar) {
        return j.a(o0Var, coroutineContext, coroutineStart, pVar);
    }

    @yt.l
    public static final <T> Object c(@yt.k CoroutineDispatcher coroutineDispatcher, @yt.k ik.p<? super o0, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, @yt.k kotlin.coroutines.c<? super T> cVar) {
        return j.c(coroutineDispatcher, pVar, cVar);
    }

    @yt.k
    public static final c2 d(@yt.k o0 o0Var, @yt.k CoroutineContext coroutineContext, @yt.k CoroutineStart coroutineStart, @yt.k ik.p<? super o0, ? super kotlin.coroutines.c<? super kotlin.z1>, ? extends Object> pVar) {
        return j.e(o0Var, coroutineContext, coroutineStart, pVar);
    }

    public static final <T> T f(@yt.k CoroutineContext coroutineContext, @yt.k ik.p<? super o0, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar) throws InterruptedException {
        return (T) i.a(coroutineContext, pVar);
    }

    @yt.l
    public static final <T> Object h(@yt.k CoroutineContext coroutineContext, @yt.k ik.p<? super o0, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, @yt.k kotlin.coroutines.c<? super T> cVar) throws Throwable {
        return j.g(coroutineContext, pVar, cVar);
    }
}
