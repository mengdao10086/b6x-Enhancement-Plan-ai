package p4;

import g.i1;
import g.n0;
import g.p0;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f46392d = "RequestTracker";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<com.bumptech.glide.request.e> f46393a = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<com.bumptech.glide.request.e> f46394b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f46395c;

    @i1
    public void a(com.bumptech.glide.request.e eVar) {
        this.f46393a.add(eVar);
    }

    public boolean b(@p0 com.bumptech.glide.request.e eVar) {
        boolean z10 = true;
        if (eVar == null) {
            return true;
        }
        boolean zRemove = this.f46393a.remove(eVar);
        if (!this.f46394b.remove(eVar) && !zRemove) {
            z10 = false;
        }
        if (z10) {
            eVar.clear();
        }
        return z10;
    }

    public void c() {
        Iterator it2 = v4.o.k(this.f46393a).iterator();
        while (it2.hasNext()) {
            b((com.bumptech.glide.request.e) it2.next());
        }
        this.f46394b.clear();
    }

    public boolean d() {
        return this.f46395c;
    }

    public void e() {
        this.f46395c = true;
        for (com.bumptech.glide.request.e eVar : v4.o.k(this.f46393a)) {
            if (eVar.isRunning() || eVar.isComplete()) {
                eVar.clear();
                this.f46394b.add(eVar);
            }
        }
    }

    public void f() {
        this.f46395c = true;
        for (com.bumptech.glide.request.e eVar : v4.o.k(this.f46393a)) {
            if (eVar.isRunning()) {
                eVar.pause();
                this.f46394b.add(eVar);
            }
        }
    }

    public void g() {
        for (com.bumptech.glide.request.e eVar : v4.o.k(this.f46393a)) {
            if (!eVar.isComplete() && !eVar.f()) {
                eVar.clear();
                if (this.f46395c) {
                    this.f46394b.add(eVar);
                } else {
                    eVar.h();
                }
            }
        }
    }

    public void h() {
        this.f46395c = false;
        for (com.bumptech.glide.request.e eVar : v4.o.k(this.f46393a)) {
            if (!eVar.isComplete() && !eVar.isRunning()) {
                eVar.h();
            }
        }
        this.f46394b.clear();
    }

    public void i(@n0 com.bumptech.glide.request.e eVar) {
        this.f46393a.add(eVar);
        if (!this.f46395c) {
            eVar.h();
        } else {
            eVar.clear();
            this.f46394b.add(eVar);
        }
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f46393a.size() + ", isPaused=" + this.f46395c + zc.a.f58317e;
    }
}
