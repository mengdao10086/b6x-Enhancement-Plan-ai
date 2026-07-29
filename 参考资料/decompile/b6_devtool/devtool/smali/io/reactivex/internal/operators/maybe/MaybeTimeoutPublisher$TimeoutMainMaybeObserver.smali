.class final Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutMainMaybeObserver;
.super Ljava/util/concurrent/atomic/AtomicReference;
.source "MaybeTimeoutPublisher.java"

# interfaces
.implements Lio/reactivex/MaybeObserver;
.implements Lio/reactivex/disposables/Disposable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "TimeoutMainMaybeObserver"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        "U:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/util/concurrent/atomic/AtomicReference<",
        "Lio/reactivex/disposables/Disposable;",
        ">;",
        "Lio/reactivex/MaybeObserver<",
        "TT;>;",
        "Lio/reactivex/disposables/Disposable;"
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = -0x52a56ffc3eeb9b77L


# instance fields
.field final downstream:Lio/reactivex/MaybeObserver;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/MaybeObserver<",
            "-TT;>;"
        }
    .end annotation
.end field

.field final fallback:Lio/reactivex/MaybeSource;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/MaybeSource<",
            "+TT;>;"
        }
    .end annotation
.end field

.field final other:Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutOtherMaybeObserver;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutOtherMaybeObserver<",
            "TT;TU;>;"
        }
    .end annotation
.end field

.field final otherObserver:Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutFallbackMaybeObserver;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutFallbackMaybeObserver<",
            "TT;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lio/reactivex/MaybeObserver;Lio/reactivex/MaybeSource;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/MaybeObserver<",
            "-TT;>;",
            "Lio/reactivex/MaybeSource<",
            "+TT;>;)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutMainMaybeObserver;->downstream:Lio/reactivex/MaybeObserver;

    new-instance v0, Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutOtherMaybeObserver;

    invoke-direct {v0, p0}, Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutOtherMaybeObserver;-><init>(Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutMainMaybeObserver;)V

    iput-object v0, p0, Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutMainMaybeObserver;->other:Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutOtherMaybeObserver;

    iput-object p2, p0, Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutMainMaybeObserver;->fallback:Lio/reactivex/MaybeSource;

    if-eqz p2, :cond_16

    new-instance p2, Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutFallbackMaybeObserver;

    invoke-direct {p2, p1}, Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutFallbackMaybeObserver;-><init>(Lio/reactivex/MaybeObserver;)V

    goto :goto_17

    :cond_16
    const/4 p2, 0x0

    :goto_17
    iput-object p2, p0, Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutMainMaybeObserver;->otherObserver:Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutFallbackMaybeObserver;

    return-void
.end method


# virtual methods
.method public dispose()V
    .registers 2

    invoke-static {p0}, Lio/reactivex/internal/disposables/DisposableHelper;->dispose(Ljava/util/concurrent/atomic/AtomicReference;)Z

    iget-object v0, p0, Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutMainMaybeObserver;->other:Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutOtherMaybeObserver;

    invoke-static {v0}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->cancel(Ljava/util/concurrent/atomic/AtomicReference;)Z

    iget-object v0, p0, Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutMainMaybeObserver;->otherObserver:Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutFallbackMaybeObserver;

    if-eqz v0, :cond_f

    invoke-static {v0}, Lio/reactivex/internal/disposables/DisposableHelper;->dispose(Ljava/util/concurrent/atomic/AtomicReference;)Z

    :cond_f
    return-void
.end method

.method public isDisposed()Z
    .registers 2

    invoke-virtual {p0}, Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutMainMaybeObserver;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lio/reactivex/disposables/Disposable;

    invoke-static {v0}, Lio/reactivex/internal/disposables/DisposableHelper;->isDisposed(Lio/reactivex/disposables/Disposable;)Z

    move-result v0

    return v0
.end method

.method public onComplete()V
    .registers 3

    iget-object v0, p0, Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutMainMaybeObserver;->other:Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutOtherMaybeObserver;

    invoke-static {v0}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->cancel(Ljava/util/concurrent/atomic/AtomicReference;)Z

    sget-object v0, Lio/reactivex/internal/disposables/DisposableHelper;->DISPOSED:Lio/reactivex/internal/disposables/DisposableHelper;

    invoke-virtual {p0, v0}, Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutMainMaybeObserver;->getAndSet(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    sget-object v1, Lio/reactivex/internal/disposables/DisposableHelper;->DISPOSED:Lio/reactivex/internal/disposables/DisposableHelper;

    if-eq v0, v1, :cond_14

    iget-object v0, p0, Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutMainMaybeObserver;->downstream:Lio/reactivex/MaybeObserver;

    invoke-interface {v0}, Lio/reactivex/MaybeObserver;->onComplete()V

    :cond_14
    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 4

    iget-object v0, p0, Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutMainMaybeObserver;->other:Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutOtherMaybeObserver;

    invoke-static {v0}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->cancel(Ljava/util/concurrent/atomic/AtomicReference;)Z

    sget-object v0, Lio/reactivex/internal/disposables/DisposableHelper;->DISPOSED:Lio/reactivex/internal/disposables/DisposableHelper;

    invoke-virtual {p0, v0}, Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutMainMaybeObserver;->getAndSet(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    sget-object v1, Lio/reactivex/internal/disposables/DisposableHelper;->DISPOSED:Lio/reactivex/internal/disposables/DisposableHelper;

    if-eq v0, v1, :cond_15

    iget-object v0, p0, Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutMainMaybeObserver;->downstream:Lio/reactivex/MaybeObserver;

    invoke-interface {v0, p1}, Lio/reactivex/MaybeObserver;->onError(Ljava/lang/Throwable;)V

    goto :goto_18

    :cond_15
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :goto_18
    return-void
.end method

.method public onSubscribe(Lio/reactivex/disposables/Disposable;)V
    .registers 2

    invoke-static {p0, p1}, Lio/reactivex/internal/disposables/DisposableHelper;->setOnce(Ljava/util/concurrent/atomic/AtomicReference;Lio/reactivex/disposables/Disposable;)Z

    return-void
.end method

.method public onSuccess(Ljava/lang/Object;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    iget-object v0, p0, Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutMainMaybeObserver;->other:Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutOtherMaybeObserver;

    invoke-static {v0}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->cancel(Ljava/util/concurrent/atomic/AtomicReference;)Z

    sget-object v0, Lio/reactivex/internal/disposables/DisposableHelper;->DISPOSED:Lio/reactivex/internal/disposables/DisposableHelper;

    invoke-virtual {p0, v0}, Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutMainMaybeObserver;->getAndSet(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    sget-object v1, Lio/reactivex/internal/disposables/DisposableHelper;->DISPOSED:Lio/reactivex/internal/disposables/DisposableHelper;

    if-eq v0, v1, :cond_14

    iget-object v0, p0, Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutMainMaybeObserver;->downstream:Lio/reactivex/MaybeObserver;

    invoke-interface {v0, p1}, Lio/reactivex/MaybeObserver;->onSuccess(Ljava/lang/Object;)V

    :cond_14
    return-void
.end method

.method public otherComplete()V
    .registers 3

    invoke-static {p0}, Lio/reactivex/internal/disposables/DisposableHelper;->dispose(Ljava/util/concurrent/atomic/AtomicReference;)Z

    move-result v0

    if-eqz v0, :cond_1a

    iget-object v0, p0, Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutMainMaybeObserver;->fallback:Lio/reactivex/MaybeSource;

    if-nez v0, :cond_15

    iget-object v0, p0, Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutMainMaybeObserver;->downstream:Lio/reactivex/MaybeObserver;

    new-instance v1, Ljava/util/concurrent/TimeoutException;

    invoke-direct {v1}, Ljava/util/concurrent/TimeoutException;-><init>()V

    invoke-interface {v0, v1}, Lio/reactivex/MaybeObserver;->onError(Ljava/lang/Throwable;)V

    goto :goto_1a

    :cond_15
    iget-object v1, p0, Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutMainMaybeObserver;->otherObserver:Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutFallbackMaybeObserver;

    invoke-interface {v0, v1}, Lio/reactivex/MaybeSource;->subscribe(Lio/reactivex/MaybeObserver;)V

    :cond_1a
    :goto_1a
    return-void
.end method

.method public otherError(Ljava/lang/Throwable;)V
    .registers 3

    invoke-static {p0}, Lio/reactivex/internal/disposables/DisposableHelper;->dispose(Ljava/util/concurrent/atomic/AtomicReference;)Z

    move-result v0

    if-eqz v0, :cond_c

    iget-object v0, p0, Lio/reactivex/internal/operators/maybe/MaybeTimeoutPublisher$TimeoutMainMaybeObserver;->downstream:Lio/reactivex/MaybeObserver;

    invoke-interface {v0, p1}, Lio/reactivex/MaybeObserver;->onError(Ljava/lang/Throwable;)V

    goto :goto_f

    :cond_c
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :goto_f
    return-void
.end method
