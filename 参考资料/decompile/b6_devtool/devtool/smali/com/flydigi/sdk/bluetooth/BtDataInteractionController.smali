.class public abstract Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;
.super Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;
.source "BtDataInteractionController.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;,
        Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$ConnectThread;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008&\u0018\u00002\u00020\u0001:\u0002!\"B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u0008J\u0008\u0010\u000f\u001a\u00020\u0010H\u0002J\u0008\u0010\u0011\u001a\u00020\u0010H\u0002J\u0006\u0010\u0012\u001a\u00020\u0010J\u0008\u0010\u0013\u001a\u00020\u0010H\u0014J\u0008\u0010\u0014\u001a\u00020\u0010H\u0002J\u0008\u0010\u0015\u001a\u00020\u0010H\u0014J\u0008\u0010\u0016\u001a\u00020\u0010H\u0004J\u0008\u0010\u0017\u001a\u00020\u0010H\u0004J\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0015J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 H\u0014R\u0014\u0010\t\u001a\u0008\u0018\u00010\nR\u00020\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0008\u0018\u00010\u000cR\u00020\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"
    }
    d2 = {
        "Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;",
        "Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;",
        "mContext",
        "Landroid/content/Context;",
        "filter",
        "Lcom/flydigi/sdk/bluetooth/DeviceFilter;",
        "mProfile",
        "",
        "(Landroid/content/Context;Lcom/flydigi/sdk/bluetooth/DeviceFilter;I)V",
        "mCommunicationThread",
        "Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;",
        "mConnectionThread",
        "Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$ConnectThread;",
        "socket",
        "Landroid/bluetooth/BluetoothSocket;",
        "cancelCommunicationThread",
        "",
        "cancelConnectThread",
        "close",
        "connect",
        "disconnect",
        "onConnectionEstablished",
        "onConnectionFailed",
        "onConnectionLost",
        "onReceiveDataFromDevice",
        "uuid",
        "Ljava/util/UUID;",
        "value",
        "",
        "onSocketConnected",
        "writeToBluetoothDevice",
        "pack",
        "Lcom/flydigi/sdk/bluetooth/data/RequestPack;",
        "CommunicationThread",
        "ConnectThread",
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
.field private mCommunicationThread:Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;

.field private mConnectionThread:Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$ConnectThread;

.field private socket:Landroid/bluetooth/BluetoothSocket;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/flydigi/sdk/bluetooth/DeviceFilter;I)V
    .registers 5

    const-string v0, "mContext"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "filter"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0, p1, p2, p3}, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;-><init>(Landroid/content/Context;Lcom/flydigi/sdk/bluetooth/DeviceFilter;I)V

    return-void
.end method

.method public static final synthetic access$disconnect(Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;)V
    .registers 1

    invoke-direct {p0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->disconnect()V

    return-void
.end method

.method public static final synthetic access$setMCommunicationThread$p(Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;)V
    .registers 2

    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->mCommunicationThread:Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;

    return-void
.end method

.method public static final synthetic access$setMConnectionThread$p(Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$ConnectThread;)V
    .registers 2

    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->mConnectionThread:Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$ConnectThread;

    return-void
.end method

.method private final cancelCommunicationThread()V
    .registers 2

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->mCommunicationThread:Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;

    if-eqz v0, :cond_7

    invoke-virtual {v0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;->cancel()V

    :cond_7
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->mCommunicationThread:Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;

    return-void
.end method

.method private final cancelConnectThread()V
    .registers 2

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->mConnectionThread:Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$ConnectThread;

    if-eqz v0, :cond_7

    invoke-virtual {v0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$ConnectThread;->cancel()V

    :cond_7
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->mConnectionThread:Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$ConnectThread;

    return-void
.end method

.method private final disconnect()V
    .registers 2

    invoke-direct {p0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->cancelConnectThread()V

    invoke-direct {p0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->cancelCommunicationThread()V

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->setMDataConnectState(I)V

    return-void
.end method


# virtual methods
.method public final close()V
    .registers 2

    invoke-direct {p0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->disconnect()V

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->socket:Landroid/bluetooth/BluetoothSocket;

    if-eqz v0, :cond_a

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothSocket;->close()V

    :cond_a
    return-void
.end method

.method protected connect()V
    .registers 4

    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->getMBluetoothDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v0

    if-eqz v0, :cond_35

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothDevice;->getType()I

    move-result v1

    const/4 v2, 0x1

    if-eq v1, v2, :cond_1a

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothDevice;->getType()I

    move-result v1

    const/4 v2, 0x3

    if-eq v1, v2, :cond_1a

    const-string v0, "current device is not a valid classic device"

    invoke-static {v0}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logw(Ljava/lang/String;)V

    return-void

    :cond_1a
    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->getServiceUUID()Ljava/util/UUID;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/bluetooth/BluetoothDevice;->createInsecureRfcommSocketToServiceRecord(Ljava/util/UUID;)Landroid/bluetooth/BluetoothSocket;

    move-result-object v0

    if-eqz v0, :cond_35

    const-string v1, "createInsecureRfcommSock\u2026erviceRecord(serviceUUID)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->socket:Landroid/bluetooth/BluetoothSocket;

    new-instance v1, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$ConnectThread;

    invoke-direct {v1, p0, v0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$ConnectThread;-><init>(Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;Landroid/bluetooth/BluetoothSocket;)V

    iput-object v1, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->mConnectionThread:Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$ConnectThread;

    invoke-virtual {v1}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$ConnectThread;->start()V

    :cond_35
    return-void
.end method

.method protected onConnectionEstablished()V
    .registers 1

    return-void
.end method

.method protected final onConnectionFailed()V
    .registers 2

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->setMDataConnectState(I)V

    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->getMBluetoothDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->onDeviceDisconnected(Landroid/bluetooth/BluetoothDevice;)V

    return-void
.end method

.method protected final onConnectionLost()V
    .registers 2

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->setMDataConnectState(I)V

    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->getMBluetoothDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->onDeviceDisconnected(Landroid/bluetooth/BluetoothDevice;)V

    return-void
.end method

.method protected onReceiveDataFromDevice(Ljava/util/UUID;[B)V
    .registers 5

    const-string v0, "uuid"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p1, "value"

    invoke-static {p2, p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    sget-object p1, Lcom/flydigi/sdk/bluetooth/util/Logger;->INSTANCE:Lcom/flydigi/sdk/bluetooth/util/Logger;

    invoke-virtual {p1}, Lcom/flydigi/sdk/bluetooth/util/Logger;->getLogRawData()Z

    move-result p1

    if-eqz p1, :cond_2a

    new-instance p1, Ljava/lang/StringBuilder;

    const-string v0, "onReceiveDataFromDevice:"

    invoke-direct {p1, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const/4 v0, 0x1

    const/4 v1, 0x0

    invoke-static {p2, v1, v0, v1}, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionControllerKt;->toHexString$default([BLjava/lang/CharSequence;ILjava/lang/Object;)Ljava/lang/String;

    move-result-object p2

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logd(Ljava/lang/String;)V

    :cond_2a
    return-void
.end method

.method protected onSocketConnected(Landroid/bluetooth/BluetoothSocket;)V
    .registers 3

    const-string v0, "socket"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "onSocketConnected"

    invoke-static {v0}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logd(Ljava/lang/String;)V

    const/4 v0, 0x2

    invoke-virtual {p0, v0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->setMDataConnectState(I)V

    invoke-direct {p0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->cancelConnectThread()V

    invoke-direct {p0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->cancelCommunicationThread()V

    new-instance v0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;

    invoke-direct {v0, p0, p1}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;-><init>(Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;Landroid/bluetooth/BluetoothSocket;)V

    iput-object v0, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->mCommunicationThread:Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;

    invoke-virtual {v0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;->start()V

    return-void
.end method

.method protected writeToBluetoothDevice(Lcom/flydigi/sdk/bluetooth/data/RequestPack;)V
    .registers 6

    const-string v0, "pack"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->mCommunicationThread:Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;

    const/4 v1, 0x0

    const/4 v2, 0x1

    if-eqz v0, :cond_16

    invoke-virtual {p1}, Lcom/flydigi/sdk/bluetooth/data/RequestPack;->getData()[B

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;->sendStream([B)Z

    move-result v0

    if-ne v0, v2, :cond_16

    move v1, v2

    :cond_16
    const/4 v0, 0x0

    if-eqz v1, :cond_34

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v3, "writeToBluetoothDevice success: "

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/flydigi/sdk/bluetooth/data/RequestPack;->getData()[B

    move-result-object p1

    invoke-static {p1, v0, v2, v0}, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionControllerKt;->toHexString$default([BLjava/lang/CharSequence;ILjava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logi(Ljava/lang/String;)V

    goto :goto_4e

    :cond_34
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v3, "writeToBluetoothDevice failed: "

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/flydigi/sdk/bluetooth/data/RequestPack;->getData()[B

    move-result-object p1

    invoke-static {p1, v0, v2, v0}, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionControllerKt;->toHexString$default([BLjava/lang/CharSequence;ILjava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logw(Ljava/lang/String;)V

    :goto_4e
    return-void
.end method
