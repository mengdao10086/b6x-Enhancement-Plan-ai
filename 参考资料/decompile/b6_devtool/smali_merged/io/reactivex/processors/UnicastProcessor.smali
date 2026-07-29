.class public final Lio/reactivex/processors/UnicastProcessor;
.super Lio/reactivex/processors/FlowableProcessor;
.source "UnicastProcessor.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/reactivex/processors/UnicastProcessor$UnicastQueueSubscription;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lio/reactivex/processors/FlowableProcessor<",
        "TT;>;"
    }
.end annotation


# instance fields
.field volatile cancelled:Z

.field final delayError:Z

.field volatile done:Z

.field final downstream:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference<",
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;>;"
        }
    .end annotation
.end field

.field enableOperatorFusion:Z

.field error:Ljava/lang/Throwable;

.field final onTerminate:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference<",
            "Ljava/lang/Runnable;",
            ">;"
        }
    .end annotation
.end field

.field final once:Ljava/util/concurrent/atomic/AtomicBoolean;

.field final queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/internal/queue/SpscLinkedArrayQueue<",
            "TT;>;"
        }
    .end annotation
.end field

.field final requested:Ljava/util/concurrent/atomic/AtomicLong;

.field final wip:Lio/reactivex/internal/subscriptions/BasicIntQueueSubscription;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/internal/subscriptions/BasicIntQueueSubscription<",
            "TT;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(I)V
    .registers 4

    const/4 v0, 0x0

    const/4 v1, 0x1

    .line 258
    invoke-direct {p0, p1, v0, v1}, Lio/reactivex/processors/UnicastProcessor;-><init>(ILjava/lang/Runnable;Z)V

    return-void
.end method

.method constructor <init>(ILjava/lang/Runnable;)V
    .registers 4

    const/4 v0, 0x1

    .line 269
    invoke-direct {p0, p1, p2, v0}, Lio/reactivex/processors/UnicastProcessor;-><init>(ILjava/lang/Runnable;Z)V

    return-void
.end method

.method constructor <init>(ILjava/lang/Runnable;Z)V
    .registers 6

    .line 281
    invoke-direct {p0}, Lio/reactivex/processors/FlowableProcessor;-><init>()V

    .line 282
    new-instance v0, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    const-string v1, "capacityHint"

    invoke-static {p1, v1}, Lio/reactivex/internal/functions/ObjectHelper;->verifyPositive(ILjava/lang/String;)I

    move-result p1

    invoke-direct {v0, p1}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;-><init>(I)V

    iput-object v0, p0, Lio/reactivex/processors/UnicastProcessor;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    .line 283
    new-instance p1, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {p1, p2}, Ljava/util/concurrent/atomic/AtomicReference;-><init>(Ljava/lang/Object;)V

    iput-object p1, p0, Lio/reactivex/processors/UnicastProcessor;->onTerminate:Ljava/util/concurrent/atomic/AtomicReference;

    .line 284
    iput-boolean p3, p0, Lio/reactivex/processors/UnicastProcessor;->delayError:Z

    .line 285
    new-instance p1, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    iput-object p1, p0, Lio/reactivex/processors/UnicastProcessor;->downstream:Ljava/util/concurrent/atomic/AtomicReference;

    .line 286
    new-instance p1, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>()V

    iput-object p1, p0, Lio/reactivex/processors/UnicastProcessor;->once:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 287
    new-instance p1, Lio/reactivex/processors/UnicastProcessor$UnicastQueueSubscription;

    invoke-direct {p1, p0}, Lio/reactivex/processors/UnicastProcessor$UnicastQueueSubscription;-><init>(Lio/reactivex/processors/UnicastProcessor;)V

    iput-object p1, p0, Lio/reactivex/processors/UnicastProcessor;->wip:Lio/reactivex/internal/subscriptions/BasicIntQueueSubscription;

    .line 288
    new-instance p1, Ljava/util/concurrent/atomic/AtomicLong;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicLong;-><init>()V

    iput-object p1, p0, Lio/reactivex/processors/UnicastProcessor;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    return-void
.end method

.method public static create()Lio/reactivex/processors/UnicastProcessor;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">()",
            "Lio/reactivex/processors/UnicastProcessor<",
            "TT;>;"
        }
    .end annotation

    .annotation runtime Lio/reactivex/annotations/CheckReturnValue;
    .end annotation

    .line 183
    new-instance v0, Lio/reactivex/processors/UnicastProcessor;

    invoke-static {}, Lio/reactivex/processors/UnicastProcessor;->bufferSize()I

    move-result v1

    invoke-direct {v0, v1}, Lio/reactivex/processors/UnicastProcessor;-><init>(I)V

    return-object v0
.end method

.method public static create(I)Lio/reactivex/processors/UnicastProcessor;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(I)",
            "Lio/reactivex/processors/UnicastProcessor<",
            "TT;>;"
        }
    .end annotation

    .annotation runtime Lio/reactivex/annotations/CheckReturnValue;
    .end annotation

    .line 195
    new-instance v0, Lio/reactivex/processors/UnicastProcessor;

    invoke-direct {v0, p0}, Lio/reactivex/processors/UnicastProcessor;-><init>(I)V

    return-object v0
.end method

.method public static create(ILjava/lang/Runnable;)Lio/reactivex/processors/UnicastProcessor;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(I",
            "Ljava/lang/Runnable;",
            ")",
            "Lio/reactivex/processors/UnicastProcessor<",
            "TT;>;"
        }
    .end annotation

    .annotation runtime Lio/reactivex/annotations/CheckReturnValue;
    .end annotation

    const-string v0, "onTerminate"

    .line 227
    invoke-static {p1, v0}, Lio/reactivex/internal/functions/ObjectHelper;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 228
    new-instance v0, Lio/reactivex/processors/UnicastProcessor;

    invoke-direct {v0, p0, p1}, Lio/reactivex/processors/UnicastProcessor;-><init>(ILjava/lang/Runnable;)V

    return-object v0
.end method

.method public static create(ILjava/lang/Runnable;Z)Lio/reactivex/processors/UnicastProcessor;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(I",
            "Ljava/lang/Runnable;",
            "Z)",
            "Lio/reactivex/processors/UnicastProcessor<",
            "TT;>;"
        }
    .end annotation

    .annotation runtime Lio/reactivex/annotations/CheckReturnValue;
    .end annotation

    const-string v0, "onTerminate"

    .line 248
    invoke-static {p1, v0}, Lio/reactivex/internal/functions/ObjectHelper;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 249
    new-instance v0, Lio/reactivex/processors/UnicastProcessor;

    invoke-direct {v0, p0, p1, p2}, Lio/reactivex/processors/UnicastProcessor;-><init>(ILjava/lang/Runnable;Z)V

    return-object v0
.end method

.method public static create(Z)Lio/reactivex/processors/UnicastProcessor;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(Z)",
            "Lio/reactivex/processors/UnicastProcessor<",
            "TT;>;"
        }
    .end annotation

    .annotation runtime Lio/reactivex/annotations/CheckReturnValue;
    .end annotation

    .line 209
    new-instance v0, Lio/reactivex/processors/UnicastProcessor;

    invoke-static {}, Lio/reactivex/processors/UnicastProcessor;->bufferSize()I

    move-result v1

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2, p0}, Lio/reactivex/processors/UnicastProcessor;-><init>(ILjava/lang/Runnable;Z)V

    return-object v0
.end method


# virtual methods
.method checkTerminated(ZZZLorg/reactivestreams/Subscriber;Lio/reactivex/internal/queue/SpscLinkedArrayQueue;)Z
    .registers 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(ZZZ",
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;",
            "Lio/reactivex/internal/queue/SpscLinkedArrayQueue<",
            "TT;>;)Z"
        }
    .end annotation

    .line 411
    iget-boolean v0, p0, Lio/reactivex/processors/UnicastProcessor;->cancelled:Z

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-eqz v0, :cond_f

    .line 412
    invoke-virtual {p5}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->clear()V

    .line 413
    iget-object p1, p0, Lio/reactivex/processors/UnicastProcessor;->downstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {p1, v2}, Ljava/util/concurrent/atomic/AtomicReference;->lazySet(Ljava/lang/Object;)V

    return v1

    :cond_f
    if-eqz p2, :cond_38

    if-eqz p1, :cond_25

    .line 418
    iget-object p1, p0, Lio/reactivex/processors/UnicastProcessor;->error:Ljava/lang/Throwable;

    if-eqz p1, :cond_25

    .line 419
    invoke-virtual {p5}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->clear()V

    .line 420
    iget-object p1, p0, Lio/reactivex/processors/UnicastProcessor;->downstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {p1, v2}, Ljava/util/concurrent/atomic/AtomicReference;->lazySet(Ljava/lang/Object;)V

    .line 421
    iget-object p1, p0, Lio/reactivex/processors/UnicastProcessor;->error:Ljava/lang/Throwable;

    invoke-interface {p4, p1}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    return v1

    :cond_25
    if-eqz p3, :cond_38

    .line 425
    iget-object p1, p0, Lio/reactivex/processors/UnicastProcessor;->error:Ljava/lang/Throwable;

    .line 426
    iget-object p2, p0, Lio/reactivex/processors/UnicastProcessor;->downstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {p2, v2}, Ljava/util/concurrent/atomic/AtomicReference;->lazySet(Ljava/lang/Object;)V

    if-eqz p1, :cond_34

    .line 428
    invoke-interface {p4, p1}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    goto :goto_37

    .line 430
    :cond_34
    invoke-interface {p4}, Lorg/reactivestreams/Subscriber;->onComplete()V

    :goto_37
    return v1

    :cond_38
    const/4 p1, 0x0

    return p1
.end method

.method doTerminate()V
    .registers 3

    .line 292
    iget-object v0, p0, Lio/reactivex/processors/UnicastProcessor;->onTerminate:Ljava/util/concurrent/atomic/AtomicReference;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicReference;->getAndSet(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Runnable;

    if-eqz v0, :cond_e

    .line 294
    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    :cond_e
    return-void
.end method

.method drain()V
    .registers 3

    .line 384
    iget-object v0, p0, Lio/reactivex/processors/UnicastProcessor;->wip:Lio/reactivex/internal/subscriptions/BasicIntQueueSubscription;

    invoke-virtual {v0}, Lio/reactivex/internal/subscriptions/BasicIntQueueSubscription;->getAndIncrement()I

    move-result v0

    if-eqz v0, :cond_9

    return-void

    .line 390
    :cond_9
    iget-object v0, p0, Lio/reactivex/processors/UnicastProcessor;->downstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/reactivestreams/Subscriber;

    const/4 v1, 0x1

    :goto_12
    if-eqz v0, :cond_20

    .line 394
    iget-boolean v1, p0, Lio/reactivex/processors/UnicastProcessor;->enableOperatorFusion:Z

    if-eqz v1, :cond_1c

    .line 395
    invoke-virtual {p0, v0}, Lio/reactivex/processors/UnicastProcessor;->drainFused(Lorg/reactivestreams/Subscriber;)V

    goto :goto_1f

    .line 397
    :cond_1c
    invoke-virtual {p0, v0}, Lio/reactivex/processors/UnicastProcessor;->drainRegular(Lorg/reactivestreams/Subscriber;)V

    :goto_1f
    return-void

    .line 402
    :cond_20
    iget-object v0, p0, Lio/reactivex/processors/UnicastProcessor;->wip:Lio/reactivex/internal/subscriptions/BasicIntQueueSubscription;

    neg-int v1, v1

    invoke-virtual {v0, v1}, Lio/reactivex/internal/subscriptions/BasicIntQueueSubscription;->addAndGet(I)I

    move-result v1

    if-nez v1, :cond_2a

    return-void

    .line 406
    :cond_2a
    iget-object v0, p0, Lio/reactivex/processors/UnicastProcessor;->downstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/reactivestreams/Subscriber;

    goto :goto_12
.end method

.method drainFused(Lorg/reactivestreams/Subscriber;)V
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;)V"
        }
    .end annotation

    .line 345
    iget-object v0, p0, Lio/reactivex/processors/UnicastProcessor;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    .line 346
    iget-boolean v1, p0, Lio/reactivex/processors/UnicastProcessor;->delayError:Z

    const/4 v2, 0x1

    xor-int/2addr v1, v2

    .line 349
    :cond_6
    iget-boolean v3, p0, Lio/reactivex/processors/UnicastProcessor;->cancelled:Z

    const/4 v4, 0x0

    if-eqz v3, :cond_11

    .line 350
    iget-object p1, p0, Lio/reactivex/processors/UnicastProcessor;->downstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {p1, v4}, Ljava/util/concurrent/atomic/AtomicReference;->lazySet(Ljava/lang/Object;)V

    return-void

    .line 354
    :cond_11
    iget-boolean v3, p0, Lio/reactivex/processors/UnicastProcessor;->done:Z

    if-eqz v1, :cond_29

    if-eqz v3, :cond_29

    .line 356
    iget-object v5, p0, Lio/reactivex/processors/UnicastProcessor;->error:Ljava/lang/Throwable;

    if-eqz v5, :cond_29

    .line 357
    invoke-virtual {v0}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->clear()V

    .line 358
    iget-object v0, p0, Lio/reactivex/processors/UnicastProcessor;->downstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0, v4}, Ljava/util/concurrent/atomic/AtomicReference;->lazySet(Ljava/lang/Object;)V

    .line 359
    iget-object v0, p0, Lio/reactivex/processors/UnicastProcessor;->error:Ljava/lang/Throwable;

    invoke-interface {p1, v0}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void

    .line 362
    :cond_29
    invoke-interface {p1, v4}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    if-eqz v3, :cond_3f

    .line 365
    iget-object v0, p0, Lio/reactivex/processors/UnicastProcessor;->downstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0, v4}, Ljava/util/concurrent/atomic/AtomicReference;->lazySet(Ljava/lang/Object;)V

    .line 367
    iget-object v0, p0, Lio/reactivex/processors/UnicastProcessor;->error:Ljava/lang/Throwable;

    if-eqz v0, :cond_3b

    .line 369
    invoke-interface {p1, v0}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    goto :goto_3e

    .line 371
    :cond_3b
    invoke-interface {p1}, Lorg/reactivestreams/Subscriber;->onComplete()V

    :goto_3e
    return-void

    .line 376
    :cond_3f
    iget-object v3, p0, Lio/reactivex/processors/UnicastProcessor;->wip:Lio/reactivex/internal/subscriptions/BasicIntQueueSubscription;

    neg-int v2, v2

    invoke-virtual {v3, v2}, Lio/reactivex/internal/subscriptions/BasicIntQueueSubscription;->addAndGet(I)I

    move-result v2

    if-nez v2, :cond_6

    return-void
.end method

.method drainRegular(Lorg/reactivestreams/Subscriber;)V
    .registers 19
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;)V"
        }
    .end annotation

    move-object/from16 v6, p0

    .line 301
    iget-object v7, v6, Lio/reactivex/processors/UnicastProcessor;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    .line 302
    iget-boolean v0, v6, Lio/reactivex/processors/UnicastProcessor;->delayError:Z

    const/4 v8, 0x1

    xor-int/lit8 v9, v0, 0x1

    move v10, v8

    .line 305
    :goto_a
    iget-object v0, v6, Lio/reactivex/processors/UnicastProcessor;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v11

    const-wide/16 v4, 0x0

    :goto_12
    cmp-long v15, v11, v4

    if-eqz v15, :cond_43

    .line 309
    iget-boolean v2, v6, Lio/reactivex/processors/UnicastProcessor;->done:Z

    .line 311
    invoke-virtual {v7}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->poll()Ljava/lang/Object;

    move-result-object v3

    if-nez v3, :cond_21

    move/from16 v16, v8

    goto :goto_24

    :cond_21
    const/4 v0, 0x0

    move/from16 v16, v0

    :goto_24
    move-object/from16 v0, p0

    move v1, v9

    move-object v8, v3

    move/from16 v3, v16

    move-wide v13, v4

    move-object/from16 v4, p1

    move-object v5, v7

    .line 314
    invoke-virtual/range {v0 .. v5}, Lio/reactivex/processors/UnicastProcessor;->checkTerminated(ZZZLorg/reactivestreams/Subscriber;Lio/reactivex/internal/queue/SpscLinkedArrayQueue;)Z

    move-result v0

    if-eqz v0, :cond_35

    return-void

    :cond_35
    if-eqz v16, :cond_38

    goto :goto_44

    :cond_38
    move-object/from16 v5, p1

    .line 322
    invoke-interface {v5, v8}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    const-wide/16 v0, 0x1

    add-long/2addr v0, v13

    move-wide v4, v0

    const/4 v8, 0x1

    goto :goto_12

    :cond_43
    move-wide v13, v4

    :goto_44
    move-object/from16 v5, p1

    if-nez v15, :cond_5b

    .line 327
    iget-boolean v2, v6, Lio/reactivex/processors/UnicastProcessor;->done:Z

    invoke-virtual {v7}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->isEmpty()Z

    move-result v3

    move-object/from16 v0, p0

    move v1, v9

    move-object/from16 v4, p1

    move-object v5, v7

    invoke-virtual/range {v0 .. v5}, Lio/reactivex/processors/UnicastProcessor;->checkTerminated(ZZZLorg/reactivestreams/Subscriber;Lio/reactivex/internal/queue/SpscLinkedArrayQueue;)Z

    move-result v0

    if-eqz v0, :cond_5b

    return-void

    :cond_5b
    const-wide/16 v0, 0x0

    cmp-long v0, v13, v0

    if-eqz v0, :cond_70

    const-wide v0, 0x7fffffffffffffffL

    cmp-long v0, v11, v0

    if-eqz v0, :cond_70

    .line 332
    iget-object v0, v6, Lio/reactivex/processors/UnicastProcessor;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    neg-long v1, v13

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicLong;->addAndGet(J)J

    .line 335
    :cond_70
    iget-object v0, v6, Lio/reactivex/processors/UnicastProcessor;->wip:Lio/reactivex/internal/subscriptions/BasicIntQueueSubscription;

    neg-int v1, v10

    invoke-virtual {v0, v1}, Lio/reactivex/internal/subscriptions/BasicIntQueueSubscription;->addAndGet(I)I

    move-result v10

    if-nez v10, :cond_7a

    return-void

    :cond_7a
    const/4 v8, 0x1

    goto :goto_a
.end method

.method public getThrowable()Ljava/lang/Throwable;
    .registers 2

    .line 570
    iget-boolean v0, p0, Lio/reactivex/processors/UnicastProcessor;->done:Z

    if-eqz v0, :cond_7

    .line 571
    iget-object v0, p0, Lio/reactivex/processors/UnicastProcessor;->error:Ljava/lang/Throwable;

    return-object v0

    :cond_7
    const/4 v0, 0x0

    return-object v0
.end method

.method public hasComplete()Z
    .registers 2

    .line 578
    iget-boolean v0, p0, Lio/reactivex/processors/UnicastProcessor;->done:Z

    if-eqz v0, :cond_a

    iget-object v0, p0, Lio/reactivex/processors/UnicastProcessor;->error:Ljava/lang/Throwable;

    if-nez v0, :cond_a

    const/4 v0, 0x1

    goto :goto_b

    :cond_a
    const/4 v0, 0x0

    :goto_b
    return v0
.end method

.method public hasSubscribers()Z
    .registers 2

    .line 564
    iget-object v0, p0, Lio/reactivex/processors/UnicastProcessor;->downstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_a

    const/4 v0, 0x1

    goto :goto_b

    :cond_a
    const/4 v0, 0x0

    :goto_b
    return v0
.end method

.method public hasThrowable()Z
    .registers 2

    .line 583
    iget-boolean v0, p0, Lio/reactivex/processors/UnicastProcessor;->done:Z

    if-eqz v0, :cond_a

    iget-object v0, p0, Lio/reactivex/processors/UnicastProcessor;->error:Ljava/lang/Throwable;

    if-eqz v0, :cond_a

    const/4 v0, 0x1

    goto :goto_b

    :cond_a
    const/4 v0, 0x0

    :goto_b
    return v0
.end method

.method public onComplete()V
    .registers 2

    .line 479
    iget-boolean v0, p0, Lio/reactivex/processors/UnicastProcessor;->done:Z

    if-nez v0, :cond_12

    iget-boolean v0, p0, Lio/reactivex/processors/UnicastProcessor;->cancelled:Z

    if-eqz v0, :cond_9

    goto :goto_12

    :cond_9
    const/4 v0, 0x1

    .line 483
    iput-boolean v0, p0, Lio/reactivex/processors/UnicastProcessor;->done:Z

    .line 485
    invoke-virtual {p0}, Lio/reactivex/processors/UnicastProcessor;->doTerminate()V

    .line 487
    invoke-virtual {p0}, Lio/reactivex/processors/UnicastProcessor;->drain()V

    :cond_12
    :goto_12
    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 3

    const-string v0, "onError called with null. Null values are generally not allowed in 2.x operators and sources."

    .line 462
    invoke-static {p1, v0}, Lio/reactivex/internal/functions/ObjectHelper;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 464
    iget-boolean v0, p0, Lio/reactivex/processors/UnicastProcessor;->done:Z

    if-nez v0, :cond_1a

    iget-boolean v0, p0, Lio/reactivex/processors/UnicastProcessor;->cancelled:Z

    if-eqz v0, :cond_e

    goto :goto_1a

    .line 469
    :cond_e
    iput-object p1, p0, Lio/reactivex/processors/UnicastProcessor;->error:Ljava/lang/Throwable;

    const/4 p1, 0x1

    .line 470
    iput-boolean p1, p0, Lio/reactivex/processors/UnicastProcessor;->done:Z

    .line 472
    invoke-virtual {p0}, Lio/reactivex/processors/UnicastProcessor;->doTerminate()V

    .line 474
    invoke-virtual {p0}, Lio/reactivex/processors/UnicastProcessor;->drain()V

    return-void

    .line 465
    :cond_1a
    :goto_1a
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    const-string v0, "onNext called with null. Null values are generally not allowed in 2.x operators and sources."

    .line 450
    invoke-static {p1, v0}, Lio/reactivex/internal/functions/ObjectHelper;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 452
    iget-boolean v0, p0, Lio/reactivex/processors/UnicastProcessor;->done:Z

    if-nez v0, :cond_16

    iget-boolean v0, p0, Lio/reactivex/processors/UnicastProcessor;->cancelled:Z

    if-eqz v0, :cond_e

    goto :goto_16

    .line 456
    :cond_e
    iget-object v0, p0, Lio/reactivex/processors/UnicastProcessor;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    invoke-virtual {v0, p1}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->offer(Ljava/lang/Object;)Z

    .line 457
    invoke-virtual {p0}, Lio/reactivex/processors/UnicastProcessor;->drain()V

    :cond_16
    :goto_16
    return-void
.end method

.method public onSubscribe(Lorg/reactivestreams/Subscription;)V
    .registers 4

    .line 441
    iget-boolean v0, p0, Lio/reactivex/processors/UnicastProcessor;->done:Z

    if-nez v0, :cond_12

    iget-boolean v0, p0, Lio/reactivex/processors/UnicastProcessor;->cancelled:Z

    if-eqz v0, :cond_9

    goto :goto_12

    :cond_9
    const-wide v0, 0x7fffffffffffffffL

    .line 444
    invoke-interface {p1, v0, v1}, Lorg/reactivestreams/Subscription;->request(J)V

    goto :goto_15

    .line 442
    :cond_12
    :goto_12
    invoke-interface {p1}, Lorg/reactivestreams/Subscription;->cancel()V

    :goto_15
    return-void
.end method

.method protected subscribeActual(Lorg/reactivestreams/Subscriber;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;)V"
        }
    .end annotation

    .line 492
    iget-object v0, p0, Lio/reactivex/processors/UnicastProcessor;->once:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    if-nez v0, :cond_2b

    iget-object v0, p0, Lio/reactivex/processors/UnicastProcessor;->once:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(ZZ)Z

    move-result v0

    if-eqz v0, :cond_2b

    .line 494
    iget-object v0, p0, Lio/reactivex/processors/UnicastProcessor;->wip:Lio/reactivex/internal/subscriptions/BasicIntQueueSubscription;

    invoke-interface {p1, v0}, Lorg/reactivestreams/Subscriber;->onSubscribe(Lorg/reactivestreams/Subscription;)V

    .line 495
    iget-object v0, p0, Lio/reactivex/processors/UnicastProcessor;->downstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/atomic/AtomicReference;->set(Ljava/lang/Object;)V

    .line 496
    iget-boolean p1, p0, Lio/reactivex/processors/UnicastProcessor;->cancelled:Z

    if-eqz p1, :cond_27

    .line 497
    iget-object p1, p0, Lio/reactivex/processors/UnicastProcessor;->downstream:Ljava/util/concurrent/atomic/AtomicReference;

    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Ljava/util/concurrent/atomic/AtomicReference;->lazySet(Ljava/lang/Object;)V

    goto :goto_35

    .line 499
    :cond_27
    invoke-virtual {p0}, Lio/reactivex/processors/UnicastProcessor;->drain()V

    goto :goto_35

    .line 502
    :cond_2b
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "This processor allows only a single Subscriber"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v0, p1}, Lio/reactivex/internal/subscriptions/EmptySubscription;->error(Ljava/lang/Throwable;Lorg/reactivestreams/Subscriber;)V

    :goto_35
    return-void
.end method
