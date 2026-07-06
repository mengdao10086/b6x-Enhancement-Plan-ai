package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class q62 {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <R, T> b62<m42> a(k82<? super R, ? super b62<? super T>, ? extends Object> k82Var, R r, b62<? super T> b62Var) {
        f92.d(k82Var, "$this$createCoroutineUnintercepted");
        f92.d(b62Var, "completion");
        z62.a(b62Var);
        if (k82Var instanceof s62) {
            return ((s62) k82Var).a(r, b62Var);
        }
        l62 l62VarC = b62Var.c();
        if (l62VarC == m62.f6776a) {
            if (b62Var != null) {
                return new o62(b62Var, b62Var, k82Var, r);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }
        if (b62Var != null) {
            return new p62(b62Var, l62VarC, b62Var, l62VarC, k82Var, r);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> b62<T> b(b62<? super T> b62Var) {
        b62<T> b62Var2;
        f92.d(b62Var, "$this$intercepted");
        v62 v62Var = (v62) (!(b62Var instanceof v62) ? null : b62Var);
        return (v62Var == null || (b62Var2 = (b62<T>) v62Var.m()) == null) ? b62Var : b62Var2;
    }
}
