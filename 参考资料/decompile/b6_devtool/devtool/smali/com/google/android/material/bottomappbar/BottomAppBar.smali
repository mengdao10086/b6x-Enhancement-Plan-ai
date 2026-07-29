.class public Lcom/google/android/material/bottomappbar/BottomAppBar;
.super Landroidx/appcompat/widget/Toolbar;
.source "BottomAppBar.java"

# interfaces
.implements Landroidx/coordinatorlayout/widget/CoordinatorLayout$AttachedBehavior;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/material/bottomappbar/BottomAppBar$SavedState;,
        Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;,
        Lcom/google/android/material/bottomappbar/BottomAppBar$AnimationListener;,
        Lcom/google/android/material/bottomappbar/BottomAppBar$MenuAlignmentMode;,
        Lcom/google/android/material/bottomappbar/BottomAppBar$FabAnimationMode;,
        Lcom/google/android/material/bottomappbar/BottomAppBar$FabAnchorMode;,
        Lcom/google/android/material/bottomappbar/BottomAppBar$FabAlignmentMode;
    }
.end annotation


# static fields
.field private static final DEF_STYLE_RES:I

.field private static final FAB_ALIGNMENT_ANIM_DURATION_ATTR:I

.field private static final FAB_ALIGNMENT_ANIM_DURATION_DEFAULT:I = 0x12c

.field private static final FAB_ALIGNMENT_ANIM_EASING_ATTR:I

.field private static final FAB_ALIGNMENT_ANIM_EASING_MIDPOINT:F = 0.2f

.field public static final FAB_ALIGNMENT_MODE_CENTER:I = 0x0

.field public static final FAB_ALIGNMENT_MODE_END:I = 0x1

.field public static final FAB_ANCHOR_MODE_CRADLE:I = 0x1

.field public static final FAB_ANCHOR_MODE_EMBED:I = 0x0

.field public static final FAB_ANIMATION_MODE_SCALE:I = 0x0

.field public static final FAB_ANIMATION_MODE_SLIDE:I = 0x1

.field public static final MENU_ALIGNMENT_MODE_AUTO:I = 0x0

.field public static final MENU_ALIGNMENT_MODE_START:I = 0x1

.field private static final NO_FAB_END_MARGIN:I = -0x1

.field private static final NO_MENU_RES_ID:I


# instance fields
.field private animatingModeChangeCounter:I

.field private animationListeners:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Lcom/google/android/material/bottomappbar/BottomAppBar$AnimationListener;",
            ">;"
        }
    .end annotation
.end field

.field private behavior:Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;

.field private bottomInset:I

.field private fabAlignmentMode:I

.field private fabAlignmentModeEndMargin:I

.field private fabAnchorMode:I

.field fabAnimationListener:Landroid/animation/AnimatorListenerAdapter;

.field private fabAnimationMode:I

.field private fabAttached:Z

.field private final fabOffsetEndMode:I

.field fabTransformationCallback:Lcom/google/android/material/animation/TransformationCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/material/animation/TransformationCallback<",
            "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;",
            ">;"
        }
    .end annotation
.end field

.field private hideOnScroll:Z

.field private leftInset:I

.field private final materialShapeDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

.field private menuAlignmentMode:I

.field private menuAnimatingWithFabAlignmentMode:Z

.field private menuAnimator:Landroid/animation/Animator;

.field private modeAnimator:Landroid/animation/Animator;

.field private navigationIconTint:Ljava/lang/Integer;

.field private final paddingBottomSystemWindowInsets:Z

.field private final paddingLeftSystemWindowInsets:Z

.field private final paddingRightSystemWindowInsets:Z

.field private pendingMenuResId:I

.field private final removeEmbeddedFabElevation:Z

.field private rightInset:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    sget v0, Lcom/google/android/material/R$style;->Widget_MaterialComponents_BottomAppBar:I

    sput v0, Lcom/google/android/material/bottomappbar/BottomAppBar;->DEF_STYLE_RES:I

    sget v0, Lcom/google/android/material/R$attr;->motionDurationLong2:I

    sput v0, Lcom/google/android/material/bottomappbar/BottomAppBar;->FAB_ALIGNMENT_ANIM_DURATION_ATTR:I

    sget v0, Lcom/google/android/material/R$attr;->motionEasingEmphasizedInterpolator:I

    sput v0, Lcom/google/android/material/bottomappbar/BottomAppBar;->FAB_ALIGNMENT_ANIM_EASING_ATTR:I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .registers 3

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/google/android/material/bottomappbar/BottomAppBar;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 4

    sget v0, Lcom/google/android/material/R$attr;->bottomAppBarStyle:I

    invoke-direct {p0, p1, p2, v0}, Lcom/google/android/material/bottomappbar/BottomAppBar;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .registers 16

    sget v6, Lcom/google/android/material/bottomappbar/BottomAppBar;->DEF_STYLE_RES:I

    invoke-static {p1, p2, p3, v6}, Lcom/google/android/material/theme/overlay/MaterialThemeOverlay;->wrap(Landroid/content/Context;Landroid/util/AttributeSet;II)Landroid/content/Context;

    move-result-object p1

    invoke-direct {p0, p1, p2, p3}, Landroidx/appcompat/widget/Toolbar;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    new-instance p1, Lcom/google/android/material/shape/MaterialShapeDrawable;

    invoke-direct {p1}, Lcom/google/android/material/shape/MaterialShapeDrawable;-><init>()V

    iput-object p1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->materialShapeDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    const/4 v7, 0x0

    iput v7, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->animatingModeChangeCounter:I

    iput v7, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->pendingMenuResId:I

    iput-boolean v7, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->menuAnimatingWithFabAlignmentMode:Z

    const/4 v8, 0x1

    iput-boolean v8, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAttached:Z

    new-instance v0, Lcom/google/android/material/bottomappbar/BottomAppBar$1;

    invoke-direct {v0, p0}, Lcom/google/android/material/bottomappbar/BottomAppBar$1;-><init>(Lcom/google/android/material/bottomappbar/BottomAppBar;)V

    iput-object v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAnimationListener:Landroid/animation/AnimatorListenerAdapter;

    new-instance v0, Lcom/google/android/material/bottomappbar/BottomAppBar$2;

    invoke-direct {v0, p0}, Lcom/google/android/material/bottomappbar/BottomAppBar$2;-><init>(Lcom/google/android/material/bottomappbar/BottomAppBar;)V

    iput-object v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabTransformationCallback:Lcom/google/android/material/animation/TransformationCallback;

    invoke-virtual {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getContext()Landroid/content/Context;

    move-result-object v9

    sget-object v2, Lcom/google/android/material/R$styleable;->BottomAppBar:[I

    new-array v5, v7, [I

    move-object v0, v9

    move-object v1, p2

    move v3, p3

    move v4, v6

    invoke-static/range {v0 .. v5}, Lcom/google/android/material/internal/ThemeEnforcement;->obtainStyledAttributes(Landroid/content/Context;Landroid/util/AttributeSet;[III[I)Landroid/content/res/TypedArray;

    move-result-object v0

    sget v1, Lcom/google/android/material/R$styleable;->BottomAppBar_backgroundTint:I

    invoke-static {v9, v0, v1}, Lcom/google/android/material/resources/MaterialResources;->getColorStateList(Landroid/content/Context;Landroid/content/res/TypedArray;I)Landroid/content/res/ColorStateList;

    move-result-object v1

    sget v2, Lcom/google/android/material/R$styleable;->BottomAppBar_navigationIconTint:I

    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v2

    const/4 v3, -0x1

    if-eqz v2, :cond_50

    sget v2, Lcom/google/android/material/R$styleable;->BottomAppBar_navigationIconTint:I

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v2

    invoke-virtual {p0, v2}, Lcom/google/android/material/bottomappbar/BottomAppBar;->setNavigationIconTint(I)V

    :cond_50
    sget v2, Lcom/google/android/material/R$styleable;->BottomAppBar_elevation:I

    invoke-virtual {v0, v2, v7}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v2

    sget v4, Lcom/google/android/material/R$styleable;->BottomAppBar_fabCradleMargin:I

    invoke-virtual {v0, v4, v7}, Landroid/content/res/TypedArray;->getDimensionPixelOffset(II)I

    move-result v4

    int-to-float v4, v4

    sget v5, Lcom/google/android/material/R$styleable;->BottomAppBar_fabCradleRoundedCornerRadius:I

    invoke-virtual {v0, v5, v7}, Landroid/content/res/TypedArray;->getDimensionPixelOffset(II)I

    move-result v5

    int-to-float v5, v5

    sget v10, Lcom/google/android/material/R$styleable;->BottomAppBar_fabCradleVerticalOffset:I

    invoke-virtual {v0, v10, v7}, Landroid/content/res/TypedArray;->getDimensionPixelOffset(II)I

    move-result v10

    int-to-float v10, v10

    sget v11, Lcom/google/android/material/R$styleable;->BottomAppBar_fabAlignmentMode:I

    invoke-virtual {v0, v11, v7}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v11

    iput v11, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAlignmentMode:I

    sget v11, Lcom/google/android/material/R$styleable;->BottomAppBar_fabAnimationMode:I

    invoke-virtual {v0, v11, v7}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v11

    iput v11, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAnimationMode:I

    sget v11, Lcom/google/android/material/R$styleable;->BottomAppBar_fabAnchorMode:I

    invoke-virtual {v0, v11, v8}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v11

    iput v11, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAnchorMode:I

    sget v11, Lcom/google/android/material/R$styleable;->BottomAppBar_removeEmbeddedFabElevation:I

    invoke-virtual {v0, v11, v8}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v11

    iput-boolean v11, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->removeEmbeddedFabElevation:Z

    sget v11, Lcom/google/android/material/R$styleable;->BottomAppBar_menuAlignmentMode:I

    invoke-virtual {v0, v11, v7}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v11

    iput v11, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->menuAlignmentMode:I

    sget v11, Lcom/google/android/material/R$styleable;->BottomAppBar_hideOnScroll:I

    invoke-virtual {v0, v11, v7}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v11

    iput-boolean v11, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->hideOnScroll:Z

    sget v11, Lcom/google/android/material/R$styleable;->BottomAppBar_paddingBottomSystemWindowInsets:I

    invoke-virtual {v0, v11, v7}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v11

    iput-boolean v11, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->paddingBottomSystemWindowInsets:Z

    sget v11, Lcom/google/android/material/R$styleable;->BottomAppBar_paddingLeftSystemWindowInsets:I

    invoke-virtual {v0, v11, v7}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v11

    iput-boolean v11, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->paddingLeftSystemWindowInsets:Z

    sget v11, Lcom/google/android/material/R$styleable;->BottomAppBar_paddingRightSystemWindowInsets:I

    invoke-virtual {v0, v11, v7}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v11

    iput-boolean v11, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->paddingRightSystemWindowInsets:Z

    sget v11, Lcom/google/android/material/R$styleable;->BottomAppBar_fabAlignmentModeEndMargin:I

    invoke-virtual {v0, v11, v3}, Landroid/content/res/TypedArray;->getDimensionPixelOffset(II)I

    move-result v3

    iput v3, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAlignmentModeEndMargin:I

    sget v3, Lcom/google/android/material/R$styleable;->BottomAppBar_addElevationShadow:I

    invoke-virtual {v0, v3, v8}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v3

    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    invoke-virtual {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v11, Lcom/google/android/material/R$dimen;->mtrl_bottomappbar_fabOffsetEndMode:I

    invoke-virtual {v0, v11}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v0

    iput v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabOffsetEndMode:I

    new-instance v0, Lcom/google/android/material/bottomappbar/BottomAppBarTopEdgeTreatment;

    invoke-direct {v0, v4, v5, v10}, Lcom/google/android/material/bottomappbar/BottomAppBarTopEdgeTreatment;-><init>(FFF)V

    invoke-static {}, Lcom/google/android/material/shape/ShapeAppearanceModel;->builder()Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    move-result-object v4

    invoke-virtual {v4, v0}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->setTopEdge(Lcom/google/android/material/shape/EdgeTreatment;)Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->build()Lcom/google/android/material/shape/ShapeAppearanceModel;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/google/android/material/shape/MaterialShapeDrawable;->setShapeAppearanceModel(Lcom/google/android/material/shape/ShapeAppearanceModel;)V

    if-eqz v3, :cond_eb

    const/4 v0, 0x2

    invoke-virtual {p1, v0}, Lcom/google/android/material/shape/MaterialShapeDrawable;->setShadowCompatibilityMode(I)V

    goto :goto_fa

    :cond_eb
    invoke-virtual {p1, v8}, Lcom/google/android/material/shape/MaterialShapeDrawable;->setShadowCompatibilityMode(I)V

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x1c

    if-lt v0, v3, :cond_fa

    invoke-virtual {p0, v7}, Lcom/google/android/material/bottomappbar/BottomAppBar;->setOutlineAmbientShadowColor(I)V

    invoke-virtual {p0, v7}, Lcom/google/android/material/bottomappbar/BottomAppBar;->setOutlineSpotShadowColor(I)V

    :cond_fa
    :goto_fa
    sget-object v0, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {p1, v0}, Lcom/google/android/material/shape/MaterialShapeDrawable;->setPaintStyle(Landroid/graphics/Paint$Style;)V

    invoke-virtual {p1, v9}, Lcom/google/android/material/shape/MaterialShapeDrawable;->initializeElevationOverlay(Landroid/content/Context;)V

    int-to-float v0, v2

    invoke-virtual {p0, v0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->setElevation(F)V

    invoke-static {p1, v1}, Landroidx/core/graphics/drawable/DrawableCompat;->setTintList(Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;)V

    invoke-static {p0, p1}, Landroidx/core/view/ViewCompat;->setBackground(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V

    new-instance p1, Lcom/google/android/material/bottomappbar/BottomAppBar$3;

    invoke-direct {p1, p0}, Lcom/google/android/material/bottomappbar/BottomAppBar$3;-><init>(Lcom/google/android/material/bottomappbar/BottomAppBar;)V

    invoke-static {p0, p2, p3, v6, p1}, Lcom/google/android/material/internal/ViewUtils;->doOnApplyWindowInsets(Landroid/view/View;Landroid/util/AttributeSet;IILcom/google/android/material/internal/ViewUtils$OnApplyWindowInsetsListener;)V

    return-void
.end method

.method static synthetic access$000(Lcom/google/android/material/bottomappbar/BottomAppBar;)Z
    .registers 1

    iget-boolean p0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->menuAnimatingWithFabAlignmentMode:Z

    return p0
.end method

.method static synthetic access$002(Lcom/google/android/material/bottomappbar/BottomAppBar;Z)Z
    .registers 2

    iput-boolean p1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->menuAnimatingWithFabAlignmentMode:Z

    return p1
.end method

.method static synthetic access$100(Lcom/google/android/material/bottomappbar/BottomAppBar;)I
    .registers 1

    iget p0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAlignmentMode:I

    return p0
.end method

.method static synthetic access$1000(Lcom/google/android/material/bottomappbar/BottomAppBar;)I
    .registers 1

    iget p0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->leftInset:I

    return p0
.end method

.method static synthetic access$1002(Lcom/google/android/material/bottomappbar/BottomAppBar;I)I
    .registers 2

    iput p1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->leftInset:I

    return p1
.end method

.method static synthetic access$1100(Lcom/google/android/material/bottomappbar/BottomAppBar;)Z
    .registers 1

    iget-boolean p0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->paddingRightSystemWindowInsets:Z

    return p0
.end method

.method static synthetic access$1200(Lcom/google/android/material/bottomappbar/BottomAppBar;)I
    .registers 1

    iget p0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->rightInset:I

    return p0
.end method

.method static synthetic access$1202(Lcom/google/android/material/bottomappbar/BottomAppBar;I)I
    .registers 2

    iput p1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->rightInset:I

    return p1
.end method

.method static synthetic access$1300(Lcom/google/android/material/bottomappbar/BottomAppBar;)V
    .registers 1

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->cancelAnimations()V

    return-void
.end method

.method static synthetic access$1400(Lcom/google/android/material/bottomappbar/BottomAppBar;)V
    .registers 1

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->setCutoutStateAndTranslateFab()V

    return-void
.end method

.method static synthetic access$1500(Lcom/google/android/material/bottomappbar/BottomAppBar;)V
    .registers 1

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->setActionMenuViewPosition()V

    return-void
.end method

.method static synthetic access$1600(Lcom/google/android/material/bottomappbar/BottomAppBar;)V
    .registers 1

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->dispatchAnimationStart()V

    return-void
.end method

.method static synthetic access$1700(Lcom/google/android/material/bottomappbar/BottomAppBar;)V
    .registers 1

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->dispatchAnimationEnd()V

    return-void
.end method

.method static synthetic access$1802(Lcom/google/android/material/bottomappbar/BottomAppBar;Landroid/animation/Animator;)Landroid/animation/Animator;
    .registers 2

    iput-object p1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->modeAnimator:Landroid/animation/Animator;

    return-object p1
.end method

.method static synthetic access$1900(Lcom/google/android/material/bottomappbar/BottomAppBar;I)F
    .registers 2

    invoke-direct {p0, p1}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getFabTranslationX(I)F

    move-result p0

    return p0
.end method

.method static synthetic access$200(Lcom/google/android/material/bottomappbar/BottomAppBar;)Z
    .registers 1

    iget-boolean p0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAttached:Z

    return p0
.end method

.method static synthetic access$2002(Lcom/google/android/material/bottomappbar/BottomAppBar;Landroid/animation/Animator;)Landroid/animation/Animator;
    .registers 2

    iput-object p1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->menuAnimator:Landroid/animation/Animator;

    return-object p1
.end method

.method static synthetic access$2100(Lcom/google/android/material/bottomappbar/BottomAppBar;)I
    .registers 1

    iget p0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->pendingMenuResId:I

    return p0
.end method

.method static synthetic access$2200(Lcom/google/android/material/bottomappbar/BottomAppBar;Landroidx/appcompat/widget/ActionMenuView;IZZ)V
    .registers 5

    invoke-direct {p0, p1, p2, p3, p4}, Lcom/google/android/material/bottomappbar/BottomAppBar;->translateActionMenuView(Landroidx/appcompat/widget/ActionMenuView;IZZ)V

    return-void
.end method

.method static synthetic access$2300(Lcom/google/android/material/bottomappbar/BottomAppBar;)Lcom/google/android/material/floatingactionbutton/FloatingActionButton;
    .registers 1

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->findDependentFab()Lcom/google/android/material/floatingactionbutton/FloatingActionButton;

    move-result-object p0

    return-object p0
.end method

.method static synthetic access$2400(Lcom/google/android/material/bottomappbar/BottomAppBar;)F
    .registers 1

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getFabTranslationX()F

    move-result p0

    return p0
.end method

.method static synthetic access$2800(Lcom/google/android/material/bottomappbar/BottomAppBar;)I
    .registers 1

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getBottomInset()I

    move-result p0

    return p0
.end method

.method static synthetic access$2900(Lcom/google/android/material/bottomappbar/BottomAppBar;)I
    .registers 1

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getLeftInset()I

    move-result p0

    return p0
.end method

.method static synthetic access$300(Lcom/google/android/material/bottomappbar/BottomAppBar;IZ)V
    .registers 3

    invoke-direct {p0, p1, p2}, Lcom/google/android/material/bottomappbar/BottomAppBar;->maybeAnimateMenuView(IZ)V

    return-void
.end method

.method static synthetic access$3000(Lcom/google/android/material/bottomappbar/BottomAppBar;)I
    .registers 1

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getRightInset()I

    move-result p0

    return p0
.end method

.method static synthetic access$3100(Lcom/google/android/material/bottomappbar/BottomAppBar;)I
    .registers 1

    iget p0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabOffsetEndMode:I

    return p0
.end method

.method static synthetic access$3200(Lcom/google/android/material/bottomappbar/BottomAppBar;)Landroid/view/View;
    .registers 1

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->findDependentView()Landroid/view/View;

    move-result-object p0

    return-object p0
.end method

.method static synthetic access$3300(Lcom/google/android/material/bottomappbar/BottomAppBar;Landroid/view/View;)V
    .registers 2

    invoke-static {p0, p1}, Lcom/google/android/material/bottomappbar/BottomAppBar;->updateFabAnchorGravity(Lcom/google/android/material/bottomappbar/BottomAppBar;Landroid/view/View;)V

    return-void
.end method

.method static synthetic access$3400(Lcom/google/android/material/bottomappbar/BottomAppBar;)Z
    .registers 1

    iget-boolean p0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->removeEmbeddedFabElevation:Z

    return p0
.end method

.method static synthetic access$3500(Lcom/google/android/material/bottomappbar/BottomAppBar;Lcom/google/android/material/floatingactionbutton/FloatingActionButton;)V
    .registers 2

    invoke-direct {p0, p1}, Lcom/google/android/material/bottomappbar/BottomAppBar;->addFabAnimationListeners(Lcom/google/android/material/floatingactionbutton/FloatingActionButton;)V

    return-void
.end method

.method static synthetic access$400(Lcom/google/android/material/bottomappbar/BottomAppBar;)I
    .registers 1

    iget p0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAnchorMode:I

    return p0
.end method

.method static synthetic access$500(Lcom/google/android/material/bottomappbar/BottomAppBar;)Lcom/google/android/material/shape/MaterialShapeDrawable;
    .registers 1

    iget-object p0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->materialShapeDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    return-object p0
.end method

.method static synthetic access$600(Lcom/google/android/material/bottomappbar/BottomAppBar;)Lcom/google/android/material/bottomappbar/BottomAppBarTopEdgeTreatment;
    .registers 1

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getTopEdgeTreatment()Lcom/google/android/material/bottomappbar/BottomAppBarTopEdgeTreatment;

    move-result-object p0

    return-object p0
.end method

.method static synthetic access$700(Lcom/google/android/material/bottomappbar/BottomAppBar;)Z
    .registers 1

    iget-boolean p0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->paddingBottomSystemWindowInsets:Z

    return p0
.end method

.method static synthetic access$802(Lcom/google/android/material/bottomappbar/BottomAppBar;I)I
    .registers 2

    iput p1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->bottomInset:I

    return p1
.end method

.method static synthetic access$900(Lcom/google/android/material/bottomappbar/BottomAppBar;)Z
    .registers 1

    iget-boolean p0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->paddingLeftSystemWindowInsets:Z

    return p0
.end method

.method private addFabAnimationListeners(Lcom/google/android/material/floatingactionbutton/FloatingActionButton;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAnimationListener:Landroid/animation/AnimatorListenerAdapter;

    invoke-virtual {p1, v0}, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;->addOnHideAnimationListener(Landroid/animation/Animator$AnimatorListener;)V

    new-instance v0, Lcom/google/android/material/bottomappbar/BottomAppBar$9;

    invoke-direct {v0, p0}, Lcom/google/android/material/bottomappbar/BottomAppBar$9;-><init>(Lcom/google/android/material/bottomappbar/BottomAppBar;)V

    invoke-virtual {p1, v0}, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;->addOnShowAnimationListener(Landroid/animation/Animator$AnimatorListener;)V

    iget-object v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabTransformationCallback:Lcom/google/android/material/animation/TransformationCallback;

    invoke-virtual {p1, v0}, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;->addTransformationCallback(Lcom/google/android/material/animation/TransformationCallback;)V

    return-void
.end method

.method private cancelAnimations()V
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->menuAnimator:Landroid/animation/Animator;

    if-eqz v0, :cond_7

    invoke-virtual {v0}, Landroid/animation/Animator;->cancel()V

    :cond_7
    iget-object v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->modeAnimator:Landroid/animation/Animator;

    if-eqz v0, :cond_e

    invoke-virtual {v0}, Landroid/animation/Animator;->cancel()V

    :cond_e
    return-void
.end method

.method private createFabTranslationXAnimation(ILjava/util/List;)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/List<",
            "Landroid/animation/Animator;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->findDependentFab()Lcom/google/android/material/floatingactionbutton/FloatingActionButton;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [F

    const/4 v2, 0x0

    invoke-direct {p0, p1}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getFabTranslationX(I)F

    move-result p1

    aput p1, v1, v2

    const-string p1, "translationX"

    invoke-static {v0, p1, v1}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object p1

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getFabAlignmentAnimationDuration()I

    move-result v0

    int-to-long v0, v0

    invoke-virtual {p1, v0, v1}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    invoke-interface {p2, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method private createMenuViewTranslationAnimation(IZLjava/util/List;)V
    .registers 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(IZ",
            "Ljava/util/List<",
            "Landroid/animation/Animator;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getActionMenuView()Landroidx/appcompat/widget/ActionMenuView;

    move-result-object v0

    if-nez v0, :cond_7

    return-void

    :cond_7
    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getFabAlignmentAnimationDuration()I

    move-result v1

    int-to-float v1, v1

    const/4 v2, 0x1

    new-array v3, v2, [F

    const/4 v4, 0x0

    const/high16 v5, 0x3f800000    # 1.0f

    aput v5, v3, v4

    const-string v6, "alpha"

    invoke-static {v0, v6, v3}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v3

    const v7, 0x3f4ccccd    # 0.8f

    mul-float/2addr v7, v1

    float-to-long v7, v7

    invoke-virtual {v3, v7, v8}, Landroid/animation/Animator;->setDuration(J)Landroid/animation/Animator;

    invoke-virtual {v0}, Landroidx/appcompat/widget/ActionMenuView;->getTranslationX()F

    move-result v7

    invoke-virtual {p0, v0, p1, p2}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getActionMenuViewTranslationX(Landroidx/appcompat/widget/ActionMenuView;IZ)I

    move-result v8

    int-to-float v8, v8

    sub-float/2addr v7, v8

    invoke-static {v7}, Ljava/lang/Math;->abs(F)F

    move-result v7

    cmpl-float v7, v7, v5

    if-lez v7, :cond_60

    new-array v5, v2, [F

    const/4 v7, 0x0

    aput v7, v5, v4

    invoke-static {v0, v6, v5}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v5

    const v6, 0x3e4ccccd    # 0.2f

    mul-float/2addr v1, v6

    float-to-long v6, v1

    invoke-virtual {v5, v6, v7}, Landroid/animation/Animator;->setDuration(J)Landroid/animation/Animator;

    new-instance v1, Lcom/google/android/material/bottomappbar/BottomAppBar$7;

    invoke-direct {v1, p0, v0, p1, p2}, Lcom/google/android/material/bottomappbar/BottomAppBar$7;-><init>(Lcom/google/android/material/bottomappbar/BottomAppBar;Landroidx/appcompat/widget/ActionMenuView;IZ)V

    invoke-virtual {v5, v1}, Landroid/animation/Animator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    new-instance p1, Landroid/animation/AnimatorSet;

    invoke-direct {p1}, Landroid/animation/AnimatorSet;-><init>()V

    const/4 p2, 0x2

    new-array p2, p2, [Landroid/animation/Animator;

    aput-object v5, p2, v4

    aput-object v3, p2, v2

    invoke-virtual {p1, p2}, Landroid/animation/AnimatorSet;->playSequentially([Landroid/animation/Animator;)V

    invoke-interface {p3, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_6b

    :cond_60
    invoke-virtual {v0}, Landroidx/appcompat/widget/ActionMenuView;->getAlpha()F

    move-result p1

    cmpg-float p1, p1, v5

    if-gez p1, :cond_6b

    invoke-interface {p3, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_6b
    :goto_6b
    return-void
.end method

.method private dispatchAnimationEnd()V
    .registers 3

    iget v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->animatingModeChangeCounter:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->animatingModeChangeCounter:I

    if-nez v0, :cond_20

    iget-object v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->animationListeners:Ljava/util/ArrayList;

    if-eqz v0, :cond_20

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_10
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_20

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/material/bottomappbar/BottomAppBar$AnimationListener;

    invoke-interface {v1, p0}, Lcom/google/android/material/bottomappbar/BottomAppBar$AnimationListener;->onAnimationEnd(Lcom/google/android/material/bottomappbar/BottomAppBar;)V

    goto :goto_10

    :cond_20
    return-void
.end method

.method private dispatchAnimationStart()V
    .registers 3

    iget v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->animatingModeChangeCounter:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->animatingModeChangeCounter:I

    if-nez v0, :cond_20

    iget-object v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->animationListeners:Ljava/util/ArrayList;

    if-eqz v0, :cond_20

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_10
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_20

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/material/bottomappbar/BottomAppBar$AnimationListener;

    invoke-interface {v1, p0}, Lcom/google/android/material/bottomappbar/BottomAppBar$AnimationListener;->onAnimationStart(Lcom/google/android/material/bottomappbar/BottomAppBar;)V

    goto :goto_10

    :cond_20
    return-void
.end method

.method private findDependentFab()Lcom/google/android/material/floatingactionbutton/FloatingActionButton;
    .registers 3

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->findDependentView()Landroid/view/View;

    move-result-object v0

    instance-of v1, v0, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;

    if-eqz v1, :cond_b

    check-cast v0, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;

    goto :goto_c

    :cond_b
    const/4 v0, 0x0

    :goto_c
    return-object v0
.end method

.method private findDependentView()Landroid/view/View;
    .registers 5

    invoke-virtual {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    instance-of v0, v0, Landroidx/coordinatorlayout/widget/CoordinatorLayout;

    const/4 v1, 0x0

    if-nez v0, :cond_a

    return-object v1

    :cond_a
    invoke-virtual {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroidx/coordinatorlayout/widget/CoordinatorLayout;

    invoke-virtual {v0, p0}, Landroidx/coordinatorlayout/widget/CoordinatorLayout;->getDependents(Landroid/view/View;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_18
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2d

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/View;

    instance-of v3, v2, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;

    if-nez v3, :cond_2c

    instance-of v3, v2, Lcom/google/android/material/floatingactionbutton/ExtendedFloatingActionButton;

    if-eqz v3, :cond_18

    :cond_2c
    return-object v2

    :cond_2d
    return-object v1
.end method

.method private getActionMenuView()Landroidx/appcompat/widget/ActionMenuView;
    .registers 4

    const/4 v0, 0x0

    :goto_1
    invoke-virtual {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getChildCount()I

    move-result v1

    if-ge v0, v1, :cond_15

    invoke-virtual {p0, v0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    instance-of v2, v1, Landroidx/appcompat/widget/ActionMenuView;

    if-eqz v2, :cond_12

    check-cast v1, Landroidx/appcompat/widget/ActionMenuView;

    return-object v1

    :cond_12
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_15
    const/4 v0, 0x0

    return-object v0
.end method

.method private getBottomInset()I
    .registers 2

    iget v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->bottomInset:I

    return v0
.end method

.method private getFabAlignmentAnimationDuration()I
    .registers 4

    invoke-virtual {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getContext()Landroid/content/Context;

    move-result-object v0

    sget v1, Lcom/google/android/material/bottomappbar/BottomAppBar;->FAB_ALIGNMENT_ANIM_DURATION_ATTR:I

    const/16 v2, 0x12c

    invoke-static {v0, v1, v2}, Lcom/google/android/material/motion/MotionUtils;->resolveThemeDuration(Landroid/content/Context;II)I

    move-result v0

    return v0
.end method

.method private getFabTranslationX()F
    .registers 2

    iget v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAlignmentMode:I

    invoke-direct {p0, v0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getFabTranslationX(I)F

    move-result v0

    return v0
.end method

.method private getFabTranslationX(I)F
    .registers 7

    invoke-static {p0}, Lcom/google/android/material/internal/ViewUtils;->isLayoutRtl(Landroid/view/View;)Z

    move-result v0

    const/4 v1, 0x1

    if-ne p1, v1, :cond_33

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->findDependentView()Landroid/view/View;

    move-result-object p1

    if-eqz v0, :cond_10

    iget v2, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->leftInset:I

    goto :goto_12

    :cond_10
    iget v2, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->rightInset:I

    :goto_12
    iget v3, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAlignmentModeEndMargin:I

    const/4 v4, -0x1

    if-eq v3, v4, :cond_23

    if-eqz p1, :cond_23

    invoke-virtual {p1}, Landroid/view/View;->getMeasuredWidth()I

    move-result p1

    div-int/lit8 p1, p1, 0x2

    iget v3, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAlignmentModeEndMargin:I

    add-int/2addr p1, v3

    goto :goto_25

    :cond_23
    iget p1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabOffsetEndMode:I

    :goto_25
    add-int/2addr v2, p1

    invoke-virtual {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getMeasuredWidth()I

    move-result p1

    div-int/lit8 p1, p1, 0x2

    sub-int/2addr p1, v2

    if-eqz v0, :cond_30

    move v1, v4

    :cond_30
    mul-int/2addr p1, v1

    int-to-float p1, p1

    return p1

    :cond_33
    const/4 p1, 0x0

    return p1
.end method

.method private getFabTranslationY()F
    .registers 3

    iget v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAnchorMode:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_f

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getTopEdgeTreatment()Lcom/google/android/material/bottomappbar/BottomAppBarTopEdgeTreatment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/material/bottomappbar/BottomAppBarTopEdgeTreatment;->getCradleVerticalOffset()F

    move-result v0

    neg-float v0, v0

    return v0

    :cond_f
    const/4 v0, 0x0

    return v0
.end method

.method private getLeftInset()I
    .registers 2

    iget v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->leftInset:I

    return v0
.end method

.method private getRightInset()I
    .registers 2

    iget v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->rightInset:I

    return v0
.end method

.method private getTopEdgeTreatment()Lcom/google/android/material/bottomappbar/BottomAppBarTopEdgeTreatment;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->materialShapeDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    invoke-virtual {v0}, Lcom/google/android/material/shape/MaterialShapeDrawable;->getShapeAppearanceModel()Lcom/google/android/material/shape/ShapeAppearanceModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/material/shape/ShapeAppearanceModel;->getTopEdge()Lcom/google/android/material/shape/EdgeTreatment;

    move-result-object v0

    check-cast v0, Lcom/google/android/material/bottomappbar/BottomAppBarTopEdgeTreatment;

    return-object v0
.end method

.method private isFabVisibleOrWillBeShown()Z
    .registers 2

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->findDependentFab()Lcom/google/android/material/floatingactionbutton/FloatingActionButton;

    move-result-object v0

    if-eqz v0, :cond_e

    invoke-virtual {v0}, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;->isOrWillBeShown()Z

    move-result v0

    if-eqz v0, :cond_e

    const/4 v0, 0x1

    goto :goto_f

    :cond_e
    const/4 v0, 0x0

    :goto_f
    return v0
.end method

.method static synthetic lambda$onLayout$0(Landroid/view/View;)V
    .registers 1

    invoke-virtual {p0}, Landroid/view/View;->requestLayout()V

    return-void
.end method

.method private maybeAnimateMenuView(IZ)V
    .registers 6

    invoke-static {p0}, Landroidx/core/view/ViewCompat;->isLaidOut(Landroid/view/View;)Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_f

    iput-boolean v1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->menuAnimatingWithFabAlignmentMode:Z

    iget p1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->pendingMenuResId:I

    invoke-virtual {p0, p1}, Lcom/google/android/material/bottomappbar/BottomAppBar;->replaceMenu(I)V

    return-void

    :cond_f
    iget-object v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->menuAnimator:Landroid/animation/Animator;

    if-eqz v0, :cond_16

    invoke-virtual {v0}, Landroid/animation/Animator;->cancel()V

    :cond_16
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->isFabVisibleOrWillBeShown()Z

    move-result v2

    if-nez v2, :cond_23

    move p1, v1

    move p2, p1

    :cond_23
    invoke-direct {p0, p1, p2, v0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->createMenuViewTranslationAnimation(IZLjava/util/List;)V

    new-instance p1, Landroid/animation/AnimatorSet;

    invoke-direct {p1}, Landroid/animation/AnimatorSet;-><init>()V

    invoke-virtual {p1, v0}, Landroid/animation/AnimatorSet;->playTogether(Ljava/util/Collection;)V

    iput-object p1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->menuAnimator:Landroid/animation/Animator;

    new-instance p2, Lcom/google/android/material/bottomappbar/BottomAppBar$6;

    invoke-direct {p2, p0}, Lcom/google/android/material/bottomappbar/BottomAppBar$6;-><init>(Lcom/google/android/material/bottomappbar/BottomAppBar;)V

    invoke-virtual {p1, p2}, Landroid/animation/Animator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    iget-object p1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->menuAnimator:Landroid/animation/Animator;

    invoke-virtual {p1}, Landroid/animation/Animator;->start()V

    return-void
.end method

.method private maybeAnimateModeChange(I)V
    .registers 5

    iget v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAlignmentMode:I

    if-eq v0, p1, :cond_49

    invoke-static {p0}, Landroidx/core/view/ViewCompat;->isLaidOut(Landroid/view/View;)Z

    move-result v0

    if-nez v0, :cond_b

    goto :goto_49

    :cond_b
    iget-object v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->modeAnimator:Landroid/animation/Animator;

    if-eqz v0, :cond_12

    invoke-virtual {v0}, Landroid/animation/Animator;->cancel()V

    :cond_12
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iget v1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAnimationMode:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_20

    invoke-direct {p0, p1, v0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->createFabTranslationXAnimation(ILjava/util/List;)V

    goto :goto_23

    :cond_20
    invoke-virtual {p0, p1, v0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->createFabDefaultXAnimation(ILjava/util/List;)V

    :goto_23
    new-instance p1, Landroid/animation/AnimatorSet;

    invoke-direct {p1}, Landroid/animation/AnimatorSet;-><init>()V

    invoke-virtual {p1, v0}, Landroid/animation/AnimatorSet;->playTogether(Ljava/util/Collection;)V

    invoke-virtual {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getContext()Landroid/content/Context;

    move-result-object v0

    sget v1, Lcom/google/android/material/bottomappbar/BottomAppBar;->FAB_ALIGNMENT_ANIM_EASING_ATTR:I

    sget-object v2, Lcom/google/android/material/animation/AnimationUtils;->LINEAR_INTERPOLATOR:Landroid/animation/TimeInterpolator;

    invoke-static {v0, v1, v2}, Lcom/google/android/material/motion/MotionUtils;->resolveThemeInterpolator(Landroid/content/Context;ILandroid/animation/TimeInterpolator;)Landroid/animation/TimeInterpolator;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/animation/AnimatorSet;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    iput-object p1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->modeAnimator:Landroid/animation/Animator;

    new-instance v0, Lcom/google/android/material/bottomappbar/BottomAppBar$4;

    invoke-direct {v0, p0}, Lcom/google/android/material/bottomappbar/BottomAppBar$4;-><init>(Lcom/google/android/material/bottomappbar/BottomAppBar;)V

    invoke-virtual {p1, v0}, Landroid/animation/Animator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    iget-object p1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->modeAnimator:Landroid/animation/Animator;

    invoke-virtual {p1}, Landroid/animation/Animator;->start()V

    :cond_49
    :goto_49
    return-void
.end method

.method private maybeTintNavigationIcon(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;
    .registers 3

    if-eqz p1, :cond_17

    iget-object v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->navigationIconTint:Ljava/lang/Integer;

    if-eqz v0, :cond_17

    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    move-result-object p1

    invoke-static {p1}, Landroidx/core/graphics/drawable/DrawableCompat;->wrap(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;

    move-result-object p1

    iget-object v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->navigationIconTint:Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-static {p1, v0}, Landroidx/core/graphics/drawable/DrawableCompat;->setTint(Landroid/graphics/drawable/Drawable;I)V

    :cond_17
    return-object p1
.end method

.method private setActionMenuViewPosition()V
    .registers 4

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getActionMenuView()Landroidx/appcompat/widget/ActionMenuView;

    move-result-object v0

    if-eqz v0, :cond_21

    iget-object v1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->menuAnimator:Landroid/animation/Animator;

    if-nez v1, :cond_21

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-virtual {v0, v1}, Landroidx/appcompat/widget/ActionMenuView;->setAlpha(F)V

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->isFabVisibleOrWillBeShown()Z

    move-result v1

    if-nez v1, :cond_1a

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1, v1}, Lcom/google/android/material/bottomappbar/BottomAppBar;->translateActionMenuView(Landroidx/appcompat/widget/ActionMenuView;IZ)V

    goto :goto_21

    :cond_1a
    iget v1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAlignmentMode:I

    iget-boolean v2, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAttached:Z

    invoke-direct {p0, v0, v1, v2}, Lcom/google/android/material/bottomappbar/BottomAppBar;->translateActionMenuView(Landroidx/appcompat/widget/ActionMenuView;IZ)V

    :cond_21
    :goto_21
    return-void
.end method

.method private setCutoutStateAndTranslateFab()V
    .registers 4

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getTopEdgeTreatment()Lcom/google/android/material/bottomappbar/BottomAppBarTopEdgeTreatment;

    move-result-object v0

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getFabTranslationX()F

    move-result v1

    invoke-virtual {v0, v1}, Lcom/google/android/material/bottomappbar/BottomAppBarTopEdgeTreatment;->setHorizontalOffset(F)V

    iget-object v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->materialShapeDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    iget-boolean v1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAttached:Z

    if-eqz v1, :cond_1f

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->isFabVisibleOrWillBeShown()Z

    move-result v1

    if-eqz v1, :cond_1f

    iget v1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAnchorMode:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_1f

    const/high16 v1, 0x3f800000    # 1.0f

    goto :goto_20

    :cond_1f
    const/4 v1, 0x0

    :goto_20
    invoke-virtual {v0, v1}, Lcom/google/android/material/shape/MaterialShapeDrawable;->setInterpolation(F)V

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->findDependentView()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_37

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getFabTranslationY()F

    move-result v1

    invoke-virtual {v0, v1}, Landroid/view/View;->setTranslationY(F)V

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getFabTranslationX()F

    move-result v1

    invoke-virtual {v0, v1}, Landroid/view/View;->setTranslationX(F)V

    :cond_37
    return-void
.end method

.method private translateActionMenuView(Landroidx/appcompat/widget/ActionMenuView;IZ)V
    .registers 5

    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->translateActionMenuView(Landroidx/appcompat/widget/ActionMenuView;IZZ)V

    return-void
.end method

.method private translateActionMenuView(Landroidx/appcompat/widget/ActionMenuView;IZZ)V
    .registers 6

    new-instance v0, Lcom/google/android/material/bottomappbar/BottomAppBar$8;

    invoke-direct {v0, p0, p1, p2, p3}, Lcom/google/android/material/bottomappbar/BottomAppBar$8;-><init>(Lcom/google/android/material/bottomappbar/BottomAppBar;Landroidx/appcompat/widget/ActionMenuView;IZ)V

    if-eqz p4, :cond_b

    invoke-virtual {p1, v0}, Landroidx/appcompat/widget/ActionMenuView;->post(Ljava/lang/Runnable;)Z

    goto :goto_e

    :cond_b
    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    :goto_e
    return-void
.end method

.method private static updateFabAnchorGravity(Lcom/google/android/material/bottomappbar/BottomAppBar;Landroid/view/View;)V
    .registers 4

    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object p1

    check-cast p1, Landroidx/coordinatorlayout/widget/CoordinatorLayout$LayoutParams;

    const/16 v0, 0x11

    iput v0, p1, Landroidx/coordinatorlayout/widget/CoordinatorLayout$LayoutParams;->anchorGravity:I

    iget v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAnchorMode:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_15

    iget v0, p1, Landroidx/coordinatorlayout/widget/CoordinatorLayout$LayoutParams;->anchorGravity:I

    or-int/lit8 v0, v0, 0x30

    iput v0, p1, Landroidx/coordinatorlayout/widget/CoordinatorLayout$LayoutParams;->anchorGravity:I

    :cond_15
    iget p0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAnchorMode:I

    if-nez p0, :cond_1f

    iget p0, p1, Landroidx/coordinatorlayout/widget/CoordinatorLayout$LayoutParams;->anchorGravity:I

    or-int/lit8 p0, p0, 0x50

    iput p0, p1, Landroidx/coordinatorlayout/widget/CoordinatorLayout$LayoutParams;->anchorGravity:I

    :cond_1f
    return-void
.end method


# virtual methods
.method addAnimationListener(Lcom/google/android/material/bottomappbar/BottomAppBar$AnimationListener;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->animationListeners:Ljava/util/ArrayList;

    if-nez v0, :cond_b

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->animationListeners:Ljava/util/ArrayList;

    :cond_b
    iget-object v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->animationListeners:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public addOnScrollStateChangedListener(Lcom/google/android/material/behavior/HideBottomViewOnScrollBehavior$OnScrollStateChangedListener;)V
    .registers 3

    invoke-virtual {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getBehavior()Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;->addOnScrollStateChangedListener(Lcom/google/android/material/behavior/HideBottomViewOnScrollBehavior$OnScrollStateChangedListener;)V

    return-void
.end method

.method public clearOnScrollStateChangedListeners()V
    .registers 2

    invoke-virtual {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getBehavior()Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;->clearOnScrollStateChangedListeners()V

    return-void
.end method

.method protected createFabDefaultXAnimation(ILjava/util/List;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/List<",
            "Landroid/animation/Animator;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->findDependentFab()Lcom/google/android/material/floatingactionbutton/FloatingActionButton;

    move-result-object p2

    if-eqz p2, :cond_18

    invoke-virtual {p2}, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;->isOrWillBeHidden()Z

    move-result v0

    if-eqz v0, :cond_d

    goto :goto_18

    :cond_d
    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->dispatchAnimationStart()V

    new-instance v0, Lcom/google/android/material/bottomappbar/BottomAppBar$5;

    invoke-direct {v0, p0, p1}, Lcom/google/android/material/bottomappbar/BottomAppBar$5;-><init>(Lcom/google/android/material/bottomappbar/BottomAppBar;I)V

    invoke-virtual {p2, v0}, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;->hide(Lcom/google/android/material/floatingactionbutton/FloatingActionButton$OnVisibilityChangedListener;)V

    :cond_18
    :goto_18
    return-void
.end method

.method protected getActionMenuViewTranslationX(Landroidx/appcompat/widget/ActionMenuView;IZ)I
    .registers 10

    iget v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->menuAlignmentMode:I

    const/4 v1, 0x0

    const/4 v2, 0x1

    if-eq v0, v2, :cond_b

    if-ne p2, v2, :cond_a

    if-nez p3, :cond_b

    :cond_a
    return v1

    :cond_b
    invoke-static {p0}, Lcom/google/android/material/internal/ViewUtils;->isLayoutRtl(Landroid/view/View;)Z

    move-result p2

    if-eqz p2, :cond_16

    invoke-virtual {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getMeasuredWidth()I

    move-result p3

    goto :goto_17

    :cond_16
    move p3, v1

    :goto_17
    move v0, v1

    :goto_18
    invoke-virtual {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getChildCount()I

    move-result v3

    if-ge v0, v3, :cond_56

    invoke-virtual {p0, v0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v4

    instance-of v4, v4, Landroidx/appcompat/widget/Toolbar$LayoutParams;

    if-eqz v4, :cond_3d

    invoke-virtual {v3}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v4

    check-cast v4, Landroidx/appcompat/widget/Toolbar$LayoutParams;

    iget v4, v4, Landroidx/appcompat/widget/Toolbar$LayoutParams;->gravity:I

    const v5, 0x800007

    and-int/2addr v4, v5

    const v5, 0x800003

    if-ne v4, v5, :cond_3d

    move v4, v2

    goto :goto_3e

    :cond_3d
    move v4, v1

    :goto_3e
    if-eqz v4, :cond_53

    if-eqz p2, :cond_4b

    invoke-virtual {v3}, Landroid/view/View;->getLeft()I

    move-result v3

    invoke-static {p3, v3}, Ljava/lang/Math;->min(II)I

    move-result p3

    goto :goto_53

    :cond_4b
    invoke-virtual {v3}, Landroid/view/View;->getRight()I

    move-result v3

    invoke-static {p3, v3}, Ljava/lang/Math;->max(II)I

    move-result p3

    :cond_53
    :goto_53
    add-int/lit8 v0, v0, 0x1

    goto :goto_18

    :cond_56
    if-eqz p2, :cond_5d

    invoke-virtual {p1}, Landroidx/appcompat/widget/ActionMenuView;->getRight()I

    move-result p1

    goto :goto_61

    :cond_5d
    invoke-virtual {p1}, Landroidx/appcompat/widget/ActionMenuView;->getLeft()I

    move-result p1

    :goto_61
    if-eqz p2, :cond_66

    iget v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->rightInset:I

    goto :goto_69

    :cond_66
    iget v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->leftInset:I

    neg-int v0, v0

    :goto_69
    invoke-virtual {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getNavigationIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v2

    if-nez v2, :cond_7e

    invoke-virtual {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/google/android/material/R$dimen;->m3_bottomappbar_horizontal_padding:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v1

    if-eqz p2, :cond_7c

    goto :goto_7e

    :cond_7c
    neg-int p2, v1

    move v1, p2

    :cond_7e
    :goto_7e
    add-int/2addr p1, v0

    add-int/2addr p1, v1

    sub-int/2addr p3, p1

    return p3
.end method

.method public getBackgroundTint()Landroid/content/res/ColorStateList;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->materialShapeDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    invoke-virtual {v0}, Lcom/google/android/material/shape/MaterialShapeDrawable;->getTintList()Landroid/content/res/ColorStateList;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getBehavior()Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;
    .registers 2

    invoke-virtual {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getBehavior()Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;

    move-result-object v0

    return-object v0
.end method

.method public getBehavior()Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->behavior:Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;

    if-nez v0, :cond_b

    new-instance v0, Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;

    invoke-direct {v0}, Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;-><init>()V

    iput-object v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->behavior:Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;

    :cond_b
    iget-object v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->behavior:Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;

    return-object v0
.end method

.method public getCradleVerticalOffset()F
    .registers 2

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getTopEdgeTreatment()Lcom/google/android/material/bottomappbar/BottomAppBarTopEdgeTreatment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/material/bottomappbar/BottomAppBarTopEdgeTreatment;->getCradleVerticalOffset()F

    move-result v0

    return v0
.end method

.method public getFabAlignmentMode()I
    .registers 2

    iget v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAlignmentMode:I

    return v0
.end method

.method public getFabAlignmentModeEndMargin()I
    .registers 2

    iget v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAlignmentModeEndMargin:I

    return v0
.end method

.method public getFabAnchorMode()I
    .registers 2

    iget v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAnchorMode:I

    return v0
.end method

.method public getFabAnimationMode()I
    .registers 2

    iget v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAnimationMode:I

    return v0
.end method

.method public getFabCradleMargin()F
    .registers 2

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getTopEdgeTreatment()Lcom/google/android/material/bottomappbar/BottomAppBarTopEdgeTreatment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/material/bottomappbar/BottomAppBarTopEdgeTreatment;->getFabCradleMargin()F

    move-result v0

    return v0
.end method

.method public getFabCradleRoundedCornerRadius()F
    .registers 2

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getTopEdgeTreatment()Lcom/google/android/material/bottomappbar/BottomAppBarTopEdgeTreatment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/material/bottomappbar/BottomAppBarTopEdgeTreatment;->getFabCradleRoundedCornerRadius()F

    move-result v0

    return v0
.end method

.method public getHideOnScroll()Z
    .registers 2

    iget-boolean v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->hideOnScroll:Z

    return v0
.end method

.method public getMenuAlignmentMode()I
    .registers 2

    iget v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->menuAlignmentMode:I

    return v0
.end method

.method public isScrolledDown()Z
    .registers 2

    invoke-virtual {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getBehavior()Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;->isScrolledDown()Z

    move-result v0

    return v0
.end method

.method public isScrolledUp()Z
    .registers 2

    invoke-virtual {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getBehavior()Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;->isScrolledUp()Z

    move-result v0

    return v0
.end method

.method protected onAttachedToWindow()V
    .registers 3

    invoke-super {p0}, Landroidx/appcompat/widget/Toolbar;->onAttachedToWindow()V

    iget-object v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->materialShapeDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    invoke-static {p0, v0}, Lcom/google/android/material/shape/MaterialShapeUtils;->setParentAbsoluteElevation(Landroid/view/View;Lcom/google/android/material/shape/MaterialShapeDrawable;)V

    invoke-virtual {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    instance-of v0, v0, Landroid/view/ViewGroup;

    if-eqz v0, :cond_1a

    invoke-virtual {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setClipChildren(Z)V

    :cond_1a
    return-void
.end method

.method protected onLayout(ZIIII)V
    .registers 6

    invoke-super/range {p0 .. p5}, Landroidx/appcompat/widget/Toolbar;->onLayout(ZIIII)V

    if-eqz p1, :cond_1f

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->cancelAnimations()V

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->setCutoutStateAndTranslateFab()V

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->findDependentView()Landroid/view/View;

    move-result-object p1

    if-eqz p1, :cond_1f

    invoke-static {p1}, Landroidx/core/view/ViewCompat;->isLaidOut(Landroid/view/View;)Z

    move-result p2

    if-eqz p2, :cond_1f

    new-instance p2, Lcom/google/android/material/bottomappbar/BottomAppBar$$ExternalSyntheticLambda0;

    invoke-direct {p2, p1}, Lcom/google/android/material/bottomappbar/BottomAppBar$$ExternalSyntheticLambda0;-><init>(Landroid/view/View;)V

    invoke-virtual {p1, p2}, Landroid/view/View;->post(Ljava/lang/Runnable;)Z

    :cond_1f
    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->setActionMenuViewPosition()V

    return-void
.end method

.method protected onRestoreInstanceState(Landroid/os/Parcelable;)V
    .registers 3

    instance-of v0, p1, Lcom/google/android/material/bottomappbar/BottomAppBar$SavedState;

    if-nez v0, :cond_8

    invoke-super {p0, p1}, Landroidx/appcompat/widget/Toolbar;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    return-void

    :cond_8
    check-cast p1, Lcom/google/android/material/bottomappbar/BottomAppBar$SavedState;

    invoke-virtual {p1}, Lcom/google/android/material/bottomappbar/BottomAppBar$SavedState;->getSuperState()Landroid/os/Parcelable;

    move-result-object v0

    invoke-super {p0, v0}, Landroidx/appcompat/widget/Toolbar;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    iget v0, p1, Lcom/google/android/material/bottomappbar/BottomAppBar$SavedState;->fabAlignmentMode:I

    iput v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAlignmentMode:I

    iget-boolean p1, p1, Lcom/google/android/material/bottomappbar/BottomAppBar$SavedState;->fabAttached:Z

    iput-boolean p1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAttached:Z

    return-void
.end method

.method protected onSaveInstanceState()Landroid/os/Parcelable;
    .registers 3

    invoke-super {p0}, Landroidx/appcompat/widget/Toolbar;->onSaveInstanceState()Landroid/os/Parcelable;

    move-result-object v0

    new-instance v1, Lcom/google/android/material/bottomappbar/BottomAppBar$SavedState;

    invoke-direct {v1, v0}, Lcom/google/android/material/bottomappbar/BottomAppBar$SavedState;-><init>(Landroid/os/Parcelable;)V

    iget v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAlignmentMode:I

    iput v0, v1, Lcom/google/android/material/bottomappbar/BottomAppBar$SavedState;->fabAlignmentMode:I

    iget-boolean v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAttached:Z

    iput-boolean v0, v1, Lcom/google/android/material/bottomappbar/BottomAppBar$SavedState;->fabAttached:Z

    return-object v1
.end method

.method public performHide()V
    .registers 2

    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->performHide(Z)V

    return-void
.end method

.method public performHide(Z)V
    .registers 3

    invoke-virtual {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getBehavior()Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;->slideDown(Landroid/view/View;Z)V

    return-void
.end method

.method public performShow()V
    .registers 2

    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->performShow(Z)V

    return-void
.end method

.method public performShow(Z)V
    .registers 3

    invoke-virtual {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getBehavior()Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;->slideUp(Landroid/view/View;Z)V

    return-void
.end method

.method removeAnimationListener(Lcom/google/android/material/bottomappbar/BottomAppBar$AnimationListener;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->animationListeners:Ljava/util/ArrayList;

    if-nez v0, :cond_5

    return-void

    :cond_5
    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    return-void
.end method

.method public removeOnScrollStateChangedListener(Lcom/google/android/material/behavior/HideBottomViewOnScrollBehavior$OnScrollStateChangedListener;)V
    .registers 3

    invoke-virtual {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getBehavior()Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;->removeOnScrollStateChangedListener(Lcom/google/android/material/behavior/HideBottomViewOnScrollBehavior$OnScrollStateChangedListener;)V

    return-void
.end method

.method public replaceMenu(I)V
    .registers 3

    if-eqz p1, :cond_f

    const/4 v0, 0x0

    iput v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->pendingMenuResId:I

    invoke-virtual {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getMenu()Landroid/view/Menu;

    move-result-object v0

    invoke-interface {v0}, Landroid/view/Menu;->clear()V

    invoke-virtual {p0, p1}, Lcom/google/android/material/bottomappbar/BottomAppBar;->inflateMenu(I)V

    :cond_f
    return-void
.end method

.method public setBackgroundTint(Landroid/content/res/ColorStateList;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->materialShapeDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    invoke-static {v0, p1}, Landroidx/core/graphics/drawable/DrawableCompat;->setTintList(Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;)V

    return-void
.end method

.method public setCradleVerticalOffset(F)V
    .registers 3

    invoke-virtual {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getCradleVerticalOffset()F

    move-result v0

    cmpl-float v0, p1, v0

    if-eqz v0, :cond_17

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getTopEdgeTreatment()Lcom/google/android/material/bottomappbar/BottomAppBarTopEdgeTreatment;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/google/android/material/bottomappbar/BottomAppBarTopEdgeTreatment;->setCradleVerticalOffset(F)V

    iget-object p1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->materialShapeDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    invoke-virtual {p1}, Lcom/google/android/material/shape/MaterialShapeDrawable;->invalidateSelf()V

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->setCutoutStateAndTranslateFab()V

    :cond_17
    return-void
.end method

.method public setElevation(F)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->materialShapeDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    invoke-virtual {v0, p1}, Lcom/google/android/material/shape/MaterialShapeDrawable;->setElevation(F)V

    iget-object p1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->materialShapeDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    invoke-virtual {p1}, Lcom/google/android/material/shape/MaterialShapeDrawable;->getShadowRadius()I

    move-result p1

    iget-object v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->materialShapeDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    invoke-virtual {v0}, Lcom/google/android/material/shape/MaterialShapeDrawable;->getShadowOffsetY()I

    move-result v0

    sub-int/2addr p1, v0

    invoke-virtual {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getBehavior()Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;->setAdditionalHiddenOffsetY(Landroid/view/View;I)V

    return-void
.end method

.method public setFabAlignmentMode(I)V
    .registers 3

    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->setFabAlignmentModeAndReplaceMenu(II)V

    return-void
.end method

.method public setFabAlignmentModeAndReplaceMenu(II)V
    .registers 3

    iput p2, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->pendingMenuResId:I

    const/4 p2, 0x1

    iput-boolean p2, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->menuAnimatingWithFabAlignmentMode:Z

    iget-boolean p2, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAttached:Z

    invoke-direct {p0, p1, p2}, Lcom/google/android/material/bottomappbar/BottomAppBar;->maybeAnimateMenuView(IZ)V

    invoke-direct {p0, p1}, Lcom/google/android/material/bottomappbar/BottomAppBar;->maybeAnimateModeChange(I)V

    iput p1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAlignmentMode:I

    return-void
.end method

.method public setFabAlignmentModeEndMargin(I)V
    .registers 3

    iget v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAlignmentModeEndMargin:I

    if-eq v0, p1, :cond_9

    iput p1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAlignmentModeEndMargin:I

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->setCutoutStateAndTranslateFab()V

    :cond_9
    return-void
.end method

.method public setFabAnchorMode(I)V
    .registers 2

    iput p1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAnchorMode:I

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->setCutoutStateAndTranslateFab()V

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->findDependentView()Landroid/view/View;

    move-result-object p1

    if-eqz p1, :cond_16

    invoke-static {p0, p1}, Lcom/google/android/material/bottomappbar/BottomAppBar;->updateFabAnchorGravity(Lcom/google/android/material/bottomappbar/BottomAppBar;Landroid/view/View;)V

    invoke-virtual {p1}, Landroid/view/View;->requestLayout()V

    iget-object p1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->materialShapeDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    invoke-virtual {p1}, Lcom/google/android/material/shape/MaterialShapeDrawable;->invalidateSelf()V

    :cond_16
    return-void
.end method

.method public setFabAnimationMode(I)V
    .registers 2

    iput p1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAnimationMode:I

    return-void
.end method

.method setFabCornerSize(F)V
    .registers 3

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getTopEdgeTreatment()Lcom/google/android/material/bottomappbar/BottomAppBarTopEdgeTreatment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/material/bottomappbar/BottomAppBarTopEdgeTreatment;->getFabCornerRadius()F

    move-result v0

    cmpl-float v0, p1, v0

    if-eqz v0, :cond_18

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getTopEdgeTreatment()Lcom/google/android/material/bottomappbar/BottomAppBarTopEdgeTreatment;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/google/android/material/bottomappbar/BottomAppBarTopEdgeTreatment;->setFabCornerSize(F)V

    iget-object p1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->materialShapeDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    invoke-virtual {p1}, Lcom/google/android/material/shape/MaterialShapeDrawable;->invalidateSelf()V

    :cond_18
    return-void
.end method

.method public setFabCradleMargin(F)V
    .registers 3

    invoke-virtual {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getFabCradleMargin()F

    move-result v0

    cmpl-float v0, p1, v0

    if-eqz v0, :cond_14

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getTopEdgeTreatment()Lcom/google/android/material/bottomappbar/BottomAppBarTopEdgeTreatment;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/google/android/material/bottomappbar/BottomAppBarTopEdgeTreatment;->setFabCradleMargin(F)V

    iget-object p1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->materialShapeDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    invoke-virtual {p1}, Lcom/google/android/material/shape/MaterialShapeDrawable;->invalidateSelf()V

    :cond_14
    return-void
.end method

.method public setFabCradleRoundedCornerRadius(F)V
    .registers 3

    invoke-virtual {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getFabCradleRoundedCornerRadius()F

    move-result v0

    cmpl-float v0, p1, v0

    if-eqz v0, :cond_14

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getTopEdgeTreatment()Lcom/google/android/material/bottomappbar/BottomAppBarTopEdgeTreatment;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/google/android/material/bottomappbar/BottomAppBarTopEdgeTreatment;->setFabCradleRoundedCornerRadius(F)V

    iget-object p1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->materialShapeDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    invoke-virtual {p1}, Lcom/google/android/material/shape/MaterialShapeDrawable;->invalidateSelf()V

    :cond_14
    return-void
.end method

.method setFabDiameter(I)Z
    .registers 3

    int-to-float p1, p1

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getTopEdgeTreatment()Lcom/google/android/material/bottomappbar/BottomAppBarTopEdgeTreatment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/material/bottomappbar/BottomAppBarTopEdgeTreatment;->getFabDiameter()F

    move-result v0

    cmpl-float v0, p1, v0

    if-eqz v0, :cond_1b

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getTopEdgeTreatment()Lcom/google/android/material/bottomappbar/BottomAppBarTopEdgeTreatment;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/google/android/material/bottomappbar/BottomAppBarTopEdgeTreatment;->setFabDiameter(F)V

    iget-object p1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->materialShapeDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    invoke-virtual {p1}, Lcom/google/android/material/shape/MaterialShapeDrawable;->invalidateSelf()V

    const/4 p1, 0x1

    return p1

    :cond_1b
    const/4 p1, 0x0

    return p1
.end method

.method public setHideOnScroll(Z)V
    .registers 2

    iput-boolean p1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->hideOnScroll:Z

    return-void
.end method

.method public setMenuAlignmentMode(I)V
    .registers 4

    iget v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->menuAlignmentMode:I

    if-eq v0, p1, :cond_15

    iput p1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->menuAlignmentMode:I

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getActionMenuView()Landroidx/appcompat/widget/ActionMenuView;

    move-result-object p1

    if-eqz p1, :cond_15

    iget v0, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAlignmentMode:I

    invoke-direct {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->isFabVisibleOrWillBeShown()Z

    move-result v1

    invoke-direct {p0, p1, v0, v1}, Lcom/google/android/material/bottomappbar/BottomAppBar;->translateActionMenuView(Landroidx/appcompat/widget/ActionMenuView;IZ)V

    :cond_15
    return-void
.end method

.method public setNavigationIcon(Landroid/graphics/drawable/Drawable;)V
    .registers 2

    invoke-direct {p0, p1}, Lcom/google/android/material/bottomappbar/BottomAppBar;->maybeTintNavigationIcon(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;

    move-result-object p1

    invoke-super {p0, p1}, Landroidx/appcompat/widget/Toolbar;->setNavigationIcon(Landroid/graphics/drawable/Drawable;)V

    return-void
.end method

.method public setNavigationIconTint(I)V
    .registers 2

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    iput-object p1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar;->navigationIconTint:Ljava/lang/Integer;

    invoke-virtual {p0}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getNavigationIcon()Landroid/graphics/drawable/Drawable;

    move-result-object p1

    if-eqz p1, :cond_f

    invoke-virtual {p0, p1}, Lcom/google/android/material/bottomappbar/BottomAppBar;->setNavigationIcon(Landroid/graphics/drawable/Drawable;)V

    :cond_f
    return-void
.end method

.method public setSubtitle(Ljava/lang/CharSequence;)V
    .registers 2

    return-void
.end method

.method public setTitle(Ljava/lang/CharSequence;)V
    .registers 2

    return-void
.end method
