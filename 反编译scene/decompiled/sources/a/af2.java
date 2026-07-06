package a;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class af2 extends bf2 implements je2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f5602a = AtomicReferenceFieldUpdater.newUpdater(af2.class, Object.class, "_queue");
    public static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(af2.class, Object.class, "_delayed");
    public volatile Object _queue = null;
    public volatile Object _delayed = null;
    public volatile int _isCompleted = 0;

    @Override // a.ve2
    public long E() {
        ye2 ye2VarH;
        if (F()) {
            return 0L;
        }
        ze2 ze2Var = (ze2) this._delayed;
        if (ze2Var != null && !ze2Var.d()) {
            rg2 rg2VarA = sg2.a();
            long jA = rg2VarA != null ? rg2VarA.a() : System.nanoTime();
            do {
                synchronized (ze2Var) {
                    ye2 ye2VarB = ze2Var.b();
                    ye2VarH = null;
                    if (ye2VarB != null) {
                        ye2 ye2Var = ye2VarB;
                        if (ye2Var.i(jA) ? P(ye2Var) : false) {
                            ye2VarH = ze2Var.h(0);
                        }
                    }
                }
            } while (ye2VarH != null);
        }
        Runnable runnableN = N();
        if (runnableN == null) {
            return y();
        }
        runnableN.run();
        return 0L;
    }

    @Override // a.ve2
    public void H() {
        qg2.f7212a.c();
        X(true);
        M();
        while (E() <= 0) {
        }
        S();
    }

    public final void M() {
        if (be2.a() && !Q()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                if (f5602a.compareAndSet(this, null, df2.b)) {
                    return;
                }
            } else {
                if (obj instanceof di2) {
                    ((di2) obj).d();
                    return;
                }
                if (obj == df2.b) {
                    return;
                }
                di2 di2Var = new di2(8, true);
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
                di2Var.a((Runnable) obj);
                if (f5602a.compareAndSet(this, obj, di2Var)) {
                    return;
                }
            }
        }
    }

    public final Runnable N() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof di2) {
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
                }
                di2 di2Var = (di2) obj;
                Object objJ = di2Var.j();
                if (objJ != di2.f569a) {
                    return (Runnable) objJ;
                }
                f5602a.compareAndSet(this, obj, di2Var.i());
            } else {
                if (obj == df2.b) {
                    return null;
                }
                if (f5602a.compareAndSet(this, obj, null)) {
                    if (obj != null) {
                        return (Runnable) obj;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
            }
        }
    }

    public final void O(Runnable runnable) {
        if (P(runnable)) {
            K();
        } else {
            de2.f5890a.O(runnable);
        }
    }

    public final boolean P(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (Q()) {
                return false;
            }
            if (obj == null) {
                if (f5602a.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof di2) {
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
                }
                di2 di2Var = (di2) obj;
                int iA = di2Var.a(runnable);
                if (iA == 0) {
                    return true;
                }
                if (iA == 1) {
                    f5602a.compareAndSet(this, obj, di2Var.i());
                } else if (iA == 2) {
                    return false;
                }
            } else {
                if (obj == df2.b) {
                    return false;
                }
                di2 di2Var2 = new di2(8, true);
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
                di2Var2.a((Runnable) obj);
                di2Var2.a(runnable);
                if (f5602a.compareAndSet(this, obj, di2Var2)) {
                    return true;
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean Q() {
        return this._isCompleted;
    }

    public boolean R() {
        if (!D()) {
            return false;
        }
        ze2 ze2Var = (ze2) this._delayed;
        if (ze2Var != null && !ze2Var.d()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof di2) {
                return ((di2) obj).g();
            }
            if (obj != df2.b) {
                return false;
            }
        }
        return true;
    }

    public final void S() {
        ye2 ye2VarI;
        rg2 rg2VarA = sg2.a();
        long jA = rg2VarA != null ? rg2VarA.a() : System.nanoTime();
        while (true) {
            ze2 ze2Var = (ze2) this._delayed;
            if (ze2Var == null || (ye2VarI = ze2Var.i()) == null) {
                return;
            } else {
                J(jA, ye2VarI);
            }
        }
    }

    public final void T() {
        this._queue = null;
        this._delayed = null;
    }

    public final void U(long j, ye2 ye2Var) {
        int iV = V(j, ye2Var);
        if (iV == 0) {
            if (Y(ye2Var)) {
                K();
            }
        } else if (iV == 1) {
            J(j, ye2Var);
        } else if (iV != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    public final int V(long j, ye2 ye2Var) {
        if (Q()) {
            return 1;
        }
        ze2 ze2Var = (ze2) this._delayed;
        if (ze2Var == null) {
            b.compareAndSet(this, null, new ze2(j));
            Object obj = this._delayed;
            f92.b(obj);
            ze2Var = (ze2) obj;
        }
        return ye2Var.h(j, ze2Var, this);
    }

    public final re2 W(long j, Runnable runnable) {
        long jC = df2.c(j);
        if (jC >= 4611686018427387903L) {
            return hg2.f6312a;
        }
        rg2 rg2VarA = sg2.a();
        long jA = rg2VarA != null ? rg2VarA.a() : System.nanoTime();
        xe2 xe2Var = new xe2(jC + jA, runnable);
        U(jA, xe2Var);
        return xe2Var;
    }

    public final void X(boolean z) {
        this._isCompleted = z ? 1 : 0;
    }

    public final boolean Y(ye2 ye2Var) {
        ze2 ze2Var = (ze2) this._delayed;
        return (ze2Var != null ? ze2Var.e() : null) == ye2Var;
    }

    @Override // a.je2
    public re2 e(long j, Runnable runnable) {
        return ie2.a(this, j, runnable);
    }

    @Override // a.je2
    public void g(long j, tc2<? super m42> tc2Var) {
        long jC = df2.c(j);
        if (jC < 4611686018427387903L) {
            rg2 rg2VarA = sg2.a();
            long jA = rg2VarA != null ? rg2VarA.a() : System.nanoTime();
            we2 we2Var = new we2(this, jC + jA, tc2Var);
            wc2.a(tc2Var, we2Var);
            U(jA, we2Var);
        }
    }

    @Override // a.od2
    public final void l(l62 l62Var, Runnable runnable) {
        O(runnable);
    }

    @Override // a.ve2
    public long y() {
        ye2 ye2VarE;
        if (super.y() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof di2)) {
                return obj == df2.b ? Long.MAX_VALUE : 0L;
            }
            if (!((di2) obj).g()) {
                return 0L;
            }
        }
        ze2 ze2Var = (ze2) this._delayed;
        if (ze2Var == null || (ye2VarE = ze2Var.e()) == null) {
            return Long.MAX_VALUE;
        }
        long j = ye2VarE.f3686a;
        rg2 rg2VarA = sg2.a();
        return ga2.c(j - (rg2VarA != null ? rg2VarA.a() : System.nanoTime()), 0L);
    }
}
