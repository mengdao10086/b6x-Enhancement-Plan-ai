.class public Landroidx/databinding/adapters/AdapterViewBindingAdapter;
.super Ljava/lang/Object;
.source "AdapterViewBindingAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/databinding/adapters/AdapterViewBindingAdapter$OnNothingSelected;,
        Landroidx/databinding/adapters/AdapterViewBindingAdapter$OnItemSelected;,
        Landroidx/databinding/adapters/AdapterViewBindingAdapter$OnItemSelectedComponentListener;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static setOnItemSelectedListener(Landroid/widget/AdapterView;Landroidx/databinding/adapters/AdapterViewBindingAdapter$OnItemSelected;Landroidx/databinding/adapters/AdapterViewBindingAdapter$OnNothingSelected;Landroidx/databinding/InverseBindingListener;)V
    .registers 5

    if-nez p1, :cond_b

    if-nez p2, :cond_b

    if-nez p3, :cond_b

    const/4 p1, 0x0

    .line 80
    invoke-virtual {p0, p1}, Landroid/widget/AdapterView;->setOnItemSelectedListener(Landroid/widget/AdapterView$OnItemSelectedListener;)V

    goto :goto_13

    .line 82
    :cond_b
    new-instance v0, Landroidx/databinding/adapters/AdapterViewBindingAdapter$OnItemSelectedComponentListener;

    invoke-direct {v0, p1, p2, p3}, Landroidx/databinding/adapters/AdapterViewBindingAdapter$OnItemSelectedComponentListener;-><init>(Landroidx/databinding/adapters/AdapterViewBindingAdapter$OnItemSelected;Landroidx/databinding/adapters/AdapterViewBindingAdapter$OnNothingSelected;Landroidx/databinding/InverseBindingListener;)V

    invoke-virtual {p0, v0}, Landroid/widget/AdapterView;->setOnItemSelectedListener(Landroid/widget/AdapterView$OnItemSelectedListener;)V

    :goto_13
    return-void
.end method

.method public static setSelectedItemPosition(Landroid/widget/AdapterView;I)V
    .registers 3

    .line 49
    invoke-virtual {p0}, Landroid/widget/AdapterView;->getSelectedItemPosition()I

    move-result v0

    if-eq v0, p1, :cond_9

    .line 50
    invoke-virtual {p0, p1}, Landroid/widget/AdapterView;->setSelection(I)V

    :cond_9
    return-void
.end method

.method public static setSelectedItemPosition(Landroid/widget/AdapterView;ILandroid/widget/Adapter;)V
    .registers 4

    .line 61
    invoke-virtual {p0}, Landroid/widget/AdapterView;->getAdapter()Landroid/widget/Adapter;

    move-result-object v0

    if-eq p2, v0, :cond_d

    .line 63
    invoke-virtual {p0, p2}, Landroid/widget/AdapterView;->setAdapter(Landroid/widget/Adapter;)V

    .line 64
    invoke-virtual {p0, p1}, Landroid/widget/AdapterView;->setSelection(I)V

    goto :goto_16

    .line 65
    :cond_d
    invoke-virtual {p0}, Landroid/widget/AdapterView;->getSelectedItemPosition()I

    move-result p2

    if-eq p2, p1, :cond_16

    .line 66
    invoke-virtual {p0, p1}, Landroid/widget/AdapterView;->setSelection(I)V

    :cond_16
    :goto_16
    return-void
.end method

.method public static setSelection(Landroid/widget/AdapterView;I)V
    .registers 2

    .line 56
    invoke-static {p0, p1}, Landroidx/databinding/adapters/AdapterViewBindingAdapter;->setSelectedItemPosition(Landroid/widget/AdapterView;I)V

    return-void
.end method

.method public static setSelection(Landroid/widget/AdapterView;ILandroid/widget/Adapter;)V
    .registers 3

    .line 72
    invoke-static {p0, p1, p2}, Landroidx/databinding/adapters/AdapterViewBindingAdapter;->setSelectedItemPosition(Landroid/widget/AdapterView;ILandroid/widget/Adapter;)V

    return-void
.end method
