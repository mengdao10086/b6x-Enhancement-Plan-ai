package kotlinx.coroutines.internal;

import java.util.Collection;
import java.util.ServiceLoader;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nCoroutineExceptionHandlerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandlerImpl.kt\nkotlinx/coroutines/internal/CoroutineExceptionHandlerImplKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,50:1\n1#2:51\n*E\n"})
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final Collection<kotlinx.coroutines.k0> f38801a = SequencesKt___SequencesKt.c3(SequencesKt__SequencesKt.e(ServiceLoader.load(kotlinx.coroutines.k0.class, kotlinx.coroutines.k0.class.getClassLoader()).iterator()));

    public static final void a(@yt.k kotlinx.coroutines.k0 k0Var) {
        if (!f38801a.contains(k0Var)) {
            throw new IllegalStateException("Exception handler was not found via a ServiceLoader".toString());
        }
    }

    @yt.k
    public static final Collection<kotlinx.coroutines.k0> b() {
        return f38801a;
    }

    public static final void c(@yt.k Throwable th2) {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th2);
    }
}
