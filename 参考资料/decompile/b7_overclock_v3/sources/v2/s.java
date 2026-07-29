package v2;

import androidx.annotation.RestrictTo;
import g.i1;
import g.n0;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class s {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f52641f = androidx.work.l.f("WorkTimer");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadFactory f52642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f52643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, c> f52644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, b> f52645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f52646e;

    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f52647a = 0;

        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@n0 Runnable r10) {
            Thread threadNewThread = Executors.defaultThreadFactory().newThread(r10);
            threadNewThread.setName("WorkManager-WorkTimer-thread-" + this.f52647a);
            this.f52647a = this.f52647a + 1;
            return threadNewThread;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface b {
        void a(@n0 String workSpecId);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f52649c = "WrkTimerRunnable";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s f52650a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f52651b;

        public c(@n0 s workTimer, @n0 String workSpecId) {
            this.f52650a = workTimer;
            this.f52651b = workSpecId;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f52650a.f52646e) {
                if (this.f52650a.f52644c.remove(this.f52651b) != null) {
                    b bVarRemove = this.f52650a.f52645d.remove(this.f52651b);
                    if (bVarRemove != null) {
                        bVarRemove.a(this.f52651b);
                    }
                } else {
                    androidx.work.l.c().a(f52649c, String.format("Timer with %s is already marked as complete.", this.f52651b), new Throwable[0]);
                }
            }
        }
    }

    public s() {
        a aVar = new a();
        this.f52642a = aVar;
        this.f52644c = new HashMap();
        this.f52645d = new HashMap();
        this.f52646e = new Object();
        this.f52643b = Executors.newSingleThreadScheduledExecutor(aVar);
    }

    @i1
    @n0
    public ScheduledExecutorService a() {
        return this.f52643b;
    }

    @i1
    @n0
    public synchronized Map<String, b> b() {
        return this.f52645d;
    }

    @i1
    @n0
    public synchronized Map<String, c> c() {
        return this.f52644c;
    }

    public void d() {
        if (this.f52643b.isShutdown()) {
            return;
        }
        this.f52643b.shutdownNow();
    }

    public void e(@n0 final String workSpecId, long processingTimeMillis, @n0 b listener) {
        synchronized (this.f52646e) {
            androidx.work.l.c().a(f52641f, String.format("Starting timer for %s", workSpecId), new Throwable[0]);
            f(workSpecId);
            c cVar = new c(this, workSpecId);
            this.f52644c.put(workSpecId, cVar);
            this.f52645d.put(workSpecId, listener);
            this.f52643b.schedule(cVar, processingTimeMillis, TimeUnit.MILLISECONDS);
        }
    }

    public void f(@n0 final String workSpecId) {
        synchronized (this.f52646e) {
            if (this.f52644c.remove(workSpecId) != null) {
                androidx.work.l.c().a(f52641f, String.format("Stopping timer for %s", workSpecId), new Throwable[0]);
                this.f52645d.remove(workSpecId);
            }
        }
    }
}
