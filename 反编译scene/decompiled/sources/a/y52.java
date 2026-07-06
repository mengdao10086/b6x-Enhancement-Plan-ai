package a;

import a.i62;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class y52<B extends i62, E extends B> implements j62<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g82<i62, E> f7951a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final j62<?> f3660a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [a.j62<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [a.g82<? super a.i62, ? extends E extends B>, a.g82<a.i62, E extends B>, java.lang.Object] */
    public y52(j62<B> j62Var, g82<? super i62, ? extends E> g82Var) {
        f92.d(j62Var, "baseKey");
        f92.d(g82Var, "safeCast");
        this.f7951a = g82Var;
        this.f3660a = j62Var instanceof y52 ? (j62<B>) ((y52) j62Var).f3660a : j62Var;
    }

    public final boolean a(j62<?> j62Var) {
        f92.d(j62Var, "key");
        return j62Var == this || this.f3660a == j62Var;
    }

    /* JADX WARN: Incorrect return type in method signature: (La/i62;)TE; */
    public final i62 b(i62 i62Var) {
        f92.d(i62Var, "element");
        return (i62) this.f7951a.f(i62Var);
    }
}
