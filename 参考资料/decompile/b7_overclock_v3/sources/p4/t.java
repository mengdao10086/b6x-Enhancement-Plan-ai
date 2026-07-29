package p4;

import g.n0;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class t implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<s4.p<?>> f46417a = Collections.newSetFromMap(new WeakHashMap());

    @Override // p4.m
    public void a() {
        Iterator it2 = v4.o.k(this.f46417a).iterator();
        while (it2.hasNext()) {
            ((s4.p) it2.next()).a();
        }
    }

    @Override // p4.m
    public void b() {
        Iterator it2 = v4.o.k(this.f46417a).iterator();
        while (it2.hasNext()) {
            ((s4.p) it2.next()).b();
        }
    }

    @Override // p4.m
    public void c() {
        Iterator it2 = v4.o.k(this.f46417a).iterator();
        while (it2.hasNext()) {
            ((s4.p) it2.next()).c();
        }
    }

    public void d() {
        this.f46417a.clear();
    }

    @n0
    public List<s4.p<?>> e() {
        return v4.o.k(this.f46417a);
    }

    public void h(@n0 s4.p<?> pVar) {
        this.f46417a.add(pVar);
    }

    public void i(@n0 s4.p<?> pVar) {
        this.f46417a.remove(pVar);
    }
}
