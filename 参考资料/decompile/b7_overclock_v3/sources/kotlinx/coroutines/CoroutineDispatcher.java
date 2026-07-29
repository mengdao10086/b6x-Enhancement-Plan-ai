package kotlinx.coroutines;

import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CoroutineDispatcher extends kotlin.coroutines.a implements kotlin.coroutines.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final Key f38234b = new Key(null);

    @kotlin.q
    public static final class Key extends kotlin.coroutines.b<kotlin.coroutines.d, CoroutineDispatcher> {
        public Key() {
            super(kotlin.coroutines.d.f37759u2, new ik.l<CoroutineContext.a, CoroutineDispatcher>() { // from class: kotlinx.coroutines.CoroutineDispatcher.Key.1
                @Override // ik.l
                @yt.l
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final CoroutineDispatcher i(@yt.k CoroutineContext.a aVar) {
                    if (aVar instanceof CoroutineDispatcher) {
                        return (CoroutineDispatcher) aVar;
                    }
                    return null;
                }
            });
        }

        public /* synthetic */ Key(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    public CoroutineDispatcher() {
        super(kotlin.coroutines.d.f37759u2);
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @yt.l
    public <E extends CoroutineContext.a> E c(@yt.k CoroutineContext.b<E> bVar) {
        return (E) d.a.b(this, bVar);
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @yt.k
    public CoroutineContext f(@yt.k CoroutineContext.b<?> bVar) {
        return d.a.c(this, bVar);
    }

    public abstract void h2(@yt.k CoroutineContext coroutineContext, @yt.k Runnable runnable);

    @y1
    public void i2(@yt.k CoroutineContext coroutineContext, @yt.k Runnable runnable) {
        h2(coroutineContext, runnable);
    }

    public boolean j2(@yt.k CoroutineContext coroutineContext) {
        return true;
    }

    @s1
    @yt.k
    public CoroutineDispatcher k2(int i10) {
        kotlinx.coroutines.internal.r.a(i10);
        return new kotlinx.coroutines.internal.q(this, i10);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Operator '+' on two CoroutineDispatcher objects is meaningless. CoroutineDispatcher is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The dispatcher to the right of `+` just replaces the dispatcher to the left.")
    @yt.k
    public final CoroutineDispatcher l2(@yt.k CoroutineDispatcher coroutineDispatcher) {
        return coroutineDispatcher;
    }

    @Override // kotlin.coroutines.d
    public final void m(@yt.k kotlin.coroutines.c<?> cVar) {
        kotlin.jvm.internal.f0.n(cVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((kotlinx.coroutines.internal.k) cVar).v();
    }

    @yt.k
    public String toString() {
        return r0.a(this) + '@' + r0.b(this);
    }

    @Override // kotlin.coroutines.d
    @yt.k
    public final <T> kotlin.coroutines.c<T> z(@yt.k kotlin.coroutines.c<? super T> cVar) {
        return new kotlinx.coroutines.internal.k(this, cVar);
    }
}
