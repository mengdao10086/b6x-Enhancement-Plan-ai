.class public final Lio/reactivex/internal/operators/completable/CompletableFromAction;
.super Lio/reactivex/Completable;
.source "CompletableFromAction.java"


# instance fields
.field final run:Lio/reactivex/functions/Action;


# direct methods
.method public constructor <init>(Lio/reactivex/functions/Action;)V
    .registers 2

    invoke-direct {p0}, Lio/reactivex/Completable;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/completable/CompletableFromAction;->run:Lio/reactivex/functions/Action;

    return-void
.end method


# virtual methods
.method protected subscribeActual(Lio/reactivex/CompletableObserver;)V
    .registers 4

    invoke-static {}, Lio/reactivex/disposables/Disposables;->empty()Lio/reactivex/disposables/Disposable;

    move-result-object v0

    invoke-interface {p1, v0}, Lio/reactivex/CompletableObserver;->onSubscribe(Lio/reactivex/disposables/Disposable;)V

    :try_start_7
    iget-object v1, p0, Lio/reactivex/internal/operators/completable/CompletableFromAction;->run:Lio/reactivex/functions/Action;

    invoke-interface {v1}, Lio/reactivex/functions/Action;->run()V
    :try_end_c
    .catchall {:try_start_7 .. :try_end_c} :catchall_16

    invoke-interface {v0}, Lio/reactivex/disposables/Disposable;->isDisposed()Z

    move-result v0

    if-nez v0, :cond_15

    invoke-interface {p1}, Lio/reactivex/CompletableObserver;->onComplete()V

    :cond_15
    return-void

    :catchall_16
    move-exception v1

    invoke-static {v1}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    invoke-interface {v0}, Lio/reactivex/disposables/Disposable;->isDisposed()Z

    move-result v0

    if-nez v0, :cond_24

    invoke-interface {p1, v1}, Lio/reactivex/CompletableObserver;->onError(Ljava/lang/Throwable;)V

    goto :goto_27

    :cond_24
    invoke-static {v1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :goto_27
    return-void
.end method
