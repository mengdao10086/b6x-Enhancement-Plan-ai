package o5;

import android.text.TextUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Method f42772a = e(d("android.os.SystemProperties"));

    public static String a(String str, String str2) {
        return str == null ? str2 : str;
    }

    public static String b(String str) {
        Method method = f42772a;
        if (method != null) {
            try {
                Object objInvoke = method.invoke(null, str);
                return objInvoke == null ? "" : g(objInvoke.toString());
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static String c(String str, String str2) {
        Method method = f42772a;
        if (method != null) {
            try {
                return a(h((String) method.invoke(null, str)), str2);
            } catch (Exception unused) {
            }
        }
        return str2;
    }

    public static Class<?> d(String str) {
        try {
            try {
                return Class.forName(str);
            } catch (ClassNotFoundException unused) {
                return ClassLoader.getSystemClassLoader().loadClass(str);
            }
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    public static Method e(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod("get", String.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String f(String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }

    public static String g(String str) {
        return str == null ? "" : str.trim();
    }

    public static String h(String str) {
        String strF = f(str);
        if (TextUtils.isEmpty(strF)) {
            return null;
        }
        return strF;
    }
}
