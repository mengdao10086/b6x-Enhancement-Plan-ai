package kotlinx.coroutines.channels;

import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0}, l = {53}, m = "elementAtOrNull", n = {"$this$consume$iv", "index", uh.a.C}, s = {"L$0", "I$0", "I$1"})
public final class ChannelsKt__DeprecatedKt$elementAtOrNull$1<E> extends ContinuationImpl {
    public int I$0;
    public int I$1;
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;

    public ChannelsKt__DeprecatedKt$elementAtOrNull$1(kotlin.coroutines.c<? super ChannelsKt__DeprecatedKt$elementAtOrNull$1> cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelsKt__DeprecatedKt.m(null, 0, this);
    }
}
