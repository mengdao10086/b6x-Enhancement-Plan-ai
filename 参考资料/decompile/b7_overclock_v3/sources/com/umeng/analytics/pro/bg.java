package com.umeng.analytics.pro;

import com.blankj.utilcode.util.i0;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bg;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public abstract class bg<T extends bg<?, ?>, F extends bd> implements aw<T, F> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<Class<? extends cd>, ce> f23356c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f23357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public F f23358b;

    public static class a extends cf<bg> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bv bvVar, bg bgVar) throws bc {
            bgVar.f23358b = null;
            bgVar.f23357a = null;
            bvVar.j();
            bq bqVarL = bvVar.l();
            Object objA = bgVar.a(bvVar, bqVarL);
            bgVar.f23357a = objA;
            if (objA != null) {
                bgVar.f23358b = (F) bgVar.a(bqVarL.f23423c);
            }
            bvVar.m();
            bvVar.l();
            bvVar.k();
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bv bvVar, bg bgVar) throws bc {
            if (bgVar.a() == null || bgVar.b() == null) {
                throw new bw("Cannot write a TUnion with no set value!");
            }
            bvVar.a(bgVar.d());
            bvVar.a(bgVar.c(bgVar.f23358b));
            bgVar.a(bvVar);
            bvVar.c();
            bvVar.d();
            bvVar.b();
        }
    }

    public static class b implements ce {
        private b() {
        }

        @Override // com.umeng.analytics.pro.ce
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    public static class c extends cg<bg> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bv bvVar, bg bgVar) throws bc {
            bgVar.f23358b = null;
            bgVar.f23357a = null;
            short sV = bvVar.v();
            Object objA = bgVar.a(bvVar, sV);
            bgVar.f23357a = objA;
            if (objA != null) {
                bgVar.f23358b = (F) bgVar.a(sV);
            }
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bv bvVar, bg bgVar) throws bc {
            if (bgVar.a() == null || bgVar.b() == null) {
                throw new bw("Cannot write a TUnion with no set value!");
            }
            bvVar.a(bgVar.f23358b.a());
            bgVar.b(bvVar);
        }
    }

    public static class d implements ce {
        private d() {
        }

        @Override // com.umeng.analytics.pro.ce
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    static {
        HashMap map = new HashMap();
        f23356c = map;
        map.put(cf.class, new b());
        map.put(cg.class, new d());
    }

    public bg() {
        this.f23358b = null;
        this.f23357a = null;
    }

    private static Object a(Object obj) {
        return obj instanceof aw ? ((aw) obj).deepCopy() : obj instanceof ByteBuffer ? ax.d((ByteBuffer) obj) : obj instanceof List ? a((List) obj) : obj instanceof Set ? a((Set) obj) : obj instanceof Map ? a((Map<Object, Object>) obj) : obj;
    }

    public abstract F a(short s10);

    public abstract Object a(bv bvVar, bq bqVar) throws bc;

    public abstract Object a(bv bvVar, short s10) throws bc;

    public abstract void a(bv bvVar) throws bc;

    public Object b() {
        return this.f23357a;
    }

    public abstract void b(F f10, Object obj) throws ClassCastException;

    public abstract void b(bv bvVar) throws bc;

    public abstract bq c(F f10);

    public boolean c() {
        return this.f23358b != null;
    }

    @Override // com.umeng.analytics.pro.aw
    public final void clear() {
        this.f23358b = null;
        this.f23357a = null;
    }

    public abstract ca d();

    @Override // com.umeng.analytics.pro.aw
    public void read(bv bvVar) throws bc {
        f23356c.get(bvVar.D()).b().b(bvVar, this);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<");
        sb2.append(getClass().getSimpleName());
        sb2.append(i0.f11861z);
        if (a() != null) {
            Object objB = b();
            sb2.append(c(a()).f23421a);
            sb2.append(":");
            if (objB instanceof ByteBuffer) {
                ax.a((ByteBuffer) objB, sb2);
            } else {
                sb2.append(objB.toString());
            }
        }
        sb2.append(">");
        return sb2.toString();
    }

    @Override // com.umeng.analytics.pro.aw
    public void write(bv bvVar) throws bc {
        f23356c.get(bvVar.D()).b().a(bvVar, this);
    }

    public boolean b(F f10) {
        return this.f23358b == f10;
    }

    public boolean b(int i10) {
        return b(a((short) i10));
    }

    public bg(F f10, Object obj) {
        a(f10, obj);
    }

    public bg(bg<T, F> bgVar) {
        if (bgVar.getClass().equals(getClass())) {
            this.f23358b = bgVar.f23358b;
            this.f23357a = a(bgVar.f23357a);
            return;
        }
        throw new ClassCastException();
    }

    private static Map a(Map<Object, Object> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            map2.put(a(entry.getKey()), a(entry.getValue()));
        }
        return map2;
    }

    private static Set a(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            hashSet.add(a(it2.next()));
        }
        return hashSet;
    }

    private static List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(a(it2.next()));
        }
        return arrayList;
    }

    public F a() {
        return this.f23358b;
    }

    public Object a(F f10) {
        if (f10 == this.f23358b) {
            return b();
        }
        throw new IllegalArgumentException("Cannot get the value of field " + f10 + " because union's set field is " + this.f23358b);
    }

    public Object a(int i10) {
        return a(a((short) i10));
    }

    public void a(F f10, Object obj) {
        b(f10, obj);
        this.f23358b = f10;
        this.f23357a = obj;
    }

    public void a(int i10, Object obj) {
        a(a((short) i10), obj);
    }
}
