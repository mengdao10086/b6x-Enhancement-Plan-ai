.class public interface abstract Lcom/flydigi/sdk/bluetooth/ConnectionStateCallback;
.super Ljava/lang/Object;
.source "BluetoothCallback.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/flydigi/sdk/bluetooth/ConnectionStateCallback$DefaultImpls;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008f\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\u0007"
    }
    d2 = {
        "Lcom/flydigi/sdk/bluetooth/ConnectionStateCallback;",
        "",
        "onDeviceConnected",
        "",
        "device",
        "Landroid/bluetooth/BluetoothDevice;",
        "onDeviceDisconnected",
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


# virtual methods
.method public abstract onDeviceConnected(Landroid/bluetooth/BluetoothDevice;)V
.end method

.method public abstract onDeviceDisconnected(Landroid/bluetooth/BluetoothDevice;)V
.end method
