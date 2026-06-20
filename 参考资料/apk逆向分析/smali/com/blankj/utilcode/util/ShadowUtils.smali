.class public Lcom/blankj/utilcode/util/ShadowUtils;
.super Ljava/lang/Object;
.source "ShadowUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/blankj/utilcode/util/ShadowUtils$DrawableWrapper;,
        Lcom/blankj/utilcode/util/ShadowUtils$ShadowDrawable;,
        Lcom/blankj/utilcode/util/ShadowUtils$Config;
    }
.end annotation


# static fields
.field private static final SHADOW_TAG:I = -0x10


# direct methods
.method public constructor <init>()V
    .registers 1

    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static apply(Landroid/view/View;Lcom/blankj/utilcode/util/ShadowUtils$Config;)V
    .registers 6

    if-eqz p0, :cond_23

    if-nez p1, :cond_5

    goto :goto_23

    .line 47
    :cond_5
    invoke-virtual {p0}, Landroid/view/View;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    const/16 v1, -0x10

    .line 48
    invoke-virtual {p0, v1}, Landroid/view/View;->getTag(I)Ljava/lang/Object;

    move-result-object v2

    .line 49
    instance-of v3, v2, Landroid/graphics/drawable/Drawable;

    if-eqz v3, :cond_19

    .line 50
    check-cast v2, Landroid/graphics/drawable/Drawable;

    invoke-static {p0, v2}, Landroidx/core/view/ViewCompat;->setBackground(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V

    goto :goto_23

    .line 52
    :cond_19
    invoke-virtual {p1, v0}, Lcom/blankj/utilcode/util/ShadowUtils$Config;->apply(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;

    move-result-object p1

    .line 53
    invoke-static {p0, p1}, Landroidx/core/view/ViewCompat;->setBackground(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V

    .line 54
    invoke-virtual {p0, v1, p1}, Landroid/view/View;->setTag(ILjava/lang/Object;)V

    :cond_23
    :goto_23
    return-void
.end method

.method public static varargs apply([Landroid/view/View;)V
    .registers 5

    if-nez p0, :cond_3

    return-void

    .line 40
    :cond_3
    array-length v0, p0

    const/4 v1, 0x0

    :goto_5
    if-ge v1, v0, :cond_14

    aget-object v2, p0, v1

    .line 41
    new-instance v3, Lcom/blankj/utilcode/util/ShadowUtils$Config;

    invoke-direct {v3}, Lcom/blankj/utilcode/util/ShadowUtils$Config;-><init>()V

    invoke-static {v2, v3}, Lcom/blankj/utilcode/util/ShadowUtils;->apply(Landroid/view/View;Lcom/blankj/utilcode/util/ShadowUtils$Config;)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_5

    :cond_14
    return-void
.end method
