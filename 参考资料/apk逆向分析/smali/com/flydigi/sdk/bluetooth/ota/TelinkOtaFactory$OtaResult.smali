.class public final enum Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;
.super Ljava/lang/Enum;
.source "OtaFactory.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "OtaResult"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;",
        ">;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0010\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000ej\u0002\u0008\u000fj\u0002\u0008\u0010j\u0002\u0008\u0011j\u0002\u0008\u0012\u00a8\u0006\u0013"
    }
    d2 = {
        "Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;",
        "",
        "code",
        "",
        "(Ljava/lang/String;II)V",
        "OTA_RESULT_OTA_DATA_PACKET_SEQ_ERR",
        "OTA_RESULT_OTA_PACKET_INVALID",
        "OTA_RESULT_OTA_DATA_CRC_ERR",
        "OTA_RESULT_OTA_WRITE_FLASH_ERR",
        "OTA_RESULT_OTA_DATA_UNCOMPLETE",
        "OTA_RESULT_OTA_FLOW_ERR",
        "OTA_RESULT_OTA_FW_CHECK_ERR",
        "OTA_RESULT_OTA_VERSION_COMPARE_ERR",
        "OTA_RESULT_OTA_PDU_LEN_ERR",
        "OTA_RESULT_OTA_FIRMWARE_MARK_ERR",
        "OTA_RESULT_OTA_FW_SIZE_ERR",
        "OTA_RESULT_OTA_DATA_PACKET_TIMEOUT",
        "OTA_RESULT_OTA_TIMEOUT",
        "OTA_RESULT_OTA_FAIL_DUE_TO_CONNECTION_TERMINATE",
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
.field private static final synthetic $VALUES:[Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

.field public static final enum OTA_RESULT_OTA_DATA_CRC_ERR:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

.field public static final enum OTA_RESULT_OTA_DATA_PACKET_SEQ_ERR:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

.field public static final enum OTA_RESULT_OTA_DATA_PACKET_TIMEOUT:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

.field public static final enum OTA_RESULT_OTA_DATA_UNCOMPLETE:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

.field public static final enum OTA_RESULT_OTA_FAIL_DUE_TO_CONNECTION_TERMINATE:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

.field public static final enum OTA_RESULT_OTA_FIRMWARE_MARK_ERR:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

.field public static final enum OTA_RESULT_OTA_FLOW_ERR:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

.field public static final enum OTA_RESULT_OTA_FW_CHECK_ERR:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

.field public static final enum OTA_RESULT_OTA_FW_SIZE_ERR:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

.field public static final enum OTA_RESULT_OTA_PACKET_INVALID:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

.field public static final enum OTA_RESULT_OTA_PDU_LEN_ERR:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

.field public static final enum OTA_RESULT_OTA_TIMEOUT:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

.field public static final enum OTA_RESULT_OTA_VERSION_COMPARE_ERR:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

.field public static final enum OTA_RESULT_OTA_WRITE_FLASH_ERR:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;


# direct methods
.method private static final synthetic $values()[Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;
    .registers 3

    const/16 v0, 0xe

    new-array v0, v0, [Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    const/4 v1, 0x0

    sget-object v2, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;->OTA_RESULT_OTA_DATA_PACKET_SEQ_ERR:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    aput-object v2, v0, v1

    const/4 v1, 0x1

    sget-object v2, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;->OTA_RESULT_OTA_PACKET_INVALID:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    aput-object v2, v0, v1

    const/4 v1, 0x2

    sget-object v2, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;->OTA_RESULT_OTA_DATA_CRC_ERR:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    aput-object v2, v0, v1

    const/4 v1, 0x3

    sget-object v2, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;->OTA_RESULT_OTA_WRITE_FLASH_ERR:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    aput-object v2, v0, v1

    const/4 v1, 0x4

    sget-object v2, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;->OTA_RESULT_OTA_DATA_UNCOMPLETE:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    aput-object v2, v0, v1

    const/4 v1, 0x5

    sget-object v2, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;->OTA_RESULT_OTA_FLOW_ERR:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;->OTA_RESULT_OTA_FW_CHECK_ERR:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;->OTA_RESULT_OTA_VERSION_COMPARE_ERR:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;->OTA_RESULT_OTA_PDU_LEN_ERR:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;->OTA_RESULT_OTA_FIRMWARE_MARK_ERR:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;->OTA_RESULT_OTA_FW_SIZE_ERR:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;->OTA_RESULT_OTA_DATA_PACKET_TIMEOUT:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;->OTA_RESULT_OTA_TIMEOUT:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;->OTA_RESULT_OTA_FAIL_DUE_TO_CONNECTION_TERMINATE:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    aput-object v2, v0, v1

    return-object v0
.end method

.method static constructor <clinit>()V
    .registers 4

    .line 75
    new-instance v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    const-string v1, "OTA_RESULT_OTA_DATA_PACKET_SEQ_ERR"

    const/4 v2, 0x0

    const/4 v3, 0x1

    invoke-direct {v0, v1, v2, v3}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;->OTA_RESULT_OTA_DATA_PACKET_SEQ_ERR:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    .line 83
    new-instance v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    const-string v1, "OTA_RESULT_OTA_PACKET_INVALID"

    const/4 v2, 0x2

    invoke-direct {v0, v1, v3, v2}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;->OTA_RESULT_OTA_PACKET_INVALID:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    .line 88
    new-instance v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    const-string v1, "OTA_RESULT_OTA_DATA_CRC_ERR"

    const/4 v3, 0x3

    invoke-direct {v0, v1, v2, v3}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;->OTA_RESULT_OTA_DATA_CRC_ERR:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    .line 93
    new-instance v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    const-string v1, "OTA_RESULT_OTA_WRITE_FLASH_ERR"

    const/4 v2, 0x4

    invoke-direct {v0, v1, v3, v2}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;->OTA_RESULT_OTA_WRITE_FLASH_ERR:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    .line 98
    new-instance v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    const-string v1, "OTA_RESULT_OTA_DATA_UNCOMPLETE"

    const/4 v3, 0x5

    invoke-direct {v0, v1, v2, v3}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;->OTA_RESULT_OTA_DATA_UNCOMPLETE:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    .line 103
    new-instance v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    const-string v1, "OTA_RESULT_OTA_FLOW_ERR"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v3, v2}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;->OTA_RESULT_OTA_FLOW_ERR:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    .line 108
    new-instance v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    const-string v1, "OTA_RESULT_OTA_FW_CHECK_ERR"

    const/4 v3, 0x7

    invoke-direct {v0, v1, v2, v3}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;->OTA_RESULT_OTA_FW_CHECK_ERR:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    .line 113
    new-instance v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    const-string v1, "OTA_RESULT_OTA_VERSION_COMPARE_ERR"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v3, v2}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;->OTA_RESULT_OTA_VERSION_COMPARE_ERR:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    .line 118
    new-instance v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    const-string v1, "OTA_RESULT_OTA_PDU_LEN_ERR"

    const/16 v3, 0x9

    invoke-direct {v0, v1, v2, v3}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;->OTA_RESULT_OTA_PDU_LEN_ERR:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    .line 123
    new-instance v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    const-string v1, "OTA_RESULT_OTA_FIRMWARE_MARK_ERR"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v3, v2}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;->OTA_RESULT_OTA_FIRMWARE_MARK_ERR:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    .line 128
    new-instance v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    const-string v1, "OTA_RESULT_OTA_FW_SIZE_ERR"

    const/16 v3, 0xb

    invoke-direct {v0, v1, v2, v3}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;->OTA_RESULT_OTA_FW_SIZE_ERR:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    .line 133
    new-instance v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    const-string v1, "OTA_RESULT_OTA_DATA_PACKET_TIMEOUT"

    const/16 v2, 0xc

    invoke-direct {v0, v1, v3, v2}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;->OTA_RESULT_OTA_DATA_PACKET_TIMEOUT:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    .line 138
    new-instance v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    const-string v1, "OTA_RESULT_OTA_TIMEOUT"

    const/16 v3, 0xd

    invoke-direct {v0, v1, v2, v3}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;->OTA_RESULT_OTA_TIMEOUT:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    .line 143
    new-instance v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    const-string v1, "OTA_RESULT_OTA_FAIL_DUE_TO_CONNECTION_TERMINATE"

    const/16 v2, 0xe

    invoke-direct {v0, v1, v3, v2}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;->OTA_RESULT_OTA_FAIL_DUE_TO_CONNECTION_TERMINATE:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    invoke-static {}, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;->$values()[Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    move-result-object v0

    sput-object v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;->$VALUES:[Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .line 71
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;
    .registers 2

    const-class v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    return-object p0
.end method

.method public static values()[Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;
    .registers 1

    sget-object v0, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;->$VALUES:[Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    invoke-virtual {v0}, [Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory$OtaResult;

    return-object v0
.end method
