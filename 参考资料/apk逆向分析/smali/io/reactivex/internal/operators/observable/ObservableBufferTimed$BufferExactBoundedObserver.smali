.class final Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;
.super Lio/reactivex/internal/observers/QueueDrainObserver;
.source "ObservableBufferTimed.java"

# interfaces
.implements Ljava/lang/Runnable;
.implements Lio/reactivex/disposables/Disposable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/observable/ObservableBufferTimed;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "BufferExactBoundedObserver"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        "U::",
        "Ljava/util/Collection<",
        "-TT;>;>",
        "Lio/reactivex/internal/observers/QueueDrainObserver<",
        "TT;TU;TU;>;",
        "Ljava/lang/Runnable;",
        "Lio/reactivex/disposables/Disposable;"
    }
.end annotation


# instance fields
.field buffer:Ljava/util/Collection;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TU;"
        }
    .end annotation
.end field

.field final bufferSupplier:Ljava/util/concurrent/Callable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/Callable<",
            "TU;>;"
        }
    .end annotation
.end field

.field consumerIndex:J

.field final maxSize:I

.field producerIndex:J

.field final restartTimerOnMaxSize:Z

.field timer:Lio/reactivex/disposables/Disposable;

.field final timespan:J

.field final unit:Ljava/util/concurrent/TimeUnit;

.field upstream:Lio/reactivex/disposables/Disposable;

.field final w:Lio/reactivex/Scheduler$Worker;


# direct methods
.method constructor <init>(Lio/reactivex/Observer;Ljava/util/concurrent/Callable;JLjava/util/concurrent/TimeUnit;IZLio/reactivex/Scheduler$Worker;)V
    .registers 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/Observer<",
            "-TU;>;",
            "Ljava/util/concurrent/Callable<",
            "TU;>;J",
            "Ljava/util/concurrent/TimeUnit;",
            "IZ",
            "Lio/reactivex/Scheduler$Worker;",
            ")V"
        }
    .end annotation

    .line 412
    new-instance v0, Lio/reactivex/internal/queue/MpscLinkedQueue;

    invoke-direct {v0}, Lio/reactivex/internal/queue/MpscLinkedQueue;-><init>()V

    invoke-direct {p0, p1, v0}, Lio/reactivex/internal/observers/QueueDrainObserver;-><init>(Lio/reactivex/Observer;Lio/reactivex/internal/fuseable/SimplePlainQueue;)V

    .line 413
    iput-object p2, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->bufferSupplier:Ljava/util/concurrent/Callable;

    .line 414
    iput-wide p3, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->timespan:J

    .line 415
    iput-object p5, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->unit:Ljava/util/concurrent/TimeUnit;

    .line 416
    iput p6, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->maxSize:I

    .line 417
    iput-boolean p7, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->restartTimerOnMaxSize:Z

    .line 418
    iput-object p8, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->w:Lio/reactivex/Scheduler$Worker;

    return-void
.end method


# virtual methods
.method public bridge synthetic accept(Lio/reactivex/Observer;Ljava/lang/Object;)V
    .registers 3

    .line 388
    check-cast p2, Ljava/util/Collection;

    invoke-virtual {p0, p1, p2}, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->accept(Lio/reactivex/Observer;Ljava/util/Collection;)V

    return-void
.end method

.method public accept(Lio/reactivex/Observer;Ljava/util/Collection;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/Observer<",
            "-TU;>;TU;)V"
        }
    .end annotation

    .line 518
    invoke-interface {p1, p2}, Lio/reactivex/Observer;->onNext(Ljava/lang/Object;)V

    return-void
.end method

.method public dispose()V
    .registers 2

    .line 523
    iget-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->cancelled:Z

    if-nez v0, :cond_1a

    const/4 v0, 0x1

    .line 524
    iput-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->cancelled:Z

    .line 525
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-interface {v0}, Lio/reactivex/disposables/Disposable;->dispose()V

    .line 526
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->w:Lio/reactivex/Scheduler$Worker;

    invoke-virtual {v0}, Lio/reactivex/Scheduler$Worker;->dispose()V

    .line 527
    monitor-enter p0

    const/4 v0, 0x0

    .line 528
    :try_start_13
    iput-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->buffer:Ljava/util/Collection;

    .line 529
    monitor-exit p0

    goto :goto_1a

    :catchall_17
    move-exception v0

    monitor-exit p0
    :try_end_19
    .catchall {:try_start_13 .. :try_end_19} :catchall_17

    throw v0

    :cond_1a
    :goto_1a
    return-void
.end method

.method public isDisposed()Z
    .registers 2

    .line 535
    iget-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->cancelled:Z

    return v0
.end method

.method public onComplete()V
    .registers 4

    .line 499
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->w:Lio/reactivex/Scheduler$Worker;

    invoke-virtual {v0}, Lio/reactivex/Scheduler$Worker;->dispose()V

    .line 502
    monitor-enter p0

    .line 503
    :try_start_6
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->buffer:Ljava/util/Collection;

    const/4 v1, 0x0

    .line 504
    iput-object v1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->buffer:Ljava/util/Collection;

    .line 505
    monitor-exit p0
    :try_end_c
    .catchall {:try_start_6 .. :try_end_c} :catchall_25

    if-eqz v0, :cond_24

    .line 508
    iget-object v1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    invoke-interface {v1, v0}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->offer(Ljava/lang/Object;)Z

    const/4 v0, 0x1

    .line 509
    iput-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->done:Z

    .line 510
    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->enter()Z

    move-result v0

    if-eqz v0, :cond_24

    .line 511
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    iget-object v1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->downstream:Lio/reactivex/Observer;

    const/4 v2, 0x0

    invoke-static {v0, v1, v2, p0, p0}, Lio/reactivex/internal/util/QueueDrainHelper;->drainLoop(Lio/reactivex/internal/fuseable/SimplePlainQueue;Lio/reactivex/Observer;ZLio/reactivex/disposables/Disposable;Lio/reactivex/internal/util/ObservableQueueDrain;)V

    :cond_24
    return-void

    :catchall_25
    move-exception v0

    .line 505
    :try_start_26
    monitor-exit p0
    :try_end_27
    .catchall {:try_start_26 .. :try_end_27} :catchall_25

    throw v0
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 3

    .line 490
    monitor-enter p0

    const/4 v0, 0x0

    .line 491
    :try_start_2
    iput-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->buffer:Ljava/util/Collection;

    .line 492
    monitor-exit p0
    :try_end_5
    .catchall {:try_start_2 .. :try_end_5} :catchall_10

    .line 493
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {v0, p1}, Lio/reactivex/Observer;->onError(Ljava/lang/Throwable;)V

    .line 494
    iget-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->w:Lio/reactivex/Scheduler$Worker;

    invoke-virtual {p1}, Lio/reactivex/Scheduler$Worker;->dispose()V

    return-void

    :catchall_10
    move-exception p1

    .line 492
    :try_start_11
    monitor-exit p0
    :try_end_12
    .catchall {:try_start_11 .. :try_end_12} :catchall_10

    throw p1
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 449
    monitor-enter p0

    .line 450
    :try_start_1
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->buffer:Ljava/util/Collection;

    if-nez v0, :cond_7

    .line 452
    monitor-exit p0

    return-void

    .line 455
    :cond_7
    invoke-interface {v0, p1}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    .line 457
    invoke-interface {v0}, Ljava/util/Collection;->size()I

    move-result p1

    iget v1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->maxSize:I

    if-ge p1, v1, :cond_14

    .line 458
    monitor-exit p0

    return-void

    :cond_14
    const/4 p1, 0x0

    .line 460
    iput-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->buffer:Ljava/util/Collection;

    .line 461
    iget-wide v1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->producerIndex:J

    const-wide/16 v3, 0x1

    add-long/2addr v1, v3

    iput-wide v1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->producerIndex:J

    .line 462
    monitor-exit p0
    :try_end_1f
    .catchall {:try_start_1 .. :try_end_1f} :catchall_66

    .line 464
    iget-boolean p1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->restartTimerOnMaxSize:Z

    if-eqz p1, :cond_28

    .line 465
    iget-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->timer:Lio/reactivex/disposables/Disposable;

    invoke-interface {p1}, Lio/reactivex/disposables/Disposable;->dispose()V

    :cond_28
    const/4 p1, 0x0

    .line 468
    invoke-virtual {p0, v0, p1, p0}, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->fastPathOrderedEmit(Ljava/lang/Object;ZLio/reactivex/disposables/Disposable;)V

    .line 471
    :try_start_2c
    iget-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->bufferSupplier:Ljava/util/concurrent/Callable;

    invoke-interface {p1}, Ljava/util/concurrent/Callable;->call()Ljava/lang/Object;

    move-result-object p1

    const-string v0, "The buffer supplied is null"

    invoke-static {p1, v0}, Lio/reactivex/internal/functions/ObjectHelper;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/Collection;
    :try_end_3a
    .catchall {:try_start_2c .. :try_end_3a} :catchall_59

    .line 479
    monitor-enter p0

    .line 480
    :try_start_3b
    iput-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->buffer:Ljava/util/Collection;

    .line 481
    iget-wide v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->consumerIndex:J

    add-long/2addr v0, v3

    iput-wide v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->consumerIndex:J

    .line 482
    monitor-exit p0
    :try_end_43
    .catchall {:try_start_3b .. :try_end_43} :catchall_56

    .line 483
    iget-boolean p1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->restartTimerOnMaxSize:Z

    if-eqz p1, :cond_55

    .line 484
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->w:Lio/reactivex/Scheduler$Worker;

    iget-wide v4, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->timespan:J

    iget-object v6, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->unit:Ljava/util/concurrent/TimeUnit;

    move-object v1, p0

    move-wide v2, v4

    invoke-virtual/range {v0 .. v6}, Lio/reactivex/Scheduler$Worker;->schedulePeriodically(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Lio/reactivex/disposables/Disposable;

    move-result-object p1

    iput-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->timer:Lio/reactivex/disposables/Disposable;

    :cond_55
    return-void

    :catchall_56
    move-exception p1

    .line 482
    :try_start_57
    monitor-exit p0
    :try_end_58
    .catchall {:try_start_57 .. :try_end_58} :catchall_56

    throw p1

    :catchall_59
    move-exception p1

    .line 473
    invoke-static {p1}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 474
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {v0, p1}, Lio/reactivex/Observer;->onError(Ljava/lang/Throwable;)V

    .line 475
    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->dispose()V

    return-void

    :catchall_66
    move-exception p1

    .line 462
    :try_start_67
    monitor-exit p0
    :try_end_68
    .catchall {:try_start_67 .. :try_end_68} :catchall_66

    throw p1
.end method

.method public onSubscribe(Lio/reactivex/disposables/Disposable;)V
    .registers 9

    .line 423
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-static {v0, p1}, Lio/reactivex/internal/disposables/DisposableHelper;->validate(Lio/reactivex/disposables/Disposable;Lio/reactivex/disposables/Disposable;)Z

    move-result v0

    if-eqz v0, :cond_3f

    .line 424
    iput-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->upstream:Lio/reactivex/disposables/Disposable;

    .line 429
    :try_start_a
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->bufferSupplier:Ljava/util/concurrent/Callable;

    invoke-interface {v0}, Ljava/util/concurrent/Callable;->call()Ljava/lang/Object;

    move-result-object v0

    const-string v1, "The buffer supplied is null"

    invoke-static {v0, v1}, Lio/reactivex/internal/functions/ObjectHelper;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Collection;
    :try_end_18
    .catchall {:try_start_a .. :try_end_18} :catchall_2e

    .line 438
    iput-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->buffer:Ljava/util/Collection;

    .line 440
    iget-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {p1, p0}, Lio/reactivex/Observer;->onSubscribe(Lio/reactivex/disposables/Disposable;)V

    .line 442
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->w:Lio/reactivex/Scheduler$Worker;

    iget-wide v4, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->timespan:J

    iget-object v6, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->unit:Ljava/util/concurrent/TimeUnit;

    move-object v1, p0

    move-wide v2, v4

    invoke-virtual/range {v0 .. v6}, Lio/reactivex/Scheduler$Worker;->schedulePeriodically(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Lio/reactivex/disposables/Disposable;

    move-result-object p1

    iput-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->timer:Lio/reactivex/disposables/Disposable;

    goto :goto_3f

    :catchall_2e
    move-exception v0

    .line 431
    invoke-static {v0}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 432
    invoke-interface {p1}, Lio/reactivex/disposables/Disposable;->dispose()V

    .line 433
    iget-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->downstream:Lio/reactivex/Observer;

    invoke-static {v0, p1}, Lio/reactivex/internal/disposables/EmptyDisposable;->error(Ljava/lang/Throwable;Lio/reactivex/Observer;)V

    .line 434
    iget-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->w:Lio/reactivex/Scheduler$Worker;

    invoke-virtual {p1}, Lio/reactivex/Scheduler$Worker;->dispose()V

    :cond_3f
    :goto_3f
    return-void
.end method

.method public run()V
    .registers 7

    .line 543
    :try_start_0
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->bufferSupplier:Ljava/util/concurrent/Callable;

    invoke-interface {v0}, Ljava/util/concurrent/Callable;->call()Ljava/lang/Object;

    move-result-object v0

    const-string v1, "The bufferSupplier returned a null buffer"

    invoke-static {v0, v1}, Lio/reactivex/internal/functions/ObjectHelper;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Collection;
    :try_end_e
    .catchall {:try_start_0 .. :try_end_e} :catchall_29

    .line 553
    monitor-enter p0

    .line 554
    :try_start_f
    iget-object v1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->buffer:Ljava/util/Collection;

    if-eqz v1, :cond_24

    .line 555
    iget-wide v2, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->producerIndex:J

    iget-wide v4, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->consumerIndex:J

    cmp-long v2, v2, v4

    if-eqz v2, :cond_1c

    goto :goto_24

    .line 558
    :cond_1c
    iput-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->buffer:Ljava/util/Collection;

    .line 559
    monitor-exit p0
    :try_end_1f
    .catchall {:try_start_f .. :try_end_1f} :catchall_26

    const/4 v0, 0x0

    .line 561
    invoke-virtual {p0, v1, v0, p0}, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->fastPathOrderedEmit(Ljava/lang/Object;ZLio/reactivex/disposables/Disposable;)V

    return-void

    .line 556
    :cond_24
    :goto_24
    :try_start_24
    monitor-exit p0

    return-void

    :catchall_26
    move-exception v0

    .line 559
    monitor-exit p0
    :try_end_28
    .catchall {:try_start_24 .. :try_end_28} :catchall_26

    throw v0

    :catchall_29
    move-exception v0

    .line 545
    invoke-static {v0}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 546
    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->dispose()V

    .line 547
    iget-object v1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferTimed$BufferExactBoundedObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {v1, v0}, Lio/reactivex/Observer;->onError(Ljava/lang/Throwable;)V

    return-void
.end method
