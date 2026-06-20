.class public abstract Lcom/blankj/utilcode/util/ClickUtils$OnMultiClickListener;
.super Ljava/lang/Object;
.source "ClickUtils.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/blankj/utilcode/util/ClickUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "OnMultiClickListener"
.end annotation


# static fields
.field private static final INTERVAL_DEFAULT_VALUE:J = 0x29aL


# instance fields
.field private mClickCount:I

.field private final mClickInterval:J

.field private mLastClickTime:J

.field private final mTriggerClickCount:I


# direct methods
.method public constructor <init>(I)V
    .registers 4

    const-wide/16 v0, 0x29a

    .line 486
    invoke-direct {p0, p1, v0, v1}, Lcom/blankj/utilcode/util/ClickUtils$OnMultiClickListener;-><init>(IJ)V

    return-void
.end method

.method public constructor <init>(IJ)V
    .registers 4

    .line 489
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 490
    iput p1, p0, Lcom/blankj/utilcode/util/ClickUtils$OnMultiClickListener;->mTriggerClickCount:I

    .line 491
    iput-wide p2, p0, Lcom/blankj/utilcode/util/ClickUtils$OnMultiClickListener;->mClickInterval:J

    return-void
.end method


# virtual methods
.method public abstract onBeforeTriggerClick(Landroid/view/View;I)V
.end method

.method public onClick(Landroid/view/View;)V
    .registers 10

    .line 500
    iget v0, p0, Lcom/blankj/utilcode/util/ClickUtils$OnMultiClickListener;->mTriggerClickCount:I

    const/4 v1, 0x1

    if-gt v0, v1, :cond_9

    .line 501
    invoke-virtual {p0, p1}, Lcom/blankj/utilcode/util/ClickUtils$OnMultiClickListener;->onTriggerClick(Landroid/view/View;)V

    return-void

    .line 504
    :cond_9
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 506
    iget-wide v4, p0, Lcom/blankj/utilcode/util/ClickUtils$OnMultiClickListener;->mLastClickTime:J

    sub-long v4, v2, v4

    iget-wide v6, p0, Lcom/blankj/utilcode/util/ClickUtils$OnMultiClickListener;->mClickInterval:J

    cmp-long v0, v4, v6

    if-gez v0, :cond_30

    .line 507
    iget v0, p0, Lcom/blankj/utilcode/util/ClickUtils$OnMultiClickListener;->mClickCount:I

    add-int/2addr v0, v1

    iput v0, p0, Lcom/blankj/utilcode/util/ClickUtils$OnMultiClickListener;->mClickCount:I

    .line 508
    iget v4, p0, Lcom/blankj/utilcode/util/ClickUtils$OnMultiClickListener;->mTriggerClickCount:I

    if-ne v0, v4, :cond_24

    .line 509
    invoke-virtual {p0, p1}, Lcom/blankj/utilcode/util/ClickUtils$OnMultiClickListener;->onTriggerClick(Landroid/view/View;)V

    goto :goto_35

    :cond_24
    if-ge v0, v4, :cond_2a

    .line 511
    invoke-virtual {p0, p1, v0}, Lcom/blankj/utilcode/util/ClickUtils$OnMultiClickListener;->onBeforeTriggerClick(Landroid/view/View;I)V

    goto :goto_35

    .line 513
    :cond_2a
    iput v1, p0, Lcom/blankj/utilcode/util/ClickUtils$OnMultiClickListener;->mClickCount:I

    .line 514
    invoke-virtual {p0, p1, v1}, Lcom/blankj/utilcode/util/ClickUtils$OnMultiClickListener;->onBeforeTriggerClick(Landroid/view/View;I)V

    goto :goto_35

    .line 517
    :cond_30
    iput v1, p0, Lcom/blankj/utilcode/util/ClickUtils$OnMultiClickListener;->mClickCount:I

    .line 518
    invoke-virtual {p0, p1, v1}, Lcom/blankj/utilcode/util/ClickUtils$OnMultiClickListener;->onBeforeTriggerClick(Landroid/view/View;I)V

    .line 520
    :goto_35
    iput-wide v2, p0, Lcom/blankj/utilcode/util/ClickUtils$OnMultiClickListener;->mLastClickTime:J

    return-void
.end method

.method public abstract onTriggerClick(Landroid/view/View;)V
.end method
