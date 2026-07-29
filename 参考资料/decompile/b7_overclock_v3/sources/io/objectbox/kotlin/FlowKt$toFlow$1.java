package io.objectbox.kotlin;

import ik.p;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.l;
import kotlinx.coroutines.channels.q;
import pi.m;
import yt.k;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "io.objectbox.kotlin.FlowKt$toFlow$1", f = "Flow.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
@d0(bv = {}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@"}, d2 = {i1.a.f31577d5, "Lkotlinx/coroutines/channels/q;", "Lkotlin/z1;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class FlowKt$toFlow$1<T> extends SuspendLambda implements p<q<? super T>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ m<T> $this_toFlow;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt$toFlow$1(m<T> mVar, kotlin.coroutines.c<? super FlowKt$toFlow$1> cVar) {
        super(2, cVar);
        this.$this_toFlow = mVar;
    }

    public static final void K0(q qVar, Object obj) {
        l.m0(qVar, obj);
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: F0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@k q<? super T> qVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((FlowKt$toFlow$1) M(qVar, cVar)).q0(z1.f38230a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @k kotlin.coroutines.c<?> cVar) {
        FlowKt$toFlow$1 flowKt$toFlow$1 = new FlowKt$toFlow$1(this.$this_toFlow, cVar);
        flowKt$toFlow$1.L$0 = obj;
        return flowKt$toFlow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@k Object obj) throws Throwable {
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            u0.n(obj);
            final q qVar = (q) this.L$0;
            final pi.d dVarF = this.$this_toFlow.f(new pi.a() { // from class: io.objectbox.kotlin.c
                @Override // pi.a
                public final void b(Object obj2) {
                    FlowKt$toFlow$1.K0(qVar, obj2);
                }
            });
            ik.a<z1> aVar = new ik.a<z1>() { // from class: io.objectbox.kotlin.FlowKt$toFlow$1.1
                {
                    super(0);
                }

                public final void b() {
                    dVarF.cancel();
                }

                @Override // ik.a
                public /* bridge */ /* synthetic */ z1 o() {
                    b();
                    return z1.f38230a;
                }
            };
            this.label = 1;
            if (ProduceKt.a(qVar, aVar, this) == objH) {
                return objH;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u0.n(obj);
        }
        return z1.f38230a;
    }
}
