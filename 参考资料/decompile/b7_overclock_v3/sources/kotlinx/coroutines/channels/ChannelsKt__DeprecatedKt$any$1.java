package kotlinx.coroutines.channels;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import v7.a;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0}, l = {a.c.C}, m = "any", n = {"$this$consume$iv"}, s = {"L$0"})
public final class ChannelsKt__DeprecatedKt$any$1<E> extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public ChannelsKt__DeprecatedKt$any$1(kotlin.coroutines.c<? super ChannelsKt__DeprecatedKt$any$1> cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelsKt__DeprecatedKt.a(null, this);
    }
}
