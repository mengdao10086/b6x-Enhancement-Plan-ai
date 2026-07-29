.class public final Lcom/example/extool/MainActivity;
.super Landroidx/appcompat/app/AppCompatActivity;
.source "MainActivity.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0014J\u0008\u0010\t\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"
    }
    d2 = {
        "Lcom/example/extool/MainActivity;",
        "Landroidx/appcompat/app/AppCompatActivity;",
        "()V",
        "btnSetup",
        "Landroid/widget/Button;",
        "onCreate",
        "",
        "savedInstanceState",
        "Landroid/os/Bundle;",
        "showDetail",
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
.field private btnSetup:Landroid/widget/Button;


# direct methods
.method public static synthetic $r8$lambda$GkOOLDEfaKCiFCP-qdNmM-usY5w(Lcom/example/extool/MainActivity;Landroid/view/View;)V
    .registers 2

    invoke-static {p0, p1}, Lcom/example/extool/MainActivity;->onCreate$lambda$0(Lcom/example/extool/MainActivity;Landroid/view/View;)V

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .line 12
    invoke-direct {p0}, Landroidx/appcompat/app/AppCompatActivity;-><init>()V

    return-void
.end method

.method public static final synthetic access$showDetail(Lcom/example/extool/MainActivity;)V
    .registers 1

    .line 12
    invoke-direct {p0}, Lcom/example/extool/MainActivity;->showDetail()V

    return-void
.end method

.method private static final onCreate$lambda$0(Lcom/example/extool/MainActivity;Landroid/view/View;)V
    .registers 3

    const-string p1, "this$0"

    invoke-static {p0, p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 19
    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v0, 0x1e

    if-le p1, v0, :cond_26

    const-string p1, "android.permission.BLUETOOTH_CONNECT"

    const-string v0, "android.permission.BLUETOOTH_SCAN"

    .line 22
    filled-new-array {p1, v0}, [Ljava/lang/String;

    move-result-object p1

    .line 20
    invoke-static {p1}, Lcom/blankj/utilcode/util/PermissionUtils;->permission([Ljava/lang/String;)Lcom/blankj/utilcode/util/PermissionUtils;

    move-result-object p1

    .line 24
    new-instance v0, Lcom/example/extool/MainActivity$onCreate$1$1;

    invoke-direct {v0, p0}, Lcom/example/extool/MainActivity$onCreate$1$1;-><init>(Lcom/example/extool/MainActivity;)V

    check-cast v0, Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;

    invoke-virtual {p1, v0}, Lcom/blankj/utilcode/util/PermissionUtils;->callback(Lcom/blankj/utilcode/util/PermissionUtils$SimpleCallback;)Lcom/blankj/utilcode/util/PermissionUtils;

    move-result-object p0

    .line 33
    invoke-virtual {p0}, Lcom/blankj/utilcode/util/PermissionUtils;->request()V

    goto :goto_29

    .line 35
    :cond_26
    invoke-direct {p0}, Lcom/example/extool/MainActivity;->showDetail()V

    :goto_29
    return-void
.end method

.method private final showDetail()V
    .registers 4

    .line 44
    new-instance v0, Landroid/content/Intent;

    move-object v1, p0

    check-cast v1, Landroid/content/Context;

    const-class v2, Lcom/example/extool/B6ExperimentalActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 43
    invoke-virtual {p0, v0}, Lcom/example/extool/MainActivity;->startActivity(Landroid/content/Intent;)V

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .registers 3

    .line 15
    invoke-super {p0, p1}, Landroidx/appcompat/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    const p1, 0x7f0b001d

    .line 16
    invoke-virtual {p0, p1}, Lcom/example/extool/MainActivity;->setContentView(I)V

    const p1, 0x7f080062

    .line 17
    invoke-virtual {p0, p1}, Lcom/example/extool/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object p1

    const-string v0, "findViewById(R.id.btn_setup)"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p1, Landroid/widget/Button;

    iput-object p1, p0, Lcom/example/extool/MainActivity;->btnSetup:Landroid/widget/Button;

    if-nez p1, :cond_21

    const-string p1, "btnSetup"

    .line 18
    invoke-static {p1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 p1, 0x0

    :cond_21
    new-instance v0, Lcom/example/extool/MainActivity$$ExternalSyntheticLambda0;

    invoke-direct {v0, p0}, Lcom/example/extool/MainActivity$$ExternalSyntheticLambda0;-><init>(Lcom/example/extool/MainActivity;)V

    invoke-virtual {p1, v0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    return-void
.end method
