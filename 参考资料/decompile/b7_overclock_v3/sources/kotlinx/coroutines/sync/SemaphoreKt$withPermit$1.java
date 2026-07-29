package kotlinx.coroutines.sync;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.t0;
import yt.k;
import yt.l;
import zj.d;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nSemaphore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt$withPermit$1\n*L\n1#1,397:1\n*E\n"})
@d(c = "kotlinx.coroutines.sync.SemaphoreKt", f = "Semaphore.kt", i = {0, 0}, l = {86}, m = "withPermit", n = {"$this$withPermit", "action"}, s = {"L$0", "L$1"})
public final class SemaphoreKt$withPermit$1<T> extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;

    public SemaphoreKt$withPermit$1(kotlin.coroutines.c<? super SemaphoreKt$withPermit$1> cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object q0(@k Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SemaphoreKt.k(null, null, this);
    }
}
