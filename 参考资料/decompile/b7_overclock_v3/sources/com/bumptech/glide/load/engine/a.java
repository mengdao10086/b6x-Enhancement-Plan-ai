package com.bumptech.glide.load.engine;

import android.os.Process;
import com.bumptech.glide.load.engine.n;
import g.i1;
import g.n0;
import g.p0;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f12266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f12267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @i1
    public final Map<c4.b, d> f12268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ReferenceQueue<n<?>> f12269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n.a f12270e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f12271f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public volatile c f12272g;

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.a$a, reason: collision with other inner class name */
    public class ThreadFactoryC0120a implements ThreadFactory {

        /* JADX INFO: renamed from: com.bumptech.glide.load.engine.a$a$a, reason: collision with other inner class name */
        public class RunnableC0121a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Runnable f12273a;

            public RunnableC0121a(Runnable runnable) {
                this.f12273a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                this.f12273a.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@n0 Runnable runnable) {
            return new Thread(new RunnableC0121a(runnable), "glide-active-resources");
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b();
        }
    }

    @i1
    public interface c {
        void a();
    }

    @i1
    public static final class d extends WeakReference<n<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c4.b f12276a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f12277b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public s<?> f12278c;

        public d(@n0 c4.b bVar, @n0 n<?> nVar, @n0 ReferenceQueue<? super n<?>> referenceQueue, boolean z10) {
            super(nVar, referenceQueue);
            this.f12276a = (c4.b) v4.m.d(bVar);
            this.f12278c = (nVar.f() && z10) ? (s) v4.m.d(nVar.e()) : null;
            this.f12277b = nVar.f();
        }

        public void a() {
            this.f12278c = null;
            clear();
        }
    }

    public a(boolean z10) {
        this(z10, Executors.newSingleThreadExecutor(new ThreadFactoryC0120a()));
    }

    public synchronized void a(c4.b bVar, n<?> nVar) {
        d dVarPut = this.f12268c.put(bVar, new d(bVar, nVar, this.f12269d, this.f12266a));
        if (dVarPut != null) {
            dVarPut.a();
        }
    }

    public void b() {
        while (!this.f12271f) {
            try {
                c((d) this.f12269d.remove());
                c cVar = this.f12272g;
                if (cVar != null) {
                    cVar.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void c(@n0 d dVar) {
        s<?> sVar;
        synchronized (this) {
            this.f12268c.remove(dVar.f12276a);
            if (dVar.f12277b && (sVar = dVar.f12278c) != null) {
                this.f12270e.c(dVar.f12276a, new n<>(sVar, true, false, dVar.f12276a, this.f12270e));
            }
        }
    }

    public synchronized void d(c4.b bVar) {
        d dVarRemove = this.f12268c.remove(bVar);
        if (dVarRemove != null) {
            dVarRemove.a();
        }
    }

    @p0
    public synchronized n<?> e(c4.b bVar) {
        d dVar = this.f12268c.get(bVar);
        if (dVar == null) {
            return null;
        }
        n<?> nVar = dVar.get();
        if (nVar == null) {
            c(dVar);
        }
        return nVar;
    }

    @i1
    public void f(c cVar) {
        this.f12272g = cVar;
    }

    public void g(n.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f12270e = aVar;
            }
        }
    }

    @i1
    public void h() {
        this.f12271f = true;
        Executor executor = this.f12267b;
        if (executor instanceof ExecutorService) {
            v4.f.c((ExecutorService) executor);
        }
    }

    @i1
    public a(boolean z10, Executor executor) {
        this.f12268c = new HashMap();
        this.f12269d = new ReferenceQueue<>();
        this.f12266a = z10;
        this.f12267b = executor;
        executor.execute(new b());
    }
}
