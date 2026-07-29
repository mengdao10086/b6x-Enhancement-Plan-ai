.class public final Lcom/flydigi/sdk/waspwing/LedData;
.super Ljava/lang/Object;
.source "WaspWingInfo.kt"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0018\u0008\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\u0008\u0012\u0004\u0012\u00020\u0007`\u0008\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\u0019\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\u0008\u0012\u0004\u0012\u00020\u0007`\u0008H\u00c6\u0003J7\u0010\u0017\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0018\u0008\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\u0008\u0012\u0004\u0012\u00020\u0007`\u0008H\u00c6\u0001J\t\u0010\u0018\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\u0008\u0010\u001d\u001a\u00020\u0007H\u0016J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0007H\u00d6\u0001R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\u0008\u0012\u0004\u0012\u00020\u0007`\u0008X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0012\u0010\u000f\"\u0004\u0008\u0013\u0010\u0011\u00a8\u0006%"
    }
    d2 = {
        "Lcom/flydigi/sdk/waspwing/LedData;",
        "Landroid/os/Parcelable;",
        "ledType",
        "",
        "period",
        "colors",
        "Ljava/util/ArrayList;",
        "",
        "Lkotlin/collections/ArrayList;",
        "(BBLjava/util/ArrayList;)V",
        "getColors",
        "()Ljava/util/ArrayList;",
        "setColors",
        "(Ljava/util/ArrayList;)V",
        "getLedType",
        "()B",
        "setLedType",
        "(B)V",
        "getPeriod",
        "setPeriod",
        "component1",
        "component2",
        "component3",
        "copy",
        "describeContents",
        "equals",
        "",
        "other",
        "",
        "hashCode",
        "toString",
        "",
        "writeToParcel",
        "",
        "parcel",
        "Landroid/os/Parcel;",
        "flags",
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
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator<",
            "Lcom/flydigi/sdk/waspwing/LedData;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private colors:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private ledType:B

.field private period:B


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lcom/flydigi/sdk/waspwing/LedData$Creator;

    invoke-direct {v0}, Lcom/flydigi/sdk/waspwing/LedData$Creator;-><init>()V

    check-cast v0, Landroid/os/Parcelable$Creator;

    sput-object v0, Lcom/flydigi/sdk/waspwing/LedData;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(BBLjava/util/ArrayList;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(BB",
            "Ljava/util/ArrayList<",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    const-string v0, "colors"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 146
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 148
    iput-byte p1, p0, Lcom/flydigi/sdk/waspwing/LedData;->ledType:B

    .line 149
    iput-byte p2, p0, Lcom/flydigi/sdk/waspwing/LedData;->period:B

    .line 150
    iput-object p3, p0, Lcom/flydigi/sdk/waspwing/LedData;->colors:Ljava/util/ArrayList;

    return-void
.end method

.method public synthetic constructor <init>(BBLjava/util/ArrayList;ILkotlin/jvm/internal/DefaultConstructorMarker;)V
    .registers 6

    and-int/lit8 p4, p4, 0x4

    if-eqz p4, :cond_9

    .line 150
    new-instance p3, Ljava/util/ArrayList;

    invoke-direct {p3}, Ljava/util/ArrayList;-><init>()V

    .line 147
    :cond_9
    invoke-direct {p0, p1, p2, p3}, Lcom/flydigi/sdk/waspwing/LedData;-><init>(BBLjava/util/ArrayList;)V

    return-void
.end method

.method public static synthetic copy$default(Lcom/flydigi/sdk/waspwing/LedData;BBLjava/util/ArrayList;ILjava/lang/Object;)Lcom/flydigi/sdk/waspwing/LedData;
    .registers 6

    and-int/lit8 p5, p4, 0x1

    if-eqz p5, :cond_6

    iget-byte p1, p0, Lcom/flydigi/sdk/waspwing/LedData;->ledType:B

    :cond_6
    and-int/lit8 p5, p4, 0x2

    if-eqz p5, :cond_c

    iget-byte p2, p0, Lcom/flydigi/sdk/waspwing/LedData;->period:B

    :cond_c
    and-int/lit8 p4, p4, 0x4

    if-eqz p4, :cond_12

    iget-object p3, p0, Lcom/flydigi/sdk/waspwing/LedData;->colors:Ljava/util/ArrayList;

    :cond_12
    invoke-virtual {p0, p1, p2, p3}, Lcom/flydigi/sdk/waspwing/LedData;->copy(BBLjava/util/ArrayList;)Lcom/flydigi/sdk/waspwing/LedData;

    move-result-object p0

    return-object p0
.end method


# virtual methods
.method public final component1()B
    .registers 2

    iget-byte v0, p0, Lcom/flydigi/sdk/waspwing/LedData;->ledType:B

    return v0
.end method

.method public final component2()B
    .registers 2

    iget-byte v0, p0, Lcom/flydigi/sdk/waspwing/LedData;->period:B

    return v0
.end method

.method public final component3()Ljava/util/ArrayList;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/flydigi/sdk/waspwing/LedData;->colors:Ljava/util/ArrayList;

    return-object v0
.end method

.method public final copy(BBLjava/util/ArrayList;)Lcom/flydigi/sdk/waspwing/LedData;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(BB",
            "Ljava/util/ArrayList<",
            "Ljava/lang/Integer;",
            ">;)",
            "Lcom/flydigi/sdk/waspwing/LedData;"
        }
    .end annotation

    const-string v0, "colors"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    new-instance v0, Lcom/flydigi/sdk/waspwing/LedData;

    invoke-direct {v0, p1, p2, p3}, Lcom/flydigi/sdk/waspwing/LedData;-><init>(BBLjava/util/ArrayList;)V

    return-object v0
.end method

.method public describeContents()I
    .registers 2

    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 6

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    .line 154
    :cond_4
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    if-eqz p1, :cond_f

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    goto :goto_10

    :cond_f
    const/4 v2, 0x0

    :goto_10
    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    const/4 v2, 0x0

    if-nez v1, :cond_18

    return v2

    :cond_18
    const-string v1, "null cannot be cast to non-null type com.flydigi.sdk.waspwing.LedData"

    .line 156
    invoke-static {p1, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p1, Lcom/flydigi/sdk/waspwing/LedData;

    .line 158
    iget-byte v1, p0, Lcom/flydigi/sdk/waspwing/LedData;->ledType:B

    iget-byte v3, p1, Lcom/flydigi/sdk/waspwing/LedData;->ledType:B

    if-eq v1, v3, :cond_26

    return v2

    .line 159
    :cond_26
    iget-byte v1, p0, Lcom/flydigi/sdk/waspwing/LedData;->period:B

    iget-byte v3, p1, Lcom/flydigi/sdk/waspwing/LedData;->period:B

    if-eq v1, v3, :cond_2d

    return v2

    .line 160
    :cond_2d
    iget-object v1, p0, Lcom/flydigi/sdk/waspwing/LedData;->colors:Ljava/util/ArrayList;

    iget-object p1, p1, Lcom/flydigi/sdk/waspwing/LedData;->colors:Ljava/util/ArrayList;

    invoke-static {v1, p1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_38

    return v2

    :cond_38
    return v0
.end method

.method public final getColors()Ljava/util/ArrayList;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .line 150
    iget-object v0, p0, Lcom/flydigi/sdk/waspwing/LedData;->colors:Ljava/util/ArrayList;

    return-object v0
.end method

.method public final getLedType()B
    .registers 2

    .line 148
    iget-byte v0, p0, Lcom/flydigi/sdk/waspwing/LedData;->ledType:B

    return v0
.end method

.method public final getPeriod()B
    .registers 2

    .line 149
    iget-byte v0, p0, Lcom/flydigi/sdk/waspwing/LedData;->period:B

    return v0
.end method

.method public hashCode()I
    .registers 3

    .line 166
    iget-byte v0, p0, Lcom/flydigi/sdk/waspwing/LedData;->ledType:B

    mul-int/lit8 v0, v0, 0x1f

    .line 167
    iget-byte v1, p0, Lcom/flydigi/sdk/waspwing/LedData;->period:B

    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    .line 168
    iget-object v1, p0, Lcom/flydigi/sdk/waspwing/LedData;->colors:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    return v0
.end method

.method public final setColors(Ljava/util/ArrayList;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList<",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    const-string v0, "<set-?>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 150
    iput-object p1, p0, Lcom/flydigi/sdk/waspwing/LedData;->colors:Ljava/util/ArrayList;

    return-void
.end method

.method public final setLedType(B)V
    .registers 2

    .line 148
    iput-byte p1, p0, Lcom/flydigi/sdk/waspwing/LedData;->ledType:B

    return-void
.end method

.method public final setPeriod(B)V
    .registers 2

    .line 149
    iput-byte p1, p0, Lcom/flydigi/sdk/waspwing/LedData;->period:B

    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "LedData(ledType="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-byte v1, p0, Lcom/flydigi/sdk/waspwing/LedData;->ledType:B

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", period="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-byte v1, p0, Lcom/flydigi/sdk/waspwing/LedData;->period:B

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", colors="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/flydigi/sdk/waspwing/LedData;->colors:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x29

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 4

    const-string p2, "out"

    invoke-static {p1, p2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    iget-byte p2, p0, Lcom/flydigi/sdk/waspwing/LedData;->ledType:B

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeByte(B)V

    iget-byte p2, p0, Lcom/flydigi/sdk/waspwing/LedData;->period:B

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeByte(B)V

    iget-object p2, p0, Lcom/flydigi/sdk/waspwing/LedData;->colors:Ljava/util/ArrayList;

    invoke-virtual {p2}, Ljava/util/ArrayList;->size()I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    invoke-virtual {p2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object p2

    :goto_1c
    invoke-interface {p2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_30

    invoke-interface {p2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    invoke-virtual {v0}, Ljava/lang/Number;->intValue()I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_1c

    :cond_30
    return-void
.end method
