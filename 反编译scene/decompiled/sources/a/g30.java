package a;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class g30 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Double f6164a = Double.valueOf(-0.0d);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Object f959a = new f30();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LinkedHashMap<String, Object> f960a;

    public g30() {
        this.f960a = new LinkedHashMap<>();
    }

    public g30(j30 j30Var) throws e30 {
        Object objD = j30Var.d();
        if (objD instanceof g30) {
            this.f960a = ((g30) objD).f960a;
        } else {
            c30.h(objD, "JSONObject");
            throw null;
        }
    }

    public g30(String str) {
        this(new j30(str));
    }

    public g30(Map map) {
        this();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (str == null) {
                throw new NullPointerException("key == null");
            }
            this.f960a.put(str, B(entry.getValue()));
        }
    }

    public static Object B(Object obj) {
        if (obj == null) {
            return f959a;
        }
        if ((obj instanceof d30) || (obj instanceof g30) || obj.equals(f959a)) {
            return obj;
        }
        if (obj instanceof Collection) {
            return new d30((Collection) obj);
        }
        if (obj.getClass().isArray()) {
            return new d30(obj);
        }
        if (obj instanceof Map) {
            return new g30((Map) obj);
        }
        if (!(obj instanceof Boolean) && !(obj instanceof Byte) && !(obj instanceof Character) && !(obj instanceof Double) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Short) && !(obj instanceof String)) {
            if (obj.getClass().getPackage().getName().startsWith("java.")) {
                return obj.toString();
            }
            return null;
        }
        return obj;
    }

    public static String l(Number number) throws e30 {
        if (number == null) {
            throw new e30("Number must be non-null");
        }
        double dDoubleValue = number.doubleValue();
        c30.a(dDoubleValue);
        if (number.equals(f6164a)) {
            return "-0";
        }
        long jLongValue = number.longValue();
        return dDoubleValue == ((double) jLongValue) ? Long.toString(jLongValue) : number.toString();
    }

    public String A(int i) {
        i30 i30Var = new i30(i);
        C(i30Var);
        return i30Var.toString();
    }

    public void C(i30 i30Var) {
        i30Var.i();
        for (Map.Entry<String, Object> entry : this.f960a.entrySet()) {
            i30Var.g(entry.getKey());
            i30Var.n(entry.getValue());
        }
        i30Var.f();
    }

    public String a(String str) throws e30 {
        if (str != null) {
            return str;
        }
        throw new e30("Names must be non-null");
    }

    public Object b(String str) {
        Object obj = this.f960a.get(str);
        if (obj != null) {
            return obj;
        }
        throw new e30("No value for " + str);
    }

    public boolean c(String str) throws e30 {
        Object objB = b(str);
        Boolean boolB = c30.b(objB);
        if (boolB != null) {
            return boolB.booleanValue();
        }
        c30.g(str, objB, "boolean");
        throw null;
    }

    public double d(String str) throws e30 {
        Object objB = b(str);
        Double dC = c30.c(objB);
        if (dC != null) {
            return dC.doubleValue();
        }
        c30.g(str, objB, "double");
        throw null;
    }

    public int e(String str) throws e30 {
        Object objB = b(str);
        Integer numD = c30.d(objB);
        if (numD != null) {
            return numD.intValue();
        }
        c30.g(str, objB, "int");
        throw null;
    }

    public d30 f(String str) throws e30 {
        Object objB = b(str);
        if (objB instanceof d30) {
            return (d30) objB;
        }
        c30.g(str, objB, "JSONArray");
        throw null;
    }

    public g30 g(String str) throws e30 {
        Object objB = b(str);
        if (objB instanceof g30) {
            return (g30) objB;
        }
        c30.g(str, objB, "JSONObject");
        throw null;
    }

    public long h(String str) throws e30 {
        Object objB = b(str);
        Long lE = c30.e(objB);
        if (lE != null) {
            return lE.longValue();
        }
        c30.g(str, objB, "long");
        throw null;
    }

    public String i(String str) {
        Object objB = b(str);
        String strF = c30.f(objB);
        if (strF != null) {
            return strF;
        }
        c30.g(str, objB, "String");
        throw null;
    }

    public boolean j(String str) {
        return this.f960a.containsKey(str);
    }

    public Iterator<String> k() {
        return this.f960a.keySet().iterator();
    }

    public Object m(String str) {
        return this.f960a.get(str);
    }

    public int n(String str) {
        return o(str, 0);
    }

    public int o(String str, int i) {
        Integer numD = c30.d(m(str));
        return numD != null ? numD.intValue() : i;
    }

    public d30 p(String str) {
        Object objM = m(str);
        if (objM instanceof d30) {
            return (d30) objM;
        }
        return null;
    }

    public g30 q(String str) {
        Object objM = m(str);
        if (objM instanceof g30) {
            return (g30) objM;
        }
        return null;
    }

    public long r(String str) {
        return s(str, 0L);
    }

    public long s(String str, long j) {
        Long lE = c30.e(m(str));
        return lE != null ? lE.longValue() : j;
    }

    public String t(String str) {
        return u(str, "");
    }

    public String toString() {
        try {
            i30 i30Var = new i30();
            C(i30Var);
            return i30Var.toString();
        } catch (e30 unused) {
            return null;
        }
    }

    public String u(String str, String str2) {
        String strF = c30.f(m(str));
        return strF != null ? strF : str2;
    }

    public g30 v(String str, int i) {
        LinkedHashMap<String, Object> linkedHashMap = this.f960a;
        a(str);
        linkedHashMap.put(str, Integer.valueOf(i));
        return this;
    }

    public g30 w(String str, long j) throws e30 {
        LinkedHashMap<String, Object> linkedHashMap = this.f960a;
        a(str);
        linkedHashMap.put(str, Long.valueOf(j));
        return this;
    }

    public g30 x(String str, Object obj) {
        if (obj == null) {
            this.f960a.remove(str);
            return this;
        }
        if (obj instanceof Number) {
            c30.a(((Number) obj).doubleValue());
        }
        LinkedHashMap<String, Object> linkedHashMap = this.f960a;
        a(str);
        linkedHashMap.put(str, obj);
        return this;
    }

    public g30 y(String str, boolean z) {
        LinkedHashMap<String, Object> linkedHashMap = this.f960a;
        a(str);
        linkedHashMap.put(str, Boolean.valueOf(z));
        return this;
    }

    public Object z(String str) {
        return this.f960a.remove(str);
    }
}
