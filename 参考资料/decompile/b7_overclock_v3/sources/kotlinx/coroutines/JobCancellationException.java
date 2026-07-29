package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nExceptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Exceptions.kt\nkotlinx/coroutines/JobCancellationException\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,76:1\n26#2:77\n*S KotlinDebug\n*F\n+ 1 Exceptions.kt\nkotlinx/coroutines/JobCancellationException\n*L\n44#1:77\n*E\n"})
public final class JobCancellationException extends CancellationException implements j0<JobCancellationException> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hk.e
    @yt.k
    public final transient c2 f38243a;

    public JobCancellationException(@yt.k String str, @yt.l Throwable th2, @yt.k c2 c2Var) {
        super(str);
        this.f38243a = c2Var;
        if (th2 != null) {
            initCause(th2);
        }
    }

    @Override // kotlinx.coroutines.j0
    @yt.l
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public JobCancellationException a() {
        return null;
    }

    public boolean equals(@yt.l Object obj) {
        if (obj != this) {
            if (obj instanceof JobCancellationException) {
                JobCancellationException jobCancellationException = (JobCancellationException) obj;
                if (!kotlin.jvm.internal.f0.g(jobCancellationException.getMessage(), getMessage()) || !kotlin.jvm.internal.f0.g(jobCancellationException.f38243a, this.f38243a) || !kotlin.jvm.internal.f0.g(jobCancellationException.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    @yt.k
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        kotlin.jvm.internal.f0.m(message);
        int iHashCode = ((message.hashCode() * 31) + this.f38243a.hashCode()) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    @yt.k
    public String toString() {
        return super.toString() + "; job=" + this.f38243a;
    }
}
