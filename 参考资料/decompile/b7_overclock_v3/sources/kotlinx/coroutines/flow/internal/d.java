package kotlinx.coroutines.flow.internal;

import ik.p;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.w0;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nChannelFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelFlow.kt\nkotlinx/coroutines/flow/internal/ChannelFlowKt\n+ 2 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,245:1\n95#2,5:246\n*S KotlinDebug\n*F\n+ 1 ChannelFlow.kt\nkotlinx/coroutines/flow/internal/ChannelFlowKt\n*L\n226#1:246,5\n*E\n"})
public final class d {
    @yt.k
    public static final <T> ChannelFlow<T> b(@yt.k kotlinx.coroutines.flow.e<? extends T> eVar) {
        ChannelFlow<T> channelFlow = eVar instanceof ChannelFlow ? (ChannelFlow) eVar : null;
        return channelFlow == null ? new e(eVar, null, 0, null, 14, null) : channelFlow;
    }

    @yt.l
    public static final <T, V> Object c(@yt.k CoroutineContext coroutineContext, V v10, @yt.k Object obj, @yt.k p<? super V, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, @yt.k kotlin.coroutines.c<? super T> cVar) {
        Object objC = ThreadContextKt.c(coroutineContext, obj);
        try {
            Object objR0 = ((p) w0.q(pVar, 2)).r0(v10, new n(cVar, coroutineContext));
            ThreadContextKt.a(coroutineContext, objC);
            if (objR0 == yj.b.h()) {
                zj.f.c(cVar);
            }
            return objR0;
        } catch (Throwable th2) {
            ThreadContextKt.a(coroutineContext, objC);
            throw th2;
        }
    }

    public static /* synthetic */ Object d(CoroutineContext coroutineContext, Object obj, Object obj2, p pVar, kotlin.coroutines.c cVar, int i10, Object obj3) {
        if ((i10 & 4) != 0) {
            obj2 = ThreadContextKt.b(coroutineContext);
        }
        return c(coroutineContext, obj, obj2, pVar, cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> kotlinx.coroutines.flow.f<T> e(kotlinx.coroutines.flow.f<? super T> fVar, CoroutineContext coroutineContext) {
        return fVar instanceof m ? true : fVar instanceof k ? fVar : new UndispatchedContextCollector(fVar, coroutineContext);
    }
}
