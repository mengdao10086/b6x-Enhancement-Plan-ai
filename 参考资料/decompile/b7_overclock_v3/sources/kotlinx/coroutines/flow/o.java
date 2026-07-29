package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.t0;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.internal.o0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharedFlow.kt\nkotlinx/coroutines/flow/SharedFlowKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,731:1\n1#2:732\n*E\n"})
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final o0 f38730a = new o0("NO_VALUE");

    @yt.k
    public static final <T> i<T> a(int i10, int i11, @yt.k BufferOverflow bufferOverflow) {
        boolean z10 = true;
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("replay cannot be negative, but was " + i10).toString());
        }
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException(("extraBufferCapacity cannot be negative, but was " + i11).toString());
        }
        if (i10 <= 0 && i11 <= 0 && bufferOverflow != BufferOverflow.SUSPEND) {
            z10 = false;
        }
        if (z10) {
            int i12 = i11 + i10;
            if (i12 < 0) {
                i12 = Integer.MAX_VALUE;
            }
            return new SharedFlowImpl(i10, i12, bufferOverflow);
        }
        throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + bufferOverflow).toString());
    }

    public static /* synthetic */ i b(int i10, int i11, BufferOverflow bufferOverflow, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        if ((i12 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return a(i10, i11, bufferOverflow);
    }

    @yt.k
    public static final <T> e<T> e(@yt.k n<? extends T> nVar, @yt.k CoroutineContext coroutineContext, int i10, @yt.k BufferOverflow bufferOverflow) {
        return ((i10 == 0 || i10 == -3) && bufferOverflow == BufferOverflow.SUSPEND) ? nVar : new kotlinx.coroutines.flow.internal.e(nVar, coroutineContext, i10, bufferOverflow);
    }

    public static final Object f(Object[] objArr, long j10) {
        return objArr[(objArr.length - 1) & ((int) j10)];
    }

    public static final void g(Object[] objArr, long j10, Object obj) {
        objArr[(objArr.length - 1) & ((int) j10)] = obj;
    }
}
