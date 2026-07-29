package bd;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.view.Surface;
import bd.b;
import bd.d;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import ec.x;
import g.i1;
import g.p0;
import g.v0;
import hd.u0;
import hd.w;
import id.z;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import ya.j1;
import ya.k;
import ya.o1;
import ya.s1;
import ya.u1;
import ya.x1;
import za.g1;
import za.h1;

/* JADX INFO: loaded from: classes3.dex */
@v0(18)
public final class l {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f9333k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f9334l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f9335m = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f9336n = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f9338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d.a f9339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f9340d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Looper f9341e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final hd.c f9342f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f9343g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @p0
    public bd.e f9344h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public u1 f9345i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f9346j;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f9347a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public x f9348b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d.a f9349c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f9350d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f9351e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f9352f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f9353g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public c f9354h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Looper f9355i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public hd.c f9356j;

        public class a implements c {
            public a() {
            }

            @Override // bd.l.c
            public /* synthetic */ void a(ya.v0 v0Var, Exception exc) {
                m.b(this, v0Var, exc);
            }

            @Override // bd.l.c
            public /* synthetic */ void b(ya.v0 v0Var) {
                m.a(this, v0Var);
            }
        }

        public l a() {
            hd.a.k(this.f9347a);
            if (this.f9348b == null) {
                hb.h hVar = new hb.h();
                if (this.f9352f) {
                    hVar.k(4);
                }
                this.f9348b = new com.google.android.exoplayer2.source.e(this.f9347a, hVar);
            }
            hd.a.j(this.f9349c.b(this.f9353g), "Unsupported output MIME type: " + this.f9353g);
            return new l(this.f9347a, this.f9348b, this.f9349c, new k(this.f9350d, this.f9351e, this.f9352f, this.f9353g), this.f9354h, this.f9355i, this.f9356j);
        }

        @i1
        public b b(hd.c cVar) {
            this.f9356j = cVar;
            return this;
        }

        public b c(Context context) {
            this.f9347a = context.getApplicationContext();
            return this;
        }

        public b d(boolean z10) {
            this.f9352f = z10;
            return this;
        }

        public b e(c cVar) {
            this.f9354h = cVar;
            return this;
        }

        public b f(Looper looper) {
            this.f9355i = looper;
            return this;
        }

        public b g(x xVar) {
            this.f9348b = xVar;
            return this;
        }

        @i1
        public b h(d.a aVar) {
            this.f9349c = aVar;
            return this;
        }

        public b i(String str) {
            this.f9353g = str;
            return this;
        }

        public b j(boolean z10) {
            this.f9350d = z10;
            return this;
        }

        public b k(boolean z10) {
            this.f9351e = z10;
            return this;
        }

        public b() {
            this.f9349c = new b.C0096b();
            this.f9353g = w.f31182f;
            this.f9354h = new a();
            this.f9355i = u0.X();
            this.f9356j = hd.c.f30965a;
        }

        public b(l lVar) {
            this.f9347a = lVar.f9337a;
            this.f9348b = lVar.f9338b;
            this.f9349c = lVar.f9339c;
            this.f9350d = lVar.f9340d.f9329a;
            this.f9351e = lVar.f9340d.f9330b;
            this.f9352f = lVar.f9340d.f9331c;
            this.f9353g = lVar.f9340d.f9332d;
            this.f9354h = lVar.f9343g;
            this.f9355i = lVar.f9341e;
            this.f9356j = lVar.f9342f;
        }
    }

    public interface c {
        void a(ya.v0 v0Var, Exception exc);

        void b(ya.v0 v0Var);
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface d {
    }

    public final class e implements h1 {
        public final ya.v0 Z;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public final bd.e f9358a0;

        public e(ya.v0 v0Var, bd.e eVar) {
            this.Z = v0Var;
            this.f9358a0 = eVar;
        }

        @Override // za.h1
        public /* synthetic */ void A(h1.b bVar, boolean z10) {
            g1.F(this, bVar, z10);
        }

        @Override // za.h1
        public /* synthetic */ void B(h1.b bVar, int i10) {
            g1.L(this, bVar, i10);
        }

        @Override // za.h1
        public /* synthetic */ void C(h1.b bVar, ec.k kVar) {
            g1.q(this, bVar, kVar);
        }

        @Override // za.h1
        public /* synthetic */ void D(h1.b bVar, String str) {
            g1.c0(this, bVar, str);
        }

        @Override // za.h1
        public /* synthetic */ void E(h1.b bVar) {
            g1.t(this, bVar);
        }

        @Override // za.h1
        public /* synthetic */ void F(h1.b bVar, String str, long j10) {
            g1.b0(this, bVar, str, j10);
        }

        @Override // za.h1
        public /* synthetic */ void G(h1.b bVar, int i10, eb.d dVar) {
            g1.m(this, bVar, i10, dVar);
        }

        @Override // za.h1
        public /* synthetic */ void H(h1.b bVar, Surface surface) {
            g1.Q(this, bVar, surface);
        }

        @Override // za.h1
        public /* synthetic */ void I(h1.b bVar, int i10, String str, long j10) {
            g1.o(this, bVar, i10, str, j10);
        }

        @Override // za.h1
        public /* synthetic */ void J(h1.b bVar) {
            g1.S(this, bVar);
        }

        @Override // za.h1
        public /* synthetic */ void K(h1.b bVar) {
            g1.w(this, bVar);
        }

        @Override // za.h1
        public /* synthetic */ void L(h1.b bVar, eb.d dVar) {
            g1.d(this, bVar, dVar);
        }

        @Override // za.h1
        public /* synthetic */ void M(h1.b bVar, ec.j jVar, ec.k kVar) {
            g1.B(this, bVar, jVar, kVar);
        }

        @Override // za.h1
        public void N(h1.b bVar, ExoPlaybackException exoPlaybackException) {
            k(exoPlaybackException);
        }

        @Override // za.h1
        public /* synthetic */ void O(h1.b bVar, eb.d dVar) {
            g1.e(this, bVar, dVar);
        }

        @Override // za.h1
        public /* synthetic */ void P(h1.b bVar, int i10, eb.d dVar) {
            g1.n(this, bVar, i10, dVar);
        }

        @Override // za.h1
        public void Q(h1.b bVar, TrackGroupArray trackGroupArray, ad.i iVar) {
            if (this.f9358a0.d() == 0) {
                k(new IllegalStateException("The output does not contain any tracks. Check that at least one of the input sample formats is supported."));
            }
        }

        @Override // za.h1
        public /* synthetic */ void R(h1.b bVar, int i10, Format format) {
            g1.p(this, bVar, i10, format);
        }

        @Override // za.h1
        public /* synthetic */ void S(h1.b bVar, int i10, long j10, long j11) {
            g1.k(this, bVar, i10, j10, j11);
        }

        @Override // za.h1
        public /* synthetic */ void T(h1.b bVar, long j10, int i10) {
            g1.f0(this, bVar, j10, i10);
        }

        @Override // za.h1
        public /* synthetic */ void U(h1.b bVar) {
            g1.T(this, bVar);
        }

        @Override // za.h1
        public /* synthetic */ void V(h1.b bVar, ec.j jVar, ec.k kVar) {
            g1.C(this, bVar, jVar, kVar);
        }

        @Override // za.h1
        public /* synthetic */ void X(h1.b bVar, int i10) {
            g1.i(this, bVar, i10);
        }

        @Override // za.h1
        public /* synthetic */ void Y(h1.b bVar, eb.d dVar) {
            g1.d0(this, bVar, dVar);
        }

        @Override // za.h1
        public /* synthetic */ void Z(h1.b bVar) {
            g1.u(this, bVar);
        }

        @Override // za.h1
        public /* synthetic */ void a(h1.b bVar, boolean z10) {
            g1.A(this, bVar, z10);
        }

        @Override // za.h1
        public /* synthetic */ void a0(h1.b bVar) {
            g1.N(this, bVar);
        }

        @Override // za.h1
        public /* synthetic */ void b(h1.b bVar, boolean z10) {
            g1.U(this, bVar, z10);
        }

        @Override // za.h1
        public /* synthetic */ void b0(h1.b bVar, float f10) {
            g1.j0(this, bVar, f10);
        }

        @Override // za.h1
        public /* synthetic */ void c(h1.b bVar, Format format) {
            g1.g0(this, bVar, format);
        }

        @Override // za.h1
        public /* synthetic */ void c0(h1.b bVar, ec.j jVar, ec.k kVar) {
            g1.E(this, bVar, jVar, kVar);
        }

        @Override // za.h1
        public /* synthetic */ void d(h1.b bVar, boolean z10) {
            g1.V(this, bVar, z10);
        }

        @Override // za.h1
        public /* synthetic */ void e(h1.b bVar, ec.j jVar, ec.k kVar, IOException iOException, boolean z10) {
            g1.D(this, bVar, jVar, kVar, iOException, z10);
        }

        @Override // za.h1
        public /* synthetic */ void e0(h1.b bVar, List list) {
            g1.W(this, bVar, list);
        }

        @Override // za.h1
        public /* synthetic */ void f(h1.b bVar, Exception exc) {
            g1.j(this, bVar, exc);
        }

        @Override // za.h1
        public /* synthetic */ void f0(h1.b bVar, eb.d dVar) {
            g1.e0(this, bVar, dVar);
        }

        @Override // za.h1
        public /* synthetic */ void g(h1.b bVar, ya.v0 v0Var, int i10) {
            g1.G(this, bVar, v0Var, i10);
        }

        @Override // za.h1
        public /* synthetic */ void g0(h1.b bVar, int i10) {
            g1.R(this, bVar, i10);
        }

        @Override // za.h1
        public /* synthetic */ void h(h1.b bVar, int i10, int i11, int i12, float f10) {
            g1.i0(this, bVar, i10, i11, i12, f10);
        }

        @Override // za.h1
        public /* synthetic */ void h0(h1.b bVar) {
            g1.s(this, bVar);
        }

        @Override // za.h1
        public /* synthetic */ void i(h1.b bVar, String str) {
            g1.c(this, bVar, str);
        }

        @Override // za.h1
        public /* synthetic */ void i0(j1 j1Var, h1.c cVar) {
            g1.y(this, j1Var, cVar);
        }

        @Override // za.h1
        public /* synthetic */ void j(h1.b bVar, boolean z10, int i10) {
            g1.O(this, bVar, z10, i10);
        }

        @Override // za.h1
        public /* synthetic */ void j0(h1.b bVar, Format format, eb.e eVar) {
            g1.h0(this, bVar, format, eVar);
        }

        public final void k(@p0 Exception exc) {
            try {
                l.this.p(false);
            } catch (IllegalStateException e10) {
                if (exc == null) {
                    exc = e10;
                }
            }
            if (exc == null) {
                l.this.f9343g.b(this.Z);
            } else {
                l.this.f9343g.a(this.Z, exc);
            }
        }

        @Override // za.h1
        public void k0(h1.b bVar, int i10) {
            if (l.this.f9346j != 0) {
                return;
            }
            x1.c cVar = new x1.c();
            bVar.f58100b.n(0, cVar);
            if (cVar.f57251l) {
                return;
            }
            long j10 = cVar.f57255p;
            l.this.f9346j = (j10 <= 0 || j10 == ya.g.f56663b) ? 2 : 1;
            ((u1) hd.a.g(l.this.f9345i)).i();
        }

        @Override // za.h1
        public void l(h1.b bVar, int i10) {
            if (i10 == 4) {
                k(null);
            }
        }

        @Override // za.h1
        public /* synthetic */ void l0(h1.b bVar, Format format, eb.e eVar) {
            g1.g(this, bVar, format, eVar);
        }

        @Override // za.h1
        public /* synthetic */ void m(h1.b bVar, ab.d dVar) {
            g1.a(this, bVar, dVar);
        }

        @Override // za.h1
        public /* synthetic */ void m0(h1.b bVar, int i10, int i11) {
            g1.X(this, bVar, i10, i11);
        }

        @Override // za.h1
        public /* synthetic */ void n(h1.b bVar, ya.h1 h1Var) {
            g1.J(this, bVar, h1Var);
        }

        @Override // za.h1
        public /* synthetic */ void n0(h1.b bVar, ec.k kVar) {
            g1.a0(this, bVar, kVar);
        }

        @Override // za.h1
        public /* synthetic */ void o(h1.b bVar, long j10) {
            g1.h(this, bVar, j10);
        }

        @Override // za.h1
        public /* synthetic */ void p(h1.b bVar, Format format) {
            g1.f(this, bVar, format);
        }

        @Override // za.h1
        public /* synthetic */ void r(h1.b bVar, boolean z10) {
            g1.z(this, bVar, z10);
        }

        @Override // za.h1
        public /* synthetic */ void s(h1.b bVar, int i10, long j10) {
            g1.x(this, bVar, i10, j10);
        }

        @Override // za.h1
        public /* synthetic */ void t(h1.b bVar, int i10, long j10, long j11) {
            g1.l(this, bVar, i10, j10, j11);
        }

        @Override // za.h1
        public /* synthetic */ void u(h1.b bVar) {
            g1.r(this, bVar);
        }

        @Override // za.h1
        public /* synthetic */ void v(h1.b bVar, Metadata metadata) {
            g1.H(this, bVar, metadata);
        }

        @Override // za.h1
        public /* synthetic */ void w(h1.b bVar, int i10) {
            g1.P(this, bVar, i10);
        }

        @Override // za.h1
        public /* synthetic */ void x(h1.b bVar, boolean z10, int i10) {
            g1.I(this, bVar, z10, i10);
        }

        @Override // za.h1
        public /* synthetic */ void y(h1.b bVar, String str, long j10) {
            g1.b(this, bVar, str, j10);
        }

        @Override // za.h1
        public /* synthetic */ void z(h1.b bVar, Exception exc) {
            g1.v(this, bVar, exc);
        }
    }

    public static final class f implements s1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bd.e f9360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p f9361b = new p();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final k f9362c;

        public f(bd.e eVar, k kVar) {
            this.f9360a = eVar;
            this.f9362c = kVar;
        }

        @Override // ya.s1
        public o1[] a(Handler handler, z zVar, com.google.android.exoplayer2.audio.a aVar, qc.k kVar, ub.e eVar) {
            k kVar2 = this.f9362c;
            boolean z10 = kVar2.f9329a;
            char c10 = 1;
            o1[] o1VarArr = new o1[(z10 || kVar2.f9330b) ? 1 : 2];
            if (z10) {
                c10 = 0;
            } else {
                o1VarArr[0] = new n(this.f9360a, this.f9361b, kVar2);
            }
            k kVar3 = this.f9362c;
            if (!kVar3.f9330b) {
                o1VarArr[c10] = new q(this.f9360a, this.f9361b, kVar3);
            }
            return o1VarArr;
        }
    }

    public b l() {
        return new b();
    }

    public void m() {
        p(true);
    }

    public Looper n() {
        return this.f9341e;
    }

    public int o(bd.f fVar) {
        u();
        if (this.f9346j == 1) {
            j1 j1Var = (j1) hd.a.g(this.f9345i);
            fVar.f9304a = Math.min((int) ((j1Var.H1() * 100) / j1Var.m1()), 99);
        }
        return this.f9346j;
    }

    public final void p(boolean z10) {
        u();
        u1 u1Var = this.f9345i;
        if (u1Var != null) {
            u1Var.release();
            this.f9345i = null;
        }
        bd.e eVar = this.f9344h;
        if (eVar != null) {
            eVar.f(z10);
            this.f9344h = null;
        }
        this.f9346j = 4;
    }

    public void q(c cVar) {
        u();
        this.f9343g = cVar;
    }

    @v0(26)
    public void r(ya.v0 v0Var, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        s(v0Var, this.f9339c.a(parcelFileDescriptor, this.f9340d.f9332d));
    }

    public final void s(ya.v0 v0Var, bd.d dVar) {
        u();
        if (this.f9345i != null) {
            throw new IllegalStateException("There is already a transformation in progress.");
        }
        bd.e eVar = new bd.e(dVar);
        this.f9344h = eVar;
        DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector(this.f9337a);
        defaultTrackSelector.M(new DefaultTrackSelector.d(this.f9337a).C(true).a());
        u1 u1VarW = new u1.b(this.f9337a, new f(eVar, this.f9340d)).G(this.f9338b).M(defaultTrackSelector).E(new k.a().e(50000, 50000, 250, 500).a()).F(this.f9341e).A(this.f9342f).w();
        this.f9345i = u1VarW;
        u1VarW.D0(v0Var);
        this.f9345i.n2(new e(v0Var, eVar));
        this.f9345i.f();
        this.f9346j = 0;
    }

    public void t(ya.v0 v0Var, String str) throws IOException {
        s(v0Var, this.f9339c.c(str, this.f9340d.f9332d));
    }

    public final void u() {
        if (Looper.myLooper() != this.f9341e) {
            throw new IllegalStateException("Transformer is accessed on the wrong thread.");
        }
    }

    public l(Context context, x xVar, d.a aVar, k kVar, c cVar, Looper looper, hd.c cVar2) {
        hd.a.j((kVar.f9329a && kVar.f9330b) ? false : true, "Audio and video cannot both be removed.");
        this.f9337a = context;
        this.f9338b = xVar;
        this.f9339c = aVar;
        this.f9340d = kVar;
        this.f9343g = cVar;
        this.f9341e = looper;
        this.f9342f = cVar2;
        this.f9346j = 4;
    }
}
