package androidx.core.widget;

import android.view.View;
import android.widget.PopupMenu;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    @v0(19)
    public static class a {
        @g.u
        public static View.OnTouchListener a(PopupMenu popupMenu) {
            return popupMenu.getDragToOpenListener();
        }
    }

    @p0
    public static View.OnTouchListener a(@n0 Object obj) {
        return a.a((PopupMenu) obj);
    }
}
