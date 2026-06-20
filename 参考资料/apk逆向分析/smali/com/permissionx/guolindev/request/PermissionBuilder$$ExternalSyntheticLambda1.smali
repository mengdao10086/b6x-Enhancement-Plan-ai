.class public final synthetic Lcom/permissionx/guolindev/request/PermissionBuilder$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field public final synthetic f$0:Lcom/permissionx/guolindev/dialog/RationaleDialogFragment;

.field public final synthetic f$1:Lcom/permissionx/guolindev/request/ChainTask;


# direct methods
.method public synthetic constructor <init>(Lcom/permissionx/guolindev/dialog/RationaleDialogFragment;Lcom/permissionx/guolindev/request/ChainTask;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/permissionx/guolindev/request/PermissionBuilder$$ExternalSyntheticLambda1;->f$0:Lcom/permissionx/guolindev/dialog/RationaleDialogFragment;

    iput-object p2, p0, Lcom/permissionx/guolindev/request/PermissionBuilder$$ExternalSyntheticLambda1;->f$1:Lcom/permissionx/guolindev/request/ChainTask;

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .registers 4

    iget-object v0, p0, Lcom/permissionx/guolindev/request/PermissionBuilder$$ExternalSyntheticLambda1;->f$0:Lcom/permissionx/guolindev/dialog/RationaleDialogFragment;

    iget-object v1, p0, Lcom/permissionx/guolindev/request/PermissionBuilder$$ExternalSyntheticLambda1;->f$1:Lcom/permissionx/guolindev/request/ChainTask;

    invoke-static {v0, v1, p1}, Lcom/permissionx/guolindev/request/PermissionBuilder;->$r8$lambda$O9Hp_-9YuEjwy3MT2jVR8bjTDnE(Lcom/permissionx/guolindev/dialog/RationaleDialogFragment;Lcom/permissionx/guolindev/request/ChainTask;Landroid/view/View;)V

    return-void
.end method
