package androidx.activity;

import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.x0;
import androidx.lifecycle.z0;
import g.k0;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.z;

/* JADX INFO: loaded from: classes2.dex */
public final class ActivityViewModelLazyKt {
    @k0
    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Superseded by viewModels that takes a CreationExtras")
    public static final /* synthetic */ <VM extends x0> z<VM> a(ComponentActivity componentActivity, ik.a<? extends z0.b> aVar) {
        f0.p(componentActivity, "<this>");
        if (aVar == null) {
            aVar = new ActivityViewModelLazyKt$viewModels$factoryPromise$1(componentActivity);
        }
        f0.y(4, "VM");
        return new ViewModelLazy(n0.d(x0.class), new ActivityViewModelLazyKt$viewModels$1(componentActivity), aVar, new ActivityViewModelLazyKt$viewModels$2(componentActivity));
    }

    @k0
    public static final /* synthetic */ <VM extends x0> z<VM> b(ComponentActivity componentActivity, ik.a<? extends p1.a> aVar, ik.a<? extends z0.b> aVar2) {
        f0.p(componentActivity, "<this>");
        if (aVar2 == null) {
            aVar2 = new ActivityViewModelLazyKt$viewModels$factoryPromise$2(componentActivity);
        }
        f0.y(4, "VM");
        return new ViewModelLazy(n0.d(x0.class), new ActivityViewModelLazyKt$viewModels$3(componentActivity), aVar2, new ActivityViewModelLazyKt$viewModels$4(aVar, componentActivity));
    }

    public static /* synthetic */ z c(ComponentActivity componentActivity, ik.a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            aVar = null;
        }
        f0.p(componentActivity, "<this>");
        if (aVar == null) {
            aVar = new ActivityViewModelLazyKt$viewModels$factoryPromise$1(componentActivity);
        }
        f0.y(4, "VM");
        return new ViewModelLazy(n0.d(x0.class), new ActivityViewModelLazyKt$viewModels$1(componentActivity), aVar, new ActivityViewModelLazyKt$viewModels$2(componentActivity));
    }

    public static /* synthetic */ z d(ComponentActivity componentActivity, ik.a aVar, ik.a aVar2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            aVar = null;
        }
        if ((i10 & 2) != 0) {
            aVar2 = null;
        }
        f0.p(componentActivity, "<this>");
        if (aVar2 == null) {
            aVar2 = new ActivityViewModelLazyKt$viewModels$factoryPromise$2(componentActivity);
        }
        f0.y(4, "VM");
        return new ViewModelLazy(n0.d(x0.class), new ActivityViewModelLazyKt$viewModels$3(componentActivity), aVar2, new ActivityViewModelLazyKt$viewModels$4(aVar, componentActivity));
    }
}
