.class public final Lio/reactivex/internal/observers/FutureObserver;
.super Ljava/util/concurrent/CountDownLatch;
.source "FutureObserver.java"

# interfaces
.implements Lio/reactivex/Observer;
.implements Ljava/util/concurrent/Future;
.implements Lio/reactivex/disposables/Disposable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/util/concurrent/CountDownLatch;",
        "Lio/reactivex/Observer<",
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

    .line 43
    invoke-direct {p0, v0}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    .line 44
    new-instance v0, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    iput-object v0, p0, Lio/reactivex/internal/observers/FutureObserver;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    return-void
.end method


# virtual methods
.method public cancel(Z)Z
    .registers 4

    .line 50
    :cond_0
    iget-object p1, p0, Lio/reactivex/internal/observers/FutureObserver;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {p1}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lio/reactivex/disposables/Disposable;

    if-eq p1, p0, :cond_23

    .line 51
    sget-object v0, Lio/reactivex/internal/disposables/DisposableHelper;->DISPOSED:Lio/reactivex/internal/disposables/DisposableHelper;

    if-ne p1, v0, :cond_f

    goto :goto_23

    .line 55
    :cond_f
    iget-object v0, p0, Lio/reactivex/internal/observers/FutureObserver;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    sget-object v1, Lio/reactivex/internal/disposables/DisposableHelper;->DISPOSED:Lio/reactivex/internal/disposables/DisposableHelper;

    invoke-static {v0, p1, v1}, Landroidx/lifecycle/LifecycleKt$$ExternalSyntheticBackportWithForwarding0;->m(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    if-eqz p1, :cond_1e

    .line 57
    invoke-interface {p1}, Lio/reactivex/disposables/Disposable;->dispose()V

    .line 59
    :cond_1e
    invoke-virtual {p0}, Lio/reactivex/internal/observers/FutureObserver;->countDown()V

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

    .line 77
    invoke-virtual {p0}, Lio/reactivex/internal/observers/FutureObserver;->getCount()J

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_10

    .line 78
    invoke-static {}, Lio/reactivex/internal/util/BlockingHelper;->verifyNonBlocking()V

    .line 79
    invoke-virtual {p0}, Lio/reactivex/internal/observers/FutureObserver;->await()V

    .line 82
    :cond_10
    invoke-virtual {p0}, Lio/reactivex/internal/observers/FutureObserver;->isCancelled()Z

    move-result v0

    if-nez v0, :cond_23

    .line 85
    iget-object v0, p0, Lio/reactivex/internal/observers/FutureObserver;->error:Ljava/lang/Throwable;

    if-nez v0, :cond_1d

    .line 89
    iget-object v0, p0, Lio/reactivex/internal/observers/FutureObserver;->value:Ljava/lang/Object;

    return-object v0

    .line 87
    :cond_1d
    new-instance v1, Ljava/util/concurrent/ExecutionException;

    invoke-direct {v1, v0}, Ljava/util/concurrent/ExecutionException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    .line 83
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

    .line 94
    invoke-virtual {p0}, Lio/reactivex/internal/observers/FutureObserver;->getCount()J

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_1e

    .line 95
    invoke-static {}, Lio/reactivex/internal/util/BlockingHelper;->verifyNonBlocking()V

    .line 96
    invoke-virtual {p0, p1, p2, p3}, Lio/reactivex/internal/observers/FutureObserver;->await(JLjava/util/concurrent/TimeUnit;)Z

    move-result v0

    if-eqz v0, :cond_14

    goto :goto_1e

    .line 97
    :cond_14
    new-instance v0, Ljava/util/concurrent/TimeoutException;

    invoke-static {p1, p2, p3}, Lio/reactivex/internal/util/ExceptionHelper;->timeoutMessage(JLjava/util/concurrent/TimeUnit;)Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/util/concurrent/TimeoutException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 101
    :cond_1e
    :goto_1e
    invoke-virtual {p0}, Lio/reactivex/internal/observers/FutureObserver;->isCancelled()Z

    move-result p1

    if-nez p1, :cond_31

    .line 105
    iget-object p1, p0, Lio/reactivex/internal/observers/FutureObserver;->error:Ljava/lang/Throwable;

    if-nez p1, :cond_2b

    .line 109
    iget-object p1, p0, Lio/reactivex/internal/observers/FutureObserver;->value:Ljava/lang/Object;

    return-object p1

    .line 107
    :cond_2b
    new-instance p2, Ljava/util/concurrent/ExecutionException;

    invoke-direct {p2, p1}, Ljava/util/concurrent/ExecutionException;-><init>(Ljava/lang/Throwable;)V

    throw p2

    .line 102
    :cond_31
    new-instance p1, Ljava/util/concurrent/CancellationException;

    invoke-direct {p1}, Ljava/util/concurrent/CancellationException;-><init>()V

    throw p1
.end method

.method public isCancelled()Z
    .registers 2

    .line 67
    iget-object v0, p0, Lio/reactivex/internal/observers/FutureObserver;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lio/reactivex/disposables/Disposable;

    invoke-static {v0}, Lio/reactivex/internal/disposables/DisposableHelper;->isDisposed(Lio/reactivex/disposables/Disposable;)Z

    move-result v0

    return v0
.end method

.method public isDisposed()Z
    .registers 2

    .line 173
    invoke-virtual {p0}, Lio/reactivex/internal/observers/FutureObserver;->isDone()Z

    move-result v0

    return v0
.end method

.method public isDone()Z
    .registers 5

    .line 72
    invoke-virtual {p0}, Lio/reactivex/internal/observers/FutureObserver;->getCount()J

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

.method public onComplete()V
    .registers 3

    .line 150
    iget-object v0, p0, Lio/reactivex/internal/observers/FutureObserver;->value:Ljava/lang/Object;

    if-nez v0, :cond_f

    .line 151
    new-instance v0, Ljava/util/NoSuchElementException;

    const-string v1, "The source is empty"

    invoke-direct {v0, v1}, Ljava/util/NoSuchElementException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lio/reactivex/internal/observers/FutureObserver;->onError(Ljava/lang/Throwable;)V

    return-void

    .line 155
    :cond_f
    iget-object v0, p0, Lio/reactivex/internal/observers/FutureObserver;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lio/reactivex/disposables/Disposable;

    if-eq v0, p0, :cond_29

    .line 156
    sget-object v1, Lio/reactivex/internal/disposables/DisposableHelper;->DISPOSED:Lio/reactivex/internal/disposables/DisposableHelper;

    if-ne v0, v1, :cond_1e

    goto :goto_29

    .line 159
    :cond_1e
    iget-object v1, p0, Lio/reactivex/internal/observers/FutureObserver;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v1, v0, p0}, Landroidx/lifecycle/LifecycleKt$$ExternalSyntheticBackportWithForwarding0;->m(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_f

    .line 160
    invoke-virtual {p0}, Lio/reactivex/internal/observers/FutureObserver;->countDown()V

    :cond_29
    :goto_29
    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 4

    .line 129
    iget-object v0, p0, Lio/reactivex/internal/observers/FutureObserver;->error:Ljava/lang/Throwable;

    if-nez v0, :cond_25

    .line 130
    iput-object p1, p0, Lio/reactivex/internal/observers/FutureObserver;->error:Ljava/lang/Throwable;

    .line 133
    :cond_6
    iget-object v0, p0, Lio/reactivex/internal/observers/FutureObserver;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lio/reactivex/disposables/Disposable;

    if-eq v0, p0, :cond_21

    .line 134
    sget-object v1, Lio/reactivex/internal/disposables/DisposableHelper;->DISPOSED:Lio/reactivex/internal/disposables/DisposableHelper;

    if-ne v0, v1, :cond_15

    goto :goto_21

    .line 138
    :cond_15
    iget-object v1, p0, Lio/reactivex/internal/observers/FutureObserver;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v1, v0, p0}, Landroidx/lifecycle/LifecycleKt$$ExternalSyntheticBackportWithForwarding0;->m(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 139
    invoke-virtual {p0}, Lio/reactivex/internal/observers/FutureObserver;->countDown()V

    return-void

    .line 135
    :cond_21
    :goto_21
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    return-void

    .line 144
    :cond_25
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 119
    iget-object v0, p0, Lio/reactivex/internal/observers/FutureObserver;->value:Ljava/lang/Object;

    if-eqz v0, :cond_1a

    .line 120
    iget-object p1, p0, Lio/reactivex/internal/observers/FutureObserver;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {p1}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lio/reactivex/disposables/Disposable;

    invoke-interface {p1}, Lio/reactivex/disposables/Disposable;->dispose()V

    .line 121
    new-instance p1, Ljava/lang/IndexOutOfBoundsException;

    const-string v0, "More than one element received"

    invoke-direct {p1, v0}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, p1}, Lio/reactivex/internal/observers/FutureObserver;->onError(Ljava/lang/Throwable;)V

    return-void

    .line 124
    :cond_1a
    iput-object p1, p0, Lio/reactivex/internal/observers/FutureObserver;->value:Ljava/lang/Object;

    return-void
.end method

.method public onSubscribe(Lio/reactivex/disposables/Disposable;)V
    .registers 3

    .line 114
    iget-object v0, p0, Lio/reactivex/internal/observers/FutureObserver;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0, p1}, Lio/reactivex/internal/disposables/DisposableHelper;->setOnce(Ljava/util/concurrent/atomic/AtomicReference;Lio/reactivex/disposables/Disposable;)Z

    return-void
.end method
