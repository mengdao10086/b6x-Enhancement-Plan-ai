package o5;

import android.view.View;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final void a(@yt.k View view, @yt.l Boolean bool, boolean z10) {
        f0.p(view, "<this>");
        view.setVisibility(f0.g(bool, Boolean.TRUE) ? 0 : z10 ? 8 : 4);
    }

    public static /* synthetic */ void b(View view, Boolean bool, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bool = Boolean.TRUE;
        }
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        a(view, bool, z10);
    }
}
