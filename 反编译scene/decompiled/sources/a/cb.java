package a;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class cb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f5773a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Class<?> f361a = a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Field f362a = b();
    public static final Field b = f();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Method f363a = d(f361a);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final Method f364b = c(f361a);
    public static final Method c = e(f361a);

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
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE);
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
        int i = Build.VERSION.SDK_INT;
        return i == 26 || i == 27;
    }

    public static boolean h(Object obj, int i, Activity activity) {
        try {
            Object obj2 = b.get(activity);
            if (obj2 == obj && activity.hashCode() == i) {
                f5773a.postAtFrontOfQueue(new ab(f362a.get(activity), obj2));
                return true;
            }
            return false;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    public static boolean i(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (g() && c == null) {
            return false;
        }
        if (f364b == null && f363a == null) {
            return false;
        }
        try {
            Object obj2 = b.get(activity);
            if (obj2 == null || (obj = f362a.get(activity)) == null) {
                return false;
            }
            Application application = activity.getApplication();
            bb bbVar = new bb(activity);
            application.registerActivityLifecycleCallbacks(bbVar);
            f5773a.post(new ya(bbVar, obj2));
            try {
                if (g()) {
                    c.invoke(obj, obj2, null, null, 0, Boolean.FALSE, null, null, Boolean.FALSE, Boolean.FALSE);
                } else {
                    activity.recreate();
                }
                return true;
            } finally {
                f5773a.post(new za(application, bbVar));
            }
        } catch (Throwable unused) {
            return false;
        }
    }
}
