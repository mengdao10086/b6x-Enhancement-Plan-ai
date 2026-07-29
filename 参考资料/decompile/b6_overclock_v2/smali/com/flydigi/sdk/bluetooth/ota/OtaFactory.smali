.class public interface abstract Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;
.super Ljava/lang/Object;
.source "OtaFactory.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/flydigi/sdk/bluetooth/ota/OtaFactory$Companion;,
        Lcom/flydigi/sdk/bluetooth/ota/OtaFactory$DefaultImpls;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0005\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008v\u0018\u0000 ,2\u00020\u0001:\u0001,J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H&J$\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00140\u00130\u00122\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&J$\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00140\u00122\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\tH&J\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\u0008\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003H&J\"\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00140\u00130\u00122\u0006\u0010\u001d\u001a\u00020\tH&J\u0017\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u0014H&\u00a2\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0014H&J\u0010\u0010#\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0014H&J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0014H&J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0014H&J\u0010\u0010&\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0014H&J\u001a\u0010\'\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00140\u00130\u0012H&J(\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u00122\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020+H&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0005R\u0012\u0010\u0008\u001a\u00020\tX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0012\u0010\u000c\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\u0008\r\u0010\u0005\u0082\u0001\u0003-./\u00a8\u00060"
    }
    d2 = {
        "Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;",
        "",
        "characteristicUUID",
        "Ljava/util/UUID;",
        "getCharacteristicUUID",
        "()Ljava/util/UUID;",
        "descriptorUUID",
        "getDescriptorUUID",
        "packetLength",
        "",
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
        "Companion",
        "Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;",
        "Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;",
        "Lcom/flydigi/sdk/bluetooth/ota/WchOtaFactory;",
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
.field public static final Companion:Lcom/flydigi/sdk/bluetooth/ota/OtaFactory$Companion;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    sget-object v0, Lcom/flydigi/sdk/bluetooth/ota/OtaFactory$Companion;->$$INSTANCE:Lcom/flydigi/sdk/bluetooth/ota/OtaFactory$Companion;

    sput-object v0, Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;->Companion:Lcom/flydigi/sdk/bluetooth/ota/OtaFactory$Companion;

    return-void
.end method


# virtual methods
.method public abstract checkCallback(Ljava/util/UUID;)Z
.end method

.method public abstract checkOtaReadyCmd([B)Lkotlin/Pair;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([B)",
            "Lkotlin/Pair<",
            "Ljava/util/UUID;",
            "Ljava/util/List<",
            "[B>;>;"
        }
    .end annotation
.end method

.method public abstract fillData([BI)Lkotlin/Pair;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([BI)",
            "Lkotlin/Pair<",
            "Ljava/util/UUID;",
            "[B>;"
        }
    .end annotation
.end method

.method public abstract getCharacteristicUUID()Ljava/util/UUID;
.end method

.method public abstract getDescriptorUUID()Ljava/util/UUID;
.end method

.method public abstract getOtaCharacteristic(Ljava/util/UUID;)Landroid/bluetooth/BluetoothGattCharacteristic;
.end method

.method public abstract getOtaEndCmd(I)Lkotlin/Pair;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Lkotlin/Pair<",
            "Ljava/util/UUID;",
            "Ljava/util/List<",
            "[B>;>;"
        }
    .end annotation
.end method

.method public abstract getOtaResultCode([B)Ljava/lang/Byte;
.end method

.method public abstract getPacketLength()I
.end method

.method public abstract getServiceUUID()Ljava/util/UUID;
.end method

.method public abstract handleCharacteristic([B)Z
.end method

.method public abstract isEndCmd([B)Z
.end method

.method public abstract isOtaReady([B)Z
.end method

.method public abstract isOtaResultCmd([B)Z
.end method

.method public abstract isOtaSuccess([B)Z
.end method

.method public abstract requestOtaDataCheckSize()Lkotlin/Pair;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lkotlin/Pair<",
            "Ljava/util/UUID;",
            "Ljava/util/List<",
            "[B>;>;"
        }
    .end annotation
.end method

.method public abstract setupOta(ILandroid/bluetooth/BluetoothGatt;)Lkotlin/Pair;
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
.end method
