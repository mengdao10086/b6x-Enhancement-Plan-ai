.class Landroidx/databinding/ViewDataBinding$7;
.super Ljava/lang/Object;
.source "ViewDataBinding.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/databinding/ViewDataBinding;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroidx/databinding/ViewDataBinding;


# direct methods
.method constructor <init>(Landroidx/databinding/ViewDataBinding;)V
    .registers 2

    .line 201
    iput-object p1, p0, Landroidx/databinding/ViewDataBinding$7;->this$0:Landroidx/databinding/ViewDataBinding;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 3

    .line 204
    monitor-enter p0

    .line 205
    :try_start_1
    iget-object v0, p0, Landroidx/databinding/ViewDataBinding$7;->this$0:Landroidx/databinding/ViewDataBinding;

    const/4 v1, 0x0

    # setter for: Landroidx/databinding/ViewDataBinding;->mPendingRebind:Z
    invoke-static {v0, v1}, Landroidx/databinding/ViewDataBinding;->access$202(Landroidx/databinding/ViewDataBinding;Z)Z

    .line 206
    monitor-exit p0
    :try_end_8
    .catchall {:try_start_1 .. :try_end_8} :catchall_38

    .line 207
    # invokes: Landroidx/databinding/ViewDataBinding;->processReferenceQueue()V
    invoke-static {}, Landroidx/databinding/ViewDataBinding;->access$300()V

    .line 210
    iget-object v0, p0, Landroidx/databinding/ViewDataBinding$7;->this$0:Landroidx/databinding/ViewDataBinding;

    # getter for: Landroidx/databinding/ViewDataBinding;->mRoot:Landroid/view/View;
    invoke-static {v0}, Landroidx/databinding/ViewDataBinding;->access$400(Landroidx/databinding/ViewDataBinding;)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->isAttachedToWindow()Z

    move-result v0

    if-nez v0, :cond_32

    .line 213
    iget-object v0, p0, Landroidx/databinding/ViewDataBinding$7;->this$0:Landroidx/databinding/ViewDataBinding;

    # getter for: Landroidx/databinding/ViewDataBinding;->mRoot:Landroid/view/View;
    invoke-static {v0}, Landroidx/databinding/ViewDataBinding;->access$400(Landroidx/databinding/ViewDataBinding;)Landroid/view/View;

    move-result-object v0

    # getter for: Landroidx/databinding/ViewDataBinding;->ROOT_REATTACHED_LISTENER:Landroid/view/View$OnAttachStateChangeListener;
    invoke-static {}, Landroidx/databinding/ViewDataBinding;->access$500()Landroid/view/View$OnAttachStateChangeListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/View;->removeOnAttachStateChangeListener(Landroid/view/View$OnAttachStateChangeListener;)V

    .line 214
    iget-object v0, p0, Landroidx/databinding/ViewDataBinding$7;->this$0:Landroidx/databinding/ViewDataBinding;

    # getter for: Landroidx/databinding/ViewDataBinding;->mRoot:Landroid/view/View;
    invoke-static {v0}, Landroidx/databinding/ViewDataBinding;->access$400(Landroidx/databinding/ViewDataBinding;)Landroid/view/View;

    move-result-object v0

    # getter for: Landroidx/databinding/ViewDataBinding;->ROOT_REATTACHED_LISTENER:Landroid/view/View$OnAttachStateChangeListener;
    invoke-static {}, Landroidx/databinding/ViewDataBinding;->access$500()Landroid/view/View$OnAttachStateChangeListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/View;->addOnAttachStateChangeListener(Landroid/view/View$OnAttachStateChangeListener;)V

    return-void

    .line 218
    :cond_32
    iget-object v0, p0, Landroidx/databinding/ViewDataBinding$7;->this$0:Landroidx/databinding/ViewDataBinding;

    invoke-virtual {v0}, Landroidx/databinding/ViewDataBinding;->executePendingBindings()V

    return-void

    :catchall_38
    move-exception v0

    .line 206
    :try_start_39
    monitor-exit p0
    :try_end_3a
    .catchall {:try_start_39 .. :try_end_3a} :catchall_38

    throw v0
.end method
