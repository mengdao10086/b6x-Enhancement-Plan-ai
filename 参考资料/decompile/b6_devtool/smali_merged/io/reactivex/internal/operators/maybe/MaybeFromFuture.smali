.class public final Lio/reactivex/internal/operators/maybe/MaybeFromFuture;
.super Lio/reactivex/Maybe;
.source "MaybeFromFuture.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lio/reactivex/Maybe<",
        "TT;>;"
    }
.end annotation


# instance fields
.field final future:Ljava/util/concurrent/Future;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/Future<",
            "+TT;>;"
        }
    .end annotation
.end field

.field final timeout:J

.field final unit:Ljava/util/concurrent/TimeUnit;


# direct methods
.method public constructor <init>(Ljava/util/concurrent/Future;JLjava/util/concurrent/TimeUnit;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/concurrent/Future<",
            "+TT;>;J",
            "Ljava/util/concurrent/TimeUnit;",
            ")V"
        }
    .end annotation

    .line 36
    invoke-direct {p0}, Lio/reactivex/Maybe;-><init>()V

    .line 37
    iput-object p1, p0, Lio/reactivex/internal/operators/maybe/MaybeFromFuture;->future:Ljava/util/concurrent/Future;

    .line 38
    iput-wide p2, p0, Lio/reactivex/internal/operators/maybe/MaybeFromFuture;->timeout:J

    .line 39
    iput-object p4, p0, Lio/reactivex/internal/operators/maybe/MaybeFromFuture;->unit:Ljava/util/concurrent/TimeUnit;

    return-void
.end method


# virtual methods
.method protected subscribeActual(Lio/reactivex/MaybeObserver;)V
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/MaybeObserver<",
            "-TT;>;)V"
        }
    .end annotation

    .line 44
    invoke-static {}, Lio/reactivex/disposables/Disposables;->empty()Lio/reactivex/disposables/Disposable;

    move-result-object v0

    .line 45
    invoke-interface {p1, v0}, Lio/reactivex/MaybeObserver;->onSubscribe(Lio/reactivex/disposables/Disposable;)V

    .line 46
    invoke-interface {v0}, Lio/reactivex/disposables/Disposable;->isDisposed()Z

    move-result v1

    if-nez v1, :cond_49

    .line 49
    :try_start_d
    iget-wide v1, p0, Lio/reactivex/internal/operators/maybe/MaybeFromFuture;->timeout:J

    const-wide/16 v3, 0x0

    cmp-long v3, v1, v3

    if-gtz v3, :cond_1c

    .line 50
    iget-object v1, p0, Lio/reactivex/internal/operators/maybe/MaybeFromFuture;->future:Ljava/util/concurrent/Future;

    invoke-interface {v1}, Ljava/util/concurrent/Future;->get()Ljava/lang/Object;

    move-result-object v1

    goto :goto_24

    .line 52
    :cond_1c
    iget-object v3, p0, Lio/reactivex/internal/operators/maybe/MaybeFromFuture;->future:Ljava/util/concurrent/Future;

    iget-object v4, p0, Lio/reactivex/internal/operators/maybe/MaybeFromFuture;->unit:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v3, v1, v2, v4}, Ljava/util/concurrent/Future;->get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;

    move-result-object v1
    :try_end_24
    .catchall {:try_start_d .. :try_end_24} :catchall_34

    .line 64
    :goto_24
    invoke-interface {v0}, Lio/reactivex/disposables/Disposable;->isDisposed()Z

    move-result v0

    if-nez v0, :cond_49

    if-nez v1, :cond_30

    .line 66
    invoke-interface {p1}, Lio/reactivex/MaybeObserver;->onComplete()V

    goto :goto_49

    .line 68
    :cond_30
    invoke-interface {p1, v1}, Lio/reactivex/MaybeObserver;->onSuccess(Ljava/lang/Object;)V

    goto :goto_49

    :catchall_34
    move-exception v1

    .line 55
    instance-of v2, v1, Ljava/util/concurrent/ExecutionException;

    if-eqz v2, :cond_3d

    .line 56
    invoke-virtual {v1}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object v1

    .line 58
    :cond_3d
    invoke-static {v1}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 59
    invoke-interface {v0}, Lio/reactivex/disposables/Disposable;->isDisposed()Z

    move-result v0

    if-nez v0, :cond_49

    .line 60
    invoke-interface {p1, v1}, Lio/reactivex/MaybeObserver;->onError(Ljava/lang/Throwable;)V

    :cond_49
    :goto_49
    return-void
.end method
