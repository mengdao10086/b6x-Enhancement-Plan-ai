package androidx.core.view;

import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;

/* JADX INFO: loaded from: classes2.dex */
public final class s {

    @g.v0(28)
    public static class a {
        @g.u
        public static void a(Menu menu, boolean z10) {
            menu.setGroupDividerEnabled(z10);
        }
    }

    public static void a(@g.n0 Menu menu, boolean z10) {
        if (menu instanceof r0.a) {
            ((r0.a) menu).setGroupDividerEnabled(z10);
        } else if (Build.VERSION.SDK_INT >= 28) {
            a.a(menu, z10);
        }
    }

    @Deprecated
    public static void b(MenuItem menuItem, int i10) {
        menuItem.setShowAsAction(i10);
    }
}
