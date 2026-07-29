.class public abstract Landroidx/constraintlayout/motion/utils/ViewTimeCycle;
.super Landroidx/constraintlayout/core/motion/utils/TimeCycleSplineSet;
.source "ViewTimeCycle.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/constraintlayout/motion/utils/ViewTimeCycle$ProgressSet;,
        Landroidx/constraintlayout/motion/utils/ViewTimeCycle$CustomSet;,
        Landroidx/constraintlayout/motion/utils/ViewTimeCycle$TranslationZset;,
        Landroidx/constraintlayout/motion/utils/ViewTimeCycle$TranslationYset;,
        Landroidx/constraintlayout/motion/utils/ViewTimeCycle$TranslationXset;,
        Landroidx/constraintlayout/motion/utils/ViewTimeCycle$ScaleYset;,
        Landroidx/constraintlayout/motion/utils/ViewTimeCycle$ScaleXset;,
        Landroidx/constraintlayout/motion/utils/ViewTimeCycle$PathRotate;,
        Landroidx/constraintlayout/motion/utils/ViewTimeCycle$RotationYset;,
        Landroidx/constraintlayout/motion/utils/ViewTimeCycle$RotationXset;,
        Landroidx/constraintlayout/motion/utils/ViewTimeCycle$RotationSet;,
        Landroidx/constraintlayout/motion/utils/ViewTimeCycle$AlphaSet;,
        Landroidx/constraintlayout/motion/utils/ViewTimeCycle$ElevationSet;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String; = "ViewTimeCycle"


# direct methods
.method public constructor <init>()V
    .registers 1

    .line 38
    invoke-direct {p0}, Landroidx/constraintlayout/core/motion/utils/TimeCycleSplineSet;-><init>()V

    return-void
.end method

.method public static makeCustomSpline(Ljava/lang/String;Landroid/util/SparseArray;)Landroidx/constraintlayout/motion/utils/ViewTimeCycle;
    .registers 3
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "str",
            "attrList"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Landroid/util/SparseArray<",
            "Landroidx/constraintlayout/widget/ConstraintAttribute;",
            ">;)",
            "Landroidx/constraintlayout/motion/utils/ViewTimeCycle;"
        }
    .end annotation

    .line 69
    new-instance v0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle$CustomSet;

    invoke-direct {v0, p0, p1}, Landroidx/constraintlayout/motion/utils/ViewTimeCycle$CustomSet;-><init>(Ljava/lang/String;Landroid/util/SparseArray;)V

    return-object v0
.end method

.method public static makeSpline(Ljava/lang/String;J)Landroidx/constraintlayout/motion/utils/ViewTimeCycle;
    .registers 5
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "str",
            "currentTime"
        }
    .end annotation

    .line 74
    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    move-result v0

    const/4 v1, -0x1

    sparse-switch v0, :sswitch_data_ec

    goto/16 :goto_9c

    :sswitch_d
    const-string v0, "alpha"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_17

    goto/16 :goto_9c

    :cond_17
    const/16 v1, 0xb

    goto/16 :goto_9c

    :sswitch_1b
    const-string v0, "transitionPathRotate"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_25

    goto/16 :goto_9c

    :cond_25
    const/16 v1, 0xa

    goto/16 :goto_9c

    :sswitch_29
    const-string v0, "elevation"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_33

    goto/16 :goto_9c

    :cond_33
    const/16 v1, 0x9

    goto/16 :goto_9c

    :sswitch_37
    const-string v0, "rotation"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_41

    goto/16 :goto_9c

    :cond_41
    const/16 v1, 0x8

    goto/16 :goto_9c

    :sswitch_45
    const-string v0, "scaleY"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_4e

    goto :goto_9c

    :cond_4e
    const/4 v1, 0x7

    goto :goto_9c

    :sswitch_50
    const-string v0, "scaleX"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_59

    goto :goto_9c

    :cond_59
    const/4 v1, 0x6

    goto :goto_9c

    :sswitch_5b
    const-string v0, "progress"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_64

    goto :goto_9c

    :cond_64
    const/4 v1, 0x5

    goto :goto_9c

    :sswitch_66
    const-string v0, "translationZ"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_6f

    goto :goto_9c

    :cond_6f
    const/4 v1, 0x4

    goto :goto_9c

    :sswitch_71
    const-string v0, "translationY"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_7a

    goto :goto_9c

    :cond_7a
    const/4 v1, 0x3

    goto :goto_9c

    :sswitch_7c
    const-string v0, "translationX"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_85

    goto :goto_9c

    :cond_85
    const/4 v1, 0x2

    goto :goto_9c

    :sswitch_87
    const-string v0, "rotationY"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_90

    goto :goto_9c

    :cond_90
    const/4 v1, 0x1

    goto :goto_9c

    :sswitch_92
    const-string v0, "rotationX"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_9b

    goto :goto_9c

    :cond_9b
    const/4 v1, 0x0

    :goto_9c
    packed-switch v1, :pswitch_data_11e

    const/4 p0, 0x0

    return-object p0

    .line 76
    :pswitch_a1
    new-instance p0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle$AlphaSet;

    invoke-direct {p0}, Landroidx/constraintlayout/motion/utils/ViewTimeCycle$AlphaSet;-><init>()V

    goto :goto_e8

    .line 91
    :pswitch_a7
    new-instance p0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle$PathRotate;

    invoke-direct {p0}, Landroidx/constraintlayout/motion/utils/ViewTimeCycle$PathRotate;-><init>()V

    goto :goto_e8

    .line 79
    :pswitch_ad
    new-instance p0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle$ElevationSet;

    invoke-direct {p0}, Landroidx/constraintlayout/motion/utils/ViewTimeCycle$ElevationSet;-><init>()V

    goto :goto_e8

    .line 82
    :pswitch_b3
    new-instance p0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle$RotationSet;

    invoke-direct {p0}, Landroidx/constraintlayout/motion/utils/ViewTimeCycle$RotationSet;-><init>()V

    goto :goto_e8

    .line 97
    :pswitch_b9
    new-instance p0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle$ScaleYset;

    invoke-direct {p0}, Landroidx/constraintlayout/motion/utils/ViewTimeCycle$ScaleYset;-><init>()V

    goto :goto_e8

    .line 94
    :pswitch_bf
    new-instance p0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle$ScaleXset;

    invoke-direct {p0}, Landroidx/constraintlayout/motion/utils/ViewTimeCycle$ScaleXset;-><init>()V

    goto :goto_e8

    .line 109
    :pswitch_c5
    new-instance p0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle$ProgressSet;

    invoke-direct {p0}, Landroidx/constraintlayout/motion/utils/ViewTimeCycle$ProgressSet;-><init>()V

    goto :goto_e8

    .line 106
    :pswitch_cb
    new-instance p0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle$TranslationZset;

    invoke-direct {p0}, Landroidx/constraintlayout/motion/utils/ViewTimeCycle$TranslationZset;-><init>()V

    goto :goto_e8

    .line 103
    :pswitch_d1
    new-instance p0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle$TranslationYset;

    invoke-direct {p0}, Landroidx/constraintlayout/motion/utils/ViewTimeCycle$TranslationYset;-><init>()V

    goto :goto_e8

    .line 100
    :pswitch_d7
    new-instance p0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle$TranslationXset;

    invoke-direct {p0}, Landroidx/constraintlayout/motion/utils/ViewTimeCycle$TranslationXset;-><init>()V

    goto :goto_e8

    .line 88
    :pswitch_dd
    new-instance p0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle$RotationYset;

    invoke-direct {p0}, Landroidx/constraintlayout/motion/utils/ViewTimeCycle$RotationYset;-><init>()V

    goto :goto_e8

    .line 85
    :pswitch_e3
    new-instance p0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle$RotationXset;

    invoke-direct {p0}, Landroidx/constraintlayout/motion/utils/ViewTimeCycle$RotationXset;-><init>()V

    .line 114
    :goto_e8
    invoke-virtual {p0, p1, p2}, Landroidx/constraintlayout/motion/utils/ViewTimeCycle;->setStartTime(J)V

    return-object p0

    :sswitch_data_ec
    .sparse-switch
        -0x4a771f66 -> :sswitch_92
        -0x4a771f65 -> :sswitch_87
        -0x490b9c39 -> :sswitch_7c
        -0x490b9c38 -> :sswitch_71
        -0x490b9c37 -> :sswitch_66
        -0x3bab3dd3 -> :sswitch_5b
        -0x3621dfb2 -> :sswitch_50
        -0x3621dfb1 -> :sswitch_45
        -0x266f082 -> :sswitch_37
        -0x42d1a3 -> :sswitch_29
        0x2382115 -> :sswitch_1b
        0x589b15e -> :sswitch_d
    .end sparse-switch

    :pswitch_data_11e
    .packed-switch 0x0
        :pswitch_e3
        :pswitch_dd
        :pswitch_d7
        :pswitch_d1
        :pswitch_cb
        :pswitch_c5
        :pswitch_bf
        :pswitch_b9
        :pswitch_b3
        :pswitch_ad
        :pswitch_a7
        :pswitch_a1
    .end packed-switch
.end method


# virtual methods
.method public get(FJLandroid/view/View;Landroidx/constraintlayout/core/motion/utils/KeyCache;)F
    .registers 23
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0,
            0x0
        }
        names = {
            "pos",
            "time",
            "view",
            "cache"
        }
    .end annotation

    move-object/from16 v0, p0

    move-wide/from16 v1, p2

    move-object/from16 v3, p4

    move-object/from16 v4, p5

    .line 44
    iget-object v5, v0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle;->mCurveFit:Landroidx/constraintlayout/core/motion/utils/CurveFit;

    move/from16 v6, p1

    float-to-double v6, v6

    iget-object v8, v0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle;->mCache:[F

    invoke-virtual {v5, v6, v7, v8}, Landroidx/constraintlayout/core/motion/utils/CurveFit;->getPos(D[F)V

    .line 45
    iget-object v5, v0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle;->mCache:[F

    const/4 v6, 0x1

    aget v5, v5, v6

    const/4 v7, 0x0

    cmpl-float v8, v5, v7

    const/4 v9, 0x2

    const/4 v10, 0x0

    if-nez v8, :cond_25

    .line 47
    iput-boolean v10, v0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle;->mContinue:Z

    .line 48
    iget-object v1, v0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle;->mCache:[F

    aget v1, v1, v9

    return v1

    .line 50
    :cond_25
    iget v11, v0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle;->last_cycle:F

    invoke-static {v11}, Ljava/lang/Float;->isNaN(F)Z

    move-result v11

    if-eqz v11, :cond_3f

    .line 51
    iget-object v11, v0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle;->mType:Ljava/lang/String;

    invoke-virtual {v4, v3, v11, v10}, Landroidx/constraintlayout/core/motion/utils/KeyCache;->getFloatValue(Ljava/lang/Object;Ljava/lang/String;I)F

    move-result v11

    iput v11, v0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle;->last_cycle:F

    .line 52
    iget v11, v0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle;->last_cycle:F

    invoke-static {v11}, Ljava/lang/Float;->isNaN(F)Z

    move-result v11

    if-eqz v11, :cond_3f

    .line 53
    iput v7, v0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle;->last_cycle:F

    .line 56
    :cond_3f
    iget-wide v11, v0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle;->last_time:J

    sub-long v11, v1, v11

    .line 57
    iget v13, v0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle;->last_cycle:F

    float-to-double v13, v13

    long-to-double v11, v11

    const-wide v15, 0x3e112e0be826d695L    # 1.0E-9

    mul-double/2addr v11, v15

    float-to-double v6, v5

    mul-double/2addr v11, v6

    add-double/2addr v13, v11

    const-wide/high16 v5, 0x3ff0000000000000L    # 1.0

    rem-double/2addr v13, v5

    double-to-float v5, v13

    iput v5, v0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle;->last_cycle:F

    .line 58
    iget-object v5, v0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle;->mType:Ljava/lang/String;

    iget v6, v0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle;->last_cycle:F

    invoke-virtual {v4, v3, v5, v10, v6}, Landroidx/constraintlayout/core/motion/utils/KeyCache;->setFloatValue(Ljava/lang/Object;Ljava/lang/String;IF)V

    .line 59
    iput-wide v1, v0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle;->last_time:J

    .line 60
    iget-object v1, v0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle;->mCache:[F

    aget v1, v1, v10

    .line 61
    iget v2, v0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle;->last_cycle:F

    invoke-virtual {v0, v2}, Landroidx/constraintlayout/motion/utils/ViewTimeCycle;->calcWave(F)F

    move-result v2

    .line 62
    iget-object v3, v0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle;->mCache:[F

    aget v3, v3, v9

    mul-float/2addr v2, v1

    add-float/2addr v2, v3

    const/4 v3, 0x0

    cmpl-float v1, v1, v3

    if-nez v1, :cond_79

    if-eqz v8, :cond_77

    goto :goto_79

    :cond_77
    move v6, v10

    goto :goto_7a

    :cond_79
    :goto_79
    const/4 v6, 0x1

    .line 64
    :goto_7a
    iput-boolean v6, v0, Landroidx/constraintlayout/motion/utils/ViewTimeCycle;->mContinue:Z

    return v2
.end method

.method public abstract setProperty(Landroid/view/View;FJLandroidx/constraintlayout/core/motion/utils/KeyCache;)Z
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0,
            0x0
        }
        names = {
            "view",
            "t",
            "time",
            "cache"
        }
    .end annotation
.end method
