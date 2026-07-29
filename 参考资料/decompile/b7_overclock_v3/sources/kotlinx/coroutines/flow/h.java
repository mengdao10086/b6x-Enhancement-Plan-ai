package kotlinx.coroutines.flow;

import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.f0;
import kotlinx.coroutines.c2;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.i;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class h {
    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Since 1.4.0, binary compatibility with earlier versions")
    public static final /* synthetic */ e a(e eVar, int i10) {
        return d(eVar, i10, null, 2, null);
    }

    @yt.k
    public static final <T> e<T> b(@yt.k e<? extends T> eVar, int i10, @yt.k BufferOverflow bufferOverflow) {
        int i11;
        BufferOverflow bufferOverflow2;
        boolean z10 = true;
        if (!(i10 >= 0 || i10 == -2 || i10 == -1)) {
            throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i10).toString());
        }
        if (i10 == -1 && bufferOverflow != BufferOverflow.SUSPEND) {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
        if (i10 == -1) {
            bufferOverflow2 = BufferOverflow.DROP_OLDEST;
            i11 = 0;
        } else {
            i11 = i10;
            bufferOverflow2 = bufferOverflow;
        }
        return eVar instanceof kotlinx.coroutines.flow.internal.i ? i.a.a((kotlinx.coroutines.flow.internal.i) eVar, null, i11, bufferOverflow2, 1, null) : new kotlinx.coroutines.flow.internal.e(eVar, null, i11, bufferOverflow2, 2, null);
    }

    public static /* synthetic */ e c(e eVar, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = -2;
        }
        return a(eVar, i10);
    }

    public static /* synthetic */ e d(e eVar, int i10, BufferOverflow bufferOverflow, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = -2;
        }
        if ((i11 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return g.o(eVar, i10, bufferOverflow);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <T> e<T> e(@yt.k e<? extends T> eVar) {
        return eVar instanceof a ? eVar : new CancellableFlowImpl(eVar);
    }

    public static final void f(CoroutineContext coroutineContext) {
        if (coroutineContext.c(c2.f38296x2) == null) {
            return;
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + coroutineContext).toString());
    }

    @yt.k
    public static final <T> e<T> g(@yt.k e<? extends T> eVar) {
        return d(eVar, -1, null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <T> e<T> h(@yt.k e<? extends T> eVar, @yt.k CoroutineContext coroutineContext) {
        f(coroutineContext);
        return f0.g(coroutineContext, EmptyCoroutineContext.f37755a) ? eVar : eVar instanceof kotlinx.coroutines.flow.internal.i ? i.a.a((kotlinx.coroutines.flow.internal.i) eVar, coroutineContext, 0, null, 6, null) : new kotlinx.coroutines.flow.internal.e(eVar, coroutineContext, 0, null, 12, null);
    }
}
