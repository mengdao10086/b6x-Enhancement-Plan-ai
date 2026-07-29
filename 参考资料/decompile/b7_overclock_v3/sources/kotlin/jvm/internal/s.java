package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.d1;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KVisibility;
import kotlin.text.StringsKt__StringsKt;
import w.w;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nClassReference.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassReference.kt\nkotlin/jvm/internal/ClassReference\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,205:1\n1559#2:206\n1590#2,4:207\n1253#2,4:211\n1238#2,4:217\n442#3:215\n392#3:216\n*S KotlinDebug\n*F\n+ 1 ClassReference.kt\nkotlin/jvm/internal/ClassReference\n*L\n107#1:206\n107#1:207,4\n155#1:211,4\n163#1:217,4\n163#1:215\n163#1:216\n*E\n"})
public final class s implements kotlin.reflect.d<Object>, r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final a f37945b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static final Map<Class<? extends kotlin.u<?>>, Integer> f37946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final HashMap<String, String> f37947d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final HashMap<String, String> f37948e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public static final HashMap<String, String> f37949f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public static final Map<String, String> f37950g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final Class<?> f37951a;

    @t0({"SMAP\nClassReference.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassReference.kt\nkotlin/jvm/internal/ClassReference$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,205:1\n1#2:206\n*E\n"})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @yt.l
        public final String a(@yt.k Class<?> jClass) {
            String str;
            f0.p(jClass, "jClass");
            String str2 = null;
            if (jClass.isAnonymousClass() || jClass.isLocalClass()) {
                return null;
            }
            if (!jClass.isArray()) {
                String str3 = (String) s.f37949f.get(jClass.getName());
                return str3 == null ? jClass.getCanonicalName() : str3;
            }
            Class<?> componentType = jClass.getComponentType();
            if (componentType.isPrimitive() && (str = (String) s.f37949f.get(componentType.getName())) != null) {
                str2 = str + "Array";
            }
            return str2 == null ? "kotlin.Array" : str2;
        }

        @yt.l
        public final String b(@yt.k Class<?> jClass) {
            String str;
            f0.p(jClass, "jClass");
            String str2 = null;
            if (!jClass.isAnonymousClass()) {
                if (jClass.isLocalClass()) {
                    String name = jClass.getSimpleName();
                    Method enclosingMethod = jClass.getEnclosingMethod();
                    if (enclosingMethod != null) {
                        f0.o(name, "name");
                        String strQ5 = StringsKt__StringsKt.q5(name, enclosingMethod.getName() + '$', null, 2, null);
                        if (strQ5 != null) {
                            return strQ5;
                        }
                    }
                    Constructor<?> enclosingConstructor = jClass.getEnclosingConstructor();
                    if (enclosingConstructor == null) {
                        f0.o(name, "name");
                        return StringsKt__StringsKt.p5(name, '$', null, 2, null);
                    }
                    f0.o(name, "name");
                    return StringsKt__StringsKt.q5(name, enclosingConstructor.getName() + '$', null, 2, null);
                }
                if (!jClass.isArray()) {
                    String str3 = (String) s.f37950g.get(jClass.getName());
                    return str3 == null ? jClass.getSimpleName() : str3;
                }
                Class<?> componentType = jClass.getComponentType();
                if (componentType.isPrimitive() && (str = (String) s.f37950g.get(componentType.getName())) != null) {
                    str2 = str + "Array";
                }
                if (str2 == null) {
                    return "Array";
                }
            }
            return str2;
        }

        public final boolean c(@yt.l Object obj, @yt.k Class<?> jClass) {
            f0.p(jClass, "jClass");
            Map map = s.f37946c;
            f0.n(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer num = (Integer) map.get(jClass);
            if (num != null) {
                return w0.B(obj, num.intValue());
            }
            if (jClass.isPrimitive()) {
                jClass = hk.a.g(hk.a.i(jClass));
            }
            return jClass.isInstance(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i10 = 0;
        List listL = CollectionsKt__CollectionsKt.L(ik.a.class, ik.l.class, ik.p.class, ik.q.class, ik.r.class, ik.s.class, ik.t.class, ik.u.class, ik.v.class, ik.w.class, ik.b.class, ik.c.class, ik.d.class, ik.e.class, ik.f.class, ik.g.class, ik.h.class, ik.i.class, ik.j.class, ik.k.class, ik.m.class, ik.n.class, ik.o.class);
        ArrayList arrayList = new ArrayList(kotlin.collections.t.Y(listL, 10));
        for (Object obj : listL) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            arrayList.add(d1.a((Class) obj, Integer.valueOf(i10)));
            i10 = i11;
        }
        f37946c = kotlin.collections.s0.B0(arrayList);
        HashMap<String, String> map = new HashMap<>();
        map.put(w.b.f53670f, "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put(w.b.f53667c, "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        f37947d = map;
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        f37948e = map2;
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
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        f0.o(collectionValues, "primitiveFqNames.values");
        for (String kotlinName : collectionValues) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("kotlin.jvm.internal.");
            f0.o(kotlinName, "kotlinName");
            sb2.append(StringsKt__StringsKt.t5(kotlinName, '.', null, 2, null));
            sb2.append("CompanionObject");
            Pair pairA = d1.a(sb2.toString(), kotlinName + ".Companion");
            map3.put(pairA.f(), pairA.h());
        }
        for (Map.Entry<Class<? extends kotlin.u<?>>, Integer> entry : f37946c.entrySet()) {
            map3.put(entry.getKey().getName(), "kotlin.Function" + entry.getValue().intValue());
        }
        f37949f = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.collections.r0.j(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), StringsKt__StringsKt.t5((String) entry2.getValue(), '.', null, 2, null));
        }
        f37950g = linkedHashMap;
    }

    public s(@yt.k Class<?> jClass) {
        f0.p(jClass, "jClass");
        this.f37951a = jClass;
    }

    @kotlin.v0(version = "1.1")
    public static /* synthetic */ void A() {
    }

    @kotlin.v0(version = "1.1")
    public static /* synthetic */ void C() {
    }

    @kotlin.v0(version = "1.1")
    public static /* synthetic */ void E() {
    }

    @kotlin.v0(version = "1.1")
    public static /* synthetic */ void F() {
    }

    @kotlin.v0(version = "1.1")
    public static /* synthetic */ void G() {
    }

    @kotlin.v0(version = "1.1")
    public static /* synthetic */ void H() {
    }

    @kotlin.v0(version = "1.4")
    public static /* synthetic */ void N() {
    }

    @kotlin.v0(version = "1.1")
    public static /* synthetic */ void P() {
    }

    @kotlin.v0(version = "1.1")
    public static /* synthetic */ void U() {
    }

    @kotlin.v0(version = "1.1")
    public static /* synthetic */ void V() {
    }

    @kotlin.v0(version = "1.5")
    public static /* synthetic */ void X() {
    }

    @kotlin.v0(version = "1.3")
    public static /* synthetic */ void s() {
    }

    @kotlin.v0(version = "1.1")
    public static /* synthetic */ void v() {
    }

    @Override // kotlin.reflect.d
    @yt.k
    public List<kotlin.reflect.d<? extends Object>> D() {
        q();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    public boolean I() {
        q();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    public boolean J() {
        q();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    @yt.l
    public String K() {
        return f37945b.b(h());
    }

    @Override // kotlin.reflect.d
    @yt.k
    public List<kotlin.reflect.r> M() {
        q();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    @yt.l
    public Object O() {
        q();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    public boolean P0() {
        q();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    public boolean W() {
        q();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    @yt.l
    public KVisibility d() {
        q();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    public boolean equals(@yt.l Object obj) {
        return (obj instanceof s) && f0.g(hk.a.g(this), hk.a.g((kotlin.reflect.d) obj));
    }

    @Override // kotlin.reflect.d
    public boolean f() {
        q();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.b
    @yt.k
    public List<Annotation> getAnnotations() {
        q();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    @yt.k
    public List<kotlin.reflect.s> getTypeParameters() {
        q();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.internal.r
    @yt.k
    public Class<?> h() {
        return this.f37951a;
    }

    @Override // kotlin.reflect.d
    public int hashCode() {
        return hk.a.g(this).hashCode();
    }

    @Override // kotlin.reflect.d
    public boolean isOpen() {
        q();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    public boolean k() {
        q();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    public boolean l0() {
        q();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d, kotlin.reflect.h
    @yt.k
    public Collection<kotlin.reflect.c<?>> n() {
        q();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    @yt.l
    public String p() {
        return f37945b.a(h());
    }

    public final Void q() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.d
    @yt.k
    public Collection<kotlin.reflect.d<?>> r() {
        q();
        throw new KotlinNothingValueException();
    }

    @yt.k
    public String toString() {
        return h().toString() + n0.f37924b;
    }

    @Override // kotlin.reflect.d
    @yt.k
    public Collection<kotlin.reflect.i<Object>> x() {
        q();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    @kotlin.v0(version = "1.1")
    public boolean x0(@yt.l Object obj) {
        return f37945b.c(obj, h());
    }

    @Override // kotlin.reflect.d
    public boolean z() {
        q();
        throw new KotlinNothingValueException();
    }
}
