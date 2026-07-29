package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;
import g.n0;
import g.v0;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5254a = "PopupWindowCompatApi21";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f5255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f5256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f5257d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f5258e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Field f5259f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f5260g;

    @v0(19)
    public static class a {
        @g.u
        public static void a(PopupWindow popupWindow, View view, int i10, int i11, int i12) {
            popupWindow.showAsDropDown(view, i10, i11, i12);
        }
    }

    @v0(23)
    public static class b {
        @g.u
        public static boolean a(PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }

        @g.u
        public static int b(PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }

        @g.u
        public static void c(PopupWindow popupWindow, boolean z10) {
            popupWindow.setOverlapAnchor(z10);
        }

        @g.u
        public static void d(PopupWindow popupWindow, int i10) {
            popupWindow.setWindowLayoutType(i10);
        }
    }

    public static boolean a(@n0 PopupWindow popupWindow) {
        if (Build.VERSION.SDK_INT >= 23) {
            return b.a(popupWindow);
        }
        if (!f5260g) {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                f5259f = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f5260g = true;
        }
        Field field = f5259f;
        if (field == null) {
            return false;
        }
        try {
            return ((Boolean) field.get(popupWindow)).booleanValue();
        } catch (IllegalAccessException unused2) {
            return false;
        }
    }

    public static int b(@n0 PopupWindow popupWindow) {
        if (Build.VERSION.SDK_INT >= 23) {
            return b.b(popupWindow);
        }
        if (!f5258e) {
            try {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("getWindowLayoutType", new Class[0]);
                f5257d = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            f5258e = true;
        }
        Method method = f5257d;
        if (method != null) {
            try {
                return ((Integer) method.invoke(popupWindow, new Object[0])).intValue();
            } catch (Exception unused2) {
            }
        }
        return 0;
    }

    public static void c(@n0 PopupWindow popupWindow, boolean z10) {
        if (Build.VERSION.SDK_INT >= 23) {
            b.c(popupWindow, z10);
            return;
        }
        if (!f5260g) {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                f5259f = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f5260g = true;
        }
        Field field = f5259f;
        if (field != null) {
            try {
                field.set(popupWindow, Boolean.valueOf(z10));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public static void d(@n0 PopupWindow popupWindow, int i10) {
        if (Build.VERSION.SDK_INT >= 23) {
            b.d(popupWindow, i10);
            return;
        }
        if (!f5256c) {
            try {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                f5255b = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            f5256c = true;
        }
        Method method = f5255b;
        if (method != null) {
            try {
                method.invoke(popupWindow, Integer.valueOf(i10));
            } catch (Exception unused2) {
            }
        }
    }

    public static void e(@n0 PopupWindow popupWindow, @n0 View view, int i10, int i11, int i12) {
        a.a(popupWindow, view, i10, i11, i12);
    }
}
