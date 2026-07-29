.class public final Lcom/blankj/utilcode/util/RomUtils;
.super Ljava/lang/Object;
.source "RomUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/blankj/utilcode/util/RomUtils$RomInfo;
    }
.end annotation


# static fields
.field private static final ROM_360:[Ljava/lang/String;

.field private static final ROM_COOLPAD:[Ljava/lang/String;

.field private static final ROM_GIONEE:[Ljava/lang/String;

.field private static final ROM_GOOGLE:[Ljava/lang/String;

.field private static final ROM_HTC:[Ljava/lang/String;

.field private static final ROM_HUAWEI:[Ljava/lang/String;

.field private static final ROM_LEECO:[Ljava/lang/String;

.field private static final ROM_LENOVO:[Ljava/lang/String;

.field private static final ROM_LG:[Ljava/lang/String;

.field private static final ROM_MEIZU:[Ljava/lang/String;

.field private static final ROM_MOTOROLA:[Ljava/lang/String;

.field private static final ROM_NUBIA:[Ljava/lang/String;

.field private static final ROM_ONEPLUS:[Ljava/lang/String;

.field private static final ROM_OPPO:[Ljava/lang/String;

.field private static final ROM_SAMSUNG:[Ljava/lang/String;

.field private static final ROM_SMARTISAN:[Ljava/lang/String;

.field private static final ROM_SONY:[Ljava/lang/String;

.field private static final ROM_VIVO:[Ljava/lang/String;

.field private static final ROM_XIAOMI:[Ljava/lang/String;

.field private static final ROM_ZTE:[Ljava/lang/String;

.field private static final UNKNOWN:Ljava/lang/String; = "unknown"

.field private static final VERSION_PROPERTY_360:Ljava/lang/String; = "ro.build.uiversion"

.field private static final VERSION_PROPERTY_HUAWEI:Ljava/lang/String; = "ro.build.version.emui"

.field private static final VERSION_PROPERTY_LEECO:Ljava/lang/String; = "ro.letv.release.version"

.field private static final VERSION_PROPERTY_NUBIA:Ljava/lang/String; = "ro.build.rom.id"

.field private static final VERSION_PROPERTY_ONEPLUS:Ljava/lang/String; = "ro.rom.version"

.field private static final VERSION_PROPERTY_OPPO:Ljava/lang/String; = "ro.build.version.opporom"

.field private static final VERSION_PROPERTY_VIVO:Ljava/lang/String; = "ro.vivo.os.build.display.id"

.field private static final VERSION_PROPERTY_XIAOMI:Ljava/lang/String; = "ro.build.version.incremental"

.field private static final VERSION_PROPERTY_ZTE:Ljava/lang/String; = "ro.build.MiFavor_version"

.field private static bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    const-string v0, "huawei"

    filled-new-array {v0}, [Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_HUAWEI:[Ljava/lang/String;

    const-string v0, "vivo"

    filled-new-array {v0}, [Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_VIVO:[Ljava/lang/String;

    const-string v0, "xiaomi"

    filled-new-array {v0}, [Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_XIAOMI:[Ljava/lang/String;

    const-string v0, "oppo"

    filled-new-array {v0}, [Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_OPPO:[Ljava/lang/String;

    const-string v0, "leeco"

    const-string v1, "letv"

    filled-new-array {v0, v1}, [Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_LEECO:[Ljava/lang/String;

    const-string v0, "360"

    const-string v1, "qiku"

    filled-new-array {v0, v1}, [Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_360:[Ljava/lang/String;

    const-string v0, "zte"

    filled-new-array {v0}, [Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_ZTE:[Ljava/lang/String;

    const-string v0, "oneplus"

    filled-new-array {v0}, [Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_ONEPLUS:[Ljava/lang/String;

    const-string v0, "nubia"

    filled-new-array {v0}, [Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_NUBIA:[Ljava/lang/String;

    const-string v0, "coolpad"

    const-string v1, "yulong"

    filled-new-array {v0, v1}, [Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_COOLPAD:[Ljava/lang/String;

    const-string v0, "lg"

    const-string v1, "lge"

    filled-new-array {v0, v1}, [Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_LG:[Ljava/lang/String;

    const-string v0, "google"

    filled-new-array {v0}, [Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_GOOGLE:[Ljava/lang/String;

    const-string v0, "samsung"

    filled-new-array {v0}, [Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_SAMSUNG:[Ljava/lang/String;

    const-string v0, "meizu"

    filled-new-array {v0}, [Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_MEIZU:[Ljava/lang/String;

    const-string v0, "lenovo"

    filled-new-array {v0}, [Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_LENOVO:[Ljava/lang/String;

    const-string v0, "smartisan"

    const-string v1, "deltainno"

    filled-new-array {v0, v1}, [Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_SMARTISAN:[Ljava/lang/String;

    const-string v0, "htc"

    filled-new-array {v0}, [Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_HTC:[Ljava/lang/String;

    const-string v0, "sony"

    filled-new-array {v0}, [Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_SONY:[Ljava/lang/String;

    const-string v0, "gionee"

    const-string v1, "amigo"

    filled-new-array {v0, v1}, [Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_GIONEE:[Ljava/lang/String;

    const-string v0, "motorola"

    filled-new-array {v0}, [Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_MOTOROLA:[Ljava/lang/String;

    const/4 v0, 0x0

    sput-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    return-void
.end method

.method private constructor <init>()V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "u can\'t instantiate me..."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private static getBrand()Ljava/lang/String;
    .registers 2

    :try_start_0
    sget-object v0, Landroid/os/Build;->BRAND:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_d

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0
    :try_end_c
    .catchall {:try_start_0 .. :try_end_c} :catchall_d

    return-object v0

    :catchall_d
    :cond_d
    const-string v0, "unknown"

    return-object v0
.end method

.method private static getManufacturer()Ljava/lang/String;
    .registers 2

    :try_start_0
    sget-object v0, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_d

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0
    :try_end_c
    .catchall {:try_start_0 .. :try_end_c} :catchall_d

    return-object v0

    :catchall_d
    :cond_d
    const-string v0, "unknown"

    return-object v0
.end method

.method public static getRomInfo()Lcom/blankj/utilcode/util/RomUtils$RomInfo;
    .registers 5

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    if-eqz v0, :cond_5

    return-object v0

    :cond_5
    new-instance v0, Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    invoke-direct {v0}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;-><init>()V

    sput-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    invoke-static {}, Lcom/blankj/utilcode/util/RomUtils;->getBrand()Ljava/lang/String;

    move-result-object v0

    invoke-static {}, Lcom/blankj/utilcode/util/RomUtils;->getManufacturer()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lcom/blankj/utilcode/util/RomUtils;->ROM_HUAWEI:[Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/blankj/utilcode/util/RomUtils;->isRightRom(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v3

    const/4 v4, 0x0

    if-eqz v3, :cond_44

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    aget-object v1, v2, v4

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$002(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    const-string v0, "ro.build.version.emui"

    invoke-static {v0}, Lcom/blankj/utilcode/util/RomUtils;->getRomVersion(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "_"

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    array-length v2, v1

    const/4 v3, 0x1

    if-le v2, v3, :cond_3c

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    aget-object v1, v1, v3

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->version:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$102(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    goto :goto_41

    :cond_3c
    sget-object v1, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->version:Ljava/lang/String;
    invoke-static {v1, v0}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$102(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    :goto_41
    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    return-object v0

    :cond_44
    sget-object v2, Lcom/blankj/utilcode/util/RomUtils;->ROM_VIVO:[Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/blankj/utilcode/util/RomUtils;->isRightRom(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_61

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    aget-object v1, v2, v4

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$002(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    const-string v1, "ro.vivo.os.build.display.id"

    invoke-static {v1}, Lcom/blankj/utilcode/util/RomUtils;->getRomVersion(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->version:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$102(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    return-object v0

    :cond_61
    sget-object v2, Lcom/blankj/utilcode/util/RomUtils;->ROM_XIAOMI:[Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/blankj/utilcode/util/RomUtils;->isRightRom(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_7e

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    aget-object v1, v2, v4

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$002(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    const-string v1, "ro.build.version.incremental"

    invoke-static {v1}, Lcom/blankj/utilcode/util/RomUtils;->getRomVersion(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->version:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$102(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    return-object v0

    :cond_7e
    sget-object v2, Lcom/blankj/utilcode/util/RomUtils;->ROM_OPPO:[Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/blankj/utilcode/util/RomUtils;->isRightRom(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_9b

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    aget-object v1, v2, v4

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$002(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    const-string v1, "ro.build.version.opporom"

    invoke-static {v1}, Lcom/blankj/utilcode/util/RomUtils;->getRomVersion(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->version:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$102(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    return-object v0

    :cond_9b
    sget-object v2, Lcom/blankj/utilcode/util/RomUtils;->ROM_LEECO:[Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/blankj/utilcode/util/RomUtils;->isRightRom(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_b8

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    aget-object v1, v2, v4

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$002(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    const-string v1, "ro.letv.release.version"

    invoke-static {v1}, Lcom/blankj/utilcode/util/RomUtils;->getRomVersion(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->version:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$102(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    return-object v0

    :cond_b8
    sget-object v2, Lcom/blankj/utilcode/util/RomUtils;->ROM_360:[Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/blankj/utilcode/util/RomUtils;->isRightRom(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_d5

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    aget-object v1, v2, v4

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$002(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    const-string v1, "ro.build.uiversion"

    invoke-static {v1}, Lcom/blankj/utilcode/util/RomUtils;->getRomVersion(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->version:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$102(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    return-object v0

    :cond_d5
    sget-object v2, Lcom/blankj/utilcode/util/RomUtils;->ROM_ZTE:[Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/blankj/utilcode/util/RomUtils;->isRightRom(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_f2

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    aget-object v1, v2, v4

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$002(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    const-string v1, "ro.build.MiFavor_version"

    invoke-static {v1}, Lcom/blankj/utilcode/util/RomUtils;->getRomVersion(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->version:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$102(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    return-object v0

    :cond_f2
    sget-object v2, Lcom/blankj/utilcode/util/RomUtils;->ROM_ONEPLUS:[Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/blankj/utilcode/util/RomUtils;->isRightRom(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_10f

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    aget-object v1, v2, v4

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$002(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    const-string v1, "ro.rom.version"

    invoke-static {v1}, Lcom/blankj/utilcode/util/RomUtils;->getRomVersion(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->version:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$102(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    return-object v0

    :cond_10f
    sget-object v2, Lcom/blankj/utilcode/util/RomUtils;->ROM_NUBIA:[Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/blankj/utilcode/util/RomUtils;->isRightRom(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_12c

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    aget-object v1, v2, v4

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$002(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    const-string v1, "ro.build.rom.id"

    invoke-static {v1}, Lcom/blankj/utilcode/util/RomUtils;->getRomVersion(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->version:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$102(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    return-object v0

    :cond_12c
    sget-object v2, Lcom/blankj/utilcode/util/RomUtils;->ROM_COOLPAD:[Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/blankj/utilcode/util/RomUtils;->isRightRom(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_13d

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    aget-object v1, v2, v4

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$002(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    goto/16 :goto_1e5

    :cond_13d
    sget-object v2, Lcom/blankj/utilcode/util/RomUtils;->ROM_LG:[Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/blankj/utilcode/util/RomUtils;->isRightRom(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_14e

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    aget-object v1, v2, v4

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$002(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    goto/16 :goto_1e5

    :cond_14e
    sget-object v2, Lcom/blankj/utilcode/util/RomUtils;->ROM_GOOGLE:[Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/blankj/utilcode/util/RomUtils;->isRightRom(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_15f

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    aget-object v1, v2, v4

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$002(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    goto/16 :goto_1e5

    :cond_15f
    sget-object v2, Lcom/blankj/utilcode/util/RomUtils;->ROM_SAMSUNG:[Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/blankj/utilcode/util/RomUtils;->isRightRom(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_170

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    aget-object v1, v2, v4

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$002(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    goto/16 :goto_1e5

    :cond_170
    sget-object v2, Lcom/blankj/utilcode/util/RomUtils;->ROM_MEIZU:[Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/blankj/utilcode/util/RomUtils;->isRightRom(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_180

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    aget-object v1, v2, v4

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$002(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    goto :goto_1e5

    :cond_180
    sget-object v2, Lcom/blankj/utilcode/util/RomUtils;->ROM_LENOVO:[Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/blankj/utilcode/util/RomUtils;->isRightRom(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_190

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    aget-object v1, v2, v4

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$002(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    goto :goto_1e5

    :cond_190
    sget-object v2, Lcom/blankj/utilcode/util/RomUtils;->ROM_SMARTISAN:[Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/blankj/utilcode/util/RomUtils;->isRightRom(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1a0

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    aget-object v1, v2, v4

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$002(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    goto :goto_1e5

    :cond_1a0
    sget-object v2, Lcom/blankj/utilcode/util/RomUtils;->ROM_HTC:[Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/blankj/utilcode/util/RomUtils;->isRightRom(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1b0

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    aget-object v1, v2, v4

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$002(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    goto :goto_1e5

    :cond_1b0
    sget-object v2, Lcom/blankj/utilcode/util/RomUtils;->ROM_SONY:[Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/blankj/utilcode/util/RomUtils;->isRightRom(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1c0

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    aget-object v1, v2, v4

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$002(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    goto :goto_1e5

    :cond_1c0
    sget-object v2, Lcom/blankj/utilcode/util/RomUtils;->ROM_GIONEE:[Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/blankj/utilcode/util/RomUtils;->isRightRom(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1d0

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    aget-object v1, v2, v4

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$002(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    goto :goto_1e5

    :cond_1d0
    sget-object v2, Lcom/blankj/utilcode/util/RomUtils;->ROM_MOTOROLA:[Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/blankj/utilcode/util/RomUtils;->isRightRom(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1e0

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    aget-object v1, v2, v4

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$002(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    goto :goto_1e5

    :cond_1e0
    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$002(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    :goto_1e5
    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    const-string v1, ""

    invoke-static {v1}, Lcom/blankj/utilcode/util/RomUtils;->getRomVersion(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    # setter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->version:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$102(Lcom/blankj/utilcode/util/RomUtils$RomInfo;Ljava/lang/String;)Ljava/lang/String;

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->bean:Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    return-object v0
.end method

.method private static getRomVersion(Ljava/lang/String;)Ljava/lang/String;
    .registers 4

    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_b

    invoke-static {p0}, Lcom/blankj/utilcode/util/RomUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    goto :goto_d

    :cond_b
    const-string p0, ""

    :goto_d
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    const-string v1, "unknown"

    if-nez v0, :cond_1b

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_27

    :cond_1b
    :try_start_1b
    sget-object v0, Landroid/os/Build;->DISPLAY:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_27

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object p0
    :try_end_27
    .catchall {:try_start_1b .. :try_end_27} :catchall_27

    :catchall_27
    :cond_27
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2e

    return-object v1

    :cond_2e
    return-object p0
.end method

.method private static getSystemProperty(Ljava/lang/String;)Ljava/lang/String;
    .registers 4

    invoke-static {p0}, Lcom/blankj/utilcode/util/RomUtils;->getSystemPropertyByShell(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_b

    return-object v0

    :cond_b
    invoke-static {p0}, Lcom/blankj/utilcode/util/RomUtils;->getSystemPropertyByStream(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_16

    return-object v0

    :cond_16
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x1c

    if-ge v1, v2, :cond_21

    invoke-static {p0}, Lcom/blankj/utilcode/util/RomUtils;->getSystemPropertyByReflect(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_21
    return-object v0
.end method

.method private static getSystemPropertyByReflect(Ljava/lang/String;)Ljava/lang/String;
    .registers 9

    const-string v0, ""

    :try_start_2
    const-string v1, "android.os.SystemProperties"

    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    const-string v2, "get"

    const/4 v3, 0x2

    new-array v4, v3, [Ljava/lang/Class;

    const-class v5, Ljava/lang/String;

    const/4 v6, 0x0

    aput-object v5, v4, v6

    const-class v5, Ljava/lang/String;

    const/4 v7, 0x1

    aput-object v5, v4, v7

    invoke-virtual {v1, v2, v4}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v2

    new-array v3, v3, [Ljava/lang/Object;

    aput-object p0, v3, v6

    aput-object v0, v3, v7

    invoke-virtual {v2, v1, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/lang/String;
    :try_end_27
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_27} :catch_28

    return-object p0

    :catch_28
    return-object v0
.end method

.method private static getSystemPropertyByShell(Ljava/lang/String;)Ljava/lang/String;
    .registers 5

    const-string v0, "getprop "

    const/4 v1, 0x0

    :try_start_3
    invoke-static {}, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v2, p0}, Ljava/lang/Runtime;->exec(Ljava/lang/String;)Ljava/lang/Process;

    move-result-object p0

    new-instance v0, Ljava/io/BufferedReader;

    new-instance v2, Ljava/io/InputStreamReader;

    invoke-virtual {p0}, Ljava/lang/Process;->getInputStream()Ljava/io/InputStream;

    move-result-object p0

    invoke-direct {v2, p0}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    const/16 p0, 0x400

    invoke-direct {v0, v2, p0}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;I)V
    :try_end_28
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_28} :catch_42
    .catchall {:try_start_3 .. :try_end_28} :catchall_3b

    :try_start_28
    invoke-virtual {v0}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object p0
    :try_end_2c
    .catch Ljava/io/IOException; {:try_start_28 .. :try_end_2c} :catch_39
    .catchall {:try_start_28 .. :try_end_2c} :catchall_36

    if-eqz p0, :cond_32

    :try_start_2e
    invoke-virtual {v0}, Ljava/io/BufferedReader;->close()V
    :try_end_31
    .catch Ljava/io/IOException; {:try_start_2e .. :try_end_31} :catch_31

    :catch_31
    return-object p0

    :cond_32
    :try_start_32
    invoke-virtual {v0}, Ljava/io/BufferedReader;->close()V
    :try_end_35
    .catch Ljava/io/IOException; {:try_start_32 .. :try_end_35} :catch_47

    goto :goto_47

    :catchall_36
    move-exception p0

    move-object v1, v0

    goto :goto_3c

    :catch_39
    move-object v1, v0

    goto :goto_42

    :catchall_3b
    move-exception p0

    :goto_3c
    if-eqz v1, :cond_41

    :try_start_3e
    invoke-virtual {v1}, Ljava/io/BufferedReader;->close()V
    :try_end_41
    .catch Ljava/io/IOException; {:try_start_3e .. :try_end_41} :catch_41

    :catch_41
    :cond_41
    throw p0

    :catch_42
    :goto_42
    if-eqz v1, :cond_47

    :try_start_44
    invoke-virtual {v1}, Ljava/io/BufferedReader;->close()V
    :try_end_47
    .catch Ljava/io/IOException; {:try_start_44 .. :try_end_47} :catch_47

    :catch_47
    :cond_47
    :goto_47
    const-string p0, ""

    return-object p0
.end method

.method private static getSystemPropertyByStream(Ljava/lang/String;)Ljava/lang/String;
    .registers 7

    const-string v0, ""

    :try_start_2
    new-instance v1, Ljava/util/Properties;

    invoke-direct {v1}, Ljava/util/Properties;-><init>()V

    new-instance v2, Ljava/io/FileInputStream;

    new-instance v3, Ljava/io/File;

    invoke-static {}, Landroid/os/Environment;->getRootDirectory()Ljava/io/File;

    move-result-object v4

    const-string v5, "build.prop"

    invoke-direct {v3, v4, v5}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-direct {v2, v3}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-virtual {v1, v2}, Ljava/util/Properties;->load(Ljava/io/InputStream;)V

    invoke-virtual {v1, p0, v0}, Ljava/util/Properties;->getProperty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0
    :try_end_1e
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_1e} :catch_1f

    return-object p0

    :catch_1f
    return-object v0
.end method

.method public static is360()Z
    .registers 2

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_360:[Ljava/lang/String;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    invoke-static {}, Lcom/blankj/utilcode/util/RomUtils;->getRomInfo()Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    move-result-object v1

    # getter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$000(Lcom/blankj/utilcode/util/RomUtils$RomInfo;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static isCoolpad()Z
    .registers 2

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_COOLPAD:[Ljava/lang/String;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    invoke-static {}, Lcom/blankj/utilcode/util/RomUtils;->getRomInfo()Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    move-result-object v1

    # getter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$000(Lcom/blankj/utilcode/util/RomUtils$RomInfo;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static isGionee()Z
    .registers 2

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_GIONEE:[Ljava/lang/String;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    invoke-static {}, Lcom/blankj/utilcode/util/RomUtils;->getRomInfo()Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    move-result-object v1

    # getter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$000(Lcom/blankj/utilcode/util/RomUtils$RomInfo;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static isGoogle()Z
    .registers 2

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_GOOGLE:[Ljava/lang/String;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    invoke-static {}, Lcom/blankj/utilcode/util/RomUtils;->getRomInfo()Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    move-result-object v1

    # getter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$000(Lcom/blankj/utilcode/util/RomUtils$RomInfo;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static isHtc()Z
    .registers 2

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_HTC:[Ljava/lang/String;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    invoke-static {}, Lcom/blankj/utilcode/util/RomUtils;->getRomInfo()Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    move-result-object v1

    # getter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$000(Lcom/blankj/utilcode/util/RomUtils$RomInfo;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static isHuawei()Z
    .registers 2

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_HUAWEI:[Ljava/lang/String;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    invoke-static {}, Lcom/blankj/utilcode/util/RomUtils;->getRomInfo()Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    move-result-object v1

    # getter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$000(Lcom/blankj/utilcode/util/RomUtils$RomInfo;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static isLeeco()Z
    .registers 2

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_LEECO:[Ljava/lang/String;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    invoke-static {}, Lcom/blankj/utilcode/util/RomUtils;->getRomInfo()Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    move-result-object v1

    # getter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$000(Lcom/blankj/utilcode/util/RomUtils$RomInfo;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static isLenovo()Z
    .registers 2

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_LENOVO:[Ljava/lang/String;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    invoke-static {}, Lcom/blankj/utilcode/util/RomUtils;->getRomInfo()Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    move-result-object v1

    # getter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$000(Lcom/blankj/utilcode/util/RomUtils$RomInfo;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static isLg()Z
    .registers 2

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_LG:[Ljava/lang/String;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    invoke-static {}, Lcom/blankj/utilcode/util/RomUtils;->getRomInfo()Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    move-result-object v1

    # getter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$000(Lcom/blankj/utilcode/util/RomUtils$RomInfo;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static isMeizu()Z
    .registers 2

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_MEIZU:[Ljava/lang/String;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    invoke-static {}, Lcom/blankj/utilcode/util/RomUtils;->getRomInfo()Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    move-result-object v1

    # getter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$000(Lcom/blankj/utilcode/util/RomUtils$RomInfo;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static isMotorola()Z
    .registers 2

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_MOTOROLA:[Ljava/lang/String;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    invoke-static {}, Lcom/blankj/utilcode/util/RomUtils;->getRomInfo()Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    move-result-object v1

    # getter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$000(Lcom/blankj/utilcode/util/RomUtils$RomInfo;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static isNubia()Z
    .registers 2

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_NUBIA:[Ljava/lang/String;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    invoke-static {}, Lcom/blankj/utilcode/util/RomUtils;->getRomInfo()Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    move-result-object v1

    # getter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$000(Lcom/blankj/utilcode/util/RomUtils$RomInfo;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static isOneplus()Z
    .registers 2

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_ONEPLUS:[Ljava/lang/String;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    invoke-static {}, Lcom/blankj/utilcode/util/RomUtils;->getRomInfo()Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    move-result-object v1

    # getter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$000(Lcom/blankj/utilcode/util/RomUtils$RomInfo;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static isOppo()Z
    .registers 2

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_OPPO:[Ljava/lang/String;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    invoke-static {}, Lcom/blankj/utilcode/util/RomUtils;->getRomInfo()Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    move-result-object v1

    # getter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$000(Lcom/blankj/utilcode/util/RomUtils$RomInfo;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method private static varargs isRightRom(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z
    .registers 8

    array-length v0, p2

    const/4 v1, 0x0

    move v2, v1

    :goto_3
    if-ge v2, v0, :cond_19

    aget-object v3, p2, v2

    invoke-virtual {p0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_17

    invoke-virtual {p1, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_14

    goto :goto_17

    :cond_14
    add-int/lit8 v2, v2, 0x1

    goto :goto_3

    :cond_17
    :goto_17
    const/4 p0, 0x1

    return p0

    :cond_19
    return v1
.end method

.method public static isSamsung()Z
    .registers 2

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_SAMSUNG:[Ljava/lang/String;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    invoke-static {}, Lcom/blankj/utilcode/util/RomUtils;->getRomInfo()Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    move-result-object v1

    # getter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$000(Lcom/blankj/utilcode/util/RomUtils$RomInfo;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static isSmartisan()Z
    .registers 2

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_SMARTISAN:[Ljava/lang/String;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    invoke-static {}, Lcom/blankj/utilcode/util/RomUtils;->getRomInfo()Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    move-result-object v1

    # getter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$000(Lcom/blankj/utilcode/util/RomUtils$RomInfo;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static isSony()Z
    .registers 2

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_SONY:[Ljava/lang/String;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    invoke-static {}, Lcom/blankj/utilcode/util/RomUtils;->getRomInfo()Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    move-result-object v1

    # getter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$000(Lcom/blankj/utilcode/util/RomUtils$RomInfo;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static isVivo()Z
    .registers 2

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_VIVO:[Ljava/lang/String;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    invoke-static {}, Lcom/blankj/utilcode/util/RomUtils;->getRomInfo()Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    move-result-object v1

    # getter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$000(Lcom/blankj/utilcode/util/RomUtils$RomInfo;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static isXiaomi()Z
    .registers 2

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_XIAOMI:[Ljava/lang/String;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    invoke-static {}, Lcom/blankj/utilcode/util/RomUtils;->getRomInfo()Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    move-result-object v1

    # getter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$000(Lcom/blankj/utilcode/util/RomUtils$RomInfo;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static isZte()Z
    .registers 2

    sget-object v0, Lcom/blankj/utilcode/util/RomUtils;->ROM_ZTE:[Ljava/lang/String;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    invoke-static {}, Lcom/blankj/utilcode/util/RomUtils;->getRomInfo()Lcom/blankj/utilcode/util/RomUtils$RomInfo;

    move-result-object v1

    # getter for: Lcom/blankj/utilcode/util/RomUtils$RomInfo;->name:Ljava/lang/String;
    invoke-static {v1}, Lcom/blankj/utilcode/util/RomUtils$RomInfo;->access$000(Lcom/blankj/utilcode/util/RomUtils$RomInfo;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method
