.class public abstract Lio/reactivex/internal/observers/BlockingBaseObserver;
.super Ljava/util/concurrent/CountDownLatch;
.source "BlockingBaseObserver.java"

# interfaces
.implements Lio/reactivex/Observer;
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
        "Lio/reactivex/disposables/Disposable;"
    }
.end annotation


# instance fields
.field volatile cancelled:Z

.field error:Ljava/lang/Throwable;

.field upstream:Lio/reactivex/disposables/Disposable;

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

    return-void
.end method


# virtual methods
.method public final blockingGet()Ljava/lang/Object;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    invoke-virtual {p0}, Lio/reactivex/internal/observers/BlockingBaseObserver;->getCount()J

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_1a

    :try_start_a
    invoke-static {}, Lio/reactivex/internal/util/BlockingHelper;->verifyNonBlocking()V

    invoke-virtual {p0}, Lio/reactivex/internal/observers/BlockingBaseObserver;->await()V
    :try_end_10
    .catch Ljava/lang/InterruptedException; {:try_start_a .. :try_end_10} :catch_11

    goto :goto_1a

    :catch_11
    move-exception v0

    invoke-virtual {p0}, Lio/reactivex/internal/observers/BlockingBaseObserver;->dispose()V

    invoke-static {v0}, Lio/reactivex/internal/util/ExceptionHelper;->wrapOrThrow(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0

    :cond_1a
    :goto_1a
    iget-object v0, p0, Lio/reactivex/internal/observers/BlockingBaseObserver;->error:Ljava/lang/Throwable;

    if-nez v0, :cond_21

    iget-object v0, p0, Lio/reactivex/internal/observers/BlockingBaseObserver;->value:Ljava/lang/Object;

    return-object v0

    :cond_21
    invoke-static {v0}, Lio/reactivex/internal/util/ExceptionHelper;->wrapOrThrow(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public final dispose()V
    .registers 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/observers/BlockingBaseObserver;->cancelled:Z

    iget-object v0, p0, Lio/reactivex/internal/observers/BlockingBaseObserver;->upstream:Lio/reactivex/disposables/Disposable;

    if-eqz v0, :cond_a

    invoke-interface {v0}, Lio/reactivex/disposables/Disposable;->dispose()V

    :cond_a
    return-void
.end method

.method public final isDisposed()Z
    .registers 2

    iget-boolean v0, p0, Lio/reactivex/internal/observers/BlockingBaseObserver;->cancelled:Z

    return v0
.end method

.method public final onComplete()V
    .registers 1

    invoke-virtual {p0}, Lio/reactivex/internal/observers/BlockingBaseObserver;->countDown()V

    return-void
.end method

.method public final onSubscribe(Lio/reactivex/disposables/Disposable;)V
    .registers 3

    iput-object p1, p0, Lio/reactivex/internal/observers/BlockingBaseObserver;->upstream:Lio/reactivex/disposables/Disposable;

    iget-boolean v0, p0, Lio/reactivex/internal/observers/BlockingBaseObserver;->cancelled:Z

    if-eqz v0, :cond_9

    invoke-interface {p1}, Lio/reactivex/disposables/Disposable;->dispose()V

    :cond_9
    return-void
.end method
