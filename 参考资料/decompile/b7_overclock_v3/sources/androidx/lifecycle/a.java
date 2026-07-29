package androidx.lifecycle;

import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.z0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends z0.d implements z0.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final C0053a f6157e = new C0053a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public static final String f6158f = "androidx.lifecycle.savedstate.vm.tag";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.l
    public androidx.savedstate.b f6159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.l
    public Lifecycle f6160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.l
    public Bundle f6161d;

    /* JADX INFO: renamed from: androidx.lifecycle.a$a, reason: collision with other inner class name */
    public static final class C0053a {
        public C0053a() {
        }

        public /* synthetic */ C0053a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    public a() {
    }

    @Override // androidx.lifecycle.z0.b
    @yt.k
    public <T extends x0> T a(@yt.k Class<T> modelClass) {
        kotlin.jvm.internal.f0.p(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        if (this.f6160c != null) {
            return (T) d(canonicalName, modelClass);
        }
        throw new UnsupportedOperationException("AbstractSavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @Override // androidx.lifecycle.z0.b
    @yt.k
    public <T extends x0> T b(@yt.k Class<T> modelClass, @yt.k p1.a extras) {
        kotlin.jvm.internal.f0.p(modelClass, "modelClass");
        kotlin.jvm.internal.f0.p(extras, "extras");
        String str = (String) extras.a(z0.c.f6285d);
        if (str != null) {
            return this.f6159b != null ? (T) d(str, modelClass) : (T) e(str, modelClass, SavedStateHandleSupport.b(extras));
        }
        throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
    }

    @Override // androidx.lifecycle.z0.d
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void c(@yt.k x0 viewModel) {
        kotlin.jvm.internal.f0.p(viewModel, "viewModel");
        androidx.savedstate.b bVar = this.f6159b;
        if (bVar != null) {
            kotlin.jvm.internal.f0.m(bVar);
            Lifecycle lifecycle = this.f6160c;
            kotlin.jvm.internal.f0.m(lifecycle);
            LegacySavedStateHandleController.a(viewModel, bVar, lifecycle);
        }
    }

    public final <T extends x0> T d(String str, Class<T> cls) {
        androidx.savedstate.b bVar = this.f6159b;
        kotlin.jvm.internal.f0.m(bVar);
        Lifecycle lifecycle = this.f6160c;
        kotlin.jvm.internal.f0.m(lifecycle);
        SavedStateHandleController savedStateHandleControllerB = LegacySavedStateHandleController.b(bVar, lifecycle, str, this.f6161d);
        T t10 = (T) e(str, cls, savedStateHandleControllerB.i());
        t10.f("androidx.lifecycle.savedstate.vm.tag", savedStateHandleControllerB);
        return t10;
    }

    @yt.k
    public abstract <T extends x0> T e(@yt.k String str, @yt.k Class<T> cls, @yt.k r0 r0Var);

    public a(@yt.k androidx.savedstate.d owner, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(owner, "owner");
        this.f6159b = owner.l1();
        this.f6160c = owner.e();
        this.f6161d = bundle;
    }
}
