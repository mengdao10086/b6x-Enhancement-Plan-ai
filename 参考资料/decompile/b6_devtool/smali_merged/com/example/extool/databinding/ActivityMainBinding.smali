.class public final Lcom/example/extool/databinding/ActivityMainBinding;
.super Ljava/lang/Object;
.source "ActivityMainBinding.java"

# interfaces
.implements Landroidx/viewbinding/ViewBinding;


# instance fields
.field public final btnSetup:Landroid/widget/Button;

.field private final rootView:Landroidx/constraintlayout/widget/ConstraintLayout;


# direct methods
.method private constructor <init>(Landroidx/constraintlayout/widget/ConstraintLayout;Landroid/widget/Button;)V
    .registers 3

    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    iput-object p1, p0, Lcom/example/extool/databinding/ActivityMainBinding;->rootView:Landroidx/constraintlayout/widget/ConstraintLayout;

    .line 27
    iput-object p2, p0, Lcom/example/extool/databinding/ActivityMainBinding;->btnSetup:Landroid/widget/Button;

    return-void
.end method

.method public static bind(Landroid/view/View;)Lcom/example/extool/databinding/ActivityMainBinding;
    .registers 3

    const v0, 0x7f080062

    .line 58
    invoke-static {p0, v0}, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View;I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    if-eqz v1, :cond_13

    .line 63
    new-instance v0, Lcom/example/extool/databinding/ActivityMainBinding;

    check-cast p0, Landroidx/constraintlayout/widget/ConstraintLayout;

    invoke-direct {v0, p0, v1}, Lcom/example/extool/databinding/ActivityMainBinding;-><init>(Landroidx/constraintlayout/widget/ConstraintLayout;Landroid/widget/Button;)V

    return-object v0

    .line 65
    :cond_13
    invoke-virtual {p0}, Landroid/view/View;->getResources()Landroid/content/res/Resources;

    move-result-object p0

    invoke-virtual {p0, v0}, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;

    move-result-object p0

    .line 66
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "Missing required view with ID: "

    invoke-virtual {v1, p0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static inflate(Landroid/view/LayoutInflater;)Lcom/example/extool/databinding/ActivityMainBinding;
    .registers 3

    const/4 v0, 0x0

    const/4 v1, 0x0

    .line 38
    invoke-static {p0, v0, v1}, Lcom/example/extool/databinding/ActivityMainBinding;->inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/example/extool/databinding/ActivityMainBinding;

    move-result-object p0

    return-object p0
.end method

.method public static inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/example/extool/databinding/ActivityMainBinding;
    .registers 5

    const v0, 0x7f0b001d

    const/4 v1, 0x0

    .line 44
    invoke-virtual {p0, v0, p1, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p0

    if-eqz p2, :cond_d

    .line 46
    invoke-virtual {p1, p0}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 48
    :cond_d
    invoke-static {p0}, Lcom/example/extool/databinding/ActivityMainBinding;->bind(Landroid/view/View;)Lcom/example/extool/databinding/ActivityMainBinding;

    move-result-object p0

    return-object p0
.end method


# virtual methods
.method public bridge synthetic getRoot()Landroid/view/View;
    .registers 2

    .line 18
    invoke-virtual {p0}, Lcom/example/extool/databinding/ActivityMainBinding;->getRoot()Landroidx/constraintlayout/widget/ConstraintLayout;

    move-result-object v0

    return-object v0
.end method

.method public getRoot()Landroidx/constraintlayout/widget/ConstraintLayout;
    .registers 2

    .line 33
    iget-object v0, p0, Lcom/example/extool/databinding/ActivityMainBinding;->rootView:Landroidx/constraintlayout/widget/ConstraintLayout;

    return-object v0
.end method
