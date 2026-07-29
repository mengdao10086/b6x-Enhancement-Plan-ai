.class public Lcom/permissionx/guolindev/PermissionX;
.super Ljava/lang/Object;
.source "PermissionX.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/permissionx/guolindev/PermissionX$permission;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static areNotificationsEnabled(Landroid/content/Context;)Z
    .registers 1

    .line 83
    invoke-static {p0}, Landroidx/core/app/NotificationManagerCompat;->from(Landroid/content/Context;)Landroidx/core/app/NotificationManagerCompat;

    move-result-object p0

    invoke-virtual {p0}, Landroidx/core/app/NotificationManagerCompat;->areNotificationsEnabled()Z

    move-result p0

    return p0
.end method

.method public static init(Landroidx/fragment/app/Fragment;)Lcom/permissionx/guolindev/PermissionMediator;
    .registers 2

    .line 62
    new-instance v0, Lcom/permissionx/guolindev/PermissionMediator;

    invoke-direct {v0, p0}, Lcom/permissionx/guolindev/PermissionMediator;-><init>(Landroidx/fragment/app/Fragment;)V

    return-object v0
.end method

.method public static init(Landroidx/fragment/app/FragmentActivity;)Lcom/permissionx/guolindev/PermissionMediator;
    .registers 2

    .line 52
    new-instance v0, Lcom/permissionx/guolindev/PermissionMediator;

    invoke-direct {v0, p0}, Lcom/permissionx/guolindev/PermissionMediator;-><init>(Landroidx/fragment/app/FragmentActivity;)V

    return-object v0
.end method

.method public static isGranted(Landroid/content/Context;Ljava/lang/String;)Z
    .registers 2

    .line 73
    invoke-static {p0, p1}, Landroidx/core/content/ContextCompat;->checkSelfPermission(Landroid/content/Context;Ljava/lang/String;)I

    move-result p0

    if-nez p0, :cond_8

    const/4 p0, 0x1

    goto :goto_9

    :cond_8
    const/4 p0, 0x0

    :goto_9
    return p0
.end method
