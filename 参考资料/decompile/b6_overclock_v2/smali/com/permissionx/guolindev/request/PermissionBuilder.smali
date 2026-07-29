.class public final Lcom/permissionx/guolindev/request/PermissionBuilder;
.super Ljava/lang/Object;
.source "PermissionBuilder.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/permissionx/guolindev/request/PermissionBuilder$Companion;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\"\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u0000 \\2\u00020\u0001:\u0001\\B5\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u00a2\u0006\u0002\u0010\nJ\r\u00102\u001a\u000203H\u0000\u00a2\u0006\u0002\u00084J\u0006\u0010\u0015\u001a\u00020\u0000J\u0016\u00105\u001a\u0002032\u000c\u00106\u001a\u0008\u0012\u0004\u0012\u00020\u000807H\u0002J\u0008\u00108\u001a\u000203H\u0003J\u0010\u00109\u001a\u00020\u00002\u0008\u0010:\u001a\u0004\u0018\u00010\u0018J\u0010\u00109\u001a\u00020\u00002\u0008\u0010:\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010;\u001a\u00020\u00002\u0008\u0010:\u001a\u0004\u0018\u00010\u001dJ\u0008\u0010<\u001a\u000203H\u0002J\u0010\u0010=\u001a\u0002032\u0008\u0010:\u001a\u0004\u0018\u00010,J\u000e\u0010>\u001a\u0002032\u0006\u0010?\u001a\u00020@J\u000e\u0010A\u001a\u0002032\u0006\u0010?\u001a\u00020@J\u000e\u0010B\u001a\u0002032\u0006\u0010?\u001a\u00020@J\u000e\u0010C\u001a\u0002032\u0006\u0010?\u001a\u00020@J\u000e\u0010D\u001a\u0002032\u0006\u0010?\u001a\u00020@J\u001c\u0010E\u001a\u0002032\u000c\u00106\u001a\u0008\u0012\u0004\u0012\u00020\u00080F2\u0006\u0010?\u001a\u00020@J\u000e\u0010G\u001a\u0002032\u0006\u0010?\u001a\u00020@J\u000e\u0010H\u001a\u0002032\u0006\u0010?\u001a\u00020@J\u0008\u0010I\u001a\u000203H\u0002J\u0016\u0010J\u001a\u00020\u00002\u0006\u0010\'\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010K\u001a\u00020\u0016J\u0006\u0010L\u001a\u00020\u0016J\u0006\u0010M\u001a\u00020\u0016J\u0006\u0010N\u001a\u00020\u0016J\u0006\u0010O\u001a\u00020\u0016J\u0006\u0010P\u001a\u00020\u0016J\u0006\u0010Q\u001a\u00020\u0016J\u001e\u0010R\u001a\u0002032\u0006\u0010?\u001a\u00020@2\u0006\u0010S\u001a\u00020\u00162\u0006\u0010T\u001a\u00020UJ\u001e\u0010R\u001a\u0002032\u0006\u0010?\u001a\u00020@2\u0006\u0010S\u001a\u00020\u00162\u0006\u0010V\u001a\u00020WJ>\u0010R\u001a\u0002032\u0006\u0010?\u001a\u00020@2\u0006\u0010S\u001a\u00020\u00162\u000c\u00106\u001a\u0008\u0012\u0004\u0012\u00020\u0008072\u0006\u0010X\u001a\u00020\u00082\u0006\u0010Y\u001a\u00020\u00082\u0008\u0010Z\u001a\u0004\u0018\u00010\u0008J\u0008\u0010[\u001a\u000203H\u0002R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\u0008 \u0010!R\u0018\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020$8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\u0008%\u0010&R\u000e\u0010\'\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010)\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010*\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010.\u001a\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\u0008/\u00100R\u0018\u00101\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006]"
    }
    d2 = {
        "Lcom/permissionx/guolindev/request/PermissionBuilder;",
        "",
        "fragmentActivity",
        "Landroidx/fragment/app/FragmentActivity;",
        "fragment",
        "Landroidx/fragment/app/Fragment;",
        "normalPermissions",
        "",
        "",
        "specialPermissions",
        "(Landroidx/fragment/app/FragmentActivity;Landroidx/fragment/app/Fragment;Ljava/util/Set;Ljava/util/Set;)V",
        "activity",
        "getActivity",
        "()Landroidx/fragment/app/FragmentActivity;",
        "setActivity",
        "(Landroidx/fragment/app/FragmentActivity;)V",
        "currentDialog",
        "Landroid/app/Dialog;",
        "darkColor",
        "",
        "deniedPermissions",
        "explainReasonBeforeRequest",
        "",
        "explainReasonCallback",
        "Lcom/permissionx/guolindev/callback/ExplainReasonCallback;",
        "explainReasonCallbackWithBeforeParam",
        "Lcom/permissionx/guolindev/callback/ExplainReasonCallbackWithBeforeParam;",
        "forwardPermissions",
        "forwardToSettingsCallback",
        "Lcom/permissionx/guolindev/callback/ForwardToSettingsCallback;",
        "fragmentManager",
        "Landroidx/fragment/app/FragmentManager;",
        "getFragmentManager",
        "()Landroidx/fragment/app/FragmentManager;",
        "grantedPermissions",
        "invisibleFragment",
        "Lcom/permissionx/guolindev/request/InvisibleFragment;",
        "getInvisibleFragment",
        "()Lcom/permissionx/guolindev/request/InvisibleFragment;",
        "lightColor",
        "originRequestOrientation",
        "permanentDeniedPermissions",
        "permissionsWontRequest",
        "requestCallback",
        "Lcom/permissionx/guolindev/callback/RequestCallback;",
        "showDialogCalled",
        "targetSdkVersion",
        "getTargetSdkVersion",
        "()I",
        "tempPermanentDeniedPermissions",
        "endRequest",
        "",
        "endRequest$permissionx_release",
        "forwardToSettings",
        "permissions",
        "",
        "lockOrientation",
        "onExplainRequestReason",
        "callback",
        "onForwardToSettings",
        "removeInvisibleFragment",
        "request",
        "requestAccessBackgroundLocationPermissionNow",
        "chainTask",
        "Lcom/permissionx/guolindev/request/ChainTask;",
        "requestBodySensorsBackgroundPermissionNow",
        "requestInstallPackagePermissionNow",
        "requestManageExternalStoragePermissionNow",
        "requestNotificationPermissionNow",
        "requestNow",
        "",
        "requestSystemAlertWindowPermissionNow",
        "requestWriteSettingsPermissionNow",
        "restoreOrientation",
        "setDialogTintColor",
        "shouldRequestBackgroundLocationPermission",
        "shouldRequestBodySensorsBackgroundPermission",
        "shouldRequestInstallPackagesPermission",
        "shouldRequestManageExternalStoragePermission",
        "shouldRequestNotificationPermission",
        "shouldRequestSystemAlertWindowPermission",
        "shouldRequestWriteSettingsPermission",
        "showHandlePermissionDialog",
        "showReasonOrGoSettings",
        "dialog",
        "Lcom/permissionx/guolindev/dialog/RationaleDialog;",
        "dialogFragment",
        "Lcom/permissionx/guolindev/dialog/RationaleDialogFragment;",
        "message",
        "positiveText",
        "negativeText",
        "startRequest",
        "Companion",
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


# static fields
.field public static final Companion:Lcom/permissionx/guolindev/request/PermissionBuilder$Companion;

.field private static final FRAGMENT_TAG:Ljava/lang/String; = "InvisibleFragment"


# instance fields
.field public activity:Landroidx/fragment/app/FragmentActivity;

.field public currentDialog:Landroid/app/Dialog;

.field private darkColor:I

.field public deniedPermissions:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public explainReasonBeforeRequest:Z

.field public explainReasonCallback:Lcom/permissionx/guolindev/callback/ExplainReasonCallback;

.field public explainReasonCallbackWithBeforeParam:Lcom/permissionx/guolindev/callback/ExplainReasonCallbackWithBeforeParam;

.field public forwardPermissions:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public forwardToSettingsCallback:Lcom/permissionx/guolindev/callback/ForwardToSettingsCallback;

.field private fragment:Landroidx/fragment/app/Fragment;

.field public grantedPermissions:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private lightColor:I

.field public normalPermissions:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private originRequestOrientation:I

.field public permanentDeniedPermissions:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public permissionsWontRequest:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public requestCallback:Lcom/permissionx/guolindev/callback/RequestCallback;

.field public showDialogCalled:Z

.field public specialPermissions:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public tempPermanentDeniedPermissions:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public static synthetic $r8$lambda$2fM8AZBC3afP91Vb8dH7uD4M0DI(Lcom/permissionx/guolindev/dialog/RationaleDialog;Lcom/permissionx/guolindev/request/ChainTask;Landroid/view/View;)V
    .registers 3

    invoke-static {p0, p1, p2}, Lcom/permissionx/guolindev/request/PermissionBuilder;->showHandlePermissionDialog$lambda-1(Lcom/permissionx/guolindev/dialog/RationaleDialog;Lcom/permissionx/guolindev/request/ChainTask;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$Lryy70HiIObb0uxPBzOJHCEctvI(Lcom/permissionx/guolindev/dialog/RationaleDialogFragment;ZLcom/permissionx/guolindev/request/ChainTask;Ljava/util/List;Lcom/permissionx/guolindev/request/PermissionBuilder;Landroid/view/View;)V
    .registers 6

    invoke-static/range {p0 .. p5}, Lcom/permissionx/guolindev/request/PermissionBuilder;->showHandlePermissionDialog$lambda-3(Lcom/permissionx/guolindev/dialog/RationaleDialogFragment;ZLcom/permissionx/guolindev/request/ChainTask;Ljava/util/List;Lcom/permissionx/guolindev/request/PermissionBuilder;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$O9Hp_-9YuEjwy3MT2jVR8bjTDnE(Lcom/permissionx/guolindev/dialog/RationaleDialogFragment;Lcom/permissionx/guolindev/request/ChainTask;Landroid/view/View;)V
    .registers 3

    invoke-static {p0, p1, p2}, Lcom/permissionx/guolindev/request/PermissionBuilder;->showHandlePermissionDialog$lambda-4(Lcom/permissionx/guolindev/dialog/RationaleDialogFragment;Lcom/permissionx/guolindev/request/ChainTask;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$h5YLp2A-1FdRklk40ZOxzrjCsqk(Lcom/permissionx/guolindev/request/PermissionBuilder;Landroid/content/DialogInterface;)V
    .registers 2

    invoke-static {p0, p1}, Lcom/permissionx/guolindev/request/PermissionBuilder;->showHandlePermissionDialog$lambda-2(Lcom/permissionx/guolindev/request/PermissionBuilder;Landroid/content/DialogInterface;)V

    return-void
.end method

.method public static synthetic $r8$lambda$uz5q09bKYdOmJDE8SO186N6Iikw(Lcom/permissionx/guolindev/dialog/RationaleDialog;ZLcom/permissionx/guolindev/request/ChainTask;Ljava/util/List;Lcom/permissionx/guolindev/request/PermissionBuilder;Landroid/view/View;)V
    .registers 6

    invoke-static/range {p0 .. p5}, Lcom/permissionx/guolindev/request/PermissionBuilder;->showHandlePermissionDialog$lambda-0(Lcom/permissionx/guolindev/dialog/RationaleDialog;ZLcom/permissionx/guolindev/request/ChainTask;Ljava/util/List;Lcom/permissionx/guolindev/request/PermissionBuilder;Landroid/view/View;)V

    return-void
.end method

.method static constructor <clinit>()V
    .registers 2

    new-instance v0, Lcom/permissionx/guolindev/request/PermissionBuilder$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/permissionx/guolindev/request/PermissionBuilder$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lcom/permissionx/guolindev/request/PermissionBuilder;->Companion:Lcom/permissionx/guolindev/request/PermissionBuilder$Companion;

    return-void
.end method

.method public constructor <init>(Landroidx/fragment/app/FragmentActivity;Landroidx/fragment/app/Fragment;Ljava/util/Set;Ljava/util/Set;)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/fragment/app/FragmentActivity;",
            "Landroidx/fragment/app/Fragment;",
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    const-string v0, "normalPermissions"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "specialPermissions"

    invoke-static {p4, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, -0x1

    iput v0, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->lightColor:I

    iput v0, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->darkColor:I

    iput v0, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->originRequestOrientation:I

    new-instance v0, Ljava/util/LinkedHashSet;

    invoke-direct {v0}, Ljava/util/LinkedHashSet;-><init>()V

    check-cast v0, Ljava/util/Set;

    iput-object v0, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->permissionsWontRequest:Ljava/util/Set;

    new-instance v0, Ljava/util/LinkedHashSet;

    invoke-direct {v0}, Ljava/util/LinkedHashSet;-><init>()V

    check-cast v0, Ljava/util/Set;

    iput-object v0, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->grantedPermissions:Ljava/util/Set;

    new-instance v0, Ljava/util/LinkedHashSet;

    invoke-direct {v0}, Ljava/util/LinkedHashSet;-><init>()V

    check-cast v0, Ljava/util/Set;

    iput-object v0, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->deniedPermissions:Ljava/util/Set;

    new-instance v0, Ljava/util/LinkedHashSet;

    invoke-direct {v0}, Ljava/util/LinkedHashSet;-><init>()V

    check-cast v0, Ljava/util/Set;

    iput-object v0, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->permanentDeniedPermissions:Ljava/util/Set;

    new-instance v0, Ljava/util/LinkedHashSet;

    invoke-direct {v0}, Ljava/util/LinkedHashSet;-><init>()V

    check-cast v0, Ljava/util/Set;

    iput-object v0, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->tempPermanentDeniedPermissions:Ljava/util/Set;

    new-instance v0, Ljava/util/LinkedHashSet;

    invoke-direct {v0}, Ljava/util/LinkedHashSet;-><init>()V

    check-cast v0, Ljava/util/Set;

    iput-object v0, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->forwardPermissions:Ljava/util/Set;

    if-eqz p1, :cond_4f

    invoke-virtual {p0, p1}, Lcom/permissionx/guolindev/request/PermissionBuilder;->setActivity(Landroidx/fragment/app/FragmentActivity;)V

    :cond_4f
    if-nez p1, :cond_5f

    if-eqz p2, :cond_5f

    invoke-virtual {p2}, Landroidx/fragment/app/Fragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object p1

    const-string v0, "fragment.requireActivity()"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p0, p1}, Lcom/permissionx/guolindev/request/PermissionBuilder;->setActivity(Landroidx/fragment/app/FragmentActivity;)V

    :cond_5f
    iput-object p2, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->fragment:Landroidx/fragment/app/Fragment;

    iput-object p3, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->normalPermissions:Ljava/util/Set;

    iput-object p4, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->specialPermissions:Ljava/util/Set;

    return-void
.end method

.method private final forwardToSettings(Ljava/util/List;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->forwardPermissions:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    iget-object v0, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->forwardPermissions:Ljava/util/Set;

    check-cast p1, Ljava/util/Collection;

    invoke-interface {v0, p1}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    invoke-direct {p0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->getInvisibleFragment()Lcom/permissionx/guolindev/request/InvisibleFragment;

    move-result-object p1

    invoke-virtual {p1}, Lcom/permissionx/guolindev/request/InvisibleFragment;->forwardToSettings()V

    return-void
.end method

.method private final getFragmentManager()Landroidx/fragment/app/FragmentManager;
    .registers 3

    iget-object v0, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->fragment:Landroidx/fragment/app/Fragment;

    if-eqz v0, :cond_9

    invoke-virtual {v0}, Landroidx/fragment/app/Fragment;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;

    move-result-object v0

    goto :goto_a

    :cond_9
    const/4 v0, 0x0

    :goto_a
    if-nez v0, :cond_19

    invoke-virtual {p0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/fragment/app/FragmentActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;

    move-result-object v0

    const-string v1, "activity.supportFragmentManager"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    :cond_19
    return-object v0
.end method

.method private final getInvisibleFragment()Lcom/permissionx/guolindev/request/InvisibleFragment;
    .registers 5

    invoke-direct {p0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->getFragmentManager()Landroidx/fragment/app/FragmentManager;

    move-result-object v0

    const-string v1, "InvisibleFragment"

    invoke-virtual {v0, v1}, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_f

    check-cast v0, Lcom/permissionx/guolindev/request/InvisibleFragment;

    goto :goto_26

    :cond_f
    new-instance v0, Lcom/permissionx/guolindev/request/InvisibleFragment;

    invoke-direct {v0}, Lcom/permissionx/guolindev/request/InvisibleFragment;-><init>()V

    invoke-direct {p0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->getFragmentManager()Landroidx/fragment/app/FragmentManager;

    move-result-object v2

    invoke-virtual {v2}, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;

    move-result-object v2

    move-object v3, v0

    check-cast v3, Landroidx/fragment/app/Fragment;

    invoke-virtual {v2, v3, v1}, Landroidx/fragment/app/FragmentTransaction;->add(Landroidx/fragment/app/Fragment;Ljava/lang/String;)Landroidx/fragment/app/FragmentTransaction;

    move-result-object v1

    invoke-virtual {v1}, Landroidx/fragment/app/FragmentTransaction;->commitNowAllowingStateLoss()V

    :goto_26
    return-object v0
.end method

.method private final lockOrientation()V
    .registers 3

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1a

    if-eq v0, v1, :cond_36

    invoke-virtual {p0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/fragment/app/FragmentActivity;->getRequestedOrientation()I

    move-result v0

    iput v0, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->originRequestOrientation:I

    invoke-virtual {p0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/fragment/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    iget v0, v0, Landroid/content/res/Configuration;->orientation:I

    const/4 v1, 0x1

    if-eq v0, v1, :cond_2e

    const/4 v1, 0x2

    if-eq v0, v1, :cond_25

    goto :goto_36

    :cond_25
    invoke-virtual {p0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    const/4 v1, 0x6

    invoke-virtual {v0, v1}, Landroidx/fragment/app/FragmentActivity;->setRequestedOrientation(I)V

    goto :goto_36

    :cond_2e
    invoke-virtual {p0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    const/4 v1, 0x7

    invoke-virtual {v0, v1}, Landroidx/fragment/app/FragmentActivity;->setRequestedOrientation(I)V

    :cond_36
    :goto_36
    return-void
.end method

.method private final removeInvisibleFragment()V
    .registers 3

    invoke-direct {p0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->getFragmentManager()Landroidx/fragment/app/FragmentManager;

    move-result-object v0

    const-string v1, "InvisibleFragment"

    invoke-virtual {v0, v1}, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_1b

    invoke-direct {p0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->getFragmentManager()Landroidx/fragment/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1}, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroidx/fragment/app/FragmentTransaction;->remove(Landroidx/fragment/app/Fragment;)Landroidx/fragment/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/fragment/app/FragmentTransaction;->commitNowAllowingStateLoss()V

    :cond_1b
    return-void
.end method

.method private final restoreOrientation()V
    .registers 3

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1a

    if-eq v0, v1, :cond_f

    invoke-virtual {p0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    iget v1, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->originRequestOrientation:I

    invoke-virtual {v0, v1}, Landroidx/fragment/app/FragmentActivity;->setRequestedOrientation(I)V

    :cond_f
    return-void
.end method

.method private static final showHandlePermissionDialog$lambda-0(Lcom/permissionx/guolindev/dialog/RationaleDialog;ZLcom/permissionx/guolindev/request/ChainTask;Ljava/util/List;Lcom/permissionx/guolindev/request/PermissionBuilder;Landroid/view/View;)V
    .registers 6

    const-string p5, "$dialog"

    invoke-static {p0, p5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p5, "$chainTask"

    invoke-static {p2, p5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p5, "$permissions"

    invoke-static {p3, p5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p5, "this$0"

    invoke-static {p4, p5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/permissionx/guolindev/dialog/RationaleDialog;->dismiss()V

    if-eqz p1, :cond_1d

    invoke-interface {p2, p3}, Lcom/permissionx/guolindev/request/ChainTask;->requestAgain(Ljava/util/List;)V

    goto :goto_20

    :cond_1d
    invoke-direct {p4, p3}, Lcom/permissionx/guolindev/request/PermissionBuilder;->forwardToSettings(Ljava/util/List;)V

    :goto_20
    return-void
.end method

.method private static final showHandlePermissionDialog$lambda-1(Lcom/permissionx/guolindev/dialog/RationaleDialog;Lcom/permissionx/guolindev/request/ChainTask;Landroid/view/View;)V
    .registers 3

    const-string p2, "$dialog"

    invoke-static {p0, p2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p2, "$chainTask"

    invoke-static {p1, p2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/permissionx/guolindev/dialog/RationaleDialog;->dismiss()V

    invoke-interface {p1}, Lcom/permissionx/guolindev/request/ChainTask;->finish()V

    return-void
.end method

.method private static final showHandlePermissionDialog$lambda-2(Lcom/permissionx/guolindev/request/PermissionBuilder;Landroid/content/DialogInterface;)V
    .registers 2

    const-string p1, "this$0"

    invoke-static {p0, p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 p1, 0x0

    iput-object p1, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->currentDialog:Landroid/app/Dialog;

    return-void
.end method

.method private static final showHandlePermissionDialog$lambda-3(Lcom/permissionx/guolindev/dialog/RationaleDialogFragment;ZLcom/permissionx/guolindev/request/ChainTask;Ljava/util/List;Lcom/permissionx/guolindev/request/PermissionBuilder;Landroid/view/View;)V
    .registers 6

    const-string p5, "$dialogFragment"

    invoke-static {p0, p5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p5, "$chainTask"

    invoke-static {p2, p5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p5, "$permissions"

    invoke-static {p3, p5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p5, "this$0"

    invoke-static {p4, p5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/permissionx/guolindev/dialog/RationaleDialogFragment;->dismiss()V

    if-eqz p1, :cond_1d

    invoke-interface {p2, p3}, Lcom/permissionx/guolindev/request/ChainTask;->requestAgain(Ljava/util/List;)V

    goto :goto_20

    :cond_1d
    invoke-direct {p4, p3}, Lcom/permissionx/guolindev/request/PermissionBuilder;->forwardToSettings(Ljava/util/List;)V

    :goto_20
    return-void
.end method

.method private static final showHandlePermissionDialog$lambda-4(Lcom/permissionx/guolindev/dialog/RationaleDialogFragment;Lcom/permissionx/guolindev/request/ChainTask;Landroid/view/View;)V
    .registers 3

    const-string p2, "$dialogFragment"

    invoke-static {p0, p2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p2, "$chainTask"

    invoke-static {p1, p2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/permissionx/guolindev/dialog/RationaleDialogFragment;->dismiss()V

    invoke-interface {p1}, Lcom/permissionx/guolindev/request/ChainTask;->finish()V

    return-void
.end method

.method private final startRequest()V
    .registers 3

    invoke-direct {p0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->lockOrientation()V

    new-instance v0, Lcom/permissionx/guolindev/request/RequestChain;

    invoke-direct {v0}, Lcom/permissionx/guolindev/request/RequestChain;-><init>()V

    new-instance v1, Lcom/permissionx/guolindev/request/RequestNormalPermissions;

    invoke-direct {v1, p0}, Lcom/permissionx/guolindev/request/RequestNormalPermissions;-><init>(Lcom/permissionx/guolindev/request/PermissionBuilder;)V

    check-cast v1, Lcom/permissionx/guolindev/request/BaseTask;

    invoke-virtual {v0, v1}, Lcom/permissionx/guolindev/request/RequestChain;->addTaskToChain$permissionx_release(Lcom/permissionx/guolindev/request/BaseTask;)V

    new-instance v1, Lcom/permissionx/guolindev/request/RequestBackgroundLocationPermission;

    invoke-direct {v1, p0}, Lcom/permissionx/guolindev/request/RequestBackgroundLocationPermission;-><init>(Lcom/permissionx/guolindev/request/PermissionBuilder;)V

    check-cast v1, Lcom/permissionx/guolindev/request/BaseTask;

    invoke-virtual {v0, v1}, Lcom/permissionx/guolindev/request/RequestChain;->addTaskToChain$permissionx_release(Lcom/permissionx/guolindev/request/BaseTask;)V

    new-instance v1, Lcom/permissionx/guolindev/request/RequestSystemAlertWindowPermission;

    invoke-direct {v1, p0}, Lcom/permissionx/guolindev/request/RequestSystemAlertWindowPermission;-><init>(Lcom/permissionx/guolindev/request/PermissionBuilder;)V

    check-cast v1, Lcom/permissionx/guolindev/request/BaseTask;

    invoke-virtual {v0, v1}, Lcom/permissionx/guolindev/request/RequestChain;->addTaskToChain$permissionx_release(Lcom/permissionx/guolindev/request/BaseTask;)V

    new-instance v1, Lcom/permissionx/guolindev/request/RequestWriteSettingsPermission;

    invoke-direct {v1, p0}, Lcom/permissionx/guolindev/request/RequestWriteSettingsPermission;-><init>(Lcom/permissionx/guolindev/request/PermissionBuilder;)V

    check-cast v1, Lcom/permissionx/guolindev/request/BaseTask;

    invoke-virtual {v0, v1}, Lcom/permissionx/guolindev/request/RequestChain;->addTaskToChain$permissionx_release(Lcom/permissionx/guolindev/request/BaseTask;)V

    new-instance v1, Lcom/permissionx/guolindev/request/RequestManageExternalStoragePermission;

    invoke-direct {v1, p0}, Lcom/permissionx/guolindev/request/RequestManageExternalStoragePermission;-><init>(Lcom/permissionx/guolindev/request/PermissionBuilder;)V

    check-cast v1, Lcom/permissionx/guolindev/request/BaseTask;

    invoke-virtual {v0, v1}, Lcom/permissionx/guolindev/request/RequestChain;->addTaskToChain$permissionx_release(Lcom/permissionx/guolindev/request/BaseTask;)V

    new-instance v1, Lcom/permissionx/guolindev/request/RequestInstallPackagesPermission;

    invoke-direct {v1, p0}, Lcom/permissionx/guolindev/request/RequestInstallPackagesPermission;-><init>(Lcom/permissionx/guolindev/request/PermissionBuilder;)V

    check-cast v1, Lcom/permissionx/guolindev/request/BaseTask;

    invoke-virtual {v0, v1}, Lcom/permissionx/guolindev/request/RequestChain;->addTaskToChain$permissionx_release(Lcom/permissionx/guolindev/request/BaseTask;)V

    new-instance v1, Lcom/permissionx/guolindev/request/RequestNotificationPermission;

    invoke-direct {v1, p0}, Lcom/permissionx/guolindev/request/RequestNotificationPermission;-><init>(Lcom/permissionx/guolindev/request/PermissionBuilder;)V

    check-cast v1, Lcom/permissionx/guolindev/request/BaseTask;

    invoke-virtual {v0, v1}, Lcom/permissionx/guolindev/request/RequestChain;->addTaskToChain$permissionx_release(Lcom/permissionx/guolindev/request/BaseTask;)V

    new-instance v1, Lcom/permissionx/guolindev/request/RequestBodySensorsBackgroundPermission;

    invoke-direct {v1, p0}, Lcom/permissionx/guolindev/request/RequestBodySensorsBackgroundPermission;-><init>(Lcom/permissionx/guolindev/request/PermissionBuilder;)V

    check-cast v1, Lcom/permissionx/guolindev/request/BaseTask;

    invoke-virtual {v0, v1}, Lcom/permissionx/guolindev/request/RequestChain;->addTaskToChain$permissionx_release(Lcom/permissionx/guolindev/request/BaseTask;)V

    invoke-virtual {v0}, Lcom/permissionx/guolindev/request/RequestChain;->runTask$permissionx_release()V

    return-void
.end method


# virtual methods
.method public final endRequest$permissionx_release()V
    .registers 1

    invoke-direct {p0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->removeInvisibleFragment()V

    invoke-direct {p0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->restoreOrientation()V

    return-void
.end method

.method public final explainReasonBeforeRequest()Lcom/permissionx/guolindev/request/PermissionBuilder;
    .registers 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->explainReasonBeforeRequest:Z

    return-object p0
.end method

.method public final getActivity()Landroidx/fragment/app/FragmentActivity;
    .registers 2

    iget-object v0, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->activity:Landroidx/fragment/app/FragmentActivity;

    if-eqz v0, :cond_5

    return-object v0

    :cond_5
    const-string v0, "activity"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 v0, 0x0

    return-object v0
.end method

.method public final getTargetSdkVersion()I
    .registers 2

    invoke-virtual {p0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/fragment/app/FragmentActivity;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v0

    iget v0, v0, Landroid/content/pm/ApplicationInfo;->targetSdkVersion:I

    return v0
.end method

.method public final onExplainRequestReason(Lcom/permissionx/guolindev/callback/ExplainReasonCallback;)Lcom/permissionx/guolindev/request/PermissionBuilder;
    .registers 2

    iput-object p1, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->explainReasonCallback:Lcom/permissionx/guolindev/callback/ExplainReasonCallback;

    return-object p0
.end method

.method public final onExplainRequestReason(Lcom/permissionx/guolindev/callback/ExplainReasonCallbackWithBeforeParam;)Lcom/permissionx/guolindev/request/PermissionBuilder;
    .registers 2

    iput-object p1, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->explainReasonCallbackWithBeforeParam:Lcom/permissionx/guolindev/callback/ExplainReasonCallbackWithBeforeParam;

    return-object p0
.end method

.method public final onForwardToSettings(Lcom/permissionx/guolindev/callback/ForwardToSettingsCallback;)Lcom/permissionx/guolindev/request/PermissionBuilder;
    .registers 2

    iput-object p1, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->forwardToSettingsCallback:Lcom/permissionx/guolindev/callback/ForwardToSettingsCallback;

    return-object p0
.end method

.method public final request(Lcom/permissionx/guolindev/callback/RequestCallback;)V
    .registers 2

    iput-object p1, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->requestCallback:Lcom/permissionx/guolindev/callback/RequestCallback;

    invoke-direct {p0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->startRequest()V

    return-void
.end method

.method public final requestAccessBackgroundLocationPermissionNow(Lcom/permissionx/guolindev/request/ChainTask;)V
    .registers 3

    const-string v0, "chainTask"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->getInvisibleFragment()Lcom/permissionx/guolindev/request/InvisibleFragment;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Lcom/permissionx/guolindev/request/InvisibleFragment;->requestAccessBackgroundLocationPermissionNow(Lcom/permissionx/guolindev/request/PermissionBuilder;Lcom/permissionx/guolindev/request/ChainTask;)V

    return-void
.end method

.method public final requestBodySensorsBackgroundPermissionNow(Lcom/permissionx/guolindev/request/ChainTask;)V
    .registers 3

    const-string v0, "chainTask"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->getInvisibleFragment()Lcom/permissionx/guolindev/request/InvisibleFragment;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Lcom/permissionx/guolindev/request/InvisibleFragment;->requestBodySensorsBackgroundPermissionNow(Lcom/permissionx/guolindev/request/PermissionBuilder;Lcom/permissionx/guolindev/request/ChainTask;)V

    return-void
.end method

.method public final requestInstallPackagePermissionNow(Lcom/permissionx/guolindev/request/ChainTask;)V
    .registers 3

    const-string v0, "chainTask"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->getInvisibleFragment()Lcom/permissionx/guolindev/request/InvisibleFragment;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Lcom/permissionx/guolindev/request/InvisibleFragment;->requestInstallPackagesPermissionNow(Lcom/permissionx/guolindev/request/PermissionBuilder;Lcom/permissionx/guolindev/request/ChainTask;)V

    return-void
.end method

.method public final requestManageExternalStoragePermissionNow(Lcom/permissionx/guolindev/request/ChainTask;)V
    .registers 3

    const-string v0, "chainTask"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->getInvisibleFragment()Lcom/permissionx/guolindev/request/InvisibleFragment;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Lcom/permissionx/guolindev/request/InvisibleFragment;->requestManageExternalStoragePermissionNow(Lcom/permissionx/guolindev/request/PermissionBuilder;Lcom/permissionx/guolindev/request/ChainTask;)V

    return-void
.end method

.method public final requestNotificationPermissionNow(Lcom/permissionx/guolindev/request/ChainTask;)V
    .registers 3

    const-string v0, "chainTask"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->getInvisibleFragment()Lcom/permissionx/guolindev/request/InvisibleFragment;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Lcom/permissionx/guolindev/request/InvisibleFragment;->requestNotificationPermissionNow(Lcom/permissionx/guolindev/request/PermissionBuilder;Lcom/permissionx/guolindev/request/ChainTask;)V

    return-void
.end method

.method public final requestNow(Ljava/util/Set;Lcom/permissionx/guolindev/request/ChainTask;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/permissionx/guolindev/request/ChainTask;",
            ")V"
        }
    .end annotation

    const-string v0, "permissions"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "chainTask"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->getInvisibleFragment()Lcom/permissionx/guolindev/request/InvisibleFragment;

    move-result-object v0

    invoke-virtual {v0, p0, p1, p2}, Lcom/permissionx/guolindev/request/InvisibleFragment;->requestNow(Lcom/permissionx/guolindev/request/PermissionBuilder;Ljava/util/Set;Lcom/permissionx/guolindev/request/ChainTask;)V

    return-void
.end method

.method public final requestSystemAlertWindowPermissionNow(Lcom/permissionx/guolindev/request/ChainTask;)V
    .registers 3

    const-string v0, "chainTask"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->getInvisibleFragment()Lcom/permissionx/guolindev/request/InvisibleFragment;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Lcom/permissionx/guolindev/request/InvisibleFragment;->requestSystemAlertWindowPermissionNow(Lcom/permissionx/guolindev/request/PermissionBuilder;Lcom/permissionx/guolindev/request/ChainTask;)V

    return-void
.end method

.method public final requestWriteSettingsPermissionNow(Lcom/permissionx/guolindev/request/ChainTask;)V
    .registers 3

    const-string v0, "chainTask"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->getInvisibleFragment()Lcom/permissionx/guolindev/request/InvisibleFragment;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Lcom/permissionx/guolindev/request/InvisibleFragment;->requestWriteSettingsPermissionNow(Lcom/permissionx/guolindev/request/PermissionBuilder;Lcom/permissionx/guolindev/request/ChainTask;)V

    return-void
.end method

.method public final setActivity(Landroidx/fragment/app/FragmentActivity;)V
    .registers 3

    const-string v0, "<set-?>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object p1, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->activity:Landroidx/fragment/app/FragmentActivity;

    return-void
.end method

.method public final setDialogTintColor(II)Lcom/permissionx/guolindev/request/PermissionBuilder;
    .registers 3

    iput p1, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->lightColor:I

    iput p2, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->darkColor:I

    return-object p0
.end method

.method public final shouldRequestBackgroundLocationPermission()Z
    .registers 3

    iget-object v0, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->specialPermissions:Ljava/util/Set;

    const-string v1, "android.permission.ACCESS_BACKGROUND_LOCATION"

    invoke-interface {v0, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public final shouldRequestBodySensorsBackgroundPermission()Z
    .registers 3

    iget-object v0, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->specialPermissions:Ljava/util/Set;

    const-string v1, "android.permission.BODY_SENSORS_BACKGROUND"

    invoke-interface {v0, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public final shouldRequestInstallPackagesPermission()Z
    .registers 3

    iget-object v0, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->specialPermissions:Ljava/util/Set;

    const-string v1, "android.permission.REQUEST_INSTALL_PACKAGES"

    invoke-interface {v0, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public final shouldRequestManageExternalStoragePermission()Z
    .registers 3

    iget-object v0, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->specialPermissions:Ljava/util/Set;

    const-string v1, "android.permission.MANAGE_EXTERNAL_STORAGE"

    invoke-interface {v0, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public final shouldRequestNotificationPermission()Z
    .registers 3

    iget-object v0, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->specialPermissions:Ljava/util/Set;

    const-string v1, "android.permission.POST_NOTIFICATIONS"

    invoke-interface {v0, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public final shouldRequestSystemAlertWindowPermission()Z
    .registers 3

    iget-object v0, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->specialPermissions:Ljava/util/Set;

    const-string v1, "android.permission.SYSTEM_ALERT_WINDOW"

    invoke-interface {v0, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public final shouldRequestWriteSettingsPermission()Z
    .registers 3

    iget-object v0, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->specialPermissions:Ljava/util/Set;

    const-string v1, "android.permission.WRITE_SETTINGS"

    invoke-interface {v0, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public final showHandlePermissionDialog(Lcom/permissionx/guolindev/request/ChainTask;ZLcom/permissionx/guolindev/dialog/RationaleDialog;)V
    .registers 14

    const-string v0, "chainTask"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "dialog"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->showDialogCalled:Z

    invoke-virtual {p3}, Lcom/permissionx/guolindev/dialog/RationaleDialog;->getPermissionsToRequest()Ljava/util/List;

    move-result-object v5

    const-string v1, "dialog.permissionsToRequest"

    invoke-static {v5, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-interface {v5}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_20

    invoke-interface {p1}, Lcom/permissionx/guolindev/request/ChainTask;->finish()V

    return-void

    :cond_20
    move-object v1, p3

    check-cast v1, Landroid/app/Dialog;

    iput-object v1, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->currentDialog:Landroid/app/Dialog;

    invoke-virtual {p3}, Lcom/permissionx/guolindev/dialog/RationaleDialog;->show()V

    instance-of v1, p3, Lcom/permissionx/guolindev/dialog/DefaultDialog;

    if-eqz v1, :cond_3b

    move-object v1, p3

    check-cast v1, Lcom/permissionx/guolindev/dialog/DefaultDialog;

    invoke-virtual {v1}, Lcom/permissionx/guolindev/dialog/DefaultDialog;->isPermissionLayoutEmpty$permissionx_release()Z

    move-result v1

    if-eqz v1, :cond_3b

    invoke-virtual {p3}, Lcom/permissionx/guolindev/dialog/RationaleDialog;->dismiss()V

    invoke-interface {p1}, Lcom/permissionx/guolindev/request/ChainTask;->finish()V

    :cond_3b
    invoke-virtual {p3}, Lcom/permissionx/guolindev/dialog/RationaleDialog;->getPositiveButton()Landroid/view/View;

    move-result-object v7

    const-string v1, "dialog.positiveButton"

    invoke-static {v7, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p3}, Lcom/permissionx/guolindev/dialog/RationaleDialog;->getNegativeButton()Landroid/view/View;

    move-result-object v8

    const/4 v1, 0x0

    invoke-virtual {p3, v1}, Lcom/permissionx/guolindev/dialog/RationaleDialog;->setCancelable(Z)V

    invoke-virtual {p3, v1}, Lcom/permissionx/guolindev/dialog/RationaleDialog;->setCanceledOnTouchOutside(Z)V

    invoke-virtual {v7, v0}, Landroid/view/View;->setClickable(Z)V

    new-instance v9, Lcom/permissionx/guolindev/request/PermissionBuilder$$ExternalSyntheticLambda2;

    move-object v1, v9

    move-object v2, p3

    move v3, p2

    move-object v4, p1

    move-object v6, p0

    invoke-direct/range {v1 .. v6}, Lcom/permissionx/guolindev/request/PermissionBuilder$$ExternalSyntheticLambda2;-><init>(Lcom/permissionx/guolindev/dialog/RationaleDialog;ZLcom/permissionx/guolindev/request/ChainTask;Ljava/util/List;Lcom/permissionx/guolindev/request/PermissionBuilder;)V

    invoke-virtual {v7, v9}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    if-eqz v8, :cond_6c

    invoke-virtual {v8, v0}, Landroid/view/View;->setClickable(Z)V

    new-instance p2, Lcom/permissionx/guolindev/request/PermissionBuilder$$ExternalSyntheticLambda3;

    invoke-direct {p2, p3, p1}, Lcom/permissionx/guolindev/request/PermissionBuilder$$ExternalSyntheticLambda3;-><init>(Lcom/permissionx/guolindev/dialog/RationaleDialog;Lcom/permissionx/guolindev/request/ChainTask;)V

    invoke-virtual {v8, p2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    :cond_6c
    iget-object p1, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->currentDialog:Landroid/app/Dialog;

    if-eqz p1, :cond_78

    new-instance p2, Lcom/permissionx/guolindev/request/PermissionBuilder$$ExternalSyntheticLambda4;

    invoke-direct {p2, p0}, Lcom/permissionx/guolindev/request/PermissionBuilder$$ExternalSyntheticLambda4;-><init>(Lcom/permissionx/guolindev/request/PermissionBuilder;)V

    invoke-virtual {p1, p2}, Landroid/app/Dialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    :cond_78
    return-void
.end method

.method public final showHandlePermissionDialog(Lcom/permissionx/guolindev/request/ChainTask;ZLcom/permissionx/guolindev/dialog/RationaleDialogFragment;)V
    .registers 14

    const-string v0, "chainTask"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "dialogFragment"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->showDialogCalled:Z

    invoke-virtual {p3}, Lcom/permissionx/guolindev/dialog/RationaleDialogFragment;->getPermissionsToRequest()Ljava/util/List;

    move-result-object v5

    const-string v1, "dialogFragment.permissionsToRequest"

    invoke-static {v5, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-interface {v5}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_20

    invoke-interface {p1}, Lcom/permissionx/guolindev/request/ChainTask;->finish()V

    return-void

    :cond_20
    invoke-direct {p0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->getFragmentManager()Landroidx/fragment/app/FragmentManager;

    move-result-object v1

    const-string v2, "PermissionXRationaleDialogFragment"

    invoke-virtual {p3, v1, v2}, Lcom/permissionx/guolindev/dialog/RationaleDialogFragment;->showNow(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V

    invoke-virtual {p3}, Lcom/permissionx/guolindev/dialog/RationaleDialogFragment;->getPositiveButton()Landroid/view/View;

    move-result-object v7

    const-string v1, "dialogFragment.positiveButton"

    invoke-static {v7, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p3}, Lcom/permissionx/guolindev/dialog/RationaleDialogFragment;->getNegativeButton()Landroid/view/View;

    move-result-object v8

    const/4 v1, 0x0

    invoke-virtual {p3, v1}, Lcom/permissionx/guolindev/dialog/RationaleDialogFragment;->setCancelable(Z)V

    invoke-virtual {v7, v0}, Landroid/view/View;->setClickable(Z)V

    new-instance v9, Lcom/permissionx/guolindev/request/PermissionBuilder$$ExternalSyntheticLambda0;

    move-object v1, v9

    move-object v2, p3

    move v3, p2

    move-object v4, p1

    move-object v6, p0

    invoke-direct/range {v1 .. v6}, Lcom/permissionx/guolindev/request/PermissionBuilder$$ExternalSyntheticLambda0;-><init>(Lcom/permissionx/guolindev/dialog/RationaleDialogFragment;ZLcom/permissionx/guolindev/request/ChainTask;Ljava/util/List;Lcom/permissionx/guolindev/request/PermissionBuilder;)V

    invoke-virtual {v7, v9}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    if-eqz v8, :cond_57

    invoke-virtual {v8, v0}, Landroid/view/View;->setClickable(Z)V

    new-instance p2, Lcom/permissionx/guolindev/request/PermissionBuilder$$ExternalSyntheticLambda1;

    invoke-direct {p2, p3, p1}, Lcom/permissionx/guolindev/request/PermissionBuilder$$ExternalSyntheticLambda1;-><init>(Lcom/permissionx/guolindev/dialog/RationaleDialogFragment;Lcom/permissionx/guolindev/request/ChainTask;)V

    invoke-virtual {v8, p2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    :cond_57
    return-void
.end method

.method public final showHandlePermissionDialog(Lcom/permissionx/guolindev/request/ChainTask;ZLjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .registers 16
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/permissionx/guolindev/request/ChainTask;",
            "Z",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    const-string v0, "chainTask"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "permissions"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "message"

    invoke-static {p4, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "positiveText"

    invoke-static {p5, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    new-instance v0, Lcom/permissionx/guolindev/dialog/DefaultDialog;

    invoke-virtual {p0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v1

    move-object v2, v1

    check-cast v2, Landroid/content/Context;

    iget v7, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->lightColor:I

    iget v8, p0, Lcom/permissionx/guolindev/request/PermissionBuilder;->darkColor:I

    move-object v1, v0

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    move-object v6, p6

    invoke-direct/range {v1 .. v8}, Lcom/permissionx/guolindev/dialog/DefaultDialog;-><init>(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V

    check-cast v0, Lcom/permissionx/guolindev/dialog/RationaleDialog;

    invoke-virtual {p0, p1, p2, v0}, Lcom/permissionx/guolindev/request/PermissionBuilder;->showHandlePermissionDialog(Lcom/permissionx/guolindev/request/ChainTask;ZLcom/permissionx/guolindev/dialog/RationaleDialog;)V

    return-void
.end method
