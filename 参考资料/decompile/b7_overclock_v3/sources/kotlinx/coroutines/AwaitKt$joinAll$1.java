package kotlinx.coroutines;

import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", i = {0}, l = {54}, m = "joinAll", n = {"$this$forEach$iv"}, s = {"L$0"})
public final class AwaitKt$joinAll$1 extends ContinuationImpl {
    public int I$0;
    public int I$1;
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public AwaitKt$joinAll$1(kotlin.coroutines.c<? super AwaitKt$joinAll$1> cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AwaitKt.d(null, this);
    }
}
