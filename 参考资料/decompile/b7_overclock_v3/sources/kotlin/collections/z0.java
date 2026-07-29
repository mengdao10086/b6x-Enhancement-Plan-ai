package kotlin.collections;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class z0<T> extends b<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final List<T> f37751b;

    /* JADX WARN: Multi-variable type inference failed */
    public z0(@yt.k List<? extends T> delegate) {
        kotlin.jvm.internal.f0.p(delegate, "delegate");
        this.f37751b = delegate;
    }

    @Override // kotlin.collections.b, kotlin.collections.AbstractCollection
    public int a() {
        return this.f37751b.size();
    }

    @Override // kotlin.collections.b, java.util.List
    public T get(int i10) {
        return this.f37751b.get(y.Y0(this, i10));
    }
}
