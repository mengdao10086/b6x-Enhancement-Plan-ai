package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes2.dex */
public final class SavedStateHandleAttacher implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final SavedStateHandlesProvider f6117a;

    public SavedStateHandleAttacher(@yt.k SavedStateHandlesProvider provider) {
        kotlin.jvm.internal.f0.p(provider, "provider");
        this.f6117a = provider;
    }

    @Override // androidx.lifecycle.v
    public void c(@yt.k y source, @yt.k Lifecycle.Event event) {
        kotlin.jvm.internal.f0.p(source, "source");
        kotlin.jvm.internal.f0.p(event, "event");
        if (event == Lifecycle.Event.ON_CREATE) {
            source.e().d(this);
            this.f6117a.d();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + event).toString());
        }
    }
}
