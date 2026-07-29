.class public final Lcom/example/extool/MainActivity$onCreate$1$1;
.super Ljava/lang/Object;
.source "MainActivity.kt"

# interfaces
.implements Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/example/extool/MainActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016J\u0008\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\u0005"
    }
    d2 = {
        "com/example/extool/MainActivity$onCreate$1$1",
        "Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;",
        "onDenied",
        "",
        "onGranted",
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


# instance fields
.field final synthetic this$0:Lcom/example/extool/MainActivity;


# direct methods
.method constructor <init>(Lcom/example/extool/MainActivity;)V
    .registers 2

    iput-object p1, p0, Lcom/example/extool/MainActivity$onCreate$1$1;->this$0:Lcom/example/extool/MainActivity;

    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDenied()V
    .registers 1

    return-void
.end method

.method public onGranted()V
    .registers 2

    .line 26
    iget-object v0, p0, Lcom/example/extool/MainActivity$onCreate$1$1;->this$0:Lcom/example/extool/MainActivity;

    # invokes: Lcom/example/extool/MainActivity;->showDetail()V
    invoke-static {v0}, Lcom/example/extool/MainActivity;->access$showDetail(Lcom/example/extool/MainActivity;)V

    return-void
.end method
