.class public final Lcom/flydigi/sdk/waspwing/BluetoothName;
.super Ljava/lang/Object;
.source "Constance.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R \u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000bj\u0008\u0012\u0004\u0012\u00020\u0004`\u000c8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"
    }
    d2 = {
        "Lcom/flydigi/sdk/waspwing/BluetoothName;",
        "",
        "()V",
        "BLUETOOTH_NAME_B3",
        "",
        "BLUETOOTH_NAME_B5",
        "BLUETOOTH_NAME_B5P",
        "BLUETOOTH_NAME_B5X",
        "BLUETOOTH_NAME_B6",
        "BLUETOOTH_NAME_B6X",
        "BLUETOOTH_NAME_LIST",
        "Ljava/util/ArrayList;",
        "Lkotlin/collections/ArrayList;",
        "sdk_waspwing_release"
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
.field public static final BLUETOOTH_NAME_B3:Ljava/lang/String; = "Flydigi Waspwing2 Pro"

.field public static final BLUETOOTH_NAME_B5:Ljava/lang/String; = "Flydigi B5"

.field public static final BLUETOOTH_NAME_B5P:Ljava/lang/String; = "Flydigi B5Pro"

.field public static final BLUETOOTH_NAME_B5X:Ljava/lang/String; = "Flydigi B5X"

.field public static final BLUETOOTH_NAME_B6:Ljava/lang/String; = "Flydigi B6"

.field public static final BLUETOOTH_NAME_B6X:Ljava/lang/String; = "Flydigi B6X"

.field public static final BLUETOOTH_NAME_LIST:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public static final INSTANCE:Lcom/flydigi/sdk/waspwing/BluetoothName;


# direct methods
.method static constructor <clinit>()V
    .registers 7

    new-instance v0, Lcom/flydigi/sdk/waspwing/BluetoothName;

    invoke-direct {v0}, Lcom/flydigi/sdk/waspwing/BluetoothName;-><init>()V

    sput-object v0, Lcom/flydigi/sdk/waspwing/BluetoothName;->INSTANCE:Lcom/flydigi/sdk/waspwing/BluetoothName;

    const-string v1, "Flydigi Waspwing2 Pro"

    const-string v2, "Flydigi B5"

    const-string v3, "Flydigi B5Pro"

    const-string v4, "Flydigi B5X"

    const-string v5, "Flydigi B6"

    const-string v6, "Flydigi B6X"

    .line 44
    filled-new-array/range {v1 .. v6}, [Ljava/lang/String;

    move-result-object v0

    .line 38
    invoke-static {v0}, Lkotlin/collections/CollectionsKt;->arrayListOf([Ljava/lang/Object;)Ljava/util/ArrayList;

    move-result-object v0

    sput-object v0, Lcom/flydigi/sdk/waspwing/BluetoothName;->BLUETOOTH_NAME_LIST:Ljava/util/ArrayList;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
