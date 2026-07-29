.class final Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualSubscriber;
.super Ljava/util/concurrent/atomic/AtomicReference;
.source "FlowableSequenceEqual.java"

# interfaces
.implements Lio/reactivex/FlowableSubscriber;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "EqualSubscriber"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/util/concurrent/atomic/AtomicReference<",
        "Lorg/reactivestreams/Subscription;",
        ">;",
        "Lio/reactivex/FlowableSubscriber<",
        "TT;>;"
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = 0x42abb13cc59281abL


# instance fields
.field volatile done:Z

.field final limit:I

.field final parent:Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualCoordinatorHelper;

.field final prefetch:I

.field produced:J

.field volatile queue:Lio/reactivex/internal/fuseable/SimpleQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/internal/fuseable/SimpleQueue<",
            "TT;>;"
        }
    .end annotation
.end field

.field sourceMode:I


# direct methods
.method constructor <init>(Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualCoordinatorHelper;I)V
    .registers 3

    invoke-direct {p0}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualSubscriber;->parent:Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualCoordinatorHelper;

    shr-int/lit8 p1, p2, 0x2

    sub-int p1, p2, p1

    iput p1, p0, Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualSubscriber;->limit:I

    iput p2, p0, Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualSubscriber;->prefetch:I

    return-void
.end method


# virtual methods
.method public cancel()V
    .registers 1

    invoke-static {p0}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->cancel(Ljava/util/concurrent/atomic/AtomicReference;)Z

    return-void
.end method

.method clear()V
    .registers 2

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualSubscriber;->queue:Lio/reactivex/internal/fuseable/SimpleQueue;

    if-eqz v0, :cond_7

    invoke-interface {v0}, Lio/reactivex/internal/fuseable/SimpleQueue;->clear()V

    :cond_7
    return-void
.end method

.method public onComplete()V
    .registers 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualSubscriber;->done:Z

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualSubscriber;->parent:Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualCoordinatorHelper;

    invoke-interface {v0}, Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualCoordinatorHelper;->drain()V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 3

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualSubscriber;->parent:Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualCoordinatorHelper;

    invoke-interface {v0, p1}, Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualCoordinatorHelper;->innerError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    iget v0, p0, Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualSubscriber;->sourceMode:I

    if-nez v0, :cond_15

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualSubscriber;->queue:Lio/reactivex/internal/fuseable/SimpleQueue;

    invoke-interface {v0, p1}, Lio/reactivex/internal/fuseable/SimpleQueue;->offer(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_15

    new-instance p1, Lio/reactivex/exceptions/MissingBackpressureException;

    invoke-direct {p1}, Lio/reactivex/exceptions/MissingBackpressureException;-><init>()V

    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualSubscriber;->onError(Ljava/lang/Throwable;)V

    return-void

    :cond_15
    iget-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualSubscriber;->parent:Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualCoordinatorHelper;

    invoke-interface {p1}, Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualCoordinatorHelper;->drain()V

    return-void
.end method

.method public onSubscribe(Lorg/reactivestreams/Subscription;)V
    .registers 5

    invoke-static {p0, p1}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->setOnce(Ljava/util/concurrent/atomic/AtomicReference;Lorg/reactivestreams/Subscription;)Z

    move-result v0

    if-eqz v0, :cond_3e

    instance-of v0, p1, Lio/reactivex/internal/fuseable/QueueSubscription;

    if-eqz v0, :cond_2f

    move-object v0, p1

    check-cast v0, Lio/reactivex/internal/fuseable/QueueSubscription;

    const/4 v1, 0x3

    invoke-interface {v0, v1}, Lio/reactivex/internal/fuseable/QueueSubscription;->requestFusion(I)I

    move-result v1

    const/4 v2, 0x1

    if-ne v1, v2, :cond_21

    iput v1, p0, Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualSubscriber;->sourceMode:I

    iput-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualSubscriber;->queue:Lio/reactivex/internal/fuseable/SimpleQueue;

    iput-boolean v2, p0, Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualSubscriber;->done:Z

    iget-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualSubscriber;->parent:Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualCoordinatorHelper;

    invoke-interface {p1}, Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualCoordinatorHelper;->drain()V

    return-void

    :cond_21
    const/4 v2, 0x2

    if-ne v1, v2, :cond_2f

    iput v1, p0, Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualSubscriber;->sourceMode:I

    iput-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualSubscriber;->queue:Lio/reactivex/internal/fuseable/SimpleQueue;

    iget v0, p0, Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualSubscriber;->prefetch:I

    int-to-long v0, v0

    invoke-interface {p1, v0, v1}, Lorg/reactivestreams/Subscription;->request(J)V

    return-void

    :cond_2f
    new-instance v0, Lio/reactivex/internal/queue/SpscArrayQueue;

    iget v1, p0, Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualSubscriber;->prefetch:I

    invoke-direct {v0, v1}, Lio/reactivex/internal/queue/SpscArrayQueue;-><init>(I)V

    iput-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualSubscriber;->queue:Lio/reactivex/internal/fuseable/SimpleQueue;

    iget v0, p0, Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualSubscriber;->prefetch:I

    int-to-long v0, v0

    invoke-interface {p1, v0, v1}, Lorg/reactivestreams/Subscription;->request(J)V

    :cond_3e
    return-void
.end method

.method public request()V
    .registers 5

    iget v0, p0, Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualSubscriber;->sourceMode:I

    const/4 v1, 0x1

    if-eq v0, v1, :cond_21

    iget-wide v0, p0, Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualSubscriber;->produced:J

    const-wide/16 v2, 0x1

    add-long/2addr v0, v2

    iget v2, p0, Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualSubscriber;->limit:I

    int-to-long v2, v2

    cmp-long v2, v0, v2

    if-ltz v2, :cond_1f

    const-wide/16 v2, 0x0

    iput-wide v2, p0, Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualSubscriber;->produced:J

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualSubscriber;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/reactivestreams/Subscription;

    invoke-interface {v2, v0, v1}, Lorg/reactivestreams/Subscription;->request(J)V

    goto :goto_21

    :cond_1f
    iput-wide v0, p0, Lio/reactivex/internal/operators/flowable/FlowableSequenceEqual$EqualSubscriber;->produced:J

    :cond_21
    :goto_21
    return-void
.end method
