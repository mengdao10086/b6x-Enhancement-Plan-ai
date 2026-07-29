package com.blankj.utilcode.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<Field> f11699a;

    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            b.l();
        }
    }

    public b() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Resources b(Resources resources, int i10) {
        return c(resources, i10, false);
    }

    public static Resources c(Resources resources, int i10, boolean z10) {
        e(resources, ((resources.getDisplayMetrics().heightPixels + (z10 ? j(resources) : 0)) * 72.0f) / i10);
        return resources;
    }

    public static Resources d(Resources resources, int i10) {
        e(resources, (resources.getDisplayMetrics().widthPixels * 72.0f) / i10);
        return resources;
    }

    public static void e(Resources resources, float f10) {
        resources.getDisplayMetrics().xdpi = f10;
        j1.a().getResources().getDisplayMetrics().xdpi = f10;
        g(resources, f10);
    }

    public static void f(Resources resources, float f10) {
        Iterator<Field> it2 = f11699a.iterator();
        while (it2.hasNext()) {
            try {
                DisplayMetrics displayMetrics = (DisplayMetrics) it2.next().get(resources);
                if (displayMetrics != null) {
                    displayMetrics.xdpi = f10;
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public static void g(Resources resources, float f10) {
        if (f11699a != null) {
            f(resources, f10);
            return;
        }
        f11699a = new ArrayList();
        Class<?> superclass = resources.getClass();
        Field[] declaredFields = superclass.getDeclaredFields();
        while (declaredFields != null && declaredFields.length > 0) {
            for (Field field : declaredFields) {
                if (field.getType().isAssignableFrom(DisplayMetrics.class)) {
                    field.setAccessible(true);
                    DisplayMetrics displayMetricsI = i(resources, field);
                    if (displayMetricsI != null) {
                        f11699a.add(field);
                        displayMetricsI.xdpi = f10;
                    }
                }
            }
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                return;
            } else {
                declaredFields = superclass.getDeclaredFields();
            }
        }
    }

    public static Resources h(Resources resources) {
        e(resources, Resources.getSystem().getDisplayMetrics().density * 72.0f);
        return resources;
    }

    public static DisplayMetrics i(Resources resources, Field field) {
        try {
            return (DisplayMetrics) field.get(resources);
        } catch (Exception unused) {
            return null;
        }
    }

    public static int j(Resources resources) {
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", l4.f.f39447b);
        if (identifier != 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static Runnable k() {
        return new a();
    }

    public static void l() {
        e(Resources.getSystem(), Resources.getSystem().getDisplayMetrics().xdpi);
    }

    public static int m(float f10) {
        return (int) (((double) ((f10 * j1.a().getResources().getDisplayMetrics().xdpi) / 72.0f)) + 0.5d);
    }

    public static int n(float f10) {
        return (int) (((double) ((f10 * 72.0f) / j1.a().getResources().getDisplayMetrics().xdpi)) + 0.5d);
    }
}
