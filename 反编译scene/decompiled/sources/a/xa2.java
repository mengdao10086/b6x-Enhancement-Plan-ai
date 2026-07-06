package a;

import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xa2<R> implements Iterator<R>, s92 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ya2 f7871a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Iterator<T> f3565a;

    public xa2(ya2 ya2Var) {
        this.f7871a = ya2Var;
        this.f3565a = ya2Var.f3672a.iterator();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f3565a.hasNext();
    }

    @Override // java.util.Iterator
    public R next() {
        return (R) this.f7871a.f7964a.f(this.f3565a.next());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
