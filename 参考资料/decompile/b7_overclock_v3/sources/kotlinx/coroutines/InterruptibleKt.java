package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
public final class InterruptibleKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38239a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f38240b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f38241c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f38242d = 3;

    @yt.l
    public static final <T> Object b(@yt.k CoroutineContext coroutineContext, @yt.k ik.a<? extends T> aVar, @yt.k kotlin.coroutines.c<? super T> cVar) {
        return h.h(coroutineContext, new InterruptibleKt$runInterruptible$2(aVar, null), cVar);
    }

    public static /* synthetic */ Object c(CoroutineContext coroutineContext, ik.a aVar, kotlin.coroutines.c cVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f37755a;
        }
        return b(coroutineContext, aVar, cVar);
    }

    public static final <T> T d(CoroutineContext coroutineContext, ik.a<? extends T> aVar) throws Throwable {
        try {
            h3 h3Var = new h3(f2.B(coroutineContext));
            h3Var.g();
            try {
                return aVar.o();
            } finally {
                h3Var.b();
            }
        } catch (InterruptedException e10) {
            throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e10);
        }
    }
}
