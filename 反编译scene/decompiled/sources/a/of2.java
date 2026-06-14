package a;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class of2 {
    public static /* synthetic */ void a(qf2 qf2Var, CancellationException cancellationException, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        qf2Var.q(cancellationException);
    }

    public static <R> R b(qf2 qf2Var, R r, k82<? super R, ? super i62, ? extends R> k82Var) {
        return (R) h62.a(qf2Var, r, k82Var);
    }

    public static <E extends i62> E c(qf2 qf2Var, j62<E> j62Var) {
        return (E) h62.b(qf2Var, j62Var);
    }

    public static /* synthetic */ re2 d(qf2 qf2Var, boolean z, boolean z2, g82 g82Var, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return qf2Var.i(z, z2, g82Var);
    }

    public static l62 e(qf2 qf2Var, j62<?> j62Var) {
        return h62.c(qf2Var, j62Var);
    }

    public static l62 f(qf2 qf2Var, l62 l62Var) {
        return h62.d(qf2Var, l62Var);
    }
}
