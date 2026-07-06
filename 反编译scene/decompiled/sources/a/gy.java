package a;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class gy {

    public interface a {
        sh a(View view, sh shVar, hy hyVar);
    }

    public static void a(View view, a aVar) {
        eh.v0(view, new ey(aVar, new hy(eh.D(view), view.getPaddingTop(), eh.C(view), view.getPaddingBottom())));
        f(view);
    }

    public static float b(Context context, int i) {
        return TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    public static float c(View view) {
        float fT = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            fT += eh.t((View) parent);
        }
        return fT;
    }

    public static boolean d(View view) {
        return eh.y(view) == 1;
    }

    public static PorterDuff.Mode e(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void f(View view) {
        if (eh.P(view)) {
            eh.h0(view);
        } else {
            view.addOnAttachStateChangeListener(new fy());
        }
    }
}
