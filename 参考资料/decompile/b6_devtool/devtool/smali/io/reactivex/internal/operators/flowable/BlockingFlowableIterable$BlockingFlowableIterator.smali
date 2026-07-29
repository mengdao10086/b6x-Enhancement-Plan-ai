.class final Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;
.super Ljava/util/concurrent/atomic/AtomicReference;
.source "BlockingFlowableIterable.java"

# interfaces
.implements Lio/reactivex/FlowableSubscriber;
.implements Ljava/util/Iterator;
.implements Ljava/lang/Runnable;
.implements Lio/reactivex/disposables/Disposable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "BlockingFlowableIterator"
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
        "TT;>;",
        "Ljava/util/Iterator<",
        "TT;>;",
        "Ljava/lang/Runnable;",
        "Lio/reactivex/disposables/Disposable;"
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = 0x5cea3901b29dcb72L


# instance fields
.field final batchSize:J

.field final condition:Ljava/util/concurrent/locks/Condition;

.field volatile done:Z

.field volatile error:Ljava/lang/Throwable;

.field final limit:J

.field final lock:Ljava/util/concurrent/locks/Lock;

.field produced:J

.field final queue:Lio/reactivex/internal/queue/SpscArrayQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/internal/queue/SpscArrayQueue<",
            "TT;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(I)V
    .registers 4

    invoke-direct {p0}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    new-instance v0, Lio/reactivex/internal/queue/SpscArrayQueue;

    invoke-direct {v0, p1}, Lio/reactivex/internal/queue/SpscArrayQueue;-><init>(I)V

    iput-object v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->queue:Lio/reactivex/internal/queue/SpscArrayQueue;

    int-to-long v0, p1

    iput-wide v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->batchSize:J

    shr-int/lit8 v0, p1, 0x2

    sub-int/2addr p1, v0

    int-to-long v0, p1

    iput-wide v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->limit:J

    new-instance p1, Ljava/util/concurrent/locks/ReentrantLock;

    invoke-direct {p1}, Ljava/util/concurrent/locks/ReentrantLock;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {p1}, Ljava/util/concurrent/locks/Lock;->newCondition()Ljava/util/concurrent/locks/Condition;

    move-result-object p1

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->condition:Ljava/util/concurrent/locks/Condition;

    return-void
.end method


# virtual methods
.method public dispose()V
    .registers 1

    invoke-static {p0}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->cancel(Ljava/util/concurrent/atomic/AtomicReference;)Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->signalConsumer()V

    return-void
.end method

.method public hasNext()Z
    .registers 4

    :goto_0
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->isDisposed()Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_11

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->error:Ljava/lang/Throwable;

    if-nez v0, :cond_c

    return v1

    :cond_c
    invoke-static {v0}, Lio/reactivex/internal/util/ExceptionHelper;->wrapOrThrow(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0

    :cond_11
    iget-boolean v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->done:Z

    iget-object v2, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->queue:Lio/reactivex/internal/queue/SpscArrayQueue;

    invoke-virtual {v2}, Lio/reactivex/internal/queue/SpscArrayQueue;->isEmpty()Z

    move-result v2

    if-eqz v0, :cond_27

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->error:Ljava/lang/Throwable;

    if-nez v0, :cond_22

    if-eqz v2, :cond_27

    return v1

    :cond_22
    invoke-static {v0}, Lio/reactivex/internal/util/ExceptionHelper;->wrapOrThrow(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0

    :cond_27
    if-eqz v2, :cond_60

    invoke-static {}, Lio/reactivex/internal/util/BlockingHelper;->verifyNonBlocking()V

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    :goto_31
    :try_start_31
    iget-boolean v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->done:Z

    if-nez v0, :cond_49

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->queue:Lio/reactivex/internal/queue/SpscArrayQueue;

    invoke-virtual {v0}, Lio/reactivex/internal/queue/SpscArrayQueue;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_49

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->isDisposed()Z

    move-result v0

    if-nez v0, :cond_49

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->condition:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Condition;->await()V
    :try_end_48
    .catch Ljava/lang/InterruptedException; {:try_start_31 .. :try_end_48} :catch_51
    .catchall {:try_start_31 .. :try_end_48} :catchall_4f

    goto :goto_31

    :cond_49
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    goto :goto_0

    :catchall_4f
    move-exception v0

    goto :goto_5a

    :catch_51
    move-exception v0

    :try_start_52
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->run()V

    invoke-static {v0}, Lio/reactivex/internal/util/ExceptionHelper;->wrapOrThrow(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
    :try_end_5a
    .catchall {:try_start_52 .. :try_end_5a} :catchall_4f

    :goto_5a
    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v0

    :cond_60
    const/4 v0, 0x1

    return v0
.end method

.method public isDisposed()Z
    .registers 3

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->get()Ljava/lang/Object;

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

.method public next()Ljava/lang/Object;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_28

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->queue:Lio/reactivex/internal/queue/SpscArrayQueue;

    invoke-virtual {v0}, Lio/reactivex/internal/queue/SpscArrayQueue;->poll()Ljava/lang/Object;

    move-result-object v0

    iget-wide v1, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->produced:J

    const-wide/16 v3, 0x1

    add-long/2addr v1, v3

    iget-wide v3, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->limit:J

    cmp-long v3, v1, v3

    if-nez v3, :cond_25

    const-wide/16 v3, 0x0

    iput-wide v3, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->produced:J

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->get()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/reactivestreams/Subscription;

    invoke-interface {v3, v1, v2}, Lorg/reactivestreams/Subscription;->request(J)V

    goto :goto_27

    :cond_25
    iput-wide v1, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->produced:J

    :goto_27
    return-object v0

    :cond_28
    new-instance v0, Ljava/util/NoSuchElementException;

    invoke-direct {v0}, Ljava/util/NoSuchElementException;-><init>()V

    throw v0
.end method

.method public onComplete()V
    .registers 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->done:Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->signalConsumer()V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 2

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->error:Ljava/lang/Throwable;

    const/4 p1, 0x1

    iput-boolean p1, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->done:Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->signalConsumer()V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->queue:Lio/reactivex/internal/queue/SpscArrayQueue;

    invoke-virtual {v0, p1}, Lio/reactivex/internal/queue/SpscArrayQueue;->offer(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_16

    invoke-static {p0}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->cancel(Ljava/util/concurrent/atomic/AtomicReference;)Z

    new-instance p1, Lio/reactivex/exceptions/MissingBackpressureException;

    const-string v0, "Queue full?!"

    invoke-direct {p1, v0}, Lio/reactivex/exceptions/MissingBackpressureException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->onError(Ljava/lang/Throwable;)V

    goto :goto_19

    :cond_16
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->signalConsumer()V

    :goto_19
    return-void
.end method

.method public onSubscribe(Lorg/reactivestreams/Subscription;)V
    .registers 4

    iget-wide v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->batchSize:J

    invoke-static {p0, p1, v0, v1}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->setOnce(Ljava/util/concurrent/atomic/AtomicReference;Lorg/reactivestreams/Subscription;J)Z

    return-void
.end method

.method public remove()V
    .registers 3

    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "remove"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public run()V
    .registers 1

    invoke-static {p0}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->cancel(Ljava/util/concurrent/atomic/AtomicReference;)Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->signalConsumer()V

    return-void
.end method

.method signalConsumer()V
    .registers 3

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    :try_start_5
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->condition:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Condition;->signalAll()V
    :try_end_a
    .catchall {:try_start_5 .. :try_end_a} :catchall_10

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    return-void

    :catchall_10
    move-exception v0

    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableIterable$BlockingFlowableIterator;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v0
.end method
