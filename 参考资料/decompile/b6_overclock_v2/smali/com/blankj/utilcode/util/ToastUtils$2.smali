.class Lcom/blankj/utilcode/util/ToastUtils$2;
.super Ljava/lang/Object;
.source "ToastUtils.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/blankj/utilcode/util/ToastUtils;->show(Landroid/view/View;Ljava/lang/CharSequence;ILcom/blankj/utilcode/util/ToastUtils;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic val$duration:I

.field final synthetic val$text:Ljava/lang/CharSequence;

.field final synthetic val$utils:Lcom/blankj/utilcode/util/ToastUtils;

.field final synthetic val$view:Landroid/view/View;


# direct methods
.method constructor <init>(Lcom/blankj/utilcode/util/ToastUtils;Landroid/view/View;Ljava/lang/CharSequence;I)V
    .registers 5

    iput-object p1, p0, Lcom/blankj/utilcode/util/ToastUtils$2;->val$utils:Lcom/blankj/utilcode/util/ToastUtils;

    iput-object p2, p0, Lcom/blankj/utilcode/util/ToastUtils$2;->val$view:Landroid/view/View;

    iput-object p3, p0, Lcom/blankj/utilcode/util/ToastUtils$2;->val$text:Ljava/lang/CharSequence;

    iput p4, p0, Lcom/blankj/utilcode/util/ToastUtils$2;->val$duration:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 3

    invoke-static {}, Lcom/blankj/utilcode/util/ToastUtils;->cancel()V

    iget-object v0, p0, Lcom/blankj/utilcode/util/ToastUtils$2;->val$utils:Lcom/blankj/utilcode/util/ToastUtils;

    # invokes: Lcom/blankj/utilcode/util/ToastUtils;->newToast(Lcom/blankj/utilcode/util/ToastUtils;)Lcom/blankj/utilcode/util/ToastUtils$IToast;
    invoke-static {v0}, Lcom/blankj/utilcode/util/ToastUtils;->access$100(Lcom/blankj/utilcode/util/ToastUtils;)Lcom/blankj/utilcode/util/ToastUtils$IToast;

    move-result-object v0

    new-instance v1, Ljava/lang/ref/WeakReference;

    invoke-direct {v1, v0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    # setter for: Lcom/blankj/utilcode/util/ToastUtils;->sWeakToast:Ljava/lang/ref/WeakReference;
    invoke-static {v1}, Lcom/blankj/utilcode/util/ToastUtils;->access$002(Ljava/lang/ref/WeakReference;)Ljava/lang/ref/WeakReference;

    iget-object v1, p0, Lcom/blankj/utilcode/util/ToastUtils$2;->val$view:Landroid/view/View;

    if-eqz v1, :cond_19

    invoke-interface {v0, v1}, Lcom/blankj/utilcode/util/ToastUtils$IToast;->setToastView(Landroid/view/View;)V

    goto :goto_1e

    :cond_19
    iget-object v1, p0, Lcom/blankj/utilcode/util/ToastUtils$2;->val$text:Ljava/lang/CharSequence;

    invoke-interface {v0, v1}, Lcom/blankj/utilcode/util/ToastUtils$IToast;->setToastView(Ljava/lang/CharSequence;)V

    :goto_1e
    iget v1, p0, Lcom/blankj/utilcode/util/ToastUtils$2;->val$duration:I

    invoke-interface {v0, v1}, Lcom/blankj/utilcode/util/ToastUtils$IToast;->show(I)V

    return-void
.end method
