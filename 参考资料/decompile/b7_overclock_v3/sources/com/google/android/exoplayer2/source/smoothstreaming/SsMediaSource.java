package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.a;
import com.google.android.exoplayer2.source.smoothstreaming.b;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.a;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.g;
import com.google.android.exoplayer2.upstream.j;
import com.google.android.exoplayer2.upstream.k;
import ec.d;
import ec.e0;
import ec.f;
import ec.x;
import ed.u;
import ed.z;
import g.p0;
import gb.r;
import hd.u0;
import hd.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ya.r0;
import ya.v0;

/* JADX INFO: loaded from: classes3.dex */
public final class SsMediaSource extends com.google.android.exoplayer2.source.a implements Loader.b<k<com.google.android.exoplayer2.source.smoothstreaming.manifest.a>> {
    public static final long A = 30000;
    public static final int B = 5000;
    public static final long C = 5000000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f18284g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Uri f18285h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final v0.g f18286i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final v0 f18287j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a.InterfaceC0197a f18288k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b.a f18289l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d f18290m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.c f18291n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final j f18292o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f18293p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final m.a f18294q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final k.a<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.a> f18295r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ArrayList<c> f18296s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public com.google.android.exoplayer2.upstream.a f18297t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Loader f18298u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public u f18299v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @p0
    public z f18300w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f18301x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public com.google.android.exoplayer2.source.smoothstreaming.manifest.a f18302y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Handler f18303z;

    public static final class Factory implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b.a f18304a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public final a.InterfaceC0197a f18305b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d f18306c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f18307d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public r f18308e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public j f18309f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f18310g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @p0
        public k.a<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.a> f18311h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public List<StreamKey> f18312i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @p0
        public Object f18313j;

        public Factory(a.InterfaceC0197a interfaceC0197a) {
            this(new a.C0191a(interfaceC0197a), interfaceC0197a);
        }

        public static /* synthetic */ com.google.android.exoplayer2.drm.c o(com.google.android.exoplayer2.drm.c cVar, v0 v0Var) {
            return cVar;
        }

        @Override // ec.x
        public int[] e() {
            return new int[]{1};
        }

        @Override // ec.x
        @Deprecated
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public SsMediaSource h(Uri uri) {
            return c(new v0.c().F(uri).a());
        }

        public SsMediaSource l(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
            return m(aVar, v0.b(Uri.EMPTY));
        }

        public SsMediaSource m(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, v0 v0Var) {
            com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVarA = aVar;
            hd.a.a(!aVarA.f18408d);
            v0.g gVar = v0Var.f57132b;
            List<StreamKey> list = (gVar == null || gVar.f57187e.isEmpty()) ? this.f18312i : v0Var.f57132b.f57187e;
            if (!list.isEmpty()) {
                aVarA = aVarA.a(list);
            }
            com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar2 = aVarA;
            v0.g gVar2 = v0Var.f57132b;
            boolean z10 = gVar2 != null;
            v0 v0VarA = v0Var.a().B(w.f31191j0).F(z10 ? v0Var.f57132b.f57183a : Uri.EMPTY).E(z10 && gVar2.f57190h != null ? v0Var.f57132b.f57190h : this.f18313j).C(list).a();
            return new SsMediaSource(v0VarA, aVar2, null, null, this.f18304a, this.f18306c, this.f18308e.a(v0VarA), this.f18309f, this.f18310g);
        }

        @Override // ec.x
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public SsMediaSource c(v0 v0Var) {
            v0 v0VarA = v0Var;
            hd.a.g(v0VarA.f57132b);
            k.a ssManifestParser = this.f18311h;
            if (ssManifestParser == null) {
                ssManifestParser = new SsManifestParser();
            }
            List<StreamKey> list = !v0VarA.f57132b.f57187e.isEmpty() ? v0VarA.f57132b.f57187e : this.f18312i;
            k.a zVar = !list.isEmpty() ? new cc.z(ssManifestParser, list) : ssManifestParser;
            v0.g gVar = v0VarA.f57132b;
            boolean z10 = gVar.f57190h == null && this.f18313j != null;
            boolean z11 = gVar.f57187e.isEmpty() && !list.isEmpty();
            if (z10 && z11) {
                v0VarA = v0Var.a().E(this.f18313j).C(list).a();
            } else if (z10) {
                v0VarA = v0Var.a().E(this.f18313j).a();
            } else if (z11) {
                v0VarA = v0Var.a().C(list).a();
            }
            v0 v0Var2 = v0VarA;
            return new SsMediaSource(v0Var2, null, this.f18305b, zVar, this.f18304a, this.f18306c, this.f18308e.a(v0Var2), this.f18309f, this.f18310g);
        }

        public Factory p(@p0 d dVar) {
            if (dVar == null) {
                dVar = new f();
            }
            this.f18306c = dVar;
            return this;
        }

        @Override // ec.x
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public Factory d(@p0 HttpDataSource.b bVar) {
            if (!this.f18307d) {
                ((com.google.android.exoplayer2.drm.a) this.f18308e).c(bVar);
            }
            return this;
        }

        @Override // ec.x
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public Factory g(@p0 final com.google.android.exoplayer2.drm.c cVar) {
            if (cVar == null) {
                f(null);
            } else {
                f(new r() { // from class: nc.c
                    @Override // gb.r
                    public final com.google.android.exoplayer2.drm.c a(v0 v0Var) {
                        return SsMediaSource.Factory.o(cVar, v0Var);
                    }
                });
            }
            return this;
        }

        @Override // ec.x
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public Factory f(@p0 r rVar) {
            if (rVar != null) {
                this.f18308e = rVar;
                this.f18307d = true;
            } else {
                this.f18308e = new com.google.android.exoplayer2.drm.a();
                this.f18307d = false;
            }
            return this;
        }

        @Override // ec.x
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public Factory a(@p0 String str) {
            if (!this.f18307d) {
                ((com.google.android.exoplayer2.drm.a) this.f18308e).d(str);
            }
            return this;
        }

        public Factory u(long j10) {
            this.f18310g = j10;
            return this;
        }

        @Override // ec.x
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public Factory i(@p0 j jVar) {
            if (jVar == null) {
                jVar = new g();
            }
            this.f18309f = jVar;
            return this;
        }

        public Factory w(@p0 k.a<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.a> aVar) {
            this.f18311h = aVar;
            return this;
        }

        @Override // ec.x
        @Deprecated
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public Factory b(@p0 List<StreamKey> list) {
            if (list == null) {
                list = Collections.emptyList();
            }
            this.f18312i = list;
            return this;
        }

        @Deprecated
        public Factory y(@p0 Object obj) {
            this.f18313j = obj;
            return this;
        }

        public Factory(b.a aVar, @p0 a.InterfaceC0197a interfaceC0197a) {
            this.f18304a = (b.a) hd.a.g(aVar);
            this.f18305b = interfaceC0197a;
            this.f18308e = new com.google.android.exoplayer2.drm.a();
            this.f18309f = new g();
            this.f18310g = 30000L;
            this.f18306c = new f();
            this.f18312i = Collections.emptyList();
        }
    }

    static {
        r0.a("goog.exo.smoothstreaming");
    }

    @Override // com.google.android.exoplayer2.source.a
    public void C(@p0 z zVar) {
        this.f18300w = zVar;
        this.f18291n.f();
        if (this.f18284g) {
            this.f18299v = new u.a();
            J();
            return;
        }
        this.f18297t = this.f18288k.a();
        Loader loader = new Loader("Loader:Manifest");
        this.f18298u = loader;
        this.f18299v = loader;
        this.f18303z = u0.z();
        L();
    }

    @Override // com.google.android.exoplayer2.source.a
    public void E() {
        this.f18302y = this.f18284g ? this.f18302y : null;
        this.f18297t = null;
        this.f18301x = 0L;
        Loader loader = this.f18298u;
        if (loader != null) {
            loader.l();
            this.f18298u = null;
        }
        Handler handler = this.f18303z;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f18303z = null;
        }
        this.f18291n.release();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public void i(k<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> kVar, long j10, long j11, boolean z10) {
        ec.j jVar = new ec.j(kVar.f19268a, kVar.f19269b, kVar.f(), kVar.d(), j10, j11, kVar.a());
        this.f18292o.d(kVar.f19268a);
        this.f18294q.q(jVar, kVar.f19270c);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public void l(k<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> kVar, long j10, long j11) {
        ec.j jVar = new ec.j(kVar.f19268a, kVar.f19269b, kVar.f(), kVar.d(), j10, j11, kVar.a());
        this.f18292o.d(kVar.f19268a);
        this.f18294q.t(jVar, kVar.f19270c);
        this.f18302y = kVar.e();
        this.f18301x = j10 - j11;
        J();
        K();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public Loader.c t(k<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> kVar, long j10, long j11, IOException iOException, int i10) {
        ec.j jVar = new ec.j(kVar.f19268a, kVar.f19269b, kVar.f(), kVar.d(), j10, j11, kVar.a());
        long jA = this.f18292o.a(new j.a(jVar, new ec.k(kVar.f19270c), iOException, i10));
        Loader.c cVarI = jA == ya.g.f56663b ? Loader.f19042k : Loader.i(false, jA);
        boolean z10 = !cVarI.c();
        this.f18294q.x(jVar, kVar.f19270c, iOException, z10);
        if (z10) {
            this.f18292o.d(kVar.f19268a);
        }
        return cVarI;
    }

    public final void J() {
        e0 e0Var;
        for (int i10 = 0; i10 < this.f18296s.size(); i10++) {
            this.f18296s.get(i10).w(this.f18302y);
        }
        long jMax = Long.MIN_VALUE;
        long jMax2 = Long.MAX_VALUE;
        for (a.b bVar : this.f18302y.f18410f) {
            if (bVar.f18430k > 0) {
                jMax2 = Math.min(jMax2, bVar.e(0));
                jMax = Math.max(jMax, bVar.e(bVar.f18430k - 1) + bVar.c(bVar.f18430k - 1));
            }
        }
        if (jMax2 == Long.MAX_VALUE) {
            long j10 = this.f18302y.f18408d ? -9223372036854775807L : 0L;
            com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar = this.f18302y;
            boolean z10 = aVar.f18408d;
            e0Var = new e0(j10, 0L, 0L, 0L, true, z10, z10, (Object) aVar, this.f18287j);
        } else {
            com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar2 = this.f18302y;
            if (aVar2.f18408d) {
                long j11 = aVar2.f18412h;
                if (j11 != ya.g.f56663b && j11 > 0) {
                    jMax2 = Math.max(jMax2, jMax - j11);
                }
                long j12 = jMax2;
                long j13 = jMax - j12;
                long jC = j13 - ya.g.c(this.f18293p);
                if (jC < 5000000) {
                    jC = Math.min(5000000L, j13 / 2);
                }
                e0Var = new e0(ya.g.f56663b, j13, j12, jC, true, true, true, (Object) this.f18302y, this.f18287j);
            } else {
                long j14 = aVar2.f18411g;
                long j15 = j14 != ya.g.f56663b ? j14 : jMax - jMax2;
                e0Var = new e0(jMax2 + j15, j15, jMax2, 0L, true, false, false, (Object) this.f18302y, this.f18287j);
            }
        }
        D(e0Var);
    }

    public final void K() {
        if (this.f18302y.f18408d) {
            this.f18303z.postDelayed(new Runnable() { // from class: nc.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f42068a.L();
                }
            }, Math.max(0L, (this.f18301x + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    public final void L() {
        if (this.f18298u.j()) {
            return;
        }
        k kVar = new k(this.f18297t, this.f18285h, 4, this.f18295r);
        this.f18294q.z(new ec.j(kVar.f19268a, kVar.f19269b, this.f18298u.n(kVar, this, this.f18292o.f(kVar.f19270c))), kVar.f19270c);
    }

    @Override // com.google.android.exoplayer2.source.l
    public com.google.android.exoplayer2.source.k a(l.a aVar, ed.b bVar, long j10) {
        m.a aVarX = x(aVar);
        c cVar = new c(this.f18302y, this.f18289l, this.f18300w, this.f18290m, this.f18291n, v(aVar), this.f18292o, aVarX, this.f18299v, bVar);
        this.f18296s.add(cVar);
        return cVar;
    }

    @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.source.l
    @p0
    @Deprecated
    public Object h() {
        return this.f18286i.f57190h;
    }

    @Override // com.google.android.exoplayer2.source.l
    public v0 j() {
        return this.f18287j;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void n() throws IOException {
        this.f18299v.a();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void p(com.google.android.exoplayer2.source.k kVar) {
        ((c) kVar).v();
        this.f18296s.remove(kVar);
    }

    public SsMediaSource(v0 v0Var, @p0 com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, @p0 a.InterfaceC0197a interfaceC0197a, @p0 k.a<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.a> aVar2, b.a aVar3, d dVar, com.google.android.exoplayer2.drm.c cVar, j jVar, long j10) {
        hd.a.i(aVar == null || !aVar.f18408d);
        this.f18287j = v0Var;
        v0.g gVar = (v0.g) hd.a.g(v0Var.f57132b);
        this.f18286i = gVar;
        this.f18302y = aVar;
        this.f18285h = gVar.f57183a.equals(Uri.EMPTY) ? null : u0.H(gVar.f57183a);
        this.f18288k = interfaceC0197a;
        this.f18295r = aVar2;
        this.f18289l = aVar3;
        this.f18290m = dVar;
        this.f18291n = cVar;
        this.f18292o = jVar;
        this.f18293p = j10;
        this.f18294q = x(null);
        this.f18284g = aVar != null;
        this.f18296s = new ArrayList<>();
    }
}
