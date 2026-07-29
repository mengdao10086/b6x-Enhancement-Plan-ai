.class final Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;
.super Ljava/util/concurrent/atomic/AtomicInteger;
.source "FlowablePublishAlt.java"

# interfaces
.implements Lio/reactivex/FlowableSubscriber;
.implements Lio/reactivex/disposables/Disposable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/flowable/FlowablePublishAlt;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "PublishConnection"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/util/concurrent/atomic/AtomicInteger;",
        "Lio/reactivex/FlowableSubscriber<",
        "TT;>;",
        "Lio/reactivex/disposables/Disposable;"
    }
.end annotation


# static fields
.field static final EMPTY:[Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;

.field static final TERMINATED:[Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;

.field private static final serialVersionUID:J = -0x17344e2bc8b53579L


# instance fields
.field final bufferSize:I

.field final connect:Ljava/util/concurrent/atomic/AtomicBoolean;

.field consumed:I

.field final current:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference<",
            "Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection<",
            "TT;>;>;"
        }
    .end annotation
.end field

.field volatile done:Z

.field error:Ljava/lang/Throwable;

.field volatile queue:Lio/reactivex/internal/fuseable/SimpleQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/internal/fuseable/SimpleQueue<",
            "TT;>;"
        }
    .end annotation
.end field

.field sourceMode:I

.field final subscribers:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference<",
            "[",
            "Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription<",
            "TT;>;>;"
        }
    .end annotation
.end field

.field final upstream:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference<",
            "Lorg/reactivestreams/Subscription;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 2

    const/4 v0, 0x0

    new-array v1, v0, [Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;

    .line 175
    sput-object v1, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->EMPTY:[Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;

    new-array v0, v0, [Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;

    .line 177
    sput-object v0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->TERMINATED:[Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;

    return-void
.end method

.method constructor <init>(Ljava/util/concurrent/atomic/AtomicReference;I)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/concurrent/atomic/AtomicReference<",
            "Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection<",
            "TT;>;>;I)V"
        }
    .end annotation

    .line 180
    invoke-direct {p0}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    .line 181
    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->current:Ljava/util/concurrent/atomic/AtomicReference;

    .line 182
    new-instance p1, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    .line 183
    new-instance p1, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->connect:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 184
    iput p2, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->bufferSize:I

    .line 185
    new-instance p1, Ljava/util/concurrent/atomic/AtomicReference;

    sget-object p2, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->EMPTY:[Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;

    invoke-direct {p1, p2}, Ljava/util/concurrent/atomic/AtomicReference;-><init>(Ljava/lang/Object;)V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    return-void
.end method


# virtual methods
.method add(Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;)Z
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription<",
            "TT;>;)Z"
        }
    .end annotation

    .line 381
    :cond_0
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;

    .line 384
    sget-object v1, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->TERMINATED:[Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;

    const/4 v2, 0x0

    if-ne v0, v1, :cond_e

    return v2

    .line 388
    :cond_e
    array-length v1, v0

    add-int/lit8 v3, v1, 0x1

    .line 390
    new-array v3, v3, [Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;

    .line 391
    invoke-static {v0, v2, v3, v2, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 392
    aput-object p1, v3, v1

    .line 394
    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v1, v0, v3}, Landroidx/lifecycle/LifecycleKt$$ExternalSyntheticBackportWithForwarding0;->m(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 p1, 0x1

    return p1
.end method

.method checkTerminated(ZZ)Z
    .registers 6

    const/4 v0, 0x0

    if-eqz p1, :cond_2c

    if-eqz p2, :cond_2c

    .line 352
    iget-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->error:Ljava/lang/Throwable;

    if-eqz p1, :cond_d

    .line 355
    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->signalError(Ljava/lang/Throwable;)V

    goto :goto_2a

    .line 357
    :cond_d
    iget-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    sget-object p2, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->TERMINATED:[Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;

    invoke-virtual {p1, p2}, Ljava/util/concurrent/atomic/AtomicReference;->getAndSet(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, [Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;

    array-length p2, p1

    :goto_18
    if-ge v0, p2, :cond_2a

    aget-object v1, p1, v0

    .line 358
    invoke-virtual {v1}, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;->isCancelled()Z

    move-result v2

    if-nez v2, :cond_27

    .line 359
    iget-object v1, v1, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;->downstream:Lorg/reactivestreams/Subscriber;

    invoke-interface {v1}, Lorg/reactivestreams/Subscriber;->onComplete()V

    :cond_27
    add-int/lit8 v0, v0, 0x1

    goto :goto_18

    :cond_2a
    :goto_2a
    const/4 p1, 0x1

    return p1

    :cond_2c
    return v0
.end method

.method public dispose()V
    .registers 3

    .line 191
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    sget-object v1, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->TERMINATED:[Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicReference;->getAndSet(Ljava/lang/Object;)Ljava/lang/Object;

    .line 192
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->current:Ljava/util/concurrent/atomic/AtomicReference;

    const/4 v1, 0x0

    invoke-static {v0, p0, v1}, Landroidx/lifecycle/LifecycleKt$$ExternalSyntheticBackportWithForwarding0;->m(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 193
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->cancel(Ljava/util/concurrent/atomic/AtomicReference;)Z

    return-void
.end method

.method drain()V
    .registers 22

    move-object/from16 v1, p0

    .line 260
    invoke-virtual/range {p0 .. p0}, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->getAndIncrement()I

    move-result v0

    if-eqz v0, :cond_9

    return-void

    .line 265
    :cond_9
    iget-object v0, v1, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->queue:Lio/reactivex/internal/fuseable/SimpleQueue;

    .line 266
    iget v2, v1, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->consumed:I

    .line 267
    iget v3, v1, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->bufferSize:I

    shr-int/lit8 v4, v3, 0x2

    sub-int/2addr v3, v4

    .line 268
    iget v4, v1, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->sourceMode:I

    const/4 v6, 0x1

    if-eq v4, v6, :cond_19

    move v4, v6

    goto :goto_1a

    :cond_19
    const/4 v4, 0x0

    :goto_1a
    move v7, v6

    move/from16 v20, v2

    move-object v2, v0

    move/from16 v0, v20

    :cond_20
    :goto_20
    if-eqz v2, :cond_d0

    .line 276
    iget-object v8, v1, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v8}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, [Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;

    .line 278
    array-length v9, v8

    const-wide v10, 0x7fffffffffffffffL

    const/4 v12, 0x0

    const/4 v13, 0x0

    :goto_32
    if-ge v12, v9, :cond_4c

    aget-object v14, v8, v12

    .line 279
    invoke-virtual {v14}, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;->get()J

    move-result-wide v15

    const-wide/high16 v17, -0x8000000000000000L

    cmp-long v17, v15, v17

    if-eqz v17, :cond_49

    .line 282
    iget-wide v13, v14, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;->emitted:J

    sub-long v13, v15, v13

    invoke-static {v13, v14, v10, v11}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v10

    move v13, v6

    :cond_49
    add-int/lit8 v12, v12, 0x1

    goto :goto_32

    :cond_4c
    const-wide/16 v14, 0x0

    if-nez v13, :cond_51

    move-wide v10, v14

    :cond_51
    :goto_51
    cmp-long v9, v10, v14

    if-eqz v9, :cond_c3

    .line 291
    iget-boolean v9, v1, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->done:Z

    .line 295
    :try_start_57
    invoke-interface {v2}, Lio/reactivex/internal/fuseable/SimpleQueue;->poll()Ljava/lang/Object;

    move-result-object v12
    :try_end_5b
    .catchall {:try_start_57 .. :try_end_5b} :catchall_aa

    if-nez v12, :cond_5f

    move v13, v6

    goto :goto_60

    :cond_5f
    const/4 v13, 0x0

    .line 307
    :goto_60
    invoke-virtual {v1, v9, v13}, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->checkTerminated(ZZ)Z

    move-result v9

    if-eqz v9, :cond_67

    return-void

    :cond_67
    if-eqz v13, :cond_6a

    goto :goto_c3

    .line 315
    :cond_6a
    array-length v9, v8

    const/4 v13, 0x0

    :goto_6c
    const-wide/16 v16, 0x1

    if-ge v13, v9, :cond_88

    aget-object v5, v8, v13

    .line 316
    invoke-virtual {v5}, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;->isCancelled()Z

    move-result v19

    if-nez v19, :cond_83

    .line 317
    iget-object v14, v5, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;->downstream:Lorg/reactivestreams/Subscriber;

    invoke-interface {v14, v12}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    .line 318
    iget-wide v14, v5, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;->emitted:J

    add-long v14, v14, v16

    iput-wide v14, v5, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;->emitted:J

    :cond_83
    add-int/lit8 v13, v13, 0x1

    const-wide/16 v14, 0x0

    goto :goto_6c

    :cond_88
    if-eqz v4, :cond_9b

    add-int/lit8 v0, v0, 0x1

    if-ne v0, v3, :cond_9b

    .line 324
    iget-object v0, v1, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/reactivestreams/Subscription;

    int-to-long v12, v3

    invoke-interface {v0, v12, v13}, Lorg/reactivestreams/Subscription;->request(J)V

    const/4 v0, 0x0

    :cond_9b
    sub-long v10, v10, v16

    .line 328
    iget-object v5, v1, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v5}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v5

    if-eq v8, v5, :cond_a7

    goto/16 :goto_20

    :cond_a7
    const-wide/16 v14, 0x0

    goto :goto_51

    :catchall_aa
    move-exception v0

    move-object v3, v0

    .line 297
    invoke-static {v3}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 298
    iget-object v0, v1, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/reactivestreams/Subscription;

    invoke-interface {v0}, Lorg/reactivestreams/Subscription;->cancel()V

    .line 299
    invoke-interface {v2}, Lio/reactivex/internal/fuseable/SimpleQueue;->clear()V

    .line 300
    iput-boolean v6, v1, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->done:Z

    .line 301
    invoke-virtual {v1, v3}, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->signalError(Ljava/lang/Throwable;)V

    return-void

    .line 333
    :cond_c3
    :goto_c3
    iget-boolean v5, v1, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->done:Z

    invoke-interface {v2}, Lio/reactivex/internal/fuseable/SimpleQueue;->isEmpty()Z

    move-result v8

    invoke-virtual {v1, v5, v8}, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->checkTerminated(ZZ)Z

    move-result v5

    if-eqz v5, :cond_d0

    return-void

    .line 338
    :cond_d0
    iput v0, v1, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->consumed:I

    neg-int v5, v7

    .line 339
    invoke-virtual {v1, v5}, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->addAndGet(I)I

    move-result v7

    if-nez v7, :cond_da

    return-void

    :cond_da
    if-nez v2, :cond_20

    .line 344
    iget-object v2, v1, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->queue:Lio/reactivex/internal/fuseable/SimpleQueue;

    goto/16 :goto_20
.end method

.method public isDisposed()Z
    .registers 3

    .line 198
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    sget-object v1, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->TERMINATED:[Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;

    if-ne v0, v1, :cond_c

    const/4 v0, 0x1

    goto :goto_d

    :cond_c
    const/4 v0, 0x0

    :goto_d
    return v0
.end method

.method public onComplete()V
    .registers 2

    const/4 v0, 0x1

    .line 255
    iput-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->done:Z

    .line 256
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->drain()V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 3

    .line 244
    iget-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->done:Z

    if-eqz v0, :cond_8

    .line 245
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    goto :goto_10

    .line 247
    :cond_8
    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->error:Ljava/lang/Throwable;

    const/4 p1, 0x1

    .line 248
    iput-boolean p1, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->done:Z

    .line 249
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->drain()V

    :goto_10
    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 233
    iget v0, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->sourceMode:I

    if-nez v0, :cond_17

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->queue:Lio/reactivex/internal/fuseable/SimpleQueue;

    invoke-interface {v0, p1}, Lio/reactivex/internal/fuseable/SimpleQueue;->offer(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_17

    .line 234
    new-instance p1, Lio/reactivex/exceptions/MissingBackpressureException;

    const-string v0, "Prefetch queue is full?!"

    invoke-direct {p1, v0}, Lio/reactivex/exceptions/MissingBackpressureException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->onError(Ljava/lang/Throwable;)V

    return-void

    .line 239
    :cond_17
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->drain()V

    return-void
.end method

.method public onSubscribe(Lorg/reactivestreams/Subscription;)V
    .registers 5

    .line 203
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0, p1}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->setOnce(Ljava/util/concurrent/atomic/AtomicReference;Lorg/reactivestreams/Subscription;)Z

    move-result v0

    if-eqz v0, :cond_3e

    .line 204
    instance-of v0, p1, Lio/reactivex/internal/fuseable/QueueSubscription;

    if-eqz v0, :cond_2f

    .line 206
    move-object v0, p1

    check-cast v0, Lio/reactivex/internal/fuseable/QueueSubscription;

    const/4 v1, 0x7

    .line 208
    invoke-interface {v0, v1}, Lio/reactivex/internal/fuseable/QueueSubscription;->requestFusion(I)I

    move-result v1

    const/4 v2, 0x1

    if-ne v1, v2, :cond_21

    .line 210
    iput v1, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->sourceMode:I

    .line 211
    iput-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->queue:Lio/reactivex/internal/fuseable/SimpleQueue;

    .line 212
    iput-boolean v2, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->done:Z

    .line 213
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->drain()V

    return-void

    :cond_21
    const/4 v2, 0x2

    if-ne v1, v2, :cond_2f

    .line 217
    iput v1, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->sourceMode:I

    .line 218
    iput-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->queue:Lio/reactivex/internal/fuseable/SimpleQueue;

    .line 219
    iget v0, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->bufferSize:I

    int-to-long v0, v0

    invoke-interface {p1, v0, v1}, Lorg/reactivestreams/Subscription;->request(J)V

    return-void

    .line 224
    :cond_2f
    new-instance v0, Lio/reactivex/internal/queue/SpscArrayQueue;

    iget v1, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->bufferSize:I

    invoke-direct {v0, v1}, Lio/reactivex/internal/queue/SpscArrayQueue;-><init>(I)V

    iput-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->queue:Lio/reactivex/internal/fuseable/SimpleQueue;

    .line 226
    iget v0, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->bufferSize:I

    int-to-long v0, v0

    invoke-interface {p1, v0, v1}, Lorg/reactivestreams/Subscription;->request(J)V

    :cond_3e
    return-void
.end method

.method remove(Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;)V
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription<",
            "TT;>;)V"
        }
    .end annotation

    .line 407
    :cond_0
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;

    .line 408
    array-length v1, v0

    if-nez v1, :cond_c

    goto :goto_39

    :cond_c
    const/4 v2, 0x0

    move v3, v2

    :goto_e
    if-ge v3, v1, :cond_18

    .line 417
    aget-object v4, v0, v3

    if-ne v4, p1, :cond_15

    goto :goto_19

    :cond_15
    add-int/lit8 v3, v3, 0x1

    goto :goto_e

    :cond_18
    const/4 v3, -0x1

    :goto_19
    if-gez v3, :cond_1c

    return-void

    :cond_1c
    const/4 v4, 0x1

    if-ne v1, v4, :cond_22

    .line 431
    sget-object v1, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->EMPTY:[Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;

    goto :goto_31

    :cond_22
    add-int/lit8 v5, v1, -0x1

    .line 434
    new-array v5, v5, [Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;

    .line 436
    invoke-static {v0, v2, v5, v2, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    add-int/lit8 v2, v3, 0x1

    sub-int/2addr v1, v3

    sub-int/2addr v1, v4

    .line 438
    invoke-static {v0, v2, v5, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    move-object v1, v5

    .line 441
    :goto_31
    iget-object v2, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v2, v0, v1}, Landroidx/lifecycle/LifecycleKt$$ExternalSyntheticBackportWithForwarding0;->m(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :goto_39
    return-void
.end method

.method signalError(Ljava/lang/Throwable;)V
    .registers 7

    .line 370
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    sget-object v1, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->TERMINATED:[Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicReference;->getAndSet(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;

    array-length v1, v0

    const/4 v2, 0x0

    :goto_c
    if-ge v2, v1, :cond_1e

    aget-object v3, v0, v2

    .line 371
    invoke-virtual {v3}, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;->isCancelled()Z

    move-result v4

    if-nez v4, :cond_1b

    .line 372
    iget-object v3, v3, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;->downstream:Lorg/reactivestreams/Subscriber;

    invoke-interface {v3, p1}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    :cond_1b
    add-int/lit8 v2, v2, 0x1

    goto :goto_c

    :cond_1e
    return-void
.end method
