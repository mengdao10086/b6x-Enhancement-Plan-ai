package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class pe2 {
    public static final <T> void a(oe2<? super T> oe2Var, int i) {
        b62<? super T> b62VarB = oe2Var.b();
        if (!c(i) || !(b62VarB instanceof le2) || b(i) != b(oe2Var.f7014a)) {
            d(oe2Var, b62VarB, i);
            return;
        }
        od2 od2Var = ((le2) b62VarB).f1791a;
        l62 l62VarC = b62VarB.c();
        if (od2Var.o(l62VarC)) {
            od2Var.l(l62VarC, oe2Var);
        } else {
            e(oe2Var);
        }
    }

    public static final boolean b(int i) {
        return i == 1;
    }

    public static final boolean c(int i) {
        return i == 0 || i == 1;
    }

    public static final <T> void d(oe2<? super T> oe2Var, b62<? super T> b62Var, int i) {
        Object objF;
        Object objI = oe2Var.i();
        Throwable thD = oe2Var.d(objI);
        if (thD == null) {
            thD = null;
        } else if (be2.d() && (b62Var instanceof w62)) {
            thD = ki2.j(thD, (w62) b62Var);
        }
        if (thD != null) {
            e42 e42Var = g42.f6169a;
            objF = h42.a(thD);
        } else {
            e42 e42Var2 = g42.f6169a;
            objF = oe2Var.f(objI);
        }
        g42.a(objF);
        if (i == 0) {
            b62Var.y(objF);
            return;
        }
        if (i == 1) {
            me2.b(b62Var, objF);
            return;
        }
        if (i != 2) {
            throw new IllegalStateException(("Invalid mode " + i).toString());
        }
        if (b62Var == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<T>");
        }
        le2 le2Var = (le2) b62Var;
        l62 l62VarC = le2Var.c();
        Object objC = ti2.c(l62VarC, le2Var.b);
        try {
            le2Var.f1790a.y(objF);
            m42 m42Var = m42.f6769a;
        } finally {
            ti2.a(l62VarC, objC);
        }
    }

    public static final void e(oe2<?> oe2Var) {
        ve2 ve2VarB = qg2.f7212a.b();
        if (ve2VarB.C()) {
            ve2VarB.w(oe2Var);
            return;
        }
        ve2VarB.A(true);
        try {
            d(oe2Var, oe2Var.b(), 2);
            do {
            } while (ve2VarB.F());
        } finally {
            try {
            } finally {
            }
        }
    }
}
