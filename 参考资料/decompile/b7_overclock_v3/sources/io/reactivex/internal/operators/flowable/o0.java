package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes5.dex */
public final class o0<R, T> extends a<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xi.n<? extends R, ? super T> f33713c;

    public o0(xi.j<T> jVar, xi.n<? extends R, ? super T> nVar) {
        super(jVar);
        this.f33713c = nVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super R> dVar) {
        try {
            bu.d<? super Object> dVarA = this.f33713c.a(dVar);
            if (dVarA != null) {
                this.f33524b.d(dVarA);
                return;
            }
            throw new NullPointerException("Operator " + this.f33713c + " returned a null Subscriber");
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
