package kotlinx.coroutines.debug.internal;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import w.w;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl", f = "DebugCoroutineInfoImpl.kt", i = {0, 0, 0}, l = {163}, m = "yieldFrames", n = {"this", "$this$yieldFrames", w.a.L}, s = {"L$0", "L$1", "L$2"})
public final class DebugCoroutineInfoImpl$yieldFrames$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ DebugCoroutineInfoImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugCoroutineInfoImpl$yieldFrames$1(DebugCoroutineInfoImpl debugCoroutineInfoImpl, kotlin.coroutines.c<? super DebugCoroutineInfoImpl$yieldFrames$1> cVar) {
        super(cVar);
        this.this$0 = debugCoroutineInfoImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object q0(@k Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.k(null, null, this);
    }
}
