package androidx.lifecycle;

import androidx.lifecycle.x0;
import androidx.lifecycle.z0;
import p1.a;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewModelLazy<VM extends x0> implements kotlin.z<VM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final kotlin.reflect.d<VM> f6139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final ik.a<c1> f6140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final ik.a<z0.b> f6141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final ik.a<p1.a> f6142d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.l
    public VM f6143e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @hk.i
    public ViewModelLazy(@yt.k kotlin.reflect.d<VM> viewModelClass, @yt.k ik.a<? extends c1> storeProducer, @yt.k ik.a<? extends z0.b> factoryProducer) {
        this(viewModelClass, storeProducer, factoryProducer, null, 8, null);
        kotlin.jvm.internal.f0.p(viewModelClass, "viewModelClass");
        kotlin.jvm.internal.f0.p(storeProducer, "storeProducer");
        kotlin.jvm.internal.f0.p(factoryProducer, "factoryProducer");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @hk.i
    public ViewModelLazy(@yt.k kotlin.reflect.d<VM> viewModelClass, @yt.k ik.a<? extends c1> storeProducer, @yt.k ik.a<? extends z0.b> factoryProducer, @yt.k ik.a<? extends p1.a> extrasProducer) {
        kotlin.jvm.internal.f0.p(viewModelClass, "viewModelClass");
        kotlin.jvm.internal.f0.p(storeProducer, "storeProducer");
        kotlin.jvm.internal.f0.p(factoryProducer, "factoryProducer");
        kotlin.jvm.internal.f0.p(extrasProducer, "extrasProducer");
        this.f6139a = viewModelClass;
        this.f6140b = storeProducer;
        this.f6141c = factoryProducer;
        this.f6142d = extrasProducer;
    }

    @Override // kotlin.z
    public boolean a() {
        return this.f6143e != null;
    }

    @Override // kotlin.z
    @yt.k
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public VM getValue() {
        VM vm2 = this.f6143e;
        if (vm2 != null) {
            return vm2;
        }
        VM vm3 = (VM) new z0(this.f6140b.o(), this.f6141c.o(), this.f6142d.o()).a(hk.a.e(this.f6139a));
        this.f6143e = vm3;
        return vm3;
    }

    public /* synthetic */ ViewModelLazy(kotlin.reflect.d dVar, ik.a aVar, ik.a aVar2, ik.a aVar3, int i10, kotlin.jvm.internal.u uVar) {
        this(dVar, aVar, aVar2, (i10 & 8) != 0 ? new ik.a<a.C0519a>() { // from class: androidx.lifecycle.ViewModelLazy.1
            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final a.C0519a o() {
                return a.C0519a.f46302b;
            }
        } : aVar3);
    }
}
