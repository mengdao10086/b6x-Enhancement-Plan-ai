.class final Lio/reactivex/internal/operators/observable/ObservableAllSingle$AllObserver;
.super Ljava/lang/Object;
.source "ObservableAllSingle.java"

# interfaces
.implements Lio/reactivex/Observer;
.implements Lio/reactivex/disposables/Disposable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/observable/ObservableAllSingle;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "AllObserver"
.end annotation

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


# instance fields
.field done:Z

.field final downstream:Lio/reactivex/SingleObserver;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/SingleObserver<",
            "-",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field final predicate:Lio/reactivex/functions/Predicate;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/functions/Predicate<",
            "-TT;>;"
        }
    .end annotation
.end field

.field upstream:Lio/reactivex/disposables/Disposable;


# direct methods
.method constructor <init>(Lio/reactivex/SingleObserver;Lio/reactivex/functions/Predicate;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/SingleObserver<",
            "-",
            "Ljava/lang/Boolean;",
            ">;",
            "Lio/reactivex/functions/Predicate<",
            "-TT;>;)V"
        }
    .end annotation

    .line 50
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 51
    iput-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableAllSingle$AllObserver;->downstream:Lio/reactivex/SingleObserver;

    .line 52
    iput-object p2, p0, Lio/reactivex/internal/operators/observable/ObservableAllSingle$AllObserver;->predicate:Lio/reactivex/functions/Predicate;

    return-void
.end method


# virtual methods
.method public dispose()V
    .registers 2

    .line 105
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableAllSingle$AllObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-interface {v0}, Lio/reactivex/disposables/Disposable;->dispose()V

    return-void
.end method

.method public isDisposed()Z
    .registers 2

    .line 110
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableAllSingle$AllObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-interface {v0}, Lio/reactivex/disposables/Disposable;->isDisposed()Z

    move-result v0

    return v0
.end method

.method public onComplete()V
    .registers 3

    .line 96
    iget-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableAllSingle$AllObserver;->done:Z

    if-eqz v0, :cond_5

    return-void

    :cond_5
    const/4 v0, 0x1

    .line 99
    iput-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableAllSingle$AllObserver;->done:Z

    .line 100
    iget-object v1, p0, Lio/reactivex/internal/operators/observable/ObservableAllSingle$AllObserver;->downstream:Lio/reactivex/SingleObserver;

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-interface {v1, v0}, Lio/reactivex/SingleObserver;->onSuccess(Ljava/lang/Object;)V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 3

    .line 86
    iget-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableAllSingle$AllObserver;->done:Z

    if-eqz v0, :cond_8

    .line 87
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    return-void

    :cond_8
    const/4 v0, 0x1

    .line 90
    iput-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableAllSingle$AllObserver;->done:Z

    .line 91
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableAllSingle$AllObserver;->downstream:Lio/reactivex/SingleObserver;

    invoke-interface {v0, p1}, Lio/reactivex/SingleObserver;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 65
    iget-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableAllSingle$AllObserver;->done:Z

    if-eqz v0, :cond_5

    return-void

    .line 70
    :cond_5
    :try_start_5
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableAllSingle$AllObserver;->predicate:Lio/reactivex/functions/Predicate;

    invoke-interface {v0, p1}, Lio/reactivex/functions/Predicate;->test(Ljava/lang/Object;)Z

    move-result p1
    :try_end_b
    .catchall {:try_start_5 .. :try_end_b} :catchall_20

    if-nez p1, :cond_1f

    const/4 p1, 0x1

    .line 78
    iput-boolean p1, p0, Lio/reactivex/internal/operators/observable/ObservableAllSingle$AllObserver;->done:Z

    .line 79
    iget-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableAllSingle$AllObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-interface {p1}, Lio/reactivex/disposables/Disposable;->dispose()V

    .line 80
    iget-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableAllSingle$AllObserver;->downstream:Lio/reactivex/SingleObserver;

    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-interface {p1, v0}, Lio/reactivex/SingleObserver;->onSuccess(Ljava/lang/Object;)V

    :cond_1f
    return-void

    :catchall_20
    move-exception p1

    .line 72
    invoke-static {p1}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 73
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableAllSingle$AllObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-interface {v0}, Lio/reactivex/disposables/Disposable;->dispose()V

    .line 74
    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/observable/ObservableAllSingle$AllObserver;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onSubscribe(Lio/reactivex/disposables/Disposable;)V
    .registers 3

    .line 57
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableAllSingle$AllObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-static {v0, p1}, Lio/reactivex/internal/disposables/DisposableHelper;->validate(Lio/reactivex/disposables/Disposable;Lio/reactivex/disposables/Disposable;)Z

    move-result v0

    if-eqz v0, :cond_f

    .line 58
    iput-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableAllSingle$AllObserver;->upstream:Lio/reactivex/disposables/Disposable;

    .line 59
    iget-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableAllSingle$AllObserver;->downstream:Lio/reactivex/SingleObserver;

    invoke-interface {p1, p0}, Lio/reactivex/SingleObserver;->onSubscribe(Lio/reactivex/disposables/Disposable;)V

    :cond_f
    return-void
.end method
