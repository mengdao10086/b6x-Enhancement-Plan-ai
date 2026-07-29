package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.c3;

/* JADX INFO: loaded from: classes5.dex */
public final class u0<T> implements c3<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f38833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final ThreadLocal<T> f38834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final CoroutineContext.b<?> f38835c;

    public u0(T t10, @yt.k ThreadLocal<T> threadLocal) {
        this.f38833a = t10;
        this.f38834b = threadLocal;
        this.f38835c = new v0(threadLocal);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @yt.k
    public CoroutineContext L(@yt.k CoroutineContext coroutineContext) {
        return c3.a.d(this, coroutineContext);
    }

    @Override // kotlinx.coroutines.c3
    public T Y1(@yt.k CoroutineContext coroutineContext) {
        T t10 = this.f38834b.get();
        this.f38834b.set(this.f38833a);
        return t10;
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @yt.l
    public <E extends CoroutineContext.a> E c(@yt.k CoroutineContext.b<E> bVar) {
        if (!kotlin.jvm.internal.f0.g(getKey(), bVar)) {
            return null;
        }
        kotlin.jvm.internal.f0.n(this, "null cannot be cast to non-null type E of kotlinx.coroutines.internal.ThreadLocalElement.get");
        return this;
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @yt.k
    public CoroutineContext f(@yt.k CoroutineContext.b<?> bVar) {
        return kotlin.jvm.internal.f0.g(getKey(), bVar) ? EmptyCoroutineContext.f37755a : this;
    }

    @Override // kotlin.coroutines.CoroutineContext.a
    @yt.k
    public CoroutineContext.b<?> getKey() {
        return this.f38835c;
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    public <R> R k(R r10, @yt.k ik.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
        return (R) c3.a.a(this, r10, pVar);
    }

    @Override // kotlinx.coroutines.c3
    public void p1(@yt.k CoroutineContext coroutineContext, T t10) {
        this.f38834b.set(t10);
    }

    @yt.k
    public String toString() {
        return "ThreadLocal(value=" + this.f38833a + ", threadLocal = " + this.f38834b + ')';
    }
}
