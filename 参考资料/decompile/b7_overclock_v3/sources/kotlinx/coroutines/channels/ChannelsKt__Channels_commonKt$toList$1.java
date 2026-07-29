package kotlinx.coroutines.channels;

import com.flydigi.sdk.waspwing.WaspWingInfo;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", i = {0, 0}, l = {WaspWingInfo.COLD_LEVEL_STANDARD_B7}, m = "toList", n = {"$this$toList_u24lambda_u243", "$this$consume$iv$iv"}, s = {"L$1", "L$2"})
public final class ChannelsKt__Channels_commonKt$toList$1<E> extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;
    public /* synthetic */ Object result;

    public ChannelsKt__Channels_commonKt$toList$1(kotlin.coroutines.c<? super ChannelsKt__Channels_commonKt$toList$1> cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return l.g0(null, this);
    }
}
