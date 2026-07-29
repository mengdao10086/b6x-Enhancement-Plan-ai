.class final Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$openBluetooth$disposable$2;
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
        "Ljava/lang/Throwable;",
        "Lkotlin/Unit;",
        ">;"
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nAbstractBluetoothController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractBluetoothController.kt\ncom/flydigi/sdk/bluetooth/AbstractBluetoothController$openBluetooth$disposable$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1116:1\n1855#2,2:1117\n*S KotlinDebug\n*F\n+ 1 AbstractBluetoothController.kt\ncom/flydigi/sdk/bluetooth/AbstractBluetoothController$openBluetooth$disposable$2\n*L\n430#1:1117,2\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\u0008\u0005"
    }
    d2 = {
        "<anonymous>",
        "",
        "it",
        "",
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

    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$openBluetooth$disposable$2;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    const/4 p1, 0x1

    invoke-direct {p0, p1}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 2

    .line 421
    check-cast p1, Ljava/lang/Throwable;

    invoke-virtual {p0, p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$openBluetooth$disposable$2;->invoke(Ljava/lang/Throwable;)V

    sget-object p1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p1
.end method

.method public final invoke(Ljava/lang/Throwable;)V
    .registers 3

    .line 430
    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$openBluetooth$disposable$2;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    # getter for: Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bluetoothStateCallbacks:Ljava/util/ArrayList;
    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->access$getBluetoothStateCallbacks$p(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)Ljava/util/ArrayList;

    move-result-object p1

    check-cast p1, Ljava/lang/Iterable;

    .line 1117
    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_c
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1c

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;

    .line 430
    invoke-interface {v0}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;->onBluetoothOpenFailed()V

    goto :goto_c

    :cond_1c
    return-void
.end method
