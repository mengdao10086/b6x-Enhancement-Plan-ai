package f0;

import android.app.Dialog;
import android.os.Build;
import android.view.View;
import g.n0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    @v0(28)
    public static class a {
        @g.u
        public static <T> T a(Dialog dialog, int i10) {
            return (T) dialog.requireViewById(i10);
        }
    }

    @n0
    public static View a(@n0 Dialog dialog, int i10) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (View) a.a(dialog, i10);
        }
        View viewFindViewById = dialog.findViewById(i10);
        if (viewFindViewById != null) {
            return viewFindViewById;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this Dialog");
    }
}
