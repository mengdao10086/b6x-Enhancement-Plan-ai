package a;

import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ya2<T, R> implements pa2<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g82<T, R> f7964a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final pa2<T> f3672a;

    /* JADX WARN: Multi-variable type inference failed */
    public ya2(pa2<? extends T> pa2Var, g82<? super T, ? extends R> g82Var) {
        f92.d(pa2Var, "sequence");
        f92.d(g82Var, "transformer");
        this.f3672a = pa2Var;
        this.f7964a = g82Var;
    }

    @Override // a.pa2
    public Iterator<R> iterator() {
        return new xa2(this);
    }
}
