package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.m;
import g.p0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class h<K extends m, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a<K, V> f12298a = new a<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<K, a<K, V>> f12299b = new HashMap();

    public static class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f12300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<V> f12301b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public a<K, V> f12302c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public a<K, V> f12303d;

        public a() {
            this(null);
        }

        public void a(V v10) {
            if (this.f12301b == null) {
                this.f12301b = new ArrayList();
            }
            this.f12301b.add(v10);
        }

        @p0
        public V b() {
            int iC = c();
            if (iC > 0) {
                return this.f12301b.remove(iC - 1);
            }
            return null;
        }

        public int c() {
            List<V> list = this.f12301b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public a(K k10) {
            this.f12303d = this;
            this.f12302c = this;
            this.f12300a = k10;
        }
    }

    public static <K, V> void e(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f12303d;
        aVar2.f12302c = aVar.f12302c;
        aVar.f12302c.f12303d = aVar2;
    }

    public static <K, V> void g(a<K, V> aVar) {
        aVar.f12302c.f12303d = aVar;
        aVar.f12303d.f12302c = aVar;
    }

    @p0
    public V a(K k10) {
        a<K, V> aVar = this.f12299b.get(k10);
        if (aVar == null) {
            aVar = new a<>(k10);
            this.f12299b.put(k10, aVar);
        } else {
            k10.b();
        }
        b(aVar);
        return aVar.b();
    }

    public final void b(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.f12298a;
        aVar.f12303d = aVar2;
        aVar.f12302c = aVar2.f12302c;
        g(aVar);
    }

    public final void c(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.f12298a;
        aVar.f12303d = aVar2.f12303d;
        aVar.f12302c = aVar2;
        g(aVar);
    }

    public void d(K k10, V v10) {
        a<K, V> aVar = this.f12299b.get(k10);
        if (aVar == null) {
            aVar = new a<>(k10);
            c(aVar);
            this.f12299b.put(k10, aVar);
        } else {
            k10.b();
        }
        aVar.a(v10);
    }

    @p0
    public V f() {
        for (a aVar = this.f12298a.f12303d; !aVar.equals(this.f12298a); aVar = aVar.f12303d) {
            V v10 = (V) aVar.b();
            if (v10 != null) {
                return v10;
            }
            e(aVar);
            this.f12299b.remove(aVar.f12300a);
            ((m) aVar.f12300a).b();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("GroupedLinkedMap( ");
        boolean z10 = false;
        for (a aVar = this.f12298a.f12302c; !aVar.equals(this.f12298a); aVar = aVar.f12302c) {
            z10 = true;
            sb2.append('{');
            sb2.append(aVar.f12300a);
            sb2.append(':');
            sb2.append(aVar.c());
            sb2.append("}, ");
        }
        if (z10) {
            sb2.delete(sb2.length() - 2, sb2.length());
        }
        sb2.append(" )");
        return sb2.toString();
    }
}
