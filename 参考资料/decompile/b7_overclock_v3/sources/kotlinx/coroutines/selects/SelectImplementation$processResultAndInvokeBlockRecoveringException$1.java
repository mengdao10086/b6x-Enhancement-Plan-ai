package kotlinx.coroutines.selects;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import w.w;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.selects.SelectImplementation", f = "Select.kt", i = {}, l = {w.h.f53796p}, m = "processResultAndInvokeBlockRecoveringException", n = {}, s = {})
public final class SelectImplementation$processResultAndInvokeBlockRecoveringException$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SelectImplementation<R> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectImplementation$processResultAndInvokeBlockRecoveringException$1(SelectImplementation<R> selectImplementation, kotlin.coroutines.c<? super SelectImplementation$processResultAndInvokeBlockRecoveringException$1> cVar) {
        super(cVar);
        this.this$0 = selectImplementation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d0(null, null, this);
    }
}
