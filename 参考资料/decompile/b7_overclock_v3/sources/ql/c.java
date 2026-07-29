package ql;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.view.Window;
import g.v0;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes5.dex */
public class c extends ol.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f47446a = "c";

    @Override // ol.a, ol.b
    public void f(Activity activity, ol.d dVar) {
        super.f(activity, dVar);
        if (Build.VERSION.SDK_INT < 26 || !g(activity.getWindow())) {
            return;
        }
        try {
            Method method = Window.class.getMethod("addExtraFlags", Integer.TYPE);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(activity.getWindow(), 1792);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // ol.b
    @v0(api = 26)
    public boolean g(Window window) {
        return "1".equals(pl.c.c().a("ro.miui.notch"));
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
        if (!g(window) || window == null) {
            return 0;
        }
        Context context = window.getContext();
        return m(window.getContext()) ? pl.b.c(context) : l(context);
    }

    public final int l(Context context) {
        int identifier = context.getResources().getIdentifier("notch_height", "dimen", l4.f.f39447b);
        return identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : pl.b.c(context);
    }

    @v0(api = 17)
    public final boolean m(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "force_black", 0) == 1;
    }
}
