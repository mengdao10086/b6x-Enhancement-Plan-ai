package g2;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewGroup;
import g.n0;
import g.v0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f28980a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f28981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f28982c;

    public static int a(@n0 ViewGroup viewGroup, int i10) {
        if (Build.VERSION.SDK_INT >= 29) {
            return viewGroup.getChildDrawingOrder(i10);
        }
        if (!f28982c) {
            try {
                Class cls = Integer.TYPE;
                Method declaredMethod = ViewGroup.class.getDeclaredMethod("getChildDrawingOrder", cls, cls);
                f28981b = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f28982c = true;
        }
        Method method = f28981b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(viewGroup, Integer.valueOf(viewGroup.getChildCount()), Integer.valueOf(i10))).intValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return i10;
    }

    public static u b(@n0 ViewGroup viewGroup) {
        return new t(viewGroup);
    }

    @SuppressLint({"NewApi"})
    @v0(18)
    public static void c(@n0 ViewGroup viewGroup, boolean z10) {
        if (f28980a) {
            try {
                viewGroup.suppressLayout(z10);
            } catch (NoSuchMethodError unused) {
                f28980a = false;
            }
        }
    }

    public static void d(@n0 ViewGroup viewGroup, boolean z10) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z10);
        } else {
            c(viewGroup, z10);
        }
    }
}
