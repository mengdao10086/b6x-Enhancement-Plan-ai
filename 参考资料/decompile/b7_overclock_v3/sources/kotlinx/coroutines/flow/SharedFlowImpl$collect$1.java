package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.flow.SharedFlowImpl", f = "SharedFlow.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {372, 379, 382}, m = "collect$suspendImpl", n = {"$this", "collector", "slot", "$this", "collector", "slot", "collectorJob", "$this", "collector", "slot", "collectorJob"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
public final class SharedFlowImpl$collect$1<T> extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SharedFlowImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedFlowImpl$collect$1(SharedFlowImpl<T> sharedFlowImpl, kotlin.coroutines.c<? super SharedFlowImpl$collect$1> cVar) {
        super(cVar);
        this.this$0 = sharedFlowImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SharedFlowImpl.E(this.this$0, null, this);
    }
}
