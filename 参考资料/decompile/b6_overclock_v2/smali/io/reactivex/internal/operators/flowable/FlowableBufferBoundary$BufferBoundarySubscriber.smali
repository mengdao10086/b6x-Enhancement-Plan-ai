.class final Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;
.super Ljava/util/concurrent/atomic/AtomicInteger;
.source "FlowableBufferBoundary.java"

# interfaces
.implements Lio/reactivex/FlowableSubscriber;
.implements Lorg/reactivestreams/Subscription;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "BufferBoundarySubscriber"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber$BufferOpenSubscriber;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        "C::",
        "Ljava/util/Collection<",
        "-TT;>;Open:",
        "Ljava/lang/Object;",
        "Close:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/util/concurrent/atomic/AtomicInteger;",
        "Lio/reactivex/FlowableSubscriber<",
        "TT;>;",
        "Lorg/reactivestreams/Subscription;"
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = -0x757ec2d16eaff404L


# instance fields
.field final bufferClose:Lio/reactivex/functions/Function;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/functions/Function<",
            "-TOpen;+",
            "Lorg/reactivestreams/Publisher<",
            "+TClose;>;>;"
        }
    .end annotation
.end field

.field final bufferOpen:Lorg/reactivestreams/Publisher;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/reactivestreams/Publisher<",
            "+TOpen;>;"
        }
    .end annotation
.end field

.field final bufferSupplier:Ljava/util/concurrent/Callable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/Callable<",
            "TC;>;"
        }
    .end annotation
.end field

.field buffers:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/Long;",
            "TC;>;"
        }
    .end annotation
.end field

.field volatile cancelled:Z

.field volatile done:Z

.field final downstream:Lorg/reactivestreams/Subscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/reactivestreams/Subscriber<",
            "-TC;>;"
        }
    .end annotation
.end field

.field emitted:J

.field final errors:Lio/reactivex/internal/util/AtomicThrowable;

.field index:J

.field final queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/internal/queue/SpscLinkedArrayQueue<",
            "TC;>;"
        }
    .end annotation
.end field

.field final requested:Ljava/util/concurrent/atomic/AtomicLong;

.field final subscribers:Lio/reactivex/disposables/CompositeDisposable;

.field final upstream:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference<",
            "Lorg/reactivestreams/Subscription;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lorg/reactivestreams/Subscriber;Lorg/reactivestreams/Publisher;Lio/reactivex/functions/Function;Ljava/util/concurrent/Callable;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Subscriber<",
            "-TC;>;",
            "Lorg/reactivestreams/Publisher<",
            "+TOpen;>;",
            "Lio/reactivex/functions/Function<",
            "-TOpen;+",
            "Lorg/reactivestreams/Publisher<",
            "+TClose;>;>;",
            "Ljava/util/concurrent/Callable<",
            "TC;>;)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    iput-object p4, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->bufferSupplier:Ljava/util/concurrent/Callable;

    iput-object p2, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->bufferOpen:Lorg/reactivestreams/Publisher;

    iput-object p3, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->bufferClose:Lio/reactivex/functions/Function;

    new-instance p1, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    invoke-static {}, Lio/reactivex/Flowable;->bufferSize()I

    move-result p2

    invoke-direct {p1, p2}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;-><init>(I)V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    new-instance p1, Lio/reactivex/disposables/CompositeDisposable;

    invoke-direct {p1}, Lio/reactivex/disposables/CompositeDisposable;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->subscribers:Lio/reactivex/disposables/CompositeDisposable;

    new-instance p1, Ljava/util/concurrent/atomic/AtomicLong;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicLong;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    new-instance p1, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    new-instance p1, Ljava/util/LinkedHashMap;

    invoke-direct {p1}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->buffers:Ljava/util/Map;

    new-instance p1, Lio/reactivex/internal/util/AtomicThrowable;

    invoke-direct {p1}, Lio/reactivex/internal/util/AtomicThrowable;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    return-void
.end method


# virtual methods
.method boundaryError(Lio/reactivex/disposables/Disposable;Ljava/lang/Throwable;)V
    .registers 4

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->cancel(Ljava/util/concurrent/atomic/AtomicReference;)Z

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->subscribers:Lio/reactivex/disposables/CompositeDisposable;

    invoke-virtual {v0, p1}, Lio/reactivex/disposables/CompositeDisposable;->delete(Lio/reactivex/disposables/Disposable;)Z

    invoke-virtual {p0, p2}, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public cancel()V
    .registers 2

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->cancel(Ljava/util/concurrent/atomic/AtomicReference;)Z

    move-result v0

    if-eqz v0, :cond_24

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->cancelled:Z

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->subscribers:Lio/reactivex/disposables/CompositeDisposable;

    invoke-virtual {v0}, Lio/reactivex/disposables/CompositeDisposable;->dispose()V

    monitor-enter p0

    const/4 v0, 0x0

    :try_start_12
    iput-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->buffers:Ljava/util/Map;

    monitor-exit p0
    :try_end_15
    .catchall {:try_start_12 .. :try_end_15} :catchall_21

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->getAndIncrement()I

    move-result v0

    if-eqz v0, :cond_24

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    invoke-virtual {v0}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->clear()V

    goto :goto_24

    :catchall_21
    move-exception v0

    :try_start_22
    monitor-exit p0
    :try_end_23
    .catchall {:try_start_22 .. :try_end_23} :catchall_21

    throw v0

    :cond_24
    :goto_24
    return-void
.end method

.method close(Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferCloseSubscriber;J)V
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferCloseSubscriber<",
            "TT;TC;>;J)V"
        }
    .end annotation

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->subscribers:Lio/reactivex/disposables/CompositeDisposable;

    invoke-virtual {v0, p1}, Lio/reactivex/disposables/CompositeDisposable;->delete(Lio/reactivex/disposables/Disposable;)Z

    iget-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->subscribers:Lio/reactivex/disposables/CompositeDisposable;

    invoke-virtual {p1}, Lio/reactivex/disposables/CompositeDisposable;->size()I

    move-result p1

    const/4 v0, 0x1

    if-nez p1, :cond_15

    iget-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {p1}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->cancel(Ljava/util/concurrent/atomic/AtomicReference;)Z

    move p1, v0

    goto :goto_16

    :cond_15
    const/4 p1, 0x0

    :goto_16
    monitor-enter p0

    :try_start_17
    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->buffers:Ljava/util/Map;

    if-nez v1, :cond_1d

    monitor-exit p0

    return-void

    :cond_1d
    iget-object v2, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p2

    invoke-interface {v1, p2}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p2

    invoke-virtual {v2, p2}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->offer(Ljava/lang/Object;)Z

    monitor-exit p0
    :try_end_2b
    .catchall {:try_start_17 .. :try_end_2b} :catchall_33

    if-eqz p1, :cond_2f

    iput-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->done:Z

    :cond_2f
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->drain()V

    return-void

    :catchall_33
    move-exception p1

    :try_start_34
    monitor-exit p0
    :try_end_35
    .catchall {:try_start_34 .. :try_end_35} :catchall_33

    throw p1
.end method

.method drain()V
    .registers 13

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->getAndIncrement()I

    move-result v0

    if-eqz v0, :cond_7

    return-void

    :cond_7
    iget-wide v0, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->emitted:J

    iget-object v2, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    iget-object v3, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    const/4 v4, 0x1

    move v5, v4

    :cond_f
    iget-object v6, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v6}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v6

    :goto_15
    cmp-long v8, v0, v6

    if-eqz v8, :cond_57

    iget-boolean v9, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->cancelled:Z

    if-eqz v9, :cond_21

    invoke-virtual {v3}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->clear()V

    return-void

    :cond_21
    iget-boolean v9, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->done:Z

    if-eqz v9, :cond_3a

    iget-object v10, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v10}, Lio/reactivex/internal/util/AtomicThrowable;->get()Ljava/lang/Object;

    move-result-object v10

    if-eqz v10, :cond_3a

    invoke-virtual {v3}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->clear()V

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v0}, Lio/reactivex/internal/util/AtomicThrowable;->terminate()Ljava/lang/Throwable;

    move-result-object v0

    invoke-interface {v2, v0}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void

    :cond_3a
    invoke-virtual {v3}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->poll()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/util/Collection;

    if-nez v10, :cond_44

    move v11, v4

    goto :goto_45

    :cond_44
    const/4 v11, 0x0

    :goto_45
    if-eqz v9, :cond_4d

    if-eqz v11, :cond_4d

    invoke-interface {v2}, Lorg/reactivestreams/Subscriber;->onComplete()V

    return-void

    :cond_4d
    if-eqz v11, :cond_50

    goto :goto_57

    :cond_50
    invoke-interface {v2, v10}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    const-wide/16 v8, 0x1

    add-long/2addr v0, v8

    goto :goto_15

    :cond_57
    :goto_57
    if-nez v8, :cond_84

    iget-boolean v6, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->cancelled:Z

    if-eqz v6, :cond_61

    invoke-virtual {v3}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->clear()V

    return-void

    :cond_61
    iget-boolean v6, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->done:Z

    if-eqz v6, :cond_84

    iget-object v6, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v6}, Lio/reactivex/internal/util/AtomicThrowable;->get()Ljava/lang/Object;

    move-result-object v6

    if-eqz v6, :cond_7a

    invoke-virtual {v3}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->clear()V

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v0}, Lio/reactivex/internal/util/AtomicThrowable;->terminate()Ljava/lang/Throwable;

    move-result-object v0

    invoke-interface {v2, v0}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void

    :cond_7a
    invoke-virtual {v3}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->isEmpty()Z

    move-result v6

    if-eqz v6, :cond_84

    invoke-interface {v2}, Lorg/reactivestreams/Subscriber;->onComplete()V

    return-void

    :cond_84
    iput-wide v0, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->emitted:J

    neg-int v5, v5

    invoke-virtual {p0, v5}, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->addAndGet(I)I

    move-result v5

    if-nez v5, :cond_f

    return-void
.end method

.method public onComplete()V
    .registers 4

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->subscribers:Lio/reactivex/disposables/CompositeDisposable;

    invoke-virtual {v0}, Lio/reactivex/disposables/CompositeDisposable;->dispose()V

    monitor-enter p0

    :try_start_6
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->buffers:Ljava/util/Map;

    if-nez v0, :cond_c

    monitor-exit p0

    return-void

    :cond_c
    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_14
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_26

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Collection;

    iget-object v2, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    invoke-virtual {v2, v1}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->offer(Ljava/lang/Object;)Z

    goto :goto_14

    :cond_26
    const/4 v0, 0x0

    iput-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->buffers:Ljava/util/Map;

    monitor-exit p0
    :try_end_2a
    .catchall {:try_start_6 .. :try_end_2a} :catchall_31

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->done:Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->drain()V

    return-void

    :catchall_31
    move-exception v0

    :try_start_32
    monitor-exit p0
    :try_end_33
    .catchall {:try_start_32 .. :try_end_33} :catchall_31

    throw v0
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 3

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v0, p1}, Lio/reactivex/internal/util/AtomicThrowable;->addThrowable(Ljava/lang/Throwable;)Z

    move-result v0

    if-eqz v0, :cond_1c

    iget-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->subscribers:Lio/reactivex/disposables/CompositeDisposable;

    invoke-virtual {p1}, Lio/reactivex/disposables/CompositeDisposable;->dispose()V

    monitor-enter p0

    const/4 p1, 0x0

    :try_start_f
    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->buffers:Ljava/util/Map;

    monitor-exit p0
    :try_end_12
    .catchall {:try_start_f .. :try_end_12} :catchall_19

    const/4 p1, 0x1

    iput-boolean p1, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->done:Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->drain()V

    goto :goto_1f

    :catchall_19
    move-exception p1

    :try_start_1a
    monitor-exit p0
    :try_end_1b
    .catchall {:try_start_1a .. :try_end_1b} :catchall_19

    throw p1

    :cond_1c
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :goto_1f
    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->buffers:Ljava/util/Map;

    if-nez v0, :cond_7

    monitor-exit p0

    return-void

    :cond_7
    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_f
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1f

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Collection;

    invoke-interface {v1, p1}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    goto :goto_f

    :cond_1f
    monitor-exit p0

    return-void

    :catchall_21
    move-exception p1

    monitor-exit p0
    :try_end_23
    .catchall {:try_start_1 .. :try_end_23} :catchall_21

    throw p1
.end method

.method public onSubscribe(Lorg/reactivestreams/Subscription;)V
    .registers 4

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0, p1}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->setOnce(Ljava/util/concurrent/atomic/AtomicReference;Lorg/reactivestreams/Subscription;)Z

    move-result v0

    if-eqz v0, :cond_1f

    new-instance v0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber$BufferOpenSubscriber;

    invoke-direct {v0, p0}, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber$BufferOpenSubscriber;-><init>(Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;)V

    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->subscribers:Lio/reactivex/disposables/CompositeDisposable;

    invoke-virtual {v1, v0}, Lio/reactivex/disposables/CompositeDisposable;->add(Lio/reactivex/disposables/Disposable;)Z

    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->bufferOpen:Lorg/reactivestreams/Publisher;

    invoke-interface {v1, v0}, Lorg/reactivestreams/Publisher;->subscribe(Lorg/reactivestreams/Subscriber;)V

    const-wide v0, 0x7fffffffffffffffL

    invoke-interface {p1, v0, v1}, Lorg/reactivestreams/Subscription;->request(J)V

    :cond_1f
    return-void
.end method

.method open(Ljava/lang/Object;)V
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TOpen;)V"
        }
    .end annotation

    :try_start_0
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->bufferSupplier:Ljava/util/concurrent/Callable;

    invoke-interface {v0}, Ljava/util/concurrent/Callable;->call()Ljava/lang/Object;

    move-result-object v0

    const-string v1, "The bufferSupplier returned a null Collection"

    invoke-static {v0, v1}, Lio/reactivex/internal/functions/ObjectHelper;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Collection;

    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->bufferClose:Lio/reactivex/functions/Function;

    invoke-interface {v1, p1}, Lio/reactivex/functions/Function;->apply(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    const-string v1, "The bufferClose returned a null Publisher"

    invoke-static {p1, v1}, Lio/reactivex/internal/functions/ObjectHelper;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lorg/reactivestreams/Publisher;
    :try_end_1c
    .catchall {:try_start_0 .. :try_end_1c} :catchall_43

    iget-wide v1, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->index:J

    const-wide/16 v3, 0x1

    add-long/2addr v3, v1

    iput-wide v3, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->index:J

    monitor-enter p0

    :try_start_24
    iget-object v3, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->buffers:Ljava/util/Map;

    if-nez v3, :cond_2a

    monitor-exit p0

    return-void

    :cond_2a
    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-interface {v3, v4, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    monitor-exit p0
    :try_end_32
    .catchall {:try_start_24 .. :try_end_32} :catchall_40

    new-instance v0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferCloseSubscriber;

    invoke-direct {v0, p0, v1, v2}, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferCloseSubscriber;-><init>(Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;J)V

    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->subscribers:Lio/reactivex/disposables/CompositeDisposable;

    invoke-virtual {v1, v0}, Lio/reactivex/disposables/CompositeDisposable;->add(Lio/reactivex/disposables/Disposable;)Z

    invoke-interface {p1, v0}, Lorg/reactivestreams/Publisher;->subscribe(Lorg/reactivestreams/Subscriber;)V

    return-void

    :catchall_40
    move-exception p1

    :try_start_41
    monitor-exit p0
    :try_end_42
    .catchall {:try_start_41 .. :try_end_42} :catchall_40

    throw p1

    :catchall_43
    move-exception p1

    invoke-static {p1}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->cancel(Ljava/util/concurrent/atomic/AtomicReference;)Z

    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method openComplete(Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber$BufferOpenSubscriber;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber$BufferOpenSubscriber<",
            "TOpen;>;)V"
        }
    .end annotation

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->subscribers:Lio/reactivex/disposables/CompositeDisposable;

    invoke-virtual {v0, p1}, Lio/reactivex/disposables/CompositeDisposable;->delete(Lio/reactivex/disposables/Disposable;)Z

    iget-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->subscribers:Lio/reactivex/disposables/CompositeDisposable;

    invoke-virtual {p1}, Lio/reactivex/disposables/CompositeDisposable;->size()I

    move-result p1

    if-nez p1, :cond_18

    iget-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {p1}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->cancel(Ljava/util/concurrent/atomic/AtomicReference;)Z

    const/4 p1, 0x1

    iput-boolean p1, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->done:Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->drain()V

    :cond_18
    return-void
.end method

.method public request(J)V
    .registers 4

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-static {v0, p1, p2}, Lio/reactivex/internal/util/BackpressureHelper;->add(Ljava/util/concurrent/atomic/AtomicLong;J)J

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableBufferBoundary$BufferBoundarySubscriber;->drain()V

    return-void
.end method
