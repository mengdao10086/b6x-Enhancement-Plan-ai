package androidx.core.widget;

import android.widget.ListView;
import g.n0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class n {

    @v0(19)
    public static class a {
        @g.u
        public static boolean a(ListView listView, int i10) {
            return listView.canScrollList(i10);
        }

        @g.u
        public static void b(ListView listView, int i10) {
            listView.scrollListBy(i10);
        }
    }

    public static boolean a(@n0 ListView listView, int i10) {
        return a.a(listView, i10);
    }

    public static void b(@n0 ListView listView, int i10) {
        a.b(listView, i10);
    }
}
