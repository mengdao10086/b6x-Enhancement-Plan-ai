.class public Lcom/blankj/utilcode/util/MessengerUtils;
.super Ljava/lang/Object;
.source "MessengerUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/blankj/utilcode/util/MessengerUtils$MessageCallback;,
        Lcom/blankj/utilcode/util/MessengerUtils$ServerService;,
        Lcom/blankj/utilcode/util/MessengerUtils$Client;
    }
.end annotation


# static fields
.field private static final KEY_STRING:Ljava/lang/String; = "MESSENGER_UTILS"

.field private static final WHAT_SEND:I = 0x2

.field private static final WHAT_SUBSCRIBE:I = 0x0

.field private static final WHAT_UNSUBSCRIBE:I = 0x1

.field private static sClientMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Lcom/blankj/utilcode/util/MessengerUtils$Client;",
            ">;"
        }
    .end annotation
.end field

.field private static sLocalClient:Lcom/blankj/utilcode/util/MessengerUtils$Client;

.field private static subscribers:Ljava/util/concurrent/ConcurrentHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentHashMap<",
            "Ljava/lang/String;",
            "Lcom/blankj/utilcode/util/MessengerUtils$MessageCallback;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .line 42
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    sput-object v0, Lcom/blankj/utilcode/util/MessengerUtils;->subscribers:Ljava/util/concurrent/ConcurrentHashMap;

    .line 44
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/blankj/utilcode/util/MessengerUtils;->sClientMap:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000()Ljava/util/concurrent/ConcurrentHashMap;
    .registers 1

    .line 40
    sget-object v0, Lcom/blankj/utilcode/util/MessengerUtils;->subscribers:Ljava/util/concurrent/ConcurrentHashMap;

    return-object v0
.end method

.method public static post(Ljava/lang/String;Landroid/os/Bundle;)V
    .registers 4

    const-string v0, "MESSENGER_UTILS"

    .line 121
    invoke-virtual {p1, v0, p0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 122
    sget-object p0, Lcom/blankj/utilcode/util/MessengerUtils;->sLocalClient:Lcom/blankj/utilcode/util/MessengerUtils$Client;

    if-eqz p0, :cond_d

    .line 123
    invoke-virtual {p0, p1}, Lcom/blankj/utilcode/util/MessengerUtils$Client;->sendMsg2Server(Landroid/os/Bundle;)V

    goto :goto_1e

    .line 125
    :cond_d
    new-instance p0, Landroid/content/Intent;

    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    const-class v1, Lcom/blankj/utilcode/util/MessengerUtils$ServerService;

    invoke-direct {p0, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 126
    invoke-virtual {p0, p1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 127
    invoke-static {p0}, Lcom/blankj/utilcode/util/MessengerUtils;->startServiceCompat(Landroid/content/Intent;)V

    .line 129
    :goto_1e
    sget-object p0, Lcom/blankj/utilcode/util/MessengerUtils;->sClientMap:Ljava/util/Map;

    invoke-interface {p0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object p0

    invoke-interface {p0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :goto_28
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_38

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/blankj/utilcode/util/MessengerUtils$Client;

    .line 130
    invoke-virtual {v0, p1}, Lcom/blankj/utilcode/util/MessengerUtils$Client;->sendMsg2Server(Landroid/os/Bundle;)V

    goto :goto_28

    :cond_38
    return-void
.end method

.method public static register()V
    .registers 3

    .line 53
    invoke-static {}, Lcom/blankj/utilcode/util/UtilsBridge;->isMainProcess()Z

    move-result v0

    const-string v1, "MessengerUtils"

    if-eqz v0, :cond_29

    .line 54
    const-class v0, Lcom/blankj/utilcode/util/MessengerUtils$ServerService;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/blankj/utilcode/util/UtilsBridge;->isServiceRunning(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1a

    const-string v0, "Server service is running."

    .line 55
    invoke-static {v1, v0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    return-void

    .line 58
    :cond_1a
    new-instance v0, Landroid/content/Intent;

    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v1

    const-class v2, Lcom/blankj/utilcode/util/MessengerUtils$ServerService;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-static {v0}, Lcom/blankj/utilcode/util/MessengerUtils;->startServiceCompat(Landroid/content/Intent;)V

    return-void

    .line 61
    :cond_29
    sget-object v0, Lcom/blankj/utilcode/util/MessengerUtils;->sLocalClient:Lcom/blankj/utilcode/util/MessengerUtils$Client;

    if-nez v0, :cond_42

    .line 62
    new-instance v0, Lcom/blankj/utilcode/util/MessengerUtils$Client;

    const/4 v2, 0x0

    invoke-direct {v0, v2}, Lcom/blankj/utilcode/util/MessengerUtils$Client;-><init>(Ljava/lang/String;)V

    .line 63
    invoke-virtual {v0}, Lcom/blankj/utilcode/util/MessengerUtils$Client;->bind()Z

    move-result v2

    if-eqz v2, :cond_3c

    .line 64
    sput-object v0, Lcom/blankj/utilcode/util/MessengerUtils;->sLocalClient:Lcom/blankj/utilcode/util/MessengerUtils$Client;

    goto :goto_47

    :cond_3c
    const-string v0, "Bind service failed."

    .line 66
    invoke-static {v1, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_47

    :cond_42
    const-string v0, "The client have been bind."

    .line 69
    invoke-static {v1, v0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    :goto_47
    return-void
.end method

.method public static register(Ljava/lang/String;)V
    .registers 4

    .line 88
    sget-object v0, Lcom/blankj/utilcode/util/MessengerUtils;->sClientMap:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    const-string v1, "MessengerUtils"

    if-eqz v0, :cond_1d

    .line 89
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v2, "register: client registered: "

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-static {v1, p0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    return-void

    .line 92
    :cond_1d
    new-instance v0, Lcom/blankj/utilcode/util/MessengerUtils$Client;

    invoke-direct {v0, p0}, Lcom/blankj/utilcode/util/MessengerUtils$Client;-><init>(Ljava/lang/String;)V

    .line 93
    invoke-virtual {v0}, Lcom/blankj/utilcode/util/MessengerUtils$Client;->bind()Z

    move-result v2

    if-eqz v2, :cond_2e

    .line 94
    sget-object v1, Lcom/blankj/utilcode/util/MessengerUtils;->sClientMap:Ljava/util/Map;

    invoke-interface {v1, p0, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_40

    .line 96
    :cond_2e
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v2, "register: client bind failed: "

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-static {v1, p0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    :goto_40
    return-void
.end method

.method private static startServiceCompat(Landroid/content/Intent;)V
    .registers 2

    const/16 v0, 0x20

    .line 136
    :try_start_2
    invoke-virtual {p0, v0}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 138
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/app/Application;->startForegroundService(Landroid/content/Intent;)Landroid/content/ComponentName;
    :try_end_c
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_c} :catch_d

    goto :goto_11

    :catch_d
    move-exception p0

    .line 143
    invoke-virtual {p0}, Ljava/lang/Exception;->printStackTrace()V

    :goto_11
    return-void
.end method

.method public static subscribe(Ljava/lang/String;Lcom/blankj/utilcode/util/MessengerUtils$MessageCallback;)V
    .registers 3

    .line 113
    sget-object v0, Lcom/blankj/utilcode/util/MessengerUtils;->subscribers:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v0, p0, p1}, Ljava/util/concurrent/ConcurrentHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public static unregister()V
    .registers 3

    .line 74
    invoke-static {}, Lcom/blankj/utilcode/util/UtilsBridge;->isMainProcess()Z

    move-result v0

    if-eqz v0, :cond_2c

    .line 75
    const-class v0, Lcom/blankj/utilcode/util/MessengerUtils$ServerService;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/blankj/utilcode/util/UtilsBridge;->isServiceRunning(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1a

    const-string v0, "MessengerUtils"

    const-string v1, "Server service isn\'t running."

    .line 76
    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    return-void

    .line 79
    :cond_1a
    new-instance v0, Landroid/content/Intent;

    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v1

    const-class v2, Lcom/blankj/utilcode/util/MessengerUtils$ServerService;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 80
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/app/Application;->stopService(Landroid/content/Intent;)Z

    .line 82
    :cond_2c
    sget-object v0, Lcom/blankj/utilcode/util/MessengerUtils;->sLocalClient:Lcom/blankj/utilcode/util/MessengerUtils$Client;

    if-eqz v0, :cond_33

    .line 83
    invoke-virtual {v0}, Lcom/blankj/utilcode/util/MessengerUtils$Client;->unbind()V

    :cond_33
    return-void
.end method

.method public static unregister(Ljava/lang/String;)V
    .registers 3

    .line 101
    sget-object v0, Lcom/blankj/utilcode/util/MessengerUtils;->sClientMap:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1d

    .line 102
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "unregister: client didn\'t register: "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    const-string v0, "MessengerUtils"

    invoke-static {v0, p0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    return-void

    .line 105
    :cond_1d
    sget-object v0, Lcom/blankj/utilcode/util/MessengerUtils;->sClientMap:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/blankj/utilcode/util/MessengerUtils$Client;

    .line 106
    sget-object v1, Lcom/blankj/utilcode/util/MessengerUtils;->sClientMap:Ljava/util/Map;

    invoke-interface {v1, p0}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    if-eqz v0, :cond_2f

    .line 108
    invoke-virtual {v0}, Lcom/blankj/utilcode/util/MessengerUtils$Client;->unbind()V

    :cond_2f
    return-void
.end method

.method public static unsubscribe(Ljava/lang/String;)V
    .registers 2

    .line 117
    sget-object v0, Lcom/blankj/utilcode/util/MessengerUtils;->subscribers:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v0, p0}, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method
