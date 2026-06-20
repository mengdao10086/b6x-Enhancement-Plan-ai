.class final Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$openBluetooth$disposable$1;
.super Lkotlin/jvm/internal/Lambda;
.source "AbstractBluetoothController.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function1;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->openBluetooth(Landroidx/fragment/app/FragmentActivity;Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;)V
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
        "Landroidx/fragment/app/FragmentActivity;",
        ">;",
        "Lkotlin/Unit;",
        ">;"
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nAbstractBluetoothController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractBluetoothController.kt\ncom/flydigi/sdk/bluetooth/AbstractBluetoothController$openBluetooth$disposable$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1116:1\n1855#2,2:1117\n*S KotlinDebug\n*F\n+ 1 AbstractBluetoothController.kt\ncom/flydigi/sdk/bluetooth/AbstractBluetoothController$openBluetooth$disposable$1\n*L\n427#1:1117,2\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\u000c\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\u000c\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\u0008\u0006"
    }
    d2 = {
        "<anonymous>",
        "",
        "result",
        "Lrx_activity_result2/Result;",
        "Landroidx/fragment/app/FragmentActivity;",
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
.field final synthetic $callback:Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;

.field final synthetic this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;


# direct methods
.method constructor <init>(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;)V
    .registers 3

    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$openBluetooth$disposable$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    iput-object p2, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$openBluetooth$disposable$1;->$callback:Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;

    const/4 p1, 0x1

    invoke-direct {p0, p1}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 2

    .line 421
    check-cast p1, Lrx_activity_result2/Result;

    invoke-virtual {p0, p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$openBluetooth$disposable$1;->invoke(Lrx_activity_result2/Result;)V

    sget-object p1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p1
.end method

.method public final invoke(Lrx_activity_result2/Result;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx_activity_result2/Result<",
            "Landroidx/fragment/app/FragmentActivity;",
            ">;)V"
        }
    .end annotation

    .line 423
    invoke-virtual {p1}, Lrx_activity_result2/Result;->resultCode()I

    move-result p1

    const/4 v0, -0x1

    if-ne p1, v0, :cond_15

    .line 424
    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$openBluetooth$disposable$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    # invokes: Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->onBluetoothEnabled()V
    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->access$onBluetoothEnabled(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V

    .line 425
    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$openBluetooth$disposable$1;->$callback:Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;

    if-eqz p1, :cond_31

    const/4 v0, 0x1

    invoke-interface {p1, v0}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;->onBluetoothState(Z)V

    goto :goto_31

    .line 427
    :cond_15
    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$openBluetooth$disposable$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    # getter for: Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bluetoothStateCallbacks:Ljava/util/ArrayList;
    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->access$getBluetoothStateCallbacks$p(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)Ljava/util/ArrayList;

    move-result-object p1

    check-cast p1, Ljava/lang/Iterable;

    .line 1117
    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_21
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_31

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;

    .line 427
    invoke-interface {v0}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;->onBluetoothOpenDeny()V

    goto :goto_21

    :cond_31
    :goto_31
    return-void
.end method
