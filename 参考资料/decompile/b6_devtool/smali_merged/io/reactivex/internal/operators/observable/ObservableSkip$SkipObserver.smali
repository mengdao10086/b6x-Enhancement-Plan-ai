.class final Lio/reactivex/internal/operators/observable/ObservableSkip$SkipObserver;
.super Ljava/lang/Object;
.source "ObservableSkip.java"

# interfaces
.implements Lio/reactivex/Observer;
.implements Lio/reactivex/disposables/Disposable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/observable/ObservableSkip;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "SkipObserver"
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
.field final downstream:Lio/reactivex/Observer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/Observer<",
            "-TT;>;"
        }
    .end annotation
.end field

.field remaining:J

.field upstream:Lio/reactivex/disposables/Disposable;


# direct methods
.method constructor <init>(Lio/reactivex/Observer;J)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/Observer<",
            "-TT;>;J)V"
        }
    .end annotation

    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    iput-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableSkip$SkipObserver;->downstream:Lio/reactivex/Observer;

    .line 40
    iput-wide p2, p0, Lio/reactivex/internal/operators/observable/ObservableSkip$SkipObserver;->remaining:J

    return-void
.end method


# virtual methods
.method public dispose()V
    .registers 2

    .line 72
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableSkip$SkipObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-interface {v0}, Lio/reactivex/disposables/Disposable;->dispose()V

    return-void
.end method

.method public isDisposed()Z
    .registers 2

    .line 77
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableSkip$SkipObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-interface {v0}, Lio/reactivex/disposables/Disposable;->isDisposed()Z

    move-result v0

    return v0
.end method

.method public onComplete()V
    .registers 2

    .line 67
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableSkip$SkipObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {v0}, Lio/reactivex/Observer;->onComplete()V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 3

    .line 62
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableSkip$SkipObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {v0, p1}, Lio/reactivex/Observer;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 53
    iget-wide v0, p0, Lio/reactivex/internal/operators/observable/ObservableSkip$SkipObserver;->remaining:J

    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-eqz v2, :cond_e

    const-wide/16 v2, 0x1

    sub-long/2addr v0, v2

    .line 54
    iput-wide v0, p0, Lio/reactivex/internal/operators/observable/ObservableSkip$SkipObserver;->remaining:J

    goto :goto_13

    .line 56
    :cond_e
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableSkip$SkipObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {v0, p1}, Lio/reactivex/Observer;->onNext(Ljava/lang/Object;)V

    :goto_13
    return-void
.end method

.method public onSubscribe(Lio/reactivex/disposables/Disposable;)V
    .registers 3

    .line 45
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableSkip$SkipObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-static {v0, p1}, Lio/reactivex/internal/disposables/DisposableHelper;->validate(Lio/reactivex/disposables/Disposable;Lio/reactivex/disposables/Disposable;)Z

    move-result v0

    if-eqz v0, :cond_f

    .line 46
    iput-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableSkip$SkipObserver;->upstream:Lio/reactivex/disposables/Disposable;

    .line 47
    iget-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableSkip$SkipObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {p1, p0}, Lio/reactivex/Observer;->onSubscribe(Lio/reactivex/disposables/Disposable;)V

    :cond_f
    return-void
.end method
