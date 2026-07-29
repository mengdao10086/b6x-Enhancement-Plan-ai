package org.greenrobot.essentials;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class ObjectCache<KEY, VALUE> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<KEY, a<VALUE>> f46166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReferenceType f46167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f46168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f46169d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f46170e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f46171f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile long f46172g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile int f46173h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile int f46174i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile int f46175j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile int f46176k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile int f46177l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile int f46178m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile int f46179n;

    public enum ReferenceType {
        SOFT,
        WEAK,
        STRONG
    }

    public static class a<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Reference<V> f46180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V f46181b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f46182c = System.currentTimeMillis();

        public a(Reference<V> reference, V v10) {
            this.f46180a = reference;
            this.f46181b = v10;
        }
    }

    public ObjectCache(ReferenceType referenceType, int i10, long j10) {
        this.f46167b = referenceType;
        this.f46168c = referenceType == ReferenceType.STRONG;
        this.f46169d = i10;
        this.f46170e = j10;
        this.f46171f = j10 > 0;
        this.f46166a = new LinkedHashMap();
    }

    public void a() {
        if (!this.f46168c || this.f46171f) {
            if ((!this.f46171f || this.f46172g == 0 || System.currentTimeMillis() <= this.f46172g) && this.f46173h <= this.f46169d / 2) {
                return;
            }
            b();
        }
    }

    public synchronized int b() {
        int i10;
        i10 = 0;
        this.f46173h = 0;
        this.f46172g = 0L;
        long jCurrentTimeMillis = this.f46171f ? System.currentTimeMillis() - this.f46170e : 0L;
        Iterator<a<VALUE>> it2 = this.f46166a.values().iterator();
        while (it2.hasNext()) {
            a<VALUE> next = it2.next();
            if (!this.f46168c && next.f46180a == null) {
                this.f46178m++;
                i10++;
                it2.remove();
            } else if (next.f46182c < jCurrentTimeMillis) {
                this.f46177l++;
                i10++;
                it2.remove();
            }
        }
        return i10;
    }

    public synchronized void c() {
        this.f46166a.clear();
    }

    public synchronized boolean d(KEY key) {
        return this.f46166a.containsKey(key);
    }

    public boolean e(KEY key) {
        return g(key) != null;
    }

    public synchronized void f(int i10) {
        if (i10 <= 0) {
            this.f46166a.clear();
        } else {
            a();
            Iterator<KEY> it2 = this.f46166a.keySet().iterator();
            while (it2.hasNext() && this.f46166a.size() > i10) {
                this.f46179n++;
                it2.next();
                it2.remove();
            }
        }
    }

    public VALUE g(KEY key) {
        a<VALUE> aVar;
        synchronized (this) {
            aVar = this.f46166a.get(key);
        }
        VALUE valueP = null;
        if (aVar != null) {
            if (!this.f46171f || System.currentTimeMillis() - aVar.f46182c < this.f46170e) {
                valueP = p(key, aVar);
            } else {
                this.f46177l++;
                synchronized (this) {
                    this.f46166a.remove(key);
                }
            }
        }
        if (valueP != null) {
            this.f46175j++;
        } else {
            this.f46176k++;
        }
        return valueP;
    }

    public int h() {
        return this.f46179n;
    }

    public int i() {
        return this.f46177l;
    }

    public int j() {
        return this.f46175j;
    }

    public int k() {
        return this.f46176k;
    }

    public int l() {
        return this.f46174i;
    }

    public int m() {
        return this.f46178m;
    }

    public int n() {
        return this.f46169d;
    }

    public String o() {
        return "ObjectCache-Removed[expired=" + this.f46177l + ", refCleared=" + this.f46178m + ", evicted=" + this.f46179n;
    }

    public final VALUE p(KEY key, a<VALUE> aVar) {
        if (aVar == null) {
            return null;
        }
        if (this.f46168c) {
            return aVar.f46181b;
        }
        VALUE value = aVar.f46180a.get();
        if (value == null) {
            this.f46178m++;
            if (key != null) {
                synchronized (this) {
                    this.f46166a.remove(key);
                }
            }
        }
        return value;
    }

    public final VALUE q(a<VALUE> aVar) {
        if (aVar != null) {
            return this.f46168c ? aVar.f46181b : aVar.f46180a.get();
        }
        return null;
    }

    public synchronized Set<KEY> r() {
        return this.f46166a.keySet();
    }

    public VALUE s(KEY key, VALUE value) {
        a<VALUE> aVarPut;
        ReferenceType referenceType = this.f46167b;
        a<VALUE> aVar = referenceType == ReferenceType.WEAK ? new a<>(new WeakReference(value), null) : referenceType == ReferenceType.SOFT ? new a<>(new SoftReference(value), null) : new a<>(null, value);
        this.f46173h++;
        this.f46174i++;
        if (this.f46171f && this.f46172g == 0) {
            this.f46172g = System.currentTimeMillis() + this.f46170e + 1;
        }
        synchronized (this) {
            int size = this.f46166a.size();
            int i10 = this.f46169d;
            if (size >= i10) {
                f(i10 - 1);
            }
            aVarPut = this.f46166a.put(key, aVar);
        }
        return q(aVarPut);
    }

    public void t(Map<KEY, VALUE> map) {
        int size = this.f46169d - map.size();
        if (this.f46169d > 0 && this.f46166a.size() > size) {
            f(size);
        }
        for (Map.Entry<KEY, VALUE> entry : map.entrySet()) {
            s(entry.getKey(), entry.getValue());
        }
    }

    public String toString() {
        return "ObjectCache[maxSize=" + this.f46169d + ", hits=" + this.f46175j + ", misses=" + this.f46176k + "]";
    }

    public VALUE u(KEY key) {
        return q(this.f46166a.remove(key));
    }

    public synchronized int v() {
        return this.f46166a.size();
    }
}
