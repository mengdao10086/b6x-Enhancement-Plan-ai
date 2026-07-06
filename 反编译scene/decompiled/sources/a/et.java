package a;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class et {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Field f6038a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Method f788a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f789a;
    public static boolean b;

    public void a(View view) {
        if (view.getVisibility() == 0) {
            view.setTag(rr.save_non_transition_alpha, null);
        }
    }

    @SuppressLint({"PrivateApi"})
    public final void b() {
        if (f789a) {
            return;
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("setFrame", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
            f788a = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsBase", "Failed to retrieve setFrame method", e);
        }
        f789a = true;
    }

    public float c(View view) {
        Float f = (Float) view.getTag(rr.save_non_transition_alpha);
        float alpha = view.getAlpha();
        return f != null ? alpha / f.floatValue() : alpha;
    }

    public void d(View view) {
        if (view.getTag(rr.save_non_transition_alpha) == null) {
            view.setTag(rr.save_non_transition_alpha, Float.valueOf(view.getAlpha()));
        }
    }

    public void e(View view, int i, int i2, int i3, int i4) {
        b();
        Method method = f788a;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    public void f(View view, float f) {
        Float f2 = (Float) view.getTag(rr.save_non_transition_alpha);
        if (f2 != null) {
            view.setAlpha(f2.floatValue() * f);
        } else {
            view.setAlpha(f);
        }
    }

    public void g(View view, int i) {
        if (!b) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f6038a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            b = true;
        }
        Field field = f6038a;
        if (field != null) {
            try {
                f6038a.setInt(view, i | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public void h(View view, Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            h((View) parent, matrix);
            matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        matrix.preConcat(matrix2);
    }

    public void i(View view, Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            i((View) parent, matrix);
            matrix.postTranslate(r0.getScrollX(), r0.getScrollY());
        }
        matrix.postTranslate(-view.getLeft(), -view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        Matrix matrix3 = new Matrix();
        if (matrix2.invert(matrix3)) {
            matrix.postConcat(matrix3);
        }
    }
}
