package tt;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.EventBusException;
import tt.f;

/* JADX INFO: loaded from: classes6.dex */
public class d {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ExecutorService f51666n = Executors.newCachedThreadPool();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f51671e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f51673g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f51674h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<Class<?>> f51676j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<vt.d> f51677k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public f f51678l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public g f51679m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f51667a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f51668b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f51669c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f51670d = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f51672f = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ExecutorService f51675i = f51666n;

    public d a(vt.d dVar) {
        if (this.f51677k == null) {
            this.f51677k = new ArrayList();
        }
        this.f51677k.add(dVar);
        return this;
    }

    public c b() {
        return new c(this);
    }

    public d c(boolean z10) {
        this.f51672f = z10;
        return this;
    }

    public d d(ExecutorService executorService) {
        this.f51675i = executorService;
        return this;
    }

    public f e() {
        f fVar = this.f51678l;
        return fVar != null ? fVar : f.a.a();
    }

    public g f() {
        g gVar = this.f51679m;
        if (gVar != null) {
            return gVar;
        }
        if (ut.a.a()) {
            return ut.a.b().f52443b;
        }
        return null;
    }

    public d g(boolean z10) {
        this.f51673g = z10;
        return this;
    }

    public c h() {
        c cVar;
        synchronized (c.class) {
            if (c.f51637t != null) {
                throw new EventBusException("Default instance already exists. It may be only set once before it's used the first time to ensure consistent behavior.");
            }
            c.f51637t = b();
            cVar = c.f51637t;
        }
        return cVar;
    }

    public d i(boolean z10) {
        this.f51668b = z10;
        return this;
    }

    public d j(boolean z10) {
        this.f51667a = z10;
        return this;
    }

    public d k(f fVar) {
        this.f51678l = fVar;
        return this;
    }

    public d l(boolean z10) {
        this.f51670d = z10;
        return this;
    }

    public d m(boolean z10) {
        this.f51669c = z10;
        return this;
    }

    public d n(Class<?> cls) {
        if (this.f51676j == null) {
            this.f51676j = new ArrayList();
        }
        this.f51676j.add(cls);
        return this;
    }

    public d o(boolean z10) {
        this.f51674h = z10;
        return this;
    }

    public d p(boolean z10) {
        this.f51671e = z10;
        return this;
    }
}
