package androidx.savedstate;

import android.view.View;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.f0;
import kotlin.k;
import kotlin.t0;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    @k(level = DeprecationLevel.HIDDEN, message = "Replaced by View.findViewTreeSavedStateRegistryOwner() from savedstate module", replaceWith = @t0(expression = "findViewTreeSavedStateRegistryOwner()", imports = {"androidx.savedstate.findViewTreeSavedStateRegistryOwner"}))
    public static final /* synthetic */ d a(View view) {
        f0.p(view, "<this>");
        return ViewTreeSavedStateRegistryOwner.a(view);
    }
}
