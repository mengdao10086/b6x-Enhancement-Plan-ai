package androidx.lifecycle;

import java.time.Duration;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import q1.b;

/* JADX INFO: loaded from: classes2.dex */
@hk.h(name = "FlowLiveDataConversions")
public final class FlowLiveDataConversions {
    @yt.k
    public static final <T> kotlinx.coroutines.flow.e<T> a(@yt.k LiveData<T> liveData) {
        kotlin.jvm.internal.f0.p(liveData, "<this>");
        return kotlinx.coroutines.flow.g.W(kotlinx.coroutines.flow.g.s(new FlowLiveDataConversions$asFlow$1(liveData, null)));
    }

    @hk.i
    @yt.k
    public static final <T> LiveData<T> b(@yt.k kotlinx.coroutines.flow.e<? extends T> eVar) {
        kotlin.jvm.internal.f0.p(eVar, "<this>");
        return f(eVar, null, 0L, 3, null);
    }

    @hk.i
    @yt.k
    public static final <T> LiveData<T> c(@yt.k kotlinx.coroutines.flow.e<? extends T> eVar, @yt.k CoroutineContext context) {
        kotlin.jvm.internal.f0.p(eVar, "<this>");
        kotlin.jvm.internal.f0.p(context, "context");
        return f(eVar, context, 0L, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @hk.i
    @yt.k
    public static final <T> LiveData<T> d(@yt.k kotlinx.coroutines.flow.e<? extends T> eVar, @yt.k CoroutineContext context, long j10) {
        kotlin.jvm.internal.f0.p(eVar, "<this>");
        kotlin.jvm.internal.f0.p(context, "context");
        b.a aVar = (LiveData<T>) CoroutineLiveDataKt.b(context, j10, new FlowLiveDataConversions$asLiveData$1(eVar, null));
        if (eVar instanceof kotlinx.coroutines.flow.u) {
            if (n.c.h().c()) {
                aVar.r(((kotlinx.coroutines.flow.u) eVar).getValue());
            } else {
                aVar.o(((kotlinx.coroutines.flow.u) eVar).getValue());
            }
        }
        return aVar;
    }

    @yt.k
    @g.v0(26)
    public static final <T> LiveData<T> e(@yt.k kotlinx.coroutines.flow.e<? extends T> eVar, @yt.k CoroutineContext context, @yt.k Duration timeout) {
        kotlin.jvm.internal.f0.p(eVar, "<this>");
        kotlin.jvm.internal.f0.p(context, "context");
        kotlin.jvm.internal.f0.p(timeout, "timeout");
        return d(eVar, context, c.f6174a.a(timeout));
    }

    public static /* synthetic */ LiveData f(kotlinx.coroutines.flow.e eVar, CoroutineContext coroutineContext, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f37755a;
        }
        if ((i10 & 2) != 0) {
            j10 = 5000;
        }
        return d(eVar, coroutineContext, j10);
    }

    public static /* synthetic */ LiveData g(kotlinx.coroutines.flow.e eVar, CoroutineContext coroutineContext, Duration duration, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f37755a;
        }
        return e(eVar, coroutineContext, duration);
    }
}
