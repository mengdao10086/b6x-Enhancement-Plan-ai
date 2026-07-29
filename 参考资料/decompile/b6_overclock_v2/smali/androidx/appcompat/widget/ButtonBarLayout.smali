.class public Landroidx/appcompat/widget/ButtonBarLayout;
.super Landroid/widget/LinearLayout;
.source "ButtonBarLayout.java"


# static fields
.field private static final PEEK_BUTTON_DP:I = 0x10


# instance fields
.field private mAllowStacking:Z

.field private mLastWidthSize:I

.field private mStacked:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 11

    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    const/4 v0, -0x1

    iput v0, p0, Landroidx/appcompat/widget/ButtonBarLayout;->mLastWidthSize:I

    sget-object v0, Landroidx/appcompat/R$styleable;->ButtonBarLayout:[I

    invoke-virtual {p1, p2, v0}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    sget-object v3, Landroidx/appcompat/R$styleable;->ButtonBarLayout:[I

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object v1, p0

    move-object v2, p1

    move-object v4, p2

    move-object v5, v0

    invoke-static/range {v1 .. v7}, Landroidx/core/view/ViewCompat;->saveAttributeDataForStyleable(Landroid/view/View;Landroid/content/Context;[ILandroid/util/AttributeSet;Landroid/content/res/TypedArray;II)V

    sget p1, Landroidx/appcompat/R$styleable;->ButtonBarLayout_allowStacking:I

    const/4 p2, 0x1

    invoke-virtual {v0, p1, p2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result p1

    iput-boolean p1, p0, Landroidx/appcompat/widget/ButtonBarLayout;->mAllowStacking:Z

    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    invoke-virtual {p0}, Landroidx/appcompat/widget/ButtonBarLayout;->getOrientation()I

    move-result p1

    if-ne p1, p2, :cond_2e

    iget-boolean p1, p0, Landroidx/appcompat/widget/ButtonBarLayout;->mAllowStacking:Z

    invoke-direct {p0, p1}, Landroidx/appcompat/widget/ButtonBarLayout;->setStacked(Z)V

    :cond_2e
    return-void
.end method

.method private getNextVisibleChildIndex(I)I
    .registers 4

    invoke-virtual {p0}, Landroidx/appcompat/widget/ButtonBarLayout;->getChildCount()I

    move-result v0

    :goto_4
    if-ge p1, v0, :cond_14

    invoke-virtual {p0, p1}, Landroidx/appcompat/widget/ButtonBarLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getVisibility()I

    move-result v1

    if-nez v1, :cond_11

    return p1

    :cond_11
    add-int/lit8 p1, p1, 0x1

    goto :goto_4

    :cond_14
    const/4 p1, -0x1

    return p1
.end method

.method private isStacked()Z
    .registers 2

    iget-boolean v0, p0, Landroidx/appcompat/widget/ButtonBarLayout;->mStacked:Z

    return v0
.end method

.method private setStacked(Z)V
    .registers 3

    iget-boolean v0, p0, Landroidx/appcompat/widget/ButtonBarLayout;->mStacked:Z

    if-eq v0, p1, :cond_3d

    if-eqz p1, :cond_a

    iget-boolean v0, p0, Landroidx/appcompat/widget/ButtonBarLayout;->mAllowStacking:Z

    if-eqz v0, :cond_3d

    :cond_a
    iput-boolean p1, p0, Landroidx/appcompat/widget/ButtonBarLayout;->mStacked:Z

    invoke-virtual {p0, p1}, Landroidx/appcompat/widget/ButtonBarLayout;->setOrientation(I)V

    if-eqz p1, :cond_15

    const v0, 0x800005

    goto :goto_17

    :cond_15
    const/16 v0, 0x50

    :goto_17
    invoke-virtual {p0, v0}, Landroidx/appcompat/widget/ButtonBarLayout;->setGravity(I)V

    sget v0, Landroidx/appcompat/R$id;->spacer:I

    invoke-virtual {p0, v0}, Landroidx/appcompat/widget/ButtonBarLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_2b

    if-eqz p1, :cond_27

    const/16 p1, 0x8

    goto :goto_28

    :cond_27
    const/4 p1, 0x4

    :goto_28
    invoke-virtual {v0, p1}, Landroid/view/View;->setVisibility(I)V

    :cond_2b
    invoke-virtual {p0}, Landroidx/appcompat/widget/ButtonBarLayout;->getChildCount()I

    move-result p1

    add-int/lit8 p1, p1, -0x2

    :goto_31
    if-ltz p1, :cond_3d

    invoke-virtual {p0, p1}, Landroidx/appcompat/widget/ButtonBarLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroidx/appcompat/widget/ButtonBarLayout;->bringChildToFront(Landroid/view/View;)V

    add-int/lit8 p1, p1, -0x1

    goto :goto_31

    :cond_3d
    return-void
.end method


# virtual methods
.method protected onMeasure(II)V
    .registers 9

    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v0

    iget-boolean v1, p0, Landroidx/appcompat/widget/ButtonBarLayout;->mAllowStacking:Z

    const/4 v2, 0x0

    if-eqz v1, :cond_18

    iget v1, p0, Landroidx/appcompat/widget/ButtonBarLayout;->mLastWidthSize:I

    if-le v0, v1, :cond_16

    invoke-direct {p0}, Landroidx/appcompat/widget/ButtonBarLayout;->isStacked()Z

    move-result v1

    if-eqz v1, :cond_16

    invoke-direct {p0, v2}, Landroidx/appcompat/widget/ButtonBarLayout;->setStacked(Z)V

    :cond_16
    iput v0, p0, Landroidx/appcompat/widget/ButtonBarLayout;->mLastWidthSize:I

    :cond_18
    invoke-direct {p0}, Landroidx/appcompat/widget/ButtonBarLayout;->isStacked()Z

    move-result v1

    const/4 v3, 0x1

    if-nez v1, :cond_2f

    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v1

    const/high16 v4, 0x40000000    # 2.0f

    if-ne v1, v4, :cond_2f

    const/high16 v1, -0x80000000

    invoke-static {v0, v1}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v0

    move v1, v3

    goto :goto_31

    :cond_2f
    move v0, p1

    move v1, v2

    :goto_31
    invoke-super {p0, v0, p2}, Landroid/widget/LinearLayout;->onMeasure(II)V

    iget-boolean v0, p0, Landroidx/appcompat/widget/ButtonBarLayout;->mAllowStacking:Z

    if-eqz v0, :cond_52

    invoke-direct {p0}, Landroidx/appcompat/widget/ButtonBarLayout;->isStacked()Z

    move-result v0

    if-nez v0, :cond_52

    invoke-virtual {p0}, Landroidx/appcompat/widget/ButtonBarLayout;->getMeasuredWidthAndState()I

    move-result v0

    const/high16 v4, -0x1000000

    and-int/2addr v0, v4

    const/high16 v4, 0x1000000

    if-ne v0, v4, :cond_4b

    move v0, v3

    goto :goto_4c

    :cond_4b
    move v0, v2

    :goto_4c
    if-eqz v0, :cond_52

    invoke-direct {p0, v3}, Landroidx/appcompat/widget/ButtonBarLayout;->setStacked(Z)V

    move v1, v3

    :cond_52
    if-eqz v1, :cond_57

    invoke-super {p0, p1, p2}, Landroid/widget/LinearLayout;->onMeasure(II)V

    :cond_57
    invoke-direct {p0, v2}, Landroidx/appcompat/widget/ButtonBarLayout;->getNextVisibleChildIndex(I)I

    move-result v0

    if-ltz v0, :cond_a4

    invoke-virtual {p0, v0}, Landroidx/appcompat/widget/ButtonBarLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v4

    check-cast v4, Landroid/widget/LinearLayout$LayoutParams;

    invoke-virtual {p0}, Landroidx/appcompat/widget/ButtonBarLayout;->getPaddingTop()I

    move-result v5

    invoke-virtual {v1}, Landroid/view/View;->getMeasuredHeight()I

    move-result v1

    add-int/2addr v5, v1

    iget v1, v4, Landroid/widget/LinearLayout$LayoutParams;->topMargin:I

    add-int/2addr v5, v1

    iget v1, v4, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin:I

    add-int/2addr v5, v1

    add-int/2addr v5, v2

    invoke-direct {p0}, Landroidx/appcompat/widget/ButtonBarLayout;->isStacked()Z

    move-result v1

    if-eqz v1, :cond_9e

    add-int/2addr v0, v3

    invoke-direct {p0, v0}, Landroidx/appcompat/widget/ButtonBarLayout;->getNextVisibleChildIndex(I)I

    move-result v0

    if-ltz v0, :cond_9c

    invoke-virtual {p0, v0}, Landroidx/appcompat/widget/ButtonBarLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getPaddingTop()I

    move-result v0

    invoke-virtual {p0}, Landroidx/appcompat/widget/ButtonBarLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v1, v1, Landroid/util/DisplayMetrics;->density:F

    const/high16 v2, 0x41800000    # 16.0f

    mul-float/2addr v1, v2

    float-to-int v1, v1

    add-int/2addr v0, v1

    add-int/2addr v5, v0

    :cond_9c
    move v2, v5

    goto :goto_a4

    :cond_9e
    invoke-virtual {p0}, Landroidx/appcompat/widget/ButtonBarLayout;->getPaddingBottom()I

    move-result v0

    add-int v2, v5, v0

    :cond_a4
    :goto_a4
    invoke-static {p0}, Landroidx/core/view/ViewCompat;->getMinimumHeight(Landroid/view/View;)I

    move-result v0

    if-eq v0, v2, :cond_b2

    invoke-virtual {p0, v2}, Landroidx/appcompat/widget/ButtonBarLayout;->setMinimumHeight(I)V

    if-nez p2, :cond_b2

    invoke-super {p0, p1, p2}, Landroid/widget/LinearLayout;->onMeasure(II)V

    :cond_b2
    return-void
.end method

.method public setAllowStacking(Z)V
    .registers 3

    iget-boolean v0, p0, Landroidx/appcompat/widget/ButtonBarLayout;->mAllowStacking:Z

    if-eq v0, p1, :cond_15

    iput-boolean p1, p0, Landroidx/appcompat/widget/ButtonBarLayout;->mAllowStacking:Z

    if-nez p1, :cond_12

    invoke-direct {p0}, Landroidx/appcompat/widget/ButtonBarLayout;->isStacked()Z

    move-result p1

    if-eqz p1, :cond_12

    const/4 p1, 0x0

    invoke-direct {p0, p1}, Landroidx/appcompat/widget/ButtonBarLayout;->setStacked(Z)V

    :cond_12
    invoke-virtual {p0}, Landroidx/appcompat/widget/ButtonBarLayout;->requestLayout()V

    :cond_15
    return-void
.end method
