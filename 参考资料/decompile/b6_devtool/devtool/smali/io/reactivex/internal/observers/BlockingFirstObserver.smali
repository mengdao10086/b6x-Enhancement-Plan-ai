.class public final Lio/reactivex/internal/observers/BlockingFirstObserver;
.super Lio/reactivex/internal/observers/BlockingBaseObserver;
.source "BlockingFirstObserver.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lio/reactivex/internal/observers/BlockingBaseObserver<",
        "TT;>;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Lio/reactivex/internal/observers/BlockingBaseObserver;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Ljava/lang/Throwable;)V
    .registers 3

    iget-object v0, p0, Lio/reactivex/internal/observers/BlockingFirstObserver;->value:Ljava/lang/Object;

    if-nez v0, :cond_6

    iput-object p1, p0, Lio/reactivex/internal/observers/BlockingFirstObserver;->error:Ljava/lang/Throwable;

    :cond_6
    invoke-virtual {p0}, Lio/reactivex/internal/observers/BlockingFirstObserver;->countDown()V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    iget-object v0, p0, Lio/reactivex/internal/observers/BlockingFirstObserver;->value:Ljava/lang/Object;

    if-nez v0, :cond_e

    iput-object p1, p0, Lio/reactivex/internal/observers/BlockingFirstObserver;->value:Ljava/lang/Object;

    iget-object p1, p0, Lio/reactivex/internal/observers/BlockingFirstObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-interface {p1}, Lio/reactivex/disposables/Disposable;->dispose()V

    invoke-virtual {p0}, Lio/reactivex/internal/observers/BlockingFirstObserver;->countDown()V

    :cond_e
    return-void
.end method
