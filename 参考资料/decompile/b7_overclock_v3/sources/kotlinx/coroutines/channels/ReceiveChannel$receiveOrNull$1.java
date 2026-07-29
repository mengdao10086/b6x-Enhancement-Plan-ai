package kotlinx.coroutines.channels;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.channels.ReceiveChannel$DefaultImpls", f = "Channel.kt", i = {}, l = {372}, m = "receiveOrNull", n = {}, s = {})
public final class ReceiveChannel$receiveOrNull$1<E> extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;

    public ReceiveChannel$receiveOrNull$1(kotlin.coroutines.c<? super ReceiveChannel$receiveOrNull$1> cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ReceiveChannel.DefaultImpls.i(null, this);
    }
}
