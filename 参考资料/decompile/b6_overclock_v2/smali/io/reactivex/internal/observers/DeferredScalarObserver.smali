.class public abstract Lio/reactivex/internal/observers/DeferredScalarObserver;
.super Lio/reactivex/internal/observers/DeferredScalarDisposable;
.source "DeferredScalarObserver.java"

# interfaces
.implements Lio/reactivex/Observer;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        "R:",
        "Ljava/lang/Object;",
        ">",
        "Lio/reactivex/internal/observers/DeferredScalarDisposable<",
        "TR;>;",
        "Lio/reactivex/Observer<",
        "TT;>;"
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = -0x3b1b71a072cf1ebL


# instance fields
.field protected upstream:Lio/reactivex/disposables/Disposable;


# direct methods
.method public constructor <init>(Lio/reactivex/Observer;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/Observer<",
            "-TR;>;)V"
        }
    .end annotation

    invoke-direct {p0, p1}, Lio/reactivex/internal/observers/DeferredScalarDisposable;-><init>(Lio/reactivex/Observer;)V

    return-void
.end method


# virtual methods
.method public dispose()V
    .registers 2

    invoke-super {p0}, Lio/reactivex/internal/observers/DeferredScalarDisposable;->dispose()V

    iget-object v0, p0, Lio/reactivex/internal/observers/DeferredScalarObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-interface {v0}, Lio/reactivex/disposables/Disposable;->dispose()V

    return-void
.end method

.method public onComplete()V
    .registers 3

    iget-object v0, p0, Lio/reactivex/internal/observers/DeferredScalarObserver;->value:Ljava/lang/Object;

    if-eqz v0, :cond_b

    const/4 v1, 0x0

    iput-object v1, p0, Lio/reactivex/internal/observers/DeferredScalarObserver;->value:Ljava/lang/Object;

    invoke-virtual {p0, v0}, Lio/reactivex/internal/observers/DeferredScalarObserver;->complete(Ljava/lang/Object;)V

    goto :goto_e

    :cond_b
    invoke-virtual {p0}, Lio/reactivex/internal/observers/DeferredScalarObserver;->complete()V

    :goto_e
    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 3

    const/4 v0, 0x0

    iput-object v0, p0, Lio/reactivex/internal/observers/DeferredScalarObserver;->value:Ljava/lang/Object;

    invoke-virtual {p0, p1}, Lio/reactivex/internal/observers/DeferredScalarObserver;->error(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onSubscribe(Lio/reactivex/disposables/Disposable;)V
    .registers 3

    iget-object v0, p0, Lio/reactivex/internal/observers/DeferredScalarObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-static {v0, p1}, Lio/reactivex/internal/disposables/DisposableHelper;->validate(Lio/reactivex/disposables/Disposable;Lio/reactivex/disposables/Disposable;)Z

    move-result v0

    if-eqz v0, :cond_f

    iput-object p1, p0, Lio/reactivex/internal/observers/DeferredScalarObserver;->upstream:Lio/reactivex/disposables/Disposable;

    iget-object p1, p0, Lio/reactivex/internal/observers/DeferredScalarObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {p1, p0}, Lio/reactivex/Observer;->onSubscribe(Lio/reactivex/disposables/Disposable;)V

    :cond_f
    return-void
.end method
