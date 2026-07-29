.class public Lcom/flydigi/sdk/bluetooth/UUIDReceiver;
.super Landroid/content/BroadcastReceiver;
.source "UUIDReceiver.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/flydigi/sdk/bluetooth/UUIDReceiver$UUIDListener;
    }
.end annotation


# instance fields
.field private final mDevice:Landroid/bluetooth/BluetoothDevice;

.field private final mListener:Lcom/flydigi/sdk/bluetooth/UUIDReceiver$UUIDListener;


# direct methods
.method public constructor <init>(Lcom/flydigi/sdk/bluetooth/UUIDReceiver$UUIDListener;Landroid/bluetooth/BluetoothDevice;)V
    .registers 3

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/UUIDReceiver;->mListener:Lcom/flydigi/sdk/bluetooth/UUIDReceiver$UUIDListener;

    iput-object p2, p0, Lcom/flydigi/sdk/bluetooth/UUIDReceiver;->mDevice:Landroid/bluetooth/BluetoothDevice;

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .registers 6

    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object p1

    if-eqz p1, :cond_3f

    const-string v0, "android.bluetooth.device.action.UUID"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_3f

    const-string p1, "android.bluetooth.device.extra.DEVICE"

    invoke-virtual {p2, p1}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Landroid/bluetooth/BluetoothDevice;

    const-string v0, "android.bluetooth.device.extra.UUID"

    invoke-virtual {p2, v0}, Landroid/content/Intent;->getParcelableArrayExtra(Ljava/lang/String;)[Landroid/os/Parcelable;

    move-result-object p2

    if-eqz p1, :cond_3f

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/UUIDReceiver;->mDevice:Landroid/bluetooth/BluetoothDevice;

    if-eqz v0, :cond_3f

    invoke-virtual {v0, p1}, Landroid/bluetooth/BluetoothDevice;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3f

    if-eqz p2, :cond_3f

    array-length v0, p2

    new-array v0, v0, [Landroid/os/ParcelUuid;

    const/4 v1, 0x0

    :goto_2e
    array-length v2, p2

    if-ge v1, v2, :cond_3a

    aget-object v2, p2, v1

    check-cast v2, Landroid/os/ParcelUuid;

    aput-object v2, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_2e

    :cond_3a
    iget-object p2, p0, Lcom/flydigi/sdk/bluetooth/UUIDReceiver;->mListener:Lcom/flydigi/sdk/bluetooth/UUIDReceiver$UUIDListener;

    invoke-interface {p2, p1, v0}, Lcom/flydigi/sdk/bluetooth/UUIDReceiver$UUIDListener;->onUUIDFound(Landroid/bluetooth/BluetoothDevice;[Landroid/os/ParcelUuid;)V

    :cond_3f
    return-void
.end method
