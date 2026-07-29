.class public final Lcom/blankj/utilcode/util/SPUtils;
.super Ljava/lang/Object;
.source "SPUtils.java"


# static fields
.field private static final SP_UTILS_MAP:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Lcom/blankj/utilcode/util/SPUtils;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private sp:Landroid/content/SharedPreferences;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .line 24
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/blankj/utilcode/util/SPUtils;->SP_UTILS_MAP:Ljava/util/Map;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;)V
    .registers 4

    .line 79
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 80
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Landroid/app/Application;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object p1

    iput-object p1, p0, Lcom/blankj/utilcode/util/SPUtils;->sp:Landroid/content/SharedPreferences;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .registers 4

    .line 83
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 84
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Landroid/app/Application;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object p1

    iput-object p1, p0, Lcom/blankj/utilcode/util/SPUtils;->sp:Landroid/content/SharedPreferences;

    return-void
.end method

.method public static getInstance()Lcom/blankj/utilcode/util/SPUtils;
    .registers 2

    const-string v0, ""

    const/4 v1, 0x0

    .line 34
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/SPUtils;->getInstance(Ljava/lang/String;I)Lcom/blankj/utilcode/util/SPUtils;

    move-result-object v0

    return-object v0
.end method

.method public static getInstance(I)Lcom/blankj/utilcode/util/SPUtils;
    .registers 2

    const-string v0, ""

    .line 44
    invoke-static {v0, p0}, Lcom/blankj/utilcode/util/SPUtils;->getInstance(Ljava/lang/String;I)Lcom/blankj/utilcode/util/SPUtils;

    move-result-object p0

    return-object p0
.end method

.method public static getInstance(Ljava/lang/String;)Lcom/blankj/utilcode/util/SPUtils;
    .registers 2

    const/4 v0, 0x0

    .line 54
    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/SPUtils;->getInstance(Ljava/lang/String;I)Lcom/blankj/utilcode/util/SPUtils;

    move-result-object p0

    return-object p0
.end method

.method public static getInstance(Ljava/lang/String;I)Lcom/blankj/utilcode/util/SPUtils;
    .registers 5

    .line 65
    invoke-static {p0}, Lcom/blankj/utilcode/util/SPUtils;->isSpace(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_8

    const-string p0, "spUtils"

    .line 66
    :cond_8
    sget-object v0, Lcom/blankj/utilcode/util/SPUtils;->SP_UTILS_MAP:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/blankj/utilcode/util/SPUtils;

    if-nez v1, :cond_2a

    .line 68
    const-class v2, Lcom/blankj/utilcode/util/SPUtils;

    monitor-enter v2

    .line 69
    :try_start_15
    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/blankj/utilcode/util/SPUtils;

    if-nez v1, :cond_25

    .line 71
    new-instance v1, Lcom/blankj/utilcode/util/SPUtils;

    invoke-direct {v1, p0, p1}, Lcom/blankj/utilcode/util/SPUtils;-><init>(Ljava/lang/String;I)V

    .line 72
    invoke-interface {v0, p0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 74
    :cond_25
    monitor-exit v2

    goto :goto_2a

    :catchall_27
    move-exception p0

    monitor-exit v2
    :try_end_29
    .catchall {:try_start_15 .. :try_end_29} :catchall_27

    throw p0

    :cond_2a
    :goto_2a
    return-object v1
.end method

.method private static isSpace(Ljava/lang/String;)Z
    .registers 6

    const/4 v0, 0x1

    if-nez p0, :cond_4

    return v0

    .line 439
    :cond_4
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    const/4 v2, 0x0

    move v3, v2

    :goto_a
    if-ge v3, v1, :cond_1a

    .line 440
    invoke-virtual {p0, v3}, Ljava/lang/String;->charAt(I)C

    move-result v4

    invoke-static {v4}, Ljava/lang/Character;->isWhitespace(C)Z

    move-result v4

    if-nez v4, :cond_17

    return v2

    :cond_17
    add-int/lit8 v3, v3, 0x1

    goto :goto_a

    :cond_1a
    return v0
.end method


# virtual methods
.method public clear()V
    .registers 2

    const/4 v0, 0x0

    .line 420
    invoke-virtual {p0, v0}, Lcom/blankj/utilcode/util/SPUtils;->clear(Z)V

    return-void
.end method

.method public clear(Z)V
    .registers 2

    if-eqz p1, :cond_10

    .line 431
    iget-object p1, p0, Lcom/blankj/utilcode/util/SPUtils;->sp:Landroid/content/SharedPreferences;

    invoke-interface {p1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object p1

    invoke-interface {p1}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    move-result-object p1

    invoke-interface {p1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    goto :goto_1d

    .line 433
    :cond_10
    iget-object p1, p0, Lcom/blankj/utilcode/util/SPUtils;->sp:Landroid/content/SharedPreferences;

    invoke-interface {p1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object p1

    invoke-interface {p1}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    move-result-object p1

    invoke-interface {p1}, Landroid/content/SharedPreferences$Editor;->apply()V

    :goto_1d
    return-void
.end method

.method public contains(Ljava/lang/String;)Z
    .registers 3

    .line 389
    iget-object v0, p0, Lcom/blankj/utilcode/util/SPUtils;->sp:Landroid/content/SharedPreferences;

    invoke-interface {v0, p1}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result p1

    return p1
.end method

.method public getAll()Ljava/util/Map;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "*>;"
        }
    .end annotation

    .line 379
    iget-object v0, p0, Lcom/blankj/utilcode/util/SPUtils;->sp:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->getAll()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getBoolean(Ljava/lang/String;)Z
    .registers 3

    const/4 v0, 0x0

    .line 308
    invoke-virtual {p0, p1, v0}, Lcom/blankj/utilcode/util/SPUtils;->getBoolean(Ljava/lang/String;Z)Z

    move-result p1

    return p1
.end method

.method public getBoolean(Ljava/lang/String;Z)Z
    .registers 4

    .line 319
    iget-object v0, p0, Lcom/blankj/utilcode/util/SPUtils;->sp:Landroid/content/SharedPreferences;

    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result p1

    return p1
.end method

.method public getFloat(Ljava/lang/String;)F
    .registers 3

    const/high16 v0, -0x40800000    # -1.0f

    .line 261
    invoke-virtual {p0, p1, v0}, Lcom/blankj/utilcode/util/SPUtils;->getFloat(Ljava/lang/String;F)F

    move-result p1

    return p1
.end method

.method public getFloat(Ljava/lang/String;F)F
    .registers 4

    .line 272
    iget-object v0, p0, Lcom/blankj/utilcode/util/SPUtils;->sp:Landroid/content/SharedPreferences;

    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences;->getFloat(Ljava/lang/String;F)F

    move-result p1

    return p1
.end method

.method public getInt(Ljava/lang/String;)I
    .registers 3

    const/4 v0, -0x1

    .line 167
    invoke-virtual {p0, p1, v0}, Lcom/blankj/utilcode/util/SPUtils;->getInt(Ljava/lang/String;I)I

    move-result p1

    return p1
.end method

.method public getInt(Ljava/lang/String;I)I
    .registers 4

    .line 178
    iget-object v0, p0, Lcom/blankj/utilcode/util/SPUtils;->sp:Landroid/content/SharedPreferences;

    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result p1

    return p1
.end method

.method public getLong(Ljava/lang/String;)J
    .registers 4

    const-wide/16 v0, -0x1

    .line 214
    invoke-virtual {p0, p1, v0, v1}, Lcom/blankj/utilcode/util/SPUtils;->getLong(Ljava/lang/String;J)J

    move-result-wide v0

    return-wide v0
.end method

.method public getLong(Ljava/lang/String;J)J
    .registers 5

    .line 225
    iget-object v0, p0, Lcom/blankj/utilcode/util/SPUtils;->sp:Landroid/content/SharedPreferences;

    invoke-interface {v0, p1, p2, p3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide p1

    return-wide p1
.end method

.method public getString(Ljava/lang/String;)Ljava/lang/String;
    .registers 3

    const-string v0, ""

    .line 120
    invoke-virtual {p0, p1, v0}, Lcom/blankj/utilcode/util/SPUtils;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    return-object p1
.end method

.method public getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .registers 4

    .line 131
    iget-object v0, p0, Lcom/blankj/utilcode/util/SPUtils;->sp:Landroid/content/SharedPreferences;

    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    return-object p1
.end method

.method public getStringSet(Ljava/lang/String;)Ljava/util/Set;
    .registers 3
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

    .line 358
    invoke-static {}, Ljava/util/Collections;->emptySet()Ljava/util/Set;

    move-result-object v0

    invoke-virtual {p0, p1, v0}, Lcom/blankj/utilcode/util/SPUtils;->getStringSet(Ljava/lang/String;Ljava/util/Set;)Ljava/util/Set;

    move-result-object p1

    return-object p1
.end method

.method public getStringSet(Ljava/lang/String;Ljava/util/Set;)Ljava/util/Set;
    .registers 4
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

    .line 370
    iget-object v0, p0, Lcom/blankj/utilcode/util/SPUtils;->sp:Landroid/content/SharedPreferences;

    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences;->getStringSet(Ljava/lang/String;Ljava/util/Set;)Ljava/util/Set;

    move-result-object p1

    return-object p1
.end method

.method public put(Ljava/lang/String;F)V
    .registers 4

    const/4 v0, 0x0

    .line 235
    invoke-virtual {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/SPUtils;->put(Ljava/lang/String;FZ)V

    return-void
.end method

.method public put(Ljava/lang/String;FZ)V
    .registers 4

    if-eqz p3, :cond_10

    .line 248
    iget-object p3, p0, Lcom/blankj/utilcode/util/SPUtils;->sp:Landroid/content/SharedPreferences;

    invoke-interface {p3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object p3

    invoke-interface {p3, p1, p2}, Landroid/content/SharedPreferences$Editor;->putFloat(Ljava/lang/String;F)Landroid/content/SharedPreferences$Editor;

    move-result-object p1

    invoke-interface {p1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    goto :goto_1d

    .line 250
    :cond_10
    iget-object p3, p0, Lcom/blankj/utilcode/util/SPUtils;->sp:Landroid/content/SharedPreferences;

    invoke-interface {p3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object p3

    invoke-interface {p3, p1, p2}, Landroid/content/SharedPreferences$Editor;->putFloat(Ljava/lang/String;F)Landroid/content/SharedPreferences$Editor;

    move-result-object p1

    invoke-interface {p1}, Landroid/content/SharedPreferences$Editor;->apply()V

    :goto_1d
    return-void
.end method

.method public put(Ljava/lang/String;I)V
    .registers 4

    const/4 v0, 0x0

    .line 141
    invoke-virtual {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/SPUtils;->put(Ljava/lang/String;IZ)V

    return-void
.end method

.method public put(Ljava/lang/String;IZ)V
    .registers 4

    if-eqz p3, :cond_10

    .line 154
    iget-object p3, p0, Lcom/blankj/utilcode/util/SPUtils;->sp:Landroid/content/SharedPreferences;

    invoke-interface {p3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object p3

    invoke-interface {p3, p1, p2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object p1

    invoke-interface {p1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    goto :goto_1d

    .line 156
    :cond_10
    iget-object p3, p0, Lcom/blankj/utilcode/util/SPUtils;->sp:Landroid/content/SharedPreferences;

    invoke-interface {p3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object p3

    invoke-interface {p3, p1, p2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object p1

    invoke-interface {p1}, Landroid/content/SharedPreferences$Editor;->apply()V

    :goto_1d
    return-void
.end method

.method public put(Ljava/lang/String;J)V
    .registers 5

    const/4 v0, 0x0

    .line 188
    invoke-virtual {p0, p1, p2, p3, v0}, Lcom/blankj/utilcode/util/SPUtils;->put(Ljava/lang/String;JZ)V

    return-void
.end method

.method public put(Ljava/lang/String;JZ)V
    .registers 5

    if-eqz p4, :cond_10

    .line 201
    iget-object p4, p0, Lcom/blankj/utilcode/util/SPUtils;->sp:Landroid/content/SharedPreferences;

    invoke-interface {p4}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object p4

    invoke-interface {p4, p1, p2, p3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object p1

    invoke-interface {p1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    goto :goto_1d

    .line 203
    :cond_10
    iget-object p4, p0, Lcom/blankj/utilcode/util/SPUtils;->sp:Landroid/content/SharedPreferences;

    invoke-interface {p4}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object p4

    invoke-interface {p4, p1, p2, p3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object p1

    invoke-interface {p1}, Landroid/content/SharedPreferences$Editor;->apply()V

    :goto_1d
    return-void
.end method

.method public put(Ljava/lang/String;Ljava/lang/String;)V
    .registers 4

    const/4 v0, 0x0

    .line 94
    invoke-virtual {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/SPUtils;->put(Ljava/lang/String;Ljava/lang/String;Z)V

    return-void
.end method

.method public put(Ljava/lang/String;Ljava/lang/String;Z)V
    .registers 4

    if-eqz p3, :cond_10

    .line 107
    iget-object p3, p0, Lcom/blankj/utilcode/util/SPUtils;->sp:Landroid/content/SharedPreferences;

    invoke-interface {p3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object p3

    invoke-interface {p3, p1, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object p1

    invoke-interface {p1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    goto :goto_1d

    .line 109
    :cond_10
    iget-object p3, p0, Lcom/blankj/utilcode/util/SPUtils;->sp:Landroid/content/SharedPreferences;

    invoke-interface {p3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object p3

    invoke-interface {p3, p1, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object p1

    invoke-interface {p1}, Landroid/content/SharedPreferences$Editor;->apply()V

    :goto_1d
    return-void
.end method

.method public put(Ljava/lang/String;Ljava/util/Set;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    const/4 v0, 0x0

    .line 329
    invoke-virtual {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/SPUtils;->put(Ljava/lang/String;Ljava/util/Set;Z)V

    return-void
.end method

.method public put(Ljava/lang/String;Ljava/util/Set;Z)V
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

    if-eqz p3, :cond_10

    .line 344
    iget-object p3, p0, Lcom/blankj/utilcode/util/SPUtils;->sp:Landroid/content/SharedPreferences;

    invoke-interface {p3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object p3

    invoke-interface {p3, p1, p2}, Landroid/content/SharedPreferences$Editor;->putStringSet(Ljava/lang/String;Ljava/util/Set;)Landroid/content/SharedPreferences$Editor;

    move-result-object p1

    invoke-interface {p1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    goto :goto_1d

    .line 346
    :cond_10
    iget-object p3, p0, Lcom/blankj/utilcode/util/SPUtils;->sp:Landroid/content/SharedPreferences;

    invoke-interface {p3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object p3

    invoke-interface {p3, p1, p2}, Landroid/content/SharedPreferences$Editor;->putStringSet(Ljava/lang/String;Ljava/util/Set;)Landroid/content/SharedPreferences$Editor;

    move-result-object p1

    invoke-interface {p1}, Landroid/content/SharedPreferences$Editor;->apply()V

    :goto_1d
    return-void
.end method

.method public put(Ljava/lang/String;Z)V
    .registers 4

    const/4 v0, 0x0

    .line 282
    invoke-virtual {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/SPUtils;->put(Ljava/lang/String;ZZ)V

    return-void
.end method

.method public put(Ljava/lang/String;ZZ)V
    .registers 4

    if-eqz p3, :cond_10

    .line 295
    iget-object p3, p0, Lcom/blankj/utilcode/util/SPUtils;->sp:Landroid/content/SharedPreferences;

    invoke-interface {p3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object p3

    invoke-interface {p3, p1, p2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object p1

    invoke-interface {p1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    goto :goto_1d

    .line 297
    :cond_10
    iget-object p3, p0, Lcom/blankj/utilcode/util/SPUtils;->sp:Landroid/content/SharedPreferences;

    invoke-interface {p3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object p3

    invoke-interface {p3, p1, p2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object p1

    invoke-interface {p1}, Landroid/content/SharedPreferences$Editor;->apply()V

    :goto_1d
    return-void
.end method

.method public remove(Ljava/lang/String;)V
    .registers 3

    const/4 v0, 0x0

    .line 398
    invoke-virtual {p0, p1, v0}, Lcom/blankj/utilcode/util/SPUtils;->remove(Ljava/lang/String;Z)V

    return-void
.end method

.method public remove(Ljava/lang/String;Z)V
    .registers 3

    if-eqz p2, :cond_10

    .line 410
    iget-object p2, p0, Lcom/blankj/utilcode/util/SPUtils;->sp:Landroid/content/SharedPreferences;

    invoke-interface {p2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object p2

    invoke-interface {p2, p1}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object p1

    invoke-interface {p1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    goto :goto_1d

    .line 412
    :cond_10
    iget-object p2, p0, Lcom/blankj/utilcode/util/SPUtils;->sp:Landroid/content/SharedPreferences;

    invoke-interface {p2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object p2

    invoke-interface {p2, p1}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object p1

    invoke-interface {p1}, Landroid/content/SharedPreferences$Editor;->apply()V

    :goto_1d
    return-void
.end method
