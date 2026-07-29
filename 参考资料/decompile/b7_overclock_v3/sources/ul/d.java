package ul;

import hk.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import rl.f;
import xf.j;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0003\u001a\u001b\u000bB\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\t\u001a\u00020\u0002J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nJ\u0006\u0010\f\u001a\u00020\u0004J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lul/d;", "", "Lul/c;", "taskQueue", "Lkotlin/z1;", "i", "(Lul/c;)V", "Lul/a;", "e", j.f55230b, "", "c", "g", "task", "f", "k", "", "delayNanos", "d", "Lul/d$a;", "backend", "Lul/d$a;", "h", "()Lul/d$a;", "<init>", "(Lul/d$a;)V", "a", "b", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @k
    public static final b f52207h = new b(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @e
    @k
    public static final d f52208i = new d(new c(f.Y(f0.C(f.f48804i, " TaskRunner"), true)));

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @k
    public static final Logger f52209j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final a f52210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f52211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f52212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f52213d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @k
    public final List<ul.c> f52214e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @k
    public final List<ul.c> f52215f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @k
    public final Runnable f52216g;

    @d0(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H&J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¨\u0006\u000e"}, d2 = {"Lul/d$a;", "", "Lul/d;", "taskRunner", "Lkotlin/z1;", "c", "", "d", "b", "nanos", "a", "Ljava/lang/Runnable;", "runnable", "execute", "okhttp"}, k = 1, mv = {1, 6, 0})
    public interface a {
        void a(@k d dVar, long j10);

        void b(@k d dVar);

        void c(@k d dVar);

        long d();

        void execute(@k Runnable runnable);
    }

    @d0(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lul/d$b;", "", "Ljava/util/logging/Logger;", "logger", "Ljava/util/logging/Logger;", "a", "()Ljava/util/logging/Logger;", "Lul/d;", "INSTANCE", "Lul/d;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(u uVar) {
            this();
        }

        @k
        public final Logger a() {
            return d.f52209j;
        }
    }

    @d0(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0006\u0010\u000e\u001a\u00020\u0004¨\u0006\u0013"}, d2 = {"Lul/d$c;", "Lul/d$a;", "Lul/d;", "taskRunner", "Lkotlin/z1;", "c", "", "d", "b", "nanos", "a", "Ljava/lang/Runnable;", "runnable", "execute", "e", "Ljava/util/concurrent/ThreadFactory;", "threadFactory", "<init>", "(Ljava/util/concurrent/ThreadFactory;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @k
        public final ThreadPoolExecutor f52217a;

        public c(@k ThreadFactory threadFactory) {
            f0.p(threadFactory, "threadFactory");
            this.f52217a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        @Override // ul.d.a
        public void a(@k d taskRunner, long j10) throws InterruptedException {
            f0.p(taskRunner, "taskRunner");
            long j11 = j10 / 1000000;
            long j12 = j10 - (1000000 * j11);
            if (j11 > 0 || j10 > 0) {
                taskRunner.wait(j11, (int) j12);
            }
        }

        @Override // ul.d.a
        public void b(@k d taskRunner) {
            f0.p(taskRunner, "taskRunner");
            taskRunner.notify();
        }

        @Override // ul.d.a
        public void c(@k d taskRunner) {
            f0.p(taskRunner, "taskRunner");
        }

        @Override // ul.d.a
        public long d() {
            return System.nanoTime();
        }

        public final void e() {
            this.f52217a.shutdown();
        }

        @Override // ul.d.a
        public void execute(@k Runnable runnable) {
            f0.p(runnable, "runnable");
            this.f52217a.execute(runnable);
        }
    }

    /* JADX INFO: renamed from: ul.d$d, reason: collision with other inner class name */
    @d0(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"ul/d$d", "Ljava/lang/Runnable;", "Lkotlin/z1;", "run", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class RunnableC0605d implements Runnable {
        public RunnableC0605d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ul.a aVarE;
            while (true) {
                d dVar = d.this;
                synchronized (dVar) {
                    aVarE = dVar.e();
                }
                if (aVarE == null) {
                    return;
                }
                ul.c cVarD = aVarE.d();
                f0.m(cVarD);
                d dVar2 = d.this;
                long jD = -1;
                boolean zIsLoggable = d.f52207h.a().isLoggable(Level.FINE);
                if (zIsLoggable) {
                    jD = cVarD.k().h().d();
                    ul.b.c(aVarE, cVarD, "starting");
                }
                try {
                    try {
                        dVar2.k(aVarE);
                        z1 z1Var = z1.f38230a;
                        if (zIsLoggable) {
                            ul.b.c(aVarE, cVarD, f0.C("finished run in ", ul.b.b(cVarD.k().h().d() - jD)));
                        }
                    } finally {
                    }
                } catch (Throwable th2) {
                    if (zIsLoggable) {
                        ul.b.c(aVarE, cVarD, f0.C("failed a run in ", ul.b.b(cVarD.k().h().d() - jD)));
                    }
                    throw th2;
                }
            }
        }
    }

    static {
        Logger logger = Logger.getLogger(d.class.getName());
        f0.o(logger, "getLogger(TaskRunner::class.java.name)");
        f52209j = logger;
    }

    public d(@k a backend) {
        f0.p(backend, "backend");
        this.f52210a = backend;
        this.f52211b = 10000;
        this.f52214e = new ArrayList();
        this.f52215f = new ArrayList();
        this.f52216g = new RunnableC0605d();
    }

    @k
    public final List<ul.c> c() {
        List<ul.c> listY4;
        synchronized (this) {
            listY4 = CollectionsKt___CollectionsKt.y4(this.f52214e, this.f52215f);
        }
        return listY4;
    }

    public final void d(ul.a aVar, long j10) {
        if (f.f48803h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
        }
        ul.c cVarD = aVar.d();
        f0.m(cVarD);
        if (!(cVarD.e() == aVar)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        boolean zF = cVarD.f();
        cVarD.s(false);
        cVarD.r(null);
        this.f52214e.remove(cVarD);
        if (j10 != -1 && !zF && !cVarD.j()) {
            cVarD.q(aVar, j10, true);
        }
        if (!cVarD.g().isEmpty()) {
            this.f52215f.add(cVarD);
        }
    }

    @l
    public final ul.a e() {
        boolean z10;
        if (f.f48803h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
        }
        while (!this.f52215f.isEmpty()) {
            long jD = this.f52210a.d();
            long jMin = Long.MAX_VALUE;
            Iterator<ul.c> it2 = this.f52215f.iterator();
            ul.a aVar = null;
            while (true) {
                if (!it2.hasNext()) {
                    z10 = false;
                    break;
                }
                ul.a aVar2 = it2.next().g().get(0);
                long jMax = Math.max(0L, aVar2.c() - jD);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (aVar != null) {
                        z10 = true;
                        break;
                    }
                    aVar = aVar2;
                }
            }
            if (aVar != null) {
                f(aVar);
                if (z10 || (!this.f52212c && (!this.f52215f.isEmpty()))) {
                    this.f52210a.execute(this.f52216g);
                }
                return aVar;
            }
            if (this.f52212c) {
                if (jMin < this.f52213d - jD) {
                    this.f52210a.b(this);
                }
                return null;
            }
            this.f52212c = true;
            this.f52213d = jD + jMin;
            try {
                try {
                    this.f52210a.a(this, jMin);
                } catch (InterruptedException unused) {
                    g();
                }
            } finally {
                this.f52212c = false;
            }
        }
        return null;
    }

    public final void f(ul.a aVar) {
        if (f.f48803h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
        }
        aVar.g(-1L);
        ul.c cVarD = aVar.d();
        f0.m(cVarD);
        cVarD.g().remove(aVar);
        this.f52215f.remove(cVarD);
        cVarD.r(aVar);
        this.f52214e.add(cVarD);
    }

    public final void g() {
        int size = this.f52214e.size() - 1;
        if (size >= 0) {
            while (true) {
                int i10 = size - 1;
                this.f52214e.get(size).b();
                if (i10 < 0) {
                    break;
                } else {
                    size = i10;
                }
            }
        }
        int size2 = this.f52215f.size() - 1;
        if (size2 < 0) {
            return;
        }
        while (true) {
            int i11 = size2 - 1;
            ul.c cVar = this.f52215f.get(size2);
            cVar.b();
            if (cVar.g().isEmpty()) {
                this.f52215f.remove(size2);
            }
            if (i11 < 0) {
                return;
            } else {
                size2 = i11;
            }
        }
    }

    @k
    public final a h() {
        return this.f52210a;
    }

    public final void i(@k ul.c taskQueue) {
        f0.p(taskQueue, "taskQueue");
        if (f.f48803h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
        }
        if (taskQueue.e() == null) {
            if (!taskQueue.g().isEmpty()) {
                f.c(this.f52215f, taskQueue);
            } else {
                this.f52215f.remove(taskQueue);
            }
        }
        if (this.f52212c) {
            this.f52210a.b(this);
        } else {
            this.f52210a.execute(this.f52216g);
        }
    }

    @k
    public final ul.c j() {
        int i10;
        synchronized (this) {
            i10 = this.f52211b;
            this.f52211b = i10 + 1;
        }
        return new ul.c(this, f0.C("Q", Integer.valueOf(i10)));
    }

    public final void k(ul.a aVar) {
        if (f.f48803h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(aVar.b());
        try {
            long jF = aVar.f();
            synchronized (this) {
                d(aVar, jF);
                z1 z1Var = z1.f38230a;
            }
            threadCurrentThread.setName(name);
        } catch (Throwable th2) {
            synchronized (this) {
                d(aVar, -1L);
                z1 z1Var2 = z1.f38230a;
                threadCurrentThread.setName(name);
                throw th2;
            }
        }
    }
}
