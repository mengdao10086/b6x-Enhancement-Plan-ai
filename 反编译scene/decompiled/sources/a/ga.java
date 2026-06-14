package a;

import java.util.LinkedHashMap;
import java.util.Locale;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ga<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6188a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LinkedHashMap<K, V> f985a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;

    public ga(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.b = i;
        this.f985a = new LinkedHashMap<>(0, 0.75f, true);
    }

    public V a(K k) {
        return null;
    }

    public void b(boolean z, K k, V v, V v2) {
    }

    public final V c(K k) {
        V vPut;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v = this.f985a.get(k);
            if (v != null) {
                this.f++;
                return v;
            }
            this.g++;
            V vA = a(k);
            if (vA == null) {
                return null;
            }
            synchronized (this) {
                this.d++;
                vPut = this.f985a.put(k, vA);
                if (vPut != null) {
                    this.f985a.put(k, vPut);
                } else {
                    this.f6188a += e(k, vA);
                }
            }
            if (vPut != null) {
                b(false, k, vA, vPut);
                return vPut;
            }
            g(this.b);
            return vA;
        }
    }

    public final V d(K k, V v) {
        V vPut;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.c++;
            this.f6188a += e(k, v);
            vPut = this.f985a.put(k, v);
            if (vPut != null) {
                this.f6188a -= e(k, vPut);
            }
        }
        if (vPut != null) {
            b(false, k, vPut, v);
        }
        g(this.b);
        return vPut;
    }

    public final int e(K k, V v) {
        int iF = f(k, v);
        if (iF >= 0) {
            return iF;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    public int f(K k, V v) {
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(int r5) {
        /*
            r4 = this;
        L0:
            monitor-enter(r4)
            int r0 = r4.f6188a     // Catch: java.lang.Throwable -> L71
            if (r0 < 0) goto L52
            java.util.LinkedHashMap<K, V> r0 = r4.f985a     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L11
            int r0 = r4.f6188a     // Catch: java.lang.Throwable -> L71
            if (r0 != 0) goto L52
        L11:
            int r0 = r4.f6188a     // Catch: java.lang.Throwable -> L71
            if (r0 <= r5) goto L50
            java.util.LinkedHashMap<K, V> r0 = r4.f985a     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L1e
            goto L50
        L1e:
            java.util.LinkedHashMap<K, V> r0 = r4.f985a     // Catch: java.lang.Throwable -> L71
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L71
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L71
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L71
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L71
            java.util.LinkedHashMap<K, V> r2 = r4.f985a     // Catch: java.lang.Throwable -> L71
            r2.remove(r1)     // Catch: java.lang.Throwable -> L71
            int r2 = r4.f6188a     // Catch: java.lang.Throwable -> L71
            int r3 = r4.e(r1, r0)     // Catch: java.lang.Throwable -> L71
            int r2 = r2 - r3
            r4.f6188a = r2     // Catch: java.lang.Throwable -> L71
            int r2 = r4.e     // Catch: java.lang.Throwable -> L71
            r3 = 1
            int r2 = r2 + r3
            r4.e = r2     // Catch: java.lang.Throwable -> L71
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L71
            r2 = 0
            r4.b(r3, r1, r0, r2)
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
        throw new UnsupportedOperationException("Method not decompiled: a.ga.g(int):void");
    }

    public final synchronized String toString() {
        int i;
        i = this.f + this.g;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.b), Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(i != 0 ? (this.f * 100) / i : 0));
    }
}
