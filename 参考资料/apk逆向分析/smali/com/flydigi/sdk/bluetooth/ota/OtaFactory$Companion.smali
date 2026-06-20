.class public final Lcom/flydigi/sdk/bluetooth/ota/OtaFactory$Companion;
.super Ljava/lang/Object;
.source "OtaFactory.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Companion"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"
    }
    d2 = {
        "Lcom/flydigi/sdk/bluetooth/ota/OtaFactory$Companion;",
        "",
        "()V",
        "createOtaFactory",
        "Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;",
        "chipType",
        "",
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
.field static final synthetic $$INSTANCE:Lcom/flydigi/sdk/bluetooth/ota/OtaFactory$Companion;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lcom/flydigi/sdk/bluetooth/ota/OtaFactory$Companion;

    invoke-direct {v0}, Lcom/flydigi/sdk/bluetooth/ota/OtaFactory$Companion;-><init>()V

    sput-object v0, Lcom/flydigi/sdk/bluetooth/ota/OtaFactory$Companion;->$$INSTANCE:Lcom/flydigi/sdk/bluetooth/ota/OtaFactory$Companion;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final createOtaFactory(I)Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;
    .registers 3

    const/4 v0, 0x1

    if-eq p1, v0, :cond_15

    const/4 v0, 0x2

    if-eq p1, v0, :cond_10

    const/4 v0, 0x3

    if-eq p1, v0, :cond_b

    const/4 p1, 0x0

    goto :goto_19

    .line 41
    :cond_b
    sget-object p1, Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;->INSTANCE:Lcom/flydigi/sdk/bluetooth/ota/TelinkOtaFactory;

    check-cast p1, Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;

    goto :goto_19

    .line 43
    :cond_10
    sget-object p1, Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;->INSTANCE:Lcom/flydigi/sdk/bluetooth/ota/KrlyOtaFactory;

    check-cast p1, Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;

    goto :goto_19

    .line 42
    :cond_15
    sget-object p1, Lcom/flydigi/sdk/bluetooth/ota/WchOtaFactory;->INSTANCE:Lcom/flydigi/sdk/bluetooth/ota/WchOtaFactory;

    check-cast p1, Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;

    :goto_19
    return-object p1
.end method
