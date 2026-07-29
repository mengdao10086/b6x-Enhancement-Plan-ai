package p1;

import androidx.lifecycle.x0;
import androidx.lifecycle.z0;
import ik.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nInitializerViewModelFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InitializerViewModelFactory.kt\nandroidx/lifecycle/viewmodel/InitializerViewModelFactoryBuilder\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,115:1\n37#2,2:116\n*S KotlinDebug\n*F\n+ 1 InitializerViewModelFactory.kt\nandroidx/lifecycle/viewmodel/InitializerViewModelFactoryBuilder\n*L\n54#1:116,2\n*E\n"})
@f
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final List<g<?>> f46304a = new ArrayList();

    public final <T extends x0> void a(@k kotlin.reflect.d<T> clazz, @k l<? super a, ? extends T> initializer) {
        f0.p(clazz, "clazz");
        f0.p(initializer, "initializer");
        this.f46304a.add(new g<>(hk.a.e(clazz), initializer));
    }

    @k
    public final z0.b b() {
        g[] gVarArr = (g[]) this.f46304a.toArray(new g[0]);
        return new b((g[]) Arrays.copyOf(gVarArr, gVarArr.length));
    }
}
