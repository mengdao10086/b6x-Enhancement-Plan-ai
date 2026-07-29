.class public final Lio/reactivex/processors/MulticastProcessor;
.super Lio/reactivex/processors/FlowableProcessor;
.source "MulticastProcessor.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lio/reactivex/processors/FlowableProcessor<",
        "TT;>;"
    }
.end annotation

.annotation runtime Lio/reactivex/annotations/BackpressureSupport;
    value = .enum Lio/reactivex/annotations/BackpressureKind;->FULL:Lio/reactivex/annotations/BackpressureKind;
.end annotation

.annotation runtime Lio/reactivex/annotations/SchedulerSupport;
    value = "none"
.end annotation


# static fields
.field static final EMPTY:[Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;

.field static final TERMINATED:[Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;


# instance fields
.field final bufferSize:I

.field consumed:I

.field volatile done:Z

.field volatile error:Ljava/lang/Throwable;

.field fusionMode:I

.field final limit:I

.field final once:Ljava/util/concurrent/atomic/AtomicBoolean;

.field volatile queue:Lio/reactivex/internal/fuseable/SimpleQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/internal/fuseable/SimpleQueue<",
            "TT;>;"
        }
    .end annotation
.end field

.field final refcount:Z

.field final subscribers:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference<",
            "[",
            "Lio/reactivex/processors/MulticastProcessor$MulticastSubscription<",
            "TT;>;>;"
        }
    .end annotation
.end field

.field final upstream:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference<",
            "Lorg/reactivestreams/Subscription;",
            ">;"
        }
    .end annotation
.end field

.field final wip:Ljava/util/concurrent/atomic/AtomicInteger;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    const/4 v0, 0x0

    new-array v1, v0, [Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;

    sput-object v1, Lio/reactivex/processors/MulticastProcessor;->EMPTY:[Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;

    new-array v0, v0, [Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;

    sput-object v0, Lio/reactivex/processors/MulticastProcessor;->TERMINATED:[Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;

    return-void
.end method

.method constructor <init>(IZ)V
    .registers 4

    invoke-direct {p0}, Lio/reactivex/processors/FlowableProcessor;-><init>()V

    const-string v0, "bufferSize"

    invoke-static {p1, v0}, Lio/reactivex/internal/functions/ObjectHelper;->verifyPositive(ILjava/lang/String;)I

    iput p1, p0, Lio/reactivex/processors/MulticastProcessor;->bufferSize:I

    shr-int/lit8 v0, p1, 0x2

    sub-int/2addr p1, v0

    iput p1, p0, Lio/reactivex/processors/MulticastProcessor;->limit:I

    new-instance p1, Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    iput-object p1, p0, Lio/reactivex/processors/MulticastProcessor;->wip:Ljava/util/concurrent/atomic/AtomicInteger;

    new-instance p1, Ljava/util/concurrent/atomic/AtomicReference;

    sget-object v0, Lio/reactivex/processors/MulticastProcessor;->EMPTY:[Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;

    invoke-direct {p1, v0}, Ljava/util/concurrent/atomic/AtomicReference;-><init>(Ljava/lang/Object;)V

    iput-object p1, p0, Lio/reactivex/processors/MulticastProcessor;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    new-instance p1, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    iput-object p1, p0, Lio/reactivex/processors/MulticastProcessor;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    iput-boolean p2, p0, Lio/reactivex/processors/MulticastProcessor;->refcount:Z

    new-instance p1, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>()V

    iput-object p1, p0, Lio/reactivex/processors/MulticastProcessor;->once:Ljava/util/concurrent/atomic/AtomicBoolean;

    return-void
.end method

.method public static create()Lio/reactivex/processors/MulticastProcessor;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">()",
            "Lio/reactivex/processors/MulticastProcessor<",
            "TT;>;"
        }
    .end annotation

    .annotation runtime Lio/reactivex/annotations/CheckReturnValue;
    .end annotation

    new-instance v0, Lio/reactivex/processors/MulticastProcessor;

    invoke-static {}, Lio/reactivex/processors/MulticastProcessor;->bufferSize()I

    move-result v1

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lio/reactivex/processors/MulticastProcessor;-><init>(IZ)V

    return-object v0
.end method

.method public static create(I)Lio/reactivex/processors/MulticastProcessor;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(I)",
            "Lio/reactivex/processors/MulticastProcessor<",
            "TT;>;"
        }
    .end annotation

    .annotation runtime Lio/reactivex/annotations/CheckReturnValue;
    .end annotation

    new-instance v0, Lio/reactivex/processors/MulticastProcessor;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lio/reactivex/processors/MulticastProcessor;-><init>(IZ)V

    return-object v0
.end method

.method public static create(IZ)Lio/reactivex/processors/MulticastProcessor;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(IZ)",
            "Lio/reactivex/processors/MulticastProcessor<",
            "TT;>;"
        }
    .end annotation

    .annotation runtime Lio/reactivex/annotations/CheckReturnValue;
    .end annotation

    new-instance v0, Lio/reactivex/processors/MulticastProcessor;

    invoke-direct {v0, p0, p1}, Lio/reactivex/processors/MulticastProcessor;-><init>(IZ)V

    return-object v0
.end method

.method public static create(Z)Lio/reactivex/processors/MulticastProcessor;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(Z)",
            "Lio/reactivex/processors/MulticastProcessor<",
            "TT;>;"
        }
    .end annotation

    .annotation runtime Lio/reactivex/annotations/CheckReturnValue;
    .end annotation

    new-instance v0, Lio/reactivex/processors/MulticastProcessor;

    invoke-static {}, Lio/reactivex/processors/MulticastProcessor;->bufferSize()I

    move-result v1

    invoke-direct {v0, v1, p0}, Lio/reactivex/processors/MulticastProcessor;-><init>(IZ)V

    return-object v0
.end method


# virtual methods
.method add(Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;)Z
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/processors/MulticastProcessor$MulticastSubscription<",
            "TT;>;)Z"
        }
    .end annotation

    :cond_0
    iget-object v0, p0, Lio/reactivex/processors/MulticastProcessor;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;

    sget-object v1, Lio/reactivex/processors/MulticastProcessor;->TERMINATED:[Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;

    const/4 v2, 0x0

    if-ne v0, v1, :cond_e

    return v2

    :cond_e
    array-length v1, v0

    add-int/lit8 v3, v1, 0x1

    new-array v3, v3, [Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;

    invoke-static {v0, v2, v3, v2, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    aput-object p1, v3, v1

    iget-object v1, p0, Lio/reactivex/processors/MulticastProcessor;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v1, v0, v3}, Landroidx/lifecycle/LifecycleKt$$ExternalSyntheticBackportWithForwarding0;->m(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 p1, 0x1

    return p1
.end method

.method drain()V
    .registers 21

    move-object/from16 v1, p0

    iget-object v0, v1, Lio/reactivex/processors/MulticastProcessor;->wip:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndIncrement()I

    move-result v0

    if-eqz v0, :cond_b

    return-void

    :cond_b
    iget-object v2, v1, Lio/reactivex/processors/MulticastProcessor;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    iget v0, v1, Lio/reactivex/processors/MulticastProcessor;->consumed:I

    iget v3, v1, Lio/reactivex/processors/MulticastProcessor;->limit:I

    iget v4, v1, Lio/reactivex/processors/MulticastProcessor;->fusionMode:I

    const/4 v5, 0x1

    move v6, v5

    :cond_15
    :goto_15
    iget-object v7, v1, Lio/reactivex/processors/MulticastProcessor;->queue:Lio/reactivex/internal/fuseable/SimpleQueue;

    if-eqz v7, :cond_11f

    invoke-virtual {v2}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, [Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;

    array-length v9, v8

    if-eqz v9, :cond_11f

    array-length v9, v8

    const-wide/16 v10, -0x1

    move-wide v14, v10

    const/4 v13, 0x0

    :goto_27
    const-wide/16 v16, 0x0

    if-ge v13, v9, :cond_4b

    aget-object v12, v8, v13

    invoke-virtual {v12}, Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;->get()J

    move-result-wide v18

    cmp-long v16, v18, v16

    if-ltz v16, :cond_46

    cmp-long v16, v14, v10

    if-nez v16, :cond_3e

    iget-wide v14, v12, Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;->emitted:J

    sub-long v14, v18, v14

    goto :goto_46

    :cond_3e
    iget-wide v10, v12, Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;->emitted:J

    sub-long v10, v18, v10

    invoke-static {v14, v15, v10, v11}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v14

    :cond_46
    :goto_46
    add-int/lit8 v13, v13, 0x1

    const-wide/16 v10, -0x1

    goto :goto_27

    :cond_4b
    move v9, v0

    :cond_4c
    :goto_4c
    cmp-long v10, v14, v16

    if-lez v10, :cond_d6

    invoke-virtual {v2}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;

    sget-object v11, Lio/reactivex/processors/MulticastProcessor;->TERMINATED:[Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;

    if-ne v0, v11, :cond_5e

    invoke-interface {v7}, Lio/reactivex/internal/fuseable/SimpleQueue;->clear()V

    return-void

    :cond_5e
    if-eq v8, v0, :cond_62

    goto/16 :goto_e8

    :cond_62
    iget-boolean v0, v1, Lio/reactivex/processors/MulticastProcessor;->done:Z

    :try_start_64
    invoke-interface {v7}, Lio/reactivex/internal/fuseable/SimpleQueue;->poll()Ljava/lang/Object;

    move-result-object v11
    :try_end_68
    .catchall {:try_start_64 .. :try_end_68} :catchall_69

    goto :goto_79

    :catchall_69
    move-exception v0

    move-object v11, v0

    invoke-static {v11}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    iget-object v0, v1, Lio/reactivex/processors/MulticastProcessor;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->cancel(Ljava/util/concurrent/atomic/AtomicReference;)Z

    iput-object v11, v1, Lio/reactivex/processors/MulticastProcessor;->error:Ljava/lang/Throwable;

    iput-boolean v5, v1, Lio/reactivex/processors/MulticastProcessor;->done:Z

    const/4 v11, 0x0

    move v0, v5

    :goto_79
    if-nez v11, :cond_7d

    move v12, v5

    goto :goto_7e

    :cond_7d
    const/4 v12, 0x0

    :goto_7e
    if-eqz v0, :cond_af

    if-eqz v12, :cond_af

    iget-object v0, v1, Lio/reactivex/processors/MulticastProcessor;->error:Ljava/lang/Throwable;

    if-eqz v0, :cond_9a

    sget-object v3, Lio/reactivex/processors/MulticastProcessor;->TERMINATED:[Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;

    invoke-virtual {v2, v3}, Ljava/util/concurrent/atomic/AtomicReference;->getAndSet(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;

    array-length v3, v2

    const/4 v12, 0x0

    :goto_90
    if-ge v12, v3, :cond_ae

    aget-object v4, v2, v12

    invoke-virtual {v4, v0}, Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;->onError(Ljava/lang/Throwable;)V

    add-int/lit8 v12, v12, 0x1

    goto :goto_90

    :cond_9a
    sget-object v0, Lio/reactivex/processors/MulticastProcessor;->TERMINATED:[Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;

    invoke-virtual {v2, v0}, Ljava/util/concurrent/atomic/AtomicReference;->getAndSet(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;

    array-length v2, v0

    const/4 v12, 0x0

    :goto_a4
    if-ge v12, v2, :cond_ae

    aget-object v3, v0, v12

    invoke-virtual {v3}, Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;->onComplete()V

    add-int/lit8 v12, v12, 0x1

    goto :goto_a4

    :cond_ae
    return-void

    :cond_af
    if-eqz v12, :cond_b2

    goto :goto_d6

    :cond_b2
    array-length v0, v8

    const/4 v10, 0x0

    :goto_b4
    if-ge v10, v0, :cond_be

    aget-object v12, v8, v10

    invoke-virtual {v12, v11}, Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;->onNext(Ljava/lang/Object;)V

    add-int/lit8 v10, v10, 0x1

    goto :goto_b4

    :cond_be
    const-wide/16 v10, 0x1

    sub-long/2addr v14, v10

    if-eq v4, v5, :cond_4c

    add-int/lit8 v9, v9, 0x1

    if-ne v9, v3, :cond_4c

    iget-object v0, v1, Lio/reactivex/processors/MulticastProcessor;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/reactivestreams/Subscription;

    int-to-long v9, v3

    invoke-interface {v0, v9, v10}, Lorg/reactivestreams/Subscription;->request(J)V

    const/4 v9, 0x0

    goto/16 :goto_4c

    :cond_d6
    :goto_d6
    if-nez v10, :cond_11e

    invoke-virtual {v2}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;

    sget-object v10, Lio/reactivex/processors/MulticastProcessor;->TERMINATED:[Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;

    if-ne v0, v10, :cond_e6

    invoke-interface {v7}, Lio/reactivex/internal/fuseable/SimpleQueue;->clear()V

    return-void

    :cond_e6
    if-eq v8, v0, :cond_eb

    :goto_e8
    move v0, v9

    goto/16 :goto_15

    :cond_eb
    iget-boolean v0, v1, Lio/reactivex/processors/MulticastProcessor;->done:Z

    if-eqz v0, :cond_11e

    invoke-interface {v7}, Lio/reactivex/internal/fuseable/SimpleQueue;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_11e

    iget-object v0, v1, Lio/reactivex/processors/MulticastProcessor;->error:Ljava/lang/Throwable;

    if-eqz v0, :cond_10b

    invoke-virtual {v2, v10}, Ljava/util/concurrent/atomic/AtomicReference;->getAndSet(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;

    array-length v3, v2

    const/4 v12, 0x0

    :goto_101
    if-ge v12, v3, :cond_11d

    aget-object v4, v2, v12

    invoke-virtual {v4, v0}, Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;->onError(Ljava/lang/Throwable;)V

    add-int/lit8 v12, v12, 0x1

    goto :goto_101

    :cond_10b
    invoke-virtual {v2, v10}, Ljava/util/concurrent/atomic/AtomicReference;->getAndSet(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;

    array-length v2, v0

    const/4 v12, 0x0

    :goto_113
    if-ge v12, v2, :cond_11d

    aget-object v3, v0, v12

    invoke-virtual {v3}, Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;->onComplete()V

    add-int/lit8 v12, v12, 0x1

    goto :goto_113

    :cond_11d
    return-void

    :cond_11e
    move v0, v9

    :cond_11f
    iput v0, v1, Lio/reactivex/processors/MulticastProcessor;->consumed:I

    iget-object v7, v1, Lio/reactivex/processors/MulticastProcessor;->wip:Ljava/util/concurrent/atomic/AtomicInteger;

    neg-int v6, v6

    invoke-virtual {v7, v6}, Ljava/util/concurrent/atomic/AtomicInteger;->addAndGet(I)I

    move-result v6

    if-nez v6, :cond_15

    return-void
.end method

.method public getThrowable()Ljava/lang/Throwable;
    .registers 2

    iget-object v0, p0, Lio/reactivex/processors/MulticastProcessor;->once:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    if-eqz v0, :cond_b

    iget-object v0, p0, Lio/reactivex/processors/MulticastProcessor;->error:Ljava/lang/Throwable;

    goto :goto_c

    :cond_b
    const/4 v0, 0x0

    :goto_c
    return-object v0
.end method

.method public hasComplete()Z
    .registers 2

    iget-object v0, p0, Lio/reactivex/processors/MulticastProcessor;->once:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    if-eqz v0, :cond_e

    iget-object v0, p0, Lio/reactivex/processors/MulticastProcessor;->error:Ljava/lang/Throwable;

    if-nez v0, :cond_e

    const/4 v0, 0x1

    goto :goto_f

    :cond_e
    const/4 v0, 0x0

    :goto_f
    return v0
.end method

.method public hasSubscribers()Z
    .registers 2

    iget-object v0, p0, Lio/reactivex/processors/MulticastProcessor;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;

    array-length v0, v0

    if-eqz v0, :cond_d

    const/4 v0, 0x1

    goto :goto_e

    :cond_d
    const/4 v0, 0x0

    :goto_e
    return v0
.end method

.method public hasThrowable()Z
    .registers 2

    iget-object v0, p0, Lio/reactivex/processors/MulticastProcessor;->once:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    if-eqz v0, :cond_e

    iget-object v0, p0, Lio/reactivex/processors/MulticastProcessor;->error:Ljava/lang/Throwable;

    if-eqz v0, :cond_e

    const/4 v0, 0x1

    goto :goto_f

    :cond_e
    const/4 v0, 0x0

    :goto_f
    return v0
.end method

.method public offer(Ljava/lang/Object;)Z
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)Z"
        }
    .end annotation

    iget-object v0, p0, Lio/reactivex/processors/MulticastProcessor;->once:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_a

    return v1

    :cond_a
    const-string v0, "offer called with null. Null values are generally not allowed in 2.x operators and sources."

    invoke-static {p1, v0}, Lio/reactivex/internal/functions/ObjectHelper;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    iget v0, p0, Lio/reactivex/processors/MulticastProcessor;->fusionMode:I

    if-nez v0, :cond_20

    iget-object v0, p0, Lio/reactivex/processors/MulticastProcessor;->queue:Lio/reactivex/internal/fuseable/SimpleQueue;

    invoke-interface {v0, p1}, Lio/reactivex/internal/fuseable/SimpleQueue;->offer(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_20

    invoke-virtual {p0}, Lio/reactivex/processors/MulticastProcessor;->drain()V

    const/4 p1, 0x1

    return p1

    :cond_20
    return v1
.end method

.method public onComplete()V
    .registers 4

    iget-object v0, p0, Lio/reactivex/processors/MulticastProcessor;->once:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(ZZ)Z

    move-result v0

    if-eqz v0, :cond_f

    iput-boolean v2, p0, Lio/reactivex/processors/MulticastProcessor;->done:Z

    invoke-virtual {p0}, Lio/reactivex/processors/MulticastProcessor;->drain()V

    :cond_f
    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 5

    const-string v0, "onError called with null. Null values are generally not allowed in 2.x operators and sources."

    invoke-static {p1, v0}, Lio/reactivex/internal/functions/ObjectHelper;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    iget-object v0, p0, Lio/reactivex/processors/MulticastProcessor;->once:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(ZZ)Z

    move-result v0

    if-eqz v0, :cond_17

    iput-object p1, p0, Lio/reactivex/processors/MulticastProcessor;->error:Ljava/lang/Throwable;

    iput-boolean v2, p0, Lio/reactivex/processors/MulticastProcessor;->done:Z

    invoke-virtual {p0}, Lio/reactivex/processors/MulticastProcessor;->drain()V

    goto :goto_1a

    :cond_17
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :goto_1a
    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    iget-object v0, p0, Lio/reactivex/processors/MulticastProcessor;->once:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    if-eqz v0, :cond_9

    return-void

    :cond_9
    iget v0, p0, Lio/reactivex/processors/MulticastProcessor;->fusionMode:I

    if-nez v0, :cond_28

    const-string v0, "onNext called with null. Null values are generally not allowed in 2.x operators and sources."

    invoke-static {p1, v0}, Lio/reactivex/internal/functions/ObjectHelper;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    iget-object v0, p0, Lio/reactivex/processors/MulticastProcessor;->queue:Lio/reactivex/internal/fuseable/SimpleQueue;

    invoke-interface {v0, p1}, Lio/reactivex/internal/fuseable/SimpleQueue;->offer(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_28

    iget-object p1, p0, Lio/reactivex/processors/MulticastProcessor;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {p1}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->cancel(Ljava/util/concurrent/atomic/AtomicReference;)Z

    new-instance p1, Lio/reactivex/exceptions/MissingBackpressureException;

    invoke-direct {p1}, Lio/reactivex/exceptions/MissingBackpressureException;-><init>()V

    invoke-virtual {p0, p1}, Lio/reactivex/processors/MulticastProcessor;->onError(Ljava/lang/Throwable;)V

    return-void

    :cond_28
    invoke-virtual {p0}, Lio/reactivex/processors/MulticastProcessor;->drain()V

    return-void
.end method

.method public onSubscribe(Lorg/reactivestreams/Subscription;)V
    .registers 5

    iget-object v0, p0, Lio/reactivex/processors/MulticastProcessor;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0, p1}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->setOnce(Ljava/util/concurrent/atomic/AtomicReference;Lorg/reactivestreams/Subscription;)Z

    move-result v0

    if-eqz v0, :cond_3e

    instance-of v0, p1, Lio/reactivex/internal/fuseable/QueueSubscription;

    if-eqz v0, :cond_2f

    move-object v0, p1

    check-cast v0, Lio/reactivex/internal/fuseable/QueueSubscription;

    const/4 v1, 0x3

    invoke-interface {v0, v1}, Lio/reactivex/internal/fuseable/QueueSubscription;->requestFusion(I)I

    move-result v1

    const/4 v2, 0x1

    if-ne v1, v2, :cond_21

    iput v1, p0, Lio/reactivex/processors/MulticastProcessor;->fusionMode:I

    iput-object v0, p0, Lio/reactivex/processors/MulticastProcessor;->queue:Lio/reactivex/internal/fuseable/SimpleQueue;

    iput-boolean v2, p0, Lio/reactivex/processors/MulticastProcessor;->done:Z

    invoke-virtual {p0}, Lio/reactivex/processors/MulticastProcessor;->drain()V

    return-void

    :cond_21
    const/4 v2, 0x2

    if-ne v1, v2, :cond_2f

    iput v1, p0, Lio/reactivex/processors/MulticastProcessor;->fusionMode:I

    iput-object v0, p0, Lio/reactivex/processors/MulticastProcessor;->queue:Lio/reactivex/internal/fuseable/SimpleQueue;

    iget v0, p0, Lio/reactivex/processors/MulticastProcessor;->bufferSize:I

    int-to-long v0, v0

    invoke-interface {p1, v0, v1}, Lorg/reactivestreams/Subscription;->request(J)V

    return-void

    :cond_2f
    new-instance v0, Lio/reactivex/internal/queue/SpscArrayQueue;

    iget v1, p0, Lio/reactivex/processors/MulticastProcessor;->bufferSize:I

    invoke-direct {v0, v1}, Lio/reactivex/internal/queue/SpscArrayQueue;-><init>(I)V

    iput-object v0, p0, Lio/reactivex/processors/MulticastProcessor;->queue:Lio/reactivex/internal/fuseable/SimpleQueue;

    iget v0, p0, Lio/reactivex/processors/MulticastProcessor;->bufferSize:I

    int-to-long v0, v0

    invoke-interface {p1, v0, v1}, Lorg/reactivestreams/Subscription;->request(J)V

    :cond_3e
    return-void
.end method

.method remove(Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;)V
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/processors/MulticastProcessor$MulticastSubscription<",
            "TT;>;)V"
        }
    .end annotation

    :cond_0
    iget-object v0, p0, Lio/reactivex/processors/MulticastProcessor;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;

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

    goto :goto_59

    :cond_1c
    const/4 v4, 0x1

    if-ne v1, v4, :cond_43

    iget-boolean v1, p0, Lio/reactivex/processors/MulticastProcessor;->refcount:Z

    if-eqz v1, :cond_38

    iget-object v1, p0, Lio/reactivex/processors/MulticastProcessor;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    sget-object v2, Lio/reactivex/processors/MulticastProcessor;->TERMINATED:[Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;

    invoke-static {v1, v0, v2}, Landroidx/lifecycle/LifecycleKt$$ExternalSyntheticBackportWithForwarding0;->m(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object p1, p0, Lio/reactivex/processors/MulticastProcessor;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {p1}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->cancel(Ljava/util/concurrent/atomic/AtomicReference;)Z

    iget-object p1, p0, Lio/reactivex/processors/MulticastProcessor;->once:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {p1, v4}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    goto :goto_59

    :cond_38
    iget-object v1, p0, Lio/reactivex/processors/MulticastProcessor;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    sget-object v2, Lio/reactivex/processors/MulticastProcessor;->EMPTY:[Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;

    invoke-static {v1, v0, v2}, Landroidx/lifecycle/LifecycleKt$$ExternalSyntheticBackportWithForwarding0;->m(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_59

    :cond_43
    add-int/lit8 v5, v1, -0x1

    new-array v5, v5, [Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;

    invoke-static {v0, v2, v5, v2, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    add-int/lit8 v2, v3, 0x1

    sub-int/2addr v1, v3

    sub-int/2addr v1, v4

    invoke-static {v0, v2, v5, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    iget-object v1, p0, Lio/reactivex/processors/MulticastProcessor;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v1, v0, v5}, Landroidx/lifecycle/LifecycleKt$$ExternalSyntheticBackportWithForwarding0;->m(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :goto_59
    return-void
.end method

.method public start()V
    .registers 3

    iget-object v0, p0, Lio/reactivex/processors/MulticastProcessor;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    sget-object v1, Lio/reactivex/internal/subscriptions/EmptySubscription;->INSTANCE:Lio/reactivex/internal/subscriptions/EmptySubscription;

    invoke-static {v0, v1}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->setOnce(Ljava/util/concurrent/atomic/AtomicReference;Lorg/reactivestreams/Subscription;)Z

    move-result v0

    if-eqz v0, :cond_13

    new-instance v0, Lio/reactivex/internal/queue/SpscArrayQueue;

    iget v1, p0, Lio/reactivex/processors/MulticastProcessor;->bufferSize:I

    invoke-direct {v0, v1}, Lio/reactivex/internal/queue/SpscArrayQueue;-><init>(I)V

    iput-object v0, p0, Lio/reactivex/processors/MulticastProcessor;->queue:Lio/reactivex/internal/fuseable/SimpleQueue;

    :cond_13
    return-void
.end method

.method public startUnbounded()V
    .registers 3

    iget-object v0, p0, Lio/reactivex/processors/MulticastProcessor;->upstream:Ljava/util/concurrent/atomic/AtomicReference;

    sget-object v1, Lio/reactivex/internal/subscriptions/EmptySubscription;->INSTANCE:Lio/reactivex/internal/subscriptions/EmptySubscription;

    invoke-static {v0, v1}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->setOnce(Ljava/util/concurrent/atomic/AtomicReference;Lorg/reactivestreams/Subscription;)Z

    move-result v0

    if-eqz v0, :cond_13

    new-instance v0, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    iget v1, p0, Lio/reactivex/processors/MulticastProcessor;->bufferSize:I

    invoke-direct {v0, v1}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;-><init>(I)V

    iput-object v0, p0, Lio/reactivex/processors/MulticastProcessor;->queue:Lio/reactivex/internal/fuseable/SimpleQueue;

    :cond_13
    return-void
.end method

.method protected subscribeActual(Lorg/reactivestreams/Subscriber;)V
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;)V"
        }
    .end annotation

    new-instance v0, Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;

    invoke-direct {v0, p1, p0}, Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;-><init>(Lorg/reactivestreams/Subscriber;Lio/reactivex/processors/MulticastProcessor;)V

    invoke-interface {p1, v0}, Lorg/reactivestreams/Subscriber;->onSubscribe(Lorg/reactivestreams/Subscription;)V

    invoke-virtual {p0, v0}, Lio/reactivex/processors/MulticastProcessor;->add(Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;)Z

    move-result v1

    if-eqz v1, :cond_20

    invoke-virtual {v0}, Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;->get()J

    move-result-wide v1

    const-wide/high16 v3, -0x8000000000000000L

    cmp-long p1, v1, v3

    if-nez p1, :cond_1c

    invoke-virtual {p0, v0}, Lio/reactivex/processors/MulticastProcessor;->remove(Lio/reactivex/processors/MulticastProcessor$MulticastSubscription;)V

    goto :goto_37

    :cond_1c
    invoke-virtual {p0}, Lio/reactivex/processors/MulticastProcessor;->drain()V

    goto :goto_37

    :cond_20
    iget-object v0, p0, Lio/reactivex/processors/MulticastProcessor;->once:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    if-nez v0, :cond_2c

    iget-boolean v0, p0, Lio/reactivex/processors/MulticastProcessor;->refcount:Z

    if-nez v0, :cond_34

    :cond_2c
    iget-object v0, p0, Lio/reactivex/processors/MulticastProcessor;->error:Ljava/lang/Throwable;

    if-eqz v0, :cond_34

    invoke-interface {p1, v0}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void

    :cond_34
    invoke-interface {p1}, Lorg/reactivestreams/Subscriber;->onComplete()V

    :goto_37
    return-void
.end method
