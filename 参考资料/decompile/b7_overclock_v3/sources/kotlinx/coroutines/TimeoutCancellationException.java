package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nTimeout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Timeout.kt\nkotlinx/coroutines/TimeoutCancellationException\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,193:1\n1#2:194\n*E\n"})
public final class TimeoutCancellationException extends CancellationException implements j0<TimeoutCancellationException> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hk.e
    @yt.l
    public final transient c2 f38264a;

    public TimeoutCancellationException(@yt.k String str, @yt.l c2 c2Var) {
        super(str);
        this.f38264a = c2Var;
    }

    @Override // kotlinx.coroutines.j0
    @yt.k
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public TimeoutCancellationException a() {
        String message = getMessage();
        if (message == null) {
            message = "";
        }
        TimeoutCancellationException timeoutCancellationException = new TimeoutCancellationException(message, this.f38264a);
        timeoutCancellationException.initCause(this);
        return timeoutCancellationException;
    }

    public TimeoutCancellationException(@yt.k String str) {
        this(str, null);
    }
}
