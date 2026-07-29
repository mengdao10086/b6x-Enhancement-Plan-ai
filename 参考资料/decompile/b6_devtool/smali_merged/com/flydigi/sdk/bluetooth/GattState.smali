.class public final Lcom/flydigi/sdk/bluetooth/GattState;
.super Ljava/lang/Object;
.source "Constance.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/flydigi/sdk/bluetooth/GattState$Code;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\u0008\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0008"
    }
    d2 = {
        "Lcom/flydigi/sdk/bluetooth/GattState;",
        "",
        "()V",
        "STATE_GATT_CONNECTED",
        "",
        "STATE_GATT_CONNECTING",
        "STATE_GATT_DISCONNECTED",
        "Code",
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
.field public static final INSTANCE:Lcom/flydigi/sdk/bluetooth/GattState;

.field public static final STATE_GATT_CONNECTED:I = 0x2

.field public static final STATE_GATT_CONNECTING:I = 0x1

.field public static final STATE_GATT_DISCONNECTED:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lcom/flydigi/sdk/bluetooth/GattState;

    invoke-direct {v0}, Lcom/flydigi/sdk/bluetooth/GattState;-><init>()V

    sput-object v0, Lcom/flydigi/sdk/bluetooth/GattState;->INSTANCE:Lcom/flydigi/sdk/bluetooth/GattState;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .line 107
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
