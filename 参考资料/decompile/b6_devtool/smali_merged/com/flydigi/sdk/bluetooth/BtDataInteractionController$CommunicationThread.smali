.class public final Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;
.super Ljava/lang/Thread;
.source "BtDataInteractionController.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "CommunicationThread"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0012\n\u0000\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000c\u001a\u00020\rJ\u0008\u0010\u000e\u001a\u00020\rH\u0002J\u0008\u0010\u000f\u001a\u00020\rH\u0016J\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"
    }
    d2 = {
        "Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;",
        "Ljava/lang/Thread;",
        "socket",
        "Landroid/bluetooth/BluetoothSocket;",
        "(Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;Landroid/bluetooth/BluetoothSocket;)V",
        "mInputStream",
        "Ljava/io/InputStream;",
        "kotlin.jvm.PlatformType",
        "mIsRunning",
        "",
        "mOutputStream",
        "Ljava/io/OutputStream;",
        "cancel",
        "",
        "listenStream",
        "run",
        "sendStream",
        "data",
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
.field private final mInputStream:Ljava/io/InputStream;

.field private mIsRunning:Z

.field private final mOutputStream:Ljava/io/OutputStream;

.field private final socket:Landroid/bluetooth/BluetoothSocket;

.field final synthetic this$0:Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;


# direct methods
.method public constructor <init>(Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;Landroid/bluetooth/BluetoothSocket;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/bluetooth/BluetoothSocket;",
            ")V"
        }
    .end annotation

    const-string v0, "socket"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 132
    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;->this$0:Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;

    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    iput-object p2, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;->socket:Landroid/bluetooth/BluetoothSocket;

    .line 134
    invoke-virtual {p2}, Landroid/bluetooth/BluetoothSocket;->getInputStream()Ljava/io/InputStream;

    move-result-object p1

    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;->mInputStream:Ljava/io/InputStream;

    .line 135
    invoke-virtual {p2}, Landroid/bluetooth/BluetoothSocket;->getOutputStream()Ljava/io/OutputStream;

    move-result-object p1

    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;->mOutputStream:Ljava/io/OutputStream;

    return-void
.end method

.method private final listenStream()V
    .registers 5

    const/high16 v0, 0x100000

    new-array v0, v0, [B

    const/4 v1, 0x1

    .line 163
    iput-boolean v1, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;->mIsRunning:Z

    .line 165
    :cond_7
    :goto_7
    iget-object v1, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;->this$0:Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;

    invoke-virtual {v1}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->getMDataConnectState()I

    move-result v1

    const/4 v2, 0x2

    if-ne v1, v2, :cond_46

    iget-boolean v1, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;->mIsRunning:Z

    if-eqz v1, :cond_46

    const/4 v1, 0x0

    .line 168
    :try_start_15
    iget-object v3, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;->mInputStream:Ljava/io/InputStream;

    invoke-virtual {v3, v0}, Ljava/io/InputStream;->read([B)I

    move-result v2
    :try_end_1b
    .catch Ljava/lang/Exception; {:try_start_15 .. :try_end_1b} :catch_2c

    if-lez v2, :cond_7

    .line 179
    new-array v3, v2, [B

    .line 180
    invoke-static {v0, v1, v3, v1, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 182
    iget-object v1, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;->this$0:Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;

    invoke-virtual {v1}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->getServiceUUID()Ljava/util/UUID;

    move-result-object v2

    invoke-virtual {v1, v2, v3}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->onReceiveDataFromDevice(Ljava/util/UUID;[B)V

    goto :goto_7

    :catch_2c
    const-string v0, "listenStream occur exception"

    .line 170
    invoke-static {v0}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logw(Ljava/lang/String;)V

    .line 171
    iput-boolean v1, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;->mIsRunning:Z

    .line 172
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;->this$0:Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;

    invoke-virtual {v0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->getMDataConnectState()I

    move-result v0

    if-ne v0, v2, :cond_40

    .line 173
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;->this$0:Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;

    invoke-virtual {v0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->onConnectionLost()V

    .line 175
    :cond_40
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;->this$0:Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->access$setMCommunicationThread$p(Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;)V

    :cond_46
    return-void
.end method


# virtual methods
.method public final cancel()V
    .registers 1

    .line 224
    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;->interrupt()V

    return-void
.end method

.method public run()V
    .registers 2

    .line 138
    invoke-super {p0}, Ljava/lang/Thread;->run()V

    .line 139
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;->mInputStream:Ljava/io/InputStream;

    if-nez v0, :cond_12

    const-string v0, "mInputStream is null"

    .line 140
    invoke-static {v0}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logw(Ljava/lang/String;)V

    .line 141
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;->this$0:Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;

    # invokes: Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->disconnect()V
    invoke-static {v0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->access$disconnect(Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;)V

    return-void

    .line 145
    :cond_12
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;->mOutputStream:Ljava/io/OutputStream;

    if-nez v0, :cond_21

    const-string v0, "mOutputStream is null"

    .line 146
    invoke-static {v0}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logw(Ljava/lang/String;)V

    .line 147
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;->this$0:Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;

    # invokes: Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->disconnect()V
    invoke-static {v0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->access$disconnect(Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;)V

    return-void

    .line 151
    :cond_21
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;->socket:Landroid/bluetooth/BluetoothSocket;

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothSocket;->isConnected()Z

    move-result v0

    if-nez v0, :cond_34

    const-string v0, "socket is disconnected"

    .line 152
    invoke-static {v0}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logw(Ljava/lang/String;)V

    .line 153
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;->this$0:Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;

    # invokes: Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->disconnect()V
    invoke-static {v0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->access$disconnect(Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;)V

    return-void

    .line 156
    :cond_34
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;->this$0:Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;

    invoke-virtual {v0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->onConnectionEstablished()V

    .line 158
    invoke-direct {p0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;->listenStream()V

    return-void
.end method

.method public final sendStream([B)Z
    .registers 6

    const-string v0, "data"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 188
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "sendStream "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-static {p1, v1, v2, v1}, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionControllerKt;->toHexString$default([BLjava/lang/CharSequence;ILjava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logd(Ljava/lang/String;)V

    .line 189
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;->socket:Landroid/bluetooth/BluetoothSocket;

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothSocket;->isConnected()Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_2c

    const-string p1, "socket is disconnected"

    .line 190
    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logw(Ljava/lang/String;)V

    return v1

    .line 193
    :cond_2c
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;->this$0:Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;

    invoke-virtual {v0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->getMDataConnectState()I

    move-result v0

    const/4 v3, 0x2

    if-eq v0, v3, :cond_3b

    const-string p1, "mGattConnectState = GattState.STATE_GATT_CONNECTED"

    .line 194
    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logw(Ljava/lang/String;)V

    return v1

    .line 197
    :cond_3b
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;->mOutputStream:Ljava/io/OutputStream;

    if-nez v0, :cond_45

    const-string p1, "mOutputStream is null"

    .line 198
    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logw(Ljava/lang/String;)V

    return v1

    .line 202
    :cond_45
    :try_start_45
    invoke-virtual {v0, p1}, Ljava/io/OutputStream;->write([B)V

    .line 215
    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$CommunicationThread;->mOutputStream:Ljava/io/OutputStream;

    invoke-virtual {p1}, Ljava/io/OutputStream;->flush()V
    :try_end_4d
    .catch Ljava/lang/Exception; {:try_start_45 .. :try_end_4d} :catch_4e

    return v2

    :catch_4e
    const-string p1, "mOutputStream occur exception"

    .line 217
    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logw(Ljava/lang/String;)V

    return v1
.end method
