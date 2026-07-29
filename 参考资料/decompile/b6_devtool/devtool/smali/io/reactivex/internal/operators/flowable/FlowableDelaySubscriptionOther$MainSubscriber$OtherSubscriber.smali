.class final Lio/reactivex/internal/operators/flowable/FlowableDelaySubscriptionOther$MainSubscriber$OtherSubscriber;
.super Ljava/util/concurrent/atomic/AtomicReference;
.source "FlowableDelaySubscriptionOther.java"

# interfaces
.implements Lio/reactivex/FlowableSubscriber;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/flowable/FlowableDelaySubscriptionOther$MainSubscriber;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x10
    name = "OtherSubscriber"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/util/concurrent/atomic/AtomicReference<",
        "Lorg/reactivestreams/Subscription;",
        ">;",
        "Lio/reactivex/FlowableSubscriber<",
        "Ljava/lang/Object;",
        ">;"
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = -0x3605ff92ed908fcaL


# instance fields
.field final synthetic this$0:Lio/reactivex/internal/operators/flowable/FlowableDelaySubscriptionOther$MainSubscriber;


# direct methods
.method constructor <init>(Lio/reactivex/internal/operators/flowable/FlowableDelaySubscriptionOther$MainSubscriber;)V
    .registers 2

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableDelaySubscriptionOther$MainSubscriber$OtherSubscriber;->this$0:Lio/reactivex/internal/operators/flowable/FlowableDelaySubscriptionOther$MainSubscriber;

    invoke-direct {p0}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    return-void
.end method


# virtual methods
.method public onComplete()V
    .registers 3

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableDelaySubscriptionOther$MainSubscriber$OtherSubscriber;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/reactivestreams/Subscription;

    sget-object v1, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->CANCELLED:Lio/reactivex/internal/subscriptions/SubscriptionHelper;

    if-eq v0, v1, :cond_f

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableDelaySubscriptionOther$MainSubscriber$OtherSubscriber;->this$0:Lio/reactivex/internal/operators/flowable/FlowableDelaySubscriptionOther$MainSubscriber;

    invoke-virtual {v0}, Lio/reactivex/internal/operators/flowable/FlowableDelaySubscriptionOther$MainSubscriber;->next()V

    :cond_f
    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 4

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableDelaySubscriptionOther$MainSubscriber$OtherSubscriber;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/reactivestreams/Subscription;

    sget-object v1, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->CANCELLED:Lio/reactivex/internal/subscriptions/SubscriptionHelper;

    if-eq v0, v1, :cond_12

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableDelaySubscriptionOther$MainSubscriber$OtherSubscriber;->this$0:Lio/reactivex/internal/operators/flowable/FlowableDelaySubscriptionOther$MainSubscriber;

    iget-object v0, v0, Lio/reactivex/internal/operators/flowable/FlowableDelaySubscriptionOther$MainSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    invoke-interface {v0, p1}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    goto :goto_15

    :cond_12
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :goto_15
    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 3

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableDelaySubscriptionOther$MainSubscriber$OtherSubscriber;->get()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lorg/reactivestreams/Subscription;

    sget-object v0, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->CANCELLED:Lio/reactivex/internal/subscriptions/SubscriptionHelper;

    if-eq p1, v0, :cond_17

    sget-object v0, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->CANCELLED:Lio/reactivex/internal/subscriptions/SubscriptionHelper;

    invoke-virtual {p0, v0}, Lio/reactivex/internal/operators/flowable/FlowableDelaySubscriptionOther$MainSubscriber$OtherSubscriber;->lazySet(Ljava/lang/Object;)V

    invoke-interface {p1}, Lorg/reactivestreams/Subscription;->cancel()V

    iget-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableDelaySubscriptionOther$MainSubscriber$OtherSubscriber;->this$0:Lio/reactivex/internal/operators/flowable/FlowableDelaySubscriptionOther$MainSubscriber;

    invoke-virtual {p1}, Lio/reactivex/internal/operators/flowable/FlowableDelaySubscriptionOther$MainSubscriber;->next()V

    :cond_17
    return-void
.end method

.method public onSubscribe(Lorg/reactivestreams/Subscription;)V
    .registers 4

    invoke-static {p0, p1}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->setOnce(Ljava/util/concurrent/atomic/AtomicReference;Lorg/reactivestreams/Subscription;)Z

    move-result v0

    if-eqz v0, :cond_e

    const-wide v0, 0x7fffffffffffffffL

    invoke-interface {p1, v0, v1}, Lorg/reactivestreams/Subscription;->request(J)V

    :cond_e
    return-void
.end method
