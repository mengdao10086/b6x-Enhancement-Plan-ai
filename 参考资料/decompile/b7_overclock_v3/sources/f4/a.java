package f4;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import g.f0;
import g.i1;
import g.n0;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ExecutorService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f27933b = "source";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f27934c = "disk-cache";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f27935d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f27936e = "GlideExecutor";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f27937f = "source-unlimited";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f27938g = "animation";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f27939h = TimeUnit.SECONDS.toMillis(10);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f27940i = 4;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile int f27941j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f27942a;

    public static final class b {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final long f27943h = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f27944a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f27945b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f27946c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @n0
        public final ThreadFactory f27947d = new c();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @n0
        public e f27948e = e.f27963d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f27949f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f27950g;

        public b(boolean z10) {
            this.f27944a = z10;
        }

        public a a() {
            if (TextUtils.isEmpty(this.f27949f)) {
                throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f27949f);
            }
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.f27945b, this.f27946c, this.f27950g, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new d(this.f27947d, this.f27949f, this.f27948e, this.f27944a));
            if (this.f27950g != 0) {
                threadPoolExecutor.allowCoreThreadTimeOut(true);
            }
            return new a(threadPoolExecutor);
        }

        public b b(String str) {
            this.f27949f = str;
            return this;
        }

        public b c(@f0(from = 1) int i10) {
            this.f27945b = i10;
            this.f27946c = i10;
            return this;
        }

        public b d(long j10) {
            this.f27950g = j10;
            return this;
        }

        public b e(@n0 e eVar) {
            this.f27948e = eVar;
            return this;
        }
    }

    public static final class c implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f27951a = 9;

        /* JADX INFO: renamed from: f4.a$c$a, reason: collision with other inner class name */
        public class C0326a extends Thread {
            public C0326a(Runnable runnable) {
                super(runnable);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(9);
                super.run();
            }
        }

        public c() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@n0 Runnable runnable) {
            return new C0326a(runnable);
        }
    }

    public static final class d implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadFactory f27953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f27954b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e f27955c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f27956d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicInteger f27957e = new AtomicInteger();

        /* JADX INFO: renamed from: f4.a$d$a, reason: collision with other inner class name */
        public class RunnableC0327a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Runnable f27958a;

            public RunnableC0327a(Runnable runnable) {
                this.f27958a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f27956d) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    this.f27958a.run();
                } catch (Throwable th2) {
                    d.this.f27955c.a(th2);
                }
            }
        }

        public d(ThreadFactory threadFactory, String str, e eVar, boolean z10) {
            this.f27953a = threadFactory;
            this.f27954b = str;
            this.f27955c = eVar;
            this.f27956d = z10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@n0 Runnable runnable) {
            Thread threadNewThread = this.f27953a.newThread(new RunnableC0327a(runnable));
            threadNewThread.setName("glide-" + this.f27954b + "-thread-" + this.f27957e.getAndIncrement());
            return threadNewThread;
        }
    }

    public interface e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f27960a = new C0328a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f27961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f27962c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final e f27963d;

        /* JADX INFO: renamed from: f4.a$e$a, reason: collision with other inner class name */
        public class C0328a implements e {
            @Override // f4.a.e
            public void a(Throwable th2) {
            }
        }

        public class b implements e {
            @Override // f4.a.e
            public void a(Throwable th2) {
            }
        }

        public class c implements e {
            @Override // f4.a.e
            public void a(Throwable th2) {
                if (th2 != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th2);
                }
            }
        }

        static {
            b bVar = new b();
            f27961b = bVar;
            f27962c = new c();
            f27963d = bVar;
        }

        void a(Throwable th2);
    }

    @i1
    public a(ExecutorService executorService) {
        this.f27942a = executorService;
    }

    public static int a() {
        if (f27941j == 0) {
            f27941j = Math.min(4, f4.b.a());
        }
        return f27941j;
    }

    public static b b() {
        return new b(true).c(a() >= 4 ? 2 : 1).b(f27938g);
    }

    public static a c() {
        return b().a();
    }

    @Deprecated
    public static a d(int i10, e eVar) {
        return b().c(i10).e(eVar).a();
    }

    public static b e() {
        return new b(true).c(1).b(f27934c);
    }

    public static a f() {
        return e().a();
    }

    @Deprecated
    public static a g(int i10, String str, e eVar) {
        return e().c(i10).b(str).e(eVar).a();
    }

    @Deprecated
    public static a h(e eVar) {
        return e().e(eVar).a();
    }

    public static b i() {
        return new b(false).c(a()).b("source");
    }

    public static a j() {
        return i().a();
    }

    @Deprecated
    public static a k(int i10, String str, e eVar) {
        return i().c(i10).b(str).e(eVar).a();
    }

    @Deprecated
    public static a l(e eVar) {
        return i().e(eVar).a();
    }

    public static a m() {
        return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f27939h, TimeUnit.MILLISECONDS, new SynchronousQueue(), new d(new c(), f27937f, e.f27963d, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j10, @n0 TimeUnit timeUnit) throws InterruptedException {
        return this.f27942a.awaitTermination(j10, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@n0 Runnable runnable) {
        this.f27942a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @n0
    public <T> List<Future<T>> invokeAll(@n0 Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f27942a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    @n0
    public <T> T invokeAny(@n0 Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return (T) this.f27942a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f27942a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f27942a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f27942a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    @n0
    public List<Runnable> shutdownNow() {
        return this.f27942a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    @n0
    public Future<?> submit(@n0 Runnable runnable) {
        return this.f27942a.submit(runnable);
    }

    public String toString() {
        return this.f27942a.toString();
    }

    @Override // java.util.concurrent.ExecutorService
    @n0
    public <T> List<Future<T>> invokeAll(@n0 Collection<? extends Callable<T>> collection, long j10, @n0 TimeUnit timeUnit) throws InterruptedException {
        return this.f27942a.invokeAll(collection, j10, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@n0 Collection<? extends Callable<T>> collection, long j10, @n0 TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (T) this.f27942a.invokeAny(collection, j10, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    @n0
    public <T> Future<T> submit(@n0 Runnable runnable, T t10) {
        return this.f27942a.submit(runnable, t10);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(@n0 Callable<T> callable) {
        return this.f27942a.submit(callable);
    }
}
