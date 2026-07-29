package xj;

import bk.f;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.t0;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nCancellationException.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancellationException.kt\nkotlin/coroutines/cancellation/CancellationExceptionKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,22:1\n1#2:23\n*E\n"})
public final class a {
    @f
    @v0(version = "1.4")
    public static final CancellationException a(String str, Throwable th2) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th2);
        return cancellationException;
    }

    @f
    @v0(version = "1.4")
    public static final CancellationException b(Throwable th2) {
        CancellationException cancellationException = new CancellationException(th2 != null ? th2.toString() : null);
        cancellationException.initCause(th2);
        return cancellationException;
    }

    @v0(version = "1.4")
    public static /* synthetic */ void c() {
    }
}
