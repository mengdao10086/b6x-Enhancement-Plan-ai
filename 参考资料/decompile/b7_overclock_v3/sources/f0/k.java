package f0;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.IBinder;
import g.n0;
import g.p0;
import g.v0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    @v0(18)
    public static class a {
        @g.u
        public static IBinder a(Bundle bundle, String str) {
            return bundle.getBinder(str);
        }

        @g.u
        public static void b(Bundle bundle, String str, IBinder iBinder) {
            bundle.putBinder(str, iBinder);
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f27508a = "BundleCompatBaseImpl";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static Method f27509b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static boolean f27510c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static Method f27511d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static boolean f27512e;

        public static IBinder a(Bundle bundle, String str) {
            if (!f27510c) {
                try {
                    Method method = Bundle.class.getMethod("getIBinder", String.class);
                    f27509b = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                }
                f27510c = true;
            }
            Method method2 = f27509b;
            if (method2 != null) {
                try {
                    return (IBinder) method2.invoke(bundle, str);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
                    f27509b = null;
                }
            }
            return null;
        }

        public static void b(Bundle bundle, String str, IBinder iBinder) {
            if (!f27512e) {
                try {
                    Method method = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                    f27511d = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                }
                f27512e = true;
            }
            Method method2 = f27511d;
            if (method2 != null) {
                try {
                    method2.invoke(bundle, str, iBinder);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
                    f27511d = null;
                }
            }
        }
    }

    @p0
    public static IBinder a(@n0 Bundle bundle, @p0 String str) {
        return a.a(bundle, str);
    }

    public static void b(@n0 Bundle bundle, @p0 String str, @p0 IBinder iBinder) {
        a.b(bundle, str, iBinder);
    }
}
