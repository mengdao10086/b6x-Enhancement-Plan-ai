.class public Landroidx/constraintlayout/motion/widget/MotionController;
.super Ljava/lang/Object;
.source "MotionController.java"


# static fields
.field static final BOUNCE:I = 0x4

.field private static final DEBUG:Z = false

.field public static final DRAW_PATH_AS_CONFIGURED:I = 0x4

.field public static final DRAW_PATH_BASIC:I = 0x1

.field public static final DRAW_PATH_CARTESIAN:I = 0x3

.field public static final DRAW_PATH_NONE:I = 0x0

.field public static final DRAW_PATH_RECTANGLE:I = 0x5

.field public static final DRAW_PATH_RELATIVE:I = 0x2

.field public static final DRAW_PATH_SCREEN:I = 0x6

.field static final EASE_IN:I = 0x1

.field static final EASE_IN_OUT:I = 0x0

.field static final EASE_OUT:I = 0x2

.field private static final FAVOR_FIXED_SIZE_VIEWS:Z = false

.field public static final HORIZONTAL_PATH_X:I = 0x2

.field public static final HORIZONTAL_PATH_Y:I = 0x3

.field private static final INTERPOLATOR_REFERENCE_ID:I = -0x2

.field private static final INTERPOLATOR_UNDEFINED:I = -0x3

.field static final LINEAR:I = 0x3

.field static final OVERSHOOT:I = 0x5

.field public static final PATH_PERCENT:I = 0x0

.field public static final PATH_PERPENDICULAR:I = 0x1

.field public static final ROTATION_LEFT:I = 0x2

.field public static final ROTATION_RIGHT:I = 0x1

.field private static final SPLINE_STRING:I = -0x1

.field private static final TAG:Ljava/lang/String; = "MotionController"

.field public static final VERTICAL_PATH_X:I = 0x4

.field public static final VERTICAL_PATH_Y:I = 0x5


# instance fields
.field private MAX_DIMENSION:I

.field attributeTable:[Ljava/lang/String;

.field private mArcSpline:Landroidx/constraintlayout/core/motion/utils/CurveFit;

.field private mAttributeInterpolatorCount:[I

.field private mAttributeNames:[Ljava/lang/String;

.field private mAttributesMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap<",
            "Ljava/lang/String;",
            "Landroidx/constraintlayout/motion/utils/ViewSpline;",
            ">;"
        }
    .end annotation
.end field

.field mConstraintTag:Ljava/lang/String;

.field mCurrentCenterX:F

.field mCurrentCenterY:F

.field private mCurveFitType:I

.field private mCycleMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap<",
            "Ljava/lang/String;",
            "Landroidx/constraintlayout/motion/utils/ViewOscillator;",
            ">;"
        }
    .end annotation
.end field

.field private mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

.field private mEndPoint:Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;

.field mForceMeasure:Z

.field mId:I

.field private mInterpolateData:[D

.field private mInterpolateVariables:[I

.field private mInterpolateVelocity:[D

.field private mKeyList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Landroidx/constraintlayout/motion/widget/Key;",
            ">;"
        }
    .end annotation
.end field

.field private mKeyTriggers:[Landroidx/constraintlayout/motion/widget/KeyTrigger;

.field private mMotionPaths:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Landroidx/constraintlayout/motion/widget/MotionPaths;",
            ">;"
        }
    .end annotation
.end field

.field mMotionStagger:F

.field private mNoMovement:Z

.field private mPathMotionArc:I

.field private mQuantizeMotionInterpolator:Landroid/view/animation/Interpolator;

.field private mQuantizeMotionPhase:F

.field private mQuantizeMotionSteps:I

.field private mSpline:[Landroidx/constraintlayout/core/motion/utils/CurveFit;

.field mStaggerOffset:F

.field mStaggerScale:F

.field private mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

.field private mStartPoint:Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;

.field mTempRect:Landroid/graphics/Rect;

.field private mTimeCycleAttributesMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap<",
            "Ljava/lang/String;",
            "Landroidx/constraintlayout/motion/utils/ViewTimeCycle;",
            ">;"
        }
    .end annotation
.end field

.field private mTransformPivotTarget:I

.field private mTransformPivotView:Landroid/view/View;

.field private mValuesBuff:[F

.field private mVelocity:[F

.field mView:Landroid/view/View;


# direct methods
.method constructor <init>(Landroid/view/View;)V
    .registers 6
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "view"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mTempRect:Landroid/graphics/Rect;

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mForceMeasure:Z

    const/4 v1, -0x1

    iput v1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mCurveFitType:I

    new-instance v1, Landroidx/constraintlayout/motion/widget/MotionPaths;

    invoke-direct {v1}, Landroidx/constraintlayout/motion/widget/MotionPaths;-><init>()V

    iput-object v1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    new-instance v1, Landroidx/constraintlayout/motion/widget/MotionPaths;

    invoke-direct {v1}, Landroidx/constraintlayout/motion/widget/MotionPaths;-><init>()V

    iput-object v1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    new-instance v1, Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;

    invoke-direct {v1}, Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;-><init>()V

    iput-object v1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartPoint:Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;

    new-instance v1, Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;

    invoke-direct {v1}, Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;-><init>()V

    iput-object v1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndPoint:Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;

    const/high16 v1, 0x7fc00000    # Float.NaN

    iput v1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mMotionStagger:F

    const/4 v2, 0x0

    iput v2, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStaggerOffset:F

    const/high16 v2, 0x3f800000    # 1.0f

    iput v2, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStaggerScale:F

    const/4 v2, 0x4

    iput v2, p0, Landroidx/constraintlayout/motion/widget/MotionController;->MAX_DIMENSION:I

    new-array v2, v2, [F

    iput-object v2, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mValuesBuff:[F

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mMotionPaths:Ljava/util/ArrayList;

    const/4 v2, 0x1

    new-array v2, v2, [F

    iput-object v2, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mVelocity:[F

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mKeyList:Ljava/util/ArrayList;

    sget v2, Landroidx/constraintlayout/motion/widget/Key;->UNSET:I

    iput v2, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mPathMotionArc:I

    sget v2, Landroidx/constraintlayout/motion/widget/Key;->UNSET:I

    iput v2, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mTransformPivotTarget:I

    const/4 v2, 0x0

    iput-object v2, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mTransformPivotView:Landroid/view/View;

    sget v3, Landroidx/constraintlayout/motion/widget/Key;->UNSET:I

    iput v3, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mQuantizeMotionSteps:I

    iput v1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mQuantizeMotionPhase:F

    iput-object v2, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mQuantizeMotionInterpolator:Landroid/view/animation/Interpolator;

    iput-boolean v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mNoMovement:Z

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/motion/widget/MotionController;->setView(Landroid/view/View;)V

    return-void
.end method

.method private getAdjustedPosition(F[F)F
    .registers 14
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "position",
            "velocity"
        }
    .end annotation

    const/4 v0, 0x0

    const/4 v1, 0x0

    const/high16 v2, 0x3f800000    # 1.0f

    if-eqz p2, :cond_9

    aput v2, p2, v1

    goto :goto_28

    :cond_9
    iget v3, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStaggerScale:F

    float-to-double v4, v3

    const-wide/high16 v6, 0x3ff0000000000000L    # 1.0

    cmpl-double v4, v4, v6

    if-eqz v4, :cond_28

    iget v4, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStaggerOffset:F

    cmpg-float v5, p1, v4

    if-gez v5, :cond_19

    move p1, v0

    :cond_19
    cmpl-float v5, p1, v4

    if-lez v5, :cond_28

    float-to-double v8, p1

    cmpg-double v5, v8, v6

    if-gez v5, :cond_28

    sub-float/2addr p1, v4

    mul-float/2addr p1, v3

    invoke-static {p1, v2}, Ljava/lang/Math;->min(FF)F

    move-result p1

    :cond_28
    :goto_28
    iget-object v3, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget-object v3, v3, Landroidx/constraintlayout/motion/widget/MotionPaths;->mKeyFrameEasing:Landroidx/constraintlayout/core/motion/utils/Easing;

    iget-object v4, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mMotionPaths:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    const/high16 v5, 0x7fc00000    # Float.NaN

    :cond_34
    :goto_34
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_5b

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget-object v7, v6, Landroidx/constraintlayout/motion/widget/MotionPaths;->mKeyFrameEasing:Landroidx/constraintlayout/core/motion/utils/Easing;

    if-eqz v7, :cond_34

    iget v7, v6, Landroidx/constraintlayout/motion/widget/MotionPaths;->time:F

    cmpg-float v7, v7, p1

    if-gez v7, :cond_52

    iget-object v0, v6, Landroidx/constraintlayout/motion/widget/MotionPaths;->mKeyFrameEasing:Landroidx/constraintlayout/core/motion/utils/Easing;

    iget v3, v6, Landroidx/constraintlayout/motion/widget/MotionPaths;->time:F

    move v10, v3

    move-object v3, v0

    move v0, v10

    goto :goto_34

    :cond_52
    invoke-static {v5}, Ljava/lang/Float;->isNaN(F)Z

    move-result v7

    if-eqz v7, :cond_34

    iget v5, v6, Landroidx/constraintlayout/motion/widget/MotionPaths;->time:F

    goto :goto_34

    :cond_5b
    if-eqz v3, :cond_79

    invoke-static {v5}, Ljava/lang/Float;->isNaN(F)Z

    move-result v4

    if-eqz v4, :cond_64

    goto :goto_65

    :cond_64
    move v2, v5

    :goto_65
    sub-float/2addr p1, v0

    sub-float/2addr v2, v0

    div-float/2addr p1, v2

    float-to-double v4, p1

    invoke-virtual {v3, v4, v5}, Landroidx/constraintlayout/core/motion/utils/Easing;->get(D)D

    move-result-wide v6

    double-to-float p1, v6

    mul-float/2addr p1, v2

    add-float/2addr p1, v0

    if-eqz p2, :cond_79

    invoke-virtual {v3, v4, v5}, Landroidx/constraintlayout/core/motion/utils/Easing;->getDiff(D)D

    move-result-wide v2

    double-to-float v0, v2

    aput v0, p2, v1

    :cond_79
    return p1
.end method

.method private static getInterpolator(Landroid/content/Context;ILjava/lang/String;I)Landroid/view/animation/Interpolator;
    .registers 5
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0,
            0x0
        }
        names = {
            "context",
            "type",
            "interpolatorString",
            "id"
        }
    .end annotation

    const/4 v0, -0x2

    if-eq p1, v0, :cond_3e

    const/4 p0, -0x1

    if-eq p1, p0, :cond_34

    if-eqz p1, :cond_2e

    const/4 p0, 0x1

    if-eq p1, p0, :cond_28

    const/4 p0, 0x2

    if-eq p1, p0, :cond_22

    const/4 p0, 0x4

    if-eq p1, p0, :cond_1c

    const/4 p0, 0x5

    if-eq p1, p0, :cond_16

    const/4 p0, 0x0

    return-object p0

    :cond_16
    new-instance p0, Landroid/view/animation/OvershootInterpolator;

    invoke-direct {p0}, Landroid/view/animation/OvershootInterpolator;-><init>()V

    return-object p0

    :cond_1c
    new-instance p0, Landroid/view/animation/BounceInterpolator;

    invoke-direct {p0}, Landroid/view/animation/BounceInterpolator;-><init>()V

    return-object p0

    :cond_22
    new-instance p0, Landroid/view/animation/DecelerateInterpolator;

    invoke-direct {p0}, Landroid/view/animation/DecelerateInterpolator;-><init>()V

    return-object p0

    :cond_28
    new-instance p0, Landroid/view/animation/AccelerateInterpolator;

    invoke-direct {p0}, Landroid/view/animation/AccelerateInterpolator;-><init>()V

    return-object p0

    :cond_2e
    new-instance p0, Landroid/view/animation/AccelerateDecelerateInterpolator;

    invoke-direct {p0}, Landroid/view/animation/AccelerateDecelerateInterpolator;-><init>()V

    return-object p0

    :cond_34
    invoke-static {p2}, Landroidx/constraintlayout/core/motion/utils/Easing;->getInterpolator(Ljava/lang/String;)Landroidx/constraintlayout/core/motion/utils/Easing;

    move-result-object p0

    new-instance p1, Landroidx/constraintlayout/motion/widget/MotionController$1;

    invoke-direct {p1, p0}, Landroidx/constraintlayout/motion/widget/MotionController$1;-><init>(Landroidx/constraintlayout/core/motion/utils/Easing;)V

    return-object p1

    :cond_3e
    invoke-static {p0, p3}, Landroid/view/animation/AnimationUtils;->loadInterpolator(Landroid/content/Context;I)Landroid/view/animation/Interpolator;

    move-result-object p0

    return-object p0
.end method

.method private getPreCycleDistance()F
    .registers 21

    move-object/from16 v0, p0

    const/4 v1, 0x2

    new-array v1, v1, [F

    const/16 v2, 0x63

    int-to-float v2, v2

    const/high16 v9, 0x3f800000    # 1.0f

    div-float v10, v9, v2

    const-wide/16 v2, 0x0

    const/4 v12, 0x0

    move-wide v13, v2

    move-wide v15, v13

    move v8, v12

    const/4 v7, 0x0

    :goto_13
    const/16 v2, 0x64

    if-ge v8, v2, :cond_aa

    int-to-float v2, v8

    mul-float/2addr v2, v10

    float-to-double v3, v2

    iget-object v5, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget-object v5, v5, Landroidx/constraintlayout/motion/widget/MotionPaths;->mKeyFrameEasing:Landroidx/constraintlayout/core/motion/utils/Easing;

    iget-object v6, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mMotionPaths:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v6

    const/high16 v17, 0x7fc00000    # Float.NaN

    const/16 v18, 0x0

    :goto_28
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v19

    if-eqz v19, :cond_54

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v19

    move-object/from16 v9, v19

    check-cast v9, Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget-object v11, v9, Landroidx/constraintlayout/motion/widget/MotionPaths;->mKeyFrameEasing:Landroidx/constraintlayout/core/motion/utils/Easing;

    if-eqz v11, :cond_51

    iget v11, v9, Landroidx/constraintlayout/motion/widget/MotionPaths;->time:F

    cmpg-float v11, v11, v2

    if-gez v11, :cond_47

    iget-object v5, v9, Landroidx/constraintlayout/motion/widget/MotionPaths;->mKeyFrameEasing:Landroidx/constraintlayout/core/motion/utils/Easing;

    iget v9, v9, Landroidx/constraintlayout/motion/widget/MotionPaths;->time:F

    move/from16 v18, v9

    goto :goto_51

    :cond_47
    invoke-static/range {v17 .. v17}, Ljava/lang/Float;->isNaN(F)Z

    move-result v11

    if-eqz v11, :cond_51

    iget v9, v9, Landroidx/constraintlayout/motion/widget/MotionPaths;->time:F

    move/from16 v17, v9

    :cond_51
    :goto_51
    const/high16 v9, 0x3f800000    # 1.0f

    goto :goto_28

    :cond_54
    if-eqz v5, :cond_70

    invoke-static/range {v17 .. v17}, Ljava/lang/Float;->isNaN(F)Z

    move-result v3

    if-eqz v3, :cond_5e

    const/high16 v17, 0x3f800000    # 1.0f

    :cond_5e
    sub-float v2, v2, v18

    sub-float v17, v17, v18

    div-float v2, v2, v17

    float-to-double v2, v2

    invoke-virtual {v5, v2, v3}, Landroidx/constraintlayout/core/motion/utils/Easing;->get(D)D

    move-result-wide v2

    double-to-float v2, v2

    mul-float v2, v2, v17

    add-float v2, v2, v18

    float-to-double v2, v2

    move-wide v3, v2

    :cond_70
    iget-object v2, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mSpline:[Landroidx/constraintlayout/core/motion/utils/CurveFit;

    aget-object v2, v2, v12

    iget-object v5, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    invoke-virtual {v2, v3, v4, v5}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getPos(D[D)V

    iget-object v2, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget-object v5, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVariables:[I

    iget-object v6, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    const/4 v9, 0x0

    move v11, v7

    move-object v7, v1

    move/from16 v17, v8

    move v8, v9

    invoke-virtual/range {v2 .. v8}, Landroidx/constraintlayout/motion/widget/MotionPaths;->getCenter(D[I[D[FI)V

    const/4 v2, 0x1

    if-lez v17, :cond_9c

    float-to-double v3, v11

    aget v5, v1, v2

    float-to-double v5, v5

    sub-double v5, v15, v5

    aget v7, v1, v12

    float-to-double v7, v7

    sub-double/2addr v13, v7

    invoke-static {v5, v6, v13, v14}, Ljava/lang/Math;->hypot(DD)D

    move-result-wide v5

    add-double/2addr v3, v5

    double-to-float v7, v3

    goto :goto_9d

    :cond_9c
    move v7, v11

    :goto_9d
    aget v3, v1, v12

    float-to-double v13, v3

    aget v2, v1, v2

    float-to-double v2, v2

    add-int/lit8 v8, v17, 0x1

    move-wide v15, v2

    const/high16 v9, 0x3f800000    # 1.0f

    goto/16 :goto_13

    :cond_aa
    move v11, v7

    return v11
.end method

.method private insertKey(Landroidx/constraintlayout/motion/widget/MotionPaths;)V
    .registers 5
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "point"
        }
    .end annotation

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mMotionPaths:Ljava/util/ArrayList;

    invoke-static {v0, p1}, Ljava/util/Collections;->binarySearch(Ljava/util/List;Ljava/lang/Object;)I

    move-result v0

    if-nez v0, :cond_24

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, " KeyPath position \""

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, p1, Landroidx/constraintlayout/motion/widget/MotionPaths;->position:F

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\" outside of range"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "MotionController"

    invoke-static {v2, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    :cond_24
    iget-object v1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mMotionPaths:Ljava/util/ArrayList;

    neg-int v0, v0

    add-int/lit8 v0, v0, -0x1

    invoke-virtual {v1, v0, p1}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    return-void
.end method

.method private readView(Landroidx/constraintlayout/motion/widget/MotionPaths;)V
    .registers 6
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "motionPaths"
        }
    .end annotation

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getX()F

    move-result v0

    float-to-int v0, v0

    int-to-float v0, v0

    iget-object v1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getY()F

    move-result v1

    float-to-int v1, v1

    int-to-float v1, v1

    iget-object v2, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mView:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getWidth()I

    move-result v2

    int-to-float v2, v2

    iget-object v3, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mView:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getHeight()I

    move-result v3

    int-to-float v3, v3

    invoke-virtual {p1, v0, v1, v2, v3}, Landroidx/constraintlayout/motion/widget/MotionPaths;->setBounds(FFFF)V

    return-void
.end method


# virtual methods
.method public addKey(Landroidx/constraintlayout/motion/widget/Key;)V
    .registers 3
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "key"
        }
    .end annotation

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mKeyList:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method addKeys(Ljava/util/ArrayList;)V
    .registers 3
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "list"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList<",
            "Landroidx/constraintlayout/motion/widget/Key;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mKeyList:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    return-void
.end method

.method buildBounds([FI)V
    .registers 19
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "bounds",
            "pointCount"
        }
    .end annotation

    move-object/from16 v0, p0

    move/from16 v1, p2

    add-int/lit8 v2, v1, -0x1

    int-to-float v2, v2

    const/high16 v3, 0x3f800000    # 1.0f

    div-float v2, v3, v2

    iget-object v4, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mAttributesMap:Ljava/util/HashMap;

    const-string v5, "translationX"

    if-nez v4, :cond_12

    goto :goto_18

    :cond_12
    invoke-virtual {v4, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/constraintlayout/core/motion/utils/SplineSet;

    :goto_18
    iget-object v4, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mAttributesMap:Ljava/util/HashMap;

    const-string v6, "translationY"

    if-nez v4, :cond_1f

    goto :goto_25

    :cond_1f
    invoke-virtual {v4, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/constraintlayout/core/motion/utils/SplineSet;

    :goto_25
    iget-object v4, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mCycleMap:Ljava/util/HashMap;

    if-nez v4, :cond_2a

    goto :goto_30

    :cond_2a
    invoke-virtual {v4, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/constraintlayout/motion/utils/ViewOscillator;

    :goto_30
    iget-object v4, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mCycleMap:Ljava/util/HashMap;

    if-nez v4, :cond_35

    goto :goto_3b

    :cond_35
    invoke-virtual {v4, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/constraintlayout/motion/utils/ViewOscillator;

    :goto_3b
    const/4 v4, 0x0

    move v5, v4

    :goto_3d
    if-ge v5, v1, :cond_cf

    int-to-float v6, v5

    mul-float/2addr v6, v2

    iget v7, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStaggerScale:F

    cmpl-float v8, v7, v3

    const/4 v9, 0x0

    if-eqz v8, :cond_60

    iget v8, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStaggerOffset:F

    cmpg-float v10, v6, v8

    if-gez v10, :cond_4f

    move v6, v9

    :cond_4f
    cmpl-float v10, v6, v8

    if-lez v10, :cond_60

    float-to-double v10, v6

    const-wide/high16 v12, 0x3ff0000000000000L    # 1.0

    cmpg-double v10, v10, v12

    if-gez v10, :cond_60

    sub-float/2addr v6, v8

    mul-float/2addr v6, v7

    invoke-static {v6, v3}, Ljava/lang/Math;->min(FF)F

    move-result v6

    :cond_60
    float-to-double v7, v6

    iget-object v10, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget-object v10, v10, Landroidx/constraintlayout/motion/widget/MotionPaths;->mKeyFrameEasing:Landroidx/constraintlayout/core/motion/utils/Easing;

    iget-object v11, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mMotionPaths:Ljava/util/ArrayList;

    invoke-virtual {v11}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v11

    const/high16 v12, 0x7fc00000    # Float.NaN

    :cond_6d
    :goto_6d
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v13

    if-eqz v13, :cond_94

    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget-object v14, v13, Landroidx/constraintlayout/motion/widget/MotionPaths;->mKeyFrameEasing:Landroidx/constraintlayout/core/motion/utils/Easing;

    if-eqz v14, :cond_6d

    iget v14, v13, Landroidx/constraintlayout/motion/widget/MotionPaths;->time:F

    cmpg-float v14, v14, v6

    if-gez v14, :cond_8b

    iget-object v9, v13, Landroidx/constraintlayout/motion/widget/MotionPaths;->mKeyFrameEasing:Landroidx/constraintlayout/core/motion/utils/Easing;

    iget v10, v13, Landroidx/constraintlayout/motion/widget/MotionPaths;->time:F

    move v15, v10

    move-object v10, v9

    move v9, v15

    goto :goto_6d

    :cond_8b
    invoke-static {v12}, Ljava/lang/Float;->isNaN(F)Z

    move-result v14

    if-eqz v14, :cond_6d

    iget v12, v13, Landroidx/constraintlayout/motion/widget/MotionPaths;->time:F

    goto :goto_6d

    :cond_94
    if-eqz v10, :cond_a9

    invoke-static {v12}, Ljava/lang/Float;->isNaN(F)Z

    move-result v7

    if-eqz v7, :cond_9d

    move v12, v3

    :cond_9d
    sub-float/2addr v6, v9

    sub-float/2addr v12, v9

    div-float/2addr v6, v12

    float-to-double v6, v6

    invoke-virtual {v10, v6, v7}, Landroidx/constraintlayout/core/motion/utils/Easing;->get(D)D

    move-result-wide v6

    double-to-float v6, v6

    mul-float/2addr v6, v12

    add-float/2addr v6, v9

    float-to-double v7, v6

    :cond_a9
    iget-object v6, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mSpline:[Landroidx/constraintlayout/core/motion/utils/CurveFit;

    aget-object v6, v6, v4

    iget-object v9, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    invoke-virtual {v6, v7, v8, v9}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getPos(D[D)V

    iget-object v6, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mArcSpline:Landroidx/constraintlayout/core/motion/utils/CurveFit;

    if-eqz v6, :cond_be

    iget-object v9, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    array-length v10, v9

    if-lez v10, :cond_be

    invoke-virtual {v6, v7, v8, v9}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getPos(D[D)V

    :cond_be
    iget-object v6, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget-object v7, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVariables:[I

    iget-object v8, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    mul-int/lit8 v9, v5, 0x2

    move-object/from16 v10, p1

    invoke-virtual {v6, v7, v8, v10, v9}, Landroidx/constraintlayout/motion/widget/MotionPaths;->getBounds([I[D[FI)V

    add-int/lit8 v5, v5, 0x1

    goto/16 :goto_3d

    :cond_cf
    return-void
.end method

.method buildKeyBounds([F[I)I
    .registers 10
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "keyBounds",
            "mode"
        }
    .end annotation

    const/4 v0, 0x0

    if-eqz p1, :cond_49

    iget-object v1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mSpline:[Landroidx/constraintlayout/core/motion/utils/CurveFit;

    aget-object v1, v1, v0

    invoke-virtual {v1}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getTimePoints()[D

    move-result-object v1

    if-eqz p2, :cond_28

    iget-object v2, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mMotionPaths:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    move v3, v0

    :goto_14
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_28

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/constraintlayout/motion/widget/MotionPaths;

    add-int/lit8 v5, v3, 0x1

    iget v4, v4, Landroidx/constraintlayout/motion/widget/MotionPaths;->mMode:I

    aput v4, p2, v3

    move v3, v5

    goto :goto_14

    :cond_28
    move p2, v0

    move v2, p2

    :goto_2a
    array-length v3, v1

    if-ge p2, v3, :cond_46

    iget-object v3, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mSpline:[Landroidx/constraintlayout/core/motion/utils/CurveFit;

    aget-object v3, v3, v0

    aget-wide v4, v1, p2

    iget-object v6, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    invoke-virtual {v3, v4, v5, v6}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getPos(D[D)V

    iget-object v3, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget-object v4, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVariables:[I

    iget-object v5, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    invoke-virtual {v3, v4, v5, p1, v2}, Landroidx/constraintlayout/motion/widget/MotionPaths;->getBounds([I[D[FI)V

    add-int/lit8 v2, v2, 0x2

    add-int/lit8 p2, p2, 0x1

    goto :goto_2a

    :cond_46
    div-int/lit8 v2, v2, 0x2

    return v2

    :cond_49
    return v0
.end method

.method buildKeyFrames([F[I)I
    .registers 13
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "keyFrames",
            "mode"
        }
    .end annotation

    const/4 v0, 0x0

    if-eqz p1, :cond_4d

    iget-object v1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mSpline:[Landroidx/constraintlayout/core/motion/utils/CurveFit;

    aget-object v1, v1, v0

    invoke-virtual {v1}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getTimePoints()[D

    move-result-object v1

    if-eqz p2, :cond_28

    iget-object v2, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mMotionPaths:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    move v3, v0

    :goto_14
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_28

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/constraintlayout/motion/widget/MotionPaths;

    add-int/lit8 v5, v3, 0x1

    iget v4, v4, Landroidx/constraintlayout/motion/widget/MotionPaths;->mMode:I

    aput v4, p2, v3

    move v3, v5

    goto :goto_14

    :cond_28
    move p2, v0

    move v9, p2

    :goto_2a
    array-length v2, v1

    if-ge p2, v2, :cond_4a

    iget-object v2, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mSpline:[Landroidx/constraintlayout/core/motion/utils/CurveFit;

    aget-object v2, v2, v0

    aget-wide v3, v1, p2

    iget-object v5, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    invoke-virtual {v2, v3, v4, v5}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getPos(D[D)V

    iget-object v2, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    aget-wide v3, v1, p2

    iget-object v5, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVariables:[I

    iget-object v6, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    move-object v7, p1

    move v8, v9

    invoke-virtual/range {v2 .. v8}, Landroidx/constraintlayout/motion/widget/MotionPaths;->getCenter(D[I[D[FI)V

    add-int/lit8 v9, v9, 0x2

    add-int/lit8 p2, p2, 0x1

    goto :goto_2a

    :cond_4a
    div-int/lit8 v9, v9, 0x2

    return v9

    :cond_4d
    return v0
.end method

.method buildPath([FI)V
    .registers 21
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "points",
            "pointCount"
        }
    .end annotation

    move-object/from16 v0, p0

    move/from16 v8, p2

    add-int/lit8 v1, v8, -0x1

    int-to-float v1, v1

    const/high16 v9, 0x3f800000    # 1.0f

    div-float v10, v9, v1

    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mAttributesMap:Ljava/util/HashMap;

    const-string v2, "translationX"

    const/4 v3, 0x0

    if-nez v1, :cond_14

    move-object v11, v3

    goto :goto_1b

    :cond_14
    invoke-virtual {v1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/constraintlayout/core/motion/utils/SplineSet;

    move-object v11, v1

    :goto_1b
    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mAttributesMap:Ljava/util/HashMap;

    const-string v4, "translationY"

    if-nez v1, :cond_23

    move-object v12, v3

    goto :goto_2a

    :cond_23
    invoke-virtual {v1, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/constraintlayout/core/motion/utils/SplineSet;

    move-object v12, v1

    :goto_2a
    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mCycleMap:Ljava/util/HashMap;

    if-nez v1, :cond_30

    move-object v13, v3

    goto :goto_37

    :cond_30
    invoke-virtual {v1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/constraintlayout/motion/utils/ViewOscillator;

    move-object v13, v1

    :goto_37
    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mCycleMap:Ljava/util/HashMap;

    if-nez v1, :cond_3c

    goto :goto_43

    :cond_3c
    invoke-virtual {v1, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    move-object v3, v1

    check-cast v3, Landroidx/constraintlayout/motion/utils/ViewOscillator;

    :goto_43
    move-object v14, v3

    const/4 v7, 0x0

    :goto_45
    if-ge v7, v8, :cond_11a

    int-to-float v1, v7

    mul-float/2addr v1, v10

    iget v2, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStaggerScale:F

    cmpl-float v3, v2, v9

    const/4 v4, 0x0

    if-eqz v3, :cond_68

    iget v3, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStaggerOffset:F

    cmpg-float v5, v1, v3

    if-gez v5, :cond_57

    move v1, v4

    :cond_57
    cmpl-float v5, v1, v3

    if-lez v5, :cond_68

    float-to-double v5, v1

    const-wide/high16 v16, 0x3ff0000000000000L    # 1.0

    cmpg-double v5, v5, v16

    if-gez v5, :cond_68

    sub-float/2addr v1, v3

    mul-float/2addr v1, v2

    invoke-static {v1, v9}, Ljava/lang/Math;->min(FF)F

    move-result v1

    :cond_68
    move v6, v1

    float-to-double v1, v6

    iget-object v3, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget-object v3, v3, Landroidx/constraintlayout/motion/widget/MotionPaths;->mKeyFrameEasing:Landroidx/constraintlayout/core/motion/utils/Easing;

    iget-object v5, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mMotionPaths:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v5

    const/high16 v16, 0x7fc00000    # Float.NaN

    :goto_76
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v17

    if-eqz v17, :cond_a0

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v17

    move-object/from16 v9, v17

    check-cast v9, Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget-object v15, v9, Landroidx/constraintlayout/motion/widget/MotionPaths;->mKeyFrameEasing:Landroidx/constraintlayout/core/motion/utils/Easing;

    if-eqz v15, :cond_9d

    iget v15, v9, Landroidx/constraintlayout/motion/widget/MotionPaths;->time:F

    cmpg-float v15, v15, v6

    if-gez v15, :cond_93

    iget-object v3, v9, Landroidx/constraintlayout/motion/widget/MotionPaths;->mKeyFrameEasing:Landroidx/constraintlayout/core/motion/utils/Easing;

    iget v4, v9, Landroidx/constraintlayout/motion/widget/MotionPaths;->time:F

    goto :goto_9d

    :cond_93
    invoke-static/range {v16 .. v16}, Ljava/lang/Float;->isNaN(F)Z

    move-result v15

    if-eqz v15, :cond_9d

    iget v9, v9, Landroidx/constraintlayout/motion/widget/MotionPaths;->time:F

    move/from16 v16, v9

    :cond_9d
    :goto_9d
    const/high16 v9, 0x3f800000    # 1.0f

    goto :goto_76

    :cond_a0
    if-eqz v3, :cond_ba

    invoke-static/range {v16 .. v16}, Ljava/lang/Float;->isNaN(F)Z

    move-result v1

    if-eqz v1, :cond_aa

    const/high16 v16, 0x3f800000    # 1.0f

    :cond_aa
    sub-float v1, v6, v4

    sub-float v16, v16, v4

    div-float v1, v1, v16

    float-to-double v1, v1

    invoke-virtual {v3, v1, v2}, Landroidx/constraintlayout/core/motion/utils/Easing;->get(D)D

    move-result-wide v1

    double-to-float v1, v1

    mul-float v1, v1, v16

    add-float/2addr v1, v4

    float-to-double v1, v1

    :cond_ba
    move-wide v2, v1

    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mSpline:[Landroidx/constraintlayout/core/motion/utils/CurveFit;

    const/4 v9, 0x0

    aget-object v1, v1, v9

    iget-object v4, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    invoke-virtual {v1, v2, v3, v4}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getPos(D[D)V

    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mArcSpline:Landroidx/constraintlayout/core/motion/utils/CurveFit;

    if-eqz v1, :cond_d1

    iget-object v4, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    array-length v5, v4

    if-lez v5, :cond_d1

    invoke-virtual {v1, v2, v3, v4}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getPos(D[D)V

    :cond_d1
    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget-object v4, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVariables:[I

    iget-object v5, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    mul-int/lit8 v15, v7, 0x2

    move v9, v6

    move-object/from16 v6, p1

    move/from16 v16, v7

    move v7, v15

    invoke-virtual/range {v1 .. v7}, Landroidx/constraintlayout/motion/widget/MotionPaths;->getCenter(D[I[D[FI)V

    if-eqz v13, :cond_ee

    aget v1, p1, v15

    invoke-virtual {v13, v9}, Landroidx/constraintlayout/motion/utils/ViewOscillator;->get(F)F

    move-result v2

    add-float/2addr v1, v2

    aput v1, p1, v15

    goto :goto_f9

    :cond_ee
    if-eqz v11, :cond_f9

    aget v1, p1, v15

    invoke-virtual {v11, v9}, Landroidx/constraintlayout/core/motion/utils/SplineSet;->get(F)F

    move-result v2

    add-float/2addr v1, v2

    aput v1, p1, v15

    :cond_f9
    :goto_f9
    if-eqz v14, :cond_107

    add-int/lit8 v15, v15, 0x1

    aget v1, p1, v15

    invoke-virtual {v14, v9}, Landroidx/constraintlayout/motion/utils/ViewOscillator;->get(F)F

    move-result v2

    add-float/2addr v1, v2

    aput v1, p1, v15

    goto :goto_114

    :cond_107
    if-eqz v12, :cond_114

    add-int/lit8 v15, v15, 0x1

    aget v1, p1, v15

    invoke-virtual {v12, v9}, Landroidx/constraintlayout/core/motion/utils/SplineSet;->get(F)F

    move-result v2

    add-float/2addr v1, v2

    aput v1, p1, v15

    :cond_114
    :goto_114
    add-int/lit8 v7, v16, 0x1

    const/high16 v9, 0x3f800000    # 1.0f

    goto/16 :goto_45

    :cond_11a
    return-void
.end method

.method buildRect(F[FI)V
    .registers 7
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0
        }
        names = {
            "p",
            "path",
            "offset"
        }
    .end annotation

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroidx/constraintlayout/motion/widget/MotionController;->getAdjustedPosition(F[F)F

    move-result p1

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mSpline:[Landroidx/constraintlayout/core/motion/utils/CurveFit;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    float-to-double v1, p1

    iget-object p1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    invoke-virtual {v0, v1, v2, p1}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getPos(D[D)V

    iget-object p1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVariables:[I

    iget-object v1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    invoke-virtual {p1, v0, v1, p2, p3}, Landroidx/constraintlayout/motion/widget/MotionPaths;->getRect([I[D[FI)V

    return-void
.end method

.method buildRectangles([FI)V
    .registers 10
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "path",
            "pointCount"
        }
    .end annotation

    add-int/lit8 v0, p2, -0x1

    int-to-float v0, v0

    const/high16 v1, 0x3f800000    # 1.0f

    div-float/2addr v1, v0

    const/4 v0, 0x0

    move v2, v0

    :goto_8
    if-ge v2, p2, :cond_29

    int-to-float v3, v2

    mul-float/2addr v3, v1

    const/4 v4, 0x0

    invoke-direct {p0, v3, v4}, Landroidx/constraintlayout/motion/widget/MotionController;->getAdjustedPosition(F[F)F

    move-result v3

    iget-object v4, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mSpline:[Landroidx/constraintlayout/core/motion/utils/CurveFit;

    aget-object v4, v4, v0

    float-to-double v5, v3

    iget-object v3, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    invoke-virtual {v4, v5, v6, v3}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getPos(D[D)V

    iget-object v3, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget-object v4, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVariables:[I

    iget-object v5, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    mul-int/lit8 v6, v2, 0x8

    invoke-virtual {v3, v4, v5, p1, v6}, Landroidx/constraintlayout/motion/widget/MotionPaths;->getRect([I[D[FI)V

    add-int/lit8 v2, v2, 0x1

    goto :goto_8

    :cond_29
    return-void
.end method

.method endTrigger(Z)V
    .registers 6
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "start"
        }
    .end annotation

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mView:Landroid/view/View;

    invoke-static {v0}, Landroidx/constraintlayout/motion/widget/Debug;->getName(Landroid/view/View;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "button"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_29

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mKeyTriggers:[Landroidx/constraintlayout/motion/widget/KeyTrigger;

    if-eqz v0, :cond_29

    const/4 v0, 0x0

    :goto_13
    iget-object v1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mKeyTriggers:[Landroidx/constraintlayout/motion/widget/KeyTrigger;

    array-length v2, v1

    if-ge v0, v2, :cond_29

    aget-object v1, v1, v0

    if-eqz p1, :cond_1f

    const/high16 v2, -0x3d380000    # -100.0f

    goto :goto_21

    :cond_1f
    const/high16 v2, 0x42c80000    # 100.0f

    :goto_21
    iget-object v3, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mView:Landroid/view/View;

    invoke-virtual {v1, v2, v3}, Landroidx/constraintlayout/motion/widget/KeyTrigger;->conditionallyFire(FLandroid/view/View;)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_13

    :cond_29
    return-void
.end method

.method public getAnimateRelativeTo()I
    .registers 2

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v0, v0, Landroidx/constraintlayout/motion/widget/MotionPaths;->mAnimateRelativeTo:I

    return v0
.end method

.method getAttributeValues(Ljava/lang/String;[FI)I
    .registers 5
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0
        }
        names = {
            "attributeType",
            "points",
            "pointCount"
        }
    .end annotation

    iget-object p3, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mAttributesMap:Ljava/util/HashMap;

    invoke-virtual {p3, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroidx/constraintlayout/core/motion/utils/SplineSet;

    if-nez p1, :cond_c

    const/4 p1, -0x1

    return p1

    :cond_c
    const/4 p3, 0x0

    :goto_d
    array-length v0, p2

    if-ge p3, v0, :cond_1f

    array-length v0, p2

    add-int/lit8 v0, v0, -0x1

    div-int v0, p3, v0

    int-to-float v0, v0

    invoke-virtual {p1, v0}, Landroidx/constraintlayout/core/motion/utils/SplineSet;->get(F)F

    move-result v0

    aput v0, p2, p3

    add-int/lit8 p3, p3, 0x1

    goto :goto_d

    :cond_1f
    array-length p1, p2

    return p1
.end method

.method public getCenter(D[F[F)V
    .registers 14
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0
        }
        names = {
            "p",
            "pos",
            "vel"
        }
    .end annotation

    const/4 v0, 0x4

    new-array v5, v0, [D

    new-array v7, v0, [D

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mSpline:[Landroidx/constraintlayout/core/motion/utils/CurveFit;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    invoke-virtual {v0, p1, p2, v5}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getPos(D[D)V

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mSpline:[Landroidx/constraintlayout/core/motion/utils/CurveFit;

    aget-object v0, v0, v1

    invoke-virtual {v0, p1, p2, v7}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getSlope(D[D)V

    const/4 v0, 0x0

    invoke-static {p4, v0}, Ljava/util/Arrays;->fill([FF)V

    iget-object v1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget-object v4, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVariables:[I

    move-wide v2, p1

    move-object v6, p3

    move-object v8, p4

    invoke-virtual/range {v1 .. v8}, Landroidx/constraintlayout/motion/widget/MotionPaths;->getCenter(D[I[D[F[D[F)V

    return-void
.end method

.method public getCenterX()F
    .registers 2

    iget v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mCurrentCenterX:F

    return v0
.end method

.method public getCenterY()F
    .registers 2

    iget v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mCurrentCenterY:F

    return v0
.end method

.method getDpDt(FFF[F)V
    .registers 16
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0,
            0x0
        }
        names = {
            "position",
            "locationX",
            "locationY",
            "mAnchorDpDt"
        }
    .end annotation

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mVelocity:[F

    invoke-direct {p0, p1, v0}, Landroidx/constraintlayout/motion/widget/MotionController;->getAdjustedPosition(F[F)F

    move-result p1

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mSpline:[Landroidx/constraintlayout/core/motion/utils/CurveFit;

    const/4 v1, 0x0

    if-eqz v0, :cond_5d

    aget-object v0, v0, v1

    float-to-double v2, p1

    iget-object p1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVelocity:[D

    invoke-virtual {v0, v2, v3, p1}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getSlope(D[D)V

    iget-object p1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mSpline:[Landroidx/constraintlayout/core/motion/utils/CurveFit;

    aget-object p1, p1, v1

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    invoke-virtual {p1, v2, v3, v0}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getPos(D[D)V

    iget-object p1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mVelocity:[F

    aget p1, p1, v1

    :goto_20
    iget-object v9, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVelocity:[D

    array-length v0, v9

    if-ge v1, v0, :cond_2e

    aget-wide v4, v9, v1

    float-to-double v6, p1

    mul-double/2addr v4, v6

    aput-wide v4, v9, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_20

    :cond_2e
    iget-object p1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mArcSpline:Landroidx/constraintlayout/core/motion/utils/CurveFit;

    if-eqz p1, :cond_50

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    array-length v1, v0

    if-lez v1, :cond_4f

    invoke-virtual {p1, v2, v3, v0}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getPos(D[D)V

    iget-object p1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mArcSpline:Landroidx/constraintlayout/core/motion/utils/CurveFit;

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVelocity:[D

    invoke-virtual {p1, v2, v3, v0}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getSlope(D[D)V

    iget-object v4, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget-object v8, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVariables:[I

    iget-object v9, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVelocity:[D

    iget-object v10, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    move v5, p2

    move v6, p3

    move-object v7, p4

    invoke-virtual/range {v4 .. v10}, Landroidx/constraintlayout/motion/widget/MotionPaths;->setDpDt(FF[F[I[D[D)V

    :cond_4f
    return-void

    :cond_50
    iget-object v4, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget-object v8, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVariables:[I

    iget-object v10, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    move v5, p2

    move v6, p3

    move-object v7, p4

    invoke-virtual/range {v4 .. v10}, Landroidx/constraintlayout/motion/widget/MotionPaths;->setDpDt(FF[F[I[D[D)V

    return-void

    :cond_5d
    iget-object p1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget p1, p1, Landroidx/constraintlayout/motion/widget/MotionPaths;->x:F

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v0, v0, Landroidx/constraintlayout/motion/widget/MotionPaths;->x:F

    sub-float/2addr p1, v0

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v0, v0, Landroidx/constraintlayout/motion/widget/MotionPaths;->y:F

    iget-object v2, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v2, v2, Landroidx/constraintlayout/motion/widget/MotionPaths;->y:F

    sub-float/2addr v0, v2

    iget-object v2, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v2, v2, Landroidx/constraintlayout/motion/widget/MotionPaths;->width:F

    iget-object v3, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v3, v3, Landroidx/constraintlayout/motion/widget/MotionPaths;->width:F

    sub-float/2addr v2, v3

    iget-object v3, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v3, v3, Landroidx/constraintlayout/motion/widget/MotionPaths;->height:F

    iget-object v4, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v4, v4, Landroidx/constraintlayout/motion/widget/MotionPaths;->height:F

    sub-float/2addr v3, v4

    add-float/2addr v2, p1

    add-float/2addr v3, v0

    const/high16 v4, 0x3f800000    # 1.0f

    sub-float v5, v4, p2

    mul-float/2addr p1, v5

    mul-float/2addr v2, p2

    add-float/2addr p1, v2

    aput p1, p4, v1

    sub-float/2addr v4, p3

    mul-float/2addr v0, v4

    mul-float/2addr v3, p3

    add-float/2addr v0, v3

    const/4 p1, 0x1

    aput v0, p4, p1

    return-void
.end method

.method public getDrawPath()I
    .registers 4

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v0, v0, Landroidx/constraintlayout/motion/widget/MotionPaths;->mDrawPath:I

    iget-object v1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mMotionPaths:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_a
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1d

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v2, v2, Landroidx/constraintlayout/motion/widget/MotionPaths;->mDrawPath:I

    invoke-static {v0, v2}, Ljava/lang/Math;->max(II)I

    move-result v0

    goto :goto_a

    :cond_1d
    iget-object v1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v1, v1, Landroidx/constraintlayout/motion/widget/MotionPaths;->mDrawPath:I

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    return v0
.end method

.method public getFinalHeight()F
    .registers 2

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v0, v0, Landroidx/constraintlayout/motion/widget/MotionPaths;->height:F

    return v0
.end method

.method public getFinalWidth()F
    .registers 2

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v0, v0, Landroidx/constraintlayout/motion/widget/MotionPaths;->width:F

    return v0
.end method

.method public getFinalX()F
    .registers 2

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v0, v0, Landroidx/constraintlayout/motion/widget/MotionPaths;->x:F

    return v0
.end method

.method public getFinalY()F
    .registers 2

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v0, v0, Landroidx/constraintlayout/motion/widget/MotionPaths;->y:F

    return v0
.end method

.method getKeyFrame(I)Landroidx/constraintlayout/motion/widget/MotionPaths;
    .registers 3
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "i"
        }
    .end annotation

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mMotionPaths:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroidx/constraintlayout/motion/widget/MotionPaths;

    return-object p1
.end method

.method public getKeyFrameInfo(I[I)I
    .registers 20
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "type",
            "info"
        }
    .end annotation

    move-object/from16 v0, p0

    move/from16 v1, p1

    const/4 v2, 0x2

    new-array v2, v2, [F

    iget-object v3, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mKeyList:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v10

    const/4 v11, 0x0

    move v12, v11

    move v13, v12

    :goto_10
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_92

    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    move-object v14, v3

    check-cast v14, Landroidx/constraintlayout/motion/widget/Key;

    iget v3, v14, Landroidx/constraintlayout/motion/widget/Key;->mType:I

    if-eq v3, v1, :cond_25

    const/4 v3, -0x1

    if-ne v1, v3, :cond_25

    goto :goto_10

    :cond_25
    aput v11, p2, v13

    add-int/lit8 v3, v13, 0x1

    iget v4, v14, Landroidx/constraintlayout/motion/widget/Key;->mType:I

    aput v4, p2, v3

    const/4 v15, 0x1

    add-int/lit8 v16, v3, 0x1

    iget v3, v14, Landroidx/constraintlayout/motion/widget/Key;->mFramePosition:I

    aput v3, p2, v16

    iget v3, v14, Landroidx/constraintlayout/motion/widget/Key;->mFramePosition:I

    int-to-float v3, v3

    const/high16 v4, 0x42c80000    # 100.0f

    div-float/2addr v3, v4

    iget-object v4, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mSpline:[Landroidx/constraintlayout/core/motion/utils/CurveFit;

    aget-object v4, v4, v11

    float-to-double v5, v3

    iget-object v3, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    invoke-virtual {v4, v5, v6, v3}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getPos(D[D)V

    iget-object v3, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget-object v7, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVariables:[I

    iget-object v8, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    const/4 v9, 0x0

    move-wide v4, v5

    move-object v6, v7

    move-object v7, v8

    move-object v8, v2

    invoke-virtual/range {v3 .. v9}, Landroidx/constraintlayout/motion/widget/MotionPaths;->getCenter(D[I[D[FI)V

    add-int/lit8 v16, v16, 0x1

    aget v3, v2, v11

    invoke-static {v3}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v3

    aput v3, p2, v16

    add-int/lit8 v16, v16, 0x1

    aget v3, v2, v15

    invoke-static {v3}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v3

    aput v3, p2, v16

    instance-of v3, v14, Landroidx/constraintlayout/motion/widget/KeyPosition;

    if-eqz v3, :cond_86

    check-cast v14, Landroidx/constraintlayout/motion/widget/KeyPosition;

    add-int/lit8 v16, v16, 0x1

    iget v3, v14, Landroidx/constraintlayout/motion/widget/KeyPosition;->mPositionType:I

    aput v3, p2, v16

    add-int/lit8 v16, v16, 0x1

    iget v3, v14, Landroidx/constraintlayout/motion/widget/KeyPosition;->mPercentX:F

    invoke-static {v3}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v3

    aput v3, p2, v16

    add-int/lit8 v16, v16, 0x1

    iget v3, v14, Landroidx/constraintlayout/motion/widget/KeyPosition;->mPercentY:F

    invoke-static {v3}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v3

    aput v3, p2, v16

    :cond_86
    add-int/lit8 v16, v16, 0x1

    sub-int v3, v16, v13

    aput v3, p2, v13

    add-int/lit8 v12, v12, 0x1

    move/from16 v13, v16

    goto/16 :goto_10

    :cond_92
    return v12
.end method

.method getKeyFrameParameter(IFF)F
    .registers 13
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0
        }
        names = {
            "type",
            "x",
            "y"
        }
    .end annotation

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v0, v0, Landroidx/constraintlayout/motion/widget/MotionPaths;->x:F

    iget-object v1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v1, v1, Landroidx/constraintlayout/motion/widget/MotionPaths;->x:F

    sub-float/2addr v0, v1

    iget-object v1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v1, v1, Landroidx/constraintlayout/motion/widget/MotionPaths;->y:F

    iget-object v2, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v2, v2, Landroidx/constraintlayout/motion/widget/MotionPaths;->y:F

    sub-float/2addr v1, v2

    iget-object v2, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v2, v2, Landroidx/constraintlayout/motion/widget/MotionPaths;->x:F

    iget-object v3, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v3, v3, Landroidx/constraintlayout/motion/widget/MotionPaths;->width:F

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v3, v4

    add-float/2addr v2, v3

    iget-object v3, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v3, v3, Landroidx/constraintlayout/motion/widget/MotionPaths;->y:F

    iget-object v5, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v5, v5, Landroidx/constraintlayout/motion/widget/MotionPaths;->height:F

    div-float/2addr v5, v4

    add-float/2addr v3, v5

    float-to-double v4, v0

    float-to-double v6, v1

    invoke-static {v4, v5, v6, v7}, Ljava/lang/Math;->hypot(DD)D

    move-result-wide v4

    double-to-float v4, v4

    float-to-double v5, v4

    const-wide v7, 0x3e7ad7f29abcaf48L    # 1.0E-7

    cmpg-double v5, v5, v7

    if-gez v5, :cond_3c

    const/high16 p1, 0x7fc00000    # Float.NaN

    return p1

    :cond_3c
    sub-float/2addr p2, v2

    sub-float/2addr p3, v3

    float-to-double v2, p2

    float-to-double v5, p3

    invoke-static {v2, v3, v5, v6}, Ljava/lang/Math;->hypot(DD)D

    move-result-wide v2

    double-to-float v2, v2

    const/4 v3, 0x0

    cmpl-float v2, v2, v3

    if-nez v2, :cond_4b

    return v3

    :cond_4b
    mul-float v2, p2, v0

    mul-float v5, p3, v1

    add-float/2addr v2, v5

    if-eqz p1, :cond_74

    const/4 v5, 0x1

    if-eq p1, v5, :cond_6a

    const/4 v2, 0x2

    if-eq p1, v2, :cond_68

    const/4 v2, 0x3

    if-eq p1, v2, :cond_66

    const/4 v0, 0x4

    if-eq p1, v0, :cond_64

    const/4 p2, 0x5

    if-eq p1, p2, :cond_62

    return v3

    :cond_62
    div-float/2addr p3, v1

    return p3

    :cond_64
    div-float/2addr p2, v1

    return p2

    :cond_66
    div-float/2addr p3, v0

    return p3

    :cond_68
    div-float/2addr p2, v0

    return p2

    :cond_6a
    mul-float/2addr v4, v4

    mul-float/2addr v2, v2

    sub-float/2addr v4, v2

    float-to-double p1, v4

    invoke-static {p1, p2}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide p1

    double-to-float p1, p1

    return p1

    :cond_74
    div-float/2addr v2, v4

    return v2
.end method

.method public getKeyFramePositions([I[F)I
    .registers 15
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "type",
            "pos"
        }
    .end annotation

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mKeyList:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    const/4 v1, 0x0

    move v2, v1

    move v10, v2

    :goto_9
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_3f

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/constraintlayout/motion/widget/Key;

    add-int/lit8 v11, v2, 0x1

    iget v4, v3, Landroidx/constraintlayout/motion/widget/Key;->mFramePosition:I

    iget v5, v3, Landroidx/constraintlayout/motion/widget/Key;->mType:I

    mul-int/lit16 v5, v5, 0x3e8

    add-int/2addr v4, v5

    aput v4, p1, v2

    iget v2, v3, Landroidx/constraintlayout/motion/widget/Key;->mFramePosition:I

    int-to-float v2, v2

    const/high16 v3, 0x42c80000    # 100.0f

    div-float/2addr v2, v3

    iget-object v3, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mSpline:[Landroidx/constraintlayout/core/motion/utils/CurveFit;

    aget-object v3, v3, v1

    float-to-double v4, v2

    iget-object v2, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    invoke-virtual {v3, v4, v5, v2}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getPos(D[D)V

    iget-object v3, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget-object v6, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVariables:[I

    iget-object v7, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    move-object v8, p2

    move v9, v10

    invoke-virtual/range {v3 .. v9}, Landroidx/constraintlayout/motion/widget/MotionPaths;->getCenter(D[I[D[FI)V

    add-int/lit8 v10, v10, 0x2

    move v2, v11

    goto :goto_9

    :cond_3f
    return v2
.end method

.method getPos(D)[D
    .registers 6
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "position"
        }
    .end annotation

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mSpline:[Landroidx/constraintlayout/core/motion/utils/CurveFit;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    iget-object v1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    invoke-virtual {v0, p1, p2, v1}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getPos(D[D)V

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mArcSpline:Landroidx/constraintlayout/core/motion/utils/CurveFit;

    if-eqz v0, :cond_16

    iget-object v1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    array-length v2, v1

    if-lez v2, :cond_16

    invoke-virtual {v0, p1, p2, v1}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getPos(D[D)V

    :cond_16
    iget-object p1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    return-object p1
.end method

.method getPositionKeyframe(IIFF)Landroidx/constraintlayout/motion/widget/KeyPositionBase;
    .registers 16
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0,
            0x0
        }
        names = {
            "layoutWidth",
            "layoutHeight",
            "x",
            "y"
        }
    .end annotation

    new-instance v7, Landroid/graphics/RectF;

    invoke-direct {v7}, Landroid/graphics/RectF;-><init>()V

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v0, v0, Landroidx/constraintlayout/motion/widget/MotionPaths;->x:F

    iput v0, v7, Landroid/graphics/RectF;->left:F

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v0, v0, Landroidx/constraintlayout/motion/widget/MotionPaths;->y:F

    iput v0, v7, Landroid/graphics/RectF;->top:F

    iget v0, v7, Landroid/graphics/RectF;->left:F

    iget-object v1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v1, v1, Landroidx/constraintlayout/motion/widget/MotionPaths;->width:F

    add-float/2addr v0, v1

    iput v0, v7, Landroid/graphics/RectF;->right:F

    iget v0, v7, Landroid/graphics/RectF;->top:F

    iget-object v1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v1, v1, Landroidx/constraintlayout/motion/widget/MotionPaths;->height:F

    add-float/2addr v0, v1

    iput v0, v7, Landroid/graphics/RectF;->bottom:F

    new-instance v8, Landroid/graphics/RectF;

    invoke-direct {v8}, Landroid/graphics/RectF;-><init>()V

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v0, v0, Landroidx/constraintlayout/motion/widget/MotionPaths;->x:F

    iput v0, v8, Landroid/graphics/RectF;->left:F

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v0, v0, Landroidx/constraintlayout/motion/widget/MotionPaths;->y:F

    iput v0, v8, Landroid/graphics/RectF;->top:F

    iget v0, v8, Landroid/graphics/RectF;->left:F

    iget-object v1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v1, v1, Landroidx/constraintlayout/motion/widget/MotionPaths;->width:F

    add-float/2addr v0, v1

    iput v0, v8, Landroid/graphics/RectF;->right:F

    iget v0, v8, Landroid/graphics/RectF;->top:F

    iget-object v1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v1, v1, Landroidx/constraintlayout/motion/widget/MotionPaths;->height:F

    add-float/2addr v0, v1

    iput v0, v8, Landroid/graphics/RectF;->bottom:F

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mKeyList:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :cond_4c
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_6d

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/motion/widget/Key;

    instance-of v1, v0, Landroidx/constraintlayout/motion/widget/KeyPositionBase;

    if-eqz v1, :cond_4c

    move-object v10, v0

    check-cast v10, Landroidx/constraintlayout/motion/widget/KeyPositionBase;

    move-object v0, v10

    move v1, p1

    move v2, p2

    move-object v3, v7

    move-object v4, v8

    move v5, p3

    move v6, p4

    invoke-virtual/range {v0 .. v6}, Landroidx/constraintlayout/motion/widget/KeyPositionBase;->intersects(IILandroid/graphics/RectF;Landroid/graphics/RectF;FF)Z

    move-result v0

    if-eqz v0, :cond_4c

    return-object v10

    :cond_6d
    const/4 p1, 0x0

    return-object p1
.end method

.method getPostLayoutDvDp(FIIFF[F)V
    .registers 26
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0,
            0x0,
            0x0,
            0x0
        }
        names = {
            "position",
            "width",
            "height",
            "locationX",
            "locationY",
            "mAnchorDpDt"
        }
    .end annotation

    move-object/from16 v0, p0

    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mVelocity:[F

    move/from16 v2, p1

    invoke-direct {v0, v2, v1}, Landroidx/constraintlayout/motion/widget/MotionController;->getAdjustedPosition(F[F)F

    move-result v1

    iget-object v2, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mAttributesMap:Ljava/util/HashMap;

    const-string v3, "translationX"

    const/4 v4, 0x0

    if-nez v2, :cond_13

    move-object v2, v4

    goto :goto_19

    :cond_13
    invoke-virtual {v2, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/constraintlayout/core/motion/utils/SplineSet;

    :goto_19
    iget-object v5, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mAttributesMap:Ljava/util/HashMap;

    const-string v6, "translationY"

    if-nez v5, :cond_21

    move-object v5, v4

    goto :goto_27

    :cond_21
    invoke-virtual {v5, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/constraintlayout/core/motion/utils/SplineSet;

    :goto_27
    iget-object v7, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mAttributesMap:Ljava/util/HashMap;

    const-string v8, "rotation"

    if-nez v7, :cond_2f

    move-object v7, v4

    goto :goto_35

    :cond_2f
    invoke-virtual {v7, v8}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroidx/constraintlayout/core/motion/utils/SplineSet;

    :goto_35
    iget-object v9, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mAttributesMap:Ljava/util/HashMap;

    const-string v10, "scaleX"

    if-nez v9, :cond_3d

    move-object v9, v4

    goto :goto_43

    :cond_3d
    invoke-virtual {v9, v10}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroidx/constraintlayout/core/motion/utils/SplineSet;

    :goto_43
    iget-object v11, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mAttributesMap:Ljava/util/HashMap;

    const-string v12, "scaleY"

    if-nez v11, :cond_4b

    move-object v11, v4

    goto :goto_51

    :cond_4b
    invoke-virtual {v11, v12}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Landroidx/constraintlayout/core/motion/utils/SplineSet;

    :goto_51
    iget-object v13, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mCycleMap:Ljava/util/HashMap;

    if-nez v13, :cond_57

    move-object v3, v4

    goto :goto_5d

    :cond_57
    invoke-virtual {v13, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/constraintlayout/motion/utils/ViewOscillator;

    :goto_5d
    iget-object v13, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mCycleMap:Ljava/util/HashMap;

    if-nez v13, :cond_63

    move-object v6, v4

    goto :goto_69

    :cond_63
    invoke-virtual {v13, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroidx/constraintlayout/motion/utils/ViewOscillator;

    :goto_69
    iget-object v13, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mCycleMap:Ljava/util/HashMap;

    if-nez v13, :cond_6f

    move-object v8, v4

    goto :goto_75

    :cond_6f
    invoke-virtual {v13, v8}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroidx/constraintlayout/motion/utils/ViewOscillator;

    :goto_75
    iget-object v13, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mCycleMap:Ljava/util/HashMap;

    if-nez v13, :cond_7b

    move-object v10, v4

    goto :goto_81

    :cond_7b
    invoke-virtual {v13, v10}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroidx/constraintlayout/motion/utils/ViewOscillator;

    :goto_81
    iget-object v13, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mCycleMap:Ljava/util/HashMap;

    if-nez v13, :cond_86

    goto :goto_8c

    :cond_86
    invoke-virtual {v13, v12}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/constraintlayout/motion/utils/ViewOscillator;

    :goto_8c
    new-instance v12, Landroidx/constraintlayout/core/motion/utils/VelocityMatrix;

    invoke-direct {v12}, Landroidx/constraintlayout/core/motion/utils/VelocityMatrix;-><init>()V

    invoke-virtual {v12}, Landroidx/constraintlayout/core/motion/utils/VelocityMatrix;->clear()V

    invoke-virtual {v12, v7, v1}, Landroidx/constraintlayout/core/motion/utils/VelocityMatrix;->setRotationVelocity(Landroidx/constraintlayout/core/motion/utils/SplineSet;F)V

    invoke-virtual {v12, v2, v5, v1}, Landroidx/constraintlayout/core/motion/utils/VelocityMatrix;->setTranslationVelocity(Landroidx/constraintlayout/core/motion/utils/SplineSet;Landroidx/constraintlayout/core/motion/utils/SplineSet;F)V

    invoke-virtual {v12, v9, v11, v1}, Landroidx/constraintlayout/core/motion/utils/VelocityMatrix;->setScaleVelocity(Landroidx/constraintlayout/core/motion/utils/SplineSet;Landroidx/constraintlayout/core/motion/utils/SplineSet;F)V

    invoke-virtual {v12, v8, v1}, Landroidx/constraintlayout/core/motion/utils/VelocityMatrix;->setRotationVelocity(Landroidx/constraintlayout/core/motion/utils/KeyCycleOscillator;F)V

    invoke-virtual {v12, v3, v6, v1}, Landroidx/constraintlayout/core/motion/utils/VelocityMatrix;->setTranslationVelocity(Landroidx/constraintlayout/core/motion/utils/KeyCycleOscillator;Landroidx/constraintlayout/core/motion/utils/KeyCycleOscillator;F)V

    invoke-virtual {v12, v10, v4, v1}, Landroidx/constraintlayout/core/motion/utils/VelocityMatrix;->setScaleVelocity(Landroidx/constraintlayout/core/motion/utils/KeyCycleOscillator;Landroidx/constraintlayout/core/motion/utils/KeyCycleOscillator;F)V

    iget-object v13, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mArcSpline:Landroidx/constraintlayout/core/motion/utils/CurveFit;

    if-eqz v13, :cond_da

    iget-object v2, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    array-length v3, v2

    if-lez v3, :cond_cb

    float-to-double v3, v1

    invoke-virtual {v13, v3, v4, v2}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getPos(D[D)V

    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mArcSpline:Landroidx/constraintlayout/core/motion/utils/CurveFit;

    iget-object v2, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVelocity:[D

    invoke-virtual {v1, v3, v4, v2}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getSlope(D[D)V

    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget-object v5, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVariables:[I

    iget-object v6, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVelocity:[D

    iget-object v7, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    move/from16 v2, p4

    move/from16 v3, p5

    move-object/from16 v4, p6

    invoke-virtual/range {v1 .. v7}, Landroidx/constraintlayout/motion/widget/MotionPaths;->setDpDt(FF[F[I[D[D)V

    :cond_cb
    move-object v1, v12

    move/from16 v2, p4

    move/from16 v3, p5

    move/from16 v4, p2

    move/from16 v5, p3

    move-object/from16 v6, p6

    invoke-virtual/range {v1 .. v6}, Landroidx/constraintlayout/core/motion/utils/VelocityMatrix;->applyTransform(FFII[F)V

    return-void

    :cond_da
    iget-object v13, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mSpline:[Landroidx/constraintlayout/core/motion/utils/CurveFit;

    const/4 v14, 0x0

    if-eqz v13, :cond_124

    iget-object v2, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mVelocity:[F

    invoke-direct {v0, v1, v2}, Landroidx/constraintlayout/motion/widget/MotionController;->getAdjustedPosition(F[F)F

    move-result v1

    iget-object v2, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mSpline:[Landroidx/constraintlayout/core/motion/utils/CurveFit;

    aget-object v2, v2, v14

    float-to-double v3, v1

    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVelocity:[D

    invoke-virtual {v2, v3, v4, v1}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getSlope(D[D)V

    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mSpline:[Landroidx/constraintlayout/core/motion/utils/CurveFit;

    aget-object v1, v1, v14

    iget-object v2, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    invoke-virtual {v1, v3, v4, v2}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getPos(D[D)V

    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mVelocity:[F

    aget v1, v1, v14

    :goto_fc
    iget-object v6, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVelocity:[D

    array-length v2, v6

    if-ge v14, v2, :cond_10a

    aget-wide v2, v6, v14

    float-to-double v4, v1

    mul-double/2addr v2, v4

    aput-wide v2, v6, v14

    add-int/lit8 v14, v14, 0x1

    goto :goto_fc

    :cond_10a
    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget-object v5, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVariables:[I

    iget-object v7, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    move/from16 v2, p4

    move/from16 v3, p5

    move-object/from16 v4, p6

    invoke-virtual/range {v1 .. v7}, Landroidx/constraintlayout/motion/widget/MotionPaths;->setDpDt(FF[F[I[D[D)V

    move-object v1, v12

    move/from16 v4, p2

    move/from16 v5, p3

    move-object/from16 v6, p6

    invoke-virtual/range {v1 .. v6}, Landroidx/constraintlayout/core/motion/utils/VelocityMatrix;->applyTransform(FFII[F)V

    return-void

    :cond_124
    iget-object v13, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v13, v13, Landroidx/constraintlayout/motion/widget/MotionPaths;->x:F

    iget-object v15, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v15, v15, Landroidx/constraintlayout/motion/widget/MotionPaths;->x:F

    sub-float/2addr v13, v15

    iget-object v15, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v15, v15, Landroidx/constraintlayout/motion/widget/MotionPaths;->y:F

    iget-object v14, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v14, v14, Landroidx/constraintlayout/motion/widget/MotionPaths;->y:F

    sub-float/2addr v15, v14

    iget-object v14, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v14, v14, Landroidx/constraintlayout/motion/widget/MotionPaths;->width:F

    move-object/from16 v16, v4

    iget-object v4, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v4, v4, Landroidx/constraintlayout/motion/widget/MotionPaths;->width:F

    sub-float/2addr v14, v4

    iget-object v4, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v4, v4, Landroidx/constraintlayout/motion/widget/MotionPaths;->height:F

    move-object/from16 v17, v10

    iget-object v10, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v10, v10, Landroidx/constraintlayout/motion/widget/MotionPaths;->height:F

    sub-float/2addr v4, v10

    add-float/2addr v14, v13

    add-float/2addr v4, v15

    const/high16 v10, 0x3f800000    # 1.0f

    sub-float v18, v10, p4

    mul-float v13, v13, v18

    mul-float v14, v14, p4

    add-float/2addr v13, v14

    const/4 v14, 0x0

    aput v13, p6, v14

    sub-float v10, v10, p5

    mul-float/2addr v15, v10

    mul-float v4, v4, p5

    add-float/2addr v15, v4

    const/4 v4, 0x1

    aput v15, p6, v4

    invoke-virtual {v12}, Landroidx/constraintlayout/core/motion/utils/VelocityMatrix;->clear()V

    invoke-virtual {v12, v7, v1}, Landroidx/constraintlayout/core/motion/utils/VelocityMatrix;->setRotationVelocity(Landroidx/constraintlayout/core/motion/utils/SplineSet;F)V

    invoke-virtual {v12, v2, v5, v1}, Landroidx/constraintlayout/core/motion/utils/VelocityMatrix;->setTranslationVelocity(Landroidx/constraintlayout/core/motion/utils/SplineSet;Landroidx/constraintlayout/core/motion/utils/SplineSet;F)V

    invoke-virtual {v12, v9, v11, v1}, Landroidx/constraintlayout/core/motion/utils/VelocityMatrix;->setScaleVelocity(Landroidx/constraintlayout/core/motion/utils/SplineSet;Landroidx/constraintlayout/core/motion/utils/SplineSet;F)V

    invoke-virtual {v12, v8, v1}, Landroidx/constraintlayout/core/motion/utils/VelocityMatrix;->setRotationVelocity(Landroidx/constraintlayout/core/motion/utils/KeyCycleOscillator;F)V

    invoke-virtual {v12, v3, v6, v1}, Landroidx/constraintlayout/core/motion/utils/VelocityMatrix;->setTranslationVelocity(Landroidx/constraintlayout/core/motion/utils/KeyCycleOscillator;Landroidx/constraintlayout/core/motion/utils/KeyCycleOscillator;F)V

    move-object/from16 v4, v16

    move-object/from16 v10, v17

    invoke-virtual {v12, v10, v4, v1}, Landroidx/constraintlayout/core/motion/utils/VelocityMatrix;->setScaleVelocity(Landroidx/constraintlayout/core/motion/utils/KeyCycleOscillator;Landroidx/constraintlayout/core/motion/utils/KeyCycleOscillator;F)V

    move-object v1, v12

    move/from16 v2, p4

    move/from16 v3, p5

    move/from16 v4, p2

    move/from16 v5, p3

    move-object/from16 v6, p6

    invoke-virtual/range {v1 .. v6}, Landroidx/constraintlayout/core/motion/utils/VelocityMatrix;->applyTransform(FFII[F)V

    return-void
.end method

.method public getStartHeight()F
    .registers 2

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v0, v0, Landroidx/constraintlayout/motion/widget/MotionPaths;->height:F

    return v0
.end method

.method public getStartWidth()F
    .registers 2

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v0, v0, Landroidx/constraintlayout/motion/widget/MotionPaths;->width:F

    return v0
.end method

.method public getStartX()F
    .registers 2

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v0, v0, Landroidx/constraintlayout/motion/widget/MotionPaths;->x:F

    return v0
.end method

.method public getStartY()F
    .registers 2

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v0, v0, Landroidx/constraintlayout/motion/widget/MotionPaths;->y:F

    return v0
.end method

.method public getTransformPivotTarget()I
    .registers 2

    iget v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mTransformPivotTarget:I

    return v0
.end method

.method public getView()Landroid/view/View;
    .registers 2

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mView:Landroid/view/View;

    return-object v0
.end method

.method interpolate(Landroid/view/View;FJLandroidx/constraintlayout/core/motion/utils/KeyCache;)Z
    .registers 26
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0,
            0x0
        }
        names = {
            "child",
            "global_position",
            "time",
            "keyCache"
        }
    .end annotation

    move-object/from16 v0, p0

    move-object/from16 v11, p1

    const/4 v1, 0x0

    move/from16 v2, p2

    invoke-direct {v0, v2, v1}, Landroidx/constraintlayout/motion/widget/MotionController;->getAdjustedPosition(F[F)F

    move-result v2

    iget v3, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mQuantizeMotionSteps:I

    sget v4, Landroidx/constraintlayout/motion/widget/Key;->UNSET:I

    const/high16 v13, 0x3f800000    # 1.0f

    if-eq v3, v4, :cond_44

    iget v3, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mQuantizeMotionSteps:I

    int-to-float v3, v3

    div-float v3, v13, v3

    div-float v4, v2, v3

    float-to-double v4, v4

    invoke-static {v4, v5}, Ljava/lang/Math;->floor(D)D

    move-result-wide v4

    double-to-float v4, v4

    mul-float/2addr v4, v3

    rem-float/2addr v2, v3

    div-float/2addr v2, v3

    iget v5, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mQuantizeMotionPhase:F

    invoke-static {v5}, Ljava/lang/Float;->isNaN(F)Z

    move-result v5

    if-nez v5, :cond_2f

    iget v5, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mQuantizeMotionPhase:F

    add-float/2addr v2, v5

    rem-float/2addr v2, v13

    :cond_2f
    iget-object v5, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mQuantizeMotionInterpolator:Landroid/view/animation/Interpolator;

    if-eqz v5, :cond_38

    invoke-interface {v5, v2}, Landroid/view/animation/Interpolator;->getInterpolation(F)F

    move-result v2

    goto :goto_42

    :cond_38
    float-to-double v5, v2

    const-wide/high16 v7, 0x3fe0000000000000L    # 0.5

    cmpl-double v2, v5, v7

    if-lez v2, :cond_41

    move v2, v13

    goto :goto_42

    :cond_41
    const/4 v2, 0x0

    :goto_42
    mul-float/2addr v2, v3

    add-float/2addr v2, v4

    :cond_44
    move v14, v2

    iget-object v2, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mAttributesMap:Ljava/util/HashMap;

    if-eqz v2, :cond_61

    invoke-virtual {v2}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_51
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_61

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/constraintlayout/motion/utils/ViewSpline;

    invoke-virtual {v3, v11, v14}, Landroidx/constraintlayout/motion/utils/ViewSpline;->setProperty(Landroid/view/View;F)V

    goto :goto_51

    :cond_61
    iget-object v2, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mTimeCycleAttributesMap:Ljava/util/HashMap;

    const/4 v15, 0x0

    if-eqz v2, :cond_95

    invoke-virtual {v2}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v7

    move-object v8, v1

    move v9, v15

    :goto_70
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_91

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/constraintlayout/motion/utils/ViewTimeCycle;

    instance-of v2, v1, Landroidx/constraintlayout/motion/utils/ViewTimeCycle$PathRotate;

    if-eqz v2, :cond_84

    move-object v8, v1

    check-cast v8, Landroidx/constraintlayout/motion/utils/ViewTimeCycle$PathRotate;

    goto :goto_70

    :cond_84
    move-object/from16 v2, p1

    move v3, v14

    move-wide/from16 v4, p3

    move-object/from16 v6, p5

    invoke-virtual/range {v1 .. v6}, Landroidx/constraintlayout/motion/utils/ViewTimeCycle;->setProperty(Landroid/view/View;FJLandroidx/constraintlayout/core/motion/utils/KeyCache;)Z

    move-result v1

    or-int/2addr v9, v1

    goto :goto_70

    :cond_91
    move/from16 v16, v9

    move-object v9, v8

    goto :goto_98

    :cond_95
    move-object v9, v1

    move/from16 v16, v15

    :goto_98
    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mSpline:[Landroidx/constraintlayout/core/motion/utils/CurveFit;

    const/4 v10, 0x1

    if-eqz v1, :cond_1f7

    aget-object v1, v1, v15

    float-to-double v7, v14

    iget-object v2, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    invoke-virtual {v1, v7, v8, v2}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getPos(D[D)V

    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mSpline:[Landroidx/constraintlayout/core/motion/utils/CurveFit;

    aget-object v1, v1, v15

    iget-object v2, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVelocity:[D

    invoke-virtual {v1, v7, v8, v2}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getSlope(D[D)V

    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mArcSpline:Landroidx/constraintlayout/core/motion/utils/CurveFit;

    if-eqz v1, :cond_c1

    iget-object v2, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    array-length v3, v2

    if-lez v3, :cond_c1

    invoke-virtual {v1, v7, v8, v2}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getPos(D[D)V

    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mArcSpline:Landroidx/constraintlayout/core/motion/utils/CurveFit;

    iget-object v2, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVelocity:[D

    invoke-virtual {v1, v7, v8, v2}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getSlope(D[D)V

    :cond_c1
    iget-boolean v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mNoMovement:Z

    if-nez v1, :cond_e1

    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget-object v4, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVariables:[I

    iget-object v5, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    iget-object v6, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVelocity:[D

    const/16 v17, 0x0

    iget-boolean v3, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mForceMeasure:Z

    move v2, v14

    move/from16 v18, v3

    move-object/from16 v3, p1

    move-wide v12, v7

    move-object/from16 v7, v17

    move/from16 v8, v18

    invoke-virtual/range {v1 .. v8}, Landroidx/constraintlayout/motion/widget/MotionPaths;->setView(FLandroid/view/View;[I[D[D[DZ)V

    iput-boolean v15, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mForceMeasure:Z

    goto :goto_e2

    :cond_e1
    move-wide v12, v7

    :goto_e2
    iget v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mTransformPivotTarget:I

    sget v2, Landroidx/constraintlayout/motion/widget/Key;->UNSET:I

    if-eq v1, v2, :cond_144

    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mTransformPivotView:Landroid/view/View;

    if-nez v1, :cond_fa

    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    check-cast v1, Landroid/view/View;

    iget v2, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mTransformPivotTarget:I

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mTransformPivotView:Landroid/view/View;

    :cond_fa
    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mTransformPivotView:Landroid/view/View;

    if-eqz v1, :cond_144

    invoke-virtual {v1}, Landroid/view/View;->getTop()I

    move-result v1

    iget-object v2, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mTransformPivotView:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getBottom()I

    move-result v2

    add-int/2addr v1, v2

    int-to-float v1, v1

    const/high16 v2, 0x40000000    # 2.0f

    div-float/2addr v1, v2

    iget-object v3, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mTransformPivotView:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getLeft()I

    move-result v3

    iget-object v4, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mTransformPivotView:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getRight()I

    move-result v4

    add-int/2addr v3, v4

    int-to-float v3, v3

    div-float/2addr v3, v2

    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getRight()I

    move-result v2

    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getLeft()I

    move-result v4

    sub-int/2addr v2, v4

    if-lez v2, :cond_144

    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getBottom()I

    move-result v2

    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getTop()I

    move-result v4

    sub-int/2addr v2, v4

    if-lez v2, :cond_144

    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getLeft()I

    move-result v2

    int-to-float v2, v2

    sub-float/2addr v3, v2

    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getTop()I

    move-result v2

    int-to-float v2, v2

    sub-float/2addr v1, v2

    invoke-virtual {v11, v3}, Landroid/view/View;->setPivotX(F)V

    invoke-virtual {v11, v1}, Landroid/view/View;->setPivotY(F)V

    :cond_144
    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mAttributesMap:Ljava/util/HashMap;

    if-eqz v1, :cond_172

    invoke-virtual {v1}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :cond_150
    :goto_150
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_172

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/constraintlayout/core/motion/utils/SplineSet;

    instance-of v2, v1, Landroidx/constraintlayout/motion/utils/ViewSpline$PathRotate;

    if-eqz v2, :cond_150

    iget-object v2, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVelocity:[D

    array-length v3, v2

    if-le v3, v10, :cond_150

    check-cast v1, Landroidx/constraintlayout/motion/utils/ViewSpline$PathRotate;

    aget-wide v4, v2, v15

    aget-wide v6, v2, v10

    move-object/from16 v2, p1

    move v3, v14

    invoke-virtual/range {v1 .. v7}, Landroidx/constraintlayout/motion/utils/ViewSpline$PathRotate;->setPathRotate(Landroid/view/View;FDD)V

    goto :goto_150

    :cond_172
    if-eqz v9, :cond_18f

    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVelocity:[D

    aget-wide v7, v1, v15

    aget-wide v17, v1, v10

    move-object v1, v9

    move-object/from16 v2, p1

    move-object/from16 v3, p5

    move v4, v14

    move-wide/from16 v5, p3

    move/from16 v19, v10

    move-wide/from16 v9, v17

    invoke-virtual/range {v1 .. v10}, Landroidx/constraintlayout/motion/utils/ViewTimeCycle$PathRotate;->setPathRotate(Landroid/view/View;Landroidx/constraintlayout/core/motion/utils/KeyCache;FJDD)Z

    move-result v1

    or-int v1, v16, v1

    move/from16 v16, v1

    goto :goto_191

    :cond_18f
    move/from16 v19, v10

    :goto_191
    move/from16 v10, v19

    :goto_193
    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mSpline:[Landroidx/constraintlayout/core/motion/utils/CurveFit;

    array-length v2, v1

    if-ge v10, v2, :cond_1b7

    aget-object v1, v1, v10

    iget-object v2, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mValuesBuff:[F

    invoke-virtual {v1, v12, v13, v2}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getPos(D[F)V

    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget-object v1, v1, Landroidx/constraintlayout/motion/widget/MotionPaths;->attributes:Ljava/util/LinkedHashMap;

    iget-object v2, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mAttributeNames:[Ljava/lang/String;

    add-int/lit8 v3, v10, -0x1

    aget-object v2, v2, v3

    invoke-virtual {v1, v2}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/constraintlayout/widget/ConstraintAttribute;

    iget-object v2, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mValuesBuff:[F

    invoke-static {v1, v11, v2}, Landroidx/constraintlayout/motion/utils/CustomSupport;->setInterpolatedValue(Landroidx/constraintlayout/widget/ConstraintAttribute;Landroid/view/View;[F)V

    add-int/lit8 v10, v10, 0x1

    goto :goto_193

    :cond_1b7
    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartPoint:Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;

    iget v1, v1, Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;->mVisibilityMode:I

    if-nez v1, :cond_1e5

    const/4 v1, 0x0

    cmpg-float v1, v14, v1

    if-gtz v1, :cond_1ca

    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartPoint:Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;

    iget v1, v1, Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;->visibility:I

    invoke-virtual {v11, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_1e5

    :cond_1ca
    const/high16 v1, 0x3f800000    # 1.0f

    cmpl-float v1, v14, v1

    if-ltz v1, :cond_1d8

    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndPoint:Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;

    iget v1, v1, Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;->visibility:I

    invoke-virtual {v11, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_1e5

    :cond_1d8
    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndPoint:Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;

    iget v1, v1, Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;->visibility:I

    iget-object v2, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartPoint:Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;

    iget v2, v2, Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;->visibility:I

    if-eq v1, v2, :cond_1e5

    invoke-virtual {v11, v15}, Landroid/view/View;->setVisibility(I)V

    :cond_1e5
    :goto_1e5
    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mKeyTriggers:[Landroidx/constraintlayout/motion/widget/KeyTrigger;

    if-eqz v1, :cond_271

    move v1, v15

    :goto_1ea
    iget-object v2, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mKeyTriggers:[Landroidx/constraintlayout/motion/widget/KeyTrigger;

    array-length v3, v2

    if-ge v1, v3, :cond_271

    aget-object v2, v2, v1

    invoke-virtual {v2, v14, v11}, Landroidx/constraintlayout/motion/widget/KeyTrigger;->conditionallyFire(FLandroid/view/View;)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_1ea

    :cond_1f7
    move/from16 v19, v10

    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v1, v1, Landroidx/constraintlayout/motion/widget/MotionPaths;->x:F

    iget-object v2, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v2, v2, Landroidx/constraintlayout/motion/widget/MotionPaths;->x:F

    iget-object v3, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v3, v3, Landroidx/constraintlayout/motion/widget/MotionPaths;->x:F

    sub-float/2addr v2, v3

    mul-float/2addr v2, v14

    add-float/2addr v1, v2

    iget-object v2, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v2, v2, Landroidx/constraintlayout/motion/widget/MotionPaths;->y:F

    iget-object v3, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v3, v3, Landroidx/constraintlayout/motion/widget/MotionPaths;->y:F

    iget-object v4, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v4, v4, Landroidx/constraintlayout/motion/widget/MotionPaths;->y:F

    sub-float/2addr v3, v4

    mul-float/2addr v3, v14

    add-float/2addr v2, v3

    iget-object v3, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v3, v3, Landroidx/constraintlayout/motion/widget/MotionPaths;->width:F

    iget-object v4, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v4, v4, Landroidx/constraintlayout/motion/widget/MotionPaths;->width:F

    iget-object v5, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v5, v5, Landroidx/constraintlayout/motion/widget/MotionPaths;->width:F

    sub-float/2addr v4, v5

    mul-float/2addr v4, v14

    add-float/2addr v3, v4

    iget-object v4, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v4, v4, Landroidx/constraintlayout/motion/widget/MotionPaths;->height:F

    iget-object v5, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v5, v5, Landroidx/constraintlayout/motion/widget/MotionPaths;->height:F

    iget-object v6, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v6, v6, Landroidx/constraintlayout/motion/widget/MotionPaths;->height:F

    sub-float/2addr v5, v6

    mul-float/2addr v5, v14

    add-float/2addr v4, v5

    const/high16 v5, 0x3f000000    # 0.5f

    add-float/2addr v1, v5

    float-to-int v6, v1

    add-float/2addr v2, v5

    float-to-int v5, v2

    add-float/2addr v1, v3

    float-to-int v1, v1

    add-float/2addr v2, v4

    float-to-int v2, v2

    sub-int v3, v1, v6

    sub-int v4, v2, v5

    iget-object v7, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v7, v7, Landroidx/constraintlayout/motion/widget/MotionPaths;->width:F

    iget-object v8, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v8, v8, Landroidx/constraintlayout/motion/widget/MotionPaths;->width:F

    cmpl-float v7, v7, v8

    if-nez v7, :cond_25f

    iget-object v7, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v7, v7, Landroidx/constraintlayout/motion/widget/MotionPaths;->height:F

    iget-object v8, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v8, v8, Landroidx/constraintlayout/motion/widget/MotionPaths;->height:F

    cmpl-float v7, v7, v8

    if-nez v7, :cond_25f

    iget-boolean v7, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mForceMeasure:Z

    if-eqz v7, :cond_26e

    :cond_25f
    const/high16 v7, 0x40000000    # 2.0f

    invoke-static {v3, v7}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v3

    invoke-static {v4, v7}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v4

    invoke-virtual {v11, v3, v4}, Landroid/view/View;->measure(II)V

    iput-boolean v15, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mForceMeasure:Z

    :cond_26e
    invoke-virtual {v11, v6, v5, v1, v2}, Landroid/view/View;->layout(IIII)V

    :cond_271
    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mCycleMap:Ljava/util/HashMap;

    if-eqz v1, :cond_2a0

    invoke-virtual {v1}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :goto_27d
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_2a0

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/constraintlayout/motion/utils/ViewOscillator;

    instance-of v2, v1, Landroidx/constraintlayout/motion/utils/ViewOscillator$PathRotateSet;

    if-eqz v2, :cond_29c

    check-cast v1, Landroidx/constraintlayout/motion/utils/ViewOscillator$PathRotateSet;

    iget-object v2, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVelocity:[D

    aget-wide v4, v2, v15

    aget-wide v6, v2, v19

    move-object/from16 v2, p1

    move v3, v14

    invoke-virtual/range {v1 .. v7}, Landroidx/constraintlayout/motion/utils/ViewOscillator$PathRotateSet;->setPathRotate(Landroid/view/View;FDD)V

    goto :goto_27d

    :cond_29c
    invoke-virtual {v1, v11, v14}, Landroidx/constraintlayout/motion/utils/ViewOscillator;->setProperty(Landroid/view/View;F)V

    goto :goto_27d

    :cond_2a0
    return v16
.end method

.method name()Ljava/lang/String;
    .registers 3

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    iget-object v1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getId()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getResourceEntryName(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method positionKeyframe(Landroid/view/View;Landroidx/constraintlayout/motion/widget/KeyPositionBase;FF[Ljava/lang/String;[F)V
    .registers 15
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0,
            0x0,
            0x0,
            0x0
        }
        names = {
            "view",
            "key",
            "x",
            "y",
            "attribute",
            "value"
        }
    .end annotation

    new-instance v2, Landroid/graphics/RectF;

    invoke-direct {v2}, Landroid/graphics/RectF;-><init>()V

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v0, v0, Landroidx/constraintlayout/motion/widget/MotionPaths;->x:F

    iput v0, v2, Landroid/graphics/RectF;->left:F

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v0, v0, Landroidx/constraintlayout/motion/widget/MotionPaths;->y:F

    iput v0, v2, Landroid/graphics/RectF;->top:F

    iget v0, v2, Landroid/graphics/RectF;->left:F

    iget-object v1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v1, v1, Landroidx/constraintlayout/motion/widget/MotionPaths;->width:F

    add-float/2addr v0, v1

    iput v0, v2, Landroid/graphics/RectF;->right:F

    iget v0, v2, Landroid/graphics/RectF;->top:F

    iget-object v1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v1, v1, Landroidx/constraintlayout/motion/widget/MotionPaths;->height:F

    add-float/2addr v0, v1

    iput v0, v2, Landroid/graphics/RectF;->bottom:F

    new-instance v3, Landroid/graphics/RectF;

    invoke-direct {v3}, Landroid/graphics/RectF;-><init>()V

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v0, v0, Landroidx/constraintlayout/motion/widget/MotionPaths;->x:F

    iput v0, v3, Landroid/graphics/RectF;->left:F

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v0, v0, Landroidx/constraintlayout/motion/widget/MotionPaths;->y:F

    iput v0, v3, Landroid/graphics/RectF;->top:F

    iget v0, v3, Landroid/graphics/RectF;->left:F

    iget-object v1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v1, v1, Landroidx/constraintlayout/motion/widget/MotionPaths;->width:F

    add-float/2addr v0, v1

    iput v0, v3, Landroid/graphics/RectF;->right:F

    iget v0, v3, Landroid/graphics/RectF;->top:F

    iget-object v1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v1, v1, Landroidx/constraintlayout/motion/widget/MotionPaths;->height:F

    add-float/2addr v0, v1

    iput v0, v3, Landroid/graphics/RectF;->bottom:F

    move-object v0, p2

    move-object v1, p1

    move v4, p3

    move v5, p4

    move-object v6, p5

    move-object v7, p6

    invoke-virtual/range {v0 .. v7}, Landroidx/constraintlayout/motion/widget/KeyPositionBase;->positionAttributes(Landroid/view/View;Landroid/graphics/RectF;Landroid/graphics/RectF;FF[Ljava/lang/String;[F)V

    return-void
.end method

.method public remeasure()V
    .registers 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mForceMeasure:Z

    return-void
.end method

.method rotate(Landroid/graphics/Rect;Landroid/graphics/Rect;III)V
    .registers 8
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0,
            0x0,
            0x0
        }
        names = {
            "rect",
            "out",
            "rotation",
            "preHeight",
            "preWidth"
        }
    .end annotation

    const/4 v0, 0x1

    const/4 v1, 0x2

    if-eq p3, v0, :cond_9d

    if-eq p3, v1, :cond_6f

    const/4 v0, 0x3

    if-eq p3, v0, :cond_3d

    const/4 p5, 0x4

    if-eq p3, p5, :cond_e

    goto/16 :goto_ca

    :cond_e
    iget p3, p1, Landroid/graphics/Rect;->left:I

    iget p5, p1, Landroid/graphics/Rect;->right:I

    add-int/2addr p3, p5

    iget p5, p1, Landroid/graphics/Rect;->bottom:I

    iget v0, p1, Landroid/graphics/Rect;->top:I

    add-int/2addr p5, v0

    invoke-virtual {p1}, Landroid/graphics/Rect;->width()I

    move-result v0

    add-int/2addr p5, v0

    div-int/2addr p5, v1

    sub-int/2addr p4, p5

    iput p4, p2, Landroid/graphics/Rect;->left:I

    invoke-virtual {p1}, Landroid/graphics/Rect;->height()I

    move-result p4

    sub-int/2addr p3, p4

    div-int/2addr p3, v1

    iput p3, p2, Landroid/graphics/Rect;->top:I

    iget p3, p2, Landroid/graphics/Rect;->left:I

    invoke-virtual {p1}, Landroid/graphics/Rect;->width()I

    move-result p4

    add-int/2addr p3, p4

    iput p3, p2, Landroid/graphics/Rect;->right:I

    iget p3, p2, Landroid/graphics/Rect;->top:I

    invoke-virtual {p1}, Landroid/graphics/Rect;->height()I

    move-result p1

    add-int/2addr p3, p1

    iput p3, p2, Landroid/graphics/Rect;->bottom:I

    goto/16 :goto_ca

    :cond_3d
    iget p3, p1, Landroid/graphics/Rect;->left:I

    iget p4, p1, Landroid/graphics/Rect;->right:I

    add-int/2addr p3, p4

    iget p4, p1, Landroid/graphics/Rect;->top:I

    iget p4, p1, Landroid/graphics/Rect;->bottom:I

    invoke-virtual {p1}, Landroid/graphics/Rect;->height()I

    move-result p4

    div-int/2addr p4, v1

    iget v0, p1, Landroid/graphics/Rect;->top:I

    add-int/2addr p4, v0

    div-int/lit8 v0, p3, 0x2

    sub-int/2addr p4, v0

    iput p4, p2, Landroid/graphics/Rect;->left:I

    invoke-virtual {p1}, Landroid/graphics/Rect;->height()I

    move-result p4

    add-int/2addr p3, p4

    div-int/2addr p3, v1

    sub-int/2addr p5, p3

    iput p5, p2, Landroid/graphics/Rect;->top:I

    iget p3, p2, Landroid/graphics/Rect;->left:I

    invoke-virtual {p1}, Landroid/graphics/Rect;->width()I

    move-result p4

    add-int/2addr p3, p4

    iput p3, p2, Landroid/graphics/Rect;->right:I

    iget p3, p2, Landroid/graphics/Rect;->top:I

    invoke-virtual {p1}, Landroid/graphics/Rect;->height()I

    move-result p1

    add-int/2addr p3, p1

    iput p3, p2, Landroid/graphics/Rect;->bottom:I

    goto :goto_ca

    :cond_6f
    iget p3, p1, Landroid/graphics/Rect;->left:I

    iget p5, p1, Landroid/graphics/Rect;->right:I

    add-int/2addr p3, p5

    iget p5, p1, Landroid/graphics/Rect;->top:I

    iget v0, p1, Landroid/graphics/Rect;->bottom:I

    add-int/2addr p5, v0

    invoke-virtual {p1}, Landroid/graphics/Rect;->width()I

    move-result v0

    add-int/2addr p5, v0

    div-int/2addr p5, v1

    sub-int/2addr p4, p5

    iput p4, p2, Landroid/graphics/Rect;->left:I

    invoke-virtual {p1}, Landroid/graphics/Rect;->height()I

    move-result p4

    sub-int/2addr p3, p4

    div-int/2addr p3, v1

    iput p3, p2, Landroid/graphics/Rect;->top:I

    iget p3, p2, Landroid/graphics/Rect;->left:I

    invoke-virtual {p1}, Landroid/graphics/Rect;->width()I

    move-result p4

    add-int/2addr p3, p4

    iput p3, p2, Landroid/graphics/Rect;->right:I

    iget p3, p2, Landroid/graphics/Rect;->top:I

    invoke-virtual {p1}, Landroid/graphics/Rect;->height()I

    move-result p1

    add-int/2addr p3, p1

    iput p3, p2, Landroid/graphics/Rect;->bottom:I

    goto :goto_ca

    :cond_9d
    iget p3, p1, Landroid/graphics/Rect;->left:I

    iget p4, p1, Landroid/graphics/Rect;->right:I

    add-int/2addr p3, p4

    iget p4, p1, Landroid/graphics/Rect;->top:I

    iget v0, p1, Landroid/graphics/Rect;->bottom:I

    add-int/2addr p4, v0

    invoke-virtual {p1}, Landroid/graphics/Rect;->width()I

    move-result v0

    sub-int/2addr p4, v0

    div-int/2addr p4, v1

    iput p4, p2, Landroid/graphics/Rect;->left:I

    invoke-virtual {p1}, Landroid/graphics/Rect;->height()I

    move-result p4

    add-int/2addr p3, p4

    div-int/2addr p3, v1

    sub-int/2addr p5, p3

    iput p5, p2, Landroid/graphics/Rect;->top:I

    iget p3, p2, Landroid/graphics/Rect;->left:I

    invoke-virtual {p1}, Landroid/graphics/Rect;->width()I

    move-result p4

    add-int/2addr p3, p4

    iput p3, p2, Landroid/graphics/Rect;->right:I

    iget p3, p2, Landroid/graphics/Rect;->top:I

    invoke-virtual {p1}, Landroid/graphics/Rect;->height()I

    move-result p1

    add-int/2addr p3, p1

    iput p3, p2, Landroid/graphics/Rect;->bottom:I

    :goto_ca
    return-void
.end method

.method setBothStates(Landroid/view/View;)V
    .registers 7
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "v"
        }
    .end annotation

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    const/4 v1, 0x0

    iput v1, v0, Landroidx/constraintlayout/motion/widget/MotionPaths;->time:F

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iput v1, v0, Landroidx/constraintlayout/motion/widget/MotionPaths;->position:F

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mNoMovement:Z

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    invoke-virtual {p1}, Landroid/view/View;->getX()F

    move-result v1

    invoke-virtual {p1}, Landroid/view/View;->getY()F

    move-result v2

    invoke-virtual {p1}, Landroid/view/View;->getWidth()I

    move-result v3

    int-to-float v3, v3

    invoke-virtual {p1}, Landroid/view/View;->getHeight()I

    move-result v4

    int-to-float v4, v4

    invoke-virtual {v0, v1, v2, v3, v4}, Landroidx/constraintlayout/motion/widget/MotionPaths;->setBounds(FFFF)V

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    invoke-virtual {p1}, Landroid/view/View;->getX()F

    move-result v1

    invoke-virtual {p1}, Landroid/view/View;->getY()F

    move-result v2

    invoke-virtual {p1}, Landroid/view/View;->getWidth()I

    move-result v3

    int-to-float v3, v3

    invoke-virtual {p1}, Landroid/view/View;->getHeight()I

    move-result v4

    int-to-float v4, v4

    invoke-virtual {v0, v1, v2, v3, v4}, Landroidx/constraintlayout/motion/widget/MotionPaths;->setBounds(FFFF)V

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartPoint:Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;

    invoke-virtual {v0, p1}, Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;->setState(Landroid/view/View;)V

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndPoint:Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;

    invoke-virtual {v0, p1}, Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;->setState(Landroid/view/View;)V

    return-void
.end method

.method public setDrawPath(I)V
    .registers 3
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "debugMode"
        }
    .end annotation

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iput p1, v0, Landroidx/constraintlayout/motion/widget/MotionPaths;->mDrawPath:I

    return-void
.end method

.method setEndState(Landroid/graphics/Rect;Landroidx/constraintlayout/widget/ConstraintSet;II)V
    .registers 12
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0,
            0x0
        }
        names = {
            "cw",
            "constraintSet",
            "parentWidth",
            "parentHeight"
        }
    .end annotation

    iget v6, p2, Landroidx/constraintlayout/widget/ConstraintSet;->mRotate:I

    if-eqz v6, :cond_10

    iget-object v2, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mTempRect:Landroid/graphics/Rect;

    move-object v0, p0

    move-object v1, p1

    move v3, v6

    move v4, p3

    move v5, p4

    invoke-virtual/range {v0 .. v5}, Landroidx/constraintlayout/motion/widget/MotionController;->rotate(Landroid/graphics/Rect;Landroid/graphics/Rect;III)V

    iget-object p1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mTempRect:Landroid/graphics/Rect;

    :cond_10
    iget-object p3, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    const/high16 p4, 0x3f800000    # 1.0f

    iput p4, p3, Landroidx/constraintlayout/motion/widget/MotionPaths;->time:F

    iget-object p3, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iput p4, p3, Landroidx/constraintlayout/motion/widget/MotionPaths;->position:F

    iget-object p3, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    invoke-direct {p0, p3}, Landroidx/constraintlayout/motion/widget/MotionController;->readView(Landroidx/constraintlayout/motion/widget/MotionPaths;)V

    iget-object p3, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget p4, p1, Landroid/graphics/Rect;->left:I

    int-to-float p4, p4

    iget v0, p1, Landroid/graphics/Rect;->top:I

    int-to-float v0, v0

    invoke-virtual {p1}, Landroid/graphics/Rect;->width()I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {p1}, Landroid/graphics/Rect;->height()I

    move-result v2

    int-to-float v2, v2

    invoke-virtual {p3, p4, v0, v1, v2}, Landroidx/constraintlayout/motion/widget/MotionPaths;->setBounds(FFFF)V

    iget-object p3, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget p4, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mId:I

    invoke-virtual {p2, p4}, Landroidx/constraintlayout/widget/ConstraintSet;->getParameters(I)Landroidx/constraintlayout/widget/ConstraintSet$Constraint;

    move-result-object p4

    invoke-virtual {p3, p4}, Landroidx/constraintlayout/motion/widget/MotionPaths;->applyParameters(Landroidx/constraintlayout/widget/ConstraintSet$Constraint;)V

    iget-object p3, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndPoint:Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;

    iget p4, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mId:I

    invoke-virtual {p3, p1, p2, v6, p4}, Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;->setState(Landroid/graphics/Rect;Landroidx/constraintlayout/widget/ConstraintSet;II)V

    return-void
.end method

.method public setPathMotionArc(I)V
    .registers 2
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "arc"
        }
    .end annotation

    iput p1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mPathMotionArc:I

    return-void
.end method

.method setStartCurrentState(Landroid/view/View;)V
    .registers 7
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "v"
        }
    .end annotation

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    const/4 v1, 0x0

    iput v1, v0, Landroidx/constraintlayout/motion/widget/MotionPaths;->time:F

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iput v1, v0, Landroidx/constraintlayout/motion/widget/MotionPaths;->position:F

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    invoke-virtual {p1}, Landroid/view/View;->getX()F

    move-result v1

    invoke-virtual {p1}, Landroid/view/View;->getY()F

    move-result v2

    invoke-virtual {p1}, Landroid/view/View;->getWidth()I

    move-result v3

    int-to-float v3, v3

    invoke-virtual {p1}, Landroid/view/View;->getHeight()I

    move-result v4

    int-to-float v4, v4

    invoke-virtual {v0, v1, v2, v3, v4}, Landroidx/constraintlayout/motion/widget/MotionPaths;->setBounds(FFFF)V

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartPoint:Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;

    invoke-virtual {v0, p1}, Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;->setState(Landroid/view/View;)V

    return-void
.end method

.method setStartState(Landroid/graphics/Rect;Landroidx/constraintlayout/widget/ConstraintSet;II)V
    .registers 12
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0,
            0x0
        }
        names = {
            "cw",
            "constraintSet",
            "parentWidth",
            "parentHeight"
        }
    .end annotation

    iget v6, p2, Landroidx/constraintlayout/widget/ConstraintSet;->mRotate:I

    if-eqz v6, :cond_e

    iget-object v2, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mTempRect:Landroid/graphics/Rect;

    move-object v0, p0

    move-object v1, p1

    move v3, v6

    move v4, p3

    move v5, p4

    invoke-virtual/range {v0 .. v5}, Landroidx/constraintlayout/motion/widget/MotionController;->rotate(Landroid/graphics/Rect;Landroid/graphics/Rect;III)V

    :cond_e
    iget-object p3, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    const/4 p4, 0x0

    iput p4, p3, Landroidx/constraintlayout/motion/widget/MotionPaths;->time:F

    iget-object p3, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iput p4, p3, Landroidx/constraintlayout/motion/widget/MotionPaths;->position:F

    iget-object p3, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    invoke-direct {p0, p3}, Landroidx/constraintlayout/motion/widget/MotionController;->readView(Landroidx/constraintlayout/motion/widget/MotionPaths;)V

    iget-object p3, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget p4, p1, Landroid/graphics/Rect;->left:I

    int-to-float p4, p4

    iget v0, p1, Landroid/graphics/Rect;->top:I

    int-to-float v0, v0

    invoke-virtual {p1}, Landroid/graphics/Rect;->width()I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {p1}, Landroid/graphics/Rect;->height()I

    move-result v2

    int-to-float v2, v2

    invoke-virtual {p3, p4, v0, v1, v2}, Landroidx/constraintlayout/motion/widget/MotionPaths;->setBounds(FFFF)V

    iget p3, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mId:I

    invoke-virtual {p2, p3}, Landroidx/constraintlayout/widget/ConstraintSet;->getParameters(I)Landroidx/constraintlayout/widget/ConstraintSet$Constraint;

    move-result-object p3

    iget-object p4, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    invoke-virtual {p4, p3}, Landroidx/constraintlayout/motion/widget/MotionPaths;->applyParameters(Landroidx/constraintlayout/widget/ConstraintSet$Constraint;)V

    iget-object p4, p3, Landroidx/constraintlayout/widget/ConstraintSet$Constraint;->motion:Landroidx/constraintlayout/widget/ConstraintSet$Motion;

    iget p4, p4, Landroidx/constraintlayout/widget/ConstraintSet$Motion;->mMotionStagger:F

    iput p4, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mMotionStagger:F

    iget-object p4, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartPoint:Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;

    iget v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mId:I

    invoke-virtual {p4, p1, p2, v6, v0}, Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;->setState(Landroid/graphics/Rect;Landroidx/constraintlayout/widget/ConstraintSet;II)V

    iget-object p1, p3, Landroidx/constraintlayout/widget/ConstraintSet$Constraint;->transform:Landroidx/constraintlayout/widget/ConstraintSet$Transform;

    iget p1, p1, Landroidx/constraintlayout/widget/ConstraintSet$Transform;->transformPivotTarget:I

    iput p1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mTransformPivotTarget:I

    iget-object p1, p3, Landroidx/constraintlayout/widget/ConstraintSet$Constraint;->motion:Landroidx/constraintlayout/widget/ConstraintSet$Motion;

    iget p1, p1, Landroidx/constraintlayout/widget/ConstraintSet$Motion;->mQuantizeMotionSteps:I

    iput p1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mQuantizeMotionSteps:I

    iget-object p1, p3, Landroidx/constraintlayout/widget/ConstraintSet$Constraint;->motion:Landroidx/constraintlayout/widget/ConstraintSet$Motion;

    iget p1, p1, Landroidx/constraintlayout/widget/ConstraintSet$Motion;->mQuantizeMotionPhase:F

    iput p1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mQuantizeMotionPhase:F

    iget-object p1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mView:Landroid/view/View;

    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object p1

    iget-object p2, p3, Landroidx/constraintlayout/widget/ConstraintSet$Constraint;->motion:Landroidx/constraintlayout/widget/ConstraintSet$Motion;

    iget p2, p2, Landroidx/constraintlayout/widget/ConstraintSet$Motion;->mQuantizeInterpolatorType:I

    iget-object p4, p3, Landroidx/constraintlayout/widget/ConstraintSet$Constraint;->motion:Landroidx/constraintlayout/widget/ConstraintSet$Motion;

    iget-object p4, p4, Landroidx/constraintlayout/widget/ConstraintSet$Motion;->mQuantizeInterpolatorString:Ljava/lang/String;

    iget-object p3, p3, Landroidx/constraintlayout/widget/ConstraintSet$Constraint;->motion:Landroidx/constraintlayout/widget/ConstraintSet$Motion;

    iget p3, p3, Landroidx/constraintlayout/widget/ConstraintSet$Motion;->mQuantizeInterpolatorID:I

    invoke-static {p1, p2, p4, p3}, Landroidx/constraintlayout/motion/widget/MotionController;->getInterpolator(Landroid/content/Context;ILjava/lang/String;I)Landroid/view/animation/Interpolator;

    move-result-object p1

    iput-object p1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mQuantizeMotionInterpolator:Landroid/view/animation/Interpolator;

    return-void
.end method

.method public setStartState(Landroidx/constraintlayout/motion/utils/ViewState;Landroid/view/View;III)V
    .registers 10
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0,
            0x0,
            0x0
        }
        names = {
            "rect",
            "v",
            "rotation",
            "preWidth",
            "preHeight"
        }
    .end annotation

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    const/4 v1, 0x0

    iput v1, v0, Landroidx/constraintlayout/motion/widget/MotionPaths;->time:F

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iput v1, v0, Landroidx/constraintlayout/motion/widget/MotionPaths;->position:F

    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    const/4 v1, 0x1

    const/4 v2, 0x2

    if-eq p3, v1, :cond_43

    if-eq p3, v2, :cond_15

    goto :goto_70

    :cond_15
    iget p4, p1, Landroidx/constraintlayout/motion/utils/ViewState;->left:I

    iget v1, p1, Landroidx/constraintlayout/motion/utils/ViewState;->right:I

    add-int/2addr p4, v1

    iget v1, p1, Landroidx/constraintlayout/motion/utils/ViewState;->top:I

    iget v3, p1, Landroidx/constraintlayout/motion/utils/ViewState;->bottom:I

    add-int/2addr v1, v3

    invoke-virtual {p1}, Landroidx/constraintlayout/motion/utils/ViewState;->width()I

    move-result v3

    add-int/2addr v1, v3

    div-int/2addr v1, v2

    sub-int/2addr p5, v1

    iput p5, v0, Landroid/graphics/Rect;->left:I

    invoke-virtual {p1}, Landroidx/constraintlayout/motion/utils/ViewState;->height()I

    move-result p5

    sub-int/2addr p4, p5

    div-int/2addr p4, v2

    iput p4, v0, Landroid/graphics/Rect;->top:I

    iget p4, v0, Landroid/graphics/Rect;->left:I

    invoke-virtual {p1}, Landroidx/constraintlayout/motion/utils/ViewState;->width()I

    move-result p5

    add-int/2addr p4, p5

    iput p4, v0, Landroid/graphics/Rect;->right:I

    iget p4, v0, Landroid/graphics/Rect;->top:I

    invoke-virtual {p1}, Landroidx/constraintlayout/motion/utils/ViewState;->height()I

    move-result p5

    add-int/2addr p4, p5

    iput p4, v0, Landroid/graphics/Rect;->bottom:I

    goto :goto_70

    :cond_43
    iget p5, p1, Landroidx/constraintlayout/motion/utils/ViewState;->left:I

    iget v1, p1, Landroidx/constraintlayout/motion/utils/ViewState;->right:I

    add-int/2addr p5, v1

    iget v1, p1, Landroidx/constraintlayout/motion/utils/ViewState;->top:I

    iget v3, p1, Landroidx/constraintlayout/motion/utils/ViewState;->bottom:I

    add-int/2addr v1, v3

    invoke-virtual {p1}, Landroidx/constraintlayout/motion/utils/ViewState;->width()I

    move-result v3

    sub-int/2addr v1, v3

    div-int/2addr v1, v2

    iput v1, v0, Landroid/graphics/Rect;->left:I

    invoke-virtual {p1}, Landroidx/constraintlayout/motion/utils/ViewState;->height()I

    move-result v1

    add-int/2addr p5, v1

    div-int/2addr p5, v2

    sub-int/2addr p4, p5

    iput p4, v0, Landroid/graphics/Rect;->top:I

    iget p4, v0, Landroid/graphics/Rect;->left:I

    invoke-virtual {p1}, Landroidx/constraintlayout/motion/utils/ViewState;->width()I

    move-result p5

    add-int/2addr p4, p5

    iput p4, v0, Landroid/graphics/Rect;->right:I

    iget p4, v0, Landroid/graphics/Rect;->top:I

    invoke-virtual {p1}, Landroidx/constraintlayout/motion/utils/ViewState;->height()I

    move-result p5

    add-int/2addr p4, p5

    iput p4, v0, Landroid/graphics/Rect;->bottom:I

    :goto_70
    iget-object p4, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget p5, v0, Landroid/graphics/Rect;->left:I

    int-to-float p5, p5

    iget v1, v0, Landroid/graphics/Rect;->top:I

    int-to-float v1, v1

    invoke-virtual {v0}, Landroid/graphics/Rect;->width()I

    move-result v2

    int-to-float v2, v2

    invoke-virtual {v0}, Landroid/graphics/Rect;->height()I

    move-result v3

    int-to-float v3, v3

    invoke-virtual {p4, p5, v1, v2, v3}, Landroidx/constraintlayout/motion/widget/MotionPaths;->setBounds(FFFF)V

    iget-object p4, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartPoint:Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;

    iget p1, p1, Landroidx/constraintlayout/motion/utils/ViewState;->rotation:F

    invoke-virtual {p4, v0, p2, p3, p1}, Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;->setState(Landroid/graphics/Rect;Landroid/view/View;IF)V

    return-void
.end method

.method public setTransformPivotTarget(I)V
    .registers 2
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "transformPivotTarget"
        }
    .end annotation

    iput p1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mTransformPivotTarget:I

    const/4 p1, 0x0

    iput-object p1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mTransformPivotView:Landroid/view/View;

    return-void
.end method

.method public setView(Landroid/view/View;)V
    .registers 3
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "view"
        }
    .end annotation

    iput-object p1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mView:Landroid/view/View;

    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    iput v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mId:I

    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object p1

    instance-of v0, p1, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;

    if-eqz v0, :cond_18

    check-cast p1, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;

    invoke-virtual {p1}, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->getConstraintTag()Ljava/lang/String;

    move-result-object p1

    iput-object p1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mConstraintTag:Ljava/lang/String;

    :cond_18
    return-void
.end method

.method public setup(IIFJ)V
    .registers 22
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0,
            0x0
        }
        names = {
            "parentWidth",
            "parentHeight",
            "transitionDuration",
            "currentTime"
        }
    .end annotation

    move-object/from16 v0, p0

    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    new-instance v2, Ljava/util/HashSet;

    invoke-direct {v2}, Ljava/util/HashSet;-><init>()V

    new-instance v3, Ljava/util/HashSet;

    invoke-direct {v3}, Ljava/util/HashSet;-><init>()V

    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    iget v5, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mPathMotionArc:I

    sget v6, Landroidx/constraintlayout/motion/widget/Key;->UNSET:I

    if-eq v5, v6, :cond_27

    iget-object v5, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v6, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mPathMotionArc:I

    iput v6, v5, Landroidx/constraintlayout/motion/widget/MotionPaths;->mPathMotionArc:I

    :cond_27
    iget-object v5, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartPoint:Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;

    iget-object v6, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndPoint:Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;

    invoke-virtual {v5, v6, v2}, Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;->different(Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;Ljava/util/HashSet;)V

    iget-object v5, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mKeyList:Ljava/util/ArrayList;

    if-eqz v5, :cond_8e

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v5

    const/4 v7, 0x0

    :cond_37
    :goto_37
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_8f

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroidx/constraintlayout/motion/widget/Key;

    instance-of v9, v8, Landroidx/constraintlayout/motion/widget/KeyPosition;

    if-eqz v9, :cond_66

    check-cast v8, Landroidx/constraintlayout/motion/widget/KeyPosition;

    new-instance v9, Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget-object v14, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget-object v15, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    move-object v10, v9

    move/from16 v11, p1

    move/from16 v12, p2

    move-object v13, v8

    invoke-direct/range {v10 .. v15}, Landroidx/constraintlayout/motion/widget/MotionPaths;-><init>(IILandroidx/constraintlayout/motion/widget/KeyPosition;Landroidx/constraintlayout/motion/widget/MotionPaths;Landroidx/constraintlayout/motion/widget/MotionPaths;)V

    invoke-direct {v0, v9}, Landroidx/constraintlayout/motion/widget/MotionController;->insertKey(Landroidx/constraintlayout/motion/widget/MotionPaths;)V

    iget v9, v8, Landroidx/constraintlayout/motion/widget/KeyPosition;->mCurveFit:I

    sget v10, Landroidx/constraintlayout/motion/widget/Key;->UNSET:I

    if-eq v9, v10, :cond_37

    iget v8, v8, Landroidx/constraintlayout/motion/widget/KeyPosition;->mCurveFit:I

    iput v8, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mCurveFitType:I

    goto :goto_37

    :cond_66
    instance-of v9, v8, Landroidx/constraintlayout/motion/widget/KeyCycle;

    if-eqz v9, :cond_6e

    invoke-virtual {v8, v3}, Landroidx/constraintlayout/motion/widget/Key;->getAttributeNames(Ljava/util/HashSet;)V

    goto :goto_37

    :cond_6e
    instance-of v9, v8, Landroidx/constraintlayout/motion/widget/KeyTimeCycle;

    if-eqz v9, :cond_76

    invoke-virtual {v8, v1}, Landroidx/constraintlayout/motion/widget/Key;->getAttributeNames(Ljava/util/HashSet;)V

    goto :goto_37

    :cond_76
    instance-of v9, v8, Landroidx/constraintlayout/motion/widget/KeyTrigger;

    if-eqz v9, :cond_87

    if-nez v7, :cond_81

    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    :cond_81
    check-cast v8, Landroidx/constraintlayout/motion/widget/KeyTrigger;

    invoke-virtual {v7, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_37

    :cond_87
    invoke-virtual {v8, v4}, Landroidx/constraintlayout/motion/widget/Key;->setInterpolation(Ljava/util/HashMap;)V

    invoke-virtual {v8, v2}, Landroidx/constraintlayout/motion/widget/Key;->getAttributeNames(Ljava/util/HashSet;)V

    goto :goto_37

    :cond_8e
    const/4 v7, 0x0

    :cond_8f
    const/4 v5, 0x0

    if-eqz v7, :cond_9c

    new-array v8, v5, [Landroidx/constraintlayout/motion/widget/KeyTrigger;

    invoke-virtual {v7, v8}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v7

    check-cast v7, [Landroidx/constraintlayout/motion/widget/KeyTrigger;

    iput-object v7, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mKeyTriggers:[Landroidx/constraintlayout/motion/widget/KeyTrigger;

    :cond_9c
    invoke-virtual {v2}, Ljava/util/HashSet;->isEmpty()Z

    move-result v7

    const-string v8, ","

    const-string v9, "CUSTOM,"

    const/4 v10, 0x1

    if-nez v7, :cond_171

    new-instance v7, Ljava/util/HashMap;

    invoke-direct {v7}, Ljava/util/HashMap;-><init>()V

    iput-object v7, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mAttributesMap:Ljava/util/HashMap;

    invoke-virtual {v2}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :goto_b2
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_10b

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/lang/String;

    invoke-virtual {v11, v9}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_fb

    new-instance v12, Landroid/util/SparseArray;

    invoke-direct {v12}, Landroid/util/SparseArray;-><init>()V

    invoke-virtual {v11, v8}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v13

    aget-object v13, v13, v10

    iget-object v14, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mKeyList:Ljava/util/ArrayList;

    invoke-virtual {v14}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v14

    :cond_d5
    :goto_d5
    invoke-interface {v14}, Ljava/util/Iterator;->hasNext()Z

    move-result v15

    if-eqz v15, :cond_f6

    invoke-interface {v14}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Landroidx/constraintlayout/motion/widget/Key;

    iget-object v6, v15, Landroidx/constraintlayout/motion/widget/Key;->mCustomConstraints:Ljava/util/HashMap;

    if-nez v6, :cond_e6

    goto :goto_d5

    :cond_e6
    iget-object v6, v15, Landroidx/constraintlayout/motion/widget/Key;->mCustomConstraints:Ljava/util/HashMap;

    invoke-virtual {v6, v13}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroidx/constraintlayout/widget/ConstraintAttribute;

    if-eqz v6, :cond_d5

    iget v15, v15, Landroidx/constraintlayout/motion/widget/Key;->mFramePosition:I

    invoke-virtual {v12, v15, v6}, Landroid/util/SparseArray;->append(ILjava/lang/Object;)V

    goto :goto_d5

    :cond_f6
    invoke-static {v11, v12}, Landroidx/constraintlayout/motion/utils/ViewSpline;->makeCustomSpline(Ljava/lang/String;Landroid/util/SparseArray;)Landroidx/constraintlayout/motion/utils/ViewSpline;

    move-result-object v6

    goto :goto_ff

    :cond_fb
    invoke-static {v11}, Landroidx/constraintlayout/motion/utils/ViewSpline;->makeSpline(Ljava/lang/String;)Landroidx/constraintlayout/motion/utils/ViewSpline;

    move-result-object v6

    :goto_ff
    if-nez v6, :cond_102

    goto :goto_b2

    :cond_102
    invoke-virtual {v6, v11}, Landroidx/constraintlayout/motion/utils/ViewSpline;->setType(Ljava/lang/String;)V

    iget-object v12, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mAttributesMap:Ljava/util/HashMap;

    invoke-virtual {v12, v11, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_b2

    :cond_10b
    iget-object v6, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mKeyList:Ljava/util/ArrayList;

    if-eqz v6, :cond_129

    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_113
    :goto_113
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_129

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroidx/constraintlayout/motion/widget/Key;

    instance-of v11, v7, Landroidx/constraintlayout/motion/widget/KeyAttributes;

    if-eqz v11, :cond_113

    iget-object v11, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mAttributesMap:Ljava/util/HashMap;

    invoke-virtual {v7, v11}, Landroidx/constraintlayout/motion/widget/Key;->addValues(Ljava/util/HashMap;)V

    goto :goto_113

    :cond_129
    iget-object v6, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartPoint:Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;

    iget-object v7, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mAttributesMap:Ljava/util/HashMap;

    invoke-virtual {v6, v7, v5}, Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;->addValues(Ljava/util/HashMap;I)V

    iget-object v6, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndPoint:Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;

    iget-object v7, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mAttributesMap:Ljava/util/HashMap;

    const/16 v11, 0x64

    invoke-virtual {v6, v7, v11}, Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;->addValues(Ljava/util/HashMap;I)V

    iget-object v6, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mAttributesMap:Ljava/util/HashMap;

    invoke-virtual {v6}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_143
    :goto_143
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_171

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    invoke-virtual {v4, v7}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_162

    invoke-virtual {v4, v7}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/lang/Integer;

    if-eqz v11, :cond_162

    invoke-virtual {v11}, Ljava/lang/Integer;->intValue()I

    move-result v11

    goto :goto_163

    :cond_162
    move v11, v5

    :goto_163
    iget-object v12, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mAttributesMap:Ljava/util/HashMap;

    invoke-virtual {v12, v7}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroidx/constraintlayout/core/motion/utils/SplineSet;

    if-eqz v7, :cond_143

    invoke-virtual {v7, v11}, Landroidx/constraintlayout/core/motion/utils/SplineSet;->setup(I)V

    goto :goto_143

    :cond_171
    invoke-virtual {v1}, Ljava/util/HashSet;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_240

    iget-object v6, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mTimeCycleAttributesMap:Ljava/util/HashMap;

    if-nez v6, :cond_182

    new-instance v6, Ljava/util/HashMap;

    invoke-direct {v6}, Ljava/util/HashMap;-><init>()V

    iput-object v6, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mTimeCycleAttributesMap:Ljava/util/HashMap;

    :cond_182
    invoke-virtual {v1}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_186
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1ec

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    iget-object v7, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mTimeCycleAttributesMap:Ljava/util/HashMap;

    invoke-virtual {v7, v6}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_19b

    goto :goto_186

    :cond_19b
    invoke-virtual {v6, v9}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_1da

    new-instance v7, Landroid/util/SparseArray;

    invoke-direct {v7}, Landroid/util/SparseArray;-><init>()V

    invoke-virtual {v6, v8}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v11

    aget-object v11, v11, v10

    iget-object v12, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mKeyList:Ljava/util/ArrayList;

    invoke-virtual {v12}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v12

    :cond_1b2
    :goto_1b2
    invoke-interface {v12}, Ljava/util/Iterator;->hasNext()Z

    move-result v13

    if-eqz v13, :cond_1d3

    invoke-interface {v12}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Landroidx/constraintlayout/motion/widget/Key;

    iget-object v14, v13, Landroidx/constraintlayout/motion/widget/Key;->mCustomConstraints:Ljava/util/HashMap;

    if-nez v14, :cond_1c3

    goto :goto_1b2

    :cond_1c3
    iget-object v14, v13, Landroidx/constraintlayout/motion/widget/Key;->mCustomConstraints:Ljava/util/HashMap;

    invoke-virtual {v14, v11}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Landroidx/constraintlayout/widget/ConstraintAttribute;

    if-eqz v14, :cond_1b2

    iget v13, v13, Landroidx/constraintlayout/motion/widget/Key;->mFramePosition:I

    invoke-virtual {v7, v13, v14}, Landroid/util/SparseArray;->append(ILjava/lang/Object;)V

    goto :goto_1b2

    :cond_1d3
    invoke-static {v6, v7}, Landroidx/constraintlayout/motion/utils/ViewTimeCycle;->makeCustomSpline(Ljava/lang/String;Landroid/util/SparseArray;)Landroidx/constraintlayout/motion/utils/ViewTimeCycle;

    move-result-object v7

    move-wide/from16 v11, p4

    goto :goto_1e0

    :cond_1da
    move-wide/from16 v11, p4

    invoke-static {v6, v11, v12}, Landroidx/constraintlayout/motion/utils/ViewTimeCycle;->makeSpline(Ljava/lang/String;J)Landroidx/constraintlayout/motion/utils/ViewTimeCycle;

    move-result-object v7

    :goto_1e0
    if-nez v7, :cond_1e3

    goto :goto_186

    :cond_1e3
    invoke-virtual {v7, v6}, Landroidx/constraintlayout/motion/utils/ViewTimeCycle;->setType(Ljava/lang/String;)V

    iget-object v13, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mTimeCycleAttributesMap:Ljava/util/HashMap;

    invoke-virtual {v13, v6, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_186

    :cond_1ec
    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mKeyList:Ljava/util/ArrayList;

    if-eqz v1, :cond_20c

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_1f4
    :goto_1f4
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_20c

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroidx/constraintlayout/motion/widget/Key;

    instance-of v7, v6, Landroidx/constraintlayout/motion/widget/KeyTimeCycle;

    if-eqz v7, :cond_1f4

    check-cast v6, Landroidx/constraintlayout/motion/widget/KeyTimeCycle;

    iget-object v7, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mTimeCycleAttributesMap:Ljava/util/HashMap;

    invoke-virtual {v6, v7}, Landroidx/constraintlayout/motion/widget/KeyTimeCycle;->addTimeValues(Ljava/util/HashMap;)V

    goto :goto_1f4

    :cond_20c
    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mTimeCycleAttributesMap:Ljava/util/HashMap;

    invoke-virtual {v1}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_216
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_240

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-virtual {v4, v6}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_233

    invoke-virtual {v4, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/Integer;

    invoke-virtual {v7}, Ljava/lang/Integer;->intValue()I

    move-result v7

    goto :goto_234

    :cond_233
    move v7, v5

    :goto_234
    iget-object v8, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mTimeCycleAttributesMap:Ljava/util/HashMap;

    invoke-virtual {v8, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroidx/constraintlayout/motion/utils/ViewTimeCycle;

    invoke-virtual {v6, v7}, Landroidx/constraintlayout/motion/utils/ViewTimeCycle;->setup(I)V

    goto :goto_216

    :cond_240
    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mMotionPaths:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    const/4 v4, 0x2

    add-int/2addr v1, v4

    new-array v6, v1, [Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget-object v7, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    aput-object v7, v6, v5

    add-int/lit8 v7, v1, -0x1

    iget-object v8, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    aput-object v8, v6, v7

    iget-object v7, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mMotionPaths:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v7

    if-lez v7, :cond_263

    iget v7, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mCurveFitType:I

    const/4 v8, -0x1

    if-ne v7, v8, :cond_263

    iput v5, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mCurveFitType:I

    :cond_263
    iget-object v7, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mMotionPaths:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v7

    move v8, v10

    :goto_26a
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_27c

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Landroidx/constraintlayout/motion/widget/MotionPaths;

    add-int/lit8 v12, v8, 0x1

    aput-object v11, v6, v8

    move v8, v12

    goto :goto_26a

    :cond_27c
    new-instance v7, Ljava/util/HashSet;

    invoke-direct {v7}, Ljava/util/HashSet;-><init>()V

    iget-object v8, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget-object v8, v8, Landroidx/constraintlayout/motion/widget/MotionPaths;->attributes:Ljava/util/LinkedHashMap;

    invoke-virtual {v8}, Ljava/util/LinkedHashMap;->keySet()Ljava/util/Set;

    move-result-object v8

    invoke-interface {v8}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :cond_28d
    :goto_28d
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_2ba

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/lang/String;

    iget-object v12, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget-object v12, v12, Landroidx/constraintlayout/motion/widget/MotionPaths;->attributes:Ljava/util/LinkedHashMap;

    invoke-virtual {v12, v11}, Ljava/util/LinkedHashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_28d

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v12, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v2, v12}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v12

    if-nez v12, :cond_28d

    invoke-virtual {v7, v11}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    goto :goto_28d

    :cond_2ba
    new-array v2, v5, [Ljava/lang/String;

    invoke-virtual {v7, v2}, Ljava/util/HashSet;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Ljava/lang/String;

    iput-object v2, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mAttributeNames:[Ljava/lang/String;

    array-length v2, v2

    new-array v2, v2, [I

    iput-object v2, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mAttributeInterpolatorCount:[I

    move v2, v5

    :goto_2ca
    iget-object v7, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mAttributeNames:[Ljava/lang/String;

    array-length v8, v7

    if-ge v2, v8, :cond_300

    aget-object v7, v7, v2

    iget-object v8, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mAttributeInterpolatorCount:[I

    aput v5, v8, v2

    move v8, v5

    :goto_2d6
    if-ge v8, v1, :cond_2fd

    aget-object v9, v6, v8

    iget-object v9, v9, Landroidx/constraintlayout/motion/widget/MotionPaths;->attributes:Ljava/util/LinkedHashMap;

    invoke-virtual {v9, v7}, Ljava/util/LinkedHashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_2fa

    aget-object v9, v6, v8

    iget-object v9, v9, Landroidx/constraintlayout/motion/widget/MotionPaths;->attributes:Ljava/util/LinkedHashMap;

    invoke-virtual {v9, v7}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroidx/constraintlayout/widget/ConstraintAttribute;

    if-eqz v9, :cond_2fa

    iget-object v7, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mAttributeInterpolatorCount:[I

    aget v8, v7, v2

    invoke-virtual {v9}, Landroidx/constraintlayout/widget/ConstraintAttribute;->numberOfInterpolatedValues()I

    move-result v9

    add-int/2addr v8, v9

    aput v8, v7, v2

    goto :goto_2fd

    :cond_2fa
    add-int/lit8 v8, v8, 0x1

    goto :goto_2d6

    :cond_2fd
    :goto_2fd
    add-int/lit8 v2, v2, 0x1

    goto :goto_2ca

    :cond_300
    aget-object v2, v6, v5

    iget v2, v2, Landroidx/constraintlayout/motion/widget/MotionPaths;->mPathMotionArc:I

    sget v7, Landroidx/constraintlayout/motion/widget/Key;->UNSET:I

    if-eq v2, v7, :cond_30a

    move v2, v10

    goto :goto_30b

    :cond_30a
    move v2, v5

    :goto_30b
    iget-object v7, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mAttributeNames:[Ljava/lang/String;

    array-length v7, v7

    const/16 v8, 0x12

    add-int/2addr v8, v7

    new-array v7, v8, [Z

    move v9, v10

    :goto_314
    if-ge v9, v1, :cond_324

    aget-object v11, v6, v9

    add-int/lit8 v12, v9, -0x1

    aget-object v12, v6, v12

    iget-object v13, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mAttributeNames:[Ljava/lang/String;

    invoke-virtual {v11, v12, v7, v13, v2}, Landroidx/constraintlayout/motion/widget/MotionPaths;->different(Landroidx/constraintlayout/motion/widget/MotionPaths;[Z[Ljava/lang/String;Z)V

    add-int/lit8 v9, v9, 0x1

    goto :goto_314

    :cond_324
    move v9, v5

    move v2, v10

    :goto_326
    if-ge v2, v8, :cond_331

    aget-boolean v11, v7, v2

    if-eqz v11, :cond_32e

    add-int/lit8 v9, v9, 0x1

    :cond_32e
    add-int/lit8 v2, v2, 0x1

    goto :goto_326

    :cond_331
    new-array v2, v9, [I

    iput-object v2, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVariables:[I

    invoke-static {v4, v9}, Ljava/lang/Math;->max(II)I

    move-result v2

    new-array v9, v2, [D

    iput-object v9, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateData:[D

    new-array v2, v2, [D

    iput-object v2, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVelocity:[D

    move v9, v5

    move v2, v10

    :goto_343
    if-ge v2, v8, :cond_353

    aget-boolean v11, v7, v2

    if-eqz v11, :cond_350

    iget-object v11, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVariables:[I

    add-int/lit8 v12, v9, 0x1

    aput v2, v11, v9

    move v9, v12

    :cond_350
    add-int/lit8 v2, v2, 0x1

    goto :goto_343

    :cond_353
    iget-object v2, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVariables:[I

    array-length v2, v2

    new-array v7, v4, [I

    aput v2, v7, v10

    aput v1, v7, v5

    sget-object v2, Ljava/lang/Double;->TYPE:Ljava/lang/Class;

    invoke-static {v2, v7}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [[D

    new-array v7, v1, [D

    move v8, v5

    :goto_367
    if-ge v8, v1, :cond_37c

    aget-object v9, v6, v8

    aget-object v11, v2, v8

    iget-object v12, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVariables:[I

    invoke-virtual {v9, v11, v12}, Landroidx/constraintlayout/motion/widget/MotionPaths;->fillStandard([D[I)V

    aget-object v9, v6, v8

    iget v9, v9, Landroidx/constraintlayout/motion/widget/MotionPaths;->time:F

    float-to-double v11, v9

    aput-wide v11, v7, v8

    add-int/lit8 v8, v8, 0x1

    goto :goto_367

    :cond_37c
    move v8, v5

    :goto_37d
    iget-object v9, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVariables:[I

    array-length v11, v9

    if-ge v8, v11, :cond_3c2

    aget v9, v9, v8

    sget-object v11, Landroidx/constraintlayout/motion/widget/MotionPaths;->names:[Ljava/lang/String;

    array-length v11, v11

    if-ge v9, v11, :cond_3bf

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v11, Landroidx/constraintlayout/motion/widget/MotionPaths;->names:[Ljava/lang/String;

    iget-object v12, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mInterpolateVariables:[I

    aget v12, v12, v8

    aget-object v11, v11, v12

    invoke-virtual {v9, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v11, " ["

    invoke-virtual {v9, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    move v11, v5

    :goto_3a5
    if-ge v11, v1, :cond_3bf

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v12, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    aget-object v12, v2, v11

    aget-wide v13, v12, v8

    invoke-virtual {v9, v13, v14}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    add-int/lit8 v11, v11, 0x1

    goto :goto_3a5

    :cond_3bf
    add-int/lit8 v8, v8, 0x1

    goto :goto_37d

    :cond_3c2
    iget-object v8, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mAttributeNames:[Ljava/lang/String;

    array-length v8, v8

    add-int/2addr v8, v10

    new-array v8, v8, [Landroidx/constraintlayout/core/motion/utils/CurveFit;

    iput-object v8, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mSpline:[Landroidx/constraintlayout/core/motion/utils/CurveFit;

    move v8, v5

    :goto_3cb
    iget-object v9, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mAttributeNames:[Ljava/lang/String;

    array-length v11, v9

    if-ge v8, v11, :cond_427

    aget-object v9, v9, v8

    move v11, v5

    move v13, v11

    const/4 v12, 0x0

    const/4 v14, 0x0

    :goto_3d6
    if-ge v11, v1, :cond_40e

    aget-object v15, v6, v11

    invoke-virtual {v15, v9}, Landroidx/constraintlayout/motion/widget/MotionPaths;->hasCustomData(Ljava/lang/String;)Z

    move-result v15

    if-eqz v15, :cond_409

    if-nez v14, :cond_3f8

    new-array v12, v1, [D

    aget-object v14, v6, v11

    invoke-virtual {v14, v9}, Landroidx/constraintlayout/motion/widget/MotionPaths;->getCustomDataCount(Ljava/lang/String;)I

    move-result v14

    new-array v15, v4, [I

    aput v14, v15, v10

    aput v1, v15, v5

    sget-object v14, Ljava/lang/Double;->TYPE:Ljava/lang/Class;

    invoke-static {v14, v15}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v14

    check-cast v14, [[D

    :cond_3f8
    aget-object v15, v6, v11

    iget v15, v15, Landroidx/constraintlayout/motion/widget/MotionPaths;->time:F

    float-to-double v4, v15

    aput-wide v4, v12, v13

    aget-object v4, v6, v11

    aget-object v5, v14, v13

    const/4 v15, 0x0

    invoke-virtual {v4, v9, v5, v15}, Landroidx/constraintlayout/motion/widget/MotionPaths;->getCustomData(Ljava/lang/String;[DI)I

    add-int/lit8 v13, v13, 0x1

    :cond_409
    add-int/lit8 v11, v11, 0x1

    const/4 v4, 0x2

    const/4 v5, 0x0

    goto :goto_3d6

    :cond_40e
    invoke-static {v12, v13}, Ljava/util/Arrays;->copyOf([DI)[D

    move-result-object v4

    invoke-static {v14, v13}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object v5

    check-cast v5, [[D

    iget-object v9, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mSpline:[Landroidx/constraintlayout/core/motion/utils/CurveFit;

    add-int/lit8 v8, v8, 0x1

    iget v11, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mCurveFitType:I

    invoke-static {v11, v4, v5}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->get(I[D[[D)Landroidx/constraintlayout/core/motion/utils/CurveFit;

    move-result-object v4

    aput-object v4, v9, v8

    const/4 v4, 0x2

    const/4 v5, 0x0

    goto :goto_3cb

    :cond_427
    iget-object v4, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mSpline:[Landroidx/constraintlayout/core/motion/utils/CurveFit;

    iget v5, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mCurveFitType:I

    invoke-static {v5, v7, v2}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->get(I[D[[D)Landroidx/constraintlayout/core/motion/utils/CurveFit;

    move-result-object v2

    const/4 v5, 0x0

    aput-object v2, v4, v5

    aget-object v2, v6, v5

    iget v2, v2, Landroidx/constraintlayout/motion/widget/MotionPaths;->mPathMotionArc:I

    sget v4, Landroidx/constraintlayout/motion/widget/Key;->UNSET:I

    if-eq v2, v4, :cond_479

    new-array v2, v1, [I

    new-array v4, v1, [D

    const/4 v7, 0x2

    new-array v8, v7, [I

    aput v7, v8, v10

    aput v1, v8, v5

    sget-object v5, Ljava/lang/Double;->TYPE:Ljava/lang/Class;

    invoke-static {v5, v8}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, [[D

    const/4 v15, 0x0

    :goto_44e
    if-ge v15, v1, :cond_473

    aget-object v7, v6, v15

    iget v7, v7, Landroidx/constraintlayout/motion/widget/MotionPaths;->mPathMotionArc:I

    aput v7, v2, v15

    aget-object v7, v6, v15

    iget v7, v7, Landroidx/constraintlayout/motion/widget/MotionPaths;->time:F

    float-to-double v7, v7

    aput-wide v7, v4, v15

    aget-object v7, v5, v15

    aget-object v8, v6, v15

    iget v8, v8, Landroidx/constraintlayout/motion/widget/MotionPaths;->x:F

    float-to-double v8, v8

    const/4 v11, 0x0

    aput-wide v8, v7, v11

    aget-object v7, v5, v15

    aget-object v8, v6, v15

    iget v8, v8, Landroidx/constraintlayout/motion/widget/MotionPaths;->y:F

    float-to-double v8, v8

    aput-wide v8, v7, v10

    add-int/lit8 v15, v15, 0x1

    goto :goto_44e

    :cond_473
    invoke-static {v2, v4, v5}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getArc([I[D[[D)Landroidx/constraintlayout/core/motion/utils/CurveFit;

    move-result-object v1

    iput-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mArcSpline:Landroidx/constraintlayout/core/motion/utils/CurveFit;

    :cond_479
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    iput-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mCycleMap:Ljava/util/HashMap;

    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mKeyList:Ljava/util/ArrayList;

    if-eqz v1, :cond_4ee

    invoke-virtual {v3}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v1

    const/high16 v2, 0x7fc00000    # Float.NaN

    :goto_48a
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_4b6

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-static {v3}, Landroidx/constraintlayout/motion/utils/ViewOscillator;->makeSpline(Ljava/lang/String;)Landroidx/constraintlayout/motion/utils/ViewOscillator;

    move-result-object v4

    if-nez v4, :cond_49d

    goto :goto_48a

    :cond_49d
    invoke-virtual {v4}, Landroidx/constraintlayout/motion/utils/ViewOscillator;->variesByPath()Z

    move-result v5

    if-eqz v5, :cond_4ad

    invoke-static {v2}, Ljava/lang/Float;->isNaN(F)Z

    move-result v5

    if-eqz v5, :cond_4ad

    invoke-direct/range {p0 .. p0}, Landroidx/constraintlayout/motion/widget/MotionController;->getPreCycleDistance()F

    move-result v2

    :cond_4ad
    invoke-virtual {v4, v3}, Landroidx/constraintlayout/motion/utils/ViewOscillator;->setType(Ljava/lang/String;)V

    iget-object v5, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mCycleMap:Ljava/util/HashMap;

    invoke-virtual {v5, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_48a

    :cond_4b6
    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mKeyList:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_4bc
    :goto_4bc
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_4d4

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/constraintlayout/motion/widget/Key;

    instance-of v4, v3, Landroidx/constraintlayout/motion/widget/KeyCycle;

    if-eqz v4, :cond_4bc

    check-cast v3, Landroidx/constraintlayout/motion/widget/KeyCycle;

    iget-object v4, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mCycleMap:Ljava/util/HashMap;

    invoke-virtual {v3, v4}, Landroidx/constraintlayout/motion/widget/KeyCycle;->addCycleValues(Ljava/util/HashMap;)V

    goto :goto_4bc

    :cond_4d4
    iget-object v1, v0, Landroidx/constraintlayout/motion/widget/MotionController;->mCycleMap:Ljava/util/HashMap;

    invoke-virtual {v1}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_4de
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_4ee

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/constraintlayout/motion/utils/ViewOscillator;

    invoke-virtual {v3, v2}, Landroidx/constraintlayout/motion/utils/ViewOscillator;->setup(F)V

    goto :goto_4de

    :cond_4ee
    return-void
.end method

.method public setupRelative(Landroidx/constraintlayout/motion/widget/MotionController;)V
    .registers 4
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "motionController"
        }
    .end annotation

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget-object v1, p1, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    invoke-virtual {v0, p1, v1}, Landroidx/constraintlayout/motion/widget/MotionPaths;->setupRelative(Landroidx/constraintlayout/motion/widget/MotionController;Landroidx/constraintlayout/motion/widget/MotionPaths;)V

    iget-object v0, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget-object v1, p1, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    invoke-virtual {v0, p1, v1}, Landroidx/constraintlayout/motion/widget/MotionPaths;->setupRelative(Landroidx/constraintlayout/motion/widget/MotionController;Landroidx/constraintlayout/motion/widget/MotionPaths;)V

    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, " start: x: "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v1, v1, Landroidx/constraintlayout/motion/widget/MotionPaths;->x:F

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " y: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mStartMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v2, v2, Landroidx/constraintlayout/motion/widget/MotionPaths;->y:F

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " end: x: "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v2, v2, Landroidx/constraintlayout/motion/widget/MotionPaths;->x:F

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Landroidx/constraintlayout/motion/widget/MotionController;->mEndMotionPath:Landroidx/constraintlayout/motion/widget/MotionPaths;

    iget v1, v1, Landroidx/constraintlayout/motion/widget/MotionPaths;->y:F

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
