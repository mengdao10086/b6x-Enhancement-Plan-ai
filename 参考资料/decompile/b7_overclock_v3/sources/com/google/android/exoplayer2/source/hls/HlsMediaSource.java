package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.c;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.a;
import ec.e0;
import ed.z;
import g.i1;
import g.p0;
import gb.r;
import hd.u0;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.List;
import ya.r0;
import ya.v0;

/* JADX INFO: loaded from: classes3.dex */
public final class HlsMediaSource extends com.google.android.exoplayer2.source.a implements HlsPlaylistTracker.c {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f17776u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f17777v = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h f17778g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final v0.g f17779h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final g f17780i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ec.d f17781j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.c f17782k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.j f17783l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f17784m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f17785n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f17786o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final HlsPlaylistTracker f17787p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f17788q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final v0 f17789r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public v0.f f17790s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @p0
    public z f17791t;

    public static final class Factory implements ec.x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f17792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public h f17793b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public lc.f f17794c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public HlsPlaylistTracker.a f17795d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ec.d f17796e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f17797f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public r f17798g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public com.google.android.exoplayer2.upstream.j f17799h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f17800i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f17801j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f17802k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public List<StreamKey> f17803l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @p0
        public Object f17804m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public long f17805n;

        public Factory(a.InterfaceC0197a interfaceC0197a) {
            this(new d(interfaceC0197a));
        }

        public static /* synthetic */ com.google.android.exoplayer2.drm.c m(com.google.android.exoplayer2.drm.c cVar, v0 v0Var) {
            return cVar;
        }

        @Deprecated
        public Factory A(@p0 Object obj) {
            this.f17804m = obj;
            return this;
        }

        public Factory B(boolean z10) {
            this.f17802k = z10;
            return this;
        }

        @Override // ec.x
        public int[] e() {
            return new int[]{2};
        }

        @Override // ec.x
        @Deprecated
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public HlsMediaSource h(Uri uri) {
            return c(new v0.c().F(uri).B(hd.w.f31189i0).a());
        }

        @Override // ec.x
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public HlsMediaSource c(v0 v0Var) {
            v0 v0VarA = v0Var;
            hd.a.g(v0VarA.f57132b);
            lc.f dVar = this.f17794c;
            List<StreamKey> list = v0VarA.f57132b.f57187e.isEmpty() ? this.f17803l : v0VarA.f57132b.f57187e;
            if (!list.isEmpty()) {
                dVar = new lc.d(dVar, list);
            }
            v0.g gVar = v0VarA.f57132b;
            boolean z10 = gVar.f57190h == null && this.f17804m != null;
            boolean z11 = gVar.f57187e.isEmpty() && !list.isEmpty();
            if (z10 && z11) {
                v0VarA = v0Var.a().E(this.f17804m).C(list).a();
            } else if (z10) {
                v0VarA = v0Var.a().E(this.f17804m).a();
            } else if (z11) {
                v0VarA = v0Var.a().C(list).a();
            }
            v0 v0Var2 = v0VarA;
            g gVar2 = this.f17792a;
            h hVar = this.f17793b;
            ec.d dVar2 = this.f17796e;
            com.google.android.exoplayer2.drm.c cVarA = this.f17798g.a(v0Var2);
            com.google.android.exoplayer2.upstream.j jVar = this.f17799h;
            return new HlsMediaSource(v0Var2, gVar2, hVar, dVar2, cVarA, jVar, this.f17795d.a(this.f17792a, jVar, dVar), this.f17805n, this.f17800i, this.f17801j, this.f17802k);
        }

        public Factory n(boolean z10) {
            this.f17800i = z10;
            return this;
        }

        public Factory o(@p0 ec.d dVar) {
            if (dVar == null) {
                dVar = new ec.f();
            }
            this.f17796e = dVar;
            return this;
        }

        @Override // ec.x
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public Factory d(@p0 HttpDataSource.b bVar) {
            if (!this.f17797f) {
                ((com.google.android.exoplayer2.drm.a) this.f17798g).c(bVar);
            }
            return this;
        }

        @Override // ec.x
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public Factory g(@p0 final com.google.android.exoplayer2.drm.c cVar) {
            if (cVar == null) {
                f(null);
            } else {
                f(new r() { // from class: com.google.android.exoplayer2.source.hls.m
                    @Override // gb.r
                    public final com.google.android.exoplayer2.drm.c a(v0 v0Var) {
                        return HlsMediaSource.Factory.m(cVar, v0Var);
                    }
                });
            }
            return this;
        }

        @Override // ec.x
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public Factory f(@p0 r rVar) {
            if (rVar != null) {
                this.f17798g = rVar;
                this.f17797f = true;
            } else {
                this.f17798g = new com.google.android.exoplayer2.drm.a();
                this.f17797f = false;
            }
            return this;
        }

        @Override // ec.x
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public Factory a(@p0 String str) {
            if (!this.f17797f) {
                ((com.google.android.exoplayer2.drm.a) this.f17798g).d(str);
            }
            return this;
        }

        @i1
        public Factory t(long j10) {
            this.f17805n = j10;
            return this;
        }

        public Factory u(@p0 h hVar) {
            if (hVar == null) {
                hVar = h.f17866a;
            }
            this.f17793b = hVar;
            return this;
        }

        @Override // ec.x
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public Factory i(@p0 com.google.android.exoplayer2.upstream.j jVar) {
            if (jVar == null) {
                jVar = new com.google.android.exoplayer2.upstream.g();
            }
            this.f17799h = jVar;
            return this;
        }

        public Factory w(int i10) {
            this.f17801j = i10;
            return this;
        }

        public Factory x(@p0 lc.f fVar) {
            if (fVar == null) {
                fVar = new lc.a();
            }
            this.f17794c = fVar;
            return this;
        }

        public Factory y(@p0 HlsPlaylistTracker.a aVar) {
            if (aVar == null) {
                aVar = com.google.android.exoplayer2.source.hls.playlist.a.f17969p;
            }
            this.f17795d = aVar;
            return this;
        }

        @Override // ec.x
        @Deprecated
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public Factory b(@p0 List<StreamKey> list) {
            if (list == null) {
                list = Collections.emptyList();
            }
            this.f17803l = list;
            return this;
        }

        public Factory(g gVar) {
            this.f17792a = (g) hd.a.g(gVar);
            this.f17798g = new com.google.android.exoplayer2.drm.a();
            this.f17794c = new lc.a();
            this.f17795d = com.google.android.exoplayer2.source.hls.playlist.a.f17969p;
            this.f17793b = h.f17866a;
            this.f17799h = new com.google.android.exoplayer2.upstream.g();
            this.f17796e = new ec.f();
            this.f17801j = 1;
            this.f17803l = Collections.emptyList();
            this.f17805n = ya.g.f56663b;
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    static {
        r0.a("goog.exo.hls");
    }

    public static long G(com.google.android.exoplayer2.source.hls.playlist.c cVar, long j10) {
        long j11;
        c.g gVar = cVar.f18043t;
        long j12 = cVar.f18028e;
        if (j12 != ya.g.f56663b) {
            j11 = cVar.f18042s - j12;
        } else {
            long j13 = gVar.f18065d;
            if (j13 == ya.g.f56663b || cVar.f18035l == ya.g.f56663b) {
                long j14 = gVar.f18064c;
                j11 = j14 != ya.g.f56663b ? j14 : cVar.f18034k * 3;
            } else {
                j11 = j13;
            }
        }
        return j11 + j10;
    }

    @Override // com.google.android.exoplayer2.source.a
    public void C(@p0 z zVar) {
        this.f17791t = zVar;
        this.f17782k.f();
        this.f17787p.f(this.f17779h.f57183a, x(null), this);
    }

    @Override // com.google.android.exoplayer2.source.a
    public void E() {
        this.f17787p.stop();
        this.f17782k.release();
    }

    public final long F(com.google.android.exoplayer2.source.hls.playlist.c cVar) {
        if (cVar.f18037n) {
            return ya.g.c(u0.j0(this.f17788q)) - cVar.e();
        }
        return 0L;
    }

    public final long H(com.google.android.exoplayer2.source.hls.playlist.c cVar, long j10) {
        List<c.e> list = cVar.f18039p;
        int size = list.size() - 1;
        long jC = (cVar.f18042s + j10) - ya.g.c(this.f17790s.f57178a);
        while (size > 0 && list.get(size).f18055e > jC) {
            size--;
        }
        return list.get(size).f18055e;
    }

    public final void I(long j10) {
        long jD = ya.g.d(j10);
        if (jD != this.f17790s.f57178a) {
            this.f17790s = this.f17789r.a().y(jD).a().f57133c;
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public com.google.android.exoplayer2.source.k a(l.a aVar, ed.b bVar, long j10) {
        m.a aVarX = x(aVar);
        return new l(this.f17778g, this.f17787p, this.f17780i, this.f17791t, this.f17782k, v(aVar), this.f17783l, aVarX, bVar, this.f17781j, this.f17784m, this.f17785n, this.f17786o);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.c
    public void c(com.google.android.exoplayer2.source.hls.playlist.c cVar) {
        e0 e0Var;
        long jD = cVar.f18037n ? ya.g.d(cVar.f18029f) : -9223372036854775807L;
        int i10 = cVar.f18027d;
        long j10 = (i10 == 2 || i10 == 1) ? jD : -9223372036854775807L;
        long j11 = cVar.f18028e;
        i iVar = new i((com.google.android.exoplayer2.source.hls.playlist.b) hd.a.g(this.f17787p.e()), cVar);
        if (this.f17787p.isLive()) {
            long jF = F(cVar);
            long j12 = this.f17790s.f57178a;
            I(u0.u(j12 != ya.g.f56663b ? ya.g.c(j12) : G(cVar, jF), jF, cVar.f18042s + jF));
            long jD2 = cVar.f18029f - this.f17787p.d();
            e0Var = new e0(j10, jD, ya.g.f56663b, cVar.f18036m ? jD2 + cVar.f18042s : -9223372036854775807L, cVar.f18042s, jD2, !cVar.f18039p.isEmpty() ? H(cVar, jF) : j11 == ya.g.f56663b ? 0L : j11, true, !cVar.f18036m, (Object) iVar, this.f17789r, this.f17790s);
        } else {
            long j13 = j11 == ya.g.f56663b ? 0L : j11;
            long j14 = cVar.f18042s;
            e0Var = new e0(j10, jD, ya.g.f56663b, j14, j14, 0L, j13, true, false, (Object) iVar, this.f17789r, (v0.f) null);
        }
        D(e0Var);
    }

    @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.source.l
    @p0
    @Deprecated
    public Object h() {
        return this.f17779h.f57190h;
    }

    @Override // com.google.android.exoplayer2.source.l
    public v0 j() {
        return this.f17789r;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void n() throws IOException {
        this.f17787p.g();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void p(com.google.android.exoplayer2.source.k kVar) {
        ((l) kVar).B();
    }

    public HlsMediaSource(v0 v0Var, g gVar, h hVar, ec.d dVar, com.google.android.exoplayer2.drm.c cVar, com.google.android.exoplayer2.upstream.j jVar, HlsPlaylistTracker hlsPlaylistTracker, long j10, boolean z10, int i10, boolean z11) {
        this.f17779h = (v0.g) hd.a.g(v0Var.f57132b);
        this.f17789r = v0Var;
        this.f17790s = v0Var.f57133c;
        this.f17780i = gVar;
        this.f17778g = hVar;
        this.f17781j = dVar;
        this.f17782k = cVar;
        this.f17783l = jVar;
        this.f17787p = hlsPlaylistTracker;
        this.f17788q = j10;
        this.f17784m = z10;
        this.f17785n = i10;
        this.f17786o = z11;
    }
}
