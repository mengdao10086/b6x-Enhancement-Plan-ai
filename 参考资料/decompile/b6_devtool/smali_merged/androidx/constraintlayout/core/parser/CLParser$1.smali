.class synthetic Landroidx/constraintlayout/core/parser/CLParser$1;
.super Ljava/lang/Object;
.source "CLParser.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/constraintlayout/core/parser/CLParser;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1008
    name = null
.end annotation


# static fields
.field static final synthetic $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE:[I


# direct methods
.method static constructor <clinit>()V
    .registers 3

    .line 234
    invoke-static {}, Landroidx/constraintlayout/core/parser/CLParser$TYPE;->values()[Landroidx/constraintlayout/core/parser/CLParser$TYPE;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Landroidx/constraintlayout/core/parser/CLParser$1;->$SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE:[I

    :try_start_9
    sget-object v1, Landroidx/constraintlayout/core/parser/CLParser$TYPE;->OBJECT:Landroidx/constraintlayout/core/parser/CLParser$TYPE;

    invoke-virtual {v1}, Landroidx/constraintlayout/core/parser/CLParser$TYPE;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_12
    .catch Ljava/lang/NoSuchFieldError; {:try_start_9 .. :try_end_12} :catch_12

    :catch_12
    :try_start_12
    sget-object v0, Landroidx/constraintlayout/core/parser/CLParser$1;->$SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE:[I

    sget-object v1, Landroidx/constraintlayout/core/parser/CLParser$TYPE;->ARRAY:Landroidx/constraintlayout/core/parser/CLParser$TYPE;

    invoke-virtual {v1}, Landroidx/constraintlayout/core/parser/CLParser$TYPE;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_1d
    .catch Ljava/lang/NoSuchFieldError; {:try_start_12 .. :try_end_1d} :catch_1d

    :catch_1d
    :try_start_1d
    sget-object v0, Landroidx/constraintlayout/core/parser/CLParser$1;->$SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE:[I

    sget-object v1, Landroidx/constraintlayout/core/parser/CLParser$TYPE;->STRING:Landroidx/constraintlayout/core/parser/CLParser$TYPE;

    invoke-virtual {v1}, Landroidx/constraintlayout/core/parser/CLParser$TYPE;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_28
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1d .. :try_end_28} :catch_28

    :catch_28
    :try_start_28
    sget-object v0, Landroidx/constraintlayout/core/parser/CLParser$1;->$SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE:[I

    sget-object v1, Landroidx/constraintlayout/core/parser/CLParser$TYPE;->NUMBER:Landroidx/constraintlayout/core/parser/CLParser$TYPE;

    invoke-virtual {v1}, Landroidx/constraintlayout/core/parser/CLParser$TYPE;->ordinal()I

    move-result v1

    const/4 v2, 0x4

    aput v2, v0, v1
    :try_end_33
    .catch Ljava/lang/NoSuchFieldError; {:try_start_28 .. :try_end_33} :catch_33

    :catch_33
    :try_start_33
    sget-object v0, Landroidx/constraintlayout/core/parser/CLParser$1;->$SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE:[I

    sget-object v1, Landroidx/constraintlayout/core/parser/CLParser$TYPE;->KEY:Landroidx/constraintlayout/core/parser/CLParser$TYPE;

    invoke-virtual {v1}, Landroidx/constraintlayout/core/parser/CLParser$TYPE;->ordinal()I

    move-result v1

    const/4 v2, 0x5

    aput v2, v0, v1
    :try_end_3e
    .catch Ljava/lang/NoSuchFieldError; {:try_start_33 .. :try_end_3e} :catch_3e

    :catch_3e
    :try_start_3e
    sget-object v0, Landroidx/constraintlayout/core/parser/CLParser$1;->$SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE:[I

    sget-object v1, Landroidx/constraintlayout/core/parser/CLParser$TYPE;->TOKEN:Landroidx/constraintlayout/core/parser/CLParser$TYPE;

    invoke-virtual {v1}, Landroidx/constraintlayout/core/parser/CLParser$TYPE;->ordinal()I

    move-result v1

    const/4 v2, 0x6

    aput v2, v0, v1
    :try_end_49
    .catch Ljava/lang/NoSuchFieldError; {:try_start_3e .. :try_end_49} :catch_49

    :catch_49
    return-void
.end method
