package ya;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoTimeoutException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;
import ya.b;
import ya.d;
import ya.j;
import ya.j1;
import ya.l1;
import ya.v1;

/* JADX INFO: loaded from: classes3.dex */
public class u1 extends e implements n, j1.a, j1.p, j1.n, j1.i, j1.c {
    public static final long E0 = 2000;
    public static final String F0 = "SimpleExoPlayer";
    public static final String G0 = "Player is accessed on the wrong thread. See https://exoplayer.dev/issues/player-accessed-on-wrong-thread";

    @g.p0
    public PriorityTaskManager A0;
    public boolean B0;
    public boolean C0;
    public fb.a D0;
    public final o1[] P;
    public final Context Q;
    public final m0 R;
    public final c S;
    public final CopyOnWriteArraySet<id.o> T;
    public final CopyOnWriteArraySet<ab.h> U;
    public final CopyOnWriteArraySet<qc.k> V;
    public final CopyOnWriteArraySet<ub.e> W;
    public final CopyOnWriteArraySet<fb.c> X;
    public final za.f1 Y;
    public final ya.b Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final d f57079a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final v1 f57080b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final y1 f57081c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final z1 f57082d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final long f57083e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    @g.p0
    public Format f57084f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    @g.p0
    public Format f57085g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    @g.p0
    public AudioTrack f57086h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    @g.p0
    public Surface f57087i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean f57088j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f57089k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    @g.p0
    public SurfaceHolder f57090l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    @g.p0
    public TextureView f57091m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f57092n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public int f57093o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    @g.p0
    public eb.d f57094p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    @g.p0
    public eb.d f57095q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f57096r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public ab.d f57097s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public float f57098t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public boolean f57099u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public List<qc.b> f57100v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    @g.p0
    public id.l f57101w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    @g.p0
    public jd.a f57102x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public boolean f57103y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public boolean f57104z0;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f57105a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final s1 f57106b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public hd.c f57107c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ad.j f57108d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ec.x f57109e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public u0 f57110f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ed.d f57111g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public za.f1 f57112h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Looper f57113i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @g.p0
        public PriorityTaskManager f57114j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public ab.d f57115k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f57116l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f57117m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f57118n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f57119o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f57120p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f57121q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public t1 f57122r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public t0 f57123s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public long f57124t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public long f57125u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f57126v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public boolean f57127w;

        public b(Context context) {
            this(context, new m(context), new hb.h());
        }

        @g.i1
        public b A(hd.c cVar) {
            hd.a.i(!this.f57127w);
            this.f57107c = cVar;
            return this;
        }

        public b B(long j10) {
            hd.a.i(!this.f57127w);
            this.f57125u = j10;
            return this;
        }

        public b C(boolean z10) {
            hd.a.i(!this.f57127w);
            this.f57118n = z10;
            return this;
        }

        public b D(t0 t0Var) {
            hd.a.i(!this.f57127w);
            this.f57123s = t0Var;
            return this;
        }

        public b E(u0 u0Var) {
            hd.a.i(!this.f57127w);
            this.f57110f = u0Var;
            return this;
        }

        public b F(Looper looper) {
            hd.a.i(!this.f57127w);
            this.f57113i = looper;
            return this;
        }

        public b G(ec.x xVar) {
            hd.a.i(!this.f57127w);
            this.f57109e = xVar;
            return this;
        }

        public b H(boolean z10) {
            hd.a.i(!this.f57127w);
            this.f57126v = z10;
            return this;
        }

        public b I(@g.p0 PriorityTaskManager priorityTaskManager) {
            hd.a.i(!this.f57127w);
            this.f57114j = priorityTaskManager;
            return this;
        }

        public b J(long j10) {
            hd.a.i(!this.f57127w);
            this.f57124t = j10;
            return this;
        }

        public b K(t1 t1Var) {
            hd.a.i(!this.f57127w);
            this.f57122r = t1Var;
            return this;
        }

        public b L(boolean z10) {
            hd.a.i(!this.f57127w);
            this.f57119o = z10;
            return this;
        }

        public b M(ad.j jVar) {
            hd.a.i(!this.f57127w);
            this.f57108d = jVar;
            return this;
        }

        public b N(boolean z10) {
            hd.a.i(!this.f57127w);
            this.f57121q = z10;
            return this;
        }

        public b O(int i10) {
            hd.a.i(!this.f57127w);
            this.f57120p = i10;
            return this;
        }

        public b P(int i10) {
            hd.a.i(!this.f57127w);
            this.f57117m = i10;
            return this;
        }

        public u1 w() {
            hd.a.i(!this.f57127w);
            this.f57127w = true;
            return new u1(this);
        }

        public b x(za.f1 f1Var) {
            hd.a.i(!this.f57127w);
            this.f57112h = f1Var;
            return this;
        }

        public b y(ab.d dVar, boolean z10) {
            hd.a.i(!this.f57127w);
            this.f57115k = dVar;
            this.f57116l = z10;
            return this;
        }

        public b z(ed.d dVar) {
            hd.a.i(!this.f57127w);
            this.f57111g = dVar;
            return this;
        }

        public b(Context context, s1 s1Var) {
            this(context, s1Var, new hb.h());
        }

        public b(Context context, hb.q qVar) {
            this(context, new m(context), qVar);
        }

        public b(Context context, s1 s1Var, hb.q qVar) {
            this(context, s1Var, new DefaultTrackSelector(context), new com.google.android.exoplayer2.source.e(context, qVar), new k(), ed.n.l(context), new za.f1(hd.c.f30965a));
        }

        public b(Context context, s1 s1Var, ad.j jVar, ec.x xVar, u0 u0Var, ed.d dVar, za.f1 f1Var) {
            this.f57105a = context;
            this.f57106b = s1Var;
            this.f57108d = jVar;
            this.f57109e = xVar;
            this.f57110f = u0Var;
            this.f57111g = dVar;
            this.f57112h = f1Var;
            this.f57113i = hd.u0.X();
            this.f57115k = ab.d.f417f;
            this.f57117m = 0;
            this.f57120p = 1;
            this.f57121q = true;
            this.f57122r = t1.f57074g;
            this.f57123s = new j.b().a();
            this.f57107c = hd.c.f30965a;
            this.f57124t = 500L;
            this.f57125u = 2000L;
        }
    }

    public final class c implements id.z, com.google.android.exoplayer2.audio.a, qc.k, ub.e, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, d.c, b.InterfaceC0668b, v1.b, j1.f {
        public c() {
        }

        @Override // com.google.android.exoplayer2.audio.a
        public void A(eb.d dVar) {
            u1.this.f57095q0 = dVar;
            u1.this.Y.A(dVar);
        }

        @Override // ya.j1.f
        public void B(boolean z10) {
            u1.this.K2();
        }

        @Override // ya.d.c
        public void C(float f10) {
            u1.this.B2();
        }

        @Override // ya.j1.f
        public /* synthetic */ void D(boolean z10, int i10) {
            k1.m(this, z10, i10);
        }

        @Override // ya.d.c
        public void E(int i10) {
            boolean zD = u1.this.D();
            u1.this.J2(zD, i10, u1.s2(zD, i10));
        }

        @Override // id.z
        public void F(eb.d dVar) {
            u1.this.f57094p0 = dVar;
            u1.this.Y.F(dVar);
        }

        @Override // id.z
        public void G(Format format, @g.p0 eb.e eVar) {
            u1.this.f57084f0 = format;
            u1.this.Y.G(format, eVar);
        }

        @Override // ya.v1.b
        public void H(int i10, boolean z10) {
            Iterator it2 = u1.this.X.iterator();
            while (it2.hasNext()) {
                ((fb.c) it2.next()).a(i10, z10);
            }
        }

        @Override // qc.k
        public void I(List<qc.b> list) {
            u1.this.f57100v0 = list;
            Iterator it2 = u1.this.V.iterator();
            while (it2.hasNext()) {
                ((qc.k) it2.next()).I(list);
            }
        }

        @Override // id.z
        public /* synthetic */ void K(Format format) {
            id.p.h(this, format);
        }

        @Override // com.google.android.exoplayer2.audio.a
        public void L(long j10) {
            u1.this.Y.L(j10);
        }

        @Override // id.z
        public void O(eb.d dVar) {
            u1.this.Y.O(dVar);
            u1.this.f57084f0 = null;
            u1.this.f57094p0 = null;
        }

        @Override // com.google.android.exoplayer2.audio.a
        public /* synthetic */ void P(Format format) {
            ab.i.e(this, format);
        }

        @Override // com.google.android.exoplayer2.audio.a
        public void Q(Format format, @g.p0 eb.e eVar) {
            u1.this.f57085g0 = format;
            u1.this.Y.Q(format, eVar);
        }

        @Override // ya.j1.f
        public void R(boolean z10, int i10) {
            u1.this.K2();
        }

        @Override // ya.j1.f
        public /* synthetic */ void S(x1 x1Var, int i10) {
            k1.s(this, x1Var, i10);
        }

        @Override // ya.j1.f
        public /* synthetic */ void V(boolean z10) {
            k1.b(this, z10);
        }

        @Override // com.google.android.exoplayer2.audio.a
        public void W(int i10, long j10, long j11) {
            u1.this.Y.W(i10, j10, j11);
        }

        @Override // id.z
        public void X(long j10, int i10) {
            u1.this.Y.X(j10, i10);
        }

        @Override // com.google.android.exoplayer2.audio.a
        public void Y(eb.d dVar) {
            u1.this.Y.Y(dVar);
            u1.this.f57085g0 = null;
            u1.this.f57095q0 = null;
        }

        @Override // ya.j1.f
        public /* synthetic */ void Z(v0 v0Var, int i10) {
            k1.g(this, v0Var, i10);
        }

        @Override // com.google.android.exoplayer2.audio.a
        public void a(boolean z10) {
            if (u1.this.f57099u0 == z10) {
                return;
            }
            u1.this.f57099u0 = z10;
            u1.this.x2();
        }

        @Override // ya.j1.f
        public /* synthetic */ void b(h1 h1Var) {
            k1.i(this, h1Var);
        }

        @Override // ya.j1.f
        public /* synthetic */ void b0(boolean z10) {
            k1.e(this, z10);
        }

        @Override // id.z
        public void c(int i10, int i11, int i12, float f10) {
            u1.this.Y.c(i10, i11, i12, f10);
            Iterator it2 = u1.this.T.iterator();
            while (it2.hasNext()) {
                ((id.o) it2.next()).c(i10, i11, i12, f10);
            }
        }

        @Override // com.google.android.exoplayer2.audio.a
        public void d(Exception exc) {
            u1.this.Y.d(exc);
        }

        @Override // ya.j1.f
        public /* synthetic */ void e(int i10) {
            k1.k(this, i10);
        }

        @Override // ya.j1.f
        public /* synthetic */ void f(x1 x1Var, Object obj, int i10) {
            k1.t(this, x1Var, obj, i10);
        }

        @Override // ya.j1.f
        public /* synthetic */ void g(boolean z10) {
            k1.f(this, z10);
        }

        @Override // ya.j1.f
        public /* synthetic */ void h(TrackGroupArray trackGroupArray, ad.i iVar) {
            k1.u(this, trackGroupArray, iVar);
        }

        @Override // ya.j1.f
        public /* synthetic */ void i(int i10) {
            k1.n(this, i10);
        }

        @Override // id.z
        public void j(String str) {
            u1.this.Y.j(str);
        }

        @Override // ya.j1.f
        public /* synthetic */ void k(List list) {
            k1.r(this, list);
        }

        @Override // id.z
        public void l(String str, long j10, long j11) {
            u1.this.Y.l(str, j10, j11);
        }

        @Override // ya.j1.f
        public /* synthetic */ void m(ExoPlaybackException exoPlaybackException) {
            k1.l(this, exoPlaybackException);
        }

        @Override // ya.j1.f
        public void n(boolean z10) {
            if (u1.this.A0 != null) {
                if (z10 && !u1.this.B0) {
                    u1.this.A0.a(0);
                    u1.this.B0 = true;
                } else {
                    if (z10 || !u1.this.B0) {
                        return;
                    }
                    u1.this.A0.e(0);
                    u1.this.B0 = false;
                }
            }
        }

        @Override // ya.j1.f
        public /* synthetic */ void o() {
            k1.p(this);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
            u1.this.H2(new Surface(surfaceTexture), true);
            u1.this.w2(i10, i11);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            u1.this.H2(null, true);
            u1.this.w2(0, 0);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
            u1.this.w2(i10, i11);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // ya.j1.f
        public /* synthetic */ void p(j1 j1Var, j1.g gVar) {
            k1.a(this, j1Var, gVar);
        }

        @Override // ya.v1.b
        public void q(int i10) {
            fb.a aVarO2 = u1.o2(u1.this.f57080b0);
            if (aVarO2.equals(u1.this.D0)) {
                return;
            }
            u1.this.D0 = aVarO2;
            Iterator it2 = u1.this.X.iterator();
            while (it2.hasNext()) {
                ((fb.c) it2.next()).b(aVarO2);
            }
        }

        @Override // ya.j1.f
        public void r(int i10) {
            u1.this.K2();
        }

        @Override // id.z
        public void s(Surface surface) {
            u1.this.Y.s(surface);
            if (u1.this.f57087i0 == surface) {
                Iterator it2 = u1.this.T.iterator();
                while (it2.hasNext()) {
                    ((id.o) it2.next()).d();
                }
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
            u1.this.w2(i11, i12);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            u1.this.H2(surfaceHolder.getSurface(), false);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            u1.this.H2(null, false);
            u1.this.w2(0, 0);
        }

        @Override // ub.e
        public void t(Metadata metadata) {
            u1.this.Y.v2(metadata);
            Iterator it2 = u1.this.W.iterator();
            while (it2.hasNext()) {
                ((ub.e) it2.next()).t(metadata);
            }
        }

        @Override // ya.b.InterfaceC0668b
        public void u() {
            u1.this.J2(false, -1, 3);
        }

        @Override // ya.j1.f
        public /* synthetic */ void v(int i10) {
            k1.o(this, i10);
        }

        @Override // com.google.android.exoplayer2.audio.a
        public void w(String str) {
            u1.this.Y.w(str);
        }

        @Override // com.google.android.exoplayer2.audio.a
        public void x(String str, long j10, long j11) {
            u1.this.Y.x(str, j10, j11);
        }

        @Override // ya.j1.f
        public /* synthetic */ void y(boolean z10) {
            k1.q(this, z10);
        }

        @Override // id.z
        public void z(int i10, long j10) {
            u1.this.Y.z(i10, j10);
        }
    }

    @Deprecated
    public u1(Context context, s1 s1Var, ad.j jVar, ec.x xVar, u0 u0Var, ed.d dVar, za.f1 f1Var, boolean z10, hd.c cVar, Looper looper) {
        this(new b(context, s1Var).M(jVar).G(xVar).E(u0Var).z(dVar).x(f1Var).N(z10).A(cVar).F(looper));
    }

    public static fb.a o2(v1 v1Var) {
        return new fb.a(0, v1Var.e(), v1Var.d());
    }

    public static int s2(boolean z10, int i10) {
        return (!z10 || i10 == 1) ? 1 : 2;
    }

    @Override // ya.j1
    public long A() {
        L2();
        return this.R.A();
    }

    @Override // ya.j1.i
    public void A0(ub.e eVar) {
        hd.a.g(eVar);
        this.W.add(eVar);
    }

    @Override // ya.j1
    public ad.i A1() {
        L2();
        return this.R.A1();
    }

    public final void A2(int i10, int i11, @g.p0 Object obj) {
        for (o1 o1Var : this.P) {
            if (o1Var.h() == i10) {
                this.R.s1(o1Var).u(i11).r(obj).n();
            }
        }
    }

    @Override // ya.j1
    public void B(int i10, long j10) {
        L2();
        this.Y.s2();
        this.R.B(i10, j10);
    }

    @Override // ya.j1.p
    public void B0(id.o oVar) {
        this.T.remove(oVar);
    }

    @Override // ya.j1.c
    public void B1(fb.c cVar) {
        this.X.remove(cVar);
    }

    public final void B2() {
        A2(1, 2, Float.valueOf(this.f57098t0 * this.f57079a0.h()));
    }

    @Override // ya.j1.p
    public void C(id.l lVar) {
        L2();
        if (this.f57101w0 != lVar) {
            return;
        }
        A2(2, 6, null);
    }

    @Override // ya.j1
    public long C0() {
        L2();
        return this.R.C0();
    }

    @Override // ya.n
    public void C1(com.google.android.exoplayer2.source.l lVar, boolean z10) {
        L2();
        this.Y.A2();
        this.R.C1(lVar, z10);
    }

    public void C2(boolean z10) {
        L2();
        if (this.C0) {
            return;
        }
        this.Z.b(z10);
    }

    @Override // ya.j1
    public boolean D() {
        L2();
        return this.R.D();
    }

    @Override // ya.e, ya.j1
    public void D0(v0 v0Var) {
        L2();
        this.Y.A2();
        this.R.D0(v0Var);
    }

    @Override // ya.e, ya.j1
    public void D1(v0 v0Var, long j10) {
        L2();
        this.Y.A2();
        this.R.D1(v0Var, j10);
    }

    @Deprecated
    public void D2(boolean z10) {
        I2(z10 ? 1 : 0);
    }

    @Override // ya.j1
    public void E() {
        L2();
        this.R.E();
    }

    @Override // ya.j1
    public void E0(int i10, List<v0> list) {
        L2();
        this.R.E0(i10, list);
    }

    @Override // ya.j1
    public int E1(int i10) {
        L2();
        return this.R.E1(i10);
    }

    public void E2(@g.p0 PriorityTaskManager priorityTaskManager) {
        L2();
        if (hd.u0.c(this.A0, priorityTaskManager)) {
            return;
        }
        if (this.B0) {
            ((PriorityTaskManager) hd.a.g(this.A0)).e(0);
        }
        if (priorityTaskManager == null || !isLoading()) {
            this.B0 = false;
        } else {
            priorityTaskManager.a(0);
            this.B0 = true;
        }
        this.A0 = priorityTaskManager;
    }

    @Override // ya.j1.p
    public void F(@g.p0 Surface surface) {
        L2();
        if (surface == null || surface != this.f57087i0) {
            return;
        }
        q0();
    }

    @Override // ya.e, ya.j1
    public void F1(List<v0> list) {
        L2();
        this.Y.A2();
        this.R.F1(list);
    }

    public void F2(boolean z10) {
        this.f57103y0 = z10;
    }

    @Override // ya.e, ya.j1
    public void G0(v0 v0Var) {
        L2();
        this.R.G0(v0Var);
    }

    @Override // ya.j1.p
    public void G1(@g.p0 SurfaceHolder surfaceHolder) {
        L2();
        if (surfaceHolder == null || surfaceHolder != this.f57090l0) {
            return;
        }
        t0(null);
    }

    public final void G2(@g.p0 id.k kVar) {
        A2(2, 8, kVar);
    }

    @Override // ya.j1
    public void H(boolean z10) {
        L2();
        this.R.H(z10);
    }

    @Override // ya.j1
    public long H1() {
        L2();
        return this.R.H1();
    }

    public final void H2(@g.p0 Surface surface, boolean z10) {
        ArrayList arrayList = new ArrayList();
        for (o1 o1Var : this.P) {
            if (o1Var.h() == 2) {
                arrayList.add(this.R.s1(o1Var).u(1).r(surface).n());
            }
        }
        Surface surface2 = this.f57087i0;
        if (surface2 != null && surface2 != surface) {
            try {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((l1) it2.next()).b(this.f57083e0);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                this.R.S2(false, ExoPlaybackException.c(new ExoTimeoutException(3)));
            }
            if (this.f57088j0) {
                this.f57087i0.release();
            }
        }
        this.f57087i0 = surface;
        this.f57088j0 = z10;
    }

    @Override // ya.j1.n
    public void I(qc.k kVar) {
        hd.a.g(kVar);
        this.V.add(kVar);
    }

    @Override // ya.j1
    public long I0() {
        L2();
        return this.R.I0();
    }

    @Override // ya.j1.a
    public void I1() {
        l(new ab.u(0, 0.0f));
    }

    public void I2(int i10) {
        L2();
        if (i10 == 0) {
            this.f57081c0.a(false);
            this.f57082d0.a(false);
        } else if (i10 == 1) {
            this.f57081c0.a(true);
            this.f57082d0.a(false);
        } else {
            if (i10 != 2) {
                return;
            }
            this.f57081c0.a(true);
            this.f57082d0.a(true);
        }
    }

    @Override // ya.j1
    public void J(boolean z10) {
        L2();
        this.f57079a0.q(D(), 1);
        this.R.J(z10);
        this.f57100v0 = Collections.emptyList();
    }

    @Override // ya.j1.c
    public void J0(fb.c cVar) {
        hd.a.g(cVar);
        this.X.add(cVar);
    }

    @Override // ya.e, ya.j1
    public void J1(int i10, v0 v0Var) {
        L2();
        this.R.J1(i10, v0Var);
    }

    public final void J2(boolean z10, int i10, int i11) {
        int i12 = 0;
        boolean z11 = z10 && i10 != -1;
        if (z11 && i10 != 1) {
            i12 = 1;
        }
        this.R.R2(z11, i12, i11);
    }

    @Override // ya.n
    public hd.c K() {
        return this.R.K();
    }

    @Override // ya.j1
    public void K0(j1.f fVar) {
        this.R.K0(fVar);
    }

    @Override // ya.j1
    @g.p0
    public j1.n K1() {
        return this;
    }

    public final void K2() {
        int iD = d();
        if (iD != 1) {
            if (iD == 2 || iD == 3) {
                this.f57081c0.b(D() && !U0());
                this.f57082d0.b(D());
                return;
            } else if (iD != 4) {
                throw new IllegalStateException();
            }
        }
        this.f57081c0.b(false);
        this.f57082d0.b(false);
    }

    @Override // ya.n
    @g.p0
    public ad.j L() {
        L2();
        return this.R.L();
    }

    @Override // ya.n
    public void L0(List<com.google.android.exoplayer2.source.l> list, boolean z10) {
        L2();
        this.Y.A2();
        this.R.L0(list, z10);
    }

    public final void L2() {
        if (Looper.myLooper() != p1()) {
            if (this.f57103y0) {
                throw new IllegalStateException(G0);
            }
            hd.t.o(F0, G0, this.f57104z0 ? null : new IllegalStateException());
            this.f57104z0 = true;
        }
    }

    @Override // ya.n
    public void M(com.google.android.exoplayer2.source.l lVar) {
        L2();
        this.R.M(lVar);
    }

    @Override // ya.n
    public void M0(boolean z10) {
        L2();
        this.R.M0(z10);
    }

    @Override // ya.j1
    public int O() {
        L2();
        return this.R.O();
    }

    @Override // ya.n
    public Looper O0() {
        return this.R.O0();
    }

    @Override // ya.j1
    public List<Metadata> P() {
        L2();
        return this.R.P();
    }

    @Override // ya.j1.p
    public void P0(id.o oVar) {
        hd.a.g(oVar);
        this.T.add(oVar);
    }

    @Override // ya.j1.n
    public List<qc.b> Q0() {
        L2();
        return this.f57100v0;
    }

    @Override // ya.n
    public void R(int i10, List<com.google.android.exoplayer2.source.l> list) {
        L2();
        this.R.R(i10, list);
    }

    @Override // ya.n
    public void R0(com.google.android.exoplayer2.source.t tVar) {
        L2();
        this.R.R0(tVar);
    }

    @Override // ya.j1
    @g.p0
    @Deprecated
    public ExoPlaybackException S() {
        return w0();
    }

    @Override // ya.j1.p
    public void S0(jd.a aVar) {
        L2();
        this.f57102x0 = aVar;
        A2(6, 7, aVar);
    }

    @Override // ya.j1
    public int T0() {
        L2();
        return this.R.T0();
    }

    @Override // ya.j1
    public int U() {
        L2();
        return this.R.U();
    }

    @Override // ya.n
    public boolean U0() {
        L2();
        return this.R.U0();
    }

    @Override // ya.j1.p
    public void V0(jd.a aVar) {
        L2();
        if (this.f57102x0 != aVar) {
            return;
        }
        A2(6, 7, null);
    }

    @Override // ya.j1.p
    public void W(@g.p0 TextureView textureView) {
        L2();
        if (textureView == null || textureView != this.f57091m0) {
            return;
        }
        x1(null);
    }

    @Override // ya.n
    @Deprecated
    public void W0(com.google.android.exoplayer2.source.l lVar) {
        t(lVar, true, true);
    }

    @Override // ya.n
    public void X(com.google.android.exoplayer2.source.l lVar) {
        L2();
        this.Y.A2();
        this.R.X(lVar);
    }

    @Override // ya.j1.a
    public float Y() {
        return this.f57098t0;
    }

    @Override // ya.e, ya.j1
    public void Y0(v0 v0Var, boolean z10) {
        L2();
        this.Y.A2();
        this.R.Y0(v0Var, z10);
    }

    @Override // ya.n
    public void Z0(boolean z10) {
        L2();
        this.R.Z0(z10);
    }

    @Override // ya.j1.p
    public void a(int i10) {
        L2();
        this.f57089k0 = i10;
        A2(2, 4, Integer.valueOf(i10));
    }

    @Override // ya.j1.a
    public void a0(ab.h hVar) {
        hd.a.g(hVar);
        this.U.add(hVar);
    }

    @Override // ya.j1.c
    public void a1(boolean z10) {
        L2();
        this.f57080b0.l(z10);
    }

    @Override // ya.j1.a
    public ab.d b() {
        return this.f57097s0;
    }

    @Override // ya.j1
    public void b0(List<v0> list, boolean z10) {
        L2();
        this.Y.A2();
        this.R.b0(list, z10);
    }

    @Override // ya.n
    public void b1(List<com.google.android.exoplayer2.source.l> list, int i10, long j10) {
        L2();
        this.Y.A2();
        this.R.b1(list, i10, j10);
    }

    @Override // ya.j1
    public void c(@g.p0 h1 h1Var) {
        L2();
        this.R.c(h1Var);
    }

    @Override // ya.j1.c
    public fb.a c0() {
        L2();
        return this.D0;
    }

    @Override // ya.n
    public t1 c1() {
        L2();
        return this.R.c1();
    }

    @Override // ya.j1
    public int d() {
        L2();
        return this.R.d();
    }

    @Override // ya.j1.c
    public void d0() {
        L2();
        this.f57080b0.c();
    }

    @Override // ya.j1.p
    public void d1(id.l lVar) {
        L2();
        this.f57101w0 = lVar;
        A2(2, 6, lVar);
    }

    @Override // ya.j1
    public h1 e() {
        L2();
        return this.R.e();
    }

    @Override // ya.n
    public void e0(boolean z10) {
        L2();
        this.R.e0(z10);
    }

    @Override // ya.j1.p
    public void e1(@g.p0 SurfaceView surfaceView) {
        L2();
        if (!(surfaceView instanceof id.h)) {
            G1(surfaceView != null ? surfaceView.getHolder() : null);
        } else if (surfaceView.getHolder() == this.f57090l0) {
            G2(null);
            this.f57090l0 = null;
        }
    }

    @Override // ya.j1
    public void f() {
        L2();
        boolean zD = D();
        int iQ = this.f57079a0.q(zD, 2);
        J2(zD, iQ, s2(zD, iQ));
        this.R.f();
    }

    @Override // ya.j1
    public int f0() {
        L2();
        return this.R.f0();
    }

    @Override // ya.e, ya.j1
    public void f1(int i10, int i11) {
        L2();
        this.R.f1(i10, i11);
    }

    @Override // ya.j1.p
    public void g0(@g.p0 SurfaceView surfaceView) {
        L2();
        if (!(surfaceView instanceof id.h)) {
            t0(surfaceView == null ? null : surfaceView.getHolder());
            return;
        }
        id.k videoDecoderOutputBufferRenderer = ((id.h) surfaceView).getVideoDecoderOutputBufferRenderer();
        q0();
        this.f57090l0 = surfaceView.getHolder();
        G2(videoDecoderOutputBufferRenderer);
    }

    @Override // ya.j1.a
    public void h(int i10) {
        L2();
        if (this.f57096r0 == i10) {
            return;
        }
        if (i10 == 0) {
            i10 = hd.u0.f31154a < 21 ? v2(0) : g.a(this.Q);
        } else if (hd.u0.f31154a < 21) {
            v2(i10);
        }
        this.f57096r0 = i10;
        A2(1, 102, Integer.valueOf(i10));
        A2(2, 102, Integer.valueOf(i10));
        this.Y.u2(i10);
        Iterator<ab.h> it2 = this.U.iterator();
        while (it2.hasNext()) {
            it2.next().c(i10);
        }
    }

    @Override // ya.n
    public void h0(List<com.google.android.exoplayer2.source.l> list) {
        L2();
        this.R.h0(list);
    }

    @Override // ya.j1
    public void h1(int i10, int i11, int i12) {
        L2();
        this.R.h1(i10, i11, i12);
    }

    @Override // ya.n
    public void i0(int i10, com.google.android.exoplayer2.source.l lVar) {
        L2();
        this.R.i0(i10, lVar);
    }

    @Override // ya.j1
    @g.p0
    public j1.i i1() {
        return this;
    }

    @Override // ya.j1
    public boolean isLoading() {
        L2();
        return this.R.isLoading();
    }

    @Override // ya.j1
    public void j(int i10) {
        L2();
        this.R.j(i10);
    }

    @Override // ya.j1
    public int j1() {
        L2();
        return this.R.j1();
    }

    @Override // ya.j1
    public int k() {
        L2();
        return this.R.k();
    }

    @Override // ya.j1
    public void k1(List<v0> list) {
        L2();
        this.R.k1(list);
    }

    @Override // ya.j1.a
    public void l(ab.u uVar) {
        L2();
        A2(1, 5, uVar);
    }

    @Override // ya.j1
    @g.p0
    public j1.c l0() {
        return this;
    }

    @Override // ya.j1
    public TrackGroupArray l1() {
        L2();
        return this.R.l1();
    }

    @Override // ya.j1.a
    public void m(float f10) {
        L2();
        float fS = hd.u0.s(f10, 0.0f, 1.0f);
        if (this.f57098t0 == fS) {
            return;
        }
        this.f57098t0 = fS;
        B2();
        this.Y.x2(fS);
        Iterator<ab.h> it2 = this.U.iterator();
        while (it2.hasNext()) {
            it2.next().b(fS);
        }
    }

    @Override // ya.e, ya.j1
    public void m0(int i10) {
        L2();
        this.R.m0(i10);
    }

    @Override // ya.j1
    public long m1() {
        L2();
        return this.R.m1();
    }

    @Override // ya.j1.a
    public boolean n() {
        return this.f57099u0;
    }

    @Override // ya.j1
    public x1 n1() {
        L2();
        return this.R.n1();
    }

    public void n2(za.h1 h1Var) {
        hd.a.g(h1Var);
        this.Y.g1(h1Var);
    }

    @Override // ya.j1.a
    public void o(boolean z10) {
        L2();
        if (this.f57099u0 == z10) {
            return;
        }
        this.f57099u0 = z10;
        A2(1, 101, Boolean.valueOf(z10));
        x2();
    }

    @Override // ya.n
    public void o0(List<com.google.android.exoplayer2.source.l> list) {
        L2();
        this.Y.A2();
        this.R.o0(list);
    }

    @Override // ya.j1.c
    public boolean o1() {
        L2();
        return this.f57080b0.j();
    }

    @Override // ya.j1.c
    public int p() {
        L2();
        return this.f57080b0.g();
    }

    @Override // ya.j1
    public void p0(int i10, int i11) {
        L2();
        this.R.p0(i10, i11);
    }

    @Override // ya.j1
    public Looper p1() {
        return this.R.p1();
    }

    public za.f1 p2() {
        return this.Y;
    }

    @Override // ya.j1.p
    public void q(@g.p0 Surface surface) {
        L2();
        z2();
        if (surface != null) {
            G2(null);
        }
        H2(surface, false);
        int i10 = surface != null ? -1 : 0;
        w2(i10, i10);
    }

    @Override // ya.j1.p
    public void q0() {
        L2();
        z2();
        H2(null, false);
        w2(0, 0);
    }

    @Override // ya.j1.a
    public int q1() {
        return this.f57096r0;
    }

    @g.p0
    public eb.d q2() {
        return this.f57095q0;
    }

    @Override // ya.j1
    public boolean r() {
        L2();
        return this.R.r();
    }

    @Override // ya.j1
    public int r0() {
        L2();
        return this.R.r0();
    }

    @Override // ya.j1.p
    public int r1() {
        return this.f57089k0;
    }

    @g.p0
    public Format r2() {
        return this.f57085g0;
    }

    @Override // ya.j1
    public void release() {
        AudioTrack audioTrack;
        L2();
        if (hd.u0.f31154a < 21 && (audioTrack = this.f57086h0) != null) {
            audioTrack.release();
            this.f57086h0 = null;
        }
        this.Z.b(false);
        this.f57080b0.k();
        this.f57081c0.b(false);
        this.f57082d0.b(false);
        this.f57079a0.j();
        this.R.release();
        this.Y.y2();
        z2();
        Surface surface = this.f57087i0;
        if (surface != null) {
            if (this.f57088j0) {
                surface.release();
            }
            this.f57087i0 = null;
        }
        if (this.B0) {
            ((PriorityTaskManager) hd.a.g(this.A0)).e(0);
            this.B0 = false;
        }
        this.f57100v0 = Collections.emptyList();
        this.C0 = true;
    }

    @Override // ya.n
    public void s(com.google.android.exoplayer2.source.l lVar, long j10) {
        L2();
        this.Y.A2();
        this.R.s(lVar, j10);
    }

    @Override // ya.j1
    @g.p0
    public j1.a s0() {
        return this;
    }

    @Override // ya.n
    public l1 s1(l1.b bVar) {
        L2();
        return this.R.s1(bVar);
    }

    @Override // ya.n
    @Deprecated
    public void t(com.google.android.exoplayer2.source.l lVar, boolean z10, boolean z11) {
        L2();
        b1(Collections.singletonList(lVar), z10 ? 0 : -1, g.f56663b);
        f();
    }

    @Override // ya.j1.p
    public void t0(@g.p0 SurfaceHolder surfaceHolder) {
        L2();
        z2();
        if (surfaceHolder != null) {
            G2(null);
        }
        this.f57090l0 = surfaceHolder;
        if (surfaceHolder == null) {
            H2(null, false);
            w2(0, 0);
            return;
        }
        surfaceHolder.addCallback(this.S);
        Surface surface = surfaceHolder.getSurface();
        if (surface == null || !surface.isValid()) {
            H2(null, false);
            w2(0, 0);
        } else {
            H2(surface, false);
            Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
            w2(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    @Override // ya.j1.c
    public void t1() {
        L2();
        this.f57080b0.i();
    }

    @g.p0
    public eb.d t2() {
        return this.f57094p0;
    }

    @Override // ya.j1.a
    public void u(ab.h hVar) {
        this.U.remove(hVar);
    }

    @Override // ya.j1.i
    public void u0(ub.e eVar) {
        this.W.remove(eVar);
    }

    @Override // ya.j1
    public boolean u1() {
        L2();
        return this.R.u1();
    }

    @g.p0
    public Format u2() {
        return this.f57084f0;
    }

    @Override // ya.n
    @Deprecated
    public void v() {
        L2();
        f();
    }

    @Override // ya.j1
    public void v0(List<v0> list, int i10, long j10) {
        L2();
        this.Y.A2();
        this.R.v0(list, i10, j10);
    }

    @Override // ya.j1
    public long v1() {
        L2();
        return this.R.v1();
    }

    public final int v2(int i10) {
        AudioTrack audioTrack = this.f57086h0;
        if (audioTrack != null && audioTrack.getAudioSessionId() != i10) {
            this.f57086h0.release();
            this.f57086h0 = null;
        }
        if (this.f57086h0 == null) {
            this.f57086h0 = new AudioTrack(3, 4000, 4, 2, 2, 0, i10);
        }
        return this.f57086h0.getAudioSessionId();
    }

    @Override // ya.n
    public boolean w() {
        L2();
        return this.R.w();
    }

    @Override // ya.j1
    @g.p0
    public ExoPlaybackException w0() {
        L2();
        return this.R.w0();
    }

    @Override // ya.j1.c
    public void w1(int i10) {
        L2();
        this.f57080b0.n(i10);
    }

    public final void w2(int i10, int i11) {
        if (i10 == this.f57092n0 && i11 == this.f57093o0) {
            return;
        }
        this.f57092n0 = i10;
        this.f57093o0 = i11;
        this.Y.w2(i10, i11);
        Iterator<id.o> it2 = this.T.iterator();
        while (it2.hasNext()) {
            it2.next().j(i10, i11);
        }
    }

    @Override // ya.j1
    public void x0(boolean z10) {
        L2();
        int iQ = this.f57079a0.q(z10, d());
        J2(z10, iQ, s2(z10, iQ));
    }

    @Override // ya.j1.p
    public void x1(@g.p0 TextureView textureView) {
        L2();
        z2();
        if (textureView != null) {
            G2(null);
        }
        this.f57091m0 = textureView;
        if (textureView == null) {
            H2(null, true);
            w2(0, 0);
            return;
        }
        if (textureView.getSurfaceTextureListener() != null) {
            hd.t.n(F0, "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.S);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            H2(null, true);
            w2(0, 0);
        } else {
            H2(new Surface(surfaceTexture), true);
            w2(textureView.getWidth(), textureView.getHeight());
        }
    }

    public final void x2() {
        this.Y.a(this.f57099u0);
        Iterator<ab.h> it2 = this.U.iterator();
        while (it2.hasNext()) {
            it2.next().a(this.f57099u0);
        }
    }

    @Override // ya.j1
    public void y(j1.f fVar) {
        hd.a.g(fVar);
        this.R.y(fVar);
    }

    @Override // ya.j1
    @g.p0
    public j1.p y0() {
        return this;
    }

    @Override // ya.j1.a
    public void y1(ab.d dVar, boolean z10) {
        L2();
        if (this.C0) {
            return;
        }
        if (!hd.u0.c(this.f57097s0, dVar)) {
            this.f57097s0 = dVar;
            A2(1, 3, dVar);
            this.f57080b0.m(hd.u0.o0(dVar.f420c));
            this.Y.t2(dVar);
            Iterator<ab.h> it2 = this.U.iterator();
            while (it2.hasNext()) {
                it2.next().d(dVar);
            }
        }
        d dVar2 = this.f57079a0;
        if (!z10) {
            dVar = null;
        }
        dVar2.n(dVar);
        boolean zD = D();
        int iQ = this.f57079a0.q(zD, d());
        J2(zD, iQ, s2(zD, iQ));
    }

    public void y2(za.h1 h1Var) {
        this.Y.z2(h1Var);
    }

    @Override // ya.j1.n
    public void z(qc.k kVar) {
        this.V.remove(kVar);
    }

    @Override // ya.n
    public void z1(@g.p0 t1 t1Var) {
        L2();
        this.R.z1(t1Var);
    }

    public final void z2() {
        TextureView textureView = this.f57091m0;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.S) {
                hd.t.n(F0, "SurfaceTextureListener already unset or replaced.");
            } else {
                this.f57091m0.setSurfaceTextureListener(null);
            }
            this.f57091m0 = null;
        }
        SurfaceHolder surfaceHolder = this.f57090l0;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.S);
            this.f57090l0 = null;
        }
    }

    public u1(b bVar) {
        Context applicationContext = bVar.f57105a.getApplicationContext();
        this.Q = applicationContext;
        za.f1 f1Var = bVar.f57112h;
        this.Y = f1Var;
        this.A0 = bVar.f57114j;
        this.f57097s0 = bVar.f57115k;
        this.f57089k0 = bVar.f57120p;
        this.f57099u0 = bVar.f57119o;
        this.f57083e0 = bVar.f57125u;
        c cVar = new c();
        this.S = cVar;
        this.T = new CopyOnWriteArraySet<>();
        this.U = new CopyOnWriteArraySet<>();
        this.V = new CopyOnWriteArraySet<>();
        this.W = new CopyOnWriteArraySet<>();
        this.X = new CopyOnWriteArraySet<>();
        Handler handler = new Handler(bVar.f57113i);
        o1[] o1VarArrA = bVar.f57106b.a(handler, cVar, cVar, cVar, cVar);
        this.P = o1VarArrA;
        this.f57098t0 = 1.0f;
        if (hd.u0.f31154a < 21) {
            this.f57096r0 = v2(0);
        } else {
            this.f57096r0 = g.a(applicationContext);
        }
        this.f57100v0 = Collections.emptyList();
        this.f57103y0 = true;
        m0 m0Var = new m0(o1VarArrA, bVar.f57108d, bVar.f57109e, bVar.f57110f, bVar.f57111g, f1Var, bVar.f57121q, bVar.f57122r, bVar.f57123s, bVar.f57124t, bVar.f57126v, bVar.f57107c, bVar.f57113i, this);
        this.R = m0Var;
        m0Var.y(cVar);
        ya.b bVar2 = new ya.b(bVar.f57105a, handler, cVar);
        this.Z = bVar2;
        bVar2.b(bVar.f57118n);
        d dVar = new d(bVar.f57105a, handler, cVar);
        this.f57079a0 = dVar;
        dVar.n(bVar.f57116l ? this.f57097s0 : null);
        v1 v1Var = new v1(bVar.f57105a, handler, cVar);
        this.f57080b0 = v1Var;
        v1Var.m(hd.u0.o0(this.f57097s0.f420c));
        y1 y1Var = new y1(bVar.f57105a);
        this.f57081c0 = y1Var;
        y1Var.a(bVar.f57117m != 0);
        z1 z1Var = new z1(bVar.f57105a);
        this.f57082d0 = z1Var;
        z1Var.a(bVar.f57117m == 2);
        this.D0 = o2(v1Var);
        A2(1, 102, Integer.valueOf(this.f57096r0));
        A2(2, 102, Integer.valueOf(this.f57096r0));
        A2(1, 3, this.f57097s0);
        A2(2, 4, Integer.valueOf(this.f57089k0));
        A2(1, 101, Boolean.valueOf(this.f57099u0));
    }
}
