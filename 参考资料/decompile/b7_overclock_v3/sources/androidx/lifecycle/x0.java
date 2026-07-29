package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.p0
    public final Map<String, Object> f6268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.p0
    public final Set<Closeable> f6269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f6270c;

    public x0() {
        this.f6268a = new HashMap();
        this.f6269b = new LinkedHashSet();
        this.f6270c = false;
    }

    public static void c(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    public void a(@g.n0 Closeable closeable) {
        Set<Closeable> set = this.f6269b;
        if (set != null) {
            synchronized (set) {
                this.f6269b.add(closeable);
            }
        }
    }

    @g.k0
    final void b() {
        this.f6270c = true;
        Map<String, Object> map = this.f6268a;
        if (map != null) {
            synchronized (map) {
                Iterator<Object> it2 = this.f6268a.values().iterator();
                while (it2.hasNext()) {
                    c(it2.next());
                }
            }
        }
        Set<Closeable> set = this.f6269b;
        if (set != null) {
            synchronized (set) {
                Iterator<Closeable> it3 = this.f6269b.iterator();
                while (it3.hasNext()) {
                    c(it3.next());
                }
            }
        }
        e();
    }

    public <T> T d(String str) {
        T t10;
        Map<String, Object> map = this.f6268a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t10 = (T) this.f6268a.get(str);
        }
        return t10;
    }

    public void e() {
    }

    public <T> T f(String str, T t10) {
        Object obj;
        synchronized (this.f6268a) {
            obj = this.f6268a.get(str);
            if (obj == null) {
                this.f6268a.put(str, t10);
            }
        }
        if (obj != null) {
            t10 = (T) obj;
        }
        if (this.f6270c) {
            c(t10);
        }
        return t10;
    }

    public x0(@g.n0 Closeable... closeableArr) {
        this.f6268a = new HashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.f6269b = linkedHashSet;
        this.f6270c = false;
        linkedHashSet.addAll(Arrays.asList(closeableArr));
    }
}
