.class Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;
.super Ljava/lang/Object;
.source "RecyclerView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/recyclerview/widget/RecyclerView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ViewFlinger"
.end annotation


# instance fields
.field private mEatRunOnAnimationRequest:Z

.field mInterpolator:Landroid/view/animation/Interpolator;

.field private mLastFlingX:I

.field private mLastFlingY:I

.field mOverScroller:Landroid/widget/OverScroller;

.field private mReSchedulePostAnimationCallback:Z

.field final synthetic this$0:Landroidx/recyclerview/widget/RecyclerView;


# direct methods
.method constructor <init>(Landroidx/recyclerview/widget/RecyclerView;)V
    .registers 4

    .line 5246
    iput-object p1, p0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 5238
    sget-object v0, Landroidx/recyclerview/widget/RecyclerView;->sQuinticInterpolator:Landroid/view/animation/Interpolator;

    iput-object v0, p0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->mInterpolator:Landroid/view/animation/Interpolator;

    const/4 v0, 0x0

    .line 5241
    iput-boolean v0, p0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->mEatRunOnAnimationRequest:Z

    .line 5244
    iput-boolean v0, p0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->mReSchedulePostAnimationCallback:Z

    .line 5247
    new-instance v0, Landroid/widget/OverScroller;

    invoke-virtual {p1}, Landroidx/recyclerview/widget/RecyclerView;->getContext()Landroid/content/Context;

    move-result-object p1

    sget-object v1, Landroidx/recyclerview/widget/RecyclerView;->sQuinticInterpolator:Landroid/view/animation/Interpolator;

    invoke-direct {v0, p1, v1}, Landroid/widget/OverScroller;-><init>(Landroid/content/Context;Landroid/view/animation/Interpolator;)V

    iput-object v0, p0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->mOverScroller:Landroid/widget/OverScroller;

    return-void
.end method

.method private computeScrollDuration(IIII)I
    .registers 9

    .line 5483
    invoke-static {p1}, Ljava/lang/Math;->abs(I)I

    move-result v0

    .line 5484
    invoke-static {p2}, Ljava/lang/Math;->abs(I)I

    move-result v1

    if-le v0, v1, :cond_c

    const/4 v2, 0x1

    goto :goto_d

    :cond_c
    const/4 v2, 0x0

    :goto_d
    mul-int/2addr p3, p3

    mul-int/2addr p4, p4

    add-int/2addr p3, p4

    int-to-double p3, p3

    .line 5486
    invoke-static {p3, p4}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide p3

    double-to-int p3, p3

    mul-int/2addr p1, p1

    mul-int/2addr p2, p2

    add-int/2addr p1, p2

    int-to-double p1, p1

    .line 5487
    invoke-static {p1, p2}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide p1

    double-to-int p1, p1

    .line 5488
    iget-object p2, p0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    if-eqz v2, :cond_28

    invoke-virtual {p2}, Landroidx/recyclerview/widget/RecyclerView;->getWidth()I

    move-result p2

    goto :goto_2c

    :cond_28
    invoke-virtual {p2}, Landroidx/recyclerview/widget/RecyclerView;->getHeight()I

    move-result p2

    .line 5489
    :goto_2c
    div-int/lit8 p4, p2, 0x2

    int-to-float p1, p1

    const/high16 v3, 0x3f800000    # 1.0f

    mul-float/2addr p1, v3

    int-to-float p2, p2

    div-float/2addr p1, p2

    .line 5490
    invoke-static {v3, p1}, Ljava/lang/Math;->min(FF)F

    move-result p1

    int-to-float p4, p4

    .line 5492
    invoke-direct {p0, p1}, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->distanceInfluenceForSnapDuration(F)F

    move-result p1

    mul-float/2addr p1, p4

    add-float/2addr p4, p1

    if-lez p3, :cond_51

    int-to-float p1, p3

    div-float/2addr p4, p1

    .line 5496
    invoke-static {p4}, Ljava/lang/Math;->abs(F)F

    move-result p1

    const/high16 p2, 0x447a0000    # 1000.0f

    mul-float/2addr p1, p2

    invoke-static {p1}, Ljava/lang/Math;->round(F)I

    move-result p1

    mul-int/lit8 p1, p1, 0x4

    goto :goto_5c

    :cond_51
    if-eqz v2, :cond_54

    goto :goto_55

    :cond_54
    move v0, v1

    :goto_55
    int-to-float p1, v0

    div-float/2addr p1, p2

    add-float/2addr p1, v3

    const/high16 p2, 0x43960000    # 300.0f

    mul-float/2addr p1, p2

    float-to-int p1, p1

    :goto_5c
    const/16 p2, 0x7d0

    .line 5501
    invoke-static {p1, p2}, Ljava/lang/Math;->min(II)I

    move-result p1

    return p1
.end method

.method private distanceInfluenceForSnapDuration(F)F
    .registers 4

    const/high16 v0, 0x3f000000    # 0.5f

    sub-float/2addr p1, v0

    const v0, 0x3ef1463b

    mul-float/2addr p1, v0

    float-to-double v0, p1

    .line 5479
    invoke-static {v0, v1}, Ljava/lang/Math;->sin(D)D

    move-result-wide v0

    double-to-float p1, v0

    return p1
.end method

.method private internalPostOnAnimation()V
    .registers 2

    .line 5411
    iget-object v0, p0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v0, p0}, Landroidx/recyclerview/widget/RecyclerView;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 5412
    iget-object v0, p0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    invoke-static {v0, p0}, Landroidx/core/view/ViewCompat;->postOnAnimation(Landroid/view/View;Ljava/lang/Runnable;)V

    return-void
.end method


# virtual methods
.method public fling(II)V
    .registers 15

    .line 5416
    iget-object v0, p0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroidx/recyclerview/widget/RecyclerView;->setScrollState(I)V

    const/4 v0, 0x0

    .line 5417
    iput v0, p0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->mLastFlingY:I

    iput v0, p0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->mLastFlingX:I

    .line 5421
    iget-object v0, p0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->mInterpolator:Landroid/view/animation/Interpolator;

    sget-object v1, Landroidx/recyclerview/widget/RecyclerView;->sQuinticInterpolator:Landroid/view/animation/Interpolator;

    if-eq v0, v1, :cond_24

    .line 5422
    sget-object v0, Landroidx/recyclerview/widget/RecyclerView;->sQuinticInterpolator:Landroid/view/animation/Interpolator;

    iput-object v0, p0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->mInterpolator:Landroid/view/animation/Interpolator;

    .line 5423
    new-instance v0, Landroid/widget/OverScroller;

    iget-object v1, p0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v1}, Landroidx/recyclerview/widget/RecyclerView;->getContext()Landroid/content/Context;

    move-result-object v1

    sget-object v2, Landroidx/recyclerview/widget/RecyclerView;->sQuinticInterpolator:Landroid/view/animation/Interpolator;

    invoke-direct {v0, v1, v2}, Landroid/widget/OverScroller;-><init>(Landroid/content/Context;Landroid/view/animation/Interpolator;)V

    iput-object v0, p0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->mOverScroller:Landroid/widget/OverScroller;

    .line 5425
    :cond_24
    iget-object v3, p0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->mOverScroller:Landroid/widget/OverScroller;

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/high16 v8, -0x80000000

    const v9, 0x7fffffff

    const/high16 v10, -0x80000000

    const v11, 0x7fffffff

    move v6, p1

    move v7, p2

    invoke-virtual/range {v3 .. v11}, Landroid/widget/OverScroller;->fling(IIIIIIII)V

    .line 5427
    invoke-virtual {p0}, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->postOnAnimation()V

    return-void
.end method

.method postOnAnimation()V
    .registers 2

    .line 5403
    iget-boolean v0, p0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->mEatRunOnAnimationRequest:Z

    if-eqz v0, :cond_8

    const/4 v0, 0x1

    .line 5404
    iput-boolean v0, p0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->mReSchedulePostAnimationCallback:Z

    goto :goto_b

    .line 5406
    :cond_8
    invoke-direct {p0}, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->internalPostOnAnimation()V

    :goto_b
    return-void
.end method

.method public run()V
    .registers 23

    move-object/from16 v0, p0

    .line 5252
    iget-object v1, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    iget-object v1, v1, Landroidx/recyclerview/widget/RecyclerView;->mLayout:Landroidx/recyclerview/widget/RecyclerView$LayoutManager;

    if-nez v1, :cond_c

    .line 5253
    invoke-virtual/range {p0 .. p0}, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->stop()V

    return-void

    :cond_c
    const/4 v1, 0x0

    .line 5257
    iput-boolean v1, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->mReSchedulePostAnimationCallback:Z

    const/4 v2, 0x1

    .line 5258
    iput-boolean v2, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->mEatRunOnAnimationRequest:Z

    .line 5260
    iget-object v3, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v3}, Landroidx/recyclerview/widget/RecyclerView;->consumePendingUpdateOperations()V

    .line 5272
    iget-object v3, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->mOverScroller:Landroid/widget/OverScroller;

    .line 5273
    invoke-virtual {v3}, Landroid/widget/OverScroller;->computeScrollOffset()Z

    move-result v4

    if-eqz v4, :cond_19b

    .line 5274
    invoke-virtual {v3}, Landroid/widget/OverScroller;->getCurrX()I

    move-result v4

    .line 5275
    invoke-virtual {v3}, Landroid/widget/OverScroller;->getCurrY()I

    move-result v5

    .line 5276
    iget v6, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->mLastFlingX:I

    sub-int v6, v4, v6

    .line 5277
    iget v7, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->mLastFlingY:I

    sub-int v13, v5, v7

    .line 5278
    iput v4, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->mLastFlingX:I

    .line 5279
    iput v5, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->mLastFlingY:I

    .line 5284
    iget-object v4, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    iget-object v4, v4, Landroidx/recyclerview/widget/RecyclerView;->mReusableIntPair:[I

    aput v1, v4, v1

    .line 5285
    iget-object v4, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    iget-object v4, v4, Landroidx/recyclerview/widget/RecyclerView;->mReusableIntPair:[I

    aput v1, v4, v2

    .line 5286
    iget-object v7, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    iget-object v10, v7, Landroidx/recyclerview/widget/RecyclerView;->mReusableIntPair:[I

    const/4 v11, 0x0

    const/4 v12, 0x1

    move v8, v6

    move v9, v13

    invoke-virtual/range {v7 .. v12}, Landroidx/recyclerview/widget/RecyclerView;->dispatchNestedPreScroll(II[I[II)Z

    move-result v4

    if-eqz v4, :cond_5b

    .line 5288
    iget-object v4, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    iget-object v4, v4, Landroidx/recyclerview/widget/RecyclerView;->mReusableIntPair:[I

    aget v4, v4, v1

    sub-int/2addr v6, v4

    .line 5289
    iget-object v4, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    iget-object v4, v4, Landroidx/recyclerview/widget/RecyclerView;->mReusableIntPair:[I

    aget v4, v4, v2

    sub-int/2addr v13, v4

    .line 5294
    :cond_5b
    iget-object v4, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v4}, Landroidx/recyclerview/widget/RecyclerView;->getOverScrollMode()I

    move-result v4

    const/4 v5, 0x2

    if-eq v4, v5, :cond_69

    .line 5295
    iget-object v4, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v4, v6, v13}, Landroidx/recyclerview/widget/RecyclerView;->considerReleasingGlowsOnScroll(II)V

    .line 5299
    :cond_69
    iget-object v4, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    iget-object v4, v4, Landroidx/recyclerview/widget/RecyclerView;->mAdapter:Landroidx/recyclerview/widget/RecyclerView$Adapter;

    if-eqz v4, :cond_c4

    .line 5300
    iget-object v4, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    iget-object v4, v4, Landroidx/recyclerview/widget/RecyclerView;->mReusableIntPair:[I

    aput v1, v4, v1

    .line 5301
    iget-object v4, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    iget-object v4, v4, Landroidx/recyclerview/widget/RecyclerView;->mReusableIntPair:[I

    aput v1, v4, v2

    .line 5302
    iget-object v4, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    iget-object v7, v4, Landroidx/recyclerview/widget/RecyclerView;->mReusableIntPair:[I

    invoke-virtual {v4, v6, v13, v7}, Landroidx/recyclerview/widget/RecyclerView;->scrollStep(II[I)V

    .line 5303
    iget-object v4, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    iget-object v4, v4, Landroidx/recyclerview/widget/RecyclerView;->mReusableIntPair:[I

    aget v4, v4, v1

    .line 5304
    iget-object v7, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    iget-object v7, v7, Landroidx/recyclerview/widget/RecyclerView;->mReusableIntPair:[I

    aget v7, v7, v2

    sub-int/2addr v6, v4

    sub-int/2addr v13, v7

    .line 5310
    iget-object v8, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    iget-object v8, v8, Landroidx/recyclerview/widget/RecyclerView;->mLayout:Landroidx/recyclerview/widget/RecyclerView$LayoutManager;

    iget-object v8, v8, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;->mSmoothScroller:Landroidx/recyclerview/widget/RecyclerView$SmoothScroller;

    if-eqz v8, :cond_c6

    .line 5311
    invoke-virtual {v8}, Landroidx/recyclerview/widget/RecyclerView$SmoothScroller;->isPendingInitialRun()Z

    move-result v9

    if-nez v9, :cond_c6

    .line 5312
    invoke-virtual {v8}, Landroidx/recyclerview/widget/RecyclerView$SmoothScroller;->isRunning()Z

    move-result v9

    if-eqz v9, :cond_c6

    .line 5313
    iget-object v9, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    iget-object v9, v9, Landroidx/recyclerview/widget/RecyclerView;->mState:Landroidx/recyclerview/widget/RecyclerView$State;

    invoke-virtual {v9}, Landroidx/recyclerview/widget/RecyclerView$State;->getItemCount()I

    move-result v9

    if-nez v9, :cond_b2

    .line 5315
    invoke-virtual {v8}, Landroidx/recyclerview/widget/RecyclerView$SmoothScroller;->stop()V

    goto :goto_c6

    .line 5316
    :cond_b2
    invoke-virtual {v8}, Landroidx/recyclerview/widget/RecyclerView$SmoothScroller;->getTargetPosition()I

    move-result v10

    if-lt v10, v9, :cond_c0

    sub-int/2addr v9, v2

    .line 5317
    invoke-virtual {v8, v9}, Landroidx/recyclerview/widget/RecyclerView$SmoothScroller;->setTargetPosition(I)V

    .line 5318
    invoke-virtual {v8, v4, v7}, Landroidx/recyclerview/widget/RecyclerView$SmoothScroller;->onAnimation(II)V

    goto :goto_c6

    .line 5320
    :cond_c0
    invoke-virtual {v8, v4, v7}, Landroidx/recyclerview/widget/RecyclerView$SmoothScroller;->onAnimation(II)V

    goto :goto_c6

    :cond_c4
    move v4, v1

    move v7, v4

    .line 5325
    :cond_c6
    :goto_c6
    iget-object v8, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    iget-object v8, v8, Landroidx/recyclerview/widget/RecyclerView;->mItemDecorations:Ljava/util/ArrayList;

    invoke-virtual {v8}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v8

    if-nez v8, :cond_d5

    .line 5326
    iget-object v8, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v8}, Landroidx/recyclerview/widget/RecyclerView;->invalidate()V

    .line 5330
    :cond_d5
    iget-object v8, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    iget-object v8, v8, Landroidx/recyclerview/widget/RecyclerView;->mReusableIntPair:[I

    aput v1, v8, v1

    .line 5331
    iget-object v8, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    iget-object v8, v8, Landroidx/recyclerview/widget/RecyclerView;->mReusableIntPair:[I

    aput v1, v8, v2

    .line 5332
    iget-object v14, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    const/16 v19, 0x0

    const/16 v20, 0x1

    iget-object v8, v14, Landroidx/recyclerview/widget/RecyclerView;->mReusableIntPair:[I

    move v15, v4

    move/from16 v16, v7

    move/from16 v17, v6

    move/from16 v18, v13

    move-object/from16 v21, v8

    invoke-virtual/range {v14 .. v21}, Landroidx/recyclerview/widget/RecyclerView;->dispatchNestedScroll(IIII[II[I)V

    .line 5334
    iget-object v8, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    iget-object v8, v8, Landroidx/recyclerview/widget/RecyclerView;->mReusableIntPair:[I

    aget v8, v8, v1

    sub-int/2addr v6, v8

    .line 5335
    iget-object v8, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    iget-object v8, v8, Landroidx/recyclerview/widget/RecyclerView;->mReusableIntPair:[I

    aget v8, v8, v2

    sub-int/2addr v13, v8

    if-nez v4, :cond_107

    if-eqz v7, :cond_10c

    .line 5338
    :cond_107
    iget-object v8, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v8, v4, v7}, Landroidx/recyclerview/widget/RecyclerView;->dispatchOnScrolled(II)V

    .line 5341
    :cond_10c
    iget-object v8, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    # invokes: Landroidx/recyclerview/widget/RecyclerView;->awakenScrollBars()Z
    invoke-static {v8}, Landroidx/recyclerview/widget/RecyclerView;->access$200(Landroidx/recyclerview/widget/RecyclerView;)Z

    move-result v8

    if-nez v8, :cond_119

    .line 5342
    iget-object v8, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v8}, Landroidx/recyclerview/widget/RecyclerView;->invalidate()V

    .line 5350
    :cond_119
    invoke-virtual {v3}, Landroid/widget/OverScroller;->getCurrX()I

    move-result v8

    invoke-virtual {v3}, Landroid/widget/OverScroller;->getFinalX()I

    move-result v9

    if-ne v8, v9, :cond_125

    move v8, v2

    goto :goto_126

    :cond_125
    move v8, v1

    .line 5351
    :goto_126
    invoke-virtual {v3}, Landroid/widget/OverScroller;->getCurrY()I

    move-result v9

    invoke-virtual {v3}, Landroid/widget/OverScroller;->getFinalY()I

    move-result v10

    if-ne v9, v10, :cond_132

    move v9, v2

    goto :goto_133

    :cond_132
    move v9, v1

    .line 5352
    :goto_133
    invoke-virtual {v3}, Landroid/widget/OverScroller;->isFinished()Z

    move-result v10

    if-nez v10, :cond_144

    if-nez v8, :cond_13d

    if-eqz v6, :cond_142

    :cond_13d
    if-nez v9, :cond_144

    if-eqz v13, :cond_142

    goto :goto_144

    :cond_142
    move v8, v1

    goto :goto_145

    :cond_144
    :goto_144
    move v8, v2

    .line 5359
    :goto_145
    iget-object v9, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    iget-object v9, v9, Landroidx/recyclerview/widget/RecyclerView;->mLayout:Landroidx/recyclerview/widget/RecyclerView$LayoutManager;

    iget-object v9, v9, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;->mSmoothScroller:Landroidx/recyclerview/widget/RecyclerView$SmoothScroller;

    if-eqz v9, :cond_155

    .line 5361
    invoke-virtual {v9}, Landroidx/recyclerview/widget/RecyclerView$SmoothScroller;->isPendingInitialRun()Z

    move-result v9

    if-eqz v9, :cond_155

    move v9, v2

    goto :goto_156

    :cond_155
    move v9, v1

    :goto_156
    if-nez v9, :cond_189

    if-eqz v8, :cond_189

    .line 5367
    iget-object v4, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v4}, Landroidx/recyclerview/widget/RecyclerView;->getOverScrollMode()I

    move-result v4

    if-eq v4, v5, :cond_17d

    .line 5368
    invoke-virtual {v3}, Landroid/widget/OverScroller;->getCurrVelocity()F

    move-result v3

    float-to-int v3, v3

    if-gez v6, :cond_16b

    neg-int v4, v3

    goto :goto_170

    :cond_16b
    if-lez v6, :cond_16f

    move v4, v3

    goto :goto_170

    :cond_16f
    move v4, v1

    :goto_170
    if-gez v13, :cond_174

    neg-int v3, v3

    goto :goto_178

    :cond_174
    if-lez v13, :cond_177

    goto :goto_178

    :cond_177
    move v3, v1

    .line 5371
    :goto_178
    iget-object v5, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v5, v4, v3}, Landroidx/recyclerview/widget/RecyclerView;->absorbGlows(II)V

    .line 5374
    :cond_17d
    sget-boolean v3, Landroidx/recyclerview/widget/RecyclerView;->ALLOW_THREAD_GAP_WORK:Z

    if-eqz v3, :cond_19b

    .line 5375
    iget-object v3, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    iget-object v3, v3, Landroidx/recyclerview/widget/RecyclerView;->mPrefetchRegistry:Landroidx/recyclerview/widget/GapWorker$LayoutPrefetchRegistryImpl;

    invoke-virtual {v3}, Landroidx/recyclerview/widget/GapWorker$LayoutPrefetchRegistryImpl;->clearPrefetchPositions()V

    goto :goto_19b

    .line 5380
    :cond_189
    invoke-virtual/range {p0 .. p0}, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->postOnAnimation()V

    .line 5381
    iget-object v3, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    iget-object v3, v3, Landroidx/recyclerview/widget/RecyclerView;->mGapWorker:Landroidx/recyclerview/widget/GapWorker;

    if-eqz v3, :cond_19b

    .line 5382
    iget-object v3, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    iget-object v3, v3, Landroidx/recyclerview/widget/RecyclerView;->mGapWorker:Landroidx/recyclerview/widget/GapWorker;

    iget-object v5, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v3, v5, v4, v7}, Landroidx/recyclerview/widget/GapWorker;->postFromTraversal(Landroidx/recyclerview/widget/RecyclerView;II)V

    .line 5387
    :cond_19b
    :goto_19b
    iget-object v3, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    iget-object v3, v3, Landroidx/recyclerview/widget/RecyclerView;->mLayout:Landroidx/recyclerview/widget/RecyclerView$LayoutManager;

    iget-object v3, v3, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;->mSmoothScroller:Landroidx/recyclerview/widget/RecyclerView$SmoothScroller;

    if-eqz v3, :cond_1ac

    .line 5389
    invoke-virtual {v3}, Landroidx/recyclerview/widget/RecyclerView$SmoothScroller;->isPendingInitialRun()Z

    move-result v4

    if-eqz v4, :cond_1ac

    .line 5390
    invoke-virtual {v3, v1, v1}, Landroidx/recyclerview/widget/RecyclerView$SmoothScroller;->onAnimation(II)V

    .line 5393
    :cond_1ac
    iput-boolean v1, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->mEatRunOnAnimationRequest:Z

    .line 5394
    iget-boolean v3, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->mReSchedulePostAnimationCallback:Z

    if-eqz v3, :cond_1b6

    .line 5395
    invoke-direct/range {p0 .. p0}, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->internalPostOnAnimation()V

    goto :goto_1c0

    .line 5397
    :cond_1b6
    iget-object v3, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v3, v1}, Landroidx/recyclerview/widget/RecyclerView;->setScrollState(I)V

    .line 5398
    iget-object v1, v0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v1, v2}, Landroidx/recyclerview/widget/RecyclerView;->stopNestedScroll(I)V

    :goto_1c0
    return-void
.end method

.method public smoothScrollBy(IIILandroid/view/animation/Interpolator;)V
    .registers 13

    const/high16 v0, -0x80000000

    const/4 v1, 0x0

    if-ne p3, v0, :cond_9

    .line 5446
    invoke-direct {p0, p1, p2, v1, v1}, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->computeScrollDuration(IIII)I

    move-result p3

    :cond_9
    move v7, p3

    if-nez p4, :cond_e

    .line 5449
    sget-object p4, Landroidx/recyclerview/widget/RecyclerView;->sQuinticInterpolator:Landroid/view/animation/Interpolator;

    .line 5454
    :cond_e
    iget-object p3, p0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->mInterpolator:Landroid/view/animation/Interpolator;

    if-eq p3, p4, :cond_21

    .line 5455
    iput-object p4, p0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->mInterpolator:Landroid/view/animation/Interpolator;

    .line 5456
    new-instance p3, Landroid/widget/OverScroller;

    iget-object v0, p0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v0}, Landroidx/recyclerview/widget/RecyclerView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-direct {p3, v0, p4}, Landroid/widget/OverScroller;-><init>(Landroid/content/Context;Landroid/view/animation/Interpolator;)V

    iput-object p3, p0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->mOverScroller:Landroid/widget/OverScroller;

    .line 5460
    :cond_21
    iput v1, p0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->mLastFlingY:I

    iput v1, p0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->mLastFlingX:I

    .line 5463
    iget-object p3, p0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    const/4 p4, 0x2

    invoke-virtual {p3, p4}, Landroidx/recyclerview/widget/RecyclerView;->setScrollState(I)V

    .line 5464
    iget-object v2, p0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->mOverScroller:Landroid/widget/OverScroller;

    const/4 v3, 0x0

    const/4 v4, 0x0

    move v5, p1

    move v6, p2

    invoke-virtual/range {v2 .. v7}, Landroid/widget/OverScroller;->startScroll(IIIII)V

    .line 5473
    invoke-virtual {p0}, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->postOnAnimation()V

    return-void
.end method

.method public stop()V
    .registers 2

    .line 5505
    iget-object v0, p0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->this$0:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v0, p0}, Landroidx/recyclerview/widget/RecyclerView;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 5506
    iget-object v0, p0, Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;->mOverScroller:Landroid/widget/OverScroller;

    invoke-virtual {v0}, Landroid/widget/OverScroller;->abortAnimation()V

    return-void
.end method
