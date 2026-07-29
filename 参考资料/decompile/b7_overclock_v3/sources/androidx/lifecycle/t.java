package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlinx.coroutines.c2;

/* JADX INFO: loaded from: classes2.dex */
@g.k0
@kotlin.jvm.internal.t0({"SMAP\nLifecycleController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LifecycleController.kt\nandroidx/lifecycle/LifecycleController\n*L\n1#1,70:1\n57#1,3:71\n57#1,3:74\n*S KotlinDebug\n*F\n+ 1 LifecycleController.kt\nandroidx/lifecycle/LifecycleController\n*L\n49#1:71,3\n36#1:74,3\n*E\n"})
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final Lifecycle f6249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final Lifecycle.State f6250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final l f6251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final v f6252d;

    public t(@yt.k Lifecycle lifecycle, @yt.k Lifecycle.State minState, @yt.k l dispatchQueue, @yt.k final c2 parentJob) {
        kotlin.jvm.internal.f0.p(lifecycle, "lifecycle");
        kotlin.jvm.internal.f0.p(minState, "minState");
        kotlin.jvm.internal.f0.p(dispatchQueue, "dispatchQueue");
        kotlin.jvm.internal.f0.p(parentJob, "parentJob");
        this.f6249a = lifecycle;
        this.f6250b = minState;
        this.f6251c = dispatchQueue;
        v vVar = new v() { // from class: androidx.lifecycle.s
            @Override // androidx.lifecycle.v
            public final void c(y yVar, Lifecycle.Event event) {
                t.d(this.f6246a, parentJob, yVar, event);
            }
        };
        this.f6252d = vVar;
        if (lifecycle.b() != Lifecycle.State.DESTROYED) {
            lifecycle.a(vVar);
        } else {
            c2.a.b(parentJob, null, 1, null);
            b();
        }
    }

    public static final void d(t this$0, c2 parentJob, y source, Lifecycle.Event event) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.p(parentJob, "$parentJob");
        kotlin.jvm.internal.f0.p(source, "source");
        kotlin.jvm.internal.f0.p(event, "<anonymous parameter 1>");
        if (source.e().b() == Lifecycle.State.DESTROYED) {
            c2.a.b(parentJob, null, 1, null);
            this$0.b();
        } else if (source.e().b().compareTo(this$0.f6250b) < 0) {
            this$0.f6251c.h();
        } else {
            this$0.f6251c.i();
        }
    }

    @g.k0
    public final void b() {
        this.f6249a.d(this.f6252d);
        this.f6251c.g();
    }

    public final void c(c2 c2Var) {
        c2.a.b(c2Var, null, 1, null);
        b();
    }
}
