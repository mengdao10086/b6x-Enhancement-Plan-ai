package g2;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import g.n0;
import g.v0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@v0(21)
public class f implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f28946b = "GhostViewApi21";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f28947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f28948d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Method f28949e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f28950f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Method f28951g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f28952h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f28953a;

    public f(@n0 View view) {
        this.f28953a = view;
    }

    public static e b(View view, ViewGroup viewGroup, Matrix matrix) {
        c();
        Method method = f28949e;
        if (method != null) {
            try {
                return new f((View) method.invoke(null, view, viewGroup, matrix));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e10) {
                throw new RuntimeException(e10.getCause());
            }
        }
        return null;
    }

    public static void c() {
        if (f28950f) {
            return;
        }
        try {
            d();
            Method declaredMethod = f28947c.getDeclaredMethod("addGhost", View.class, ViewGroup.class, Matrix.class);
            f28949e = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException unused) {
        }
        f28950f = true;
    }

    public static void d() {
        if (f28948d) {
            return;
        }
        try {
            f28947c = Class.forName("android.view.GhostView");
        } catch (ClassNotFoundException unused) {
        }
        f28948d = true;
    }

    public static void e() {
        if (f28952h) {
            return;
        }
        try {
            d();
            Method declaredMethod = f28947c.getDeclaredMethod("removeGhost", View.class);
            f28951g = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException unused) {
        }
        f28952h = true;
    }

    public static void f(View view) {
        e();
        Method method = f28951g;
        if (method != null) {
            try {
                method.invoke(null, view);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e10) {
                throw new RuntimeException(e10.getCause());
            }
        }
    }

    @Override // g2.e
    public void a(ViewGroup viewGroup, View view) {
    }

    @Override // g2.e
    public void setVisibility(int i10) {
        this.f28953a.setVisibility(i10);
    }
}
