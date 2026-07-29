.class public Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;
.super Lio/reactivex/internal/subscriptions/BasicIntQueueSubscription;
.source "DeferredScalarSubscription.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lio/reactivex/internal/subscriptions/BasicIntQueueSubscription<",
        "TT;>;"
    }
.end annotation


# static fields
.field static final CANCELLED:I = 0x4

.field static final FUSED_CONSUMED:I = 0x20

.field static final FUSED_EMPTY:I = 0x8

.field static final FUSED_READY:I = 0x10

.field static final HAS_REQUEST_HAS_VALUE:I = 0x3

.field static final HAS_REQUEST_NO_VALUE:I = 0x2

.field static final NO_REQUEST_HAS_VALUE:I = 0x1

.field static final NO_REQUEST_NO_VALUE:I = 0x0

.field private static final serialVersionUID:J = -0x1ddae1b13717dd41L


# instance fields
.field protected final downstream:Lorg/reactivestreams/Subscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;"
        }
    .end annotation
.end field

.field protected value:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lorg/reactivestreams/Subscriber;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;)V"
        }
    .end annotation

    invoke-direct {p0}, Lio/reactivex/internal/subscriptions/BasicIntQueueSubscription;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->downstream:Lorg/reactivestreams/Subscriber;

    return-void
.end method


# virtual methods
.method public cancel()V
    .registers 2

    const/4 v0, 0x4

    invoke-virtual {p0, v0}, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->set(I)V

    const/4 v0, 0x0

    iput-object v0, p0, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->value:Ljava/lang/Object;

    return-void
.end method

.method public final clear()V
    .registers 2

    const/16 v0, 0x20

    invoke-virtual {p0, v0}, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->lazySet(I)V

    const/4 v0, 0x0

    iput-object v0, p0, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->value:Ljava/lang/Object;

    return-void
.end method

.method public final complete(Ljava/lang/Object;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    invoke-virtual {p0}, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->get()I

    move-result v0

    :cond_4
    const/16 v1, 0x8

    const/4 v2, 0x4

    if-ne v0, v1, :cond_1f

    iput-object p1, p0, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->value:Ljava/lang/Object;

    const/16 v0, 0x10

    invoke-virtual {p0, v0}, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->lazySet(I)V

    iget-object v0, p0, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->downstream:Lorg/reactivestreams/Subscriber;

    invoke-interface {v0, p1}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    invoke-virtual {p0}, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->get()I

    move-result p1

    if-eq p1, v2, :cond_1e

    invoke-interface {v0}, Lorg/reactivestreams/Subscriber;->onComplete()V

    :cond_1e
    return-void

    :cond_1f
    and-int/lit8 v1, v0, -0x3

    if-eqz v1, :cond_24

    return-void

    :cond_24
    const/4 v1, 0x2

    if-ne v0, v1, :cond_3a

    const/4 v0, 0x3

    invoke-virtual {p0, v0}, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->lazySet(I)V

    iget-object v0, p0, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->downstream:Lorg/reactivestreams/Subscriber;

    invoke-interface {v0, p1}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    invoke-virtual {p0}, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->get()I

    move-result p1

    if-eq p1, v2, :cond_39

    invoke-interface {v0}, Lorg/reactivestreams/Subscriber;->onComplete()V

    :cond_39
    return-void

    :cond_3a
    iput-object p1, p0, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->value:Ljava/lang/Object;

    const/4 v0, 0x0

    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->compareAndSet(II)Z

    move-result v0

    if-eqz v0, :cond_45

    return-void

    :cond_45
    invoke-virtual {p0}, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->get()I

    move-result v0

    if-ne v0, v2, :cond_4

    const/4 p1, 0x0

    iput-object p1, p0, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->value:Ljava/lang/Object;

    return-void
.end method

.method public final isCancelled()Z
    .registers 3

    invoke-virtual {p0}, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->get()I

    move-result v0

    const/4 v1, 0x4

    if-ne v0, v1, :cond_9

    const/4 v0, 0x1

    goto :goto_a

    :cond_9
    const/4 v0, 0x0

    :goto_a
    return v0
.end method

.method public final isEmpty()Z
    .registers 3

    invoke-virtual {p0}, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->get()I

    move-result v0

    const/16 v1, 0x10

    if-eq v0, v1, :cond_a

    const/4 v0, 0x1

    goto :goto_b

    :cond_a
    const/4 v0, 0x0

    :goto_b
    return v0
.end method

.method public final poll()Ljava/lang/Object;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    invoke-virtual {p0}, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->get()I

    move-result v0

    const/16 v1, 0x10

    const/4 v2, 0x0

    if-ne v0, v1, :cond_13

    const/16 v0, 0x20

    invoke-virtual {p0, v0}, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->lazySet(I)V

    iget-object v0, p0, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->value:Ljava/lang/Object;

    iput-object v2, p0, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->value:Ljava/lang/Object;

    return-object v0

    :cond_13
    return-object v2
.end method

.method public final request(J)V
    .registers 4

    invoke-static {p1, p2}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->validate(J)Z

    move-result p1

    if-eqz p1, :cond_38

    :cond_6
    invoke-virtual {p0}, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->get()I

    move-result p1

    and-int/lit8 p2, p1, -0x2

    if-eqz p2, :cond_f

    return-void

    :cond_f
    const/4 p2, 0x1

    if-ne p1, p2, :cond_30

    const/4 p1, 0x3

    invoke-virtual {p0, p2, p1}, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->compareAndSet(II)Z

    move-result p1

    if-eqz p1, :cond_2f

    iget-object p1, p0, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->value:Ljava/lang/Object;

    if-eqz p1, :cond_2f

    const/4 p2, 0x0

    iput-object p2, p0, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->value:Ljava/lang/Object;

    iget-object p2, p0, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->downstream:Lorg/reactivestreams/Subscriber;

    invoke-interface {p2, p1}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    invoke-virtual {p0}, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->get()I

    move-result p1

    const/4 v0, 0x4

    if-eq p1, v0, :cond_2f

    invoke-interface {p2}, Lorg/reactivestreams/Subscriber;->onComplete()V

    :cond_2f
    return-void

    :cond_30
    const/4 p1, 0x0

    const/4 p2, 0x2

    invoke-virtual {p0, p1, p2}, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->compareAndSet(II)Z

    move-result p1

    if-eqz p1, :cond_6

    :cond_38
    return-void
.end method

.method public final requestFusion(I)I
    .registers 3

    const/4 v0, 0x2

    and-int/2addr p1, v0

    if-eqz p1, :cond_a

    const/16 p1, 0x8

    invoke-virtual {p0, p1}, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->lazySet(I)V

    return v0

    :cond_a
    const/4 p1, 0x0

    return p1
.end method

.method public final tryCancel()Z
    .registers 3

    const/4 v0, 0x4

    invoke-virtual {p0, v0}, Lio/reactivex/internal/subscriptions/DeferredScalarSubscription;->getAndSet(I)I

    move-result v1

    if-eq v1, v0, :cond_9

    const/4 v0, 0x1

    goto :goto_a

    :cond_9
    const/4 v0, 0x0

    :goto_a
    return v0
.end method
