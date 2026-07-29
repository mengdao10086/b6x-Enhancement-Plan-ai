package ql;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
import g.v0;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes5.dex */
public class b extends ol.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f47443a = "b";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f47444b = "display_notch_status";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f47445c = 65536;

    @TargetApi(19)
    public static void m(Window window) {
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        try {
            Class<?> cls = Class.forName("com.huawei.android.view.LayoutParamsEx");
            cls.getMethod("addHwFlags", Integer.TYPE).invoke(cls.getConstructor(WindowManager.LayoutParams.class).newInstance(attributes), 65536);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException | Exception unused) {
        }
    }

    @v0(api = 19)
    public static void n(Window window) {
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        try {
            Class<?> cls = Class.forName("com.huawei.android.view.LayoutParamsEx");
            cls.getMethod("clearHwFlags", Integer.TYPE).invoke(cls.getConstructor(WindowManager.LayoutParams.class).newInstance(attributes), 65536);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException | Exception unused) {
        }
    }

    @Override // ol.a, ol.b
    @v0(api = 26)
    public void f(Activity activity, ol.d dVar) {
        super.f(activity, dVar);
        if (g(activity.getWindow())) {
            m(activity.getWindow());
        }
    }

    @Override // ol.b
    @v0(api = 26)
    public boolean g(Window window) {
        try {
            Class<?> clsLoadClass = window.getContext().getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(clsLoadClass, new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // ol.a, ol.b
    @v0(api = 26)
    public void h(Activity activity, ol.d dVar) {
        f(activity, dVar);
        if (g(activity.getWindow())) {
            pl.b.i(activity.getWindow());
        }
    }

    @Override // ol.b
    @v0(api = 26)
    public int i(Window window) {
        if (!g(window)) {
            return 0;
        }
        int[] iArr = {0, 0};
        try {
            Class<?> clsLoadClass = window.getContext().getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((int[]) clsLoadClass.getMethod("getNotchSize", new Class[0]).invoke(clsLoadClass, new Object[0]))[1];
        } catch (ClassNotFoundException unused) {
            return iArr[1];
        } catch (NoSuchMethodException unused2) {
            return iArr[1];
        } catch (Exception unused3) {
            return iArr[1];
        } catch (Throwable unused4) {
            return iArr[1];
        }
    }

    public final boolean l(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), f47444b, 0) == 1;
    }
}
