.class final Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapInnerSubscriber;
.super Ljava/util/concurrent/atomic/AtomicReference;
.source "FlowableSwitchMap.java"

# interfaces
.implements Lio/reactivex/FlowableSubscriber;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/flowable/FlowableSwitchMap;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "SwitchMapInnerSubscriber"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        "R:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/util/concurrent/atomic/AtomicReference<",
        "Lorg/reactivestreams/Subscription;",
        ">;",
        "Lio/reactivex/FlowableSubscriber<",
        "TR;>;"
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = 0x3540c639803a63b9L


# instance fields
.field final bufferSize:I

.field volatile done:Z

.field fusionMode:I

.field final index:J

.field final parent:Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapSubscriber<",
            "TT;TR;>;"
        }
    .end annotation
.end field

.field volatile queue:Lio/reactivex/internal/fuseable/SimpleQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/internal/fuseable/SimpleQueue<",
            "TR;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapSubscriber;JI)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapSubscriber<",
            "TT;TR;>;JI)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapInnerSubscriber;->parent:Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapSubscriber;

    iput-wide p2, p0, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapInnerSubscriber;->index:J

    iput p4, p0, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapInnerSubscriber;->bufferSize:I

    return-void
.end method


# virtual methods
.method public cancel()V
    .registers 1

    invoke-static {p0}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->cancel(Ljava/util/concurrent/atomic/AtomicReference;)Z

    return-void
.end method

.method public onComplete()V
    .registers 6

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapInnerSubscriber;->parent:Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapSubscriber;

    iget-wide v1, p0, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapInnerSubscriber;->index:J

    iget-wide v3, v0, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapSubscriber;->unique:J

    cmp-long v1, v1, v3

    if-nez v1, :cond_10

    const/4 v1, 0x1

    iput-boolean v1, p0, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapInnerSubscriber;->done:Z

    invoke-virtual {v0}, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapSubscriber;->drain()V

    :cond_10
    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 7

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapInnerSubscriber;->parent:Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapSubscriber;

    iget-wide v1, p0, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapInnerSubscriber;->index:J

    iget-wide v3, v0, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapSubscriber;->unique:J

    cmp-long v1, v1, v3

    if-nez v1, :cond_24

    iget-object v1, v0, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapSubscriber;->error:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v1, p1}, Lio/reactivex/internal/util/AtomicThrowable;->addThrowable(Ljava/lang/Throwable;)Z

    move-result v1

    if-eqz v1, :cond_24

    iget-boolean p1, v0, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapSubscriber;->delayErrors:Z

    const/4 v1, 0x1

    if-nez p1, :cond_1e

    iget-object p1, v0, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    invoke-interface {p1}, Lorg/reactivestreams/Subscription;->cancel()V

    iput-boolean v1, v0, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapSubscriber;->done:Z

    :cond_1e
    iput-boolean v1, p0, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapInnerSubscriber;->done:Z

    invoke-virtual {v0}, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapSubscriber;->drain()V

    goto :goto_27

    :cond_24
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :goto_27
    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TR;)V"
        }
    .end annotation

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapInnerSubscriber;->parent:Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapSubscriber;

    iget-wide v1, p0, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapInnerSubscriber;->index:J

    iget-wide v3, v0, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapSubscriber;->unique:J

    cmp-long v1, v1, v3

    if-nez v1, :cond_24

    iget v1, p0, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapInnerSubscriber;->fusionMode:I

    if-nez v1, :cond_21

    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapInnerSubscriber;->queue:Lio/reactivex/internal/fuseable/SimpleQueue;

    invoke-interface {v1, p1}, Lio/reactivex/internal/fuseable/SimpleQueue;->offer(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_21

    new-instance p1, Lio/reactivex/exceptions/MissingBackpressureException;

    const-string v0, "Queue full?!"

    invoke-direct {p1, v0}, Lio/reactivex/exceptions/MissingBackpressureException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapInnerSubscriber;->onError(Ljava/lang/Throwable;)V

    return-void

    :cond_21
    invoke-virtual {v0}, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapSubscriber;->drain()V

    :cond_24
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

    const/4 v1, 0x7

    invoke-interface {v0, v1}, Lio/reactivex/internal/fuseable/QueueSubscription;->requestFusion(I)I

    move-result v1

    const/4 v2, 0x1

    if-ne v1, v2, :cond_21

    iput v1, p0, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapInnerSubscriber;->fusionMode:I

    iput-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapInnerSubscriber;->queue:Lio/reactivex/internal/fuseable/SimpleQueue;

    iput-boolean v2, p0, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapInnerSubscriber;->done:Z

    iget-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapInnerSubscriber;->parent:Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapSubscriber;

    invoke-virtual {p1}, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapSubscriber;->drain()V

    return-void

    :cond_21
    const/4 v2, 0x2

    if-ne v1, v2, :cond_2f

    iput v1, p0, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapInnerSubscriber;->fusionMode:I

    iput-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapInnerSubscriber;->queue:Lio/reactivex/internal/fuseable/SimpleQueue;

    iget v0, p0, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapInnerSubscriber;->bufferSize:I

    int-to-long v0, v0

    invoke-interface {p1, v0, v1}, Lorg/reactivestreams/Subscription;->request(J)V

    return-void

    :cond_2f
    new-instance v0, Lio/reactivex/internal/queue/SpscArrayQueue;

    iget v1, p0, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapInnerSubscriber;->bufferSize:I

    invoke-direct {v0, v1}, Lio/reactivex/internal/queue/SpscArrayQueue;-><init>(I)V

    iput-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapInnerSubscriber;->queue:Lio/reactivex/internal/fuseable/SimpleQueue;

    iget v0, p0, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapInnerSubscriber;->bufferSize:I

    int-to-long v0, v0

    invoke-interface {p1, v0, v1}, Lorg/reactivestreams/Subscription;->request(J)V

    :cond_3e
    return-void
.end method

.method public request(J)V
    .registers 5

    iget v0, p0, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapInnerSubscriber;->fusionMode:I

    const/4 v1, 0x1

    if-eq v0, v1, :cond_e

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapInnerSubscriber;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/reactivestreams/Subscription;

    invoke-interface {v0, p1, p2}, Lorg/reactivestreams/Subscription;->request(J)V

    :cond_e
    return-void
.end method
