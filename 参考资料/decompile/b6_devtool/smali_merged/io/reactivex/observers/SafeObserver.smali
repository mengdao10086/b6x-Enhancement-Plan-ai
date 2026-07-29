.class public final Lio/reactivex/observers/SafeObserver;
.super Ljava/lang/Object;
.source "SafeObserver.java"

# interfaces
.implements Lio/reactivex/Observer;
.implements Lio/reactivex/disposables/Disposable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lio/reactivex/Observer<",
        "TT;>;",
        "Lio/reactivex/disposables/Disposable;"
    }
.end annotation


# instance fields
.field done:Z

.field final downstream:Lio/reactivex/Observer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/reactivex/Observer<",
            "-TT;>;"
        }
    .end annotation
.end field

.field upstream:Lio/reactivex/disposables/Disposable;


# direct methods
.method public constructor <init>(Lio/reactivex/Observer;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/Observer<",
            "-TT;>;)V"
        }
    .end annotation

    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    iput-object p1, p0, Lio/reactivex/observers/SafeObserver;->downstream:Lio/reactivex/Observer;

    return-void
.end method


# virtual methods
.method public dispose()V
    .registers 2

    .line 68
    iget-object v0, p0, Lio/reactivex/observers/SafeObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-interface {v0}, Lio/reactivex/disposables/Disposable;->dispose()V

    return-void
.end method

.method public isDisposed()Z
    .registers 2

    .line 73
    iget-object v0, p0, Lio/reactivex/observers/SafeObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-interface {v0}, Lio/reactivex/disposables/Disposable;->isDisposed()Z

    move-result v0

    return v0
.end method

.method public onComplete()V
    .registers 2

    .line 180
    iget-boolean v0, p0, Lio/reactivex/observers/SafeObserver;->done:Z

    if-eqz v0, :cond_5

    return-void

    :cond_5
    const/4 v0, 0x1

    .line 184
    iput-boolean v0, p0, Lio/reactivex/observers/SafeObserver;->done:Z

    .line 186
    iget-object v0, p0, Lio/reactivex/observers/SafeObserver;->upstream:Lio/reactivex/disposables/Disposable;

    if-nez v0, :cond_10

    .line 187
    invoke-virtual {p0}, Lio/reactivex/observers/SafeObserver;->onCompleteNoSubscription()V

    return-void

    .line 192
    :cond_10
    :try_start_10
    iget-object v0, p0, Lio/reactivex/observers/SafeObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {v0}, Lio/reactivex/Observer;->onComplete()V
    :try_end_15
    .catchall {:try_start_10 .. :try_end_15} :catchall_16

    goto :goto_1d

    :catchall_16
    move-exception v0

    .line 194
    invoke-static {v0}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 195
    invoke-static {v0}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    :goto_1d
    return-void
.end method

.method onCompleteNoSubscription()V
    .registers 7

    .line 201
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "Subscription not set!"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    const/4 v1, 0x1

    const/4 v2, 0x0

    const/4 v3, 0x2

    .line 204
    :try_start_a
    iget-object v4, p0, Lio/reactivex/observers/SafeObserver;->downstream:Lio/reactivex/Observer;

    sget-object v5, Lio/reactivex/internal/disposables/EmptyDisposable;->INSTANCE:Lio/reactivex/internal/disposables/EmptyDisposable;

    invoke-interface {v4, v5}, Lio/reactivex/Observer;->onSubscribe(Lio/reactivex/disposables/Disposable;)V
    :try_end_11
    .catchall {:try_start_a .. :try_end_11} :catchall_2a

    .line 212
    :try_start_11
    iget-object v4, p0, Lio/reactivex/observers/SafeObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {v4, v0}, Lio/reactivex/Observer;->onError(Ljava/lang/Throwable;)V
    :try_end_16
    .catchall {:try_start_11 .. :try_end_16} :catchall_17

    goto :goto_29

    :catchall_17
    move-exception v4

    .line 214
    invoke-static {v4}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 216
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

    .line 206
    invoke-static {v4}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 208
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

    .line 138
    iget-boolean v0, p0, Lio/reactivex/observers/SafeObserver;->done:Z

    if-eqz v0, :cond_8

    .line 139
    invoke-static {p1}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    return-void

    :cond_8
    const/4 v0, 0x1

    .line 142
    iput-boolean v0, p0, Lio/reactivex/observers/SafeObserver;->done:Z

    .line 144
    iget-object v1, p0, Lio/reactivex/observers/SafeObserver;->upstream:Lio/reactivex/disposables/Disposable;

    const/4 v2, 0x0

    const/4 v3, 0x2

    if-nez v1, :cond_5b

    .line 145
    new-instance v1, Ljava/lang/NullPointerException;

    const-string v4, "Subscription not set!"

    invoke-direct {v1, v4}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    const/4 v4, 0x3

    .line 148
    :try_start_19
    iget-object v5, p0, Lio/reactivex/observers/SafeObserver;->downstream:Lio/reactivex/Observer;

    sget-object v6, Lio/reactivex/internal/disposables/EmptyDisposable;->INSTANCE:Lio/reactivex/internal/disposables/EmptyDisposable;

    invoke-interface {v5, v6}, Lio/reactivex/Observer;->onSubscribe(Lio/reactivex/disposables/Disposable;)V
    :try_end_20
    .catchall {:try_start_19 .. :try_end_20} :catchall_46

    .line 156
    :try_start_20
    iget-object v5, p0, Lio/reactivex/observers/SafeObserver;->downstream:Lio/reactivex/Observer;

    new-instance v6, Lio/reactivex/exceptions/CompositeException;

    new-array v7, v3, [Ljava/lang/Throwable;

    aput-object p1, v7, v2

    aput-object v1, v7, v0

    invoke-direct {v6, v7}, Lio/reactivex/exceptions/CompositeException;-><init>([Ljava/lang/Throwable;)V

    invoke-interface {v5, v6}, Lio/reactivex/Observer;->onError(Ljava/lang/Throwable;)V
    :try_end_30
    .catchall {:try_start_20 .. :try_end_30} :catchall_31

    goto :goto_45

    :catchall_31
    move-exception v5

    .line 158
    invoke-static {v5}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 160
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

    .line 150
    invoke-static {v5}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 152
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

    .line 166
    new-instance p1, Ljava/lang/NullPointerException;

    const-string v1, "onError called with null. Null values are generally not allowed in 2.x operators and sources."

    invoke-direct {p1, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    .line 170
    :cond_64
    :try_start_64
    iget-object v1, p0, Lio/reactivex/observers/SafeObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {v1, p1}, Lio/reactivex/Observer;->onError(Ljava/lang/Throwable;)V
    :try_end_69
    .catchall {:try_start_64 .. :try_end_69} :catchall_6a

    goto :goto_7c

    :catchall_6a
    move-exception v1

    .line 172
    invoke-static {v1}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 174
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

    .line 78
    iget-boolean v0, p0, Lio/reactivex/observers/SafeObserver;->done:Z

    if-eqz v0, :cond_5

    return-void

    .line 81
    :cond_5
    iget-object v0, p0, Lio/reactivex/observers/SafeObserver;->upstream:Lio/reactivex/disposables/Disposable;

    if-nez v0, :cond_d

    .line 82
    invoke-virtual {p0}, Lio/reactivex/observers/SafeObserver;->onNextNoSubscription()V

    return-void

    :cond_d
    const/4 v0, 0x1

    const/4 v1, 0x0

    const/4 v2, 0x2

    if-nez p1, :cond_35

    .line 87
    new-instance p1, Ljava/lang/NullPointerException;

    const-string v3, "onNext called with null. Null values are generally not allowed in 2.x operators and sources."

    invoke-direct {p1, v3}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    .line 89
    :try_start_19
    iget-object v3, p0, Lio/reactivex/observers/SafeObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-interface {v3}, Lio/reactivex/disposables/Disposable;->dispose()V
    :try_end_1e
    .catchall {:try_start_19 .. :try_end_1e} :catchall_22

    .line 95
    invoke-virtual {p0, p1}, Lio/reactivex/observers/SafeObserver;->onError(Ljava/lang/Throwable;)V

    return-void

    :catchall_22
    move-exception v3

    .line 91
    invoke-static {v3}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 92
    new-instance v4, Lio/reactivex/exceptions/CompositeException;

    new-array v2, v2, [Ljava/lang/Throwable;

    aput-object p1, v2, v1

    aput-object v3, v2, v0

    invoke-direct {v4, v2}, Lio/reactivex/exceptions/CompositeException;-><init>([Ljava/lang/Throwable;)V

    invoke-virtual {p0, v4}, Lio/reactivex/observers/SafeObserver;->onError(Ljava/lang/Throwable;)V

    return-void

    .line 100
    :cond_35
    :try_start_35
    iget-object v3, p0, Lio/reactivex/observers/SafeObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {v3, p1}, Lio/reactivex/Observer;->onNext(Ljava/lang/Object;)V
    :try_end_3a
    .catchall {:try_start_35 .. :try_end_3a} :catchall_3b

    goto :goto_47

    :catchall_3b
    move-exception p1

    .line 102
    invoke-static {p1}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 104
    :try_start_3f
    iget-object v3, p0, Lio/reactivex/observers/SafeObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-interface {v3}, Lio/reactivex/disposables/Disposable;->dispose()V
    :try_end_44
    .catchall {:try_start_3f .. :try_end_44} :catchall_48

    .line 110
    invoke-virtual {p0, p1}, Lio/reactivex/observers/SafeObserver;->onError(Ljava/lang/Throwable;)V

    :goto_47
    return-void

    :catchall_48
    move-exception v3

    .line 106
    invoke-static {v3}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 107
    new-instance v4, Lio/reactivex/exceptions/CompositeException;

    new-array v2, v2, [Ljava/lang/Throwable;

    aput-object p1, v2, v1

    aput-object v3, v2, v0

    invoke-direct {v4, v2}, Lio/reactivex/exceptions/CompositeException;-><init>([Ljava/lang/Throwable;)V

    invoke-virtual {p0, v4}, Lio/reactivex/observers/SafeObserver;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method onNextNoSubscription()V
    .registers 7

    const/4 v0, 0x1

    .line 115
    iput-boolean v0, p0, Lio/reactivex/observers/SafeObserver;->done:Z

    .line 117
    new-instance v1, Ljava/lang/NullPointerException;

    const-string v2, "Subscription not set!"

    invoke-direct {v1, v2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    const/4 v2, 0x0

    const/4 v3, 0x2

    .line 120
    :try_start_c
    iget-object v4, p0, Lio/reactivex/observers/SafeObserver;->downstream:Lio/reactivex/Observer;

    sget-object v5, Lio/reactivex/internal/disposables/EmptyDisposable;->INSTANCE:Lio/reactivex/internal/disposables/EmptyDisposable;

    invoke-interface {v4, v5}, Lio/reactivex/Observer;->onSubscribe(Lio/reactivex/disposables/Disposable;)V
    :try_end_13
    .catchall {:try_start_c .. :try_end_13} :catchall_2c

    .line 128
    :try_start_13
    iget-object v4, p0, Lio/reactivex/observers/SafeObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {v4, v1}, Lio/reactivex/Observer;->onError(Ljava/lang/Throwable;)V
    :try_end_18
    .catchall {:try_start_13 .. :try_end_18} :catchall_19

    goto :goto_2b

    :catchall_19
    move-exception v4

    .line 130
    invoke-static {v4}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 132
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

    .line 122
    invoke-static {v4}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 124
    new-instance v5, Lio/reactivex/exceptions/CompositeException;

    new-array v3, v3, [Ljava/lang/Throwable;

    aput-object v1, v3, v2

    aput-object v4, v3, v0

    invoke-direct {v5, v3}, Lio/reactivex/exceptions/CompositeException;-><init>([Ljava/lang/Throwable;)V

    invoke-static {v5}, Lio/reactivex/plugins/RxJavaPlugins;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onSubscribe(Lio/reactivex/disposables/Disposable;)V
    .registers 7

    .line 46
    iget-object v0, p0, Lio/reactivex/observers/SafeObserver;->upstream:Lio/reactivex/disposables/Disposable;

    invoke-static {v0, p1}, Lio/reactivex/internal/disposables/DisposableHelper;->validate(Lio/reactivex/disposables/Disposable;Lio/reactivex/disposables/Disposable;)Z

    move-result v0

    if-eqz v0, :cond_32

    .line 47
    iput-object p1, p0, Lio/reactivex/observers/SafeObserver;->upstream:Lio/reactivex/disposables/Disposable;

    .line 49
    :try_start_a
    iget-object v0, p0, Lio/reactivex/observers/SafeObserver;->downstream:Lio/reactivex/Observer;

    invoke-interface {v0, p0}, Lio/reactivex/Observer;->onSubscribe(Lio/reactivex/disposables/Disposable;)V
    :try_end_f
    .catchall {:try_start_a .. :try_end_f} :catchall_10

    goto :goto_32

    :catchall_10
    move-exception v0

    .line 51
    invoke-static {v0}, Lio/reactivex/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    const/4 v1, 0x1

    .line 52
    iput-boolean v1, p0, Lio/reactivex/observers/SafeObserver;->done:Z

    .line 55
    :try_start_17
    invoke-interface {p1}, Lio/reactivex/disposables/Disposable;->dispose()V
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
