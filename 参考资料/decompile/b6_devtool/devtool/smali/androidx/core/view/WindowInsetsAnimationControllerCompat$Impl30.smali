.class Landroidx/core/view/WindowInsetsAnimationControllerCompat$Impl30;
.super Landroidx/core/view/WindowInsetsAnimationControllerCompat$Impl;
.source "WindowInsetsAnimationControllerCompat.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/core/view/WindowInsetsAnimationControllerCompat;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "Impl30"
.end annotation


# instance fields
.field private final mController:Landroid/view/WindowInsetsAnimationController;


# direct methods
.method constructor <init>(Landroid/view/WindowInsetsAnimationController;)V
    .registers 2

    invoke-direct {p0}, Landroidx/core/view/WindowInsetsAnimationControllerCompat$Impl;-><init>()V

    iput-object p1, p0, Landroidx/core/view/WindowInsetsAnimationControllerCompat$Impl30;->mController:Landroid/view/WindowInsetsAnimationController;

    return-void
.end method


# virtual methods
.method finish(Z)V
    .registers 3

    iget-object v0, p0, Landroidx/core/view/WindowInsetsAnimationControllerCompat$Impl30;->mController:Landroid/view/WindowInsetsAnimationController;

    invoke-interface {v0, p1}, Landroid/view/WindowInsetsAnimationController;->finish(Z)V

    return-void
.end method

.method public getCurrentAlpha()F
    .registers 2

    iget-object v0, p0, Landroidx/core/view/WindowInsetsAnimationControllerCompat$Impl30;->mController:Landroid/view/WindowInsetsAnimationController;

    invoke-interface {v0}, Landroid/view/WindowInsetsAnimationController;->getCurrentAlpha()F

    move-result v0

    return v0
.end method

.method public getCurrentFraction()F
    .registers 2

    iget-object v0, p0, Landroidx/core/view/WindowInsetsAnimationControllerCompat$Impl30;->mController:Landroid/view/WindowInsetsAnimationController;

    invoke-interface {v0}, Landroid/view/WindowInsetsAnimationController;->getCurrentFraction()F

    move-result v0

    return v0
.end method

.method public getCurrentInsets()Landroidx/core/graphics/Insets;
    .registers 2

    iget-object v0, p0, Landroidx/core/view/WindowInsetsAnimationControllerCompat$Impl30;->mController:Landroid/view/WindowInsetsAnimationController;

    invoke-interface {v0}, Landroid/view/WindowInsetsAnimationController;->getCurrentInsets()Landroid/graphics/Insets;

    move-result-object v0

    invoke-static {v0}, Landroidx/core/graphics/Insets;->toCompatInsets(Landroid/graphics/Insets;)Landroidx/core/graphics/Insets;

    move-result-object v0

    return-object v0
.end method

.method public getHiddenStateInsets()Landroidx/core/graphics/Insets;
    .registers 2

    iget-object v0, p0, Landroidx/core/view/WindowInsetsAnimationControllerCompat$Impl30;->mController:Landroid/view/WindowInsetsAnimationController;

    invoke-interface {v0}, Landroid/view/WindowInsetsAnimationController;->getHiddenStateInsets()Landroid/graphics/Insets;

    move-result-object v0

    invoke-static {v0}, Landroidx/core/graphics/Insets;->toCompatInsets(Landroid/graphics/Insets;)Landroidx/core/graphics/Insets;

    move-result-object v0

    return-object v0
.end method

.method public getShownStateInsets()Landroidx/core/graphics/Insets;
    .registers 2

    iget-object v0, p0, Landroidx/core/view/WindowInsetsAnimationControllerCompat$Impl30;->mController:Landroid/view/WindowInsetsAnimationController;

    invoke-interface {v0}, Landroid/view/WindowInsetsAnimationController;->getShownStateInsets()Landroid/graphics/Insets;

    move-result-object v0

    invoke-static {v0}, Landroidx/core/graphics/Insets;->toCompatInsets(Landroid/graphics/Insets;)Landroidx/core/graphics/Insets;

    move-result-object v0

    return-object v0
.end method

.method public getTypes()I
    .registers 2

    iget-object v0, p0, Landroidx/core/view/WindowInsetsAnimationControllerCompat$Impl30;->mController:Landroid/view/WindowInsetsAnimationController;

    invoke-interface {v0}, Landroid/view/WindowInsetsAnimationController;->getTypes()I

    move-result v0

    return v0
.end method

.method isCancelled()Z
    .registers 2

    iget-object v0, p0, Landroidx/core/view/WindowInsetsAnimationControllerCompat$Impl30;->mController:Landroid/view/WindowInsetsAnimationController;

    invoke-interface {v0}, Landroid/view/WindowInsetsAnimationController;->isCancelled()Z

    move-result v0

    return v0
.end method

.method isFinished()Z
    .registers 2

    iget-object v0, p0, Landroidx/core/view/WindowInsetsAnimationControllerCompat$Impl30;->mController:Landroid/view/WindowInsetsAnimationController;

    invoke-interface {v0}, Landroid/view/WindowInsetsAnimationController;->isFinished()Z

    move-result v0

    return v0
.end method

.method public setInsetsAndAlpha(Landroidx/core/graphics/Insets;FF)V
    .registers 5

    iget-object v0, p0, Landroidx/core/view/WindowInsetsAnimationControllerCompat$Impl30;->mController:Landroid/view/WindowInsetsAnimationController;

    if-nez p1, :cond_6

    const/4 p1, 0x0

    goto :goto_a

    :cond_6
    invoke-virtual {p1}, Landroidx/core/graphics/Insets;->toPlatformInsets()Landroid/graphics/Insets;

    move-result-object p1

    :goto_a
    invoke-interface {v0, p1, p2, p3}, Landroid/view/WindowInsetsAnimationController;->setInsetsAndAlpha(Landroid/graphics/Insets;FF)V

    return-void
.end method
