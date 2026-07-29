package kotlinx.coroutines.internal;

import java.util.Iterator;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
public final class i {
    public static final void a(@yt.k CoroutineContext coroutineContext, @yt.k Throwable th2) {
        Iterator<kotlinx.coroutines.k0> it2 = h.b().iterator();
        while (it2.hasNext()) {
            try {
                it2.next().V1(coroutineContext, th2);
            } catch (ExceptionSuccessfullyProcessed unused) {
                return;
            } catch (Throwable th3) {
                h.c(kotlinx.coroutines.l0.c(th2, th3));
            }
        }
        try {
            kotlin.o.a(th2, new DiagnosticCoroutineContextException(coroutineContext));
        } catch (Throwable unused2) {
        }
        h.c(th2);
    }
}
