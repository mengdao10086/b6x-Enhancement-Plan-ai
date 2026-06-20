.class Lcom/blankj/utilcode/util/ThreadUtils$Task$1;
.super Ljava/util/TimerTask;
.source "ThreadUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/blankj/utilcode/util/ThreadUtils$Task;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/blankj/utilcode/util/ThreadUtils$Task;


# direct methods
.method constructor <init>(Lcom/blankj/utilcode/util/ThreadUtils$Task;)V
    .registers 2

    .line 1214
    iput-object p1, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task$1;->this$0:Lcom/blankj/utilcode/util/ThreadUtils$Task;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 2

    .line 1217
    iget-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task$1;->this$0:Lcom/blankj/utilcode/util/ThreadUtils$Task;

    invoke-virtual {v0}, Lcom/blankj/utilcode/util/ThreadUtils$Task;->isDone()Z

    move-result v0

    if-nez v0, :cond_23

    iget-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task$1;->this$0:Lcom/blankj/utilcode/util/ThreadUtils$Task;

    # getter for: Lcom/blankj/utilcode/util/ThreadUtils$Task;->mTimeoutListener:Lcom/blankj/utilcode/util/ThreadUtils$Task$OnTimeoutListener;
    invoke-static {v0}, Lcom/blankj/utilcode/util/ThreadUtils$Task;->access$400(Lcom/blankj/utilcode/util/ThreadUtils$Task;)Lcom/blankj/utilcode/util/ThreadUtils$Task$OnTimeoutListener;

    move-result-object v0

    if-eqz v0, :cond_23

    .line 1218
    iget-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task$1;->this$0:Lcom/blankj/utilcode/util/ThreadUtils$Task;

    # invokes: Lcom/blankj/utilcode/util/ThreadUtils$Task;->timeout()V
    invoke-static {v0}, Lcom/blankj/utilcode/util/ThreadUtils$Task;->access$500(Lcom/blankj/utilcode/util/ThreadUtils$Task;)V

    .line 1219
    iget-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task$1;->this$0:Lcom/blankj/utilcode/util/ThreadUtils$Task;

    # getter for: Lcom/blankj/utilcode/util/ThreadUtils$Task;->mTimeoutListener:Lcom/blankj/utilcode/util/ThreadUtils$Task$OnTimeoutListener;
    invoke-static {v0}, Lcom/blankj/utilcode/util/ThreadUtils$Task;->access$400(Lcom/blankj/utilcode/util/ThreadUtils$Task;)Lcom/blankj/utilcode/util/ThreadUtils$Task$OnTimeoutListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/blankj/utilcode/util/ThreadUtils$Task$OnTimeoutListener;->onTimeout()V

    .line 1220
    iget-object v0, p0, Lcom/blankj/utilcode/util/ThreadUtils$Task$1;->this$0:Lcom/blankj/utilcode/util/ThreadUtils$Task;

    invoke-virtual {v0}, Lcom/blankj/utilcode/util/ThreadUtils$Task;->onDone()V

    :cond_23
    return-void
.end method
