.class public final Lcom/flydigi/sdk/bluetooth/DeviceFilter$DefaultImpls;
.super Ljava/lang/Object;
.source "DeviceFilter.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/flydigi/sdk/bluetooth/DeviceFilter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "DefaultImpls"
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
.method public static synthetic isValidDevice$default(Lcom/flydigi/sdk/bluetooth/DeviceFilter;Ljava/lang/String;IILjava/lang/Object;)Z
    .registers 5

    if-nez p4, :cond_c

    and-int/lit8 p3, p3, 0x2

    if-eqz p3, :cond_7

    const/4 p2, 0x0

    .line 15
    :cond_7
    invoke-interface {p0, p1, p2}, Lcom/flydigi/sdk/bluetooth/DeviceFilter;->isValidDevice(Ljava/lang/String;I)Z

    move-result p0

    return p0

    :cond_c
    new-instance p0, Ljava/lang/UnsupportedOperationException;

    const-string p1, "Super calls with default arguments not supported in this target, function: isValidDevice"

    invoke-direct {p0, p1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw p0
.end method
