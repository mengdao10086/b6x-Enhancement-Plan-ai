.class final Lio/reactivex/subjects/ReplaySubject$UnboundedReplayBuffer;
.super Ljava/util/concurrent/atomic/AtomicReference;
.source "ReplaySubject.java"

# interfaces
.implements Lio/reactivex/subjects/ReplaySubject$ReplayBuffer;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/subjects/ReplaySubject;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "UnboundedReplayBuffer"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/util/concurrent/atomic/AtomicReference<",
        "Ljava/lang/Object;",
        ">;",
        "Lio/reactivex/subjects/ReplaySubject$ReplayBuffer<",
        "TT;>;"
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = -0xa2f4068c73be4b3L


# instance fields
.field final buffer:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field volatile done:Z

.field volatile size:I


# direct methods
.method constructor <init>(I)V
    .registers 4

    invoke-direct {p0}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    new-instance v0, Ljava/util/ArrayList;

    const-string v1, "capacityHint"

    invoke-static {p1, v1}, Lio/reactivex/internal/functions/ObjectHelper;->verifyPositive(ILjava/lang/String;)I

    move-result p1

    invoke-direct {v0, p1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lio/reactivex/subjects/ReplaySubject$UnboundedReplayBuffer;->buffer:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public add(Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    iget-object v0, p0, Lio/reactivex/subjects/ReplaySubject$UnboundedReplayBuffer;->buffer:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget p1, p0, Lio/reactivex/subjects/ReplaySubject$UnboundedReplayBuffer;->size:I

    add-int/lit8 p1, p1, 0x1

    iput p1, p0, Lio/reactivex/subjects/ReplaySubject$UnboundedReplayBuffer;->size:I

    return-void
.end method

.method public addFinal(Ljava/lang/Object;)V
    .registers 3

    iget-object v0, p0, Lio/reactivex/subjects/ReplaySubject$UnboundedReplayBuffer;->buffer:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    invoke-virtual {p0}, Lio/reactivex/subjects/ReplaySubject$UnboundedReplayBuffer;->trimHead()V

    iget p1, p0, Lio/reactivex/subjects/ReplaySubject$UnboundedReplayBuffer;->size:I

    const/4 v0, 0x1

    add-int/2addr p1, v0

    iput p1, p0, Lio/reactivex/subjects/ReplaySubject$UnboundedReplayBuffer;->size:I

    iput-boolean v0, p0, Lio/reactivex/subjects/ReplaySubject$UnboundedReplayBuffer;->done:Z

    return-void
.end method

.method public getValue()Ljava/lang/Object;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    iget v0, p0, Lio/reactivex/subjects/ReplaySubject$UnboundedReplayBuffer;->size:I

    const/4 v1, 0x0

    if-eqz v0, :cond_26

    iget-object v2, p0, Lio/reactivex/subjects/ReplaySubject$UnboundedReplayBuffer;->buffer:Ljava/util/List;

    add-int/lit8 v3, v0, -0x1

    invoke-interface {v2, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    invoke-static {v3}, Lio/reactivex/internal/util/NotificationLite;->isComplete(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_1b

    invoke-static {v3}, Lio/reactivex/internal/util/NotificationLite;->isError(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1a

    goto :goto_1b

    :cond_1a
    return-object v3

    :cond_1b
    :goto_1b
    const/4 v3, 0x1

    if-ne v0, v3, :cond_1f

    return-object v1

    :cond_1f
    add-int/lit8 v0, v0, -0x2

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0

    :cond_26
    return-object v1
.end method

.method public getValues([Ljava/lang/Object;)[Ljava/lang/Object;
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([TT;)[TT;"
        }
    .end annotation

    iget v0, p0, Lio/reactivex/subjects/ReplaySubject$UnboundedReplayBuffer;->size:I

    const/4 v1, 0x0

    const/4 v2, 0x0

    if-nez v0, :cond_c

    array-length v0, p1

    if-eqz v0, :cond_b

    aput-object v1, p1, v2

    :cond_b
    return-object p1

    :cond_c
    iget-object v3, p0, Lio/reactivex/subjects/ReplaySubject$UnboundedReplayBuffer;->buffer:Ljava/util/List;

    add-int/lit8 v4, v0, -0x1

    invoke-interface {v3, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    invoke-static {v4}, Lio/reactivex/internal/util/NotificationLite;->isComplete(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_20

    invoke-static {v4}, Lio/reactivex/internal/util/NotificationLite;->isError(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2a

    :cond_20
    add-int/lit8 v0, v0, -0x1

    if-nez v0, :cond_2a

    array-length v0, p1

    if-eqz v0, :cond_29

    aput-object v1, p1, v2

    :cond_29
    return-object p1

    :cond_2a
    array-length v4, p1

    if-ge v4, v0, :cond_3d

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object p1

    invoke-static {p1, v0}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, [Ljava/lang/Object;

    check-cast p1, [Ljava/lang/Object;

    :cond_3d
    :goto_3d
    if-ge v2, v0, :cond_48

    invoke-interface {v3, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    aput-object v4, p1, v2

    add-int/lit8 v2, v2, 0x1

    goto :goto_3d

    :cond_48
    array-length v2, p1

    if-le v2, v0, :cond_4d

    aput-object v1, p1, v0

    :cond_4d
    return-object p1
.end method

.method public replay(Lio/reactivex/subjects/ReplaySubject$ReplayDisposable;)V
    .registers 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/subjects/ReplaySubject$ReplayDisposable<",
            "TT;>;)V"
        }
    .end annotation

    invoke-virtual {p1}, Lio/reactivex/subjects/ReplaySubject$ReplayDisposable;->getAndIncrement()I

    move-result v0

    if-eqz v0, :cond_7

    return-void

    :cond_7
    iget-object v0, p0, Lio/reactivex/subjects/ReplaySubject$UnboundedReplayBuffer;->buffer:Ljava/util/List;

    iget-object v1, p1, Lio/reactivex/subjects/ReplaySubject$ReplayDisposable;->downstream:Lio/reactivex/Observer;

    iget-object v2, p1, Lio/reactivex/subjects/ReplaySubject$ReplayDisposable;->index:Ljava/lang/Object;

    check-cast v2, Ljava/lang/Integer;

    const/4 v3, 0x1

    if-eqz v2, :cond_17

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    goto :goto_1e

    :cond_17
    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    iput-object v4, p1, Lio/reactivex/subjects/ReplaySubject$ReplayDisposable;->index:Ljava/lang/Object;

    :goto_1e
    move v4, v3

    :cond_1f
    :goto_1f
    iget-boolean v5, p1, Lio/reactivex/subjects/ReplaySubject$ReplayDisposable;->cancelled:Z

    const/4 v6, 0x0

    if-eqz v5, :cond_27

    iput-object v6, p1, Lio/reactivex/subjects/ReplaySubject$ReplayDisposable;->index:Ljava/lang/Object;

    return-void

    :cond_27
    iget v5, p0, Lio/reactivex/subjects/ReplaySubject$UnboundedReplayBuffer;->size:I

    :goto_29
    if-eq v5, v2, :cond_5e

    iget-boolean v7, p1, Lio/reactivex/subjects/ReplaySubject$ReplayDisposable;->cancelled:Z

    if-eqz v7, :cond_32

    iput-object v6, p1, Lio/reactivex/subjects/ReplaySubject$ReplayDisposable;->index:Ljava/lang/Object;

    return-void

    :cond_32
    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    iget-boolean v8, p0, Lio/reactivex/subjects/ReplaySubject$UnboundedReplayBuffer;->done:Z

    if-eqz v8, :cond_58

    add-int/lit8 v8, v2, 0x1

    if-ne v8, v5, :cond_58

    iget v5, p0, Lio/reactivex/subjects/ReplaySubject$UnboundedReplayBuffer;->size:I

    if-ne v8, v5, :cond_58

    invoke-static {v7}, Lio/reactivex/internal/util/NotificationLite;->isComplete(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4c

    invoke-interface {v1}, Lio/reactivex/Observer;->onComplete()V

    goto :goto_53

    :cond_4c
    invoke-static {v7}, Lio/reactivex/internal/util/NotificationLite;->getError(Ljava/lang/Object;)Ljava/lang/Throwable;

    move-result-object v0

    invoke-interface {v1, v0}, Lio/reactivex/Observer;->onError(Ljava/lang/Throwable;)V

    :goto_53
    iput-object v6, p1, Lio/reactivex/subjects/ReplaySubject$ReplayDisposable;->index:Ljava/lang/Object;

    iput-boolean v3, p1, Lio/reactivex/subjects/ReplaySubject$ReplayDisposable;->cancelled:Z

    return-void

    :cond_58
    invoke-interface {v1, v7}, Lio/reactivex/Observer;->onNext(Ljava/lang/Object;)V

    add-int/lit8 v2, v2, 0x1

    goto :goto_29

    :cond_5e
    iget v5, p0, Lio/reactivex/subjects/ReplaySubject$UnboundedReplayBuffer;->size:I

    if-eq v2, v5, :cond_63

    goto :goto_1f

    :cond_63
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    iput-object v5, p1, Lio/reactivex/subjects/ReplaySubject$ReplayDisposable;->index:Ljava/lang/Object;

    neg-int v4, v4

    invoke-virtual {p1, v4}, Lio/reactivex/subjects/ReplaySubject$ReplayDisposable;->addAndGet(I)I

    move-result v4

    if-nez v4, :cond_1f

    return-void
.end method

.method public size()I
    .registers 5

    iget v0, p0, Lio/reactivex/subjects/ReplaySubject$UnboundedReplayBuffer;->size:I

    if-eqz v0, :cond_1b

    iget-object v1, p0, Lio/reactivex/subjects/ReplaySubject$UnboundedReplayBuffer;->buffer:Ljava/util/List;

    add-int/lit8 v2, v0, -0x1

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    invoke-static {v1}, Lio/reactivex/internal/util/NotificationLite;->isComplete(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1a

    invoke-static {v1}, Lio/reactivex/internal/util/NotificationLite;->isError(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_19

    goto :goto_1a

    :cond_19
    return v0

    :cond_1a
    :goto_1a
    return v2

    :cond_1b
    const/4 v0, 0x0

    return v0
.end method

.method public trimHead()V
    .registers 1

    return-void
.end method
