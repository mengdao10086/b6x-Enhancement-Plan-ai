.class public Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;
.super Lcom/google/android/material/navigation/NavigationBarMenuView;
.source "BottomNavigationMenuView.java"


# instance fields
.field private final activeItemMaxWidth:I

.field private final activeItemMinWidth:I

.field private final inactiveItemMaxWidth:I

.field private final inactiveItemMinWidth:I

.field private itemHorizontalTranslationEnabled:Z

.field private final tempChildWidths:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 3

    invoke-direct {p0, p1}, Lcom/google/android/material/navigation/NavigationBarMenuView;-><init>(Landroid/content/Context;)V

    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    iput-object p1, p0, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->tempChildWidths:Ljava/util/List;

    new-instance p1, Landroid/widget/FrameLayout$LayoutParams;

    const/4 v0, -0x2

    invoke-direct {p1, v0, v0}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    const/16 v0, 0x11

    iput v0, p1, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    invoke-virtual {p0, p1}, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    invoke-virtual {p0}, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->getResources()Landroid/content/res/Resources;

    move-result-object p1

    sget v0, Lcom/google/android/material/R$dimen;->design_bottom_navigation_item_max_width:I

    invoke-virtual {p1, v0}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iput v0, p0, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->inactiveItemMaxWidth:I

    sget v0, Lcom/google/android/material/R$dimen;->design_bottom_navigation_item_min_width:I

    invoke-virtual {p1, v0}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iput v0, p0, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->inactiveItemMinWidth:I

    sget v0, Lcom/google/android/material/R$dimen;->design_bottom_navigation_active_item_max_width:I

    invoke-virtual {p1, v0}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iput v0, p0, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->activeItemMaxWidth:I

    sget v0, Lcom/google/android/material/R$dimen;->design_bottom_navigation_active_item_min_width:I

    invoke-virtual {p1, v0}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result p1

    iput p1, p0, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->activeItemMinWidth:I

    return-void
.end method


# virtual methods
.method protected createNavigationBarItemView(Landroid/content/Context;)Lcom/google/android/material/navigation/NavigationBarItemView;
    .registers 3

    new-instance v0, Lcom/google/android/material/bottomnavigation/BottomNavigationItemView;

    invoke-direct {v0, p1}, Lcom/google/android/material/bottomnavigation/BottomNavigationItemView;-><init>(Landroid/content/Context;)V

    return-object v0
.end method

.method public isItemHorizontalTranslationEnabled()Z
    .registers 2

    iget-boolean v0, p0, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->itemHorizontalTranslationEnabled:Z

    return v0
.end method

.method protected onLayout(ZIIII)V
    .registers 10

    invoke-virtual {p0}, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->getChildCount()I

    move-result p1

    sub-int/2addr p4, p2

    sub-int/2addr p5, p3

    const/4 p2, 0x0

    move p3, p2

    move v0, p3

    :goto_9
    if-ge p3, p1, :cond_3b

    invoke-virtual {p0, p3}, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getVisibility()I

    move-result v2

    const/16 v3, 0x8

    if-ne v2, v3, :cond_18

    goto :goto_38

    :cond_18
    invoke-static {p0}, Landroidx/core/view/ViewCompat;->getLayoutDirection(Landroid/view/View;)I

    move-result v2

    const/4 v3, 0x1

    if-ne v2, v3, :cond_2b

    sub-int v2, p4, v0

    invoke-virtual {v1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v3

    sub-int v3, v2, v3

    invoke-virtual {v1, v3, p2, v2, p5}, Landroid/view/View;->layout(IIII)V

    goto :goto_33

    :cond_2b
    invoke-virtual {v1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v2

    add-int/2addr v2, v0

    invoke-virtual {v1, v0, p2, v2, p5}, Landroid/view/View;->layout(IIII)V

    :goto_33
    invoke-virtual {v1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v1

    add-int/2addr v0, v1

    :goto_38
    add-int/lit8 p3, p3, 0x1

    goto :goto_9

    :cond_3b
    return-void
.end method

.method protected onMeasure(II)V
    .registers 14

    invoke-virtual {p0}, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->getMenu()Landroidx/appcompat/view/menu/MenuBuilder;

    move-result-object v0

    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result p1

    invoke-virtual {v0}, Landroidx/appcompat/view/menu/MenuBuilder;->getVisibleItems()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    invoke-virtual {p0}, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->getChildCount()I

    move-result v1

    iget-object v2, p0, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->tempChildWidths:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->clear()V

    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result p2

    const/high16 v2, 0x40000000    # 2.0f

    invoke-static {p2, v2}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v3

    invoke-virtual {p0}, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->getLabelVisibilityMode()I

    move-result v4

    invoke-virtual {p0, v4, v0}, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->isShifting(II)Z

    move-result v4

    const/16 v5, 0x8

    const/4 v6, 0x0

    const/4 v7, 0x1

    if-eqz v4, :cond_ac

    invoke-virtual {p0}, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->isItemHorizontalTranslationEnabled()Z

    move-result v4

    if-eqz v4, :cond_ac

    invoke-virtual {p0}, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->getSelectedItemPosition()I

    move-result v4

    invoke-virtual {p0, v4}, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    iget v8, p0, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->activeItemMinWidth:I

    invoke-virtual {v4}, Landroid/view/View;->getVisibility()I

    move-result v9

    if-eq v9, v5, :cond_5a

    iget v9, p0, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->activeItemMaxWidth:I

    const/high16 v10, -0x80000000

    invoke-static {v9, v10}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v9

    invoke-virtual {v4, v9, v3}, Landroid/view/View;->measure(II)V

    invoke-virtual {v4}, Landroid/view/View;->getMeasuredWidth()I

    move-result v9

    invoke-static {v8, v9}, Ljava/lang/Math;->max(II)I

    move-result v8

    :cond_5a
    invoke-virtual {v4}, Landroid/view/View;->getVisibility()I

    move-result v4

    if-eq v4, v5, :cond_62

    move v4, v7

    goto :goto_63

    :cond_62
    move v4, v6

    :goto_63
    sub-int/2addr v0, v4

    iget v4, p0, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->inactiveItemMinWidth:I

    mul-int/2addr v4, v0

    sub-int v4, p1, v4

    iget v9, p0, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->activeItemMaxWidth:I

    invoke-static {v8, v9}, Ljava/lang/Math;->min(II)I

    move-result v8

    invoke-static {v4, v8}, Ljava/lang/Math;->min(II)I

    move-result v4

    sub-int/2addr p1, v4

    if-nez v0, :cond_77

    goto :goto_78

    :cond_77
    move v7, v0

    :goto_78
    div-int v7, p1, v7

    iget v8, p0, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->inactiveItemMaxWidth:I

    invoke-static {v7, v8}, Ljava/lang/Math;->min(II)I

    move-result v7

    mul-int/2addr v0, v7

    sub-int/2addr p1, v0

    move v0, v6

    :goto_83
    if-ge v0, v1, :cond_dd

    invoke-virtual {p0, v0}, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v8

    invoke-virtual {v8}, Landroid/view/View;->getVisibility()I

    move-result v8

    if-eq v8, v5, :cond_9f

    invoke-virtual {p0}, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->getSelectedItemPosition()I

    move-result v8

    if-ne v0, v8, :cond_97

    move v8, v4

    goto :goto_98

    :cond_97
    move v8, v7

    :goto_98
    if-lez p1, :cond_a0

    add-int/lit8 v8, v8, 0x1

    add-int/lit8 p1, p1, -0x1

    goto :goto_a0

    :cond_9f
    move v8, v6

    :cond_a0
    :goto_a0
    iget-object v9, p0, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->tempChildWidths:Ljava/util/List;

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-interface {v9, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v0, v0, 0x1

    goto :goto_83

    :cond_ac
    if-nez v0, :cond_af

    goto :goto_b0

    :cond_af
    move v7, v0

    :goto_b0
    div-int v4, p1, v7

    iget v7, p0, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->activeItemMaxWidth:I

    invoke-static {v4, v7}, Ljava/lang/Math;->min(II)I

    move-result v4

    mul-int/2addr v0, v4

    sub-int/2addr p1, v0

    move v0, v6

    :goto_bb
    if-ge v0, v1, :cond_dd

    invoke-virtual {p0, v0}, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v7

    invoke-virtual {v7}, Landroid/view/View;->getVisibility()I

    move-result v7

    if-eq v7, v5, :cond_d0

    if-lez p1, :cond_ce

    add-int/lit8 v7, v4, 0x1

    add-int/lit8 p1, p1, -0x1

    goto :goto_d1

    :cond_ce
    move v7, v4

    goto :goto_d1

    :cond_d0
    move v7, v6

    :goto_d1
    iget-object v8, p0, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->tempChildWidths:Ljava/util/List;

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-interface {v8, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v0, v0, 0x1

    goto :goto_bb

    :cond_dd
    move p1, v6

    :goto_de
    if-ge v6, v1, :cond_110

    invoke-virtual {p0, v6}, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v4

    if-ne v4, v5, :cond_eb

    goto :goto_10d

    :cond_eb
    iget-object v4, p0, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->tempChildWidths:Ljava/util/List;

    invoke-interface {v4, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-static {v4, v2}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v4

    invoke-virtual {v0, v4, v3}, Landroid/view/View;->measure(II)V

    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v4

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v7

    iput v7, v4, Landroid/view/ViewGroup$LayoutParams;->width:I

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v0

    add-int/2addr p1, v0

    :goto_10d
    add-int/lit8 v6, v6, 0x1

    goto :goto_de

    :cond_110
    invoke-virtual {p0, p1, p2}, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->setMeasuredDimension(II)V

    return-void
.end method

.method public setItemHorizontalTranslationEnabled(Z)V
    .registers 2

    iput-boolean p1, p0, Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;->itemHorizontalTranslationEnabled:Z

    return-void
.end method
