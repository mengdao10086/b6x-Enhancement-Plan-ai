.class final Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;
.super Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionBase;
.source "ParallelJoin.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/parallel/ParallelJoin;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "JoinSubscriptionDelayError"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionBase<",
        "TT;>;"
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = -0x4fa158f1d44428dbL


# direct methods
.method constructor <init>(Lorg/reactivestreams/Subscriber;II)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;II)V"
        }
    .end annotation

    .line 323
    invoke-direct {p0, p1, p2, p3}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionBase;-><init>(Lorg/reactivestreams/Subscriber;II)V

    return-void
.end method


# virtual methods
.method drain()V
    .registers 2

    .line 382
    invoke-virtual {p0}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->getAndIncrement()I

    move-result v0

    if-eqz v0, :cond_7

    return-void

    .line 386
    :cond_7
    invoke-virtual {p0}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->drainLoop()V

    return-void
.end method

.method drainLoop()V
    .registers 19

    move-object/from16 v0, p0

    .line 392
    iget-object v1, v0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->subscribers:[Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinInnerSubscriber;

    .line 393
    array-length v2, v1

    .line 394
    iget-object v3, v0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->downstream:Lorg/reactivestreams/Subscriber;

    const/4 v5, 0x1

    .line 398
    :goto_8
    iget-object v6, v0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v6}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v6

    const-wide/16 v8, 0x0

    move-wide v10, v8

    :cond_11
    cmp-long v12, v10, v6

    if-eqz v12, :cond_69

    .line 403
    iget-boolean v12, v0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->cancelled:Z

    if-eqz v12, :cond_1d

    .line 404
    invoke-virtual/range {p0 .. p0}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->cleanup()V

    return-void

    .line 408
    :cond_1d
    iget-object v12, v0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->done:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v12}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v12

    if-nez v12, :cond_27

    const/4 v12, 0x1

    goto :goto_28

    :cond_27
    const/4 v12, 0x0

    :goto_28
    const/4 v14, 0x0

    const/4 v15, 0x1

    :goto_2a
    if-ge v14, v2, :cond_4b

    .line 413
    aget-object v4, v1, v14

    .line 415
    iget-object v13, v4, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinInnerSubscriber;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    if-eqz v13, :cond_48

    .line 417
    invoke-interface {v13}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->poll()Ljava/lang/Object;

    move-result-object v13

    if-eqz v13, :cond_48

    .line 421
    invoke-interface {v3, v13}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    .line 422
    invoke-virtual {v4}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinInnerSubscriber;->requestOne()V

    const-wide/16 v16, 0x1

    add-long v10, v10, v16

    cmp-long v4, v10, v6

    if-nez v4, :cond_47

    goto :goto_69

    :cond_47
    const/4 v15, 0x0

    :cond_48
    add-int/lit8 v14, v14, 0x1

    goto :goto_2a

    :cond_4b
    if-eqz v12, :cond_67

    if-eqz v15, :cond_67

    .line 431
    iget-object v1, v0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v1}, Lio/reactivex/internal/util/AtomicThrowable;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Throwable;

    if-eqz v1, :cond_63

    .line 433
    iget-object v1, v0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v1}, Lio/reactivex/internal/util/AtomicThrowable;->terminate()Ljava/lang/Throwable;

    move-result-object v1

    invoke-interface {v3, v1}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    goto :goto_66

    .line 435
    :cond_63
    invoke-interface {v3}, Lorg/reactivestreams/Subscriber;->onComplete()V

    :goto_66
    return-void

    :cond_67
    if-eqz v15, :cond_11

    :cond_69
    :goto_69
    cmp-long v4, v10, v6

    if-nez v4, :cond_b1

    .line 446
    iget-boolean v4, v0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->cancelled:Z

    if-eqz v4, :cond_75

    .line 447
    invoke-virtual/range {p0 .. p0}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->cleanup()V

    return-void

    .line 451
    :cond_75
    iget-object v4, v0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->done:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v4}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v4

    if-nez v4, :cond_7f

    const/4 v4, 0x1

    goto :goto_80

    :cond_7f
    const/4 v4, 0x0

    :goto_80
    const/4 v12, 0x0

    :goto_81
    if-ge v12, v2, :cond_94

    .line 456
    aget-object v13, v1, v12

    .line 458
    iget-object v13, v13, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinInnerSubscriber;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    if-eqz v13, :cond_91

    .line 459
    invoke-interface {v13}, Lio/reactivex/internal/fuseable/SimpleQueue;->isEmpty()Z

    move-result v13

    if-nez v13, :cond_91

    const/4 v13, 0x0

    goto :goto_95

    :cond_91
    add-int/lit8 v12, v12, 0x1

    goto :goto_81

    :cond_94
    const/4 v13, 0x1

    :goto_95
    if-eqz v4, :cond_b1

    if-eqz v13, :cond_b1

    .line 466
    iget-object v1, v0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v1}, Lio/reactivex/internal/util/AtomicThrowable;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Throwable;

    if-eqz v1, :cond_ad

    .line 468
    iget-object v1, v0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v1}, Lio/reactivex/internal/util/AtomicThrowable;->terminate()Ljava/lang/Throwable;

    move-result-object v1

    invoke-interface {v3, v1}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    goto :goto_b0

    .line 470
    :cond_ad
    invoke-interface {v3}, Lorg/reactivestreams/Subscriber;->onComplete()V

    :goto_b0
    return-void

    :cond_b1
    cmp-long v4, v10, v8

    if-eqz v4, :cond_c4

    const-wide v8, 0x7fffffffffffffffL

    cmp-long v4, v6, v8

    if-eqz v4, :cond_c4

    .line 477
    iget-object v4, v0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    neg-long v6, v10

    invoke-virtual {v4, v6, v7}, Ljava/util/concurrent/atomic/AtomicLong;->addAndGet(J)J

    .line 480
    :cond_c4
    invoke-virtual/range {p0 .. p0}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->get()I

    move-result v4

    if-ne v4, v5, :cond_d2

    neg-int v4, v5

    .line 482
    invoke-virtual {v0, v4}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->addAndGet(I)I

    move-result v4

    if-nez v4, :cond_d2

    return-void

    :cond_d2
    move v5, v4

    goto/16 :goto_8
.end method

.method onComplete()V
    .registers 2

    .line 376
    iget-object v0, p0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->done:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I

    .line 377
    invoke-virtual {p0}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->drain()V

    return-void
.end method

.method onError(Ljava/lang/Throwable;)V
    .registers 3

    .line 369
    iget-object v0, p0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v0, p1}, Lio/reactivex/internal/util/AtomicThrowable;->addThrowable(Ljava/lang/Throwable;)Z

    .line 370
    iget-object p1, p0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->done:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {p1}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I

    .line 371
    invoke-virtual {p0}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->drain()V

    return-void
.end method

.method onNext(Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinInnerSubscriber;Ljava/lang/Object;)V
    .registers 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinInnerSubscriber<",
            "TT;>;TT;)V"
        }
    .end annotation

    .line 328
    invoke-virtual {p0}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->get()I

    move-result v0

    const-string v1, "Queue full?!"

    if-nez v0, :cond_62

    const/4 v0, 0x0

    const/4 v2, 0x1

    invoke-virtual {p0, v0, v2}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->compareAndSet(II)Z

    move-result v0

    if-eqz v0, :cond_62

    .line 329
    iget-object v0, p0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v0, v2, v4

    if-eqz v0, :cond_3b

    .line 330
    iget-object v0, p0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->downstream:Lorg/reactivestreams/Subscriber;

    invoke-interface {v0, p2}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    .line 331
    iget-object p2, p0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {p2}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v0

    const-wide v2, 0x7fffffffffffffffL

    cmp-long p2, v0, v2

    if-eqz p2, :cond_35

    .line 332
    iget-object p2, p0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {p2}, Ljava/util/concurrent/atomic/AtomicLong;->decrementAndGet()J

    :cond_35
    const-wide/16 v0, 0x1

    .line 334
    invoke-virtual {p1, v0, v1}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinInnerSubscriber;->request(J)V

    goto :goto_5b

    .line 336
    :cond_3b
    invoke-virtual {p1}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinInnerSubscriber;->getQueue()Lio/reactivex/internal/fuseable/SimplePlainQueue;

    move-result-object v0

    .line 338
    invoke-interface {v0, p2}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->offer(Ljava/lang/Object;)Z

    move-result p2

    if-nez p2, :cond_5b

    .line 339
    invoke-virtual {p1}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinInnerSubscriber;->cancel()Z

    .line 340
    iget-object p1, p0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    new-instance p2, Lio/reactivex/exceptions/MissingBackpressureException;

    invoke-direct {p2, v1}, Lio/reactivex/exceptions/MissingBackpressureException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1, p2}, Lio/reactivex/internal/util/AtomicThrowable;->addThrowable(Ljava/lang/Throwable;)Z

    .line 341
    iget-object p1, p0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->done:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {p1}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I

    .line 342
    invoke-virtual {p0}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->drainLoop()V

    return-void

    .line 346
    :cond_5b
    :goto_5b
    invoke-virtual {p0}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->decrementAndGet()I

    move-result p1

    if-nez p1, :cond_88

    return-void

    .line 350
    :cond_62
    invoke-virtual {p1}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinInnerSubscriber;->getQueue()Lio/reactivex/internal/fuseable/SimplePlainQueue;

    move-result-object v0

    .line 352
    invoke-interface {v0, p2}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->offer(Ljava/lang/Object;)Z

    move-result p2

    if-nez p2, :cond_81

    .line 353
    invoke-virtual {p1}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinInnerSubscriber;->cancel()Z

    move-result p1

    if-eqz p1, :cond_81

    .line 354
    iget-object p1, p0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    new-instance p2, Lio/reactivex/exceptions/MissingBackpressureException;

    invoke-direct {p2, v1}, Lio/reactivex/exceptions/MissingBackpressureException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1, p2}, Lio/reactivex/internal/util/AtomicThrowable;->addThrowable(Ljava/lang/Throwable;)Z

    .line 355
    iget-object p1, p0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->done:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {p1}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I

    .line 359
    :cond_81
    invoke-virtual {p0}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->getAndIncrement()I

    move-result p1

    if-eqz p1, :cond_88

    return-void

    .line 364
    :cond_88
    invoke-virtual {p0}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionDelayError;->drainLoop()V

    return-void
.end method
