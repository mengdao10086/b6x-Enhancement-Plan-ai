.class public final Lcom/google/android/material/color/utilities/ViewingConditions;
.super Ljava/lang/Object;
.source "ViewingConditions.java"


# static fields
.field public static final DEFAULT:Lcom/google/android/material/color/utilities/ViewingConditions;


# instance fields
.field private final aw:D

.field private final c:D

.field private final fl:D

.field private final flRoot:D

.field private final n:D

.field private final nbb:D

.field private final nc:D

.field private final ncb:D

.field private final rgbD:[D

.field private final z:D


# direct methods
.method static constructor <clinit>()V
    .registers 9

    const/4 v0, 0x3

    new-array v1, v0, [D

    .line 42
    invoke-static {}, Lcom/google/android/material/color/utilities/ColorUtils;->whitePointD65()[D

    move-result-object v0

    const/4 v2, 0x0

    aget-wide v3, v0, v2

    aput-wide v3, v1, v2

    .line 43
    invoke-static {}, Lcom/google/android/material/color/utilities/ColorUtils;->whitePointD65()[D

    move-result-object v0

    const/4 v2, 0x1

    aget-wide v3, v0, v2

    aput-wide v3, v1, v2

    .line 44
    invoke-static {}, Lcom/google/android/material/color/utilities/ColorUtils;->whitePointD65()[D

    move-result-object v0

    const/4 v2, 0x2

    aget-wide v3, v0, v2

    aput-wide v3, v1, v2

    const-wide/high16 v2, 0x4049000000000000L    # 50.0

    .line 46
    invoke-static {v2, v3}, Lcom/google/android/material/color/utilities/ColorUtils;->yFromLstar(D)D

    move-result-wide v2

    const-wide v4, 0x404fd4bbab8b494cL    # 63.66197723675813

    mul-double/2addr v2, v4

    const-wide/high16 v4, 0x4059000000000000L    # 100.0

    div-double/2addr v2, v4

    const-wide/high16 v4, 0x4049000000000000L    # 50.0

    const-wide/high16 v6, 0x4000000000000000L    # 2.0

    const/4 v8, 0x0

    .line 40
    invoke-static/range {v1 .. v8}, Lcom/google/android/material/color/utilities/ViewingConditions;->make([DDDDZ)Lcom/google/android/material/color/utilities/ViewingConditions;

    move-result-object v0

    sput-object v0, Lcom/google/android/material/color/utilities/ViewingConditions;->DEFAULT:Lcom/google/android/material/color/utilities/ViewingConditions;

    return-void
.end method

.method private constructor <init>(DDDDDD[DDDD)V
    .registers 23

    move-object v0, p0

    .line 189
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    move-wide v1, p1

    .line 190
    iput-wide v1, v0, Lcom/google/android/material/color/utilities/ViewingConditions;->n:D

    move-wide v1, p3

    .line 191
    iput-wide v1, v0, Lcom/google/android/material/color/utilities/ViewingConditions;->aw:D

    move-wide v1, p5

    .line 192
    iput-wide v1, v0, Lcom/google/android/material/color/utilities/ViewingConditions;->nbb:D

    move-wide v1, p7

    .line 193
    iput-wide v1, v0, Lcom/google/android/material/color/utilities/ViewingConditions;->ncb:D

    move-wide v1, p9

    .line 194
    iput-wide v1, v0, Lcom/google/android/material/color/utilities/ViewingConditions;->c:D

    move-wide v1, p11

    .line 195
    iput-wide v1, v0, Lcom/google/android/material/color/utilities/ViewingConditions;->nc:D

    move-object/from16 v1, p13

    .line 196
    iput-object v1, v0, Lcom/google/android/material/color/utilities/ViewingConditions;->rgbD:[D

    move-wide/from16 v1, p14

    .line 197
    iput-wide v1, v0, Lcom/google/android/material/color/utilities/ViewingConditions;->fl:D

    move-wide/from16 v1, p16

    .line 198
    iput-wide v1, v0, Lcom/google/android/material/color/utilities/ViewingConditions;->flRoot:D

    move-wide/from16 v1, p18

    .line 199
    iput-wide v1, v0, Lcom/google/android/material/color/utilities/ViewingConditions;->z:D

    return-void
.end method

.method static make([DDDDZ)Lcom/google/android/material/color/utilities/ViewingConditions;
    .registers 47

    move-wide/from16 v0, p1

    .line 127
    sget-object v2, Lcom/google/android/material/color/utilities/Cam16;->XYZ_TO_CAM16RGB:[[D

    const/4 v3, 0x0

    .line 129
    aget-wide v4, p0, v3

    aget-object v6, v2, v3

    aget-wide v7, v6, v3

    mul-double/2addr v7, v4

    const/4 v9, 0x1

    aget-wide v10, p0, v9

    aget-wide v12, v6, v9

    mul-double/2addr v12, v10

    add-double/2addr v7, v12

    const/4 v12, 0x2

    aget-wide v13, p0, v12

    aget-wide v15, v6, v12

    mul-double/2addr v15, v13

    add-double/2addr v7, v15

    .line 130
    aget-object v6, v2, v9

    aget-wide v15, v6, v3

    mul-double/2addr v15, v4

    aget-wide v17, v6, v9

    mul-double v17, v17, v10

    add-double v15, v15, v17

    aget-wide v17, v6, v12

    mul-double v17, v17, v13

    add-double v15, v15, v17

    .line 131
    aget-object v2, v2, v12

    aget-wide v17, v2, v3

    mul-double v4, v4, v17

    aget-wide v17, v2, v9

    mul-double v10, v10, v17

    add-double/2addr v4, v10

    aget-wide v10, v2, v12

    mul-double/2addr v13, v10

    add-double/2addr v4, v13

    const-wide/high16 v10, 0x4024000000000000L    # 10.0

    div-double v13, p5, v10

    const-wide v17, 0x3fe999999999999aL    # 0.8

    add-double v30, v13, v17

    const-wide v13, 0x3feccccccccccccdL    # 0.9

    cmpl-double v2, v30, v13

    if-ltz v2, :cond_61

    const-wide v19, 0x3fe2e147ae147ae1L    # 0.59

    const-wide v21, 0x3fe6147ae147ae14L    # 0.69

    sub-double v13, v30, v13

    mul-double v23, v13, v10

    .line 135
    invoke-static/range {v19 .. v24}, Lcom/google/android/material/color/utilities/MathUtils;->lerp(DDD)D

    move-result-wide v10

    goto :goto_75

    :cond_61
    const-wide v13, 0x3fe0cccccccccccdL    # 0.525

    const-wide v19, 0x3fe2e147ae147ae1L    # 0.59

    sub-double v17, v30, v17

    mul-double v21, v17, v10

    move-wide/from16 v17, v13

    .line 136
    invoke-static/range {v17 .. v22}, Lcom/google/android/material/color/utilities/MathUtils;->lerp(DDD)D

    move-result-wide v10

    :goto_75
    move-wide/from16 v28, v10

    const-wide/high16 v10, 0x3ff0000000000000L    # 1.0

    if-eqz p7, :cond_7e

    move-wide/from16 v21, v10

    goto :goto_98

    :cond_7e
    neg-double v13, v0

    const-wide/high16 v17, 0x4045000000000000L    # 42.0

    sub-double v13, v13, v17

    const-wide/high16 v17, 0x4057000000000000L    # 92.0

    div-double v13, v13, v17

    .line 140
    invoke-static {v13, v14}, Ljava/lang/Math;->exp(D)D

    move-result-wide v13

    const-wide v17, 0x3fd1c71c71c71c72L    # 0.2777777777777778

    mul-double v13, v13, v17

    sub-double v13, v10, v13

    mul-double v13, v13, v30

    move-wide/from16 v21, v13

    :goto_98
    const-wide/16 v17, 0x0

    const-wide/high16 v19, 0x3ff0000000000000L    # 1.0

    .line 141
    invoke-static/range {v17 .. v22}, Lcom/google/android/material/color/utilities/MathUtils;->clampDouble(DDD)D

    move-result-wide v13

    const/4 v2, 0x3

    new-array v6, v2, [D

    move-object/from16 v32, v6

    const-wide/high16 v17, 0x4059000000000000L    # 100.0

    div-double v19, v17, v7

    mul-double v19, v19, v13

    add-double v19, v19, v10

    sub-double v19, v19, v13

    aput-wide v19, v6, v3

    div-double v19, v17, v15

    mul-double v19, v19, v13

    add-double v19, v19, v10

    sub-double v19, v19, v13

    aput-wide v19, v6, v9

    div-double v19, v17, v4

    mul-double v19, v19, v13

    add-double v19, v19, v10

    sub-double v19, v19, v13

    aput-wide v19, v6, v12

    const-wide/high16 v13, 0x4014000000000000L    # 5.0

    mul-double/2addr v13, v0

    add-double v19, v13, v10

    div-double v19, v10, v19

    mul-double v21, v19, v19

    mul-double v21, v21, v19

    mul-double v21, v21, v19

    sub-double v10, v10, v21

    mul-double v21, v21, v0

    const-wide v0, 0x3fb999999999999aL    # 0.1

    mul-double/2addr v0, v10

    mul-double/2addr v0, v10

    .line 150
    invoke-static {v13, v14}, Ljava/lang/Math;->cbrt(D)D

    move-result-wide v10

    mul-double/2addr v0, v10

    add-double v0, v21, v0

    move-wide/from16 v33, v0

    .line 151
    invoke-static/range {p3 .. p4}, Lcom/google/android/material/color/utilities/ColorUtils;->yFromLstar(D)D

    move-result-wide v10

    aget-wide v13, p0, v9

    div-double/2addr v10, v13

    move-wide/from16 v20, v10

    const-wide v13, 0x3ff7ae147ae147aeL    # 1.48

    .line 152
    invoke-static {v10, v11}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v22

    add-double v37, v22, v13

    const-wide v13, 0x3fc999999999999aL    # 0.2

    .line 153
    invoke-static {v10, v11, v13, v14}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v10

    const-wide v13, 0x3fe7333333333333L    # 0.725

    div-double/2addr v13, v10

    move-wide/from16 v24, v13

    move-wide/from16 v26, v13

    new-array v2, v2, [D

    aget-wide v10, v6, v3

    mul-double/2addr v10, v0

    mul-double/2addr v10, v7

    div-double v10, v10, v17

    const-wide v7, 0x3fdae147ae147ae1L    # 0.42

    .line 157
    invoke-static {v10, v11, v7, v8}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v10

    aput-wide v10, v2, v3

    aget-wide v10, v6, v9

    mul-double/2addr v10, v0

    mul-double/2addr v10, v15

    div-double v10, v10, v17

    .line 158
    invoke-static {v10, v11, v7, v8}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v10

    aput-wide v10, v2, v9

    aget-wide v10, v6, v12

    mul-double/2addr v10, v0

    mul-double/2addr v10, v4

    div-double v10, v10, v17

    .line 159
    invoke-static {v10, v11, v7, v8}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v4

    aput-wide v4, v2, v12

    aget-wide v6, v2, v3

    const-wide/high16 v10, 0x4079000000000000L    # 400.0

    mul-double v15, v6, v10

    const-wide v17, 0x403b2147ae147ae1L    # 27.13

    add-double v6, v6, v17

    div-double/2addr v15, v6

    aget-wide v6, v2, v9

    mul-double v2, v6, v10

    add-double v6, v6, v17

    div-double/2addr v2, v6

    mul-double/2addr v10, v4

    add-double v4, v4, v17

    div-double/2addr v10, v4

    const-wide/high16 v4, 0x4000000000000000L    # 2.0

    mul-double/2addr v15, v4

    add-double/2addr v15, v2

    const-wide v2, 0x3fa999999999999aL    # 0.05

    mul-double/2addr v10, v2

    add-double/2addr v15, v10

    mul-double v22, v15, v13

    .line 170
    new-instance v2, Lcom/google/android/material/color/utilities/ViewingConditions;

    move-object/from16 v19, v2

    const-wide/high16 v3, 0x3fd0000000000000L    # 0.25

    invoke-static {v0, v1, v3, v4}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v35

    invoke-direct/range {v19 .. v38}, Lcom/google/android/material/color/utilities/ViewingConditions;-><init>(DDDDDD[DDDD)V

    return-object v2
.end method


# virtual methods
.method public getAw()D
    .registers 3

    .line 63
    iget-wide v0, p0, Lcom/google/android/material/color/utilities/ViewingConditions;->aw:D

    return-wide v0
.end method

.method getC()D
    .registers 3

    .line 79
    iget-wide v0, p0, Lcom/google/android/material/color/utilities/ViewingConditions;->c:D

    return-wide v0
.end method

.method getFl()D
    .registers 3

    .line 91
    iget-wide v0, p0, Lcom/google/android/material/color/utilities/ViewingConditions;->fl:D

    return-wide v0
.end method

.method public getFlRoot()D
    .registers 3

    .line 95
    iget-wide v0, p0, Lcom/google/android/material/color/utilities/ViewingConditions;->flRoot:D

    return-wide v0
.end method

.method public getN()D
    .registers 3

    .line 67
    iget-wide v0, p0, Lcom/google/android/material/color/utilities/ViewingConditions;->n:D

    return-wide v0
.end method

.method public getNbb()D
    .registers 3

    .line 71
    iget-wide v0, p0, Lcom/google/android/material/color/utilities/ViewingConditions;->nbb:D

    return-wide v0
.end method

.method getNc()D
    .registers 3

    .line 83
    iget-wide v0, p0, Lcom/google/android/material/color/utilities/ViewingConditions;->nc:D

    return-wide v0
.end method

.method getNcb()D
    .registers 3

    .line 75
    iget-wide v0, p0, Lcom/google/android/material/color/utilities/ViewingConditions;->ncb:D

    return-wide v0
.end method

.method public getRgbD()[D
    .registers 2

    .line 87
    iget-object v0, p0, Lcom/google/android/material/color/utilities/ViewingConditions;->rgbD:[D

    return-object v0
.end method

.method getZ()D
    .registers 3

    .line 99
    iget-wide v0, p0, Lcom/google/android/material/color/utilities/ViewingConditions;->z:D

    return-wide v0
.end method
