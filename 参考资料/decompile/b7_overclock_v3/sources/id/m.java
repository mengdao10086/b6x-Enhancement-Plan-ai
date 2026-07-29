package id;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import com.google.android.exoplayer2.video.DummySurface;
import g.p0;
import g.v0;
import hd.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f32245r = "VideoFrameReleaseHelper";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final long f32246s = 5000000000L;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final float f32247t = 0.02f;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final float f32248u = 1.0f;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f32249v = 30;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final long f32250w = 500;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final long f32251x = 20000000;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final long f32252y = 80;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f32253a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final WindowManager f32254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public final b f32255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public final a f32256d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f32257e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public Surface f32258f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f32259g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f32260h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f32261i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f32262j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f32263k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f32264l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f32265m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f32266n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f32267o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f32268p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f32269q;

    @v0(17)
    public final class a implements DisplayManager.DisplayListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DisplayManager f32270a;

        public a(DisplayManager displayManager) {
            this.f32270a = displayManager;
        }

        public void a() {
            this.f32270a.registerDisplayListener(this, u0.z());
        }

        public void b() {
            this.f32270a.unregisterDisplayListener(this);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i10) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i10) {
            if (i10 == 0) {
                m.this.r();
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i10) {
        }
    }

    public static final class b implements Choreographer.FrameCallback, Handler.Callback {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f32272f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f32273g = 1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f32274h = 2;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f32275i = new b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile long f32276a = ya.g.f56663b;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Handler f32277b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final HandlerThread f32278c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Choreographer f32279d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f32280e;

        public b() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.f32278c = handlerThread;
            handlerThread.start();
            Handler handlerY = u0.y(handlerThread.getLooper(), this);
            this.f32277b = handlerY;
            handlerY.sendEmptyMessage(0);
        }

        public static b d() {
            return f32275i;
        }

        public void a() {
            this.f32277b.sendEmptyMessage(1);
        }

        public final void b() {
            int i10 = this.f32280e + 1;
            this.f32280e = i10;
            if (i10 == 1) {
                ((Choreographer) hd.a.g(this.f32279d)).postFrameCallback(this);
            }
        }

        public final void c() {
            this.f32279d = Choreographer.getInstance();
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j10) {
            this.f32276a = j10;
            ((Choreographer) hd.a.g(this.f32279d)).postFrameCallbackDelayed(this, 500L);
        }

        public void e() {
            this.f32277b.sendEmptyMessage(2);
        }

        public final void f() {
            int i10 = this.f32280e - 1;
            this.f32280e = i10;
            if (i10 == 0) {
                ((Choreographer) hd.a.g(this.f32279d)).removeFrameCallback(this);
                this.f32276a = ya.g.f56663b;
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                c();
                return true;
            }
            if (i10 == 1) {
                b();
                return true;
            }
            if (i10 != 2) {
                return false;
            }
            f();
            return true;
        }
    }

    public m(@p0 Context context) {
        if (context != null) {
            context = context.getApplicationContext();
            this.f32254b = (WindowManager) context.getSystemService("window");
        } else {
            this.f32254b = null;
        }
        if (this.f32254b != null) {
            this.f32256d = u0.f31154a >= 17 ? f((Context) hd.a.g(context)) : null;
            this.f32255c = b.d();
        } else {
            this.f32256d = null;
            this.f32255c = null;
        }
        this.f32263k = ya.g.f56663b;
        this.f32264l = ya.g.f56663b;
        this.f32259g = -1.0f;
        this.f32262j = 1.0f;
    }

    public static boolean c(long j10, long j11) {
        return Math.abs(j10 - j11) <= 20000000;
    }

    public static long e(long j10, long j11, long j12) {
        long j13;
        long j14 = j11 + (((j10 - j11) / j12) * j12);
        if (j10 <= j14) {
            j13 = j14 - j12;
        } else {
            j14 = j12 + j14;
            j13 = j14;
        }
        return j14 - j10 < j10 - j13 ? j14 : j13;
    }

    @v0(30)
    public static void q(Surface surface, float f10) {
        try {
            surface.setFrameRate(f10, f10 == 0.0f ? 0 : 1);
        } catch (IllegalStateException e10) {
            hd.t.e(f32245r, "Failed to call Surface.setFrameRate", e10);
        }
    }

    public long b(long j10) {
        long j11;
        if (this.f32268p == -1 || !this.f32253a.e()) {
            j11 = j10;
        } else {
            long jA = this.f32269q + ((long) ((this.f32253a.a() * (this.f32265m - this.f32268p)) / this.f32262j));
            if (c(j10, jA)) {
                j11 = jA;
            } else {
                p();
                j11 = j10;
            }
        }
        this.f32266n = this.f32265m;
        this.f32267o = j11;
        b bVar = this.f32255c;
        if (bVar == null || this.f32263k == ya.g.f56663b) {
            return j11;
        }
        long j12 = bVar.f32276a;
        return j12 == ya.g.f56663b ? j11 : e(j11, j12, this.f32263k) - this.f32264l;
    }

    public final void d() {
        Surface surface;
        if (u0.f31154a < 30 || (surface = this.f32258f) == null || this.f32261i == 0.0f) {
            return;
        }
        this.f32261i = 0.0f;
        q(surface, 0.0f);
    }

    @p0
    @v0(17)
    public final a f(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        if (displayManager == null) {
            return null;
        }
        return new a(displayManager);
    }

    @TargetApi(17)
    public void g() {
        if (this.f32254b != null) {
            a aVar = this.f32256d;
            if (aVar != null) {
                aVar.b();
            }
            ((b) hd.a.g(this.f32255c)).e();
        }
    }

    @TargetApi(17)
    public void h() {
        if (this.f32254b != null) {
            ((b) hd.a.g(this.f32255c)).a();
            a aVar = this.f32256d;
            if (aVar != null) {
                aVar.a();
            }
            r();
        }
    }

    public void i(float f10) {
        this.f32259g = f10;
        this.f32253a.g();
        s();
    }

    public void j(long j10) {
        long j11 = this.f32266n;
        if (j11 != -1) {
            this.f32268p = j11;
            this.f32269q = this.f32267o;
        }
        this.f32265m++;
        this.f32253a.f(j10 * 1000);
        s();
    }

    public void k(float f10) {
        this.f32262j = f10;
        p();
        t(false);
    }

    public void l() {
        p();
    }

    public void m() {
        this.f32257e = true;
        p();
        t(false);
    }

    public void n() {
        this.f32257e = false;
        d();
    }

    public void o(@p0 Surface surface) {
        if (surface instanceof DummySurface) {
            surface = null;
        }
        if (this.f32258f == surface) {
            return;
        }
        d();
        this.f32258f = surface;
        t(true);
    }

    public final void p() {
        this.f32265m = 0L;
        this.f32268p = -1L;
        this.f32266n = -1L;
    }

    public final void r() {
        Display defaultDisplay = ((WindowManager) hd.a.g(this.f32254b)).getDefaultDisplay();
        if (defaultDisplay != null) {
            long refreshRate = (long) (1.0E9d / ((double) defaultDisplay.getRefreshRate()));
            this.f32263k = refreshRate;
            this.f32264l = (refreshRate * 80) / 100;
        } else {
            hd.t.n(f32245r, "Unable to query display refresh rate");
            this.f32263k = ya.g.f56663b;
            this.f32264l = ya.g.f56663b;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s() {
        /*
            r8 = this;
            int r0 = hd.u0.f31154a
            r1 = 30
            if (r0 < r1) goto L73
            android.view.Surface r0 = r8.f32258f
            if (r0 != 0) goto Lc
            goto L73
        Lc:
            id.d r0 = r8.f32253a
            boolean r0 = r0.e()
            if (r0 == 0) goto L1b
            id.d r0 = r8.f32253a
            float r0 = r0.b()
            goto L1d
        L1b:
            float r0 = r8.f32259g
        L1d:
            float r2 = r8.f32260h
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 != 0) goto L24
            return
        L24:
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            r4 = 0
            r5 = 1
            int r6 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r6 == 0) goto L61
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L61
            id.d r1 = r8.f32253a
            boolean r1 = r1.e()
            if (r1 == 0) goto L49
            id.d r1 = r8.f32253a
            long r1 = r1.d()
            r6 = 5000000000(0x12a05f200, double:2.470328229E-314)
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 < 0) goto L49
            r1 = 1
            goto L4a
        L49:
            r1 = 0
        L4a:
            if (r1 == 0) goto L50
            r1 = 1017370378(0x3ca3d70a, float:0.02)
            goto L52
        L50:
            r1 = 1065353216(0x3f800000, float:1.0)
        L52:
            float r2 = r8.f32260h
            float r2 = r0 - r2
            float r2 = java.lang.Math.abs(r2)
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 < 0) goto L5f
            goto L6c
        L5f:
            r5 = 0
            goto L6c
        L61:
            if (r6 == 0) goto L64
            goto L6c
        L64:
            id.d r2 = r8.f32253a
            int r2 = r2.c()
            if (r2 < r1) goto L5f
        L6c:
            if (r5 == 0) goto L73
            r8.f32260h = r0
            r8.t(r4)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.m.s():void");
    }

    public final void t(boolean z10) {
        Surface surface;
        if (u0.f31154a < 30 || (surface = this.f32258f) == null) {
            return;
        }
        float f10 = 0.0f;
        if (this.f32257e) {
            float f11 = this.f32260h;
            if (f11 != -1.0f) {
                f10 = this.f32262j * f11;
            }
        }
        if (z10 || this.f32261i != f10) {
            this.f32261i = f10;
            q(surface, f10);
        }
    }
}
