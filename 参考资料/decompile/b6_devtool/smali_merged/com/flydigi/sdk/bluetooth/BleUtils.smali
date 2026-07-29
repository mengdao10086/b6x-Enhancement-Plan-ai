.class public final Lcom/flydigi/sdk/bluetooth/BleUtils;
.super Ljava/lang/Object;
.source "BleUtils.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "BleUtils"


# direct methods
.method static constructor <clinit>()V
    .registers 0

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static readDeviceNameFromScanRecord([B)Ljava/lang/String;
    .registers 10

    .line 19
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    const/4 v1, 0x0

    if-eqz p0, :cond_89

    .line 24
    :try_start_8
    invoke-static {p0}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object p0

    sget-object v2, Ljava/nio/ByteOrder;->LITTLE_ENDIAN:Ljava/nio/ByteOrder;

    invoke-virtual {p0, v2}, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;

    move-result-object p0

    .line 25
    :cond_12
    :goto_12
    invoke-virtual {p0}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v2

    const/4 v3, 0x2

    if-le v2, v3, :cond_89

    .line 26
    invoke-virtual {p0}, Ljava/nio/ByteBuffer;->get()B

    move-result v2

    if-nez v2, :cond_20

    goto :goto_89

    .line 29
    :cond_20
    invoke-virtual {p0}, Ljava/nio/ByteBuffer;->get()B

    move-result v4

    const/4 v5, 0x1

    if-eq v4, v3, :cond_66

    const/4 v6, 0x3

    if-eq v4, v6, :cond_66

    const/4 v3, 0x6

    if-eq v4, v3, :cond_4e

    const/4 v3, 0x7

    if-eq v4, v3, :cond_4e

    const/16 v3, 0x9

    if-eq v4, v3, :cond_3e

    .line 57
    invoke-virtual {p0}, Ljava/nio/ByteBuffer;->position()I

    move-result v3

    add-int/2addr v3, v2

    sub-int/2addr v3, v5

    .line 58
    invoke-virtual {p0, v3}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    goto :goto_12

    :cond_3e
    add-int/lit8 v2, v2, -0x1

    .line 52
    new-array v1, v2, [B

    .line 53
    invoke-virtual {p0, v1}, Ljava/nio/ByteBuffer;->get([B)Ljava/nio/ByteBuffer;

    .line 54
    new-instance v2, Ljava/lang/String;

    sget-object v3, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-direct {v2, v1, v3}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    move-object v1, v2

    goto :goto_12

    :cond_4e
    :goto_4e
    const/16 v3, 0x10

    if-lt v2, v3, :cond_12

    .line 45
    invoke-virtual {p0}, Ljava/nio/ByteBuffer;->getLong()J

    move-result-wide v3

    .line 46
    invoke-virtual {p0}, Ljava/nio/ByteBuffer;->getLong()J

    move-result-wide v5

    .line 47
    new-instance v7, Ljava/util/UUID;

    invoke-direct {v7, v5, v6, v3, v4}, Ljava/util/UUID;-><init>(JJ)V

    invoke-interface {v0, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v2, v2, -0x10

    int-to-byte v2, v2

    goto :goto_4e

    :cond_66
    :goto_66
    if-lt v2, v3, :cond_12

    const-string v4, "%08x-0000-1000-8000-00805f9b34fb"

    new-array v6, v5, [Ljava/lang/Object;

    .line 38
    invoke-virtual {p0}, Ljava/nio/ByteBuffer;->getShort()S

    move-result v7

    invoke-static {v7}, Ljava/lang/Short;->valueOf(S)Ljava/lang/Short;

    move-result-object v7

    const/4 v8, 0x0

    aput-object v7, v6, v8

    .line 36
    invoke-static {v4, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    .line 35
    invoke-static {v4}, Ljava/util/UUID;->fromString(Ljava/lang/String;)Ljava/util/UUID;

    move-result-object v4

    .line 34
    invoke-interface {v0, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_82
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_82} :catch_86

    add-int/lit8 v2, v2, -0x2

    int-to-byte v2, v2

    goto :goto_66

    :catch_86
    const-string p0, ""

    goto :goto_8a

    :cond_89
    :goto_89
    move-object p0, v1

    :goto_8a
    return-object p0
.end method
