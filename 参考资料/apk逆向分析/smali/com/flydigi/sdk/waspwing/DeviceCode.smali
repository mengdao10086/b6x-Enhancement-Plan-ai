.class public final Lcom/flydigi/sdk/waspwing/DeviceCode;
.super Ljava/lang/Object;
.source "Constance.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0008\u0008\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000c"
    }
    d2 = {
        "Lcom/flydigi/sdk/waspwing/DeviceCode;",
        "",
        "()V",
        "DEVICE_CODE_ALL",
        "",
        "DEVICE_CODE_B3",
        "DEVICE_CODE_B5",
        "DEVICE_CODE_B5P",
        "DEVICE_CODE_B6",
        "DEVICE_CODE_B6X",
        "getDeviceCodeFromBtName",
        "btName",
        "sdk_waspwing_release"
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
.field public static final DEVICE_CODE_ALL:Ljava/lang/String; = "all"

.field public static final DEVICE_CODE_B3:Ljava/lang/String; = "b3"

.field public static final DEVICE_CODE_B5:Ljava/lang/String; = "b5"

.field public static final DEVICE_CODE_B5P:Ljava/lang/String; = "b5p"

.field public static final DEVICE_CODE_B6:Ljava/lang/String; = "b6"

.field public static final DEVICE_CODE_B6X:Ljava/lang/String; = "b6x"

.field public static final INSTANCE:Lcom/flydigi/sdk/waspwing/DeviceCode;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lcom/flydigi/sdk/waspwing/DeviceCode;

    invoke-direct {v0}, Lcom/flydigi/sdk/waspwing/DeviceCode;-><init>()V

    sput-object v0, Lcom/flydigi/sdk/waspwing/DeviceCode;->INSTANCE:Lcom/flydigi/sdk/waspwing/DeviceCode;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final getDeviceCodeFromBtName(Ljava/lang/String;)Ljava/lang/String;
    .registers 3

    if-eqz p1, :cond_4f

    .line 18
    invoke-virtual {p1}, Ljava/lang/String;->hashCode()I

    move-result v0

    sparse-switch v0, :sswitch_data_52

    goto :goto_4f

    :sswitch_a
    const-string v0, "Flydigi B6X"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_13

    goto :goto_4f

    :cond_13
    const-string p1, "b6x"

    goto :goto_51

    :sswitch_16
    const-string v0, "Flydigi B5X"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_40

    goto :goto_4f

    :sswitch_1f
    const-string v0, "Flydigi B6"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_28

    goto :goto_4f

    :cond_28
    const-string p1, "b6"

    goto :goto_51

    :sswitch_2b
    const-string v0, "Flydigi B5"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_34

    goto :goto_4f

    :cond_34
    const-string p1, "b5"

    goto :goto_51

    :sswitch_37
    const-string v0, "Flydigi B5Pro"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_40

    goto :goto_4f

    :cond_40
    const-string p1, "b5p"

    goto :goto_51

    :sswitch_43
    const-string v0, "Flydigi Waspwing2 Pro"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_4c

    goto :goto_4f

    :cond_4c
    const-string p1, "b3"

    goto :goto_51

    :cond_4f
    :goto_4f
    const-string p1, "all"

    :goto_51
    return-object p1

    :sswitch_data_52
    .sparse-switch
        -0x38ed2519 -> :sswitch_43
        -0x34026f2c -> :sswitch_37
        -0x2aa658e7 -> :sswitch_2b
        -0x2aa658e6 -> :sswitch_1f
        -0x2a24c3a1 -> :sswitch_16
        -0x2a24c382 -> :sswitch_a
    .end sparse-switch
.end method
