.class public interface abstract Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;
.super Ljava/lang/Object;
.source "BluetoothCallback.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback$DefaultImpls;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016J\u0008\u0010\u0004\u001a\u00020\u0003H\u0016J\u0008\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0008H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a8\u0006\u000c"
    }
    d2 = {
        "Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;",
        "",
        "onBluetoothNotSupported",
        "",
        "onBluetoothOpenDeny",
        "onBluetoothOpenFailed",
        "onBluetoothProfileOpened",
        "profile",
        "",
        "onBluetoothState",
        "enabled",
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
.method public abstract onBluetoothNotSupported()V
.end method

.method public abstract onBluetoothOpenDeny()V
.end method

.method public abstract onBluetoothOpenFailed()V
.end method

.method public abstract onBluetoothProfileOpened(I)V
.end method

.method public abstract onBluetoothState(Z)V
.end method
