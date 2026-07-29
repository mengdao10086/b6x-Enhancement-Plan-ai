package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.z0;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes2.dex */
public final class t0 extends z0.d implements z0.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.l
    public Application f6253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final z0.b f6254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.l
    public Bundle f6255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.l
    public Lifecycle f6256e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.l
    public androidx.savedstate.b f6257f;

    public t0() {
        this.f6254c = new z0.a();
    }

    @Override // androidx.lifecycle.z0.b
    @yt.k
    public <T extends x0> T a(@yt.k Class<T> modelClass) {
        kotlin.jvm.internal.f0.p(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            return (T) d(canonicalName, modelClass);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.z0.b
    @yt.k
    public <T extends x0> T b(@yt.k Class<T> modelClass, @yt.k p1.a extras) {
        kotlin.jvm.internal.f0.p(modelClass, "modelClass");
        kotlin.jvm.internal.f0.p(extras, "extras");
        String str = (String) extras.a(z0.c.f6285d);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (extras.a(SavedStateHandleSupport.f6123c) == null || extras.a(SavedStateHandleSupport.f6124d) == null) {
            if (this.f6256e != null) {
                return (T) d(str, modelClass);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) extras.a(z0.a.f6278i);
        boolean zIsAssignableFrom = b.class.isAssignableFrom(modelClass);
        Constructor constructorC = (!zIsAssignableFrom || application == null) ? u0.c(modelClass, u0.f6261b) : u0.c(modelClass, u0.f6260a);
        return constructorC == null ? (T) this.f6254c.b(modelClass, extras) : (!zIsAssignableFrom || application == null) ? (T) u0.d(modelClass, constructorC, SavedStateHandleSupport.b(extras)) : (T) u0.d(modelClass, constructorC, application, SavedStateHandleSupport.b(extras));
    }

    @Override // androidx.lifecycle.z0.d
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void c(@yt.k x0 viewModel) {
        kotlin.jvm.internal.f0.p(viewModel, "viewModel");
        if (this.f6256e != null) {
            androidx.savedstate.b bVar = this.f6257f;
            kotlin.jvm.internal.f0.m(bVar);
            Lifecycle lifecycle = this.f6256e;
            kotlin.jvm.internal.f0.m(lifecycle);
            LegacySavedStateHandleController.a(viewModel, bVar, lifecycle);
        }
    }

    @yt.k
    public final <T extends x0> T d(@yt.k String key, @yt.k Class<T> modelClass) {
        T t10;
        Application application;
        kotlin.jvm.internal.f0.p(key, "key");
        kotlin.jvm.internal.f0.p(modelClass, "modelClass");
        Lifecycle lifecycle = this.f6256e;
        if (lifecycle == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean zIsAssignableFrom = b.class.isAssignableFrom(modelClass);
        Constructor constructorC = (!zIsAssignableFrom || this.f6253b == null) ? u0.c(modelClass, u0.f6261b) : u0.c(modelClass, u0.f6260a);
        if (constructorC == null) {
            return this.f6253b != null ? (T) this.f6254c.a(modelClass) : (T) z0.c.f6283b.a().a(modelClass);
        }
        androidx.savedstate.b bVar = this.f6257f;
        kotlin.jvm.internal.f0.m(bVar);
        SavedStateHandleController savedStateHandleControllerB = LegacySavedStateHandleController.b(bVar, lifecycle, key, this.f6255d);
        if (!zIsAssignableFrom || (application = this.f6253b) == null) {
            t10 = (T) u0.d(modelClass, constructorC, savedStateHandleControllerB.i());
        } else {
            kotlin.jvm.internal.f0.m(application);
            t10 = (T) u0.d(modelClass, constructorC, application, savedStateHandleControllerB.i());
        }
        t10.f("androidx.lifecycle.savedstate.vm.tag", savedStateHandleControllerB);
        return t10;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public t0(@yt.l Application application, @yt.k androidx.savedstate.d owner) {
        this(application, owner, null);
        kotlin.jvm.internal.f0.p(owner, "owner");
    }

    @SuppressLint({"LambdaLast"})
    public t0(@yt.l Application application, @yt.k androidx.savedstate.d owner, @yt.l Bundle bundle) {
        z0.a aVar;
        kotlin.jvm.internal.f0.p(owner, "owner");
        this.f6257f = owner.l1();
        this.f6256e = owner.e();
        this.f6255d = bundle;
        this.f6253b = application;
        if (application != null) {
            aVar = z0.a.f6275f.b(application);
        } else {
            aVar = new z0.a();
        }
        this.f6254c = aVar;
    }
}
