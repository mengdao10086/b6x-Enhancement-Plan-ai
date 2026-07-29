.class public final Lcom/example/extool/BindingAdapterKt;
.super Ljava/lang/Object;
.source "BindingAdapter.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u00a8\u0006\u0006"
    }
    d2 = {
        "goneUnless",
        "",
        "view",
        "Landroid/view/View;",
        "visible",
        "",
        "exTool_release"
    }
    k = 0x2
    mv = {
        0x1,
        0x8,
        0x0
    }
    xi = 0x30
.end annotation


# direct methods
.method public static final goneUnless(Landroid/view/View;Z)V
    .registers 3
    .annotation runtime Landroidx/databinding/BindingAdapter;
        value = {
            "app:goneUnless"
        }
    .end annotation

    const-string v0, "view"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    if-eqz p1, :cond_9

    const/4 p1, 0x0

    goto :goto_b

    :cond_9
    const/16 p1, 0x8

    .line 8
    :goto_b
    invoke-virtual {p0, p1}, Landroid/view/View;->setVisibility(I)V

    return-void
.end method
