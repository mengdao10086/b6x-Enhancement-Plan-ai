.class final Landroidx/concurrent/futures/AbstractResolvableFuture$SynchronizedHelper;
.super Landroidx/concurrent/futures/AbstractResolvableFuture$AtomicHelper;
.source "AbstractResolvableFuture.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/concurrent/futures/AbstractResolvableFuture;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "SynchronizedHelper"
.end annotation


# direct methods
.method constructor <init>()V
    .registers 2

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroidx/concurrent/futures/AbstractResolvableFuture$AtomicHelper;-><init>(Landroidx/concurrent/futures/AbstractResolvableFuture$1;)V

    return-void
.end method


# virtual methods
.method casListeners(Landroidx/concurrent/futures/AbstractResolvableFuture;Landroidx/concurrent/futures/AbstractResolvableFuture$Listener;Landroidx/concurrent/futures/AbstractResolvableFuture$Listener;)Z
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/concurrent/futures/AbstractResolvableFuture<",
            "*>;",
            "Landroidx/concurrent/futures/AbstractResolvableFuture$Listener;",
            "Landroidx/concurrent/futures/AbstractResolvableFuture$Listener;",
            ")Z"
        }
    .end annotation

    monitor-enter p1

    :try_start_1
    iget-object v0, p1, Landroidx/concurrent/futures/AbstractResolvableFuture;->listeners:Landroidx/concurrent/futures/AbstractResolvableFuture$Listener;

    if-ne v0, p2, :cond_a

    iput-object p3, p1, Landroidx/concurrent/futures/AbstractResolvableFuture;->listeners:Landroidx/concurrent/futures/AbstractResolvableFuture$Listener;

    monitor-exit p1

    const/4 p1, 0x1

    return p1

    :cond_a
    monitor-exit p1

    const/4 p1, 0x0

    return p1

    :catchall_d
    move-exception p2

    monitor-exit p1
    :try_end_f
    .catchall {:try_start_1 .. :try_end_f} :catchall_d

    throw p2
.end method

.method casValue(Landroidx/concurrent/futures/AbstractResolvableFuture;Ljava/lang/Object;Ljava/lang/Object;)Z
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/concurrent/futures/AbstractResolvableFuture<",
            "*>;",
            "Ljava/lang/Object;",
            "Ljava/lang/Object;",
            ")Z"
        }
    .end annotation

    monitor-enter p1

    :try_start_1
    iget-object v0, p1, Landroidx/concurrent/futures/AbstractResolvableFuture;->value:Ljava/lang/Object;

    if-ne v0, p2, :cond_a

    iput-object p3, p1, Landroidx/concurrent/futures/AbstractResolvableFuture;->value:Ljava/lang/Object;

    monitor-exit p1

    const/4 p1, 0x1

    return p1

    :cond_a
    monitor-exit p1

    const/4 p1, 0x0

    return p1

    :catchall_d
    move-exception p2

    monitor-exit p1
    :try_end_f
    .catchall {:try_start_1 .. :try_end_f} :catchall_d

    throw p2
.end method

.method casWaiters(Landroidx/concurrent/futures/AbstractResolvableFuture;Landroidx/concurrent/futures/AbstractResolvableFuture$Waiter;Landroidx/concurrent/futures/AbstractResolvableFuture$Waiter;)Z
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/concurrent/futures/AbstractResolvableFuture<",
            "*>;",
            "Landroidx/concurrent/futures/AbstractResolvableFuture$Waiter;",
            "Landroidx/concurrent/futures/AbstractResolvableFuture$Waiter;",
            ")Z"
        }
    .end annotation

    monitor-enter p1

    :try_start_1
    iget-object v0, p1, Landroidx/concurrent/futures/AbstractResolvableFuture;->waiters:Landroidx/concurrent/futures/AbstractResolvableFuture$Waiter;

    if-ne v0, p2, :cond_a

    iput-object p3, p1, Landroidx/concurrent/futures/AbstractResolvableFuture;->waiters:Landroidx/concurrent/futures/AbstractResolvableFuture$Waiter;

    monitor-exit p1

    const/4 p1, 0x1

    return p1

    :cond_a
    monitor-exit p1

    const/4 p1, 0x0

    return p1

    :catchall_d
    move-exception p2

    monitor-exit p1
    :try_end_f
    .catchall {:try_start_1 .. :try_end_f} :catchall_d

    throw p2
.end method

.method putNext(Landroidx/concurrent/futures/AbstractResolvableFuture$Waiter;Landroidx/concurrent/futures/AbstractResolvableFuture$Waiter;)V
    .registers 3

    iput-object p2, p1, Landroidx/concurrent/futures/AbstractResolvableFuture$Waiter;->next:Landroidx/concurrent/futures/AbstractResolvableFuture$Waiter;

    return-void
.end method

.method putThread(Landroidx/concurrent/futures/AbstractResolvableFuture$Waiter;Ljava/lang/Thread;)V
    .registers 3

    iput-object p2, p1, Landroidx/concurrent/futures/AbstractResolvableFuture$Waiter;->thread:Ljava/lang/Thread;

    return-void
.end method
