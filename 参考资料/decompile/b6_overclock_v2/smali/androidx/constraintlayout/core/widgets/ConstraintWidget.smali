.class public Landroidx/constraintlayout/core/widgets/ConstraintWidget;
.super Ljava/lang/Object;
.source "ConstraintWidget.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;
    }
.end annotation


# static fields
.field public static final ANCHOR_BASELINE:I = 0x4

.field public static final ANCHOR_BOTTOM:I = 0x3

.field public static final ANCHOR_LEFT:I = 0x0

.field public static final ANCHOR_RIGHT:I = 0x1

.field public static final ANCHOR_TOP:I = 0x2

.field private static final AUTOTAG_CENTER:Z = false

.field public static final BOTH:I = 0x2

.field public static final CHAIN_PACKED:I = 0x2

.field public static final CHAIN_SPREAD:I = 0x0

.field public static final CHAIN_SPREAD_INSIDE:I = 0x1

.field public static DEFAULT_BIAS:F = 0.5f

.field static final DIMENSION_HORIZONTAL:I = 0x0

.field static final DIMENSION_VERTICAL:I = 0x1

.field protected static final DIRECT:I = 0x2

.field public static final GONE:I = 0x8

.field public static final HORIZONTAL:I = 0x0

.field public static final INVISIBLE:I = 0x4

.field public static final MATCH_CONSTRAINT_PERCENT:I = 0x2

.field public static final MATCH_CONSTRAINT_RATIO:I = 0x3

.field public static final MATCH_CONSTRAINT_RATIO_RESOLVED:I = 0x4

.field public static final MATCH_CONSTRAINT_SPREAD:I = 0x0

.field public static final MATCH_CONSTRAINT_WRAP:I = 0x1

.field protected static final SOLVER:I = 0x1

.field public static final UNKNOWN:I = -0x1

.field private static final USE_WRAP_DIMENSION_FOR_SPREAD:Z = false

.field public static final VERTICAL:I = 0x1

.field public static final VISIBLE:I = 0x0

.field private static final WRAP:I = -0x2

.field public static final WRAP_BEHAVIOR_HORIZONTAL_ONLY:I = 0x1

.field public static final WRAP_BEHAVIOR_INCLUDED:I = 0x0

.field public static final WRAP_BEHAVIOR_SKIPPED:I = 0x3

.field public static final WRAP_BEHAVIOR_VERTICAL_ONLY:I = 0x2


# instance fields
.field private OPTIMIZE_WRAP:Z

.field private OPTIMIZE_WRAP_ON_RESOLVED:Z

.field public frame:Landroidx/constraintlayout/core/state/WidgetFrame;

.field private hasBaseline:Z

.field public horizontalChainRun:Landroidx/constraintlayout/core/widgets/analyzer/ChainRun;

.field public horizontalGroup:I

.field public horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

.field private horizontalSolvingPass:Z

.field private inPlaceholder:Z

.field public isTerminalWidget:[Z

.field protected mAnchors:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Landroidx/constraintlayout/core/widgets/ConstraintAnchor;",
            ">;"
        }
    .end annotation
.end field

.field private mAnimated:Z

.field public mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

.field mBaselineDistance:I

.field public mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

.field mBottomHasCentered:Z

.field public mCenter:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

.field mCenterX:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

.field mCenterY:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

.field private mCircleConstraintAngle:F

.field private mCompanionWidget:Ljava/lang/Object;

.field private mContainerItemSkip:I

.field private mDebugName:Ljava/lang/String;

.field public mDimensionRatio:F

.field protected mDimensionRatioSide:I

.field mDistToBottom:I

.field mDistToLeft:I

.field mDistToRight:I

.field mDistToTop:I

.field mGroupsToSolver:Z

.field mHeight:I

.field private mHeightOverride:I

.field mHorizontalBiasPercent:F

.field mHorizontalChainFixedPosition:Z

.field mHorizontalChainStyle:I

.field mHorizontalNextWidget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

.field public mHorizontalResolution:I

.field mHorizontalWrapVisited:Z

.field private mInVirtualLayout:Z

.field public mIsHeightWrapContent:Z

.field private mIsInBarrier:[Z

.field public mIsWidthWrapContent:Z

.field private mLastHorizontalMeasureSpec:I

.field private mLastVerticalMeasureSpec:I

.field public mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

.field mLeftHasCentered:Z

.field public mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

.field public mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

.field protected mListNextMatchConstraintsWidget:[Landroidx/constraintlayout/core/widgets/ConstraintWidget;

.field public mMatchConstraintDefaultHeight:I

.field public mMatchConstraintDefaultWidth:I

.field public mMatchConstraintMaxHeight:I

.field public mMatchConstraintMaxWidth:I

.field public mMatchConstraintMinHeight:I

.field public mMatchConstraintMinWidth:I

.field public mMatchConstraintPercentHeight:F

.field public mMatchConstraintPercentWidth:F

.field private mMaxDimension:[I

.field private mMeasureRequested:Z

.field protected mMinHeight:I

.field protected mMinWidth:I

.field protected mNextChainWidget:[Landroidx/constraintlayout/core/widgets/ConstraintWidget;

.field protected mOffsetX:I

.field protected mOffsetY:I

.field public mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

.field mRelX:I

.field mRelY:I

.field mResolvedDimensionRatio:F

.field mResolvedDimensionRatioSide:I

.field mResolvedHasRatio:Z

.field public mResolvedMatchConstraintDefault:[I

.field public mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

.field mRightHasCentered:Z

.field public mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

.field mTopHasCentered:Z

.field private mType:Ljava/lang/String;

.field mVerticalBiasPercent:F

.field mVerticalChainFixedPosition:Z

.field mVerticalChainStyle:I

.field mVerticalNextWidget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

.field public mVerticalResolution:I

.field mVerticalWrapVisited:Z

.field private mVisibility:I

.field public mWeight:[F

.field mWidth:I

.field private mWidthOverride:I

.field private mWrapBehaviorInParent:I

.field protected mX:I

.field protected mY:I

.field public measured:Z

.field private resolvedHorizontal:Z

.field private resolvedVertical:Z

.field public run:[Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;

.field public stringId:Ljava/lang/String;

.field public verticalChainRun:Landroidx/constraintlayout/core/widgets/analyzer/ChainRun;

.field public verticalGroup:I

.field public verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

.field private verticalSolvingPass:Z


# direct methods
.method static constructor <clinit>()V
    .registers 0

    return-void
.end method

.method public constructor <init>()V
    .registers 11

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->measured:Z

    const/4 v1, 0x2

    new-array v2, v1, [Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;

    iput-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->run:[Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;

    const/4 v2, 0x0

    iput-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    iput-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    new-array v3, v1, [Z

    fill-array-data v3, :array_134

    iput-object v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isTerminalWidget:[Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedHasRatio:Z

    const/4 v3, 0x1

    iput-boolean v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMeasureRequested:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->OPTIMIZE_WRAP:Z

    iput-boolean v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->OPTIMIZE_WRAP_ON_RESOLVED:Z

    const/4 v4, -0x1

    iput v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidthOverride:I

    iput v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeightOverride:I

    new-instance v5, Landroidx/constraintlayout/core/state/WidgetFrame;

    invoke-direct {v5, p0}, Landroidx/constraintlayout/core/state/WidgetFrame;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;)V

    iput-object v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->frame:Landroidx/constraintlayout/core/state/WidgetFrame;

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedHorizontal:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedVertical:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalSolvingPass:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalSolvingPass:Z

    iput v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalResolution:I

    iput v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalResolution:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWrapBehaviorInParent:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultWidth:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultHeight:I

    new-array v5, v1, [I

    iput-object v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedMatchConstraintDefault:[I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinWidth:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxWidth:I

    const/high16 v5, 0x3f800000    # 1.0f

    iput v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintPercentWidth:F

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinHeight:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxHeight:I

    iput v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintPercentHeight:F

    iput v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    iput v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatio:F

    new-array v5, v1, [I

    fill-array-data v5, :array_13a

    iput-object v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMaxDimension:[I

    const/4 v5, 0x0

    iput v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCircleConstraintAngle:F

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->hasBaseline:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mInVirtualLayout:Z

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLastHorizontalMeasureSpec:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLastVerticalMeasureSpec:I

    new-instance v6, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->LEFT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-direct {v6, p0, v7}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)V

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    new-instance v6, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->TOP:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-direct {v6, p0, v7}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)V

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    new-instance v6, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->RIGHT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-direct {v6, p0, v7}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)V

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    new-instance v6, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->BOTTOM:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-direct {v6, p0, v7}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)V

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    new-instance v6, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->BASELINE:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-direct {v6, p0, v7}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)V

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    new-instance v6, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER_X:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-direct {v6, p0, v7}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)V

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenterX:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    new-instance v6, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER_Y:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-direct {v6, p0, v7}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)V

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenterY:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    new-instance v6, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-direct {v6, p0, v7}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)V

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenter:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    const/4 v7, 0x6

    new-array v7, v7, [Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v8, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aput-object v8, v7, v0

    iget-object v8, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aput-object v8, v7, v3

    iget-object v8, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aput-object v8, v7, v1

    const/4 v8, 0x3

    iget-object v9, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aput-object v9, v7, v8

    const/4 v8, 0x4

    iget-object v9, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aput-object v9, v7, v8

    const/4 v8, 0x5

    aput-object v6, v7, v8

    iput-object v7, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mAnchors:Ljava/util/ArrayList;

    new-array v6, v1, [Z

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mIsInBarrier:[Z

    new-array v6, v1, [Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->FIXED:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    aput-object v7, v6, v0

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->FIXED:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    aput-object v7, v6, v3

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    iput-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    iput v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatio:F

    iput v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatioSide:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRelX:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRelY:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mOffsetX:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mOffsetY:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaselineDistance:I

    sget v5, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->DEFAULT_BIAS:F

    iput v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalBiasPercent:F

    iput v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalBiasPercent:F

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mContainerItemSkip:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mAnimated:Z

    iput-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDebugName:Ljava/lang/String;

    iput-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mType:Ljava/lang/String;

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mGroupsToSolver:Z

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalChainStyle:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalChainStyle:I

    new-array v5, v1, [F

    fill-array-data v5, :array_142

    iput-object v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWeight:[F

    new-array v5, v1, [Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    aput-object v2, v5, v0

    aput-object v2, v5, v3

    iput-object v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListNextMatchConstraintsWidget:[Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    new-array v1, v1, [Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    aput-object v2, v1, v0

    aput-object v2, v1, v3

    iput-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mNextChainWidget:[Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iput-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalNextWidget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iput-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalNextWidget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iput v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalGroup:I

    iput v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalGroup:I

    invoke-direct {p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->addAnchors()V

    return-void

    :array_134
    .array-data 1
        0x1t
        0x1t
    .end array-data

    nop

    :array_13a
    .array-data 4
        0x7fffffff
        0x7fffffff
    .end array-data

    :array_142
    .array-data 4
        -0x40800000    # -1.0f
        -0x40800000    # -1.0f
    .end array-data
.end method

.method public constructor <init>(II)V
    .registers 4

    const/4 v0, 0x0

    invoke-direct {p0, v0, v0, p1, p2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;-><init>(IIII)V

    return-void
.end method

.method public constructor <init>(IIII)V
    .registers 15

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->measured:Z

    const/4 v1, 0x2

    new-array v2, v1, [Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;

    iput-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->run:[Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;

    const/4 v2, 0x0

    iput-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    iput-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    new-array v3, v1, [Z

    fill-array-data v3, :array_134

    iput-object v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isTerminalWidget:[Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedHasRatio:Z

    const/4 v3, 0x1

    iput-boolean v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMeasureRequested:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->OPTIMIZE_WRAP:Z

    iput-boolean v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->OPTIMIZE_WRAP_ON_RESOLVED:Z

    const/4 v4, -0x1

    iput v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidthOverride:I

    iput v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeightOverride:I

    new-instance v5, Landroidx/constraintlayout/core/state/WidgetFrame;

    invoke-direct {v5, p0}, Landroidx/constraintlayout/core/state/WidgetFrame;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;)V

    iput-object v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->frame:Landroidx/constraintlayout/core/state/WidgetFrame;

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedHorizontal:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedVertical:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalSolvingPass:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalSolvingPass:Z

    iput v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalResolution:I

    iput v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalResolution:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWrapBehaviorInParent:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultWidth:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultHeight:I

    new-array v5, v1, [I

    iput-object v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedMatchConstraintDefault:[I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinWidth:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxWidth:I

    const/high16 v5, 0x3f800000    # 1.0f

    iput v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintPercentWidth:F

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinHeight:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxHeight:I

    iput v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintPercentHeight:F

    iput v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    iput v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatio:F

    new-array v5, v1, [I

    fill-array-data v5, :array_13a

    iput-object v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMaxDimension:[I

    const/4 v5, 0x0

    iput v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCircleConstraintAngle:F

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->hasBaseline:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mInVirtualLayout:Z

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLastHorizontalMeasureSpec:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLastVerticalMeasureSpec:I

    new-instance v6, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->LEFT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-direct {v6, p0, v7}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)V

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    new-instance v6, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->TOP:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-direct {v6, p0, v7}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)V

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    new-instance v6, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->RIGHT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-direct {v6, p0, v7}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)V

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    new-instance v6, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->BOTTOM:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-direct {v6, p0, v7}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)V

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    new-instance v6, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->BASELINE:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-direct {v6, p0, v7}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)V

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    new-instance v6, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER_X:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-direct {v6, p0, v7}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)V

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenterX:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    new-instance v6, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER_Y:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-direct {v6, p0, v7}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)V

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenterY:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    new-instance v6, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-direct {v6, p0, v7}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)V

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenter:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    const/4 v7, 0x6

    new-array v7, v7, [Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v8, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aput-object v8, v7, v0

    iget-object v8, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aput-object v8, v7, v3

    iget-object v8, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aput-object v8, v7, v1

    const/4 v8, 0x3

    iget-object v9, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aput-object v9, v7, v8

    const/4 v8, 0x4

    iget-object v9, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aput-object v9, v7, v8

    const/4 v8, 0x5

    aput-object v6, v7, v8

    iput-object v7, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mAnchors:Ljava/util/ArrayList;

    new-array v6, v1, [Z

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mIsInBarrier:[Z

    new-array v6, v1, [Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->FIXED:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    aput-object v7, v6, v0

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->FIXED:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    aput-object v7, v6, v3

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    iput-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iput v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatio:F

    iput v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatioSide:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRelX:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRelY:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mOffsetX:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mOffsetY:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaselineDistance:I

    sget v5, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->DEFAULT_BIAS:F

    iput v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalBiasPercent:F

    iput v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalBiasPercent:F

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mContainerItemSkip:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mAnimated:Z

    iput-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDebugName:Ljava/lang/String;

    iput-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mType:Ljava/lang/String;

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mGroupsToSolver:Z

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalChainStyle:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalChainStyle:I

    new-array v5, v1, [F

    fill-array-data v5, :array_142

    iput-object v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWeight:[F

    new-array v5, v1, [Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    aput-object v2, v5, v0

    aput-object v2, v5, v3

    iput-object v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListNextMatchConstraintsWidget:[Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    new-array v1, v1, [Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    aput-object v2, v1, v0

    aput-object v2, v1, v3

    iput-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mNextChainWidget:[Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iput-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalNextWidget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iput-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalNextWidget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iput v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalGroup:I

    iput v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalGroup:I

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    iput p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    iput p3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    iput p4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    invoke-direct {p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->addAnchors()V

    return-void

    :array_134
    .array-data 1
        0x1t
        0x1t
    .end array-data

    nop

    :array_13a
    .array-data 4
        0x7fffffff
        0x7fffffff
    .end array-data

    :array_142
    .array-data 4
        -0x40800000    # -1.0f
        -0x40800000    # -1.0f
    .end array-data
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .registers 12

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->measured:Z

    const/4 v1, 0x2

    new-array v2, v1, [Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;

    iput-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->run:[Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;

    const/4 v2, 0x0

    iput-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    iput-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    new-array v3, v1, [Z

    fill-array-data v3, :array_138

    iput-object v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isTerminalWidget:[Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedHasRatio:Z

    const/4 v3, 0x1

    iput-boolean v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMeasureRequested:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->OPTIMIZE_WRAP:Z

    iput-boolean v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->OPTIMIZE_WRAP_ON_RESOLVED:Z

    const/4 v4, -0x1

    iput v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidthOverride:I

    iput v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeightOverride:I

    new-instance v5, Landroidx/constraintlayout/core/state/WidgetFrame;

    invoke-direct {v5, p0}, Landroidx/constraintlayout/core/state/WidgetFrame;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;)V

    iput-object v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->frame:Landroidx/constraintlayout/core/state/WidgetFrame;

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedHorizontal:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedVertical:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalSolvingPass:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalSolvingPass:Z

    iput v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalResolution:I

    iput v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalResolution:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWrapBehaviorInParent:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultWidth:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultHeight:I

    new-array v5, v1, [I

    iput-object v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedMatchConstraintDefault:[I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinWidth:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxWidth:I

    const/high16 v5, 0x3f800000    # 1.0f

    iput v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintPercentWidth:F

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinHeight:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxHeight:I

    iput v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintPercentHeight:F

    iput v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    iput v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatio:F

    new-array v5, v1, [I

    fill-array-data v5, :array_13e

    iput-object v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMaxDimension:[I

    const/4 v5, 0x0

    iput v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCircleConstraintAngle:F

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->hasBaseline:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mInVirtualLayout:Z

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLastHorizontalMeasureSpec:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLastVerticalMeasureSpec:I

    new-instance v6, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->LEFT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-direct {v6, p0, v7}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)V

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    new-instance v6, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->TOP:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-direct {v6, p0, v7}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)V

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    new-instance v6, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->RIGHT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-direct {v6, p0, v7}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)V

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    new-instance v6, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->BOTTOM:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-direct {v6, p0, v7}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)V

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    new-instance v6, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->BASELINE:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-direct {v6, p0, v7}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)V

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    new-instance v6, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER_X:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-direct {v6, p0, v7}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)V

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenterX:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    new-instance v6, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER_Y:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-direct {v6, p0, v7}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)V

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenterY:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    new-instance v6, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-direct {v6, p0, v7}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)V

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenter:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    const/4 v7, 0x6

    new-array v7, v7, [Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v8, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aput-object v8, v7, v0

    iget-object v8, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aput-object v8, v7, v3

    iget-object v8, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aput-object v8, v7, v1

    const/4 v8, 0x3

    iget-object v9, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aput-object v9, v7, v8

    const/4 v8, 0x4

    iget-object v9, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aput-object v9, v7, v8

    const/4 v8, 0x5

    aput-object v6, v7, v8

    iput-object v7, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mAnchors:Ljava/util/ArrayList;

    new-array v6, v1, [Z

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mIsInBarrier:[Z

    new-array v6, v1, [Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->FIXED:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    aput-object v7, v6, v0

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->FIXED:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    aput-object v7, v6, v3

    iput-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    iput-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    iput v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatio:F

    iput v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatioSide:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRelX:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRelY:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mOffsetX:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mOffsetY:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaselineDistance:I

    sget v5, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->DEFAULT_BIAS:F

    iput v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalBiasPercent:F

    iput v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalBiasPercent:F

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mContainerItemSkip:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mAnimated:Z

    iput-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDebugName:Ljava/lang/String;

    iput-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mType:Ljava/lang/String;

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mGroupsToSolver:Z

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalChainStyle:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalChainStyle:I

    new-array v5, v1, [F

    fill-array-data v5, :array_146

    iput-object v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWeight:[F

    new-array v5, v1, [Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    aput-object v2, v5, v0

    aput-object v2, v5, v3

    iput-object v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListNextMatchConstraintsWidget:[Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    new-array v1, v1, [Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    aput-object v2, v1, v0

    aput-object v2, v1, v3

    iput-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mNextChainWidget:[Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iput-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalNextWidget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iput-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalNextWidget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iput v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalGroup:I

    iput v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalGroup:I

    invoke-direct {p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->addAnchors()V

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setDebugName(Ljava/lang/String;)V

    return-void

    nop

    :array_138
    .array-data 1
        0x1t
        0x1t
    .end array-data

    nop

    :array_13e
    .array-data 4
        0x7fffffff
        0x7fffffff
    .end array-data

    :array_146
    .array-data 4
        -0x40800000    # -1.0f
        -0x40800000    # -1.0f
    .end array-data
.end method

.method public constructor <init>(Ljava/lang/String;II)V
    .registers 4

    invoke-direct {p0, p2, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;-><init>(II)V

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setDebugName(Ljava/lang/String;)V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;IIII)V
    .registers 6

    invoke-direct {p0, p2, p3, p4, p5}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;-><init>(IIII)V

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setDebugName(Ljava/lang/String;)V

    return-void
.end method

.method private addAnchors()V
    .registers 3

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mAnchors:Ljava/util/ArrayList;

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mAnchors:Ljava/util/ArrayList;

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mAnchors:Ljava/util/ArrayList;

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mAnchors:Ljava/util/ArrayList;

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mAnchors:Ljava/util/ArrayList;

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenterX:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mAnchors:Ljava/util/ArrayList;

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenterY:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mAnchors:Ljava/util/ArrayList;

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenter:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mAnchors:Ljava/util/ArrayList;

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method private applyConstraints(Landroidx/constraintlayout/core/LinearSystem;ZZZZLandroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;ZLandroidx/constraintlayout/core/widgets/ConstraintAnchor;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;IIIIFZZZZZIIIIFZ)V
    .registers 59

    move-object/from16 v0, p0

    move-object/from16 v10, p1

    move-object/from16 v11, p6

    move-object/from16 v12, p7

    move-object/from16 v13, p10

    move-object/from16 v14, p11

    move/from16 v15, p14

    move/from16 v1, p15

    move/from16 v2, p23

    move/from16 v3, p24

    move/from16 v4, p25

    invoke-virtual {v10, v13}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v9

    invoke-virtual {v10, v14}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v8

    invoke-virtual/range {p10 .. p10}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getTarget()Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v5

    invoke-virtual {v10, v5}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v7

    invoke-virtual/range {p11 .. p11}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getTarget()Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v5

    invoke-virtual {v10, v5}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v6

    invoke-static {}, Landroidx/constraintlayout/core/LinearSystem;->getMetrics()Landroidx/constraintlayout/core/Metrics;

    move-result-object v5

    if-eqz v5, :cond_40

    invoke-static {}, Landroidx/constraintlayout/core/LinearSystem;->getMetrics()Landroidx/constraintlayout/core/Metrics;

    move-result-object v5

    iget-wide v11, v5, Landroidx/constraintlayout/core/Metrics;->nonresolvedWidgets:J

    const-wide/16 v16, 0x1

    add-long v11, v11, v16

    iput-wide v11, v5, Landroidx/constraintlayout/core/Metrics;->nonresolvedWidgets:J

    :cond_40
    invoke-virtual/range {p10 .. p10}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result v11

    invoke-virtual/range {p11 .. p11}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result v12

    iget-object v5, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenter:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v5}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result v16

    if-eqz v12, :cond_53

    add-int/lit8 v5, v11, 0x1

    goto :goto_54

    :cond_53
    move v5, v11

    :goto_54
    if-eqz v16, :cond_58

    add-int/lit8 v5, v5, 0x1

    :cond_58
    if-eqz p17, :cond_5d

    const/16 v18, 0x3

    goto :goto_5f

    :cond_5d
    move/from16 v18, p22

    :goto_5f
    sget-object v17, Landroidx/constraintlayout/core/widgets/ConstraintWidget$1;->$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour:[I

    invoke-virtual/range {p8 .. p8}, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->ordinal()I

    move-result v19

    aget v2, v17, v19

    const/4 v14, 0x1

    if-eq v2, v14, :cond_73

    const/4 v14, 0x2

    if-eq v2, v14, :cond_73

    const/4 v14, 0x3

    if-eq v2, v14, :cond_73

    const/4 v14, 0x4

    if-eq v2, v14, :cond_78

    :cond_73
    move/from16 v2, v18

    :cond_75
    const/16 v18, 0x0

    goto :goto_7e

    :cond_78
    move/from16 v2, v18

    if-eq v2, v14, :cond_75

    const/16 v18, 0x1

    :goto_7e
    iget v14, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidthOverride:I

    const/4 v13, -0x1

    if-eq v14, v13, :cond_8c

    if-eqz p2, :cond_8c

    iput v13, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidthOverride:I

    move-object/from16 v21, v6

    const/16 v18, 0x0

    goto :goto_90

    :cond_8c
    move/from16 v14, p13

    move-object/from16 v21, v6

    :goto_90
    iget v6, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeightOverride:I

    if-eq v6, v13, :cond_9b

    if-nez p2, :cond_9b

    iput v13, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeightOverride:I

    move v14, v6

    const/16 v18, 0x0

    :cond_9b
    iget v6, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    const/16 v13, 0x8

    if-ne v6, v13, :cond_a4

    const/4 v14, 0x0

    const/16 v18, 0x0

    :cond_a4
    if-eqz p27, :cond_bd

    if-nez v11, :cond_b2

    if-nez v12, :cond_b2

    if-nez v16, :cond_b2

    move/from16 v6, p12

    invoke-virtual {v10, v9, v6}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    goto :goto_bd

    :cond_b2
    if-eqz v11, :cond_bd

    if-nez v12, :cond_bd

    invoke-virtual/range {p10 .. p10}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v6

    invoke-virtual {v10, v9, v7, v6, v13}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)Landroidx/constraintlayout/core/ArrayRow;

    :cond_bd
    :goto_bd
    if-nez v18, :cond_ea

    if-eqz p9, :cond_d6

    const/4 v6, 0x3

    const/4 v13, 0x0

    invoke-virtual {v10, v8, v9, v13, v6}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)Landroidx/constraintlayout/core/ArrayRow;

    const/16 v6, 0x8

    if-lez v15, :cond_cd

    invoke-virtual {v10, v8, v9, v15, v6}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    :cond_cd
    const v14, 0x7fffffff

    if-ge v1, v14, :cond_db

    invoke-virtual {v10, v8, v9, v1, v6}, Landroidx/constraintlayout/core/LinearSystem;->addLowerThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    goto :goto_db

    :cond_d6
    move v6, v13

    const/4 v13, 0x0

    invoke-virtual {v10, v8, v9, v14, v6}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)Landroidx/constraintlayout/core/ArrayRow;

    :cond_db
    :goto_db
    move v1, v4

    move/from16 p9, v5

    move-object v13, v7

    move-object v15, v8

    move/from16 v23, v18

    move-object/from16 v14, v21

    move/from16 v18, p5

    move/from16 v21, v3

    goto/16 :goto_1ee

    :cond_ea
    const/4 v1, 0x2

    const/4 v13, 0x0

    if-eq v5, v1, :cond_113

    if-nez p17, :cond_113

    const/4 v1, 0x1

    if-eq v2, v1, :cond_f5

    if-nez v2, :cond_113

    :cond_f5
    invoke-static {v3, v14}, Ljava/lang/Math;->max(II)I

    move-result v1

    if-lez v4, :cond_ff

    invoke-static {v4, v1}, Ljava/lang/Math;->min(II)I

    move-result v1

    :cond_ff
    const/16 v6, 0x8

    invoke-virtual {v10, v8, v9, v1, v6}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)Landroidx/constraintlayout/core/ArrayRow;

    move/from16 v18, p5

    move v1, v4

    move/from16 p9, v5

    move-object v15, v8

    move/from16 v23, v13

    move-object/from16 v14, v21

    move/from16 v21, v3

    move-object v13, v7

    goto/16 :goto_1ee

    :cond_113
    const/4 v1, -0x2

    if-ne v3, v1, :cond_118

    move v6, v14

    goto :goto_119

    :cond_118
    move v6, v3

    :goto_119
    if-ne v4, v1, :cond_11d

    move v1, v14

    goto :goto_11e

    :cond_11d
    move v1, v4

    :goto_11e
    if-lez v14, :cond_124

    const/4 v3, 0x1

    if-eq v2, v3, :cond_124

    move v14, v13

    :cond_124
    if-lez v6, :cond_12f

    const/16 v3, 0x8

    invoke-virtual {v10, v8, v9, v6, v3}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    invoke-static {v14, v6}, Ljava/lang/Math;->max(II)I

    move-result v14

    :cond_12f
    if-lez v1, :cond_148

    if-eqz p3, :cond_138

    const/4 v3, 0x1

    if-ne v2, v3, :cond_138

    move v3, v13

    goto :goto_139

    :cond_138
    const/4 v3, 0x1

    :goto_139
    if-eqz v3, :cond_141

    const/16 v3, 0x8

    invoke-virtual {v10, v8, v9, v1, v3}, Landroidx/constraintlayout/core/LinearSystem;->addLowerThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    goto :goto_143

    :cond_141
    const/16 v3, 0x8

    :goto_143
    invoke-static {v14, v1}, Ljava/lang/Math;->min(II)I

    move-result v14

    goto :goto_14a

    :cond_148
    const/16 v3, 0x8

    :goto_14a
    const/4 v4, 0x1

    if-ne v2, v4, :cond_173

    if-eqz p3, :cond_154

    invoke-virtual {v10, v8, v9, v14, v3}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)Landroidx/constraintlayout/core/ArrayRow;

    const/4 v4, 0x5

    goto :goto_165

    :cond_154
    if-eqz p19, :cond_15e

    const/4 v4, 0x5

    invoke-virtual {v10, v8, v9, v14, v4}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)Landroidx/constraintlayout/core/ArrayRow;

    invoke-virtual {v10, v8, v9, v14, v3}, Landroidx/constraintlayout/core/LinearSystem;->addLowerThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    goto :goto_165

    :cond_15e
    const/4 v4, 0x5

    invoke-virtual {v10, v8, v9, v14, v4}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)Landroidx/constraintlayout/core/ArrayRow;

    invoke-virtual {v10, v8, v9, v14, v3}, Landroidx/constraintlayout/core/LinearSystem;->addLowerThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    :goto_165
    move/from16 p9, v5

    move-object v13, v7

    move-object v15, v8

    move/from16 v23, v18

    move-object/from16 v14, v21

    move/from16 v18, p5

    move/from16 v21, v6

    goto/16 :goto_1ee

    :cond_173
    const/4 v4, 0x5

    const/4 v14, 0x2

    if-ne v2, v14, :cond_1e2

    invoke-virtual/range {p10 .. p10}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getType()Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    move-result-object v3

    sget-object v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->TOP:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    if-eq v3, v4, :cond_1a1

    invoke-virtual/range {p10 .. p10}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getType()Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    move-result-object v3

    sget-object v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->BOTTOM:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    if-ne v3, v4, :cond_188

    goto :goto_1a1

    :cond_188
    iget-object v3, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    sget-object v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->LEFT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {v3, v4}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v3

    invoke-virtual {v10, v3}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v3

    iget-object v4, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    sget-object v13, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->RIGHT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {v4, v13}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v4

    invoke-virtual {v10, v4}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v4

    goto :goto_1b9

    :cond_1a1
    :goto_1a1
    iget-object v3, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    sget-object v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->TOP:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {v3, v4}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v3

    invoke-virtual {v10, v3}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v3

    iget-object v4, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    sget-object v13, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->BOTTOM:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {v4, v13}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v4

    invoke-virtual {v10, v4}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v4

    :goto_1b9
    move-object/from16 v23, v3

    move-object v13, v4

    invoke-virtual/range {p1 .. p1}, Landroidx/constraintlayout/core/LinearSystem;->createRow()Landroidx/constraintlayout/core/ArrayRow;

    move-result-object v3

    const/16 v24, 0x5

    move-object v4, v8

    move v14, v5

    move-object v5, v9

    move/from16 p9, v14

    move-object/from16 v14, v21

    move/from16 v21, v6

    move-object v6, v13

    move-object v13, v7

    move-object/from16 v7, v23

    move-object v15, v8

    move/from16 v8, p26

    invoke-virtual/range {v3 .. v8}, Landroidx/constraintlayout/core/ArrayRow;->createRowDimensionRatio(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;F)Landroidx/constraintlayout/core/ArrayRow;

    move-result-object v3

    invoke-virtual {v10, v3}, Landroidx/constraintlayout/core/LinearSystem;->addConstraint(Landroidx/constraintlayout/core/ArrayRow;)V

    if-eqz p3, :cond_1dd

    const/16 v18, 0x0

    :cond_1dd
    move/from16 v23, v18

    move/from16 v18, p5

    goto :goto_1ee

    :cond_1e2
    move/from16 p9, v5

    move-object v13, v7

    move-object v15, v8

    move-object/from16 v14, v21

    move/from16 v21, v6

    move/from16 v23, v18

    const/16 v18, 0x1

    :goto_1ee
    if-eqz p27, :cond_511

    if-eqz p19, :cond_1fe

    move-object/from16 v1, p6

    move-object/from16 v4, p7

    move/from16 v5, p9

    move-object v2, v15

    const/4 v3, 0x0

    const/4 v6, 0x2

    move-object v15, v9

    goto/16 :goto_51b

    :cond_1fe
    if-nez v11, :cond_209

    if-nez v12, :cond_209

    if-nez v16, :cond_209

    move-object v2, v15

    const/4 v1, 0x5

    const/4 v3, 0x0

    goto/16 :goto_4dc

    :cond_209
    if-eqz v11, :cond_225

    if-nez v12, :cond_225

    move-object/from16 v7, p10

    const/4 v8, 0x0

    iget-object v1, v7, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v1, v1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    if-eqz p3, :cond_21d

    instance-of v1, v1, Landroidx/constraintlayout/core/widgets/Barrier;

    if-eqz v1, :cond_21d

    const/16 v13, 0x8

    goto :goto_21e

    :cond_21d
    const/4 v13, 0x5

    :goto_21e
    move/from16 v22, p3

    move v3, v8

    move v6, v13

    move-object v2, v15

    goto/16 :goto_4df

    :cond_225
    move-object/from16 v7, p10

    const/4 v8, 0x0

    if-nez v11, :cond_25c

    if-eqz v12, :cond_25c

    invoke-virtual/range {p11 .. p11}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v1

    neg-int v1, v1

    const/16 v2, 0x8

    invoke-virtual {v10, v15, v14, v1, v2}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)Landroidx/constraintlayout/core/ArrayRow;

    if-eqz p3, :cond_4d9

    iget-boolean v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->OPTIMIZE_WRAP:Z

    if-eqz v1, :cond_252

    iget-boolean v1, v9, Landroidx/constraintlayout/core/SolverVariable;->isFinalValue:Z

    if-eqz v1, :cond_252

    iget-object v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    if-eqz v1, :cond_252

    check-cast v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    if-eqz p2, :cond_24d

    invoke-virtual {v1, v7}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->addHorizontalWrapMinVariable(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V

    goto/16 :goto_4d9

    :cond_24d
    invoke-virtual {v1, v7}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->addVerticalWrapMinVariable(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V

    goto/16 :goto_4d9

    :cond_252
    move-object/from16 v6, p6

    const/4 v1, 0x5

    invoke-virtual {v10, v9, v6, v8, v1}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    move v3, v8

    move-object v2, v15

    goto/16 :goto_4dc

    :cond_25c
    move-object/from16 v6, p6

    if-eqz v11, :cond_4d9

    if-eqz v12, :cond_4d9

    iget-object v3, v7, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v11, v3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-object/from16 v12, p11

    const/4 v3, 0x2

    iget-object v4, v12, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v5, v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual/range {p0 .. p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getParent()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v4

    const/16 v16, 0x6

    if-eqz v23, :cond_368

    if-nez v2, :cond_2cb

    if-nez v1, :cond_2a0

    if-nez v21, :cond_2a0

    iget-boolean v1, v13, Landroidx/constraintlayout/core/SolverVariable;->isFinalValue:Z

    if-eqz v1, :cond_295

    iget-boolean v1, v14, Landroidx/constraintlayout/core/SolverVariable;->isFinalValue:Z

    if-eqz v1, :cond_295

    invoke-virtual/range {p10 .. p10}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v1

    const/16 v2, 0x8

    invoke-virtual {v10, v9, v13, v1, v2}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)Landroidx/constraintlayout/core/ArrayRow;

    invoke-virtual/range {p11 .. p11}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v1

    neg-int v1, v1

    invoke-virtual {v10, v15, v14, v1, v2}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)Landroidx/constraintlayout/core/ArrayRow;

    return-void

    :cond_295
    move/from16 v19, v8

    move/from16 v24, v19

    const/16 v1, 0x8

    const/16 v3, 0x8

    const/16 v22, 0x1

    goto :goto_2a8

    :cond_2a0
    move/from16 v22, v8

    const/4 v1, 0x5

    const/4 v3, 0x5

    const/16 v19, 0x1

    const/16 v24, 0x1

    :goto_2a8
    instance-of v8, v11, Landroidx/constraintlayout/core/widgets/Barrier;

    if-nez v8, :cond_2be

    instance-of v8, v5, Landroidx/constraintlayout/core/widgets/Barrier;

    if-eqz v8, :cond_2b1

    goto :goto_2be

    :cond_2b1
    move-object/from16 v8, p7

    move/from16 v25, v22

    move/from16 v22, v19

    move/from16 v19, v3

    :goto_2b9
    move v3, v1

    move/from16 v1, v16

    goto/16 :goto_3b3

    :cond_2be
    :goto_2be
    move-object/from16 v8, p7

    move v3, v1

    move/from16 v1, v16

    move/from16 v25, v22

    move/from16 v22, v19

    const/16 v19, 0x4

    goto/16 :goto_3b3

    :cond_2cb
    if-ne v2, v3, :cond_2e3

    instance-of v1, v11, Landroidx/constraintlayout/core/widgets/Barrier;

    if-nez v1, :cond_2df

    instance-of v1, v5, Landroidx/constraintlayout/core/widgets/Barrier;

    if-eqz v1, :cond_2d6

    goto :goto_2df

    :cond_2d6
    move-object/from16 v8, p7

    move/from16 v1, v16

    const/4 v3, 0x5

    const/16 v19, 0x5

    goto/16 :goto_3ad

    :cond_2df
    :goto_2df
    move-object/from16 v8, p7

    goto/16 :goto_3a8

    :cond_2e3
    const/4 v8, 0x1

    if-ne v2, v8, :cond_2ee

    move-object/from16 v8, p7

    move/from16 v1, v16

    const/16 v3, 0x8

    goto/16 :goto_3ab

    :cond_2ee
    const/4 v8, 0x3

    if-ne v2, v8, :cond_35c

    iget v8, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    const/4 v3, -0x1

    if-ne v8, v3, :cond_310

    if-eqz p20, :cond_300

    move-object/from16 v8, p7

    if-eqz p3, :cond_2fe

    const/4 v1, 0x5

    goto :goto_304

    :cond_2fe
    const/4 v1, 0x4

    goto :goto_304

    :cond_300
    move-object/from16 v8, p7

    const/16 v1, 0x8

    :goto_304
    const/16 v3, 0x8

    :goto_306
    const/16 v19, 0x5

    :goto_308
    const/16 v22, 0x1

    const/16 v24, 0x1

    const/16 v25, 0x1

    goto/16 :goto_3b3

    :cond_310
    if-eqz p17, :cond_331

    move/from16 v3, p23

    const/4 v8, 0x2

    if-eq v3, v8, :cond_31d

    const/4 v1, 0x1

    if-ne v3, v1, :cond_31b

    goto :goto_31d

    :cond_31b
    const/4 v1, 0x0

    goto :goto_31e

    :cond_31d
    :goto_31d
    const/4 v1, 0x1

    :goto_31e
    if-nez v1, :cond_324

    const/16 v1, 0x8

    const/4 v3, 0x5

    goto :goto_326

    :cond_324
    const/4 v1, 0x5

    const/4 v3, 0x4

    :goto_326
    move-object/from16 v8, p7

    move/from16 v19, v3

    const/16 v22, 0x1

    const/16 v24, 0x1

    const/16 v25, 0x1

    goto :goto_2b9

    :cond_331
    if-lez v1, :cond_339

    move-object/from16 v8, p7

    move/from16 v1, v16

    const/4 v3, 0x5

    goto :goto_306

    :cond_339
    if-nez v1, :cond_354

    if-nez v21, :cond_354

    if-nez p20, :cond_347

    move-object/from16 v8, p7

    move/from16 v1, v16

    const/4 v3, 0x5

    const/16 v19, 0x8

    goto :goto_308

    :cond_347
    if-eq v11, v4, :cond_34d

    if-eq v5, v4, :cond_34d

    const/4 v1, 0x4

    goto :goto_34e

    :cond_34d
    const/4 v1, 0x5

    :goto_34e
    move-object/from16 v8, p7

    move v3, v1

    move/from16 v1, v16

    goto :goto_359

    :cond_354
    move-object/from16 v8, p7

    move/from16 v1, v16

    const/4 v3, 0x5

    :goto_359
    const/16 v19, 0x4

    goto :goto_308

    :cond_35c
    move-object/from16 v8, p7

    move/from16 v1, v16

    const/4 v3, 0x5

    const/16 v19, 0x4

    const/16 v22, 0x0

    const/16 v24, 0x0

    goto :goto_3b1

    :cond_368
    iget-boolean v1, v13, Landroidx/constraintlayout/core/SolverVariable;->isFinalValue:Z

    if-eqz v1, :cond_2df

    iget-boolean v1, v14, Landroidx/constraintlayout/core/SolverVariable;->isFinalValue:Z

    if-eqz v1, :cond_2df

    invoke-virtual/range {p10 .. p10}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v1

    invoke-virtual/range {p11 .. p11}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v2

    const/16 v3, 0x8

    move-object/from16 p17, p1

    move-object/from16 p18, v9

    move-object/from16 p19, v13

    move/from16 p20, v1

    move/from16 p21, p16

    move-object/from16 p22, v14

    move-object/from16 p23, v15

    move/from16 p24, v2

    move/from16 p25, v3

    invoke-virtual/range {p17 .. p25}, Landroidx/constraintlayout/core/LinearSystem;->addCentering(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;IFLandroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    if-eqz p3, :cond_3a7

    if-eqz v18, :cond_3a7

    iget-object v1, v12, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz v1, :cond_39e

    invoke-virtual/range {p11 .. p11}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v13

    move-object/from16 v8, p7

    goto :goto_3a1

    :cond_39e
    move-object/from16 v8, p7

    const/4 v13, 0x0

    :goto_3a1
    if-eq v14, v8, :cond_3a7

    const/4 v1, 0x5

    invoke-virtual {v10, v8, v15, v13, v1}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    :cond_3a7
    return-void

    :goto_3a8
    move/from16 v1, v16

    const/4 v3, 0x5

    :goto_3ab
    const/16 v19, 0x4

    :goto_3ad
    const/16 v22, 0x1

    const/16 v24, 0x1

    :goto_3b1
    const/16 v25, 0x0

    :goto_3b3
    if-eqz v24, :cond_3be

    if-ne v13, v14, :cond_3be

    if-eq v11, v4, :cond_3be

    const/16 v24, 0x0

    const/16 v26, 0x0

    goto :goto_3c0

    :cond_3be
    const/16 v26, 0x1

    :goto_3c0
    if-eqz v22, :cond_406

    if-nez v23, :cond_3d5

    if-nez p18, :cond_3d5

    if-nez p20, :cond_3d5

    if-ne v13, v6, :cond_3d5

    if-ne v14, v8, :cond_3d5

    const/16 v22, 0x0

    const/16 v26, 0x8

    const/16 v27, 0x8

    const/16 v28, 0x0

    goto :goto_3dd

    :cond_3d5
    move/from16 v22, p3

    move/from16 v27, v1

    move/from16 v28, v26

    move/from16 v26, v3

    :goto_3dd
    invoke-virtual/range {p10 .. p10}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v29

    invoke-virtual/range {p11 .. p11}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v30

    move-object/from16 v1, p1

    move v3, v2

    move-object v2, v9

    move v12, v3

    move-object v3, v13

    move/from16 p8, v12

    move-object v12, v4

    move/from16 v4, v29

    move-object/from16 v29, v12

    move-object v12, v5

    move/from16 v5, p16

    move-object v6, v14

    move-object v7, v15

    move/from16 v8, v30

    move-object/from16 v20, v15

    move-object v15, v9

    move/from16 v9, v27

    invoke-virtual/range {v1 .. v9}, Landroidx/constraintlayout/core/LinearSystem;->addCentering(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;IFLandroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    move/from16 v3, v26

    move/from16 v26, v28

    goto :goto_410

    :cond_406
    move/from16 p8, v2

    move-object/from16 v29, v4

    move-object v12, v5

    move-object/from16 v20, v15

    move-object v15, v9

    move/from16 v22, p3

    :goto_410
    iget v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    const/16 v2, 0x8

    if-ne v1, v2, :cond_41d

    invoke-virtual/range {p11 .. p11}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->hasDependents()Z

    move-result v1

    if-nez v1, :cond_41d

    return-void

    :cond_41d
    if-eqz v24, :cond_441

    if-eqz v22, :cond_42f

    if-eq v13, v14, :cond_42f

    if-nez v23, :cond_42f

    instance-of v1, v11, Landroidx/constraintlayout/core/widgets/Barrier;

    if-nez v1, :cond_42d

    instance-of v1, v12, Landroidx/constraintlayout/core/widgets/Barrier;

    if-eqz v1, :cond_42f

    :cond_42d
    move/from16 v3, v16

    :cond_42f
    invoke-virtual/range {p10 .. p10}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v1

    invoke-virtual {v10, v15, v13, v1, v3}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    invoke-virtual/range {p11 .. p11}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v1

    neg-int v1, v1

    move-object/from16 v2, v20

    invoke-virtual {v10, v2, v14, v1, v3}, Landroidx/constraintlayout/core/LinearSystem;->addLowerThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    goto :goto_443

    :cond_441
    move-object/from16 v2, v20

    :goto_443
    if-eqz v22, :cond_459

    if-eqz p21, :cond_459

    instance-of v1, v11, Landroidx/constraintlayout/core/widgets/Barrier;

    if-nez v1, :cond_459

    instance-of v1, v12, Landroidx/constraintlayout/core/widgets/Barrier;

    if-nez v1, :cond_459

    move-object/from16 v1, v29

    if-eq v12, v1, :cond_45b

    move/from16 v3, v16

    move v4, v3

    const/16 v26, 0x1

    goto :goto_45d

    :cond_459
    move-object/from16 v1, v29

    :cond_45b
    move/from16 v4, v19

    :goto_45d
    if-eqz v26, :cond_4a7

    if-eqz v25, :cond_487

    if-eqz p20, :cond_465

    if-eqz p4, :cond_487

    :cond_465
    if-eq v11, v1, :cond_46c

    if-ne v12, v1, :cond_46a

    goto :goto_46c

    :cond_46a
    move v6, v4

    goto :goto_46e

    :cond_46c
    :goto_46c
    move/from16 v6, v16

    :goto_46e
    instance-of v5, v11, Landroidx/constraintlayout/core/widgets/Guideline;

    if-nez v5, :cond_476

    instance-of v5, v12, Landroidx/constraintlayout/core/widgets/Guideline;

    if-eqz v5, :cond_477

    :cond_476
    const/4 v6, 0x5

    :cond_477
    instance-of v5, v11, Landroidx/constraintlayout/core/widgets/Barrier;

    if-nez v5, :cond_47f

    instance-of v5, v12, Landroidx/constraintlayout/core/widgets/Barrier;

    if-eqz v5, :cond_480

    :cond_47f
    const/4 v6, 0x5

    :cond_480
    if-eqz p20, :cond_483

    const/4 v6, 0x5

    :cond_483
    invoke-static {v6, v4}, Ljava/lang/Math;->max(II)I

    move-result v4

    :cond_487
    if-eqz v22, :cond_498

    invoke-static {v3, v4}, Ljava/lang/Math;->min(II)I

    move-result v3

    if-eqz p17, :cond_497

    if-nez p20, :cond_497

    if-eq v11, v1, :cond_495

    if-ne v12, v1, :cond_497

    :cond_495
    const/4 v4, 0x4

    goto :goto_498

    :cond_497
    move v4, v3

    :cond_498
    :goto_498
    invoke-virtual/range {p10 .. p10}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v1

    invoke-virtual {v10, v15, v13, v1, v4}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)Landroidx/constraintlayout/core/ArrayRow;

    invoke-virtual/range {p11 .. p11}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v1

    neg-int v1, v1

    invoke-virtual {v10, v2, v14, v1, v4}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)Landroidx/constraintlayout/core/ArrayRow;

    :cond_4a7
    if-eqz v22, :cond_4b9

    move-object/from16 v1, p6

    if-ne v1, v13, :cond_4b2

    invoke-virtual/range {p10 .. p10}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v3

    goto :goto_4b3

    :cond_4b2
    const/4 v3, 0x0

    :goto_4b3
    if-eq v13, v1, :cond_4b9

    const/4 v4, 0x5

    invoke-virtual {v10, v15, v1, v3, v4}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    :cond_4b9
    if-eqz v22, :cond_4d6

    if-eqz v23, :cond_4d6

    if-nez p14, :cond_4d6

    if-nez v21, :cond_4d6

    if-eqz v23, :cond_4d0

    move/from16 v1, p8

    const/4 v3, 0x3

    if-ne v1, v3, :cond_4d0

    const/16 v1, 0x8

    const/4 v3, 0x0

    invoke-virtual {v10, v2, v15, v3, v1}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    const/4 v1, 0x5

    goto :goto_4de

    :cond_4d0
    const/4 v3, 0x0

    const/4 v1, 0x5

    invoke-virtual {v10, v2, v15, v3, v1}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    goto :goto_4de

    :cond_4d6
    const/4 v1, 0x5

    const/4 v3, 0x0

    goto :goto_4de

    :cond_4d9
    :goto_4d9
    move v3, v8

    move-object v2, v15

    const/4 v1, 0x5

    :goto_4dc
    move/from16 v22, p3

    :goto_4de
    move v6, v1

    :goto_4df
    if-eqz v22, :cond_510

    if-eqz v18, :cond_510

    move-object/from16 v1, p11

    iget-object v4, v1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz v4, :cond_4f0

    invoke-virtual/range {p11 .. p11}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v13

    move-object/from16 v4, p7

    goto :goto_4f3

    :cond_4f0
    move-object/from16 v4, p7

    move v13, v3

    :goto_4f3
    if-eq v14, v4, :cond_510

    iget-boolean v3, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->OPTIMIZE_WRAP:Z

    if-eqz v3, :cond_50d

    iget-boolean v3, v2, Landroidx/constraintlayout/core/SolverVariable;->isFinalValue:Z

    if-eqz v3, :cond_50d

    iget-object v3, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    if-eqz v3, :cond_50d

    check-cast v3, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    if-eqz p2, :cond_509

    invoke-virtual {v3, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->addHorizontalWrapMaxVariable(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V

    goto :goto_50c

    :cond_509
    invoke-virtual {v3, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->addVerticalWrapMaxVariable(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V

    :goto_50c
    return-void

    :cond_50d
    invoke-virtual {v10, v4, v2, v13, v6}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    :cond_510
    return-void

    :cond_511
    move-object/from16 v1, p6

    move-object/from16 v4, p7

    move-object v2, v15

    const/4 v3, 0x0

    move-object v15, v9

    move/from16 v5, p9

    const/4 v6, 0x2

    :goto_51b
    if-ge v5, v6, :cond_564

    if-eqz p3, :cond_564

    if-eqz v18, :cond_564

    const/16 v5, 0x8

    invoke-virtual {v10, v15, v1, v3, v5}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    if-nez p2, :cond_531

    iget-object v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v1, v1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-nez v1, :cond_52f

    goto :goto_531

    :cond_52f
    move v13, v3

    goto :goto_532

    :cond_531
    :goto_531
    const/4 v13, 0x1

    :goto_532
    if-nez p2, :cond_55c

    iget-object v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v1, v1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz v1, :cond_55c

    iget-object v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v1, v1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v1, v1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget v5, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatio:F

    const/4 v6, 0x0

    cmpl-float v5, v5, v6

    if-eqz v5, :cond_55a

    iget-object v5, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    aget-object v5, v5, v3

    sget-object v6, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v5, v6, :cond_55a

    iget-object v1, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    const/4 v5, 0x1

    aget-object v1, v1, v5

    sget-object v6, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v1, v6, :cond_55a

    move v14, v5

    goto :goto_55d

    :cond_55a
    move v14, v3

    goto :goto_55d

    :cond_55c
    move v14, v13

    :goto_55d
    if-eqz v14, :cond_564

    const/16 v1, 0x8

    invoke-virtual {v10, v4, v2, v3, v1}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    :cond_564
    return-void
.end method

.method private getSceneString(Ljava/lang/StringBuilder;Ljava/lang/String;IIIIIIFF)V
    .registers 11

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p2, " :  {\n"

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p2, "      size"

    const/4 p6, 0x0

    invoke-direct {p0, p1, p2, p3, p6}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAttribute(Ljava/lang/StringBuilder;Ljava/lang/String;II)V

    const-string p2, "      min"

    invoke-direct {p0, p1, p2, p4, p6}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAttribute(Ljava/lang/StringBuilder;Ljava/lang/String;II)V

    const-string p2, "      max"

    const p3, 0x7fffffff

    invoke-direct {p0, p1, p2, p5, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAttribute(Ljava/lang/StringBuilder;Ljava/lang/String;II)V

    const-string p2, "      matchMin"

    invoke-direct {p0, p1, p2, p7, p6}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAttribute(Ljava/lang/StringBuilder;Ljava/lang/String;II)V

    const-string p2, "      matchDef"

    invoke-direct {p0, p1, p2, p8, p6}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAttribute(Ljava/lang/StringBuilder;Ljava/lang/String;II)V

    const-string p2, "      matchPercent"

    const/high16 p3, 0x3f800000    # 1.0f

    invoke-direct {p0, p1, p2, p9, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAttribute(Ljava/lang/StringBuilder;Ljava/lang/String;FF)V

    const-string p2, "    },\n"

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    return-void
.end method

.method private getSceneString(Ljava/lang/StringBuilder;Ljava/lang/String;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V
    .registers 6

    iget-object v0, p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-nez v0, :cond_5

    return-void

    :cond_5
    const-string v0, "    "

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p2, " : [ \'"

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object p2, p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string p2, "\'"

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget p2, p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mGoneMargin:I

    const/high16 v0, -0x80000000

    if-ne p2, v0, :cond_26

    iget p2, p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mMargin:I

    if-eqz p2, :cond_3f

    :cond_26
    const-string p2, ","

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mMargin:I

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    iget v1, p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mGoneMargin:I

    if-eq v1, v0, :cond_3f

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget p3, p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mGoneMargin:I

    invoke-virtual {p1, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_3f
    const-string p2, " ] ,\n"

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    return-void
.end method

.method private isChainHead(I)Z
    .registers 5

    mul-int/lit8 p1, p1, 0x2

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aget-object v0, v0, p1

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz v0, :cond_2f

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aget-object v0, v0, p1

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aget-object v2, v1, p1

    if-eq v0, v2, :cond_2f

    const/4 v0, 0x1

    add-int/2addr p1, v0

    aget-object v1, v1, p1

    iget-object v1, v1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz v1, :cond_2f

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aget-object v1, v1, p1

    iget-object v1, v1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v1, v1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aget-object p1, v2, p1

    if-ne v1, p1, :cond_2f

    goto :goto_30

    :cond_2f
    const/4 v0, 0x0

    :goto_30
    return v0
.end method

.method private serializeAnchor(Ljava/lang/StringBuilder;Ljava/lang/String;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V
    .registers 5

    iget-object v0, p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-nez v0, :cond_5

    return-void

    :cond_5
    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p2, " : [ \'"

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object p2, p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string p2, "\',"

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget p2, p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mMargin:I

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p2, ","

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget p3, p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mGoneMargin:I

    invoke-virtual {p1, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p2, " ] ,\n"

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    return-void
.end method

.method private serializeAttribute(Ljava/lang/StringBuilder;Ljava/lang/String;FF)V
    .registers 5

    cmpl-float p4, p3, p4

    if-nez p4, :cond_5

    return-void

    :cond_5
    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p2, " :   "

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1, p3}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    const-string p2, ",\n"

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    return-void
.end method

.method private serializeAttribute(Ljava/lang/StringBuilder;Ljava/lang/String;II)V
    .registers 5

    if-ne p3, p4, :cond_3

    return-void

    :cond_3
    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p2, " :   "

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p2, ",\n"

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    return-void
.end method

.method private serializeCircle(Ljava/lang/StringBuilder;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;F)V
    .registers 5

    iget-object v0, p2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-nez v0, :cond_5

    return-void

    :cond_5
    const-string v0, "circle : [ \'"

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v0, p2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v0, "\',"

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget p2, p2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mMargin:I

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p2, ","

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1, p3}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p2, " ] ,\n"

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    return-void
.end method

.method private serializeDimensionRatio(Ljava/lang/StringBuilder;Ljava/lang/String;FI)V
    .registers 6

    const/4 v0, 0x0

    cmpl-float v0, p3, v0

    if-nez v0, :cond_6

    return-void

    :cond_6
    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p2, " :  ["

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1, p3}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    const-string p2, ","

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1, p4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p2, ""

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p2, "],\n"

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    return-void
.end method

.method private serializeSize(Ljava/lang/StringBuilder;Ljava/lang/String;IIIIIIFF)V
    .registers 11

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p2, " :  {\n"

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p2, "size"

    const/high16 p6, -0x80000000

    invoke-direct {p0, p1, p2, p3, p6}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAttribute(Ljava/lang/StringBuilder;Ljava/lang/String;II)V

    const-string p2, "min"

    const/4 p3, 0x0

    invoke-direct {p0, p1, p2, p4, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAttribute(Ljava/lang/StringBuilder;Ljava/lang/String;II)V

    const-string p2, "max"

    const p4, 0x7fffffff

    invoke-direct {p0, p1, p2, p5, p4}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAttribute(Ljava/lang/StringBuilder;Ljava/lang/String;II)V

    const-string p2, "matchMin"

    invoke-direct {p0, p1, p2, p7, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAttribute(Ljava/lang/StringBuilder;Ljava/lang/String;II)V

    const-string p2, "matchDef"

    invoke-direct {p0, p1, p2, p8, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAttribute(Ljava/lang/StringBuilder;Ljava/lang/String;II)V

    const-string p2, "matchPercent"

    const/4 p3, 0x1

    invoke-direct {p0, p1, p2, p8, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAttribute(Ljava/lang/StringBuilder;Ljava/lang/String;II)V

    const-string p2, "},\n"

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    return-void
.end method


# virtual methods
.method public addChildrenToSolverByDependency(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;Landroidx/constraintlayout/core/LinearSystem;Ljava/util/HashSet;IZ)V
    .registers 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;",
            "Landroidx/constraintlayout/core/LinearSystem;",
            "Ljava/util/HashSet<",
            "Landroidx/constraintlayout/core/widgets/ConstraintWidget;",
            ">;IZ)V"
        }
    .end annotation

    if-eqz p5, :cond_18

    invoke-virtual {p3, p0}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result p5

    if-nez p5, :cond_9

    return-void

    :cond_9
    invoke-static {p1, p2, p0}, Landroidx/constraintlayout/core/widgets/Optimizer;->checkMatchParent(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;Landroidx/constraintlayout/core/LinearSystem;Landroidx/constraintlayout/core/widgets/ConstraintWidget;)V

    invoke-virtual {p3, p0}, Ljava/util/HashSet;->remove(Ljava/lang/Object;)Z

    const/16 p5, 0x40

    invoke-virtual {p1, p5}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->optimizeFor(I)Z

    move-result p5

    invoke-virtual {p0, p2, p5}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->addToSolver(Landroidx/constraintlayout/core/LinearSystem;Z)V

    :cond_18
    if-nez p4, :cond_60

    iget-object p5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p5}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getDependents()Ljava/util/HashSet;

    move-result-object p5

    if-eqz p5, :cond_3d

    invoke-virtual {p5}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object p5

    :goto_26
    invoke-interface {p5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3d

    invoke-interface {p5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    const/4 v6, 0x1

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move v5, p4

    invoke-virtual/range {v1 .. v6}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->addChildrenToSolverByDependency(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;Landroidx/constraintlayout/core/LinearSystem;Ljava/util/HashSet;IZ)V

    goto :goto_26

    :cond_3d
    iget-object p5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p5}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getDependents()Ljava/util/HashSet;

    move-result-object p5

    if-eqz p5, :cond_c9

    invoke-virtual {p5}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object p5

    :goto_49
    invoke-interface {p5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_c9

    invoke-interface {p5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    const/4 v6, 0x1

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move v5, p4

    invoke-virtual/range {v1 .. v6}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->addChildrenToSolverByDependency(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;Landroidx/constraintlayout/core/LinearSystem;Ljava/util/HashSet;IZ)V

    goto :goto_49

    :cond_60
    iget-object p5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p5}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getDependents()Ljava/util/HashSet;

    move-result-object p5

    if-eqz p5, :cond_83

    invoke-virtual {p5}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object p5

    :goto_6c
    invoke-interface {p5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_83

    invoke-interface {p5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    const/4 v6, 0x1

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move v5, p4

    invoke-virtual/range {v1 .. v6}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->addChildrenToSolverByDependency(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;Landroidx/constraintlayout/core/LinearSystem;Ljava/util/HashSet;IZ)V

    goto :goto_6c

    :cond_83
    iget-object p5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p5}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getDependents()Ljava/util/HashSet;

    move-result-object p5

    if-eqz p5, :cond_a6

    invoke-virtual {p5}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object p5

    :goto_8f
    invoke-interface {p5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_a6

    invoke-interface {p5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    const/4 v6, 0x1

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move v5, p4

    invoke-virtual/range {v1 .. v6}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->addChildrenToSolverByDependency(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;Landroidx/constraintlayout/core/LinearSystem;Ljava/util/HashSet;IZ)V

    goto :goto_8f

    :cond_a6
    iget-object p5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p5}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getDependents()Ljava/util/HashSet;

    move-result-object p5

    if-eqz p5, :cond_c9

    invoke-virtual {p5}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object p5

    :goto_b2
    invoke-interface {p5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_c9

    invoke-interface {p5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    const/4 v6, 0x1

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move v5, p4

    invoke-virtual/range {v1 .. v6}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->addChildrenToSolverByDependency(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;Landroidx/constraintlayout/core/LinearSystem;Ljava/util/HashSet;IZ)V

    goto :goto_b2

    :cond_c9
    return-void
.end method

.method addFirst()Z
    .registers 2

    instance-of v0, p0, Landroidx/constraintlayout/core/widgets/VirtualLayout;

    if-nez v0, :cond_b

    instance-of v0, p0, Landroidx/constraintlayout/core/widgets/Guideline;

    if-eqz v0, :cond_9

    goto :goto_b

    :cond_9
    const/4 v0, 0x0

    goto :goto_c

    :cond_b
    :goto_b
    const/4 v0, 0x1

    :goto_c
    return v0
.end method

.method public addToSolver(Landroidx/constraintlayout/core/LinearSystem;Z)V
    .registers 53

    move-object/from16 v15, p0

    move-object/from16 v14, p1

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v14, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v13

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v14, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v12

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v14, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v11

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v14, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v10

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v14, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v9

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    const/4 v8, 0x2

    const/4 v1, 0x3

    const/4 v7, 0x1

    const/4 v6, 0x0

    if-eqz v0, :cond_57

    if-eqz v0, :cond_36

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    aget-object v0, v0, v6

    sget-object v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->WRAP_CONTENT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v0, v2, :cond_36

    move v0, v7

    goto :goto_37

    :cond_36
    move v0, v6

    :goto_37
    iget-object v2, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    if-eqz v2, :cond_45

    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    aget-object v2, v2, v7

    sget-object v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->WRAP_CONTENT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v2, v3, :cond_45

    move v2, v7

    goto :goto_46

    :cond_45
    move v2, v6

    :goto_46
    iget v3, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWrapBehaviorInParent:I

    if-eq v3, v7, :cond_54

    if-eq v3, v8, :cond_51

    if-eq v3, v1, :cond_57

    move v4, v0

    move v5, v2

    goto :goto_59

    :cond_51
    move v5, v2

    move v4, v6

    goto :goto_59

    :cond_54
    move v4, v0

    move v5, v6

    goto :goto_59

    :cond_57
    move v4, v6

    move v5, v4

    :goto_59
    iget v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    const/16 v3, 0x8

    if-ne v0, v3, :cond_74

    iget-boolean v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mAnimated:Z

    if-nez v0, :cond_74

    invoke-virtual/range {p0 .. p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->hasDependencies()Z

    move-result v0

    if-nez v0, :cond_74

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mIsInBarrier:[Z

    aget-boolean v2, v0, v6

    if-nez v2, :cond_74

    aget-boolean v0, v0, v7

    if-nez v0, :cond_74

    return-void

    :cond_74
    iget-boolean v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedHorizontal:Z

    const/4 v2, 0x5

    if-nez v0, :cond_7d

    iget-boolean v8, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedVertical:Z

    if-eqz v8, :cond_fa

    :cond_7d
    if-eqz v0, :cond_ac

    iget v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    invoke-virtual {v14, v13, v0}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    iget v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    iget v8, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    add-int/2addr v0, v8

    invoke-virtual {v14, v12, v0}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    if-eqz v4, :cond_ac

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    if-eqz v0, :cond_ac

    iget-boolean v8, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->OPTIMIZE_WRAP_ON_RESOLVED:Z

    if-eqz v8, :cond_a3

    check-cast v0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    iget-object v8, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, v8}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->addHorizontalWrapMinVariable(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V

    iget-object v8, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, v8}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->addHorizontalWrapMaxVariable(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V

    goto :goto_ac

    :cond_a3
    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v14, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v0

    invoke-virtual {v14, v0, v12, v6, v2}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    :cond_ac
    :goto_ac
    iget-boolean v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedVertical:Z

    if-eqz v0, :cond_ed

    iget v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    invoke-virtual {v14, v11, v0}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    iget v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    iget v8, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    add-int/2addr v0, v8

    invoke-virtual {v14, v10, v0}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->hasDependents()Z

    move-result v0

    if-eqz v0, :cond_cd

    iget v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    iget v8, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaselineDistance:I

    add-int/2addr v0, v8

    invoke-virtual {v14, v9, v0}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    :cond_cd
    if-eqz v5, :cond_ed

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    if-eqz v0, :cond_ed

    iget-boolean v8, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->OPTIMIZE_WRAP_ON_RESOLVED:Z

    if-eqz v8, :cond_e4

    check-cast v0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    iget-object v8, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, v8}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->addVerticalWrapMinVariable(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V

    iget-object v8, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, v8}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->addVerticalWrapMaxVariable(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V

    goto :goto_ed

    :cond_e4
    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v14, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v0

    invoke-virtual {v14, v0, v10, v6, v2}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    :cond_ed
    :goto_ed
    iget-boolean v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedHorizontal:Z

    if-eqz v0, :cond_fa

    iget-boolean v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedVertical:Z

    if-eqz v0, :cond_fa

    iput-boolean v6, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedHorizontal:Z

    iput-boolean v6, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedVertical:Z

    return-void

    :cond_fa
    sget-object v0, Landroidx/constraintlayout/core/LinearSystem;->sMetrics:Landroidx/constraintlayout/core/Metrics;

    const-wide/16 v17, 0x1

    if-eqz v0, :cond_108

    sget-object v0, Landroidx/constraintlayout/core/LinearSystem;->sMetrics:Landroidx/constraintlayout/core/Metrics;

    iget-wide v1, v0, Landroidx/constraintlayout/core/Metrics;->widgets:J

    add-long v1, v1, v17

    iput-wide v1, v0, Landroidx/constraintlayout/core/Metrics;->widgets:J

    :cond_108
    if-eqz p2, :cond_1a4

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    if-eqz v0, :cond_1a4

    iget-object v1, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    if-eqz v1, :cond_1a4

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    if-eqz v0, :cond_1a4

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    if-eqz v0, :cond_1a4

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    if-eqz v0, :cond_1a4

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    if-eqz v0, :cond_1a4

    sget-object v0, Landroidx/constraintlayout/core/LinearSystem;->sMetrics:Landroidx/constraintlayout/core/Metrics;

    if-eqz v0, :cond_13c

    sget-object v0, Landroidx/constraintlayout/core/LinearSystem;->sMetrics:Landroidx/constraintlayout/core/Metrics;

    iget-wide v1, v0, Landroidx/constraintlayout/core/Metrics;->graphSolved:J

    add-long v1, v1, v17

    iput-wide v1, v0, Landroidx/constraintlayout/core/Metrics;->graphSolved:J

    :cond_13c
    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    invoke-virtual {v14, v13, v0}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    invoke-virtual {v14, v12, v0}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    invoke-virtual {v14, v11, v0}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    invoke-virtual {v14, v10, v0}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->baseline:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    invoke-virtual {v14, v9, v0}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    if-eqz v0, :cond_19f

    if-eqz v4, :cond_186

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isTerminalWidget:[Z

    aget-boolean v0, v0, v6

    if-eqz v0, :cond_186

    invoke-virtual/range {p0 .. p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isInHorizontalChain()Z

    move-result v0

    if-nez v0, :cond_186

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v14, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v0

    invoke-virtual {v14, v0, v12, v6, v3}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    :cond_186
    if-eqz v5, :cond_19f

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isTerminalWidget:[Z

    aget-boolean v0, v0, v7

    if-eqz v0, :cond_19f

    invoke-virtual/range {p0 .. p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isInVerticalChain()Z

    move-result v0

    if-nez v0, :cond_19f

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v14, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v0

    invoke-virtual {v14, v0, v10, v6, v3}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    :cond_19f
    iput-boolean v6, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedHorizontal:Z

    iput-boolean v6, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedVertical:Z

    return-void

    :cond_1a4
    sget-object v0, Landroidx/constraintlayout/core/LinearSystem;->sMetrics:Landroidx/constraintlayout/core/Metrics;

    if-eqz v0, :cond_1b0

    sget-object v0, Landroidx/constraintlayout/core/LinearSystem;->sMetrics:Landroidx/constraintlayout/core/Metrics;

    iget-wide v1, v0, Landroidx/constraintlayout/core/Metrics;->linearSolved:J

    add-long v1, v1, v17

    iput-wide v1, v0, Landroidx/constraintlayout/core/Metrics;->linearSolved:J

    :cond_1b0
    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    if-eqz v0, :cond_221

    invoke-direct {v15, v6}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isChainHead(I)Z

    move-result v0

    if-eqz v0, :cond_1c3

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    check-cast v0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    invoke-virtual {v0, v15, v6}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->addChain(Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)V

    move v0, v7

    goto :goto_1c7

    :cond_1c3
    invoke-virtual/range {p0 .. p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isInHorizontalChain()Z

    move-result v0

    :goto_1c7
    invoke-direct {v15, v7}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isChainHead(I)Z

    move-result v1

    if-eqz v1, :cond_1d6

    iget-object v1, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    check-cast v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    invoke-virtual {v1, v15, v7}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->addChain(Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)V

    move v1, v7

    goto :goto_1da

    :cond_1d6
    invoke-virtual/range {p0 .. p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isInVerticalChain()Z

    move-result v1

    :goto_1da
    if-nez v0, :cond_1f9

    if-eqz v4, :cond_1f9

    iget v2, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    if-eq v2, v3, :cond_1f9

    iget-object v2, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-nez v2, :cond_1f9

    iget-object v2, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-nez v2, :cond_1f9

    iget-object v2, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v14, v2}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v2

    invoke-virtual {v14, v2, v12, v6, v7}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    :cond_1f9
    if-nez v1, :cond_21c

    if-eqz v5, :cond_21c

    iget v2, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    if-eq v2, v3, :cond_21c

    iget-object v2, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-nez v2, :cond_21c

    iget-object v2, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-nez v2, :cond_21c

    iget-object v2, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-nez v2, :cond_21c

    iget-object v2, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v14, v2}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v2

    invoke-virtual {v14, v2, v10, v6, v7}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    :cond_21c
    move/from16 v29, v0

    move/from16 v28, v1

    goto :goto_225

    :cond_221
    move/from16 v28, v6

    move/from16 v29, v28

    :goto_225
    iget v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    iget v1, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinWidth:I

    if-ge v0, v1, :cond_22c

    move v0, v1

    :cond_22c
    iget v1, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    iget v2, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinHeight:I

    if-ge v1, v2, :cond_233

    move v1, v2

    :cond_233
    iget-object v2, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    aget-object v2, v2, v6

    sget-object v8, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-eq v2, v8, :cond_23d

    move v2, v7

    goto :goto_23e

    :cond_23d
    move v2, v6

    :goto_23e
    iget-object v8, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    aget-object v8, v8, v7

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-eq v8, v7, :cond_248

    const/4 v7, 0x1

    goto :goto_249

    :cond_248
    move v7, v6

    :goto_249
    iget v8, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatioSide:I

    iput v8, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    iget v8, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatio:F

    iput v8, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatio:F

    iget v6, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultWidth:I

    iget v3, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultHeight:I

    const/16 v22, 0x0

    cmpl-float v8, v8, v22

    move/from16 v22, v0

    if-lez v8, :cond_2fc

    iget v8, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    const/16 v0, 0x8

    if-eq v8, v0, :cond_2fc

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    const/4 v8, 0x0

    aget-object v0, v0, v8

    sget-object v8, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v0, v8, :cond_26f

    if-nez v6, :cond_26f

    const/4 v6, 0x3

    :cond_26f
    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    const/4 v8, 0x1

    aget-object v0, v0, v8

    sget-object v8, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v0, v8, :cond_27b

    if-nez v3, :cond_27b

    const/4 v3, 0x3

    :cond_27b
    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    const/4 v8, 0x0

    aget-object v0, v0, v8

    sget-object v8, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v0, v8, :cond_296

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    const/4 v8, 0x1

    aget-object v0, v0, v8

    sget-object v8, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v0, v8, :cond_296

    const/4 v0, 0x3

    if-ne v6, v0, :cond_296

    if-ne v3, v0, :cond_296

    invoke-virtual {v15, v4, v5, v2, v7}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setupDimensionRatio(ZZZZ)V

    goto :goto_2f2

    :cond_296
    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    const/4 v2, 0x0

    aget-object v0, v0, v2

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    const/16 v17, 0x4

    if-ne v0, v7, :cond_2c1

    const/4 v0, 0x3

    if-ne v6, v0, :cond_2c1

    iput v2, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    iget v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatio:F

    iget v2, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    int-to-float v2, v2

    mul-float/2addr v0, v2

    float-to-int v0, v0

    iget-object v2, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    const/4 v7, 0x1

    aget-object v2, v2, v7

    sget-object v8, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move/from16 v30, v1

    move/from16 v31, v3

    if-eq v2, v8, :cond_2bd

    move/from16 v32, v17

    goto :goto_304

    :cond_2bd
    move/from16 v32, v6

    move v8, v7

    goto :goto_305

    :cond_2c1
    const/4 v7, 0x1

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    aget-object v0, v0, v7

    sget-object v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v0, v2, :cond_2f2

    const/4 v0, 0x3

    if-ne v3, v0, :cond_2f2

    iput v7, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    iget v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatioSide:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_2db

    const/high16 v0, 0x3f800000    # 1.0f

    iget v1, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatio:F

    div-float/2addr v0, v1

    iput v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatio:F

    :cond_2db
    iget v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatio:F

    iget v1, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    int-to-float v1, v1

    mul-float/2addr v0, v1

    float-to-int v1, v0

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    const/4 v2, 0x0

    aget-object v0, v0, v2

    sget-object v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-eq v0, v2, :cond_2f2

    move/from16 v30, v1

    move/from16 v32, v6

    move/from16 v31, v17

    goto :goto_302

    :cond_2f2
    :goto_2f2
    move/from16 v30, v1

    move/from16 v31, v3

    move/from16 v32, v6

    move/from16 v0, v22

    const/4 v8, 0x1

    goto :goto_305

    :cond_2fc
    move/from16 v30, v1

    move/from16 v31, v3

    move/from16 v32, v6

    :goto_302
    move/from16 v0, v22

    :goto_304
    const/4 v8, 0x0

    :goto_305
    iget-object v1, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedMatchConstraintDefault:[I

    const/4 v2, 0x0

    aput v32, v1, v2

    const/4 v2, 0x1

    aput v31, v1, v2

    iput-boolean v8, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedHasRatio:Z

    if-eqz v8, :cond_31b

    iget v1, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    const/4 v2, -0x1

    if-eqz v1, :cond_318

    if-ne v1, v2, :cond_31c

    :cond_318
    const/16 v17, 0x1

    goto :goto_31e

    :cond_31b
    const/4 v2, -0x1

    :cond_31c
    const/16 v17, 0x0

    :goto_31e
    if-eqz v8, :cond_32a

    iget v1, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    const/4 v3, 0x1

    if-eq v1, v3, :cond_327

    if-ne v1, v2, :cond_32a

    :cond_327
    const/16 v33, 0x1

    goto :goto_32c

    :cond_32a
    const/16 v33, 0x0

    :goto_32c
    iget-object v1, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    const/4 v2, 0x0

    aget-object v1, v1, v2

    sget-object v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->WRAP_CONTENT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v1, v2, :cond_33c

    instance-of v1, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    if-eqz v1, :cond_33c

    const/16 v22, 0x1

    goto :goto_33e

    :cond_33c
    const/16 v22, 0x0

    :goto_33e
    if-eqz v22, :cond_343

    const/16 v23, 0x0

    goto :goto_345

    :cond_343
    move/from16 v23, v0

    :goto_345
    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenter:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result v0

    const/4 v1, 0x1

    xor-int/lit8 v34, v0, 0x1

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mIsInBarrier:[Z

    const/4 v2, 0x0

    aget-boolean v27, v0, v2

    aget-boolean v35, v0, v1

    iget v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalResolution:I

    const/16 v36, 0x0

    const/4 v7, 0x2

    if-eq v0, v7, :cond_44b

    iget-boolean v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedHorizontal:Z

    if-nez v0, :cond_44b

    if-eqz p2, :cond_3ab

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    if-eqz v0, :cond_3ab

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    if-eqz v0, :cond_3ab

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    if-nez v0, :cond_375

    goto :goto_3ab

    :cond_375
    if-eqz p2, :cond_44b

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    invoke-virtual {v14, v13, v0}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    invoke-virtual {v14, v12, v0}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    if-eqz v0, :cond_44b

    if-eqz v4, :cond_44b

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isTerminalWidget:[Z

    const/4 v1, 0x0

    aget-boolean v0, v0, v1

    if-eqz v0, :cond_44b

    invoke-virtual/range {p0 .. p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isInHorizontalChain()Z

    move-result v0

    if-nez v0, :cond_44b

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v14, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v0

    const/16 v3, 0x8

    invoke-virtual {v14, v0, v12, v1, v3}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    goto/16 :goto_44b

    :cond_3ab
    :goto_3ab
    const/16 v3, 0x8

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    if-eqz v0, :cond_3ba

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v14, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v0

    move-object/from16 v16, v0

    goto :goto_3bc

    :cond_3ba
    move-object/from16 v16, v36

    :goto_3bc
    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    if-eqz v0, :cond_3c8

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v14, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v0

    move-object v6, v0

    goto :goto_3ca

    :cond_3c8
    move-object/from16 v6, v36

    :goto_3ca
    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isTerminalWidget:[Z

    const/16 v20, 0x0

    aget-boolean v21, v0, v20

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    aget-object v37, v0, v20

    iget-object v1, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v2, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-object/from16 v39, v2

    iget v2, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    move/from16 v40, v2

    iget v2, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinWidth:I

    iget-object v3, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMaxDimension:[I

    aget v42, v3, v20

    iget v3, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalBiasPercent:F

    const/16 v18, 0x1

    aget-object v0, v0, v18

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v0, v7, :cond_3f1

    move/from16 v44, v18

    goto :goto_3f3

    :cond_3f1
    move/from16 v44, v20

    :goto_3f3
    iget v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinWidth:I

    move/from16 v24, v0

    iget v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxWidth:I

    move/from16 v25, v0

    iget v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintPercentWidth:F

    move/from16 v26, v0

    move-object/from16 v0, p0

    move-object/from16 v45, v1

    move-object/from16 v1, p1

    move-object/from16 v19, v39

    move/from16 v38, v40

    const/4 v7, 0x5

    move/from16 v39, v2

    const/4 v2, 0x1

    move/from16 v40, v3

    move v3, v4

    move/from16 v41, v4

    move v4, v5

    move/from16 v46, v5

    move/from16 v5, v21

    const/16 v18, 0x2

    move-object/from16 v7, v16

    move/from16 v43, v8

    move-object/from16 v8, v37

    move-object/from16 v47, v9

    move/from16 v9, v22

    move-object/from16 v48, v10

    move-object/from16 v10, v45

    move-object/from16 v49, v11

    move-object/from16 v11, v19

    move-object/from16 v37, v12

    move/from16 v12, v38

    move-object/from16 v38, v13

    move/from16 v13, v23

    move/from16 v14, v39

    move/from16 v15, v42

    move/from16 v16, v40

    move/from16 v18, v44

    move/from16 v19, v29

    move/from16 v20, v28

    move/from16 v21, v27

    move/from16 v22, v32

    move/from16 v23, v31

    move/from16 v27, v34

    invoke-direct/range {v0 .. v27}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->applyConstraints(Landroidx/constraintlayout/core/LinearSystem;ZZZZLandroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;ZLandroidx/constraintlayout/core/widgets/ConstraintAnchor;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;IIIIFZZZZZIIIIFZ)V

    goto :goto_45b

    :cond_44b
    :goto_44b
    move/from16 v41, v4

    move/from16 v46, v5

    move/from16 v43, v8

    move-object/from16 v47, v9

    move-object/from16 v48, v10

    move-object/from16 v49, v11

    move-object/from16 v37, v12

    move-object/from16 v38, v13

    :goto_45b
    if-eqz p2, :cond_4c7

    move-object/from16 v15, p0

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    if-eqz v0, :cond_4ba

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    if-eqz v0, :cond_4ba

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    if-eqz v0, :cond_4ba

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    move-object/from16 v14, p1

    move-object/from16 v13, v49

    invoke-virtual {v14, v13, v0}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    move-object/from16 v12, v48

    invoke-virtual {v14, v12, v0}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->baseline:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    move-object/from16 v1, v47

    invoke-virtual {v14, v1, v0}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    if-eqz v0, :cond_4b4

    if-nez v28, :cond_4b4

    if-eqz v46, :cond_4b4

    iget-object v2, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isTerminalWidget:[Z

    const/4 v11, 0x1

    aget-boolean v2, v2, v11

    if-eqz v2, :cond_4b0

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v14, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v0

    const/16 v2, 0x8

    const/4 v10, 0x0

    invoke-virtual {v14, v0, v12, v10, v2}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    goto :goto_4b8

    :cond_4b0
    const/16 v2, 0x8

    const/4 v10, 0x0

    goto :goto_4b8

    :cond_4b4
    const/16 v2, 0x8

    const/4 v10, 0x0

    const/4 v11, 0x1

    :goto_4b8
    move v7, v10

    goto :goto_4d6

    :cond_4ba
    move-object/from16 v14, p1

    move-object/from16 v1, v47

    move-object/from16 v12, v48

    move-object/from16 v13, v49

    const/16 v2, 0x8

    const/4 v10, 0x0

    const/4 v11, 0x1

    goto :goto_4d5

    :cond_4c7
    const/16 v2, 0x8

    const/4 v10, 0x0

    const/4 v11, 0x1

    move-object/from16 v15, p0

    move-object/from16 v14, p1

    move-object/from16 v1, v47

    move-object/from16 v12, v48

    move-object/from16 v13, v49

    :goto_4d5
    move v7, v11

    :goto_4d6
    iget v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalResolution:I

    const/4 v3, 0x2

    if-ne v0, v3, :cond_4dd

    move v6, v10

    goto :goto_4de

    :cond_4dd
    move v6, v7

    :goto_4de
    if-eqz v6, :cond_5c0

    iget-boolean v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedVertical:Z

    if-nez v0, :cond_5c0

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    aget-object v0, v0, v11

    sget-object v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->WRAP_CONTENT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v0, v3, :cond_4f2

    instance-of v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    if-eqz v0, :cond_4f2

    move v9, v11

    goto :goto_4f3

    :cond_4f2
    move v9, v10

    :goto_4f3
    if-eqz v9, :cond_4f7

    move/from16 v30, v10

    :cond_4f7
    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    if-eqz v0, :cond_503

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v14, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v0

    move-object v7, v0

    goto :goto_505

    :cond_503
    move-object/from16 v7, v36

    :goto_505
    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    if-eqz v0, :cond_511

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v14, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v0

    move-object v6, v0

    goto :goto_513

    :cond_511
    move-object/from16 v6, v36

    :goto_513
    iget v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaselineDistance:I

    if-gtz v0, :cond_51b

    iget v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    if-ne v0, v2, :cond_55d

    :cond_51b
    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz v0, :cond_548

    invoke-virtual/range {p0 .. p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getBaselineDistance()I

    move-result v0

    invoke-virtual {v14, v1, v13, v0, v2}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)Landroidx/constraintlayout/core/ArrayRow;

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v14, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v0

    iget-object v3, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v3

    invoke-virtual {v14, v1, v0, v3, v2}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)Landroidx/constraintlayout/core/ArrayRow;

    if-eqz v46, :cond_545

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v14, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v0

    const/4 v1, 0x5

    invoke-virtual {v14, v7, v0, v10, v1}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    :cond_545
    move/from16 v27, v10

    goto :goto_55f

    :cond_548
    iget v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    if-ne v0, v2, :cond_556

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v0

    invoke-virtual {v14, v1, v13, v0, v2}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)Landroidx/constraintlayout/core/ArrayRow;

    goto :goto_55d

    :cond_556
    invoke-virtual/range {p0 .. p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getBaselineDistance()I

    move-result v0

    invoke-virtual {v14, v1, v13, v0, v2}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)Landroidx/constraintlayout/core/ArrayRow;

    :cond_55d
    :goto_55d
    move/from16 v27, v34

    :goto_55f
    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isTerminalWidget:[Z

    aget-boolean v5, v0, v11

    iget-object v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    aget-object v8, v0, v11

    iget-object v4, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v3, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget v1, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    iget v2, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinHeight:I

    iget-object v10, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMaxDimension:[I

    aget v16, v10, v11

    iget v10, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalBiasPercent:F

    const/16 v17, 0x0

    aget-object v0, v0, v17

    sget-object v11, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v0, v11, :cond_580

    const/16 v18, 0x1

    goto :goto_582

    :cond_580
    move/from16 v18, v17

    :goto_582
    iget v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinHeight:I

    move/from16 v24, v0

    iget v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxHeight:I

    move/from16 v25, v0

    iget v0, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintPercentHeight:F

    move/from16 v26, v0

    move-object/from16 v0, p0

    move/from16 v19, v1

    move-object/from16 v1, p1

    move/from16 v20, v2

    const/4 v2, 0x0

    move-object v11, v3

    move/from16 v3, v46

    move-object/from16 v21, v4

    move/from16 v4, v41

    move/from16 v17, v10

    move-object/from16 v10, v21

    move-object/from16 v34, v12

    move/from16 v12, v19

    move-object/from16 v36, v13

    move/from16 v13, v30

    move/from16 v14, v20

    move/from16 v15, v16

    move/from16 v16, v17

    move/from16 v17, v33

    move/from16 v19, v28

    move/from16 v20, v29

    move/from16 v21, v35

    move/from16 v22, v31

    move/from16 v23, v32

    invoke-direct/range {v0 .. v27}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->applyConstraints(Landroidx/constraintlayout/core/LinearSystem;ZZZZLandroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;ZLandroidx/constraintlayout/core/widgets/ConstraintAnchor;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;IIIIFZZZZZIIIIFZ)V

    goto :goto_5c4

    :cond_5c0
    move-object/from16 v34, v12

    move-object/from16 v36, v13

    :goto_5c4
    if-eqz v43, :cond_5f1

    const/16 v6, 0x8

    move-object/from16 v7, p0

    iget v0, v7, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_5df

    iget v5, v7, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatio:F

    move-object/from16 v0, p1

    move-object/from16 v1, v34

    move-object/from16 v2, v36

    move-object/from16 v3, v37

    move-object/from16 v4, v38

    invoke-virtual/range {v0 .. v6}, Landroidx/constraintlayout/core/LinearSystem;->addRatio(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;FI)V

    goto :goto_5f3

    :cond_5df
    iget v5, v7, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatio:F

    const/16 v6, 0x8

    move-object/from16 v0, p1

    move-object/from16 v1, v37

    move-object/from16 v2, v38

    move-object/from16 v3, v34

    move-object/from16 v4, v36

    invoke-virtual/range {v0 .. v6}, Landroidx/constraintlayout/core/LinearSystem;->addRatio(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;FI)V

    goto :goto_5f3

    :cond_5f1
    move-object/from16 v7, p0

    :goto_5f3
    iget-object v0, v7, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenter:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_61b

    iget-object v0, v7, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenter:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getTarget()Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getOwner()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v0

    iget v1, v7, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCircleConstraintAngle:F

    const/high16 v2, 0x42b40000    # 90.0f

    add-float/2addr v1, v2

    float-to-double v1, v1

    invoke-static {v1, v2}, Ljava/lang/Math;->toRadians(D)D

    move-result-wide v1

    double-to-float v1, v1

    iget-object v2, v7, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenter:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v2

    move-object/from16 v3, p1

    invoke-virtual {v3, v7, v0, v1, v2}, Landroidx/constraintlayout/core/LinearSystem;->addCenterPoint(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintWidget;FI)V

    :cond_61b
    const/4 v0, 0x0

    iput-boolean v0, v7, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedHorizontal:Z

    iput-boolean v0, v7, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedVertical:Z

    return-void
.end method

.method public allowedInBarrier()Z
    .registers 3

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    const/16 v1, 0x8

    if-eq v0, v1, :cond_8

    const/4 v0, 0x1

    goto :goto_9

    :cond_8
    const/4 v0, 0x0

    :goto_9
    return v0
.end method

.method public connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)V
    .registers 5

    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, p3, v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;I)V

    return-void
.end method

.method public connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;I)V
    .registers 8

    sget-object v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    const/4 v1, 0x0

    if-ne p1, v0, :cond_e1

    sget-object p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    if-ne p3, p1, :cond_9e

    sget-object p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->LEFT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    sget-object p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->RIGHT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p3

    sget-object p4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->TOP:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p4}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p4

    sget-object v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->BOTTOM:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v0

    const/4 v2, 0x1

    if-eqz p1, :cond_2a

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result p1

    if-nez p1, :cond_32

    :cond_2a
    if-eqz p3, :cond_34

    invoke-virtual {p3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result p1

    if-eqz p1, :cond_34

    :cond_32
    move p1, v1

    goto :goto_43

    :cond_34
    sget-object p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->LEFT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    sget-object p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->LEFT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p1, p2, p3, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;I)V

    sget-object p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->RIGHT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    sget-object p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->RIGHT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p1, p2, p3, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;I)V

    move p1, v2

    :goto_43
    if-eqz p4, :cond_4b

    invoke-virtual {p4}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result p3

    if-nez p3, :cond_53

    :cond_4b
    if-eqz v0, :cond_55

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result p3

    if-eqz p3, :cond_55

    :cond_53
    move v2, v1

    goto :goto_63

    :cond_55
    sget-object p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->TOP:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    sget-object p4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->TOP:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p3, p2, p4, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;I)V

    sget-object p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->BOTTOM:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    sget-object p4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->BOTTOM:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p3, p2, p4, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;I)V

    :goto_63
    if-eqz p1, :cond_78

    if-eqz v2, :cond_78

    sget-object p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    sget-object p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p2, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p2

    invoke-virtual {p1, p2, v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    goto/16 :goto_240

    :cond_78
    if-eqz p1, :cond_8b

    sget-object p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER_X:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    sget-object p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER_X:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p2, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p2

    invoke-virtual {p1, p2, v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    goto/16 :goto_240

    :cond_8b
    if-eqz v2, :cond_240

    sget-object p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER_Y:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    sget-object p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER_Y:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p2, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p2

    invoke-virtual {p1, p2, v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    goto/16 :goto_240

    :cond_9e
    sget-object p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->LEFT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    if-eq p3, p1, :cond_c8

    sget-object p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->RIGHT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    if-ne p3, p1, :cond_a7

    goto :goto_c8

    :cond_a7
    sget-object p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->TOP:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    if-eq p3, p1, :cond_af

    sget-object p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->BOTTOM:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    if-ne p3, p1, :cond_240

    :cond_af
    sget-object p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->TOP:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p1, p2, p3, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;I)V

    sget-object p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->BOTTOM:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p1, p2, p3, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;I)V

    sget-object p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    invoke-virtual {p2, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p2

    invoke-virtual {p1, p2, v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    goto/16 :goto_240

    :cond_c8
    :goto_c8
    sget-object p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->LEFT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p1, p2, p3, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;I)V

    sget-object p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->RIGHT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p1, p2, p3, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;I)V

    sget-object p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    invoke-virtual {p2, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p2

    invoke-virtual {p1, p2, v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    goto/16 :goto_240

    :cond_e1
    sget-object v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER_X:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    if-ne p1, v0, :cond_10e

    sget-object v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->LEFT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    if-eq p3, v0, :cond_ed

    sget-object v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->RIGHT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    if-ne p3, v0, :cond_10e

    :cond_ed
    sget-object p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->LEFT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    invoke-virtual {p2, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p2

    sget-object p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->RIGHT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p3

    invoke-virtual {p1, p2, v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    invoke-virtual {p3, p2, v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    sget-object p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER_X:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    invoke-virtual {p1, p2, v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    goto/16 :goto_240

    :cond_10e
    sget-object v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER_Y:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    if-ne p1, v0, :cond_13b

    sget-object v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->TOP:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    if-eq p3, v0, :cond_11a

    sget-object v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->BOTTOM:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    if-ne p3, v0, :cond_13b

    :cond_11a
    invoke-virtual {p2, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    sget-object p2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->TOP:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p2

    invoke-virtual {p2, p1, v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    sget-object p2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->BOTTOM:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p2

    invoke-virtual {p2, p1, v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    sget-object p2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER_Y:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p2

    invoke-virtual {p2, p1, v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    goto/16 :goto_240

    :cond_13b
    sget-object v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER_X:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    if-ne p1, v0, :cond_170

    sget-object v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER_X:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    if-ne p3, v0, :cond_170

    sget-object p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->LEFT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    sget-object p4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->LEFT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p2, p4}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p4

    invoke-virtual {p1, p4, v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    sget-object p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->RIGHT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    sget-object p4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->RIGHT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p2, p4}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p4

    invoke-virtual {p1, p4, v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    sget-object p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER_X:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    invoke-virtual {p2, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p2

    invoke-virtual {p1, p2, v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    goto/16 :goto_240

    :cond_170
    sget-object v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER_Y:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    if-ne p1, v0, :cond_1a5

    sget-object v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER_Y:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    if-ne p3, v0, :cond_1a5

    sget-object p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->TOP:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    sget-object p4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->TOP:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p2, p4}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p4

    invoke-virtual {p1, p4, v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    sget-object p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->BOTTOM:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    sget-object p4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->BOTTOM:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p2, p4}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p4

    invoke-virtual {p1, p4, v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    sget-object p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER_Y:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    invoke-virtual {p2, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p2

    invoke-virtual {p1, p2, v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    goto/16 :goto_240

    :cond_1a5
    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v0

    invoke-virtual {p2, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p2

    invoke-virtual {v0, p2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isValidConnection(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)Z

    move-result p3

    if-eqz p3, :cond_240

    sget-object p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->BASELINE:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    if-ne p1, p3, :cond_1ce

    sget-object p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->TOP:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    sget-object p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->BOTTOM:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p3

    if-eqz p1, :cond_1c8

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    :cond_1c8
    if-eqz p3, :cond_23d

    invoke-virtual {p3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    goto :goto_23d

    :cond_1ce
    sget-object p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->TOP:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    if-eq p1, p3, :cond_209

    sget-object p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->BOTTOM:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    if-ne p1, p3, :cond_1d7

    goto :goto_209

    :cond_1d7
    sget-object p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->LEFT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    if-eq p1, p3, :cond_1df

    sget-object p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->RIGHT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    if-ne p1, p3, :cond_23d

    :cond_1df
    sget-object p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p3

    invoke-virtual {p3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getTarget()Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v1

    if-eq v1, p2, :cond_1ee

    invoke-virtual {p3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    :cond_1ee
    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getOpposite()Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    sget-object p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER_X:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p3

    invoke-virtual {p3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result v1

    if-eqz v1, :cond_23d

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    invoke-virtual {p3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    goto :goto_23d

    :cond_209
    :goto_209
    sget-object p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->BASELINE:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p3

    if-eqz p3, :cond_214

    invoke-virtual {p3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    :cond_214
    sget-object p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p3

    invoke-virtual {p3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getTarget()Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v1

    if-eq v1, p2, :cond_223

    invoke-virtual {p3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    :cond_223
    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getOpposite()Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    sget-object p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER_Y:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p3

    invoke-virtual {p3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result v1

    if-eqz v1, :cond_23d

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    invoke-virtual {p3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    :cond_23d
    :goto_23d
    invoke-virtual {v0, p2, p4}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)Z

    :cond_240
    :goto_240
    return-void
.end method

.method public connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)V
    .registers 5

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getOwner()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v0

    if-ne v0, p0, :cond_15

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getType()Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    move-result-object p1

    invoke-virtual {p2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getOwner()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v0

    invoke-virtual {p2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getType()Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    move-result-object p2

    invoke-virtual {p0, p1, v0, p2, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;I)V

    :cond_15
    return-void
.end method

.method public connectCircularConstraint(Landroidx/constraintlayout/core/widgets/ConstraintWidget;FI)V
    .registers 10

    sget-object v1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    sget-object v3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    const/4 v5, 0x0

    move-object v0, p0

    move-object v2, p1

    move v4, p3

    invoke-virtual/range {v0 .. v5}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->immediateConnect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;II)V

    iput p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCircleConstraintAngle:F

    return-void
.end method

.method public copy(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Ljava/util/HashMap;)V
    .registers 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/constraintlayout/core/widgets/ConstraintWidget;",
            "Ljava/util/HashMap<",
            "Landroidx/constraintlayout/core/widgets/ConstraintWidget;",
            "Landroidx/constraintlayout/core/widgets/ConstraintWidget;",
            ">;)V"
        }
    .end annotation

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalResolution:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalResolution:I

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalResolution:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalResolution:I

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultWidth:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultWidth:I

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultHeight:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultHeight:I

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedMatchConstraintDefault:[I

    iget-object v1, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedMatchConstraintDefault:[I

    const/4 v2, 0x0

    aget v3, v1, v2

    aput v3, v0, v2

    const/4 v3, 0x1

    aget v1, v1, v3

    aput v1, v0, v3

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinWidth:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinWidth:I

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxWidth:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxWidth:I

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinHeight:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinHeight:I

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxHeight:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxHeight:I

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintPercentHeight:F

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintPercentHeight:F

    iget-boolean v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mIsWidthWrapContent:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mIsWidthWrapContent:Z

    iget-boolean v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mIsHeightWrapContent:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mIsHeightWrapContent:Z

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatio:F

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatio:F

    iget-object v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMaxDimension:[I

    array-length v1, v0

    invoke-static {v0, v1}, Ljava/util/Arrays;->copyOf([II)[I

    move-result-object v0

    iput-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMaxDimension:[I

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCircleConstraintAngle:F

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCircleConstraintAngle:F

    iget-boolean v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->hasBaseline:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->hasBaseline:Z

    iget-boolean v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->inPlaceholder:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->inPlaceholder:Z

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenterX:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenterY:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenter:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    const/4 v1, 0x2

    invoke-static {v0, v1}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    iput-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    const/4 v1, 0x0

    if-nez v0, :cond_91

    move-object v0, v1

    goto :goto_99

    :cond_91
    iget-object v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {p2, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    :goto_99
    iput-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatio:F

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatio:F

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatioSide:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatioSide:I

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRelX:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRelX:I

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRelY:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRelY:I

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mOffsetX:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mOffsetX:I

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mOffsetY:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mOffsetY:I

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaselineDistance:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaselineDistance:I

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinWidth:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinWidth:I

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinHeight:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinHeight:I

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalBiasPercent:F

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalBiasPercent:F

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalBiasPercent:F

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalBiasPercent:F

    iget-object v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCompanionWidget:Ljava/lang/Object;

    iput-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCompanionWidget:Ljava/lang/Object;

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mContainerItemSkip:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mContainerItemSkip:I

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    iget-boolean v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mAnimated:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mAnimated:Z

    iget-object v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDebugName:Ljava/lang/String;

    iput-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDebugName:Ljava/lang/String;

    iget-object v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mType:Ljava/lang/String;

    iput-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mType:Ljava/lang/String;

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDistToTop:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDistToTop:I

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDistToLeft:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDistToLeft:I

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDistToRight:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDistToRight:I

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDistToBottom:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDistToBottom:I

    iget-boolean v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeftHasCentered:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeftHasCentered:Z

    iget-boolean v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRightHasCentered:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRightHasCentered:Z

    iget-boolean v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTopHasCentered:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTopHasCentered:Z

    iget-boolean v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottomHasCentered:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottomHasCentered:Z

    iget-boolean v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalWrapVisited:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalWrapVisited:Z

    iget-boolean v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalWrapVisited:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalWrapVisited:Z

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalChainStyle:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalChainStyle:I

    iget v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalChainStyle:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalChainStyle:I

    iget-boolean v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalChainFixedPosition:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalChainFixedPosition:Z

    iget-boolean v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalChainFixedPosition:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalChainFixedPosition:Z

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWeight:[F

    iget-object v4, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWeight:[F

    aget v5, v4, v2

    aput v5, v0, v2

    aget v4, v4, v3

    aput v4, v0, v3

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListNextMatchConstraintsWidget:[Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v4, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListNextMatchConstraintsWidget:[Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    aget-object v5, v4, v2

    aput-object v5, v0, v2

    aget-object v4, v4, v3

    aput-object v4, v0, v3

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mNextChainWidget:[Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v4, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mNextChainWidget:[Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    aget-object v5, v4, v2

    aput-object v5, v0, v2

    aget-object v2, v4, v3

    aput-object v2, v0, v3

    iget-object v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalNextWidget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    if-nez v0, :cond_151

    move-object v0, v1

    goto :goto_157

    :cond_151
    invoke-virtual {p2, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    :goto_157
    iput-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalNextWidget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalNextWidget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    if-nez p1, :cond_15e

    goto :goto_165

    :cond_15e
    invoke-virtual {p2, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    move-object v1, p1

    check-cast v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    :goto_165
    iput-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalNextWidget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    return-void
.end method

.method public createObjectVariables(Landroidx/constraintlayout/core/LinearSystem;)V
    .registers 3

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaselineDistance:I

    if-lez v0, :cond_1d

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    :cond_1d
    return-void
.end method

.method public ensureMeasureRequested()V
    .registers 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMeasureRequested:Z

    return-void
.end method

.method public ensureWidgetRuns()V
    .registers 2

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    if-nez v0, :cond_b

    new-instance v0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    invoke-direct {v0, p0}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;)V

    iput-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    :cond_b
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    if-nez v0, :cond_16

    new-instance v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    invoke-direct {v0, p0}, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;)V

    iput-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    :cond_16
    return-void
.end method

.method public getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;
    .registers 4

    sget-object v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget$1;->$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type:[I

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_30

    new-instance v0, Ljava/lang/AssertionError;

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->name()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v0

    :pswitch_15
    const/4 p1, 0x0

    return-object p1

    :pswitch_17
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenterY:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    return-object p1

    :pswitch_1a
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenterX:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    return-object p1

    :pswitch_1d
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenter:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    return-object p1

    :pswitch_20
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    return-object p1

    :pswitch_23
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    return-object p1

    :pswitch_26
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    return-object p1

    :pswitch_29
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    return-object p1

    :pswitch_2c
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    return-object p1

    nop

    :pswitch_data_30
    .packed-switch 0x1
        :pswitch_2c
        :pswitch_29
        :pswitch_26
        :pswitch_23
        :pswitch_20
        :pswitch_1d
        :pswitch_1a
        :pswitch_17
        :pswitch_15
    .end packed-switch
.end method

.method public getAnchors()Ljava/util/ArrayList;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList<",
            "Landroidx/constraintlayout/core/widgets/ConstraintAnchor;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mAnchors:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getBaselineDistance()I
    .registers 2

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaselineDistance:I

    return v0
.end method

.method public getBiasPercent(I)F
    .registers 3

    if-nez p1, :cond_5

    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalBiasPercent:F

    return p1

    :cond_5
    const/4 v0, 0x1

    if-ne p1, v0, :cond_b

    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalBiasPercent:F

    return p1

    :cond_b
    const/high16 p1, -0x40800000    # -1.0f

    return p1
.end method

.method public getBottom()I
    .registers 3

    invoke-virtual {p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getY()I

    move-result v0

    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    add-int/2addr v0, v1

    return v0
.end method

.method public getCompanionWidget()Ljava/lang/Object;
    .registers 2

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCompanionWidget:Ljava/lang/Object;

    return-object v0
.end method

.method public getContainerItemSkip()I
    .registers 2

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mContainerItemSkip:I

    return v0
.end method

.method public getDebugName()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDebugName:Ljava/lang/String;

    return-object v0
.end method

.method public getDimensionBehaviour(I)Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;
    .registers 3

    if-nez p1, :cond_7

    invoke-virtual {p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHorizontalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object p1

    return-object p1

    :cond_7
    const/4 v0, 0x1

    if-ne p1, v0, :cond_f

    invoke-virtual {p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getVerticalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object p1

    return-object p1

    :cond_f
    const/4 p1, 0x0

    return-object p1
.end method

.method public getDimensionRatio()F
    .registers 2

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatio:F

    return v0
.end method

.method public getDimensionRatioSide()I
    .registers 2

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatioSide:I

    return v0
.end method

.method public getHasBaseline()Z
    .registers 2

    iget-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->hasBaseline:Z

    return v0
.end method

.method public getHeight()I
    .registers 3

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    const/16 v1, 0x8

    if-ne v0, v1, :cond_8

    const/4 v0, 0x0

    return v0

    :cond_8
    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    return v0
.end method

.method public getHorizontalBiasPercent()F
    .registers 2

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalBiasPercent:F

    return v0
.end method

.method public getHorizontalChainControlWidget()Landroidx/constraintlayout/core/widgets/ConstraintWidget;
    .registers 6

    invoke-virtual {p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isInHorizontalChain()Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_46

    move-object v2, p0

    move-object v0, v1

    :goto_9
    if-nez v0, :cond_45

    if-eqz v2, :cond_45

    sget-object v3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->LEFT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {v2, v3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v3

    if-nez v3, :cond_17

    move-object v3, v1

    goto :goto_1b

    :cond_17
    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getTarget()Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v3

    :goto_1b
    if-nez v3, :cond_1f

    move-object v3, v1

    goto :goto_23

    :cond_1f
    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getOwner()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v3

    :goto_23
    invoke-virtual {p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getParent()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v4

    if-ne v3, v4, :cond_2b

    move-object v1, v2

    goto :goto_46

    :cond_2b
    if-nez v3, :cond_2f

    move-object v4, v1

    goto :goto_39

    :cond_2f
    sget-object v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->RIGHT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {v3, v4}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v4

    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getTarget()Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v4

    :goto_39
    if-eqz v4, :cond_43

    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getOwner()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v4

    if-eq v4, v2, :cond_43

    move-object v0, v2

    goto :goto_9

    :cond_43
    move-object v2, v3

    goto :goto_9

    :cond_45
    move-object v1, v0

    :cond_46
    :goto_46
    return-object v1
.end method

.method public getHorizontalChainStyle()I
    .registers 2

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalChainStyle:I

    return v0
.end method

.method public getHorizontalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;
    .registers 3

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    return-object v0
.end method

.method public getHorizontalMargin()I
    .registers 3

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    const/4 v1, 0x0

    if-eqz v0, :cond_8

    iget v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mMargin:I

    add-int/2addr v1, v0

    :cond_8
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz v0, :cond_f

    iget v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mMargin:I

    add-int/2addr v1, v0

    :cond_f
    return v1
.end method

.method public getLastHorizontalMeasureSpec()I
    .registers 2

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLastHorizontalMeasureSpec:I

    return v0
.end method

.method public getLastVerticalMeasureSpec()I
    .registers 2

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLastVerticalMeasureSpec:I

    return v0
.end method

.method public getLeft()I
    .registers 2

    invoke-virtual {p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getX()I

    move-result v0

    return v0
.end method

.method public getLength(I)I
    .registers 3

    if-nez p1, :cond_7

    invoke-virtual {p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getWidth()I

    move-result p1

    return p1

    :cond_7
    const/4 v0, 0x1

    if-ne p1, v0, :cond_f

    invoke-virtual {p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHeight()I

    move-result p1

    return p1

    :cond_f
    const/4 p1, 0x0

    return p1
.end method

.method public getMaxHeight()I
    .registers 3

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMaxDimension:[I

    const/4 v1, 0x1

    aget v0, v0, v1

    return v0
.end method

.method public getMaxWidth()I
    .registers 3

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMaxDimension:[I

    const/4 v1, 0x0

    aget v0, v0, v1

    return v0
.end method

.method public getMinHeight()I
    .registers 2

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinHeight:I

    return v0
.end method

.method public getMinWidth()I
    .registers 2

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinWidth:I

    return v0
.end method

.method public getNextChainMember(I)Landroidx/constraintlayout/core/widgets/ConstraintWidget;
    .registers 3

    if-nez p1, :cond_17

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz p1, :cond_2f

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-ne p1, v0, :cond_2f

    iget-object p1, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    return-object p1

    :cond_17
    const/4 v0, 0x1

    if-ne p1, v0, :cond_2f

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz p1, :cond_2f

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-ne p1, v0, :cond_2f

    iget-object p1, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    return-object p1

    :cond_2f
    const/4 p1, 0x0

    return-object p1
.end method

.method public getOptimizerWrapHeight()I
    .registers 5

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    const/4 v2, 0x1

    aget-object v1, v1, v2

    sget-object v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v1, v3, :cond_25

    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultHeight:I

    if-ne v1, v2, :cond_16

    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinHeight:I

    invoke-static {v1, v0}, Ljava/lang/Math;->max(II)I

    move-result v0

    goto :goto_1e

    :cond_16
    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinHeight:I

    if-lez v0, :cond_1d

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    goto :goto_1e

    :cond_1d
    const/4 v0, 0x0

    :goto_1e
    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxHeight:I

    if-lez v1, :cond_25

    if-ge v1, v0, :cond_25

    move v0, v1

    :cond_25
    return v0
.end method

.method public getOptimizerWrapWidth()I
    .registers 5

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    const/4 v2, 0x0

    aget-object v1, v1, v2

    sget-object v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v1, v3, :cond_26

    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultWidth:I

    const/4 v3, 0x1

    if-ne v1, v3, :cond_17

    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinWidth:I

    invoke-static {v1, v0}, Ljava/lang/Math;->max(II)I

    move-result v0

    goto :goto_1f

    :cond_17
    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinWidth:I

    if-lez v0, :cond_1e

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    goto :goto_1f

    :cond_1e
    move v0, v2

    :goto_1f
    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxWidth:I

    if-lez v1, :cond_26

    if-ge v1, v0, :cond_26

    move v0, v1

    :cond_26
    return v0
.end method

.method public getParent()Landroidx/constraintlayout/core/widgets/ConstraintWidget;
    .registers 2

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    return-object v0
.end method

.method public getPreviousChainMember(I)Landroidx/constraintlayout/core/widgets/ConstraintWidget;
    .registers 3

    if-nez p1, :cond_17

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz p1, :cond_2f

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-ne p1, v0, :cond_2f

    iget-object p1, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    return-object p1

    :cond_17
    const/4 v0, 0x1

    if-ne p1, v0, :cond_2f

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz p1, :cond_2f

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-ne p1, v0, :cond_2f

    iget-object p1, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    return-object p1

    :cond_2f
    const/4 p1, 0x0

    return-object p1
.end method

.method getRelativePositioning(I)I
    .registers 3

    if-nez p1, :cond_5

    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRelX:I

    return p1

    :cond_5
    const/4 v0, 0x1

    if-ne p1, v0, :cond_b

    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRelY:I

    return p1

    :cond_b
    const/4 p1, 0x0

    return p1
.end method

.method public getRight()I
    .registers 3

    invoke-virtual {p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getX()I

    move-result v0

    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    add-int/2addr v0, v1

    return v0
.end method

.method protected getRootX()I
    .registers 3

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mOffsetX:I

    add-int/2addr v0, v1

    return v0
.end method

.method protected getRootY()I
    .registers 3

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mOffsetY:I

    add-int/2addr v0, v1

    return v0
.end method

.method public getRun(I)Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;
    .registers 3

    if-nez p1, :cond_5

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    return-object p1

    :cond_5
    const/4 v0, 0x1

    if-ne p1, v0, :cond_b

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    return-object p1

    :cond_b
    const/4 p1, 0x0

    return-object p1
.end method

.method public getSceneString(Ljava/lang/StringBuilder;)V
    .registers 14

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "  "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->stringId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ":{\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "    actualWidth:"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v0, "\n"

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "    actualHeight:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "    actualLeft:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "    actualTop:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v0, "left"

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-direct {p0, p1, v0, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getSceneString(Ljava/lang/StringBuilder;Ljava/lang/String;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V

    const-string v0, "top"

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-direct {p0, p1, v0, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getSceneString(Ljava/lang/StringBuilder;Ljava/lang/String;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V

    const-string v0, "right"

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-direct {p0, p1, v0, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getSceneString(Ljava/lang/StringBuilder;Ljava/lang/String;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V

    const-string v0, "bottom"

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-direct {p0, p1, v0, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getSceneString(Ljava/lang/StringBuilder;Ljava/lang/String;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V

    const-string v0, "baseline"

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-direct {p0, p1, v0, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getSceneString(Ljava/lang/StringBuilder;Ljava/lang/String;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V

    const-string v0, "centerX"

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenterX:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-direct {p0, p1, v0, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getSceneString(Ljava/lang/StringBuilder;Ljava/lang/String;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V

    const-string v0, "centerY"

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenterY:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-direct {p0, p1, v0, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getSceneString(Ljava/lang/StringBuilder;Ljava/lang/String;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V

    const-string v2, "    width"

    iget v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    iget v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinWidth:I

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMaxDimension:[I

    const/4 v11, 0x0

    aget v5, v0, v11

    iget v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidthOverride:I

    iget v7, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinWidth:I

    iget v8, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultWidth:I

    iget v9, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintPercentWidth:F

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWeight:[F

    aget v10, v0, v11

    move-object v0, p0

    move-object v1, p1

    invoke-direct/range {v0 .. v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getSceneString(Ljava/lang/StringBuilder;Ljava/lang/String;IIIIIIFF)V

    const-string v2, "    height"

    iget v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    iget v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinHeight:I

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMaxDimension:[I

    const/4 v1, 0x1

    aget v5, v0, v1

    iget v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeightOverride:I

    iget v7, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinHeight:I

    iget v8, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultHeight:I

    iget v9, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintPercentHeight:F

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWeight:[F

    aget v10, v0, v1

    move-object v0, p0

    move-object v1, p1

    invoke-direct/range {v0 .. v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getSceneString(Ljava/lang/StringBuilder;Ljava/lang/String;IIIIIIFF)V

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatio:F

    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatioSide:I

    const-string v2, "    dimensionRatio"

    invoke-direct {p0, p1, v2, v0, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeDimensionRatio(Ljava/lang/StringBuilder;Ljava/lang/String;FI)V

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalBiasPercent:F

    sget v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->DEFAULT_BIAS:F

    const-string v2, "    horizontalBias"

    invoke-direct {p0, p1, v2, v0, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAttribute(Ljava/lang/StringBuilder;Ljava/lang/String;FF)V

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalBiasPercent:F

    sget v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->DEFAULT_BIAS:F

    const-string v2, "    verticalBias"

    invoke-direct {p0, p1, v2, v0, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAttribute(Ljava/lang/StringBuilder;Ljava/lang/String;FF)V

    const-string v0, "    horizontalChainStyle"

    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalChainStyle:I

    invoke-direct {p0, p1, v0, v1, v11}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAttribute(Ljava/lang/StringBuilder;Ljava/lang/String;II)V

    const-string v0, "    verticalChainStyle"

    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalChainStyle:I

    invoke-direct {p0, p1, v0, v1, v11}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAttribute(Ljava/lang/StringBuilder;Ljava/lang/String;II)V

    const-string v0, "  }"

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    return-void
.end method

.method public getTop()I
    .registers 2

    invoke-virtual {p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getY()I

    move-result v0

    return v0
.end method

.method public getType()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mType:Ljava/lang/String;

    return-object v0
.end method

.method public getVerticalBiasPercent()F
    .registers 2

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalBiasPercent:F

    return v0
.end method

.method public getVerticalChainControlWidget()Landroidx/constraintlayout/core/widgets/ConstraintWidget;
    .registers 6

    invoke-virtual {p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isInVerticalChain()Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_46

    move-object v2, p0

    move-object v0, v1

    :goto_9
    if-nez v0, :cond_45

    if-eqz v2, :cond_45

    sget-object v3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->TOP:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {v2, v3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v3

    if-nez v3, :cond_17

    move-object v3, v1

    goto :goto_1b

    :cond_17
    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getTarget()Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v3

    :goto_1b
    if-nez v3, :cond_1f

    move-object v3, v1

    goto :goto_23

    :cond_1f
    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getOwner()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v3

    :goto_23
    invoke-virtual {p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getParent()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v4

    if-ne v3, v4, :cond_2b

    move-object v1, v2

    goto :goto_46

    :cond_2b
    if-nez v3, :cond_2f

    move-object v4, v1

    goto :goto_39

    :cond_2f
    sget-object v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->BOTTOM:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {v3, v4}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v4

    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getTarget()Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v4

    :goto_39
    if-eqz v4, :cond_43

    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getOwner()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v4

    if-eq v4, v2, :cond_43

    move-object v0, v2

    goto :goto_9

    :cond_43
    move-object v2, v3

    goto :goto_9

    :cond_45
    move-object v1, v0

    :cond_46
    :goto_46
    return-object v1
.end method

.method public getVerticalChainStyle()I
    .registers 2

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalChainStyle:I

    return v0
.end method

.method public getVerticalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;
    .registers 3

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    const/4 v1, 0x1

    aget-object v0, v0, v1

    return-object v0
.end method

.method public getVerticalMargin()I
    .registers 3

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    const/4 v1, 0x0

    if-eqz v0, :cond_a

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mMargin:I

    add-int/2addr v1, v0

    :cond_a
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz v0, :cond_13

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mMargin:I

    add-int/2addr v1, v0

    :cond_13
    return v1
.end method

.method public getVisibility()I
    .registers 2

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    return v0
.end method

.method public getWidth()I
    .registers 3

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    const/16 v1, 0x8

    if-ne v0, v1, :cond_8

    const/4 v0, 0x0

    return v0

    :cond_8
    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    return v0
.end method

.method public getWrapBehaviorInParent()I
    .registers 2

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWrapBehaviorInParent:I

    return v0
.end method

.method public getX()I
    .registers 3

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    if-eqz v0, :cond_10

    instance-of v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    if-eqz v1, :cond_10

    check-cast v0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mPaddingLeft:I

    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    add-int/2addr v0, v1

    return v0

    :cond_10
    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    return v0
.end method

.method public getY()I
    .registers 3

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    if-eqz v0, :cond_10

    instance-of v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    if-eqz v1, :cond_10

    check-cast v0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mPaddingTop:I

    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    add-int/2addr v0, v1

    return v0

    :cond_10
    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    return v0
.end method

.method public hasBaseline()Z
    .registers 2

    iget-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->hasBaseline:Z

    return v0
.end method

.method public hasDanglingDimension(I)Z
    .registers 6

    const/4 v0, 0x2

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-nez p1, :cond_1d

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz p1, :cond_d

    move p1, v1

    goto :goto_e

    :cond_d
    move p1, v2

    :goto_e
    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz v3, :cond_16

    move v3, v1

    goto :goto_17

    :cond_16
    move v3, v2

    :goto_17
    add-int/2addr p1, v3

    if-ge p1, v0, :cond_1b

    goto :goto_1c

    :cond_1b
    move v1, v2

    :goto_1c
    return v1

    :cond_1d
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz p1, :cond_25

    move p1, v1

    goto :goto_26

    :cond_25
    move p1, v2

    :goto_26
    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz v3, :cond_2e

    move v3, v1

    goto :goto_2f

    :cond_2e
    move v3, v2

    :goto_2f
    add-int/2addr p1, v3

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz v3, :cond_38

    move v3, v1

    goto :goto_39

    :cond_38
    move v3, v2

    :goto_39
    add-int/2addr p1, v3

    if-ge p1, v0, :cond_3d

    goto :goto_3e

    :cond_3d
    move v1, v2

    :goto_3e
    return v1
.end method

.method public hasDependencies()Z
    .registers 5

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mAnchors:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/4 v1, 0x0

    move v2, v1

    :goto_8
    if-ge v2, v0, :cond_1d

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mAnchors:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->hasDependents()Z

    move-result v3

    if-eqz v3, :cond_1a

    const/4 v0, 0x1

    return v0

    :cond_1a
    add-int/lit8 v2, v2, 0x1

    goto :goto_8

    :cond_1d
    return v1
.end method

.method public hasDimensionOverride()Z
    .registers 3

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidthOverride:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_c

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeightOverride:I

    if-eq v0, v1, :cond_a

    goto :goto_c

    :cond_a
    const/4 v0, 0x0

    goto :goto_d

    :cond_c
    :goto_c
    const/4 v0, 0x1

    :goto_d
    return v0
.end method

.method public hasResolvedTargets(II)Z
    .registers 7

    const/4 v0, 0x1

    const/4 v1, 0x0

    if-nez p1, :cond_48

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz p1, :cond_8c

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->hasFinalValue()Z

    move-result p1

    if-eqz p1, :cond_8c

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz p1, :cond_8c

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->hasFinalValue()Z

    move-result p1

    if-eqz p1, :cond_8c

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getFinalValue()I

    move-result p1

    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v2

    sub-int/2addr p1, v2

    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getFinalValue()I

    move-result v2

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v3

    add-int/2addr v2, v3

    sub-int/2addr p1, v2

    if-lt p1, p2, :cond_46

    goto :goto_47

    :cond_46
    move v0, v1

    :goto_47
    return v0

    :cond_48
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz p1, :cond_8c

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->hasFinalValue()Z

    move-result p1

    if-eqz p1, :cond_8c

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz p1, :cond_8c

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->hasFinalValue()Z

    move-result p1

    if-eqz p1, :cond_8c

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getFinalValue()I

    move-result p1

    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v2

    sub-int/2addr p1, v2

    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getFinalValue()I

    move-result v2

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v3

    add-int/2addr v2, v3

    sub-int/2addr p1, v2

    if-lt p1, p2, :cond_8a

    goto :goto_8b

    :cond_8a
    move v0, v1

    :goto_8b
    return v0

    :cond_8c
    return v1
.end method

.method public immediateConnect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;II)V
    .registers 6

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    invoke-virtual {p2, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p2

    const/4 p3, 0x1

    invoke-virtual {p1, p2, p4, p5, p3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;IIZ)Z

    return-void
.end method

.method public isAnimated()Z
    .registers 2

    iget-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mAnimated:Z

    return v0
.end method

.method public isHeightWrapContent()Z
    .registers 2

    iget-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mIsHeightWrapContent:Z

    return v0
.end method

.method public isHorizontalSolvingPassDone()Z
    .registers 2

    iget-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalSolvingPass:Z

    return v0
.end method

.method public isInBarrier(I)Z
    .registers 3

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mIsInBarrier:[Z

    aget-boolean p1, v0, p1

    return p1
.end method

.method public isInHorizontalChain()Z
    .registers 3

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz v0, :cond_10

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eq v0, v1, :cond_20

    :cond_10
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz v0, :cond_22

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-ne v0, v1, :cond_22

    :cond_20
    const/4 v0, 0x1

    return v0

    :cond_22
    const/4 v0, 0x0

    return v0
.end method

.method public isInPlaceholder()Z
    .registers 2

    iget-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->inPlaceholder:Z

    return v0
.end method

.method public isInVerticalChain()Z
    .registers 3

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz v0, :cond_10

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eq v0, v1, :cond_20

    :cond_10
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz v0, :cond_22

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-ne v0, v1, :cond_22

    :cond_20
    const/4 v0, 0x1

    return v0

    :cond_22
    const/4 v0, 0x0

    return v0
.end method

.method public isInVirtualLayout()Z
    .registers 2

    iget-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mInVirtualLayout:Z

    return v0
.end method

.method public isMeasureRequested()Z
    .registers 3

    iget-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMeasureRequested:Z

    if-eqz v0, :cond_c

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    const/16 v1, 0x8

    if-eq v0, v1, :cond_c

    const/4 v0, 0x1

    goto :goto_d

    :cond_c
    const/4 v0, 0x0

    :goto_d
    return v0
.end method

.method public isResolvedHorizontally()Z
    .registers 2

    iget-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedHorizontal:Z

    if-nez v0, :cond_17

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->hasFinalValue()Z

    move-result v0

    if-eqz v0, :cond_15

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->hasFinalValue()Z

    move-result v0

    if-eqz v0, :cond_15

    goto :goto_17

    :cond_15
    const/4 v0, 0x0

    goto :goto_18

    :cond_17
    :goto_17
    const/4 v0, 0x1

    :goto_18
    return v0
.end method

.method public isResolvedVertically()Z
    .registers 2

    iget-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedVertical:Z

    if-nez v0, :cond_17

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->hasFinalValue()Z

    move-result v0

    if-eqz v0, :cond_15

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->hasFinalValue()Z

    move-result v0

    if-eqz v0, :cond_15

    goto :goto_17

    :cond_15
    const/4 v0, 0x0

    goto :goto_18

    :cond_17
    :goto_17
    const/4 v0, 0x1

    :goto_18
    return v0
.end method

.method public isRoot()Z
    .registers 2

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    if-nez v0, :cond_6

    const/4 v0, 0x1

    goto :goto_7

    :cond_6
    const/4 v0, 0x0

    :goto_7
    return v0
.end method

.method public isSpreadHeight()Z
    .registers 4

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultHeight:I

    if-nez v0, :cond_1d

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatio:F

    const/4 v1, 0x0

    cmpl-float v0, v0, v1

    if-nez v0, :cond_1d

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinHeight:I

    if-nez v0, :cond_1d

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxHeight:I

    if-nez v0, :cond_1d

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    const/4 v1, 0x1

    aget-object v0, v0, v1

    sget-object v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v0, v2, :cond_1d

    goto :goto_1e

    :cond_1d
    const/4 v1, 0x0

    :goto_1e
    return v1
.end method

.method public isSpreadWidth()Z
    .registers 4

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultWidth:I

    const/4 v1, 0x0

    if-nez v0, :cond_1d

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatio:F

    const/4 v2, 0x0

    cmpl-float v0, v0, v2

    if-nez v0, :cond_1d

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinWidth:I

    if-nez v0, :cond_1d

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxWidth:I

    if-nez v0, :cond_1d

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    aget-object v0, v0, v1

    sget-object v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v0, v2, :cond_1d

    const/4 v1, 0x1

    :cond_1d
    return v1
.end method

.method public isVerticalSolvingPassDone()Z
    .registers 2

    iget-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalSolvingPass:Z

    return v0
.end method

.method public isWidthWrapContent()Z
    .registers 2

    iget-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mIsWidthWrapContent:Z

    return v0
.end method

.method public markHorizontalSolvingPassDone()V
    .registers 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalSolvingPass:Z

    return-void
.end method

.method public markVerticalSolvingPassDone()V
    .registers 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalSolvingPass:Z

    return-void
.end method

.method public oppositeDimensionDependsOn(I)Z
    .registers 6

    const/4 v0, 0x1

    const/4 v1, 0x0

    if-nez p1, :cond_6

    move v2, v0

    goto :goto_7

    :cond_6
    move v2, v1

    :goto_7
    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    aget-object p1, v3, p1

    aget-object v2, v3, v2

    sget-object v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne p1, v3, :cond_16

    sget-object p1, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v2, p1, :cond_16

    goto :goto_17

    :cond_16
    move v0, v1

    :goto_17
    return v0
.end method

.method public oppositeDimensionsTied()Z
    .registers 5

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    sget-object v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v0, v2, :cond_13

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    const/4 v2, 0x1

    aget-object v0, v0, v2

    sget-object v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v0, v3, :cond_13

    move v1, v2

    :cond_13
    return v1
.end method

.method public reset()V
    .registers 7

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenterX:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenterY:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenter:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    const/4 v1, 0x0

    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCircleConstraintAngle:F

    const/4 v2, 0x0

    iput v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    iput v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatio:F

    const/4 v1, -0x1

    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatioSide:I

    iput v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    iput v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    iput v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mOffsetX:I

    iput v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mOffsetY:I

    iput v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaselineDistance:I

    iput v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinWidth:I

    iput v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinHeight:I

    sget v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->DEFAULT_BIAS:F

    iput v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalBiasPercent:F

    iput v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalBiasPercent:F

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    sget-object v4, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->FIXED:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    aput-object v4, v3, v2

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    sget-object v4, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->FIXED:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    const/4 v5, 0x1

    aput-object v4, v3, v5

    iput-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCompanionWidget:Ljava/lang/Object;

    iput v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mContainerItemSkip:I

    iput v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    iput-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mType:Ljava/lang/String;

    iput-boolean v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalWrapVisited:Z

    iput-boolean v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalWrapVisited:Z

    iput v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalChainStyle:I

    iput v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalChainStyle:I

    iput-boolean v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalChainFixedPosition:Z

    iput-boolean v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalChainFixedPosition:Z

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWeight:[F

    const/high16 v3, -0x40800000    # -1.0f

    aput v3, v0, v2

    aput v3, v0, v5

    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalResolution:I

    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalResolution:I

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMaxDimension:[I

    const v3, 0x7fffffff

    aput v3, v0, v2

    aput v3, v0, v5

    iput v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultWidth:I

    iput v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultHeight:I

    const/high16 v0, 0x3f800000    # 1.0f

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintPercentWidth:F

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintPercentHeight:F

    iput v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxWidth:I

    iput v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxHeight:I

    iput v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinWidth:I

    iput v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinHeight:I

    iput-boolean v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedHasRatio:Z

    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatio:F

    iput-boolean v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mGroupsToSolver:Z

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isTerminalWidget:[Z

    aput-boolean v5, v0, v2

    aput-boolean v5, v0, v5

    iput-boolean v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mInVirtualLayout:Z

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mIsInBarrier:[Z

    aput-boolean v2, v0, v2

    aput-boolean v2, v0, v5

    iput-boolean v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMeasureRequested:Z

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedMatchConstraintDefault:[I

    aput v2, v0, v2

    aput v2, v0, v5

    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidthOverride:I

    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeightOverride:I

    return-void
.end method

.method public resetAllConstraints()V
    .registers 2

    invoke-virtual {p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resetAnchors()V

    sget v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->DEFAULT_BIAS:F

    invoke-virtual {p0, v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setVerticalBiasPercent(F)V

    sget v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->DEFAULT_BIAS:F

    invoke-virtual {p0, v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setHorizontalBiasPercent(F)V

    return-void
.end method

.method public resetAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V
    .registers 10

    invoke-virtual {p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getParent()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v0

    if-eqz v0, :cond_1b

    invoke-virtual {p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getParent()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v0

    instance-of v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    if-eqz v0, :cond_1b

    invoke-virtual {p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getParent()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->handlesInternalConstraints()Z

    move-result v0

    if-eqz v0, :cond_1b

    return-void

    :cond_1b
    sget-object v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->LEFT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v0

    sget-object v1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->RIGHT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v1

    sget-object v2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->TOP:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, v2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v2

    sget-object v3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->BOTTOM:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, v3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v3

    sget-object v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, v4}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v4

    sget-object v5, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER_X:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, v5}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v5

    sget-object v6, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER_Y:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {p0, v6}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v6

    const/high16 v7, 0x3f000000    # 0.5f

    if-ne p1, v4, :cond_87

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result v4

    if-eqz v4, :cond_65

    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result v4

    if-eqz v4, :cond_65

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getTarget()Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v4

    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getTarget()Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v5

    if-ne v4, v5, :cond_65

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    :cond_65
    invoke-virtual {v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_81

    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_81

    invoke-virtual {v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getTarget()Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v0

    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getTarget()Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v1

    if-ne v0, v1, :cond_81

    invoke-virtual {v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    :cond_81
    iput v7, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalBiasPercent:F

    iput v7, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalBiasPercent:F

    goto/16 :goto_109

    :cond_87
    if-ne p1, v5, :cond_b0

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result v2

    if-eqz v2, :cond_ad

    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result v2

    if-eqz v2, :cond_ad

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getTarget()Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v2

    invoke-virtual {v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getOwner()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v2

    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getTarget()Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v3

    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getOwner()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v3

    if-ne v2, v3, :cond_ad

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    :cond_ad
    iput v7, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalBiasPercent:F

    goto :goto_109

    :cond_b0
    if-ne p1, v6, :cond_d9

    invoke-virtual {v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_d6

    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_d6

    invoke-virtual {v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getTarget()Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getOwner()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v0

    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getTarget()Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v1

    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getOwner()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v1

    if-ne v0, v1, :cond_d6

    invoke-virtual {v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    :cond_d6
    iput v7, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalBiasPercent:F

    goto :goto_109

    :cond_d9
    if-eq p1, v0, :cond_f6

    if-ne p1, v1, :cond_de

    goto :goto_f6

    :cond_de
    if-eq p1, v2, :cond_e2

    if-ne p1, v3, :cond_109

    :cond_e2
    invoke-virtual {v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_109

    invoke-virtual {v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getTarget()Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v0

    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getTarget()Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v1

    if-ne v0, v1, :cond_109

    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    goto :goto_109

    :cond_f6
    :goto_f6
    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result v2

    if-eqz v2, :cond_109

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getTarget()Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v0

    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getTarget()Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v1

    if-ne v0, v1, :cond_109

    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    :cond_109
    :goto_109
    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    return-void
.end method

.method public resetAnchors()V
    .registers 4

    invoke-virtual {p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getParent()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v0

    if-eqz v0, :cond_17

    instance-of v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    if-eqz v0, :cond_17

    invoke-virtual {p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getParent()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->handlesInternalConstraints()Z

    move-result v0

    if-eqz v0, :cond_17

    return-void

    :cond_17
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mAnchors:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/4 v1, 0x0

    :goto_1e
    if-ge v1, v0, :cond_2e

    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mAnchors:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    add-int/lit8 v1, v1, 0x1

    goto :goto_1e

    :cond_2e
    return-void
.end method

.method public resetFinalResolution()V
    .registers 4

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedHorizontal:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedVertical:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalSolvingPass:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalSolvingPass:Z

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mAnchors:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    :goto_f
    if-ge v0, v1, :cond_1f

    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mAnchors:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->resetFinalResolution()V

    add-int/lit8 v0, v0, 0x1

    goto :goto_f

    :cond_1f
    return-void
.end method

.method public resetSolverVariables(Landroidx/constraintlayout/core/Cache;)V
    .registers 3

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->resetSolverVariable(Landroidx/constraintlayout/core/Cache;)V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->resetSolverVariable(Landroidx/constraintlayout/core/Cache;)V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->resetSolverVariable(Landroidx/constraintlayout/core/Cache;)V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->resetSolverVariable(Landroidx/constraintlayout/core/Cache;)V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->resetSolverVariable(Landroidx/constraintlayout/core/Cache;)V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenter:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->resetSolverVariable(Landroidx/constraintlayout/core/Cache;)V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenterX:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->resetSolverVariable(Landroidx/constraintlayout/core/Cache;)V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenterY:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->resetSolverVariable(Landroidx/constraintlayout/core/Cache;)V

    return-void
.end method

.method public resetSolvingPassFlag()V
    .registers 2

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalSolvingPass:Z

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalSolvingPass:Z

    return-void
.end method

.method public serialize(Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;
    .registers 13

    const-string v0, "{\n"

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v0, "left"

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-direct {p0, p1, v0, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAnchor(Ljava/lang/StringBuilder;Ljava/lang/String;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V

    const-string v0, "top"

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-direct {p0, p1, v0, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAnchor(Ljava/lang/StringBuilder;Ljava/lang/String;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V

    const-string v0, "right"

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-direct {p0, p1, v0, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAnchor(Ljava/lang/StringBuilder;Ljava/lang/String;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V

    const-string v0, "bottom"

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-direct {p0, p1, v0, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAnchor(Ljava/lang/StringBuilder;Ljava/lang/String;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V

    const-string v0, "baseline"

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-direct {p0, p1, v0, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAnchor(Ljava/lang/StringBuilder;Ljava/lang/String;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V

    const-string v0, "centerX"

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenterX:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-direct {p0, p1, v0, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAnchor(Ljava/lang/StringBuilder;Ljava/lang/String;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V

    const-string v0, "centerY"

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenterY:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-direct {p0, p1, v0, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAnchor(Ljava/lang/StringBuilder;Ljava/lang/String;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenter:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCircleConstraintAngle:F

    invoke-direct {p0, p1, v0, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeCircle(Ljava/lang/StringBuilder;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;F)V

    const-string v2, "width"

    iget v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    iget v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinWidth:I

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMaxDimension:[I

    const/4 v1, 0x0

    aget v5, v0, v1

    iget v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidthOverride:I

    iget v7, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinWidth:I

    iget v8, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultWidth:I

    iget v9, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintPercentWidth:F

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWeight:[F

    aget v10, v0, v1

    move-object v0, p0

    move-object v1, p1

    invoke-direct/range {v0 .. v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeSize(Ljava/lang/StringBuilder;Ljava/lang/String;IIIIIIFF)V

    const-string v2, "height"

    iget v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    iget v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinHeight:I

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMaxDimension:[I

    const/4 v1, 0x1

    aget v5, v0, v1

    iget v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeightOverride:I

    iget v7, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinHeight:I

    iget v8, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultHeight:I

    iget v9, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintPercentHeight:F

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWeight:[F

    aget v10, v0, v1

    move-object v0, p0

    move-object v1, p1

    invoke-direct/range {v0 .. v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeSize(Ljava/lang/StringBuilder;Ljava/lang/String;IIIIIIFF)V

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatio:F

    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatioSide:I

    const-string v2, "dimensionRatio"

    invoke-direct {p0, p1, v2, v0, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeDimensionRatio(Ljava/lang/StringBuilder;Ljava/lang/String;FI)V

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalBiasPercent:F

    sget v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->DEFAULT_BIAS:F

    const-string v2, "horizontalBias"

    invoke-direct {p0, p1, v2, v0, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAttribute(Ljava/lang/StringBuilder;Ljava/lang/String;FF)V

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalBiasPercent:F

    sget v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->DEFAULT_BIAS:F

    const-string v2, "verticalBias"

    invoke-direct {p0, p1, v2, v0, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAttribute(Ljava/lang/StringBuilder;Ljava/lang/String;FF)V

    const-string v0, "}\n"

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    return-object p1
.end method

.method public setAnimated(Z)V
    .registers 2

    iput-boolean p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mAnimated:Z

    return-void
.end method

.method public setBaselineDistance(I)V
    .registers 2

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaselineDistance:I

    if-lez p1, :cond_6

    const/4 p1, 0x1

    goto :goto_7

    :cond_6
    const/4 p1, 0x0

    :goto_7
    iput-boolean p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->hasBaseline:Z

    return-void
.end method

.method public setCompanionWidget(Ljava/lang/Object;)V
    .registers 2

    iput-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCompanionWidget:Ljava/lang/Object;

    return-void
.end method

.method public setContainerItemSkip(I)V
    .registers 2

    if-ltz p1, :cond_5

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mContainerItemSkip:I

    goto :goto_8

    :cond_5
    const/4 p1, 0x0

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mContainerItemSkip:I

    :goto_8
    return-void
.end method

.method public setDebugName(Ljava/lang/String;)V
    .registers 2

    iput-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDebugName:Ljava/lang/String;

    return-void
.end method

.method public setDebugSolverName(Landroidx/constraintlayout/core/LinearSystem;Ljava/lang/String;)V
    .registers 9

    iput-object p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDebugName:Ljava/lang/String;

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v0

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1, v1}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v1

    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1, v2}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v2

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1, v3}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ".left"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Landroidx/constraintlayout/core/SolverVariable;->setName(Ljava/lang/String;)V

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, ".top"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroidx/constraintlayout/core/SolverVariable;->setName(Ljava/lang/String;)V

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ".right"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Landroidx/constraintlayout/core/SolverVariable;->setName(Ljava/lang/String;)V

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ".bottom"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Landroidx/constraintlayout/core/SolverVariable;->setName(Ljava/lang/String;)V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object p1

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p2

    const-string v0, ".baseline"

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p2

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-virtual {p1, p2}, Landroidx/constraintlayout/core/SolverVariable;->setName(Ljava/lang/String;)V

    return-void
.end method

.method public setDimension(II)V
    .registers 4

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinWidth:I

    if-ge p1, v0, :cond_8

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    :cond_8
    iput p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinHeight:I

    if-ge p2, p1, :cond_10

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    :cond_10
    return-void
.end method

.method public setDimensionRatio(FI)V
    .registers 3

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatio:F

    iput p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatioSide:I

    return-void
.end method

.method public setDimensionRatio(Ljava/lang/String;)V
    .registers 10

    const/4 v0, 0x0

    if-eqz p1, :cond_90

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_b

    goto/16 :goto_90

    :cond_b
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    const/16 v2, 0x2c

    invoke-virtual {p1, v2}, Ljava/lang/String;->indexOf(I)I

    move-result v2

    const/4 v3, 0x0

    const/4 v4, 0x1

    const/4 v5, -0x1

    if-lez v2, :cond_39

    add-int/lit8 v6, v1, -0x1

    if-ge v2, v6, :cond_39

    invoke-virtual {p1, v3, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v6

    const-string v7, "W"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_2b

    goto :goto_36

    :cond_2b
    const-string v3, "H"

    invoke-virtual {v6, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_35

    move v3, v4

    goto :goto_36

    :cond_35
    move v3, v5

    :goto_36
    add-int/2addr v2, v4

    move v5, v3

    move v3, v2

    :cond_39
    const/16 v2, 0x3a

    invoke-virtual {p1, v2}, Ljava/lang/String;->indexOf(I)I

    move-result v2

    if-ltz v2, :cond_77

    sub-int/2addr v1, v4

    if-ge v2, v1, :cond_77

    invoke-virtual {p1, v3, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    add-int/2addr v2, v4

    invoke-virtual {p1, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_86

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_86

    :try_start_59
    invoke-static {v1}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v1

    invoke-static {p1}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result p1

    cmpl-float v2, v1, v0

    if-lez v2, :cond_86

    cmpl-float v2, p1, v0

    if-lez v2, :cond_86

    if-ne v5, v4, :cond_71

    div-float/2addr p1, v1

    invoke-static {p1}, Ljava/lang/Math;->abs(F)F

    move-result p1

    goto :goto_87

    :cond_71
    div-float/2addr v1, p1

    invoke-static {v1}, Ljava/lang/Math;->abs(F)F

    move-result p1
    :try_end_76
    .catch Ljava/lang/NumberFormatException; {:try_start_59 .. :try_end_76} :catch_86

    goto :goto_87

    :cond_77
    invoke-virtual {p1, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_86

    :try_start_81
    invoke-static {p1}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result p1
    :try_end_85
    .catch Ljava/lang/NumberFormatException; {:try_start_81 .. :try_end_85} :catch_86

    goto :goto_87

    :catch_86
    :cond_86
    move p1, v0

    :goto_87
    cmpl-float v0, p1, v0

    if-lez v0, :cond_8f

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatio:F

    iput v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatioSide:I

    :cond_8f
    return-void

    :cond_90
    :goto_90
    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatio:F

    return-void
.end method

.method public setFinalBaseline(I)V
    .registers 5

    iget-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->hasBaseline:Z

    if-nez v0, :cond_5

    return-void

    :cond_5
    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaselineDistance:I

    sub-int v0, p1, v0

    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    add-int/2addr v1, v0

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v2, v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->setFinalValue(I)V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->setFinalValue(I)V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->setFinalValue(I)V

    const/4 p1, 0x1

    iput-boolean p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedVertical:Z

    return-void
.end method

.method public setFinalFrame(IIIIII)V
    .registers 7

    invoke-virtual {p0, p1, p2, p3, p4}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setFrame(IIII)V

    invoke-virtual {p0, p5}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setBaselineDistance(I)V

    const/4 p1, 0x0

    const/4 p2, 0x1

    if-nez p6, :cond_f

    iput-boolean p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedHorizontal:Z

    iput-boolean p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedVertical:Z

    goto :goto_22

    :cond_f
    if-ne p6, p2, :cond_16

    iput-boolean p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedHorizontal:Z

    iput-boolean p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedVertical:Z

    goto :goto_22

    :cond_16
    const/4 p3, 0x2

    if-ne p6, p3, :cond_1e

    iput-boolean p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedHorizontal:Z

    iput-boolean p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedVertical:Z

    goto :goto_22

    :cond_1e
    iput-boolean p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedHorizontal:Z

    iput-boolean p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedVertical:Z

    :goto_22
    return-void
.end method

.method public setFinalHorizontal(II)V
    .registers 4

    iget-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedHorizontal:Z

    if-eqz v0, :cond_5

    return-void

    :cond_5
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->setFinalValue(I)V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, p2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->setFinalValue(I)V

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    sub-int/2addr p2, p1

    iput p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    const/4 p1, 0x1

    iput-boolean p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedHorizontal:Z

    return-void
.end method

.method public setFinalLeft(I)V
    .registers 3

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->setFinalValue(I)V

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    return-void
.end method

.method public setFinalTop(I)V
    .registers 3

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->setFinalValue(I)V

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    return-void
.end method

.method public setFinalVertical(II)V
    .registers 4

    iget-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedVertical:Z

    if-eqz v0, :cond_5

    return-void

    :cond_5
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->setFinalValue(I)V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, p2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->setFinalValue(I)V

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    sub-int/2addr p2, p1

    iput p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    iget-boolean p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->hasBaseline:Z

    if-eqz p2, :cond_20

    iget-object p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaselineDistance:I

    add-int/2addr p1, v0

    invoke-virtual {p2, p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->setFinalValue(I)V

    :cond_20
    const/4 p1, 0x1

    iput-boolean p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resolvedVertical:Z

    return-void
.end method

.method public setFrame(III)V
    .registers 5

    if-nez p3, :cond_6

    invoke-virtual {p0, p1, p2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setHorizontalDimension(II)V

    goto :goto_c

    :cond_6
    const/4 v0, 0x1

    if-ne p3, v0, :cond_c

    invoke-virtual {p0, p1, p2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setVerticalDimension(II)V

    :cond_c
    :goto_c
    return-void
.end method

.method public setFrame(IIII)V
    .registers 7

    sub-int/2addr p3, p1

    sub-int/2addr p4, p2

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    iput p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    const/16 p2, 0x8

    const/4 v0, 0x0

    if-ne p1, p2, :cond_12

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    return-void

    :cond_12
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    aget-object p1, p1, v0

    sget-object p2, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->FIXED:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne p1, p2, :cond_1f

    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    if-ge p3, p1, :cond_1f

    move p3, p1

    :cond_1f
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    const/4 p2, 0x1

    aget-object p1, p1, p2

    sget-object v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->FIXED:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne p1, v1, :cond_2d

    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    if-ge p4, p1, :cond_2d

    move p4, p1

    :cond_2d
    iput p3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    iput p4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinHeight:I

    if-ge p4, p1, :cond_37

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    :cond_37
    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinWidth:I

    if-ge p3, p1, :cond_3d

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    :cond_3d
    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxWidth:I

    if-lez p1, :cond_53

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    aget-object p1, p1, v0

    sget-object v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne p1, v0, :cond_53

    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxWidth:I

    invoke-static {p1, v0}, Ljava/lang/Math;->min(II)I

    move-result p1

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    :cond_53
    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxHeight:I

    if-lez p1, :cond_69

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    aget-object p1, p1, p2

    sget-object p2, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne p1, p2, :cond_69

    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    iget p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxHeight:I

    invoke-static {p1, p2}, Ljava/lang/Math;->min(II)I

    move-result p1

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    :cond_69
    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    if-eq p3, p1, :cond_6f

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidthOverride:I

    :cond_6f
    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    if-eq p4, p1, :cond_75

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeightOverride:I

    :cond_75
    return-void
.end method

.method public setGoneMargin(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;I)V
    .registers 4

    sget-object v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget$1;->$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type:[I

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->ordinal()I

    move-result p1

    aget p1, v0, p1

    const/4 v0, 0x1

    if-eq p1, v0, :cond_2c

    const/4 v0, 0x2

    if-eq p1, v0, :cond_27

    const/4 v0, 0x3

    if-eq p1, v0, :cond_22

    const/4 v0, 0x4

    if-eq p1, v0, :cond_1d

    const/4 v0, 0x5

    if-eq p1, v0, :cond_18

    goto :goto_30

    :cond_18
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iput p2, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mGoneMargin:I

    goto :goto_30

    :cond_1d
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iput p2, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mGoneMargin:I

    goto :goto_30

    :cond_22
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iput p2, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mGoneMargin:I

    goto :goto_30

    :cond_27
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iput p2, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mGoneMargin:I

    goto :goto_30

    :cond_2c
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iput p2, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mGoneMargin:I

    :goto_30
    return-void
.end method

.method public setHasBaseline(Z)V
    .registers 2

    iput-boolean p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->hasBaseline:Z

    return-void
.end method

.method public setHeight(I)V
    .registers 3

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinHeight:I

    if-ge p1, v0, :cond_8

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    :cond_8
    return-void
.end method

.method public setHeightWrapContent(Z)V
    .registers 2

    iput-boolean p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mIsHeightWrapContent:Z

    return-void
.end method

.method public setHorizontalBiasPercent(F)V
    .registers 2

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalBiasPercent:F

    return-void
.end method

.method public setHorizontalChainStyle(I)V
    .registers 2

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalChainStyle:I

    return-void
.end method

.method public setHorizontalDimension(II)V
    .registers 3

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    sub-int/2addr p2, p1

    iput p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinWidth:I

    if-ge p2, p1, :cond_b

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    :cond_b
    return-void
.end method

.method public setHorizontalDimensionBehaviour(Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;)V
    .registers 4

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    const/4 v1, 0x0

    aput-object p1, v0, v1

    return-void
.end method

.method public setHorizontalMatchStyle(IIIF)V
    .registers 5

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultWidth:I

    iput p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinWidth:I

    const p2, 0x7fffffff

    if-ne p3, p2, :cond_a

    const/4 p3, 0x0

    :cond_a
    iput p3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxWidth:I

    iput p4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintPercentWidth:F

    const/4 p2, 0x0

    cmpl-float p2, p4, p2

    if-lez p2, :cond_1e

    const/high16 p2, 0x3f800000    # 1.0f

    cmpg-float p2, p4, p2

    if-gez p2, :cond_1e

    if-nez p1, :cond_1e

    const/4 p1, 0x2

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultWidth:I

    :cond_1e
    return-void
.end method

.method public setHorizontalWeight(F)V
    .registers 4

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWeight:[F

    const/4 v1, 0x0

    aput p1, v0, v1

    return-void
.end method

.method protected setInBarrier(IZ)V
    .registers 4

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mIsInBarrier:[Z

    aput-boolean p2, v0, p1

    return-void
.end method

.method public setInPlaceholder(Z)V
    .registers 2

    iput-boolean p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->inPlaceholder:Z

    return-void
.end method

.method public setInVirtualLayout(Z)V
    .registers 2

    iput-boolean p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mInVirtualLayout:Z

    return-void
.end method

.method public setLastMeasureSpec(II)V
    .registers 3

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLastHorizontalMeasureSpec:I

    iput p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLastVerticalMeasureSpec:I

    const/4 p1, 0x0

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setMeasureRequested(Z)V

    return-void
.end method

.method public setLength(II)V
    .registers 4

    if-nez p2, :cond_6

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setWidth(I)V

    goto :goto_c

    :cond_6
    const/4 v0, 0x1

    if-ne p2, v0, :cond_c

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setHeight(I)V

    :cond_c
    :goto_c
    return-void
.end method

.method public setMaxHeight(I)V
    .registers 4

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMaxDimension:[I

    const/4 v1, 0x1

    aput p1, v0, v1

    return-void
.end method

.method public setMaxWidth(I)V
    .registers 4

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMaxDimension:[I

    const/4 v1, 0x0

    aput p1, v0, v1

    return-void
.end method

.method public setMeasureRequested(Z)V
    .registers 2

    iput-boolean p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMeasureRequested:Z

    return-void
.end method

.method public setMinHeight(I)V
    .registers 2

    if-gez p1, :cond_6

    const/4 p1, 0x0

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinHeight:I

    goto :goto_8

    :cond_6
    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinHeight:I

    :goto_8
    return-void
.end method

.method public setMinWidth(I)V
    .registers 2

    if-gez p1, :cond_6

    const/4 p1, 0x0

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinWidth:I

    goto :goto_8

    :cond_6
    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinWidth:I

    :goto_8
    return-void
.end method

.method public setOffset(II)V
    .registers 3

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mOffsetX:I

    iput p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mOffsetY:I

    return-void
.end method

.method public setOrigin(II)V
    .registers 3

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    iput p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    return-void
.end method

.method public setParent(Landroidx/constraintlayout/core/widgets/ConstraintWidget;)V
    .registers 2

    iput-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    return-void
.end method

.method setRelativePositioning(II)V
    .registers 4

    if-nez p2, :cond_5

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRelX:I

    goto :goto_a

    :cond_5
    const/4 v0, 0x1

    if-ne p2, v0, :cond_a

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRelY:I

    :cond_a
    :goto_a
    return-void
.end method

.method public setType(Ljava/lang/String;)V
    .registers 2

    iput-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mType:Ljava/lang/String;

    return-void
.end method

.method public setVerticalBiasPercent(F)V
    .registers 2

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalBiasPercent:F

    return-void
.end method

.method public setVerticalChainStyle(I)V
    .registers 2

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalChainStyle:I

    return-void
.end method

.method public setVerticalDimension(II)V
    .registers 3

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    sub-int/2addr p2, p1

    iput p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinHeight:I

    if-ge p2, p1, :cond_b

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    :cond_b
    return-void
.end method

.method public setVerticalDimensionBehaviour(Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;)V
    .registers 4

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    const/4 v1, 0x1

    aput-object p1, v0, v1

    return-void
.end method

.method public setVerticalMatchStyle(IIIF)V
    .registers 5

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultHeight:I

    iput p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinHeight:I

    const p2, 0x7fffffff

    if-ne p3, p2, :cond_a

    const/4 p3, 0x0

    :cond_a
    iput p3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxHeight:I

    iput p4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintPercentHeight:F

    const/4 p2, 0x0

    cmpl-float p2, p4, p2

    if-lez p2, :cond_1e

    const/high16 p2, 0x3f800000    # 1.0f

    cmpg-float p2, p4, p2

    if-gez p2, :cond_1e

    if-nez p1, :cond_1e

    const/4 p1, 0x2

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultHeight:I

    :cond_1e
    return-void
.end method

.method public setVerticalWeight(F)V
    .registers 4

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWeight:[F

    const/4 v1, 0x1

    aput p1, v0, v1

    return-void
.end method

.method public setVisibility(I)V
    .registers 2

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    return-void
.end method

.method public setWidth(I)V
    .registers 3

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinWidth:I

    if-ge p1, v0, :cond_8

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    :cond_8
    return-void
.end method

.method public setWidthWrapContent(Z)V
    .registers 2

    iput-boolean p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mIsWidthWrapContent:Z

    return-void
.end method

.method public setWrapBehaviorInParent(I)V
    .registers 3

    if-ltz p1, :cond_7

    const/4 v0, 0x3

    if-gt p1, v0, :cond_7

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWrapBehaviorInParent:I

    :cond_7
    return-void
.end method

.method public setX(I)V
    .registers 2

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    return-void
.end method

.method public setY(I)V
    .registers 2

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    return-void
.end method

.method public setupDimensionRatio(ZZZZ)V
    .registers 8

    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    const/high16 p2, 0x3f800000    # 1.0f

    const/4 v0, 0x0

    const/4 v1, 0x1

    const/4 v2, -0x1

    if-ne p1, v2, :cond_20

    if-eqz p3, :cond_10

    if-nez p4, :cond_10

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    goto :goto_20

    :cond_10
    if-nez p3, :cond_20

    if-eqz p4, :cond_20

    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatioSide:I

    if-ne p1, v2, :cond_20

    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatio:F

    div-float p1, p2, p1

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatio:F

    :cond_20
    :goto_20
    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    if-nez p1, :cond_37

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result p1

    if-eqz p1, :cond_34

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result p1

    if-nez p1, :cond_37

    :cond_34
    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    goto :goto_4d

    :cond_37
    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    if-ne p1, v1, :cond_4d

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result p1

    if-eqz p1, :cond_4b

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result p1

    if-nez p1, :cond_4d

    :cond_4b
    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    :cond_4d
    :goto_4d
    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    if-ne p1, v2, :cond_9c

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result p1

    if-eqz p1, :cond_71

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result p1

    if-eqz p1, :cond_71

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result p1

    if-eqz p1, :cond_71

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result p1

    if-nez p1, :cond_9c

    :cond_71
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result p1

    if-eqz p1, :cond_84

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result p1

    if-eqz p1, :cond_84

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    goto :goto_9c

    :cond_84
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result p1

    if-eqz p1, :cond_9c

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result p1

    if-eqz p1, :cond_9c

    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatio:F

    div-float p1, p2, p1

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatio:F

    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    :cond_9c
    :goto_9c
    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    if-ne p1, v2, :cond_b8

    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinWidth:I

    if-lez p1, :cond_ab

    iget p3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinHeight:I

    if-nez p3, :cond_ab

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    goto :goto_b8

    :cond_ab
    if-nez p1, :cond_b8

    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinHeight:I

    if-lez p1, :cond_b8

    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatio:F

    div-float/2addr p2, p1

    iput p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatio:F

    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    :cond_b8
    :goto_b8
    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 6

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mType:Ljava/lang/String;

    const-string v2, " "

    const-string v3, ""

    if-eqz v1, :cond_23

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v4, "type: "

    invoke-direct {v1, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mType:Ljava/lang/String;

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_24

    :cond_23
    move-object v1, v3

    :goto_24
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDebugName:Ljava/lang/String;

    if-eqz v1, :cond_41

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v3, "id: "

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDebugName:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    :cond_41
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ") - ("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " x "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public updateFromRuns(ZZ)V
    .registers 10

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->isResolved()Z

    move-result v0

    and-int/2addr p1, v0

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->isResolved()Z

    move-result v0

    and-int/2addr p2, v0

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v1, v1, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v1, v1, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v2, v2, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v3, v3, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    sub-int v4, v2, v0

    sub-int v5, v3, v1

    const/4 v6, 0x0

    if-ltz v4, :cond_44

    if-ltz v5, :cond_44

    const/high16 v4, -0x80000000

    if-eq v0, v4, :cond_44

    const v5, 0x7fffffff

    if-eq v0, v5, :cond_44

    if-eq v1, v4, :cond_44

    if-eq v1, v5, :cond_44

    if-eq v2, v4, :cond_44

    if-eq v2, v5, :cond_44

    if-eq v3, v4, :cond_44

    if-ne v3, v5, :cond_48

    :cond_44
    move v0, v6

    move v1, v0

    move v2, v1

    move v3, v2

    :cond_48
    sub-int/2addr v2, v0

    sub-int/2addr v3, v1

    if-eqz p1, :cond_4e

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    :cond_4e
    if-eqz p2, :cond_52

    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    :cond_52
    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    const/16 v1, 0x8

    if-ne v0, v1, :cond_5d

    iput v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    iput v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    return-void

    :cond_5d
    if-eqz p1, :cond_74

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    aget-object p1, p1, v6

    sget-object v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->FIXED:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne p1, v0, :cond_6c

    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    if-ge v2, p1, :cond_6c

    move v2, p1

    :cond_6c
    iput v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinWidth:I

    if-ge v2, p1, :cond_74

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    :cond_74
    if-eqz p2, :cond_8c

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    const/4 p2, 0x1

    aget-object p1, p1, p2

    sget-object p2, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->FIXED:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne p1, p2, :cond_84

    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    if-ge v3, p1, :cond_84

    move v3, p1

    :cond_84
    iput v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinHeight:I

    if-ge v3, p1, :cond_8c

    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    :cond_8c
    return-void
.end method

.method public updateFromSolver(Landroidx/constraintlayout/core/LinearSystem;Z)V
    .registers 7

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1, v0}, Landroidx/constraintlayout/core/LinearSystem;->getObjectVariableValue(Ljava/lang/Object;)I

    move-result v0

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1, v1}, Landroidx/constraintlayout/core/LinearSystem;->getObjectVariableValue(Ljava/lang/Object;)I

    move-result v1

    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1, v2}, Landroidx/constraintlayout/core/LinearSystem;->getObjectVariableValue(Ljava/lang/Object;)I

    move-result v2

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p1, v3}, Landroidx/constraintlayout/core/LinearSystem;->getObjectVariableValue(Ljava/lang/Object;)I

    move-result p1

    if-eqz p2, :cond_38

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    if-eqz v3, :cond_38

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-boolean v3, v3, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    if-eqz v3, :cond_38

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-boolean v3, v3, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    if-eqz v3, :cond_38

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v2, v2, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    :cond_38
    if-eqz p2, :cond_58

    iget-object p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    if-eqz p2, :cond_58

    iget-object p2, p2, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-boolean p2, p2, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    if-eqz p2, :cond_58

    iget-object p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object p2, p2, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-boolean p2, p2, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    if-eqz p2, :cond_58

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v1, p1, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget p1, p1, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    :cond_58
    sub-int p2, v2, v0

    sub-int v3, p1, v1

    if-ltz p2, :cond_75

    if-ltz v3, :cond_75

    const/high16 p2, -0x80000000

    if-eq v0, p2, :cond_75

    const v3, 0x7fffffff

    if-eq v0, v3, :cond_75

    if-eq v1, p2, :cond_75

    if-eq v1, v3, :cond_75

    if-eq v2, p2, :cond_75

    if-eq v2, v3, :cond_75

    if-eq p1, p2, :cond_75

    if-ne p1, v3, :cond_79

    :cond_75
    const/4 v0, 0x0

    move p1, v0

    move v1, p1

    move v2, v1

    :cond_79
    invoke-virtual {p0, v0, v1, v2, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setFrame(IIII)V

    return-void
.end method
