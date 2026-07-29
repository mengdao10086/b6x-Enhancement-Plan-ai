.class final Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;
.super Lio/reactivex/internal/subscriptions/BasicIntQueueSubscription;
.source "MaybeMergeArray.java"

# interfaces
.implements Lio/reactivex/MaybeObserver;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/maybe/MaybeMergeArray;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "MergeMaybeObserver"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lio/reactivex/internal/subscriptions/BasicIntQueueSubscription<",
        "TT;>;",
        "Lio/reactivex/MaybeObserver<",
        "TT;>;"
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = -0x92a32049d0458bbL


# instance fields
.field volatile cancelled:Z

.field consumed:J

.field final downstream:Lorg/reactivestreams/Subscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;"
        }
    .end annotation
.end field

.field final error:Lio/reactivex/internal/util/AtomicThrowable;

.field outputFused:Z

.field final queue:Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field final requested:Ljava/util/concurrent/atomic/AtomicLong;

.field final set:Lio/reactivex/disposables/CompositeDisposable;

.field final sourceCount:I


# direct methods
.method constructor <init>(Lorg/reactivestreams/Subscriber;ILio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;I",
            "Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex<",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0}, Lio/reactivex/internal/subscriptions/BasicIntQueueSubscription;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->downstream:Lorg/reactivestreams/Subscriber;

    iput p2, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->sourceCount:I

    new-instance p1, Lio/reactivex/disposables/CompositeDisposable;

    invoke-direct {p1}, Lio/reactivex/disposables/CompositeDisposable;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->set:Lio/reactivex/disposables/CompositeDisposable;

    new-instance p1, Ljava/util/concurrent/atomic/AtomicLong;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicLong;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    new-instance p1, Lio/reactivex/internal/util/AtomicThrowable;

    invoke-direct {p1}, Lio/reactivex/internal/util/AtomicThrowable;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->error:Lio/reactivex/internal/util/AtomicThrowable;

    iput-object p3, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->queue:Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex;

    return-void
.end method


# virtual methods
.method public cancel()V
    .registers 2

    iget-boolean v0, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->cancelled:Z

    if-nez v0, :cond_17

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->cancelled:Z

    iget-object v0, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->set:Lio/reactivex/disposables/CompositeDisposable;

    invoke-virtual {v0}, Lio/reactivex/disposables/CompositeDisposable;->dispose()V

    invoke-virtual {p0}, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->getAndIncrement()I

    move-result v0

    if-nez v0, :cond_17

    iget-object v0, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->queue:Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex;

    invoke-interface {v0}, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex;->clear()V

    :cond_17
    return-void
.end method

.method public clear()V
    .registers 2

    iget-object v0, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->queue:Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex;

    invoke-interface {v0}, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex;->clear()V

    return-void
.end method

.method drain()V
    .registers 2

    invoke-virtual {p0}, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->getAndIncrement()I

    move-result v0

    if-eqz v0, :cond_7

    return-void

    :cond_7
    iget-boolean v0, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->outputFused:Z

    if-eqz v0, :cond_f

    invoke-virtual {p0}, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->drainFused()V

    goto :goto_12

    :cond_f
    invoke-virtual {p0}, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->drainNormal()V

    :goto_12
    return-void
.end method

.method drainFused()V
    .registers 7

    iget-object v0, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->downstream:Lorg/reactivestreams/Subscriber;

    iget-object v1, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->queue:Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex;

    const/4 v2, 0x1

    move v3, v2

    :cond_6
    iget-boolean v4, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->cancelled:Z

    if-eqz v4, :cond_e

    invoke-interface {v1}, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex;->clear()V

    return-void

    :cond_e
    iget-object v4, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->error:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v4}, Lio/reactivex/internal/util/AtomicThrowable;->get()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Throwable;

    if-eqz v4, :cond_1f

    invoke-interface {v1}, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex;->clear()V

    invoke-interface {v0, v4}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void

    :cond_1f
    invoke-interface {v1}, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex;->producerIndex()I

    move-result v4

    iget v5, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->sourceCount:I

    if-ne v4, v5, :cond_29

    move v4, v2

    goto :goto_2a

    :cond_29
    const/4 v4, 0x0

    :goto_2a
    invoke-interface {v1}, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_34

    const/4 v5, 0x0

    invoke-interface {v0, v5}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    :cond_34
    if-eqz v4, :cond_3a

    invoke-interface {v0}, Lorg/reactivestreams/Subscriber;->onComplete()V

    return-void

    :cond_3a
    neg-int v3, v3

    invoke-virtual {p0, v3}, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->addAndGet(I)I

    move-result v3

    if-nez v3, :cond_6

    return-void
.end method

.method drainNormal()V
    .registers 11

    iget-object v0, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->downstream:Lorg/reactivestreams/Subscriber;

    iget-object v1, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->queue:Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex;

    iget-wide v2, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->consumed:J

    const/4 v4, 0x1

    :cond_7
    iget-object v5, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v5}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v5

    :cond_d
    :goto_d
    cmp-long v7, v2, v5

    if-eqz v7, :cond_4e

    iget-boolean v8, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->cancelled:Z

    if-eqz v8, :cond_19

    invoke-interface {v1}, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex;->clear()V

    return-void

    :cond_19
    iget-object v8, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->error:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v8}, Lio/reactivex/internal/util/AtomicThrowable;->get()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/Throwable;

    if-eqz v8, :cond_30

    invoke-interface {v1}, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex;->clear()V

    iget-object v1, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->error:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v1}, Lio/reactivex/internal/util/AtomicThrowable;->terminate()Ljava/lang/Throwable;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void

    :cond_30
    invoke-interface {v1}, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex;->consumerIndex()I

    move-result v8

    iget v9, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->sourceCount:I

    if-ne v8, v9, :cond_3c

    invoke-interface {v0}, Lorg/reactivestreams/Subscriber;->onComplete()V

    return-void

    :cond_3c
    invoke-interface {v1}, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex;->poll()Ljava/lang/Object;

    move-result-object v8

    if-nez v8, :cond_43

    goto :goto_4e

    :cond_43
    sget-object v7, Lio/reactivex/internal/util/NotificationLite;->COMPLETE:Lio/reactivex/internal/util/NotificationLite;

    if-eq v8, v7, :cond_d

    invoke-interface {v0, v8}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    const-wide/16 v7, 0x1

    add-long/2addr v2, v7

    goto :goto_d

    :cond_4e
    :goto_4e
    if-nez v7, :cond_7f

    iget-object v5, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->error:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v5}, Lio/reactivex/internal/util/AtomicThrowable;->get()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Throwable;

    if-eqz v5, :cond_67

    invoke-interface {v1}, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex;->clear()V

    iget-object v1, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->error:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v1}, Lio/reactivex/internal/util/AtomicThrowable;->terminate()Ljava/lang/Throwable;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void

    :cond_67
    :goto_67
    invoke-interface {v1}, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex;->peek()Ljava/lang/Object;

    move-result-object v5

    sget-object v6, Lio/reactivex/internal/util/NotificationLite;->COMPLETE:Lio/reactivex/internal/util/NotificationLite;

    if-ne v5, v6, :cond_73

    invoke-interface {v1}, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex;->drop()V

    goto :goto_67

    :cond_73
    invoke-interface {v1}, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex;->consumerIndex()I

    move-result v5

    iget v6, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->sourceCount:I

    if-ne v5, v6, :cond_7f

    invoke-interface {v0}, Lorg/reactivestreams/Subscriber;->onComplete()V

    return-void

    :cond_7f
    iput-wide v2, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->consumed:J

    neg-int v4, v4

    invoke-virtual {p0, v4}, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->addAndGet(I)I

    move-result v4

    if-nez v4, :cond_7

    return-void
.end method

.method isCancelled()Z
    .registers 2

    iget-boolean v0, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->cancelled:Z

    return v0
.end method

.method public isEmpty()Z
    .registers 2

    iget-object v0, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->queue:Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex;

    invoke-interface {v0}, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex;->isEmpty()Z

    move-result v0

    return v0
.end method

.method public onComplete()V
    .registers 3

    iget-object v0, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->queue:Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex;

    sget-object v1, Lio/reactivex/internal/util/NotificationLite;->COMPLETE:Lio/reactivex/internal/util/NotificationLite;

    invoke-interface {v0, v1}, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex;->offer(Ljava/lang/Object;)Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->drain()V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 3

    iget-object v0, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->error:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v0, p1}, Lio/reactivex/internal/util/AtomicThrowable;->addThrowable(Ljava/lang/Throwable;)Z

    move-result v0

    if-eqz v0, :cond_18

    iget-object p1, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->set:Lio/reactivex/disposables/CompositeDisposable;

    invoke-virtual {p1}, Lio/reactivex/disposables/CompositeDisposable;->dispose()V

    iget-object p1, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->queue:Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex;

    sget-object v0, Lio/reactivex/internal/util/NotificationLite;->COMPLETE:Lio/reactivex/internal/util/NotificationLite;

    invoke-interface {p1, v0}, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex;->offer(Ljava/lang/Object;)Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->drain()V

    goto :goto_1b

    :cond_18
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :goto_1b
    return-void
.end method

.method public onSubscribe(Lio/reactivex/disposables/Disposable;)V
    .registers 3

    iget-object v0, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->set:Lio/reactivex/disposables/CompositeDisposable;

    invoke-virtual {v0, p1}, Lio/reactivex/disposables/CompositeDisposable;->add(Lio/reactivex/disposables/Disposable;)Z

    return-void
.end method

.method public onSuccess(Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    iget-object v0, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->queue:Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex;

    invoke-interface {v0, p1}, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex;->offer(Ljava/lang/Object;)Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->drain()V

    return-void
.end method

.method public poll()Ljava/lang/Object;
    .registers 3
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

    :cond_0
    iget-object v0, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->queue:Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex;

    invoke-interface {v0}, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$SimpleQueueWithConsumerIndex;->poll()Ljava/lang/Object;

    move-result-object v0

    sget-object v1, Lio/reactivex/internal/util/NotificationLite;->COMPLETE:Lio/reactivex/internal/util/NotificationLite;

    if-eq v0, v1, :cond_0

    return-object v0
.end method

.method public request(J)V
    .registers 4

    invoke-static {p1, p2}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->validate(J)Z

    move-result v0

    if-eqz v0, :cond_e

    iget-object v0, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-static {v0, p1, p2}, Lio/reactivex/internal/util/BackpressureHelper;->add(Ljava/util/concurrent/atomic/AtomicLong;J)J

    invoke-virtual {p0}, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->drain()V

    :cond_e
    return-void
.end method

.method public requestFusion(I)I
    .registers 3

    const/4 v0, 0x2

    and-int/2addr p1, v0

    if-eqz p1, :cond_8

    const/4 p1, 0x1

    iput-boolean p1, p0, Lio/reactivex/internal/operators/maybe/MaybeMergeArray$MergeMaybeObserver;->outputFused:Z

    return v0

    :cond_8
    const/4 p1, 0x0

    return p1
.end method
