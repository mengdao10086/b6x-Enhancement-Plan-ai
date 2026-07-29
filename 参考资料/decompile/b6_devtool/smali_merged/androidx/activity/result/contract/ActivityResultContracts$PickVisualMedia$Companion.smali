.class public final Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$Companion;
.super Ljava/lang/Object;
.source "ActivityResultContracts.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Companion"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u00a2\u0006\u0002\u0008\u0007J\u0008\u0010\u0008\u001a\u00020\tH\u0007\u00a8\u0006\n"
    }
    d2 = {
        "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$Companion;",
        "",
        "()V",
        "getVisualMimeType",
        "",
        "input",
        "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;",
        "getVisualMimeType$activity_release",
        "isPhotoPickerAvailable",
        "",
        "activity_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x7,
        0x1
    }
    xi = 0x30
.end annotation


# direct methods
.method private constructor <init>()V
    .registers 1

    .line 619
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    .registers 2

    invoke-direct {p0}, Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$Companion;-><init>()V

    return-void
.end method


# virtual methods
.method public final getVisualMimeType$activity_release(Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;)Ljava/lang/String;
    .registers 3

    const-string v0, "input"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 640
    instance-of v0, p1, Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$ImageOnly;

    if-eqz v0, :cond_c

    const-string p1, "image/*"

    goto :goto_23

    .line 641
    :cond_c
    instance-of v0, p1, Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VideoOnly;

    if-eqz v0, :cond_13

    const-string p1, "video/*"

    goto :goto_23

    .line 642
    :cond_13
    instance-of v0, p1, Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$SingleMimeType;

    if-eqz v0, :cond_1e

    check-cast p1, Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$SingleMimeType;

    invoke-virtual {p1}, Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$SingleMimeType;->getMimeType()Ljava/lang/String;

    move-result-object p1

    goto :goto_23

    .line 643
    :cond_1e
    instance-of p1, p1, Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$ImageAndVideo;

    if-eqz p1, :cond_24

    const/4 p1, 0x0

    :goto_23
    return-object p1

    :cond_24
    new-instance p1, Lkotlin/NoWhenBranchMatchedException;

    invoke-direct {p1}, Lkotlin/NoWhenBranchMatchedException;-><init>()V

    throw p1
.end method

.method public final isPhotoPickerAvailable()Z
    .registers 5
    .annotation runtime Lkotlin/jvm/JvmStatic;
    .end annotation

    .line 627
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x21

    const/4 v2, 0x1

    if-lt v0, v1, :cond_8

    goto :goto_18

    .line 629
    :cond_8
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/4 v1, 0x0

    const/16 v3, 0x1e

    if-lt v0, v3, :cond_17

    .line 632
    invoke-static {v3}, Landroid/os/ext/SdkExtensions;->getExtensionVersion(I)I

    move-result v0

    const/4 v3, 0x2

    if-lt v0, v3, :cond_17

    goto :goto_18

    :cond_17
    move v2, v1

    :goto_18
    return v2
.end method
