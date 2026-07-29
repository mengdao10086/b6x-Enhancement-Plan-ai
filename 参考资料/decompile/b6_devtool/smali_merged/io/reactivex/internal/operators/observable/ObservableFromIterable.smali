.class public final Lio/reactivex/internal/operators/observable/ObservableFromIterable;
.super Lio/reactivex/Observable;
.source "ObservableFromIterable.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/reactivex/internal/operators/observable/ObservableFromIterable$FromIterableDisposable;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lio/reactivex/Observable<",
        "TT;>;"
    }
.end annotation


# instance fields
.field final source:Ljava/lang/Iterable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Iterable<",
            "+TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/Iterable;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Iterable<",
            "+TT;>;)V"
        }
    .end annotation

    .line 27
    invoke-direct {p0}, Lio/reactivex/Observable;-><init>()V

    .line 28
    iput-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableFromIterable;->source:Ljava/lang/Iterable;

    return-void
.end method


# virtual methods
.method public subscribeActual(Lio/reactivex/Observer;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/Observer<",
            "-TT;>;)V"
        }
    .end annotation

    .line 35
    :try_start_0
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableFromIterable;->source:Ljava/lang/Iterable;

    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0
    :try_end_6
    .catchall {:try_start_0 .. :try_end_6} :catchall_28

    .line 43
    :try_start_6
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1
    :try_end_a
    .catchall {:try_start_6 .. :try_end_a} :catchall_20

    if-nez v1, :cond_10

    .line 50
    invoke-static {p1}, Lio/reactivex/internal/disposables/EmptyDisposable;->complete(Lio/reactivex/Observer;)V

    return-void

    .line 54
    :cond_10
    new-instance v1, Lio/reactivex/internal/operators/observable/ObservableFromIterable$FromIterableDisposable;

    invoke-direct {v1, p1, v0}, Lio/reactivex/internal/operators/observable/ObservableFromIterable$FromIterableDisposable;-><init>(Lio/reactivex/Observer;Ljava/util/Iterator;)V

    .line 55
    invoke-interface {p1, v1}, Lio/reactivex/Observer;->onSubscribe(Lio/reactivex/disposables/Disposable;)V

    .line 57
    iget-boolean p1, v1, Lio/reactivex/internal/operators/observable/ObservableFromIterable$FromIterableDisposable;->fusionMode:Z

    if-nez p1, :cond_1f

    .line 58
    invoke-virtual {v1}, Lio/reactivex/internal/operators/observable/ObservableFromIterable$FromIterableDisposable;->run()V

    :cond_1f
    return-void

    :catchall_20
    move-exception v0

    .line 45
    invoke-static {v0}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 46
    invoke-static {v0, p1}, Lio/reactivex/internal/disposables/EmptyDisposable;->error(Ljava/lang/Throwable;Lio/reactivex/Observer;)V

    return-void

    :catchall_28
    move-exception v0

    .line 37
    invoke-static {v0}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 38
    invoke-static {v0, p1}, Lio/reactivex/internal/disposables/EmptyDisposable;->error(Ljava/lang/Throwable;Lio/reactivex/Observer;)V

    return-void
.end method
