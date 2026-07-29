.class public abstract Lcom/blankj/utilcode/util/ThreadUtils$Task;
.super Ljava/lang/Object;
.source "ThreadUtils.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/blankj/utilcode/util/ThreadUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Task"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/blankj/utilcode/util/ThreadUtils$Task$OnTimeoutListener;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Ljava/lang/Runnable;"
    }
.end annotation


# static fields
.field private static final CANCELLED:I = 0x4

.field private static final COMPLETING:I = 0x3

.field private static final EXCEPTIONAL:I = 0x2

.field private static final INTERRUPTED:I = 0x5

.field private static final NEW:I = 0x0

.field private static final RUNNING:I = 0x1

.field private static final TIMEOUT:I = 0x6


# instance fields
.field private deliver:Ljava/util/concurrent/Executor;

.field private volatile isSchedule:Z

.field private mTimeoutListener:Lcom/blankj/utilcode/util/ThreadUtils$Task$OnTimeoutListener;

.field private mTimeoutMillis:J

.field private mTimer:Ljava/util/Timer;

.field private volatile runner:Ljava/lang/Thread;

.field private final state:Ljava/util/concurrent/atomic/AtomicInteger;


# direct methods
.method public constructor <init>()V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    iput-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->state:Ljava/util/concurrent/atomic/AtomicInteger;

    return-void
.end method

.method static synthetic access$000(Lcom/blankj/utilcode/util/ThreadUtils$Task;Z)V
    .registers 2

    invoke-direct {p0, p1}, Lcom/blankj/utilcode/util/ThreadUtils$Task;->setSchedule(Z)V

    return-void
.end method

.method static synthetic access$400(Lcom/blankj/utilcode/util/ThreadUtils$Task;)Lcom/blankj/utilcode/util/ThreadUtils$Task$OnTimeoutListener;
    .registers 1

    iget-object p0, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->mTimeoutListener:Lcom/blankj/utilcode/util/ThreadUtils$Task$OnTimeoutListener;

    return-object p0
.end method

.method static synthetic access$500(Lcom/blankj/utilcode/util/ThreadUtils$Task;)V
    .registers 1

    invoke-direct {p0}, Lcom/blankj/utilcode/util/ThreadUtils$Task;->timeout()V

    return-void
.end method

.method private getDeliver()Ljava/util/concurrent/Executor;
    .registers 2

    iget-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->deliver:Ljava/util/concurrent/Executor;

    if-nez v0, :cond_8

    # invokes: Lcom/blankj/utilcode/util/ThreadUtils;->getGlobalDeliver()Ljava/util/concurrent/Executor;
    invoke-static {}, Lcom/blankj/utilcode/util/ThreadUtils;->access$600()Ljava/util/concurrent/Executor;

    move-result-object v0

    :cond_8
    return-object v0
.end method

.method private setSchedule(Z)V
    .registers 2

    iput-boolean p1, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->isSchedule:Z

    return-void
.end method

.method private timeout()V
    .registers 4

    iget-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->state:Ljava/util/concurrent/atomic/AtomicInteger;

    monitor-enter v0

    :try_start_3
    iget-object v1, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->state:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v1

    const/4 v2, 0x1

    if-le v1, v2, :cond_e

    monitor-exit v0

    return-void

    :cond_e
    iget-object v1, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->state:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v2, 0x6

    invoke-virtual {v1, v2}, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V

    monitor-exit v0
    :try_end_15
    .catchall {:try_start_3 .. :try_end_15} :catchall_1f

    iget-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->runner:Ljava/lang/Thread;

    if-eqz v0, :cond_1e

    iget-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->runner:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->interrupt()V

    :cond_1e
    return-void

    :catchall_1f
    move-exception v1

    :try_start_20
    monitor-exit v0
    :try_end_21
    .catchall {:try_start_20 .. :try_end_21} :catchall_1f

    throw v1
.end method


# virtual methods
.method public cancel()V
    .registers 2

    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/blankj/utilcode/util/ThreadUtils$Task;->cancel(Z)V

    return-void
.end method

.method public cancel(Z)V
    .registers 5

    iget-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->state:Ljava/util/concurrent/atomic/AtomicInteger;

    monitor-enter v0

    :try_start_3
    iget-object v1, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->state:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v1

    const/4 v2, 0x1

    if-le v1, v2, :cond_e

    monitor-exit v0

    return-void

    :cond_e
    iget-object v1, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->state:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v2, 0x4

    invoke-virtual {v1, v2}, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V

    monitor-exit v0
    :try_end_15
    .catchall {:try_start_3 .. :try_end_15} :catchall_2d

    if-eqz p1, :cond_20

    iget-object p1, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->runner:Ljava/lang/Thread;

    if-eqz p1, :cond_20

    iget-object p1, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->runner:Ljava/lang/Thread;

    invoke-virtual {p1}, Ljava/lang/Thread;->interrupt()V

    :cond_20
    invoke-direct {p0}, Lcom/blankj/utilcode/util/ThreadUtils$Task;->getDeliver()Ljava/util/concurrent/Executor;

    move-result-object p1

    new-instance v0, Lcom/blankj/utilcode/util/ThreadUtils$Task$5;

    invoke-direct {v0, p0}, Lcom/blankj/utilcode/util/ThreadUtils$Task$5;-><init>(Lcom/blankj/utilcode/util/ThreadUtils$Task;)V

    invoke-interface {p1, v0}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    return-void

    :catchall_2d
    move-exception p1

    :try_start_2e
    monitor-exit v0
    :try_end_2f
    .catchall {:try_start_2e .. :try_end_2f} :catchall_2d

    throw p1
.end method

.method public abstract doInBackground()Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation
.end method

.method public isCanceled()Z
    .registers 3

    iget-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->state:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v0

    const/4 v1, 0x4

    if-lt v0, v1, :cond_b

    const/4 v0, 0x1

    goto :goto_c

    :cond_b
    const/4 v0, 0x0

    :goto_c
    return v0
.end method

.method public isDone()Z
    .registers 3

    iget-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->state:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v0

    const/4 v1, 0x1

    if-le v0, v1, :cond_a

    goto :goto_b

    :cond_a
    const/4 v1, 0x0

    :goto_b
    return v1
.end method

.method public abstract onCancel()V
.end method

.method protected onDone()V
    .registers 2

    # getter for: Lcom/blankj/utilcode/util/ThreadUtils;->TASK_POOL_MAP:Ljava/util/Map;
    invoke-static {}, Lcom/blankj/utilcode/util/ThreadUtils;->access$700()Ljava/util/Map;

    move-result-object v0

    invoke-interface {v0, p0}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->mTimer:Ljava/util/Timer;

    if-eqz v0, :cond_13

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->mTimer:Ljava/util/Timer;

    iput-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->mTimeoutListener:Lcom/blankj/utilcode/util/ThreadUtils$Task$OnTimeoutListener;

    :cond_13
    return-void
.end method

.method public abstract onFail(Ljava/lang/Throwable;)V
.end method

.method public abstract onSuccess(Ljava/lang/Object;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation
.end method

.method public run()V
    .registers 6

    iget-boolean v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->isSchedule:Z

    const/4 v1, 0x0

    const/4 v2, 0x1

    if-eqz v0, :cond_2e

    iget-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->runner:Ljava/lang/Thread;

    if-nez v0, :cond_25

    iget-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->state:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicInteger;->compareAndSet(II)Z

    move-result v0

    if-nez v0, :cond_13

    return-void

    :cond_13
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    iput-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->runner:Ljava/lang/Thread;

    iget-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->mTimeoutListener:Lcom/blankj/utilcode/util/ThreadUtils$Task$OnTimeoutListener;

    if-eqz v0, :cond_52

    const-string v0, "ThreadUtils"

    const-string v1, "Scheduled task doesn\'t support timeout."

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_52

    :cond_25
    iget-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->state:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v0

    if-eq v0, v2, :cond_52

    return-void

    :cond_2e
    iget-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->state:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicInteger;->compareAndSet(II)Z

    move-result v0

    if-nez v0, :cond_37

    return-void

    :cond_37
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    iput-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->runner:Ljava/lang/Thread;

    iget-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->mTimeoutListener:Lcom/blankj/utilcode/util/ThreadUtils$Task$OnTimeoutListener;

    if-eqz v0, :cond_52

    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->mTimer:Ljava/util/Timer;

    new-instance v1, Lcom/blankj/utilcode/util/ThreadUtils$Task$1;

    invoke-direct {v1, p0}, Lcom/blankj/utilcode/util/ThreadUtils$Task$1;-><init>(Lcom/blankj/utilcode/util/ThreadUtils$Task;)V

    iget-wide v3, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->mTimeoutMillis:J

    invoke-virtual {v0, v1, v3, v4}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    :cond_52
    :goto_52
    :try_start_52
    invoke-virtual {p0}, Lcom/blankj/utilcode/util/ThreadUtils$Task;->doInBackground()Ljava/lang/Object;

    move-result-object v0

    iget-boolean v1, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->isSchedule:Z

    if-eqz v1, :cond_70

    iget-object v1, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->state:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v1

    if-eq v1, v2, :cond_63

    return-void

    :cond_63
    invoke-direct {p0}, Lcom/blankj/utilcode/util/ThreadUtils$Task;->getDeliver()Ljava/util/concurrent/Executor;

    move-result-object v1

    new-instance v3, Lcom/blankj/utilcode/util/ThreadUtils$Task$2;

    invoke-direct {v3, p0, v0}, Lcom/blankj/utilcode/util/ThreadUtils$Task$2;-><init>(Lcom/blankj/utilcode/util/ThreadUtils$Task;Ljava/lang/Object;)V

    invoke-interface {v1, v3}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    goto :goto_a6

    :cond_70
    iget-object v1, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->state:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v3, 0x3

    invoke-virtual {v1, v2, v3}, Ljava/util/concurrent/atomic/AtomicInteger;->compareAndSet(II)Z

    move-result v1

    if-nez v1, :cond_7a

    return-void

    :cond_7a
    invoke-direct {p0}, Lcom/blankj/utilcode/util/ThreadUtils$Task;->getDeliver()Ljava/util/concurrent/Executor;

    move-result-object v1

    new-instance v3, Lcom/blankj/utilcode/util/ThreadUtils$Task$3;

    invoke-direct {v3, p0, v0}, Lcom/blankj/utilcode/util/ThreadUtils$Task$3;-><init>(Lcom/blankj/utilcode/util/ThreadUtils$Task;Ljava/lang/Object;)V

    invoke-interface {v1, v3}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V
    :try_end_86
    .catch Ljava/lang/InterruptedException; {:try_start_52 .. :try_end_86} :catch_9f
    .catchall {:try_start_52 .. :try_end_86} :catchall_87

    goto :goto_a6

    :catchall_87
    move-exception v0

    iget-object v1, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->state:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v3, 0x2

    invoke-virtual {v1, v2, v3}, Ljava/util/concurrent/atomic/AtomicInteger;->compareAndSet(II)Z

    move-result v1

    if-nez v1, :cond_92

    return-void

    :cond_92
    invoke-direct {p0}, Lcom/blankj/utilcode/util/ThreadUtils$Task;->getDeliver()Ljava/util/concurrent/Executor;

    move-result-object v1

    new-instance v2, Lcom/blankj/utilcode/util/ThreadUtils$Task$4;

    invoke-direct {v2, p0, v0}, Lcom/blankj/utilcode/util/ThreadUtils$Task$4;-><init>(Lcom/blankj/utilcode/util/ThreadUtils$Task;Ljava/lang/Throwable;)V

    invoke-interface {v1, v2}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    goto :goto_a6

    :catch_9f
    iget-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->state:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v1, 0x4

    const/4 v2, 0x5

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicInteger;->compareAndSet(II)Z

    :goto_a6
    return-void
.end method

.method public setDeliver(Ljava/util/concurrent/Executor;)Lcom/blankj/utilcode/util/ThreadUtils$Task;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/concurrent/Executor;",
            ")",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;"
        }
    .end annotation

    iput-object p1, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->deliver:Ljava/util/concurrent/Executor;

    return-object p0
.end method

.method public setTimeout(JLcom/blankj/utilcode/util/ThreadUtils$Task$OnTimeoutListener;)Lcom/blankj/utilcode/util/ThreadUtils$Task;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task$OnTimeoutListener;",
            ")",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;"
        }
    .end annotation

    iput-wide p1, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->mTimeoutMillis:J

    iput-object p3, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task;->mTimeoutListener:Lcom/blankj/utilcode/util/ThreadUtils$Task$OnTimeoutListener;

    return-object p0
.end method
