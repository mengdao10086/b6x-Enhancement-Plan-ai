package a;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class uc2<T> extends oe2<T> implements tc2<T>, w62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f7585a = AtomicIntegerFieldUpdater.newUpdater(uc2.class, "_decision");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final AtomicReferenceFieldUpdater f3167a = AtomicReferenceFieldUpdater.newUpdater(uc2.class, Object.class, "_state");
    public volatile int _decision;
    public volatile Object _parentHandle;
    public volatile Object _state;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b62<T> f3168a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final l62 f3169a;

    /* JADX WARN: Multi-variable type inference failed */
    public uc2(b62<? super T> b62Var, int i) {
        super(i);
        this.f3168a = b62Var;
        this.f3169a = b62Var.c();
        this._decision = 0;
        this._state = ic2.f6399a;
        this._parentHandle = null;
    }

    public final Object A() {
        return this._state;
    }

    public void B() {
        J();
    }

    public final boolean C() {
        b62<T> b62Var = this.f3168a;
        return (b62Var instanceof le2) && ((le2) b62Var).m(this);
    }

    public final rc2 D(g82<? super Throwable, m42> g82Var) {
        return g82Var instanceof rc2 ? (rc2) g82Var : new lf2(g82Var);
    }

    public final void E(g82<? super Throwable, m42> g82Var, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + g82Var + ", already has " + obj).toString());
    }

    public String F() {
        return "CancellableContinuation";
    }

    public final void G(Throwable th) {
        if (m(th)) {
            return;
        }
        k(th);
        r();
    }

    public final xc2 H(Object obj, int i) {
        Object obj2;
        do {
            obj2 = this._state;
            if (!(obj2 instanceof ig2)) {
                if (obj2 instanceof xc2) {
                    xc2 xc2Var = (xc2) obj2;
                    if (xc2Var.c()) {
                        return xc2Var;
                    }
                }
                j(obj);
                throw null;
            }
        } while (!f3167a.compareAndSet(this, obj2, obj));
        r();
        s(i);
        return null;
    }

    public final void I(re2 re2Var) {
        this._parentHandle = re2Var;
    }

    public final void J() {
        qf2 qf2Var;
        if (n() || x() != null || (qf2Var = (qf2) this.f3168a.c().get(qf2.f7209a)) == null) {
            return;
        }
        qf2Var.n();
        re2 re2VarD = of2.d(qf2Var, true, false, new yc2(qf2Var, this), 2, null);
        I(re2VarD);
        if (!g() || C()) {
            return;
        }
        re2VarD.b();
        I(hg2.f6312a);
    }

    public final boolean K() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f7585a.compareAndSet(this, 0, 2));
        return true;
    }

    public final boolean L() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f7585a.compareAndSet(this, 0, 1));
        return true;
    }

    @Override // a.oe2
    public void a(Object obj, Throwable th) {
    }

    @Override // a.oe2
    public final b62<T> b() {
        return this.f3168a;
    }

    @Override // a.b62
    public l62 c() {
        return this.f3169a;
    }

    @Override // a.tc2
    public void e(od2 od2Var, T t) {
        b62<T> b62Var = this.f3168a;
        if (!(b62Var instanceof le2)) {
            b62Var = null;
        }
        le2 le2Var = (le2) b62Var;
        H(t, (le2Var != null ? le2Var.f1791a : null) == od2Var ? 2 : ((oe2) this).f7014a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.oe2
    public <T> T f(Object obj) {
        return obj;
    }

    @Override // a.tc2
    public boolean g() {
        return !(A() instanceof ig2);
    }

    @Override // a.oe2
    public Object i() {
        return A();
    }

    public final void j(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    public boolean k(Throwable th) {
        Object obj;
        boolean z;
        do {
            obj = this._state;
            if (!(obj instanceof ig2)) {
                return false;
            }
            z = obj instanceof rc2;
        } while (!f3167a.compareAndSet(this, obj, new xc2(this, th, z)));
        if (z) {
            try {
                ((rc2) obj).a(th);
            } catch (Throwable th2) {
                rd2.a(c(), new jd2("Exception in cancellation handler for " + this, th2));
            }
        }
        r();
        s(0);
        return true;
    }

    @Override // a.tc2
    public Object l(Throwable th) {
        Object obj;
        do {
            obj = this._state;
            if (!(obj instanceof ig2)) {
                return null;
            }
        } while (!f3167a.compareAndSet(this, obj, new gd2(th, false, 2, null)));
        r();
        return vc2.f7680a;
    }

    public final boolean m(Throwable th) {
        if (((oe2) this).f7014a != 0) {
            return false;
        }
        b62<T> b62Var = this.f3168a;
        if (!(b62Var instanceof le2)) {
            b62Var = null;
        }
        le2 le2Var = (le2) b62Var;
        if (le2Var != null) {
            return le2Var.n(th);
        }
        return false;
    }

    public final boolean n() {
        Throwable thJ;
        boolean zG = g();
        if (((oe2) this).f7014a != 0) {
            return zG;
        }
        b62<T> b62Var = this.f3168a;
        if (!(b62Var instanceof le2)) {
            b62Var = null;
        }
        le2 le2Var = (le2) b62Var;
        if (le2Var == null || (thJ = le2Var.j(this)) == null) {
            return zG;
        }
        if (!zG) {
            k(thJ);
        }
        return true;
    }

    @Override // a.tc2
    public void o(Object obj) {
        if (be2.a()) {
            if (!(obj == vc2.f7680a)) {
                throw new AssertionError();
            }
        }
        s(((oe2) this).f7014a);
    }

    @Override // a.w62
    public StackTraceElement p() {
        return null;
    }

    public final void q() {
        re2 re2VarX = x();
        if (re2VarX != null) {
            re2VarX.b();
        }
        I(hg2.f6312a);
    }

    public final void r() {
        if (C()) {
            return;
        }
        q();
    }

    public final void s(int i) {
        if (K()) {
            return;
        }
        pe2.a(this, i);
    }

    @Override // a.tc2
    public boolean t() {
        return A() instanceof xc2;
    }

    public String toString() {
        return F() + '(' + ce2.c(this.f3168a) + "){" + A() + "}@" + ce2.b(this);
    }

    public Throwable u(qf2 qf2Var) {
        return qf2Var.m();
    }

    @Override // a.w62
    public w62 v() {
        b62<T> b62Var = this.f3168a;
        if (!(b62Var instanceof w62)) {
            b62Var = null;
        }
        return (w62) b62Var;
    }

    @Override // a.tc2
    public void w(g82<? super Throwable, m42> g82Var) {
        Object obj;
        rc2 rc2VarD = null;
        do {
            obj = this._state;
            if (!(obj instanceof ic2)) {
                if (obj instanceof rc2) {
                    E(g82Var, obj);
                    throw null;
                }
                if (obj instanceof xc2) {
                    if (!((xc2) obj).b()) {
                        E(g82Var, obj);
                        throw null;
                    }
                    try {
                        if (!(obj instanceof gd2)) {
                            obj = null;
                        }
                        gd2 gd2Var = (gd2) obj;
                        g82Var.f(gd2Var != null ? gd2Var.f999a : null);
                        return;
                    } catch (Throwable th) {
                        rd2.a(c(), new jd2("Exception in cancellation handler for " + this, th));
                        return;
                    }
                }
                return;
            }
            if (rc2VarD == null) {
                rc2VarD = D(g82Var);
            }
        } while (!f3167a.compareAndSet(this, obj, rc2VarD));
    }

    public final re2 x() {
        return (re2) this._parentHandle;
    }

    @Override // a.b62
    public void y(Object obj) {
        H(hd2.c(obj, this), ((oe2) this).f7014a);
    }

    public final Object z() {
        qf2 qf2Var;
        J();
        if (L()) {
            return r62.c();
        }
        Object objA = A();
        if (objA instanceof gd2) {
            Throwable th = ((gd2) objA).f999a;
            if (be2.d()) {
                throw ki2.j(th, this);
            }
            throw th;
        }
        if (((oe2) this).f7014a != 1 || (qf2Var = (qf2) c().get(qf2.f7209a)) == null || qf2Var.a()) {
            f(objA);
            return objA;
        }
        CancellationException cancellationExceptionM = qf2Var.m();
        a(objA, cancellationExceptionM);
        if (be2.d()) {
            throw ki2.j(cancellationExceptionM, this);
        }
        throw cancellationExceptionM;
    }
}
