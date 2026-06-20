.class public final Lcom/permissionx/guolindev/request/RequestNormalPermissions;
.super Lcom/permissionx/guolindev/request/BaseTask;
.source "RequestNormalPermissions.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\u000f\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0008\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\u0007\u001a\u00020\u00062\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\tH\u0016\u00a8\u0006\u000b"
    }
    d2 = {
        "Lcom/permissionx/guolindev/request/RequestNormalPermissions;",
        "Lcom/permissionx/guolindev/request/BaseTask;",
        "permissionBuilder",
        "Lcom/permissionx/guolindev/request/PermissionBuilder;",
        "(Lcom/permissionx/guolindev/request/PermissionBuilder;)V",
        "request",
        "",
        "requestAgain",
        "permissions",
        "",
        "",
        "permissionx_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x7,
        0x1
    }
    xi = 0x30
.end annotation


# direct methods
.method public constructor <init>(Lcom/permissionx/guolindev/request/PermissionBuilder;)V
    .registers 3

    const-string v0, "permissionBuilder"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 27
    invoke-direct {p0, p1}, Lcom/permissionx/guolindev/request/BaseTask;-><init>(Lcom/permissionx/guolindev/request/PermissionBuilder;)V

    return-void
.end method


# virtual methods
.method public request()V
    .registers 5

    .line 30
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 31
    iget-object v1, p0, Lcom/permissionx/guolindev/request/RequestNormalPermissions;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    iget-object v1, v1, Lcom/permissionx/guolindev/request/PermissionBuilder;->normalPermissions:Ljava/util/Set;

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_d
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_33

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 32
    iget-object v3, p0, Lcom/permissionx/guolindev/request/RequestNormalPermissions;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    invoke-virtual {v3}, Lcom/permissionx/guolindev/request/PermissionBuilder;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v3

    check-cast v3, Landroid/content/Context;

    invoke-static {v3, v2}, Lcom/permissionx/guolindev/PermissionX;->isGranted(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2f

    .line 33
    iget-object v3, p0, Lcom/permissionx/guolindev/request/RequestNormalPermissions;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    iget-object v3, v3, Lcom/permissionx/guolindev/request/PermissionBuilder;->grantedPermissions:Ljava/util/Set;

    invoke-interface {v3, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_d

    .line 35
    :cond_2f
    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_d

    .line 38
    :cond_33
    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_3d

    .line 39
    invoke-virtual {p0}, Lcom/permissionx/guolindev/request/RequestNormalPermissions;->finish()V

    return-void

    .line 42
    :cond_3d
    iget-object v1, p0, Lcom/permissionx/guolindev/request/RequestNormalPermissions;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    iget-boolean v1, v1, Lcom/permissionx/guolindev/request/PermissionBuilder;->explainReasonBeforeRequest:Z

    if-eqz v1, :cond_87

    iget-object v1, p0, Lcom/permissionx/guolindev/request/RequestNormalPermissions;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    iget-object v1, v1, Lcom/permissionx/guolindev/request/PermissionBuilder;->explainReasonCallback:Lcom/permissionx/guolindev/callback/ExplainReasonCallback;

    if-nez v1, :cond_4f

    iget-object v1, p0, Lcom/permissionx/guolindev/request/RequestNormalPermissions;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    iget-object v1, v1, Lcom/permissionx/guolindev/request/PermissionBuilder;->explainReasonCallbackWithBeforeParam:Lcom/permissionx/guolindev/callback/ExplainReasonCallbackWithBeforeParam;

    if-eqz v1, :cond_87

    .line 43
    :cond_4f
    iget-object v1, p0, Lcom/permissionx/guolindev/request/RequestNormalPermissions;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    const/4 v2, 0x0

    iput-boolean v2, v1, Lcom/permissionx/guolindev/request/PermissionBuilder;->explainReasonBeforeRequest:Z

    .line 44
    iget-object v1, p0, Lcom/permissionx/guolindev/request/RequestNormalPermissions;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    iget-object v1, v1, Lcom/permissionx/guolindev/request/PermissionBuilder;->deniedPermissions:Ljava/util/Set;

    move-object v2, v0

    check-cast v2, Ljava/util/Collection;

    invoke-interface {v1, v2}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 45
    iget-object v1, p0, Lcom/permissionx/guolindev/request/RequestNormalPermissions;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    iget-object v1, v1, Lcom/permissionx/guolindev/request/PermissionBuilder;->explainReasonCallbackWithBeforeParam:Lcom/permissionx/guolindev/callback/ExplainReasonCallbackWithBeforeParam;

    if-eqz v1, :cond_76

    .line 47
    iget-object v1, p0, Lcom/permissionx/guolindev/request/RequestNormalPermissions;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    iget-object v1, v1, Lcom/permissionx/guolindev/request/PermissionBuilder;->explainReasonCallbackWithBeforeParam:Lcom/permissionx/guolindev/callback/ExplainReasonCallbackWithBeforeParam;

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {p0}, Lcom/permissionx/guolindev/request/RequestNormalPermissions;->getExplainScope()Lcom/permissionx/guolindev/request/ExplainScope;

    move-result-object v2

    check-cast v0, Ljava/util/List;

    const/4 v3, 0x1

    invoke-interface {v1, v2, v0, v3}, Lcom/permissionx/guolindev/callback/ExplainReasonCallbackWithBeforeParam;->onExplainReason(Lcom/permissionx/guolindev/request/ExplainScope;Ljava/util/List;Z)V

    goto :goto_93

    .line 49
    :cond_76
    iget-object v1, p0, Lcom/permissionx/guolindev/request/RequestNormalPermissions;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    iget-object v1, v1, Lcom/permissionx/guolindev/request/PermissionBuilder;->explainReasonCallback:Lcom/permissionx/guolindev/callback/ExplainReasonCallback;

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {p0}, Lcom/permissionx/guolindev/request/RequestNormalPermissions;->getExplainScope()Lcom/permissionx/guolindev/request/ExplainScope;

    move-result-object v2

    check-cast v0, Ljava/util/List;

    invoke-interface {v1, v2, v0}, Lcom/permissionx/guolindev/callback/ExplainReasonCallback;->onExplainReason(Lcom/permissionx/guolindev/request/ExplainScope;Ljava/util/List;)V

    goto :goto_93

    .line 53
    :cond_87
    iget-object v0, p0, Lcom/permissionx/guolindev/request/RequestNormalPermissions;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    iget-object v1, p0, Lcom/permissionx/guolindev/request/RequestNormalPermissions;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    iget-object v1, v1, Lcom/permissionx/guolindev/request/PermissionBuilder;->normalPermissions:Ljava/util/Set;

    move-object v2, p0

    check-cast v2, Lcom/permissionx/guolindev/request/ChainTask;

    invoke-virtual {v0, v1, v2}, Lcom/permissionx/guolindev/request/PermissionBuilder;->requestNow(Ljava/util/Set;Lcom/permissionx/guolindev/request/ChainTask;)V

    :goto_93
    return-void
.end method

.method public requestAgain(Ljava/util/List;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    const-string v0, "permissions"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 63
    new-instance v0, Ljava/util/HashSet;

    iget-object v1, p0, Lcom/permissionx/guolindev/request/RequestNormalPermissions;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    iget-object v1, v1, Lcom/permissionx/guolindev/request/PermissionBuilder;->grantedPermissions:Ljava/util/Set;

    check-cast v1, Ljava/util/Collection;

    invoke-direct {v0, v1}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    check-cast v0, Ljava/util/Set;

    .line 64
    check-cast p1, Ljava/util/Collection;

    invoke-interface {v0, p1}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 65
    move-object p1, v0

    check-cast p1, Ljava/util/Collection;

    invoke-interface {p1}, Ljava/util/Collection;->isEmpty()Z

    move-result p1

    xor-int/lit8 p1, p1, 0x1

    if-eqz p1, :cond_2b

    .line 66
    iget-object p1, p0, Lcom/permissionx/guolindev/request/RequestNormalPermissions;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    move-object v1, p0

    check-cast v1, Lcom/permissionx/guolindev/request/ChainTask;

    invoke-virtual {p1, v0, v1}, Lcom/permissionx/guolindev/request/PermissionBuilder;->requestNow(Ljava/util/Set;Lcom/permissionx/guolindev/request/ChainTask;)V

    goto :goto_2e

    .line 68
    :cond_2b
    invoke-virtual {p0}, Lcom/permissionx/guolindev/request/RequestNormalPermissions;->finish()V

    :goto_2e
    return-void
.end method
