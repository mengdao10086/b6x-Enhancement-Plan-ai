.class public final Lcom/flydigi/sdk/waspwing/LedType;
.super Ljava/lang/Object;
.source "Constance.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/flydigi/sdk/waspwing/LedType$Type;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u000e\u0008\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"
    }
    d2 = {
        "Lcom/flydigi/sdk/waspwing/LedType;",
        "",
        "()V",
        "LED_TYPE_BLACK",
        "",
        "LED_TYPE_BLINKING",
        "LED_TYPE_BREATH",
        "LED_TYPE_CORONA",
        "LED_TYPE_GRADUAL",
        "LED_TYPE_LONG",
        "LED_TYPE_OFF",
        "LED_TYPE_RAINBOW",
        "LED_TYPE_RAINBOW_SMART",
        "LED_TYPE_SHUTDOWN",
        "LED_TYPE_STARTING",
        "LED_TYPE_TWO_SHUTDOWN",
        "LED_TYPE_TWO_STARTING",
        "Type",
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
.field public static final INSTANCE:Lcom/flydigi/sdk/waspwing/LedType;

.field public static final LED_TYPE_BLACK:I = 0xa

.field public static final LED_TYPE_BLINKING:I = 0x7

.field public static final LED_TYPE_BREATH:I = 0x5

.field public static final LED_TYPE_CORONA:I = 0x4

.field public static final LED_TYPE_GRADUAL:I = 0x6

.field public static final LED_TYPE_LONG:I = 0xb

.field public static final LED_TYPE_OFF:I = 0x0

.field public static final LED_TYPE_RAINBOW:I = 0x3

.field public static final LED_TYPE_RAINBOW_SMART:I = 0xc

.field public static final LED_TYPE_SHUTDOWN:I = 0x2

.field public static final LED_TYPE_STARTING:I = 0x1

.field public static final LED_TYPE_TWO_SHUTDOWN:I = 0x9

.field public static final LED_TYPE_TWO_STARTING:I = 0x8


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lcom/flydigi/sdk/waspwing/LedType;

    invoke-direct {v0}, Lcom/flydigi/sdk/waspwing/LedType;-><init>()V

    sput-object v0, Lcom/flydigi/sdk/waspwing/LedType;->INSTANCE:Lcom/flydigi/sdk/waspwing/LedType;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .line 63
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
