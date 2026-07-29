.class final Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;
.super Ljava/util/concurrent/atomic/AtomicInteger;
.source "ObservableSkipLastTimed.java"

# interfaces
.implements Lio/reactivex/Observer;
.implements Lio/reactivex/disposables/Disposable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "SkipLastTimedObserver"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/util/concurrent/atomic/AtomicInteger;",
        "Lio/reactivex/Observer<",
        "TT;>;",
        "Lio/reactivex/disposables/Disposable;"
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = -0x4eca0434695949bbL


# instance fields
.field volatile cancelled:Z

.field final delayError:Z

.field volatile done:Z

.field final downstream:Lio/reactivex/Observer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/Observer<",
            "-TT;>;"
        }
    .end annotation
.end field

.field error:Ljava/lang/Throwable;

.field final queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/internal/queue/SpscLinkedArrayQueue<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field final scheduler:Lio/reactivex/Scheduler;

.field final time:J

.field final unit:Ljava/util/concurrent/TimeUnit;

.field upstream:Lio/reactivex/disposables/Disposable;


# direct methods
.method constructor <init>(Lio/reactivex/Observer;JLjava/util/concurrent/TimeUnit;Lio/reactivex/Scheduler;IZ)V
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/Observer<",
            "-TT;>;J",
            "Ljava/util/concurrent/TimeUnit;",
            "Lio/reactivex/Scheduler;",
            "IZ)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->downstream:Lio/reactivex/Observer;

    iput-wide p2, p0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->time:J

    iput-object p4, p0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->unit:Ljava/util/concurrent/TimeUnit;

    iput-object p5, p0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->scheduler:Lio/reactivex/Scheduler;

    new-instance p1, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    invoke-direct {p1, p6}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;-><init>(I)V

    iput-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    iput-boolean p7, p0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->delayError:Z

    return-void
.end method


# virtual methods
.method public dispose()V
    .registers 2

    iget-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->cancelled:Z

    if-nez v0, :cond_17

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->cancelled:Z

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-interface {v0}, Lio/reactivex/disposables/Disposable;->dispose()V

    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->getAndIncrement()I

    move-result v0

    if-nez v0, :cond_17

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    invoke-virtual {v0}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->clear()V

    :cond_17
    return-void
.end method

.method drain()V
    .registers 18

    move-object/from16 v0, p0

    invoke-virtual/range {p0 .. p0}, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->getAndIncrement()I

    move-result v1

    if-eqz v1, :cond_9

    return-void

    :cond_9
    iget-object v1, v0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->downstream:Lio/reactivex/Observer;

    iget-object v2, v0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    iget-boolean v3, v0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->delayError:Z

    iget-object v4, v0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->unit:Ljava/util/concurrent/TimeUnit;

    iget-object v5, v0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->scheduler:Lio/reactivex/Scheduler;

    iget-wide v6, v0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->time:J

    const/4 v8, 0x1

    move v9, v8

    :cond_17
    :goto_17
    iget-boolean v10, v0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->cancelled:Z

    if-eqz v10, :cond_21

    iget-object v1, v0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    invoke-virtual {v1}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->clear()V

    return-void

    :cond_21
    iget-boolean v10, v0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->done:Z

    invoke-virtual {v2}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->peek()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/lang/Long;

    if-nez v11, :cond_2d

    move v12, v8

    goto :goto_2e

    :cond_2d
    const/4 v12, 0x0

    :goto_2e
    invoke-virtual {v5, v4}, Lio/reactivex/Scheduler;->now(Ljava/util/concurrent/TimeUnit;)J

    move-result-wide v13

    if-nez v12, :cond_3e

    invoke-virtual {v11}, Ljava/lang/Long;->longValue()J

    move-result-wide v15

    sub-long/2addr v13, v6

    cmp-long v11, v15, v13

    if-lez v11, :cond_3e

    move v12, v8

    :cond_3e
    if-eqz v10, :cond_63

    if-eqz v3, :cond_50

    if-eqz v12, :cond_63

    iget-object v2, v0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->error:Ljava/lang/Throwable;

    if-eqz v2, :cond_4c

    invoke-interface {v1, v2}, Lio/reactivex/Observer;->onError(Ljava/lang/Throwable;)V

    goto :goto_4f

    :cond_4c
    invoke-interface {v1}, Lio/reactivex/Observer;->onComplete()V

    :goto_4f
    return-void

    :cond_50
    iget-object v10, v0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->error:Ljava/lang/Throwable;

    if-eqz v10, :cond_5d

    iget-object v2, v0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    invoke-virtual {v2}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->clear()V

    invoke-interface {v1, v10}, Lio/reactivex/Observer;->onError(Ljava/lang/Throwable;)V

    return-void

    :cond_5d
    if-eqz v12, :cond_63

    invoke-interface {v1}, Lio/reactivex/Observer;->onComplete()V

    return-void

    :cond_63
    if-eqz v12, :cond_6d

    neg-int v9, v9

    invoke-virtual {v0, v9}, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->addAndGet(I)I

    move-result v9

    if-nez v9, :cond_17

    return-void

    :cond_6d
    invoke-virtual {v2}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->poll()Ljava/lang/Object;

    invoke-virtual {v2}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->poll()Ljava/lang/Object;

    move-result-object v10

    invoke-interface {v1, v10}, Lio/reactivex/Observer;->onNext(Ljava/lang/Object;)V

    goto :goto_17
.end method

.method public isDisposed()Z
    .registers 2

    iget-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->cancelled:Z

    return v0
.end method

.method public onComplete()V
    .registers 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->done:Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->drain()V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 2

    iput-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->error:Ljava/lang/Throwable;

    const/4 p1, 0x1

    iput-boolean p1, p0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->done:Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->drain()V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    iget-object v1, p0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->scheduler:Lio/reactivex/Scheduler;

    iget-object v2, p0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->unit:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v1, v2}, Lio/reactivex/Scheduler;->now(Ljava/util/concurrent/TimeUnit;)J

    move-result-wide v1

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->offer(Ljava/lang/Object;Ljava/lang/Object;)Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->drain()V

    return-void
.end method

.method public onSubscribe(Lio/reactivex/disposables/Disposable;)V
    .registers 3

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-static {v0, p1}, Lio/reactivex/internal/disposables/DisposableHelper;->validate(Lio/reactivex/disposables/Disposable;Lio/reactivex/disposables/Disposable;)Z

    move-result v0

    if-eqz v0, :cond_f

    iput-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->upstream:Lio/reactivex/disposables/Disposable;

    iget-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableSkipLastTimed$SkipLastTimedObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {p1, p0}, Lio/reactivex/Observer;->onSubscribe(Lio/reactivex/disposables/Disposable;)V

    :cond_f
    return-void
.end method
