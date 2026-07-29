.class public final Lio/reactivex/internal/operators/observable/ObservableRefCount;
.super Lio/reactivex/Observable;
.source "ObservableRefCount.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/reactivex/internal/operators/observable/ObservableRefCount$RefCountObserver;,
        Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;
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
.field connection:Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;

.field final n:I

.field final scheduler:Lio/reactivex/Scheduler;

.field final source:Lio/reactivex/observables/ConnectableObservable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/observables/ConnectableObservable<",
            "TT;>;"
        }
    .end annotation
.end field

.field final timeout:J

.field final unit:Ljava/util/concurrent/TimeUnit;


# direct methods
.method public constructor <init>(Lio/reactivex/observables/ConnectableObservable;)V
    .registers 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/observables/ConnectableObservable<",
            "TT;>;)V"
        }
    .end annotation

    const/4 v2, 0x1

    const-wide/16 v3, 0x0

    .line 48
    sget-object v5, Ljava/util/concurrent/TimeUnit;->NANOSECONDS:Ljava/util/concurrent/TimeUnit;

    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p1

    invoke-direct/range {v0 .. v6}, Lio/reactivex/internal/operators/observable/ObservableRefCount;-><init>(Lio/reactivex/observables/ConnectableObservable;IJLjava/util/concurrent/TimeUnit;Lio/reactivex/Scheduler;)V

    return-void
.end method

.method public constructor <init>(Lio/reactivex/observables/ConnectableObservable;IJLjava/util/concurrent/TimeUnit;Lio/reactivex/Scheduler;)V
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/observables/ConnectableObservable<",
            "TT;>;IJ",
            "Ljava/util/concurrent/TimeUnit;",
            "Lio/reactivex/Scheduler;",
            ")V"
        }
    .end annotation

    .line 52
    invoke-direct {p0}, Lio/reactivex/Observable;-><init>()V

    .line 53
    iput-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableRefCount;->source:Lio/reactivex/observables/ConnectableObservable;

    .line 54
    iput p2, p0, Lio/reactivex/internal/operators/observable/ObservableRefCount;->n:I

    .line 55
    iput-wide p3, p0, Lio/reactivex/internal/operators/observable/ObservableRefCount;->timeout:J

    .line 56
    iput-object p5, p0, Lio/reactivex/internal/operators/observable/ObservableRefCount;->unit:Ljava/util/concurrent/TimeUnit;

    .line 57
    iput-object p6, p0, Lio/reactivex/internal/operators/observable/ObservableRefCount;->scheduler:Lio/reactivex/Scheduler;

    return-void
.end method


# virtual methods
.method cancel(Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;)V
    .registers 7

    .line 93
    monitor-enter p0

    .line 94
    :try_start_1
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableRefCount;->connection:Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;

    if-eqz v0, :cond_3d

    if-eq v0, p1, :cond_8

    goto :goto_3d

    .line 97
    :cond_8
    iget-wide v0, p1, Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;->subscriberCount:J

    const-wide/16 v2, 0x1

    sub-long/2addr v0, v2

    .line 98
    iput-wide v0, p1, Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;->subscriberCount:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_3b

    .line 99
    iget-boolean v0, p1, Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;->connected:Z

    if-nez v0, :cond_1a

    goto :goto_3b

    .line 102
    :cond_1a
    iget-wide v0, p0, Lio/reactivex/internal/operators/observable/ObservableRefCount;->timeout:J

    cmp-long v0, v0, v2

    if-nez v0, :cond_25

    .line 103
    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/observable/ObservableRefCount;->timeout(Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;)V

    .line 104
    monitor-exit p0

    return-void

    .line 106
    :cond_25
    new-instance v0, Lio/reactivex/internal/disposables/SequentialDisposable;

    invoke-direct {v0}, Lio/reactivex/internal/disposables/SequentialDisposable;-><init>()V

    .line 107
    iput-object v0, p1, Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;->timer:Lio/reactivex/disposables/Disposable;

    .line 108
    monitor-exit p0
    :try_end_2d
    .catchall {:try_start_1 .. :try_end_2d} :catchall_3f

    .line 110
    iget-object v1, p0, Lio/reactivex/internal/operators/observable/ObservableRefCount;->scheduler:Lio/reactivex/Scheduler;

    iget-wide v2, p0, Lio/reactivex/internal/operators/observable/ObservableRefCount;->timeout:J

    iget-object v4, p0, Lio/reactivex/internal/operators/observable/ObservableRefCount;->unit:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v1, p1, v2, v3, v4}, Lio/reactivex/Scheduler;->scheduleDirect(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Lio/reactivex/disposables/Disposable;

    move-result-object p1

    invoke-virtual {v0, p1}, Lio/reactivex/internal/disposables/SequentialDisposable;->replace(Lio/reactivex/disposables/Disposable;)Z

    return-void

    .line 100
    :cond_3b
    :goto_3b
    :try_start_3b
    monitor-exit p0

    return-void

    .line 95
    :cond_3d
    :goto_3d
    monitor-exit p0

    return-void

    :catchall_3f
    move-exception p1

    .line 108
    monitor-exit p0
    :try_end_41
    .catchall {:try_start_3b .. :try_end_41} :catchall_3f

    throw p1
.end method

.method clearTimer(Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;)V
    .registers 3

    .line 137
    iget-object v0, p1, Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;->timer:Lio/reactivex/disposables/Disposable;

    if-eqz v0, :cond_c

    .line 138
    iget-object v0, p1, Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;->timer:Lio/reactivex/disposables/Disposable;

    invoke-interface {v0}, Lio/reactivex/disposables/Disposable;->dispose()V

    const/4 v0, 0x0

    .line 139
    iput-object v0, p1, Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;->timer:Lio/reactivex/disposables/Disposable;

    :cond_c
    return-void
.end method

.method reset(Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;)V
    .registers 4

    .line 144
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableRefCount;->source:Lio/reactivex/observables/ConnectableObservable;

    instance-of v1, v0, Lio/reactivex/disposables/Disposable;

    if-eqz v1, :cond_c

    .line 145
    check-cast v0, Lio/reactivex/disposables/Disposable;

    invoke-interface {v0}, Lio/reactivex/disposables/Disposable;->dispose()V

    goto :goto_1b

    .line 146
    :cond_c
    instance-of v1, v0, Lio/reactivex/internal/disposables/ResettableConnectable;

    if-eqz v1, :cond_1b

    .line 147
    check-cast v0, Lio/reactivex/internal/disposables/ResettableConnectable;

    invoke-virtual {p1}, Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;->get()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lio/reactivex/disposables/Disposable;

    invoke-interface {v0, p1}, Lio/reactivex/internal/disposables/ResettableConnectable;->resetIf(Lio/reactivex/disposables/Disposable;)V

    :cond_1b
    :goto_1b
    return-void
.end method

.method protected subscribeActual(Lio/reactivex/Observer;)V
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/Observer<",
            "-TT;>;)V"
        }
    .end annotation

    .line 66
    monitor-enter p0

    .line 67
    :try_start_1
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableRefCount;->connection:Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;

    if-nez v0, :cond_c

    .line 69
    new-instance v0, Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;

    invoke-direct {v0, p0}, Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;-><init>(Lio/reactivex/internal/operators/observable/ObservableRefCount;)V

    .line 70
    iput-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableRefCount;->connection:Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;

    .line 73
    :cond_c
    iget-wide v1, v0, Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;->subscriberCount:J

    const-wide/16 v3, 0x0

    cmp-long v3, v1, v3

    if-nez v3, :cond_1d

    .line 74
    iget-object v3, v0, Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;->timer:Lio/reactivex/disposables/Disposable;

    if-eqz v3, :cond_1d

    .line 75
    iget-object v3, v0, Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;->timer:Lio/reactivex/disposables/Disposable;

    invoke-interface {v3}, Lio/reactivex/disposables/Disposable;->dispose()V

    :cond_1d
    const-wide/16 v3, 0x1

    add-long/2addr v1, v3

    .line 77
    iput-wide v1, v0, Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;->subscriberCount:J

    .line 78
    iget-boolean v3, v0, Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;->connected:Z

    if-nez v3, :cond_31

    iget v3, p0, Lio/reactivex/internal/operators/observable/ObservableRefCount;->n:I

    int-to-long v3, v3

    cmp-long v1, v1, v3

    if-nez v1, :cond_31

    const/4 v1, 0x1

    .line 80
    iput-boolean v1, v0, Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;->connected:Z

    goto :goto_32

    :cond_31
    const/4 v1, 0x0

    .line 82
    :goto_32
    monitor-exit p0
    :try_end_33
    .catchall {:try_start_1 .. :try_end_33} :catchall_45

    .line 84
    iget-object v2, p0, Lio/reactivex/internal/operators/observable/ObservableRefCount;->source:Lio/reactivex/observables/ConnectableObservable;

    new-instance v3, Lio/reactivex/internal/operators/observable/ObservableRefCount$RefCountObserver;

    invoke-direct {v3, p1, p0, v0}, Lio/reactivex/internal/operators/observable/ObservableRefCount$RefCountObserver;-><init>(Lio/reactivex/Observer;Lio/reactivex/internal/operators/observable/ObservableRefCount;Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;)V

    invoke-virtual {v2, v3}, Lio/reactivex/observables/ConnectableObservable;->subscribe(Lio/reactivex/Observer;)V

    if-eqz v1, :cond_44

    .line 87
    iget-object p1, p0, Lio/reactivex/internal/operators/observable/ObservableRefCount;->source:Lio/reactivex/observables/ConnectableObservable;

    invoke-virtual {p1, v0}, Lio/reactivex/observables/ConnectableObservable;->connect(Lio/reactivex/functions/Consumer;)V

    :cond_44
    return-void

    :catchall_45
    move-exception p1

    .line 82
    :try_start_46
    monitor-exit p0
    :try_end_47
    .catchall {:try_start_46 .. :try_end_47} :catchall_45

    throw p1
.end method

.method terminated(Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;)V
    .registers 10

    .line 114
    monitor-enter p0

    .line 115
    :try_start_1
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableRefCount;->source:Lio/reactivex/observables/ConnectableObservable;

    instance-of v0, v0, Lio/reactivex/internal/operators/observable/ObservablePublishClassic;

    const/4 v1, 0x0

    const-wide/16 v2, 0x0

    const-wide/16 v4, 0x1

    if-eqz v0, :cond_24

    .line 116
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableRefCount;->connection:Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;

    if-eqz v0, :cond_17

    if-ne v0, p1, :cond_17

    .line 117
    iput-object v1, p0, Lio/reactivex/internal/operators/observable/ObservableRefCount;->connection:Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;

    .line 118
    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/observable/ObservableRefCount;->clearTimer(Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;)V

    .line 121
    :cond_17
    iget-wide v0, p1, Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;->subscriberCount:J

    sub-long/2addr v0, v4

    iput-wide v0, p1, Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;->subscriberCount:J

    cmp-long v0, v0, v2

    if-nez v0, :cond_3b

    .line 122
    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/observable/ObservableRefCount;->reset(Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;)V

    goto :goto_3b

    .line 125
    :cond_24
    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableRefCount;->connection:Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;

    if-eqz v0, :cond_3b

    if-ne v0, p1, :cond_3b

    .line 126
    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/observable/ObservableRefCount;->clearTimer(Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;)V

    .line 127
    iget-wide v6, p1, Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;->subscriberCount:J

    sub-long/2addr v6, v4

    iput-wide v6, p1, Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;->subscriberCount:J

    cmp-long v0, v6, v2

    if-nez v0, :cond_3b

    .line 128
    iput-object v1, p0, Lio/reactivex/internal/operators/observable/ObservableRefCount;->connection:Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;

    .line 129
    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/observable/ObservableRefCount;->reset(Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;)V

    .line 133
    :cond_3b
    :goto_3b
    monitor-exit p0

    return-void

    :catchall_3d
    move-exception p1

    monitor-exit p0
    :try_end_3f
    .catchall {:try_start_1 .. :try_end_3f} :catchall_3d

    throw p1
.end method

.method timeout(Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;)V
    .registers 6

    .line 152
    monitor-enter p0

    .line 153
    :try_start_1
    iget-wide v0, p1, Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;->subscriberCount:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_34

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableRefCount;->connection:Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;

    if-ne p1, v0, :cond_34

    const/4 v0, 0x0

    .line 154
    iput-object v0, p0, Lio/reactivex/internal/operators/observable/ObservableRefCount;->connection:Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;

    .line 155
    invoke-virtual {p1}, Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lio/reactivex/disposables/Disposable;

    .line 156
    invoke-static {p1}, Lio/reactivex/internal/disposables/DisposableHelper;->dispose(Ljava/util/concurrent/atomic/AtomicReference;)Z

    .line 158
    iget-object v1, p0, Lio/reactivex/internal/operators/observable/ObservableRefCount;->source:Lio/reactivex/observables/ConnectableObservable;

    instance-of v2, v1, Lio/reactivex/disposables/Disposable;

    if-eqz v2, :cond_25

    .line 159
    check-cast v1, Lio/reactivex/disposables/Disposable;

    invoke-interface {v1}, Lio/reactivex/disposables/Disposable;->dispose()V

    goto :goto_34

    .line 160
    :cond_25
    instance-of v2, v1, Lio/reactivex/internal/disposables/ResettableConnectable;

    if-eqz v2, :cond_34

    if-nez v0, :cond_2f

    const/4 v0, 0x1

    .line 162
    iput-boolean v0, p1, Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;->disconnectedEarly:Z

    goto :goto_34

    .line 164
    :cond_2f
    check-cast v1, Lio/reactivex/internal/disposables/ResettableConnectable;

    invoke-interface {v1, v0}, Lio/reactivex/internal/disposables/ResettableConnectable;->resetIf(Lio/reactivex/disposables/Disposable;)V

    .line 168
    :cond_34
    :goto_34
    monitor-exit p0

    return-void

    :catchall_36
    move-exception p1

    monitor-exit p0
    :try_end_38
    .catchall {:try_start_1 .. :try_end_38} :catchall_36

    throw p1
.end method
