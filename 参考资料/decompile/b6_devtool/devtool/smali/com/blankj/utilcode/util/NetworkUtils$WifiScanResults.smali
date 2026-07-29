.class public final Lcom/blankj/utilcode/util/NetworkUtils$WifiScanResults;
.super Ljava/lang/Object;
.source "NetworkUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/blankj/utilcode/util/NetworkUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "WifiScanResults"
.end annotation


# instance fields
.field private allResults:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Landroid/net/wifi/ScanResult;",
            ">;"
        }
    .end annotation
.end field

.field private filterResults:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Landroid/net/wifi/ScanResult;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/blankj/utilcode/util/NetworkUtils$WifiScanResults;->allResults:Ljava/util/List;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/blankj/utilcode/util/NetworkUtils$WifiScanResults;->filterResults:Ljava/util/List;

    return-void
.end method

.method static synthetic access$500(Lcom/blankj/utilcode/util/NetworkUtils$WifiScanResults;)Ljava/util/List;
    .registers 1

    iget-object p0, p0, Lcom/blankj/utilcode/util/NetworkUtils$WifiScanResults;->allResults:Ljava/util/List;

    return-object p0
.end method

.method private static filterScanResult(Ljava/util/List;)Ljava/util/List;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Landroid/net/wifi/ScanResult;",
            ">;)",
            "Ljava/util/List<",
            "Landroid/net/wifi/ScanResult;",
            ">;"
        }
    .end annotation

    if-eqz p0, :cond_4c

    invoke-interface {p0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_9

    goto :goto_4c

    :cond_9
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v1

    invoke-direct {v0, v1}, Ljava/util/LinkedHashMap;-><init>(I)V

    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :goto_16
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_42

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/net/wifi/ScanResult;

    iget-object v2, v1, Landroid/net/wifi/ScanResult;->SSID:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_2b

    goto :goto_16

    :cond_2b
    iget-object v2, v1, Landroid/net/wifi/ScanResult;->SSID:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/net/wifi/ScanResult;

    if-eqz v2, :cond_3c

    iget v2, v2, Landroid/net/wifi/ScanResult;->level:I

    iget v3, v1, Landroid/net/wifi/ScanResult;->level:I

    if-lt v2, v3, :cond_3c

    goto :goto_16

    :cond_3c
    iget-object v2, v1, Landroid/net/wifi/ScanResult;->SSID:Ljava/lang/String;

    invoke-virtual {v0, v2, v1}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_16

    :cond_42
    new-instance p0, Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-direct {p0, v0}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    return-object p0

    :cond_4c
    :goto_4c
    new-instance p0, Ljava/util/ArrayList;

    invoke-direct {p0}, Ljava/util/ArrayList;-><init>()V

    return-object p0
.end method


# virtual methods
.method public getAllResults()Ljava/util/List;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Landroid/net/wifi/ScanResult;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/blankj/utilcode/util/NetworkUtils$WifiScanResults;->allResults:Ljava/util/List;

    return-object v0
.end method

.method public getFilterResults()Ljava/util/List;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Landroid/net/wifi/ScanResult;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/blankj/utilcode/util/NetworkUtils$WifiScanResults;->filterResults:Ljava/util/List;

    return-object v0
.end method

.method public setAllResults(Ljava/util/List;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Landroid/net/wifi/ScanResult;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/blankj/utilcode/util/NetworkUtils$WifiScanResults;->allResults:Ljava/util/List;

    invoke-static {p1}, Lcom/blankj/utilcode/util/NetworkUtils$WifiScanResults;->filterScanResult(Ljava/util/List;)Ljava/util/List;

    move-result-object p1

    iput-object p1, p0, Lcom/blankj/utilcode/util/NetworkUtils$WifiScanResults;->filterResults:Ljava/util/List;

    return-void
.end method
