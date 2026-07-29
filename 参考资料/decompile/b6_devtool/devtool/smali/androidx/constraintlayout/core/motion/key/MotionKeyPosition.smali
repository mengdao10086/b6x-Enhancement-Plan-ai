.class public Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;
.super Landroidx/constraintlayout/core/motion/key/MotionKey;
.source "MotionKeyPosition.java"


# static fields
.field static final KEY_TYPE:I = 0x2

.field static final NAME:Ljava/lang/String; = "KeyPosition"

.field protected static final SELECTION_SLOPE:F = 20.0f

.field public static final TYPE_CARTESIAN:I = 0x0

.field public static final TYPE_PATH:I = 0x1

.field public static final TYPE_SCREEN:I = 0x2


# instance fields
.field public mAltPercentX:F

.field public mAltPercentY:F

.field private mCalculatedPositionX:F

.field private mCalculatedPositionY:F

.field public mCurveFit:I

.field public mDrawPath:I

.field public mPathMotionArc:I

.field public mPercentHeight:F

.field public mPercentWidth:F

.field public mPercentX:F

.field public mPercentY:F

.field public mPositionType:I

.field public mTransitionEasing:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .registers 3

    invoke-direct {p0}, Landroidx/constraintlayout/core/motion/key/MotionKey;-><init>()V

    sget v0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->UNSET:I

    iput v0, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mCurveFit:I

    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mTransitionEasing:Ljava/lang/String;

    sget v0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->UNSET:I

    iput v0, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mPathMotionArc:I

    const/4 v0, 0x0

    iput v0, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mDrawPath:I

    const/high16 v1, 0x7fc00000    # Float.NaN

    iput v1, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mPercentWidth:F

    iput v1, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mPercentHeight:F

    iput v1, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mPercentX:F

    iput v1, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mPercentY:F

    iput v1, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mAltPercentX:F

    iput v1, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mAltPercentY:F

    iput v0, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mPositionType:I

    iput v1, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mCalculatedPositionX:F

    iput v1, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mCalculatedPositionY:F

    const/4 v0, 0x2

    iput v0, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mType:I

    return-void
.end method

.method private calcCartesianPosition(FFFF)V
    .registers 10

    sub-float/2addr p3, p1

    sub-float/2addr p4, p2

    iget v0, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mPercentX:F

    invoke-static {v0}, Ljava/lang/Float;->isNaN(F)Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_d

    move v0, v1

    goto :goto_f

    :cond_d
    iget v0, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mPercentX:F

    :goto_f
    iget v2, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mAltPercentY:F

    invoke-static {v2}, Ljava/lang/Float;->isNaN(F)Z

    move-result v2

    if-eqz v2, :cond_19

    move v2, v1

    goto :goto_1b

    :cond_19
    iget v2, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mAltPercentY:F

    :goto_1b
    iget v3, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mPercentY:F

    invoke-static {v3}, Ljava/lang/Float;->isNaN(F)Z

    move-result v3

    if-eqz v3, :cond_25

    move v3, v1

    goto :goto_27

    :cond_25
    iget v3, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mPercentY:F

    :goto_27
    iget v4, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mAltPercentX:F

    invoke-static {v4}, Ljava/lang/Float;->isNaN(F)Z

    move-result v4

    if-eqz v4, :cond_30

    goto :goto_32

    :cond_30
    iget v1, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mAltPercentX:F

    :goto_32
    mul-float/2addr v0, p3

    add-float/2addr p1, v0

    mul-float/2addr v1, p4

    add-float/2addr p1, v1

    float-to-int p1, p1

    int-to-float p1, p1

    iput p1, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mCalculatedPositionX:F

    mul-float/2addr p3, v2

    add-float/2addr p2, p3

    mul-float/2addr p4, v3

    add-float/2addr p2, p4

    float-to-int p1, p2

    int-to-float p1, p1

    iput p1, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mCalculatedPositionY:F

    return-void
.end method

.method private calcPathPosition(FFFF)V
    .registers 8

    sub-float/2addr p3, p1

    sub-float/2addr p4, p2

    neg-float v0, p4

    iget v1, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mPercentX:F

    mul-float v2, p3, v1

    add-float/2addr p1, v2

    iget v2, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mPercentY:F

    mul-float/2addr v0, v2

    add-float/2addr p1, v0

    iput p1, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mCalculatedPositionX:F

    mul-float/2addr p4, v1

    add-float/2addr p2, p4

    mul-float/2addr p3, v2

    add-float/2addr p2, p3

    iput p2, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mCalculatedPositionY:F

    return-void
.end method

.method private calcScreenPosition(II)V
    .registers 6

    const/4 v0, 0x0

    sub-int/2addr p1, v0

    int-to-float p1, p1

    iget v1, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mPercentX:F

    mul-float/2addr p1, v1

    int-to-float v2, v0

    add-float/2addr p1, v2

    iput p1, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mCalculatedPositionX:F

    sub-int/2addr p2, v0

    int-to-float p1, p2

    mul-float/2addr p1, v1

    add-float/2addr p1, v2

    iput p1, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mCalculatedPositionY:F

    return-void
.end method


# virtual methods
.method public addValues(Ljava/util/HashMap;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap<",
            "Ljava/lang/String;",
            "Landroidx/constraintlayout/core/motion/utils/SplineSet;",
            ">;)V"
        }
    .end annotation

    return-void
.end method

.method calcPosition(IIFFFF)V
    .registers 9

    iget v0, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mPositionType:I

    const/4 v1, 0x1

    if-eq v0, v1, :cond_10

    const/4 v1, 0x2

    if-eq v0, v1, :cond_c

    invoke-direct {p0, p3, p4, p5, p6}, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->calcCartesianPosition(FFFF)V

    return-void

    :cond_c
    invoke-direct {p0, p1, p2}, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->calcScreenPosition(II)V

    return-void

    :cond_10
    invoke-direct {p0, p3, p4, p5, p6}, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->calcPathPosition(FFFF)V

    return-void
.end method

.method public clone()Landroidx/constraintlayout/core/motion/key/MotionKey;
    .registers 2

    new-instance v0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;

    invoke-direct {v0}, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;-><init>()V

    invoke-virtual {v0, p0}, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->copy(Landroidx/constraintlayout/core/motion/key/MotionKey;)Landroidx/constraintlayout/core/motion/key/MotionKey;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic clone()Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    invoke-virtual {p0}, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->clone()Landroidx/constraintlayout/core/motion/key/MotionKey;

    move-result-object v0

    return-object v0
.end method

.method public copy(Landroidx/constraintlayout/core/motion/key/MotionKey;)Landroidx/constraintlayout/core/motion/key/MotionKey;
    .registers 3

    invoke-super {p0, p1}, Landroidx/constraintlayout/core/motion/key/MotionKey;->copy(Landroidx/constraintlayout/core/motion/key/MotionKey;)Landroidx/constraintlayout/core/motion/key/MotionKey;

    check-cast p1, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;

    iget-object v0, p1, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mTransitionEasing:Ljava/lang/String;

    iput-object v0, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mTransitionEasing:Ljava/lang/String;

    iget v0, p1, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mPathMotionArc:I

    iput v0, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mPathMotionArc:I

    iget v0, p1, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mDrawPath:I

    iput v0, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mDrawPath:I

    iget v0, p1, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mPercentWidth:F

    iput v0, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mPercentWidth:F

    const/high16 v0, 0x7fc00000    # Float.NaN

    iput v0, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mPercentHeight:F

    iget v0, p1, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mPercentX:F

    iput v0, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mPercentX:F

    iget v0, p1, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mPercentY:F

    iput v0, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mPercentY:F

    iget v0, p1, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mAltPercentX:F

    iput v0, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mAltPercentX:F

    iget v0, p1, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mAltPercentY:F

    iput v0, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mAltPercentY:F

    iget v0, p1, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mCalculatedPositionX:F

    iput v0, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mCalculatedPositionX:F

    iget p1, p1, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mCalculatedPositionY:F

    iput p1, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mCalculatedPositionY:F

    return-object p0
.end method

.method public getAttributeNames(Ljava/util/HashSet;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashSet<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    return-void
.end method

.method public getId(Ljava/lang/String;)I
    .registers 2

    invoke-static {p1}, Landroidx/constraintlayout/core/motion/utils/TypedValues$PositionType;->getId(Ljava/lang/String;)I

    move-result p1

    return p1
.end method

.method getPositionX()F
    .registers 2

    iget v0, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mCalculatedPositionX:F

    return v0
.end method

.method getPositionY()F
    .registers 2

    iget v0, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mCalculatedPositionY:F

    return v0
.end method

.method public intersects(IILandroidx/constraintlayout/core/motion/utils/FloatRect;Landroidx/constraintlayout/core/motion/utils/FloatRect;FF)Z
    .registers 14

    invoke-virtual {p3}, Landroidx/constraintlayout/core/motion/utils/FloatRect;->centerX()F

    move-result v3

    invoke-virtual {p3}, Landroidx/constraintlayout/core/motion/utils/FloatRect;->centerY()F

    move-result v4

    invoke-virtual {p4}, Landroidx/constraintlayout/core/motion/utils/FloatRect;->centerX()F

    move-result v5

    invoke-virtual {p4}, Landroidx/constraintlayout/core/motion/utils/FloatRect;->centerY()F

    move-result v6

    move-object v0, p0

    move v1, p1

    move v2, p2

    invoke-virtual/range {v0 .. v6}, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->calcPosition(IIFFFF)V

    iget p1, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mCalculatedPositionX:F

    sub-float/2addr p5, p1

    invoke-static {p5}, Ljava/lang/Math;->abs(F)F

    move-result p1

    const/high16 p2, 0x41a00000    # 20.0f

    cmpg-float p1, p1, p2

    if-gez p1, :cond_30

    iget p1, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mCalculatedPositionY:F

    sub-float/2addr p6, p1

    invoke-static {p6}, Ljava/lang/Math;->abs(F)F

    move-result p1

    cmpg-float p1, p1, p2

    if-gez p1, :cond_30

    const/4 p1, 0x1

    return p1

    :cond_30
    const/4 p1, 0x0

    return p1
.end method

.method public positionAttributes(Landroidx/constraintlayout/core/motion/MotionWidget;Landroidx/constraintlayout/core/motion/utils/FloatRect;Landroidx/constraintlayout/core/motion/utils/FloatRect;FF[Ljava/lang/String;[F)V
    .registers 15

    iget v0, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mPositionType:I

    const/4 v1, 0x1

    if-eq v0, v1, :cond_17

    const/4 v1, 0x2

    if-eq v0, v1, :cond_13

    move-object v0, p0

    move-object v1, p2

    move-object v2, p3

    move v3, p4

    move v4, p5

    move-object v5, p6

    move-object v6, p7

    invoke-virtual/range {v0 .. v6}, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->positionCartAttributes(Landroidx/constraintlayout/core/motion/utils/FloatRect;Landroidx/constraintlayout/core/motion/utils/FloatRect;FF[Ljava/lang/String;[F)V

    return-void

    :cond_13
    invoke-virtual/range {p0 .. p7}, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->positionScreenAttributes(Landroidx/constraintlayout/core/motion/MotionWidget;Landroidx/constraintlayout/core/motion/utils/FloatRect;Landroidx/constraintlayout/core/motion/utils/FloatRect;FF[Ljava/lang/String;[F)V

    return-void

    :cond_17
    move-object v0, p0

    move-object v1, p2

    move-object v2, p3

    move v3, p4

    move v4, p5

    move-object v5, p6

    move-object v6, p7

    invoke-virtual/range {v0 .. v6}, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->positionPathAttributes(Landroidx/constraintlayout/core/motion/utils/FloatRect;Landroidx/constraintlayout/core/motion/utils/FloatRect;FF[Ljava/lang/String;[F)V

    return-void
.end method

.method positionCartAttributes(Landroidx/constraintlayout/core/motion/utils/FloatRect;Landroidx/constraintlayout/core/motion/utils/FloatRect;FF[Ljava/lang/String;[F)V
    .registers 13

    invoke-virtual {p1}, Landroidx/constraintlayout/core/motion/utils/FloatRect;->centerX()F

    move-result v0

    invoke-virtual {p1}, Landroidx/constraintlayout/core/motion/utils/FloatRect;->centerY()F

    move-result p1

    invoke-virtual {p2}, Landroidx/constraintlayout/core/motion/utils/FloatRect;->centerX()F

    move-result v1

    invoke-virtual {p2}, Landroidx/constraintlayout/core/motion/utils/FloatRect;->centerY()F

    move-result p2

    sub-float/2addr v1, v0

    sub-float/2addr p2, p1

    const/4 v2, 0x0

    aget-object v3, p5, v2

    const-string v4, "percentX"

    const/4 v5, 0x1

    if-eqz v3, :cond_32

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p5

    if-eqz p5, :cond_29

    sub-float/2addr p3, v0

    div-float/2addr p3, v1

    aput p3, p6, v2

    sub-float/2addr p4, p1

    div-float/2addr p4, p2

    aput p4, p6, v5

    goto :goto_40

    :cond_29
    sub-float/2addr p3, v0

    div-float/2addr p3, v1

    aput p3, p6, v5

    sub-float/2addr p4, p1

    div-float/2addr p4, p2

    aput p4, p6, v2

    goto :goto_40

    :cond_32
    aput-object v4, p5, v2

    sub-float/2addr p3, v0

    div-float/2addr p3, v1

    aput p3, p6, v2

    const-string p3, "percentY"

    aput-object p3, p5, v5

    sub-float/2addr p4, p1

    div-float/2addr p4, p2

    aput p4, p6, v5

    :goto_40
    return-void
.end method

.method positionPathAttributes(Landroidx/constraintlayout/core/motion/utils/FloatRect;Landroidx/constraintlayout/core/motion/utils/FloatRect;FF[Ljava/lang/String;[F)V
    .registers 14

    invoke-virtual {p1}, Landroidx/constraintlayout/core/motion/utils/FloatRect;->centerX()F

    move-result v0

    invoke-virtual {p1}, Landroidx/constraintlayout/core/motion/utils/FloatRect;->centerY()F

    move-result p1

    invoke-virtual {p2}, Landroidx/constraintlayout/core/motion/utils/FloatRect;->centerX()F

    move-result v1

    invoke-virtual {p2}, Landroidx/constraintlayout/core/motion/utils/FloatRect;->centerY()F

    move-result p2

    sub-float/2addr v1, v0

    sub-float/2addr p2, p1

    float-to-double v2, v1

    float-to-double v4, p2

    invoke-static {v2, v3, v4, v5}, Ljava/lang/Math;->hypot(DD)D

    move-result-wide v2

    double-to-float v2, v2

    float-to-double v3, v2

    const-wide v5, 0x3f1a36e2eb1c432dL    # 1.0E-4

    cmpg-double v3, v3, v5

    const/4 v4, 0x1

    const/4 v5, 0x0

    if-gez v3, :cond_32

    sget-object p1, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string p2, "distance ~ 0"

    invoke-virtual {p1, p2}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    const/4 p1, 0x0

    aput p1, p6, v5

    aput p1, p6, v4

    return-void

    :cond_32
    div-float/2addr v1, v2

    div-float/2addr p2, v2

    sub-float/2addr p4, p1

    mul-float p1, v1, p4

    sub-float/2addr p3, v0

    mul-float v0, p3, p2

    sub-float/2addr p1, v0

    div-float/2addr p1, v2

    mul-float/2addr v1, p3

    mul-float/2addr p2, p4

    add-float/2addr v1, p2

    div-float/2addr v1, v2

    aget-object p2, p5, v5

    const-string p3, "percentX"

    if-eqz p2, :cond_51

    invoke-virtual {p3, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p2

    if-eqz p2, :cond_5b

    aput v1, p6, v5

    aput p1, p6, v4

    goto :goto_5b

    :cond_51
    aput-object p3, p5, v5

    const-string p2, "percentY"

    aput-object p2, p5, v4

    aput v1, p6, v5

    aput p1, p6, v4

    :cond_5b
    :goto_5b
    return-void
.end method

.method positionScreenAttributes(Landroidx/constraintlayout/core/motion/MotionWidget;Landroidx/constraintlayout/core/motion/utils/FloatRect;Landroidx/constraintlayout/core/motion/utils/FloatRect;FF[Ljava/lang/String;[F)V
    .registers 11

    invoke-virtual {p2}, Landroidx/constraintlayout/core/motion/utils/FloatRect;->centerX()F

    invoke-virtual {p2}, Landroidx/constraintlayout/core/motion/utils/FloatRect;->centerY()F

    invoke-virtual {p3}, Landroidx/constraintlayout/core/motion/utils/FloatRect;->centerX()F

    invoke-virtual {p3}, Landroidx/constraintlayout/core/motion/utils/FloatRect;->centerY()F

    invoke-virtual {p1}, Landroidx/constraintlayout/core/motion/MotionWidget;->getParent()Landroidx/constraintlayout/core/motion/MotionWidget;

    move-result-object p1

    invoke-virtual {p1}, Landroidx/constraintlayout/core/motion/MotionWidget;->getWidth()I

    move-result p2

    invoke-virtual {p1}, Landroidx/constraintlayout/core/motion/MotionWidget;->getHeight()I

    move-result p1

    const/4 p3, 0x0

    aget-object v0, p6, p3

    const-string v1, "percentX"

    const/4 v2, 0x1

    if-eqz v0, :cond_38

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p6

    if-eqz p6, :cond_2f

    int-to-float p2, p2

    div-float/2addr p4, p2

    aput p4, p7, p3

    int-to-float p1, p1

    div-float/2addr p5, p1

    aput p5, p7, v2

    goto :goto_46

    :cond_2f
    int-to-float p2, p2

    div-float/2addr p4, p2

    aput p4, p7, v2

    int-to-float p1, p1

    div-float/2addr p5, p1

    aput p5, p7, p3

    goto :goto_46

    :cond_38
    aput-object v1, p6, p3

    int-to-float p2, p2

    div-float/2addr p4, p2

    aput p4, p7, p3

    const-string p2, "percentY"

    aput-object p2, p6, v2

    int-to-float p1, p1

    div-float/2addr p5, p1

    aput p5, p7, v2

    :goto_46
    return-void
.end method

.method public setValue(IF)Z
    .registers 3

    packed-switch p1, :pswitch_data_1a

    invoke-super {p0, p1, p2}, Landroidx/constraintlayout/core/motion/key/MotionKey;->setValue(IF)Z

    move-result p1

    return p1

    :pswitch_8
    iput p2, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mPercentY:F

    goto :goto_18

    :pswitch_b
    iput p2, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mPercentX:F

    goto :goto_18

    :pswitch_e
    iput p2, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mPercentWidth:F

    iput p2, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mPercentHeight:F

    goto :goto_18

    :pswitch_13
    iput p2, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mPercentHeight:F

    goto :goto_18

    :pswitch_16
    iput p2, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mPercentWidth:F

    :goto_18
    const/4 p1, 0x1

    return p1

    :pswitch_data_1a
    .packed-switch 0x1f7
        :pswitch_16
        :pswitch_13
        :pswitch_e
        :pswitch_b
        :pswitch_8
    .end packed-switch
.end method

.method public setValue(II)Z
    .registers 4

    const/16 v0, 0x64

    if-eq p1, v0, :cond_17

    const/16 v0, 0x1fc

    if-eq p1, v0, :cond_14

    const/16 v0, 0x1fe

    if-eq p1, v0, :cond_11

    invoke-super {p0, p1, p2}, Landroidx/constraintlayout/core/motion/key/MotionKey;->setValue(II)Z

    move-result p1

    return p1

    :cond_11
    iput p2, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mPositionType:I

    goto :goto_19

    :cond_14
    iput p2, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mCurveFit:I

    goto :goto_19

    :cond_17
    iput p2, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mFramePosition:I

    :goto_19
    const/4 p1, 0x1

    return p1
.end method

.method public setValue(ILjava/lang/String;)Z
    .registers 4

    const/16 v0, 0x1f5

    if-eq p1, v0, :cond_9

    invoke-super {p0, p1, p2}, Landroidx/constraintlayout/core/motion/key/MotionKey;->setValue(ILjava/lang/String;)Z

    move-result p1

    return p1

    :cond_9
    invoke-virtual {p2}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object p1

    iput-object p1, p0, Landroidx/constraintlayout/core/motion/key/MotionKeyPosition;->mTransitionEasing:Ljava/lang/String;

    const/4 p1, 0x1

    return p1
.end method
