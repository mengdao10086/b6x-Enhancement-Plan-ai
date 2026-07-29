.class public final Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$characteristicObservable$1;
.super Ljava/lang/Object;
.source "LeDataInteractionController.kt"

# interfaces
.implements Lcom/flydigi/sdk/bluetooth/CharacteristicObservable$CommandChange;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;-><init>(Landroid/content/Context;Lcom/flydigi/sdk/bluetooth/DeviceFilter;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u0008"
    }
    d2 = {
        "com/flydigi/sdk/bluetooth/LeDataInteractionController$characteristicObservable$1",
        "Lcom/flydigi/sdk/bluetooth/CharacteristicObservable$CommandChange;",
        "characteristicWriteSuccess",
        "",
        "observer",
        "Lcom/flydigi/sdk/bluetooth/CharacteristicObservable;",
        "command",
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


# instance fields
.field final synthetic this$0:Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;


# direct methods
.method constructor <init>(Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;)V
    .registers 2

    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$characteristicObservable$1;->this$0:Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;

    .line 188
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public characteristicWriteSuccess(Lcom/flydigi/sdk/bluetooth/CharacteristicObservable;[B)V
    .registers 5

    const-string v0, "observer"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 193
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$characteristicObservable$1;->this$0:Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;

    invoke-virtual {v0}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->getMMainHandler()Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$characteristicObservable$1;->this$0:Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;

    invoke-virtual {v1}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->getCharacteristicWriteTimeoutRunnable()Ljava/lang/Runnable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 195
    invoke-virtual {p1}, Lcom/flydigi/sdk/bluetooth/CharacteristicObservable;->clear()V

    if-eqz p2, :cond_1e

    .line 196
    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$characteristicObservable$1;->this$0:Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;

    .line 197
    invoke-virtual {p1, p2}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->onCharacteristicCallbackReceived([B)V

    .line 200
    :cond_1e
    :try_start_1e
    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$characteristicObservable$1;->this$0:Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;

    invoke-virtual {p1}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->getMutex()Lkotlinx/coroutines/sync/Mutex;

    move-result-object p1

    invoke-interface {p1}, Lkotlinx/coroutines/sync/Mutex;->isLocked()Z

    move-result p1

    if-eqz p1, :cond_3c

    .line 201
    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$characteristicObservable$1;->this$0:Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;

    invoke-virtual {p1}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->getMutex()Lkotlinx/coroutines/sync/Mutex;

    move-result-object p1

    const/4 p2, 0x1

    const/4 v0, 0x0

    invoke-static {p1, v0, p2, v0}, Lkotlinx/coroutines/sync/Mutex$DefaultImpls;->unlock$default(Lkotlinx/coroutines/sync/Mutex;Ljava/lang/Object;ILjava/lang/Object;)V
    :try_end_35
    .catch Ljava/lang/IllegalStateException; {:try_start_1e .. :try_end_35} :catch_36

    goto :goto_3c

    :catch_36
    move-exception p1

    .line 204
    check-cast p1, Ljava/lang/Throwable;

    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/util/Logger;->loge(Ljava/lang/Throwable;)V

    :cond_3c
    :goto_3c
    return-void
.end method
