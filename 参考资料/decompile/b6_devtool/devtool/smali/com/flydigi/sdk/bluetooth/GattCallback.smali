.class public interface abstract Lcom/flydigi/sdk/bluetooth/GattCallback;
.super Ljava/lang/Object;
.source "GattCallback.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/flydigi/sdk/bluetooth/GattCallback$DefaultImpls;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0008\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u000c\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016\u00a8\u0006\u000f"
    }
    d2 = {
        "Lcom/flydigi/sdk/bluetooth/GattCallback;",
        "",
        "onGattConnectFailed",
        "",
        "device",
        "Landroid/bluetooth/BluetoothDevice;",
        "onGattConnectTimeout",
        "onGattConnected",
        "onGattConnecting",
        "onGattDisconnected",
        "gatt",
        "Landroid/bluetooth/BluetoothGatt;",
        "onReadRemoteRssi",
        "rssi",
        "",
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
.method public abstract onGattConnectFailed(Landroid/bluetooth/BluetoothDevice;)V
.end method

.method public abstract onGattConnectTimeout(Landroid/bluetooth/BluetoothDevice;)V
.end method

.method public abstract onGattConnected(Landroid/bluetooth/BluetoothDevice;)V
.end method

.method public abstract onGattConnecting(Landroid/bluetooth/BluetoothDevice;)V
.end method

.method public abstract onGattDisconnected(Landroid/bluetooth/BluetoothGatt;)V
.end method

.method public abstract onReadRemoteRssi(I)V
.end method
