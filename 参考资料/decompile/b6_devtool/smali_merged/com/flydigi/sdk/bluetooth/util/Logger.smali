.class public final Lcom/flydigi/sdk/bluetooth/util/Logger;
.super Ljava/lang/Object;
.source "Logger.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0003\n\u0002\u0008\u0003\u0008\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0007J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0007J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\u0008\"\u0004\u0008\r\u0010\n\u00a8\u0006\u0016"
    }
    d2 = {
        "Lcom/flydigi/sdk/bluetooth/util/Logger;",
        "",
        "()V",
        "TAG",
        "",
        "inDebugMode",
        "",
        "getInDebugMode",
        "()Z",
        "setInDebugMode",
        "(Z)V",
        "logRawData",
        "getLogRawData",
        "setLogRawData",
        "logd",
        "",
        "message",
        "loge",
        "throwable",
        "",
        "logi",
        "logw",
        "bluetooth_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x8,
        0x0
    }
    xi = 0x30
.end annotation


# static fields
.field public static final INSTANCE:Lcom/flydigi/sdk/bluetooth/util/Logger;

.field private static final TAG:Ljava/lang/String; = "FlyBle"

.field private static inDebugMode:Z

.field private static logRawData:Z


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lcom/flydigi/sdk/bluetooth/util/Logger;

    invoke-direct {v0}, Lcom/flydigi/sdk/bluetooth/util/Logger;-><init>()V

    sput-object v0, Lcom/flydigi/sdk/bluetooth/util/Logger;->INSTANCE:Lcom/flydigi/sdk/bluetooth/util/Logger;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static final logFile(Ljava/lang/String;Ljava/lang/String;)V
    .registers 7
    .annotation runtime Lkotlin/jvm/JvmStatic;
    .end annotation

    :try_start_0
    new-instance v2, Ljava/io/FileOutputStream;
    const-string v3, "/data/data/com.example.extool/files/飞智散热器开发者工具.log"
    const/4 v4, 0x1
    invoke-direct {v2, v3, v4}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;Z)V

    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V
    const-string v4, "["
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    const-string v4, "] "
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    const-string v4, "\n"
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual {v5}, Ljava/lang/String;->getBytes()[B
    move-result-object v4
    invoke-virtual {v2, v4}, Ljava/io/FileOutputStream;->write([B)V
    invoke-virtual {v2}, Ljava/io/FileOutputStream;->close()V

    const-string v2, "FlyLog"
    invoke-static {v2, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :catch_0
    return-void
.end method

.method public static final logd(Ljava/lang/String;)V
    .registers 2
    .annotation runtime Lkotlin/jvm/JvmStatic;
    .end annotation

    const-string v0, "message"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 17
    sget-boolean v0, Lcom/flydigi/sdk/bluetooth/util/Logger;->inDebugMode:Z

    if-eqz v0, :cond_e

    const-string v0, "FlyBle"

    .line 18
    invoke-static {v0, p0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_e
    return-void
.end method

.method public static final loge(Ljava/lang/Throwable;)V
    .registers 2
    .annotation runtime Lkotlin/jvm/JvmStatic;
    .end annotation

    const-string v0, "throwable"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 38
    sget-boolean v0, Lcom/flydigi/sdk/bluetooth/util/Logger;->inDebugMode:Z

    if-eqz v0, :cond_14

    .line 39
    invoke-virtual {p0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object p0

    if-eqz p0, :cond_14

    const-string v0, "FlyBle"

    .line 40
    invoke-static {v0, p0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    :cond_14
    return-void
.end method

.method public static final logi(Ljava/lang/String;)V
    .registers 2
    .annotation runtime Lkotlin/jvm/JvmStatic;
    .end annotation

    const-string v0, "message"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 24
    sget-boolean v0, Lcom/flydigi/sdk/bluetooth/util/Logger;->inDebugMode:Z

    if-eqz v0, :cond_e

    const-string v0, "FlyBle"

    .line 25
    invoke-static {v0, p0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    :cond_e
    return-void
.end method

.method public static final logw(Ljava/lang/String;)V
    .registers 2
    .annotation runtime Lkotlin/jvm/JvmStatic;
    .end annotation

    const-string v0, "message"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 31
    sget-boolean v0, Lcom/flydigi/sdk/bluetooth/util/Logger;->inDebugMode:Z

    if-eqz v0, :cond_e

    const-string v0, "FlyBle"

    .line 32
    invoke-static {v0, p0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    :cond_e
    return-void
.end method


# virtual methods
.method public final getInDebugMode()Z
    .registers 2

    .line 12
    sget-boolean v0, Lcom/flydigi/sdk/bluetooth/util/Logger;->inDebugMode:Z

    return v0
.end method

.method public final getLogRawData()Z
    .registers 2

    .line 13
    sget-boolean v0, Lcom/flydigi/sdk/bluetooth/util/Logger;->logRawData:Z

    return v0
.end method

.method public final setInDebugMode(Z)V
    .registers 2

    .line 12
    sput-boolean p1, Lcom/flydigi/sdk/bluetooth/util/Logger;->inDebugMode:Z

    return-void
.end method

.method public final setLogRawData(Z)V
    .registers 2

    .line 13
    sput-boolean p1, Lcom/flydigi/sdk/bluetooth/util/Logger;->logRawData:Z

    return-void
.end method
