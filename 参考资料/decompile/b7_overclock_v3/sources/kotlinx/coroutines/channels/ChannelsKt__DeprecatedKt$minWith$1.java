package kotlinx.coroutines.channels;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import rb.k0;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {k0.f48142c, 436}, m = "minWith", n = {"comparator", "$this$consume$iv", "iterator", "comparator", "$this$consume$iv", "iterator", "min"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
public final class ChannelsKt__DeprecatedKt$minWith$1<E> extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;
    public /* synthetic */ Object result;

    public ChannelsKt__DeprecatedKt$minWith$1(kotlin.coroutines.c<? super ChannelsKt__DeprecatedKt$minWith$1> cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelsKt__DeprecatedKt.N(null, null, this);
    }
}
