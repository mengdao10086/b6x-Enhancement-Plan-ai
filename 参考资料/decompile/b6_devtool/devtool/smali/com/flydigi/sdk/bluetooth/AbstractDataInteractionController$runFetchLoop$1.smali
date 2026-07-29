.class final Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController$runFetchLoop$1;
.super Lkotlin/coroutines/jvm/internal/ContinuationImpl;
.source "AbstractDataInteractionController.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;->runFetchLoop(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation runtime Lkotlin/Metadata;
    k = 0x3
    mv = {
        0x1,
        0x8,
        0x0
    }
    xi = 0x30
.end annotation

.annotation runtime Lkotlin/coroutines/jvm/internal/DebugMetadata;
    c = "com.flydigi.sdk.bluetooth.AbstractDataInteractionController"
    f = "AbstractDataInteractionController.kt"
    i = {
        0x0,
        0x0
    }
    l = {
        0x34
    }
    m = "runFetchLoop"
    n = {
        "this",
        "it"
    }
    s = {
        "L$0",
        "L$1"
    }
.end annotation


# instance fields
.field L$0:Ljava/lang/Object;

.field L$1:Ljava/lang/Object;

.field label:I

.field synthetic result:Ljava/lang/Object;

.field final synthetic this$0:Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;


# direct methods
.method constructor <init>(Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;Lkotlin/coroutines/Continuation;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController$runFetchLoop$1;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController$runFetchLoop$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;

    invoke-direct {p0, p2}, Lkotlin/coroutines/jvm/internal/ContinuationImpl;-><init>(Lkotlin/coroutines/Continuation;)V

    return-void
.end method


# virtual methods
.method public final invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 3

    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController$runFetchLoop$1;->result:Ljava/lang/Object;

    iget p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController$runFetchLoop$1;->label:I

    const/high16 v0, -0x80000000

    or-int/2addr p1, v0

    iput p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController$runFetchLoop$1;->label:I

    iget-object p1, p0, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController$runFetchLoop$1;->this$0:Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;

    move-object v0, p0

    check-cast v0, Lkotlin/coroutines/Continuation;

    # invokes: Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;->runFetchLoop(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    invoke-static {p1, v0}, Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;->access$runFetchLoop(Lcom/flydigi/sdk/bluetooth/AbstractDataInteractionController;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method
