.class public final Lcom/blankj/utilcode/util/SnackbarUtils;
.super Ljava/lang/Object;
.source "SnackbarUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/blankj/utilcode/util/SnackbarUtils$Duration;
    }
.end annotation


# static fields
.field private static final COLOR_DEFAULT:I = -0x1000001

.field private static final COLOR_ERROR:I = -0x10000

.field private static final COLOR_MESSAGE:I = -0x1

.field private static final COLOR_SUCCESS:I = -0xd44a00

.field private static final COLOR_WARNING:I = -0x3f00

.field public static final LENGTH_INDEFINITE:I = -0x2

.field public static final LENGTH_LONG:I = 0x0

.field public static final LENGTH_SHORT:I = -0x1

.field private static sWeakSnackbar:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference<",
            "Lcom/google/android/material/snackbar/Snackbar;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private actionListener:Landroid/view/View$OnClickListener;

.field private actionText:Ljava/lang/CharSequence;

.field private actionTextColor:I

.field private bgColor:I

.field private bgResource:I

.field private bottomMargin:I

.field private duration:I

.field private message:Ljava/lang/CharSequence;

.field private messageColor:I

.field private view:Landroid/view/View;


# direct methods
.method private constructor <init>(Landroid/view/View;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-direct {p0}, Lcom/blankj/utilcode/util/SnackbarUtils;->setDefault()V

    iput-object p1, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->view:Landroid/view/View;

    return-void
.end method

.method public static addView(ILandroid/view/ViewGroup$LayoutParams;)V
    .registers 5

    invoke-static {}, Lcom/blankj/utilcode/util/SnackbarUtils;->getView()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_1e

    const/4 v1, 0x0

    invoke-virtual {v0, v1, v1, v1, v1}, Landroid/view/View;->setPadding(IIII)V

    move-object v1, v0

    check-cast v1, Lcom/google/android/material/snackbar/Snackbar$SnackbarLayout;

    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const/4 v2, 0x0

    invoke-virtual {v0, p0, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p0

    const/4 v0, -0x1

    invoke-virtual {v1, p0, v0, p1}, Lcom/google/android/material/snackbar/Snackbar$SnackbarLayout;->addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    :cond_1e
    return-void
.end method

.method public static addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    .registers 4

    invoke-static {}, Lcom/blankj/utilcode/util/SnackbarUtils;->getView()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_f

    const/4 v1, 0x0

    invoke-virtual {v0, v1, v1, v1, v1}, Landroid/view/View;->setPadding(IIII)V

    check-cast v0, Lcom/google/android/material/snackbar/Snackbar$SnackbarLayout;

    invoke-virtual {v0, p0, p1}, Lcom/google/android/material/snackbar/Snackbar$SnackbarLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    :cond_f
    return-void
.end method

.method public static dismiss()V
    .registers 1

    sget-object v0, Lcom/blankj/utilcode/util/SnackbarUtils;->sWeakSnackbar:Ljava/lang/ref/WeakReference;

    if-eqz v0, :cond_18

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_18

    sget-object v0, Lcom/blankj/utilcode/util/SnackbarUtils;->sWeakSnackbar:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/material/snackbar/Snackbar;

    invoke-virtual {v0}, Lcom/google/android/material/snackbar/Snackbar;->dismiss()V

    const/4 v0, 0x0

    sput-object v0, Lcom/blankj/utilcode/util/SnackbarUtils;->sWeakSnackbar:Ljava/lang/ref/WeakReference;

    :cond_18
    return-void
.end method

.method private static findSuitableParentCopyFromSnackbar(Landroid/view/View;)Landroid/view/ViewGroup;
    .registers 4

    const/4 v0, 0x0

    move-object v1, v0

    :cond_2
    instance-of v2, p0, Landroidx/coordinatorlayout/widget/CoordinatorLayout;

    if-eqz v2, :cond_9

    check-cast p0, Landroid/view/ViewGroup;

    return-object p0

    :cond_9
    instance-of v2, p0, Landroid/widget/FrameLayout;

    if-eqz v2, :cond_1c

    invoke-virtual {p0}, Landroid/view/View;->getId()I

    move-result v1

    const v2, 0x1020002

    if-ne v1, v2, :cond_19

    check-cast p0, Landroid/view/ViewGroup;

    return-object p0

    :cond_19
    move-object v1, p0

    check-cast v1, Landroid/view/ViewGroup;

    :cond_1c
    if-eqz p0, :cond_2a

    invoke-virtual {p0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object p0

    instance-of v2, p0, Landroid/view/View;

    if-eqz v2, :cond_29

    check-cast p0, Landroid/view/View;

    goto :goto_2a

    :cond_29
    move-object p0, v0

    :cond_2a
    :goto_2a
    if-nez p0, :cond_2

    return-object v1
.end method

.method public static getView()Landroid/view/View;
    .registers 1

    sget-object v0, Lcom/blankj/utilcode/util/SnackbarUtils;->sWeakSnackbar:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/material/snackbar/Snackbar;

    if-nez v0, :cond_c

    const/4 v0, 0x0

    return-object v0

    :cond_c
    invoke-virtual {v0}, Lcom/google/android/material/snackbar/Snackbar;->getView()Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method private setDefault()V
    .registers 4

    const-string v0, ""

    iput-object v0, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->message:Ljava/lang/CharSequence;

    const v1, -0x1000001

    iput v1, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->messageColor:I

    iput v1, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->bgColor:I

    const/4 v2, -0x1

    iput v2, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->bgResource:I

    iput v2, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->duration:I

    iput-object v0, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->actionText:Ljava/lang/CharSequence;

    iput v1, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->actionTextColor:I

    const/4 v0, 0x0

    iput v0, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->bottomMargin:I

    return-void
.end method

.method public static with(Landroid/view/View;)Lcom/blankj/utilcode/util/SnackbarUtils;
    .registers 2

    new-instance v0, Lcom/blankj/utilcode/util/SnackbarUtils;

    invoke-direct {v0, p0}, Lcom/blankj/utilcode/util/SnackbarUtils;-><init>(Landroid/view/View;)V

    return-object v0
.end method


# virtual methods
.method public setAction(Ljava/lang/CharSequence;ILandroid/view/View$OnClickListener;)Lcom/blankj/utilcode/util/SnackbarUtils;
    .registers 4

    iput-object p1, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->actionText:Ljava/lang/CharSequence;

    iput p2, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->actionTextColor:I

    iput-object p3, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->actionListener:Landroid/view/View$OnClickListener;

    return-object p0
.end method

.method public setAction(Ljava/lang/CharSequence;Landroid/view/View$OnClickListener;)Lcom/blankj/utilcode/util/SnackbarUtils;
    .registers 4

    const v0, -0x1000001

    invoke-virtual {p0, p1, v0, p2}, Lcom/blankj/utilcode/util/SnackbarUtils;->setAction(Ljava/lang/CharSequence;ILandroid/view/View$OnClickListener;)Lcom/blankj/utilcode/util/SnackbarUtils;

    move-result-object p1

    return-object p1
.end method

.method public setBgColor(I)Lcom/blankj/utilcode/util/SnackbarUtils;
    .registers 2

    iput p1, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->bgColor:I

    return-object p0
.end method

.method public setBgResource(I)Lcom/blankj/utilcode/util/SnackbarUtils;
    .registers 2

    iput p1, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->bgResource:I

    return-object p0
.end method

.method public setBottomMargin(I)Lcom/blankj/utilcode/util/SnackbarUtils;
    .registers 2

    iput p1, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->bottomMargin:I

    return-object p0
.end method

.method public setDuration(I)Lcom/blankj/utilcode/util/SnackbarUtils;
    .registers 2

    iput p1, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->duration:I

    return-object p0
.end method

.method public setMessage(Ljava/lang/CharSequence;)Lcom/blankj/utilcode/util/SnackbarUtils;
    .registers 2

    iput-object p1, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->message:Ljava/lang/CharSequence;

    return-object p0
.end method

.method public setMessageColor(I)Lcom/blankj/utilcode/util/SnackbarUtils;
    .registers 2

    iput p1, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->messageColor:I

    return-object p0
.end method

.method public show()Lcom/google/android/material/snackbar/Snackbar;
    .registers 2

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/blankj/utilcode/util/SnackbarUtils;->show(Z)Lcom/google/android/material/snackbar/Snackbar;

    move-result-object v0

    return-object v0
.end method

.method public show(Z)Lcom/google/android/material/snackbar/Snackbar;
    .registers 11

    iget-object v0, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->view:Landroid/view/View;

    if-nez v0, :cond_6

    const/4 p1, 0x0

    return-object p1

    :cond_6
    const/high16 v1, 0x43340000    # 180.0f

    const/4 v2, -0x1

    if-eqz p1, :cond_2f

    invoke-static {v0}, Lcom/blankj/utilcode/util/SnackbarUtils;->findSuitableParentCopyFromSnackbar(Landroid/view/View;)Landroid/view/ViewGroup;

    move-result-object v3

    const-string v4, "topSnackBarCoordinatorLayout"

    invoke-virtual {v3, v4}, Landroid/view/ViewGroup;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;

    move-result-object v5

    if-nez v5, :cond_2e

    new-instance v5, Landroidx/coordinatorlayout/widget/CoordinatorLayout;

    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-direct {v5, v0}, Landroidx/coordinatorlayout/widget/CoordinatorLayout;-><init>(Landroid/content/Context;)V

    invoke-virtual {v5, v4}, Landroidx/coordinatorlayout/widget/CoordinatorLayout;->setTag(Ljava/lang/Object;)V

    invoke-virtual {v5, v1}, Landroidx/coordinatorlayout/widget/CoordinatorLayout;->setRotation(F)V

    const/high16 v0, 0x42c80000    # 100.0f

    invoke-virtual {v5, v0}, Landroidx/coordinatorlayout/widget/CoordinatorLayout;->setElevation(F)V

    invoke-virtual {v3, v5, v2, v2}, Landroid/view/ViewGroup;->addView(Landroid/view/View;II)V

    :cond_2e
    move-object v0, v5

    :cond_2f
    iget v3, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->messageColor:I

    const/4 v4, 0x0

    const v5, -0x1000001

    if-eq v3, v5, :cond_5c

    new-instance v3, Landroid/text/SpannableString;

    iget-object v6, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->message:Ljava/lang/CharSequence;

    invoke-direct {v3, v6}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    new-instance v6, Landroid/text/style/ForegroundColorSpan;

    iget v7, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->messageColor:I

    invoke-direct {v6, v7}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    invoke-virtual {v3}, Landroid/text/SpannableString;->length()I

    move-result v7

    const/16 v8, 0x21

    invoke-virtual {v3, v6, v4, v7, v8}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    new-instance v6, Ljava/lang/ref/WeakReference;

    iget v7, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->duration:I

    invoke-static {v0, v3, v7}, Lcom/google/android/material/snackbar/Snackbar;->make(Landroid/view/View;Ljava/lang/CharSequence;I)Lcom/google/android/material/snackbar/Snackbar;

    move-result-object v0

    invoke-direct {v6, v0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    sput-object v6, Lcom/blankj/utilcode/util/SnackbarUtils;->sWeakSnackbar:Ljava/lang/ref/WeakReference;

    goto :goto_6b

    :cond_5c
    new-instance v3, Ljava/lang/ref/WeakReference;

    iget-object v6, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->message:Ljava/lang/CharSequence;

    iget v7, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->duration:I

    invoke-static {v0, v6, v7}, Lcom/google/android/material/snackbar/Snackbar;->make(Landroid/view/View;Ljava/lang/CharSequence;I)Lcom/google/android/material/snackbar/Snackbar;

    move-result-object v0

    invoke-direct {v3, v0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    sput-object v3, Lcom/blankj/utilcode/util/SnackbarUtils;->sWeakSnackbar:Ljava/lang/ref/WeakReference;

    :goto_6b
    sget-object v0, Lcom/blankj/utilcode/util/SnackbarUtils;->sWeakSnackbar:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/material/snackbar/Snackbar;

    invoke-virtual {v0}, Lcom/google/android/material/snackbar/Snackbar;->getView()Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/google/android/material/snackbar/Snackbar$SnackbarLayout;

    if-eqz p1, :cond_8b

    :goto_7b
    invoke-virtual {v3}, Lcom/google/android/material/snackbar/Snackbar$SnackbarLayout;->getChildCount()I

    move-result p1

    if-ge v4, p1, :cond_8b

    invoke-virtual {v3, v4}, Lcom/google/android/material/snackbar/Snackbar$SnackbarLayout;->getChildAt(I)Landroid/view/View;

    move-result-object p1

    invoke-virtual {p1, v1}, Landroid/view/View;->setRotation(F)V

    add-int/lit8 v4, v4, 0x1

    goto :goto_7b

    :cond_8b
    iget p1, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->bgResource:I

    if-eq p1, v2, :cond_93

    invoke-virtual {v3, p1}, Lcom/google/android/material/snackbar/Snackbar$SnackbarLayout;->setBackgroundResource(I)V

    goto :goto_9a

    :cond_93
    iget p1, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->bgColor:I

    if-eq p1, v5, :cond_9a

    invoke-virtual {v3, p1}, Lcom/google/android/material/snackbar/Snackbar$SnackbarLayout;->setBackgroundColor(I)V

    :cond_9a
    :goto_9a
    iget p1, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->bottomMargin:I

    if-eqz p1, :cond_a8

    invoke-virtual {v3}, Lcom/google/android/material/snackbar/Snackbar$SnackbarLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object p1

    check-cast p1, Landroid/view/ViewGroup$MarginLayoutParams;

    iget v1, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->bottomMargin:I

    iput v1, p1, Landroid/view/ViewGroup$MarginLayoutParams;->bottomMargin:I

    :cond_a8
    iget-object p1, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->actionText:Ljava/lang/CharSequence;

    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result p1

    if-lez p1, :cond_c2

    iget-object p1, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->actionListener:Landroid/view/View$OnClickListener;

    if-eqz p1, :cond_c2

    iget p1, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->actionTextColor:I

    if-eq p1, v5, :cond_bb

    invoke-virtual {v0, p1}, Lcom/google/android/material/snackbar/Snackbar;->setActionTextColor(I)Lcom/google/android/material/snackbar/Snackbar;

    :cond_bb
    iget-object p1, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->actionText:Ljava/lang/CharSequence;

    iget-object v1, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->actionListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, p1, v1}, Lcom/google/android/material/snackbar/Snackbar;->setAction(Ljava/lang/CharSequence;Landroid/view/View$OnClickListener;)Lcom/google/android/material/snackbar/Snackbar;

    :cond_c2
    invoke-virtual {v0}, Lcom/google/android/material/snackbar/Snackbar;->show()V

    return-object v0
.end method

.method public showError()V
    .registers 2

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/blankj/utilcode/util/SnackbarUtils;->showError(Z)V

    return-void
.end method

.method public showError(Z)V
    .registers 3

    const/high16 v0, -0x10000

    iput v0, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->bgColor:I

    const/4 v0, -0x1

    iput v0, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->messageColor:I

    iput v0, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->actionTextColor:I

    invoke-virtual {p0, p1}, Lcom/blankj/utilcode/util/SnackbarUtils;->show(Z)Lcom/google/android/material/snackbar/Snackbar;

    return-void
.end method

.method public showSuccess()V
    .registers 2

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/blankj/utilcode/util/SnackbarUtils;->showSuccess(Z)V

    return-void
.end method

.method public showSuccess(Z)V
    .registers 3

    const v0, -0xd44a00

    iput v0, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->bgColor:I

    const/4 v0, -0x1

    iput v0, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->messageColor:I

    iput v0, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->actionTextColor:I

    invoke-virtual {p0, p1}, Lcom/blankj/utilcode/util/SnackbarUtils;->show(Z)Lcom/google/android/material/snackbar/Snackbar;

    return-void
.end method

.method public showWarning()V
    .registers 2

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/blankj/utilcode/util/SnackbarUtils;->showWarning(Z)V

    return-void
.end method

.method public showWarning(Z)V
    .registers 3

    const/16 v0, -0x3f00

    iput v0, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->bgColor:I

    const/4 v0, -0x1

    iput v0, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->messageColor:I

    iput v0, p0, Lcom/blankj/utilcode/util/SnackbarUtils;->actionTextColor:I

    invoke-virtual {p0, p1}, Lcom/blankj/utilcode/util/SnackbarUtils;->show(Z)Lcom/google/android/material/snackbar/Snackbar;

    return-void
.end method
