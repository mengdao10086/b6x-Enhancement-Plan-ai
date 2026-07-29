package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.t0;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.j;
import kotlinx.coroutines.flow.internal.ChildCancelledException;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$1\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,405:1\n514#2,6:406\n530#2,4:412\n534#2:417\n1#3:416\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$1\n*L\n287#1:406,6\n288#1:412,4\n288#1:417\n*E\n"})
@zj.d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$1", f = "Delay.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__DelayKt$sample$2$1$1 extends SuspendLambda implements ik.p<kotlinx.coroutines.channels.j<? extends Object>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ Ref.ObjectRef<Object> $lastValue;
    public final /* synthetic */ ReceiveChannel<z1> $ticker;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$sample$2$1$1(Ref.ObjectRef<Object> objectRef, ReceiveChannel<z1> receiveChannel, kotlin.coroutines.c<? super FlowKt__DelayKt$sample$2$1$1> cVar) {
        super(2, cVar);
        this.$lastValue = objectRef;
        this.$ticker = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        FlowKt__DelayKt$sample$2$1$1 flowKt__DelayKt$sample$2$1$1 = new FlowKt__DelayKt$sample$2$1$1(this.$lastValue, this.$ticker, cVar);
        flowKt__DelayKt$sample$2$1$1.L$0 = obj;
        return flowKt__DelayKt$sample$2$1$1;
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v8, types: [T, kotlinx.coroutines.internal.o0] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        yj.b.h();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        u0.n(obj);
        ?? O = ((kotlinx.coroutines.channels.j) this.L$0).o();
        Ref.ObjectRef<Object> objectRef = this.$lastValue;
        boolean z10 = O instanceof j.c;
        if (!z10) {
            objectRef.element = O;
        }
        ReceiveChannel<z1> receiveChannel = this.$ticker;
        if (z10) {
            Throwable thF = kotlinx.coroutines.channels.j.f(O);
            if (thF != null) {
                throw thF;
            }
            receiveChannel.h(new ChildCancelledException());
            objectRef.element = kotlinx.coroutines.flow.internal.l.f38721c;
        }
        return z1.f38230a;
    }

    @Override // ik.p
    public /* bridge */ /* synthetic */ Object r0(kotlinx.coroutines.channels.j<? extends Object> jVar, kotlin.coroutines.c<? super z1> cVar) {
        return x0(jVar.o(), cVar);
    }

    @yt.l
    public final Object x0(@yt.k Object obj, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((FlowKt__DelayKt$sample$2$1$1) M(kotlinx.coroutines.channels.j.b(obj), cVar)).q0(z1.f38230a);
    }
}
