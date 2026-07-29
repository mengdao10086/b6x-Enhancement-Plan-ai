.class final Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestNotificationPermissionResult$1;
.super Lkotlin/jvm/internal/Lambda;
.source "InvisibleFragment.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function0;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/permissionx/guolindev/request/InvisibleFragment;->onRequestNotificationPermissionResult()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/Lambda;",
        "Lkotlin/jvm/functions/Function0<",
        "Lkotlin/Unit;",
        ">;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\u0008\u0002"
    }
    d2 = {
        "<anonymous>",
        "",
        "invoke"
    }
    k = 0x3
    mv = {
        0x1,
        0x7,
        0x1
    }
    xi = 0x30
.end annotation


# instance fields
.field final synthetic this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;


# direct methods
.method constructor <init>(Lcom/permissionx/guolindev/request/InvisibleFragment;)V
    .registers 2

    iput-object p1, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestNotificationPermissionResult$1;->this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;

    const/4 p1, 0x0

    invoke-direct {p0, p1}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke()Ljava/lang/Object;
    .registers 2

    .line 583
    invoke-virtual {p0}, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestNotificationPermissionResult$1;->invoke()V

    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object v0
.end method

.method public final invoke()V
    .registers 6

    .line 585
    iget-object v0, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestNotificationPermissionResult$1;->this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;

    invoke-virtual {v0}, Lcom/permissionx/guolindev/request/InvisibleFragment;->requireContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/permissionx/guolindev/PermissionX;->areNotificationsEnabled(Landroid/content/Context;)Z

    move-result v0

    const-string v1, "task"

    const/4 v2, 0x0

    if-eqz v0, :cond_21

    .line 586
    iget-object v0, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestNotificationPermissionResult$1;->this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;

    # getter for: Lcom/permissionx/guolindev/request/InvisibleFragment;->task:Lcom/permissionx/guolindev/request/ChainTask;
    invoke-static {v0}, Lcom/permissionx/guolindev/request/InvisibleFragment;->access$getTask$p(Lcom/permissionx/guolindev/request/InvisibleFragment;)Lcom/permissionx/guolindev/request/ChainTask;

    move-result-object v0

    if-nez v0, :cond_1b

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_1c

    :cond_1b
    move-object v2, v0

    :goto_1c
    invoke-interface {v2}, Lcom/permissionx/guolindev/request/ChainTask;->finish()V

    goto/16 :goto_a9

    .line 587
    :cond_21
    iget-object v0, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestNotificationPermissionResult$1;->this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;

    # getter for: Lcom/permissionx/guolindev/request/InvisibleFragment;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;
    invoke-static {v0}, Lcom/permissionx/guolindev/request/InvisibleFragment;->access$getPb$p(Lcom/permissionx/guolindev/request/InvisibleFragment;)Lcom/permissionx/guolindev/request/PermissionBuilder;

    move-result-object v0

    const-string v3, "pb"

    if-nez v0, :cond_2f

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v2

    :cond_2f
    iget-object v0, v0, Lcom/permissionx/guolindev/request/PermissionBuilder;->explainReasonCallback:Lcom/permissionx/guolindev/callback/ExplainReasonCallback;

    if-nez v0, :cond_43

    iget-object v0, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestNotificationPermissionResult$1;->this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;

    # getter for: Lcom/permissionx/guolindev/request/InvisibleFragment;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;
    invoke-static {v0}, Lcom/permissionx/guolindev/request/InvisibleFragment;->access$getPb$p(Lcom/permissionx/guolindev/request/InvisibleFragment;)Lcom/permissionx/guolindev/request/PermissionBuilder;

    move-result-object v0

    if-nez v0, :cond_3f

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v2

    :cond_3f
    iget-object v0, v0, Lcom/permissionx/guolindev/request/PermissionBuilder;->explainReasonCallbackWithBeforeParam:Lcom/permissionx/guolindev/callback/ExplainReasonCallbackWithBeforeParam;

    if-eqz v0, :cond_a9

    .line 588
    :cond_43
    iget-object v0, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestNotificationPermissionResult$1;->this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;

    # getter for: Lcom/permissionx/guolindev/request/InvisibleFragment;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;
    invoke-static {v0}, Lcom/permissionx/guolindev/request/InvisibleFragment;->access$getPb$p(Lcom/permissionx/guolindev/request/InvisibleFragment;)Lcom/permissionx/guolindev/request/PermissionBuilder;

    move-result-object v0

    if-nez v0, :cond_4f

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v2

    :cond_4f
    iget-object v0, v0, Lcom/permissionx/guolindev/request/PermissionBuilder;->explainReasonCallbackWithBeforeParam:Lcom/permissionx/guolindev/callback/ExplainReasonCallbackWithBeforeParam;

    const-string v4, "android.permission.POST_NOTIFICATIONS"

    if-eqz v0, :cond_80

    .line 590
    iget-object v0, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestNotificationPermissionResult$1;->this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;

    # getter for: Lcom/permissionx/guolindev/request/InvisibleFragment;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;
    invoke-static {v0}, Lcom/permissionx/guolindev/request/InvisibleFragment;->access$getPb$p(Lcom/permissionx/guolindev/request/InvisibleFragment;)Lcom/permissionx/guolindev/request/PermissionBuilder;

    move-result-object v0

    if-nez v0, :cond_61

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v2

    :cond_61
    iget-object v0, v0, Lcom/permissionx/guolindev/request/PermissionBuilder;->explainReasonCallbackWithBeforeParam:Lcom/permissionx/guolindev/callback/ExplainReasonCallbackWithBeforeParam;

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    .line 591
    iget-object v3, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestNotificationPermissionResult$1;->this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;

    # getter for: Lcom/permissionx/guolindev/request/InvisibleFragment;->task:Lcom/permissionx/guolindev/request/ChainTask;
    invoke-static {v3}, Lcom/permissionx/guolindev/request/InvisibleFragment;->access$getTask$p(Lcom/permissionx/guolindev/request/InvisibleFragment;)Lcom/permissionx/guolindev/request/ChainTask;

    move-result-object v3

    if-nez v3, :cond_72

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_73

    :cond_72
    move-object v2, v3

    :goto_73
    invoke-interface {v2}, Lcom/permissionx/guolindev/request/ChainTask;->getExplainScope()Lcom/permissionx/guolindev/request/ExplainScope;

    move-result-object v1

    .line 592
    invoke-static {v4}, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v2

    const/4 v3, 0x0

    .line 590
    invoke-interface {v0, v1, v2, v3}, Lcom/permissionx/guolindev/callback/ExplainReasonCallbackWithBeforeParam;->onExplainReason(Lcom/permissionx/guolindev/request/ExplainScope;Ljava/util/List;Z)V

    goto :goto_a9

    .line 596
    :cond_80
    iget-object v0, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestNotificationPermissionResult$1;->this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;

    # getter for: Lcom/permissionx/guolindev/request/InvisibleFragment;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;
    invoke-static {v0}, Lcom/permissionx/guolindev/request/InvisibleFragment;->access$getPb$p(Lcom/permissionx/guolindev/request/InvisibleFragment;)Lcom/permissionx/guolindev/request/PermissionBuilder;

    move-result-object v0

    if-nez v0, :cond_8c

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v2

    :cond_8c
    iget-object v0, v0, Lcom/permissionx/guolindev/request/PermissionBuilder;->explainReasonCallback:Lcom/permissionx/guolindev/callback/ExplainReasonCallback;

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    .line 597
    iget-object v3, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestNotificationPermissionResult$1;->this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;

    # getter for: Lcom/permissionx/guolindev/request/InvisibleFragment;->task:Lcom/permissionx/guolindev/request/ChainTask;
    invoke-static {v3}, Lcom/permissionx/guolindev/request/InvisibleFragment;->access$getTask$p(Lcom/permissionx/guolindev/request/InvisibleFragment;)Lcom/permissionx/guolindev/request/ChainTask;

    move-result-object v3

    if-nez v3, :cond_9d

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_9e

    :cond_9d
    move-object v2, v3

    :goto_9e
    invoke-interface {v2}, Lcom/permissionx/guolindev/request/ChainTask;->getExplainScope()Lcom/permissionx/guolindev/request/ExplainScope;

    move-result-object v1

    .line 598
    invoke-static {v4}, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v2

    .line 596
    invoke-interface {v0, v1, v2}, Lcom/permissionx/guolindev/callback/ExplainReasonCallback;->onExplainReason(Lcom/permissionx/guolindev/request/ExplainScope;Ljava/util/List;)V

    :cond_a9
    :goto_a9
    return-void
.end method
