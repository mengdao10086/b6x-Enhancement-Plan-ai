.class public final synthetic Lcom/permissionx/guolindev/request/PermissionBuilder$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field public final synthetic f$0:Lcom/permissionx/guolindev/dialog/RationaleDialogFragment;

.field public final synthetic f$1:Z

.field public final synthetic f$2:Lcom/permissionx/guolindev/request/ChainTask;

.field public final synthetic f$3:Ljava/util/List;

.field public final synthetic f$4:Lcom/permissionx/guolindev/request/PermissionBuilder;


# direct methods
.method public synthetic constructor <init>(Lcom/permissionx/guolindev/dialog/RationaleDialogFragment;ZLcom/permissionx/guolindev/request/ChainTask;Ljava/util/List;Lcom/permissionx/guolindev/request/PermissionBuilder;)V
    .registers 6

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/permissionx/guolindev/request/PermissionBuilder$$ExternalSyntheticLambda0;->f$0:Lcom/permissionx/guolindev/dialog/RationaleDialogFragment;

    iput-boolean p2, p0, Lcom/permissionx/guolindev/request/PermissionBuilder$$ExternalSyntheticLambda0;->f$1:Z

    iput-object p3, p0, Lcom/permissionx/guolindev/request/PermissionBuilder$$ExternalSyntheticLambda0;->f$2:Lcom/permissionx/guolindev/request/ChainTask;

    iput-object p4, p0, Lcom/permissionx/guolindev/request/PermissionBuilder$$ExternalSyntheticLambda0;->f$3:Ljava/util/List;

    iput-object p5, p0, Lcom/permissionx/guolindev/request/PermissionBuilder$$ExternalSyntheticLambda0;->f$4:Lcom/permissionx/guolindev/request/PermissionBuilder;

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .registers 8

    iget-object v0, p0, Lcom/permissionx/guolindev/request/PermissionBuilder$$ExternalSyntheticLambda0;->f$0:Lcom/permissionx/guolindev/dialog/RationaleDialogFragment;

    iget-boolean v1, p0, Lcom/permissionx/guolindev/request/PermissionBuilder$$ExternalSyntheticLambda0;->f$1:Z

    iget-object v2, p0, Lcom/permissionx/guolindev/request/PermissionBuilder$$ExternalSyntheticLambda0;->f$2:Lcom/permissionx/guolindev/request/ChainTask;

    iget-object v3, p0, Lcom/permissionx/guolindev/request/PermissionBuilder$$ExternalSyntheticLambda0;->f$3:Ljava/util/List;

    iget-object v4, p0, Lcom/permissionx/guolindev/request/PermissionBuilder$$ExternalSyntheticLambda0;->f$4:Lcom/permissionx/guolindev/request/PermissionBuilder;

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/permissionx/guolindev/request/PermissionBuilder;->$r8$lambda$Lryy70HiIObb0uxPBzOJHCEctvI(Lcom/permissionx/guolindev/dialog/RationaleDialogFragment;ZLcom/permissionx/guolindev/request/ChainTask;Ljava/util/List;Lcom/permissionx/guolindev/request/PermissionBuilder;Landroid/view/View;)V

    return-void
.end method
