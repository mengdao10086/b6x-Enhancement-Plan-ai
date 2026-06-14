package a;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class oe2<T> extends jj2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7014a;

    public oe2(int i) {
        this.f7014a = i;
    }

    public void a(Object obj, Throwable th) {
    }

    public abstract b62<T> b();

    public final Throwable d(Object obj) {
        if (!(obj instanceof gd2)) {
            obj = null;
        }
        gd2 gd2Var = (gd2) obj;
        if (gd2Var != null) {
            return gd2Var.f999a;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T f(Object obj) {
        return obj;
    }

    public final void h(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            x32.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        f92.b(th);
        rd2.a(b().c(), new ae2("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object i();

    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, InvocationTargetException {
        Object objA;
        Object objF;
        Object objA2;
        kj2 kj2Var = ((jj2) this).f1550a;
        try {
            b62<T> b62VarB = b();
            if (b62VarB == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<T>");
            }
            le2 le2Var = (le2) b62VarB;
            b62<T> b62Var = le2Var.f1790a;
            l62 l62VarC = b62Var.c();
            Object objI = i();
            Object objC = ti2.c(l62VarC, le2Var.b);
            try {
                Throwable thD = d(objI);
                qf2 qf2Var = pe2.b(this.f7014a) ? (qf2) l62VarC.get(qf2.f7209a) : null;
                if (thD == null && qf2Var != null && !qf2Var.a()) {
                    Throwable thM = qf2Var.m();
                    a(objI, thM);
                    e42 e42Var = g42.f6169a;
                    if (be2.d() && (b62Var instanceof w62)) {
                        thM = ki2.j(thM, (w62) b62Var);
                    }
                    objF = h42.a(thM);
                    g42.a(objF);
                } else if (thD != null) {
                    e42 e42Var2 = g42.f6169a;
                    objF = h42.a(thD);
                    g42.a(objF);
                } else {
                    objF = f(objI);
                    e42 e42Var3 = g42.f6169a;
                    g42.a(objF);
                }
                b62Var.y(objF);
                m42 m42Var = m42.f6769a;
                try {
                    e42 e42Var4 = g42.f6169a;
                    kj2Var.f();
                    objA2 = m42.f6769a;
                    g42.a(objA2);
                } catch (Throwable th) {
                    e42 e42Var5 = g42.f6169a;
                    objA2 = h42.a(th);
                    g42.a(objA2);
                }
                h(null, g42.b(objA2));
            } finally {
                ti2.a(l62VarC, objC);
            }
        } catch (Throwable th2) {
            try {
                e42 e42Var6 = g42.f6169a;
                kj2Var.f();
                objA = m42.f6769a;
                g42.a(objA);
            } catch (Throwable th3) {
                e42 e42Var7 = g42.f6169a;
                objA = h42.a(th3);
                g42.a(objA);
            }
            h(th2, g42.b(objA));
        }
    }
}
