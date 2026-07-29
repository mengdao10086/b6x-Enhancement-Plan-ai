.class final Lio/reactivex/internal/operators/flowable/FlowableFlatMap$InnerSubscriber;
.super Ljava/util/concurrent/atomic/AtomicReference;
.source "FlowableFlatMap.java"

# interfaces
.implements Lio/reactivex/FlowableSubscriber;
.implements Lio/reactivex/disposables/Disposable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/flowable/FlowableFlatMap;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "InnerSubscriber"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        "U:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/util/concurrent/atomic/AtomicReference<",
        "Lorg/reactivestreams/Subscription;",
        ">;",
        "Lio/reactivex/FlowableSubscriber<",
        "TU;>;",
        "Lio/reactivex/disposables/Disposable;"
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = -0x3fec6c572fe7d027L


# instance fields
.field final bufferSize:I

.field volatile done:Z

.field fusionMode:I

.field final id:J

.field final limit:I

.field final parent:Lio/reactivex/internal/operators/flowable/FlowableFlatMap$MergeSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/internal/operators/flowable/FlowableFlatMap$MergeSubscriber<",
            "TT;TU;>;"
        }
    .end annotation
.end field

.field produced:J

.field volatile queue:Lio/reactivex/internal/fuseable/SimpleQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/internal/fuseable/SimpleQueue<",
            "TU;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lio/reactivex/internal/operators/flowable/FlowableFlatMap$MergeSubscriber;J)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/internal/operators/flowable/FlowableFlatMap$MergeSubscriber<",
            "TT;TU;>;J)V"
        }
    .end annotation

    .line 632
    invoke-direct {p0}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    .line 633
    iput-wide p2, p0, Lio/reactivex/internal/operators/flowable/FlowableFlatMap$InnerSubscriber;->id:J

    .line 634
    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableFlatMap$InnerSubscriber;->parent:Lio/reactivex/internal/operators/flowable/FlowableFlatMap$MergeSubscriber;

    .line 635
    iget p1, p1, Lio/reactivex/internal/operators/flowable/FlowableFlatMap$MergeSubscriber;->bufferSize:I

    iput p1, p0, Lio/reactivex/internal/operators/flowable/FlowableFlatMap$InnerSubscriber;->bufferSize:I

    shr-int/lit8 p1, p1, 0x2

    .line 636
    iput p1, p0, Lio/reactivex/internal/operators/flowable/FlowableFlatMap$InnerSubscriber;->limit:I

    return-void
.end method


# virtual methods
.method public dispose()V
    .registers 1

    .line 700
    invoke-static {p0}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->cancel(Ljava/util/concurrent/atomic/AtomicReference;)Z

    return-void
.end method

.method public isDisposed()Z
    .registers 3

    .line 705
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableFlatMap$InnerSubscriber;->get()Ljava/lang/Object;

    move-result-object v0

    sget-object v1, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->CANCELLED:Lio/reactivex/internal/subscriptions/SubscriptionHelper;

    if-ne v0, v1, :cond_a

    const/4 v0, 0x1

    goto :goto_b

    :cond_a
    const/4 v0, 0x0

    :goto_b
    return v0
.end method

.method public onComplete()V
    .registers 2

    const/4 v0, 0x1

    .line 682
    iput-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableFlatMap$InnerSubscriber;->done:Z

    .line 683
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableFlatMap$InnerSubscriber;->parent:Lio/reactivex/internal/operators/flowable/FlowableFlatMap$MergeSubscriber;

    invoke-virtual {v0}, Lio/reactivex/internal/operators/flowable/FlowableFlatMap$MergeSubscriber;->drain()V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 3

    .line 676
    sget-object v0, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->CANCELLED:Lio/reactivex/internal/subscriptions/SubscriptionHelper;

    invoke-virtual {p0, v0}, Lio/reactivex/internal/operators/flowable/FlowableFlatMap$InnerSubscriber;->lazySet(Ljava/lang/Object;)V

    .line 677
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableFlatMap$InnerSubscriber;->parent:Lio/reactivex/internal/operators/flowable/FlowableFlatMap$MergeSubscriber;

    invoke-virtual {v0, p0, p1}, Lio/reactivex/internal/operators/flowable/FlowableFlatMap$MergeSubscriber;->innerError(Lio/reactivex/internal/operators/flowable/FlowableFlatMap$InnerSubscriber;Ljava/lang/Throwable;)V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TU;)V"
        }
    .end annotation

    .line 667
    iget v0, p0, Lio/reactivex/internal/operators/flowable/FlowableFlatMap$InnerSubscriber;->fusionMode:I

    const/4 v1, 0x2

    if-eq v0, v1, :cond_b

    .line 668
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableFlatMap$InnerSubscriber;->parent:Lio/reactivex/internal/operators/flowable/FlowableFlatMap$MergeSubscriber;

    invoke-virtual {v0, p1, p0}, Lio/reactivex/internal/operators/flowable/FlowableFlatMap$MergeSubscriber;->tryEmit(Ljava/lang/Object;Lio/reactivex/internal/operators/flowable/FlowableFlatMap$InnerSubscriber;)V

    goto :goto_10

    .line 670
    :cond_b
    iget-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableFlatMap$InnerSubscriber;->parent:Lio/reactivex/internal/operators/flowable/FlowableFlatMap$MergeSubscriber;

    invoke-virtual {p1}, Lio/reactivex/internal/operators/flowable/FlowableFlatMap$MergeSubscriber;->drain()V

    :goto_10
    return-void
.end method

.method public onSubscribe(Lorg/reactivestreams/Subscription;)V
    .registers 5

    .line 641
    invoke-static {p0, p1}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->setOnce(Ljava/util/concurrent/atomic/AtomicReference;Lorg/reactivestreams/Subscription;)Z

    move-result v0

    if-eqz v0, :cond_2e

    .line 643
    instance-of v0, p1, Lio/reactivex/internal/fuseable/QueueSubscription;

    if-eqz v0, :cond_28

    .line 645
    move-object v0, p1

    check-cast v0, Lio/reactivex/internal/fuseable/QueueSubscription;

    const/4 v1, 0x7

    .line 646
    invoke-interface {v0, v1}, Lio/reactivex/internal/fuseable/QueueSubscription;->requestFusion(I)I

    move-result v1

    const/4 v2, 0x1

    if-ne v1, v2, :cond_21

    .line 648
    iput v1, p0, Lio/reactivex/internal/operators/flowable/FlowableFlatMap$InnerSubscriber;->fusionMode:I

    .line 649
    iput-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableFlatMap$InnerSubscriber;->queue:Lio/reactivex/internal/fuseable/SimpleQueue;

    .line 650
    iput-boolean v2, p0, Lio/reactivex/internal/operators/flowable/FlowableFlatMap$InnerSubscriber;->done:Z

    .line 651
    iget-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableFlatMap$InnerSubscriber;->parent:Lio/reactivex/internal/operators/flowable/FlowableFlatMap$MergeSubscriber;

    invoke-virtual {p1}, Lio/reactivex/internal/operators/flowable/FlowableFlatMap$MergeSubscriber;->drain()V

    return-void

    :cond_21
    const/4 v2, 0x2

    if-ne v1, v2, :cond_28

    .line 655
    iput v1, p0, Lio/reactivex/internal/operators/flowable/FlowableFlatMap$InnerSubscriber;->fusionMode:I

    .line 656
    iput-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableFlatMap$InnerSubscriber;->queue:Lio/reactivex/internal/fuseable/SimpleQueue;

    .line 661
    :cond_28
    iget v0, p0, Lio/reactivex/internal/operators/flowable/FlowableFlatMap$InnerSubscriber;->bufferSize:I

    int-to-long v0, v0

    invoke-interface {p1, v0, v1}, Lorg/reactivestreams/Subscription;->request(J)V

    :cond_2e
    return-void
.end method

.method requestMore(J)V
    .registers 5

    .line 687
    iget v0, p0, Lio/reactivex/internal/operators/flowable/FlowableFlatMap$InnerSubscriber;->fusionMode:I

    const/4 v1, 0x1

    if-eq v0, v1, :cond_1f

    .line 688
    iget-wide v0, p0, Lio/reactivex/internal/operators/flowable/FlowableFlatMap$InnerSubscriber;->produced:J

    add-long/2addr v0, p1

    .line 689
    iget p1, p0, Lio/reactivex/internal/operators/flowable/FlowableFlatMap$InnerSubscriber;->limit:I

    int-to-long p1, p1

    cmp-long p1, v0, p1

    if-ltz p1, :cond_1d

    const-wide/16 p1, 0x0

    .line 690
    iput-wide p1, p0, Lio/reactivex/internal/operators/flowable/FlowableFlatMap$InnerSubscriber;->produced:J

    .line 691
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableFlatMap$InnerSubscriber;->get()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lorg/reactivestreams/Subscription;

    invoke-interface {p1, v0, v1}, Lorg/reactivestreams/Subscription;->request(J)V

    goto :goto_1f

    .line 693
    :cond_1d
    iput-wide v0, p0, Lio/reactivex/internal/operators/flowable/FlowableFlatMap$InnerSubscriber;->produced:J

    :cond_1f
    :goto_1f
    return-void
.end method
