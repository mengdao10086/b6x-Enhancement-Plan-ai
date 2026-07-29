package androidx.lifecycle;

import kotlin.z1;
import kotlinx.coroutines.c2;

/* JADX INFO: loaded from: classes2.dex */
public abstract class LifecycleCoroutineScope implements kotlinx.coroutines.o0 {
    @yt.k
    public abstract Lifecycle h();

    @kotlin.k(message = "launchWhenCreated is deprecated as it can lead to wasted resources in some cases. Replace with suspending repeatOnLifecycle to run the block whenever the Lifecycle state is at least Lifecycle.State.CREATED.")
    @yt.k
    public final c2 j(@yt.k ik.p<? super kotlinx.coroutines.o0, ? super kotlin.coroutines.c<? super z1>, ? extends Object> block) {
        kotlin.jvm.internal.f0.p(block, "block");
        return kotlinx.coroutines.j.f(this, null, null, new LifecycleCoroutineScope$launchWhenCreated$1(this, block, null), 3, null);
    }

    @kotlin.k(message = "launchWhenResumed is deprecated as it can lead to wasted resources in some cases. Replace with suspending repeatOnLifecycle to run the block whenever the Lifecycle state is at least Lifecycle.State.RESUMED.")
    @yt.k
    public final c2 k(@yt.k ik.p<? super kotlinx.coroutines.o0, ? super kotlin.coroutines.c<? super z1>, ? extends Object> block) {
        kotlin.jvm.internal.f0.p(block, "block");
        return kotlinx.coroutines.j.f(this, null, null, new LifecycleCoroutineScope$launchWhenResumed$1(this, block, null), 3, null);
    }

    @kotlin.k(message = "launchWhenStarted is deprecated as it can lead to wasted resources in some cases. Replace with suspending repeatOnLifecycle to run the block whenever the Lifecycle state is at least Lifecycle.State.STARTED.")
    @yt.k
    public final c2 l(@yt.k ik.p<? super kotlinx.coroutines.o0, ? super kotlin.coroutines.c<? super z1>, ? extends Object> block) {
        kotlin.jvm.internal.f0.p(block, "block");
        return kotlinx.coroutines.j.f(this, null, null, new LifecycleCoroutineScope$launchWhenStarted$1(this, block, null), 3, null);
    }
}
