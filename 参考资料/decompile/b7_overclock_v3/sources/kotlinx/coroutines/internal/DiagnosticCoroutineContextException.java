package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nCoroutineExceptionHandlerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandlerImpl.kt\nkotlinx/coroutines/internal/DiagnosticCoroutineContextException\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,50:1\n26#2:51\n*S KotlinDebug\n*F\n+ 1 CoroutineExceptionHandlerImpl.kt\nkotlinx/coroutines/internal/DiagnosticCoroutineContextException\n*L\n46#1:51\n*E\n"})
public final class DiagnosticCoroutineContextException extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final transient CoroutineContext f38757a;

    public DiagnosticCoroutineContextException(@yt.k CoroutineContext coroutineContext) {
        this.f38757a = coroutineContext;
    }

    @Override // java.lang.Throwable
    @yt.k
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    @yt.k
    public String getLocalizedMessage() {
        return this.f38757a.toString();
    }
}
