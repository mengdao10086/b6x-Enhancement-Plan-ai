.class public Lcom/google/android/material/search/SearchView;
.super Landroid/widget/FrameLayout;
.source "SearchView.java"

# interfaces
.implements Landroidx/coordinatorlayout/widget/CoordinatorLayout$AttachedBehavior;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/material/search/SearchView$SavedState;,
        Lcom/google/android/material/search/SearchView$TransitionState;,
        Lcom/google/android/material/search/SearchView$TransitionListener;,
        Lcom/google/android/material/search/SearchView$Behavior;
    }
.end annotation


# static fields
.field private static final DEF_STYLE_RES:I

.field private static final TALKBACK_FOCUS_CHANGE_DELAY_MS:J = 0x64L


# instance fields
.field private animatedMenuItems:Z

.field private animatedNavigationIcon:Z

.field private autoShowKeyboard:Z

.field final backgroundView:Landroid/view/View;

.field private childImportantForAccessibilityMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Landroid/view/View;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field final clearButton:Landroid/widget/ImageButton;

.field final contentContainer:Lcom/google/android/material/internal/TouchObserverFrameLayout;

.field private currentTransitionState:Lcom/google/android/material/search/SearchView$TransitionState;

.field final divider:Landroid/view/View;

.field final dummyToolbar:Landroidx/appcompat/widget/Toolbar;

.field final editText:Landroid/widget/EditText;

.field private final elevationOverlayProvider:Lcom/google/android/material/elevation/ElevationOverlayProvider;

.field final headerContainer:Landroid/widget/FrameLayout;

.field private final layoutInflated:Z

.field final rootView:Lcom/google/android/material/internal/ClippableRoundedCornerLayout;

.field final scrim:Landroid/view/View;

.field private searchBar:Lcom/google/android/material/search/SearchBar;

.field final searchPrefix:Landroid/widget/TextView;

.field private final searchViewAnimationHelper:Lcom/google/android/material/search/SearchViewAnimationHelper;

.field private softInputMode:I

.field final statusBarSpacer:Landroid/view/View;

.field private statusBarSpacerEnabledOverride:Z

.field final toolbar:Lcom/google/android/material/appbar/MaterialToolbar;

.field final toolbarContainer:Landroid/widget/FrameLayout;

.field private final transitionListeners:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Lcom/google/android/material/search/SearchView$TransitionListener;",
            ">;"
        }
    .end annotation
.end field

.field private useWindowInsetsController:Z


# direct methods
.method static constructor <clinit>()V
    .registers 1

    sget v0, Lcom/google/android/material/R$style;->Widget_Material3_SearchView:I

    sput v0, Lcom/google/android/material/search/SearchView;->DEF_STYLE_RES:I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .registers 3

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/google/android/material/search/SearchView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 4

    sget v0, Lcom/google/android/material/R$attr;->materialSearchViewStyle:I

    invoke-direct {p0, p1, p2, v0}, Lcom/google/android/material/search/SearchView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .registers 12

    sget v4, Lcom/google/android/material/search/SearchView;->DEF_STYLE_RES:I

    invoke-static {p1, p2, p3, v4}, Lcom/google/android/material/theme/overlay/MaterialThemeOverlay;->wrap(Landroid/content/Context;Landroid/util/AttributeSet;II)Landroid/content/Context;

    move-result-object p1

    invoke-direct {p0, p1, p2, p3}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    new-instance p1, Ljava/util/LinkedHashSet;

    invoke-direct {p1}, Ljava/util/LinkedHashSet;-><init>()V

    iput-object p1, p0, Lcom/google/android/material/search/SearchView;->transitionListeners:Ljava/util/Set;

    const/16 p1, 0x10

    iput p1, p0, Lcom/google/android/material/search/SearchView;->softInputMode:I

    sget-object p1, Lcom/google/android/material/search/SearchView$TransitionState;->HIDDEN:Lcom/google/android/material/search/SearchView$TransitionState;

    iput-object p1, p0, Lcom/google/android/material/search/SearchView;->currentTransitionState:Lcom/google/android/material/search/SearchView$TransitionState;

    invoke-virtual {p0}, Lcom/google/android/material/search/SearchView;->getContext()Landroid/content/Context;

    move-result-object p1

    sget-object v2, Lcom/google/android/material/R$styleable;->SearchView:[I

    const/4 v6, 0x0

    new-array v5, v6, [I

    move-object v0, p1

    move-object v1, p2

    move v3, p3

    invoke-static/range {v0 .. v5}, Lcom/google/android/material/internal/ThemeEnforcement;->obtainStyledAttributes(Landroid/content/Context;Landroid/util/AttributeSet;[III[I)Landroid/content/res/TypedArray;

    move-result-object p2

    sget p3, Lcom/google/android/material/R$styleable;->SearchView_headerLayout:I

    const/4 v0, -0x1

    invoke-virtual {p2, p3, v0}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result p3

    sget v1, Lcom/google/android/material/R$styleable;->SearchView_android_textAppearance:I

    invoke-virtual {p2, v1, v0}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v0

    sget v1, Lcom/google/android/material/R$styleable;->SearchView_android_text:I

    invoke-virtual {p2, v1}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v1

    sget v2, Lcom/google/android/material/R$styleable;->SearchView_android_hint:I

    invoke-virtual {p2, v2}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v2

    sget v3, Lcom/google/android/material/R$styleable;->SearchView_searchPrefixText:I

    invoke-virtual {p2, v3}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v3

    sget v4, Lcom/google/android/material/R$styleable;->SearchView_useDrawerArrowDrawable:I

    invoke-virtual {p2, v4, v6}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v4

    sget v5, Lcom/google/android/material/R$styleable;->SearchView_animateNavigationIcon:I

    const/4 v7, 0x1

    invoke-virtual {p2, v5, v7}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v5

    iput-boolean v5, p0, Lcom/google/android/material/search/SearchView;->animatedNavigationIcon:Z

    sget v5, Lcom/google/android/material/R$styleable;->SearchView_animateMenuItems:I

    invoke-virtual {p2, v5, v7}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v5

    iput-boolean v5, p0, Lcom/google/android/material/search/SearchView;->animatedMenuItems:Z

    sget v5, Lcom/google/android/material/R$styleable;->SearchView_hideNavigationIcon:I

    invoke-virtual {p2, v5, v6}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v5

    sget v6, Lcom/google/android/material/R$styleable;->SearchView_autoShowKeyboard:I

    invoke-virtual {p2, v6, v7}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v6

    iput-boolean v6, p0, Lcom/google/android/material/search/SearchView;->autoShowKeyboard:Z

    invoke-virtual {p2}, Landroid/content/res/TypedArray;->recycle()V

    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object p2

    sget v6, Lcom/google/android/material/R$layout;->mtrl_search_view:I

    invoke-virtual {p2, v6, p0}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    iput-boolean v7, p0, Lcom/google/android/material/search/SearchView;->layoutInflated:Z

    sget p2, Lcom/google/android/material/R$id;->search_view_scrim:I

    invoke-virtual {p0, p2}, Lcom/google/android/material/search/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object p2

    iput-object p2, p0, Lcom/google/android/material/search/SearchView;->scrim:Landroid/view/View;

    sget p2, Lcom/google/android/material/R$id;->search_view_root:I

    invoke-virtual {p0, p2}, Lcom/google/android/material/search/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object p2

    check-cast p2, Lcom/google/android/material/internal/ClippableRoundedCornerLayout;

    iput-object p2, p0, Lcom/google/android/material/search/SearchView;->rootView:Lcom/google/android/material/internal/ClippableRoundedCornerLayout;

    sget p2, Lcom/google/android/material/R$id;->search_view_background:I

    invoke-virtual {p0, p2}, Lcom/google/android/material/search/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object p2

    iput-object p2, p0, Lcom/google/android/material/search/SearchView;->backgroundView:Landroid/view/View;

    sget p2, Lcom/google/android/material/R$id;->search_view_status_bar_spacer:I

    invoke-virtual {p0, p2}, Lcom/google/android/material/search/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object p2

    iput-object p2, p0, Lcom/google/android/material/search/SearchView;->statusBarSpacer:Landroid/view/View;

    sget p2, Lcom/google/android/material/R$id;->search_view_header_container:I

    invoke-virtual {p0, p2}, Lcom/google/android/material/search/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object p2

    check-cast p2, Landroid/widget/FrameLayout;

    iput-object p2, p0, Lcom/google/android/material/search/SearchView;->headerContainer:Landroid/widget/FrameLayout;

    sget p2, Lcom/google/android/material/R$id;->search_view_toolbar_container:I

    invoke-virtual {p0, p2}, Lcom/google/android/material/search/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object p2

    check-cast p2, Landroid/widget/FrameLayout;

    iput-object p2, p0, Lcom/google/android/material/search/SearchView;->toolbarContainer:Landroid/widget/FrameLayout;

    sget p2, Lcom/google/android/material/R$id;->search_view_toolbar:I

    invoke-virtual {p0, p2}, Lcom/google/android/material/search/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object p2

    check-cast p2, Lcom/google/android/material/appbar/MaterialToolbar;

    iput-object p2, p0, Lcom/google/android/material/search/SearchView;->toolbar:Lcom/google/android/material/appbar/MaterialToolbar;

    sget p2, Lcom/google/android/material/R$id;->search_view_dummy_toolbar:I

    invoke-virtual {p0, p2}, Lcom/google/android/material/search/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object p2

    check-cast p2, Landroidx/appcompat/widget/Toolbar;

    iput-object p2, p0, Lcom/google/android/material/search/SearchView;->dummyToolbar:Landroidx/appcompat/widget/Toolbar;

    sget p2, Lcom/google/android/material/R$id;->search_view_search_prefix:I

    invoke-virtual {p0, p2}, Lcom/google/android/material/search/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object p2

    check-cast p2, Landroid/widget/TextView;

    iput-object p2, p0, Lcom/google/android/material/search/SearchView;->searchPrefix:Landroid/widget/TextView;

    sget p2, Lcom/google/android/material/R$id;->search_view_edit_text:I

    invoke-virtual {p0, p2}, Lcom/google/android/material/search/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object p2

    check-cast p2, Landroid/widget/EditText;

    iput-object p2, p0, Lcom/google/android/material/search/SearchView;->editText:Landroid/widget/EditText;

    sget p2, Lcom/google/android/material/R$id;->search_view_clear_button:I

    invoke-virtual {p0, p2}, Lcom/google/android/material/search/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object p2

    check-cast p2, Landroid/widget/ImageButton;

    iput-object p2, p0, Lcom/google/android/material/search/SearchView;->clearButton:Landroid/widget/ImageButton;

    sget p2, Lcom/google/android/material/R$id;->search_view_divider:I

    invoke-virtual {p0, p2}, Lcom/google/android/material/search/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object p2

    iput-object p2, p0, Lcom/google/android/material/search/SearchView;->divider:Landroid/view/View;

    sget p2, Lcom/google/android/material/R$id;->search_view_content_container:I

    invoke-virtual {p0, p2}, Lcom/google/android/material/search/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object p2

    check-cast p2, Lcom/google/android/material/internal/TouchObserverFrameLayout;

    iput-object p2, p0, Lcom/google/android/material/search/SearchView;->contentContainer:Lcom/google/android/material/internal/TouchObserverFrameLayout;

    new-instance p2, Lcom/google/android/material/search/SearchViewAnimationHelper;

    invoke-direct {p2, p0}, Lcom/google/android/material/search/SearchViewAnimationHelper;-><init>(Lcom/google/android/material/search/SearchView;)V

    iput-object p2, p0, Lcom/google/android/material/search/SearchView;->searchViewAnimationHelper:Lcom/google/android/material/search/SearchViewAnimationHelper;

    new-instance p2, Lcom/google/android/material/elevation/ElevationOverlayProvider;

    invoke-direct {p2, p1}, Lcom/google/android/material/elevation/ElevationOverlayProvider;-><init>(Landroid/content/Context;)V

    iput-object p2, p0, Lcom/google/android/material/search/SearchView;->elevationOverlayProvider:Lcom/google/android/material/elevation/ElevationOverlayProvider;

    invoke-direct {p0}, Lcom/google/android/material/search/SearchView;->setUpRootView()V

    invoke-direct {p0}, Lcom/google/android/material/search/SearchView;->setUpBackgroundViewElevationOverlay()V

    invoke-direct {p0, p3}, Lcom/google/android/material/search/SearchView;->setUpHeaderLayout(I)V

    invoke-virtual {p0, v3}, Lcom/google/android/material/search/SearchView;->setSearchPrefixText(Ljava/lang/CharSequence;)V

    invoke-direct {p0, v0, v1, v2}, Lcom/google/android/material/search/SearchView;->setUpEditText(ILjava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0, v4, v5}, Lcom/google/android/material/search/SearchView;->setUpBackButton(ZZ)V

    invoke-direct {p0}, Lcom/google/android/material/search/SearchView;->setUpClearButton()V

    invoke-direct {p0}, Lcom/google/android/material/search/SearchView;->setUpContentOnTouchListener()V

    invoke-direct {p0}, Lcom/google/android/material/search/SearchView;->setUpInsetListeners()V

    return-void
.end method

.method private getActivityWindow()Landroid/view/Window;
    .registers 2

    invoke-virtual {p0}, Lcom/google/android/material/search/SearchView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/material/internal/ContextUtils;->getActivity(Landroid/content/Context;)Landroid/app/Activity;

    move-result-object v0

    if-nez v0, :cond_c

    const/4 v0, 0x0

    goto :goto_10

    :cond_c
    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    :goto_10
    return-object v0
.end method

.method private getOverlayElevation()F
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->searchBar:Lcom/google/android/material/search/SearchBar;

    if-eqz v0, :cond_9

    invoke-virtual {v0}, Lcom/google/android/material/search/SearchBar;->getCompatElevation()F

    move-result v0

    return v0

    :cond_9
    invoke-virtual {p0}, Lcom/google/android/material/search/SearchView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/google/android/material/R$dimen;->m3_searchview_elevation:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v0

    return v0
.end method

.method private getStatusBarHeight()I
    .registers 5

    invoke-virtual {p0}, Lcom/google/android/material/search/SearchView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const-string v1, "dimen"

    const-string v2, "android"

    const-string v3, "status_bar_height"

    invoke-virtual {v0, v3, v1, v2}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    if-lez v0, :cond_19

    invoke-virtual {p0}, Lcom/google/android/material/search/SearchView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    return v0

    :cond_19
    const/4 v0, 0x0

    return v0
.end method

.method private isNavigationIconDrawerArrowDrawable(Landroidx/appcompat/widget/Toolbar;)Z
    .registers 2

    invoke-virtual {p1}, Landroidx/appcompat/widget/Toolbar;->getNavigationIcon()Landroid/graphics/drawable/Drawable;

    move-result-object p1

    invoke-static {p1}, Landroidx/core/graphics/drawable/DrawableCompat;->unwrap(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;

    move-result-object p1

    instance-of p1, p1, Landroidx/appcompat/graphics/drawable/DrawerArrowDrawable;

    return p1
.end method

.method static synthetic lambda$setUpDividerInsetListener$6(Landroid/view/ViewGroup$MarginLayoutParams;IILandroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;
    .registers 5

    invoke-virtual {p4}, Landroidx/core/view/WindowInsetsCompat;->getSystemWindowInsetLeft()I

    move-result p3

    add-int/2addr p1, p3

    iput p1, p0, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    invoke-virtual {p4}, Landroidx/core/view/WindowInsetsCompat;->getSystemWindowInsetRight()I

    move-result p1

    add-int/2addr p2, p1

    iput p2, p0, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    return-object p4
.end method

.method static synthetic lambda$setUpRootView$0(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .registers 2

    const/4 p0, 0x1

    return p0
.end method

.method private setStatusBarSpacerEnabledInternal(Z)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->statusBarSpacer:Landroid/view/View;

    if-eqz p1, :cond_6

    const/4 p1, 0x0

    goto :goto_8

    :cond_6
    const/16 p1, 0x8

    :goto_8
    invoke-virtual {v0, p1}, Landroid/view/View;->setVisibility(I)V

    return-void
.end method

.method private setUpBackButton(ZZ)V
    .registers 4

    if-eqz p2, :cond_9

    iget-object p1, p0, Lcom/google/android/material/search/SearchView;->toolbar:Lcom/google/android/material/appbar/MaterialToolbar;

    const/4 p2, 0x0

    invoke-virtual {p1, p2}, Lcom/google/android/material/appbar/MaterialToolbar;->setNavigationIcon(Landroid/graphics/drawable/Drawable;)V

    return-void

    :cond_9
    iget-object p2, p0, Lcom/google/android/material/search/SearchView;->toolbar:Lcom/google/android/material/appbar/MaterialToolbar;

    new-instance v0, Lcom/google/android/material/search/SearchView$$ExternalSyntheticLambda2;

    invoke-direct {v0, p0}, Lcom/google/android/material/search/SearchView$$ExternalSyntheticLambda2;-><init>(Lcom/google/android/material/search/SearchView;)V

    invoke-virtual {p2, v0}, Lcom/google/android/material/appbar/MaterialToolbar;->setNavigationOnClickListener(Landroid/view/View$OnClickListener;)V

    if-eqz p1, :cond_2c

    new-instance p1, Landroidx/appcompat/graphics/drawable/DrawerArrowDrawable;

    invoke-virtual {p0}, Lcom/google/android/material/search/SearchView;->getContext()Landroid/content/Context;

    move-result-object p2

    invoke-direct {p1, p2}, Landroidx/appcompat/graphics/drawable/DrawerArrowDrawable;-><init>(Landroid/content/Context;)V

    sget p2, Lcom/google/android/material/R$attr;->colorOnSurface:I

    invoke-static {p0, p2}, Lcom/google/android/material/color/MaterialColors;->getColor(Landroid/view/View;I)I

    move-result p2

    invoke-virtual {p1, p2}, Landroidx/appcompat/graphics/drawable/DrawerArrowDrawable;->setColor(I)V

    iget-object p2, p0, Lcom/google/android/material/search/SearchView;->toolbar:Lcom/google/android/material/appbar/MaterialToolbar;

    invoke-virtual {p2, p1}, Lcom/google/android/material/appbar/MaterialToolbar;->setNavigationIcon(Landroid/graphics/drawable/Drawable;)V

    :cond_2c
    return-void
.end method

.method private setUpBackgroundViewElevationOverlay()V
    .registers 2

    invoke-direct {p0}, Lcom/google/android/material/search/SearchView;->getOverlayElevation()F

    move-result v0

    invoke-direct {p0, v0}, Lcom/google/android/material/search/SearchView;->setUpBackgroundViewElevationOverlay(F)V

    return-void
.end method

.method private setUpBackgroundViewElevationOverlay(F)V
    .registers 4

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->elevationOverlayProvider:Lcom/google/android/material/elevation/ElevationOverlayProvider;

    if-eqz v0, :cond_12

    iget-object v1, p0, Lcom/google/android/material/search/SearchView;->backgroundView:Landroid/view/View;

    if-nez v1, :cond_9

    goto :goto_12

    :cond_9
    invoke-virtual {v0, p1}, Lcom/google/android/material/elevation/ElevationOverlayProvider;->compositeOverlayWithThemeSurfaceColorIfNeeded(F)I

    move-result p1

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->backgroundView:Landroid/view/View;

    invoke-virtual {v0, p1}, Landroid/view/View;->setBackgroundColor(I)V

    :cond_12
    :goto_12
    return-void
.end method

.method private setUpClearButton()V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->clearButton:Landroid/widget/ImageButton;

    new-instance v1, Lcom/google/android/material/search/SearchView$$ExternalSyntheticLambda7;

    invoke-direct {v1, p0}, Lcom/google/android/material/search/SearchView$$ExternalSyntheticLambda7;-><init>(Lcom/google/android/material/search/SearchView;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->editText:Landroid/widget/EditText;

    new-instance v1, Lcom/google/android/material/search/SearchView$1;

    invoke-direct {v1, p0}, Lcom/google/android/material/search/SearchView$1;-><init>(Lcom/google/android/material/search/SearchView;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    return-void
.end method

.method private setUpContentOnTouchListener()V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->contentContainer:Lcom/google/android/material/internal/TouchObserverFrameLayout;

    new-instance v1, Lcom/google/android/material/search/SearchView$$ExternalSyntheticLambda0;

    invoke-direct {v1, p0}, Lcom/google/android/material/search/SearchView$$ExternalSyntheticLambda0;-><init>(Lcom/google/android/material/search/SearchView;)V

    invoke-virtual {v0, v1}, Lcom/google/android/material/internal/TouchObserverFrameLayout;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    return-void
.end method

.method private setUpDividerInsetListener()V
    .registers 6

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->divider:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup$MarginLayoutParams;

    iget v1, v0, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    iget v2, v0, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    iget-object v3, p0, Lcom/google/android/material/search/SearchView;->divider:Landroid/view/View;

    new-instance v4, Lcom/google/android/material/search/SearchView$$ExternalSyntheticLambda3;

    invoke-direct {v4, v0, v1, v2}, Lcom/google/android/material/search/SearchView$$ExternalSyntheticLambda3;-><init>(Landroid/view/ViewGroup$MarginLayoutParams;II)V

    invoke-static {v3, v4}, Landroidx/core/view/ViewCompat;->setOnApplyWindowInsetsListener(Landroid/view/View;Landroidx/core/view/OnApplyWindowInsetsListener;)V

    return-void
.end method

.method private setUpEditText(ILjava/lang/String;Ljava/lang/String;)V
    .registers 5

    const/4 v0, -0x1

    if-eq p1, v0, :cond_8

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->editText:Landroid/widget/EditText;

    invoke-static {v0, p1}, Landroidx/core/widget/TextViewCompat;->setTextAppearance(Landroid/widget/TextView;I)V

    :cond_8
    iget-object p1, p0, Lcom/google/android/material/search/SearchView;->editText:Landroid/widget/EditText;

    invoke-virtual {p1, p2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    iget-object p1, p0, Lcom/google/android/material/search/SearchView;->editText:Landroid/widget/EditText;

    invoke-virtual {p1, p3}, Landroid/widget/EditText;->setHint(Ljava/lang/CharSequence;)V

    return-void
.end method

.method private setUpHeaderLayout(I)V
    .registers 5

    const/4 v0, -0x1

    if-eq p1, v0, :cond_15

    invoke-virtual {p0}, Lcom/google/android/material/search/SearchView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/material/search/SearchView;->headerContainer:Landroid/widget/FrameLayout;

    const/4 v2, 0x0

    invoke-virtual {v0, p1, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p1

    invoke-virtual {p0, p1}, Lcom/google/android/material/search/SearchView;->addHeaderView(Landroid/view/View;)V

    :cond_15
    return-void
.end method

.method private setUpInsetListeners()V
    .registers 1

    invoke-direct {p0}, Lcom/google/android/material/search/SearchView;->setUpToolbarInsetListener()V

    invoke-direct {p0}, Lcom/google/android/material/search/SearchView;->setUpDividerInsetListener()V

    invoke-direct {p0}, Lcom/google/android/material/search/SearchView;->setUpStatusBarSpacerInsetListener()V

    return-void
.end method

.method private setUpRootView()V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->rootView:Lcom/google/android/material/internal/ClippableRoundedCornerLayout;

    new-instance v1, Lcom/google/android/material/search/SearchView$$ExternalSyntheticLambda1;

    invoke-direct {v1}, Lcom/google/android/material/search/SearchView$$ExternalSyntheticLambda1;-><init>()V

    invoke-virtual {v0, v1}, Lcom/google/android/material/internal/ClippableRoundedCornerLayout;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    return-void
.end method

.method private setUpStatusBarSpacer(I)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->statusBarSpacer:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    iget v0, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    if-eq v0, p1, :cond_17

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->statusBarSpacer:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    iput p1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    iget-object p1, p0, Lcom/google/android/material/search/SearchView;->statusBarSpacer:Landroid/view/View;

    invoke-virtual {p1}, Landroid/view/View;->requestLayout()V

    :cond_17
    return-void
.end method

.method private setUpStatusBarSpacerInsetListener()V
    .registers 3

    invoke-direct {p0}, Lcom/google/android/material/search/SearchView;->getStatusBarHeight()I

    move-result v0

    invoke-direct {p0, v0}, Lcom/google/android/material/search/SearchView;->setUpStatusBarSpacer(I)V

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->statusBarSpacer:Landroid/view/View;

    new-instance v1, Lcom/google/android/material/search/SearchView$$ExternalSyntheticLambda4;

    invoke-direct {v1, p0}, Lcom/google/android/material/search/SearchView$$ExternalSyntheticLambda4;-><init>(Lcom/google/android/material/search/SearchView;)V

    invoke-static {v0, v1}, Landroidx/core/view/ViewCompat;->setOnApplyWindowInsetsListener(Landroid/view/View;Landroidx/core/view/OnApplyWindowInsetsListener;)V

    return-void
.end method

.method private setUpToolbarInsetListener()V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->toolbar:Lcom/google/android/material/appbar/MaterialToolbar;

    new-instance v1, Lcom/google/android/material/search/SearchView$$ExternalSyntheticLambda8;

    invoke-direct {v1, p0}, Lcom/google/android/material/search/SearchView$$ExternalSyntheticLambda8;-><init>(Lcom/google/android/material/search/SearchView;)V

    invoke-static {v0, v1}, Lcom/google/android/material/internal/ViewUtils;->doOnApplyWindowInsets(Landroid/view/View;Lcom/google/android/material/internal/ViewUtils$OnApplyWindowInsetsListener;)V

    return-void
.end method

.method private updateChildImportantForAccessibility(Landroid/view/ViewGroup;Z)V
    .registers 7

    const/4 v0, 0x0

    :goto_1
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v1

    if-ge v0, v1, :cond_50

    invoke-virtual {p1, v0}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    if-ne v1, p0, :cond_e

    goto :goto_4d

    :cond_e
    iget-object v2, p0, Lcom/google/android/material/search/SearchView;->rootView:Lcom/google/android/material/internal/ClippableRoundedCornerLayout;

    invoke-virtual {v2}, Lcom/google/android/material/internal/ClippableRoundedCornerLayout;->getId()I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    if-eqz v2, :cond_20

    check-cast v1, Landroid/view/ViewGroup;

    invoke-direct {p0, v1, p2}, Lcom/google/android/material/search/SearchView;->updateChildImportantForAccessibility(Landroid/view/ViewGroup;Z)V

    goto :goto_4d

    :cond_20
    if-nez p2, :cond_3c

    iget-object v2, p0, Lcom/google/android/material/search/SearchView;->childImportantForAccessibilityMap:Ljava/util/Map;

    if-eqz v2, :cond_4d

    invoke-interface {v2, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4d

    iget-object v2, p0, Lcom/google/android/material/search/SearchView;->childImportantForAccessibilityMap:Ljava/util/Map;

    invoke-interface {v2, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-static {v1, v2}, Landroidx/core/view/ViewCompat;->setImportantForAccessibility(Landroid/view/View;I)V

    goto :goto_4d

    :cond_3c
    iget-object v2, p0, Lcom/google/android/material/search/SearchView;->childImportantForAccessibilityMap:Ljava/util/Map;

    invoke-virtual {v1}, Landroid/view/View;->getImportantForAccessibility()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v2, v1, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const/4 v2, 0x4

    invoke-static {v1, v2}, Landroidx/core/view/ViewCompat;->setImportantForAccessibility(Landroid/view/View;I)V

    :cond_4d
    :goto_4d
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_50
    return-void
.end method

.method private updateNavigationIconIfNeeded()V
    .registers 5

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->toolbar:Lcom/google/android/material/appbar/MaterialToolbar;

    if-nez v0, :cond_5

    return-void

    :cond_5
    invoke-direct {p0, v0}, Lcom/google/android/material/search/SearchView;->isNavigationIconDrawerArrowDrawable(Landroidx/appcompat/widget/Toolbar;)Z

    move-result v0

    if-eqz v0, :cond_c

    return-void

    :cond_c
    sget v0, Lcom/google/android/material/R$drawable;->ic_arrow_back_black_24:I

    iget-object v1, p0, Lcom/google/android/material/search/SearchView;->searchBar:Lcom/google/android/material/search/SearchBar;

    if-nez v1, :cond_18

    iget-object v1, p0, Lcom/google/android/material/search/SearchView;->toolbar:Lcom/google/android/material/appbar/MaterialToolbar;

    invoke-virtual {v1, v0}, Lcom/google/android/material/appbar/MaterialToolbar;->setNavigationIcon(I)V

    goto :goto_50

    :cond_18
    invoke-virtual {p0}, Lcom/google/android/material/search/SearchView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1, v0}, Landroidx/appcompat/content/res/AppCompatResources;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-static {v0}, Landroidx/core/graphics/drawable/DrawableCompat;->wrap(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/material/search/SearchView;->toolbar:Lcom/google/android/material/appbar/MaterialToolbar;

    invoke-virtual {v1}, Lcom/google/android/material/appbar/MaterialToolbar;->getNavigationIconTint()Ljava/lang/Integer;

    move-result-object v1

    if-eqz v1, :cond_3d

    iget-object v1, p0, Lcom/google/android/material/search/SearchView;->toolbar:Lcom/google/android/material/appbar/MaterialToolbar;

    invoke-virtual {v1}, Lcom/google/android/material/appbar/MaterialToolbar;->getNavigationIconTint()Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    invoke-static {v0, v1}, Landroidx/core/graphics/drawable/DrawableCompat;->setTint(Landroid/graphics/drawable/Drawable;I)V

    :cond_3d
    iget-object v1, p0, Lcom/google/android/material/search/SearchView;->toolbar:Lcom/google/android/material/appbar/MaterialToolbar;

    new-instance v2, Lcom/google/android/material/internal/FadeThroughDrawable;

    iget-object v3, p0, Lcom/google/android/material/search/SearchView;->searchBar:Lcom/google/android/material/search/SearchBar;

    invoke-virtual {v3}, Lcom/google/android/material/search/SearchBar;->getNavigationIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-direct {v2, v3, v0}, Lcom/google/android/material/internal/FadeThroughDrawable;-><init>(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    invoke-virtual {v1, v2}, Lcom/google/android/material/appbar/MaterialToolbar;->setNavigationIcon(Landroid/graphics/drawable/Drawable;)V

    invoke-direct {p0}, Lcom/google/android/material/search/SearchView;->updateNavigationIconProgressIfNeeded()V

    :goto_50
    return-void
.end method

.method private updateNavigationIconProgressIfNeeded()V
    .registers 5

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->toolbar:Lcom/google/android/material/appbar/MaterialToolbar;

    invoke-static {v0}, Lcom/google/android/material/internal/ToolbarUtils;->getNavigationIconButton(Landroidx/appcompat/widget/Toolbar;)Landroid/widget/ImageButton;

    move-result-object v0

    if-nez v0, :cond_9

    return-void

    :cond_9
    iget-object v1, p0, Lcom/google/android/material/search/SearchView;->rootView:Lcom/google/android/material/internal/ClippableRoundedCornerLayout;

    invoke-virtual {v1}, Lcom/google/android/material/internal/ClippableRoundedCornerLayout;->getVisibility()I

    move-result v1

    if-nez v1, :cond_13

    const/4 v1, 0x1

    goto :goto_14

    :cond_13
    const/4 v1, 0x0

    :goto_14
    invoke-virtual {v0}, Landroid/widget/ImageButton;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-static {v0}, Landroidx/core/graphics/drawable/DrawableCompat;->unwrap(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    instance-of v2, v0, Landroidx/appcompat/graphics/drawable/DrawerArrowDrawable;

    if-eqz v2, :cond_27

    move-object v2, v0

    check-cast v2, Landroidx/appcompat/graphics/drawable/DrawerArrowDrawable;

    int-to-float v3, v1

    invoke-virtual {v2, v3}, Landroidx/appcompat/graphics/drawable/DrawerArrowDrawable;->setProgress(F)V

    :cond_27
    instance-of v2, v0, Lcom/google/android/material/internal/FadeThroughDrawable;

    if-eqz v2, :cond_31

    check-cast v0, Lcom/google/android/material/internal/FadeThroughDrawable;

    int-to-float v1, v1

    invoke-virtual {v0, v1}, Lcom/google/android/material/internal/FadeThroughDrawable;->setProgress(F)V

    :cond_31
    return-void
.end method


# virtual methods
.method public addHeaderView(Landroid/view/View;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->headerContainer:Landroid/widget/FrameLayout;

    invoke-virtual {v0, p1}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V

    iget-object p1, p0, Lcom/google/android/material/search/SearchView;->headerContainer:Landroid/widget/FrameLayout;

    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/widget/FrameLayout;->setVisibility(I)V

    return-void
.end method

.method public addTransitionListener(Lcom/google/android/material/search/SearchView$TransitionListener;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->transitionListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V
    .registers 5

    iget-boolean v0, p0, Lcom/google/android/material/search/SearchView;->layoutInflated:Z

    if-eqz v0, :cond_a

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->contentContainer:Lcom/google/android/material/internal/TouchObserverFrameLayout;

    invoke-virtual {v0, p1, p2, p3}, Lcom/google/android/material/internal/TouchObserverFrameLayout;->addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    goto :goto_d

    :cond_a
    invoke-super {p0, p1, p2, p3}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    :goto_d
    return-void
.end method

.method public clearFocusAndHideKeyboard()V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->editText:Landroid/widget/EditText;

    new-instance v1, Lcom/google/android/material/search/SearchView$$ExternalSyntheticLambda9;

    invoke-direct {v1, p0}, Lcom/google/android/material/search/SearchView$$ExternalSyntheticLambda9;-><init>(Lcom/google/android/material/search/SearchView;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->post(Ljava/lang/Runnable;)Z

    return-void
.end method

.method public clearText()V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->editText:Landroid/widget/EditText;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method

.method public getBehavior()Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior<",
            "Lcom/google/android/material/search/SearchView;",
            ">;"
        }
    .end annotation

    new-instance v0, Lcom/google/android/material/search/SearchView$Behavior;

    invoke-direct {v0}, Lcom/google/android/material/search/SearchView$Behavior;-><init>()V

    return-object v0
.end method

.method public getCurrentTransitionState()Lcom/google/android/material/search/SearchView$TransitionState;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->currentTransitionState:Lcom/google/android/material/search/SearchView$TransitionState;

    return-object v0
.end method

.method public getEditText()Landroid/widget/EditText;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->editText:Landroid/widget/EditText;

    return-object v0
.end method

.method public getHint()Ljava/lang/CharSequence;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->editText:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getHint()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public getSearchPrefix()Landroid/widget/TextView;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->searchPrefix:Landroid/widget/TextView;

    return-object v0
.end method

.method public getSearchPrefixText()Ljava/lang/CharSequence;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->searchPrefix:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public getSoftInputMode()I
    .registers 2

    iget v0, p0, Lcom/google/android/material/search/SearchView;->softInputMode:I

    return v0
.end method

.method public getText()Landroid/text/Editable;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->editText:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    return-object v0
.end method

.method public getToolbar()Landroidx/appcompat/widget/Toolbar;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->toolbar:Lcom/google/android/material/appbar/MaterialToolbar;

    return-object v0
.end method

.method public hide()V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->currentTransitionState:Lcom/google/android/material/search/SearchView$TransitionState;

    sget-object v1, Lcom/google/android/material/search/SearchView$TransitionState;->HIDDEN:Lcom/google/android/material/search/SearchView$TransitionState;

    invoke-virtual {v0, v1}, Lcom/google/android/material/search/SearchView$TransitionState;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1e

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->currentTransitionState:Lcom/google/android/material/search/SearchView$TransitionState;

    sget-object v1, Lcom/google/android/material/search/SearchView$TransitionState;->HIDING:Lcom/google/android/material/search/SearchView$TransitionState;

    invoke-virtual {v0, v1}, Lcom/google/android/material/search/SearchView$TransitionState;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_15

    goto :goto_1e

    :cond_15
    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->searchViewAnimationHelper:Lcom/google/android/material/search/SearchViewAnimationHelper;

    invoke-virtual {v0}, Lcom/google/android/material/search/SearchViewAnimationHelper;->hide()V

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/google/android/material/search/SearchView;->setModalForAccessibility(Z)V

    :cond_1e
    :goto_1e
    return-void
.end method

.method public inflateMenu(I)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->toolbar:Lcom/google/android/material/appbar/MaterialToolbar;

    invoke-virtual {v0, p1}, Lcom/google/android/material/appbar/MaterialToolbar;->inflateMenu(I)V

    return-void
.end method

.method isAdjustNothingSoftInputMode()Z
    .registers 3

    iget v0, p0, Lcom/google/android/material/search/SearchView;->softInputMode:I

    const/16 v1, 0x30

    if-ne v0, v1, :cond_8

    const/4 v0, 0x1

    goto :goto_9

    :cond_8
    const/4 v0, 0x0

    :goto_9
    return v0
.end method

.method public isAnimatedNavigationIcon()Z
    .registers 2

    iget-boolean v0, p0, Lcom/google/android/material/search/SearchView;->animatedNavigationIcon:Z

    return v0
.end method

.method public isAutoShowKeyboard()Z
    .registers 2

    iget-boolean v0, p0, Lcom/google/android/material/search/SearchView;->autoShowKeyboard:Z

    return v0
.end method

.method public isMenuItemsAnimated()Z
    .registers 2

    iget-boolean v0, p0, Lcom/google/android/material/search/SearchView;->animatedMenuItems:Z

    return v0
.end method

.method public isSetupWithSearchBar()Z
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->searchBar:Lcom/google/android/material/search/SearchBar;

    if-eqz v0, :cond_6

    const/4 v0, 0x1

    goto :goto_7

    :cond_6
    const/4 v0, 0x0

    :goto_7
    return v0
.end method

.method public isShowing()Z
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->currentTransitionState:Lcom/google/android/material/search/SearchView$TransitionState;

    sget-object v1, Lcom/google/android/material/search/SearchView$TransitionState;->SHOWN:Lcom/google/android/material/search/SearchView$TransitionState;

    invoke-virtual {v0, v1}, Lcom/google/android/material/search/SearchView$TransitionState;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_17

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->currentTransitionState:Lcom/google/android/material/search/SearchView$TransitionState;

    sget-object v1, Lcom/google/android/material/search/SearchView$TransitionState;->SHOWING:Lcom/google/android/material/search/SearchView$TransitionState;

    invoke-virtual {v0, v1}, Lcom/google/android/material/search/SearchView$TransitionState;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_15

    goto :goto_17

    :cond_15
    const/4 v0, 0x0

    goto :goto_18

    :cond_17
    :goto_17
    const/4 v0, 0x1

    :goto_18
    return v0
.end method

.method public isUseWindowInsetsController()Z
    .registers 2

    iget-boolean v0, p0, Lcom/google/android/material/search/SearchView;->useWindowInsetsController:Z

    return v0
.end method

.method synthetic lambda$clearFocusAndHideKeyboard$9$com-google-android-material-search-SearchView()V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->editText:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->clearFocus()V

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->searchBar:Lcom/google/android/material/search/SearchBar;

    if-eqz v0, :cond_c

    invoke-virtual {v0}, Lcom/google/android/material/search/SearchBar;->requestFocus()Z

    :cond_c
    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->editText:Landroid/widget/EditText;

    iget-boolean v1, p0, Lcom/google/android/material/search/SearchView;->useWindowInsetsController:Z

    invoke-static {v0, v1}, Lcom/google/android/material/internal/ViewUtils;->hideKeyboard(Landroid/view/View;Z)V

    return-void
.end method

.method synthetic lambda$requestFocusAndShowKeyboard$8$com-google-android-material-search-SearchView()V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->editText:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->requestFocus()Z

    move-result v0

    if-eqz v0, :cond_f

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->editText:Landroid/widget/EditText;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->sendAccessibilityEvent(I)V

    :cond_f
    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->editText:Landroid/widget/EditText;

    iget-boolean v1, p0, Lcom/google/android/material/search/SearchView;->useWindowInsetsController:Z

    invoke-static {v0, v1}, Lcom/google/android/material/internal/ViewUtils;->showKeyboard(Landroid/view/View;Z)V

    return-void
.end method

.method synthetic lambda$setUpBackButton$1$com-google-android-material-search-SearchView(Landroid/view/View;)V
    .registers 2

    invoke-virtual {p0}, Lcom/google/android/material/search/SearchView;->hide()V

    return-void
.end method

.method synthetic lambda$setUpClearButton$2$com-google-android-material-search-SearchView(Landroid/view/View;)V
    .registers 2

    invoke-virtual {p0}, Lcom/google/android/material/search/SearchView;->clearText()V

    invoke-virtual {p0}, Lcom/google/android/material/search/SearchView;->requestFocusAndShowKeyboardIfNeeded()V

    return-void
.end method

.method synthetic lambda$setUpContentOnTouchListener$3$com-google-android-material-search-SearchView(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .registers 3

    invoke-virtual {p0}, Lcom/google/android/material/search/SearchView;->isAdjustNothingSoftInputMode()Z

    move-result p1

    if-eqz p1, :cond_9

    invoke-virtual {p0}, Lcom/google/android/material/search/SearchView;->clearFocusAndHideKeyboard()V

    :cond_9
    const/4 p1, 0x0

    return p1
.end method

.method synthetic lambda$setUpStatusBarSpacerInsetListener$5$com-google-android-material-search-SearchView(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;
    .registers 4

    invoke-virtual {p2}, Landroidx/core/view/WindowInsetsCompat;->getSystemWindowInsetTop()I

    move-result p1

    invoke-direct {p0, p1}, Lcom/google/android/material/search/SearchView;->setUpStatusBarSpacer(I)V

    iget-boolean v0, p0, Lcom/google/android/material/search/SearchView;->statusBarSpacerEnabledOverride:Z

    if-nez v0, :cond_13

    if-lez p1, :cond_f

    const/4 p1, 0x1

    goto :goto_10

    :cond_f
    const/4 p1, 0x0

    :goto_10
    invoke-direct {p0, p1}, Lcom/google/android/material/search/SearchView;->setStatusBarSpacerEnabledInternal(Z)V

    :cond_13
    return-object p2
.end method

.method synthetic lambda$setUpToolbarInsetListener$4$com-google-android-material-search-SearchView(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;Lcom/google/android/material/internal/ViewUtils$RelativePadding;)Landroidx/core/view/WindowInsetsCompat;
    .registers 8

    iget-object p1, p0, Lcom/google/android/material/search/SearchView;->toolbar:Lcom/google/android/material/appbar/MaterialToolbar;

    invoke-static {p1}, Lcom/google/android/material/internal/ViewUtils;->isLayoutRtl(Landroid/view/View;)Z

    move-result p1

    if-eqz p1, :cond_b

    iget v0, p3, Lcom/google/android/material/internal/ViewUtils$RelativePadding;->end:I

    goto :goto_d

    :cond_b
    iget v0, p3, Lcom/google/android/material/internal/ViewUtils$RelativePadding;->start:I

    :goto_d
    if-eqz p1, :cond_12

    iget p1, p3, Lcom/google/android/material/internal/ViewUtils$RelativePadding;->start:I

    goto :goto_14

    :cond_12
    iget p1, p3, Lcom/google/android/material/internal/ViewUtils$RelativePadding;->end:I

    :goto_14
    iget-object v1, p0, Lcom/google/android/material/search/SearchView;->toolbar:Lcom/google/android/material/appbar/MaterialToolbar;

    invoke-virtual {p2}, Landroidx/core/view/WindowInsetsCompat;->getSystemWindowInsetLeft()I

    move-result v2

    add-int/2addr v0, v2

    iget v2, p3, Lcom/google/android/material/internal/ViewUtils$RelativePadding;->top:I

    invoke-virtual {p2}, Landroidx/core/view/WindowInsetsCompat;->getSystemWindowInsetRight()I

    move-result v3

    add-int/2addr p1, v3

    iget p3, p3, Lcom/google/android/material/internal/ViewUtils$RelativePadding;->bottom:I

    invoke-virtual {v1, v0, v2, p1, p3}, Lcom/google/android/material/appbar/MaterialToolbar;->setPadding(IIII)V

    return-object p2
.end method

.method synthetic lambda$setupWithSearchBar$7$com-google-android-material-search-SearchView(Landroid/view/View;)V
    .registers 2

    invoke-virtual {p0}, Lcom/google/android/material/search/SearchView;->show()V

    return-void
.end method

.method protected onAttachedToWindow()V
    .registers 1

    invoke-super {p0}, Landroid/widget/FrameLayout;->onAttachedToWindow()V

    invoke-static {p0}, Lcom/google/android/material/shape/MaterialShapeUtils;->setParentAbsoluteElevation(Landroid/view/View;)V

    return-void
.end method

.method protected onFinishInflate()V
    .registers 1

    invoke-super {p0}, Landroid/widget/FrameLayout;->onFinishInflate()V

    invoke-virtual {p0}, Lcom/google/android/material/search/SearchView;->updateSoftInputMode()V

    return-void
.end method

.method protected onRestoreInstanceState(Landroid/os/Parcelable;)V
    .registers 3

    instance-of v0, p1, Lcom/google/android/material/search/SearchView$SavedState;

    if-nez v0, :cond_8

    invoke-super {p0, p1}, Landroid/widget/FrameLayout;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    return-void

    :cond_8
    check-cast p1, Lcom/google/android/material/search/SearchView$SavedState;

    invoke-virtual {p1}, Lcom/google/android/material/search/SearchView$SavedState;->getSuperState()Landroid/os/Parcelable;

    move-result-object v0

    invoke-super {p0, v0}, Landroid/widget/FrameLayout;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    iget-object v0, p1, Lcom/google/android/material/search/SearchView$SavedState;->text:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/google/android/material/search/SearchView;->setText(Ljava/lang/CharSequence;)V

    iget p1, p1, Lcom/google/android/material/search/SearchView$SavedState;->visibility:I

    if-nez p1, :cond_1c

    const/4 p1, 0x1

    goto :goto_1d

    :cond_1c
    const/4 p1, 0x0

    :goto_1d
    invoke-virtual {p0, p1}, Lcom/google/android/material/search/SearchView;->setVisible(Z)V

    return-void
.end method

.method protected onSaveInstanceState()Landroid/os/Parcelable;
    .registers 3

    new-instance v0, Lcom/google/android/material/search/SearchView$SavedState;

    invoke-super {p0}, Landroid/widget/FrameLayout;->onSaveInstanceState()Landroid/os/Parcelable;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/google/android/material/search/SearchView$SavedState;-><init>(Landroid/os/Parcelable;)V

    invoke-virtual {p0}, Lcom/google/android/material/search/SearchView;->getText()Landroid/text/Editable;

    move-result-object v1

    if-nez v1, :cond_11

    const/4 v1, 0x0

    goto :goto_15

    :cond_11
    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    :goto_15
    iput-object v1, v0, Lcom/google/android/material/search/SearchView$SavedState;->text:Ljava/lang/String;

    iget-object v1, p0, Lcom/google/android/material/search/SearchView;->rootView:Lcom/google/android/material/internal/ClippableRoundedCornerLayout;

    invoke-virtual {v1}, Lcom/google/android/material/internal/ClippableRoundedCornerLayout;->getVisibility()I

    move-result v1

    iput v1, v0, Lcom/google/android/material/search/SearchView$SavedState;->visibility:I

    return-object v0
.end method

.method public removeAllHeaderViews()V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->headerContainer:Landroid/widget/FrameLayout;

    invoke-virtual {v0}, Landroid/widget/FrameLayout;->removeAllViews()V

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->headerContainer:Landroid/widget/FrameLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->setVisibility(I)V

    return-void
.end method

.method public removeHeaderView(Landroid/view/View;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->headerContainer:Landroid/widget/FrameLayout;

    invoke-virtual {v0, p1}, Landroid/widget/FrameLayout;->removeView(Landroid/view/View;)V

    iget-object p1, p0, Lcom/google/android/material/search/SearchView;->headerContainer:Landroid/widget/FrameLayout;

    invoke-virtual {p1}, Landroid/widget/FrameLayout;->getChildCount()I

    move-result p1

    if-nez p1, :cond_14

    iget-object p1, p0, Lcom/google/android/material/search/SearchView;->headerContainer:Landroid/widget/FrameLayout;

    const/16 v0, 0x8

    invoke-virtual {p1, v0}, Landroid/widget/FrameLayout;->setVisibility(I)V

    :cond_14
    return-void
.end method

.method public removeTransitionListener(Lcom/google/android/material/search/SearchView$TransitionListener;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->transitionListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    return-void
.end method

.method public requestFocusAndShowKeyboard()V
    .registers 5

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->editText:Landroid/widget/EditText;

    new-instance v1, Lcom/google/android/material/search/SearchView$$ExternalSyntheticLambda5;

    invoke-direct {v1, p0}, Lcom/google/android/material/search/SearchView$$ExternalSyntheticLambda5;-><init>(Lcom/google/android/material/search/SearchView;)V

    const-wide/16 v2, 0x64

    invoke-virtual {v0, v1, v2, v3}, Landroid/widget/EditText;->postDelayed(Ljava/lang/Runnable;J)Z

    return-void
.end method

.method requestFocusAndShowKeyboardIfNeeded()V
    .registers 2

    iget-boolean v0, p0, Lcom/google/android/material/search/SearchView;->autoShowKeyboard:Z

    if-eqz v0, :cond_7

    invoke-virtual {p0}, Lcom/google/android/material/search/SearchView;->requestFocusAndShowKeyboard()V

    :cond_7
    return-void
.end method

.method public setAnimatedNavigationIcon(Z)V
    .registers 2

    iput-boolean p1, p0, Lcom/google/android/material/search/SearchView;->animatedNavigationIcon:Z

    return-void
.end method

.method public setAutoShowKeyboard(Z)V
    .registers 2

    iput-boolean p1, p0, Lcom/google/android/material/search/SearchView;->autoShowKeyboard:Z

    return-void
.end method

.method public setElevation(F)V
    .registers 2

    invoke-super {p0, p1}, Landroid/widget/FrameLayout;->setElevation(F)V

    invoke-direct {p0, p1}, Lcom/google/android/material/search/SearchView;->setUpBackgroundViewElevationOverlay(F)V

    return-void
.end method

.method public setHint(I)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->editText:Landroid/widget/EditText;

    invoke-virtual {v0, p1}, Landroid/widget/EditText;->setHint(I)V

    return-void
.end method

.method public setHint(Ljava/lang/CharSequence;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->editText:Landroid/widget/EditText;

    invoke-virtual {v0, p1}, Landroid/widget/EditText;->setHint(Ljava/lang/CharSequence;)V

    return-void
.end method

.method public setMenuItemsAnimated(Z)V
    .registers 2

    iput-boolean p1, p0, Lcom/google/android/material/search/SearchView;->animatedMenuItems:Z

    return-void
.end method

.method public setModalForAccessibility(Z)V
    .registers 5

    invoke-virtual {p0}, Lcom/google/android/material/search/SearchView;->getRootView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    if-eqz p1, :cond_13

    new-instance v1, Ljava/util/HashMap;

    invoke-virtual {v0}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v2

    invoke-direct {v1, v2}, Ljava/util/HashMap;-><init>(I)V

    iput-object v1, p0, Lcom/google/android/material/search/SearchView;->childImportantForAccessibilityMap:Ljava/util/Map;

    :cond_13
    invoke-direct {p0, v0, p1}, Lcom/google/android/material/search/SearchView;->updateChildImportantForAccessibility(Landroid/view/ViewGroup;Z)V

    if-nez p1, :cond_1b

    const/4 p1, 0x0

    iput-object p1, p0, Lcom/google/android/material/search/SearchView;->childImportantForAccessibilityMap:Ljava/util/Map;

    :cond_1b
    return-void
.end method

.method public setOnMenuItemClickListener(Landroidx/appcompat/widget/Toolbar$OnMenuItemClickListener;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->toolbar:Lcom/google/android/material/appbar/MaterialToolbar;

    invoke-virtual {v0, p1}, Lcom/google/android/material/appbar/MaterialToolbar;->setOnMenuItemClickListener(Landroidx/appcompat/widget/Toolbar$OnMenuItemClickListener;)V

    return-void
.end method

.method public setSearchPrefixText(Ljava/lang/CharSequence;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->searchPrefix:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->searchPrefix:Landroid/widget/TextView;

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result p1

    if-eqz p1, :cond_10

    const/16 p1, 0x8

    goto :goto_11

    :cond_10
    const/4 p1, 0x0

    :goto_11
    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setVisibility(I)V

    return-void
.end method

.method public setStatusBarSpacerEnabled(Z)V
    .registers 3

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/material/search/SearchView;->statusBarSpacerEnabledOverride:Z

    invoke-direct {p0, p1}, Lcom/google/android/material/search/SearchView;->setStatusBarSpacerEnabledInternal(Z)V

    return-void
.end method

.method public setText(I)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->editText:Landroid/widget/EditText;

    invoke-virtual {v0, p1}, Landroid/widget/EditText;->setText(I)V

    return-void
.end method

.method public setText(Ljava/lang/CharSequence;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->editText:Landroid/widget/EditText;

    invoke-virtual {v0, p1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method

.method public setToolbarTouchscreenBlocksFocus(Z)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->toolbar:Lcom/google/android/material/appbar/MaterialToolbar;

    invoke-virtual {v0, p1}, Lcom/google/android/material/appbar/MaterialToolbar;->setTouchscreenBlocksFocus(Z)V

    return-void
.end method

.method setTransitionState(Lcom/google/android/material/search/SearchView$TransitionState;)V
    .registers 5

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->currentTransitionState:Lcom/google/android/material/search/SearchView$TransitionState;

    invoke-virtual {v0, p1}, Lcom/google/android/material/search/SearchView$TransitionState;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_9

    return-void

    :cond_9
    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->currentTransitionState:Lcom/google/android/material/search/SearchView$TransitionState;

    iput-object p1, p0, Lcom/google/android/material/search/SearchView;->currentTransitionState:Lcom/google/android/material/search/SearchView$TransitionState;

    new-instance v1, Ljava/util/LinkedHashSet;

    iget-object v2, p0, Lcom/google/android/material/search/SearchView;->transitionListeners:Ljava/util/Set;

    invoke-direct {v1, v2}, Ljava/util/LinkedHashSet;-><init>(Ljava/util/Collection;)V

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_18
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_28

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/material/search/SearchView$TransitionListener;

    invoke-interface {v2, p0, v0, p1}, Lcom/google/android/material/search/SearchView$TransitionListener;->onStateChanged(Lcom/google/android/material/search/SearchView;Lcom/google/android/material/search/SearchView$TransitionState;Lcom/google/android/material/search/SearchView$TransitionState;)V

    goto :goto_18

    :cond_28
    return-void
.end method

.method public setUseWindowInsetsController(Z)V
    .registers 2

    iput-boolean p1, p0, Lcom/google/android/material/search/SearchView;->useWindowInsetsController:Z

    return-void
.end method

.method public setVisible(Z)V
    .registers 5

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->rootView:Lcom/google/android/material/internal/ClippableRoundedCornerLayout;

    invoke-virtual {v0}, Lcom/google/android/material/internal/ClippableRoundedCornerLayout;->getVisibility()I

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    const/4 v0, 0x1

    goto :goto_c

    :cond_b
    move v0, v1

    :goto_c
    iget-object v2, p0, Lcom/google/android/material/search/SearchView;->rootView:Lcom/google/android/material/internal/ClippableRoundedCornerLayout;

    if-eqz p1, :cond_11

    goto :goto_13

    :cond_11
    const/16 v1, 0x8

    :goto_13
    invoke-virtual {v2, v1}, Lcom/google/android/material/internal/ClippableRoundedCornerLayout;->setVisibility(I)V

    invoke-direct {p0}, Lcom/google/android/material/search/SearchView;->updateNavigationIconProgressIfNeeded()V

    if-eq v0, p1, :cond_1e

    invoke-virtual {p0, p1}, Lcom/google/android/material/search/SearchView;->setModalForAccessibility(Z)V

    :cond_1e
    if-eqz p1, :cond_23

    sget-object p1, Lcom/google/android/material/search/SearchView$TransitionState;->SHOWN:Lcom/google/android/material/search/SearchView$TransitionState;

    goto :goto_25

    :cond_23
    sget-object p1, Lcom/google/android/material/search/SearchView$TransitionState;->HIDDEN:Lcom/google/android/material/search/SearchView$TransitionState;

    :goto_25
    invoke-virtual {p0, p1}, Lcom/google/android/material/search/SearchView;->setTransitionState(Lcom/google/android/material/search/SearchView$TransitionState;)V

    return-void
.end method

.method public setupWithSearchBar(Lcom/google/android/material/search/SearchBar;)V
    .registers 3

    iput-object p1, p0, Lcom/google/android/material/search/SearchView;->searchBar:Lcom/google/android/material/search/SearchBar;

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->searchViewAnimationHelper:Lcom/google/android/material/search/SearchViewAnimationHelper;

    invoke-virtual {v0, p1}, Lcom/google/android/material/search/SearchViewAnimationHelper;->setSearchBar(Lcom/google/android/material/search/SearchBar;)V

    if-eqz p1, :cond_11

    new-instance v0, Lcom/google/android/material/search/SearchView$$ExternalSyntheticLambda6;

    invoke-direct {v0, p0}, Lcom/google/android/material/search/SearchView$$ExternalSyntheticLambda6;-><init>(Lcom/google/android/material/search/SearchView;)V

    invoke-virtual {p1, v0}, Lcom/google/android/material/search/SearchBar;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    :cond_11
    invoke-direct {p0}, Lcom/google/android/material/search/SearchView;->updateNavigationIconIfNeeded()V

    invoke-direct {p0}, Lcom/google/android/material/search/SearchView;->setUpBackgroundViewElevationOverlay()V

    return-void
.end method

.method public show()V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->currentTransitionState:Lcom/google/android/material/search/SearchView$TransitionState;

    sget-object v1, Lcom/google/android/material/search/SearchView$TransitionState;->SHOWN:Lcom/google/android/material/search/SearchView$TransitionState;

    invoke-virtual {v0, v1}, Lcom/google/android/material/search/SearchView$TransitionState;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1e

    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->currentTransitionState:Lcom/google/android/material/search/SearchView$TransitionState;

    sget-object v1, Lcom/google/android/material/search/SearchView$TransitionState;->SHOWING:Lcom/google/android/material/search/SearchView$TransitionState;

    invoke-virtual {v0, v1}, Lcom/google/android/material/search/SearchView$TransitionState;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_15

    goto :goto_1e

    :cond_15
    iget-object v0, p0, Lcom/google/android/material/search/SearchView;->searchViewAnimationHelper:Lcom/google/android/material/search/SearchViewAnimationHelper;

    invoke-virtual {v0}, Lcom/google/android/material/search/SearchViewAnimationHelper;->show()V

    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/google/android/material/search/SearchView;->setModalForAccessibility(Z)V

    :cond_1e
    :goto_1e
    return-void
.end method

.method public updateSoftInputMode()V
    .registers 2

    invoke-direct {p0}, Lcom/google/android/material/search/SearchView;->getActivityWindow()Landroid/view/Window;

    move-result-object v0

    if-eqz v0, :cond_e

    invoke-virtual {v0}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v0

    iget v0, v0, Landroid/view/WindowManager$LayoutParams;->softInputMode:I

    iput v0, p0, Lcom/google/android/material/search/SearchView;->softInputMode:I

    :cond_e
    return-void
.end method
