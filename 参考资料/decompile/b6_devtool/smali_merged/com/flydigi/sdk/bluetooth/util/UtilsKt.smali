.class public final Lcom/flydigi/sdk/bluetooth/util/UtilsKt;
.super Ljava/lang/Object;
.source "Utils.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u00a8\u0006\u0004"
    }
    d2 = {
        "generateCRCByte",
        "",
        "value",
        "",
        "bluetooth_release"
    }
    k = 0x2
    mv = {
        0x1,
        0x8,
        0x0
    }
    xi = 0x30
.end annotation


# direct methods
.method public static final generateCRCByte([B)V
    .registers 4

    const-string v0, "value"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 5
    array-length v0, p0

    const/16 v1, 0x14

    if-ne v0, v1, :cond_1b

    const/4 v0, 0x0

    move v1, v0

    :goto_c
    const/16 v2, 0x13

    if-ge v0, v2, :cond_16

    .line 8
    aget-byte v2, p0, v0

    add-int/2addr v1, v2

    add-int/lit8 v0, v0, 0x1

    goto :goto_c

    :cond_16
    and-int/lit16 v0, v1, 0xff

    int-to-byte v0, v0

    .line 9
    aput-byte v0, p0, v2

    :cond_1b
    return-void
.end method
