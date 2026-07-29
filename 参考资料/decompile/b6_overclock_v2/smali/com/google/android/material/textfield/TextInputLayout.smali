.class public Lcom/google/android/material/textfield/TextInputLayout;
.super Landroid/widget/LinearLayout;
.source "TextInputLayout.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/material/textfield/TextInputLayout$AccessibilityDelegate;,
        Lcom/google/android/material/textfield/TextInputLayout$SavedState;,
        Lcom/google/android/material/textfield/TextInputLayout$OnEndIconChangedListener;,
        Lcom/google/android/material/textfield/TextInputLayout$OnEditTextAttachedListener;,
        Lcom/google/android/material/textfield/TextInputLayout$EndIconMode;,
        Lcom/google/android/material/textfield/TextInputLayout$BoxBackgroundMode;,
        Lcom/google/android/material/textfield/TextInputLayout$LengthCounter;
    }
.end annotation


# static fields
.field public static final BOX_BACKGROUND_FILLED:I = 0x1

.field public static final BOX_BACKGROUND_NONE:I = 0x0

.field public static final BOX_BACKGROUND_OUTLINE:I = 0x2

.field private static final DEFAULT_PLACEHOLDER_FADE_DURATION:I = 0x57

.field private static final DEF_STYLE_RES:I

.field private static final EDIT_TEXT_BACKGROUND_RIPPLE_STATE:[[I

.field public static final END_ICON_CLEAR_TEXT:I = 0x2

.field public static final END_ICON_CUSTOM:I = -0x1

.field public static final END_ICON_DROPDOWN_MENU:I = 0x3

.field public static final END_ICON_NONE:I = 0x0

.field public static final END_ICON_PASSWORD_TOGGLE:I = 0x1

.field private static final INVALID_MAX_LENGTH:I = -0x1

.field private static final LABEL_SCALE_ANIMATION_DURATION:I = 0xa7

.field private static final LOG_TAG:Ljava/lang/String; = "TextInputLayout"

.field private static final NO_WIDTH:I = -0x1

.field private static final PLACEHOLDER_START_DELAY:I = 0x43


# instance fields
.field private animator:Landroid/animation/ValueAnimator;

.field private areCornerRadiiRtl:Z

.field private boxBackground:Lcom/google/android/material/shape/MaterialShapeDrawable;

.field private boxBackgroundApplied:Z

.field private boxBackgroundColor:I

.field private boxBackgroundMode:I

.field private boxCollapsedPaddingTopPx:I

.field private final boxLabelCutoutPaddingPx:I

.field private boxStrokeColor:I

.field private boxStrokeWidthDefaultPx:I

.field private boxStrokeWidthFocusedPx:I

.field private boxStrokeWidthPx:I

.field private boxUnderlineDefault:Lcom/google/android/material/shape/MaterialShapeDrawable;

.field private boxUnderlineFocused:Lcom/google/android/material/shape/MaterialShapeDrawable;

.field final collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

.field counterEnabled:Z

.field private counterMaxLength:I

.field private counterOverflowTextAppearance:I

.field private counterOverflowTextColor:Landroid/content/res/ColorStateList;

.field private counterOverflowed:Z

.field private counterTextAppearance:I

.field private counterTextColor:Landroid/content/res/ColorStateList;

.field private counterView:Landroid/widget/TextView;

.field private defaultFilledBackgroundColor:I

.field private defaultHintTextColor:Landroid/content/res/ColorStateList;

.field private defaultStrokeColor:I

.field private disabledColor:I

.field private disabledFilledBackgroundColor:I

.field editText:Landroid/widget/EditText;

.field private final editTextAttachedListeners:Ljava/util/LinkedHashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedHashSet<",
            "Lcom/google/android/material/textfield/TextInputLayout$OnEditTextAttachedListener;",
            ">;"
        }
    .end annotation
.end field

.field private endDummyDrawable:Landroid/graphics/drawable/Drawable;

.field private endDummyDrawableWidth:I

.field private final endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

.field private expandedHintEnabled:Z

.field private filledDropDownMenuBackground:Landroid/graphics/drawable/StateListDrawable;

.field private focusedFilledBackgroundColor:I

.field private focusedStrokeColor:I

.field private focusedTextColor:Landroid/content/res/ColorStateList;

.field private hint:Ljava/lang/CharSequence;

.field private hintAnimationEnabled:Z

.field private hintEnabled:Z

.field private hintExpanded:Z

.field private hoveredFilledBackgroundColor:I

.field private hoveredStrokeColor:I

.field private inDrawableStateChanged:Z

.field private final indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

.field private final inputFrame:Landroid/widget/FrameLayout;

.field private isProvidingHint:Z

.field private lengthCounter:Lcom/google/android/material/textfield/TextInputLayout$LengthCounter;

.field private maxEms:I

.field private maxWidth:I

.field private minEms:I

.field private minWidth:I

.field private originalEditTextEndDrawable:Landroid/graphics/drawable/Drawable;

.field private originalHint:Ljava/lang/CharSequence;

.field private outlinedDropDownMenuBackground:Lcom/google/android/material/shape/MaterialShapeDrawable;

.field private placeholderEnabled:Z

.field private placeholderFadeIn:Landroidx/transition/Fade;

.field private placeholderFadeOut:Landroidx/transition/Fade;

.field private placeholderText:Ljava/lang/CharSequence;

.field private placeholderTextAppearance:I

.field private placeholderTextColor:Landroid/content/res/ColorStateList;

.field private placeholderTextView:Landroid/widget/TextView;

.field private restoringSavedState:Z

.field private shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

.field private startDummyDrawable:Landroid/graphics/drawable/Drawable;

.field private startDummyDrawableWidth:I

.field private final startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

.field private strokeErrorColor:Landroid/content/res/ColorStateList;

.field private final tmpBoundsRect:Landroid/graphics/Rect;

.field private final tmpRect:Landroid/graphics/Rect;

.field private final tmpRectF:Landroid/graphics/RectF;

.field private typeface:Landroid/graphics/Typeface;


# direct methods
.method static constructor <clinit>()V
    .registers 5

    sget v0, Lcom/google/android/material/R$style;->Widget_Design_TextInputLayout:I

    sput v0, Lcom/google/android/material/textfield/TextInputLayout;->DEF_STYLE_RES:I

    const/4 v0, 0x2

    new-array v0, v0, [[I

    const/4 v1, 0x1

    new-array v2, v1, [I

    const v3, 0x10100a7

    const/4 v4, 0x0

    aput v3, v2, v4

    aput-object v2, v0, v4

    new-array v2, v4, [I

    aput-object v2, v0, v1

    sput-object v0, Lcom/google/android/material/textfield/TextInputLayout;->EDIT_TEXT_BACKGROUND_RIPPLE_STATE:[[I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .registers 3

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/google/android/material/textfield/TextInputLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 4

    sget v0, Lcom/google/android/material/R$attr;->textInputStyle:I

    invoke-direct {p0, p1, p2, v0}, Lcom/google/android/material/textfield/TextInputLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .registers 20

    move-object/from16 v0, p0

    move-object/from16 v7, p2

    move/from16 v8, p3

    sget v9, Lcom/google/android/material/textfield/TextInputLayout;->DEF_STYLE_RES:I

    move-object/from16 v1, p1

    invoke-static {v1, v7, v8, v9}, Lcom/google/android/material/theme/overlay/MaterialThemeOverlay;->wrap(Landroid/content/Context;Landroid/util/AttributeSet;II)Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1, v7, v8}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    const/4 v10, -0x1

    iput v10, v0, Lcom/google/android/material/textfield/TextInputLayout;->minEms:I

    iput v10, v0, Lcom/google/android/material/textfield/TextInputLayout;->maxEms:I

    iput v10, v0, Lcom/google/android/material/textfield/TextInputLayout;->minWidth:I

    iput v10, v0, Lcom/google/android/material/textfield/TextInputLayout;->maxWidth:I

    new-instance v1, Lcom/google/android/material/textfield/IndicatorViewController;

    invoke-direct {v1, v0}, Lcom/google/android/material/textfield/IndicatorViewController;-><init>(Lcom/google/android/material/textfield/TextInputLayout;)V

    iput-object v1, v0, Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

    new-instance v1, Lcom/google/android/material/textfield/TextInputLayout$$ExternalSyntheticLambda0;

    invoke-direct {v1}, Lcom/google/android/material/textfield/TextInputLayout$$ExternalSyntheticLambda0;-><init>()V

    iput-object v1, v0, Lcom/google/android/material/textfield/TextInputLayout;->lengthCounter:Lcom/google/android/material/textfield/TextInputLayout$LengthCounter;

    new-instance v1, Landroid/graphics/Rect;

    invoke-direct {v1}, Landroid/graphics/Rect;-><init>()V

    iput-object v1, v0, Lcom/google/android/material/textfield/TextInputLayout;->tmpRect:Landroid/graphics/Rect;

    new-instance v1, Landroid/graphics/Rect;

    invoke-direct {v1}, Landroid/graphics/Rect;-><init>()V

    iput-object v1, v0, Lcom/google/android/material/textfield/TextInputLayout;->tmpBoundsRect:Landroid/graphics/Rect;

    new-instance v1, Landroid/graphics/RectF;

    invoke-direct {v1}, Landroid/graphics/RectF;-><init>()V

    iput-object v1, v0, Lcom/google/android/material/textfield/TextInputLayout;->tmpRectF:Landroid/graphics/RectF;

    new-instance v1, Ljava/util/LinkedHashSet;

    invoke-direct {v1}, Ljava/util/LinkedHashSet;-><init>()V

    iput-object v1, v0, Lcom/google/android/material/textfield/TextInputLayout;->editTextAttachedListeners:Ljava/util/LinkedHashSet;

    new-instance v1, Lcom/google/android/material/internal/CollapsingTextHelper;

    invoke-direct {v1, v0}, Lcom/google/android/material/internal/CollapsingTextHelper;-><init>(Landroid/view/View;)V

    iput-object v1, v0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/material/textfield/TextInputLayout;->getContext()Landroid/content/Context;

    move-result-object v11

    const/4 v12, 0x1

    invoke-virtual {v0, v12}, Lcom/google/android/material/textfield/TextInputLayout;->setOrientation(I)V

    const/4 v13, 0x0

    invoke-virtual {v0, v13}, Lcom/google/android/material/textfield/TextInputLayout;->setWillNotDraw(Z)V

    invoke-virtual {v0, v12}, Lcom/google/android/material/textfield/TextInputLayout;->setAddStatesFromChildren(Z)V

    new-instance v14, Landroid/widget/FrameLayout;

    invoke-direct {v14, v11}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    iput-object v14, v0, Lcom/google/android/material/textfield/TextInputLayout;->inputFrame:Landroid/widget/FrameLayout;

    invoke-virtual {v14, v12}, Landroid/widget/FrameLayout;->setAddStatesFromChildren(Z)V

    sget-object v2, Lcom/google/android/material/animation/AnimationUtils;->LINEAR_INTERPOLATOR:Landroid/animation/TimeInterpolator;

    invoke-virtual {v1, v2}, Lcom/google/android/material/internal/CollapsingTextHelper;->setTextSizeInterpolator(Landroid/animation/TimeInterpolator;)V

    sget-object v2, Lcom/google/android/material/animation/AnimationUtils;->LINEAR_INTERPOLATOR:Landroid/animation/TimeInterpolator;

    invoke-virtual {v1, v2}, Lcom/google/android/material/internal/CollapsingTextHelper;->setPositionInterpolator(Landroid/animation/TimeInterpolator;)V

    const v2, 0x800033

    invoke-virtual {v1, v2}, Lcom/google/android/material/internal/CollapsingTextHelper;->setCollapsedTextGravity(I)V

    sget-object v3, Lcom/google/android/material/R$styleable;->TextInputLayout:[I

    const/4 v1, 0x5

    new-array v6, v1, [I

    sget v1, Lcom/google/android/material/R$styleable;->TextInputLayout_counterTextAppearance:I

    aput v1, v6, v13

    sget v1, Lcom/google/android/material/R$styleable;->TextInputLayout_counterOverflowTextAppearance:I

    aput v1, v6, v12

    sget v1, Lcom/google/android/material/R$styleable;->TextInputLayout_errorTextAppearance:I

    const/4 v15, 0x2

    aput v1, v6, v15

    const/4 v1, 0x3

    sget v2, Lcom/google/android/material/R$styleable;->TextInputLayout_helperTextTextAppearance:I

    aput v2, v6, v1

    const/4 v1, 0x4

    sget v2, Lcom/google/android/material/R$styleable;->TextInputLayout_hintTextAppearance:I

    aput v2, v6, v1

    move-object v1, v11

    move-object/from16 v2, p2

    move/from16 v4, p3

    move v5, v9

    invoke-static/range {v1 .. v6}, Lcom/google/android/material/internal/ThemeEnforcement;->obtainTintedStyledAttributes(Landroid/content/Context;Landroid/util/AttributeSet;[III[I)Landroidx/appcompat/widget/TintTypedArray;

    move-result-object v1

    new-instance v2, Lcom/google/android/material/textfield/StartCompoundLayout;

    invoke-direct {v2, v0, v1}, Lcom/google/android/material/textfield/StartCompoundLayout;-><init>(Lcom/google/android/material/textfield/TextInputLayout;Landroidx/appcompat/widget/TintTypedArray;)V

    iput-object v2, v0, Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_hintEnabled:I

    invoke-virtual {v1, v3, v12}, Landroidx/appcompat/widget/TintTypedArray;->getBoolean(IZ)Z

    move-result v3

    iput-boolean v3, v0, Lcom/google/android/material/textfield/TextInputLayout;->hintEnabled:Z

    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_android_hint:I

    invoke-virtual {v1, v3}, Landroidx/appcompat/widget/TintTypedArray;->getText(I)Ljava/lang/CharSequence;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/google/android/material/textfield/TextInputLayout;->setHint(Ljava/lang/CharSequence;)V

    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_hintAnimationEnabled:I

    invoke-virtual {v1, v3, v12}, Landroidx/appcompat/widget/TintTypedArray;->getBoolean(IZ)Z

    move-result v3

    iput-boolean v3, v0, Lcom/google/android/material/textfield/TextInputLayout;->hintAnimationEnabled:Z

    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_expandedHintEnabled:I

    invoke-virtual {v1, v3, v12}, Landroidx/appcompat/widget/TintTypedArray;->getBoolean(IZ)Z

    move-result v3

    iput-boolean v3, v0, Lcom/google/android/material/textfield/TextInputLayout;->expandedHintEnabled:Z

    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_android_minEms:I

    invoke-virtual {v1, v3}, Landroidx/appcompat/widget/TintTypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_d4

    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_android_minEms:I

    invoke-virtual {v1, v3, v10}, Landroidx/appcompat/widget/TintTypedArray;->getInt(II)I

    move-result v3

    invoke-virtual {v0, v3}, Lcom/google/android/material/textfield/TextInputLayout;->setMinEms(I)V

    goto :goto_e5

    :cond_d4
    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_android_minWidth:I

    invoke-virtual {v1, v3}, Landroidx/appcompat/widget/TintTypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_e5

    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_android_minWidth:I

    invoke-virtual {v1, v3, v10}, Landroidx/appcompat/widget/TintTypedArray;->getDimensionPixelSize(II)I

    move-result v3

    invoke-virtual {v0, v3}, Lcom/google/android/material/textfield/TextInputLayout;->setMinWidth(I)V

    :cond_e5
    :goto_e5
    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_android_maxEms:I

    invoke-virtual {v1, v3}, Landroidx/appcompat/widget/TintTypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_f7

    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_android_maxEms:I

    invoke-virtual {v1, v3, v10}, Landroidx/appcompat/widget/TintTypedArray;->getInt(II)I

    move-result v3

    invoke-virtual {v0, v3}, Lcom/google/android/material/textfield/TextInputLayout;->setMaxEms(I)V

    goto :goto_108

    :cond_f7
    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_android_maxWidth:I

    invoke-virtual {v1, v3}, Landroidx/appcompat/widget/TintTypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_108

    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_android_maxWidth:I

    invoke-virtual {v1, v3, v10}, Landroidx/appcompat/widget/TintTypedArray;->getDimensionPixelSize(II)I

    move-result v3

    invoke-virtual {v0, v3}, Lcom/google/android/material/textfield/TextInputLayout;->setMaxWidth(I)V

    :cond_108
    :goto_108
    invoke-static {v11, v7, v8, v9}, Lcom/google/android/material/shape/ShapeAppearanceModel;->builder(Landroid/content/Context;Landroid/util/AttributeSet;II)Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->build()Lcom/google/android/material/shape/ShapeAppearanceModel;

    move-result-object v3

    iput-object v3, v0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    invoke-virtual {v11}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/google/android/material/R$dimen;->mtrl_textinput_box_label_cutout_padding:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v3

    iput v3, v0, Lcom/google/android/material/textfield/TextInputLayout;->boxLabelCutoutPaddingPx:I

    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_boxCollapsedPaddingTop:I

    invoke-virtual {v1, v3, v13}, Landroidx/appcompat/widget/TintTypedArray;->getDimensionPixelOffset(II)I

    move-result v3

    iput v3, v0, Lcom/google/android/material/textfield/TextInputLayout;->boxCollapsedPaddingTopPx:I

    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_boxStrokeWidth:I

    invoke-virtual {v11}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/google/android/material/R$dimen;->mtrl_textinput_box_stroke_width_default:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v4

    invoke-virtual {v1, v3, v4}, Landroidx/appcompat/widget/TintTypedArray;->getDimensionPixelSize(II)I

    move-result v3

    iput v3, v0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeWidthDefaultPx:I

    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_boxStrokeWidthFocused:I

    invoke-virtual {v11}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/google/android/material/R$dimen;->mtrl_textinput_box_stroke_width_focused:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v4

    invoke-virtual {v1, v3, v4}, Landroidx/appcompat/widget/TintTypedArray;->getDimensionPixelSize(II)I

    move-result v3

    iput v3, v0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeWidthFocusedPx:I

    iget v3, v0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeWidthDefaultPx:I

    iput v3, v0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeWidthPx:I

    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_boxCornerRadiusTopStart:I

    const/high16 v4, -0x40800000    # -1.0f

    invoke-virtual {v1, v3, v4}, Landroidx/appcompat/widget/TintTypedArray;->getDimension(IF)F

    move-result v3

    sget v5, Lcom/google/android/material/R$styleable;->TextInputLayout_boxCornerRadiusTopEnd:I

    invoke-virtual {v1, v5, v4}, Landroidx/appcompat/widget/TintTypedArray;->getDimension(IF)F

    move-result v5

    sget v6, Lcom/google/android/material/R$styleable;->TextInputLayout_boxCornerRadiusBottomEnd:I

    invoke-virtual {v1, v6, v4}, Landroidx/appcompat/widget/TintTypedArray;->getDimension(IF)F

    move-result v6

    sget v7, Lcom/google/android/material/R$styleable;->TextInputLayout_boxCornerRadiusBottomStart:I

    invoke-virtual {v1, v7, v4}, Landroidx/appcompat/widget/TintTypedArray;->getDimension(IF)F

    move-result v4

    iget-object v7, v0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    invoke-virtual {v7}, Lcom/google/android/material/shape/ShapeAppearanceModel;->toBuilder()Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    move-result-object v7

    const/4 v8, 0x0

    cmpl-float v9, v3, v8

    if-ltz v9, :cond_176

    invoke-virtual {v7, v3}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->setTopLeftCornerSize(F)Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    :cond_176
    cmpl-float v3, v5, v8

    if-ltz v3, :cond_17d

    invoke-virtual {v7, v5}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->setTopRightCornerSize(F)Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    :cond_17d
    cmpl-float v3, v6, v8

    if-ltz v3, :cond_184

    invoke-virtual {v7, v6}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->setBottomRightCornerSize(F)Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    :cond_184
    cmpl-float v3, v4, v8

    if-ltz v3, :cond_18b

    invoke-virtual {v7, v4}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->setBottomLeftCornerSize(F)Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    :cond_18b
    invoke-virtual {v7}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->build()Lcom/google/android/material/shape/ShapeAppearanceModel;

    move-result-object v3

    iput-object v3, v0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_boxBackgroundColor:I

    invoke-static {v11, v1, v3}, Lcom/google/android/material/resources/MaterialResources;->getColorStateList(Landroid/content/Context;Landroidx/appcompat/widget/TintTypedArray;I)Landroid/content/res/ColorStateList;

    move-result-object v3

    if-eqz v3, :cond_1ed

    invoke-virtual {v3}, Landroid/content/res/ColorStateList;->getDefaultColor()I

    move-result v4

    iput v4, v0, Lcom/google/android/material/textfield/TextInputLayout;->defaultFilledBackgroundColor:I

    iput v4, v0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundColor:I

    invoke-virtual {v3}, Landroid/content/res/ColorStateList;->isStateful()Z

    move-result v4

    const v5, -0x101009e

    if-eqz v4, :cond_1cb

    new-array v4, v12, [I

    aput v5, v4, v13

    invoke-virtual {v3, v4, v10}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    move-result v4

    iput v4, v0, Lcom/google/android/material/textfield/TextInputLayout;->disabledFilledBackgroundColor:I

    new-array v4, v15, [I

    fill-array-data v4, :array_368

    invoke-virtual {v3, v4, v10}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    move-result v4

    iput v4, v0, Lcom/google/android/material/textfield/TextInputLayout;->focusedFilledBackgroundColor:I

    new-array v4, v15, [I

    fill-array-data v4, :array_370

    invoke-virtual {v3, v4, v10}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    move-result v3

    iput v3, v0, Lcom/google/android/material/textfield/TextInputLayout;->hoveredFilledBackgroundColor:I

    goto :goto_1f7

    :cond_1cb
    iget v3, v0, Lcom/google/android/material/textfield/TextInputLayout;->defaultFilledBackgroundColor:I

    iput v3, v0, Lcom/google/android/material/textfield/TextInputLayout;->focusedFilledBackgroundColor:I

    sget v3, Lcom/google/android/material/R$color;->mtrl_filled_background_color:I

    invoke-static {v11, v3}, Landroidx/appcompat/content/res/AppCompatResources;->getColorStateList(Landroid/content/Context;I)Landroid/content/res/ColorStateList;

    move-result-object v3

    new-array v4, v12, [I

    aput v5, v4, v13

    invoke-virtual {v3, v4, v10}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    move-result v4

    iput v4, v0, Lcom/google/android/material/textfield/TextInputLayout;->disabledFilledBackgroundColor:I

    new-array v4, v12, [I

    const v5, 0x1010367

    aput v5, v4, v13

    invoke-virtual {v3, v4, v10}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    move-result v3

    iput v3, v0, Lcom/google/android/material/textfield/TextInputLayout;->hoveredFilledBackgroundColor:I

    goto :goto_1f7

    :cond_1ed
    iput v13, v0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundColor:I

    iput v13, v0, Lcom/google/android/material/textfield/TextInputLayout;->defaultFilledBackgroundColor:I

    iput v13, v0, Lcom/google/android/material/textfield/TextInputLayout;->disabledFilledBackgroundColor:I

    iput v13, v0, Lcom/google/android/material/textfield/TextInputLayout;->focusedFilledBackgroundColor:I

    iput v13, v0, Lcom/google/android/material/textfield/TextInputLayout;->hoveredFilledBackgroundColor:I

    :goto_1f7
    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_android_textColorHint:I

    invoke-virtual {v1, v3}, Landroidx/appcompat/widget/TintTypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_209

    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_android_textColorHint:I

    invoke-virtual {v1, v3}, Landroidx/appcompat/widget/TintTypedArray;->getColorStateList(I)Landroid/content/res/ColorStateList;

    move-result-object v3

    iput-object v3, v0, Lcom/google/android/material/textfield/TextInputLayout;->focusedTextColor:Landroid/content/res/ColorStateList;

    iput-object v3, v0, Lcom/google/android/material/textfield/TextInputLayout;->defaultHintTextColor:Landroid/content/res/ColorStateList;

    :cond_209
    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_boxStrokeColor:I

    invoke-static {v11, v1, v3}, Lcom/google/android/material/resources/MaterialResources;->getColorStateList(Landroid/content/Context;Landroidx/appcompat/widget/TintTypedArray;I)Landroid/content/res/ColorStateList;

    move-result-object v3

    sget v4, Lcom/google/android/material/R$styleable;->TextInputLayout_boxStrokeColor:I

    invoke-virtual {v1, v4, v13}, Landroidx/appcompat/widget/TintTypedArray;->getColor(II)I

    move-result v4

    iput v4, v0, Lcom/google/android/material/textfield/TextInputLayout;->focusedStrokeColor:I

    sget v4, Lcom/google/android/material/R$color;->mtrl_textinput_default_box_stroke_color:I

    invoke-static {v11, v4}, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context;I)I

    move-result v4

    iput v4, v0, Lcom/google/android/material/textfield/TextInputLayout;->defaultStrokeColor:I

    sget v4, Lcom/google/android/material/R$color;->mtrl_textinput_disabled_color:I

    invoke-static {v11, v4}, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context;I)I

    move-result v4

    iput v4, v0, Lcom/google/android/material/textfield/TextInputLayout;->disabledColor:I

    sget v4, Lcom/google/android/material/R$color;->mtrl_textinput_hovered_box_stroke_color:I

    invoke-static {v11, v4}, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context;I)I

    move-result v4

    iput v4, v0, Lcom/google/android/material/textfield/TextInputLayout;->hoveredStrokeColor:I

    if-eqz v3, :cond_234

    invoke-virtual {v0, v3}, Lcom/google/android/material/textfield/TextInputLayout;->setBoxStrokeColorStateList(Landroid/content/res/ColorStateList;)V

    :cond_234
    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_boxStrokeErrorColor:I

    invoke-virtual {v1, v3}, Landroidx/appcompat/widget/TintTypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_245

    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_boxStrokeErrorColor:I

    invoke-static {v11, v1, v3}, Lcom/google/android/material/resources/MaterialResources;->getColorStateList(Landroid/content/Context;Landroidx/appcompat/widget/TintTypedArray;I)Landroid/content/res/ColorStateList;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/google/android/material/textfield/TextInputLayout;->setBoxStrokeErrorColor(Landroid/content/res/ColorStateList;)V

    :cond_245
    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_hintTextAppearance:I

    invoke-virtual {v1, v3, v10}, Landroidx/appcompat/widget/TintTypedArray;->getResourceId(II)I

    move-result v3

    if-eq v3, v10, :cond_256

    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_hintTextAppearance:I

    invoke-virtual {v1, v3, v13}, Landroidx/appcompat/widget/TintTypedArray;->getResourceId(II)I

    move-result v3

    invoke-virtual {v0, v3}, Lcom/google/android/material/textfield/TextInputLayout;->setHintTextAppearance(I)V

    :cond_256
    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_errorTextAppearance:I

    invoke-virtual {v1, v3, v13}, Landroidx/appcompat/widget/TintTypedArray;->getResourceId(II)I

    move-result v3

    sget v4, Lcom/google/android/material/R$styleable;->TextInputLayout_errorContentDescription:I

    invoke-virtual {v1, v4}, Landroidx/appcompat/widget/TintTypedArray;->getText(I)Ljava/lang/CharSequence;

    move-result-object v4

    sget v5, Lcom/google/android/material/R$styleable;->TextInputLayout_errorAccessibilityLiveRegion:I

    invoke-virtual {v1, v5, v12}, Landroidx/appcompat/widget/TintTypedArray;->getInt(II)I

    move-result v5

    sget v6, Lcom/google/android/material/R$styleable;->TextInputLayout_errorEnabled:I

    invoke-virtual {v1, v6, v13}, Landroidx/appcompat/widget/TintTypedArray;->getBoolean(IZ)Z

    move-result v6

    sget v7, Lcom/google/android/material/R$styleable;->TextInputLayout_helperTextTextAppearance:I

    invoke-virtual {v1, v7, v13}, Landroidx/appcompat/widget/TintTypedArray;->getResourceId(II)I

    move-result v7

    sget v8, Lcom/google/android/material/R$styleable;->TextInputLayout_helperTextEnabled:I

    invoke-virtual {v1, v8, v13}, Landroidx/appcompat/widget/TintTypedArray;->getBoolean(IZ)Z

    move-result v8

    sget v9, Lcom/google/android/material/R$styleable;->TextInputLayout_helperText:I

    invoke-virtual {v1, v9}, Landroidx/appcompat/widget/TintTypedArray;->getText(I)Ljava/lang/CharSequence;

    move-result-object v9

    sget v11, Lcom/google/android/material/R$styleable;->TextInputLayout_placeholderTextAppearance:I

    invoke-virtual {v1, v11, v13}, Landroidx/appcompat/widget/TintTypedArray;->getResourceId(II)I

    move-result v11

    sget v15, Lcom/google/android/material/R$styleable;->TextInputLayout_placeholderText:I

    invoke-virtual {v1, v15}, Landroidx/appcompat/widget/TintTypedArray;->getText(I)Ljava/lang/CharSequence;

    move-result-object v15

    sget v12, Lcom/google/android/material/R$styleable;->TextInputLayout_counterEnabled:I

    invoke-virtual {v1, v12, v13}, Landroidx/appcompat/widget/TintTypedArray;->getBoolean(IZ)Z

    move-result v12

    sget v13, Lcom/google/android/material/R$styleable;->TextInputLayout_counterMaxLength:I

    invoke-virtual {v1, v13, v10}, Landroidx/appcompat/widget/TintTypedArray;->getInt(II)I

    move-result v10

    invoke-virtual {v0, v10}, Lcom/google/android/material/textfield/TextInputLayout;->setCounterMaxLength(I)V

    sget v10, Lcom/google/android/material/R$styleable;->TextInputLayout_counterTextAppearance:I

    const/4 v13, 0x0

    invoke-virtual {v1, v10, v13}, Landroidx/appcompat/widget/TintTypedArray;->getResourceId(II)I

    move-result v10

    iput v10, v0, Lcom/google/android/material/textfield/TextInputLayout;->counterTextAppearance:I

    sget v10, Lcom/google/android/material/R$styleable;->TextInputLayout_counterOverflowTextAppearance:I

    invoke-virtual {v1, v10, v13}, Landroidx/appcompat/widget/TintTypedArray;->getResourceId(II)I

    move-result v10

    iput v10, v0, Lcom/google/android/material/textfield/TextInputLayout;->counterOverflowTextAppearance:I

    sget v10, Lcom/google/android/material/R$styleable;->TextInputLayout_boxBackgroundMode:I

    invoke-virtual {v1, v10, v13}, Landroidx/appcompat/widget/TintTypedArray;->getInt(II)I

    move-result v10

    invoke-virtual {v0, v10}, Lcom/google/android/material/textfield/TextInputLayout;->setBoxBackgroundMode(I)V

    invoke-virtual {v0, v4}, Lcom/google/android/material/textfield/TextInputLayout;->setErrorContentDescription(Ljava/lang/CharSequence;)V

    invoke-virtual {v0, v5}, Lcom/google/android/material/textfield/TextInputLayout;->setErrorAccessibilityLiveRegion(I)V

    iget v4, v0, Lcom/google/android/material/textfield/TextInputLayout;->counterOverflowTextAppearance:I

    invoke-virtual {v0, v4}, Lcom/google/android/material/textfield/TextInputLayout;->setCounterOverflowTextAppearance(I)V

    invoke-virtual {v0, v7}, Lcom/google/android/material/textfield/TextInputLayout;->setHelperTextTextAppearance(I)V

    invoke-virtual {v0, v3}, Lcom/google/android/material/textfield/TextInputLayout;->setErrorTextAppearance(I)V

    iget v3, v0, Lcom/google/android/material/textfield/TextInputLayout;->counterTextAppearance:I

    invoke-virtual {v0, v3}, Lcom/google/android/material/textfield/TextInputLayout;->setCounterTextAppearance(I)V

    invoke-virtual {v0, v15}, Lcom/google/android/material/textfield/TextInputLayout;->setPlaceholderText(Ljava/lang/CharSequence;)V

    invoke-virtual {v0, v11}, Lcom/google/android/material/textfield/TextInputLayout;->setPlaceholderTextAppearance(I)V

    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_errorTextColor:I

    invoke-virtual {v1, v3}, Landroidx/appcompat/widget/TintTypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_2e2

    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_errorTextColor:I

    invoke-virtual {v1, v3}, Landroidx/appcompat/widget/TintTypedArray;->getColorStateList(I)Landroid/content/res/ColorStateList;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/google/android/material/textfield/TextInputLayout;->setErrorTextColor(Landroid/content/res/ColorStateList;)V

    :cond_2e2
    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_helperTextTextColor:I

    invoke-virtual {v1, v3}, Landroidx/appcompat/widget/TintTypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_2f3

    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_helperTextTextColor:I

    invoke-virtual {v1, v3}, Landroidx/appcompat/widget/TintTypedArray;->getColorStateList(I)Landroid/content/res/ColorStateList;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/google/android/material/textfield/TextInputLayout;->setHelperTextColor(Landroid/content/res/ColorStateList;)V

    :cond_2f3
    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_hintTextColor:I

    invoke-virtual {v1, v3}, Landroidx/appcompat/widget/TintTypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_304

    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_hintTextColor:I

    invoke-virtual {v1, v3}, Landroidx/appcompat/widget/TintTypedArray;->getColorStateList(I)Landroid/content/res/ColorStateList;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/google/android/material/textfield/TextInputLayout;->setHintTextColor(Landroid/content/res/ColorStateList;)V

    :cond_304
    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_counterTextColor:I

    invoke-virtual {v1, v3}, Landroidx/appcompat/widget/TintTypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_315

    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_counterTextColor:I

    invoke-virtual {v1, v3}, Landroidx/appcompat/widget/TintTypedArray;->getColorStateList(I)Landroid/content/res/ColorStateList;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/google/android/material/textfield/TextInputLayout;->setCounterTextColor(Landroid/content/res/ColorStateList;)V

    :cond_315
    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_counterOverflowTextColor:I

    invoke-virtual {v1, v3}, Landroidx/appcompat/widget/TintTypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_326

    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_counterOverflowTextColor:I

    invoke-virtual {v1, v3}, Landroidx/appcompat/widget/TintTypedArray;->getColorStateList(I)Landroid/content/res/ColorStateList;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/google/android/material/textfield/TextInputLayout;->setCounterOverflowTextColor(Landroid/content/res/ColorStateList;)V

    :cond_326
    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_placeholderTextColor:I

    invoke-virtual {v1, v3}, Landroidx/appcompat/widget/TintTypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_337

    sget v3, Lcom/google/android/material/R$styleable;->TextInputLayout_placeholderTextColor:I

    invoke-virtual {v1, v3}, Landroidx/appcompat/widget/TintTypedArray;->getColorStateList(I)Landroid/content/res/ColorStateList;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/google/android/material/textfield/TextInputLayout;->setPlaceholderTextColor(Landroid/content/res/ColorStateList;)V

    :cond_337
    new-instance v3, Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-direct {v3, v0, v1}, Lcom/google/android/material/textfield/EndCompoundLayout;-><init>(Lcom/google/android/material/textfield/TextInputLayout;Landroidx/appcompat/widget/TintTypedArray;)V

    iput-object v3, v0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    sget v4, Lcom/google/android/material/R$styleable;->TextInputLayout_android_enabled:I

    const/4 v5, 0x1

    invoke-virtual {v1, v4, v5}, Landroidx/appcompat/widget/TintTypedArray;->getBoolean(IZ)Z

    move-result v4

    invoke-virtual {v1}, Landroidx/appcompat/widget/TintTypedArray;->recycle()V

    const/4 v1, 0x2

    invoke-static {v0, v1}, Landroidx/core/view/ViewCompat;->setImportantForAccessibility(Landroid/view/View;I)V

    invoke-static {v0, v5}, Landroidx/core/view/ViewCompat;->setImportantForAutofill(Landroid/view/View;I)V

    invoke-virtual {v14, v2}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V

    invoke-virtual {v14, v3}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V

    invoke-virtual {v0, v14}, Lcom/google/android/material/textfield/TextInputLayout;->addView(Landroid/view/View;)V

    invoke-virtual {v0, v4}, Lcom/google/android/material/textfield/TextInputLayout;->setEnabled(Z)V

    invoke-virtual {v0, v8}, Lcom/google/android/material/textfield/TextInputLayout;->setHelperTextEnabled(Z)V

    invoke-virtual {v0, v6}, Lcom/google/android/material/textfield/TextInputLayout;->setErrorEnabled(Z)V

    invoke-virtual {v0, v12}, Lcom/google/android/material/textfield/TextInputLayout;->setCounterEnabled(Z)V

    invoke-virtual {v0, v9}, Lcom/google/android/material/textfield/TextInputLayout;->setHelperText(Ljava/lang/CharSequence;)V

    return-void

    :array_368
    .array-data 4
        0x101009c
        0x101009e
    .end array-data

    :array_370
    .array-data 4
        0x1010367
        0x101009e
    .end array-data
.end method

.method static synthetic access$000(Lcom/google/android/material/textfield/TextInputLayout;)Z
    .registers 1

    iget-boolean p0, p0, Lcom/google/android/material/textfield/TextInputLayout;->restoringSavedState:Z

    return p0
.end method

.method static synthetic access$100(Lcom/google/android/material/textfield/TextInputLayout;)Z
    .registers 1

    iget-boolean p0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderEnabled:Z

    return p0
.end method

.method static synthetic access$200(Lcom/google/android/material/textfield/TextInputLayout;Landroid/text/Editable;)V
    .registers 2

    invoke-direct {p0, p1}, Lcom/google/android/material/textfield/TextInputLayout;->updatePlaceholderText(Landroid/text/Editable;)V

    return-void
.end method

.method static synthetic access$300(Lcom/google/android/material/textfield/TextInputLayout;)Lcom/google/android/material/textfield/EndCompoundLayout;
    .registers 1

    iget-object p0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    return-object p0
.end method

.method static synthetic access$400(Lcom/google/android/material/textfield/TextInputLayout;)Lcom/google/android/material/textfield/StartCompoundLayout;
    .registers 1

    iget-object p0, p0, Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

    return-object p0
.end method

.method static synthetic access$500(Lcom/google/android/material/textfield/TextInputLayout;)Lcom/google/android/material/textfield/IndicatorViewController;
    .registers 1

    iget-object p0, p0, Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

    return-object p0
.end method

.method private addPlaceholderTextView()V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderTextView:Landroid/widget/TextView;

    if-eqz v0, :cond_f

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->inputFrame:Landroid/widget/FrameLayout;

    invoke-virtual {v1, v0}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderTextView:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    :cond_f
    return-void
.end method

.method private adjustFilledEditTextPaddingForLargeFont()V
    .registers 7

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    if-eqz v0, :cond_65

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundMode:I

    const/4 v1, 0x1

    if-eq v0, v1, :cond_a

    goto :goto_65

    :cond_a
    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/material/resources/MaterialResources;->isFontScaleAtLeast2_0(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_38

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-static {v0}, Landroidx/core/view/ViewCompat;->getPaddingStart(Landroid/view/View;)I

    move-result v1

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/google/android/material/R$dimen;->material_filled_edittext_font_2_0_padding_top:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    iget-object v3, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-static {v3}, Landroidx/core/view/ViewCompat;->getPaddingEnd(Landroid/view/View;)I

    move-result v3

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/google/android/material/R$dimen;->material_filled_edittext_font_2_0_padding_bottom:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v4

    invoke-static {v0, v1, v2, v3, v4}, Landroidx/core/view/ViewCompat;->setPaddingRelative(Landroid/view/View;IIII)V

    goto :goto_65

    :cond_38
    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/material/resources/MaterialResources;->isFontScaleAtLeast1_3(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_65

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-static {v0}, Landroidx/core/view/ViewCompat;->getPaddingStart(Landroid/view/View;)I

    move-result v1

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/google/android/material/R$dimen;->material_filled_edittext_font_1_3_padding_top:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    iget-object v3, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-static {v3}, Landroidx/core/view/ViewCompat;->getPaddingEnd(Landroid/view/View;)I

    move-result v3

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/google/android/material/R$dimen;->material_filled_edittext_font_1_3_padding_bottom:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v4

    invoke-static {v0, v1, v2, v3, v4}, Landroidx/core/view/ViewCompat;->setPaddingRelative(Landroid/view/View;IIII)V

    :cond_65
    :goto_65
    return-void
.end method

.method private applyBoxAttributes()V
    .registers 4

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackground:Lcom/google/android/material/shape/MaterialShapeDrawable;

    if-nez v0, :cond_5

    return-void

    :cond_5
    invoke-virtual {v0}, Lcom/google/android/material/shape/MaterialShapeDrawable;->getShapeAppearanceModel()Lcom/google/android/material/shape/ShapeAppearanceModel;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    if-eq v0, v1, :cond_12

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackground:Lcom/google/android/material/shape/MaterialShapeDrawable;

    invoke-virtual {v0, v1}, Lcom/google/android/material/shape/MaterialShapeDrawable;->setShapeAppearanceModel(Lcom/google/android/material/shape/ShapeAppearanceModel;)V

    :cond_12
    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->canDrawOutlineStroke()Z

    move-result v0

    if-eqz v0, :cond_22

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackground:Lcom/google/android/material/shape/MaterialShapeDrawable;

    iget v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeWidthPx:I

    int-to-float v1, v1

    iget v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeColor:I

    invoke-virtual {v0, v1, v2}, Lcom/google/android/material/shape/MaterialShapeDrawable;->setStroke(FI)V

    :cond_22
    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->calculateBoxBackgroundColor()I

    move-result v0

    iput v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundColor:I

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackground:Lcom/google/android/material/shape/MaterialShapeDrawable;

    invoke-static {v0}, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/google/android/material/shape/MaterialShapeDrawable;->setFillColor(Landroid/content/res/ColorStateList;)V

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->applyBoxUnderlineAttributes()V

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->updateEditTextBoxBackgroundIfNeeded()V

    return-void
.end method

.method private applyBoxUnderlineAttributes()V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxUnderlineDefault:Lcom/google/android/material/shape/MaterialShapeDrawable;

    if-eqz v0, :cond_37

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxUnderlineFocused:Lcom/google/android/material/shape/MaterialShapeDrawable;

    if-nez v0, :cond_9

    goto :goto_37

    :cond_9
    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->canDrawStroke()Z

    move-result v0

    if-eqz v0, :cond_34

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxUnderlineDefault:Lcom/google/android/material/shape/MaterialShapeDrawable;

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->isFocused()Z

    move-result v1

    if-eqz v1, :cond_20

    iget v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->defaultStrokeColor:I

    invoke-static {v1}, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;

    move-result-object v1

    goto :goto_26

    :cond_20
    iget v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeColor:I

    invoke-static {v1}, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;

    move-result-object v1

    :goto_26
    invoke-virtual {v0, v1}, Lcom/google/android/material/shape/MaterialShapeDrawable;->setFillColor(Landroid/content/res/ColorStateList;)V

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxUnderlineFocused:Lcom/google/android/material/shape/MaterialShapeDrawable;

    iget v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeColor:I

    invoke-static {v1}, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/material/shape/MaterialShapeDrawable;->setFillColor(Landroid/content/res/ColorStateList;)V

    :cond_34
    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->invalidate()V

    :cond_37
    :goto_37
    return-void
.end method

.method private applyCutoutPadding(Landroid/graphics/RectF;)V
    .registers 4

    iget v0, p1, Landroid/graphics/RectF;->left:F

    iget v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxLabelCutoutPaddingPx:I

    int-to-float v1, v1

    sub-float/2addr v0, v1

    iput v0, p1, Landroid/graphics/RectF;->left:F

    iget v0, p1, Landroid/graphics/RectF;->right:F

    iget v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxLabelCutoutPaddingPx:I

    int-to-float v1, v1

    add-float/2addr v0, v1

    iput v0, p1, Landroid/graphics/RectF;->right:F

    return-void
.end method

.method private assignBoxBackgroundByMode()V
    .registers 4

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundMode:I

    const/4 v1, 0x0

    if-eqz v0, :cond_5f

    const/4 v2, 0x1

    if-eq v0, v2, :cond_47

    const/4 v2, 0x2

    if-ne v0, v2, :cond_2c

    iget-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->hintEnabled:Z

    if-eqz v0, :cond_1e

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackground:Lcom/google/android/material/shape/MaterialShapeDrawable;

    instance-of v0, v0, Lcom/google/android/material/textfield/CutoutDrawable;

    if-nez v0, :cond_1e

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    invoke-static {v0}, Lcom/google/android/material/textfield/CutoutDrawable;->create(Lcom/google/android/material/shape/ShapeAppearanceModel;)Lcom/google/android/material/textfield/CutoutDrawable;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackground:Lcom/google/android/material/shape/MaterialShapeDrawable;

    goto :goto_27

    :cond_1e
    new-instance v0, Lcom/google/android/material/shape/MaterialShapeDrawable;

    iget-object v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    invoke-direct {v0, v2}, Lcom/google/android/material/shape/MaterialShapeDrawable;-><init>(Lcom/google/android/material/shape/ShapeAppearanceModel;)V

    iput-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackground:Lcom/google/android/material/shape/MaterialShapeDrawable;

    :goto_27
    iput-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxUnderlineDefault:Lcom/google/android/material/shape/MaterialShapeDrawable;

    iput-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxUnderlineFocused:Lcom/google/android/material/shape/MaterialShapeDrawable;

    goto :goto_65

    :cond_2c
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundMode:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " is illegal; only @BoxBackgroundMode constants are supported."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_47
    new-instance v0, Lcom/google/android/material/shape/MaterialShapeDrawable;

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    invoke-direct {v0, v1}, Lcom/google/android/material/shape/MaterialShapeDrawable;-><init>(Lcom/google/android/material/shape/ShapeAppearanceModel;)V

    iput-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackground:Lcom/google/android/material/shape/MaterialShapeDrawable;

    new-instance v0, Lcom/google/android/material/shape/MaterialShapeDrawable;

    invoke-direct {v0}, Lcom/google/android/material/shape/MaterialShapeDrawable;-><init>()V

    iput-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxUnderlineDefault:Lcom/google/android/material/shape/MaterialShapeDrawable;

    new-instance v0, Lcom/google/android/material/shape/MaterialShapeDrawable;

    invoke-direct {v0}, Lcom/google/android/material/shape/MaterialShapeDrawable;-><init>()V

    iput-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxUnderlineFocused:Lcom/google/android/material/shape/MaterialShapeDrawable;

    goto :goto_65

    :cond_5f
    iput-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackground:Lcom/google/android/material/shape/MaterialShapeDrawable;

    iput-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxUnderlineDefault:Lcom/google/android/material/shape/MaterialShapeDrawable;

    iput-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxUnderlineFocused:Lcom/google/android/material/shape/MaterialShapeDrawable;

    :goto_65
    return-void
.end method

.method private calculateBoxBackgroundColor()I
    .registers 4

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundColor:I

    iget v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundMode:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_14

    sget v0, Lcom/google/android/material/R$attr;->colorSurface:I

    const/4 v1, 0x0

    invoke-static {p0, v0, v1}, Lcom/google/android/material/color/MaterialColors;->getColor(Landroid/view/View;II)I

    move-result v0

    iget v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundColor:I

    invoke-static {v0, v1}, Lcom/google/android/material/color/MaterialColors;->layer(II)I

    move-result v0

    :cond_14
    return v0
.end method

.method private calculateCollapsedTextBounds(Landroid/graphics/Rect;)Landroid/graphics/Rect;
    .registers 6

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    if-eqz v0, :cond_65

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->tmpBoundsRect:Landroid/graphics/Rect;

    invoke-static {p0}, Lcom/google/android/material/internal/ViewUtils;->isLayoutRtl(Landroid/view/View;)Z

    move-result v1

    iget v2, p1, Landroid/graphics/Rect;->bottom:I

    iput v2, v0, Landroid/graphics/Rect;->bottom:I

    iget v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundMode:I

    const/4 v3, 0x1

    if-eq v2, v3, :cond_4d

    const/4 v3, 0x2

    if-eq v2, v3, :cond_2d

    iget v2, p1, Landroid/graphics/Rect;->left:I

    invoke-direct {p0, v2, v1}, Lcom/google/android/material/textfield/TextInputLayout;->getLabelLeftBoundAlightWithPrefix(IZ)I

    move-result v2

    iput v2, v0, Landroid/graphics/Rect;->left:I

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getPaddingTop()I

    move-result v2

    iput v2, v0, Landroid/graphics/Rect;->top:I

    iget p1, p1, Landroid/graphics/Rect;->right:I

    invoke-direct {p0, p1, v1}, Lcom/google/android/material/textfield/TextInputLayout;->getLabelRightBoundAlignedWithSuffix(IZ)I

    move-result p1

    iput p1, v0, Landroid/graphics/Rect;->right:I

    return-object v0

    :cond_2d
    iget v1, p1, Landroid/graphics/Rect;->left:I

    iget-object v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getPaddingLeft()I

    move-result v2

    add-int/2addr v1, v2

    iput v1, v0, Landroid/graphics/Rect;->left:I

    iget v1, p1, Landroid/graphics/Rect;->top:I

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->calculateLabelMarginTop()I

    move-result v2

    sub-int/2addr v1, v2

    iput v1, v0, Landroid/graphics/Rect;->top:I

    iget p1, p1, Landroid/graphics/Rect;->right:I

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getPaddingRight()I

    move-result v1

    sub-int/2addr p1, v1

    iput p1, v0, Landroid/graphics/Rect;->right:I

    return-object v0

    :cond_4d
    iget v2, p1, Landroid/graphics/Rect;->left:I

    invoke-direct {p0, v2, v1}, Lcom/google/android/material/textfield/TextInputLayout;->getLabelLeftBoundAlightWithPrefix(IZ)I

    move-result v2

    iput v2, v0, Landroid/graphics/Rect;->left:I

    iget v2, p1, Landroid/graphics/Rect;->top:I

    iget v3, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxCollapsedPaddingTopPx:I

    add-int/2addr v2, v3

    iput v2, v0, Landroid/graphics/Rect;->top:I

    iget p1, p1, Landroid/graphics/Rect;->right:I

    invoke-direct {p0, p1, v1}, Lcom/google/android/material/textfield/TextInputLayout;->getLabelRightBoundAlignedWithSuffix(IZ)I

    move-result p1

    iput p1, v0, Landroid/graphics/Rect;->right:I

    return-object v0

    :cond_65
    new-instance p1, Ljava/lang/IllegalStateException;

    invoke-direct {p1}, Ljava/lang/IllegalStateException;-><init>()V

    throw p1
.end method

.method private calculateExpandedLabelBottom(Landroid/graphics/Rect;Landroid/graphics/Rect;F)I
    .registers 5

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->isSingleLineFilledTextField()Z

    move-result v0

    if-eqz v0, :cond_c

    iget p1, p2, Landroid/graphics/Rect;->top:I

    int-to-float p1, p1

    add-float/2addr p1, p3

    float-to-int p1, p1

    return p1

    :cond_c
    iget p1, p1, Landroid/graphics/Rect;->bottom:I

    iget-object p2, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {p2}, Landroid/widget/EditText;->getCompoundPaddingBottom()I

    move-result p2

    sub-int/2addr p1, p2

    return p1
.end method

.method private calculateExpandedLabelTop(Landroid/graphics/Rect;F)I
    .registers 4

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->isSingleLineFilledTextField()Z

    move-result v0

    if-eqz v0, :cond_11

    invoke-virtual {p1}, Landroid/graphics/Rect;->centerY()I

    move-result p1

    int-to-float p1, p1

    const/high16 v0, 0x40000000    # 2.0f

    div-float/2addr p2, v0

    sub-float/2addr p1, p2

    float-to-int p1, p1

    return p1

    :cond_11
    iget p1, p1, Landroid/graphics/Rect;->top:I

    iget-object p2, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {p2}, Landroid/widget/EditText;->getCompoundPaddingTop()I

    move-result p2

    add-int/2addr p1, p2

    return p1
.end method

.method private calculateExpandedTextBounds(Landroid/graphics/Rect;)Landroid/graphics/Rect;
    .registers 6

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    if-eqz v0, :cond_2f

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->tmpBoundsRect:Landroid/graphics/Rect;

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    invoke-virtual {v1}, Lcom/google/android/material/internal/CollapsingTextHelper;->getExpandedTextHeight()F

    move-result v1

    iget v2, p1, Landroid/graphics/Rect;->left:I

    iget-object v3, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {v3}, Landroid/widget/EditText;->getCompoundPaddingLeft()I

    move-result v3

    add-int/2addr v2, v3

    iput v2, v0, Landroid/graphics/Rect;->left:I

    invoke-direct {p0, p1, v1}, Lcom/google/android/material/textfield/TextInputLayout;->calculateExpandedLabelTop(Landroid/graphics/Rect;F)I

    move-result v2

    iput v2, v0, Landroid/graphics/Rect;->top:I

    iget v2, p1, Landroid/graphics/Rect;->right:I

    iget-object v3, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {v3}, Landroid/widget/EditText;->getCompoundPaddingRight()I

    move-result v3

    sub-int/2addr v2, v3

    iput v2, v0, Landroid/graphics/Rect;->right:I

    invoke-direct {p0, p1, v0, v1}, Lcom/google/android/material/textfield/TextInputLayout;->calculateExpandedLabelBottom(Landroid/graphics/Rect;Landroid/graphics/Rect;F)I

    move-result p1

    iput p1, v0, Landroid/graphics/Rect;->bottom:I

    return-object v0

    :cond_2f
    new-instance p1, Ljava/lang/IllegalStateException;

    invoke-direct {p1}, Ljava/lang/IllegalStateException;-><init>()V

    throw p1
.end method

.method private calculateLabelMarginTop()I
    .registers 4

    iget-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->hintEnabled:Z

    const/4 v1, 0x0

    if-nez v0, :cond_6

    return v1

    :cond_6
    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundMode:I

    if-eqz v0, :cond_19

    const/4 v2, 0x2

    if-eq v0, v2, :cond_e

    return v1

    :cond_e
    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    invoke-virtual {v0}, Lcom/google/android/material/internal/CollapsingTextHelper;->getCollapsedTextHeight()F

    move-result v0

    const/high16 v1, 0x40000000    # 2.0f

    div-float/2addr v0, v1

    :goto_17
    float-to-int v0, v0

    return v0

    :cond_19
    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    invoke-virtual {v0}, Lcom/google/android/material/internal/CollapsingTextHelper;->getCollapsedTextHeight()F

    move-result v0

    goto :goto_17
.end method

.method private canDrawOutlineStroke()Z
    .registers 3

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundMode:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_d

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->canDrawStroke()Z

    move-result v0

    if-eqz v0, :cond_d

    const/4 v0, 0x1

    goto :goto_e

    :cond_d
    const/4 v0, 0x0

    :goto_e
    return v0
.end method

.method private canDrawStroke()Z
    .registers 3

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeWidthPx:I

    const/4 v1, -0x1

    if-le v0, v1, :cond_b

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeColor:I

    if-eqz v0, :cond_b

    const/4 v0, 0x1

    goto :goto_c

    :cond_b
    const/4 v0, 0x0

    :goto_c
    return v0
.end method

.method private closeCutout()V
    .registers 2

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->cutoutEnabled()Z

    move-result v0

    if-eqz v0, :cond_d

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackground:Lcom/google/android/material/shape/MaterialShapeDrawable;

    check-cast v0, Lcom/google/android/material/textfield/CutoutDrawable;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/CutoutDrawable;->removeCutout()V

    :cond_d
    return-void
.end method

.method private collapseHint(Z)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->animator:Landroid/animation/ValueAnimator;

    if-eqz v0, :cond_f

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->isRunning()Z

    move-result v0

    if-eqz v0, :cond_f

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->animator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->cancel()V

    :cond_f
    const/high16 v0, 0x3f800000    # 1.0f

    if-eqz p1, :cond_1b

    iget-boolean p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->hintAnimationEnabled:Z

    if-eqz p1, :cond_1b

    invoke-virtual {p0, v0}, Lcom/google/android/material/textfield/TextInputLayout;->animateToExpansionFraction(F)V

    goto :goto_20

    :cond_1b
    iget-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    invoke-virtual {p1, v0}, Lcom/google/android/material/internal/CollapsingTextHelper;->setExpansionFraction(F)V

    :goto_20
    const/4 p1, 0x0

    iput-boolean p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->hintExpanded:Z

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->cutoutEnabled()Z

    move-result v0

    if-eqz v0, :cond_2c

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->openCutout()V

    :cond_2c
    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->updatePlaceholderText()V

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/StartCompoundLayout;->onHintStateChanged(Z)V

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->onHintStateChanged(Z)V

    return-void
.end method

.method private createPlaceholderFadeTransition()Landroidx/transition/Fade;
    .registers 5

    new-instance v0, Landroidx/transition/Fade;

    invoke-direct {v0}, Landroidx/transition/Fade;-><init>()V

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getContext()Landroid/content/Context;

    move-result-object v1

    sget v2, Lcom/google/android/material/R$attr;->motionDurationShort2:I

    const/16 v3, 0x57

    invoke-static {v1, v2, v3}, Lcom/google/android/material/motion/MotionUtils;->resolveThemeDuration(Landroid/content/Context;II)I

    move-result v1

    int-to-long v1, v1

    invoke-virtual {v0, v1, v2}, Landroidx/transition/Fade;->setDuration(J)Landroidx/transition/Transition;

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getContext()Landroid/content/Context;

    move-result-object v1

    sget v2, Lcom/google/android/material/R$attr;->motionEasingLinearInterpolator:I

    sget-object v3, Lcom/google/android/material/animation/AnimationUtils;->LINEAR_INTERPOLATOR:Landroid/animation/TimeInterpolator;

    invoke-static {v1, v2, v3}, Lcom/google/android/material/motion/MotionUtils;->resolveThemeInterpolator(Landroid/content/Context;ILandroid/animation/TimeInterpolator;)Landroid/animation/TimeInterpolator;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroidx/transition/Fade;->setInterpolator(Landroid/animation/TimeInterpolator;)Landroidx/transition/Transition;

    return-object v0
.end method

.method private cutoutEnabled()Z
    .registers 2

    iget-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->hintEnabled:Z

    if-eqz v0, :cond_14

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->hint:Ljava/lang/CharSequence;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_14

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackground:Lcom/google/android/material/shape/MaterialShapeDrawable;

    instance-of v0, v0, Lcom/google/android/material/textfield/CutoutDrawable;

    if-eqz v0, :cond_14

    const/4 v0, 0x1

    goto :goto_15

    :cond_14
    const/4 v0, 0x0

    :goto_15
    return v0
.end method

.method private dispatchOnEditTextAttached()V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editTextAttachedListeners:Ljava/util/LinkedHashSet;

    invoke-virtual {v0}, Ljava/util/LinkedHashSet;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_6
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_16

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/material/textfield/TextInputLayout$OnEditTextAttachedListener;

    invoke-interface {v1, p0}, Lcom/google/android/material/textfield/TextInputLayout$OnEditTextAttachedListener;->onEditTextAttached(Lcom/google/android/material/textfield/TextInputLayout;)V

    goto :goto_6

    :cond_16
    return-void
.end method

.method private drawBoxUnderline(Landroid/graphics/Canvas;)V
    .registers 7

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxUnderlineFocused:Lcom/google/android/material/shape/MaterialShapeDrawable;

    if-eqz v0, :cond_3e

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxUnderlineDefault:Lcom/google/android/material/shape/MaterialShapeDrawable;

    if-eqz v0, :cond_3e

    invoke-virtual {v0, p1}, Lcom/google/android/material/shape/MaterialShapeDrawable;->draw(Landroid/graphics/Canvas;)V

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->isFocused()Z

    move-result v0

    if-eqz v0, :cond_3e

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxUnderlineFocused:Lcom/google/android/material/shape/MaterialShapeDrawable;

    invoke-virtual {v0}, Lcom/google/android/material/shape/MaterialShapeDrawable;->getBounds()Landroid/graphics/Rect;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxUnderlineDefault:Lcom/google/android/material/shape/MaterialShapeDrawable;

    invoke-virtual {v1}, Lcom/google/android/material/shape/MaterialShapeDrawable;->getBounds()Landroid/graphics/Rect;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    invoke-virtual {v2}, Lcom/google/android/material/internal/CollapsingTextHelper;->getExpansionFraction()F

    move-result v2

    invoke-virtual {v1}, Landroid/graphics/Rect;->centerX()I

    move-result v3

    iget v4, v1, Landroid/graphics/Rect;->left:I

    invoke-static {v3, v4, v2}, Lcom/google/android/material/animation/AnimationUtils;->lerp(IIF)I

    move-result v4

    iput v4, v0, Landroid/graphics/Rect;->left:I

    iget v1, v1, Landroid/graphics/Rect;->right:I

    invoke-static {v3, v1, v2}, Lcom/google/android/material/animation/AnimationUtils;->lerp(IIF)I

    move-result v1

    iput v1, v0, Landroid/graphics/Rect;->right:I

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxUnderlineFocused:Lcom/google/android/material/shape/MaterialShapeDrawable;

    invoke-virtual {v0, p1}, Lcom/google/android/material/shape/MaterialShapeDrawable;->draw(Landroid/graphics/Canvas;)V

    :cond_3e
    return-void
.end method

.method private drawHint(Landroid/graphics/Canvas;)V
    .registers 3

    iget-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->hintEnabled:Z

    if-eqz v0, :cond_9

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    invoke-virtual {v0, p1}, Lcom/google/android/material/internal/CollapsingTextHelper;->draw(Landroid/graphics/Canvas;)V

    :cond_9
    return-void
.end method

.method private expandHint(Z)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->animator:Landroid/animation/ValueAnimator;

    if-eqz v0, :cond_f

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->isRunning()Z

    move-result v0

    if-eqz v0, :cond_f

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->animator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->cancel()V

    :cond_f
    const/4 v0, 0x0

    if-eqz p1, :cond_1a

    iget-boolean p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->hintAnimationEnabled:Z

    if-eqz p1, :cond_1a

    invoke-virtual {p0, v0}, Lcom/google/android/material/textfield/TextInputLayout;->animateToExpansionFraction(F)V

    goto :goto_1f

    :cond_1a
    iget-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    invoke-virtual {p1, v0}, Lcom/google/android/material/internal/CollapsingTextHelper;->setExpansionFraction(F)V

    :goto_1f
    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->cutoutEnabled()Z

    move-result p1

    if-eqz p1, :cond_32

    iget-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackground:Lcom/google/android/material/shape/MaterialShapeDrawable;

    check-cast p1, Lcom/google/android/material/textfield/CutoutDrawable;

    invoke-virtual {p1}, Lcom/google/android/material/textfield/CutoutDrawable;->hasCutout()Z

    move-result p1

    if-eqz p1, :cond_32

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->closeCutout()V

    :cond_32
    const/4 p1, 0x1

    iput-boolean p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->hintExpanded:Z

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->hidePlaceholderText()V

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/StartCompoundLayout;->onHintStateChanged(Z)V

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->onHintStateChanged(Z)V

    return-void
.end method

.method private getDropDownMaterialShapeDrawable(Z)Lcom/google/android/material/shape/MaterialShapeDrawable;
    .registers 6

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/google/android/material/R$dimen;->mtrl_shape_corner_size_small_component:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v0

    int-to-float v0, v0

    if-eqz p1, :cond_f

    move p1, v0

    goto :goto_10

    :cond_f
    const/4 p1, 0x0

    :goto_10
    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    instance-of v2, v1, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;

    if-eqz v2, :cond_1d

    check-cast v1, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;

    invoke-virtual {v1}, Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;->getPopupElevation()F

    move-result v1

    goto :goto_28

    :cond_1d
    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/google/android/material/R$dimen;->m3_comp_outlined_autocomplete_menu_container_elevation:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v1

    int-to-float v1, v1

    :goto_28
    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/google/android/material/R$dimen;->mtrl_exposed_dropdown_menu_popup_vertical_padding:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v2

    invoke-static {}, Lcom/google/android/material/shape/ShapeAppearanceModel;->builder()Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    move-result-object v3

    invoke-virtual {v3, p1}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->setTopLeftCornerSize(F)Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    move-result-object v3

    invoke-virtual {v3, p1}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->setTopRightCornerSize(F)Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    move-result-object p1

    invoke-virtual {p1, v0}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->setBottomLeftCornerSize(F)Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    move-result-object p1

    invoke-virtual {p1, v0}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->setBottomRightCornerSize(F)Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    move-result-object p1

    invoke-virtual {p1}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->build()Lcom/google/android/material/shape/ShapeAppearanceModel;

    move-result-object p1

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, v1}, Lcom/google/android/material/shape/MaterialShapeDrawable;->createWithElevationOverlay(Landroid/content/Context;F)Lcom/google/android/material/shape/MaterialShapeDrawable;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/google/android/material/shape/MaterialShapeDrawable;->setShapeAppearanceModel(Lcom/google/android/material/shape/ShapeAppearanceModel;)V

    const/4 p1, 0x0

    invoke-virtual {v0, p1, v2, p1, v2}, Lcom/google/android/material/shape/MaterialShapeDrawable;->setPadding(IIII)V

    return-object v0
.end method

.method private getEditTextBoxBackground()Landroid/graphics/drawable/Drawable;
    .registers 5

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    instance-of v1, v0, Landroid/widget/AutoCompleteTextView;

    if-eqz v1, :cond_37

    invoke-static {v0}, Lcom/google/android/material/textfield/EditTextUtils;->isEditable(Landroid/widget/EditText;)Z

    move-result v0

    if-eqz v0, :cond_d

    goto :goto_37

    :cond_d
    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    sget v1, Lcom/google/android/material/R$attr;->colorControlHighlight:I

    invoke-static {v0, v1}, Lcom/google/android/material/color/MaterialColors;->getColor(Landroid/view/View;I)I

    move-result v0

    iget v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundMode:I

    const/4 v2, 0x2

    if-ne v1, v2, :cond_27

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackground:Lcom/google/android/material/shape/MaterialShapeDrawable;

    sget-object v3, Lcom/google/android/material/textfield/TextInputLayout;->EDIT_TEXT_BACKGROUND_RIPPLE_STATE:[[I

    invoke-static {v1, v2, v0, v3}, Lcom/google/android/material/textfield/TextInputLayout;->getOutlinedBoxBackgroundWithRipple(Landroid/content/Context;Lcom/google/android/material/shape/MaterialShapeDrawable;I[[I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0

    :cond_27
    const/4 v2, 0x1

    if-ne v1, v2, :cond_35

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackground:Lcom/google/android/material/shape/MaterialShapeDrawable;

    iget v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundColor:I

    sget-object v3, Lcom/google/android/material/textfield/TextInputLayout;->EDIT_TEXT_BACKGROUND_RIPPLE_STATE:[[I

    invoke-static {v1, v2, v0, v3}, Lcom/google/android/material/textfield/TextInputLayout;->getFilledBoxBackgroundWithRipple(Lcom/google/android/material/shape/MaterialShapeDrawable;II[[I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0

    :cond_35
    const/4 v0, 0x0

    return-object v0

    :cond_37
    :goto_37
    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackground:Lcom/google/android/material/shape/MaterialShapeDrawable;

    return-object v0
.end method

.method private static getFilledBoxBackgroundWithRipple(Lcom/google/android/material/shape/MaterialShapeDrawable;II[[I)Landroid/graphics/drawable/Drawable;
    .registers 6

    const v0, 0x3dcccccd    # 0.1f

    invoke-static {p2, p1, v0}, Lcom/google/android/material/color/MaterialColors;->layer(IIF)I

    move-result p2

    const/4 v0, 0x2

    new-array v0, v0, [I

    const/4 v1, 0x0

    aput p2, v0, v1

    const/4 p2, 0x1

    aput p1, v0, p2

    new-instance p1, Landroid/content/res/ColorStateList;

    invoke-direct {p1, p3, v0}, Landroid/content/res/ColorStateList;-><init>([[I[I)V

    new-instance p2, Landroid/graphics/drawable/RippleDrawable;

    invoke-direct {p2, p1, p0, p0}, Landroid/graphics/drawable/RippleDrawable;-><init>(Landroid/content/res/ColorStateList;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    return-object p2
.end method

.method private getLabelLeftBoundAlightWithPrefix(IZ)I
    .registers 4

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getCompoundPaddingLeft()I

    move-result v0

    add-int/2addr p1, v0

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getPrefixText()Ljava/lang/CharSequence;

    move-result-object v0

    if-eqz v0, :cond_21

    if-nez p2, :cond_21

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getPrefixTextView()Landroid/widget/TextView;

    move-result-object p2

    invoke-virtual {p2}, Landroid/widget/TextView;->getMeasuredWidth()I

    move-result p2

    sub-int/2addr p1, p2

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getPrefixTextView()Landroid/widget/TextView;

    move-result-object p2

    invoke-virtual {p2}, Landroid/widget/TextView;->getPaddingLeft()I

    move-result p2

    add-int/2addr p1, p2

    :cond_21
    return p1
.end method

.method private getLabelRightBoundAlignedWithSuffix(IZ)I
    .registers 4

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getCompoundPaddingRight()I

    move-result v0

    sub-int/2addr p1, v0

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getPrefixText()Ljava/lang/CharSequence;

    move-result-object v0

    if-eqz v0, :cond_21

    if-eqz p2, :cond_21

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getPrefixTextView()Landroid/widget/TextView;

    move-result-object p2

    invoke-virtual {p2}, Landroid/widget/TextView;->getMeasuredWidth()I

    move-result p2

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getPrefixTextView()Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/TextView;->getPaddingRight()I

    move-result v0

    sub-int/2addr p2, v0

    add-int/2addr p1, p2

    :cond_21
    return p1
.end method

.method private getOrCreateFilledDropDownMenuBackground()Landroid/graphics/drawable/Drawable;
    .registers 5

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->filledDropDownMenuBackground:Landroid/graphics/drawable/StateListDrawable;

    if-nez v0, :cond_26

    new-instance v0, Landroid/graphics/drawable/StateListDrawable;

    invoke-direct {v0}, Landroid/graphics/drawable/StateListDrawable;-><init>()V

    iput-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->filledDropDownMenuBackground:Landroid/graphics/drawable/StateListDrawable;

    const/4 v1, 0x1

    new-array v1, v1, [I

    const v2, 0x10100aa

    const/4 v3, 0x0

    aput v2, v1, v3

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getOrCreateOutlinedDropDownMenuBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/graphics/drawable/StateListDrawable;->addState([ILandroid/graphics/drawable/Drawable;)V

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->filledDropDownMenuBackground:Landroid/graphics/drawable/StateListDrawable;

    new-array v1, v3, [I

    invoke-direct {p0, v3}, Lcom/google/android/material/textfield/TextInputLayout;->getDropDownMaterialShapeDrawable(Z)Lcom/google/android/material/shape/MaterialShapeDrawable;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/graphics/drawable/StateListDrawable;->addState([ILandroid/graphics/drawable/Drawable;)V

    :cond_26
    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->filledDropDownMenuBackground:Landroid/graphics/drawable/StateListDrawable;

    return-object v0
.end method

.method private getOrCreateOutlinedDropDownMenuBackground()Landroid/graphics/drawable/Drawable;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->outlinedDropDownMenuBackground:Lcom/google/android/material/shape/MaterialShapeDrawable;

    if-nez v0, :cond_b

    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/google/android/material/textfield/TextInputLayout;->getDropDownMaterialShapeDrawable(Z)Lcom/google/android/material/shape/MaterialShapeDrawable;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->outlinedDropDownMenuBackground:Lcom/google/android/material/shape/MaterialShapeDrawable;

    :cond_b
    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->outlinedDropDownMenuBackground:Lcom/google/android/material/shape/MaterialShapeDrawable;

    return-object v0
.end method

.method private static getOutlinedBoxBackgroundWithRipple(Landroid/content/Context;Lcom/google/android/material/shape/MaterialShapeDrawable;I[[I)Landroid/graphics/drawable/Drawable;
    .registers 10

    sget v0, Lcom/google/android/material/R$attr;->colorSurface:I

    const-string v1, "TextInputLayout"

    invoke-static {p0, v0, v1}, Lcom/google/android/material/color/MaterialColors;->getColor(Landroid/content/Context;ILjava/lang/String;)I

    move-result p0

    new-instance v0, Lcom/google/android/material/shape/MaterialShapeDrawable;

    invoke-virtual {p1}, Lcom/google/android/material/shape/MaterialShapeDrawable;->getShapeAppearanceModel()Lcom/google/android/material/shape/ShapeAppearanceModel;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/google/android/material/shape/MaterialShapeDrawable;-><init>(Lcom/google/android/material/shape/ShapeAppearanceModel;)V

    const v1, 0x3dcccccd    # 0.1f

    invoke-static {p2, p0, v1}, Lcom/google/android/material/color/MaterialColors;->layer(IIF)I

    move-result p2

    const/4 v1, 0x2

    new-array v2, v1, [I

    const/4 v3, 0x0

    aput p2, v2, v3

    const/4 v4, 0x1

    aput v3, v2, v4

    new-instance v5, Landroid/content/res/ColorStateList;

    invoke-direct {v5, p3, v2}, Landroid/content/res/ColorStateList;-><init>([[I[I)V

    invoke-virtual {v0, v5}, Lcom/google/android/material/shape/MaterialShapeDrawable;->setFillColor(Landroid/content/res/ColorStateList;)V

    invoke-virtual {v0, p0}, Lcom/google/android/material/shape/MaterialShapeDrawable;->setTint(I)V

    new-array v2, v1, [I

    aput p2, v2, v3

    aput p0, v2, v4

    new-instance p0, Landroid/content/res/ColorStateList;

    invoke-direct {p0, p3, v2}, Landroid/content/res/ColorStateList;-><init>([[I[I)V

    new-instance p2, Lcom/google/android/material/shape/MaterialShapeDrawable;

    invoke-virtual {p1}, Lcom/google/android/material/shape/MaterialShapeDrawable;->getShapeAppearanceModel()Lcom/google/android/material/shape/ShapeAppearanceModel;

    move-result-object p3

    invoke-direct {p2, p3}, Lcom/google/android/material/shape/MaterialShapeDrawable;-><init>(Lcom/google/android/material/shape/ShapeAppearanceModel;)V

    const/4 p3, -0x1

    invoke-virtual {p2, p3}, Lcom/google/android/material/shape/MaterialShapeDrawable;->setTint(I)V

    new-instance p3, Landroid/graphics/drawable/RippleDrawable;

    invoke-direct {p3, p0, v0, p2}, Landroid/graphics/drawable/RippleDrawable;-><init>(Landroid/content/res/ColorStateList;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    new-array p0, v1, [Landroid/graphics/drawable/Drawable;

    aput-object p3, p0, v3

    aput-object p1, p0, v4

    new-instance p1, Landroid/graphics/drawable/LayerDrawable;

    invoke-direct {p1, p0}, Landroid/graphics/drawable/LayerDrawable;-><init>([Landroid/graphics/drawable/Drawable;)V

    return-object p1
.end method

.method private hidePlaceholderText()V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderTextView:Landroid/widget/TextView;

    if-eqz v0, :cond_19

    iget-boolean v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderEnabled:Z

    if-eqz v1, :cond_19

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->inputFrame:Landroid/widget/FrameLayout;

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderFadeOut:Landroidx/transition/Fade;

    invoke-static {v0, v1}, Landroidx/transition/TransitionManager;->beginDelayedTransition(Landroid/view/ViewGroup;Landroidx/transition/Transition;)V

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderTextView:Landroid/widget/TextView;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    :cond_19
    return-void
.end method

.method private isSingleLineFilledTextField()Z
    .registers 3

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundMode:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_e

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getMinLines()I

    move-result v0

    if-gt v0, v1, :cond_e

    goto :goto_f

    :cond_e
    const/4 v1, 0x0

    :goto_f
    return v1
.end method

.method static synthetic lambda$new$0(Landroid/text/Editable;)I
    .registers 1

    if-eqz p0, :cond_7

    invoke-interface {p0}, Landroid/text/Editable;->length()I

    move-result p0

    goto :goto_8

    :cond_7
    const/4 p0, 0x0

    :goto_8
    return p0
.end method

.method private onApplyBoxBackgroundMode()V
    .registers 2

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->assignBoxBackgroundByMode()V

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->updateEditTextBoxBackgroundIfNeeded()V

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->updateTextInputBoxState()V

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->updateBoxCollapsedPaddingTop()V

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->adjustFilledEditTextPaddingForLargeFont()V

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundMode:I

    if-eqz v0, :cond_16

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->updateInputLayoutMargins()V

    :cond_16
    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->setDropDownMenuBackgroundIfNeeded()V

    return-void
.end method

.method private openCutout()V
    .registers 6

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->cutoutEnabled()Z

    move-result v0

    if-nez v0, :cond_7

    return-void

    :cond_7
    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->tmpRectF:Landroid/graphics/RectF;

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    iget-object v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getWidth()I

    move-result v2

    iget-object v3, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {v3}, Landroid/widget/EditText;->getGravity()I

    move-result v3

    invoke-virtual {v1, v0, v2, v3}, Lcom/google/android/material/internal/CollapsingTextHelper;->getCollapsedTextActualBounds(Landroid/graphics/RectF;II)V

    invoke-virtual {v0}, Landroid/graphics/RectF;->width()F

    move-result v1

    const/4 v2, 0x0

    cmpg-float v1, v1, v2

    if-lez v1, :cond_51

    invoke-virtual {v0}, Landroid/graphics/RectF;->height()F

    move-result v1

    cmpg-float v1, v1, v2

    if-gtz v1, :cond_2c

    goto :goto_51

    :cond_2c
    invoke-direct {p0, v0}, Lcom/google/android/material/textfield/TextInputLayout;->applyCutoutPadding(Landroid/graphics/RectF;)V

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getPaddingLeft()I

    move-result v1

    neg-int v1, v1

    int-to-float v1, v1

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getPaddingTop()I

    move-result v2

    neg-int v2, v2

    int-to-float v2, v2

    invoke-virtual {v0}, Landroid/graphics/RectF;->height()F

    move-result v3

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v3, v4

    sub-float/2addr v2, v3

    iget v3, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeWidthPx:I

    int-to-float v3, v3

    add-float/2addr v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/graphics/RectF;->offset(FF)V

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackground:Lcom/google/android/material/shape/MaterialShapeDrawable;

    check-cast v1, Lcom/google/android/material/textfield/CutoutDrawable;

    invoke-virtual {v1, v0}, Lcom/google/android/material/textfield/CutoutDrawable;->setCutout(Landroid/graphics/RectF;)V

    :cond_51
    :goto_51
    return-void
.end method

.method private recalculateCutout()V
    .registers 2

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->cutoutEnabled()Z

    move-result v0

    if-eqz v0, :cond_10

    iget-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->hintExpanded:Z

    if-nez v0, :cond_10

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->closeCutout()V

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->openCutout()V

    :cond_10
    return-void
.end method

.method private static recursiveSetEnabled(Landroid/view/ViewGroup;Z)V
    .registers 6

    invoke-virtual {p0}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v0

    const/4 v1, 0x0

    :goto_5
    if-ge v1, v0, :cond_1a

    invoke-virtual {p0, v1}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2, p1}, Landroid/view/View;->setEnabled(Z)V

    instance-of v3, v2, Landroid/view/ViewGroup;

    if-eqz v3, :cond_17

    check-cast v2, Landroid/view/ViewGroup;

    invoke-static {v2, p1}, Lcom/google/android/material/textfield/TextInputLayout;->recursiveSetEnabled(Landroid/view/ViewGroup;Z)V

    :cond_17
    add-int/lit8 v1, v1, 0x1

    goto :goto_5

    :cond_1a
    return-void
.end method

.method private removePlaceholderTextView()V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderTextView:Landroid/widget/TextView;

    if-eqz v0, :cond_9

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    :cond_9
    return-void
.end method

.method private setDropDownMenuBackgroundIfNeeded()V
    .registers 4

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    instance-of v1, v0, Landroid/widget/AutoCompleteTextView;

    if-nez v1, :cond_7

    return-void

    :cond_7
    check-cast v0, Landroid/widget/AutoCompleteTextView;

    invoke-virtual {v0}, Landroid/widget/AutoCompleteTextView;->getDropDownBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    if-nez v1, :cond_26

    iget v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundMode:I

    const/4 v2, 0x2

    if-ne v1, v2, :cond_1c

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getOrCreateOutlinedDropDownMenuBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/AutoCompleteTextView;->setDropDownBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_26

    :cond_1c
    const/4 v2, 0x1

    if-ne v1, v2, :cond_26

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getOrCreateFilledDropDownMenuBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/AutoCompleteTextView;->setDropDownBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    :cond_26
    :goto_26
    return-void
.end method

.method private setEditText(Landroid/widget/EditText;)V
    .registers 6

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    if-nez v0, :cond_e0

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getEndIconMode()I

    move-result v0

    const/4 v1, 0x3

    if-eq v0, v1, :cond_16

    instance-of v0, p1, Lcom/google/android/material/textfield/TextInputEditText;

    if-nez v0, :cond_16

    const-string v0, "TextInputLayout"

    const-string v1, "EditText added is not a TextInputEditText. Please switch to using that class instead."

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    :cond_16
    iput-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->minEms:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_21

    invoke-virtual {p0, v0}, Lcom/google/android/material/textfield/TextInputLayout;->setMinEms(I)V

    goto :goto_26

    :cond_21
    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->minWidth:I

    invoke-virtual {p0, v0}, Lcom/google/android/material/textfield/TextInputLayout;->setMinWidth(I)V

    :goto_26
    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->maxEms:I

    if-eq v0, v1, :cond_2e

    invoke-virtual {p0, v0}, Lcom/google/android/material/textfield/TextInputLayout;->setMaxEms(I)V

    goto :goto_33

    :cond_2e
    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->maxWidth:I

    invoke-virtual {p0, v0}, Lcom/google/android/material/textfield/TextInputLayout;->setMaxWidth(I)V

    :goto_33
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundApplied:Z

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->onApplyBoxBackgroundMode()V

    new-instance v1, Lcom/google/android/material/textfield/TextInputLayout$AccessibilityDelegate;

    invoke-direct {v1, p0}, Lcom/google/android/material/textfield/TextInputLayout$AccessibilityDelegate;-><init>(Lcom/google/android/material/textfield/TextInputLayout;)V

    invoke-virtual {p0, v1}, Lcom/google/android/material/textfield/TextInputLayout;->setTextInputAccessibilityDelegate(Lcom/google/android/material/textfield/TextInputLayout$AccessibilityDelegate;)V

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    iget-object v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getTypeface()Landroid/graphics/Typeface;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/google/android/material/internal/CollapsingTextHelper;->setTypefaces(Landroid/graphics/Typeface;)V

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    iget-object v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getTextSize()F

    move-result v2

    invoke-virtual {v1, v2}, Lcom/google/android/material/internal/CollapsingTextHelper;->setExpandedTextSize(F)V

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    iget-object v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getLetterSpacing()F

    move-result v2

    invoke-virtual {v1, v2}, Lcom/google/android/material/internal/CollapsingTextHelper;->setExpandedLetterSpacing(F)V

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getGravity()I

    move-result v1

    iget-object v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    and-int/lit8 v3, v1, -0x71

    or-int/lit8 v3, v3, 0x30

    invoke-virtual {v2, v3}, Lcom/google/android/material/internal/CollapsingTextHelper;->setCollapsedTextGravity(I)V

    iget-object v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    invoke-virtual {v2, v1}, Lcom/google/android/material/internal/CollapsingTextHelper;->setExpandedTextGravity(I)V

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    new-instance v2, Lcom/google/android/material/textfield/TextInputLayout$1;

    invoke-direct {v2, p0}, Lcom/google/android/material/textfield/TextInputLayout$1;-><init>(Lcom/google/android/material/textfield/TextInputLayout;)V

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->defaultHintTextColor:Landroid/content/res/ColorStateList;

    if-nez v1, :cond_8c

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getHintTextColors()Landroid/content/res/ColorStateList;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->defaultHintTextColor:Landroid/content/res/ColorStateList;

    :cond_8c
    iget-boolean v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->hintEnabled:Z

    const/4 v2, 0x1

    if-eqz v1, :cond_ac

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->hint:Ljava/lang/CharSequence;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_aa

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getHint()Ljava/lang/CharSequence;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->originalHint:Ljava/lang/CharSequence;

    invoke-virtual {p0, v1}, Lcom/google/android/material/textfield/TextInputLayout;->setHint(Ljava/lang/CharSequence;)V

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    const/4 v3, 0x0

    invoke-virtual {v1, v3}, Landroid/widget/EditText;->setHint(Ljava/lang/CharSequence;)V

    :cond_aa
    iput-boolean v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->isProvidingHint:Z

    :cond_ac
    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterView:Landroid/widget/TextView;

    if-eqz v1, :cond_b9

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/google/android/material/textfield/TextInputLayout;->updateCounter(Landroid/text/Editable;)V

    :cond_b9
    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->updateEditTextBackground()V

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

    invoke-virtual {v1}, Lcom/google/android/material/textfield/IndicatorViewController;->adjustIndicatorPadding()V

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

    invoke-virtual {v1}, Lcom/google/android/material/textfield/StartCompoundLayout;->bringToFront()V

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v1}, Lcom/google/android/material/textfield/EndCompoundLayout;->bringToFront()V

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->dispatchOnEditTextAttached()V

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v1}, Lcom/google/android/material/textfield/EndCompoundLayout;->updateSuffixTextViewPadding()V

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->isEnabled()Z

    move-result v1

    if-nez v1, :cond_dc

    invoke-virtual {p1, v0}, Landroid/widget/EditText;->setEnabled(Z)V

    :cond_dc
    invoke-direct {p0, v0, v2}, Lcom/google/android/material/textfield/TextInputLayout;->updateLabelState(ZZ)V

    return-void

    :cond_e0
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string v0, "We already have an EditText, can only have one"

    invoke-direct {p1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private setHintInternal(Ljava/lang/CharSequence;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->hint:Ljava/lang/CharSequence;

    invoke-static {p1, v0}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_16

    iput-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->hint:Ljava/lang/CharSequence;

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    invoke-virtual {v0, p1}, Lcom/google/android/material/internal/CollapsingTextHelper;->setText(Ljava/lang/CharSequence;)V

    iget-boolean p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->hintExpanded:Z

    if-nez p1, :cond_16

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->openCutout()V

    :cond_16
    return-void
.end method

.method private setPlaceholderTextEnabled(Z)V
    .registers 3

    iget-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderEnabled:Z

    if-ne v0, p1, :cond_5

    return-void

    :cond_5
    if-eqz p1, :cond_b

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->addPlaceholderTextView()V

    goto :goto_11

    :cond_b
    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->removePlaceholderTextView()V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderTextView:Landroid/widget/TextView;

    :goto_11
    iput-boolean p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderEnabled:Z

    return-void
.end method

.method private shouldUpdateEndDummyDrawable()Z
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/EndCompoundLayout;->isErrorIconVisible()Z

    move-result v0

    if-nez v0, :cond_1e

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/EndCompoundLayout;->hasEndIcon()Z

    move-result v0

    if-eqz v0, :cond_16

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->isEndIconVisible()Z

    move-result v0

    if-nez v0, :cond_1e

    :cond_16
    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/EndCompoundLayout;->getSuffixText()Ljava/lang/CharSequence;

    move-result-object v0

    if-eqz v0, :cond_28

    :cond_1e
    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/EndCompoundLayout;->getMeasuredWidth()I

    move-result v0

    if-lez v0, :cond_28

    const/4 v0, 0x1

    goto :goto_29

    :cond_28
    const/4 v0, 0x0

    :goto_29
    return v0
.end method

.method private shouldUpdateStartDummyDrawable()Z
    .registers 2

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getStartIconDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    if-nez v0, :cond_16

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getPrefixText()Ljava/lang/CharSequence;

    move-result-object v0

    if-eqz v0, :cond_20

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getPrefixTextView()Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/TextView;->getVisibility()I

    move-result v0

    if-nez v0, :cond_20

    :cond_16
    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/StartCompoundLayout;->getMeasuredWidth()I

    move-result v0

    if-lez v0, :cond_20

    const/4 v0, 0x1

    goto :goto_21

    :cond_20
    const/4 v0, 0x0

    :goto_21
    return v0
.end method

.method private showPlaceholderText()V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderTextView:Landroid/widget/TextView;

    if-eqz v0, :cond_2e

    iget-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderEnabled:Z

    if-eqz v0, :cond_2e

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderText:Ljava/lang/CharSequence;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2e

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderTextView:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderText:Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->inputFrame:Landroid/widget/FrameLayout;

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderFadeIn:Landroidx/transition/Fade;

    invoke-static {v0, v1}, Landroidx/transition/TransitionManager;->beginDelayedTransition(Landroid/view/ViewGroup;Landroidx/transition/Transition;)V

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderTextView:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderTextView:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->bringToFront()V

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderText:Ljava/lang/CharSequence;

    invoke-virtual {p0, v0}, Lcom/google/android/material/textfield/TextInputLayout;->announceForAccessibility(Ljava/lang/CharSequence;)V

    :cond_2e
    return-void
.end method

.method private updateBoxCollapsedPaddingTop()V
    .registers 3

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundMode:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_32

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/material/resources/MaterialResources;->isFontScaleAtLeast2_0(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_1c

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/google/android/material/R$dimen;->material_font_2_0_box_collapsed_padding_top:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iput v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxCollapsedPaddingTopPx:I

    goto :goto_32

    :cond_1c
    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/material/resources/MaterialResources;->isFontScaleAtLeast1_3(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_32

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/google/android/material/R$dimen;->material_font_1_3_box_collapsed_padding_top:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iput v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxCollapsedPaddingTopPx:I

    :cond_32
    :goto_32
    return-void
.end method

.method private updateBoxUnderlineBounds(Landroid/graphics/Rect;)V
    .registers 7

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxUnderlineDefault:Lcom/google/android/material/shape/MaterialShapeDrawable;

    if-eqz v0, :cond_14

    iget v0, p1, Landroid/graphics/Rect;->bottom:I

    iget v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeWidthDefaultPx:I

    sub-int/2addr v0, v1

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxUnderlineDefault:Lcom/google/android/material/shape/MaterialShapeDrawable;

    iget v2, p1, Landroid/graphics/Rect;->left:I

    iget v3, p1, Landroid/graphics/Rect;->right:I

    iget v4, p1, Landroid/graphics/Rect;->bottom:I

    invoke-virtual {v1, v2, v0, v3, v4}, Lcom/google/android/material/shape/MaterialShapeDrawable;->setBounds(IIII)V

    :cond_14
    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxUnderlineFocused:Lcom/google/android/material/shape/MaterialShapeDrawable;

    if-eqz v0, :cond_28

    iget v0, p1, Landroid/graphics/Rect;->bottom:I

    iget v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeWidthFocusedPx:I

    sub-int/2addr v0, v1

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxUnderlineFocused:Lcom/google/android/material/shape/MaterialShapeDrawable;

    iget v2, p1, Landroid/graphics/Rect;->left:I

    iget v3, p1, Landroid/graphics/Rect;->right:I

    iget p1, p1, Landroid/graphics/Rect;->bottom:I

    invoke-virtual {v1, v2, v0, v3, p1}, Lcom/google/android/material/shape/MaterialShapeDrawable;->setBounds(IIII)V

    :cond_28
    return-void
.end method

.method private updateCounter()V
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterView:Landroid/widget/TextView;

    if-eqz v0, :cond_11

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    if-nez v0, :cond_a

    const/4 v0, 0x0

    goto :goto_e

    :cond_a
    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    :goto_e
    invoke-virtual {p0, v0}, Lcom/google/android/material/textfield/TextInputLayout;->updateCounter(Landroid/text/Editable;)V

    :cond_11
    return-void
.end method

.method private static updateCounterContentDescription(Landroid/content/Context;Landroid/widget/TextView;IIZ)V
    .registers 7

    if-eqz p4, :cond_5

    sget p4, Lcom/google/android/material/R$string;->character_counter_overflowed_content_description:I

    goto :goto_7

    :cond_5
    sget p4, Lcom/google/android/material/R$string;->character_counter_content_description:I

    :goto_7
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    aput-object p2, v0, v1

    const/4 p2, 0x1

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p3

    aput-object p3, v0, p2

    invoke-virtual {p0, p4, v0}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    invoke-virtual {p1, p0}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    return-void
.end method

.method private updateCounterTextAppearanceAndColor()V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterView:Landroid/widget/TextView;

    if-eqz v0, :cond_2a

    iget-boolean v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterOverflowed:Z

    if-eqz v1, :cond_b

    iget v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterOverflowTextAppearance:I

    goto :goto_d

    :cond_b
    iget v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterTextAppearance:I

    :goto_d
    invoke-virtual {p0, v0, v1}, Lcom/google/android/material/textfield/TextInputLayout;->setTextAppearanceCompatWithErrorFallback(Landroid/widget/TextView;I)V

    iget-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterOverflowed:Z

    if-nez v0, :cond_1d

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterTextColor:Landroid/content/res/ColorStateList;

    if-eqz v0, :cond_1d

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterView:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setTextColor(Landroid/content/res/ColorStateList;)V

    :cond_1d
    iget-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterOverflowed:Z

    if-eqz v0, :cond_2a

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterOverflowTextColor:Landroid/content/res/ColorStateList;

    if-eqz v0, :cond_2a

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterView:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setTextColor(Landroid/content/res/ColorStateList;)V

    :cond_2a
    return-void
.end method

.method private updateCursorColor(Z)V
    .registers 4

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getContext()Landroid/content/Context;

    move-result-object v0

    sget v1, Lcom/google/android/material/R$attr;->colorControlActivated:I

    invoke-static {v0, v1}, Lcom/google/android/material/color/MaterialColors;->getColorStateListOrNull(Landroid/content/Context;I)Landroid/content/res/ColorStateList;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    if-eqz v1, :cond_2e

    invoke-virtual {v1}, Landroid/widget/EditText;->getTextCursorDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    if-eqz v1, :cond_2e

    if-nez v0, :cond_17

    goto :goto_2e

    :cond_17
    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getTextCursorDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    if-eqz p1, :cond_2b

    iget-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->strokeErrorColor:Landroid/content/res/ColorStateList;

    if-eqz p1, :cond_24

    goto :goto_2a

    :cond_24
    iget p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeColor:I

    invoke-static {p1}, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;

    move-result-object p1

    :goto_2a
    move-object v0, p1

    :cond_2b
    invoke-static {v1, v0}, Landroidx/core/graphics/drawable/DrawableCompat;->setTintList(Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;)V

    :cond_2e
    :goto_2e
    return-void
.end method

.method private updateEditTextHeightBasedOnIcon()Z
    .registers 4

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    const/4 v1, 0x0

    if-nez v0, :cond_6

    return v1

    :cond_6
    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/EndCompoundLayout;->getMeasuredHeight()I

    move-result v0

    iget-object v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

    invoke-virtual {v2}, Lcom/google/android/material/textfield/StartCompoundLayout;->getMeasuredHeight()I

    move-result v2

    invoke-static {v0, v2}, Ljava/lang/Math;->max(II)I

    move-result v0

    iget-object v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getMeasuredHeight()I

    move-result v2

    if-ge v2, v0, :cond_25

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {v1, v0}, Landroid/widget/EditText;->setMinimumHeight(I)V

    const/4 v0, 0x1

    return v0

    :cond_25
    return v1
.end method

.method private updateInputLayoutMargins()V
    .registers 4

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundMode:I

    const/4 v1, 0x1

    if-eq v0, v1, :cond_1c

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->inputFrame:Landroid/widget/FrameLayout;

    invoke-virtual {v0}, Landroid/widget/FrameLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->calculateLabelMarginTop()I

    move-result v1

    iget v2, v0, Landroid/widget/LinearLayout$LayoutParams;->topMargin:I

    if-eq v1, v2, :cond_1c

    iput v1, v0, Landroid/widget/LinearLayout$LayoutParams;->topMargin:I

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->inputFrame:Landroid/widget/FrameLayout;

    invoke-virtual {v0}, Landroid/widget/FrameLayout;->requestLayout()V

    :cond_1c
    return-void
.end method

.method private updateLabelState(ZZ)V
    .registers 10

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->isEnabled()Z

    move-result v0

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    const/4 v2, 0x1

    const/4 v3, 0x0

    if-eqz v1, :cond_16

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_16

    move v1, v2

    goto :goto_17

    :cond_16
    move v1, v3

    :goto_17
    iget-object v4, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    if-eqz v4, :cond_23

    invoke-virtual {v4}, Landroid/widget/EditText;->hasFocus()Z

    move-result v4

    if-eqz v4, :cond_23

    move v4, v2

    goto :goto_24

    :cond_23
    move v4, v3

    :goto_24
    iget-object v5, p0, Lcom/google/android/material/textfield/TextInputLayout;->defaultHintTextColor:Landroid/content/res/ColorStateList;

    if-eqz v5, :cond_2d

    iget-object v6, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    invoke-virtual {v6, v5}, Lcom/google/android/material/internal/CollapsingTextHelper;->setCollapsedAndExpandedTextColor(Landroid/content/res/ColorStateList;)V

    :cond_2d
    if-nez v0, :cond_4d

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->defaultHintTextColor:Landroid/content/res/ColorStateList;

    if-eqz v0, :cond_41

    new-array v2, v2, [I

    const v5, -0x101009e

    aput v5, v2, v3

    iget v3, p0, Lcom/google/android/material/textfield/TextInputLayout;->disabledColor:I

    invoke-virtual {v0, v2, v3}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    move-result v0

    goto :goto_43

    :cond_41
    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->disabledColor:I

    :goto_43
    iget-object v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    invoke-static {v0}, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/google/android/material/internal/CollapsingTextHelper;->setCollapsedAndExpandedTextColor(Landroid/content/res/ColorStateList;)V

    goto :goto_7c

    :cond_4d
    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->shouldShowError()Z

    move-result v0

    if-eqz v0, :cond_5f

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    iget-object v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

    invoke-virtual {v2}, Lcom/google/android/material/textfield/IndicatorViewController;->getErrorViewTextColors()Landroid/content/res/ColorStateList;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/google/android/material/internal/CollapsingTextHelper;->setCollapsedAndExpandedTextColor(Landroid/content/res/ColorStateList;)V

    goto :goto_7c

    :cond_5f
    iget-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterOverflowed:Z

    if-eqz v0, :cond_71

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterView:Landroid/widget/TextView;

    if-eqz v0, :cond_71

    iget-object v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    invoke-virtual {v0}, Landroid/widget/TextView;->getTextColors()Landroid/content/res/ColorStateList;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/google/android/material/internal/CollapsingTextHelper;->setCollapsedAndExpandedTextColor(Landroid/content/res/ColorStateList;)V

    goto :goto_7c

    :cond_71
    if-eqz v4, :cond_7c

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->focusedTextColor:Landroid/content/res/ColorStateList;

    if-eqz v0, :cond_7c

    iget-object v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    invoke-virtual {v2, v0}, Lcom/google/android/material/internal/CollapsingTextHelper;->setCollapsedTextColor(Landroid/content/res/ColorStateList;)V

    :cond_7c
    :goto_7c
    if-nez v1, :cond_95

    iget-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->expandedHintEnabled:Z

    if-eqz v0, :cond_95

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_8b

    if-eqz v4, :cond_8b

    goto :goto_95

    :cond_8b
    if-nez p2, :cond_91

    iget-boolean p2, p0, Lcom/google/android/material/textfield/TextInputLayout;->hintExpanded:Z

    if-nez p2, :cond_9e

    :cond_91
    invoke-direct {p0, p1}, Lcom/google/android/material/textfield/TextInputLayout;->expandHint(Z)V

    goto :goto_9e

    :cond_95
    :goto_95
    if-nez p2, :cond_9b

    iget-boolean p2, p0, Lcom/google/android/material/textfield/TextInputLayout;->hintExpanded:Z

    if-eqz p2, :cond_9e

    :cond_9b
    invoke-direct {p0, p1}, Lcom/google/android/material/textfield/TextInputLayout;->collapseHint(Z)V

    :cond_9e
    :goto_9e
    return-void
.end method

.method private updatePlaceholderMeasurementsBasedOnEditText()V
    .registers 6

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderTextView:Landroid/widget/TextView;

    if-eqz v0, :cond_2e

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    if-eqz v0, :cond_2e

    invoke-virtual {v0}, Landroid/widget/EditText;->getGravity()I

    move-result v0

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderTextView:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setGravity(I)V

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderTextView:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getCompoundPaddingLeft()I

    move-result v1

    iget-object v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getCompoundPaddingTop()I

    move-result v2

    iget-object v3, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {v3}, Landroid/widget/EditText;->getCompoundPaddingRight()I

    move-result v3

    iget-object v4, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {v4}, Landroid/widget/EditText;->getCompoundPaddingBottom()I

    move-result v4

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/widget/TextView;->setPadding(IIII)V

    :cond_2e
    return-void
.end method

.method private updatePlaceholderText()V
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    if-nez v0, :cond_6

    const/4 v0, 0x0

    goto :goto_a

    :cond_6
    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    :goto_a
    invoke-direct {p0, v0}, Lcom/google/android/material/textfield/TextInputLayout;->updatePlaceholderText(Landroid/text/Editable;)V

    return-void
.end method

.method private updatePlaceholderText(Landroid/text/Editable;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->lengthCounter:Lcom/google/android/material/textfield/TextInputLayout$LengthCounter;

    invoke-interface {v0, p1}, Lcom/google/android/material/textfield/TextInputLayout$LengthCounter;->countLength(Landroid/text/Editable;)I

    move-result p1

    if-nez p1, :cond_10

    iget-boolean p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->hintExpanded:Z

    if-nez p1, :cond_10

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->showPlaceholderText()V

    goto :goto_13

    :cond_10
    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->hidePlaceholderText()V

    :goto_13
    return-void
.end method

.method private updateStrokeErrorColor(ZZ)V
    .registers 7

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->strokeErrorColor:Landroid/content/res/ColorStateList;

    invoke-virtual {v0}, Landroid/content/res/ColorStateList;->getDefaultColor()I

    move-result v0

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->strokeErrorColor:Landroid/content/res/ColorStateList;

    const/4 v2, 0x2

    new-array v3, v2, [I

    fill-array-data v3, :array_2a

    invoke-virtual {v1, v3, v0}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    move-result v1

    iget-object v3, p0, Lcom/google/android/material/textfield/TextInputLayout;->strokeErrorColor:Landroid/content/res/ColorStateList;

    new-array v2, v2, [I

    fill-array-data v2, :array_32

    invoke-virtual {v3, v2, v0}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    move-result v2

    if-eqz p1, :cond_22

    iput v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeColor:I

    goto :goto_29

    :cond_22
    if-eqz p2, :cond_27

    iput v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeColor:I

    goto :goto_29

    :cond_27
    iput v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeColor:I

    :goto_29
    return-void

    :array_2a
    .array-data 4
        0x1010367
        0x101009e
    .end array-data

    :array_32
    .array-data 4
        0x10102fe
        0x101009e
    .end array-data
.end method


# virtual methods
.method public addOnEditTextAttachedListener(Lcom/google/android/material/textfield/TextInputLayout$OnEditTextAttachedListener;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editTextAttachedListeners:Ljava/util/LinkedHashSet;

    invoke-virtual {v0, p1}, Ljava/util/LinkedHashSet;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    if-eqz v0, :cond_c

    invoke-interface {p1, p0}, Lcom/google/android/material/textfield/TextInputLayout$OnEditTextAttachedListener;->onEditTextAttached(Lcom/google/android/material/textfield/TextInputLayout;)V

    :cond_c
    return-void
.end method

.method public addOnEndIconChangedListener(Lcom/google/android/material/textfield/TextInputLayout$OnEndIconChangedListener;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->addOnEndIconChangedListener(Lcom/google/android/material/textfield/TextInputLayout$OnEndIconChangedListener;)V

    return-void
.end method

.method public addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V
    .registers 5

    instance-of v0, p1, Landroid/widget/EditText;

    if-eqz v0, :cond_24

    new-instance p2, Landroid/widget/FrameLayout$LayoutParams;

    invoke-direct {p2, p3}, Landroid/widget/FrameLayout$LayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V

    iget v0, p2, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    and-int/lit8 v0, v0, -0x71

    or-int/lit8 v0, v0, 0x10

    iput v0, p2, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->inputFrame:Landroid/widget/FrameLayout;

    invoke-virtual {v0, p1, p2}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    iget-object p2, p0, Lcom/google/android/material/textfield/TextInputLayout;->inputFrame:Landroid/widget/FrameLayout;

    invoke-virtual {p2, p3}, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->updateInputLayoutMargins()V

    check-cast p1, Landroid/widget/EditText;

    invoke-direct {p0, p1}, Lcom/google/android/material/textfield/TextInputLayout;->setEditText(Landroid/widget/EditText;)V

    goto :goto_27

    :cond_24
    invoke-super {p0, p1, p2, p3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    :goto_27
    return-void
.end method

.method animateToExpansionFraction(F)V
    .registers 6

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    invoke-virtual {v0}, Lcom/google/android/material/internal/CollapsingTextHelper;->getExpansionFraction()F

    move-result v0

    cmpl-float v0, v0, p1

    if-nez v0, :cond_b

    return-void

    :cond_b
    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->animator:Landroid/animation/ValueAnimator;

    if-nez v0, :cond_41

    new-instance v0, Landroid/animation/ValueAnimator;

    invoke-direct {v0}, Landroid/animation/ValueAnimator;-><init>()V

    iput-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->animator:Landroid/animation/ValueAnimator;

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getContext()Landroid/content/Context;

    move-result-object v1

    sget v2, Lcom/google/android/material/R$attr;->motionEasingEmphasizedInterpolator:I

    sget-object v3, Lcom/google/android/material/animation/AnimationUtils;->FAST_OUT_SLOW_IN_INTERPOLATOR:Landroid/animation/TimeInterpolator;

    invoke-static {v1, v2, v3}, Lcom/google/android/material/motion/MotionUtils;->resolveThemeInterpolator(Landroid/content/Context;ILandroid/animation/TimeInterpolator;)Landroid/animation/TimeInterpolator;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/animation/ValueAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->animator:Landroid/animation/ValueAnimator;

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getContext()Landroid/content/Context;

    move-result-object v1

    sget v2, Lcom/google/android/material/R$attr;->motionDurationMedium4:I

    const/16 v3, 0xa7

    invoke-static {v1, v2, v3}, Lcom/google/android/material/motion/MotionUtils;->resolveThemeDuration(Landroid/content/Context;II)I

    move-result v1

    int-to-long v1, v1

    invoke-virtual {v0, v1, v2}, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->animator:Landroid/animation/ValueAnimator;

    new-instance v1, Lcom/google/android/material/textfield/TextInputLayout$4;

    invoke-direct {v1, p0}, Lcom/google/android/material/textfield/TextInputLayout$4;-><init>(Lcom/google/android/material/textfield/TextInputLayout;)V

    invoke-virtual {v0, v1}, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V

    :cond_41
    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->animator:Landroid/animation/ValueAnimator;

    const/4 v1, 0x2

    new-array v1, v1, [F

    iget-object v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    invoke-virtual {v2}, Lcom/google/android/material/internal/CollapsingTextHelper;->getExpansionFraction()F

    move-result v2

    const/4 v3, 0x0

    aput v2, v1, v3

    const/4 v2, 0x1

    aput p1, v1, v2

    invoke-virtual {v0, v1}, Landroid/animation/ValueAnimator;->setFloatValues([F)V

    iget-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->animator:Landroid/animation/ValueAnimator;

    invoke-virtual {p1}, Landroid/animation/ValueAnimator;->start()V

    return-void
.end method

.method public clearOnEditTextAttachedListeners()V
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editTextAttachedListeners:Ljava/util/LinkedHashSet;

    invoke-virtual {v0}, Ljava/util/LinkedHashSet;->clear()V

    return-void
.end method

.method public clearOnEndIconChangedListeners()V
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/EndCompoundLayout;->clearOnEndIconChangedListeners()V

    return-void
.end method

.method cutoutIsOpen()Z
    .registers 2

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->cutoutEnabled()Z

    move-result v0

    if-eqz v0, :cond_12

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackground:Lcom/google/android/material/shape/MaterialShapeDrawable;

    check-cast v0, Lcom/google/android/material/textfield/CutoutDrawable;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/CutoutDrawable;->hasCutout()Z

    move-result v0

    if-eqz v0, :cond_12

    const/4 v0, 0x1

    goto :goto_13

    :cond_12
    const/4 v0, 0x0

    :goto_13
    return v0
.end method

.method public dispatchProvideAutofillStructure(Landroid/view/ViewStructure;I)V
    .registers 7

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    if-nez v0, :cond_8

    invoke-super {p0, p1, p2}, Landroid/widget/LinearLayout;->dispatchProvideAutofillStructure(Landroid/view/ViewStructure;I)V

    return-void

    :cond_8
    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->originalHint:Ljava/lang/CharSequence;

    const/4 v2, 0x0

    if-eqz v1, :cond_30

    iget-boolean v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->isProvidingHint:Z

    iput-boolean v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->isProvidingHint:Z

    invoke-virtual {v0}, Landroid/widget/EditText;->getHint()Ljava/lang/CharSequence;

    move-result-object v0

    iget-object v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    iget-object v3, p0, Lcom/google/android/material/textfield/TextInputLayout;->originalHint:Ljava/lang/CharSequence;

    invoke-virtual {v2, v3}, Landroid/widget/EditText;->setHint(Ljava/lang/CharSequence;)V

    :try_start_1c
    invoke-super {p0, p1, p2}, Landroid/widget/LinearLayout;->dispatchProvideAutofillStructure(Landroid/view/ViewStructure;I)V
    :try_end_1f
    .catchall {:try_start_1c .. :try_end_1f} :catchall_27

    iget-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {p1, v0}, Landroid/widget/EditText;->setHint(Ljava/lang/CharSequence;)V

    iput-boolean v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->isProvidingHint:Z

    goto :goto_69

    :catchall_27
    move-exception p1

    iget-object p2, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {p2, v0}, Landroid/widget/EditText;->setHint(Ljava/lang/CharSequence;)V

    iput-boolean v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->isProvidingHint:Z

    throw p1

    :cond_30
    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getAutofillId()Landroid/view/autofill/AutofillId;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/view/ViewStructure;->setAutofillId(Landroid/view/autofill/AutofillId;)V

    invoke-virtual {p0, p1, p2}, Lcom/google/android/material/textfield/TextInputLayout;->onProvideAutofillStructure(Landroid/view/ViewStructure;I)V

    invoke-virtual {p0, p1, p2}, Lcom/google/android/material/textfield/TextInputLayout;->onProvideAutofillVirtualStructure(Landroid/view/ViewStructure;I)V

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->inputFrame:Landroid/widget/FrameLayout;

    invoke-virtual {v0}, Landroid/widget/FrameLayout;->getChildCount()I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/view/ViewStructure;->setChildCount(I)V

    :goto_46
    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->inputFrame:Landroid/widget/FrameLayout;

    invoke-virtual {v0}, Landroid/widget/FrameLayout;->getChildCount()I

    move-result v0

    if-ge v2, v0, :cond_69

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->inputFrame:Landroid/widget/FrameLayout;

    invoke-virtual {v0, v2}, Landroid/widget/FrameLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {p1, v2}, Landroid/view/ViewStructure;->newChild(I)Landroid/view/ViewStructure;

    move-result-object v1

    invoke-virtual {v0, v1, p2}, Landroid/view/View;->dispatchProvideAutofillStructure(Landroid/view/ViewStructure;I)V

    iget-object v3, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    if-ne v0, v3, :cond_66

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getHint()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/view/ViewStructure;->setHint(Ljava/lang/CharSequence;)V

    :cond_66
    add-int/lit8 v2, v2, 0x1

    goto :goto_46

    :cond_69
    :goto_69
    return-void
.end method

.method protected dispatchRestoreInstanceState(Landroid/util/SparseArray;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/util/SparseArray<",
            "Landroid/os/Parcelable;",
            ">;)V"
        }
    .end annotation

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->restoringSavedState:Z

    invoke-super {p0, p1}, Landroid/widget/LinearLayout;->dispatchRestoreInstanceState(Landroid/util/SparseArray;)V

    const/4 p1, 0x0

    iput-boolean p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->restoringSavedState:Z

    return-void
.end method

.method public draw(Landroid/graphics/Canvas;)V
    .registers 2

    invoke-super {p0, p1}, Landroid/widget/LinearLayout;->draw(Landroid/graphics/Canvas;)V

    invoke-direct {p0, p1}, Lcom/google/android/material/textfield/TextInputLayout;->drawHint(Landroid/graphics/Canvas;)V

    invoke-direct {p0, p1}, Lcom/google/android/material/textfield/TextInputLayout;->drawBoxUnderline(Landroid/graphics/Canvas;)V

    return-void
.end method

.method protected drawableStateChanged()V
    .registers 5

    iget-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->inDrawableStateChanged:Z

    if-eqz v0, :cond_5

    return-void

    :cond_5
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->inDrawableStateChanged:Z

    invoke-super {p0}, Landroid/widget/LinearLayout;->drawableStateChanged()V

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getDrawableState()[I

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    const/4 v3, 0x0

    if-eqz v2, :cond_1a

    invoke-virtual {v2, v1}, Lcom/google/android/material/internal/CollapsingTextHelper;->setState([I)Z

    move-result v1

    or-int/2addr v1, v3

    goto :goto_1b

    :cond_1a
    move v1, v3

    :goto_1b
    iget-object v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    if-eqz v2, :cond_30

    invoke-static {p0}, Landroidx/core/view/ViewCompat;->isLaidOut(Landroid/view/View;)Z

    move-result v2

    if-eqz v2, :cond_2c

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->isEnabled()Z

    move-result v2

    if-eqz v2, :cond_2c

    goto :goto_2d

    :cond_2c
    move v0, v3

    :goto_2d
    invoke-virtual {p0, v0}, Lcom/google/android/material/textfield/TextInputLayout;->updateLabelState(Z)V

    :cond_30
    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->updateEditTextBackground()V

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->updateTextInputBoxState()V

    if-eqz v1, :cond_3b

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->invalidate()V

    :cond_3b
    iput-boolean v3, p0, Lcom/google/android/material/textfield/TextInputLayout;->inDrawableStateChanged:Z

    return-void
.end method

.method public getBaseline()I
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    if-eqz v0, :cond_13

    invoke-virtual {v0}, Landroid/widget/EditText;->getBaseline()I

    move-result v0

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getPaddingTop()I

    move-result v1

    add-int/2addr v0, v1

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->calculateLabelMarginTop()I

    move-result v1

    add-int/2addr v0, v1

    return v0

    :cond_13
    invoke-super {p0}, Landroid/widget/LinearLayout;->getBaseline()I

    move-result v0

    return v0
.end method

.method getBoxBackground()Lcom/google/android/material/shape/MaterialShapeDrawable;
    .registers 3

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundMode:I

    const/4 v1, 0x1

    if-eq v0, v1, :cond_f

    const/4 v1, 0x2

    if-ne v0, v1, :cond_9

    goto :goto_f

    :cond_9
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    :cond_f
    :goto_f
    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackground:Lcom/google/android/material/shape/MaterialShapeDrawable;

    return-object v0
.end method

.method public getBoxBackgroundColor()I
    .registers 2

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundColor:I

    return v0
.end method

.method public getBoxBackgroundMode()I
    .registers 2

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundMode:I

    return v0
.end method

.method public getBoxCollapsedPaddingTop()I
    .registers 2

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxCollapsedPaddingTopPx:I

    return v0
.end method

.method public getBoxCornerRadiusBottomEnd()F
    .registers 3

    invoke-static {p0}, Lcom/google/android/material/internal/ViewUtils;->isLayoutRtl(Landroid/view/View;)Z

    move-result v0

    if-eqz v0, :cond_13

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    invoke-virtual {v0}, Lcom/google/android/material/shape/ShapeAppearanceModel;->getBottomLeftCornerSize()Lcom/google/android/material/shape/CornerSize;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->tmpRectF:Landroid/graphics/RectF;

    invoke-interface {v0, v1}, Lcom/google/android/material/shape/CornerSize;->getCornerSize(Landroid/graphics/RectF;)F

    move-result v0

    goto :goto_1f

    :cond_13
    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    invoke-virtual {v0}, Lcom/google/android/material/shape/ShapeAppearanceModel;->getBottomRightCornerSize()Lcom/google/android/material/shape/CornerSize;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->tmpRectF:Landroid/graphics/RectF;

    invoke-interface {v0, v1}, Lcom/google/android/material/shape/CornerSize;->getCornerSize(Landroid/graphics/RectF;)F

    move-result v0

    :goto_1f
    return v0
.end method

.method public getBoxCornerRadiusBottomStart()F
    .registers 3

    invoke-static {p0}, Lcom/google/android/material/internal/ViewUtils;->isLayoutRtl(Landroid/view/View;)Z

    move-result v0

    if-eqz v0, :cond_13

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    invoke-virtual {v0}, Lcom/google/android/material/shape/ShapeAppearanceModel;->getBottomRightCornerSize()Lcom/google/android/material/shape/CornerSize;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->tmpRectF:Landroid/graphics/RectF;

    invoke-interface {v0, v1}, Lcom/google/android/material/shape/CornerSize;->getCornerSize(Landroid/graphics/RectF;)F

    move-result v0

    goto :goto_1f

    :cond_13
    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    invoke-virtual {v0}, Lcom/google/android/material/shape/ShapeAppearanceModel;->getBottomLeftCornerSize()Lcom/google/android/material/shape/CornerSize;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->tmpRectF:Landroid/graphics/RectF;

    invoke-interface {v0, v1}, Lcom/google/android/material/shape/CornerSize;->getCornerSize(Landroid/graphics/RectF;)F

    move-result v0

    :goto_1f
    return v0
.end method

.method public getBoxCornerRadiusTopEnd()F
    .registers 3

    invoke-static {p0}, Lcom/google/android/material/internal/ViewUtils;->isLayoutRtl(Landroid/view/View;)Z

    move-result v0

    if-eqz v0, :cond_13

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    invoke-virtual {v0}, Lcom/google/android/material/shape/ShapeAppearanceModel;->getTopLeftCornerSize()Lcom/google/android/material/shape/CornerSize;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->tmpRectF:Landroid/graphics/RectF;

    invoke-interface {v0, v1}, Lcom/google/android/material/shape/CornerSize;->getCornerSize(Landroid/graphics/RectF;)F

    move-result v0

    goto :goto_1f

    :cond_13
    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    invoke-virtual {v0}, Lcom/google/android/material/shape/ShapeAppearanceModel;->getTopRightCornerSize()Lcom/google/android/material/shape/CornerSize;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->tmpRectF:Landroid/graphics/RectF;

    invoke-interface {v0, v1}, Lcom/google/android/material/shape/CornerSize;->getCornerSize(Landroid/graphics/RectF;)F

    move-result v0

    :goto_1f
    return v0
.end method

.method public getBoxCornerRadiusTopStart()F
    .registers 3

    invoke-static {p0}, Lcom/google/android/material/internal/ViewUtils;->isLayoutRtl(Landroid/view/View;)Z

    move-result v0

    if-eqz v0, :cond_13

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    invoke-virtual {v0}, Lcom/google/android/material/shape/ShapeAppearanceModel;->getTopRightCornerSize()Lcom/google/android/material/shape/CornerSize;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->tmpRectF:Landroid/graphics/RectF;

    invoke-interface {v0, v1}, Lcom/google/android/material/shape/CornerSize;->getCornerSize(Landroid/graphics/RectF;)F

    move-result v0

    goto :goto_1f

    :cond_13
    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    invoke-virtual {v0}, Lcom/google/android/material/shape/ShapeAppearanceModel;->getTopLeftCornerSize()Lcom/google/android/material/shape/CornerSize;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->tmpRectF:Landroid/graphics/RectF;

    invoke-interface {v0, v1}, Lcom/google/android/material/shape/CornerSize;->getCornerSize(Landroid/graphics/RectF;)F

    move-result v0

    :goto_1f
    return v0
.end method

.method public getBoxStrokeColor()I
    .registers 2

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->focusedStrokeColor:I

    return v0
.end method

.method public getBoxStrokeErrorColor()Landroid/content/res/ColorStateList;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->strokeErrorColor:Landroid/content/res/ColorStateList;

    return-object v0
.end method

.method public getBoxStrokeWidth()I
    .registers 2

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeWidthDefaultPx:I

    return v0
.end method

.method public getBoxStrokeWidthFocused()I
    .registers 2

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeWidthFocusedPx:I

    return v0
.end method

.method public getCounterMaxLength()I
    .registers 2

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterMaxLength:I

    return v0
.end method

.method getCounterOverflowDescription()Ljava/lang/CharSequence;
    .registers 2

    iget-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterEnabled:Z

    if-eqz v0, :cond_11

    iget-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterOverflowed:Z

    if-eqz v0, :cond_11

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterView:Landroid/widget/TextView;

    if-eqz v0, :cond_11

    invoke-virtual {v0}, Landroid/widget/TextView;->getContentDescription()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0

    :cond_11
    const/4 v0, 0x0

    return-object v0
.end method

.method public getCounterOverflowTextColor()Landroid/content/res/ColorStateList;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterOverflowTextColor:Landroid/content/res/ColorStateList;

    return-object v0
.end method

.method public getCounterTextColor()Landroid/content/res/ColorStateList;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterTextColor:Landroid/content/res/ColorStateList;

    return-object v0
.end method

.method public getDefaultHintTextColor()Landroid/content/res/ColorStateList;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->defaultHintTextColor:Landroid/content/res/ColorStateList;

    return-object v0
.end method

.method public getEditText()Landroid/widget/EditText;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    return-object v0
.end method

.method public getEndIconContentDescription()Ljava/lang/CharSequence;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/EndCompoundLayout;->getEndIconContentDescription()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public getEndIconDrawable()Landroid/graphics/drawable/Drawable;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/EndCompoundLayout;->getEndIconDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0
.end method

.method public getEndIconMinSize()I
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/EndCompoundLayout;->getEndIconMinSize()I

    move-result v0

    return v0
.end method

.method public getEndIconMode()I
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/EndCompoundLayout;->getEndIconMode()I

    move-result v0

    return v0
.end method

.method public getEndIconScaleType()Landroid/widget/ImageView$ScaleType;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/EndCompoundLayout;->getEndIconScaleType()Landroid/widget/ImageView$ScaleType;

    move-result-object v0

    return-object v0
.end method

.method getEndIconView()Lcom/google/android/material/internal/CheckableImageButton;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/EndCompoundLayout;->getEndIconView()Lcom/google/android/material/internal/CheckableImageButton;

    move-result-object v0

    return-object v0
.end method

.method public getError()Ljava/lang/CharSequence;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/IndicatorViewController;->isErrorEnabled()Z

    move-result v0

    if-eqz v0, :cond_f

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/IndicatorViewController;->getErrorText()Ljava/lang/CharSequence;

    move-result-object v0

    goto :goto_10

    :cond_f
    const/4 v0, 0x0

    :goto_10
    return-object v0
.end method

.method public getErrorAccessibilityLiveRegion()I
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/IndicatorViewController;->getErrorAccessibilityLiveRegion()I

    move-result v0

    return v0
.end method

.method public getErrorContentDescription()Ljava/lang/CharSequence;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/IndicatorViewController;->getErrorContentDescription()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public getErrorCurrentTextColors()I
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/IndicatorViewController;->getErrorViewCurrentTextColor()I

    move-result v0

    return v0
.end method

.method public getErrorIconDrawable()Landroid/graphics/drawable/Drawable;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/EndCompoundLayout;->getErrorIconDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0
.end method

.method public getHelperText()Ljava/lang/CharSequence;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/IndicatorViewController;->isHelperTextEnabled()Z

    move-result v0

    if-eqz v0, :cond_f

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/IndicatorViewController;->getHelperText()Ljava/lang/CharSequence;

    move-result-object v0

    goto :goto_10

    :cond_f
    const/4 v0, 0x0

    :goto_10
    return-object v0
.end method

.method public getHelperTextCurrentTextColor()I
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/IndicatorViewController;->getHelperTextViewCurrentTextColor()I

    move-result v0

    return v0
.end method

.method public getHint()Ljava/lang/CharSequence;
    .registers 2

    iget-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->hintEnabled:Z

    if-eqz v0, :cond_7

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->hint:Ljava/lang/CharSequence;

    goto :goto_8

    :cond_7
    const/4 v0, 0x0

    :goto_8
    return-object v0
.end method

.method final getHintCollapsedTextHeight()F
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    invoke-virtual {v0}, Lcom/google/android/material/internal/CollapsingTextHelper;->getCollapsedTextHeight()F

    move-result v0

    return v0
.end method

.method final getHintCurrentCollapsedTextColor()I
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    invoke-virtual {v0}, Lcom/google/android/material/internal/CollapsingTextHelper;->getCurrentCollapsedTextColor()I

    move-result v0

    return v0
.end method

.method public getHintTextColor()Landroid/content/res/ColorStateList;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->focusedTextColor:Landroid/content/res/ColorStateList;

    return-object v0
.end method

.method public getLengthCounter()Lcom/google/android/material/textfield/TextInputLayout$LengthCounter;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->lengthCounter:Lcom/google/android/material/textfield/TextInputLayout$LengthCounter;

    return-object v0
.end method

.method public getMaxEms()I
    .registers 2

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->maxEms:I

    return v0
.end method

.method public getMaxWidth()I
    .registers 2

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->maxWidth:I

    return v0
.end method

.method public getMinEms()I
    .registers 2

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->minEms:I

    return v0
.end method

.method public getMinWidth()I
    .registers 2

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->minWidth:I

    return v0
.end method

.method public getPasswordVisibilityToggleContentDescription()Ljava/lang/CharSequence;
    .registers 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/EndCompoundLayout;->getPasswordVisibilityToggleContentDescription()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public getPasswordVisibilityToggleDrawable()Landroid/graphics/drawable/Drawable;
    .registers 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/EndCompoundLayout;->getPasswordVisibilityToggleDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0
.end method

.method public getPlaceholderText()Ljava/lang/CharSequence;
    .registers 2

    iget-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderEnabled:Z

    if-eqz v0, :cond_7

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderText:Ljava/lang/CharSequence;

    goto :goto_8

    :cond_7
    const/4 v0, 0x0

    :goto_8
    return-object v0
.end method

.method public getPlaceholderTextAppearance()I
    .registers 2

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderTextAppearance:I

    return v0
.end method

.method public getPlaceholderTextColor()Landroid/content/res/ColorStateList;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderTextColor:Landroid/content/res/ColorStateList;

    return-object v0
.end method

.method public getPrefixText()Ljava/lang/CharSequence;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/StartCompoundLayout;->getPrefixText()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public getPrefixTextColor()Landroid/content/res/ColorStateList;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/StartCompoundLayout;->getPrefixTextColor()Landroid/content/res/ColorStateList;

    move-result-object v0

    return-object v0
.end method

.method public getPrefixTextView()Landroid/widget/TextView;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/StartCompoundLayout;->getPrefixTextView()Landroid/widget/TextView;

    move-result-object v0

    return-object v0
.end method

.method public getShapeAppearanceModel()Lcom/google/android/material/shape/ShapeAppearanceModel;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    return-object v0
.end method

.method public getStartIconContentDescription()Ljava/lang/CharSequence;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/StartCompoundLayout;->getStartIconContentDescription()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public getStartIconDrawable()Landroid/graphics/drawable/Drawable;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/StartCompoundLayout;->getStartIconDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0
.end method

.method public getStartIconMinSize()I
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/StartCompoundLayout;->getStartIconMinSize()I

    move-result v0

    return v0
.end method

.method public getStartIconScaleType()Landroid/widget/ImageView$ScaleType;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/StartCompoundLayout;->getStartIconScaleType()Landroid/widget/ImageView$ScaleType;

    move-result-object v0

    return-object v0
.end method

.method public getSuffixText()Ljava/lang/CharSequence;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/EndCompoundLayout;->getSuffixText()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public getSuffixTextColor()Landroid/content/res/ColorStateList;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/EndCompoundLayout;->getSuffixTextColor()Landroid/content/res/ColorStateList;

    move-result-object v0

    return-object v0
.end method

.method public getSuffixTextView()Landroid/widget/TextView;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/EndCompoundLayout;->getSuffixTextView()Landroid/widget/TextView;

    move-result-object v0

    return-object v0
.end method

.method public getTypeface()Landroid/graphics/Typeface;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->typeface:Landroid/graphics/Typeface;

    return-object v0
.end method

.method public isCounterEnabled()Z
    .registers 2

    iget-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterEnabled:Z

    return v0
.end method

.method public isEndIconCheckable()Z
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/EndCompoundLayout;->isEndIconCheckable()Z

    move-result v0

    return v0
.end method

.method public isEndIconVisible()Z
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/EndCompoundLayout;->isEndIconVisible()Z

    move-result v0

    return v0
.end method

.method public isErrorEnabled()Z
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/IndicatorViewController;->isErrorEnabled()Z

    move-result v0

    return v0
.end method

.method public isExpandedHintEnabled()Z
    .registers 2

    iget-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->expandedHintEnabled:Z

    return v0
.end method

.method final isHelperTextDisplayed()Z
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/IndicatorViewController;->helperTextIsDisplayed()Z

    move-result v0

    return v0
.end method

.method public isHelperTextEnabled()Z
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/IndicatorViewController;->isHelperTextEnabled()Z

    move-result v0

    return v0
.end method

.method public isHintAnimationEnabled()Z
    .registers 2

    iget-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->hintAnimationEnabled:Z

    return v0
.end method

.method public isHintEnabled()Z
    .registers 2

    iget-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->hintEnabled:Z

    return v0
.end method

.method final isHintExpanded()Z
    .registers 2

    iget-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->hintExpanded:Z

    return v0
.end method

.method public isPasswordVisibilityToggleEnabled()Z
    .registers 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/EndCompoundLayout;->isPasswordVisibilityToggleEnabled()Z

    move-result v0

    return v0
.end method

.method public isProvidingHint()Z
    .registers 2

    iget-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->isProvidingHint:Z

    return v0
.end method

.method public isStartIconCheckable()Z
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/StartCompoundLayout;->isStartIconCheckable()Z

    move-result v0

    return v0
.end method

.method public isStartIconVisible()Z
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/StartCompoundLayout;->isStartIconVisible()Z

    move-result v0

    return v0
.end method

.method protected onConfigurationChanged(Landroid/content/res/Configuration;)V
    .registers 3

    invoke-super {p0, p1}, Landroid/widget/LinearLayout;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    invoke-virtual {v0, p1}, Lcom/google/android/material/internal/CollapsingTextHelper;->maybeUpdateFontWeightAdjustment(Landroid/content/res/Configuration;)V

    return-void
.end method

.method protected onLayout(ZIIII)V
    .registers 6

    invoke-super/range {p0 .. p5}, Landroid/widget/LinearLayout;->onLayout(ZIIII)V

    iget-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    if-eqz p1, :cond_56

    iget-object p2, p0, Lcom/google/android/material/textfield/TextInputLayout;->tmpRect:Landroid/graphics/Rect;

    invoke-static {p0, p1, p2}, Lcom/google/android/material/internal/DescendantOffsetUtils;->getDescendantRect(Landroid/view/ViewGroup;Landroid/view/View;Landroid/graphics/Rect;)V

    invoke-direct {p0, p2}, Lcom/google/android/material/textfield/TextInputLayout;->updateBoxUnderlineBounds(Landroid/graphics/Rect;)V

    iget-boolean p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->hintEnabled:Z

    if-eqz p1, :cond_56

    iget-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    iget-object p3, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {p3}, Landroid/widget/EditText;->getTextSize()F

    move-result p3

    invoke-virtual {p1, p3}, Lcom/google/android/material/internal/CollapsingTextHelper;->setExpandedTextSize(F)V

    iget-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {p1}, Landroid/widget/EditText;->getGravity()I

    move-result p1

    iget-object p3, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    and-int/lit8 p4, p1, -0x71

    or-int/lit8 p4, p4, 0x30

    invoke-virtual {p3, p4}, Lcom/google/android/material/internal/CollapsingTextHelper;->setCollapsedTextGravity(I)V

    iget-object p3, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    invoke-virtual {p3, p1}, Lcom/google/android/material/internal/CollapsingTextHelper;->setExpandedTextGravity(I)V

    iget-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    invoke-direct {p0, p2}, Lcom/google/android/material/textfield/TextInputLayout;->calculateCollapsedTextBounds(Landroid/graphics/Rect;)Landroid/graphics/Rect;

    move-result-object p3

    invoke-virtual {p1, p3}, Lcom/google/android/material/internal/CollapsingTextHelper;->setCollapsedBounds(Landroid/graphics/Rect;)V

    iget-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    invoke-direct {p0, p2}, Lcom/google/android/material/textfield/TextInputLayout;->calculateExpandedTextBounds(Landroid/graphics/Rect;)Landroid/graphics/Rect;

    move-result-object p2

    invoke-virtual {p1, p2}, Lcom/google/android/material/internal/CollapsingTextHelper;->setExpandedBounds(Landroid/graphics/Rect;)V

    iget-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    invoke-virtual {p1}, Lcom/google/android/material/internal/CollapsingTextHelper;->recalculate()V

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->cutoutEnabled()Z

    move-result p1

    if-eqz p1, :cond_56

    iget-boolean p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->hintExpanded:Z

    if-nez p1, :cond_56

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->openCutout()V

    :cond_56
    return-void
.end method

.method protected onMeasure(II)V
    .registers 3

    invoke-super {p0, p1, p2}, Landroid/widget/LinearLayout;->onMeasure(II)V

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->updateEditTextHeightBasedOnIcon()Z

    move-result p1

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->updateDummyDrawables()Z

    move-result p2

    if-nez p1, :cond_f

    if-eqz p2, :cond_19

    :cond_f
    iget-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    new-instance p2, Lcom/google/android/material/textfield/TextInputLayout$3;

    invoke-direct {p2, p0}, Lcom/google/android/material/textfield/TextInputLayout$3;-><init>(Lcom/google/android/material/textfield/TextInputLayout;)V

    invoke-virtual {p1, p2}, Landroid/widget/EditText;->post(Ljava/lang/Runnable;)Z

    :cond_19
    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->updatePlaceholderMeasurementsBasedOnEditText()V

    iget-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->updateSuffixTextViewPadding()V

    return-void
.end method

.method protected onRestoreInstanceState(Landroid/os/Parcelable;)V
    .registers 3

    instance-of v0, p1, Lcom/google/android/material/textfield/TextInputLayout$SavedState;

    if-nez v0, :cond_8

    invoke-super {p0, p1}, Landroid/widget/LinearLayout;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    return-void

    :cond_8
    check-cast p1, Lcom/google/android/material/textfield/TextInputLayout$SavedState;

    invoke-virtual {p1}, Lcom/google/android/material/textfield/TextInputLayout$SavedState;->getSuperState()Landroid/os/Parcelable;

    move-result-object v0

    invoke-super {p0, v0}, Landroid/widget/LinearLayout;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    iget-object v0, p1, Lcom/google/android/material/textfield/TextInputLayout$SavedState;->error:Ljava/lang/CharSequence;

    invoke-virtual {p0, v0}, Lcom/google/android/material/textfield/TextInputLayout;->setError(Ljava/lang/CharSequence;)V

    iget-boolean p1, p1, Lcom/google/android/material/textfield/TextInputLayout$SavedState;->isEndIconChecked:Z

    if-eqz p1, :cond_22

    new-instance p1, Lcom/google/android/material/textfield/TextInputLayout$2;

    invoke-direct {p1, p0}, Lcom/google/android/material/textfield/TextInputLayout$2;-><init>(Lcom/google/android/material/textfield/TextInputLayout;)V

    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/TextInputLayout;->post(Ljava/lang/Runnable;)Z

    :cond_22
    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->requestLayout()V

    return-void
.end method

.method public onRtlPropertiesChanged(I)V
    .registers 11

    invoke-super {p0, p1}, Landroid/widget/LinearLayout;->onRtlPropertiesChanged(I)V

    const/4 v0, 0x1

    if-ne p1, v0, :cond_7

    goto :goto_8

    :cond_7
    const/4 v0, 0x0

    :goto_8
    iget-boolean p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->areCornerRadiiRtl:Z

    if-eq v0, p1, :cond_81

    iget-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    invoke-virtual {p1}, Lcom/google/android/material/shape/ShapeAppearanceModel;->getTopLeftCornerSize()Lcom/google/android/material/shape/CornerSize;

    move-result-object p1

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->tmpRectF:Landroid/graphics/RectF;

    invoke-interface {p1, v1}, Lcom/google/android/material/shape/CornerSize;->getCornerSize(Landroid/graphics/RectF;)F

    move-result p1

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    invoke-virtual {v1}, Lcom/google/android/material/shape/ShapeAppearanceModel;->getTopRightCornerSize()Lcom/google/android/material/shape/CornerSize;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->tmpRectF:Landroid/graphics/RectF;

    invoke-interface {v1, v2}, Lcom/google/android/material/shape/CornerSize;->getCornerSize(Landroid/graphics/RectF;)F

    move-result v1

    iget-object v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    invoke-virtual {v2}, Lcom/google/android/material/shape/ShapeAppearanceModel;->getBottomLeftCornerSize()Lcom/google/android/material/shape/CornerSize;

    move-result-object v2

    iget-object v3, p0, Lcom/google/android/material/textfield/TextInputLayout;->tmpRectF:Landroid/graphics/RectF;

    invoke-interface {v2, v3}, Lcom/google/android/material/shape/CornerSize;->getCornerSize(Landroid/graphics/RectF;)F

    move-result v2

    iget-object v3, p0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    invoke-virtual {v3}, Lcom/google/android/material/shape/ShapeAppearanceModel;->getBottomRightCornerSize()Lcom/google/android/material/shape/CornerSize;

    move-result-object v3

    iget-object v4, p0, Lcom/google/android/material/textfield/TextInputLayout;->tmpRectF:Landroid/graphics/RectF;

    invoke-interface {v3, v4}, Lcom/google/android/material/shape/CornerSize;->getCornerSize(Landroid/graphics/RectF;)F

    move-result v3

    iget-object v4, p0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    invoke-virtual {v4}, Lcom/google/android/material/shape/ShapeAppearanceModel;->getTopLeftCorner()Lcom/google/android/material/shape/CornerTreatment;

    move-result-object v4

    iget-object v5, p0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    invoke-virtual {v5}, Lcom/google/android/material/shape/ShapeAppearanceModel;->getTopRightCorner()Lcom/google/android/material/shape/CornerTreatment;

    move-result-object v5

    iget-object v6, p0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    invoke-virtual {v6}, Lcom/google/android/material/shape/ShapeAppearanceModel;->getBottomLeftCorner()Lcom/google/android/material/shape/CornerTreatment;

    move-result-object v6

    iget-object v7, p0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    invoke-virtual {v7}, Lcom/google/android/material/shape/ShapeAppearanceModel;->getBottomRightCorner()Lcom/google/android/material/shape/CornerTreatment;

    move-result-object v7

    invoke-static {}, Lcom/google/android/material/shape/ShapeAppearanceModel;->builder()Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    move-result-object v8

    invoke-virtual {v8, v5}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->setTopLeftCorner(Lcom/google/android/material/shape/CornerTreatment;)Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    move-result-object v5

    invoke-virtual {v5, v4}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->setTopRightCorner(Lcom/google/android/material/shape/CornerTreatment;)Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    move-result-object v4

    invoke-virtual {v4, v7}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->setBottomLeftCorner(Lcom/google/android/material/shape/CornerTreatment;)Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    move-result-object v4

    invoke-virtual {v4, v6}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->setBottomRightCorner(Lcom/google/android/material/shape/CornerTreatment;)Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    move-result-object v4

    invoke-virtual {v4, v1}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->setTopLeftCornerSize(F)Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->setTopRightCornerSize(F)Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    move-result-object p1

    invoke-virtual {p1, v3}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->setBottomLeftCornerSize(F)Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    move-result-object p1

    invoke-virtual {p1, v2}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->setBottomRightCornerSize(F)Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    move-result-object p1

    invoke-virtual {p1}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->build()Lcom/google/android/material/shape/ShapeAppearanceModel;

    move-result-object p1

    iput-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->areCornerRadiiRtl:Z

    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/TextInputLayout;->setShapeAppearanceModel(Lcom/google/android/material/shape/ShapeAppearanceModel;)V

    :cond_81
    return-void
.end method

.method public onSaveInstanceState()Landroid/os/Parcelable;
    .registers 3

    invoke-super {p0}, Landroid/widget/LinearLayout;->onSaveInstanceState()Landroid/os/Parcelable;

    move-result-object v0

    new-instance v1, Lcom/google/android/material/textfield/TextInputLayout$SavedState;

    invoke-direct {v1, v0}, Lcom/google/android/material/textfield/TextInputLayout$SavedState;-><init>(Landroid/os/Parcelable;)V

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->shouldShowError()Z

    move-result v0

    if-eqz v0, :cond_15

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getError()Ljava/lang/CharSequence;

    move-result-object v0

    iput-object v0, v1, Lcom/google/android/material/textfield/TextInputLayout$SavedState;->error:Ljava/lang/CharSequence;

    :cond_15
    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/EndCompoundLayout;->isEndIconChecked()Z

    move-result v0

    iput-boolean v0, v1, Lcom/google/android/material/textfield/TextInputLayout$SavedState;->isEndIconChecked:Z

    return-object v1
.end method

.method public passwordVisibilityToggleRequested(Z)V
    .registers 3
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->togglePasswordVisibilityToggle(Z)V

    return-void
.end method

.method public refreshEndIconDrawableState()V
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/EndCompoundLayout;->refreshEndIconDrawableState()V

    return-void
.end method

.method public refreshErrorIconDrawableState()V
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/EndCompoundLayout;->refreshErrorIconDrawableState()V

    return-void
.end method

.method public refreshStartIconDrawableState()V
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/StartCompoundLayout;->refreshStartIconDrawableState()V

    return-void
.end method

.method public removeOnEditTextAttachedListener(Lcom/google/android/material/textfield/TextInputLayout$OnEditTextAttachedListener;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editTextAttachedListeners:Ljava/util/LinkedHashSet;

    invoke-virtual {v0, p1}, Ljava/util/LinkedHashSet;->remove(Ljava/lang/Object;)Z

    return-void
.end method

.method public removeOnEndIconChangedListener(Lcom/google/android/material/textfield/TextInputLayout$OnEndIconChangedListener;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->removeOnEndIconChangedListener(Lcom/google/android/material/textfield/TextInputLayout$OnEndIconChangedListener;)V

    return-void
.end method

.method public setBoxBackgroundColor(I)V
    .registers 3

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundColor:I

    if-eq v0, p1, :cond_f

    iput p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundColor:I

    iput p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->defaultFilledBackgroundColor:I

    iput p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->focusedFilledBackgroundColor:I

    iput p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->hoveredFilledBackgroundColor:I

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->applyBoxAttributes()V

    :cond_f
    return-void
.end method

.method public setBoxBackgroundColorResource(I)V
    .registers 3

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p1}, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context;I)I

    move-result p1

    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/TextInputLayout;->setBoxBackgroundColor(I)V

    return-void
.end method

.method public setBoxBackgroundColorStateList(Landroid/content/res/ColorStateList;)V
    .registers 5

    invoke-virtual {p1}, Landroid/content/res/ColorStateList;->getDefaultColor()I

    move-result v0

    iput v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->defaultFilledBackgroundColor:I

    iput v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundColor:I

    const/4 v0, 0x1

    new-array v0, v0, [I

    const/4 v1, 0x0

    const v2, -0x101009e

    aput v2, v0, v1

    const/4 v1, -0x1

    invoke-virtual {p1, v0, v1}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    move-result v0

    iput v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->disabledFilledBackgroundColor:I

    const/4 v0, 0x2

    new-array v2, v0, [I

    fill-array-data v2, :array_34

    invoke-virtual {p1, v2, v1}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    move-result v2

    iput v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->focusedFilledBackgroundColor:I

    new-array v0, v0, [I

    fill-array-data v0, :array_3c

    invoke-virtual {p1, v0, v1}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    move-result p1

    iput p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->hoveredFilledBackgroundColor:I

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->applyBoxAttributes()V

    return-void

    nop

    :array_34
    .array-data 4
        0x101009c
        0x101009e
    .end array-data

    :array_3c
    .array-data 4
        0x1010367
        0x101009e
    .end array-data
.end method

.method public setBoxBackgroundMode(I)V
    .registers 3

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundMode:I

    if-ne p1, v0, :cond_5

    return-void

    :cond_5
    iput p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundMode:I

    iget-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    if-eqz p1, :cond_e

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->onApplyBoxBackgroundMode()V

    :cond_e
    return-void
.end method

.method public setBoxCollapsedPaddingTop(I)V
    .registers 2

    iput p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxCollapsedPaddingTopPx:I

    return-void
.end method

.method public setBoxCornerFamily(I)V
    .registers 4

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    invoke-virtual {v0}, Lcom/google/android/material/shape/ShapeAppearanceModel;->toBuilder()Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    invoke-virtual {v1}, Lcom/google/android/material/shape/ShapeAppearanceModel;->getTopLeftCornerSize()Lcom/google/android/material/shape/CornerSize;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->setTopLeftCorner(ILcom/google/android/material/shape/CornerSize;)Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    invoke-virtual {v1}, Lcom/google/android/material/shape/ShapeAppearanceModel;->getTopRightCornerSize()Lcom/google/android/material/shape/CornerSize;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->setTopRightCorner(ILcom/google/android/material/shape/CornerSize;)Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    invoke-virtual {v1}, Lcom/google/android/material/shape/ShapeAppearanceModel;->getBottomLeftCornerSize()Lcom/google/android/material/shape/CornerSize;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->setBottomLeftCorner(ILcom/google/android/material/shape/CornerSize;)Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    invoke-virtual {v1}, Lcom/google/android/material/shape/ShapeAppearanceModel;->getBottomRightCornerSize()Lcom/google/android/material/shape/CornerSize;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->setBottomRightCorner(ILcom/google/android/material/shape/CornerSize;)Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    move-result-object p1

    invoke-virtual {p1}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->build()Lcom/google/android/material/shape/ShapeAppearanceModel;

    move-result-object p1

    iput-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->applyBoxAttributes()V

    return-void
.end method

.method public setBoxCornerRadii(FFFF)V
    .registers 7

    invoke-static {p0}, Lcom/google/android/material/internal/ViewUtils;->isLayoutRtl(Landroid/view/View;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->areCornerRadiiRtl:Z

    if-eqz v0, :cond_a

    move v1, p2

    goto :goto_b

    :cond_a
    move v1, p1

    :goto_b
    if-eqz v0, :cond_e

    goto :goto_f

    :cond_e
    move p1, p2

    :goto_f
    if-eqz v0, :cond_13

    move p2, p4

    goto :goto_14

    :cond_13
    move p2, p3

    :goto_14
    if-eqz v0, :cond_17

    goto :goto_18

    :cond_17
    move p3, p4

    :goto_18
    iget-object p4, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackground:Lcom/google/android/material/shape/MaterialShapeDrawable;

    if-eqz p4, :cond_42

    invoke-virtual {p4}, Lcom/google/android/material/shape/MaterialShapeDrawable;->getTopLeftCornerResolvedSize()F

    move-result p4

    cmpl-float p4, p4, v1

    if-nez p4, :cond_42

    iget-object p4, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackground:Lcom/google/android/material/shape/MaterialShapeDrawable;

    invoke-virtual {p4}, Lcom/google/android/material/shape/MaterialShapeDrawable;->getTopRightCornerResolvedSize()F

    move-result p4

    cmpl-float p4, p4, p1

    if-nez p4, :cond_42

    iget-object p4, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackground:Lcom/google/android/material/shape/MaterialShapeDrawable;

    invoke-virtual {p4}, Lcom/google/android/material/shape/MaterialShapeDrawable;->getBottomLeftCornerResolvedSize()F

    move-result p4

    cmpl-float p4, p4, p2

    if-nez p4, :cond_42

    iget-object p4, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackground:Lcom/google/android/material/shape/MaterialShapeDrawable;

    invoke-virtual {p4}, Lcom/google/android/material/shape/MaterialShapeDrawable;->getBottomRightCornerResolvedSize()F

    move-result p4

    cmpl-float p4, p4, p3

    if-eqz p4, :cond_61

    :cond_42
    iget-object p4, p0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    invoke-virtual {p4}, Lcom/google/android/material/shape/ShapeAppearanceModel;->toBuilder()Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    move-result-object p4

    invoke-virtual {p4, v1}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->setTopLeftCornerSize(F)Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    move-result-object p4

    invoke-virtual {p4, p1}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->setTopRightCornerSize(F)Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    move-result-object p1

    invoke-virtual {p1, p2}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->setBottomLeftCornerSize(F)Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    move-result-object p1

    invoke-virtual {p1, p3}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->setBottomRightCornerSize(F)Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    move-result-object p1

    invoke-virtual {p1}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->build()Lcom/google/android/material/shape/ShapeAppearanceModel;

    move-result-object p1

    iput-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->applyBoxAttributes()V

    :cond_61
    return-void
.end method

.method public setBoxCornerRadiiResources(IIII)V
    .registers 6

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getDimension(I)F

    move-result p1

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p2}, Landroid/content/res/Resources;->getDimension(I)F

    move-result p2

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p4}, Landroid/content/res/Resources;->getDimension(I)F

    move-result p4

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p3}, Landroid/content/res/Resources;->getDimension(I)F

    move-result p3

    invoke-virtual {p0, p1, p2, p4, p3}, Lcom/google/android/material/textfield/TextInputLayout;->setBoxCornerRadii(FFFF)V

    return-void
.end method

.method public setBoxStrokeColor(I)V
    .registers 3

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->focusedStrokeColor:I

    if-eq v0, p1, :cond_9

    iput p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->focusedStrokeColor:I

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->updateTextInputBoxState()V

    :cond_9
    return-void
.end method

.method public setBoxStrokeColorStateList(Landroid/content/res/ColorStateList;)V
    .registers 5

    invoke-virtual {p1}, Landroid/content/res/ColorStateList;->isStateful()Z

    move-result v0

    if-eqz v0, :cond_34

    invoke-virtual {p1}, Landroid/content/res/ColorStateList;->getDefaultColor()I

    move-result v0

    iput v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->defaultStrokeColor:I

    const/4 v0, 0x1

    new-array v0, v0, [I

    const/4 v1, 0x0

    const v2, -0x101009e

    aput v2, v0, v1

    const/4 v1, -0x1

    invoke-virtual {p1, v0, v1}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    move-result v0

    iput v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->disabledColor:I

    const/4 v0, 0x2

    new-array v2, v0, [I

    fill-array-data v2, :array_46

    invoke-virtual {p1, v2, v1}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    move-result v2

    iput v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->hoveredStrokeColor:I

    new-array v0, v0, [I

    fill-array-data v0, :array_4e

    invoke-virtual {p1, v0, v1}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    move-result p1

    iput p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->focusedStrokeColor:I

    goto :goto_42

    :cond_34
    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->focusedStrokeColor:I

    invoke-virtual {p1}, Landroid/content/res/ColorStateList;->getDefaultColor()I

    move-result v1

    if-eq v0, v1, :cond_42

    invoke-virtual {p1}, Landroid/content/res/ColorStateList;->getDefaultColor()I

    move-result p1

    iput p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->focusedStrokeColor:I

    :cond_42
    :goto_42
    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->updateTextInputBoxState()V

    return-void

    :array_46
    .array-data 4
        0x1010367
        0x101009e
    .end array-data

    :array_4e
    .array-data 4
        0x101009c
        0x101009e
    .end array-data
.end method

.method public setBoxStrokeErrorColor(Landroid/content/res/ColorStateList;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->strokeErrorColor:Landroid/content/res/ColorStateList;

    if-eq v0, p1, :cond_9

    iput-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->strokeErrorColor:Landroid/content/res/ColorStateList;

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->updateTextInputBoxState()V

    :cond_9
    return-void
.end method

.method public setBoxStrokeWidth(I)V
    .registers 2

    iput p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeWidthDefaultPx:I

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->updateTextInputBoxState()V

    return-void
.end method

.method public setBoxStrokeWidthFocused(I)V
    .registers 2

    iput p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeWidthFocusedPx:I

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->updateTextInputBoxState()V

    return-void
.end method

.method public setBoxStrokeWidthFocusedResource(I)V
    .registers 3

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result p1

    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/TextInputLayout;->setBoxStrokeWidthFocused(I)V

    return-void
.end method

.method public setBoxStrokeWidthResource(I)V
    .registers 3

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result p1

    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/TextInputLayout;->setBoxStrokeWidth(I)V

    return-void
.end method

.method public setCounterEnabled(Z)V
    .registers 5

    iget-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterEnabled:Z

    if-eq v0, p1, :cond_55

    const/4 v0, 0x2

    if-eqz p1, :cond_49

    new-instance v1, Landroidx/appcompat/widget/AppCompatTextView;

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2}, Landroidx/appcompat/widget/AppCompatTextView;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterView:Landroid/widget/TextView;

    sget v2, Lcom/google/android/material/R$id;->textinput_counter:I

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setId(I)V

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->typeface:Landroid/graphics/Typeface;

    if-eqz v1, :cond_20

    iget-object v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterView:Landroid/widget/TextView;

    invoke-virtual {v2, v1}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    :cond_20
    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterView:Landroid/widget/TextView;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setMaxLines(I)V

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

    iget-object v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterView:Landroid/widget/TextView;

    invoke-virtual {v1, v2, v0}, Lcom/google/android/material/textfield/IndicatorViewController;->addIndicator(Landroid/widget/TextView;I)V

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterView:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup$MarginLayoutParams;

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/google/android/material/R$dimen;->mtrl_textinput_counter_margin_start:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v1

    invoke-static {v0, v1}, Landroidx/core/view/MarginLayoutParamsCompat;->setMarginStart(Landroid/view/ViewGroup$MarginLayoutParams;I)V

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->updateCounterTextAppearanceAndColor()V

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->updateCounter()V

    goto :goto_53

    :cond_49
    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

    iget-object v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterView:Landroid/widget/TextView;

    invoke-virtual {v1, v2, v0}, Lcom/google/android/material/textfield/IndicatorViewController;->removeIndicator(Landroid/widget/TextView;I)V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterView:Landroid/widget/TextView;

    :goto_53
    iput-boolean p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterEnabled:Z

    :cond_55
    return-void
.end method

.method public setCounterMaxLength(I)V
    .registers 3

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterMaxLength:I

    if-eq v0, p1, :cond_13

    if-lez p1, :cond_9

    iput p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterMaxLength:I

    goto :goto_c

    :cond_9
    const/4 p1, -0x1

    iput p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterMaxLength:I

    :goto_c
    iget-boolean p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterEnabled:Z

    if-eqz p1, :cond_13

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->updateCounter()V

    :cond_13
    return-void
.end method

.method public setCounterOverflowTextAppearance(I)V
    .registers 3

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterOverflowTextAppearance:I

    if-eq v0, p1, :cond_9

    iput p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterOverflowTextAppearance:I

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->updateCounterTextAppearanceAndColor()V

    :cond_9
    return-void
.end method

.method public setCounterOverflowTextColor(Landroid/content/res/ColorStateList;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterOverflowTextColor:Landroid/content/res/ColorStateList;

    if-eq v0, p1, :cond_9

    iput-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterOverflowTextColor:Landroid/content/res/ColorStateList;

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->updateCounterTextAppearanceAndColor()V

    :cond_9
    return-void
.end method

.method public setCounterTextAppearance(I)V
    .registers 3

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterTextAppearance:I

    if-eq v0, p1, :cond_9

    iput p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterTextAppearance:I

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->updateCounterTextAppearanceAndColor()V

    :cond_9
    return-void
.end method

.method public setCounterTextColor(Landroid/content/res/ColorStateList;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterTextColor:Landroid/content/res/ColorStateList;

    if-eq v0, p1, :cond_9

    iput-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterTextColor:Landroid/content/res/ColorStateList;

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->updateCounterTextAppearanceAndColor()V

    :cond_9
    return-void
.end method

.method public setDefaultHintTextColor(Landroid/content/res/ColorStateList;)V
    .registers 2

    iput-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->defaultHintTextColor:Landroid/content/res/ColorStateList;

    iput-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->focusedTextColor:Landroid/content/res/ColorStateList;

    iget-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    if-eqz p1, :cond_c

    const/4 p1, 0x0

    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/TextInputLayout;->updateLabelState(Z)V

    :cond_c
    return-void
.end method

.method public setEnabled(Z)V
    .registers 2

    invoke-static {p0, p1}, Lcom/google/android/material/textfield/TextInputLayout;->recursiveSetEnabled(Landroid/view/ViewGroup;Z)V

    invoke-super {p0, p1}, Landroid/widget/LinearLayout;->setEnabled(Z)V

    return-void
.end method

.method public setEndIconActivated(Z)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->setEndIconActivated(Z)V

    return-void
.end method

.method public setEndIconCheckable(Z)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->setEndIconCheckable(Z)V

    return-void
.end method

.method public setEndIconContentDescription(I)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->setEndIconContentDescription(I)V

    return-void
.end method

.method public setEndIconContentDescription(Ljava/lang/CharSequence;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->setEndIconContentDescription(Ljava/lang/CharSequence;)V

    return-void
.end method

.method public setEndIconDrawable(I)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->setEndIconDrawable(I)V

    return-void
.end method

.method public setEndIconDrawable(Landroid/graphics/drawable/Drawable;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->setEndIconDrawable(Landroid/graphics/drawable/Drawable;)V

    return-void
.end method

.method public setEndIconMinSize(I)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->setEndIconMinSize(I)V

    return-void
.end method

.method public setEndIconMode(I)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->setEndIconMode(I)V

    return-void
.end method

.method public setEndIconOnClickListener(Landroid/view/View$OnClickListener;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->setEndIconOnClickListener(Landroid/view/View$OnClickListener;)V

    return-void
.end method

.method public setEndIconOnLongClickListener(Landroid/view/View$OnLongClickListener;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->setEndIconOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    return-void
.end method

.method public setEndIconScaleType(Landroid/widget/ImageView$ScaleType;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->setEndIconScaleType(Landroid/widget/ImageView$ScaleType;)V

    return-void
.end method

.method public setEndIconTintList(Landroid/content/res/ColorStateList;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->setEndIconTintList(Landroid/content/res/ColorStateList;)V

    return-void
.end method

.method public setEndIconTintMode(Landroid/graphics/PorterDuff$Mode;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->setEndIconTintMode(Landroid/graphics/PorterDuff$Mode;)V

    return-void
.end method

.method public setEndIconVisible(Z)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->setEndIconVisible(Z)V

    return-void
.end method

.method public setError(Ljava/lang/CharSequence;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/IndicatorViewController;->isErrorEnabled()Z

    move-result v0

    if-nez v0, :cond_13

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_f

    return-void

    :cond_f
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/google/android/material/textfield/TextInputLayout;->setErrorEnabled(Z)V

    :cond_13
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1f

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/IndicatorViewController;->showError(Ljava/lang/CharSequence;)V

    goto :goto_24

    :cond_1f
    iget-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

    invoke-virtual {p1}, Lcom/google/android/material/textfield/IndicatorViewController;->hideError()V

    :goto_24
    return-void
.end method

.method public setErrorAccessibilityLiveRegion(I)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/IndicatorViewController;->setErrorAccessibilityLiveRegion(I)V

    return-void
.end method

.method public setErrorContentDescription(Ljava/lang/CharSequence;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/IndicatorViewController;->setErrorContentDescription(Ljava/lang/CharSequence;)V

    return-void
.end method

.method public setErrorEnabled(Z)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/IndicatorViewController;->setErrorEnabled(Z)V

    return-void
.end method

.method public setErrorIconDrawable(I)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->setErrorIconDrawable(I)V

    return-void
.end method

.method public setErrorIconDrawable(Landroid/graphics/drawable/Drawable;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->setErrorIconDrawable(Landroid/graphics/drawable/Drawable;)V

    return-void
.end method

.method public setErrorIconOnClickListener(Landroid/view/View$OnClickListener;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->setErrorIconOnClickListener(Landroid/view/View$OnClickListener;)V

    return-void
.end method

.method public setErrorIconOnLongClickListener(Landroid/view/View$OnLongClickListener;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->setErrorIconOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    return-void
.end method

.method public setErrorIconTintList(Landroid/content/res/ColorStateList;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->setErrorIconTintList(Landroid/content/res/ColorStateList;)V

    return-void
.end method

.method public setErrorIconTintMode(Landroid/graphics/PorterDuff$Mode;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->setErrorIconTintMode(Landroid/graphics/PorterDuff$Mode;)V

    return-void
.end method

.method public setErrorTextAppearance(I)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/IndicatorViewController;->setErrorTextAppearance(I)V

    return-void
.end method

.method public setErrorTextColor(Landroid/content/res/ColorStateList;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/IndicatorViewController;->setErrorViewTextColor(Landroid/content/res/ColorStateList;)V

    return-void
.end method

.method public setExpandedHintEnabled(Z)V
    .registers 3

    iget-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->expandedHintEnabled:Z

    if-eq v0, p1, :cond_a

    iput-boolean p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->expandedHintEnabled:Z

    const/4 p1, 0x0

    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/TextInputLayout;->updateLabelState(Z)V

    :cond_a
    return-void
.end method

.method public setHelperText(Ljava/lang/CharSequence;)V
    .registers 3

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_11

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->isHelperTextEnabled()Z

    move-result p1

    if-eqz p1, :cond_20

    const/4 p1, 0x0

    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/TextInputLayout;->setHelperTextEnabled(Z)V

    goto :goto_20

    :cond_11
    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->isHelperTextEnabled()Z

    move-result v0

    if-nez v0, :cond_1b

    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/google/android/material/textfield/TextInputLayout;->setHelperTextEnabled(Z)V

    :cond_1b
    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/IndicatorViewController;->showHelper(Ljava/lang/CharSequence;)V

    :cond_20
    :goto_20
    return-void
.end method

.method public setHelperTextColor(Landroid/content/res/ColorStateList;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/IndicatorViewController;->setHelperTextViewTextColor(Landroid/content/res/ColorStateList;)V

    return-void
.end method

.method public setHelperTextEnabled(Z)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/IndicatorViewController;->setHelperTextEnabled(Z)V

    return-void
.end method

.method public setHelperTextTextAppearance(I)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/IndicatorViewController;->setHelperTextAppearance(I)V

    return-void
.end method

.method public setHint(I)V
    .registers 3

    if-eqz p1, :cond_b

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getText(I)Ljava/lang/CharSequence;

    move-result-object p1

    goto :goto_c

    :cond_b
    const/4 p1, 0x0

    :goto_c
    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/TextInputLayout;->setHint(Ljava/lang/CharSequence;)V

    return-void
.end method

.method public setHint(Ljava/lang/CharSequence;)V
    .registers 3

    iget-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->hintEnabled:Z

    if-eqz v0, :cond_c

    invoke-direct {p0, p1}, Lcom/google/android/material/textfield/TextInputLayout;->setHintInternal(Ljava/lang/CharSequence;)V

    const/16 p1, 0x800

    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/TextInputLayout;->sendAccessibilityEvent(I)V

    :cond_c
    return-void
.end method

.method public setHintAnimationEnabled(Z)V
    .registers 2

    iput-boolean p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->hintAnimationEnabled:Z

    return-void
.end method

.method public setHintEnabled(Z)V
    .registers 4

    iget-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->hintEnabled:Z

    if-eq p1, v0, :cond_51

    iput-boolean p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->hintEnabled:Z

    const/4 v0, 0x0

    if-nez p1, :cond_2b

    const/4 p1, 0x0

    iput-boolean p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->isProvidingHint:Z

    iget-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->hint:Ljava/lang/CharSequence;

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result p1

    if-nez p1, :cond_27

    iget-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {p1}, Landroid/widget/EditText;->getHint()Ljava/lang/CharSequence;

    move-result-object p1

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result p1

    if-eqz p1, :cond_27

    iget-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->hint:Ljava/lang/CharSequence;

    invoke-virtual {p1, v1}, Landroid/widget/EditText;->setHint(Ljava/lang/CharSequence;)V

    :cond_27
    invoke-direct {p0, v0}, Lcom/google/android/material/textfield/TextInputLayout;->setHintInternal(Ljava/lang/CharSequence;)V

    goto :goto_4a

    :cond_2b
    iget-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {p1}, Landroid/widget/EditText;->getHint()Ljava/lang/CharSequence;

    move-result-object p1

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_47

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->hint:Ljava/lang/CharSequence;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_42

    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/TextInputLayout;->setHint(Ljava/lang/CharSequence;)V

    :cond_42
    iget-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {p1, v0}, Landroid/widget/EditText;->setHint(Ljava/lang/CharSequence;)V

    :cond_47
    const/4 p1, 0x1

    iput-boolean p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->isProvidingHint:Z

    :goto_4a
    iget-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    if-eqz p1, :cond_51

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->updateInputLayoutMargins()V

    :cond_51
    return-void
.end method

.method public setHintTextAppearance(I)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    invoke-virtual {v0, p1}, Lcom/google/android/material/internal/CollapsingTextHelper;->setCollapsedTextAppearance(I)V

    iget-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    invoke-virtual {p1}, Lcom/google/android/material/internal/CollapsingTextHelper;->getCollapsedTextColor()Landroid/content/res/ColorStateList;

    move-result-object p1

    iput-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->focusedTextColor:Landroid/content/res/ColorStateList;

    iget-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    if-eqz p1, :cond_18

    const/4 p1, 0x0

    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/TextInputLayout;->updateLabelState(Z)V

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->updateInputLayoutMargins()V

    :cond_18
    return-void
.end method

.method public setHintTextColor(Landroid/content/res/ColorStateList;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->focusedTextColor:Landroid/content/res/ColorStateList;

    if-eq v0, p1, :cond_17

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->defaultHintTextColor:Landroid/content/res/ColorStateList;

    if-nez v0, :cond_d

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    invoke-virtual {v0, p1}, Lcom/google/android/material/internal/CollapsingTextHelper;->setCollapsedTextColor(Landroid/content/res/ColorStateList;)V

    :cond_d
    iput-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->focusedTextColor:Landroid/content/res/ColorStateList;

    iget-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    if-eqz p1, :cond_17

    const/4 p1, 0x0

    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/TextInputLayout;->updateLabelState(Z)V

    :cond_17
    return-void
.end method

.method public setLengthCounter(Lcom/google/android/material/textfield/TextInputLayout$LengthCounter;)V
    .registers 2

    iput-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->lengthCounter:Lcom/google/android/material/textfield/TextInputLayout$LengthCounter;

    return-void
.end method

.method public setMaxEms(I)V
    .registers 4

    iput p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->maxEms:I

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    if-eqz v0, :cond_c

    const/4 v1, -0x1

    if-eq p1, v1, :cond_c

    invoke-virtual {v0, p1}, Landroid/widget/EditText;->setMaxEms(I)V

    :cond_c
    return-void
.end method

.method public setMaxWidth(I)V
    .registers 4

    iput p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->maxWidth:I

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    if-eqz v0, :cond_c

    const/4 v1, -0x1

    if-eq p1, v1, :cond_c

    invoke-virtual {v0, p1}, Landroid/widget/EditText;->setMaxWidth(I)V

    :cond_c
    return-void
.end method

.method public setMaxWidthResource(I)V
    .registers 3

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result p1

    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/TextInputLayout;->setMaxWidth(I)V

    return-void
.end method

.method public setMinEms(I)V
    .registers 4

    iput p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->minEms:I

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    if-eqz v0, :cond_c

    const/4 v1, -0x1

    if-eq p1, v1, :cond_c

    invoke-virtual {v0, p1}, Landroid/widget/EditText;->setMinEms(I)V

    :cond_c
    return-void
.end method

.method public setMinWidth(I)V
    .registers 4

    iput p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->minWidth:I

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    if-eqz v0, :cond_c

    const/4 v1, -0x1

    if-eq p1, v1, :cond_c

    invoke-virtual {v0, p1}, Landroid/widget/EditText;->setMinWidth(I)V

    :cond_c
    return-void
.end method

.method public setMinWidthResource(I)V
    .registers 3

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result p1

    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/TextInputLayout;->setMinWidth(I)V

    return-void
.end method

.method public setPasswordVisibilityToggleContentDescription(I)V
    .registers 3
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->setPasswordVisibilityToggleContentDescription(I)V

    return-void
.end method

.method public setPasswordVisibilityToggleContentDescription(Ljava/lang/CharSequence;)V
    .registers 3
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->setPasswordVisibilityToggleContentDescription(Ljava/lang/CharSequence;)V

    return-void
.end method

.method public setPasswordVisibilityToggleDrawable(I)V
    .registers 3
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->setPasswordVisibilityToggleDrawable(I)V

    return-void
.end method

.method public setPasswordVisibilityToggleDrawable(Landroid/graphics/drawable/Drawable;)V
    .registers 3
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->setPasswordVisibilityToggleDrawable(Landroid/graphics/drawable/Drawable;)V

    return-void
.end method

.method public setPasswordVisibilityToggleEnabled(Z)V
    .registers 3
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->setPasswordVisibilityToggleEnabled(Z)V

    return-void
.end method

.method public setPasswordVisibilityToggleTintList(Landroid/content/res/ColorStateList;)V
    .registers 3
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->setPasswordVisibilityToggleTintList(Landroid/content/res/ColorStateList;)V

    return-void
.end method

.method public setPasswordVisibilityToggleTintMode(Landroid/graphics/PorterDuff$Mode;)V
    .registers 3
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->setPasswordVisibilityToggleTintMode(Landroid/graphics/PorterDuff$Mode;)V

    return-void
.end method

.method public setPlaceholderText(Ljava/lang/CharSequence;)V
    .registers 5

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderTextView:Landroid/widget/TextView;

    if-nez v0, :cond_35

    new-instance v0, Landroidx/appcompat/widget/AppCompatTextView;

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Landroidx/appcompat/widget/AppCompatTextView;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderTextView:Landroid/widget/TextView;

    sget v1, Lcom/google/android/material/R$id;->textinput_placeholder:I

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setId(I)V

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderTextView:Landroid/widget/TextView;

    const/4 v1, 0x2

    invoke-static {v0, v1}, Landroidx/core/view/ViewCompat;->setImportantForAccessibility(Landroid/view/View;I)V

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->createPlaceholderFadeTransition()Landroidx/transition/Fade;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderFadeIn:Landroidx/transition/Fade;

    const-wide/16 v1, 0x43

    invoke-virtual {v0, v1, v2}, Landroidx/transition/Fade;->setStartDelay(J)Landroidx/transition/Transition;

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->createPlaceholderFadeTransition()Landroidx/transition/Fade;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderFadeOut:Landroidx/transition/Fade;

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderTextAppearance:I

    invoke-virtual {p0, v0}, Lcom/google/android/material/textfield/TextInputLayout;->setPlaceholderTextAppearance(I)V

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderTextColor:Landroid/content/res/ColorStateList;

    invoke-virtual {p0, v0}, Lcom/google/android/material/textfield/TextInputLayout;->setPlaceholderTextColor(Landroid/content/res/ColorStateList;)V

    :cond_35
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_40

    const/4 p1, 0x0

    invoke-direct {p0, p1}, Lcom/google/android/material/textfield/TextInputLayout;->setPlaceholderTextEnabled(Z)V

    goto :goto_4a

    :cond_40
    iget-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderEnabled:Z

    if-nez v0, :cond_48

    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/google/android/material/textfield/TextInputLayout;->setPlaceholderTextEnabled(Z)V

    :cond_48
    iput-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderText:Ljava/lang/CharSequence;

    :goto_4a
    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->updatePlaceholderText()V

    return-void
.end method

.method public setPlaceholderTextAppearance(I)V
    .registers 3

    iput p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderTextAppearance:I

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderTextView:Landroid/widget/TextView;

    if-eqz v0, :cond_9

    invoke-static {v0, p1}, Landroidx/core/widget/TextViewCompat;->setTextAppearance(Landroid/widget/TextView;I)V

    :cond_9
    return-void
.end method

.method public setPlaceholderTextColor(Landroid/content/res/ColorStateList;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderTextColor:Landroid/content/res/ColorStateList;

    if-eq v0, p1, :cond_f

    iput-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderTextColor:Landroid/content/res/ColorStateList;

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->placeholderTextView:Landroid/widget/TextView;

    if-eqz v0, :cond_f

    if-eqz p1, :cond_f

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setTextColor(Landroid/content/res/ColorStateList;)V

    :cond_f
    return-void
.end method

.method public setPrefixText(Ljava/lang/CharSequence;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/StartCompoundLayout;->setPrefixText(Ljava/lang/CharSequence;)V

    return-void
.end method

.method public setPrefixTextAppearance(I)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/StartCompoundLayout;->setPrefixTextAppearance(I)V

    return-void
.end method

.method public setPrefixTextColor(Landroid/content/res/ColorStateList;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/StartCompoundLayout;->setPrefixTextColor(Landroid/content/res/ColorStateList;)V

    return-void
.end method

.method public setShapeAppearanceModel(Lcom/google/android/material/shape/ShapeAppearanceModel;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackground:Lcom/google/android/material/shape/MaterialShapeDrawable;

    if-eqz v0, :cond_f

    invoke-virtual {v0}, Lcom/google/android/material/shape/MaterialShapeDrawable;->getShapeAppearanceModel()Lcom/google/android/material/shape/ShapeAppearanceModel;

    move-result-object v0

    if-eq v0, p1, :cond_f

    iput-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->applyBoxAttributes()V

    :cond_f
    return-void
.end method

.method public setStartIconCheckable(Z)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/StartCompoundLayout;->setStartIconCheckable(Z)V

    return-void
.end method

.method public setStartIconContentDescription(I)V
    .registers 3

    if-eqz p1, :cond_b

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getText(I)Ljava/lang/CharSequence;

    move-result-object p1

    goto :goto_c

    :cond_b
    const/4 p1, 0x0

    :goto_c
    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/TextInputLayout;->setStartIconContentDescription(Ljava/lang/CharSequence;)V

    return-void
.end method

.method public setStartIconContentDescription(Ljava/lang/CharSequence;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/StartCompoundLayout;->setStartIconContentDescription(Ljava/lang/CharSequence;)V

    return-void
.end method

.method public setStartIconDrawable(I)V
    .registers 3

    if-eqz p1, :cond_b

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p1}, Landroidx/appcompat/content/res/AppCompatResources;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object p1

    goto :goto_c

    :cond_b
    const/4 p1, 0x0

    :goto_c
    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/TextInputLayout;->setStartIconDrawable(Landroid/graphics/drawable/Drawable;)V

    return-void
.end method

.method public setStartIconDrawable(Landroid/graphics/drawable/Drawable;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/StartCompoundLayout;->setStartIconDrawable(Landroid/graphics/drawable/Drawable;)V

    return-void
.end method

.method public setStartIconMinSize(I)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/StartCompoundLayout;->setStartIconMinSize(I)V

    return-void
.end method

.method public setStartIconOnClickListener(Landroid/view/View$OnClickListener;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/StartCompoundLayout;->setStartIconOnClickListener(Landroid/view/View$OnClickListener;)V

    return-void
.end method

.method public setStartIconOnLongClickListener(Landroid/view/View$OnLongClickListener;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/StartCompoundLayout;->setStartIconOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    return-void
.end method

.method public setStartIconScaleType(Landroid/widget/ImageView$ScaleType;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/StartCompoundLayout;->setStartIconScaleType(Landroid/widget/ImageView$ScaleType;)V

    return-void
.end method

.method public setStartIconTintList(Landroid/content/res/ColorStateList;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/StartCompoundLayout;->setStartIconTintList(Landroid/content/res/ColorStateList;)V

    return-void
.end method

.method public setStartIconTintMode(Landroid/graphics/PorterDuff$Mode;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/StartCompoundLayout;->setStartIconTintMode(Landroid/graphics/PorterDuff$Mode;)V

    return-void
.end method

.method public setStartIconVisible(Z)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/StartCompoundLayout;->setStartIconVisible(Z)V

    return-void
.end method

.method public setSuffixText(Ljava/lang/CharSequence;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->setSuffixText(Ljava/lang/CharSequence;)V

    return-void
.end method

.method public setSuffixTextAppearance(I)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->setSuffixTextAppearance(I)V

    return-void
.end method

.method public setSuffixTextColor(Landroid/content/res/ColorStateList;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/EndCompoundLayout;->setSuffixTextColor(Landroid/content/res/ColorStateList;)V

    return-void
.end method

.method setTextAppearanceCompatWithErrorFallback(Landroid/widget/TextView;I)V
    .registers 5

    const/4 v0, 0x1

    :try_start_1
    invoke-static {p1, p2}, Landroidx/core/widget/TextViewCompat;->setTextAppearance(Landroid/widget/TextView;I)V

    invoke-virtual {p1}, Landroid/widget/TextView;->getTextColors()Landroid/content/res/ColorStateList;

    move-result-object p2

    invoke-virtual {p2}, Landroid/content/res/ColorStateList;->getDefaultColor()I

    move-result p2
    :try_end_c
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_c} :catch_14

    const v1, -0xff01

    if-ne p2, v1, :cond_12

    goto :goto_14

    :cond_12
    const/4 p2, 0x0

    move v0, p2

    :catch_14
    :goto_14
    if-eqz v0, :cond_28

    sget p2, Lcom/google/android/material/R$style;->TextAppearance_AppCompat_Caption:I

    invoke-static {p1, p2}, Landroidx/core/widget/TextViewCompat;->setTextAppearance(Landroid/widget/TextView;I)V

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getContext()Landroid/content/Context;

    move-result-object p2

    sget v0, Lcom/google/android/material/R$color;->design_error:I

    invoke-static {p2, v0}, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context;I)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/widget/TextView;->setTextColor(I)V

    :cond_28
    return-void
.end method

.method public setTextInputAccessibilityDelegate(Lcom/google/android/material/textfield/TextInputLayout$AccessibilityDelegate;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    if-eqz v0, :cond_7

    invoke-static {v0, p1}, Landroidx/core/view/ViewCompat;->setAccessibilityDelegate(Landroid/view/View;Landroidx/core/view/AccessibilityDelegateCompat;)V

    :cond_7
    return-void
.end method

.method public setTypeface(Landroid/graphics/Typeface;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->typeface:Landroid/graphics/Typeface;

    if-eq p1, v0, :cond_17

    iput-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->typeface:Landroid/graphics/Typeface;

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->collapsingTextHelper:Lcom/google/android/material/internal/CollapsingTextHelper;

    invoke-virtual {v0, p1}, Lcom/google/android/material/internal/CollapsingTextHelper;->setTypefaces(Landroid/graphics/Typeface;)V

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

    invoke-virtual {v0, p1}, Lcom/google/android/material/textfield/IndicatorViewController;->setTypefaces(Landroid/graphics/Typeface;)V

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterView:Landroid/widget/TextView;

    if-eqz v0, :cond_17

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    :cond_17
    return-void
.end method

.method shouldShowError()Z
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/IndicatorViewController;->errorShouldBeShown()Z

    move-result v0

    return v0
.end method

.method updateCounter(Landroid/text/Editable;)V
    .registers 10

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->lengthCounter:Lcom/google/android/material/textfield/TextInputLayout$LengthCounter;

    invoke-interface {v0, p1}, Lcom/google/android/material/textfield/TextInputLayout$LengthCounter;->countLength(Landroid/text/Editable;)I

    move-result p1

    iget-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterOverflowed:Z

    iget v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterMaxLength:I

    const/4 v2, -0x1

    const/4 v3, 0x0

    if-ne v1, v2, :cond_20

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterView:Landroid/widget/TextView;

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v1, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    iget-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterView:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    iput-boolean v3, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterOverflowed:Z

    goto :goto_64

    :cond_20
    const/4 v2, 0x1

    if-le p1, v1, :cond_25

    move v1, v2

    goto :goto_26

    :cond_25
    move v1, v3

    :goto_26
    iput-boolean v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterOverflowed:Z

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v4, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterView:Landroid/widget/TextView;

    iget v5, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterMaxLength:I

    iget-boolean v6, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterOverflowed:Z

    invoke-static {v1, v4, p1, v5, v6}, Lcom/google/android/material/textfield/TextInputLayout;->updateCounterContentDescription(Landroid/content/Context;Landroid/widget/TextView;IIZ)V

    iget-boolean v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterOverflowed:Z

    if-eq v0, v1, :cond_3c

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->updateCounterTextAppearanceAndColor()V

    :cond_3c
    invoke-static {}, Landroidx/core/text/BidiFormatter;->getInstance()Landroidx/core/text/BidiFormatter;

    move-result-object v1

    iget-object v4, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterView:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getContext()Landroid/content/Context;

    move-result-object v5

    sget v6, Lcom/google/android/material/R$string;->character_counter_pattern:I

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    aput-object p1, v7, v3

    iget p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterMaxLength:I

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    aput-object p1, v7, v2

    invoke-virtual {v5, v6, v7}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v1, p1}, Landroidx/core/text/BidiFormatter;->unicodeWrap(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v4, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :goto_64
    iget-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    if-eqz p1, :cond_75

    iget-boolean p1, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterOverflowed:Z

    if-eq v0, p1, :cond_75

    invoke-virtual {p0, v3}, Lcom/google/android/material/textfield/TextInputLayout;->updateLabelState(Z)V

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->updateTextInputBoxState()V

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->updateEditTextBackground()V

    :cond_75
    return-void
.end method

.method updateDummyDrawables()Z
    .registers 11

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    const/4 v1, 0x0

    if-nez v0, :cond_6

    return v1

    :cond_6
    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->shouldUpdateStartDummyDrawable()Z

    move-result v0

    const/4 v2, 0x0

    const/4 v3, 0x2

    const/4 v4, 0x3

    const/4 v5, 0x1

    if-eqz v0, :cond_49

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/StartCompoundLayout;->getMeasuredWidth()I

    move-result v0

    iget-object v6, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {v6}, Landroid/widget/EditText;->getPaddingLeft()I

    move-result v6

    sub-int/2addr v0, v6

    iget-object v6, p0, Lcom/google/android/material/textfield/TextInputLayout;->startDummyDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v6, :cond_25

    iget v6, p0, Lcom/google/android/material/textfield/TextInputLayout;->startDummyDrawableWidth:I

    if-eq v6, v0, :cond_31

    :cond_25
    new-instance v6, Landroid/graphics/drawable/ColorDrawable;

    invoke-direct {v6}, Landroid/graphics/drawable/ColorDrawable;-><init>()V

    iput-object v6, p0, Lcom/google/android/material/textfield/TextInputLayout;->startDummyDrawable:Landroid/graphics/drawable/Drawable;

    iput v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->startDummyDrawableWidth:I

    invoke-virtual {v6, v1, v1, v0, v5}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    :cond_31
    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-static {v0}, Landroidx/core/widget/TextViewCompat;->getCompoundDrawablesRelative(Landroid/widget/TextView;)[Landroid/graphics/drawable/Drawable;

    move-result-object v0

    aget-object v6, v0, v1

    iget-object v7, p0, Lcom/google/android/material/textfield/TextInputLayout;->startDummyDrawable:Landroid/graphics/drawable/Drawable;

    if-eq v6, v7, :cond_62

    iget-object v6, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    aget-object v8, v0, v5

    aget-object v9, v0, v3

    aget-object v0, v0, v4

    invoke-static {v6, v7, v8, v9, v0}, Landroidx/core/widget/TextViewCompat;->setCompoundDrawablesRelative(Landroid/widget/TextView;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    goto :goto_60

    :cond_49
    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->startDummyDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_62

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-static {v0}, Landroidx/core/widget/TextViewCompat;->getCompoundDrawablesRelative(Landroid/widget/TextView;)[Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iget-object v6, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    aget-object v7, v0, v5

    aget-object v8, v0, v3

    aget-object v0, v0, v4

    invoke-static {v6, v2, v7, v8, v0}, Landroidx/core/widget/TextViewCompat;->setCompoundDrawablesRelative(Landroid/widget/TextView;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    iput-object v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->startDummyDrawable:Landroid/graphics/drawable/Drawable;

    :goto_60
    move v0, v5

    goto :goto_63

    :cond_62
    move v0, v1

    :goto_63
    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->shouldUpdateEndDummyDrawable()Z

    move-result v6

    if-eqz v6, :cond_d7

    iget-object v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v2}, Lcom/google/android/material/textfield/EndCompoundLayout;->getSuffixTextView()Landroid/widget/TextView;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/TextView;->getMeasuredWidth()I

    move-result v2

    iget-object v6, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {v6}, Landroid/widget/EditText;->getPaddingRight()I

    move-result v6

    sub-int/2addr v2, v6

    iget-object v6, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v6}, Lcom/google/android/material/textfield/EndCompoundLayout;->getCurrentEndIconView()Lcom/google/android/material/internal/CheckableImageButton;

    move-result-object v6

    if-eqz v6, :cond_92

    invoke-virtual {v6}, Landroid/view/View;->getMeasuredWidth()I

    move-result v7

    add-int/2addr v2, v7

    invoke-virtual {v6}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v6

    check-cast v6, Landroid/view/ViewGroup$MarginLayoutParams;

    invoke-static {v6}, Landroidx/core/view/MarginLayoutParamsCompat;->getMarginStart(Landroid/view/ViewGroup$MarginLayoutParams;)I

    move-result v6

    add-int/2addr v2, v6

    :cond_92
    iget-object v6, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-static {v6}, Landroidx/core/widget/TextViewCompat;->getCompoundDrawablesRelative(Landroid/widget/TextView;)[Landroid/graphics/drawable/Drawable;

    move-result-object v6

    iget-object v7, p0, Lcom/google/android/material/textfield/TextInputLayout;->endDummyDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v7, :cond_b3

    iget v8, p0, Lcom/google/android/material/textfield/TextInputLayout;->endDummyDrawableWidth:I

    if-eq v8, v2, :cond_b3

    iput v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->endDummyDrawableWidth:I

    invoke-virtual {v7, v1, v1, v2, v5}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    aget-object v1, v6, v1

    aget-object v2, v6, v5

    iget-object v3, p0, Lcom/google/android/material/textfield/TextInputLayout;->endDummyDrawable:Landroid/graphics/drawable/Drawable;

    aget-object v4, v6, v4

    invoke-static {v0, v1, v2, v3, v4}, Landroidx/core/widget/TextViewCompat;->setCompoundDrawablesRelative(Landroid/widget/TextView;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    goto :goto_f8

    :cond_b3
    if-nez v7, :cond_c1

    new-instance v7, Landroid/graphics/drawable/ColorDrawable;

    invoke-direct {v7}, Landroid/graphics/drawable/ColorDrawable;-><init>()V

    iput-object v7, p0, Lcom/google/android/material/textfield/TextInputLayout;->endDummyDrawable:Landroid/graphics/drawable/Drawable;

    iput v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->endDummyDrawableWidth:I

    invoke-virtual {v7, v1, v1, v2, v5}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    :cond_c1
    aget-object v2, v6, v3

    iget-object v3, p0, Lcom/google/android/material/textfield/TextInputLayout;->endDummyDrawable:Landroid/graphics/drawable/Drawable;

    if-eq v2, v3, :cond_d5

    iput-object v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->originalEditTextEndDrawable:Landroid/graphics/drawable/Drawable;

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    aget-object v1, v6, v1

    aget-object v2, v6, v5

    aget-object v4, v6, v4

    invoke-static {v0, v1, v2, v3, v4}, Landroidx/core/widget/TextViewCompat;->setCompoundDrawablesRelative(Landroid/widget/TextView;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    goto :goto_f8

    :cond_d5
    move v5, v0

    goto :goto_f8

    :cond_d7
    iget-object v6, p0, Lcom/google/android/material/textfield/TextInputLayout;->endDummyDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v6, :cond_f9

    iget-object v6, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-static {v6}, Landroidx/core/widget/TextViewCompat;->getCompoundDrawablesRelative(Landroid/widget/TextView;)[Landroid/graphics/drawable/Drawable;

    move-result-object v6

    aget-object v3, v6, v3

    iget-object v7, p0, Lcom/google/android/material/textfield/TextInputLayout;->endDummyDrawable:Landroid/graphics/drawable/Drawable;

    if-ne v3, v7, :cond_f5

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    aget-object v1, v6, v1

    aget-object v3, v6, v5

    iget-object v7, p0, Lcom/google/android/material/textfield/TextInputLayout;->originalEditTextEndDrawable:Landroid/graphics/drawable/Drawable;

    aget-object v4, v6, v4

    invoke-static {v0, v1, v3, v7, v4}, Landroidx/core/widget/TextViewCompat;->setCompoundDrawablesRelative(Landroid/widget/TextView;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    goto :goto_f6

    :cond_f5
    move v5, v0

    :goto_f6
    iput-object v2, p0, Lcom/google/android/material/textfield/TextInputLayout;->endDummyDrawable:Landroid/graphics/drawable/Drawable;

    :goto_f8
    move v0, v5

    :cond_f9
    return v0
.end method

.method updateEditTextBackground()V
    .registers 4

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    if-eqz v0, :cond_4c

    iget v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundMode:I

    if-eqz v1, :cond_9

    goto :goto_4c

    :cond_9
    invoke-virtual {v0}, Landroid/widget/EditText;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    if-nez v0, :cond_10

    return-void

    :cond_10
    invoke-static {v0}, Landroidx/appcompat/widget/DrawableUtils;->canSafelyMutateDrawable(Landroid/graphics/drawable/Drawable;)Z

    move-result v1

    if-eqz v1, :cond_1a

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    :cond_1a
    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->shouldShowError()Z

    move-result v1

    if-eqz v1, :cond_2e

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getErrorCurrentTextColors()I

    move-result v1

    sget-object v2, Landroid/graphics/PorterDuff$Mode;->SRC_IN:Landroid/graphics/PorterDuff$Mode;

    invoke-static {v1, v2}, Landroidx/appcompat/widget/AppCompatDrawableManager;->getPorterDuffColorFilter(ILandroid/graphics/PorterDuff$Mode;)Landroid/graphics/PorterDuffColorFilter;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setColorFilter(Landroid/graphics/ColorFilter;)V

    goto :goto_4c

    :cond_2e
    iget-boolean v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterOverflowed:Z

    if-eqz v1, :cond_44

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterView:Landroid/widget/TextView;

    if-eqz v1, :cond_44

    invoke-virtual {v1}, Landroid/widget/TextView;->getCurrentTextColor()I

    move-result v1

    sget-object v2, Landroid/graphics/PorterDuff$Mode;->SRC_IN:Landroid/graphics/PorterDuff$Mode;

    invoke-static {v1, v2}, Landroidx/appcompat/widget/AppCompatDrawableManager;->getPorterDuffColorFilter(ILandroid/graphics/PorterDuff$Mode;)Landroid/graphics/PorterDuffColorFilter;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setColorFilter(Landroid/graphics/ColorFilter;)V

    goto :goto_4c

    :cond_44
    invoke-static {v0}, Landroidx/core/graphics/drawable/DrawableCompat;->clearColorFilter(Landroid/graphics/drawable/Drawable;)V

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->refreshDrawableState()V

    :cond_4c
    :goto_4c
    return-void
.end method

.method updateEditTextBoxBackgroundIfNeeded()V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    if-eqz v0, :cond_23

    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackground:Lcom/google/android/material/shape/MaterialShapeDrawable;

    if-eqz v1, :cond_23

    iget-boolean v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundApplied:Z

    if-nez v1, :cond_12

    invoke-virtual {v0}, Landroid/widget/EditText;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    if-nez v0, :cond_23

    :cond_12
    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundMode:I

    if-nez v0, :cond_17

    goto :goto_23

    :cond_17
    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getEditTextBoxBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-static {v0, v1}, Landroidx/core/view/ViewCompat;->setBackground(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundApplied:Z

    :cond_23
    :goto_23
    return-void
.end method

.method updateLabelState(Z)V
    .registers 3

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/google/android/material/textfield/TextInputLayout;->updateLabelState(ZZ)V

    return-void
.end method

.method updateTextInputBoxState()V
    .registers 7

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackground:Lcom/google/android/material/shape/MaterialShapeDrawable;

    if-eqz v0, :cond_e2

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundMode:I

    if-nez v0, :cond_a

    goto/16 :goto_e2

    :cond_a
    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->isFocused()Z

    move-result v0

    const/4 v1, 0x0

    const/4 v2, 0x1

    if-nez v0, :cond_1f

    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    if-eqz v0, :cond_1d

    invoke-virtual {v0}, Landroid/widget/EditText;->hasFocus()Z

    move-result v0

    if-eqz v0, :cond_1d

    goto :goto_1f

    :cond_1d
    move v0, v1

    goto :goto_20

    :cond_1f
    :goto_1f
    move v0, v2

    :goto_20
    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->isHovered()Z

    move-result v3

    if-nez v3, :cond_33

    iget-object v3, p0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    if-eqz v3, :cond_31

    invoke-virtual {v3}, Landroid/widget/EditText;->isHovered()Z

    move-result v3

    if-eqz v3, :cond_31

    goto :goto_33

    :cond_31
    move v3, v1

    goto :goto_34

    :cond_33
    :goto_33
    move v3, v2

    :goto_34
    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->shouldShowError()Z

    move-result v4

    if-nez v4, :cond_42

    iget-object v4, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterView:Landroid/widget/TextView;

    if-eqz v4, :cond_43

    iget-boolean v4, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterOverflowed:Z

    if-eqz v4, :cond_43

    :cond_42
    move v1, v2

    :cond_43
    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->isEnabled()Z

    move-result v4

    if-nez v4, :cond_4e

    iget v4, p0, Lcom/google/android/material/textfield/TextInputLayout;->disabledColor:I

    iput v4, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeColor:I

    goto :goto_8c

    :cond_4e
    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->shouldShowError()Z

    move-result v4

    if-eqz v4, :cond_63

    iget-object v4, p0, Lcom/google/android/material/textfield/TextInputLayout;->strokeErrorColor:Landroid/content/res/ColorStateList;

    if-eqz v4, :cond_5c

    invoke-direct {p0, v0, v3}, Lcom/google/android/material/textfield/TextInputLayout;->updateStrokeErrorColor(ZZ)V

    goto :goto_8c

    :cond_5c
    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->getErrorCurrentTextColors()I

    move-result v4

    iput v4, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeColor:I

    goto :goto_8c

    :cond_63
    iget-boolean v4, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterOverflowed:Z

    if-eqz v4, :cond_7a

    iget-object v4, p0, Lcom/google/android/material/textfield/TextInputLayout;->counterView:Landroid/widget/TextView;

    if-eqz v4, :cond_7a

    iget-object v5, p0, Lcom/google/android/material/textfield/TextInputLayout;->strokeErrorColor:Landroid/content/res/ColorStateList;

    if-eqz v5, :cond_73

    invoke-direct {p0, v0, v3}, Lcom/google/android/material/textfield/TextInputLayout;->updateStrokeErrorColor(ZZ)V

    goto :goto_8c

    :cond_73
    invoke-virtual {v4}, Landroid/widget/TextView;->getCurrentTextColor()I

    move-result v4

    iput v4, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeColor:I

    goto :goto_8c

    :cond_7a
    if-eqz v0, :cond_81

    iget v4, p0, Lcom/google/android/material/textfield/TextInputLayout;->focusedStrokeColor:I

    iput v4, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeColor:I

    goto :goto_8c

    :cond_81
    if-eqz v3, :cond_88

    iget v4, p0, Lcom/google/android/material/textfield/TextInputLayout;->hoveredStrokeColor:I

    iput v4, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeColor:I

    goto :goto_8c

    :cond_88
    iget v4, p0, Lcom/google/android/material/textfield/TextInputLayout;->defaultStrokeColor:I

    iput v4, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeColor:I

    :goto_8c
    sget v4, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v5, 0x1d

    if-lt v4, v5, :cond_95

    invoke-direct {p0, v1}, Lcom/google/android/material/textfield/TextInputLayout;->updateCursorColor(Z)V

    :cond_95
    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;

    invoke-virtual {v1}, Lcom/google/android/material/textfield/EndCompoundLayout;->onTextInputBoxStateUpdated()V

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->refreshStartIconDrawableState()V

    iget v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundMode:I

    const/4 v4, 0x2

    if-ne v1, v4, :cond_bc

    iget v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeWidthPx:I

    if-eqz v0, :cond_b1

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->isEnabled()Z

    move-result v4

    if-eqz v4, :cond_b1

    iget v4, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeWidthFocusedPx:I

    iput v4, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeWidthPx:I

    goto :goto_b5

    :cond_b1
    iget v4, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeWidthDefaultPx:I

    iput v4, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeWidthPx:I

    :goto_b5
    iget v4, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxStrokeWidthPx:I

    if-eq v4, v1, :cond_bc

    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->recalculateCutout()V

    :cond_bc
    iget v1, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundMode:I

    if-ne v1, v2, :cond_df

    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputLayout;->isEnabled()Z

    move-result v1

    if-nez v1, :cond_cb

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->disabledFilledBackgroundColor:I

    iput v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundColor:I

    goto :goto_df

    :cond_cb
    if-eqz v3, :cond_d4

    if-nez v0, :cond_d4

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->hoveredFilledBackgroundColor:I

    iput v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundColor:I

    goto :goto_df

    :cond_d4
    if-eqz v0, :cond_db

    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->focusedFilledBackgroundColor:I

    iput v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundColor:I

    goto :goto_df

    :cond_db
    iget v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->defaultFilledBackgroundColor:I

    iput v0, p0, Lcom/google/android/material/textfield/TextInputLayout;->boxBackgroundColor:I

    :cond_df
    :goto_df
    invoke-direct {p0}, Lcom/google/android/material/textfield/TextInputLayout;->applyBoxAttributes()V

    :cond_e2
    :goto_e2
    return-void
.end method
