package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.TimeoutCancellationException;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$2", f = "Delay.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__DelayKt$timeoutInternal$1$1$2 extends SuspendLambda implements ik.l<kotlin.coroutines.c<?>, Object> {
    public final /* synthetic */ long $timeout;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$timeoutInternal$1$1$2(long j10, kotlin.coroutines.c<? super FlowKt__DelayKt$timeoutInternal$1$1$2> cVar) {
        super(1, cVar);
        this.$timeout = j10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> T(@yt.k kotlin.coroutines.c<?> cVar) {
        return new FlowKt__DelayKt$timeoutInternal$1$1$2(this.$timeout, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        yj.b.h();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        u0.n(obj);
        throw new TimeoutCancellationException("Timed out waiting for " + ((Object) uk.e.u0(this.$timeout)));
    }

    @Override // ik.l
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object i(@yt.l kotlin.coroutines.c<?> cVar) {
        return ((FlowKt__DelayKt$timeoutInternal$1$1$2) T(cVar)).q0(z1.f38230a);
    }
}
