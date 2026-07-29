.class final Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$createBondTimeoutRunnable$2;
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

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nAbstractBluetoothController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractBluetoothController.kt\ncom/flydigi/sdk/bluetooth/AbstractBluetoothController$createBondTimeoutRunnable$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1116:1\n1855#2,2:1117\n1#3:1119\n*S KotlinDebug\n*F\n+ 1 AbstractBluetoothController.kt\ncom/flydigi/sdk/bluetooth/AbstractBluetoothController$createBondTimeoutRunnable$2\n*L\n336#1:1117,2\n*E\n"
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
.method public static synthetic $r8$lambda$E362W4xeF0G6_PjRAjk6iYHRQmY(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V
    .registers 1

    invoke-static {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$createBondTimeoutRunnable$2;->invoke$lambda$2(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V

    return-void
.end method

.method constructor <init>(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V
    .registers 2

    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$createBondTimeoutRunnable$2;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    const/4 p1, 0x0

    invoke-direct {p0, p1}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method

.method private static final invoke$lambda$2(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V
    .registers 4

    const-string v0, "this$0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 336
    # getter for: Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bondStateCallbacks:Ljava/util/ArrayList;
    invoke-static {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->access$getBondStateCallbacks$p(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)Ljava/util/ArrayList;

    move-result-object v0

    check-cast v0, Ljava/lang/Iterable;

    .line 1117
    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_f
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_23

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/flydigi/sdk/bluetooth/BondStateCallback;

    .line 336
    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->getMBluetoothDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/flydigi/sdk/bluetooth/BondStateCallback;->onCreateBondTimeout(Landroid/bluetooth/BluetoothDevice;)V

    goto :goto_f

    .line 337
    :cond_23
    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->getMBluetoothDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v0

    if-eqz v0, :cond_2c

    # invokes: Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->cancelBondProcess(Landroid/bluetooth/BluetoothDevice;)Z
    invoke-static {p0, v0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->access$cancelBondProcess(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;Landroid/bluetooth/BluetoothDevice;)Z

    :cond_2c
    return-void
.end method


# virtual methods
.method public bridge synthetic invoke()Ljava/lang/Object;
    .registers 2

    .line 334
    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$createBondTimeoutRunnable$2;->invoke()Ljava/lang/Runnable;

    move-result-object v0

    return-object v0
.end method

.method public final invoke()Ljava/lang/Runnable;
    .registers 3

    .line 335
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$createBondTimeoutRunnable$2;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    new-instance v1, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$createBondTimeoutRunnable$2$$ExternalSyntheticLambda0;

    invoke-direct {v1, v0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$createBondTimeoutRunnable$2$$ExternalSyntheticLambda0;-><init>(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V

    return-object v1
.end method
