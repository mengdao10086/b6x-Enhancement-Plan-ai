.class public final Lio/reactivex/internal/operators/flowable/FlowablePublishAlt;
.super Lio/reactivex/flowables/ConnectableFlowable;
.source "FlowablePublishAlt.java"

# interfaces
.implements Lio/reactivex/internal/fuseable/HasUpstreamPublisher;
.implements Lio/reactivex/internal/disposables/ResettableConnectable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;,
        Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lio/reactivex/flowables/ConnectableFlowable<",
        "TT;>;",
        "Lio/reactivex/internal/fuseable/HasUpstreamPublisher<",
        "TT;>;",
        "Lio/reactivex/internal/disposables/ResettableConnectable;"
    }
.end annotation


# instance fields
.field final bufferSize:I

.field final current:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference<",
            "Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection<",
            "TT;>;>;"
        }
    .end annotation
.end field

.field final source:Lorg/reactivestreams/Publisher;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/reactivestreams/Publisher<",
            "TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lorg/reactivestreams/Publisher;I)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Publisher<",
            "TT;>;I)V"
        }
    .end annotation

    .line 53
    invoke-direct {p0}, Lio/reactivex/flowables/ConnectableFlowable;-><init>()V

    .line 54
    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt;->source:Lorg/reactivestreams/Publisher;

    .line 55
    iput p2, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt;->bufferSize:I

    .line 56
    new-instance p1, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt;->current:Ljava/util/concurrent/atomic/AtomicReference;

    return-void
.end method


# virtual methods
.method public connect(Lio/reactivex/functions/Consumer;)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/functions/Consumer<",
            "-",
            "Lio/reactivex/disposables/Disposable;",
            ">;)V"
        }
    .end annotation

    .line 78
    :goto_0
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt;->current:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;

    if-eqz v0, :cond_10

    .line 80
    invoke-virtual {v0}, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->isDisposed()Z

    move-result v1

    if-eqz v1, :cond_23

    .line 81
    :cond_10
    new-instance v1, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;

    iget-object v2, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt;->current:Ljava/util/concurrent/atomic/AtomicReference;

    iget v3, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt;->bufferSize:I

    invoke-direct {v1, v2, v3}, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;-><init>(Ljava/util/concurrent/atomic/AtomicReference;I)V

    .line 82
    iget-object v2, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt;->current:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v2, v0, v1}, Landroidx/lifecycle/LifecycleKt$$ExternalSyntheticBackportWithForwarding0;->m(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_22

    goto :goto_0

    :cond_22
    move-object v0, v1

    .line 88
    :cond_23
    iget-object v1, v0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->connect:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v1

    const/4 v2, 0x0

    if-nez v1, :cond_36

    iget-object v1, v0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->connect:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v3}, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(ZZ)Z

    move-result v1

    if-eqz v1, :cond_36

    move v2, v3

    .line 93
    :cond_36
    :try_start_36
    invoke-interface {p1, v0}, Lio/reactivex/functions/Consumer;->accept(Ljava/lang/Object;)V
    :try_end_39
    .catchall {:try_start_36 .. :try_end_39} :catchall_41

    if-eqz v2, :cond_40

    .line 100
    iget-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt;->source:Lorg/reactivestreams/Publisher;

    invoke-interface {p1, v0}, Lorg/reactivestreams/Publisher;->subscribe(Lorg/reactivestreams/Subscriber;)V

    :cond_40
    return-void

    :catchall_41
    move-exception p1

    .line 95
    invoke-static {p1}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 96
    invoke-static {p1}, Lio/reactivex/internal/util/ExceptionHelper;->wrapOrThrow(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;

    move-result-object p1

    throw p1
.end method

.method public publishBufferSize()I
    .registers 2

    .line 69
    iget v0, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt;->bufferSize:I

    return v0
.end method

.method public resetIf(Lio/reactivex/disposables/Disposable;)V
    .registers 4

    .line 146
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt;->current:Ljava/util/concurrent/atomic/AtomicReference;

    check-cast p1, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;

    const/4 v1, 0x0

    invoke-static {v0, p1, v1}, Landroidx/lifecycle/LifecycleKt$$ExternalSyntheticBackportWithForwarding0;->m(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Z

    return-void
.end method

.method public source()Lorg/reactivestreams/Publisher;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lorg/reactivestreams/Publisher<",
            "TT;>;"
        }
    .end annotation

    .line 61
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt;->source:Lorg/reactivestreams/Publisher;

    return-object v0
.end method

.method protected subscribeActual(Lorg/reactivestreams/Subscriber;)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;)V"
        }
    .end annotation

    .line 109
    :goto_0
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt;->current:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;

    if-nez v0, :cond_1d

    .line 113
    new-instance v1, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;

    iget-object v2, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt;->current:Ljava/util/concurrent/atomic/AtomicReference;

    iget v3, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt;->bufferSize:I

    invoke-direct {v1, v2, v3}, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;-><init>(Ljava/util/concurrent/atomic/AtomicReference;I)V

    .line 114
    iget-object v2, p0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt;->current:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v2, v0, v1}, Landroidx/lifecycle/LifecycleKt$$ExternalSyntheticBackportWithForwarding0;->m(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1c

    goto :goto_0

    :cond_1c
    move-object v0, v1

    .line 123
    :cond_1d
    new-instance v1, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;

    invoke-direct {v1, p1, v0}, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;-><init>(Lorg/reactivestreams/Subscriber;Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;)V

    .line 124
    invoke-interface {p1, v1}, Lorg/reactivestreams/Subscriber;->onSubscribe(Lorg/reactivestreams/Subscription;)V

    .line 126
    invoke-virtual {v0, v1}, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->add(Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;)Z

    move-result v2

    if-eqz v2, :cond_39

    .line 127
    invoke-virtual {v1}, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;->isCancelled()Z

    move-result p1

    if-eqz p1, :cond_35

    .line 128
    invoke-virtual {v0, v1}, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->remove(Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$InnerSubscription;)V

    goto :goto_38

    .line 130
    :cond_35
    invoke-virtual {v0}, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->drain()V

    :goto_38
    return-void

    .line 135
    :cond_39
    iget-object v0, v0, Lio/reactivex/internal/operators/flowable/FlowablePublishAlt$PublishConnection;->error:Ljava/lang/Throwable;

    if-eqz v0, :cond_41

    .line 137
    invoke-interface {p1, v0}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    goto :goto_44

    .line 139
    :cond_41
    invoke-interface {p1}, Lorg/reactivestreams/Subscriber;->onComplete()V

    :goto_44
    return-void
.end method
