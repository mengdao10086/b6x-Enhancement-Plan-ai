.class final Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;
.super Lio/reactivex/internal/observers/QueueDrainObserver;
.source "ObservableBufferBoundarySupplier.java"

# interfaces
.implements Lio/reactivex/Observer;
.implements Lio/reactivex/disposables/Disposable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "BufferBoundarySupplierObserver"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        "U::",
        "Ljava/util/Collection<",
        "-TT;>;B:",
        "Ljava/lang/Object;",
        ">",
        "Lio/reactivex/internal/observers/QueueDrainObserver<",
        "TT;TU;TU;>;",
        "Lio/reactivex/Observer<",
        "TT;>;",
        "Lio/reactivex/disposables/Disposable;"
    }
.end annotation


# instance fields
.field final boundarySupplier:Ljava/util/concurrent/Callable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/Callable<",
            "+",
            "Lio/reactivex/ObservableSource<",
            "TB;>;>;"
        }
    .end annotation
.end field

.field buffer:Ljava/util/Collection;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TU;"
        }
    .end annotation
.end field

.field final bufferSupplier:Ljava/util/concurrent/Callable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/Callable<",
            "TU;>;"
        }
    .end annotation
.end field

.field final other:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference<",
            "Lio/reactivex/disposables/Disposable;",
            ">;"
        }
    .end annotation
.end field

.field upstream:Lio/reactivex/disposables/Disposable;


# direct methods
.method constructor <init>(Lio/reactivex/Observer;Ljava/util/concurrent/Callable;Ljava/util/concurrent/Callable;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/Observer<",
            "-TU;>;",
            "Ljava/util/concurrent/Callable<",
            "TU;>;",
            "Ljava/util/concurrent/Callable<",
            "+",
            "Lio/reactivex/ObservableSource<",
            "TB;>;>;)V"
        }
    .end annotation

    new-instance v0, Lio/reactivex/internal/queue/MpscLinkedQueue;

    invoke-direct {v0}, Lio/reactivex/internal/queue/MpscLinkedQueue;-><init>()V

    invoke-direct {p0, p1, v0}, Lio/reactivex/internal/observers/QueueDrainObserver;-><init>(Lio/reactivex/Observer;Lio/reactivex/internal/fuseable/SimplePlainQueue;)V

    new-instance p1, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->other:Ljava/util/concurrent/atomic/AtomicReference;

    iput-object p2, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->bufferSupplier:Ljava/util/concurrent/Callable;

    iput-object p3, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->boundarySupplier:Ljava/util/concurrent/Callable;

    return-void
.end method


# virtual methods
.method public bridge synthetic accept(Lio/reactivex/Observer;Ljava/lang/Object;)V
    .registers 3

    check-cast p2, Ljava/util/Collection;

    invoke-virtual {p0, p1, p2}, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->accept(Lio/reactivex/Observer;Ljava/util/Collection;)V

    return-void
.end method

.method public accept(Lio/reactivex/Observer;Ljava/util/Collection;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/Observer<",
            "-TU;>;TU;)V"
        }
    .end annotation

    iget-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {p1, p2}, Lio/reactivex/Observer;->onNext(Ljava/lang/Object;)V

    return-void
.end method

.method public dispose()V
    .registers 2

    iget-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->cancelled:Z

    if-nez v0, :cond_1a

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->cancelled:Z

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-interface {v0}, Lio/reactivex/disposables/Disposable;->dispose()V

    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->disposeOther()V

    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->enter()Z

    move-result v0

    if-eqz v0, :cond_1a

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    invoke-interface {v0}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->clear()V

    :cond_1a
    return-void
.end method

.method disposeOther()V
    .registers 2

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->other:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0}, Lio/reactivex/internal/disposables/DisposableHelper;->dispose(Ljava/util/concurrent/atomic/AtomicReference;)Z

    return-void
.end method

.method public isDisposed()Z
    .registers 2

    iget-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->cancelled:Z

    return v0
.end method

.method next()V
    .registers 5

    :try_start_0
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->bufferSupplier:Ljava/util/concurrent/Callable;

    invoke-interface {v0}, Ljava/util/concurrent/Callable;->call()Ljava/lang/Object;

    move-result-object v0

    const-string v1, "The buffer supplied is null"

    invoke-static {v0, v1}, Lio/reactivex/internal/functions/ObjectHelper;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Collection;
    :try_end_e
    .catchall {:try_start_0 .. :try_end_e} :catchall_51

    :try_start_e
    iget-object v1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->boundarySupplier:Ljava/util/concurrent/Callable;

    invoke-interface {v1}, Ljava/util/concurrent/Callable;->call()Ljava/lang/Object;

    move-result-object v1

    const-string v2, "The boundary ObservableSource supplied is null"

    invoke-static {v1, v2}, Lio/reactivex/internal/functions/ObjectHelper;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lio/reactivex/ObservableSource;
    :try_end_1c
    .catchall {:try_start_e .. :try_end_1c} :catchall_3f

    new-instance v2, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundaryObserver;

    invoke-direct {v2, p0}, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundaryObserver;-><init>(Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;)V

    iget-object v3, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->other:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v3, v2}, Lio/reactivex/internal/disposables/DisposableHelper;->replace(Ljava/util/concurrent/atomic/AtomicReference;Lio/reactivex/disposables/Disposable;)Z

    move-result v3

    if-eqz v3, :cond_3e

    monitor-enter p0

    :try_start_2a
    iget-object v3, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->buffer:Ljava/util/Collection;

    if-nez v3, :cond_30

    monitor-exit p0

    return-void

    :cond_30
    iput-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->buffer:Ljava/util/Collection;

    monitor-exit p0
    :try_end_33
    .catchall {:try_start_2a .. :try_end_33} :catchall_3b

    invoke-interface {v1, v2}, Lio/reactivex/ObservableSource;->subscribe(Lio/reactivex/Observer;)V

    const/4 v0, 0x0

    invoke-virtual {p0, v3, v0, p0}, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->fastPathEmit(Ljava/lang/Object;ZLio/reactivex/disposables/Disposable;)V

    goto :goto_3e

    :catchall_3b
    move-exception v0

    :try_start_3c
    monitor-exit p0
    :try_end_3d
    .catchall {:try_start_3c .. :try_end_3d} :catchall_3b

    throw v0

    :cond_3e
    :goto_3e
    return-void

    :catchall_3f
    move-exception v0

    invoke-static {v0}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    const/4 v1, 0x1

    iput-boolean v1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->cancelled:Z

    iget-object v1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-interface {v1}, Lio/reactivex/disposables/Disposable;->dispose()V

    iget-object v1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {v1, v0}, Lio/reactivex/Observer;->onError(Ljava/lang/Throwable;)V

    return-void

    :catchall_51
    move-exception v0

    invoke-static {v0}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->dispose()V

    iget-object v1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {v1, v0}, Lio/reactivex/Observer;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onComplete()V
    .registers 4

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->buffer:Ljava/util/Collection;

    if-nez v0, :cond_7

    monitor-exit p0

    return-void

    :cond_7
    const/4 v1, 0x0

    iput-object v1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->buffer:Ljava/util/Collection;

    monitor-exit p0
    :try_end_b
    .catchall {:try_start_1 .. :try_end_b} :catchall_22

    iget-object v1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    invoke-interface {v1, v0}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->offer(Ljava/lang/Object;)Z

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->done:Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->enter()Z

    move-result v0

    if-eqz v0, :cond_21

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    iget-object v1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->downstream:Lio/reactivex/Observer;

    const/4 v2, 0x0

    invoke-static {v0, v1, v2, p0, p0}, Lio/reactivex/internal/util/QueueDrainHelper;->drainLoop(Lio/reactivex/internal/fuseable/SimplePlainQueue;Lio/reactivex/Observer;ZLio/reactivex/disposables/Disposable;Lio/reactivex/internal/util/ObservableQueueDrain;)V

    :cond_21
    return-void

    :catchall_22
    move-exception v0

    :try_start_23
    monitor-exit p0
    :try_end_24
    .catchall {:try_start_23 .. :try_end_24} :catchall_22

    throw v0
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 3

    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->dispose()V

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {v0, p1}, Lio/reactivex/Observer;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->buffer:Ljava/util/Collection;

    if-nez v0, :cond_7

    monitor-exit p0

    return-void

    :cond_7
    invoke-interface {v0, p1}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    monitor-exit p0

    return-void

    :catchall_c
    move-exception p1

    monitor-exit p0
    :try_end_e
    .catchall {:try_start_1 .. :try_end_e} :catchall_c

    throw p1
.end method

.method public onSubscribe(Lio/reactivex/disposables/Disposable;)V
    .registers 6

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-static {v0, p1}, Lio/reactivex/internal/disposables/DisposableHelper;->validate(Lio/reactivex/disposables/Disposable;Lio/reactivex/disposables/Disposable;)Z

    move-result v0

    if-eqz v0, :cond_59

    iput-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->upstream:Lio/reactivex/disposables/Disposable;

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->downstream:Lio/reactivex/Observer;

    const/4 v1, 0x1

    :try_start_d
    iget-object v2, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->bufferSupplier:Ljava/util/concurrent/Callable;

    invoke-interface {v2}, Ljava/util/concurrent/Callable;->call()Ljava/lang/Object;

    move-result-object v2

    const-string v3, "The buffer supplied is null"

    invoke-static {v2, v3}, Lio/reactivex/internal/functions/ObjectHelper;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Collection;
    :try_end_1b
    .catchall {:try_start_d .. :try_end_1b} :catchall_4d

    iput-object v2, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->buffer:Ljava/util/Collection;

    :try_start_1d
    iget-object v2, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->boundarySupplier:Ljava/util/concurrent/Callable;

    invoke-interface {v2}, Ljava/util/concurrent/Callable;->call()Ljava/lang/Object;

    move-result-object v2

    const-string v3, "The boundary ObservableSource supplied is null"

    invoke-static {v2, v3}, Lio/reactivex/internal/functions/ObjectHelper;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lio/reactivex/ObservableSource;
    :try_end_2b
    .catchall {:try_start_1d .. :try_end_2b} :catchall_40

    new-instance p1, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundaryObserver;

    invoke-direct {p1, p0}, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundaryObserver;-><init>(Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;)V

    iget-object v1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->other:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v1, p1}, Ljava/util/concurrent/atomic/AtomicReference;->set(Ljava/lang/Object;)V

    invoke-interface {v0, p0}, Lio/reactivex/Observer;->onSubscribe(Lio/reactivex/disposables/Disposable;)V

    iget-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->cancelled:Z

    if-nez v0, :cond_59

    invoke-interface {v2, p1}, Lio/reactivex/ObservableSource;->subscribe(Lio/reactivex/Observer;)V

    goto :goto_59

    :catchall_40
    move-exception v2

    invoke-static {v2}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    iput-boolean v1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->cancelled:Z

    invoke-interface {p1}, Lio/reactivex/disposables/Disposable;->dispose()V

    invoke-static {v2, v0}, Lio/reactivex/internal/disposables/EmptyDisposable;->error(Ljava/lang/Throwable;Lio/reactivex/Observer;)V

    return-void

    :catchall_4d
    move-exception v2

    invoke-static {v2}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    iput-boolean v1, p0, Lio/reactivex/internal/operators/observable/ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver;->cancelled:Z

    invoke-interface {p1}, Lio/reactivex/disposables/Disposable;->dispose()V

    invoke-static {v2, v0}, Lio/reactivex/internal/disposables/EmptyDisposable;->error(Ljava/lang/Throwable;Lio/reactivex/Observer;)V

    :cond_59
    :goto_59
    return-void
.end method
