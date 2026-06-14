package a;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class me2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final li2 f6801a = new li2("UNDEFINED");
    public static final li2 b = new li2("REUSABLE_CLAIMED");

    public static final <T> void b(b62<? super T> b62Var, Object obj) {
        boolean z;
        if (!(b62Var instanceof le2)) {
            b62Var.y(obj);
            return;
        }
        le2 le2Var = (le2) b62Var;
        Object objB = hd2.b(obj);
        if (le2Var.f1791a.o(le2Var.c())) {
            le2Var.f1793a = objB;
            ((oe2) le2Var).f7014a = 1;
            le2Var.f1791a.l(le2Var.c(), le2Var);
            return;
        }
        ve2 ve2VarB = qg2.f7212a.b();
        if (ve2VarB.C()) {
            le2Var.f1793a = objB;
            ((oe2) le2Var).f7014a = 1;
            ve2VarB.w(le2Var);
            return;
        }
        ve2VarB.A(true);
        try {
            qf2 qf2Var = (qf2) le2Var.c().get(qf2.f7209a);
            if (qf2Var == null || qf2Var.a()) {
                z = false;
            } else {
                CancellationException cancellationExceptionM = qf2Var.m();
                e42 e42Var = g42.f6169a;
                Object objA = h42.a(cancellationExceptionM);
                g42.a(objA);
                le2Var.y(objA);
                z = true;
            }
            if (!z) {
                l62 l62VarC = le2Var.c();
                Object objC = ti2.c(l62VarC, le2Var.b);
                try {
                    le2Var.f1790a.y(obj);
                    m42 m42Var = m42.f6769a;
                    ti2.a(l62VarC, objC);
                } catch (Throwable th) {
                    ti2.a(l62VarC, objC);
                    throw th;
                }
            }
            while (ve2VarB.F()) {
            }
        } finally {
            try {
            } finally {
            }
        }
    }
}
