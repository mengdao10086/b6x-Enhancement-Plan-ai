.class final Lio/reactivex/internal/operators/flowable/FlowableFromIterable$IteratorSubscription;
.super Lio/reactivex/internal/operators/flowable/FlowableFromIterable$BaseRangeSubscription;
.source "FlowableFromIterable.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/flowable/FlowableFromIterable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "IteratorSubscription"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lio/reactivex/internal/operators/flowable/FlowableFromIterable$BaseRangeSubscription<",
        "TT;>;"
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = -0x53954cbe186540ffL


# instance fields
.field final downstream:Lorg/reactivestreams/Subscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lorg/reactivestreams/Subscriber;Ljava/util/Iterator;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;",
            "Ljava/util/Iterator<",
            "+TT;>;)V"
        }
    .end annotation

    .line 147
    invoke-direct {p0, p2}, Lio/reactivex/internal/operators/flowable/FlowableFromIterable$BaseRangeSubscription;-><init>(Ljava/util/Iterator;)V

    .line 148
    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableFromIterable$IteratorSubscription;->downstream:Lorg/reactivestreams/Subscriber;

    return-void
.end method


# virtual methods
.method fastPath()V
    .registers 5

    .line 153
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableFromIterable$IteratorSubscription;->it:Ljava/util/Iterator;

    .line 154
    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableFromIterable$IteratorSubscription;->downstream:Lorg/reactivestreams/Subscriber;

    .line 156
    :cond_4
    iget-boolean v2, p0, Lio/reactivex/internal/operators/flowable/FlowableFromIterable$IteratorSubscription;->cancelled:Z

    if-eqz v2, :cond_9

    return-void

    .line 163
    :cond_9
    :try_start_9
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2
    :try_end_d
    .catchall {:try_start_9 .. :try_end_d} :catchall_3d

    .line 170
    iget-boolean v3, p0, Lio/reactivex/internal/operators/flowable/FlowableFromIterable$IteratorSubscription;->cancelled:Z

    if-eqz v3, :cond_12

    return-void

    :cond_12
    if-nez v2, :cond_1f

    .line 175
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v2, "Iterator.next() returned a null value"

    invoke-direct {v0, v2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    invoke-interface {v1, v0}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void

    .line 178
    :cond_1f
    invoke-interface {v1, v2}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    .line 181
    iget-boolean v2, p0, Lio/reactivex/internal/operators/flowable/FlowableFromIterable$IteratorSubscription;->cancelled:Z

    if-eqz v2, :cond_27

    return-void

    .line 188
    :cond_27
    :try_start_27
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2
    :try_end_2b
    .catchall {:try_start_27 .. :try_end_2b} :catchall_35

    if-nez v2, :cond_4

    .line 196
    iget-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableFromIterable$IteratorSubscription;->cancelled:Z

    if-nez v0, :cond_34

    .line 197
    invoke-interface {v1}, Lorg/reactivestreams/Subscriber;->onComplete()V

    :cond_34
    return-void

    :catchall_35
    move-exception v0

    .line 190
    invoke-static {v0}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 191
    invoke-interface {v1, v0}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void

    :catchall_3d
    move-exception v0

    .line 165
    invoke-static {v0}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 166
    invoke-interface {v1, v0}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method slowPath(J)V
    .registers 11

    .line 207
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableFromIterable$IteratorSubscription;->it:Ljava/util/Iterator;

    .line 208
    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableFromIterable$IteratorSubscription;->downstream:Lorg/reactivestreams/Subscriber;

    const-wide/16 v2, 0x0

    :cond_6
    move-wide v4, v2

    :cond_7
    :goto_7
    cmp-long v6, v4, p1

    if-eqz v6, :cond_50

    .line 214
    iget-boolean v6, p0, Lio/reactivex/internal/operators/flowable/FlowableFromIterable$IteratorSubscription;->cancelled:Z

    if-eqz v6, :cond_10

    return-void

    .line 221
    :cond_10
    :try_start_10
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6
    :try_end_14
    .catchall {:try_start_10 .. :try_end_14} :catchall_48

    .line 228
    iget-boolean v7, p0, Lio/reactivex/internal/operators/flowable/FlowableFromIterable$IteratorSubscription;->cancelled:Z

    if-eqz v7, :cond_19

    return-void

    :cond_19
    if-nez v6, :cond_26

    .line 233
    new-instance p1, Ljava/lang/NullPointerException;

    const-string p2, "Iterator.next() returned a null value"

    invoke-direct {p1, p2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    invoke-interface {v1, p1}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void

    .line 236
    :cond_26
    invoke-interface {v1, v6}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    .line 239
    iget-boolean v6, p0, Lio/reactivex/internal/operators/flowable/FlowableFromIterable$IteratorSubscription;->cancelled:Z

    if-eqz v6, :cond_2e

    return-void

    .line 246
    :cond_2e
    :try_start_2e
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v6
    :try_end_32
    .catchall {:try_start_2e .. :try_end_32} :catchall_40

    if-nez v6, :cond_3c

    .line 254
    iget-boolean p1, p0, Lio/reactivex/internal/operators/flowable/FlowableFromIterable$IteratorSubscription;->cancelled:Z

    if-nez p1, :cond_3b

    .line 255
    invoke-interface {v1}, Lorg/reactivestreams/Subscriber;->onComplete()V

    :cond_3b
    return-void

    :cond_3c
    const-wide/16 v6, 0x1

    add-long/2addr v4, v6

    goto :goto_7

    :catchall_40
    move-exception p1

    .line 248
    invoke-static {p1}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 249
    invoke-interface {v1, p1}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void

    :catchall_48
    move-exception p1

    .line 223
    invoke-static {p1}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 224
    invoke-interface {v1, p1}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void

    .line 263
    :cond_50
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableFromIterable$IteratorSubscription;->get()J

    move-result-wide p1

    cmp-long v6, v4, p1

    if-nez v6, :cond_7

    neg-long p1, v4

    .line 265
    invoke-virtual {p0, p1, p2}, Lio/reactivex/internal/operators/flowable/FlowableFromIterable$IteratorSubscription;->addAndGet(J)J

    move-result-wide p1

    cmp-long v4, p1, v2

    if-nez v4, :cond_6

    return-void
.end method
