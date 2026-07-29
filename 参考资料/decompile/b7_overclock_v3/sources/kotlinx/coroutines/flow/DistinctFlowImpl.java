package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Ref;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
public final class DistinctFlowImpl<T> implements e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final e<T> f38482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hk.e
    @yt.k
    public final ik.l<T, Object> f38483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @hk.e
    @yt.k
    public final ik.p<Object, Object, Boolean> f38484c;

    /* JADX WARN: Multi-variable type inference failed */
    public DistinctFlowImpl(@yt.k e<? extends T> eVar, @yt.k ik.l<? super T, ? extends Object> lVar, @yt.k ik.p<Object, Object, Boolean> pVar) {
        this.f38482a = eVar;
        this.f38483b = lVar;
        this.f38484c = pVar;
    }

    @Override // kotlinx.coroutines.flow.e
    @yt.l
    public Object a(@yt.k f<? super T> fVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (T) kotlinx.coroutines.flow.internal.l.f38719a;
        Object objA = this.f38482a.a(new DistinctFlowImpl$collect$2(this, objectRef, fVar), cVar);
        return objA == yj.b.h() ? objA : z1.f38230a;
    }
}
