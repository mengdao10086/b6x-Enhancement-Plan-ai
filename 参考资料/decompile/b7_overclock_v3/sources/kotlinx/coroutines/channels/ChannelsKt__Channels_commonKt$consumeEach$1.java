package kotlinx.coroutines.channels;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nChannels.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$consumeEach$1\n*L\n1#1,141:1\n*E\n"})
@zj.d(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", i = {0, 0}, l = {106}, m = "consumeEach", n = {"action", "$this$consume$iv"}, s = {"L$0", "L$1"})
public final class ChannelsKt__Channels_commonKt$consumeEach$1<E> extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public /* synthetic */ Object result;

    public ChannelsKt__Channels_commonKt$consumeEach$1(kotlin.coroutines.c<? super ChannelsKt__Channels_commonKt$consumeEach$1> cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelsKt__Channels_commonKt.e(null, null, this);
    }
}
