package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class c30 {
    public static double a(double d) throws e30 {
        if (!Double.isInfinite(d) && !Double.isNaN(d)) {
            return d;
        }
        throw new e30("Forbidden numeric value: " + d);
    }

    public static Boolean b(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (!(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        if ("true".equalsIgnoreCase(str)) {
            return Boolean.TRUE;
        }
        if ("false".equalsIgnoreCase(str)) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static Double c(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (!(obj instanceof String)) {
            return null;
        }
        try {
            return Double.valueOf((String) obj);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Integer d(Object obj) {
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (!(obj instanceof String)) {
            return null;
        }
        try {
            return Integer.valueOf((int) Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Long e(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (!(obj instanceof String)) {
            return null;
        }
        try {
            return Long.valueOf((long) Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static String f(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj != null) {
            return String.valueOf(obj);
        }
        return null;
    }

    public static e30 g(Object obj, Object obj2, String str) throws e30 {
        if (obj2 == null) {
            throw new e30("Value at " + obj + " is null.");
        }
        throw new e30("Value " + obj2 + " at " + obj + " of type " + obj2.getClass().getName() + " cannot be converted to " + str);
    }

    public static e30 h(Object obj, String str) throws e30 {
        if (obj == null) {
            throw new e30("Value is null.");
        }
        throw new e30("Value " + obj + " of type " + obj.getClass().getName() + " cannot be converted to " + str);
    }
}
