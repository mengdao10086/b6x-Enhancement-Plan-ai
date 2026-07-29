.class public final Lcom/flydigi/sdk/waspwing/WaspWingInfo$Creator;
.super Ljava/lang/Object;
.source "WaspWingInfo.kt"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/flydigi/sdk/waspwing/WaspWingInfo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Creator"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable$Creator<",
        "Lcom/flydigi/sdk/waspwing/WaspWingInfo;",
        ">;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    k = 0x3
    mv = {
        0x1,
        0x8,
        0x0
    }
    xi = 0x30
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final createFromParcel(Landroid/os/Parcel;)Lcom/flydigi/sdk/waspwing/WaspWingInfo;
    .registers 35

    move-object/from16 v0, p1

    const-string v1, "parcel"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    new-instance v1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    invoke-virtual/range {p1 .. p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual/range {p1 .. p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual/range {p1 .. p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    const/4 v5, 0x1

    const/4 v6, 0x0

    if-eqz v2, :cond_1b

    move v7, v5

    goto :goto_1c

    :cond_1b
    move v7, v6

    :goto_1c
    invoke-virtual/range {p1 .. p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual/range {p1 .. p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual/range {p1 .. p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_2c

    move v10, v5

    goto :goto_2d

    :cond_2c
    move v10, v6

    :goto_2d
    invoke-virtual/range {p1 .. p1}, Landroid/os/Parcel;->readInt()I

    move-result v11

    invoke-virtual/range {p1 .. p1}, Landroid/os/Parcel;->readInt()I

    move-result v12

    invoke-virtual/range {p1 .. p1}, Landroid/os/Parcel;->readInt()I

    move-result v13

    invoke-virtual/range {p1 .. p1}, Landroid/os/Parcel;->readInt()I

    move-result v14

    invoke-virtual/range {p1 .. p1}, Landroid/os/Parcel;->readInt()I

    move-result v15

    invoke-virtual/range {p1 .. p1}, Landroid/os/Parcel;->readInt()I

    move-result v16

    invoke-virtual/range {p1 .. p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_4e

    move/from16 v17, v5

    goto :goto_50

    :cond_4e
    move/from16 v17, v6

    :goto_50
    invoke-virtual/range {p1 .. p1}, Landroid/os/Parcel;->readInt()I

    move-result v18

    invoke-virtual/range {p1 .. p1}, Landroid/os/Parcel;->readInt()I

    move-result v19

    invoke-virtual/range {p1 .. p1}, Landroid/os/Parcel;->readInt()I

    move-result v20

    invoke-virtual/range {p1 .. p1}, Landroid/os/Parcel;->readInt()I

    move-result v21

    invoke-virtual/range {p1 .. p1}, Landroid/os/Parcel;->readInt()I

    move-result v22

    invoke-virtual/range {p1 .. p1}, Landroid/os/Parcel;->readInt()I

    move-result v23

    invoke-virtual/range {p1 .. p1}, Landroid/os/Parcel;->readByte()B

    move-result v24

    invoke-virtual/range {p1 .. p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    const/16 v25, 0x0

    if-nez v2, :cond_77

    move-object/from16 v2, v25

    goto :goto_7d

    :cond_77
    sget-object v2, Lcom/flydigi/sdk/waspwing/LedData;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v2, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v2

    :goto_7d
    move-object/from16 v26, v2

    check-cast v26, Lcom/flydigi/sdk/waspwing/LedData;

    invoke-virtual/range {p1 .. p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_8a

    move/from16 v27, v5

    goto :goto_8c

    :cond_8a
    move/from16 v27, v6

    :goto_8c
    invoke-virtual/range {p1 .. p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_95

    move/from16 v28, v5

    goto :goto_97

    :cond_95
    move/from16 v28, v6

    :goto_97
    invoke-virtual/range {p1 .. p1}, Landroid/os/Parcel;->createByteArray()[B

    move-result-object v29

    invoke-virtual/range {p1 .. p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-nez v2, :cond_a4

    move-object/from16 v30, v25

    goto :goto_ae

    :cond_a4
    invoke-virtual/range {p1 .. p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    move-object/from16 v30, v2

    :goto_ae
    invoke-virtual/range {p1 .. p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-nez v2, :cond_b7

    move-object/from16 v31, v25

    goto :goto_c1

    :cond_b7
    invoke-virtual/range {p1 .. p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    move-object/from16 v31, v2

    :goto_c1
    invoke-virtual/range {p1 .. p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_ca

    move/from16 v32, v5

    goto :goto_cc

    :cond_ca
    move/from16 v32, v6

    :goto_cc
    invoke-virtual/range {p1 .. p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-nez v2, :cond_d5

    move-object/from16 v0, v25

    goto :goto_dd

    :cond_d5
    invoke-virtual/range {p1 .. p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    :goto_dd
    move-object v2, v1

    move v5, v7

    move-object v6, v8

    move-object v7, v9

    move v8, v10

    move v9, v11

    move v10, v12

    move v11, v13

    move v12, v14

    move v13, v15

    move/from16 v14, v16

    move/from16 v15, v17

    move/from16 v16, v18

    move/from16 v17, v19

    move/from16 v18, v20

    move/from16 v19, v21

    move/from16 v20, v22

    move/from16 v21, v23

    move/from16 v22, v24

    move-object/from16 v23, v26

    move/from16 v24, v27

    move/from16 v25, v28

    move-object/from16 v26, v29

    move-object/from16 v27, v30

    move-object/from16 v28, v31

    move/from16 v29, v32

    move-object/from16 v30, v0

    invoke-direct/range {v2 .. v30}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;-><init>(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZIIIIIIZIIIIIIBLcom/flydigi/sdk/waspwing/LedData;ZZ[BLjava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Integer;)V

    return-object v1
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 2

    invoke-virtual {p0, p1}, Lcom/flydigi/sdk/waspwing/WaspWingInfo$Creator;->createFromParcel(Landroid/os/Parcel;)Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    move-result-object p1

    return-object p1
.end method

.method public final newArray(I)[Lcom/flydigi/sdk/waspwing/WaspWingInfo;
    .registers 2

    new-array p1, p1, [Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    return-object p1
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 2

    invoke-virtual {p0, p1}, Lcom/flydigi/sdk/waspwing/WaspWingInfo$Creator;->newArray(I)[Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    move-result-object p1

    return-object p1
.end method
