.class final Lio/reactivex/internal/operators/flowable/FlowableRange$RangeConditionalSubscription;
.super Lio/reactivex/internal/operators/flowable/FlowableRange$BaseRangeSubscription;
.source "FlowableRange.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/flowable/FlowableRange;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "RangeConditionalSubscription"
.end annotation


# static fields
.field private static final serialVersionUID:J = 0x23e7f25903d0c345L


# instance fields
.field final downstream:Lio/reactivex/internal/fuseable/ConditionalSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/internal/fuseable/ConditionalSubscriber<",
            "-",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lio/reactivex/internal/fuseable/ConditionalSubscriber;II)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/internal/fuseable/ConditionalSubscriber<",
            "-",
            "Ljava/lang/Integer;",
            ">;II)V"
        }
    .end annotation

    invoke-direct {p0, p2, p3}, Lio/reactivex/internal/operators/flowable/FlowableRange$BaseRangeSubscription;-><init>(II)V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableRange$RangeConditionalSubscription;->downstream:Lio/reactivex/internal/fuseable/ConditionalSubscriber;

    return-void
.end method


# virtual methods
.method fastPath()V
    .registers 5

    iget v0, p0, Lio/reactivex/internal/operators/flowable/FlowableRange$RangeConditionalSubscription;->end:I

    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableRange$RangeConditionalSubscription;->downstream:Lio/reactivex/internal/fuseable/ConditionalSubscriber;

    iget v2, p0, Lio/reactivex/internal/operators/flowable/FlowableRange$RangeConditionalSubscription;->index:I

    :goto_6
    if-eq v2, v0, :cond_17

    iget-boolean v3, p0, Lio/reactivex/internal/operators/flowable/FlowableRange$RangeConditionalSubscription;->cancelled:Z

    if-eqz v3, :cond_d

    return-void

    :cond_d
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v1, v3}, Lio/reactivex/internal/fuseable/ConditionalSubscriber;->tryOnNext(Ljava/lang/Object;)Z

    add-int/lit8 v2, v2, 0x1

    goto :goto_6

    :cond_17
    iget-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableRange$RangeConditionalSubscription;->cancelled:Z

    if-eqz v0, :cond_1c

    return-void

    :cond_1c
    invoke-interface {v1}, Lio/reactivex/internal/fuseable/ConditionalSubscriber;->onComplete()V

    return-void
.end method

.method slowPath(J)V
    .registers 12

    iget v0, p0, Lio/reactivex/internal/operators/flowable/FlowableRange$RangeConditionalSubscription;->end:I

    iget v1, p0, Lio/reactivex/internal/operators/flowable/FlowableRange$RangeConditionalSubscription;->index:I

    iget-object v2, p0, Lio/reactivex/internal/operators/flowable/FlowableRange$RangeConditionalSubscription;->downstream:Lio/reactivex/internal/fuseable/ConditionalSubscriber;

    const-wide/16 v3, 0x0

    :cond_8
    move-wide v5, v3

    :cond_9
    :goto_9
    cmp-long v7, v5, p1

    if-eqz v7, :cond_24

    if-eq v1, v0, :cond_24

    iget-boolean v7, p0, Lio/reactivex/internal/operators/flowable/FlowableRange$RangeConditionalSubscription;->cancelled:Z

    if-eqz v7, :cond_14

    return-void

    :cond_14
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-interface {v2, v7}, Lio/reactivex/internal/fuseable/ConditionalSubscriber;->tryOnNext(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_21

    const-wide/16 v7, 0x1

    add-long/2addr v5, v7

    :cond_21
    add-int/lit8 v1, v1, 0x1

    goto :goto_9

    :cond_24
    if-ne v1, v0, :cond_2e

    iget-boolean p1, p0, Lio/reactivex/internal/operators/flowable/FlowableRange$RangeConditionalSubscription;->cancelled:Z

    if-nez p1, :cond_2d

    invoke-interface {v2}, Lio/reactivex/internal/fuseable/ConditionalSubscriber;->onComplete()V

    :cond_2d
    return-void

    :cond_2e
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableRange$RangeConditionalSubscription;->get()J

    move-result-wide p1

    cmp-long v7, v5, p1

    if-nez v7, :cond_9

    iput v1, p0, Lio/reactivex/internal/operators/flowable/FlowableRange$RangeConditionalSubscription;->index:I

    neg-long p1, v5

    invoke-virtual {p0, p1, p2}, Lio/reactivex/internal/operators/flowable/FlowableRange$RangeConditionalSubscription;->addAndGet(J)J

    move-result-wide p1

    cmp-long v5, p1, v3

    if-nez v5, :cond_8

    return-void
.end method
