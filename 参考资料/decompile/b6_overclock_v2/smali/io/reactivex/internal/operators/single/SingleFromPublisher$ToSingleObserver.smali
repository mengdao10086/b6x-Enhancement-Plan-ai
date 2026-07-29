.class final Lio/reactivex/internal/operators/single/SingleFromPublisher$ToSingleObserver;
.super Ljava/lang/Object;
.source "SingleFromPublisher.java"

# interfaces
.implements Lio/reactivex/FlowableSubscriber;
.implements Lio/reactivex/disposables/Disposable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/single/SingleFromPublisher;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "ToSingleObserver"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lio/reactivex/FlowableSubscriber<",
        "TT;>;",
        "Lio/reactivex/disposables/Disposable;"
    }
.end annotation


# instance fields
.field volatile disposed:Z

.field done:Z

.field final downstream:Lio/reactivex/SingleObserver;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/SingleObserver<",
            "-TT;>;"
        }
    .end annotation
.end field

.field upstream:Lorg/reactivestreams/Subscription;

.field value:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lio/reactivex/SingleObserver;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/SingleObserver<",
            "-TT;>;)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/single/SingleFromPublisher$ToSingleObserver;->downstream:Lio/reactivex/SingleObserver;

    return-void
.end method


# virtual methods
.method public dispose()V
    .registers 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/single/SingleFromPublisher$ToSingleObserver;->disposed:Z

    iget-object v0, p0, Lio/reactivex/internal/operators/single/SingleFromPublisher$ToSingleObserver;->upstream:Lorg/reactivestreams/Subscription;

    invoke-interface {v0}, Lorg/reactivestreams/Subscription;->cancel()V

    return-void
.end method

.method public isDisposed()Z
    .registers 2

    iget-boolean v0, p0, Lio/reactivex/internal/operators/single/SingleFromPublisher$ToSingleObserver;->disposed:Z

    return v0
.end method

.method public onComplete()V
    .registers 4

    iget-boolean v0, p0, Lio/reactivex/internal/operators/single/SingleFromPublisher$ToSingleObserver;->done:Z

    if-eqz v0, :cond_5

    return-void

    :cond_5
    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/single/SingleFromPublisher$ToSingleObserver;->done:Z

    iget-object v0, p0, Lio/reactivex/internal/operators/single/SingleFromPublisher$ToSingleObserver;->value:Ljava/lang/Object;

    const/4 v1, 0x0

    iput-object v1, p0, Lio/reactivex/internal/operators/single/SingleFromPublisher$ToSingleObserver;->value:Ljava/lang/Object;

    if-nez v0, :cond_1c

    iget-object v0, p0, Lio/reactivex/internal/operators/single/SingleFromPublisher$ToSingleObserver;->downstream:Lio/reactivex/SingleObserver;

    new-instance v1, Ljava/util/NoSuchElementException;

    const-string v2, "The source Publisher is empty"

    invoke-direct {v1, v2}, Ljava/util/NoSuchElementException;-><init>(Ljava/lang/String;)V

    invoke-interface {v0, v1}, Lio/reactivex/SingleObserver;->onError(Ljava/lang/Throwable;)V

    goto :goto_21

    :cond_1c
    iget-object v1, p0, Lio/reactivex/internal/operators/single/SingleFromPublisher$ToSingleObserver;->downstream:Lio/reactivex/SingleObserver;

    invoke-interface {v1, v0}, Lio/reactivex/SingleObserver;->onSuccess(Ljava/lang/Object;)V

    :goto_21
    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 3

    iget-boolean v0, p0, Lio/reactivex/internal/operators/single/SingleFromPublisher$ToSingleObserver;->done:Z

    if-eqz v0, :cond_8

    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    return-void

    :cond_8
    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/single/SingleFromPublisher$ToSingleObserver;->done:Z

    const/4 v0, 0x0

    iput-object v0, p0, Lio/reactivex/internal/operators/single/SingleFromPublisher$ToSingleObserver;->value:Ljava/lang/Object;

    iget-object v0, p0, Lio/reactivex/internal/operators/single/SingleFromPublisher$ToSingleObserver;->downstream:Lio/reactivex/SingleObserver;

    invoke-interface {v0, p1}, Lio/reactivex/SingleObserver;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    iget-boolean v0, p0, Lio/reactivex/internal/operators/single/SingleFromPublisher$ToSingleObserver;->done:Z

    if-eqz v0, :cond_5

    return-void

    :cond_5
    iget-object v0, p0, Lio/reactivex/internal/operators/single/SingleFromPublisher$ToSingleObserver;->value:Ljava/lang/Object;

    if-eqz v0, :cond_21

    iget-object p1, p0, Lio/reactivex/internal/operators/single/SingleFromPublisher$ToSingleObserver;->upstream:Lorg/reactivestreams/Subscription;

    invoke-interface {p1}, Lorg/reactivestreams/Subscription;->cancel()V

    const/4 p1, 0x1

    iput-boolean p1, p0, Lio/reactivex/internal/operators/single/SingleFromPublisher$ToSingleObserver;->done:Z

    const/4 p1, 0x0

    iput-object p1, p0, Lio/reactivex/internal/operators/single/SingleFromPublisher$ToSingleObserver;->value:Ljava/lang/Object;

    iget-object p1, p0, Lio/reactivex/internal/operators/single/SingleFromPublisher$ToSingleObserver;->downstream:Lio/reactivex/SingleObserver;

    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    const-string v1, "Too many elements in the Publisher"

    invoke-direct {v0, v1}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    invoke-interface {p1, v0}, Lio/reactivex/SingleObserver;->onError(Ljava/lang/Throwable;)V

    goto :goto_23

    :cond_21
    iput-object p1, p0, Lio/reactivex/internal/operators/single/SingleFromPublisher$ToSingleObserver;->value:Ljava/lang/Object;

    :goto_23
    return-void
.end method

.method public onSubscribe(Lorg/reactivestreams/Subscription;)V
    .registers 4

    iget-object v0, p0, Lio/reactivex/internal/operators/single/SingleFromPublisher$ToSingleObserver;->upstream:Lorg/reactivestreams/Subscription;

    invoke-static {v0, p1}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->validate(Lorg/reactivestreams/Subscription;Lorg/reactivestreams/Subscription;)Z

    move-result v0

    if-eqz v0, :cond_17

    iput-object p1, p0, Lio/reactivex/internal/operators/single/SingleFromPublisher$ToSingleObserver;->upstream:Lorg/reactivestreams/Subscription;

    iget-object v0, p0, Lio/reactivex/internal/operators/single/SingleFromPublisher$ToSingleObserver;->downstream:Lio/reactivex/SingleObserver;

    invoke-interface {v0, p0}, Lio/reactivex/SingleObserver;->onSubscribe(Lio/reactivex/disposables/Disposable;)V

    const-wide v0, 0x7fffffffffffffffL

    invoke-interface {p1, v0, v1}, Lorg/reactivestreams/Subscription;->request(J)V

    :cond_17
    return-void
.end method
