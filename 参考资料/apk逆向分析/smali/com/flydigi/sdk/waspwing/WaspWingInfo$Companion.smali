.class public final Lcom/flydigi/sdk/waspwing/WaspWingInfo$Companion;
.super Ljava/lang/Object;
.source "WaspWingInfo.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/flydigi/sdk/waspwing/WaspWingInfo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Companion"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"
    }
    d2 = {
        "Lcom/flydigi/sdk/waspwing/WaspWingInfo$Companion;",
        "",
        "()V",
        "DEFAULT_COLD_LEVEL",
        "",
        "DEFAULT_COLD_LEVEL_OVERCLOCK_MAX",
        "DEFAULT_COLD_LEVEL_OVERCLOCK_MIDDLE",
        "DEFAULT_COLD_LEVEL_OVERCLOCK_MIN",
        "DEFAULT_WIND_LEVEL_MAX",
        "DEFAULT_WIND_LEVEL_MIDDLE",
        "DEFAULT_WIND_LEVEL_MIN",
        "DEFAULT_WIND_LEVEL_OVERCLOCK_MAX",
        "DEFAULT_WIND_LEVEL_OVERCLOCK_MIDDLE",
        "DEFAULT_WIND_LEVEL_OVERCLOCK_MIN",
        "EXPERIMENTAL_RUN_MODE_COLD_LEVEL",
        "EXPERIMENTAL_RUN_MODE_WIND_LEVEL",
        "LED_OFF",
        "LED_ON",
        "SPEED_MAX",
        "SPEED_MAX_B5",
        "SPEED_MIN_B3",
        "SPEED_MIN_B5",
        "TEMPERATURE_MIDDLE",
        "TEMPERATURE_MIN",
        "WIND_LEVEL_MAX",
        "WIND_LEVEL_MIN",
        "convertFromDevice",
        "Lcom/flydigi/sdk/waspwing/WaspWingInfo;",
        "bluetoothDevice",
        "Landroid/bluetooth/BluetoothDevice;",
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
.method private constructor <init>()V
    .registers 1

    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    .registers 2

    invoke-direct {p0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo$Companion;-><init>()V

    return-void
.end method


# virtual methods
.method public final convertFromDevice(Landroid/bluetooth/BluetoothDevice;)Lcom/flydigi/sdk/waspwing/WaspWingInfo;
    .registers 35
    .annotation runtime Lkotlin/jvm/JvmStatic;
    .end annotation

    const-string v0, "bluetoothDevice"

    move-object/from16 v1, p1

    invoke-static {v1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 46
    new-instance v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    move-object v2, v0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    const/4 v13, 0x0

    const/4 v14, 0x0

    const/4 v15, 0x0

    const/16 v16, 0x0

    const/16 v17, 0x0

    const/16 v18, 0x0

    const/16 v19, 0x0

    const/16 v20, 0x0

    const/16 v21, 0x0

    const/16 v22, 0x0

    const/16 v23, 0x0

    const/16 v24, 0x0

    const/16 v25, 0x0

    const/16 v26, 0x0

    const/16 v27, 0x0

    const/16 v28, 0x0

    const/16 v29, 0x0

    const/16 v30, 0x0

    const v31, 0xfffffff

    const/16 v32, 0x0

    invoke-direct/range {v2 .. v32}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;-><init>(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZIIIIIIZIIIIIIBLcom/flydigi/sdk/waspwing/LedData;ZZ[BLjava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Integer;ILkotlin/jvm/internal/DefaultConstructorMarker;)V

    const/4 v2, 0x1

    .line 47
    invoke-virtual {v0, v2}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->setConnected(Z)V

    .line 48
    invoke-virtual/range {p1 .. p1}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->setDeviceName(Ljava/lang/String;)V

    .line 49
    invoke-virtual/range {p1 .. p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->setAddress(Ljava/lang/String;)V

    .line 50
    sget-object v2, Lcom/flydigi/sdk/waspwing/DeviceCode;->INSTANCE:Lcom/flydigi/sdk/waspwing/DeviceCode;

    invoke-virtual/range {p1 .. p1}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Lcom/flydigi/sdk/waspwing/DeviceCode;->getDeviceCodeFromBtName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->setDeviceCode(Ljava/lang/String;)V

    return-object v0
.end method
