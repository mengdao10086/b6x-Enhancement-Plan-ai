.class public final Lio/reactivex/observers/SerializedObserver;
.super Ljava/lang/Object;
.source "SerializedObserver.java"

# interfaces
.implements Lio/reactivex/Observer;
.implements Lio/reactivex/disposables/Disposable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lio/reactivex/Observer<",
        "TT;>;",
        "Lio/reactivex/disposables/Disposable;"
    }
.end annotation


# static fields
.field static final QUEUE_LINK_SIZE:I = 0x4


# instance fields
.field final delayError:Z

.field volatile done:Z

.field final downstream:Lio/reactivex/Observer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/Observer<",
            "-TT;>;"
        }
    .end annotation
.end field

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

.field upstream:Lio/reactivex/disposables/Disposable;


# direct methods
.method public constructor <init>(Lio/reactivex/Observer;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/Observer<",
            "-TT;>;)V"
        }
    .end annotation

    const/4 v0, 0x0

    .line 51
    invoke-direct {p0, p1, v0}, Lio/reactivex/observers/SerializedObserver;-><init>(Lio/reactivex/Observer;Z)V

    return-void
.end method

.method public constructor <init>(Lio/reactivex/Observer;Z)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/Observer<",
            "-TT;>;Z)V"
        }
    .end annotation

    .line 61
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 62
    iput-object p1, p0, Lio/reactivex/observers/SerializedObserver;->downstream:Lio/reactivex/Observer;

    .line 63
    iput-boolean p2, p0, Lio/reactivex/observers/SerializedObserver;->delayError:Z

    return-void
.end method


# virtual methods
.method public dispose()V
    .registers 2

    .line 77
    iget-object v0, p0, Lio/reactivex/observers/SerializedObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-interface {v0}, Lio/reactivex/disposables/Disposable;->dispose()V

    return-void
.end method

.method emitLoop()V
    .registers 3

    .line 186
    :cond_0
    monitor-enter p0

    .line 187
    :try_start_1
    iget-object v0, p0, Lio/reactivex/observers/SerializedObserver;->queue:Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;

    if-nez v0, :cond_a

    const/4 v0, 0x0

    .line 189
    iput-boolean v0, p0, Lio/reactivex/observers/SerializedObserver;->emitting:Z

    .line 190
    monitor-exit p0

    return-void

    :cond_a
    const/4 v1, 0x0

    .line 192
    iput-object v1, p0, Lio/reactivex/observers/SerializedObserver;->queue:Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;

    .line 193
    monitor-exit p0
    :try_end_e
    .catchall {:try_start_1 .. :try_end_e} :catchall_17

    .line 195
    iget-object v1, p0, Lio/reactivex/observers/SerializedObserver;->downstream:Lio/reactivex/Observer;

    invoke-virtual {v0, v1}, Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;->accept(Lio/reactivex/Observer;)Z

    move-result v0

    if-eqz v0, :cond_0

    return-void

    :catchall_17
    move-exception v0

    .line 193
    :try_start_18
    monitor-exit p0
    :try_end_19
    .catchall {:try_start_18 .. :try_end_19} :catchall_17

    throw v0
.end method

.method public isDisposed()Z
    .registers 2

    .line 82
    iget-object v0, p0, Lio/reactivex/observers/SerializedObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-interface {v0}, Lio/reactivex/disposables/Disposable;->isDisposed()Z

    move-result v0

    return v0
.end method

.method public onComplete()V
    .registers 3

    .line 159
    iget-boolean v0, p0, Lio/reactivex/observers/SerializedObserver;->done:Z

    if-eqz v0, :cond_5

    return-void

    .line 162
    :cond_5
    monitor-enter p0

    .line 163
    :try_start_6
    iget-boolean v0, p0, Lio/reactivex/observers/SerializedObserver;->done:Z

    if-eqz v0, :cond_c

    .line 164
    monitor-exit p0

    return-void

    .line 166
    :cond_c
    iget-boolean v0, p0, Lio/reactivex/observers/SerializedObserver;->emitting:Z

    if-eqz v0, :cond_25

    .line 167
    iget-object v0, p0, Lio/reactivex/observers/SerializedObserver;->queue:Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;

    if-nez v0, :cond_1c

    .line 169
    new-instance v0, Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;

    const/4 v1, 0x4

    invoke-direct {v0, v1}, Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;-><init>(I)V

    .line 170
    iput-object v0, p0, Lio/reactivex/observers/SerializedObserver;->queue:Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;

    .line 172
    :cond_1c
    invoke-static {}, Lio/reactivex/internal/util/NotificationLite;->complete()Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;->add(Ljava/lang/Object;)V

    .line 173
    monitor-exit p0

    return-void

    :cond_25
    const/4 v0, 0x1

    .line 175
    iput-boolean v0, p0, Lio/reactivex/observers/SerializedObserver;->done:Z

    .line 176
    iput-boolean v0, p0, Lio/reactivex/observers/SerializedObserver;->emitting:Z

    .line 177
    monitor-exit p0
    :try_end_2b
    .catchall {:try_start_6 .. :try_end_2b} :catchall_31

    .line 179
    iget-object v0, p0, Lio/reactivex/observers/SerializedObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {v0}, Lio/reactivex/Observer;->onComplete()V

    return-void

    :catchall_31
    move-exception v0

    .line 177
    :try_start_32
    monitor-exit p0
    :try_end_33
    .catchall {:try_start_32 .. :try_end_33} :catchall_31

    throw v0
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 4

    .line 118
    iget-boolean v0, p0, Lio/reactivex/observers/SerializedObserver;->done:Z

    if-eqz v0, :cond_8

    .line 119
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    return-void

    .line 123
    :cond_8
    monitor-enter p0

    .line 124
    :try_start_9
    iget-boolean v0, p0, Lio/reactivex/observers/SerializedObserver;->done:Z

    const/4 v1, 0x1

    if-eqz v0, :cond_f

    goto :goto_37

    .line 127
    :cond_f
    iget-boolean v0, p0, Lio/reactivex/observers/SerializedObserver;->emitting:Z

    if-eqz v0, :cond_32

    .line 128
    iput-boolean v1, p0, Lio/reactivex/observers/SerializedObserver;->done:Z

    .line 129
    iget-object v0, p0, Lio/reactivex/observers/SerializedObserver;->queue:Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;

    if-nez v0, :cond_21

    .line 131
    new-instance v0, Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;

    const/4 v1, 0x4

    invoke-direct {v0, v1}, Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;-><init>(I)V

    .line 132
    iput-object v0, p0, Lio/reactivex/observers/SerializedObserver;->queue:Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;

    .line 134
    :cond_21
    invoke-static {p1}, Lio/reactivex/internal/util/NotificationLite;->error(Ljava/lang/Throwable;)Ljava/lang/Object;

    move-result-object p1

    .line 135
    iget-boolean v1, p0, Lio/reactivex/observers/SerializedObserver;->delayError:Z

    if-eqz v1, :cond_2d

    .line 136
    invoke-virtual {v0, p1}, Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;->add(Ljava/lang/Object;)V

    goto :goto_30

    .line 138
    :cond_2d
    invoke-virtual {v0, p1}, Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;->setFirst(Ljava/lang/Object;)V

    .line 140
    :goto_30
    monitor-exit p0

    return-void

    .line 142
    :cond_32
    iput-boolean v1, p0, Lio/reactivex/observers/SerializedObserver;->done:Z

    .line 143
    iput-boolean v1, p0, Lio/reactivex/observers/SerializedObserver;->emitting:Z

    const/4 v1, 0x0

    .line 146
    :goto_37
    monitor-exit p0
    :try_end_38
    .catchall {:try_start_9 .. :try_end_38} :catchall_44

    if-eqz v1, :cond_3e

    .line 149
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    return-void

    .line 153
    :cond_3e
    iget-object v0, p0, Lio/reactivex/observers/SerializedObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {v0, p1}, Lio/reactivex/Observer;->onError(Ljava/lang/Throwable;)V

    return-void

    :catchall_44
    move-exception p1

    .line 146
    :try_start_45
    monitor-exit p0
    :try_end_46
    .catchall {:try_start_45 .. :try_end_46} :catchall_44

    throw p1
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 87
    iget-boolean v0, p0, Lio/reactivex/observers/SerializedObserver;->done:Z

    if-eqz v0, :cond_5

    return-void

    :cond_5
    if-nez p1, :cond_17

    .line 91
    iget-object p1, p0, Lio/reactivex/observers/SerializedObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-interface {p1}, Lio/reactivex/disposables/Disposable;->dispose()V

    .line 92
    new-instance p1, Ljava/lang/NullPointerException;

    const-string v0, "onNext called with null. Null values are generally not allowed in 2.x operators and sources."

    invoke-direct {p1, v0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, p1}, Lio/reactivex/observers/SerializedObserver;->onError(Ljava/lang/Throwable;)V

    return-void

    .line 95
    :cond_17
    monitor-enter p0

    .line 96
    :try_start_18
    iget-boolean v0, p0, Lio/reactivex/observers/SerializedObserver;->done:Z

    if-eqz v0, :cond_1e

    .line 97
    monitor-exit p0

    return-void

    .line 99
    :cond_1e
    iget-boolean v0, p0, Lio/reactivex/observers/SerializedObserver;->emitting:Z

    if-eqz v0, :cond_37

    .line 100
    iget-object v0, p0, Lio/reactivex/observers/SerializedObserver;->queue:Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;

    if-nez v0, :cond_2e

    .line 102
    new-instance v0, Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;

    const/4 v1, 0x4

    invoke-direct {v0, v1}, Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;-><init>(I)V

    .line 103
    iput-object v0, p0, Lio/reactivex/observers/SerializedObserver;->queue:Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;

    .line 105
    :cond_2e
    invoke-static {p1}, Lio/reactivex/internal/util/NotificationLite;->next(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    invoke-virtual {v0, p1}, Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;->add(Ljava/lang/Object;)V

    .line 106
    monitor-exit p0

    return-void

    :cond_37
    const/4 v0, 0x1

    .line 108
    iput-boolean v0, p0, Lio/reactivex/observers/SerializedObserver;->emitting:Z

    .line 109
    monitor-exit p0
    :try_end_3b
    .catchall {:try_start_18 .. :try_end_3b} :catchall_44

    .line 111
    iget-object v0, p0, Lio/reactivex/observers/SerializedObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {v0, p1}, Lio/reactivex/Observer;->onNext(Ljava/lang/Object;)V

    .line 113
    invoke-virtual {p0}, Lio/reactivex/observers/SerializedObserver;->emitLoop()V

    return-void

    :catchall_44
    move-exception p1

    .line 109
    :try_start_45
    monitor-exit p0
    :try_end_46
    .catchall {:try_start_45 .. :try_end_46} :catchall_44

    throw p1
.end method

.method public onSubscribe(Lio/reactivex/disposables/Disposable;)V
    .registers 3

    .line 68
    iget-object v0, p0, Lio/reactivex/observers/SerializedObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-static {v0, p1}, Lio/reactivex/internal/disposables/DisposableHelper;->validate(Lio/reactivex/disposables/Disposable;Lio/reactivex/disposables/Disposable;)Z

    move-result v0

    if-eqz v0, :cond_f

    .line 69
    iput-object p1, p0, Lio/reactivex/observers/SerializedObserver;->upstream:Lio/reactivex/disposables/Disposable;

    .line 71
    iget-object p1, p0, Lio/reactivex/observers/SerializedObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {p1, p0}, Lio/reactivex/Observer;->onSubscribe(Lio/reactivex/disposables/Disposable;)V

    :cond_f
    return-void
.end method
