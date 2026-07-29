.class final Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;
.super Ljava/lang/Object;
.source "ReplayProcessor.java"

# interfaces
.implements Lio/reactivex/processors/ReplayProcessor$ReplayBuffer;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/processors/ReplayProcessor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "SizeBoundReplayBuffer"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lio/reactivex/processors/ReplayProcessor$ReplayBuffer<",
        "TT;>;"
    }
.end annotation


# instance fields
.field volatile done:Z

.field error:Ljava/lang/Throwable;

.field volatile head:Lio/reactivex/processors/ReplayProcessor$Node;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/processors/ReplayProcessor$Node<",
            "TT;>;"
        }
    .end annotation
.end field

.field final maxSize:I

.field size:I

.field tail:Lio/reactivex/processors/ReplayProcessor$Node;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/processors/ReplayProcessor$Node<",
            "TT;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(I)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const-string v0, "maxSize"

    invoke-static {p1, v0}, Lio/reactivex/internal/functions/ObjectHelper;->verifyPositive(ILjava/lang/String;)I

    move-result p1

    iput p1, p0, Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;->maxSize:I

    new-instance p1, Lio/reactivex/processors/ReplayProcessor$Node;

    const/4 v0, 0x0

    invoke-direct {p1, v0}, Lio/reactivex/processors/ReplayProcessor$Node;-><init>(Ljava/lang/Object;)V

    iput-object p1, p0, Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;->tail:Lio/reactivex/processors/ReplayProcessor$Node;

    iput-object p1, p0, Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;->head:Lio/reactivex/processors/ReplayProcessor$Node;

    return-void
.end method


# virtual methods
.method public complete()V
    .registers 2

    invoke-virtual {p0}, Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;->trimHead()V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;->done:Z

    return-void
.end method

.method public error(Ljava/lang/Throwable;)V
    .registers 2

    iput-object p1, p0, Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;->error:Ljava/lang/Throwable;

    invoke-virtual {p0}, Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;->trimHead()V

    const/4 p1, 0x1

    iput-boolean p1, p0, Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;->done:Z

    return-void
.end method

.method public getError()Ljava/lang/Throwable;
    .registers 2

    iget-object v0, p0, Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;->error:Ljava/lang/Throwable;

    return-object v0
.end method

.method public getValue()Ljava/lang/Object;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    iget-object v0, p0, Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;->head:Lio/reactivex/processors/ReplayProcessor$Node;

    :goto_2
    invoke-virtual {v0}, Lio/reactivex/processors/ReplayProcessor$Node;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lio/reactivex/processors/ReplayProcessor$Node;

    if-nez v1, :cond_d

    iget-object v0, v0, Lio/reactivex/processors/ReplayProcessor$Node;->value:Ljava/lang/Object;

    return-object v0

    :cond_d
    move-object v0, v1

    goto :goto_2
.end method

.method public getValues([Ljava/lang/Object;)[Ljava/lang/Object;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([TT;)[TT;"
        }
    .end annotation

    iget-object v0, p0, Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;->head:Lio/reactivex/processors/ReplayProcessor$Node;

    const/4 v1, 0x0

    move-object v2, v0

    move v3, v1

    :goto_5
    invoke-virtual {v2}, Lio/reactivex/processors/ReplayProcessor$Node;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lio/reactivex/processors/ReplayProcessor$Node;

    if-nez v2, :cond_36

    array-length v2, p1

    if-ge v2, v3, :cond_20

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object p1

    invoke-static {p1, v3}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, [Ljava/lang/Object;

    check-cast p1, [Ljava/lang/Object;

    :cond_20
    :goto_20
    if-ge v1, v3, :cond_2f

    invoke-virtual {v0}, Lio/reactivex/processors/ReplayProcessor$Node;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lio/reactivex/processors/ReplayProcessor$Node;

    iget-object v2, v0, Lio/reactivex/processors/ReplayProcessor$Node;->value:Ljava/lang/Object;

    aput-object v2, p1, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_20

    :cond_2f
    array-length v0, p1

    if-le v0, v3, :cond_35

    const/4 v0, 0x0

    aput-object v0, p1, v3

    :cond_35
    return-object p1

    :cond_36
    add-int/lit8 v3, v3, 0x1

    goto :goto_5
.end method

.method public isDone()Z
    .registers 2

    iget-boolean v0, p0, Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;->done:Z

    return v0
.end method

.method public next(Ljava/lang/Object;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    new-instance v0, Lio/reactivex/processors/ReplayProcessor$Node;

    invoke-direct {v0, p1}, Lio/reactivex/processors/ReplayProcessor$Node;-><init>(Ljava/lang/Object;)V

    iget-object p1, p0, Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;->tail:Lio/reactivex/processors/ReplayProcessor$Node;

    iput-object v0, p0, Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;->tail:Lio/reactivex/processors/ReplayProcessor$Node;

    iget v1, p0, Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;->size:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;->size:I

    invoke-virtual {p1, v0}, Lio/reactivex/processors/ReplayProcessor$Node;->set(Ljava/lang/Object;)V

    invoke-virtual {p0}, Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;->trim()V

    return-void
.end method

.method public replay(Lio/reactivex/processors/ReplayProcessor$ReplaySubscription;)V
    .registers 15
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/processors/ReplayProcessor$ReplaySubscription<",
            "TT;>;)V"
        }
    .end annotation

    invoke-virtual {p1}, Lio/reactivex/processors/ReplayProcessor$ReplaySubscription;->getAndIncrement()I

    move-result v0

    if-eqz v0, :cond_7

    return-void

    :cond_7
    iget-object v0, p1, Lio/reactivex/processors/ReplayProcessor$ReplaySubscription;->downstream:Lorg/reactivestreams/Subscriber;

    iget-object v1, p1, Lio/reactivex/processors/ReplayProcessor$ReplaySubscription;->index:Ljava/lang/Object;

    check-cast v1, Lio/reactivex/processors/ReplayProcessor$Node;

    if-nez v1, :cond_11

    iget-object v1, p0, Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;->head:Lio/reactivex/processors/ReplayProcessor$Node;

    :cond_11
    iget-wide v2, p1, Lio/reactivex/processors/ReplayProcessor$ReplaySubscription;->emitted:J

    const/4 v4, 0x1

    move v5, v4

    :cond_15
    iget-object v6, p1, Lio/reactivex/processors/ReplayProcessor$ReplaySubscription;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v6}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v6

    :goto_1b
    cmp-long v8, v2, v6

    const/4 v9, 0x0

    if-eqz v8, :cond_55

    iget-boolean v10, p1, Lio/reactivex/processors/ReplayProcessor$ReplaySubscription;->cancelled:Z

    if-eqz v10, :cond_27

    iput-object v9, p1, Lio/reactivex/processors/ReplayProcessor$ReplaySubscription;->index:Ljava/lang/Object;

    return-void

    :cond_27
    iget-boolean v10, p0, Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;->done:Z

    invoke-virtual {v1}, Lio/reactivex/processors/ReplayProcessor$Node;->get()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Lio/reactivex/processors/ReplayProcessor$Node;

    if-nez v11, :cond_33

    move v12, v4

    goto :goto_34

    :cond_33
    const/4 v12, 0x0

    :goto_34
    if-eqz v10, :cond_48

    if-eqz v12, :cond_48

    iput-object v9, p1, Lio/reactivex/processors/ReplayProcessor$ReplaySubscription;->index:Ljava/lang/Object;

    iput-boolean v4, p1, Lio/reactivex/processors/ReplayProcessor$ReplaySubscription;->cancelled:Z

    iget-object p1, p0, Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;->error:Ljava/lang/Throwable;

    if-nez p1, :cond_44

    invoke-interface {v0}, Lorg/reactivestreams/Subscriber;->onComplete()V

    goto :goto_47

    :cond_44
    invoke-interface {v0, p1}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    :goto_47
    return-void

    :cond_48
    if-eqz v12, :cond_4b

    goto :goto_55

    :cond_4b
    iget-object v1, v11, Lio/reactivex/processors/ReplayProcessor$Node;->value:Ljava/lang/Object;

    invoke-interface {v0, v1}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    const-wide/16 v8, 0x1

    add-long/2addr v2, v8

    move-object v1, v11

    goto :goto_1b

    :cond_55
    :goto_55
    if-nez v8, :cond_78

    iget-boolean v6, p1, Lio/reactivex/processors/ReplayProcessor$ReplaySubscription;->cancelled:Z

    if-eqz v6, :cond_5e

    iput-object v9, p1, Lio/reactivex/processors/ReplayProcessor$ReplaySubscription;->index:Ljava/lang/Object;

    return-void

    :cond_5e
    iget-boolean v6, p0, Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;->done:Z

    if-eqz v6, :cond_78

    invoke-virtual {v1}, Lio/reactivex/processors/ReplayProcessor$Node;->get()Ljava/lang/Object;

    move-result-object v6

    if-nez v6, :cond_78

    iput-object v9, p1, Lio/reactivex/processors/ReplayProcessor$ReplaySubscription;->index:Ljava/lang/Object;

    iput-boolean v4, p1, Lio/reactivex/processors/ReplayProcessor$ReplaySubscription;->cancelled:Z

    iget-object p1, p0, Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;->error:Ljava/lang/Throwable;

    if-nez p1, :cond_74

    invoke-interface {v0}, Lorg/reactivestreams/Subscriber;->onComplete()V

    goto :goto_77

    :cond_74
    invoke-interface {v0, p1}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    :goto_77
    return-void

    :cond_78
    iput-object v1, p1, Lio/reactivex/processors/ReplayProcessor$ReplaySubscription;->index:Ljava/lang/Object;

    iput-wide v2, p1, Lio/reactivex/processors/ReplayProcessor$ReplaySubscription;->emitted:J

    neg-int v5, v5

    invoke-virtual {p1, v5}, Lio/reactivex/processors/ReplayProcessor$ReplaySubscription;->addAndGet(I)I

    move-result v5

    if-nez v5, :cond_15

    return-void
.end method

.method public size()I
    .registers 4

    iget-object v0, p0, Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;->head:Lio/reactivex/processors/ReplayProcessor$Node;

    const/4 v1, 0x0

    :goto_3
    const v2, 0x7fffffff

    if-eq v1, v2, :cond_14

    invoke-virtual {v0}, Lio/reactivex/processors/ReplayProcessor$Node;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lio/reactivex/processors/ReplayProcessor$Node;

    if-nez v0, :cond_11

    goto :goto_14

    :cond_11
    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    :cond_14
    :goto_14
    return v1
.end method

.method trim()V
    .registers 3

    iget v0, p0, Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;->size:I

    iget v1, p0, Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;->maxSize:I

    if-le v0, v1, :cond_14

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;->size:I

    iget-object v0, p0, Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;->head:Lio/reactivex/processors/ReplayProcessor$Node;

    invoke-virtual {v0}, Lio/reactivex/processors/ReplayProcessor$Node;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lio/reactivex/processors/ReplayProcessor$Node;

    iput-object v0, p0, Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;->head:Lio/reactivex/processors/ReplayProcessor$Node;

    :cond_14
    return-void
.end method

.method public trimHead()V
    .registers 3

    iget-object v0, p0, Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;->head:Lio/reactivex/processors/ReplayProcessor$Node;

    iget-object v0, v0, Lio/reactivex/processors/ReplayProcessor$Node;->value:Ljava/lang/Object;

    if-eqz v0, :cond_17

    new-instance v0, Lio/reactivex/processors/ReplayProcessor$Node;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lio/reactivex/processors/ReplayProcessor$Node;-><init>(Ljava/lang/Object;)V

    iget-object v1, p0, Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;->head:Lio/reactivex/processors/ReplayProcessor$Node;

    invoke-virtual {v1}, Lio/reactivex/processors/ReplayProcessor$Node;->get()Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Lio/reactivex/processors/ReplayProcessor$Node;->lazySet(Ljava/lang/Object;)V

    iput-object v0, p0, Lio/reactivex/processors/ReplayProcessor$SizeBoundReplayBuffer;->head:Lio/reactivex/processors/ReplayProcessor$Node;

    :cond_17
    return-void
.end method
