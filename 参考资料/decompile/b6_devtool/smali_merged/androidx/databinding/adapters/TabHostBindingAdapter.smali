.class public Landroidx/databinding/adapters/TabHostBindingAdapter;
.super Ljava/lang/Object;
.source "TabHostBindingAdapter.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getCurrentTab(Landroid/widget/TabHost;)I
    .registers 1

    .line 34
    invoke-virtual {p0}, Landroid/widget/TabHost;->getCurrentTab()I

    move-result p0

    return p0
.end method

.method public static getCurrentTabTag(Landroid/widget/TabHost;)Ljava/lang/String;
    .registers 1

    .line 39
    invoke-virtual {p0}, Landroid/widget/TabHost;->getCurrentTabTag()Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static setCurrentTab(Landroid/widget/TabHost;I)V
    .registers 3

    .line 44
    invoke-virtual {p0}, Landroid/widget/TabHost;->getCurrentTab()I

    move-result v0

    if-eq v0, p1, :cond_9

    .line 45
    invoke-virtual {p0, p1}, Landroid/widget/TabHost;->setCurrentTab(I)V

    :cond_9
    return-void
.end method

.method public static setCurrentTabTag(Landroid/widget/TabHost;Ljava/lang/String;)V
    .registers 4

    .line 51
    invoke-virtual {p0}, Landroid/widget/TabHost;->getCurrentTabTag()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_c

    .line 52
    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_10

    :cond_c
    if-nez v0, :cond_13

    if-eqz p1, :cond_13

    .line 54
    :cond_10
    invoke-virtual {p0, p1}, Landroid/widget/TabHost;->setCurrentTabByTag(Ljava/lang/String;)V

    :cond_13
    return-void
.end method

.method public static setListeners(Landroid/widget/TabHost;Landroid/widget/TabHost$OnTabChangeListener;Landroidx/databinding/InverseBindingListener;)V
    .registers 4

    if-nez p2, :cond_6

    .line 63
    invoke-virtual {p0, p1}, Landroid/widget/TabHost;->setOnTabChangedListener(Landroid/widget/TabHost$OnTabChangeListener;)V

    goto :goto_e

    .line 65
    :cond_6
    new-instance v0, Landroidx/databinding/adapters/TabHostBindingAdapter$1;

    invoke-direct {v0, p1, p2}, Landroidx/databinding/adapters/TabHostBindingAdapter$1;-><init>(Landroid/widget/TabHost$OnTabChangeListener;Landroidx/databinding/InverseBindingListener;)V

    invoke-virtual {p0, v0}, Landroid/widget/TabHost;->setOnTabChangedListener(Landroid/widget/TabHost$OnTabChangeListener;)V

    :goto_e
    return-void
.end method
