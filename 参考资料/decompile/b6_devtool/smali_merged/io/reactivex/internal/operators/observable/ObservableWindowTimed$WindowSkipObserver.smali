.class final Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;
.super Lio/reactivex/internal/observers/QueueDrainObserver;
.source "ObservableWindowTimed.java"

# interfaces
.implements Lio/reactivex/disposables/Disposable;
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/observable/ObservableWindowTimed;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "WindowSkipObserver"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver$CompletionTask;,
        Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver$SubjectWork;
    }
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
        "Lio/reactivex/disposables/Disposable;",
        "Ljava/lang/Runnable;"
    }
.end annotation


# instance fields
.field final bufferSize:I

.field volatile terminated:Z

.field final timeskip:J

.field final timespan:J

.field final unit:Ljava/util/concurrent/TimeUnit;

.field upstream:Lio/reactivex/disposables/Disposable;

.field final windows:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lio/reactivex/subjects/UnicastSubject<",
            "TT;>;>;"
        }
    .end annotation
.end field

.field final worker:Lio/reactivex/Scheduler$Worker;


# direct methods
.method constructor <init>(Lio/reactivex/Observer;JJLjava/util/concurrent/TimeUnit;Lio/reactivex/Scheduler$Worker;I)V
    .registers 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/Observer<",
            "-",
            "Lio/reactivex/Observable<",
            "TT;>;>;JJ",
            "Ljava/util/concurrent/TimeUnit;",
            "Lio/reactivex/Scheduler$Worker;",
            "I)V"
        }
    .end annotation

    .line 526
    new-instance v0, Lio/reactivex/internal/queue/MpscLinkedQueue;

    invoke-direct {v0}, Lio/reactivex/internal/queue/MpscLinkedQueue;-><init>()V

    invoke-direct {p0, p1, v0}, Lio/reactivex/internal/observers/QueueDrainObserver;-><init>(Lio/reactivex/Observer;Lio/reactivex/internal/fuseable/SimplePlainQueue;)V

    .line 527
    iput-wide p2, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->timespan:J

    .line 528
    iput-wide p4, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->timeskip:J

    .line 529
    iput-object p6, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->unit:Ljava/util/concurrent/TimeUnit;

    .line 530
    iput-object p7, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->worker:Lio/reactivex/Scheduler$Worker;

    .line 531
    iput p8, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->bufferSize:I

    .line 532
    new-instance p1, Ljava/util/LinkedList;

    invoke-direct {p1}, Ljava/util/LinkedList;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->windows:Ljava/util/List;

    return-void
.end method


# virtual methods
.method complete(Lio/reactivex/subjects/UnicastSubject;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/subjects/UnicastSubject<",
            "TT;>;)V"
        }
    .end annotation

    .line 607
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    new-instance v1, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver$SubjectWork;

    const/4 v2, 0x0

    invoke-direct {v1, p1, v2}, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver$SubjectWork;-><init>(Lio/reactivex/subjects/UnicastSubject;Z)V

    invoke-interface {v0, v1}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->offer(Ljava/lang/Object;)Z

    .line 608
    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->enter()Z

    move-result p1

    if-eqz p1, :cond_14

    .line 609
    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->drainLoop()V

    :cond_14
    return-void
.end method

.method public dispose()V
    .registers 2

    const/4 v0, 0x1

    .line 598
    iput-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->cancelled:Z

    return-void
.end method

.method drainLoop()V
    .registers 11

    .line 615
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    check-cast v0, Lio/reactivex/internal/queue/MpscLinkedQueue;

    .line 616
    iget-object v1, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->downstream:Lio/reactivex/Observer;

    .line 617
    iget-object v2, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->windows:Ljava/util/List;

    const/4 v3, 0x1

    move v4, v3

    .line 624
    :cond_a
    :goto_a
    iget-boolean v5, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->terminated:Z

    if-eqz v5, :cond_1f

    .line 625
    iget-object v1, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-interface {v1}, Lio/reactivex/disposables/Disposable;->dispose()V

    .line 626
    invoke-virtual {v0}, Lio/reactivex/internal/queue/MpscLinkedQueue;->clear()V

    .line 627
    invoke-interface {v2}, Ljava/util/List;->clear()V

    .line 628
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->worker:Lio/reactivex/Scheduler$Worker;

    invoke-virtual {v0}, Lio/reactivex/Scheduler$Worker;->dispose()V

    return-void

    .line 632
    :cond_1f
    iget-boolean v5, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->done:Z

    .line 634
    invoke-virtual {v0}, Lio/reactivex/internal/queue/MpscLinkedQueue;->poll()Ljava/lang/Object;

    move-result-object v6

    if-nez v6, :cond_29

    move v7, v3

    goto :goto_2a

    :cond_29
    const/4 v7, 0x0

    .line 637
    :goto_2a
    instance-of v8, v6, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver$SubjectWork;

    if-eqz v5, :cond_6a

    if-nez v7, :cond_32

    if-eqz v8, :cond_6a

    .line 640
    :cond_32
    invoke-virtual {v0}, Lio/reactivex/internal/queue/MpscLinkedQueue;->clear()V

    .line 641
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->error:Ljava/lang/Throwable;

    if-eqz v0, :cond_4d

    .line 643
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_3d
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_61

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lio/reactivex/subjects/UnicastSubject;

    .line 644
    invoke-virtual {v3, v0}, Lio/reactivex/subjects/UnicastSubject;->onError(Ljava/lang/Throwable;)V

    goto :goto_3d

    .line 647
    :cond_4d
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_51
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_61

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lio/reactivex/subjects/UnicastSubject;

    .line 648
    invoke-virtual {v1}, Lio/reactivex/subjects/UnicastSubject;->onComplete()V

    goto :goto_51

    .line 651
    :cond_61
    invoke-interface {v2}, Ljava/util/List;->clear()V

    .line 652
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->worker:Lio/reactivex/Scheduler$Worker;

    invoke-virtual {v0}, Lio/reactivex/Scheduler$Worker;->dispose()V

    return-void

    :cond_6a
    if-eqz v7, :cond_74

    neg-int v4, v4

    .line 687
    invoke-virtual {p0, v4}, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->leave(I)I

    move-result v4

    if-nez v4, :cond_a

    return-void

    :cond_74
    if-eqz v8, :cond_b5

    .line 661
    check-cast v6, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver$SubjectWork;

    .line 663
    iget-boolean v5, v6, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver$SubjectWork;->open:Z

    if-eqz v5, :cond_9d

    .line 664
    iget-boolean v5, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->cancelled:Z

    if-eqz v5, :cond_81

    goto :goto_a

    .line 668
    :cond_81
    iget v5, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->bufferSize:I

    invoke-static {v5}, Lio/reactivex/subjects/UnicastSubject;->create(I)Lio/reactivex/subjects/UnicastSubject;

    move-result-object v5

    .line 669
    invoke-interface {v2, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 670
    invoke-interface {v1, v5}, Lio/reactivex/Observer;->onNext(Ljava/lang/Object;)V

    .line 672
    iget-object v6, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->worker:Lio/reactivex/Scheduler$Worker;

    new-instance v7, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver$CompletionTask;

    invoke-direct {v7, p0, v5}, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver$CompletionTask;-><init>(Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;Lio/reactivex/subjects/UnicastSubject;)V

    iget-wide v8, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->timespan:J

    iget-object v5, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->unit:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v6, v7, v8, v9, v5}, Lio/reactivex/Scheduler$Worker;->schedule(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Lio/reactivex/disposables/Disposable;

    goto/16 :goto_a

    .line 674
    :cond_9d
    iget-object v5, v6, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver$SubjectWork;->w:Lio/reactivex/subjects/UnicastSubject;

    invoke-interface {v2, v5}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 675
    iget-object v5, v6, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver$SubjectWork;->w:Lio/reactivex/subjects/UnicastSubject;

    invoke-virtual {v5}, Lio/reactivex/subjects/UnicastSubject;->onComplete()V

    .line 676
    invoke-interface {v2}, Ljava/util/List;->isEmpty()Z

    move-result v5

    if-eqz v5, :cond_a

    iget-boolean v5, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->cancelled:Z

    if-eqz v5, :cond_a

    .line 677
    iput-boolean v3, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->terminated:Z

    goto/16 :goto_a

    .line 681
    :cond_b5
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_b9
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_a

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lio/reactivex/subjects/UnicastSubject;

    .line 682
    invoke-virtual {v7, v6}, Lio/reactivex/subjects/UnicastSubject;->onNext(Ljava/lang/Object;)V

    goto :goto_b9
.end method

.method public isDisposed()Z
    .registers 2

    .line 603
    iget-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->cancelled:Z

    return v0
.end method

.method public onComplete()V
    .registers 2

    const/4 v0, 0x1

    .line 588
    iput-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->done:Z

    .line 589
    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->enter()Z

    move-result v0

    if-eqz v0, :cond_c

    .line 590
    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->drainLoop()V

    .line 593
    :cond_c
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {v0}, Lio/reactivex/Observer;->onComplete()V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 3

    .line 577
    iput-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->error:Ljava/lang/Throwable;

    const/4 v0, 0x1

    .line 578
    iput-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->done:Z

    .line 579
    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->enter()Z

    move-result v0

    if-eqz v0, :cond_e

    .line 580
    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->drainLoop()V

    .line 583
    :cond_e
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {v0, p1}, Lio/reactivex/Observer;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 559
    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->fastEnter()Z

    move-result v0

    if-eqz v0, :cond_24

    .line 560
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->windows:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_c
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1c

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lio/reactivex/subjects/UnicastSubject;

    .line 561
    invoke-virtual {v1, p1}, Lio/reactivex/subjects/UnicastSubject;->onNext(Ljava/lang/Object;)V

    goto :goto_c

    :cond_1c
    const/4 p1, -0x1

    .line 563
    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->leave(I)I

    move-result p1

    if-nez p1, :cond_30

    return-void

    .line 567
    :cond_24
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    invoke-interface {v0, p1}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->offer(Ljava/lang/Object;)Z

    .line 568
    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->enter()Z

    move-result p1

    if-nez p1, :cond_30

    return-void

    .line 572
    :cond_30
    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->drainLoop()V

    return-void
.end method

.method public onSubscribe(Lio/reactivex/disposables/Disposable;)V
    .registers 13

    .line 537
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-static {v0, p1}, Lio/reactivex/internal/disposables/DisposableHelper;->validate(Lio/reactivex/disposables/Disposable;Lio/reactivex/disposables/Disposable;)Z

    move-result v0

    if-eqz v0, :cond_3d

    .line 538
    iput-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->upstream:Lio/reactivex/disposables/Disposable;

    .line 540
    iget-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {p1, p0}, Lio/reactivex/Observer;->onSubscribe(Lio/reactivex/disposables/Disposable;)V

    .line 542
    iget-boolean p1, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->cancelled:Z

    if-eqz p1, :cond_14

    return-void

    .line 546
    :cond_14
    iget p1, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->bufferSize:I

    invoke-static {p1}, Lio/reactivex/subjects/UnicastSubject;->create(I)Lio/reactivex/subjects/UnicastSubject;

    move-result-object p1

    .line 547
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->windows:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 549
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {v0, p1}, Lio/reactivex/Observer;->onNext(Ljava/lang/Object;)V

    .line 550
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->worker:Lio/reactivex/Scheduler$Worker;

    new-instance v1, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver$CompletionTask;

    invoke-direct {v1, p0, p1}, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver$CompletionTask;-><init>(Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;Lio/reactivex/subjects/UnicastSubject;)V

    iget-wide v2, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->timespan:J

    iget-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->unit:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v1, v2, v3, p1}, Lio/reactivex/Scheduler$Worker;->schedule(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Lio/reactivex/disposables/Disposable;

    .line 552
    iget-object v4, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->worker:Lio/reactivex/Scheduler$Worker;

    iget-wide v8, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->timeskip:J

    iget-object v10, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->unit:Ljava/util/concurrent/TimeUnit;

    move-object v5, p0

    move-wide v6, v8

    invoke-virtual/range {v4 .. v10}, Lio/reactivex/Scheduler$Worker;->schedulePeriodically(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Lio/reactivex/disposables/Disposable;

    :cond_3d
    return-void
.end method

.method public run()V
    .registers 4

    .line 697
    iget v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->bufferSize:I

    invoke-static {v0}, Lio/reactivex/subjects/UnicastSubject;->create(I)Lio/reactivex/subjects/UnicastSubject;

    move-result-object v0

    .line 699
    new-instance v1, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver$SubjectWork;

    const/4 v2, 0x1

    invoke-direct {v1, v0, v2}, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver$SubjectWork;-><init>(Lio/reactivex/subjects/UnicastSubject;Z)V

    .line 700
    iget-boolean v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->cancelled:Z

    if-nez v0, :cond_15

    .line 701
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    invoke-interface {v0, v1}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->offer(Ljava/lang/Object;)Z

    .line 703
    :cond_15
    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->enter()Z

    move-result v0

    if-eqz v0, :cond_1e

    .line 704
    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowSkipObserver;->drainLoop()V

    :cond_1e
    return-void
.end method
