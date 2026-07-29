.class final Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;
.super Ljava/util/concurrent/atomic/AtomicInteger;
.source "FlowableThrottleLatest.java"

# interfaces
.implements Lio/reactivex/FlowableSubscriber;
.implements Lorg/reactivestreams/Subscription;
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "ThrottleLatestSubscriber"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
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
.field private static final serialVersionUID:J = -0x7323c2cdbcdaca16L


# instance fields
.field volatile cancelled:Z

.field volatile done:Z

.field final downstream:Lorg/reactivestreams/Subscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;"
        }
    .end annotation
.end field

.field final emitLast:Z

.field emitted:J

.field error:Ljava/lang/Throwable;

.field final latest:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference<",
            "TT;>;"
        }
    .end annotation
.end field

.field final requested:Ljava/util/concurrent/atomic/AtomicLong;

.field final timeout:J

.field volatile timerFired:Z

.field timerRunning:Z

.field final unit:Ljava/util/concurrent/TimeUnit;

.field upstream:Lorg/reactivestreams/Subscription;

.field final worker:Lio/reactivex/Scheduler$Worker;


# direct methods
.method constructor <init>(Lorg/reactivestreams/Subscriber;JLjava/util/concurrent/TimeUnit;Lio/reactivex/Scheduler$Worker;Z)V
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;J",
            "Ljava/util/concurrent/TimeUnit;",
            "Lio/reactivex/Scheduler$Worker;",
            "Z)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    iput-wide p2, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->timeout:J

    iput-object p4, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->unit:Ljava/util/concurrent/TimeUnit;

    iput-object p5, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->worker:Lio/reactivex/Scheduler$Worker;

    iput-boolean p6, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->emitLast:Z

    new-instance p1, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->latest:Ljava/util/concurrent/atomic/AtomicReference;

    new-instance p1, Ljava/util/concurrent/atomic/AtomicLong;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicLong;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    return-void
.end method


# virtual methods
.method public cancel()V
    .registers 3

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->cancelled:Z

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    invoke-interface {v0}, Lorg/reactivestreams/Subscription;->cancel()V

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->worker:Lio/reactivex/Scheduler$Worker;

    invoke-virtual {v0}, Lio/reactivex/Scheduler$Worker;->dispose()V

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->getAndIncrement()I

    move-result v0

    if-nez v0, :cond_19

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->latest:Ljava/util/concurrent/atomic/AtomicReference;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicReference;->lazySet(Ljava/lang/Object;)V

    :cond_19
    return-void
.end method

.method drain()V
    .registers 14

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->getAndIncrement()I

    move-result v0

    if-eqz v0, :cond_7

    return-void

    :cond_7
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->latest:Ljava/util/concurrent/atomic/AtomicReference;

    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    iget-object v2, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    const/4 v3, 0x1

    move v4, v3

    :cond_f
    :goto_f
    iget-boolean v5, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->cancelled:Z

    const/4 v6, 0x0

    if-eqz v5, :cond_18

    invoke-virtual {v0, v6}, Ljava/util/concurrent/atomic/AtomicReference;->lazySet(Ljava/lang/Object;)V

    return-void

    :cond_18
    iget-boolean v5, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->done:Z

    if-eqz v5, :cond_2e

    iget-object v7, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->error:Ljava/lang/Throwable;

    if-eqz v7, :cond_2e

    invoke-virtual {v0, v6}, Ljava/util/concurrent/atomic/AtomicReference;->lazySet(Ljava/lang/Object;)V

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->error:Ljava/lang/Throwable;

    invoke-interface {v2, v0}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->worker:Lio/reactivex/Scheduler$Worker;

    invoke-virtual {v0}, Lio/reactivex/Scheduler$Worker;->dispose()V

    return-void

    :cond_2e
    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v7

    const/4 v8, 0x0

    if-nez v7, :cond_37

    move v7, v3

    goto :goto_38

    :cond_37
    move v7, v8

    :goto_38
    const-wide/16 v9, 0x1

    if-eqz v5, :cond_71

    if-nez v7, :cond_65

    iget-boolean v3, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->emitLast:Z

    if-eqz v3, :cond_65

    invoke-virtual {v0, v6}, Ljava/util/concurrent/atomic/AtomicReference;->getAndSet(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    iget-wide v3, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->emitted:J

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v5

    cmp-long v1, v3, v5

    if-eqz v1, :cond_5a

    add-long/2addr v3, v9

    iput-wide v3, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->emitted:J

    invoke-interface {v2, v0}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    invoke-interface {v2}, Lorg/reactivestreams/Subscriber;->onComplete()V

    goto :goto_6b

    :cond_5a
    new-instance v0, Lio/reactivex/exceptions/MissingBackpressureException;

    const-string v1, "Could not emit final value due to lack of requests"

    invoke-direct {v0, v1}, Lio/reactivex/exceptions/MissingBackpressureException;-><init>(Ljava/lang/String;)V

    invoke-interface {v2, v0}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    goto :goto_6b

    :cond_65
    invoke-virtual {v0, v6}, Ljava/util/concurrent/atomic/AtomicReference;->lazySet(Ljava/lang/Object;)V

    invoke-interface {v2}, Lorg/reactivestreams/Subscriber;->onComplete()V

    :goto_6b
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->worker:Lio/reactivex/Scheduler$Worker;

    invoke-virtual {v0}, Lio/reactivex/Scheduler$Worker;->dispose()V

    return-void

    :cond_71
    if-eqz v7, :cond_7c

    iget-boolean v5, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->timerFired:Z

    if-eqz v5, :cond_85

    iput-boolean v8, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->timerRunning:Z

    iput-boolean v8, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->timerFired:Z

    goto :goto_85

    :cond_7c
    iget-boolean v5, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->timerRunning:Z

    if-eqz v5, :cond_8d

    iget-boolean v5, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->timerFired:Z

    if-eqz v5, :cond_85

    goto :goto_8d

    :cond_85
    :goto_85
    neg-int v4, v4

    invoke-virtual {p0, v4}, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->addAndGet(I)I

    move-result v4

    if-nez v4, :cond_f

    return-void

    :cond_8d
    :goto_8d
    invoke-virtual {v0, v6}, Ljava/util/concurrent/atomic/AtomicReference;->getAndSet(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    iget-wide v6, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->emitted:J

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v11

    cmp-long v11, v6, v11

    if-eqz v11, :cond_b0

    invoke-interface {v2, v5}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    add-long/2addr v6, v9

    iput-wide v6, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->emitted:J

    iput-boolean v8, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->timerFired:Z

    iput-boolean v3, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->timerRunning:Z

    iget-object v5, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->worker:Lio/reactivex/Scheduler$Worker;

    iget-wide v6, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->timeout:J

    iget-object v8, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->unit:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v5, p0, v6, v7, v8}, Lio/reactivex/Scheduler$Worker;->schedule(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Lio/reactivex/disposables/Disposable;

    goto/16 :goto_f

    :cond_b0
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    invoke-interface {v0}, Lorg/reactivestreams/Subscription;->cancel()V

    new-instance v0, Lio/reactivex/exceptions/MissingBackpressureException;

    const-string v1, "Could not emit value due to lack of requests"

    invoke-direct {v0, v1}, Lio/reactivex/exceptions/MissingBackpressureException;-><init>(Ljava/lang/String;)V

    invoke-interface {v2, v0}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->worker:Lio/reactivex/Scheduler$Worker;

    invoke-virtual {v0}, Lio/reactivex/Scheduler$Worker;->dispose()V

    return-void
.end method

.method public onComplete()V
    .registers 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->done:Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->drain()V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 2

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->error:Ljava/lang/Throwable;

    const/4 p1, 0x1

    iput-boolean p1, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->done:Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->drain()V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->latest:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/atomic/AtomicReference;->set(Ljava/lang/Object;)V

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->drain()V

    return-void
.end method

.method public onSubscribe(Lorg/reactivestreams/Subscription;)V
    .registers 4

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    invoke-static {v0, p1}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->validate(Lorg/reactivestreams/Subscription;Lorg/reactivestreams/Subscription;)Z

    move-result v0

    if-eqz v0, :cond_17

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    invoke-interface {v0, p0}, Lorg/reactivestreams/Subscriber;->onSubscribe(Lorg/reactivestreams/Subscription;)V

    const-wide v0, 0x7fffffffffffffffL

    invoke-interface {p1, v0, v1}, Lorg/reactivestreams/Subscription;->request(J)V

    :cond_17
    return-void
.end method

.method public request(J)V
    .registers 4

    invoke-static {p1, p2}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->validate(J)Z

    move-result v0

    if-eqz v0, :cond_b

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-static {v0, p1, p2}, Lio/reactivex/internal/util/BackpressureHelper;->add(Ljava/util/concurrent/atomic/AtomicLong;J)J

    :cond_b
    return-void
.end method

.method public run()V
    .registers 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->timerFired:Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableThrottleLatest$ThrottleLatestSubscriber;->drain()V

    return-void
.end method
