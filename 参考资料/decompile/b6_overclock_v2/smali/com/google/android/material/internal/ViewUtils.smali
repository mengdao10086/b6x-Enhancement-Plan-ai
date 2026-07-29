.class public Lcom/google/android/material/internal/ViewUtils;
.super Ljava/lang/Object;
.source "ViewUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/material/internal/ViewUtils$RelativePadding;,
        Lcom/google/android/material/internal/ViewUtils$OnApplyWindowInsetsListener;
    }
.end annotation


# static fields
.field public static final EDGE_TO_EDGE_FLAGS:I = 0x300


# direct methods
.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static addOnGlobalLayoutListener(Landroid/view/View;Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    .registers 2

    if-eqz p0, :cond_9

    invoke-virtual {p0}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object p0

    invoke-virtual {p0, p1}, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    :cond_9
    return-void
.end method

.method public static calculateRectFromBounds(Landroid/view/View;)Landroid/graphics/Rect;
    .registers 2

    const/4 v0, 0x0

    invoke-static {p0, v0}, Lcom/google/android/material/internal/ViewUtils;->calculateRectFromBounds(Landroid/view/View;I)Landroid/graphics/Rect;

    move-result-object p0

    return-object p0
.end method

.method public static calculateRectFromBounds(Landroid/view/View;I)Landroid/graphics/Rect;
    .registers 6

    new-instance v0, Landroid/graphics/Rect;

    invoke-virtual {p0}, Landroid/view/View;->getLeft()I

    move-result v1

    invoke-virtual {p0}, Landroid/view/View;->getTop()I

    move-result v2

    add-int/2addr v2, p1

    invoke-virtual {p0}, Landroid/view/View;->getRight()I

    move-result v3

    invoke-virtual {p0}, Landroid/view/View;->getBottom()I

    move-result p0

    add-int/2addr p0, p1

    invoke-direct {v0, v1, v2, v3, p0}, Landroid/graphics/Rect;-><init>(IIII)V

    return-object v0
.end method

.method public static doOnApplyWindowInsets(Landroid/view/View;Landroid/util/AttributeSet;II)V
    .registers 5

    const/4 v0, 0x0

    invoke-static {p0, p1, p2, p3, v0}, Lcom/google/android/material/internal/ViewUtils;->doOnApplyWindowInsets(Landroid/view/View;Landroid/util/AttributeSet;IILcom/google/android/material/internal/ViewUtils$OnApplyWindowInsetsListener;)V

    return-void
.end method

.method public static doOnApplyWindowInsets(Landroid/view/View;Landroid/util/AttributeSet;IILcom/google/android/material/internal/ViewUtils$OnApplyWindowInsetsListener;)V
    .registers 7

    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    sget-object v1, Lcom/google/android/material/R$styleable;->Insets:[I

    invoke-virtual {v0, p1, v1, p2, p3}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object p1

    sget p2, Lcom/google/android/material/R$styleable;->Insets_paddingBottomSystemWindowInsets:I

    const/4 p3, 0x0

    invoke-virtual {p1, p2, p3}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result p2

    sget v0, Lcom/google/android/material/R$styleable;->Insets_paddingLeftSystemWindowInsets:I

    invoke-virtual {p1, v0, p3}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v0

    sget v1, Lcom/google/android/material/R$styleable;->Insets_paddingRightSystemWindowInsets:I

    invoke-virtual {p1, v1, p3}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result p3

    invoke-virtual {p1}, Landroid/content/res/TypedArray;->recycle()V

    new-instance p1, Lcom/google/android/material/internal/ViewUtils$2;

    invoke-direct {p1, p2, v0, p3, p4}, Lcom/google/android/material/internal/ViewUtils$2;-><init>(ZZZLcom/google/android/material/internal/ViewUtils$OnApplyWindowInsetsListener;)V

    invoke-static {p0, p1}, Lcom/google/android/material/internal/ViewUtils;->doOnApplyWindowInsets(Landroid/view/View;Lcom/google/android/material/internal/ViewUtils$OnApplyWindowInsetsListener;)V

    return-void
.end method

.method public static doOnApplyWindowInsets(Landroid/view/View;Lcom/google/android/material/internal/ViewUtils$OnApplyWindowInsetsListener;)V
    .registers 7

    new-instance v0, Lcom/google/android/material/internal/ViewUtils$RelativePadding;

    invoke-static {p0}, Landroidx/core/view/ViewCompat;->getPaddingStart(Landroid/view/View;)I

    move-result v1

    invoke-virtual {p0}, Landroid/view/View;->getPaddingTop()I

    move-result v2

    invoke-static {p0}, Landroidx/core/view/ViewCompat;->getPaddingEnd(Landroid/view/View;)I

    move-result v3

    invoke-virtual {p0}, Landroid/view/View;->getPaddingBottom()I

    move-result v4

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/google/android/material/internal/ViewUtils$RelativePadding;-><init>(IIII)V

    new-instance v1, Lcom/google/android/material/internal/ViewUtils$3;

    invoke-direct {v1, p1, v0}, Lcom/google/android/material/internal/ViewUtils$3;-><init>(Lcom/google/android/material/internal/ViewUtils$OnApplyWindowInsetsListener;Lcom/google/android/material/internal/ViewUtils$RelativePadding;)V

    invoke-static {p0, v1}, Landroidx/core/view/ViewCompat;->setOnApplyWindowInsetsListener(Landroid/view/View;Landroidx/core/view/OnApplyWindowInsetsListener;)V

    invoke-static {p0}, Lcom/google/android/material/internal/ViewUtils;->requestApplyInsetsWhenAttached(Landroid/view/View;)V

    return-void
.end method

.method public static dpToPx(Landroid/content/Context;I)F
    .registers 3

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object p0

    int-to-float p1, p1

    invoke-virtual {p0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object p0

    const/4 v0, 0x1

    invoke-static {v0, p1, p0}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result p0

    return p0
.end method

.method public static getBackgroundColor(Landroid/view/View;)Ljava/lang/Integer;
    .registers 2

    invoke-virtual {p0}, Landroid/view/View;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    instance-of v0, v0, Landroid/graphics/drawable/ColorDrawable;

    if-eqz v0, :cond_17

    invoke-virtual {p0}, Landroid/view/View;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object p0

    check-cast p0, Landroid/graphics/drawable/ColorDrawable;

    invoke-virtual {p0}, Landroid/graphics/drawable/ColorDrawable;->getColor()I

    move-result p0

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p0

    goto :goto_18

    :cond_17
    const/4 p0, 0x0

    :goto_18
    return-object p0
.end method

.method public static getChildren(Landroid/view/View;)Ljava/util/List;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/View;",
            ")",
            "Ljava/util/List<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    instance-of v1, p0, Landroid/view/ViewGroup;

    if-eqz v1, :cond_1c

    check-cast p0, Landroid/view/ViewGroup;

    const/4 v1, 0x0

    :goto_c
    invoke-virtual {p0}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v2

    if-ge v1, v2, :cond_1c

    invoke-virtual {p0, v1}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v1, v1, 0x1

    goto :goto_c

    :cond_1c
    return-object v0
.end method

.method public static getContentView(Landroid/view/View;)Landroid/view/ViewGroup;
    .registers 4

    const/4 v0, 0x0

    if-nez p0, :cond_4

    return-object v0

    :cond_4
    invoke-virtual {p0}, Landroid/view/View;->getRootView()Landroid/view/View;

    move-result-object v1

    const v2, 0x1020002

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/view/ViewGroup;

    if-eqz v2, :cond_14

    return-object v2

    :cond_14
    if-eq v1, p0, :cond_1d

    instance-of p0, v1, Landroid/view/ViewGroup;

    if-eqz p0, :cond_1d

    check-cast v1, Landroid/view/ViewGroup;

    return-object v1

    :cond_1d
    return-object v0
.end method

.method public static getContentViewOverlay(Landroid/view/View;)Lcom/google/android/material/internal/ViewOverlayImpl;
    .registers 1

    invoke-static {p0}, Lcom/google/android/material/internal/ViewUtils;->getContentView(Landroid/view/View;)Landroid/view/ViewGroup;

    move-result-object p0

    invoke-static {p0}, Lcom/google/android/material/internal/ViewUtils;->getOverlay(Landroid/view/View;)Lcom/google/android/material/internal/ViewOverlayImpl;

    move-result-object p0

    return-object p0
.end method

.method private static getInputMethodManager(Landroid/view/View;)Landroid/view/inputmethod/InputMethodManager;
    .registers 2

    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object p0

    const-class v0, Landroid/view/inputmethod/InputMethodManager;

    invoke-static {p0, v0}, Landroidx/core/content/ContextCompat;->getSystemService(Landroid/content/Context;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Landroid/view/inputmethod/InputMethodManager;

    return-object p0
.end method

.method public static getOverlay(Landroid/view/View;)Lcom/google/android/material/internal/ViewOverlayImpl;
    .registers 2

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    new-instance v0, Lcom/google/android/material/internal/ViewOverlayApi18;

    invoke-direct {v0, p0}, Lcom/google/android/material/internal/ViewOverlayApi18;-><init>(Landroid/view/View;)V

    return-object v0
.end method

.method public static getParentAbsoluteElevation(Landroid/view/View;)F
    .registers 3

    invoke-virtual {p0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object p0

    const/4 v0, 0x0

    :goto_5
    instance-of v1, p0, Landroid/view/View;

    if-eqz v1, :cond_16

    move-object v1, p0

    check-cast v1, Landroid/view/View;

    invoke-static {v1}, Landroidx/core/view/ViewCompat;->getElevation(Landroid/view/View;)F

    move-result v1

    add-float/2addr v0, v1

    invoke-interface {p0}, Landroid/view/ViewParent;->getParent()Landroid/view/ViewParent;

    move-result-object p0

    goto :goto_5

    :cond_16
    return v0
.end method

.method public static hideKeyboard(Landroid/view/View;)V
    .registers 2

    const/4 v0, 0x1

    invoke-static {p0, v0}, Lcom/google/android/material/internal/ViewUtils;->hideKeyboard(Landroid/view/View;Z)V

    return-void
.end method

.method public static hideKeyboard(Landroid/view/View;Z)V
    .registers 3

    if-eqz p1, :cond_10

    invoke-static {p0}, Landroidx/core/view/ViewCompat;->getWindowInsetsController(Landroid/view/View;)Landroidx/core/view/WindowInsetsControllerCompat;

    move-result-object p1

    if-eqz p1, :cond_10

    invoke-static {}, Landroidx/core/view/WindowInsetsCompat$Type;->ime()I

    move-result p0

    invoke-virtual {p1, p0}, Landroidx/core/view/WindowInsetsControllerCompat;->hide(I)V

    return-void

    :cond_10
    invoke-static {p0}, Lcom/google/android/material/internal/ViewUtils;->getInputMethodManager(Landroid/view/View;)Landroid/view/inputmethod/InputMethodManager;

    move-result-object p1

    if-eqz p1, :cond_1e

    invoke-virtual {p0}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object p0

    const/4 v0, 0x0

    invoke-virtual {p1, p0, v0}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    :cond_1e
    return-void
.end method

.method public static isLayoutRtl(Landroid/view/View;)Z
    .registers 2

    invoke-static {p0}, Landroidx/core/view/ViewCompat;->getLayoutDirection(Landroid/view/View;)I

    move-result p0

    const/4 v0, 0x1

    if-ne p0, v0, :cond_8

    goto :goto_9

    :cond_8
    const/4 v0, 0x0

    :goto_9
    return v0
.end method

.method public static parseTintMode(ILandroid/graphics/PorterDuff$Mode;)Landroid/graphics/PorterDuff$Mode;
    .registers 3

    const/4 v0, 0x3

    if-eq p0, v0, :cond_1d

    const/4 v0, 0x5

    if-eq p0, v0, :cond_1a

    const/16 v0, 0x9

    if-eq p0, v0, :cond_17

    packed-switch p0, :pswitch_data_20

    return-object p1

    :pswitch_e
    sget-object p0, Landroid/graphics/PorterDuff$Mode;->ADD:Landroid/graphics/PorterDuff$Mode;

    return-object p0

    :pswitch_11
    sget-object p0, Landroid/graphics/PorterDuff$Mode;->SCREEN:Landroid/graphics/PorterDuff$Mode;

    return-object p0

    :pswitch_14
    sget-object p0, Landroid/graphics/PorterDuff$Mode;->MULTIPLY:Landroid/graphics/PorterDuff$Mode;

    return-object p0

    :cond_17
    sget-object p0, Landroid/graphics/PorterDuff$Mode;->SRC_ATOP:Landroid/graphics/PorterDuff$Mode;

    return-object p0

    :cond_1a
    sget-object p0, Landroid/graphics/PorterDuff$Mode;->SRC_IN:Landroid/graphics/PorterDuff$Mode;

    return-object p0

    :cond_1d
    sget-object p0, Landroid/graphics/PorterDuff$Mode;->SRC_OVER:Landroid/graphics/PorterDuff$Mode;

    return-object p0

    :pswitch_data_20
    .packed-switch 0xe
        :pswitch_14
        :pswitch_11
        :pswitch_e
    .end packed-switch
.end method

.method public static removeOnGlobalLayoutListener(Landroid/view/View;Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    .registers 2

    if-eqz p0, :cond_9

    invoke-virtual {p0}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object p0

    invoke-static {p0, p1}, Lcom/google/android/material/internal/ViewUtils;->removeOnGlobalLayoutListener(Landroid/view/ViewTreeObserver;Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    :cond_9
    return-void
.end method

.method public static removeOnGlobalLayoutListener(Landroid/view/ViewTreeObserver;Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    .registers 2

    invoke-virtual {p0, p1}, Landroid/view/ViewTreeObserver;->removeOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    return-void
.end method

.method public static requestApplyInsetsWhenAttached(Landroid/view/View;)V
    .registers 2

    invoke-static {p0}, Landroidx/core/view/ViewCompat;->isAttachedToWindow(Landroid/view/View;)Z

    move-result v0

    if-eqz v0, :cond_a

    invoke-static {p0}, Landroidx/core/view/ViewCompat;->requestApplyInsets(Landroid/view/View;)V

    goto :goto_12

    :cond_a
    new-instance v0, Lcom/google/android/material/internal/ViewUtils$4;

    invoke-direct {v0}, Lcom/google/android/material/internal/ViewUtils$4;-><init>()V

    invoke-virtual {p0, v0}, Landroid/view/View;->addOnAttachStateChangeListener(Landroid/view/View$OnAttachStateChangeListener;)V

    :goto_12
    return-void
.end method

.method public static requestFocusAndShowKeyboard(Landroid/view/View;)V
    .registers 2

    invoke-virtual {p0}, Landroid/view/View;->requestFocus()Z

    new-instance v0, Lcom/google/android/material/internal/ViewUtils$1;

    invoke-direct {v0, p0}, Lcom/google/android/material/internal/ViewUtils$1;-><init>(Landroid/view/View;)V

    invoke-virtual {p0, v0}, Landroid/view/View;->post(Ljava/lang/Runnable;)Z

    return-void
.end method

.method public static setBoundsFromRect(Landroid/view/View;Landroid/graphics/Rect;)V
    .registers 3

    iget v0, p1, Landroid/graphics/Rect;->left:I

    invoke-virtual {p0, v0}, Landroid/view/View;->setLeft(I)V

    iget v0, p1, Landroid/graphics/Rect;->top:I

    invoke-virtual {p0, v0}, Landroid/view/View;->setTop(I)V

    iget v0, p1, Landroid/graphics/Rect;->right:I

    invoke-virtual {p0, v0}, Landroid/view/View;->setRight(I)V

    iget p1, p1, Landroid/graphics/Rect;->bottom:I

    invoke-virtual {p0, p1}, Landroid/view/View;->setBottom(I)V

    return-void
.end method

.method public static showKeyboard(Landroid/view/View;)V
    .registers 2

    const/4 v0, 0x1

    invoke-static {p0, v0}, Lcom/google/android/material/internal/ViewUtils;->showKeyboard(Landroid/view/View;Z)V

    return-void
.end method

.method public static showKeyboard(Landroid/view/View;Z)V
    .registers 3

    if-eqz p1, :cond_10

    invoke-static {p0}, Landroidx/core/view/ViewCompat;->getWindowInsetsController(Landroid/view/View;)Landroidx/core/view/WindowInsetsControllerCompat;

    move-result-object p1

    if-eqz p1, :cond_10

    invoke-static {}, Landroidx/core/view/WindowInsetsCompat$Type;->ime()I

    move-result p0

    invoke-virtual {p1, p0}, Landroidx/core/view/WindowInsetsControllerCompat;->show(I)V

    return-void

    :cond_10
    invoke-static {p0}, Lcom/google/android/material/internal/ViewUtils;->getInputMethodManager(Landroid/view/View;)Landroid/view/inputmethod/InputMethodManager;

    move-result-object p1

    const/4 v0, 0x1

    invoke-virtual {p1, p0, v0}, Landroid/view/inputmethod/InputMethodManager;->showSoftInput(Landroid/view/View;I)Z

    return-void
.end method
