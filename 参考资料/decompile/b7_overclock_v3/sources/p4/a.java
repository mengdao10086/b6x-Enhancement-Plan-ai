package p4;

import g.n0;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class a implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<m> f46361a = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f46362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f46363c;

    @Override // p4.l
    public void a(@n0 m mVar) {
        this.f46361a.add(mVar);
        if (this.f46363c) {
            mVar.a();
        } else if (this.f46362b) {
            mVar.b();
        } else {
            mVar.c();
        }
    }

    @Override // p4.l
    public void b(@n0 m mVar) {
        this.f46361a.remove(mVar);
    }

    public void c() {
        this.f46363c = true;
        Iterator it2 = v4.o.k(this.f46361a).iterator();
        while (it2.hasNext()) {
            ((m) it2.next()).a();
        }
    }

    public void d() {
        this.f46362b = true;
        Iterator it2 = v4.o.k(this.f46361a).iterator();
        while (it2.hasNext()) {
            ((m) it2.next()).b();
        }
    }

    public void e() {
        this.f46362b = false;
        Iterator it2 = v4.o.k(this.f46361a).iterator();
        while (it2.hasNext()) {
            ((m) it2.next()).c();
        }
    }
}
