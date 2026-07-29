.class final Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextIterator;
.super Ljava/lang/Object;
.source "BlockingFlowableNext.java"

# interfaces
.implements Ljava/util/Iterator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/flowable/BlockingFlowableNext;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "NextIterator"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Ljava/util/Iterator<",
        "TT;>;"
    }
.end annotation


# instance fields
.field private error:Ljava/lang/Throwable;

.field private hasNext:Z

.field private isNextConsumed:Z

.field private final items:Lorg/reactivestreams/Publisher;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/reactivestreams/Publisher<",
            "+TT;>;"
        }
    .end annotation
.end field

.field private next:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field

.field private started:Z

.field private final subscriber:Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextSubscriber<",
            "TT;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lorg/reactivestreams/Publisher;Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextSubscriber;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Publisher<",
            "+TT;>;",
            "Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextSubscriber<",
            "TT;>;)V"
        }
    .end annotation

    .line 59
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x1

    .line 54
    iput-boolean v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextIterator;->hasNext:Z

    .line 55
    iput-boolean v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextIterator;->isNextConsumed:Z

    .line 60
    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextIterator;->items:Lorg/reactivestreams/Publisher;

    .line 61
    iput-object p2, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextIterator;->subscriber:Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextSubscriber;

    return-void
.end method

.method private moveToNext()Z
    .registers 5

    .line 82
    :try_start_0
    iget-boolean v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextIterator;->started:Z

    const/4 v1, 0x1

    if-nez v0, :cond_1b

    .line 83
    iput-boolean v1, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextIterator;->started:Z

    .line 85
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextIterator;->subscriber:Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextSubscriber;

    invoke-virtual {v0}, Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextSubscriber;->setWaiting()V

    .line 86
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextIterator;->items:Lorg/reactivestreams/Publisher;

    invoke-static {v0}, Lio/reactivex/Flowable;->fromPublisher(Lorg/reactivestreams/Publisher;)Lio/reactivex/Flowable;

    move-result-object v0

    .line 87
    invoke-virtual {v0}, Lio/reactivex/Flowable;->materialize()Lio/reactivex/Flowable;

    move-result-object v0

    iget-object v2, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextIterator;->subscriber:Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextSubscriber;

    invoke-virtual {v0, v2}, Lio/reactivex/Flowable;->subscribe(Lio/reactivex/FlowableSubscriber;)V

    .line 90
    :cond_1b
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextIterator;->subscriber:Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextSubscriber;

    invoke-virtual {v0}, Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextSubscriber;->takeNext()Lio/reactivex/Notification;

    move-result-object v0

    .line 91
    invoke-virtual {v0}, Lio/reactivex/Notification;->isOnNext()Z

    move-result v2

    const/4 v3, 0x0

    if-eqz v2, :cond_31

    .line 92
    iput-boolean v3, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextIterator;->isNextConsumed:Z

    .line 93
    invoke-virtual {v0}, Lio/reactivex/Notification;->getValue()Ljava/lang/Object;

    move-result-object v0

    iput-object v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextIterator;->next:Ljava/lang/Object;

    return v1

    .line 98
    :cond_31
    iput-boolean v3, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextIterator;->hasNext:Z

    .line 99
    invoke-virtual {v0}, Lio/reactivex/Notification;->isOnComplete()Z

    move-result v1

    if-eqz v1, :cond_3a

    return v3

    .line 102
    :cond_3a
    invoke-virtual {v0}, Lio/reactivex/Notification;->isOnError()Z

    move-result v1

    if-eqz v1, :cond_4b

    .line 103
    invoke-virtual {v0}, Lio/reactivex/Notification;->getError()Ljava/lang/Throwable;

    move-result-object v0

    iput-object v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextIterator;->error:Ljava/lang/Throwable;

    .line 104
    invoke-static {v0}, Lio/reactivex/internal/util/ExceptionHelper;->wrapOrThrow(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0

    .line 106
    :cond_4b
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Should not reach here"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_53
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_53} :catch_53

    :catch_53
    move-exception v0

    .line 108
    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextIterator;->subscriber:Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextSubscriber;

    invoke-virtual {v1}, Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextSubscriber;->dispose()V

    .line 109
    iput-object v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextIterator;->error:Ljava/lang/Throwable;

    .line 110
    invoke-static {v0}, Lio/reactivex/internal/util/ExceptionHelper;->wrapOrThrow(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method


# virtual methods
.method public hasNext()Z
    .registers 3

    .line 66
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextIterator;->error:Ljava/lang/Throwable;

    if-nez v0, :cond_16

    .line 72
    iget-boolean v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextIterator;->hasNext:Z

    const/4 v1, 0x0

    if-nez v0, :cond_a

    return v1

    .line 77
    :cond_a
    iget-boolean v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextIterator;->isNextConsumed:Z

    if-eqz v0, :cond_14

    invoke-direct {p0}, Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextIterator;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_15

    :cond_14
    const/4 v1, 0x1

    :cond_15
    return v1

    .line 68
    :cond_16
    invoke-static {v0}, Lio/reactivex/internal/util/ExceptionHelper;->wrapOrThrow(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public next()Ljava/lang/Object;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .line 116
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextIterator;->error:Ljava/lang/Throwable;

    if-nez v0, :cond_18

    .line 120
    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextIterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_10

    const/4 v0, 0x1

    .line 121
    iput-boolean v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextIterator;->isNextConsumed:Z

    .line 122
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/BlockingFlowableNext$NextIterator;->next:Ljava/lang/Object;

    return-object v0

    .line 125
    :cond_10
    new-instance v0, Ljava/util/NoSuchElementException;

    const-string v1, "No more elements"

    invoke-direct {v0, v1}, Ljava/util/NoSuchElementException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 118
    :cond_18
    invoke-static {v0}, Lio/reactivex/internal/util/ExceptionHelper;->wrapOrThrow(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public remove()V
    .registers 3

    .line 131
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "Read only iterator"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
