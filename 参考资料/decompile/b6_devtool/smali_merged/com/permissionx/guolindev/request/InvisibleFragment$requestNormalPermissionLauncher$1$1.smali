.class final Lcom/permissionx/guolindev/request/InvisibleFragment$requestNormalPermissionLauncher$1$1;
.super Lkotlin/jvm/internal/Lambda;
.source "InvisibleFragment.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function0;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/permissionx/guolindev/request/InvisibleFragment;->requestNormalPermissionLauncher$lambda-0(Lcom/permissionx/guolindev/request/InvisibleFragment;Ljava/util/Map;)V
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
.field final synthetic $grantResults:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;


# direct methods
.method constructor <init>(Lcom/permissionx/guolindev/request/InvisibleFragment;Ljava/util/Map;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/permissionx/guolindev/request/InvisibleFragment;",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/Boolean;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$requestNormalPermissionLauncher$1$1;->this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;

    iput-object p2, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$requestNormalPermissionLauncher$1$1;->$grantResults:Ljava/util/Map;

    const/4 p1, 0x0

    invoke-direct {p0, p1}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke()Ljava/lang/Object;
    .registers 2

    .line 59
    invoke-virtual {p0}, Lcom/permissionx/guolindev/request/InvisibleFragment$requestNormalPermissionLauncher$1$1;->invoke()V

    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object v0
.end method

.method public final invoke()V
    .registers 4

    .line 60
    iget-object v0, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$requestNormalPermissionLauncher$1$1;->this$0:Lcom/permissionx/guolindev/request/InvisibleFragment;

    iget-object v1, p0, Lcom/permissionx/guolindev/request/InvisibleFragment$requestNormalPermissionLauncher$1$1;->$grantResults:Ljava/util/Map;

    const-string v2, "grantResults"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    # invokes: Lcom/permissionx/guolindev/request/InvisibleFragment;->onRequestNormalPermissionsResult(Ljava/util/Map;)V
    invoke-static {v0, v1}, Lcom/permissionx/guolindev/request/InvisibleFragment;->access$onRequestNormalPermissionsResult(Lcom/permissionx/guolindev/request/InvisibleFragment;Ljava/util/Map;)V

    return-void
.end method
