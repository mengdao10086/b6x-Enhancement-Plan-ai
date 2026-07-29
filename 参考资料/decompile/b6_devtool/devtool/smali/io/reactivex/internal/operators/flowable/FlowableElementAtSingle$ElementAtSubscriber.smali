.class final Lio/reactivex/internal/operators/flowable/FlowableElementAtSingle$ElementAtSubscriber;
.super Ljava/lang/Object;
.source "FlowableElementAtSingle.java"

# interfaces
.implements Lio/reactivex/FlowableSubscriber;
.implements Lio/reactivex/disposables/Disposable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/flowable/FlowableElementAtSingle;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "ElementAtSubscriber"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lio/reactivex/FlowableSubscriber<",
        "TT;>;",
        "Lio/reactivex/disposables/Disposable;"
    }
.end annotation


# instance fields
.field count:J

.field final defaultValue:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field

.field done:Z

.field final downstream:Lio/reactivex/SingleObserver;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/SingleObserver<",
            "-TT;>;"
        }
    .end annotation
.end field

.field final index:J

.field upstream:Lorg/reactivestreams/Subscription;


# direct methods
.method constructor <init>(Lio/reactivex/SingleObserver;JLjava/lang/Object;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/SingleObserver<",
            "-TT;>;JTT;)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableElementAtSingle$ElementAtSubscriber;->downstream:Lio/reactivex/SingleObserver;

    iput-wide p2, p0, Lio/reactivex/internal/operators/flowable/FlowableElementAtSingle$ElementAtSubscriber;->index:J

    iput-object p4, p0, Lio/reactivex/internal/operators/flowable/FlowableElementAtSingle$ElementAtSubscriber;->defaultValue:Ljava/lang/Object;

    return-void
.end method


# virtual methods
.method public dispose()V
    .registers 2

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableElementAtSingle$ElementAtSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    invoke-interface {v0}, Lorg/reactivestreams/Subscription;->cancel()V

    sget-object v0, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->CANCELLED:Lio/reactivex/internal/subscriptions/SubscriptionHelper;

    iput-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableElementAtSingle$ElementAtSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    return-void
.end method

.method public isDisposed()Z
    .registers 3

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableElementAtSingle$ElementAtSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    sget-object v1, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->CANCELLED:Lio/reactivex/internal/subscriptions/SubscriptionHelper;

    if-ne v0, v1, :cond_8

    const/4 v0, 0x1

    goto :goto_9

    :cond_8
    const/4 v0, 0x0

    :goto_9
    return v0
.end method

.method public onComplete()V
    .registers 3

    sget-object v0, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->CANCELLED:Lio/reactivex/internal/subscriptions/SubscriptionHelper;

    iput-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableElementAtSingle$ElementAtSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    iget-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableElementAtSingle$ElementAtSubscriber;->done:Z

    if-nez v0, :cond_1f

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableElementAtSingle$ElementAtSubscriber;->done:Z

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableElementAtSingle$ElementAtSubscriber;->defaultValue:Ljava/lang/Object;

    if-eqz v0, :cond_15

    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableElementAtSingle$ElementAtSubscriber;->downstream:Lio/reactivex/SingleObserver;

    invoke-interface {v1, v0}, Lio/reactivex/SingleObserver;->onSuccess(Ljava/lang/Object;)V

    goto :goto_1f

    :cond_15
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableElementAtSingle$ElementAtSubscriber;->downstream:Lio/reactivex/SingleObserver;

    new-instance v1, Ljava/util/NoSuchElementException;

    invoke-direct {v1}, Ljava/util/NoSuchElementException;-><init>()V

    invoke-interface {v0, v1}, Lio/reactivex/SingleObserver;->onError(Ljava/lang/Throwable;)V

    :cond_1f
    :goto_1f
    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 3

    iget-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableElementAtSingle$ElementAtSubscriber;->done:Z

    if-eqz v0, :cond_8

    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    return-void

    :cond_8
    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableElementAtSingle$ElementAtSubscriber;->done:Z

    sget-object v0, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->CANCELLED:Lio/reactivex/internal/subscriptions/SubscriptionHelper;

    iput-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableElementAtSingle$ElementAtSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableElementAtSingle$ElementAtSubscriber;->downstream:Lio/reactivex/SingleObserver;

    invoke-interface {v0, p1}, Lio/reactivex/SingleObserver;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    iget-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableElementAtSingle$ElementAtSubscriber;->done:Z

    if-eqz v0, :cond_5

    return-void

    :cond_5
    iget-wide v0, p0, Lio/reactivex/internal/operators/flowable/FlowableElementAtSingle$ElementAtSubscriber;->count:J

    iget-wide v2, p0, Lio/reactivex/internal/operators/flowable/FlowableElementAtSingle$ElementAtSubscriber;->index:J

    cmp-long v2, v0, v2

    if-nez v2, :cond_1f

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableElementAtSingle$ElementAtSubscriber;->done:Z

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableElementAtSingle$ElementAtSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    invoke-interface {v0}, Lorg/reactivestreams/Subscription;->cancel()V

    sget-object v0, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->CANCELLED:Lio/reactivex/internal/subscriptions/SubscriptionHelper;

    iput-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableElementAtSingle$ElementAtSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableElementAtSingle$ElementAtSubscriber;->downstream:Lio/reactivex/SingleObserver;

    invoke-interface {v0, p1}, Lio/reactivex/SingleObserver;->onSuccess(Ljava/lang/Object;)V

    return-void

    :cond_1f
    const-wide/16 v2, 0x1

    add-long/2addr v0, v2

    iput-wide v0, p0, Lio/reactivex/internal/operators/flowable/FlowableElementAtSingle$ElementAtSubscriber;->count:J

    return-void
.end method

.method public onSubscribe(Lorg/reactivestreams/Subscription;)V
    .registers 4

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableElementAtSingle$ElementAtSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    invoke-static {v0, p1}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->validate(Lorg/reactivestreams/Subscription;Lorg/reactivestreams/Subscription;)Z

    move-result v0

    if-eqz v0, :cond_17

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableElementAtSingle$ElementAtSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableElementAtSingle$ElementAtSubscriber;->downstream:Lio/reactivex/SingleObserver;

    invoke-interface {v0, p0}, Lio/reactivex/SingleObserver;->onSubscribe(Lio/reactivex/disposables/Disposable;)V

    const-wide v0, 0x7fffffffffffffffL

    invoke-interface {p1, v0, v1}, Lorg/reactivestreams/Subscription;->request(J)V

    :cond_17
    return-void
.end method
