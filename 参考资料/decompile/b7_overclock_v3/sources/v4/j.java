package v4;

import g.n0;
import g.p0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class j<T, Y> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<T, a<Y>> f52684a = new LinkedHashMap(100, 0.75f, true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f52685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f52686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f52687d;

    public static final class a<Y> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Y f52688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f52689b;

        public a(Y y10, int i10) {
            this.f52688a = y10;
            this.f52689b = i10;
        }
    }

    public j(long j10) {
        this.f52685b = j10;
        this.f52686c = j10;
    }

    public synchronized long a() {
        return this.f52686c;
    }

    public void c() {
        q(0L);
    }

    public synchronized void d(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
        this.f52686c = Math.round(this.f52685b * f10);
        j();
    }

    public synchronized long e() {
        return this.f52687d;
    }

    public synchronized boolean i(@n0 T t10) {
        return this.f52684a.containsKey(t10);
    }

    public final void j() {
        q(this.f52686c);
    }

    @p0
    public synchronized Y k(@n0 T t10) {
        a<Y> aVar;
        aVar = this.f52684a.get(t10);
        return aVar != null ? aVar.f52688a : null;
    }

    public synchronized int l() {
        return this.f52684a.size();
    }

    public int m(@p0 Y y10) {
        return 1;
    }

    public void n(@n0 T t10, @p0 Y y10) {
    }

    @p0
    public synchronized Y o(@n0 T t10, @p0 Y y10) {
        int iM = m(y10);
        long j10 = iM;
        if (j10 >= this.f52686c) {
            n(t10, y10);
            return null;
        }
        if (y10 != null) {
            this.f52687d += j10;
        }
        a<Y> aVarPut = this.f52684a.put(t10, y10 == null ? null : new a<>(y10, iM));
        if (aVarPut != null) {
            this.f52687d -= (long) aVarPut.f52689b;
            if (!aVarPut.f52688a.equals(y10)) {
                n(t10, aVarPut.f52688a);
            }
        }
        j();
        return aVarPut != null ? aVarPut.f52688a : null;
    }

    @p0
    public synchronized Y p(@n0 T t10) {
        a<Y> aVarRemove = this.f52684a.remove(t10);
        if (aVarRemove == null) {
            return null;
        }
        this.f52687d -= (long) aVarRemove.f52689b;
        return aVarRemove.f52688a;
    }

    public synchronized void q(long j10) {
        while (this.f52687d > j10) {
            Iterator<Map.Entry<T, a<Y>>> it2 = this.f52684a.entrySet().iterator();
            Map.Entry<T, a<Y>> next = it2.next();
            a<Y> value = next.getValue();
            this.f52687d -= (long) value.f52689b;
            T key = next.getKey();
            it2.remove();
            n(key, value.f52688a);
        }
    }
}
