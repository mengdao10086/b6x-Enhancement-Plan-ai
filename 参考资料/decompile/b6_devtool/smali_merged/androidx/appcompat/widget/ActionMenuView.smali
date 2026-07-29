.class public Landroidx/appcompat/widget/ActionMenuView;
.super Landroidx/appcompat/widget/LinearLayoutCompat;
.source "ActionMenuView.java"

# interfaces
.implements Landroidx/appcompat/view/menu/MenuBuilder$ItemInvoker;
.implements Landroidx/appcompat/view/menu/MenuView;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/appcompat/widget/ActionMenuView$LayoutParams;,
        Landroidx/appcompat/widget/ActionMenuView$ActionMenuChildView;,
        Landroidx/appcompat/widget/ActionMenuView$ActionMenuPresenterCallback;,
        Landroidx/appcompat/widget/ActionMenuView$MenuBuilderCallback;,
        Landroidx/appcompat/widget/ActionMenuView$OnMenuItemClickListener;
    }
.end annotation


# static fields
.field static final GENERATED_ITEM_PADDING:I = 0x4

.field static final MIN_CELL_SIZE:I = 0x38

.field private static final TAG:Ljava/lang/String; = "ActionMenuView"


# instance fields
.field private mActionMenuPresenterCallback:Landroidx/appcompat/view/menu/MenuPresenter$Callback;

.field private mFormatItems:Z

.field private mFormatItemsWidth:I

.field private mGeneratedItemPadding:I

.field private mMenu:Landroidx/appcompat/view/menu/MenuBuilder;

.field mMenuBuilderCallback:Landroidx/appcompat/view/menu/MenuBuilder$Callback;

.field private mMinCellSize:I

.field mOnMenuItemClickListener:Landroidx/appcompat/widget/ActionMenuView$OnMenuItemClickListener;

.field private mPopupContext:Landroid/content/Context;

.field private mPopupTheme:I

.field private mPresenter:Landroidx/appcompat/widget/ActionMenuPresenter;

.field private mReserveOverflow:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 3

    const/4 v0, 0x0

    .line 79
    invoke-direct {p0, p1, v0}, Landroidx/appcompat/widget/ActionMenuView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 5

    .line 83
    invoke-direct {p0, p1, p2}, Landroidx/appcompat/widget/LinearLayoutCompat;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    const/4 p2, 0x0

    .line 84
    invoke-virtual {p0, p2}, Landroidx/appcompat/widget/ActionMenuView;->setBaselineAligned(Z)V

    .line 85
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->density:F

    const/high16 v1, 0x42600000    # 56.0f

    mul-float/2addr v1, v0

    float-to-int v1, v1

    .line 86
    iput v1, p0, Landroidx/appcompat/widget/ActionMenuView;->mMinCellSize:I

    const/high16 v1, 0x40800000    # 4.0f

    mul-float/2addr v0, v1

    float-to-int v0, v0

    .line 87
    iput v0, p0, Landroidx/appcompat/widget/ActionMenuView;->mGeneratedItemPadding:I

    .line 88
    iput-object p1, p0, Landroidx/appcompat/widget/ActionMenuView;->mPopupContext:Landroid/content/Context;

    .line 89
    iput p2, p0, Landroidx/appcompat/widget/ActionMenuView;->mPopupTheme:I

    return-void
.end method

.method static measureChildForCells(Landroid/view/View;IIII)I
    .registers 10

    .line 407
    invoke-virtual {p0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;

    .line 409
    invoke-static {p3}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v1

    sub-int/2addr v1, p4

    .line 411
    invoke-static {p3}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result p3

    .line 412
    invoke-static {v1, p3}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result p3

    .line 414
    instance-of p4, p0, Landroidx/appcompat/view/menu/ActionMenuItemView;

    if-eqz p4, :cond_1b

    .line 415
    move-object p4, p0

    check-cast p4, Landroidx/appcompat/view/menu/ActionMenuItemView;

    goto :goto_1c

    :cond_1b
    const/4 p4, 0x0

    :goto_1c
    const/4 v1, 0x1

    const/4 v2, 0x0

    if-eqz p4, :cond_28

    .line 416
    invoke-virtual {p4}, Landroidx/appcompat/view/menu/ActionMenuItemView;->hasText()Z

    move-result p4

    if-eqz p4, :cond_28

    move p4, v1

    goto :goto_29

    :cond_28
    move p4, v2

    :goto_29
    if-lez p2, :cond_4c

    const/4 v3, 0x2

    if-eqz p4, :cond_30

    if-lt p2, v3, :cond_4c

    :cond_30
    mul-int/2addr p2, p1

    const/high16 v4, -0x80000000

    .line 420
    invoke-static {p2, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result p2

    .line 422
    invoke-virtual {p0, p2, p3}, Landroid/view/View;->measure(II)V

    .line 424
    invoke-virtual {p0}, Landroid/view/View;->getMeasuredWidth()I

    move-result p2

    .line 425
    div-int v4, p2, p1

    .line 426
    rem-int/2addr p2, p1

    if-eqz p2, :cond_45

    add-int/lit8 v4, v4, 0x1

    :cond_45
    if-eqz p4, :cond_4a

    if-ge v4, v3, :cond_4a

    goto :goto_4d

    :cond_4a
    move v3, v4

    goto :goto_4d

    :cond_4c
    move v3, v2

    .line 430
    :goto_4d
    iget-boolean p2, v0, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->isOverflowButton:Z

    if-nez p2, :cond_54

    if-eqz p4, :cond_54

    goto :goto_55

    :cond_54
    move v1, v2

    .line 431
    :goto_55
    iput-boolean v1, v0, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->expandable:Z

    .line 433
    iput v3, v0, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->cellsUsed:I

    mul-int/2addr p1, v3

    const/high16 p2, 0x40000000    # 2.0f

    .line 435
    invoke-static {p1, p2}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result p1

    invoke-virtual {p0, p1, p3}, Landroid/view/View;->measure(II)V

    return v3
.end method

.method private onMeasureExactFormat(II)V
    .registers 32

    move-object/from16 v0, p0

    .line 181
    invoke-static/range {p2 .. p2}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v1

    .line 182
    invoke-static/range {p1 .. p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v2

    .line 183
    invoke-static/range {p2 .. p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v3

    .line 185
    invoke-virtual/range {p0 .. p0}, Landroidx/appcompat/widget/ActionMenuView;->getPaddingLeft()I

    move-result v4

    invoke-virtual/range {p0 .. p0}, Landroidx/appcompat/widget/ActionMenuView;->getPaddingRight()I

    move-result v5

    add-int/2addr v4, v5

    .line 186
    invoke-virtual/range {p0 .. p0}, Landroidx/appcompat/widget/ActionMenuView;->getPaddingTop()I

    move-result v5

    invoke-virtual/range {p0 .. p0}, Landroidx/appcompat/widget/ActionMenuView;->getPaddingBottom()I

    move-result v6

    add-int/2addr v5, v6

    const/4 v6, -0x2

    move/from16 v7, p2

    .line 188
    invoke-static {v7, v5, v6}, Landroidx/appcompat/widget/ActionMenuView;->getChildMeasureSpec(III)I

    move-result v6

    sub-int/2addr v2, v4

    .line 194
    iget v4, v0, Landroidx/appcompat/widget/ActionMenuView;->mMinCellSize:I

    div-int v7, v2, v4

    .line 195
    rem-int v8, v2, v4

    const/4 v9, 0x0

    if-nez v7, :cond_35

    .line 199
    invoke-virtual {v0, v2, v9}, Landroidx/appcompat/widget/ActionMenuView;->setMeasuredDimension(II)V

    return-void

    .line 203
    :cond_35
    div-int/2addr v8, v7

    add-int/2addr v4, v8

    .line 215
    invoke-virtual/range {p0 .. p0}, Landroidx/appcompat/widget/ActionMenuView;->getChildCount()I

    move-result v8

    move v10, v9

    move v12, v10

    move v13, v12

    move v14, v13

    move v15, v14

    move/from16 v16, v15

    const-wide/16 v17, 0x0

    :goto_44
    if-ge v12, v8, :cond_c3

    .line 217
    invoke-virtual {v0, v12}, Landroidx/appcompat/widget/ActionMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v11

    .line 218
    invoke-virtual {v11}, Landroid/view/View;->getVisibility()I

    move-result v9

    move/from16 v19, v3

    const/16 v3, 0x8

    if-ne v9, v3, :cond_56

    goto/16 :goto_bd

    .line 220
    :cond_56
    instance-of v3, v11, Landroidx/appcompat/view/menu/ActionMenuItemView;

    add-int/lit8 v14, v14, 0x1

    if-eqz v3, :cond_65

    .line 226
    iget v9, v0, Landroidx/appcompat/widget/ActionMenuView;->mGeneratedItemPadding:I

    move/from16 v20, v14

    const/4 v14, 0x0

    invoke-virtual {v11, v9, v14, v9, v14}, Landroid/view/View;->setPadding(IIII)V

    goto :goto_68

    :cond_65
    move/from16 v20, v14

    const/4 v14, 0x0

    .line 229
    :goto_68
    invoke-virtual {v11}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v9

    check-cast v9, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;

    .line 230
    iput-boolean v14, v9, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->expanded:Z

    .line 231
    iput v14, v9, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->extraPixels:I

    .line 232
    iput v14, v9, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->cellsUsed:I

    .line 233
    iput-boolean v14, v9, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->expandable:Z

    .line 234
    iput v14, v9, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->leftMargin:I

    .line 235
    iput v14, v9, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->rightMargin:I

    if-eqz v3, :cond_87

    .line 236
    move-object v3, v11

    check-cast v3, Landroidx/appcompat/view/menu/ActionMenuItemView;

    invoke-virtual {v3}, Landroidx/appcompat/view/menu/ActionMenuItemView;->hasText()Z

    move-result v3

    if-eqz v3, :cond_87

    const/4 v3, 0x1

    goto :goto_88

    :cond_87
    const/4 v3, 0x0

    :goto_88
    iput-boolean v3, v9, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->preventEdgeOffset:Z

    .line 239
    iget-boolean v3, v9, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->isOverflowButton:Z

    if-eqz v3, :cond_90

    const/4 v3, 0x1

    goto :goto_91

    :cond_90
    move v3, v7

    .line 241
    :goto_91
    invoke-static {v11, v4, v3, v6, v5}, Landroidx/appcompat/widget/ActionMenuView;->measureChildForCells(Landroid/view/View;IIII)I

    move-result v3

    .line 244
    invoke-static {v15, v3}, Ljava/lang/Math;->max(II)I

    move-result v15

    .line 245
    iget-boolean v14, v9, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->expandable:Z

    if-eqz v14, :cond_9f

    add-int/lit8 v16, v16, 0x1

    .line 246
    :cond_9f
    iget-boolean v9, v9, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->isOverflowButton:Z

    if-eqz v9, :cond_a4

    const/4 v13, 0x1

    :cond_a4
    sub-int/2addr v7, v3

    .line 249
    invoke-virtual {v11}, Landroid/view/View;->getMeasuredHeight()I

    move-result v9

    invoke-static {v10, v9}, Ljava/lang/Math;->max(II)I

    move-result v10

    const/4 v9, 0x1

    if-ne v3, v9, :cond_ba

    shl-int v3, v9, v12

    move v11, v10

    int-to-long v9, v3

    or-long v9, v17, v9

    move-wide/from16 v17, v9

    move v10, v11

    goto :goto_bb

    :cond_ba
    move v11, v10

    :goto_bb
    move/from16 v14, v20

    :goto_bd
    add-int/lit8 v12, v12, 0x1

    move/from16 v3, v19

    const/4 v9, 0x0

    goto :goto_44

    :cond_c3
    move/from16 v19, v3

    const/4 v3, 0x2

    if-eqz v13, :cond_cc

    if-ne v14, v3, :cond_cc

    const/4 v5, 0x1

    goto :goto_cd

    :cond_cc
    const/4 v5, 0x0

    :goto_cd
    const/4 v9, 0x0

    :goto_ce
    if-lez v16, :cond_177

    if-lez v7, :cond_177

    const v20, 0x7fffffff

    move/from16 v12, v20

    const/4 v3, 0x0

    const/4 v11, 0x0

    const-wide/16 v20, 0x0

    :goto_db
    if-ge v11, v8, :cond_116

    .line 266
    invoke-virtual {v0, v11}, Landroidx/appcompat/widget/ActionMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v24

    .line 267
    invoke-virtual/range {v24 .. v24}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v24

    move/from16 v25, v9

    move-object/from16 v9, v24

    check-cast v9, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;

    move/from16 v24, v10

    .line 270
    iget-boolean v10, v9, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->expandable:Z

    if-nez v10, :cond_f2

    goto :goto_10f

    .line 273
    :cond_f2
    iget v10, v9, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->cellsUsed:I

    if-ge v10, v12, :cond_101

    .line 274
    iget v3, v9, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->cellsUsed:I

    const-wide/16 v22, 0x1

    shl-long v9, v22, v11

    move v12, v3

    move-wide/from16 v20, v9

    const/4 v3, 0x1

    goto :goto_10f

    :cond_101
    const-wide/16 v22, 0x1

    .line 277
    iget v9, v9, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->cellsUsed:I

    if-ne v9, v12, :cond_10f

    shl-long v9, v22, v11

    or-long v9, v20, v9

    add-int/lit8 v3, v3, 0x1

    move-wide/from16 v20, v9

    :cond_10f
    :goto_10f
    add-int/lit8 v11, v11, 0x1

    move/from16 v10, v24

    move/from16 v9, v25

    goto :goto_db

    :cond_116
    move/from16 v25, v9

    move/from16 v24, v10

    or-long v17, v17, v20

    if-le v3, v7, :cond_122

    move v11, v1

    move/from16 v26, v2

    goto :goto_17e

    :cond_122
    add-int/lit8 v12, v12, 0x1

    const/4 v3, 0x0

    :goto_125
    if-ge v3, v8, :cond_171

    .line 292
    invoke-virtual {v0, v3}, Landroidx/appcompat/widget/ActionMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v9

    .line 293
    invoke-virtual {v9}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v10

    check-cast v10, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;

    move/from16 v26, v2

    const/4 v11, 0x1

    shl-int v2, v11, v3

    move v11, v1

    int-to-long v1, v2

    and-long v22, v20, v1

    const-wide/16 v27, 0x0

    cmp-long v22, v22, v27

    if-nez v22, :cond_149

    .line 296
    iget v9, v10, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->cellsUsed:I

    if-ne v9, v12, :cond_146

    or-long v17, v17, v1

    :cond_146
    move/from16 v27, v5

    goto :goto_169

    :cond_149
    if-eqz v5, :cond_15d

    .line 300
    iget-boolean v1, v10, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->preventEdgeOffset:Z

    if-eqz v1, :cond_15d

    const/4 v1, 0x1

    if-ne v7, v1, :cond_15d

    .line 302
    iget v2, v0, Landroidx/appcompat/widget/ActionMenuView;->mGeneratedItemPadding:I

    add-int v1, v2, v4

    move/from16 v27, v5

    const/4 v5, 0x0

    invoke-virtual {v9, v1, v5, v2, v5}, Landroid/view/View;->setPadding(IIII)V

    goto :goto_15f

    :cond_15d
    move/from16 v27, v5

    .line 304
    :goto_15f
    iget v1, v10, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->cellsUsed:I

    const/4 v2, 0x1

    add-int/2addr v1, v2

    iput v1, v10, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->cellsUsed:I

    .line 305
    iput-boolean v2, v10, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->expanded:Z

    add-int/lit8 v7, v7, -0x1

    :goto_169
    add-int/lit8 v3, v3, 0x1

    move v1, v11

    move/from16 v2, v26

    move/from16 v5, v27

    goto :goto_125

    :cond_171
    move/from16 v10, v24

    const/4 v3, 0x2

    const/4 v9, 0x1

    goto/16 :goto_ce

    :cond_177
    move v11, v1

    move/from16 v26, v2

    move/from16 v25, v9

    move/from16 v24, v10

    :goto_17e
    const/4 v1, 0x1

    if-nez v13, :cond_185

    if-ne v14, v1, :cond_185

    move v2, v1

    goto :goto_186

    :cond_185
    const/4 v2, 0x0

    :goto_186
    if-lez v7, :cond_23b

    const-wide/16 v9, 0x0

    cmp-long v3, v17, v9

    if-eqz v3, :cond_23b

    sub-int/2addr v14, v1

    if-lt v7, v14, :cond_195

    if-nez v2, :cond_195

    if-le v15, v1, :cond_23b

    .line 318
    :cond_195
    invoke-static/range {v17 .. v18}, Ljava/lang/Long;->bitCount(J)I

    move-result v1

    int-to-float v1, v1

    if-nez v2, :cond_1d6

    const-wide/16 v2, 0x1

    and-long v2, v17, v2

    const-wide/16 v9, 0x0

    cmp-long v2, v2, v9

    const/high16 v3, 0x3f000000    # 0.5f

    const/4 v14, 0x0

    if-eqz v2, :cond_1b8

    .line 323
    invoke-virtual {v0, v14}, Landroidx/appcompat/widget/ActionMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    check-cast v2, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;

    .line 324
    iget-boolean v2, v2, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->preventEdgeOffset:Z

    if-nez v2, :cond_1b8

    sub-float/2addr v1, v3

    :cond_1b8
    add-int/lit8 v2, v8, -0x1

    const/4 v5, 0x1

    shl-int v9, v5, v2

    int-to-long v9, v9

    and-long v9, v17, v9

    const-wide/16 v12, 0x0

    cmp-long v5, v9, v12

    if-eqz v5, :cond_1d7

    .line 327
    invoke-virtual {v0, v2}, Landroidx/appcompat/widget/ActionMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    check-cast v2, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;

    .line 328
    iget-boolean v2, v2, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->preventEdgeOffset:Z

    if-nez v2, :cond_1d7

    sub-float/2addr v1, v3

    goto :goto_1d7

    :cond_1d6
    const/4 v14, 0x0

    :cond_1d7
    :goto_1d7
    const/4 v2, 0x0

    cmpl-float v2, v1, v2

    if-lez v2, :cond_1e1

    mul-int/2addr v7, v4

    int-to-float v2, v7

    div-float/2addr v2, v1

    float-to-int v1, v2

    goto :goto_1e2

    :cond_1e1
    move v1, v14

    :goto_1e2
    move v2, v14

    move/from16 v9, v25

    :goto_1e5
    if-ge v2, v8, :cond_23e

    const/4 v3, 0x1

    shl-int v5, v3, v2

    int-to-long v12, v5

    and-long v12, v17, v12

    const-wide/16 v15, 0x0

    cmp-long v3, v12, v15

    if-nez v3, :cond_1f6

    const/4 v3, 0x1

    const/4 v7, 0x2

    goto :goto_238

    .line 338
    :cond_1f6
    invoke-virtual {v0, v2}, Landroidx/appcompat/widget/ActionMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 339
    invoke-virtual {v3}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v5

    check-cast v5, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;

    .line 340
    instance-of v3, v3, Landroidx/appcompat/view/menu/ActionMenuItemView;

    if-eqz v3, :cond_219

    .line 342
    iput v1, v5, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->extraPixels:I

    const/4 v3, 0x1

    .line 343
    iput-boolean v3, v5, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->expanded:Z

    if-nez v2, :cond_215

    .line 344
    iget-boolean v3, v5, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->preventEdgeOffset:Z

    if-nez v3, :cond_215

    neg-int v3, v1

    const/4 v7, 0x2

    .line 347
    div-int/2addr v3, v7

    iput v3, v5, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->leftMargin:I

    goto :goto_216

    :cond_215
    const/4 v7, 0x2

    :goto_216
    const/4 v3, 0x1

    const/4 v9, 0x1

    goto :goto_238

    :cond_219
    const/4 v7, 0x2

    .line 350
    iget-boolean v3, v5, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->isOverflowButton:Z

    if-eqz v3, :cond_229

    .line 351
    iput v1, v5, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->extraPixels:I

    const/4 v3, 0x1

    .line 352
    iput-boolean v3, v5, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->expanded:Z

    neg-int v9, v1

    .line 353
    div-int/2addr v9, v7

    iput v9, v5, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->rightMargin:I

    move v9, v3

    goto :goto_238

    :cond_229
    const/4 v3, 0x1

    if-eqz v2, :cond_230

    .line 360
    div-int/lit8 v10, v1, 0x2

    iput v10, v5, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->leftMargin:I

    :cond_230
    add-int/lit8 v10, v8, -0x1

    if-eq v2, v10, :cond_238

    .line 363
    div-int/lit8 v10, v1, 0x2

    iput v10, v5, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->rightMargin:I

    :cond_238
    :goto_238
    add-int/lit8 v2, v2, 0x1

    goto :goto_1e5

    :cond_23b
    const/4 v14, 0x0

    move/from16 v9, v25

    :cond_23e
    const/high16 v1, 0x40000000    # 2.0f

    if-eqz v9, :cond_264

    move v9, v14

    :goto_243
    if-ge v9, v8, :cond_264

    .line 374
    invoke-virtual {v0, v9}, Landroidx/appcompat/widget/ActionMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 375
    invoke-virtual {v2}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    check-cast v3, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;

    .line 377
    iget-boolean v5, v3, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->expanded:Z

    if-nez v5, :cond_254

    goto :goto_261

    .line 379
    :cond_254
    iget v5, v3, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->cellsUsed:I

    mul-int/2addr v5, v4

    iget v3, v3, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->extraPixels:I

    add-int/2addr v5, v3

    .line 380
    invoke-static {v5, v1}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v3

    invoke-virtual {v2, v3, v6}, Landroid/view/View;->measure(II)V

    :goto_261
    add-int/lit8 v9, v9, 0x1

    goto :goto_243

    :cond_264
    if-eq v11, v1, :cond_269

    move/from16 v3, v24

    goto :goto_26b

    :cond_269
    move/from16 v3, v19

    :goto_26b
    move/from16 v2, v26

    .line 389
    invoke-virtual {v0, v2, v3}, Landroidx/appcompat/widget/ActionMenuView;->setMeasuredDimension(II)V

    return-void
.end method


# virtual methods
.method protected checkLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Z
    .registers 2

    .line 610
    instance-of p1, p1, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;

    return p1
.end method

.method public dismissPopupMenus()V
    .registers 2

    .line 723
    iget-object v0, p0, Landroidx/appcompat/widget/ActionMenuView;->mPresenter:Landroidx/appcompat/widget/ActionMenuPresenter;

    if-eqz v0, :cond_7

    .line 724
    invoke-virtual {v0}, Landroidx/appcompat/widget/ActionMenuPresenter;->dismissPopupMenus()Z

    :cond_7
    return-void
.end method

.method public dispatchPopulateAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)Z
    .registers 2

    const/4 p1, 0x0

    return p1
.end method

.method protected bridge synthetic generateDefaultLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    .registers 2

    .line 50
    invoke-virtual {p0}, Landroidx/appcompat/widget/ActionMenuView;->generateDefaultLayoutParams()Landroidx/appcompat/widget/ActionMenuView$LayoutParams;

    move-result-object v0

    return-object v0
.end method

.method protected generateDefaultLayoutParams()Landroidx/appcompat/widget/ActionMenuView$LayoutParams;
    .registers 3

    .line 583
    new-instance v0, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;

    const/4 v1, -0x2

    invoke-direct {v0, v1, v1}, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;-><init>(II)V

    const/16 v1, 0x10

    .line 585
    iput v1, v0, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->gravity:I

    return-object v0
.end method

.method protected bridge synthetic generateDefaultLayoutParams()Landroidx/appcompat/widget/LinearLayoutCompat$LayoutParams;
    .registers 2

    .line 50
    invoke-virtual {p0}, Landroidx/appcompat/widget/ActionMenuView;->generateDefaultLayoutParams()Landroidx/appcompat/widget/ActionMenuView$LayoutParams;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic generateLayoutParams(Landroid/util/AttributeSet;)Landroid/view/ViewGroup$LayoutParams;
    .registers 2

    .line 50
    invoke-virtual {p0, p1}, Landroidx/appcompat/widget/ActionMenuView;->generateLayoutParams(Landroid/util/AttributeSet;)Landroidx/appcompat/widget/ActionMenuView$LayoutParams;

    move-result-object p1

    return-object p1
.end method

.method protected bridge synthetic generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;
    .registers 2

    .line 50
    invoke-virtual {p0, p1}, Landroidx/appcompat/widget/ActionMenuView;->generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroidx/appcompat/widget/ActionMenuView$LayoutParams;

    move-result-object p1

    return-object p1
.end method

.method public generateLayoutParams(Landroid/util/AttributeSet;)Landroidx/appcompat/widget/ActionMenuView$LayoutParams;
    .registers 4

    .line 591
    new-instance v0, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;

    invoke-virtual {p0}, Landroidx/appcompat/widget/ActionMenuView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-object v0
.end method

.method protected generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroidx/appcompat/widget/ActionMenuView$LayoutParams;
    .registers 3

    if-eqz p1, :cond_1c

    .line 597
    instance-of v0, p1, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;

    if-eqz v0, :cond_e

    .line 598
    new-instance v0, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;

    check-cast p1, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;

    invoke-direct {v0, p1}, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;-><init>(Landroidx/appcompat/widget/ActionMenuView$LayoutParams;)V

    goto :goto_13

    .line 599
    :cond_e
    new-instance v0, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;

    invoke-direct {v0, p1}, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V

    .line 600
    :goto_13
    iget p1, v0, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->gravity:I

    if-gtz p1, :cond_1b

    const/16 p1, 0x10

    .line 601
    iput p1, v0, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->gravity:I

    :cond_1b
    return-object v0

    .line 605
    :cond_1c
    invoke-virtual {p0}, Landroidx/appcompat/widget/ActionMenuView;->generateDefaultLayoutParams()Landroidx/appcompat/widget/ActionMenuView$LayoutParams;

    move-result-object p1

    return-object p1
.end method

.method public bridge synthetic generateLayoutParams(Landroid/util/AttributeSet;)Landroidx/appcompat/widget/LinearLayoutCompat$LayoutParams;
    .registers 2

    .line 50
    invoke-virtual {p0, p1}, Landroidx/appcompat/widget/ActionMenuView;->generateLayoutParams(Landroid/util/AttributeSet;)Landroidx/appcompat/widget/ActionMenuView$LayoutParams;

    move-result-object p1

    return-object p1
.end method

.method protected bridge synthetic generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroidx/appcompat/widget/LinearLayoutCompat$LayoutParams;
    .registers 2

    .line 50
    invoke-virtual {p0, p1}, Landroidx/appcompat/widget/ActionMenuView;->generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroidx/appcompat/widget/ActionMenuView$LayoutParams;

    move-result-object p1

    return-object p1
.end method

.method public generateOverflowButtonLayoutParams()Landroidx/appcompat/widget/ActionMenuView$LayoutParams;
    .registers 3

    .line 616
    invoke-virtual {p0}, Landroidx/appcompat/widget/ActionMenuView;->generateDefaultLayoutParams()Landroidx/appcompat/widget/ActionMenuView$LayoutParams;

    move-result-object v0

    const/4 v1, 0x1

    .line 617
    iput-boolean v1, v0, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->isOverflowButton:Z

    return-object v0
.end method

.method public getMenu()Landroid/view/Menu;
    .registers 4

    .line 651
    iget-object v0, p0, Landroidx/appcompat/widget/ActionMenuView;->mMenu:Landroidx/appcompat/view/menu/MenuBuilder;

    if-nez v0, :cond_3f

    .line 652
    invoke-virtual {p0}, Landroidx/appcompat/widget/ActionMenuView;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 653
    new-instance v1, Landroidx/appcompat/view/menu/MenuBuilder;

    invoke-direct {v1, v0}, Landroidx/appcompat/view/menu/MenuBuilder;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Landroidx/appcompat/widget/ActionMenuView;->mMenu:Landroidx/appcompat/view/menu/MenuBuilder;

    .line 654
    new-instance v2, Landroidx/appcompat/widget/ActionMenuView$MenuBuilderCallback;

    invoke-direct {v2, p0}, Landroidx/appcompat/widget/ActionMenuView$MenuBuilderCallback;-><init>(Landroidx/appcompat/widget/ActionMenuView;)V

    invoke-virtual {v1, v2}, Landroidx/appcompat/view/menu/MenuBuilder;->setCallback(Landroidx/appcompat/view/menu/MenuBuilder$Callback;)V

    .line 655
    new-instance v1, Landroidx/appcompat/widget/ActionMenuPresenter;

    invoke-direct {v1, v0}, Landroidx/appcompat/widget/ActionMenuPresenter;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Landroidx/appcompat/widget/ActionMenuView;->mPresenter:Landroidx/appcompat/widget/ActionMenuPresenter;

    const/4 v0, 0x1

    .line 656
    invoke-virtual {v1, v0}, Landroidx/appcompat/widget/ActionMenuPresenter;->setReserveOverflow(Z)V

    .line 657
    iget-object v0, p0, Landroidx/appcompat/widget/ActionMenuView;->mPresenter:Landroidx/appcompat/widget/ActionMenuPresenter;

    iget-object v1, p0, Landroidx/appcompat/widget/ActionMenuView;->mActionMenuPresenterCallback:Landroidx/appcompat/view/menu/MenuPresenter$Callback;

    if-eqz v1, :cond_29

    goto :goto_2e

    .line 658
    :cond_29
    new-instance v1, Landroidx/appcompat/widget/ActionMenuView$ActionMenuPresenterCallback;

    invoke-direct {v1}, Landroidx/appcompat/widget/ActionMenuView$ActionMenuPresenterCallback;-><init>()V

    .line 657
    :goto_2e
    invoke-virtual {v0, v1}, Landroidx/appcompat/widget/ActionMenuPresenter;->setCallback(Landroidx/appcompat/view/menu/MenuPresenter$Callback;)V

    .line 659
    iget-object v0, p0, Landroidx/appcompat/widget/ActionMenuView;->mMenu:Landroidx/appcompat/view/menu/MenuBuilder;

    iget-object v1, p0, Landroidx/appcompat/widget/ActionMenuView;->mPresenter:Landroidx/appcompat/widget/ActionMenuPresenter;

    iget-object v2, p0, Landroidx/appcompat/widget/ActionMenuView;->mPopupContext:Landroid/content/Context;

    invoke-virtual {v0, v1, v2}, Landroidx/appcompat/view/menu/MenuBuilder;->addMenuPresenter(Landroidx/appcompat/view/menu/MenuPresenter;Landroid/content/Context;)V

    .line 660
    iget-object v0, p0, Landroidx/appcompat/widget/ActionMenuView;->mPresenter:Landroidx/appcompat/widget/ActionMenuPresenter;

    invoke-virtual {v0, p0}, Landroidx/appcompat/widget/ActionMenuPresenter;->setMenuView(Landroidx/appcompat/widget/ActionMenuView;)V

    .line 663
    :cond_3f
    iget-object v0, p0, Landroidx/appcompat/widget/ActionMenuView;->mMenu:Landroidx/appcompat/view/menu/MenuBuilder;

    return-object v0
.end method

.method public getOverflowIcon()Landroid/graphics/drawable/Drawable;
    .registers 2

    .line 565
    invoke-virtual {p0}, Landroidx/appcompat/widget/ActionMenuView;->getMenu()Landroid/view/Menu;

    .line 566
    iget-object v0, p0, Landroidx/appcompat/widget/ActionMenuView;->mPresenter:Landroidx/appcompat/widget/ActionMenuPresenter;

    invoke-virtual {v0}, Landroidx/appcompat/widget/ActionMenuPresenter;->getOverflowIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0
.end method

.method public getPopupTheme()I
    .registers 2

    .line 116
    iget v0, p0, Landroidx/appcompat/widget/ActionMenuView;->mPopupTheme:I

    return v0
.end method

.method public getWindowAnimations()I
    .registers 2

    const/4 v0, 0x0

    return v0
.end method

.method protected hasSupportDividerBeforeChildAt(I)Z
    .registers 6

    const/4 v0, 0x0

    if-nez p1, :cond_4

    return v0

    :cond_4
    add-int/lit8 v1, p1, -0x1

    .line 736
    invoke-virtual {p0, v1}, Landroidx/appcompat/widget/ActionMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 737
    invoke-virtual {p0, p1}, Landroidx/appcompat/widget/ActionMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 739
    invoke-virtual {p0}, Landroidx/appcompat/widget/ActionMenuView;->getChildCount()I

    move-result v3

    if-ge p1, v3, :cond_1f

    instance-of v3, v1, Landroidx/appcompat/widget/ActionMenuView$ActionMenuChildView;

    if-eqz v3, :cond_1f

    .line 740
    check-cast v1, Landroidx/appcompat/widget/ActionMenuView$ActionMenuChildView;

    invoke-interface {v1}, Landroidx/appcompat/widget/ActionMenuView$ActionMenuChildView;->needsDividerAfter()Z

    move-result v1

    or-int/2addr v0, v1

    :cond_1f
    if-lez p1, :cond_2c

    .line 742
    instance-of p1, v2, Landroidx/appcompat/widget/ActionMenuView$ActionMenuChildView;

    if-eqz p1, :cond_2c

    .line 743
    check-cast v2, Landroidx/appcompat/widget/ActionMenuView$ActionMenuChildView;

    invoke-interface {v2}, Landroidx/appcompat/widget/ActionMenuView$ActionMenuChildView;->needsDividerBefore()Z

    move-result p1

    or-int/2addr v0, p1

    :cond_2c
    return v0
.end method

.method public hideOverflowMenu()Z
    .registers 2

    .line 700
    iget-object v0, p0, Landroidx/appcompat/widget/ActionMenuView;->mPresenter:Landroidx/appcompat/widget/ActionMenuPresenter;

    if-eqz v0, :cond_c

    invoke-virtual {v0}, Landroidx/appcompat/widget/ActionMenuPresenter;->hideOverflowMenu()Z

    move-result v0

    if-eqz v0, :cond_c

    const/4 v0, 0x1

    goto :goto_d

    :cond_c
    const/4 v0, 0x0

    :goto_d
    return v0
.end method

.method public initialize(Landroidx/appcompat/view/menu/MenuBuilder;)V
    .registers 2

    .line 639
    iput-object p1, p0, Landroidx/appcompat/widget/ActionMenuView;->mMenu:Landroidx/appcompat/view/menu/MenuBuilder;

    return-void
.end method

.method public invokeItem(Landroidx/appcompat/view/menu/MenuItemImpl;)Z
    .registers 4

    .line 625
    iget-object v0, p0, Landroidx/appcompat/widget/ActionMenuView;->mMenu:Landroidx/appcompat/view/menu/MenuBuilder;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Landroidx/appcompat/view/menu/MenuBuilder;->performItemAction(Landroid/view/MenuItem;I)Z

    move-result p1

    return p1
.end method

.method public isOverflowMenuShowPending()Z
    .registers 2

    .line 716
    iget-object v0, p0, Landroidx/appcompat/widget/ActionMenuView;->mPresenter:Landroidx/appcompat/widget/ActionMenuPresenter;

    if-eqz v0, :cond_c

    invoke-virtual {v0}, Landroidx/appcompat/widget/ActionMenuPresenter;->isOverflowMenuShowPending()Z

    move-result v0

    if-eqz v0, :cond_c

    const/4 v0, 0x1

    goto :goto_d

    :cond_c
    const/4 v0, 0x0

    :goto_d
    return v0
.end method

.method public isOverflowMenuShowing()Z
    .registers 2

    .line 710
    iget-object v0, p0, Landroidx/appcompat/widget/ActionMenuView;->mPresenter:Landroidx/appcompat/widget/ActionMenuPresenter;

    if-eqz v0, :cond_c

    invoke-virtual {v0}, Landroidx/appcompat/widget/ActionMenuPresenter;->isOverflowMenuShowing()Z

    move-result v0

    if-eqz v0, :cond_c

    const/4 v0, 0x1

    goto :goto_d

    :cond_c
    const/4 v0, 0x0

    :goto_d
    return v0
.end method

.method public isOverflowReserved()Z
    .registers 2

    .line 572
    iget-boolean v0, p0, Landroidx/appcompat/widget/ActionMenuView;->mReserveOverflow:Z

    return v0
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .registers 3

    .line 131
    invoke-super {p0, p1}, Landroidx/appcompat/widget/LinearLayoutCompat;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 133
    iget-object p1, p0, Landroidx/appcompat/widget/ActionMenuView;->mPresenter:Landroidx/appcompat/widget/ActionMenuPresenter;

    if-eqz p1, :cond_1d

    const/4 v0, 0x0

    .line 134
    invoke-virtual {p1, v0}, Landroidx/appcompat/widget/ActionMenuPresenter;->updateMenuView(Z)V

    .line 136
    iget-object p1, p0, Landroidx/appcompat/widget/ActionMenuView;->mPresenter:Landroidx/appcompat/widget/ActionMenuPresenter;

    invoke-virtual {p1}, Landroidx/appcompat/widget/ActionMenuPresenter;->isOverflowMenuShowing()Z

    move-result p1

    if-eqz p1, :cond_1d

    .line 137
    iget-object p1, p0, Landroidx/appcompat/widget/ActionMenuView;->mPresenter:Landroidx/appcompat/widget/ActionMenuPresenter;

    invoke-virtual {p1}, Landroidx/appcompat/widget/ActionMenuPresenter;->hideOverflowMenu()Z

    .line 138
    iget-object p1, p0, Landroidx/appcompat/widget/ActionMenuView;->mPresenter:Landroidx/appcompat/widget/ActionMenuPresenter;

    invoke-virtual {p1}, Landroidx/appcompat/widget/ActionMenuPresenter;->showOverflowMenu()Z

    :cond_1d
    return-void
.end method

.method public onDetachedFromWindow()V
    .registers 1

    .line 544
    invoke-super {p0}, Landroidx/appcompat/widget/LinearLayoutCompat;->onDetachedFromWindow()V

    .line 545
    invoke-virtual {p0}, Landroidx/appcompat/widget/ActionMenuView;->dismissPopupMenus()V

    return-void
.end method

.method protected onLayout(ZIIII)V
    .registers 23

    move-object/from16 v0, p0

    .line 442
    iget-boolean v1, v0, Landroidx/appcompat/widget/ActionMenuView;->mFormatItems:Z

    if-nez v1, :cond_a

    .line 443
    invoke-super/range {p0 .. p5}, Landroidx/appcompat/widget/LinearLayoutCompat;->onLayout(ZIIII)V

    return-void

    .line 447
    :cond_a
    invoke-virtual/range {p0 .. p0}, Landroidx/appcompat/widget/ActionMenuView;->getChildCount()I

    move-result v1

    sub-int v2, p5, p3

    .line 448
    div-int/lit8 v2, v2, 0x2

    .line 449
    invoke-virtual/range {p0 .. p0}, Landroidx/appcompat/widget/ActionMenuView;->getDividerWidth()I

    move-result v3

    sub-int v4, p4, p2

    .line 452
    invoke-virtual/range {p0 .. p0}, Landroidx/appcompat/widget/ActionMenuView;->getPaddingRight()I

    move-result v5

    sub-int v5, v4, v5

    invoke-virtual/range {p0 .. p0}, Landroidx/appcompat/widget/ActionMenuView;->getPaddingLeft()I

    move-result v6

    sub-int/2addr v5, v6

    .line 454
    invoke-static/range {p0 .. p0}, Landroidx/appcompat/widget/ViewUtils;->isLayoutRtl(Landroid/view/View;)Z

    move-result v6

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    :goto_2a
    const/16 v11, 0x8

    const/4 v12, 0x1

    if-ge v8, v1, :cond_8d

    .line 456
    invoke-virtual {v0, v8}, Landroidx/appcompat/widget/ActionMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v13

    .line 457
    invoke-virtual {v13}, Landroid/view/View;->getVisibility()I

    move-result v14

    if-ne v14, v11, :cond_3a

    goto :goto_8a

    .line 461
    :cond_3a
    invoke-virtual {v13}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v11

    check-cast v11, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;

    .line 462
    iget-boolean v14, v11, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->isOverflowButton:Z

    if-eqz v14, :cond_7a

    .line 463
    invoke-virtual {v13}, Landroid/view/View;->getMeasuredWidth()I

    move-result v9

    .line 464
    invoke-virtual {v0, v8}, Landroidx/appcompat/widget/ActionMenuView;->hasSupportDividerBeforeChildAt(I)Z

    move-result v14

    if-eqz v14, :cond_4f

    add-int/2addr v9, v3

    .line 467
    :cond_4f
    invoke-virtual {v13}, Landroid/view/View;->getMeasuredHeight()I

    move-result v14

    if-eqz v6, :cond_5f

    .line 471
    invoke-virtual/range {p0 .. p0}, Landroidx/appcompat/widget/ActionMenuView;->getPaddingLeft()I

    move-result v15

    iget v11, v11, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->leftMargin:I

    add-int/2addr v15, v11

    add-int v11, v15, v9

    goto :goto_6f

    .line 474
    :cond_5f
    invoke-virtual/range {p0 .. p0}, Landroidx/appcompat/widget/ActionMenuView;->getWidth()I

    move-result v15

    invoke-virtual/range {p0 .. p0}, Landroidx/appcompat/widget/ActionMenuView;->getPaddingRight()I

    move-result v16

    sub-int v15, v15, v16

    iget v11, v11, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->rightMargin:I

    sub-int v11, v15, v11

    sub-int v15, v11, v9

    .line 477
    :goto_6f
    div-int/lit8 v16, v14, 0x2

    sub-int v7, v2, v16

    add-int/2addr v14, v7

    .line 479
    invoke-virtual {v13, v15, v7, v11, v14}, Landroid/view/View;->layout(IIII)V

    sub-int/2addr v5, v9

    move v9, v12

    goto :goto_8a

    .line 484
    :cond_7a
    invoke-virtual {v13}, Landroid/view/View;->getMeasuredWidth()I

    move-result v7

    iget v12, v11, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->leftMargin:I

    add-int/2addr v7, v12

    iget v11, v11, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->rightMargin:I

    add-int/2addr v7, v11

    sub-int/2addr v5, v7

    .line 486
    invoke-virtual {v0, v8}, Landroidx/appcompat/widget/ActionMenuView;->hasSupportDividerBeforeChildAt(I)Z

    add-int/lit8 v10, v10, 0x1

    :goto_8a
    add-int/lit8 v8, v8, 0x1

    goto :goto_2a

    :cond_8d
    if-ne v1, v12, :cond_ac

    if-nez v9, :cond_ac

    const/4 v3, 0x0

    .line 494
    invoke-virtual {v0, v3}, Landroidx/appcompat/widget/ActionMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 495
    invoke-virtual {v1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v3

    .line 496
    invoke-virtual {v1}, Landroid/view/View;->getMeasuredHeight()I

    move-result v5

    .line 497
    div-int/lit8 v4, v4, 0x2

    .line 498
    div-int/lit8 v6, v3, 0x2

    sub-int/2addr v4, v6

    .line 499
    div-int/lit8 v6, v5, 0x2

    sub-int/2addr v2, v6

    add-int/2addr v3, v4

    add-int/2addr v5, v2

    .line 500
    invoke-virtual {v1, v4, v2, v3, v5}, Landroid/view/View;->layout(IIII)V

    return-void

    :cond_ac
    xor-int/lit8 v3, v9, 0x1

    sub-int/2addr v10, v3

    if-lez v10, :cond_b4

    .line 505
    div-int v3, v5, v10

    goto :goto_b5

    :cond_b4
    const/4 v3, 0x0

    :goto_b5
    const/4 v4, 0x0

    invoke-static {v4, v3}, Ljava/lang/Math;->max(II)I

    move-result v3

    if-eqz v6, :cond_fa

    .line 508
    invoke-virtual/range {p0 .. p0}, Landroidx/appcompat/widget/ActionMenuView;->getWidth()I

    move-result v5

    invoke-virtual/range {p0 .. p0}, Landroidx/appcompat/widget/ActionMenuView;->getPaddingRight()I

    move-result v6

    sub-int/2addr v5, v6

    move v7, v4

    :goto_c6
    if-ge v7, v1, :cond_133

    .line 510
    invoke-virtual {v0, v7}, Landroidx/appcompat/widget/ActionMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    .line 511
    invoke-virtual {v4}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v6

    check-cast v6, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;

    .line 512
    invoke-virtual {v4}, Landroid/view/View;->getVisibility()I

    move-result v8

    if-eq v8, v11, :cond_f7

    iget-boolean v8, v6, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->isOverflowButton:Z

    if-eqz v8, :cond_dd

    goto :goto_f7

    .line 516
    :cond_dd
    iget v8, v6, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->rightMargin:I

    sub-int/2addr v5, v8

    .line 517
    invoke-virtual {v4}, Landroid/view/View;->getMeasuredWidth()I

    move-result v8

    .line 518
    invoke-virtual {v4}, Landroid/view/View;->getMeasuredHeight()I

    move-result v9

    .line 519
    div-int/lit8 v10, v9, 0x2

    sub-int v10, v2, v10

    sub-int v12, v5, v8

    add-int/2addr v9, v10

    .line 520
    invoke-virtual {v4, v12, v10, v5, v9}, Landroid/view/View;->layout(IIII)V

    .line 521
    iget v4, v6, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->leftMargin:I

    add-int/2addr v8, v4

    add-int/2addr v8, v3

    sub-int/2addr v5, v8

    :cond_f7
    :goto_f7
    add-int/lit8 v7, v7, 0x1

    goto :goto_c6

    .line 524
    :cond_fa
    invoke-virtual/range {p0 .. p0}, Landroidx/appcompat/widget/ActionMenuView;->getPaddingLeft()I

    move-result v5

    move v7, v4

    :goto_ff
    if-ge v7, v1, :cond_133

    .line 526
    invoke-virtual {v0, v7}, Landroidx/appcompat/widget/ActionMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    .line 527
    invoke-virtual {v4}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v6

    check-cast v6, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;

    .line 528
    invoke-virtual {v4}, Landroid/view/View;->getVisibility()I

    move-result v8

    if-eq v8, v11, :cond_130

    iget-boolean v8, v6, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->isOverflowButton:Z

    if-eqz v8, :cond_116

    goto :goto_130

    .line 532
    :cond_116
    iget v8, v6, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->leftMargin:I

    add-int/2addr v5, v8

    .line 533
    invoke-virtual {v4}, Landroid/view/View;->getMeasuredWidth()I

    move-result v8

    .line 534
    invoke-virtual {v4}, Landroid/view/View;->getMeasuredHeight()I

    move-result v9

    .line 535
    div-int/lit8 v10, v9, 0x2

    sub-int v10, v2, v10

    add-int v12, v5, v8

    add-int/2addr v9, v10

    .line 536
    invoke-virtual {v4, v5, v10, v12, v9}, Landroid/view/View;->layout(IIII)V

    .line 537
    iget v4, v6, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->rightMargin:I

    add-int/2addr v8, v4

    add-int/2addr v8, v3

    add-int/2addr v5, v8

    :cond_130
    :goto_130
    add-int/lit8 v7, v7, 0x1

    goto :goto_ff

    :cond_133
    return-void
.end method

.method protected onMeasure(II)V
    .registers 8

    .line 150
    iget-boolean v0, p0, Landroidx/appcompat/widget/ActionMenuView;->mFormatItems:Z

    .line 151
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v1

    const/high16 v2, 0x40000000    # 2.0f

    const/4 v3, 0x1

    const/4 v4, 0x0

    if-ne v1, v2, :cond_e

    move v1, v3

    goto :goto_f

    :cond_e
    move v1, v4

    :goto_f
    iput-boolean v1, p0, Landroidx/appcompat/widget/ActionMenuView;->mFormatItems:Z

    if-eq v0, v1, :cond_15

    .line 154
    iput v4, p0, Landroidx/appcompat/widget/ActionMenuView;->mFormatItemsWidth:I

    .line 159
    :cond_15
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v0

    .line 160
    iget-boolean v1, p0, Landroidx/appcompat/widget/ActionMenuView;->mFormatItems:Z

    if-eqz v1, :cond_2a

    iget-object v1, p0, Landroidx/appcompat/widget/ActionMenuView;->mMenu:Landroidx/appcompat/view/menu/MenuBuilder;

    if-eqz v1, :cond_2a

    iget v2, p0, Landroidx/appcompat/widget/ActionMenuView;->mFormatItemsWidth:I

    if-eq v0, v2, :cond_2a

    .line 161
    iput v0, p0, Landroidx/appcompat/widget/ActionMenuView;->mFormatItemsWidth:I

    .line 162
    invoke-virtual {v1, v3}, Landroidx/appcompat/view/menu/MenuBuilder;->onItemsChanged(Z)V

    .line 165
    :cond_2a
    invoke-virtual {p0}, Landroidx/appcompat/widget/ActionMenuView;->getChildCount()I

    move-result v0

    .line 166
    iget-boolean v1, p0, Landroidx/appcompat/widget/ActionMenuView;->mFormatItems:Z

    if-eqz v1, :cond_38

    if-lez v0, :cond_38

    .line 167
    invoke-direct {p0, p1, p2}, Landroidx/appcompat/widget/ActionMenuView;->onMeasureExactFormat(II)V

    goto :goto_4f

    :cond_38
    move v1, v4

    :goto_39
    if-ge v1, v0, :cond_4c

    .line 171
    invoke-virtual {p0, v1}, Landroidx/appcompat/widget/ActionMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 172
    invoke-virtual {v2}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    check-cast v2, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;

    .line 173
    iput v4, v2, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->rightMargin:I

    iput v4, v2, Landroidx/appcompat/widget/ActionMenuView$LayoutParams;->leftMargin:I

    add-int/lit8 v1, v1, 0x1

    goto :goto_39

    .line 175
    :cond_4c
    invoke-super {p0, p1, p2}, Landroidx/appcompat/widget/LinearLayoutCompat;->onMeasure(II)V

    :goto_4f
    return-void
.end method

.method public peekMenu()Landroidx/appcompat/view/menu/MenuBuilder;
    .registers 2

    .line 682
    iget-object v0, p0, Landroidx/appcompat/widget/ActionMenuView;->mMenu:Landroidx/appcompat/view/menu/MenuBuilder;

    return-object v0
.end method

.method public setExpandedActionViewsExclusive(Z)V
    .registers 3

    .line 756
    iget-object v0, p0, Landroidx/appcompat/widget/ActionMenuView;->mPresenter:Landroidx/appcompat/widget/ActionMenuPresenter;

    invoke-virtual {v0, p1}, Landroidx/appcompat/widget/ActionMenuPresenter;->setExpandedActionViewsExclusive(Z)V

    return-void
.end method

.method public setMenuCallbacks(Landroidx/appcompat/view/menu/MenuPresenter$Callback;Landroidx/appcompat/view/menu/MenuBuilder$Callback;)V
    .registers 3

    .line 672
    iput-object p1, p0, Landroidx/appcompat/widget/ActionMenuView;->mActionMenuPresenterCallback:Landroidx/appcompat/view/menu/MenuPresenter$Callback;

    .line 673
    iput-object p2, p0, Landroidx/appcompat/widget/ActionMenuView;->mMenuBuilderCallback:Landroidx/appcompat/view/menu/MenuBuilder$Callback;

    return-void
.end method

.method public setOnMenuItemClickListener(Landroidx/appcompat/widget/ActionMenuView$OnMenuItemClickListener;)V
    .registers 2

    .line 144
    iput-object p1, p0, Landroidx/appcompat/widget/ActionMenuView;->mOnMenuItemClickListener:Landroidx/appcompat/widget/ActionMenuView$OnMenuItemClickListener;

    return-void
.end method

.method public setOverflowIcon(Landroid/graphics/drawable/Drawable;)V
    .registers 3

    .line 554
    invoke-virtual {p0}, Landroidx/appcompat/widget/ActionMenuView;->getMenu()Landroid/view/Menu;

    .line 555
    iget-object v0, p0, Landroidx/appcompat/widget/ActionMenuView;->mPresenter:Landroidx/appcompat/widget/ActionMenuPresenter;

    invoke-virtual {v0, p1}, Landroidx/appcompat/widget/ActionMenuPresenter;->setOverflowIcon(Landroid/graphics/drawable/Drawable;)V

    return-void
.end method

.method public setOverflowReserved(Z)V
    .registers 2

    .line 578
    iput-boolean p1, p0, Landroidx/appcompat/widget/ActionMenuView;->mReserveOverflow:Z

    return-void
.end method

.method public setPopupTheme(I)V
    .registers 4

    .line 100
    iget v0, p0, Landroidx/appcompat/widget/ActionMenuView;->mPopupTheme:I

    if-eq v0, p1, :cond_1a

    .line 101
    iput p1, p0, Landroidx/appcompat/widget/ActionMenuView;->mPopupTheme:I

    if-nez p1, :cond_f

    .line 103
    invoke-virtual {p0}, Landroidx/appcompat/widget/ActionMenuView;->getContext()Landroid/content/Context;

    move-result-object p1

    iput-object p1, p0, Landroidx/appcompat/widget/ActionMenuView;->mPopupContext:Landroid/content/Context;

    goto :goto_1a

    .line 105
    :cond_f
    new-instance v0, Landroid/view/ContextThemeWrapper;

    invoke-virtual {p0}, Landroidx/appcompat/widget/ActionMenuView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Landroid/view/ContextThemeWrapper;-><init>(Landroid/content/Context;I)V

    iput-object v0, p0, Landroidx/appcompat/widget/ActionMenuView;->mPopupContext:Landroid/content/Context;

    :cond_1a
    :goto_1a
    return-void
.end method

.method public setPresenter(Landroidx/appcompat/widget/ActionMenuPresenter;)V
    .registers 2

    .line 125
    iput-object p1, p0, Landroidx/appcompat/widget/ActionMenuView;->mPresenter:Landroidx/appcompat/widget/ActionMenuPresenter;

    .line 126
    invoke-virtual {p1, p0}, Landroidx/appcompat/widget/ActionMenuPresenter;->setMenuView(Landroidx/appcompat/widget/ActionMenuView;)V

    return-void
.end method

.method public showOverflowMenu()Z
    .registers 2

    .line 691
    iget-object v0, p0, Landroidx/appcompat/widget/ActionMenuView;->mPresenter:Landroidx/appcompat/widget/ActionMenuPresenter;

    if-eqz v0, :cond_c

    invoke-virtual {v0}, Landroidx/appcompat/widget/ActionMenuPresenter;->showOverflowMenu()Z

    move-result v0

    if-eqz v0, :cond_c

    const/4 v0, 0x1

    goto :goto_d

    :cond_c
    const/4 v0, 0x0

    :goto_d
    return v0
.end method
