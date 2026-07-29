package androidx.core.util;

import g.v0;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import kotlin.Result;

/* JADX INFO: loaded from: classes2.dex */
@v0(24)
final class ContinuationConsumer<T> extends AtomicBoolean implements Consumer<T> {

    @yt.k
    private final kotlin.coroutines.c<T> continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationConsumer(@yt.k kotlin.coroutines.c<? super T> continuation) {
        super(false);
        kotlin.jvm.internal.f0.p(continuation, "continuation");
        this.continuation = continuation;
    }

    @Override // java.util.function.Consumer
    public void accept(T t10) {
        if (compareAndSet(false, true)) {
            kotlin.coroutines.c<T> cVar = this.continuation;
            Result.a aVar = Result.f37633a;
            cVar.x(Result.b(t10));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    @yt.k
    public String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + ')';
    }
}
