.class public final Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mClassicScanReceiver$1;
.super Landroid/content/BroadcastReceiver;
.source "AbstractBluetoothController.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;-><init>(Landroid/content/Context;Lcom/flydigi/sdk/bluetooth/DeviceFilter;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nAbstractBluetoothController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractBluetoothController.kt\ncom/flydigi/sdk/bluetooth/AbstractBluetoothController$mClassicScanReceiver$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1116:1\n1855#2,2:1117\n1855#2,2:1119\n*S KotlinDebug\n*F\n+ 1 AbstractBluetoothController.kt\ncom/flydigi/sdk/bluetooth/AbstractBluetoothController$mClassicScanReceiver$1\n*L\n88#1:1117,2\n91#1:1119,2\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\u0008"
    }
    d2 = {
        "com/flydigi/sdk/bluetooth/AbstractBluetoothController$mClassicScanReceiver$1",
        "Landroid/content/BroadcastReceiver;",
        "onReceive",
        "",
        "context",
        "Landroid/content/Context;",
        "intent",
        "Landroid/content/Intent;",
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


# instance fields
.field final synthetic this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;


# direct methods
.method constructor <init>(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V
    .registers 2

    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mClassicScanReceiver$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    .line 82
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .registers 10

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p1, "intent"

    invoke-static {p2, p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p1, "android.bluetooth.device.extra.DEVICE"

    .line 84
    invoke-virtual {p2, p1}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object p1

    move-object v1, p1

    check-cast v1, Landroid/bluetooth/BluetoothDevice;

    const-string p1, "android.bluetooth.device.extra.NAME"

    .line 85
    invoke-virtual {p2, p1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string p1, "android.bluetooth.device.extra.RSSI"

    const/16 v0, -0x64

    .line 86
    invoke-virtual {p2, p1, v0}, Landroid/content/Intent;->getShortExtra(Ljava/lang/String;S)S

    move-result v3

    .line 87
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object p1

    if-eqz p1, :cond_a4

    invoke-virtual {p1}, Ljava/lang/String;->hashCode()I

    move-result p2

    const v0, -0x6a269925

    if-eq p2, v0, :cond_7f

    const v0, 0x6724d8

    if-eq p2, v0, :cond_5b

    const v0, 0x459717c3

    if-eq p2, v0, :cond_3b

    goto :goto_a4

    :cond_3b
    const-string p2, "android.bluetooth.device.action.FOUND"

    invoke-virtual {p1, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_44

    goto :goto_a4

    :cond_44
    if-eqz v1, :cond_a4

    .line 95
    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mClassicScanReceiver$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    .line 98
    new-instance p2, Lcom/flydigi/sdk/bluetooth/data/BleDevice;

    const/4 v4, 0x0

    .line 103
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    move-object v0, p2

    .line 98
    invoke-direct/range {v0 .. v6}, Lcom/flydigi/sdk/bluetooth/data/BleDevice;-><init>(Landroid/bluetooth/BluetoothDevice;Ljava/lang/String;I[BJ)V

    .line 97
    invoke-static {p2}, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;

    move-result-object p2

    .line 96
    # invokes: Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->onDeviceFound(Ljava/util/List;)V
    invoke-static {p1, p2}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->access$onDeviceFound(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;Ljava/util/List;)V

    goto :goto_a4

    :cond_5b
    const-string p2, "android.bluetooth.adapter.action.DISCOVERY_STARTED"

    .line 87
    invoke-virtual {p1, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_a4

    .line 88
    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mClassicScanReceiver$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    # getter for: Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->scanDeviceCallbacks:Ljava/util/ArrayList;
    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->access$getScanDeviceCallbacks$p(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)Ljava/util/ArrayList;

    move-result-object p1

    check-cast p1, Ljava/lang/Iterable;

    .line 1117
    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_6f
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result p2

    if-eqz p2, :cond_a4

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;

    .line 89
    invoke-interface {p2}, Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;->onScanStarted()V

    goto :goto_6f

    :cond_7f
    const-string p2, "android.bluetooth.adapter.action.DISCOVERY_FINISHED"

    .line 87
    invoke-virtual {p1, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_88

    goto :goto_a4

    .line 91
    :cond_88
    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mClassicScanReceiver$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    # getter for: Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->scanDeviceCallbacks:Ljava/util/ArrayList;
    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->access$getScanDeviceCallbacks$p(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)Ljava/util/ArrayList;

    move-result-object p1

    check-cast p1, Ljava/lang/Iterable;

    .line 1119
    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_94
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result p2

    if-eqz p2, :cond_a4

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;

    .line 92
    invoke-interface {p2}, Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;->onScanStopped()V

    goto :goto_94

    :cond_a4
    :goto_a4
    return-void
.end method
