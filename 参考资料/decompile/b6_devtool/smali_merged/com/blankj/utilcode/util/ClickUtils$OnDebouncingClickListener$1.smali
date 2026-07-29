.class Lcom/blankj/utilcode/util/ClickUtils$OnDebouncingClickListener$1;
.super Ljava/lang/Object;
.source "ClickUtils.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/blankj/utilcode/util/ClickUtils$OnDebouncingClickListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .line 426
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 2

    const/4 v0, 0x1

    .line 429
    # setter for: Lcom/blankj/utilcode/util/ClickUtils$OnDebouncingClickListener;->mEnabled:Z
    invoke-static {v0}, Lcom/blankj/utilcode/util/ClickUtils$OnDebouncingClickListener;->access$002(Z)Z

    return-void
.end method
