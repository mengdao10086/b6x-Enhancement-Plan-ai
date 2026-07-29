package androidx.work;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.RestrictTo;
import g.f0;
import g.n0;
import g.p0;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @SuppressLint({"MinMaxConstant"})
    public static final int f8312m = 20;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final Executor f8313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final Executor f8314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final y f8315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final k f8316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final t f8317e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public final i f8318f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public final String f8319g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f8320h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f8321i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f8322j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f8323k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f8324l;

    /* JADX INFO: renamed from: androidx.work.a$a, reason: collision with other inner class name */
    public class ThreadFactoryC0080a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f8325a = new AtomicInteger(0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f8326b;

        public ThreadFactoryC0080a(final boolean val$isTaskExecutor) {
            this.f8326b = val$isTaskExecutor;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, (this.f8326b ? "WM.task-" : "androidx.work-") + this.f8325a.incrementAndGet());
        }
    }

    public interface c {
        @n0
        a c();
    }

    public a(@n0 b builder) {
        Executor executor = builder.f8328a;
        if (executor == null) {
            this.f8313a = a(false);
        } else {
            this.f8313a = executor;
        }
        Executor executor2 = builder.f8331d;
        if (executor2 == null) {
            this.f8324l = true;
            this.f8314b = a(true);
        } else {
            this.f8324l = false;
            this.f8314b = executor2;
        }
        y yVar = builder.f8329b;
        if (yVar == null) {
            this.f8315c = y.c();
        } else {
            this.f8315c = yVar;
        }
        k kVar = builder.f8330c;
        if (kVar == null) {
            this.f8316d = k.c();
        } else {
            this.f8316d = kVar;
        }
        t tVar = builder.f8332e;
        if (tVar == null) {
            this.f8317e = new l2.a();
        } else {
            this.f8317e = tVar;
        }
        this.f8320h = builder.f8335h;
        this.f8321i = builder.f8336i;
        this.f8322j = builder.f8337j;
        this.f8323k = builder.f8338k;
        this.f8318f = builder.f8333f;
        this.f8319g = builder.f8334g;
    }

    @n0
    public final Executor a(boolean isTaskExecutor) {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), b(isTaskExecutor));
    }

    @n0
    public final ThreadFactory b(boolean isTaskExecutor) {
        return new ThreadFactoryC0080a(isTaskExecutor);
    }

    @p0
    public String c() {
        return this.f8319g;
    }

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public i d() {
        return this.f8318f;
    }

    @n0
    public Executor e() {
        return this.f8313a;
    }

    @n0
    public k f() {
        return this.f8316d;
    }

    public int g() {
        return this.f8322j;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @f0(from = 20, to = 50)
    public int h() {
        return Build.VERSION.SDK_INT == 23 ? this.f8323k / 2 : this.f8323k;
    }

    public int i() {
        return this.f8321i;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int j() {
        return this.f8320h;
    }

    @n0
    public t k() {
        return this.f8317e;
    }

    @n0
    public Executor l() {
        return this.f8314b;
    }

    @n0
    public y m() {
        return this.f8315c;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean n() {
        return this.f8324l;
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Executor f8328a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public y f8329b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public k f8330c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Executor f8331d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public t f8332e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @p0
        public i f8333f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @p0
        public String f8334g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f8335h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f8336i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f8337j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f8338k;

        public b() {
            this.f8335h = 4;
            this.f8336i = 0;
            this.f8337j = Integer.MAX_VALUE;
            this.f8338k = 20;
        }

        @n0
        public a a() {
            return new a(this);
        }

        @n0
        public b b(@n0 String processName) {
            this.f8334g = processName;
            return this;
        }

        @n0
        public b c(@n0 Executor executor) {
            this.f8328a = executor;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @n0
        public b d(@n0 i exceptionHandler) {
            this.f8333f = exceptionHandler;
            return this;
        }

        @n0
        public b e(@n0 k inputMergerFactory) {
            this.f8330c = inputMergerFactory;
            return this;
        }

        @n0
        public b f(int minJobSchedulerId, int maxJobSchedulerId) {
            if (maxJobSchedulerId - minJobSchedulerId < 1000) {
                throw new IllegalArgumentException("WorkManager needs a range of at least 1000 job ids.");
            }
            this.f8336i = minJobSchedulerId;
            this.f8337j = maxJobSchedulerId;
            return this;
        }

        @n0
        public b g(int maxSchedulerLimit) {
            if (maxSchedulerLimit < 20) {
                throw new IllegalArgumentException("WorkManager needs to be able to schedule at least 20 jobs in JobScheduler.");
            }
            this.f8338k = Math.min(maxSchedulerLimit, 50);
            return this;
        }

        @n0
        public b h(int loggingLevel) {
            this.f8335h = loggingLevel;
            return this;
        }

        @n0
        public b i(@n0 t runnableScheduler) {
            this.f8332e = runnableScheduler;
            return this;
        }

        @n0
        public b j(@n0 Executor taskExecutor) {
            this.f8331d = taskExecutor;
            return this;
        }

        @n0
        public b k(@n0 y workerFactory) {
            this.f8329b = workerFactory;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public b(@n0 a configuration) {
            this.f8328a = configuration.f8313a;
            this.f8329b = configuration.f8315c;
            this.f8330c = configuration.f8316d;
            this.f8331d = configuration.f8314b;
            this.f8335h = configuration.f8320h;
            this.f8336i = configuration.f8321i;
            this.f8337j = configuration.f8322j;
            this.f8338k = configuration.f8323k;
            this.f8332e = configuration.f8317e;
            this.f8333f = configuration.f8318f;
            this.f8334g = configuration.f8319g;
        }
    }
}
