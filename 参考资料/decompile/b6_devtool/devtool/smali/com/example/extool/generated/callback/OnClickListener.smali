.class public final Lcom/example/extool/generated/callback/OnClickListener;
.super Ljava/lang/Object;
.source "OnClickListener.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/example/extool/generated/callback/OnClickListener$Listener;
    }
.end annotation


# instance fields
.field final mListener:Lcom/example/extool/generated/callback/OnClickListener$Listener;

.field final mSourceId:I


# direct methods
.method public constructor <init>(Lcom/example/extool/generated/callback/OnClickListener$Listener;I)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/example/extool/generated/callback/OnClickListener;->mListener:Lcom/example/extool/generated/callback/OnClickListener$Listener;

    iput p2, p0, Lcom/example/extool/generated/callback/OnClickListener;->mSourceId:I

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .registers 4

    iget-object v0, p0, Lcom/example/extool/generated/callback/OnClickListener;->mListener:Lcom/example/extool/generated/callback/OnClickListener$Listener;

    iget v1, p0, Lcom/example/extool/generated/callback/OnClickListener;->mSourceId:I

    invoke-interface {v0, v1, p1}, Lcom/example/extool/generated/callback/OnClickListener$Listener;->_internalCallbackOnClick(ILandroid/view/View;)V

    return-void
.end method
