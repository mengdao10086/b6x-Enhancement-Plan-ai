.class public final Lcom/flydigi/sdk/bluetooth/ScanMode;
.super Ljava/lang/Object;
.source "Constance.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/flydigi/sdk/bluetooth/ScanMode$Type;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0008\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\nB\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"
    }
    d2 = {
        "Lcom/flydigi/sdk/bluetooth/ScanMode;",
        "",
        "()V",
        "SCAN_MODE_CLASSIC",
        "",
        "SCAN_MODE_LE",
        "SCAN_MODE_LE_BALANCED",
        "SCAN_MODE_LE_LOW_LATENCY",
        "SCAN_MODE_LE_LOW_POWER",
        "SCAN_MODE_LE_OPPORTUNISTIC",
        "Type",
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
.field public static final INSTANCE:Lcom/flydigi/sdk/bluetooth/ScanMode;

.field public static final SCAN_MODE_CLASSIC:I = 0x1

.field public static final SCAN_MODE_LE:I = 0x2

.field public static final SCAN_MODE_LE_BALANCED:I = 0x5

.field public static final SCAN_MODE_LE_LOW_LATENCY:I = 0x6

.field public static final SCAN_MODE_LE_LOW_POWER:I = 0x4

.field public static final SCAN_MODE_LE_OPPORTUNISTIC:I = 0x3


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lcom/flydigi/sdk/bluetooth/ScanMode;

    invoke-direct {v0}, Lcom/flydigi/sdk/bluetooth/ScanMode;-><init>()V

    sput-object v0, Lcom/flydigi/sdk/bluetooth/ScanMode;->INSTANCE:Lcom/flydigi/sdk/bluetooth/ScanMode;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
