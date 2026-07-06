package a;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class yg {
    public static void a(WindowInsets windowInsets, View view) {
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(ra.tag_window_insets_animation_callback);
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        }
    }

    public static sh b(View view, sh shVar, Rect rect) {
        WindowInsets windowInsetsR = shVar.r();
        if (windowInsetsR != null) {
            return sh.t(view.computeSystemWindowInsets(windowInsetsR, rect), view);
        }
        rect.setEmpty();
        return shVar;
    }

    public static sh c(View view) {
        return rh.a(view);
    }

    public static void d(View view, ng ngVar) {
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(ra.tag_on_apply_window_listener, ngVar);
        }
        if (ngVar == null) {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(ra.tag_window_insets_animation_callback));
        } else {
            view.setOnApplyWindowInsetsListener(new xg(view, ngVar));
        }
    }
}
