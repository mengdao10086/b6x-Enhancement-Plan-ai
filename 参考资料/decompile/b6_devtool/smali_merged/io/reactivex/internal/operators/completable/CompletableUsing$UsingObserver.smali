.class final Lio/reactivex/internal/operators/completable/CompletableUsing$UsingObserver;
.super Ljava/util/concurrent/atomic/AtomicReference;
.source "CompletableUsing.java"

# interfaces
.implements Lio/reactivex/CompletableObserver;
.implements Lio/reactivex/disposables/Disposable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/completable/CompletableUsing;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "UsingObserver"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<R:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/util/concurrent/atomic/AtomicReference<",
        "Ljava/lang/Object;",
        ">;",
        "Lio/reactivex/CompletableObserver;",
        "Lio/reactivex/disposables/Disposable;"
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = -0x95bf75d78cfb0efL


# instance fields
.field final disposer:Lio/reactivex/functions/Consumer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/functions/Consumer<",
            "-TR;>;"
        }
    .end annotation
.end field

.field final downstream:Lio/reactivex/CompletableObserver;

.field final eager:Z

.field upstream:Lio/reactivex/disposables/Disposable;


# direct methods
.method constructor <init>(Lio/reactivex/CompletableObserver;Ljava/lang/Object;Lio/reactivex/functions/Consumer;Z)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/CompletableObserver;",
            "TR;",
            "Lio/reactivex/functions/Consumer<",
            "-TR;>;Z)V"
        }
    .end annotation

    .line 102
    invoke-direct {p0, p2}, Ljava/util/concurrent/atomic/AtomicReference;-><init>(Ljava/lang/Object;)V

    .line 103
    iput-object p1, p0, Lio/reactivex/internal/operators/completable/CompletableUsing$UsingObserver;->downstream:Lio/reactivex/CompletableObserver;

    .line 104
    iput-object p3, p0, Lio/reactivex/internal/operators/completable/CompletableUsing$UsingObserver;->disposer:Lio/reactivex/functions/Consumer;

    .line 105
    iput-boolean p4, p0, Lio/reactivex/internal/operators/completable/CompletableUsing$UsingObserver;->eager:Z

    return-void
.end method


# virtual methods
.method public dispose()V
    .registers 2

    .line 110
    iget-object v0, p0, Lio/reactivex/internal/operators/completable/CompletableUsing$UsingObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-interface {v0}, Lio/reactivex/disposables/Disposable;->dispose()V

    .line 111
    sget-object v0, Lio/reactivex/internal/disposables/DisposableHelper;->DISPOSED:Lio/reactivex/internal/disposables/DisposableHelper;

    iput-object v0, p0, Lio/reactivex/internal/operators/completable/CompletableUsing$UsingObserver;->upstream:Lio/reactivex/disposables/Disposable;

    .line 112
    invoke-virtual {p0}, Lio/reactivex/internal/operators/completable/CompletableUsing$UsingObserver;->disposeResourceAfter()V

    return-void
.end method

.method disposeResourceAfter()V
    .registers 3

    .line 117
    invoke-virtual {p0, p0}, Lio/reactivex/internal/operators/completable/CompletableUsing$UsingObserver;->getAndSet(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eq v0, p0, :cond_13

    .line 120
    :try_start_6
    iget-object v1, p0, Lio/reactivex/internal/operators/completable/CompletableUsing$UsingObserver;->disposer:Lio/reactivex/functions/Consumer;

    invoke-interface {v1, v0}, Lio/reactivex/functions/Consumer;->accept(Ljava/lang/Object;)V
    :try_end_b
    .catchall {:try_start_6 .. :try_end_b} :catchall_c

    goto :goto_13

    :catchall_c
    move-exception v0

    .line 122
    invoke-static {v0}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 123
    invoke-static {v0}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :cond_13
    :goto_13
    return-void
.end method

.method public isDisposed()Z
    .registers 2

    .line 130
    iget-object v0, p0, Lio/reactivex/internal/operators/completable/CompletableUsing$UsingObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-interface {v0}, Lio/reactivex/disposables/Disposable;->isDisposed()Z

    move-result v0

    return v0
.end method

.method public onComplete()V
    .registers 3

    .line 170
    sget-object v0, Lio/reactivex/internal/disposables/DisposableHelper;->DISPOSED:Lio/reactivex/internal/disposables/DisposableHelper;

    iput-object v0, p0, Lio/reactivex/internal/operators/completable/CompletableUsing$UsingObserver;->upstream:Lio/reactivex/disposables/Disposable;

    .line 171
    iget-boolean v0, p0, Lio/reactivex/internal/operators/completable/CompletableUsing$UsingObserver;->eager:Z

    if-eqz v0, :cond_1e

    .line 172
    invoke-virtual {p0, p0}, Lio/reactivex/internal/operators/completable/CompletableUsing$UsingObserver;->getAndSet(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eq v0, p0, :cond_1d

    .line 175
    :try_start_e
    iget-object v1, p0, Lio/reactivex/internal/operators/completable/CompletableUsing$UsingObserver;->disposer:Lio/reactivex/functions/Consumer;

    invoke-interface {v1, v0}, Lio/reactivex/functions/Consumer;->accept(Ljava/lang/Object;)V
    :try_end_13
    .catchall {:try_start_e .. :try_end_13} :catchall_14

    goto :goto_1e

    :catchall_14
    move-exception v0

    .line 177
    invoke-static {v0}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 178
    iget-object v1, p0, Lio/reactivex/internal/operators/completable/CompletableUsing$UsingObserver;->downstream:Lio/reactivex/CompletableObserver;

    invoke-interface {v1, v0}, Lio/reactivex/CompletableObserver;->onError(Ljava/lang/Throwable;)V

    :cond_1d
    return-void

    .line 186
    :cond_1e
    :goto_1e
    iget-object v0, p0, Lio/reactivex/internal/operators/completable/CompletableUsing$UsingObserver;->downstream:Lio/reactivex/CompletableObserver;

    invoke-interface {v0}, Lio/reactivex/CompletableObserver;->onComplete()V

    .line 188
    iget-boolean v0, p0, Lio/reactivex/internal/operators/completable/CompletableUsing$UsingObserver;->eager:Z

    if-nez v0, :cond_2a

    .line 189
    invoke-virtual {p0}, Lio/reactivex/internal/operators/completable/CompletableUsing$UsingObserver;->disposeResourceAfter()V

    :cond_2a
    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 6

    .line 145
    sget-object v0, Lio/reactivex/internal/disposables/DisposableHelper;->DISPOSED:Lio/reactivex/internal/disposables/DisposableHelper;

    iput-object v0, p0, Lio/reactivex/internal/operators/completable/CompletableUsing$UsingObserver;->upstream:Lio/reactivex/disposables/Disposable;

    .line 146
    iget-boolean v0, p0, Lio/reactivex/internal/operators/completable/CompletableUsing$UsingObserver;->eager:Z

    if-eqz v0, :cond_29

    .line 147
    invoke-virtual {p0, p0}, Lio/reactivex/internal/operators/completable/CompletableUsing$UsingObserver;->getAndSet(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eq v0, p0, :cond_28

    .line 150
    :try_start_e
    iget-object v1, p0, Lio/reactivex/internal/operators/completable/CompletableUsing$UsingObserver;->disposer:Lio/reactivex/functions/Consumer;

    invoke-interface {v1, v0}, Lio/reactivex/functions/Consumer;->accept(Ljava/lang/Object;)V
    :try_end_13
    .catchall {:try_start_e .. :try_end_13} :catchall_14

    goto :goto_29

    :catchall_14
    move-exception v0

    .line 152
    invoke-static {v0}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 153
    new-instance v1, Lio/reactivex/exceptions/CompositeException;

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Throwable;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    const/4 p1, 0x1

    aput-object v0, v2, p1

    invoke-direct {v1, v2}, Lio/reactivex/exceptions/CompositeException;-><init>([Ljava/lang/Throwable;)V

    move-object p1, v1

    goto :goto_29

    :cond_28
    return-void

    .line 160
    :cond_29
    :goto_29
    iget-object v0, p0, Lio/reactivex/internal/operators/completable/CompletableUsing$UsingObserver;->downstream:Lio/reactivex/CompletableObserver;

    invoke-interface {v0, p1}, Lio/reactivex/CompletableObserver;->onError(Ljava/lang/Throwable;)V

    .line 162
    iget-boolean p1, p0, Lio/reactivex/internal/operators/completable/CompletableUsing$UsingObserver;->eager:Z

    if-nez p1, :cond_35

    .line 163
    invoke-virtual {p0}, Lio/reactivex/internal/operators/completable/CompletableUsing$UsingObserver;->disposeResourceAfter()V

    :cond_35
    return-void
.end method

.method public onSubscribe(Lio/reactivex/disposables/Disposable;)V
    .registers 3

    .line 135
    iget-object v0, p0, Lio/reactivex/internal/operators/completable/CompletableUsing$UsingObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-static {v0, p1}, Lio/reactivex/internal/disposables/DisposableHelper;->validate(Lio/reactivex/disposables/Disposable;Lio/reactivex/disposables/Disposable;)Z

    move-result v0

    if-eqz v0, :cond_f

    .line 136
    iput-object p1, p0, Lio/reactivex/internal/operators/completable/CompletableUsing$UsingObserver;->upstream:Lio/reactivex/disposables/Disposable;

    .line 138
    iget-object p1, p0, Lio/reactivex/internal/operators/completable/CompletableUsing$UsingObserver;->downstream:Lio/reactivex/CompletableObserver;

    invoke-interface {p1, p0}, Lio/reactivex/CompletableObserver;->onSubscribe(Lio/reactivex/disposables/Disposable;)V

    :cond_f
    return-void
.end method
