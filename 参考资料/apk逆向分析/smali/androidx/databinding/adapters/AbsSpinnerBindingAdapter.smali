.class public Landroidx/databinding/adapters/AbsSpinnerBindingAdapter;
.super Ljava/lang/Object;
.source "AbsSpinnerBindingAdapter.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static setEntries(Landroid/widget/AbsSpinner;Ljava/util/List;)V
    .registers 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Landroid/widget/AbsSpinner;",
            "Ljava/util/List<",
            "TT;>;)V"
        }
    .end annotation

    if-eqz p1, :cond_26

    .line 63
    invoke-virtual {p0}, Landroid/widget/AbsSpinner;->getAdapter()Landroid/widget/SpinnerAdapter;

    move-result-object v0

    .line 64
    instance-of v1, v0, Landroidx/databinding/adapters/ObservableListAdapter;

    if-eqz v1, :cond_10

    .line 66
    check-cast v0, Landroidx/databinding/adapters/ObservableListAdapter;

    invoke-virtual {v0, p1}, Landroidx/databinding/adapters/ObservableListAdapter;->setList(Ljava/util/List;)V

    goto :goto_2a

    .line 68
    :cond_10
    new-instance v0, Landroidx/databinding/adapters/ObservableListAdapter;

    invoke-virtual {p0}, Landroid/widget/AbsSpinner;->getContext()Landroid/content/Context;

    move-result-object v2

    const v4, 0x1090008

    const v5, 0x1090009

    const/4 v6, 0x0

    move-object v1, v0

    move-object v3, p1

    invoke-direct/range {v1 .. v6}, Landroidx/databinding/adapters/ObservableListAdapter;-><init>(Landroid/content/Context;Ljava/util/List;III)V

    invoke-virtual {p0, v0}, Landroid/widget/AbsSpinner;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    goto :goto_2a

    :cond_26
    const/4 p1, 0x0

    .line 73
    invoke-virtual {p0, p1}, Landroid/widget/AbsSpinner;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    :goto_2a
    return-void
.end method

.method public static setEntries(Landroid/widget/AbsSpinner;[Ljava/lang/CharSequence;)V
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Ljava/lang/CharSequence;",
            ">(",
            "Landroid/widget/AbsSpinner;",
            "[TT;)V"
        }
    .end annotation

    if-eqz p1, :cond_3e

    .line 36
    invoke-virtual {p0}, Landroid/widget/AbsSpinner;->getAdapter()Landroid/widget/SpinnerAdapter;

    move-result-object v0

    const/4 v1, 0x1

    if-eqz v0, :cond_26

    .line 38
    invoke-interface {v0}, Landroid/widget/SpinnerAdapter;->getCount()I

    move-result v2

    array-length v3, p1

    if-ne v2, v3, :cond_26

    const/4 v2, 0x0

    move v3, v2

    .line 40
    :goto_12
    array-length v4, p1

    if-ge v3, v4, :cond_25

    .line 41
    aget-object v4, p1, v3

    invoke-interface {v0, v3}, Landroid/widget/SpinnerAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_22

    goto :goto_26

    :cond_22
    add-int/lit8 v3, v3, 0x1

    goto :goto_12

    :cond_25
    move v1, v2

    :cond_26
    :goto_26
    if-eqz v1, :cond_42

    .line 48
    new-instance v0, Landroid/widget/ArrayAdapter;

    .line 49
    invoke-virtual {p0}, Landroid/widget/AbsSpinner;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x1090008

    invoke-direct {v0, v1, v2, p1}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;I[Ljava/lang/Object;)V

    const p1, 0x1090009

    .line 51
    invoke-virtual {v0, p1}, Landroid/widget/ArrayAdapter;->setDropDownViewResource(I)V

    .line 52
    invoke-virtual {p0, v0}, Landroid/widget/AbsSpinner;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    goto :goto_42

    :cond_3e
    const/4 p1, 0x0

    .line 55
    invoke-virtual {p0, p1}, Landroid/widget/AbsSpinner;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    :cond_42
    :goto_42
    return-void
.end method
