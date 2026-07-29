.class Landroidx/databinding/ViewDataBinding$5;
.super Landroidx/databinding/CallbackRegistry$NotifierCallback;
.source "ViewDataBinding.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/databinding/ViewDataBinding;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroidx/databinding/CallbackRegistry$NotifierCallback<",
        "Landroidx/databinding/OnRebindCallback;",
        "Landroidx/databinding/ViewDataBinding;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .line 153
    invoke-direct {p0}, Landroidx/databinding/CallbackRegistry$NotifierCallback;-><init>()V

    return-void
.end method


# virtual methods
.method public onNotifyCallback(Landroidx/databinding/OnRebindCallback;Landroidx/databinding/ViewDataBinding;ILjava/lang/Void;)V
    .registers 5

    const/4 p4, 0x1

    if-eq p3, p4, :cond_12

    const/4 p4, 0x2

    if-eq p3, p4, :cond_e

    const/4 p4, 0x3

    if-eq p3, p4, :cond_a

    goto :goto_1b

    .line 167
    :cond_a
    invoke-virtual {p1, p2}, Landroidx/databinding/OnRebindCallback;->onBound(Landroidx/databinding/ViewDataBinding;)V

    goto :goto_1b

    .line 164
    :cond_e
    invoke-virtual {p1, p2}, Landroidx/databinding/OnRebindCallback;->onCanceled(Landroidx/databinding/ViewDataBinding;)V

    goto :goto_1b

    .line 159
    :cond_12
    invoke-virtual {p1, p2}, Landroidx/databinding/OnRebindCallback;->onPreBind(Landroidx/databinding/ViewDataBinding;)Z

    move-result p1

    if-nez p1, :cond_1b

    .line 160
    # setter for: Landroidx/databinding/ViewDataBinding;->mRebindHalted:Z
    invoke-static {p2, p4}, Landroidx/databinding/ViewDataBinding;->access$002(Landroidx/databinding/ViewDataBinding;Z)Z

    :cond_1b
    :goto_1b
    return-void
.end method

.method public bridge synthetic onNotifyCallback(Ljava/lang/Object;Ljava/lang/Object;ILjava/lang/Object;)V
    .registers 5

    .line 153
    check-cast p1, Landroidx/databinding/OnRebindCallback;

    check-cast p2, Landroidx/databinding/ViewDataBinding;

    check-cast p4, Ljava/lang/Void;

    invoke-virtual {p0, p1, p2, p3, p4}, Landroidx/databinding/ViewDataBinding$5;->onNotifyCallback(Landroidx/databinding/OnRebindCallback;Landroidx/databinding/ViewDataBinding;ILjava/lang/Void;)V

    return-void
.end method
