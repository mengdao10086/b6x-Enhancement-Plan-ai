.class public final Lcom/blankj/utilcode/util/ThreadUtils;
.super Ljava/lang/Object;
.source "ThreadUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/blankj/utilcode/util/ThreadUtils$SyncValue;,
        Lcom/blankj/utilcode/util/ThreadUtils$Task;,
        Lcom/blankj/utilcode/util/ThreadUtils$SimpleTask;,
        Lcom/blankj/utilcode/util/ThreadUtils$UtilsThreadFactory;,
        Lcom/blankj/utilcode/util/ThreadUtils$LinkedBlockingQueue4Util;,
        Lcom/blankj/utilcode/util/ThreadUtils$ThreadPoolExecutor4Util;
    }
.end annotation


# static fields
.field private static final CPU_COUNT:I

.field private static final HANDLER:Landroid/os/Handler;

.field private static final TASK_POOL_MAP:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task;",
            "Ljava/util/concurrent/ExecutorService;",
            ">;"
        }
    .end annotation
.end field

.field private static final TIMER:Ljava/util/Timer;

.field private static final TYPE_CACHED:B = -0x2t

.field private static final TYPE_CPU:B = -0x8t

.field private static final TYPE_IO:B = -0x4t

.field private static final TYPE_PRIORITY_POOLS:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/Integer;",
            "Ljava/util/Map<",
            "Ljava/lang/Integer;",
            "Ljava/util/concurrent/ExecutorService;",
            ">;>;"
        }
    .end annotation
.end field

.field private static final TYPE_SINGLE:B = -0x1t

.field private static sDeliver:Ljava/util/concurrent/Executor;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    sput-object v0, Lcom/blankj/utilcode/util/ThreadUtils;->HANDLER:Landroid/os/Handler;

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/blankj/utilcode/util/ThreadUtils;->TYPE_PRIORITY_POOLS:Ljava/util/Map;

    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    sput-object v0, Lcom/blankj/utilcode/util/ThreadUtils;->TASK_POOL_MAP:Ljava/util/Map;

    invoke-static {}, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Runtime;->availableProcessors()I

    move-result v0

    sput v0, Lcom/blankj/utilcode/util/ThreadUtils;->CPU_COUNT:I

    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    sput-object v0, Lcom/blankj/utilcode/util/ThreadUtils;->TIMER:Ljava/util/Timer;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$200()I
    .registers 1

    sget v0, Lcom/blankj/utilcode/util/ThreadUtils;->CPU_COUNT:I

    return v0
.end method

.method static synthetic access$600()Ljava/util/concurrent/Executor;
    .registers 1

    invoke-static {}, Lcom/blankj/utilcode/util/ThreadUtils;->getGlobalDeliver()Ljava/util/concurrent/Executor;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$700()Ljava/util/Map;
    .registers 1

    sget-object v0, Lcom/blankj/utilcode/util/ThreadUtils;->TASK_POOL_MAP:Ljava/util/Map;

    return-object v0
.end method

.method public static cancel(Lcom/blankj/utilcode/util/ThreadUtils$Task;)V
    .registers 1

    if-nez p0, :cond_3

    return-void

    :cond_3
    invoke-virtual {p0}, Lcom/blankj/utilcode/util/ThreadUtils$Task;->cancel()V

    return-void
.end method

.method public static cancel(Ljava/util/List;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task;",
            ">;)V"
        }
    .end annotation

    if-eqz p0, :cond_20

    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_9

    goto :goto_20

    :cond_9
    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :goto_d
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_20

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/blankj/utilcode/util/ThreadUtils$Task;

    if-nez v0, :cond_1c

    goto :goto_d

    :cond_1c
    invoke-virtual {v0}, Lcom/blankj/utilcode/util/ThreadUtils$Task;->cancel()V

    goto :goto_d

    :cond_20
    :goto_20
    return-void
.end method

.method public static cancel(Ljava/util/concurrent/ExecutorService;)V
    .registers 4

    instance-of v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$ThreadPoolExecutor4Util;

    if-eqz v0, :cond_2a

    sget-object v0, Lcom/blankj/utilcode/util/ThreadUtils;->TASK_POOL_MAP:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_e
    :goto_e
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_31

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    if-ne v2, p0, :cond_e

    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/blankj/utilcode/util/ThreadUtils$Task;

    invoke-static {v1}, Lcom/blankj/utilcode/util/ThreadUtils;->cancel(Lcom/blankj/utilcode/util/ThreadUtils$Task;)V

    goto :goto_e

    :cond_2a
    const-string p0, "ThreadUtils"

    const-string v0, "The executorService is not ThreadUtils\'s pool."

    invoke-static {p0, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    :cond_31
    return-void
.end method

.method public static varargs cancel([Lcom/blankj/utilcode/util/ThreadUtils$Task;)V
    .registers 4

    if-eqz p0, :cond_15

    array-length v0, p0

    if-nez v0, :cond_6

    goto :goto_15

    :cond_6
    array-length v0, p0

    const/4 v1, 0x0

    :goto_8
    if-ge v1, v0, :cond_15

    aget-object v2, p0, v1

    if-nez v2, :cond_f

    goto :goto_12

    :cond_f
    invoke-virtual {v2}, Lcom/blankj/utilcode/util/ThreadUtils$Task;->cancel()V

    :goto_12
    add-int/lit8 v1, v1, 0x1

    goto :goto_8

    :cond_15
    :goto_15
    return-void
.end method

.method private static execute(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;)V
    .registers 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/concurrent/ExecutorService;",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;)V"
        }
    .end annotation

    const-wide/16 v2, 0x0

    const-wide/16 v4, 0x0

    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p1

    invoke-static/range {v0 .. v6}, Lcom/blankj/utilcode/util/ThreadUtils;->execute(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method private static execute(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V
    .registers 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/concurrent/ExecutorService;",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;JJ",
            "Ljava/util/concurrent/TimeUnit;",
            ")V"
        }
    .end annotation

    sget-object v0, Lcom/blankj/utilcode/util/ThreadUtils;->TASK_POOL_MAP:Ljava/util/Map;

    monitor-enter v0

    :try_start_3
    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    if-eqz v1, :cond_12

    const-string p0, "ThreadUtils"

    const-string p1, "Task can only be executed once."

    invoke-static {p0, p1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    monitor-exit v0

    return-void

    :cond_12
    invoke-interface {v0, p1, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    monitor-exit v0
    :try_end_16
    .catchall {:try_start_3 .. :try_end_16} :catchall_4b

    const-wide/16 v0, 0x0

    cmp-long v2, p4, v0

    if-nez v2, :cond_33

    cmp-long p4, p2, v0

    if-nez p4, :cond_24

    invoke-interface {p0, p1}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    goto :goto_4a

    :cond_24
    new-instance p4, Lcom/blankj/utilcode/util/ThreadUtils$1;

    invoke-direct {p4, p0, p1}, Lcom/blankj/utilcode/util/ThreadUtils$1;-><init>(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;)V

    sget-object p0, Lcom/blankj/utilcode/util/ThreadUtils;->TIMER:Ljava/util/Timer;

    invoke-virtual {p6, p2, p3}, Ljava/util/concurrent/TimeUnit;->toMillis(J)J

    move-result-wide p1

    invoke-virtual {p0, p4, p1, p2}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    goto :goto_4a

    :cond_33
    const/4 v0, 0x1

    # invokes: Lcom/blankj/utilcode/util/ThreadUtils$Task;->setSchedule(Z)V
    invoke-static {p1, v0}, Lcom/blankj/utilcode/util/ThreadUtils$Task;->access$000(Lcom/blankj/utilcode/util/ThreadUtils$Task;Z)V

    new-instance v0, Lcom/blankj/utilcode/util/ThreadUtils$2;

    invoke-direct {v0, p0, p1}, Lcom/blankj/utilcode/util/ThreadUtils$2;-><init>(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;)V

    sget-object p0, Lcom/blankj/utilcode/util/ThreadUtils;->TIMER:Ljava/util/Timer;

    invoke-virtual {p6, p2, p3}, Ljava/util/concurrent/TimeUnit;->toMillis(J)J

    move-result-wide p2

    invoke-virtual {p6, p4, p5}, Ljava/util/concurrent/TimeUnit;->toMillis(J)J

    move-result-wide p4

    move-object p1, v0

    invoke-virtual/range {p0 .. p5}, Ljava/util/Timer;->scheduleAtFixedRate(Ljava/util/TimerTask;JJ)V

    :goto_4a
    return-void

    :catchall_4b
    move-exception p0

    :try_start_4c
    monitor-exit v0
    :try_end_4d
    .catchall {:try_start_4c .. :try_end_4d} :catchall_4b

    throw p0
.end method

.method private static executeAtFixedRate(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/concurrent/ExecutorService;",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;JJ",
            "Ljava/util/concurrent/TimeUnit;",
            ")V"
        }
    .end annotation

    invoke-static/range {p0 .. p6}, Lcom/blankj/utilcode/util/ThreadUtils;->execute(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeByCached(Lcom/blankj/utilcode/util/ThreadUtils$Task;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;)V"
        }
    .end annotation

    const/4 v0, -0x2

    invoke-static {v0}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    invoke-static {v0, p0}, Lcom/blankj/utilcode/util/ThreadUtils;->execute(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;)V

    return-void
.end method

.method public static executeByCached(Lcom/blankj/utilcode/util/ThreadUtils$Task;I)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;I)V"
        }
    .end annotation

    const/4 v0, -0x2

    invoke-static {v0, p1}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(II)Ljava/util/concurrent/ExecutorService;

    move-result-object p1

    invoke-static {p1, p0}, Lcom/blankj/utilcode/util/ThreadUtils;->execute(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;)V

    return-void
.end method

.method public static executeByCachedAtFixRate(Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V
    .registers 14
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;JJ",
            "Ljava/util/concurrent/TimeUnit;",
            ")V"
        }
    .end annotation

    const/4 v0, -0x2

    invoke-static {v0}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    move-object v2, p0

    move-wide v3, p1

    move-wide v5, p3

    move-object v7, p5

    invoke-static/range {v1 .. v7}, Lcom/blankj/utilcode/util/ThreadUtils;->executeAtFixedRate(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeByCachedAtFixRate(Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;I)V
    .registers 15
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;JJ",
            "Ljava/util/concurrent/TimeUnit;",
            "I)V"
        }
    .end annotation

    const/4 v0, -0x2

    invoke-static {v0, p6}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(II)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    move-object v2, p0

    move-wide v3, p1

    move-wide v5, p3

    move-object v7, p5

    invoke-static/range {v1 .. v7}, Lcom/blankj/utilcode/util/ThreadUtils;->executeAtFixedRate(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeByCachedAtFixRate(Lcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;)V
    .registers 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;J",
            "Ljava/util/concurrent/TimeUnit;",
            ")V"
        }
    .end annotation

    const/4 v0, -0x2

    invoke-static {v0}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    const-wide/16 v3, 0x0

    move-object v2, p0

    move-wide v5, p1

    move-object v7, p3

    invoke-static/range {v1 .. v7}, Lcom/blankj/utilcode/util/ThreadUtils;->executeAtFixedRate(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeByCachedAtFixRate(Lcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;I)V
    .registers 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;J",
            "Ljava/util/concurrent/TimeUnit;",
            "I)V"
        }
    .end annotation

    const/4 v0, -0x2

    invoke-static {v0, p4}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(II)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    const-wide/16 v3, 0x0

    move-object v2, p0

    move-wide v5, p1

    move-object v7, p3

    invoke-static/range {v1 .. v7}, Lcom/blankj/utilcode/util/ThreadUtils;->executeAtFixedRate(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeByCachedWithDelay(Lcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;J",
            "Ljava/util/concurrent/TimeUnit;",
            ")V"
        }
    .end annotation

    const/4 v0, -0x2

    invoke-static {v0}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    invoke-static {v0, p0, p1, p2, p3}, Lcom/blankj/utilcode/util/ThreadUtils;->executeWithDelay(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeByCachedWithDelay(Lcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;I)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;J",
            "Ljava/util/concurrent/TimeUnit;",
            "I)V"
        }
    .end annotation

    const/4 v0, -0x2

    invoke-static {v0, p4}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(II)Ljava/util/concurrent/ExecutorService;

    move-result-object p4

    invoke-static {p4, p0, p1, p2, p3}, Lcom/blankj/utilcode/util/ThreadUtils;->executeWithDelay(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeByCpu(Lcom/blankj/utilcode/util/ThreadUtils$Task;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;)V"
        }
    .end annotation

    const/4 v0, -0x8

    invoke-static {v0}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    invoke-static {v0, p0}, Lcom/blankj/utilcode/util/ThreadUtils;->execute(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;)V

    return-void
.end method

.method public static executeByCpu(Lcom/blankj/utilcode/util/ThreadUtils$Task;I)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;I)V"
        }
    .end annotation

    const/4 v0, -0x8

    invoke-static {v0, p1}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(II)Ljava/util/concurrent/ExecutorService;

    move-result-object p1

    invoke-static {p1, p0}, Lcom/blankj/utilcode/util/ThreadUtils;->execute(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;)V

    return-void
.end method

.method public static executeByCpuAtFixRate(Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V
    .registers 14
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;JJ",
            "Ljava/util/concurrent/TimeUnit;",
            ")V"
        }
    .end annotation

    const/4 v0, -0x8

    invoke-static {v0}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    move-object v2, p0

    move-wide v3, p1

    move-wide v5, p3

    move-object v7, p5

    invoke-static/range {v1 .. v7}, Lcom/blankj/utilcode/util/ThreadUtils;->executeAtFixedRate(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeByCpuAtFixRate(Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;I)V
    .registers 15
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;JJ",
            "Ljava/util/concurrent/TimeUnit;",
            "I)V"
        }
    .end annotation

    const/4 v0, -0x8

    invoke-static {v0, p6}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(II)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    move-object v2, p0

    move-wide v3, p1

    move-wide v5, p3

    move-object v7, p5

    invoke-static/range {v1 .. v7}, Lcom/blankj/utilcode/util/ThreadUtils;->executeAtFixedRate(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeByCpuAtFixRate(Lcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;)V
    .registers 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;J",
            "Ljava/util/concurrent/TimeUnit;",
            ")V"
        }
    .end annotation

    const/4 v0, -0x8

    invoke-static {v0}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    const-wide/16 v3, 0x0

    move-object v2, p0

    move-wide v5, p1

    move-object v7, p3

    invoke-static/range {v1 .. v7}, Lcom/blankj/utilcode/util/ThreadUtils;->executeAtFixedRate(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeByCpuAtFixRate(Lcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;I)V
    .registers 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;J",
            "Ljava/util/concurrent/TimeUnit;",
            "I)V"
        }
    .end annotation

    const/4 v0, -0x8

    invoke-static {v0, p4}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(II)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    const-wide/16 v3, 0x0

    move-object v2, p0

    move-wide v5, p1

    move-object v7, p3

    invoke-static/range {v1 .. v7}, Lcom/blankj/utilcode/util/ThreadUtils;->executeAtFixedRate(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeByCpuWithDelay(Lcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;J",
            "Ljava/util/concurrent/TimeUnit;",
            ")V"
        }
    .end annotation

    const/4 v0, -0x8

    invoke-static {v0}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    invoke-static {v0, p0, p1, p2, p3}, Lcom/blankj/utilcode/util/ThreadUtils;->executeWithDelay(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeByCpuWithDelay(Lcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;I)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;J",
            "Ljava/util/concurrent/TimeUnit;",
            "I)V"
        }
    .end annotation

    const/4 v0, -0x8

    invoke-static {v0, p4}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(II)Ljava/util/concurrent/ExecutorService;

    move-result-object p4

    invoke-static {p4, p0, p1, p2, p3}, Lcom/blankj/utilcode/util/ThreadUtils;->executeWithDelay(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeByCustom(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/concurrent/ExecutorService;",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;)V"
        }
    .end annotation

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ThreadUtils;->execute(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;)V

    return-void
.end method

.method public static executeByCustomAtFixRate(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/concurrent/ExecutorService;",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;JJ",
            "Ljava/util/concurrent/TimeUnit;",
            ")V"
        }
    .end annotation

    invoke-static/range {p0 .. p6}, Lcom/blankj/utilcode/util/ThreadUtils;->executeAtFixedRate(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeByCustomAtFixRate(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;)V
    .registers 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/concurrent/ExecutorService;",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;J",
            "Ljava/util/concurrent/TimeUnit;",
            ")V"
        }
    .end annotation

    const-wide/16 v2, 0x0

    move-object v0, p0

    move-object v1, p1

    move-wide v4, p2

    move-object v6, p4

    invoke-static/range {v0 .. v6}, Lcom/blankj/utilcode/util/ThreadUtils;->executeAtFixedRate(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeByCustomWithDelay(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/concurrent/ExecutorService;",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;J",
            "Ljava/util/concurrent/TimeUnit;",
            ")V"
        }
    .end annotation

    invoke-static {p0, p1, p2, p3, p4}, Lcom/blankj/utilcode/util/ThreadUtils;->executeWithDelay(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeByFixed(ILcom/blankj/utilcode/util/ThreadUtils$Task;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(I",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;)V"
        }
    .end annotation

    invoke-static {p0}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(I)Ljava/util/concurrent/ExecutorService;

    move-result-object p0

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ThreadUtils;->execute(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;)V

    return-void
.end method

.method public static executeByFixed(ILcom/blankj/utilcode/util/ThreadUtils$Task;I)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(I",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;I)V"
        }
    .end annotation

    invoke-static {p0, p2}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(II)Ljava/util/concurrent/ExecutorService;

    move-result-object p0

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ThreadUtils;->execute(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;)V

    return-void
.end method

.method public static executeByFixedAtFixRate(ILcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V
    .registers 14
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(I",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;JJ",
            "Ljava/util/concurrent/TimeUnit;",
            ")V"
        }
    .end annotation

    invoke-static {p0}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    move-object v1, p1

    move-wide v2, p2

    move-wide v4, p4

    move-object v6, p6

    invoke-static/range {v0 .. v6}, Lcom/blankj/utilcode/util/ThreadUtils;->executeAtFixedRate(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeByFixedAtFixRate(ILcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;I)V
    .registers 15
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(I",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;JJ",
            "Ljava/util/concurrent/TimeUnit;",
            "I)V"
        }
    .end annotation

    invoke-static {p0, p7}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(II)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    move-object v1, p1

    move-wide v2, p2

    move-wide v4, p4

    move-object v6, p6

    invoke-static/range {v0 .. v6}, Lcom/blankj/utilcode/util/ThreadUtils;->executeAtFixedRate(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeByFixedAtFixRate(ILcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;)V
    .registers 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(I",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;J",
            "Ljava/util/concurrent/TimeUnit;",
            ")V"
        }
    .end annotation

    invoke-static {p0}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    const-wide/16 v2, 0x0

    move-object v1, p1

    move-wide v4, p2

    move-object v6, p4

    invoke-static/range {v0 .. v6}, Lcom/blankj/utilcode/util/ThreadUtils;->executeAtFixedRate(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeByFixedAtFixRate(ILcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;I)V
    .registers 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(I",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;J",
            "Ljava/util/concurrent/TimeUnit;",
            "I)V"
        }
    .end annotation

    invoke-static {p0, p5}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(II)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    const-wide/16 v2, 0x0

    move-object v1, p1

    move-wide v4, p2

    move-object v6, p4

    invoke-static/range {v0 .. v6}, Lcom/blankj/utilcode/util/ThreadUtils;->executeAtFixedRate(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeByFixedWithDelay(ILcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(I",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;J",
            "Ljava/util/concurrent/TimeUnit;",
            ")V"
        }
    .end annotation

    invoke-static {p0}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(I)Ljava/util/concurrent/ExecutorService;

    move-result-object p0

    invoke-static {p0, p1, p2, p3, p4}, Lcom/blankj/utilcode/util/ThreadUtils;->executeWithDelay(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeByFixedWithDelay(ILcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;I)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(I",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;J",
            "Ljava/util/concurrent/TimeUnit;",
            "I)V"
        }
    .end annotation

    invoke-static {p0, p5}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(II)Ljava/util/concurrent/ExecutorService;

    move-result-object p0

    invoke-static {p0, p1, p2, p3, p4}, Lcom/blankj/utilcode/util/ThreadUtils;->executeWithDelay(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeByIo(Lcom/blankj/utilcode/util/ThreadUtils$Task;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;)V"
        }
    .end annotation

    const/4 v0, -0x4

    invoke-static {v0}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    invoke-static {v0, p0}, Lcom/blankj/utilcode/util/ThreadUtils;->execute(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;)V

    return-void
.end method

.method public static executeByIo(Lcom/blankj/utilcode/util/ThreadUtils$Task;I)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;I)V"
        }
    .end annotation

    const/4 v0, -0x4

    invoke-static {v0, p1}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(II)Ljava/util/concurrent/ExecutorService;

    move-result-object p1

    invoke-static {p1, p0}, Lcom/blankj/utilcode/util/ThreadUtils;->execute(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;)V

    return-void
.end method

.method public static executeByIoAtFixRate(Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V
    .registers 14
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;JJ",
            "Ljava/util/concurrent/TimeUnit;",
            ")V"
        }
    .end annotation

    const/4 v0, -0x4

    invoke-static {v0}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    move-object v2, p0

    move-wide v3, p1

    move-wide v5, p3

    move-object v7, p5

    invoke-static/range {v1 .. v7}, Lcom/blankj/utilcode/util/ThreadUtils;->executeAtFixedRate(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeByIoAtFixRate(Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;I)V
    .registers 15
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;JJ",
            "Ljava/util/concurrent/TimeUnit;",
            "I)V"
        }
    .end annotation

    const/4 v0, -0x4

    invoke-static {v0, p6}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(II)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    move-object v2, p0

    move-wide v3, p1

    move-wide v5, p3

    move-object v7, p5

    invoke-static/range {v1 .. v7}, Lcom/blankj/utilcode/util/ThreadUtils;->executeAtFixedRate(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeByIoAtFixRate(Lcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;)V
    .registers 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;J",
            "Ljava/util/concurrent/TimeUnit;",
            ")V"
        }
    .end annotation

    const/4 v0, -0x4

    invoke-static {v0}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    const-wide/16 v3, 0x0

    move-object v2, p0

    move-wide v5, p1

    move-object v7, p3

    invoke-static/range {v1 .. v7}, Lcom/blankj/utilcode/util/ThreadUtils;->executeAtFixedRate(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeByIoAtFixRate(Lcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;I)V
    .registers 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;J",
            "Ljava/util/concurrent/TimeUnit;",
            "I)V"
        }
    .end annotation

    const/4 v0, -0x4

    invoke-static {v0, p4}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(II)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    const-wide/16 v3, 0x0

    move-object v2, p0

    move-wide v5, p1

    move-object v7, p3

    invoke-static/range {v1 .. v7}, Lcom/blankj/utilcode/util/ThreadUtils;->executeAtFixedRate(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeByIoWithDelay(Lcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;J",
            "Ljava/util/concurrent/TimeUnit;",
            ")V"
        }
    .end annotation

    const/4 v0, -0x4

    invoke-static {v0}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    invoke-static {v0, p0, p1, p2, p3}, Lcom/blankj/utilcode/util/ThreadUtils;->executeWithDelay(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeByIoWithDelay(Lcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;I)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;J",
            "Ljava/util/concurrent/TimeUnit;",
            "I)V"
        }
    .end annotation

    const/4 v0, -0x4

    invoke-static {v0, p4}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(II)Ljava/util/concurrent/ExecutorService;

    move-result-object p4

    invoke-static {p4, p0, p1, p2, p3}, Lcom/blankj/utilcode/util/ThreadUtils;->executeWithDelay(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeBySingle(Lcom/blankj/utilcode/util/ThreadUtils$Task;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;)V"
        }
    .end annotation

    const/4 v0, -0x1

    invoke-static {v0}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    invoke-static {v0, p0}, Lcom/blankj/utilcode/util/ThreadUtils;->execute(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;)V

    return-void
.end method

.method public static executeBySingle(Lcom/blankj/utilcode/util/ThreadUtils$Task;I)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;I)V"
        }
    .end annotation

    const/4 v0, -0x1

    invoke-static {v0, p1}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(II)Ljava/util/concurrent/ExecutorService;

    move-result-object p1

    invoke-static {p1, p0}, Lcom/blankj/utilcode/util/ThreadUtils;->execute(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;)V

    return-void
.end method

.method public static executeBySingleAtFixRate(Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V
    .registers 14
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;JJ",
            "Ljava/util/concurrent/TimeUnit;",
            ")V"
        }
    .end annotation

    const/4 v0, -0x1

    invoke-static {v0}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    move-object v2, p0

    move-wide v3, p1

    move-wide v5, p3

    move-object v7, p5

    invoke-static/range {v1 .. v7}, Lcom/blankj/utilcode/util/ThreadUtils;->executeAtFixedRate(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeBySingleAtFixRate(Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;I)V
    .registers 15
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;JJ",
            "Ljava/util/concurrent/TimeUnit;",
            "I)V"
        }
    .end annotation

    const/4 v0, -0x1

    invoke-static {v0, p6}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(II)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    move-object v2, p0

    move-wide v3, p1

    move-wide v5, p3

    move-object v7, p5

    invoke-static/range {v1 .. v7}, Lcom/blankj/utilcode/util/ThreadUtils;->executeAtFixedRate(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeBySingleAtFixRate(Lcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;)V
    .registers 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;J",
            "Ljava/util/concurrent/TimeUnit;",
            ")V"
        }
    .end annotation

    const/4 v0, -0x1

    invoke-static {v0}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    const-wide/16 v3, 0x0

    move-object v2, p0

    move-wide v5, p1

    move-object v7, p3

    invoke-static/range {v1 .. v7}, Lcom/blankj/utilcode/util/ThreadUtils;->executeAtFixedRate(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeBySingleAtFixRate(Lcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;I)V
    .registers 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;J",
            "Ljava/util/concurrent/TimeUnit;",
            "I)V"
        }
    .end annotation

    const/4 v0, -0x1

    invoke-static {v0, p4}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(II)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    const-wide/16 v3, 0x0

    move-object v2, p0

    move-wide v5, p1

    move-object v7, p3

    invoke-static/range {v1 .. v7}, Lcom/blankj/utilcode/util/ThreadUtils;->executeAtFixedRate(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeBySingleWithDelay(Lcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;J",
            "Ljava/util/concurrent/TimeUnit;",
            ")V"
        }
    .end annotation

    const/4 v0, -0x1

    invoke-static {v0}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    invoke-static {v0, p0, p1, p2, p3}, Lcom/blankj/utilcode/util/ThreadUtils;->executeWithDelay(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static executeBySingleWithDelay(Lcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;I)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;J",
            "Ljava/util/concurrent/TimeUnit;",
            "I)V"
        }
    .end annotation

    const/4 v0, -0x1

    invoke-static {v0, p4}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(II)Ljava/util/concurrent/ExecutorService;

    move-result-object p4

    invoke-static {p4, p0, p1, p2, p3}, Lcom/blankj/utilcode/util/ThreadUtils;->executeWithDelay(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method private static executeWithDelay(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JLjava/util/concurrent/TimeUnit;)V
    .registers 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/concurrent/ExecutorService;",
            "Lcom/blankj/utilcode/util/ThreadUtils$Task<",
            "TT;>;J",
            "Ljava/util/concurrent/TimeUnit;",
            ")V"
        }
    .end annotation

    const-wide/16 v4, 0x0

    move-object v0, p0

    move-object v1, p1

    move-wide v2, p2

    move-object v6, p4

    invoke-static/range {v0 .. v6}, Lcom/blankj/utilcode/util/ThreadUtils;->execute(Ljava/util/concurrent/ExecutorService;Lcom/blankj/utilcode/util/ThreadUtils$Task;JJLjava/util/concurrent/TimeUnit;)V

    return-void
.end method

.method public static getCachedPool()Ljava/util/concurrent/ExecutorService;
    .registers 1

    const/4 v0, -0x2

    invoke-static {v0}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    return-object v0
.end method

.method public static getCachedPool(I)Ljava/util/concurrent/ExecutorService;
    .registers 2

    const/4 v0, -0x2

    invoke-static {v0, p0}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(II)Ljava/util/concurrent/ExecutorService;

    move-result-object p0

    return-object p0
.end method

.method public static getCpuPool()Ljava/util/concurrent/ExecutorService;
    .registers 1

    const/4 v0, -0x8

    invoke-static {v0}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    return-object v0
.end method

.method public static getCpuPool(I)Ljava/util/concurrent/ExecutorService;
    .registers 2

    const/4 v0, -0x8

    invoke-static {v0, p0}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(II)Ljava/util/concurrent/ExecutorService;

    move-result-object p0

    return-object p0
.end method

.method public static getFixedPool(I)Ljava/util/concurrent/ExecutorService;
    .registers 1

    invoke-static {p0}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(I)Ljava/util/concurrent/ExecutorService;

    move-result-object p0

    return-object p0
.end method

.method public static getFixedPool(II)Ljava/util/concurrent/ExecutorService;
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(II)Ljava/util/concurrent/ExecutorService;

    move-result-object p0

    return-object p0
.end method

.method private static getGlobalDeliver()Ljava/util/concurrent/Executor;
    .registers 1

    sget-object v0, Lcom/blankj/utilcode/util/ThreadUtils;->sDeliver:Ljava/util/concurrent/Executor;

    if-nez v0, :cond_b

    new-instance v0, Lcom/blankj/utilcode/util/ThreadUtils$3;

    invoke-direct {v0}, Lcom/blankj/utilcode/util/ThreadUtils$3;-><init>()V

    sput-object v0, Lcom/blankj/utilcode/util/ThreadUtils;->sDeliver:Ljava/util/concurrent/Executor;

    :cond_b
    sget-object v0, Lcom/blankj/utilcode/util/ThreadUtils;->sDeliver:Ljava/util/concurrent/Executor;

    return-object v0
.end method

.method public static getIoPool()Ljava/util/concurrent/ExecutorService;
    .registers 1

    const/4 v0, -0x4

    invoke-static {v0}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    return-object v0
.end method

.method public static getIoPool(I)Ljava/util/concurrent/ExecutorService;
    .registers 2

    const/4 v0, -0x4

    invoke-static {v0, p0}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(II)Ljava/util/concurrent/ExecutorService;

    move-result-object p0

    return-object p0
.end method

.method public static getMainHandler()Landroid/os/Handler;
    .registers 1

    sget-object v0, Lcom/blankj/utilcode/util/ThreadUtils;->HANDLER:Landroid/os/Handler;

    return-object v0
.end method

.method private static getPoolByTypeAndPriority(I)Ljava/util/concurrent/ExecutorService;
    .registers 2

    const/4 v0, 0x5

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(II)Ljava/util/concurrent/ExecutorService;

    move-result-object p0

    return-object p0
.end method

.method private static getPoolByTypeAndPriority(II)Ljava/util/concurrent/ExecutorService;
    .registers 5

    sget-object v0, Lcom/blankj/utilcode/util/ThreadUtils;->TYPE_PRIORITY_POOLS:Ljava/util/Map;

    monitor-enter v0

    :try_start_3
    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map;

    if-nez v1, :cond_27

    new-instance v1, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v1}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    # invokes: Lcom/blankj/utilcode/util/ThreadUtils$ThreadPoolExecutor4Util;->createPool(II)Ljava/util/concurrent/ExecutorService;
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ThreadUtils$ThreadPoolExecutor4Util;->access$100(II)Ljava/util/concurrent/ExecutorService;

    move-result-object v2

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-interface {v1, p1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p0

    invoke-interface {v0, p0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_3e

    :cond_27
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/concurrent/ExecutorService;

    if-nez v2, :cond_3e

    # invokes: Lcom/blankj/utilcode/util/ThreadUtils$ThreadPoolExecutor4Util;->createPool(II)Ljava/util/concurrent/ExecutorService;
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ThreadUtils$ThreadPoolExecutor4Util;->access$100(II)Ljava/util/concurrent/ExecutorService;

    move-result-object v2

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p0

    invoke-interface {v1, p0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_3e
    :goto_3e
    monitor-exit v0

    return-object v2

    :catchall_40
    move-exception p0

    monitor-exit v0
    :try_end_42
    .catchall {:try_start_3 .. :try_end_42} :catchall_40

    throw p0
.end method

.method public static getSinglePool()Ljava/util/concurrent/ExecutorService;
    .registers 1

    const/4 v0, -0x1

    invoke-static {v0}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    return-object v0
.end method

.method public static getSinglePool(I)Ljava/util/concurrent/ExecutorService;
    .registers 2

    const/4 v0, -0x1

    invoke-static {v0, p0}, Lcom/blankj/utilcode/util/ThreadUtils;->getPoolByTypeAndPriority(II)Ljava/util/concurrent/ExecutorService;

    move-result-object p0

    return-object p0
.end method

.method public static isMainThread()Z
    .registers 2

    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    if-ne v0, v1, :cond_c

    const/4 v0, 0x1

    goto :goto_d

    :cond_c
    const/4 v0, 0x0

    :goto_d
    return v0
.end method

.method public static runOnUiThread(Ljava/lang/Runnable;)V
    .registers 3

    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    if-ne v0, v1, :cond_e

    invoke-interface {p0}, Ljava/lang/Runnable;->run()V

    goto :goto_13

    :cond_e
    sget-object v0, Lcom/blankj/utilcode/util/ThreadUtils;->HANDLER:Landroid/os/Handler;

    invoke-virtual {v0, p0}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    :goto_13
    return-void
.end method

.method public static runOnUiThreadDelayed(Ljava/lang/Runnable;J)V
    .registers 4

    sget-object v0, Lcom/blankj/utilcode/util/ThreadUtils;->HANDLER:Landroid/os/Handler;

    invoke-virtual {v0, p0, p1, p2}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    return-void
.end method

.method public static setDeliver(Ljava/util/concurrent/Executor;)V
    .registers 1

    sput-object p0, Lcom/blankj/utilcode/util/ThreadUtils;->sDeliver:Ljava/util/concurrent/Executor;

    return-void
.end method
