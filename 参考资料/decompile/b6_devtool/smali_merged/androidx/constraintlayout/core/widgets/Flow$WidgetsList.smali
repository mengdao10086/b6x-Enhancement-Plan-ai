.class Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;
.super Ljava/lang/Object;
.source "Flow.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/constraintlayout/core/widgets/Flow;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "WidgetsList"
.end annotation


# instance fields
.field private biggest:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

.field biggestDimension:I

.field private mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

.field private mCount:I

.field private mHeight:I

.field private mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

.field private mMax:I

.field private mNbMatchConstraintsWidgets:I

.field private mOrientation:I

.field private mPaddingBottom:I

.field private mPaddingLeft:I

.field private mPaddingRight:I

.field private mPaddingTop:I

.field private mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

.field private mStartIndex:I

.field private mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

.field private mWidth:I

.field final synthetic this$0:Landroidx/constraintlayout/core/widgets/Flow;


# direct methods
.method public constructor <init>(Landroidx/constraintlayout/core/widgets/Flow;ILandroidx/constraintlayout/core/widgets/ConstraintAnchor;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)V
    .registers 9

    .line 364
    iput-object p1, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    .line 344
    iput-object v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->biggest:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    const/4 v0, 0x0

    .line 345
    iput v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->biggestDimension:I

    .line 350
    iput v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mPaddingLeft:I

    .line 351
    iput v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mPaddingTop:I

    .line 352
    iput v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mPaddingRight:I

    .line 353
    iput v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mPaddingBottom:I

    .line 354
    iput v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mWidth:I

    .line 355
    iput v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mHeight:I

    .line 356
    iput v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mStartIndex:I

    .line 357
    iput v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mCount:I

    .line 358
    iput v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mNbMatchConstraintsWidgets:I

    .line 359
    iput v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mMax:I

    .line 365
    iput p2, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mOrientation:I

    .line 366
    iput-object p3, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 367
    iput-object p4, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 368
    iput-object p5, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 369
    iput-object p6, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 370
    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/Flow;->getPaddingLeft()I

    move-result p2

    iput p2, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mPaddingLeft:I

    .line 371
    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/Flow;->getPaddingTop()I

    move-result p2

    iput p2, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mPaddingTop:I

    .line 372
    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/Flow;->getPaddingRight()I

    move-result p2

    iput p2, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mPaddingRight:I

    .line 373
    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/Flow;->getPaddingBottom()I

    move-result p1

    iput p1, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mPaddingBottom:I

    .line 374
    iput p7, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mMax:I

    return-void
.end method

.method static synthetic access$2000(Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;)Landroidx/constraintlayout/core/widgets/ConstraintWidget;
    .registers 1

    .line 342
    iget-object p0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->biggest:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    return-object p0
.end method

.method private recomputeDimensions()V
    .registers 10

    const/4 v0, 0x0

    .line 738
    iput v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mWidth:I

    .line 739
    iput v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mHeight:I

    const/4 v1, 0x0

    .line 740
    iput-object v1, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->biggest:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 741
    iput v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->biggestDimension:I

    .line 742
    iget v1, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mCount:I

    move v2, v0

    :goto_d
    if-ge v2, v1, :cond_90

    .line 744
    iget v3, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mStartIndex:I

    add-int/2addr v3, v2

    iget-object v4, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mDisplayedWidgetsCount:I
    invoke-static {v4}, Landroidx/constraintlayout/core/widgets/Flow;->access$400(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v4

    if-lt v3, v4, :cond_1c

    goto/16 :goto_90

    .line 747
    :cond_1c
    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mDisplayedWidgets:[Landroidx/constraintlayout/core/widgets/ConstraintWidget;
    invoke-static {v3}, Landroidx/constraintlayout/core/widgets/Flow;->access$500(Landroidx/constraintlayout/core/widgets/Flow;)[Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v3

    iget v4, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mStartIndex:I

    add-int/2addr v4, v2

    aget-object v3, v3, v4

    .line 748
    iget v4, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mOrientation:I

    const/16 v5, 0x8

    if-nez v4, :cond_5b

    .line 749
    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getWidth()I

    move-result v4

    .line 750
    iget-object v6, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mHorizontalGap:I
    invoke-static {v6}, Landroidx/constraintlayout/core/widgets/Flow;->access$000(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v6

    .line 751
    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getVisibility()I

    move-result v7

    if-ne v7, v5, :cond_3e

    move v6, v0

    .line 754
    :cond_3e
    iget v5, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mWidth:I

    add-int/2addr v4, v6

    add-int/2addr v5, v4

    iput v5, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mWidth:I

    .line 755
    iget-object v4, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    iget v5, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mMax:I

    # invokes: Landroidx/constraintlayout/core/widgets/Flow;->getWidgetHeight(Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)I
    invoke-static {v4, v3, v5}, Landroidx/constraintlayout/core/widgets/Flow;->access$300(Landroidx/constraintlayout/core/widgets/Flow;Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)I

    move-result v4

    .line 756
    iget-object v5, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->biggest:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    if-eqz v5, :cond_54

    iget v5, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->biggestDimension:I

    if-ge v5, v4, :cond_8c

    .line 757
    :cond_54
    iput-object v3, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->biggest:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 758
    iput v4, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->biggestDimension:I

    .line 759
    iput v4, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mHeight:I

    goto :goto_8c

    .line 762
    :cond_5b
    iget-object v4, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    iget v6, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mMax:I

    # invokes: Landroidx/constraintlayout/core/widgets/Flow;->getWidgetWidth(Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)I
    invoke-static {v4, v3, v6}, Landroidx/constraintlayout/core/widgets/Flow;->access$200(Landroidx/constraintlayout/core/widgets/Flow;Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)I

    move-result v4

    .line 763
    iget-object v6, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    iget v7, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mMax:I

    # invokes: Landroidx/constraintlayout/core/widgets/Flow;->getWidgetHeight(Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)I
    invoke-static {v6, v3, v7}, Landroidx/constraintlayout/core/widgets/Flow;->access$300(Landroidx/constraintlayout/core/widgets/Flow;Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)I

    move-result v6

    .line 764
    iget-object v7, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mVerticalGap:I
    invoke-static {v7}, Landroidx/constraintlayout/core/widgets/Flow;->access$100(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v7

    .line 765
    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getVisibility()I

    move-result v8

    if-ne v8, v5, :cond_78

    move v7, v0

    .line 768
    :cond_78
    iget v5, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mHeight:I

    add-int/2addr v6, v7

    add-int/2addr v5, v6

    iput v5, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mHeight:I

    .line 769
    iget-object v5, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->biggest:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    if-eqz v5, :cond_86

    iget v5, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->biggestDimension:I

    if-ge v5, v4, :cond_8c

    .line 770
    :cond_86
    iput-object v3, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->biggest:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 771
    iput v4, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->biggestDimension:I

    .line 772
    iput v4, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mWidth:I

    :cond_8c
    :goto_8c
    add-int/lit8 v2, v2, 0x1

    goto/16 :goto_d

    :cond_90
    :goto_90
    return-void
.end method


# virtual methods
.method public add(Landroidx/constraintlayout/core/widgets/ConstraintWidget;)V
    .registers 8

    .line 420
    iget v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mOrientation:I

    const/16 v1, 0x8

    const/4 v2, 0x0

    if-nez v0, :cond_49

    .line 421
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    iget v3, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mMax:I

    # invokes: Landroidx/constraintlayout/core/widgets/Flow;->getWidgetWidth(Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)I
    invoke-static {v0, p1, v3}, Landroidx/constraintlayout/core/widgets/Flow;->access$200(Landroidx/constraintlayout/core/widgets/Flow;Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)I

    move-result v0

    .line 422
    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHorizontalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object v3

    sget-object v4, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v3, v4, :cond_1e

    .line 423
    iget v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mNbMatchConstraintsWidgets:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mNbMatchConstraintsWidgets:I

    move v0, v2

    .line 426
    :cond_1e
    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mHorizontalGap:I
    invoke-static {v3}, Landroidx/constraintlayout/core/widgets/Flow;->access$000(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v3

    .line 427
    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getVisibility()I

    move-result v4

    if-ne v4, v1, :cond_2b

    goto :goto_2c

    :cond_2b
    move v2, v3

    .line 430
    :goto_2c
    iget v1, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mWidth:I

    add-int/2addr v0, v2

    add-int/2addr v1, v0

    iput v1, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mWidth:I

    .line 431
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    iget v1, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mMax:I

    # invokes: Landroidx/constraintlayout/core/widgets/Flow;->getWidgetHeight(Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)I
    invoke-static {v0, p1, v1}, Landroidx/constraintlayout/core/widgets/Flow;->access$300(Landroidx/constraintlayout/core/widgets/Flow;Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)I

    move-result v0

    .line 432
    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->biggest:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    if-eqz v1, :cond_42

    iget v1, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->biggestDimension:I

    if-ge v1, v0, :cond_8a

    .line 433
    :cond_42
    iput-object p1, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->biggest:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 434
    iput v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->biggestDimension:I

    .line 435
    iput v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mHeight:I

    goto :goto_8a

    .line 438
    :cond_49
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    iget v3, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mMax:I

    # invokes: Landroidx/constraintlayout/core/widgets/Flow;->getWidgetWidth(Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)I
    invoke-static {v0, p1, v3}, Landroidx/constraintlayout/core/widgets/Flow;->access$200(Landroidx/constraintlayout/core/widgets/Flow;Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)I

    move-result v0

    .line 439
    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    iget v4, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mMax:I

    # invokes: Landroidx/constraintlayout/core/widgets/Flow;->getWidgetHeight(Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)I
    invoke-static {v3, p1, v4}, Landroidx/constraintlayout/core/widgets/Flow;->access$300(Landroidx/constraintlayout/core/widgets/Flow;Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)I

    move-result v3

    .line 440
    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getVerticalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object v4

    sget-object v5, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v4, v5, :cond_68

    .line 441
    iget v3, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mNbMatchConstraintsWidgets:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mNbMatchConstraintsWidgets:I

    move v3, v2

    .line 444
    :cond_68
    iget-object v4, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mVerticalGap:I
    invoke-static {v4}, Landroidx/constraintlayout/core/widgets/Flow;->access$100(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v4

    .line 445
    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getVisibility()I

    move-result v5

    if-ne v5, v1, :cond_75

    goto :goto_76

    :cond_75
    move v2, v4

    .line 448
    :goto_76
    iget v1, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mHeight:I

    add-int/2addr v3, v2

    add-int/2addr v1, v3

    iput v1, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mHeight:I

    .line 449
    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->biggest:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    if-eqz v1, :cond_84

    iget v1, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->biggestDimension:I

    if-ge v1, v0, :cond_8a

    .line 450
    :cond_84
    iput-object p1, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->biggest:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 451
    iput v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->biggestDimension:I

    .line 452
    iput v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mWidth:I

    .line 455
    :cond_8a
    :goto_8a
    iget p1, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mCount:I

    add-int/lit8 p1, p1, 0x1

    iput p1, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mCount:I

    return-void
.end method

.method public clear()V
    .registers 3

    const/4 v0, 0x0

    .line 394
    iput v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->biggestDimension:I

    const/4 v1, 0x0

    .line 395
    iput-object v1, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->biggest:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 396
    iput v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mWidth:I

    .line 397
    iput v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mHeight:I

    .line 398
    iput v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mStartIndex:I

    .line 399
    iput v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mCount:I

    .line 400
    iput v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mNbMatchConstraintsWidgets:I

    return-void
.end method

.method public createConstraints(ZIZ)V
    .registers 20

    move-object/from16 v0, p0

    .line 459
    iget v1, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mCount:I

    const/4 v2, 0x0

    move v3, v2

    :goto_6
    if-ge v3, v1, :cond_27

    .line 461
    iget v4, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mStartIndex:I

    add-int/2addr v4, v3

    iget-object v5, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mDisplayedWidgetsCount:I
    invoke-static {v5}, Landroidx/constraintlayout/core/widgets/Flow;->access$400(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v5

    if-lt v4, v5, :cond_14

    goto :goto_27

    .line 464
    :cond_14
    iget-object v4, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mDisplayedWidgets:[Landroidx/constraintlayout/core/widgets/ConstraintWidget;
    invoke-static {v4}, Landroidx/constraintlayout/core/widgets/Flow;->access$500(Landroidx/constraintlayout/core/widgets/Flow;)[Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v4

    iget v5, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mStartIndex:I

    add-int/2addr v5, v3

    aget-object v4, v4, v5

    if-eqz v4, :cond_24

    .line 466
    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resetAnchors()V

    :cond_24
    add-int/lit8 v3, v3, 0x1

    goto :goto_6

    :cond_27
    :goto_27
    if-eqz v1, :cond_384

    .line 469
    iget-object v3, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->biggest:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    if-nez v3, :cond_2f

    goto/16 :goto_384

    :cond_2f
    if-eqz p3, :cond_35

    if-nez p2, :cond_35

    const/4 v4, 0x1

    goto :goto_36

    :cond_35
    move v4, v2

    :goto_36
    const/4 v5, -0x1

    move v6, v2

    move v7, v5

    move v8, v7

    :goto_3a
    if-ge v6, v1, :cond_69

    if-eqz p1, :cond_42

    add-int/lit8 v9, v1, -0x1

    sub-int/2addr v9, v6

    goto :goto_43

    :cond_42
    move v9, v6

    .line 481
    :goto_43
    iget v10, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mStartIndex:I

    add-int/2addr v10, v9

    iget-object v11, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mDisplayedWidgetsCount:I
    invoke-static {v11}, Landroidx/constraintlayout/core/widgets/Flow;->access$400(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v11

    if-lt v10, v11, :cond_4f

    goto :goto_69

    .line 484
    :cond_4f
    iget-object v10, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mDisplayedWidgets:[Landroidx/constraintlayout/core/widgets/ConstraintWidget;
    invoke-static {v10}, Landroidx/constraintlayout/core/widgets/Flow;->access$500(Landroidx/constraintlayout/core/widgets/Flow;)[Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v10

    iget v11, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mStartIndex:I

    add-int/2addr v11, v9

    aget-object v9, v10, v11

    if-eqz v9, :cond_66

    .line 485
    invoke-virtual {v9}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getVisibility()I

    move-result v9

    if-nez v9, :cond_66

    if-ne v7, v5, :cond_65

    move v7, v6

    :cond_65
    move v8, v6

    :cond_66
    add-int/lit8 v6, v6, 0x1

    goto :goto_3a

    .line 494
    :cond_69
    :goto_69
    iget v6, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mOrientation:I

    const/4 v9, 0x0

    if-nez v6, :cond_20e

    .line 495
    iget-object v6, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->biggest:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 496
    iget-object v10, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mVerticalStyle:I
    invoke-static {v10}, Landroidx/constraintlayout/core/widgets/Flow;->access$600(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v10

    invoke-virtual {v6, v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setVerticalChainStyle(I)V

    .line 497
    iget v10, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mPaddingTop:I

    if-lez p2, :cond_84

    .line 499
    iget-object v11, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mVerticalGap:I
    invoke-static {v11}, Landroidx/constraintlayout/core/widgets/Flow;->access$100(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v11

    add-int/2addr v10, v11

    .line 501
    :cond_84
    iget-object v11, v6, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v12, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v11, v12, v10}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    if-eqz p3, :cond_96

    .line 503
    iget-object v10, v6, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v11, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget v12, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mPaddingBottom:I

    invoke-virtual {v10, v11, v12}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    :cond_96
    if-lez p2, :cond_a3

    .line 506
    iget-object v10, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v10, v10, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v10, v10, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 507
    iget-object v11, v6, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v10, v11, v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    .line 511
    :cond_a3
    iget-object v10, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mVerticalAlign:I
    invoke-static {v10}, Landroidx/constraintlayout/core/widgets/Flow;->access$700(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v10

    const/4 v11, 0x3

    if-ne v10, v11, :cond_dd

    invoke-virtual {v6}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->hasBaseline()Z

    move-result v10

    if-nez v10, :cond_dd

    move v10, v2

    :goto_b3
    if-ge v10, v1, :cond_dd

    if-eqz p1, :cond_bb

    add-int/lit8 v12, v1, -0x1

    sub-int/2addr v12, v10

    goto :goto_bc

    :cond_bb
    move v12, v10

    .line 517
    :goto_bc
    iget v13, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mStartIndex:I

    add-int/2addr v13, v12

    iget-object v14, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mDisplayedWidgetsCount:I
    invoke-static {v14}, Landroidx/constraintlayout/core/widgets/Flow;->access$400(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v14

    if-lt v13, v14, :cond_c8

    goto :goto_dd

    .line 520
    :cond_c8
    iget-object v13, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mDisplayedWidgets:[Landroidx/constraintlayout/core/widgets/ConstraintWidget;
    invoke-static {v13}, Landroidx/constraintlayout/core/widgets/Flow;->access$500(Landroidx/constraintlayout/core/widgets/Flow;)[Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v13

    iget v14, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mStartIndex:I

    add-int/2addr v14, v12

    aget-object v12, v13, v14

    .line 521
    invoke-virtual {v12}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->hasBaseline()Z

    move-result v13

    if-eqz v13, :cond_da

    goto :goto_de

    :cond_da
    add-int/lit8 v10, v10, 0x1

    goto :goto_b3

    :cond_dd
    :goto_dd
    move-object v12, v6

    :goto_de
    move v10, v2

    :goto_df
    if-ge v10, v1, :cond_384

    if-eqz p1, :cond_e7

    add-int/lit8 v13, v1, -0x1

    sub-int/2addr v13, v10

    goto :goto_e8

    :cond_e7
    move v13, v10

    .line 533
    :goto_e8
    iget v14, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mStartIndex:I

    add-int/2addr v14, v13

    iget-object v15, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mDisplayedWidgetsCount:I
    invoke-static {v15}, Landroidx/constraintlayout/core/widgets/Flow;->access$400(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v15

    if-lt v14, v15, :cond_f5

    goto/16 :goto_384

    .line 536
    :cond_f5
    iget-object v14, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mDisplayedWidgets:[Landroidx/constraintlayout/core/widgets/ConstraintWidget;
    invoke-static {v14}, Landroidx/constraintlayout/core/widgets/Flow;->access$500(Landroidx/constraintlayout/core/widgets/Flow;)[Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v14

    iget v15, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mStartIndex:I

    add-int/2addr v15, v13

    aget-object v14, v14, v15

    if-nez v14, :cond_106

    move-object v14, v9

    move v9, v11

    goto/16 :goto_208

    :cond_106
    if-nez v10, :cond_111

    .line 541
    iget-object v15, v14, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v11, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget v3, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mPaddingLeft:I

    invoke-virtual {v14, v15, v11, v3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)V

    :cond_111
    if-nez v13, :cond_16f

    .line 547
    iget-object v3, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mHorizontalStyle:I
    invoke-static {v3}, Landroidx/constraintlayout/core/widgets/Flow;->access$800(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v3

    const/high16 v11, 0x3f800000    # 1.0f

    .line 548
    iget-object v13, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mHorizontalBias:F
    invoke-static {v13}, Landroidx/constraintlayout/core/widgets/Flow;->access$900(Landroidx/constraintlayout/core/widgets/Flow;)F

    move-result v13

    if-eqz p1, :cond_125

    sub-float v13, v11, v13

    .line 549
    :cond_125
    iget v15, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mStartIndex:I

    if-nez v15, :cond_149

    iget-object v15, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mFirstHorizontalStyle:I
    invoke-static {v15}, Landroidx/constraintlayout/core/widgets/Flow;->access$1000(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v15

    if-eq v15, v5, :cond_149

    .line 550
    iget-object v3, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mFirstHorizontalStyle:I
    invoke-static {v3}, Landroidx/constraintlayout/core/widgets/Flow;->access$1000(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v3

    if-eqz p1, :cond_141

    .line 551
    iget-object v13, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mFirstHorizontalBias:F
    invoke-static {v13}, Landroidx/constraintlayout/core/widgets/Flow;->access$1100(Landroidx/constraintlayout/core/widgets/Flow;)F

    move-result v13

    :goto_13f
    sub-float/2addr v11, v13

    goto :goto_147

    :cond_141
    iget-object v11, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mFirstHorizontalBias:F
    invoke-static {v11}, Landroidx/constraintlayout/core/widgets/Flow;->access$1100(Landroidx/constraintlayout/core/widgets/Flow;)F

    move-result v11

    :goto_147
    move v13, v11

    goto :goto_169

    :cond_149
    if-eqz p3, :cond_169

    .line 552
    iget-object v15, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mLastHorizontalStyle:I
    invoke-static {v15}, Landroidx/constraintlayout/core/widgets/Flow;->access$1200(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v15

    if-eq v15, v5, :cond_169

    .line 553
    iget-object v3, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mLastHorizontalStyle:I
    invoke-static {v3}, Landroidx/constraintlayout/core/widgets/Flow;->access$1200(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v3

    if-eqz p1, :cond_162

    .line 554
    iget-object v13, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mLastHorizontalBias:F
    invoke-static {v13}, Landroidx/constraintlayout/core/widgets/Flow;->access$1300(Landroidx/constraintlayout/core/widgets/Flow;)F

    move-result v13

    goto :goto_13f

    :cond_162
    iget-object v11, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mLastHorizontalBias:F
    invoke-static {v11}, Landroidx/constraintlayout/core/widgets/Flow;->access$1300(Landroidx/constraintlayout/core/widgets/Flow;)F

    move-result v11

    goto :goto_147

    .line 556
    :cond_169
    :goto_169
    invoke-virtual {v14, v3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setHorizontalChainStyle(I)V

    .line 557
    invoke-virtual {v14, v13}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setHorizontalBiasPercent(F)V

    :cond_16f
    add-int/lit8 v3, v1, -0x1

    if-ne v10, v3, :cond_17c

    .line 560
    iget-object v3, v14, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v11, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget v13, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mPaddingRight:I

    invoke-virtual {v14, v3, v11, v13}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)V

    :cond_17c
    if-eqz v9, :cond_1a7

    .line 563
    iget-object v3, v14, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v11, v9, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v13, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mHorizontalGap:I
    invoke-static {v13}, Landroidx/constraintlayout/core/widgets/Flow;->access$000(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v13

    invoke-virtual {v3, v11, v13}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    if-ne v10, v7, :cond_194

    .line 565
    iget-object v3, v14, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget v11, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mPaddingLeft:I

    invoke-virtual {v3, v11}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->setGoneMargin(I)V

    .line 567
    :cond_194
    iget-object v3, v9, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v11, v14, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v3, v11, v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    const/4 v3, 0x1

    add-int/lit8 v11, v8, 0x1

    if-ne v10, v11, :cond_1a7

    .line 569
    iget-object v3, v9, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget v9, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mPaddingRight:I

    invoke-virtual {v3, v9}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->setGoneMargin(I)V

    :cond_1a7
    if-eq v14, v6, :cond_207

    .line 573
    iget-object v3, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mVerticalAlign:I
    invoke-static {v3}, Landroidx/constraintlayout/core/widgets/Flow;->access$700(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v3

    const/4 v9, 0x3

    if-ne v3, v9, :cond_1c8

    .line 574
    invoke-virtual {v12}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->hasBaseline()Z

    move-result v3

    if-eqz v3, :cond_1c8

    if-eq v14, v12, :cond_1c8

    .line 576
    invoke-virtual {v14}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->hasBaseline()Z

    move-result v3

    if-eqz v3, :cond_1c8

    .line 577
    iget-object v3, v14, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v11, v12, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v3, v11, v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    goto :goto_208

    .line 579
    :cond_1c8
    iget-object v3, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mVerticalAlign:I
    invoke-static {v3}, Landroidx/constraintlayout/core/widgets/Flow;->access$700(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v3

    if-eqz v3, :cond_1ff

    const/4 v11, 0x1

    if-eq v3, v11, :cond_1f7

    if-eqz v4, :cond_1e8

    .line 591
    iget-object v3, v14, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v11, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget v13, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mPaddingTop:I

    invoke-virtual {v3, v11, v13}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    .line 592
    iget-object v3, v14, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v11, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget v13, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mPaddingBottom:I

    invoke-virtual {v3, v11, v13}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    goto :goto_208

    .line 594
    :cond_1e8
    iget-object v3, v14, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v11, v6, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v3, v11, v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    .line 595
    iget-object v3, v14, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v11, v6, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v3, v11, v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    goto :goto_208

    .line 585
    :cond_1f7
    iget-object v3, v14, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v11, v6, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v3, v11, v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    goto :goto_208

    .line 581
    :cond_1ff
    iget-object v3, v14, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v11, v6, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v3, v11, v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    goto :goto_208

    :cond_207
    const/4 v9, 0x3

    :goto_208
    add-int/lit8 v10, v10, 0x1

    move v11, v9

    move-object v9, v14

    goto/16 :goto_df

    .line 604
    :cond_20e
    iget-object v3, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->biggest:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 605
    iget-object v6, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mHorizontalStyle:I
    invoke-static {v6}, Landroidx/constraintlayout/core/widgets/Flow;->access$800(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v6

    invoke-virtual {v3, v6}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setHorizontalChainStyle(I)V

    .line 606
    iget v6, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mPaddingLeft:I

    if-lez p2, :cond_224

    .line 608
    iget-object v10, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mHorizontalGap:I
    invoke-static {v10}, Landroidx/constraintlayout/core/widgets/Flow;->access$000(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v10

    add-int/2addr v6, v10

    :cond_224
    if-eqz p1, :cond_246

    .line 611
    iget-object v10, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v11, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v10, v11, v6}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    if-eqz p3, :cond_238

    .line 613
    iget-object v6, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v10, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget v11, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mPaddingRight:I

    invoke-virtual {v6, v10, v11}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    :cond_238
    if-lez p2, :cond_265

    .line 616
    iget-object v6, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v6, v6, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v6, v6, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 617
    iget-object v10, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v6, v10, v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    goto :goto_265

    .line 620
    :cond_246
    iget-object v10, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v11, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v10, v11, v6}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    if-eqz p3, :cond_258

    .line 622
    iget-object v6, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v10, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget v11, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mPaddingRight:I

    invoke-virtual {v6, v10, v11}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    :cond_258
    if-lez p2, :cond_265

    .line 625
    iget-object v6, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v6, v6, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v6, v6, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 626
    iget-object v10, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v6, v10, v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    :cond_265
    :goto_265
    move v6, v2

    :goto_266
    if-ge v6, v1, :cond_384

    .line 630
    iget v10, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mStartIndex:I

    add-int/2addr v10, v6

    iget-object v11, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mDisplayedWidgetsCount:I
    invoke-static {v11}, Landroidx/constraintlayout/core/widgets/Flow;->access$400(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v11

    if-lt v10, v11, :cond_275

    goto/16 :goto_384

    .line 633
    :cond_275
    iget-object v10, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mDisplayedWidgets:[Landroidx/constraintlayout/core/widgets/ConstraintWidget;
    invoke-static {v10}, Landroidx/constraintlayout/core/widgets/Flow;->access$500(Landroidx/constraintlayout/core/widgets/Flow;)[Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v10

    iget v11, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mStartIndex:I

    add-int/2addr v11, v6

    aget-object v10, v10, v11

    if-nez v10, :cond_285

    const/4 v12, 0x1

    goto/16 :goto_380

    :cond_285
    if-nez v6, :cond_2d1

    .line 638
    iget-object v11, v10, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v12, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget v13, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mPaddingTop:I

    invoke-virtual {v10, v11, v12, v13}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)V

    .line 639
    iget-object v11, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mVerticalStyle:I
    invoke-static {v11}, Landroidx/constraintlayout/core/widgets/Flow;->access$600(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v11

    .line 640
    iget-object v12, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mVerticalBias:F
    invoke-static {v12}, Landroidx/constraintlayout/core/widgets/Flow;->access$1400(Landroidx/constraintlayout/core/widgets/Flow;)F

    move-result v12

    .line 641
    iget v13, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mStartIndex:I

    if-nez v13, :cond_2b5

    iget-object v13, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mFirstVerticalStyle:I
    invoke-static {v13}, Landroidx/constraintlayout/core/widgets/Flow;->access$1500(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v13

    if-eq v13, v5, :cond_2b5

    .line 642
    iget-object v11, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mFirstVerticalStyle:I
    invoke-static {v11}, Landroidx/constraintlayout/core/widgets/Flow;->access$1500(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v11

    .line 643
    iget-object v12, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mFirstVerticalBias:F
    invoke-static {v12}, Landroidx/constraintlayout/core/widgets/Flow;->access$1600(Landroidx/constraintlayout/core/widgets/Flow;)F

    move-result v12

    goto :goto_2cb

    :cond_2b5
    if-eqz p3, :cond_2cb

    .line 644
    iget-object v13, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mLastVerticalStyle:I
    invoke-static {v13}, Landroidx/constraintlayout/core/widgets/Flow;->access$1700(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v13

    if-eq v13, v5, :cond_2cb

    .line 645
    iget-object v11, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mLastVerticalStyle:I
    invoke-static {v11}, Landroidx/constraintlayout/core/widgets/Flow;->access$1700(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v11

    .line 646
    iget-object v12, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mLastVerticalBias:F
    invoke-static {v12}, Landroidx/constraintlayout/core/widgets/Flow;->access$1800(Landroidx/constraintlayout/core/widgets/Flow;)F

    move-result v12

    .line 648
    :cond_2cb
    :goto_2cb
    invoke-virtual {v10, v11}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setVerticalChainStyle(I)V

    .line 649
    invoke-virtual {v10, v12}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setVerticalBiasPercent(F)V

    :cond_2d1
    add-int/lit8 v11, v1, -0x1

    if-ne v6, v11, :cond_2de

    .line 652
    iget-object v11, v10, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v12, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget v13, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mPaddingBottom:I

    invoke-virtual {v10, v11, v12, v13}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)V

    :cond_2de
    if-eqz v9, :cond_309

    .line 655
    iget-object v11, v10, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v12, v9, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v13, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mVerticalGap:I
    invoke-static {v13}, Landroidx/constraintlayout/core/widgets/Flow;->access$100(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v13

    invoke-virtual {v11, v12, v13}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    if-ne v6, v7, :cond_2f6

    .line 657
    iget-object v11, v10, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget v12, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mPaddingTop:I

    invoke-virtual {v11, v12}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->setGoneMargin(I)V

    .line 659
    :cond_2f6
    iget-object v11, v9, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v12, v10, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v11, v12, v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    const/4 v11, 0x1

    add-int/lit8 v12, v8, 0x1

    if-ne v6, v12, :cond_309

    .line 661
    iget-object v9, v9, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget v11, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mPaddingBottom:I

    invoke-virtual {v9, v11}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->setGoneMargin(I)V

    :cond_309
    if-eq v10, v3, :cond_37e

    const/4 v9, 0x2

    if-eqz p1, :cond_33b

    .line 666
    iget-object v11, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mHorizontalAlign:I
    invoke-static {v11}, Landroidx/constraintlayout/core/widgets/Flow;->access$1900(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v11

    if-eqz v11, :cond_333

    const/4 v12, 0x1

    if-eq v11, v12, :cond_32b

    if-eq v11, v9, :cond_31c

    goto :goto_37e

    .line 672
    :cond_31c
    iget-object v9, v10, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v11, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v9, v11, v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    .line 673
    iget-object v9, v10, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v11, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v9, v11, v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    goto :goto_37e

    .line 677
    :cond_32b
    iget-object v9, v10, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v11, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v9, v11, v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    goto :goto_37e

    .line 668
    :cond_333
    iget-object v9, v10, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v11, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v9, v11, v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    goto :goto_37e

    .line 682
    :cond_33b
    iget-object v11, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mHorizontalAlign:I
    invoke-static {v11}, Landroidx/constraintlayout/core/widgets/Flow;->access$1900(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v11

    if-eqz v11, :cond_375

    const/4 v12, 0x1

    if-eq v11, v12, :cond_36d

    if-eq v11, v9, :cond_349

    goto :goto_37f

    :cond_349
    if-eqz v4, :cond_35e

    .line 689
    iget-object v9, v10, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v11, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget v13, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mPaddingLeft:I

    invoke-virtual {v9, v11, v13}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    .line 690
    iget-object v9, v10, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v11, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget v13, v0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mPaddingRight:I

    invoke-virtual {v9, v11, v13}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    goto :goto_37f

    .line 692
    :cond_35e
    iget-object v9, v10, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v11, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v9, v11, v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    .line 693
    iget-object v9, v10, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v11, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v9, v11, v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    goto :goto_37f

    .line 698
    :cond_36d
    iget-object v9, v10, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v11, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v9, v11, v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    goto :goto_37f

    :cond_375
    const/4 v12, 0x1

    .line 684
    iget-object v9, v10, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v11, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v9, v11, v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    goto :goto_37f

    :cond_37e
    :goto_37e
    const/4 v12, 0x1

    :goto_37f
    move-object v9, v10

    :goto_380
    add-int/lit8 v6, v6, 0x1

    goto/16 :goto_266

    :cond_384
    :goto_384
    return-void
.end method

.method public getHeight()I
    .registers 3

    .line 413
    iget v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mOrientation:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_f

    .line 414
    iget v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mHeight:I

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mVerticalGap:I
    invoke-static {v1}, Landroidx/constraintlayout/core/widgets/Flow;->access$100(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v1

    sub-int/2addr v0, v1

    return v0

    .line 416
    :cond_f
    iget v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mHeight:I

    return v0
.end method

.method public getWidth()I
    .registers 3

    .line 406
    iget v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mOrientation:I

    if-nez v0, :cond_e

    .line 407
    iget v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mWidth:I

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mHorizontalGap:I
    invoke-static {v1}, Landroidx/constraintlayout/core/widgets/Flow;->access$000(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v1

    sub-int/2addr v0, v1

    return v0

    .line 409
    :cond_e
    iget v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mWidth:I

    return v0
.end method

.method public measureMatchConstraints(I)V
    .registers 10

    .line 710
    iget v0, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mNbMatchConstraintsWidgets:I

    if-nez v0, :cond_5

    return-void

    .line 713
    :cond_5
    iget v1, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mCount:I

    .line 714
    div-int/2addr p1, v0

    const/4 v0, 0x0

    :goto_9
    if-ge v0, v1, :cond_66

    .line 716
    iget v2, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mStartIndex:I

    add-int/2addr v2, v0

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mDisplayedWidgetsCount:I
    invoke-static {v3}, Landroidx/constraintlayout/core/widgets/Flow;->access$400(Landroidx/constraintlayout/core/widgets/Flow;)I

    move-result v3

    if-lt v2, v3, :cond_17

    goto :goto_66

    .line 719
    :cond_17
    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    # getter for: Landroidx/constraintlayout/core/widgets/Flow;->mDisplayedWidgets:[Landroidx/constraintlayout/core/widgets/ConstraintWidget;
    invoke-static {v2}, Landroidx/constraintlayout/core/widgets/Flow;->access$500(Landroidx/constraintlayout/core/widgets/Flow;)[Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v2

    iget v3, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mStartIndex:I

    add-int/2addr v3, v0

    aget-object v3, v2, v3

    .line 720
    iget v2, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mOrientation:I

    if-nez v2, :cond_45

    if-eqz v3, :cond_63

    .line 721
    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHorizontalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object v2

    sget-object v4, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v2, v4, :cond_63

    .line 722
    iget v2, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultWidth:I

    if-nez v2, :cond_63

    .line 723
    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    sget-object v4, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->FIXED:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getVerticalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object v6

    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHeight()I

    move-result v7

    move v5, p1

    invoke-virtual/range {v2 .. v7}, Landroidx/constraintlayout/core/widgets/Flow;->measure(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;ILandroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;I)V

    goto :goto_63

    :cond_45
    if-eqz v3, :cond_63

    .line 727
    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getVerticalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object v2

    sget-object v4, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v2, v4, :cond_63

    .line 728
    iget v2, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultHeight:I

    if-nez v2, :cond_63

    .line 729
    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->this$0:Landroidx/constraintlayout/core/widgets/Flow;

    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHorizontalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object v4

    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getWidth()I

    move-result v5

    sget-object v6, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->FIXED:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move v7, p1

    invoke-virtual/range {v2 .. v7}, Landroidx/constraintlayout/core/widgets/Flow;->measure(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;ILandroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;I)V

    :cond_63
    :goto_63
    add-int/lit8 v0, v0, 0x1

    goto :goto_9

    .line 734
    :cond_66
    :goto_66
    invoke-direct {p0}, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->recomputeDimensions()V

    return-void
.end method

.method public setStartIndex(I)V
    .registers 2

    .line 403
    iput p1, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mStartIndex:I

    return-void
.end method

.method public setup(ILandroidx/constraintlayout/core/widgets/ConstraintAnchor;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;IIIII)V
    .registers 11

    .line 381
    iput p1, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mOrientation:I

    .line 382
    iput-object p2, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 383
    iput-object p3, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 384
    iput-object p4, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 385
    iput-object p5, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 386
    iput p6, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mPaddingLeft:I

    .line 387
    iput p7, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mPaddingTop:I

    .line 388
    iput p8, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mPaddingRight:I

    .line 389
    iput p9, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mPaddingBottom:I

    .line 390
    iput p10, p0, Landroidx/constraintlayout/core/widgets/Flow$WidgetsList;->mMax:I

    return-void
.end method
