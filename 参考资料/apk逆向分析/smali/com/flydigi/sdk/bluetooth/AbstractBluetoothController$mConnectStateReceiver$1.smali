.class public final Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mConnectStateReceiver$1;
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

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\u0008"
    }
    d2 = {
        "com/flydigi/sdk/bluetooth/AbstractBluetoothController$mConnectStateReceiver$1",
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

    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mConnectStateReceiver$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    .line 223
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .registers 8

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p1, "intent"

    invoke-static {p2, p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p1, "android.bluetooth.device.extra.DEVICE"

    .line 225
    invoke-virtual {p2, p1}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Landroid/bluetooth/BluetoothDevice;

    const/4 v0, 0x0

    if-eqz p1, :cond_10d

    .line 228
    iget-object v1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mConnectStateReceiver$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    invoke-virtual {v1, p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isDeviceNameExist(Landroid/bluetooth/BluetoothDevice;)Z

    move-result v1

    if-eqz v1, :cond_10d

    .line 229
    iget-object v1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mConnectStateReceiver$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    invoke-virtual {v1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->getDeviceFilter()Lcom/flydigi/sdk/bluetooth/DeviceFilter;

    move-result-object v1

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    const/4 v4, 0x2

    invoke-static {v1, v2, v3, v4, v0}, Lcom/flydigi/sdk/bluetooth/DeviceFilter$DefaultImpls;->isValidDevice$default(Lcom/flydigi/sdk/bluetooth/DeviceFilter;Ljava/lang/String;IILjava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_10d

    .line 230
    iget-object v1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mConnectStateReceiver$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    invoke-virtual {v1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->getMBluetoothDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v1

    if-eqz v1, :cond_45

    iget-object v1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mConnectStateReceiver$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    invoke-virtual {v1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->getMBluetoothDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v1

    invoke-static {p1, v1}, Landroidx/core/util/ObjectsCompat;->equals(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_45

    goto/16 :goto_10d

    .line 236
    :cond_45
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_10c

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v1

    const v2, -0x11f77b4b

    const-string v3, "[Broadcast] Action received: device:"

    if-eq v1, v2, :cond_d2

    const v2, 0x42f3be3f

    if-eq v1, v2, :cond_92

    const p2, 0x6c9330ef

    if-eq v1, p2, :cond_62

    goto/16 :goto_10c

    :cond_62
    const-string p2, "android.bluetooth.device.action.ACL_DISCONNECTED"

    invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p2

    if-nez p2, :cond_6c

    goto/16 :goto_10c

    .line 243
    :cond_6c
    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p2

    const-string v0, " android.bluetooth.device.action.ACL_DISCONNECTED "

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p2

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-static {p2}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logi(Ljava/lang/String;)V

    .line 244
    iget-object p2, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mConnectStateReceiver$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    invoke-virtual {p2, p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->onDeviceDisconnected(Landroid/bluetooth/BluetoothDevice;)V

    .line 245
    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mConnectStateReceiver$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    invoke-virtual {p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->reset()V

    goto/16 :goto_10c

    :cond_92
    const-string v1, "android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED"

    .line 236
    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_9b

    goto :goto_10c

    .line 248
    :cond_9b
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logi(Ljava/lang/String;)V

    const-string v0, "android.bluetooth.adapter.extra.CONNECTION_STATE"

    const/4 v1, -0x1

    .line 250
    invoke-virtual {p2, v0, v1}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result p2

    if-eqz p2, :cond_c7

    if-eq p2, v4, :cond_c1

    goto :goto_10c

    .line 252
    :cond_c1
    iget-object p2, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mConnectStateReceiver$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    invoke-virtual {p2, p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->onDeviceConnected(Landroid/bluetooth/BluetoothDevice;)V

    goto :goto_10c

    .line 254
    :cond_c7
    iget-object p2, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mConnectStateReceiver$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    invoke-virtual {p2, p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->onDeviceDisconnected(Landroid/bluetooth/BluetoothDevice;)V

    .line 255
    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mConnectStateReceiver$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    invoke-virtual {p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->reset()V

    goto :goto_10c

    :cond_d2
    const-string p2, "android.bluetooth.device.action.ACL_CONNECTED"

    .line 236
    invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p2

    if-eqz p2, :cond_10c

    const-string p2, "RX.ACL"
    const-string v0, "ACL_CONNECTED"
    invoke-static {p2, v0}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logFile(Ljava/lang/String;Ljava/lang/String;)V

    .line 238
    iget-object p2, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mConnectStateReceiver$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    invoke-virtual {p2, p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->setMBluetoothDevice(Landroid/bluetooth/BluetoothDevice;)V

    .line 239
    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p2

    const-string v0, " android.bluetooth.device.action.ACL_CONNECTED connectionStateCallback.size:"

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p2

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mConnectStateReceiver$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    # getter for: Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->connectionStateCallbacks:Ljava/util/ArrayList;
    invoke-static {v0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->access$getConnectionStateCallbacks$p(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p2

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-static {p2}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logi(Ljava/lang/String;)V

    .line 240
    iget-object p2, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mConnectStateReceiver$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    invoke-virtual {p2}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->stopScan()V

    iget-object p2, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mConnectStateReceiver$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    invoke-virtual {p2, p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->onDeviceConnected(Landroid/bluetooth/BluetoothDevice;)V

    :cond_10c
    :goto_10c
    return-void

    .line 232
    :cond_10d
    :goto_10d
    new-instance p2, Ljava/lang/StringBuilder;

    const-string v1, "skip other device["

    invoke-direct {p2, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    if-eqz p1, :cond_11a

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v0

    :cond_11a
    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    const/16 p2, 0x5d

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logi(Ljava/lang/String;)V

    return-void
.end method
