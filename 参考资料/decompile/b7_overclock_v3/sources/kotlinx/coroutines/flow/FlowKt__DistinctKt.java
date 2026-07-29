package kotlinx.coroutines.flow;

import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.w0;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FlowKt__DistinctKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final ik.l<Object, Object> f38510a = new ik.l<Object, Object>() { // from class: kotlinx.coroutines.flow.FlowKt__DistinctKt$defaultKeySelector$1
        @Override // ik.l
        @yt.l
        public final Object i(@yt.l Object obj) {
            return obj;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final ik.p<Object, Object, Boolean> f38511b = new ik.p<Object, Object, Boolean>() { // from class: kotlinx.coroutines.flow.FlowKt__DistinctKt$defaultAreEquivalent$1
        @Override // ik.p
        @yt.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean r0(@yt.l Object obj, @yt.l Object obj2) {
            return Boolean.valueOf(f0.g(obj, obj2));
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <T> e<T> a(@yt.k e<? extends T> eVar) {
        return eVar instanceof u ? eVar : d(eVar, f38510a, f38511b);
    }

    @yt.k
    public static final <T> e<T> b(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super T, Boolean> pVar) {
        ik.l<Object, Object> lVar = f38510a;
        f0.n(pVar, "null cannot be cast to non-null type kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Boolean>");
        return d(eVar, lVar, (ik.p) w0.q(pVar, 2));
    }

    @yt.k
    public static final <T, K> e<T> c(@yt.k e<? extends T> eVar, @yt.k ik.l<? super T, ? extends K> lVar) {
        return d(eVar, lVar, f38511b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> e<T> d(e<? extends T> eVar, ik.l<? super T, ? extends Object> lVar, ik.p<Object, Object, Boolean> pVar) {
        if (eVar instanceof DistinctFlowImpl) {
            DistinctFlowImpl distinctFlowImpl = (DistinctFlowImpl) eVar;
            if (distinctFlowImpl.f38483b == lVar && distinctFlowImpl.f38484c == pVar) {
                return eVar;
            }
        }
        return new DistinctFlowImpl(eVar, lVar, pVar);
    }
}
