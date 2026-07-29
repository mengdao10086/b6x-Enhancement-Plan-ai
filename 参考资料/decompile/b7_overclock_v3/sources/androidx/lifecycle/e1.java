package androidx.lifecycle;

import android.view.View;
import kotlin.DeprecationLevel;

/* JADX INFO: loaded from: classes2.dex */
public final class e1 {
    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Replaced by View.findViewTreeViewModelStoreOwner in ViewTreeViewModelStoreOwner", replaceWith = @kotlin.t0(expression = "View.findViewTreeViewModelStoreOwner", imports = {"androidx.lifecycle.ViewTreeViewModelStoreOwner"}))
    public static final /* synthetic */ d1 a(View view) {
        kotlin.jvm.internal.f0.p(view, "view");
        return ViewTreeViewModelStoreOwner.a(view);
    }
}
