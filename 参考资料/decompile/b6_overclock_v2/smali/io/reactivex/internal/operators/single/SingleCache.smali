.class public final Lio/reactivex/internal/operators/single/SingleCache;
.super Lio/reactivex/Single;
.source "SingleCache.java"

# interfaces
.implements Lio/reactivex/SingleObserver;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lio/reactivex/Single<",
        "TT;>;",
        "Lio/reactivex/SingleObserver<",
        "TT;>;"
    }
.end annotation


# static fields
.field static final EMPTY:[Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable;

.field static final TERMINATED:[Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable;


# instance fields
.field error:Ljava/lang/Throwable;

.field final observers:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference<",
            "[",
            "Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable<",
            "TT;>;>;"
        }
    .end annotation
.end field

.field final source:Lio/reactivex/SingleSource;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/SingleSource<",
            "+TT;>;"
        }
    .end annotation
.end field

.field value:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field

.field final wip:Ljava/util/concurrent/atomic/AtomicInteger;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    const/4 v0, 0x0

    new-array v1, v0, [Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable;

    sput-object v1, Lio/reactivex/internal/operators/single/SingleCache;->EMPTY:[Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable;

    new-array v0, v0, [Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable;

    sput-object v0, Lio/reactivex/internal/operators/single/SingleCache;->TERMINATED:[Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable;

    return-void
.end method

.method public constructor <init>(Lio/reactivex/SingleSource;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/SingleSource<",
            "+TT;>;)V"
        }
    .end annotation

    invoke-direct {p0}, Lio/reactivex/Single;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/single/SingleCache;->source:Lio/reactivex/SingleSource;

    new-instance p1, Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/single/SingleCache;->wip:Ljava/util/concurrent/atomic/AtomicInteger;

    new-instance p1, Ljava/util/concurrent/atomic/AtomicReference;

    sget-object v0, Lio/reactivex/internal/operators/single/SingleCache;->EMPTY:[Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable;

    invoke-direct {p1, v0}, Ljava/util/concurrent/atomic/AtomicReference;-><init>(Ljava/lang/Object;)V

    iput-object p1, p0, Lio/reactivex/internal/operators/single/SingleCache;->observers:Ljava/util/concurrent/atomic/AtomicReference;

    return-void
.end method


# virtual methods
.method add(Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable;)Z
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable<",
            "TT;>;)Z"
        }
    .end annotation

    :cond_0
    iget-object v0, p0, Lio/reactivex/internal/operators/single/SingleCache;->observers:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable;

    sget-object v1, Lio/reactivex/internal/operators/single/SingleCache;->TERMINATED:[Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable;

    const/4 v2, 0x0

    if-ne v0, v1, :cond_e

    return v2

    :cond_e
    array-length v1, v0

    add-int/lit8 v3, v1, 0x1

    new-array v3, v3, [Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable;

    invoke-static {v0, v2, v3, v2, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    aput-object p1, v3, v1

    iget-object v1, p0, Lio/reactivex/internal/operators/single/SingleCache;->observers:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v1, v0, v3}, Landroidx/lifecycle/LifecycleKt$$ExternalSyntheticBackportWithForwarding0;->m(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 p1, 0x1

    return p1
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 7

    iput-object p1, p0, Lio/reactivex/internal/operators/single/SingleCache;->error:Ljava/lang/Throwable;

    iget-object v0, p0, Lio/reactivex/internal/operators/single/SingleCache;->observers:Ljava/util/concurrent/atomic/AtomicReference;

    sget-object v1, Lio/reactivex/internal/operators/single/SingleCache;->TERMINATED:[Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable;

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicReference;->getAndSet(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable;

    array-length v1, v0

    const/4 v2, 0x0

    :goto_e
    if-ge v2, v1, :cond_20

    aget-object v3, v0, v2

    invoke-virtual {v3}, Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable;->isDisposed()Z

    move-result v4

    if-nez v4, :cond_1d

    iget-object v3, v3, Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable;->downstream:Lio/reactivex/SingleObserver;

    invoke-interface {v3, p1}, Lio/reactivex/SingleObserver;->onError(Ljava/lang/Throwable;)V

    :cond_1d
    add-int/lit8 v2, v2, 0x1

    goto :goto_e

    :cond_20
    return-void
.end method

.method public onSubscribe(Lio/reactivex/disposables/Disposable;)V
    .registers 2

    return-void
.end method

.method public onSuccess(Ljava/lang/Object;)V
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    iput-object p1, p0, Lio/reactivex/internal/operators/single/SingleCache;->value:Ljava/lang/Object;

    iget-object v0, p0, Lio/reactivex/internal/operators/single/SingleCache;->observers:Ljava/util/concurrent/atomic/AtomicReference;

    sget-object v1, Lio/reactivex/internal/operators/single/SingleCache;->TERMINATED:[Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable;

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicReference;->getAndSet(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable;

    array-length v1, v0

    const/4 v2, 0x0

    :goto_e
    if-ge v2, v1, :cond_20

    aget-object v3, v0, v2

    invoke-virtual {v3}, Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable;->isDisposed()Z

    move-result v4

    if-nez v4, :cond_1d

    iget-object v3, v3, Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable;->downstream:Lio/reactivex/SingleObserver;

    invoke-interface {v3, p1}, Lio/reactivex/SingleObserver;->onSuccess(Ljava/lang/Object;)V

    :cond_1d
    add-int/lit8 v2, v2, 0x1

    goto :goto_e

    :cond_20
    return-void
.end method

.method remove(Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable;)V
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable<",
            "TT;>;)V"
        }
    .end annotation

    :cond_0
    iget-object v0, p0, Lio/reactivex/internal/operators/single/SingleCache;->observers:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable;

    array-length v1, v0

    if-nez v1, :cond_c

    return-void

    :cond_c
    const/4 v2, 0x0

    move v3, v2

    :goto_e
    if-ge v3, v1, :cond_18

    aget-object v4, v0, v3

    if-ne v4, p1, :cond_15

    goto :goto_19

    :cond_15
    add-int/lit8 v3, v3, 0x1

    goto :goto_e

    :cond_18
    const/4 v3, -0x1

    :goto_19
    if-gez v3, :cond_1c

    return-void

    :cond_1c
    const/4 v4, 0x1

    if-ne v1, v4, :cond_22

    sget-object v1, Lio/reactivex/internal/operators/single/SingleCache;->EMPTY:[Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable;

    goto :goto_31

    :cond_22
    add-int/lit8 v5, v1, -0x1

    new-array v5, v5, [Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable;

    invoke-static {v0, v2, v5, v2, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    add-int/lit8 v2, v3, 0x1

    sub-int/2addr v1, v3

    sub-int/2addr v1, v4

    invoke-static {v0, v2, v5, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    move-object v1, v5

    :goto_31
    iget-object v2, p0, Lio/reactivex/internal/operators/single/SingleCache;->observers:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v2, v0, v1}, Landroidx/lifecycle/LifecycleKt$$ExternalSyntheticBackportWithForwarding0;->m(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    return-void
.end method

.method protected subscribeActual(Lio/reactivex/SingleObserver;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/SingleObserver<",
            "-TT;>;)V"
        }
    .end annotation

    new-instance v0, Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable;

    invoke-direct {v0, p1, p0}, Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable;-><init>(Lio/reactivex/SingleObserver;Lio/reactivex/internal/operators/single/SingleCache;)V

    invoke-interface {p1, v0}, Lio/reactivex/SingleObserver;->onSubscribe(Lio/reactivex/disposables/Disposable;)V

    invoke-virtual {p0, v0}, Lio/reactivex/internal/operators/single/SingleCache;->add(Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable;)Z

    move-result v1

    if-eqz v1, :cond_25

    invoke-virtual {v0}, Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable;->isDisposed()Z

    move-result p1

    if-eqz p1, :cond_17

    invoke-virtual {p0, v0}, Lio/reactivex/internal/operators/single/SingleCache;->remove(Lio/reactivex/internal/operators/single/SingleCache$CacheDisposable;)V

    :cond_17
    iget-object p1, p0, Lio/reactivex/internal/operators/single/SingleCache;->wip:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {p1}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndIncrement()I

    move-result p1

    if-nez p1, :cond_24

    iget-object p1, p0, Lio/reactivex/internal/operators/single/SingleCache;->source:Lio/reactivex/SingleSource;

    invoke-interface {p1, p0}, Lio/reactivex/SingleSource;->subscribe(Lio/reactivex/SingleObserver;)V

    :cond_24
    return-void

    :cond_25
    iget-object v0, p0, Lio/reactivex/internal/operators/single/SingleCache;->error:Ljava/lang/Throwable;

    if-eqz v0, :cond_2d

    invoke-interface {p1, v0}, Lio/reactivex/SingleObserver;->onError(Ljava/lang/Throwable;)V

    goto :goto_32

    :cond_2d
    iget-object v0, p0, Lio/reactivex/internal/operators/single/SingleCache;->value:Ljava/lang/Object;

    invoke-interface {p1, v0}, Lio/reactivex/SingleObserver;->onSuccess(Ljava/lang/Object;)V

    :goto_32
    return-void
.end method
