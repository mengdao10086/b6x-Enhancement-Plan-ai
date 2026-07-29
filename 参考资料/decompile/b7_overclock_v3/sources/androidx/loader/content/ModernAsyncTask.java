package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import androidx.annotation.RestrictTo;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ModernAsyncTask<Params, Progress, Result> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f6287f = "AsyncTask";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f6288g = 5;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f6289h = 128;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f6290i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ThreadFactory f6291j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final BlockingQueue<Runnable> f6292k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Executor f6293l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f6294m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f6295n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static f f6296o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static volatile Executor f6297p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g<Params, Result> f6298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FutureTask<Result> f6299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Status f6300c = Status.PENDING;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f6301d = new AtomicBoolean();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f6302e = new AtomicBoolean();

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    public static class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f6303a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.f6303a.getAndIncrement());
        }
    }

    public class b extends g<Params, Result> {
        public b() {
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.util.concurrent.Callable
        public Result call() throws Exception {
            ModernAsyncTask.this.f6302e.set(true);
            Result result = null;
            try {
                Process.setThreadPriority(10);
                result = (Result) ModernAsyncTask.this.b(this.f6309a);
                Binder.flushPendingCommands();
                return result;
            } finally {
            }
        }
    }

    public class c extends FutureTask<Result> {
        public c(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            try {
                ModernAsyncTask.this.r(get());
            } catch (InterruptedException unused) {
            } catch (CancellationException unused2) {
                ModernAsyncTask.this.r(null);
            } catch (ExecutionException e10) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e10.getCause());
            } catch (Throwable th2) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th2);
            }
        }
    }

    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6306a;

        static {
            int[] iArr = new int[Status.values().length];
            f6306a = iArr;
            try {
                iArr[Status.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6306a[Status.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class e<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ModernAsyncTask f6307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Data[] f6308b;

        public e(ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.f6307a = modernAsyncTask;
            this.f6308b = dataArr;
        }
    }

    public static class f extends Handler {
        public f() {
            super(Looper.getMainLooper());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar = (e) message.obj;
            int i10 = message.what;
            if (i10 == 1) {
                eVar.f6307a.f(eVar.f6308b[0]);
            } else {
                if (i10 != 2) {
                    return;
                }
                eVar.f6307a.p(eVar.f6308b);
            }
        }
    }

    public static abstract class g<Params, Result> implements Callable<Result> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Params[] f6309a;
    }

    static {
        a aVar = new a();
        f6291j = aVar;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        f6292k = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, linkedBlockingQueue, aVar);
        f6293l = threadPoolExecutor;
        f6297p = threadPoolExecutor;
    }

    public ModernAsyncTask() {
        b bVar = new b();
        this.f6298a = bVar;
        this.f6299b = new c(bVar);
    }

    public static void d(Runnable runnable) {
        f6297p.execute(runnable);
    }

    public static Handler i() {
        f fVar;
        synchronized (ModernAsyncTask.class) {
            if (f6296o == null) {
                f6296o = new f();
            }
            fVar = f6296o;
        }
        return fVar;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void t(Executor executor) {
        f6297p = executor;
    }

    public final boolean a(boolean z10) {
        this.f6301d.set(true);
        return this.f6299b.cancel(z10);
    }

    public abstract Result b(Params... paramsArr);

    public final ModernAsyncTask<Params, Progress, Result> c(Params... paramsArr) {
        return e(f6297p, paramsArr);
    }

    public final ModernAsyncTask<Params, Progress, Result> e(Executor executor, Params... paramsArr) {
        if (this.f6300c == Status.PENDING) {
            this.f6300c = Status.RUNNING;
            o();
            this.f6298a.f6309a = paramsArr;
            executor.execute(this.f6299b);
            return this;
        }
        int i10 = d.f6306a[this.f6300c.ordinal()];
        if (i10 == 1) {
            throw new IllegalStateException("Cannot execute task: the task is already running.");
        }
        if (i10 != 2) {
            throw new IllegalStateException("We should never reach this state");
        }
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    }

    public void f(Result result) {
        if (k()) {
            m(result);
        } else {
            n(result);
        }
        this.f6300c = Status.FINISHED;
    }

    public final Result g() throws ExecutionException, InterruptedException {
        return this.f6299b.get();
    }

    public final Result h(long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.f6299b.get(j10, timeUnit);
    }

    public final Status j() {
        return this.f6300c;
    }

    public final boolean k() {
        return this.f6301d.get();
    }

    public void l() {
    }

    public void m(Result result) {
        l();
    }

    public void n(Result result) {
    }

    public void o() {
    }

    public void p(Progress... progressArr) {
    }

    public Result q(Result result) {
        i().obtainMessage(1, new e(this, result)).sendToTarget();
        return result;
    }

    public void r(Result result) {
        if (this.f6302e.get()) {
            return;
        }
        q(result);
    }

    public final void s(Progress... progressArr) {
        if (k()) {
            return;
        }
        i().obtainMessage(2, new e(this, progressArr)).sendToTarget();
    }
}
