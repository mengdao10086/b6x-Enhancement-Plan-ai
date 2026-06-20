.class public final Lcom/example/extool/generated/callback/OnProgressChanged;
.super Ljava/lang/Object;
.source "OnProgressChanged.java"

# interfaces
.implements Landroidx/databinding/adapters/SeekBarBindingAdapter$OnProgressChanged;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/example/extool/generated/callback/OnProgressChanged$Listener;
    }
.end annotation


# instance fields
.field final mListener:Lcom/example/extool/generated/callback/OnProgressChanged$Listener;

.field final mSourceId:I


# direct methods
.method public constructor <init>(Lcom/example/extool/generated/callback/OnProgressChanged$Listener;I)V
    .registers 3

    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 6
    iput-object p1, p0, Lcom/example/extool/generated/callback/OnProgressChanged;->mListener:Lcom/example/extool/generated/callback/OnProgressChanged$Listener;

    .line 7
    iput p2, p0, Lcom/example/extool/generated/callback/OnProgressChanged;->mSourceId:I

    return-void
.end method


# virtual methods
.method public onProgressChanged(Landroid/widget/SeekBar;IZ)V
    .registers 6

    .line 11
    iget-object v0, p0, Lcom/example/extool/generated/callback/OnProgressChanged;->mListener:Lcom/example/extool/generated/callback/OnProgressChanged$Listener;

    iget v1, p0, Lcom/example/extool/generated/callback/OnProgressChanged;->mSourceId:I

    invoke-interface {v0, v1, p1, p2, p3}, Lcom/example/extool/generated/callback/OnProgressChanged$Listener;->_internalCallbackOnProgressChanged(ILandroid/widget/SeekBar;IZ)V

    return-void
.end method
