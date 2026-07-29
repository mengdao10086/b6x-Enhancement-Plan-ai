.class public abstract Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;
.super Ljava/lang/Object;
.source "AbstractBluetoothController.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$Companion;
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nAbstractBluetoothController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractBluetoothController.kt\ncom/flydigi/sdk/bluetooth/AbstractBluetoothController\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1116:1\n1855#2,2:1117\n1855#2,2:1119\n1855#2,2:1121\n1855#2,2:1123\n1855#2,2:1125\n1855#2,2:1127\n1855#2,2:1129\n1855#2,2:1131\n1855#2,2:1133\n1855#2,2:1135\n1855#2,2:1137\n1855#2,2:1139\n1855#2,2:1141\n1855#2,2:1143\n1855#2,2:1145\n1855#2,2:1147\n1855#2,2:1150\n1855#2,2:1152\n1855#2,2:1154\n1855#2,2:1156\n1855#2,2:1158\n1855#2,2:1160\n1855#2,2:1162\n1855#2,2:1164\n1855#2,2:1166\n1855#2,2:1168\n1855#2,2:1170\n1855#2,2:1172\n1855#2,2:1174\n1855#2,2:1176\n1855#2,2:1178\n1855#2,2:1180\n1855#2,2:1182\n1855#2,2:1184\n1855#2,2:1186\n1#3:1149\n*S KotlinDebug\n*F\n+ 1 AbstractBluetoothController.kt\ncom/flydigi/sdk/bluetooth/AbstractBluetoothController\n*L\n389#1:1117,2\n415#1:1119,2\n457#1:1121,2\n482#1:1123,2\n502#1:1125,2\n533#1:1127,2\n570#1:1129,2\n600#1:1131,2\n652#1:1133,2\n663#1:1135,2\n697#1:1137,2\n730#1:1139,2\n750#1:1141,2\n753#1:1143,2\n755#1:1145,2\n767#1:1147,2\n797#1:1150,2\n802#1:1152,2\n808#1:1154,2\n824#1:1156,2\n829#1:1158,2\n842#1:1160,2\n868#1:1162,2\n891#1:1164,2\n898#1:1166,2\n912#1:1168,2\n929#1:1170,2\n941#1:1172,2\n985#1:1174,2\n996#1:1176,2\n1014#1:1178,2\n1026#1:1180,2\n1030#1:1182,2\n554#1:1184,2\n586#1:1186,2\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u00db\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0008\u0003\n\u0002\u0008\u0003\n\u0002\u0008\u0003\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0010 \n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0010\u0012\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n*\u0005:=@CV\u0008&\u0018\u0000 \u0092\u00012\u00020\u0001:\u0002\u0092\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u0008J\u0010\u0010[\u001a\u00020\u001d2\u0006\u0010\\\u001a\u000202H\u0002J\u0019\u0010]\u001a\u00020^2\n\u0008\u0002\u0010_\u001a\u0004\u0018\u00010\u001dH\u0002\u00a2\u0006\u0002\u0010`J\u0006\u0010a\u001a\u00020\u001dJ\u0010\u0010b\u001a\u00020\u001d2\u0006\u0010\\\u001a\u000202H\u0002J\u000e\u0010c\u001a\u00020^2\u0006\u0010\\\u001a\u000202J\u0010\u0010d\u001a\u00020\u001d2\u0006\u0010\\\u001a\u000202H\u0002J\u000c\u0010e\u001a\u0008\u0012\u0004\u0012\u0002020fJ\u001d\u0010g\u001a\u0008\u0012\u0004\u0012\u0002020f2\n\u0008\u0002\u0010h\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0002\u0010iJ\u000e\u0010j\u001a\u00020\u00072\u0006\u0010\\\u001a\u000202J\u0012\u0010k\u001a\u0004\u0018\u0001022\u0008\u0010l\u001a\u0004\u0018\u00010mJ\u0006\u0010n\u001a\u00020\u001dJ\u0006\u0010o\u001a\u00020\u001dJ\u0006\u0010)\u001a\u00020\u001dJ\u0010\u0010p\u001a\u00020\u001d2\u0006\u0010l\u001a\u00020mH\u0002J\u0010\u0010q\u001a\u00020\u001d2\u0008\u0010\\\u001a\u0004\u0018\u000102J\u0010\u0010q\u001a\u00020\u001d2\u0008\u0010r\u001a\u0004\u0018\u00010mJ\u0012\u0010s\u001a\u00020\u001d2\u0008\u0010t\u001a\u0004\u0018\u00010uH\u0002J\u0008\u0010v\u001a\u00020^H\u0014J\u0008\u0010w\u001a\u00020^H\u0002J\u0012\u0010x\u001a\u00020^2\u0008\u0010\\\u001a\u0004\u0018\u000102H\u0015J\u0012\u0010y\u001a\u00020^2\u0008\u0010\\\u001a\u0004\u0018\u000102H\u0015J\u0016\u0010z\u001a\u00020^2\u000c\u0010{\u001a\u0008\u0012\u0004\u0012\u00020|0fH\u0002J\u001b\u0010}\u001a\u00020^2\u0006\u0010~\u001a\u00020\u007f2\u000b\u0008\u0002\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u000bJ\u001d\u0010}\u001a\u00020^2\u0008\u0010\u0081\u0001\u001a\u00030\u0082\u00012\u000b\u0008\u0002\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u000bJ\t\u0010\u0083\u0001\u001a\u00020^H\u0002J\u0012\u0010\u0084\u0001\u001a\u00020^2\u0007\u0010\u0085\u0001\u001a\u00020\u0001H\u0017J\u000f\u0010\u0086\u0001\u001a\u00020^2\u0006\u0010\\\u001a\u000202J\u000f\u0010\u0086\u0001\u001a\u00020^2\u0006\u0010l\u001a\u00020mJ\u0012\u0010\u0087\u0001\u001a\u00030\u0088\u00012\u0008\u0010\u0081\u0001\u001a\u00030\u0089\u0001J\t\u0010\u008a\u0001\u001a\u00020^H\u0015J\u0013\u0010\u008b\u0001\u001a\u00020^2\u0008\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0002J\t\u0010\u008c\u0001\u001a\u00020^H\u0002J\u0013\u0010\u008c\u0001\u001a\u00020^2\u0008\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0003J\u0017\u0010\u008d\u0001\u001a\u00020^2\u0006\u0010~\u001a\u00020\u007f2\u0006\u0010Z\u001a\u00020\u0007J\u0019\u0010\u008d\u0001\u001a\u00020^2\u0008\u0010\u0081\u0001\u001a\u00030\u0082\u00012\u0006\u0010Z\u001a\u00020\u0007J\u0007\u0010\u008e\u0001\u001a\u00020^J\u0012\u0010\u008f\u0001\u001a\u00020^2\u0007\u0010\u0085\u0001\u001a\u00020\u0001H\u0017J\u000b\u0010\u0090\u0001\u001a\u00020\u001d*\u000202J\u000b\u0010\u0091\u0001\u001a\u00020\u001d*\u000202R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\u0008\u0012\u0004\u0012\u00020\u000b`\u000cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\nj\u0008\u0012\u0004\u0012\u00020\u000e`\u000cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\u000c\n\u0004\u0008\u0013\u0010\u0014\u001a\u0004\u0008\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\u0007X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\nj\u0008\u0012\u0004\u0012\u00020\u001b`\u000cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\u000c\n\u0004\u0008 \u0010\u0014\u001a\u0004\u0008\u001f\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u001a\u0010#\u001a\u00020\u001dX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008$\u0010%\"\u0004\u0008&\u0010\'R\u000e\u0010(\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\u000c\n\u0004\u0008.\u0010\u0014\u001a\u0004\u0008,\u0010-R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u00101\u001a\u0004\u0018\u000102X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u00083\u00104\"\u0004\u00085\u00106R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00109\u001a\u00020:X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010;R\u0010\u0010<\u001a\u00020=X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010>R\u0010\u0010?\u001a\u00020@X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010AR\u0010\u0010B\u001a\u00020CX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010DR\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008E\u0010FR\u001a\u0010G\u001a\u00020HX\u0084.\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008I\u0010J\"\u0004\u0008K\u0010LR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010O\u001a\u00020HX\u0084.\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008P\u0010J\"\u0004\u0008Q\u0010LR\u001b\u0010R\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\u000c\n\u0004\u0008T\u0010\u0014\u001a\u0004\u0008S\u0010\u0012R\u0010\u0010U\u001a\u00020VX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010WR\u001e\u0010X\u001a\u0012\u0012\u0004\u0012\u00020Y0\nj\u0008\u0012\u0004\u0012\u00020Y`\u000cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0093\u0001"
    }
    d2 = {
        "Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;",
        "",
        "mContext",
        "Landroid/content/Context;",
        "deviceFilter",
        "Lcom/flydigi/sdk/bluetooth/DeviceFilter;",
        "mProfile",
        "",
        "(Landroid/content/Context;Lcom/flydigi/sdk/bluetooth/DeviceFilter;I)V",
        "bluetoothStateCallbacks",
        "Ljava/util/ArrayList;",
        "Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;",
        "Lkotlin/collections/ArrayList;",
        "bondStateCallbacks",
        "Lcom/flydigi/sdk/bluetooth/BondStateCallback;",
        "checkLocationServiceEnabledRunnable",
        "Ljava/lang/Runnable;",
        "getCheckLocationServiceEnabledRunnable",
        "()Ljava/lang/Runnable;",
        "checkLocationServiceEnabledRunnable$delegate",
        "Lkotlin/Lazy;",
        "chipType",
        "getChipType",
        "()I",
        "setChipType",
        "(I)V",
        "connectionStateCallbacks",
        "Lcom/flydigi/sdk/bluetooth/ConnectionStateCallback;",
        "continueCreateBond",
        "",
        "createBondTimeoutRunnable",
        "getCreateBondTimeoutRunnable",
        "createBondTimeoutRunnable$delegate",
        "getDeviceFilter",
        "()Lcom/flydigi/sdk/bluetooth/DeviceFilter;",
        "inOtaMode",
        "getInOtaMode",
        "()Z",
        "setInOtaMode",
        "(Z)V",
        "inScanning",
        "isBluetoothSupported",
        "leScanCallback",
        "Landroid/bluetooth/BluetoothAdapter$LeScanCallback;",
        "getLeScanCallback",
        "()Landroid/bluetooth/BluetoothAdapter$LeScanCallback;",
        "leScanCallback$delegate",
        "mBluetoothAdapter",
        "Landroid/bluetooth/BluetoothAdapter;",
        "mBluetoothDevice",
        "Landroid/bluetooth/BluetoothDevice;",
        "getMBluetoothDevice",
        "()Landroid/bluetooth/BluetoothDevice;",
        "setMBluetoothDevice",
        "(Landroid/bluetooth/BluetoothDevice;)V",
        "mBluetoothManager",
        "Landroid/bluetooth/BluetoothManager;",
        "mBluetoothStateReceiver",
        "com/flydigi/sdk/bluetooth/AbstractBluetoothController$mBluetoothStateReceiver$1",
        "Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mBluetoothStateReceiver$1;",
        "mBondStateReceiver",
        "com/flydigi/sdk/bluetooth/AbstractBluetoothController$mBondStateReceiver$1",
        "Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mBondStateReceiver$1;",
        "mClassicScanReceiver",
        "com/flydigi/sdk/bluetooth/AbstractBluetoothController$mClassicScanReceiver$1",
        "Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mClassicScanReceiver$1;",
        "mConnectStateReceiver",
        "com/flydigi/sdk/bluetooth/AbstractBluetoothController$mConnectStateReceiver$1",
        "Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mConnectStateReceiver$1;",
        "getMContext",
        "()Landroid/content/Context;",
        "mMainHandler",
        "Landroid/os/Handler;",
        "getMMainHandler",
        "()Landroid/os/Handler;",
        "setMMainHandler",
        "(Landroid/os/Handler;)V",
        "mProxy",
        "Landroid/bluetooth/BluetoothProfile;",
        "mWorkHandler",
        "getMWorkHandler",
        "setMWorkHandler",
        "removeBondTimeoutRunnable",
        "getRemoveBondTimeoutRunnable",
        "removeBondTimeoutRunnable$delegate",
        "scanCallback",
        "com/flydigi/sdk/bluetooth/AbstractBluetoothController$scanCallback$1",
        "Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$scanCallback$1;",
        "scanDeviceCallbacks",
        "Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;",
        "scanMode",
        "cancelBondProcess",
        "device",
        "checkLocationServiceEnabled",
        "",
        "doScan",
        "(Ljava/lang/Boolean;)V",
        "closeBluetooth",
        "connectDevice",
        "createBond",
        "disconnectDevice",
        "getBondedDevice",
        "",
        "getConnectedDevices",
        "bondRequired",
        "(Ljava/lang/Boolean;)Ljava/util/List;",
        "getConnectionState",
        "getRemoteDevice",
        "deviceMac",
        "",
        "isAccessFineLocationPermissionGranted",
        "isBluetoothEnabled",
        "isDeviceBonded",
        "isDeviceConnected",
        "address",
        "isDeviceReady",
        "scanRecord",
        "",
        "onBluetoothDisabled",
        "onBluetoothEnabled",
        "onDeviceConnected",
        "onDeviceDisconnected",
        "onDeviceFound",
        "devices",
        "Lcom/flydigi/sdk/bluetooth/data/BleDevice;",
        "openBluetooth",
        "fragment",
        "Landroidx/fragment/app/Fragment;",
        "callback",
        "activity",
        "Landroidx/fragment/app/FragmentActivity;",
        "openProfile",
        "register",
        "obj",
        "removeBond",
        "requestEnableLocationService",
        "Lio/reactivex/disposables/Disposable;",
        "Landroid/app/Activity;",
        "reset",
        "startClassicScan",
        "startLeScan",
        "startScan",
        "stopScan",
        "unregister",
        "isConnected",
        "isDeviceNameExist",
        "Companion",
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
.field public static final Companion:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$Companion;

.field public static final TIMEOUT_BOND:J = 0x3a98L


# instance fields
.field private bluetoothStateCallbacks:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;",
            ">;"
        }
    .end annotation
.end field

.field private bondStateCallbacks:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Lcom/flydigi/sdk/bluetooth/BondStateCallback;",
            ">;"
        }
    .end annotation
.end field

.field private final checkLocationServiceEnabledRunnable$delegate:Lkotlin/Lazy;

.field private chipType:I

.field private connectionStateCallbacks:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Lcom/flydigi/sdk/bluetooth/ConnectionStateCallback;",
            ">;"
        }
    .end annotation
.end field

.field private continueCreateBond:Z

.field private final createBondTimeoutRunnable$delegate:Lkotlin/Lazy;

.field private final deviceFilter:Lcom/flydigi/sdk/bluetooth/DeviceFilter;

.field private inOtaMode:Z

.field private inScanning:Z

.field private isBluetoothSupported:Z

.field private final leScanCallback$delegate:Lkotlin/Lazy;

.field private mBluetoothAdapter:Landroid/bluetooth/BluetoothAdapter;

.field private mBluetoothDevice:Landroid/bluetooth/BluetoothDevice;

.field private mBluetoothManager:Landroid/bluetooth/BluetoothManager;

.field private final mBluetoothStateReceiver:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mBluetoothStateReceiver$1;

.field private final mBondStateReceiver:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mBondStateReceiver$1;

.field private final mClassicScanReceiver:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mClassicScanReceiver$1;

.field private final mConnectStateReceiver:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mConnectStateReceiver$1;

.field private final mContext:Landroid/content/Context;

.field protected mMainHandler:Landroid/os/Handler;

.field private final mProfile:I

.field private mProxy:Landroid/bluetooth/BluetoothProfile;

.field protected mWorkHandler:Landroid/os/Handler;

.field private final removeBondTimeoutRunnable$delegate:Lkotlin/Lazy;

.field private final scanCallback:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$scanCallback$1;

.field private scanDeviceCallbacks:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;",
            ">;"
        }
    .end annotation
.end field

.field private scanMode:I


# direct methods
.method public static synthetic $r8$lambda$DuU7MZ1PnYBIO7vJdKr2djD0IvM(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;ZLjava/util/List;Ljava/util/List;)V
    .registers 4

    invoke-static {p0, p1, p2, p3}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->startLeScan$lambda$19(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;ZLjava/util/List;Ljava/util/List;)V

    return-void
.end method

.method public static synthetic $r8$lambda$O3k0zptRxhza0tW5XxfXB5Ea2mM(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V
    .registers 2

    invoke-static {p0, p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->openBluetooth$lambda$6(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V

    return-void
.end method

.method public static synthetic $r8$lambda$Rhxns2YOOPAoOf_gDjAz3wlz52M(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;ZLjava/util/List;Ljava/util/List;)V
    .registers 4

    invoke-static {p0, p1, p2, p3}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->startClassicScan$lambda$16(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;ZLjava/util/List;Ljava/util/List;)V

    return-void
.end method

.method public static synthetic $r8$lambda$jKnbpaYBPPIGjzhGiBGjmpnxdg8(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V
    .registers 2

    invoke-static {p0, p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->openBluetooth$lambda$5(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V

    return-void
.end method

.method public static synthetic $r8$lambda$nI30JbqAnRnNJ3HRLkP_QT3zsDA(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V
    .registers 2

    invoke-static {p0, p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->requestEnableLocationService$lambda$9(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V

    return-void
.end method

.method static constructor <clinit>()V
    .registers 2

    new-instance v0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->Companion:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$Companion;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/flydigi/sdk/bluetooth/DeviceFilter;I)V
    .registers 9

    const-string v0, "mContext"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "deviceFilter"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mContext:Landroid/content/Context;

    iput-object p2, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->deviceFilter:Lcom/flydigi/sdk/bluetooth/DeviceFilter;

    iput p3, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mProfile:I

    const/4 p2, -0x1

    iput p2, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->chipType:I

    new-instance p2, Ljava/util/ArrayList;

    invoke-direct {p2}, Ljava/util/ArrayList;-><init>()V

    iput-object p2, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bluetoothStateCallbacks:Ljava/util/ArrayList;

    new-instance p2, Ljava/util/ArrayList;

    invoke-direct {p2}, Ljava/util/ArrayList;-><init>()V

    iput-object p2, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->scanDeviceCallbacks:Ljava/util/ArrayList;

    new-instance p2, Ljava/util/ArrayList;

    invoke-direct {p2}, Ljava/util/ArrayList;-><init>()V

    iput-object p2, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bondStateCallbacks:Ljava/util/ArrayList;

    new-instance p2, Ljava/util/ArrayList;

    invoke-direct {p2}, Ljava/util/ArrayList;-><init>()V

    iput-object p2, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->connectionStateCallbacks:Ljava/util/ArrayList;

    const/4 p2, 0x2

    iput p2, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->scanMode:I

    const/4 p2, 0x1

    iput-boolean p2, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isBluetoothSupported:Z

    new-instance p3, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mClassicScanReceiver$1;

    invoke-direct {p3, p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mClassicScanReceiver$1;-><init>(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V

    iput-object p3, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mClassicScanReceiver:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mClassicScanReceiver$1;

    new-instance v0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mBluetoothStateReceiver$1;

    invoke-direct {v0, p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mBluetoothStateReceiver$1;-><init>(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V

    iput-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mBluetoothStateReceiver:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mBluetoothStateReceiver$1;

    new-instance v1, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mBondStateReceiver$1;

    invoke-direct {v1, p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mBondStateReceiver$1;-><init>(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V

    iput-object v1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mBondStateReceiver:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mBondStateReceiver$1;

    new-instance v2, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mConnectStateReceiver$1;

    invoke-direct {v2, p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mConnectStateReceiver$1;-><init>(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V

    iput-object v2, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mConnectStateReceiver:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mConnectStateReceiver$1;

    new-instance v3, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$leScanCallback$2;

    invoke-direct {v3, p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$leScanCallback$2;-><init>(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V

    check-cast v3, Lkotlin/jvm/functions/Function0;

    invoke-static {v3}, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;

    move-result-object v3

    iput-object v3, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->leScanCallback$delegate:Lkotlin/Lazy;

    new-instance v3, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$scanCallback$1;

    invoke-direct {v3, p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$scanCallback$1;-><init>(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V

    iput-object v3, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->scanCallback:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$scanCallback$1;

    new-instance v3, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$checkLocationServiceEnabledRunnable$2;

    invoke-direct {v3, p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$checkLocationServiceEnabledRunnable$2;-><init>(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V

    check-cast v3, Lkotlin/jvm/functions/Function0;

    invoke-static {v3}, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;

    move-result-object v3

    iput-object v3, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->checkLocationServiceEnabledRunnable$delegate:Lkotlin/Lazy;

    new-instance v3, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$createBondTimeoutRunnable$2;

    invoke-direct {v3, p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$createBondTimeoutRunnable$2;-><init>(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V

    check-cast v3, Lkotlin/jvm/functions/Function0;

    invoke-static {v3}, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;

    move-result-object v3

    iput-object v3, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->createBondTimeoutRunnable$delegate:Lkotlin/Lazy;

    new-instance v3, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$removeBondTimeoutRunnable$2;

    invoke-direct {v3, p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$removeBondTimeoutRunnable$2;-><init>(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V

    check-cast v3, Lkotlin/jvm/functions/Function0;

    invoke-static {v3}, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;

    move-result-object v3

    iput-object v3, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->removeBondTimeoutRunnable$delegate:Lkotlin/Lazy;

    const-string v3, "bluetooth"

    invoke-virtual {p1, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    const-string v4, "null cannot be cast to non-null type android.bluetooth.BluetoothManager"

    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v3, Landroid/bluetooth/BluetoothManager;

    iput-object v3, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mBluetoothManager:Landroid/bluetooth/BluetoothManager;

    if-eqz v3, :cond_a6

    invoke-virtual {v3}, Landroid/bluetooth/BluetoothManager;->getAdapter()Landroid/bluetooth/BluetoothAdapter;

    move-result-object v3

    if-nez v3, :cond_aa

    :cond_a6
    invoke-static {}, Landroid/bluetooth/BluetoothAdapter;->getDefaultAdapter()Landroid/bluetooth/BluetoothAdapter;

    move-result-object v3

    :cond_aa
    iput-object v3, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mBluetoothAdapter:Landroid/bluetooth/BluetoothAdapter;

    if-eqz v3, :cond_af

    goto :goto_b0

    :cond_af
    const/4 p2, 0x0

    :goto_b0
    iput-boolean p2, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isBluetoothSupported:Z

    new-instance p2, Landroid/os/HandlerThread;

    const-string v3, "flyBleThread"

    invoke-direct {p2, v3}, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/HandlerThread;->start()V

    invoke-virtual {p2}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object p2

    new-instance v3, Landroid/os/Handler;

    invoke-direct {v3, p2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    invoke-virtual {p0, v3}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->setMWorkHandler(Landroid/os/Handler;)V

    new-instance p2, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v3

    invoke-direct {p2, v3}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    invoke-virtual {p0, p2}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->setMMainHandler(Landroid/os/Handler;)V

    iget-boolean p2, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isBluetoothSupported:Z

    if-eqz p2, :cond_12d

    invoke-direct {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->openProfile()V

    new-instance p2, Landroid/content/IntentFilter;

    invoke-direct {p2}, Landroid/content/IntentFilter;-><init>()V

    const-string v3, "android.bluetooth.adapter.action.DISCOVERY_STARTED"

    invoke-virtual {p2, v3}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    const-string v3, "android.bluetooth.adapter.action.DISCOVERY_FINISHED"

    invoke-virtual {p2, v3}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    const-string v3, "android.bluetooth.device.action.FOUND"

    invoke-virtual {p2, v3}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    const-string v3, "android.bluetooth.device.action.PAIRING_REQUEST"

    invoke-virtual {p2, v3}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    check-cast p3, Landroid/content/BroadcastReceiver;

    invoke-virtual {p1, p3, p2}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    new-instance p2, Landroid/content/IntentFilter;

    invoke-direct {p2}, Landroid/content/IntentFilter;-><init>()V

    const-string p3, "android.bluetooth.adapter.action.STATE_CHANGED"

    invoke-virtual {p2, p3}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    check-cast v0, Landroid/content/BroadcastReceiver;

    invoke-virtual {p1, v0, p2}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    new-instance p2, Landroid/content/IntentFilter;

    invoke-direct {p2}, Landroid/content/IntentFilter;-><init>()V

    const-string p3, "android.bluetooth.device.action.ACL_CONNECTED"

    invoke-virtual {p2, p3}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    const-string p3, "android.bluetooth.device.action.ACL_DISCONNECTED"

    invoke-virtual {p2, p3}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    const-string p3, "android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED"

    invoke-virtual {p2, p3}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    check-cast v2, Landroid/content/BroadcastReceiver;

    invoke-virtual {p1, v2, p2}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    check-cast v1, Landroid/content/BroadcastReceiver;

    new-instance p2, Landroid/content/IntentFilter;

    const-string p3, "android.bluetooth.device.action.BOND_STATE_CHANGED"

    invoke-direct {p2, p3}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1, v1, p2}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    :cond_12d
    return-void
.end method

.method public static final synthetic access$cancelBondProcess(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;Landroid/bluetooth/BluetoothDevice;)Z
    .registers 2

    invoke-direct {p0, p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->cancelBondProcess(Landroid/bluetooth/BluetoothDevice;)Z

    move-result p0

    return p0
.end method

.method public static final synthetic access$checkLocationServiceEnabled(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;Ljava/lang/Boolean;)V
    .registers 2

    invoke-direct {p0, p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->checkLocationServiceEnabled(Ljava/lang/Boolean;)V

    return-void
.end method

.method public static final synthetic access$connectDevice(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;Landroid/bluetooth/BluetoothDevice;)Z
    .registers 2

    invoke-direct {p0, p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->connectDevice(Landroid/bluetooth/BluetoothDevice;)Z

    move-result p0

    return p0
.end method

.method public static final synthetic access$getBluetoothStateCallbacks$p(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)Ljava/util/ArrayList;
    .registers 1

    iget-object p0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bluetoothStateCallbacks:Ljava/util/ArrayList;

    return-object p0
.end method

.method public static final synthetic access$getBondStateCallbacks$p(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)Ljava/util/ArrayList;
    .registers 1

    iget-object p0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bondStateCallbacks:Ljava/util/ArrayList;

    return-object p0
.end method

.method public static final synthetic access$getCheckLocationServiceEnabledRunnable(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)Ljava/lang/Runnable;
    .registers 1

    invoke-direct {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->getCheckLocationServiceEnabledRunnable()Ljava/lang/Runnable;

    move-result-object p0

    return-object p0
.end method

.method public static final synthetic access$getConnectionStateCallbacks$p(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)Ljava/util/ArrayList;
    .registers 1

    iget-object p0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->connectionStateCallbacks:Ljava/util/ArrayList;

    return-object p0
.end method

.method public static final synthetic access$getContinueCreateBond$p(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)Z
    .registers 1

    iget-boolean p0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->continueCreateBond:Z

    return p0
.end method

.method public static final synthetic access$getCreateBondTimeoutRunnable(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)Ljava/lang/Runnable;
    .registers 1

    invoke-direct {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->getCreateBondTimeoutRunnable()Ljava/lang/Runnable;

    move-result-object p0

    return-object p0
.end method

.method public static final synthetic access$getRemoveBondTimeoutRunnable(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)Ljava/lang/Runnable;
    .registers 1

    invoke-direct {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->getRemoveBondTimeoutRunnable()Ljava/lang/Runnable;

    move-result-object p0

    return-object p0
.end method

.method public static final synthetic access$getScanDeviceCallbacks$p(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)Ljava/util/ArrayList;
    .registers 1

    iget-object p0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->scanDeviceCallbacks:Ljava/util/ArrayList;

    return-object p0
.end method

.method public static final synthetic access$onBluetoothEnabled(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V
    .registers 1

    invoke-direct {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->onBluetoothEnabled()V

    return-void
.end method

.method public static final synthetic access$onDeviceFound(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;Ljava/util/List;)V
    .registers 2

    invoke-direct {p0, p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->onDeviceFound(Ljava/util/List;)V

    return-void
.end method

.method public static final synthetic access$openProfile(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V
    .registers 1

    invoke-direct {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->openProfile()V

    return-void
.end method

.method public static final synthetic access$setContinueCreateBond$p(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;Z)V
    .registers 2

    iput-boolean p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->continueCreateBond:Z

    return-void
.end method

.method public static final synthetic access$setMProxy$p(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;Landroid/bluetooth/BluetoothProfile;)V
    .registers 2

    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mProxy:Landroid/bluetooth/BluetoothProfile;

    return-void
.end method

.method private final cancelBondProcess(Landroid/bluetooth/BluetoothDevice;)Z
    .registers 6

    iget-boolean v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isBluetoothSupported:Z

    const/4 v1, 0x0

    if-nez v0, :cond_1e

    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bluetoothStateCallbacks:Ljava/util/ArrayList;

    check-cast p1, Ljava/lang/Iterable;

    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_d
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1d

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;

    invoke-interface {v0}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;->onBluetoothNotSupported()V

    goto :goto_d

    :cond_1d
    return v1

    :cond_1e
    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isBluetoothEnabled()Z

    move-result v0

    if-nez v0, :cond_25

    return v1

    :cond_25
    :try_start_25
    const-class v0, Landroid/bluetooth/BluetoothDevice;

    const-string v2, "cancelBondProcess"

    new-array v3, v1, [Ljava/lang/Class;

    invoke-virtual {v0, v2, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Ljava/lang/reflect/Method;->setAccessible(Z)V

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object v3, v2, v1

    invoke-virtual {v0, p1, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    const-string v0, "null cannot be cast to non-null type kotlin.Boolean"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p1, Ljava/lang/Boolean;

    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1
    :try_end_47
    .catch Ljava/lang/Exception; {:try_start_25 .. :try_end_47} :catch_47

    :catch_47
    return v1
.end method

.method private final checkLocationServiceEnabled(Ljava/lang/Boolean;)V
    .registers 6

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mContext:Landroid/content/Context;

    const-string v1, "location"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    const-string v1, "null cannot be cast to non-null type android.location.LocationManager"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Landroid/location/LocationManager;

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x1c

    const/4 v3, 0x1

    if-lt v1, v2, :cond_1b

    invoke-virtual {v0}, Landroid/location/LocationManager;->isLocationEnabled()Z

    move-result v0

    goto :goto_37

    :cond_1b
    const-string v1, "gps"

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_36

    const-string v1, "network"

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_36

    const-string v1, "passive"

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_34

    goto :goto_36

    :cond_34
    const/4 v0, 0x0

    goto :goto_37

    :cond_36
    :goto_36
    move v0, v3

    :goto_37
    if-nez v0, :cond_56

    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->stopScan()V

    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->scanDeviceCallbacks:Ljava/util/ArrayList;

    check-cast p1, Ljava/lang/Iterable;

    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_44
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_63

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;

    const/16 v1, 0x8

    invoke-interface {v0, v1}, Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;->onScanFailed(I)V

    goto :goto_44

    :cond_56
    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_63

    invoke-direct {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->startLeScan()V

    :cond_63
    return-void
.end method

.method static synthetic checkLocationServiceEnabled$default(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;Ljava/lang/Boolean;ILjava/lang/Object;)V
    .registers 4

    if-nez p3, :cond_f

    and-int/lit8 p2, p2, 0x1

    if-eqz p2, :cond_b

    const/4 p1, 0x0

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p1

    :cond_b
    invoke-direct {p0, p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->checkLocationServiceEnabled(Ljava/lang/Boolean;)V

    return-void

    :cond_f
    new-instance p0, Ljava/lang/UnsupportedOperationException;

    const-string p1, "Super calls with default arguments not supported in this target, function: checkLocationServiceEnabled"

    invoke-direct {p0, p1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method private final connectDevice(Landroid/bluetooth/BluetoothDevice;)Z
    .registers 9

    iget-boolean v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isBluetoothSupported:Z

    const/4 v1, 0x0

    if-nez v0, :cond_1e

    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bluetoothStateCallbacks:Ljava/util/ArrayList;

    check-cast p1, Ljava/lang/Iterable;

    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_d
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1d

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;

    invoke-interface {v0}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;->onBluetoothNotSupported()V

    goto :goto_d

    :cond_1d
    return v1

    :cond_1e
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x1c

    const/4 v3, 0x1

    if-lt v0, v2, :cond_26

    return v3

    :cond_26
    :try_start_26
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mProxy:Landroid/bluetooth/BluetoothProfile;

    if-eqz v0, :cond_50

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    const-string v4, "connect"

    new-array v5, v3, [Ljava/lang/Class;

    const-class v6, Landroid/bluetooth/BluetoothDevice;

    aput-object v6, v5, v1

    invoke-virtual {v2, v4, v5}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v2

    invoke-virtual {v2, v3}, Ljava/lang/reflect/Method;->setAccessible(Z)V

    new-array v3, v3, [Ljava/lang/Object;

    aput-object p1, v3, v1

    invoke-virtual {v2, v0, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    const-string v0, "null cannot be cast to non-null type kotlin.Boolean"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p1, Ljava/lang/Boolean;

    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1
    :try_end_50
    .catch Ljava/lang/Exception; {:try_start_26 .. :try_end_50} :catch_50

    :catch_50
    :cond_50
    return v1
.end method

.method private final disconnectDevice(Landroid/bluetooth/BluetoothDevice;)Z
    .registers 9

    iget-boolean v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isBluetoothSupported:Z

    const/4 v1, 0x0

    if-nez v0, :cond_1e

    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bluetoothStateCallbacks:Ljava/util/ArrayList;

    check-cast p1, Ljava/lang/Iterable;

    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_d
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1d

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;

    invoke-interface {v0}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;->onBluetoothNotSupported()V

    goto :goto_d

    :cond_1d
    return v1

    :cond_1e
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x1c

    const/4 v3, 0x1

    if-lt v0, v2, :cond_26

    return v3

    :cond_26
    :try_start_26
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mProxy:Landroid/bluetooth/BluetoothProfile;

    if-eqz v0, :cond_50

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    const-string v4, "disconnect"

    new-array v5, v3, [Ljava/lang/Class;

    const-class v6, Landroid/bluetooth/BluetoothDevice;

    aput-object v6, v5, v1

    invoke-virtual {v2, v4, v5}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v2

    invoke-virtual {v2, v3}, Ljava/lang/reflect/Method;->setAccessible(Z)V

    new-array v3, v3, [Ljava/lang/Object;

    aput-object p1, v3, v1

    invoke-virtual {v2, v0, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    const-string v0, "null cannot be cast to non-null type kotlin.Boolean"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p1, Ljava/lang/Boolean;

    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1
    :try_end_50
    .catch Ljava/lang/Exception; {:try_start_26 .. :try_end_50} :catch_50

    :catch_50
    :cond_50
    return v1
.end method

.method private final getCheckLocationServiceEnabledRunnable()Ljava/lang/Runnable;
    .registers 2

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->checkLocationServiceEnabledRunnable$delegate:Lkotlin/Lazy;

    invoke-interface {v0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Runnable;

    return-object v0
.end method

.method public static synthetic getConnectedDevices$default(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;Ljava/lang/Boolean;ILjava/lang/Object;)Ljava/util/List;
    .registers 4

    if-nez p3, :cond_10

    and-int/lit8 p2, p2, 0x1

    if-eqz p2, :cond_b

    const/4 p1, 0x0

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p1

    :cond_b
    invoke-virtual {p0, p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->getConnectedDevices(Ljava/lang/Boolean;)Ljava/util/List;

    move-result-object p0

    return-object p0

    :cond_10
    new-instance p0, Ljava/lang/UnsupportedOperationException;

    const-string p1, "Super calls with default arguments not supported in this target, function: getConnectedDevices"

    invoke-direct {p0, p1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method private final getCreateBondTimeoutRunnable()Ljava/lang/Runnable;
    .registers 2

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->createBondTimeoutRunnable$delegate:Lkotlin/Lazy;

    invoke-interface {v0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Runnable;

    return-object v0
.end method

.method private final getLeScanCallback()Landroid/bluetooth/BluetoothAdapter$LeScanCallback;
    .registers 2

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->leScanCallback$delegate:Lkotlin/Lazy;

    invoke-interface {v0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/bluetooth/BluetoothAdapter$LeScanCallback;

    return-object v0
.end method

.method private final getRemoveBondTimeoutRunnable()Ljava/lang/Runnable;
    .registers 2

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->removeBondTimeoutRunnable$delegate:Lkotlin/Lazy;

    invoke-interface {v0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Runnable;

    return-object v0
.end method

.method private final isDeviceBonded(Ljava/lang/String;)Z
    .registers 4

    iget-boolean v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isBluetoothSupported:Z

    const/4 v1, 0x0

    if-nez v0, :cond_1e

    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bluetoothStateCallbacks:Ljava/util/ArrayList;

    check-cast p1, Ljava/lang/Iterable;

    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_d
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1d

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;

    invoke-interface {v0}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;->onBluetoothNotSupported()V

    goto :goto_d

    :cond_1d
    return v1

    :cond_1e
    invoke-virtual {p0, p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->getRemoteDevice(Ljava/lang/String;)Landroid/bluetooth/BluetoothDevice;

    move-result-object p1

    if-eqz p1, :cond_2d

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getBondState()I

    move-result p1

    const/16 v0, 0xc

    if-ne p1, v0, :cond_2d

    const/4 v1, 0x1

    :cond_2d
    return v1
.end method

.method private final isDeviceReady([B)Z
    .registers 7

    const/4 v0, 0x0

    if-nez p1, :cond_4

    return v0

    :cond_4
    array-length v1, p1

    const/4 v2, 0x1

    if-le v1, v2, :cond_21

    :try_start_8
    array-length v1, p1

    sub-int/2addr v1, v2

    move v3, v0

    :goto_b
    if-ge v3, v1, :cond_21

    aget-byte v4, p1, v3

    if-ne v4, v2, :cond_1e

    add-int/2addr v3, v2

    aget-byte p1, p1, v3
    :try_end_14
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_14} :catch_21

    and-int/lit8 v1, p1, 0x1

    if-gtz v1, :cond_1c

    and-int/lit8 p1, p1, 0x2

    if-lez p1, :cond_1d

    :cond_1c
    move v0, v2

    :cond_1d
    return v0

    :cond_1e
    add-int/lit8 v3, v3, 0x1

    goto :goto_b

    :catch_21
    :cond_21
    return v0
.end method

.method private final onBluetoothEnabled()V
    .registers 4

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bluetoothStateCallbacks:Ljava/util/ArrayList;

    check-cast v0, Ljava/lang/Iterable;

    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_8
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_19

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;

    const/4 v2, 0x1

    invoke-interface {v1, v2}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;->onBluetoothState(Z)V

    goto :goto_8

    :cond_19
    return-void
.end method

.method private final onDeviceFound(Ljava/util/List;)V
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lcom/flydigi/sdk/bluetooth/data/BleDevice;",
            ">;)V"
        }
    .end annotation

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :cond_9
    :goto_9
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    const/4 v2, 0x1

    if-eqz v1, :cond_56

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/flydigi/sdk/bluetooth/data/BleDevice;

    invoke-virtual {v1}, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v3

    invoke-virtual {p0, v3}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isDeviceNameExist(Landroid/bluetooth/BluetoothDevice;)Z

    move-result v3

    if-eqz v3, :cond_29

    invoke-virtual {v1}, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v3

    invoke-virtual {v3}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v3

    goto :goto_31

    :cond_29
    invoke-virtual {v1}, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->getBytes()[B

    move-result-object v3

    invoke-static {v3}, Lcom/flydigi/sdk/bluetooth/BleUtils;->readDeviceNameFromScanRecord([B)Ljava/lang/String;

    move-result-object v3

    :goto_31
    invoke-virtual {v1, v3}, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->setDeviceName(Ljava/lang/String;)V

    invoke-virtual {v1}, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->getDeviceName()Ljava/lang/String;

    move-result-object v4

    check-cast v4, Ljava/lang/CharSequence;

    if-eqz v4, :cond_44

    invoke-interface {v4}, Ljava/lang/CharSequence;->length()I

    move-result v4

    if-nez v4, :cond_43

    goto :goto_44

    :cond_43
    const/4 v2, 0x0

    :cond_44
    :goto_44
    if-nez v2, :cond_9

    iget-object v2, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->deviceFilter:Lcom/flydigi/sdk/bluetooth/DeviceFilter;

    invoke-virtual {v1}, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->getRssi()I

    move-result v4

    invoke-interface {v2, v3, v4}, Lcom/flydigi/sdk/bluetooth/DeviceFilter;->isValidDevice(Ljava/lang/String;I)Z

    move-result v2

    if-eqz v2, :cond_9

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_9

    :cond_56
    move-object p1, v0

    check-cast p1, Ljava/util/Collection;

    invoke-interface {p1}, Ljava/util/Collection;->isEmpty()Z

    move-result p1

    xor-int/2addr p1, v2

    if-eqz p1, :cond_7b

    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->scanDeviceCallbacks:Ljava/util/ArrayList;

    check-cast p1, Ljava/lang/Iterable;

    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_68
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_7b

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;

    move-object v2, v0

    check-cast v2, Ljava/util/List;

    invoke-interface {v1, v2}, Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;->onDeviceFound(Ljava/util/List;)V

    goto :goto_68

    :cond_7b
    return-void
.end method

.method public static synthetic openBluetooth$default(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;Landroidx/fragment/app/Fragment;Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;ILjava/lang/Object;)V
    .registers 5

    if-nez p4, :cond_b

    and-int/lit8 p3, p3, 0x2

    if-eqz p3, :cond_7

    const/4 p2, 0x0

    :cond_7
    invoke-virtual {p0, p1, p2}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->openBluetooth(Landroidx/fragment/app/Fragment;Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;)V

    return-void

    :cond_b
    new-instance p0, Ljava/lang/UnsupportedOperationException;

    const-string p1, "Super calls with default arguments not supported in this target, function: openBluetooth"

    invoke-direct {p0, p1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static synthetic openBluetooth$default(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;Landroidx/fragment/app/FragmentActivity;Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;ILjava/lang/Object;)V
    .registers 5

    if-nez p4, :cond_b

    and-int/lit8 p3, p3, 0x2

    if-eqz p3, :cond_7

    const/4 p2, 0x0

    :cond_7
    invoke-virtual {p0, p1, p2}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->openBluetooth(Landroidx/fragment/app/FragmentActivity;Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;)V

    return-void

    :cond_b
    new-instance p0, Ljava/lang/UnsupportedOperationException;

    const-string p1, "Super calls with default arguments not supported in this target, function: openBluetooth"

    invoke-direct {p0, p1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method private static final openBluetooth$lambda$5(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V
    .registers 3

    const-string v0, "$tmp0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-interface {p0, p1}, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method private static final openBluetooth$lambda$6(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V
    .registers 3

    const-string v0, "$tmp0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-interface {p0, p1}, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method private final openProfile()V
    .registers 5

    iget-boolean v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isBluetoothSupported:Z

    if-nez v0, :cond_1d

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bluetoothStateCallbacks:Ljava/util/ArrayList;

    check-cast v0, Ljava/lang/Iterable;

    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_c
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1c

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;

    invoke-interface {v1}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;->onBluetoothNotSupported()V

    goto :goto_c

    :cond_1c
    return-void

    :cond_1d
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mBluetoothAdapter:Landroid/bluetooth/BluetoothAdapter;

    if-eqz v0, :cond_2f

    iget-object v1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mContext:Landroid/content/Context;

    new-instance v2, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$openProfile$2;

    invoke-direct {v2, p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$openProfile$2;-><init>(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V

    check-cast v2, Landroid/bluetooth/BluetoothProfile$ServiceListener;

    iget v3, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mProfile:I

    invoke-virtual {v0, v1, v2, v3}, Landroid/bluetooth/BluetoothAdapter;->getProfileProxy(Landroid/content/Context;Landroid/bluetooth/BluetoothProfile$ServiceListener;I)Z

    :cond_2f
    return-void
.end method

.method private static final requestEnableLocationService$lambda$9(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V
    .registers 3

    const-string v0, "$tmp0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-interface {p0, p1}, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method private final startClassicScan(Landroidx/fragment/app/FragmentActivity;)V
    .registers 5

    iget-boolean v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isBluetoothSupported:Z

    if-nez v0, :cond_1d

    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bluetoothStateCallbacks:Ljava/util/ArrayList;

    check-cast p1, Ljava/lang/Iterable;

    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_c
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1c

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;

    invoke-interface {v0}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;->onBluetoothNotSupported()V

    goto :goto_c

    :cond_1c
    return-void

    :cond_1d
    invoke-static {p1}, Lcom/permissionx/guolindev/PermissionX;->init(Landroidx/fragment/app/FragmentActivity;)Lcom/permissionx/guolindev/PermissionMediator;

    move-result-object p1

    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x1f

    if-lt v1, v2, :cond_2d

    const-string v1, "android.permission.BLUETOOTH_SCAN"

    goto :goto_2f

    :cond_2d
    const-string v1, "android.permission.ACCESS_FINE_LOCATION"

    :goto_2f
    const/4 v2, 0x0

    aput-object v1, v0, v2

    invoke-virtual {p1, v0}, Lcom/permissionx/guolindev/PermissionMediator;->permissions([Ljava/lang/String;)Lcom/permissionx/guolindev/request/PermissionBuilder;

    move-result-object p1

    new-instance v0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$$ExternalSyntheticLambda0;

    invoke-direct {v0, p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$$ExternalSyntheticLambda0;-><init>(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V

    invoke-virtual {p1, v0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->request(Lcom/permissionx/guolindev/callback/RequestCallback;)V

    return-void
.end method

.method private static final startClassicScan$lambda$16(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;ZLjava/util/List;Ljava/util/List;)V
    .registers 5

    const-string v0, "this$0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "<anonymous parameter 1>"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p2, "<anonymous parameter 2>"

    invoke-static {p3, p2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    if-eqz p1, :cond_27

    iget-object p0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mBluetoothAdapter:Landroid/bluetooth/BluetoothAdapter;

    if-eqz p0, :cond_41

    invoke-virtual {p0}, Landroid/bluetooth/BluetoothAdapter;->isDiscovering()Z

    move-result p1

    if-eqz p1, :cond_23

    const-string p1, "\u53d6\u6d88\u4e4b\u524d\u7684\u626b\u63cf"

    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logd(Ljava/lang/String;)V

    invoke-virtual {p0}, Landroid/bluetooth/BluetoothAdapter;->cancelDiscovery()Z

    :cond_23
    invoke-virtual {p0}, Landroid/bluetooth/BluetoothAdapter;->startDiscovery()Z

    goto :goto_41

    :cond_27
    iget-object p0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->scanDeviceCallbacks:Ljava/util/ArrayList;

    check-cast p0, Ljava/lang/Iterable;

    invoke-interface {p0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :goto_2f
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result p1

    if-eqz p1, :cond_41

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;

    const/16 p2, 0x9

    invoke-interface {p1, p2}, Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;->onScanFailed(I)V

    goto :goto_2f

    :cond_41
    :goto_41
    return-void
.end method

.method private final startLeScan()V
    .registers 8

    iget-boolean v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isBluetoothSupported:Z

    if-nez v0, :cond_1d

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bluetoothStateCallbacks:Ljava/util/ArrayList;

    check-cast v0, Ljava/lang/Iterable;

    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_c
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1c

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;

    invoke-interface {v1}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;->onBluetoothNotSupported()V

    goto :goto_c

    :cond_1c
    return-void

    :cond_1d
    iget-boolean v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->inScanning:Z

    if-eqz v0, :cond_27

    const-string v0, "\u5df2\u7ecf\u5728\u626b\u63cf\u4e2d\u4e86"

    invoke-static {v0}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logw(Ljava/lang/String;)V

    return-void

    :cond_27
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->inScanning:Z

    iget v1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->scanMode:I

    const-wide/16 v2, 0x1f4

    const/4 v4, 0x2

    if-ne v1, v4, :cond_3d

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mBluetoothAdapter:Landroid/bluetooth/BluetoothAdapter;

    if-eqz v0, :cond_7f

    invoke-direct {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->getLeScanCallback()Landroid/bluetooth/BluetoothAdapter$LeScanCallback;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/bluetooth/BluetoothAdapter;->startLeScan(Landroid/bluetooth/BluetoothAdapter$LeScanCallback;)Z

    goto :goto_7f

    :cond_3d
    new-instance v1, Landroid/bluetooth/le/ScanSettings$Builder;

    invoke-direct {v1}, Landroid/bluetooth/le/ScanSettings$Builder;-><init>()V

    iget v5, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->scanMode:I

    const/4 v6, 0x3

    if-eq v5, v6, :cond_51

    const/4 v6, 0x4

    if-eq v5, v6, :cond_4f

    const/4 v6, 0x5

    if-eq v5, v6, :cond_52

    move v0, v4

    goto :goto_52

    :cond_4f
    const/4 v0, 0x0

    goto :goto_52

    :cond_51
    const/4 v0, -0x1

    :cond_52
    :goto_52
    invoke-virtual {v1, v0}, Landroid/bluetooth/le/ScanSettings$Builder;->setScanMode(I)Landroid/bluetooth/le/ScanSettings$Builder;

    iget v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->scanMode:I

    if-ne v0, v4, :cond_5f

    const-wide/16 v4, 0x0

    invoke-virtual {v1, v4, v5}, Landroid/bluetooth/le/ScanSettings$Builder;->setReportDelay(J)Landroid/bluetooth/le/ScanSettings$Builder;

    goto :goto_66

    :cond_5f
    const-wide/16 v2, 0x3e8

    invoke-virtual {v1, v2, v3}, Landroid/bluetooth/le/ScanSettings$Builder;->setReportDelay(J)Landroid/bluetooth/le/ScanSettings$Builder;

    const-wide/16 v2, 0x1388

    :goto_66
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mBluetoothAdapter:Landroid/bluetooth/BluetoothAdapter;

    if-eqz v0, :cond_7f

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothAdapter;->getBluetoothLeScanner()Landroid/bluetooth/le/BluetoothLeScanner;

    move-result-object v0

    if-eqz v0, :cond_7f

    invoke-static {}, Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;

    move-result-object v4

    invoke-virtual {v1}, Landroid/bluetooth/le/ScanSettings$Builder;->build()Landroid/bluetooth/le/ScanSettings;

    move-result-object v1

    iget-object v5, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->scanCallback:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$scanCallback$1;

    check-cast v5, Landroid/bluetooth/le/ScanCallback;

    invoke-virtual {v0, v4, v1, v5}, Landroid/bluetooth/le/BluetoothLeScanner;->startScan(Ljava/util/List;Landroid/bluetooth/le/ScanSettings;Landroid/bluetooth/le/ScanCallback;)V

    :cond_7f
    :goto_7f
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->scanDeviceCallbacks:Ljava/util/ArrayList;

    check-cast v0, Ljava/lang/Iterable;

    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_87
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_97

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;

    invoke-interface {v1}, Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;->onScanStarted()V

    goto :goto_87

    :cond_97
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1f

    if-ge v0, v1, :cond_a8

    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->getMWorkHandler()Landroid/os/Handler;

    move-result-object v0

    invoke-direct {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->getCheckLocationServiceEnabledRunnable()Ljava/lang/Runnable;

    move-result-object v1

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    :cond_a8
    return-void
.end method

.method private final startLeScan(Landroidx/fragment/app/FragmentActivity;)V
    .registers 5

    iget-boolean v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isBluetoothSupported:Z

    if-nez v0, :cond_1d

    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bluetoothStateCallbacks:Ljava/util/ArrayList;

    check-cast p1, Ljava/lang/Iterable;

    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_c
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1c

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;

    invoke-interface {v0}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;->onBluetoothNotSupported()V

    goto :goto_c

    :cond_1c
    return-void

    :cond_1d
    invoke-static {p1}, Lcom/permissionx/guolindev/PermissionX;->init(Landroidx/fragment/app/FragmentActivity;)Lcom/permissionx/guolindev/PermissionMediator;

    move-result-object p1

    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x1f

    if-lt v1, v2, :cond_2d

    const-string v1, "android.permission.BLUETOOTH_SCAN"

    goto :goto_2f

    :cond_2d
    const-string v1, "android.permission.ACCESS_FINE_LOCATION"

    :goto_2f
    const/4 v2, 0x0

    aput-object v1, v0, v2

    invoke-virtual {p1, v0}, Lcom/permissionx/guolindev/PermissionMediator;->permissions([Ljava/lang/String;)Lcom/permissionx/guolindev/request/PermissionBuilder;

    move-result-object p1

    new-instance v0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$$ExternalSyntheticLambda1;

    invoke-direct {v0, p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$$ExternalSyntheticLambda1;-><init>(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V

    invoke-virtual {p1, v0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->request(Lcom/permissionx/guolindev/callback/RequestCallback;)V

    return-void
.end method

.method private static final startLeScan$lambda$19(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;ZLjava/util/List;Ljava/util/List;)V
    .registers 5

    const-string v0, "this$0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "<anonymous parameter 1>"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p2, "<anonymous parameter 2>"

    invoke-static {p3, p2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    if-eqz p1, :cond_15

    invoke-direct {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->startLeScan()V

    goto :goto_2f

    :cond_15
    iget-object p0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->scanDeviceCallbacks:Ljava/util/ArrayList;

    check-cast p0, Ljava/lang/Iterable;

    invoke-interface {p0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :goto_1d
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result p1

    if-eqz p1, :cond_2f

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;

    const/16 p2, 0x9

    invoke-interface {p1, p2}, Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;->onScanFailed(I)V

    goto :goto_1d

    :cond_2f
    :goto_2f
    return-void
.end method


# virtual methods
.method public final closeBluetooth()Z
    .registers 4

    iget-boolean v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isBluetoothSupported:Z

    const/4 v1, 0x1

    if-nez v0, :cond_1e

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bluetoothStateCallbacks:Ljava/util/ArrayList;

    check-cast v0, Ljava/lang/Iterable;

    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_d
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1d

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;

    invoke-interface {v2}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;->onBluetoothNotSupported()V

    goto :goto_d

    :cond_1d
    return v1

    :cond_1e
    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isBluetoothEnabled()Z

    move-result v0

    if-nez v0, :cond_2a

    const-string v0, "\u7cfb\u7edf\u84dd\u7259\u672a\u5f00\u542f\uff0c\u65e0\u9700\u5173\u95ed"

    invoke-static {v0}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logw(Ljava/lang/String;)V

    return v1

    :cond_2a
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mBluetoothAdapter:Landroid/bluetooth/BluetoothAdapter;

    if-eqz v0, :cond_33

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothAdapter;->disable()Z

    move-result v0

    goto :goto_34

    :cond_33
    const/4 v0, 0x0

    :goto_34
    return v0
.end method

.method public final createBond(Landroid/bluetooth/BluetoothDevice;)V
    .registers 5

    const-string v0, "device"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    iget-boolean v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isBluetoothSupported:Z

    if-nez v0, :cond_22

    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bluetoothStateCallbacks:Ljava/util/ArrayList;

    check-cast p1, Ljava/lang/Iterable;

    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_11
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_21

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;

    invoke-interface {v0}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;->onBluetoothNotSupported()V

    goto :goto_11

    :cond_21
    return-void

    :cond_22
    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->stopScan()V

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->getRemoteDevice(Ljava/lang/String;)Landroid/bluetooth/BluetoothDevice;

    move-result-object v0

    iput-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mBluetoothDevice:Landroid/bluetooth/BluetoothDevice;

    const/4 v1, 0x0

    if-eqz v0, :cond_bd

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object p1

    const-string v2, "it.address"

    invoke-static {p1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0, p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isDeviceBonded(Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_79

    const/4 p1, 0x1

    iput-boolean p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->continueCreateBond:Z

    new-instance p1, Ljava/lang/StringBuilder;

    const-string v1, "\u5df2\u6709"

    invoke-direct {p1, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    const/16 v1, 0x28

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    const-string v1, ")\u7684\u914d\u5bf9\u4fe1\u606f\uff0c\u9700\u8981\u5148\u53d6\u6d88\u914d\u5bf9"

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logi(Ljava/lang/String;)V

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object p1

    invoke-static {p1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p0, p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->removeBond(Ljava/lang/String;)V

    return-void

    :cond_79
    invoke-virtual {v0}, Landroid/bluetooth/BluetoothDevice;->createBond()Z

    move-result p1

    if-eqz p1, :cond_a5

    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bondStateCallbacks:Ljava/util/ArrayList;

    check-cast p1, Ljava/lang/Iterable;

    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_87
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_97

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/flydigi/sdk/bluetooth/BondStateCallback;

    invoke-interface {v1, v0}, Lcom/flydigi/sdk/bluetooth/BondStateCallback;->onCreateBondStart(Landroid/bluetooth/BluetoothDevice;)V

    goto :goto_87

    :cond_97
    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->getMMainHandler()Landroid/os/Handler;

    move-result-object p1

    invoke-direct {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->getCreateBondTimeoutRunnable()Ljava/lang/Runnable;

    move-result-object v0

    const-wide/16 v1, 0x3a98

    invoke-virtual {p1, v0, v1, v2}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_d5

    :cond_a5
    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bondStateCallbacks:Ljava/util/ArrayList;

    check-cast p1, Ljava/lang/Iterable;

    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_ad
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_d5

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/flydigi/sdk/bluetooth/BondStateCallback;

    invoke-interface {v2, v0, v1}, Lcom/flydigi/sdk/bluetooth/BondStateCallback;->onCreateBondResult(Landroid/bluetooth/BluetoothDevice;Z)V

    goto :goto_ad

    :cond_bd
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bondStateCallbacks:Ljava/util/ArrayList;

    check-cast v0, Ljava/lang/Iterable;

    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_c5
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_d5

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/flydigi/sdk/bluetooth/BondStateCallback;

    invoke-interface {v2, p1, v1}, Lcom/flydigi/sdk/bluetooth/BondStateCallback;->onCreateBondResult(Landroid/bluetooth/BluetoothDevice;Z)V

    goto :goto_c5

    :cond_d5
    :goto_d5
    return-void
.end method

.method public final getBondedDevice()Ljava/util/List;
    .registers 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Landroid/bluetooth/BluetoothDevice;",
            ">;"
        }
    .end annotation

    iget-boolean v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isBluetoothSupported:Z

    if-nez v0, :cond_21

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bluetoothStateCallbacks:Ljava/util/ArrayList;

    check-cast v0, Ljava/lang/Iterable;

    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_c
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1c

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;

    invoke-interface {v1}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;->onBluetoothNotSupported()V

    goto :goto_c

    :cond_1c
    invoke-static {}, Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;

    move-result-object v0

    return-object v0

    :cond_21
    invoke-static {}, Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;

    move-result-object v0

    iget-object v1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mBluetoothAdapter:Landroid/bluetooth/BluetoothAdapter;

    if-eqz v1, :cond_58

    invoke-virtual {v1}, Landroid/bluetooth/BluetoothAdapter;->getBondedDevices()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_31
    :goto_31
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_58

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/bluetooth/BluetoothDevice;

    iget-object v3, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->deviceFilter:Lcom/flydigi/sdk/bluetooth/DeviceFilter;

    invoke-virtual {v2}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x2

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-static {v3, v4, v7, v5, v6}, Lcom/flydigi/sdk/bluetooth/DeviceFilter$DefaultImpls;->isValidDevice$default(Lcom/flydigi/sdk/bluetooth/DeviceFilter;Ljava/lang/String;IILjava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_31

    check-cast v0, Ljava/util/Collection;

    const-string v3, "device"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {v0, v2}, Lkotlin/collections/CollectionsKt;->plus(Ljava/util/Collection;Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    goto :goto_31

    :cond_58
    return-object v0
.end method

.method protected final getChipType()I
    .registers 2

    iget v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->chipType:I

    return v0
.end method

.method public final getConnectedDevices(Ljava/lang/Boolean;)Ljava/util/List;
    .registers 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Boolean;",
            ")",
            "Ljava/util/List<",
            "Landroid/bluetooth/BluetoothDevice;",
            ">;"
        }
    .end annotation

    iget-boolean v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isBluetoothSupported:Z

    if-nez v0, :cond_21

    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bluetoothStateCallbacks:Ljava/util/ArrayList;

    check-cast p1, Ljava/lang/Iterable;

    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_c
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1c

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;

    invoke-interface {v0}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;->onBluetoothNotSupported()V

    goto :goto_c

    :cond_1c
    invoke-static {}, Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;

    move-result-object p1

    return-object p1

    :cond_21
    invoke-static {}, Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;

    move-result-object v0

    iget-object v1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mBluetoothManager:Landroid/bluetooth/BluetoothManager;

    const-string v2, "device"

    const/4 v3, 0x0

    const/4 v4, 0x2

    const/4 v5, 0x0

    if-eqz v1, :cond_8c

    const/4 v6, 0x7

    invoke-virtual {v1, v6}, Landroid/bluetooth/BluetoothManager;->getConnectedDevices(I)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_37
    :goto_37
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_8c

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/bluetooth/BluetoothDevice;

    iget-object v7, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->deviceFilter:Lcom/flydigi/sdk/bluetooth/DeviceFilter;

    invoke-virtual {v6}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8, v5, v4, v3}, Lcom/flydigi/sdk/bluetooth/DeviceFilter$DefaultImpls;->isValidDevice$default(Lcom/flydigi/sdk/bluetooth/DeviceFilter;Ljava/lang/String;IILjava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_37

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "find bluetooth "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logd(Ljava/lang/String;)V

    const/4 v7, 0x1

    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v7

    invoke-static {p1, v7}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_82

    invoke-virtual {v6}, Landroid/bluetooth/BluetoothDevice;->getBondState()I

    move-result v7

    const/16 v8, 0xc

    if-ne v7, v8, :cond_37

    check-cast v0, Ljava/util/Collection;

    invoke-static {v6, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {v0, v6}, Lkotlin/collections/CollectionsKt;->plus(Ljava/util/Collection;Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    goto :goto_37

    :cond_82
    check-cast v0, Ljava/util/Collection;

    invoke-static {v6, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {v0, v6}, Lkotlin/collections/CollectionsKt;->plus(Ljava/util/Collection;Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    goto :goto_37

    :cond_8c
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result p1

    if-eqz p1, :cond_ee

    :try_start_92
    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mProxy:Landroid/bluetooth/BluetoothProfile;

    if-eqz p1, :cond_ee

    invoke-interface {p1}, Landroid/bluetooth/BluetoothProfile;->getConnectedDevices()Ljava/util/List;

    move-result-object p1

    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :cond_9e
    :goto_9e
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_ee

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/bluetooth/BluetoothDevice;

    iget-object v6, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->deviceFilter:Lcom/flydigi/sdk/bluetooth/DeviceFilter;

    invoke-virtual {v1}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7, v5, v4, v3}, Lcom/flydigi/sdk/bluetooth/DeviceFilter$DefaultImpls;->isValidDevice$default(Lcom/flydigi/sdk/bluetooth/DeviceFilter;Ljava/lang/String;IILjava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_9e

    move-object v6, v0

    check-cast v6, Ljava/util/Collection;

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {v6, v1}, Lkotlin/collections/CollectionsKt;->plus(Ljava/util/Collection;Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0
    :try_end_c0
    .catch Ljava/lang/Exception; {:try_start_92 .. :try_end_c0} :catch_c1

    goto :goto_9e

    :catch_c1
    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->getBondedDevice()Ljava/util/List;

    move-result-object p1

    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :cond_c9
    :goto_c9
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_ee

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/bluetooth/BluetoothDevice;

    iget-object v2, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->deviceFilter:Lcom/flydigi/sdk/bluetooth/DeviceFilter;

    invoke-virtual {v1}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-static {v2, v6, v5, v4, v3}, Lcom/flydigi/sdk/bluetooth/DeviceFilter$DefaultImpls;->isValidDevice$default(Lcom/flydigi/sdk/bluetooth/DeviceFilter;Ljava/lang/String;IILjava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_c9

    invoke-virtual {p0, v1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isConnected(Landroid/bluetooth/BluetoothDevice;)Z

    move-result v2

    if-eqz v2, :cond_c9

    check-cast v0, Ljava/util/Collection;

    invoke-static {v0, v1}, Lkotlin/collections/CollectionsKt;->plus(Ljava/util/Collection;Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    goto :goto_c9

    :cond_ee
    return-object v0
.end method

.method public final getConnectionState(Landroid/bluetooth/BluetoothDevice;)I
    .registers 4

    const-string v0, "device"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    iget-boolean v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isBluetoothSupported:Z

    const/4 v1, 0x0

    if-nez v0, :cond_23

    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bluetoothStateCallbacks:Ljava/util/ArrayList;

    check-cast p1, Ljava/lang/Iterable;

    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_12
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_22

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;

    invoke-interface {v0}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;->onBluetoothNotSupported()V

    goto :goto_12

    :cond_22
    return v1

    :cond_23
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mBluetoothManager:Landroid/bluetooth/BluetoothManager;

    if-eqz v0, :cond_2d

    const/4 v1, 0x7

    invoke-virtual {v0, p1, v1}, Landroid/bluetooth/BluetoothManager;->getConnectionState(Landroid/bluetooth/BluetoothDevice;I)I

    move-result v1

    goto :goto_35

    :cond_2d
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mProxy:Landroid/bluetooth/BluetoothProfile;

    if-eqz v0, :cond_35

    invoke-interface {v0, p1}, Landroid/bluetooth/BluetoothProfile;->getConnectionState(Landroid/bluetooth/BluetoothDevice;)I

    move-result v1

    :cond_35
    :goto_35
    return v1
.end method

.method protected final getDeviceFilter()Lcom/flydigi/sdk/bluetooth/DeviceFilter;
    .registers 2

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->deviceFilter:Lcom/flydigi/sdk/bluetooth/DeviceFilter;

    return-object v0
.end method

.method protected final getInOtaMode()Z
    .registers 2

    iget-boolean v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->inOtaMode:Z

    return v0
.end method

.method protected final getMBluetoothDevice()Landroid/bluetooth/BluetoothDevice;
    .registers 2

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mBluetoothDevice:Landroid/bluetooth/BluetoothDevice;

    return-object v0
.end method

.method protected final getMContext()Landroid/content/Context;
    .registers 2

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method protected final getMMainHandler()Landroid/os/Handler;
    .registers 2

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mMainHandler:Landroid/os/Handler;

    if-eqz v0, :cond_5

    return-object v0

    :cond_5
    const-string v0, "mMainHandler"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 v0, 0x0

    return-object v0
.end method

.method protected final getMWorkHandler()Landroid/os/Handler;
    .registers 2

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mWorkHandler:Landroid/os/Handler;

    if-eqz v0, :cond_5

    return-object v0

    :cond_5
    const-string v0, "mWorkHandler"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 v0, 0x0

    return-object v0
.end method

.method public final getRemoteDevice(Ljava/lang/String;)Landroid/bluetooth/BluetoothDevice;
    .registers 3

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mBluetoothAdapter:Landroid/bluetooth/BluetoothAdapter;

    if-eqz v0, :cond_9

    invoke-virtual {v0, p1}, Landroid/bluetooth/BluetoothAdapter;->getRemoteDevice(Ljava/lang/String;)Landroid/bluetooth/BluetoothDevice;

    move-result-object p1

    goto :goto_a

    :cond_9
    const/4 p1, 0x0

    :goto_a
    return-object p1
.end method

.method public final isAccessFineLocationPermissionGranted()Z
    .registers 3

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mContext:Landroid/content/Context;

    const-string v1, "android.permission.ACCESS_FINE_LOCATION"

    invoke-static {v0, v1}, Landroidx/core/content/ContextCompat;->checkSelfPermission(Landroid/content/Context;Ljava/lang/String;)I

    move-result v0

    if-eqz v0, :cond_17

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mContext:Landroid/content/Context;

    const-string v1, "android.permission.BLUETOOTH_SCAN"

    invoke-static {v0, v1}, Landroidx/core/content/ContextCompat;->checkSelfPermission(Landroid/content/Context;Ljava/lang/String;)I

    move-result v0

    if-nez v0, :cond_15

    goto :goto_17

    :cond_15
    const/4 v0, 0x0

    goto :goto_18

    :cond_17
    :goto_17
    const/4 v0, 0x1

    :goto_18
    return v0
.end method

.method public final isBluetoothEnabled()Z
    .registers 4

    iget-boolean v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isBluetoothSupported:Z

    const/4 v1, 0x0

    if-nez v0, :cond_1e

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bluetoothStateCallbacks:Ljava/util/ArrayList;

    check-cast v0, Ljava/lang/Iterable;

    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_d
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1d

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;

    invoke-interface {v2}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;->onBluetoothNotSupported()V

    goto :goto_d

    :cond_1d
    return v1

    :cond_1e
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mBluetoothAdapter:Landroid/bluetooth/BluetoothAdapter;

    if-eqz v0, :cond_27

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothAdapter;->isEnabled()Z

    move-result v0

    return v0

    :cond_27
    return v1
.end method

.method public final isBluetoothSupported()Z
    .registers 2

    iget-boolean v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isBluetoothSupported:Z

    return v0
.end method

.method public final isConnected(Landroid/bluetooth/BluetoothDevice;)Z
    .registers 6

    const-string v0, "<this>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-class v0, Landroid/bluetooth/BluetoothDevice;

    const/4 v1, 0x0

    new-array v2, v1, [Ljava/lang/Class;

    const-string v3, "isConnected"

    invoke-virtual {v0, v3, v2}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Ljava/lang/reflect/Method;->setAccessible(Z)V

    new-array v1, v1, [Ljava/lang/Object;

    invoke-virtual {v0, p1, v1}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    const-string v0, "null cannot be cast to non-null type kotlin.Boolean"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p1, Ljava/lang/Boolean;

    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result p1

    return p1
.end method

.method public final isDeviceConnected(Landroid/bluetooth/BluetoothDevice;)Z
    .registers 8

    iget-boolean v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isBluetoothSupported:Z

    const/4 v1, 0x0

    if-nez v0, :cond_1e

    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bluetoothStateCallbacks:Ljava/util/ArrayList;

    check-cast p1, Ljava/lang/Iterable;

    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_d
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1d

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;

    invoke-interface {v0}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;->onBluetoothNotSupported()V

    goto :goto_d

    :cond_1d
    return v1

    :cond_1e
    const/4 v0, 0x1

    const/4 v2, 0x0

    :try_start_20
    invoke-static {p0, v2, v0, v2}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->getConnectedDevices$default(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;Ljava/lang/Boolean;ILjava/lang/Object;)Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_28
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_47

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/bluetooth/BluetoothDevice;

    if-eqz p1, :cond_3b

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v5

    goto :goto_3c

    :cond_3b
    move-object v5, v2

    :goto_3c
    invoke-virtual {v4}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v4

    invoke-static {v5, v4}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v4
    :try_end_44
    .catch Ljava/lang/Exception; {:try_start_20 .. :try_end_44} :catch_47

    if-eqz v4, :cond_28

    return v0

    :catch_47
    :cond_47
    return v1
.end method

.method public final isDeviceConnected(Ljava/lang/String;)Z
    .registers 2

    invoke-virtual {p0, p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->getRemoteDevice(Ljava/lang/String;)Landroid/bluetooth/BluetoothDevice;

    move-result-object p1

    invoke-virtual {p0, p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isDeviceConnected(Landroid/bluetooth/BluetoothDevice;)Z

    move-result p1

    return p1
.end method

.method public final isDeviceNameExist(Landroid/bluetooth/BluetoothDevice;)Z
    .registers 3

    const-string v0, "<this>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object p1

    check-cast p1, Ljava/lang/CharSequence;

    const/4 v0, 0x1

    if-eqz p1, :cond_17

    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result p1

    if-nez p1, :cond_15

    goto :goto_17

    :cond_15
    const/4 p1, 0x0

    goto :goto_18

    :cond_17
    :goto_17
    move p1, v0

    :goto_18
    xor-int/2addr p1, v0

    return p1
.end method

.method protected onBluetoothDisabled()V
    .registers 4

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bluetoothStateCallbacks:Ljava/util/ArrayList;

    check-cast v0, Ljava/lang/Iterable;

    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_8
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_19

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;

    const/4 v2, 0x0

    invoke-interface {v1, v2}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;->onBluetoothState(Z)V

    goto :goto_8

    :cond_19
    return-void
.end method

.method protected onDeviceConnected(Landroid/bluetooth/BluetoothDevice;)V
    .registers 4

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->connectionStateCallbacks:Ljava/util/ArrayList;

    check-cast v0, Ljava/lang/Iterable;

    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_8
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_18

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/flydigi/sdk/bluetooth/ConnectionStateCallback;

    invoke-interface {v1, p1}, Lcom/flydigi/sdk/bluetooth/ConnectionStateCallback;->onDeviceConnected(Landroid/bluetooth/BluetoothDevice;)V

    goto :goto_8

    :cond_18
    return-void
.end method

.method protected onDeviceDisconnected(Landroid/bluetooth/BluetoothDevice;)V
    .registers 4

    const/4 v0, -0x1

    iput v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->chipType:I

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->connectionStateCallbacks:Ljava/util/ArrayList;

    check-cast v0, Ljava/lang/Iterable;

    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_b
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1b

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/flydigi/sdk/bluetooth/ConnectionStateCallback;

    invoke-interface {v1, p1}, Lcom/flydigi/sdk/bluetooth/ConnectionStateCallback;->onDeviceDisconnected(Landroid/bluetooth/BluetoothDevice;)V

    goto :goto_b

    :cond_1b
    return-void
.end method

.method public final openBluetooth(Landroidx/fragment/app/Fragment;Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;)V
    .registers 4

    const-string v0, "fragment"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p1}, Landroidx/fragment/app/Fragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object p1

    if-eqz p1, :cond_e

    invoke-virtual {p0, p1, p2}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->openBluetooth(Landroidx/fragment/app/FragmentActivity;Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;)V

    :cond_e
    return-void
.end method

.method public final openBluetooth(Landroidx/fragment/app/FragmentActivity;Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;)V
    .registers 5

    const-string v0, "activity"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    iget-boolean v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isBluetoothSupported:Z

    if-nez v0, :cond_22

    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bluetoothStateCallbacks:Ljava/util/ArrayList;

    check-cast p1, Ljava/lang/Iterable;

    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_11
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result p2

    if-eqz p2, :cond_21

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;

    invoke-interface {p2}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;->onBluetoothNotSupported()V

    goto :goto_11

    :cond_21
    return-void

    :cond_22
    check-cast p1, Landroid/app/Activity;

    invoke-static {p1}, Lrx_activity_result2/RxActivityResult;->on(Landroid/app/Activity;)Lrx_activity_result2/RxActivityResult$Builder;

    move-result-object p1

    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.bluetooth.adapter.action.REQUEST_ENABLE"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1, v0}, Lrx_activity_result2/RxActivityResult$Builder;->startIntent(Landroid/content/Intent;)Lio/reactivex/Observable;

    move-result-object p1

    new-instance v0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$openBluetooth$disposable$1;

    invoke-direct {v0, p0, p2}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$openBluetooth$disposable$1;-><init>(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;)V

    check-cast v0, Lkotlin/jvm/functions/Function1;

    new-instance p2, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$$ExternalSyntheticLambda3;

    invoke-direct {p2, v0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$$ExternalSyntheticLambda3;-><init>(Lkotlin/jvm/functions/Function1;)V

    new-instance v0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$openBluetooth$disposable$2;

    invoke-direct {v0, p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$openBluetooth$disposable$2;-><init>(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V

    check-cast v0, Lkotlin/jvm/functions/Function1;

    new-instance v1, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$$ExternalSyntheticLambda4;

    invoke-direct {v1, v0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$$ExternalSyntheticLambda4;-><init>(Lkotlin/jvm/functions/Function1;)V

    invoke-virtual {p1, p2, v1}, Lio/reactivex/Observable;->subscribe(Lio/reactivex/functions/Consumer;Lio/reactivex/functions/Consumer;)Lio/reactivex/disposables/Disposable;

    return-void
.end method

.method public register(Ljava/lang/Object;)V
    .registers 3

    const-string v0, "obj"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    instance-of v0, p1, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;

    if-eqz v0, :cond_16

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bluetoothStateCallbacks:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_16

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bluetoothStateCallbacks:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_16
    instance-of v0, p1, Lcom/flydigi/sdk/bluetooth/ConnectionStateCallback;

    if-eqz v0, :cond_27

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->connectionStateCallbacks:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_27

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->connectionStateCallbacks:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_27
    instance-of v0, p1, Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;

    if-eqz v0, :cond_38

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->scanDeviceCallbacks:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_38

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->scanDeviceCallbacks:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_38
    instance-of v0, p1, Lcom/flydigi/sdk/bluetooth/BondStateCallback;

    if-eqz v0, :cond_49

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bondStateCallbacks:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_49

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bondStateCallbacks:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_49
    return-void
.end method

.method public final removeBond(Landroid/bluetooth/BluetoothDevice;)V
    .registers 7

    const-string v0, "device"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    iget-boolean v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isBluetoothSupported:Z

    if-nez v0, :cond_22

    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bluetoothStateCallbacks:Ljava/util/ArrayList;

    check-cast p1, Ljava/lang/Iterable;

    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_11
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_21

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;

    invoke-interface {v0}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;->onBluetoothNotSupported()V

    goto :goto_11

    :cond_21
    return-void

    :cond_22
    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getBondState()I

    move-result v0

    const/16 v1, 0xc

    const/4 v2, 0x0

    if-eq v0, v1, :cond_44

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bondStateCallbacks:Ljava/util/ArrayList;

    check-cast v0, Ljava/lang/Iterable;

    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_33
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_43

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/flydigi/sdk/bluetooth/BondStateCallback;

    invoke-interface {v1, p1, v2}, Lcom/flydigi/sdk/bluetooth/BondStateCallback;->onRemoveBondResult(Landroid/bluetooth/BluetoothDevice;Z)V

    goto :goto_33

    :cond_43
    return-void

    :cond_44
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bondStateCallbacks:Ljava/util/ArrayList;

    check-cast v0, Ljava/lang/Iterable;

    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_4c
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_5c

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/flydigi/sdk/bluetooth/BondStateCallback;

    invoke-interface {v1, p1}, Lcom/flydigi/sdk/bluetooth/BondStateCallback;->onRemoveBondStart(Landroid/bluetooth/BluetoothDevice;)V

    goto :goto_4c

    :cond_5c
    invoke-virtual {p0, p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isDeviceConnected(Landroid/bluetooth/BluetoothDevice;)Z

    move-result v0

    const/4 v1, 0x1

    if-eqz v0, :cond_68

    invoke-direct {p0, p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->disconnectDevice(Landroid/bluetooth/BluetoothDevice;)Z

    move-result v0

    goto :goto_69

    :cond_68
    move v0, v1

    :goto_69
    if-eqz v0, :cond_c9

    :try_start_6b
    const-class v0, Landroid/bluetooth/BluetoothDevice;

    const-string v3, "removeBond"

    new-array v4, v2, [Ljava/lang/Class;

    invoke-virtual {v0, v3, v4}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/reflect/Method;->setAccessible(Z)V

    new-array v1, v2, [Ljava/lang/Object;

    invoke-virtual {v0, p1, v1}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    const-string v1, "null cannot be cast to non-null type kotlin.Boolean"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_99

    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->getMMainHandler()Landroid/os/Handler;

    move-result-object v0

    invoke-direct {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->getRemoveBondTimeoutRunnable()Ljava/lang/Runnable;

    move-result-object v1

    const-wide/16 v3, 0x3a98

    invoke-virtual {v0, v1, v3, v4}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_c9

    :cond_99
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bondStateCallbacks:Ljava/util/ArrayList;

    check-cast v0, Ljava/lang/Iterable;

    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_a1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_c9

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/flydigi/sdk/bluetooth/BondStateCallback;

    invoke-interface {v1, p1, v2}, Lcom/flydigi/sdk/bluetooth/BondStateCallback;->onRemoveBondResult(Landroid/bluetooth/BluetoothDevice;Z)V
    :try_end_b0
    .catch Ljava/lang/Exception; {:try_start_6b .. :try_end_b0} :catch_b1

    goto :goto_a1

    :catch_b1
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bondStateCallbacks:Ljava/util/ArrayList;

    check-cast v0, Ljava/lang/Iterable;

    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_b9
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_c9

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/flydigi/sdk/bluetooth/BondStateCallback;

    invoke-interface {v1, p1, v2}, Lcom/flydigi/sdk/bluetooth/BondStateCallback;->onRemoveBondResult(Landroid/bluetooth/BluetoothDevice;Z)V

    goto :goto_b9

    :cond_c9
    :goto_c9
    return-void
.end method

.method public final removeBond(Ljava/lang/String;)V
    .registers 3

    const-string v0, "deviceMac"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p0, p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->getRemoteDevice(Ljava/lang/String;)Landroid/bluetooth/BluetoothDevice;

    move-result-object p1

    if-eqz p1, :cond_e

    invoke-virtual {p0, p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->removeBond(Landroid/bluetooth/BluetoothDevice;)V

    :cond_e
    return-void
.end method

.method public final requestEnableLocationService(Landroid/app/Activity;)Lio/reactivex/disposables/Disposable;
    .registers 4

    const-string v0, "activity"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {p1}, Lrx_activity_result2/RxActivityResult;->on(Landroid/app/Activity;)Lrx_activity_result2/RxActivityResult$Builder;

    move-result-object p1

    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.settings.LOCATION_SOURCE_SETTINGS"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1, v0}, Lrx_activity_result2/RxActivityResult$Builder;->startIntent(Landroid/content/Intent;)Lio/reactivex/Observable;

    move-result-object p1

    new-instance v0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$requestEnableLocationService$1;

    invoke-direct {v0, p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$requestEnableLocationService$1;-><init>(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V

    check-cast v0, Lkotlin/jvm/functions/Function1;

    new-instance v1, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$$ExternalSyntheticLambda2;

    invoke-direct {v1, v0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$$ExternalSyntheticLambda2;-><init>(Lkotlin/jvm/functions/Function1;)V

    invoke-virtual {p1, v1}, Lio/reactivex/Observable;->subscribe(Lio/reactivex/functions/Consumer;)Lio/reactivex/disposables/Disposable;

    move-result-object p1

    const-string v0, "fun requestEnableLocatio\u2026true)\n            }\n    }"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    return-object p1
.end method

.method protected reset()V
    .registers 3

    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->getMMainHandler()Landroid/os/Handler;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->getMWorkHandler()Landroid/os/Handler;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    iput-object v1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mBluetoothDevice:Landroid/bluetooth/BluetoothDevice;

    return-void
.end method

.method protected final setChipType(I)V
    .registers 2

    iput p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->chipType:I

    return-void
.end method

.method protected final setInOtaMode(Z)V
    .registers 2

    iput-boolean p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->inOtaMode:Z

    return-void
.end method

.method protected final setMBluetoothDevice(Landroid/bluetooth/BluetoothDevice;)V
    .registers 2

    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mBluetoothDevice:Landroid/bluetooth/BluetoothDevice;

    return-void
.end method

.method protected final setMMainHandler(Landroid/os/Handler;)V
    .registers 3

    const-string v0, "<set-?>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mMainHandler:Landroid/os/Handler;

    return-void
.end method

.method protected final setMWorkHandler(Landroid/os/Handler;)V
    .registers 3

    const-string v0, "<set-?>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mWorkHandler:Landroid/os/Handler;

    return-void
.end method

.method public final startScan(Landroidx/fragment/app/Fragment;I)V
    .registers 4

    const-string v0, "fragment"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p1}, Landroidx/fragment/app/Fragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object p1

    const-string v0, "fragment.requireActivity()"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p0, p1, p2}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->startScan(Landroidx/fragment/app/FragmentActivity;I)V

    return-void
.end method

.method public final startScan(Landroidx/fragment/app/FragmentActivity;I)V
    .registers 5

    const-string v0, "activity"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    iget-boolean v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isBluetoothSupported:Z

    if-nez v0, :cond_21

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bluetoothStateCallbacks:Ljava/util/ArrayList;

    check-cast v0, Ljava/lang/Iterable;

    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_21

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;

    invoke-interface {p1}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;->onBluetoothNotSupported()V

    return-void

    :cond_21
    iput p2, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->scanMode:I

    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isBluetoothEnabled()Z

    move-result v0

    if-nez v0, :cond_34

    new-instance v0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$startScan$2;

    invoke-direct {v0, p0, p1, p2}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$startScan$2;-><init>(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;Landroidx/fragment/app/FragmentActivity;I)V

    check-cast v0, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;

    invoke-virtual {p0, p1, v0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->openBluetooth(Landroidx/fragment/app/FragmentActivity;Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;)V

    goto :goto_3e

    :cond_34
    const/4 v0, 0x1

    if-ne p2, v0, :cond_3b

    invoke-direct {p0, p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->startClassicScan(Landroidx/fragment/app/FragmentActivity;)V

    goto :goto_3e

    :cond_3b
    invoke-direct {p0, p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->startLeScan(Landroidx/fragment/app/FragmentActivity;)V

    :goto_3e
    return-void
.end method

.method public final stopScan()V
    .registers 3

    iget-boolean v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isBluetoothSupported:Z

    if-nez v0, :cond_1d

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bluetoothStateCallbacks:Ljava/util/ArrayList;

    check-cast v0, Ljava/lang/Iterable;

    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_c
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1c

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;

    invoke-interface {v1}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;->onBluetoothNotSupported()V

    goto :goto_c

    :cond_1c
    return-void

    :cond_1d
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->inScanning:Z

    const-string v0, "\u505c\u6b62\u626b\u63cf"

    invoke-static {v0}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logd(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mBluetoothAdapter:Landroid/bluetooth/BluetoothAdapter;

    if-eqz v0, :cond_32

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothAdapter;->isDiscovering()Z

    move-result v1

    if-eqz v1, :cond_32

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothAdapter;->cancelDiscovery()Z

    :cond_32
    iget v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->scanMode:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_43

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mBluetoothAdapter:Landroid/bluetooth/BluetoothAdapter;

    if-eqz v0, :cond_54

    invoke-direct {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->getLeScanCallback()Landroid/bluetooth/BluetoothAdapter$LeScanCallback;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/bluetooth/BluetoothAdapter;->stopLeScan(Landroid/bluetooth/BluetoothAdapter$LeScanCallback;)V

    goto :goto_54

    :cond_43
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->mBluetoothAdapter:Landroid/bluetooth/BluetoothAdapter;

    if-eqz v0, :cond_54

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothAdapter;->getBluetoothLeScanner()Landroid/bluetooth/le/BluetoothLeScanner;

    move-result-object v0

    if-eqz v0, :cond_54

    iget-object v1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->scanCallback:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$scanCallback$1;

    check-cast v1, Landroid/bluetooth/le/ScanCallback;

    invoke-virtual {v0, v1}, Landroid/bluetooth/le/BluetoothLeScanner;->stopScan(Landroid/bluetooth/le/ScanCallback;)V

    :cond_54
    :goto_54
    return-void
.end method

.method public unregister(Ljava/lang/Object;)V
    .registers 3

    const-string v0, "obj"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    instance-of v0, p1, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;

    if-eqz v0, :cond_16

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bluetoothStateCallbacks:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_16

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bluetoothStateCallbacks:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    :cond_16
    instance-of v0, p1, Lcom/flydigi/sdk/bluetooth/ConnectionStateCallback;

    if-eqz v0, :cond_27

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->connectionStateCallbacks:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_27

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->connectionStateCallbacks:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    :cond_27
    instance-of v0, p1, Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;

    if-eqz v0, :cond_38

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->scanDeviceCallbacks:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_38

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->scanDeviceCallbacks:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    :cond_38
    instance-of v0, p1, Lcom/flydigi/sdk/bluetooth/BondStateCallback;

    if-eqz v0, :cond_49

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bondStateCallbacks:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_49

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bondStateCallbacks:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    :cond_49
    return-void
.end method
