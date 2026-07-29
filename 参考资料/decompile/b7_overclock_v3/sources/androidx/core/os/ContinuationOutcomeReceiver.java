package androidx.core.os;

import android.os.OutcomeReceiver;
import g.v0;
import java.lang.Throwable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.jvm.internal.f0;
import kotlin.u0;

/* JADX INFO: loaded from: classes2.dex */
@v0(31)
final class ContinuationOutcomeReceiver<R, E extends Throwable> extends AtomicBoolean implements OutcomeReceiver<R, E> {

    @yt.k
    private final kotlin.coroutines.c<R> continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationOutcomeReceiver(@yt.k kotlin.coroutines.c<? super R> continuation) {
        super(false);
        f0.p(continuation, "continuation");
        this.continuation = continuation;
    }

    @Override // android.os.OutcomeReceiver
    public void onError(@yt.k E error) {
        f0.p(error, "error");
        if (compareAndSet(false, true)) {
            kotlin.coroutines.c<R> cVar = this.continuation;
            Result.a aVar = Result.f37633a;
            cVar.x(Result.b(u0.a(error)));
        }
    }

    @Override // android.os.OutcomeReceiver
    public void onResult(@yt.k R result) {
        f0.p(result, "result");
        if (compareAndSet(false, true)) {
            kotlin.coroutines.c<R> cVar = this.continuation;
            Result.a aVar = Result.f37633a;
            cVar.x(Result.b(result));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    @yt.k
    public String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
