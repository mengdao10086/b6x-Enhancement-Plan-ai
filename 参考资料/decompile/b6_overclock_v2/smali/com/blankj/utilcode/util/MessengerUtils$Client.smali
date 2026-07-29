.class Lcom/blankj/utilcode/util/MessengerUtils$Client;
.super Ljava/lang/Object;
.source "MessengerUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/blankj/utilcode/util/MessengerUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Client"
.end annotation


# instance fields
.field mCached:Ljava/util/LinkedList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedList<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation
.end field

.field mClient:Landroid/os/Messenger;

.field mConn:Landroid/content/ServiceConnection;

.field mPkgName:Ljava/lang/String;

.field mReceiveServeMsgHandler:Landroid/os/Handler;

.field mServer:Landroid/os/Messenger;


# direct methods
.method constructor <init>(Ljava/lang/String;)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/blankj/utilcode/util/MessengerUtils$Client;->mCached:Ljava/util/LinkedList;

    new-instance v0, Lcom/blankj/utilcode/util/MessengerUtils$Client$1;

    invoke-direct {v0, p0}, Lcom/blankj/utilcode/util/MessengerUtils$Client$1;-><init>(Lcom/blankj/utilcode/util/MessengerUtils$Client;)V

    iput-object v0, p0, Lcom/blankj/utilcode/util/MessengerUtils$Client;->mReceiveServeMsgHandler:Landroid/os/Handler;

    new-instance v0, Landroid/os/Messenger;

    iget-object v1, p0, Lcom/blankj/utilcode/util/MessengerUtils$Client;->mReceiveServeMsgHandler:Landroid/os/Handler;

    invoke-direct {v0, v1}, Landroid/os/Messenger;-><init>(Landroid/os/Handler;)V

    iput-object v0, p0, Lcom/blankj/utilcode/util/MessengerUtils$Client;->mClient:Landroid/os/Messenger;

    new-instance v0, Lcom/blankj/utilcode/util/MessengerUtils$Client$2;

    invoke-direct {v0, p0}, Lcom/blankj/utilcode/util/MessengerUtils$Client$2;-><init>(Lcom/blankj/utilcode/util/MessengerUtils$Client;)V

    iput-object v0, p0, Lcom/blankj/utilcode/util/MessengerUtils$Client;->mConn:Landroid/content/ServiceConnection;

    iput-object p1, p0, Lcom/blankj/utilcode/util/MessengerUtils$Client;->mPkgName:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$100(Lcom/blankj/utilcode/util/MessengerUtils$Client;)V
    .registers 1

    invoke-direct {p0}, Lcom/blankj/utilcode/util/MessengerUtils$Client;->sendCachedMsg2Server()V

    return-void
.end method

.method private send2Server(Landroid/os/Bundle;)Z
    .registers 4

    iget-object v0, p0, Lcom/blankj/utilcode/util/MessengerUtils$Client;->mReceiveServeMsgHandler:Landroid/os/Handler;

    const/4 v1, 0x2

    invoke-static {v0, v1}, Landroid/os/Message;->obtain(Landroid/os/Handler;I)Landroid/os/Message;

    move-result-object v0

    const-class v1, Lcom/blankj/utilcode/util/MessengerUtils;

    invoke-virtual {v1}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v1

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->setClassLoader(Ljava/lang/ClassLoader;)V

    invoke-virtual {v0, p1}, Landroid/os/Message;->setData(Landroid/os/Bundle;)V

    iget-object p1, p0, Lcom/blankj/utilcode/util/MessengerUtils$Client;->mClient:Landroid/os/Messenger;

    iput-object p1, v0, Landroid/os/Message;->replyTo:Landroid/os/Messenger;

    :try_start_17
    iget-object p1, p0, Lcom/blankj/utilcode/util/MessengerUtils$Client;->mServer:Landroid/os/Messenger;

    invoke-virtual {p1, v0}, Landroid/os/Messenger;->send(Landroid/os/Message;)V
    :try_end_1c
    .catch Landroid/os/RemoteException; {:try_start_17 .. :try_end_1c} :catch_1e

    const/4 p1, 0x1

    return p1

    :catch_1e
    move-exception p1

    invoke-virtual {p1}, Landroid/os/RemoteException;->printStackTrace()V

    const/4 p1, 0x0

    return p1
.end method

.method private sendCachedMsg2Server()V
    .registers 3

    iget-object v0, p0, Lcom/blankj/utilcode/util/MessengerUtils$Client;->mCached:Ljava/util/LinkedList;

    invoke-virtual {v0}, Ljava/util/LinkedList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_9

    return-void

    :cond_9
    iget-object v0, p0, Lcom/blankj/utilcode/util/MessengerUtils$Client;->mCached:Ljava/util/LinkedList;

    invoke-virtual {v0}, Ljava/util/LinkedList;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    :goto_11
    if-ltz v0, :cond_29

    iget-object v1, p0, Lcom/blankj/utilcode/util/MessengerUtils$Client;->mCached:Ljava/util/LinkedList;

    invoke-virtual {v1, v0}, Ljava/util/LinkedList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/os/Bundle;

    invoke-direct {p0, v1}, Lcom/blankj/utilcode/util/MessengerUtils$Client;->send2Server(Landroid/os/Bundle;)Z

    move-result v1

    if-eqz v1, :cond_26

    iget-object v1, p0, Lcom/blankj/utilcode/util/MessengerUtils$Client;->mCached:Ljava/util/LinkedList;

    invoke-virtual {v1, v0}, Ljava/util/LinkedList;->remove(I)Ljava/lang/Object;

    :cond_26
    add-int/lit8 v0, v0, -0x1

    goto :goto_11

    :cond_29
    return-void
.end method


# virtual methods
.method bind()Z
    .registers 5

    iget-object v0, p0, Lcom/blankj/utilcode/util/MessengerUtils$Client;->mPkgName:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    const/4 v1, 0x1

    if-eqz v0, :cond_1f

    new-instance v0, Landroid/content/Intent;

    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v2

    const-class v3, Lcom/blankj/utilcode/util/MessengerUtils$ServerService;

    invoke-direct {v0, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v2

    iget-object v3, p0, Lcom/blankj/utilcode/util/MessengerUtils$Client;->mConn:Landroid/content/ServiceConnection;

    invoke-virtual {v2, v0, v3, v1}, Landroid/app/Application;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    move-result v0

    return v0

    :cond_1f
    iget-object v0, p0, Lcom/blankj/utilcode/util/MessengerUtils$Client;->mPkgName:Ljava/lang/String;

    invoke-static {v0}, Lcom/blankj/utilcode/util/UtilsBridge;->isAppInstalled(Ljava/lang/String;)Z

    move-result v0

    const/4 v2, 0x0

    const-string v3, "MessengerUtils"

    if-eqz v0, :cond_71

    iget-object v0, p0, Lcom/blankj/utilcode/util/MessengerUtils$Client;->mPkgName:Ljava/lang/String;

    invoke-static {v0}, Lcom/blankj/utilcode/util/UtilsBridge;->isAppRunning(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_5c

    new-instance v0, Landroid/content/Intent;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/blankj/utilcode/util/MessengerUtils$Client;->mPkgName:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ".messenger"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/blankj/utilcode/util/MessengerUtils$Client;->mPkgName:Ljava/lang/String;

    invoke-virtual {v0, v2}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v2

    iget-object v3, p0, Lcom/blankj/utilcode/util/MessengerUtils$Client;->mConn:Landroid/content/ServiceConnection;

    invoke-virtual {v2, v0, v3, v1}, Landroid/app/Application;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    move-result v0

    return v0

    :cond_5c
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "bind: the app is not running -> "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/blankj/utilcode/util/MessengerUtils$Client;->mPkgName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    return v2

    :cond_71
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "bind: the app is not installed -> "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/blankj/utilcode/util/MessengerUtils$Client;->mPkgName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    return v2
.end method

.method sendMsg2Server(Landroid/os/Bundle;)V
    .registers 4

    iget-object v0, p0, Lcom/blankj/utilcode/util/MessengerUtils$Client;->mServer:Landroid/os/Messenger;

    if-nez v0, :cond_1e

    iget-object v0, p0, Lcom/blankj/utilcode/util/MessengerUtils$Client;->mCached:Ljava/util/LinkedList;

    invoke-virtual {v0, p1}, Ljava/util/LinkedList;->addFirst(Ljava/lang/Object;)V

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "save the bundle "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    const-string v0, "MessengerUtils"

    invoke-static {v0, p1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_2c

    :cond_1e
    invoke-direct {p0}, Lcom/blankj/utilcode/util/MessengerUtils$Client;->sendCachedMsg2Server()V

    invoke-direct {p0, p1}, Lcom/blankj/utilcode/util/MessengerUtils$Client;->send2Server(Landroid/os/Bundle;)Z

    move-result v0

    if-nez v0, :cond_2c

    iget-object v0, p0, Lcom/blankj/utilcode/util/MessengerUtils$Client;->mCached:Ljava/util/LinkedList;

    invoke-virtual {v0, p1}, Ljava/util/LinkedList;->addFirst(Ljava/lang/Object;)V

    :cond_2c
    :goto_2c
    return-void
.end method

.method unbind()V
    .registers 5

    invoke-static {}, Lcom/blankj/utilcode/util/UtilsBridge;->getCurrentProcessName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    iget-object v1, p0, Lcom/blankj/utilcode/util/MessengerUtils$Client;->mReceiveServeMsgHandler:Landroid/os/Handler;

    const/4 v2, 0x1

    const/4 v3, 0x0

    invoke-static {v1, v2, v0, v3}, Landroid/os/Message;->obtain(Landroid/os/Handler;III)Landroid/os/Message;

    move-result-object v0

    iget-object v1, p0, Lcom/blankj/utilcode/util/MessengerUtils$Client;->mClient:Landroid/os/Messenger;

    iput-object v1, v0, Landroid/os/Message;->replyTo:Landroid/os/Messenger;

    :try_start_14
    iget-object v1, p0, Lcom/blankj/utilcode/util/MessengerUtils$Client;->mServer:Landroid/os/Messenger;

    invoke-virtual {v1, v0}, Landroid/os/Messenger;->send(Landroid/os/Message;)V
    :try_end_19
    .catch Landroid/os/RemoteException; {:try_start_14 .. :try_end_19} :catch_1a

    goto :goto_1e

    :catch_1a
    move-exception v0

    invoke-virtual {v0}, Landroid/os/RemoteException;->printStackTrace()V

    :goto_1e
    :try_start_1e
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    iget-object v1, p0, Lcom/blankj/utilcode/util/MessengerUtils$Client;->mConn:Landroid/content/ServiceConnection;

    invoke-virtual {v0, v1}, Landroid/app/Application;->unbindService(Landroid/content/ServiceConnection;)V
    :try_end_27
    .catch Ljava/lang/Exception; {:try_start_1e .. :try_end_27} :catch_27

    :catch_27
    return-void
.end method
