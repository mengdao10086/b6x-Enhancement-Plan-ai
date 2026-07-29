package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.core.util.n;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.n;
import e4.a;
import e4.j;
import g.i1;
import g.n0;
import g.p0;
import java.util.Map;
import java.util.concurrent.Executor;
import w4.a;

/* JADX INFO: loaded from: classes2.dex */
public class i implements k, j.a, n.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f12384j = 150;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f12386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f12387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e4.j f12388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f12389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final v f12390e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f12391f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f12392g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.a f12393h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f12383i = "Engine";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final boolean f12385k = Log.isLoggable(f12383i, 2);

    @i1
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DecodeJob.e f12394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n.a<DecodeJob<?>> f12395b = w4.a.e(150, new C0122a());

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12396c;

        /* JADX INFO: renamed from: com.bumptech.glide.load.engine.i$a$a, reason: collision with other inner class name */
        public class C0122a implements a.d<DecodeJob<?>> {
            public C0122a() {
            }

            @Override // w4.a.d
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public DecodeJob<?> create() {
                a aVar = a.this;
                return new DecodeJob<>(aVar.f12394a, aVar.f12395b);
            }
        }

        public a(DecodeJob.e eVar) {
            this.f12394a = eVar;
        }

        public <R> DecodeJob<R> a(com.bumptech.glide.d dVar, Object obj, l lVar, c4.b bVar, int i10, int i11, Class<?> cls, Class<R> cls2, Priority priority, h hVar, Map<Class<?>, c4.h<?>> map, boolean z10, boolean z11, boolean z12, c4.e eVar, DecodeJob.b<R> bVar2) {
            DecodeJob decodeJob = (DecodeJob) v4.m.d(this.f12395b.a());
            int i12 = this.f12396c;
            this.f12396c = i12 + 1;
            return decodeJob.o(dVar, obj, lVar, bVar, i10, i11, cls, cls2, priority, hVar, map, z10, z11, z12, eVar, bVar2, i12);
        }
    }

    @i1
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f4.a f12398a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f4.a f12399b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final f4.a f12400c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final f4.a f12401d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final k f12402e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final n.a f12403f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final n.a<j<?>> f12404g = w4.a.e(150, new a());

        public class a implements a.d<j<?>> {
            public a() {
            }

            @Override // w4.a.d
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public j<?> create() {
                b bVar = b.this;
                return new j<>(bVar.f12398a, bVar.f12399b, bVar.f12400c, bVar.f12401d, bVar.f12402e, bVar.f12403f, bVar.f12404g);
            }
        }

        public b(f4.a aVar, f4.a aVar2, f4.a aVar3, f4.a aVar4, k kVar, n.a aVar5) {
            this.f12398a = aVar;
            this.f12399b = aVar2;
            this.f12400c = aVar3;
            this.f12401d = aVar4;
            this.f12402e = kVar;
            this.f12403f = aVar5;
        }

        public <R> j<R> a(c4.b bVar, boolean z10, boolean z11, boolean z12, boolean z13) {
            return ((j) v4.m.d(this.f12404g.a())).l(bVar, z10, z11, z12, z13);
        }

        @i1
        public void b() {
            v4.f.c(this.f12398a);
            v4.f.c(this.f12399b);
            v4.f.c(this.f12400c);
            v4.f.c(this.f12401d);
        }
    }

    public static class c implements DecodeJob.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a.InterfaceC0306a f12406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile e4.a f12407b;

        public c(a.InterfaceC0306a interfaceC0306a) {
            this.f12406a = interfaceC0306a;
        }

        @Override // com.bumptech.glide.load.engine.DecodeJob.e
        public e4.a a() {
            if (this.f12407b == null) {
                synchronized (this) {
                    if (this.f12407b == null) {
                        this.f12407b = this.f12406a.a();
                    }
                    if (this.f12407b == null) {
                        this.f12407b = new e4.b();
                    }
                }
            }
            return this.f12407b;
        }

        @i1
        public synchronized void b() {
            if (this.f12407b == null) {
                return;
            }
            this.f12407b.clear();
        }
    }

    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j<?> f12408a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.bumptech.glide.request.i f12409b;

        public d(com.bumptech.glide.request.i iVar, j<?> jVar) {
            this.f12409b = iVar;
            this.f12408a = jVar;
        }

        public void a() {
            synchronized (i.this) {
                this.f12408a.s(this.f12409b);
            }
        }
    }

    public i(e4.j jVar, a.InterfaceC0306a interfaceC0306a, f4.a aVar, f4.a aVar2, f4.a aVar3, f4.a aVar4, boolean z10) {
        this(jVar, interfaceC0306a, aVar, aVar2, aVar3, aVar4, null, null, null, null, null, null, z10);
    }

    public static void k(String str, long j10, c4.b bVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" in ");
        sb2.append(v4.i.a(j10));
        sb2.append("ms, key: ");
        sb2.append(bVar);
    }

    @Override // e4.j.a
    public void a(@n0 s<?> sVar) {
        this.f12390e.a(sVar, true);
    }

    @Override // com.bumptech.glide.load.engine.k
    public synchronized void b(j<?> jVar, c4.b bVar) {
        this.f12386a.e(bVar, jVar);
    }

    @Override // com.bumptech.glide.load.engine.n.a
    public void c(c4.b bVar, n<?> nVar) {
        this.f12393h.d(bVar);
        if (nVar.f()) {
            this.f12388c.g(bVar, nVar);
        } else {
            this.f12390e.a(nVar, false);
        }
    }

    @Override // com.bumptech.glide.load.engine.k
    public synchronized void d(j<?> jVar, c4.b bVar, n<?> nVar) {
        if (nVar != null) {
            if (nVar.f()) {
                this.f12393h.a(bVar, nVar);
            }
            this.f12386a.e(bVar, jVar);
        } else {
            this.f12386a.e(bVar, jVar);
        }
    }

    public void e() {
        this.f12391f.a().clear();
    }

    public final n<?> f(c4.b bVar) {
        s<?> sVarF = this.f12388c.f(bVar);
        if (sVarF == null) {
            return null;
        }
        return sVarF instanceof n ? (n) sVarF : new n<>(sVarF, true, true, bVar, this);
    }

    public <R> d g(com.bumptech.glide.d dVar, Object obj, c4.b bVar, int i10, int i11, Class<?> cls, Class<R> cls2, Priority priority, h hVar, Map<Class<?>, c4.h<?>> map, boolean z10, boolean z11, c4.e eVar, boolean z12, boolean z13, boolean z14, boolean z15, com.bumptech.glide.request.i iVar, Executor executor) {
        long jB = f12385k ? v4.i.b() : 0L;
        l lVarA = this.f12387b.a(obj, bVar, i10, i11, map, cls, cls2, eVar);
        synchronized (this) {
            n<?> nVarJ = j(lVarA, z12, jB);
            if (nVarJ == null) {
                return n(dVar, obj, bVar, i10, i11, cls, cls2, priority, hVar, map, z10, z11, eVar, z12, z13, z14, z15, iVar, executor, lVarA, jB);
            }
            iVar.c(nVarJ, DataSource.MEMORY_CACHE, false);
            return null;
        }
    }

    @p0
    public final n<?> h(c4.b bVar) {
        n<?> nVarE = this.f12393h.e(bVar);
        if (nVarE != null) {
            nVarE.b();
        }
        return nVarE;
    }

    public final n<?> i(c4.b bVar) {
        n<?> nVarF = f(bVar);
        if (nVarF != null) {
            nVarF.b();
            this.f12393h.a(bVar, nVarF);
        }
        return nVarF;
    }

    @p0
    public final n<?> j(l lVar, boolean z10, long j10) {
        if (!z10) {
            return null;
        }
        n<?> nVarH = h(lVar);
        if (nVarH != null) {
            if (f12385k) {
                k("Loaded resource from active resources", j10, lVar);
            }
            return nVarH;
        }
        n<?> nVarI = i(lVar);
        if (nVarI == null) {
            return null;
        }
        if (f12385k) {
            k("Loaded resource from cache", j10, lVar);
        }
        return nVarI;
    }

    public void l(s<?> sVar) {
        if (!(sVar instanceof n)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((n) sVar).g();
    }

    @i1
    public void m() {
        this.f12389d.b();
        this.f12391f.b();
        this.f12393h.h();
    }

    public final <R> d n(com.bumptech.glide.d dVar, Object obj, c4.b bVar, int i10, int i11, Class<?> cls, Class<R> cls2, Priority priority, h hVar, Map<Class<?>, c4.h<?>> map, boolean z10, boolean z11, c4.e eVar, boolean z12, boolean z13, boolean z14, boolean z15, com.bumptech.glide.request.i iVar, Executor executor, l lVar, long j10) {
        j<?> jVarA = this.f12386a.a(lVar, z15);
        if (jVarA != null) {
            jVarA.b(iVar, executor);
            if (f12385k) {
                k("Added to existing load", j10, lVar);
            }
            return new d(iVar, jVarA);
        }
        j<R> jVarA2 = this.f12389d.a(lVar, z12, z13, z14, z15);
        DecodeJob<R> decodeJobA = this.f12392g.a(dVar, obj, lVar, bVar, i10, i11, cls, cls2, priority, hVar, map, z10, z11, z15, eVar, jVarA2);
        this.f12386a.d(lVar, jVarA2);
        jVarA2.b(iVar, executor);
        jVarA2.t(decodeJobA);
        if (f12385k) {
            k("Started new load", j10, lVar);
        }
        return new d(iVar, jVarA2);
    }

    @i1
    public i(e4.j jVar, a.InterfaceC0306a interfaceC0306a, f4.a aVar, f4.a aVar2, f4.a aVar3, f4.a aVar4, p pVar, m mVar, com.bumptech.glide.load.engine.a aVar5, b bVar, a aVar6, v vVar, boolean z10) {
        this.f12388c = jVar;
        c cVar = new c(interfaceC0306a);
        this.f12391f = cVar;
        com.bumptech.glide.load.engine.a aVar7 = aVar5 == null ? new com.bumptech.glide.load.engine.a(z10) : aVar5;
        this.f12393h = aVar7;
        aVar7.g(this);
        this.f12387b = mVar == null ? new m() : mVar;
        this.f12386a = pVar == null ? new p() : pVar;
        this.f12389d = bVar == null ? new b(aVar, aVar2, aVar3, aVar4, this, this) : bVar;
        this.f12392g = aVar6 == null ? new a(cVar) : aVar6;
        this.f12390e = vVar == null ? new v() : vVar;
        jVar.h(this);
    }
}
