.class final Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;
.super Ljava/lang/Object;
.source "BehaviorSubject.java"

# interfaces
.implements Lio/reactivex/disposables/Disposable;
.implements Lio/reactivex/internal/util/AppendOnlyLinkedArrayList$NonThrowingPredicate;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/subjects/BehaviorSubject;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "BehaviorDisposable"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lio/reactivex/disposables/Disposable;",
        "Lio/reactivex/internal/util/AppendOnlyLinkedArrayList$NonThrowingPredicate<",
        "Ljava/lang/Object;",
        ">;"
    }
.end annotation


# instance fields
.field volatile cancelled:Z

.field final downstream:Lio/reactivex/Observer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/Observer<",
            "-TT;>;"
        }
    .end annotation
.end field

.field emitting:Z

.field fastPath:Z

.field index:J

.field next:Z

.field queue:Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/internal/util/AppendOnlyLinkedArrayList<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field final state:Lio/reactivex/subjects/BehaviorSubject;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/subjects/BehaviorSubject<",
            "TT;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lio/reactivex/Observer;Lio/reactivex/subjects/BehaviorSubject;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/Observer<",
            "-TT;>;",
            "Lio/reactivex/subjects/BehaviorSubject<",
            "TT;>;)V"
        }
    .end annotation

    .line 485
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 486
    iput-object p1, p0, Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;->downstream:Lio/reactivex/Observer;

    .line 487
    iput-object p2, p0, Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;->state:Lio/reactivex/subjects/BehaviorSubject;

    return-void
.end method


# virtual methods
.method public dispose()V
    .registers 2

    .line 492
    iget-boolean v0, p0, Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;->cancelled:Z

    if-nez v0, :cond_c

    const/4 v0, 0x1

    .line 493
    iput-boolean v0, p0, Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;->cancelled:Z

    .line 495
    iget-object v0, p0, Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;->state:Lio/reactivex/subjects/BehaviorSubject;

    invoke-virtual {v0, p0}, Lio/reactivex/subjects/BehaviorSubject;->remove(Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;)V

    :cond_c
    return-void
.end method

.method emitFirst()V
    .registers 5

    .line 505
    iget-boolean v0, p0, Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;->cancelled:Z

    if-eqz v0, :cond_5

    return-void

    .line 509
    :cond_5
    monitor-enter p0

    .line 510
    :try_start_6
    iget-boolean v0, p0, Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;->cancelled:Z

    if-eqz v0, :cond_c

    .line 511
    monitor-exit p0

    return-void

    .line 513
    :cond_c
    iget-boolean v0, p0, Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;->next:Z

    if-eqz v0, :cond_12

    .line 514
    monitor-exit p0

    return-void

    .line 517
    :cond_12
    iget-object v0, p0, Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;->state:Lio/reactivex/subjects/BehaviorSubject;

    .line 518
    iget-object v1, v0, Lio/reactivex/subjects/BehaviorSubject;->readLock:Ljava/util/concurrent/locks/Lock;

    .line 520
    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 521
    iget-wide v2, v0, Lio/reactivex/subjects/BehaviorSubject;->index:J

    iput-wide v2, p0, Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;->index:J

    .line 522
    iget-object v0, v0, Lio/reactivex/subjects/BehaviorSubject;->value:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    .line 523
    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    const/4 v1, 0x1

    if-eqz v0, :cond_2b

    move v2, v1

    goto :goto_2c

    :cond_2b
    const/4 v2, 0x0

    .line 525
    :goto_2c
    iput-boolean v2, p0, Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;->emitting:Z

    .line 526
    iput-boolean v1, p0, Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;->next:Z

    .line 527
    monitor-exit p0
    :try_end_31
    .catchall {:try_start_6 .. :try_end_31} :catchall_3e

    if-eqz v0, :cond_3d

    .line 530
    invoke-virtual {p0, v0}, Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;->test(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3a

    return-void

    .line 534
    :cond_3a
    invoke-virtual {p0}, Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;->emitLoop()V

    :cond_3d
    return-void

    :catchall_3e
    move-exception v0

    .line 527
    :try_start_3f
    monitor-exit p0
    :try_end_40
    .catchall {:try_start_3f .. :try_end_40} :catchall_3e

    throw v0
.end method

.method emitLoop()V
    .registers 3

    .line 574
    :goto_0
    iget-boolean v0, p0, Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;->cancelled:Z

    if-eqz v0, :cond_5

    return-void

    .line 578
    :cond_5
    monitor-enter p0

    .line 579
    :try_start_6
    iget-object v0, p0, Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;->queue:Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;

    if-nez v0, :cond_f

    const/4 v0, 0x0

    .line 581
    iput-boolean v0, p0, Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;->emitting:Z

    .line 582
    monitor-exit p0

    return-void

    :cond_f
    const/4 v1, 0x0

    .line 584
    iput-object v1, p0, Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;->queue:Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;

    .line 585
    monitor-exit p0
    :try_end_13
    .catchall {:try_start_6 .. :try_end_13} :catchall_17

    .line 587
    invoke-virtual {v0, p0}, Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;->forEachWhile(Lio/reactivex/internal/util/AppendOnlyLinkedArrayList$NonThrowingPredicate;)V

    goto :goto_0

    :catchall_17
    move-exception v0

    .line 585
    :try_start_18
    monitor-exit p0
    :try_end_19
    .catchall {:try_start_18 .. :try_end_19} :catchall_17

    throw v0
.end method

.method emitNext(Ljava/lang/Object;J)V
    .registers 6

    .line 539
    iget-boolean v0, p0, Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;->cancelled:Z

    if-eqz v0, :cond_5

    return-void

    .line 542
    :cond_5
    iget-boolean v0, p0, Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;->fastPath:Z

    if-nez v0, :cond_37

    .line 543
    monitor-enter p0

    .line 544
    :try_start_a
    iget-boolean v0, p0, Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;->cancelled:Z

    if-eqz v0, :cond_10

    .line 545
    monitor-exit p0

    return-void

    .line 547
    :cond_10
    iget-wide v0, p0, Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;->index:J

    cmp-long p2, v0, p2

    if-nez p2, :cond_18

    .line 548
    monitor-exit p0

    return-void

    .line 550
    :cond_18
    iget-boolean p2, p0, Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;->emitting:Z

    if-eqz p2, :cond_2d

    .line 551
    iget-object p2, p0, Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;->queue:Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;

    if-nez p2, :cond_28

    .line 553
    new-instance p2, Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;

    const/4 p3, 0x4

    invoke-direct {p2, p3}, Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;-><init>(I)V

    .line 554
    iput-object p2, p0, Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;->queue:Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;

    .line 556
    :cond_28
    invoke-virtual {p2, p1}, Lio/reactivex/internal/util/AppendOnlyLinkedArrayList;->add(Ljava/lang/Object;)V

    .line 557
    monitor-exit p0

    return-void

    :cond_2d
    const/4 p2, 0x1

    .line 559
    iput-boolean p2, p0, Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;->next:Z

    .line 560
    monitor-exit p0
    :try_end_31
    .catchall {:try_start_a .. :try_end_31} :catchall_34

    .line 561
    iput-boolean p2, p0, Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;->fastPath:Z

    goto :goto_37

    :catchall_34
    move-exception p1

    .line 560
    :try_start_35
    monitor-exit p0
    :try_end_36
    .catchall {:try_start_35 .. :try_end_36} :catchall_34

    throw p1

    .line 564
    :cond_37
    :goto_37
    invoke-virtual {p0, p1}, Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;->test(Ljava/lang/Object;)Z

    return-void
.end method

.method public isDisposed()Z
    .registers 2

    .line 501
    iget-boolean v0, p0, Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;->cancelled:Z

    return v0
.end method

.method public test(Ljava/lang/Object;)Z
    .registers 3

    .line 569
    iget-boolean v0, p0, Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;->cancelled:Z

    if-nez v0, :cond_f

    iget-object v0, p0, Lio/reactivex/subjects/BehaviorSubject$BehaviorDisposable;->downstream:Lio/reactivex/Observer;

    invoke-static {p1, v0}, Lio/reactivex/internal/util/NotificationLite;->accept(Ljava/lang/Object;Lio/reactivex/Observer;)Z

    move-result p1

    if-eqz p1, :cond_d

    goto :goto_f

    :cond_d
    const/4 p1, 0x0

    goto :goto_10

    :cond_f
    :goto_f
    const/4 p1, 0x1

    :goto_10
    return p1
.end method
