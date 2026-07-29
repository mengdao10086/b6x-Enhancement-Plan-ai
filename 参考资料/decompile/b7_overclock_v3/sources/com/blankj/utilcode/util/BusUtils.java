package com.blankj.utilcode.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
public final class BusUtils {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f11435e = "nULl";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f11436f = "BusUtils";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, List<c>> f11437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Set<Object>> f11438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, List<String>> f11439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Map<String, Object>> f11440d;

    public enum ThreadMode {
        MAIN,
        IO,
        CPU,
        CACHED,
        SINGLE,
        POSTING
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f11441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f11442b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f11443c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f11444d;

        public a(Object obj, Object obj2, c cVar, boolean z10) {
            this.f11441a = obj;
            this.f11442b = obj2;
            this.f11443c = cVar;
            this.f11444d = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            BusUtils.this.t(this.f11441a, this.f11442b, this.f11443c, this.f11444d);
        }
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface b {
        int priority() default 0;

        boolean sticky() default false;

        String tag();

        ThreadMode threadMode() default ThreadMode.POSTING;
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11446a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f11447b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f11448c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f11449d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f11450e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f11451f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f11452g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f11453h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Method f11454i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public List<String> f11455j = new CopyOnWriteArrayList();

        public c(String str, String str2, String str3, String str4, String str5, boolean z10, String str6, int i10) {
            this.f11446a = str;
            this.f11447b = str2;
            this.f11448c = str3;
            this.f11449d = str4;
            this.f11450e = str5;
            this.f11451f = z10;
            this.f11452g = str6;
            this.f11453h = i10;
        }

        public final String a() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f11447b);
            sb2.append("#");
            sb2.append(this.f11448c);
            if ("".equals(this.f11449d)) {
                str = "()";
            } else {
                str = ee.a.f26978c + this.f11449d + i0.f11861z + this.f11450e + ee.a.f26979d;
            }
            sb2.append(str);
            return sb2.toString();
        }

        public String toString() {
            return "BusInfo { tag : " + this.f11446a + ", desc: " + a() + ", sticky: " + this.f11451f + ", threadMode: " + this.f11452g + ", method: " + this.f11454i + ", priority: " + this.f11453h + " }";
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final BusUtils f11456a = new BusUtils(null);
    }

    public /* synthetic */ BusUtils(a aVar) {
        this();
    }

    public static void A(String str) {
        e().B(str);
    }

    public static String C() {
        return e().toString();
    }

    public static void D(Object obj) {
        e().E(obj);
    }

    public static BusUtils e() {
        return d.f11456a;
    }

    public static void m(String str) {
        n(str, f11435e);
    }

    public static void n(String str, Object obj) {
        e().o(str, obj);
    }

    public static void q(String str) {
        r(str, f11435e);
    }

    public static void r(String str, Object obj) {
        e().s(str, obj);
    }

    public static void v(Object obj) {
        e().z(obj);
    }

    public static void y(String str, String str2, String str3, String str4, String str5, boolean z10, String str6, int i10) {
        e().x(str, str2, str3, str4, str5, z10, str6, i10);
    }

    public final void B(String str) {
        List<c> list = this.f11437a.get(str);
        if (list == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("The bus of tag <");
            sb2.append(str);
            sb2.append("> is not exists.");
            return;
        }
        for (c cVar : list) {
            if (cVar.f11451f) {
                synchronized (this.f11440d) {
                    Map<String, Object> map = this.f11440d.get(cVar.f11447b);
                    if (map != null && map.containsKey(str)) {
                        map.remove(str);
                    }
                    return;
                }
            }
        }
    }

    public final void E(Object obj) {
        if (obj == null) {
            return;
        }
        String name = obj.getClass().getName();
        synchronized (this.f11438b) {
            Set<Object> set = this.f11438b.get(name);
            if (set != null && set.contains(obj)) {
                set.remove(obj);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("The bus of <");
            sb2.append(obj);
            sb2.append("> was not registered before.");
        }
    }

    public final void b(Object obj, String str, Object obj2) {
        List<c> list = this.f11437a.get(str);
        if (list == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("The bus of tag <");
            sb2.append(str);
            sb2.append("> is not exists.");
            return;
        }
        for (c cVar : list) {
            if (cVar.f11455j.contains(obj.getClass().getName()) && cVar.f11451f) {
                synchronized (this.f11440d) {
                    Map<String, Object> map = this.f11440d.get(cVar.f11447b);
                    if (map != null && map.containsKey(str)) {
                        i(obj, obj2, cVar, true);
                    }
                }
            }
        }
    }

    public final void c(Object obj) {
        Map<String, Object> map = this.f11440d.get(obj.getClass().getName());
        if (map == null) {
            return;
        }
        synchronized (this.f11440d) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                b(obj, entry.getKey(), entry.getValue());
            }
        }
    }

    public final Class d(String str) throws ClassNotFoundException {
        str.hashCode();
        switch (str) {
            case "double":
                return Double.TYPE;
            case "int":
                return Integer.TYPE;
            case "byte":
                return Byte.TYPE;
            case "char":
                return Character.TYPE;
            case "long":
                return Long.TYPE;
            case "boolean":
                return Boolean.TYPE;
            case "float":
                return Float.TYPE;
            case "short":
                return Short.TYPE;
            default:
                return Class.forName(str);
        }
    }

    public final Method f(c cVar) {
        try {
            return "".equals(cVar.f11449d) ? Class.forName(cVar.f11447b).getDeclaredMethod(cVar.f11448c, new Class[0]) : Class.forName(cVar.f11447b).getDeclaredMethod(cVar.f11448c, d(cVar.f11449d));
        } catch (ClassNotFoundException e10) {
            e10.printStackTrace();
            return null;
        } catch (NoSuchMethodException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public final void g() {
    }

    public final void h(Object obj, c cVar, boolean z10) {
        i(null, obj, cVar, z10);
    }

    public final void i(Object obj, Object obj2, c cVar, boolean z10) {
        if (cVar.f11454i == null) {
            Method methodF = f(cVar);
            if (methodF == null) {
                return;
            } else {
                cVar.f11454i = methodF;
            }
        }
        l(obj, obj2, cVar, z10);
    }

    public final void j(Object obj, c cVar, Set<Object> set) {
        try {
            if (obj == f11435e) {
                Iterator<Object> it2 = set.iterator();
                while (it2.hasNext()) {
                    cVar.f11454i.invoke(it2.next(), new Object[0]);
                }
            } else {
                Iterator<Object> it3 = set.iterator();
                while (it3.hasNext()) {
                    cVar.f11454i.invoke(it3.next(), obj);
                }
            }
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
        } catch (InvocationTargetException e11) {
            e11.printStackTrace();
        }
    }

    public final void k(Object obj, c cVar, boolean z10) {
        l(null, obj, cVar, z10);
    }

    public final void l(Object obj, Object obj2, c cVar, boolean z10) {
        a aVar;
        aVar = new a(obj, obj2, cVar, z10);
        String str = cVar.f11452g;
        str.hashCode();
        switch (str) {
            case "SINGLE":
                ThreadUtils.p0().execute(aVar);
                break;
            case "IO":
                ThreadUtils.k0().execute(aVar);
                break;
            case "CPU":
                ThreadUtils.f0().execute(aVar);
                break;
            case "MAIN":
                ThreadUtils.s0(aVar);
                break;
            case "CACHED":
                ThreadUtils.d0().execute(aVar);
                break;
            default:
                aVar.run();
                break;
        }
    }

    public final void o(String str, Object obj) {
        p(str, obj, false);
    }

    public final void p(String str, Object obj, boolean z10) {
        List<c> list = this.f11437a.get(str);
        if (list != null) {
            Iterator<c> it2 = list.iterator();
            while (it2.hasNext()) {
                h(obj, it2.next(), z10);
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("The bus of tag <");
            sb2.append(str);
            sb2.append("> is not exists.");
            this.f11437a.isEmpty();
        }
    }

    public final void s(String str, Object obj) {
        List<c> list = this.f11437a.get(str);
        if (list == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("The bus of tag <");
            sb2.append(str);
            sb2.append("> is not exists.");
            return;
        }
        for (c cVar : list) {
            if (cVar.f11451f) {
                synchronized (this.f11440d) {
                    Map<String, Object> concurrentHashMap = this.f11440d.get(cVar.f11447b);
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap<>();
                        this.f11440d.put(cVar.f11447b, concurrentHashMap);
                    }
                    concurrentHashMap.put(str, obj);
                }
                h(obj, cVar, true);
            } else {
                h(obj, cVar, false);
            }
        }
    }

    public final void t(Object obj, Object obj2, c cVar, boolean z10) {
        Set<Object> hashSet = new HashSet<>();
        if (obj == null) {
            Iterator<String> it2 = cVar.f11455j.iterator();
            while (it2.hasNext()) {
                Set<Object> set = this.f11438b.get(it2.next());
                if (set != null && !set.isEmpty()) {
                    hashSet.addAll(set);
                }
            }
            if (hashSet.size() == 0) {
                if (z10) {
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("The ");
                sb2.append(cVar);
                sb2.append(" was not registered before.");
                return;
            }
        } else {
            hashSet.add(obj);
        }
        j(obj2, cVar, hashSet);
    }

    public String toString() {
        return "BusUtils: " + this.f11437a;
    }

    public final void u(Class<?> cls, String str) {
        if (this.f11439c.get(str) == null) {
            synchronized (this.f11439c) {
                if (this.f11439c.get(str) == null) {
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    for (Map.Entry<String, List<c>> entry : this.f11437a.entrySet()) {
                        for (c cVar : entry.getValue()) {
                            try {
                                if (Class.forName(cVar.f11447b).isAssignableFrom(cls)) {
                                    copyOnWriteArrayList.add(entry.getKey());
                                    cVar.f11455j.add(str);
                                }
                            } catch (ClassNotFoundException e10) {
                                e10.printStackTrace();
                            }
                        }
                    }
                    this.f11439c.put(str, copyOnWriteArrayList);
                }
            }
        }
    }

    public final void w(String str, String str2, String str3, String str4, String str5, boolean z10, String str6) {
        x(str, str2, str3, str4, str5, z10, str6, 0);
    }

    public final void x(String str, String str2, String str3, String str4, String str5, boolean z10, String str6, int i10) {
        List<c> copyOnWriteArrayList = this.f11437a.get(str);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f11437a.put(str, copyOnWriteArrayList);
        }
        copyOnWriteArrayList.add(new c(str, str2, str3, str4, str5, z10, str6, i10));
    }

    public final void z(Object obj) {
        if (obj == null) {
            return;
        }
        Class<?> cls = obj.getClass();
        String name = cls.getName();
        boolean z10 = false;
        synchronized (this.f11438b) {
            Set<Object> copyOnWriteArraySet = this.f11438b.get(name);
            if (copyOnWriteArraySet == null) {
                copyOnWriteArraySet = new CopyOnWriteArraySet<>();
                this.f11438b.put(name, copyOnWriteArraySet);
                z10 = true;
            }
            if (copyOnWriteArraySet.contains(obj)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("The bus of <");
                sb2.append(obj);
                sb2.append("> already registered.");
                return;
            }
            copyOnWriteArraySet.add(obj);
            if (z10) {
                u(cls, name);
            }
            c(obj);
        }
    }

    public BusUtils() {
        this.f11437a = new ConcurrentHashMap();
        this.f11438b = new ConcurrentHashMap();
        this.f11439c = new ConcurrentHashMap();
        this.f11440d = new ConcurrentHashMap();
        g();
    }
}
