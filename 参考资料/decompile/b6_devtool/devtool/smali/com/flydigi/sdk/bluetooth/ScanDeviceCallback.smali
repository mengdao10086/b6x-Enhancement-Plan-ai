.class public interface abstract Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;
.super Ljava/lang/Object;
.source "BluetoothCallback.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback$DefaultImpls;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\tH\u0016J\u0008\u0010\n\u001a\u00020\u0003H\u0016J\u0008\u0010\u000b\u001a\u00020\u0003H\u0016\u00a8\u0006\u000c"
    }
    d2 = {
        "Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;",
        "",
        "onDeviceFound",
        "",
        "devices",
        "",
        "Lcom/flydigi/sdk/bluetooth/data/BleDevice;",
        "onScanFailed",
        "errorCode",
        "",
        "onScanStarted",
        "onScanStopped",
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
.method public abstract onDeviceFound(Ljava/util/List;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lcom/flydigi/sdk/bluetooth/data/BleDevice;",
            ">;)V"
        }
    .end annotation
.end method

.method public abstract onScanFailed(I)V
.end method

.method public abstract onScanStarted()V
.end method

.method public abstract onScanStopped()V
.end method
