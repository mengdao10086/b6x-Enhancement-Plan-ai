.class Lcom/blankj/utilcode/util/MessengerUtils$ServerService$1;
.super Landroid/os/Handler;
.source "MessengerUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/blankj/utilcode/util/MessengerUtils$ServerService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/blankj/utilcode/util/MessengerUtils$ServerService;


# direct methods
.method constructor <init>(Lcom/blankj/utilcode/util/MessengerUtils$ServerService;)V
    .registers 2

    .line 275
    iput-object p1, p0, Lcom/blankj/utilcode/util/MessengerUtils$ServerService$1;->this$0:Lcom/blankj/utilcode/util/MessengerUtils$ServerService;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .registers 4

    .line 278
    iget v0, p1, Landroid/os/Message;->what:I

    if-eqz v0, :cond_29

    const/4 v1, 0x1

    if-eq v0, v1, :cond_19

    const/4 v1, 0x2

    if-eq v0, v1, :cond_e

    .line 290
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    goto :goto_3a

    .line 283
    :cond_e
    iget-object v0, p0, Lcom/blankj/utilcode/util/MessengerUtils$ServerService$1;->this$0:Lcom/blankj/utilcode/util/MessengerUtils$ServerService;

    # invokes: Lcom/blankj/utilcode/util/MessengerUtils$ServerService;->sendMsg2Client(Landroid/os/Message;)V
    invoke-static {v0, p1}, Lcom/blankj/utilcode/util/MessengerUtils$ServerService;->access$300(Lcom/blankj/utilcode/util/MessengerUtils$ServerService;Landroid/os/Message;)V

    .line 284
    iget-object v0, p0, Lcom/blankj/utilcode/util/MessengerUtils$ServerService$1;->this$0:Lcom/blankj/utilcode/util/MessengerUtils$ServerService;

    # invokes: Lcom/blankj/utilcode/util/MessengerUtils$ServerService;->consumeServerProcessCallback(Landroid/os/Message;)V
    invoke-static {v0, p1}, Lcom/blankj/utilcode/util/MessengerUtils$ServerService;->access$400(Lcom/blankj/utilcode/util/MessengerUtils$ServerService;Landroid/os/Message;)V

    goto :goto_3a

    .line 287
    :cond_19
    iget-object v0, p0, Lcom/blankj/utilcode/util/MessengerUtils$ServerService$1;->this$0:Lcom/blankj/utilcode/util/MessengerUtils$ServerService;

    # getter for: Lcom/blankj/utilcode/util/MessengerUtils$ServerService;->mClientMap:Ljava/util/concurrent/ConcurrentHashMap;
    invoke-static {v0}, Lcom/blankj/utilcode/util/MessengerUtils$ServerService;->access$200(Lcom/blankj/utilcode/util/MessengerUtils$ServerService;)Ljava/util/concurrent/ConcurrentHashMap;

    move-result-object v0

    iget p1, p1, Landroid/os/Message;->arg1:I

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-virtual {v0, p1}, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_3a

    .line 280
    :cond_29
    iget-object v0, p0, Lcom/blankj/utilcode/util/MessengerUtils$ServerService$1;->this$0:Lcom/blankj/utilcode/util/MessengerUtils$ServerService;

    # getter for: Lcom/blankj/utilcode/util/MessengerUtils$ServerService;->mClientMap:Ljava/util/concurrent/ConcurrentHashMap;
    invoke-static {v0}, Lcom/blankj/utilcode/util/MessengerUtils$ServerService;->access$200(Lcom/blankj/utilcode/util/MessengerUtils$ServerService;)Ljava/util/concurrent/ConcurrentHashMap;

    move-result-object v0

    iget v1, p1, Landroid/os/Message;->arg1:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    iget-object p1, p1, Landroid/os/Message;->replyTo:Landroid/os/Messenger;

    invoke-virtual {v0, v1, p1}, Ljava/util/concurrent/ConcurrentHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :goto_3a
    return-void
.end method
