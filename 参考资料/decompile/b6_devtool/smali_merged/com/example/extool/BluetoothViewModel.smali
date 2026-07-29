.class public abstract Lcom/example/extool/BluetoothViewModel;
.super Landroidx/lifecycle/ViewModel;
.source "BluetoothViewModel.kt"

# interfaces
.implements Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;
.implements Lcom/flydigi/sdk/bluetooth/ConnectionStateCallback;
.implements Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nBluetoothViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BluetoothViewModel.kt\ncom/example/extool/BluetoothViewModel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,100:1\n1#2:101\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH&J\u0008\u0010\u001f\u001a\u00020\u001cH&J\u0008\u0010 \u001a\u00020\u001cH\u0016J\u0008\u0010!\u001a\u00020\u001cH\u0016J\u0008\u0010\"\u001a\u00020\u001cH\u0016J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u000fH\u0016J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\nH\u0016J\u0012\u0010\'\u001a\u00020\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010(\u001a\u00020\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0016\u0010)\u001a\u00020\u001c2\u000c\u0010*\u001a\u0008\u0012\u0004\u0012\u00020,0+H\u0016J\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u000fH\u0016J\u0008\u0010/\u001a\u00020\u001cH\u0016J\u0008\u00100\u001a\u00020\u001cH\u0016J\u0008\u00101\u001a\u00020\u001cH&J\u0008\u00102\u001a\u00020\u001cH&J\u0006\u00103\u001a\u00020\u001cR\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0007X\u0084\u0004\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0007X\u0084\u0004\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000cR\u0017\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0012\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0012\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0014R\u0017\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0012\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0014R\u0017\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0012\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0014\u00a8\u00064"
    }
    d2 = {
        "Lcom/example/extool/BluetoothViewModel;",
        "Landroidx/lifecycle/ViewModel;",
        "Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;",
        "Lcom/flydigi/sdk/bluetooth/ConnectionStateCallback;",
        "Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;",
        "()V",
        "_bluetoothNameLiveData",
        "Landroidx/lifecycle/MutableLiveData;",
        "",
        "_connectLiveData",
        "",
        "get_connectLiveData",
        "()Landroidx/lifecycle/MutableLiveData;",
        "_macLiveData",
        "_scanFailedLiveData",
        "",
        "get_scanFailedLiveData",
        "bluetoothNameLiveData",
        "Landroidx/lifecycle/LiveData;",
        "getBluetoothNameLiveData",
        "()Landroidx/lifecycle/LiveData;",
        "connectLiveData",
        "getConnectLiveData",
        "macLiveData",
        "getMacLiveData",
        "scanFailedLiveData",
        "getScanFailedLiveData",
        "connect",
        "",
        "device",
        "Landroid/bluetooth/BluetoothDevice;",
        "disconnect",
        "onBluetoothNotSupported",
        "onBluetoothOpenDeny",
        "onBluetoothOpenFailed",
        "onBluetoothProfileOpened",
        "profile",
        "onBluetoothState",
        "enabled",
        "onDeviceConnected",
        "onDeviceDisconnected",
        "onDeviceFound",
        "devices",
        "",
        "Lcom/flydigi/sdk/bluetooth/data/BleDevice;",
        "onScanFailed",
        "errorCode",
        "onScanStarted",
        "onScanStopped",
        "scan",
        "stopScan",
        "tryConnect",
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


# instance fields
.field private final _bluetoothNameLiveData:Landroidx/lifecycle/MutableLiveData;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/lifecycle/MutableLiveData<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final _connectLiveData:Landroidx/lifecycle/MutableLiveData;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/lifecycle/MutableLiveData<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field private final _macLiveData:Landroidx/lifecycle/MutableLiveData;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/lifecycle/MutableLiveData<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final _scanFailedLiveData:Landroidx/lifecycle/MutableLiveData;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/lifecycle/MutableLiveData<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private final bluetoothNameLiveData:Landroidx/lifecycle/LiveData;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/lifecycle/LiveData<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final connectLiveData:Landroidx/lifecycle/LiveData;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/lifecycle/LiveData<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field private final macLiveData:Landroidx/lifecycle/LiveData;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/lifecycle/LiveData<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final scanFailedLiveData:Landroidx/lifecycle/LiveData;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/lifecycle/LiveData<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .registers 2

    .line 12
    invoke-direct {p0}, Landroidx/lifecycle/ViewModel;-><init>()V

    .line 15
    new-instance v0, Landroidx/lifecycle/MutableLiveData;

    invoke-direct {v0}, Landroidx/lifecycle/MutableLiveData;-><init>()V

    iput-object v0, p0, Lcom/example/extool/BluetoothViewModel;->_bluetoothNameLiveData:Landroidx/lifecycle/MutableLiveData;

    .line 16
    check-cast v0, Landroidx/lifecycle/LiveData;

    iput-object v0, p0, Lcom/example/extool/BluetoothViewModel;->bluetoothNameLiveData:Landroidx/lifecycle/LiveData;

    .line 18
    new-instance v0, Landroidx/lifecycle/MutableLiveData;

    invoke-direct {v0}, Landroidx/lifecycle/MutableLiveData;-><init>()V

    iput-object v0, p0, Lcom/example/extool/BluetoothViewModel;->_macLiveData:Landroidx/lifecycle/MutableLiveData;

    .line 19
    check-cast v0, Landroidx/lifecycle/LiveData;

    iput-object v0, p0, Lcom/example/extool/BluetoothViewModel;->macLiveData:Landroidx/lifecycle/LiveData;

    .line 21
    new-instance v0, Landroidx/lifecycle/MutableLiveData;

    invoke-direct {v0}, Landroidx/lifecycle/MutableLiveData;-><init>()V

    iput-object v0, p0, Lcom/example/extool/BluetoothViewModel;->_connectLiveData:Landroidx/lifecycle/MutableLiveData;

    .line 22
    check-cast v0, Landroidx/lifecycle/LiveData;

    iput-object v0, p0, Lcom/example/extool/BluetoothViewModel;->connectLiveData:Landroidx/lifecycle/LiveData;

    .line 24
    new-instance v0, Landroidx/lifecycle/MutableLiveData;

    invoke-direct {v0}, Landroidx/lifecycle/MutableLiveData;-><init>()V

    iput-object v0, p0, Lcom/example/extool/BluetoothViewModel;->_scanFailedLiveData:Landroidx/lifecycle/MutableLiveData;

    .line 25
    check-cast v0, Landroidx/lifecycle/LiveData;

    iput-object v0, p0, Lcom/example/extool/BluetoothViewModel;->scanFailedLiveData:Landroidx/lifecycle/LiveData;

    return-void
.end method


# virtual methods
.method public abstract connect(Landroid/bluetooth/BluetoothDevice;)V
.end method

.method public abstract disconnect()V
.end method

.method public final getBluetoothNameLiveData()Landroidx/lifecycle/LiveData;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroidx/lifecycle/LiveData<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 16
    iget-object v0, p0, Lcom/example/extool/BluetoothViewModel;->bluetoothNameLiveData:Landroidx/lifecycle/LiveData;

    return-object v0
.end method

.method public final getConnectLiveData()Landroidx/lifecycle/LiveData;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroidx/lifecycle/LiveData<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation

    .line 22
    iget-object v0, p0, Lcom/example/extool/BluetoothViewModel;->connectLiveData:Landroidx/lifecycle/LiveData;

    return-object v0
.end method

.method public final getMacLiveData()Landroidx/lifecycle/LiveData;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroidx/lifecycle/LiveData<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 19
    iget-object v0, p0, Lcom/example/extool/BluetoothViewModel;->macLiveData:Landroidx/lifecycle/LiveData;

    return-object v0
.end method

.method public final getScanFailedLiveData()Landroidx/lifecycle/LiveData;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroidx/lifecycle/LiveData<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .line 25
    iget-object v0, p0, Lcom/example/extool/BluetoothViewModel;->scanFailedLiveData:Landroidx/lifecycle/LiveData;

    return-object v0
.end method

.method protected final get_connectLiveData()Landroidx/lifecycle/MutableLiveData;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroidx/lifecycle/MutableLiveData<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation

    .line 21
    iget-object v0, p0, Lcom/example/extool/BluetoothViewModel;->_connectLiveData:Landroidx/lifecycle/MutableLiveData;

    return-object v0
.end method

.method protected final get_scanFailedLiveData()Landroidx/lifecycle/MutableLiveData;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroidx/lifecycle/MutableLiveData<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .line 24
    iget-object v0, p0, Lcom/example/extool/BluetoothViewModel;->_scanFailedLiveData:Landroidx/lifecycle/MutableLiveData;

    return-object v0
.end method

.method public onBluetoothNotSupported()V
    .registers 1

    .line 51
    invoke-static {p0}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback$DefaultImpls;->onBluetoothNotSupported(Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;)V

    return-void
.end method

.method public onBluetoothOpenDeny()V
    .registers 1

    .line 43
    invoke-static {p0}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback$DefaultImpls;->onBluetoothOpenDeny(Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;)V

    return-void
.end method

.method public onBluetoothOpenFailed()V
    .registers 1

    .line 47
    invoke-static {p0}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback$DefaultImpls;->onBluetoothOpenFailed(Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;)V

    return-void
.end method

.method public onBluetoothProfileOpened(I)V
    .registers 2

    .line 55
    invoke-static {p0, p1}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback$DefaultImpls;->onBluetoothProfileOpened(Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;I)V

    return-void
.end method

.method public onBluetoothState(Z)V
    .registers 2

    .line 36
    invoke-static {p0, p1}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback$DefaultImpls;->onBluetoothState(Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;Z)V

    if-eqz p1, :cond_8

    .line 38
    invoke-virtual {p0}, Lcom/example/extool/BluetoothViewModel;->tryConnect()V

    :cond_8
    return-void
.end method

.method public onDeviceConnected(Landroid/bluetooth/BluetoothDevice;)V
    .registers 4

    .line 80
    const-string v0, "VM.onDevConn"
    const-string v1, "entry"
    invoke-static {v0, v1}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logFile(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/example/extool/BluetoothViewModel;->stopScan()V

    invoke-static {p0, p1}, Lcom/flydigi/sdk/bluetooth/ConnectionStateCallback$DefaultImpls;->onDeviceConnected(Lcom/flydigi/sdk/bluetooth/ConnectionStateCallback;Landroid/bluetooth/BluetoothDevice;)V

    if-eqz p1, :cond_10

    .line 81
    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_10

    iget-object v1, p0, Lcom/example/extool/BluetoothViewModel;->_bluetoothNameLiveData:Landroidx/lifecycle/MutableLiveData;

    invoke-virtual {v1, v0}, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V

    :cond_10
    if-eqz p1, :cond_1d

    .line 82
    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object p1

    if-eqz p1, :cond_1d

    iget-object v0, p0, Lcom/example/extool/BluetoothViewModel;->_macLiveData:Landroidx/lifecycle/MutableLiveData;

    invoke-virtual {v0, p1}, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V

    .line 83
    :cond_1d
    iget-object p1, p0, Lcom/example/extool/BluetoothViewModel;->_connectLiveData:Landroidx/lifecycle/MutableLiveData;

    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V

    return-void
.end method

.method public onDeviceDisconnected(Landroid/bluetooth/BluetoothDevice;)V
    .registers 3

    .line 87
    invoke-static {p0, p1}, Lcom/flydigi/sdk/bluetooth/ConnectionStateCallback$DefaultImpls;->onDeviceDisconnected(Lcom/flydigi/sdk/bluetooth/ConnectionStateCallback;Landroid/bluetooth/BluetoothDevice;)V

    .line 88
    iget-object p1, p0, Lcom/example/extool/BluetoothViewModel;->_connectLiveData:Landroidx/lifecycle/MutableLiveData;

    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V

    .line 89
    iget-object p1, p0, Lcom/example/extool/BluetoothViewModel;->_bluetoothNameLiveData:Landroidx/lifecycle/MutableLiveData;

    const-string v0, ""

    invoke-virtual {p1, v0}, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V

    .line 90
    iget-object p1, p0, Lcom/example/extool/BluetoothViewModel;->_macLiveData:Landroidx/lifecycle/MutableLiveData;

    invoke-virtual {p1, v0}, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V

    return-void
.end method

.method public onDeviceFound(Ljava/util/List;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lcom/flydigi/sdk/bluetooth/data/BleDevice;",
            ">;)V"
        }
    .end annotation

    const-string v0, "devices"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "VM.onDevFound"
    const-string v1, "entry"
    invoke-static {v0, v1}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logFile(Ljava/lang/String;Ljava/lang/String;)V

    .line 64
    invoke-static {p0, p1}, Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback$DefaultImpls;->onDeviceFound(Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;Ljava/util/List;)V

    .line 65
    invoke-virtual {p0}, Lcom/example/extool/BluetoothViewModel;->stopScan()V

    .line 66
    invoke-static {p1}, Lkotlin/collections/CollectionsKt;->first(Ljava/util/List;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/flydigi/sdk/bluetooth/data/BleDevice;

    invoke-virtual {p1}, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object p1

    invoke-virtual {p0, p1}, Lcom/example/extool/BluetoothViewModel;->connect(Landroid/bluetooth/BluetoothDevice;)V

    return-void
.end method

.method public onScanFailed(I)V
    .registers 3

    .line 59
    invoke-static {p0, p1}, Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback$DefaultImpls;->onScanFailed(Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;I)V

    .line 60
    iget-object v0, p0, Lcom/example/extool/BluetoothViewModel;->_scanFailedLiveData:Landroidx/lifecycle/MutableLiveData;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-virtual {v0, p1}, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V

    return-void
.end method

.method public onScanStarted()V
    .registers 3

    const-string v0, "VM.onScanStart"
    const-string v1, "scan started"
    invoke-static {v0, v1}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logFile(Ljava/lang/String;Ljava/lang/String;)V

    .line 70
    invoke-static {p0}, Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback$DefaultImpls;->onScanStarted(Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;)V

    .line 71
    iget-object v0, p0, Lcom/example/extool/BluetoothViewModel;->_bluetoothNameLiveData:Landroidx/lifecycle/MutableLiveData;

    const-string v1, "\u626b\u63cf\u4e2d"

    invoke-virtual {v0, v1}, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V

    .line 72
    iget-object v0, p0, Lcom/example/extool/BluetoothViewModel;->_macLiveData:Landroidx/lifecycle/MutableLiveData;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V

    return-void
.end method

.method public onScanStopped()V
    .registers 1

    .line 76
    invoke-static {p0}, Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback$DefaultImpls;->onScanStopped(Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;)V

    return-void
.end method

.method public abstract scan()V
.end method

.method public abstract stopScan()V
.end method

.method public final tryConnect()V
    .registers 3

    .line 28
    iget-object v0, p0, Lcom/example/extool/BluetoothViewModel;->connectLiveData:Landroidx/lifecycle/LiveData;

    invoke-virtual {v0}, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;

    move-result-object v0

    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_15

    .line 29
    invoke-virtual {p0}, Lcom/example/extool/BluetoothViewModel;->disconnect()V

    goto :goto_18

    .line 31
    :cond_15
    invoke-virtual {p0}, Lcom/example/extool/BluetoothViewModel;->scan()V

    :goto_18
    return-void
.end method
