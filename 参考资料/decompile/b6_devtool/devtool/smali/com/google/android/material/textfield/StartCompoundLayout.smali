.class Lcom/google/android/material/textfield/StartCompoundLayout;
.super Landroid/widget/LinearLayout;
.source "StartCompoundLayout.java"


# instance fields
.field private hintExpanded:Z

.field private prefixText:Ljava/lang/CharSequence;

.field private final prefixTextView:Landroid/widget/TextView;

.field private startIconMinSize:I

.field private startIconOnLongClickListener:Landroid/view/View$OnLongClickListener;

.field private startIconScaleType:Landroid/widget/ImageView$ScaleType;

.field private startIconTintList:Landroid/content/res/ColorStateList;

.field private startIconTintMode:Landroid/graphics/PorterDuff$Mode;

.field private final startIconView:Lcom/google/android/material/internal/CheckableImageButton;

.field private final textInputLayout:Lcom/google/android/material/textfield/TextInputLayout;


# direct methods
.method constructor <init>(Lcom/google/android/material/textfield/TextInputLayout;Landroidx/appcompat/widget/TintTypedArray;)V
    .registers 7

    invoke-virtual {p1}, Lcom/google/android/material/textfield/TextInputLayout;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    iput-object p1, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->textInputLayout:Lcom/google/android/material/textfield/TextInputLayout;

    const/16 p1, 0x8

    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/StartCompoundLayout;->setVisibility(I)V

    const/4 p1, 0x0

    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/StartCompoundLayout;->setOrientation(I)V

    new-instance v0, Landroid/widget/FrameLayout$LayoutParams;

    const/4 v1, -0x1

    const v2, 0x800003

    const/4 v3, -0x2

    invoke-direct {v0, v3, v1, v2}, Landroid/widget/FrameLayout$LayoutParams;-><init>(III)V

    invoke-virtual {p0, v0}, Lcom/google/android/material/textfield/StartCompoundLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    invoke-virtual {p0}, Lcom/google/android/material/textfield/StartCompoundLayout;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    sget v1, Lcom/google/android/material/R$layout;->design_text_input_start_icon:I

    invoke-virtual {v0, v1, p0, p1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p1

    check-cast p1, Lcom/google/android/material/internal/CheckableImageButton;

    iput-object p1, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconView:Lcom/google/android/material/internal/CheckableImageButton;

    invoke-static {p1}, Lcom/google/android/material/textfield/IconHelper;->setCompatRippleBackgroundIfNeeded(Lcom/google/android/material/internal/CheckableImageButton;)V

    new-instance v0, Landroidx/appcompat/widget/AppCompatTextView;

    invoke-virtual {p0}, Lcom/google/android/material/textfield/StartCompoundLayout;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Landroidx/appcompat/widget/AppCompatTextView;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->prefixTextView:Landroid/widget/TextView;

    invoke-direct {p0, p2}, Lcom/google/android/material/textfield/StartCompoundLayout;->initStartIconView(Landroidx/appcompat/widget/TintTypedArray;)V

    invoke-direct {p0, p2}, Lcom/google/android/material/textfield/StartCompoundLayout;->initPrefixTextView(Landroidx/appcompat/widget/TintTypedArray;)V

    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/StartCompoundLayout;->addView(Landroid/view/View;)V

    invoke-virtual {p0, v0}, Lcom/google/android/material/textfield/StartCompoundLayout;->addView(Landroid/view/View;)V

    return-void
.end method

.method private initPrefixTextView(Landroidx/appcompat/widget/TintTypedArray;)V
    .registers 5

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->prefixTextView:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->prefixTextView:Landroid/widget/TextView;

    sget v1, Lcom/google/android/material/R$id;->textinput_prefix_text:I

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setId(I)V

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->prefixTextView:Landroid/widget/TextView;

    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v2, -0x2

    invoke-direct {v1, v2, v2}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->prefixTextView:Landroid/widget/TextView;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Landroidx/core/view/ViewCompat;->setAccessibilityLiveRegion(Landroid/view/View;I)V

    sget v0, Lcom/google/android/material/R$styleable;->TextInputLayout_prefixTextAppearance:I

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroidx/appcompat/widget/TintTypedArray;->getResourceId(II)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/google/android/material/textfield/StartCompoundLayout;->setPrefixTextAppearance(I)V

    sget v0, Lcom/google/android/material/R$styleable;->TextInputLayout_prefixTextColor:I

    invoke-virtual {p1, v0}, Landroidx/appcompat/widget/TintTypedArray;->hasValue(I)Z

    move-result v0

    if-eqz v0, :cond_3a

    sget v0, Lcom/google/android/material/R$styleable;->TextInputLayout_prefixTextColor:I

    invoke-virtual {p1, v0}, Landroidx/appcompat/widget/TintTypedArray;->getColorStateList(I)Landroid/content/res/ColorStateList;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/google/android/material/textfield/StartCompoundLayout;->setPrefixTextColor(Landroid/content/res/ColorStateList;)V

    :cond_3a
    sget v0, Lcom/google/android/material/R$styleable;->TextInputLayout_prefixText:I

    invoke-virtual {p1, v0}, Landroidx/appcompat/widget/TintTypedArray;->getText(I)Ljava/lang/CharSequence;

    move-result-object p1

    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/StartCompoundLayout;->setPrefixText(Ljava/lang/CharSequence;)V

    return-void
.end method

.method private initStartIconView(Landroidx/appcompat/widget/TintTypedArray;)V
    .registers 6

    invoke-virtual {p0}, Lcom/google/android/material/textfield/StartCompoundLayout;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/material/resources/MaterialResources;->isFontScaleAtLeast1_3(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_16

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconView:Lcom/google/android/material/internal/CheckableImageButton;

    invoke-virtual {v0}, Lcom/google/android/material/internal/CheckableImageButton;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup$MarginLayoutParams;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Landroidx/core/view/MarginLayoutParamsCompat;->setMarginEnd(Landroid/view/ViewGroup$MarginLayoutParams;I)V

    :cond_16
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/google/android/material/textfield/StartCompoundLayout;->setStartIconOnClickListener(Landroid/view/View$OnClickListener;)V

    invoke-virtual {p0, v0}, Lcom/google/android/material/textfield/StartCompoundLayout;->setStartIconOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    sget v1, Lcom/google/android/material/R$styleable;->TextInputLayout_startIconTint:I

    invoke-virtual {p1, v1}, Landroidx/appcompat/widget/TintTypedArray;->hasValue(I)Z

    move-result v1

    if-eqz v1, :cond_31

    invoke-virtual {p0}, Lcom/google/android/material/textfield/StartCompoundLayout;->getContext()Landroid/content/Context;

    move-result-object v1

    sget v2, Lcom/google/android/material/R$styleable;->TextInputLayout_startIconTint:I

    invoke-static {v1, p1, v2}, Lcom/google/android/material/resources/MaterialResources;->getColorStateList(Landroid/content/Context;Landroidx/appcompat/widget/TintTypedArray;I)Landroid/content/res/ColorStateList;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconTintList:Landroid/content/res/ColorStateList;

    :cond_31
    sget v1, Lcom/google/android/material/R$styleable;->TextInputLayout_startIconTintMode:I

    invoke-virtual {p1, v1}, Landroidx/appcompat/widget/TintTypedArray;->hasValue(I)Z

    move-result v1

    const/4 v2, -0x1

    if-eqz v1, :cond_46

    sget v1, Lcom/google/android/material/R$styleable;->TextInputLayout_startIconTintMode:I

    invoke-virtual {p1, v1, v2}, Landroidx/appcompat/widget/TintTypedArray;->getInt(II)I

    move-result v1

    invoke-static {v1, v0}, Lcom/google/android/material/internal/ViewUtils;->parseTintMode(ILandroid/graphics/PorterDuff$Mode;)Landroid/graphics/PorterDuff$Mode;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconTintMode:Landroid/graphics/PorterDuff$Mode;

    :cond_46
    sget v0, Lcom/google/android/material/R$styleable;->TextInputLayout_startIconDrawable:I

    invoke-virtual {p1, v0}, Landroidx/appcompat/widget/TintTypedArray;->hasValue(I)Z

    move-result v0

    if-eqz v0, :cond_72

    sget v0, Lcom/google/android/material/R$styleable;->TextInputLayout_startIconDrawable:I

    invoke-virtual {p1, v0}, Landroidx/appcompat/widget/TintTypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/google/android/material/textfield/StartCompoundLayout;->setStartIconDrawable(Landroid/graphics/drawable/Drawable;)V

    sget v0, Lcom/google/android/material/R$styleable;->TextInputLayout_startIconContentDescription:I

    invoke-virtual {p1, v0}, Landroidx/appcompat/widget/TintTypedArray;->hasValue(I)Z

    move-result v0

    if-eqz v0, :cond_68

    sget v0, Lcom/google/android/material/R$styleable;->TextInputLayout_startIconContentDescription:I

    invoke-virtual {p1, v0}, Landroidx/appcompat/widget/TintTypedArray;->getText(I)Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/google/android/material/textfield/StartCompoundLayout;->setStartIconContentDescription(Ljava/lang/CharSequence;)V

    :cond_68
    sget v0, Lcom/google/android/material/R$styleable;->TextInputLayout_startIconCheckable:I

    const/4 v1, 0x1

    invoke-virtual {p1, v0, v1}, Landroidx/appcompat/widget/TintTypedArray;->getBoolean(IZ)Z

    move-result v0

    invoke-virtual {p0, v0}, Lcom/google/android/material/textfield/StartCompoundLayout;->setStartIconCheckable(Z)V

    :cond_72
    sget v0, Lcom/google/android/material/R$styleable;->TextInputLayout_startIconMinSize:I

    invoke-virtual {p0}, Lcom/google/android/material/textfield/StartCompoundLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v3, Lcom/google/android/material/R$dimen;->mtrl_min_touch_target_size:I

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    invoke-virtual {p1, v0, v1}, Landroidx/appcompat/widget/TintTypedArray;->getDimensionPixelSize(II)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/google/android/material/textfield/StartCompoundLayout;->setStartIconMinSize(I)V

    sget v0, Lcom/google/android/material/R$styleable;->TextInputLayout_startIconScaleType:I

    invoke-virtual {p1, v0}, Landroidx/appcompat/widget/TintTypedArray;->hasValue(I)Z

    move-result v0

    if-eqz v0, :cond_9a

    sget v0, Lcom/google/android/material/R$styleable;->TextInputLayout_startIconScaleType:I

    invoke-virtual {p1, v0, v2}, Landroidx/appcompat/widget/TintTypedArray;->getInt(II)I

    move-result p1

    invoke-static {p1}, Lcom/google/android/material/textfield/IconHelper;->convertScaleType(I)Landroid/widget/ImageView$ScaleType;

    move-result-object p1

    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/StartCompoundLayout;->setStartIconScaleType(Landroid/widget/ImageView$ScaleType;)V

    :cond_9a
    return-void
.end method

.method private updateVisibility()V
    .registers 5

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->prefixText:Ljava/lang/CharSequence;

    const/16 v1, 0x8

    const/4 v2, 0x0

    if-eqz v0, :cond_d

    iget-boolean v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->hintExpanded:Z

    if-nez v0, :cond_d

    move v0, v2

    goto :goto_e

    :cond_d
    move v0, v1

    :goto_e
    iget-object v3, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconView:Lcom/google/android/material/internal/CheckableImageButton;

    invoke-virtual {v3}, Lcom/google/android/material/internal/CheckableImageButton;->getVisibility()I

    move-result v3

    if-eqz v3, :cond_1b

    if-nez v0, :cond_19

    goto :goto_1b

    :cond_19
    move v3, v2

    goto :goto_1c

    :cond_1b
    :goto_1b
    const/4 v3, 0x1

    :goto_1c
    if-eqz v3, :cond_1f

    move v1, v2

    :cond_1f
    invoke-virtual {p0, v1}, Lcom/google/android/material/textfield/StartCompoundLayout;->setVisibility(I)V

    iget-object v1, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->prefixTextView:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setVisibility(I)V

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->textInputLayout:Lcom/google/android/material/textfield/TextInputLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/TextInputLayout;->updateDummyDrawables()Z

    return-void
.end method


# virtual methods
.method getPrefixText()Ljava/lang/CharSequence;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->prefixText:Ljava/lang/CharSequence;

    return-object v0
.end method

.method getPrefixTextColor()Landroid/content/res/ColorStateList;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->prefixTextView:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getTextColors()Landroid/content/res/ColorStateList;

    move-result-object v0

    return-object v0
.end method

.method getPrefixTextView()Landroid/widget/TextView;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->prefixTextView:Landroid/widget/TextView;

    return-object v0
.end method

.method getStartIconContentDescription()Ljava/lang/CharSequence;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconView:Lcom/google/android/material/internal/CheckableImageButton;

    invoke-virtual {v0}, Lcom/google/android/material/internal/CheckableImageButton;->getContentDescription()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method getStartIconDrawable()Landroid/graphics/drawable/Drawable;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconView:Lcom/google/android/material/internal/CheckableImageButton;

    invoke-virtual {v0}, Lcom/google/android/material/internal/CheckableImageButton;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0
.end method

.method getStartIconMinSize()I
    .registers 2

    iget v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconMinSize:I

    return v0
.end method

.method getStartIconScaleType()Landroid/widget/ImageView$ScaleType;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconScaleType:Landroid/widget/ImageView$ScaleType;

    return-object v0
.end method

.method isStartIconCheckable()Z
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconView:Lcom/google/android/material/internal/CheckableImageButton;

    invoke-virtual {v0}, Lcom/google/android/material/internal/CheckableImageButton;->isCheckable()Z

    move-result v0

    return v0
.end method

.method isStartIconVisible()Z
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconView:Lcom/google/android/material/internal/CheckableImageButton;

    invoke-virtual {v0}, Lcom/google/android/material/internal/CheckableImageButton;->getVisibility()I

    move-result v0

    if-nez v0, :cond_a

    const/4 v0, 0x1

    goto :goto_b

    :cond_a
    const/4 v0, 0x0

    :goto_b
    return v0
.end method

.method onHintStateChanged(Z)V
    .registers 2

    iput-boolean p1, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->hintExpanded:Z

    invoke-direct {p0}, Lcom/google/android/material/textfield/StartCompoundLayout;->updateVisibility()V

    return-void
.end method

.method protected onMeasure(II)V
    .registers 3

    invoke-super {p0, p1, p2}, Landroid/widget/LinearLayout;->onMeasure(II)V

    invoke-virtual {p0}, Lcom/google/android/material/textfield/StartCompoundLayout;->updatePrefixTextViewPadding()V

    return-void
.end method

.method refreshStartIconDrawableState()V
    .registers 4

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->textInputLayout:Lcom/google/android/material/textfield/TextInputLayout;

    iget-object v1, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconView:Lcom/google/android/material/internal/CheckableImageButton;

    iget-object v2, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconTintList:Landroid/content/res/ColorStateList;

    invoke-static {v0, v1, v2}, Lcom/google/android/material/textfield/IconHelper;->refreshIconDrawableState(Lcom/google/android/material/textfield/TextInputLayout;Lcom/google/android/material/internal/CheckableImageButton;Landroid/content/res/ColorStateList;)V

    return-void
.end method

.method setPrefixText(Ljava/lang/CharSequence;)V
    .registers 3

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_8

    const/4 v0, 0x0

    goto :goto_9

    :cond_8
    move-object v0, p1

    :goto_9
    iput-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->prefixText:Ljava/lang/CharSequence;

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->prefixTextView:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    invoke-direct {p0}, Lcom/google/android/material/textfield/StartCompoundLayout;->updateVisibility()V

    return-void
.end method

.method setPrefixTextAppearance(I)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->prefixTextView:Landroid/widget/TextView;

    invoke-static {v0, p1}, Landroidx/core/widget/TextViewCompat;->setTextAppearance(Landroid/widget/TextView;I)V

    return-void
.end method

.method setPrefixTextColor(Landroid/content/res/ColorStateList;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->prefixTextView:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setTextColor(Landroid/content/res/ColorStateList;)V

    return-void
.end method

.method setStartIconCheckable(Z)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconView:Lcom/google/android/material/internal/CheckableImageButton;

    invoke-virtual {v0, p1}, Lcom/google/android/material/internal/CheckableImageButton;->setCheckable(Z)V

    return-void
.end method

.method setStartIconContentDescription(Ljava/lang/CharSequence;)V
    .registers 3

    invoke-virtual {p0}, Lcom/google/android/material/textfield/StartCompoundLayout;->getStartIconContentDescription()Ljava/lang/CharSequence;

    move-result-object v0

    if-eq v0, p1, :cond_b

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconView:Lcom/google/android/material/internal/CheckableImageButton;

    invoke-virtual {v0, p1}, Lcom/google/android/material/internal/CheckableImageButton;->setContentDescription(Ljava/lang/CharSequence;)V

    :cond_b
    return-void
.end method

.method setStartIconDrawable(Landroid/graphics/drawable/Drawable;)V
    .registers 5

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconView:Lcom/google/android/material/internal/CheckableImageButton;

    invoke-virtual {v0, p1}, Lcom/google/android/material/internal/CheckableImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    if-eqz p1, :cond_1a

    iget-object p1, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->textInputLayout:Lcom/google/android/material/textfield/TextInputLayout;

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconView:Lcom/google/android/material/internal/CheckableImageButton;

    iget-object v1, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconTintList:Landroid/content/res/ColorStateList;

    iget-object v2, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconTintMode:Landroid/graphics/PorterDuff$Mode;

    invoke-static {p1, v0, v1, v2}, Lcom/google/android/material/textfield/IconHelper;->applyIconTint(Lcom/google/android/material/textfield/TextInputLayout;Lcom/google/android/material/internal/CheckableImageButton;Landroid/content/res/ColorStateList;Landroid/graphics/PorterDuff$Mode;)V

    const/4 p1, 0x1

    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/StartCompoundLayout;->setStartIconVisible(Z)V

    invoke-virtual {p0}, Lcom/google/android/material/textfield/StartCompoundLayout;->refreshStartIconDrawableState()V

    goto :goto_28

    :cond_1a
    const/4 p1, 0x0

    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/StartCompoundLayout;->setStartIconVisible(Z)V

    const/4 p1, 0x0

    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/StartCompoundLayout;->setStartIconOnClickListener(Landroid/view/View$OnClickListener;)V

    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/StartCompoundLayout;->setStartIconOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/StartCompoundLayout;->setStartIconContentDescription(Ljava/lang/CharSequence;)V

    :goto_28
    return-void
.end method

.method setStartIconMinSize(I)V
    .registers 3

    if-ltz p1, :cond_e

    iget v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconMinSize:I

    if-eq p1, v0, :cond_d

    iput p1, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconMinSize:I

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconView:Lcom/google/android/material/internal/CheckableImageButton;

    invoke-static {v0, p1}, Lcom/google/android/material/textfield/IconHelper;->setIconMinSize(Lcom/google/android/material/internal/CheckableImageButton;I)V

    :cond_d
    return-void

    :cond_e
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string v0, "startIconSize cannot be less than 0"

    invoke-direct {p1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method setStartIconOnClickListener(Landroid/view/View$OnClickListener;)V
    .registers 4

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconView:Lcom/google/android/material/internal/CheckableImageButton;

    iget-object v1, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconOnLongClickListener:Landroid/view/View$OnLongClickListener;

    invoke-static {v0, p1, v1}, Lcom/google/android/material/textfield/IconHelper;->setIconOnClickListener(Lcom/google/android/material/internal/CheckableImageButton;Landroid/view/View$OnClickListener;Landroid/view/View$OnLongClickListener;)V

    return-void
.end method

.method setStartIconOnLongClickListener(Landroid/view/View$OnLongClickListener;)V
    .registers 3

    iput-object p1, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconOnLongClickListener:Landroid/view/View$OnLongClickListener;

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconView:Lcom/google/android/material/internal/CheckableImageButton;

    invoke-static {v0, p1}, Lcom/google/android/material/textfield/IconHelper;->setIconOnLongClickListener(Lcom/google/android/material/internal/CheckableImageButton;Landroid/view/View$OnLongClickListener;)V

    return-void
.end method

.method setStartIconScaleType(Landroid/widget/ImageView$ScaleType;)V
    .registers 3

    iput-object p1, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconScaleType:Landroid/widget/ImageView$ScaleType;

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconView:Lcom/google/android/material/internal/CheckableImageButton;

    invoke-static {v0, p1}, Lcom/google/android/material/textfield/IconHelper;->setIconScaleType(Lcom/google/android/material/internal/CheckableImageButton;Landroid/widget/ImageView$ScaleType;)V

    return-void
.end method

.method setStartIconTintList(Landroid/content/res/ColorStateList;)V
    .registers 5

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconTintList:Landroid/content/res/ColorStateList;

    if-eq v0, p1, :cond_f

    iput-object p1, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconTintList:Landroid/content/res/ColorStateList;

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->textInputLayout:Lcom/google/android/material/textfield/TextInputLayout;

    iget-object v1, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconView:Lcom/google/android/material/internal/CheckableImageButton;

    iget-object v2, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconTintMode:Landroid/graphics/PorterDuff$Mode;

    invoke-static {v0, v1, p1, v2}, Lcom/google/android/material/textfield/IconHelper;->applyIconTint(Lcom/google/android/material/textfield/TextInputLayout;Lcom/google/android/material/internal/CheckableImageButton;Landroid/content/res/ColorStateList;Landroid/graphics/PorterDuff$Mode;)V

    :cond_f
    return-void
.end method

.method setStartIconTintMode(Landroid/graphics/PorterDuff$Mode;)V
    .registers 5

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconTintMode:Landroid/graphics/PorterDuff$Mode;

    if-eq v0, p1, :cond_f

    iput-object p1, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconTintMode:Landroid/graphics/PorterDuff$Mode;

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->textInputLayout:Lcom/google/android/material/textfield/TextInputLayout;

    iget-object v1, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconView:Lcom/google/android/material/internal/CheckableImageButton;

    iget-object v2, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconTintList:Landroid/content/res/ColorStateList;

    invoke-static {v0, v1, v2, p1}, Lcom/google/android/material/textfield/IconHelper;->applyIconTint(Lcom/google/android/material/textfield/TextInputLayout;Lcom/google/android/material/internal/CheckableImageButton;Landroid/content/res/ColorStateList;Landroid/graphics/PorterDuff$Mode;)V

    :cond_f
    return-void
.end method

.method setStartIconVisible(Z)V
    .registers 3

    invoke-virtual {p0}, Lcom/google/android/material/textfield/StartCompoundLayout;->isStartIconVisible()Z

    move-result v0

    if-eq v0, p1, :cond_17

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconView:Lcom/google/android/material/internal/CheckableImageButton;

    if-eqz p1, :cond_c

    const/4 p1, 0x0

    goto :goto_e

    :cond_c
    const/16 p1, 0x8

    :goto_e
    invoke-virtual {v0, p1}, Lcom/google/android/material/internal/CheckableImageButton;->setVisibility(I)V

    invoke-virtual {p0}, Lcom/google/android/material/textfield/StartCompoundLayout;->updatePrefixTextViewPadding()V

    invoke-direct {p0}, Lcom/google/android/material/textfield/StartCompoundLayout;->updateVisibility()V

    :cond_17
    return-void
.end method

.method setupAccessibilityNodeInfo(Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->prefixTextView:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getVisibility()I

    move-result v0

    if-nez v0, :cond_13

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->prefixTextView:Landroid/widget/TextView;

    invoke-virtual {p1, v0}, Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;->setLabelFor(Landroid/view/View;)V

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->prefixTextView:Landroid/widget/TextView;

    invoke-virtual {p1, v0}, Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;->setTraversalAfter(Landroid/view/View;)V

    goto :goto_18

    :cond_13
    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconView:Lcom/google/android/material/internal/CheckableImageButton;

    invoke-virtual {p1, v0}, Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;->setTraversalAfter(Landroid/view/View;)V

    :goto_18
    return-void
.end method

.method updatePrefixTextViewPadding()V
    .registers 7

    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->textInputLayout:Lcom/google/android/material/textfield/TextInputLayout;

    iget-object v0, v0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    if-nez v0, :cond_7

    return-void

    :cond_7
    invoke-virtual {p0}, Lcom/google/android/material/textfield/StartCompoundLayout;->isStartIconVisible()Z

    move-result v1

    if-eqz v1, :cond_f

    const/4 v1, 0x0

    goto :goto_13

    :cond_f
    invoke-static {v0}, Landroidx/core/view/ViewCompat;->getPaddingStart(Landroid/view/View;)I

    move-result v1

    :goto_13
    iget-object v2, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->prefixTextView:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/EditText;->getCompoundPaddingTop()I

    move-result v3

    invoke-virtual {p0}, Lcom/google/android/material/textfield/StartCompoundLayout;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/google/android/material/R$dimen;->material_input_text_to_prefix_suffix_padding:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v4

    invoke-virtual {v0}, Landroid/widget/EditText;->getCompoundPaddingBottom()I

    move-result v0

    invoke-static {v2, v1, v3, v4, v0}, Landroidx/core/view/ViewCompat;->setPaddingRelative(Landroid/view/View;IIII)V

    return-void
.end method
