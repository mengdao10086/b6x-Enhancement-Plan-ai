package androidx.fragment.app;

import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.c1;
import androidx.lifecycle.d1;
import androidx.lifecycle.x0;
import androidx.lifecycle.z0;
import kotlin.DeprecationLevel;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.d0(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aD\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u000e\b\n\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u0087\bø\u0001\u0000\u001aV\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u000e\b\n\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0010\b\n\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00032\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u0087\bø\u0001\u0000\u001a4\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u0087\bø\u0001\u0000\u001aF\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0010\b\n\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00032\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u0087\bø\u0001\u0000\u001aJ\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u0007\u001aZ\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u0007\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016²\u0006\u0018\u0010\u0015\u001a\u00020\u0004\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00008\nX\u008a\u0084\u0002²\u0006\u0018\u0010\u0015\u001a\u00020\u0004\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00008\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/lifecycle/x0;", "VM", "Landroidx/fragment/app/Fragment;", "Lkotlin/Function0;", "Landroidx/lifecycle/d1;", "ownerProducer", "Landroidx/lifecycle/z0$b;", "factoryProducer", "Lkotlin/z;", "k", "Lp1/a;", "extrasProducer", com.flydigi.sdk.bluetooth.l.f16298a, "c", "d", "Lkotlin/reflect/d;", "viewModelClass", "Landroidx/lifecycle/c1;", "storeProducer", "g", "h", "owner", "fragment-ktx_release"}, k = 2, mv = {1, 6, 0})
public final class FragmentViewModelLazyKt {
    @g.k0
    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Superseded by activityViewModels that takes a CreationExtras producer")
    public static final /* synthetic */ <VM extends x0> kotlin.z<VM> c(Fragment fragment, ik.a<? extends z0.b> aVar) {
        kotlin.jvm.internal.f0.p(fragment, "<this>");
        kotlin.jvm.internal.f0.y(4, "VM");
        kotlin.reflect.d dVarD = kotlin.jvm.internal.n0.d(x0.class);
        FragmentViewModelLazyKt$activityViewModels$1 fragmentViewModelLazyKt$activityViewModels$1 = new FragmentViewModelLazyKt$activityViewModels$1(fragment);
        FragmentViewModelLazyKt$activityViewModels$2 fragmentViewModelLazyKt$activityViewModels$2 = new FragmentViewModelLazyKt$activityViewModels$2(fragment);
        if (aVar == null) {
            aVar = new FragmentViewModelLazyKt$activityViewModels$3(fragment);
        }
        return h(fragment, dVarD, fragmentViewModelLazyKt$activityViewModels$1, fragmentViewModelLazyKt$activityViewModels$2, aVar);
    }

    @g.k0
    public static final /* synthetic */ <VM extends x0> kotlin.z<VM> d(Fragment fragment, ik.a<? extends p1.a> aVar, ik.a<? extends z0.b> aVar2) {
        kotlin.jvm.internal.f0.p(fragment, "<this>");
        kotlin.jvm.internal.f0.y(4, "VM");
        kotlin.reflect.d dVarD = kotlin.jvm.internal.n0.d(x0.class);
        FragmentViewModelLazyKt$activityViewModels$4 fragmentViewModelLazyKt$activityViewModels$4 = new FragmentViewModelLazyKt$activityViewModels$4(fragment);
        FragmentViewModelLazyKt$activityViewModels$5 fragmentViewModelLazyKt$activityViewModels$5 = new FragmentViewModelLazyKt$activityViewModels$5(aVar, fragment);
        if (aVar2 == null) {
            aVar2 = new FragmentViewModelLazyKt$activityViewModels$6(fragment);
        }
        return h(fragment, dVarD, fragmentViewModelLazyKt$activityViewModels$4, fragmentViewModelLazyKt$activityViewModels$5, aVar2);
    }

    public static /* synthetic */ kotlin.z e(Fragment fragment, ik.a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            aVar = null;
        }
        kotlin.jvm.internal.f0.p(fragment, "<this>");
        kotlin.jvm.internal.f0.y(4, "VM");
        kotlin.reflect.d dVarD = kotlin.jvm.internal.n0.d(x0.class);
        FragmentViewModelLazyKt$activityViewModels$1 fragmentViewModelLazyKt$activityViewModels$1 = new FragmentViewModelLazyKt$activityViewModels$1(fragment);
        FragmentViewModelLazyKt$activityViewModels$2 fragmentViewModelLazyKt$activityViewModels$2 = new FragmentViewModelLazyKt$activityViewModels$2(fragment);
        if (aVar == null) {
            aVar = new FragmentViewModelLazyKt$activityViewModels$3(fragment);
        }
        return h(fragment, dVarD, fragmentViewModelLazyKt$activityViewModels$1, fragmentViewModelLazyKt$activityViewModels$2, aVar);
    }

    public static /* synthetic */ kotlin.z f(Fragment fragment, ik.a aVar, ik.a aVar2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            aVar = null;
        }
        if ((i10 & 2) != 0) {
            aVar2 = null;
        }
        kotlin.jvm.internal.f0.p(fragment, "<this>");
        kotlin.jvm.internal.f0.y(4, "VM");
        kotlin.reflect.d dVarD = kotlin.jvm.internal.n0.d(x0.class);
        FragmentViewModelLazyKt$activityViewModels$4 fragmentViewModelLazyKt$activityViewModels$4 = new FragmentViewModelLazyKt$activityViewModels$4(fragment);
        FragmentViewModelLazyKt$activityViewModels$5 fragmentViewModelLazyKt$activityViewModels$5 = new FragmentViewModelLazyKt$activityViewModels$5(aVar, fragment);
        if (aVar2 == null) {
            aVar2 = new FragmentViewModelLazyKt$activityViewModels$6(fragment);
        }
        return h(fragment, dVarD, fragmentViewModelLazyKt$activityViewModels$4, fragmentViewModelLazyKt$activityViewModels$5, aVar2);
    }

    @g.k0
    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Superseded by createViewModelLazy that takes a CreationExtras producer")
    public static final /* synthetic */ kotlin.z g(final Fragment fragment, kotlin.reflect.d viewModelClass, ik.a storeProducer, ik.a aVar) {
        kotlin.jvm.internal.f0.p(fragment, "<this>");
        kotlin.jvm.internal.f0.p(viewModelClass, "viewModelClass");
        kotlin.jvm.internal.f0.p(storeProducer, "storeProducer");
        return h(fragment, viewModelClass, storeProducer, new ik.a<p1.a>() { // from class: androidx.fragment.app.FragmentViewModelLazyKt$createViewModelLazy$1
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final p1.a o() {
                p1.a defaultViewModelCreationExtras = fragment.j0();
                kotlin.jvm.internal.f0.o(defaultViewModelCreationExtras, "defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, aVar);
    }

    @g.k0
    @yt.k
    public static final <VM extends x0> kotlin.z<VM> h(@yt.k final Fragment fragment, @yt.k kotlin.reflect.d<VM> viewModelClass, @yt.k ik.a<? extends c1> storeProducer, @yt.k ik.a<? extends p1.a> extrasProducer, @yt.l ik.a<? extends z0.b> aVar) {
        kotlin.jvm.internal.f0.p(fragment, "<this>");
        kotlin.jvm.internal.f0.p(viewModelClass, "viewModelClass");
        kotlin.jvm.internal.f0.p(storeProducer, "storeProducer");
        kotlin.jvm.internal.f0.p(extrasProducer, "extrasProducer");
        if (aVar == null) {
            aVar = new ik.a<z0.b>() { // from class: androidx.fragment.app.FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1
                {
                    super(0);
                }

                @Override // ik.a
                @yt.k
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final z0.b o() {
                    z0.b defaultViewModelProviderFactory = fragment.h0();
                    kotlin.jvm.internal.f0.o(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
                    return defaultViewModelProviderFactory;
                }
            };
        }
        return new ViewModelLazy(viewModelClass, storeProducer, aVar, extrasProducer);
    }

    public static /* synthetic */ kotlin.z i(Fragment fragment, kotlin.reflect.d dVar, ik.a aVar, ik.a aVar2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            aVar2 = null;
        }
        return g(fragment, dVar, aVar, aVar2);
    }

    public static /* synthetic */ kotlin.z j(final Fragment fragment, kotlin.reflect.d dVar, ik.a aVar, ik.a aVar2, ik.a aVar3, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            aVar2 = new ik.a<p1.a>() { // from class: androidx.fragment.app.FragmentViewModelLazyKt$createViewModelLazy$2
                {
                    super(0);
                }

                @Override // ik.a
                @yt.k
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final p1.a o() {
                    p1.a defaultViewModelCreationExtras = fragment.j0();
                    kotlin.jvm.internal.f0.o(defaultViewModelCreationExtras, "defaultViewModelCreationExtras");
                    return defaultViewModelCreationExtras;
                }
            };
        }
        if ((i10 & 8) != 0) {
            aVar3 = null;
        }
        return h(fragment, dVar, aVar, aVar2, aVar3);
    }

    @g.k0
    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Superseded by viewModels that takes a CreationExtras producer")
    public static final /* synthetic */ <VM extends x0> kotlin.z<VM> k(Fragment fragment, ik.a<? extends d1> ownerProducer, ik.a<? extends z0.b> aVar) {
        kotlin.jvm.internal.f0.p(fragment, "<this>");
        kotlin.jvm.internal.f0.p(ownerProducer, "ownerProducer");
        kotlin.z zVarC = kotlin.b0.c(LazyThreadSafetyMode.NONE, new FragmentViewModelLazyKt$viewModels$owner$2(ownerProducer));
        kotlin.jvm.internal.f0.y(4, "VM");
        kotlin.reflect.d dVarD = kotlin.jvm.internal.n0.d(x0.class);
        FragmentViewModelLazyKt$viewModels$2 fragmentViewModelLazyKt$viewModels$2 = new FragmentViewModelLazyKt$viewModels$2(zVarC);
        FragmentViewModelLazyKt$viewModels$3 fragmentViewModelLazyKt$viewModels$3 = new FragmentViewModelLazyKt$viewModels$3(zVarC);
        if (aVar == null) {
            aVar = new FragmentViewModelLazyKt$viewModels$4(fragment, zVarC);
        }
        return h(fragment, dVarD, fragmentViewModelLazyKt$viewModels$2, fragmentViewModelLazyKt$viewModels$3, aVar);
    }

    @g.k0
    public static final /* synthetic */ <VM extends x0> kotlin.z<VM> l(Fragment fragment, ik.a<? extends d1> ownerProducer, ik.a<? extends p1.a> aVar, ik.a<? extends z0.b> aVar2) {
        kotlin.jvm.internal.f0.p(fragment, "<this>");
        kotlin.jvm.internal.f0.p(ownerProducer, "ownerProducer");
        kotlin.z zVarC = kotlin.b0.c(LazyThreadSafetyMode.NONE, new FragmentViewModelLazyKt$viewModels$owner$4(ownerProducer));
        kotlin.jvm.internal.f0.y(4, "VM");
        kotlin.reflect.d dVarD = kotlin.jvm.internal.n0.d(x0.class);
        FragmentViewModelLazyKt$viewModels$6 fragmentViewModelLazyKt$viewModels$6 = new FragmentViewModelLazyKt$viewModels$6(zVarC);
        FragmentViewModelLazyKt$viewModels$7 fragmentViewModelLazyKt$viewModels$7 = new FragmentViewModelLazyKt$viewModels$7(aVar, zVarC);
        if (aVar2 == null) {
            aVar2 = new FragmentViewModelLazyKt$viewModels$8(fragment, zVarC);
        }
        return h(fragment, dVarD, fragmentViewModelLazyKt$viewModels$6, fragmentViewModelLazyKt$viewModels$7, aVar2);
    }

    public static /* synthetic */ kotlin.z m(final Fragment fragment, ik.a ownerProducer, ik.a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            ownerProducer = new ik.a<Fragment>() { // from class: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$1
                {
                    super(0);
                }

                @Override // ik.a
                @yt.k
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Fragment o() {
                    return fragment;
                }
            };
        }
        if ((i10 & 2) != 0) {
            aVar = null;
        }
        kotlin.jvm.internal.f0.p(fragment, "<this>");
        kotlin.jvm.internal.f0.p(ownerProducer, "ownerProducer");
        kotlin.z zVarC = kotlin.b0.c(LazyThreadSafetyMode.NONE, new FragmentViewModelLazyKt$viewModels$owner$2(ownerProducer));
        kotlin.jvm.internal.f0.y(4, "VM");
        kotlin.reflect.d dVarD = kotlin.jvm.internal.n0.d(x0.class);
        FragmentViewModelLazyKt$viewModels$2 fragmentViewModelLazyKt$viewModels$2 = new FragmentViewModelLazyKt$viewModels$2(zVarC);
        FragmentViewModelLazyKt$viewModels$3 fragmentViewModelLazyKt$viewModels$3 = new FragmentViewModelLazyKt$viewModels$3(zVarC);
        if (aVar == null) {
            aVar = new FragmentViewModelLazyKt$viewModels$4(fragment, zVarC);
        }
        return h(fragment, dVarD, fragmentViewModelLazyKt$viewModels$2, fragmentViewModelLazyKt$viewModels$3, aVar);
    }

    public static /* synthetic */ kotlin.z n(final Fragment fragment, ik.a ownerProducer, ik.a aVar, ik.a aVar2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            ownerProducer = new ik.a<Fragment>() { // from class: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$5
                {
                    super(0);
                }

                @Override // ik.a
                @yt.k
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Fragment o() {
                    return fragment;
                }
            };
        }
        if ((i10 & 2) != 0) {
            aVar = null;
        }
        if ((i10 & 4) != 0) {
            aVar2 = null;
        }
        kotlin.jvm.internal.f0.p(fragment, "<this>");
        kotlin.jvm.internal.f0.p(ownerProducer, "ownerProducer");
        kotlin.z zVarC = kotlin.b0.c(LazyThreadSafetyMode.NONE, new FragmentViewModelLazyKt$viewModels$owner$4(ownerProducer));
        kotlin.jvm.internal.f0.y(4, "VM");
        kotlin.reflect.d dVarD = kotlin.jvm.internal.n0.d(x0.class);
        FragmentViewModelLazyKt$viewModels$6 fragmentViewModelLazyKt$viewModels$6 = new FragmentViewModelLazyKt$viewModels$6(zVarC);
        FragmentViewModelLazyKt$viewModels$7 fragmentViewModelLazyKt$viewModels$7 = new FragmentViewModelLazyKt$viewModels$7(aVar, zVarC);
        if (aVar2 == null) {
            aVar2 = new FragmentViewModelLazyKt$viewModels$8(fragment, zVarC);
        }
        return h(fragment, dVarD, fragmentViewModelLazyKt$viewModels$6, fragmentViewModelLazyKt$viewModels$7, aVar2);
    }

    public static final d1 o(kotlin.z<? extends d1> zVar) {
        return zVar.getValue();
    }

    public static final d1 p(kotlin.z<? extends d1> zVar) {
        return zVar.getValue();
    }
}
