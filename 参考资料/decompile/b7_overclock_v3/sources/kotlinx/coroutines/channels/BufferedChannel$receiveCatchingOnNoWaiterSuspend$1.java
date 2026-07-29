package kotlinx.coroutines.channels;

import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.channels.BufferedChannel", f = "BufferedChannel.kt", i = {0, 0, 0, 0}, l = {3056}, m = "receiveCatchingOnNoWaiterSuspend-GKJJFZk", n = {"this", "segment", "index", SsManifestParser.e.J}, s = {"L$0", "L$1", "I$0", "J$0"})
public final class BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 extends ContinuationImpl {
    public int I$0;
    public long J$0;
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ BufferedChannel<E> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(BufferedChannel<E> bufferedChannel, kotlin.coroutines.c<? super BufferedChannel$receiveCatchingOnNoWaiterSuspend$1> cVar) {
        super(cVar);
        this.this$0 = bufferedChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objB1 = this.this$0.b1(null, 0, 0L, this);
        return objB1 == yj.b.h() ? objB1 : j.b(objB1);
    }
}
