package kotlinx.coroutines.flow;

import androidx.lifecycle.r0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.t0;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.selects.SelectImplementation;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2\n+ 2 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,405:1\n55#2,8:406\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2\n*L\n284#1:406,8\n*E\n"})
@zj.d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", f = "Delay.kt", i = {0, 0, 0, 0}, l = {413}, m = "invokeSuspend", n = {"downstream", r0.f6236g, "lastValue", "ticker"}, s = {"L$0", "L$1", "L$2", "L$3"})
public final class FlowKt__DelayKt$sample$2<T> extends SuspendLambda implements ik.q<o0, f<? super T>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ long $periodMillis;
    public final /* synthetic */ e<T> $this_sample;
    private /* synthetic */ Object L$0;
    public /* synthetic */ Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$sample$2(long j10, e<? extends T> eVar, kotlin.coroutines.c<? super FlowKt__DelayKt$sample$2> cVar) {
        super(3, cVar);
        this.$periodMillis = j10;
        this.$this_sample = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        f fVar;
        ReceiveChannel receiveChannel;
        Ref.ObjectRef objectRef;
        ReceiveChannel receiveChannelG;
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            u0.n(obj);
            o0 o0Var = (o0) this.L$0;
            f fVar2 = (f) this.L$1;
            ReceiveChannel receiveChannelF = ProduceKt.f(o0Var, null, -1, new FlowKt__DelayKt$sample$2$values$1(this.$this_sample, null), 1, null);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            fVar = fVar2;
            receiveChannel = receiveChannelF;
            objectRef = objectRef2;
            receiveChannelG = FlowKt__DelayKt.g(o0Var, this.$periodMillis, 0L, 2, null);
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            receiveChannelG = (ReceiveChannel) this.L$3;
            objectRef = (Ref.ObjectRef) this.L$2;
            receiveChannel = (ReceiveChannel) this.L$1;
            fVar = (f) this.L$0;
            u0.n(obj);
        }
        while (objectRef.element != kotlinx.coroutines.flow.internal.l.f38721c) {
            SelectImplementation selectImplementation = new SelectImplementation(b());
            selectImplementation.p(receiveChannel.o(), new FlowKt__DelayKt$sample$2$1$1(objectRef, receiveChannelG, null));
            selectImplementation.p(receiveChannelG.j(), new FlowKt__DelayKt$sample$2$1$2(objectRef, fVar, null));
            this.L$0 = fVar;
            this.L$1 = receiveChannel;
            this.L$2 = objectRef;
            this.L$3 = receiveChannelG;
            this.label = 1;
            if (selectImplementation.R(this) == objH) {
                return objH;
            }
        }
        return z1.f38230a;
    }

    @Override // ik.q
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object A(@yt.k o0 o0Var, @yt.k f<? super T> fVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        FlowKt__DelayKt$sample$2 flowKt__DelayKt$sample$2 = new FlowKt__DelayKt$sample$2(this.$periodMillis, this.$this_sample, cVar);
        flowKt__DelayKt$sample$2.L$0 = o0Var;
        flowKt__DelayKt$sample$2.L$1 = fVar;
        return flowKt__DelayKt$sample$2.q0(z1.f38230a);
    }
}
