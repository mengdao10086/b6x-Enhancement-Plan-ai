package kotlin.collections;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class y0<T> extends d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final List<T> f37750a;

    public y0(@yt.k List<T> delegate) {
        kotlin.jvm.internal.f0.p(delegate, "delegate");
        this.f37750a = delegate;
    }

    @Override // kotlin.collections.d
    public int a() {
        return this.f37750a.size();
    }

    @Override // kotlin.collections.d, java.util.AbstractList, java.util.List
    public void add(int i10, T t10) {
        this.f37750a.add(y.Z0(this, i10), t10);
    }

    @Override // kotlin.collections.d
    public T b(int i10) {
        return this.f37750a.remove(y.Y0(this, i10));
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f37750a.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i10) {
        return this.f37750a.get(y.Y0(this, i10));
    }

    @Override // kotlin.collections.d, java.util.AbstractList, java.util.List
    public T set(int i10, T t10) {
        return this.f37750a.set(y.Y0(this, i10), t10);
    }
}
