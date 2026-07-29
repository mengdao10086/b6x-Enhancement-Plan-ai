.class public final Lcom/flydigi/sdk/waspwing/WaspwingViewModel;
.super Landroidx/lifecycle/ViewModel;
.source "WaspwingViewModel.kt"

# interfaces
.implements Lcom/flydigi/sdk/waspwing/WaspWingGattCallback;
.implements Lcom/flydigi/sdk/bluetooth/ConnectionStateCallback;


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0012\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eR\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00070\n\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0017\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00070\n\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000c\u00a8\u0006\u001f"
    }
    d2 = {
        "Lcom/flydigi/sdk/waspwing/WaspwingViewModel;",
        "Landroidx/lifecycle/ViewModel;",
        "Lcom/flydigi/sdk/waspwing/WaspWingGattCallback;",
        "Lcom/flydigi/sdk/bluetooth/ConnectionStateCallback;",
        "()V",
        "_connectedLiveData",
        "Landroidx/lifecycle/MutableLiveData;",
        "Lcom/flydigi/sdk/waspwing/WaspWingInfo;",
        "_mWaspwingInfo",
        "mConnectedLiveData",
        "Landroidx/lifecycle/LiveData;",
        "getMConnectedLiveData",
        "()Landroidx/lifecycle/LiveData;",
        "mWaspwingInfo",
        "getMWaspwingInfo",
        "onDeviceInfoUpdate",
        "",
        "waspWingInfo",
        "onGattConnected",
        "device",
        "Landroid/bluetooth/BluetoothDevice;",
        "onGattDisconnected",
        "gatt",
        "Landroid/bluetooth/BluetoothGatt;",
        "onTempHistoryUpdate",
        "tempHistory",
        "",
        "updateDeviceInfo",
        "updateManualMode",
        "value",
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


# instance fields
.field private final _connectedLiveData:Landroidx/lifecycle/MutableLiveData;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/lifecycle/MutableLiveData<",
            "Lcom/flydigi/sdk/waspwing/WaspWingInfo;",
            ">;"
        }
    .end annotation
.end field

.field private final _mWaspwingInfo:Landroidx/lifecycle/MutableLiveData;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/lifecycle/MutableLiveData<",
            "Lcom/flydigi/sdk/waspwing/WaspWingInfo;",
            ">;"
        }
    .end annotation
.end field

.field private final mConnectedLiveData:Landroidx/lifecycle/LiveData;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/lifecycle/LiveData<",
            "Lcom/flydigi/sdk/waspwing/WaspWingInfo;",
            ">;"
        }
    .end annotation
.end field

.field private final mWaspwingInfo:Landroidx/lifecycle/LiveData;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/lifecycle/LiveData<",
            "Lcom/flydigi/sdk/waspwing/WaspWingInfo;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .registers 2

    .line 14
    invoke-direct {p0}, Landroidx/lifecycle/ViewModel;-><init>()V

    .line 16
    new-instance v0, Landroidx/lifecycle/MutableLiveData;

    invoke-direct {v0}, Landroidx/lifecycle/MutableLiveData;-><init>()V

    iput-object v0, p0, Lcom/flydigi/sdk/waspwing/WaspwingViewModel;->_mWaspwingInfo:Landroidx/lifecycle/MutableLiveData;

    .line 17
    check-cast v0, Landroidx/lifecycle/LiveData;

    iput-object v0, p0, Lcom/flydigi/sdk/waspwing/WaspwingViewModel;->mWaspwingInfo:Landroidx/lifecycle/LiveData;

    .line 19
    new-instance v0, Landroidx/lifecycle/MutableLiveData;

    invoke-direct {v0}, Landroidx/lifecycle/MutableLiveData;-><init>()V

    iput-object v0, p0, Lcom/flydigi/sdk/waspwing/WaspwingViewModel;->_connectedLiveData:Landroidx/lifecycle/MutableLiveData;

    .line 20
    check-cast v0, Landroidx/lifecycle/LiveData;

    iput-object v0, p0, Lcom/flydigi/sdk/waspwing/WaspwingViewModel;->mConnectedLiveData:Landroidx/lifecycle/LiveData;

    .line 23
    invoke-static {p0}, Lcom/flydigi/sdk/waspwing/WaspWingManager;->register(Ljava/lang/Object;)V

    return-void
.end method


# virtual methods
.method public final getMConnectedLiveData()Landroidx/lifecycle/LiveData;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroidx/lifecycle/LiveData<",
            "Lcom/flydigi/sdk/waspwing/WaspWingInfo;",
            ">;"
        }
    .end annotation

    .line 20
    iget-object v0, p0, Lcom/flydigi/sdk/waspwing/WaspwingViewModel;->mConnectedLiveData:Landroidx/lifecycle/LiveData;

    return-object v0
.end method

.method public final getMWaspwingInfo()Landroidx/lifecycle/LiveData;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroidx/lifecycle/LiveData<",
            "Lcom/flydigi/sdk/waspwing/WaspWingInfo;",
            ">;"
        }
    .end annotation

    .line 17
    iget-object v0, p0, Lcom/flydigi/sdk/waspwing/WaspwingViewModel;->mWaspwingInfo:Landroidx/lifecycle/LiveData;

    return-object v0
.end method

.method public onDeviceConnected(Landroid/bluetooth/BluetoothDevice;)V
    .registers 2

    .line 14
    invoke-static {p0, p1}, Lcom/flydigi/sdk/bluetooth/ConnectionStateCallback$DefaultImpls;->onDeviceConnected(Lcom/flydigi/sdk/bluetooth/ConnectionStateCallback;Landroid/bluetooth/BluetoothDevice;)V

    return-void
.end method

.method public onDeviceDisconnected(Landroid/bluetooth/BluetoothDevice;)V
    .registers 2

    .line 14
    invoke-static {p0, p1}, Lcom/flydigi/sdk/bluetooth/ConnectionStateCallback$DefaultImpls;->onDeviceDisconnected(Lcom/flydigi/sdk/bluetooth/ConnectionStateCallback;Landroid/bluetooth/BluetoothDevice;)V

    return-void
.end method

.method public onDeviceInfoUpdate(Lcom/flydigi/sdk/waspwing/WaspWingInfo;)V
    .registers 3

    const-string v0, "waspWingInfo"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 27
    invoke-virtual {p0, p1}, Lcom/flydigi/sdk/waspwing/WaspwingViewModel;->updateDeviceInfo(Lcom/flydigi/sdk/waspwing/WaspWingInfo;)V

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
    .registers 37

    const-string v0, "device"

    move-object/from16 v1, p1

    invoke-static {v1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 41
    invoke-static/range {p0 .. p1}, Lcom/flydigi/sdk/waspwing/WaspWingGattCallback$DefaultImpls;->onGattConnected(Lcom/flydigi/sdk/waspwing/WaspWingGattCallback;Landroid/bluetooth/BluetoothDevice;)V

    move-object/from16 v0, p0

    .line 42
    iget-object v2, v0, Lcom/flydigi/sdk/waspwing/WaspwingViewModel;->_connectedLiveData:Landroidx/lifecycle/MutableLiveData;

    .line 43
    new-instance v15, Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    move-object v3, v15

    .line 44
    invoke-virtual/range {p1 .. p1}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v4

    .line 45
    invoke-virtual/range {p1 .. p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x1

    .line 47
    sget-object v7, Lcom/flydigi/sdk/waspwing/DeviceCode;->INSTANCE:Lcom/flydigi/sdk/waspwing/DeviceCode;

    invoke-virtual/range {p1 .. p1}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v7, v1}, Lcom/flydigi/sdk/waspwing/DeviceCode;->getDeviceCodeFromBtName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    const/4 v13, 0x0

    const/4 v14, 0x0

    const/4 v1, 0x0

    move-object/from16 v34, v15

    move v15, v1

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

    const v32, 0xffffff0

    const/16 v33, 0x0

    .line 43
    invoke-direct/range {v3 .. v33}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;-><init>(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZIIIIIIZIIIIIIBLcom/flydigi/sdk/waspwing/LedData;ZZ[BLjava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Integer;ILkotlin/jvm/internal/DefaultConstructorMarker;)V

    move-object/from16 v1, v34

    .line 42
    invoke-virtual {v2, v1}, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V

    return-void
.end method

.method public onGattConnecting(Landroid/bluetooth/BluetoothDevice;)V
    .registers 2

    .line 14
    invoke-static {p0, p1}, Lcom/flydigi/sdk/waspwing/WaspWingGattCallback$DefaultImpls;->onGattConnecting(Lcom/flydigi/sdk/waspwing/WaspWingGattCallback;Landroid/bluetooth/BluetoothDevice;)V

    return-void
.end method

.method public onGattDisconnected(Landroid/bluetooth/BluetoothGatt;)V
    .registers 67

    move-object/from16 v0, p0

    const-string v1, "gatt"

    move-object/from16 v2, p1

    invoke-static {v2, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 53
    invoke-static/range {p0 .. p1}, Lcom/flydigi/sdk/waspwing/WaspWingGattCallback$DefaultImpls;->onGattDisconnected(Lcom/flydigi/sdk/waspwing/WaspWingGattCallback;Landroid/bluetooth/BluetoothGatt;)V

    .line 54
    iget-object v1, v0, Lcom/flydigi/sdk/waspwing/WaspwingViewModel;->_mWaspwingInfo:Landroidx/lifecycle/MutableLiveData;

    invoke-virtual {v1}, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;

    move-result-object v1

    move-object v3, v1

    check-cast v3, Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    if-eqz v3, :cond_ac

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

    const v32, 0xfffffff

    const/16 v33, 0x0

    invoke-static/range {v3 .. v33}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->copy$default(Lcom/flydigi/sdk/waspwing/WaspWingInfo;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZIIIIIIZIIIIIIBLcom/flydigi/sdk/waspwing/LedData;ZZ[BLjava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Integer;ILjava/lang/Object;)Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    move-result-object v1

    if-eqz v1, :cond_ac

    .line 55
    invoke-virtual/range {p1 .. p1}, Landroid/bluetooth/BluetoothGatt;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v2

    invoke-virtual {v2}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getAddress()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroidx/core/util/ObjectsCompat;->equals(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_ac

    const/4 v2, 0x0

    .line 56
    invoke-virtual {v1, v2}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->setConnected(Z)V

    .line 57
    iget-object v2, v0, Lcom/flydigi/sdk/waspwing/WaspwingViewModel;->_mWaspwingInfo:Landroidx/lifecycle/MutableLiveData;

    const/16 v35, 0x0

    const/16 v36, 0x0

    const/16 v37, 0x0

    const/16 v38, 0x0

    const/16 v39, 0x0

    const/16 v40, 0x0

    const/16 v41, 0x0

    const/16 v42, 0x0

    const/16 v43, 0x0

    const/16 v44, 0x0

    const/16 v45, 0x0

    const/16 v46, 0x0

    const/16 v47, 0x0

    const/16 v48, 0x0

    const/16 v49, 0x0

    const/16 v50, 0x0

    const/16 v51, 0x0

    const/16 v52, 0x0

    const/16 v53, 0x0

    const/16 v54, 0x0

    const/16 v55, 0x0

    const/16 v56, 0x0

    const/16 v57, 0x0

    const/16 v58, 0x0

    const/16 v59, 0x0

    const/16 v60, 0x0

    const/16 v61, 0x0

    const/16 v62, 0x0

    const v63, 0xfffffff

    const/16 v64, 0x0

    move-object/from16 v34, v1

    invoke-static/range {v34 .. v64}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->copy$default(Lcom/flydigi/sdk/waspwing/WaspWingInfo;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZIIIIIIZIIIIIIBLcom/flydigi/sdk/waspwing/LedData;ZZ[BLjava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Integer;ILjava/lang/Object;)Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    move-result-object v1

    invoke-virtual {v2, v1}, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V

    :cond_ac
    return-void
.end method

.method public onReadRemoteRssi(I)V
    .registers 2

    .line 14
    invoke-static {p0, p1}, Lcom/flydigi/sdk/waspwing/WaspWingGattCallback$DefaultImpls;->onReadRemoteRssi(Lcom/flydigi/sdk/waspwing/WaspWingGattCallback;I)V

    return-void
.end method

.method public onTempHistoryUpdate([B)V
    .registers 3

    const-string v0, "tempHistory"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 37
    invoke-static {p0, p1}, Lcom/flydigi/sdk/waspwing/WaspWingGattCallback$DefaultImpls;->onTempHistoryUpdate(Lcom/flydigi/sdk/waspwing/WaspWingGattCallback;[B)V

    return-void
.end method

.method public final updateDeviceInfo(Lcom/flydigi/sdk/waspwing/WaspWingInfo;)V
    .registers 35

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    const-string v2, "waspWingInfo"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 31
    iget-object v2, v0, Lcom/flydigi/sdk/waspwing/WaspwingViewModel;->_mWaspwingInfo:Landroidx/lifecycle/MutableLiveData;

    invoke-virtual {v2}, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;

    move-result-object v2

    invoke-static {v2, v1}, Landroidx/core/util/ObjectsCompat;->equals(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_54

    .line 32
    iget-object v15, v0, Lcom/flydigi/sdk/waspwing/WaspwingViewModel;->_mWaspwingInfo:Landroidx/lifecycle/MutableLiveData;

    const/4 v2, 0x0

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

    const/16 v16, 0x0

    move-object/from16 v32, v15

    move/from16 v15, v16

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

    const v30, 0xfffffff

    const/16 v31, 0x0

    move-object/from16 v1, p1

    invoke-static/range {v1 .. v31}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->copy$default(Lcom/flydigi/sdk/waspwing/WaspWingInfo;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZIIIIIIZIIIIIIBLcom/flydigi/sdk/waspwing/LedData;ZZ[BLjava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Integer;ILjava/lang/Object;)Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    move-result-object v1

    move-object/from16 v2, v32

    invoke-virtual {v2, v1}, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V

    :cond_54
    return-void
.end method

.method public final updateManualMode(F)V
    .registers 35

    move-object/from16 v0, p0

    .line 63
    iget-object v1, v0, Lcom/flydigi/sdk/waspwing/WaspwingViewModel;->_mWaspwingInfo:Landroidx/lifecycle/MutableLiveData;

    invoke-virtual {v1}, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;

    move-result-object v1

    move-object v2, v1

    check-cast v2, Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    if-eqz v2, :cond_a2

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

    invoke-static/range {v2 .. v32}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->copy$default(Lcom/flydigi/sdk/waspwing/WaspWingInfo;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZIIIIIIZIIIIIIBLcom/flydigi/sdk/waspwing/LedData;ZZ[BLjava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Integer;ILjava/lang/Object;)Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    move-result-object v1

    if-eqz v1, :cond_a2

    const/4 v2, 0x0

    cmpg-float v2, p1, v2

    const/4 v3, 0x1

    const/4 v4, 0x0

    if-nez v2, :cond_4c

    move v2, v3

    goto :goto_4d

    :cond_4c
    move v2, v4

    :goto_4d
    if-eqz v2, :cond_64

    .line 65
    sget-object v5, Lcom/flydigi/sdk/waspwing/WaspWingManager;->INSTANCE:Lcom/flydigi/sdk/waspwing/WaspWingManager;

    const/4 v6, 0x1

    invoke-virtual {v1}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getTargetTemperature()I

    move-result v7

    const/16 v8, 0xfa0

    const/16 v9, 0x7d

    const/4 v10, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    const/16 v13, 0x70

    const/4 v14, 0x0

    invoke-static/range {v5 .. v14}, Lcom/flydigi/sdk/waspwing/WaspWingManager;->setRunMode$default(Lcom/flydigi/sdk/waspwing/WaspWingManager;IIIIIIIILjava/lang/Object;)V

    goto :goto_a2

    :cond_64
    const/high16 v2, 0x3f800000    # 1.0f

    cmpg-float v2, p1, v2

    if-nez v2, :cond_6c

    move v2, v3

    goto :goto_6d

    :cond_6c
    move v2, v4

    :goto_6d
    if-eqz v2, :cond_84

    .line 66
    sget-object v5, Lcom/flydigi/sdk/waspwing/WaspWingManager;->INSTANCE:Lcom/flydigi/sdk/waspwing/WaspWingManager;

    const/4 v6, 0x1

    invoke-virtual {v1}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getTargetTemperature()I

    move-result v7

    const/16 v8, 0x1194

    const/16 v9, 0x7d

    const/4 v10, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    const/16 v13, 0x70

    const/4 v14, 0x0

    invoke-static/range {v5 .. v14}, Lcom/flydigi/sdk/waspwing/WaspWingManager;->setRunMode$default(Lcom/flydigi/sdk/waspwing/WaspWingManager;IIIIIIIILjava/lang/Object;)V

    goto :goto_a2

    :cond_84
    const/high16 v2, 0x40000000    # 2.0f

    cmpg-float v2, p1, v2

    if-nez v2, :cond_8b

    goto :goto_8c

    :cond_8b
    move v3, v4

    :goto_8c
    if-eqz v3, :cond_a2

    .line 67
    sget-object v4, Lcom/flydigi/sdk/waspwing/WaspWingManager;->INSTANCE:Lcom/flydigi/sdk/waspwing/WaspWingManager;

    const/4 v5, 0x2

    .line 69
    invoke-virtual {v1}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getTargetTemperature()I

    move-result v6

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/16 v9, 0x157c

    const/16 v10, 0xb2

    const/4 v11, 0x0

    const/16 v12, 0x4c

    const/4 v13, 0x0

    .line 67
    invoke-static/range {v4 .. v13}, Lcom/flydigi/sdk/waspwing/WaspWingManager;->setRunMode$default(Lcom/flydigi/sdk/waspwing/WaspWingManager;IIIIIIIILjava/lang/Object;)V

    :cond_a2
    :goto_a2
    return-void
.end method
