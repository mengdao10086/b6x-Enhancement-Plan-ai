package com.google.android.exoplayer2.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.google.android.exoplayer2.util.EGLSurfaceTexture;
import g.p0;
import g.v0;
import hd.m;
import hd.t;

/* JADX INFO: loaded from: classes3.dex */
@v0(17)
public final class DummySurface extends Surface {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f19304d = "DummySurface";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f19305e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f19306f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f19307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f19308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f19309c;

    public static class b extends HandlerThread implements Handler.Callback {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f19310f = 1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f19311g = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public EGLSurfaceTexture f19312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Handler f19313b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public Error f19314c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @p0
        public RuntimeException f19315d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @p0
        public DummySurface f19316e;

        public b() {
            super("ExoPlayer:DummySurface");
        }

        public DummySurface a(int i10) {
            boolean z10;
            start();
            this.f19313b = new Handler(getLooper(), this);
            this.f19312a = new EGLSurfaceTexture(this.f19313b);
            synchronized (this) {
                z10 = false;
                this.f19313b.obtainMessage(1, i10, 0).sendToTarget();
                while (this.f19316e == null && this.f19315d == null && this.f19314c == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z10 = true;
                    }
                }
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.f19315d;
            if (runtimeException != null) {
                throw runtimeException;
            }
            Error error = this.f19314c;
            if (error == null) {
                return (DummySurface) hd.a.g(this.f19316e);
            }
            throw error;
        }

        public final void b(int i10) {
            hd.a.g(this.f19312a);
            this.f19312a.h(i10);
            this.f19316e = new DummySurface(this, this.f19312a.g(), i10 != 0);
        }

        public void c() {
            hd.a.g(this.f19313b);
            this.f19313b.sendEmptyMessage(2);
        }

        public final void d() {
            hd.a.g(this.f19312a);
            this.f19312a.i();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            try {
                if (i10 != 1) {
                    if (i10 != 2) {
                        return true;
                    }
                    try {
                        d();
                    } finally {
                        try {
                        } finally {
                        }
                    }
                    return true;
                }
                try {
                    b(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e10) {
                    t.e(DummySurface.f19304d, "Failed to initialize dummy surface", e10);
                    this.f19314c = e10;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e11) {
                    t.e(DummySurface.f19304d, "Failed to initialize dummy surface", e11);
                    this.f19315d = e11;
                    synchronized (this) {
                        notify();
                    }
                }
                return true;
            } catch (Throwable th2) {
                synchronized (this) {
                    notify();
                    throw th2;
                }
            }
        }
    }

    public static int a(Context context) {
        if (m.k(context)) {
            return m.l() ? 1 : 2;
        }
        return 0;
    }

    public static synchronized boolean b(Context context) {
        if (!f19306f) {
            f19305e = a(context);
            f19306f = true;
        }
        return f19305e != 0;
    }

    public static DummySurface e(Context context, boolean z10) {
        hd.a.i(!z10 || b(context));
        return new b().a(z10 ? f19305e : 0);
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.f19308b) {
            if (!this.f19309c) {
                this.f19308b.c();
                this.f19309c = true;
            }
        }
    }

    public DummySurface(b bVar, SurfaceTexture surfaceTexture, boolean z10) {
        super(surfaceTexture);
        this.f19308b = bVar;
        this.f19307a = z10;
    }
}
