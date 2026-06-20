.class public final Lcom/permissionx/guolindev/request/RequestBodySensorsBackgroundPermission;
.super Lcom/permissionx/guolindev/request/BaseTask;
.source "RequestBodySensorsBackgroundPermission.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/permissionx/guolindev/request/RequestBodySensorsBackgroundPermission$Companion;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0008\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\u0007\u001a\u00020\u00062\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\tH\u0016\u00a8\u0006\u000c"
    }
    d2 = {
        "Lcom/permissionx/guolindev/request/RequestBodySensorsBackgroundPermission;",
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
        "Companion",
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


# static fields
.field public static final BODY_SENSORS_BACKGROUND:Ljava/lang/String; = "android.permission.BODY_SENSORS_BACKGROUND"

.field public static final Companion:Lcom/permissionx/guolindev/request/RequestBodySensorsBackgroundPermission$Companion;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    new-instance v0, Lcom/permissionx/guolindev/request/RequestBodySensorsBackgroundPermission$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/permissionx/guolindev/request/RequestBodySensorsBackgroundPermission$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lcom/permissionx/guolindev/request/RequestBodySensorsBackgroundPermission;->Companion:Lcom/permissionx/guolindev/request/RequestBodySensorsBackgroundPermission$Companion;

    return-void
.end method

.method public constructor <init>(Lcom/permissionx/guolindev/request/PermissionBuilder;)V
    .registers 3

    const-string v0, "permissionBuilder"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 28
    invoke-direct {p0, p1}, Lcom/permissionx/guolindev/request/BaseTask;-><init>(Lcom/permissionx/guolindev/request/PermissionBuilder;)V

    return-void
.end method


# virtual methods
.method public request()V
    .registers 5

    .line 31
    iget-object v0, p0, Lcom/permissionx/guolindev/request/RequestBodySensorsBackgroundPermission;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    invoke-virtual {v0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->shouldRequestBodySensorsBackgroundPermission()Z

    move-result v0

    if-eqz v0, :cond_86

    .line 32
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x21

    const-string v2, "android.permission.BODY_SENSORS_BACKGROUND"

    if-ge v0, v1, :cond_22

    .line 35
    iget-object v0, p0, Lcom/permissionx/guolindev/request/RequestBodySensorsBackgroundPermission;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    iget-object v0, v0, Lcom/permissionx/guolindev/request/PermissionBuilder;->specialPermissions:Ljava/util/Set;

    invoke-interface {v0, v2}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 36
    iget-object v0, p0, Lcom/permissionx/guolindev/request/RequestBodySensorsBackgroundPermission;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    iget-object v0, v0, Lcom/permissionx/guolindev/request/PermissionBuilder;->permissionsWontRequest:Ljava/util/Set;

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 37
    invoke-virtual {p0}, Lcom/permissionx/guolindev/request/RequestBodySensorsBackgroundPermission;->finish()V

    return-void

    .line 40
    :cond_22
    iget-object v0, p0, Lcom/permissionx/guolindev/request/RequestBodySensorsBackgroundPermission;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    invoke-virtual {v0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    invoke-static {v0, v2}, Lcom/permissionx/guolindev/PermissionX;->isGranted(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_34

    .line 42
    invoke-virtual {p0}, Lcom/permissionx/guolindev/request/RequestBodySensorsBackgroundPermission;->finish()V

    return-void

    .line 46
    :cond_34
    iget-object v0, p0, Lcom/permissionx/guolindev/request/RequestBodySensorsBackgroundPermission;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    invoke-virtual {v0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    const-string v1, "android.permission.BODY_SENSORS"

    invoke-static {v0, v1}, Lcom/permissionx/guolindev/PermissionX;->isGranted(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_86

    .line 51
    iget-object v0, p0, Lcom/permissionx/guolindev/request/RequestBodySensorsBackgroundPermission;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    iget-object v0, v0, Lcom/permissionx/guolindev/request/PermissionBuilder;->explainReasonCallback:Lcom/permissionx/guolindev/callback/ExplainReasonCallback;

    if-nez v0, :cond_59

    iget-object v0, p0, Lcom/permissionx/guolindev/request/RequestBodySensorsBackgroundPermission;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    iget-object v0, v0, Lcom/permissionx/guolindev/request/PermissionBuilder;->explainReasonCallbackWithBeforeParam:Lcom/permissionx/guolindev/callback/ExplainReasonCallbackWithBeforeParam;

    if-eqz v0, :cond_51

    goto :goto_59

    .line 61
    :cond_51
    invoke-static {}, Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/permissionx/guolindev/request/RequestBodySensorsBackgroundPermission;->requestAgain(Ljava/util/List;)V

    goto :goto_85

    .line 52
    :cond_59
    :goto_59
    filled-new-array {v2}, [Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lkotlin/collections/CollectionsKt;->mutableListOf([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    .line 53
    iget-object v1, p0, Lcom/permissionx/guolindev/request/RequestBodySensorsBackgroundPermission;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    iget-object v1, v1, Lcom/permissionx/guolindev/request/PermissionBuilder;->explainReasonCallbackWithBeforeParam:Lcom/permissionx/guolindev/callback/ExplainReasonCallbackWithBeforeParam;

    if-eqz v1, :cond_77

    .line 55
    iget-object v1, p0, Lcom/permissionx/guolindev/request/RequestBodySensorsBackgroundPermission;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    iget-object v1, v1, Lcom/permissionx/guolindev/request/PermissionBuilder;->explainReasonCallbackWithBeforeParam:Lcom/permissionx/guolindev/callback/ExplainReasonCallbackWithBeforeParam;

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {p0}, Lcom/permissionx/guolindev/request/RequestBodySensorsBackgroundPermission;->getExplainScope()Lcom/permissionx/guolindev/request/ExplainScope;

    move-result-object v2

    const/4 v3, 0x1

    invoke-interface {v1, v2, v0, v3}, Lcom/permissionx/guolindev/callback/ExplainReasonCallbackWithBeforeParam;->onExplainReason(Lcom/permissionx/guolindev/request/ExplainScope;Ljava/util/List;Z)V

    goto :goto_85

    .line 57
    :cond_77
    iget-object v1, p0, Lcom/permissionx/guolindev/request/RequestBodySensorsBackgroundPermission;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    iget-object v1, v1, Lcom/permissionx/guolindev/request/PermissionBuilder;->explainReasonCallback:Lcom/permissionx/guolindev/callback/ExplainReasonCallback;

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {p0}, Lcom/permissionx/guolindev/request/RequestBodySensorsBackgroundPermission;->getExplainScope()Lcom/permissionx/guolindev/request/ExplainScope;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Lcom/permissionx/guolindev/callback/ExplainReasonCallback;->onExplainReason(Lcom/permissionx/guolindev/request/ExplainScope;Ljava/util/List;)V

    :goto_85
    return-void

    .line 67
    :cond_86
    invoke-virtual {p0}, Lcom/permissionx/guolindev/request/RequestBodySensorsBackgroundPermission;->finish()V

    return-void
.end method

.method public requestAgain(Ljava/util/List;)V
    .registers 3
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

    .line 72
    iget-object p1, p0, Lcom/permissionx/guolindev/request/RequestBodySensorsBackgroundPermission;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    move-object v0, p0

    check-cast v0, Lcom/permissionx/guolindev/request/ChainTask;

    invoke-virtual {p1, v0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->requestBodySensorsBackgroundPermissionNow(Lcom/permissionx/guolindev/request/ChainTask;)V

    return-void
.end method
