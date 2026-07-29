package com.google.android.exoplayer2.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import ed.u;
import g.p0;
import hd.q0;
import hd.t;
import hd.u0;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class Loader implements u {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f19035d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f19036e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f19037f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f19038g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f19039h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f19040i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final c f19041j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final c f19042k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f19043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public d<? extends e> f19044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public IOException f19045c;

    public static final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Throwable th2) {
            super("Unexpected " + th2.getClass().getSimpleName() + ": " + th2.getMessage(), th2);
        }
    }

    public interface b<T extends e> {
        void i(T t10, long j10, long j11, boolean z10);

        void l(T t10, long j10, long j11);

        c t(T t10, long j10, long j11, IOException iOException, int i10);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f19046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f19047b;

        public boolean c() {
            int i10 = this.f19046a;
            return i10 == 0 || i10 == 1;
        }

        public c(int i10, long j10) {
            this.f19046a = i10;
            this.f19047b = j10;
        }
    }

    @SuppressLint({"HandlerLeak"})
    public final class d<T extends e> extends Handler implements Runnable {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final String f19048k = "LoadTask";

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f19049l = 0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int f19050m = 1;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int f19051n = 2;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final int f19052o = 3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f19053a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f19054b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f19055c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @p0
        public b<T> f19056d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @p0
        public IOException f19057e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f19058f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @p0
        public Thread f19059g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f19060h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public volatile boolean f19061i;

        public d(Looper looper, T t10, b<T> bVar, int i10, long j10) {
            super(looper);
            this.f19054b = t10;
            this.f19056d = bVar;
            this.f19053a = i10;
            this.f19055c = j10;
        }

        public void a(boolean z10) {
            this.f19061i = z10;
            this.f19057e = null;
            if (hasMessages(0)) {
                this.f19060h = true;
                removeMessages(0);
                if (!z10) {
                    sendEmptyMessage(1);
                }
            } else {
                synchronized (this) {
                    this.f19060h = true;
                    this.f19054b.c();
                    Thread thread = this.f19059g;
                    if (thread != null) {
                        thread.interrupt();
                    }
                }
            }
            if (z10) {
                c();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                ((b) hd.a.g(this.f19056d)).i(this.f19054b, jElapsedRealtime, jElapsedRealtime - this.f19055c, true);
                this.f19056d = null;
            }
        }

        public final void b() {
            this.f19057e = null;
            Loader.this.f19043a.execute((Runnable) hd.a.g(Loader.this.f19044b));
        }

        public final void c() {
            Loader.this.f19044b = null;
        }

        public final long d() {
            return Math.min((this.f19058f - 1) * 1000, 5000);
        }

        public void e(int i10) throws IOException {
            IOException iOException = this.f19057e;
            if (iOException != null && this.f19058f > i10) {
                throw iOException;
            }
        }

        public void f(long j10) {
            hd.a.i(Loader.this.f19044b == null);
            Loader.this.f19044b = this;
            if (j10 > 0) {
                sendEmptyMessageDelayed(0, j10);
            } else {
                b();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f19061i) {
                return;
            }
            int i10 = message.what;
            if (i10 == 0) {
                b();
                return;
            }
            if (i10 == 3) {
                throw ((Error) message.obj);
            }
            c();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j10 = jElapsedRealtime - this.f19055c;
            b bVar = (b) hd.a.g(this.f19056d);
            if (this.f19060h) {
                bVar.i(this.f19054b, jElapsedRealtime, j10, false);
                return;
            }
            int i11 = message.what;
            if (i11 == 1) {
                try {
                    bVar.l(this.f19054b, jElapsedRealtime, j10);
                    return;
                } catch (RuntimeException e10) {
                    t.e(f19048k, "Unexpected exception handling load completed", e10);
                    Loader.this.f19045c = new UnexpectedLoaderException(e10);
                    return;
                }
            }
            if (i11 != 2) {
                return;
            }
            IOException iOException = (IOException) message.obj;
            this.f19057e = iOException;
            int i12 = this.f19058f + 1;
            this.f19058f = i12;
            c cVarT = bVar.t(this.f19054b, jElapsedRealtime, j10, iOException, i12);
            if (cVarT.f19046a == 3) {
                Loader.this.f19045c = this.f19057e;
            } else if (cVarT.f19046a != 2) {
                if (cVarT.f19046a == 1) {
                    this.f19058f = 1;
                }
                f(cVarT.f19047b != ya.g.f56663b ? cVarT.f19047b : d());
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            try {
                synchronized (this) {
                    z10 = !this.f19060h;
                    this.f19059g = Thread.currentThread();
                }
                if (z10) {
                    q0.a("load:" + this.f19054b.getClass().getSimpleName());
                    try {
                        this.f19054b.b();
                        q0.c();
                    } catch (Throwable th2) {
                        q0.c();
                        throw th2;
                    }
                }
                synchronized (this) {
                    this.f19059g = null;
                    Thread.interrupted();
                }
                if (this.f19061i) {
                    return;
                }
                sendEmptyMessage(1);
            } catch (IOException e10) {
                if (this.f19061i) {
                    return;
                }
                obtainMessage(2, e10).sendToTarget();
            } catch (Error e11) {
                t.e(f19048k, "Unexpected error loading stream", e11);
                if (!this.f19061i) {
                    obtainMessage(3, e11).sendToTarget();
                }
                throw e11;
            } catch (Exception e12) {
                t.e(f19048k, "Unexpected exception loading stream", e12);
                if (this.f19061i) {
                    return;
                }
                obtainMessage(2, new UnexpectedLoaderException(e12)).sendToTarget();
            } catch (OutOfMemoryError e13) {
                t.e(f19048k, "OutOfMemory error loading stream", e13);
                if (this.f19061i) {
                    return;
                }
                obtainMessage(2, new UnexpectedLoaderException(e13)).sendToTarget();
            }
        }
    }

    public interface e {
        void b() throws IOException;

        void c();
    }

    public interface f {
        void h();
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f19063a;

        public g(f fVar) {
            this.f19063a = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f19063a.h();
        }
    }

    static {
        long j10 = ya.g.f56663b;
        f19039h = i(false, ya.g.f56663b);
        f19040i = i(true, ya.g.f56663b);
        f19041j = new c(2, j10);
        f19042k = new c(3, j10);
    }

    public Loader(String str) {
        this.f19043a = u0.R0(str);
    }

    public static c i(boolean z10, long j10) {
        return new c(z10 ? 1 : 0, j10);
    }

    @Override // ed.u
    public void a() throws IOException {
        b(Integer.MIN_VALUE);
    }

    @Override // ed.u
    public void b(int i10) throws IOException {
        IOException iOException = this.f19045c;
        if (iOException != null) {
            throw iOException;
        }
        d<? extends e> dVar = this.f19044b;
        if (dVar != null) {
            if (i10 == Integer.MIN_VALUE) {
                i10 = dVar.f19053a;
            }
            dVar.e(i10);
        }
    }

    public void g() {
        ((d) hd.a.k(this.f19044b)).a(false);
    }

    public void h() {
        this.f19045c = null;
    }

    public boolean j() {
        return this.f19045c != null;
    }

    public boolean k() {
        return this.f19044b != null;
    }

    public void l() {
        m(null);
    }

    public void m(@p0 f fVar) {
        d<? extends e> dVar = this.f19044b;
        if (dVar != null) {
            dVar.a(true);
        }
        if (fVar != null) {
            this.f19043a.execute(new g(fVar));
        }
        this.f19043a.shutdown();
    }

    public <T extends e> long n(T t10, b<T> bVar, int i10) {
        Looper looper = (Looper) hd.a.k(Looper.myLooper());
        this.f19045c = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new d(looper, t10, bVar, i10, jElapsedRealtime).f(0L);
        return jElapsedRealtime;
    }
}
