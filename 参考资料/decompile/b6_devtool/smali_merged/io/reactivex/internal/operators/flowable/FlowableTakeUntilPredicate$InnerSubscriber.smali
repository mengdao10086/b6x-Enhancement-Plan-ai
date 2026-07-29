.class final Lio/reactivex/internal/operators/flowable/FlowableTakeUntilPredicate$InnerSubscriber;
.super Ljava/lang/Object;
.source "FlowableTakeUntilPredicate.java"

# interfaces
.implements Lio/reactivex/FlowableSubscriber;
.implements Lorg/reactivestreams/Subscription;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/flowable/FlowableTakeUntilPredicate;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "InnerSubscriber"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lio/reactivex/FlowableSubscriber<",
        "TT;>;",
        "Lorg/reactivestreams/Subscription;"
    }
.end annotation


# instance fields
.field done:Z

.field final downstream:Lorg/reactivestreams/Subscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;"
        }
    .end annotation
.end field

.field final predicate:Lio/reactivex/functions/Predicate;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/functions/Predicate<",
            "-TT;>;"
        }
    .end annotation
.end field

.field upstream:Lorg/reactivestreams/Subscription;


# direct methods
.method constructor <init>(Lorg/reactivestreams/Subscriber;Lio/reactivex/functions/Predicate;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;",
            "Lio/reactivex/functions/Predicate<",
            "-TT;>;)V"
        }
    .end annotation

    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableTakeUntilPredicate$InnerSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    .line 43
    iput-object p2, p0, Lio/reactivex/internal/operators/flowable/FlowableTakeUntilPredicate$InnerSubscriber;->predicate:Lio/reactivex/functions/Predicate;

    return-void
.end method


# virtual methods
.method public cancel()V
    .registers 2

    .line 100
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableTakeUntilPredicate$InnerSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    invoke-interface {v0}, Lorg/reactivestreams/Subscription;->cancel()V

    return-void
.end method

.method public onComplete()V
    .registers 2

    .line 87
    iget-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableTakeUntilPredicate$InnerSubscriber;->done:Z

    if-nez v0, :cond_c

    const/4 v0, 0x1

    .line 88
    iput-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableTakeUntilPredicate$InnerSubscriber;->done:Z

    .line 89
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableTakeUntilPredicate$InnerSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    invoke-interface {v0}, Lorg/reactivestreams/Subscriber;->onComplete()V

    :cond_c
    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 3

    .line 77
    iget-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableTakeUntilPredicate$InnerSubscriber;->done:Z

    if-nez v0, :cond_d

    const/4 v0, 0x1

    .line 78
    iput-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableTakeUntilPredicate$InnerSubscriber;->done:Z

    .line 79
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableTakeUntilPredicate$InnerSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    invoke-interface {v0, p1}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    goto :goto_10

    .line 81
    :cond_d
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :goto_10
    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 56
    iget-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableTakeUntilPredicate$InnerSubscriber;->done:Z

    if-nez v0, :cond_2b

    .line 57
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableTakeUntilPredicate$InnerSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    invoke-interface {v0, p1}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    .line 60
    :try_start_9
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableTakeUntilPredicate$InnerSubscriber;->predicate:Lio/reactivex/functions/Predicate;

    invoke-interface {v0, p1}, Lio/reactivex/functions/Predicate;->test(Ljava/lang/Object;)Z

    move-result p1
    :try_end_f
    .catchall {:try_start_9 .. :try_end_f} :catchall_1f

    if-eqz p1, :cond_2b

    const/4 p1, 0x1

    .line 68
    iput-boolean p1, p0, Lio/reactivex/internal/operators/flowable/FlowableTakeUntilPredicate$InnerSubscriber;->done:Z

    .line 69
    iget-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableTakeUntilPredicate$InnerSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    invoke-interface {p1}, Lorg/reactivestreams/Subscription;->cancel()V

    .line 70
    iget-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableTakeUntilPredicate$InnerSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    invoke-interface {p1}, Lorg/reactivestreams/Subscriber;->onComplete()V

    goto :goto_2b

    :catchall_1f
    move-exception p1

    .line 62
    invoke-static {p1}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 63
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableTakeUntilPredicate$InnerSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    invoke-interface {v0}, Lorg/reactivestreams/Subscription;->cancel()V

    .line 64
    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/flowable/FlowableTakeUntilPredicate$InnerSubscriber;->onError(Ljava/lang/Throwable;)V

    :cond_2b
    :goto_2b
    return-void
.end method

.method public onSubscribe(Lorg/reactivestreams/Subscription;)V
    .registers 3

    .line 48
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableTakeUntilPredicate$InnerSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    invoke-static {v0, p1}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->validate(Lorg/reactivestreams/Subscription;Lorg/reactivestreams/Subscription;)Z

    move-result v0

    if-eqz v0, :cond_f

    .line 49
    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableTakeUntilPredicate$InnerSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    .line 50
    iget-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableTakeUntilPredicate$InnerSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    invoke-interface {p1, p0}, Lorg/reactivestreams/Subscriber;->onSubscribe(Lorg/reactivestreams/Subscription;)V

    :cond_f
    return-void
.end method

.method public request(J)V
    .registers 4

    .line 95
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableTakeUntilPredicate$InnerSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    invoke-interface {v0, p1, p2}, Lorg/reactivestreams/Subscription;->request(J)V

    return-void
.end method
