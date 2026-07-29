package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.exoplayer2.source.ads.a;
import com.google.android.exoplayer2.source.ads.b;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.l;
import ec.j;
import ec.x;
import ed.z;
import fc.h;
import g.p0;
import hd.u0;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ya.g;
import ya.v0;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class AdsMediaSource extends com.google.android.exoplayer2.source.c<l.a> {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final l.a f17511v = new l.a(new Object());

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final l f17512j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final x f17513k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.ads.b f17514l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b.a f17515m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.b f17516n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Object f17517o;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @p0
    public c f17520r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @p0
    public x1 f17521s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @p0
    public com.google.android.exoplayer2.source.ads.a f17522t;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Handler f17518p = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final x1.b f17519q = new x1.b();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public a[][] f17523u = new a[0][];

    public static final class AdLoadException extends IOException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f17524a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f17525b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f17526c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f17527d = 3;
        public final int type;

        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface a {
        }

        public AdLoadException(int i10, Exception exc) {
            super(exc);
            this.type = i10;
        }

        public static AdLoadException a(Exception exc) {
            return new AdLoadException(0, exc);
        }

        public static AdLoadException b(Exception exc, int i10) {
            return new AdLoadException(1, new IOException("Failed to load ad group " + i10, exc));
        }

        public static AdLoadException c(Exception exc) {
            return new AdLoadException(2, exc);
        }

        public static AdLoadException d(RuntimeException runtimeException) {
            return new AdLoadException(3, runtimeException);
        }

        public RuntimeException f() {
            hd.a.i(this.type == 3);
            return (RuntimeException) hd.a.g(getCause());
        }
    }

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l.a f17528a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<i> f17529b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Uri f17530c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public l f17531d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public x1 f17532e;

        public a(l.a aVar) {
            this.f17528a = aVar;
        }

        public k a(l.a aVar, ed.b bVar, long j10) {
            i iVar = new i(aVar, bVar, j10);
            this.f17529b.add(iVar);
            l lVar = this.f17531d;
            if (lVar != null) {
                iVar.y(lVar);
                iVar.z(AdsMediaSource.this.new b((Uri) hd.a.g(this.f17530c)));
            }
            x1 x1Var = this.f17532e;
            if (x1Var != null) {
                iVar.d(new l.a(x1Var.m(0), aVar.f26859d));
            }
            return iVar;
        }

        public long b() {
            x1 x1Var = this.f17532e;
            return x1Var == null ? g.f56663b : x1Var.f(0, AdsMediaSource.this.f17519q).j();
        }

        public void c(x1 x1Var) {
            hd.a.a(x1Var.i() == 1);
            if (this.f17532e == null) {
                Object objM = x1Var.m(0);
                for (int i10 = 0; i10 < this.f17529b.size(); i10++) {
                    i iVar = this.f17529b.get(i10);
                    iVar.d(new l.a(objM, iVar.f18129a.f26859d));
                }
            }
            this.f17532e = x1Var;
        }

        public boolean d() {
            return this.f17531d != null;
        }

        public void e(l lVar, Uri uri) {
            this.f17531d = lVar;
            this.f17530c = uri;
            for (int i10 = 0; i10 < this.f17529b.size(); i10++) {
                i iVar = this.f17529b.get(i10);
                iVar.y(lVar);
                iVar.z(AdsMediaSource.this.new b(uri));
            }
            AdsMediaSource.this.N(this.f17528a, lVar);
        }

        public boolean f() {
            return this.f17529b.isEmpty();
        }

        public void g() {
            if (d()) {
                AdsMediaSource.this.O(this.f17528a);
            }
        }

        public void h(i iVar) {
            this.f17529b.remove(iVar);
            iVar.x();
        }
    }

    public final class b implements i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f17534a;

        public b(Uri uri) {
            this.f17534a = uri;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(l.a aVar) {
            AdsMediaSource.this.f17514l.a(AdsMediaSource.this, aVar.f26857b, aVar.f26858c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(l.a aVar, IOException iOException) {
            AdsMediaSource.this.f17514l.b(AdsMediaSource.this, aVar.f26857b, aVar.f26858c, iOException);
        }

        @Override // com.google.android.exoplayer2.source.i.a
        public void a(final l.a aVar) {
            AdsMediaSource.this.f17518p.post(new Runnable() { // from class: fc.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f28026a.e(aVar);
                }
            });
        }

        @Override // com.google.android.exoplayer2.source.i.a
        public void b(final l.a aVar, final IOException iOException) {
            AdsMediaSource.this.x(aVar).x(new j(j.a(), new com.google.android.exoplayer2.upstream.b(this.f17534a), SystemClock.elapsedRealtime()), 6, AdLoadException.a(iOException), true);
            AdsMediaSource.this.f17518p.post(new Runnable() { // from class: fc.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f28028a.f(aVar, iOException);
                }
            });
        }
    }

    public final class c implements b.InterfaceC0182b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f17536a = u0.z();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f17537b;

        public c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(com.google.android.exoplayer2.source.ads.a aVar) {
            if (this.f17537b) {
                return;
            }
            AdsMediaSource.this.f0(aVar);
        }

        @Override // com.google.android.exoplayer2.source.ads.b.InterfaceC0182b
        public void a(final com.google.android.exoplayer2.source.ads.a aVar) {
            if (this.f17537b) {
                return;
            }
            this.f17536a.post(new Runnable() { // from class: fc.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f28031a.f(aVar);
                }
            });
        }

        @Override // com.google.android.exoplayer2.source.ads.b.InterfaceC0182b
        public /* synthetic */ void b() {
            fc.b.a(this);
        }

        @Override // com.google.android.exoplayer2.source.ads.b.InterfaceC0182b
        public void c(AdLoadException adLoadException, com.google.android.exoplayer2.upstream.b bVar) {
            if (this.f17537b) {
                return;
            }
            AdsMediaSource.this.x(null).x(new j(j.a(), bVar, SystemClock.elapsedRealtime()), 6, adLoadException, true);
        }

        @Override // com.google.android.exoplayer2.source.ads.b.InterfaceC0182b
        public /* synthetic */ void d() {
            fc.b.d(this);
        }

        public void g() {
            this.f17537b = true;
            this.f17536a.removeCallbacksAndMessages(null);
        }
    }

    public AdsMediaSource(l lVar, com.google.android.exoplayer2.upstream.b bVar, Object obj, x xVar, com.google.android.exoplayer2.source.ads.b bVar2, b.a aVar) {
        this.f17512j = lVar;
        this.f17513k = xVar;
        this.f17514l = bVar2;
        this.f17515m = aVar;
        this.f17516n = bVar;
        this.f17517o = obj;
        bVar2.e(xVar.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(c cVar) {
        this.f17514l.d(this, this.f17516n, this.f17517o, this.f17515m, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(c cVar) {
        this.f17514l.c(this, cVar);
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.a
    public void C(@p0 z zVar) {
        super.C(zVar);
        final c cVar = new c();
        this.f17520r = cVar;
        N(f17511v, this.f17512j);
        this.f17518p.post(new Runnable() { // from class: fc.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f28022a.b0(cVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.a
    public void E() {
        super.E();
        final c cVar = (c) hd.a.g(this.f17520r);
        this.f17520r = null;
        cVar.g();
        this.f17521s = null;
        this.f17522t = null;
        this.f17523u = new a[0][];
        this.f17518p.post(new Runnable() { // from class: fc.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f28024a.c0(cVar);
            }
        });
    }

    public final long[][] Z() {
        long[][] jArr = new long[this.f17523u.length][];
        int i10 = 0;
        while (true) {
            a[][] aVarArr = this.f17523u;
            if (i10 >= aVarArr.length) {
                return jArr;
            }
            jArr[i10] = new long[aVarArr[i10].length];
            int i11 = 0;
            while (true) {
                a[][] aVarArr2 = this.f17523u;
                if (i11 < aVarArr2[i10].length) {
                    a aVar = aVarArr2[i10][i11];
                    jArr[i10][i11] = aVar == null ? g.f56663b : aVar.b();
                    i11++;
                }
            }
            i10++;
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.a aVar, ed.b bVar, long j10) {
        if (((com.google.android.exoplayer2.source.ads.a) hd.a.g(this.f17522t)).f17546b <= 0 || !aVar.b()) {
            i iVar = new i(aVar, bVar, j10);
            iVar.y(this.f17512j);
            iVar.d(aVar);
            return iVar;
        }
        int i10 = aVar.f26857b;
        int i11 = aVar.f26858c;
        a[][] aVarArr = this.f17523u;
        if (aVarArr[i10].length <= i11) {
            aVarArr[i10] = (a[]) Arrays.copyOf(aVarArr[i10], i11 + 1);
        }
        a aVar2 = this.f17523u[i10][i11];
        if (aVar2 == null) {
            aVar2 = new a(aVar);
            this.f17523u[i10][i11] = aVar2;
            d0();
        }
        return aVar2.a(aVar, bVar, j10);
    }

    @Override // com.google.android.exoplayer2.source.c
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public l.a I(l.a aVar, l.a aVar2) {
        return aVar.b() ? aVar : aVar2;
    }

    public final void d0() {
        Uri uri;
        v0.e eVar;
        com.google.android.exoplayer2.source.ads.a aVar = this.f17522t;
        if (aVar == null) {
            return;
        }
        for (int i10 = 0; i10 < this.f17523u.length; i10++) {
            int i11 = 0;
            while (true) {
                a[][] aVarArr = this.f17523u;
                if (i11 < aVarArr[i10].length) {
                    a aVar2 = aVarArr[i10][i11];
                    if (aVar2 != null && !aVar2.d()) {
                        a.C0181a[] c0181aArr = aVar.f17548d;
                        if (c0181aArr[i10] != null && i11 < c0181aArr[i10].f17552b.length && (uri = c0181aArr[i10].f17552b[i11]) != null) {
                            v0.c cVarF = new v0.c().F(uri);
                            v0.g gVar = this.f17512j.j().f57132b;
                            if (gVar != null && (eVar = gVar.f57185c) != null) {
                                cVarF.t(eVar.f57169a);
                                cVarF.l(eVar.a());
                                cVarF.n(eVar.f57170b);
                                cVarF.k(eVar.f57174f);
                                cVarF.m(eVar.f57171c);
                                cVarF.p(eVar.f57172d);
                                cVarF.q(eVar.f57173e);
                                cVarF.s(eVar.f57175g);
                            }
                            aVar2.e(this.f17513k.c(cVarF.a()), uri);
                        }
                    }
                    i11++;
                }
            }
        }
    }

    public final void e0() {
        x1 x1Var = this.f17521s;
        com.google.android.exoplayer2.source.ads.a aVar = this.f17522t;
        if (aVar == null || x1Var == null) {
            return;
        }
        if (aVar.f17546b == 0) {
            D(x1Var);
        } else {
            this.f17522t = aVar.f(Z());
            D(new h(x1Var, this.f17522t));
        }
    }

    public final void f0(com.google.android.exoplayer2.source.ads.a aVar) {
        com.google.android.exoplayer2.source.ads.a aVar2 = this.f17522t;
        if (aVar2 == null) {
            a[][] aVarArr = new a[aVar.f17546b][];
            this.f17523u = aVarArr;
            Arrays.fill(aVarArr, new a[0]);
        } else {
            hd.a.i(aVar.f17546b == aVar2.f17546b);
        }
        this.f17522t = aVar;
        d0();
        e0();
    }

    @Override // com.google.android.exoplayer2.source.c
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public void L(l.a aVar, l lVar, x1 x1Var) {
        if (aVar.b()) {
            ((a) hd.a.g(this.f17523u[aVar.f26857b][aVar.f26858c])).c(x1Var);
        } else {
            hd.a.a(x1Var.i() == 1);
            this.f17521s = x1Var;
        }
        e0();
    }

    @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.source.l
    @p0
    @Deprecated
    public Object h() {
        return this.f17512j.h();
    }

    @Override // com.google.android.exoplayer2.source.l
    public v0 j() {
        return this.f17512j.j();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void p(k kVar) {
        i iVar = (i) kVar;
        l.a aVar = iVar.f18129a;
        if (!aVar.b()) {
            iVar.x();
            return;
        }
        a aVar2 = (a) hd.a.g(this.f17523u[aVar.f26857b][aVar.f26858c]);
        aVar2.h(iVar);
        if (aVar2.f()) {
            aVar2.g();
            this.f17523u[aVar.f26857b][aVar.f26858c] = null;
        }
    }
}
