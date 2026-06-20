.class public final Lcom/flydigi/sdk/waspwing/WaspWingManager$init$filter$1;
.super Ljava/lang/Object;
.source "WaspWingManager.kt"

# interfaces
.implements Lcom/flydigi/sdk/bluetooth/DeviceFilter;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/flydigi/sdk/waspwing/WaspWingManager;->init(Landroid/content/Context;Lcom/flydigi/sdk/bluetooth/DeviceFilter;Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\u0008"
    }
    d2 = {
        "com/flydigi/sdk/waspwing/WaspWingManager$init$filter$1",
        "Lcom/flydigi/sdk/bluetooth/DeviceFilter;",
        "isValidDevice",
        "",
        "deviceName",
        "",
        "rssi",
        "",
        "sdk_waspwing_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x8,
        0x0
    }
    xi = 0x30
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public isValidDevice(Ljava/lang/String;I)Z
    .registers 5

    .line 41
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "deviceName:"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",rssiDef:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcom/flydigi/sdk/waspwing/WaspWingManager;->INSTANCE:Lcom/flydigi/sdk/waspwing/WaspWingManager;

    invoke-virtual {v1}, Lcom/flydigi/sdk/waspwing/WaspWingManager;->getRssiDef()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",rssi:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "FlyBle"

    invoke-static {v1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 42
    sget-object v0, Lcom/flydigi/sdk/waspwing/WaspWingManager;->INSTANCE:Lcom/flydigi/sdk/waspwing/WaspWingManager;

    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingManager;->getRssiDef()I

    move-result v0

    const/4 v1, 0x0

    if-le p2, v0, :cond_46

    const/4 p2, 0x1

    if-eqz p1, :cond_42

    invoke-static {p1}, Lcom/flydigi/sdk/waspwing/WaspWingManagerKt;->isValid(Ljava/lang/String;)Z

    move-result p1

    if-ne p1, p2, :cond_42

    move p1, p2

    goto :goto_43

    :cond_42
    move p1, v1

    :goto_43
    if-eqz p1, :cond_46

    move v1, p2

    :cond_46
    return v1
.end method
