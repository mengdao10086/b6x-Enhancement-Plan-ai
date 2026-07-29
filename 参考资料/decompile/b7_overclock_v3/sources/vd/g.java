package vd;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import com.google.android.material.R;
import g.d1;
import g.n0;
import g.p0;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import vd.h;

/* JADX INFO: loaded from: classes3.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f53064a = {R.attr.dynamicColorThemeOverlay};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f53065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SuppressLint({"PrivateApi"})
    public static final c f53066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, c> f53067d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, c> f53068e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f53069f = 0;

    public class a implements c {
        @Override // vd.g.c
        public boolean a() {
            return true;
        }
    }

    public class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f53070a;

        @Override // vd.g.c
        public boolean a() {
            if (this.f53070a == null) {
                try {
                    Method declaredMethod = Build.class.getDeclaredMethod("getLong", String.class);
                    declaredMethod.setAccessible(true);
                    this.f53070a = Long.valueOf(((Long) declaredMethod.invoke(null, "ro.build.version.oneui")).longValue());
                } catch (Exception unused) {
                    this.f53070a = -1L;
                }
            }
            return this.f53070a.longValue() >= 40100;
        }
    }

    public interface c {
        boolean a();
    }

    public static class d implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h f53071a;

        public d(@n0 h hVar) {
            this.f53071a = hVar;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@n0 Activity activity, @p0 Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@n0 Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@n0 Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(@n0 Activity activity, @p0 Bundle bundle) {
            g.k(activity, this.f53071a.e(), this.f53071a.d(), this.f53071a.c());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@n0 Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@n0 Activity activity, @n0 Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@n0 Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@n0 Activity activity) {
        }
    }

    public interface e {
        void a(@n0 Activity activity);
    }

    public interface f {
        boolean a(@n0 Activity activity, @d1 int i10);
    }

    static {
        a aVar = new a();
        f53065b = aVar;
        b bVar = new b();
        f53066c = bVar;
        HashMap map = new HashMap();
        map.put("fcnt", aVar);
        map.put("google", aVar);
        map.put("hmd global", aVar);
        map.put("infinix", aVar);
        map.put("infinix mobility limited", aVar);
        map.put("itel", aVar);
        map.put("kyocera", aVar);
        map.put("lenovo", aVar);
        map.put(com.google.android.material.internal.i.f20421a, aVar);
        map.put("motorola", aVar);
        map.put("nothing", aVar);
        map.put("oneplus", aVar);
        map.put("oppo", aVar);
        map.put("realme", aVar);
        map.put("robolectric", aVar);
        map.put(com.google.android.material.internal.i.f20422b, bVar);
        map.put("sharp", aVar);
        map.put("sony", aVar);
        map.put("tcl", aVar);
        map.put("tecno", aVar);
        map.put("tecno mobile limited", aVar);
        map.put("vivo", aVar);
        map.put("xiaomi", aVar);
        f53067d = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("asus", aVar);
        map2.put("jio", aVar);
        f53068e = Collections.unmodifiableMap(map2);
    }

    @Deprecated
    public static void b(@n0 Activity activity) {
        j(activity);
    }

    @Deprecated
    public static void c(@n0 Activity activity, @d1 int i10) {
        l(activity, new h.c().g(i10).d());
    }

    @Deprecated
    public static void d(@n0 Activity activity, @n0 f fVar) {
        l(activity, new h.c().f(fVar).d());
    }

    public static void e(@n0 Application application) {
        i(application, new h.c().d());
    }

    @Deprecated
    public static void f(@n0 Application application, @d1 int i10) {
        i(application, new h.c().g(i10).d());
    }

    @Deprecated
    public static void g(@n0 Application application, @d1 int i10, @n0 f fVar) {
        i(application, new h.c().g(i10).f(fVar).d());
    }

    @Deprecated
    public static void h(@n0 Application application, @n0 f fVar) {
        i(application, new h.c().f(fVar).d());
    }

    public static void i(@n0 Application application, @n0 h hVar) {
        application.registerActivityLifecycleCallbacks(new d(hVar));
    }

    public static void j(@n0 Activity activity) {
        l(activity, new h.c().d());
    }

    public static void k(@n0 Activity activity, @d1 int i10, @n0 f fVar, @n0 e eVar) {
        if (n()) {
            if (i10 == 0) {
                i10 = m(activity);
            }
            if (i10 == 0 || !fVar.a(activity, i10)) {
                return;
            }
            o.a(activity, i10);
            eVar.a(activity);
        }
    }

    public static void l(@n0 Activity activity, @n0 h hVar) {
        k(activity, hVar.e(), hVar.d(), hVar.c());
    }

    public static int m(@n0 Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f53064a);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    @g.k(api = 31)
    @SuppressLint({"DefaultLocale"})
    public static boolean n() {
        if (Build.VERSION.SDK_INT < 31) {
            return false;
        }
        if (androidx.core.os.a.k()) {
            return true;
        }
        c cVar = f53067d.get(Build.MANUFACTURER.toLowerCase());
        if (cVar == null) {
            cVar = f53068e.get(Build.BRAND.toLowerCase());
        }
        return cVar != null && cVar.a();
    }

    @n0
    public static Context o(@n0 Context context) {
        return p(context, 0);
    }

    @n0
    public static Context p(@n0 Context context, @d1 int i10) {
        if (!n()) {
            return context;
        }
        if (i10 == 0) {
            i10 = m(context);
        }
        return i10 == 0 ? context : new ContextThemeWrapper(context, i10);
    }
}
