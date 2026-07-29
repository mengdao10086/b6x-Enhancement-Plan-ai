package kotlinx.coroutines.flow;

import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
public final class m<T> extends AbstractFlow<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final ik.p<f<? super T>, kotlin.coroutines.c<? super z1>, Object> f38729a;

    /* JADX WARN: Multi-variable type inference failed */
    public m(@yt.k ik.p<? super f<? super T>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar) {
        this.f38729a = pVar;
    }

    @Override // kotlinx.coroutines.flow.AbstractFlow
    @yt.l
    public Object d(@yt.k f<? super T> fVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        Object objR0 = this.f38729a.r0(fVar, cVar);
        return objR0 == yj.b.h() ? objR0 : z1.f38230a;
    }
}
