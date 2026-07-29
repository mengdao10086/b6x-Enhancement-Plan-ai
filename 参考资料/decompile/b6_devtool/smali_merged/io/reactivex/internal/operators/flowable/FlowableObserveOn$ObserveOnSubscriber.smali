.class final Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;
.super Lio/reactivex/internal/operators/flowable/FlowableObserveOn$BaseObserveOnSubscriber;
.source "FlowableObserveOn.java"

# interfaces
.implements Lio/reactivex/FlowableSubscriber;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/flowable/FlowableObserveOn;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "ObserveOnSubscriber"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lio/reactivex/internal/operators/flowable/FlowableObserveOn$BaseObserveOnSubscriber<",
        "TT;>;",
        "Lio/reactivex/FlowableSubscriber<",
        "TT;>;"
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = -0x3f1a97e8f84a341aL


# instance fields
.field final downstream:Lorg/reactivestreams/Subscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lorg/reactivestreams/Subscriber;Lio/reactivex/Scheduler$Worker;ZI)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;",
            "Lio/reactivex/Scheduler$Worker;",
            "ZI)V"
        }
    .end annotation

    .line 257
    invoke-direct {p0, p2, p3, p4}, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$BaseObserveOnSubscriber;-><init>(Lio/reactivex/Scheduler$Worker;ZI)V

    .line 258
    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    return-void
.end method


# virtual methods
.method public onSubscribe(Lorg/reactivestreams/Subscription;)V
    .registers 5

    .line 263
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    invoke-static {v0, p1}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->validate(Lorg/reactivestreams/Subscription;Lorg/reactivestreams/Subscription;)Z

    move-result v0

    if-eqz v0, :cond_4c

    .line 264
    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    .line 266
    instance-of v0, p1, Lio/reactivex/internal/fuseable/QueueSubscription;

    if-eqz v0, :cond_38

    .line 268
    move-object v0, p1

    check-cast v0, Lio/reactivex/internal/fuseable/QueueSubscription;

    const/4 v1, 0x7

    .line 270
    invoke-interface {v0, v1}, Lio/reactivex/internal/fuseable/QueueSubscription;->requestFusion(I)I

    move-result v1

    const/4 v2, 0x1

    if-ne v1, v2, :cond_25

    .line 273
    iput v2, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->sourceMode:I

    .line 274
    iput-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->queue:Lio/reactivex/internal/fuseable/SimpleQueue;

    .line 275
    iput-boolean v2, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->done:Z

    .line 277
    iget-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    invoke-interface {p1, p0}, Lorg/reactivestreams/Subscriber;->onSubscribe(Lorg/reactivestreams/Subscription;)V

    return-void

    :cond_25
    const/4 v2, 0x2

    if-ne v1, v2, :cond_38

    .line 281
    iput v2, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->sourceMode:I

    .line 282
    iput-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->queue:Lio/reactivex/internal/fuseable/SimpleQueue;

    .line 284
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    invoke-interface {v0, p0}, Lorg/reactivestreams/Subscriber;->onSubscribe(Lorg/reactivestreams/Subscription;)V

    .line 286
    iget v0, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->prefetch:I

    int-to-long v0, v0

    invoke-interface {p1, v0, v1}, Lorg/reactivestreams/Subscription;->request(J)V

    return-void

    .line 292
    :cond_38
    new-instance v0, Lio/reactivex/internal/queue/SpscArrayQueue;

    iget v1, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->prefetch:I

    invoke-direct {v0, v1}, Lio/reactivex/internal/queue/SpscArrayQueue;-><init>(I)V

    iput-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->queue:Lio/reactivex/internal/fuseable/SimpleQueue;

    .line 294
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    invoke-interface {v0, p0}, Lorg/reactivestreams/Subscriber;->onSubscribe(Lorg/reactivestreams/Subscription;)V

    .line 296
    iget v0, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->prefetch:I

    int-to-long v0, v0

    invoke-interface {p1, v0, v1}, Lorg/reactivestreams/Subscription;->request(J)V

    :cond_4c
    return-void
.end method

.method public poll()Ljava/lang/Object;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .line 472
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->queue:Lio/reactivex/internal/fuseable/SimpleQueue;

    invoke-interface {v0}, Lio/reactivex/internal/fuseable/SimpleQueue;->poll()Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_25

    .line 473
    iget v1, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->sourceMode:I

    const/4 v2, 0x1

    if-eq v1, v2, :cond_25

    .line 474
    iget-wide v1, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->produced:J

    const-wide/16 v3, 0x1

    add-long/2addr v1, v3

    .line 475
    iget v3, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->limit:I

    int-to-long v3, v3

    cmp-long v3, v1, v3

    if-nez v3, :cond_23

    const-wide/16 v3, 0x0

    .line 476
    iput-wide v3, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->produced:J

    .line 477
    iget-object v3, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    invoke-interface {v3, v1, v2}, Lorg/reactivestreams/Subscription;->request(J)V

    goto :goto_25

    .line 479
    :cond_23
    iput-wide v1, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->produced:J

    :cond_25
    :goto_25
    return-object v0
.end method

.method runAsync()V
    .registers 13

    .line 370
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    .line 371
    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->queue:Lio/reactivex/internal/fuseable/SimpleQueue;

    .line 373
    iget-wide v2, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->produced:J

    const/4 v4, 0x1

    move v5, v4

    .line 377
    :cond_8
    :goto_8
    iget-object v6, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v6}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v6

    :cond_e
    :goto_e
    cmp-long v8, v2, v6

    if-eqz v8, :cond_63

    .line 380
    iget-boolean v9, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->done:Z

    .line 384
    :try_start_14
    invoke-interface {v1}, Lio/reactivex/internal/fuseable/SimpleQueue;->poll()Ljava/lang/Object;

    move-result-object v10
    :try_end_18
    .catchall {:try_start_14 .. :try_end_18} :catchall_4c

    if-nez v10, :cond_1c

    move v11, v4

    goto :goto_1d

    :cond_1c
    const/4 v11, 0x0

    .line 399
    :goto_1d
    invoke-virtual {p0, v9, v11, v0}, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->checkTerminated(ZZLorg/reactivestreams/Subscriber;)Z

    move-result v9

    if-eqz v9, :cond_24

    return-void

    :cond_24
    if-eqz v11, :cond_27

    goto :goto_63

    .line 407
    :cond_27
    invoke-interface {v0, v10}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    const-wide/16 v8, 0x1

    add-long/2addr v2, v8

    .line 410
    iget v8, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->limit:I

    int-to-long v8, v8

    cmp-long v8, v2, v8

    if-nez v8, :cond_e

    const-wide v8, 0x7fffffffffffffffL

    cmp-long v8, v6, v8

    if-eqz v8, :cond_44

    .line 412
    iget-object v6, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    neg-long v7, v2

    invoke-virtual {v6, v7, v8}, Ljava/util/concurrent/atomic/AtomicLong;->addAndGet(J)J

    move-result-wide v6

    .line 414
    :cond_44
    iget-object v8, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    invoke-interface {v8, v2, v3}, Lorg/reactivestreams/Subscription;->request(J)V

    const-wide/16 v2, 0x0

    goto :goto_e

    :catchall_4c
    move-exception v2

    .line 386
    invoke-static {v2}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 388
    iput-boolean v4, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->cancelled:Z

    .line 389
    iget-object v3, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    invoke-interface {v3}, Lorg/reactivestreams/Subscription;->cancel()V

    .line 390
    invoke-interface {v1}, Lio/reactivex/internal/fuseable/SimpleQueue;->clear()V

    .line 392
    invoke-interface {v0, v2}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    .line 393
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->worker:Lio/reactivex/Scheduler$Worker;

    invoke-virtual {v0}, Lio/reactivex/Scheduler$Worker;->dispose()V

    return-void

    :cond_63
    :goto_63
    if-nez v8, :cond_72

    .line 419
    iget-boolean v6, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->done:Z

    invoke-interface {v1}, Lio/reactivex/internal/fuseable/SimpleQueue;->isEmpty()Z

    move-result v7

    invoke-virtual {p0, v6, v7, v0}, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->checkTerminated(ZZLorg/reactivestreams/Subscriber;)Z

    move-result v6

    if-eqz v6, :cond_72

    return-void

    .line 423
    :cond_72
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->get()I

    move-result v6

    if-ne v5, v6, :cond_82

    .line 425
    iput-wide v2, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->produced:J

    neg-int v5, v5

    .line 426
    invoke-virtual {p0, v5}, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->addAndGet(I)I

    move-result v5

    if-nez v5, :cond_8

    return-void

    :cond_82
    move v5, v6

    goto :goto_8
.end method

.method runBackfused()V
    .registers 6

    const/4 v0, 0x1

    move v1, v0

    .line 442
    :cond_2
    iget-boolean v2, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->cancelled:Z

    if-eqz v2, :cond_7

    return-void

    .line 446
    :cond_7
    iget-boolean v2, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->done:Z

    .line 448
    iget-object v3, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    const/4 v4, 0x0

    invoke-interface {v3, v4}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    if-eqz v2, :cond_28

    .line 451
    iput-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->cancelled:Z

    .line 452
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->error:Ljava/lang/Throwable;

    if-eqz v0, :cond_1d

    .line 454
    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    invoke-interface {v1, v0}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    goto :goto_22

    .line 456
    :cond_1d
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    invoke-interface {v0}, Lorg/reactivestreams/Subscriber;->onComplete()V

    .line 458
    :goto_22
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->worker:Lio/reactivex/Scheduler$Worker;

    invoke-virtual {v0}, Lio/reactivex/Scheduler$Worker;->dispose()V

    return-void

    :cond_28
    neg-int v1, v1

    .line 462
    invoke-virtual {p0, v1}, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->addAndGet(I)I

    move-result v1

    if-nez v1, :cond_2

    return-void
.end method

.method runSync()V
    .registers 11

    .line 304
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    .line 305
    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->queue:Lio/reactivex/internal/fuseable/SimpleQueue;

    .line 307
    iget-wide v2, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->produced:J

    const/4 v4, 0x1

    move v5, v4

    .line 311
    :cond_8
    :goto_8
    iget-object v6, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v6}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v6

    :goto_e
    cmp-long v8, v2, v6

    if-eqz v8, :cond_43

    .line 317
    :try_start_12
    invoke-interface {v1}, Lio/reactivex/internal/fuseable/SimpleQueue;->poll()Ljava/lang/Object;

    move-result-object v8
    :try_end_16
    .catchall {:try_start_12 .. :try_end_16} :catchall_2f

    .line 327
    iget-boolean v9, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->cancelled:Z

    if-eqz v9, :cond_1b

    return-void

    :cond_1b
    if-nez v8, :cond_28

    .line 331
    iput-boolean v4, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->cancelled:Z

    .line 332
    invoke-interface {v0}, Lorg/reactivestreams/Subscriber;->onComplete()V

    .line 333
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->worker:Lio/reactivex/Scheduler$Worker;

    invoke-virtual {v0}, Lio/reactivex/Scheduler$Worker;->dispose()V

    return-void

    .line 337
    :cond_28
    invoke-interface {v0, v8}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    const-wide/16 v8, 0x1

    add-long/2addr v2, v8

    goto :goto_e

    :catchall_2f
    move-exception v1

    .line 319
    invoke-static {v1}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 320
    iput-boolean v4, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->cancelled:Z

    .line 321
    iget-object v2, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    invoke-interface {v2}, Lorg/reactivestreams/Subscription;->cancel()V

    .line 322
    invoke-interface {v0, v1}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    .line 323
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->worker:Lio/reactivex/Scheduler$Worker;

    invoke-virtual {v0}, Lio/reactivex/Scheduler$Worker;->dispose()V

    return-void

    .line 342
    :cond_43
    iget-boolean v6, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->cancelled:Z

    if-eqz v6, :cond_48

    return-void

    .line 346
    :cond_48
    invoke-interface {v1}, Lio/reactivex/internal/fuseable/SimpleQueue;->isEmpty()Z

    move-result v6

    if-eqz v6, :cond_59

    .line 347
    iput-boolean v4, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->cancelled:Z

    .line 348
    invoke-interface {v0}, Lorg/reactivestreams/Subscriber;->onComplete()V

    .line 349
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->worker:Lio/reactivex/Scheduler$Worker;

    invoke-virtual {v0}, Lio/reactivex/Scheduler$Worker;->dispose()V

    return-void

    .line 353
    :cond_59
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->get()I

    move-result v6

    if-ne v5, v6, :cond_69

    .line 355
    iput-wide v2, p0, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->produced:J

    neg-int v5, v5

    .line 356
    invoke-virtual {p0, v5}, Lio/reactivex/internal/operators/flowable/FlowableObserveOn$ObserveOnSubscriber;->addAndGet(I)I

    move-result v5

    if-nez v5, :cond_8

    return-void

    :cond_69
    move v5, v6

    goto :goto_8
.end method
