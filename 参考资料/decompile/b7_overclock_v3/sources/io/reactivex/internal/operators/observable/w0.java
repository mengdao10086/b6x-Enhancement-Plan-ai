package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes5.dex */
public final class w0<R, T> extends a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.d0<? extends R, ? super T> f34759b;

    public w0(xi.e0<T> e0Var, xi.d0<? extends R, ? super T> d0Var) {
        super(e0Var);
        this.f34759b = d0Var;
    }

    @Override // xi.z
    public void I5(xi.g0<? super R> g0Var) {
        try {
            this.f34421a.c((xi.g0) io.reactivex.internal.functions.a.g(this.f34759b.a(g0Var), "Operator " + this.f34759b + " returned a null Observer"));
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            kj.a.Y(th2);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }
}
