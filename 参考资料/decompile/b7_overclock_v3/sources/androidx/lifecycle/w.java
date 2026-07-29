package androidx.lifecycle;

import kotlinx.coroutines.b3;

/* JADX INFO: loaded from: classes2.dex */
public final class w {
    @yt.k
    public static final LifecycleCoroutineScope a(@yt.k Lifecycle lifecycle) {
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl;
        kotlin.jvm.internal.f0.p(lifecycle, "<this>");
        do {
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl2 = (LifecycleCoroutineScopeImpl) lifecycle.c().get();
            if (lifecycleCoroutineScopeImpl2 != null) {
                return lifecycleCoroutineScopeImpl2;
            }
            lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(lifecycle, b3.c(null, 1, null).L(kotlinx.coroutines.d1.e().m2()));
        } while (!lifecycle.c().compareAndSet(null, lifecycleCoroutineScopeImpl));
        lifecycleCoroutineScopeImpl.m();
        return lifecycleCoroutineScopeImpl;
    }
}
