package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Process;
import android.os.UserHandle;
import g.v0;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class x {

    @v0(16)
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Object f4676a = new Object();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static Method f4677b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static boolean f4678c;

        @SuppressLint({"PrivateApi"})
        public static boolean a(int i10) {
            try {
                synchronized (f4676a) {
                    if (!f4678c) {
                        f4678c = true;
                        f4677b = Class.forName("android.os.UserId").getDeclaredMethod("isApp", Integer.TYPE);
                    }
                }
                Method method = f4677b;
                if (method != null) {
                    Boolean bool = (Boolean) method.invoke(null, Integer.valueOf(i10));
                    if (bool != null) {
                        return bool.booleanValue();
                    }
                    throw new NullPointerException();
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            return true;
        }
    }

    @v0(17)
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Object f4679a = new Object();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static Method f4680b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static boolean f4681c;

        @SuppressLint({"DiscouragedPrivateApi"})
        public static boolean a(int i10) {
            try {
                synchronized (f4679a) {
                    if (!f4681c) {
                        f4681c = true;
                        f4680b = UserHandle.class.getDeclaredMethod("isApp", Integer.TYPE);
                    }
                }
                Method method = f4680b;
                if (method != null) {
                    Boolean bool = (Boolean) method.invoke(null, Integer.valueOf(i10));
                    if (bool != null) {
                        return bool.booleanValue();
                    }
                    throw new NullPointerException();
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            return true;
        }
    }

    @v0(24)
    public static class c {
        public static boolean a(int i10) {
            return Process.isApplicationUid(i10);
        }
    }

    public static boolean a(int i10) {
        return Build.VERSION.SDK_INT >= 24 ? c.a(i10) : b.a(i10);
    }
}
