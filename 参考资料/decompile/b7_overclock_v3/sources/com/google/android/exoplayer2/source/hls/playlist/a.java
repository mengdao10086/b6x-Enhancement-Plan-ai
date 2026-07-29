package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.hls.g;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.b;
import com.google.android.exoplayer2.source.hls.playlist.c;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.j;
import com.google.android.exoplayer2.upstream.k;
import com.google.common.collect.Iterables;
import g.p0;
import hd.u0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import lc.e;
import lc.f;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements HlsPlaylistTracker, Loader.b<k<e>> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final HlsPlaylistTracker.a f17969p = new HlsPlaylistTracker.a() { // from class: lc.b
        @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.a
        public final HlsPlaylistTracker a(com.google.android.exoplayer2.source.hls.g gVar, j jVar, f fVar) {
            return new com.google.android.exoplayer2.source.hls.playlist.a(gVar, jVar, fVar);
        }
    };

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final double f17970q = 3.5d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f17971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f17972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f17973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<Uri, C0187a> f17974d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<HlsPlaylistTracker.b> f17975e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final double f17976f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public m.a f17977g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @p0
    public Loader f17978h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public Handler f17979i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public HlsPlaylistTracker.c f17980j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public b f17981k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @p0
    public Uri f17982l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @p0
    public c f17983m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f17984n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f17985o;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.source.hls.playlist.a$a, reason: collision with other inner class name */
    public final class C0187a implements Loader.b<k<e>> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final String f17986l = "_HLS_msn";

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final String f17987m = "_HLS_part";

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final String f17988n = "_HLS_skip";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f17989a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Loader f17990b = new Loader("DefaultHlsPlaylistTracker:MediaPlaylist");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.google.android.exoplayer2.upstream.a f17991c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @p0
        public c f17992d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f17993e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f17994f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f17995g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f17996h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f17997i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @p0
        public IOException f17998j;

        public C0187a(Uri uri) {
            this.f17989a = uri;
            this.f17991c = a.this.f17971a.a(4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(Uri uri) {
            this.f17997i = false;
            n(uri);
        }

        public final boolean f(long j10) {
            this.f17996h = SystemClock.elapsedRealtime() + j10;
            return this.f17989a.equals(a.this.f17982l) && !a.this.G();
        }

        public final Uri g() {
            c cVar = this.f17992d;
            if (cVar != null) {
                c.g gVar = cVar.f18043t;
                if (gVar.f18062a != ya.g.f56663b || gVar.f18066e) {
                    Uri.Builder builderBuildUpon = this.f17989a.buildUpon();
                    c cVar2 = this.f17992d;
                    if (cVar2.f18043t.f18066e) {
                        builderBuildUpon.appendQueryParameter(f17986l, String.valueOf(cVar2.f18032i + ((long) cVar2.f18039p.size())));
                        c cVar3 = this.f17992d;
                        if (cVar3.f18035l != ya.g.f56663b) {
                            List<c.b> list = cVar3.f18040q;
                            int size = list.size();
                            if (!list.isEmpty() && ((c.b) Iterables.getLast(list)).f18045m) {
                                size--;
                            }
                            builderBuildUpon.appendQueryParameter(f17987m, String.valueOf(size));
                        }
                    }
                    c.g gVar2 = this.f17992d.f18043t;
                    if (gVar2.f18062a != ya.g.f56663b) {
                        builderBuildUpon.appendQueryParameter(f17988n, gVar2.f18063b ? "v2" : HlsPlaylistParser.V);
                    }
                    return builderBuildUpon.build();
                }
            }
            return this.f17989a;
        }

        @p0
        public c h() {
            return this.f17992d;
        }

        public boolean j() {
            int i10;
            if (this.f17992d == null) {
                return false;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long jMax = Math.max(30000L, ya.g.d(this.f17992d.f18042s));
            c cVar = this.f17992d;
            return cVar.f18036m || (i10 = cVar.f18027d) == 2 || i10 == 1 || this.f17993e + jMax > jElapsedRealtime;
        }

        public void m() {
            o(this.f17989a);
        }

        public final void n(Uri uri) {
            k kVar = new k(this.f17991c, uri, 4, a.this.f17972b.a(a.this.f17981k, this.f17992d));
            a.this.f17977g.z(new ec.j(kVar.f19268a, kVar.f19269b, this.f17990b.n(kVar, this, a.this.f17973c.f(kVar.f19270c))), kVar.f19270c);
        }

        public final void o(final Uri uri) {
            this.f17996h = 0L;
            if (this.f17997i || this.f17990b.k() || this.f17990b.j()) {
                return;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (jElapsedRealtime >= this.f17995g) {
                n(uri);
            } else {
                this.f17997i = true;
                a.this.f17979i.postDelayed(new Runnable() { // from class: lc.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f39562a.k(uri);
                    }
                }, this.f17995g - jElapsedRealtime);
            }
        }

        public void p() throws IOException {
            this.f17990b.a();
            IOException iOException = this.f17998j;
            if (iOException != null) {
                throw iOException;
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void i(k<e> kVar, long j10, long j11, boolean z10) {
            ec.j jVar = new ec.j(kVar.f19268a, kVar.f19269b, kVar.f(), kVar.d(), j10, j11, kVar.a());
            a.this.f17973c.d(kVar.f19268a);
            a.this.f17977g.q(jVar, 4);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public void l(k<e> kVar, long j10, long j11) {
            e eVarE = kVar.e();
            ec.j jVar = new ec.j(kVar.f19268a, kVar.f19269b, kVar.f(), kVar.d(), j10, j11, kVar.a());
            if (eVarE instanceof c) {
                u((c) eVarE, jVar);
                a.this.f17977g.t(jVar, 4);
            } else {
                this.f17998j = new ParserException("Loaded playlist has unexpected type.");
                a.this.f17977g.x(jVar, 4, this.f17998j, true);
            }
            a.this.f17973c.d(kVar.f19268a);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public Loader.c t(k<e> kVar, long j10, long j11, IOException iOException, int i10) {
            Loader.c cVarI;
            ec.j jVar = new ec.j(kVar.f19268a, kVar.f19269b, kVar.f(), kVar.d(), j10, j11, kVar.a());
            boolean z10 = iOException instanceof HlsPlaylistParser.DeltaUpdateException;
            if ((kVar.f().getQueryParameter(f17986l) != null) || z10) {
                int i11 = iOException instanceof HttpDataSource.InvalidResponseCodeException ? ((HttpDataSource.InvalidResponseCodeException) iOException).responseCode : Integer.MAX_VALUE;
                if (z10 || i11 == 400 || i11 == 503) {
                    this.f17995g = SystemClock.elapsedRealtime();
                    m();
                    ((m.a) u0.k(a.this.f17977g)).x(jVar, kVar.f19270c, iOException, true);
                    return Loader.f19041j;
                }
            }
            j.a aVar = new j.a(jVar, new ec.k(kVar.f19270c), iOException, i10);
            long jE = a.this.f17973c.e(aVar);
            boolean z11 = jE != ya.g.f56663b;
            boolean zF = a.this.I(this.f17989a, jE) || !z11;
            if (z11) {
                zF |= f(jE);
            }
            if (zF) {
                long jA = a.this.f17973c.a(aVar);
                cVarI = jA != ya.g.f56663b ? Loader.i(false, jA) : Loader.f19042k;
            } else {
                cVarI = Loader.f19041j;
            }
            boolean z12 = !cVarI.c();
            a.this.f17977g.x(jVar, kVar.f19270c, iOException, z12);
            if (z12) {
                a.this.f17973c.d(kVar.f19268a);
            }
            return cVarI;
        }

        public final void u(c cVar, ec.j jVar) {
            c cVar2 = this.f17992d;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.f17993e = jElapsedRealtime;
            c cVarB = a.this.B(cVar2, cVar);
            this.f17992d = cVarB;
            boolean z10 = true;
            if (cVarB != cVar2) {
                this.f17998j = null;
                this.f17994f = jElapsedRealtime;
                a.this.M(this.f17989a, cVarB);
            } else if (!cVarB.f18036m) {
                if (cVar.f18032i + ((long) cVar.f18039p.size()) < this.f17992d.f18032i) {
                    this.f17998j = new HlsPlaylistTracker.PlaylistResetException(this.f17989a);
                    a.this.I(this.f17989a, ya.g.f56663b);
                } else if (jElapsedRealtime - this.f17994f > ya.g.d(r14.f18034k) * a.this.f17976f) {
                    this.f17998j = new HlsPlaylistTracker.PlaylistStuckException(this.f17989a);
                    long jE = a.this.f17973c.e(new j.a(jVar, new ec.k(4), this.f17998j, 1));
                    a.this.I(this.f17989a, jE);
                    if (jE != ya.g.f56663b) {
                        f(jE);
                    }
                }
            }
            c cVar3 = this.f17992d;
            this.f17995g = jElapsedRealtime + ya.g.d(cVar3.f18043t.f18066e ? 0L : cVar3 != cVar2 ? cVar3.f18034k : cVar3.f18034k / 2);
            if (this.f17992d.f18035l == ya.g.f56663b && !this.f17989a.equals(a.this.f17982l)) {
                z10 = false;
            }
            if (!z10 || this.f17992d.f18036m) {
                return;
            }
            o(g());
        }

        public void v() {
            this.f17990b.l();
        }
    }

    public a(g gVar, j jVar, f fVar) {
        this(gVar, jVar, fVar, 3.5d);
    }

    public static c.e A(c cVar, c cVar2) {
        int i10 = (int) (cVar2.f18032i - cVar.f18032i);
        List<c.e> list = cVar.f18039p;
        if (i10 < list.size()) {
            return list.get(i10);
        }
        return null;
    }

    public final c B(@p0 c cVar, c cVar2) {
        return !cVar2.f(cVar) ? cVar2.f18036m ? cVar.d() : cVar : cVar2.c(D(cVar, cVar2), C(cVar, cVar2));
    }

    public final int C(@p0 c cVar, c cVar2) {
        c.e eVarA;
        if (cVar2.f18030g) {
            return cVar2.f18031h;
        }
        c cVar3 = this.f17983m;
        int i10 = cVar3 != null ? cVar3.f18031h : 0;
        return (cVar == null || (eVarA = A(cVar, cVar2)) == null) ? i10 : (cVar.f18031h + eVarA.f18054d) - cVar2.f18039p.get(0).f18054d;
    }

    public final long D(@p0 c cVar, c cVar2) {
        if (cVar2.f18037n) {
            return cVar2.f18029f;
        }
        c cVar3 = this.f17983m;
        long j10 = cVar3 != null ? cVar3.f18029f : 0L;
        if (cVar == null) {
            return j10;
        }
        int size = cVar.f18039p.size();
        c.e eVarA = A(cVar, cVar2);
        return eVarA != null ? cVar.f18029f + eVarA.f18055e : ((long) size) == cVar2.f18032i - cVar.f18032i ? cVar.e() : j10;
    }

    public final Uri E(Uri uri) {
        c.d dVar;
        c cVar = this.f17983m;
        if (cVar == null || !cVar.f18043t.f18066e || (dVar = cVar.f18041r.get(uri)) == null) {
            return uri;
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.appendQueryParameter(C0187a.f17986l, String.valueOf(dVar.f18047b));
        int i10 = dVar.f18048c;
        if (i10 != -1) {
            builderBuildUpon.appendQueryParameter(C0187a.f17987m, String.valueOf(i10));
        }
        return builderBuildUpon.build();
    }

    public final boolean F(Uri uri) {
        List<b.C0188b> list = this.f17981k.f18005e;
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (uri.equals(list.get(i10).f18018a)) {
                return true;
            }
        }
        return false;
    }

    public final boolean G() {
        List<b.C0188b> list = this.f17981k.f18005e;
        int size = list.size();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        for (int i10 = 0; i10 < size; i10++) {
            C0187a c0187a = (C0187a) hd.a.g(this.f17974d.get(list.get(i10).f18018a));
            if (jElapsedRealtime > c0187a.f17996h) {
                Uri uri = c0187a.f17989a;
                this.f17982l = uri;
                c0187a.o(E(uri));
                return true;
            }
        }
        return false;
    }

    public final void H(Uri uri) {
        if (uri.equals(this.f17982l) || !F(uri)) {
            return;
        }
        c cVar = this.f17983m;
        if (cVar == null || !cVar.f18036m) {
            this.f17982l = uri;
            this.f17974d.get(uri).o(E(uri));
        }
    }

    public final boolean I(Uri uri, long j10) {
        int size = this.f17975e.size();
        boolean z10 = false;
        for (int i10 = 0; i10 < size; i10++) {
            z10 |= !this.f17975e.get(i10).h(uri, j10);
        }
        return z10;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public void i(k<e> kVar, long j10, long j11, boolean z10) {
        ec.j jVar = new ec.j(kVar.f19268a, kVar.f19269b, kVar.f(), kVar.d(), j10, j11, kVar.a());
        this.f17973c.d(kVar.f19268a);
        this.f17977g.q(jVar, 4);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public void l(k<e> kVar, long j10, long j11) {
        e eVarE = kVar.e();
        boolean z10 = eVarE instanceof c;
        b bVarE = z10 ? b.e(eVarE.f39566a) : (b) eVarE;
        this.f17981k = bVarE;
        this.f17982l = bVarE.f18005e.get(0).f18018a;
        z(bVarE.f18004d);
        ec.j jVar = new ec.j(kVar.f19268a, kVar.f19269b, kVar.f(), kVar.d(), j10, j11, kVar.a());
        C0187a c0187a = this.f17974d.get(this.f17982l);
        if (z10) {
            c0187a.u((c) eVarE, jVar);
        } else {
            c0187a.m();
        }
        this.f17973c.d(kVar.f19268a);
        this.f17977g.t(jVar, 4);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public Loader.c t(k<e> kVar, long j10, long j11, IOException iOException, int i10) {
        ec.j jVar = new ec.j(kVar.f19268a, kVar.f19269b, kVar.f(), kVar.d(), j10, j11, kVar.a());
        long jA = this.f17973c.a(new j.a(jVar, new ec.k(kVar.f19270c), iOException, i10));
        boolean z10 = jA == ya.g.f56663b;
        this.f17977g.x(jVar, kVar.f19270c, iOException, z10);
        if (z10) {
            this.f17973c.d(kVar.f19268a);
        }
        return z10 ? Loader.f19042k : Loader.i(false, jA);
    }

    public final void M(Uri uri, c cVar) {
        if (uri.equals(this.f17982l)) {
            if (this.f17983m == null) {
                this.f17984n = !cVar.f18036m;
                this.f17985o = cVar.f18029f;
            }
            this.f17983m = cVar;
            this.f17980j.c(cVar);
        }
        int size = this.f17975e.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f17975e.get(i10).d();
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean a(Uri uri) {
        return this.f17974d.get(uri).j();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void b(HlsPlaylistTracker.b bVar) {
        this.f17975e.remove(bVar);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void c(Uri uri) throws IOException {
        this.f17974d.get(uri).p();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public long d() {
        return this.f17985o;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    @p0
    public b e() {
        return this.f17981k;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void f(Uri uri, m.a aVar, HlsPlaylistTracker.c cVar) {
        this.f17979i = u0.z();
        this.f17977g = aVar;
        this.f17980j = cVar;
        k kVar = new k(this.f17971a.a(4), uri, 4, this.f17972b.b());
        hd.a.i(this.f17978h == null);
        Loader loader = new Loader("DefaultHlsPlaylistTracker:MasterPlaylist");
        this.f17978h = loader;
        aVar.z(new ec.j(kVar.f19268a, kVar.f19269b, loader.n(kVar, this, this.f17973c.f(kVar.f19270c))), kVar.f19270c);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void g() throws IOException {
        Loader loader = this.f17978h;
        if (loader != null) {
            loader.a();
        }
        Uri uri = this.f17982l;
        if (uri != null) {
            c(uri);
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void h(Uri uri) {
        this.f17974d.get(uri).m();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean isLive() {
        return this.f17984n;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void j(HlsPlaylistTracker.b bVar) {
        hd.a.g(bVar);
        this.f17975e.add(bVar);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    @p0
    public c k(Uri uri, boolean z10) {
        c cVarH = this.f17974d.get(uri).h();
        if (cVarH != null && z10) {
            H(uri);
        }
        return cVarH;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void stop() {
        this.f17982l = null;
        this.f17983m = null;
        this.f17981k = null;
        this.f17985o = ya.g.f56663b;
        this.f17978h.l();
        this.f17978h = null;
        Iterator<C0187a> it2 = this.f17974d.values().iterator();
        while (it2.hasNext()) {
            it2.next().v();
        }
        this.f17979i.removeCallbacksAndMessages(null);
        this.f17979i = null;
        this.f17974d.clear();
    }

    public final void z(List<Uri> list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            Uri uri = list.get(i10);
            this.f17974d.put(uri, new C0187a(uri));
        }
    }

    public a(g gVar, j jVar, f fVar, double d10) {
        this.f17971a = gVar;
        this.f17972b = fVar;
        this.f17973c = jVar;
        this.f17976f = d10;
        this.f17975e = new ArrayList();
        this.f17974d = new HashMap<>();
        this.f17985o = ya.g.f56663b;
    }
}
