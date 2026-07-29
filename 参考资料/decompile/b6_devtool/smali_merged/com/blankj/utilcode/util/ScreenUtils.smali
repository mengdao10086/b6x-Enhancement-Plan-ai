.class public final Lcom/blankj/utilcode/util/ScreenUtils;
.super Ljava/lang/Object;
.source "ScreenUtils.java"


# direct methods
.method private constructor <init>()V
    .registers 3

    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "u can\'t instantiate me..."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static getAppScreenHeight()I
    .registers 2

    .line 91
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    const-string v1, "window"

    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/WindowManager;

    if-nez v0, :cond_10

    const/4 v0, -0x1

    return v0

    .line 93
    :cond_10
    new-instance v1, Landroid/graphics/Point;

    invoke-direct {v1}, Landroid/graphics/Point;-><init>()V

    .line 94
    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/Display;->getSize(Landroid/graphics/Point;)V

    .line 95
    iget v0, v1, Landroid/graphics/Point;->y:I

    return v0
.end method

.method public static getAppScreenWidth()I
    .registers 2

    .line 78
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    const-string v1, "window"

    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/WindowManager;

    if-nez v0, :cond_10

    const/4 v0, -0x1

    return v0

    .line 80
    :cond_10
    new-instance v1, Landroid/graphics/Point;

    invoke-direct {v1}, Landroid/graphics/Point;-><init>()V

    .line 81
    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/Display;->getSize(Landroid/graphics/Point;)V

    .line 82
    iget v0, v1, Landroid/graphics/Point;->x:I

    return v0
.end method

.method public static getScreenDensity()F
    .registers 1

    .line 104
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->density:F

    return v0
.end method

.method public static getScreenDensityDpi()I
    .registers 1

    .line 113
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->densityDpi:I

    return v0
.end method

.method public static getScreenHeight()I
    .registers 2

    .line 61
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    const-string v1, "window"

    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/WindowManager;

    if-nez v0, :cond_10

    const/4 v0, -0x1

    return v0

    .line 63
    :cond_10
    new-instance v1, Landroid/graphics/Point;

    invoke-direct {v1}, Landroid/graphics/Point;-><init>()V

    .line 65
    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/Display;->getRealSize(Landroid/graphics/Point;)V

    .line 69
    iget v0, v1, Landroid/graphics/Point;->y:I

    return v0
.end method

.method public static getScreenRotation(Landroid/app/Activity;)I
    .registers 2

    .line 269
    invoke-virtual {p0}, Landroid/app/Activity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object p0

    invoke-interface {p0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object p0

    invoke-virtual {p0}, Landroid/view/Display;->getRotation()I

    move-result p0

    const/4 v0, 0x1

    if-eq p0, v0, :cond_1d

    const/4 v0, 0x2

    if-eq p0, v0, :cond_1a

    const/4 v0, 0x3

    if-eq p0, v0, :cond_17

    const/4 p0, 0x0

    return p0

    :cond_17
    const/16 p0, 0x10e

    return p0

    :cond_1a
    const/16 p0, 0xb4

    return p0

    :cond_1d
    const/16 p0, 0x5a

    return p0
.end method

.method public static getScreenWidth()I
    .registers 2

    .line 44
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    const-string v1, "window"

    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/WindowManager;

    if-nez v0, :cond_10

    const/4 v0, -0x1

    return v0

    .line 46
    :cond_10
    new-instance v1, Landroid/graphics/Point;

    invoke-direct {v1}, Landroid/graphics/Point;-><init>()V

    .line 48
    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/Display;->getRealSize(Landroid/graphics/Point;)V

    .line 52
    iget v0, v1, Landroid/graphics/Point;->x:I

    return v0
.end method

.method public static getScreenXDpi()F
    .registers 1

    .line 122
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->xdpi:F

    return v0
.end method

.method public static getScreenYDpi()F
    .registers 1

    .line 131
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->ydpi:F

    return v0
.end method

.method public static getSleepDuration()I
    .registers 2

    .line 354
    :try_start_0
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Application;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const-string v1, "screen_off_timeout"

    .line 353
    invoke-static {v0, v1}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;)I

    move-result v0
    :try_end_e
    .catch Landroid/provider/Settings$SettingNotFoundException; {:try_start_0 .. :try_end_e} :catch_f

    return v0

    :catch_f
    move-exception v0

    .line 358
    invoke-virtual {v0}, Landroid/provider/Settings$SettingNotFoundException;->printStackTrace()V

    const/16 v0, -0x7b

    return v0
.end method

.method public static isFullScreen(Landroid/app/Activity;)Z
    .registers 2

    .line 219
    invoke-virtual {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object p0

    invoke-virtual {p0}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object p0

    iget p0, p0, Landroid/view/WindowManager$LayoutParams;->flags:I

    const/16 v0, 0x400

    and-int/2addr p0, v0

    if-ne p0, v0, :cond_11

    const/4 p0, 0x1

    goto :goto_12

    :cond_11
    const/4 p0, 0x0

    :goto_12
    return p0
.end method

.method public static isLandscape()Z
    .registers 2

    .line 248
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Application;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    iget v0, v0, Landroid/content/res/Configuration;->orientation:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_13

    const/4 v0, 0x1

    goto :goto_14

    :cond_13
    const/4 v0, 0x0

    :goto_14
    return v0
.end method

.method public static isPortrait()Z
    .registers 2

    .line 258
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Application;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    iget v0, v0, Landroid/content/res/Configuration;->orientation:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_12

    goto :goto_13

    :cond_12
    const/4 v1, 0x0

    :goto_13
    return v1
.end method

.method public static isScreenLock()Z
    .registers 2

    .line 326
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    const-string v1, "keyguard"

    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/KeyguardManager;

    if-nez v0, :cond_10

    const/4 v0, 0x0

    return v0

    .line 328
    :cond_10
    invoke-virtual {v0}, Landroid/app/KeyguardManager;->inKeyguardRestrictedInputMode()Z

    move-result v0

    return v0
.end method

.method public static screenShot(Landroid/app/Activity;)Landroid/graphics/Bitmap;
    .registers 2

    const/4 v0, 0x0

    .line 290
    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/ScreenUtils;->screenShot(Landroid/app/Activity;Z)Landroid/graphics/Bitmap;

    move-result-object p0

    return-object p0
.end method

.method public static screenShot(Landroid/app/Activity;Z)Landroid/graphics/Bitmap;
    .registers 5

    .line 301
    invoke-virtual {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    .line 302
    invoke-static {v0}, Lcom/blankj/utilcode/util/UtilsBridge;->view2Bitmap(Landroid/view/View;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 303
    new-instance v1, Landroid/util/DisplayMetrics;

    invoke-direct {v1}, Landroid/util/DisplayMetrics;-><init>()V

    .line 304
    invoke-virtual {p0}, Landroid/app/Activity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object p0

    invoke-interface {p0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object p0

    invoke-virtual {p0, v1}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    const/4 p0, 0x0

    if-eqz p1, :cond_2d

    .line 306
    invoke-static {}, Lcom/blankj/utilcode/util/UtilsBridge;->getStatusBarHeight()I

    move-result p1

    .line 307
    iget v2, v1, Landroid/util/DisplayMetrics;->widthPixels:I

    iget v1, v1, Landroid/util/DisplayMetrics;->heightPixels:I

    sub-int/2addr v1, p1

    invoke-static {v0, p0, p1, v2, v1}, Landroid/graphics/Bitmap;->createBitmap(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;

    move-result-object p0

    return-object p0

    .line 315
    :cond_2d
    iget p1, v1, Landroid/util/DisplayMetrics;->widthPixels:I

    iget v1, v1, Landroid/util/DisplayMetrics;->heightPixels:I

    invoke-static {v0, p0, p0, p1, v1}, Landroid/graphics/Bitmap;->createBitmap(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;

    move-result-object p0

    return-object p0
.end method

.method public static setFullScreen(Landroid/app/Activity;)V
    .registers 2

    .line 184
    invoke-virtual {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object p0

    const/16 v0, 0x400

    invoke-virtual {p0, v0}, Landroid/view/Window;->addFlags(I)V

    return-void
.end method

.method public static setLandscape(Landroid/app/Activity;)V
    .registers 2

    const/4 v0, 0x0

    .line 229
    invoke-virtual {p0, v0}, Landroid/app/Activity;->setRequestedOrientation(I)V

    return-void
.end method

.method public static setNonFullScreen(Landroid/app/Activity;)V
    .registers 2

    .line 193
    invoke-virtual {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object p0

    const/16 v0, 0x400

    invoke-virtual {p0, v0}, Landroid/view/Window;->clearFlags(I)V

    return-void
.end method

.method public static setPortrait(Landroid/app/Activity;)V
    .registers 2

    const/4 v0, 0x1

    .line 239
    invoke-virtual {p0, v0}, Landroid/app/Activity;->setRequestedOrientation(I)V

    return-void
.end method

.method public static setSleepDuration(I)V
    .registers 3

    .line 340
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Application;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const-string v1, "screen_off_timeout"

    .line 339
    invoke-static {v0, v1, p0}, Landroid/provider/Settings$System;->putInt(Landroid/content/ContentResolver;Ljava/lang/String;I)Z

    return-void
.end method

.method public static toggleFullScreen(Landroid/app/Activity;)V
    .registers 3

    .line 202
    invoke-static {p0}, Lcom/blankj/utilcode/util/ScreenUtils;->isFullScreen(Landroid/app/Activity;)Z

    move-result v0

    .line 203
    invoke-virtual {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object p0

    const/16 v1, 0x400

    if-eqz v0, :cond_10

    .line 205
    invoke-virtual {p0, v1}, Landroid/view/Window;->clearFlags(I)V

    goto :goto_13

    .line 207
    :cond_10
    invoke-virtual {p0, v1}, Landroid/view/Window;->addFlags(I)V

    :goto_13
    return-void
.end method


# virtual methods
.method public calculateDistanceByX(Landroid/view/View;)I
    .registers 4

    const/4 v0, 0x2

    new-array v0, v0, [I

    .line 141
    invoke-virtual {p1, v0}, Landroid/view/View;->getLocationOnScreen([I)V

    .line 142
    invoke-static {}, Lcom/blankj/utilcode/util/ScreenUtils;->getScreenWidth()I

    move-result p1

    const/4 v1, 0x0

    aget v0, v0, v1

    sub-int/2addr p1, v0

    return p1
.end method

.method public calculateDistanceByY(Landroid/view/View;)I
    .registers 4

    const/4 v0, 0x2

    new-array v0, v0, [I

    .line 152
    invoke-virtual {p1, v0}, Landroid/view/View;->getLocationOnScreen([I)V

    .line 153
    invoke-static {}, Lcom/blankj/utilcode/util/ScreenUtils;->getScreenHeight()I

    move-result p1

    const/4 v1, 0x1

    aget v0, v0, v1

    sub-int/2addr p1, v0

    return p1
.end method

.method public getViewX(Landroid/view/View;)I
    .registers 3

    const/4 v0, 0x2

    new-array v0, v0, [I

    .line 163
    invoke-virtual {p1, v0}, Landroid/view/View;->getLocationOnScreen([I)V

    const/4 p1, 0x0

    aget p1, v0, p1

    return p1
.end method

.method public getViewY(Landroid/view/View;)I
    .registers 3

    const/4 v0, 0x2

    new-array v0, v0, [I

    .line 174
    invoke-virtual {p1, v0}, Landroid/view/View;->getLocationOnScreen([I)V

    const/4 p1, 0x1

    aget p1, v0, p1

    return p1
.end method
