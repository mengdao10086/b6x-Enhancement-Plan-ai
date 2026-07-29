package h4;

import android.text.TextUtils;
import g.i1;
import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, List<i>> f30465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Map<String, String> f30466d;

    public static final class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f30467d = "User-Agent";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f30468e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Map<String, List<i>> f30469f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f30470a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, List<i>> f30471b = f30469f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f30472c = true;

        static {
            String strG = g();
            f30468e = strG;
            HashMap map = new HashMap(2);
            if (!TextUtils.isEmpty(strG)) {
                map.put("User-Agent", Collections.singletonList(new b(strG)));
            }
            f30469f = Collections.unmodifiableMap(map);
        }

        @i1
        public static String g() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb2 = new StringBuilder(property.length());
            for (int i10 = 0; i10 < length; i10++) {
                char cCharAt = property.charAt(i10);
                if ((cCharAt > 31 || cCharAt == '\t') && cCharAt < 127) {
                    sb2.append(cCharAt);
                } else {
                    sb2.append('?');
                }
            }
            return sb2.toString();
        }

        public a a(@n0 String str, @n0 i iVar) {
            if (this.f30472c && "User-Agent".equalsIgnoreCase(str)) {
                return h(str, iVar);
            }
            e();
            f(str).add(iVar);
            return this;
        }

        public a b(@n0 String str, @n0 String str2) {
            return a(str, new b(str2));
        }

        public j c() {
            this.f30470a = true;
            return new j(this.f30471b);
        }

        public final Map<String, List<i>> d() {
            HashMap map = new HashMap(this.f30471b.size());
            for (Map.Entry<String, List<i>> entry : this.f30471b.entrySet()) {
                map.put(entry.getKey(), new ArrayList(entry.getValue()));
            }
            return map;
        }

        public final void e() {
            if (this.f30470a) {
                this.f30470a = false;
                this.f30471b = d();
            }
        }

        public final List<i> f(String str) {
            List<i> list = this.f30471b.get(str);
            if (list != null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            this.f30471b.put(str, arrayList);
            return arrayList;
        }

        public a h(@n0 String str, @p0 i iVar) {
            e();
            if (iVar == null) {
                this.f30471b.remove(str);
            } else {
                List<i> listF = f(str);
                listF.clear();
                listF.add(iVar);
            }
            if (this.f30472c && "User-Agent".equalsIgnoreCase(str)) {
                this.f30472c = false;
            }
            return this;
        }

        public a i(@n0 String str, @p0 String str2) {
            return h(str, str2 == null ? null : new b(str2));
        }
    }

    public static final class b implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public final String f30473a;

        public b(@n0 String str) {
            this.f30473a = str;
        }

        @Override // h4.i
        public String a() {
            return this.f30473a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f30473a.equals(((b) obj).f30473a);
            }
            return false;
        }

        public int hashCode() {
            return this.f30473a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f30473a + "'}";
        }
    }

    public j(Map<String, List<i>> map) {
        this.f30465c = Collections.unmodifiableMap(map);
    }

    @Override // h4.h
    public Map<String, String> a() {
        if (this.f30466d == null) {
            synchronized (this) {
                if (this.f30466d == null) {
                    this.f30466d = Collections.unmodifiableMap(c());
                }
            }
        }
        return this.f30466d;
    }

    @n0
    public final String b(@n0 List<i> list) {
        StringBuilder sb2 = new StringBuilder();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            String strA = list.get(i10).a();
            if (!TextUtils.isEmpty(strA)) {
                sb2.append(strA);
                if (i10 != list.size() - 1) {
                    sb2.append(',');
                }
            }
        }
        return sb2.toString();
    }

    public final Map<String, String> c() {
        HashMap map = new HashMap();
        for (Map.Entry<String, List<i>> entry : this.f30465c.entrySet()) {
            String strB = b(entry.getValue());
            if (!TextUtils.isEmpty(strB)) {
                map.put(entry.getKey(), strB);
            }
        }
        return map;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f30465c.equals(((j) obj).f30465c);
        }
        return false;
    }

    public int hashCode() {
        return this.f30465c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f30465c + '}';
    }
}
