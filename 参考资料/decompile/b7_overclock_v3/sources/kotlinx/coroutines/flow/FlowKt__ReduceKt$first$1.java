package kotlinx.coroutines.flow;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {183}, m = "first", n = {CommonNetImpl.RESULT, "collector$iv"}, s = {"L$0", "L$1"})
public final class FlowKt__ReduceKt$first$1<T> extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;

    public FlowKt__ReduceKt$first$1(kotlin.coroutines.c<? super FlowKt__ReduceKt$first$1> cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return g.v0(null, this);
    }
}
