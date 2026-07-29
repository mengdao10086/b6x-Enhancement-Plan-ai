package androidx.core.util;

import g.n0;
import g.p0;
import g.v0;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    @v0(19)
    public static class a {
        @g.u
        public static boolean a(Object obj, Object obj2) {
            return Objects.equals(obj, obj2);
        }

        @g.u
        public static int b(Object... objArr) {
            return Objects.hash(objArr);
        }
    }

    public static boolean a(@p0 Object obj, @p0 Object obj2) {
        return a.a(obj, obj2);
    }

    public static int b(@p0 Object... objArr) {
        return a.b(objArr);
    }

    public static int c(@p0 Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    @n0
    public static <T> T d(@p0 T t10) {
        Objects.requireNonNull(t10);
        return t10;
    }

    @n0
    public static <T> T e(@p0 T t10, @n0 String str) {
        Objects.requireNonNull(t10, str);
        return t10;
    }

    @p0
    public static String f(@p0 Object obj, @p0 String str) {
        return obj != null ? obj.toString() : str;
    }
}
