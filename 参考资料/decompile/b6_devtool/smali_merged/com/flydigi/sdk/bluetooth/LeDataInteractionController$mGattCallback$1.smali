.class public final Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$mGattCallback$1;
.super Landroid/bluetooth/BluetoothGattCallback;
.source "LeDataInteractionController.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;-><init>(Landroid/content/Context;Lcom/flydigi/sdk/bluetooth/DeviceFilter;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nLeDataInteractionController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LeDataInteractionController.kt\ncom/flydigi/sdk/bluetooth/LeDataInteractionController$mGattCallback$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,460:1\n1#2:461\n1855#3,2:462\n*S KotlinDebug\n*F\n+ 1 LeDataInteractionController.kt\ncom/flydigi/sdk/bluetooth/LeDataInteractionController$mGattCallback$1\n*L\n132#1:462,2\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0008\u0006*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u0008\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J$\u0010\u000b\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016J(\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J$\u0010\u0013\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u0014\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u0016\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u0017\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u0018"
    }
    d2 = {
        "com/flydigi/sdk/bluetooth/LeDataInteractionController$mGattCallback$1",
        "Landroid/bluetooth/BluetoothGattCallback;",
        "onCharacteristicChanged",
        "",
        "gatt",
        "Landroid/bluetooth/BluetoothGatt;",
        "characteristic",
        "Landroid/bluetooth/BluetoothGattCharacteristic;",
        "onCharacteristicRead",
        "status",
        "",
        "onCharacteristicWrite",
        "onConnectionStateChange",
        "newState",
        "onDescriptorRead",
        "descriptor",
        "Landroid/bluetooth/BluetoothGattDescriptor;",
        "value",
        "",
        "onDescriptorWrite",
        "onReadRemoteRssi",
        "rssi",
        "onReliableWriteCompleted",
        "onServicesDiscovered",
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
.field final synthetic this$0:Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;


# direct methods
.method constructor <init>(Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;)V
    .registers 2

    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$mGattCallback$1;->this$0:Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;

    .line 41
    invoke-direct {p0}, Landroid/bluetooth/BluetoothGattCallback;-><init>()V

    return-void
.end method


# virtual methods
.method public onCharacteristicChanged(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;)V
    .registers 12

    if-eqz p2, :cond_133

    .line 118
    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$mGattCallback$1;->this$0:Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;

    .line 119
    sget-object v0, Lcom/flydigi/sdk/bluetooth/util/Logger;->INSTANCE:Lcom/flydigi/sdk/bluetooth/util/Logger;

    invoke-virtual {v0}, Lcom/flydigi/sdk/bluetooth/util/Logger;->getLogRawData()Z

    move-result v0

    const-string v1, "it.value"

    const/4 v2, 0x0

    const/4 v3, 0x1

    if-eqz v0, :cond_3b

    .line 120
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v4, "onReceiveDataFromDevice:"

    invoke-direct {v0, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/bluetooth/BluetoothGattCharacteristic;->getValue()[B

    move-result-object v4

    invoke-static {v4, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {v4, v2, v3, v2}, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionControllerKt;->toHexString$default([BLjava/lang/CharSequence;ILjava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, " from "

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p2}, Landroid/bluetooth/BluetoothGattCharacteristic;->getUuid()Ljava/util/UUID;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logd(Ljava/lang/String;)V

    .line 122
    :cond_3b
    # getter for: Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->otaFactory:Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;
    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->access$getOtaFactory$p(Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;)Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;

    move-result-object v0

    if-eqz v0, :cond_4c

    invoke-static {v0, v2, v3, v2}, Lcom/flydigi/sdk/bluetooth/ota/OtaFactory$DefaultImpls;->getOtaCharacteristic$default(Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;Ljava/util/UUID;ILjava/lang/Object;)Landroid/bluetooth/BluetoothGattCharacteristic;

    move-result-object v0

    if-eqz v0, :cond_4c

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothGattCharacteristic;->getUuid()Ljava/util/UUID;

    move-result-object v0

    goto :goto_4d

    :cond_4c
    move-object v0, v2

    :goto_4d
    invoke-virtual {p2}, Landroid/bluetooth/BluetoothGattCharacteristic;->getUuid()Ljava/util/UUID;

    move-result-object v4

    invoke-static {v0, v4}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_112

    .line 123
    invoke-virtual {p2}, Landroid/bluetooth/BluetoothGattCharacteristic;->getValue()[B

    move-result-object p2

    if-eqz p2, :cond_133

    const-string v0, "value"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 124
    # getter for: Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->otaFactory:Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;
    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->access$getOtaFactory$p(Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;)Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;

    move-result-object v0

    const/4 v1, 0x0

    if-eqz v0, :cond_71

    invoke-interface {v0, p2}, Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;->isOtaReady([B)Z

    move-result v0

    if-ne v0, v3, :cond_71

    move v0, v3

    goto :goto_72

    :cond_71
    move v0, v1

    :goto_72
    if-eqz v0, :cond_a7

    .line 125
    # getter for: Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->otaFactory:Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;
    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->access$getOtaFactory$p(Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;)Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;

    move-result-object v0

    if-eqz v0, :cond_133

    invoke-interface {v0}, Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;->requestOtaDataCheckSize()Lkotlin/Pair;

    move-result-object v0

    if-eqz v0, :cond_133

    .line 126
    move-object v2, p1

    check-cast v2, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;

    invoke-virtual {v0}, Lkotlin/Pair;->getFirst()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/UUID;

    invoke-virtual {v0}, Lkotlin/Pair;->getSecond()Ljava/lang/Object;

    move-result-object v0

    move-object v4, v0

    check-cast v4, Ljava/util/List;

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/16 v7, 0xc

    const/4 v8, 0x0

    invoke-static/range {v2 .. v8}, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;->addCommandToQueue$default(Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;Ljava/util/UUID;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Long;ILjava/lang/Object;)V

    .line 127
    # getter for: Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->otaFactory:Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;
    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->access$getOtaFactory$p(Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;)Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;

    move-result-object v0

    if-eqz v0, :cond_a2

    invoke-interface {v0, p2}, Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;->isOtaReady([B)Z

    move-result v1

    :cond_a2
    invoke-static {p1, v1}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->access$setOtaIdle$p(Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;Z)V

    goto/16 :goto_133

    .line 129
    :cond_a7
    # getter for: Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->otaFactory:Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;
    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->access$getOtaFactory$p(Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;)Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;

    move-result-object v0

    if-eqz v0, :cond_b5

    invoke-interface {v0, p2}, Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;->isOtaResultCmd([B)Z

    move-result v0

    if-ne v0, v3, :cond_b5

    move v0, v3

    goto :goto_b6

    :cond_b5
    move v0, v1

    :goto_b6
    if-eqz v0, :cond_f5

    .line 130
    invoke-virtual {p1, v1}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->setInOtaMode(Z)V

    .line 131
    # getter for: Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->otaFactory:Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;
    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->access$getOtaFactory$p(Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;)Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;

    move-result-object v0

    if-eqz v0, :cond_c8

    invoke-interface {v0, p2}, Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;->isOtaSuccess([B)Z

    move-result v0

    if-ne v0, v3, :cond_c8

    goto :goto_c9

    :cond_c8
    move v3, v1

    :goto_c9
    if-eqz v3, :cond_e5

    .line 132
    # getter for: Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->otaCallbacks:Ljava/util/ArrayList;
    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->access$getOtaCallbacks$p(Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;)Ljava/util/ArrayList;

    move-result-object p1

    check-cast p1, Ljava/lang/Iterable;

    .line 462
    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_d5
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result p2

    if-eqz p2, :cond_133

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lcom/flydigi/sdk/bluetooth/ota/OtaCallback;

    .line 132
    invoke-interface {p2}, Lcom/flydigi/sdk/bluetooth/ota/OtaCallback;->onOtaSuccess()V

    goto :goto_d5

    .line 135
    :cond_e5
    sget-object v0, Lcom/flydigi/sdk/bluetooth/ota/OtaStatus;->ERR_OTA_FAILED:Lcom/flydigi/sdk/bluetooth/ota/OtaStatus;

    # getter for: Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->otaFactory:Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;
    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->access$getOtaFactory$p(Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;)Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;

    move-result-object v1

    if-eqz v1, :cond_f1

    invoke-interface {v1, p2}, Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;->getOtaResultCode([B)Ljava/lang/Byte;

    move-result-object v2

    .line 134
    :cond_f1
    # invokes: Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->onOtaFailed(Lcom/flydigi/sdk/bluetooth/ota/OtaStatus;Ljava/lang/Byte;)V
    invoke-static {p1, v0, v2}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->access$onOtaFailed(Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;Lcom/flydigi/sdk/bluetooth/ota/OtaStatus;Ljava/lang/Byte;)V

    goto :goto_133

    .line 139
    :cond_f5
    # getter for: Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->otaFactory:Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;
    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->access$getOtaFactory$p(Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;)Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;

    move-result-object v0

    if-eqz v0, :cond_102

    invoke-interface {v0, p2}, Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;->handleCharacteristic([B)Z

    move-result p2

    if-ne p2, v3, :cond_102

    goto :goto_103

    :cond_102
    move v3, v1

    :goto_103
    invoke-static {p1, v3}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->access$setOtaIdle$p(Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;Z)V

    .line 141
    # getter for: Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->isOtaIdle:Z
    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->access$isOtaIdle$p(Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;)Z

    move-result p2

    if-nez p2, :cond_133

    .line 142
    sget-object p2, Lcom/flydigi/sdk/bluetooth/ota/OtaStatus;->ERR_DEVICE_NOT_PREPARED:Lcom/flydigi/sdk/bluetooth/ota/OtaStatus;

    # invokes: Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->onOtaFailed(Lcom/flydigi/sdk/bluetooth/ota/OtaStatus;Ljava/lang/Byte;)V
    invoke-static {p1, p2, v2}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->access$onOtaFailed(Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;Lcom/flydigi/sdk/bluetooth/ota/OtaStatus;Ljava/lang/Byte;)V

    goto :goto_133

    .line 148
    :cond_112
    invoke-virtual {p1}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->getReadCharacteristicUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {p2}, Landroid/bluetooth/BluetoothGattCharacteristic;->getUuid()Ljava/util/UUID;

    move-result-object v2

    invoke-static {v0, v2}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_133

    .line 149
    invoke-virtual {p2}, Landroid/bluetooth/BluetoothGattCharacteristic;->getUuid()Ljava/util/UUID;

    move-result-object v0

    const-string v2, "it.uuid"

    invoke-static {v0, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/bluetooth/BluetoothGattCharacteristic;->getValue()[B

    move-result-object p2

    invoke-static {p2, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p1, v0, p2}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->onReceiveDataFromDevice(Ljava/util/UUID;[B)V

    :cond_133
    :goto_133
    return-void
.end method

.method public onCharacteristicRead(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;I)V
    .registers 8

    if-eqz p2, :cond_38

    .line 55
    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$mGattCallback$1;->this$0:Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;

    .line 56
    new-instance p3, Ljava/lang/StringBuilder;

    const-string v0, "onCharacteristicReadSuccess:"

    invoke-direct {p3, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/bluetooth/BluetoothGattCharacteristic;->getValue()[B

    move-result-object v0

    const-string v1, "it.value"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v2, 0x1

    const/4 v3, 0x0

    invoke-static {v0, v3, v2, v3}, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionControllerKt;->toHexString$default([BLjava/lang/CharSequence;ILjava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p3

    invoke-virtual {p3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p3

    invoke-static {p3}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logd(Ljava/lang/String;)V

    .line 57
    invoke-virtual {p2}, Landroid/bluetooth/BluetoothGattCharacteristic;->getUuid()Ljava/util/UUID;

    move-result-object p3

    const-string v0, "it.uuid"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/bluetooth/BluetoothGattCharacteristic;->getValue()[B

    move-result-object p2

    invoke-static {p2, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p1, p3, p2}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->onCharacteristicReadSuccess(Ljava/util/UUID;[B)V

    :cond_38
    return-void
.end method

.method public onCharacteristicWrite(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;I)V
    .registers 9

    if-eqz p2, :cond_42

    .line 64
    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$mGattCallback$1;->this$0:Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;

    .line 65
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "onCharacteristicWriteSuccess:"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/bluetooth/BluetoothGattCharacteristic;->getValue()[B

    move-result-object v1

    const-string v2, "it.value"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v3, 0x1

    const/4 v4, 0x0

    invoke-static {v1, v4, v3, v4}, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionControllerKt;->toHexString$default([BLjava/lang/CharSequence;ILjava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " status:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p3

    invoke-virtual {p3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p3

    invoke-static {p3}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logd(Ljava/lang/String;)V

    .line 66
    invoke-virtual {p2}, Landroid/bluetooth/BluetoothGattCharacteristic;->getUuid()Ljava/util/UUID;

    move-result-object p3

    const-string v0, "it.uuid"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/bluetooth/BluetoothGattCharacteristic;->getValue()[B

    move-result-object p2

    invoke-static {p2, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p1, p3, p2}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->onCharacteristicWriteSuccess(Ljava/util/UUID;[B)V

    :cond_42
    return-void
.end method

.method public onConnectionStateChange(Landroid/bluetooth/BluetoothGatt;II)V
    .registers 6

    const-string v0, "gatt"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 44
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "onConnectionStateChange status\uff1a"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p2

    const-string v0, " newState:"

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p2

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p2

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-static {p2}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logd(Ljava/lang/String;)V

    if-eqz p3, :cond_2d

    const/4 p2, 0x2

    if-eq p3, p2, :cond_27

    goto :goto_32

    .line 46
    :cond_27
    iget-object p2, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$mGattCallback$1;->this$0:Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;

    invoke-virtual {p2, p1}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->onGattConnected(Landroid/bluetooth/BluetoothGatt;)V

    goto :goto_32

    .line 48
    :cond_2d
    iget-object p2, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$mGattCallback$1;->this$0:Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;

    invoke-virtual {p2, p1}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->onGattDisconnected(Landroid/bluetooth/BluetoothGatt;)V

    :goto_32
    return-void
.end method

.method public onDescriptorRead(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattDescriptor;I[B)V
    .registers 7

    const-string v0, "gatt"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "descriptor"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "value"

    invoke-static {p4, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 110
    invoke-super {p0, p1, p2, p3, p4}, Landroid/bluetooth/BluetoothGattCallback;->onDescriptorRead(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattDescriptor;I[B)V

    .line 111
    new-instance p1, Ljava/lang/StringBuilder;

    const-string v0, "onDescriptorRead:read "

    invoke-direct {p1, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const/4 v0, 0x0

    const/4 v1, 0x1

    invoke-static {p4, v0, v1, v0}, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionControllerKt;->toHexString$default([BLjava/lang/CharSequence;ILjava/lang/Object;)Ljava/lang/String;

    move-result-object p4

    invoke-virtual {p1, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    const-string p4, " from "

    invoke-virtual {p1, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p2}, Landroid/bluetooth/BluetoothGattDescriptor;->getUuid()Ljava/util/UUID;

    move-result-object p2

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object p1

    const-string p2, " status:"

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logd(Ljava/lang/String;)V

    return-void
.end method

.method public onDescriptorWrite(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattDescriptor;I)V
    .registers 7

    .line 103
    new-instance p1, Ljava/lang/StringBuilder;

    const-string v0, "onDescriptorWritten:"

    invoke-direct {p1, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const/4 v0, 0x0

    if-eqz p2, :cond_16

    invoke-virtual {p2}, Landroid/bluetooth/BluetoothGattDescriptor;->getValue()[B

    move-result-object v1

    if-eqz v1, :cond_16

    const/4 v2, 0x1

    invoke-static {v1, v0, v2, v0}, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionControllerKt;->toHexString$default([BLjava/lang/CharSequence;ILjava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto :goto_17

    :cond_16
    move-object v1, v0

    :goto_17
    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    const-string v1, " to "

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    if-eqz p2, :cond_27

    invoke-virtual {p2}, Landroid/bluetooth/BluetoothGattDescriptor;->getUuid()Ljava/util/UUID;

    move-result-object v0

    :cond_27
    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object p1

    const-string v0, " status:"

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logd(Ljava/lang/String;)V

    if-eqz p2, :cond_43

    .line 104
    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$mGattCallback$1;->this$0:Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;

    invoke-virtual {p1, p2}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->onDescriptorWritten(Landroid/bluetooth/BluetoothGattDescriptor;)V

    :cond_43
    return-void
.end method

.method public onReadRemoteRssi(Landroid/bluetooth/BluetoothGatt;II)V
    .registers 4

    .line 94
    invoke-super {p0, p1, p2, p3}, Landroid/bluetooth/BluetoothGattCallback;->onReadRemoteRssi(Landroid/bluetooth/BluetoothGatt;II)V

    if-nez p3, :cond_a

    .line 96
    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$mGattCallback$1;->this$0:Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;

    invoke-virtual {p1, p2}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->onReadRemoteRssi(I)V

    :cond_a
    return-void
.end method

.method public onReliableWriteCompleted(Landroid/bluetooth/BluetoothGatt;I)V
    .registers 3

    const-string p1, "onReliableWriteCompleted"

    .line 90
    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logd(Ljava/lang/String;)V

    return-void
.end method

.method public onServicesDiscovered(Landroid/bluetooth/BluetoothGatt;I)V
    .registers 5

    .line 71
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$mGattCallback$1;->this$0:Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;

    # invokes: Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->checkBluetoothPermission()Z
    invoke-static {v0}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->access$checkBluetoothPermission(Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;)Z

    move-result v0

    if-nez v0, :cond_9

    return-void

    .line 72
    :cond_9
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "onServicesDiscovered status:"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logd(Ljava/lang/String;)V

    if-nez p2, :cond_4f

    if-eqz p1, :cond_4f

    .line 74
    iget-object p2, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$mGattCallback$1;->this$0:Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;

    .line 75
    invoke-virtual {p2}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->getServiceUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/bluetooth/BluetoothGatt;->getService(Ljava/util/UUID;)Landroid/bluetooth/BluetoothGattService;

    move-result-object v0

    invoke-virtual {p2, v0}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->setGattService(Landroid/bluetooth/BluetoothGattService;)V

    .line 76
    invoke-virtual {p2}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->getGattService()Landroid/bluetooth/BluetoothGattService;

    move-result-object v0

    if-eqz v0, :cond_35

    .line 77
    invoke-virtual {p2, v0}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->initCharacteristic(Landroid/bluetooth/BluetoothGattService;)V

    .line 79
    :cond_35
    invoke-virtual {p2}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->getReadCharacteristic()Landroid/bluetooth/BluetoothGattCharacteristic;

    move-result-object v0

    if-eqz v0, :cond_4f

    const/4 v1, 0x1

    .line 80
    invoke-virtual {p1, v0, v1}, Landroid/bluetooth/BluetoothGatt;->setCharacteristicNotification(Landroid/bluetooth/BluetoothGattCharacteristic;Z)Z

    .line 81
    invoke-virtual {p2}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->getDescriptorUUID()Ljava/util/UUID;

    move-result-object p2

    invoke-virtual {v0, p2}, Landroid/bluetooth/BluetoothGattCharacteristic;->getDescriptor(Ljava/util/UUID;)Landroid/bluetooth/BluetoothGattDescriptor;

    move-result-object p2

    .line 82
    sget-object v0, Landroid/bluetooth/BluetoothGattDescriptor;->ENABLE_NOTIFICATION_VALUE:[B

    invoke-virtual {p2, v0}, Landroid/bluetooth/BluetoothGattDescriptor;->setValue([B)Z

    .line 83
    invoke-virtual {p1, p2}, Landroid/bluetooth/BluetoothGatt;->writeDescriptor(Landroid/bluetooth/BluetoothGattDescriptor;)Z

    :cond_4f
    return-void
.end method
