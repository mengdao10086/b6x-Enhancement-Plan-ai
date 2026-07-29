.class final Lio/reactivex/processors/SerializedProcessor;
.super Lio/reactivex/processors/FlowableProcessor;
.source "SerializedProcessor.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lio/reactivex/processors/FlowableProcessor<",
        "TT;>;"
    }
.end annotation


# instance fields
.field final actual:Lio/reactivex/processors/FlowableProcessor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/processors/FlowableProcessor<",
            "TT;>;"
        }
    .end annotation
.end field

.field volatile done:Z

.field emitting:Z

.field queue:Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/internal/util/AppendOnlyLinkedArrayList<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lio/reactivex/processors/FlowableProcessor;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/processors/FlowableProcessor<",
            "TT;>;)V"
        }
    .end annotation

    invoke-direct {p0}, Lio/reactivex/processors/FlowableProcessor;-><init>()V

    iput-object p1, p0, Lio/reactivex/processors/SerializedProcessor;->actual:Lio/reactivex/processors/FlowableProcessor;

    return-void
.end method


# virtual methods
.method emitLoop()V
    .registers 3

    :goto_0
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lio/reactivex/processors/SerializedProcessor;->queue:Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;

    if-nez v0, :cond_a

    const/4 v0, 0x0

    iput-boolean v0, p0, Lio/reactivex/processors/SerializedProcessor;->emitting:Z

    monitor-exit p0

    return-void

    :cond_a
    const/4 v1, 0x0

    iput-object v1, p0, Lio/reactivex/processors/SerializedProcessor;->queue:Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;

    monitor-exit p0
    :try_end_e
    .catchall {:try_start_1 .. :try_end_e} :catchall_14

    iget-object v1, p0, Lio/reactivex/processors/SerializedProcessor;->actual:Lio/reactivex/processors/FlowableProcessor;

    invoke-virtual {v0, v1}, Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;->accept(Lorg/reactivestreams/Subscriber;)Z

    goto :goto_0

    :catchall_14
    move-exception v0

    :try_start_15
    monitor-exit p0
    :try_end_16
    .catchall {:try_start_15 .. :try_end_16} :catchall_14

    throw v0
.end method

.method public getThrowable()Ljava/lang/Throwable;
    .registers 2

    iget-object v0, p0, Lio/reactivex/processors/SerializedProcessor;->actual:Lio/reactivex/processors/FlowableProcessor;

    invoke-virtual {v0}, Lio/reactivex/processors/FlowableProcessor;->getThrowable()Ljava/lang/Throwable;

    move-result-object v0

    return-object v0
.end method

.method public hasComplete()Z
    .registers 2

    iget-object v0, p0, Lio/reactivex/processors/SerializedProcessor;->actual:Lio/reactivex/processors/FlowableProcessor;

    invoke-virtual {v0}, Lio/reactivex/processors/FlowableProcessor;->hasComplete()Z

    move-result v0

    return v0
.end method

.method public hasSubscribers()Z
    .registers 2

    iget-object v0, p0, Lio/reactivex/processors/SerializedProcessor;->actual:Lio/reactivex/processors/FlowableProcessor;

    invoke-virtual {v0}, Lio/reactivex/processors/FlowableProcessor;->hasSubscribers()Z

    move-result v0

    return v0
.end method

.method public hasThrowable()Z
    .registers 2

    iget-object v0, p0, Lio/reactivex/processors/SerializedProcessor;->actual:Lio/reactivex/processors/FlowableProcessor;

    invoke-virtual {v0}, Lio/reactivex/processors/FlowableProcessor;->hasThrowable()Z

    move-result v0

    return v0
.end method

.method public onComplete()V
    .registers 3

    iget-boolean v0, p0, Lio/reactivex/processors/SerializedProcessor;->done:Z

    if-eqz v0, :cond_5

    return-void

    :cond_5
    monitor-enter p0

    :try_start_6
    iget-boolean v0, p0, Lio/reactivex/processors/SerializedProcessor;->done:Z

    if-eqz v0, :cond_c

    monitor-exit p0

    return-void

    :cond_c
    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/processors/SerializedProcessor;->done:Z

    iget-boolean v1, p0, Lio/reactivex/processors/SerializedProcessor;->emitting:Z

    if-eqz v1, :cond_28

    iget-object v0, p0, Lio/reactivex/processors/SerializedProcessor;->queue:Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;

    if-nez v0, :cond_1f

    new-instance v0, Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;

    const/4 v1, 0x4

    invoke-direct {v0, v1}, Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;-><init>(I)V

    iput-object v0, p0, Lio/reactivex/processors/SerializedProcessor;->queue:Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;

    :cond_1f
    invoke-static {}, Lio/reactivex/internal/util/NotificationLite;->complete()Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;->add(Ljava/lang/Object;)V

    monitor-exit p0

    return-void

    :cond_28
    iput-boolean v0, p0, Lio/reactivex/processors/SerializedProcessor;->emitting:Z

    monitor-exit p0
    :try_end_2b
    .catchall {:try_start_6 .. :try_end_2b} :catchall_31

    iget-object v0, p0, Lio/reactivex/processors/SerializedProcessor;->actual:Lio/reactivex/processors/FlowableProcessor;

    invoke-virtual {v0}, Lio/reactivex/processors/FlowableProcessor;->onComplete()V

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
    .registers 4

    iget-boolean v0, p0, Lio/reactivex/processors/SerializedProcessor;->done:Z

    if-eqz v0, :cond_8

    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    return-void

    :cond_8
    monitor-enter p0

    :try_start_9
    iget-boolean v0, p0, Lio/reactivex/processors/SerializedProcessor;->done:Z

    const/4 v1, 0x1

    if-eqz v0, :cond_f

    goto :goto_2d

    :cond_f
    iput-boolean v1, p0, Lio/reactivex/processors/SerializedProcessor;->done:Z

    iget-boolean v0, p0, Lio/reactivex/processors/SerializedProcessor;->emitting:Z

    if-eqz v0, :cond_2a

    iget-object v0, p0, Lio/reactivex/processors/SerializedProcessor;->queue:Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;

    if-nez v0, :cond_21

    new-instance v0, Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;

    const/4 v1, 0x4

    invoke-direct {v0, v1}, Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;-><init>(I)V

    iput-object v0, p0, Lio/reactivex/processors/SerializedProcessor;->queue:Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;

    :cond_21
    invoke-static {p1}, Lio/reactivex/internal/util/NotificationLite;->error(Ljava/lang/Throwable;)Ljava/lang/Object;

    move-result-object p1

    invoke-virtual {v0, p1}, Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;->setFirst(Ljava/lang/Object;)V

    monitor-exit p0

    return-void

    :cond_2a
    iput-boolean v1, p0, Lio/reactivex/processors/SerializedProcessor;->emitting:Z

    const/4 v1, 0x0

    :goto_2d
    monitor-exit p0
    :try_end_2e
    .catchall {:try_start_9 .. :try_end_2e} :catchall_3a

    if-eqz v1, :cond_34

    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    return-void

    :cond_34
    iget-object v0, p0, Lio/reactivex/processors/SerializedProcessor;->actual:Lio/reactivex/processors/FlowableProcessor;

    invoke-virtual {v0, p1}, Lio/reactivex/processors/FlowableProcessor;->onError(Ljava/lang/Throwable;)V

    return-void

    :catchall_3a
    move-exception p1

    :try_start_3b
    monitor-exit p0
    :try_end_3c
    .catchall {:try_start_3b .. :try_end_3c} :catchall_3a

    throw p1
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    iget-boolean v0, p0, Lio/reactivex/processors/SerializedProcessor;->done:Z

    if-eqz v0, :cond_5

    return-void

    :cond_5
    monitor-enter p0

    :try_start_6
    iget-boolean v0, p0, Lio/reactivex/processors/SerializedProcessor;->done:Z

    if-eqz v0, :cond_c

    monitor-exit p0

    return-void

    :cond_c
    iget-boolean v0, p0, Lio/reactivex/processors/SerializedProcessor;->emitting:Z

    if-eqz v0, :cond_25

    iget-object v0, p0, Lio/reactivex/processors/SerializedProcessor;->queue:Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;

    if-nez v0, :cond_1c

    new-instance v0, Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;

    const/4 v1, 0x4

    invoke-direct {v0, v1}, Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;-><init>(I)V

    iput-object v0, p0, Lio/reactivex/processors/SerializedProcessor;->queue:Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;

    :cond_1c
    invoke-static {p1}, Lio/reactivex/internal/util/NotificationLite;->next(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    invoke-virtual {v0, p1}, Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;->add(Ljava/lang/Object;)V

    monitor-exit p0

    return-void

    :cond_25
    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/processors/SerializedProcessor;->emitting:Z

    monitor-exit p0
    :try_end_29
    .catchall {:try_start_6 .. :try_end_29} :catchall_32

    iget-object v0, p0, Lio/reactivex/processors/SerializedProcessor;->actual:Lio/reactivex/processors/FlowableProcessor;

    invoke-virtual {v0, p1}, Lio/reactivex/processors/FlowableProcessor;->onNext(Ljava/lang/Object;)V

    invoke-virtual {p0}, Lio/reactivex/processors/SerializedProcessor;->emitLoop()V

    return-void

    :catchall_32
    move-exception p1

    :try_start_33
    monitor-exit p0
    :try_end_34
    .catchall {:try_start_33 .. :try_end_34} :catchall_32

    throw p1
.end method

.method public onSubscribe(Lorg/reactivestreams/Subscription;)V
    .registers 4

    iget-boolean v0, p0, Lio/reactivex/processors/SerializedProcessor;->done:Z

    const/4 v1, 0x1

    if-nez v0, :cond_2d

    monitor-enter p0

    :try_start_6
    iget-boolean v0, p0, Lio/reactivex/processors/SerializedProcessor;->done:Z

    if-eqz v0, :cond_b

    goto :goto_28

    :cond_b
    iget-boolean v0, p0, Lio/reactivex/processors/SerializedProcessor;->emitting:Z

    if-eqz v0, :cond_24

    iget-object v0, p0, Lio/reactivex/processors/SerializedProcessor;->queue:Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;

    if-nez v0, :cond_1b

    new-instance v0, Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;

    const/4 v1, 0x4

    invoke-direct {v0, v1}, Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;-><init>(I)V

    iput-object v0, p0, Lio/reactivex/processors/SerializedProcessor;->queue:Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;

    :cond_1b
    invoke-static {p1}, Lio/reactivex/internal/util/NotificationLite;->subscription(Lorg/reactivestreams/Subscription;)Ljava/lang/Object;

    move-result-object p1

    invoke-virtual {v0, p1}, Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;->add(Ljava/lang/Object;)V

    monitor-exit p0

    return-void

    :cond_24
    iput-boolean v1, p0, Lio/reactivex/processors/SerializedProcessor;->emitting:Z

    const/4 v0, 0x0

    move v1, v0

    :goto_28
    monitor-exit p0

    goto :goto_2d

    :catchall_2a
    move-exception p1

    monitor-exit p0
    :try_end_2c
    .catchall {:try_start_6 .. :try_end_2c} :catchall_2a

    throw p1

    :cond_2d
    :goto_2d
    if-eqz v1, :cond_33

    invoke-interface {p1}, Lorg/reactivestreams/Subscription;->cancel()V

    goto :goto_3b

    :cond_33
    iget-object v0, p0, Lio/reactivex/processors/SerializedProcessor;->actual:Lio/reactivex/processors/FlowableProcessor;

    invoke-virtual {v0, p1}, Lio/reactivex/processors/FlowableProcessor;->onSubscribe(Lorg/reactivestreams/Subscription;)V

    invoke-virtual {p0}, Lio/reactivex/processors/SerializedProcessor;->emitLoop()V

    :goto_3b
    return-void
.end method

.method protected subscribeActual(Lorg/reactivestreams/Subscriber;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;)V"
        }
    .end annotation

    iget-object v0, p0, Lio/reactivex/processors/SerializedProcessor;->actual:Lio/reactivex/processors/FlowableProcessor;

    invoke-virtual {v0, p1}, Lio/reactivex/processors/FlowableProcessor;->subscribe(Lorg/reactivestreams/Subscriber;)V

    return-void
.end method
