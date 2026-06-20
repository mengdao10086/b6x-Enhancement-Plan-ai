.class public final Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$startScan$2;
.super Ljava/lang/Object;
.source "AbstractBluetoothController.kt"

# interfaces
.implements Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->startScan(Landroidx/fragment/app/FragmentActivity;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0006"
    }
    d2 = {
        "com/flydigi/sdk/bluetooth/AbstractBluetoothController$startScan$2",
        "Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;",
        "onBluetoothState",
        "",
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


# instance fields
.field final synthetic $activity:Landroidx/fragment/app/FragmentActivity;

.field final synthetic $scanMode:I

.field final synthetic this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;


# direct methods
.method constructor <init>(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;Landroidx/fragment/app/FragmentActivity;I)V
    .registers 4

    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$startScan$2;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    iput-object p2, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$startScan$2;->$activity:Landroidx/fragment/app/FragmentActivity;

    iput p3, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$startScan$2;->$scanMode:I

    .line 511
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onBluetoothNotSupported()V
    .registers 1

    .line 511
    invoke-static {p0}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback$DefaultImpls;->onBluetoothNotSupported(Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;)V

    return-void
.end method

.method public onBluetoothOpenDeny()V
    .registers 1

    .line 511
    invoke-static {p0}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback$DefaultImpls;->onBluetoothOpenDeny(Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;)V

    return-void
.end method

.method public onBluetoothOpenFailed()V
    .registers 1

    .line 511
    invoke-static {p0}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback$DefaultImpls;->onBluetoothOpenFailed(Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;)V

    return-void
.end method

.method public onBluetoothProfileOpened(I)V
    .registers 2

    .line 511
    invoke-static {p0, p1}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback$DefaultImpls;->onBluetoothProfileOpened(Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;I)V

    return-void
.end method

.method public onBluetoothState(Z)V
    .registers 4

    if-eqz p1, :cond_b

    .line 514
    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$startScan$2;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$startScan$2;->$activity:Landroidx/fragment/app/FragmentActivity;

    iget v1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$startScan$2;->$scanMode:I

    invoke-virtual {p1, v0, v1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->startScan(Landroidx/fragment/app/FragmentActivity;I)V

    :cond_b
    return-void
.end method
