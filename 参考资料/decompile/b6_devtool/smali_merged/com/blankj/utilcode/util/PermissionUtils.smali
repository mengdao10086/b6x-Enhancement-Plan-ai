.class public final Lcom/blankj/utilcode/util/PermissionUtils;
.super Ljava/lang/Object;
.source "PermissionUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/blankj/utilcode/util/PermissionUtils$ThemeCallback;,
        Lcom/blankj/utilcode/util/PermissionUtils$FullCallback;,
        Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;,
        Lcom/blankj/utilcode/util/PermissionUtils$SingleCallback;,
        Lcom/blankj/utilcode/util/PermissionUtils$OnRationaleListener;,
        Lcom/blankj/utilcode/util/PermissionUtils$OnExplainListener;,
        Lcom/blankj/utilcode/util/PermissionUtils$PermissionActivityImpl;
    }
.end annotation


# static fields
.field private static sInstance:Lcom/blankj/utilcode/util/PermissionUtils;

.field private static sSimpleCallback4DrawOverlays:Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;

.field private static sSimpleCallback4WriteSettings:Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;


# instance fields
.field private mFullCallback:Lcom/blankj/utilcode/util/PermissionUtils$FullCallback;

.field private mOnExplainListener:Lcom/blankj/utilcode/util/PermissionUtils$OnExplainListener;

.field private mOnRationaleListener:Lcom/blankj/utilcode/util/PermissionUtils$OnRationaleListener;

.field private mPermissions:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mPermissionsDenied:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mPermissionsDeniedForever:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mPermissionsGranted:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mPermissionsParam:[Ljava/lang/String;

.field private mPermissionsRequest:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mSimpleCallback:Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;

.field private mSingleCallback:Lcom/blankj/utilcode/util/PermissionUtils$SingleCallback;

.field private mThemeCallback:Lcom/blankj/utilcode/util/PermissionUtils$ThemeCallback;


# direct methods
.method private varargs constructor <init>([Ljava/lang/String;)V
    .registers 2

    .line 226
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 227
    iput-object p1, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissionsParam:[Ljava/lang/String;

    .line 228
    sput-object p0, Lcom/blankj/utilcode/util/PermissionUtils;->sInstance:Lcom/blankj/utilcode/util/PermissionUtils;

    return-void
.end method

.method static synthetic access$002(Lcom/blankj/utilcode/util/PermissionUtils;Ljava/util/List;)Ljava/util/List;
    .registers 2

    .line 40
    iput-object p1, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissionsDenied:Ljava/util/List;

    return-object p1
.end method

.method static synthetic access$1000(Lcom/blankj/utilcode/util/PermissionUtils;Lcom/blankj/utilcode/util/UtilsTransActivity;Ljava/lang/Runnable;)Z
    .registers 3

    .line 40
    invoke-direct {p0, p1, p2}, Lcom/blankj/utilcode/util/PermissionUtils;->shouldRationale(Lcom/blankj/utilcode/util/UtilsTransActivity;Ljava/lang/Runnable;)Z

    move-result p0

    return p0
.end method

.method static synthetic access$102(Lcom/blankj/utilcode/util/PermissionUtils;Ljava/util/List;)Ljava/util/List;
    .registers 2

    .line 40
    iput-object p1, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissionsDeniedForever:Ljava/util/List;

    return-object p1
.end method

.method static synthetic access$1100(Lcom/blankj/utilcode/util/PermissionUtils;Landroid/app/Activity;)V
    .registers 2

    .line 40
    invoke-direct {p0, p1}, Lcom/blankj/utilcode/util/PermissionUtils;->onRequestPermissionsResult(Landroid/app/Activity;)V

    return-void
.end method

.method static synthetic access$1200()Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;
    .registers 1

    .line 40
    sget-object v0, Lcom/blankj/utilcode/util/PermissionUtils;->sSimpleCallback4WriteSettings:Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;

    return-object v0
.end method

.method static synthetic access$1202(Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;)Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;
    .registers 1

    .line 40
    sput-object p0, Lcom/blankj/utilcode/util/PermissionUtils;->sSimpleCallback4WriteSettings:Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;

    return-object p0
.end method

.method static synthetic access$1300()Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;
    .registers 1

    .line 40
    sget-object v0, Lcom/blankj/utilcode/util/PermissionUtils;->sSimpleCallback4DrawOverlays:Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;

    return-object v0
.end method

.method static synthetic access$1302(Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;)Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;
    .registers 1

    .line 40
    sput-object p0, Lcom/blankj/utilcode/util/PermissionUtils;->sSimpleCallback4DrawOverlays:Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;

    return-object p0
.end method

.method static synthetic access$200(Lcom/blankj/utilcode/util/PermissionUtils;)V
    .registers 1

    .line 40
    invoke-direct {p0}, Lcom/blankj/utilcode/util/PermissionUtils;->requestCallback()V

    return-void
.end method

.method static synthetic access$300()Lcom/blankj/utilcode/util/PermissionUtils;
    .registers 1

    .line 40
    sget-object v0, Lcom/blankj/utilcode/util/PermissionUtils;->sInstance:Lcom/blankj/utilcode/util/PermissionUtils;

    return-object v0
.end method

.method static synthetic access$400(Lcom/blankj/utilcode/util/PermissionUtils;)Ljava/util/List;
    .registers 1

    .line 40
    iget-object p0, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissionsRequest:Ljava/util/List;

    return-object p0
.end method

.method static synthetic access$500(Lcom/blankj/utilcode/util/PermissionUtils;)Lcom/blankj/utilcode/util/PermissionUtils$ThemeCallback;
    .registers 1

    .line 40
    iget-object p0, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mThemeCallback:Lcom/blankj/utilcode/util/PermissionUtils$ThemeCallback;

    return-object p0
.end method

.method static synthetic access$600(Lcom/blankj/utilcode/util/PermissionUtils;)Lcom/blankj/utilcode/util/PermissionUtils$OnExplainListener;
    .registers 1

    .line 40
    iget-object p0, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mOnExplainListener:Lcom/blankj/utilcode/util/PermissionUtils$OnExplainListener;

    return-object p0
.end method

.method static synthetic access$602(Lcom/blankj/utilcode/util/PermissionUtils;Lcom/blankj/utilcode/util/PermissionUtils$OnExplainListener;)Lcom/blankj/utilcode/util/PermissionUtils$OnExplainListener;
    .registers 2

    .line 40
    iput-object p1, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mOnExplainListener:Lcom/blankj/utilcode/util/PermissionUtils$OnExplainListener;

    return-object p1
.end method

.method static synthetic access$800(Landroid/app/Activity;I)V
    .registers 2

    .line 40
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/PermissionUtils;->startWriteSettingsActivity(Landroid/app/Activity;I)V

    return-void
.end method

.method static synthetic access$900(Landroid/app/Activity;I)V
    .registers 2

    .line 40
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/PermissionUtils;->startOverlayPermissionActivity(Landroid/app/Activity;I)V

    return-void
.end method

.method public static getPermissions()Ljava/util/List;
    .registers 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 66
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Application;->getPackageName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/blankj/utilcode/util/PermissionUtils;->getPermissions(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public static getPermissions(Ljava/lang/String;)Ljava/util/List;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 76
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Application;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    const/16 v1, 0x1000

    .line 78
    :try_start_a
    invoke-virtual {v0, p0, v1}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object p0

    iget-object p0, p0, Landroid/content/pm/PackageInfo;->requestedPermissions:[Ljava/lang/String;

    if-nez p0, :cond_17

    .line 79
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object p0

    return-object p0

    .line 80
    :cond_17
    invoke-static {p0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object p0
    :try_end_1b
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_a .. :try_end_1b} :catch_1c

    return-object p0

    :catch_1c
    move-exception p0

    .line 82
    invoke-virtual {p0}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    .line 83
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object p0

    return-object p0
.end method

.method private getPermissionsStatus(Landroid/app/Activity;)V
    .registers 5

    .line 375
    iget-object v0, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissionsRequest:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_6
    :goto_6
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_2f

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 376
    invoke-static {v1}, Lcom/blankj/utilcode/util/PermissionUtils;->isGranted(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1e

    .line 377
    iget-object v2, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissionsGranted:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_6

    .line 379
    :cond_1e
    iget-object v2, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissionsDenied:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 380
    invoke-virtual {p1, v1}, Landroid/app/Activity;->shouldShowRequestPermissionRationale(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_6

    .line 381
    iget-object v2, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissionsDeniedForever:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_6

    :cond_2f
    return-void
.end method

.method private static varargs getRequestAndDeniedPermissions([Ljava/lang/String;)Landroid/util/Pair;
    .registers 14
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/String;",
            ")",
            "Landroid/util/Pair<",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .line 109
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 110
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 111
    invoke-static {}, Lcom/blankj/utilcode/util/PermissionUtils;->getPermissions()Ljava/util/List;

    move-result-object v2

    .line 112
    array-length v3, p0

    const/4 v4, 0x0

    move v5, v4

    :goto_11
    if-ge v5, v3, :cond_4f

    aget-object v6, p0, v5

    .line 114
    invoke-static {v6}, Lcom/blankj/utilcode/constant/PermissionConstants;->getPermissions(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v7

    .line 115
    array-length v8, v7

    move v9, v4

    move v10, v9

    :goto_1c
    if-ge v9, v8, :cond_2d

    aget-object v11, v7, v9

    .line 116
    invoke-interface {v2, v11}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_2a

    .line 117
    invoke-interface {v0, v11}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    const/4 v10, 0x1

    :cond_2a
    add-int/lit8 v9, v9, 0x1

    goto :goto_1c

    :cond_2d
    if-nez v10, :cond_4c

    .line 122
    invoke-interface {v1, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 123
    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "U should add the permission of "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " in manifest."

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    const-string v7, "PermissionUtils"

    invoke-static {v7, v6}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    :cond_4c
    add-int/lit8 v5, v5, 0x1

    goto :goto_11

    .line 126
    :cond_4f
    invoke-static {v0, v1}, Landroid/util/Pair;->create(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;

    move-result-object p0

    return-object p0
.end method

.method private static isGranted(Ljava/lang/String;)Z
    .registers 2

    .line 132
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    invoke-static {v0, p0}, Landroidx/core/content/ContextCompat;->checkSelfPermission(Landroid/content/Context;Ljava/lang/String;)I

    move-result p0

    if-nez p0, :cond_c

    const/4 p0, 0x1

    goto :goto_d

    :cond_c
    const/4 p0, 0x0

    :goto_d
    return p0
.end method

.method public static varargs isGranted([Ljava/lang/String;)Z
    .registers 3

    .line 94
    invoke-static {p0}, Lcom/blankj/utilcode/util/PermissionUtils;->getRequestAndDeniedPermissions([Ljava/lang/String;)Landroid/util/Pair;

    move-result-object p0

    .line 95
    iget-object v0, p0, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v0, Ljava/util/List;

    .line 96
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_10

    return v1

    .line 99
    :cond_10
    iget-object p0, p0, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast p0, Ljava/util/List;

    .line 100
    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :cond_18
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2b

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 101
    invoke-static {v0}, Lcom/blankj/utilcode/util/PermissionUtils;->isGranted(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_18

    return v1

    :cond_2b
    const/4 p0, 0x1

    return p0
.end method

.method public static isGrantedDrawOverlays()Z
    .registers 1

    .line 173
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    invoke-static {v0}, Landroid/provider/Settings;->canDrawOverlays(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public static isGrantedWriteSettings()Z
    .registers 1

    .line 142
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    invoke-static {v0}, Landroid/provider/Settings$System;->canWrite(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public static launchAppDetailsSettings()V
    .registers 2

    .line 201
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Application;->getPackageName()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/UtilsBridge;->getLaunchAppDetailsSettingsIntent(Ljava/lang/String;Z)Landroid/content/Intent;

    move-result-object v0

    .line 202
    invoke-static {v0}, Lcom/blankj/utilcode/util/UtilsBridge;->isIntentAvailable(Landroid/content/Intent;)Z

    move-result v1

    if-nez v1, :cond_14

    return-void

    .line 203
    :cond_14
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/app/Application;->startActivity(Landroid/content/Intent;)V

    return-void
.end method

.method private onRequestPermissionsResult(Landroid/app/Activity;)V
    .registers 2

    .line 416
    invoke-direct {p0, p1}, Lcom/blankj/utilcode/util/PermissionUtils;->getPermissionsStatus(Landroid/app/Activity;)V

    .line 417
    invoke-direct {p0}, Lcom/blankj/utilcode/util/PermissionUtils;->requestCallback()V

    return-void
.end method

.method public static varargs permission([Ljava/lang/String;)Lcom/blankj/utilcode/util/PermissionUtils;
    .registers 2

    .line 223
    new-instance v0, Lcom/blankj/utilcode/util/PermissionUtils;

    invoke-direct {v0, p0}, Lcom/blankj/utilcode/util/PermissionUtils;-><init>([Ljava/lang/String;)V

    return-object v0
.end method

.method public static varargs permissionGroup([Ljava/lang/String;)Lcom/blankj/utilcode/util/PermissionUtils;
    .registers 1

    .line 213
    invoke-static {p0}, Lcom/blankj/utilcode/util/PermissionUtils;->permission([Ljava/lang/String;)Lcom/blankj/utilcode/util/PermissionUtils;

    move-result-object p0

    return-object p0
.end method

.method private rationalInner(Lcom/blankj/utilcode/util/UtilsTransActivity;Ljava/lang/Runnable;)V
    .registers 5

    .line 358
    invoke-direct {p0, p1}, Lcom/blankj/utilcode/util/PermissionUtils;->getPermissionsStatus(Landroid/app/Activity;)V

    .line 359
    iget-object v0, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mOnRationaleListener:Lcom/blankj/utilcode/util/PermissionUtils$OnRationaleListener;

    new-instance v1, Lcom/blankj/utilcode/util/PermissionUtils$1;

    invoke-direct {v1, p0, p2, p1}, Lcom/blankj/utilcode/util/PermissionUtils$1;-><init>(Lcom/blankj/utilcode/util/PermissionUtils;Ljava/lang/Runnable;Lcom/blankj/utilcode/util/UtilsTransActivity;)V

    invoke-interface {v0, p1, v1}, Lcom/blankj/utilcode/util/PermissionUtils$OnRationaleListener;->rationale(Lcom/blankj/utilcode/util/UtilsTransActivity;Lcom/blankj/utilcode/util/PermissionUtils$OnRationaleListener$ShouldRequest;)V

    return-void
.end method

.method private requestCallback()V
    .registers 7

    .line 388
    iget-object v0, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mSingleCallback:Lcom/blankj/utilcode/util/PermissionUtils$SingleCallback;

    const/4 v1, 0x0

    if-eqz v0, :cond_16

    .line 389
    iget-object v2, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissionsDenied:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->isEmpty()Z

    move-result v2

    iget-object v3, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissionsGranted:Ljava/util/List;

    iget-object v4, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissionsDeniedForever:Ljava/util/List;

    iget-object v5, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissionsDenied:Ljava/util/List;

    invoke-interface {v0, v2, v3, v4, v5}, Lcom/blankj/utilcode/util/PermissionUtils$SingleCallback;->callback(ZLjava/util/List;Ljava/util/List;Ljava/util/List;)V

    .line 391
    iput-object v1, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mSingleCallback:Lcom/blankj/utilcode/util/PermissionUtils$SingleCallback;

    .line 393
    :cond_16
    iget-object v0, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mSimpleCallback:Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;

    if-eqz v0, :cond_2f

    .line 394
    iget-object v0, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissionsDenied:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_28

    .line 395
    iget-object v0, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mSimpleCallback:Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;

    invoke-interface {v0}, Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;->onGranted()V

    goto :goto_2d

    .line 397
    :cond_28
    iget-object v0, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mSimpleCallback:Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;

    invoke-interface {v0}, Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;->onDenied()V

    .line 399
    :goto_2d
    iput-object v1, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mSimpleCallback:Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;

    .line 401
    :cond_2f
    iget-object v0, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mFullCallback:Lcom/blankj/utilcode/util/PermissionUtils$FullCallback;

    if-eqz v0, :cond_5d

    .line 402
    iget-object v0, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissionsRequest:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-eqz v0, :cond_43

    iget-object v0, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissionsGranted:Ljava/util/List;

    .line 403
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_4a

    .line 404
    :cond_43
    iget-object v0, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mFullCallback:Lcom/blankj/utilcode/util/PermissionUtils$FullCallback;

    iget-object v2, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissionsGranted:Ljava/util/List;

    invoke-interface {v0, v2}, Lcom/blankj/utilcode/util/PermissionUtils$FullCallback;->onGranted(Ljava/util/List;)V

    .line 406
    :cond_4a
    iget-object v0, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissionsDenied:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_5b

    .line 407
    iget-object v0, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mFullCallback:Lcom/blankj/utilcode/util/PermissionUtils$FullCallback;

    iget-object v2, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissionsDeniedForever:Ljava/util/List;

    iget-object v3, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissionsDenied:Ljava/util/List;

    invoke-interface {v0, v2, v3}, Lcom/blankj/utilcode/util/PermissionUtils$FullCallback;->onDenied(Ljava/util/List;Ljava/util/List;)V

    .line 409
    :cond_5b
    iput-object v1, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mFullCallback:Lcom/blankj/utilcode/util/PermissionUtils$FullCallback;

    .line 411
    :cond_5d
    iput-object v1, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mOnRationaleListener:Lcom/blankj/utilcode/util/PermissionUtils$OnRationaleListener;

    .line 412
    iput-object v1, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mThemeCallback:Lcom/blankj/utilcode/util/PermissionUtils$ThemeCallback;

    return-void
.end method

.method public static requestDrawOverlays(Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;)V
    .registers 2

    .line 178
    invoke-static {}, Lcom/blankj/utilcode/util/PermissionUtils;->isGrantedDrawOverlays()Z

    move-result v0

    if-eqz v0, :cond_c

    if-eqz p0, :cond_b

    .line 179
    invoke-interface {p0}, Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;->onGranted()V

    :cond_b
    return-void

    .line 182
    :cond_c
    sput-object p0, Lcom/blankj/utilcode/util/PermissionUtils;->sSimpleCallback4DrawOverlays:Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;

    const/4 p0, 0x3

    .line 183
    invoke-static {p0}, Lcom/blankj/utilcode/util/PermissionUtils$PermissionActivityImpl;->start(I)V

    return-void
.end method

.method public static requestWriteSettings(Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;)V
    .registers 2

    .line 147
    invoke-static {}, Lcom/blankj/utilcode/util/PermissionUtils;->isGrantedWriteSettings()Z

    move-result v0

    if-eqz v0, :cond_c

    if-eqz p0, :cond_b

    .line 148
    invoke-interface {p0}, Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;->onGranted()V

    :cond_b
    return-void

    .line 151
    :cond_c
    sput-object p0, Lcom/blankj/utilcode/util/PermissionUtils;->sSimpleCallback4WriteSettings:Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;

    const/4 p0, 0x2

    .line 152
    invoke-static {p0}, Lcom/blankj/utilcode/util/PermissionUtils$PermissionActivityImpl;->start(I)V

    return-void
.end method

.method private shouldRationale(Lcom/blankj/utilcode/util/UtilsTransActivity;Ljava/lang/Runnable;)Z
    .registers 6

    .line 344
    iget-object v0, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mOnRationaleListener:Lcom/blankj/utilcode/util/PermissionUtils$OnRationaleListener;

    const/4 v1, 0x0

    if-eqz v0, :cond_25

    .line 345
    iget-object v0, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissionsRequest:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_b
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_22

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 346
    invoke-virtual {p1, v2}, Lcom/blankj/utilcode/util/UtilsTransActivity;->shouldShowRequestPermissionRationale(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_b

    .line 347
    invoke-direct {p0, p1, p2}, Lcom/blankj/utilcode/util/PermissionUtils;->rationalInner(Lcom/blankj/utilcode/util/UtilsTransActivity;Ljava/lang/Runnable;)V

    const/4 p1, 0x1

    move v1, p1

    :cond_22
    const/4 p1, 0x0

    .line 352
    iput-object p1, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mOnRationaleListener:Lcom/blankj/utilcode/util/PermissionUtils$OnRationaleListener;

    :cond_25
    return v1
.end method

.method private static startOverlayPermissionActivity(Landroid/app/Activity;I)V
    .registers 5

    .line 188
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.settings.action.MANAGE_OVERLAY_PERMISSION"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 189
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "package:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Application;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 190
    invoke-static {v0}, Lcom/blankj/utilcode/util/UtilsBridge;->isIntentAvailable(Landroid/content/Intent;)Z

    move-result v1

    if-nez v1, :cond_2f

    .line 191
    invoke-static {}, Lcom/blankj/utilcode/util/PermissionUtils;->launchAppDetailsSettings()V

    return-void

    .line 194
    :cond_2f
    invoke-virtual {p0, v0, p1}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    return-void
.end method

.method private startPermissionActivity()V
    .registers 2

    const/4 v0, 0x1

    .line 337
    invoke-static {v0}, Lcom/blankj/utilcode/util/PermissionUtils$PermissionActivityImpl;->start(I)V

    return-void
.end method

.method private static startWriteSettingsActivity(Landroid/app/Activity;I)V
    .registers 5

    .line 157
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.settings.action.MANAGE_WRITE_SETTINGS"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 158
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "package:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Application;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 159
    invoke-static {v0}, Lcom/blankj/utilcode/util/UtilsBridge;->isIntentAvailable(Landroid/content/Intent;)Z

    move-result v1

    if-nez v1, :cond_2f

    .line 160
    invoke-static {}, Lcom/blankj/utilcode/util/PermissionUtils;->launchAppDetailsSettings()V

    return-void

    .line 163
    :cond_2f
    invoke-virtual {p0, v0, p1}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    return-void
.end method


# virtual methods
.method public callback(Lcom/blankj/utilcode/util/PermissionUtils$FullCallback;)Lcom/blankj/utilcode/util/PermissionUtils;
    .registers 2

    .line 282
    iput-object p1, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mFullCallback:Lcom/blankj/utilcode/util/PermissionUtils$FullCallback;

    return-object p0
.end method

.method public callback(Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;)Lcom/blankj/utilcode/util/PermissionUtils;
    .registers 2

    .line 271
    iput-object p1, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mSimpleCallback:Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;

    return-object p0
.end method

.method public callback(Lcom/blankj/utilcode/util/PermissionUtils$SingleCallback;)Lcom/blankj/utilcode/util/PermissionUtils;
    .registers 2

    .line 260
    iput-object p1, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mSingleCallback:Lcom/blankj/utilcode/util/PermissionUtils$SingleCallback;

    return-object p0
.end method

.method public explain(Lcom/blankj/utilcode/util/PermissionUtils$OnExplainListener;)Lcom/blankj/utilcode/util/PermissionUtils;
    .registers 2

    .line 238
    iput-object p1, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mOnExplainListener:Lcom/blankj/utilcode/util/PermissionUtils$OnExplainListener;

    return-object p0
.end method

.method public rationale(Lcom/blankj/utilcode/util/PermissionUtils$OnRationaleListener;)Lcom/blankj/utilcode/util/PermissionUtils;
    .registers 2

    .line 249
    iput-object p1, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mOnRationaleListener:Lcom/blankj/utilcode/util/PermissionUtils$OnRationaleListener;

    return-object p0
.end method

.method public request()V
    .registers 4

    .line 301
    iget-object v0, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissionsParam:[Ljava/lang/String;

    if-eqz v0, :cond_77

    array-length v0, v0

    if-gtz v0, :cond_8

    goto :goto_77

    .line 306
    :cond_8
    new-instance v0, Ljava/util/LinkedHashSet;

    invoke-direct {v0}, Ljava/util/LinkedHashSet;-><init>()V

    iput-object v0, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissions:Ljava/util/Set;

    .line 307
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissionsRequest:Ljava/util/List;

    .line 308
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissionsGranted:Ljava/util/List;

    .line 309
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissionsDenied:Ljava/util/List;

    .line 310
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissionsDeniedForever:Ljava/util/List;

    .line 312
    iget-object v0, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissionsParam:[Ljava/lang/String;

    invoke-static {v0}, Lcom/blankj/utilcode/util/PermissionUtils;->getRequestAndDeniedPermissions([Ljava/lang/String;)Landroid/util/Pair;

    move-result-object v0

    .line 313
    iget-object v1, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissions:Ljava/util/Set;

    iget-object v2, v0, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v2, Ljava/util/Collection;

    invoke-interface {v1, v2}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 314
    iget-object v1, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissionsDenied:Ljava/util/List;

    iget-object v0, v0, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v0, Ljava/util/Collection;

    invoke-interface {v1, v0}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 320
    iget-object v0, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissions:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_49
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_67

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 321
    invoke-static {v1}, Lcom/blankj/utilcode/util/PermissionUtils;->isGranted(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_61

    .line 322
    iget-object v2, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissionsGranted:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_49

    .line 324
    :cond_61
    iget-object v2, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissionsRequest:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_49

    .line 327
    :cond_67
    iget-object v0, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mPermissionsRequest:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_73

    .line 328
    invoke-direct {p0}, Lcom/blankj/utilcode/util/PermissionUtils;->requestCallback()V

    goto :goto_76

    .line 330
    :cond_73
    invoke-direct {p0}, Lcom/blankj/utilcode/util/PermissionUtils;->startPermissionActivity()V

    :goto_76
    return-void

    :cond_77
    :goto_77
    const-string v0, "PermissionUtils"

    const-string v1, "No permissions to request."

    .line 302
    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    return-void
.end method

.method public theme(Lcom/blankj/utilcode/util/PermissionUtils$ThemeCallback;)Lcom/blankj/utilcode/util/PermissionUtils;
    .registers 2

    .line 293
    iput-object p1, p0, Lcom/blankj/utilcode/util/PermissionUtils;->mThemeCallback:Lcom/blankj/utilcode/util/PermissionUtils$ThemeCallback;

    return-object p0
.end method
