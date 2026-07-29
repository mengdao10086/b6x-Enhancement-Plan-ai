.class public final Lio/reactivex/internal/observers/FutureSingleObserver;
.super Ljava/util/concurrent/CountDownLatch;
.source "FutureSingleObserver.java"

# interfaces
.implements Lio/reactivex/SingleObserver;
.implements Ljava/util/concurrent/Future;
.implements Lio/reactivex/disposables/Disposable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/util/concurrent/CountDownLatch;",
        "Lio/reactivex/SingleObserver<",
        "TT;>;",
        "Ljava/util/concurrent/Future<",
        "TT;>;",
        "Lio/reactivex/disposables/Disposable;"
    }
.end annotation


# instance fields
.field error:Ljava/lang/Throwable;

.field final upstream:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference<",
            "Lio/reactivex/disposables/Disposable;",
            ">;"
        }
    .end annotation
.end field

.field value:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .registers 2

    const/4 v0, 0x1

    invoke-direct {p0, v0}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    new-instance v0, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    iput-object v0, p0, Lio/reactivex/internal/observers/FutureSingleObserver;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    return-void
.end method


# virtual methods
.method public cancel(Z)Z
    .registers 4

    :cond_0
    iget-object p1, p0, Lio/reactivex/internal/observers/FutureSingleObserver;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {p1}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lio/reactivex/disposables/Disposable;

    if-eq p1, p0, :cond_23

    sget-object v0, Lio/reactivex/internal/disposables/DisposableHelper;->DISPOSED:Lio/reactivex/internal/disposables/DisposableHelper;

    if-ne p1, v0, :cond_f

    goto :goto_23

    :cond_f
    iget-object v0, p0, Lio/reactivex/internal/observers/FutureSingleObserver;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    sget-object v1, Lio/reactivex/internal/disposables/DisposableHelper;->DISPOSED:Lio/reactivex/internal/disposables/DisposableHelper;

    invoke-static {v0, p1, v1}, Landroidx/lifecycle/LifecycleKt$$ExternalSyntheticBackportWithForwarding0;->m(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    if-eqz p1, :cond_1e

    invoke-interface {p1}, Lio/reactivex/disposables/Disposable;->dispose()V

    :cond_1e
    invoke-virtual {p0}, Lio/reactivex/internal/observers/FutureSingleObserver;->countDown()V

    const/4 p1, 0x1

    return p1

    :cond_23
    :goto_23
    const/4 p1, 0x0

    return p1
.end method

.method public dispose()V
    .registers 1

    return-void
.end method

.method public get()Ljava/lang/Object;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;,
            Ljava/util/concurrent/ExecutionException;
        }
    .end annotation

    invoke-virtual {p0}, Lio/reactivex/internal/observers/FutureSingleObserver;->getCount()J

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_10

    invoke-static {}, Lio/reactivex/internal/util/BlockingHelper;->verifyNonBlocking()V

    invoke-virtual {p0}, Lio/reactivex/internal/observers/FutureSingleObserver;->await()V

    :cond_10
    invoke-virtual {p0}, Lio/reactivex/internal/observers/FutureSingleObserver;->isCancelled()Z

    move-result v0

    if-nez v0, :cond_23

    iget-object v0, p0, Lio/reactivex/internal/observers/FutureSingleObserver;->error:Ljava/lang/Throwable;

    if-nez v0, :cond_1d

    iget-object v0, p0, Lio/reactivex/internal/observers/FutureSingleObserver;->value:Ljava/lang/Object;

    return-object v0

    :cond_1d
    new-instance v1, Ljava/util/concurrent/ExecutionException;

    invoke-direct {v1, v0}, Ljava/util/concurrent/ExecutionException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    :cond_23
    new-instance v0, Ljava/util/concurrent/CancellationException;

    invoke-direct {v0}, Ljava/util/concurrent/CancellationException;-><init>()V

    throw v0
.end method

.method public get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Ljava/util/concurrent/TimeUnit;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;,
            Ljava/util/concurrent/ExecutionException;,
            Ljava/util/concurrent/TimeoutException;
        }
    .end annotation

    invoke-virtual {p0}, Lio/reactivex/internal/observers/FutureSingleObserver;->getCount()J

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_1e

    invoke-static {}, Lio/reactivex/internal/util/BlockingHelper;->verifyNonBlocking()V

    invoke-virtual {p0, p1, p2, p3}, Lio/reactivex/internal/observers/FutureSingleObserver;->await(JLjava/util/concurrent/TimeUnit;)Z

    move-result v0

    if-eqz v0, :cond_14

    goto :goto_1e

    :cond_14
    new-instance v0, Ljava/util/concurrent/TimeoutException;

    invoke-static {p1, p2, p3}, Lio/reactivex/internal/util/ExceptionHelper;->timeoutMessage(JLjava/util/concurrent/TimeUnit;)Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/util/concurrent/TimeoutException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1e
    :goto_1e
    invoke-virtual {p0}, Lio/reactivex/internal/observers/FutureSingleObserver;->isCancelled()Z

    move-result p1

    if-nez p1, :cond_31

    iget-object p1, p0, Lio/reactivex/internal/observers/FutureSingleObserver;->error:Ljava/lang/Throwable;

    if-nez p1, :cond_2b

    iget-object p1, p0, Lio/reactivex/internal/observers/FutureSingleObserver;->value:Ljava/lang/Object;

    return-object p1

    :cond_2b
    new-instance p2, Ljava/util/concurrent/ExecutionException;

    invoke-direct {p2, p1}, Ljava/util/concurrent/ExecutionException;-><init>(Ljava/lang/Throwable;)V

    throw p2

    :cond_31
    new-instance p1, Ljava/util/concurrent/CancellationException;

    invoke-direct {p1}, Ljava/util/concurrent/CancellationException;-><init>()V

    throw p1
.end method

.method public isCancelled()Z
    .registers 2

    iget-object v0, p0, Lio/reactivex/internal/observers/FutureSingleObserver;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lio/reactivex/disposables/Disposable;

    invoke-static {v0}, Lio/reactivex/internal/disposables/DisposableHelper;->isDisposed(Lio/reactivex/disposables/Disposable;)Z

    move-result v0

    return v0
.end method

.method public isDisposed()Z
    .registers 2

    invoke-virtual {p0}, Lio/reactivex/internal/observers/FutureSingleObserver;->isDone()Z

    move-result v0

    return v0
.end method

.method public isDone()Z
    .registers 5

    invoke-virtual {p0}, Lio/reactivex/internal/observers/FutureSingleObserver;->getCount()J

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_c

    const/4 v0, 0x1

    goto :goto_d

    :cond_c
    const/4 v0, 0x0

    :goto_d
    return v0
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 4

    :cond_0
    iget-object v0, p0, Lio/reactivex/internal/observers/FutureSingleObserver;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lio/reactivex/disposables/Disposable;

    sget-object v1, Lio/reactivex/internal/disposables/DisposableHelper;->DISPOSED:Lio/reactivex/internal/disposables/DisposableHelper;

    if-ne v0, v1, :cond_10

    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    return-void

    :cond_10
    iput-object p1, p0, Lio/reactivex/internal/observers/FutureSingleObserver;->error:Ljava/lang/Throwable;

    iget-object v1, p0, Lio/reactivex/internal/observers/FutureSingleObserver;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v1, v0, p0}, Landroidx/lifecycle/LifecycleKt$$ExternalSyntheticBackportWithForwarding0;->m(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lio/reactivex/internal/observers/FutureSingleObserver;->countDown()V

    return-void
.end method

.method public onSubscribe(Lio/reactivex/disposables/Disposable;)V
    .registers 3

    iget-object v0, p0, Lio/reactivex/internal/observers/FutureSingleObserver;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0, p1}, Lio/reactivex/internal/disposables/DisposableHelper;->setOnce(Ljava/util/concurrent/atomic/AtomicReference;Lio/reactivex/disposables/Disposable;)Z

    return-void
.end method

.method public onSuccess(Ljava/lang/Object;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    iget-object v0, p0, Lio/reactivex/internal/observers/FutureSingleObserver;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lio/reactivex/disposables/Disposable;

    sget-object v1, Lio/reactivex/internal/disposables/DisposableHelper;->DISPOSED:Lio/reactivex/internal/disposables/DisposableHelper;

    if-ne v0, v1, :cond_d

    return-void

    :cond_d
    iput-object p1, p0, Lio/reactivex/internal/observers/FutureSingleObserver;->value:Ljava/lang/Object;

    iget-object p1, p0, Lio/reactivex/internal/observers/FutureSingleObserver;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {p1, v0, p0}, Landroidx/lifecycle/LifecycleKt$$ExternalSyntheticBackportWithForwarding0;->m(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Z

    invoke-virtual {p0}, Lio/reactivex/internal/observers/FutureSingleObserver;->countDown()V

    return-void
.end method
