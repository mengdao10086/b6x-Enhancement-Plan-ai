package kotlinx.coroutines.channels;

import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.channels.TickerChannelsKt", f = "TickerChannels.kt", i = {0, 0, 1, 1, 2, 2}, l = {106, 108, 109}, m = "fixedDelayTicker", n = {"channel", "delayMillis", "channel", "delayMillis", "channel", "delayMillis"}, s = {"L$0", "J$0", "L$0", "J$0", "L$0", "J$0"})
public final class TickerChannelsKt$fixedDelayTicker$1 extends ContinuationImpl {
    public long J$0;
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public TickerChannelsKt$fixedDelayTicker$1(kotlin.coroutines.c<? super TickerChannelsKt$fixedDelayTicker$1> cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TickerChannelsKt.c(0L, 0L, null, this);
    }
}
