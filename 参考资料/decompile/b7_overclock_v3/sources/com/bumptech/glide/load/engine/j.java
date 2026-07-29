package com.bumptech.glide.load.engine;

import androidx.core.util.n;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.n;
import g.b0;
import g.i1;
import g.n0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import w4.a;

/* JADX INFO: loaded from: classes2.dex */
public class j<R> implements DecodeJob.b<R>, a.f {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final c f12411z = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f12412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w4.c f12413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n.a f12414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n.a<j<?>> f12415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f12416e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k f12417f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f4.a f12418g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f4.a f12419h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f4.a f12420i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final f4.a f12421j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicInteger f12422k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c4.b f12423l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f12424m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f12425n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f12426o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f12427p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public s<?> f12428q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public DataSource f12429r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f12430s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public GlideException f12431t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f12432u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public n<?> f12433v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public DecodeJob<R> f12434w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile boolean f12435x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f12436y;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bumptech.glide.request.i f12437a;

        public a(com.bumptech.glide.request.i iVar) {
            this.f12437a = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f12437a.g()) {
                synchronized (j.this) {
                    if (j.this.f12412a.b(this.f12437a)) {
                        j.this.e(this.f12437a);
                    }
                    j.this.i();
                }
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bumptech.glide.request.i f12439a;

        public b(com.bumptech.glide.request.i iVar) {
            this.f12439a = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f12439a.g()) {
                synchronized (j.this) {
                    if (j.this.f12412a.b(this.f12439a)) {
                        j.this.f12433v.b();
                        j.this.g(this.f12439a);
                        j.this.s(this.f12439a);
                    }
                    j.this.i();
                }
            }
        }
    }

    @i1
    public static class c {
        public <R> n<R> a(s<R> sVar, boolean z10, c4.b bVar, n.a aVar) {
            return new n<>(sVar, z10, true, bVar, aVar);
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bumptech.glide.request.i f12441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f12442b;

        public d(com.bumptech.glide.request.i iVar, Executor executor) {
            this.f12441a = iVar;
            this.f12442b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f12441a.equals(((d) obj).f12441a);
            }
            return false;
        }

        public int hashCode() {
            return this.f12441a.hashCode();
        }
    }

    public static final class e implements Iterable<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<d> f12443a;

        public e() {
            this(new ArrayList(2));
        }

        public static d e(com.bumptech.glide.request.i iVar) {
            return new d(iVar, v4.f.a());
        }

        public void a(com.bumptech.glide.request.i iVar, Executor executor) {
            this.f12443a.add(new d(iVar, executor));
        }

        public boolean b(com.bumptech.glide.request.i iVar) {
            return this.f12443a.contains(e(iVar));
        }

        public void clear() {
            this.f12443a.clear();
        }

        public e d() {
            return new e(new ArrayList(this.f12443a));
        }

        public void f(com.bumptech.glide.request.i iVar) {
            this.f12443a.remove(e(iVar));
        }

        public boolean isEmpty() {
            return this.f12443a.isEmpty();
        }

        @Override // java.lang.Iterable
        @n0
        public Iterator<d> iterator() {
            return this.f12443a.iterator();
        }

        public int size() {
            return this.f12443a.size();
        }

        public e(List<d> list) {
            this.f12443a = list;
        }
    }

    public j(f4.a aVar, f4.a aVar2, f4.a aVar3, f4.a aVar4, k kVar, n.a aVar5, n.a<j<?>> aVar6) {
        this(aVar, aVar2, aVar3, aVar4, kVar, aVar5, aVar6, f12411z);
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.b
    public void a(GlideException glideException) {
        synchronized (this) {
            this.f12431t = glideException;
        }
        o();
    }

    public synchronized void b(com.bumptech.glide.request.i iVar, Executor executor) {
        this.f12413b.c();
        this.f12412a.a(iVar, executor);
        boolean z10 = true;
        if (this.f12430s) {
            k(1);
            executor.execute(new b(iVar));
        } else if (this.f12432u) {
            k(1);
            executor.execute(new a(iVar));
        } else {
            if (this.f12435x) {
                z10 = false;
            }
            v4.m.a(z10, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.DecodeJob.b
    public void c(s<R> sVar, DataSource dataSource, boolean z10) {
        synchronized (this) {
            this.f12428q = sVar;
            this.f12429r = dataSource;
            this.f12436y = z10;
        }
        p();
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.b
    public void d(DecodeJob<?> decodeJob) {
        j().execute(decodeJob);
    }

    @b0("this")
    public void e(com.bumptech.glide.request.i iVar) {
        try {
            iVar.a(this.f12431t);
        } catch (Throwable th2) {
            throw new CallbackException(th2);
        }
    }

    @Override // w4.a.f
    @n0
    public w4.c f() {
        return this.f12413b;
    }

    @b0("this")
    public void g(com.bumptech.glide.request.i iVar) {
        try {
            iVar.c(this.f12433v, this.f12429r, this.f12436y);
        } catch (Throwable th2) {
            throw new CallbackException(th2);
        }
    }

    public void h() {
        if (n()) {
            return;
        }
        this.f12435x = true;
        this.f12434w.cancel();
        this.f12417f.b(this, this.f12423l);
    }

    public void i() {
        n<?> nVar;
        synchronized (this) {
            this.f12413b.c();
            v4.m.a(n(), "Not yet complete!");
            int iDecrementAndGet = this.f12422k.decrementAndGet();
            v4.m.a(iDecrementAndGet >= 0, "Can't decrement below 0");
            if (iDecrementAndGet == 0) {
                nVar = this.f12433v;
                r();
            } else {
                nVar = null;
            }
        }
        if (nVar != null) {
            nVar.g();
        }
    }

    public final f4.a j() {
        return this.f12425n ? this.f12420i : this.f12426o ? this.f12421j : this.f12419h;
    }

    public synchronized void k(int i10) {
        n<?> nVar;
        v4.m.a(n(), "Not yet complete!");
        if (this.f12422k.getAndAdd(i10) == 0 && (nVar = this.f12433v) != null) {
            nVar.b();
        }
    }

    @i1
    public synchronized j<R> l(c4.b bVar, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f12423l = bVar;
        this.f12424m = z10;
        this.f12425n = z11;
        this.f12426o = z12;
        this.f12427p = z13;
        return this;
    }

    public synchronized boolean m() {
        return this.f12435x;
    }

    public final boolean n() {
        return this.f12432u || this.f12430s || this.f12435x;
    }

    public void o() {
        synchronized (this) {
            this.f12413b.c();
            if (this.f12435x) {
                r();
                return;
            }
            if (this.f12412a.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
            if (this.f12432u) {
                throw new IllegalStateException("Already failed once");
            }
            this.f12432u = true;
            c4.b bVar = this.f12423l;
            e eVarD = this.f12412a.d();
            k(eVarD.size() + 1);
            this.f12417f.d(this, bVar, null);
            for (d dVar : eVarD) {
                dVar.f12442b.execute(new a(dVar.f12441a));
            }
            i();
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void p() {
        synchronized (this) {
            this.f12413b.c();
            if (this.f12435x) {
                this.f12428q.a();
                r();
                return;
            }
            if (this.f12412a.isEmpty()) {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            }
            if (this.f12430s) {
                throw new IllegalStateException("Already have resource");
            }
            this.f12433v = this.f12416e.a(this.f12428q, this.f12424m, this.f12423l, this.f12414c);
            this.f12430s = true;
            e eVarD = this.f12412a.d();
            k(eVarD.size() + 1);
            this.f12417f.d(this, this.f12423l, this.f12433v);
            for (d dVar : eVarD) {
                dVar.f12442b.execute(new b(dVar.f12441a));
            }
            i();
        }
    }

    public boolean q() {
        return this.f12427p;
    }

    public final synchronized void r() {
        if (this.f12423l == null) {
            throw new IllegalArgumentException();
        }
        this.f12412a.clear();
        this.f12423l = null;
        this.f12433v = null;
        this.f12428q = null;
        this.f12432u = false;
        this.f12435x = false;
        this.f12430s = false;
        this.f12436y = false;
        this.f12434w.x(false);
        this.f12434w = null;
        this.f12431t = null;
        this.f12429r = null;
        this.f12415d.b(this);
    }

    public synchronized void s(com.bumptech.glide.request.i iVar) {
        this.f12413b.c();
        this.f12412a.f(iVar);
        if (this.f12412a.isEmpty()) {
            h();
            if ((this.f12430s || this.f12432u) && this.f12422k.get() == 0) {
                r();
            }
        }
    }

    public synchronized void t(DecodeJob<R> decodeJob) {
        this.f12434w = decodeJob;
        (decodeJob.F() ? this.f12418g : j()).execute(decodeJob);
    }

    @i1
    public j(f4.a aVar, f4.a aVar2, f4.a aVar3, f4.a aVar4, k kVar, n.a aVar5, n.a<j<?>> aVar6, c cVar) {
        this.f12412a = new e();
        this.f12413b = w4.c.a();
        this.f12422k = new AtomicInteger();
        this.f12418g = aVar;
        this.f12419h = aVar2;
        this.f12420i = aVar3;
        this.f12421j = aVar4;
        this.f12417f = kVar;
        this.f12414c = aVar5;
        this.f12415d = aVar6;
        this.f12416e = cVar;
    }
}
