package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.google.android.exoplayer2.upstream.h;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import ed.j;
import ed.v;
import ed.y;
import ed.z;
import fd.f;
import fd.g;
import fd.k;
import fd.m;
import g.p0;
import hd.u0;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.google.android.exoplayer2.upstream.a {
    public static final int A = 1;
    public static final long B = 102400;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f19150v = 1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f19151w = 2;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f19152x = 4;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f19153y = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f19154z = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Cache f19155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.a f19156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public final com.google.android.exoplayer2.upstream.a f19157d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.a f19158e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f f19159f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public final c f19160g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f19161h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f19162i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f19163j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public Uri f19164k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @p0
    public com.google.android.exoplayer2.upstream.b f19165l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @p0
    public com.google.android.exoplayer2.upstream.a f19166m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f19167n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f19168o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f19169p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @p0
    public g f19170q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f19171r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f19172s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f19173t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f19174u;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    public interface c {
        void a(int i10);

        void b(long j10, long j11);
    }

    public static final class d implements a.InterfaceC0197a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Cache f19175a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public j.a f19177c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f19179e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @p0
        public a.InterfaceC0197a f19180f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @p0
        public PriorityTaskManager f19181g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f19182h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f19183i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @p0
        public c f19184j;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a.InterfaceC0197a f19176b = new FileDataSource.a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public f f19178d = f.f28053a;

        @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0197a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a() {
            a.InterfaceC0197a interfaceC0197a = this.f19180f;
            return g(interfaceC0197a != null ? interfaceC0197a.a() : null, this.f19183i, this.f19182h);
        }

        public a e() {
            a.InterfaceC0197a interfaceC0197a = this.f19180f;
            return g(interfaceC0197a != null ? interfaceC0197a.a() : null, this.f19183i | 1, -1000);
        }

        public a f() {
            return g(null, this.f19183i | 1, -1000);
        }

        public final a g(@p0 com.google.android.exoplayer2.upstream.a aVar, int i10, int i11) {
            j jVarA;
            Cache cache = (Cache) hd.a.g(this.f19175a);
            if (this.f19179e || aVar == null) {
                jVarA = null;
            } else {
                j.a aVar2 = this.f19177c;
                jVarA = aVar2 != null ? aVar2.a() : new CacheDataSink.a().c(cache).a();
            }
            return new a(cache, aVar, this.f19176b.a(), jVarA, this.f19178d, i10, this.f19181g, i11, this.f19184j);
        }

        @p0
        public Cache h() {
            return this.f19175a;
        }

        public f i() {
            return this.f19178d;
        }

        @p0
        public PriorityTaskManager j() {
            return this.f19181g;
        }

        public d k(Cache cache) {
            this.f19175a = cache;
            return this;
        }

        public d l(f fVar) {
            this.f19178d = fVar;
            return this;
        }

        public d m(a.InterfaceC0197a interfaceC0197a) {
            this.f19176b = interfaceC0197a;
            return this;
        }

        public d n(@p0 j.a aVar) {
            this.f19177c = aVar;
            this.f19179e = aVar == null;
            return this;
        }

        public d o(@p0 c cVar) {
            this.f19184j = cVar;
            return this;
        }

        public d p(int i10) {
            this.f19183i = i10;
            return this;
        }

        public d q(@p0 a.InterfaceC0197a interfaceC0197a) {
            this.f19180f = interfaceC0197a;
            return this;
        }

        public d r(int i10) {
            this.f19182h = i10;
            return this;
        }

        public d s(@p0 PriorityTaskManager priorityTaskManager) {
            this.f19181g = priorityTaskManager;
            return this;
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface e {
    }

    public static Uri x(Cache cache, String str, Uri uri) {
        Uri uriB = k.b(cache.d(str));
        return uriB != null ? uriB : uri;
    }

    public final boolean A() {
        return this.f19166m == this.f19156c;
    }

    public final boolean B() {
        return !A();
    }

    public final boolean C() {
        return this.f19166m == this.f19157d;
    }

    public final void D() {
        c cVar = this.f19160g;
        if (cVar == null || this.f19173t <= 0) {
            return;
        }
        cVar.b(this.f19155b.m(), this.f19173t);
        this.f19173t = 0L;
    }

    public final void E(int i10) {
        c cVar = this.f19160g;
        if (cVar != null) {
            cVar.a(i10);
        }
    }

    public final void F(com.google.android.exoplayer2.upstream.b bVar, boolean z10) throws IOException {
        g gVarH;
        long jMin;
        com.google.android.exoplayer2.upstream.b bVarA;
        com.google.android.exoplayer2.upstream.a aVar;
        String str = (String) u0.k(bVar.f19100i);
        if (this.f19172s) {
            gVarH = null;
        } else if (this.f19161h) {
            try {
                gVarH = this.f19155b.h(str, this.f19168o, this.f19169p);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            gVarH = this.f19155b.f(str, this.f19168o, this.f19169p);
        }
        if (gVarH == null) {
            aVar = this.f19158e;
            bVarA = bVar.a().i(this.f19168o).h(this.f19169p).a();
        } else if (gVarH.f28057d) {
            Uri uriFromFile = Uri.fromFile((File) u0.k(gVarH.f28058e));
            long j10 = gVarH.f28055b;
            long j11 = this.f19168o - j10;
            long jMin2 = gVarH.f28056c - j11;
            long j12 = this.f19169p;
            if (j12 != -1) {
                jMin2 = Math.min(jMin2, j12);
            }
            bVarA = bVar.a().j(uriFromFile).l(j10).i(j11).h(jMin2).a();
            aVar = this.f19156c;
        } else {
            if (gVarH.e()) {
                jMin = this.f19169p;
            } else {
                jMin = gVarH.f28056c;
                long j13 = this.f19169p;
                if (j13 != -1) {
                    jMin = Math.min(jMin, j13);
                }
            }
            bVarA = bVar.a().i(this.f19168o).h(jMin).a();
            aVar = this.f19157d;
            if (aVar == null) {
                aVar = this.f19158e;
                this.f19155b.n(gVarH);
                gVarH = null;
            }
        }
        this.f19174u = (this.f19172s || aVar != this.f19158e) ? Long.MAX_VALUE : this.f19168o + B;
        if (z10) {
            hd.a.i(z());
            if (aVar == this.f19158e) {
                return;
            }
            try {
                u();
            } finally {
            }
        }
        if (gVarH != null && gVarH.d()) {
            this.f19170q = gVarH;
        }
        this.f19166m = aVar;
        this.f19167n = bVarA.f19099h == -1;
        long jA = aVar.a(bVarA);
        m mVar = new m();
        if (this.f19167n && jA != -1) {
            this.f19169p = jA;
            m.h(mVar, this.f19168o + jA);
        }
        if (B()) {
            Uri uriS = aVar.s();
            this.f19164k = uriS;
            m.i(mVar, bVar.f19092a.equals(uriS) ^ true ? this.f19164k : null);
        }
        if (C()) {
            this.f19155b.l(str, mVar);
        }
    }

    public final void G(String str) throws IOException {
        this.f19169p = 0L;
        if (C()) {
            m mVar = new m();
            m.h(mVar, this.f19168o);
            this.f19155b.l(str, mVar);
        }
    }

    public final int H(com.google.android.exoplayer2.upstream.b bVar) {
        if (this.f19162i && this.f19171r) {
            return 0;
        }
        return (this.f19163j && bVar.f19099h == -1) ? 1 : -1;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        try {
            String strA = this.f19159f.a(bVar);
            com.google.android.exoplayer2.upstream.b bVarA = bVar.a().g(strA).a();
            this.f19165l = bVarA;
            this.f19164k = x(this.f19155b, strA, bVarA.f19092a);
            this.f19168o = bVar.f19098g;
            int iH = H(bVar);
            boolean z10 = iH != -1;
            this.f19172s = z10;
            if (z10) {
                E(iH);
            }
            long j10 = bVar.f19099h;
            if (j10 != -1 || this.f19172s) {
                this.f19169p = j10;
            } else {
                long jA = k.a(this.f19155b.d(strA));
                this.f19169p = jA;
                if (jA != -1) {
                    long j11 = jA - bVar.f19098g;
                    this.f19169p = j11;
                    if (j11 <= 0) {
                        throw new DataSourceException(0);
                    }
                }
            }
            F(bVarA, false);
            return this.f19169p;
        } catch (Throwable th2) {
            y(th2);
            throw th2;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Map<String, List<String>> c() {
        return B() ? this.f19158e.c() : Collections.emptyMap();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws IOException {
        this.f19165l = null;
        this.f19164k = null;
        this.f19168o = 0L;
        D();
        try {
            u();
        } catch (Throwable th2) {
            y(th2);
            throw th2;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void d(z zVar) {
        hd.a.g(zVar);
        this.f19156c.d(zVar);
        this.f19158e.d(zVar);
    }

    @Override // ed.h
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        com.google.android.exoplayer2.upstream.b bVar = (com.google.android.exoplayer2.upstream.b) hd.a.g(this.f19165l);
        if (i11 == 0) {
            return 0;
        }
        if (this.f19169p == 0) {
            return -1;
        }
        try {
            if (this.f19168o >= this.f19174u) {
                F(bVar, true);
            }
            int i12 = ((com.google.android.exoplayer2.upstream.a) hd.a.g(this.f19166m)).read(bArr, i10, i11);
            if (i12 != -1) {
                if (A()) {
                    this.f19173t += (long) i12;
                }
                long j10 = i12;
                this.f19168o += j10;
                long j11 = this.f19169p;
                if (j11 != -1) {
                    this.f19169p = j11 - j10;
                }
            } else {
                if (!this.f19167n) {
                    long j12 = this.f19169p;
                    if (j12 <= 0) {
                        if (j12 == -1) {
                        }
                    }
                    u();
                    F(bVar, false);
                    return read(bArr, i10, i11);
                }
                G((String) u0.k(bVar.f19100i));
            }
            return i12;
        } catch (IOException e10) {
            if (this.f19167n && DataSourceException.a(e10)) {
                G((String) u0.k(bVar.f19100i));
                return -1;
            }
            y(e10);
            throw e10;
        } catch (Throwable th2) {
            y(th2);
            throw th2;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @p0
    public Uri s() {
        return this.f19164k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void u() throws IOException {
        com.google.android.exoplayer2.upstream.a aVar = this.f19166m;
        if (aVar == null) {
            return;
        }
        try {
            aVar.close();
        } finally {
            this.f19166m = null;
            this.f19167n = false;
            g gVar = this.f19170q;
            if (gVar != null) {
                this.f19155b.n(gVar);
                this.f19170q = null;
            }
        }
    }

    public Cache v() {
        return this.f19155b;
    }

    public f w() {
        return this.f19159f;
    }

    public final void y(Throwable th2) {
        if (A() || (th2 instanceof Cache.CacheException)) {
            this.f19171r = true;
        }
    }

    public final boolean z() {
        return this.f19166m == this.f19158e;
    }

    public a(Cache cache, @p0 com.google.android.exoplayer2.upstream.a aVar) {
        this(cache, aVar, 0);
    }

    public a(Cache cache, @p0 com.google.android.exoplayer2.upstream.a aVar, int i10) {
        this(cache, aVar, new FileDataSource(), new CacheDataSink(cache, CacheDataSink.f19133k), i10, null);
    }

    public a(Cache cache, @p0 com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.a aVar2, @p0 j jVar, int i10, @p0 c cVar) {
        this(cache, aVar, aVar2, jVar, i10, cVar, null);
    }

    public a(Cache cache, @p0 com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.a aVar2, @p0 j jVar, int i10, @p0 c cVar, @p0 f fVar) {
        this(cache, aVar, aVar2, jVar, fVar, i10, null, 0, cVar);
    }

    public a(Cache cache, @p0 com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.a aVar2, @p0 j jVar, @p0 f fVar, int i10, @p0 PriorityTaskManager priorityTaskManager, int i11, @p0 c cVar) {
        this.f19155b = cache;
        this.f19156c = aVar2;
        this.f19159f = fVar == null ? f.f28053a : fVar;
        this.f19161h = (i10 & 1) != 0;
        this.f19162i = (i10 & 2) != 0;
        this.f19163j = (i10 & 4) != 0;
        if (aVar != null) {
            aVar = priorityTaskManager != null ? new v(aVar, priorityTaskManager, i11) : aVar;
            this.f19158e = aVar;
            this.f19157d = jVar != null ? new y(aVar, jVar) : null;
        } else {
            this.f19158e = h.f19261b;
            this.f19157d = null;
        }
        this.f19160g = cVar;
    }
}
