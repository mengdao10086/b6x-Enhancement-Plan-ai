.class public Landroidx/databinding/adapters/ViewBindingAdapter;
.super Ljava/lang/Object;
.source "ViewBindingAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/databinding/adapters/ViewBindingAdapter$OnViewAttachedToWindow;,
        Landroidx/databinding/adapters/ViewBindingAdapter$OnViewDetachedFromWindow;
    }
.end annotation


# static fields
.field public static final FADING_EDGE_HORIZONTAL:I = 0x1

.field public static final FADING_EDGE_NONE:I = 0x0

.field public static final FADING_EDGE_VERTICAL:I = 0x2


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static pixelsToDimensionPixelSize(F)I
    .registers 2

    const/high16 v0, 0x3f000000    # 0.5f

    add-float/2addr v0, p0

    float-to-int v0, v0

    if-eqz v0, :cond_7

    return v0

    :cond_7
    const/4 v0, 0x0

    cmpl-float p0, p0, v0

    if-nez p0, :cond_e

    const/4 p0, 0x0

    return p0

    :cond_e
    if-lez p0, :cond_12

    const/4 p0, 0x1

    return p0

    :cond_12
    const/4 p0, -0x1

    return p0
.end method

.method public static setBackground(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V
    .registers 2

    invoke-virtual {p0, p1}, Landroid/view/View;->setBackground(Landroid/graphics/drawable/Drawable;)V

    return-void
.end method

.method public static setClickListener(Landroid/view/View;Landroid/view/View$OnClickListener;Z)V
    .registers 3

    invoke-virtual {p0, p1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    invoke-virtual {p0, p2}, Landroid/view/View;->setClickable(Z)V

    return-void
.end method

.method public static setOnAttachStateChangeListener(Landroid/view/View;Landroidx/databinding/adapters/ViewBindingAdapter$OnViewDetachedFromWindow;Landroidx/databinding/adapters/ViewBindingAdapter$OnViewAttachedToWindow;)V
    .registers 4

    if-nez p1, :cond_6

    if-nez p2, :cond_6

    const/4 p1, 0x0

    goto :goto_c

    :cond_6
    new-instance v0, Landroidx/databinding/adapters/ViewBindingAdapter$1;

    invoke-direct {v0, p2, p1}, Landroidx/databinding/adapters/ViewBindingAdapter$1;-><init>(Landroidx/databinding/adapters/ViewBindingAdapter$OnViewAttachedToWindow;Landroidx/databinding/adapters/ViewBindingAdapter$OnViewDetachedFromWindow;)V

    move-object p1, v0

    :goto_c
    sget p2, Landroidx/databinding/library/baseAdapters/R$id;->onAttachStateChangeListener:I

    invoke-static {p0, p1, p2}, Landroidx/databinding/adapters/ListenerUtil;->trackListener(Landroid/view/View;Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Landroid/view/View$OnAttachStateChangeListener;

    if-eqz p2, :cond_19

    invoke-virtual {p0, p2}, Landroid/view/View;->removeOnAttachStateChangeListener(Landroid/view/View$OnAttachStateChangeListener;)V

    :cond_19
    if-eqz p1, :cond_1e

    invoke-virtual {p0, p1}, Landroid/view/View;->addOnAttachStateChangeListener(Landroid/view/View$OnAttachStateChangeListener;)V

    :cond_1e
    return-void
.end method

.method public static setOnClick(Landroid/view/View;Landroid/view/View$OnClickListener;Z)V
    .registers 3

    invoke-virtual {p0, p1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    invoke-virtual {p0, p2}, Landroid/view/View;->setClickable(Z)V

    return-void
.end method

.method public static setOnLayoutChangeListener(Landroid/view/View;Landroid/view/View$OnLayoutChangeListener;Landroid/view/View$OnLayoutChangeListener;)V
    .registers 3

    if-eqz p1, :cond_5

    invoke-virtual {p0, p1}, Landroid/view/View;->removeOnLayoutChangeListener(Landroid/view/View$OnLayoutChangeListener;)V

    :cond_5
    if-eqz p2, :cond_a

    invoke-virtual {p0, p2}, Landroid/view/View;->addOnLayoutChangeListener(Landroid/view/View$OnLayoutChangeListener;)V

    :cond_a
    return-void
.end method

.method public static setOnLongClick(Landroid/view/View;Landroid/view/View$OnLongClickListener;Z)V
    .registers 3

    invoke-virtual {p0, p1}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    invoke-virtual {p0, p2}, Landroid/view/View;->setLongClickable(Z)V

    return-void
.end method

.method public static setOnLongClickListener(Landroid/view/View;Landroid/view/View$OnLongClickListener;Z)V
    .registers 3

    invoke-virtual {p0, p1}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    invoke-virtual {p0, p2}, Landroid/view/View;->setLongClickable(Z)V

    return-void
.end method

.method public static setPadding(Landroid/view/View;F)V
    .registers 2

    invoke-static {p1}, Landroidx/databinding/adapters/ViewBindingAdapter;->pixelsToDimensionPixelSize(F)I

    move-result p1

    invoke-virtual {p0, p1, p1, p1, p1}, Landroid/view/View;->setPadding(IIII)V

    return-void
.end method

.method public static setPaddingBottom(Landroid/view/View;F)V
    .registers 5

    invoke-static {p1}, Landroidx/databinding/adapters/ViewBindingAdapter;->pixelsToDimensionPixelSize(F)I

    move-result p1

    invoke-virtual {p0}, Landroid/view/View;->getPaddingLeft()I

    move-result v0

    invoke-virtual {p0}, Landroid/view/View;->getPaddingTop()I

    move-result v1

    invoke-virtual {p0}, Landroid/view/View;->getPaddingRight()I

    move-result v2

    invoke-virtual {p0, v0, v1, v2, p1}, Landroid/view/View;->setPadding(IIII)V

    return-void
.end method

.method public static setPaddingEnd(Landroid/view/View;F)V
    .registers 5

    invoke-static {p1}, Landroidx/databinding/adapters/ViewBindingAdapter;->pixelsToDimensionPixelSize(F)I

    move-result p1

    invoke-virtual {p0}, Landroid/view/View;->getPaddingStart()I

    move-result v0

    invoke-virtual {p0}, Landroid/view/View;->getPaddingTop()I

    move-result v1

    invoke-virtual {p0}, Landroid/view/View;->getPaddingBottom()I

    move-result v2

    invoke-virtual {p0, v0, v1, p1, v2}, Landroid/view/View;->setPaddingRelative(IIII)V

    return-void
.end method

.method public static setPaddingLeft(Landroid/view/View;F)V
    .registers 5

    invoke-static {p1}, Landroidx/databinding/adapters/ViewBindingAdapter;->pixelsToDimensionPixelSize(F)I

    move-result p1

    invoke-virtual {p0}, Landroid/view/View;->getPaddingTop()I

    move-result v0

    invoke-virtual {p0}, Landroid/view/View;->getPaddingRight()I

    move-result v1

    invoke-virtual {p0}, Landroid/view/View;->getPaddingBottom()I

    move-result v2

    invoke-virtual {p0, p1, v0, v1, v2}, Landroid/view/View;->setPadding(IIII)V

    return-void
.end method

.method public static setPaddingRight(Landroid/view/View;F)V
    .registers 5

    invoke-static {p1}, Landroidx/databinding/adapters/ViewBindingAdapter;->pixelsToDimensionPixelSize(F)I

    move-result p1

    invoke-virtual {p0}, Landroid/view/View;->getPaddingLeft()I

    move-result v0

    invoke-virtual {p0}, Landroid/view/View;->getPaddingTop()I

    move-result v1

    invoke-virtual {p0}, Landroid/view/View;->getPaddingBottom()I

    move-result v2

    invoke-virtual {p0, v0, v1, p1, v2}, Landroid/view/View;->setPadding(IIII)V

    return-void
.end method

.method public static setPaddingStart(Landroid/view/View;F)V
    .registers 5

    invoke-static {p1}, Landroidx/databinding/adapters/ViewBindingAdapter;->pixelsToDimensionPixelSize(F)I

    move-result p1

    invoke-virtual {p0}, Landroid/view/View;->getPaddingTop()I

    move-result v0

    invoke-virtual {p0}, Landroid/view/View;->getPaddingEnd()I

    move-result v1

    invoke-virtual {p0}, Landroid/view/View;->getPaddingBottom()I

    move-result v2

    invoke-virtual {p0, p1, v0, v1, v2}, Landroid/view/View;->setPaddingRelative(IIII)V

    return-void
.end method

.method public static setPaddingTop(Landroid/view/View;F)V
    .registers 5

    invoke-static {p1}, Landroidx/databinding/adapters/ViewBindingAdapter;->pixelsToDimensionPixelSize(F)I

    move-result p1

    invoke-virtual {p0}, Landroid/view/View;->getPaddingLeft()I

    move-result v0

    invoke-virtual {p0}, Landroid/view/View;->getPaddingRight()I

    move-result v1

    invoke-virtual {p0}, Landroid/view/View;->getPaddingBottom()I

    move-result v2

    invoke-virtual {p0, v0, p1, v1, v2}, Landroid/view/View;->setPadding(IIII)V

    return-void
.end method

.method public static setRequiresFadingEdge(Landroid/view/View;I)V
    .registers 5

    and-int/lit8 v0, p1, 0x2

    const/4 v1, 0x0

    const/4 v2, 0x1

    if-eqz v0, :cond_8

    move v0, v2

    goto :goto_9

    :cond_8
    move v0, v1

    :goto_9
    and-int/2addr p1, v2

    if-eqz p1, :cond_d

    move v1, v2

    :cond_d
    invoke-virtual {p0, v0}, Landroid/view/View;->setVerticalFadingEdgeEnabled(Z)V

    invoke-virtual {p0, v1}, Landroid/view/View;->setHorizontalFadingEdgeEnabled(Z)V

    return-void
.end method
