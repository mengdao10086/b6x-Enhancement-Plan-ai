.class public final Lio/reactivex/processors/PublishProcessor;
.super Lio/reactivex/processors/FlowableProcessor;
.source "PublishProcessor.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/reactivex/processors/PublishProcessor$PublishSubscription;
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


# static fields
.field static final EMPTY:[Lio/reactivex/processors/PublishProcessor$PublishSubscription;

.field static final TERMINATED:[Lio/reactivex/processors/PublishProcessor$PublishSubscription;


# instance fields
.field error:Ljava/lang/Throwable;

.field final subscribers:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference<",
            "[",
            "Lio/reactivex/processors/PublishProcessor$PublishSubscription<",
            "TT;>;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 2

    const/4 v0, 0x0

    new-array v1, v0, [Lio/reactivex/processors/PublishProcessor$PublishSubscription;

    sput-object v1, Lio/reactivex/processors/PublishProcessor;->TERMINATED:[Lio/reactivex/processors/PublishProcessor$PublishSubscription;

    new-array v0, v0, [Lio/reactivex/processors/PublishProcessor$PublishSubscription;

    sput-object v0, Lio/reactivex/processors/PublishProcessor;->EMPTY:[Lio/reactivex/processors/PublishProcessor$PublishSubscription;

    return-void
.end method

.method constructor <init>()V
    .registers 3

    invoke-direct {p0}, Lio/reactivex/processors/FlowableProcessor;-><init>()V

    new-instance v0, Ljava/util/concurrent/atomic/AtomicReference;

    sget-object v1, Lio/reactivex/processors/PublishProcessor;->EMPTY:[Lio/reactivex/processors/PublishProcessor$PublishSubscription;

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lio/reactivex/processors/PublishProcessor;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    return-void
.end method

.method public static create()Lio/reactivex/processors/PublishProcessor;
    .registers 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">()",
            "Lio/reactivex/processors/PublishProcessor<",
            "TT;>;"
        }
    .end annotation

    .annotation runtime Lio/reactivex/annotations/CheckReturnValue;
    .end annotation

    new-instance v0, Lio/reactivex/processors/PublishProcessor;

    invoke-direct {v0}, Lio/reactivex/processors/PublishProcessor;-><init>()V

    return-object v0
.end method


# virtual methods
.method add(Lio/reactivex/processors/PublishProcessor$PublishSubscription;)Z
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/processors/PublishProcessor$PublishSubscription<",
            "TT;>;)Z"
        }
    .end annotation

    :cond_0
    iget-object v0, p0, Lio/reactivex/processors/PublishProcessor;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lio/reactivex/processors/PublishProcessor$PublishSubscription;

    sget-object v1, Lio/reactivex/processors/PublishProcessor;->TERMINATED:[Lio/reactivex/processors/PublishProcessor$PublishSubscription;

    const/4 v2, 0x0

    if-ne v0, v1, :cond_e

    return v2

    :cond_e
    array-length v1, v0

    add-int/lit8 v3, v1, 0x1

    new-array v3, v3, [Lio/reactivex/processors/PublishProcessor$PublishSubscription;

    invoke-static {v0, v2, v3, v2, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    aput-object p1, v3, v1

    iget-object v1, p0, Lio/reactivex/processors/PublishProcessor;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v1, v0, v3}, Landroidx/lifecycle/LifecycleKt$$ExternalSyntheticBackportWithForwarding0;->m(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 p1, 0x1

    return p1
.end method

.method public getThrowable()Ljava/lang/Throwable;
    .registers 3

    iget-object v0, p0, Lio/reactivex/processors/PublishProcessor;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    sget-object v1, Lio/reactivex/processors/PublishProcessor;->TERMINATED:[Lio/reactivex/processors/PublishProcessor$PublishSubscription;

    if-ne v0, v1, :cond_d

    iget-object v0, p0, Lio/reactivex/processors/PublishProcessor;->error:Ljava/lang/Throwable;

    return-object v0

    :cond_d
    const/4 v0, 0x0

    return-object v0
.end method

.method public hasComplete()Z
    .registers 3

    iget-object v0, p0, Lio/reactivex/processors/PublishProcessor;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    sget-object v1, Lio/reactivex/processors/PublishProcessor;->TERMINATED:[Lio/reactivex/processors/PublishProcessor$PublishSubscription;

    if-ne v0, v1, :cond_10

    iget-object v0, p0, Lio/reactivex/processors/PublishProcessor;->error:Ljava/lang/Throwable;

    if-nez v0, :cond_10

    const/4 v0, 0x1

    goto :goto_11

    :cond_10
    const/4 v0, 0x0

    :goto_11
    return v0
.end method

.method public hasSubscribers()Z
    .registers 2

    iget-object v0, p0, Lio/reactivex/processors/PublishProcessor;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lio/reactivex/processors/PublishProcessor$PublishSubscription;

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
    .registers 3

    iget-object v0, p0, Lio/reactivex/processors/PublishProcessor;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    sget-object v1, Lio/reactivex/processors/PublishProcessor;->TERMINATED:[Lio/reactivex/processors/PublishProcessor$PublishSubscription;

    if-ne v0, v1, :cond_10

    iget-object v0, p0, Lio/reactivex/processors/PublishProcessor;->error:Ljava/lang/Throwable;

    if-eqz v0, :cond_10

    const/4 v0, 0x1

    goto :goto_11

    :cond_10
    const/4 v0, 0x0

    :goto_11
    return v0
.end method

.method public offer(Ljava/lang/Object;)Z
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)Z"
        }
    .end annotation

    const/4 v0, 0x1

    if-nez p1, :cond_e

    new-instance p1, Ljava/lang/NullPointerException;

    const-string v1, "onNext called with null. Null values are generally not allowed in 2.x operators and sources."

    invoke-direct {p1, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, p1}, Lio/reactivex/processors/PublishProcessor;->onError(Ljava/lang/Throwable;)V

    return v0

    :cond_e
    iget-object v1, p0, Lio/reactivex/processors/PublishProcessor;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Lio/reactivex/processors/PublishProcessor$PublishSubscription;

    array-length v2, v1

    const/4 v3, 0x0

    move v4, v3

    :goto_19
    if-ge v4, v2, :cond_27

    aget-object v5, v1, v4

    invoke-virtual {v5}, Lio/reactivex/processors/PublishProcessor$PublishSubscription;->isFull()Z

    move-result v5

    if-eqz v5, :cond_24

    return v3

    :cond_24
    add-int/lit8 v4, v4, 0x1

    goto :goto_19

    :cond_27
    array-length v2, v1

    :goto_28
    if-ge v3, v2, :cond_32

    aget-object v4, v1, v3

    invoke-virtual {v4, p1}, Lio/reactivex/processors/PublishProcessor$PublishSubscription;->onNext(Ljava/lang/Object;)V

    add-int/lit8 v3, v3, 0x1

    goto :goto_28

    :cond_32
    return v0
.end method

.method public onComplete()V
    .registers 5

    iget-object v0, p0, Lio/reactivex/processors/PublishProcessor;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    sget-object v1, Lio/reactivex/processors/PublishProcessor;->TERMINATED:[Lio/reactivex/processors/PublishProcessor$PublishSubscription;

    if-ne v0, v1, :cond_b

    return-void

    :cond_b
    iget-object v0, p0, Lio/reactivex/processors/PublishProcessor;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicReference;->getAndSet(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lio/reactivex/processors/PublishProcessor$PublishSubscription;

    array-length v1, v0

    const/4 v2, 0x0

    :goto_15
    if-ge v2, v1, :cond_1f

    aget-object v3, v0, v2

    invoke-virtual {v3}, Lio/reactivex/processors/PublishProcessor$PublishSubscription;->onComplete()V

    add-int/lit8 v2, v2, 0x1

    goto :goto_15

    :cond_1f
    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 6

    const-string v0, "onError called with null. Null values are generally not allowed in 2.x operators and sources."

    invoke-static {p1, v0}, Lio/reactivex/internal/functions/ObjectHelper;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    iget-object v0, p0, Lio/reactivex/processors/PublishProcessor;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    sget-object v1, Lio/reactivex/processors/PublishProcessor;->TERMINATED:[Lio/reactivex/processors/PublishProcessor$PublishSubscription;

    if-ne v0, v1, :cond_13

    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    return-void

    :cond_13
    iput-object p1, p0, Lio/reactivex/processors/PublishProcessor;->error:Ljava/lang/Throwable;

    iget-object v0, p0, Lio/reactivex/processors/PublishProcessor;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicReference;->getAndSet(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lio/reactivex/processors/PublishProcessor$PublishSubscription;

    array-length v1, v0

    const/4 v2, 0x0

    :goto_1f
    if-ge v2, v1, :cond_29

    aget-object v3, v0, v2

    invoke-virtual {v3, p1}, Lio/reactivex/processors/PublishProcessor$PublishSubscription;->onError(Ljava/lang/Throwable;)V

    add-int/lit8 v2, v2, 0x1

    goto :goto_1f

    :cond_29
    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    const-string v0, "onNext called with null. Null values are generally not allowed in 2.x operators and sources."

    invoke-static {p1, v0}, Lio/reactivex/internal/functions/ObjectHelper;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    iget-object v0, p0, Lio/reactivex/processors/PublishProcessor;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lio/reactivex/processors/PublishProcessor$PublishSubscription;

    array-length v1, v0

    const/4 v2, 0x0

    :goto_f
    if-ge v2, v1, :cond_19

    aget-object v3, v0, v2

    invoke-virtual {v3, p1}, Lio/reactivex/processors/PublishProcessor$PublishSubscription;->onNext(Ljava/lang/Object;)V

    add-int/lit8 v2, v2, 0x1

    goto :goto_f

    :cond_19
    return-void
.end method

.method public onSubscribe(Lorg/reactivestreams/Subscription;)V
    .registers 4

    iget-object v0, p0, Lio/reactivex/processors/PublishProcessor;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    sget-object v1, Lio/reactivex/processors/PublishProcessor;->TERMINATED:[Lio/reactivex/processors/PublishProcessor$PublishSubscription;

    if-ne v0, v1, :cond_e

    invoke-interface {p1}, Lorg/reactivestreams/Subscription;->cancel()V

    return-void

    :cond_e
    const-wide v0, 0x7fffffffffffffffL

    invoke-interface {p1, v0, v1}, Lorg/reactivestreams/Subscription;->request(J)V

    return-void
.end method

.method remove(Lio/reactivex/processors/PublishProcessor$PublishSubscription;)V
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/processors/PublishProcessor$PublishSubscription<",
            "TT;>;)V"
        }
    .end annotation

    :cond_0
    iget-object v0, p0, Lio/reactivex/processors/PublishProcessor;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lio/reactivex/processors/PublishProcessor$PublishSubscription;

    sget-object v1, Lio/reactivex/processors/PublishProcessor;->TERMINATED:[Lio/reactivex/processors/PublishProcessor$PublishSubscription;

    if-eq v0, v1, :cond_3f

    sget-object v1, Lio/reactivex/processors/PublishProcessor;->EMPTY:[Lio/reactivex/processors/PublishProcessor$PublishSubscription;

    if-ne v0, v1, :cond_11

    goto :goto_3f

    :cond_11
    array-length v1, v0

    const/4 v2, 0x0

    move v3, v2

    :goto_14
    if-ge v3, v1, :cond_1e

    aget-object v4, v0, v3

    if-ne v4, p1, :cond_1b

    goto :goto_1f

    :cond_1b
    add-int/lit8 v3, v3, 0x1

    goto :goto_14

    :cond_1e
    const/4 v3, -0x1

    :goto_1f
    if-gez v3, :cond_22

    return-void

    :cond_22
    const/4 v4, 0x1

    if-ne v1, v4, :cond_28

    sget-object v1, Lio/reactivex/processors/PublishProcessor;->EMPTY:[Lio/reactivex/processors/PublishProcessor$PublishSubscription;

    goto :goto_37

    :cond_28
    add-int/lit8 v5, v1, -0x1

    new-array v5, v5, [Lio/reactivex/processors/PublishProcessor$PublishSubscription;

    invoke-static {v0, v2, v5, v2, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    add-int/lit8 v2, v3, 0x1

    sub-int/2addr v1, v3

    sub-int/2addr v1, v4

    invoke-static {v0, v2, v5, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    move-object v1, v5

    :goto_37
    iget-object v2, p0, Lio/reactivex/processors/PublishProcessor;->subscribers:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v2, v0, v1}, Landroidx/lifecycle/LifecycleKt$$ExternalSyntheticBackportWithForwarding0;->m(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_3f
    :goto_3f
    return-void
.end method

.method protected subscribeActual(Lorg/reactivestreams/Subscriber;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;)V"
        }
    .end annotation

    new-instance v0, Lio/reactivex/processors/PublishProcessor$PublishSubscription;

    invoke-direct {v0, p1, p0}, Lio/reactivex/processors/PublishProcessor$PublishSubscription;-><init>(Lorg/reactivestreams/Subscriber;Lio/reactivex/processors/PublishProcessor;)V

    invoke-interface {p1, v0}, Lorg/reactivestreams/Subscriber;->onSubscribe(Lorg/reactivestreams/Subscription;)V

    invoke-virtual {p0, v0}, Lio/reactivex/processors/PublishProcessor;->add(Lio/reactivex/processors/PublishProcessor$PublishSubscription;)Z

    move-result v1

    if-eqz v1, :cond_18

    invoke-virtual {v0}, Lio/reactivex/processors/PublishProcessor$PublishSubscription;->isCancelled()Z

    move-result p1

    if-eqz p1, :cond_23

    invoke-virtual {p0, v0}, Lio/reactivex/processors/PublishProcessor;->remove(Lio/reactivex/processors/PublishProcessor$PublishSubscription;)V

    goto :goto_23

    :cond_18
    iget-object v0, p0, Lio/reactivex/processors/PublishProcessor;->error:Ljava/lang/Throwable;

    if-eqz v0, :cond_20

    invoke-interface {p1, v0}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    goto :goto_23

    :cond_20
    invoke-interface {p1}, Lorg/reactivestreams/Subscriber;->onComplete()V

    :cond_23
    :goto_23
    return-void
.end method
