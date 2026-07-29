.class public final Lcom/blankj/utilcode/util/BarUtils;
.super Ljava/lang/Object;
.source "BarUtils.java"


# static fields
.field private static final KEY_OFFSET:I = -0x7b

.field private static final TAG_OFFSET:Ljava/lang/String; = "TAG_OFFSET"

.field private static final TAG_STATUS_BAR:Ljava/lang/String; = "TAG_STATUS_BAR"


# direct methods
.method private constructor <init>()V
    .registers 3

    .line 50
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 51
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "u can\'t instantiate me..."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static addMarginTopEqualStatusBarHeight(Landroid/view/View;)V
    .registers 7

    const-string v0, "TAG_OFFSET"

    .line 169
    invoke-virtual {p0, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    const/16 v0, -0x7b

    .line 170
    invoke-virtual {p0, v0}, Landroid/view/View;->getTag(I)Ljava/lang/Object;

    move-result-object v1

    if-eqz v1, :cond_16

    .line 171
    check-cast v1, Ljava/lang/Boolean;

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_16

    return-void

    .line 172
    :cond_16
    invoke-virtual {p0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 173
    iget v2, v1, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    iget v3, v1, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    .line 174
    invoke-static {}, Lcom/blankj/utilcode/util/BarUtils;->getStatusBarHeight()I

    move-result v4

    add-int/2addr v3, v4

    iget v4, v1, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    iget v5, v1, Landroid/view/ViewGroup$MarginLayoutParams;->bottomMargin:I

    .line 173
    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/view/ViewGroup$MarginLayoutParams;->setMargins(IIII)V

    const/4 v1, 0x1

    .line 177
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Landroid/view/View;->setTag(ILjava/lang/Object;)V

    return-void
.end method

.method private static addMarginTopEqualStatusBarHeight(Landroid/view/Window;)V
    .registers 2

    .line 199
    invoke-virtual {p0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object p0

    const-string v0, "TAG_OFFSET"

    invoke-virtual {p0, v0}, Landroid/view/View;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;

    move-result-object p0

    if-nez p0, :cond_d

    return-void

    .line 201
    :cond_d
    invoke-static {p0}, Lcom/blankj/utilcode/util/BarUtils;->addMarginTopEqualStatusBarHeight(Landroid/view/View;)V

    return-void
.end method

.method private static applyStatusBarColor(Landroid/app/Activity;IZ)Landroid/view/View;
    .registers 3

    .line 355
    invoke-virtual {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object p0

    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/BarUtils;->applyStatusBarColor(Landroid/view/Window;IZ)Landroid/view/View;

    move-result-object p0

    return-object p0
.end method

.method private static applyStatusBarColor(Landroid/view/Window;IZ)Landroid/view/View;
    .registers 4

    if-eqz p2, :cond_9

    .line 362
    invoke-virtual {p0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object p2

    check-cast p2, Landroid/view/ViewGroup;

    goto :goto_12

    :cond_9
    const p2, 0x1020002

    .line 363
    invoke-virtual {p0, p2}, Landroid/view/Window;->findViewById(I)Landroid/view/View;

    move-result-object p2

    check-cast p2, Landroid/view/ViewGroup;

    :goto_12
    const-string v0, "TAG_STATUS_BAR"

    .line 364
    invoke-virtual {p2, v0}, Landroid/view/ViewGroup;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_2a

    .line 366
    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result p0

    const/16 p2, 0x8

    if-ne p0, p2, :cond_26

    const/4 p0, 0x0

    .line 367
    invoke-virtual {v0, p0}, Landroid/view/View;->setVisibility(I)V

    .line 369
    :cond_26
    invoke-virtual {v0, p1}, Landroid/view/View;->setBackgroundColor(I)V

    goto :goto_35

    .line 371
    :cond_2a
    invoke-virtual {p0}, Landroid/view/Window;->getContext()Landroid/content/Context;

    move-result-object p0

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/BarUtils;->createStatusBarView(Landroid/content/Context;I)Landroid/view/View;

    move-result-object v0

    .line 372
    invoke-virtual {p2, v0}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    :goto_35
    return-object v0
.end method

.method private static createStatusBarView(Landroid/content/Context;I)Landroid/view/View;
    .registers 5

    .line 397
    new-instance v0, Landroid/view/View;

    invoke-direct {v0, p0}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 398
    new-instance p0, Landroid/view/ViewGroup$LayoutParams;

    const/4 v1, -0x1

    .line 399
    invoke-static {}, Lcom/blankj/utilcode/util/BarUtils;->getStatusBarHeight()I

    move-result v2

    invoke-direct {p0, v1, v2}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    .line 398
    invoke-virtual {v0, p0}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 400
    invoke-virtual {v0, p1}, Landroid/view/View;->setBackgroundColor(I)V

    const-string p0, "TAG_STATUS_BAR"

    .line 401
    invoke-virtual {v0, p0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    return-object v0
.end method

.method public static getActionBarHeight()I
    .registers 4

    .line 433
    new-instance v0, Landroid/util/TypedValue;

    invoke-direct {v0}, Landroid/util/TypedValue;-><init>()V

    .line 434
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Application;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v1

    const v2, 0x10102eb

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v0, v3}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    move-result v1

    if-eqz v1, :cond_2a

    .line 435
    iget v0, v0, Landroid/util/TypedValue;->data:I

    .line 436
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Application;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    .line 435
    invoke-static {v0, v1}, Landroid/util/TypedValue;->complexToDimensionPixelSize(ILandroid/util/DisplayMetrics;)I

    move-result v0

    return v0

    :cond_2a
    const/4 v0, 0x0

    return v0
.end method

.method public static getNavBarColor(Landroid/app/Activity;)I
    .registers 1

    .line 628
    invoke-virtual {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/BarUtils;->getNavBarColor(Landroid/view/Window;)I

    move-result p0

    return p0
.end method

.method public static getNavBarColor(Landroid/view/Window;)I
    .registers 1

    .line 639
    invoke-virtual {p0}, Landroid/view/Window;->getNavigationBarColor()I

    move-result p0

    return p0
.end method

.method public static getNavBarHeight()I
    .registers 4

    .line 486
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v0

    const-string v1, "dimen"

    const-string v2, "android"

    const-string v3, "navigation_bar_height"

    .line 487
    invoke-virtual {v0, v3, v1, v2}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    if-eqz v1, :cond_15

    .line 489
    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    return v0

    :cond_15
    const/4 v0, 0x0

    return v0
.end method

.method private static getResNameById(I)Ljava/lang/String;
    .registers 2

    .line 591
    :try_start_0
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Application;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/content/res/Resources;->getResourceEntryName(I)Ljava/lang/String;

    move-result-object p0
    :try_end_c
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_c} :catch_d

    return-object p0

    :catch_d
    const-string p0, ""

    return-object p0
.end method

.method public static getStatusBarHeight()I
    .registers 4

    .line 60
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v0

    const-string v1, "dimen"

    const-string v2, "android"

    const-string v3, "status_bar_height"

    .line 61
    invoke-virtual {v0, v3, v1, v2}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    .line 62
    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    return v0
.end method

.method private static hideStatusBarView(Landroid/app/Activity;)V
    .registers 1

    .line 378
    invoke-virtual {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/BarUtils;->hideStatusBarView(Landroid/view/Window;)V

    return-void
.end method

.method private static hideStatusBarView(Landroid/view/Window;)V
    .registers 2

    .line 382
    invoke-virtual {p0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object p0

    check-cast p0, Landroid/view/ViewGroup;

    const-string v0, "TAG_STATUS_BAR"

    .line 383
    invoke-virtual {p0, v0}, Landroid/view/ViewGroup;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;

    move-result-object p0

    if-nez p0, :cond_f

    return-void

    :cond_f
    const/16 v0, 0x8

    .line 385
    invoke-virtual {p0, v0}, Landroid/view/View;->setVisibility(I)V

    return-void
.end method

.method private static invokePanels(Ljava/lang/String;)V
    .registers 5

    .line 466
    :try_start_0
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    const-string v1, "statusbar"

    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    const-string v1, "android.app.StatusBarManager"

    .line 468
    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    const/4 v2, 0x0

    new-array v3, v2, [Ljava/lang/Class;

    .line 469
    invoke-virtual {v1, p0, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object p0

    new-array v1, v2, [Ljava/lang/Object;

    .line 470
    invoke-virtual {p0, v0, v1}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1c
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_1c} :catch_1d

    goto :goto_21

    :catch_1d
    move-exception p0

    .line 472
    invoke-virtual {p0}, Ljava/lang/Exception;->printStackTrace()V

    :goto_21
    return-void
.end method

.method public static isNavBarLightMode(Landroid/app/Activity;)Z
    .registers 1

    .line 701
    invoke-virtual {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/BarUtils;->isNavBarLightMode(Landroid/view/Window;)Z

    move-result p0

    return p0
.end method

.method public static isNavBarLightMode(Landroid/view/Window;)Z
    .registers 1

    .line 712
    invoke-virtual {p0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object p0

    .line 713
    invoke-virtual {p0}, Landroid/view/View;->getSystemUiVisibility()I

    move-result p0

    and-int/lit8 p0, p0, 0x10

    if-eqz p0, :cond_e

    const/4 p0, 0x1

    goto :goto_f

    :cond_e
    const/4 p0, 0x0

    :goto_f
    return p0
.end method

.method public static isNavBarVisible(Landroid/app/Activity;)Z
    .registers 1

    .line 544
    invoke-virtual {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/BarUtils;->isNavBarVisible(Landroid/view/Window;)Z

    move-result p0

    return p0
.end method

.method public static isNavBarVisible(Landroid/view/Window;)Z
    .registers 8

    .line 556
    invoke-virtual {p0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object p0

    check-cast p0, Landroid/view/ViewGroup;

    .line 557
    invoke-virtual {p0}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v0

    const/4 v1, 0x0

    move v2, v1

    :goto_c
    const/4 v3, 0x1

    if-ge v2, v0, :cond_31

    .line 558
    invoke-virtual {p0, v2}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    .line 559
    invoke-virtual {v4}, Landroid/view/View;->getId()I

    move-result v5

    const/4 v6, -0x1

    if-eq v5, v6, :cond_2e

    .line 561
    invoke-static {v5}, Lcom/blankj/utilcode/util/BarUtils;->getResNameById(I)Ljava/lang/String;

    move-result-object v5

    const-string v6, "navigationBarBackground"

    .line 562
    invoke-virtual {v6, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2e

    .line 563
    invoke-virtual {v4}, Landroid/view/View;->getVisibility()I

    move-result v4

    if-nez v4, :cond_2e

    move v0, v3

    goto :goto_32

    :cond_2e
    add-int/lit8 v2, v2, 0x1

    goto :goto_c

    :cond_31
    move v0, v1

    :goto_32
    if-eqz v0, :cond_5c

    .line 573
    invoke-static {}, Lcom/blankj/utilcode/util/UtilsBridge;->isSamsung()Z

    move-result v0

    if-eqz v0, :cond_52

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x1d

    if-ge v0, v2, :cond_52

    .line 577
    :try_start_40
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Application;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const-string v2, "navigationbar_hide_bar_enabled"

    invoke-static {v0, v2}, Landroid/provider/Settings$Global;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;)I

    move-result p0
    :try_end_4e
    .catch Ljava/lang/Exception; {:try_start_40 .. :try_end_4e} :catch_52

    if-nez p0, :cond_51

    move v1, v3

    :cond_51
    return v1

    .line 582
    :catch_52
    :cond_52
    invoke-virtual {p0}, Landroid/view/ViewGroup;->getSystemUiVisibility()I

    move-result p0

    and-int/lit8 p0, p0, 0x2

    if-nez p0, :cond_5b

    move v1, v3

    :cond_5b
    move v0, v1

    :cond_5c
    return v0
.end method

.method public static isStatusBarLightMode(Landroid/app/Activity;)Z
    .registers 1

    .line 144
    invoke-virtual {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/BarUtils;->isStatusBarLightMode(Landroid/view/Window;)Z

    move-result p0

    return p0
.end method

.method public static isStatusBarLightMode(Landroid/view/Window;)Z
    .registers 1

    .line 155
    invoke-virtual {p0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object p0

    .line 156
    invoke-virtual {p0}, Landroid/view/View;->getSystemUiVisibility()I

    move-result p0

    and-int/lit16 p0, p0, 0x2000

    if-eqz p0, :cond_e

    const/4 p0, 0x1

    goto :goto_f

    :cond_e
    const/4 p0, 0x0

    :goto_f
    return p0
.end method

.method public static isStatusBarVisible(Landroid/app/Activity;)Z
    .registers 1

    .line 102
    invoke-virtual {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object p0

    invoke-virtual {p0}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object p0

    iget p0, p0, Landroid/view/WindowManager$LayoutParams;->flags:I

    and-int/lit16 p0, p0, 0x400

    if-nez p0, :cond_10

    const/4 p0, 0x1

    goto :goto_11

    :cond_10
    const/4 p0, 0x0

    :goto_11
    return p0
.end method

.method public static isSupportNavBar()Z
    .registers 5

    .line 649
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    const-string v1, "window"

    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/WindowManager;

    const/4 v1, 0x0

    if-nez v0, :cond_10

    return v1

    .line 651
    :cond_10
    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    .line 652
    new-instance v2, Landroid/graphics/Point;

    invoke-direct {v2}, Landroid/graphics/Point;-><init>()V

    .line 653
    new-instance v3, Landroid/graphics/Point;

    invoke-direct {v3}, Landroid/graphics/Point;-><init>()V

    .line 654
    invoke-virtual {v0, v2}, Landroid/view/Display;->getSize(Landroid/graphics/Point;)V

    .line 655
    invoke-virtual {v0, v3}, Landroid/view/Display;->getRealSize(Landroid/graphics/Point;)V

    .line 656
    iget v0, v3, Landroid/graphics/Point;->y:I

    iget v4, v2, Landroid/graphics/Point;->y:I

    if-ne v0, v4, :cond_30

    iget v0, v3, Landroid/graphics/Point;->x:I

    iget v2, v2, Landroid/graphics/Point;->x:I

    if-eq v0, v2, :cond_31

    :cond_30
    const/4 v1, 0x1

    :cond_31
    return v1
.end method

.method public static setNavBarColor(Landroid/app/Activity;I)V
    .registers 2

    .line 605
    invoke-virtual {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object p0

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/BarUtils;->setNavBarColor(Landroid/view/Window;I)V

    return-void
.end method

.method public static setNavBarColor(Landroid/view/Window;I)V
    .registers 3

    const/high16 v0, -0x80000000

    .line 616
    invoke-virtual {p0, v0}, Landroid/view/Window;->addFlags(I)V

    .line 617
    invoke-virtual {p0, p1}, Landroid/view/Window;->setNavigationBarColor(I)V

    return-void
.end method

.method public static setNavBarLightMode(Landroid/app/Activity;Z)V
    .registers 2

    .line 671
    invoke-virtual {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object p0

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/BarUtils;->setNavBarLightMode(Landroid/view/Window;Z)V

    return-void
.end method

.method public static setNavBarLightMode(Landroid/view/Window;Z)V
    .registers 3

    .line 683
    invoke-virtual {p0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object p0

    .line 684
    invoke-virtual {p0}, Landroid/view/View;->getSystemUiVisibility()I

    move-result v0

    if-eqz p1, :cond_d

    or-int/lit8 p1, v0, 0x10

    goto :goto_f

    :cond_d
    and-int/lit8 p1, v0, -0x11

    .line 690
    :goto_f
    invoke-virtual {p0, p1}, Landroid/view/View;->setSystemUiVisibility(I)V

    return-void
.end method

.method public static setNavBarVisibility(Landroid/app/Activity;Z)V
    .registers 2

    .line 503
    invoke-virtual {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object p0

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/BarUtils;->setNavBarVisibility(Landroid/view/Window;Z)V

    return-void
.end method

.method public static setNavBarVisibility(Landroid/view/Window;Z)V
    .registers 8

    .line 515
    invoke-virtual {p0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object p0

    check-cast p0, Landroid/view/ViewGroup;

    .line 516
    invoke-virtual {p0}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v0

    const/4 v1, 0x0

    move v2, v1

    :goto_c
    if-ge v2, v0, :cond_30

    .line 517
    invoke-virtual {p0, v2}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 518
    invoke-virtual {v3}, Landroid/view/View;->getId()I

    move-result v4

    const/4 v5, -0x1

    if-eq v4, v5, :cond_2d

    .line 520
    invoke-static {v4}, Lcom/blankj/utilcode/util/BarUtils;->getResNameById(I)Ljava/lang/String;

    move-result-object v4

    const-string v5, "navigationBarBackground"

    .line 521
    invoke-virtual {v5, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2d

    if-eqz p1, :cond_29

    move v4, v1

    goto :goto_2a

    :cond_29
    const/4 v4, 0x4

    .line 522
    :goto_2a
    invoke-virtual {v3, v4}, Landroid/view/View;->setVisibility(I)V

    :cond_2d
    add-int/lit8 v2, v2, 0x1

    goto :goto_c

    :cond_30
    if-eqz p1, :cond_3c

    .line 530
    invoke-virtual {p0}, Landroid/view/ViewGroup;->getSystemUiVisibility()I

    move-result p1

    and-int/lit16 p1, p1, -0x1203

    invoke-virtual {p0, p1}, Landroid/view/ViewGroup;->setSystemUiVisibility(I)V

    goto :goto_45

    .line 532
    :cond_3c
    invoke-virtual {p0}, Landroid/view/ViewGroup;->getSystemUiVisibility()I

    move-result p1

    or-int/lit16 p1, p1, 0x1202

    invoke-virtual {p0, p1}, Landroid/view/ViewGroup;->setSystemUiVisibility(I)V

    :goto_45
    return-void
.end method

.method public static setNotificationBarVisibility(Z)V
    .registers 1

    if-eqz p0, :cond_5

    const-string p0, "expandNotificationsPanel"

    goto :goto_7

    :cond_5
    const-string p0, "collapsePanels"

    .line 460
    :goto_7
    invoke-static {p0}, Lcom/blankj/utilcode/util/BarUtils;->invokePanels(Ljava/lang/String;)V

    return-void
.end method

.method public static setStatusBarColor(Landroid/app/Activity;I)Landroid/view/View;
    .registers 3

    const/4 v0, 0x0

    .line 219
    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/BarUtils;->setStatusBarColor(Landroid/app/Activity;IZ)Landroid/view/View;

    move-result-object p0

    return-object p0
.end method

.method public static setStatusBarColor(Landroid/app/Activity;IZ)Landroid/view/View;
    .registers 3

    .line 234
    invoke-static {p0}, Lcom/blankj/utilcode/util/BarUtils;->transparentStatusBar(Landroid/app/Activity;)V

    .line 235
    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/BarUtils;->applyStatusBarColor(Landroid/app/Activity;IZ)Landroid/view/View;

    move-result-object p0

    return-object p0
.end method

.method public static setStatusBarColor(Landroid/view/Window;I)Landroid/view/View;
    .registers 3

    const/4 v0, 0x0

    .line 247
    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/BarUtils;->setStatusBarColor(Landroid/view/Window;IZ)Landroid/view/View;

    move-result-object p0

    return-object p0
.end method

.method public static setStatusBarColor(Landroid/view/Window;IZ)Landroid/view/View;
    .registers 3

    .line 262
    invoke-static {p0}, Lcom/blankj/utilcode/util/BarUtils;->transparentStatusBar(Landroid/view/Window;)V

    .line 263
    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/BarUtils;->applyStatusBarColor(Landroid/view/Window;IZ)Landroid/view/View;

    move-result-object p0

    return-object p0
.end method

.method public static setStatusBarColor(Landroid/view/View;I)V
    .registers 4

    .line 275
    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/blankj/utilcode/util/UtilsBridge;->getActivityByContext(Landroid/content/Context;)Landroid/app/Activity;

    move-result-object v0

    if-nez v0, :cond_b

    return-void

    .line 277
    :cond_b
    invoke-static {v0}, Lcom/blankj/utilcode/util/BarUtils;->transparentStatusBar(Landroid/app/Activity;)V

    const/4 v0, 0x0

    .line 278
    invoke-virtual {p0, v0}, Landroid/view/View;->setVisibility(I)V

    .line 279
    invoke-virtual {p0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    const/4 v1, -0x1

    .line 280
    iput v1, v0, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 281
    invoke-static {}, Lcom/blankj/utilcode/util/BarUtils;->getStatusBarHeight()I

    move-result v1

    iput v1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 282
    invoke-virtual {p0, p1}, Landroid/view/View;->setBackgroundColor(I)V

    return-void
.end method

.method public static setStatusBarColor4Drawer(Landroidx/drawerlayout/widget/DrawerLayout;Landroid/view/View;I)V
    .registers 4

    const/4 v0, 0x0

    .line 320
    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/BarUtils;->setStatusBarColor4Drawer(Landroidx/drawerlayout/widget/DrawerLayout;Landroid/view/View;IZ)V

    return-void
.end method

.method public static setStatusBarColor4Drawer(Landroidx/drawerlayout/widget/DrawerLayout;Landroid/view/View;IZ)V
    .registers 8

    .line 337
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/blankj/utilcode/util/UtilsBridge;->getActivityByContext(Landroid/content/Context;)Landroid/app/Activity;

    move-result-object v0

    if-nez v0, :cond_b

    return-void

    .line 339
    :cond_b
    invoke-static {v0}, Lcom/blankj/utilcode/util/BarUtils;->transparentStatusBar(Landroid/app/Activity;)V

    const/4 v1, 0x0

    .line 340
    invoke-virtual {p0, v1}, Landroidx/drawerlayout/widget/DrawerLayout;->setFitsSystemWindows(Z)V

    .line 341
    invoke-static {p1, p2}, Lcom/blankj/utilcode/util/BarUtils;->setStatusBarColor(Landroid/view/View;I)V

    .line 342
    invoke-virtual {p0}, Landroidx/drawerlayout/widget/DrawerLayout;->getChildCount()I

    move-result p1

    move v2, v1

    :goto_1a
    if-ge v2, p1, :cond_26

    .line 343
    invoke-virtual {p0, v2}, Landroidx/drawerlayout/widget/DrawerLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3, v1}, Landroid/view/View;->setFitsSystemWindows(Z)V

    add-int/lit8 v2, v2, 0x1

    goto :goto_1a

    :cond_26
    if-eqz p3, :cond_2c

    .line 346
    invoke-static {v0}, Lcom/blankj/utilcode/util/BarUtils;->hideStatusBarView(Landroid/app/Activity;)V

    goto :goto_2f

    .line 348
    :cond_2c
    invoke-static {v0, p2, v1}, Lcom/blankj/utilcode/util/BarUtils;->setStatusBarColor(Landroid/app/Activity;IZ)Landroid/view/View;

    :goto_2f
    return-void
.end method

.method public static setStatusBarCustom(Landroid/view/View;)V
    .registers 4

    .line 292
    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/blankj/utilcode/util/UtilsBridge;->getActivityByContext(Landroid/content/Context;)Landroid/app/Activity;

    move-result-object v0

    if-nez v0, :cond_b

    return-void

    .line 294
    :cond_b
    invoke-static {v0}, Lcom/blankj/utilcode/util/BarUtils;->transparentStatusBar(Landroid/app/Activity;)V

    const/4 v0, 0x0

    .line 295
    invoke-virtual {p0, v0}, Landroid/view/View;->setVisibility(I)V

    .line 296
    invoke-virtual {p0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    const/4 v1, -0x1

    if-nez v0, :cond_26

    .line 298
    new-instance v0, Landroid/view/ViewGroup$LayoutParams;

    .line 300
    invoke-static {}, Lcom/blankj/utilcode/util/BarUtils;->getStatusBarHeight()I

    move-result v2

    invoke-direct {v0, v1, v2}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    .line 302
    invoke-virtual {p0, v0}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_2e

    .line 304
    :cond_26
    iput v1, v0, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 305
    invoke-static {}, Lcom/blankj/utilcode/util/BarUtils;->getStatusBarHeight()I

    move-result p0

    iput p0, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    :goto_2e
    return-void
.end method

.method public static setStatusBarLightMode(Landroid/app/Activity;Z)V
    .registers 2

    .line 114
    invoke-virtual {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object p0

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/BarUtils;->setStatusBarLightMode(Landroid/view/Window;Z)V

    return-void
.end method

.method public static setStatusBarLightMode(Landroid/view/Window;Z)V
    .registers 3

    .line 126
    invoke-virtual {p0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object p0

    .line 127
    invoke-virtual {p0}, Landroid/view/View;->getSystemUiVisibility()I

    move-result v0

    if-eqz p1, :cond_d

    or-int/lit16 p1, v0, 0x2000

    goto :goto_f

    :cond_d
    and-int/lit16 p1, v0, -0x2001

    .line 133
    :goto_f
    invoke-virtual {p0, p1}, Landroid/view/View;->setSystemUiVisibility(I)V

    return-void
.end method

.method public static setStatusBarVisibility(Landroid/app/Activity;Z)V
    .registers 2

    .line 73
    invoke-virtual {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object p0

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/BarUtils;->setStatusBarVisibility(Landroid/view/Window;Z)V

    return-void
.end method

.method public static setStatusBarVisibility(Landroid/view/Window;Z)V
    .registers 3

    const/16 v0, 0x400

    if-eqz p1, :cond_e

    .line 85
    invoke-virtual {p0, v0}, Landroid/view/Window;->clearFlags(I)V

    .line 86
    invoke-static {p0}, Lcom/blankj/utilcode/util/BarUtils;->showStatusBarView(Landroid/view/Window;)V

    .line 87
    invoke-static {p0}, Lcom/blankj/utilcode/util/BarUtils;->addMarginTopEqualStatusBarHeight(Landroid/view/Window;)V

    goto :goto_17

    .line 89
    :cond_e
    invoke-virtual {p0, v0}, Landroid/view/Window;->addFlags(I)V

    .line 90
    invoke-static {p0}, Lcom/blankj/utilcode/util/BarUtils;->hideStatusBarView(Landroid/view/Window;)V

    .line 91
    invoke-static {p0}, Lcom/blankj/utilcode/util/BarUtils;->subtractMarginTopEqualStatusBarHeight(Landroid/view/Window;)V

    :goto_17
    return-void
.end method

.method private static showStatusBarView(Landroid/view/Window;)V
    .registers 2

    .line 389
    invoke-virtual {p0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object p0

    check-cast p0, Landroid/view/ViewGroup;

    const-string v0, "TAG_STATUS_BAR"

    .line 390
    invoke-virtual {p0, v0}, Landroid/view/ViewGroup;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;

    move-result-object p0

    if-nez p0, :cond_f

    return-void

    :cond_f
    const/4 v0, 0x0

    .line 392
    invoke-virtual {p0, v0}, Landroid/view/View;->setVisibility(I)V

    return-void
.end method

.method public static subtractMarginTopEqualStatusBarHeight(Landroid/view/View;)V
    .registers 7

    const/16 v0, -0x7b

    .line 187
    invoke-virtual {p0, v0}, Landroid/view/View;->getTag(I)Ljava/lang/Object;

    move-result-object v1

    if-eqz v1, :cond_2f

    .line 188
    check-cast v1, Ljava/lang/Boolean;

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-nez v1, :cond_11

    goto :goto_2f

    .line 189
    :cond_11
    invoke-virtual {p0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 190
    iget v2, v1, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    iget v3, v1, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    .line 191
    invoke-static {}, Lcom/blankj/utilcode/util/BarUtils;->getStatusBarHeight()I

    move-result v4

    sub-int/2addr v3, v4

    iget v4, v1, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    iget v5, v1, Landroid/view/ViewGroup$MarginLayoutParams;->bottomMargin:I

    .line 190
    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/view/ViewGroup$MarginLayoutParams;->setMargins(IIII)V

    const/4 v1, 0x0

    .line 194
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Landroid/view/View;->setTag(ILjava/lang/Object;)V

    :cond_2f
    :goto_2f
    return-void
.end method

.method private static subtractMarginTopEqualStatusBarHeight(Landroid/view/Window;)V
    .registers 2

    .line 206
    invoke-virtual {p0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object p0

    const-string v0, "TAG_OFFSET"

    invoke-virtual {p0, v0}, Landroid/view/View;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;

    move-result-object p0

    if-nez p0, :cond_d

    return-void

    .line 208
    :cond_d
    invoke-static {p0}, Lcom/blankj/utilcode/util/BarUtils;->subtractMarginTopEqualStatusBarHeight(Landroid/view/View;)V

    return-void
.end method

.method public static transparentNavBar(Landroid/app/Activity;)V
    .registers 1

    .line 720
    invoke-virtual {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/BarUtils;->transparentNavBar(Landroid/view/Window;)V

    return-void
.end method

.method public static transparentNavBar(Landroid/view/Window;)V
    .registers 4

    .line 725
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1d

    const/4 v2, 0x0

    if-lt v0, v1, :cond_a

    .line 726
    invoke-virtual {p0, v2}, Landroid/view/Window;->setNavigationBarContrastEnforced(Z)V

    .line 729
    :cond_a
    invoke-virtual {p0, v2}, Landroid/view/Window;->setNavigationBarColor(I)V

    .line 735
    invoke-virtual {p0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object p0

    .line 736
    invoke-virtual {p0}, Landroid/view/View;->getSystemUiVisibility()I

    move-result v0

    or-int/lit16 v0, v0, 0x700

    .line 738
    invoke-virtual {p0, v0}, Landroid/view/View;->setSystemUiVisibility(I)V

    return-void
.end method

.method public static transparentStatusBar(Landroid/app/Activity;)V
    .registers 1

    .line 406
    invoke-virtual {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/BarUtils;->transparentStatusBar(Landroid/view/Window;)V

    return-void
.end method

.method public static transparentStatusBar(Landroid/view/Window;)V
    .registers 3

    const/high16 v0, 0x4000000

    .line 412
    invoke-virtual {p0, v0}, Landroid/view/Window;->clearFlags(I)V

    const/high16 v0, -0x80000000

    .line 413
    invoke-virtual {p0, v0}, Landroid/view/Window;->addFlags(I)V

    .line 415
    invoke-virtual {p0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getSystemUiVisibility()I

    move-result v0

    .line 416
    invoke-virtual {p0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v1

    or-int/lit16 v0, v0, 0x500

    invoke-virtual {v1, v0}, Landroid/view/View;->setSystemUiVisibility(I)V

    const/4 v0, 0x0

    .line 417
    invoke-virtual {p0, v0}, Landroid/view/Window;->setStatusBarColor(I)V

    return-void
.end method
