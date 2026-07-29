package w0;

import android.annotation.SuppressLint;
import android.os.Build;
import android.telephony.TelephonyManager;
import g.n0;
import g.p0;
import g.u;
import g.v0;
import g.y0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Method f53826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f53827b;

    @v0(23)
    public static class a {
        @y0("android.permission.READ_PHONE_STATE")
        @SuppressLint({"MissingPermission"})
        @u
        @p0
        public static String a(TelephonyManager telephonyManager, int i10) {
            return telephonyManager.getDeviceId(i10);
        }
    }

    /* JADX INFO: renamed from: w0.b$b, reason: collision with other inner class name */
    @v0(26)
    public static class C0631b {
        @y0("android.permission.READ_PHONE_STATE")
        @SuppressLint({"MissingPermission"})
        @u
        @p0
        public static String a(TelephonyManager telephonyManager) {
            return telephonyManager.getImei();
        }
    }

    @v0(30)
    public static class c {
        @u
        public static int a(TelephonyManager telephonyManager) {
            return telephonyManager.getSubscriptionId();
        }
    }

    @p0
    @y0("android.permission.READ_PHONE_STATE")
    @SuppressLint({"MissingPermission"})
    public static String a(@n0 TelephonyManager telephonyManager) {
        int iB;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            return C0631b.a(telephonyManager);
        }
        if (i10 < 22 || (iB = b(telephonyManager)) == Integer.MAX_VALUE || iB == -1) {
            return telephonyManager.getDeviceId();
        }
        int iA = w0.a.a(iB);
        if (i10 >= 23) {
            return a.a(telephonyManager, iA);
        }
        try {
            if (f53826a == null) {
                Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getDeviceId", Integer.TYPE);
                f53826a = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            return (String) f53826a.invoke(telephonyManager, Integer.valueOf(iA));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static int b(@n0 TelephonyManager telephonyManager) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            return c.a(telephonyManager);
        }
        if (i10 < 22) {
            return Integer.MAX_VALUE;
        }
        try {
            if (f53827b == null) {
                Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getSubId", new Class[0]);
                f53827b = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            Integer num = (Integer) f53827b.invoke(telephonyManager, new Object[0]);
            if (num == null || num.intValue() == -1) {
                return Integer.MAX_VALUE;
            }
            return num.intValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return Integer.MAX_VALUE;
        }
    }
}
