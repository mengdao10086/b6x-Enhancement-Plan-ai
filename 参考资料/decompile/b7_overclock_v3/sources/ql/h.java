package ql;

import android.app.Activity;
import android.view.Window;
import g.v0;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes5.dex */
public class h extends ol.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f47448c = "h";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Class f47449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Method f47450b;

    @Override // ol.a, ol.b
    @v0(api = 26)
    public void a(Activity activity, ol.d dVar) {
        super.a(activity, dVar);
    }

    @Override // ol.a, ol.b
    @v0(api = 26)
    public void e(Activity activity, ol.d dVar) {
        h(activity, dVar);
    }

    @Override // ol.a, ol.b
    public void f(Activity activity, ol.d dVar) {
        super.f(activity, dVar);
    }

    @Override // ol.b
    @v0(api = 26)
    public boolean g(Window window) {
        if (window == null) {
            return false;
        }
        try {
            Class<?> clsLoadClass = window.getContext().getClassLoader().loadClass("android.util.FtFeature");
            this.f47449a = clsLoadClass;
            Method method = clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE);
            this.f47450b = method;
            return ((Boolean) method.invoke(this.f47449a, 32)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // ol.a, ol.b
    @v0(api = 26)
    public void h(Activity activity, ol.d dVar) {
        super.h(activity, dVar);
        if (g(activity.getWindow())) {
            pl.b.i(activity.getWindow());
        }
    }

    @Override // ol.b
    @v0(api = 26)
    public int i(Window window) {
        if (g(window)) {
            return pl.b.c(window.getContext());
        }
        return 0;
    }
}
