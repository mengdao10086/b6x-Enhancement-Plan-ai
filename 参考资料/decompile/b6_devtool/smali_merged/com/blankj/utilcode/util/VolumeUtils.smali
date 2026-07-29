.class public Lcom/blankj/utilcode/util/VolumeUtils;
.super Ljava/lang/Object;
.source "VolumeUtils.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getMaxVolume(I)I
    .registers 3

    .line 91
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    const-string v1, "audio"

    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/AudioManager;

    .line 93
    invoke-virtual {v0, p0}, Landroid/media/AudioManager;->getStreamMaxVolume(I)I

    move-result p0

    return p0
.end method

.method public static getMinVolume(I)I
    .registers 4

    .line 113
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    const-string v1, "audio"

    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/AudioManager;

    .line 114
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x1c

    if-lt v1, v2, :cond_17

    .line 116
    invoke-virtual {v0, p0}, Landroid/media/AudioManager;->getStreamMinVolume(I)I

    move-result p0

    return p0

    :cond_17
    const/4 p0, 0x0

    return p0
.end method

.method public static getVolume(I)I
    .registers 3

    .line 34
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    const-string v1, "audio"

    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/AudioManager;

    .line 36
    invoke-virtual {v0, p0}, Landroid/media/AudioManager;->getStreamVolume(I)I

    move-result p0

    return p0
.end method

.method public static setVolume(III)V
    .registers 5

    .line 66
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    const-string v1, "audio"

    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/AudioManager;

    .line 69
    :try_start_c
    invoke-virtual {v0, p0, p1, p2}, Landroid/media/AudioManager;->setStreamVolume(III)V
    :try_end_f
    .catch Ljava/lang/SecurityException; {:try_start_c .. :try_end_f} :catch_f

    :catch_f
    return-void
.end method
