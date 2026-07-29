package androidx.work;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.d0;

/* JADX INFO: loaded from: classes2.dex */
@zj.d(c = "androidx.work.OperationKt", f = "Operation.kt", i = {0}, l = {39}, m = "await", n = {"$this$await$iv"}, s = {"L$0"})
@d0(k = 3, mv = {1, 5, 1}, xi = 48)
public final class OperationKt$await$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public OperationKt$await$1(kotlin.coroutines.c<? super OperationKt$await$1> cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return OperationKt.a(null, this);
    }
}
