package a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class z82 implements ia2<Object>, y82 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, String> f8046a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Map<Class<? extends y32<?>>, Integer> f3802a;
    public static final HashMap<String, String> b;
    public static final HashMap<String, String> c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Class<?> f3803a;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i = 0;
        List listH = y42.h(v72.class, g82.class, k82.class, l82.class, m82.class, n82.class, o82.class, p82.class, q82.class, r82.class, w72.class, x72.class, y72.class, z72.class, a82.class, b82.class, c82.class, d82.class, e82.class, f82.class, h82.class, i82.class, j82.class);
        ArrayList arrayList = new ArrayList(z42.m(listH, 10));
        for (Object obj : listH) {
            int i2 = i + 1;
            if (i < 0) {
                y42.l();
                throw null;
            }
            arrayList.add(j42.a((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        f3802a = t52.j(arrayList);
        HashMap<String, String> map = new HashMap<>();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        f8046a = map;
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        b = map2;
        HashMap<String, String> map3 = new HashMap<>();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(f8046a);
        map3.putAll(b);
        Collection<String> collectionValues = f8046a.values();
        f92.c(collectionValues, "primitiveFqNames.values");
        for (String str : collectionValues) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            f92.c(str, "kotlinName");
            sb.append(ec2.m0(str, '.', null, 2, null));
            sb.append("CompanionObject");
            d42 d42VarA = j42.a(sb.toString(), str + ".Companion");
            map3.put(d42VarA.c(), d42VarA.d());
        }
        for (Map.Entry<Class<? extends y32<?>>, Integer> entry : f3802a.entrySet()) {
            Class<? extends y32<?>> key = entry.getKey();
            int iIntValue = entry.getValue().intValue();
            map3.put(key.getName(), "kotlin.Function" + iIntValue);
        }
        c = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(s52.a(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), ec2.m0((String) entry2.getValue(), '.', null, 2, null));
        }
    }

    public z82(Class<?> cls) {
        f92.d(cls, "jClass");
        this.f3803a = cls;
    }

    @Override // a.y82
    public Class<?> a() {
        return this.f3803a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof z82) && f92.a(u72.a(this), u72.a((ia2) obj));
    }

    public int hashCode() {
        return u72.a(this).hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
