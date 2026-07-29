.class public abstract Lio/reactivex/internal/subscribers/QueueDrainSubscriber;
.super Lio/reactivex/internal/subscribers/QueueDrainSubscriberPad4;
.source "QueueDrainSubscriber.java"

# interfaces
.implements Lio/reactivex/FlowableSubscriber;
.implements Lio/reactivex/internal/util/QueueDrain;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        "U:",
        "Ljava/lang/Object;",
        "V:",
        "Ljava/lang/Object;",
        ">",
        "Lio/reactivex/internal/subscribers/QueueDrainSubscriberPad4;",
        "Lio/reactivex/FlowableSubscriber<",
        "TT;>;",
        "Lio/reactivex/internal/util/QueueDrain<",
        "TU;TV;>;"
    }
.end annotation


# instance fields
.field protected volatile cancelled:Z

.field protected volatile done:Z

.field protected final downstream:Lorg/reactivestreams/Subscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/reactivestreams/Subscriber<",
            "-TV;>;"
        }
    .end annotation
.end field

.field protected error:Ljava/lang/Throwable;

.field protected final queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/internal/fuseable/SimplePlainQueue<",
            "TU;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lorg/reactivestreams/Subscriber;Lio/reactivex/internal/fuseable/SimplePlainQueue;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Subscriber<",
            "-TV;>;",
            "Lio/reactivex/internal/fuseable/SimplePlainQueue<",
            "TU;>;)V"
        }
    .end annotation

    invoke-direct {p0}, Lio/reactivex/internal/subscribers/QueueDrainSubscriberPad4;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/subscribers/QueueDrainSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    iput-object p2, p0, Lio/reactivex/internal/subscribers/QueueDrainSubscriber;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    return-void
.end method


# virtual methods
.method public accept(Lorg/reactivestreams/Subscriber;Ljava/lang/Object;)Z
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Subscriber<",
            "-TV;>;TU;)Z"
        }
    .end annotation

    const/4 p1, 0x0

    return p1
.end method

.method public final cancelled()Z
    .registers 2

    iget-boolean v0, p0, Lio/reactivex/internal/subscribers/QueueDrainSubscriber;->cancelled:Z

    return v0
.end method

.method public final done()Z
    .registers 2

    iget-boolean v0, p0, Lio/reactivex/internal/subscribers/QueueDrainSubscriber;->done:Z

    return v0
.end method

.method public final enter()Z
    .registers 2

    iget-object v0, p0, Lio/reactivex/internal/subscribers/QueueDrainSubscriber;->wip:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndIncrement()I

    move-result v0

    if-nez v0, :cond_a

    const/4 v0, 0x1

    goto :goto_b

    :cond_a
    const/4 v0, 0x0

    :goto_b
    return v0
.end method

.method public final error()Ljava/lang/Throwable;
    .registers 2

    iget-object v0, p0, Lio/reactivex/internal/subscribers/QueueDrainSubscriber;->error:Ljava/lang/Throwable;

    return-object v0
.end method

.method public final fastEnter()Z
    .registers 4

    iget-object v0, p0, Lio/reactivex/internal/subscribers/QueueDrainSubscriber;->wip:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_13

    iget-object v0, p0, Lio/reactivex/internal/subscribers/QueueDrainSubscriber;->wip:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicInteger;->compareAndSet(II)Z

    move-result v0

    if-eqz v0, :cond_13

    move v1, v2

    :cond_13
    return v1
.end method

.method protected final fastPathEmitMax(Ljava/lang/Object;ZLio/reactivex/disposables/Disposable;)V
    .registers 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TU;Z",
            "Lio/reactivex/disposables/Disposable;",
            ")V"
        }
    .end annotation

    iget-object v0, p0, Lio/reactivex/internal/subscribers/QueueDrainSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    iget-object v1, p0, Lio/reactivex/internal/subscribers/QueueDrainSubscriber;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    invoke-virtual {p0}, Lio/reactivex/internal/subscribers/QueueDrainSubscriber;->fastEnter()Z

    move-result v2

    if-eqz v2, :cond_40

    iget-object v2, p0, Lio/reactivex/internal/subscribers/QueueDrainSubscriber;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v2}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v4, v2, v4

    if-eqz v4, :cond_32

    invoke-virtual {p0, v0, p1}, Lio/reactivex/internal/subscribers/QueueDrainSubscriber;->accept(Lorg/reactivestreams/Subscriber;Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_2a

    const-wide v4, 0x7fffffffffffffffL

    cmp-long p1, v2, v4

    if-eqz p1, :cond_2a

    const-wide/16 v2, 0x1

    invoke-virtual {p0, v2, v3}, Lio/reactivex/internal/subscribers/QueueDrainSubscriber;->produced(J)J

    :cond_2a
    const/4 p1, -0x1

    invoke-virtual {p0, p1}, Lio/reactivex/internal/subscribers/QueueDrainSubscriber;->leave(I)I

    move-result p1

    if-nez p1, :cond_4a

    return-void

    :cond_32
    invoke-interface {p3}, Lio/reactivex/disposables/Disposable;->dispose()V

    new-instance p1, Lio/reactivex/exceptions/MissingBackpressureException;

    const-string p2, "Could not emit buffer due to lack of requests"

    invoke-direct {p1, p2}, Lio/reactivex/exceptions/MissingBackpressureException;-><init>(Ljava/lang/String;)V

    invoke-interface {v0, p1}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void

    :cond_40
    invoke-interface {v1, p1}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->offer(Ljava/lang/Object;)Z

    invoke-virtual {p0}, Lio/reactivex/internal/subscribers/QueueDrainSubscriber;->enter()Z

    move-result p1

    if-nez p1, :cond_4a

    return-void

    :cond_4a
    invoke-static {v1, v0, p2, p3, p0}, Lio/reactivex/internal/util/QueueDrainHelper;->drainMaxLoop(Lio/reactivex/internal/fuseable/SimplePlainQueue;Lorg/reactivestreams/Subscriber;ZLio/reactivex/disposables/Disposable;Lio/reactivex/internal/util/QueueDrain;)V

    return-void
.end method

.method protected final fastPathOrderedEmitMax(Ljava/lang/Object;ZLio/reactivex/disposables/Disposable;)V
    .registers 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TU;Z",
            "Lio/reactivex/disposables/Disposable;",
            ")V"
        }
    .end annotation

    iget-object v0, p0, Lio/reactivex/internal/subscribers/QueueDrainSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    iget-object v1, p0, Lio/reactivex/internal/subscribers/QueueDrainSubscriber;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    invoke-virtual {p0}, Lio/reactivex/internal/subscribers/QueueDrainSubscriber;->fastEnter()Z

    move-result v2

    if-eqz v2, :cond_4d

    iget-object v2, p0, Lio/reactivex/internal/subscribers/QueueDrainSubscriber;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v2}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v4, v2, v4

    if-eqz v4, :cond_3c

    invoke-interface {v1}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->isEmpty()Z

    move-result v4

    if-eqz v4, :cond_38

    invoke-virtual {p0, v0, p1}, Lio/reactivex/internal/subscribers/QueueDrainSubscriber;->accept(Lorg/reactivestreams/Subscriber;Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_30

    const-wide v4, 0x7fffffffffffffffL

    cmp-long p1, v2, v4

    if-eqz p1, :cond_30

    const-wide/16 v2, 0x1

    invoke-virtual {p0, v2, v3}, Lio/reactivex/internal/subscribers/QueueDrainSubscriber;->produced(J)J

    :cond_30
    const/4 p1, -0x1

    invoke-virtual {p0, p1}, Lio/reactivex/internal/subscribers/QueueDrainSubscriber;->leave(I)I

    move-result p1

    if-nez p1, :cond_57

    return-void

    :cond_38
    invoke-interface {v1, p1}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->offer(Ljava/lang/Object;)Z

    goto :goto_57

    :cond_3c
    const/4 p1, 0x1

    iput-boolean p1, p0, Lio/reactivex/internal/subscribers/QueueDrainSubscriber;->cancelled:Z

    invoke-interface {p3}, Lio/reactivex/disposables/Disposable;->dispose()V

    new-instance p1, Lio/reactivex/exceptions/MissingBackpressureException;

    const-string p2, "Could not emit buffer due to lack of requests"

    invoke-direct {p1, p2}, Lio/reactivex/exceptions/MissingBackpressureException;-><init>(Ljava/lang/String;)V

    invoke-interface {v0, p1}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void

    :cond_4d
    invoke-interface {v1, p1}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->offer(Ljava/lang/Object;)Z

    invoke-virtual {p0}, Lio/reactivex/internal/subscribers/QueueDrainSubscriber;->enter()Z

    move-result p1

    if-nez p1, :cond_57

    return-void

    :cond_57
    :goto_57
    invoke-static {v1, v0, p2, p3, p0}, Lio/reactivex/internal/util/QueueDrainHelper;->drainMaxLoop(Lio/reactivex/internal/fuseable/SimplePlainQueue;Lorg/reactivestreams/Subscriber;ZLio/reactivex/disposables/Disposable;Lio/reactivex/internal/util/QueueDrain;)V

    return-void
.end method

.method public final leave(I)I
    .registers 3

    iget-object v0, p0, Lio/reactivex/internal/subscribers/QueueDrainSubscriber;->wip:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/atomic/AtomicInteger;->addAndGet(I)I

    move-result p1

    return p1
.end method

.method public final produced(J)J
    .registers 4

    iget-object v0, p0, Lio/reactivex/internal/subscribers/QueueDrainSubscriber;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    neg-long p1, p1

    invoke-virtual {v0, p1, p2}, Ljava/util/concurrent/atomic/AtomicLong;->addAndGet(J)J

    move-result-wide p1

    return-wide p1
.end method

.method public final requested()J
    .registers 3

    iget-object v0, p0, Lio/reactivex/internal/subscribers/QueueDrainSubscriber;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v0

    return-wide v0
.end method

.method public final requested(J)V
    .registers 4

    invoke-static {p1, p2}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->validate(J)Z

    move-result v0

    if-eqz v0, :cond_b

    iget-object v0, p0, Lio/reactivex/internal/subscribers/QueueDrainSubscriber;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-static {v0, p1, p2}, Lio/reactivex/internal/util/BackpressureHelper;->add(Ljava/util/concurrent/atomic/AtomicLong;J)J

    :cond_b
    return-void
.end method
