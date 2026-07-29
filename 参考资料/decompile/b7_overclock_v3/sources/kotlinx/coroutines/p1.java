package kotlinx.coroutines;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nExceptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,76:1\n1#2:77\n*E\n"})
public final class p1 {
    @yt.k
    public static final CancellationException a(@yt.l String str, @yt.l Throwable th2) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th2);
        return cancellationException;
    }

    public static final void b(@yt.k Throwable th2, @yt.k Throwable th3) throws IllegalAccessException, InvocationTargetException {
        kotlin.o.a(th2, th3);
    }
}
