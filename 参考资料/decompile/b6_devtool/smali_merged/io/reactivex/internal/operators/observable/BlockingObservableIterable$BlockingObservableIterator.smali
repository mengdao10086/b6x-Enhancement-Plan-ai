.class final Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;
.super Ljava/util/concurrent/atomic/AtomicReference;
.source "BlockingObservableIterable.java"

# interfaces
.implements Lio/reactivex/Observer;
.implements Ljava/util/Iterator;
.implements Lio/reactivex/disposables/Disposable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/observable/BlockingObservableIterable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "BlockingObservableIterator"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/util/concurrent/atomic/AtomicReference<",
        "Lio/reactivex/disposables/Disposable;",
        ">;",
        "Lio/reactivex/Observer<",
        "TT;>;",
        "Ljava/util/Iterator<",
        "TT;>;",
        "Lio/reactivex/disposables/Disposable;"
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = 0x5cea3901b29dcb72L


# instance fields
.field final condition:Ljava/util/concurrent/locks/Condition;

.field volatile done:Z

.field volatile error:Ljava/lang/Throwable;

.field final lock:Ljava/util/concurrent/locks/Lock;

.field final queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/internal/queue/SpscLinkedArrayQueue<",
            "TT;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(I)V
    .registers 3

    .line 58
    invoke-direct {p0}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    .line 59
    new-instance v0, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    invoke-direct {v0, p1}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;-><init>(I)V

    iput-object v0, p0, Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    .line 60
    new-instance p1, Ljava/util/concurrent/locks/ReentrantLock;

    invoke-direct {p1}, Ljava/util/concurrent/locks/ReentrantLock;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;->lock:Ljava/util/concurrent/locks/Lock;

    .line 61
    invoke-interface {p1}, Ljava/util/concurrent/locks/Lock;->newCondition()Ljava/util/concurrent/locks/Condition;

    move-result-object p1

    iput-object p1, p0, Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;->condition:Ljava/util/concurrent/locks/Condition;

    return-void
.end method


# virtual methods
.method public dispose()V
    .registers 1

    .line 155
    invoke-static {p0}, Lio/reactivex/internal/disposables/DisposableHelper;->dispose(Ljava/util/concurrent/atomic/AtomicReference;)Z

    .line 156
    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;->signalConsumer()V

    return-void
.end method

.method public hasNext()Z
    .registers 4

    .line 67
    :goto_0
    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;->isDisposed()Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_11

    .line 68
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;->error:Ljava/lang/Throwable;

    if-nez v0, :cond_c

    return v1

    .line 70
    :cond_c
    invoke-static {v0}, Lio/reactivex/internal/util/ExceptionHelper;->wrapOrThrow(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0

    .line 74
    :cond_11
    iget-boolean v0, p0, Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;->done:Z

    .line 75
    iget-object v2, p0, Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    invoke-virtual {v2}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->isEmpty()Z

    move-result v2

    if-eqz v0, :cond_27

    .line 77
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;->error:Ljava/lang/Throwable;

    if-nez v0, :cond_22

    if-eqz v2, :cond_27

    return v1

    .line 79
    :cond_22
    invoke-static {v0}, Lio/reactivex/internal/util/ExceptionHelper;->wrapOrThrow(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0

    :cond_27
    if-eqz v2, :cond_62

    .line 87
    :try_start_29
    invoke-static {}, Lio/reactivex/internal/util/BlockingHelper;->verifyNonBlocking()V

    .line 88
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V
    :try_end_31
    .catch Ljava/lang/InterruptedException; {:try_start_29 .. :try_end_31} :catch_56

    .line 90
    :goto_31
    :try_start_31
    iget-boolean v0, p0, Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;->done:Z

    if-nez v0, :cond_49

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    invoke-virtual {v0}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_49

    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;->isDisposed()Z

    move-result v0

    if-nez v0, :cond_49

    .line 91
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;->condition:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Condition;->await()V
    :try_end_48
    .catchall {:try_start_31 .. :try_end_48} :catchall_4f

    goto :goto_31

    .line 94
    :cond_49
    :try_start_49
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    goto :goto_0

    :catchall_4f
    move-exception v0

    iget-object v1, p0, Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    .line 95
    throw v0
    :try_end_56
    .catch Ljava/lang/InterruptedException; {:try_start_49 .. :try_end_56} :catch_56

    :catch_56
    move-exception v0

    .line 97
    invoke-static {p0}, Lio/reactivex/internal/disposables/DisposableHelper;->dispose(Ljava/util/concurrent/atomic/AtomicReference;)Z

    .line 98
    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;->signalConsumer()V

    .line 99
    invoke-static {v0}, Lio/reactivex/internal/util/ExceptionHelper;->wrapOrThrow(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0

    :cond_62
    const/4 v0, 0x1

    return v0
.end method

.method public isDisposed()Z
    .registers 2

    .line 161
    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lio/reactivex/disposables/Disposable;

    invoke-static {v0}, Lio/reactivex/internal/disposables/DisposableHelper;->isDisposed(Lio/reactivex/disposables/Disposable;)Z

    move-result v0

    return v0
.end method

.method public next()Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .line 109
    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_d

    .line 110
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    invoke-virtual {v0}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->poll()Ljava/lang/Object;

    move-result-object v0

    return-object v0

    .line 112
    :cond_d
    new-instance v0, Ljava/util/NoSuchElementException;

    invoke-direct {v0}, Ljava/util/NoSuchElementException;-><init>()V

    throw v0
.end method

.method public onComplete()V
    .registers 2

    const/4 v0, 0x1

    .line 135
    iput-boolean v0, p0, Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;->done:Z

    .line 136
    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;->signalConsumer()V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 2

    .line 128
    iput-object p1, p0, Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;->error:Ljava/lang/Throwable;

    const/4 p1, 0x1

    .line 129
    iput-boolean p1, p0, Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;->done:Z

    .line 130
    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;->signalConsumer()V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 122
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    invoke-virtual {v0, p1}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->offer(Ljava/lang/Object;)Z

    .line 123
    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;->signalConsumer()V

    return-void
.end method

.method public onSubscribe(Lio/reactivex/disposables/Disposable;)V
    .registers 2

    .line 117
    invoke-static {p0, p1}, Lio/reactivex/internal/disposables/DisposableHelper;->setOnce(Ljava/util/concurrent/atomic/AtomicReference;Lio/reactivex/disposables/Disposable;)Z

    return-void
.end method

.method public remove()V
    .registers 3

    .line 150
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "remove"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method signalConsumer()V
    .registers 3

    .line 140
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 142
    :try_start_5
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;->condition:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Condition;->signalAll()V
    :try_end_a
    .catchall {:try_start_5 .. :try_end_a} :catchall_10

    .line 144
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    return-void

    :catchall_10
    move-exception v0

    iget-object v1, p0, Lio/reactivex/internal/operators/observable/BlockingObservableIterable$BlockingObservableIterator;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    .line 145
    throw v0
.end method
