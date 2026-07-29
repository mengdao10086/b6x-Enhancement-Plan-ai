package f0;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import androidx.annotation.RestrictTo;
import g.n0;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f27418a = "ActivityRecreator";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class<?> f27419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Field f27420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Field f27421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Method f27422e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Method f27423f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Method f27424g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Handler f27425h = new Handler(Looper.getMainLooper());

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f27426a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f27427b;

        public a(d dVar, Object obj) {
            this.f27426a = dVar;
            this.f27427b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f27426a.f27432a = this.f27427b;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Application f27428a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f27429b;

        public b(Application application, d dVar) {
            this.f27428a = application;
            this.f27429b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f27428a.unregisterActivityLifecycleCallbacks(this.f27429b);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f27430a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f27431b;

        public c(Object obj, Object obj2) {
            this.f27430a = obj;
            this.f27431b = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Method method = f.f27422e;
                if (method != null) {
                    method.invoke(this.f27430a, this.f27431b, Boolean.FALSE, "AppCompat recreation");
                } else {
                    f.f27423f.invoke(this.f27430a, this.f27431b, Boolean.FALSE);
                }
            } catch (RuntimeException e10) {
                if (e10.getClass() == RuntimeException.class && e10.getMessage() != null && e10.getMessage().startsWith("Unable to stop")) {
                    throw e10;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static final class d implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f27432a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Activity f27433b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f27434c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f27435d = false;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f27436e = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f27437f = false;

        public d(@n0 Activity activity) {
            this.f27433b = activity;
            this.f27434c = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f27433b == activity) {
                this.f27433b = null;
                this.f27436e = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.f27436e || this.f27437f || this.f27435d || !f.h(this.f27432a, this.f27434c, activity)) {
                return;
            }
            this.f27437f = true;
            this.f27432a = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f27433b == activity) {
                this.f27435d = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class<?> clsA = a();
        f27419b = clsA;
        f27420c = b();
        f27421d = f();
        f27422e = d(clsA);
        f27423f = c(clsA);
        f27424g = e(clsA);
    }

    public static Class<?> a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method c(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method d(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method e(Class<?> cls) {
        if (g() && cls != null) {
            try {
                Class<?> cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean g() {
        int i10 = Build.VERSION.SDK_INT;
        return i10 == 26 || i10 == 27;
    }

    public static boolean h(Object obj, int i10, Activity activity) {
        try {
            Object obj2 = f27421d.get(activity);
            if (obj2 == obj && activity.hashCode() == i10) {
                f27425h.postAtFrontOfQueue(new c(f27420c.get(activity), obj2));
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean i(@n0 Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (g() && f27424g == null) {
            return false;
        }
        if (f27423f == null && f27422e == null) {
            return false;
        }
        try {
            Object obj2 = f27421d.get(activity);
            if (obj2 == null || (obj = f27420c.get(activity)) == null) {
                return false;
            }
            Application application = activity.getApplication();
            d dVar = new d(activity);
            application.registerActivityLifecycleCallbacks(dVar);
            Handler handler = f27425h;
            handler.post(new a(dVar, obj2));
            try {
                if (g()) {
                    Method method = f27424g;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                } else {
                    activity.recreate();
                }
                handler.post(new b(application, dVar));
                return true;
            } catch (Throwable th2) {
                f27425h.post(new b(application, dVar));
                throw th2;
            }
        } catch (Throwable unused) {
            return false;
        }
    }
}
