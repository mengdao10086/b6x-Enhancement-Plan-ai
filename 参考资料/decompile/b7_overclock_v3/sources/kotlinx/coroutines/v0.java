package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
public class v0<T> extends a<T> implements u0<T> {
    public v0(@yt.k CoroutineContext coroutineContext, boolean z10) {
        super(coroutineContext, true, z10);
    }

    public static /* synthetic */ <T> Object J1(v0<T> v0Var, kotlin.coroutines.c<? super T> cVar) throws Throwable {
        Object objF0 = v0Var.f0(cVar);
        yj.b.h();
        return objF0;
    }

    @Override // kotlinx.coroutines.u0
    @yt.k
    public kotlinx.coroutines.selects.e<T> M() {
        kotlinx.coroutines.selects.e<T> eVar = (kotlinx.coroutines.selects.e<T>) C0();
        kotlin.jvm.internal.f0.n(eVar, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectClause1<T of kotlinx.coroutines.DeferredCoroutine>");
        return eVar;
    }

    @Override // kotlinx.coroutines.u0
    @yt.l
    public Object b0(@yt.k kotlin.coroutines.c<? super T> cVar) {
        return J1(this, cVar);
    }

    @Override // kotlinx.coroutines.u0
    public T u() {
        return (T) w0();
    }
}
