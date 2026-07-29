.class final Lio/reactivex/internal/operators/observable/ObservableTakeUntilPredicate$TakeUntilPredicateObserver;
.super Ljava/lang/Object;
.source "ObservableTakeUntilPredicate.java"

# interfaces
.implements Lio/reactivex/Observer;
.implements Lio/reactivex/disposables/Disposable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/observable/ObservableTakeUntilPredicate;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "TakeUntilPredicateObserver"
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

.field final downstream:Lio/reactivex/Observer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/Observer<",
            "-TT;>;"
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
.method constructor <init>(Lio/reactivex/Observer;Lio/reactivex/functions/Predicate;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/Observer<",
            "-TT;>;",
            "Lio/reactivex/functions/Predicate<",
            "-TT;>;)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableTakeUntilPredicate$TakeUntilPredicateObserver;->downstream:Lio/reactivex/Observer;

    iput-object p2, p0, Lio/reactivex/internal/operators/observable/ObservableTakeUntilPredicate$TakeUntilPredicateObserver;->predicate:Lio/reactivex/functions/Predicate;

    return-void
.end method


# virtual methods
.method public dispose()V
    .registers 2

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableTakeUntilPredicate$TakeUntilPredicateObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-interface {v0}, Lio/reactivex/disposables/Disposable;->dispose()V

    return-void
.end method

.method public isDisposed()Z
    .registers 2

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableTakeUntilPredicate$TakeUntilPredicateObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-interface {v0}, Lio/reactivex/disposables/Disposable;->isDisposed()Z

    move-result v0

    return v0
.end method

.method public onComplete()V
    .registers 2

    iget-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableTakeUntilPredicate$TakeUntilPredicateObserver;->done:Z

    if-nez v0, :cond_c

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableTakeUntilPredicate$TakeUntilPredicateObserver;->done:Z

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableTakeUntilPredicate$TakeUntilPredicateObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {v0}, Lio/reactivex/Observer;->onComplete()V

    :cond_c
    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 3

    iget-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableTakeUntilPredicate$TakeUntilPredicateObserver;->done:Z

    if-nez v0, :cond_d

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableTakeUntilPredicate$TakeUntilPredicateObserver;->done:Z

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableTakeUntilPredicate$TakeUntilPredicateObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {v0, p1}, Lio/reactivex/Observer;->onError(Ljava/lang/Throwable;)V

    goto :goto_10

    :cond_d
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :goto_10
    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    iget-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableTakeUntilPredicate$TakeUntilPredicateObserver;->done:Z

    if-nez v0, :cond_2b

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableTakeUntilPredicate$TakeUntilPredicateObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {v0, p1}, Lio/reactivex/Observer;->onNext(Ljava/lang/Object;)V

    :try_start_9
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableTakeUntilPredicate$TakeUntilPredicateObserver;->predicate:Lio/reactivex/functions/Predicate;

    invoke-interface {v0, p1}, Lio/reactivex/functions/Predicate;->test(Ljava/lang/Object;)Z

    move-result p1
    :try_end_f
    .catchall {:try_start_9 .. :try_end_f} :catchall_1f

    if-eqz p1, :cond_2b

    const/4 p1, 0x1

    iput-boolean p1, p0, Lio/reactivex/internal/operators/observable/ObservableTakeUntilPredicate$TakeUntilPredicateObserver;->done:Z

    iget-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableTakeUntilPredicate$TakeUntilPredicateObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-interface {p1}, Lio/reactivex/disposables/Disposable;->dispose()V

    iget-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableTakeUntilPredicate$TakeUntilPredicateObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {p1}, Lio/reactivex/Observer;->onComplete()V

    goto :goto_2b

    :catchall_1f
    move-exception p1

    invoke-static {p1}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableTakeUntilPredicate$TakeUntilPredicateObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-interface {v0}, Lio/reactivex/disposables/Disposable;->dispose()V

    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/observable/ObservableTakeUntilPredicate$TakeUntilPredicateObserver;->onError(Ljava/lang/Throwable;)V

    :cond_2b
    :goto_2b
    return-void
.end method

.method public onSubscribe(Lio/reactivex/disposables/Disposable;)V
    .registers 3

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableTakeUntilPredicate$TakeUntilPredicateObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-static {v0, p1}, Lio/reactivex/internal/disposables/DisposableHelper;->validate(Lio/reactivex/disposables/Disposable;Lio/reactivex/disposables/Disposable;)Z

    move-result v0

    if-eqz v0, :cond_f

    iput-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableTakeUntilPredicate$TakeUntilPredicateObserver;->upstream:Lio/reactivex/disposables/Disposable;

    iget-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableTakeUntilPredicate$TakeUntilPredicateObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {p1, p0}, Lio/reactivex/Observer;->onSubscribe(Lio/reactivex/disposables/Disposable;)V

    :cond_f
    return-void
.end method
