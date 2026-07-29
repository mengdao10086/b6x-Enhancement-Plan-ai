package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nCollect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collect$3\n*L\n1#1,118:1\n*E\n"})
public final class FlowKt__CollectKt$collect$3<T> implements f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ik.p<T, kotlin.coroutines.c<? super z1>, Object> f38501a;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__CollectKt$collect$3(ik.p<? super T, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar) {
        this.f38501a = pVar;
    }

    @yt.l
    public Object a(T t10, @yt.k final kotlin.coroutines.c<? super z1> cVar) {
        c0.e(4);
        new ContinuationImpl(cVar) { // from class: kotlinx.coroutines.flow.FlowKt__CollectKt$collect$3$emit$1
            public int label;
            public /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @yt.l
            public final Object q0(@yt.k Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return this.this$0.f(null, this);
            }
        };
        c0.e(5);
        this.f38501a.r0(t10, cVar);
        return z1.f38230a;
    }

    @Override // kotlinx.coroutines.flow.f
    @yt.l
    public Object f(T t10, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        Object objR0 = this.f38501a.r0(t10, cVar);
        return objR0 == yj.b.h() ? objR0 : z1.f38230a;
    }
}
