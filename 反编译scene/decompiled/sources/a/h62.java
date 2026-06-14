package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class h62 {
    public static <R> R a(i62 i62Var, R r, k82<? super R, ? super i62, ? extends R> k82Var) {
        f92.d(k82Var, "operation");
        return k82Var.d(r, i62Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E extends i62> E b(i62 i62Var, j62<E> j62Var) {
        f92.d(j62Var, "key");
        if (!f92.a(i62Var.getKey(), j62Var)) {
            return null;
        }
        if (i62Var != 0) {
            return i62Var;
        }
        throw new NullPointerException("null cannot be cast to non-null type E");
    }

    public static l62 c(i62 i62Var, j62<?> j62Var) {
        f92.d(j62Var, "key");
        return f92.a(i62Var.getKey(), j62Var) ? m62.f6776a : i62Var;
    }

    public static l62 d(i62 i62Var, l62 l62Var) {
        f92.d(l62Var, "context");
        return g62.a(i62Var, l62Var);
    }
}
