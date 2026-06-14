package a;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class t82<T> implements Iterator<T>, s92 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7477a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final T[] f3004a;

    public t82(T[] tArr) {
        f92.d(tArr, "array");
        this.f3004a = tArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f7477a < this.f3004a.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f3004a;
            int i = this.f7477a;
            this.f7477a = i + 1;
            return tArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f7477a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
