.class public final Landroidx/core/app/ShareCompat;
.super Ljava/lang/Object;
.source "ShareCompat.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/core/app/ShareCompat$Api16Impl;,
        Landroidx/core/app/ShareCompat$IntentReader;,
        Landroidx/core/app/ShareCompat$IntentBuilder;
    }
.end annotation


# static fields
.field public static final EXTRA_CALLING_ACTIVITY:Ljava/lang/String; = "androidx.core.app.EXTRA_CALLING_ACTIVITY"

.field public static final EXTRA_CALLING_ACTIVITY_INTEROP:Ljava/lang/String; = "android.support.v4.app.EXTRA_CALLING_ACTIVITY"

.field public static final EXTRA_CALLING_PACKAGE:Ljava/lang/String; = "androidx.core.app.EXTRA_CALLING_PACKAGE"

.field public static final EXTRA_CALLING_PACKAGE_INTEROP:Ljava/lang/String; = "android.support.v4.app.EXTRA_CALLING_PACKAGE"

.field private static final HISTORY_FILENAME_PREFIX:Ljava/lang/String; = ".sharecompat_"


# direct methods
.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static configureMenuItem(Landroid/view/Menu;ILandroidx/core/app/ShareCompat$IntentBuilder;)V
    .registers 4
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    invoke-interface {p0, p1}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object p0

    if-eqz p0, :cond_a

    invoke-static {p0, p2}, Landroidx/core/app/ShareCompat;->configureMenuItem(Landroid/view/MenuItem;Landroidx/core/app/ShareCompat$IntentBuilder;)V

    return-void

    :cond_a
    new-instance p0, Ljava/lang/IllegalArgumentException;

    new-instance p2, Ljava/lang/StringBuilder;

    const-string v0, "Could not find menu item with id "

    invoke-direct {p2, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p1

    const-string p2, " in the supplied menu"

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static configureMenuItem(Landroid/view/MenuItem;Landroidx/core/app/ShareCompat$IntentBuilder;)V
    .registers 5
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    invoke-interface {p0}, Landroid/view/MenuItem;->getActionProvider()Landroid/view/ActionProvider;

    move-result-object v0

    instance-of v1, v0, Landroid/widget/ShareActionProvider;

    if-nez v1, :cond_12

    new-instance v0, Landroid/widget/ShareActionProvider;

    invoke-virtual {p1}, Landroidx/core/app/ShareCompat$IntentBuilder;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/widget/ShareActionProvider;-><init>(Landroid/content/Context;)V

    goto :goto_14

    :cond_12
    check-cast v0, Landroid/widget/ShareActionProvider;

    :goto_14
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, ".sharecompat_"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroidx/core/app/ShareCompat$IntentBuilder;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ShareActionProvider;->setShareHistoryFileName(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroidx/core/app/ShareCompat$IntentBuilder;->getIntent()Landroid/content/Intent;

    move-result-object p1

    invoke-virtual {v0, p1}, Landroid/widget/ShareActionProvider;->setShareIntent(Landroid/content/Intent;)V

    invoke-interface {p0, v0}, Landroid/view/MenuItem;->setActionProvider(Landroid/view/ActionProvider;)Landroid/view/MenuItem;

    return-void
.end method

.method public static getCallingActivity(Landroid/app/Activity;)Landroid/content/ComponentName;
    .registers 2

    invoke-virtual {p0}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0}, Landroid/app/Activity;->getCallingActivity()Landroid/content/ComponentName;

    move-result-object p0

    if-nez p0, :cond_e

    invoke-static {v0}, Landroidx/core/app/ShareCompat;->getCallingActivity(Landroid/content/Intent;)Landroid/content/ComponentName;

    move-result-object p0

    :cond_e
    return-object p0
.end method

.method static getCallingActivity(Landroid/content/Intent;)Landroid/content/ComponentName;
    .registers 2

    const-string v0, "androidx.core.app.EXTRA_CALLING_ACTIVITY"

    invoke-virtual {p0, v0}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/content/ComponentName;

    if-nez v0, :cond_13

    const-string v0, "android.support.v4.app.EXTRA_CALLING_ACTIVITY"

    invoke-virtual {p0, v0}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object p0

    move-object v0, p0

    check-cast v0, Landroid/content/ComponentName;

    :cond_13
    return-object v0
.end method

.method public static getCallingPackage(Landroid/app/Activity;)Ljava/lang/String;
    .registers 2

    invoke-virtual {p0}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0}, Landroid/app/Activity;->getCallingPackage()Ljava/lang/String;

    move-result-object p0

    if-nez p0, :cond_10

    if-eqz v0, :cond_10

    invoke-static {v0}, Landroidx/core/app/ShareCompat;->getCallingPackage(Landroid/content/Intent;)Ljava/lang/String;

    move-result-object p0

    :cond_10
    return-object p0
.end method

.method static getCallingPackage(Landroid/content/Intent;)Ljava/lang/String;
    .registers 2

    const-string v0, "androidx.core.app.EXTRA_CALLING_PACKAGE"

    invoke-virtual {p0, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_e

    const-string v0, "android.support.v4.app.EXTRA_CALLING_PACKAGE"

    invoke-virtual {p0, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :cond_e
    return-object v0
.end method
