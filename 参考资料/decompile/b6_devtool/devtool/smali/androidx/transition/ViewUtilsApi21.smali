.class Landroidx/transition/ViewUtilsApi21;
.super Landroidx/transition/ViewUtilsApi19;
.source "ViewUtilsApi21.java"


# static fields
.field private static sTryHiddenSetAnimationMatrix:Z = true

.field private static sTryHiddenTransformMatrixToGlobal:Z = true

.field private static sTryHiddenTransformMatrixToLocal:Z = true


# direct methods
.method static constructor <clinit>()V
    .registers 0

    return-void
.end method

.method constructor <init>()V
    .registers 1

    invoke-direct {p0}, Landroidx/transition/ViewUtilsApi19;-><init>()V

    return-void
.end method


# virtual methods
.method public setAnimationMatrix(Landroid/view/View;Landroid/graphics/Matrix;)V
    .registers 4

    sget-boolean v0, Landroidx/transition/ViewUtilsApi21;->sTryHiddenSetAnimationMatrix:Z

    if-eqz v0, :cond_b

    :try_start_4
    invoke-virtual {p1, p2}, Landroid/view/View;->setAnimationMatrix(Landroid/graphics/Matrix;)V
    :try_end_7
    .catch Ljava/lang/NoSuchMethodError; {:try_start_4 .. :try_end_7} :catch_8

    goto :goto_b

    :catch_8
    const/4 p1, 0x0

    sput-boolean p1, Landroidx/transition/ViewUtilsApi21;->sTryHiddenSetAnimationMatrix:Z

    :cond_b
    :goto_b
    return-void
.end method

.method public transformMatrixToGlobal(Landroid/view/View;Landroid/graphics/Matrix;)V
    .registers 4

    sget-boolean v0, Landroidx/transition/ViewUtilsApi21;->sTryHiddenTransformMatrixToGlobal:Z

    if-eqz v0, :cond_b

    :try_start_4
    invoke-virtual {p1, p2}, Landroid/view/View;->transformMatrixToGlobal(Landroid/graphics/Matrix;)V
    :try_end_7
    .catch Ljava/lang/NoSuchMethodError; {:try_start_4 .. :try_end_7} :catch_8

    goto :goto_b

    :catch_8
    const/4 p1, 0x0

    sput-boolean p1, Landroidx/transition/ViewUtilsApi21;->sTryHiddenTransformMatrixToGlobal:Z

    :cond_b
    :goto_b
    return-void
.end method

.method public transformMatrixToLocal(Landroid/view/View;Landroid/graphics/Matrix;)V
    .registers 4

    sget-boolean v0, Landroidx/transition/ViewUtilsApi21;->sTryHiddenTransformMatrixToLocal:Z

    if-eqz v0, :cond_b

    :try_start_4
    invoke-virtual {p1, p2}, Landroid/view/View;->transformMatrixToLocal(Landroid/graphics/Matrix;)V
    :try_end_7
    .catch Ljava/lang/NoSuchMethodError; {:try_start_4 .. :try_end_7} :catch_8

    goto :goto_b

    :catch_8
    const/4 p1, 0x0

    sput-boolean p1, Landroidx/transition/ViewUtilsApi21;->sTryHiddenTransformMatrixToLocal:Z

    :cond_b
    :goto_b
    return-void
.end method
