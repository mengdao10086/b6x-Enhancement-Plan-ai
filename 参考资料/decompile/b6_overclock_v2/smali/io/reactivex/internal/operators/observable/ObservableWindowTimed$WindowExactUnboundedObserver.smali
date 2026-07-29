.class final Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;
.super Lio/reactivex/internal/observers/QueueDrainObserver;
.source "ObservableWindowTimed.java"

# interfaces
.implements Lio/reactivex/Observer;
.implements Lio/reactivex/disposables/Disposable;
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/observable/ObservableWindowTimed;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "WindowExactUnboundedObserver"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lio/reactivex/internal/observers/QueueDrainObserver<",
        "TT;",
        "Ljava/lang/Object;",
        "Lio/reactivex/Observable<",
        "TT;>;>;",
        "Lio/reactivex/Observer<",
        "TT;>;",
        "Lio/reactivex/disposables/Disposable;",
        "Ljava/lang/Runnable;"
    }
.end annotation


# static fields
.field static final NEXT:Ljava/lang/Object;


# instance fields
.field final bufferSize:I

.field final scheduler:Lio/reactivex/Scheduler;

.field volatile terminated:Z

.field final timer:Lio/reactivex/internal/disposables/SequentialDisposable;

.field final timespan:J

.field final unit:Ljava/util/concurrent/TimeUnit;

.field upstream:Lio/reactivex/disposables/Disposable;

.field window:Lio/reactivex/subjects/UnicastSubject;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/subjects/UnicastSubject<",
            "TT;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->NEXT:Ljava/lang/Object;

    return-void
.end method

.method constructor <init>(Lio/reactivex/Observer;JLjava/util/concurrent/TimeUnit;Lio/reactivex/Scheduler;I)V
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/Observer<",
            "-",
            "Lio/reactivex/Observable<",
            "TT;>;>;J",
            "Ljava/util/concurrent/TimeUnit;",
            "Lio/reactivex/Scheduler;",
            "I)V"
        }
    .end annotation

    new-instance v0, Lio/reactivex/internal/queue/MpscLinkedQueue;

    invoke-direct {v0}, Lio/reactivex/internal/queue/MpscLinkedQueue;-><init>()V

    invoke-direct {p0, p1, v0}, Lio/reactivex/internal/observers/QueueDrainObserver;-><init>(Lio/reactivex/Observer;Lio/reactivex/internal/fuseable/SimplePlainQueue;)V

    new-instance p1, Lio/reactivex/internal/disposables/SequentialDisposable;

    invoke-direct {p1}, Lio/reactivex/internal/disposables/SequentialDisposable;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->timer:Lio/reactivex/internal/disposables/SequentialDisposable;

    iput-wide p2, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->timespan:J

    iput-object p4, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->unit:Ljava/util/concurrent/TimeUnit;

    iput-object p5, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->scheduler:Lio/reactivex/Scheduler;

    iput p6, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->bufferSize:I

    return-void
.end method


# virtual methods
.method public dispose()V
    .registers 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->cancelled:Z

    return-void
.end method

.method drainLoop()V
    .registers 8

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    check-cast v0, Lio/reactivex/internal/queue/MpscLinkedQueue;

    iget-object v1, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->downstream:Lio/reactivex/Observer;

    iget-object v2, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->window:Lio/reactivex/subjects/UnicastSubject;

    const/4 v3, 0x1

    :cond_9
    :goto_9
    iget-boolean v4, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->terminated:Z

    iget-boolean v5, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->done:Z

    invoke-virtual {v0}, Lio/reactivex/internal/queue/MpscLinkedQueue;->poll()Ljava/lang/Object;

    move-result-object v6

    if-eqz v5, :cond_30

    if-eqz v6, :cond_19

    sget-object v5, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->NEXT:Ljava/lang/Object;

    if-ne v6, v5, :cond_30

    :cond_19
    const/4 v1, 0x0

    iput-object v1, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->window:Lio/reactivex/subjects/UnicastSubject;

    invoke-virtual {v0}, Lio/reactivex/internal/queue/MpscLinkedQueue;->clear()V

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->error:Ljava/lang/Throwable;

    if-eqz v0, :cond_27

    invoke-virtual {v2, v0}, Lio/reactivex/subjects/UnicastSubject;->onError(Ljava/lang/Throwable;)V

    goto :goto_2a

    :cond_27
    invoke-virtual {v2}, Lio/reactivex/subjects/UnicastSubject;->onComplete()V

    :goto_2a
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->timer:Lio/reactivex/internal/disposables/SequentialDisposable;

    invoke-virtual {v0}, Lio/reactivex/internal/disposables/SequentialDisposable;->dispose()V

    return-void

    :cond_30
    if-nez v6, :cond_3a

    neg-int v3, v3

    invoke-virtual {p0, v3}, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->leave(I)I

    move-result v3

    if-nez v3, :cond_9

    return-void

    :cond_3a
    sget-object v5, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->NEXT:Ljava/lang/Object;

    if-ne v6, v5, :cond_55

    invoke-virtual {v2}, Lio/reactivex/subjects/UnicastSubject;->onComplete()V

    if-nez v4, :cond_4f

    iget v2, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->bufferSize:I

    invoke-static {v2}, Lio/reactivex/subjects/UnicastSubject;->create(I)Lio/reactivex/subjects/UnicastSubject;

    move-result-object v2

    iput-object v2, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->window:Lio/reactivex/subjects/UnicastSubject;

    invoke-interface {v1, v2}, Lio/reactivex/Observer;->onNext(Ljava/lang/Object;)V

    goto :goto_9

    :cond_4f
    iget-object v4, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-interface {v4}, Lio/reactivex/disposables/Disposable;->dispose()V

    goto :goto_9

    :cond_55
    invoke-static {v6}, Lio/reactivex/internal/util/NotificationLite;->getValue(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v2, v4}, Lio/reactivex/subjects/UnicastSubject;->onNext(Ljava/lang/Object;)V

    goto :goto_9
.end method

.method public isDisposed()Z
    .registers 2

    iget-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->cancelled:Z

    return v0
.end method

.method public onComplete()V
    .registers 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->done:Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->enter()Z

    move-result v0

    if-eqz v0, :cond_c

    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->drainLoop()V

    :cond_c
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {v0}, Lio/reactivex/Observer;->onComplete()V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 3

    iput-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->error:Ljava/lang/Throwable;

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->done:Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->enter()Z

    move-result v0

    if-eqz v0, :cond_e

    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->drainLoop()V

    :cond_e
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {v0, p1}, Lio/reactivex/Observer;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    iget-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->terminated:Z

    if-eqz v0, :cond_5

    return-void

    :cond_5
    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->fastEnter()Z

    move-result v0

    if-eqz v0, :cond_18

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->window:Lio/reactivex/subjects/UnicastSubject;

    invoke-virtual {v0, p1}, Lio/reactivex/subjects/UnicastSubject;->onNext(Ljava/lang/Object;)V

    const/4 p1, -0x1

    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->leave(I)I

    move-result p1

    if-nez p1, :cond_28

    return-void

    :cond_18
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    invoke-static {p1}, Lio/reactivex/internal/util/NotificationLite;->next(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    invoke-interface {v0, p1}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->offer(Ljava/lang/Object;)Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->enter()Z

    move-result p1

    if-nez p1, :cond_28

    return-void

    :cond_28
    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->drainLoop()V

    return-void
.end method

.method public onSubscribe(Lio/reactivex/disposables/Disposable;)V
    .registers 9

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-static {v0, p1}, Lio/reactivex/internal/disposables/DisposableHelper;->validate(Lio/reactivex/disposables/Disposable;Lio/reactivex/disposables/Disposable;)Z

    move-result v0

    if-eqz v0, :cond_31

    iput-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->upstream:Lio/reactivex/disposables/Disposable;

    iget p1, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->bufferSize:I

    invoke-static {p1}, Lio/reactivex/subjects/UnicastSubject;->create(I)Lio/reactivex/subjects/UnicastSubject;

    move-result-object p1

    iput-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->window:Lio/reactivex/subjects/UnicastSubject;

    iget-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {p1, p0}, Lio/reactivex/Observer;->onSubscribe(Lio/reactivex/disposables/Disposable;)V

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->window:Lio/reactivex/subjects/UnicastSubject;

    invoke-interface {p1, v0}, Lio/reactivex/Observer;->onNext(Ljava/lang/Object;)V

    iget-boolean p1, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->cancelled:Z

    if-nez p1, :cond_31

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->scheduler:Lio/reactivex/Scheduler;

    iget-wide v4, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->timespan:J

    iget-object v6, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->unit:Ljava/util/concurrent/TimeUnit;

    move-object v1, p0

    move-wide v2, v4

    invoke-virtual/range {v0 .. v6}, Lio/reactivex/Scheduler;->schedulePeriodicallyDirect(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Lio/reactivex/disposables/Disposable;

    move-result-object p1

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->timer:Lio/reactivex/internal/disposables/SequentialDisposable;

    invoke-virtual {v0, p1}, Lio/reactivex/internal/disposables/SequentialDisposable;->replace(Lio/reactivex/disposables/Disposable;)Z

    :cond_31
    return-void
.end method

.method public run()V
    .registers 3

    iget-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->cancelled:Z

    if-eqz v0, :cond_7

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->terminated:Z

    :cond_7
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    sget-object v1, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->NEXT:Ljava/lang/Object;

    invoke-interface {v0, v1}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->offer(Ljava/lang/Object;)Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->enter()Z

    move-result v0

    if-eqz v0, :cond_17

    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;->drainLoop()V

    :cond_17
    return-void
.end method
