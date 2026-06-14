package a;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class bw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f5737a;

    static {
        f5737a = Build.VERSION.SDK_INT < 18;
    }

    public static void a(aw awVar, View view, FrameLayout frameLayout) {
        c(awVar, view, frameLayout);
        if (f5737a) {
            frameLayout.setForeground(awVar);
        } else {
            view.getOverlay().add(awVar);
        }
    }

    public static void b(aw awVar, View view, FrameLayout frameLayout) {
        if (awVar == null) {
            return;
        }
        if (f5737a) {
            frameLayout.setForeground(null);
        } else {
            view.getOverlay().remove(awVar);
        }
    }

    public static void c(aw awVar, View view, FrameLayout frameLayout) {
        Rect rect = new Rect();
        (f5737a ? frameLayout : view).getDrawingRect(rect);
        awVar.setBounds(rect);
        awVar.v(view, frameLayout);
    }

    public static void d(Rect rect, float f, float f2, float f3, float f4) {
        rect.set((int) (f - f3), (int) (f2 - f4), (int) (f + f3), (int) (f2 + f4));
    }
}
