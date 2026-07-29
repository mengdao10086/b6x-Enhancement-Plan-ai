.class public final Lcom/permissionx/guolindev/dialog/DefaultDialog;
.super Lcom/permissionx/guolindev/dialog/RationaleDialog;
.source "DefaultDialog.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u0008\u001a\u00020\u0006\u0012\u0008\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\rJ\u0008\u0010\u0010\u001a\u00020\u0011H\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u000e\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0008\u0010\u0015\u001a\u00020\u0013H\u0016J\u0008\u0010\u0016\u001a\u00020\u0017H\u0002J\r\u0010\u0018\u001a\u00020\u0017H\u0000\u00a2\u0006\u0002\u0008\u0019J\u0012\u0010\u001a\u001a\u00020\u00112\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\u0008\u0010\u001d\u001a\u00020\u0011H\u0002J\u0008\u0010\u001e\u001a\u00020\u0011H\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"
    }
    d2 = {
        "Lcom/permissionx/guolindev/dialog/DefaultDialog;",
        "Lcom/permissionx/guolindev/dialog/RationaleDialog;",
        "context",
        "Landroid/content/Context;",
        "permissions",
        "",
        "",
        "message",
        "positiveText",
        "negativeText",
        "lightColor",
        "",
        "darkColor",
        "(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V",
        "binding",
        "Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;",
        "buildPermissionsLayout",
        "",
        "getNegativeButton",
        "Landroid/view/View;",
        "getPermissionsToRequest",
        "getPositiveButton",
        "isDarkTheme",
        "",
        "isPermissionLayoutEmpty",
        "isPermissionLayoutEmpty$permissionx_release",
        "onCreate",
        "savedInstanceState",
        "Landroid/os/Bundle;",
        "setupText",
        "setupWindow",
        "permissionx_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x7,
        0x1
    }
    xi = 0x30
.end annotation


# instance fields
.field private binding:Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;

.field private final darkColor:I

.field private final lightColor:I

.field private final message:Ljava/lang/String;

.field private final negativeText:Ljava/lang/String;

.field private final permissions:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final positiveText:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V
    .registers 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "II)V"
        }
    .end annotation

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "permissions"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "message"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "positiveText"

    invoke-static {p4, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 46
    sget v0, Lcom/permissionx/guolindev/R$style;->PermissionXDefaultDialog:I

    invoke-direct {p0, p1, v0}, Lcom/permissionx/guolindev/dialog/RationaleDialog;-><init>(Landroid/content/Context;I)V

    .line 40
    iput-object p2, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->permissions:Ljava/util/List;

    .line 41
    iput-object p3, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->message:Ljava/lang/String;

    .line 42
    iput-object p4, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->positiveText:Ljava/lang/String;

    .line 43
    iput-object p5, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->negativeText:Ljava/lang/String;

    .line 44
    iput p6, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->lightColor:I

    .line 45
    iput p7, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->darkColor:I

    return-void
.end method

.method private final buildPermissionsLayout()V
    .registers 13

    .line 125
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    .line 126
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 127
    iget-object v2, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->permissions:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_d
    :goto_d
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_23d

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    const/16 v4, 0x21

    const/16 v5, 0x1d

    const/4 v6, 0x0

    const/4 v7, 0x0

    if-ge v1, v5, :cond_39

    .line 131
    :try_start_21
    invoke-virtual {p0}, Lcom/permissionx/guolindev/dialog/DefaultDialog;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    invoke-virtual {v5, v3, v7}, Landroid/content/pm/PackageManager;->getPermissionInfo(Ljava/lang/String;I)Landroid/content/pm/PermissionInfo;

    move-result-object v5

    .line 132
    iget-object v5, v5, Landroid/content/pm/PermissionInfo;->group:Ljava/lang/String;
    :try_end_2f
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_21 .. :try_end_2f} :catch_30

    goto :goto_7b

    :catch_30
    move-exception v5

    .line 134
    invoke-virtual {v5}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    .line 135
    move-object v5, v6

    check-cast v5, Ljava/lang/String;

    move-object v5, v6

    goto :goto_7b

    :cond_39
    if-ne v1, v5, :cond_46

    .line 138
    invoke-static {}, Lcom/permissionx/guolindev/dialog/PermissionMapKt;->getPermissionMapOnQ()Ljava/util/Map;

    move-result-object v5

    invoke-interface {v5, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    goto :goto_7b

    :cond_46
    const/16 v5, 0x1e

    if-ne v1, v5, :cond_55

    .line 139
    invoke-static {}, Lcom/permissionx/guolindev/dialog/PermissionMapKt;->getPermissionMapOnR()Ljava/util/Map;

    move-result-object v5

    invoke-interface {v5, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    goto :goto_7b

    :cond_55
    const/16 v5, 0x1f

    if-ne v1, v5, :cond_64

    .line 140
    invoke-static {}, Lcom/permissionx/guolindev/dialog/PermissionMapKt;->getPermissionMapOnS()Ljava/util/Map;

    move-result-object v5

    invoke-interface {v5, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    goto :goto_7b

    :cond_64
    if-ne v1, v4, :cond_71

    .line 141
    invoke-static {}, Lcom/permissionx/guolindev/dialog/PermissionMapKt;->getPermissionMapOnT()Ljava/util/Map;

    move-result-object v5

    invoke-interface {v5, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    goto :goto_7b

    .line 145
    :cond_71
    invoke-static {}, Lcom/permissionx/guolindev/dialog/PermissionMapKt;->getPermissionMapOnT()Ljava/util/Map;

    move-result-object v5

    invoke-interface {v5, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .line 148
    :goto_7b
    invoke-static {}, Lcom/permissionx/guolindev/dialog/PermissionMapKt;->getAllSpecialPermissions()Ljava/util/Set;

    move-result-object v8

    invoke-interface {v8, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_8b

    invoke-virtual {v0, v3}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_93

    :cond_8b
    if-eqz v5, :cond_d

    .line 149
    invoke-virtual {v0, v5}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_d

    .line 150
    :cond_93
    invoke-virtual {p0}, Lcom/permissionx/guolindev/dialog/DefaultDialog;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v8

    iget-object v9, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->binding:Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;

    const-string v10, "binding"

    if-nez v9, :cond_a1

    invoke-static {v10}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v9, v6

    :cond_a1
    iget-object v9, v9, Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;->permissionsLayout:Landroid/widget/LinearLayout;

    check-cast v9, Landroid/view/ViewGroup;

    invoke-static {v8, v9, v7}, Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;->inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;

    move-result-object v8

    const-string v9, "inflate(layoutInflater, \u2026permissionsLayout, false)"

    invoke-static {v8, v9}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v9, "android.permission.ACCESS_BACKGROUND_LOCATION"

    .line 152
    invoke-static {v3, v9}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_df

    .line 153
    iget-object v4, v8, Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;->permissionText:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/permissionx/guolindev/dialog/DefaultDialog;->getContext()Landroid/content/Context;

    move-result-object v9

    sget v11, Lcom/permissionx/guolindev/R$string;->permissionx_access_background_location:I

    invoke-virtual {v9, v11}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v9

    check-cast v9, Ljava/lang/CharSequence;

    invoke-virtual {v4, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 154
    iget-object v4, v8, Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;->permissionIcon:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/permissionx/guolindev/dialog/DefaultDialog;->getContext()Landroid/content/Context;

    move-result-object v9

    invoke-virtual {v9}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v9

    invoke-static {v5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {v9, v5, v7}, Landroid/content/pm/PackageManager;->getPermissionGroupInfo(Ljava/lang/String;I)Landroid/content/pm/PermissionGroupInfo;

    move-result-object v7

    iget v7, v7, Landroid/content/pm/PermissionGroupInfo;->icon:I

    invoke-virtual {v4, v7}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_1fe

    :cond_df
    const-string v9, "android.permission.SYSTEM_ALERT_WINDOW"

    .line 156
    invoke-static {v3, v9}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_101

    .line 157
    iget-object v4, v8, Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;->permissionText:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/permissionx/guolindev/dialog/DefaultDialog;->getContext()Landroid/content/Context;

    move-result-object v7

    sget v9, Lcom/permissionx/guolindev/R$string;->permissionx_system_alert_window:I

    invoke-virtual {v7, v9}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v7

    check-cast v7, Ljava/lang/CharSequence;

    invoke-virtual {v4, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 158
    iget-object v4, v8, Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;->permissionIcon:Landroid/widget/ImageView;

    sget v7, Lcom/permissionx/guolindev/R$drawable;->permissionx_ic_alert:I

    invoke-virtual {v4, v7}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_1fe

    :cond_101
    const-string v9, "android.permission.WRITE_SETTINGS"

    .line 160
    invoke-static {v3, v9}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_123

    .line 161
    iget-object v4, v8, Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;->permissionText:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/permissionx/guolindev/dialog/DefaultDialog;->getContext()Landroid/content/Context;

    move-result-object v7

    sget v9, Lcom/permissionx/guolindev/R$string;->permissionx_write_settings:I

    invoke-virtual {v7, v9}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v7

    check-cast v7, Ljava/lang/CharSequence;

    invoke-virtual {v4, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 162
    iget-object v4, v8, Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;->permissionIcon:Landroid/widget/ImageView;

    sget v7, Lcom/permissionx/guolindev/R$drawable;->permissionx_ic_setting:I

    invoke-virtual {v4, v7}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_1fe

    :cond_123
    const-string v9, "android.permission.MANAGE_EXTERNAL_STORAGE"

    .line 164
    invoke-static {v3, v9}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_154

    .line 165
    iget-object v4, v8, Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;->permissionText:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/permissionx/guolindev/dialog/DefaultDialog;->getContext()Landroid/content/Context;

    move-result-object v9

    sget v11, Lcom/permissionx/guolindev/R$string;->permissionx_manage_external_storage:I

    invoke-virtual {v9, v11}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v9

    check-cast v9, Ljava/lang/CharSequence;

    invoke-virtual {v4, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 166
    iget-object v4, v8, Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;->permissionIcon:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/permissionx/guolindev/dialog/DefaultDialog;->getContext()Landroid/content/Context;

    move-result-object v9

    invoke-virtual {v9}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v9

    invoke-static {v5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {v9, v5, v7}, Landroid/content/pm/PackageManager;->getPermissionGroupInfo(Ljava/lang/String;I)Landroid/content/pm/PermissionGroupInfo;

    move-result-object v7

    iget v7, v7, Landroid/content/pm/PermissionGroupInfo;->icon:I

    invoke-virtual {v4, v7}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_1fe

    :cond_154
    const-string v9, "android.permission.REQUEST_INSTALL_PACKAGES"

    .line 168
    invoke-static {v3, v9}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_176

    .line 169
    iget-object v4, v8, Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;->permissionText:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/permissionx/guolindev/dialog/DefaultDialog;->getContext()Landroid/content/Context;

    move-result-object v7

    sget v9, Lcom/permissionx/guolindev/R$string;->permissionx_request_install_packages:I

    invoke-virtual {v7, v9}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v7

    check-cast v7, Ljava/lang/CharSequence;

    invoke-virtual {v4, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 170
    iget-object v4, v8, Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;->permissionIcon:Landroid/widget/ImageView;

    sget v7, Lcom/permissionx/guolindev/R$drawable;->permissionx_ic_install:I

    invoke-virtual {v4, v7}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_1fe

    :cond_176
    const-string v9, "android.permission.POST_NOTIFICATIONS"

    .line 172
    invoke-static {v3, v9}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_19b

    .line 173
    sget v9, Landroid/os/Build$VERSION;->SDK_INT:I

    if-ge v9, v4, :cond_19b

    .line 176
    iget-object v4, v8, Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;->permissionText:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/permissionx/guolindev/dialog/DefaultDialog;->getContext()Landroid/content/Context;

    move-result-object v7

    sget v9, Lcom/permissionx/guolindev/R$string;->permissionx_post_notification:I

    invoke-virtual {v7, v9}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v7

    check-cast v7, Ljava/lang/CharSequence;

    invoke-virtual {v4, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 177
    iget-object v4, v8, Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;->permissionIcon:Landroid/widget/ImageView;

    sget v7, Lcom/permissionx/guolindev/R$drawable;->permissionx_ic_notification:I

    invoke-virtual {v4, v7}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_1fe

    :cond_19b
    const-string v4, "android.permission.BODY_SENSORS_BACKGROUND"

    .line 179
    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1cb

    .line 180
    iget-object v4, v8, Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;->permissionText:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/permissionx/guolindev/dialog/DefaultDialog;->getContext()Landroid/content/Context;

    move-result-object v9

    sget v11, Lcom/permissionx/guolindev/R$string;->permissionx_body_sensor_background:I

    invoke-virtual {v9, v11}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v9

    check-cast v9, Ljava/lang/CharSequence;

    invoke-virtual {v4, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 181
    iget-object v4, v8, Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;->permissionIcon:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/permissionx/guolindev/dialog/DefaultDialog;->getContext()Landroid/content/Context;

    move-result-object v9

    invoke-virtual {v9}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v9

    invoke-static {v5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {v9, v5, v7}, Landroid/content/pm/PackageManager;->getPermissionGroupInfo(Ljava/lang/String;I)Landroid/content/pm/PermissionGroupInfo;

    move-result-object v7

    iget v7, v7, Landroid/content/pm/PermissionGroupInfo;->icon:I

    invoke-virtual {v4, v7}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_1fe

    .line 184
    :cond_1cb
    iget-object v4, v8, Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;->permissionText:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/permissionx/guolindev/dialog/DefaultDialog;->getContext()Landroid/content/Context;

    move-result-object v9

    invoke-virtual {p0}, Lcom/permissionx/guolindev/dialog/DefaultDialog;->getContext()Landroid/content/Context;

    move-result-object v11

    invoke-virtual {v11}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v11

    invoke-static {v5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {v11, v5, v7}, Landroid/content/pm/PackageManager;->getPermissionGroupInfo(Ljava/lang/String;I)Landroid/content/pm/PermissionGroupInfo;

    move-result-object v11

    iget v11, v11, Landroid/content/pm/PermissionGroupInfo;->labelRes:I

    invoke-virtual {v9, v11}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v9

    check-cast v9, Ljava/lang/CharSequence;

    invoke-virtual {v4, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 185
    iget-object v4, v8, Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;->permissionIcon:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/permissionx/guolindev/dialog/DefaultDialog;->getContext()Landroid/content/Context;

    move-result-object v9

    invoke-virtual {v9}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v9

    invoke-virtual {v9, v5, v7}, Landroid/content/pm/PackageManager;->getPermissionGroupInfo(Ljava/lang/String;I)Landroid/content/pm/PermissionGroupInfo;

    move-result-object v7

    iget v7, v7, Landroid/content/pm/PermissionGroupInfo;->icon:I

    invoke-virtual {v4, v7}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 188
    :goto_1fe
    invoke-direct {p0}, Lcom/permissionx/guolindev/dialog/DefaultDialog;->isDarkTheme()Z

    move-result v4

    const/4 v7, -0x1

    if-eqz v4, :cond_213

    .line 189
    iget v4, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->darkColor:I

    if-eq v4, v7, :cond_220

    .line 190
    iget-object v4, v8, Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;->permissionIcon:Landroid/widget/ImageView;

    iget v7, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->darkColor:I

    sget-object v9, Landroid/graphics/PorterDuff$Mode;->SRC_ATOP:Landroid/graphics/PorterDuff$Mode;

    invoke-virtual {v4, v7, v9}, Landroid/widget/ImageView;->setColorFilter(ILandroid/graphics/PorterDuff$Mode;)V

    goto :goto_220

    .line 193
    :cond_213
    iget v4, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->lightColor:I

    if-eq v4, v7, :cond_220

    .line 194
    iget-object v4, v8, Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;->permissionIcon:Landroid/widget/ImageView;

    iget v7, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->lightColor:I

    sget-object v9, Landroid/graphics/PorterDuff$Mode;->SRC_ATOP:Landroid/graphics/PorterDuff$Mode;

    invoke-virtual {v4, v7, v9}, Landroid/widget/ImageView;->setColorFilter(ILandroid/graphics/PorterDuff$Mode;)V

    .line 197
    :cond_220
    :goto_220
    iget-object v4, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->binding:Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;

    if-nez v4, :cond_228

    invoke-static {v10}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_229

    :cond_228
    move-object v6, v4

    :goto_229
    iget-object v4, v6, Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;->permissionsLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v8}, Lcom/permissionx/guolindev/databinding/PermissionxPermissionItemBinding;->getRoot()Landroid/widget/LinearLayout;

    move-result-object v6

    check-cast v6, Landroid/view/View;

    invoke-virtual {v4, v6}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    if-nez v5, :cond_237

    goto :goto_238

    :cond_237
    move-object v3, v5

    .line 198
    :goto_238
    invoke-virtual {v0, v3}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    goto/16 :goto_d

    :cond_23d
    return-void
.end method

.method private final isDarkTheme()Z
    .registers 3

    .line 232
    invoke-virtual {p0}, Lcom/permissionx/guolindev/dialog/DefaultDialog;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    iget v0, v0, Landroid/content/res/Configuration;->uiMode:I

    and-int/lit8 v0, v0, 0x30

    const/16 v1, 0x20

    if-ne v0, v1, :cond_16

    const/4 v0, 0x1

    goto :goto_17

    :cond_16
    const/4 v0, 0x0

    :goto_17
    return v0
.end method

.method private final setupText()V
    .registers 5

    .line 99
    iget-object v0, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->binding:Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;

    const/4 v1, 0x0

    const-string v2, "binding"

    if-nez v0, :cond_b

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_b
    iget-object v0, v0, Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;->messageText:Landroid/widget/TextView;

    iget-object v3, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->message:Ljava/lang/String;

    check-cast v3, Ljava/lang/CharSequence;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 100
    iget-object v0, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->binding:Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;

    if-nez v0, :cond_1c

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_1c
    iget-object v0, v0, Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;->positiveBtn:Landroid/widget/Button;

    iget-object v3, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->positiveText:Ljava/lang/String;

    check-cast v3, Ljava/lang/CharSequence;

    invoke-virtual {v0, v3}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 101
    iget-object v0, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->negativeText:Ljava/lang/String;

    if-eqz v0, :cond_49

    .line 102
    iget-object v0, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->binding:Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;

    if-nez v0, :cond_31

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_31
    iget-object v0, v0, Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;->negativeLayout:Landroid/widget/LinearLayout;

    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 103
    iget-object v0, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->binding:Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;

    if-nez v0, :cond_3f

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_3f
    iget-object v0, v0, Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;->negativeBtn:Landroid/widget/Button;

    iget-object v3, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->negativeText:Ljava/lang/String;

    check-cast v3, Ljava/lang/CharSequence;

    invoke-virtual {v0, v3}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    goto :goto_58

    .line 105
    :cond_49
    iget-object v0, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->binding:Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;

    if-nez v0, :cond_51

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_51
    iget-object v0, v0, Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;->negativeLayout:Landroid/widget/LinearLayout;

    const/16 v3, 0x8

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 107
    :goto_58
    invoke-direct {p0}, Lcom/permissionx/guolindev/dialog/DefaultDialog;->isDarkTheme()Z

    move-result v0

    const/4 v3, -0x1

    if-eqz v0, :cond_83

    .line 108
    iget v0, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->darkColor:I

    if-eq v0, v3, :cond_a6

    .line 109
    iget-object v0, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->binding:Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;

    if-nez v0, :cond_6b

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_6b
    iget-object v0, v0, Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;->positiveBtn:Landroid/widget/Button;

    iget v3, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->darkColor:I

    invoke-virtual {v0, v3}, Landroid/widget/Button;->setTextColor(I)V

    .line 110
    iget-object v0, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->binding:Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;

    if-nez v0, :cond_7a

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_7b

    :cond_7a
    move-object v1, v0

    :goto_7b
    iget-object v0, v1, Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;->negativeBtn:Landroid/widget/Button;

    iget v1, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->darkColor:I

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setTextColor(I)V

    goto :goto_a6

    .line 113
    :cond_83
    iget v0, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->lightColor:I

    if-eq v0, v3, :cond_a6

    .line 114
    iget-object v0, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->binding:Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;

    if-nez v0, :cond_8f

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_8f
    iget-object v0, v0, Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;->positiveBtn:Landroid/widget/Button;

    iget v3, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->lightColor:I

    invoke-virtual {v0, v3}, Landroid/widget/Button;->setTextColor(I)V

    .line 115
    iget-object v0, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->binding:Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;

    if-nez v0, :cond_9e

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_9f

    :cond_9e
    move-object v1, v0

    :goto_9f
    iget-object v0, v1, Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;->negativeBtn:Landroid/widget/Button;

    iget v1, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->lightColor:I

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setTextColor(I)V

    :cond_a6
    :goto_a6
    return-void
.end method

.method private final setupWindow()V
    .registers 9

    .line 207
    invoke-virtual {p0}, Lcom/permissionx/guolindev/dialog/DefaultDialog;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    .line 208
    invoke-virtual {p0}, Lcom/permissionx/guolindev/dialog/DefaultDialog;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v1, v1, Landroid/util/DisplayMetrics;->heightPixels:I

    const/16 v2, 0x11

    if-ge v0, v1, :cond_3b

    .line 211
    invoke-virtual {p0}, Lcom/permissionx/guolindev/dialog/DefaultDialog;->getWindow()Landroid/view/Window;

    move-result-object v1

    if-eqz v1, :cond_55

    .line 212
    invoke-virtual {v1}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v3

    .line 213
    invoke-virtual {v1, v2}, Landroid/view/Window;->setGravity(I)V

    int-to-double v4, v0

    const-wide v6, 0x3feb851eb851eb85L    # 0.86

    mul-double/2addr v4, v6

    double-to-int v0, v4

    .line 214
    iput v0, v3, Landroid/view/WindowManager$LayoutParams;->width:I

    .line 215
    invoke-virtual {v1, v3}, Landroid/view/Window;->setAttributes(Landroid/view/WindowManager$LayoutParams;)V

    goto :goto_55

    .line 219
    :cond_3b
    invoke-virtual {p0}, Lcom/permissionx/guolindev/dialog/DefaultDialog;->getWindow()Landroid/view/Window;

    move-result-object v1

    if-eqz v1, :cond_55

    .line 220
    invoke-virtual {v1}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v3

    .line 221
    invoke-virtual {v1, v2}, Landroid/view/Window;->setGravity(I)V

    int-to-double v4, v0

    const-wide v6, 0x3fe3333333333333L    # 0.6

    mul-double/2addr v4, v6

    double-to-int v0, v4

    .line 222
    iput v0, v3, Landroid/view/WindowManager$LayoutParams;->width:I

    .line 223
    invoke-virtual {v1, v3}, Landroid/view/Window;->setAttributes(Landroid/view/WindowManager$LayoutParams;)V

    :cond_55
    :goto_55
    return-void
.end method


# virtual methods
.method public getNegativeButton()Landroid/view/View;
    .registers 3

    .line 73
    iget-object v0, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->negativeText:Ljava/lang/String;

    const/4 v1, 0x0

    if-eqz v0, :cond_15

    .line 74
    iget-object v0, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->binding:Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;

    if-nez v0, :cond_f

    const-string v0, "binding"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_10

    :cond_f
    move-object v1, v0

    :goto_10
    iget-object v0, v1, Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;->negativeBtn:Landroid/widget/Button;

    check-cast v0, Landroid/view/View;

    return-object v0

    :cond_15
    move-object v0, v1

    check-cast v0, Landroid/view/View;

    return-object v1
.end method

.method public getPermissionsToRequest()Ljava/util/List;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 83
    iget-object v0, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->permissions:Ljava/util/List;

    return-object v0
.end method

.method public getPositiveButton()Landroid/view/View;
    .registers 3

    .line 64
    iget-object v0, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->binding:Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;

    if-nez v0, :cond_a

    const-string v0, "binding"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 v0, 0x0

    :cond_a
    iget-object v0, v0, Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;->positiveBtn:Landroid/widget/Button;

    const-string v1, "binding.positiveBtn"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Landroid/view/View;

    return-object v0
.end method

.method public final isPermissionLayoutEmpty$permissionx_release()Z
    .registers 2

    .line 92
    iget-object v0, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->binding:Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;

    if-nez v0, :cond_a

    const-string v0, "binding"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 v0, 0x0

    :cond_a
    iget-object v0, v0, Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;->permissionsLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v0

    if-nez v0, :cond_14

    const/4 v0, 0x1

    goto :goto_15

    :cond_14
    const/4 v0, 0x0

    :goto_15
    return v0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .registers 3

    .line 51
    invoke-super {p0, p1}, Lcom/permissionx/guolindev/dialog/RationaleDialog;->onCreate(Landroid/os/Bundle;)V

    .line 52
    invoke-virtual {p0}, Lcom/permissionx/guolindev/dialog/DefaultDialog;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object p1

    invoke-static {p1}, Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;->inflate(Landroid/view/LayoutInflater;)Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;

    move-result-object p1

    const-string v0, "inflate(layoutInflater)"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object p1, p0, Lcom/permissionx/guolindev/dialog/DefaultDialog;->binding:Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;

    if-nez p1, :cond_1a

    const-string p1, "binding"

    .line 53
    invoke-static {p1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 p1, 0x0

    :cond_1a
    invoke-virtual {p1}, Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;->getRoot()Landroid/widget/LinearLayout;

    move-result-object p1

    check-cast p1, Landroid/view/View;

    invoke-virtual {p0, p1}, Lcom/permissionx/guolindev/dialog/DefaultDialog;->setContentView(Landroid/view/View;)V

    .line 54
    invoke-direct {p0}, Lcom/permissionx/guolindev/dialog/DefaultDialog;->setupText()V

    .line 55
    invoke-direct {p0}, Lcom/permissionx/guolindev/dialog/DefaultDialog;->buildPermissionsLayout()V

    .line 56
    invoke-direct {p0}, Lcom/permissionx/guolindev/dialog/DefaultDialog;->setupWindow()V

    return-void
.end method
