.class final Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;
.super Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter;
.source "FlowableCreate.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/flowable/FlowableCreate;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "LatestAsyncEmitter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter<",
        "TT;>;"
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = 0x37d61f4a35bdda6fL


# instance fields
.field volatile done:Z

.field error:Ljava/lang/Throwable;

.field final queue:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference<",
            "TT;>;"
        }
    .end annotation
.end field

.field final wip:Ljava/util/concurrent/atomic/AtomicInteger;


# direct methods
.method constructor <init>(Lorg/reactivestreams/Subscriber;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;)V"
        }
    .end annotation

    invoke-direct {p0, p1}, Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter;-><init>(Lorg/reactivestreams/Subscriber;)V

    new-instance p1, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->queue:Ljava/util/concurrent/atomic/AtomicReference;

    new-instance p1, Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->wip:Ljava/util/concurrent/atomic/AtomicInteger;

    return-void
.end method


# virtual methods
.method drain()V
    .registers 18

    move-object/from16 v0, p0

    iget-object v1, v0, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->wip:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndIncrement()I

    move-result v1

    if-eqz v1, :cond_b

    return-void

    :cond_b
    iget-object v1, v0, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->downstream:Lorg/reactivestreams/Subscriber;

    iget-object v2, v0, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->queue:Ljava/util/concurrent/atomic/AtomicReference;

    const/4 v3, 0x1

    move v4, v3

    :cond_11
    invoke-virtual/range {p0 .. p0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->get()J

    move-result-wide v5

    const-wide/16 v7, 0x0

    move-wide v9, v7

    :goto_18
    cmp-long v11, v9, v5

    const/4 v12, 0x0

    const/4 v13, 0x0

    if-eqz v11, :cond_4f

    invoke-virtual/range {p0 .. p0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->isCancelled()Z

    move-result v14

    if-eqz v14, :cond_28

    invoke-virtual {v2, v13}, Ljava/util/concurrent/atomic/AtomicReference;->lazySet(Ljava/lang/Object;)V

    return-void

    :cond_28
    iget-boolean v14, v0, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->done:Z

    invoke-virtual {v2, v13}, Ljava/util/concurrent/atomic/AtomicReference;->getAndSet(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v15

    if-nez v15, :cond_33

    move/from16 v16, v3

    goto :goto_35

    :cond_33
    move/from16 v16, v12

    :goto_35
    if-eqz v14, :cond_45

    if-eqz v16, :cond_45

    iget-object v1, v0, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->error:Ljava/lang/Throwable;

    if-eqz v1, :cond_41

    invoke-virtual {v0, v1}, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->error(Ljava/lang/Throwable;)Z

    goto :goto_44

    :cond_41
    invoke-virtual/range {p0 .. p0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->complete()V

    :goto_44
    return-void

    :cond_45
    if-eqz v16, :cond_48

    goto :goto_4f

    :cond_48
    invoke-interface {v1, v15}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    const-wide/16 v11, 0x1

    add-long/2addr v9, v11

    goto :goto_18

    :cond_4f
    :goto_4f
    if-nez v11, :cond_74

    invoke-virtual/range {p0 .. p0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->isCancelled()Z

    move-result v5

    if-eqz v5, :cond_5b

    invoke-virtual {v2, v13}, Ljava/util/concurrent/atomic/AtomicReference;->lazySet(Ljava/lang/Object;)V

    return-void

    :cond_5b
    iget-boolean v5, v0, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->done:Z

    invoke-virtual {v2}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v6

    if-nez v6, :cond_64

    move v12, v3

    :cond_64
    if-eqz v5, :cond_74

    if-eqz v12, :cond_74

    iget-object v1, v0, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->error:Ljava/lang/Throwable;

    if-eqz v1, :cond_70

    invoke-virtual {v0, v1}, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->error(Ljava/lang/Throwable;)Z

    goto :goto_73

    :cond_70
    invoke-virtual/range {p0 .. p0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->complete()V

    :goto_73
    return-void

    :cond_74
    cmp-long v5, v9, v7

    if-eqz v5, :cond_7b

    invoke-static {v0, v9, v10}, Lio/reactivex/internal/util/BackpressureHelper;->produced(Ljava/util/concurrent/atomic/AtomicLong;J)J

    :cond_7b
    iget-object v5, v0, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->wip:Ljava/util/concurrent/atomic/AtomicInteger;

    neg-int v4, v4

    invoke-virtual {v5, v4}, Ljava/util/concurrent/atomic/AtomicInteger;->addAndGet(I)I

    move-result v4

    if-nez v4, :cond_11

    return-void
.end method

.method public onComplete()V
    .registers 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->done:Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->drain()V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    iget-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->done:Z

    if-nez v0, :cond_20

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->isCancelled()Z

    move-result v0

    if-eqz v0, :cond_b

    goto :goto_20

    :cond_b
    if-nez p1, :cond_18

    new-instance p1, Ljava/lang/NullPointerException;

    const-string v0, "onNext called with null. Null values are generally not allowed in 2.x operators and sources."

    invoke-direct {p1, v0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->onError(Ljava/lang/Throwable;)V

    return-void

    :cond_18
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->queue:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/atomic/AtomicReference;->set(Ljava/lang/Object;)V

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->drain()V

    :cond_20
    :goto_20
    return-void
.end method

.method onRequested()V
    .registers 1

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->drain()V

    return-void
.end method

.method onUnsubscribed()V
    .registers 3

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->wip:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndIncrement()I

    move-result v0

    if-nez v0, :cond_e

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->queue:Ljava/util/concurrent/atomic/AtomicReference;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicReference;->lazySet(Ljava/lang/Object;)V

    :cond_e
    return-void
.end method

.method public tryOnError(Ljava/lang/Throwable;)Z
    .registers 4

    iget-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->done:Z

    if-nez v0, :cond_20

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->isCancelled()Z

    move-result v0

    if-eqz v0, :cond_b

    goto :goto_20

    :cond_b
    if-nez p1, :cond_17

    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "onError called with null. Null values are generally not allowed in 2.x operators and sources."

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->onError(Ljava/lang/Throwable;)V

    :cond_17
    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->error:Ljava/lang/Throwable;

    const/4 p1, 0x1

    iput-boolean p1, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->done:Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$LatestAsyncEmitter;->drain()V

    return p1

    :cond_20
    :goto_20
    const/4 p1, 0x0

    return p1
.end method
