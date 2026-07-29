.class final Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;
.super Ljava/util/concurrent/atomic/AtomicInteger;
.source "FlowableCreate.java"

# interfaces
.implements Lio/reactivex/FlowableEmitter;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/flowable/FlowableCreate;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "SerializedEmitter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/util/concurrent/atomic/AtomicInteger;",
        "Lio/reactivex/FlowableEmitter<",
        "TT;>;"
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = 0x43c4fdd95fbcd5c6L


# instance fields
.field volatile done:Z

.field final emitter:Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter<",
            "TT;>;"
        }
    .end annotation
.end field

.field final error:Lio/reactivex/internal/util/AtomicThrowable;

.field final queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/internal/fuseable/SimplePlainQueue<",
            "TT;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter<",
            "TT;>;)V"
        }
    .end annotation

    .line 97
    invoke-direct {p0}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    .line 98
    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->emitter:Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter;

    .line 99
    new-instance p1, Lio/reactivex/internal/util/AtomicThrowable;

    invoke-direct {p1}, Lio/reactivex/internal/util/AtomicThrowable;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->error:Lio/reactivex/internal/util/AtomicThrowable;

    .line 100
    new-instance p1, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    const/16 v0, 0x10

    invoke-direct {p1, v0}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;-><init>(I)V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    return-void
.end method


# virtual methods
.method drain()V
    .registers 2

    .line 162
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->getAndIncrement()I

    move-result v0

    if-nez v0, :cond_9

    .line 163
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->drainLoop()V

    :cond_9
    return-void
.end method

.method drainLoop()V
    .registers 9

    .line 168
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->emitter:Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter;

    .line 169
    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    .line 170
    iget-object v2, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->error:Lio/reactivex/internal/util/AtomicThrowable;

    const/4 v3, 0x1

    move v4, v3

    .line 175
    :cond_8
    :goto_8
    invoke-virtual {v0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter;->isCancelled()Z

    move-result v5

    if-eqz v5, :cond_12

    .line 176
    invoke-interface {v1}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->clear()V

    return-void

    .line 180
    :cond_12
    invoke-virtual {v2}, Lio/reactivex/internal/util/AtomicThrowable;->get()Ljava/lang/Object;

    move-result-object v5

    if-eqz v5, :cond_23

    .line 181
    invoke-interface {v1}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->clear()V

    .line 182
    invoke-virtual {v2}, Lio/reactivex/internal/util/AtomicThrowable;->terminate()Ljava/lang/Throwable;

    move-result-object v1

    invoke-virtual {v0, v1}, Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter;->onError(Ljava/lang/Throwable;)V

    return-void

    .line 186
    :cond_23
    iget-boolean v5, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->done:Z

    .line 188
    invoke-interface {v1}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->poll()Ljava/lang/Object;

    move-result-object v6

    if-nez v6, :cond_2d

    move v7, v3

    goto :goto_2e

    :cond_2d
    const/4 v7, 0x0

    :goto_2e
    if-eqz v5, :cond_36

    if-eqz v7, :cond_36

    .line 193
    invoke-virtual {v0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter;->onComplete()V

    return-void

    :cond_36
    if-eqz v7, :cond_40

    neg-int v4, v4

    .line 204
    invoke-virtual {p0, v4}, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->addAndGet(I)I

    move-result v4

    if-nez v4, :cond_8

    return-void

    .line 201
    :cond_40
    invoke-virtual {v0, v6}, Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter;->onNext(Ljava/lang/Object;)V

    goto :goto_8
.end method

.method public isCancelled()Z
    .registers 2

    .line 228
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->emitter:Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter;

    invoke-virtual {v0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter;->isCancelled()Z

    move-result v0

    return v0
.end method

.method public onComplete()V
    .registers 2

    .line 154
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->emitter:Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter;

    invoke-virtual {v0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter;->isCancelled()Z

    move-result v0

    if-nez v0, :cond_13

    iget-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->done:Z

    if-eqz v0, :cond_d

    goto :goto_13

    :cond_d
    const/4 v0, 0x1

    .line 157
    iput-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->done:Z

    .line 158
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->drain()V

    :cond_13
    :goto_13
    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 3

    .line 131
    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->tryOnError(Ljava/lang/Throwable;)Z

    move-result v0

    if-nez v0, :cond_9

    .line 132
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :cond_9
    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 105
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->emitter:Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter;

    invoke-virtual {v0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter;->isCancelled()Z

    move-result v0

    if-nez v0, :cond_49

    iget-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->done:Z

    if-eqz v0, :cond_d

    goto :goto_49

    :cond_d
    if-nez p1, :cond_1a

    .line 109
    new-instance p1, Ljava/lang/NullPointerException;

    const-string v0, "onNext called with null. Null values are generally not allowed in 2.x operators and sources."

    invoke-direct {p1, v0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->onError(Ljava/lang/Throwable;)V

    return-void

    .line 112
    :cond_1a
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->get()I

    move-result v0

    if-nez v0, :cond_34

    const/4 v0, 0x0

    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->compareAndSet(II)Z

    move-result v0

    if-eqz v0, :cond_34

    .line 113
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->emitter:Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter;

    invoke-virtual {v0, p1}, Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter;->onNext(Ljava/lang/Object;)V

    .line 114
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->decrementAndGet()I

    move-result p1

    if-nez p1, :cond_42

    return-void

    .line 118
    :cond_34
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    .line 119
    monitor-enter v0

    .line 120
    :try_start_37
    invoke-interface {v0, p1}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->offer(Ljava/lang/Object;)Z

    .line 121
    monitor-exit v0
    :try_end_3b
    .catchall {:try_start_37 .. :try_end_3b} :catchall_46

    .line 122
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->getAndIncrement()I

    move-result p1

    if-eqz p1, :cond_42

    return-void

    .line 126
    :cond_42
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->drainLoop()V

    return-void

    :catchall_46
    move-exception p1

    .line 121
    :try_start_47
    monitor-exit v0
    :try_end_48
    .catchall {:try_start_47 .. :try_end_48} :catchall_46

    throw p1

    :cond_49
    :goto_49
    return-void
.end method

.method public requested()J
    .registers 3

    .line 223
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->emitter:Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter;

    invoke-virtual {v0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter;->requested()J

    move-result-wide v0

    return-wide v0
.end method

.method public serialize()Lio/reactivex/FlowableEmitter;
    .registers 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lio/reactivex/FlowableEmitter<",
            "TT;>;"
        }
    .end annotation

    return-object p0
.end method

.method public setCancellable(Lio/reactivex/functions/Cancellable;)V
    .registers 3

    .line 218
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->emitter:Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter;

    invoke-virtual {v0, p1}, Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter;->setCancellable(Lio/reactivex/functions/Cancellable;)V

    return-void
.end method

.method public setDisposable(Lio/reactivex/disposables/Disposable;)V
    .registers 3

    .line 213
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->emitter:Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter;

    invoke-virtual {v0, p1}, Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter;->setDisposable(Lio/reactivex/disposables/Disposable;)V

    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 2

    .line 238
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->emitter:Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter;

    invoke-virtual {v0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public tryOnError(Ljava/lang/Throwable;)Z
    .registers 4

    .line 138
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->emitter:Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter;

    invoke-virtual {v0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$BaseEmitter;->isCancelled()Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_26

    iget-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->done:Z

    if-eqz v0, :cond_e

    goto :goto_26

    :cond_e
    if-nez p1, :cond_17

    .line 142
    new-instance p1, Ljava/lang/NullPointerException;

    const-string v0, "onError called with null. Null values are generally not allowed in 2.x operators and sources."

    invoke-direct {p1, v0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    .line 144
    :cond_17
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->error:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v0, p1}, Lio/reactivex/internal/util/AtomicThrowable;->addThrowable(Ljava/lang/Throwable;)Z

    move-result p1

    if-eqz p1, :cond_26

    const/4 p1, 0x1

    .line 145
    iput-boolean p1, p0, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->done:Z

    .line 146
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableCreate$SerializedEmitter;->drain()V

    return p1

    :cond_26
    :goto_26
    return v1
.end method
