.class final Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;
.super Ljava/util/concurrent/atomic/AtomicInteger;
.source "FlowableGroupJoin.java"

# interfaces
.implements Lorg/reactivestreams/Subscription;
.implements Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$JoinSupport;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/flowable/FlowableGroupJoin;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "GroupJoinSubscription"
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
            "Lio/reactivex/processors/UnicastProcessor<",
            "TTRight;>;>;"
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
            "-",
            "Lio/reactivex/Flowable<",
            "TTRight;>;+TR;>;"
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

    sput-object v0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->LEFT_VALUE:Ljava/lang/Integer;

    const/4 v0, 0x2

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    sput-object v0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->RIGHT_VALUE:Ljava/lang/Integer;

    const/4 v0, 0x3

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    sput-object v0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->LEFT_CLOSE:Ljava/lang/Integer;

    const/4 v0, 0x4

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    sput-object v0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->RIGHT_CLOSE:Ljava/lang/Integer;

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
            "-",
            "Lio/reactivex/Flowable<",
            "TTRight;>;+TR;>;)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->downstream:Lorg/reactivestreams/Subscriber;

    new-instance p1, Ljava/util/concurrent/atomic/AtomicLong;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicLong;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    new-instance p1, Lio/reactivex/disposables/CompositeDisposable;

    invoke-direct {p1}, Lio/reactivex/disposables/CompositeDisposable;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->disposables:Lio/reactivex/disposables/CompositeDisposable;

    new-instance p1, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    invoke-static {}, Lio/reactivex/Flowable;->bufferSize()I

    move-result v0

    invoke-direct {p1, v0}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;-><init>(I)V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    new-instance p1, Ljava/util/LinkedHashMap;

    invoke-direct {p1}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->lefts:Ljava/util/Map;

    new-instance p1, Ljava/util/LinkedHashMap;

    invoke-direct {p1}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->rights:Ljava/util/Map;

    new-instance p1, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->error:Ljava/util/concurrent/atomic/AtomicReference;

    iput-object p2, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->leftEnd:Lio/reactivex/functions/Function;

    iput-object p3, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->rightEnd:Lio/reactivex/functions/Function;

    iput-object p4, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->resultSelector:Lio/reactivex/functions/BiFunction;

    new-instance p1, Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 p2, 0x2

    invoke-direct {p1, p2}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    iput-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->active:Ljava/util/concurrent/atomic/AtomicInteger;

    return-void
.end method


# virtual methods
.method public cancel()V
    .registers 2

    iget-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->cancelled:Z

    if-eqz v0, :cond_5

    return-void

    :cond_5
    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->cancelled:Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->cancelAll()V

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->getAndIncrement()I

    move-result v0

    if-nez v0, :cond_16

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    invoke-virtual {v0}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->clear()V

    :cond_16
    return-void
.end method

.method cancelAll()V
    .registers 2

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->disposables:Lio/reactivex/disposables/CompositeDisposable;

    invoke-virtual {v0}, Lio/reactivex/disposables/CompositeDisposable;->dispose()V

    return-void
.end method

.method drain()V
    .registers 11

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->getAndIncrement()I

    move-result v0

    if-eqz v0, :cond_7

    return-void

    :cond_7
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->downstream:Lorg/reactivestreams/Subscriber;

    const/4 v2, 0x1

    move v3, v2

    :cond_d
    :goto_d
    iget-boolean v4, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->cancelled:Z

    if-eqz v4, :cond_15

    invoke-virtual {v0}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->clear()V

    return-void

    :cond_15
    iget-object v4, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->error:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v4}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Throwable;

    if-eqz v4, :cond_29

    invoke-virtual {v0}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->clear()V

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->cancelAll()V

    invoke-virtual {p0, v1}, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->errorAll(Lorg/reactivestreams/Subscriber;)V

    return-void

    :cond_29
    iget-object v4, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->active:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v4}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v4

    const/4 v5, 0x0

    if-nez v4, :cond_34

    move v4, v2

    goto :goto_35

    :cond_34
    move v4, v5

    :goto_35
    invoke-virtual {v0}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->poll()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Integer;

    if-nez v6, :cond_3f

    move v7, v2

    goto :goto_40

    :cond_3f
    move v7, v5

    :goto_40
    if-eqz v4, :cond_71

    if-eqz v7, :cond_71

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->lefts:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_4e
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_5e

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lio/reactivex/processors/UnicastProcessor;

    invoke-virtual {v2}, Lio/reactivex/processors/UnicastProcessor;->onComplete()V

    goto :goto_4e

    :cond_5e
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->lefts:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->rights:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->disposables:Lio/reactivex/disposables/CompositeDisposable;

    invoke-virtual {v0}, Lio/reactivex/disposables/CompositeDisposable;->dispose()V

    invoke-interface {v1}, Lorg/reactivestreams/Subscriber;->onComplete()V

    return-void

    :cond_71
    if-eqz v7, :cond_7b

    neg-int v3, v3

    invoke-virtual {p0, v3}, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->addAndGet(I)I

    move-result v3

    if-nez v3, :cond_d

    return-void

    :cond_7b
    invoke-virtual {v0}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->poll()Ljava/lang/Object;

    move-result-object v4

    sget-object v7, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->LEFT_VALUE:Ljava/lang/Integer;

    if-ne v6, v7, :cond_114

    invoke-static {}, Lio/reactivex/processors/UnicastProcessor;->create()Lio/reactivex/processors/UnicastProcessor;

    move-result-object v5

    iget v6, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->leftIndex:I

    add-int/lit8 v7, v6, 0x1

    iput v7, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->leftIndex:I

    iget-object v7, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->lefts:Ljava/util/Map;

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-interface {v7, v8, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :try_start_96
    iget-object v7, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->leftEnd:Lio/reactivex/functions/Function;

    invoke-interface {v7, v4}, Lio/reactivex/functions/Function;->apply(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    const-string v8, "The leftEnd returned a null Publisher"

    invoke-static {v7, v8}, Lio/reactivex/internal/functions/ObjectHelper;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lorg/reactivestreams/Publisher;
    :try_end_a4
    .catchall {:try_start_96 .. :try_end_a4} :catchall_10f

    new-instance v8, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$LeftRightEndSubscriber;

    invoke-direct {v8, p0, v2, v6}, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$LeftRightEndSubscriber;-><init>(Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$JoinSupport;ZI)V

    iget-object v6, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->disposables:Lio/reactivex/disposables/CompositeDisposable;

    invoke-virtual {v6, v8}, Lio/reactivex/disposables/CompositeDisposable;->add(Lio/reactivex/disposables/Disposable;)Z

    invoke-interface {v7, v8}, Lorg/reactivestreams/Publisher;->subscribe(Lorg/reactivestreams/Subscriber;)V

    iget-object v6, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->error:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v6}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Throwable;

    if-eqz v6, :cond_c5

    invoke-virtual {v0}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->clear()V

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->cancelAll()V

    invoke-virtual {p0, v1}, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->errorAll(Lorg/reactivestreams/Subscriber;)V

    return-void

    :cond_c5
    :try_start_c5
    iget-object v6, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->resultSelector:Lio/reactivex/functions/BiFunction;

    invoke-interface {v6, v4, v5}, Lio/reactivex/functions/BiFunction;->apply(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    const-string v6, "The resultSelector returned a null value"

    invoke-static {v4, v6}, Lio/reactivex/internal/functions/ObjectHelper;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4
    :try_end_d1
    .catchall {:try_start_c5 .. :try_end_d1} :catchall_10a

    iget-object v6, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v6}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v6

    const-wide/16 v8, 0x0

    cmp-long v6, v6, v8

    if-eqz v6, :cond_ff

    invoke-interface {v1, v4}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    iget-object v4, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    const-wide/16 v6, 0x1

    invoke-static {v4, v6, v7}, Lio/reactivex/internal/util/BackpressureHelper;->produced(Ljava/util/concurrent/atomic/AtomicLong;J)J

    iget-object v4, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->rights:Ljava/util/Map;

    invoke-interface {v4}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_f1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_d

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v5, v6}, Lio/reactivex/processors/UnicastProcessor;->onNext(Ljava/lang/Object;)V

    goto :goto_f1

    :cond_ff
    new-instance v2, Lio/reactivex/exceptions/MissingBackpressureException;

    const-string v3, "Could not emit value due to lack of requests"

    invoke-direct {v2, v3}, Lio/reactivex/exceptions/MissingBackpressureException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v2, v1, v0}, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->fail(Ljava/lang/Throwable;Lorg/reactivestreams/Subscriber;Lio/reactivex/internal/fuseable/SimpleQueue;)V

    return-void

    :catchall_10a
    move-exception v2

    invoke-virtual {p0, v2, v1, v0}, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->fail(Ljava/lang/Throwable;Lorg/reactivestreams/Subscriber;Lio/reactivex/internal/fuseable/SimpleQueue;)V

    return-void

    :catchall_10f
    move-exception v2

    invoke-virtual {p0, v2, v1, v0}, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->fail(Ljava/lang/Throwable;Lorg/reactivestreams/Subscriber;Lio/reactivex/internal/fuseable/SimpleQueue;)V

    return-void

    :cond_114
    sget-object v7, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->RIGHT_VALUE:Ljava/lang/Integer;

    if-ne v6, v7, :cond_175

    iget v6, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->rightIndex:I

    add-int/lit8 v7, v6, 0x1

    iput v7, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->rightIndex:I

    iget-object v7, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->rights:Ljava/util/Map;

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-interface {v7, v8, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :try_start_127
    iget-object v7, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->rightEnd:Lio/reactivex/functions/Function;

    invoke-interface {v7, v4}, Lio/reactivex/functions/Function;->apply(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    const-string v8, "The rightEnd returned a null Publisher"

    invoke-static {v7, v8}, Lio/reactivex/internal/functions/ObjectHelper;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lorg/reactivestreams/Publisher;
    :try_end_135
    .catchall {:try_start_127 .. :try_end_135} :catchall_170

    new-instance v8, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$LeftRightEndSubscriber;

    invoke-direct {v8, p0, v5, v6}, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$LeftRightEndSubscriber;-><init>(Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$JoinSupport;ZI)V

    iget-object v5, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->disposables:Lio/reactivex/disposables/CompositeDisposable;

    invoke-virtual {v5, v8}, Lio/reactivex/disposables/CompositeDisposable;->add(Lio/reactivex/disposables/Disposable;)Z

    invoke-interface {v7, v8}, Lorg/reactivestreams/Publisher;->subscribe(Lorg/reactivestreams/Subscriber;)V

    iget-object v5, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->error:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v5}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Throwable;

    if-eqz v5, :cond_156

    invoke-virtual {v0}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->clear()V

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->cancelAll()V

    invoke-virtual {p0, v1}, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->errorAll(Lorg/reactivestreams/Subscriber;)V

    return-void

    :cond_156
    iget-object v5, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->lefts:Ljava/util/Map;

    invoke-interface {v5}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_160
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_d

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lio/reactivex/processors/UnicastProcessor;

    invoke-virtual {v6, v4}, Lio/reactivex/processors/UnicastProcessor;->onNext(Ljava/lang/Object;)V

    goto :goto_160

    :catchall_170
    move-exception v2

    invoke-virtual {p0, v2, v1, v0}, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->fail(Ljava/lang/Throwable;Lorg/reactivestreams/Subscriber;Lio/reactivex/internal/fuseable/SimpleQueue;)V

    return-void

    :cond_175
    sget-object v5, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->LEFT_CLOSE:Ljava/lang/Integer;

    if-ne v6, v5, :cond_195

    check-cast v4, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$LeftRightEndSubscriber;

    iget-object v5, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->lefts:Ljava/util/Map;

    iget v6, v4, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$LeftRightEndSubscriber;->index:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-interface {v5, v6}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lio/reactivex/processors/UnicastProcessor;

    iget-object v6, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->disposables:Lio/reactivex/disposables/CompositeDisposable;

    invoke-virtual {v6, v4}, Lio/reactivex/disposables/CompositeDisposable;->remove(Lio/reactivex/disposables/Disposable;)Z

    if-eqz v5, :cond_d

    invoke-virtual {v5}, Lio/reactivex/processors/UnicastProcessor;->onComplete()V

    goto/16 :goto_d

    :cond_195
    sget-object v5, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->RIGHT_CLOSE:Ljava/lang/Integer;

    if-ne v6, v5, :cond_d

    check-cast v4, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$LeftRightEndSubscriber;

    iget-object v5, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->rights:Ljava/util/Map;

    iget v6, v4, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$LeftRightEndSubscriber;->index:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-interface {v5, v6}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v5, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->disposables:Lio/reactivex/disposables/CompositeDisposable;

    invoke-virtual {v5, v4}, Lio/reactivex/disposables/CompositeDisposable;->remove(Lio/reactivex/disposables/Disposable;)Z

    goto/16 :goto_d
.end method

.method errorAll(Lorg/reactivestreams/Subscriber;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Subscriber<",
            "*>;)V"
        }
    .end annotation

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->error:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0}, Lio/reactivex/internal/util/ExceptionHelper;->terminate(Ljava/util/concurrent/atomic/AtomicReference;)Ljava/lang/Throwable;

    move-result-object v0

    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->lefts:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_10
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_20

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lio/reactivex/processors/UnicastProcessor;

    invoke-virtual {v2, v0}, Lio/reactivex/processors/UnicastProcessor;->onError(Ljava/lang/Throwable;)V

    goto :goto_10

    :cond_20
    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->lefts:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->clear()V

    iget-object v1, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->rights:Ljava/util/Map;

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

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->error:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0, p1}, Lio/reactivex/internal/util/ExceptionHelper;->addThrowable(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Throwable;)Z

    invoke-interface {p3}, Lio/reactivex/internal/fuseable/SimpleQueue;->clear()V

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->cancelAll()V

    invoke-virtual {p0, p2}, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->errorAll(Lorg/reactivestreams/Subscriber;)V

    return-void
.end method

.method public innerClose(ZLio/reactivex/internal/operators/flowable/FlowableGroupJoin$LeftRightEndSubscriber;)V
    .registers 4

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    if-eqz p1, :cond_8

    sget-object p1, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->LEFT_CLOSE:Ljava/lang/Integer;

    goto :goto_a

    :cond_8
    sget-object p1, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->RIGHT_CLOSE:Ljava/lang/Integer;

    :goto_a
    invoke-virtual {v0, p1, p2}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->offer(Ljava/lang/Object;Ljava/lang/Object;)Z

    monitor-exit p0
    :try_end_e
    .catchall {:try_start_1 .. :try_end_e} :catchall_12

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->drain()V

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

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->error:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0, p1}, Lio/reactivex/internal/util/ExceptionHelper;->addThrowable(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Throwable;)Z

    move-result v0

    if-eqz v0, :cond_c

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->drain()V

    goto :goto_f

    :cond_c
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :goto_f
    return-void
.end method

.method public innerComplete(Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$LeftRightSubscriber;)V
    .registers 3

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->disposables:Lio/reactivex/disposables/CompositeDisposable;

    invoke-virtual {v0, p1}, Lio/reactivex/disposables/CompositeDisposable;->delete(Lio/reactivex/disposables/Disposable;)Z

    iget-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->active:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {p1}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->drain()V

    return-void
.end method

.method public innerError(Ljava/lang/Throwable;)V
    .registers 3

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->error:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0, p1}, Lio/reactivex/internal/util/ExceptionHelper;->addThrowable(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Throwable;)Z

    move-result v0

    if-eqz v0, :cond_11

    iget-object p1, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->active:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {p1}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->drain()V

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
    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->queue:Lio/reactivex/internal/queue/SpscLinkedArrayQueue;

    if-eqz p1, :cond_8

    sget-object p1, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->LEFT_VALUE:Ljava/lang/Integer;

    goto :goto_a

    :cond_8
    sget-object p1, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->RIGHT_VALUE:Ljava/lang/Integer;

    :goto_a
    invoke-virtual {v0, p1, p2}, Lio/reactivex/internal/queue/SpscLinkedArrayQueue;->offer(Ljava/lang/Object;Ljava/lang/Object;)Z

    monitor-exit p0
    :try_end_e
    .catchall {:try_start_1 .. :try_end_e} :catchall_12

    invoke-virtual {p0}, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->drain()V

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

    iget-object v0, p0, Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-static {v0, p1, p2}, Lio/reactivex/internal/util/BackpressureHelper;->add(Ljava/util/concurrent/atomic/AtomicLong;J)J

    :cond_b
    return-void
.end method
