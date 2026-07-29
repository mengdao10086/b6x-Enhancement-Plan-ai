package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes2.dex */
public final class CompositeGeneratedAdaptersObserver implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final o[] f6064a;

    public CompositeGeneratedAdaptersObserver(@yt.k o[] generatedAdapters) {
        kotlin.jvm.internal.f0.p(generatedAdapters, "generatedAdapters");
        this.f6064a = generatedAdapters;
    }

    @Override // androidx.lifecycle.v
    public void c(@yt.k y source, @yt.k Lifecycle.Event event) {
        kotlin.jvm.internal.f0.p(source, "source");
        kotlin.jvm.internal.f0.p(event, "event");
        i0 i0Var = new i0();
        for (o oVar : this.f6064a) {
            oVar.a(source, event, false, i0Var);
        }
        for (o oVar2 : this.f6064a) {
            oVar2.a(source, event, true, i0Var);
        }
    }
}
