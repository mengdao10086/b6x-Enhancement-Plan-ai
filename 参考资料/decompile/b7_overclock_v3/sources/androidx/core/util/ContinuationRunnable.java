package androidx.core.util;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
final class ContinuationRunnable extends AtomicBoolean implements Runnable {

    @yt.k
    private final kotlin.coroutines.c<z1> continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationRunnable(@yt.k kotlin.coroutines.c<? super z1> continuation) {
        super(false);
        kotlin.jvm.internal.f0.p(continuation, "continuation");
        this.continuation = continuation;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (compareAndSet(false, true)) {
            kotlin.coroutines.c<z1> cVar = this.continuation;
            Result.a aVar = Result.f37633a;
            cVar.x(Result.b(z1.f38230a));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    @yt.k
    public String toString() {
        return "ContinuationRunnable(ran = " + get() + ')';
    }
}
