package gu;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30092a = "IdentifierManager";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Object f30093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f30094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f30095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Method f30096e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Method f30097f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Method f30098g;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f30094c = cls;
            f30093b = cls.newInstance();
            f30095d = f30094c.getMethod("getUDID", Context.class);
            f30096e = f30094c.getMethod("getOAID", Context.class);
            f30097f = f30094c.getMethod("getVAID", Context.class);
            f30098g = f30094c.getMethod("getAAID", Context.class);
        } catch (Exception unused) {
        }
    }

    public static String a(Context context) {
        return b(context, f30095d);
    }

    public static String b(Context context, Method method) {
        Object obj = f30093b;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(obj, context);
            if (objInvoke != null) {
                return (String) objInvoke;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean c() {
        return (f30094c == null || f30093b == null) ? false : true;
    }

    public static String d(Context context) {
        return b(context, f30096e);
    }

    public static String e(Context context) {
        return b(context, f30097f);
    }

    public static String f(Context context) {
        return b(context, f30098g);
    }
}
