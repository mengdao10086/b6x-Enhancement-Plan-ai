package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.c2;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.p1;
import kotlinx.coroutines.r0;

/* JADX INFO: loaded from: classes5.dex */
public class a<E> extends h<E> implements c<E> {
    public a(@yt.k CoroutineContext coroutineContext, @yt.k g<E> gVar, boolean z10) {
        super(coroutineContext, gVar, false, z10);
        N0((c2) coroutineContext.c(c2.f38296x2));
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean L0(@yt.k Throwable th2) {
        l0.b(b(), th2);
        return true;
    }

    @Override // kotlinx.coroutines.JobSupport
    public void h1(@yt.l Throwable th2) {
        g<E> gVarJ1 = J1();
        if (th2 != null) {
            cancellationExceptionA = th2 instanceof CancellationException ? (CancellationException) th2 : null;
            if (cancellationExceptionA == null) {
                cancellationExceptionA = p1.a(r0.a(this) + " was cancelled", th2);
            }
        }
        gVarJ1.h(cancellationExceptionA);
    }
}
