.class final Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;
.super Ljava/util/concurrent/atomic/AtomicInteger;
.source "FlowableConcatMapMaybe.java"

# interfaces
.implements Lio/reactivex/FlowableSubscriber;
.implements Lorg/reactivestreams/Subscription;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "ConcatMapMaybeSubscriber"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber$ConcatMapMaybeObserver;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        "R:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/util/concurrent/atomic/AtomicInteger;",
        "Lio/reactivex/FlowableSubscriber<",
        "TT;>;",
        "Lorg/reactivestreams/Subscription;"
    }
.end annotation


# static fields
.field static final STATE_ACTIVE:I = 0x1

.field static final STATE_INACTIVE:I = 0x0

.field static final STATE_RESULT_VALUE:I = 0x2

.field private static final serialVersionUID:J = -0x7ed83da4674d8da5L


# instance fields
.field volatile cancelled:Z

.field consumed:I

.field volatile done:Z

.field final downstream:Lorg/reactivestreams/Subscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/reactivestreams/Subscriber<",
            "-TR;>;"
        }
    .end annotation
.end field

.field emitted:J

.field final errorMode:Lio/reactivex/internal/util/ErrorMode;

.field final errors:Lio/reactivex/internal/util/AtomicThrowable;

.field final inner:Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber$ConcatMapMaybeObserver;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber$ConcatMapMaybeObserver<",
            "TR;>;"
        }
    .end annotation
.end field

.field item:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TR;"
        }
    .end annotation
.end field

.field final mapper:Lio/reactivex/functions/Function;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/functions/Function<",
            "-TT;+",
            "Lio/reactivex/MaybeSource<",
            "+TR;>;>;"
        }
    .end annotation
.end field

.field final prefetch:I

.field final queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/internal/fuseable/SimplePlainQueue<",
            "TT;>;"
        }
    .end annotation
.end field

.field final requested:Ljava/util/concurrent/atomic/AtomicLong;

.field volatile state:I

.field upstream:Lorg/reactivestreams/Subscription;


# direct methods
.method constructor <init>(Lorg/reactivestreams/Subscriber;Lio/reactivex/functions/Function;ILio/reactivex/internal/util/ErrorMode;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Subscriber<",
            "-TR;>;",
            "Lio/reactivex/functions/Function<",
            "-TT;+",
            "Lio/reactivex/MaybeSource<",
            "+TR;>;>;I",
            "Lio/reactivex/internal/util/ErrorMode;",
            ")V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    iput-object p2, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->mapper:Lio/reactivex/functions/Function;

    iput p3, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->prefetch:I

    iput-object p4, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->errorMode:Lio/reactivex/internal/util/ErrorMode;

    new-instance p1, Ljava/util/concurrent/atomic/AtomicLong;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicLong;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    new-instance p1, Lio/reactivex/internal/util/AtomicThrowable;

    invoke-direct {p1}, Lio/reactivex/internal/util/AtomicThrowable;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    new-instance p1, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber$ConcatMapMaybeObserver;

    invoke-direct {p1, p0}, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber$ConcatMapMaybeObserver;-><init>(Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;)V

    iput-object p1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->inner:Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber$ConcatMapMaybeObserver;

    new-instance p1, Lio/reactivex/internal/queue/SpscArrayQueue;

    invoke-direct {p1, p3}, Lio/reactivex/internal/queue/SpscArrayQueue;-><init>(I)V

    iput-object p1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    return-void
.end method


# virtual methods
.method public cancel()V
    .registers 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->cancelled:Z

    iget-object v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    invoke-interface {v0}, Lorg/reactivestreams/Subscription;->cancel()V

    iget-object v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->inner:Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber$ConcatMapMaybeObserver;

    invoke-virtual {v0}, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber$ConcatMapMaybeObserver;->dispose()V

    invoke-virtual {p0}, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->getAndIncrement()I

    move-result v0

    if-nez v0, :cond_1b

    iget-object v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    invoke-interface {v0}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->clear()V

    const/4 v0, 0x0

    iput-object v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->item:Ljava/lang/Object;

    :cond_1b
    return-void
.end method

.method drain()V
    .registers 16

    invoke-virtual {p0}, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->getAndIncrement()I

    move-result v0

    if-eqz v0, :cond_7

    return-void

    :cond_7
    iget-object v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    iget-object v1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->errorMode:Lio/reactivex/internal/util/ErrorMode;

    iget-object v2, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    iget-object v3, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    iget-object v4, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    iget v5, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->prefetch:I

    shr-int/lit8 v6, v5, 0x1

    sub-int/2addr v5, v6

    const/4 v6, 0x1

    move v7, v6

    :cond_18
    :goto_18
    iget-boolean v8, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->cancelled:Z

    const/4 v9, 0x0

    if-eqz v8, :cond_24

    invoke-interface {v2}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->clear()V

    iput-object v9, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->item:Ljava/lang/Object;

    goto/16 :goto_c0

    :cond_24
    iget v8, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->state:I

    invoke-virtual {v3}, Lio/reactivex/internal/util/AtomicThrowable;->get()Ljava/lang/Object;

    move-result-object v10

    if-eqz v10, :cond_43

    sget-object v10, Lio/reactivex/internal/util/ErrorMode;->IMMEDIATE:Lio/reactivex/internal/util/ErrorMode;

    if-eq v1, v10, :cond_36

    sget-object v10, Lio/reactivex/internal/util/ErrorMode;->BOUNDARY:Lio/reactivex/internal/util/ErrorMode;

    if-ne v1, v10, :cond_43

    if-nez v8, :cond_43

    :cond_36
    invoke-interface {v2}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->clear()V

    iput-object v9, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->item:Ljava/lang/Object;

    invoke-virtual {v3}, Lio/reactivex/internal/util/AtomicThrowable;->terminate()Ljava/lang/Throwable;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void

    :cond_43
    const/4 v10, 0x0

    if-nez v8, :cond_a3

    iget-boolean v8, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->done:Z

    invoke-interface {v2}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->poll()Ljava/lang/Object;

    move-result-object v9

    if-nez v9, :cond_50

    move v11, v6

    goto :goto_51

    :cond_50
    move v11, v10

    :goto_51
    if-eqz v8, :cond_63

    if-eqz v11, :cond_63

    invoke-virtual {v3}, Lio/reactivex/internal/util/AtomicThrowable;->terminate()Ljava/lang/Throwable;

    move-result-object v1

    if-nez v1, :cond_5f

    invoke-interface {v0}, Lorg/reactivestreams/Subscriber;->onComplete()V

    goto :goto_62

    :cond_5f
    invoke-interface {v0, v1}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    :goto_62
    return-void

    :cond_63
    if-eqz v11, :cond_66

    goto :goto_c0

    :cond_66
    iget v8, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->consumed:I

    add-int/2addr v8, v6

    if-ne v8, v5, :cond_74

    iput v10, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->consumed:I

    iget-object v8, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    int-to-long v10, v5

    invoke-interface {v8, v10, v11}, Lorg/reactivestreams/Subscription;->request(J)V

    goto :goto_76

    :cond_74
    iput v8, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->consumed:I

    :goto_76
    :try_start_76
    iget-object v8, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->mapper:Lio/reactivex/functions/Function;

    invoke-interface {v8, v9}, Lio/reactivex/functions/Function;->apply(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    const-string v9, "The mapper returned a null MaybeSource"

    invoke-static {v8, v9}, Lio/reactivex/internal/functions/ObjectHelper;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lio/reactivex/MaybeSource;
    :try_end_84
    .catchall {:try_start_76 .. :try_end_84} :catchall_8c

    iput v6, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->state:I

    iget-object v9, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->inner:Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber$ConcatMapMaybeObserver;

    invoke-interface {v8, v9}, Lio/reactivex/MaybeSource;->subscribe(Lio/reactivex/MaybeObserver;)V

    goto :goto_c0

    :catchall_8c
    move-exception v1

    invoke-static {v1}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    iget-object v4, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    invoke-interface {v4}, Lorg/reactivestreams/Subscription;->cancel()V

    invoke-interface {v2}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->clear()V

    invoke-virtual {v3, v1}, Lio/reactivex/internal/util/AtomicThrowable;->addThrowable(Ljava/lang/Throwable;)Z

    invoke-virtual {v3}, Lio/reactivex/internal/util/AtomicThrowable;->terminate()Ljava/lang/Throwable;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void

    :cond_a3
    const/4 v11, 0x2

    if-ne v8, v11, :cond_c0

    iget-wide v11, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->emitted:J

    invoke-virtual {v4}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v13

    cmp-long v8, v11, v13

    if-eqz v8, :cond_c0

    iget-object v8, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->item:Ljava/lang/Object;

    iput-object v9, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->item:Ljava/lang/Object;

    invoke-interface {v0, v8}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    const-wide/16 v8, 0x1

    add-long/2addr v11, v8

    iput-wide v11, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->emitted:J

    iput v10, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->state:I

    goto/16 :goto_18

    :cond_c0
    :goto_c0
    neg-int v7, v7

    invoke-virtual {p0, v7}, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->addAndGet(I)I

    move-result v7

    if-nez v7, :cond_18

    return-void
.end method

.method innerComplete()V
    .registers 2

    const/4 v0, 0x0

    iput v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->state:I

    invoke-virtual {p0}, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->drain()V

    return-void
.end method

.method innerError(Ljava/lang/Throwable;)V
    .registers 3

    iget-object v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v0, p1}, Lio/reactivex/internal/util/AtomicThrowable;->addThrowable(Ljava/lang/Throwable;)Z

    move-result v0

    if-eqz v0, :cond_1a

    iget-object p1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->errorMode:Lio/reactivex/internal/util/ErrorMode;

    sget-object v0, Lio/reactivex/internal/util/ErrorMode;->END:Lio/reactivex/internal/util/ErrorMode;

    if-eq p1, v0, :cond_13

    iget-object p1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    invoke-interface {p1}, Lorg/reactivestreams/Subscription;->cancel()V

    :cond_13
    const/4 p1, 0x0

    iput p1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->state:I

    invoke-virtual {p0}, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->drain()V

    goto :goto_1d

    :cond_1a
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :goto_1d
    return-void
.end method

.method innerSuccess(Ljava/lang/Object;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TR;)V"
        }
    .end annotation

    iput-object p1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->item:Ljava/lang/Object;

    const/4 p1, 0x2

    iput p1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->state:I

    invoke-virtual {p0}, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->drain()V

    return-void
.end method

.method public onComplete()V
    .registers 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->done:Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->drain()V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 3

    iget-object v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v0, p1}, Lio/reactivex/internal/util/AtomicThrowable;->addThrowable(Ljava/lang/Throwable;)Z

    move-result v0

    if-eqz v0, :cond_1a

    iget-object p1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->errorMode:Lio/reactivex/internal/util/ErrorMode;

    sget-object v0, Lio/reactivex/internal/util/ErrorMode;->IMMEDIATE:Lio/reactivex/internal/util/ErrorMode;

    if-ne p1, v0, :cond_13

    iget-object p1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->inner:Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber$ConcatMapMaybeObserver;

    invoke-virtual {p1}, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber$ConcatMapMaybeObserver;->dispose()V

    :cond_13
    const/4 p1, 0x1

    iput-boolean p1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->done:Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->drain()V

    goto :goto_1d

    :cond_1a
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :goto_1d
    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    iget-object v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    invoke-interface {v0, p1}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->offer(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_18

    iget-object p1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    invoke-interface {p1}, Lorg/reactivestreams/Subscription;->cancel()V

    new-instance p1, Lio/reactivex/exceptions/MissingBackpressureException;

    const-string v0, "queue full?!"

    invoke-direct {p1, v0}, Lio/reactivex/exceptions/MissingBackpressureException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->onError(Ljava/lang/Throwable;)V

    return-void

    :cond_18
    invoke-virtual {p0}, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->drain()V

    return-void
.end method

.method public onSubscribe(Lorg/reactivestreams/Subscription;)V
    .registers 4

    iget-object v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    invoke-static {v0, p1}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->validate(Lorg/reactivestreams/Subscription;Lorg/reactivestreams/Subscription;)Z

    move-result v0

    if-eqz v0, :cond_15

    iput-object p1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    iget-object v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    invoke-interface {v0, p0}, Lorg/reactivestreams/Subscriber;->onSubscribe(Lorg/reactivestreams/Subscription;)V

    iget v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->prefetch:I

    int-to-long v0, v0

    invoke-interface {p1, v0, v1}, Lorg/reactivestreams/Subscription;->request(J)V

    :cond_15
    return-void
.end method

.method public request(J)V
    .registers 4

    iget-object v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-static {v0, p1, p2}, Lio/reactivex/internal/util/BackpressureHelper;->add(Ljava/util/concurrent/atomic/AtomicLong;J)J

    invoke-virtual {p0}, Lio/reactivex/internal/operators/mixed/FlowableConcatMapMaybe$ConcatMapMaybeSubscriber;->drain()V

    return-void
.end method
