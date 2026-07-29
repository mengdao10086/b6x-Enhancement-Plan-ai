package kotlinx.coroutines.flow;

import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
public final class CancellableFlowImpl<T> implements a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final e<T> f38480a;

    /* JADX WARN: Multi-variable type inference failed */
    public CancellableFlowImpl(@yt.k e<? extends T> eVar) {
        this.f38480a = eVar;
    }

    @Override // kotlinx.coroutines.flow.e
    @yt.l
    public Object a(@yt.k f<? super T> fVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        Object objA = this.f38480a.a(new CancellableFlowImpl$collect$2(fVar), cVar);
        return objA == yj.b.h() ? objA : z1.f38230a;
    }
}
