package androidx.appcompat.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.RestrictTo;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2496a = "ViewUtils";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f2497b;

    static {
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
            f2497b = declaredMethod;
            if (declaredMethod.isAccessible()) {
                return;
            }
            f2497b.setAccessible(true);
        } catch (NoSuchMethodException unused) {
        }
    }

    public static void a(View view, Rect rect, Rect rect2) {
        Method method = f2497b;
        if (method != null) {
            try {
                method.invoke(view, rect, rect2);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean b(View view) {
        return androidx.core.view.u0.Z(view) == 1;
    }

    public static void c(View view) {
        try {
            Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(view, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
    }
}
