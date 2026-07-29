package v0;

import android.os.Handler;
import android.os.Process;
import androidx.core.util.o;
import g.f0;
import g.n0;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    public static class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f52517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f52518b;

        /* JADX INFO: renamed from: v0.i$a$a, reason: collision with other inner class name */
        public static class C0610a extends Thread {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f52519a;

            public C0610a(Runnable runnable, String str, int i10) {
                super(runnable, str);
                this.f52519a = i10;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.f52519a);
                super.run();
            }
        }

        public a(@n0 String str, int i10) {
            this.f52517a = str;
            this.f52518b = i10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0610a(runnable, this.f52517a, this.f52518b);
        }
    }

    public static class b implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f52520a;

        public b(@n0 Handler handler) {
            this.f52520a = (Handler) o.l(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@n0 Runnable runnable) {
            if (this.f52520a.post((Runnable) o.l(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.f52520a + " is shutting down");
        }
    }

    public static class c<T> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public Callable<T> f52521a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @n0
        public androidx.core.util.d<T> f52522b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @n0
        public Handler f52523c;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ androidx.core.util.d f52524a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Object f52525b;

            public a(androidx.core.util.d dVar, Object obj) {
                this.f52524a = dVar;
                this.f52525b = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                this.f52524a.accept(this.f52525b);
            }
        }

        public c(@n0 Handler handler, @n0 Callable<T> callable, @n0 androidx.core.util.d<T> dVar) {
            this.f52521a = callable;
            this.f52522b = dVar;
            this.f52523c = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            T tCall;
            try {
                tCall = this.f52521a.call();
            } catch (Exception unused) {
                tCall = null;
            }
            this.f52523c.post(new a(this.f52522b, tCall));
        }
    }

    public static ThreadPoolExecutor a(@n0 String str, int i10, @f0(from = 0) int i11) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i11, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i10));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static Executor b(@n0 Handler handler) {
        return new b(handler);
    }

    public static <T> void c(@n0 Executor executor, @n0 Callable<T> callable, @n0 androidx.core.util.d<T> dVar) {
        executor.execute(new c(v0.b.a(), callable, dVar));
    }

    public static <T> T d(@n0 ExecutorService executorService, @n0 Callable<T> callable, @f0(from = 0) int i10) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            throw e10;
        } catch (ExecutionException e11) {
            throw new RuntimeException(e11);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
