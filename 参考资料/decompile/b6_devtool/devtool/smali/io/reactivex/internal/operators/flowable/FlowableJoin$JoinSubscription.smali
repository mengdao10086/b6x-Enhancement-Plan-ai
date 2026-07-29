.class final Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;
.super Ljava/util/concurrent/atomic/AtomicInteger;
.source "FlowableJoin.java"

# interfaces
.implements Lorg/reactivestreams/Subscription;
.implements Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$JoinSupport;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/flowable/FlowableJoin;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "JoinSubscription"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T",
        "Left:Ljava/lang/Object;",
        "TRight:",
        "Ljava/lang/Object;",
        "T",
        "LeftEnd:Ljava/lang/Object;",
        "TRightEnd:",
        "Ljava/lang/Object;",
        "R:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/util/concurrent/atomic/AtomicInteger;",
        "Lorg/reactivestreams/Subscription;",
        "Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$JoinSupport;"
    }
.end annotation


# static fields
.field static final LEFT_CLOSE:Ljava/lang/Integer;

.field static final LEFT_VALUE:Ljava/lang/Integer;

.field static final RIGHT_CLOSE:Ljava/lang/Integer;

.field static final RIGHT_VALUE:Ljava/lang/Integer;

.field private static final serialVersionUID:J = -0x54414b546f40e739L


# instance fields
.field final active:Ljava/util/concurrent/atomic/AtomicInteger;

.field volatile cancelled:Z

.field final disposables:Lio/reactivex/disposables/CompositeDisposable;

.field final downstream:Lorg/reactivestreams/Subscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/reactivestreams/Subscriber<",
            "-TR;>;"
        }
    .end annotation
.end field

.field final error:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference<",
            "Ljava/lang/Throwable;",
            ">;"
        }
    .end annotation
.end field

.field final leftEnd:Lio/reactivex/functions/Function;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/functions/Function<",
            "-TT",
            "Left;",
            "+",
            "Lorg/reactivestreams/Publisher<",
            "TT",
            "LeftEnd;",
            ">;>;"
        }
    .end annotation
.end field

.field leftIndex:I

.field final lefts:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/Integer;",
            "TT",
            "Left;",
            ">;"
        }
    .end annotation
.end field

.field final queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/internal/queue/SpscLinkedArrayQueue<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field final requested:Ljava/util/concurrent/atomic/AtomicLong;

.field final resultSelector:Lio/reactivex/functions/BiFunction;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/functions/BiFunction<",
            "-TT",
            "Left;",
            "-TTRight;+TR;>;"
        }
    .end annotation
.end field

.field final rightEnd:Lio/reactivex/functions/Function;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/functions/Function<",
            "-TTRight;+",
            "Lorg/reactivestreams/Publisher<",
            "TTRightEnd;>;>;"
        }
    .end annotation
.end field

.field rightIndex:I

.field final rights:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/Integer;",
            "TTRight;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    sput-object v0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->LEFT_VALUE:Ljava/lang/Integer;

    const/4 v0, 0x2

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    sput-object v0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->RIGHT_VALUE:Ljava/lang/Integer;

    const/4 v0, 0x3

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    sput-object v0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->LEFT_CLOSE:Ljava/lang/Integer;

    const/4 v0, 0x4

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    sput-object v0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->RIGHT_CLOSE:Ljava/lang/Integer;

    return-void
.end method

.method constructor <init>(Lorg/reactivestreams/Subscriber;Lio/reactivex/functions/Function;Lio/reactivex/functions/Function;Lio/reactivex/functions/BiFunction;)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Subscriber<",
            "-TR;>;",
            "Lio/reactivex/functions/Function<",
            "-TT",
            "Left;",
            "+",
            "Lorg/reactivestreams/Publisher<",
            "TT",
            "LeftEnd;",
            ">;>;",
            "Lio/reactivex/functions/Function<",
            "-TTRight;+",
            "Lorg/reactivestreams/Publisher<",
            "TTRightEnd;>;>;",
            "Lio/reactivex/functions/BiFunction<",
            "-TT",
            "Left;",
            "-TTRight;+TR;>;)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->downstream:Lorg/reactivestreams/Subscriber;

    new-instance p1, Ljava/util/concurrent/atomic/AtomicLong;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicLong;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    new-instance p1, Lio/reactivex/disposables/CompositeDisposable;

    invoke-direct {p1}, Lio/reactivex/disposables/CompositeDisposable;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->disposables:Lio/reactivex/disposables/CompositeDisposable;

    new-instance p1, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    invoke-static {}, Lio/reactivex/Flowable;->bufferSize()I

    move-result v0

    invoke-direct {p1, v0}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;-><init>(I)V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    new-instance p1, Ljava/util/LinkedHashMap;

    invoke-direct {p1}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->lefts:Ljava/util/Map;

    new-instance p1, Ljava/util/LinkedHashMap;

    invoke-direct {p1}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->rights:Ljava/util/Map;

    new-instance p1, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->error:Ljava/util/concurrent/atomic/AtomicReference;

    iput-object p2, p0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->leftEnd:Lio/reactivex/functions/Function;

    iput-object p3, p0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->rightEnd:Lio/reactivex/functions/Function;

    iput-object p4, p0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->resultSelector:Lio/reactivex/functions/BiFunction;

    new-instance p1, Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 p2, 0x2

    invoke-direct {p1, p2}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->active:Ljava/util/concurrent/atomic/AtomicInteger;

    return-void
.end method


# virtual methods
.method public cancel()V
    .registers 2

    iget-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->cancelled:Z

    if-eqz v0, :cond_5

    return-void

    :cond_5
    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->cancelled:Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->cancelAll()V

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->getAndIncrement()I

    move-result v0

    if-nez v0, :cond_16

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    invoke-virtual {v0}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->clear()V

    :cond_16
    return-void
.end method

.method cancelAll()V
    .registers 2

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->disposables:Lio/reactivex/disposables/CompositeDisposable;

    invoke-virtual {v0}, Lio/reactivex/disposables/CompositeDisposable;->dispose()V

    return-void
.end method

.method drain()V
    .registers 18

    move-object/from16 v1, p0

    invoke-virtual/range {p0 .. p0}, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->getAndIncrement()I

    move-result v0

    if-eqz v0, :cond_9

    return-void

    :cond_9
    iget-object v2, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    iget-object v3, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->downstream:Lorg/reactivestreams/Subscriber;

    const/4 v0, 0x1

    move v4, v0

    :cond_f
    :goto_f
    iget-boolean v5, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->cancelled:Z

    if-eqz v5, :cond_17

    invoke-virtual {v2}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->clear()V

    return-void

    :cond_17
    iget-object v5, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->error:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v5}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Throwable;

    if-eqz v5, :cond_2b

    invoke-virtual {v2}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->clear()V

    invoke-virtual/range {p0 .. p0}, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->cancelAll()V

    invoke-virtual {v1, v3}, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->errorAll(Lorg/reactivestreams/Subscriber;)V

    return-void

    :cond_2b
    iget-object v5, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->active:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v5}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v5

    const/4 v6, 0x0

    if-nez v5, :cond_36

    move v5, v0

    goto :goto_37

    :cond_36
    move v5, v6

    :goto_37
    invoke-virtual {v2}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->poll()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/Integer;

    if-nez v7, :cond_41

    move v8, v0

    goto :goto_42

    :cond_41
    move v8, v6

    :goto_42
    if-eqz v5, :cond_59

    if-eqz v8, :cond_59

    iget-object v0, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->lefts:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    iget-object v0, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->rights:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    iget-object v0, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->disposables:Lio/reactivex/disposables/CompositeDisposable;

    invoke-virtual {v0}, Lio/reactivex/disposables/CompositeDisposable;->dispose()V

    invoke-interface {v3}, Lorg/reactivestreams/Subscriber;->onComplete()V

    return-void

    :cond_59
    if-eqz v8, :cond_63

    neg-int v4, v4

    invoke-virtual {v1, v4}, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->addAndGet(I)I

    move-result v4

    if-nez v4, :cond_f

    return-void

    :cond_63
    invoke-virtual {v2}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->poll()Ljava/lang/Object;

    move-result-object v5

    sget-object v8, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->LEFT_VALUE:Ljava/lang/Integer;

    const-wide/16 v9, 0x1

    const-string v11, "Could not emit value due to lack of requests"

    const-string v12, "The resultSelector returned a null value"

    if-ne v7, v8, :cond_10a

    iget v6, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->leftIndex:I

    add-int/lit8 v7, v6, 0x1

    iput v7, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->leftIndex:I

    iget-object v7, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->lefts:Ljava/util/Map;

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-interface {v7, v8, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :try_start_80
    iget-object v7, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->leftEnd:Lio/reactivex/functions/Function;

    invoke-interface {v7, v5}, Lio/reactivex/functions/Function;->apply(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    const-string v8, "The leftEnd returned a null Publisher"

    invoke-static {v7, v8}, Lio/reactivex/internal/functions/ObjectHelper;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lorg/reactivestreams/Publisher;
    :try_end_8e
    .catchall {:try_start_80 .. :try_end_8e} :catchall_105

    new-instance v8, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$LeftRightEndSubscriber;

    invoke-direct {v8, v1, v0, v6}, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$LeftRightEndSubscriber;-><init>(Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$JoinSupport;ZI)V

    iget-object v6, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->disposables:Lio/reactivex/disposables/CompositeDisposable;

    invoke-virtual {v6, v8}, Lio/reactivex/disposables/CompositeDisposable;->add(Lio/reactivex/disposables/Disposable;)Z

    invoke-interface {v7, v8}, Lorg/reactivestreams/Publisher;->subscribe(Lorg/reactivestreams/Subscriber;)V

    iget-object v6, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->error:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v6}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Throwable;

    if-eqz v6, :cond_af

    invoke-virtual {v2}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->clear()V

    invoke-virtual/range {p0 .. p0}, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->cancelAll()V

    invoke-virtual {v1, v3}, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->errorAll(Lorg/reactivestreams/Subscriber;)V

    return-void

    :cond_af
    iget-object v6, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v6}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v6

    iget-object v8, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->rights:Ljava/util/Map;

    invoke-interface {v8}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v8

    invoke-interface {v8}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v8

    const-wide/16 v13, 0x0

    :goto_c1
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v16

    if-eqz v16, :cond_f8

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    :try_start_cb
    iget-object v15, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->resultSelector:Lio/reactivex/functions/BiFunction;

    invoke-interface {v15, v5, v0}, Lio/reactivex/functions/BiFunction;->apply(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0, v12}, Lio/reactivex/internal/functions/ObjectHelper;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0
    :try_end_d5
    .catchall {:try_start_cb .. :try_end_d5} :catchall_f3

    cmp-long v15, v13, v6

    if-eqz v15, :cond_df

    invoke-interface {v3, v0}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    add-long/2addr v13, v9

    const/4 v0, 0x1

    goto :goto_c1

    :cond_df
    iget-object v0, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->error:Ljava/util/concurrent/atomic/AtomicReference;

    new-instance v4, Lio/reactivex/exceptions/MissingBackpressureException;

    invoke-direct {v4, v11}, Lio/reactivex/exceptions/MissingBackpressureException;-><init>(Ljava/lang/String;)V

    invoke-static {v0, v4}, Lio/reactivex/internal/util/ExceptionHelper;->addThrowable(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Throwable;)Z

    invoke-virtual {v2}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->clear()V

    invoke-virtual/range {p0 .. p0}, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->cancelAll()V

    invoke-virtual {v1, v3}, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->errorAll(Lorg/reactivestreams/Subscriber;)V

    return-void

    :catchall_f3
    move-exception v0

    invoke-virtual {v1, v0, v3, v2}, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->fail(Ljava/lang/Throwable;Lorg/reactivestreams/Subscriber;Lio/reactivex/internal/fuseable/SimpleQueue;)V

    return-void

    :cond_f8
    const-wide/16 v5, 0x0

    cmp-long v0, v13, v5

    if-eqz v0, :cond_1d2

    iget-object v0, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-static {v0, v13, v14}, Lio/reactivex/internal/util/BackpressureHelper;->produced(Ljava/util/concurrent/atomic/AtomicLong;J)J

    goto/16 :goto_1d2

    :catchall_105
    move-exception v0

    invoke-virtual {v1, v0, v3, v2}, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->fail(Ljava/lang/Throwable;Lorg/reactivestreams/Subscriber;Lio/reactivex/internal/fuseable/SimpleQueue;)V

    return-void

    :cond_10a
    sget-object v0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->RIGHT_VALUE:Ljava/lang/Integer;

    if-ne v7, v0, :cond_1a5

    iget v0, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->rightIndex:I

    add-int/lit8 v7, v0, 0x1

    iput v7, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->rightIndex:I

    iget-object v7, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->rights:Ljava/util/Map;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-interface {v7, v8, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :try_start_11d
    iget-object v7, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->rightEnd:Lio/reactivex/functions/Function;

    invoke-interface {v7, v5}, Lio/reactivex/functions/Function;->apply(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    const-string v8, "The rightEnd returned a null Publisher"

    invoke-static {v7, v8}, Lio/reactivex/internal/functions/ObjectHelper;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lorg/reactivestreams/Publisher;
    :try_end_12b
    .catchall {:try_start_11d .. :try_end_12b} :catchall_1a0

    new-instance v8, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$LeftRightEndSubscriber;

    invoke-direct {v8, v1, v6, v0}, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$LeftRightEndSubscriber;-><init>(Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$JoinSupport;ZI)V

    iget-object v0, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->disposables:Lio/reactivex/disposables/CompositeDisposable;

    invoke-virtual {v0, v8}, Lio/reactivex/disposables/CompositeDisposable;->add(Lio/reactivex/disposables/Disposable;)Z

    invoke-interface {v7, v8}, Lorg/reactivestreams/Publisher;->subscribe(Lorg/reactivestreams/Subscriber;)V

    iget-object v0, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->error:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Throwable;

    if-eqz v0, :cond_14c

    invoke-virtual {v2}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->clear()V

    invoke-virtual/range {p0 .. p0}, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->cancelAll()V

    invoke-virtual {v1, v3}, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->errorAll(Lorg/reactivestreams/Subscriber;)V

    return-void

    :cond_14c
    iget-object v0, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v6

    iget-object v0, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->lefts:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    const-wide/16 v13, 0x0

    :goto_15e
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_194

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    :try_start_168
    iget-object v15, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->resultSelector:Lio/reactivex/functions/BiFunction;

    invoke-interface {v15, v8, v5}, Lio/reactivex/functions/BiFunction;->apply(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    invoke-static {v8, v12}, Lio/reactivex/internal/functions/ObjectHelper;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v8
    :try_end_172
    .catchall {:try_start_168 .. :try_end_172} :catchall_18f

    cmp-long v15, v13, v6

    if-eqz v15, :cond_17b

    invoke-interface {v3, v8}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    add-long/2addr v13, v9

    goto :goto_15e

    :cond_17b
    iget-object v0, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->error:Ljava/util/concurrent/atomic/AtomicReference;

    new-instance v4, Lio/reactivex/exceptions/MissingBackpressureException;

    invoke-direct {v4, v11}, Lio/reactivex/exceptions/MissingBackpressureException;-><init>(Ljava/lang/String;)V

    invoke-static {v0, v4}, Lio/reactivex/internal/util/ExceptionHelper;->addThrowable(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Throwable;)Z

    invoke-virtual {v2}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->clear()V

    invoke-virtual/range {p0 .. p0}, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->cancelAll()V

    invoke-virtual {v1, v3}, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->errorAll(Lorg/reactivestreams/Subscriber;)V

    return-void

    :catchall_18f
    move-exception v0

    invoke-virtual {v1, v0, v3, v2}, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->fail(Ljava/lang/Throwable;Lorg/reactivestreams/Subscriber;Lio/reactivex/internal/fuseable/SimpleQueue;)V

    return-void

    :cond_194
    const-wide/16 v5, 0x0

    cmp-long v0, v13, v5

    if-eqz v0, :cond_1d2

    iget-object v0, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-static {v0, v13, v14}, Lio/reactivex/internal/util/BackpressureHelper;->produced(Ljava/util/concurrent/atomic/AtomicLong;J)J

    goto :goto_1d2

    :catchall_1a0
    move-exception v0

    invoke-virtual {v1, v0, v3, v2}, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->fail(Ljava/lang/Throwable;Lorg/reactivestreams/Subscriber;Lio/reactivex/internal/fuseable/SimpleQueue;)V

    return-void

    :cond_1a5
    sget-object v0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->LEFT_CLOSE:Ljava/lang/Integer;

    if-ne v7, v0, :cond_1bc

    check-cast v5, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$LeftRightEndSubscriber;

    iget-object v0, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->lefts:Ljava/util/Map;

    iget v6, v5, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$LeftRightEndSubscriber;->index:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-interface {v0, v6}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->disposables:Lio/reactivex/disposables/CompositeDisposable;

    invoke-virtual {v0, v5}, Lio/reactivex/disposables/CompositeDisposable;->remove(Lio/reactivex/disposables/Disposable;)Z

    goto :goto_1d2

    :cond_1bc
    sget-object v0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->RIGHT_CLOSE:Ljava/lang/Integer;

    if-ne v7, v0, :cond_1d2

    check-cast v5, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$LeftRightEndSubscriber;

    iget-object v0, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->rights:Ljava/util/Map;

    iget v6, v5, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$LeftRightEndSubscriber;->index:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-interface {v0, v6}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, v1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->disposables:Lio/reactivex/disposables/CompositeDisposable;

    invoke-virtual {v0, v5}, Lio/reactivex/disposables/CompositeDisposable;->remove(Lio/reactivex/disposables/Disposable;)Z

    :cond_1d2
    :goto_1d2
    const/4 v0, 0x1

    goto/16 :goto_f
.end method

.method errorAll(Lorg/reactivestreams/Subscriber;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Subscriber<",
            "*>;)V"
        }
    .end annotation

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->error:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0}, Lio/reactivex/internal/util/ExceptionHelper;->terminate(Ljava/util/concurrent/atomic/AtomicReference;)Ljava/lang/Throwable;

    move-result-object v0

    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->lefts:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->clear()V

    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->rights:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->clear()V

    invoke-interface {p1, v0}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method fail(Ljava/lang/Throwable;Lorg/reactivestreams/Subscriber;Lio/reactivex/internal/fuseable/SimpleQueue;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Throwable;",
            "Lorg/reactivestreams/Subscriber<",
            "*>;",
            "Lio/reactivex/internal/fuseable/SimpleQueue<",
            "*>;)V"
        }
    .end annotation

    invoke-static {p1}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->error:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0, p1}, Lio/reactivex/internal/util/ExceptionHelper;->addThrowable(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Throwable;)Z

    invoke-interface {p3}, Lio/reactivex/internal/fuseable/SimpleQueue;->clear()V

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->cancelAll()V

    invoke-virtual {p0, p2}, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->errorAll(Lorg/reactivestreams/Subscriber;)V

    return-void
.end method

.method public innerClose(ZLio/reactivex/internal/operators/flowable/FlowableGroupJoin$LeftRightEndSubscriber;)V
    .registers 4

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    if-eqz p1, :cond_8

    sget-object p1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->LEFT_CLOSE:Ljava/lang/Integer;

    goto :goto_a

    :cond_8
    sget-object p1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->RIGHT_CLOSE:Ljava/lang/Integer;

    :goto_a
    invoke-virtual {v0, p1, p2}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->offer(Ljava/lang/Object;Ljava/lang/Object;)Z

    monitor-exit p0
    :try_end_e
    .catchall {:try_start_1 .. :try_end_e} :catchall_12

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->drain()V

    return-void

    :catchall_12
    move-exception p1

    :try_start_13
    monitor-exit p0
    :try_end_14
    .catchall {:try_start_13 .. :try_end_14} :catchall_12

    throw p1
.end method

.method public innerCloseError(Ljava/lang/Throwable;)V
    .registers 3

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->error:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0, p1}, Lio/reactivex/internal/util/ExceptionHelper;->addThrowable(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Throwable;)Z

    move-result v0

    if-eqz v0, :cond_c

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->drain()V

    goto :goto_f

    :cond_c
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :goto_f
    return-void
.end method

.method public innerComplete(Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$LeftRightSubscriber;)V
    .registers 3

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->disposables:Lio/reactivex/disposables/CompositeDisposable;

    invoke-virtual {v0, p1}, Lio/reactivex/disposables/CompositeDisposable;->delete(Lio/reactivex/disposables/Disposable;)Z

    iget-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->active:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {p1}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->drain()V

    return-void
.end method

.method public innerError(Ljava/lang/Throwable;)V
    .registers 3

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->error:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0, p1}, Lio/reactivex/internal/util/ExceptionHelper;->addThrowable(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Throwable;)Z

    move-result v0

    if-eqz v0, :cond_11

    iget-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->active:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {p1}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->drain()V

    goto :goto_14

    :cond_11
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :goto_14
    return-void
.end method

.method public innerValue(ZLjava/lang/Object;)V
    .registers 4

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    if-eqz p1, :cond_8

    sget-object p1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->LEFT_VALUE:Ljava/lang/Integer;

    goto :goto_a

    :cond_8
    sget-object p1, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->RIGHT_VALUE:Ljava/lang/Integer;

    :goto_a
    invoke-virtual {v0, p1, p2}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->offer(Ljava/lang/Object;Ljava/lang/Object;)Z

    monitor-exit p0
    :try_end_e
    .catchall {:try_start_1 .. :try_end_e} :catchall_12

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->drain()V

    return-void

    :catchall_12
    move-exception p1

    :try_start_13
    monitor-exit p0
    :try_end_14
    .catchall {:try_start_13 .. :try_end_14} :catchall_12

    throw p1
.end method

.method public request(J)V
    .registers 4

    invoke-static {p1, p2}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->validate(J)Z

    move-result v0

    if-eqz v0, :cond_b

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-static {v0, p1, p2}, Lio/reactivex/internal/util/BackpressureHelper;->add(Ljava/util/concurrent/atomic/AtomicLong;J)J

    :cond_b
    return-void
.end method
