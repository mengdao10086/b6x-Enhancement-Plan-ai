.class final Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;
.super Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter;
.source "FlowableCreate.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/flowable/FlowableCreate;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "BufferAsyncEmitter"
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
.field private static final serialVersionUID:J = 0x21aef8f9f7f1cbc3L


# instance fields
.field volatile done:Z

.field error:Ljava/lang/Throwable;

.field final queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/internal/queue/SpscLinkedArrayQueue<",
            "TT;>;"
        }
    .end annotation
.end field

.field final wip:Ljava/util/concurrent/atomic/AtomicInteger;


# direct methods
.method constructor <init>(Lorg/reactivestreams/Subscriber;I)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;I)V"
        }
    .end annotation

    .line 455
    invoke-direct {p0, p1}, Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter;-><init>(Lorg/reactivestreams/Subscriber;)V

    .line 456
    new-instance p1, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    invoke-direct {p1, p2}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;-><init>(I)V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    .line 457
    new-instance p1, Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->wip:Ljava/util/concurrent/atomic/AtomicInteger;

    return-void
.end method


# virtual methods
.method drain()V
    .registers 15

    .line 509
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->wip:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndIncrement()I

    move-result v0

    if-eqz v0, :cond_9

    return-void

    .line 514
    :cond_9
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->downstream:Lorg/reactivestreams/Subscriber;

    .line 515
    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    const/4 v2, 0x1

    move v3, v2

    .line 518
    :cond_f
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->get()J

    move-result-wide v4

    const-wide/16 v6, 0x0

    move-wide v8, v6

    :goto_16
    cmp-long v10, v8, v4

    if-eqz v10, :cond_49

    .line 522
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->isCancelled()Z

    move-result v11

    if-eqz v11, :cond_24

    .line 523
    invoke-virtual {v1}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->clear()V

    return-void

    .line 527
    :cond_24
    iget-boolean v11, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->done:Z

    .line 529
    invoke-virtual {v1}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->poll()Ljava/lang/Object;

    move-result-object v12

    if-nez v12, :cond_2e

    move v13, v2

    goto :goto_2f

    :cond_2e
    const/4 v13, 0x0

    :goto_2f
    if-eqz v11, :cond_3f

    if-eqz v13, :cond_3f

    .line 534
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->error:Ljava/lang/Throwable;

    if-eqz v0, :cond_3b

    .line 536
    invoke-virtual {p0, v0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->error(Ljava/lang/Throwable;)Z

    goto :goto_3e

    .line 538
    :cond_3b
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->complete()V

    :goto_3e
    return-void

    :cond_3f
    if-eqz v13, :cond_42

    goto :goto_49

    .line 547
    :cond_42
    invoke-interface {v0, v12}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    const-wide/16 v10, 0x1

    add-long/2addr v8, v10

    goto :goto_16

    :cond_49
    :goto_49
    if-nez v10, :cond_6b

    .line 553
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->isCancelled()Z

    move-result v4

    if-eqz v4, :cond_55

    .line 554
    invoke-virtual {v1}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->clear()V

    return-void

    .line 558
    :cond_55
    iget-boolean v4, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->done:Z

    .line 560
    invoke-virtual {v1}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->isEmpty()Z

    move-result v5

    if-eqz v4, :cond_6b

    if-eqz v5, :cond_6b

    .line 563
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->error:Ljava/lang/Throwable;

    if-eqz v0, :cond_67

    .line 565
    invoke-virtual {p0, v0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->error(Ljava/lang/Throwable;)Z

    goto :goto_6a

    .line 567
    :cond_67
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->complete()V

    :goto_6a
    return-void

    :cond_6b
    cmp-long v4, v8, v6

    if-eqz v4, :cond_72

    .line 574
    invoke-static {p0, v8, v9}, Lio/reactivex/internal/util/BackpressureHelper;->produced(Ljava/util/concurrent/atomic/AtomicLong;J)J

    .line 577
    :cond_72
    iget-object v4, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->wip:Ljava/util/concurrent/atomic/AtomicInteger;

    neg-int v3, v3

    invoke-virtual {v4, v3}, Ljava/util/concurrent/atomic/AtomicInteger;->addAndGet(I)I

    move-result v3

    if-nez v3, :cond_f

    return-void
.end method

.method public onComplete()V
    .registers 2

    const/4 v0, 0x1

    .line 492
    iput-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->done:Z

    .line 493
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->drain()V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 462
    iget-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->done:Z

    if-nez v0, :cond_20

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->isCancelled()Z

    move-result v0

    if-eqz v0, :cond_b

    goto :goto_20

    :cond_b
    if-nez p1, :cond_18

    .line 467
    new-instance p1, Ljava/lang/NullPointerException;

    const-string v0, "onNext called with null. Null values are generally not allowed in 2.x operators and sources."

    invoke-direct {p1, v0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->onError(Ljava/lang/Throwable;)V

    return-void

    .line 470
    :cond_18
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    invoke-virtual {v0, p1}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->offer(Ljava/lang/Object;)Z

    .line 471
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->drain()V

    :cond_20
    :goto_20
    return-void
.end method

.method onRequested()V
    .registers 1

    .line 498
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->drain()V

    return-void
.end method

.method onUnsubscribed()V
    .registers 2

    .line 503
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->wip:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndIncrement()I

    move-result v0

    if-nez v0, :cond_d

    .line 504
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    invoke-virtual {v0}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->clear()V

    :cond_d
    return-void
.end method

.method public tryOnError(Ljava/lang/Throwable;)Z
    .registers 3

    .line 476
    iget-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->done:Z

    if-nez v0, :cond_1d

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->isCancelled()Z

    move-result v0

    if-eqz v0, :cond_b

    goto :goto_1d

    :cond_b
    if-nez p1, :cond_14

    .line 481
    new-instance p1, Ljava/lang/NullPointerException;

    const-string v0, "onError called with null. Null values are generally not allowed in 2.x operators and sources."

    invoke-direct {p1, v0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    .line 484
    :cond_14
    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->error:Ljava/lang/Throwable;

    const/4 p1, 0x1

    .line 485
    iput-boolean p1, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->done:Z

    .line 486
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$BufferAsyncEmitter;->drain()V

    return p1

    :cond_1d
    :goto_1d
    const/4 p1, 0x0

    return p1
.end method
