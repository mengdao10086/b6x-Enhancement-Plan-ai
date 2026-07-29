.class public final Lio/reactivex/subscribers/SafeSubscriber;
.super Ljava/lang/Object;
.source "SafeSubscriber.java"

# interfaces
.implements Lio/reactivex/FlowableSubscriber;
.implements Lorg/reactivestreams/Subscription;


# annotations
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

.field upstream:Lorg/reactivestreams/Subscription;


# direct methods
.method public constructor <init>(Lorg/reactivestreams/Subscriber;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;)V"
        }
    .end annotation

    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    iput-object p1, p0, Lio/reactivex/subscribers/SafeSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    return-void
.end method


# virtual methods
.method public cancel()V
    .registers 2

    .line 228
    :try_start_0
    iget-object v0, p0, Lio/reactivex/subscribers/SafeSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    invoke-interface {v0}, Lorg/reactivestreams/Subscription;->cancel()V
    :try_end_5
    .catchall {:try_start_0 .. :try_end_5} :catchall_6

    goto :goto_d

    :catchall_6
    move-exception v0

    .line 230
    invoke-static {v0}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 231
    invoke-static {v0}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :goto_d
    return-void
.end method

.method public onComplete()V
    .registers 2

    .line 169
    iget-boolean v0, p0, Lio/reactivex/subscribers/SafeSubscriber;->done:Z

    if-eqz v0, :cond_5

    return-void

    :cond_5
    const/4 v0, 0x1

    .line 172
    iput-boolean v0, p0, Lio/reactivex/subscribers/SafeSubscriber;->done:Z

    .line 174
    iget-object v0, p0, Lio/reactivex/subscribers/SafeSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    if-nez v0, :cond_10

    .line 175
    invoke-virtual {p0}, Lio/reactivex/subscribers/SafeSubscriber;->onCompleteNoSubscription()V

    return-void

    .line 180
    :cond_10
    :try_start_10
    iget-object v0, p0, Lio/reactivex/subscribers/SafeSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    invoke-interface {v0}, Lorg/reactivestreams/Subscriber;->onComplete()V
    :try_end_15
    .catchall {:try_start_10 .. :try_end_15} :catchall_16

    goto :goto_1d

    :catchall_16
    move-exception v0

    .line 182
    invoke-static {v0}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 183
    invoke-static {v0}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :goto_1d
    return-void
.end method

.method onCompleteNoSubscription()V
    .registers 7

    .line 189
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "Subscription not set!"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    const/4 v1, 0x1

    const/4 v2, 0x0

    const/4 v3, 0x2

    .line 192
    :try_start_a
    iget-object v4, p0, Lio/reactivex/subscribers/SafeSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    sget-object v5, Lio/reactivex/internal/subscriptions/EmptySubscription;->INSTANCE:Lio/reactivex/internal/subscriptions/EmptySubscription;

    invoke-interface {v4, v5}, Lorg/reactivestreams/Subscriber;->onSubscribe(Lorg/reactivestreams/Subscription;)V
    :try_end_11
    .catchall {:try_start_a .. :try_end_11} :catchall_2a

    .line 200
    :try_start_11
    iget-object v4, p0, Lio/reactivex/subscribers/SafeSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    invoke-interface {v4, v0}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V
    :try_end_16
    .catchall {:try_start_11 .. :try_end_16} :catchall_17

    goto :goto_29

    :catchall_17
    move-exception v4

    .line 202
    invoke-static {v4}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 204
    new-instance v5, Lio/reactivex/exceptions/CompositeException;

    new-array v3, v3, [Ljava/lang/Throwable;

    aput-object v0, v3, v2

    aput-object v4, v3, v1

    invoke-direct {v5, v3}, Lio/reactivex/exceptions/CompositeException;-><init>([Ljava/lang/Throwable;)V

    invoke-static {v5}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :goto_29
    return-void

    :catchall_2a
    move-exception v4

    .line 194
    invoke-static {v4}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 196
    new-instance v5, Lio/reactivex/exceptions/CompositeException;

    new-array v3, v3, [Ljava/lang/Throwable;

    aput-object v0, v3, v2

    aput-object v4, v3, v1

    invoke-direct {v5, v3}, Lio/reactivex/exceptions/CompositeException;-><init>([Ljava/lang/Throwable;)V

    invoke-static {v5}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .registers 10

    .line 127
    iget-boolean v0, p0, Lio/reactivex/subscribers/SafeSubscriber;->done:Z

    if-eqz v0, :cond_8

    .line 128
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    return-void

    :cond_8
    const/4 v0, 0x1

    .line 131
    iput-boolean v0, p0, Lio/reactivex/subscribers/SafeSubscriber;->done:Z

    .line 133
    iget-object v1, p0, Lio/reactivex/subscribers/SafeSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    const/4 v2, 0x0

    const/4 v3, 0x2

    if-nez v1, :cond_5b

    .line 134
    new-instance v1, Ljava/lang/NullPointerException;

    const-string v4, "Subscription not set!"

    invoke-direct {v1, v4}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    const/4 v4, 0x3

    .line 137
    :try_start_19
    iget-object v5, p0, Lio/reactivex/subscribers/SafeSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    sget-object v6, Lio/reactivex/internal/subscriptions/EmptySubscription;->INSTANCE:Lio/reactivex/internal/subscriptions/EmptySubscription;

    invoke-interface {v5, v6}, Lorg/reactivestreams/Subscriber;->onSubscribe(Lorg/reactivestreams/Subscription;)V
    :try_end_20
    .catchall {:try_start_19 .. :try_end_20} :catchall_46

    .line 145
    :try_start_20
    iget-object v5, p0, Lio/reactivex/subscribers/SafeSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    new-instance v6, Lio/reactivex/exceptions/CompositeException;

    new-array v7, v3, [Ljava/lang/Throwable;

    aput-object p1, v7, v2

    aput-object v1, v7, v0

    invoke-direct {v6, v7}, Lio/reactivex/exceptions/CompositeException;-><init>([Ljava/lang/Throwable;)V

    invoke-interface {v5, v6}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V
    :try_end_30
    .catchall {:try_start_20 .. :try_end_30} :catchall_31

    goto :goto_45

    :catchall_31
    move-exception v5

    .line 147
    invoke-static {v5}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 149
    new-instance v6, Lio/reactivex/exceptions/CompositeException;

    new-array v4, v4, [Ljava/lang/Throwable;

    aput-object p1, v4, v2

    aput-object v1, v4, v0

    aput-object v5, v4, v3

    invoke-direct {v6, v4}, Lio/reactivex/exceptions/CompositeException;-><init>([Ljava/lang/Throwable;)V

    invoke-static {v6}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :goto_45
    return-void

    :catchall_46
    move-exception v5

    .line 139
    invoke-static {v5}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 141
    new-instance v6, Lio/reactivex/exceptions/CompositeException;

    new-array v4, v4, [Ljava/lang/Throwable;

    aput-object p1, v4, v2

    aput-object v1, v4, v0

    aput-object v5, v4, v3

    invoke-direct {v6, v4}, Lio/reactivex/exceptions/CompositeException;-><init>([Ljava/lang/Throwable;)V

    invoke-static {v6}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    return-void

    :cond_5b
    if-nez p1, :cond_64

    .line 155
    new-instance p1, Ljava/lang/NullPointerException;

    const-string v1, "onError called with null. Null values are generally not allowed in 2.x operators and sources."

    invoke-direct {p1, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    .line 159
    :cond_64
    :try_start_64
    iget-object v1, p0, Lio/reactivex/subscribers/SafeSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    invoke-interface {v1, p1}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V
    :try_end_69
    .catchall {:try_start_64 .. :try_end_69} :catchall_6a

    goto :goto_7c

    :catchall_6a
    move-exception v1

    .line 161
    invoke-static {v1}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 163
    new-instance v4, Lio/reactivex/exceptions/CompositeException;

    new-array v3, v3, [Ljava/lang/Throwable;

    aput-object p1, v3, v2

    aput-object v1, v3, v0

    invoke-direct {v4, v3}, Lio/reactivex/exceptions/CompositeException;-><init>([Ljava/lang/Throwable;)V

    invoke-static {v4}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :goto_7c
    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 68
    iget-boolean v0, p0, Lio/reactivex/subscribers/SafeSubscriber;->done:Z

    if-eqz v0, :cond_5

    return-void

    .line 71
    :cond_5
    iget-object v0, p0, Lio/reactivex/subscribers/SafeSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    if-nez v0, :cond_d

    .line 72
    invoke-virtual {p0}, Lio/reactivex/subscribers/SafeSubscriber;->onNextNoSubscription()V

    return-void

    :cond_d
    const/4 v0, 0x1

    const/4 v1, 0x0

    const/4 v2, 0x2

    if-nez p1, :cond_35

    .line 77
    new-instance p1, Ljava/lang/NullPointerException;

    const-string v3, "onNext called with null. Null values are generally not allowed in 2.x operators and sources."

    invoke-direct {p1, v3}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    .line 79
    :try_start_19
    iget-object v3, p0, Lio/reactivex/subscribers/SafeSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    invoke-interface {v3}, Lorg/reactivestreams/Subscription;->cancel()V
    :try_end_1e
    .catchall {:try_start_19 .. :try_end_1e} :catchall_22

    .line 85
    invoke-virtual {p0, p1}, Lio/reactivex/subscribers/SafeSubscriber;->onError(Ljava/lang/Throwable;)V

    return-void

    :catchall_22
    move-exception v3

    .line 81
    invoke-static {v3}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 82
    new-instance v4, Lio/reactivex/exceptions/CompositeException;

    new-array v2, v2, [Ljava/lang/Throwable;

    aput-object p1, v2, v1

    aput-object v3, v2, v0

    invoke-direct {v4, v2}, Lio/reactivex/exceptions/CompositeException;-><init>([Ljava/lang/Throwable;)V

    invoke-virtual {p0, v4}, Lio/reactivex/subscribers/SafeSubscriber;->onError(Ljava/lang/Throwable;)V

    return-void

    .line 90
    :cond_35
    :try_start_35
    iget-object v3, p0, Lio/reactivex/subscribers/SafeSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    invoke-interface {v3, p1}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V
    :try_end_3a
    .catchall {:try_start_35 .. :try_end_3a} :catchall_3b

    goto :goto_47

    :catchall_3b
    move-exception p1

    .line 92
    invoke-static {p1}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 94
    :try_start_3f
    iget-object v3, p0, Lio/reactivex/subscribers/SafeSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    invoke-interface {v3}, Lorg/reactivestreams/Subscription;->cancel()V
    :try_end_44
    .catchall {:try_start_3f .. :try_end_44} :catchall_48

    .line 100
    invoke-virtual {p0, p1}, Lio/reactivex/subscribers/SafeSubscriber;->onError(Ljava/lang/Throwable;)V

    :goto_47
    return-void

    :catchall_48
    move-exception v3

    .line 96
    invoke-static {v3}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 97
    new-instance v4, Lio/reactivex/exceptions/CompositeException;

    new-array v2, v2, [Ljava/lang/Throwable;

    aput-object p1, v2, v1

    aput-object v3, v2, v0

    invoke-direct {v4, v2}, Lio/reactivex/exceptions/CompositeException;-><init>([Ljava/lang/Throwable;)V

    invoke-virtual {p0, v4}, Lio/reactivex/subscribers/SafeSubscriber;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method onNextNoSubscription()V
    .registers 7

    const/4 v0, 0x1

    .line 105
    iput-boolean v0, p0, Lio/reactivex/subscribers/SafeSubscriber;->done:Z

    .line 106
    new-instance v1, Ljava/lang/NullPointerException;

    const-string v2, "Subscription not set!"

    invoke-direct {v1, v2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    const/4 v2, 0x0

    const/4 v3, 0x2

    .line 109
    :try_start_c
    iget-object v4, p0, Lio/reactivex/subscribers/SafeSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    sget-object v5, Lio/reactivex/internal/subscriptions/EmptySubscription;->INSTANCE:Lio/reactivex/internal/subscriptions/EmptySubscription;

    invoke-interface {v4, v5}, Lorg/reactivestreams/Subscriber;->onSubscribe(Lorg/reactivestreams/Subscription;)V
    :try_end_13
    .catchall {:try_start_c .. :try_end_13} :catchall_2c

    .line 117
    :try_start_13
    iget-object v4, p0, Lio/reactivex/subscribers/SafeSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    invoke-interface {v4, v1}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V
    :try_end_18
    .catchall {:try_start_13 .. :try_end_18} :catchall_19

    goto :goto_2b

    :catchall_19
    move-exception v4

    .line 119
    invoke-static {v4}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 121
    new-instance v5, Lio/reactivex/exceptions/CompositeException;

    new-array v3, v3, [Ljava/lang/Throwable;

    aput-object v1, v3, v2

    aput-object v4, v3, v0

    invoke-direct {v5, v3}, Lio/reactivex/exceptions/CompositeException;-><init>([Ljava/lang/Throwable;)V

    invoke-static {v5}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :goto_2b
    return-void

    :catchall_2c
    move-exception v4

    .line 111
    invoke-static {v4}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 113
    new-instance v5, Lio/reactivex/exceptions/CompositeException;

    new-array v3, v3, [Ljava/lang/Throwable;

    aput-object v1, v3, v2

    aput-object v4, v3, v0

    invoke-direct {v5, v3}, Lio/reactivex/exceptions/CompositeException;-><init>([Ljava/lang/Throwable;)V

    invoke-static {v5}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onSubscribe(Lorg/reactivestreams/Subscription;)V
    .registers 7

    .line 46
    iget-object v0, p0, Lio/reactivex/subscribers/SafeSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    invoke-static {v0, p1}, Lio/reactivex/internal/subscriptions/SubscriptionHelper;->validate(Lorg/reactivestreams/Subscription;Lorg/reactivestreams/Subscription;)Z

    move-result v0

    if-eqz v0, :cond_32

    .line 47
    iput-object p1, p0, Lio/reactivex/subscribers/SafeSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    .line 49
    :try_start_a
    iget-object v0, p0, Lio/reactivex/subscribers/SafeSubscriber;->downstream:Lorg/reactivestreams/Subscriber;

    invoke-interface {v0, p0}, Lorg/reactivestreams/Subscriber;->onSubscribe(Lorg/reactivestreams/Subscription;)V
    :try_end_f
    .catchall {:try_start_a .. :try_end_f} :catchall_10

    goto :goto_32

    :catchall_10
    move-exception v0

    .line 51
    invoke-static {v0}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    const/4 v1, 0x1

    .line 52
    iput-boolean v1, p0, Lio/reactivex/subscribers/SafeSubscriber;->done:Z

    .line 55
    :try_start_17
    invoke-interface {p1}, Lorg/reactivestreams/Subscription;->cancel()V
    :try_end_1a
    .catchall {:try_start_17 .. :try_end_1a} :catchall_1e

    .line 61
    invoke-static {v0}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    goto :goto_32

    :catchall_1e
    move-exception p1

    .line 57
    invoke-static {p1}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 58
    new-instance v2, Lio/reactivex/exceptions/CompositeException;

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Throwable;

    const/4 v4, 0x0

    aput-object v0, v3, v4

    aput-object p1, v3, v1

    invoke-direct {v2, v3}, Lio/reactivex/exceptions/CompositeException;-><init>([Ljava/lang/Throwable;)V

    invoke-static {v2}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :cond_32
    :goto_32
    return-void
.end method

.method public request(J)V
    .registers 6

    .line 211
    :try_start_0
    iget-object v0, p0, Lio/reactivex/subscribers/SafeSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    invoke-interface {v0, p1, p2}, Lorg/reactivestreams/Subscription;->request(J)V
    :try_end_5
    .catchall {:try_start_0 .. :try_end_5} :catchall_6

    goto :goto_12

    :catchall_6
    move-exception p1

    .line 213
    invoke-static {p1}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 215
    :try_start_a
    iget-object p2, p0, Lio/reactivex/subscribers/SafeSubscriber;->upstream:Lorg/reactivestreams/Subscription;

    invoke-interface {p2}, Lorg/reactivestreams/Subscription;->cancel()V
    :try_end_f
    .catchall {:try_start_a .. :try_end_f} :catchall_13

    .line 221
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :goto_12
    return-void

    :catchall_13
    move-exception p2

    .line 217
    invoke-static {p2}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 218
    new-instance v0, Lio/reactivex/exceptions/CompositeException;

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Throwable;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    const/4 p1, 0x1

    aput-object p2, v1, p1

    invoke-direct {v0, v1}, Lio/reactivex/exceptions/CompositeException;-><init>([Ljava/lang/Throwable;)V

    invoke-static {v0}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    return-void
.end method
