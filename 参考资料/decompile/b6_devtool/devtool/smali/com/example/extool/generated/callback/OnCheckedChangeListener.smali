.class public final Lcom/example/extool/generated/callback/OnCheckedChangeListener;
.super Ljava/lang/Object;
.source "OnCheckedChangeListener.java"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/example/extool/generated/callback/OnCheckedChangeListener$Listener;
    }
.end annotation


# instance fields
.field final mListener:Lcom/example/extool/generated/callback/OnCheckedChangeListener$Listener;

.field final mSourceId:I


# direct methods
.method public constructor <init>(Lcom/example/extool/generated/callback/OnCheckedChangeListener$Listener;I)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/example/extool/generated/callback/OnCheckedChangeListener;->mListener:Lcom/example/extool/generated/callback/OnCheckedChangeListener$Listener;

    iput p2, p0, Lcom/example/extool/generated/callback/OnCheckedChangeListener;->mSourceId:I

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .registers 5

    iget-object v0, p0, Lcom/example/extool/generated/callback/OnCheckedChangeListener;->mListener:Lcom/example/extool/generated/callback/OnCheckedChangeListener$Listener;

    iget v1, p0, Lcom/example/extool/generated/callback/OnCheckedChangeListener;->mSourceId:I

    invoke-interface {v0, v1, p1, p2}, Lcom/example/extool/generated/callback/OnCheckedChangeListener$Listener;->_internalCallbackOnCheckedChanged(ILandroid/widget/CompoundButton;Z)V

    return-void
.end method
