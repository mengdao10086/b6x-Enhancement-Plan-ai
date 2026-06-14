package a;

import java.util.Collection;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class r92 {
    public static Collection a(Object obj) {
        if (!(obj instanceof s92)) {
            return c(obj);
        }
        h(obj, "kotlin.collections.MutableCollection");
        throw null;
    }

    public static Object b(Object obj, int i) {
        if (obj == null || e(obj, i)) {
            return obj;
        }
        h(obj, "kotlin.jvm.functions.Function" + i);
        throw null;
    }

    public static Collection c(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e) {
            g(e);
            throw null;
        }
    }

    public static int d(Object obj) {
        if (obj instanceof c92) {
            return ((c92) obj).h();
        }
        if (obj instanceof v72) {
            return 0;
        }
        if (obj instanceof g82) {
            return 1;
        }
        return obj instanceof k82 ? 2 : -1;
    }

    public static boolean e(Object obj, int i) {
        return (obj instanceof y32) && d(obj) == i;
    }

    public static <T extends Throwable> T f(T t) {
        f92.h(t, r92.class.getName());
        return t;
    }

    public static ClassCastException g(ClassCastException classCastException) {
        f(classCastException);
        throw classCastException;
    }

    public static void h(Object obj, String str) {
        i((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
        throw null;
    }

    public static void i(String str) {
        g(new ClassCastException(str));
        throw null;
    }
}
