.class final Lcom/example/extool/B6ExperimentalActivity$onCreate$3;
.super Lkotlin/jvm/internal/Lambda;
.source "B6ExperimentalActivity.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function1;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/example/extool/B6ExperimentalActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/Lambda;",
        "Lkotlin/jvm/functions/Function1<",
        "Ljava/lang/Integer;",
        "Lkotlin/Unit;",
        ">;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\u0008\u0005\u0010\u0006"
    }
    d2 = {
        "<anonymous>",
        "",
        "it",
        "",
        "kotlin.jvm.PlatformType",
        "invoke",
        "(Ljava/lang/Integer;)V"
    }
    k = 0x3
    mv = {
        0x1,
        0x8,
        0x0
    }
    xi = 0x30
.end annotation


# instance fields
.field final synthetic this$0:Lcom/example/extool/B6ExperimentalActivity;


# direct methods
.method public static synthetic $r8$lambda$D_9TdkYYzBBg5K5TJauGM0r9WcE(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V
    .registers 2

    invoke-static {p0, p1}, Lcom/example/extool/B6ExperimentalActivity$onCreate$3;->invoke$lambda$3$lambda$2(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V

    return-void
.end method

.method public static synthetic $r8$lambda$MeQmKdxNjr7nk9-dg4PZ6rO-ORg(Lcom/example/extool/B6ExperimentalActivity;Landroid/content/DialogInterface;I)V
    .registers 3

    invoke-static {p0, p1, p2}, Lcom/example/extool/B6ExperimentalActivity$onCreate$3;->invoke$lambda$3(Lcom/example/extool/B6ExperimentalActivity;Landroid/content/DialogInterface;I)V

    return-void
.end method

.method public static synthetic $r8$lambda$XZo3_5UWnlRzEpNJoKM0DsnXdFI(Lcom/example/extool/B6ExperimentalActivity;Landroid/content/DialogInterface;I)V
    .registers 3

    invoke-static {p0, p1, p2}, Lcom/example/extool/B6ExperimentalActivity$onCreate$3;->invoke$lambda$1(Lcom/example/extool/B6ExperimentalActivity;Landroid/content/DialogInterface;I)V

    return-void
.end method

.method public static synthetic $r8$lambda$qyiR_5_6ZHu2q7upB1ZBcVBeOyQ(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V
    .registers 2

    invoke-static {p0, p1}, Lcom/example/extool/B6ExperimentalActivity$onCreate$3;->invoke$lambda$1$lambda$0(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V

    return-void
.end method

.method constructor <init>(Lcom/example/extool/B6ExperimentalActivity;)V
    .registers 2

    iput-object p1, p0, Lcom/example/extool/B6ExperimentalActivity$onCreate$3;->this$0:Lcom/example/extool/B6ExperimentalActivity;

    const/4 p1, 0x1

    invoke-direct {p0, p1}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method

.method private static final invoke$lambda$1(Lcom/example/extool/B6ExperimentalActivity;Landroid/content/DialogInterface;I)V
    .registers 3

    const-string p2, "this$0"

    invoke-static {p0, p2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    if-eqz p1, :cond_a

    .line 37
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 38
    :cond_a
    new-instance p1, Landroid/content/Intent;

    invoke-direct {p1}, Landroid/content/Intent;-><init>()V

    const-string p2, "android.settings.LOCATION_SOURCE_SETTINGS"

    .line 39
    invoke-virtual {p1, p2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 40
    move-object p2, p0

    check-cast p2, Landroid/app/Activity;

    invoke-static {p2}, Lrx_activity_result2/RxActivityResult;->on(Landroid/app/Activity;)Lrx_activity_result2/RxActivityResult$Builder;

    move-result-object p2

    invoke-virtual {p2, p1}, Lrx_activity_result2/RxActivityResult$Builder;->startIntent(Landroid/content/Intent;)Lio/reactivex/Observable;

    move-result-object p1

    new-instance p2, Lcom/example/extool/B6ExperimentalActivity$onCreate$3$1$1;

    invoke-direct {p2, p0}, Lcom/example/extool/B6ExperimentalActivity$onCreate$3$1$1;-><init>(Lcom/example/extool/B6ExperimentalActivity;)V

    check-cast p2, Lkotlin/jvm/functions/Function1;

    new-instance p0, Lcom/example/extool/B6ExperimentalActivity$onCreate$3$$ExternalSyntheticLambda1;

    invoke-direct {p0, p2}, Lcom/example/extool/B6ExperimentalActivity$onCreate$3$$ExternalSyntheticLambda1;-><init>(Lkotlin/jvm/functions/Function1;)V

    invoke-virtual {p1, p0}, Lio/reactivex/Observable;->subscribe(Lio/reactivex/functions/Consumer;)Lio/reactivex/disposables/Disposable;

    return-void
.end method

.method private static final invoke$lambda$1$lambda$0(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V
    .registers 3

    const-string v0, "$tmp0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 40
    invoke-interface {p0, p1}, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method private static final invoke$lambda$3(Lcom/example/extool/B6ExperimentalActivity;Landroid/content/DialogInterface;I)V
    .registers 5

    const-string p2, "this$0"

    invoke-static {p0, p2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    if-eqz p1, :cond_a

    .line 48
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 49
    :cond_a
    new-instance p1, Landroid/content/Intent;

    invoke-direct {p1}, Landroid/content/Intent;-><init>()V

    const-string p2, "android.settings.APPLICATION_DETAILS_SETTINGS"

    .line 50
    invoke-virtual {p1, p2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 51
    invoke-virtual {p0}, Lcom/example/extool/B6ExperimentalActivity;->getPackageName()Ljava/lang/String;

    move-result-object p2

    const/4 v0, 0x0

    const-string v1, "package"

    invoke-static {v1, p2, v0}, Landroid/net/Uri;->fromParts(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object p2

    invoke-virtual {p1, p2}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 52
    move-object p2, p0

    check-cast p2, Landroid/app/Activity;

    invoke-static {p2}, Lrx_activity_result2/RxActivityResult;->on(Landroid/app/Activity;)Lrx_activity_result2/RxActivityResult$Builder;

    move-result-object p2

    invoke-virtual {p2, p1}, Lrx_activity_result2/RxActivityResult$Builder;->startIntent(Landroid/content/Intent;)Lio/reactivex/Observable;

    move-result-object p1

    new-instance p2, Lcom/example/extool/B6ExperimentalActivity$onCreate$3$2$1;

    invoke-direct {p2, p0}, Lcom/example/extool/B6ExperimentalActivity$onCreate$3$2$1;-><init>(Lcom/example/extool/B6ExperimentalActivity;)V

    check-cast p2, Lkotlin/jvm/functions/Function1;

    new-instance p0, Lcom/example/extool/B6ExperimentalActivity$onCreate$3$$ExternalSyntheticLambda0;

    invoke-direct {p0, p2}, Lcom/example/extool/B6ExperimentalActivity$onCreate$3$$ExternalSyntheticLambda0;-><init>(Lkotlin/jvm/functions/Function1;)V

    invoke-virtual {p1, p0}, Lio/reactivex/Observable;->subscribe(Lio/reactivex/functions/Consumer;)Lio/reactivex/disposables/Disposable;

    return-void
.end method

.method private static final invoke$lambda$3$lambda$2(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V
    .registers 3

    const-string v0, "$tmp0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 52
    invoke-interface {p0, p1}, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 2

    .line 32
    check-cast p1, Ljava/lang/Integer;

    invoke-virtual {p0, p1}, Lcom/example/extool/B6ExperimentalActivity$onCreate$3;->invoke(Ljava/lang/Integer;)V

    sget-object p1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p1
.end method

.method public final invoke(Ljava/lang/Integer;)V
    .registers 6

    const-string v0, "\u53bb\u5f00\u542f"

    const/4 v1, 0x0

    if-nez p1, :cond_6

    goto :goto_3f

    .line 33
    :cond_6
    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v2

    const/16 v3, 0x8

    if-ne v2, v3, :cond_3f

    .line 34
    new-instance p1, Landroidx/appcompat/app/AlertDialog$Builder;

    iget-object v2, p0, Lcom/example/extool/B6ExperimentalActivity$onCreate$3;->this$0:Lcom/example/extool/B6ExperimentalActivity;

    check-cast v2, Landroid/content/Context;

    invoke-direct {p1, v2}, Landroidx/appcompat/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    const-string v2, "\u8bf7\u5f00\u542f\u4f4d\u7f6e\u670d\u52a1"

    move-object v3, v2

    check-cast v3, Ljava/lang/CharSequence;

    invoke-virtual {p1, v3}, Landroidx/appcompat/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroidx/appcompat/app/AlertDialog$Builder;

    move-result-object p1

    check-cast v2, Ljava/lang/CharSequence;

    invoke-virtual {p1, v2}, Landroidx/appcompat/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroidx/appcompat/app/AlertDialog$Builder;

    move-result-object p1

    .line 35
    invoke-virtual {p1, v1}, Landroidx/appcompat/app/AlertDialog$Builder;->setCancelable(Z)Landroidx/appcompat/app/AlertDialog$Builder;

    move-result-object p1

    check-cast v0, Ljava/lang/CharSequence;

    iget-object v1, p0, Lcom/example/extool/B6ExperimentalActivity$onCreate$3;->this$0:Lcom/example/extool/B6ExperimentalActivity;

    new-instance v2, Lcom/example/extool/B6ExperimentalActivity$onCreate$3$$ExternalSyntheticLambda2;

    invoke-direct {v2, v1}, Lcom/example/extool/B6ExperimentalActivity$onCreate$3$$ExternalSyntheticLambda2;-><init>(Lcom/example/extool/B6ExperimentalActivity;)V

    invoke-virtual {p1, v0, v2}, Landroidx/appcompat/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroidx/appcompat/app/AlertDialog$Builder;

    move-result-object p1

    .line 43
    invoke-virtual {p1}, Landroidx/appcompat/app/AlertDialog$Builder;->create()Landroidx/appcompat/app/AlertDialog;

    move-result-object p1

    invoke-virtual {p1}, Landroidx/appcompat/app/AlertDialog;->show()V

    goto :goto_93

    :cond_3f
    :goto_3f
    if-nez p1, :cond_42

    goto :goto_7c

    .line 45
    :cond_42
    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p1

    const/16 v2, 0x9

    if-ne p1, v2, :cond_7c

    .line 46
    new-instance p1, Landroidx/appcompat/app/AlertDialog$Builder;

    iget-object v2, p0, Lcom/example/extool/B6ExperimentalActivity$onCreate$3;->this$0:Lcom/example/extool/B6ExperimentalActivity;

    check-cast v2, Landroid/content/Context;

    invoke-direct {p1, v2}, Landroidx/appcompat/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    const-string v2, "\u7f3a\u5c11\u5b9a\u4f4d\u6743\u9650"

    check-cast v2, Ljava/lang/CharSequence;

    invoke-virtual {p1, v2}, Landroidx/appcompat/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroidx/appcompat/app/AlertDialog$Builder;

    move-result-object p1

    const-string v2, "\u8bf7\u6388\u6743\u5b9a\u4f4d\u6743\u9650"

    check-cast v2, Ljava/lang/CharSequence;

    invoke-virtual {p1, v2}, Landroidx/appcompat/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroidx/appcompat/app/AlertDialog$Builder;

    move-result-object p1

    .line 47
    invoke-virtual {p1, v1}, Landroidx/appcompat/app/AlertDialog$Builder;->setCancelable(Z)Landroidx/appcompat/app/AlertDialog$Builder;

    move-result-object p1

    check-cast v0, Ljava/lang/CharSequence;

    iget-object v1, p0, Lcom/example/extool/B6ExperimentalActivity$onCreate$3;->this$0:Lcom/example/extool/B6ExperimentalActivity;

    new-instance v2, Lcom/example/extool/B6ExperimentalActivity$onCreate$3$$ExternalSyntheticLambda3;

    invoke-direct {v2, v1}, Lcom/example/extool/B6ExperimentalActivity$onCreate$3$$ExternalSyntheticLambda3;-><init>(Lcom/example/extool/B6ExperimentalActivity;)V

    invoke-virtual {p1, v0, v2}, Landroidx/appcompat/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroidx/appcompat/app/AlertDialog$Builder;

    move-result-object p1

    .line 55
    invoke-virtual {p1}, Landroidx/appcompat/app/AlertDialog$Builder;->create()Landroidx/appcompat/app/AlertDialog;

    move-result-object p1

    invoke-virtual {p1}, Landroidx/appcompat/app/AlertDialog;->show()V

    goto :goto_93

    .line 57
    :cond_7c
    :goto_7c
    iget-object p1, p0, Lcom/example/extool/B6ExperimentalActivity$onCreate$3;->this$0:Lcom/example/extool/B6ExperimentalActivity;

    # getter for: Lcom/example/extool/B6ExperimentalActivity;->binding:Lcom/example/extool/databinding/ActivityExperimentalB6Binding;
    invoke-static {p1}, Lcom/example/extool/B6ExperimentalActivity;->access$getBinding$p(Lcom/example/extool/B6ExperimentalActivity;)Lcom/example/extool/databinding/ActivityExperimentalB6Binding;

    move-result-object p1

    if-nez p1, :cond_8a

    const-string p1, "binding"

    invoke-static {p1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 p1, 0x0

    :cond_8a
    iget-object p1, p1, Lcom/example/extool/databinding/ActivityExperimentalB6Binding;->tvConnectState:Landroid/widget/TextView;

    const-string v0, "\u626b\u63cf\u5931\u8d25"

    check-cast v0, Ljava/lang/CharSequence;

    invoke-virtual {p1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :goto_93
    return-void
.end method
