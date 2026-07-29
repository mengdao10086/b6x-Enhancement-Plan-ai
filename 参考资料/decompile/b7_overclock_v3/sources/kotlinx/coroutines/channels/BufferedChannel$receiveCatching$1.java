package kotlinx.coroutines.channels;

import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.channels.BufferedChannel", f = "BufferedChannel.kt", i = {}, l = {739}, m = "receiveCatching-JP2dKIU$suspendImpl", n = {}, s = {})
public final class BufferedChannel$receiveCatching$1<E> extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ BufferedChannel<E> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BufferedChannel$receiveCatching$1(BufferedChannel<E> bufferedChannel, kotlin.coroutines.c<? super BufferedChannel$receiveCatching$1> cVar) {
        super(cVar);
        this.this$0 = bufferedChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objA1 = BufferedChannel.a1(this.this$0, this);
        return objA1 == yj.b.h() ? objA1 : j.b(objA1);
    }
}
