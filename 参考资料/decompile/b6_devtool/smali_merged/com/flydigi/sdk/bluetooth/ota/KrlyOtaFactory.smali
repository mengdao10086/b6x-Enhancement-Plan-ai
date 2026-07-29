.class public final Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;
.super Ljava/lang/Object;
.source "OtaFactory.kt"

# interfaces
.implements Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0005\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0000\u0008\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J$\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001b0\u001a0\u00192\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001d\u001a\u00020\u000b2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001bH\u0002J$\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u000bH\u0016J\u0014\u0010\"\u001a\u0004\u0018\u00010#2\u0008\u0010$\u001a\u0004\u0018\u00010\u0004H\u0016J\"\u0010%\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001b0\u001a0\u00192\u0006\u0010&\u001a\u00020\u000bH\u0016J\u0017\u0010\'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\u001bH\u0016\u00a2\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u001bH\u0016J\u0010\u0010,\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u001bH\u0016J\u0010\u0010-\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u001bH\u0016J\u0010\u0010.\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u001bH\u0016J\u0010\u0010/\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u001bH\u0016J\u001a\u00100\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001b0\u001a0\u0019H\u0016J(\u00101\u001a\u0012\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\u00192\u0006\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u000204H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000c\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u0007R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u000bX\u0096D\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0007\u00a8\u00065"
    }
    d2 = {
        "Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;",
        "Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;",
        "()V",
        "characteristic2UUID",
        "Ljava/util/UUID;",
        "characteristicUUID",
        "getCharacteristicUUID",
        "()Ljava/util/UUID;",
        "checkCallbackRequired",
        "",
        "checkDataSize",
        "",
        "descriptorUUID",
        "getDescriptorUUID",
        "otaService",
        "Landroid/bluetooth/BluetoothGattService;",
        "packetLength",
        "getPacketLength",
        "()I",
        "sendDataSize",
        "serviceUUID",
        "getServiceUUID",
        "checkCallback",
        "first",
        "checkOtaReadyCmd",
        "Lkotlin/Pair;",
        "",
        "",
        "file",
        "crc16",
        "data",
        "fillData",
        "total",
        "index",
        "getOtaCharacteristic",
        "Landroid/bluetooth/BluetoothGattCharacteristic;",
        "uuid",
        "getOtaEndCmd",
        "idx",
        "getOtaResultCode",
        "",
        "value",
        "([B)Ljava/lang/Byte;",
        "handleCharacteristic",
        "isEndCmd",
        "isOtaReady",
        "isOtaResultCmd",
        "isOtaSuccess",
        "requestOtaDataCheckSize",
        "setupOta",
        "chipType",
        "gatt",
        "Landroid/bluetooth/BluetoothGatt;",
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


# static fields
.field public static final INSTANCE:Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;

.field private static final characteristic2UUID:Ljava/util/UUID;

.field private static final characteristicUUID:Ljava/util/UUID;

.field private static checkCallbackRequired:Z

.field private static checkDataSize:I

.field private static final descriptorUUID:Ljava/util/UUID;

.field private static otaService:Landroid/bluetooth/BluetoothGattService;

.field private static final packetLength:I

.field private static sendDataSize:I

.field private static final serviceUUID:Ljava/util/UUID;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    new-instance v0, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;

    invoke-direct {v0}, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;-><init>()V

    sput-object v0, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->INSTANCE:Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;

    const-string v0, "0000FF10-0000-1000-8000-00805F9B34FB"

    .line 388
    invoke-static {v0}, Ljava/util/UUID;->fromString(Ljava/lang/String;)Ljava/util/UUID;

    move-result-object v0

    const-string v1, "fromString(\"0000FF10-0000-1000-8000-00805F9B34FB\")"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    sput-object v0, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->serviceUUID:Ljava/util/UUID;

    const-string v0, "00002902-0000-1000-8000-00805f9b34fb"

    .line 389
    invoke-static {v0}, Ljava/util/UUID;->fromString(Ljava/lang/String;)Ljava/util/UUID;

    move-result-object v0

    const-string v1, "fromString(\"00002902-0000-1000-8000-00805f9b34fb\")"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    sput-object v0, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->descriptorUUID:Ljava/util/UUID;

    const-string v0, "0000FF11-0000-1000-8000-00805F9B34FB"

    .line 390
    invoke-static {v0}, Ljava/util/UUID;->fromString(Ljava/lang/String;)Ljava/util/UUID;

    move-result-object v0

    const-string v1, "fromString(\"0000FF11-0000-1000-8000-00805F9B34FB\")"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    sput-object v0, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->characteristicUUID:Ljava/util/UUID;

    const-string v0, "0000FF12-0000-1000-8000-00805F9B34FB"

    .line 391
    invoke-static {v0}, Ljava/util/UUID;->fromString(Ljava/lang/String;)Ljava/util/UUID;

    move-result-object v0

    const-string v1, "fromString(\"0000FF12-0000-1000-8000-00805F9B34FB\")"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    sput-object v0, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->characteristic2UUID:Ljava/util/UUID;

    const/16 v0, 0x14

    .line 392
    sput v0, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->packetLength:I

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .line 386
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private final crc16([B)I
    .registers 11

    const/4 v0, 0x0

    if-eqz p1, :cond_2f

    .line 515
    array-length v1, p1

    move v2, v0

    move v3, v2

    :goto_6
    if-ge v2, v1, :cond_2e

    aget-byte v4, p1, v2

    move v5, v0

    :goto_b
    const/16 v6, 0x8

    if-ge v5, v6, :cond_2b

    rsub-int/lit8 v6, v5, 0x7

    shr-int v6, v4, v6

    const/4 v7, 0x1

    and-int/2addr v6, v7

    if-ne v6, v7, :cond_19

    move v6, v7

    goto :goto_1a

    :cond_19
    move v6, v0

    :goto_1a
    shr-int/lit8 v8, v3, 0xf

    and-int/2addr v8, v7

    if-ne v8, v7, :cond_20

    goto :goto_21

    :cond_20
    move v7, v0

    :goto_21
    shl-int/lit8 v3, v3, 0x1

    xor-int/2addr v6, v7

    if-eqz v6, :cond_28

    xor-int/lit16 v3, v3, 0x1021

    :cond_28
    add-int/lit8 v5, v5, 0x1

    goto :goto_b

    :cond_2b
    add-int/lit8 v2, v2, 0x1

    goto :goto_6

    :cond_2e
    move v0, v3

    :cond_2f
    return v0
.end method


# virtual methods
.method public checkCallback(Ljava/util/UUID;)Z
    .registers 3

    const-string v0, "first"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 488
    sget-boolean p1, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->checkCallbackRequired:Z

    return p1
.end method

.method public checkOtaReadyCmd([B)Lkotlin/Pair;
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([B)",
            "Lkotlin/Pair<",
            "Ljava/util/UUID;",
            "Ljava/util/List<",
            "[B>;>;"
        }
    .end annotation

    const/16 v0, 0x8

    new-array v1, v0, [B

    const/4 v2, 0x0

    aput-byte v0, v1, v2

    const/4 v3, 0x1

    const/16 v4, 0x50

    aput-byte v4, v1, v3

    const/4 v3, 0x2

    aput-byte v2, v1, v3

    .line 419
    invoke-direct {p0, p1}, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->crc16([B)I

    move-result v3

    shr-int/lit8 v4, v3, 0x8

    int-to-byte v4, v4

    const/4 v5, 0x3

    aput-byte v4, v1, v5

    and-int/lit16 v3, v3, 0xff

    int-to-byte v3, v3

    const/4 v4, 0x4

    aput-byte v3, v1, v4

    if-eqz p1, :cond_23

    .line 422
    array-length v3, p1

    goto :goto_24

    :cond_23
    move v3, v2

    :goto_24
    shr-int/lit8 v3, v3, 0x10

    int-to-byte v3, v3

    const/4 v4, 0x5

    aput-byte v3, v1, v4

    if-eqz p1, :cond_2e

    .line 423
    array-length v3, p1

    goto :goto_2f

    :cond_2e
    move v3, v2

    :goto_2f
    const v4, 0xff00

    and-int/2addr v3, v4

    shr-int/lit8 v0, v3, 0x8

    int-to-byte v0, v0

    const/4 v3, 0x6

    aput-byte v0, v1, v3

    if-eqz p1, :cond_3c

    .line 424
    array-length v2, p1

    :cond_3c
    and-int/lit16 p1, v2, 0xff

    int-to-byte p1, p1

    const/4 v0, 0x7

    aput-byte p1, v1, v0

    .line 425
    new-instance p1, Lkotlin/Pair;

    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->getCharacteristicUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-static {v1}, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-direct {p1, v0, v1}, Lkotlin/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    return-object p1
.end method

.method public fillData([BI)Lkotlin/Pair;
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([BI)",
            "Lkotlin/Pair<",
            "Ljava/util/UUID;",
            "[B>;"
        }
    .end annotation

    const-string v0, "total"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 460
    array-length v0, p1

    .line 461
    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->getPacketLength()I

    move-result v1

    rem-int v1, v0, v1

    const/4 v2, 0x1

    if-nez v1, :cond_16

    .line 462
    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->getPacketLength()I

    move-result v1

    div-int v1, v0, v1

    goto :goto_25

    :cond_16
    int-to-float v1, v0

    .line 464
    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->getPacketLength()I

    move-result v3

    int-to-float v3, v3

    div-float/2addr v1, v3

    int-to-float v3, v2

    add-float/2addr v1, v3

    float-to-double v3, v1

    invoke-static {v3, v4}, Ljava/lang/Math;->floor(D)D

    move-result-wide v3

    double-to-int v1, v3

    :goto_25
    add-int/lit8 v3, p2, 0x1

    if-ne v3, v1, :cond_30

    .line 468
    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->getPacketLength()I

    move-result v1

    mul-int/2addr v1, p2

    sub-int/2addr v0, v1

    goto :goto_34

    .line 470
    :cond_30
    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->getPacketLength()I

    move-result v0

    .line 473
    :goto_34
    new-array v1, v0, [B

    .line 474
    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->getPacketLength()I

    move-result v3

    mul-int/2addr p2, v3

    const/4 v3, 0x0

    invoke-static {p1, p2, v1, v3, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 476
    sget p1, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->sendDataSize:I

    add-int/2addr p1, v0

    sput p1, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->sendDataSize:I

    .line 477
    sget p2, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->checkDataSize:I

    if-ne p1, p2, :cond_53

    .line 478
    sput v3, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->sendDataSize:I

    .line 479
    sput-boolean v2, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->checkCallbackRequired:Z

    const-string p1, "cwq"

    const-string p2, "check callback"

    .line 480
    invoke-static {p1, p2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 482
    :cond_53
    new-instance p1, Lkotlin/Pair;

    sget-object p2, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->characteristic2UUID:Ljava/util/UUID;

    invoke-direct {p1, p2, v1}, Lkotlin/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    return-object p1
.end method

.method public getCharacteristicUUID()Ljava/util/UUID;
    .registers 2

    .line 390
    sget-object v0, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->characteristicUUID:Ljava/util/UUID;

    return-object v0
.end method

.method public getDescriptorUUID()Ljava/util/UUID;
    .registers 2

    .line 389
    sget-object v0, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->descriptorUUID:Ljava/util/UUID;

    return-object v0
.end method

.method public getOtaCharacteristic(Ljava/util/UUID;)Landroid/bluetooth/BluetoothGattCharacteristic;
    .registers 3

    .line 412
    sget-object v0, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->otaService:Landroid/bluetooth/BluetoothGattService;

    if-eqz v0, :cond_f

    if-nez p1, :cond_a

    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->getCharacteristicUUID()Ljava/util/UUID;

    move-result-object p1

    :cond_a
    invoke-virtual {v0, p1}, Landroid/bluetooth/BluetoothGattService;->getCharacteristic(Ljava/util/UUID;)Landroid/bluetooth/BluetoothGattCharacteristic;

    move-result-object p1

    goto :goto_10

    :cond_f
    const/4 p1, 0x0

    :goto_10
    return-object p1
.end method

.method public getOtaEndCmd(I)Lkotlin/Pair;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Lkotlin/Pair<",
            "Ljava/util/UUID;",
            "Ljava/util/List<",
            "[B>;>;"
        }
    .end annotation

    .line 492
    new-instance p1, Lkotlin/Pair;

    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->getCharacteristicUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-static {}, Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;

    move-result-object v1

    invoke-direct {p1, v0, v1}, Lkotlin/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    return-object p1
.end method

.method public getOtaResultCode([B)Ljava/lang/Byte;
    .registers 3

    const-string v0, "value"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 p1, 0x0

    return-object p1
.end method

.method public getPacketLength()I
    .registers 2

    .line 392
    sget v0, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->packetLength:I

    return v0
.end method

.method public getServiceUUID()Ljava/util/UUID;
    .registers 2

    .line 388
    sget-object v0, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->serviceUUID:Ljava/util/UUID;

    return-object v0
.end method

.method public handleCharacteristic([B)Z
    .registers 10

    const-string v0, "value"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x0

    .line 444
    aget-byte v1, p1, v0

    const/4 v2, 0x5

    const/4 v3, 0x3

    const/4 v4, 0x2

    const/16 v5, 0x8

    const/4 v6, 0x1

    if-ne v1, v2, :cond_28

    .line 445
    aget-byte v2, p1, v6

    const/16 v7, 0x51

    if-ne v2, v7, :cond_28

    .line 446
    aget-byte v2, p1, v4

    if-nez v2, :cond_28

    .line 448
    aget-byte v0, p1, v3

    and-int/lit16 v0, v0, 0xff

    shl-int/2addr v0, v5

    const/4 v1, 0x4

    aget-byte p1, p1, v1

    and-int/lit16 p1, p1, 0xff

    add-int/2addr v0, p1

    sput v0, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->checkDataSize:I

    goto :goto_3c

    :cond_28
    if-ne v1, v5, :cond_3c

    .line 450
    aget-byte v1, p1, v6

    const/16 v2, 0x52

    if-ne v1, v2, :cond_3c

    .line 451
    aget-byte v1, p1, v4

    if-nez v1, :cond_3c

    .line 453
    sput-boolean v0, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->checkCallbackRequired:Z

    .line 454
    aget-byte p1, p1, v3

    if-nez p1, :cond_3b

    move v0, v6

    :cond_3b
    return v0

    :cond_3c
    :goto_3c
    return v6
.end method

.method public isEndCmd([B)Z
    .registers 3

    const-string v0, "value"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 p1, 0x0

    return p1
.end method

.method public isOtaReady([B)Z
    .registers 6

    const-string v0, "value"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 429
    array-length v0, p1

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-nez v0, :cond_c

    move v0, v1

    goto :goto_d

    :cond_c
    move v0, v2

    :goto_d
    xor-int/2addr v0, v1

    if-eqz v0, :cond_28

    .line 430
    aget-byte v0, p1, v2

    const/4 v3, 0x4

    if-ne v0, v3, :cond_28

    .line 431
    aget-byte v0, p1, v1

    const/16 v3, 0x50

    if-ne v0, v3, :cond_28

    const/4 v0, 0x2

    .line 432
    aget-byte v0, p1, v0

    if-nez v0, :cond_28

    const/4 v0, 0x3

    .line 434
    aget-byte p1, p1, v0

    if-nez p1, :cond_26

    goto :goto_27

    :cond_26
    move v1, v2

    :goto_27
    return v1

    :cond_28
    return v2
.end method

.method public isOtaResultCmd([B)Z
    .registers 3

    const-string v0, "value"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 p1, 0x0

    return p1
.end method

.method public isOtaSuccess([B)Z
    .registers 3

    const-string v0, "value"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 p1, 0x0

    return p1
.end method

.method public requestOtaDataCheckSize()Lkotlin/Pair;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lkotlin/Pair<",
            "Ljava/util/UUID;",
            "Ljava/util/List<",
            "[B>;>;"
        }
    .end annotation

    .line 440
    new-instance v0, Lkotlin/Pair;

    sget-object v1, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->INSTANCE:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;

    invoke-virtual {v1}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->getCharacteristicUUID()Ljava/util/UUID;

    move-result-object v1

    const/4 v2, 0x3

    new-array v2, v2, [B

    fill-array-data v2, :array_16

    invoke-static {v2}, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lkotlin/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    return-object v0

    :array_16
    .array-data 1
        0x3t
        0x51t
        0x0t
    .end array-data
.end method

.method public setupOta(ILandroid/bluetooth/BluetoothGatt;)Lkotlin/Pair;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/bluetooth/BluetoothGatt;",
            ")",
            "Lkotlin/Pair<",
            "Landroid/bluetooth/BluetoothGattCharacteristic;",
            "Landroid/bluetooth/BluetoothGattCharacteristic;",
            ">;"
        }
    .end annotation

    const-string p1, "gatt"

    .line 402
    invoke-static {p2, p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->getServiceUUID()Ljava/util/UUID;

    move-result-object p1

    invoke-virtual {p2, p1}, Landroid/bluetooth/BluetoothGatt;->getService(Ljava/util/UUID;)Landroid/bluetooth/BluetoothGattService;

    move-result-object p1

    if-eqz p1, :cond_25

    .line 403
    sget-object v0, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->INSTANCE:Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;

    sput-object p1, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->otaService:Landroid/bluetooth/BluetoothGattService;

    .line 404
    invoke-virtual {v0}, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->getCharacteristicUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/bluetooth/BluetoothGattService;->getCharacteristic(Ljava/util/UUID;)Landroid/bluetooth/BluetoothGattCharacteristic;

    move-result-object p1

    const/4 v0, 0x1

    .line 405
    invoke-virtual {p2, p1, v0}, Landroid/bluetooth/BluetoothGatt;->setCharacteristicNotification(Landroid/bluetooth/BluetoothGattCharacteristic;Z)Z

    .line 406
    new-instance p2, Lkotlin/Pair;

    invoke-direct {p2, p1, p1}, Lkotlin/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    return-object p2

    :cond_25
    const/4 p1, 0x0

    return-object p1
.end method
