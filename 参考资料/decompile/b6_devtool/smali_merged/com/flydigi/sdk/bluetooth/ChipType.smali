.class public final Lcom/flydigi/sdk/bluetooth/ChipType;
.super Ljava/lang/Object;
.source "Constance.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/flydigi/sdk/bluetooth/ChipType$TYPE;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0006\u0008\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"
    }
    d2 = {
        "Lcom/flydigi/sdk/bluetooth/ChipType;",
        "",
        "()V",
        "TYPE_KRLY",
        "",
        "TYPE_NORDIC",
        "TYPE_TELINK",
        "TYPE_UNKNOWN",
        "TYPE_WCH",
        "TYPE",
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
.field public static final INSTANCE:Lcom/flydigi/sdk/bluetooth/ChipType;

.field public static final TYPE_KRLY:I = 0x2

.field public static final TYPE_NORDIC:I = 0x0

.field public static final TYPE_TELINK:I = 0x3

.field public static final TYPE_UNKNOWN:I = -0x1

.field public static final TYPE_WCH:I = 0x1


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lcom/flydigi/sdk/bluetooth/ChipType;

    invoke-direct {v0}, Lcom/flydigi/sdk/bluetooth/ChipType;-><init>()V

    sput-object v0, Lcom/flydigi/sdk/bluetooth/ChipType;->INSTANCE:Lcom/flydigi/sdk/bluetooth/ChipType;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .line 133
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
