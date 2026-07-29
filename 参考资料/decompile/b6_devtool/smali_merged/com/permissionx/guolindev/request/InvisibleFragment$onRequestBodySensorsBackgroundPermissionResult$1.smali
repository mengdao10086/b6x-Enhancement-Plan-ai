.class final Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestBodySensorsBackgroundPermissionResult$1;
.super Lkotlin/jvm/internal/Lambda;
.source "InvisibleFragment.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function0;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/permissionx/guolindev/request/InvisibleFragment;->onRequestBodySensorsBackgroundPermissionResult(Z)V
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
.field final synthetic $granted:Z

.field final synthetic this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;


# direct methods
.method constructor <init>(ZLcom/permissionx/guolindev/request/InvisibleFragment;)V
    .registers 3

    iput-boolean p1, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestBodySensorsBackgroundPermissionResult$1;->$granted:Z

    iput-object p2, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestBodySensorsBackgroundPermissionResult$1;->this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;

    const/4 p1, 0x0

    invoke-direct {p0, p1}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke()Ljava/lang/Object;
    .registers 2

    .line 614
    invoke-virtual {p0}, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestBodySensorsBackgroundPermissionResult$1;->invoke()V

    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object v0
.end method

.method public final invoke()V
    .registers 8

    .line 615
    iget-boolean v0, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestBodySensorsBackgroundPermissionResult$1;->$granted:Z

    const-string v1, "task"

    const-string v2, "android.permission.BODY_SENSORS_BACKGROUND"

    const-string v3, "pb"

    const/4 v4, 0x0

    if-eqz v0, :cond_50

    .line 616
    iget-object v0, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestBodySensorsBackgroundPermissionResult$1;->this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;

    # getter for: Lcom/permissionx/guolindev/request/InvisibleFragment;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;
    invoke-static {v0}, Lcom/permissionx/guolindev/request/InvisibleFragment;->access$getPb$p(Lcom/permissionx/guolindev/request/InvisibleFragment;)Lcom/permissionx/guolindev/request/PermissionBuilder;

    move-result-object v0

    if-nez v0, :cond_17

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v4

    :cond_17
    iget-object v0, v0, Lcom/permissionx/guolindev/request/PermissionBuilder;->grantedPermissions:Ljava/util/Set;

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 618
    iget-object v0, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestBodySensorsBackgroundPermissionResult$1;->this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;

    # getter for: Lcom/permissionx/guolindev/request/InvisibleFragment;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;
    invoke-static {v0}, Lcom/permissionx/guolindev/request/InvisibleFragment;->access$getPb$p(Lcom/permissionx/guolindev/request/InvisibleFragment;)Lcom/permissionx/guolindev/request/PermissionBuilder;

    move-result-object v0

    if-nez v0, :cond_28

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v4

    :cond_28
    iget-object v0, v0, Lcom/permissionx/guolindev/request/PermissionBuilder;->deniedPermissions:Ljava/util/Set;

    invoke-interface {v0, v2}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 619
    iget-object v0, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestBodySensorsBackgroundPermissionResult$1;->this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;

    # getter for: Lcom/permissionx/guolindev/request/InvisibleFragment;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;
    invoke-static {v0}, Lcom/permissionx/guolindev/request/InvisibleFragment;->access$getPb$p(Lcom/permissionx/guolindev/request/InvisibleFragment;)Lcom/permissionx/guolindev/request/PermissionBuilder;

    move-result-object v0

    if-nez v0, :cond_39

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v4

    :cond_39
    iget-object v0, v0, Lcom/permissionx/guolindev/request/PermissionBuilder;->permanentDeniedPermissions:Ljava/util/Set;

    invoke-interface {v0, v2}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 620
    iget-object v0, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestBodySensorsBackgroundPermissionResult$1;->this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;

    # getter for: Lcom/permissionx/guolindev/request/InvisibleFragment;->task:Lcom/permissionx/guolindev/request/ChainTask;
    invoke-static {v0}, Lcom/permissionx/guolindev/request/InvisibleFragment;->access$getTask$p(Lcom/permissionx/guolindev/request/InvisibleFragment;)Lcom/permissionx/guolindev/request/ChainTask;

    move-result-object v0

    if-nez v0, :cond_4a

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_4b

    :cond_4a
    move-object v4, v0

    :goto_4b
    invoke-interface {v4}, Lcom/permissionx/guolindev/request/ChainTask;->finish()V

    goto/16 :goto_141

    .line 624
    :cond_50
    iget-object v0, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestBodySensorsBackgroundPermissionResult$1;->this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;

    invoke-virtual {v0, v2}, Lcom/permissionx/guolindev/request/InvisibleFragment;->shouldShowRequestPermissionRationale(Ljava/lang/String;)Z

    move-result v0

    .line 626
    iget-object v5, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestBodySensorsBackgroundPermissionResult$1;->this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;

    # getter for: Lcom/permissionx/guolindev/request/InvisibleFragment;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;
    invoke-static {v5}, Lcom/permissionx/guolindev/request/InvisibleFragment;->access$getPb$p(Lcom/permissionx/guolindev/request/InvisibleFragment;)Lcom/permissionx/guolindev/request/PermissionBuilder;

    move-result-object v5

    if-nez v5, :cond_62

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v5, v4

    :cond_62
    iget-object v5, v5, Lcom/permissionx/guolindev/request/PermissionBuilder;->explainReasonCallback:Lcom/permissionx/guolindev/callback/ExplainReasonCallback;

    const/4 v6, 0x0

    if-nez v5, :cond_77

    iget-object v5, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestBodySensorsBackgroundPermissionResult$1;->this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;

    # getter for: Lcom/permissionx/guolindev/request/InvisibleFragment;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;
    invoke-static {v5}, Lcom/permissionx/guolindev/request/InvisibleFragment;->access$getPb$p(Lcom/permissionx/guolindev/request/InvisibleFragment;)Lcom/permissionx/guolindev/request/PermissionBuilder;

    move-result-object v5

    if-nez v5, :cond_73

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v5, v4

    :cond_73
    iget-object v5, v5, Lcom/permissionx/guolindev/request/PermissionBuilder;->explainReasonCallbackWithBeforeParam:Lcom/permissionx/guolindev/callback/ExplainReasonCallbackWithBeforeParam;

    if-eqz v5, :cond_dd

    :cond_77
    if-eqz v0, :cond_dd

    .line 629
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    check-cast v0, Ljava/util/List;

    .line 630
    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 631
    iget-object v2, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestBodySensorsBackgroundPermissionResult$1;->this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;

    # getter for: Lcom/permissionx/guolindev/request/InvisibleFragment;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;
    invoke-static {v2}, Lcom/permissionx/guolindev/request/InvisibleFragment;->access$getPb$p(Lcom/permissionx/guolindev/request/InvisibleFragment;)Lcom/permissionx/guolindev/request/PermissionBuilder;

    move-result-object v2

    if-nez v2, :cond_8f

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v2, v4

    :cond_8f
    iget-object v2, v2, Lcom/permissionx/guolindev/request/PermissionBuilder;->explainReasonCallbackWithBeforeParam:Lcom/permissionx/guolindev/callback/ExplainReasonCallbackWithBeforeParam;

    if-eqz v2, :cond_b8

    .line 633
    iget-object v2, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestBodySensorsBackgroundPermissionResult$1;->this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;

    # getter for: Lcom/permissionx/guolindev/request/InvisibleFragment;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;
    invoke-static {v2}, Lcom/permissionx/guolindev/request/InvisibleFragment;->access$getPb$p(Lcom/permissionx/guolindev/request/InvisibleFragment;)Lcom/permissionx/guolindev/request/PermissionBuilder;

    move-result-object v2

    if-nez v2, :cond_9f

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v2, v4

    :cond_9f
    iget-object v2, v2, Lcom/permissionx/guolindev/request/PermissionBuilder;->explainReasonCallbackWithBeforeParam:Lcom/permissionx/guolindev/callback/ExplainReasonCallbackWithBeforeParam;

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    .line 634
    iget-object v5, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestBodySensorsBackgroundPermissionResult$1;->this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;

    # getter for: Lcom/permissionx/guolindev/request/InvisibleFragment;->task:Lcom/permissionx/guolindev/request/ChainTask;
    invoke-static {v5}, Lcom/permissionx/guolindev/request/InvisibleFragment;->access$getTask$p(Lcom/permissionx/guolindev/request/InvisibleFragment;)Lcom/permissionx/guolindev/request/ChainTask;

    move-result-object v5

    if-nez v5, :cond_b0

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v5, v4

    :cond_b0
    invoke-interface {v5}, Lcom/permissionx/guolindev/request/ChainTask;->getExplainScope()Lcom/permissionx/guolindev/request/ExplainScope;

    move-result-object v5

    .line 633
    invoke-interface {v2, v5, v0, v6}, Lcom/permissionx/guolindev/callback/ExplainReasonCallbackWithBeforeParam;->onExplainReason(Lcom/permissionx/guolindev/request/ExplainScope;Ljava/util/List;Z)V

    goto :goto_11f

    .line 637
    :cond_b8
    iget-object v2, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestBodySensorsBackgroundPermissionResult$1;->this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;

    # getter for: Lcom/permissionx/guolindev/request/InvisibleFragment;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;
    invoke-static {v2}, Lcom/permissionx/guolindev/request/InvisibleFragment;->access$getPb$p(Lcom/permissionx/guolindev/request/InvisibleFragment;)Lcom/permissionx/guolindev/request/PermissionBuilder;

    move-result-object v2

    if-nez v2, :cond_c4

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v2, v4

    :cond_c4
    iget-object v2, v2, Lcom/permissionx/guolindev/request/PermissionBuilder;->explainReasonCallback:Lcom/permissionx/guolindev/callback/ExplainReasonCallback;

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    .line 638
    iget-object v5, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestBodySensorsBackgroundPermissionResult$1;->this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;

    # getter for: Lcom/permissionx/guolindev/request/InvisibleFragment;->task:Lcom/permissionx/guolindev/request/ChainTask;
    invoke-static {v5}, Lcom/permissionx/guolindev/request/InvisibleFragment;->access$getTask$p(Lcom/permissionx/guolindev/request/InvisibleFragment;)Lcom/permissionx/guolindev/request/ChainTask;

    move-result-object v5

    if-nez v5, :cond_d5

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v5, v4

    :cond_d5
    invoke-interface {v5}, Lcom/permissionx/guolindev/request/ChainTask;->getExplainScope()Lcom/permissionx/guolindev/request/ExplainScope;

    move-result-object v5

    .line 637
    invoke-interface {v2, v5, v0}, Lcom/permissionx/guolindev/callback/ExplainReasonCallback;->onExplainReason(Lcom/permissionx/guolindev/request/ExplainScope;Ljava/util/List;)V

    goto :goto_11f

    .line 642
    :cond_dd
    iget-object v5, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestBodySensorsBackgroundPermissionResult$1;->this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;

    # getter for: Lcom/permissionx/guolindev/request/InvisibleFragment;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;
    invoke-static {v5}, Lcom/permissionx/guolindev/request/InvisibleFragment;->access$getPb$p(Lcom/permissionx/guolindev/request/InvisibleFragment;)Lcom/permissionx/guolindev/request/PermissionBuilder;

    move-result-object v5

    if-nez v5, :cond_e9

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v5, v4

    :cond_e9
    iget-object v5, v5, Lcom/permissionx/guolindev/request/PermissionBuilder;->forwardToSettingsCallback:Lcom/permissionx/guolindev/callback/ForwardToSettingsCallback;

    if-eqz v5, :cond_11e

    if-nez v0, :cond_11e

    .line 645
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    check-cast v0, Ljava/util/List;

    .line 646
    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 647
    iget-object v2, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestBodySensorsBackgroundPermissionResult$1;->this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;

    # getter for: Lcom/permissionx/guolindev/request/InvisibleFragment;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;
    invoke-static {v2}, Lcom/permissionx/guolindev/request/InvisibleFragment;->access$getPb$p(Lcom/permissionx/guolindev/request/InvisibleFragment;)Lcom/permissionx/guolindev/request/PermissionBuilder;

    move-result-object v2

    if-nez v2, :cond_105

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v2, v4

    :cond_105
    iget-object v2, v2, Lcom/permissionx/guolindev/request/PermissionBuilder;->forwardToSettingsCallback:Lcom/permissionx/guolindev/callback/ForwardToSettingsCallback;

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    .line 648
    iget-object v5, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestBodySensorsBackgroundPermissionResult$1;->this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;

    # getter for: Lcom/permissionx/guolindev/request/InvisibleFragment;->task:Lcom/permissionx/guolindev/request/ChainTask;
    invoke-static {v5}, Lcom/permissionx/guolindev/request/InvisibleFragment;->access$getTask$p(Lcom/permissionx/guolindev/request/InvisibleFragment;)Lcom/permissionx/guolindev/request/ChainTask;

    move-result-object v5

    if-nez v5, :cond_116

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v5, v4

    :cond_116
    invoke-interface {v5}, Lcom/permissionx/guolindev/request/ChainTask;->getForwardScope()Lcom/permissionx/guolindev/request/ForwardScope;

    move-result-object v5

    .line 647
    invoke-interface {v2, v5, v0}, Lcom/permissionx/guolindev/callback/ForwardToSettingsCallback;->onForwardToSettings(Lcom/permissionx/guolindev/request/ForwardScope;Ljava/util/List;)V

    goto :goto_11f

    :cond_11e
    const/4 v6, 0x1

    :goto_11f
    if-nez v6, :cond_131

    .line 656
    iget-object v0, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestBodySensorsBackgroundPermissionResult$1;->this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;

    # getter for: Lcom/permissionx/guolindev/request/InvisibleFragment;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;
    invoke-static {v0}, Lcom/permissionx/guolindev/request/InvisibleFragment;->access$getPb$p(Lcom/permissionx/guolindev/request/InvisibleFragment;)Lcom/permissionx/guolindev/request/PermissionBuilder;

    move-result-object v0

    if-nez v0, :cond_12d

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v4

    :cond_12d
    iget-boolean v0, v0, Lcom/permissionx/guolindev/request/PermissionBuilder;->showDialogCalled:Z

    if-nez v0, :cond_141

    .line 657
    :cond_131
    iget-object v0, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$onRequestBodySensorsBackgroundPermissionResult$1;->this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;

    # getter for: Lcom/permissionx/guolindev/request/InvisibleFragment;->task:Lcom/permissionx/guolindev/request/ChainTask;
    invoke-static {v0}, Lcom/permissionx/guolindev/request/InvisibleFragment;->access$getTask$p(Lcom/permissionx/guolindev/request/InvisibleFragment;)Lcom/permissionx/guolindev/request/ChainTask;

    move-result-object v0

    if-nez v0, :cond_13d

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_13e

    :cond_13d
    move-object v4, v0

    :goto_13e
    invoke-interface {v4}, Lcom/permissionx/guolindev/request/ChainTask;->finish()V

    :cond_141
    :goto_141
    return-void
.end method
