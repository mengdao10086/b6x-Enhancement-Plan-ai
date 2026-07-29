.class final Lio/reactivex/internal/operators/observable/ObservablePublishAlt$PublishConnection;
.super Ljava/util/concurrent/atomic/AtomicReference;
.source "ObservablePublishAlt.java"

# interfaces
.implements Lio/reactivex/Observer;
.implements Lio/reactivex/disposables/Disposable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/observable/ObservablePublishAlt;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "PublishConnection"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/util/concurrent/atomic/AtomicReference<",
        "[",
        "Lio/reactivex/internal/operators/observable/ObservablePublishAlt$InnerDisposable<",
        "TT;>;>;",
        "Lio/reactivex/Observer<",
        "TT;>;",
        "Lio/reactivex/disposables/Disposable;"
    }
.end annotation


# static fields
.field static final EMPTY:[Lio/reactivex/internal/operators/observable/ObservablePublishAlt$InnerDisposable;

.field static final TERMINATED:[Lio/reactivex/internal/operators/observable/ObservablePublishAlt$InnerDisposable;

.field private static final serialVersionUID:J = -0x2d1f6696927d02d4L


# instance fields
.field final connect:Ljava/util/concurrent/atomic/AtomicBoolean;

.field final current:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference<",
            "Lio/reactivex/internal/operators/observable/ObservablePublishAlt$PublishConnection<",
            "TT;>;>;"
        }
    .end annotation
.end field

.field error:Ljava/lang/Throwable;

.field final upstream:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference<",
            "Lio/reactivex/disposables/Disposable;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 2

    const/4 v0, 0x0

    new-array v1, v0, [Lio/reactivex/internal/operators/observable/ObservablePublishAlt$InnerDisposable;

    sput-object v1, Lio/reactivex/internal/operators/observable/ObservablePublishAlt$PublishConnection;->EMPTY:[Lio/reactivex/internal/operators/observable/ObservablePublishAlt$InnerDisposable;

    new-array v0, v0, [Lio/reactivex/internal/operators/observable/ObservablePublishAlt$InnerDisposable;

    sput-object v0, Lio/reactivex/internal/operators/observable/ObservablePublishAlt$PublishConnection;->TERMINATED:[Lio/reactivex/internal/operators/observable/ObservablePublishAlt$InnerDisposable;

    return-void
.end method

.method constructor <init>(Ljava/util/concurrent/atomic/AtomicReference;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/concurrent/atomic/AtomicReference<",
            "Lio/reactivex/internal/operators/observable/ObservablePublishAlt$PublishConnection<",
            "TT;>;>;)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>()V

    iput-object v0, p0, Lio/reactivex/internal/operators/observable/ObservablePublishAlt$PublishConnection;->connect:Ljava/util/concurrent/atomic/AtomicBoolean;

    iput-object p1, p0, Lio/reactivex/internal/operators/observable/ObservablePublishAlt$PublishConnection;->current:Ljava/util/concurrent/atomic/AtomicReference;

    new-instance p1, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/observable/ObservablePublishAlt$PublishConnection;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    sget-object p1, Lio/reactivex/internal/operators/observable/ObservablePublishAlt$PublishConnection;->EMPTY:[Lio/reactivex/internal/operators/observable/ObservablePublishAlt$InnerDisposable;

    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/observable/ObservablePublishAlt$PublishConnection;->lazySet(Ljava/lang/Object;)V

    return-void
.end method


# virtual methods
.method public add(Lio/reactivex/internal/operators/observable/ObservablePublishAlt$InnerDisposable;)Z
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/internal/operators/observable/ObservablePublishAlt$InnerDisposable<",
            "TT;>;)Z"
        }
    .end annotation

    :cond_0
    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservablePublishAlt$PublishConnection;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lio/reactivex/internal/operators/observable/ObservablePublishAlt$InnerDisposable;

    sget-object v1, Lio/reactivex/internal/operators/observable/ObservablePublishAlt$PublishConnection;->TERMINATED:[Lio/reactivex/internal/operators/observable/ObservablePublishAlt$InnerDisposable;

    const/4 v2, 0x0

    if-ne v0, v1, :cond_c

    return v2

    :cond_c
    array-length v1, v0

    add-int/lit8 v3, v1, 0x1

    new-array v3, v3, [Lio/reactivex/internal/operators/observable/ObservablePublishAlt$InnerDisposable;

    invoke-static {v0, v2, v3, v2, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    aput-object p1, v3, v1

    invoke-virtual {p0, v0, v3}, Lio/reactivex/internal/operators/observable/ObservablePublishAlt$PublishConnection;->compareAndSet(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 p1, 0x1

    return p1
.end method

.method public dispose()V
    .registers 3

    sget-object v0, Lio/reactivex/internal/operators/observable/ObservablePublishAlt$PublishConnection;->TERMINATED:[Lio/reactivex/internal/operators/observable/ObservablePublishAlt$InnerDisposable;

    invoke-virtual {p0, v0}, Lio/reactivex/internal/operators/observable/ObservablePublishAlt$PublishConnection;->getAndSet(Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservablePublishAlt$PublishConnection;->current:Ljava/util/concurrent/atomic/AtomicReference;

    const/4 v1, 0x0

    invoke-static {v0, p0, v1}, Landroidx/lifecycle/LifecycleKt$$ExternalSyntheticBackportWithForwarding0;->m(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Z

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservablePublishAlt$PublishConnection;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0}, Lio/reactivex/internal/disposables/DisposableHelper;->dispose(Ljava/util/concurrent/atomic/AtomicReference;)Z

    return-void
.end method

.method public isDisposed()Z
    .registers 3

    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservablePublishAlt$PublishConnection;->get()Ljava/lang/Object;

    move-result-object v0

    sget-object v1, Lio/reactivex/internal/operators/observable/ObservablePublishAlt$PublishConnection;->TERMINATED:[Lio/reactivex/internal/operators/observable/ObservablePublishAlt$InnerDisposable;

    if-ne v0, v1, :cond_a

    const/4 v0, 0x1

    goto :goto_b

    :cond_a
    const/4 v0, 0x0

    :goto_b
    return v0
.end method

.method public onComplete()V
    .registers 5

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservablePublishAlt$PublishConnection;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    sget-object v1, Lio/reactivex/internal/disposables/DisposableHelper;->DISPOSED:Lio/reactivex/internal/disposables/DisposableHelper;

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicReference;->lazySet(Ljava/lang/Object;)V

    sget-object v0, Lio/reactivex/internal/operators/observable/ObservablePublishAlt$PublishConnection;->TERMINATED:[Lio/reactivex/internal/operators/observable/ObservablePublishAlt$InnerDisposable;

    invoke-virtual {p0, v0}, Lio/reactivex/internal/operators/observable/ObservablePublishAlt$PublishConnection;->getAndSet(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lio/reactivex/internal/operators/observable/ObservablePublishAlt$InnerDisposable;

    array-length v1, v0

    const/4 v2, 0x0

    :goto_11
    if-ge v2, v1, :cond_1d

    aget-object v3, v0, v2

    iget-object v3, v3, Lio/reactivex/internal/operators/observable/ObservablePublishAlt$InnerDisposable;->downstream:Lio/reactivex/Observer;

    invoke-interface {v3}, Lio/reactivex/Observer;->onComplete()V

    add-int/lit8 v2, v2, 0x1

    goto :goto_11

    :cond_1d
    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 6

    iput-object p1, p0, Lio/reactivex/internal/operators/observable/ObservablePublishAlt$PublishConnection;->error:Ljava/lang/Throwable;

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservablePublishAlt$PublishConnection;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    sget-object v1, Lio/reactivex/internal/disposables/DisposableHelper;->DISPOSED:Lio/reactivex/internal/disposables/DisposableHelper;

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicReference;->lazySet(Ljava/lang/Object;)V

    sget-object v0, Lio/reactivex/internal/operators/observable/ObservablePublishAlt$PublishConnection;->TERMINATED:[Lio/reactivex/internal/operators/observable/ObservablePublishAlt$InnerDisposable;

    invoke-virtual {p0, v0}, Lio/reactivex/internal/operators/observable/ObservablePublishAlt$PublishConnection;->getAndSet(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lio/reactivex/internal/operators/observable/ObservablePublishAlt$InnerDisposable;

    array-length v1, v0

    const/4 v2, 0x0

    :goto_13
    if-ge v2, v1, :cond_1f

    aget-object v3, v0, v2

    iget-object v3, v3, Lio/reactivex/internal/operators/observable/ObservablePublishAlt$InnerDisposable;->downstream:Lio/reactivex/Observer;

    invoke-interface {v3, p1}, Lio/reactivex/Observer;->onError(Ljava/lang/Throwable;)V

    add-int/lit8 v2, v2, 0x1

    goto :goto_13

    :cond_1f
    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservablePublishAlt$PublishConnection;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lio/reactivex/internal/operators/observable/ObservablePublishAlt$InnerDisposable;

    array-length v1, v0

    const/4 v2, 0x0

    :goto_8
    if-ge v2, v1, :cond_14

    aget-object v3, v0, v2

    iget-object v3, v3, Lio/reactivex/internal/operators/observable/ObservablePublishAlt$InnerDisposable;->downstream:Lio/reactivex/Observer;

    invoke-interface {v3, p1}, Lio/reactivex/Observer;->onNext(Ljava/lang/Object;)V

    add-int/lit8 v2, v2, 0x1

    goto :goto_8

    :cond_14
    return-void
.end method

.method public onSubscribe(Lio/reactivex/disposables/Disposable;)V
    .registers 3

    iget-object v0, p0, Lio/reactivex/internal/operators/observable/ObservablePublishAlt$PublishConnection;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0, p1}, Lio/reactivex/internal/disposables/DisposableHelper;->setOnce(Ljava/util/concurrent/atomic/AtomicReference;Lio/reactivex/disposables/Disposable;)Z

    return-void
.end method

.method public remove(Lio/reactivex/internal/operators/observable/ObservablePublishAlt$InnerDisposable;)V
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/internal/operators/observable/ObservablePublishAlt$InnerDisposable<",
            "TT;>;)V"
        }
    .end annotation

    :cond_0
    invoke-virtual {p0}, Lio/reactivex/internal/operators/observable/ObservablePublishAlt$PublishConnection;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lio/reactivex/internal/operators/observable/ObservablePublishAlt$InnerDisposable;

    array-length v1, v0

    if-nez v1, :cond_a

    return-void

    :cond_a
    const/4 v2, 0x0

    move v3, v2

    :goto_c
    if-ge v3, v1, :cond_16

    aget-object v4, v0, v3

    if-ne v4, p1, :cond_13

    goto :goto_17

    :cond_13
    add-int/lit8 v3, v3, 0x1

    goto :goto_c

    :cond_16
    const/4 v3, -0x1

    :goto_17
    if-gez v3, :cond_1a

    return-void

    :cond_1a
    sget-object v4, Lio/reactivex/internal/operators/observable/ObservablePublishAlt$PublishConnection;->EMPTY:[Lio/reactivex/internal/operators/observable/ObservablePublishAlt$InnerDisposable;

    const/4 v5, 0x1

    if-eq v1, v5, :cond_2d

    add-int/lit8 v4, v1, -0x1

    new-array v4, v4, [Lio/reactivex/internal/operators/observable/ObservablePublishAlt$InnerDisposable;

    invoke-static {v0, v2, v4, v2, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    add-int/lit8 v2, v3, 0x1

    sub-int/2addr v1, v3

    sub-int/2addr v1, v5

    invoke-static {v0, v2, v4, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    :cond_2d
    invoke-virtual {p0, v0, v4}, Lio/reactivex/internal/operators/observable/ObservablePublishAlt$PublishConnection;->compareAndSet(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    return-void
.end method
