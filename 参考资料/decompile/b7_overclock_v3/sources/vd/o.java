package vd;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import g.d1;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public final class o {
    public static void a(@n0 Context context, @d1 int i10) {
        Resources.Theme themeB;
        context.getTheme().applyStyle(i10, true);
        if (!(context instanceof Activity) || (themeB = b((Activity) context)) == null) {
            return;
        }
        themeB.applyStyle(i10, true);
    }

    @p0
    public static Resources.Theme b(@n0 Activity activity) {
        View viewPeekDecorView;
        Context context;
        Window window = activity.getWindow();
        if (window == null || (viewPeekDecorView = window.peekDecorView()) == null || (context = viewPeekDecorView.getContext()) == null) {
            return null;
        }
        return context.getTheme();
    }
}
