package androidx.lifecycle;

import android.view.View;
import kotlin.DeprecationLevel;

/* JADX INFO: loaded from: classes2.dex */
public final class w0 {
    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Replaced by View.findViewTreeLifecycleOwner() from lifecycle module", replaceWith = @kotlin.t0(expression = "findViewTreeLifecycleOwner()", imports = {"androidx.lifecycle.findViewTreeLifecycleOwner"}))
    public static final /* synthetic */ y a(View view) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        return ViewTreeLifecycleOwner.a(view);
    }
}
