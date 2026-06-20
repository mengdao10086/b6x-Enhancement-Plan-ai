.class final Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$requestEnableLocationService$1;
.super Lkotlin/jvm/internal/Lambda;
.source "AbstractBluetoothController.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function1;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->requestEnableLocationService(Landroid/app/Activity;)Lio/reactivex/disposables/Disposable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/Lambda;",
        "Lkotlin/jvm/functions/Function1<",
        "Lrx_activity_result2/Result<",
        "Landroid/app/Activity;",
        ">;",
        "Lkotlin/Unit;",
        ">;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\u000c\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\u000c\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\u0008\u0006"
    }
    d2 = {
        "<anonymous>",
        "",
        "it",
        "Lrx_activity_result2/Result;",
        "Landroid/app/Activity;",
        "kotlin.jvm.PlatformType",
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
.method constructor <init>(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V
    .registers 2

    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$requestEnableLocationService$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    const/4 p1, 0x1

    invoke-direct {p0, p1}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 2

    .line 475
    check-cast p1, Lrx_activity_result2/Result;

    invoke-virtual {p0, p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$requestEnableLocationService$1;->invoke(Lrx_activity_result2/Result;)V

    sget-object p1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p1
.end method

.method public final invoke(Lrx_activity_result2/Result;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx_activity_result2/Result<",
            "Landroid/app/Activity;",
            ">;)V"
        }
    .end annotation

    .line 476
    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$requestEnableLocationService$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    # invokes: Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->checkLocationServiceEnabled(Ljava/lang/Boolean;)V
    invoke-static {p1, v0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->access$checkLocationServiceEnabled(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;Ljava/lang/Boolean;)V

    return-void
.end method
