package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nReduce.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt$fold$1\n*L\n1#1,172:1\n*E\n"})
@zj.d(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {44}, m = "fold", n = {"accumulator"}, s = {"L$0"})
public final class FlowKt__ReduceKt$fold$1<T, R> extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public FlowKt__ReduceKt$fold$1(kotlin.coroutines.c<? super FlowKt__ReduceKt$fold$1> cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FlowKt__ReduceKt.e(null, null, null, this);
    }
}
