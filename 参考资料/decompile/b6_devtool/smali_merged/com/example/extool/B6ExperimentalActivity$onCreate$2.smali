.class final Lcom/example/extool/B6ExperimentalActivity$onCreate$2;
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
        "Ljava/lang/Boolean;",
        "Lkotlin/Unit;",
        ">;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\u0008\u0005\u0010\u0006"
    }
    d2 = {
        "<anonymous>",
        "",
        "it",
        "",
        "kotlin.jvm.PlatformType",
        "invoke",
        "(Ljava/lang/Boolean;)V"
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

    iput-object p1, p0, Lcom/example/extool/B6ExperimentalActivity$onCreate$2;->this$0:Lcom/example/extool/B6ExperimentalActivity;

    const/4 p1, 0x1

    invoke-direct {p0, p1}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 2

    .line 27
    check-cast p1, Ljava/lang/Boolean;

    invoke-virtual {p0, p1}, Lcom/example/extool/B6ExperimentalActivity$onCreate$2;->invoke(Ljava/lang/Boolean;)V

    sget-object p1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p1
.end method

.method public final invoke(Ljava/lang/Boolean;)V
    .registers 2

    .line 28
    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result p1

    if-nez p1, :cond_f

    .line 29
    iget-object p1, p0, Lcom/example/extool/B6ExperimentalActivity$onCreate$2;->this$0:Lcom/example/extool/B6ExperimentalActivity;

    # invokes: Lcom/example/extool/B6ExperimentalActivity;->getViewModel()Lcom/example/extool/WaspWingViewModel;
    invoke-static {p1}, Lcom/example/extool/B6ExperimentalActivity;->access$getViewModel(Lcom/example/extool/B6ExperimentalActivity;)Lcom/example/extool/WaspWingViewModel;

    move-result-object p1

    invoke-virtual {p1}, Lcom/example/extool/WaspWingViewModel;->tryConnect()V

    :cond_f
    return-void
.end method
