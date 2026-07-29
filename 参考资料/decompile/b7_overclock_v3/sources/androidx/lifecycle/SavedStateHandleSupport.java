package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.z0;
import androidx.savedstate.b;
import p1.a;

/* JADX INFO: loaded from: classes2.dex */
@hk.h(name = "SavedStateHandleSupport")
@kotlin.jvm.internal.t0({"SMAP\nSavedStateHandleSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateHandleSupport.kt\nandroidx/lifecycle/SavedStateHandleSupport\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 InitializerViewModelFactory.kt\nandroidx/lifecycle/viewmodel/InitializerViewModelFactoryKt\n*L\n1#1,221:1\n1#2:222\n31#3:223\n63#3,2:224\n*S KotlinDebug\n*F\n+ 1 SavedStateHandleSupport.kt\nandroidx/lifecycle/SavedStateHandleSupport\n*L\n109#1:223\n110#1:224,2\n*E\n"})
public final class SavedStateHandleSupport {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final String f6121a = "androidx.lifecycle.internal.SavedStateHandlesVM";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final String f6122b = "androidx.lifecycle.internal.SavedStateHandlesProvider";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final a.b<androidx.savedstate.d> f6123c = new b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final a.b<d1> f6124d = new c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final a.b<Bundle> f6125e = new a();

    public static final class a implements a.b<Bundle> {
    }

    public static final class b implements a.b<androidx.savedstate.d> {
    }

    public static final class c implements a.b<d1> {
    }

    public static final r0 a(androidx.savedstate.d dVar, d1 d1Var, String str, Bundle bundle) {
        SavedStateHandlesProvider savedStateHandlesProviderD = d(dVar);
        s0 s0VarE = e(d1Var);
        r0 r0Var = s0VarE.g().get(str);
        if (r0Var != null) {
            return r0Var;
        }
        r0 r0VarA = r0.f6235f.a(savedStateHandlesProviderD.b(str), bundle);
        s0VarE.g().put(str, r0VarA);
        return r0VarA;
    }

    @g.k0
    @yt.k
    public static final r0 b(@yt.k p1.a aVar) {
        kotlin.jvm.internal.f0.p(aVar, "<this>");
        androidx.savedstate.d dVar = (androidx.savedstate.d) aVar.a(f6123c);
        if (dVar == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        d1 d1Var = (d1) aVar.a(f6124d);
        if (d1Var == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) aVar.a(f6125e);
        String str = (String) aVar.a(z0.c.f6285d);
        if (str != null) {
            return a(dVar, d1Var, str, bundle);
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.k0
    public static final <T extends androidx.savedstate.d & d1> void c(@yt.k T t10) {
        kotlin.jvm.internal.f0.p(t10, "<this>");
        Lifecycle.State stateB = t10.e().b();
        if (!(stateB == Lifecycle.State.INITIALIZED || stateB == Lifecycle.State.CREATED)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (t10.l1().c(f6122b) == null) {
            SavedStateHandlesProvider savedStateHandlesProvider = new SavedStateHandlesProvider(t10.l1(), t10);
            t10.l1().j(f6122b, savedStateHandlesProvider);
            t10.e().a(new SavedStateHandleAttacher(savedStateHandlesProvider));
        }
    }

    @yt.k
    public static final SavedStateHandlesProvider d(@yt.k androidx.savedstate.d dVar) {
        kotlin.jvm.internal.f0.p(dVar, "<this>");
        b.c cVarC = dVar.l1().c(f6122b);
        SavedStateHandlesProvider savedStateHandlesProvider = cVarC instanceof SavedStateHandlesProvider ? (SavedStateHandlesProvider) cVarC : null;
        if (savedStateHandlesProvider != null) {
            return savedStateHandlesProvider;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }

    @yt.k
    public static final s0 e(@yt.k d1 d1Var) {
        kotlin.jvm.internal.f0.p(d1Var, "<this>");
        p1.c cVar = new p1.c();
        cVar.a(kotlin.jvm.internal.n0.d(s0.class), new ik.l<p1.a, s0>() { // from class: androidx.lifecycle.SavedStateHandleSupport$savedStateHandlesVM$1$1
            @Override // ik.l
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final s0 i(@yt.k p1.a initializer) {
                kotlin.jvm.internal.f0.p(initializer, "$this$initializer");
                return new s0();
            }
        });
        return (s0) new z0(d1Var, cVar.b()).b(f6121a, s0.class);
    }
}
