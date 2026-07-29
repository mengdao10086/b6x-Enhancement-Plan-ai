package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.flow.FlowKt__CountKt", f = "Count.kt", i = {0}, l = {17}, m = uh.a.C, n = {"i"}, s = {"L$0"})
public final class FlowKt__CountKt$count$1<T> extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public FlowKt__CountKt$count$1(kotlin.coroutines.c<? super FlowKt__CountKt$count$1> cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return g.Z(null, this);
    }
}
