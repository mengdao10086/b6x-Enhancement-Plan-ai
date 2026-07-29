package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
public final class l3 implements CoroutineContext.a, CoroutineContext.b<l3> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final l3 f38907a = new l3();

    @Override // kotlin.coroutines.CoroutineContext
    @yt.k
    public CoroutineContext L(@yt.k CoroutineContext coroutineContext) {
        return CoroutineContext.a.C0431a.d(this, coroutineContext);
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @yt.l
    public <E extends CoroutineContext.a> E c(@yt.k CoroutineContext.b<E> bVar) {
        return (E) CoroutineContext.a.C0431a.b(this, bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @yt.k
    public CoroutineContext f(@yt.k CoroutineContext.b<?> bVar) {
        return CoroutineContext.a.C0431a.c(this, bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext.a
    @yt.k
    public CoroutineContext.b<?> getKey() {
        return this;
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    public <R> R k(R r10, @yt.k ik.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
        return (R) CoroutineContext.a.C0431a.a(this, r10, pVar);
    }
}
