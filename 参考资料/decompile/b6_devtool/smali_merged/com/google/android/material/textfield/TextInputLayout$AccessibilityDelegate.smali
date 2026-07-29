.class public Lcom/google/android/material/textfield/TextInputLayout$AccessibilityDelegate;
.super Landroidx/core/view/AccessibilityDelegateCompat;
.source "TextInputLayout.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/material/textfield/TextInputLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AccessibilityDelegate"
.end annotation


# instance fields
.field private final layout:Lcom/google/android/material/textfield/TextInputLayout;


# direct methods
.method public constructor <init>(Lcom/google/android/material/textfield/TextInputLayout;)V
    .registers 2

    .line 4410
    invoke-direct {p0}, Landroidx/core/view/AccessibilityDelegateCompat;-><init>()V

    .line 4411
    iput-object p1, p0, Lcom/google/android/material/textfield/TextInputLayout$AccessibilityDelegate;->layout:Lcom/google/android/material/textfield/TextInputLayout;

    return-void
.end method


# virtual methods
.method public onInitializeAccessibilityNodeInfo(Landroid/view/View;Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;)V
    .registers 15

    .line 4417
    invoke-super {p0, p1, p2}, Landroidx/core/view/AccessibilityDelegateCompat;->onInitializeAccessibilityNodeInfo(Landroid/view/View;Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;)V

    .line 4418
    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout$AccessibilityDelegate;->layout:Lcom/google/android/material/textfield/TextInputLayout;

    invoke-virtual {v0}, Lcom/google/android/material/textfield/TextInputLayout;->getEditText()Landroid/widget/EditText;

    move-result-object v0

    if-eqz v0, :cond_10

    .line 4419
    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    goto :goto_11

    :cond_10
    const/4 v0, 0x0

    .line 4420
    :goto_11
    iget-object v1, p0, Lcom/google/android/material/textfield/TextInputLayout$AccessibilityDelegate;->layout:Lcom/google/android/material/textfield/TextInputLayout;

    invoke-virtual {v1}, Lcom/google/android/material/textfield/TextInputLayout;->getHint()Ljava/lang/CharSequence;

    move-result-object v1

    .line 4421
    iget-object v2, p0, Lcom/google/android/material/textfield/TextInputLayout$AccessibilityDelegate;->layout:Lcom/google/android/material/textfield/TextInputLayout;

    invoke-virtual {v2}, Lcom/google/android/material/textfield/TextInputLayout;->getError()Ljava/lang/CharSequence;

    move-result-object v2

    .line 4422
    iget-object v3, p0, Lcom/google/android/material/textfield/TextInputLayout$AccessibilityDelegate;->layout:Lcom/google/android/material/textfield/TextInputLayout;

    invoke-virtual {v3}, Lcom/google/android/material/textfield/TextInputLayout;->getPlaceholderText()Ljava/lang/CharSequence;

    move-result-object v3

    .line 4423
    iget-object v4, p0, Lcom/google/android/material/textfield/TextInputLayout$AccessibilityDelegate;->layout:Lcom/google/android/material/textfield/TextInputLayout;

    invoke-virtual {v4}, Lcom/google/android/material/textfield/TextInputLayout;->getCounterMaxLength()I

    move-result v4

    .line 4424
    iget-object v5, p0, Lcom/google/android/material/textfield/TextInputLayout$AccessibilityDelegate;->layout:Lcom/google/android/material/textfield/TextInputLayout;

    invoke-virtual {v5}, Lcom/google/android/material/textfield/TextInputLayout;->getCounterOverflowDescription()Ljava/lang/CharSequence;

    move-result-object v5

    .line 4425
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    const/4 v7, 0x1

    xor-int/2addr v6, v7

    .line 4426
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    xor-int/2addr v8, v7

    .line 4427
    iget-object v9, p0, Lcom/google/android/material/textfield/TextInputLayout$AccessibilityDelegate;->layout:Lcom/google/android/material/textfield/TextInputLayout;

    invoke-virtual {v9}, Lcom/google/android/material/textfield/TextInputLayout;->isHintExpanded()Z

    move-result v9

    xor-int/2addr v9, v7

    .line 4428
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v10

    xor-int/2addr v10, v7

    if-nez v10, :cond_51

    .line 4429
    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v11

    if-nez v11, :cond_4f

    goto :goto_51

    :cond_4f
    const/4 v11, 0x0

    goto :goto_52

    :cond_51
    :goto_51
    move v11, v7

    :goto_52
    if-eqz v8, :cond_59

    .line 4430
    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_5b

    :cond_59
    const-string v1, ""

    .line 4433
    :goto_5b
    iget-object v8, p0, Lcom/google/android/material/textfield/TextInputLayout$AccessibilityDelegate;->layout:Lcom/google/android/material/textfield/TextInputLayout;

    # getter for: Lcom/google/android/material/textfield/TextInputLayout;->startLayout:Lcom/google/android/material/textfield/StartCompoundLayout;
    invoke-static {v8}, Lcom/google/android/material/textfield/TextInputLayout;->access$400(Lcom/google/android/material/textfield/TextInputLayout;)Lcom/google/android/material/textfield/StartCompoundLayout;

    move-result-object v8

    invoke-virtual {v8, p2}, Lcom/google/android/material/textfield/StartCompoundLayout;->setupAccessibilityNodeInfo(Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;)V

    if-eqz v6, :cond_6a

    .line 4437
    invoke-virtual {p2, v0}, Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;->setText(Ljava/lang/CharSequence;)V

    goto :goto_97

    .line 4438
    :cond_6a
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-nez v8, :cond_92

    .line 4439
    invoke-virtual {p2, v1}, Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;->setText(Ljava/lang/CharSequence;)V

    if-eqz v9, :cond_97

    if-eqz v3, :cond_97

    .line 4441
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, ", "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p2, v3}, Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;->setText(Ljava/lang/CharSequence;)V

    goto :goto_97

    :cond_92
    if-eqz v3, :cond_97

    .line 4444
    invoke-virtual {p2, v3}, Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;->setText(Ljava/lang/CharSequence;)V

    .line 4447
    :cond_97
    :goto_97
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_a5

    .line 4449
    invoke-virtual {p2, v1}, Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;->setHintText(Ljava/lang/CharSequence;)V

    xor-int/lit8 v1, v6, 0x1

    .line 4456
    invoke-virtual {p2, v1}, Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;->setShowingHintText(Z)V

    :cond_a5
    if-eqz v0, :cond_ae

    .line 4461
    invoke-interface {v0}, Ljava/lang/CharSequence;->length()I

    move-result v0

    if-ne v0, v4, :cond_ae

    goto :goto_af

    :cond_ae
    const/4 v4, -0x1

    .line 4460
    :goto_af
    invoke-virtual {p2, v4}, Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;->setMaxTextLength(I)V

    if-eqz v11, :cond_bb

    if-eqz v10, :cond_b7

    goto :goto_b8

    :cond_b7
    move-object v2, v5

    .line 4464
    :goto_b8
    invoke-virtual {p2, v2}, Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;->setError(Ljava/lang/CharSequence;)V

    .line 4468
    :cond_bb
    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout$AccessibilityDelegate;->layout:Lcom/google/android/material/textfield/TextInputLayout;

    # getter for: Lcom/google/android/material/textfield/TextInputLayout;->indicatorViewController:Lcom/google/android/material/textfield/IndicatorViewController;
    invoke-static {v0}, Lcom/google/android/material/textfield/TextInputLayout;->access$500(Lcom/google/android/material/textfield/TextInputLayout;)Lcom/google/android/material/textfield/IndicatorViewController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/material/textfield/IndicatorViewController;->getHelperTextView()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_ca

    .line 4470
    invoke-virtual {p2, v0}, Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;->setLabelFor(Landroid/view/View;)V

    .line 4474
    :cond_ca
    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout$AccessibilityDelegate;->layout:Lcom/google/android/material/textfield/TextInputLayout;

    # getter for: Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;
    invoke-static {v0}, Lcom/google/android/material/textfield/TextInputLayout;->access$300(Lcom/google/android/material/textfield/TextInputLayout;)Lcom/google/android/material/textfield/EndCompoundLayout;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/material/textfield/EndCompoundLayout;->getEndIconDelegate()Lcom/google/android/material/textfield/EndIconDelegate;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/google/android/material/textfield/EndIconDelegate;->onInitializeAccessibilityNodeInfo(Landroid/view/View;Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;)V

    return-void
.end method

.method public onPopulateAccessibilityEvent(Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)V
    .registers 4

    .line 4480
    invoke-super {p0, p1, p2}, Landroidx/core/view/AccessibilityDelegateCompat;->onPopulateAccessibilityEvent(Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)V

    .line 4481
    iget-object v0, p0, Lcom/google/android/material/textfield/TextInputLayout$AccessibilityDelegate;->layout:Lcom/google/android/material/textfield/TextInputLayout;

    # getter for: Lcom/google/android/material/textfield/TextInputLayout;->endLayout:Lcom/google/android/material/textfield/EndCompoundLayout;
    invoke-static {v0}, Lcom/google/android/material/textfield/TextInputLayout;->access$300(Lcom/google/android/material/textfield/TextInputLayout;)Lcom/google/android/material/textfield/EndCompoundLayout;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/material/textfield/EndCompoundLayout;->getEndIconDelegate()Lcom/google/android/material/textfield/EndIconDelegate;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/google/android/material/textfield/EndIconDelegate;->onPopulateAccessibilityEvent(Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)V

    return-void
.end method
