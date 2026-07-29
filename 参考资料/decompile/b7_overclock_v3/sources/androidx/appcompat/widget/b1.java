package androidx.appcompat.widget;

import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class b1 {

    @g.v0(26)
    public static class a {
        @g.u
        public static void a(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    public static void a(@g.n0 View view, @g.p0 CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            a.a(view, charSequence);
        } else {
            e1.h(view, charSequence);
        }
    }
}
