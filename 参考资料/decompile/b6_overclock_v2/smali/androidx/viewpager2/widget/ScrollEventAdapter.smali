.class final Landroidx/viewpager2/widget/ScrollEventAdapter;
.super Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;
.source "ScrollEventAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;
    }
.end annotation


# static fields
.field private static final NO_POSITION:I = -0x1

.field private static final STATE_IDLE:I = 0x0

.field private static final STATE_IN_PROGRESS_FAKE_DRAG:I = 0x4

.field private static final STATE_IN_PROGRESS_IMMEDIATE_SCROLL:I = 0x3

.field private static final STATE_IN_PROGRESS_MANUAL_DRAG:I = 0x1

.field private static final STATE_IN_PROGRESS_SMOOTH_SCROLL:I = 0x2


# instance fields
.field private mAdapterState:I

.field private mCallback:Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;

.field private mDataSetChangeHappened:Z

.field private mDispatchSelected:Z

.field private mDragStartPosition:I

.field private mFakeDragging:Z

.field private final mLayoutManager:Landroidx/recyclerview/widget/LinearLayoutManager;

.field private final mRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

.field private mScrollHappened:Z

.field private mScrollState:I

.field private mScrollValues:Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;

.field private mTarget:I

.field private final mViewPager:Landroidx/viewpager2/widget/ViewPager2;


# direct methods
.method constructor <init>(Landroidx/viewpager2/widget/ViewPager2;)V
    .registers 2

    invoke-direct {p0}, Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;-><init>()V

    iput-object p1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mViewPager:Landroidx/viewpager2/widget/ViewPager2;

    iget-object p1, p1, Landroidx/viewpager2/widget/ViewPager2;->mRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    iput-object p1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {p1}, Landroidx/recyclerview/widget/RecyclerView;->getLayoutManager()Landroidx/recyclerview/widget/RecyclerView$LayoutManager;

    move-result-object p1

    check-cast p1, Landroidx/recyclerview/widget/LinearLayoutManager;

    iput-object p1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mLayoutManager:Landroidx/recyclerview/widget/LinearLayoutManager;

    new-instance p1, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;

    invoke-direct {p1}, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;-><init>()V

    iput-object p1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollValues:Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;

    invoke-direct {p0}, Landroidx/viewpager2/widget/ScrollEventAdapter;->resetState()V

    return-void
.end method

.method private dispatchScrolled(IFI)V
    .registers 5

    iget-object v0, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mCallback:Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;

    if-eqz v0, :cond_7

    invoke-virtual {v0, p1, p2, p3}, Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;->onPageScrolled(IFI)V

    :cond_7
    return-void
.end method

.method private dispatchSelected(I)V
    .registers 3

    iget-object v0, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mCallback:Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;

    if-eqz v0, :cond_7

    invoke-virtual {v0, p1}, Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;->onPageSelected(I)V

    :cond_7
    return-void
.end method

.method private dispatchStateChanged(I)V
    .registers 4

    iget v0, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mAdapterState:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_a

    iget v0, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollState:I

    if-nez v0, :cond_a

    return-void

    :cond_a
    iget v0, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollState:I

    if-ne v0, p1, :cond_f

    return-void

    :cond_f
    iput p1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollState:I

    iget-object v0, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mCallback:Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;

    if-eqz v0, :cond_18

    invoke-virtual {v0, p1}, Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;->onPageScrollStateChanged(I)V

    :cond_18
    return-void
.end method

.method private getPosition()I
    .registers 2

    iget-object v0, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mLayoutManager:Landroidx/recyclerview/widget/LinearLayoutManager;

    invoke-virtual {v0}, Landroidx/recyclerview/widget/LinearLayoutManager;->findFirstVisibleItemPosition()I

    move-result v0

    return v0
.end method

.method private isInAnyDraggingState()Z
    .registers 4

    iget v0, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mAdapterState:I

    const/4 v1, 0x1

    if-eq v0, v1, :cond_a

    const/4 v2, 0x4

    if-ne v0, v2, :cond_9

    goto :goto_a

    :cond_9
    const/4 v1, 0x0

    :cond_a
    :goto_a
    return v1
.end method

.method private resetState()V
    .registers 3

    const/4 v0, 0x0

    iput v0, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mAdapterState:I

    iput v0, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollState:I

    iget-object v1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollValues:Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;

    invoke-virtual {v1}, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->reset()V

    const/4 v1, -0x1

    iput v1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mDragStartPosition:I

    iput v1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mTarget:I

    iput-boolean v0, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mDispatchSelected:Z

    iput-boolean v0, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollHappened:Z

    iput-boolean v0, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mFakeDragging:Z

    iput-boolean v0, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mDataSetChangeHappened:Z

    return-void
.end method

.method private startDrag(Z)V
    .registers 4

    iput-boolean p1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mFakeDragging:Z

    const/4 v0, 0x1

    if-eqz p1, :cond_7

    const/4 p1, 0x4

    goto :goto_8

    :cond_7
    move p1, v0

    :goto_8
    iput p1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mAdapterState:I

    iget p1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mTarget:I

    const/4 v1, -0x1

    if-eq p1, v1, :cond_14

    iput p1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mDragStartPosition:I

    iput v1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mTarget:I

    goto :goto_1e

    :cond_14
    iget p1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mDragStartPosition:I

    if-ne p1, v1, :cond_1e

    invoke-direct {p0}, Landroidx/viewpager2/widget/ScrollEventAdapter;->getPosition()I

    move-result p1

    iput p1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mDragStartPosition:I

    :cond_1e
    :goto_1e
    invoke-direct {p0, v0}, Landroidx/viewpager2/widget/ScrollEventAdapter;->dispatchStateChanged(I)V

    return-void
.end method

.method private updateScrollEventValues()V
    .registers 10

    iget-object v0, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollValues:Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;

    iget-object v1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mLayoutManager:Landroidx/recyclerview/widget/LinearLayoutManager;

    invoke-virtual {v1}, Landroidx/recyclerview/widget/LinearLayoutManager;->findFirstVisibleItemPosition()I

    move-result v1

    iput v1, v0, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mPosition:I

    iget v1, v0, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mPosition:I

    const/4 v2, -0x1

    if-ne v1, v2, :cond_13

    invoke-virtual {v0}, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->reset()V

    return-void

    :cond_13
    iget-object v1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mLayoutManager:Landroidx/recyclerview/widget/LinearLayoutManager;

    iget v2, v0, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mPosition:I

    invoke-virtual {v1, v2}, Landroidx/recyclerview/widget/LinearLayoutManager;->findViewByPosition(I)Landroid/view/View;

    move-result-object v1

    if-nez v1, :cond_21

    invoke-virtual {v0}, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->reset()V

    return-void

    :cond_21
    iget-object v2, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mLayoutManager:Landroidx/recyclerview/widget/LinearLayoutManager;

    invoke-virtual {v2, v1}, Landroidx/recyclerview/widget/LinearLayoutManager;->getLeftDecorationWidth(Landroid/view/View;)I

    move-result v2

    iget-object v3, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mLayoutManager:Landroidx/recyclerview/widget/LinearLayoutManager;

    invoke-virtual {v3, v1}, Landroidx/recyclerview/widget/LinearLayoutManager;->getRightDecorationWidth(Landroid/view/View;)I

    move-result v3

    iget-object v4, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mLayoutManager:Landroidx/recyclerview/widget/LinearLayoutManager;

    invoke-virtual {v4, v1}, Landroidx/recyclerview/widget/LinearLayoutManager;->getTopDecorationHeight(Landroid/view/View;)I

    move-result v4

    iget-object v5, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mLayoutManager:Landroidx/recyclerview/widget/LinearLayoutManager;

    invoke-virtual {v5, v1}, Landroidx/recyclerview/widget/LinearLayoutManager;->getBottomDecorationHeight(Landroid/view/View;)I

    move-result v5

    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v6

    instance-of v7, v6, Landroid/view/ViewGroup$MarginLayoutParams;

    if-eqz v7, :cond_4f

    check-cast v6, Landroid/view/ViewGroup$MarginLayoutParams;

    iget v7, v6, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    add-int/2addr v2, v7

    iget v7, v6, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    add-int/2addr v3, v7

    iget v7, v6, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    add-int/2addr v4, v7

    iget v6, v6, Landroid/view/ViewGroup$MarginLayoutParams;->bottomMargin:I

    add-int/2addr v5, v6

    :cond_4f
    invoke-virtual {v1}, Landroid/view/View;->getHeight()I

    move-result v6

    add-int/2addr v6, v4

    add-int/2addr v6, v5

    invoke-virtual {v1}, Landroid/view/View;->getWidth()I

    move-result v5

    add-int/2addr v5, v2

    add-int/2addr v5, v3

    iget-object v3, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mLayoutManager:Landroidx/recyclerview/widget/LinearLayoutManager;

    invoke-virtual {v3}, Landroidx/recyclerview/widget/LinearLayoutManager;->getOrientation()I

    move-result v3

    const/4 v7, 0x1

    const/4 v8, 0x0

    if-nez v3, :cond_67

    move v3, v7

    goto :goto_68

    :cond_67
    move v3, v8

    :goto_68
    if-eqz v3, :cond_81

    invoke-virtual {v1}, Landroid/view/View;->getLeft()I

    move-result v1

    sub-int/2addr v1, v2

    iget-object v2, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v2}, Landroidx/recyclerview/widget/RecyclerView;->getPaddingLeft()I

    move-result v2

    sub-int/2addr v1, v2

    iget-object v2, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mViewPager:Landroidx/viewpager2/widget/ViewPager2;

    invoke-virtual {v2}, Landroidx/viewpager2/widget/ViewPager2;->isRtl()Z

    move-result v2

    if-eqz v2, :cond_7f

    neg-int v1, v1

    :cond_7f
    move v6, v5

    goto :goto_8d

    :cond_81
    invoke-virtual {v1}, Landroid/view/View;->getTop()I

    move-result v1

    sub-int/2addr v1, v4

    iget-object v2, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v2}, Landroidx/recyclerview/widget/RecyclerView;->getPaddingTop()I

    move-result v2

    sub-int/2addr v1, v2

    :goto_8d
    neg-int v1, v1

    iput v1, v0, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mOffsetPx:I

    iget v1, v0, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mOffsetPx:I

    if-gez v1, :cond_c1

    new-instance v1, Landroidx/viewpager2/widget/AnimateLayoutChangeDetector;

    iget-object v2, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mLayoutManager:Landroidx/recyclerview/widget/LinearLayoutManager;

    invoke-direct {v1, v2}, Landroidx/viewpager2/widget/AnimateLayoutChangeDetector;-><init>(Landroidx/recyclerview/widget/LinearLayoutManager;)V

    invoke-virtual {v1}, Landroidx/viewpager2/widget/AnimateLayoutChangeDetector;->mayHaveInterferingAnimations()Z

    move-result v1

    if-eqz v1, :cond_a9

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_a9
    new-instance v1, Ljava/lang/IllegalStateException;

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    new-array v3, v7, [Ljava/lang/Object;

    iget v0, v0, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mOffsetPx:I

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    aput-object v0, v3, v8

    const-string v0, "Page can only be offset by a positive amount, not by %d"

    invoke-static {v2, v0, v3}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_c1
    if-nez v6, :cond_c5

    const/4 v1, 0x0

    goto :goto_ca

    :cond_c5
    iget v1, v0, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mOffsetPx:I

    int-to-float v1, v1

    int-to-float v2, v6

    div-float/2addr v1, v2

    :goto_ca
    iput v1, v0, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mOffset:F

    return-void
.end method


# virtual methods
.method getRelativeScrollPosition()D
    .registers 5

    invoke-direct {p0}, Landroidx/viewpager2/widget/ScrollEventAdapter;->updateScrollEventValues()V

    iget-object v0, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollValues:Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;

    iget v0, v0, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mPosition:I

    int-to-double v0, v0

    iget-object v2, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollValues:Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;

    iget v2, v2, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mOffset:F

    float-to-double v2, v2

    add-double/2addr v0, v2

    return-wide v0
.end method

.method getScrollState()I
    .registers 2

    iget v0, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollState:I

    return v0
.end method

.method isDragging()Z
    .registers 3

    iget v0, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollState:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_6

    goto :goto_7

    :cond_6
    const/4 v1, 0x0

    :goto_7
    return v1
.end method

.method isFakeDragging()Z
    .registers 2

    iget-boolean v0, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mFakeDragging:Z

    return v0
.end method

.method isIdle()Z
    .registers 2

    iget v0, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollState:I

    if-nez v0, :cond_6

    const/4 v0, 0x1

    goto :goto_7

    :cond_6
    const/4 v0, 0x0

    :goto_7
    return v0
.end method

.method notifyBeginFakeDrag()V
    .registers 2

    const/4 v0, 0x4

    iput v0, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mAdapterState:I

    const/4 v0, 0x1

    invoke-direct {p0, v0}, Landroidx/viewpager2/widget/ScrollEventAdapter;->startDrag(Z)V

    return-void
.end method

.method notifyDataSetChangeHappened()V
    .registers 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mDataSetChangeHappened:Z

    return-void
.end method

.method notifyEndFakeDrag()V
    .registers 4

    invoke-virtual {p0}, Landroidx/viewpager2/widget/ScrollEventAdapter;->isDragging()Z

    move-result v0

    if-eqz v0, :cond_b

    iget-boolean v0, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mFakeDragging:Z

    if-nez v0, :cond_b

    return-void

    :cond_b
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mFakeDragging:Z

    invoke-direct {p0}, Landroidx/viewpager2/widget/ScrollEventAdapter;->updateScrollEventValues()V

    iget-object v1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollValues:Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;

    iget v1, v1, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mOffsetPx:I

    if-nez v1, :cond_2d

    iget-object v1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollValues:Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;

    iget v1, v1, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mPosition:I

    iget v2, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mDragStartPosition:I

    if-eq v1, v2, :cond_26

    iget-object v1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollValues:Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;

    iget v1, v1, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mPosition:I

    invoke-direct {p0, v1}, Landroidx/viewpager2/widget/ScrollEventAdapter;->dispatchSelected(I)V

    :cond_26
    invoke-direct {p0, v0}, Landroidx/viewpager2/widget/ScrollEventAdapter;->dispatchStateChanged(I)V

    invoke-direct {p0}, Landroidx/viewpager2/widget/ScrollEventAdapter;->resetState()V

    goto :goto_31

    :cond_2d
    const/4 v0, 0x2

    invoke-direct {p0, v0}, Landroidx/viewpager2/widget/ScrollEventAdapter;->dispatchStateChanged(I)V

    :goto_31
    return-void
.end method

.method notifyProgrammaticScroll(IZ)V
    .registers 5

    const/4 v0, 0x2

    if-eqz p2, :cond_5

    move p2, v0

    goto :goto_6

    :cond_5
    const/4 p2, 0x3

    :goto_6
    iput p2, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mAdapterState:I

    const/4 p2, 0x0

    iput-boolean p2, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mFakeDragging:Z

    iget v1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mTarget:I

    if-eq v1, p1, :cond_10

    const/4 p2, 0x1

    :cond_10
    iput p1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mTarget:I

    invoke-direct {p0, v0}, Landroidx/viewpager2/widget/ScrollEventAdapter;->dispatchStateChanged(I)V

    if-eqz p2, :cond_1a

    invoke-direct {p0, p1}, Landroidx/viewpager2/widget/ScrollEventAdapter;->dispatchSelected(I)V

    :cond_1a
    return-void
.end method

.method public onScrollStateChanged(Landroidx/recyclerview/widget/RecyclerView;I)V
    .registers 8

    iget p1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mAdapterState:I

    const/4 v0, 0x0

    const/4 v1, 0x1

    if-ne p1, v1, :cond_a

    iget p1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollState:I

    if-eq p1, v1, :cond_10

    :cond_a
    if-ne p2, v1, :cond_10

    invoke-direct {p0, v0}, Landroidx/viewpager2/widget/ScrollEventAdapter;->startDrag(Z)V

    return-void

    :cond_10
    invoke-direct {p0}, Landroidx/viewpager2/widget/ScrollEventAdapter;->isInAnyDraggingState()Z

    move-result p1

    const/4 v2, 0x2

    if-eqz p1, :cond_23

    if-ne p2, v2, :cond_23

    iget-boolean p1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollHappened:Z

    if-eqz p1, :cond_22

    invoke-direct {p0, v2}, Landroidx/viewpager2/widget/ScrollEventAdapter;->dispatchStateChanged(I)V

    iput-boolean v1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mDispatchSelected:Z

    :cond_22
    return-void

    :cond_23
    invoke-direct {p0}, Landroidx/viewpager2/widget/ScrollEventAdapter;->isInAnyDraggingState()Z

    move-result p1

    const/4 v3, -0x1

    if-eqz p1, :cond_61

    if-nez p2, :cond_61

    invoke-direct {p0}, Landroidx/viewpager2/widget/ScrollEventAdapter;->updateScrollEventValues()V

    iget-boolean p1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollHappened:Z

    if-nez p1, :cond_42

    iget-object p1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollValues:Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;

    iget p1, p1, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mPosition:I

    if-eq p1, v3, :cond_59

    iget-object p1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollValues:Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;

    iget p1, p1, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mPosition:I

    const/4 v4, 0x0

    invoke-direct {p0, p1, v4, v0}, Landroidx/viewpager2/widget/ScrollEventAdapter;->dispatchScrolled(IFI)V

    goto :goto_59

    :cond_42
    iget-object p1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollValues:Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;

    iget p1, p1, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mOffsetPx:I

    if-nez p1, :cond_58

    iget p1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mDragStartPosition:I

    iget-object v4, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollValues:Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;

    iget v4, v4, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mPosition:I

    if-eq p1, v4, :cond_59

    iget-object p1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollValues:Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;

    iget p1, p1, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mPosition:I

    invoke-direct {p0, p1}, Landroidx/viewpager2/widget/ScrollEventAdapter;->dispatchSelected(I)V

    goto :goto_59

    :cond_58
    move v1, v0

    :cond_59
    :goto_59
    if-eqz v1, :cond_61

    invoke-direct {p0, v0}, Landroidx/viewpager2/widget/ScrollEventAdapter;->dispatchStateChanged(I)V

    invoke-direct {p0}, Landroidx/viewpager2/widget/ScrollEventAdapter;->resetState()V

    :cond_61
    iget p1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mAdapterState:I

    if-ne p1, v2, :cond_91

    if-nez p2, :cond_91

    iget-boolean p1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mDataSetChangeHappened:Z

    if-eqz p1, :cond_91

    invoke-direct {p0}, Landroidx/viewpager2/widget/ScrollEventAdapter;->updateScrollEventValues()V

    iget-object p1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollValues:Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;

    iget p1, p1, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mOffsetPx:I

    if-nez p1, :cond_91

    iget p1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mTarget:I

    iget-object p2, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollValues:Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;

    iget p2, p2, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mPosition:I

    if-eq p1, p2, :cond_8b

    iget-object p1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollValues:Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;

    iget p1, p1, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mPosition:I

    if-ne p1, v3, :cond_84

    move p1, v0

    goto :goto_88

    :cond_84
    iget-object p1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollValues:Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;

    iget p1, p1, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mPosition:I

    :goto_88
    invoke-direct {p0, p1}, Landroidx/viewpager2/widget/ScrollEventAdapter;->dispatchSelected(I)V

    :cond_8b
    invoke-direct {p0, v0}, Landroidx/viewpager2/widget/ScrollEventAdapter;->dispatchStateChanged(I)V

    invoke-direct {p0}, Landroidx/viewpager2/widget/ScrollEventAdapter;->resetState()V

    :cond_91
    return-void
.end method

.method public onScrolled(Landroidx/recyclerview/widget/RecyclerView;II)V
    .registers 7

    const/4 p1, 0x1

    iput-boolean p1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollHappened:Z

    invoke-direct {p0}, Landroidx/viewpager2/widget/ScrollEventAdapter;->updateScrollEventValues()V

    iget-boolean v0, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mDispatchSelected:Z

    const/4 v1, -0x1

    const/4 v2, 0x0

    if-eqz v0, :cond_3f

    iput-boolean v2, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mDispatchSelected:Z

    if-gtz p3, :cond_22

    if-nez p3, :cond_20

    if-gez p2, :cond_16

    move p2, p1

    goto :goto_17

    :cond_16
    move p2, v2

    :goto_17
    iget-object p3, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mViewPager:Landroidx/viewpager2/widget/ViewPager2;

    invoke-virtual {p3}, Landroidx/viewpager2/widget/ViewPager2;->isRtl()Z

    move-result p3

    if-ne p2, p3, :cond_20

    goto :goto_22

    :cond_20
    move p2, v2

    goto :goto_23

    :cond_22
    :goto_22
    move p2, p1

    :goto_23
    if-eqz p2, :cond_31

    iget-object p2, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollValues:Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;

    iget p2, p2, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mOffsetPx:I

    if-eqz p2, :cond_31

    iget-object p2, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollValues:Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;

    iget p2, p2, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mPosition:I

    add-int/2addr p2, p1

    goto :goto_35

    :cond_31
    iget-object p2, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollValues:Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;

    iget p2, p2, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mPosition:I

    :goto_35
    iput p2, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mTarget:I

    iget p3, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mDragStartPosition:I

    if-eq p3, p2, :cond_4d

    invoke-direct {p0, p2}, Landroidx/viewpager2/widget/ScrollEventAdapter;->dispatchSelected(I)V

    goto :goto_4d

    :cond_3f
    iget p2, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mAdapterState:I

    if-nez p2, :cond_4d

    iget-object p2, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollValues:Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;

    iget p2, p2, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mPosition:I

    if-ne p2, v1, :cond_4a

    move p2, v2

    :cond_4a
    invoke-direct {p0, p2}, Landroidx/viewpager2/widget/ScrollEventAdapter;->dispatchSelected(I)V

    :cond_4d
    :goto_4d
    iget-object p2, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollValues:Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;

    iget p2, p2, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mPosition:I

    if-ne p2, v1, :cond_55

    move p2, v2

    goto :goto_59

    :cond_55
    iget-object p2, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollValues:Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;

    iget p2, p2, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mPosition:I

    :goto_59
    iget-object p3, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollValues:Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;

    iget p3, p3, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mOffset:F

    iget-object v0, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollValues:Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;

    iget v0, v0, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mOffsetPx:I

    invoke-direct {p0, p2, p3, v0}, Landroidx/viewpager2/widget/ScrollEventAdapter;->dispatchScrolled(IFI)V

    iget-object p2, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollValues:Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;

    iget p2, p2, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mPosition:I

    iget p3, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mTarget:I

    if-eq p2, p3, :cond_6e

    if-ne p3, v1, :cond_7e

    :cond_6e
    iget-object p2, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollValues:Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;

    iget p2, p2, Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;->mOffsetPx:I

    if-nez p2, :cond_7e

    iget p2, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mScrollState:I

    if-eq p2, p1, :cond_7e

    invoke-direct {p0, v2}, Landroidx/viewpager2/widget/ScrollEventAdapter;->dispatchStateChanged(I)V

    invoke-direct {p0}, Landroidx/viewpager2/widget/ScrollEventAdapter;->resetState()V

    :cond_7e
    return-void
.end method

.method setOnPageChangeCallback(Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;)V
    .registers 2

    iput-object p1, p0, Landroidx/viewpager2/widget/ScrollEventAdapter;->mCallback:Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;

    return-void
.end method
