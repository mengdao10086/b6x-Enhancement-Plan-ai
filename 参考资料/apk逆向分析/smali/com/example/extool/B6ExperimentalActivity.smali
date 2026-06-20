.class public final Lcom/example/extool/B6ExperimentalActivity;
.super Landroidx/appcompat/app/AppCompatActivity;
.source "B6ExperimentalActivity.kt"


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nB6ExperimentalActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 B6ExperimentalActivity.kt\ncom/example/extool/B6ExperimentalActivity\n+ 2 ActivityViewModelLazy.kt\nandroidx/activity/ActivityViewModelLazyKt\n*L\n1#1,69:1\n75#2,13:70\n*S KotlinDebug\n*F\n+ 1 B6ExperimentalActivity.kt\ncom/example/extool/B6ExperimentalActivity\n*L\n18#1:70,13\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0008\u0010\u000f\u001a\u00020\u000cH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008\u00a8\u0006\u0010"
    }
    d2 = {
        "Lcom/example/extool/B6ExperimentalActivity;",
        "Landroidx/appcompat/app/AppCompatActivity;",
        "()V",
        "binding",
        "Lcom/example/extool/databinding/ActivityExperimentalB6Binding;",
        "viewModel",
        "Lcom/example/extool/WaspWingViewModel;",
        "getViewModel",
        "()Lcom/example/extool/WaspWingViewModel;",
        "viewModel$delegate",
        "Lkotlin/Lazy;",
        "onCreate",
        "",
        "savedInstanceState",
        "Landroid/os/Bundle;",
        "onResume",
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
.field private binding:Lcom/example/extool/databinding/ActivityExperimentalB6Binding;

.field private final viewModel$delegate:Lkotlin/Lazy;


# direct methods
.method public static synthetic $r8$lambda$9unseIyjPdTPVD_2QGLTDxUSjag(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V
    .registers 2

    invoke-static {p0, p1}, Lcom/example/extool/B6ExperimentalActivity;->onCreate$lambda$1(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V

    return-void
.end method

.method public static synthetic $r8$lambda$_-ilCIxV9Q4qRVYxuwpObGgceOg(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V
    .registers 2

    invoke-static {p0, p1}, Lcom/example/extool/B6ExperimentalActivity;->onCreate$lambda$0(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V

    return-void
.end method

.method public static synthetic $r8$lambda$diGEsijTsVN5J-x4z7i5_KxWoVA(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V
    .registers 2

    invoke-static {p0, p1}, Lcom/example/extool/B6ExperimentalActivity;->onCreate$lambda$2(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V

    return-void
.end method

.method public constructor <init>()V
    .registers 8

    const v0, 0x7f0b001c

    .line 16
    invoke-direct {p0, v0}, Landroidx/appcompat/app/AppCompatActivity;-><init>(I)V

    .line 18
    move-object v0, p0

    check-cast v0, Landroidx/activity/ComponentActivity;

    .line 74
    new-instance v1, Lcom/example/extool/B6ExperimentalActivity$special$$inlined$viewModels$default$1;

    invoke-direct {v1, v0}, Lcom/example/extool/B6ExperimentalActivity$special$$inlined$viewModels$default$1;-><init>(Landroidx/activity/ComponentActivity;)V

    check-cast v1, Lkotlin/jvm/functions/Function0;

    .line 78
    new-instance v2, Landroidx/lifecycle/ViewModelLazy;

    const-class v3, Lcom/example/extool/WaspWingViewModel;

    invoke-static {v3}, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;

    move-result-object v3

    .line 80
    new-instance v4, Lcom/example/extool/B6ExperimentalActivity$special$$inlined$viewModels$default$2;

    invoke-direct {v4, v0}, Lcom/example/extool/B6ExperimentalActivity$special$$inlined$viewModels$default$2;-><init>(Landroidx/activity/ComponentActivity;)V

    check-cast v4, Lkotlin/jvm/functions/Function0;

    .line 82
    new-instance v5, Lcom/example/extool/B6ExperimentalActivity$special$$inlined$viewModels$default$3;

    const/4 v6, 0x0

    invoke-direct {v5, v6, v0}, Lcom/example/extool/B6ExperimentalActivity$special$$inlined$viewModels$default$3;-><init>(Lkotlin/jvm/functions/Function0;Landroidx/activity/ComponentActivity;)V

    check-cast v5, Lkotlin/jvm/functions/Function0;

    .line 78
    invoke-direct {v2, v3, v4, v1, v5}, Landroidx/lifecycle/ViewModelLazy;-><init>(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V

    check-cast v2, Lkotlin/Lazy;

    .line 18
    iput-object v2, p0, Lcom/example/extool/B6ExperimentalActivity;->viewModel$delegate:Lkotlin/Lazy;

    return-void
.end method

.method public static final synthetic access$getBinding$p(Lcom/example/extool/B6ExperimentalActivity;)Lcom/example/extool/databinding/ActivityExperimentalB6Binding;
    .registers 1

    .line 16
    iget-object p0, p0, Lcom/example/extool/B6ExperimentalActivity;->binding:Lcom/example/extool/databinding/ActivityExperimentalB6Binding;

    return-object p0
.end method

.method public static final synthetic access$getViewModel(Lcom/example/extool/B6ExperimentalActivity;)Lcom/example/extool/WaspWingViewModel;
    .registers 1

    .line 16
    invoke-direct {p0}, Lcom/example/extool/B6ExperimentalActivity;->getViewModel()Lcom/example/extool/WaspWingViewModel;

    move-result-object p0

    return-object p0
.end method

.method private final getViewModel()Lcom/example/extool/WaspWingViewModel;
    .registers 2

    .line 18
    iget-object v0, p0, Lcom/example/extool/B6ExperimentalActivity;->viewModel$delegate:Lkotlin/Lazy;

    invoke-interface {v0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/example/extool/WaspWingViewModel;

    return-object v0
.end method

.method private static final onCreate$lambda$0(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V
    .registers 3

    const-string v0, "$tmp0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 24
    invoke-interface {p0, p1}, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method private static final onCreate$lambda$1(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V
    .registers 3

    const-string v0, "$tmp0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 27
    invoke-interface {p0, p1}, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method private static final onCreate$lambda$2(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V
    .registers 3

    const-string v0, "$tmp0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 32
    invoke-interface {p0, p1}, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .registers 5

    .line 21
    invoke-super {p0, p1}, Landroidx/appcompat/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 22
    move-object p1, p0

    check-cast p1, Landroid/app/Activity;

    const v0, 0x7f0b001c

    invoke-static {p1, v0}, Landroidx/databinding/DataBindingUtil;->setContentView(Landroid/app/Activity;I)Landroidx/databinding/ViewDataBinding;

    move-result-object p1

    const-string v0, "setContentView(this, R.l\u2026activity_experimental_b6)"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p1, Lcom/example/extool/databinding/ActivityExperimentalB6Binding;

    iput-object p1, p0, Lcom/example/extool/B6ExperimentalActivity;->binding:Lcom/example/extool/databinding/ActivityExperimentalB6Binding;

    if-nez p1, :cond_1e

    const-string p1, "binding"

    .line 23
    invoke-static {p1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 p1, 0x0

    :cond_1e
    invoke-direct {p0}, Lcom/example/extool/B6ExperimentalActivity;->getViewModel()Lcom/example/extool/WaspWingViewModel;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/example/extool/databinding/ActivityExperimentalB6Binding;->setViewModel(Lcom/example/extool/WaspWingViewModel;)V

    .line 24
    invoke-direct {p0}, Lcom/example/extool/B6ExperimentalActivity;->getViewModel()Lcom/example/extool/WaspWingViewModel;

    move-result-object p1

    invoke-virtual {p1}, Lcom/example/extool/WaspWingViewModel;->getWaspWingInfo()Landroidx/lifecycle/LiveData;

    move-result-object p1

    move-object v0, p0

    check-cast v0, Landroidx/lifecycle/LifecycleOwner;

    new-instance v1, Lcom/example/extool/B6ExperimentalActivity$onCreate$1;

    invoke-direct {v1, p0}, Lcom/example/extool/B6ExperimentalActivity$onCreate$1;-><init>(Lcom/example/extool/B6ExperimentalActivity;)V

    check-cast v1, Lkotlin/jvm/functions/Function1;

    new-instance v2, Lcom/example/extool/B6ExperimentalActivity$$ExternalSyntheticLambda0;

    invoke-direct {v2, v1}, Lcom/example/extool/B6ExperimentalActivity$$ExternalSyntheticLambda0;-><init>(Lkotlin/jvm/functions/Function1;)V

    invoke-virtual {p1, v0, v2}, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    .line 27
    invoke-direct {p0}, Lcom/example/extool/B6ExperimentalActivity;->getViewModel()Lcom/example/extool/WaspWingViewModel;

    move-result-object p1

    invoke-virtual {p1}, Lcom/example/extool/WaspWingViewModel;->getConnectLiveData()Landroidx/lifecycle/LiveData;

    move-result-object p1

    new-instance v1, Lcom/example/extool/B6ExperimentalActivity$onCreate$2;

    invoke-direct {v1, p0}, Lcom/example/extool/B6ExperimentalActivity$onCreate$2;-><init>(Lcom/example/extool/B6ExperimentalActivity;)V

    check-cast v1, Lkotlin/jvm/functions/Function1;

    new-instance v2, Lcom/example/extool/B6ExperimentalActivity$$ExternalSyntheticLambda1;

    invoke-direct {v2, v1}, Lcom/example/extool/B6ExperimentalActivity$$ExternalSyntheticLambda1;-><init>(Lkotlin/jvm/functions/Function1;)V

    invoke-virtual {p1, v0, v2}, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    .line 32
    invoke-direct {p0}, Lcom/example/extool/B6ExperimentalActivity;->getViewModel()Lcom/example/extool/WaspWingViewModel;

    move-result-object p1

    invoke-virtual {p1}, Lcom/example/extool/WaspWingViewModel;->getScanFailedLiveData()Landroidx/lifecycle/LiveData;

    move-result-object p1

    new-instance v1, Lcom/example/extool/B6ExperimentalActivity$onCreate$3;

    invoke-direct {v1, p0}, Lcom/example/extool/B6ExperimentalActivity$onCreate$3;-><init>(Lcom/example/extool/B6ExperimentalActivity;)V

    check-cast v1, Lkotlin/jvm/functions/Function1;

    new-instance v2, Lcom/example/extool/B6ExperimentalActivity$$ExternalSyntheticLambda2;

    invoke-direct {v2, v1}, Lcom/example/extool/B6ExperimentalActivity$$ExternalSyntheticLambda2;-><init>(Lkotlin/jvm/functions/Function1;)V

    invoke-virtual {p1, v0, v2}, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    return-void
.end method

.method protected onResume()V
    .registers 3

    .line 64
    invoke-super {p0}, Landroidx/appcompat/app/AppCompatActivity;->onResume()V

    .line 65
    invoke-direct {p0}, Lcom/example/extool/B6ExperimentalActivity;->getViewModel()Lcom/example/extool/WaspWingViewModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/example/extool/WaspWingViewModel;->getConnectLiveData()Landroidx/lifecycle/LiveData;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;

    move-result-object v0

    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_21

    .line 66
    invoke-direct {p0}, Lcom/example/extool/B6ExperimentalActivity;->getViewModel()Lcom/example/extool/WaspWingViewModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/example/extool/WaspWingViewModel;->tryConnect()V

    :cond_21
    return-void
.end method
