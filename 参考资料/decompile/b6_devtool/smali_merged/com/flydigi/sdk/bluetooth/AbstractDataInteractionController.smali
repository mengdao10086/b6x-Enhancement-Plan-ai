.class public abstract Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;
.super Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;
.source "AbstractDataInteractionController.kt"


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nAbstractDataInteractionController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractDataInteractionController.kt\ncom/flydigi/sdk/bluetooth/AbstractDataInteractionController\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,134:1\n1855#2,2:135\n*S KotlinDebug\n*F\n+ 1 AbstractDataInteractionController.kt\ncom/flydigi/sdk/bluetooth/AbstractDataInteractionController\n*L\n114#1:135,2\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008&\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u0008J7\u0010\u001b\u001a\u00020\u001c2\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\n\u0008\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\u0008\u0002\u0010\"\u001a\u0004\u0018\u00010#\u00a2\u0006\u0002\u0010$J=\u0010\u001b\u001a\u00020\u001c2\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00182\u000c\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\u001f0%2\n\u0008\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\u0008\u0002\u0010\"\u001a\u0004\u0018\u00010#\u00a2\u0006\u0002\u0010&J\u001f\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\n\u0008\u0002\u0010 \u001a\u0004\u0018\u00010!\u00a2\u0006\u0002\u0010\'J1\u0010\u001b\u001a\u00020\u001c2\u000c\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\u001f0%2\n\u0008\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\u0008\u0002\u0010\"\u001a\u0004\u0018\u00010#\u00a2\u0006\u0002\u0010(J\u0008\u0010)\u001a\u00020\u001cH$J\u000e\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,J\u0008\u0010-\u001a\u00020!H\u0002J\u0018\u0010.\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u001fH$J\u0010\u00100\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,H\u0014J\u0010\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u000bH\u0002J\u0011\u00103\u001a\u00020\u001cH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00104J\u0010\u00105\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u000bH%R\u0014\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u000c\u001a\u00020\u0007X\u0084\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0014X\u0084\u0004\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0018X\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001a\u0082\u0002\u0004\n\u0002\u0008\u0019\u00a8\u00066"
    }
    d2 = {
        "Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;",
        "Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;",
        "mContext",
        "Landroid/content/Context;",
        "filter",
        "Lcom/flydigi/sdk/bluetooth/DeviceFilter;",
        "mProfile",
        "",
        "(Landroid/content/Context;Lcom/flydigi/sdk/bluetooth/DeviceFilter;I)V",
        "mConcurrentLinkedQueue",
        "Ljava/util/concurrent/ConcurrentLinkedQueue;",
        "Lcom/flydigi/sdk/bluetooth/data/RequestPack;",
        "mDataConnectState",
        "getMDataConnectState$annotations",
        "()V",
        "getMDataConnectState",
        "()I",
        "setMDataConnectState",
        "(I)V",
        "mutex",
        "Lkotlinx/coroutines/sync/Mutex;",
        "getMutex",
        "()Lkotlinx/coroutines/sync/Mutex;",
        "serviceUUID",
        "Ljava/util/UUID;",
        "getServiceUUID",
        "()Ljava/util/UUID;",
        "addCommandToQueue",
        "",
        "uuid",
        "command",
        "",
        "requireCallback",
        "",
        "delay",
        "",
        "(Ljava/util/UUID;[BLjava/lang/Boolean;Ljava/lang/Long;)V",
        "",
        "(Ljava/util/UUID;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Long;)V",
        "([BLjava/lang/Boolean;)V",
        "(Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Long;)V",
        "connect",
        "connectWith",
        "device",
        "Landroid/bluetooth/BluetoothDevice;",
        "isConnected",
        "onReceiveDataFromDevice",
        "value",
        "preConnectWith",
        "processData",
        "pack",
        "runFetchLoop",
        "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;",
        "writeToBluetoothDevice",
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
.field private volatile mConcurrentLinkedQueue:Ljava/util/concurrent/ConcurrentLinkedQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentLinkedQueue<",
            "Lcom/flydigi/sdk/bluetooth/data/RequestPack;",
            ">;"
        }
    .end annotation
.end field

.field private mDataConnectState:I

.field private final mutex:Lkotlinx/coroutines/sync/Mutex;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/flydigi/sdk/bluetooth/DeviceFilter;I)V
    .registers 10

    const-string v0, "mContext"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "filter"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 29
    invoke-direct {p0, p1, p2, p3}, Lcom/flydigi/sdk/bluetooth/AbstractBluetoothController;-><init>(Landroid/content/Context;Lcom/flydigi/sdk/bluetooth/DeviceFilter;I)V

    const/4 p1, 0x0

    .line 34
    invoke-static {p1}, Lkotlinx/coroutines/sync/MutexKt;->Mutex(Z)Lkotlinx/coroutines/sync/Mutex;

    move-result-object p1

    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;->mutex:Lkotlinx/coroutines/sync/Mutex;

    .line 40
    new-instance p1, Ljava/util/concurrent/ConcurrentLinkedQueue;

    invoke-direct {p1}, Ljava/util/concurrent/ConcurrentLinkedQueue;-><init>()V

    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;->mConcurrentLinkedQueue:Ljava/util/concurrent/ConcurrentLinkedQueue;

    .line 43
    sget-object p1, Lkotlinx/coroutines/GlobalScope;->INSTANCE:Lkotlinx/coroutines/GlobalScope;

    move-object v0, p1

    check-cast v0, Lkotlinx/coroutines/CoroutineScope;

    const/4 v1, 0x0

    const/4 v2, 0x0

    new-instance p1, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController$1;

    const/4 p2, 0x0

    invoke-direct {p1, p0, p2}, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController$1;-><init>(Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;Lkotlin/coroutines/Continuation;)V

    move-object v3, p1

    check-cast v3, Lkotlin/jvm/functions/Function2;

    const/4 v4, 0x3

    const/4 v5, 0x0

    invoke-static/range {v0 .. v5}, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;ILjava/lang/Object;)Lkotlinx/coroutines/Job;

    return-void
.end method

.method public static final synthetic access$runFetchLoop(Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .registers 2

    .line 27
    invoke-direct {p0, p1}, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;->runFetchLoop(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic addCommandToQueue$default(Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Long;ILjava/lang/Object;)V
    .registers 6

    if-nez p5, :cond_19

    and-int/lit8 p5, p4, 0x2

    if-eqz p5, :cond_b

    const/4 p2, 0x0

    .line 88
    invoke-static {p2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p2

    :cond_b
    and-int/lit8 p4, p4, 0x4

    if-eqz p4, :cond_15

    const-wide/16 p3, 0x0

    invoke-static {p3, p4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p3

    .line 87
    :cond_15
    invoke-virtual {p0, p1, p2, p3}, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;->addCommandToQueue(Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Long;)V

    return-void

    :cond_19
    new-instance p0, Ljava/lang/UnsupportedOperationException;

    const-string p1, "Super calls with default arguments not supported in this target, function: addCommandToQueue"

    invoke-direct {p0, p1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static synthetic addCommandToQueue$default(Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;Ljava/util/UUID;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Long;ILjava/lang/Object;)V
    .registers 7

    if-nez p6, :cond_1e

    and-int/lit8 p6, p5, 0x1

    if-eqz p6, :cond_7

    const/4 p1, 0x0

    :cond_7
    and-int/lit8 p6, p5, 0x4

    if-eqz p6, :cond_10

    const/4 p3, 0x0

    .line 102
    invoke-static {p3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p3

    :cond_10
    and-int/lit8 p5, p5, 0x8

    if-eqz p5, :cond_1a

    const-wide/16 p4, 0x0

    .line 103
    invoke-static {p4, p5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p4

    .line 99
    :cond_1a
    invoke-virtual {p0, p1, p2, p3, p4}, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;->addCommandToQueue(Ljava/util/UUID;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Long;)V

    return-void

    :cond_1e
    new-instance p0, Ljava/lang/UnsupportedOperationException;

    const-string p1, "Super calls with default arguments not supported in this target, function: addCommandToQueue"

    invoke-direct {p0, p1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static synthetic addCommandToQueue$default(Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;Ljava/util/UUID;[BLjava/lang/Boolean;Ljava/lang/Long;ILjava/lang/Object;)V
    .registers 7

    if-nez p6, :cond_1e

    and-int/lit8 p6, p5, 0x1

    if-eqz p6, :cond_7

    const/4 p1, 0x0

    :cond_7
    and-int/lit8 p6, p5, 0x4

    if-eqz p6, :cond_10

    const/4 p3, 0x0

    .line 94
    invoke-static {p3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p3

    :cond_10
    and-int/lit8 p5, p5, 0x8

    if-eqz p5, :cond_1a

    const-wide/16 p4, 0x0

    invoke-static {p4, p5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p4

    .line 93
    :cond_1a
    invoke-virtual {p0, p1, p2, p3, p4}, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;->addCommandToQueue(Ljava/util/UUID;[BLjava/lang/Boolean;Ljava/lang/Long;)V

    return-void

    :cond_1e
    new-instance p0, Ljava/lang/UnsupportedOperationException;

    const-string p1, "Super calls with default arguments not supported in this target, function: addCommandToQueue"

    invoke-direct {p0, p1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static synthetic addCommandToQueue$default(Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;[BLjava/lang/Boolean;ILjava/lang/Object;)V
    .registers 5

    if-nez p4, :cond_f

    and-int/lit8 p3, p3, 0x2

    if-eqz p3, :cond_b

    const/4 p2, 0x0

    .line 82
    invoke-static {p2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p2

    .line 81
    :cond_b
    invoke-virtual {p0, p1, p2}, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;->addCommandToQueue([BLjava/lang/Boolean;)V

    return-void

    :cond_f
    new-instance p0, Ljava/lang/UnsupportedOperationException;

    const-string p1, "Super calls with default arguments not supported in this target, function: addCommandToQueue"

    invoke-direct {p0, p1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method protected static synthetic getMDataConnectState$annotations()V
    .registers 0

    return-void
.end method

.method private final isConnected()Z
    .registers 4

    .line 122
    iget v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;->mDataConnectState:I

    const/4 v1, 0x2

    const/4 v2, 0x1

    if-eq v0, v1, :cond_a

    if-ne v0, v2, :cond_9

    goto :goto_a

    :cond_9
    const/4 v2, 0x0

    :cond_a
    :goto_a
    return v2
.end method

.method private final processData(Lcom/flydigi/sdk/bluetooth/data/RequestPack;)V
    .registers 4

    .line 60
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;->mConcurrentLinkedQueue:Ljava/util/concurrent/ConcurrentLinkedQueue;

    invoke-virtual {v0}, Ljava/util/concurrent/ConcurrentLinkedQueue;->poll()Ljava/lang/Object;

    .line 61
    iget v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;->mDataConnectState:I

    const/4 v1, 0x2

    if-eq v0, v1, :cond_10

    const-string p1, "Gatt hasn\'t connected"

    .line 62
    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logw(Ljava/lang/String;)V

    return-void

    .line 66
    :cond_10
    invoke-virtual {p0, p1}, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;->writeToBluetoothDevice(Lcom/flydigi/sdk/bluetooth/data/RequestPack;)V

    return-void
.end method

.method private final runFetchLoop(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Lkotlin/Unit;",
            ">;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    instance-of v0, p1, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController$runFetchLoop$1;

    if-eqz v0, :cond_14

    move-object v0, p1

    check-cast v0, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController$runFetchLoop$1;

    iget v1, v0, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController$runFetchLoop$1;->label:I

    const/high16 v2, -0x80000000

    and-int/2addr v1, v2

    if-eqz v1, :cond_14

    iget p1, v0, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController$runFetchLoop$1;->label:I

    sub-int/2addr p1, v2

    iput p1, v0, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController$runFetchLoop$1;->label:I

    goto :goto_19

    :cond_14
    new-instance v0, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController$runFetchLoop$1;

    invoke-direct {v0, p0, p1}, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController$runFetchLoop$1;-><init>(Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;Lkotlin/coroutines/Continuation;)V

    :goto_19
    iget-object p1, v0, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController$runFetchLoop$1;->result:Ljava/lang/Object;

    invoke-static {}, Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;

    move-result-object v1

    .line 48
    iget v2, v0, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController$runFetchLoop$1;->label:I

    const/4 v3, 0x1

    if-eqz v2, :cond_3a

    if-ne v2, v3, :cond_32

    iget-object v2, v0, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController$runFetchLoop$1;->L$1:Ljava/lang/Object;

    check-cast v2, Lcom/flydigi/sdk/bluetooth/data/RequestPack;

    iget-object v4, v0, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController$runFetchLoop$1;->L$0:Ljava/lang/Object;

    check-cast v4, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;

    invoke-static {p1}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    goto :goto_59

    :cond_32
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string v0, "call to \'resume\' before \'invoke\' with coroutine"

    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_3a
    invoke-static {p1}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    move-object v4, p0

    .line 50
    :cond_3e
    :goto_3e
    iget-object p1, v4, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;->mConcurrentLinkedQueue:Ljava/util/concurrent/ConcurrentLinkedQueue;

    invoke-virtual {p1}, Ljava/util/concurrent/ConcurrentLinkedQueue;->peek()Ljava/lang/Object;

    move-result-object p1

    move-object v2, p1

    check-cast v2, Lcom/flydigi/sdk/bluetooth/data/RequestPack;

    if-eqz v2, :cond_3e

    .line 52
    iget-object p1, v4, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;->mutex:Lkotlinx/coroutines/sync/Mutex;

    iput-object v4, v0, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController$runFetchLoop$1;->L$0:Ljava/lang/Object;

    iput-object v2, v0, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController$runFetchLoop$1;->L$1:Ljava/lang/Object;

    iput v3, v0, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController$runFetchLoop$1;->label:I

    const/4 v5, 0x0

    invoke-static {p1, v5, v0, v3, v5}, Lkotlinx/coroutines/sync/Mutex$DefaultImpls;->lock$default(Lkotlinx/coroutines/sync/Mutex;Ljava/lang/Object;Lkotlin/coroutines/Continuation;ILjava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    if-ne p1, v1, :cond_59

    return-object v1

    .line 53
    :cond_59
    :goto_59
    invoke-direct {v4, v2}, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;->processData(Lcom/flydigi/sdk/bluetooth/data/RequestPack;)V

    goto :goto_3e
.end method


# virtual methods
.method public final addCommandToQueue(Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Long;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "[B>;",
            "Ljava/lang/Boolean;",
            "Ljava/lang/Long;",
            ")V"
        }
    .end annotation

    const-string v0, "command"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x0

    .line 90
    invoke-virtual {p0, v0, p1, p2, p3}, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;->addCommandToQueue(Ljava/util/UUID;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Long;)V

    return-void
.end method

.method public final addCommandToQueue(Ljava/util/UUID;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Long;)V
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/UUID;",
            "Ljava/util/List<",
            "[B>;",
            "Ljava/lang/Boolean;",
            "Ljava/lang/Long;",
            ")V"
        }
    .end annotation

    const-string v0, "command"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 105
    iget v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;->mDataConnectState:I

    if-nez v0, :cond_f

    const-string p1, "Gatt hasn\'t connected"

    .line 106
    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logw(Ljava/lang/String;)V

    return-void

    .line 109
    :cond_f
    invoke-interface {p2}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_16

    return-void

    .line 113
    :cond_16
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;->mConcurrentLinkedQueue:Ljava/util/concurrent/ConcurrentLinkedQueue;

    monitor-enter v0

    .line 114
    :try_start_19
    check-cast p2, Ljava/lang/Iterable;

    .line 135
    invoke-interface {p2}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p2

    :goto_1f
    invoke-interface {p2}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_36

    invoke-interface {p2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [B

    .line 115
    new-instance v2, Lcom/flydigi/sdk/bluetooth/data/RequestPack;

    invoke-direct {v2, p1, v1, p3, p4}, Lcom/flydigi/sdk/bluetooth/data/RequestPack;-><init>(Ljava/util/UUID;[BLjava/lang/Boolean;Ljava/lang/Long;)V

    .line 116
    iget-object v1, p0, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;->mConcurrentLinkedQueue:Ljava/util/concurrent/ConcurrentLinkedQueue;

    invoke-virtual {v1, v2}, Ljava/util/concurrent/ConcurrentLinkedQueue;->add(Ljava/lang/Object;)Z

    goto :goto_1f

    .line 118
    :cond_36
    sget-object p1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;
    :try_end_38
    .catchall {:try_start_19 .. :try_end_38} :catchall_3a

    .line 113
    monitor-exit v0

    return-void

    :catchall_3a
    move-exception p1

    monitor-exit v0

    throw p1
.end method

.method public final addCommandToQueue(Ljava/util/UUID;[BLjava/lang/Boolean;Ljava/lang/Long;)V
    .registers 6

    const-string v0, "command"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 96
    invoke-static {p2}, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;

    move-result-object p2

    invoke-virtual {p0, p1, p2, p3, p4}, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;->addCommandToQueue(Ljava/util/UUID;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Long;)V

    return-void
.end method

.method public final addCommandToQueue([BLjava/lang/Boolean;)V
    .registers 10

    const-string v0, "command"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 84
    invoke-static {p1}, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v2

    const/4 v4, 0x0

    const/4 v5, 0x4

    const/4 v6, 0x0

    move-object v1, p0

    move-object v3, p2

    invoke-static/range {v1 .. v6}, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;->addCommandToQueue$default(Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Long;ILjava/lang/Object;)V

    return-void
.end method

.method protected abstract connect()V
.end method

.method public final connectWith(Landroid/bluetooth/BluetoothDevice;)V
    .registers 3

    const-string v0, "device"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 71
    invoke-direct {p0}, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_11

    const-string p1, "gatt has been connected with other device"

    .line 72
    invoke-static {p1}, Lcom/flydigi/sdk/bluetooth/util/Logger;->logw(Ljava/lang/String;)V

    return-void

    .line 75
    :cond_11
    invoke-virtual {p0, p1}, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;->setMBluetoothDevice(Landroid/bluetooth/BluetoothDevice;)V

    .line 76
    invoke-virtual {p0, p1}, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;->preConnectWith(Landroid/bluetooth/BluetoothDevice;)V

    .line 77
    invoke-virtual {p0}, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;->connect()V

    return-void
.end method

.method protected final getMDataConnectState()I
    .registers 2

    .line 32
    iget v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;->mDataConnectState:I

    return v0
.end method

.method protected final getMutex()Lkotlinx/coroutines/sync/Mutex;
    .registers 2

    .line 34
    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;->mutex:Lkotlinx/coroutines/sync/Mutex;

    return-object v0
.end method

.method protected abstract getServiceUUID()Ljava/util/UUID;
.end method

.method protected abstract onReceiveDataFromDevice(Ljava/util/UUID;[B)V
.end method

.method protected preConnectWith(Landroid/bluetooth/BluetoothDevice;)V
    .registers 3

    const-string v0, "device"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    return-void
.end method

.method protected final setMDataConnectState(I)V
    .registers 2

    .line 32
    iput p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;->mDataConnectState:I

    return-void
.end method

.method protected abstract writeToBluetoothDevice(Lcom/flydigi/sdk/bluetooth/data/RequestPack;)V
.end method
