package o;

import androidx.annotation.RestrictTo;
import g.n0;
import g.p0;
import hb.u;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c<K, V> f42678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c<K, V> f42679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakHashMap<f<K, V>, Boolean> f42680c = new WeakHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f42681d = 0;

    public static class a<K, V> extends e<K, V> {
        public a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // o.b.e
        public c<K, V> b(c<K, V> cVar) {
            return cVar.f42685d;
        }

        @Override // o.b.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.f42684c;
        }
    }

    /* JADX INFO: renamed from: o.b$b, reason: collision with other inner class name */
    public static class C0481b<K, V> extends e<K, V> {
        public C0481b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // o.b.e
        public c<K, V> b(c<K, V> cVar) {
            return cVar.f42684c;
        }

        @Override // o.b.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.f42685d;
        }
    }

    public static class c<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public final K f42682a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @n0
        public final V f42683b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c<K, V> f42684c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c<K, V> f42685d;

        public c(@n0 K k10, @n0 V v10) {
            this.f42682a = k10;
            this.f42683b = v10;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f42682a.equals(cVar.f42682a) && this.f42683b.equals(cVar.f42683b);
        }

        @Override // java.util.Map.Entry
        @n0
        public K getKey() {
            return this.f42682a;
        }

        @Override // java.util.Map.Entry
        @n0
        public V getValue() {
            return this.f42683b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f42682a.hashCode() ^ this.f42683b.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f42682a + u.f30904o + this.f42683b;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public class d extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c<K, V> f42686a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f42687b = true;

        public d() {
        }

        @Override // o.b.f
        public void a(@n0 c<K, V> cVar) {
            c<K, V> cVar2 = this.f42686a;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f42685d;
                this.f42686a = cVar3;
                this.f42687b = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (this.f42687b) {
                this.f42687b = false;
                this.f42686a = b.this.f42678a;
            } else {
                c<K, V> cVar = this.f42686a;
                this.f42686a = cVar != null ? cVar.f42684c : null;
            }
            return this.f42686a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f42687b) {
                return b.this.f42678a != null;
            }
            c<K, V> cVar = this.f42686a;
            return (cVar == null || cVar.f42684c == null) ? false : true;
        }
    }

    public static abstract class e<K, V> extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c<K, V> f42689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c<K, V> f42690b;

        public e(c<K, V> cVar, c<K, V> cVar2) {
            this.f42689a = cVar2;
            this.f42690b = cVar;
        }

        @Override // o.b.f
        public void a(@n0 c<K, V> cVar) {
            if (this.f42689a == cVar && cVar == this.f42690b) {
                this.f42690b = null;
                this.f42689a = null;
            }
            c<K, V> cVar2 = this.f42689a;
            if (cVar2 == cVar) {
                this.f42689a = b(cVar2);
            }
            if (this.f42690b == cVar) {
                this.f42690b = e();
            }
        }

        public abstract c<K, V> b(c<K, V> cVar);

        public abstract c<K, V> c(c<K, V> cVar);

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f42690b;
            this.f42690b = e();
            return cVar;
        }

        public final c<K, V> e() {
            c<K, V> cVar = this.f42690b;
            c<K, V> cVar2 = this.f42689a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f42690b != null;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static abstract class f<K, V> {
        public abstract void a(@n0 c<K, V> cVar);
    }

    @p0
    public Map.Entry<K, V> a() {
        return this.f42678a;
    }

    @p0
    public c<K, V> b(K k10) {
        c<K, V> cVar = this.f42678a;
        while (cVar != null && !cVar.f42682a.equals(k10)) {
            cVar = cVar.f42684c;
        }
        return cVar;
    }

    @n0
    public b<K, V>.d d() {
        b<K, V>.d dVar = new d();
        this.f42680c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    @n0
    public Iterator<Map.Entry<K, V>> descendingIterator() {
        C0481b c0481b = new C0481b(this.f42679b, this.f42678a);
        this.f42680c.put(c0481b, Boolean.FALSE);
        return c0481b;
    }

    @p0
    public Map.Entry<K, V> e() {
        return this.f42679b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it2 = iterator();
        Iterator<Map.Entry<K, V>> it3 = bVar.iterator();
        while (it2.hasNext() && it3.hasNext()) {
            Map.Entry<K, V> next = it2.next();
            Map.Entry<K, V> next2 = it3.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it2.hasNext() || it3.hasNext()) ? false : true;
    }

    public c<K, V> f(@n0 K k10, @n0 V v10) {
        c<K, V> cVar = new c<>(k10, v10);
        this.f42681d++;
        c<K, V> cVar2 = this.f42679b;
        if (cVar2 == null) {
            this.f42678a = cVar;
            this.f42679b = cVar;
            return cVar;
        }
        cVar2.f42684c = cVar;
        cVar.f42685d = cVar2;
        this.f42679b = cVar;
        return cVar;
    }

    public V g(@n0 K k10, @n0 V v10) {
        c<K, V> cVarB = b(k10);
        if (cVarB != null) {
            return cVarB.f42683b;
        }
        f(k10, v10);
        return null;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it2 = iterator();
        int iHashCode = 0;
        while (it2.hasNext()) {
            iHashCode += it2.next().hashCode();
        }
        return iHashCode;
    }

    public V i(@n0 K k10) {
        c<K, V> cVarB = b(k10);
        if (cVarB == null) {
            return null;
        }
        this.f42681d--;
        if (!this.f42680c.isEmpty()) {
            Iterator<f<K, V>> it2 = this.f42680c.keySet().iterator();
            while (it2.hasNext()) {
                it2.next().a(cVarB);
            }
        }
        c<K, V> cVar = cVarB.f42685d;
        if (cVar != null) {
            cVar.f42684c = cVarB.f42684c;
        } else {
            this.f42678a = cVarB.f42684c;
        }
        c<K, V> cVar2 = cVarB.f42684c;
        if (cVar2 != null) {
            cVar2.f42685d = cVar;
        } else {
            this.f42679b = cVar;
        }
        cVarB.f42684c = null;
        cVarB.f42685d = null;
        return cVarB.f42683b;
    }

    @Override // java.lang.Iterable
    @n0
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f42678a, this.f42679b);
        this.f42680c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public int size() {
        return this.f42681d;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        Iterator<Map.Entry<K, V>> it2 = iterator();
        while (it2.hasNext()) {
            sb2.append(it2.next().toString());
            if (it2.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }
}
