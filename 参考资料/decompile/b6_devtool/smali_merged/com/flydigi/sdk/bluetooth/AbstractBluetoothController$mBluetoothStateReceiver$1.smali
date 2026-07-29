.class public final Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mBluetoothStateReceiver$1;
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
        "\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u00a8\u0006\u000c"
    }
    d2 = {
        "com/flydigi/sdk/bluetooth/AbstractBluetoothController$mBluetoothStateReceiver$1",
        "Landroid/content/BroadcastReceiver;",
        "onReceive",
        "",
        "context",
        "Landroid/content/Context;",
        "intent",
        "Landroid/content/Intent;",
        "state2String",
        "",
        "state",
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
.field final synthetic this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;


# direct methods
.method constructor <init>(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V
    .registers 2

    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mBluetoothStateReceiver$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    .line 117
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method

.method private final state2String(I)Ljava/lang/String;
    .registers 2

    packed-switch p1, :pswitch_data_12

    const-string p1, "\u672a\u77e5\u72b6\u6001"

    goto :goto_11

    :pswitch_6
    const-string p1, "\u6b63\u5728\u5173\u95ed"

    goto :goto_11

    :pswitch_9
    const-string p1, "\u5df2\u6253\u5f00"

    goto :goto_11

    :pswitch_c
    const-string p1, "\u6b63\u5728\u6253\u5f00"

    goto :goto_11

    :pswitch_f
    const-string p1, "\u5df2\u5173\u95ed"

    :goto_11
    return-object p1

    :pswitch_data_12
    .packed-switch 0xa
        :pswitch_f
        :pswitch_c
        :pswitch_9
        :pswitch_6
    .end packed-switch
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .registers 5

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p1, "intent"

    invoke-static {p2, p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p1, "android.bluetooth.adapter.extra.STATE"

    const/4 v0, -0x1

    .line 119
    invoke-virtual {p2, p1, v0}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result p1

    const-string v1, "android.bluetooth.adapter.extra.PREVIOUS_STATE"

    .line 120
    invoke-virtual {p2, v1, v0}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result p2

    .line 123
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "[Broadcast] Action received: android.bluetooth.adapter.action.STATE_CHANGED state changed form "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 124
    invoke-direct {p0, p2}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mBluetoothStateReceiver$1;->state2String(I)Ljava/lang/String;

    move-result-object v1

    .line 123
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " to "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 124
    invoke-direct {p0, p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mBluetoothStateReceiver$1;->state2String(I)Ljava/lang/String;

    move-result-object v1

    .line 123
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 122
    invoke-static {v0}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logd(Ljava/lang/String;)V

    const/16 v0, 0xa

    if-ne p1, v0, :cond_49

    const/16 v0, 0xd

    if-ne p2, v0, :cond_49

    .line 130
    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mBluetoothStateReceiver$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    invoke-virtual {p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->onBluetoothDisabled()V

    goto :goto_56

    :cond_49
    const/16 v0, 0xc

    if-ne p1, v0, :cond_56

    const/16 p1, 0xb

    if-ne p2, p1, :cond_56

    .line 134
    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$mBluetoothStateReceiver$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    # invokes: Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->onBluetoothEnabled()V
    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->access$onBluetoothEnabled(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V

    :cond_56
    :goto_56
    return-void
.end method
