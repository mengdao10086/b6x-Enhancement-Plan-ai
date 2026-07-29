.class final Lio/reactivex/internal/schedulers/ExecutorScheduler$ExecutorWorker$InterruptibleRunnable;
.super Ljava/util/concurrent/atomic/AtomicInteger;
.source "ExecutorScheduler.java"

# interfaces
.implements Ljava/lang/Runnable;
.implements Lio/reactivex/disposables/Disposable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/schedulers/ExecutorScheduler$ExecutorWorker;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "InterruptibleRunnable"
.end annotation


# static fields
.field static final FINISHED:I = 0x2

.field static final INTERRUPTED:I = 0x4

.field static final INTERRUPTING:I = 0x3

.field static final READY:I = 0x0

.field static final RUNNING:I = 0x1

.field private static final serialVersionUID:J = -0x3201fa934be19cacL


# instance fields
.field final run:Ljava/lang/Runnable;

.field final tasks:Lio/reactivex/internal/disposables/DisposableContainer;

.field volatile thread:Ljava/lang/Thread;


# direct methods
.method constructor <init>(Ljava/lang/Runnable;Lio/reactivex/internal/disposables/DisposableContainer;)V
    .registers 3

    invoke-direct {p0}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/schedulers/ExecutorScheduler$ExecutorWorker$InterruptibleRunnable;->run:Ljava/lang/Runnable;

    iput-object p2, p0, Lio/reactivex/internal/schedulers/ExecutorScheduler$ExecutorWorker$InterruptibleRunnable;->tasks:Lio/reactivex/internal/disposables/DisposableContainer;

    return-void
.end method


# virtual methods
.method cleanup()V
    .registers 2

    iget-object v0, p0, Lio/reactivex/internal/schedulers/ExecutorScheduler$ExecutorWorker$InterruptibleRunnable;->tasks:Lio/reactivex/internal/disposables/DisposableContainer;

    if-eqz v0, :cond_7

    invoke-interface {v0, p0}, Lio/reactivex/internal/disposables/DisposableContainer;->delete(Lio/reactivex/disposables/Disposable;)Z

    :cond_7
    return-void
.end method

.method public dispose()V
    .registers 4

    :cond_0
    invoke-virtual {p0}, Lio/reactivex/internal/schedulers/ExecutorScheduler$ExecutorWorker$InterruptibleRunnable;->get()I

    move-result v0

    const/4 v1, 0x2

    if-lt v0, v1, :cond_8

    goto :goto_2e

    :cond_8
    const/4 v1, 0x4

    if-nez v0, :cond_16

    const/4 v0, 0x0

    invoke-virtual {p0, v0, v1}, Lio/reactivex/internal/schedulers/ExecutorScheduler$ExecutorWorker$InterruptibleRunnable;->compareAndSet(II)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lio/reactivex/internal/schedulers/ExecutorScheduler$ExecutorWorker$InterruptibleRunnable;->cleanup()V

    goto :goto_2e

    :cond_16
    const/4 v0, 0x1

    const/4 v2, 0x3

    invoke-virtual {p0, v0, v2}, Lio/reactivex/internal/schedulers/ExecutorScheduler$ExecutorWorker$InterruptibleRunnable;->compareAndSet(II)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lio/reactivex/internal/schedulers/ExecutorScheduler$ExecutorWorker$InterruptibleRunnable;->thread:Ljava/lang/Thread;

    if-eqz v0, :cond_28

    invoke-virtual {v0}, Ljava/lang/Thread;->interrupt()V

    const/4 v0, 0x0

    iput-object v0, p0, Lio/reactivex/internal/schedulers/ExecutorScheduler$ExecutorWorker$InterruptibleRunnable;->thread:Ljava/lang/Thread;

    :cond_28
    invoke-virtual {p0, v1}, Lio/reactivex/internal/schedulers/ExecutorScheduler$ExecutorWorker$InterruptibleRunnable;->set(I)V

    invoke-virtual {p0}, Lio/reactivex/internal/schedulers/ExecutorScheduler$ExecutorWorker$InterruptibleRunnable;->cleanup()V

    :goto_2e
    return-void
.end method

.method public isDisposed()Z
    .registers 3

    invoke-virtual {p0}, Lio/reactivex/internal/schedulers/ExecutorScheduler$ExecutorWorker$InterruptibleRunnable;->get()I

    move-result v0

    const/4 v1, 0x2

    if-lt v0, v1, :cond_9

    const/4 v0, 0x1

    goto :goto_a

    :cond_9
    const/4 v0, 0x0

    :goto_a
    return v0
.end method

.method public run()V
    .registers 6

    invoke-virtual {p0}, Lio/reactivex/internal/schedulers/ExecutorScheduler$ExecutorWorker$InterruptibleRunnable;->get()I

    move-result v0

    if-nez v0, :cond_53

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    iput-object v0, p0, Lio/reactivex/internal/schedulers/ExecutorScheduler$ExecutorWorker$InterruptibleRunnable;->thread:Ljava/lang/Thread;

    const/4 v0, 0x0

    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Lio/reactivex/internal/schedulers/ExecutorScheduler$ExecutorWorker$InterruptibleRunnable;->compareAndSet(II)Z

    move-result v0

    const/4 v2, 0x0

    if-eqz v0, :cond_51

    const/4 v0, 0x3

    const/4 v3, 0x2

    :try_start_17
    iget-object v4, p0, Lio/reactivex/internal/schedulers/ExecutorScheduler$ExecutorWorker$InterruptibleRunnable;->run:Ljava/lang/Runnable;

    invoke-interface {v4}, Ljava/lang/Runnable;->run()V
    :try_end_1c
    .catchall {:try_start_17 .. :try_end_1c} :catchall_36

    iput-object v2, p0, Lio/reactivex/internal/schedulers/ExecutorScheduler$ExecutorWorker$InterruptibleRunnable;->thread:Ljava/lang/Thread;

    invoke-virtual {p0, v1, v3}, Lio/reactivex/internal/schedulers/ExecutorScheduler$ExecutorWorker$InterruptibleRunnable;->compareAndSet(II)Z

    move-result v1

    if-eqz v1, :cond_28

    invoke-virtual {p0}, Lio/reactivex/internal/schedulers/ExecutorScheduler$ExecutorWorker$InterruptibleRunnable;->cleanup()V

    goto :goto_53

    :cond_28
    :goto_28
    invoke-virtual {p0}, Lio/reactivex/internal/schedulers/ExecutorScheduler$ExecutorWorker$InterruptibleRunnable;->get()I

    move-result v1

    if-ne v1, v0, :cond_32

    invoke-static {}, Ljava/lang/Thread;->yield()V

    goto :goto_28

    :cond_32
    invoke-static {}, Ljava/lang/Thread;->interrupted()Z

    goto :goto_53

    :catchall_36
    move-exception v4

    iput-object v2, p0, Lio/reactivex/internal/schedulers/ExecutorScheduler$ExecutorWorker$InterruptibleRunnable;->thread:Ljava/lang/Thread;

    invoke-virtual {p0, v1, v3}, Lio/reactivex/internal/schedulers/ExecutorScheduler$ExecutorWorker$InterruptibleRunnable;->compareAndSet(II)Z

    move-result v1

    if-nez v1, :cond_4d

    :goto_3f
    invoke-virtual {p0}, Lio/reactivex/internal/schedulers/ExecutorScheduler$ExecutorWorker$InterruptibleRunnable;->get()I

    move-result v1

    if-ne v1, v0, :cond_49

    invoke-static {}, Ljava/lang/Thread;->yield()V

    goto :goto_3f

    :cond_49
    invoke-static {}, Ljava/lang/Thread;->interrupted()Z

    goto :goto_50

    :cond_4d
    invoke-virtual {p0}, Lio/reactivex/internal/schedulers/ExecutorScheduler$ExecutorWorker$InterruptibleRunnable;->cleanup()V

    :goto_50
    throw v4

    :cond_51
    iput-object v2, p0, Lio/reactivex/internal/schedulers/ExecutorScheduler$ExecutorWorker$InterruptibleRunnable;->thread:Ljava/lang/Thread;

    :cond_53
    :goto_53
    return-void
.end method
