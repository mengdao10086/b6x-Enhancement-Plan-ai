.class public Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;
.super Landroidx/appcompat/widget/AppCompatAutoCompleteTextView;
.source "MaterialAutoCompleteTextView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/material/textfield/MaterialAutoCompleteTextView$MaterialArrayAdapter;
    }
.end annotation


# static fields
.field private static final MAX_ITEMS_MEASURED:I = 0xf


# instance fields
.field private final accessibilityManager:Landroid/view/accessibility/AccessibilityManager;

.field private final modalListPopup:Landroidx/appcompat/widget/ListPopupWindow;

.field private final popupElevation:F

.field private final simpleItemLayout:I

.field private simpleItemSelectedColor:I

.field private simpleItemSelectedRippleColor:Landroid/content/res/ColorStateList;

.field private final tempRect:Landroid/graphics/Rect;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 3

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 4

    sget v0, Lcom/google/android/material/R$attr;->autoCompleteTextViewStyle:I

    invoke-direct {p0, p1, p2, v0}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .registers 11

    const/4 v0, 0x0

    invoke-static {p1, p2, p3, v0}, Lcom/google/android/material/theme/overlay/MaterialThemeOverlay;->wrap(Landroid/content/Context;Landroid/util/AttributeSet;II)Landroid/content/Context;

    move-result-object p1

    invoke-direct {p0, p1, p2, p3}, Landroidx/appcompat/widget/AppCompatAutoCompleteTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    new-instance p1, Landroid/graphics/Rect;

    invoke-direct {p1}, Landroid/graphics/Rect;-><init>()V

    iput-object p1, p0, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->tempRect:Landroid/graphics/Rect;

    invoke-virtual {p0}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->getContext()Landroid/content/Context;

    move-result-object p1

    sget-object v3, Lcom/google/android/material/R$styleable;->MaterialAutoCompleteTextView:[I

    sget v5, Lcom/google/android/material/R$style;->Widget_AppCompat_AutoCompleteTextView:I

    new-array v6, v0, [I

    move-object v1, p1

    move-object v2, p2

    move v4, p3

    invoke-static/range {v1 .. v6}, Lcom/google/android/material/internal/ThemeEnforcement;->obtainStyledAttributes(Landroid/content/Context;Landroid/util/AttributeSet;[III[I)Landroid/content/res/TypedArray;

    move-result-object p2

    sget p3, Lcom/google/android/material/R$styleable;->MaterialAutoCompleteTextView_android_inputType:I

    invoke-virtual {p2, p3}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result p3

    if-eqz p3, :cond_34

    sget p3, Lcom/google/android/material/R$styleable;->MaterialAutoCompleteTextView_android_inputType:I

    invoke-virtual {p2, p3, v0}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result p3

    if-nez p3, :cond_34

    const/4 p3, 0x0

    invoke-virtual {p0, p3}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->setKeyListener(Landroid/text/method/KeyListener;)V

    :cond_34
    sget p3, Lcom/google/android/material/R$styleable;->MaterialAutoCompleteTextView_simpleItemLayout:I

    sget v1, Lcom/google/android/material/R$layout;->mtrl_auto_complete_simple_item:I

    invoke-virtual {p2, p3, v1}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result p3

    iput p3, p0, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->simpleItemLayout:I

    sget p3, Lcom/google/android/material/R$styleable;->MaterialAutoCompleteTextView_android_popupElevation:I

    sget v1, Lcom/google/android/material/R$dimen;->mtrl_exposed_dropdown_menu_popup_elevation:I

    invoke-virtual {p2, p3, v1}, Landroid/content/res/TypedArray;->getDimensionPixelOffset(II)I

    move-result p3

    int-to-float p3, p3

    iput p3, p0, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->popupElevation:F

    sget p3, Lcom/google/android/material/R$styleable;->MaterialAutoCompleteTextView_simpleItemSelectedColor:I

    invoke-virtual {p2, p3, v0}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result p3

    iput p3, p0, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->simpleItemSelectedColor:I

    sget p3, Lcom/google/android/material/R$styleable;->MaterialAutoCompleteTextView_simpleItemSelectedRippleColor:I

    invoke-static {p1, p2, p3}, Lcom/google/android/material/resources/MaterialResources;->getColorStateList(Landroid/content/Context;Landroid/content/res/TypedArray;I)Landroid/content/res/ColorStateList;

    move-result-object p3

    iput-object p3, p0, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->simpleItemSelectedRippleColor:Landroid/content/res/ColorStateList;

    const-string p3, "accessibility"

    invoke-virtual {p1, p3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p3

    check-cast p3, Landroid/view/accessibility/AccessibilityManager;

    iput-object p3, p0, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->accessibilityManager:Landroid/view/accessibility/AccessibilityManager;

    new-instance p3, Landroidx/appcompat/widget/ListPopupWindow;

    invoke-direct {p3, p1}, Landroidx/appcompat/widget/ListPopupWindow;-><init>(Landroid/content/Context;)V

    iput-object p3, p0, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->modalListPopup:Landroidx/appcompat/widget/ListPopupWindow;

    const/4 p1, 0x1

    invoke-virtual {p3, p1}, Landroidx/appcompat/widget/ListPopupWindow;->setModal(Z)V

    invoke-virtual {p3, p0}, Landroidx/appcompat/widget/ListPopupWindow;->setAnchorView(Landroid/view/View;)V

    const/4 p1, 0x2

    invoke-virtual {p3, p1}, Landroidx/appcompat/widget/ListPopupWindow;->setInputMethodMode(I)V

    invoke-virtual {p0}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object p1

    invoke-virtual {p3, p1}, Landroidx/appcompat/widget/ListPopupWindow;->setAdapter(Landroid/widget/ListAdapter;)V

    new-instance p1, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView$1;

    invoke-direct {p1, p0}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView$1;-><init>(Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;)V

    invoke-virtual {p3, p1}, Landroidx/appcompat/widget/ListPopupWindow;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    sget p1, Lcom/google/android/material/R$styleable;->MaterialAutoCompleteTextView_simpleItems:I

    invoke-virtual {p2, p1}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result p1

    if-eqz p1, :cond_95

    sget p1, Lcom/google/android/material/R$styleable;->MaterialAutoCompleteTextView_simpleItems:I

    invoke-virtual {p2, p1, v0}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result p1

    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->setSimpleItems(I)V

    :cond_95
    invoke-virtual {p2}, Landroid/content/res/TypedArray;->recycle()V

    return-void
.end method

.method static synthetic access$000(Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;)Landroidx/appcompat/widget/ListPopupWindow;
    .registers 1

    iget-object p0, p0, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->modalListPopup:Landroidx/appcompat/widget/ListPopupWindow;

    return-object p0
.end method

.method static synthetic access$100(Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;Ljava/lang/Object;)V
    .registers 2

    invoke-direct {p0, p1}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->updateText(Ljava/lang/Object;)V

    return-void
.end method

.method static synthetic access$200(Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;)I
    .registers 1

    iget p0, p0, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->simpleItemSelectedColor:I

    return p0
.end method

.method static synthetic access$300(Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;)Landroid/content/res/ColorStateList;
    .registers 1

    iget-object p0, p0, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->simpleItemSelectedRippleColor:Landroid/content/res/ColorStateList;

    return-object p0
.end method

.method private findTextInputLayoutAncestor()Lcom/google/android/material/textfield/TextInputLayout;
    .registers 3

    invoke-virtual {p0}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    :goto_4
    if-eqz v0, :cond_12

    instance-of v1, v0, Lcom/google/android/material/textfield/TextInputLayout;

    if-eqz v1, :cond_d

    check-cast v0, Lcom/google/android/material/textfield/TextInputLayout;

    return-object v0

    :cond_d
    invoke-interface {v0}, Landroid/view/ViewParent;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    goto :goto_4

    :cond_12
    const/4 v0, 0x0

    return-object v0
.end method

.method private isTouchExplorationEnabled()Z
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->accessibilityManager:Landroid/view/accessibility/AccessibilityManager;

    if-eqz v0, :cond_c

    invoke-virtual {v0}, Landroid/view/accessibility/AccessibilityManager;->isTouchExplorationEnabled()Z

    move-result v0

    if-eqz v0, :cond_c

    const/4 v0, 0x1

    goto :goto_d

    :cond_c
    const/4 v0, 0x0

    :goto_d
    return v0
.end method

.method private measureContentWidth()I
    .registers 13

    invoke-virtual {p0}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    invoke-direct {p0}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->findTextInputLayoutAncestor()Lcom/google/android/material/textfield/TextInputLayout;

    move-result-object v1

    const/4 v2, 0x0

    if-eqz v0, :cond_89

    if-nez v1, :cond_f

    goto/16 :goto_89

    :cond_f
    invoke-virtual {p0}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->getMeasuredWidth()I

    move-result v3

    invoke-static {v3, v2}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v3

    invoke-virtual {p0}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->getMeasuredHeight()I

    move-result v4

    invoke-static {v4, v2}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v4

    iget-object v5, p0, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->modalListPopup:Landroidx/appcompat/widget/ListPopupWindow;

    invoke-virtual {v5}, Landroidx/appcompat/widget/ListPopupWindow;->getSelectedItemPosition()I

    move-result v5

    invoke-static {v2, v5}, Ljava/lang/Math;->max(II)I

    move-result v5

    invoke-interface {v0}, Landroid/widget/ListAdapter;->getCount()I

    move-result v6

    add-int/lit8 v5, v5, 0xf

    invoke-static {v6, v5}, Ljava/lang/Math;->min(II)I

    move-result v5

    add-int/lit8 v6, v5, -0xf

    invoke-static {v2, v6}, Ljava/lang/Math;->max(II)I

    move-result v6

    const/4 v7, 0x0

    move v8, v6

    move-object v9, v7

    move v6, v2

    :goto_3d
    if-ge v8, v5, :cond_68

    invoke-interface {v0, v8}, Landroid/widget/ListAdapter;->getItemViewType(I)I

    move-result v10

    if-eq v10, v2, :cond_47

    move-object v9, v7

    move v2, v10

    :cond_47
    invoke-interface {v0, v8, v9, v1}, Landroid/widget/ListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v9

    invoke-virtual {v9}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v10

    if-nez v10, :cond_5a

    new-instance v10, Landroid/view/ViewGroup$LayoutParams;

    const/4 v11, -0x2

    invoke-direct {v10, v11, v11}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v9, v10}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    :cond_5a
    invoke-virtual {v9, v3, v4}, Landroid/view/View;->measure(II)V

    invoke-virtual {v9}, Landroid/view/View;->getMeasuredWidth()I

    move-result v10

    invoke-static {v6, v10}, Ljava/lang/Math;->max(II)I

    move-result v6

    add-int/lit8 v8, v8, 0x1

    goto :goto_3d

    :cond_68
    iget-object v0, p0, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->modalListPopup:Landroidx/appcompat/widget/ListPopupWindow;

    invoke-virtual {v0}, Landroidx/appcompat/widget/ListPopupWindow;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    if-eqz v0, :cond_7f

    iget-object v2, p0, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->tempRect:Landroid/graphics/Rect;

    invoke-virtual {v0, v2}, Landroid/graphics/drawable/Drawable;->getPadding(Landroid/graphics/Rect;)Z

    iget-object v0, p0, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->tempRect:Landroid/graphics/Rect;

    iget v0, v0, Landroid/graphics/Rect;->left:I

    iget-object v2, p0, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->tempRect:Landroid/graphics/Rect;

    iget v2, v2, Landroid/graphics/Rect;->right:I

    add-int/2addr v0, v2

    add-int/2addr v6, v0

    :cond_7f
    invoke-virtual {v1}, Lcom/google/android/material/textfield/TextInputLayout;->getEndIconView()Lcom/google/android/material/internal/CheckableImageButton;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/material/internal/CheckableImageButton;->getMeasuredWidth()I

    move-result v0

    add-int/2addr v6, v0

    return v6

    :cond_89
    :goto_89
    return v2
.end method

.method private onInputTypeChanged()V
    .registers 2

    invoke-direct {p0}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->findTextInputLayoutAncestor()Lcom/google/android/material/textfield/TextInputLayout;

    move-result-object v0

    if-eqz v0, :cond_9

    invoke-virtual {v0}, Lcom/google/android/material/textfield/TextInputLayout;->updateEditTextBoxBackgroundIfNeeded()V

    :cond_9
    return-void
.end method

.method private updateText(Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Landroid/widget/ListAdapter;",
            ":",
            "Landroid/widget/Filterable;",
            ">(",
            "Ljava/lang/Object;",
            ")V"
        }
    .end annotation

    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->convertSelectionToString(Ljava/lang/Object;)Ljava/lang/CharSequence;

    move-result-object p1

    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->setText(Ljava/lang/CharSequence;Z)V

    return-void
.end method


# virtual methods
.method public dismissDropDown()V
    .registers 2

    invoke-direct {p0}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->isTouchExplorationEnabled()Z

    move-result v0

    if-eqz v0, :cond_c

    iget-object v0, p0, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->modalListPopup:Landroidx/appcompat/widget/ListPopupWindow;

    invoke-virtual {v0}, Landroidx/appcompat/widget/ListPopupWindow;->dismiss()V

    goto :goto_f

    :cond_c
    invoke-super {p0}, Landroidx/appcompat/widget/AppCompatAutoCompleteTextView;->dismissDropDown()V

    :goto_f
    return-void
.end method

.method public getHint()Ljava/lang/CharSequence;
    .registers 3

    invoke-direct {p0}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->findTextInputLayoutAncestor()Lcom/google/android/material/textfield/TextInputLayout;

    move-result-object v0

    if-eqz v0, :cond_11

    invoke-virtual {v0}, Lcom/google/android/material/textfield/TextInputLayout;->isProvidingHint()Z

    move-result v1

    if-eqz v1, :cond_11

    invoke-virtual {v0}, Lcom/google/android/material/textfield/TextInputLayout;->getHint()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0

    :cond_11
    invoke-super {p0}, Landroidx/appcompat/widget/AppCompatAutoCompleteTextView;->getHint()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public getPopupElevation()F
    .registers 2

    iget v0, p0, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->popupElevation:F

    return v0
.end method

.method public getSimpleItemSelectedColor()I
    .registers 2

    iget v0, p0, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->simpleItemSelectedColor:I

    return v0
.end method

.method public getSimpleItemSelectedRippleColor()Landroid/content/res/ColorStateList;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->simpleItemSelectedRippleColor:Landroid/content/res/ColorStateList;

    return-object v0
.end method

.method protected onAttachedToWindow()V
    .registers 2

    invoke-super {p0}, Landroidx/appcompat/widget/AppCompatAutoCompleteTextView;->onAttachedToWindow()V

    invoke-direct {p0}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->findTextInputLayoutAncestor()Lcom/google/android/material/textfield/TextInputLayout;

    move-result-object v0

    if-eqz v0, :cond_20

    invoke-virtual {v0}, Lcom/google/android/material/textfield/TextInputLayout;->isProvidingHint()Z

    move-result v0

    if-eqz v0, :cond_20

    invoke-super {p0}, Landroidx/appcompat/widget/AppCompatAutoCompleteTextView;->getHint()Ljava/lang/CharSequence;

    move-result-object v0

    if-nez v0, :cond_20

    invoke-static {}, Lcom/google/android/material/internal/ManufacturerUtils;->isMeizuDevice()Z

    move-result v0

    if-eqz v0, :cond_20

    const-string v0, ""

    invoke-virtual {p0, v0}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->setHint(Ljava/lang/CharSequence;)V

    :cond_20
    return-void
.end method

.method protected onDetachedFromWindow()V
    .registers 2

    invoke-super {p0}, Landroidx/appcompat/widget/AppCompatAutoCompleteTextView;->onDetachedFromWindow()V

    iget-object v0, p0, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->modalListPopup:Landroidx/appcompat/widget/ListPopupWindow;

    invoke-virtual {v0}, Landroidx/appcompat/widget/ListPopupWindow;->dismiss()V

    return-void
.end method

.method protected onMeasure(II)V
    .registers 4

    invoke-super {p0, p1, p2}, Landroidx/appcompat/widget/AppCompatAutoCompleteTextView;->onMeasure(II)V

    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result p2

    const/high16 v0, -0x80000000

    if-ne p2, v0, :cond_26

    invoke-virtual {p0}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->getMeasuredWidth()I

    move-result p2

    invoke-direct {p0}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->measureContentWidth()I

    move-result v0

    invoke-static {p2, v0}, Ljava/lang/Math;->max(II)I

    move-result p2

    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result p1

    invoke-static {p2, p1}, Ljava/lang/Math;->min(II)I

    move-result p1

    invoke-virtual {p0}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->getMeasuredHeight()I

    move-result p2

    invoke-virtual {p0, p1, p2}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->setMeasuredDimension(II)V

    :cond_26
    return-void
.end method

.method public onWindowFocusChanged(Z)V
    .registers 3

    invoke-direct {p0}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->isTouchExplorationEnabled()Z

    move-result v0

    if-eqz v0, :cond_7

    return-void

    :cond_7
    invoke-super {p0, p1}, Landroidx/appcompat/widget/AppCompatAutoCompleteTextView;->onWindowFocusChanged(Z)V

    return-void
.end method

.method public setAdapter(Landroid/widget/ListAdapter;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Landroid/widget/ListAdapter;",
            ":",
            "Landroid/widget/Filterable;",
            ">(TT;)V"
        }
    .end annotation

    invoke-super {p0, p1}, Landroidx/appcompat/widget/AppCompatAutoCompleteTextView;->setAdapter(Landroid/widget/ListAdapter;)V

    iget-object p1, p0, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->modalListPopup:Landroidx/appcompat/widget/ListPopupWindow;

    invoke-virtual {p0}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroidx/appcompat/widget/ListPopupWindow;->setAdapter(Landroid/widget/ListAdapter;)V

    return-void
.end method

.method public setDropDownBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    .registers 3

    invoke-super {p0, p1}, Landroidx/appcompat/widget/AppCompatAutoCompleteTextView;->setDropDownBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    iget-object v0, p0, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->modalListPopup:Landroidx/appcompat/widget/ListPopupWindow;

    if-eqz v0, :cond_a

    invoke-virtual {v0, p1}, Landroidx/appcompat/widget/ListPopupWindow;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    :cond_a
    return-void
.end method

.method public setOnItemSelectedListener(Landroid/widget/AdapterView$OnItemSelectedListener;)V
    .registers 3

    invoke-super {p0, p1}, Landroidx/appcompat/widget/AppCompatAutoCompleteTextView;->setOnItemSelectedListener(Landroid/widget/AdapterView$OnItemSelectedListener;)V

    iget-object p1, p0, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->modalListPopup:Landroidx/appcompat/widget/ListPopupWindow;

    invoke-virtual {p0}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->getOnItemSelectedListener()Landroid/widget/AdapterView$OnItemSelectedListener;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroidx/appcompat/widget/ListPopupWindow;->setOnItemSelectedListener(Landroid/widget/AdapterView$OnItemSelectedListener;)V

    return-void
.end method

.method public setRawInputType(I)V
    .registers 2

    invoke-super {p0, p1}, Landroidx/appcompat/widget/AppCompatAutoCompleteTextView;->setRawInputType(I)V

    invoke-direct {p0}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->onInputTypeChanged()V

    return-void
.end method

.method public setSimpleItemSelectedColor(I)V
    .registers 2

    iput p1, p0, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->simpleItemSelectedColor:I

    invoke-virtual {p0}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object p1

    instance-of p1, p1, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView$MaterialArrayAdapter;

    if-eqz p1, :cond_13

    invoke-virtual {p0}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object p1

    check-cast p1, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView$MaterialArrayAdapter;

    invoke-virtual {p1}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView$MaterialArrayAdapter;->updateSelectedItemColorStateList()V

    :cond_13
    return-void
.end method

.method public setSimpleItemSelectedRippleColor(Landroid/content/res/ColorStateList;)V
    .registers 2

    iput-object p1, p0, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->simpleItemSelectedRippleColor:Landroid/content/res/ColorStateList;

    invoke-virtual {p0}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object p1

    instance-of p1, p1, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView$MaterialArrayAdapter;

    if-eqz p1, :cond_13

    invoke-virtual {p0}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object p1

    check-cast p1, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView$MaterialArrayAdapter;

    invoke-virtual {p1}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView$MaterialArrayAdapter;->updateSelectedItemColorStateList()V

    :cond_13
    return-void
.end method

.method public setSimpleItems(I)V
    .registers 3

    invoke-virtual {p0}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->setSimpleItems([Ljava/lang/String;)V

    return-void
.end method

.method public setSimpleItems([Ljava/lang/String;)V
    .registers 5

    new-instance v0, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView$MaterialArrayAdapter;

    invoke-virtual {p0}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->getContext()Landroid/content/Context;

    move-result-object v1

    iget v2, p0, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->simpleItemLayout:I

    invoke-direct {v0, p0, v1, v2, p1}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView$MaterialArrayAdapter;-><init>(Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;Landroid/content/Context;I[Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->setAdapter(Landroid/widget/ListAdapter;)V

    return-void
.end method

.method public showDropDown()V
    .registers 2

    invoke-direct {p0}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->isTouchExplorationEnabled()Z

    move-result v0

    if-eqz v0, :cond_c

    iget-object v0, p0, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->modalListPopup:Landroidx/appcompat/widget/ListPopupWindow;

    invoke-virtual {v0}, Landroidx/appcompat/widget/ListPopupWindow;->show()V

    goto :goto_f

    :cond_c
    invoke-super {p0}, Landroidx/appcompat/widget/AppCompatAutoCompleteTextView;->showDropDown()V

    :goto_f
    return-void
.end method
