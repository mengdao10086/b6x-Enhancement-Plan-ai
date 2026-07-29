.class Lcom/google/android/material/checkbox/MaterialCheckBox$1;
.super Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;
.source "MaterialCheckBox.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/material/checkbox/MaterialCheckBox;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/android/material/checkbox/MaterialCheckBox;


# direct methods
.method constructor <init>(Lcom/google/android/material/checkbox/MaterialCheckBox;)V
    .registers 2

    iput-object p1, p0, Lcom/google/android/material/checkbox/MaterialCheckBox$1;->this$0:Lcom/google/android/material/checkbox/MaterialCheckBox;

    invoke-direct {p0}, Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/graphics/drawable/Drawable;)V
    .registers 3

    invoke-super {p0, p1}, Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;->onAnimationEnd(Landroid/graphics/drawable/Drawable;)V

    iget-object v0, p0, Lcom/google/android/material/checkbox/MaterialCheckBox$1;->this$0:Lcom/google/android/material/checkbox/MaterialCheckBox;

    iget-object v0, v0, Lcom/google/android/material/checkbox/MaterialCheckBox;->buttonTintList:Landroid/content/res/ColorStateList;

    if-eqz v0, :cond_10

    iget-object v0, p0, Lcom/google/android/material/checkbox/MaterialCheckBox$1;->this$0:Lcom/google/android/material/checkbox/MaterialCheckBox;

    iget-object v0, v0, Lcom/google/android/material/checkbox/MaterialCheckBox;->buttonTintList:Landroid/content/res/ColorStateList;

    invoke-static {p1, v0}, Landroidx/core/graphics/drawable/DrawableCompat;->setTintList(Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;)V

    :cond_10
    return-void
.end method

.method public onAnimationStart(Landroid/graphics/drawable/Drawable;)V
    .registers 5

    invoke-super {p0, p1}, Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;->onAnimationStart(Landroid/graphics/drawable/Drawable;)V

    iget-object v0, p0, Lcom/google/android/material/checkbox/MaterialCheckBox$1;->this$0:Lcom/google/android/material/checkbox/MaterialCheckBox;

    iget-object v0, v0, Lcom/google/android/material/checkbox/MaterialCheckBox;->buttonTintList:Landroid/content/res/ColorStateList;

    if-eqz v0, :cond_22

    iget-object v0, p0, Lcom/google/android/material/checkbox/MaterialCheckBox$1;->this$0:Lcom/google/android/material/checkbox/MaterialCheckBox;

    iget-object v0, v0, Lcom/google/android/material/checkbox/MaterialCheckBox;->buttonTintList:Landroid/content/res/ColorStateList;

    iget-object v1, p0, Lcom/google/android/material/checkbox/MaterialCheckBox$1;->this$0:Lcom/google/android/material/checkbox/MaterialCheckBox;

    # getter for: Lcom/google/android/material/checkbox/MaterialCheckBox;->currentStateChecked:[I
    invoke-static {v1}, Lcom/google/android/material/checkbox/MaterialCheckBox;->access$000(Lcom/google/android/material/checkbox/MaterialCheckBox;)[I

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/material/checkbox/MaterialCheckBox$1;->this$0:Lcom/google/android/material/checkbox/MaterialCheckBox;

    iget-object v2, v2, Lcom/google/android/material/checkbox/MaterialCheckBox;->buttonTintList:Landroid/content/res/ColorStateList;

    invoke-virtual {v2}, Landroid/content/res/ColorStateList;->getDefaultColor()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    move-result v0

    invoke-static {p1, v0}, Landroidx/core/graphics/drawable/DrawableCompat;->setTint(Landroid/graphics/drawable/Drawable;I)V

    :cond_22
    return-void
.end method
