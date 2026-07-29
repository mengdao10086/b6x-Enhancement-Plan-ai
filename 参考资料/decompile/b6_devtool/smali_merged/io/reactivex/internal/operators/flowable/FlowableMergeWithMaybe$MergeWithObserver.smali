.class final Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;
.super Ljava/util/concurrent/atomic/AtomicInteger;
.source "FlowableMergeWithMaybe.java"

# interfaces
.implements Lio/reactivex/FlowableSubscriber;
.implements Lorg/reactivestreams/Subscription;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "MergeWithObserver"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver$OtherObserver;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/util/concurrent/atomic/AtomicInteger;",
        "Lio/reactivex/FlowableSubscriber<",
        "TT;>;",
        "Lorg/reactivestreams/Subscription;"
    }
.end annotation


# static fields
.field static final OTHER_STATE_CONSUMED_OR_EMPTY:I = 0x2

.field static final OTHER_STATE_HAS_VALUE:I = 0x1

.field private static final serialVersionUID:J = -0x3fbd8a98db8e76f7L


# instance fields
.field volatile cancelled:Z

.field consumed:I

.field final downstream:Lorg/reactivestreams/Subscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;"
        }
    .end annotation
.end field

.field emitted:J

.field final error:Lio/reactivex/internal/util/AtomicThrowable;

.field final limit:I

.field volatile mainDone:Z

.field final mainSubscription:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference<",
            "Lorg/reactivestreams/Subscription;",
            ">;"
        }
    .end annotation
.end field

.field final otherObserver:Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver$OtherObserver;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver$OtherObserver<",
            "TT;>;"
        }
    .end annotation
.end field

.field volatile otherState:I

.field final prefetch:I

.field volatile queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/internal/fuseable/SimplePlainQueue<",
            "TT;>;"
        }
    .end annotation
.end field

.field final requested:Ljava/util/concurrent/atomic/AtomicLong;

.field singleItem:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lorg/reactivestreams/Subscriber;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;)V"
        }
    .end annotation

    .line 90
    invoke-direct {p0}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    .line 91
    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->downstream:Lorg/reactivestreams/Subscriber;

    .line 92
    new-instance p1, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->mainSubscription:Ljava/util/concurrent/atomic/AtomicReference;

    .line 93
    new-instance p1, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver$OtherObserver;

    invoke-direct {p1, p0}, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver$OtherObserver;-><init>(Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;)V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->otherObserver:Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver$OtherObserver;

    .line 94
    new-instance p1, Lio/reactivex/internal/util/AtomicThrowable;

    invoke-direct {p1}, Lio/reactivex/internal/util/AtomicThrowable;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->error:Lio/reactivex/internal/util/AtomicThrowable;

    .line 95
    new-instance p1, Ljava/util/concurrent/atomic/AtomicLong;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicLong;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    .line 96
    invoke-static {}, Lio/reactivex/Flowable;->bufferSize()I

    move-result p1

    iput p1, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->prefetch:I

    shr-int/lit8 v0, p1, 0x2

    sub-int/2addr p1, v0

    .line 97
    iput p1, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->limit:I

    return-void
.end method


# virtual methods
.method public cancel()V
    .registers 2

    const/4 v0, 0x1

    .line 167
    iput-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->cancelled:Z

    .line 168
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->mainSubscription:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->cancel(Ljava/util/concurrent/atomic/AtomicReference;)Z

    .line 169
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->otherObserver:Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver$OtherObserver;

    invoke-static {v0}, Lio/reactivex/internal/disposables/DisposableHelper;->dispose(Ljava/util/concurrent/atomic/AtomicReference;)Z

    .line 170
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->getAndIncrement()I

    move-result v0

    if-nez v0, :cond_18

    const/4 v0, 0x0

    .line 171
    iput-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    .line 172
    iput-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->singleItem:Ljava/lang/Object;

    :cond_18
    return-void
.end method

.method drain()V
    .registers 2

    .line 225
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->getAndIncrement()I

    move-result v0

    if-nez v0, :cond_9

    .line 226
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->drainLoop()V

    :cond_9
    return-void
.end method

.method drainLoop()V
    .registers 19

    move-object/from16 v0, p0

    .line 231
    iget-object v1, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->downstream:Lorg/reactivestreams/Subscriber;

    .line 233
    iget-wide v2, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->emitted:J

    .line 234
    iget v4, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->consumed:I

    .line 235
    iget v5, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->limit:I

    const/4 v6, 0x1

    move v7, v6

    .line 238
    :goto_c
    iget-object v8, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v8}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v8

    :goto_12
    cmp-long v10, v2, v8

    const/4 v12, 0x2

    const/4 v13, 0x0

    if-eqz v10, :cond_81

    .line 241
    iget-boolean v14, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->cancelled:Z

    if-eqz v14, :cond_21

    .line 242
    iput-object v13, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->singleItem:Ljava/lang/Object;

    .line 243
    iput-object v13, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    return-void

    .line 247
    :cond_21
    iget-object v14, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->error:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v14}, Lio/reactivex/internal/util/AtomicThrowable;->get()Ljava/lang/Object;

    move-result-object v14

    if-eqz v14, :cond_37

    .line 248
    iput-object v13, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->singleItem:Ljava/lang/Object;

    .line 249
    iput-object v13, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    .line 250
    iget-object v2, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->error:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v2}, Lio/reactivex/internal/util/AtomicThrowable;->terminate()Ljava/lang/Throwable;

    move-result-object v2

    invoke-interface {v1, v2}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void

    .line 254
    :cond_37
    iget v14, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->otherState:I

    const-wide/16 v15, 0x1

    if-ne v14, v6, :cond_48

    .line 256
    iget-object v10, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->singleItem:Ljava/lang/Object;

    .line 257
    iput-object v13, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->singleItem:Ljava/lang/Object;

    .line 258
    iput v12, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->otherState:I

    .line 260
    invoke-interface {v1, v10}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    add-long/2addr v2, v15

    goto :goto_12

    .line 266
    :cond_48
    iget-boolean v6, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->mainDone:Z

    .line 267
    iget-object v11, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    if-eqz v11, :cond_53

    .line 268
    invoke-interface {v11}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->poll()Ljava/lang/Object;

    move-result-object v11

    goto :goto_54

    :cond_53
    move-object v11, v13

    :goto_54
    if-nez v11, :cond_59

    const/16 v17, 0x1

    goto :goto_5b

    :cond_59
    const/16 v17, 0x0

    :goto_5b
    if-eqz v6, :cond_67

    if-eqz v17, :cond_67

    if-ne v14, v12, :cond_67

    .line 272
    iput-object v13, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    .line 273
    invoke-interface {v1}, Lorg/reactivestreams/Subscriber;->onComplete()V

    return-void

    :cond_67
    if-eqz v17, :cond_6a

    goto :goto_81

    .line 281
    :cond_6a
    invoke-interface {v1, v11}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    add-long/2addr v2, v15

    add-int/lit8 v4, v4, 0x1

    if-ne v4, v5, :cond_7f

    .line 287
    iget-object v4, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->mainSubscription:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v4}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lorg/reactivestreams/Subscription;

    int-to-long v10, v5

    invoke-interface {v4, v10, v11}, Lorg/reactivestreams/Subscription;->request(J)V

    const/4 v4, 0x0

    :cond_7f
    const/4 v6, 0x1

    goto :goto_12

    :cond_81
    :goto_81
    if-nez v10, :cond_c0

    .line 292
    iget-boolean v6, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->cancelled:Z

    if-eqz v6, :cond_8c

    .line 293
    iput-object v13, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->singleItem:Ljava/lang/Object;

    .line 294
    iput-object v13, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    return-void

    .line 298
    :cond_8c
    iget-object v6, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->error:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v6}, Lio/reactivex/internal/util/AtomicThrowable;->get()Ljava/lang/Object;

    move-result-object v6

    if-eqz v6, :cond_a2

    .line 299
    iput-object v13, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->singleItem:Ljava/lang/Object;

    .line 300
    iput-object v13, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    .line 301
    iget-object v2, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->error:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v2}, Lio/reactivex/internal/util/AtomicThrowable;->terminate()Ljava/lang/Throwable;

    move-result-object v2

    invoke-interface {v1, v2}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void

    .line 305
    :cond_a2
    iget-boolean v6, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->mainDone:Z

    .line 306
    iget-object v8, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    if-eqz v8, :cond_b1

    .line 307
    invoke-interface {v8}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->isEmpty()Z

    move-result v8

    if-eqz v8, :cond_af

    goto :goto_b1

    :cond_af
    const/4 v11, 0x0

    goto :goto_b2

    :cond_b1
    :goto_b1
    const/4 v11, 0x1

    :goto_b2
    if-eqz v6, :cond_c0

    if-eqz v11, :cond_c0

    .line 309
    iget v6, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->otherState:I

    if-ne v6, v12, :cond_c0

    .line 310
    iput-object v13, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    .line 311
    invoke-interface {v1}, Lorg/reactivestreams/Subscriber;->onComplete()V

    return-void

    .line 316
    :cond_c0
    iput-wide v2, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->emitted:J

    .line 317
    iput v4, v0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->consumed:I

    neg-int v6, v7

    .line 318
    invoke-virtual {v0, v6}, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->addAndGet(I)I

    move-result v7

    if-nez v7, :cond_cc

    return-void

    :cond_cc
    const/4 v6, 0x1

    goto/16 :goto_c
.end method

.method getOrCreateQueue()Lio/reactivex/internal/fuseable/SimplePlainQueue;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lio/reactivex/internal/fuseable/SimplePlainQueue<",
            "TT;>;"
        }
    .end annotation

    .line 216
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    if-nez v0, :cond_f

    .line 218
    new-instance v0, Lio/reactivex/internal/queue/SpscArrayQueue;

    invoke-static {}, Lio/reactivex/Flowable;->bufferSize()I

    move-result v1

    invoke-direct {v0, v1}, Lio/reactivex/internal/queue/SpscArrayQueue;-><init>(I)V

    .line 219
    iput-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    :cond_f
    return-object v0
.end method

.method public onComplete()V
    .registers 2

    const/4 v0, 0x1

    .line 155
    iput-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->mainDone:Z

    .line 156
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->drain()V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 3

    .line 145
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->error:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v0, p1}, Lio/reactivex/internal/util/AtomicThrowable;->addThrowable(Ljava/lang/Throwable;)Z

    move-result v0

    if-eqz v0, :cond_11

    .line 146
    iget-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->otherObserver:Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver$OtherObserver;

    invoke-static {p1}, Lio/reactivex/internal/disposables/DisposableHelper;->dispose(Ljava/util/concurrent/atomic/AtomicReference;)Z

    .line 147
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->drain()V

    goto :goto_14

    .line 149
    :cond_11
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :goto_14
    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    const/4 v0, 0x0

    const/4 v1, 0x1

    .line 107
    invoke-virtual {p0, v0, v1}, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->compareAndSet(II)Z

    move-result v2

    if-eqz v2, :cond_54

    .line 108
    iget-wide v2, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->emitted:J

    .line 109
    iget-object v4, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v4}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v4

    cmp-long v4, v4, v2

    if-eqz v4, :cond_46

    .line 110
    iget-object v4, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    if-eqz v4, :cond_23

    .line 111
    invoke-interface {v4}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->isEmpty()Z

    move-result v5

    if-eqz v5, :cond_1f

    goto :goto_23

    .line 124
    :cond_1f
    invoke-interface {v4, p1}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->offer(Ljava/lang/Object;)Z

    goto :goto_4d

    :cond_23
    :goto_23
    const-wide/16 v4, 0x1

    add-long/2addr v2, v4

    .line 113
    iput-wide v2, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->emitted:J

    .line 114
    iget-object v2, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->downstream:Lorg/reactivestreams/Subscriber;

    invoke-interface {v2, p1}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    .line 116
    iget p1, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->consumed:I

    add-int/2addr p1, v1

    .line 117
    iget v1, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->limit:I

    if-ne p1, v1, :cond_43

    .line 118
    iput v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->consumed:I

    .line 119
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->mainSubscription:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/reactivestreams/Subscription;

    int-to-long v1, p1

    invoke-interface {v0, v1, v2}, Lorg/reactivestreams/Subscription;->request(J)V

    goto :goto_4d

    .line 121
    :cond_43
    iput p1, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->consumed:I

    goto :goto_4d

    .line 127
    :cond_46
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->getOrCreateQueue()Lio/reactivex/internal/fuseable/SimplePlainQueue;

    move-result-object v0

    .line 128
    invoke-interface {v0, p1}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->offer(Ljava/lang/Object;)Z

    .line 130
    :goto_4d
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->decrementAndGet()I

    move-result p1

    if-nez p1, :cond_62

    return-void

    .line 134
    :cond_54
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->getOrCreateQueue()Lio/reactivex/internal/fuseable/SimplePlainQueue;

    move-result-object v0

    .line 135
    invoke-interface {v0, p1}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->offer(Ljava/lang/Object;)Z

    .line 136
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->getAndIncrement()I

    move-result p1

    if-eqz p1, :cond_62

    return-void

    .line 140
    :cond_62
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->drainLoop()V

    return-void
.end method

.method public onSubscribe(Lorg/reactivestreams/Subscription;)V
    .registers 5

    .line 102
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->mainSubscription:Ljava/util/concurrent/atomic/AtomicReference;

    iget v1, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->prefetch:I

    int-to-long v1, v1

    invoke-static {v0, p1, v1, v2}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->setOnce(Ljava/util/concurrent/atomic/AtomicReference;Lorg/reactivestreams/Subscription;J)Z

    return-void
.end method

.method otherComplete()V
    .registers 2

    const/4 v0, 0x2

    .line 211
    iput v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->otherState:I

    .line 212
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->drain()V

    return-void
.end method

.method otherError(Ljava/lang/Throwable;)V
    .registers 3

    .line 202
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->error:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v0, p1}, Lio/reactivex/internal/util/AtomicThrowable;->addThrowable(Ljava/lang/Throwable;)Z

    move-result v0

    if-eqz v0, :cond_11

    .line 203
    iget-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->mainSubscription:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {p1}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->cancel(Ljava/util/concurrent/atomic/AtomicReference;)Z

    .line 204
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->drain()V

    goto :goto_14

    .line 206
    :cond_11
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :goto_14
    return-void
.end method

.method otherSuccess(Ljava/lang/Object;)V
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    const/4 v0, 0x0

    const/4 v1, 0x1

    .line 177
    invoke-virtual {p0, v0, v1}, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->compareAndSet(II)Z

    move-result v0

    if-eqz v0, :cond_2d

    .line 178
    iget-wide v2, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->emitted:J

    .line 179
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v4

    cmp-long v0, v4, v2

    if-eqz v0, :cond_22

    const-wide/16 v0, 0x1

    add-long/2addr v2, v0

    .line 181
    iput-wide v2, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->emitted:J

    .line 182
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->downstream:Lorg/reactivestreams/Subscriber;

    invoke-interface {v0, p1}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    const/4 p1, 0x2

    .line 183
    iput p1, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->otherState:I

    goto :goto_38

    .line 185
    :cond_22
    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->singleItem:Ljava/lang/Object;

    .line 186
    iput v1, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->otherState:I

    .line 187
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->decrementAndGet()I

    move-result p1

    if-nez p1, :cond_38

    return-void

    .line 192
    :cond_2d
    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->singleItem:Ljava/lang/Object;

    .line 193
    iput v1, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->otherState:I

    .line 194
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->getAndIncrement()I

    move-result p1

    if-eqz p1, :cond_38

    return-void

    .line 198
    :cond_38
    :goto_38
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->drainLoop()V

    return-void
.end method

.method public request(J)V
    .registers 4

    .line 161
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-static {v0, p1, p2}, Lio/reactivex/internal/util/BackpressureHelper;->add(Ljava/util/concurrent/atomic/AtomicLong;J)J

    .line 162
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableMergeWithMaybe$MergeWithObserver;->drain()V

    return-void
.end method
