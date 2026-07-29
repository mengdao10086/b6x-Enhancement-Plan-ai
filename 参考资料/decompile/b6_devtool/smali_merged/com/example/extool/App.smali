.class public final Lcom/example/extool/App;
.super Landroid/app/Application;
.source "App.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"
    }
    d2 = {
        "Lcom/example/extool/App;",
        "Landroid/app/Application;",
        "()V",
        "onCreate",
        "",
        "exTool_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x8,
        0x0
    }
    xi = 0x30
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    .line 10
    invoke-direct {p0}, Landroid/app/Application;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreate()V
    .registers 4

    .line 12
    invoke-super {p0}, Landroid/app/Application;->onCreate()V

    .line 13
    move-object v0, p0

    check-cast v0, Landroid/app/Application;

    invoke-static {v0}, Lcom/blankj/utilcode/util/Utils;->init(Landroid/app/Application;)V

    .line 14
    move-object v0, p0

    check-cast v0, Landroid/content/Context;

    new-instance v1, Lcom/example/extool/App$onCreate$1;

    invoke-direct {v1}, Lcom/example/extool/App$onCreate$1;-><init>()V

    check-cast v1, Lcom/flydigi/sdk/bluetooth/DeviceFilter;

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Lcom/flydigi/sdk/waspwing/WaspWingManager;->init(Landroid/content/Context;Lcom/flydigi/sdk/bluetooth/DeviceFilter;Z)V

    return-void
.end method
