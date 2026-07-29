package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.c;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.load.engine.s;
import g.b0;
import g.n0;
import g.p0;
import g.v;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import s4.o;
import s4.p;

/* JADX INFO: loaded from: classes2.dex */
public final class SingleRequest<R> implements e, o, i {
    public static final String F = "Glide";

    @b0("requestLock")
    public int A;

    @b0("requestLock")
    public int B;

    @b0("requestLock")
    public boolean C;

    @p0
    public RuntimeException D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final String f12684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w4.c f12685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f12686d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public final g<R> f12687e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RequestCoordinator f12688f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f12689g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bumptech.glide.d f12690h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public final Object f12691i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Class<R> f12692j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a<?> f12693k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f12694l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f12695m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Priority f12696n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final p<R> f12697o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @p0
    public final List<g<R>> f12698p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final t4.g<? super R> f12699q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Executor f12700r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @b0("requestLock")
    public s<R> f12701s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @b0("requestLock")
    public i.d f12702t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @b0("requestLock")
    public long f12703u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile com.bumptech.glide.load.engine.i f12704v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @b0("requestLock")
    public Status f12705w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @p0
    @b0("requestLock")
    public Drawable f12706x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @p0
    @b0("requestLock")
    public Drawable f12707y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @p0
    @b0("requestLock")
    public Drawable f12708z;
    public static final String E = "GlideRequest";
    public static final boolean G = Log.isLoggable(E, 2);

    public enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public SingleRequest(Context context, com.bumptech.glide.d dVar, @n0 Object obj, @p0 Object obj2, Class<R> cls, a<?> aVar, int i10, int i11, Priority priority, p<R> pVar, @p0 g<R> gVar, @p0 List<g<R>> list, RequestCoordinator requestCoordinator, com.bumptech.glide.load.engine.i iVar, t4.g<? super R> gVar2, Executor executor) {
        this.f12684b = G ? String.valueOf(super.hashCode()) : null;
        this.f12685c = w4.c.a();
        this.f12686d = obj;
        this.f12689g = context;
        this.f12690h = dVar;
        this.f12691i = obj2;
        this.f12692j = cls;
        this.f12693k = aVar;
        this.f12694l = i10;
        this.f12695m = i11;
        this.f12696n = priority;
        this.f12697o = pVar;
        this.f12687e = gVar;
        this.f12698p = list;
        this.f12688f = requestCoordinator;
        this.f12704v = iVar;
        this.f12699q = gVar2;
        this.f12700r = executor;
        this.f12705w = Status.PENDING;
        if (this.D == null && dVar.g().b(c.e.class)) {
            this.D = new RuntimeException("Glide request origin trace");
        }
    }

    public static int u(int i10, float f10) {
        return i10 == Integer.MIN_VALUE ? i10 : Math.round(f10 * i10);
    }

    public static <R> SingleRequest<R> x(Context context, com.bumptech.glide.d dVar, Object obj, Object obj2, Class<R> cls, a<?> aVar, int i10, int i11, Priority priority, p<R> pVar, g<R> gVar, @p0 List<g<R>> list, RequestCoordinator requestCoordinator, com.bumptech.glide.load.engine.i iVar, t4.g<? super R> gVar2, Executor executor) {
        return new SingleRequest<>(context, dVar, obj, obj2, cls, aVar, i10, i11, priority, pVar, gVar, list, requestCoordinator, iVar, gVar2, executor);
    }

    @b0("requestLock")
    public final void A() {
        if (k()) {
            Drawable drawableP = this.f12691i == null ? p() : null;
            if (drawableP == null) {
                drawableP = o();
            }
            if (drawableP == null) {
                drawableP = q();
            }
            this.f12697o.n(drawableP);
        }
    }

    @Override // com.bumptech.glide.request.i
    public void a(GlideException glideException) {
        y(glideException, 5);
    }

    @Override // com.bumptech.glide.request.e
    public boolean b() {
        boolean z10;
        synchronized (this.f12686d) {
            z10 = this.f12705w == Status.COMPLETE;
        }
        return z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.i
    public void c(s<?> sVar, DataSource dataSource, boolean z10) {
        this.f12685c.c();
        s<?> sVar2 = null;
        try {
            synchronized (this.f12686d) {
                try {
                    this.f12702t = null;
                    if (sVar == null) {
                        a(new GlideException("Expected to receive a Resource<R> with an object of " + this.f12692j + " inside, but instead got null."));
                        return;
                    }
                    Object obj = sVar.get();
                    try {
                        if (obj != null && this.f12692j.isAssignableFrom(obj.getClass())) {
                            if (l()) {
                                z(sVar, obj, dataSource, z10);
                                return;
                            }
                            this.f12701s = null;
                            this.f12705w = Status.COMPLETE;
                            w4.b.g(E, this.f12683a);
                            this.f12704v.l(sVar);
                            return;
                        }
                        this.f12701s = null;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Expected to receive an object of ");
                        sb2.append(this.f12692j);
                        sb2.append(" but instead got ");
                        sb2.append(obj != null ? obj.getClass() : "");
                        sb2.append(zc.a.f58316d);
                        sb2.append(obj);
                        sb2.append("} inside Resource{");
                        sb2.append(sVar);
                        sb2.append("}.");
                        sb2.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                        a(new GlideException(sb2.toString()));
                        this.f12704v.l(sVar);
                    } catch (Throwable th2) {
                        sVar2 = sVar;
                        th = th2;
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        } catch (Throwable th4) {
            if (sVar2 != null) {
                this.f12704v.l(sVar2);
            }
            throw th4;
        }
    }

    @Override // com.bumptech.glide.request.e
    public void clear() {
        synchronized (this.f12686d) {
            i();
            this.f12685c.c();
            Status status = this.f12705w;
            Status status2 = Status.CLEARED;
            if (status == status2) {
                return;
            }
            m();
            s<R> sVar = this.f12701s;
            if (sVar != null) {
                this.f12701s = null;
            } else {
                sVar = null;
            }
            if (j()) {
                this.f12697o.s(q());
            }
            w4.b.g(E, this.f12683a);
            this.f12705w = status2;
            if (sVar != null) {
                this.f12704v.l(sVar);
            }
        }
    }

    @Override // com.bumptech.glide.request.e
    public boolean d(e eVar) {
        int i10;
        int i11;
        Object obj;
        Class<R> cls;
        a<?> aVar;
        Priority priority;
        int size;
        int i12;
        int i13;
        Object obj2;
        Class<R> cls2;
        a<?> aVar2;
        Priority priority2;
        int size2;
        if (!(eVar instanceof SingleRequest)) {
            return false;
        }
        synchronized (this.f12686d) {
            i10 = this.f12694l;
            i11 = this.f12695m;
            obj = this.f12691i;
            cls = this.f12692j;
            aVar = this.f12693k;
            priority = this.f12696n;
            List<g<R>> list = this.f12698p;
            size = list != null ? list.size() : 0;
        }
        SingleRequest singleRequest = (SingleRequest) eVar;
        synchronized (singleRequest.f12686d) {
            i12 = singleRequest.f12694l;
            i13 = singleRequest.f12695m;
            obj2 = singleRequest.f12691i;
            cls2 = singleRequest.f12692j;
            aVar2 = singleRequest.f12693k;
            priority2 = singleRequest.f12696n;
            List<g<R>> list2 = singleRequest.f12698p;
            size2 = list2 != null ? list2.size() : 0;
        }
        return i10 == i12 && i11 == i13 && v4.o.c(obj, obj2) && cls.equals(cls2) && aVar.equals(aVar2) && priority == priority2 && size == size2;
    }

    @Override // s4.o
    public void e(int i10, int i11) throws Throwable {
        Object obj;
        this.f12685c.c();
        Object obj2 = this.f12686d;
        synchronized (obj2) {
            try {
                try {
                    boolean z10 = G;
                    if (z10) {
                        t("Got onSizeReady in " + v4.i.a(this.f12703u));
                    }
                    if (this.f12705w == Status.WAITING_FOR_SIZE) {
                        Status status = Status.RUNNING;
                        this.f12705w = status;
                        float fY = this.f12693k.Y();
                        this.A = u(i10, fY);
                        this.B = u(i11, fY);
                        if (z10) {
                            t("finished setup for calling load in " + v4.i.a(this.f12703u));
                        }
                        obj = obj2;
                        try {
                            this.f12702t = this.f12704v.g(this.f12690h, this.f12691i, this.f12693k.V(), this.A, this.B, this.f12693k.S(), this.f12692j, this.f12696n, this.f12693k.F(), this.f12693k.c0(), this.f12693k.p0(), this.f12693k.k0(), this.f12693k.L(), this.f12693k.i0(), this.f12693k.e0(), this.f12693k.d0(), this.f12693k.K(), this, this.f12700r);
                            if (this.f12705w != status) {
                                this.f12702t = null;
                            }
                            if (z10) {
                                t("finished onSizeReady in " + v4.i.a(this.f12703u));
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                obj = obj2;
            }
        }
    }

    @Override // com.bumptech.glide.request.e
    public boolean f() {
        boolean z10;
        synchronized (this.f12686d) {
            z10 = this.f12705w == Status.CLEARED;
        }
        return z10;
    }

    @Override // com.bumptech.glide.request.i
    public Object g() {
        this.f12685c.c();
        return this.f12686d;
    }

    @Override // com.bumptech.glide.request.e
    public void h() {
        synchronized (this.f12686d) {
            i();
            this.f12685c.c();
            this.f12703u = v4.i.b();
            Object obj = this.f12691i;
            if (obj == null) {
                if (v4.o.w(this.f12694l, this.f12695m)) {
                    this.A = this.f12694l;
                    this.B = this.f12695m;
                }
                y(new GlideException("Received null model"), p() == null ? 5 : 3);
                return;
            }
            Status status = this.f12705w;
            Status status2 = Status.RUNNING;
            if (status == status2) {
                throw new IllegalArgumentException("Cannot restart a running request");
            }
            if (status == Status.COMPLETE) {
                c(this.f12701s, DataSource.MEMORY_CACHE, false);
                return;
            }
            n(obj);
            this.f12683a = w4.b.b(E);
            Status status3 = Status.WAITING_FOR_SIZE;
            this.f12705w = status3;
            if (v4.o.w(this.f12694l, this.f12695m)) {
                e(this.f12694l, this.f12695m);
            } else {
                this.f12697o.m(this);
            }
            Status status4 = this.f12705w;
            if ((status4 == status2 || status4 == status3) && k()) {
                this.f12697o.q(q());
            }
            if (G) {
                t("finished run method in " + v4.i.a(this.f12703u));
            }
        }
    }

    @b0("requestLock")
    public final void i() {
        if (this.C) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @Override // com.bumptech.glide.request.e
    public boolean isComplete() {
        boolean z10;
        synchronized (this.f12686d) {
            z10 = this.f12705w == Status.COMPLETE;
        }
        return z10;
    }

    @Override // com.bumptech.glide.request.e
    public boolean isRunning() {
        boolean z10;
        synchronized (this.f12686d) {
            Status status = this.f12705w;
            z10 = status == Status.RUNNING || status == Status.WAITING_FOR_SIZE;
        }
        return z10;
    }

    @b0("requestLock")
    public final boolean j() {
        RequestCoordinator requestCoordinator = this.f12688f;
        return requestCoordinator == null || requestCoordinator.i(this);
    }

    @b0("requestLock")
    public final boolean k() {
        RequestCoordinator requestCoordinator = this.f12688f;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    @b0("requestLock")
    public final boolean l() {
        RequestCoordinator requestCoordinator = this.f12688f;
        return requestCoordinator == null || requestCoordinator.e(this);
    }

    @b0("requestLock")
    public final void m() {
        i();
        this.f12685c.c();
        this.f12697o.f(this);
        i.d dVar = this.f12702t;
        if (dVar != null) {
            dVar.a();
            this.f12702t = null;
        }
    }

    public final void n(Object obj) {
        List<g<R>> list = this.f12698p;
        if (list == null) {
            return;
        }
        for (g<R> gVar : list) {
            if (gVar instanceof c) {
                ((c) gVar).a(obj);
            }
        }
    }

    @b0("requestLock")
    public final Drawable o() {
        if (this.f12706x == null) {
            Drawable drawableH = this.f12693k.H();
            this.f12706x = drawableH;
            if (drawableH == null && this.f12693k.G() > 0) {
                this.f12706x = s(this.f12693k.G());
            }
        }
        return this.f12706x;
    }

    @b0("requestLock")
    public final Drawable p() {
        if (this.f12708z == null) {
            Drawable drawableI = this.f12693k.I();
            this.f12708z = drawableI;
            if (drawableI == null && this.f12693k.J() > 0) {
                this.f12708z = s(this.f12693k.J());
            }
        }
        return this.f12708z;
    }

    @Override // com.bumptech.glide.request.e
    public void pause() {
        synchronized (this.f12686d) {
            if (isRunning()) {
                clear();
            }
        }
    }

    @b0("requestLock")
    public final Drawable q() {
        if (this.f12707y == null) {
            Drawable drawableP = this.f12693k.P();
            this.f12707y = drawableP;
            if (drawableP == null && this.f12693k.Q() > 0) {
                this.f12707y = s(this.f12693k.Q());
            }
        }
        return this.f12707y;
    }

    @b0("requestLock")
    public final boolean r() {
        RequestCoordinator requestCoordinator = this.f12688f;
        return requestCoordinator == null || !requestCoordinator.getRoot().b();
    }

    @b0("requestLock")
    public final Drawable s(@v int i10) {
        return l4.b.a(this.f12690h, i10, this.f12693k.a0() != null ? this.f12693k.a0() : this.f12689g.getTheme());
    }

    public final void t(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" this: ");
        sb2.append(this.f12684b);
    }

    public String toString() {
        Object obj;
        Class<R> cls;
        synchronized (this.f12686d) {
            obj = this.f12691i;
            cls = this.f12692j;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + "]";
    }

    @b0("requestLock")
    public final void v() {
        RequestCoordinator requestCoordinator = this.f12688f;
        if (requestCoordinator != null) {
            requestCoordinator.a(this);
        }
    }

    @b0("requestLock")
    public final void w() {
        RequestCoordinator requestCoordinator = this.f12688f;
        if (requestCoordinator != null) {
            requestCoordinator.g(this);
        }
    }

    public final void y(GlideException glideException, int i10) {
        boolean zD;
        this.f12685c.c();
        synchronized (this.f12686d) {
            glideException.o(this.D);
            int iH = this.f12690h.h();
            if (iH <= i10) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Load failed for ");
                sb2.append(this.f12691i);
                sb2.append(" with size [");
                sb2.append(this.A);
                sb2.append("x");
                sb2.append(this.B);
                sb2.append("]");
                if (iH <= 4) {
                    glideException.k("Glide");
                }
            }
            this.f12702t = null;
            this.f12705w = Status.FAILED;
            boolean z10 = true;
            this.C = true;
            try {
                List<g<R>> list = this.f12698p;
                if (list != null) {
                    Iterator<g<R>> it2 = list.iterator();
                    zD = false;
                    while (it2.hasNext()) {
                        zD |= it2.next().d(glideException, this.f12691i, this.f12697o, r());
                    }
                } else {
                    zD = false;
                }
                g<R> gVar = this.f12687e;
                if (gVar == null || !gVar.d(glideException, this.f12691i, this.f12697o, r())) {
                    z10 = false;
                }
                if (!(zD | z10)) {
                    A();
                }
                this.C = false;
                v();
                w4.b.g(E, this.f12683a);
            } catch (Throwable th2) {
                this.C = false;
                throw th2;
            }
        }
    }

    @b0("requestLock")
    public final void z(s<R> sVar, R r10, DataSource dataSource, boolean z10) {
        boolean zE;
        boolean zR = r();
        this.f12705w = Status.COMPLETE;
        this.f12701s = sVar;
        if (this.f12690h.h() <= 3) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Finished loading ");
            sb2.append(r10.getClass().getSimpleName());
            sb2.append(" from ");
            sb2.append(dataSource);
            sb2.append(" for ");
            sb2.append(this.f12691i);
            sb2.append(" with size [");
            sb2.append(this.A);
            sb2.append("x");
            sb2.append(this.B);
            sb2.append("] in ");
            sb2.append(v4.i.a(this.f12703u));
            sb2.append(" ms");
        }
        boolean z11 = true;
        this.C = true;
        try {
            List<g<R>> list = this.f12698p;
            if (list != null) {
                Iterator<g<R>> it2 = list.iterator();
                zE = false;
                while (it2.hasNext()) {
                    zE |= it2.next().e(r10, this.f12691i, this.f12697o, dataSource, zR);
                }
            } else {
                zE = false;
            }
            g<R> gVar = this.f12687e;
            if (gVar == null || !gVar.e(r10, this.f12691i, this.f12697o, dataSource, zR)) {
                z11 = false;
            }
            if (!(z11 | zE)) {
                this.f12697o.g(r10, this.f12699q.a(dataSource, zR));
            }
            this.C = false;
            w();
            w4.b.g(E, this.f12683a);
        } catch (Throwable th2) {
            this.C = false;
            throw th2;
        }
    }
}
