.class final Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;
.super Ljava/lang/Object;
.source "CacheDiskUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/blankj/utilcode/util/CacheDiskUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "DiskCacheManager"
.end annotation


# instance fields
.field private final cacheCount:Ljava/util/concurrent/atomic/AtomicInteger;

.field private final cacheDir:Ljava/io/File;

.field private final cacheSize:Ljava/util/concurrent/atomic/AtomicLong;

.field private final countLimit:I

.field private final lastUsageDates:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/io/File;",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field private final mThread:Ljava/lang/Thread;

.field private final sizeLimit:J


# direct methods
.method private constructor <init>(Ljava/io/File;JI)V
    .registers 6

    .line 660
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 655
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 656
    invoke-static {v0}, Ljava/util/Collections;->synchronizedMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->lastUsageDates:Ljava/util/Map;

    .line 661
    iput-object p1, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->cacheDir:Ljava/io/File;

    .line 662
    iput-wide p2, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->sizeLimit:J

    .line 663
    iput p4, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->countLimit:I

    .line 664
    new-instance p2, Ljava/util/concurrent/atomic/AtomicLong;

    invoke-direct {p2}, Ljava/util/concurrent/atomic/AtomicLong;-><init>()V

    iput-object p2, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->cacheSize:Ljava/util/concurrent/atomic/AtomicLong;

    .line 665
    new-instance p2, Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-direct {p2}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    iput-object p2, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->cacheCount:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 666
    new-instance p2, Ljava/lang/Thread;

    new-instance p3, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager$1;

    invoke-direct {p3, p0, p1}, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager$1;-><init>(Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;Ljava/io/File;)V

    invoke-direct {p2, p3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    iput-object p2, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->mThread:Ljava/lang/Thread;

    .line 688
    invoke-virtual {p2}, Ljava/lang/Thread;->start()V

    return-void
.end method

.method synthetic constructor <init>(Ljava/io/File;JILcom/blankj/utilcode/util/CacheDiskUtils$1;)V
    .registers 6

    .line 650
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;-><init>(Ljava/io/File;JI)V

    return-void
.end method

.method static synthetic access$1000(Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;)I
    .registers 1

    .line 650
    invoke-direct {p0}, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->getCacheCount()I

    move-result p0

    return p0
.end method

.method static synthetic access$1100(Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;)Z
    .registers 1

    .line 650
    invoke-direct {p0}, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->clear()Z

    move-result p0

    return p0
.end method

.method static synthetic access$1200(Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;)Ljava/util/Map;
    .registers 1

    .line 650
    iget-object p0, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->lastUsageDates:Ljava/util/Map;

    return-object p0
.end method

.method static synthetic access$1300(Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;)Ljava/util/concurrent/atomic/AtomicLong;
    .registers 1

    .line 650
    iget-object p0, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->cacheSize:Ljava/util/concurrent/atomic/AtomicLong;

    return-object p0
.end method

.method static synthetic access$1400(Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;)Ljava/util/concurrent/atomic/AtomicInteger;
    .registers 1

    .line 650
    iget-object p0, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->cacheCount:Ljava/util/concurrent/atomic/AtomicInteger;

    return-object p0
.end method

.method static synthetic access$200(Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;Ljava/lang/String;)Ljava/io/File;
    .registers 2

    .line 650
    invoke-direct {p0, p1}, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->getFileBeforePut(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    return-object p0
.end method

.method static synthetic access$300(Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;Ljava/io/File;)V
    .registers 2

    .line 650
    invoke-direct {p0, p1}, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->updateModify(Ljava/io/File;)V

    return-void
.end method

.method static synthetic access$400(Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;Ljava/io/File;)V
    .registers 2

    .line 650
    invoke-direct {p0, p1}, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->put(Ljava/io/File;)V

    return-void
.end method

.method static synthetic access$500(Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;Ljava/lang/String;)Ljava/io/File;
    .registers 2

    .line 650
    invoke-direct {p0, p1}, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->getFileIfExists(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    return-object p0
.end method

.method static synthetic access$700(Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;Ljava/lang/String;)Z
    .registers 2

    .line 650
    invoke-direct {p0, p1}, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->removeByKey(Ljava/lang/String;)Z

    move-result p0

    return p0
.end method

.method static synthetic access$900(Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;)J
    .registers 3

    .line 650
    invoke-direct {p0}, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->getCacheSize()J

    move-result-wide v0

    return-wide v0
.end method

.method private clear()Z
    .registers 10

    .line 755
    iget-object v0, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->cacheDir:Ljava/io/File;

    new-instance v1, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager$2;

    invoke-direct {v1, p0}, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager$2;-><init>(Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;)V

    invoke-virtual {v0, v1}, Ljava/io/File;->listFiles(Ljava/io/FilenameFilter;)[Ljava/io/File;

    move-result-object v0

    const/4 v1, 0x1

    if-eqz v0, :cond_4c

    .line 761
    array-length v2, v0

    if-gtz v2, :cond_12

    goto :goto_4c

    .line 763
    :cond_12
    array-length v2, v0

    const/4 v3, 0x0

    move v4, v3

    :goto_15
    if-ge v4, v2, :cond_39

    aget-object v5, v0, v4

    .line 764
    invoke-virtual {v5}, Ljava/io/File;->delete()Z

    move-result v6

    if-nez v6, :cond_21

    move v1, v3

    goto :goto_36

    .line 768
    :cond_21
    iget-object v6, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->cacheSize:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v5}, Ljava/io/File;->length()J

    move-result-wide v7

    neg-long v7, v7

    invoke-virtual {v6, v7, v8}, Ljava/util/concurrent/atomic/AtomicLong;->addAndGet(J)J

    .line 769
    iget-object v6, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->cacheCount:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v7, -0x1

    invoke-virtual {v6, v7}, Ljava/util/concurrent/atomic/AtomicInteger;->addAndGet(I)I

    .line 770
    iget-object v6, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->lastUsageDates:Ljava/util/Map;

    invoke-interface {v6, v5}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    :goto_36
    add-int/lit8 v4, v4, 0x1

    goto :goto_15

    :cond_39
    if-eqz v1, :cond_4c

    .line 773
    iget-object v0, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->lastUsageDates:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 774
    iget-object v0, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->cacheSize:Ljava/util/concurrent/atomic/AtomicLong;

    const-wide/16 v4, 0x0

    invoke-virtual {v0, v4, v5}, Ljava/util/concurrent/atomic/AtomicLong;->set(J)V

    .line 775
    iget-object v0, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->cacheCount:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0, v3}, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V

    :cond_4c
    :goto_4c
    return v1
.end method

.method private getCacheCount()I
    .registers 2

    .line 697
    invoke-direct {p0}, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->wait2InitOk()V

    .line 698
    iget-object v0, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->cacheCount:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v0

    return v0
.end method

.method private getCacheNameByKey(Ljava/lang/String;)Ljava/lang/String;
    .registers 5

    .line 726
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "cdu_"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const/4 v1, 0x0

    const/4 v2, 0x3

    invoke-virtual {p1, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/String;->hashCode()I

    move-result p1

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    return-object p1
.end method

.method private getCacheSize()J
    .registers 3

    .line 692
    invoke-direct {p0}, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->wait2InitOk()V

    .line 693
    iget-object v0, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->cacheSize:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v0

    return-wide v0
.end method

.method private getFileBeforePut(Ljava/lang/String;)Ljava/io/File;
    .registers 5

    .line 702
    invoke-direct {p0}, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->wait2InitOk()V

    .line 703
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->cacheDir:Ljava/io/File;

    invoke-direct {p0, p1}, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->getCacheNameByKey(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, v1, p1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 704
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result p1

    if-eqz p1, :cond_24

    .line 705
    iget-object p1, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->cacheCount:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v1, -0x1

    invoke-virtual {p1, v1}, Ljava/util/concurrent/atomic/AtomicInteger;->addAndGet(I)I

    .line 706
    iget-object p1, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->cacheSize:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v0}, Ljava/io/File;->length()J

    move-result-wide v1

    neg-long v1, v1

    invoke-virtual {p1, v1, v2}, Ljava/util/concurrent/atomic/AtomicLong;->addAndGet(J)J

    :cond_24
    return-object v0
.end method

.method private getFileIfExists(Ljava/lang/String;)Ljava/io/File;
    .registers 4

    .line 720
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->cacheDir:Ljava/io/File;

    invoke-direct {p0, p1}, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->getCacheNameByKey(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, v1, p1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 721
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result p1

    if-nez p1, :cond_13

    const/4 p1, 0x0

    return-object p1

    :cond_13
    return-object v0
.end method

.method private put(Ljava/io/File;)V
    .registers 6

    .line 730
    iget-object v0, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->cacheCount:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;->addAndGet(I)I

    .line 731
    iget-object v0, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->cacheSize:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {p1}, Ljava/io/File;->length()J

    move-result-wide v1

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicLong;->addAndGet(J)J

    .line 732
    :goto_f
    iget-object p1, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->cacheCount:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {p1}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result p1

    iget v0, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->countLimit:I

    if-gt p1, v0, :cond_27

    iget-object p1, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->cacheSize:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {p1}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v0

    iget-wide v2, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->sizeLimit:J

    cmp-long p1, v0, v2

    if-lez p1, :cond_26

    goto :goto_27

    :cond_26
    return-void

    .line 733
    :cond_27
    :goto_27
    iget-object p1, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->cacheSize:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-direct {p0}, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->removeOldest()J

    move-result-wide v0

    neg-long v0, v0

    invoke-virtual {p1, v0, v1}, Ljava/util/concurrent/atomic/AtomicLong;->addAndGet(J)J

    .line 734
    iget-object p1, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->cacheCount:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v0, -0x1

    invoke-virtual {p1, v0}, Ljava/util/concurrent/atomic/AtomicInteger;->addAndGet(I)I

    goto :goto_f
.end method

.method private removeByKey(Ljava/lang/String;)Z
    .registers 6

    .line 745
    invoke-direct {p0, p1}, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->getFileIfExists(Ljava/lang/String;)Ljava/io/File;

    move-result-object p1

    const/4 v0, 0x1

    if-nez p1, :cond_8

    return v0

    .line 747
    :cond_8
    invoke-virtual {p1}, Ljava/io/File;->delete()Z

    move-result v1

    if-nez v1, :cond_10

    const/4 p1, 0x0

    return p1

    .line 748
    :cond_10
    iget-object v1, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->cacheSize:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {p1}, Ljava/io/File;->length()J

    move-result-wide v2

    neg-long v2, v2

    invoke-virtual {v1, v2, v3}, Ljava/util/concurrent/atomic/AtomicLong;->addAndGet(J)J

    .line 749
    iget-object v1, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->cacheCount:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v2, -0x1

    invoke-virtual {v1, v2}, Ljava/util/concurrent/atomic/AtomicInteger;->addAndGet(I)I

    .line 750
    iget-object v1, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->lastUsageDates:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    return v0
.end method

.method private removeOldest()J
    .registers 13

    .line 786
    iget-object v0, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->lastUsageDates:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->isEmpty()Z

    move-result v0

    const-wide/16 v1, 0x0

    if-eqz v0, :cond_b

    return-wide v1

    :cond_b
    const-wide v3, 0x7fffffffffffffffL

    .line 787
    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    .line 789
    iget-object v3, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->lastUsageDates:Ljava/util/Map;

    invoke-interface {v3}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v3

    .line 790
    iget-object v4, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->lastUsageDates:Ljava/util/Map;

    monitor-enter v4

    .line 791
    :try_start_1d
    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    const/4 v5, 0x0

    :cond_22
    :goto_22
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_49

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/Map$Entry;

    .line 792
    invoke-interface {v6}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/Long;

    .line 793
    invoke-virtual {v7}, Ljava/lang/Long;->longValue()J

    move-result-wide v8

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v10

    cmp-long v8, v8, v10

    if-gez v8, :cond_22

    .line 795
    invoke-interface {v6}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/io/File;

    move-object v5, v0

    move-object v0, v7

    goto :goto_22

    .line 798
    :cond_49
    monitor-exit v4
    :try_end_4a
    .catchall {:try_start_1d .. :try_end_4a} :catchall_5e

    if-nez v5, :cond_4d

    return-wide v1

    .line 800
    :cond_4d
    invoke-virtual {v5}, Ljava/io/File;->length()J

    move-result-wide v3

    .line 801
    invoke-virtual {v5}, Ljava/io/File;->delete()Z

    move-result v0

    if-eqz v0, :cond_5d

    .line 802
    iget-object v0, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->lastUsageDates:Ljava/util/Map;

    invoke-interface {v0, v5}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    return-wide v3

    :cond_5d
    return-wide v1

    :catchall_5e
    move-exception v0

    .line 798
    :try_start_5f
    monitor-exit v4
    :try_end_60
    .catchall {:try_start_5f .. :try_end_60} :catchall_5e

    throw v0
.end method

.method private updateModify(Ljava/io/File;)V
    .registers 5

    .line 739
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    .line 740
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v1

    invoke-virtual {p1, v1, v2}, Ljava/io/File;->setLastModified(J)Z

    .line 741
    iget-object v1, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->lastUsageDates:Ljava/util/Map;

    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method private wait2InitOk()V
    .registers 2

    .line 713
    :try_start_0
    iget-object v0, p0, Lcom/blankj/utilcode/util/CacheDiskUtils$DiskCacheManager;->mThread:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->join()V
    :try_end_5
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_5} :catch_6

    goto :goto_a

    :catch_6
    move-exception v0

    .line 715
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    :goto_a
    return-void
.end method
