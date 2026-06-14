package a;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class j9<K, V> implements Iterator<Map.Entry<K, V>>, k9<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h9<K, V> f6487a;
    public h9<K, V> b;

    public j9(h9<K, V> h9Var, h9<K, V> h9Var2) {
        this.f6487a = h9Var2;
        this.b = h9Var;
    }

    @Override // a.k9
    public void a(h9<K, V> h9Var) {
        if (this.f6487a == h9Var && h9Var == this.b) {
            this.b = null;
            this.f6487a = null;
        }
        h9<K, V> h9Var2 = this.f6487a;
        if (h9Var2 == h9Var) {
            this.f6487a = b(h9Var2);
        }
        if (this.b == h9Var) {
            this.b = e();
        }
    }

    public abstract h9<K, V> b(h9<K, V> h9Var);

    public abstract h9<K, V> c(h9<K, V> h9Var);

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Map.Entry<K, V> next() {
        h9<K, V> h9Var = this.b;
        this.b = e();
        return h9Var;
    }

    public final h9<K, V> e() {
        h9<K, V> h9Var = this.b;
        h9<K, V> h9Var2 = this.f6487a;
        if (h9Var == h9Var2 || h9Var2 == null) {
            return null;
        }
        return c(h9Var);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b != null;
    }
}
