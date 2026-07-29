package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.LegacySavedStateHandleController;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.b;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class LegacySavedStateHandleController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final LegacySavedStateHandleController f6077a = new LegacySavedStateHandleController();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final String f6078b = "androidx.lifecycle.savedstate.vm.tag";

    public static final class a implements b.a {
        @Override // androidx.savedstate.b.a
        public void a(@yt.k androidx.savedstate.d owner) {
            kotlin.jvm.internal.f0.p(owner, "owner");
            if (!(owner instanceof d1)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner".toString());
            }
            c1 c1VarO0 = ((d1) owner).O0();
            androidx.savedstate.b bVarL1 = owner.l1();
            Iterator<String> it2 = c1VarO0.c().iterator();
            while (it2.hasNext()) {
                x0 x0VarB = c1VarO0.b(it2.next());
                kotlin.jvm.internal.f0.m(x0VarB);
                LegacySavedStateHandleController.a(x0VarB, bVarL1, owner.e());
            }
            if (!c1VarO0.c().isEmpty()) {
                bVarL1.k(a.class);
            }
        }
    }

    @hk.m
    public static final void a(@yt.k x0 viewModel, @yt.k androidx.savedstate.b registry, @yt.k Lifecycle lifecycle) {
        kotlin.jvm.internal.f0.p(viewModel, "viewModel");
        kotlin.jvm.internal.f0.p(registry, "registry");
        kotlin.jvm.internal.f0.p(lifecycle, "lifecycle");
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) viewModel.d("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController == null || savedStateHandleController.j()) {
            return;
        }
        savedStateHandleController.h(registry, lifecycle);
        f6077a.c(registry, lifecycle);
    }

    @hk.m
    @yt.k
    public static final SavedStateHandleController b(@yt.k androidx.savedstate.b registry, @yt.k Lifecycle lifecycle, @yt.l String str, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(registry, "registry");
        kotlin.jvm.internal.f0.p(lifecycle, "lifecycle");
        kotlin.jvm.internal.f0.m(str);
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, r0.f6235f.a(registry.b(str), bundle));
        savedStateHandleController.h(registry, lifecycle);
        f6077a.c(registry, lifecycle);
        return savedStateHandleController;
    }

    public final void c(final androidx.savedstate.b bVar, final Lifecycle lifecycle) {
        Lifecycle.State stateB = lifecycle.b();
        if (stateB == Lifecycle.State.INITIALIZED || stateB.isAtLeast(Lifecycle.State.STARTED)) {
            bVar.k(a.class);
        } else {
            lifecycle.a(new v() { // from class: androidx.lifecycle.LegacySavedStateHandleController$tryToAddRecreator$1
                @Override // androidx.lifecycle.v
                public void c(@yt.k y source, @yt.k Lifecycle.Event event) {
                    kotlin.jvm.internal.f0.p(source, "source");
                    kotlin.jvm.internal.f0.p(event, "event");
                    if (event == Lifecycle.Event.ON_START) {
                        lifecycle.d(this);
                        bVar.k(LegacySavedStateHandleController.a.class);
                    }
                }
            });
        }
    }
}
