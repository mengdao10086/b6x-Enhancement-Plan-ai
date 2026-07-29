package androidx.collection;

import g.n0;
import g.p0;
import hb.u;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class j<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<K, V> f2837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2841e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2842f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2843g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2844h;

    public j(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f2839c = i10;
        this.f2837a = new LinkedHashMap<>(0, 0.75f, true);
    }

    @p0
    public V a(@n0 K k10) {
        return null;
    }

    public final synchronized int b() {
        return this.f2841e;
    }

    public void c(boolean z10, @n0 K k10, @n0 V v10, @p0 V v11) {
    }

    public final void d() {
        r(-1);
    }

    public final synchronized int e() {
        return this.f2842f;
    }

    @p0
    public final V f(@n0 K k10) {
        V vPut;
        Objects.requireNonNull(k10, "key == null");
        synchronized (this) {
            V v10 = this.f2837a.get(k10);
            if (v10 != null) {
                this.f2843g++;
                return v10;
            }
            this.f2844h++;
            V vA = a(k10);
            if (vA == null) {
                return null;
            }
            synchronized (this) {
                this.f2841e++;
                vPut = this.f2837a.put(k10, vA);
                if (vPut != null) {
                    this.f2837a.put(k10, vPut);
                } else {
                    this.f2838b += n(k10, vA);
                }
            }
            if (vPut != null) {
                c(false, k10, vA, vPut);
                return vPut;
            }
            r(this.f2839c);
            return vA;
        }
    }

    public final synchronized int g() {
        return this.f2843g;
    }

    public final synchronized int h() {
        return this.f2839c;
    }

    public final synchronized int i() {
        return this.f2844h;
    }

    @p0
    public final V j(@n0 K k10, @n0 V v10) {
        V vPut;
        if (k10 == null || v10 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f2840d++;
            this.f2838b += n(k10, v10);
            vPut = this.f2837a.put(k10, v10);
            if (vPut != null) {
                this.f2838b -= n(k10, vPut);
            }
        }
        if (vPut != null) {
            c(false, k10, vPut, v10);
        }
        r(this.f2839c);
        return vPut;
    }

    public final synchronized int k() {
        return this.f2840d;
    }

    @p0
    public final V l(@n0 K k10) {
        V vRemove;
        Objects.requireNonNull(k10, "key == null");
        synchronized (this) {
            vRemove = this.f2837a.remove(k10);
            if (vRemove != null) {
                this.f2838b -= n(k10, vRemove);
            }
        }
        if (vRemove != null) {
            c(false, k10, vRemove, null);
        }
        return vRemove;
    }

    public void m(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        synchronized (this) {
            this.f2839c = i10;
        }
        r(i10);
    }

    public final int n(K k10, V v10) {
        int iP = p(k10, v10);
        if (iP >= 0) {
            return iP;
        }
        throw new IllegalStateException("Negative size: " + k10 + u.f30904o + v10);
    }

    public final synchronized int o() {
        return this.f2838b;
    }

    public int p(@n0 K k10, @n0 V v10) {
        return 1;
    }

    public final synchronized Map<K, V> q() {
        return new LinkedHashMap(this.f2837a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void r(int r5) {
        /*
            r4 = this;
        L0:
            monitor-enter(r4)
            int r0 = r4.f2838b     // Catch: java.lang.Throwable -> L71
            if (r0 < 0) goto L52
            java.util.LinkedHashMap<K, V> r0 = r4.f2837a     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L11
            int r0 = r4.f2838b     // Catch: java.lang.Throwable -> L71
            if (r0 != 0) goto L52
        L11:
            int r0 = r4.f2838b     // Catch: java.lang.Throwable -> L71
            if (r0 <= r5) goto L50
            java.util.LinkedHashMap<K, V> r0 = r4.f2837a     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L1e
            goto L50
        L1e:
            java.util.LinkedHashMap<K, V> r0 = r4.f2837a     // Catch: java.lang.Throwable -> L71
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L71
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L71
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L71
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L71
            java.util.LinkedHashMap<K, V> r2 = r4.f2837a     // Catch: java.lang.Throwable -> L71
            r2.remove(r1)     // Catch: java.lang.Throwable -> L71
            int r2 = r4.f2838b     // Catch: java.lang.Throwable -> L71
            int r3 = r4.n(r1, r0)     // Catch: java.lang.Throwable -> L71
            int r2 = r2 - r3
            r4.f2838b = r2     // Catch: java.lang.Throwable -> L71
            int r2 = r4.f2842f     // Catch: java.lang.Throwable -> L71
            r3 = 1
            int r2 = r2 + r3
            r4.f2842f = r2     // Catch: java.lang.Throwable -> L71
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L71
            r2 = 0
            r4.c(r3, r1, r0, r2)
            goto L0
        L50:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L71
            return
        L52:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L71
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71
            r0.<init>()     // Catch: java.lang.Throwable -> L71
            java.lang.Class r1 = r4.getClass()     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L71
            r0.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L71
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L71
            throw r5     // Catch: java.lang.Throwable -> L71
        L71:
            r5 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L71
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.j.r(int):void");
    }

    public final synchronized String toString() {
        int i10;
        int i11;
        i10 = this.f2843g;
        i11 = this.f2844h + i10;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f2839c), Integer.valueOf(this.f2843g), Integer.valueOf(this.f2844h), Integer.valueOf(i11 != 0 ? (i10 * 100) / i11 : 0));
    }
}
