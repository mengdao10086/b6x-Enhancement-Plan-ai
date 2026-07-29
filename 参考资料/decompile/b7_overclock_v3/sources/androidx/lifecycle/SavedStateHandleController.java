package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.jvm.internal.t0({"SMAP\nSavedStateHandleController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateHandleController.kt\nandroidx/lifecycle/SavedStateHandleController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,41:1\n1#2:42\n*E\n"})
public final class SavedStateHandleController implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final String f6118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final r0 f6119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6120c;

    public SavedStateHandleController(@yt.k String key, @yt.k r0 handle) {
        kotlin.jvm.internal.f0.p(key, "key");
        kotlin.jvm.internal.f0.p(handle, "handle");
        this.f6118a = key;
        this.f6119b = handle;
    }

    @Override // androidx.lifecycle.v
    public void c(@yt.k y source, @yt.k Lifecycle.Event event) {
        kotlin.jvm.internal.f0.p(source, "source");
        kotlin.jvm.internal.f0.p(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.f6120c = false;
            source.e().d(this);
        }
    }

    public final void h(@yt.k androidx.savedstate.b registry, @yt.k Lifecycle lifecycle) {
        kotlin.jvm.internal.f0.p(registry, "registry");
        kotlin.jvm.internal.f0.p(lifecycle, "lifecycle");
        if (!(!this.f6120c)) {
            throw new IllegalStateException("Already attached to lifecycleOwner".toString());
        }
        this.f6120c = true;
        lifecycle.a(this);
        registry.j(this.f6118a, this.f6119b.o());
    }

    @yt.k
    public final r0 i() {
        return this.f6119b;
    }

    public final boolean j() {
        return this.f6120c;
    }
}
