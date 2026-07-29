.class Landroidx/core/view/ViewCompat$Api30Impl;
.super Ljava/lang/Object;
.source "ViewCompat.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/core/view/ViewCompat;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "Api30Impl"
.end annotation


# direct methods
.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static getStateDescription(Landroid/view/View;)Ljava/lang/CharSequence;
    .registers 1

    invoke-virtual {p0}, Landroid/view/View;->getStateDescription()Ljava/lang/CharSequence;

    move-result-object p0

    return-object p0
.end method

.method public static getWindowInsetsController(Landroid/view/View;)Landroidx/core/view/WindowInsetsControllerCompat;
    .registers 1

    invoke-virtual {p0}, Landroid/view/View;->getWindowInsetsController()Landroid/view/WindowInsetsController;

    move-result-object p0

    if-eqz p0, :cond_b

    invoke-static {p0}, Landroidx/core/view/WindowInsetsControllerCompat;->toWindowInsetsControllerCompat(Landroid/view/WindowInsetsController;)Landroidx/core/view/WindowInsetsControllerCompat;

    move-result-object p0

    goto :goto_c

    :cond_b
    const/4 p0, 0x0

    :goto_c
    return-object p0
.end method

.method static setStateDescription(Landroid/view/View;Ljava/lang/CharSequence;)V
    .registers 2

    invoke-virtual {p0, p1}, Landroid/view/View;->setStateDescription(Ljava/lang/CharSequence;)V

    return-void
.end method
