package a;

import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class oa2<T> implements pa2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g82<T, T> f7002a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final v72<T> f2223a;

    /* JADX WARN: Multi-variable type inference failed */
    public oa2(v72<? extends T> v72Var, g82<? super T, ? extends T> g82Var) {
        f92.d(v72Var, "getInitialValue");
        f92.d(g82Var, "getNextValue");
        this.f2223a = v72Var;
        this.f7002a = g82Var;
    }

    @Override // a.pa2
    public Iterator<T> iterator() {
        return new na2(this);
    }
}
