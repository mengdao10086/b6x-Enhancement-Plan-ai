.class public final Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;
.super Ljava/lang/Object;
.source "PermissionxDefaultDialogLayoutBinding.java"

# interfaces
.implements Landroidx/viewbinding/ViewBinding;


# instance fields
.field public final messageText:Landroid/widget/TextView;

.field public final negativeBtn:Landroid/widget/Button;

.field public final negativeLayout:Landroid/widget/LinearLayout;

.field public final permissionsLayout:Landroid/widget/LinearLayout;

.field public final positiveBtn:Landroid/widget/Button;

.field public final positiveLayout:Landroid/widget/LinearLayout;

.field private final rootView:Landroid/widget/LinearLayout;


# direct methods
.method private constructor <init>(Landroid/widget/LinearLayout;Landroid/widget/TextView;Landroid/widget/Button;Landroid/widget/LinearLayout;Landroid/widget/LinearLayout;Landroid/widget/Button;Landroid/widget/LinearLayout;)V
    .registers 8

    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 45
    iput-object p1, p0, Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;->rootView:Landroid/widget/LinearLayout;

    .line 46
    iput-object p2, p0, Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;->messageText:Landroid/widget/TextView;

    .line 47
    iput-object p3, p0, Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;->negativeBtn:Landroid/widget/Button;

    .line 48
    iput-object p4, p0, Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;->negativeLayout:Landroid/widget/LinearLayout;

    .line 49
    iput-object p5, p0, Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;->permissionsLayout:Landroid/widget/LinearLayout;

    .line 50
    iput-object p6, p0, Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;->positiveBtn:Landroid/widget/Button;

    .line 51
    iput-object p7, p0, Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;->positiveLayout:Landroid/widget/LinearLayout;

    return-void
.end method

.method public static bind(Landroid/view/View;)Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;
    .registers 11

    .line 81
    sget v0, Lcom/permissionx/guolindev/R$id;->messageText:I

    .line 82
    invoke-static {p0, v0}, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View;I)Landroid/view/View;

    move-result-object v1

    move-object v4, v1

    check-cast v4, Landroid/widget/TextView;

    if-eqz v4, :cond_4c

    .line 87
    sget v0, Lcom/permissionx/guolindev/R$id;->negativeBtn:I

    .line 88
    invoke-static {p0, v0}, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View;I)Landroid/view/View;

    move-result-object v1

    move-object v5, v1

    check-cast v5, Landroid/widget/Button;

    if-eqz v5, :cond_4c

    .line 93
    sget v0, Lcom/permissionx/guolindev/R$id;->negativeLayout:I

    .line 94
    invoke-static {p0, v0}, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View;I)Landroid/view/View;

    move-result-object v1

    move-object v6, v1

    check-cast v6, Landroid/widget/LinearLayout;

    if-eqz v6, :cond_4c

    .line 99
    sget v0, Lcom/permissionx/guolindev/R$id;->permissionsLayout:I

    .line 100
    invoke-static {p0, v0}, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View;I)Landroid/view/View;

    move-result-object v1

    move-object v7, v1

    check-cast v7, Landroid/widget/LinearLayout;

    if-eqz v7, :cond_4c

    .line 105
    sget v0, Lcom/permissionx/guolindev/R$id;->positiveBtn:I

    .line 106
    invoke-static {p0, v0}, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View;I)Landroid/view/View;

    move-result-object v1

    move-object v8, v1

    check-cast v8, Landroid/widget/Button;

    if-eqz v8, :cond_4c

    .line 111
    sget v0, Lcom/permissionx/guolindev/R$id;->positiveLayout:I

    .line 112
    invoke-static {p0, v0}, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View;I)Landroid/view/View;

    move-result-object v1

    move-object v9, v1

    check-cast v9, Landroid/widget/LinearLayout;

    if-eqz v9, :cond_4c

    .line 117
    new-instance v0, Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;

    move-object v3, p0

    check-cast v3, Landroid/widget/LinearLayout;

    move-object v2, v0

    invoke-direct/range {v2 .. v9}, Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;-><init>(Landroid/widget/LinearLayout;Landroid/widget/TextView;Landroid/widget/Button;Landroid/widget/LinearLayout;Landroid/widget/LinearLayout;Landroid/widget/Button;Landroid/widget/LinearLayout;)V

    return-object v0

    .line 120
    :cond_4c
    invoke-virtual {p0}, Landroid/view/View;->getResources()Landroid/content/res/Resources;

    move-result-object p0

    invoke-virtual {p0, v0}, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;

    move-result-object p0

    .line 121
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "Missing required view with ID: "

    invoke-virtual {v1, p0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static inflate(Landroid/view/LayoutInflater;)Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;
    .registers 3

    const/4 v0, 0x0

    const/4 v1, 0x0

    .line 62
    invoke-static {p0, v0, v1}, Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;->inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;

    move-result-object p0

    return-object p0
.end method

.method public static inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;
    .registers 5

    .line 68
    sget v0, Lcom/permissionx/guolindev/R$layout;->permissionx_default_dialog_layout:I

    const/4 v1, 0x0

    invoke-virtual {p0, v0, p1, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p0

    if-eqz p2, :cond_c

    .line 70
    invoke-virtual {p1, p0}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 72
    :cond_c
    invoke-static {p0}, Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;->bind(Landroid/view/View;)Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;

    move-result-object p0

    return-object p0
.end method


# virtual methods
.method public bridge synthetic getRoot()Landroid/view/View;
    .registers 2

    .line 19
    invoke-virtual {p0}, Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;->getRoot()Landroid/widget/LinearLayout;

    move-result-object v0

    return-object v0
.end method

.method public getRoot()Landroid/widget/LinearLayout;
    .registers 2

    .line 57
    iget-object v0, p0, Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;->rootView:Landroid/widget/LinearLayout;

    return-object v0
.end method
