.class final Lcom/example/extool/B6ExperimentalActivity$onCreate$1;
.super Lkotlin/jvm/internal/Lambda;
.source "B6ExperimentalActivity.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function1;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/example/extool/B6ExperimentalActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/Lambda;",
        "Lkotlin/jvm/functions/Function1<",
        "Lcom/flydigi/sdk/waspwing/WaspWingInfo;",
        "Lkotlin/Unit;",
        ">;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\u0008\u0005"
    }
    d2 = {
        "<anonymous>",
        "",
        "it",
        "Lcom/flydigi/sdk/waspwing/WaspWingInfo;",
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
.field final synthetic this$0:Lcom/example/extool/B6ExperimentalActivity;


# direct methods
.method constructor <init>(Lcom/example/extool/B6ExperimentalActivity;)V
    .registers 2

    iput-object p1, p0, Lcom/example/extool/B6ExperimentalActivity$onCreate$1;->this$0:Lcom/example/extool/B6ExperimentalActivity;

    const/4 p1, 0x1

    invoke-direct {p0, p1}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 2

    .line 24
    check-cast p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    invoke-virtual {p0, p1}, Lcom/example/extool/B6ExperimentalActivity$onCreate$1;->invoke(Lcom/flydigi/sdk/waspwing/WaspWingInfo;)V

    sget-object p1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p1
.end method

.method public final invoke(Lcom/flydigi/sdk/waspwing/WaspWingInfo;)V
    .registers 3

    .line 25
    iget-object v0, p0, Lcom/example/extool/B6ExperimentalActivity$onCreate$1;->this$0:Lcom/example/extool/B6ExperimentalActivity;

    # getter for: Lcom/example/extool/B6ExperimentalActivity;->binding:Lcom/example/extool/databinding/ActivityExperimentalB6Binding;
    invoke-static {v0}, Lcom/example/extool/B6ExperimentalActivity;->access$getBinding$p(Lcom/example/extool/B6ExperimentalActivity;)Lcom/example/extool/databinding/ActivityExperimentalB6Binding;

    move-result-object v0

    if-nez v0, :cond_e

    const-string v0, "binding"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 v0, 0x0

    :cond_e
    invoke-virtual {v0, p1}, Lcom/example/extool/databinding/ActivityExperimentalB6Binding;->setData(Lcom/flydigi/sdk/waspwing/WaspWingInfo;)V

    return-void
.end method
