package kotlinx.coroutines.selects;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import rb.k0;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.selects.SelectImplementation", f = "Select.kt", i = {0}, l = {431, k0.f48142c}, m = "doSelectSuspend", n = {"this"}, s = {"L$0"})
public final class SelectImplementation$doSelectSuspend$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SelectImplementation<R> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectImplementation$doSelectSuspend$1(SelectImplementation<R> selectImplementation, kotlin.coroutines.c<? super SelectImplementation$doSelectSuspend$1> cVar) {
        super(cVar);
        this.this$0 = selectImplementation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.T(this);
    }
}
