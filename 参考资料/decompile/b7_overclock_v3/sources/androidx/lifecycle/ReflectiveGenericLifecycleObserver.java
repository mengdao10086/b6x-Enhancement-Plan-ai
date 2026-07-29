package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.d;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
class ReflectiveGenericLifecycleObserver implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f6108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d.a f6109b;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f6108a = obj;
        this.f6109b = d.f6176c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.v
    public void c(@g.n0 y yVar, @g.n0 Lifecycle.Event event) {
        this.f6109b.a(yVar, event, this.f6108a);
    }
}
