.class public final Lcom/flydigi/sdk/bluetooth/DeviceNamePrefix;
.super Ljava/lang/Object;
.source "Constance.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/flydigi/sdk/bluetooth/DeviceNamePrefix$Mode;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\u0008\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"
    }
    d2 = {
        "Lcom/flydigi/sdk/bluetooth/DeviceNamePrefix;",
        "",
        "()V",
        "DEVICE_PREFIX",
        "",
        "DEVICE_PREFIX_CHDFU",
        "DEVICE_PREFIX_DFU",
        "DEVICE_PREFIX_DFU_KRLY",
        "DEVICE_PREFIX_NEW",
        "Mode",
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
.field public static final DEVICE_PREFIX:Ljava/lang/String; = "Feizhi"

.field public static final DEVICE_PREFIX_CHDFU:Ljava/lang/String; = "chdfu"

.field public static final DEVICE_PREFIX_DFU:Ljava/lang/String; = "dfu"

.field public static final DEVICE_PREFIX_DFU_KRLY:Ljava/lang/String; = "DFU Flydigi "

.field public static final DEVICE_PREFIX_NEW:Ljava/lang/String; = "Flydigi"

.field public static final INSTANCE:Lcom/flydigi/sdk/bluetooth/DeviceNamePrefix;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lcom/flydigi/sdk/bluetooth/DeviceNamePrefix;

    invoke-direct {v0}, Lcom/flydigi/sdk/bluetooth/DeviceNamePrefix;-><init>()V

    sput-object v0, Lcom/flydigi/sdk/bluetooth/DeviceNamePrefix;->INSTANCE:Lcom/flydigi/sdk/bluetooth/DeviceNamePrefix;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
