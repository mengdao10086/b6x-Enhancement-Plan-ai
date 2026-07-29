package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.queue.MpscLinkedQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class ExecutorScheduler extends h0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h0 f35108e = lj.b.g();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f35109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @bj.e
    public final Executor f35110d;

    public static final class DelayedRunnable extends AtomicReference<Runnable> implements Runnable, io.reactivex.disposables.b, lj.a {
        private static final long serialVersionUID = -4101336210206799084L;
        public final SequentialDisposable direct;
        public final SequentialDisposable timed;

        public DelayedRunnable(Runnable runnable) {
            super(runnable);
            this.timed = new SequentialDisposable();
            this.direct = new SequentialDisposable();
        }

        @Override // lj.a
        public Runnable a() {
            Runnable runnable = get();
            return runnable != null ? runnable : Functions.f32980b;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (getAndSet(null) != null) {
                this.timed.dispose();
                this.direct.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == null;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = get();
            if (runnable != null) {
                try {
                    runnable.run();
                    lazySet(null);
                    SequentialDisposable sequentialDisposable = this.timed;
                    DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                    sequentialDisposable.lazySet(disposableHelper);
                    this.direct.lazySet(disposableHelper);
                } catch (Throwable th2) {
                    lazySet(null);
                    this.timed.lazySet(DisposableHelper.DISPOSED);
                    this.direct.lazySet(DisposableHelper.DISPOSED);
                    throw th2;
                }
            }
        }
    }

    public static final class ExecutorWorker extends h0.c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f35111a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f35112b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile boolean f35114d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicInteger f35115e = new AtomicInteger();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final io.reactivex.disposables.a f35116f = new io.reactivex.disposables.a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final MpscLinkedQueue<Runnable> f35113c = new MpscLinkedQueue<>();

        public static final class BooleanRunnable extends AtomicBoolean implements Runnable, io.reactivex.disposables.b {
            private static final long serialVersionUID = -2421395018820541164L;
            public final Runnable actual;

            public BooleanRunnable(Runnable runnable) {
                this.actual = runnable;
            }

            @Override // io.reactivex.disposables.b
            public void dispose() {
                lazySet(true);
            }

            @Override // io.reactivex.disposables.b
            public boolean isDisposed() {
                return get();
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get()) {
                    return;
                }
                try {
                    this.actual.run();
                } finally {
                    lazySet(true);
                }
            }
        }

        public static final class InterruptibleRunnable extends AtomicInteger implements Runnable, io.reactivex.disposables.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final int f35117a = 0;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final int f35118b = 1;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final int f35119c = 2;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static final int f35120d = 3;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final int f35121e = 4;
            private static final long serialVersionUID = -3603436687413320876L;
            public final Runnable run;
            public final ej.a tasks;
            public volatile Thread thread;

            public InterruptibleRunnable(Runnable runnable, ej.a aVar) {
                this.run = runnable;
                this.tasks = aVar;
            }

            public void a() {
                ej.a aVar = this.tasks;
                if (aVar != null) {
                    aVar.c(this);
                }
            }

            @Override // io.reactivex.disposables.b
            public void dispose() {
                while (true) {
                    int i10 = get();
                    if (i10 >= 2) {
                        return;
                    }
                    if (i10 == 0) {
                        if (compareAndSet(0, 4)) {
                            a();
                            return;
                        }
                    } else if (compareAndSet(1, 3)) {
                        Thread thread = this.thread;
                        if (thread != null) {
                            thread.interrupt();
                            this.thread = null;
                        }
                        set(4);
                        a();
                        return;
                    }
                }
            }

            @Override // io.reactivex.disposables.b
            public boolean isDisposed() {
                return get() >= 2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get() == 0) {
                    this.thread = Thread.currentThread();
                    if (!compareAndSet(0, 1)) {
                        this.thread = null;
                        return;
                    }
                    try {
                        this.run.run();
                        this.thread = null;
                        if (compareAndSet(1, 2)) {
                            a();
                            return;
                        }
                        while (get() == 3) {
                            Thread.yield();
                        }
                        Thread.interrupted();
                    } catch (Throwable th2) {
                        this.thread = null;
                        if (compareAndSet(1, 2)) {
                            a();
                        } else {
                            while (get() == 3) {
                                Thread.yield();
                            }
                            Thread.interrupted();
                        }
                        throw th2;
                    }
                }
            }
        }

        public final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final SequentialDisposable f35122a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Runnable f35123b;

            public a(SequentialDisposable sequentialDisposable, Runnable runnable) {
                this.f35122a = sequentialDisposable;
                this.f35123b = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f35122a.a(ExecutorWorker.this.b(this.f35123b));
            }
        }

        public ExecutorWorker(Executor executor, boolean z10) {
            this.f35112b = executor;
            this.f35111a = z10;
        }

        @Override // xi.h0.c
        @bj.e
        public io.reactivex.disposables.b b(@bj.e Runnable runnable) {
            io.reactivex.disposables.b booleanRunnable;
            if (this.f35114d) {
                return EmptyDisposable.INSTANCE;
            }
            Runnable runnableB0 = kj.a.b0(runnable);
            if (this.f35111a) {
                booleanRunnable = new InterruptibleRunnable(runnableB0, this.f35116f);
                this.f35116f.b(booleanRunnable);
            } else {
                booleanRunnable = new BooleanRunnable(runnableB0);
            }
            this.f35113c.offer(booleanRunnable);
            if (this.f35115e.getAndIncrement() == 0) {
                try {
                    this.f35112b.execute(this);
                } catch (RejectedExecutionException e10) {
                    this.f35114d = true;
                    this.f35113c.clear();
                    kj.a.Y(e10);
                    return EmptyDisposable.INSTANCE;
                }
            }
            return booleanRunnable;
        }

        @Override // xi.h0.c
        @bj.e
        public io.reactivex.disposables.b c(@bj.e Runnable runnable, long j10, @bj.e TimeUnit timeUnit) {
            if (j10 <= 0) {
                return b(runnable);
            }
            if (this.f35114d) {
                return EmptyDisposable.INSTANCE;
            }
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(new a(sequentialDisposable2, kj.a.b0(runnable)), this.f35116f);
            this.f35116f.b(scheduledRunnable);
            Executor executor = this.f35112b;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    scheduledRunnable.a(((ScheduledExecutorService) executor).schedule((Callable) scheduledRunnable, j10, timeUnit));
                } catch (RejectedExecutionException e10) {
                    this.f35114d = true;
                    kj.a.Y(e10);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                scheduledRunnable.a(new b(ExecutorScheduler.f35108e.g(scheduledRunnable, j10, timeUnit)));
            }
            sequentialDisposable.a(scheduledRunnable);
            return sequentialDisposable2;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f35114d) {
                return;
            }
            this.f35114d = true;
            this.f35116f.dispose();
            if (this.f35115e.getAndIncrement() == 0) {
                this.f35113c.clear();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f35114d;
        }

        @Override // java.lang.Runnable
        public void run() {
            MpscLinkedQueue<Runnable> mpscLinkedQueue = this.f35113c;
            int iAddAndGet = 1;
            while (!this.f35114d) {
                do {
                    Runnable runnablePoll = mpscLinkedQueue.poll();
                    if (runnablePoll != null) {
                        runnablePoll.run();
                    } else if (this.f35114d) {
                        mpscLinkedQueue.clear();
                        return;
                    } else {
                        iAddAndGet = this.f35115e.addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    }
                } while (!this.f35114d);
                mpscLinkedQueue.clear();
                return;
            }
            mpscLinkedQueue.clear();
        }
    }

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DelayedRunnable f35125a;

        public a(DelayedRunnable delayedRunnable) {
            this.f35125a = delayedRunnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            DelayedRunnable delayedRunnable = this.f35125a;
            delayedRunnable.direct.a(ExecutorScheduler.this.f(delayedRunnable));
        }
    }

    public ExecutorScheduler(@bj.e Executor executor, boolean z10) {
        this.f35110d = executor;
        this.f35109c = z10;
    }

    @Override // xi.h0
    @bj.e
    public h0.c d() {
        return new ExecutorWorker(this.f35110d, this.f35109c);
    }

    @Override // xi.h0
    @bj.e
    public io.reactivex.disposables.b f(@bj.e Runnable runnable) {
        Runnable runnableB0 = kj.a.b0(runnable);
        try {
            if (this.f35110d instanceof ExecutorService) {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(runnableB0);
                scheduledDirectTask.b(((ExecutorService) this.f35110d).submit(scheduledDirectTask));
                return scheduledDirectTask;
            }
            if (this.f35109c) {
                ExecutorWorker.InterruptibleRunnable interruptibleRunnable = new ExecutorWorker.InterruptibleRunnable(runnableB0, null);
                this.f35110d.execute(interruptibleRunnable);
                return interruptibleRunnable;
            }
            ExecutorWorker.BooleanRunnable booleanRunnable = new ExecutorWorker.BooleanRunnable(runnableB0);
            this.f35110d.execute(booleanRunnable);
            return booleanRunnable;
        } catch (RejectedExecutionException e10) {
            kj.a.Y(e10);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // xi.h0
    @bj.e
    public io.reactivex.disposables.b g(@bj.e Runnable runnable, long j10, TimeUnit timeUnit) {
        Runnable runnableB0 = kj.a.b0(runnable);
        if (!(this.f35110d instanceof ScheduledExecutorService)) {
            DelayedRunnable delayedRunnable = new DelayedRunnable(runnableB0);
            delayedRunnable.timed.a(f35108e.g(new a(delayedRunnable), j10, timeUnit));
            return delayedRunnable;
        }
        try {
            ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(runnableB0);
            scheduledDirectTask.b(((ScheduledExecutorService) this.f35110d).schedule(scheduledDirectTask, j10, timeUnit));
            return scheduledDirectTask;
        } catch (RejectedExecutionException e10) {
            kj.a.Y(e10);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // xi.h0
    @bj.e
    public io.reactivex.disposables.b h(@bj.e Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        if (!(this.f35110d instanceof ScheduledExecutorService)) {
            return super.h(runnable, j10, j11, timeUnit);
        }
        try {
            ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(kj.a.b0(runnable));
            scheduledDirectPeriodicTask.b(((ScheduledExecutorService) this.f35110d).scheduleAtFixedRate(scheduledDirectPeriodicTask, j10, j11, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e10) {
            kj.a.Y(e10);
            return EmptyDisposable.INSTANCE;
        }
    }
}
