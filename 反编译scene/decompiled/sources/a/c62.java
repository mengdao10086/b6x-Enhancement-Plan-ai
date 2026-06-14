package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class c62 {
    public static <E extends i62> E a(e62 e62Var, j62<E> j62Var) {
        f92.d(j62Var, "key");
        if (!(j62Var instanceof y52)) {
            if (e62.f5972a != j62Var) {
                return null;
            }
            if (e62Var != null) {
                return e62Var;
            }
            throw new NullPointerException("null cannot be cast to non-null type E");
        }
        y52 y52Var = (y52) j62Var;
        if (!y52Var.a(e62Var.getKey())) {
            return null;
        }
        E e = (E) y52Var.b(e62Var);
        if (e instanceof i62) {
            return e;
        }
        return null;
    }

    public static l62 b(e62 e62Var, j62<?> j62Var) {
        f92.d(j62Var, "key");
        if (!(j62Var instanceof y52)) {
            return e62.f5972a == j62Var ? m62.f6776a : e62Var;
        }
        y52 y52Var = (y52) j62Var;
        return (!y52Var.a(e62Var.getKey()) || y52Var.b(e62Var) == null) ? e62Var : m62.f6776a;
    }
}
