package com.blankj.utilcode.util;

import android.os.Handler;
import android.os.Looper;
import com.umeng.analytics.pro.an;
import java.lang.Thread;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public final class ThreadUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f11611a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Integer, Map<Integer, ExecutorService>> f11612b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<f, ExecutorService> f11613c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f11614d = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Timer f11615e = new Timer();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte f11616f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte f11617g = -2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte f11618h = -4;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte f11619i = -8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Executor f11620j;

    public static final class UtilsThreadFactory extends AtomicLong implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AtomicInteger f11621a = new AtomicInteger(1);
        private static final long serialVersionUID = -9209200509960368598L;
        private final boolean isDaemon;
        private final String namePrefix;
        private final int priority;

        public class a extends Thread {
            public a(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    super.run();
                } catch (Throwable unused) {
                }
            }
        }

        public class b implements Thread.UncaughtExceptionHandler {
            public b() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th2) {
                System.out.println(th2);
            }
        }

        public UtilsThreadFactory(String str, int i10) {
            this(str, i10, false);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@g.n0 Runnable runnable) {
            Objects.requireNonNull(runnable, "Argument 'r' of type Runnable (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            a aVar = new a(runnable, this.namePrefix + getAndIncrement());
            aVar.setDaemon(this.isDaemon);
            aVar.setUncaughtExceptionHandler(new b());
            aVar.setPriority(this.priority);
            return aVar;
        }

        public UtilsThreadFactory(String str, int i10, boolean z10) {
            this.namePrefix = str + "-pool-" + f11621a.getAndIncrement() + "-thread-";
            this.priority = i10;
            this.isDaemon = z10;
        }
    }

    public static class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExecutorService f11624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f11625b;

        public a(ExecutorService executorService, f fVar) {
            this.f11624a = executorService;
            this.f11625b = fVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f11624a.execute(this.f11625b);
        }
    }

    public static class b extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExecutorService f11626a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f11627b;

        public b(ExecutorService executorService, f fVar) {
            this.f11626a = executorService;
            this.f11627b = fVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f11626a.execute(this.f11627b);
        }
    }

    public static class c implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(@g.n0 Runnable runnable) {
            Objects.requireNonNull(runnable, "Argument 'command' of type Runnable (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            ThreadUtils.s0(runnable);
        }
    }

    public static abstract class d<T> extends f<T> {
        @Override // com.blankj.utilcode.util.ThreadUtils.f
        public void i() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onCancel: ");
            sb2.append(Thread.currentThread());
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.f
        public void k(Throwable th2) {
        }
    }

    public static class e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CountDownLatch f11628a = new CountDownLatch(1);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AtomicBoolean f11629b = new AtomicBoolean();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public T f11630c;

        public T a() {
            if (!this.f11629b.get()) {
                try {
                    this.f11628a.await();
                } catch (InterruptedException e10) {
                    e10.printStackTrace();
                }
            }
            return this.f11630c;
        }

        public void b(T t10) {
            if (this.f11629b.compareAndSet(false, true)) {
                this.f11630c = t10;
                this.f11628a.countDown();
            }
        }
    }

    public static abstract class f<T> implements Runnable {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f11631h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f11632i = 1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f11633j = 2;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f11634k = 3;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f11635l = 4;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int f11636m = 5;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int f11637n = 6;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f11638a = new AtomicInteger(0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f11639b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile Thread f11640c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Timer f11641d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f11642e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public InterfaceC0115f f11643f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Executor f11644g;

        public class a extends TimerTask {
            public a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (f.this.h() || f.this.f11643f == null) {
                    return;
                }
                f.this.p();
                f.this.f11643f.a();
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f11646a;

            public b(Object obj) {
                this.f11646a = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                f.this.l(this.f11646a);
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f11648a;

            public c(Object obj) {
                this.f11648a = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                f.this.l(this.f11648a);
                f.this.j();
            }
        }

        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Throwable f11650a;

            public d(Throwable th2) {
                this.f11650a = th2;
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.k(this.f11650a);
                f.this.j();
            }
        }

        public class e implements Runnable {
            public e() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.i();
                f.this.j();
            }
        }

        /* JADX INFO: renamed from: com.blankj.utilcode.util.ThreadUtils$f$f, reason: collision with other inner class name */
        public interface InterfaceC0115f {
            void a();
        }

        public void cancel() {
            d(true);
        }

        public void d(boolean z10) {
            synchronized (this.f11638a) {
                if (this.f11638a.get() > 1) {
                    return;
                }
                this.f11638a.set(4);
                if (z10 && this.f11640c != null) {
                    this.f11640c.interrupt();
                }
                f().execute(new e());
            }
        }

        public abstract T e() throws Throwable;

        public final Executor f() {
            Executor executor = this.f11644g;
            return executor == null ? ThreadUtils.j0() : executor;
        }

        public boolean g() {
            return this.f11638a.get() >= 4;
        }

        public boolean h() {
            return this.f11638a.get() > 1;
        }

        public abstract void i();

        @g.i
        public void j() {
            ThreadUtils.f11613c.remove(this);
            Timer timer = this.f11641d;
            if (timer != null) {
                timer.cancel();
                this.f11641d = null;
                this.f11643f = null;
            }
        }

        public abstract void k(Throwable th2);

        public abstract void l(T t10);

        public f<T> m(Executor executor) {
            this.f11644g = executor;
            return this;
        }

        public final void n(boolean z10) {
            this.f11639b = z10;
        }

        public f<T> o(long j10, InterfaceC0115f interfaceC0115f) {
            this.f11642e = j10;
            this.f11643f = interfaceC0115f;
            return this;
        }

        public final void p() {
            synchronized (this.f11638a) {
                if (this.f11638a.get() > 1) {
                    return;
                }
                this.f11638a.set(6);
                if (this.f11640c != null) {
                    this.f11640c.interrupt();
                }
                j();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f11639b) {
                if (this.f11640c == null) {
                    if (!this.f11638a.compareAndSet(0, 1)) {
                        return;
                    } else {
                        this.f11640c = Thread.currentThread();
                    }
                } else if (this.f11638a.get() != 1) {
                    return;
                }
            } else {
                if (!this.f11638a.compareAndSet(0, 1)) {
                    return;
                }
                this.f11640c = Thread.currentThread();
                if (this.f11643f != null) {
                    Timer timer = new Timer();
                    this.f11641d = timer;
                    timer.schedule(new a(), this.f11642e);
                }
            }
            try {
                T tE = e();
                if (this.f11639b) {
                    if (this.f11638a.get() != 1) {
                        return;
                    }
                    f().execute(new b(tE));
                } else if (this.f11638a.compareAndSet(1, 3)) {
                    f().execute(new c(tE));
                }
            } catch (InterruptedException unused) {
                this.f11638a.compareAndSet(4, 5);
            } catch (Throwable th2) {
                if (this.f11638a.compareAndSet(1, 2)) {
                    f().execute(new d(th2));
                }
            }
        }
    }

    public static final class g extends ThreadPoolExecutor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f11653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public LinkedBlockingQueue4Util f11654b;

        public g(int i10, int i11, long j10, TimeUnit timeUnit, LinkedBlockingQueue4Util linkedBlockingQueue4Util, ThreadFactory threadFactory) {
            super(i10, i11, j10, timeUnit, linkedBlockingQueue4Util, threadFactory);
            this.f11653a = new AtomicInteger();
            linkedBlockingQueue4Util.mPool = this;
            this.f11654b = linkedBlockingQueue4Util;
        }

        public static ExecutorService b(int i10, int i11) {
            if (i10 == -8) {
                return new g(ThreadUtils.f11614d + 1, (ThreadUtils.f11614d * 2) + 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(true), new UtilsThreadFactory(an.f23257w, i11));
            }
            if (i10 == -4) {
                return new g((ThreadUtils.f11614d * 2) + 1, (ThreadUtils.f11614d * 2) + 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("io", i11));
            }
            if (i10 == -2) {
                return new g(0, 128, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(true), new UtilsThreadFactory("cached", i11));
            }
            if (i10 == -1) {
                return new g(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("single", i11));
            }
            return new g(i10, i10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("fixed(" + i10 + ee.a.f26979d, i11));
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public void afterExecute(Runnable runnable, Throwable th2) {
            this.f11653a.decrementAndGet();
            super.afterExecute(runnable, th2);
        }

        public final int c() {
            return this.f11653a.get();
        }

        @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
        public void execute(@g.n0 Runnable runnable) {
            Objects.requireNonNull(runnable, "Argument 'command' of type Runnable (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            if (isShutdown()) {
                return;
            }
            this.f11653a.incrementAndGet();
            try {
                super.execute(runnable);
            } catch (RejectedExecutionException unused) {
                this.f11654b.offer(runnable);
            } catch (Throwable unused2) {
                this.f11653a.decrementAndGet();
            }
        }
    }

    public static <T> void A(ExecutorService executorService, f<T> fVar) {
        h(executorService, fVar);
    }

    public static <T> void B(ExecutorService executorService, f<T> fVar, long j10, long j11, TimeUnit timeUnit) {
        j(executorService, fVar, j10, j11, timeUnit);
    }

    public static <T> void C(ExecutorService executorService, f<T> fVar, long j10, TimeUnit timeUnit) {
        j(executorService, fVar, 0L, j10, timeUnit);
    }

    public static <T> void D(ExecutorService executorService, f<T> fVar, long j10, TimeUnit timeUnit) {
        c0(executorService, fVar, j10, timeUnit);
    }

    public static <T> void E(@g.f0(from = 1) int i10, f<T> fVar) {
        h(n0(i10), fVar);
    }

    public static <T> void F(@g.f0(from = 1) int i10, f<T> fVar, @g.f0(from = 1, to = g1.a.f28860g) int i11) {
        h(o0(i10, i11), fVar);
    }

    public static <T> void G(@g.f0(from = 1) int i10, f<T> fVar, long j10, long j11, TimeUnit timeUnit) {
        j(n0(i10), fVar, j10, j11, timeUnit);
    }

    public static <T> void H(@g.f0(from = 1) int i10, f<T> fVar, long j10, long j11, TimeUnit timeUnit, @g.f0(from = 1, to = g1.a.f28860g) int i11) {
        j(o0(i10, i11), fVar, j10, j11, timeUnit);
    }

    public static <T> void I(@g.f0(from = 1) int i10, f<T> fVar, long j10, TimeUnit timeUnit) {
        j(n0(i10), fVar, 0L, j10, timeUnit);
    }

    public static <T> void J(@g.f0(from = 1) int i10, f<T> fVar, long j10, TimeUnit timeUnit, @g.f0(from = 1, to = g1.a.f28860g) int i11) {
        j(o0(i10, i11), fVar, 0L, j10, timeUnit);
    }

    public static <T> void K(@g.f0(from = 1) int i10, f<T> fVar, long j10, TimeUnit timeUnit) {
        c0(n0(i10), fVar, j10, timeUnit);
    }

    public static <T> void L(@g.f0(from = 1) int i10, f<T> fVar, long j10, TimeUnit timeUnit, @g.f0(from = 1, to = g1.a.f28860g) int i11) {
        c0(o0(i10, i11), fVar, j10, timeUnit);
    }

    public static <T> void M(f<T> fVar) {
        h(n0(-4), fVar);
    }

    public static <T> void N(f<T> fVar, @g.f0(from = 1, to = g1.a.f28860g) int i10) {
        h(o0(-4, i10), fVar);
    }

    public static <T> void O(f<T> fVar, long j10, long j11, TimeUnit timeUnit) {
        j(n0(-4), fVar, j10, j11, timeUnit);
    }

    public static <T> void P(f<T> fVar, long j10, long j11, TimeUnit timeUnit, @g.f0(from = 1, to = g1.a.f28860g) int i10) {
        j(o0(-4, i10), fVar, j10, j11, timeUnit);
    }

    public static <T> void Q(f<T> fVar, long j10, TimeUnit timeUnit) {
        j(n0(-4), fVar, 0L, j10, timeUnit);
    }

    public static <T> void R(f<T> fVar, long j10, TimeUnit timeUnit, @g.f0(from = 1, to = g1.a.f28860g) int i10) {
        j(o0(-4, i10), fVar, 0L, j10, timeUnit);
    }

    public static <T> void S(f<T> fVar, long j10, TimeUnit timeUnit) {
        c0(n0(-4), fVar, j10, timeUnit);
    }

    public static <T> void T(f<T> fVar, long j10, TimeUnit timeUnit, @g.f0(from = 1, to = g1.a.f28860g) int i10) {
        c0(o0(-4, i10), fVar, j10, timeUnit);
    }

    public static <T> void U(f<T> fVar) {
        h(n0(-1), fVar);
    }

    public static <T> void V(f<T> fVar, @g.f0(from = 1, to = g1.a.f28860g) int i10) {
        h(o0(-1, i10), fVar);
    }

    public static <T> void W(f<T> fVar, long j10, long j11, TimeUnit timeUnit) {
        j(n0(-1), fVar, j10, j11, timeUnit);
    }

    public static <T> void X(f<T> fVar, long j10, long j11, TimeUnit timeUnit, @g.f0(from = 1, to = g1.a.f28860g) int i10) {
        j(o0(-1, i10), fVar, j10, j11, timeUnit);
    }

    public static <T> void Y(f<T> fVar, long j10, TimeUnit timeUnit) {
        j(n0(-1), fVar, 0L, j10, timeUnit);
    }

    public static <T> void Z(f<T> fVar, long j10, TimeUnit timeUnit, @g.f0(from = 1, to = g1.a.f28860g) int i10) {
        j(o0(-1, i10), fVar, 0L, j10, timeUnit);
    }

    public static <T> void a0(f<T> fVar, long j10, TimeUnit timeUnit) {
        c0(n0(-1), fVar, j10, timeUnit);
    }

    public static <T> void b0(f<T> fVar, long j10, TimeUnit timeUnit, @g.f0(from = 1, to = g1.a.f28860g) int i10) {
        c0(o0(-1, i10), fVar, j10, timeUnit);
    }

    public static <T> void c0(ExecutorService executorService, f<T> fVar, long j10, TimeUnit timeUnit) {
        i(executorService, fVar, j10, 0L, timeUnit);
    }

    public static void d(f fVar) {
        if (fVar == null) {
            return;
        }
        fVar.cancel();
    }

    public static ExecutorService d0() {
        return n0(-2);
    }

    public static void e(List<f> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (f fVar : list) {
            if (fVar != null) {
                fVar.cancel();
            }
        }
    }

    public static ExecutorService e0(@g.f0(from = 1, to = g1.a.f28860g) int i10) {
        return o0(-2, i10);
    }

    public static void f(ExecutorService executorService) {
        if (executorService instanceof g) {
            for (Map.Entry<f, ExecutorService> entry : f11613c.entrySet()) {
                if (entry.getValue() == executorService) {
                    d(entry.getKey());
                }
            }
        }
    }

    public static ExecutorService f0() {
        return n0(-8);
    }

    public static void g(f... fVarArr) {
        if (fVarArr == null || fVarArr.length == 0) {
            return;
        }
        for (f fVar : fVarArr) {
            if (fVar != null) {
                fVar.cancel();
            }
        }
    }

    public static ExecutorService g0(@g.f0(from = 1, to = g1.a.f28860g) int i10) {
        return o0(-8, i10);
    }

    public static <T> void h(ExecutorService executorService, f<T> fVar) {
        i(executorService, fVar, 0L, 0L, null);
    }

    public static ExecutorService h0(@g.f0(from = 1) int i10) {
        return n0(i10);
    }

    public static <T> void i(ExecutorService executorService, f<T> fVar, long j10, long j11, TimeUnit timeUnit) {
        Map<f, ExecutorService> map = f11613c;
        synchronized (map) {
            if (map.get(fVar) != null) {
                return;
            }
            map.put(fVar, executorService);
            if (j11 != 0) {
                fVar.n(true);
                f11615e.scheduleAtFixedRate(new b(executorService, fVar), timeUnit.toMillis(j10), timeUnit.toMillis(j11));
            } else if (j10 == 0) {
                executorService.execute(fVar);
            } else {
                f11615e.schedule(new a(executorService, fVar), timeUnit.toMillis(j10));
            }
        }
    }

    public static ExecutorService i0(@g.f0(from = 1) int i10, @g.f0(from = 1, to = g1.a.f28860g) int i11) {
        return o0(i10, i11);
    }

    public static <T> void j(ExecutorService executorService, f<T> fVar, long j10, long j11, TimeUnit timeUnit) {
        i(executorService, fVar, j10, j11, timeUnit);
    }

    public static Executor j0() {
        if (f11620j == null) {
            f11620j = new c();
        }
        return f11620j;
    }

    public static <T> void k(f<T> fVar) {
        h(n0(-2), fVar);
    }

    public static ExecutorService k0() {
        return n0(-4);
    }

    public static <T> void l(f<T> fVar, @g.f0(from = 1, to = g1.a.f28860g) int i10) {
        h(o0(-2, i10), fVar);
    }

    public static ExecutorService l0(@g.f0(from = 1, to = g1.a.f28860g) int i10) {
        return o0(-4, i10);
    }

    public static <T> void m(f<T> fVar, long j10, long j11, TimeUnit timeUnit) {
        j(n0(-2), fVar, j10, j11, timeUnit);
    }

    public static Handler m0() {
        return f11611a;
    }

    public static <T> void n(f<T> fVar, long j10, long j11, TimeUnit timeUnit, @g.f0(from = 1, to = g1.a.f28860g) int i10) {
        j(o0(-2, i10), fVar, j10, j11, timeUnit);
    }

    public static ExecutorService n0(int i10) {
        return o0(i10, 5);
    }

    public static <T> void o(f<T> fVar, long j10, TimeUnit timeUnit) {
        j(n0(-2), fVar, 0L, j10, timeUnit);
    }

    public static ExecutorService o0(int i10, int i11) {
        ExecutorService executorServiceB;
        Map<Integer, Map<Integer, ExecutorService>> map = f11612b;
        synchronized (map) {
            Map<Integer, ExecutorService> map2 = map.get(Integer.valueOf(i10));
            if (map2 == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                executorServiceB = g.b(i10, i11);
                concurrentHashMap.put(Integer.valueOf(i11), executorServiceB);
                map.put(Integer.valueOf(i10), concurrentHashMap);
            } else {
                executorServiceB = map2.get(Integer.valueOf(i11));
                if (executorServiceB == null) {
                    executorServiceB = g.b(i10, i11);
                    map2.put(Integer.valueOf(i11), executorServiceB);
                }
            }
        }
        return executorServiceB;
    }

    public static <T> void p(f<T> fVar, long j10, TimeUnit timeUnit, @g.f0(from = 1, to = g1.a.f28860g) int i10) {
        j(o0(-2, i10), fVar, 0L, j10, timeUnit);
    }

    public static ExecutorService p0() {
        return n0(-1);
    }

    public static <T> void q(f<T> fVar, long j10, TimeUnit timeUnit) {
        c0(n0(-2), fVar, j10, timeUnit);
    }

    public static ExecutorService q0(@g.f0(from = 1, to = g1.a.f28860g) int i10) {
        return o0(-1, i10);
    }

    public static <T> void r(f<T> fVar, long j10, TimeUnit timeUnit, @g.f0(from = 1, to = g1.a.f28860g) int i10) {
        c0(o0(-2, i10), fVar, j10, timeUnit);
    }

    public static boolean r0() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static <T> void s(f<T> fVar) {
        h(n0(-8), fVar);
    }

    public static void s0(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            f11611a.post(runnable);
        }
    }

    public static <T> void t(f<T> fVar, @g.f0(from = 1, to = g1.a.f28860g) int i10) {
        h(o0(-8, i10), fVar);
    }

    public static void t0(Runnable runnable, long j10) {
        f11611a.postDelayed(runnable, j10);
    }

    public static <T> void u(f<T> fVar, long j10, long j11, TimeUnit timeUnit) {
        j(n0(-8), fVar, j10, j11, timeUnit);
    }

    public static void u0(Executor executor) {
        f11620j = executor;
    }

    public static <T> void v(f<T> fVar, long j10, long j11, TimeUnit timeUnit, @g.f0(from = 1, to = g1.a.f28860g) int i10) {
        j(o0(-8, i10), fVar, j10, j11, timeUnit);
    }

    public static <T> void w(f<T> fVar, long j10, TimeUnit timeUnit) {
        j(n0(-8), fVar, 0L, j10, timeUnit);
    }

    public static <T> void x(f<T> fVar, long j10, TimeUnit timeUnit, @g.f0(from = 1, to = g1.a.f28860g) int i10) {
        j(o0(-8, i10), fVar, 0L, j10, timeUnit);
    }

    public static <T> void y(f<T> fVar, long j10, TimeUnit timeUnit) {
        c0(n0(-8), fVar, j10, timeUnit);
    }

    public static <T> void z(f<T> fVar, long j10, TimeUnit timeUnit, @g.f0(from = 1, to = g1.a.f28860g) int i10) {
        c0(o0(-8, i10), fVar, j10, timeUnit);
    }

    public static final class LinkedBlockingQueue4Util extends LinkedBlockingQueue<Runnable> {
        private int mCapacity;
        private volatile g mPool;

        public LinkedBlockingQueue4Util() {
            this.mCapacity = Integer.MAX_VALUE;
        }

        @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean offer(@g.n0 Runnable runnable) {
            Objects.requireNonNull(runnable, "Argument 'runnable' of type Runnable (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            if (this.mCapacity > size() || this.mPool == null || this.mPool.getPoolSize() >= this.mPool.getMaximumPoolSize()) {
                return super.offer(runnable);
            }
            return false;
        }

        public LinkedBlockingQueue4Util(boolean z10) {
            this.mCapacity = Integer.MAX_VALUE;
            if (z10) {
                this.mCapacity = 0;
            }
        }

        public LinkedBlockingQueue4Util(int i10) {
            this.mCapacity = i10;
        }
    }
}
