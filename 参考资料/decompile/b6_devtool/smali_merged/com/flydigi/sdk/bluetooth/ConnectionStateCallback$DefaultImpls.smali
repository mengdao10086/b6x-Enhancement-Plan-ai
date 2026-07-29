.class public final Lcom/flydigi/sdk/bluetooth/ConnectionStateCallback$DefaultImpls;
.super Ljava/lang/Object;
.source "BluetoothCallback.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/flydigi/sdk/bluetooth/ConnectionStateCallback;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "DefaultImpls"
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nBluetoothCallback.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BluetoothCallback.kt\ncom/flydigi/sdk/bluetooth/ConnectionStateCallback$DefaultImpls\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,129:1\n1#2:130\n*E\n"
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
.method public static onDeviceConnected(Lcom/flydigi/sdk/bluetooth/ConnectionStateCallback;Landroid/bluetooth/BluetoothDevice;)V
    .registers 3

    if-eqz p1, :cond_2c

    .line 122
    new-instance p0, Ljava/lang/StringBuilder;

    const-string v0, "\u4e0e"

    invoke-direct {p0, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    const/16 v0, 0x28

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    const-string p1, ")\u8fde\u63a5\u6210\u529f"

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-static {p0}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logi(Ljava/lang/String;)V

    :cond_2c
    return-void
.end method

.method public static onDeviceDisconnected(Lcom/flydigi/sdk/bluetooth/ConnectionStateCallback;Landroid/bluetooth/BluetoothDevice;)V
    .registers 3

    if-eqz p1, :cond_2c

    .line 126
    new-instance p0, Ljava/lang/StringBuilder;

    const-string v0, "\u4e0e"

    invoke-direct {p0, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    const/16 v0, 0x28

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    const-string p1, ")\u65ad\u5f00\u8fde\u63a5"

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-static {p0}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logi(Ljava/lang/String;)V

    :cond_2c
    return-void
.end method
