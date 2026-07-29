.class final Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;
.super Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionBase;
.source "ParallelJoin.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/parallel/ParallelJoin;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "JoinSubscription"
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
.field private static final serialVersionUID:J = 0x579a0f4f7e6bd483L


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

    .line 138
    invoke-direct {p0, p1, p2, p3}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscriptionBase;-><init>(Lorg/reactivestreams/Subscriber;II)V

    return-void
.end method


# virtual methods
.method drain()V
    .registers 2

    .line 204
    invoke-virtual {p0}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->getAndIncrement()I

    move-result v0

    if-eqz v0, :cond_7

    return-void

    .line 208
    :cond_7
    invoke-virtual {p0}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->drainLoop()V

    return-void
.end method

.method drainLoop()V
    .registers 19

    move-object/from16 v0, p0

    .line 214
    iget-object v1, v0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->subscribers:[Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinInnerSubscriber;

    .line 215
    array-length v2, v1

    .line 216
    iget-object v3, v0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->downstream:Lorg/reactivestreams/Subscriber;

    const/4 v5, 0x1

    .line 220
    :goto_8
    iget-object v6, v0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v6}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v6

    const-wide/16 v8, 0x0

    move-wide v10, v8

    :cond_11
    cmp-long v12, v10, v6

    if-eqz v12, :cond_67

    .line 225
    iget-boolean v12, v0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->cancelled:Z

    if-eqz v12, :cond_1d

    .line 226
    invoke-virtual/range {p0 .. p0}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->cleanup()V

    return-void

    .line 230
    :cond_1d
    iget-object v12, v0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v12}, Lio/reactivex/internal/util/AtomicThrowable;->get()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/Throwable;

    if-eqz v12, :cond_2e

    .line 232
    invoke-virtual/range {p0 .. p0}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->cleanup()V

    .line 233
    invoke-interface {v3, v12}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void

    .line 237
    :cond_2e
    iget-object v12, v0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->done:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v12}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v12

    if-nez v12, :cond_38

    const/4 v12, 0x1

    goto :goto_39

    :cond_38
    const/4 v12, 0x0

    :goto_39
    const/4 v14, 0x0

    const/4 v15, 0x1

    .line 241
    :goto_3b
    array-length v4, v1

    if-ge v14, v4, :cond_5d

    .line 242
    aget-object v4, v1, v14

    .line 243
    iget-object v13, v4, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinInnerSubscriber;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    if-eqz v13, :cond_5a

    .line 245
    invoke-interface {v13}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->poll()Ljava/lang/Object;

    move-result-object v13

    if-eqz v13, :cond_5a

    .line 249
    invoke-interface {v3, v13}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    .line 250
    invoke-virtual {v4}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinInnerSubscriber;->requestOne()V

    const-wide/16 v16, 0x1

    add-long v10, v10, v16

    cmp-long v4, v10, v6

    if-nez v4, :cond_59

    goto :goto_67

    :cond_59
    const/4 v15, 0x0

    :cond_5a
    add-int/lit8 v14, v14, 0x1

    goto :goto_3b

    :cond_5d
    if-eqz v12, :cond_65

    if-eqz v15, :cond_65

    .line 259
    invoke-interface {v3}, Lorg/reactivestreams/Subscriber;->onComplete()V

    return-void

    :cond_65
    if-eqz v15, :cond_11

    :cond_67
    :goto_67
    cmp-long v4, v10, v6

    if-nez v4, :cond_ac

    .line 269
    iget-boolean v4, v0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->cancelled:Z

    if-eqz v4, :cond_73

    .line 270
    invoke-virtual/range {p0 .. p0}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->cleanup()V

    return-void

    .line 274
    :cond_73
    iget-object v4, v0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v4}, Lio/reactivex/internal/util/AtomicThrowable;->get()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Throwable;

    if-eqz v4, :cond_84

    .line 276
    invoke-virtual/range {p0 .. p0}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->cleanup()V

    .line 277
    invoke-interface {v3, v4}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void

    .line 281
    :cond_84
    iget-object v4, v0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->done:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v4}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v4

    if-nez v4, :cond_8e

    const/4 v4, 0x1

    goto :goto_8f

    :cond_8e
    const/4 v4, 0x0

    :goto_8f
    const/4 v12, 0x0

    :goto_90
    if-ge v12, v2, :cond_a3

    .line 286
    aget-object v13, v1, v12

    .line 288
    iget-object v13, v13, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinInnerSubscriber;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    if-eqz v13, :cond_a0

    .line 289
    invoke-interface {v13}, Lio/reactivex/internal/fuseable/SimpleQueue;->isEmpty()Z

    move-result v13

    if-nez v13, :cond_a0

    const/4 v13, 0x0

    goto :goto_a4

    :cond_a0
    add-int/lit8 v12, v12, 0x1

    goto :goto_90

    :cond_a3
    const/4 v13, 0x1

    :goto_a4
    if-eqz v4, :cond_ac

    if-eqz v13, :cond_ac

    .line 296
    invoke-interface {v3}, Lorg/reactivestreams/Subscriber;->onComplete()V

    return-void

    :cond_ac
    cmp-long v4, v10, v8

    if-eqz v4, :cond_bf

    const-wide v8, 0x7fffffffffffffffL

    cmp-long v4, v6, v8

    if-eqz v4, :cond_bf

    .line 302
    iget-object v4, v0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    neg-long v6, v10

    invoke-virtual {v4, v6, v7}, Ljava/util/concurrent/atomic/AtomicLong;->addAndGet(J)J

    .line 305
    :cond_bf
    invoke-virtual/range {p0 .. p0}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->get()I

    move-result v4

    if-ne v4, v5, :cond_cd

    neg-int v4, v5

    .line 307
    invoke-virtual {v0, v4}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->addAndGet(I)I

    move-result v4

    if-nez v4, :cond_cd

    return-void

    :cond_cd
    move v5, v4

    goto/16 :goto_8
.end method

.method public onComplete()V
    .registers 2

    .line 198
    iget-object v0, p0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->done:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I

    .line 199
    invoke-virtual {p0}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->drain()V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 4

    .line 186
    iget-object v0, p0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    const/4 v1, 0x0

    invoke-virtual {v0, v1, p1}, Lio/reactivex/internal/util/AtomicThrowable;->compareAndSet(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_10

    .line 187
    invoke-virtual {p0}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->cancelAll()V

    .line 188
    invoke-virtual {p0}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->drain()V

    goto :goto_1b

    .line 190
    :cond_10
    iget-object v0, p0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v0}, Lio/reactivex/internal/util/AtomicThrowable;->get()Ljava/lang/Object;

    move-result-object v0

    if-eq p1, v0, :cond_1b

    .line 191
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :cond_1b
    :goto_1b
    return-void
.end method

.method public onNext(Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinInnerSubscriber;Ljava/lang/Object;)V
    .registers 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinInnerSubscriber<",
            "TT;>;TT;)V"
        }
    .end annotation

    .line 143
    invoke-virtual {p0}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->get()I

    move-result v0

    const-string v1, "Queue full?!"

    if-nez v0, :cond_67

    const/4 v0, 0x0

    const/4 v2, 0x1

    invoke-virtual {p0, v0, v2}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->compareAndSet(II)Z

    move-result v0

    if-eqz v0, :cond_67

    .line 144
    iget-object v0, p0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v0, v2, v4

    if-eqz v0, :cond_3b

    .line 145
    iget-object v0, p0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->downstream:Lorg/reactivestreams/Subscriber;

    invoke-interface {v0, p2}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    .line 146
    iget-object p2, p0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {p2}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v0

    const-wide v2, 0x7fffffffffffffffL

    cmp-long p2, v0, v2

    if-eqz p2, :cond_35

    .line 147
    iget-object p2, p0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {p2}, Ljava/util/concurrent/atomic/AtomicLong;->decrementAndGet()J

    :cond_35
    const-wide/16 v0, 0x1

    .line 149
    invoke-virtual {p1, v0, v1}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinInnerSubscriber;->request(J)V

    goto :goto_60

    .line 151
    :cond_3b
    invoke-virtual {p1}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinInnerSubscriber;->getQueue()Lio/reactivex/internal/fuseable/SimplePlainQueue;

    move-result-object p1

    .line 153
    invoke-interface {p1, p2}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->offer(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_60

    .line 154
    invoke-virtual {p0}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->cancelAll()V

    .line 155
    new-instance p1, Lio/reactivex/exceptions/MissingBackpressureException;

    invoke-direct {p1, v1}, Lio/reactivex/exceptions/MissingBackpressureException;-><init>(Ljava/lang/String;)V

    .line 156
    iget-object p2, p0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    const/4 v0, 0x0

    invoke-virtual {p2, v0, p1}, Lio/reactivex/internal/util/AtomicThrowable;->compareAndSet(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p2

    if-eqz p2, :cond_5c

    .line 157
    iget-object p2, p0, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->downstream:Lorg/reactivestreams/Subscriber;

    invoke-interface {p2, p1}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    goto :goto_5f

    .line 159
    :cond_5c
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :goto_5f
    return-void

    .line 164
    :cond_60
    :goto_60
    invoke-virtual {p0}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->decrementAndGet()I

    move-result p1

    if-nez p1, :cond_84

    return-void

    .line 168
    :cond_67
    invoke-virtual {p1}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinInnerSubscriber;->getQueue()Lio/reactivex/internal/fuseable/SimplePlainQueue;

    move-result-object p1

    .line 170
    invoke-interface {p1, p2}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->offer(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_7d

    .line 171
    invoke-virtual {p0}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->cancelAll()V

    .line 172
    new-instance p1, Lio/reactivex/exceptions/MissingBackpressureException;

    invoke-direct {p1, v1}, Lio/reactivex/exceptions/MissingBackpressureException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->onError(Ljava/lang/Throwable;)V

    return-void

    .line 176
    :cond_7d
    invoke-virtual {p0}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->getAndIncrement()I

    move-result p1

    if-eqz p1, :cond_84

    return-void

    .line 181
    :cond_84
    invoke-virtual {p0}, Lio/reactivex/internal/operators/parallel/ParallelJoin$JoinSubscription;->drainLoop()V

    return-void
.end method
