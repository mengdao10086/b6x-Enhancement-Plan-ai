.class public final Lcom/flydigi/sdk/bluetooth/CharacteristicObservable;
.super Ljava/lang/Object;
.source "CharacteristicObservable.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/flydigi/sdk/bluetooth/CharacteristicObservable$CommandChange;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001:\u0001\u0016B\u000f\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000cR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0004R\u0011\u0010\u0008\u001a\u00020\t\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u000cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010\u00a8\u0006\u0017"
    }
    d2 = {
        "Lcom/flydigi/sdk/bluetooth/CharacteristicObservable;",
        "",
        "commandChange",
        "Lcom/flydigi/sdk/bluetooth/CharacteristicObservable$CommandChange;",
        "(Lcom/flydigi/sdk/bluetooth/CharacteristicObservable$CommandChange;)V",
        "getCommandChange",
        "()Lcom/flydigi/sdk/bluetooth/CharacteristicObservable$CommandChange;",
        "setCommandChange",
        "isClear",
        "",
        "()Z",
        "packet",
        "Lcom/flydigi/sdk/bluetooth/data/RequestPack;",
        "getPacket",
        "()Lcom/flydigi/sdk/bluetooth/data/RequestPack;",
        "setPacket",
        "(Lcom/flydigi/sdk/bluetooth/data/RequestPack;)V",
        "clear",
        "",
        "finish",
        "update",
        "command",
        "CommandChange",
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
.field private commandChange:Lcom/flydigi/sdk/bluetooth/CharacteristicObservable$CommandChange;

.field private final isClear:Z

.field private packet:Lcom/flydigi/sdk/bluetooth/data/RequestPack;


# direct methods
.method public constructor <init>(Lcom/flydigi/sdk/bluetooth/CharacteristicObservable$CommandChange;)V
    .registers 2

    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/CharacteristicObservable;->commandChange:Lcom/flydigi/sdk/bluetooth/CharacteristicObservable$CommandChange;

    .line 21
    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/CharacteristicObservable;->packet:Lcom/flydigi/sdk/bluetooth/data/RequestPack;

    if-eqz p1, :cond_b

    const/4 p1, 0x1

    goto :goto_c

    :cond_b
    const/4 p1, 0x0

    :goto_c
    iput-boolean p1, p0, Lcom/flydigi/sdk/bluetooth/CharacteristicObservable;->isClear:Z

    return-void
.end method


# virtual methods
.method public final clear()V
    .registers 2

    const/4 v0, 0x0

    .line 18
    iput-object v0, p0, Lcom/flydigi/sdk/bluetooth/CharacteristicObservable;->packet:Lcom/flydigi/sdk/bluetooth/data/RequestPack;

    return-void
.end method

.method public final finish()V
    .registers 3

    .line 24
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/CharacteristicObservable;->commandChange:Lcom/flydigi/sdk/bluetooth/CharacteristicObservable$CommandChange;

    if-eqz v0, :cond_11

    iget-object v1, p0, Lcom/flydigi/sdk/bluetooth/CharacteristicObservable;->packet:Lcom/flydigi/sdk/bluetooth/data/RequestPack;

    if-eqz v1, :cond_d

    invoke-virtual {v1}, Lcom/flydigi/sdk/bluetooth/data/RequestPack;->getData()[B

    move-result-object v1

    goto :goto_e

    :cond_d
    const/4 v1, 0x0

    :goto_e
    invoke-interface {v0, p0, v1}, Lcom/flydigi/sdk/bluetooth/CharacteristicObservable$CommandChange;->characteristicWriteSuccess(Lcom/flydigi/sdk/bluetooth/CharacteristicObservable;[B)V

    :cond_11
    return-void
.end method

.method public final getCommandChange()Lcom/flydigi/sdk/bluetooth/CharacteristicObservable$CommandChange;
    .registers 2

    .line 9
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/CharacteristicObservable;->commandChange:Lcom/flydigi/sdk/bluetooth/CharacteristicObservable$CommandChange;

    return-object v0
.end method

.method public final getPacket()Lcom/flydigi/sdk/bluetooth/data/RequestPack;
    .registers 2

    .line 11
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/CharacteristicObservable;->packet:Lcom/flydigi/sdk/bluetooth/data/RequestPack;

    return-object v0
.end method

.method public final isClear()Z
    .registers 2

    .line 21
    iget-boolean v0, p0, Lcom/flydigi/sdk/bluetooth/CharacteristicObservable;->isClear:Z

    return v0
.end method

.method public final setCommandChange(Lcom/flydigi/sdk/bluetooth/CharacteristicObservable$CommandChange;)V
    .registers 2

    .line 9
    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/CharacteristicObservable;->commandChange:Lcom/flydigi/sdk/bluetooth/CharacteristicObservable$CommandChange;

    return-void
.end method

.method public final setPacket(Lcom/flydigi/sdk/bluetooth/data/RequestPack;)V
    .registers 2

    .line 11
    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/CharacteristicObservable;->packet:Lcom/flydigi/sdk/bluetooth/data/RequestPack;

    return-void
.end method

.method public final update(Lcom/flydigi/sdk/bluetooth/data/RequestPack;)V
    .registers 3

    const-string v0, "command"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 14
    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/CharacteristicObservable;->packet:Lcom/flydigi/sdk/bluetooth/data/RequestPack;

    return-void
.end method
