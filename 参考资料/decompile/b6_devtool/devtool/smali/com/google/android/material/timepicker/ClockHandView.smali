.class Lcom/google/android/material/timepicker/ClockHandView;
.super Landroid/view/View;
.source "ClockHandView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/material/timepicker/ClockHandView$OnActionUpListener;,
        Lcom/google/android/material/timepicker/ClockHandView$OnRotateListener;
    }
.end annotation


# static fields
.field private static final DEFAULT_ANIMATION_DURATION:I = 0xc8


# instance fields
.field private animatingOnTouchUp:Z

.field private final animationDuration:I

.field private final animationInterpolator:Landroid/animation/TimeInterpolator;

.field private final centerDotRadius:F

.field private changedDuringTouch:Z

.field private circleRadius:I

.field private currentLevel:I

.field private degRad:D

.field private downX:F

.field private downY:F

.field private isInTapRegion:Z

.field private isMultiLevel:Z

.field private final listeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lcom/google/android/material/timepicker/ClockHandView$OnRotateListener;",
            ">;"
        }
    .end annotation
.end field

.field private onActionUpListener:Lcom/google/android/material/timepicker/ClockHandView$OnActionUpListener;

.field private originalDeg:F

.field private final paint:Landroid/graphics/Paint;

.field private final rotationAnimator:Landroid/animation/ValueAnimator;

.field private final scaledTouchSlop:I

.field private final selectorBox:Landroid/graphics/RectF;

.field private final selectorRadius:I

.field private final selectorStrokeWidth:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 3

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/google/android/material/timepicker/ClockHandView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 4

    sget v0, Lcom/google/android/material/R$attr;->materialClockStyle:I

    invoke-direct {p0, p1, p2, v0}, Lcom/google/android/material/timepicker/ClockHandView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .registers 8

    invoke-direct {p0, p1, p2, p3}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    new-instance v0, Landroid/animation/ValueAnimator;

    invoke-direct {v0}, Landroid/animation/ValueAnimator;-><init>()V

    iput-object v0, p0, Lcom/google/android/material/timepicker/ClockHandView;->rotationAnimator:Landroid/animation/ValueAnimator;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/google/android/material/timepicker/ClockHandView;->listeners:Ljava/util/List;

    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/google/android/material/timepicker/ClockHandView;->paint:Landroid/graphics/Paint;

    new-instance v1, Landroid/graphics/RectF;

    invoke-direct {v1}, Landroid/graphics/RectF;-><init>()V

    iput-object v1, p0, Lcom/google/android/material/timepicker/ClockHandView;->selectorBox:Landroid/graphics/RectF;

    const/4 v1, 0x1

    iput v1, p0, Lcom/google/android/material/timepicker/ClockHandView;->currentLevel:I

    sget-object v2, Lcom/google/android/material/R$styleable;->ClockHandView:[I

    sget v3, Lcom/google/android/material/R$style;->Widget_MaterialComponents_TimePicker_Clock:I

    invoke-virtual {p1, p2, v2, p3, v3}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object p2

    sget p3, Lcom/google/android/material/R$attr;->motionDurationLong2:I

    const/16 v2, 0xc8

    invoke-static {p1, p3, v2}, Lcom/google/android/material/motion/MotionUtils;->resolveThemeDuration(Landroid/content/Context;II)I

    move-result p3

    iput p3, p0, Lcom/google/android/material/timepicker/ClockHandView;->animationDuration:I

    sget p3, Lcom/google/android/material/R$attr;->motionEasingEmphasizedInterpolator:I

    sget-object v2, Lcom/google/android/material/animation/AnimationUtils;->FAST_OUT_SLOW_IN_INTERPOLATOR:Landroid/animation/TimeInterpolator;

    invoke-static {p1, p3, v2}, Lcom/google/android/material/motion/MotionUtils;->resolveThemeInterpolator(Landroid/content/Context;ILandroid/animation/TimeInterpolator;)Landroid/animation/TimeInterpolator;

    move-result-object p3

    iput-object p3, p0, Lcom/google/android/material/timepicker/ClockHandView;->animationInterpolator:Landroid/animation/TimeInterpolator;

    sget p3, Lcom/google/android/material/R$styleable;->ClockHandView_materialCircleRadius:I

    const/4 v2, 0x0

    invoke-virtual {p2, p3, v2}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result p3

    iput p3, p0, Lcom/google/android/material/timepicker/ClockHandView;->circleRadius:I

    sget p3, Lcom/google/android/material/R$styleable;->ClockHandView_selectorSize:I

    invoke-virtual {p2, p3, v2}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result p3

    iput p3, p0, Lcom/google/android/material/timepicker/ClockHandView;->selectorRadius:I

    invoke-virtual {p0}, Lcom/google/android/material/timepicker/ClockHandView;->getResources()Landroid/content/res/Resources;

    move-result-object p3

    sget v3, Lcom/google/android/material/R$dimen;->material_clock_hand_stroke_width:I

    invoke-virtual {p3, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v3

    iput v3, p0, Lcom/google/android/material/timepicker/ClockHandView;->selectorStrokeWidth:I

    sget v3, Lcom/google/android/material/R$dimen;->material_clock_hand_center_dot_radius:I

    invoke-virtual {p3, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result p3

    int-to-float p3, p3

    iput p3, p0, Lcom/google/android/material/timepicker/ClockHandView;->centerDotRadius:F

    sget p3, Lcom/google/android/material/R$styleable;->ClockHandView_clockHandColor:I

    invoke-virtual {p2, p3, v2}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result p3

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    invoke-virtual {v0, p3}, Landroid/graphics/Paint;->setColor(I)V

    const/4 p3, 0x0

    invoke-virtual {p0, p3}, Lcom/google/android/material/timepicker/ClockHandView;->setHandRotation(F)V

    invoke-static {p1}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object p1

    invoke-virtual {p1}, Landroid/view/ViewConfiguration;->getScaledTouchSlop()I

    move-result p1

    iput p1, p0, Lcom/google/android/material/timepicker/ClockHandView;->scaledTouchSlop:I

    const/4 p1, 0x2

    invoke-static {p0, p1}, Landroidx/core/view/ViewCompat;->setImportantForAccessibility(Landroid/view/View;I)V

    invoke-virtual {p2}, Landroid/content/res/TypedArray;->recycle()V

    return-void
.end method

.method private adjustLevel(FF)V
    .registers 6

    invoke-virtual {p0}, Lcom/google/android/material/timepicker/ClockHandView;->getWidth()I

    move-result v0

    const/4 v1, 0x2

    div-int/2addr v0, v1

    invoke-virtual {p0}, Lcom/google/android/material/timepicker/ClockHandView;->getHeight()I

    move-result v2

    div-int/2addr v2, v1

    int-to-float v0, v0

    int-to-float v2, v2

    invoke-static {v0, v2, p1, p2}, Lcom/google/android/material/math/MathUtils;->dist(FFFF)F

    move-result p1

    invoke-direct {p0, v1}, Lcom/google/android/material/timepicker/ClockHandView;->getLeveledCircleRadius(I)I

    move-result p2

    invoke-virtual {p0}, Lcom/google/android/material/timepicker/ClockHandView;->getContext()Landroid/content/Context;

    move-result-object v0

    const/16 v2, 0xc

    invoke-static {v0, v2}, Lcom/google/android/material/internal/ViewUtils;->dpToPx(Landroid/content/Context;I)F

    move-result v0

    int-to-float p2, p2

    add-float/2addr p2, v0

    cmpg-float p1, p1, p2

    if-gtz p1, :cond_26

    goto :goto_27

    :cond_26
    const/4 v1, 0x1

    :goto_27
    iput v1, p0, Lcom/google/android/material/timepicker/ClockHandView;->currentLevel:I

    return-void
.end method

.method private drawSelector(Landroid/graphics/Canvas;)V
    .registers 13

    invoke-virtual {p0}, Lcom/google/android/material/timepicker/ClockHandView;->getHeight()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    invoke-virtual {p0}, Lcom/google/android/material/timepicker/ClockHandView;->getWidth()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    iget v2, p0, Lcom/google/android/material/timepicker/ClockHandView;->currentLevel:I

    invoke-direct {p0, v2}, Lcom/google/android/material/timepicker/ClockHandView;->getLeveledCircleRadius(I)I

    move-result v2

    int-to-float v9, v1

    int-to-float v3, v2

    iget-wide v4, p0, Lcom/google/android/material/timepicker/ClockHandView;->degRad:D

    invoke-static {v4, v5}, Ljava/lang/Math;->cos(D)D

    move-result-wide v4

    double-to-float v4, v4

    mul-float/2addr v4, v3

    add-float/2addr v4, v9

    int-to-float v10, v0

    iget-wide v5, p0, Lcom/google/android/material/timepicker/ClockHandView;->degRad:D

    invoke-static {v5, v6}, Ljava/lang/Math;->sin(D)D

    move-result-wide v5

    double-to-float v5, v5

    mul-float/2addr v3, v5

    add-float/2addr v3, v10

    iget-object v5, p0, Lcom/google/android/material/timepicker/ClockHandView;->paint:Landroid/graphics/Paint;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    iget v5, p0, Lcom/google/android/material/timepicker/ClockHandView;->selectorRadius:I

    int-to-float v5, v5

    iget-object v6, p0, Lcom/google/android/material/timepicker/ClockHandView;->paint:Landroid/graphics/Paint;

    invoke-virtual {p1, v4, v3, v5, v6}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    iget-wide v3, p0, Lcom/google/android/material/timepicker/ClockHandView;->degRad:D

    invoke-static {v3, v4}, Ljava/lang/Math;->sin(D)D

    move-result-wide v3

    iget-wide v5, p0, Lcom/google/android/material/timepicker/ClockHandView;->degRad:D

    invoke-static {v5, v6}, Ljava/lang/Math;->cos(D)D

    move-result-wide v5

    iget v7, p0, Lcom/google/android/material/timepicker/ClockHandView;->selectorRadius:I

    sub-int/2addr v2, v7

    int-to-float v2, v2

    float-to-double v7, v2

    mul-double/2addr v5, v7

    double-to-int v2, v5

    add-int/2addr v1, v2

    int-to-float v6, v1

    mul-double/2addr v7, v3

    double-to-int v1, v7

    add-int/2addr v0, v1

    int-to-float v7, v0

    iget-object v0, p0, Lcom/google/android/material/timepicker/ClockHandView;->paint:Landroid/graphics/Paint;

    iget v1, p0, Lcom/google/android/material/timepicker/ClockHandView;->selectorStrokeWidth:I

    int-to-float v1, v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    iget-object v8, p0, Lcom/google/android/material/timepicker/ClockHandView;->paint:Landroid/graphics/Paint;

    move-object v3, p1

    move v4, v9

    move v5, v10

    invoke-virtual/range {v3 .. v8}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    iget v0, p0, Lcom/google/android/material/timepicker/ClockHandView;->centerDotRadius:F

    iget-object v1, p0, Lcom/google/android/material/timepicker/ClockHandView;->paint:Landroid/graphics/Paint;

    invoke-virtual {p1, v9, v10, v0, v1}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    return-void
.end method

.method private getDegreesFromXY(FF)I
    .registers 7

    invoke-virtual {p0}, Lcom/google/android/material/timepicker/ClockHandView;->getWidth()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    invoke-virtual {p0}, Lcom/google/android/material/timepicker/ClockHandView;->getHeight()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    int-to-float v0, v0

    sub-float/2addr p1, v0

    float-to-double v2, p1

    int-to-float p1, v1

    sub-float/2addr p2, p1

    float-to-double p1, p2

    invoke-static {p1, p2, v2, v3}, Ljava/lang/Math;->atan2(DD)D

    move-result-wide p1

    invoke-static {p1, p2}, Ljava/lang/Math;->toDegrees(D)D

    move-result-wide p1

    double-to-int p1, p1

    add-int/lit8 p1, p1, 0x5a

    if-gez p1, :cond_21

    add-int/lit16 p1, p1, 0x168

    :cond_21
    return p1
.end method

.method private getLeveledCircleRadius(I)I
    .registers 3

    const/4 v0, 0x2

    if-ne p1, v0, :cond_f

    iget p1, p0, Lcom/google/android/material/timepicker/ClockHandView;->circleRadius:I

    int-to-float p1, p1

    const v0, 0x3f28f5c3    # 0.66f

    mul-float/2addr p1, v0

    invoke-static {p1}, Ljava/lang/Math;->round(F)I

    move-result p1

    goto :goto_11

    :cond_f
    iget p1, p0, Lcom/google/android/material/timepicker/ClockHandView;->circleRadius:I

    :goto_11
    return p1
.end method

.method private getValuesForAnimation(F)Landroid/util/Pair;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(F)",
            "Landroid/util/Pair<",
            "Ljava/lang/Float;",
            "Ljava/lang/Float;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/google/android/material/timepicker/ClockHandView;->getHandRotation()F

    move-result v0

    sub-float v1, v0, p1

    invoke-static {v1}, Ljava/lang/Math;->abs(F)F

    move-result v1

    const/high16 v2, 0x43340000    # 180.0f

    cmpl-float v1, v1, v2

    if-lez v1, :cond_24

    cmpl-float v1, v0, v2

    const/high16 v3, 0x43b40000    # 360.0f

    if-lez v1, :cond_1b

    cmpg-float v1, p1, v2

    if-gez v1, :cond_1b

    add-float/2addr p1, v3

    :cond_1b
    cmpg-float v1, v0, v2

    if-gez v1, :cond_24

    cmpl-float v1, p1, v2

    if-lez v1, :cond_24

    add-float/2addr v0, v3

    :cond_24
    new-instance v1, Landroid/util/Pair;

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    invoke-static {p1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object p1

    invoke-direct {v1, v0, p1}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    return-object v1
.end method

.method private handleTouchInput(FFZZZ)Z
    .registers 8

    invoke-direct {p0, p1, p2}, Lcom/google/android/material/timepicker/ClockHandView;->getDegreesFromXY(FF)I

    move-result p1

    invoke-virtual {p0}, Lcom/google/android/material/timepicker/ClockHandView;->getHandRotation()F

    move-result p2

    int-to-float p1, p1

    cmpl-float p2, p2, p1

    const/4 v0, 0x0

    const/4 v1, 0x1

    if-eqz p2, :cond_11

    move p2, v1

    goto :goto_12

    :cond_11
    move p2, v0

    :goto_12
    if-eqz p4, :cond_17

    if-eqz p2, :cond_17

    return v1

    :cond_17
    if-nez p2, :cond_1d

    if-eqz p3, :cond_1c

    goto :goto_1d

    :cond_1c
    return v0

    :cond_1d
    :goto_1d
    if-eqz p5, :cond_24

    iget-boolean p2, p0, Lcom/google/android/material/timepicker/ClockHandView;->animatingOnTouchUp:Z

    if-eqz p2, :cond_24

    move v0, v1

    :cond_24
    invoke-virtual {p0, p1, v0}, Lcom/google/android/material/timepicker/ClockHandView;->setHandRotation(FZ)V

    return v1
.end method

.method private setHandRotationInternal(FZ)V
    .registers 10

    const/high16 v0, 0x43b40000    # 360.0f

    rem-float/2addr p1, v0

    iput p1, p0, Lcom/google/android/material/timepicker/ClockHandView;->originalDeg:F

    const/high16 v0, 0x42b40000    # 90.0f

    sub-float v0, p1, v0

    float-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->toRadians(D)D

    move-result-wide v0

    iput-wide v0, p0, Lcom/google/android/material/timepicker/ClockHandView;->degRad:D

    invoke-virtual {p0}, Lcom/google/android/material/timepicker/ClockHandView;->getHeight()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    invoke-virtual {p0}, Lcom/google/android/material/timepicker/ClockHandView;->getWidth()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    iget v2, p0, Lcom/google/android/material/timepicker/ClockHandView;->currentLevel:I

    invoke-direct {p0, v2}, Lcom/google/android/material/timepicker/ClockHandView;->getLeveledCircleRadius(I)I

    move-result v2

    int-to-float v1, v1

    int-to-float v2, v2

    iget-wide v3, p0, Lcom/google/android/material/timepicker/ClockHandView;->degRad:D

    invoke-static {v3, v4}, Ljava/lang/Math;->cos(D)D

    move-result-wide v3

    double-to-float v3, v3

    mul-float/2addr v3, v2

    add-float/2addr v1, v3

    int-to-float v0, v0

    iget-wide v3, p0, Lcom/google/android/material/timepicker/ClockHandView;->degRad:D

    invoke-static {v3, v4}, Ljava/lang/Math;->sin(D)D

    move-result-wide v3

    double-to-float v3, v3

    mul-float/2addr v2, v3

    add-float/2addr v0, v2

    iget-object v2, p0, Lcom/google/android/material/timepicker/ClockHandView;->selectorBox:Landroid/graphics/RectF;

    iget v3, p0, Lcom/google/android/material/timepicker/ClockHandView;->selectorRadius:I

    int-to-float v4, v3

    sub-float v4, v1, v4

    int-to-float v5, v3

    sub-float v5, v0, v5

    int-to-float v6, v3

    add-float/2addr v1, v6

    int-to-float v3, v3

    add-float/2addr v0, v3

    invoke-virtual {v2, v4, v5, v1, v0}, Landroid/graphics/RectF;->set(FFFF)V

    iget-object v0, p0, Lcom/google/android/material/timepicker/ClockHandView;->listeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_4e
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_5e

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/material/timepicker/ClockHandView$OnRotateListener;

    invoke-interface {v1, p1, p2}, Lcom/google/android/material/timepicker/ClockHandView$OnRotateListener;->onRotate(FZ)V

    goto :goto_4e

    :cond_5e
    invoke-virtual {p0}, Lcom/google/android/material/timepicker/ClockHandView;->invalidate()V

    return-void
.end method


# virtual methods
.method public addOnRotateListener(Lcom/google/android/material/timepicker/ClockHandView$OnRotateListener;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/timepicker/ClockHandView;->listeners:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method getCurrentLevel()I
    .registers 2

    iget v0, p0, Lcom/google/android/material/timepicker/ClockHandView;->currentLevel:I

    return v0
.end method

.method public getCurrentSelectorBox()Landroid/graphics/RectF;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/timepicker/ClockHandView;->selectorBox:Landroid/graphics/RectF;

    return-object v0
.end method

.method public getHandRotation()F
    .registers 2

    iget v0, p0, Lcom/google/android/material/timepicker/ClockHandView;->originalDeg:F

    return v0
.end method

.method public getSelectorRadius()I
    .registers 2

    iget v0, p0, Lcom/google/android/material/timepicker/ClockHandView;->selectorRadius:I

    return v0
.end method

.method synthetic lambda$setHandRotation$0$com-google-android-material-timepicker-ClockHandView(Landroid/animation/ValueAnimator;)V
    .registers 3

    invoke-virtual {p1}, Landroid/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/Float;

    invoke-virtual {p1}, Ljava/lang/Float;->floatValue()F

    move-result p1

    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Lcom/google/android/material/timepicker/ClockHandView;->setHandRotationInternal(FZ)V

    return-void
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .registers 2

    invoke-super {p0, p1}, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V

    invoke-direct {p0, p1}, Lcom/google/android/material/timepicker/ClockHandView;->drawSelector(Landroid/graphics/Canvas;)V

    return-void
.end method

.method protected onLayout(ZIIII)V
    .registers 6

    invoke-super/range {p0 .. p5}, Landroid/view/View;->onLayout(ZIIII)V

    iget-object p1, p0, Lcom/google/android/material/timepicker/ClockHandView;->rotationAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {p1}, Landroid/animation/ValueAnimator;->isRunning()Z

    move-result p1

    if-nez p1, :cond_12

    invoke-virtual {p0}, Lcom/google/android/material/timepicker/ClockHandView;->getHandRotation()F

    move-result p1

    invoke-virtual {p0, p1}, Lcom/google/android/material/timepicker/ClockHandView;->setHandRotation(F)V

    :cond_12
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .registers 12

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v0

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v7

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result p1

    const/4 v8, 0x1

    const/4 v1, 0x0

    if-eqz v0, :cond_40

    if-eq v0, v8, :cond_19

    const/4 v2, 0x2

    if-eq v0, v2, :cond_19

    move v0, v1

    move v4, v0

    move v5, v4

    goto :goto_4b

    :cond_19
    iget v2, p0, Lcom/google/android/material/timepicker/ClockHandView;->downX:F

    sub-float v2, v7, v2

    float-to-int v2, v2

    iget v3, p0, Lcom/google/android/material/timepicker/ClockHandView;->downY:F

    sub-float v3, p1, v3

    float-to-int v3, v3

    mul-int/2addr v2, v2

    mul-int/2addr v3, v3

    add-int/2addr v2, v3

    iget v3, p0, Lcom/google/android/material/timepicker/ClockHandView;->scaledTouchSlop:I

    if-le v2, v3, :cond_2c

    move v2, v8

    goto :goto_2d

    :cond_2c
    move v2, v1

    :goto_2d
    iput-boolean v2, p0, Lcom/google/android/material/timepicker/ClockHandView;->isInTapRegion:Z

    iget-boolean v2, p0, Lcom/google/android/material/timepicker/ClockHandView;->changedDuringTouch:Z

    if-ne v0, v8, :cond_35

    move v0, v8

    goto :goto_36

    :cond_35
    move v0, v1

    :goto_36
    iget-boolean v3, p0, Lcom/google/android/material/timepicker/ClockHandView;->isMultiLevel:Z

    if-eqz v3, :cond_3d

    invoke-direct {p0, v7, p1}, Lcom/google/android/material/timepicker/ClockHandView;->adjustLevel(FF)V

    :cond_3d
    move v5, v1

    move v4, v2

    goto :goto_4b

    :cond_40
    iput v7, p0, Lcom/google/android/material/timepicker/ClockHandView;->downX:F

    iput p1, p0, Lcom/google/android/material/timepicker/ClockHandView;->downY:F

    iput-boolean v8, p0, Lcom/google/android/material/timepicker/ClockHandView;->isInTapRegion:Z

    iput-boolean v1, p0, Lcom/google/android/material/timepicker/ClockHandView;->changedDuringTouch:Z

    move v0, v1

    move v4, v0

    move v5, v8

    :goto_4b
    iget-boolean v9, p0, Lcom/google/android/material/timepicker/ClockHandView;->changedDuringTouch:Z

    move-object v1, p0

    move v2, v7

    move v3, p1

    move v6, v0

    invoke-direct/range {v1 .. v6}, Lcom/google/android/material/timepicker/ClockHandView;->handleTouchInput(FFZZZ)Z

    move-result v1

    or-int/2addr v1, v9

    iput-boolean v1, p0, Lcom/google/android/material/timepicker/ClockHandView;->changedDuringTouch:Z

    if-eqz v1, :cond_6a

    if-eqz v0, :cond_6a

    iget-object v0, p0, Lcom/google/android/material/timepicker/ClockHandView;->onActionUpListener:Lcom/google/android/material/timepicker/ClockHandView$OnActionUpListener;

    if-eqz v0, :cond_6a

    invoke-direct {p0, v7, p1}, Lcom/google/android/material/timepicker/ClockHandView;->getDegreesFromXY(FF)I

    move-result p1

    int-to-float p1, p1

    iget-boolean v1, p0, Lcom/google/android/material/timepicker/ClockHandView;->isInTapRegion:Z

    invoke-interface {v0, p1, v1}, Lcom/google/android/material/timepicker/ClockHandView$OnActionUpListener;->onActionUp(FZ)V

    :cond_6a
    return v8
.end method

.method public setAnimateOnTouchUp(Z)V
    .registers 2

    iput-boolean p1, p0, Lcom/google/android/material/timepicker/ClockHandView;->animatingOnTouchUp:Z

    return-void
.end method

.method public setCircleRadius(I)V
    .registers 2

    iput p1, p0, Lcom/google/android/material/timepicker/ClockHandView;->circleRadius:I

    invoke-virtual {p0}, Lcom/google/android/material/timepicker/ClockHandView;->invalidate()V

    return-void
.end method

.method setCurrentLevel(I)V
    .registers 2

    iput p1, p0, Lcom/google/android/material/timepicker/ClockHandView;->currentLevel:I

    invoke-virtual {p0}, Lcom/google/android/material/timepicker/ClockHandView;->invalidate()V

    return-void
.end method

.method public setHandRotation(F)V
    .registers 3

    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/google/android/material/timepicker/ClockHandView;->setHandRotation(FZ)V

    return-void
.end method

.method public setHandRotation(FZ)V
    .registers 6

    iget-object v0, p0, Lcom/google/android/material/timepicker/ClockHandView;->rotationAnimator:Landroid/animation/ValueAnimator;

    if-eqz v0, :cond_7

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->cancel()V

    :cond_7
    const/4 v0, 0x0

    if-nez p2, :cond_e

    invoke-direct {p0, p1, v0}, Lcom/google/android/material/timepicker/ClockHandView;->setHandRotationInternal(FZ)V

    return-void

    :cond_e
    invoke-direct {p0, p1}, Lcom/google/android/material/timepicker/ClockHandView;->getValuesForAnimation(F)Landroid/util/Pair;

    move-result-object p1

    iget-object p2, p0, Lcom/google/android/material/timepicker/ClockHandView;->rotationAnimator:Landroid/animation/ValueAnimator;

    const/4 v1, 0x2

    new-array v1, v1, [F

    iget-object v2, p1, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v2, Ljava/lang/Float;

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v2

    aput v2, v1, v0

    iget-object p1, p1, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast p1, Ljava/lang/Float;

    invoke-virtual {p1}, Ljava/lang/Float;->floatValue()F

    move-result p1

    const/4 v0, 0x1

    aput p1, v1, v0

    invoke-virtual {p2, v1}, Landroid/animation/ValueAnimator;->setFloatValues([F)V

    iget-object p1, p0, Lcom/google/android/material/timepicker/ClockHandView;->rotationAnimator:Landroid/animation/ValueAnimator;

    iget p2, p0, Lcom/google/android/material/timepicker/ClockHandView;->animationDuration:I

    int-to-long v0, p2

    invoke-virtual {p1, v0, v1}, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;

    iget-object p1, p0, Lcom/google/android/material/timepicker/ClockHandView;->rotationAnimator:Landroid/animation/ValueAnimator;

    iget-object p2, p0, Lcom/google/android/material/timepicker/ClockHandView;->animationInterpolator:Landroid/animation/TimeInterpolator;

    invoke-virtual {p1, p2}, Landroid/animation/ValueAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    iget-object p1, p0, Lcom/google/android/material/timepicker/ClockHandView;->rotationAnimator:Landroid/animation/ValueAnimator;

    new-instance p2, Lcom/google/android/material/timepicker/ClockHandView$$ExternalSyntheticLambda0;

    invoke-direct {p2, p0}, Lcom/google/android/material/timepicker/ClockHandView$$ExternalSyntheticLambda0;-><init>(Lcom/google/android/material/timepicker/ClockHandView;)V

    invoke-virtual {p1, p2}, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V

    iget-object p1, p0, Lcom/google/android/material/timepicker/ClockHandView;->rotationAnimator:Landroid/animation/ValueAnimator;

    new-instance p2, Lcom/google/android/material/timepicker/ClockHandView$1;

    invoke-direct {p2, p0}, Lcom/google/android/material/timepicker/ClockHandView$1;-><init>(Lcom/google/android/material/timepicker/ClockHandView;)V

    invoke-virtual {p1, p2}, Landroid/animation/ValueAnimator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    iget-object p1, p0, Lcom/google/android/material/timepicker/ClockHandView;->rotationAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {p1}, Landroid/animation/ValueAnimator;->start()V

    return-void
.end method

.method setMultiLevel(Z)V
    .registers 3

    iget-boolean v0, p0, Lcom/google/android/material/timepicker/ClockHandView;->isMultiLevel:Z

    if-eqz v0, :cond_9

    if-nez p1, :cond_9

    const/4 v0, 0x1

    iput v0, p0, Lcom/google/android/material/timepicker/ClockHandView;->currentLevel:I

    :cond_9
    iput-boolean p1, p0, Lcom/google/android/material/timepicker/ClockHandView;->isMultiLevel:Z

    invoke-virtual {p0}, Lcom/google/android/material/timepicker/ClockHandView;->invalidate()V

    return-void
.end method

.method public setOnActionUpListener(Lcom/google/android/material/timepicker/ClockHandView$OnActionUpListener;)V
    .registers 2

    iput-object p1, p0, Lcom/google/android/material/timepicker/ClockHandView;->onActionUpListener:Lcom/google/android/material/timepicker/ClockHandView$OnActionUpListener;

    return-void
.end method
