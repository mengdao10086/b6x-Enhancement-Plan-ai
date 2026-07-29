.class final Lio/reactivex/internal/operators/completable/CompletableTakeUntilCompletable$TakeUntilMainObserver;
.super Ljava/util/concurrent/atomic/AtomicReference;
.source "CompletableTakeUntilCompletable.java"

# interfaces
.implements Lio/reactivex/CompletableObserver;
.implements Lio/reactivex/disposables/Disposable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/completable/CompletableTakeUntilCompletable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "TakeUntilMainObserver"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/reactivex/internal/operators/completable/CompletableTakeUntilCompletable$TakeUntilMainObserver$OtherObserver;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/util/concurrent/atomic/AtomicReference<",
        "Lio/reactivex/disposables/Disposable;",
        ">;",
        "Lio/reactivex/CompletableObserver;",
        "Lio/reactivex/disposables/Disposable;"
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = 0x3107c76f99bcc0dbL


# instance fields
.field final downstream:Lio/reactivex/CompletableObserver;

.field final once:Ljava/util/concurrent/atomic/AtomicBoolean;

.field final other:Lio/reactivex/internal/operators/completable/CompletableTakeUntilCompletable$TakeUntilMainObserver$OtherObserver;


# direct methods
.method constructor <init>(Lio/reactivex/CompletableObserver;)V
    .registers 2

    invoke-direct {p0}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/completable/CompletableTakeUntilCompletable$TakeUntilMainObserver;->downstream:Lio/reactivex/CompletableObserver;

    new-instance p1, Lio/reactivex/internal/operators/completable/CompletableTakeUntilCompletable$TakeUntilMainObserver$OtherObserver;

    invoke-direct {p1, p0}, Lio/reactivex/internal/operators/completable/CompletableTakeUntilCompletable$TakeUntilMainObserver$OtherObserver;-><init>(Lio/reactivex/internal/operators/completable/CompletableTakeUntilCompletable$TakeUntilMainObserver;)V

    iput-object p1, p0, Lio/reactivex/internal/operators/completable/CompletableTakeUntilCompletable$TakeUntilMainObserver;->other:Lio/reactivex/internal/operators/completable/CompletableTakeUntilCompletable$TakeUntilMainObserver$OtherObserver;

    new-instance p1, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/completable/CompletableTakeUntilCompletable$TakeUntilMainObserver;->once:Ljava/util/concurrent/atomic/AtomicBoolean;

    return-void
.end method


# virtual methods
.method public dispose()V
    .registers 4

    iget-object v0, p0, Lio/reactivex/internal/operators/completable/CompletableTakeUntilCompletable$TakeUntilMainObserver;->once:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(ZZ)Z

    move-result v0

    if-eqz v0, :cond_12

    invoke-static {p0}, Lio/reactivex/internal/disposables/DisposableHelper;->dispose(Ljava/util/concurrent/atomic/AtomicReference;)Z

    iget-object v0, p0, Lio/reactivex/internal/operators/completable/CompletableTakeUntilCompletable$TakeUntilMainObserver;->other:Lio/reactivex/internal/operators/completable/CompletableTakeUntilCompletable$TakeUntilMainObserver$OtherObserver;

    invoke-static {v0}, Lio/reactivex/internal/disposables/DisposableHelper;->dispose(Ljava/util/concurrent/atomic/AtomicReference;)Z

    :cond_12
    return-void
.end method

.method innerComplete()V
    .registers 4

    iget-object v0, p0, Lio/reactivex/internal/operators/completable/CompletableTakeUntilCompletable$TakeUntilMainObserver;->once:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(ZZ)Z

    move-result v0

    if-eqz v0, :cond_12

    invoke-static {p0}, Lio/reactivex/internal/disposables/DisposableHelper;->dispose(Ljava/util/concurrent/atomic/AtomicReference;)Z

    iget-object v0, p0, Lio/reactivex/internal/operators/completable/CompletableTakeUntilCompletable$TakeUntilMainObserver;->downstream:Lio/reactivex/CompletableObserver;

    invoke-interface {v0}, Lio/reactivex/CompletableObserver;->onComplete()V

    :cond_12
    return-void
.end method

.method innerError(Ljava/lang/Throwable;)V
    .registers 5

    iget-object v0, p0, Lio/reactivex/internal/operators/completable/CompletableTakeUntilCompletable$TakeUntilMainObserver;->once:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(ZZ)Z

    move-result v0

    if-eqz v0, :cond_13

    invoke-static {p0}, Lio/reactivex/internal/disposables/DisposableHelper;->dispose(Ljava/util/concurrent/atomic/AtomicReference;)Z

    iget-object v0, p0, Lio/reactivex/internal/operators/completable/CompletableTakeUntilCompletable$TakeUntilMainObserver;->downstream:Lio/reactivex/CompletableObserver;

    invoke-interface {v0, p1}, Lio/reactivex/CompletableObserver;->onError(Ljava/lang/Throwable;)V

    goto :goto_16

    :cond_13
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :goto_16
    return-void
.end method

.method public isDisposed()Z
    .registers 2

    iget-object v0, p0, Lio/reactivex/internal/operators/completable/CompletableTakeUntilCompletable$TakeUntilMainObserver;->once:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    return v0
.end method

.method public onComplete()V
    .registers 4

    iget-object v0, p0, Lio/reactivex/internal/operators/completable/CompletableTakeUntilCompletable$TakeUntilMainObserver;->once:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(ZZ)Z

    move-result v0

    if-eqz v0, :cond_14

    iget-object v0, p0, Lio/reactivex/internal/operators/completable/CompletableTakeUntilCompletable$TakeUntilMainObserver;->other:Lio/reactivex/internal/operators/completable/CompletableTakeUntilCompletable$TakeUntilMainObserver$OtherObserver;

    invoke-static {v0}, Lio/reactivex/internal/disposables/DisposableHelper;->dispose(Ljava/util/concurrent/atomic/AtomicReference;)Z

    iget-object v0, p0, Lio/reactivex/internal/operators/completable/CompletableTakeUntilCompletable$TakeUntilMainObserver;->downstream:Lio/reactivex/CompletableObserver;

    invoke-interface {v0}, Lio/reactivex/CompletableObserver;->onComplete()V

    :cond_14
    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 5

    iget-object v0, p0, Lio/reactivex/internal/operators/completable/CompletableTakeUntilCompletable$TakeUntilMainObserver;->once:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(ZZ)Z

    move-result v0

    if-eqz v0, :cond_15

    iget-object v0, p0, Lio/reactivex/internal/operators/completable/CompletableTakeUntilCompletable$TakeUntilMainObserver;->other:Lio/reactivex/internal/operators/completable/CompletableTakeUntilCompletable$TakeUntilMainObserver$OtherObserver;

    invoke-static {v0}, Lio/reactivex/internal/disposables/DisposableHelper;->dispose(Ljava/util/concurrent/atomic/AtomicReference;)Z

    iget-object v0, p0, Lio/reactivex/internal/operators/completable/CompletableTakeUntilCompletable$TakeUntilMainObserver;->downstream:Lio/reactivex/CompletableObserver;

    invoke-interface {v0, p1}, Lio/reactivex/CompletableObserver;->onError(Ljava/lang/Throwable;)V

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
