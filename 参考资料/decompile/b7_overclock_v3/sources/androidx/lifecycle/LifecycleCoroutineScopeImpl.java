package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.h2;

/* JADX INFO: loaded from: classes2.dex */
public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final Lifecycle f6084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final CoroutineContext f6085b;

    public LifecycleCoroutineScopeImpl(@yt.k Lifecycle lifecycle, @yt.k CoroutineContext coroutineContext) {
        kotlin.jvm.internal.f0.p(lifecycle, "lifecycle");
        kotlin.jvm.internal.f0.p(coroutineContext, "coroutineContext");
        this.f6084a = lifecycle;
        this.f6085b = coroutineContext;
        if (h().b() == Lifecycle.State.DESTROYED) {
            h2.i(W(), null, 1, null);
        }
    }

    @Override // kotlinx.coroutines.o0
    @yt.k
    public CoroutineContext W() {
        return this.f6085b;
    }

    @Override // androidx.lifecycle.v
    public void c(@yt.k y source, @yt.k Lifecycle.Event event) {
        kotlin.jvm.internal.f0.p(source, "source");
        kotlin.jvm.internal.f0.p(event, "event");
        if (h().b().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            h().d(this);
            h2.i(W(), null, 1, null);
        }
    }

    @Override // androidx.lifecycle.LifecycleCoroutineScope
    @yt.k
    public Lifecycle h() {
        return this.f6084a;
    }

    public final void m() {
        kotlinx.coroutines.j.f(this, kotlinx.coroutines.d1.e().o2(), null, new LifecycleCoroutineScopeImpl$register$1(this, null), 2, null);
    }
}
