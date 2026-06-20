.class Lcom/blankj/utilcode/util/NetworkUtils$9;
.super Ljava/lang/Object;
.source "NetworkUtils.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/blankj/utilcode/util/NetworkUtils;->removeOnWifiChangedConsumer(Lcom/blankj/utilcode/util/Utils$Consumer;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic val$consumer:Lcom/blankj/utilcode/util/Utils$Consumer;


# direct methods
.method constructor <init>(Lcom/blankj/utilcode/util/Utils$Consumer;)V
    .registers 2

    .line 822
    iput-object p1, p0, Lcom/blankj/utilcode/util/NetworkUtils$9;->val$consumer:Lcom/blankj/utilcode/util/Utils$Consumer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 3

    .line 825
    # getter for: Lcom/blankj/utilcode/util/NetworkUtils;->SCAN_RESULT_CONSUMERS:Ljava/util/Set;
    invoke-static {}, Lcom/blankj/utilcode/util/NetworkUtils;->access$100()Ljava/util/Set;

    move-result-object v0

    iget-object v1, p0, Lcom/blankj/utilcode/util/NetworkUtils$9;->val$consumer:Lcom/blankj/utilcode/util/Utils$Consumer;

    invoke-interface {v0, v1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 826
    # getter for: Lcom/blankj/utilcode/util/NetworkUtils;->SCAN_RESULT_CONSUMERS:Ljava/util/Set;
    invoke-static {}, Lcom/blankj/utilcode/util/NetworkUtils;->access$100()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_16

    .line 827
    # invokes: Lcom/blankj/utilcode/util/NetworkUtils;->stopScanWifi()V
    invoke-static {}, Lcom/blankj/utilcode/util/NetworkUtils;->access$700()V

    :cond_16
    return-void
.end method
