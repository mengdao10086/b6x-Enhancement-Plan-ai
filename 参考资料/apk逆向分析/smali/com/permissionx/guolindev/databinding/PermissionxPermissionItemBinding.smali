.class public final Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;
.super Ljava/lang/Object;
.source "PermissionxPermissionItemBinding.java"

# interfaces
.implements Landroidx/viewbinding/ViewBinding;


# instance fields
.field public final permissionIcon:Landroid/widget/ImageView;

.field public final permissionText:Landroid/widget/TextView;

.field private final rootView:Landroid/widget/LinearLayout;


# direct methods
.method private constructor <init>(Landroid/widget/LinearLayout;Landroid/widget/ImageView;Landroid/widget/TextView;)V
    .registers 4

    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    iput-object p1, p0, Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;->rootView:Landroid/widget/LinearLayout;

    .line 32
    iput-object p2, p0, Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;->permissionIcon:Landroid/widget/ImageView;

    .line 33
    iput-object p3, p0, Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;->permissionText:Landroid/widget/TextView;

    return-void
.end method

.method public static bind(Landroid/view/View;)Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;
    .registers 4

    .line 63
    sget v0, Lcom/permissionx/guolindev/R$id;->permissionIcon:I

    .line 64
    invoke-static {p0, v0}, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View;I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    if-eqz v1, :cond_1c

    .line 69
    sget v0, Lcom/permissionx/guolindev/R$id;->permissionText:I

    .line 70
    invoke-static {p0, v0}, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View;I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    if-eqz v2, :cond_1c

    .line 75
    new-instance v0, Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;

    check-cast p0, Landroid/widget/LinearLayout;

    invoke-direct {v0, p0, v1, v2}, Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;-><init>(Landroid/widget/LinearLayout;Landroid/widget/ImageView;Landroid/widget/TextView;)V

    return-object v0

    .line 78
    :cond_1c
    invoke-virtual {p0}, Landroid/view/View;->getResources()Landroid/content/res/Resources;

    move-result-object p0

    invoke-virtual {p0, v0}, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;

    move-result-object p0

    .line 79
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "Missing required view with ID: "

    invoke-virtual {v1, p0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static inflate(Landroid/view/LayoutInflater;)Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;
    .registers 3

    const/4 v0, 0x0

    const/4 v1, 0x0

    .line 44
    invoke-static {p0, v0, v1}, Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;->inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;

    move-result-object p0

    return-object p0
.end method

.method public static inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;
    .registers 5

    .line 50
    sget v0, Lcom/permissionx/guolindev/R$layout;->permissionx_permission_item:I

    const/4 v1, 0x0

    invoke-virtual {p0, v0, p1, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p0

    if-eqz p2, :cond_c

    .line 52
    invoke-virtual {p1, p0}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 54
    :cond_c
    invoke-static {p0}, Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;->bind(Landroid/view/View;)Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;

    move-result-object p0

    return-object p0
.end method


# virtual methods
.method public bridge synthetic getRoot()Landroid/view/View;
    .registers 2

    .line 19
    invoke-virtual {p0}, Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;->getRoot()Landroid/widget/LinearLayout;

    move-result-object v0

    return-object v0
.end method

.method public getRoot()Landroid/widget/LinearLayout;
    .registers 2

    .line 39
    iget-object v0, p0, Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;->rootView:Landroid/widget/LinearLayout;

    return-object v0
.end method
