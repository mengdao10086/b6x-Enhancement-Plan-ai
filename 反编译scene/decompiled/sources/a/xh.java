package a;

import a.sh;
import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class xh extends ci {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class<?> f7890a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Field f3584a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Method f3585a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f3586a = false;
    public static Class<?> b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static Field f3587b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public uc f3588a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final WindowInsets f3589a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public uc f3590b;
    public sh c;

    public xh(sh shVar, xh xhVar) {
        this(shVar, new WindowInsets(xhVar.f3589a));
    }

    public xh(sh shVar, WindowInsets windowInsets) {
        super(shVar);
        this.f3588a = null;
        this.f3589a = windowInsets;
    }

    @SuppressLint({"PrivateApi"})
    public static void r() {
        try {
            f3585a = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
            f7890a = Class.forName("android.view.ViewRootImpl");
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            b = cls;
            f3584a = cls.getDeclaredField("mVisibleInsets");
            f3587b = f7890a.getDeclaredField("mAttachInfo");
            f3584a.setAccessible(true);
            f3587b.setAccessible(true);
        } catch (ReflectiveOperationException e) {
            Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
        }
        f3586a = true;
    }

    @Override // a.ci
    public void d(View view) {
        uc ucVarQ = q(view);
        if (ucVarQ == null) {
            ucVarQ = uc.f7583a;
        }
        n(ucVarQ);
    }

    @Override // a.ci
    public void e(sh shVar) {
        shVar.p(this.c);
        shVar.o(this.f3590b);
    }

    @Override // a.ci
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return Objects.equals(this.f3590b, ((xh) obj).f3590b);
        }
        return false;
    }

    @Override // a.ci
    public final uc i() {
        if (this.f3588a == null) {
            this.f3588a = uc.b(this.f3589a.getSystemWindowInsetLeft(), this.f3589a.getSystemWindowInsetTop(), this.f3589a.getSystemWindowInsetRight(), this.f3589a.getSystemWindowInsetBottom());
        }
        return this.f3588a;
    }

    @Override // a.ci
    public sh j(int i, int i2, int i3, int i4) {
        sh.a aVar = new sh.a(sh.s(this.f3589a));
        aVar.c(sh.k(i(), i, i2, i3, i4));
        aVar.b(sh.k(h(), i, i2, i3, i4));
        return aVar.a();
    }

    @Override // a.ci
    public boolean l() {
        return this.f3589a.isRound();
    }

    @Override // a.ci
    public void m(uc[] ucVarArr) {
    }

    @Override // a.ci
    public void n(uc ucVar) {
        this.f3590b = ucVar;
    }

    @Override // a.ci
    public void o(sh shVar) {
        this.c = shVar;
    }

    public final uc q(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }
        if (!f3586a) {
            r();
        }
        Method method = f3585a;
        if (method != null && b != null && f3584a != null) {
            try {
                Object objInvoke = method.invoke(view, new Object[0]);
                if (objInvoke == null) {
                    Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                    return null;
                }
                Rect rect = (Rect) f3584a.get(f3587b.get(objInvoke));
                if (rect != null) {
                    return uc.c(rect);
                }
                return null;
            } catch (ReflectiveOperationException e) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
            }
        }
        return null;
    }
}
