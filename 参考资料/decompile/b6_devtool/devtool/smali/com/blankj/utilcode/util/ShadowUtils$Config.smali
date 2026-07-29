.class public Lcom/blankj/utilcode/util/ShadowUtils$Config;
.super Ljava/lang/Object;
.source "ShadowUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/blankj/utilcode/util/ShadowUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Config"
.end annotation


# static fields
.field private static final SHADOW_COLOR_DEFAULT:I = 0x44000000

.field private static final SHADOW_SIZE:I


# instance fields
.field private isCircle:Z

.field private mShadowColorNormal:I

.field private mShadowColorPressed:I

.field private mShadowMaxSizeNormal:F

.field private mShadowMaxSizePressed:F

.field private mShadowRadius:F

.field private mShadowSizeNormal:F

.field private mShadowSizePressed:F


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const/high16 v0, 0x41000000    # 8.0f

    invoke-static {v0}, Lcom/blankj/utilcode/util/UtilsBridge;->dp2px(F)I

    move-result v0

    sput v0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->SHADOW_SIZE:I

    return-void
.end method

.method public constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/high16 v0, -0x40800000    # -1.0f

    iput v0, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowRadius:F

    iput v0, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowSizeNormal:F

    iput v0, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowSizePressed:F

    iput v0, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowMaxSizeNormal:F

    iput v0, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowMaxSizePressed:F

    const/high16 v0, 0x44000000    # 512.0f

    iput v0, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowColorNormal:I

    iput v0, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowColorPressed:I

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->isCircle:Z

    return-void
.end method

.method private getShadowMaxSizeNormal()F
    .registers 3

    iget v0, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowMaxSizeNormal:F

    const/high16 v1, -0x40800000    # -1.0f

    cmpl-float v0, v0, v1

    if-nez v0, :cond_e

    invoke-direct {p0}, Lcom/blankj/utilcode/util/ShadowUtils$Config;->getShadowSizeNormal()F

    move-result v0

    iput v0, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowMaxSizeNormal:F

    :cond_e
    iget v0, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowMaxSizeNormal:F

    return v0
.end method

.method private getShadowMaxSizePressed()F
    .registers 3

    iget v0, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowMaxSizePressed:F

    const/high16 v1, -0x40800000    # -1.0f

    cmpl-float v0, v0, v1

    if-nez v0, :cond_e

    invoke-direct {p0}, Lcom/blankj/utilcode/util/ShadowUtils$Config;->getShadowSizePressed()F

    move-result v0

    iput v0, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowMaxSizePressed:F

    :cond_e
    iget v0, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowMaxSizePressed:F

    return v0
.end method

.method private getShadowRadius()F
    .registers 3

    iget v0, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowRadius:F

    const/4 v1, 0x0

    cmpg-float v0, v0, v1

    if-gez v0, :cond_9

    iput v1, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowRadius:F

    :cond_9
    iget v0, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowRadius:F

    return v0
.end method

.method private getShadowSizeNormal()F
    .registers 3

    iget v0, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowSizeNormal:F

    const/high16 v1, -0x40800000    # -1.0f

    cmpl-float v0, v0, v1

    if-nez v0, :cond_d

    sget v0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->SHADOW_SIZE:I

    int-to-float v0, v0

    iput v0, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowSizeNormal:F

    :cond_d
    iget v0, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowSizeNormal:F

    return v0
.end method

.method private getShadowSizePressed()F
    .registers 3

    iget v0, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowSizePressed:F

    const/high16 v1, -0x40800000    # -1.0f

    cmpl-float v0, v0, v1

    if-nez v0, :cond_e

    invoke-direct {p0}, Lcom/blankj/utilcode/util/ShadowUtils$Config;->getShadowSizeNormal()F

    move-result v0

    iput v0, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowSizePressed:F

    :cond_e
    iget v0, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowSizePressed:F

    return v0
.end method


# virtual methods
.method apply(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;
    .registers 12

    const/4 v0, 0x0

    if-nez p1, :cond_8

    new-instance p1, Landroid/graphics/drawable/ColorDrawable;

    invoke-direct {p1, v0}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    :cond_8
    new-instance v8, Landroid/graphics/drawable/StateListDrawable;

    invoke-direct {v8}, Landroid/graphics/drawable/StateListDrawable;-><init>()V

    const/4 v1, 0x1

    new-array v9, v1, [I

    const v1, 0x10100a7

    aput v1, v9, v0

    new-instance v0, Lcom/blankj/utilcode/util/ShadowUtils$ShadowDrawable;

    invoke-direct {p0}, Lcom/blankj/utilcode/util/ShadowUtils$Config;->getShadowRadius()F

    move-result v3

    invoke-direct {p0}, Lcom/blankj/utilcode/util/ShadowUtils$Config;->getShadowSizeNormal()F

    move-result v4

    invoke-direct {p0}, Lcom/blankj/utilcode/util/ShadowUtils$Config;->getShadowMaxSizeNormal()F

    move-result v5

    iget v6, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowColorPressed:I

    iget-boolean v7, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->isCircle:Z

    move-object v1, v0

    move-object v2, p1

    invoke-direct/range {v1 .. v7}, Lcom/blankj/utilcode/util/ShadowUtils$ShadowDrawable;-><init>(Landroid/graphics/drawable/Drawable;FFFIZ)V

    invoke-virtual {v8, v9, v0}, Landroid/graphics/drawable/StateListDrawable;->addState([ILandroid/graphics/drawable/Drawable;)V

    sget-object v0, Landroid/util/StateSet;->WILD_CARD:[I

    new-instance v9, Lcom/blankj/utilcode/util/ShadowUtils$ShadowDrawable;

    invoke-direct {p0}, Lcom/blankj/utilcode/util/ShadowUtils$Config;->getShadowRadius()F

    move-result v3

    invoke-direct {p0}, Lcom/blankj/utilcode/util/ShadowUtils$Config;->getShadowSizePressed()F

    move-result v4

    invoke-direct {p0}, Lcom/blankj/utilcode/util/ShadowUtils$Config;->getShadowMaxSizePressed()F

    move-result v5

    iget v6, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowColorNormal:I

    iget-boolean v7, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->isCircle:Z

    move-object v1, v9

    invoke-direct/range {v1 .. v7}, Lcom/blankj/utilcode/util/ShadowUtils$ShadowDrawable;-><init>(Landroid/graphics/drawable/Drawable;FFFIZ)V

    invoke-virtual {v8, v0, v9}, Landroid/graphics/drawable/StateListDrawable;->addState([ILandroid/graphics/drawable/Drawable;)V

    return-object v8
.end method

.method public setCircle()Lcom/blankj/utilcode/util/ShadowUtils$Config;
    .registers 3

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->isCircle:Z

    iget v0, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowRadius:F

    const/high16 v1, -0x40800000    # -1.0f

    cmpl-float v0, v0, v1

    if-nez v0, :cond_c

    return-object p0

    :cond_c
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Set circle needn\'t set radius."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public setShadowColor(I)Lcom/blankj/utilcode/util/ShadowUtils$Config;
    .registers 2

    invoke-virtual {p0, p1, p1}, Lcom/blankj/utilcode/util/ShadowUtils$Config;->setShadowColor(II)Lcom/blankj/utilcode/util/ShadowUtils$Config;

    move-result-object p1

    return-object p1
.end method

.method public setShadowColor(II)Lcom/blankj/utilcode/util/ShadowUtils$Config;
    .registers 3

    iput p1, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowColorNormal:I

    iput p2, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowColorPressed:I

    return-object p0
.end method

.method public setShadowMaxSize(I)Lcom/blankj/utilcode/util/ShadowUtils$Config;
    .registers 2

    invoke-virtual {p0, p1, p1}, Lcom/blankj/utilcode/util/ShadowUtils$Config;->setShadowMaxSize(II)Lcom/blankj/utilcode/util/ShadowUtils$Config;

    move-result-object p1

    return-object p1
.end method

.method public setShadowMaxSize(II)Lcom/blankj/utilcode/util/ShadowUtils$Config;
    .registers 3

    int-to-float p1, p1

    iput p1, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowMaxSizeNormal:F

    int-to-float p1, p2

    iput p1, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowMaxSizePressed:F

    return-object p0
.end method

.method public setShadowRadius(F)Lcom/blankj/utilcode/util/ShadowUtils$Config;
    .registers 3

    iput p1, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowRadius:F

    iget-boolean p1, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->isCircle:Z

    if-nez p1, :cond_7

    return-object p0

    :cond_7
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string v0, "Set circle needn\'t set radius."

    invoke-direct {p1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public setShadowSize(I)Lcom/blankj/utilcode/util/ShadowUtils$Config;
    .registers 2

    invoke-virtual {p0, p1, p1}, Lcom/blankj/utilcode/util/ShadowUtils$Config;->setShadowSize(II)Lcom/blankj/utilcode/util/ShadowUtils$Config;

    move-result-object p1

    return-object p1
.end method

.method public setShadowSize(II)Lcom/blankj/utilcode/util/ShadowUtils$Config;
    .registers 3

    int-to-float p1, p1

    iput p1, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowSizeNormal:F

    int-to-float p1, p2

    iput p1, p0, Lcom/blankj/utilcode/util/ShadowUtils$Config;->mShadowSizePressed:F

    return-object p0
.end method
