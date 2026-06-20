.class public final Lcom/blankj/utilcode/util/CacheMemoryStaticUtils;
.super Ljava/lang/Object;
.source "CacheMemoryStaticUtils.java"


# static fields
.field private static sDefaultCacheMemoryUtils:Lcom/blankj/utilcode/util/CacheMemoryUtils;


# direct methods
.method public constructor <init>()V
    .registers 1

    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static clear()V
    .registers 1

    .line 93
    invoke-static {}, Lcom/blankj/utilcode/util/CacheMemoryStaticUtils;->getDefaultCacheMemoryUtils()Lcom/blankj/utilcode/util/CacheMemoryUtils;

    move-result-object v0

    invoke-static {v0}, Lcom/blankj/utilcode/util/CacheMemoryStaticUtils;->clear(Lcom/blankj/utilcode/util/CacheMemoryUtils;)V

    return-void
.end method

.method public static clear(Lcom/blankj/utilcode/util/CacheMemoryUtils;)V
    .registers 1

    .line 182
    invoke-virtual {p0}, Lcom/blankj/utilcode/util/CacheMemoryUtils;->clear()V

    return-void
.end method

.method public static get(Ljava/lang/String;)Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/String;",
            ")TT;"
        }
    .end annotation

    .line 55
    invoke-static {}, Lcom/blankj/utilcode/util/CacheMemoryStaticUtils;->getDefaultCacheMemoryUtils()Lcom/blankj/utilcode/util/CacheMemoryUtils;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/CacheMemoryStaticUtils;->get(Ljava/lang/String;Lcom/blankj/utilcode/util/CacheMemoryUtils;)Ljava/lang/Object;

    move-result-object p0

    return-object p0
.end method

.method public static get(Ljava/lang/String;Lcom/blankj/utilcode/util/CacheMemoryUtils;)Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/String;",
            "Lcom/blankj/utilcode/util/CacheMemoryUtils;",
            ")TT;"
        }
    .end annotation

    .line 137
    invoke-virtual {p1, p0}, Lcom/blankj/utilcode/util/CacheMemoryUtils;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p0

    return-object p0
.end method

.method public static get(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/String;",
            "TT;)TT;"
        }
    .end annotation

    .line 67
    invoke-static {}, Lcom/blankj/utilcode/util/CacheMemoryStaticUtils;->getDefaultCacheMemoryUtils()Lcom/blankj/utilcode/util/CacheMemoryUtils;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/CacheMemoryStaticUtils;->get(Ljava/lang/String;Ljava/lang/Object;Lcom/blankj/utilcode/util/CacheMemoryUtils;)Ljava/lang/Object;

    move-result-object p0

    return-object p0
.end method

.method public static get(Ljava/lang/String;Ljava/lang/Object;Lcom/blankj/utilcode/util/CacheMemoryUtils;)Ljava/lang/Object;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/String;",
            "TT;",
            "Lcom/blankj/utilcode/util/CacheMemoryUtils;",
            ")TT;"
        }
    .end annotation

    .line 152
    invoke-virtual {p2, p0, p1}, Lcom/blankj/utilcode/util/CacheMemoryUtils;->get(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    return-object p0
.end method

.method public static getCacheCount()I
    .registers 1

    .line 76
    invoke-static {}, Lcom/blankj/utilcode/util/CacheMemoryStaticUtils;->getDefaultCacheMemoryUtils()Lcom/blankj/utilcode/util/CacheMemoryUtils;

    move-result-object v0

    invoke-static {v0}, Lcom/blankj/utilcode/util/CacheMemoryStaticUtils;->getCacheCount(Lcom/blankj/utilcode/util/CacheMemoryUtils;)I

    move-result v0

    return v0
.end method

.method public static getCacheCount(Lcom/blankj/utilcode/util/CacheMemoryUtils;)I
    .registers 1

    .line 162
    invoke-virtual {p0}, Lcom/blankj/utilcode/util/CacheMemoryUtils;->getCacheCount()I

    move-result p0

    return p0
.end method

.method private static getDefaultCacheMemoryUtils()Lcom/blankj/utilcode/util/CacheMemoryUtils;
    .registers 1

    .line 186
    sget-object v0, Lcom/blankj/utilcode/util/CacheMemoryStaticUtils;->sDefaultCacheMemoryUtils:Lcom/blankj/utilcode/util/CacheMemoryUtils;

    if-eqz v0, :cond_5

    goto :goto_9

    :cond_5
    invoke-static {}, Lcom/blankj/utilcode/util/CacheMemoryUtils;->getInstance()Lcom/blankj/utilcode/util/CacheMemoryUtils;

    move-result-object v0

    :goto_9
    return-object v0
.end method

.method public static put(Ljava/lang/String;Ljava/lang/Object;)V
    .registers 3

    .line 33
    invoke-static {}, Lcom/blankj/utilcode/util/CacheMemoryStaticUtils;->getDefaultCacheMemoryUtils()Lcom/blankj/utilcode/util/CacheMemoryUtils;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/CacheMemoryStaticUtils;->put(Ljava/lang/String;Ljava/lang/Object;Lcom/blankj/utilcode/util/CacheMemoryUtils;)V

    return-void
.end method

.method public static put(Ljava/lang/String;Ljava/lang/Object;I)V
    .registers 4

    .line 44
    invoke-static {}, Lcom/blankj/utilcode/util/CacheMemoryStaticUtils;->getDefaultCacheMemoryUtils()Lcom/blankj/utilcode/util/CacheMemoryUtils;

    move-result-object v0

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/CacheMemoryStaticUtils;->put(Ljava/lang/String;Ljava/lang/Object;ILcom/blankj/utilcode/util/CacheMemoryUtils;)V

    return-void
.end method

.method public static put(Ljava/lang/String;Ljava/lang/Object;ILcom/blankj/utilcode/util/CacheMemoryUtils;)V
    .registers 4

    .line 125
    invoke-virtual {p3, p0, p1, p2}, Lcom/blankj/utilcode/util/CacheMemoryUtils;->put(Ljava/lang/String;Ljava/lang/Object;I)V

    return-void
.end method

.method public static put(Ljava/lang/String;Ljava/lang/Object;Lcom/blankj/utilcode/util/CacheMemoryUtils;)V
    .registers 3

    .line 110
    invoke-virtual {p2, p0, p1}, Lcom/blankj/utilcode/util/CacheMemoryUtils;->put(Ljava/lang/String;Ljava/lang/Object;)V

    return-void
.end method

.method public static remove(Ljava/lang/String;)Ljava/lang/Object;
    .registers 2

    .line 86
    invoke-static {}, Lcom/blankj/utilcode/util/CacheMemoryStaticUtils;->getDefaultCacheMemoryUtils()Lcom/blankj/utilcode/util/CacheMemoryUtils;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/CacheMemoryStaticUtils;->remove(Ljava/lang/String;Lcom/blankj/utilcode/util/CacheMemoryUtils;)Ljava/lang/Object;

    move-result-object p0

    return-object p0
.end method

.method public static remove(Ljava/lang/String;Lcom/blankj/utilcode/util/CacheMemoryUtils;)Ljava/lang/Object;
    .registers 2

    .line 173
    invoke-virtual {p1, p0}, Lcom/blankj/utilcode/util/CacheMemoryUtils;->remove(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p0

    return-object p0
.end method

.method public static setDefaultCacheMemoryUtils(Lcom/blankj/utilcode/util/CacheMemoryUtils;)V
    .registers 1

    .line 23
    sput-object p0, Lcom/blankj/utilcode/util/CacheMemoryStaticUtils;->sDefaultCacheMemoryUtils:Lcom/blankj/utilcode/util/CacheMemoryUtils;

    return-void
.end method
