package a;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class mc2<T> extends hc2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ve2 f6794a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Thread f1925a;

    public mc2(l62 l62Var, Thread thread, ve2 ve2Var) {
        super(l62Var, true);
        this.f1925a = thread;
        this.f6794a = ve2Var;
    }

    @Override // a.bg2
    public void E(Object obj) {
        if (!f92.a(Thread.currentThread(), this.f1925a)) {
            LockSupport.unpark(this.f1925a);
        }
    }

    public final T J0() throws Throwable {
        rg2 rg2VarA = sg2.a();
        if (rg2VarA != null) {
            rg2VarA.g();
        }
        try {
            ve2 ve2Var = this.f6794a;
            if (ve2Var != null) {
                ve2.B(ve2Var, false, 1, null);
            }
            while (!Thread.interrupted()) {
                try {
                    ve2 ve2Var2 = this.f6794a;
                    long jE = ve2Var2 != null ? ve2Var2.E() : Long.MAX_VALUE;
                    if (g()) {
                        T t = (T) cg2.h(a0());
                        gd2 gd2Var = (gd2) (t instanceof gd2 ? t : null);
                        if (gd2Var == null) {
                            return t;
                        }
                        throw gd2Var.f999a;
                    }
                    rg2 rg2VarA2 = sg2.a();
                    if (rg2VarA2 != null) {
                        rg2VarA2.c(this, jE);
                    } else {
                        LockSupport.parkNanos(this, jE);
                    }
                } finally {
                    ve2 ve2Var3 = this.f6794a;
                    if (ve2Var3 != null) {
                        ve2.t(ve2Var3, false, 1, null);
                    }
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            H(interruptedException);
            throw interruptedException;
        } finally {
            rg2 rg2VarA3 = sg2.a();
            if (rg2VarA3 != null) {
                rg2VarA3.e();
            }
        }
    }

    @Override // a.bg2
    public boolean e0() {
        return true;
    }
}
