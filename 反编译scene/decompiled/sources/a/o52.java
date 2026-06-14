package a;

import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class o52<T> implements Iterable<n52<? extends T>>, s92 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v72<Iterator<T>> f6985a;

    /* JADX WARN: Multi-variable type inference failed */
    public o52(v72<? extends Iterator<? extends T>> v72Var) {
        f92.d(v72Var, "iteratorFactory");
        this.f6985a = v72Var;
    }

    @Override // java.lang.Iterable
    public Iterator<n52<T>> iterator() {
        return new p52(this.f6985a.i());
    }
}
