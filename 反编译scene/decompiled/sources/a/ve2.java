package a;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ve2 extends od2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f7688a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ih2<oe2<?>> f3272a;
    public boolean b;

    public static /* synthetic */ void B(ve2 ve2Var, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        ve2Var.A(z);
    }

    public static /* synthetic */ void t(ve2 ve2Var, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        ve2Var.p(z);
    }

    public final void A(boolean z) {
        this.f7688a += v(z);
        if (z) {
            return;
        }
        this.b = true;
    }

    public final boolean C() {
        return this.f7688a >= v(true);
    }

    public final boolean D() {
        ih2<oe2<?>> ih2Var = this.f3272a;
        if (ih2Var != null) {
            return ih2Var.c();
        }
        return true;
    }

    public abstract long E();

    public final boolean F() throws IllegalAccessException, InvocationTargetException {
        oe2<?> oe2VarD;
        ih2<oe2<?>> ih2Var = this.f3272a;
        if (ih2Var == null || (oe2VarD = ih2Var.d()) == null) {
            return false;
        }
        oe2VarD.run();
        return true;
    }

    public boolean G() {
        return false;
    }

    public abstract void H();

    public final void p(boolean z) {
        long jV = this.f7688a - v(z);
        this.f7688a = jV;
        if (jV > 0) {
            return;
        }
        if (be2.a()) {
            if (!(this.f7688a == 0)) {
                throw new AssertionError();
            }
        }
        if (this.b) {
            H();
        }
    }

    public final long v(boolean z) {
        return z ? 4294967296L : 1L;
    }

    public final void w(oe2<?> oe2Var) {
        ih2<oe2<?>> ih2Var = this.f3272a;
        if (ih2Var == null) {
            ih2Var = new ih2<>();
            this.f3272a = ih2Var;
        }
        ih2Var.a(oe2Var);
    }

    public long y() {
        ih2<oe2<?>> ih2Var = this.f3272a;
        return (ih2Var == null || ih2Var.c()) ? Long.MAX_VALUE : 0L;
    }
}
