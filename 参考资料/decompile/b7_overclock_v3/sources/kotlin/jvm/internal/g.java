package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public final class g<T> implements Iterator<T>, jk.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final T[] f37899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f37900b;

    public g(@yt.k T[] array) {
        f0.p(array, "array");
        this.f37899a = array;
    }

    @yt.k
    public final T[] a() {
        return this.f37899a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f37900b < this.f37899a.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f37899a;
            int i10 = this.f37900b;
            this.f37900b = i10 + 1;
            return tArr[i10];
        } catch (ArrayIndexOutOfBoundsException e10) {
            this.f37900b--;
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
