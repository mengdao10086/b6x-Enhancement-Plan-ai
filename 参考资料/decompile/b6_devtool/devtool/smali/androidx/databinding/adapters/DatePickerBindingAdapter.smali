.class public Landroidx/databinding/adapters/DatePickerBindingAdapter;
.super Ljava/lang/Object;
.source "DatePickerBindingAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/databinding/adapters/DatePickerBindingAdapter$DateChangedListener;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static setListeners(Landroid/widget/DatePicker;IIILandroid/widget/DatePicker$OnDateChangedListener;Landroidx/databinding/InverseBindingListener;Landroidx/databinding/InverseBindingListener;Landroidx/databinding/InverseBindingListener;)V
    .registers 10

    if-nez p1, :cond_6

    invoke-virtual {p0}, Landroid/widget/DatePicker;->getYear()I

    move-result p1

    :cond_6
    if-nez p3, :cond_c

    invoke-virtual {p0}, Landroid/widget/DatePicker;->getDayOfMonth()I

    move-result p3

    :cond_c
    if-nez p5, :cond_16

    if-nez p6, :cond_16

    if-nez p7, :cond_16

    invoke-virtual {p0, p1, p2, p3, p4}, Landroid/widget/DatePicker;->init(IIILandroid/widget/DatePicker$OnDateChangedListener;)V

    goto :goto_31

    :cond_16
    sget v0, Landroidx/databinding/library/baseAdapters/R$id;->onDateChanged:I

    invoke-static {p0, v0}, Landroidx/databinding/adapters/ListenerUtil;->getListener(Landroid/view/View;I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/databinding/adapters/DatePickerBindingAdapter$DateChangedListener;

    if-nez v0, :cond_2b

    new-instance v0, Landroidx/databinding/adapters/DatePickerBindingAdapter$DateChangedListener;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Landroidx/databinding/adapters/DatePickerBindingAdapter$DateChangedListener;-><init>(Landroidx/databinding/adapters/DatePickerBindingAdapter$1;)V

    sget v1, Landroidx/databinding/library/baseAdapters/R$id;->onDateChanged:I

    invoke-static {p0, v0, v1}, Landroidx/databinding/adapters/ListenerUtil;->trackListener(Landroid/view/View;Ljava/lang/Object;I)Ljava/lang/Object;

    :cond_2b
    invoke-virtual {v0, p4, p5, p6, p7}, Landroidx/databinding/adapters/DatePickerBindingAdapter$DateChangedListener;->setListeners(Landroid/widget/DatePicker$OnDateChangedListener;Landroidx/databinding/InverseBindingListener;Landroidx/databinding/InverseBindingListener;Landroidx/databinding/InverseBindingListener;)V

    invoke-virtual {p0, p1, p2, p3, v0}, Landroid/widget/DatePicker;->init(IIILandroid/widget/DatePicker$OnDateChangedListener;)V

    :goto_31
    return-void
.end method
