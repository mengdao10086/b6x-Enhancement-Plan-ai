package kotlinx.coroutines.sync;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.t0;
import yt.k;
import yt.l;
import zj.d;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexKt$withLock$1\n*L\n1#1,300:1\n*E\n"})
@d(c = "kotlinx.coroutines.sync.MutexKt", f = "Mutex.kt", i = {0, 0, 0}, l = {125}, m = "withLock", n = {"$this$withLock", "owner", "action"}, s = {"L$0", "L$1", "L$2"})
public final class MutexKt$withLock$1<T> extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public /* synthetic */ Object result;

    public MutexKt$withLock$1(kotlin.coroutines.c<? super MutexKt$withLock$1> cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object q0(@k Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return MutexKt.e(null, null, null, this);
    }
}
