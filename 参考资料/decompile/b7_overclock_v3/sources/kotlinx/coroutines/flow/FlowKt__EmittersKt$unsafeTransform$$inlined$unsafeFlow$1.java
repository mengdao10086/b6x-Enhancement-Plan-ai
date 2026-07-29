package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n1#1,112:1\n51#2,5:113\n*E\n"})
public final class FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1<R> implements e<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f38524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ik.q f38525b;

    public FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1(e eVar, ik.q qVar) {
        this.f38524a = eVar;
        this.f38525b = qVar;
    }

    @Override // kotlinx.coroutines.flow.e
    @yt.l
    public Object a(@yt.k f<? super R> fVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        Object objA = this.f38524a.a(new FlowKt__EmittersKt$unsafeTransform$1$1(this.f38525b, fVar), cVar);
        return objA == yj.b.h() ? objA : z1.f38230a;
    }

    @yt.l
    public Object d(@yt.k f fVar, @yt.k kotlin.coroutines.c cVar) {
        c0.e(4);
        new ContinuationImpl(cVar) { // from class: kotlinx.coroutines.flow.FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1.1
            public int label;
            public /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @yt.l
            public final Object q0(@yt.k Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1.this.a(null, this);
            }
        };
        c0.e(5);
        e eVar = this.f38524a;
        FlowKt__EmittersKt$unsafeTransform$1$1 flowKt__EmittersKt$unsafeTransform$1$1 = new FlowKt__EmittersKt$unsafeTransform$1$1(this.f38525b, fVar);
        c0.e(0);
        eVar.a(flowKt__EmittersKt$unsafeTransform$1$1, cVar);
        c0.e(1);
        return z1.f38230a;
    }
}
