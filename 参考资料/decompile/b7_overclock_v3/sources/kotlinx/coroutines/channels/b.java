package kotlinx.coroutines.channels;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.z1;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.r2;

/* JADX INFO: loaded from: classes5.dex */
public final class b {
    @r2
    @yt.k
    public static final <E> s<E> a(@yt.k o0 o0Var, @yt.k CoroutineContext coroutineContext, int i10, @yt.k CoroutineStart coroutineStart, @yt.l ik.l<? super Throwable, z1> lVar, @yt.k ik.p<? super c<E>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar) {
        CoroutineContext coroutineContextE = CoroutineContextKt.e(o0Var, coroutineContext);
        g gVarD = i.d(i10, null, null, 6, null);
        a lazyActorCoroutine = coroutineStart.isLazy() ? new LazyActorCoroutine(coroutineContextE, gVarD, pVar) : new a(coroutineContextE, gVarD, true);
        if (lVar != null) {
            ((JobSupport) lazyActorCoroutine).L1(lVar);
        }
        ((kotlinx.coroutines.a) lazyActorCoroutine).I1(coroutineStart, lazyActorCoroutine, pVar);
        return (s<E>) lazyActorCoroutine;
    }

    public static /* synthetic */ s b(o0 o0Var, CoroutineContext coroutineContext, int i10, CoroutineStart coroutineStart, ik.l lVar, ik.p pVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f37755a;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        int i12 = (i11 & 2) != 0 ? 0 : i10;
        if ((i11 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i11 & 8) != 0) {
            lVar = null;
        }
        return a(o0Var, coroutineContext2, i12, coroutineStart2, lVar, pVar);
    }
}
