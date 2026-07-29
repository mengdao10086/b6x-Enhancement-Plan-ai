.class final Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;
.super Ljava/util/concurrent/atomic/AtomicInteger;
.source "FlowableConcatMapCompletable.java"

# interfaces
.implements Lio/reactivex/FlowableSubscriber;
.implements Lio/reactivex/disposables/Disposable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "ConcatMapCompletableObserver"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver$ConcatMapInnerObserver;
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
        "Lio/reactivex/disposables/Disposable;"
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = 0x321c7f6dd838d46aL


# instance fields
.field volatile active:Z

.field consumed:I

.field volatile disposed:Z

.field volatile done:Z

.field final downstream:Lio/reactivex/CompletableObserver;

.field final errorMode:Lio/reactivex/internal/util/ErrorMode;

.field final errors:Lio/reactivex/internal/util/AtomicThrowable;

.field final inner:Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver$ConcatMapInnerObserver;

.field final mapper:Lio/reactivex/functions/Function;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/functions/Function<",
            "-TT;+",
            "Lio/reactivex/CompletableSource;",
            ">;"
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

.field upstream:Lorg/reactivestreams/Subscription;


# direct methods
.method constructor <init>(Lio/reactivex/CompletableObserver;Lio/reactivex/functions/Function;Lio/reactivex/internal/util/ErrorMode;I)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/CompletableObserver;",
            "Lio/reactivex/functions/Function<",
            "-TT;+",
            "Lio/reactivex/CompletableSource;",
            ">;",
            "Lio/reactivex/internal/util/ErrorMode;",
            "I)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->downstream:Lio/reactivex/CompletableObserver;

    iput-object p2, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->mapper:Lio/reactivex/functions/Function;

    iput-object p3, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->errorMode:Lio/reactivex/internal/util/ErrorMode;

    iput p4, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->prefetch:I

    new-instance p1, Lio/reactivex/internal/util/AtomicThrowable;

    invoke-direct {p1}, Lio/reactivex/internal/util/AtomicThrowable;-><init>()V

    iput-object p1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    new-instance p1, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver$ConcatMapInnerObserver;

    invoke-direct {p1, p0}, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver$ConcatMapInnerObserver;-><init>(Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;)V

    iput-object p1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->inner:Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver$ConcatMapInnerObserver;

    new-instance p1, Lio/reactivex/internal/queue/SpscArrayQueue;

    invoke-direct {p1, p4}, Lio/reactivex/internal/queue/SpscArrayQueue;-><init>(I)V

    iput-object p1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    return-void
.end method


# virtual methods
.method public dispose()V
    .registers 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->disposed:Z

    iget-object v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->upstream:Lorg/reactivestreams/Subscription;

    invoke-interface {v0}, Lorg/reactivestreams/Subscription;->cancel()V

    iget-object v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->inner:Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver$ConcatMapInnerObserver;

    invoke-virtual {v0}, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver$ConcatMapInnerObserver;->dispose()V

    invoke-virtual {p0}, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->getAndIncrement()I

    move-result v0

    if-nez v0, :cond_18

    iget-object v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    invoke-interface {v0}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->clear()V

    :cond_18
    return-void
.end method

.method drain()V
    .registers 7

    invoke-virtual {p0}, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->getAndIncrement()I

    move-result v0

    if-eqz v0, :cond_7

    return-void

    :cond_7
    iget-boolean v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->disposed:Z

    if-eqz v0, :cond_11

    iget-object v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    invoke-interface {v0}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->clear()V

    return-void

    :cond_11
    iget-boolean v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->active:Z

    if-nez v0, :cond_a7

    iget-object v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->errorMode:Lio/reactivex/internal/util/ErrorMode;

    sget-object v1, Lio/reactivex/internal/util/ErrorMode;->BOUNDARY:Lio/reactivex/internal/util/ErrorMode;

    if-ne v0, v1, :cond_34

    iget-object v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v0}, Lio/reactivex/internal/util/AtomicThrowable;->get()Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_34

    iget-object v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    invoke-interface {v0}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->clear()V

    iget-object v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v0}, Lio/reactivex/internal/util/AtomicThrowable;->terminate()Ljava/lang/Throwable;

    move-result-object v0

    iget-object v1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->downstream:Lio/reactivex/CompletableObserver;

    invoke-interface {v1, v0}, Lio/reactivex/CompletableObserver;->onError(Ljava/lang/Throwable;)V

    return-void

    :cond_34
    iget-boolean v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->done:Z

    iget-object v1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    invoke-interface {v1}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->poll()Ljava/lang/Object;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x1

    if-nez v1, :cond_42

    move v4, v3

    goto :goto_43

    :cond_42
    move v4, v2

    :goto_43
    if-eqz v0, :cond_5b

    if-eqz v4, :cond_5b

    iget-object v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v0}, Lio/reactivex/internal/util/AtomicThrowable;->terminate()Ljava/lang/Throwable;

    move-result-object v0

    if-eqz v0, :cond_55

    iget-object v1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->downstream:Lio/reactivex/CompletableObserver;

    invoke-interface {v1, v0}, Lio/reactivex/CompletableObserver;->onError(Ljava/lang/Throwable;)V

    goto :goto_5a

    :cond_55
    iget-object v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->downstream:Lio/reactivex/CompletableObserver;

    invoke-interface {v0}, Lio/reactivex/CompletableObserver;->onComplete()V

    :goto_5a
    return-void

    :cond_5b
    if-nez v4, :cond_a7

    iget v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->prefetch:I

    shr-int/lit8 v4, v0, 0x1

    sub-int/2addr v0, v4

    iget v4, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->consumed:I

    add-int/2addr v4, v3

    if-ne v4, v0, :cond_70

    iput v2, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->consumed:I

    iget-object v2, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->upstream:Lorg/reactivestreams/Subscription;

    int-to-long v4, v0

    invoke-interface {v2, v4, v5}, Lorg/reactivestreams/Subscription;->request(J)V

    goto :goto_72

    :cond_70
    iput v4, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->consumed:I

    :goto_72
    :try_start_72
    iget-object v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->mapper:Lio/reactivex/functions/Function;

    invoke-interface {v0, v1}, Lio/reactivex/functions/Function;->apply(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    const-string v1, "The mapper returned a null CompletableSource"

    invoke-static {v0, v1}, Lio/reactivex/internal/functions/ObjectHelper;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lio/reactivex/CompletableSource;
    :try_end_80
    .catchall {:try_start_72 .. :try_end_80} :catchall_88

    iput-boolean v3, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->active:Z

    iget-object v1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->inner:Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver$ConcatMapInnerObserver;

    invoke-interface {v0, v1}, Lio/reactivex/CompletableSource;->subscribe(Lio/reactivex/CompletableObserver;)V

    goto :goto_a7

    :catchall_88
    move-exception v0

    invoke-static {v0}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    iget-object v1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    invoke-interface {v1}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->clear()V

    iget-object v1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->upstream:Lorg/reactivestreams/Subscription;

    invoke-interface {v1}, Lorg/reactivestreams/Subscription;->cancel()V

    iget-object v1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v1, v0}, Lio/reactivex/internal/util/AtomicThrowable;->addThrowable(Ljava/lang/Throwable;)Z

    iget-object v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v0}, Lio/reactivex/internal/util/AtomicThrowable;->terminate()Ljava/lang/Throwable;

    move-result-object v0

    iget-object v1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->downstream:Lio/reactivex/CompletableObserver;

    invoke-interface {v1, v0}, Lio/reactivex/CompletableObserver;->onError(Ljava/lang/Throwable;)V

    return-void

    :cond_a7
    :goto_a7
    invoke-virtual {p0}, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->decrementAndGet()I

    move-result v0

    if-nez v0, :cond_7

    return-void
.end method

.method innerComplete()V
    .registers 2

    const/4 v0, 0x0

    iput-boolean v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->active:Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->drain()V

    return-void
.end method

.method innerError(Ljava/lang/Throwable;)V
    .registers 3

    iget-object v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v0, p1}, Lio/reactivex/internal/util/AtomicThrowable;->addThrowable(Ljava/lang/Throwable;)Z

    move-result v0

    if-eqz v0, :cond_35

    iget-object p1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->errorMode:Lio/reactivex/internal/util/ErrorMode;

    sget-object v0, Lio/reactivex/internal/util/ErrorMode;->IMMEDIATE:Lio/reactivex/internal/util/ErrorMode;

    if-ne p1, v0, :cond_2e

    iget-object p1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->upstream:Lorg/reactivestreams/Subscription;

    invoke-interface {p1}, Lorg/reactivestreams/Subscription;->cancel()V

    iget-object p1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {p1}, Lio/reactivex/internal/util/AtomicThrowable;->terminate()Ljava/lang/Throwable;

    move-result-object p1

    sget-object v0, Lio/reactivex/internal/util/ExceptionHelper;->TERMINATED:Ljava/lang/Throwable;

    if-eq p1, v0, :cond_22

    iget-object v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->downstream:Lio/reactivex/CompletableObserver;

    invoke-interface {v0, p1}, Lio/reactivex/CompletableObserver;->onError(Ljava/lang/Throwable;)V

    :cond_22
    invoke-virtual {p0}, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->getAndIncrement()I

    move-result p1

    if-nez p1, :cond_38

    iget-object p1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    invoke-interface {p1}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->clear()V

    goto :goto_38

    :cond_2e
    const/4 p1, 0x0

    iput-boolean p1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->active:Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->drain()V

    goto :goto_38

    :cond_35
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :cond_38
    :goto_38
    return-void
.end method

.method public isDisposed()Z
    .registers 2

    iget-boolean v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->disposed:Z

    return v0
.end method

.method public onComplete()V
    .registers 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->done:Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->drain()V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 3

    iget-object v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {v0, p1}, Lio/reactivex/internal/util/AtomicThrowable;->addThrowable(Ljava/lang/Throwable;)Z

    move-result v0

    if-eqz v0, :cond_35

    iget-object p1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->errorMode:Lio/reactivex/internal/util/ErrorMode;

    sget-object v0, Lio/reactivex/internal/util/ErrorMode;->IMMEDIATE:Lio/reactivex/internal/util/ErrorMode;

    if-ne p1, v0, :cond_2e

    iget-object p1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->inner:Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver$ConcatMapInnerObserver;

    invoke-virtual {p1}, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver$ConcatMapInnerObserver;->dispose()V

    iget-object p1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->errors:Lio/reactivex/internal/util/AtomicThrowable;

    invoke-virtual {p1}, Lio/reactivex/internal/util/AtomicThrowable;->terminate()Ljava/lang/Throwable;

    move-result-object p1

    sget-object v0, Lio/reactivex/internal/util/ExceptionHelper;->TERMINATED:Ljava/lang/Throwable;

    if-eq p1, v0, :cond_22

    iget-object v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->downstream:Lio/reactivex/CompletableObserver;

    invoke-interface {v0, p1}, Lio/reactivex/CompletableObserver;->onError(Ljava/lang/Throwable;)V

    :cond_22
    invoke-virtual {p0}, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->getAndIncrement()I

    move-result p1

    if-nez p1, :cond_38

    iget-object p1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    invoke-interface {p1}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->clear()V

    goto :goto_38

    :cond_2e
    const/4 p1, 0x1

    iput-boolean p1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->done:Z

    invoke-virtual {p0}, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->drain()V

    goto :goto_38

    :cond_35
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :cond_38
    :goto_38
    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    iget-object v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->queue:Lio/reactivex/internal/fuseable/SimplePlainQueue;

    invoke-interface {v0, p1}, Lio/reactivex/internal/fuseable/SimplePlainQueue;->offer(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_c

    invoke-virtual {p0}, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->drain()V

    goto :goto_1b

    :cond_c
    iget-object p1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->upstream:Lorg/reactivestreams/Subscription;

    invoke-interface {p1}, Lorg/reactivestreams/Subscription;->cancel()V

    new-instance p1, Lio/reactivex/exceptions/MissingBackpressureException;

    const-string v0, "Queue full?!"

    invoke-direct {p1, v0}, Lio/reactivex/exceptions/MissingBackpressureException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, p1}, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->onError(Ljava/lang/Throwable;)V

    :goto_1b
    return-void
.end method

.method public onSubscribe(Lorg/reactivestreams/Subscription;)V
    .registers 4

    iget-object v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->upstream:Lorg/reactivestreams/Subscription;

    invoke-static {v0, p1}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->validate(Lorg/reactivestreams/Subscription;Lorg/reactivestreams/Subscription;)Z

    move-result v0

    if-eqz v0, :cond_15

    iput-object p1, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->upstream:Lorg/reactivestreams/Subscription;

    iget-object v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->downstream:Lio/reactivex/CompletableObserver;

    invoke-interface {v0, p0}, Lio/reactivex/CompletableObserver;->onSubscribe(Lio/reactivex/disposables/Disposable;)V

    iget v0, p0, Lio/reactivex/internal/operators/mixed/FlowableConcatMapCompletable$ConcatMapCompletableObserver;->prefetch:I

    int-to-long v0, v0

    invoke-interface {p1, v0, v1}, Lorg/reactivestreams/Subscription;->request(J)V

    :cond_15
    return-void
.end method
