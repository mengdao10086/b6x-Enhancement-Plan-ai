.class public Lcom/blankj/utilcode/util/ThreadUtils$SyncValue;
.super Ljava/lang/Object;
.source "ThreadUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/blankj/utilcode/util/ThreadUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SyncValue"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private mFlag:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private mLatch:Ljava/util/concurrent/CountDownLatch;

.field private mValue:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    iput-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$SyncValue;->mLatch:Ljava/util/concurrent/CountDownLatch;

    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>()V

    iput-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$SyncValue;->mFlag:Ljava/util/concurrent/atomic/AtomicBoolean;

    return-void
.end method


# virtual methods
.method public getValue()Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    iget-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$SyncValue;->mFlag:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    if-nez v0, :cond_12

    :try_start_8
    iget-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$SyncValue;->mLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->await()V
    :try_end_d
    .catch Ljava/lang/InterruptedException; {:try_start_8 .. :try_end_d} :catch_e

    goto :goto_12

    :catch_e
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    :cond_12
    :goto_12
    iget-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$SyncValue;->mValue:Ljava/lang/Object;

    return-object v0
.end method

.method public getValue(JLjava/util/concurrent/TimeUnit;Ljava/lang/Object;)Ljava/lang/Object;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Ljava/util/concurrent/TimeUnit;",
            "TT;)TT;"
        }
    .end annotation

    iget-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$SyncValue;->mFlag:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    if-nez v0, :cond_13

    :try_start_8
    iget-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$SyncValue;->mLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0, p1, p2, p3}, Ljava/util/concurrent/CountDownLatch;->await(JLjava/util/concurrent/TimeUnit;)Z
    :try_end_d
    .catch Ljava/lang/InterruptedException; {:try_start_8 .. :try_end_d} :catch_e

    goto :goto_13

    :catch_e
    move-exception p1

    invoke-virtual {p1}, Ljava/lang/InterruptedException;->printStackTrace()V

    return-object p4

    :cond_13
    :goto_13
    iget-object p1, p0, Lcom/blankj/utilcode/util/ThreadUtils$SyncValue;->mValue:Ljava/lang/Object;

    return-object p1
.end method

.method public setValue(Ljava/lang/Object;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    iget-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$SyncValue;->mFlag:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(ZZ)Z

    move-result v0

    if-eqz v0, :cond_11

    iput-object p1, p0, Lcom/blankj/utilcode/util/ThreadUtils$SyncValue;->mValue:Ljava/lang/Object;

    iget-object p1, p0, Lcom/blankj/utilcode/util/ThreadUtils$SyncValue;->mLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {p1}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    :cond_11
    return-void
.end method
