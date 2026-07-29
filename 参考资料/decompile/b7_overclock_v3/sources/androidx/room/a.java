package androidx.room;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f7304e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final Executor f7305f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.p0
    @g.b0("mLock")
    public c2.d f7308i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.p0
    public c2.e f7300a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final Handler f7301b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.p0
    public Runnable f7302c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final Object f7303d = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.b0("mLock")
    public int f7306g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.b0("mLock")
    public long f7307h = SystemClock.uptimeMillis();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f7309j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Runnable f7310k = new RunnableC0067a();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final Runnable f7311l = new b();

    /* JADX INFO: renamed from: androidx.room.a$a, reason: collision with other inner class name */
    public class RunnableC0067a implements Runnable {
        public RunnableC0067a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.f7305f.execute(aVar.f7311l);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (a.this.f7303d) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                a aVar = a.this;
                if (jUptimeMillis - aVar.f7307h < aVar.f7304e) {
                    return;
                }
                if (aVar.f7306g != 0) {
                    return;
                }
                Runnable runnable = aVar.f7302c;
                if (runnable == null) {
                    throw new IllegalStateException("mOnAutoCloseCallback is null but it should have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
                }
                runnable.run();
                c2.d dVar = a.this.f7308i;
                if (dVar != null && dVar.isOpen()) {
                    try {
                        a.this.f7308i.close();
                    } catch (IOException e10) {
                        b2.f.a(e10);
                    }
                    a.this.f7308i = null;
                }
            }
        }
    }

    public a(long j10, @g.n0 TimeUnit timeUnit, @g.n0 Executor executor) {
        this.f7304e = timeUnit.toMillis(j10);
        this.f7305f = executor;
    }

    public void a() throws IOException {
        synchronized (this.f7303d) {
            this.f7309j = true;
            c2.d dVar = this.f7308i;
            if (dVar != null) {
                dVar.close();
            }
            this.f7308i = null;
        }
    }

    public void b() {
        synchronized (this.f7303d) {
            int i10 = this.f7306g;
            if (i10 <= 0) {
                throw new IllegalStateException("ref count is 0 or lower but we're supposed to decrement");
            }
            int i11 = i10 - 1;
            this.f7306g = i11;
            if (i11 == 0) {
                if (this.f7308i == null) {
                } else {
                    this.f7301b.postDelayed(this.f7310k, this.f7304e);
                }
            }
        }
    }

    @g.p0
    public <V> V c(@g.n0 p.a<c2.d, V> aVar) {
        try {
            return aVar.apply(f());
        } finally {
            b();
        }
    }

    @g.p0
    public c2.d d() {
        c2.d dVar;
        synchronized (this.f7303d) {
            dVar = this.f7308i;
        }
        return dVar;
    }

    @g.i1
    public int e() {
        int i10;
        synchronized (this.f7303d) {
            i10 = this.f7306g;
        }
        return i10;
    }

    @g.n0
    public c2.d f() {
        synchronized (this.f7303d) {
            this.f7301b.removeCallbacks(this.f7310k);
            this.f7306g++;
            if (this.f7309j) {
                throw new IllegalStateException("Attempting to open already closed database.");
            }
            c2.d dVar = this.f7308i;
            if (dVar != null && dVar.isOpen()) {
                return this.f7308i;
            }
            c2.e eVar = this.f7300a;
            if (eVar == null) {
                throw new IllegalStateException("AutoCloser has not been initialized. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
            }
            c2.d writableDatabase = eVar.getWritableDatabase();
            this.f7308i = writableDatabase;
            return writableDatabase;
        }
    }

    public void g(@g.n0 c2.e eVar) {
        if (this.f7300a != null) {
            return;
        }
        this.f7300a = eVar;
    }

    public boolean h() {
        return !this.f7309j;
    }

    public void i(Runnable runnable) {
        this.f7302c = runnable;
    }
}
