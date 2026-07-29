.class public final Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$scanCallback$1;
.super Landroid/bluetooth/le/ScanCallback;
.source "AbstractBluetoothController.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;-><init>(Landroid/content/Context;Lcom/flydigi/sdk/bluetooth/DeviceFilter;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nAbstractBluetoothController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractBluetoothController.kt\ncom/flydigi/sdk/bluetooth/AbstractBluetoothController$scanCallback$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1116:1\n1054#2:1117\n766#2:1118\n857#2,2:1119\n1549#2:1121\n1620#2,3:1122\n1855#2,2:1125\n*S KotlinDebug\n*F\n+ 1 AbstractBluetoothController.kt\ncom/flydigi/sdk/bluetooth/AbstractBluetoothController$scanCallback$1\n*L\n300#1:1117\n300#1:1118\n300#1:1119,2\n301#1:1121\n301#1:1122,3\n321#1:1125,2\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\u0006H\u0016\u00a8\u0006\r"
    }
    d2 = {
        "com/flydigi/sdk/bluetooth/AbstractBluetoothController$scanCallback$1",
        "Landroid/bluetooth/le/ScanCallback;",
        "onBatchScanResults",
        "",
        "results",
        "",
        "Landroid/bluetooth/le/ScanResult;",
        "onScanFailed",
        "errorCode",
        "",
        "onScanResult",
        "callbackType",
        "result",
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

    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$scanCallback$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    .line 279
    invoke-direct {p0}, Landroid/bluetooth/le/ScanCallback;-><init>()V

    return-void
.end method


# virtual methods
.method public onBatchScanResults(Ljava/util/List;)V
    .registers 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Landroid/bluetooth/le/ScanResult;",
            ">;)V"
        }
    .end annotation

    const-string v0, "results"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 298
    invoke-super {p0, p1}, Landroid/bluetooth/le/ScanCallback;->onBatchScanResults(Ljava/util/List;)V

    .line 299
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$scanCallback$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    invoke-virtual {v0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->getMWorkHandler()Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$scanCallback$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    # invokes: Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->getCheckLocationServiceEnabledRunnable()Ljava/lang/Runnable;
    invoke-static {v1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->access$getCheckLocationServiceEnabledRunnable(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)Ljava/lang/Runnable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 300
    check-cast p1, Ljava/lang/Iterable;

    .line 1117
    new-instance v0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$scanCallback$1$onBatchScanResults$$inlined$sortedByDescending$1;

    invoke-direct {v0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$scanCallback$1$onBatchScanResults$$inlined$sortedByDescending$1;-><init>()V

    check-cast v0, Ljava/util/Comparator;

    invoke-static {p1, v0}, Lkotlin/collections/CollectionsKt;->sortedWith(Ljava/lang/Iterable;Ljava/util/Comparator;)Ljava/util/List;

    move-result-object p1

    check-cast p1, Ljava/lang/Iterable;

    .line 300
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$scanCallback$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    .line 1118
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    check-cast v1, Ljava/util/Collection;

    .line 1119
    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :cond_33
    :goto_33
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_53

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    move-object v3, v2

    check-cast v3, Landroid/bluetooth/le/ScanResult;

    .line 300
    invoke-virtual {v3}, Landroid/bluetooth/le/ScanResult;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v3

    const-string v4, "it.device"

    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0, v3}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->isDeviceNameExist(Landroid/bluetooth/BluetoothDevice;)Z

    move-result v3

    if-eqz v3, :cond_33

    .line 1119
    invoke-interface {v1, v2}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    goto :goto_33

    .line 1120
    :cond_53
    check-cast v1, Ljava/util/List;

    .line 1118
    check-cast v1, Ljava/lang/Iterable;

    .line 1121
    new-instance p1, Ljava/util/ArrayList;

    const/16 v0, 0xa

    invoke-static {v1, v0}, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable;I)I

    move-result v0

    invoke-direct {p1, v0}, Ljava/util/ArrayList;-><init>(I)V

    check-cast p1, Ljava/util/Collection;

    .line 1122
    invoke-interface {v1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_68
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_cc

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    .line 1123
    check-cast v1, Landroid/bluetooth/le/ScanResult;

    .line 304
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1}, Landroid/bluetooth/le/ScanResult;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v3

    invoke-virtual {v3}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/16 v3, 0x20

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v1}, Landroid/bluetooth/le/ScanResult;->getRssi()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "cwq"

    .line 302
    invoke-static {v3, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 306
    new-instance v2, Lcom/flydigi/sdk/bluetooth/data/BleDevice;

    .line 307
    invoke-virtual {v1}, Landroid/bluetooth/le/ScanResult;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v5

    const-string v3, "result.device"

    invoke-static {v5, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 308
    invoke-virtual {v1}, Landroid/bluetooth/le/ScanResult;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v3

    invoke-virtual {v3}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v6

    .line 309
    invoke-virtual {v1}, Landroid/bluetooth/le/ScanResult;->getRssi()I

    move-result v7

    .line 310
    invoke-virtual {v1}, Landroid/bluetooth/le/ScanResult;->getScanRecord()Landroid/bluetooth/le/ScanRecord;

    move-result-object v1

    if-eqz v1, :cond_be

    invoke-virtual {v1}, Landroid/bluetooth/le/ScanRecord;->getBytes()[B

    move-result-object v1

    goto :goto_bf

    :cond_be
    const/4 v1, 0x0

    :goto_bf
    move-object v8, v1

    .line 311
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v9

    move-object v4, v2

    .line 306
    invoke-direct/range {v4 .. v10}, Lcom/flydigi/sdk/bluetooth/data/BleDevice;-><init>(Landroid/bluetooth/BluetoothDevice;Ljava/lang/String;I[BJ)V

    .line 1123
    invoke-interface {p1, v2}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    goto :goto_68

    .line 1124
    :cond_cc
    check-cast p1, Ljava/util/List;

    .line 313
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$scanCallback$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    .line 315
    # invokes: Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->onDeviceFound(Ljava/util/List;)V
    invoke-static {v0, p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->access$onDeviceFound(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;Ljava/util/List;)V

    return-void
.end method

.method public onScanFailed(I)V
    .registers 4

    .line 320
    invoke-super {p0, p1}, Landroid/bluetooth/le/ScanCallback;->onScanFailed(I)V

    const-string v0, "SC.onScanFailed"
    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static {v0, v1}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logFile(Ljava/lang/String;Ljava/lang/String;)V

    .line 321
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$scanCallback$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    # getter for: Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->scanDeviceCallbacks:Ljava/util/ArrayList;
    invoke-static {v0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->access$getScanDeviceCallbacks$p(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)Ljava/util/ArrayList;

    move-result-object v0

    check-cast v0, Ljava/lang/Iterable;

    .line 1125
    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_f
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1f

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;

    .line 322
    invoke-interface {v1, p1}, Lcom/flydigi/sdk/bluetooth/ScanDeviceCallback;->onScanFailed(I)V

    goto :goto_f

    :cond_1f
    return-void
.end method

.method public onScanResult(ILandroid/bluetooth/le/ScanResult;)V
    .registers 11

    const-string v0, "result"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 281
    invoke-super {p0, p1, p2}, Landroid/bluetooth/le/ScanCallback;->onScanResult(ILandroid/bluetooth/le/ScanResult;)V

    const-string v0, "SC.onScanResult"
    invoke-virtual {p2}, Landroid/bluetooth/le/ScanResult;->getDevice()Landroid/bluetooth/BluetoothDevice;
    move-result-object v1
    invoke-virtual {v1}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;
    move-result-object v1
    invoke-static {v0, v1}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logFile(Ljava/lang/String;Ljava/lang/String;)V

    .line 282
    new-instance p1, Ljava/lang/StringBuilder;

    const-string v0, "onScanResult:"

    invoke-direct {p1, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/bluetooth/le/ScanResult;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v0

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    const-string v0, "cwq"

    invoke-static {v0, p1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 283
    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$scanCallback$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    invoke-virtual {p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->getMWorkHandler()Landroid/os/Handler;

    move-result-object p1

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$scanCallback$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    # invokes: Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->getCheckLocationServiceEnabledRunnable()Ljava/lang/Runnable;
    invoke-static {v0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->access$getCheckLocationServiceEnabledRunnable(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)Ljava/lang/Runnable;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 284
    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$scanCallback$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    .line 286
    new-instance v7, Lcom/flydigi/sdk/bluetooth/data/BleDevice;

    .line 287
    invoke-virtual {p2}, Landroid/bluetooth/le/ScanResult;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v1

    const-string v0, "result.device"

    invoke-static {v1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 288
    invoke-virtual {p2}, Landroid/bluetooth/le/ScanResult;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v0

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v2

    .line 289
    invoke-virtual {p2}, Landroid/bluetooth/le/ScanResult;->getRssi()I

    move-result v3

    .line 290
    invoke-virtual {p2}, Landroid/bluetooth/le/ScanResult;->getScanRecord()Landroid/bluetooth/le/ScanRecord;

    move-result-object p2

    if-eqz p2, :cond_57

    invoke-virtual {p2}, Landroid/bluetooth/le/ScanRecord;->getBytes()[B

    move-result-object p2

    goto :goto_58

    :cond_57
    const/4 p2, 0x0

    :goto_58
    move-object v4, p2

    .line 291
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v5

    move-object v0, v7

    .line 286
    invoke-direct/range {v0 .. v6}, Lcom/flydigi/sdk/bluetooth/data/BleDevice;-><init>(Landroid/bluetooth/BluetoothDevice;Ljava/lang/String;I[BJ)V

    .line 285
    invoke-static {v7}, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;

    move-result-object p2

    .line 284
    # invokes: Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->onDeviceFound(Ljava/util/List;)V
    invoke-static {p1, p2}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->access$onDeviceFound(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;Ljava/util/List;)V

    return-void
.end method
