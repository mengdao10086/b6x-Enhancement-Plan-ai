.class public final Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback$DefaultImpls;
.super Ljava/lang/Object;
.source "BluetoothCallback.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "DefaultImpls"
.end annotation

.annotation runtime Lkotlin/Metadata;
    k = 0x3
    mv = {
        0x1,
        0x8,
        0x0
    }
    xi = 0x30
.end annotation


# direct methods
.method public static onBluetoothNotSupported(Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;)V
    .registers 1

    return-void
.end method

.method public static onBluetoothOpenDeny(Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;)V
    .registers 1

    return-void
.end method

.method public static onBluetoothOpenFailed(Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;)V
    .registers 1

    return-void
.end method

.method public static onBluetoothProfileOpened(Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;I)V
    .registers 2

    return-void
.end method

.method public static onBluetoothState(Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;Z)V
    .registers 2

    if-eqz p1, :cond_8

    const-string p0, "\u84dd\u7259\u5df2\u6253\u5f00"

    .line 21
    invoke-static {p0}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logi(Ljava/lang/String;)V

    goto :goto_d

    :cond_8
    const-string p0, "\u84dd\u7259\u5df2\u5173\u95ed"

    .line 23
    invoke-static {p0}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logi(Ljava/lang/String;)V

    :goto_d
    return-void
.end method
