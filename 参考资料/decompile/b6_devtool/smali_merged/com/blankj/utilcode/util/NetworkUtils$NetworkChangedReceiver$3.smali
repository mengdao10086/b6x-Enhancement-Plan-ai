.class Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver$3;
.super Ljava/lang/Object;
.source "NetworkUtils.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;


# direct methods
.method constructor <init>(Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;)V
    .registers 2

    .line 917
    iput-object p1, p0, Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver$3;->this$0:Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 4

    .line 921
    invoke-static {}, Lcom/blankj/utilcode/util/NetworkUtils;->getNetworkType()Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;

    move-result-object v0

    .line 922
    iget-object v1, p0, Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver$3;->this$0:Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;

    # getter for: Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;->mType:Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;
    invoke-static {v1}, Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;->access$1000(Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;)Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;

    move-result-object v1

    if-ne v1, v0, :cond_d

    return-void

    .line 923
    :cond_d
    iget-object v1, p0, Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver$3;->this$0:Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;

    # setter for: Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;->mType:Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;
    invoke-static {v1, v0}, Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;->access$1002(Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;)Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;

    .line 924
    sget-object v1, Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;->NETWORK_NO:Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;

    if-ne v0, v1, :cond_30

    .line 925
    iget-object v0, p0, Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver$3;->this$0:Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;

    # getter for: Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;->mListeners:Ljava/util/Set;
    invoke-static {v0}, Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;->access$900(Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;)Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_20
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_4a

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/blankj/utilcode/util/NetworkUtils$OnNetworkStatusChangedListener;

    .line 926
    invoke-interface {v1}, Lcom/blankj/utilcode/util/NetworkUtils$OnNetworkStatusChangedListener;->onDisconnected()V

    goto :goto_20

    .line 929
    :cond_30
    iget-object v1, p0, Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver$3;->this$0:Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;

    # getter for: Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;->mListeners:Ljava/util/Set;
    invoke-static {v1}, Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;->access$900(Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;)Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_3a
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_4a

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/blankj/utilcode/util/NetworkUtils$OnNetworkStatusChangedListener;

    .line 930
    invoke-interface {v2, v0}, Lcom/blankj/utilcode/util/NetworkUtils$OnNetworkStatusChangedListener;->onConnected(Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;)V

    goto :goto_3a

    :cond_4a
    return-void
.end method
