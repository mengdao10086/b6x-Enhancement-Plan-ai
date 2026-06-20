.class public final Lcom/blankj/utilcode/util/SPStaticUtils;
.super Ljava/lang/Object;
.source "SPStaticUtils.java"


# static fields
.field private static sDefaultSPUtils:Lcom/blankj/utilcode/util/SPUtils;


# direct methods
.method public constructor <init>()V
    .registers 1

    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static clear()V
    .registers 1

    .line 337
    invoke-static {}, Lcom/blankj/utilcode/util/SPStaticUtils;->getDefaultSPUtils()Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    invoke-static {v0}, Lcom/blankj/utilcode/util/SPStaticUtils;->clear(Lcom/blankj/utilcode/util/SPUtils;)V

    return-void
.end method

.method public static clear(Lcom/blankj/utilcode/util/SPUtils;)V
    .registers 1

    .line 712
    invoke-virtual {p0}, Lcom/blankj/utilcode/util/SPUtils;->clear()V

    return-void
.end method

.method public static clear(Z)V
    .registers 2

    .line 347
    invoke-static {}, Lcom/blankj/utilcode/util/SPStaticUtils;->getDefaultSPUtils()Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/SPStaticUtils;->clear(ZLcom/blankj/utilcode/util/SPUtils;)V

    return-void
.end method

.method public static clear(ZLcom/blankj/utilcode/util/SPUtils;)V
    .registers 2

    .line 723
    invoke-virtual {p1, p0}, Lcom/blankj/utilcode/util/SPUtils;->clear(Z)V

    return-void
.end method

.method public static contains(Ljava/lang/String;)Z
    .registers 2

    .line 310
    invoke-static {}, Lcom/blankj/utilcode/util/SPStaticUtils;->getDefaultSPUtils()Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/SPStaticUtils;->contains(Ljava/lang/String;Lcom/blankj/utilcode/util/SPUtils;)Z

    move-result p0

    return p0
.end method

.method public static contains(Ljava/lang/String;Lcom/blankj/utilcode/util/SPUtils;)Z
    .registers 2

    .line 681
    invoke-virtual {p1, p0}, Lcom/blankj/utilcode/util/SPUtils;->contains(Ljava/lang/String;)Z

    move-result p0

    return p0
.end method

.method public static getAll()Ljava/util/Map;
    .registers 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "*>;"
        }
    .end annotation

    .line 300
    invoke-static {}, Lcom/blankj/utilcode/util/SPStaticUtils;->getDefaultSPUtils()Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    invoke-static {v0}, Lcom/blankj/utilcode/util/SPStaticUtils;->getAll(Lcom/blankj/utilcode/util/SPUtils;)Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public static getAll(Lcom/blankj/utilcode/util/SPUtils;)Ljava/util/Map;
    .registers 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/blankj/utilcode/util/SPUtils;",
            ")",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "*>;"
        }
    .end annotation

    .line 670
    invoke-virtual {p0}, Lcom/blankj/utilcode/util/SPUtils;->getAll()Ljava/util/Map;

    move-result-object p0

    return-object p0
.end method

.method public static getBoolean(Ljava/lang/String;)Z
    .registers 2

    .line 233
    invoke-static {}, Lcom/blankj/utilcode/util/SPStaticUtils;->getDefaultSPUtils()Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/SPStaticUtils;->getBoolean(Ljava/lang/String;Lcom/blankj/utilcode/util/SPUtils;)Z

    move-result p0

    return p0
.end method

.method public static getBoolean(Ljava/lang/String;Lcom/blankj/utilcode/util/SPUtils;)Z
    .registers 2

    .line 593
    invoke-virtual {p1, p0}, Lcom/blankj/utilcode/util/SPUtils;->getBoolean(Ljava/lang/String;)Z

    move-result p0

    return p0
.end method

.method public static getBoolean(Ljava/lang/String;Z)Z
    .registers 3

    .line 244
    invoke-static {}, Lcom/blankj/utilcode/util/SPStaticUtils;->getDefaultSPUtils()Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/SPStaticUtils;->getBoolean(Ljava/lang/String;ZLcom/blankj/utilcode/util/SPUtils;)Z

    move-result p0

    return p0
.end method

.method public static getBoolean(Ljava/lang/String;ZLcom/blankj/utilcode/util/SPUtils;)Z
    .registers 3

    .line 607
    invoke-virtual {p2, p0, p1}, Lcom/blankj/utilcode/util/SPUtils;->getBoolean(Ljava/lang/String;Z)Z

    move-result p0

    return p0
.end method

.method private static getDefaultSPUtils()Lcom/blankj/utilcode/util/SPUtils;
    .registers 1

    .line 727
    sget-object v0, Lcom/blankj/utilcode/util/SPStaticUtils;->sDefaultSPUtils:Lcom/blankj/utilcode/util/SPUtils;

    if-eqz v0, :cond_5

    goto :goto_9

    :cond_5
    invoke-static {}, Lcom/blankj/utilcode/util/SPUtils;->getInstance()Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    :goto_9
    return-object v0
.end method

.method public static getFloat(Ljava/lang/String;)F
    .registers 2

    .line 190
    invoke-static {}, Lcom/blankj/utilcode/util/SPStaticUtils;->getDefaultSPUtils()Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/SPStaticUtils;->getFloat(Ljava/lang/String;Lcom/blankj/utilcode/util/SPUtils;)F

    move-result p0

    return p0
.end method

.method public static getFloat(Ljava/lang/String;F)F
    .registers 3

    .line 201
    invoke-static {}, Lcom/blankj/utilcode/util/SPStaticUtils;->getDefaultSPUtils()Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/SPStaticUtils;->getFloat(Ljava/lang/String;FLcom/blankj/utilcode/util/SPUtils;)F

    move-result p0

    return p0
.end method

.method public static getFloat(Ljava/lang/String;FLcom/blankj/utilcode/util/SPUtils;)F
    .registers 3

    .line 555
    invoke-virtual {p2, p0, p1}, Lcom/blankj/utilcode/util/SPUtils;->getFloat(Ljava/lang/String;F)F

    move-result p0

    return p0
.end method

.method public static getFloat(Ljava/lang/String;Lcom/blankj/utilcode/util/SPUtils;)F
    .registers 2

    .line 543
    invoke-virtual {p1, p0}, Lcom/blankj/utilcode/util/SPUtils;->getFloat(Ljava/lang/String;)F

    move-result p0

    return p0
.end method

.method public static getInt(Ljava/lang/String;)I
    .registers 2

    .line 104
    invoke-static {}, Lcom/blankj/utilcode/util/SPStaticUtils;->getDefaultSPUtils()Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/SPStaticUtils;->getInt(Ljava/lang/String;Lcom/blankj/utilcode/util/SPUtils;)I

    move-result p0

    return p0
.end method

.method public static getInt(Ljava/lang/String;I)I
    .registers 3

    .line 115
    invoke-static {}, Lcom/blankj/utilcode/util/SPStaticUtils;->getDefaultSPUtils()Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/SPStaticUtils;->getInt(Ljava/lang/String;ILcom/blankj/utilcode/util/SPUtils;)I

    move-result p0

    return p0
.end method

.method public static getInt(Ljava/lang/String;ILcom/blankj/utilcode/util/SPUtils;)I
    .registers 3

    .line 455
    invoke-virtual {p2, p0, p1}, Lcom/blankj/utilcode/util/SPUtils;->getInt(Ljava/lang/String;I)I

    move-result p0

    return p0
.end method

.method public static getInt(Ljava/lang/String;Lcom/blankj/utilcode/util/SPUtils;)I
    .registers 2

    .line 443
    invoke-virtual {p1, p0}, Lcom/blankj/utilcode/util/SPUtils;->getInt(Ljava/lang/String;)I

    move-result p0

    return p0
.end method

.method public static getLong(Ljava/lang/String;)J
    .registers 3

    .line 147
    invoke-static {}, Lcom/blankj/utilcode/util/SPStaticUtils;->getDefaultSPUtils()Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/SPStaticUtils;->getLong(Ljava/lang/String;Lcom/blankj/utilcode/util/SPUtils;)J

    move-result-wide v0

    return-wide v0
.end method

.method public static getLong(Ljava/lang/String;J)J
    .registers 4

    .line 158
    invoke-static {}, Lcom/blankj/utilcode/util/SPStaticUtils;->getDefaultSPUtils()Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/SPStaticUtils;->getLong(Ljava/lang/String;JLcom/blankj/utilcode/util/SPUtils;)J

    move-result-wide p0

    return-wide p0
.end method

.method public static getLong(Ljava/lang/String;JLcom/blankj/utilcode/util/SPUtils;)J
    .registers 4

    .line 505
    invoke-virtual {p3, p0, p1, p2}, Lcom/blankj/utilcode/util/SPUtils;->getLong(Ljava/lang/String;J)J

    move-result-wide p0

    return-wide p0
.end method

.method public static getLong(Ljava/lang/String;Lcom/blankj/utilcode/util/SPUtils;)J
    .registers 2

    .line 493
    invoke-virtual {p1, p0}, Lcom/blankj/utilcode/util/SPUtils;->getLong(Ljava/lang/String;)J

    move-result-wide p0

    return-wide p0
.end method

.method public static getString(Ljava/lang/String;)Ljava/lang/String;
    .registers 2

    .line 60
    invoke-static {}, Lcom/blankj/utilcode/util/SPStaticUtils;->getDefaultSPUtils()Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/SPStaticUtils;->getString(Ljava/lang/String;Lcom/blankj/utilcode/util/SPUtils;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getString(Ljava/lang/String;Lcom/blankj/utilcode/util/SPUtils;)Ljava/lang/String;
    .registers 2

    .line 390
    invoke-virtual {p1, p0}, Lcom/blankj/utilcode/util/SPUtils;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .registers 3

    .line 71
    invoke-static {}, Lcom/blankj/utilcode/util/SPStaticUtils;->getDefaultSPUtils()Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/SPStaticUtils;->getString(Ljava/lang/String;Ljava/lang/String;Lcom/blankj/utilcode/util/SPUtils;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getString(Ljava/lang/String;Ljava/lang/String;Lcom/blankj/utilcode/util/SPUtils;)Ljava/lang/String;
    .registers 3

    .line 404
    invoke-virtual {p2, p0, p1}, Lcom/blankj/utilcode/util/SPUtils;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getStringSet(Ljava/lang/String;)Ljava/util/Set;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 279
    invoke-static {}, Lcom/blankj/utilcode/util/SPStaticUtils;->getDefaultSPUtils()Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/SPStaticUtils;->getStringSet(Ljava/lang/String;Lcom/blankj/utilcode/util/SPUtils;)Ljava/util/Set;

    move-result-object p0

    return-object p0
.end method

.method public static getStringSet(Ljava/lang/String;Lcom/blankj/utilcode/util/SPUtils;)Ljava/util/Set;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/blankj/utilcode/util/SPUtils;",
            ")",
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 646
    invoke-virtual {p1, p0}, Lcom/blankj/utilcode/util/SPUtils;->getStringSet(Ljava/lang/String;)Ljava/util/Set;

    move-result-object p0

    return-object p0
.end method

.method public static getStringSet(Ljava/lang/String;Ljava/util/Set;)Ljava/util/Set;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 291
    invoke-static {}, Lcom/blankj/utilcode/util/SPStaticUtils;->getDefaultSPUtils()Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/SPStaticUtils;->getStringSet(Ljava/lang/String;Ljava/util/Set;Lcom/blankj/utilcode/util/SPUtils;)Ljava/util/Set;

    move-result-object p0

    return-object p0
.end method

.method public static getStringSet(Ljava/lang/String;Ljava/util/Set;Lcom/blankj/utilcode/util/SPUtils;)Ljava/util/Set;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/blankj/utilcode/util/SPUtils;",
            ")",
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 660
    invoke-virtual {p2, p0, p1}, Lcom/blankj/utilcode/util/SPUtils;->getStringSet(Ljava/lang/String;Ljava/util/Set;)Ljava/util/Set;

    move-result-object p0

    return-object p0
.end method

.method public static put(Ljava/lang/String;F)V
    .registers 3

    .line 168
    invoke-static {}, Lcom/blankj/utilcode/util/SPStaticUtils;->getDefaultSPUtils()Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/SPStaticUtils;->put(Ljava/lang/String;FLcom/blankj/utilcode/util/SPUtils;)V

    return-void
.end method

.method public static put(Ljava/lang/String;FLcom/blankj/utilcode/util/SPUtils;)V
    .registers 3

    .line 516
    invoke-virtual {p2, p0, p1}, Lcom/blankj/utilcode/util/SPUtils;->put(Ljava/lang/String;F)V

    return-void
.end method

.method public static put(Ljava/lang/String;FZ)V
    .registers 4

    .line 180
    invoke-static {}, Lcom/blankj/utilcode/util/SPStaticUtils;->getDefaultSPUtils()Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/SPStaticUtils;->put(Ljava/lang/String;FZLcom/blankj/utilcode/util/SPUtils;)V

    return-void
.end method

.method public static put(Ljava/lang/String;FZLcom/blankj/utilcode/util/SPUtils;)V
    .registers 4

    .line 532
    invoke-virtual {p3, p0, p1, p2}, Lcom/blankj/utilcode/util/SPUtils;->put(Ljava/lang/String;FZ)V

    return-void
.end method

.method public static put(Ljava/lang/String;I)V
    .registers 3

    .line 82
    invoke-static {}, Lcom/blankj/utilcode/util/SPStaticUtils;->getDefaultSPUtils()Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/SPStaticUtils;->put(Ljava/lang/String;ILcom/blankj/utilcode/util/SPUtils;)V

    return-void
.end method

.method public static put(Ljava/lang/String;ILcom/blankj/utilcode/util/SPUtils;)V
    .registers 3

    .line 416
    invoke-virtual {p2, p0, p1}, Lcom/blankj/utilcode/util/SPUtils;->put(Ljava/lang/String;I)V

    return-void
.end method

.method public static put(Ljava/lang/String;IZ)V
    .registers 4

    .line 94
    invoke-static {}, Lcom/blankj/utilcode/util/SPStaticUtils;->getDefaultSPUtils()Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/SPStaticUtils;->put(Ljava/lang/String;IZLcom/blankj/utilcode/util/SPUtils;)V

    return-void
.end method

.method public static put(Ljava/lang/String;IZLcom/blankj/utilcode/util/SPUtils;)V
    .registers 4

    .line 432
    invoke-virtual {p3, p0, p1, p2}, Lcom/blankj/utilcode/util/SPUtils;->put(Ljava/lang/String;IZ)V

    return-void
.end method

.method public static put(Ljava/lang/String;J)V
    .registers 4

    .line 125
    invoke-static {}, Lcom/blankj/utilcode/util/SPStaticUtils;->getDefaultSPUtils()Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/SPStaticUtils;->put(Ljava/lang/String;JLcom/blankj/utilcode/util/SPUtils;)V

    return-void
.end method

.method public static put(Ljava/lang/String;JLcom/blankj/utilcode/util/SPUtils;)V
    .registers 4

    .line 466
    invoke-virtual {p3, p0, p1, p2}, Lcom/blankj/utilcode/util/SPUtils;->put(Ljava/lang/String;J)V

    return-void
.end method

.method public static put(Ljava/lang/String;JZ)V
    .registers 5

    .line 137
    invoke-static {}, Lcom/blankj/utilcode/util/SPStaticUtils;->getDefaultSPUtils()Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    invoke-static {p0, p1, p2, p3, v0}, Lcom/blankj/utilcode/util/SPStaticUtils;->put(Ljava/lang/String;JZLcom/blankj/utilcode/util/SPUtils;)V

    return-void
.end method

.method public static put(Ljava/lang/String;JZLcom/blankj/utilcode/util/SPUtils;)V
    .registers 5

    .line 482
    invoke-virtual {p4, p0, p1, p2, p3}, Lcom/blankj/utilcode/util/SPUtils;->put(Ljava/lang/String;JZ)V

    return-void
.end method

.method public static put(Ljava/lang/String;Ljava/lang/String;)V
    .registers 3

    .line 37
    invoke-static {}, Lcom/blankj/utilcode/util/SPStaticUtils;->getDefaultSPUtils()Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/SPStaticUtils;->put(Ljava/lang/String;Ljava/lang/String;Lcom/blankj/utilcode/util/SPUtils;)V

    return-void
.end method

.method public static put(Ljava/lang/String;Ljava/lang/String;Lcom/blankj/utilcode/util/SPUtils;)V
    .registers 3

    .line 362
    invoke-virtual {p2, p0, p1}, Lcom/blankj/utilcode/util/SPUtils;->put(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public static put(Ljava/lang/String;Ljava/lang/String;Z)V
    .registers 4

    .line 49
    invoke-static {}, Lcom/blankj/utilcode/util/SPStaticUtils;->getDefaultSPUtils()Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/SPStaticUtils;->put(Ljava/lang/String;Ljava/lang/String;ZLcom/blankj/utilcode/util/SPUtils;)V

    return-void
.end method

.method public static put(Ljava/lang/String;Ljava/lang/String;ZLcom/blankj/utilcode/util/SPUtils;)V
    .registers 4

    .line 378
    invoke-virtual {p3, p0, p1, p2}, Lcom/blankj/utilcode/util/SPUtils;->put(Ljava/lang/String;Ljava/lang/String;Z)V

    return-void
.end method

.method public static put(Ljava/lang/String;Ljava/util/Set;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .line 254
    invoke-static {}, Lcom/blankj/utilcode/util/SPStaticUtils;->getDefaultSPUtils()Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/SPStaticUtils;->put(Ljava/lang/String;Ljava/util/Set;Lcom/blankj/utilcode/util/SPUtils;)V

    return-void
.end method

.method public static put(Ljava/lang/String;Ljava/util/Set;Lcom/blankj/utilcode/util/SPUtils;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/blankj/utilcode/util/SPUtils;",
            ")V"
        }
    .end annotation

    .line 618
    invoke-virtual {p2, p0, p1}, Lcom/blankj/utilcode/util/SPUtils;->put(Ljava/lang/String;Ljava/util/Set;)V

    return-void
.end method

.method public static put(Ljava/lang/String;Ljava/util/Set;Z)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;Z)V"
        }
    .end annotation

    .line 268
    invoke-static {}, Lcom/blankj/utilcode/util/SPStaticUtils;->getDefaultSPUtils()Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/SPStaticUtils;->put(Ljava/lang/String;Ljava/util/Set;ZLcom/blankj/utilcode/util/SPUtils;)V

    return-void
.end method

.method public static put(Ljava/lang/String;Ljava/util/Set;ZLcom/blankj/utilcode/util/SPUtils;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;Z",
            "Lcom/blankj/utilcode/util/SPUtils;",
            ")V"
        }
    .end annotation

    .line 634
    invoke-virtual {p3, p0, p1, p2}, Lcom/blankj/utilcode/util/SPUtils;->put(Ljava/lang/String;Ljava/util/Set;Z)V

    return-void
.end method

.method public static put(Ljava/lang/String;Z)V
    .registers 3

    .line 211
    invoke-static {}, Lcom/blankj/utilcode/util/SPStaticUtils;->getDefaultSPUtils()Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/SPStaticUtils;->put(Ljava/lang/String;ZLcom/blankj/utilcode/util/SPUtils;)V

    return-void
.end method

.method public static put(Ljava/lang/String;ZLcom/blankj/utilcode/util/SPUtils;)V
    .registers 3

    .line 566
    invoke-virtual {p2, p0, p1}, Lcom/blankj/utilcode/util/SPUtils;->put(Ljava/lang/String;Z)V

    return-void
.end method

.method public static put(Ljava/lang/String;ZZ)V
    .registers 4

    .line 223
    invoke-static {}, Lcom/blankj/utilcode/util/SPStaticUtils;->getDefaultSPUtils()Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/SPStaticUtils;->put(Ljava/lang/String;ZZLcom/blankj/utilcode/util/SPUtils;)V

    return-void
.end method

.method public static put(Ljava/lang/String;ZZLcom/blankj/utilcode/util/SPUtils;)V
    .registers 4

    .line 582
    invoke-virtual {p3, p0, p1, p2}, Lcom/blankj/utilcode/util/SPUtils;->put(Ljava/lang/String;ZZ)V

    return-void
.end method

.method public static remove(Ljava/lang/String;)V
    .registers 2

    .line 319
    invoke-static {}, Lcom/blankj/utilcode/util/SPStaticUtils;->getDefaultSPUtils()Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/SPStaticUtils;->remove(Ljava/lang/String;Lcom/blankj/utilcode/util/SPUtils;)V

    return-void
.end method

.method public static remove(Ljava/lang/String;Lcom/blankj/utilcode/util/SPUtils;)V
    .registers 2

    .line 691
    invoke-virtual {p1, p0}, Lcom/blankj/utilcode/util/SPUtils;->remove(Ljava/lang/String;)V

    return-void
.end method

.method public static remove(Ljava/lang/String;Z)V
    .registers 3

    .line 330
    invoke-static {}, Lcom/blankj/utilcode/util/SPStaticUtils;->getDefaultSPUtils()Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/SPStaticUtils;->remove(Ljava/lang/String;ZLcom/blankj/utilcode/util/SPUtils;)V

    return-void
.end method

.method public static remove(Ljava/lang/String;ZLcom/blankj/utilcode/util/SPUtils;)V
    .registers 3

    .line 703
    invoke-virtual {p2, p0, p1}, Lcom/blankj/utilcode/util/SPUtils;->remove(Ljava/lang/String;Z)V

    return-void
.end method

.method public static setDefaultSPUtils(Lcom/blankj/utilcode/util/SPUtils;)V
    .registers 1

    .line 27
    sput-object p0, Lcom/blankj/utilcode/util/SPStaticUtils;->sDefaultSPUtils:Lcom/blankj/utilcode/util/SPUtils;

    return-void
.end method
