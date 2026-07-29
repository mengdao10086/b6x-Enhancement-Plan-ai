.class public Lcom/blankj/utilcode/util/UtilsTransActivity;
.super Landroidx/appcompat/app/AppCompatActivity;
.source "UtilsTransActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;
    }
.end annotation


# static fields
.field private static final CALLBACK_MAP:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Lcom/blankj/utilcode/util/UtilsTransActivity;",
            "Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;",
            ">;"
        }
    .end annotation
.end field

.field protected static final EXTRA_DELEGATE:Ljava/lang/String; = "extra_delegate"


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/blankj/utilcode/util/UtilsTransActivity;->CALLBACK_MAP:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Landroidx/appcompat/app/AppCompatActivity;-><init>()V

    return-void
.end method

.method public static start(Landroid/app/Activity;Lcom/blankj/utilcode/util/Utils$Consumer;Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Lcom/blankj/utilcode/util/Utils$Consumer<",
            "Landroid/content/Intent;",
            ">;",
            "Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;",
            ")V"
        }
    .end annotation

    const-class v0, Lcom/blankj/utilcode/util/UtilsTransActivity;

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/UtilsTransActivity;->start(Landroid/app/Activity;Lcom/blankj/utilcode/util/Utils$Consumer;Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;Ljava/lang/Class;)V

    return-void
.end method

.method protected static start(Landroid/app/Activity;Lcom/blankj/utilcode/util/Utils$Consumer;Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;Ljava/lang/Class;)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Lcom/blankj/utilcode/util/Utils$Consumer<",
            "Landroid/content/Intent;",
            ">;",
            "Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;",
            "Ljava/lang/Class<",
            "*>;)V"
        }
    .end annotation

    if-nez p2, :cond_3

    return-void

    :cond_3
    new-instance v0, Landroid/content/Intent;

    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v1

    invoke-direct {v0, v1, p3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    const-string p3, "extra_delegate"

    invoke-virtual {v0, p3, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    if-eqz p1, :cond_16

    invoke-interface {p1, v0}, Lcom/blankj/utilcode/util/Utils$Consumer;->accept(Ljava/lang/Object;)V

    :cond_16
    if-nez p0, :cond_25

    const/high16 p0, 0x10000000

    invoke-virtual {v0, p0}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object p0

    invoke-virtual {p0, v0}, Landroid/app/Application;->startActivity(Landroid/content/Intent;)V

    goto :goto_28

    :cond_25
    invoke-virtual {p0, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    :goto_28
    return-void
.end method

.method public static start(Landroid/app/Activity;Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;)V
    .registers 4

    const/4 v0, 0x0

    const-class v1, Lcom/blankj/utilcode/util/UtilsTransActivity;

    invoke-static {p0, v0, p1, v1}, Lcom/blankj/utilcode/util/UtilsTransActivity;->start(Landroid/app/Activity;Lcom/blankj/utilcode/util/Utils$Consumer;Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;Ljava/lang/Class;)V

    return-void
.end method

.method public static start(Lcom/blankj/utilcode/util/Utils$Consumer;Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/blankj/utilcode/util/Utils$Consumer<",
            "Landroid/content/Intent;",
            ">;",
            "Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;",
            ")V"
        }
    .end annotation

    const/4 v0, 0x0

    const-class v1, Lcom/blankj/utilcode/util/UtilsTransActivity;

    invoke-static {v0, p0, p1, v1}, Lcom/blankj/utilcode/util/UtilsTransActivity;->start(Landroid/app/Activity;Lcom/blankj/utilcode/util/Utils$Consumer;Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;Ljava/lang/Class;)V

    return-void
.end method

.method public static start(Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;)V
    .registers 3

    const/4 v0, 0x0

    const-class v1, Lcom/blankj/utilcode/util/UtilsTransActivity;

    invoke-static {v0, v0, p0, v1}, Lcom/blankj/utilcode/util/UtilsTransActivity;->start(Landroid/app/Activity;Lcom/blankj/utilcode/util/Utils$Consumer;Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;Ljava/lang/Class;)V

    return-void
.end method


# virtual methods
.method public dispatchTouchEvent(Landroid/view/MotionEvent;)Z
    .registers 3

    sget-object v0, Lcom/blankj/utilcode/util/UtilsTransActivity;->CALLBACK_MAP:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;

    if-nez v0, :cond_f

    invoke-super {p0, p1}, Landroidx/appcompat/app/AppCompatActivity;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z

    move-result p1

    return p1

    :cond_f
    invoke-virtual {v0, p0, p1}, Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;->dispatchTouchEvent(Lcom/blankj/utilcode/util/UtilsTransActivity;Landroid/view/MotionEvent;)Z

    move-result v0

    if-eqz v0, :cond_17

    const/4 p1, 0x1

    return p1

    :cond_17
    invoke-super {p0, p1}, Landroidx/appcompat/app/AppCompatActivity;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z

    move-result p1

    return p1
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .registers 5

    invoke-super {p0, p1, p2, p3}, Landroidx/appcompat/app/AppCompatActivity;->onActivityResult(IILandroid/content/Intent;)V

    sget-object v0, Lcom/blankj/utilcode/util/UtilsTransActivity;->CALLBACK_MAP:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;

    if-nez v0, :cond_e

    return-void

    :cond_e
    invoke-virtual {v0, p0, p1, p2, p3}, Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;->onActivityResult(Lcom/blankj/utilcode/util/UtilsTransActivity;IILandroid/content/Intent;)V

    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .registers 4

    const/4 v0, 0x0

    invoke-virtual {p0, v0, v0}, Lcom/blankj/utilcode/util/UtilsTransActivity;->overridePendingTransition(II)V

    invoke-virtual {p0}, Lcom/blankj/utilcode/util/UtilsTransActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "extra_delegate"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getSerializableExtra(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    instance-of v1, v0, Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;

    if-nez v1, :cond_19

    invoke-super {p0, p1}, Landroidx/appcompat/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    invoke-virtual {p0}, Lcom/blankj/utilcode/util/UtilsTransActivity;->finish()V

    return-void

    :cond_19
    check-cast v0, Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;

    sget-object v1, Lcom/blankj/utilcode/util/UtilsTransActivity;->CALLBACK_MAP:Ljava/util/Map;

    invoke-interface {v1, p0, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {v0, p0, p1}, Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;->onCreateBefore(Lcom/blankj/utilcode/util/UtilsTransActivity;Landroid/os/Bundle;)V

    invoke-super {p0, p1}, Landroidx/appcompat/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    invoke-virtual {v0, p0, p1}, Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;->onCreated(Lcom/blankj/utilcode/util/UtilsTransActivity;Landroid/os/Bundle;)V

    return-void
.end method

.method protected onDestroy()V
    .registers 3

    invoke-super {p0}, Landroidx/appcompat/app/AppCompatActivity;->onDestroy()V

    sget-object v0, Lcom/blankj/utilcode/util/UtilsTransActivity;->CALLBACK_MAP:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;

    if-nez v1, :cond_e

    return-void

    :cond_e
    invoke-virtual {v1, p0}, Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;->onDestroy(Lcom/blankj/utilcode/util/UtilsTransActivity;)V

    invoke-interface {v0, p0}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method protected onPause()V
    .registers 2

    const/4 v0, 0x0

    invoke-virtual {p0, v0, v0}, Lcom/blankj/utilcode/util/UtilsTransActivity;->overridePendingTransition(II)V

    invoke-super {p0}, Landroidx/appcompat/app/AppCompatActivity;->onPause()V

    sget-object v0, Lcom/blankj/utilcode/util/UtilsTransActivity;->CALLBACK_MAP:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;

    if-nez v0, :cond_12

    return-void

    :cond_12
    invoke-virtual {v0, p0}, Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;->onPaused(Lcom/blankj/utilcode/util/UtilsTransActivity;)V

    return-void
.end method

.method public onRequestPermissionsResult(I[Ljava/lang/String;[I)V
    .registers 5

    invoke-super {p0, p1, p2, p3}, Landroidx/appcompat/app/AppCompatActivity;->onRequestPermissionsResult(I[Ljava/lang/String;[I)V

    sget-object v0, Lcom/blankj/utilcode/util/UtilsTransActivity;->CALLBACK_MAP:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;

    if-nez v0, :cond_e

    return-void

    :cond_e
    invoke-virtual {v0, p0, p1, p2, p3}, Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;->onRequestPermissionsResult(Lcom/blankj/utilcode/util/UtilsTransActivity;I[Ljava/lang/String;[I)V

    return-void
.end method

.method protected onResume()V
    .registers 2

    invoke-super {p0}, Landroidx/appcompat/app/AppCompatActivity;->onResume()V

    sget-object v0, Lcom/blankj/utilcode/util/UtilsTransActivity;->CALLBACK_MAP:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;

    if-nez v0, :cond_e

    return-void

    :cond_e
    invoke-virtual {v0, p0}, Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;->onResumed(Lcom/blankj/utilcode/util/UtilsTransActivity;)V

    return-void
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .registers 3

    invoke-super {p0, p1}, Landroidx/appcompat/app/AppCompatActivity;->onSaveInstanceState(Landroid/os/Bundle;)V

    sget-object v0, Lcom/blankj/utilcode/util/UtilsTransActivity;->CALLBACK_MAP:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;

    if-nez v0, :cond_e

    return-void

    :cond_e
    invoke-virtual {v0, p0, p1}, Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;->onSaveInstanceState(Lcom/blankj/utilcode/util/UtilsTransActivity;Landroid/os/Bundle;)V

    return-void
.end method

.method protected onStart()V
    .registers 2

    invoke-super {p0}, Landroidx/appcompat/app/AppCompatActivity;->onStart()V

    sget-object v0, Lcom/blankj/utilcode/util/UtilsTransActivity;->CALLBACK_MAP:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;

    if-nez v0, :cond_e

    return-void

    :cond_e
    invoke-virtual {v0, p0}, Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;->onStarted(Lcom/blankj/utilcode/util/UtilsTransActivity;)V

    return-void
.end method

.method protected onStop()V
    .registers 2

    invoke-super {p0}, Landroidx/appcompat/app/AppCompatActivity;->onStop()V

    sget-object v0, Lcom/blankj/utilcode/util/UtilsTransActivity;->CALLBACK_MAP:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;

    if-nez v0, :cond_e

    return-void

    :cond_e
    invoke-virtual {v0, p0}, Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;->onStopped(Lcom/blankj/utilcode/util/UtilsTransActivity;)V

    return-void
.end method
