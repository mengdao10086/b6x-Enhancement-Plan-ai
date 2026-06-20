.class final Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$checkLocationServiceEnabledRunnable$2;
.super Lkotlin/jvm/internal/Lambda;
.source "AbstractBluetoothController.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function0;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;-><init>(Landroid/content/Context;Lcom/flydigi/sdk/bluetooth/DeviceFilter;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/Lambda;",
        "Lkotlin/jvm/functions/Function0<",
        "Ljava/lang/Runnable;",
        ">;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\u0008\u0002"
    }
    d2 = {
        "<anonymous>",
        "Ljava/lang/Runnable;",
        "invoke"
    }
    k = 0x3
    mv = {
        0x1,
        0x8,
        0x0
    }
    xi = 0x30
.end annotation


# instance fields
.field final synthetic this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;


# direct methods
.method public static synthetic $r8$lambda$Cdjo5pAjwM6uHgnC8FoHpbEaJOQ(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V
    .registers 1

    invoke-static {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$checkLocationServiceEnabledRunnable$2;->invoke$lambda$0(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V

    return-void
.end method

.method constructor <init>(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V
    .registers 2

    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$checkLocationServiceEnabledRunnable$2;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    const/4 p1, 0x0

    invoke-direct {p0, p1}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method

.method private static final invoke$lambda$0(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V
    .registers 3

    const-string v0, "this$0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x0

    const/4 v1, 0x1

    .line 330
    invoke-static {p0, v0, v1, v0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->checkLocationServiceEnabled$default(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;Ljava/lang/Boolean;ILjava/lang/Object;)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke()Ljava/lang/Object;
    .registers 2

    .line 328
    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$checkLocationServiceEnabledRunnable$2;->invoke()Ljava/lang/Runnable;

    move-result-object v0

    return-object v0
.end method

.method public final invoke()Ljava/lang/Runnable;
    .registers 3

    .line 329
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$checkLocationServiceEnabledRunnable$2;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    new-instance v1, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$checkLocationServiceEnabledRunnable$2$$ExternalSyntheticLambda0;

    invoke-direct {v1, v0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$checkLocationServiceEnabledRunnable$2$$ExternalSyntheticLambda0;-><init>(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V

    return-object v1
.end method
