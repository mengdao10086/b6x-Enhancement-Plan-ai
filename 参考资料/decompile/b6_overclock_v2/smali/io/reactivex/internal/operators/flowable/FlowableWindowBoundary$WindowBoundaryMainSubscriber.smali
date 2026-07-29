.class final Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;
.super Ljava/util/concurrent/atomic/AtomicInteger;
.source "FlowableWindowBoundary.java"

# interfaces
.implements Lio/reactivex/FlowableSubscriber;
.implements Lorg/reactivestreams/Subscription;
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "WindowBoundaryMainSubscriber"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        "B:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/util/concurrent/atomic/AtomicInteger;",
        "Lio/reactivex/FlowableSubscriber<",
        "TT;>;",
        "Lorg/reactivestreams/Subscription;",
        "Ljava/lang/Runnable;"
    }
.end annotation


# static fields
.field static final NEXT_WINDOW:Ljava/lang/Object;

.field private static final serialVersionUID:J = 0x1efd47eb1fc2a3a0L


# instance fields
.field final boundarySubscriber:Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryInnerSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryInnerSubscriber<",
            "TT;TB;>;"
        }
    .end annotation
.end field

.field final capacityHint:I

.field volatile done:Z

.field final downstream:Lorg/reactivestreams/Subscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/reactivestreams/Subscriber<",
            "-",
            "Lio/reactivex/Flowable<",
            "TT;>;>;"
        }
    .end annotation
.end field

.field emitted:J

.field final errors:Lio/reactivex/internal/util/AtomicThrowable;

.field final queue:Lio/reactivex/internal/queue/MpscLinkedQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/internal/queue/MpscLinkedQueue<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field final requested:Ljava/util/concurrent/atomic/AtomicLong;

.field final stopWindows:Ljava/util/concurrent/atomic/AtomicBoolean;

.field final upstream:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference<",
            "Lorg/reactivestreams/Subscription;",
            ">;"
        }
    .end annotation
.end field

.field window:Lio/reactivex/processors/UnicastProcessor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/processors/UnicastProcessor<",
            "TT;>;"
        }
    .end annotation
.end field

.field final windows:Ljava/util/concurrent/atomic/AtomicInteger;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->NEXT_WINDOW:Ljava/lang/Object;

    return-void
.end method

.method constructor <init>(Lorg/reactivestreams/Subscriber;I)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Subscriber<",
            "-",
            "Lio/reactivex/Flowable<",
            "TT;>;>;I)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    iput p2, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->capacityHint:I

    new-instance p1, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryInnerSubscriber;

    invoke-direct {p1, p0}, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryInnerSubscriber;-><init>(Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;)V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->boundarySubscriber:Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryInnerSubscriber;

    new-instance p1, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    new-instance p1, Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 p2, 0x1

    invoke-direct {p1, p2}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->windows:Ljava/util/concurrent/atomic/AtomicInteger;

    new-instance p1, Lio/reactivex/internal/queue/MpscLinkedQueue;

    invoke-direct {p1}, Lio/reactivex/internal/queue/MpscLinkedQueue;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->queue:Lio/reactivex/internal/queue/MpscLinkedQueue;

    new-instance p1, Lio/reactivex/internal/util/AtomicThrowable;

    invoke-direct {p1}, Lio/reactivex/internal/util/AtomicThrowable;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    new-instance p1, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->stopWindows:Ljava/util/concurrent/atomic/AtomicBoolean;

    new-instance p1, Ljava/util/concurrent/atomic/AtomicLong;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicLong;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    return-void
.end method


# virtual methods
.method public cancel()V
    .registers 4

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->stopWindows:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(ZZ)Z

    move-result v0

    if-eqz v0, :cond_1c

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->boundarySubscriber:Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryInnerSubscriber;

    invoke-virtual {v0}, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryInnerSubscriber;->dispose()V

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->windows:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I

    move-result v0

    if-nez v0, :cond_1c

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->cancel(Ljava/util/concurrent/atomic/AtomicReference;)Z

    :cond_1c
    return-void
.end method

.method drain()V
    .registers 13

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->getAndIncrement()I

    move-result v0

    if-eqz v0, :cond_7

    return-void

    :cond_7
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->queue:Lio/reactivex/internal/queue/MpscLinkedQueue;

    iget-object v2, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    iget-wide v3, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->emitted:J

    const/4 v5, 0x1

    move v6, v5

    :cond_11
    :goto_11
    iget-object v7, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->windows:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v7}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v7

    const/4 v8, 0x0

    if-nez v7, :cond_20

    invoke-virtual {v1}, Lio/reactivex/internal/queue/MpscLinkedQueue;->clear()V

    iput-object v8, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->window:Lio/reactivex/processors/UnicastProcessor;

    return-void

    :cond_20
    iget-object v7, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->window:Lio/reactivex/processors/UnicastProcessor;

    iget-boolean v9, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->done:Z

    if-eqz v9, :cond_3e

    invoke-virtual {v2}, Lio/reactivex/internal/util/AtomicThrowable;->get()Ljava/lang/Object;

    move-result-object v10

    if-eqz v10, :cond_3e

    invoke-virtual {v1}, Lio/reactivex/internal/queue/MpscLinkedQueue;->clear()V

    invoke-virtual {v2}, Lio/reactivex/internal/util/AtomicThrowable;->terminate()Ljava/lang/Throwable;

    move-result-object v1

    if-eqz v7, :cond_3a

    iput-object v8, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->window:Lio/reactivex/processors/UnicastProcessor;

    invoke-virtual {v7, v1}, Lio/reactivex/processors/UnicastProcessor;->onError(Ljava/lang/Throwable;)V

    :cond_3a
    invoke-interface {v0, v1}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void

    :cond_3e
    invoke-virtual {v1}, Lio/reactivex/internal/queue/MpscLinkedQueue;->poll()Ljava/lang/Object;

    move-result-object v10

    if-nez v10, :cond_46

    move v11, v5

    goto :goto_47

    :cond_46
    const/4 v11, 0x0

    :goto_47
    if-eqz v9, :cond_67

    if-eqz v11, :cond_67

    invoke-virtual {v2}, Lio/reactivex/internal/util/AtomicThrowable;->terminate()Ljava/lang/Throwable;

    move-result-object v1

    if-nez v1, :cond_5c

    if-eqz v7, :cond_58

    iput-object v8, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->window:Lio/reactivex/processors/UnicastProcessor;

    invoke-virtual {v7}, Lio/reactivex/processors/UnicastProcessor;->onComplete()V

    :cond_58
    invoke-interface {v0}, Lorg/reactivestreams/Subscriber;->onComplete()V

    goto :goto_66

    :cond_5c
    if-eqz v7, :cond_63

    iput-object v8, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->window:Lio/reactivex/processors/UnicastProcessor;

    invoke-virtual {v7, v1}, Lio/reactivex/processors/UnicastProcessor;->onError(Ljava/lang/Throwable;)V

    :cond_63
    invoke-interface {v0, v1}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    :goto_66
    return-void

    :cond_67
    if-eqz v11, :cond_73

    iput-wide v3, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->emitted:J

    neg-int v6, v6

    invoke-virtual {p0, v6}, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->addAndGet(I)I

    move-result v6

    if-nez v6, :cond_11

    return-void

    :cond_73
    sget-object v9, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->NEXT_WINDOW:Ljava/lang/Object;

    if-eq v10, v9, :cond_7b

    invoke-virtual {v7, v10}, Lio/reactivex/processors/UnicastProcessor;->onNext(Ljava/lang/Object;)V

    goto :goto_11

    :cond_7b
    if-eqz v7, :cond_82

    iput-object v8, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->window:Lio/reactivex/processors/UnicastProcessor;

    invoke-virtual {v7}, Lio/reactivex/processors/UnicastProcessor;->onComplete()V

    :cond_82
    iget-object v7, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->stopWindows:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v7}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v7

    if-nez v7, :cond_11

    iget v7, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->capacityHint:I

    invoke-static {v7, p0}, Lio/reactivex/processors/UnicastProcessor;->create(ILjava/lang/Runnable;)Lio/reactivex/processors/UnicastProcessor;

    move-result-object v7

    iput-object v7, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->window:Lio/reactivex/processors/UnicastProcessor;

    iget-object v8, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->windows:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v8}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndIncrement()I

    iget-object v8, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v8}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v8

    cmp-long v8, v3, v8

    if-eqz v8, :cond_a9

    const-wide/16 v8, 0x1

    add-long/2addr v3, v8

    invoke-interface {v0, v7}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    goto/16 :goto_11

    :cond_a9
    iget-object v7, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v7}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->cancel(Ljava/util/concurrent/atomic/AtomicReference;)Z

    iget-object v7, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->boundarySubscriber:Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryInnerSubscriber;

    invoke-virtual {v7}, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryInnerSubscriber;->dispose()V

    new-instance v7, Lio/reactivex/exceptions/MissingBackpressureException;

    const-string v8, "Could not deliver a window due to lack of requests"

    invoke-direct {v7, v8}, Lio/reactivex/exceptions/MissingBackpressureException;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v7}, Lio/reactivex/internal/util/AtomicThrowable;->addThrowable(Ljava/lang/Throwable;)Z

    iput-boolean v5, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->done:Z

    goto/16 :goto_11
.end method

.method innerComplete()V
    .registers 2

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->cancel(Ljava/util/concurrent/atomic/AtomicReference;)Z

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->done:Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->drain()V

    return-void
.end method

.method innerError(Ljava/lang/Throwable;)V
    .registers 3

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->cancel(Ljava/util/concurrent/atomic/AtomicReference;)Z

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v0, p1}, Lio/reactivex/internal/util/AtomicThrowable;->addThrowable(Ljava/lang/Throwable;)Z

    move-result v0

    if-eqz v0, :cond_14

    const/4 p1, 0x1

    iput-boolean p1, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->done:Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->drain()V

    goto :goto_17

    :cond_14
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :goto_17
    return-void
.end method

.method innerNext()V
    .registers 3

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->queue:Lio/reactivex/internal/queue/MpscLinkedQueue;

    sget-object v1, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->NEXT_WINDOW:Ljava/lang/Object;

    invoke-virtual {v0, v1}, Lio/reactivex/internal/queue/MpscLinkedQueue;->offer(Ljava/lang/Object;)Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->drain()V

    return-void
.end method

.method public onComplete()V
    .registers 2

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->boundarySubscriber:Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryInnerSubscriber;

    invoke-virtual {v0}, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryInnerSubscriber;->dispose()V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->done:Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->drain()V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 3

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->boundarySubscriber:Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryInnerSubscriber;

    invoke-virtual {v0}, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryInnerSubscriber;->dispose()V

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v0, p1}, Lio/reactivex/internal/util/AtomicThrowable;->addThrowable(Ljava/lang/Throwable;)Z

    move-result v0

    if-eqz v0, :cond_14

    const/4 p1, 0x1

    iput-boolean p1, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->done:Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->drain()V

    goto :goto_17

    :cond_14
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :goto_17
    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->queue:Lio/reactivex/internal/queue/MpscLinkedQueue;

    invoke-virtual {v0, p1}, Lio/reactivex/internal/queue/MpscLinkedQueue;->offer(Ljava/lang/Object;)Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->drain()V

    return-void
.end method

.method public onSubscribe(Lorg/reactivestreams/Subscription;)V
    .registers 5

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    const-wide v1, 0x7fffffffffffffffL

    invoke-static {v0, p1, v1, v2}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->setOnce(Ljava/util/concurrent/atomic/AtomicReference;Lorg/reactivestreams/Subscription;J)Z

    return-void
.end method

.method public request(J)V
    .registers 4

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-static {v0, p1, p2}, Lio/reactivex/internal/util/BackpressureHelper;->add(Ljava/util/concurrent/atomic/AtomicLong;J)J

    return-void
.end method

.method public run()V
    .registers 2

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->windows:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I

    move-result v0

    if-nez v0, :cond_d

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableWindowBoundary$WindowBoundaryMainSubscriber;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->cancel(Ljava/util/concurrent/atomic/AtomicReference;)Z

    :cond_d
    return-void
.end method
