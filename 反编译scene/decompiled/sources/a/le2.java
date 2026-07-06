package a;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class le2<T> extends oe2<T> implements w62, b62<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f6699a = AtomicReferenceFieldUpdater.newUpdater(le2.class, Object.class, "_reusableCancellableContinuation");
    public volatile Object _reusableCancellableContinuation;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b62<T> f1790a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final od2 f1791a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final w62 f1792a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f1793a;
    public final Object b;

    /* JADX WARN: Multi-variable type inference failed */
    public le2(od2 od2Var, b62<? super T> b62Var) {
        super(0);
        this.f1791a = od2Var;
        this.f1790a = b62Var;
        this.f1793a = me2.f6801a;
        b62<T> b62Var2 = this.f1790a;
        this.f1792a = (w62) (b62Var2 instanceof w62 ? b62Var2 : null);
        this.b = ti2.b(c());
        this._reusableCancellableContinuation = null;
    }

    @Override // a.oe2
    public b62<T> b() {
        return this;
    }

    @Override // a.b62
    public l62 c() {
        return this.f1790a.c();
    }

    @Override // a.oe2
    public Object i() {
        Object obj = this.f1793a;
        if (be2.a()) {
            if (!(obj != me2.f6801a)) {
                throw new AssertionError();
            }
        }
        this.f1793a = me2.f6801a;
        return obj;
    }

    public final Throwable j(tc2<?> tc2Var) {
        li2 li2Var;
        do {
            Object obj = this._reusableCancellableContinuation;
            li2Var = me2.b;
            if (obj != li2Var) {
                if (obj == null) {
                    return null;
                }
                if (obj instanceof Throwable) {
                    if (f6699a.compareAndSet(this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!f6699a.compareAndSet(this, li2Var, tc2Var));
        return null;
    }

    public final uc2<?> k() {
        Object obj = this._reusableCancellableContinuation;
        if (!(obj instanceof uc2)) {
            obj = null;
        }
        return (uc2) obj;
    }

    public final boolean m(uc2<?> uc2Var) {
        Object obj = this._reusableCancellableContinuation;
        if (obj != null) {
            return !(obj instanceof uc2) || obj == uc2Var;
        }
        return false;
    }

    public final boolean n(Throwable th) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            if (f92.a(obj, me2.b)) {
                if (f6699a.compareAndSet(this, me2.b, th)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (f6699a.compareAndSet(this, obj, null)) {
                    return false;
                }
            }
        }
    }

    @Override // a.w62
    public StackTraceElement p() {
        return null;
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f1791a + ", " + ce2.c(this.f1790a) + ']';
    }

    @Override // a.w62
    public w62 v() {
        return this.f1792a;
    }

    @Override // a.b62
    public void y(Object obj) {
        l62 l62VarC = this.f1790a.c();
        Object objB = hd2.b(obj);
        if (this.f1791a.o(l62VarC)) {
            this.f1793a = objB;
            ((oe2) this).f7014a = 0;
            this.f1791a.l(l62VarC, this);
            return;
        }
        ve2 ve2VarB = qg2.f7212a.b();
        if (ve2VarB.C()) {
            this.f1793a = objB;
            ((oe2) this).f7014a = 0;
            ve2VarB.w(this);
            return;
        }
        ve2VarB.A(true);
        try {
            l62 l62VarC2 = c();
            Object objC = ti2.c(l62VarC2, this.b);
            try {
                this.f1790a.y(obj);
                m42 m42Var = m42.f6769a;
                while (ve2VarB.F()) {
                }
            } finally {
                ti2.a(l62VarC2, objC);
            }
        } finally {
            try {
            } finally {
            }
        }
    }
}
