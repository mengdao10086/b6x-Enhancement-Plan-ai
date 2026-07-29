.class final Lio/reactivex/internal/operators/flowable/FlowableDistinctUntilChanged$DistinctUntilChangedConditionalSubscriber;
.super Lio/reactivex/internal/subscribers/BasicFuseableConditionalSubscriber;
.source "FlowableDistinctUntilChanged.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/flowable/FlowableDistinctUntilChanged;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "DistinctUntilChangedConditionalSubscriber"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        "K:",
        "Ljava/lang/Object;",
        ">",
        "Lio/reactivex/internal/subscribers/BasicFuseableConditionalSubscriber<",
        "TT;TT;>;"
    }
.end annotation


# instance fields
.field final comparer:Lio/reactivex/functions/BiPredicate;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/functions/BiPredicate<",
            "-TK;-TK;>;"
        }
    .end annotation
.end field

.field hasValue:Z

.field final keySelector:Lio/reactivex/functions/Function;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/functions/Function<",
            "-TT;TK;>;"
        }
    .end annotation
.end field

.field last:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TK;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lio/reactivex/internal/fuseable/ConditionalSubscriber;Lio/reactivex/functions/Function;Lio/reactivex/functions/BiPredicate;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/internal/fuseable/ConditionalSubscriber<",
            "-TT;>;",
            "Lio/reactivex/functions/Function<",
            "-TT;TK;>;",
            "Lio/reactivex/functions/BiPredicate<",
            "-TK;-TK;>;)V"
        }
    .end annotation

    .line 151
    invoke-direct {p0, p1}, Lio/reactivex/internal/subscribers/BasicFuseableConditionalSubscriber;-><init>(Lio/reactivex/internal/fuseable/ConditionalSubscriber;)V

    .line 152
    iput-object p2, p0, Lio/reactivex/internal/operators/flowable/FlowableDistinctUntilChanged$DistinctUntilChangedConditionalSubscriber;->keySelector:Lio/reactivex/functions/Function;

    .line 153
    iput-object p3, p0, Lio/reactivex/internal/operators/flowable/FlowableDistinctUntilChanged$DistinctUntilChangedConditionalSubscriber;->comparer:Lio/reactivex/functions/BiPredicate;

    return-void
.end method


# virtual methods
.method public onNext(Ljava/lang/Object;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 158
    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/flowable/FlowableDistinctUntilChanged$DistinctUntilChangedConditionalSubscriber;->tryOnNext(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_d

    .line 159
    iget-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableDistinctUntilChanged$DistinctUntilChangedConditionalSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    const-wide/16 v0, 0x1

    invoke-interface {p1, v0, v1}, Lorg/reactivestreams/Subscription;->request(J)V

    :cond_d
    return-void
.end method

.method public poll()Ljava/lang/Object;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .line 204
    :cond_0
    :goto_0
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableDistinctUntilChanged$DistinctUntilChangedConditionalSubscriber;->qs:Lio/reactivex/internal/fuseable/QueueSubscription;

    invoke-interface {v0}, Lio/reactivex/internal/fuseable/QueueSubscription;->poll()Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_a

    const/4 v0, 0x0

    return-object v0

    .line 208
    :cond_a
    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableDistinctUntilChanged$DistinctUntilChangedConditionalSubscriber;->keySelector:Lio/reactivex/functions/Function;

    invoke-interface {v1, v0}, Lio/reactivex/functions/Function;->apply(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 209
    iget-boolean v2, p0, Lio/reactivex/internal/operators/flowable/FlowableDistinctUntilChanged$DistinctUntilChangedConditionalSubscriber;->hasValue:Z

    const/4 v3, 0x1

    if-nez v2, :cond_1a

    .line 210
    iput-boolean v3, p0, Lio/reactivex/internal/operators/flowable/FlowableDistinctUntilChanged$DistinctUntilChangedConditionalSubscriber;->hasValue:Z

    .line 211
    iput-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableDistinctUntilChanged$DistinctUntilChangedConditionalSubscriber;->last:Ljava/lang/Object;

    return-object v0

    .line 215
    :cond_1a
    iget-object v2, p0, Lio/reactivex/internal/operators/flowable/FlowableDistinctUntilChanged$DistinctUntilChangedConditionalSubscriber;->comparer:Lio/reactivex/functions/BiPredicate;

    iget-object v4, p0, Lio/reactivex/internal/operators/flowable/FlowableDistinctUntilChanged$DistinctUntilChangedConditionalSubscriber;->last:Ljava/lang/Object;

    invoke-interface {v2, v4, v1}, Lio/reactivex/functions/BiPredicate;->test(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_27

    .line 216
    iput-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableDistinctUntilChanged$DistinctUntilChangedConditionalSubscriber;->last:Ljava/lang/Object;

    return-object v0

    .line 219
    :cond_27
    iput-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableDistinctUntilChanged$DistinctUntilChangedConditionalSubscriber;->last:Ljava/lang/Object;

    .line 220
    iget v0, p0, Lio/reactivex/internal/operators/flowable/FlowableDistinctUntilChanged$DistinctUntilChangedConditionalSubscriber;->sourceMode:I

    if-eq v0, v3, :cond_0

    .line 221
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableDistinctUntilChanged$DistinctUntilChangedConditionalSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    const-wide/16 v1, 0x1

    invoke-interface {v0, v1, v2}, Lorg/reactivestreams/Subscription;->request(J)V

    goto :goto_0
.end method

.method public requestFusion(I)I
    .registers 2

    .line 197
    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/flowable/FlowableDistinctUntilChanged$DistinctUntilChangedConditionalSubscriber;->transitiveBoundaryFusion(I)I

    move-result p1

    return p1
.end method

.method public tryOnNext(Ljava/lang/Object;)Z
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)Z"
        }
    .end annotation

    .line 165
    iget-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableDistinctUntilChanged$DistinctUntilChangedConditionalSubscriber;->done:Z

    const/4 v1, 0x0

    if-eqz v0, :cond_6

    return v1

    .line 168
    :cond_6
    iget v0, p0, Lio/reactivex/internal/operators/flowable/FlowableDistinctUntilChanged$DistinctUntilChangedConditionalSubscriber;->sourceMode:I

    if-eqz v0, :cond_11

    .line 169
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableDistinctUntilChanged$DistinctUntilChangedConditionalSubscriber;->downstream:Lio/reactivex/internal/fuseable/ConditionalSubscriber;

    invoke-interface {v0, p1}, Lio/reactivex/internal/fuseable/ConditionalSubscriber;->tryOnNext(Ljava/lang/Object;)Z

    move-result p1

    return p1

    :cond_11
    const/4 v0, 0x1

    .line 175
    :try_start_12
    iget-object v2, p0, Lio/reactivex/internal/operators/flowable/FlowableDistinctUntilChanged$DistinctUntilChangedConditionalSubscriber;->keySelector:Lio/reactivex/functions/Function;

    invoke-interface {v2, p1}, Lio/reactivex/functions/Function;->apply(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 176
    iget-boolean v3, p0, Lio/reactivex/internal/operators/flowable/FlowableDistinctUntilChanged$DistinctUntilChangedConditionalSubscriber;->hasValue:Z

    if-eqz v3, :cond_29

    .line 177
    iget-object v3, p0, Lio/reactivex/internal/operators/flowable/FlowableDistinctUntilChanged$DistinctUntilChangedConditionalSubscriber;->comparer:Lio/reactivex/functions/BiPredicate;

    iget-object v4, p0, Lio/reactivex/internal/operators/flowable/FlowableDistinctUntilChanged$DistinctUntilChangedConditionalSubscriber;->last:Ljava/lang/Object;

    invoke-interface {v3, v4, v2}, Lio/reactivex/functions/BiPredicate;->test(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    .line 178
    iput-object v2, p0, Lio/reactivex/internal/operators/flowable/FlowableDistinctUntilChanged$DistinctUntilChangedConditionalSubscriber;->last:Ljava/lang/Object;

    if-eqz v3, :cond_2d

    return v1

    .line 183
    :cond_29
    iput-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableDistinctUntilChanged$DistinctUntilChangedConditionalSubscriber;->hasValue:Z

    .line 184
    iput-object v2, p0, Lio/reactivex/internal/operators/flowable/FlowableDistinctUntilChanged$DistinctUntilChangedConditionalSubscriber;->last:Ljava/lang/Object;
    :try_end_2d
    .catchall {:try_start_12 .. :try_end_2d} :catchall_33

    .line 191
    :cond_2d
    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableDistinctUntilChanged$DistinctUntilChangedConditionalSubscriber;->downstream:Lio/reactivex/internal/fuseable/ConditionalSubscriber;

    invoke-interface {v1, p1}, Lio/reactivex/internal/fuseable/ConditionalSubscriber;->onNext(Ljava/lang/Object;)V

    return v0

    :catchall_33
    move-exception p1

    .line 187
    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/flowable/FlowableDistinctUntilChanged$DistinctUntilChangedConditionalSubscriber;->fail(Ljava/lang/Throwable;)V

    return v0
.end method
