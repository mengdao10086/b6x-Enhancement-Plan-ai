.class final Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;
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
    name = "SizeAndTimeBoundReplayBuffer"
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

.field volatile head:Lio/reactivex/processors/ReplayProcessor$TimedNode;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/processors/ReplayProcessor$TimedNode<",
            "TT;>;"
        }
    .end annotation
.end field

.field final maxAge:J

.field final maxSize:I

.field final scheduler:Lio/reactivex/Scheduler;

.field size:I

.field tail:Lio/reactivex/processors/ReplayProcessor$TimedNode;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/processors/ReplayProcessor$TimedNode<",
            "TT;>;"
        }
    .end annotation
.end field

.field final unit:Ljava/util/concurrent/TimeUnit;


# direct methods
.method constructor <init>(IJLjava/util/concurrent/TimeUnit;Lio/reactivex/Scheduler;)V
    .registers 7

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const-string v0, "maxSize"

    invoke-static {p1, v0}, Lio/reactivex/internal/functions/ObjectHelper;->verifyPositive(ILjava/lang/String;)I

    move-result p1

    iput p1, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->maxSize:I

    const-string p1, "maxAge"

    invoke-static {p2, p3, p1}, Lio/reactivex/internal/functions/ObjectHelper;->verifyPositive(JLjava/lang/String;)J

    move-result-wide p1

    iput-wide p1, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->maxAge:J

    const-string p1, "unit is null"

    invoke-static {p4, p1}, Lio/reactivex/internal/functions/ObjectHelper;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/concurrent/TimeUnit;

    iput-object p1, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->unit:Ljava/util/concurrent/TimeUnit;

    const-string p1, "scheduler is null"

    invoke-static {p5, p1}, Lio/reactivex/internal/functions/ObjectHelper;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lio/reactivex/Scheduler;

    iput-object p1, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->scheduler:Lio/reactivex/Scheduler;

    new-instance p1, Lio/reactivex/processors/ReplayProcessor$TimedNode;

    const/4 p2, 0x0

    const-wide/16 p3, 0x0

    invoke-direct {p1, p2, p3, p4}, Lio/reactivex/processors/ReplayProcessor$TimedNode;-><init>(Ljava/lang/Object;J)V

    iput-object p1, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->tail:Lio/reactivex/processors/ReplayProcessor$TimedNode;

    iput-object p1, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->head:Lio/reactivex/processors/ReplayProcessor$TimedNode;

    return-void
.end method


# virtual methods
.method public complete()V
    .registers 2

    invoke-virtual {p0}, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->trimFinal()V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->done:Z

    return-void
.end method

.method public error(Ljava/lang/Throwable;)V
    .registers 2

    invoke-virtual {p0}, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->trimFinal()V

    iput-object p1, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->error:Ljava/lang/Throwable;

    const/4 p1, 0x1

    iput-boolean p1, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->done:Z

    return-void
.end method

.method public getError()Ljava/lang/Throwable;
    .registers 2

    iget-object v0, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->error:Ljava/lang/Throwable;

    return-object v0
.end method

.method getHead()Lio/reactivex/processors/ReplayProcessor$TimedNode;
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lio/reactivex/processors/ReplayProcessor$TimedNode<",
            "TT;>;"
        }
    .end annotation

    iget-object v0, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->head:Lio/reactivex/processors/ReplayProcessor$TimedNode;

    iget-object v1, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->scheduler:Lio/reactivex/Scheduler;

    iget-object v2, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->unit:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v1, v2}, Lio/reactivex/Scheduler;->now(Ljava/util/concurrent/TimeUnit;)J

    move-result-wide v1

    iget-wide v3, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->maxAge:J

    sub-long/2addr v1, v3

    invoke-virtual {v0}, Lio/reactivex/processors/ReplayProcessor$TimedNode;->get()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lio/reactivex/processors/ReplayProcessor$TimedNode;

    :goto_13
    move-object v6, v3

    move-object v3, v0

    move-object v0, v6

    if-eqz v0, :cond_26

    iget-wide v4, v0, Lio/reactivex/processors/ReplayProcessor$TimedNode;->time:J

    cmp-long v4, v4, v1

    if-lez v4, :cond_1f

    goto :goto_26

    :cond_1f
    invoke-virtual {v0}, Lio/reactivex/processors/ReplayProcessor$TimedNode;->get()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lio/reactivex/processors/ReplayProcessor$TimedNode;

    goto :goto_13

    :cond_26
    :goto_26
    return-object v3
.end method

.method public getValue()Ljava/lang/Object;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    iget-object v0, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->head:Lio/reactivex/processors/ReplayProcessor$TimedNode;

    :goto_2
    invoke-virtual {v0}, Lio/reactivex/processors/ReplayProcessor$TimedNode;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lio/reactivex/processors/ReplayProcessor$TimedNode;

    if-nez v1, :cond_20

    iget-object v1, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->scheduler:Lio/reactivex/Scheduler;

    iget-object v2, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->unit:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v1, v2}, Lio/reactivex/Scheduler;->now(Ljava/util/concurrent/TimeUnit;)J

    move-result-wide v1

    iget-wide v3, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->maxAge:J

    sub-long/2addr v1, v3

    iget-wide v3, v0, Lio/reactivex/processors/ReplayProcessor$TimedNode;->time:J

    cmp-long v1, v3, v1

    if-gez v1, :cond_1d

    const/4 v0, 0x0

    return-object v0

    :cond_1d
    iget-object v0, v0, Lio/reactivex/processors/ReplayProcessor$TimedNode;->value:Ljava/lang/Object;

    return-object v0

    :cond_20
    move-object v0, v1

    goto :goto_2
.end method

.method public getValues([Ljava/lang/Object;)[Ljava/lang/Object;
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([TT;)[TT;"
        }
    .end annotation

    invoke-virtual {p0}, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->getHead()Lio/reactivex/processors/ReplayProcessor$TimedNode;

    move-result-object v0

    invoke-virtual {p0, v0}, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->size(Lio/reactivex/processors/ReplayProcessor$TimedNode;)I

    move-result v1

    const/4 v2, 0x0

    const/4 v3, 0x0

    if-nez v1, :cond_12

    array-length v0, p1

    if-eqz v0, :cond_39

    aput-object v2, p1, v3

    goto :goto_39

    :cond_12
    array-length v4, p1

    if-ge v4, v1, :cond_25

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object p1

    invoke-static {p1, v1}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, [Ljava/lang/Object;

    check-cast p1, [Ljava/lang/Object;

    :cond_25
    :goto_25
    if-eq v3, v1, :cond_34

    invoke-virtual {v0}, Lio/reactivex/processors/ReplayProcessor$TimedNode;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lio/reactivex/processors/ReplayProcessor$TimedNode;

    iget-object v4, v0, Lio/reactivex/processors/ReplayProcessor$TimedNode;->value:Ljava/lang/Object;

    aput-object v4, p1, v3

    add-int/lit8 v3, v3, 0x1

    goto :goto_25

    :cond_34
    array-length v0, p1

    if-le v0, v1, :cond_39

    aput-object v2, p1, v1

    :cond_39
    :goto_39
    return-object p1
.end method

.method public isDone()Z
    .registers 2

    iget-boolean v0, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->done:Z

    return v0
.end method

.method public next(Ljava/lang/Object;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    new-instance v0, Lio/reactivex/processors/ReplayProcessor$TimedNode;

    iget-object v1, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->scheduler:Lio/reactivex/Scheduler;

    iget-object v2, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->unit:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v1, v2}, Lio/reactivex/Scheduler;->now(Ljava/util/concurrent/TimeUnit;)J

    move-result-wide v1

    invoke-direct {v0, p1, v1, v2}, Lio/reactivex/processors/ReplayProcessor$TimedNode;-><init>(Ljava/lang/Object;J)V

    iget-object p1, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->tail:Lio/reactivex/processors/ReplayProcessor$TimedNode;

    iput-object v0, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->tail:Lio/reactivex/processors/ReplayProcessor$TimedNode;

    iget v1, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->size:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->size:I

    invoke-virtual {p1, v0}, Lio/reactivex/processors/ReplayProcessor$TimedNode;->set(Ljava/lang/Object;)V

    invoke-virtual {p0}, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->trim()V

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

    check-cast v1, Lio/reactivex/processors/ReplayProcessor$TimedNode;

    if-nez v1, :cond_13

    invoke-virtual {p0}, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->getHead()Lio/reactivex/processors/ReplayProcessor$TimedNode;

    move-result-object v1

    :cond_13
    iget-wide v2, p1, Lio/reactivex/processors/ReplayProcessor$ReplaySubscription;->emitted:J

    const/4 v4, 0x1

    move v5, v4

    :cond_17
    iget-object v6, p1, Lio/reactivex/processors/ReplayProcessor$ReplaySubscription;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v6}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v6

    :goto_1d
    cmp-long v8, v2, v6

    const/4 v9, 0x0

    if-eqz v8, :cond_57

    iget-boolean v10, p1, Lio/reactivex/processors/ReplayProcessor$ReplaySubscription;->cancelled:Z

    if-eqz v10, :cond_29

    iput-object v9, p1, Lio/reactivex/processors/ReplayProcessor$ReplaySubscription;->index:Ljava/lang/Object;

    return-void

    :cond_29
    iget-boolean v10, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->done:Z

    invoke-virtual {v1}, Lio/reactivex/processors/ReplayProcessor$TimedNode;->get()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Lio/reactivex/processors/ReplayProcessor$TimedNode;

    if-nez v11, :cond_35

    move v12, v4

    goto :goto_36

    :cond_35
    const/4 v12, 0x0

    :goto_36
    if-eqz v10, :cond_4a

    if-eqz v12, :cond_4a

    iput-object v9, p1, Lio/reactivex/processors/ReplayProcessor$ReplaySubscription;->index:Ljava/lang/Object;

    iput-boolean v4, p1, Lio/reactivex/processors/ReplayProcessor$ReplaySubscription;->cancelled:Z

    iget-object p1, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->error:Ljava/lang/Throwable;

    if-nez p1, :cond_46

    invoke-interface {v0}, Lorg/reactivestreams/Subscriber;->onComplete()V

    goto :goto_49

    :cond_46
    invoke-interface {v0, p1}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    :goto_49
    return-void

    :cond_4a
    if-eqz v12, :cond_4d

    goto :goto_57

    :cond_4d
    iget-object v1, v11, Lio/reactivex/processors/ReplayProcessor$TimedNode;->value:Ljava/lang/Object;

    invoke-interface {v0, v1}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    const-wide/16 v8, 0x1

    add-long/2addr v2, v8

    move-object v1, v11

    goto :goto_1d

    :cond_57
    :goto_57
    if-nez v8, :cond_7a

    iget-boolean v6, p1, Lio/reactivex/processors/ReplayProcessor$ReplaySubscription;->cancelled:Z

    if-eqz v6, :cond_60

    iput-object v9, p1, Lio/reactivex/processors/ReplayProcessor$ReplaySubscription;->index:Ljava/lang/Object;

    return-void

    :cond_60
    iget-boolean v6, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->done:Z

    if-eqz v6, :cond_7a

    invoke-virtual {v1}, Lio/reactivex/processors/ReplayProcessor$TimedNode;->get()Ljava/lang/Object;

    move-result-object v6

    if-nez v6, :cond_7a

    iput-object v9, p1, Lio/reactivex/processors/ReplayProcessor$ReplaySubscription;->index:Ljava/lang/Object;

    iput-boolean v4, p1, Lio/reactivex/processors/ReplayProcessor$ReplaySubscription;->cancelled:Z

    iget-object p1, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->error:Ljava/lang/Throwable;

    if-nez p1, :cond_76

    invoke-interface {v0}, Lorg/reactivestreams/Subscriber;->onComplete()V

    goto :goto_79

    :cond_76
    invoke-interface {v0, p1}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    :goto_79
    return-void

    :cond_7a
    iput-object v1, p1, Lio/reactivex/processors/ReplayProcessor$ReplaySubscription;->index:Ljava/lang/Object;

    iput-wide v2, p1, Lio/reactivex/processors/ReplayProcessor$ReplaySubscription;->emitted:J

    neg-int v5, v5

    invoke-virtual {p1, v5}, Lio/reactivex/processors/ReplayProcessor$ReplaySubscription;->addAndGet(I)I

    move-result v5

    if-nez v5, :cond_17

    return-void
.end method

.method public size()I
    .registers 2

    invoke-virtual {p0}, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->getHead()Lio/reactivex/processors/ReplayProcessor$TimedNode;

    move-result-object v0

    invoke-virtual {p0, v0}, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->size(Lio/reactivex/processors/ReplayProcessor$TimedNode;)I

    move-result v0

    return v0
.end method

.method size(Lio/reactivex/processors/ReplayProcessor$TimedNode;)I
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/processors/ReplayProcessor$TimedNode<",
            "TT;>;)I"
        }
    .end annotation

    const/4 v0, 0x0

    :goto_1
    const v1, 0x7fffffff

    if-eq v0, v1, :cond_12

    invoke-virtual {p1}, Lio/reactivex/processors/ReplayProcessor$TimedNode;->get()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lio/reactivex/processors/ReplayProcessor$TimedNode;

    if-nez p1, :cond_f

    goto :goto_12

    :cond_f
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_12
    :goto_12
    return v0
.end method

.method trim()V
    .registers 8

    iget v0, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->size:I

    iget v1, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->maxSize:I

    const/4 v2, 0x1

    if-le v0, v1, :cond_14

    sub-int/2addr v0, v2

    iput v0, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->size:I

    iget-object v0, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->head:Lio/reactivex/processors/ReplayProcessor$TimedNode;

    invoke-virtual {v0}, Lio/reactivex/processors/ReplayProcessor$TimedNode;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lio/reactivex/processors/ReplayProcessor$TimedNode;

    iput-object v0, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->head:Lio/reactivex/processors/ReplayProcessor$TimedNode;

    :cond_14
    iget-object v0, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->scheduler:Lio/reactivex/Scheduler;

    iget-object v1, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->unit:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v1}, Lio/reactivex/Scheduler;->now(Ljava/util/concurrent/TimeUnit;)J

    move-result-wide v0

    iget-wide v3, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->maxAge:J

    sub-long/2addr v0, v3

    iget-object v3, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->head:Lio/reactivex/processors/ReplayProcessor$TimedNode;

    :goto_21
    iget v4, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->size:I

    if-gt v4, v2, :cond_28

    iput-object v3, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->head:Lio/reactivex/processors/ReplayProcessor$TimedNode;

    goto :goto_3b

    :cond_28
    invoke-virtual {v3}, Lio/reactivex/processors/ReplayProcessor$TimedNode;->get()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lio/reactivex/processors/ReplayProcessor$TimedNode;

    if-nez v4, :cond_33

    iput-object v3, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->head:Lio/reactivex/processors/ReplayProcessor$TimedNode;

    goto :goto_3b

    :cond_33
    iget-wide v5, v4, Lio/reactivex/processors/ReplayProcessor$TimedNode;->time:J

    cmp-long v5, v5, v0

    if-lez v5, :cond_3c

    iput-object v3, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->head:Lio/reactivex/processors/ReplayProcessor$TimedNode;

    :goto_3b
    return-void

    :cond_3c
    iget v3, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->size:I

    sub-int/2addr v3, v2

    iput v3, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->size:I

    move-object v3, v4

    goto :goto_21
.end method

.method trimFinal()V
    .registers 10

    iget-object v0, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->scheduler:Lio/reactivex/Scheduler;

    iget-object v1, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->unit:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v1}, Lio/reactivex/Scheduler;->now(Ljava/util/concurrent/TimeUnit;)J

    move-result-wide v0

    iget-wide v2, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->maxAge:J

    sub-long/2addr v0, v2

    iget-object v2, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->head:Lio/reactivex/processors/ReplayProcessor$TimedNode;

    :goto_d
    invoke-virtual {v2}, Lio/reactivex/processors/ReplayProcessor$TimedNode;->get()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lio/reactivex/processors/ReplayProcessor$TimedNode;

    const-wide/16 v4, 0x0

    const/4 v6, 0x0

    if-nez v3, :cond_27

    iget-object v0, v2, Lio/reactivex/processors/ReplayProcessor$TimedNode;->value:Ljava/lang/Object;

    if-eqz v0, :cond_24

    new-instance v0, Lio/reactivex/processors/ReplayProcessor$TimedNode;

    invoke-direct {v0, v6, v4, v5}, Lio/reactivex/processors/ReplayProcessor$TimedNode;-><init>(Ljava/lang/Object;J)V

    iput-object v0, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->head:Lio/reactivex/processors/ReplayProcessor$TimedNode;

    goto :goto_42

    :cond_24
    iput-object v2, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->head:Lio/reactivex/processors/ReplayProcessor$TimedNode;

    goto :goto_42

    :cond_27
    iget-wide v7, v3, Lio/reactivex/processors/ReplayProcessor$TimedNode;->time:J

    cmp-long v7, v7, v0

    if-lez v7, :cond_43

    iget-object v0, v2, Lio/reactivex/processors/ReplayProcessor$TimedNode;->value:Ljava/lang/Object;

    if-eqz v0, :cond_40

    new-instance v0, Lio/reactivex/processors/ReplayProcessor$TimedNode;

    invoke-direct {v0, v6, v4, v5}, Lio/reactivex/processors/ReplayProcessor$TimedNode;-><init>(Ljava/lang/Object;J)V

    invoke-virtual {v2}, Lio/reactivex/processors/ReplayProcessor$TimedNode;->get()Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Lio/reactivex/processors/ReplayProcessor$TimedNode;->lazySet(Ljava/lang/Object;)V

    iput-object v0, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->head:Lio/reactivex/processors/ReplayProcessor$TimedNode;

    goto :goto_42

    :cond_40
    iput-object v2, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->head:Lio/reactivex/processors/ReplayProcessor$TimedNode;

    :goto_42
    return-void

    :cond_43
    move-object v2, v3

    goto :goto_d
.end method

.method public trimHead()V
    .registers 5

    iget-object v0, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->head:Lio/reactivex/processors/ReplayProcessor$TimedNode;

    iget-object v0, v0, Lio/reactivex/processors/ReplayProcessor$TimedNode;->value:Ljava/lang/Object;

    if-eqz v0, :cond_19

    new-instance v0, Lio/reactivex/processors/ReplayProcessor$TimedNode;

    const/4 v1, 0x0

    const-wide/16 v2, 0x0

    invoke-direct {v0, v1, v2, v3}, Lio/reactivex/processors/ReplayProcessor$TimedNode;-><init>(Ljava/lang/Object;J)V

    iget-object v1, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->head:Lio/reactivex/processors/ReplayProcessor$TimedNode;

    invoke-virtual {v1}, Lio/reactivex/processors/ReplayProcessor$TimedNode;->get()Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Lio/reactivex/processors/ReplayProcessor$TimedNode;->lazySet(Ljava/lang/Object;)V

    iput-object v0, p0, Lio/reactivex/processors/ReplayProcessor$SizeAndTimeBoundReplayBuffer;->head:Lio/reactivex/processors/ReplayProcessor$TimedNode;

    :cond_19
    return-void
.end method
