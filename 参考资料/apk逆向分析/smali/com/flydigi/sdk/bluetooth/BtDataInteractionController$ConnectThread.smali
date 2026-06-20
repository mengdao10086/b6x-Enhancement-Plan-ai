.class public final Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$ConnectThread;
.super Ljava/lang/Thread;
.source "BtDataInteractionController.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "ConnectThread"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0008\u0010\u0007\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0008"
    }
    d2 = {
        "Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$ConnectThread;",
        "Ljava/lang/Thread;",
        "socket",
        "Landroid/bluetooth/BluetoothSocket;",
        "(Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;Landroid/bluetooth/BluetoothSocket;)V",
        "cancel",
        "",
        "run",
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

    .line 101
    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$ConnectThread;->this$0:Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;

    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    iput-object p2, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$ConnectThread;->socket:Landroid/bluetooth/BluetoothSocket;

    return-void
.end method


# virtual methods
.method public final cancel()V
    .registers 1

    .line 128
    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$ConnectThread;->interrupt()V

    return-void
.end method

.method public run()V
    .registers 4

    .line 105
    :try_start_0
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$ConnectThread;->this$0:Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;

    invoke-virtual {v0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->stopScan()V

    .line 108
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$ConnectThread;->socket:Landroid/bluetooth/BluetoothSocket;

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothSocket;->connect()V

    const-string v0, "Connect to the remote device through the socket."

    .line 110
    invoke-static {v0}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logi(Ljava/lang/String;)V
    :try_end_f
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_f} :catch_17

    .line 124
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$ConnectThread;->this$0:Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;

    iget-object v1, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$ConnectThread;->socket:Landroid/bluetooth/BluetoothSocket;

    invoke-virtual {v0, v1}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->onSocketConnected(Landroid/bluetooth/BluetoothSocket;)V

    return-void

    :catch_17
    move-exception v0

    .line 112
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Could not connect the client socket:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logw(Ljava/lang/String;)V

    .line 114
    :try_start_2a
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$ConnectThread;->socket:Landroid/bluetooth/BluetoothSocket;

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothSocket;->close()V
    :try_end_2f
    .catch Ljava/lang/Exception; {:try_start_2a .. :try_end_2f} :catch_30

    goto :goto_43

    :catch_30
    move-exception v0

    .line 116
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Could not close the client socket:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logw(Ljava/lang/String;)V

    .line 118
    :goto_43
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$ConnectThread;->this$0:Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;

    invoke-virtual {v0}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->onConnectionFailed()V

    .line 119
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$ConnectThread;->this$0:Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;->access$setMConnectionThread$p(Lcom/flydigi/sdk/bluetooth/BtDataInteractionController;Lcom/flydigi/sdk/bluetooth/BtDataInteractionController$ConnectThread;)V

    return-void
.end method
