.class public final Lcom/example/extool/WaspWingViewModel;
.super Lcom/example/extool/BluetoothViewModel;
.source "WaspWingViewModel.kt"

# interfaces
.implements Lcom/flydigi/sdk/waspwing/WaspWingGattCallback;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/example/extool/WaspWingViewModel$Companion;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0002\u0008\u0008\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0008\u0010\u000f\u001a\u00020\u000cH\u0016J\u0006\u0010\u0010\u001a\u00020\u000cJ\u0006\u0010\u0011\u001a\u00020\u000cJ\u0006\u0010\u0012\u001a\u00020\u000cJ\u000e\u0010\u0013\u001a\u00020\u000c2\u0006\u0010\u0014\u001a\u00020\u0015J\u0012\u0010\u0016\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u000c2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0008\u0010\u0018\u001a\u00020\u000cH\u0016J\u0008\u0010\u0019\u001a\u00020\u000cH\u0016J\u000e\u0010\u001a\u001a\u00020\u000c2\u0006\u0010\u001b\u001a\u00020\u0015J\u0006\u0010\u001c\u001a\u00020\u000cJ\u0006\u0010\u001d\u001a\u00020\u000cJ\u0006\u0010\u001e\u001a\u00020\u000cJ\u000e\u0010\u001f\u001a\u00020\u000c2\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010 \u001a\u00020\u000c2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0015J\u0016\u0010$\u001a\u00020\u000c2\u0006\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u0015J\u0016\u0010\'\u001a\u00020\u000c2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0015J\u0016\u0010(\u001a\u00020\u000c2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0015R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0008\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n\u00a8\u0006*"
    }
    d2 = {
        "Lcom/example/extool/WaspWingViewModel;",
        "Lcom/example/extool/BluetoothViewModel;",
        "Lcom/flydigi/sdk/waspwing/WaspWingGattCallback;",
        "()V",
        "_waspWingInfo",
        "Landroidx/lifecycle/MutableLiveData;",
        "Lcom/flydigi/sdk/waspwing/WaspWingInfo;",
        "waspWingInfo",
        "Landroidx/lifecycle/LiveData;",
        "getWaspWingInfo",
        "()Landroidx/lifecycle/LiveData;",
        "connect",
        "",
        "device",
        "Landroid/bluetooth/BluetoothDevice;",
        "disconnect",
        "downColdPwm",
        "downTargetTemperature",
        "downWindPwm",
        "enableExperimentalMode",
        "enabled",
        "",
        "onDeviceDisconnected",
        "onDeviceInfoUpdate",
        "scan",
        "stopScan",
        "switchLed",
        "state",
        "upColdPwm",
        "upTargetTemperature",
        "upWindPwm",
        "update",
        "updateColdPwm",
        "value",
        "",
        "fromUser",
        "updateDefaultMode",
        "checkedId",
        "isChecked",
        "updateDefaultTemperature",
        "updateWindPwm",
        "Companion",
        "exTool_release"
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
.field public static final COLD_ADJUST_MAX:I = 0xe5

.field public static final COLD_ADJUST_MIN:I = 0x0

.field public static final Companion:Lcom/example/extool/WaspWingViewModel$Companion;

.field public static final TEMPERATURE_ADJUST_MAX:I = 0x23

.field public static final TEMPERATURE_ADJUST_MIN:I = 0x5

.field public static final WIND_ADJUST_MAX:I = 0x1770

.field public static final WIND_ADJUST_MIN:I = 0x7d0


# instance fields
.field private final _waspWingInfo:Landroidx/lifecycle/MutableLiveData;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/lifecycle/MutableLiveData<",
            "Lcom/flydigi/sdk/waspwing/WaspWingInfo;",
            ">;"
        }
    .end annotation
.end field

.field private final waspWingInfo:Landroidx/lifecycle/LiveData;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/lifecycle/LiveData<",
            "Lcom/flydigi/sdk/waspwing/WaspWingInfo;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 2

    new-instance v0, Lcom/example/extool/WaspWingViewModel$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/example/extool/WaspWingViewModel$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lcom/example/extool/WaspWingViewModel;->Companion:Lcom/example/extool/WaspWingViewModel$Companion;

    return-void
.end method

.method public constructor <init>()V
    .registers 2

    .line 14
    invoke-direct {p0}, Lcom/example/extool/BluetoothViewModel;-><init>()V

    .line 15
    new-instance v0, Landroidx/lifecycle/MutableLiveData;

    invoke-direct {v0}, Landroidx/lifecycle/MutableLiveData;-><init>()V

    iput-object v0, p0, Lcom/example/extool/WaspWingViewModel;->_waspWingInfo:Landroidx/lifecycle/MutableLiveData;

    .line 16
    check-cast v0, Landroidx/lifecycle/LiveData;

    iput-object v0, p0, Lcom/example/extool/WaspWingViewModel;->waspWingInfo:Landroidx/lifecycle/LiveData;

    .line 173
    invoke-static {p0}, Lcom/flydigi/sdk/waspwing/WaspWingManager;->register(Ljava/lang/Object;)V

    return-void
.end method


# virtual methods
.method public connect(Landroid/bluetooth/BluetoothDevice;)V
    .registers 3

    const-string v0, "device"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 188
    invoke-static {p1}, Lcom/flydigi/sdk/waspwing/WaspWingManager;->connectGattWith(Landroid/bluetooth/BluetoothDevice;)V

    return-void
.end method

.method public disconnect()V
    .registers 1

    .line 192
    invoke-static {}, Lcom/flydigi/sdk/waspwing/WaspWingManager;->disconnect()V

    return-void
.end method

.method public final downColdPwm()V
    .registers 13

    .line 140
    iget-object v0, p0, Lcom/example/extool/WaspWingViewModel;->waspWingInfo:Landroidx/lifecycle/LiveData;

    invoke-virtual {v0}, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    if-eqz v0, :cond_2b

    .line 141
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getRealColdLevel()I

    move-result v1

    if-gtz v1, :cond_11

    return-void

    .line 144
    :cond_11
    sget-object v2, Lcom/flydigi/sdk/waspwing/WaspWingManager;->INSTANCE:Lcom/flydigi/sdk/waspwing/WaspWingManager;

    .line 145
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getRunMode()I

    move-result v3

    .line 146
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getTargetTemperature()I

    move-result v4

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    .line 147
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getRealColdLevel()I

    move-result v0

    add-int/lit8 v8, v0, -0x1

    const/4 v9, 0x0

    const/16 v10, 0x5c

    const/4 v11, 0x0

    .line 144
    invoke-static/range {v2 .. v11}, Lcom/flydigi/sdk/waspwing/WaspWingManager;->setRunMode$default(Lcom/flydigi/sdk/waspwing/WaspWingManager;IIIIIIIILjava/lang/Object;)V

    :cond_2b
    return-void
.end method

.method public final downTargetTemperature()V
    .registers 14

    .line 57
    iget-object v0, p0, Lcom/example/extool/WaspWingViewModel;->waspWingInfo:Landroidx/lifecycle/LiveData;

    invoke-virtual {v0}, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    if-eqz v0, :cond_26

    .line 58
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getTargetTemperature()I

    move-result v1

    const/4 v2, 0x5

    if-gt v1, v2, :cond_12

    return-void

    .line 61
    :cond_12
    sget-object v3, Lcom/flydigi/sdk/waspwing/WaspWingManager;->INSTANCE:Lcom/flydigi/sdk/waspwing/WaspWingManager;

    const/4 v4, 0x0

    .line 63
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getTargetTemperature()I

    move-result v0

    add-int/lit8 v5, v0, -0x1

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/16 v11, 0x7c

    const/4 v12, 0x0

    .line 61
    invoke-static/range {v3 .. v12}, Lcom/flydigi/sdk/waspwing/WaspWingManager;->setRunMode$default(Lcom/flydigi/sdk/waspwing/WaspWingManager;IIIIIIIILjava/lang/Object;)V

    :cond_26
    return-void
.end method

.method public final downWindPwm()V
    .registers 14

    .line 112
    iget-object v0, p0, Lcom/example/extool/WaspWingViewModel;->waspWingInfo:Landroidx/lifecycle/LiveData;

    invoke-virtual {v0}, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    if-eqz v0, :cond_2d

    .line 113
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getRealWindLevel()I

    move-result v1

    const/16 v2, 0x7d0

    if-gt v1, v2, :cond_13

    return-void

    .line 116
    :cond_13
    sget-object v3, Lcom/flydigi/sdk/waspwing/WaspWingManager;->INSTANCE:Lcom/flydigi/sdk/waspwing/WaspWingManager;

    .line 117
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getRunMode()I

    move-result v4

    .line 118
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getTargetTemperature()I

    move-result v5

    const/4 v6, 0x0

    const/4 v7, 0x0

    .line 119
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getRealWindLevel()I

    move-result v0

    add-int/lit8 v8, v0, -0x1

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/16 v11, 0x6c

    const/4 v12, 0x0

    .line 116
    invoke-static/range {v3 .. v12}, Lcom/flydigi/sdk/waspwing/WaspWingManager;->setRunMode$default(Lcom/flydigi/sdk/waspwing/WaspWingManager;IIIIIIIILjava/lang/Object;)V

    :cond_2d
    return-void
.end method

.method public final enableExperimentalMode(Z)V
    .registers 9

    .line 167
    iget-object v0, p0, Lcom/example/extool/WaspWingViewModel;->waspWingInfo:Landroidx/lifecycle/LiveData;

    invoke-virtual {v0}, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    if-eqz v0, :cond_1d

    .line 168
    sget-object v1, Lcom/flydigi/sdk/waspwing/WaspWingManager;->INSTANCE:Lcom/flydigi/sdk/waspwing/WaspWingManager;

    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getRealColdLevel()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x4

    const/4 v6, 0x0

    move v2, p1

    invoke-static/range {v1 .. v6}, Lcom/flydigi/sdk/waspwing/WaspWingManager;->setExperimentalRunMode$default(Lcom/flydigi/sdk/waspwing/WaspWingManager;ZLjava/lang/Integer;Ljava/lang/Integer;ILjava/lang/Object;)V

    :cond_1d
    return-void
.end method

.method public final getWaspWingInfo()Landroidx/lifecycle/LiveData;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroidx/lifecycle/LiveData<",
            "Lcom/flydigi/sdk/waspwing/WaspWingInfo;",
            ">;"
        }
    .end annotation

    .line 16
    iget-object v0, p0, Lcom/example/extool/WaspWingViewModel;->waspWingInfo:Landroidx/lifecycle/LiveData;

    return-object v0
.end method

.method public onDeviceDisconnected(Landroid/bluetooth/BluetoothDevice;)V
    .registers 36

    .line 203
    invoke-super/range {p0 .. p1}, Lcom/example/extool/BluetoothViewModel;->onDeviceDisconnected(Landroid/bluetooth/BluetoothDevice;)V

    move-object/from16 v0, p0

    .line 204
    iget-object v1, v0, Lcom/example/extool/WaspWingViewModel;->_waspWingInfo:Landroidx/lifecycle/MutableLiveData;

    invoke-virtual {v1}, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;

    move-result-object v2

    move-object v3, v2

    check-cast v3, Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    if-eqz v3, :cond_46

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

    const/16 v31, 0x0

    const v32, 0xffffffb

    const/16 v33, 0x0

    invoke-static/range {v3 .. v33}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->copy$default(Lcom/flydigi/sdk/waspwing/WaspWingInfo;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZIIIIIIZIIIIIIBLcom/flydigi/sdk/waspwing/LedData;ZZ[BLjava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Integer;ILjava/lang/Object;)Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    move-result-object v2

    goto :goto_47

    :cond_46
    const/4 v2, 0x0

    :goto_47
    invoke-virtual {v1, v2}, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V

    return-void
.end method

.method public onDeviceInfoUpdate(Lcom/flydigi/sdk/waspwing/WaspWingInfo;)V
    .registers 10

    const-string v0, "waspWingInfo"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 196
    iget-object v0, p0, Lcom/example/extool/WaspWingViewModel;->_waspWingInfo:Landroidx/lifecycle/MutableLiveData;

    invoke-virtual {v0, p1}, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V

    .line 197
    invoke-virtual {p1}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getExperimentalRunModeValue()Ljava/lang/Integer;

    move-result-object v0

    if-nez v0, :cond_11

    goto :goto_17

    :cond_11
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-eqz v0, :cond_3d

    :goto_17
    invoke-virtual {p1}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getExperimentalRunModeValue()Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p1}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getRealColdLevel()I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    if-nez v0, :cond_24

    goto :goto_2a

    :cond_24
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-eq v0, v1, :cond_3d

    .line 198
    :goto_2a
    sget-object v2, Lcom/flydigi/sdk/waspwing/WaspWingManager;->INSTANCE:Lcom/flydigi/sdk/waspwing/WaspWingManager;

    const/4 v3, 0x1

    invoke-virtual {p1}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getRealColdLevel()I

    move-result p1

    add-int/lit8 p1, p1, 0x1

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    const/4 v5, 0x0

    const/4 v6, 0x4

    const/4 v7, 0x0

    invoke-static/range {v2 .. v7}, Lcom/flydigi/sdk/waspwing/WaspWingManager;->setExperimentalRunMode$default(Lcom/flydigi/sdk/waspwing/WaspWingManager;ZLjava/lang/Integer;Ljava/lang/Integer;ILjava/lang/Object;)V

    :cond_3d
    return-void
.end method

.method public onGattConnectFailed(Landroid/bluetooth/BluetoothDevice;)V
    .registers 2

    .line 14
    invoke-static {p0, p1}, Lcom/flydigi/sdk/waspwing/WaspWingGattCallback$DefaultImpls;->onGattConnectFailed(Lcom/flydigi/sdk/waspwing/WaspWingGattCallback;Landroid/bluetooth/BluetoothDevice;)V

    return-void
.end method

.method public onGattConnectTimeout(Landroid/bluetooth/BluetoothDevice;)V
    .registers 2

    .line 14
    invoke-static {p0, p1}, Lcom/flydigi/sdk/waspwing/WaspWingGattCallback$DefaultImpls;->onGattConnectTimeout(Lcom/flydigi/sdk/waspwing/WaspWingGattCallback;Landroid/bluetooth/BluetoothDevice;)V

    return-void
.end method

.method public onGattConnected(Landroid/bluetooth/BluetoothDevice;)V
    .registers 2

    .line 14
    invoke-static {p0, p1}, Lcom/flydigi/sdk/waspwing/WaspWingGattCallback$DefaultImpls;->onGattConnected(Lcom/flydigi/sdk/waspwing/WaspWingGattCallback;Landroid/bluetooth/BluetoothDevice;)V

    return-void
.end method

.method public onGattConnecting(Landroid/bluetooth/BluetoothDevice;)V
    .registers 2

    .line 14
    invoke-static {p0, p1}, Lcom/flydigi/sdk/waspwing/WaspWingGattCallback$DefaultImpls;->onGattConnecting(Lcom/flydigi/sdk/waspwing/WaspWingGattCallback;Landroid/bluetooth/BluetoothDevice;)V

    return-void
.end method

.method public onGattDisconnected(Landroid/bluetooth/BluetoothGatt;)V
    .registers 2

    .line 14
    invoke-static {p0, p1}, Lcom/flydigi/sdk/waspwing/WaspWingGattCallback$DefaultImpls;->onGattDisconnected(Lcom/flydigi/sdk/waspwing/WaspWingGattCallback;Landroid/bluetooth/BluetoothGatt;)V

    return-void
.end method

.method public onReadRemoteRssi(I)V
    .registers 2

    .line 14
    invoke-static {p0, p1}, Lcom/flydigi/sdk/waspwing/WaspWingGattCallback$DefaultImpls;->onReadRemoteRssi(Lcom/flydigi/sdk/waspwing/WaspWingGattCallback;I)V

    return-void
.end method

.method public onTempHistoryUpdate([B)V
    .registers 2

    .line 14
    invoke-static {p0, p1}, Lcom/flydigi/sdk/waspwing/WaspWingGattCallback$DefaultImpls;->onTempHistoryUpdate(Lcom/flydigi/sdk/waspwing/WaspWingGattCallback;[B)V

    return-void
.end method

.method public scan()V
    .registers 3

    .line 178
    invoke-static {}, Lcom/blankj/utilcode/util/ActivityUtils;->getTopActivity()Landroid/app/Activity;

    move-result-object v0

    const-string v1, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Landroidx/fragment/app/FragmentActivity;

    const/4 v1, 0x2

    .line 177
    invoke-static {v0, v1}, Lcom/flydigi/sdk/waspwing/WaspWingManager;->startScan(Landroidx/fragment/app/FragmentActivity;I)V

    return-void
.end method

.method public stopScan()V
    .registers 1

    .line 184
    invoke-static {}, Lcom/flydigi/sdk/waspwing/WaspWingManager;->stopScan()V

    return-void
.end method

.method public final switchLed(Z)V
    .registers 2

    if-eqz p1, :cond_8

    .line 33
    sget-object p1, Lcom/flydigi/sdk/waspwing/WaspWingManager;->INSTANCE:Lcom/flydigi/sdk/waspwing/WaspWingManager;

    invoke-virtual {p1}, Lcom/flydigi/sdk/waspwing/WaspWingManager;->setLightOn()V

    goto :goto_d

    .line 35
    :cond_8
    sget-object p1, Lcom/flydigi/sdk/waspwing/WaspWingManager;->INSTANCE:Lcom/flydigi/sdk/waspwing/WaspWingManager;

    invoke-virtual {p1}, Lcom/flydigi/sdk/waspwing/WaspWingManager;->setLightOff()V

    :goto_d
    return-void
.end method

.method public final upColdPwm()V
    .registers 14

    .line 153
    iget-object v0, p0, Lcom/example/extool/WaspWingViewModel;->waspWingInfo:Landroidx/lifecycle/LiveData;

    invoke-virtual {v0}, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    if-eqz v0, :cond_2d

    .line 154
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getRealColdLevel()I

    move-result v1

    const/16 v2, 0xe5

    if-lt v1, v2, :cond_13

    return-void

    .line 157
    :cond_13
    sget-object v3, Lcom/flydigi/sdk/waspwing/WaspWingManager;->INSTANCE:Lcom/flydigi/sdk/waspwing/WaspWingManager;

    .line 158
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getRunMode()I

    move-result v4

    .line 159
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getTargetTemperature()I

    move-result v5

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    .line 160
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getRealColdLevel()I

    move-result v0

    add-int/lit8 v9, v0, 0x1

    const/4 v10, 0x0

    const/16 v11, 0x5c

    const/4 v12, 0x0

    .line 157
    invoke-static/range {v3 .. v12}, Lcom/flydigi/sdk/waspwing/WaspWingManager;->setRunMode$default(Lcom/flydigi/sdk/waspwing/WaspWingManager;IIIIIIIILjava/lang/Object;)V

    :cond_2d
    return-void
.end method

.method public final upTargetTemperature()V
    .registers 14

    .line 70
    iget-object v0, p0, Lcom/example/extool/WaspWingViewModel;->waspWingInfo:Landroidx/lifecycle/LiveData;

    invoke-virtual {v0}, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    if-eqz v0, :cond_27

    .line 71
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getTargetTemperature()I

    move-result v1

    const/16 v2, 0x23

    if-lt v1, v2, :cond_13

    return-void

    .line 74
    :cond_13
    sget-object v3, Lcom/flydigi/sdk/waspwing/WaspWingManager;->INSTANCE:Lcom/flydigi/sdk/waspwing/WaspWingManager;

    const/4 v4, 0x0

    .line 76
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getTargetTemperature()I

    move-result v0

    add-int/lit8 v5, v0, 0x1

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/16 v11, 0x7c

    const/4 v12, 0x0

    .line 74
    invoke-static/range {v3 .. v12}, Lcom/flydigi/sdk/waspwing/WaspWingManager;->setRunMode$default(Lcom/flydigi/sdk/waspwing/WaspWingManager;IIIIIIIILjava/lang/Object;)V

    :cond_27
    return-void
.end method

.method public final upWindPwm()V
    .registers 14

    .line 126
    iget-object v0, p0, Lcom/example/extool/WaspWingViewModel;->waspWingInfo:Landroidx/lifecycle/LiveData;

    invoke-virtual {v0}, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    if-eqz v0, :cond_2d

    .line 127
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getRealWindLevel()I

    move-result v1

    const/16 v2, 0x1770

    if-lt v1, v2, :cond_13

    return-void

    .line 130
    :cond_13
    sget-object v3, Lcom/flydigi/sdk/waspwing/WaspWingManager;->INSTANCE:Lcom/flydigi/sdk/waspwing/WaspWingManager;

    .line 131
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getRunMode()I

    move-result v4

    .line 132
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getTargetTemperature()I

    move-result v5

    const/4 v6, 0x0

    const/4 v7, 0x0

    .line 133
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getRealWindLevel()I

    move-result v0

    add-int/lit8 v8, v0, 0x1

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/16 v11, 0x6c

    const/4 v12, 0x0

    .line 130
    invoke-static/range {v3 .. v12}, Lcom/flydigi/sdk/waspwing/WaspWingManager;->setRunMode$default(Lcom/flydigi/sdk/waspwing/WaspWingManager;IIIIIIIILjava/lang/Object;)V

    :cond_2d
    return-void
.end method

.method public final update(Lcom/flydigi/sdk/waspwing/WaspWingInfo;)V
    .registers 3

    const-string v0, "waspWingInfo"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 28
    iget-object v0, p0, Lcom/example/extool/WaspWingViewModel;->_waspWingInfo:Landroidx/lifecycle/MutableLiveData;

    invoke-virtual {v0, p1}, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V

    return-void
.end method

.method public final updateColdPwm(IZ)V
    .registers 13

    if-nez p2, :cond_3

    return-void

    .line 100
    :cond_3
    iget-object p2, p0, Lcom/example/extool/WaspWingViewModel;->waspWingInfo:Landroidx/lifecycle/LiveData;

    invoke-virtual {p2}, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    if-eqz p2, :cond_22

    .line 102
    sget-object v0, Lcom/flydigi/sdk/waspwing/WaspWingManager;->INSTANCE:Lcom/flydigi/sdk/waspwing/WaspWingManager;

    .line 103
    invoke-virtual {p2}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getRunMode()I

    move-result v1

    .line 104
    invoke-virtual {p2}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getTargetTemperature()I

    move-result v2

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v7, 0x0

    const/16 v8, 0x5c

    const/4 v9, 0x0

    move v6, p1

    .line 102
    invoke-static/range {v0 .. v9}, Lcom/flydigi/sdk/waspwing/WaspWingManager;->setRunMode$default(Lcom/flydigi/sdk/waspwing/WaspWingManager;IIIIIIIILjava/lang/Object;)V

    :cond_22
    return-void
.end method

.method public final updateDefaultMode(IZ)V
    .registers 13

    if-eqz p2, :cond_2a

    const p2, 0x7f080161

    if-ne p2, p1, :cond_9

    const/4 p1, 0x0

    goto :goto_a

    :cond_9
    const/4 p1, 0x2

    :goto_a
    move v1, p1

    .line 44
    sget-object v0, Lcom/flydigi/sdk/waspwing/WaspWingManager;->INSTANCE:Lcom/flydigi/sdk/waspwing/WaspWingManager;

    .line 46
    iget-object p1, p0, Lcom/example/extool/WaspWingViewModel;->waspWingInfo:Landroidx/lifecycle/LiveData;

    invoke-virtual {p1}, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    if-eqz p1, :cond_1c

    invoke-virtual {p1}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getTargetTemperature()I

    move-result p1

    goto :goto_1e

    :cond_1c
    const/16 p1, 0xa

    :goto_1e
    move v2, p1

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/16 v8, 0x7c

    const/4 v9, 0x0

    .line 44
    invoke-static/range {v0 .. v9}, Lcom/flydigi/sdk/waspwing/WaspWingManager;->setRunMode$default(Lcom/flydigi/sdk/waspwing/WaspWingManager;IIIIIIIILjava/lang/Object;)V

    :cond_2a
    return-void
.end method

.method public final updateDefaultTemperature(IZ)V
    .registers 13

    if-nez p2, :cond_3

    return-void

    .line 53
    :cond_3
    sget-object v0, Lcom/flydigi/sdk/waspwing/WaspWingManager;->INSTANCE:Lcom/flydigi/sdk/waspwing/WaspWingManager;

    const/4 v1, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/16 v8, 0x7c

    const/4 v9, 0x0

    move v2, p1

    invoke-static/range {v0 .. v9}, Lcom/flydigi/sdk/waspwing/WaspWingManager;->setRunMode$default(Lcom/flydigi/sdk/waspwing/WaspWingManager;IIIIIIIILjava/lang/Object;)V

    return-void
.end method

.method public final updateWindPwm(IZ)V
    .registers 13

    if-nez p2, :cond_3

    return-void

    .line 84
    :cond_3
    iget-object p2, p0, Lcom/example/extool/WaspWingViewModel;->waspWingInfo:Landroidx/lifecycle/LiveData;

    invoke-virtual {p2}, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    if-eqz p2, :cond_22

    .line 86
    sget-object v0, Lcom/flydigi/sdk/waspwing/WaspWingManager;->INSTANCE:Lcom/flydigi/sdk/waspwing/WaspWingManager;

    .line 87
    invoke-virtual {p2}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getRunMode()I

    move-result v1

    .line 88
    invoke-virtual {p2}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getTargetTemperature()I

    move-result v2

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/16 v8, 0x6c

    const/4 v9, 0x0

    move v5, p1

    .line 86
    invoke-static/range {v0 .. v9}, Lcom/flydigi/sdk/waspwing/WaspWingManager;->setRunMode$default(Lcom/flydigi/sdk/waspwing/WaspWingManager;IIIIIIIILjava/lang/Object;)V

    :cond_22
    return-void
.end method
