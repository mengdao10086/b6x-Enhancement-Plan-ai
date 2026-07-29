package androidx.core.widget;

import android.view.View;
import android.widget.ListPopupWindow;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    @v0(19)
    public static class a {
        @g.u
        public static View.OnTouchListener a(ListPopupWindow listPopupWindow, View view) {
            return listPopupWindow.createDragToOpenListener(view);
        }
    }

    @p0
    public static View.OnTouchListener a(@n0 ListPopupWindow listPopupWindow, @n0 View view) {
        return a.a(listPopupWindow, view);
    }

    @Deprecated
    public static View.OnTouchListener b(Object obj, View view) {
        return a((ListPopupWindow) obj, view);
    }
}
