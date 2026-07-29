package v4;

/* JADX INFO: loaded from: classes2.dex */
public final class b<K, V> extends androidx.collection.a<K, V> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f52667n;

    @Override // androidx.collection.l, java.util.Map
    public void clear() {
        this.f52667n = 0;
        super.clear();
    }

    @Override // androidx.collection.l, java.util.Map
    public int hashCode() {
        if (this.f52667n == 0) {
            this.f52667n = super.hashCode();
        }
        return this.f52667n;
    }

    @Override // androidx.collection.l
    public void l(androidx.collection.l<? extends K, ? extends V> lVar) {
        this.f52667n = 0;
        super.l(lVar);
    }

    @Override // androidx.collection.l
    public V m(int i10) {
        this.f52667n = 0;
        return (V) super.m(i10);
    }

    @Override // androidx.collection.l
    public V n(int i10, V v10) {
        this.f52667n = 0;
        return (V) super.n(i10, v10);
    }

    @Override // androidx.collection.l, java.util.Map
    public V put(K k10, V v10) {
        this.f52667n = 0;
        return (V) super.put(k10, v10);
    }
}
