.class public final Lio/reactivex/internal/schedulers/ScheduledDirectPeriodicTask;
.super Lio/reactivex/internal/schedulers/AbstractDirectTask;
.source "ScheduledDirectPeriodicTask.java"

# interfaces
.implements Ljava/lang/Runnable;


# static fields
.field private static final serialVersionUID:J = 0x1924f211b909b42fL


# direct methods
.method public constructor <init>(Ljava/lang/Runnable;)V
    .registers 2

    invoke-direct {p0, p1}, Lio/reactivex/internal/schedulers/AbstractDirectTask;-><init>(Ljava/lang/Runnable;)V

    return-void
.end method


# virtual methods
.method public bridge synthetic getWrappedRunnable()Ljava/lang/Runnable;
    .registers 2

    invoke-super {p0}, Lio/reactivex/internal/schedulers/AbstractDirectTask;->getWrappedRunnable()Ljava/lang/Runnable;

    move-result-object v0

    return-object v0
.end method

.method public run()V
    .registers 3

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    iput-object v0, p0, Lio/reactivex/internal/schedulers/ScheduledDirectPeriodicTask;->runner:Ljava/lang/Thread;

    const/4 v0, 0x0

    :try_start_7
    iget-object v1, p0, Lio/reactivex/internal/schedulers/ScheduledDirectPeriodicTask;->runnable:Ljava/lang/Runnable;

    invoke-interface {v1}, Ljava/lang/Runnable;->run()V

    iput-object v0, p0, Lio/reactivex/internal/schedulers/ScheduledDirectPeriodicTask;->runner:Ljava/lang/Thread;
    :try_end_e
    .catchall {:try_start_7 .. :try_end_e} :catchall_f

    goto :goto_1a

    :catchall_f
    move-exception v1

    iput-object v0, p0, Lio/reactivex/internal/schedulers/ScheduledDirectPeriodicTask;->runner:Ljava/lang/Thread;

    sget-object v0, Lio/reactivex/internal/schedulers/ScheduledDirectPeriodicTask;->FINISHED:Ljava/util/concurrent/FutureTask;

    invoke-virtual {p0, v0}, Lio/reactivex/internal/schedulers/ScheduledDirectPeriodicTask;->lazySet(Ljava/lang/Object;)V

    invoke-static {v1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :goto_1a
    return-void
.end method
