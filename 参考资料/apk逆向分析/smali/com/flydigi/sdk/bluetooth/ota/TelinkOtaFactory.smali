.class public final Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;
.super Ljava/lang/Object;
.source "OtaFactory.kt"

# interfaces
.implements Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0005\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001<B\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\tH\u0016J$\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001b0\u001a0\u00192\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u001c\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00042\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u001bH\u0002J\u0018\u0010\"\u001a\u00020#2\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0004H\u0002J$\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010&\u001a\u00020\u001b2\u0006\u0010\'\u001a\u00020\u0004H\u0016J\u0018\u0010(\u001a\u00020#2\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\'\u001a\u00020\u0004H\u0002J\u0014\u0010)\u001a\u0004\u0018\u00010*2\u0008\u0010+\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010,\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001b0\u001a0\u00192\u0006\u0010-\u001a\u00020\u0004H\u0016J\u0017\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\u001bH\u0016\u00a2\u0006\u0002\u00101J\u0010\u00102\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u001bH\u0016J\u0010\u00103\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u001bH\u0016J\u0010\u00104\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u001bH\u0016J\u0010\u00105\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u001bH\u0016J\u0010\u00106\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u001bH\u0016J\u001a\u00107\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001b0\u001a0\u0019H\u0016J&\u00108\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*\u0018\u00010\u00192\u0006\u00109\u001a\u00020\u00042\u0006\u0010:\u001a\u00020;H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0008\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0014\u0010\u000c\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\u0008\r\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0004X\u0096D\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u000b\u00a8\u0006="
    }
    d2 = {
        "Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;",
        "Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;",
        "()V",
        "CMD_OTA_END",
        "",
        "CMD_OTA_RESULT",
        "CMD_OTA_START",
        "OTA_RESULT_OTA_SUCCESS",
        "characteristicUUID",
        "Ljava/util/UUID;",
        "getCharacteristicUUID",
        "()Ljava/util/UUID;",
        "descriptorUUID",
        "getDescriptorUUID",
        "otaService",
        "Landroid/bluetooth/BluetoothGattService;",
        "packetLength",
        "getPacketLength",
        "()I",
        "serviceUUID",
        "getServiceUUID",
        "checkCallback",
        "",
        "first",
        "checkOtaReadyCmd",
        "Lkotlin/Pair;",
        "",
        "",
        "file",
        "convertCmd",
        "opcode",
        "data",
        "crc16",
        "packet",
        "fillCrc",
        "",
        "crc",
        "fillData",
        "total",
        "index",
        "fillIndex",
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
        "OtaResult",
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
.field private static final CMD_OTA_END:I = 0xff02

.field private static final CMD_OTA_RESULT:I = 0xff06

.field private static final CMD_OTA_START:I = 0xff01

.field public static final INSTANCE:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;

.field private static final OTA_RESULT_OTA_SUCCESS:I

.field private static otaService:Landroid/bluetooth/BluetoothGattService;

.field private static final packetLength:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;

    invoke-direct {v0}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;-><init>()V

    sput-object v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->INSTANCE:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;

    const/16 v0, 0x10

    .line 60
    sput v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->packetLength:I

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .line 52
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private final convertCmd(I[B)[B
    .registers 8

    const/4 v0, 0x1

    const/4 v1, 0x0

    const/4 v2, 0x2

    if-nez p2, :cond_14

    new-array p2, v2, [B

    and-int/lit16 v2, p1, 0xff

    int-to-byte v2, v2

    aput-byte v2, p2, v1

    shr-int/lit8 p1, p1, 0x8

    and-int/lit16 p1, p1, 0xff

    int-to-byte p1, p1

    aput-byte p1, p2, v0

    goto :goto_29

    .line 287
    :cond_14
    array-length v3, p2

    add-int/2addr v3, v2

    new-array v3, v3, [B

    and-int/lit16 v4, p1, 0xff

    int-to-byte v4, v4

    .line 288
    aput-byte v4, v3, v1

    shr-int/lit8 p1, p1, 0x8

    and-int/lit16 p1, p1, 0xff

    int-to-byte p1, p1

    .line 289
    aput-byte p1, v3, v0

    .line 290
    array-length p1, p2

    invoke-static {p2, v1, v3, v2, p1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    move-object p2, v3

    :goto_29
    return-object p2
.end method

.method static synthetic convertCmd$default(Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;I[BILjava/lang/Object;)[B
    .registers 5

    and-int/lit8 p3, p3, 0x2

    if-eqz p3, :cond_5

    const/4 p2, 0x0

    .line 282
    :cond_5
    invoke-direct {p0, p1, p2}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->convertCmd(I[B)[B

    move-result-object p0

    return-object p0
.end method

.method private final crc16([B)I
    .registers 11

    .line 268
    array-length v0, p1

    const/4 v1, 0x2

    sub-int/2addr v0, v1

    new-array v1, v1, [S

    .line 269
    fill-array-data v1, :array_2a

    const v2, 0xffff

    const/4 v3, 0x0

    move v5, v2

    move v4, v3

    :goto_e
    if-ge v4, v0, :cond_28

    .line 273
    aget-byte v6, p1, v4

    move v7, v3

    :goto_13
    const/16 v8, 0x8

    if-ge v7, v8, :cond_25

    shr-int/lit8 v8, v5, 0x1

    xor-int/2addr v5, v6

    and-int/lit8 v5, v5, 0x1

    .line 275
    aget-short v5, v1, v5

    and-int/2addr v5, v2

    xor-int/2addr v5, v8

    shr-int/lit8 v6, v6, 0x1

    add-int/lit8 v7, v7, 0x1

    goto :goto_13

    :cond_25
    add-int/lit8 v4, v4, 0x1

    goto :goto_e

    :cond_28
    return v5

    nop

    :array_2a
    .array-data 2
        0x0s
        -0x5fffs
    .end array-data
.end method

.method private final fillCrc([BI)V
    .registers 6

    .line 262
    array-length v0, p1

    add-int/lit8 v0, v0, -0x2

    add-int/lit8 v1, v0, 0x1

    and-int/lit16 v2, p2, 0xff

    int-to-byte v2, v2

    .line 263
    aput-byte v2, p1, v0

    shr-int/lit8 p2, p2, 0x8

    and-int/lit16 p2, p2, 0xff

    int-to-byte p2, p2

    .line 264
    aput-byte p2, p1, v1

    return-void
.end method

.method private final fillIndex([BI)V
    .registers 5

    and-int/lit16 v0, p2, 0xff

    int-to-byte v0, v0

    const/4 v1, 0x0

    .line 257
    aput-byte v0, p1, v1

    shr-int/lit8 p2, p2, 0x8

    and-int/lit16 p2, p2, 0xff

    int-to-byte p2, p2

    const/4 v0, 0x1

    .line 258
    aput-byte p2, p1, v0

    return-void
.end method


# virtual methods
.method public checkCallback(Ljava/util/UUID;)Z
    .registers 3

    const-string v0, "first"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 p1, 0x0

    return p1
.end method

.method public checkOtaReadyCmd([B)Lkotlin/Pair;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([B)",
            "Lkotlin/Pair<",
            "Ljava/util/UUID;",
            "Ljava/util/List<",
            "[B>;>;"
        }
    .end annotation

    .line 164
    new-instance p1, Lkotlin/Pair;

    .line 165
    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->getCharacteristicUUID()Ljava/util/UUID;

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x2

    const v3, 0xff01

    .line 170
    invoke-static {p0, v3, v1, v2, v1}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->convertCmd$default(Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;I[BILjava/lang/Object;)[B

    move-result-object v1

    .line 165
    invoke-static {v1}, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    .line 164
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

    .line 231
    array-length v0, p1

    .line 232
    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->getPacketLength()I

    move-result v1

    rem-int v1, v0, v1

    const/4 v2, 0x1

    if-nez v1, :cond_16

    .line 233
    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->getPacketLength()I

    move-result v1

    div-int v1, v0, v1

    goto :goto_25

    :cond_16
    int-to-float v1, v0

    .line 235
    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->getPacketLength()I

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

    .line 238
    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->getPacketLength()I

    move-result v1

    mul-int/2addr v1, p2

    sub-int/2addr v0, v1

    goto :goto_34

    .line 240
    :cond_30
    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->getPacketLength()I

    move-result v0

    .line 242
    :goto_34
    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->getPacketLength()I

    move-result v1

    if-ne v0, v1, :cond_41

    .line 243
    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->getPacketLength()I

    move-result v1

    :goto_3e
    add-int/lit8 v1, v1, 0x4

    goto :goto_4d

    .line 245
    :cond_41
    rem-int/lit8 v1, v0, 0x10

    if-nez v1, :cond_47

    move v1, v0

    goto :goto_3e

    :cond_47
    div-int/lit8 v1, v0, 0x10

    add-int/2addr v1, v2

    mul-int/lit8 v1, v1, 0x10

    goto :goto_3e

    .line 247
    :goto_4d
    new-array v2, v1, [B

    const/4 v3, 0x0

    :goto_50
    if-ge v3, v1, :cond_58

    const/4 v4, -0x1

    aput-byte v4, v2, v3

    add-int/lit8 v3, v3, 0x1

    goto :goto_50

    .line 248
    :cond_58
    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->getPacketLength()I

    move-result v1

    mul-int/2addr v1, p2

    const/4 v3, 0x2

    invoke-static {p1, v1, v2, v3, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 249
    invoke-direct {p0, v2, p2}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->fillIndex([BI)V

    .line 250
    invoke-direct {p0, v2}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->crc16([B)I

    move-result p1

    .line 251
    invoke-direct {p0, v2, p1}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->fillCrc([BI)V

    .line 252
    new-instance p1, Lkotlin/Pair;

    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->getCharacteristicUUID()Ljava/util/UUID;

    move-result-object p2

    invoke-direct {p1, p2, v2}, Lkotlin/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    return-object p1
.end method

.method public getCharacteristicUUID()Ljava/util/UUID;
    .registers 3

    const-string v0, "00010203-0405-0607-0809-0a0b0c0d2b12"

    .line 58
    invoke-static {v0}, Ljava/util/UUID;->fromString(Ljava/lang/String;)Ljava/util/UUID;

    move-result-object v0

    const-string v1, "fromString(\"00010203-0405-0607-0809-0a0b0c0d2b12\")"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    return-object v0
.end method

.method public getDescriptorUUID()Ljava/util/UUID;
    .registers 3

    const-string v0, "00002902-0000-1000-8000-00805f9b34fb"

    .line 56
    invoke-static {v0}, Ljava/util/UUID;->fromString(Ljava/lang/String;)Ljava/util/UUID;

    move-result-object v0

    const-string v1, "fromString(\"00002902-0000-1000-8000-00805f9b34fb\")"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    return-object v0
.end method

.method public getOtaCharacteristic(Ljava/util/UUID;)Landroid/bluetooth/BluetoothGattCharacteristic;
    .registers 3

    .line 201
    sget-object v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->otaService:Landroid/bluetooth/BluetoothGattService;

    if-eqz v0, :cond_f

    if-nez p1, :cond_a

    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->getCharacteristicUUID()Ljava/util/UUID;

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
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Lkotlin/Pair<",
            "Ljava/util/UUID;",
            "Ljava/util/List<",
            "[B>;>;"
        }
    .end annotation

    .line 214
    new-instance v0, Lkotlin/Pair;

    .line 215
    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->getCharacteristicUUID()Ljava/util/UUID;

    move-result-object v1

    const/4 v2, 0x4

    new-array v2, v2, [B

    and-int/lit16 v3, p1, 0xff

    int-to-byte v3, v3

    const/4 v4, 0x0

    aput-byte v3, v2, v4

    shr-int/lit8 v3, p1, 0x8

    and-int/lit16 v3, v3, 0xff

    int-to-byte v3, v3

    const/4 v4, 0x1

    aput-byte v3, v2, v4

    not-int p1, p1

    and-int/lit16 v3, p1, 0xff

    int-to-byte v3, v3

    const/4 v4, 0x2

    aput-byte v3, v2, v4

    shr-int/lit8 p1, p1, 0x8

    and-int/lit16 p1, p1, 0xff

    int-to-byte p1, p1

    const/4 v3, 0x3

    aput-byte p1, v2, v3

    const p1, 0xff02

    .line 217
    invoke-direct {p0, p1, v2}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->convertCmd(I[B)[B

    move-result-object p1

    .line 216
    invoke-static {p1}, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;

    move-result-object p1

    .line 214
    invoke-direct {v0, v1, p1}, Lkotlin/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    return-object v0
.end method

.method public getOtaResultCode([B)Ljava/lang/Byte;
    .registers 3

    const-string v0, "value"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 207
    invoke-virtual {p0, p1}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->isOtaResultCmd([B)Z

    move-result v0

    if-eqz v0, :cond_13

    const/4 v0, 0x2

    .line 208
    aget-byte p1, p1, v0

    invoke-static {p1}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p1

    goto :goto_14

    :cond_13
    const/4 p1, 0x0

    :goto_14
    return-object p1
.end method

.method public getPacketLength()I
    .registers 2

    .line 60
    sget v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->packetLength:I

    return v0
.end method

.method public getServiceUUID()Ljava/util/UUID;
    .registers 3

    const-string v0, "00010203-0405-0607-0809-0a0b0c0d1912"

    .line 54
    invoke-static {v0}, Ljava/util/UUID;->fromString(Ljava/lang/String;)Ljava/util/UUID;

    move-result-object v0

    const-string v1, "fromString(\"00010203-0405-0607-0809-0a0b0c0d1912\")"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    return-object v0
.end method

.method public handleCharacteristic([B)Z
    .registers 3

    const-string v0, "value"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 p1, 0x1

    return p1
.end method

.method public isEndCmd([B)Z
    .registers 5

    const-string v0, "value"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 180
    array-length v0, p1

    const/4 v1, 0x6

    const/4 v2, 0x0

    if-ne v0, v1, :cond_16

    .line 181
    aget-byte v0, p1, v2

    const/4 v1, 0x2

    if-ne v0, v1, :cond_16

    const/4 v0, 0x1

    .line 182
    aget-byte p1, p1, v0

    const/4 v1, -0x1

    if-ne p1, v1, :cond_16

    move v2, v0

    :cond_16
    return v2
.end method

.method public isOtaReady([B)Z
    .registers 3

    const-string v0, "value"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 p1, 0x1

    return p1
.end method

.method public isOtaResultCmd([B)Z
    .registers 5

    const-string v0, "value"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 186
    array-length v0, p1

    const/4 v1, 0x4

    const/4 v2, 0x0

    if-ne v0, v1, :cond_16

    .line 187
    aget-byte v0, p1, v2

    const/4 v1, 0x6

    if-ne v0, v1, :cond_16

    const/4 v0, 0x1

    .line 188
    aget-byte p1, p1, v0

    const/4 v1, -0x1

    if-ne p1, v1, :cond_16

    move v2, v0

    :cond_16
    return v2
.end method

.method public isOtaSuccess([B)Z
    .registers 4

    const-string v0, "value"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 203
    invoke-virtual {p0, p1}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->isOtaResultCmd([B)Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_12

    const/4 v0, 0x2

    .line 204
    aget-byte p1, p1, v0

    if-nez p1, :cond_12

    const/4 v1, 0x1

    :cond_12
    return v1
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

    .line 193
    new-instance v0, Lkotlin/Pair;

    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->getCharacteristicUUID()Ljava/util/UUID;

    move-result-object v1

    invoke-static {}, Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lkotlin/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    return-object v0
.end method

.method public setupOta(ILandroid/bluetooth/BluetoothGatt;)Lkotlin/Pair;
    .registers 5
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

    .line 149
    invoke-static {p2, p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->getServiceUUID()Ljava/util/UUID;

    move-result-object p1

    invoke-virtual {p2, p1}, Landroid/bluetooth/BluetoothGatt;->getService(Ljava/util/UUID;)Landroid/bluetooth/BluetoothGattService;

    move-result-object p1

    if-eqz p1, :cond_40

    .line 150
    sget-object v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->INSTANCE:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;

    sput-object p1, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->otaService:Landroid/bluetooth/BluetoothGattService;

    .line 151
    invoke-virtual {v0}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->getCharacteristicUUID()Ljava/util/UUID;

    move-result-object v1

    invoke-virtual {p1, v1}, Landroid/bluetooth/BluetoothGattService;->getCharacteristic(Ljava/util/UUID;)Landroid/bluetooth/BluetoothGattCharacteristic;

    move-result-object p1

    const/4 v1, 0x1

    .line 152
    invoke-virtual {p2, p1, v1}, Landroid/bluetooth/BluetoothGatt;->setCharacteristicNotification(Landroid/bluetooth/BluetoothGattCharacteristic;Z)Z

    .line 154
    invoke-virtual {v0}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->getDescriptorUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/bluetooth/BluetoothGattCharacteristic;->getDescriptor(Ljava/util/UUID;)Landroid/bluetooth/BluetoothGattDescriptor;

    move-result-object v0

    if-eqz v0, :cond_3a

    const-string v1, "getDescriptor(descriptorUUID)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v1, 0x2

    new-array v1, v1, [B

    .line 155
    fill-array-data v1, :array_42

    invoke-virtual {v0, v1}, Landroid/bluetooth/BluetoothGattDescriptor;->setValue([B)Z

    .line 156
    invoke-virtual {p2, v0}, Landroid/bluetooth/BluetoothGatt;->writeDescriptor(Landroid/bluetooth/BluetoothGattDescriptor;)Z

    .line 158
    :cond_3a
    new-instance p2, Lkotlin/Pair;

    invoke-direct {p2, p1, p1}, Lkotlin/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    return-object p2

    :cond_40
    const/4 p1, 0x0

    return-object p1

    :array_42
    .array-data 1
        0x1t
        0x0t
    .end array-data
.end method
