package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
public final class z2<T> extends kotlinx.coroutines.internal.k0<T> {
    public z2(@yt.k CoroutineContext coroutineContext, @yt.k kotlin.coroutines.c<? super T> cVar) {
        super(coroutineContext, cVar);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean o0(@yt.k Throwable th2) {
        return false;
    }
}
