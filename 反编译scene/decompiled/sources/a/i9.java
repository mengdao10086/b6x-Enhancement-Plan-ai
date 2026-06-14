package a;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class i9<K, V> implements Iterable<Map.Entry<K, V>> {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public h9<K, V> f1341a;
    public h9<K, V> b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WeakHashMap<k9<K, V>, Boolean> f1342a = new WeakHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6386a = 0;

    public class a implements Iterator<Map.Entry<K, V>>, k9<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h9<K, V> f6387a;
        public boolean b = true;

        public a() {
        }

        @Override // a.k9
        public void a(h9<K, V> h9Var) {
            h9<K, V> h9Var2 = this.f6387a;
            if (h9Var == h9Var2) {
                h9<K, V> h9Var3 = h9Var2.b;
                this.f6387a = h9Var3;
                this.b = h9Var3 == null;
            }
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            h9<K, V> h9Var;
            if (this.b) {
                this.b = false;
                h9Var = i9.this.f1341a;
            } else {
                h9<K, V> h9Var2 = this.f6387a;
                h9Var = h9Var2 != null ? h9Var2.f6287a : null;
            }
            this.f6387a = h9Var;
            return this.f6387a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.b) {
                return i9.this.f1341a != null;
            }
            h9<K, V> h9Var = this.f6387a;
            return (h9Var == null || h9Var.f6287a == null) ? false : true;
        }
    }

    public Iterator<Map.Entry<K, V>> a() {
        g9 g9Var = new g9(this.b, this.f1341a);
        this.f1342a.put(g9Var, Boolean.FALSE);
        return g9Var;
    }

    public Map.Entry<K, V> b() {
        return this.f1341a;
    }

    public h9<K, V> c(K k) {
        h9<K, V> h9Var = this.f1341a;
        while (h9Var != null && !h9Var.f1138a.equals(k)) {
            h9Var = h9Var.f6287a;
        }
        return h9Var;
    }

    public i9<K, V>.a d() {
        i9<K, V>.a aVar = new a();
        this.f1342a.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public Map.Entry<K, V> e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i9)) {
            return false;
        }
        i9 i9Var = (i9) obj;
        if (size() != i9Var.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = i9Var.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public h9<K, V> f(K k, V v) {
        h9<K, V> h9Var = new h9<>(k, v);
        this.f6386a++;
        h9<K, V> h9Var2 = this.b;
        if (h9Var2 == null) {
            this.f1341a = h9Var;
        } else {
            h9Var2.f6287a = h9Var;
            h9Var.b = h9Var2;
        }
        this.b = h9Var;
        return h9Var;
    }

    public V g(K k) {
        h9<K, V> h9VarC = c(k);
        if (h9VarC == null) {
            return null;
        }
        this.f6386a--;
        if (!this.f1342a.isEmpty()) {
            Iterator<k9<K, V>> it = this.f1342a.keySet().iterator();
            while (it.hasNext()) {
                it.next().a(h9VarC);
            }
        }
        h9<K, V> h9Var = h9VarC.b;
        if (h9Var != null) {
            h9Var.f6287a = h9VarC.f6287a;
        } else {
            this.f1341a = h9VarC.f6287a;
        }
        h9<K, V> h9Var2 = h9VarC.f6287a;
        if (h9Var2 != null) {
            h9Var2.b = h9VarC.b;
        } else {
            this.b = h9VarC.b;
        }
        h9VarC.f6287a = null;
        h9VarC.b = null;
        return h9VarC.f1139b;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += it.next().hashCode();
        }
        return iHashCode;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        f9 f9Var = new f9(this.f1341a, this.b);
        this.f1342a.put(f9Var, Boolean.FALSE);
        return f9Var;
    }

    public int size() {
        return this.f6386a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
