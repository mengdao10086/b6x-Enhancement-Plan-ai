.class public final Lcom/flydigi/sdk/bluetooth/data/BleDevice;
.super Ljava/lang/Object;
.source "BleDevice.kt"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\u000cJ\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010!\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\t\u0010#\u001a\u00020\u000bH\u00c6\u0003J?\u0010$\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000bH\u00c6\u0001J\t\u0010%\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010&\u001a\u00020\'2\u0008\u0010(\u001a\u0004\u0018\u00010)H\u00d6\u0003J\t\u0010*\u001a\u00020\u0007H\u00d6\u0001J\t\u0010+\u001a\u00020\u0005H\u00d6\u0001J\u0019\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0007H\u00d6\u0001R\u001c\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014\"\u0004\u0008\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001aR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u001b\u0010\u001c\"\u0004\u0008\u001d\u0010\u001e\u00a8\u00061"
    }
    d2 = {
        "Lcom/flydigi/sdk/bluetooth/data/BleDevice;",
        "Landroid/os/Parcelable;",
        "device",
        "Landroid/bluetooth/BluetoothDevice;",
        "deviceName",
        "",
        "rssi",
        "",
        "bytes",
        "",
        "timestampNanos",
        "",
        "(Landroid/bluetooth/BluetoothDevice;Ljava/lang/String;I[BJ)V",
        "getBytes",
        "()[B",
        "setBytes",
        "([B)V",
        "getDevice",
        "()Landroid/bluetooth/BluetoothDevice;",
        "getDeviceName",
        "()Ljava/lang/String;",
        "setDeviceName",
        "(Ljava/lang/String;)V",
        "getRssi",
        "()I",
        "setRssi",
        "(I)V",
        "getTimestampNanos",
        "()J",
        "setTimestampNanos",
        "(J)V",
        "component1",
        "component2",
        "component3",
        "component4",
        "component5",
        "copy",
        "describeContents",
        "equals",
        "",
        "other",
        "",
        "hashCode",
        "toString",
        "writeToParcel",
        "",
        "parcel",
        "Landroid/os/Parcel;",
        "flags",
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
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator<",
            "Lcom/flydigi/sdk/bluetooth/data/BleDevice;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private bytes:[B

.field private final device:Landroid/bluetooth/BluetoothDevice;

.field private deviceName:Ljava/lang/String;

.field private rssi:I

.field private timestampNanos:J


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lcom/flydigi/sdk/bluetooth/data/BleDevice$Creator;

    invoke-direct {v0}, Lcom/flydigi/sdk/bluetooth/data/BleDevice$Creator;-><init>()V

    check-cast v0, Landroid/os/Parcelable$Creator;

    sput-object v0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Landroid/bluetooth/BluetoothDevice;Ljava/lang/String;I[BJ)V
    .registers 8

    const-string v0, "device"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->device:Landroid/bluetooth/BluetoothDevice;

    .line 21
    iput-object p2, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->deviceName:Ljava/lang/String;

    .line 22
    iput p3, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->rssi:I

    .line 23
    iput-object p4, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->bytes:[B

    .line 24
    iput-wide p5, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->timestampNanos:J

    return-void
.end method

.method public synthetic constructor <init>(Landroid/bluetooth/BluetoothDevice;Ljava/lang/String;I[BJILkotlin/jvm/internal/DefaultConstructorMarker;)V
    .registers 18

    and-int/lit8 v0, p7, 0x2

    const/4 v1, 0x0

    if-eqz v0, :cond_7

    move-object v4, v1

    goto :goto_8

    :cond_7
    move-object v4, p2

    :goto_8
    and-int/lit8 v0, p7, 0x8

    if-eqz v0, :cond_e

    move-object v6, v1

    goto :goto_f

    :cond_e
    move-object v6, p4

    :goto_f
    move-object v2, p0

    move-object v3, p1

    move v5, p3

    move-wide v7, p5

    .line 19
    invoke-direct/range {v2 .. v8}, Lcom/flydigi/sdk/bluetooth/data/BleDevice;-><init>(Landroid/bluetooth/BluetoothDevice;Ljava/lang/String;I[BJ)V

    return-void
.end method

.method public static synthetic copy$default(Lcom/flydigi/sdk/bluetooth/data/BleDevice;Landroid/bluetooth/BluetoothDevice;Ljava/lang/String;I[BJILjava/lang/Object;)Lcom/flydigi/sdk/bluetooth/data/BleDevice;
    .registers 13

    and-int/lit8 p8, p7, 0x1

    if-eqz p8, :cond_6

    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->device:Landroid/bluetooth/BluetoothDevice;

    :cond_6
    and-int/lit8 p8, p7, 0x2

    if-eqz p8, :cond_c

    iget-object p2, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->deviceName:Ljava/lang/String;

    :cond_c
    move-object p8, p2

    and-int/lit8 p2, p7, 0x4

    if-eqz p2, :cond_13

    iget p3, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->rssi:I

    :cond_13
    move v0, p3

    and-int/lit8 p2, p7, 0x8

    if-eqz p2, :cond_1a

    iget-object p4, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->bytes:[B

    :cond_1a
    move-object v1, p4

    and-int/lit8 p2, p7, 0x10

    if-eqz p2, :cond_21

    iget-wide p5, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->timestampNanos:J

    :cond_21
    move-wide v2, p5

    move-object p2, p0

    move-object p3, p1

    move-object p4, p8

    move p5, v0

    move-object p6, v1

    move-wide p7, v2

    invoke-virtual/range {p2 .. p8}, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->copy(Landroid/bluetooth/BluetoothDevice;Ljava/lang/String;I[BJ)Lcom/flydigi/sdk/bluetooth/data/BleDevice;

    move-result-object p0

    return-object p0
.end method


# virtual methods
.method public final component1()Landroid/bluetooth/BluetoothDevice;
    .registers 2

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->device:Landroid/bluetooth/BluetoothDevice;

    return-object v0
.end method

.method public final component2()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->deviceName:Ljava/lang/String;

    return-object v0
.end method

.method public final component3()I
    .registers 2

    iget v0, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->rssi:I

    return v0
.end method

.method public final component4()[B
    .registers 2

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->bytes:[B

    return-object v0
.end method

.method public final component5()J
    .registers 3

    iget-wide v0, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->timestampNanos:J

    return-wide v0
.end method

.method public final copy(Landroid/bluetooth/BluetoothDevice;Ljava/lang/String;I[BJ)Lcom/flydigi/sdk/bluetooth/data/BleDevice;
    .registers 15

    const-string v0, "device"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    new-instance v0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;

    move-object v1, v0

    move-object v2, p1

    move-object v3, p2

    move v4, p3

    move-object v5, p4

    move-wide v6, p5

    invoke-direct/range {v1 .. v7}, Lcom/flydigi/sdk/bluetooth/data/BleDevice;-><init>(Landroid/bluetooth/BluetoothDevice;Ljava/lang/String;I[BJ)V

    return-object v0
.end method

.method public describeContents()I
    .registers 2

    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 9

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    instance-of v1, p1, Lcom/flydigi/sdk/bluetooth/data/BleDevice;

    const/4 v2, 0x0

    if-nez v1, :cond_a

    return v2

    :cond_a
    check-cast p1, Lcom/flydigi/sdk/bluetooth/data/BleDevice;

    iget-object v1, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->device:Landroid/bluetooth/BluetoothDevice;

    iget-object v3, p1, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->device:Landroid/bluetooth/BluetoothDevice;

    invoke-static {v1, v3}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_17

    return v2

    :cond_17
    iget-object v1, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->deviceName:Ljava/lang/String;

    iget-object v3, p1, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->deviceName:Ljava/lang/String;

    invoke-static {v1, v3}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_22

    return v2

    :cond_22
    iget v1, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->rssi:I

    iget v3, p1, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->rssi:I

    if-eq v1, v3, :cond_29

    return v2

    :cond_29
    iget-object v1, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->bytes:[B

    iget-object v3, p1, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->bytes:[B

    invoke-static {v1, v3}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_34

    return v2

    :cond_34
    iget-wide v3, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->timestampNanos:J

    iget-wide v5, p1, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->timestampNanos:J

    cmp-long p1, v3, v5

    if-eqz p1, :cond_3d

    return v2

    :cond_3d
    return v0
.end method

.method public final getBytes()[B
    .registers 2

    .line 23
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->bytes:[B

    return-object v0
.end method

.method public final getDevice()Landroid/bluetooth/BluetoothDevice;
    .registers 2

    .line 20
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->device:Landroid/bluetooth/BluetoothDevice;

    return-object v0
.end method

.method public final getDeviceName()Ljava/lang/String;
    .registers 2

    .line 21
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->deviceName:Ljava/lang/String;

    return-object v0
.end method

.method public final getRssi()I
    .registers 2

    .line 22
    iget v0, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->rssi:I

    return v0
.end method

.method public final getTimestampNanos()J
    .registers 3

    .line 24
    iget-wide v0, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->timestampNanos:J

    return-wide v0
.end method

.method public hashCode()I
    .registers 4

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->device:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothDevice;->hashCode()I

    move-result v0

    mul-int/lit8 v0, v0, 0x1f

    iget-object v1, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->deviceName:Ljava/lang/String;

    const/4 v2, 0x0

    if-nez v1, :cond_f

    move v1, v2

    goto :goto_13

    :cond_f
    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :goto_13
    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    iget v1, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->rssi:I

    invoke-static {v1}, Ljava/lang/Integer;->hashCode(I)I

    move-result v1

    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    iget-object v1, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->bytes:[B

    if-nez v1, :cond_24

    goto :goto_28

    :cond_24
    invoke-static {v1}, Ljava/util/Arrays;->hashCode([B)I

    move-result v2

    :goto_28
    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget-wide v1, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->timestampNanos:J

    invoke-static {v1, v2}, Ljava/lang/Long;->hashCode(J)I

    move-result v1

    add-int/2addr v0, v1

    return v0
.end method

.method public final setBytes([B)V
    .registers 2

    .line 23
    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->bytes:[B

    return-void
.end method

.method public final setDeviceName(Ljava/lang/String;)V
    .registers 2

    .line 21
    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->deviceName:Ljava/lang/String;

    return-void
.end method

.method public final setRssi(I)V
    .registers 2

    .line 22
    iput p1, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->rssi:I

    return-void
.end method

.method public final setTimestampNanos(J)V
    .registers 3

    .line 24
    iput-wide p1, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->timestampNanos:J

    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "BleDevice(device="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->device:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", deviceName="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->deviceName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", rssi="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->rssi:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", bytes="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->bytes:[B

    invoke-static {v1}, Ljava/util/Arrays;->toString([B)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", timestampNanos="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v1, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->timestampNanos:J

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x29

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 5

    const-string v0, "out"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->device:Landroid/bluetooth/BluetoothDevice;

    check-cast v0, Landroid/os/Parcelable;

    invoke-virtual {p1, v0, p2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    iget-object p2, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->deviceName:Ljava/lang/String;

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget p2, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->rssi:I

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeInt(I)V

    iget-object p2, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->bytes:[B

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeByteArray([B)V

    iget-wide v0, p0, Lcom/flydigi/sdk/bluetooth/data/BleDevice;->timestampNanos:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    return-void
.end method
