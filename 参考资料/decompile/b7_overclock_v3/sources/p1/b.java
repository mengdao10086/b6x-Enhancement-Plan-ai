package p1;

import androidx.lifecycle.a1;
import androidx.lifecycle.x0;
import androidx.lifecycle.z0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nInitializerViewModelFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InitializerViewModelFactory.kt\nandroidx/lifecycle/viewmodel/InitializerViewModelFactory\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,115:1\n13579#2,2:116\n*S KotlinDebug\n*F\n+ 1 InitializerViewModelFactory.kt\nandroidx/lifecycle/viewmodel/InitializerViewModelFactory\n*L\n105#1:116,2\n*E\n"})
public final class b implements z0.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final g<?>[] f46303b;

    public b(@k g<?>... initializers) {
        f0.p(initializers, "initializers");
        this.f46303b = initializers;
    }

    @Override // androidx.lifecycle.z0.b
    public /* synthetic */ x0 a(Class cls) {
        return a1.a(this, cls);
    }

    @Override // androidx.lifecycle.z0.b
    @k
    public <T extends x0> T b(@k Class<T> modelClass, @k a extras) {
        f0.p(modelClass, "modelClass");
        f0.p(extras, "extras");
        T t10 = null;
        for (g<?> gVar : this.f46303b) {
            if (f0.g(gVar.a(), modelClass)) {
                T tI = gVar.b().i(extras);
                t10 = tI instanceof x0 ? tI : null;
            }
        }
        if (t10 != null) {
            return t10;
        }
        throw new IllegalArgumentException("No initializer set for given class " + modelClass.getName());
    }
}
