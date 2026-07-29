package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes2.dex */
public final class SingleGeneratedAdapterObserver implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final o f6131a;

    public SingleGeneratedAdapterObserver(@yt.k o generatedAdapter) {
        kotlin.jvm.internal.f0.p(generatedAdapter, "generatedAdapter");
        this.f6131a = generatedAdapter;
    }

    @Override // androidx.lifecycle.v
    public void c(@yt.k y source, @yt.k Lifecycle.Event event) {
        kotlin.jvm.internal.f0.p(source, "source");
        kotlin.jvm.internal.f0.p(event, "event");
        this.f6131a.a(source, event, false, null);
        this.f6131a.a(source, event, true, null);
    }
}
