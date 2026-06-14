package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class yi2 {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <R, T> void a(k82<? super R, ? super b62<? super T>, ? extends Object> k82Var, R r, b62<? super T> b62Var) {
        Object objA;
        z62.a(b62Var);
        try {
            l62 l62VarC = b62Var.c();
            Object objC = ti2.c(l62VarC, null);
            try {
            } finally {
                ti2.a(l62VarC, objC);
            }
        } catch (Throwable th) {
            e42 e42Var = g42.f6169a;
            objA = h42.a(th);
        }
        if (k82Var == null) {
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
        r92.b(k82Var, 2);
        objA = k82Var.d(r, b62Var);
        if (objA != r62.c()) {
            e42 e42Var2 = g42.f6169a;
            g42.a(objA);
            b62Var.y(objA);
        }
    }

    public static final <T, R> Object b(ji2<? super T> ji2Var, R r, k82<? super R, ? super b62<? super T>, ? extends Object> k82Var) {
        Object gd2Var;
        Object objG0;
        ji2Var.E0();
        try {
        } catch (Throwable th) {
            gd2Var = new gd2(th, false, 2, null);
        }
        if (k82Var == null) {
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
        r92.b(k82Var, 2);
        gd2Var = k82Var.d(r, ji2Var);
        if (gd2Var == r62.c() || (objG0 = ji2Var.g0(gd2Var)) == cg2.b) {
            return r62.c();
        }
        if (!(objG0 instanceof gd2)) {
            return cg2.h(objG0);
        }
        Throwable th2 = ((gd2) objG0).f999a;
        b62<? super T> b62Var = ji2Var.f6514a;
        if (be2.d() && (b62Var instanceof w62)) {
            throw ki2.j(th2, (w62) b62Var);
        }
        throw th2;
    }

    public static final <T, R> Object c(ji2<? super T> ji2Var, R r, k82<? super R, ? super b62<? super T>, ? extends Object> k82Var) throws Throwable {
        Object gd2Var;
        Object objG0;
        ji2Var.E0();
        try {
        } catch (Throwable th) {
            gd2Var = new gd2(th, false, 2, null);
        }
        if (k82Var == null) {
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
        r92.b(k82Var, 2);
        gd2Var = k82Var.d(r, ji2Var);
        if (gd2Var == r62.c() || (objG0 = ji2Var.g0(gd2Var)) == cg2.b) {
            return r62.c();
        }
        if (!(objG0 instanceof gd2)) {
            return cg2.h(objG0);
        }
        gd2 gd2Var2 = (gd2) objG0;
        Throwable th2 = gd2Var2.f999a;
        if (((th2 instanceof tg2) && ((tg2) th2).f7499a == ji2Var) ? false : true) {
            Throwable th3 = gd2Var2.f999a;
            b62<? super T> b62Var = ji2Var.f6514a;
            if (be2.d() && (b62Var instanceof w62)) {
                throw ki2.j(th3, (w62) b62Var);
            }
            throw th3;
        }
        if (!(gd2Var instanceof gd2)) {
            return gd2Var;
        }
        Throwable th4 = ((gd2) gd2Var).f999a;
        b62<? super T> b62Var2 = ji2Var.f6514a;
        if (be2.d() && (b62Var2 instanceof w62)) {
            throw ki2.j(th4, (w62) b62Var2);
        }
        throw th4;
    }
}
