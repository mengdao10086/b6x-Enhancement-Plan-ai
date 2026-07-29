package kotlin.collections;

import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes5.dex */
public final class v0<E> extends b<E> implements RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final List<E> f37745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f37746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f37747d;

    /* JADX WARN: Multi-variable type inference failed */
    public v0(@yt.k List<? extends E> list) {
        kotlin.jvm.internal.f0.p(list, "list");
        this.f37745b = list;
    }

    @Override // kotlin.collections.b, kotlin.collections.AbstractCollection
    public int a() {
        return this.f37747d;
    }

    public final void b(int i10, int i11) {
        b.f37685a.d(i10, i11, this.f37745b.size());
        this.f37746c = i10;
        this.f37747d = i11 - i10;
    }

    @Override // kotlin.collections.b, java.util.List
    public E get(int i10) {
        b.f37685a.b(i10, this.f37747d);
        return this.f37745b.get(this.f37746c + i10);
    }
}
