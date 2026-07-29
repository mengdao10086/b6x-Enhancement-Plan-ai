.class final Lio/reactivex/internal/schedulers/ComputationScheduler$FixedSchedulerPool;
.super Ljava/lang/Object;
.source "ComputationScheduler.java"

# interfaces
.implements Lio/reactivex/internal/schedulers/SchedulerMultiWorkerSupport;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/schedulers/ComputationScheduler;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "FixedSchedulerPool"
.end annotation


# instance fields
.field final cores:I

.field final eventLoops:[Lio/reactivex/internal/schedulers/ComputationScheduler$PoolWorker;

.field n:J


# direct methods
.method constructor <init>(ILjava/util/concurrent/ThreadFactory;)V
    .registers 6

    .line 77
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 79
    iput p1, p0, Lio/reactivex/internal/schedulers/ComputationScheduler$FixedSchedulerPool;->cores:I

    .line 80
    new-array v0, p1, [Lio/reactivex/internal/schedulers/ComputationScheduler$PoolWorker;

    iput-object v0, p0, Lio/reactivex/internal/schedulers/ComputationScheduler$FixedSchedulerPool;->eventLoops:[Lio/reactivex/internal/schedulers/ComputationScheduler$PoolWorker;

    const/4 v0, 0x0

    :goto_a
    if-ge v0, p1, :cond_18

    .line 82
    iget-object v1, p0, Lio/reactivex/internal/schedulers/ComputationScheduler$FixedSchedulerPool;->eventLoops:[Lio/reactivex/internal/schedulers/ComputationScheduler$PoolWorker;

    new-instance v2, Lio/reactivex/internal/schedulers/ComputationScheduler$PoolWorker;

    invoke-direct {v2, p2}, Lio/reactivex/internal/schedulers/ComputationScheduler$PoolWorker;-><init>(Ljava/util/concurrent/ThreadFactory;)V

    aput-object v2, v1, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_a

    :cond_18
    return-void
.end method


# virtual methods
.method public createWorkers(ILio/reactivex/internal/schedulers/SchedulerMultiWorkerSupport$WorkerCallback;)V
    .registers 9

    .line 103
    iget v0, p0, Lio/reactivex/internal/schedulers/ComputationScheduler$FixedSchedulerPool;->cores:I

    const/4 v1, 0x0

    if-nez v0, :cond_f

    :goto_5
    if-ge v1, p1, :cond_2d

    .line 106
    sget-object v0, Lio/reactivex/internal/schedulers/ComputationScheduler;->SHUTDOWN_WORKER:Lio/reactivex/internal/schedulers/ComputationScheduler$PoolWorker;

    invoke-interface {p2, v1, v0}, Lio/reactivex/internal/schedulers/SchedulerMultiWorkerSupport$WorkerCallback;->onWorker(ILio/reactivex/Scheduler$Worker;)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_5

    .line 109
    :cond_f
    iget-wide v2, p0, Lio/reactivex/internal/schedulers/ComputationScheduler$FixedSchedulerPool;->n:J

    long-to-int v2, v2

    rem-int/2addr v2, v0

    move v3, v1

    :goto_14
    if-ge v3, p1, :cond_2a

    .line 111
    new-instance v4, Lio/reactivex/internal/schedulers/ComputationScheduler$EventLoopWorker;

    iget-object v5, p0, Lio/reactivex/internal/schedulers/ComputationScheduler$FixedSchedulerPool;->eventLoops:[Lio/reactivex/internal/schedulers/ComputationScheduler$PoolWorker;

    aget-object v5, v5, v2

    invoke-direct {v4, v5}, Lio/reactivex/internal/schedulers/ComputationScheduler$EventLoopWorker;-><init>(Lio/reactivex/internal/schedulers/ComputationScheduler$PoolWorker;)V

    invoke-interface {p2, v3, v4}, Lio/reactivex/internal/schedulers/SchedulerMultiWorkerSupport$WorkerCallback;->onWorker(ILio/reactivex/Scheduler$Worker;)V

    add-int/lit8 v2, v2, 0x1

    if-ne v2, v0, :cond_27

    move v2, v1

    :cond_27
    add-int/lit8 v3, v3, 0x1

    goto :goto_14

    :cond_2a
    int-to-long p1, v2

    .line 116
    iput-wide p1, p0, Lio/reactivex/internal/schedulers/ComputationScheduler$FixedSchedulerPool;->n:J

    :cond_2d
    return-void
.end method

.method public getEventLoop()Lio/reactivex/internal/schedulers/ComputationScheduler$PoolWorker;
    .registers 7

    .line 87
    iget v0, p0, Lio/reactivex/internal/schedulers/ComputationScheduler$FixedSchedulerPool;->cores:I

    if-nez v0, :cond_7

    .line 89
    sget-object v0, Lio/reactivex/internal/schedulers/ComputationScheduler;->SHUTDOWN_WORKER:Lio/reactivex/internal/schedulers/ComputationScheduler$PoolWorker;

    return-object v0

    .line 92
    :cond_7
    iget-object v1, p0, Lio/reactivex/internal/schedulers/ComputationScheduler$FixedSchedulerPool;->eventLoops:[Lio/reactivex/internal/schedulers/ComputationScheduler$PoolWorker;

    iget-wide v2, p0, Lio/reactivex/internal/schedulers/ComputationScheduler$FixedSchedulerPool;->n:J

    const-wide/16 v4, 0x1

    add-long/2addr v4, v2

    iput-wide v4, p0, Lio/reactivex/internal/schedulers/ComputationScheduler$FixedSchedulerPool;->n:J

    int-to-long v4, v0

    rem-long/2addr v2, v4

    long-to-int v0, v2

    aget-object v0, v1, v0

    return-object v0
.end method

.method public shutdown()V
    .registers 5

    .line 96
    iget-object v0, p0, Lio/reactivex/internal/schedulers/ComputationScheduler$FixedSchedulerPool;->eventLoops:[Lio/reactivex/internal/schedulers/ComputationScheduler$PoolWorker;

    array-length v1, v0

    const/4 v2, 0x0

    :goto_4
    if-ge v2, v1, :cond_e

    aget-object v3, v0, v2

    .line 97
    invoke-virtual {v3}, Lio/reactivex/internal/schedulers/ComputationScheduler$PoolWorker;->dispose()V

    add-int/lit8 v2, v2, 0x1

    goto :goto_4

    :cond_e
    return-void
.end method
