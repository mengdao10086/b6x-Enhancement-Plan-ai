.class Landroidx/recyclerview/widget/FastScroller;
.super Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;
.source "FastScroller.java"

# interfaces
.implements Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/recyclerview/widget/FastScroller$AnimatorUpdater;,
        Landroidx/recyclerview/widget/FastScroller$AnimatorListener;
    }
.end annotation


# static fields
.field private static final ANIMATION_STATE_FADING_IN:I = 0x1

.field private static final ANIMATION_STATE_FADING_OUT:I = 0x3

.field private static final ANIMATION_STATE_IN:I = 0x2

.field private static final ANIMATION_STATE_OUT:I = 0x0

.field private static final DRAG_NONE:I = 0x0

.field private static final DRAG_X:I = 0x1

.field private static final DRAG_Y:I = 0x2

.field private static final EMPTY_STATE_SET:[I

.field private static final HIDE_DELAY_AFTER_DRAGGING_MS:I = 0x4b0

.field private static final HIDE_DELAY_AFTER_VISIBLE_MS:I = 0x5dc

.field private static final HIDE_DURATION_MS:I = 0x1f4

.field private static final PRESSED_STATE_SET:[I

.field private static final SCROLLBAR_FULL_OPAQUE:I = 0xff

.field private static final SHOW_DURATION_MS:I = 0x1f4

.field private static final STATE_DRAGGING:I = 0x2

.field private static final STATE_HIDDEN:I = 0x0

.field private static final STATE_VISIBLE:I = 0x1


# instance fields
.field mAnimationState:I

.field private mDragState:I

.field private final mHideRunnable:Ljava/lang/Runnable;

.field mHorizontalDragX:F

.field private final mHorizontalRange:[I

.field mHorizontalThumbCenterX:I

.field private final mHorizontalThumbDrawable:Landroid/graphics/drawable/StateListDrawable;

.field private final mHorizontalThumbHeight:I

.field mHorizontalThumbWidth:I

.field private final mHorizontalTrackDrawable:Landroid/graphics/drawable/Drawable;

.field private final mHorizontalTrackHeight:I

.field private final mMargin:I

.field private mNeedHorizontalScrollbar:Z

.field private mNeedVerticalScrollbar:Z

.field private final mOnScrollListener:Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;

.field private mRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

.field private mRecyclerViewHeight:I

.field private mRecyclerViewWidth:I

.field private final mScrollbarMinimumRange:I

.field final mShowHideAnimator:Landroid/animation/ValueAnimator;

.field private mState:I

.field mVerticalDragY:F

.field private final mVerticalRange:[I

.field mVerticalThumbCenterY:I

.field final mVerticalThumbDrawable:Landroid/graphics/drawable/StateListDrawable;

.field mVerticalThumbHeight:I

.field private final mVerticalThumbWidth:I

.field final mVerticalTrackDrawable:Landroid/graphics/drawable/Drawable;

.field private final mVerticalTrackWidth:I


# direct methods
.method static constructor <clinit>()V
    .registers 3

    const/4 v0, 0x1

    new-array v0, v0, [I

    const v1, 0x10100a7

    const/4 v2, 0x0

    aput v1, v0, v2

    sput-object v0, Landroidx/recyclerview/widget/FastScroller;->PRESSED_STATE_SET:[I

    new-array v0, v2, [I

    sput-object v0, Landroidx/recyclerview/widget/FastScroller;->EMPTY_STATE_SET:[I

    return-void
.end method

.method constructor <init>(Landroidx/recyclerview/widget/RecyclerView;Landroid/graphics/drawable/StateListDrawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/StateListDrawable;Landroid/graphics/drawable/Drawable;III)V
    .registers 12

    invoke-direct {p0}, Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;-><init>()V

    const/4 v0, 0x0

    iput v0, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerViewWidth:I

    iput v0, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerViewHeight:I

    iput-boolean v0, p0, Landroidx/recyclerview/widget/FastScroller;->mNeedVerticalScrollbar:Z

    iput-boolean v0, p0, Landroidx/recyclerview/widget/FastScroller;->mNeedHorizontalScrollbar:Z

    iput v0, p0, Landroidx/recyclerview/widget/FastScroller;->mState:I

    iput v0, p0, Landroidx/recyclerview/widget/FastScroller;->mDragState:I

    const/4 v1, 0x2

    new-array v2, v1, [I

    iput-object v2, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalRange:[I

    new-array v2, v1, [I

    iput-object v2, p0, Landroidx/recyclerview/widget/FastScroller;->mHorizontalRange:[I

    new-array v1, v1, [F

    fill-array-data v1, :array_84

    invoke-static {v1}, Landroid/animation/ValueAnimator;->ofFloat([F)Landroid/animation/ValueAnimator;

    move-result-object v1

    iput-object v1, p0, Landroidx/recyclerview/widget/FastScroller;->mShowHideAnimator:Landroid/animation/ValueAnimator;

    iput v0, p0, Landroidx/recyclerview/widget/FastScroller;->mAnimationState:I

    new-instance v0, Landroidx/recyclerview/widget/FastScroller$1;

    invoke-direct {v0, p0}, Landroidx/recyclerview/widget/FastScroller$1;-><init>(Landroidx/recyclerview/widget/FastScroller;)V

    iput-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mHideRunnable:Ljava/lang/Runnable;

    new-instance v0, Landroidx/recyclerview/widget/FastScroller$2;

    invoke-direct {v0, p0}, Landroidx/recyclerview/widget/FastScroller$2;-><init>(Landroidx/recyclerview/widget/FastScroller;)V

    iput-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mOnScrollListener:Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;

    iput-object p2, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalThumbDrawable:Landroid/graphics/drawable/StateListDrawable;

    iput-object p3, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalTrackDrawable:Landroid/graphics/drawable/Drawable;

    iput-object p4, p0, Landroidx/recyclerview/widget/FastScroller;->mHorizontalThumbDrawable:Landroid/graphics/drawable/StateListDrawable;

    iput-object p5, p0, Landroidx/recyclerview/widget/FastScroller;->mHorizontalTrackDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p2}, Landroid/graphics/drawable/StateListDrawable;->getIntrinsicWidth()I

    move-result v0

    invoke-static {p6, v0}, Ljava/lang/Math;->max(II)I

    move-result v0

    iput v0, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalThumbWidth:I

    invoke-virtual {p3}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v0

    invoke-static {p6, v0}, Ljava/lang/Math;->max(II)I

    move-result v0

    iput v0, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalTrackWidth:I

    invoke-virtual {p4}, Landroid/graphics/drawable/StateListDrawable;->getIntrinsicWidth()I

    move-result p4

    invoke-static {p6, p4}, Ljava/lang/Math;->max(II)I

    move-result p4

    iput p4, p0, Landroidx/recyclerview/widget/FastScroller;->mHorizontalThumbHeight:I

    invoke-virtual {p5}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result p4

    invoke-static {p6, p4}, Ljava/lang/Math;->max(II)I

    move-result p4

    iput p4, p0, Landroidx/recyclerview/widget/FastScroller;->mHorizontalTrackHeight:I

    iput p7, p0, Landroidx/recyclerview/widget/FastScroller;->mScrollbarMinimumRange:I

    iput p8, p0, Landroidx/recyclerview/widget/FastScroller;->mMargin:I

    const/16 p4, 0xff

    invoke-virtual {p2, p4}, Landroid/graphics/drawable/StateListDrawable;->setAlpha(I)V

    invoke-virtual {p3, p4}, Landroid/graphics/drawable/Drawable;->setAlpha(I)V

    new-instance p2, Landroidx/recyclerview/widget/FastScroller$AnimatorListener;

    invoke-direct {p2, p0}, Landroidx/recyclerview/widget/FastScroller$AnimatorListener;-><init>(Landroidx/recyclerview/widget/FastScroller;)V

    invoke-virtual {v1, p2}, Landroid/animation/ValueAnimator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    new-instance p2, Landroidx/recyclerview/widget/FastScroller$AnimatorUpdater;

    invoke-direct {p2, p0}, Landroidx/recyclerview/widget/FastScroller$AnimatorUpdater;-><init>(Landroidx/recyclerview/widget/FastScroller;)V

    invoke-virtual {v1, p2}, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V

    invoke-virtual {p0, p1}, Landroidx/recyclerview/widget/FastScroller;->attachToRecyclerView(Landroidx/recyclerview/widget/RecyclerView;)V

    return-void

    :array_84
    .array-data 4
        0x0
        0x3f800000    # 1.0f
    .end array-data
.end method

.method private cancelHide()V
    .registers 3

    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    iget-object v1, p0, Landroidx/recyclerview/widget/FastScroller;->mHideRunnable:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroidx/recyclerview/widget/RecyclerView;->removeCallbacks(Ljava/lang/Runnable;)Z

    return-void
.end method

.method private destroyCallbacks()V
    .registers 3

    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v0, p0}, Landroidx/recyclerview/widget/RecyclerView;->removeItemDecoration(Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;)V

    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v0, p0}, Landroidx/recyclerview/widget/RecyclerView;->removeOnItemTouchListener(Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;)V

    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    iget-object v1, p0, Landroidx/recyclerview/widget/FastScroller;->mOnScrollListener:Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;

    invoke-virtual {v0, v1}, Landroidx/recyclerview/widget/RecyclerView;->removeOnScrollListener(Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)V

    invoke-direct {p0}, Landroidx/recyclerview/widget/FastScroller;->cancelHide()V

    return-void
.end method

.method private drawHorizontalScrollbar(Landroid/graphics/Canvas;)V
    .registers 8

    iget v0, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerViewHeight:I

    iget v1, p0, Landroidx/recyclerview/widget/FastScroller;->mHorizontalThumbHeight:I

    sub-int/2addr v0, v1

    iget v2, p0, Landroidx/recyclerview/widget/FastScroller;->mHorizontalThumbCenterX:I

    iget v3, p0, Landroidx/recyclerview/widget/FastScroller;->mHorizontalThumbWidth:I

    div-int/lit8 v4, v3, 0x2

    sub-int/2addr v2, v4

    iget-object v4, p0, Landroidx/recyclerview/widget/FastScroller;->mHorizontalThumbDrawable:Landroid/graphics/drawable/StateListDrawable;

    const/4 v5, 0x0

    invoke-virtual {v4, v5, v5, v3, v1}, Landroid/graphics/drawable/StateListDrawable;->setBounds(IIII)V

    iget-object v1, p0, Landroidx/recyclerview/widget/FastScroller;->mHorizontalTrackDrawable:Landroid/graphics/drawable/Drawable;

    iget v3, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerViewWidth:I

    iget v4, p0, Landroidx/recyclerview/widget/FastScroller;->mHorizontalTrackHeight:I

    invoke-virtual {v1, v5, v5, v3, v4}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    int-to-float v1, v0

    const/4 v3, 0x0

    invoke-virtual {p1, v3, v1}, Landroid/graphics/Canvas;->translate(FF)V

    iget-object v1, p0, Landroidx/recyclerview/widget/FastScroller;->mHorizontalTrackDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    int-to-float v1, v2

    invoke-virtual {p1, v1, v3}, Landroid/graphics/Canvas;->translate(FF)V

    iget-object v1, p0, Landroidx/recyclerview/widget/FastScroller;->mHorizontalThumbDrawable:Landroid/graphics/drawable/StateListDrawable;

    invoke-virtual {v1, p1}, Landroid/graphics/drawable/StateListDrawable;->draw(Landroid/graphics/Canvas;)V

    neg-int v1, v2

    int-to-float v1, v1

    neg-int v0, v0

    int-to-float v0, v0

    invoke-virtual {p1, v1, v0}, Landroid/graphics/Canvas;->translate(FF)V

    return-void
.end method

.method private drawVerticalScrollbar(Landroid/graphics/Canvas;)V
    .registers 8

    iget v0, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerViewWidth:I

    iget v1, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalThumbWidth:I

    sub-int/2addr v0, v1

    iget v2, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalThumbCenterY:I

    iget v3, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalThumbHeight:I

    div-int/lit8 v4, v3, 0x2

    sub-int/2addr v2, v4

    iget-object v4, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalThumbDrawable:Landroid/graphics/drawable/StateListDrawable;

    const/4 v5, 0x0

    invoke-virtual {v4, v5, v5, v1, v3}, Landroid/graphics/drawable/StateListDrawable;->setBounds(IIII)V

    iget-object v1, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalTrackDrawable:Landroid/graphics/drawable/Drawable;

    iget v3, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalTrackWidth:I

    iget v4, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerViewHeight:I

    invoke-virtual {v1, v5, v5, v3, v4}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    invoke-direct {p0}, Landroidx/recyclerview/widget/FastScroller;->isLayoutRTL()Z

    move-result v1

    if-eqz v1, :cond_46

    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalTrackDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    iget v0, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalThumbWidth:I

    int-to-float v0, v0

    int-to-float v1, v2

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->translate(FF)V

    const/high16 v0, -0x40800000    # -1.0f

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->scale(FF)V

    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalThumbDrawable:Landroid/graphics/drawable/StateListDrawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/StateListDrawable;->draw(Landroid/graphics/Canvas;)V

    invoke-virtual {p1, v1, v1}, Landroid/graphics/Canvas;->scale(FF)V

    iget v0, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalThumbWidth:I

    neg-int v0, v0

    int-to-float v0, v0

    neg-int v1, v2

    int-to-float v1, v1

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->translate(FF)V

    goto :goto_60

    :cond_46
    int-to-float v1, v0

    const/4 v3, 0x0

    invoke-virtual {p1, v1, v3}, Landroid/graphics/Canvas;->translate(FF)V

    iget-object v1, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalTrackDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    int-to-float v1, v2

    invoke-virtual {p1, v3, v1}, Landroid/graphics/Canvas;->translate(FF)V

    iget-object v1, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalThumbDrawable:Landroid/graphics/drawable/StateListDrawable;

    invoke-virtual {v1, p1}, Landroid/graphics/drawable/StateListDrawable;->draw(Landroid/graphics/Canvas;)V

    neg-int v0, v0

    int-to-float v0, v0

    neg-int v1, v2

    int-to-float v1, v1

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->translate(FF)V

    :goto_60
    return-void
.end method

.method private getHorizontalRange()[I
    .registers 4

    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mHorizontalRange:[I

    iget v1, p0, Landroidx/recyclerview/widget/FastScroller;->mMargin:I

    const/4 v2, 0x0

    aput v1, v0, v2

    iget v2, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerViewWidth:I

    sub-int/2addr v2, v1

    const/4 v1, 0x1

    aput v2, v0, v1

    return-object v0
.end method

.method private getVerticalRange()[I
    .registers 4

    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalRange:[I

    iget v1, p0, Landroidx/recyclerview/widget/FastScroller;->mMargin:I

    const/4 v2, 0x0

    aput v1, v0, v2

    iget v2, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerViewHeight:I

    sub-int/2addr v2, v1

    const/4 v1, 0x1

    aput v2, v0, v1

    return-object v0
.end method

.method private horizontalScrollTo(F)V
    .registers 10

    invoke-direct {p0}, Landroidx/recyclerview/widget/FastScroller;->getHorizontalRange()[I

    move-result-object v3

    const/4 v7, 0x0

    aget v0, v3, v7

    int-to-float v0, v0

    const/4 v1, 0x1

    aget v1, v3, v1

    int-to-float v1, v1

    invoke-static {v1, p1}, Ljava/lang/Math;->min(FF)F

    move-result p1

    invoke-static {v0, p1}, Ljava/lang/Math;->max(FF)F

    move-result p1

    iget v0, p0, Landroidx/recyclerview/widget/FastScroller;->mHorizontalThumbCenterX:I

    int-to-float v0, v0

    sub-float/2addr v0, p1

    invoke-static {v0}, Ljava/lang/Math;->abs(F)F

    move-result v0

    const/high16 v1, 0x40000000    # 2.0f

    cmpg-float v0, v0, v1

    if-gez v0, :cond_23

    return-void

    :cond_23
    iget v1, p0, Landroidx/recyclerview/widget/FastScroller;->mHorizontalDragX:F

    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v0}, Landroidx/recyclerview/widget/RecyclerView;->computeHorizontalScrollRange()I

    move-result v4

    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v0}, Landroidx/recyclerview/widget/RecyclerView;->computeHorizontalScrollOffset()I

    move-result v5

    iget v6, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerViewWidth:I

    move-object v0, p0

    move v2, p1

    invoke-direct/range {v0 .. v6}, Landroidx/recyclerview/widget/FastScroller;->scrollTo(FF[IIII)I

    move-result v0

    if-eqz v0, :cond_40

    iget-object v1, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v1, v0, v7}, Landroidx/recyclerview/widget/RecyclerView;->scrollBy(II)V

    :cond_40
    iput p1, p0, Landroidx/recyclerview/widget/FastScroller;->mHorizontalDragX:F

    return-void
.end method

.method private isLayoutRTL()Z
    .registers 3

    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-static {v0}, Landroidx/core/view/ViewCompat;->getLayoutDirection(Landroid/view/View;)I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_a

    goto :goto_b

    :cond_a
    const/4 v1, 0x0

    :goto_b
    return v1
.end method

.method private resetHideDelay(I)V
    .registers 6

    invoke-direct {p0}, Landroidx/recyclerview/widget/FastScroller;->cancelHide()V

    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    iget-object v1, p0, Landroidx/recyclerview/widget/FastScroller;->mHideRunnable:Ljava/lang/Runnable;

    int-to-long v2, p1

    invoke-virtual {v0, v1, v2, v3}, Landroidx/recyclerview/widget/RecyclerView;->postDelayed(Ljava/lang/Runnable;J)Z

    return-void
.end method

.method private scrollTo(FF[IIII)I
    .registers 9

    const/4 v0, 0x1

    aget v0, p3, v0

    const/4 v1, 0x0

    aget p3, p3, v1

    sub-int/2addr v0, p3

    if-nez v0, :cond_a

    return v1

    :cond_a
    sub-float/2addr p2, p1

    int-to-float p1, v0

    div-float/2addr p2, p1

    sub-int/2addr p4, p6

    int-to-float p1, p4

    mul-float/2addr p2, p1

    float-to-int p1, p2

    add-int/2addr p5, p1

    if-ge p5, p4, :cond_17

    if-ltz p5, :cond_17

    return p1

    :cond_17
    return v1
.end method

.method private setupCallbacks()V
    .registers 3

    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v0, p0}, Landroidx/recyclerview/widget/RecyclerView;->addItemDecoration(Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;)V

    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v0, p0}, Landroidx/recyclerview/widget/RecyclerView;->addOnItemTouchListener(Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;)V

    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    iget-object v1, p0, Landroidx/recyclerview/widget/FastScroller;->mOnScrollListener:Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;

    invoke-virtual {v0, v1}, Landroidx/recyclerview/widget/RecyclerView;->addOnScrollListener(Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)V

    return-void
.end method

.method private verticalScrollTo(F)V
    .registers 10

    invoke-direct {p0}, Landroidx/recyclerview/widget/FastScroller;->getVerticalRange()[I

    move-result-object v3

    const/4 v7, 0x0

    aget v0, v3, v7

    int-to-float v0, v0

    const/4 v1, 0x1

    aget v1, v3, v1

    int-to-float v1, v1

    invoke-static {v1, p1}, Ljava/lang/Math;->min(FF)F

    move-result p1

    invoke-static {v0, p1}, Ljava/lang/Math;->max(FF)F

    move-result p1

    iget v0, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalThumbCenterY:I

    int-to-float v0, v0

    sub-float/2addr v0, p1

    invoke-static {v0}, Ljava/lang/Math;->abs(F)F

    move-result v0

    const/high16 v1, 0x40000000    # 2.0f

    cmpg-float v0, v0, v1

    if-gez v0, :cond_23

    return-void

    :cond_23
    iget v1, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalDragY:F

    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v0}, Landroidx/recyclerview/widget/RecyclerView;->computeVerticalScrollRange()I

    move-result v4

    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v0}, Landroidx/recyclerview/widget/RecyclerView;->computeVerticalScrollOffset()I

    move-result v5

    iget v6, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerViewHeight:I

    move-object v0, p0

    move v2, p1

    invoke-direct/range {v0 .. v6}, Landroidx/recyclerview/widget/FastScroller;->scrollTo(FF[IIII)I

    move-result v0

    if-eqz v0, :cond_40

    iget-object v1, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v1, v7, v0}, Landroidx/recyclerview/widget/RecyclerView;->scrollBy(II)V

    :cond_40
    iput p1, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalDragY:F

    return-void
.end method


# virtual methods
.method public attachToRecyclerView(Landroidx/recyclerview/widget/RecyclerView;)V
    .registers 3

    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    if-ne v0, p1, :cond_5

    return-void

    :cond_5
    if-eqz v0, :cond_a

    invoke-direct {p0}, Landroidx/recyclerview/widget/FastScroller;->destroyCallbacks()V

    :cond_a
    iput-object p1, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    if-eqz p1, :cond_11

    invoke-direct {p0}, Landroidx/recyclerview/widget/FastScroller;->setupCallbacks()V

    :cond_11
    return-void
.end method

.method getHorizontalThumbDrawable()Landroid/graphics/drawable/Drawable;
    .registers 2

    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mHorizontalThumbDrawable:Landroid/graphics/drawable/StateListDrawable;

    return-object v0
.end method

.method getHorizontalTrackDrawable()Landroid/graphics/drawable/Drawable;
    .registers 2

    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mHorizontalTrackDrawable:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method getVerticalThumbDrawable()Landroid/graphics/drawable/Drawable;
    .registers 2

    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalThumbDrawable:Landroid/graphics/drawable/StateListDrawable;

    return-object v0
.end method

.method getVerticalTrackDrawable()Landroid/graphics/drawable/Drawable;
    .registers 2

    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalTrackDrawable:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method hide(I)V
    .registers 7

    iget v0, p0, Landroidx/recyclerview/widget/FastScroller;->mAnimationState:I

    const/4 v1, 0x2

    const/4 v2, 0x1

    if-eq v0, v2, :cond_9

    if-eq v0, v1, :cond_e

    goto :goto_33

    :cond_9
    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mShowHideAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->cancel()V

    :cond_e
    const/4 v0, 0x3

    iput v0, p0, Landroidx/recyclerview/widget/FastScroller;->mAnimationState:I

    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mShowHideAnimator:Landroid/animation/ValueAnimator;

    new-array v1, v1, [F

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Float;

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v3

    const/4 v4, 0x0

    aput v3, v1, v4

    const/4 v3, 0x0

    aput v3, v1, v2

    invoke-virtual {v0, v1}, Landroid/animation/ValueAnimator;->setFloatValues([F)V

    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mShowHideAnimator:Landroid/animation/ValueAnimator;

    int-to-long v1, p1

    invoke-virtual {v0, v1, v2}, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;

    iget-object p1, p0, Landroidx/recyclerview/widget/FastScroller;->mShowHideAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {p1}, Landroid/animation/ValueAnimator;->start()V

    :goto_33
    return-void
.end method

.method public isDragging()Z
    .registers 3

    iget v0, p0, Landroidx/recyclerview/widget/FastScroller;->mState:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_7

    const/4 v0, 0x1

    goto :goto_8

    :cond_7
    const/4 v0, 0x0

    :goto_8
    return v0
.end method

.method isPointInsideHorizontalThumb(FF)Z
    .registers 5

    iget v0, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerViewHeight:I

    iget v1, p0, Landroidx/recyclerview/widget/FastScroller;->mHorizontalThumbHeight:I

    sub-int/2addr v0, v1

    int-to-float v0, v0

    cmpl-float p2, p2, v0

    if-ltz p2, :cond_21

    iget p2, p0, Landroidx/recyclerview/widget/FastScroller;->mHorizontalThumbCenterX:I

    iget v0, p0, Landroidx/recyclerview/widget/FastScroller;->mHorizontalThumbWidth:I

    div-int/lit8 v1, v0, 0x2

    sub-int v1, p2, v1

    int-to-float v1, v1

    cmpl-float v1, p1, v1

    if-ltz v1, :cond_21

    div-int/lit8 v0, v0, 0x2

    add-int/2addr p2, v0

    int-to-float p2, p2

    cmpg-float p1, p1, p2

    if-gtz p1, :cond_21

    const/4 p1, 0x1

    goto :goto_22

    :cond_21
    const/4 p1, 0x0

    :goto_22
    return p1
.end method

.method isPointInsideVerticalThumb(FF)Z
    .registers 5

    invoke-direct {p0}, Landroidx/recyclerview/widget/FastScroller;->isLayoutRTL()Z

    move-result v0

    if-eqz v0, :cond_10

    iget v0, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalThumbWidth:I

    div-int/lit8 v0, v0, 0x2

    int-to-float v0, v0

    cmpg-float p1, p1, v0

    if-gtz p1, :cond_31

    goto :goto_1a

    :cond_10
    iget v0, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerViewWidth:I

    iget v1, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalThumbWidth:I

    sub-int/2addr v0, v1

    int-to-float v0, v0

    cmpl-float p1, p1, v0

    if-ltz p1, :cond_31

    :goto_1a
    iget p1, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalThumbCenterY:I

    iget v0, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalThumbHeight:I

    div-int/lit8 v1, v0, 0x2

    sub-int v1, p1, v1

    int-to-float v1, v1

    cmpl-float v1, p2, v1

    if-ltz v1, :cond_31

    div-int/lit8 v0, v0, 0x2

    add-int/2addr p1, v0

    int-to-float p1, p1

    cmpg-float p1, p2, p1

    if-gtz p1, :cond_31

    const/4 p1, 0x1

    goto :goto_32

    :cond_31
    const/4 p1, 0x0

    :goto_32
    return p1
.end method

.method isVisible()Z
    .registers 3

    iget v0, p0, Landroidx/recyclerview/widget/FastScroller;->mState:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_6

    goto :goto_7

    :cond_6
    const/4 v1, 0x0

    :goto_7
    return v1
.end method

.method public onDrawOver(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V
    .registers 4

    iget p2, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerViewWidth:I

    iget-object p3, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {p3}, Landroidx/recyclerview/widget/RecyclerView;->getWidth()I

    move-result p3

    if-ne p2, p3, :cond_28

    iget p2, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerViewHeight:I

    iget-object p3, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {p3}, Landroidx/recyclerview/widget/RecyclerView;->getHeight()I

    move-result p3

    if-eq p2, p3, :cond_15

    goto :goto_28

    :cond_15
    iget p2, p0, Landroidx/recyclerview/widget/FastScroller;->mAnimationState:I

    if-eqz p2, :cond_27

    iget-boolean p2, p0, Landroidx/recyclerview/widget/FastScroller;->mNeedVerticalScrollbar:Z

    if-eqz p2, :cond_20

    invoke-direct {p0, p1}, Landroidx/recyclerview/widget/FastScroller;->drawVerticalScrollbar(Landroid/graphics/Canvas;)V

    :cond_20
    iget-boolean p2, p0, Landroidx/recyclerview/widget/FastScroller;->mNeedHorizontalScrollbar:Z

    if-eqz p2, :cond_27

    invoke-direct {p0, p1}, Landroidx/recyclerview/widget/FastScroller;->drawHorizontalScrollbar(Landroid/graphics/Canvas;)V

    :cond_27
    return-void

    :cond_28
    :goto_28
    iget-object p1, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {p1}, Landroidx/recyclerview/widget/RecyclerView;->getWidth()I

    move-result p1

    iput p1, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerViewWidth:I

    iget-object p1, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {p1}, Landroidx/recyclerview/widget/RecyclerView;->getHeight()I

    move-result p1

    iput p1, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerViewHeight:I

    const/4 p1, 0x0

    invoke-virtual {p0, p1}, Landroidx/recyclerview/widget/FastScroller;->setState(I)V

    return-void
.end method

.method public onInterceptTouchEvent(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)Z
    .registers 8

    iget p1, p0, Landroidx/recyclerview/widget/FastScroller;->mState:I

    const/4 v0, 0x0

    const/4 v1, 0x2

    const/4 v2, 0x1

    if-ne p1, v2, :cond_46

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getX()F

    move-result p1

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getY()F

    move-result v3

    invoke-virtual {p0, p1, v3}, Landroidx/recyclerview/widget/FastScroller;->isPointInsideVerticalThumb(FF)Z

    move-result p1

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getX()F

    move-result v3

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getY()F

    move-result v4

    invoke-virtual {p0, v3, v4}, Landroidx/recyclerview/widget/FastScroller;->isPointInsideHorizontalThumb(FF)Z

    move-result v3

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v4

    if-nez v4, :cond_49

    if-nez p1, :cond_29

    if-eqz v3, :cond_49

    :cond_29
    if-eqz v3, :cond_36

    iput v2, p0, Landroidx/recyclerview/widget/FastScroller;->mDragState:I

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getX()F

    move-result p1

    float-to-int p1, p1

    int-to-float p1, p1

    iput p1, p0, Landroidx/recyclerview/widget/FastScroller;->mHorizontalDragX:F

    goto :goto_42

    :cond_36
    if-eqz p1, :cond_42

    iput v1, p0, Landroidx/recyclerview/widget/FastScroller;->mDragState:I

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getY()F

    move-result p1

    float-to-int p1, p1

    int-to-float p1, p1

    iput p1, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalDragY:F

    :cond_42
    :goto_42
    invoke-virtual {p0, v1}, Landroidx/recyclerview/widget/FastScroller;->setState(I)V

    goto :goto_48

    :cond_46
    if-ne p1, v1, :cond_49

    :goto_48
    move v0, v2

    :cond_49
    return v0
.end method

.method public onRequestDisallowInterceptTouchEvent(Z)V
    .registers 2

    return-void
.end method

.method public onTouchEvent(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V
    .registers 7

    iget p1, p0, Landroidx/recyclerview/widget/FastScroller;->mState:I

    if-nez p1, :cond_5

    return-void

    :cond_5
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result p1

    const/4 v0, 0x1

    const/4 v1, 0x2

    if-nez p1, :cond_46

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getX()F

    move-result p1

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getY()F

    move-result v2

    invoke-virtual {p0, p1, v2}, Landroidx/recyclerview/widget/FastScroller;->isPointInsideVerticalThumb(FF)Z

    move-result p1

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getX()F

    move-result v2

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getY()F

    move-result v3

    invoke-virtual {p0, v2, v3}, Landroidx/recyclerview/widget/FastScroller;->isPointInsideHorizontalThumb(FF)Z

    move-result v2

    if-nez p1, :cond_29

    if-eqz v2, :cond_7f

    :cond_29
    if-eqz v2, :cond_36

    iput v0, p0, Landroidx/recyclerview/widget/FastScroller;->mDragState:I

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getX()F

    move-result p1

    float-to-int p1, p1

    int-to-float p1, p1

    iput p1, p0, Landroidx/recyclerview/widget/FastScroller;->mHorizontalDragX:F

    goto :goto_42

    :cond_36
    if-eqz p1, :cond_42

    iput v1, p0, Landroidx/recyclerview/widget/FastScroller;->mDragState:I

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getY()F

    move-result p1

    float-to-int p1, p1

    int-to-float p1, p1

    iput p1, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalDragY:F

    :cond_42
    :goto_42
    invoke-virtual {p0, v1}, Landroidx/recyclerview/widget/FastScroller;->setState(I)V

    goto :goto_7f

    :cond_46
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result p1

    if-ne p1, v0, :cond_5c

    iget p1, p0, Landroidx/recyclerview/widget/FastScroller;->mState:I

    if-ne p1, v1, :cond_5c

    const/4 p1, 0x0

    iput p1, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalDragY:F

    iput p1, p0, Landroidx/recyclerview/widget/FastScroller;->mHorizontalDragX:F

    invoke-virtual {p0, v0}, Landroidx/recyclerview/widget/FastScroller;->setState(I)V

    const/4 p1, 0x0

    iput p1, p0, Landroidx/recyclerview/widget/FastScroller;->mDragState:I

    goto :goto_7f

    :cond_5c
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result p1

    if-ne p1, v1, :cond_7f

    iget p1, p0, Landroidx/recyclerview/widget/FastScroller;->mState:I

    if-ne p1, v1, :cond_7f

    invoke-virtual {p0}, Landroidx/recyclerview/widget/FastScroller;->show()V

    iget p1, p0, Landroidx/recyclerview/widget/FastScroller;->mDragState:I

    if-ne p1, v0, :cond_74

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getX()F

    move-result p1

    invoke-direct {p0, p1}, Landroidx/recyclerview/widget/FastScroller;->horizontalScrollTo(F)V

    :cond_74
    iget p1, p0, Landroidx/recyclerview/widget/FastScroller;->mDragState:I

    if-ne p1, v1, :cond_7f

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getY()F

    move-result p1

    invoke-direct {p0, p1}, Landroidx/recyclerview/widget/FastScroller;->verticalScrollTo(F)V

    :cond_7f
    :goto_7f
    return-void
.end method

.method requestRedraw()V
    .registers 2

    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v0}, Landroidx/recyclerview/widget/RecyclerView;->invalidate()V

    return-void
.end method

.method setState(I)V
    .registers 5

    const/4 v0, 0x2

    if-ne p1, v0, :cond_11

    iget v1, p0, Landroidx/recyclerview/widget/FastScroller;->mState:I

    if-eq v1, v0, :cond_11

    iget-object v1, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalThumbDrawable:Landroid/graphics/drawable/StateListDrawable;

    sget-object v2, Landroidx/recyclerview/widget/FastScroller;->PRESSED_STATE_SET:[I

    invoke-virtual {v1, v2}, Landroid/graphics/drawable/StateListDrawable;->setState([I)Z

    invoke-direct {p0}, Landroidx/recyclerview/widget/FastScroller;->cancelHide()V

    :cond_11
    if-nez p1, :cond_17

    invoke-virtual {p0}, Landroidx/recyclerview/widget/FastScroller;->requestRedraw()V

    goto :goto_1a

    :cond_17
    invoke-virtual {p0}, Landroidx/recyclerview/widget/FastScroller;->show()V

    :goto_1a
    iget v1, p0, Landroidx/recyclerview/widget/FastScroller;->mState:I

    if-ne v1, v0, :cond_2d

    if-eq p1, v0, :cond_2d

    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalThumbDrawable:Landroid/graphics/drawable/StateListDrawable;

    sget-object v1, Landroidx/recyclerview/widget/FastScroller;->EMPTY_STATE_SET:[I

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/StateListDrawable;->setState([I)Z

    const/16 v0, 0x4b0

    invoke-direct {p0, v0}, Landroidx/recyclerview/widget/FastScroller;->resetHideDelay(I)V

    goto :goto_35

    :cond_2d
    const/4 v0, 0x1

    if-ne p1, v0, :cond_35

    const/16 v0, 0x5dc

    invoke-direct {p0, v0}, Landroidx/recyclerview/widget/FastScroller;->resetHideDelay(I)V

    :cond_35
    :goto_35
    iput p1, p0, Landroidx/recyclerview/widget/FastScroller;->mState:I

    return-void
.end method

.method public show()V
    .registers 6

    iget v0, p0, Landroidx/recyclerview/widget/FastScroller;->mAnimationState:I

    if-eqz v0, :cond_d

    const/4 v1, 0x3

    if-eq v0, v1, :cond_8

    goto :goto_3c

    :cond_8
    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mShowHideAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->cancel()V

    :cond_d
    const/4 v0, 0x1

    iput v0, p0, Landroidx/recyclerview/widget/FastScroller;->mAnimationState:I

    iget-object v1, p0, Landroidx/recyclerview/widget/FastScroller;->mShowHideAnimator:Landroid/animation/ValueAnimator;

    const/4 v2, 0x2

    new-array v2, v2, [F

    invoke-virtual {v1}, Landroid/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Float;

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v3

    const/4 v4, 0x0

    aput v3, v2, v4

    const/high16 v3, 0x3f800000    # 1.0f

    aput v3, v2, v0

    invoke-virtual {v1, v2}, Landroid/animation/ValueAnimator;->setFloatValues([F)V

    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mShowHideAnimator:Landroid/animation/ValueAnimator;

    const-wide/16 v1, 0x1f4

    invoke-virtual {v0, v1, v2}, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;

    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mShowHideAnimator:Landroid/animation/ValueAnimator;

    const-wide/16 v1, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/animation/ValueAnimator;->setStartDelay(J)V

    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mShowHideAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->start()V

    :goto_3c
    return-void
.end method

.method updateScrollPosition(II)V
    .registers 11

    iget-object v0, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v0}, Landroidx/recyclerview/widget/RecyclerView;->computeVerticalScrollRange()I

    move-result v0

    iget v1, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerViewHeight:I

    sub-int v2, v0, v1

    const/4 v3, 0x0

    const/4 v4, 0x1

    if-lez v2, :cond_14

    iget v2, p0, Landroidx/recyclerview/widget/FastScroller;->mScrollbarMinimumRange:I

    if-lt v1, v2, :cond_14

    move v2, v4

    goto :goto_15

    :cond_14
    move v2, v3

    :goto_15
    iput-boolean v2, p0, Landroidx/recyclerview/widget/FastScroller;->mNeedVerticalScrollbar:Z

    iget-object v2, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v2}, Landroidx/recyclerview/widget/RecyclerView;->computeHorizontalScrollRange()I

    move-result v2

    iget v5, p0, Landroidx/recyclerview/widget/FastScroller;->mRecyclerViewWidth:I

    sub-int v6, v2, v5

    if-lez v6, :cond_29

    iget v6, p0, Landroidx/recyclerview/widget/FastScroller;->mScrollbarMinimumRange:I

    if-lt v5, v6, :cond_29

    move v6, v4

    goto :goto_2a

    :cond_29
    move v6, v3

    :goto_2a
    iput-boolean v6, p0, Landroidx/recyclerview/widget/FastScroller;->mNeedHorizontalScrollbar:Z

    iget-boolean v7, p0, Landroidx/recyclerview/widget/FastScroller;->mNeedVerticalScrollbar:Z

    if-nez v7, :cond_3a

    if-nez v6, :cond_3a

    iget p1, p0, Landroidx/recyclerview/widget/FastScroller;->mState:I

    if-eqz p1, :cond_39

    invoke-virtual {p0, v3}, Landroidx/recyclerview/widget/FastScroller;->setState(I)V

    :cond_39
    return-void

    :cond_3a
    const/high16 v3, 0x40000000    # 2.0f

    if-eqz v7, :cond_52

    int-to-float p2, p2

    int-to-float v6, v1

    div-float v7, v6, v3

    add-float/2addr p2, v7

    mul-float/2addr v6, p2

    int-to-float p2, v0

    div-float/2addr v6, p2

    float-to-int p2, v6

    iput p2, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalThumbCenterY:I

    mul-int p2, v1, v1

    div-int/2addr p2, v0

    invoke-static {v1, p2}, Ljava/lang/Math;->min(II)I

    move-result p2

    iput p2, p0, Landroidx/recyclerview/widget/FastScroller;->mVerticalThumbHeight:I

    :cond_52
    iget-boolean p2, p0, Landroidx/recyclerview/widget/FastScroller;->mNeedHorizontalScrollbar:Z

    if-eqz p2, :cond_6a

    int-to-float p1, p1

    int-to-float p2, v5

    div-float v0, p2, v3

    add-float/2addr p1, v0

    mul-float/2addr p2, p1

    int-to-float p1, v2

    div-float/2addr p2, p1

    float-to-int p1, p2

    iput p1, p0, Landroidx/recyclerview/widget/FastScroller;->mHorizontalThumbCenterX:I

    mul-int p1, v5, v5

    div-int/2addr p1, v2

    invoke-static {v5, p1}, Ljava/lang/Math;->min(II)I

    move-result p1

    iput p1, p0, Landroidx/recyclerview/widget/FastScroller;->mHorizontalThumbWidth:I

    :cond_6a
    iget p1, p0, Landroidx/recyclerview/widget/FastScroller;->mState:I

    if-eqz p1, :cond_70

    if-ne p1, v4, :cond_73

    :cond_70
    invoke-virtual {p0, v4}, Landroidx/recyclerview/widget/FastScroller;->setState(I)V

    :cond_73
    return-void
.end method
