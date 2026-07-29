.class public final Lcom/permissionx/guolindev/request/RequestManageExternalStoragePermission;
.super Lcom/permissionx/guolindev/request/BaseTask;
.source "RequestManageExternalStoragePermission.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/permissionx/guolindev/request/RequestManageExternalStoragePermission$Companion;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0008\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\u0007\u001a\u00020\u00062\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\tH\u0016\u00a8\u0006\u000c"
    }
    d2 = {
        "Lcom/permissionx/guolindev/request/RequestManageExternalStoragePermission;",
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
.field public static final Companion:Lcom/permissionx/guolindev/request/RequestManageExternalStoragePermission$Companion;

.field public static final MANAGE_EXTERNAL_STORAGE:Ljava/lang/String; = "android.permission.MANAGE_EXTERNAL_STORAGE"


# direct methods
.method static constructor <clinit>()V
    .registers 2

    new-instance v0, Lcom/permissionx/guolindev/request/RequestManageExternalStoragePermission$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/permissionx/guolindev/request/RequestManageExternalStoragePermission$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lcom/permissionx/guolindev/request/RequestManageExternalStoragePermission;->Companion:Lcom/permissionx/guolindev/request/RequestManageExternalStoragePermission$Companion;

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
    iget-object v0, p0, Lcom/permissionx/guolindev/request/RequestManageExternalStoragePermission;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    invoke-virtual {v0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->shouldRequestManageExternalStoragePermission()Z

    move-result v0

    if-eqz v0, :cond_58

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1e

    if-lt v0, v1, :cond_58

    .line 32
    invoke-static {}, Landroid/os/Environment;->isExternalStorageManager()Z

    move-result v0

    if-eqz v0, :cond_18

    .line 34
    invoke-virtual {p0}, Lcom/permissionx/guolindev/request/RequestManageExternalStoragePermission;->finish()V

    return-void

    .line 37
    :cond_18
    iget-object v0, p0, Lcom/permissionx/guolindev/request/RequestManageExternalStoragePermission;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    iget-object v0, v0, Lcom/permissionx/guolindev/request/PermissionBuilder;->explainReasonCallback:Lcom/permissionx/guolindev/callback/ExplainReasonCallback;

    if-nez v0, :cond_29

    iget-object v0, p0, Lcom/permissionx/guolindev/request/RequestManageExternalStoragePermission;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    iget-object v0, v0, Lcom/permissionx/guolindev/request/PermissionBuilder;->explainReasonCallbackWithBeforeParam:Lcom/permissionx/guolindev/callback/ExplainReasonCallbackWithBeforeParam;

    if-eqz v0, :cond_25

    goto :goto_29

    .line 48
    :cond_25
    invoke-virtual {p0}, Lcom/permissionx/guolindev/request/RequestManageExternalStoragePermission;->finish()V

    goto :goto_57

    :cond_29
    :goto_29
    const-string v0, "android.permission.MANAGE_EXTERNAL_STORAGE"

    .line 38
    filled-new-array {v0}, [Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lkotlin/collections/CollectionsKt;->mutableListOf([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    .line 39
    iget-object v1, p0, Lcom/permissionx/guolindev/request/RequestManageExternalStoragePermission;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    iget-object v1, v1, Lcom/permissionx/guolindev/request/PermissionBuilder;->explainReasonCallbackWithBeforeParam:Lcom/permissionx/guolindev/callback/ExplainReasonCallbackWithBeforeParam;

    if-eqz v1, :cond_49

    .line 41
    iget-object v1, p0, Lcom/permissionx/guolindev/request/RequestManageExternalStoragePermission;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    iget-object v1, v1, Lcom/permissionx/guolindev/request/PermissionBuilder;->explainReasonCallbackWithBeforeParam:Lcom/permissionx/guolindev/callback/ExplainReasonCallbackWithBeforeParam;

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {p0}, Lcom/permissionx/guolindev/request/RequestManageExternalStoragePermission;->getExplainScope()Lcom/permissionx/guolindev/request/ExplainScope;

    move-result-object v2

    const/4 v3, 0x1

    invoke-interface {v1, v2, v0, v3}, Lcom/permissionx/guolindev/callback/ExplainReasonCallbackWithBeforeParam;->onExplainReason(Lcom/permissionx/guolindev/request/ExplainScope;Ljava/util/List;Z)V

    goto :goto_57

    .line 43
    :cond_49
    iget-object v1, p0, Lcom/permissionx/guolindev/request/RequestManageExternalStoragePermission;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    iget-object v1, v1, Lcom/permissionx/guolindev/request/PermissionBuilder;->explainReasonCallback:Lcom/permissionx/guolindev/callback/ExplainReasonCallback;

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {p0}, Lcom/permissionx/guolindev/request/RequestManageExternalStoragePermission;->getExplainScope()Lcom/permissionx/guolindev/request/ExplainScope;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Lcom/permissionx/guolindev/callback/ExplainReasonCallback;->onExplainReason(Lcom/permissionx/guolindev/request/ExplainScope;Ljava/util/List;)V

    :goto_57
    return-void

    .line 54
    :cond_58
    invoke-virtual {p0}, Lcom/permissionx/guolindev/request/RequestManageExternalStoragePermission;->finish()V

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

    .line 59
    iget-object p1, p0, Lcom/permissionx/guolindev/request/RequestManageExternalStoragePermission;->pb:Lcom/permissionx/guolindev/request/PermissionBuilder;

    move-object v0, p0

    check-cast v0, Lcom/permissionx/guolindev/request/ChainTask;

    invoke-virtual {p1, v0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->requestManageExternalStoragePermissionNow(Lcom/permissionx/guolindev/request/ChainTask;)V

    return-void
.end method
