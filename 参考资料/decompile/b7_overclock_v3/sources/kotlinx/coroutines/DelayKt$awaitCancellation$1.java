package kotlinx.coroutines;

import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.DelayKt", f = "Delay.kt", i = {}, l = {163}, m = "awaitCancellation", n = {}, s = {})
public final class DelayKt$awaitCancellation$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;

    public DelayKt$awaitCancellation$1(kotlin.coroutines.c<? super DelayKt$awaitCancellation$1> cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DelayKt.a(this);
    }
}
