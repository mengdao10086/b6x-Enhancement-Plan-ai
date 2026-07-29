package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.k0;

/* JADX INFO: loaded from: classes5.dex */
public final class g<T> extends k0<T> {
    public g(@yt.k CoroutineContext coroutineContext, @yt.k kotlin.coroutines.c<? super T> cVar) {
        super(coroutineContext, cVar);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean o0(@yt.k Throwable th2) {
        if (th2 instanceof ChildCancelledException) {
            return true;
        }
        return i0(th2);
    }
}
