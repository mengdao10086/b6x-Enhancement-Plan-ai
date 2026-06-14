package a;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class na2<T> implements Iterator<T>, s92 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6894a = -2;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ oa2 f2033a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public T f2034a;

    public na2(oa2 oa2Var) {
        this.f2033a = oa2Var;
    }

    public final void a() {
        T t;
        if (this.f6894a == -2) {
            t = (T) this.f2033a.f2223a.i();
        } else {
            g82 g82Var = this.f2033a.f7002a;
            T t2 = this.f2034a;
            f92.b(t2);
            t = (T) g82Var.f(t2);
        }
        this.f2034a = t;
        this.f6894a = t == null ? 0 : 1;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f6894a < 0) {
            a();
        }
        return this.f6894a == 1;
    }

    @Override // java.util.Iterator
    public T next() {
        if (this.f6894a < 0) {
            a();
        }
        if (this.f6894a == 0) {
            throw new NoSuchElementException();
        }
        T t = this.f2034a;
        if (t == null) {
            throw new NullPointerException("null cannot be cast to non-null type T");
        }
        this.f6894a = -1;
        return t;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
