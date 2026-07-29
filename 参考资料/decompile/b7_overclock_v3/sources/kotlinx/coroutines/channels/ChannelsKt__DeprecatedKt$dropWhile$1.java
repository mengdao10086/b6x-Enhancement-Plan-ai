package kotlinx.coroutines.channels;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2, 3, 4}, l = {181, 182, 183, mb.e.f41031i2, 188}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0", "L$0", "L$0"})
public final class ChannelsKt__DeprecatedKt$dropWhile$1 extends SuspendLambda implements ik.p<q<Object>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ ik.p<Object, kotlin.coroutines.c<? super Boolean>, Object> $predicate;
    public final /* synthetic */ ReceiveChannel<Object> $this_dropWhile;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$dropWhile$1(ReceiveChannel<Object> receiveChannel, ik.p<Object, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar, kotlin.coroutines.c<? super ChannelsKt__DeprecatedKt$dropWhile$1> cVar) {
        super(2, cVar);
        this.$this_dropWhile = receiveChannel;
        this.$predicate = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        ChannelsKt__DeprecatedKt$dropWhile$1 channelsKt__DeprecatedKt$dropWhile$1 = new ChannelsKt__DeprecatedKt$dropWhile$1(this.$this_dropWhile, this.$predicate, cVar);
        channelsKt__DeprecatedKt$dropWhile$1.L$0 = obj;
        return channelsKt__DeprecatedKt$dropWhile$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x008d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0104  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00b1 -> B:27:0x00b5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0102 -> B:35:0x00d9). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q0(@yt.k java.lang.Object r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k q<Object> qVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((ChannelsKt__DeprecatedKt$dropWhile$1) M(qVar, cVar)).q0(z1.f38230a);
    }
}
