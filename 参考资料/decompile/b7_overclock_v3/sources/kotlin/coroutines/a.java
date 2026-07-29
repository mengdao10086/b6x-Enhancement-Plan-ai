package kotlin.coroutines;

import ik.p;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.f0;
import kotlin.v0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@v0(version = "1.3")
public abstract class a implements CoroutineContext.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final CoroutineContext.b<?> f37756a;

    public a(@k CoroutineContext.b<?> key) {
        f0.p(key, "key");
        this.f37756a = key;
    }

    @Override // kotlin.coroutines.CoroutineContext
    @k
    public CoroutineContext L(@k CoroutineContext coroutineContext) {
        return CoroutineContext.a.C0431a.d(this, coroutineContext);
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @l
    public <E extends CoroutineContext.a> E c(@k CoroutineContext.b<E> bVar) {
        return (E) CoroutineContext.a.C0431a.b(this, bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @k
    public CoroutineContext f(@k CoroutineContext.b<?> bVar) {
        return CoroutineContext.a.C0431a.c(this, bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext.a
    @k
    public CoroutineContext.b<?> getKey() {
        return this.f37756a;
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    public <R> R k(R r10, @k p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
        return (R) CoroutineContext.a.C0431a.a(this, r10, pVar);
    }
}
