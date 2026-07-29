.class public Lio/reactivex/internal/schedulers/NewThreadWorker;
.super Lio/reactivex/Scheduler$Worker;
.source "NewThreadWorker.java"

# interfaces
.implements Lio/reactivex/disposables/Disposable;


# instance fields
.field volatile disposed:Z

.field private final executor:Ljava/util/concurrent/ScheduledExecutorService;


# direct methods
.method public constructor <init>(Ljava/util/concurrent/ThreadFactory;)V
    .registers 2

    .line 35
    invoke-direct {p0}, Lio/reactivex/Scheduler$Worker;-><init>()V

    .line 36
    invoke-static {p1}, Lio/reactivex/internal/schedulers/SchedulerPoolFactory;->create(Ljava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ScheduledExecutorService;

    move-result-object p1

    iput-object p1, p0, Lio/reactivex/internal/schedulers/NewThreadWorker;->executor:Ljava/util/concurrent/ScheduledExecutorService;

    return-void
.end method


# virtual methods
.method public dispose()V
    .registers 2

    .line 162
    iget-boolean v0, p0, Lio/reactivex/internal/schedulers/NewThreadWorker;->disposed:Z

    if-nez v0, :cond_c

    const/4 v0, 0x1

    .line 163
    iput-boolean v0, p0, Lio/reactivex/internal/schedulers/NewThreadWorker;->disposed:Z

    .line 164
    iget-object v0, p0, Lio/reactivex/internal/schedulers/NewThreadWorker;->executor:Ljava/util/concurrent/ScheduledExecutorService;

    invoke-interface {v0}, Ljava/util/concurrent/ScheduledExecutorService;->shutdownNow()Ljava/util/List;

    :cond_c
    return-void
.end method

.method public isDisposed()Z
    .registers 2

    .line 180
    iget-boolean v0, p0, Lio/reactivex/internal/schedulers/NewThreadWorker;->disposed:Z

    return v0
.end method

.method public schedule(Ljava/lang/Runnable;)Lio/reactivex/disposables/Disposable;
    .registers 5

    const-wide/16 v0, 0x0

    const/4 v2, 0x0

    .line 42
    invoke-virtual {p0, p1, v0, v1, v2}, Lio/reactivex/internal/schedulers/NewThreadWorker;->schedule(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Lio/reactivex/disposables/Disposable;

    move-result-object p1

    return-object p1
.end method

.method public schedule(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Lio/reactivex/disposables/Disposable;
    .registers 11

    .line 48
    iget-boolean v0, p0, Lio/reactivex/internal/schedulers/NewThreadWorker;->disposed:Z

    if-eqz v0, :cond_7

    .line 49
    sget-object p1, Lio/reactivex/internal/disposables/EmptyDisposable;->INSTANCE:Lio/reactivex/internal/disposables/EmptyDisposable;

    return-object p1

    :cond_7
    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-wide v2, p2

    move-object v4, p4

    .line 51
    invoke-virtual/range {v0 .. v5}, Lio/reactivex/internal/schedulers/NewThreadWorker;->scheduleActual(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;Lio/reactivex/internal/disposables/DisposableContainer;)Lio/reactivex/internal/schedulers/ScheduledRunnable;

    move-result-object p1

    return-object p1
.end method

.method public scheduleActual(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;Lio/reactivex/internal/disposables/DisposableContainer;)Lio/reactivex/internal/schedulers/ScheduledRunnable;
    .registers 9

    .line 132
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onSchedule(Ljava/lang/Runnable;)Ljava/lang/Runnable;

    move-result-object p1

    .line 134
    new-instance v0, Lio/reactivex/internal/schedulers/ScheduledRunnable;

    invoke-direct {v0, p1, p5}, Lio/reactivex/internal/schedulers/ScheduledRunnable;-><init>(Ljava/lang/Runnable;Lio/reactivex/internal/disposables/DisposableContainer;)V

    if-eqz p5, :cond_12

    .line 137
    invoke-interface {p5, v0}, Lio/reactivex/internal/disposables/DisposableContainer;->add(Lio/reactivex/disposables/Disposable;)Z

    move-result p1

    if-nez p1, :cond_12

    return-object v0

    :cond_12
    const-wide/16 v1, 0x0

    cmp-long p1, p2, v1

    if-gtz p1, :cond_1f

    .line 145
    :try_start_18
    iget-object p1, p0, Lio/reactivex/internal/schedulers/NewThreadWorker;->executor:Ljava/util/concurrent/ScheduledExecutorService;

    invoke-interface {p1, v0}, Ljava/util/concurrent/ScheduledExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object p1

    goto :goto_25

    .line 147
    :cond_1f
    iget-object p1, p0, Lio/reactivex/internal/schedulers/NewThreadWorker;->executor:Ljava/util/concurrent/ScheduledExecutorService;

    invoke-interface {p1, v0, p2, p3, p4}, Ljava/util/concurrent/ScheduledExecutorService;->schedule(Ljava/util/concurrent/Callable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    move-result-object p1

    .line 149
    :goto_25
    invoke-virtual {v0, p1}, Lio/reactivex/internal/schedulers/ScheduledRunnable;->setFuture(Ljava/util/concurrent/Future;)V
    :try_end_28
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_18 .. :try_end_28} :catch_29

    goto :goto_32

    :catch_29
    move-exception p1

    if-eqz p5, :cond_2f

    .line 152
    invoke-interface {p5, v0}, Lio/reactivex/internal/disposables/DisposableContainer;->remove(Lio/reactivex/disposables/Disposable;)Z

    .line 154
    :cond_2f
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :goto_32
    return-object v0
.end method

.method public scheduleDirect(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Lio/reactivex/disposables/Disposable;
    .registers 8

    .line 63
    new-instance v0, Lio/reactivex/internal/schedulers/ScheduledDirectTask;

    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onSchedule(Ljava/lang/Runnable;)Ljava/lang/Runnable;

    move-result-object p1

    invoke-direct {v0, p1}, Lio/reactivex/internal/schedulers/ScheduledDirectTask;-><init>(Ljava/lang/Runnable;)V

    const-wide/16 v1, 0x0

    cmp-long p1, p2, v1

    if-gtz p1, :cond_16

    .line 67
    :try_start_f
    iget-object p1, p0, Lio/reactivex/internal/schedulers/NewThreadWorker;->executor:Ljava/util/concurrent/ScheduledExecutorService;

    invoke-interface {p1, v0}, Ljava/util/concurrent/ScheduledExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object p1

    goto :goto_1c

    .line 69
    :cond_16
    iget-object p1, p0, Lio/reactivex/internal/schedulers/NewThreadWorker;->executor:Ljava/util/concurrent/ScheduledExecutorService;

    invoke-interface {p1, v0, p2, p3, p4}, Ljava/util/concurrent/ScheduledExecutorService;->schedule(Ljava/util/concurrent/Callable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    move-result-object p1

    .line 71
    :goto_1c
    invoke-virtual {v0, p1}, Lio/reactivex/internal/schedulers/ScheduledDirectTask;->setFuture(Ljava/util/concurrent/Future;)V
    :try_end_1f
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_f .. :try_end_1f} :catch_20

    return-object v0

    :catch_20
    move-exception p1

    .line 74
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    .line 75
    sget-object p1, Lio/reactivex/internal/disposables/EmptyDisposable;->INSTANCE:Lio/reactivex/internal/disposables/EmptyDisposable;

    return-object p1
.end method

.method public schedulePeriodicallyDirect(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Lio/reactivex/disposables/Disposable;
    .registers 15

    .line 89
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onSchedule(Ljava/lang/Runnable;)Ljava/lang/Runnable;

    move-result-object p1

    const-wide/16 v0, 0x0

    cmp-long v2, p4, v0

    if-gtz v2, :cond_2d

    .line 92
    new-instance p4, Lio/reactivex/internal/schedulers/InstantPeriodicTask;

    iget-object p5, p0, Lio/reactivex/internal/schedulers/NewThreadWorker;->executor:Ljava/util/concurrent/ScheduledExecutorService;

    invoke-direct {p4, p1, p5}, Lio/reactivex/internal/schedulers/InstantPeriodicTask;-><init>(Ljava/lang/Runnable;Ljava/util/concurrent/ExecutorService;)V

    cmp-long p1, p2, v0

    if-gtz p1, :cond_1c

    .line 96
    :try_start_15
    iget-object p1, p0, Lio/reactivex/internal/schedulers/NewThreadWorker;->executor:Ljava/util/concurrent/ScheduledExecutorService;

    invoke-interface {p1, p4}, Ljava/util/concurrent/ScheduledExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object p1

    goto :goto_22

    .line 98
    :cond_1c
    iget-object p1, p0, Lio/reactivex/internal/schedulers/NewThreadWorker;->executor:Ljava/util/concurrent/ScheduledExecutorService;

    invoke-interface {p1, p4, p2, p3, p6}, Ljava/util/concurrent/ScheduledExecutorService;->schedule(Ljava/util/concurrent/Callable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    move-result-object p1

    .line 100
    :goto_22
    invoke-virtual {p4, p1}, Lio/reactivex/internal/schedulers/InstantPeriodicTask;->setFirst(Ljava/util/concurrent/Future;)V
    :try_end_25
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_15 .. :try_end_25} :catch_26

    return-object p4

    :catch_26
    move-exception p1

    .line 102
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    .line 103
    sget-object p1, Lio/reactivex/internal/disposables/EmptyDisposable;->INSTANCE:Lio/reactivex/internal/disposables/EmptyDisposable;

    return-object p1

    .line 108
    :cond_2d
    new-instance v7, Lio/reactivex/internal/schedulers/ScheduledDirectPeriodicTask;

    invoke-direct {v7, p1}, Lio/reactivex/internal/schedulers/ScheduledDirectPeriodicTask;-><init>(Ljava/lang/Runnable;)V

    .line 110
    :try_start_32
    iget-object v0, p0, Lio/reactivex/internal/schedulers/NewThreadWorker;->executor:Ljava/util/concurrent/ScheduledExecutorService;

    move-object v1, v7

    move-wide v2, p2

    move-wide v4, p4

    move-object v6, p6

    invoke-interface/range {v0 .. v6}, Ljava/util/concurrent/ScheduledExecutorService;->scheduleAtFixedRate(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    move-result-object p1

    .line 111
    invoke-virtual {v7, p1}, Lio/reactivex/internal/schedulers/ScheduledDirectPeriodicTask;->setFuture(Ljava/util/concurrent/Future;)V
    :try_end_3f
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_32 .. :try_end_3f} :catch_40

    return-object v7

    :catch_40
    move-exception p1

    .line 114
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    .line 115
    sget-object p1, Lio/reactivex/internal/disposables/EmptyDisposable;->INSTANCE:Lio/reactivex/internal/disposables/EmptyDisposable;

    return-object p1
.end method

.method public shutdown()V
    .registers 2

    .line 172
    iget-boolean v0, p0, Lio/reactivex/internal/schedulers/NewThreadWorker;->disposed:Z

    if-nez v0, :cond_c

    const/4 v0, 0x1

    .line 173
    iput-boolean v0, p0, Lio/reactivex/internal/schedulers/NewThreadWorker;->disposed:Z

    .line 174
    iget-object v0, p0, Lio/reactivex/internal/schedulers/NewThreadWorker;->executor:Ljava/util/concurrent/ScheduledExecutorService;

    invoke-interface {v0}, Ljava/util/concurrent/ScheduledExecutorService;->shutdown()V

    :cond_c
    return-void
.end method
