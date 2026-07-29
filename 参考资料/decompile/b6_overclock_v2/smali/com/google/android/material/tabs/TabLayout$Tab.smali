.class public Lcom/google/android/material/tabs/TabLayout$Tab;
.super Ljava/lang/Object;
.source "TabLayout.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/material/tabs/TabLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Tab"
.end annotation


# static fields
.field public static final INVALID_POSITION:I = -0x1


# instance fields
.field private contentDesc:Ljava/lang/CharSequence;

.field private customView:Landroid/view/View;

.field private icon:Landroid/graphics/drawable/Drawable;

.field private id:I

.field private labelVisibilityMode:I

.field public parent:Lcom/google/android/material/tabs/TabLayout;

.field private position:I

.field private tag:Ljava/lang/Object;

.field private text:Ljava/lang/CharSequence;

.field public view:Lcom/google/android/material/tabs/TabLayout$TabView;


# direct methods
.method public constructor <init>()V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, -0x1

    iput v0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->position:I

    const/4 v1, 0x1

    iput v1, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->labelVisibilityMode:I

    iput v0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->id:I

    return-void
.end method

.method static synthetic access$000(Lcom/google/android/material/tabs/TabLayout$Tab;)I
    .registers 1

    iget p0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->id:I

    return p0
.end method

.method static synthetic access$1500(Lcom/google/android/material/tabs/TabLayout$Tab;)I
    .registers 1

    iget p0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->labelVisibilityMode:I

    return p0
.end method

.method static synthetic access$300(Lcom/google/android/material/tabs/TabLayout$Tab;)Ljava/lang/CharSequence;
    .registers 1

    iget-object p0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->contentDesc:Ljava/lang/CharSequence;

    return-object p0
.end method

.method static synthetic access$400(Lcom/google/android/material/tabs/TabLayout$Tab;)Ljava/lang/CharSequence;
    .registers 1

    iget-object p0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->text:Ljava/lang/CharSequence;

    return-object p0
.end method


# virtual methods
.method public getBadge()Lcom/google/android/material/badge/BadgeDrawable;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->view:Lcom/google/android/material/tabs/TabLayout$TabView;

    # invokes: Lcom/google/android/material/tabs/TabLayout$TabView;->getBadge()Lcom/google/android/material/badge/BadgeDrawable;
    invoke-static {v0}, Lcom/google/android/material/tabs/TabLayout$TabView;->access$1000(Lcom/google/android/material/tabs/TabLayout$TabView;)Lcom/google/android/material/badge/BadgeDrawable;

    move-result-object v0

    return-object v0
.end method

.method public getContentDescription()Ljava/lang/CharSequence;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->view:Lcom/google/android/material/tabs/TabLayout$TabView;

    if-nez v0, :cond_6

    const/4 v0, 0x0

    goto :goto_a

    :cond_6
    invoke-virtual {v0}, Lcom/google/android/material/tabs/TabLayout$TabView;->getContentDescription()Ljava/lang/CharSequence;

    move-result-object v0

    :goto_a
    return-object v0
.end method

.method public getCustomView()Landroid/view/View;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->customView:Landroid/view/View;

    return-object v0
.end method

.method public getIcon()Landroid/graphics/drawable/Drawable;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->icon:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public getId()I
    .registers 2

    iget v0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->id:I

    return v0
.end method

.method public getOrCreateBadge()Lcom/google/android/material/badge/BadgeDrawable;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->view:Lcom/google/android/material/tabs/TabLayout$TabView;

    # invokes: Lcom/google/android/material/tabs/TabLayout$TabView;->getOrCreateBadge()Lcom/google/android/material/badge/BadgeDrawable;
    invoke-static {v0}, Lcom/google/android/material/tabs/TabLayout$TabView;->access$800(Lcom/google/android/material/tabs/TabLayout$TabView;)Lcom/google/android/material/badge/BadgeDrawable;

    move-result-object v0

    return-object v0
.end method

.method public getPosition()I
    .registers 2

    iget v0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->position:I

    return v0
.end method

.method public getTabLabelVisibility()I
    .registers 2

    iget v0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->labelVisibilityMode:I

    return v0
.end method

.method public getTag()Ljava/lang/Object;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->tag:Ljava/lang/Object;

    return-object v0
.end method

.method public getText()Ljava/lang/CharSequence;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->text:Ljava/lang/CharSequence;

    return-object v0
.end method

.method public isSelected()Z
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->parent:Lcom/google/android/material/tabs/TabLayout;

    if-eqz v0, :cond_13

    invoke-virtual {v0}, Lcom/google/android/material/tabs/TabLayout;->getSelectedTabPosition()I

    move-result v0

    const/4 v1, -0x1

    if-eq v0, v1, :cond_11

    iget v1, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->position:I

    if-ne v0, v1, :cond_11

    const/4 v0, 0x1

    goto :goto_12

    :cond_11
    const/4 v0, 0x0

    :goto_12
    return v0

    :cond_13
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Tab not attached to a TabLayout"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public removeBadge()V
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->view:Lcom/google/android/material/tabs/TabLayout$TabView;

    # invokes: Lcom/google/android/material/tabs/TabLayout$TabView;->removeBadge()V
    invoke-static {v0}, Lcom/google/android/material/tabs/TabLayout$TabView;->access$900(Lcom/google/android/material/tabs/TabLayout$TabView;)V

    return-void
.end method

.method reset()V
    .registers 3

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->parent:Lcom/google/android/material/tabs/TabLayout;

    iput-object v0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->view:Lcom/google/android/material/tabs/TabLayout$TabView;

    iput-object v0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->tag:Ljava/lang/Object;

    iput-object v0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->icon:Landroid/graphics/drawable/Drawable;

    const/4 v1, -0x1

    iput v1, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->id:I

    iput-object v0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->text:Ljava/lang/CharSequence;

    iput-object v0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->contentDesc:Ljava/lang/CharSequence;

    iput v1, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->position:I

    iput-object v0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->customView:Landroid/view/View;

    return-void
.end method

.method public select()V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->parent:Lcom/google/android/material/tabs/TabLayout;

    if-eqz v0, :cond_8

    invoke-virtual {v0, p0}, Lcom/google/android/material/tabs/TabLayout;->selectTab(Lcom/google/android/material/tabs/TabLayout$Tab;)V

    return-void

    :cond_8
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Tab not attached to a TabLayout"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public setContentDescription(I)Lcom/google/android/material/tabs/TabLayout$Tab;
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->parent:Lcom/google/android/material/tabs/TabLayout;

    if-eqz v0, :cond_11

    invoke-virtual {v0}, Lcom/google/android/material/tabs/TabLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getText(I)Ljava/lang/CharSequence;

    move-result-object p1

    invoke-virtual {p0, p1}, Lcom/google/android/material/tabs/TabLayout$Tab;->setContentDescription(Ljava/lang/CharSequence;)Lcom/google/android/material/tabs/TabLayout$Tab;

    move-result-object p1

    return-object p1

    :cond_11
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string v0, "Tab not attached to a TabLayout"

    invoke-direct {p1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public setContentDescription(Ljava/lang/CharSequence;)Lcom/google/android/material/tabs/TabLayout$Tab;
    .registers 2

    iput-object p1, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->contentDesc:Ljava/lang/CharSequence;

    invoke-virtual {p0}, Lcom/google/android/material/tabs/TabLayout$Tab;->updateView()V

    return-object p0
.end method

.method public setCustomView(I)Lcom/google/android/material/tabs/TabLayout$Tab;
    .registers 5

    iget-object v0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->view:Lcom/google/android/material/tabs/TabLayout$TabView;

    invoke-virtual {v0}, Lcom/google/android/material/tabs/TabLayout$TabView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->view:Lcom/google/android/material/tabs/TabLayout$TabView;

    const/4 v2, 0x0

    invoke-virtual {v0, p1, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p1

    invoke-virtual {p0, p1}, Lcom/google/android/material/tabs/TabLayout$Tab;->setCustomView(Landroid/view/View;)Lcom/google/android/material/tabs/TabLayout$Tab;

    move-result-object p1

    return-object p1
.end method

.method public setCustomView(Landroid/view/View;)Lcom/google/android/material/tabs/TabLayout$Tab;
    .registers 2

    iput-object p1, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->customView:Landroid/view/View;

    invoke-virtual {p0}, Lcom/google/android/material/tabs/TabLayout$Tab;->updateView()V

    return-object p0
.end method

.method public setIcon(I)Lcom/google/android/material/tabs/TabLayout$Tab;
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->parent:Lcom/google/android/material/tabs/TabLayout;

    if-eqz v0, :cond_11

    invoke-virtual {v0}, Lcom/google/android/material/tabs/TabLayout;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p1}, Landroidx/appcompat/content/res/AppCompatResources;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object p1

    invoke-virtual {p0, p1}, Lcom/google/android/material/tabs/TabLayout$Tab;->setIcon(Landroid/graphics/drawable/Drawable;)Lcom/google/android/material/tabs/TabLayout$Tab;

    move-result-object p1

    return-object p1

    :cond_11
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string v0, "Tab not attached to a TabLayout"

    invoke-direct {p1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public setIcon(Landroid/graphics/drawable/Drawable;)Lcom/google/android/material/tabs/TabLayout$Tab;
    .registers 4

    iput-object p1, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->icon:Landroid/graphics/drawable/Drawable;

    iget-object p1, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->parent:Lcom/google/android/material/tabs/TabLayout;

    iget p1, p1, Lcom/google/android/material/tabs/TabLayout;->tabGravity:I

    const/4 v0, 0x1

    if-eq p1, v0, :cond_10

    iget-object p1, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->parent:Lcom/google/android/material/tabs/TabLayout;

    iget p1, p1, Lcom/google/android/material/tabs/TabLayout;->mode:I

    const/4 v1, 0x2

    if-ne p1, v1, :cond_15

    :cond_10
    iget-object p1, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->parent:Lcom/google/android/material/tabs/TabLayout;

    invoke-virtual {p1, v0}, Lcom/google/android/material/tabs/TabLayout;->updateTabViews(Z)V

    :cond_15
    invoke-virtual {p0}, Lcom/google/android/material/tabs/TabLayout$Tab;->updateView()V

    sget-boolean p1, Lcom/google/android/material/badge/BadgeUtils;->USE_COMPAT_PARENT:Z

    if-eqz p1, :cond_35

    iget-object p1, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->view:Lcom/google/android/material/tabs/TabLayout$TabView;

    # invokes: Lcom/google/android/material/tabs/TabLayout$TabView;->hasBadgeDrawable()Z
    invoke-static {p1}, Lcom/google/android/material/tabs/TabLayout$TabView;->access$600(Lcom/google/android/material/tabs/TabLayout$TabView;)Z

    move-result p1

    if-eqz p1, :cond_35

    iget-object p1, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->view:Lcom/google/android/material/tabs/TabLayout$TabView;

    # getter for: Lcom/google/android/material/tabs/TabLayout$TabView;->badgeDrawable:Lcom/google/android/material/badge/BadgeDrawable;
    invoke-static {p1}, Lcom/google/android/material/tabs/TabLayout$TabView;->access$700(Lcom/google/android/material/tabs/TabLayout$TabView;)Lcom/google/android/material/badge/BadgeDrawable;

    move-result-object p1

    invoke-virtual {p1}, Lcom/google/android/material/badge/BadgeDrawable;->isVisible()Z

    move-result p1

    if-eqz p1, :cond_35

    iget-object p1, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->view:Lcom/google/android/material/tabs/TabLayout$TabView;

    invoke-virtual {p1}, Lcom/google/android/material/tabs/TabLayout$TabView;->invalidate()V

    :cond_35
    return-object p0
.end method

.method public setId(I)Lcom/google/android/material/tabs/TabLayout$Tab;
    .registers 3

    iput p1, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->id:I

    iget-object v0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->view:Lcom/google/android/material/tabs/TabLayout$TabView;

    if-eqz v0, :cond_9

    invoke-virtual {v0, p1}, Lcom/google/android/material/tabs/TabLayout$TabView;->setId(I)V

    :cond_9
    return-object p0
.end method

.method setPosition(I)V
    .registers 2

    iput p1, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->position:I

    return-void
.end method

.method public setTabLabelVisibility(I)Lcom/google/android/material/tabs/TabLayout$Tab;
    .registers 4

    iput p1, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->labelVisibilityMode:I

    iget-object p1, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->parent:Lcom/google/android/material/tabs/TabLayout;

    iget p1, p1, Lcom/google/android/material/tabs/TabLayout;->tabGravity:I

    const/4 v0, 0x1

    if-eq p1, v0, :cond_10

    iget-object p1, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->parent:Lcom/google/android/material/tabs/TabLayout;

    iget p1, p1, Lcom/google/android/material/tabs/TabLayout;->mode:I

    const/4 v1, 0x2

    if-ne p1, v1, :cond_15

    :cond_10
    iget-object p1, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->parent:Lcom/google/android/material/tabs/TabLayout;

    invoke-virtual {p1, v0}, Lcom/google/android/material/tabs/TabLayout;->updateTabViews(Z)V

    :cond_15
    invoke-virtual {p0}, Lcom/google/android/material/tabs/TabLayout$Tab;->updateView()V

    sget-boolean p1, Lcom/google/android/material/badge/BadgeUtils;->USE_COMPAT_PARENT:Z

    if-eqz p1, :cond_35

    iget-object p1, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->view:Lcom/google/android/material/tabs/TabLayout$TabView;

    # invokes: Lcom/google/android/material/tabs/TabLayout$TabView;->hasBadgeDrawable()Z
    invoke-static {p1}, Lcom/google/android/material/tabs/TabLayout$TabView;->access$600(Lcom/google/android/material/tabs/TabLayout$TabView;)Z

    move-result p1

    if-eqz p1, :cond_35

    iget-object p1, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->view:Lcom/google/android/material/tabs/TabLayout$TabView;

    # getter for: Lcom/google/android/material/tabs/TabLayout$TabView;->badgeDrawable:Lcom/google/android/material/badge/BadgeDrawable;
    invoke-static {p1}, Lcom/google/android/material/tabs/TabLayout$TabView;->access$700(Lcom/google/android/material/tabs/TabLayout$TabView;)Lcom/google/android/material/badge/BadgeDrawable;

    move-result-object p1

    invoke-virtual {p1}, Lcom/google/android/material/badge/BadgeDrawable;->isVisible()Z

    move-result p1

    if-eqz p1, :cond_35

    iget-object p1, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->view:Lcom/google/android/material/tabs/TabLayout$TabView;

    invoke-virtual {p1}, Lcom/google/android/material/tabs/TabLayout$TabView;->invalidate()V

    :cond_35
    return-object p0
.end method

.method public setTag(Ljava/lang/Object;)Lcom/google/android/material/tabs/TabLayout$Tab;
    .registers 2

    iput-object p1, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->tag:Ljava/lang/Object;

    return-object p0
.end method

.method public setText(I)Lcom/google/android/material/tabs/TabLayout$Tab;
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->parent:Lcom/google/android/material/tabs/TabLayout;

    if-eqz v0, :cond_11

    invoke-virtual {v0}, Lcom/google/android/material/tabs/TabLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getText(I)Ljava/lang/CharSequence;

    move-result-object p1

    invoke-virtual {p0, p1}, Lcom/google/android/material/tabs/TabLayout$Tab;->setText(Ljava/lang/CharSequence;)Lcom/google/android/material/tabs/TabLayout$Tab;

    move-result-object p1

    return-object p1

    :cond_11
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string v0, "Tab not attached to a TabLayout"

    invoke-direct {p1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public setText(Ljava/lang/CharSequence;)Lcom/google/android/material/tabs/TabLayout$Tab;
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->contentDesc:Ljava/lang/CharSequence;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_13

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_13

    iget-object v0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->view:Lcom/google/android/material/tabs/TabLayout$TabView;

    invoke-virtual {v0, p1}, Lcom/google/android/material/tabs/TabLayout$TabView;->setContentDescription(Ljava/lang/CharSequence;)V

    :cond_13
    iput-object p1, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->text:Ljava/lang/CharSequence;

    invoke-virtual {p0}, Lcom/google/android/material/tabs/TabLayout$Tab;->updateView()V

    return-object p0
.end method

.method updateView()V
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/tabs/TabLayout$Tab;->view:Lcom/google/android/material/tabs/TabLayout$TabView;

    if-eqz v0, :cond_7

    invoke-virtual {v0}, Lcom/google/android/material/tabs/TabLayout$TabView;->update()V

    :cond_7
    return-void
.end method
