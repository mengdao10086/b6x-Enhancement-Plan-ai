package kotlinx.coroutines.flow.internal;

import ik.p;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
public final class f implements CoroutineContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hk.e
    @yt.k
    public final Throwable f38714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CoroutineContext f38715b;

    public f(@yt.k Throwable th2, @yt.k CoroutineContext coroutineContext) {
        this.f38714a = th2;
        this.f38715b = coroutineContext;
    }

    @Override // kotlin.coroutines.CoroutineContext
    @yt.k
    public CoroutineContext L(@yt.k CoroutineContext coroutineContext) {
        return this.f38715b.L(coroutineContext);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @yt.l
    public <E extends CoroutineContext.a> E c(@yt.k CoroutineContext.b<E> bVar) {
        return (E) this.f38715b.c(bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @yt.k
    public CoroutineContext f(@yt.k CoroutineContext.b<?> bVar) {
        return this.f38715b.f(bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R k(R r10, @yt.k p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
        return (R) this.f38715b.k(r10, pVar);
    }
}
