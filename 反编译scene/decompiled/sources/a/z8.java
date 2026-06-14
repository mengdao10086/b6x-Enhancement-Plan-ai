package a;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class z8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Method f8043a;

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
                f8043a = declaredMethod;
                if (declaredMethod.isAccessible()) {
                    return;
                }
                f8043a.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
            }
        }
    }

    public static void a(View view, Rect rect, Rect rect2) {
        Method method = f8043a;
        if (method != null) {
            try {
                method.invoke(view, rect, rect2);
            } catch (Exception e) {
                Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e);
            }
        }
    }

    public static boolean b(View view) {
        return eh.y(view) == 1;
    }

    public static void c(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                method.invoke(view, new Object[0]);
            } catch (IllegalAccessException e) {
                e = e;
                Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e);
            } catch (NoSuchMethodException unused) {
                Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
            } catch (InvocationTargetException e2) {
                e = e2;
                Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e);
            }
        }
    }
}
