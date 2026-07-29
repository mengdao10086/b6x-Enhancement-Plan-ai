.class Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior$1;
.super Ljava/lang/Object;
.source "BottomAppBar.java"

# interfaces
.implements Landroid/view/View$OnLayoutChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;


# direct methods
.method constructor <init>(Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;)V
    .registers 2

    iput-object p1, p0, Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior$1;->this$0:Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLayoutChange(Landroid/view/View;IIIIIIII)V
    .registers 10

    iget-object p2, p0, Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior$1;->this$0:Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;

    # getter for: Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;->viewRef:Ljava/lang/ref/WeakReference;
    invoke-static {p2}, Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;->access$2500(Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;)Ljava/lang/ref/WeakReference;

    move-result-object p2

    invoke-virtual {p2}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lcom/google/android/material/bottomappbar/BottomAppBar;

    if-eqz p2, :cond_be

    instance-of p3, p1, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;

    if-nez p3, :cond_18

    instance-of p4, p1, Lcom/google/android/material/floatingactionbutton/ExtendedFloatingActionButton;

    if-nez p4, :cond_18

    goto/16 :goto_be

    :cond_18
    invoke-virtual {p1}, Landroid/view/View;->getHeight()I

    move-result p4

    if-eqz p3, :cond_51

    move-object p3, p1

    check-cast p3, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;

    iget-object p4, p0, Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior$1;->this$0:Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;

    # getter for: Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;->fabContentRect:Landroid/graphics/Rect;
    invoke-static {p4}, Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;->access$2600(Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;)Landroid/graphics/Rect;

    move-result-object p4

    invoke-virtual {p3, p4}, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;->getMeasuredContentRect(Landroid/graphics/Rect;)V

    iget-object p4, p0, Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior$1;->this$0:Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;

    # getter for: Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;->fabContentRect:Landroid/graphics/Rect;
    invoke-static {p4}, Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;->access$2600(Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;)Landroid/graphics/Rect;

    move-result-object p4

    invoke-virtual {p4}, Landroid/graphics/Rect;->height()I

    move-result p4

    invoke-virtual {p2, p4}, Lcom/google/android/material/bottomappbar/BottomAppBar;->setFabDiameter(I)Z

    invoke-virtual {p3}, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;->getShapeAppearanceModel()Lcom/google/android/material/shape/ShapeAppearanceModel;

    move-result-object p3

    invoke-virtual {p3}, Lcom/google/android/material/shape/ShapeAppearanceModel;->getTopLeftCornerSize()Lcom/google/android/material/shape/CornerSize;

    move-result-object p3

    new-instance p5, Landroid/graphics/RectF;

    iget-object p6, p0, Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior$1;->this$0:Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;

    # getter for: Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;->fabContentRect:Landroid/graphics/Rect;
    invoke-static {p6}, Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;->access$2600(Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;)Landroid/graphics/Rect;

    move-result-object p6

    invoke-direct {p5, p6}, Landroid/graphics/RectF;-><init>(Landroid/graphics/Rect;)V

    invoke-interface {p3, p5}, Lcom/google/android/material/shape/CornerSize;->getCornerSize(Landroid/graphics/RectF;)F

    move-result p3

    invoke-virtual {p2, p3}, Lcom/google/android/material/bottomappbar/BottomAppBar;->setFabCornerSize(F)V

    :cond_51
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object p3

    check-cast p3, Landroidx/coordinatorlayout/widget/CoordinatorLayout$LayoutParams;

    iget-object p5, p0, Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior$1;->this$0:Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;

    # getter for: Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;->originalBottomMargin:I
    invoke-static {p5}, Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;->access$2700(Lcom/google/android/material/bottomappbar/BottomAppBar$Behavior;)I

    move-result p5

    if-nez p5, :cond_bd

    invoke-virtual {p1}, Landroid/view/View;->getMeasuredHeight()I

    move-result p5

    sub-int/2addr p5, p4

    div-int/lit8 p5, p5, 0x2

    # getter for: Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAnchorMode:I
    invoke-static {p2}, Lcom/google/android/material/bottomappbar/BottomAppBar;->access$400(Lcom/google/android/material/bottomappbar/BottomAppBar;)I

    move-result p4

    const/4 p6, 0x1

    if-ne p4, p6, :cond_80

    invoke-virtual {p2}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getResources()Landroid/content/res/Resources;

    move-result-object p4

    sget p6, Lcom/google/android/material/R$dimen;->mtrl_bottomappbar_fab_bottom_margin:I

    invoke-virtual {p4, p6}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result p4

    sub-int/2addr p4, p5

    # invokes: Lcom/google/android/material/bottomappbar/BottomAppBar;->getBottomInset()I
    invoke-static {p2}, Lcom/google/android/material/bottomappbar/BottomAppBar;->access$2800(Lcom/google/android/material/bottomappbar/BottomAppBar;)I

    move-result p5

    add-int/2addr p5, p4

    iput p5, p3, Landroidx/coordinatorlayout/widget/CoordinatorLayout$LayoutParams;->bottomMargin:I

    goto :goto_98

    :cond_80
    # getter for: Lcom/google/android/material/bottomappbar/BottomAppBar;->fabAnchorMode:I
    invoke-static {p2}, Lcom/google/android/material/bottomappbar/BottomAppBar;->access$400(Lcom/google/android/material/bottomappbar/BottomAppBar;)I

    move-result p4

    if-nez p4, :cond_98

    invoke-virtual {p2}, Lcom/google/android/material/bottomappbar/BottomAppBar;->getMeasuredHeight()I

    move-result p4

    # invokes: Lcom/google/android/material/bottomappbar/BottomAppBar;->getBottomInset()I
    invoke-static {p2}, Lcom/google/android/material/bottomappbar/BottomAppBar;->access$2800(Lcom/google/android/material/bottomappbar/BottomAppBar;)I

    move-result p5

    add-int/2addr p4, p5

    invoke-virtual {p1}, Landroid/view/View;->getMeasuredHeight()I

    move-result p5

    sub-int/2addr p4, p5

    div-int/lit8 p4, p4, 0x2

    iput p4, p3, Landroidx/coordinatorlayout/widget/CoordinatorLayout$LayoutParams;->bottomMargin:I

    :cond_98
    :goto_98
    # invokes: Lcom/google/android/material/bottomappbar/BottomAppBar;->getLeftInset()I
    invoke-static {p2}, Lcom/google/android/material/bottomappbar/BottomAppBar;->access$2900(Lcom/google/android/material/bottomappbar/BottomAppBar;)I

    move-result p4

    iput p4, p3, Landroidx/coordinatorlayout/widget/CoordinatorLayout$LayoutParams;->leftMargin:I

    # invokes: Lcom/google/android/material/bottomappbar/BottomAppBar;->getRightInset()I
    invoke-static {p2}, Lcom/google/android/material/bottomappbar/BottomAppBar;->access$3000(Lcom/google/android/material/bottomappbar/BottomAppBar;)I

    move-result p4

    iput p4, p3, Landroidx/coordinatorlayout/widget/CoordinatorLayout$LayoutParams;->rightMargin:I

    invoke-static {p1}, Lcom/google/android/material/internal/ViewUtils;->isLayoutRtl(Landroid/view/View;)Z

    move-result p1

    if-eqz p1, :cond_b4

    iget p1, p3, Landroidx/coordinatorlayout/widget/CoordinatorLayout$LayoutParams;->leftMargin:I

    # getter for: Lcom/google/android/material/bottomappbar/BottomAppBar;->fabOffsetEndMode:I
    invoke-static {p2}, Lcom/google/android/material/bottomappbar/BottomAppBar;->access$3100(Lcom/google/android/material/bottomappbar/BottomAppBar;)I

    move-result p2

    add-int/2addr p1, p2

    iput p1, p3, Landroidx/coordinatorlayout/widget/CoordinatorLayout$LayoutParams;->leftMargin:I

    goto :goto_bd

    :cond_b4
    iget p1, p3, Landroidx/coordinatorlayout/widget/CoordinatorLayout$LayoutParams;->rightMargin:I

    # getter for: Lcom/google/android/material/bottomappbar/BottomAppBar;->fabOffsetEndMode:I
    invoke-static {p2}, Lcom/google/android/material/bottomappbar/BottomAppBar;->access$3100(Lcom/google/android/material/bottomappbar/BottomAppBar;)I

    move-result p2

    add-int/2addr p1, p2

    iput p1, p3, Landroidx/coordinatorlayout/widget/CoordinatorLayout$LayoutParams;->rightMargin:I

    :cond_bd
    :goto_bd
    return-void

    :cond_be
    :goto_be
    invoke-virtual {p1, p0}, Landroid/view/View;->removeOnLayoutChangeListener(Landroid/view/View$OnLayoutChangeListener;)V

    return-void
.end method
