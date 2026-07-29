package pl;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f46704a = "c";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f46705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static c f46706c;

    public c() {
        f46705b = d(b("android.os.SystemProperties"));
    }

    public static c c() {
        if (f46706c == null) {
            synchronized (c.class) {
                if (f46706c == null) {
                    f46706c = new c();
                }
            }
        }
        return f46706c;
    }

    public final String a(String str) {
        if (str == null) {
            return "";
        }
        try {
            Method method = f46705b;
            String str2 = (String) (method != null ? method.invoke(null, str) : null);
            if (str2 != null) {
                return str2.trim();
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public final Class b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            e10.getMessage();
            try {
                return ClassLoader.getSystemClassLoader().loadClass(str);
            } catch (ClassNotFoundException e11) {
                e11.getMessage();
                return null;
            }
        }
    }

    public final Method d(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod("get", String.class);
        } catch (Exception e10) {
            e10.getMessage();
            return null;
        }
    }
}
