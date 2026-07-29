package kotlinx.coroutines;

/* JADX INFO: loaded from: classes5.dex */
public final class y<T> extends JobSupport implements x<T> {
    public y(@yt.l c2 c2Var) {
        super(true);
        N0(c2Var);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean E0() {
        return true;
    }

    @Override // kotlinx.coroutines.u0
    @yt.k
    public kotlinx.coroutines.selects.e<T> M() {
        kotlinx.coroutines.selects.e<T> eVar = (kotlinx.coroutines.selects.e<T>) C0();
        kotlin.jvm.internal.f0.n(eVar, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectClause1<T of kotlinx.coroutines.CompletableDeferredImpl>");
        return eVar;
    }

    @Override // kotlinx.coroutines.u0
    @yt.l
    public Object b0(@yt.k kotlin.coroutines.c<? super T> cVar) throws Throwable {
        Object objF0 = f0(cVar);
        yj.b.h();
        return objF0;
    }

    @Override // kotlinx.coroutines.x
    public boolean l(@yt.k Throwable th2) {
        return W0(new c0(th2, false, 2, null));
    }

    @Override // kotlinx.coroutines.u0
    public T u() {
        return (T) w0();
    }

    @Override // kotlinx.coroutines.x
    public boolean u1(T t10) {
        return W0(t10);
    }
}
