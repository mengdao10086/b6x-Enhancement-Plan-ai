package kotlinx.coroutines.channels;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.u0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$requireNoNulls$1", f = "Deprecated.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChannelsKt__DeprecatedKt$requireNoNulls$1 extends SuspendLambda implements ik.p<Object, kotlin.coroutines.c<Object>, Object> {
    public final /* synthetic */ ReceiveChannel<Object> $this_requireNoNulls;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$requireNoNulls$1(ReceiveChannel<Object> receiveChannel, kotlin.coroutines.c<? super ChannelsKt__DeprecatedKt$requireNoNulls$1> cVar) {
        super(2, cVar);
        this.$this_requireNoNulls = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        ChannelsKt__DeprecatedKt$requireNoNulls$1 channelsKt__DeprecatedKt$requireNoNulls$1 = new ChannelsKt__DeprecatedKt$requireNoNulls$1(this.$this_requireNoNulls, cVar);
        channelsKt__DeprecatedKt$requireNoNulls$1.L$0 = obj;
        return channelsKt__DeprecatedKt$requireNoNulls$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        yj.b.h();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        u0.n(obj);
        Object obj2 = this.L$0;
        if (obj2 != null) {
            return obj2;
        }
        throw new IllegalArgumentException("null element found in " + this.$this_requireNoNulls + '.');
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.l Object obj, @yt.l kotlin.coroutines.c<Object> cVar) {
        return ((ChannelsKt__DeprecatedKt$requireNoNulls$1) M(obj, cVar)).q0(z1.f38230a);
    }
}
