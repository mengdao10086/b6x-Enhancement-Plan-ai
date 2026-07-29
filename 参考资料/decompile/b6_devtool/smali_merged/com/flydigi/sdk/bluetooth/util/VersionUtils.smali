.class public final Lcom/flydigi/sdk/bluetooth/util/VersionUtils;
.super Ljava/lang/Object;
.source "VersionUtils.kt"


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nVersionUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VersionUtils.kt\ncom/flydigi/sdk/bluetooth/util/VersionUtils\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,59:1\n37#2,2:60\n37#2,2:62\n37#2,2:64\n37#2,2:66\n*S KotlinDebug\n*F\n+ 1 VersionUtils.kt\ncom/flydigi/sdk/bluetooth/util/VersionUtils\n*L\n13#1:60,2\n14#1:62,2\n40#1:64,2\n41#1:66,2\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0018\u0010\u0008\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\t"
    }
    d2 = {
        "Lcom/flydigi/sdk/bluetooth/util/VersionUtils;",
        "",
        "()V",
        "isVersionNew",
        "",
        "oldV",
        "",
        "newV",
        "isVersionNewOrEquals",
        "bluetooth_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x8,
        0x0
    }
    xi = 0x30
.end annotation


# static fields
.field public static final INSTANCE:Lcom/flydigi/sdk/bluetooth/util/VersionUtils;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lcom/flydigi/sdk/bluetooth/util/VersionUtils;

    invoke-direct {v0}, Lcom/flydigi/sdk/bluetooth/util/VersionUtils;-><init>()V

    sput-object v0, Lcom/flydigi/sdk/bluetooth/util/VersionUtils;->INSTANCE:Lcom/flydigi/sdk/bluetooth/util/VersionUtils;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static final isVersionNew(Ljava/lang/String;Ljava/lang/String;)Z
    .registers 8
    .annotation runtime Lkotlin/jvm/JvmStatic;
    .end annotation

    const-string v0, "\\."

    const-string v1, "oldV"

    invoke-static {p0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v1, "newV"

    invoke-static {p1, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v1, 0x1

    .line 13
    :try_start_d
    check-cast p0, Ljava/lang/CharSequence;

    new-instance v2, Lkotlin/text/Regex;

    invoke-direct {v2, v0}, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V

    const/4 v3, 0x0

    invoke-virtual {v2, p0, v3}, Lkotlin/text/Regex;->split(Ljava/lang/CharSequence;I)Ljava/util/List;

    move-result-object p0

    check-cast p0, Ljava/util/Collection;

    new-array v2, v3, [Ljava/lang/String;

    .line 61
    invoke-interface {p0, v2}, Ljava/util/Collection;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object p0

    .line 13
    check-cast p0, [Ljava/lang/String;

    .line 14
    check-cast p1, Ljava/lang/CharSequence;

    new-instance v2, Lkotlin/text/Regex;

    invoke-direct {v2, v0}, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1, v3}, Lkotlin/text/Regex;->split(Ljava/lang/CharSequence;I)Ljava/util/List;

    move-result-object p1

    check-cast p1, Ljava/util/Collection;

    new-array v0, v3, [Ljava/lang/String;

    .line 63
    invoke-interface {p1, v0}, Ljava/util/Collection;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object p1

    .line 14
    check-cast p1, [Ljava/lang/String;

    .line 15
    array-length v0, p1

    array-length v2, p0

    if-le v0, v2, :cond_3d

    return v1

    .line 17
    :cond_3d
    array-length v0, p1

    array-length v2, p0

    if-ne v0, v2, :cond_5a

    .line 18
    array-length v0, p1

    move v2, v3

    :goto_43
    if-ge v2, v0, :cond_5a

    .line 19
    aget-object v4, p0, v2

    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v4

    .line 20
    aget-object v5, p1, v2

    invoke-static {v5}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v5
    :try_end_51
    .catch Ljava/lang/Exception; {:try_start_d .. :try_end_51} :catch_5b

    if-le v5, v4, :cond_54

    return v1

    :cond_54
    if-ge v5, v4, :cond_57

    return v3

    :cond_57
    add-int/lit8 v2, v2, 0x1

    goto :goto_43

    :cond_5a
    return v3

    :catch_5b
    return v1
.end method

.method public static final isVersionNewOrEquals(Ljava/lang/String;Ljava/lang/String;)Z
    .registers 8
    .annotation runtime Lkotlin/jvm/JvmStatic;
    .end annotation

    const-string v0, "oldV"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "newV"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 37
    invoke-static {p0, p1}, Landroidx/core/util/ObjectsCompat;->equals(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    const/4 v1, 0x1

    if-eqz v0, :cond_12

    return v1

    .line 40
    :cond_12
    check-cast p0, Ljava/lang/CharSequence;

    new-instance v0, Lkotlin/text/Regex;

    const-string v2, "\\."

    invoke-direct {v0, v2}, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V

    const/4 v3, 0x0

    invoke-virtual {v0, p0, v3}, Lkotlin/text/Regex;->split(Ljava/lang/CharSequence;I)Ljava/util/List;

    move-result-object p0

    check-cast p0, Ljava/util/Collection;

    new-array v0, v3, [Ljava/lang/String;

    .line 65
    invoke-interface {p0, v0}, Ljava/util/Collection;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object p0

    .line 40
    check-cast p0, [Ljava/lang/String;

    .line 41
    check-cast p1, Ljava/lang/CharSequence;

    new-instance v0, Lkotlin/text/Regex;

    invoke-direct {v0, v2}, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1, v3}, Lkotlin/text/Regex;->split(Ljava/lang/CharSequence;I)Ljava/util/List;

    move-result-object p1

    check-cast p1, Ljava/util/Collection;

    new-array v0, v3, [Ljava/lang/String;

    .line 67
    invoke-interface {p1, v0}, Ljava/util/Collection;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object p1

    .line 41
    check-cast p1, [Ljava/lang/String;

    .line 42
    array-length v0, p1

    array-length v2, p0

    if-le v0, v2, :cond_44

    return v1

    .line 44
    :cond_44
    array-length v0, p1

    array-length v2, p0

    if-ne v0, v2, :cond_61

    .line 45
    array-length v0, p1

    move v2, v3

    :goto_4a
    if-ge v2, v0, :cond_61

    .line 46
    aget-object v4, p0, v2

    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v4

    .line 47
    aget-object v5, p1, v2

    invoke-static {v5}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v5

    if-le v5, v4, :cond_5b

    return v1

    :cond_5b
    if-ge v5, v4, :cond_5e

    return v3

    :cond_5e
    add-int/lit8 v2, v2, 0x1

    goto :goto_4a

    :cond_61
    return v3
.end method
