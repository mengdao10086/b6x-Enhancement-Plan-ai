.class public final Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$openProfile$2;
.super Ljava/lang/Object;
.source "AbstractBluetoothController.kt"

# interfaces
.implements Landroid/bluetooth/BluetoothProfile$ServiceListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->openProfile()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nAbstractBluetoothController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractBluetoothController.kt\ncom/flydigi/sdk/bluetooth/AbstractBluetoothController$openProfile$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1116:1\n1855#2,2:1117\n*S KotlinDebug\n*F\n+ 1 AbstractBluetoothController.kt\ncom/flydigi/sdk/bluetooth/AbstractBluetoothController$openProfile$2\n*L\n400#1:1117,2\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u0008\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\t"
    }
    d2 = {
        "com/flydigi/sdk/bluetooth/AbstractBluetoothController$openProfile$2",
        "Landroid/bluetooth/BluetoothProfile$ServiceListener;",
        "onServiceConnected",
        "",
        "profile",
        "",
        "proxy",
        "Landroid/bluetooth/BluetoothProfile;",
        "onServiceDisconnected",
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


# instance fields
.field final synthetic this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;


# direct methods
.method public static synthetic $r8$lambda$u_24UkReqk5HSPlpf5SVVc_kGW0(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V
    .registers 1

    invoke-static {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$openProfile$2;->onServiceConnected$lambda$0(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V

    return-void
.end method

.method constructor <init>(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V
    .registers 2

    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$openProfile$2;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    .line 394
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static final onServiceConnected$lambda$0(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V
    .registers 2

    const-string v0, "this$0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 397
    # invokes: Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->openProfile()V
    invoke-static {p0}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->access$openProfile(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V

    return-void
.end method


# virtual methods
.method public onServiceConnected(ILandroid/bluetooth/BluetoothProfile;)V
    .registers 6

    if-nez p2, :cond_15

    .line 397
    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$openProfile$2;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    invoke-virtual {p1}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->getMMainHandler()Landroid/os/Handler;

    move-result-object p1

    iget-object p2, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$openProfile$2;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    new-instance v0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$openProfile$2$$ExternalSyntheticLambda0;

    invoke-direct {v0, p2}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$openProfile$2$$ExternalSyntheticLambda0;-><init>(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)V

    const-wide/16 v1, 0x7d0

    invoke-virtual {p1, v0, v1, v2}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_36

    .line 399
    :cond_15
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$openProfile$2;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    invoke-static {v0, p2}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->access$setMProxy$p(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;Landroid/bluetooth/BluetoothProfile;)V

    .line 400
    iget-object p2, p0, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController$openProfile$2;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;

    # getter for: Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->bluetoothStateCallbacks:Ljava/util/ArrayList;
    invoke-static {p2}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;->access$getBluetoothStateCallbacks$p(Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;)Ljava/util/ArrayList;

    move-result-object p2

    check-cast p2, Ljava/lang/Iterable;

    .line 1117
    invoke-interface {p2}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p2

    :goto_26
    invoke-interface {p2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_36

    invoke-interface {p2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;

    .line 401
    invoke-interface {v0, p1}, Lcom/flydigi/sdk/bluetooth/BluetoothStateCallback;->onBluetoothProfileOpened(I)V

    goto :goto_26

    :cond_36
    :goto_36
    return-void
.end method

.method public onServiceDisconnected(I)V
    .registers 2

    return-void
.end method
