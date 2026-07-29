package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
import g.i1;
import g.p0;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements com.bumptech.glide.load.engine.bitmap_recycle.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f12305h = 4194304;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @i1
    public static final int f12306i = 8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f12307j = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h<a, Object> f12308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f12309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Class<?>, NavigableMap<Integer, Integer>> f12310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Class<?>, com.bumptech.glide.load.engine.bitmap_recycle.a<?>> f12311e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f12312f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12313g;

    public static final class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f12314a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12315b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Class<?> f12316c;

        public a(b bVar) {
            this.f12314a = bVar;
        }

        public void a(int i10, Class<?> cls) {
            this.f12315b = i10;
            this.f12316c = cls;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.m
        public void b() {
            this.f12314a.c(this);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f12315b == aVar.f12315b && this.f12316c == aVar.f12316c;
        }

        public int hashCode() {
            int i10 = this.f12315b * 31;
            Class<?> cls = this.f12316c;
            return i10 + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.f12315b + "array=" + this.f12316c + '}';
        }
    }

    public static final class b extends d<a> {
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(this);
        }

        public a e(int i10, Class<?> cls) {
            a aVarB = b();
            aVarB.a(i10, cls);
            return aVarB;
        }
    }

    @i1
    public j() {
        this.f12308b = new h<>();
        this.f12309c = new b();
        this.f12310d = new HashMap();
        this.f12311e = new HashMap();
        this.f12312f = 4194304;
    }

    public final void a(int i10, Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMapN = n(cls);
        Integer num = (Integer) navigableMapN.get(Integer.valueOf(i10));
        if (num != null) {
            if (num.intValue() == 1) {
                navigableMapN.remove(Integer.valueOf(i10));
                return;
            } else {
                navigableMapN.put(Integer.valueOf(i10), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i10 + ", this: " + this);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.b
    public synchronized void b(int i10) {
        try {
            if (i10 >= 40) {
                c();
            } else if (i10 >= 20 || i10 == 15) {
                h(this.f12312f / 2);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.b
    public synchronized void c() {
        h(0);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.b
    public synchronized <T> T d(int i10, Class<T> cls) {
        return (T) m(this.f12309c.e(i10, cls), cls);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.b
    @Deprecated
    public <T> void e(T t10, Class<T> cls) {
        put(t10);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.b
    public synchronized <T> T f(int i10, Class<T> cls) {
        Integer numCeilingKey;
        numCeilingKey = n(cls).ceilingKey(Integer.valueOf(i10));
        return (T) m(q(i10, numCeilingKey) ? this.f12309c.e(numCeilingKey.intValue(), cls) : this.f12309c.e(i10, cls), cls);
    }

    public final void g() {
        h(this.f12312f);
    }

    public final void h(int i10) {
        while (this.f12313g > i10) {
            Object objF = this.f12308b.f();
            v4.m.d(objF);
            com.bumptech.glide.load.engine.bitmap_recycle.a aVarI = i(objF);
            this.f12313g -= aVarI.b(objF) * aVarI.a();
            a(aVarI.b(objF), objF.getClass());
            if (Log.isLoggable(aVarI.h(), 2)) {
                aVarI.h();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("evicted: ");
                sb2.append(aVarI.b(objF));
            }
        }
    }

    public final <T> com.bumptech.glide.load.engine.bitmap_recycle.a<T> i(T t10) {
        return j(t10.getClass());
    }

    public final <T> com.bumptech.glide.load.engine.bitmap_recycle.a<T> j(Class<T> cls) {
        com.bumptech.glide.load.engine.bitmap_recycle.a<T> gVar = (com.bumptech.glide.load.engine.bitmap_recycle.a) this.f12311e.get(cls);
        if (gVar == null) {
            if (cls.equals(int[].class)) {
                gVar = new i();
            } else {
                if (!cls.equals(byte[].class)) {
                    throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
                }
                gVar = new g();
            }
            this.f12311e.put(cls, gVar);
        }
        return gVar;
    }

    @p0
    public final <T> T k(a aVar) {
        return (T) this.f12308b.a(aVar);
    }

    public int l() {
        int iIntValue = 0;
        for (Class<?> cls : this.f12310d.keySet()) {
            for (Integer num : this.f12310d.get(cls).keySet()) {
                iIntValue += num.intValue() * ((Integer) this.f12310d.get(cls).get(num)).intValue() * j(cls).a();
            }
        }
        return iIntValue;
    }

    public final <T> T m(a aVar, Class<T> cls) {
        com.bumptech.glide.load.engine.bitmap_recycle.a<T> aVarJ = j(cls);
        T t10 = (T) k(aVar);
        if (t10 != null) {
            this.f12313g -= aVarJ.b(t10) * aVarJ.a();
            a(aVarJ.b(t10), cls);
        }
        if (t10 != null) {
            return t10;
        }
        if (Log.isLoggable(aVarJ.h(), 2)) {
            aVarJ.h();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Allocated ");
            sb2.append(aVar.f12315b);
            sb2.append(" bytes");
        }
        return aVarJ.newArray(aVar.f12315b);
    }

    public final NavigableMap<Integer, Integer> n(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f12310d.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f12310d.put(cls, treeMap);
        return treeMap;
    }

    public final boolean o() {
        int i10 = this.f12313g;
        return i10 == 0 || this.f12312f / i10 >= 2;
    }

    public final boolean p(int i10) {
        return i10 <= this.f12312f / 2;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.b
    public synchronized <T> void put(T t10) {
        Class<?> cls = t10.getClass();
        com.bumptech.glide.load.engine.bitmap_recycle.a<T> aVarJ = j(cls);
        int iB = aVarJ.b(t10);
        int iA = aVarJ.a() * iB;
        if (p(iA)) {
            a aVarE = this.f12309c.e(iB, cls);
            this.f12308b.d(aVarE, t10);
            NavigableMap<Integer, Integer> navigableMapN = n(cls);
            Integer num = (Integer) navigableMapN.get(Integer.valueOf(aVarE.f12315b));
            Integer numValueOf = Integer.valueOf(aVarE.f12315b);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapN.put(numValueOf, Integer.valueOf(iIntValue));
            this.f12313g += iA;
            g();
        }
    }

    public final boolean q(int i10, Integer num) {
        return num != null && (o() || num.intValue() <= i10 * 8);
    }

    public j(int i10) {
        this.f12308b = new h<>();
        this.f12309c = new b();
        this.f12310d = new HashMap();
        this.f12311e = new HashMap();
        this.f12312f = i10;
    }
}
