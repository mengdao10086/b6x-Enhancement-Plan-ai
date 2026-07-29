.class public final Lcom/blankj/utilcode/util/CloseUtils;
.super Ljava/lang/Object;
.source "CloseUtils.java"


# direct methods
.method private constructor <init>()V
    .registers 3

    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "u can\'t instantiate me..."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static varargs closeIO([Ljava/io/Closeable;)V
    .registers 4

    if-nez p0, :cond_3

    return-void

    .line 27
    :cond_3
    array-length v0, p0

    const/4 v1, 0x0

    :goto_5
    if-ge v1, v0, :cond_16

    aget-object v2, p0, v1

    if-eqz v2, :cond_13

    .line 30
    :try_start_b
    invoke-interface {v2}, Ljava/io/Closeable;->close()V
    :try_end_e
    .catch Ljava/io/IOException; {:try_start_b .. :try_end_e} :catch_f

    goto :goto_13

    :catch_f
    move-exception v2

    .line 32
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    :cond_13
    :goto_13
    add-int/lit8 v1, v1, 0x1

    goto :goto_5

    :cond_16
    return-void
.end method

.method public static varargs closeIOQuietly([Ljava/io/Closeable;)V
    .registers 4

    if-nez p0, :cond_3

    return-void

    .line 45
    :cond_3
    array-length v0, p0

    const/4 v1, 0x0

    :goto_5
    if-ge v1, v0, :cond_11

    aget-object v2, p0, v1

    if-eqz v2, :cond_e

    .line 48
    :try_start_b
    invoke-interface {v2}, Ljava/io/Closeable;->close()V
    :try_end_e
    .catch Ljava/io/IOException; {:try_start_b .. :try_end_e} :catch_e

    :catch_e
    :cond_e
    add-int/lit8 v1, v1, 0x1

    goto :goto_5

    :cond_11
    return-void
.end method
