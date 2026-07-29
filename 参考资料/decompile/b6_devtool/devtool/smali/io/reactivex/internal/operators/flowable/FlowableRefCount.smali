.class public final Lio/reactivex/internal/operators/flowable/FlowableRefCount;
.super Lio/reactivex/Flowable;
.source "FlowableRefCount.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefCountSubscriber;,
        Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lio/reactivex/Flowable<",
        "TT;>;"
    }
.end annotation


# instance fields
.field connection:Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;

.field final n:I

.field final scheduler:Lio/reactivex/Scheduler;

.field final source:Lio/reactivex/flowables/ConnectableFlowable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/flowables/ConnectableFlowable<",
            "TT;>;"
        }
    .end annotation
.end field

.field final timeout:J

.field final unit:Ljava/util/concurrent/TimeUnit;


# direct methods
.method public constructor <init>(Lio/reactivex/flowables/ConnectableFlowable;)V
    .registers 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/flowables/ConnectableFlowable<",
            "TT;>;)V"
        }
    .end annotation

    const/4 v2, 0x1

    const-wide/16 v3, 0x0

    sget-object v5, Ljava/util/concurrent/TimeUnit;->NANOSECONDS:Ljava/util/concurrent/TimeUnit;

    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p1

    invoke-direct/range {v0 .. v6}, Lio/reactivex/internal/operators/flowable/FlowableRefCount;-><init>(Lio/reactivex/flowables/ConnectableFlowable;IJLjava/util/concurrent/TimeUnit;Lio/reactivex/Scheduler;)V

    return-void
.end method

.method public constructor <init>(Lio/reactivex/flowables/ConnectableFlowable;IJLjava/util/concurrent/TimeUnit;Lio/reactivex/Scheduler;)V
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/flowables/ConnectableFlowable<",
            "TT;>;IJ",
            "Ljava/util/concurrent/TimeUnit;",
            "Lio/reactivex/Scheduler;",
            ")V"
        }
    .end annotation

    invoke-direct {p0}, Lio/reactivex/Flowable;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableRefCount;->source:Lio/reactivex/flowables/ConnectableFlowable;

    iput p2, p0, Lio/reactivex/internal/operators/flowable/FlowableRefCount;->n:I

    iput-wide p3, p0, Lio/reactivex/internal/operators/flowable/FlowableRefCount;->timeout:J

    iput-object p5, p0, Lio/reactivex/internal/operators/flowable/FlowableRefCount;->unit:Ljava/util/concurrent/TimeUnit;

    iput-object p6, p0, Lio/reactivex/internal/operators/flowable/FlowableRefCount;->scheduler:Lio/reactivex/Scheduler;

    return-void
.end method


# virtual methods
.method cancel(Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;)V
    .registers 7

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableRefCount;->connection:Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;

    if-eqz v0, :cond_3d

    if-eq v0, p1, :cond_8

    goto :goto_3d

    :cond_8
    iget-wide v0, p1, Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;->subscriberCount:J

    const-wide/16 v2, 0x1

    sub-long/2addr v0, v2

    iput-wide v0, p1, Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;->subscriberCount:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_3b

    iget-boolean v0, p1, Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;->connected:Z

    if-nez v0, :cond_1a

    goto :goto_3b

    :cond_1a
    iget-wide v0, p0, Lio/reactivex/internal/operators/flowable/FlowableRefCount;->timeout:J

    cmp-long v0, v0, v2

    if-nez v0, :cond_25

    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/flowable/FlowableRefCount;->timeout(Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;)V

    monitor-exit p0

    return-void

    :cond_25
    new-instance v0, Lio/reactivex/internal/disposables/SequentialDisposable;

    invoke-direct {v0}, Lio/reactivex/internal/disposables/SequentialDisposable;-><init>()V

    iput-object v0, p1, Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;->timer:Lio/reactivex/disposables/Disposable;

    monitor-exit p0
    :try_end_2d
    .catchall {:try_start_1 .. :try_end_2d} :catchall_3f

    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableRefCount;->scheduler:Lio/reactivex/Scheduler;

    iget-wide v2, p0, Lio/reactivex/internal/operators/flowable/FlowableRefCount;->timeout:J

    iget-object v4, p0, Lio/reactivex/internal/operators/flowable/FlowableRefCount;->unit:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v1, p1, v2, v3, v4}, Lio/reactivex/Scheduler;->scheduleDirect(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Lio/reactivex/disposables/Disposable;

    move-result-object p1

    invoke-virtual {v0, p1}, Lio/reactivex/internal/disposables/SequentialDisposable;->replace(Lio/reactivex/disposables/Disposable;)Z

    return-void

    :cond_3b
    :goto_3b
    :try_start_3b
    monitor-exit p0

    return-void

    :cond_3d
    :goto_3d
    monitor-exit p0

    return-void

    :catchall_3f
    move-exception p1

    monitor-exit p0
    :try_end_41
    .catchall {:try_start_3b .. :try_end_41} :catchall_3f

    throw p1
.end method

.method clearTimer(Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;)V
    .registers 3

    iget-object v0, p1, Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;->timer:Lio/reactivex/disposables/Disposable;

    if-eqz v0, :cond_c

    iget-object v0, p1, Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;->timer:Lio/reactivex/disposables/Disposable;

    invoke-interface {v0}, Lio/reactivex/disposables/Disposable;->dispose()V

    const/4 v0, 0x0

    iput-object v0, p1, Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;->timer:Lio/reactivex/disposables/Disposable;

    :cond_c
    return-void
.end method

.method reset(Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;)V
    .registers 4

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableRefCount;->source:Lio/reactivex/flowables/ConnectableFlowable;

    instance-of v1, v0, Lio/reactivex/disposables/Disposable;

    if-eqz v1, :cond_c

    check-cast v0, Lio/reactivex/disposables/Disposable;

    invoke-interface {v0}, Lio/reactivex/disposables/Disposable;->dispose()V

    goto :goto_1b

    :cond_c
    instance-of v1, v0, Lio/reactivex/internal/disposables/ResettableConnectable;

    if-eqz v1, :cond_1b

    check-cast v0, Lio/reactivex/internal/disposables/ResettableConnectable;

    invoke-virtual {p1}, Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;->get()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lio/reactivex/disposables/Disposable;

    invoke-interface {v0, p1}, Lio/reactivex/internal/disposables/ResettableConnectable;->resetIf(Lio/reactivex/disposables/Disposable;)V

    :cond_1b
    :goto_1b
    return-void
.end method

.method protected subscribeActual(Lorg/reactivestreams/Subscriber;)V
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;)V"
        }
    .end annotation

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableRefCount;->connection:Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;

    if-nez v0, :cond_c

    new-instance v0, Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;

    invoke-direct {v0, p0}, Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;-><init>(Lio/reactivex/internal/operators/flowable/FlowableRefCount;)V

    iput-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableRefCount;->connection:Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;

    :cond_c
    iget-wide v1, v0, Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;->subscriberCount:J

    const-wide/16 v3, 0x0

    cmp-long v3, v1, v3

    if-nez v3, :cond_1d

    iget-object v3, v0, Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;->timer:Lio/reactivex/disposables/Disposable;

    if-eqz v3, :cond_1d

    iget-object v3, v0, Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;->timer:Lio/reactivex/disposables/Disposable;

    invoke-interface {v3}, Lio/reactivex/disposables/Disposable;->dispose()V

    :cond_1d
    const-wide/16 v3, 0x1

    add-long/2addr v1, v3

    iput-wide v1, v0, Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;->subscriberCount:J

    iget-boolean v3, v0, Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;->connected:Z

    if-nez v3, :cond_31

    iget v3, p0, Lio/reactivex/internal/operators/flowable/FlowableRefCount;->n:I

    int-to-long v3, v3

    cmp-long v1, v1, v3

    if-nez v1, :cond_31

    const/4 v1, 0x1

    iput-boolean v1, v0, Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;->connected:Z

    goto :goto_32

    :cond_31
    const/4 v1, 0x0

    :goto_32
    monitor-exit p0
    :try_end_33
    .catchall {:try_start_1 .. :try_end_33} :catchall_45

    iget-object v2, p0, Lio/reactivex/internal/operators/flowable/FlowableRefCount;->source:Lio/reactivex/flowables/ConnectableFlowable;

    new-instance v3, Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefCountSubscriber;

    invoke-direct {v3, p1, p0, v0}, Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefCountSubscriber;-><init>(Lorg/reactivestreams/Subscriber;Lio/reactivex/internal/operators/flowable/FlowableRefCount;Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;)V

    invoke-virtual {v2, v3}, Lio/reactivex/flowables/ConnectableFlowable;->subscribe(Lio/reactivex/FlowableSubscriber;)V

    if-eqz v1, :cond_44

    iget-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableRefCount;->source:Lio/reactivex/flowables/ConnectableFlowable;

    invoke-virtual {p1, v0}, Lio/reactivex/flowables/ConnectableFlowable;->connect(Lio/reactivex/functions/Consumer;)V

    :cond_44
    return-void

    :catchall_45
    move-exception p1

    :try_start_46
    monitor-exit p0
    :try_end_47
    .catchall {:try_start_46 .. :try_end_47} :catchall_45

    throw p1
.end method

.method terminated(Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;)V
    .registers 10

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableRefCount;->source:Lio/reactivex/flowables/ConnectableFlowable;

    instance-of v0, v0, Lio/reactivex/internal/operators/flowable/FlowablePublishClassic;

    const/4 v1, 0x0

    const-wide/16 v2, 0x0

    const-wide/16 v4, 0x1

    if-eqz v0, :cond_24

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableRefCount;->connection:Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;

    if-eqz v0, :cond_17

    if-ne v0, p1, :cond_17

    iput-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableRefCount;->connection:Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;

    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/flowable/FlowableRefCount;->clearTimer(Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;)V

    :cond_17
    iget-wide v0, p1, Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;->subscriberCount:J

    sub-long/2addr v0, v4

    iput-wide v0, p1, Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;->subscriberCount:J

    cmp-long v0, v0, v2

    if-nez v0, :cond_3b

    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/flowable/FlowableRefCount;->reset(Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;)V

    goto :goto_3b

    :cond_24
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableRefCount;->connection:Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;

    if-eqz v0, :cond_3b

    if-ne v0, p1, :cond_3b

    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/flowable/FlowableRefCount;->clearTimer(Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;)V

    iget-wide v6, p1, Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;->subscriberCount:J

    sub-long/2addr v6, v4

    iput-wide v6, p1, Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;->subscriberCount:J

    cmp-long v0, v6, v2

    if-nez v0, :cond_3b

    iput-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableRefCount;->connection:Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;

    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/flowable/FlowableRefCount;->reset(Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;)V

    :cond_3b
    :goto_3b
    monitor-exit p0

    return-void

    :catchall_3d
    move-exception p1

    monitor-exit p0
    :try_end_3f
    .catchall {:try_start_1 .. :try_end_3f} :catchall_3d

    throw p1
.end method

.method timeout(Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;)V
    .registers 6

    monitor-enter p0

    :try_start_1
    iget-wide v0, p1, Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;->subscriberCount:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_34

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableRefCount;->connection:Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;

    if-ne p1, v0, :cond_34

    const/4 v0, 0x0

    iput-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableRefCount;->connection:Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;

    invoke-virtual {p1}, Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lio/reactivex/disposables/Disposable;

    invoke-static {p1}, Lio/reactivex/internal/disposables/DisposableHelper;->dispose(Ljava/util/concurrent/atomic/AtomicReference;)Z

    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableRefCount;->source:Lio/reactivex/flowables/ConnectableFlowable;

    instance-of v2, v1, Lio/reactivex/disposables/Disposable;

    if-eqz v2, :cond_25

    check-cast v1, Lio/reactivex/disposables/Disposable;

    invoke-interface {v1}, Lio/reactivex/disposables/Disposable;->dispose()V

    goto :goto_34

    :cond_25
    instance-of v2, v1, Lio/reactivex/internal/disposables/ResettableConnectable;

    if-eqz v2, :cond_34

    if-nez v0, :cond_2f

    const/4 v0, 0x1

    iput-boolean v0, p1, Lio/reactivex/internal/operators/flowable/FlowableRefCount$RefConnection;->disconnectedEarly:Z

    goto :goto_34

    :cond_2f
    check-cast v1, Lio/reactivex/internal/disposables/ResettableConnectable;

    invoke-interface {v1, v0}, Lio/reactivex/internal/disposables/ResettableConnectable;->resetIf(Lio/reactivex/disposables/Disposable;)V

    :cond_34
    :goto_34
    monitor-exit p0

    return-void

    :catchall_36
    move-exception p1

    monitor-exit p0
    :try_end_38
    .catchall {:try_start_1 .. :try_end_38} :catchall_36

    throw p1
.end method
