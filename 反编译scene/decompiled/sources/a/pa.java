package a;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class pa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<Matrix> f7099a = new ThreadLocal<>();
    public static final ThreadLocal<RectF> b = new ThreadLocal<>();

    public static void a(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        c(viewGroup, view, rect);
    }

    public static void b(ViewParent viewParent, View view, Matrix matrix) {
        Object parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            b(viewParent, (View) parent, matrix);
            matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        if (view.getMatrix().isIdentity()) {
            return;
        }
        matrix.preConcat(view.getMatrix());
    }

    public static void c(ViewGroup viewGroup, View view, Rect rect) {
        Matrix matrix = f7099a.get();
        if (matrix == null) {
            matrix = new Matrix();
            f7099a.set(matrix);
        } else {
            matrix.reset();
        }
        b(viewGroup, view, matrix);
        RectF rectF = b.get();
        if (rectF == null) {
            rectF = new RectF();
            b.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }
}
