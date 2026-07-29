package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nFlowExceptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlowExceptions.kt\nkotlinx/coroutines/flow/internal/AbortFlowException\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,30:1\n26#2:31\n*S KotlinDebug\n*F\n+ 1 FlowExceptions.kt\nkotlinx/coroutines/flow/internal/AbortFlowException\n*L\n17#1:31\n*E\n"})
public final class AbortFlowException extends CancellationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hk.e
    @yt.k
    public final transient kotlinx.coroutines.flow.f<?> f38673a;

    public AbortFlowException(@yt.k kotlinx.coroutines.flow.f<?> fVar) {
        super("Flow was aborted, no more elements needed");
        this.f38673a = fVar;
    }

    @Override // java.lang.Throwable
    @yt.k
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
