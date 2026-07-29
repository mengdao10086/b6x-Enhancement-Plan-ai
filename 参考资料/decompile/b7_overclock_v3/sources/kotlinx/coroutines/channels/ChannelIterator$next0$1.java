package kotlinx.coroutines.channels;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ChannelIterator;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.channels.ChannelIterator$DefaultImpls", f = "Channel.kt", i = {0}, l = {589}, m = "next", n = {"$this"}, s = {"L$0"})
public final class ChannelIterator$next0$1<E> extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public ChannelIterator$next0$1(kotlin.coroutines.c<? super ChannelIterator$next0$1> cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelIterator.DefaultImpls.a(null, this);
    }
}
