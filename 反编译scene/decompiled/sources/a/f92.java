package a;

import java.util.Arrays;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class f92 {
    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void b(Object obj) {
        if (obj != null) {
            return;
        }
        j();
        throw null;
    }

    public static void c(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str + " must not be null");
        g(nullPointerException);
        throw nullPointerException;
    }

    public static void d(Object obj, String str) {
        if (obj != null) {
            return;
        }
        k(str);
        throw null;
    }

    public static int e(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static String f(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    public static <T extends Throwable> T g(T t) {
        h(t, f92.class.getName());
        return t;
    }

    public static <T extends Throwable> T h(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }

    public static String i(String str, Object obj) {
        return str + obj;
    }

    public static void j() {
        NullPointerException nullPointerException = new NullPointerException();
        g(nullPointerException);
        throw nullPointerException;
    }

    public static void k(String str) {
        NullPointerException nullPointerException = new NullPointerException(f(str));
        g(nullPointerException);
        throw nullPointerException;
    }

    public static void l(String str) {
        l42 l42Var = new l42(str);
        g(l42Var);
        throw l42Var;
    }

    public static void m(String str) {
        l("lateinit property " + str + " has not been initialized");
        throw null;
    }
}
