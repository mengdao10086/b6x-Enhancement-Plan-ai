.class public final Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback$DefaultImpls;
.super Ljava/lang/Object;
.source "BluetoothCallback.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "DefaultImpls"
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nBluetoothCallback.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BluetoothCallback.kt\ncom/flydigi/sdk/bluetooth/ScanDeviceCallback$DefaultImpls\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,129:1\n1855#2,2:130\n*S KotlinDebug\n*F\n+ 1 BluetoothCallback.kt\ncom/flydigi/sdk/bluetooth/ScanDeviceCallback$DefaultImpls\n*L\n45#1:130,2\n*E\n"
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
.method public static onDeviceFound(Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;Ljava/util/List;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;",
            "Ljava/util/List<",
            "Lcom/flydigi/sdk/bluetooth/data/BleDevice;",
            ">;)V"
        }
    .end annotation

    const-string p0, "devices"

    invoke-static {p1, p0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 45
    check-cast p1, Ljava/lang/Iterable;

    .line 130
    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :goto_b
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result p1

    if-eqz p1, :cond_52

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/flydigi/sdk/bluetooth/data/BleDevice;

    .line 46
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "\u626b\u5230\u8bbe\u5907\uff1a"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v1

    invoke-virtual {v1}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x28

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v1

    invoke-virtual {v1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "),\u4fe1\u53f7\u5f3a\u5ea6\uff1a"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->getRssi()I

    move-result p1

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logi(Ljava/lang/String;)V

    goto :goto_b

    :cond_52
    return-void
.end method

.method public static onScanFailed(Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;I)V
    .registers 3

    .line 41
    new-instance p0, Ljava/lang/StringBuilder;

    const-string v0, "\u626b\u63cf\u5931\u8d25\uff0ccode\uff1a"

    invoke-direct {p0, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-static {p0}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logi(Ljava/lang/String;)V

    return-void
.end method

.method public static onScanStarted(Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;)V
    .registers 1

    const-string p0, "\u5f00\u59cb\u626b\u63cf"

    .line 51
    invoke-static {p0}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logi(Ljava/lang/String;)V

    return-void
.end method

.method public static onScanStopped(Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;)V
    .registers 1

    const-string p0, "\u626b\u63cf\u7ed3\u675f"

    .line 55
    invoke-static {p0}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logi(Ljava/lang/String;)V

    return-void
.end method
