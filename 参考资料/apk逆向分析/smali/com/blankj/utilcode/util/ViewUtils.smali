.class public Lcom/blankj/utilcode/util/ViewUtils;
.super Ljava/lang/Object;
.source "ViewUtils.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static fixScrollViewTopping(Landroid/view/View;)V
    .registers 6

    const/4 v0, 0x0

    .line 97
    invoke-virtual {p0, v0}, Landroid/view/View;->setFocusable(Z)V

    .line 99
    instance-of v1, p0, Landroid/view/ViewGroup;

    if-eqz v1, :cond_b

    .line 100
    check-cast p0, Landroid/view/ViewGroup;

    goto :goto_c

    :cond_b
    const/4 p0, 0x0

    :goto_c
    if-nez p0, :cond_f

    return-void

    .line 105
    :cond_f
    invoke-virtual {p0}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v1

    move v2, v0

    :goto_14
    if-ge v2, v1, :cond_27

    .line 106
    invoke-virtual {p0, v2}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 107
    invoke-virtual {v3, v0}, Landroid/view/View;->setFocusable(Z)V

    .line 108
    instance-of v4, v3, Landroid/view/ViewGroup;

    if-eqz v4, :cond_24

    .line 109
    invoke-static {v3}, Lcom/blankj/utilcode/util/ViewUtils;->fixScrollViewTopping(Landroid/view/View;)V

    :cond_24
    add-int/lit8 v2, v2, 0x1

    goto :goto_14

    :cond_27
    return-void
.end method

.method public static isLayoutRtl()Z
    .registers 3

    .line 82
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Application;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Configuration;->getLocales()Landroid/os/LocaleList;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/LocaleList;->get(I)Ljava/util/Locale;

    move-result-object v0

    .line 86
    invoke-static {v0}, Landroid/text/TextUtils;->getLayoutDirectionFromLocale(Ljava/util/Locale;)I

    move-result v0

    const/4 v2, 0x1

    if-ne v0, v2, :cond_1d

    move v1, v2

    :cond_1d
    return v1
.end method

.method public static layoutId2View(I)Landroid/view/View;
    .registers 3

    .line 116
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    const-string v1, "layout_inflater"

    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    const/4 v1, 0x0

    .line 117
    invoke-virtual {v0, p0, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p0

    return-object p0
.end method

.method public static runOnUiThread(Ljava/lang/Runnable;)V
    .registers 1

    .line 62
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->runOnUiThread(Ljava/lang/Runnable;)V

    return-void
.end method

.method public static runOnUiThreadDelayed(Ljava/lang/Runnable;J)V
    .registers 3

    .line 70
    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/UtilsBridge;->runOnUiThreadDelayed(Ljava/lang/Runnable;J)V

    return-void
.end method

.method public static setViewEnabled(Landroid/view/View;Z)V
    .registers 5

    const/4 v0, 0x1

    new-array v0, v0, [Landroid/view/View;

    const/4 v1, 0x0

    .line 31
    move-object v2, v1

    check-cast v2, Landroid/view/View;

    const/4 v2, 0x0

    aput-object v1, v0, v2

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/ViewUtils;->setViewEnabled(Landroid/view/View;Z[Landroid/view/View;)V

    return-void
.end method

.method public static varargs setViewEnabled(Landroid/view/View;Z[Landroid/view/View;)V
    .registers 7

    if-nez p0, :cond_3

    return-void

    :cond_3
    const/4 v0, 0x0

    if-eqz p2, :cond_12

    .line 44
    array-length v1, p2

    move v2, v0

    :goto_8
    if-ge v2, v1, :cond_12

    aget-object v3, p2, v2

    if-ne p0, v3, :cond_f

    return-void

    :cond_f
    add-int/lit8 v2, v2, 0x1

    goto :goto_8

    .line 48
    :cond_12
    instance-of v1, p0, Landroid/view/ViewGroup;

    if-eqz v1, :cond_29

    .line 49
    move-object v1, p0

    check-cast v1, Landroid/view/ViewGroup;

    .line 50
    invoke-virtual {v1}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v2

    :goto_1d
    if-ge v0, v2, :cond_29

    .line 52
    invoke-virtual {v1, v0}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    invoke-static {v3, p1, p2}, Lcom/blankj/utilcode/util/ViewUtils;->setViewEnabled(Landroid/view/View;Z[Landroid/view/View;)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_1d

    .line 55
    :cond_29
    invoke-virtual {p0, p1}, Landroid/view/View;->setEnabled(Z)V

    return-void
.end method
