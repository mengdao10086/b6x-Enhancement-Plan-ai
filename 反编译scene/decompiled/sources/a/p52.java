package a;

import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class p52<T> implements Iterator<n52<? extends T>>, s92 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7088a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Iterator<T> f2397a;

    /* JADX WARN: Multi-variable type inference failed */
    public p52(Iterator<? extends T> it) {
        f92.d(it, "iterator");
        this.f2397a = it;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final n52<T> next() {
        int i = this.f7088a;
        this.f7088a = i + 1;
        if (i >= 0) {
            return new n52<>(i, this.f2397a.next());
        }
        y42.l();
        throw null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2397a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
