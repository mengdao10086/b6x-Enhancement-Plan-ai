.class public final Lcom/flydigi/sdk/waspwing/LedData$Creator;
.super Ljava/lang/Object;
.source "WaspWingInfo.kt"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/flydigi/sdk/waspwing/LedData;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Creator"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable$Creator<",
        "Lcom/flydigi/sdk/waspwing/LedData;",
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
.method public final createFromParcel(Landroid/os/Parcel;)Lcom/flydigi/sdk/waspwing/LedData;
    .registers 8

    const-string v0, "parcel"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v0

    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v1

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3, v2}, Ljava/util/ArrayList;-><init>(I)V

    const/4 v4, 0x0

    :goto_17
    if-eq v4, v2, :cond_27

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    add-int/lit8 v4, v4, 0x1

    goto :goto_17

    :cond_27
    new-instance p1, Lcom/flydigi/sdk/waspwing/LedData;

    invoke-direct {p1, v0, v1, v3}, Lcom/flydigi/sdk/waspwing/LedData;-><init>(BBLjava/util/ArrayList;)V

    return-object p1
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 2

    invoke-virtual {p0, p1}, Lcom/flydigi/sdk/waspwing/LedData$Creator;->createFromParcel(Landroid/os/Parcel;)Lcom/flydigi/sdk/waspwing/LedData;

    move-result-object p1

    return-object p1
.end method

.method public final newArray(I)[Lcom/flydigi/sdk/waspwing/LedData;
    .registers 2

    new-array p1, p1, [Lcom/flydigi/sdk/waspwing/LedData;

    return-object p1
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 2

    invoke-virtual {p0, p1}, Lcom/flydigi/sdk/waspwing/LedData$Creator;->newArray(I)[Lcom/flydigi/sdk/waspwing/LedData;

    move-result-object p1

    return-object p1
.end method
