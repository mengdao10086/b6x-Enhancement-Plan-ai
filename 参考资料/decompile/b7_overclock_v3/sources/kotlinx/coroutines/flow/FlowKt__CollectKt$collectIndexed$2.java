package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nCollect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2\n+ 2 FlowExceptions.common.kt\nkotlinx/coroutines/flow/internal/FlowExceptions_commonKt\n*L\n1#1,118:1\n32#2,4:119\n*S KotlinDebug\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2\n*L\n62#1:119,4\n*E\n"})
public final class FlowKt__CollectKt$collectIndexed$2<T> implements f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f38502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ik.q<Integer, T, kotlin.coroutines.c<? super z1>, Object> f38503b;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__CollectKt$collectIndexed$2(ik.q<? super Integer, ? super T, ? super kotlin.coroutines.c<? super z1>, ? extends Object> qVar) {
        this.f38503b = qVar;
    }

    @yt.l
    public Object a(T t10, @yt.k final kotlin.coroutines.c<? super z1> cVar) {
        c0.e(4);
        new ContinuationImpl(cVar) { // from class: kotlinx.coroutines.flow.FlowKt__CollectKt$collectIndexed$2$emit$1
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
        ik.q<Integer, T, kotlin.coroutines.c<? super z1>, Object> qVar = this.f38503b;
        int i10 = this.f38502a;
        this.f38502a = i10 + 1;
        if (i10 < 0) {
            throw new ArithmeticException("Index overflow has happened");
        }
        qVar.A(Integer.valueOf(i10), t10, cVar);
        return z1.f38230a;
    }

    @Override // kotlinx.coroutines.flow.f
    @yt.l
    public Object f(T t10, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        ik.q<Integer, T, kotlin.coroutines.c<? super z1>, Object> qVar = this.f38503b;
        int i10 = this.f38502a;
        this.f38502a = i10 + 1;
        if (i10 < 0) {
            throw new ArithmeticException("Index overflow has happened");
        }
        Object objA = qVar.A(zj.a.f(i10), t10, cVar);
        return objA == yj.b.h() ? objA : z1.f38230a;
    }
}
