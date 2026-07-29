.class final Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber;
.super Ljava/util/concurrent/atomic/AtomicInteger;
.source "FlowableMergeWithCompletable.java"

# interfaces
.implements Lio/reactivex/FlowableSubscriber;
.implements Lorg/reactivestreams/Subscription;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "MergeWithSubscriber"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber$OtherObserver;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/util/concurrent/atomic/AtomicInteger;",
        "Lio/reactivex/FlowableSubscriber<",
        "TT;>;",
        "Lorg/reactivestreams/Subscription;"
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = -0x3fbd8a98db8e76f7L


# instance fields
.field final downstream:Lorg/reactivestreams/Subscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;"
        }
    .end annotation
.end field

.field final error:Lio/reactivex/internal/util/AtomicThrowable;

.field volatile mainDone:Z

.field final mainSubscription:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference<",
            "Lorg/reactivestreams/Subscription;",
            ">;"
        }
    .end annotation
.end field

.field volatile otherDone:Z

.field final otherObserver:Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber$OtherObserver;

.field final requested:Ljava/util/concurrent/atomic/AtomicLong;


# direct methods
.method constructor <init>(Lorg/reactivestreams/Subscriber;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    new-instance p1, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber;->mainSubscription:Ljava/util/concurrent/atomic/AtomicReference;

    new-instance p1, Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber$OtherObserver;

    invoke-direct {p1, p0}, Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber$OtherObserver;-><init>(Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber;)V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber;->otherObserver:Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber$OtherObserver;

    new-instance p1, Lio/reactivex/internal/util/AtomicThrowable;

    invoke-direct {p1}, Lio/reactivex/internal/util/AtomicThrowable;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber;->error:Lio/reactivex/internal/util/AtomicThrowable;

    new-instance p1, Ljava/util/concurrent/atomic/AtomicLong;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicLong;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    return-void
.end method


# virtual methods
.method public cancel()V
    .registers 2

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber;->mainSubscription:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->cancel(Ljava/util/concurrent/atomic/AtomicReference;)Z

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber;->otherObserver:Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber$OtherObserver;

    invoke-static {v0}, Lio/reactivex/internal/disposables/DisposableHelper;->dispose(Ljava/util/concurrent/atomic/AtomicReference;)Z

    return-void
.end method

.method public onComplete()V
    .registers 3

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber;->mainDone:Z

    iget-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber;->otherDone:Z

    if-eqz v0, :cond_e

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber;->error:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-static {v0, p0, v1}, Lio/reactivex/internal/util/HalfSerializer;->onComplete(Lorg/reactivestreams/Subscriber;Ljava/util/concurrent/atomic/AtomicInteger;Lio/reactivex/internal/util/AtomicThrowable;)V

    :cond_e
    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 4

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber;->otherObserver:Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber$OtherObserver;

    invoke-static {v0}, Lio/reactivex/internal/disposables/DisposableHelper;->dispose(Ljava/util/concurrent/atomic/AtomicReference;)Z

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber;->error:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-static {v0, p1, p0, v1}, Lio/reactivex/internal/util/HalfSerializer;->onError(Lorg/reactivestreams/Subscriber;Ljava/lang/Throwable;Ljava/util/concurrent/atomic/AtomicInteger;Lio/reactivex/internal/util/AtomicThrowable;)V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber;->error:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-static {v0, p1, p0, v1}, Lio/reactivex/internal/util/HalfSerializer;->onNext(Lorg/reactivestreams/Subscriber;Ljava/lang/Object;Ljava/util/concurrent/atomic/AtomicInteger;Lio/reactivex/internal/util/AtomicThrowable;)V

    return-void
.end method

.method public onSubscribe(Lorg/reactivestreams/Subscription;)V
    .registers 4

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber;->mainSubscription:Ljava/util/concurrent/atomic/AtomicReference;

    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-static {v0, v1, p1}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->deferredSetOnce(Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicLong;Lorg/reactivestreams/Subscription;)Z

    return-void
.end method

.method otherComplete()V
    .registers 3

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber;->otherDone:Z

    iget-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber;->mainDone:Z

    if-eqz v0, :cond_e

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber;->error:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-static {v0, p0, v1}, Lio/reactivex/internal/util/HalfSerializer;->onComplete(Lorg/reactivestreams/Subscriber;Ljava/util/concurrent/atomic/AtomicInteger;Lio/reactivex/internal/util/AtomicThrowable;)V

    :cond_e
    return-void
.end method

.method otherError(Ljava/lang/Throwable;)V
    .registers 4

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber;->mainSubscription:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->cancel(Ljava/util/concurrent/atomic/AtomicReference;)Z

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber;->error:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-static {v0, p1, p0, v1}, Lio/reactivex/internal/util/HalfSerializer;->onError(Lorg/reactivestreams/Subscriber;Ljava/lang/Throwable;Ljava/util/concurrent/atomic/AtomicInteger;Lio/reactivex/internal/util/AtomicThrowable;)V

    return-void
.end method

.method public request(J)V
    .registers 5

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber;->mainSubscription:Ljava/util/concurrent/atomic/AtomicReference;

    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableMergeWithCompletable$MergeWithSubscriber;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-static {v0, v1, p1, p2}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->deferredRequest(Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicLong;J)V

    return-void
.end method
