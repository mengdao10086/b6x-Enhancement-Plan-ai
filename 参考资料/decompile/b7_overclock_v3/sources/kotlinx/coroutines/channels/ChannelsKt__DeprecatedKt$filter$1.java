package kotlinx.coroutines.channels;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.z1;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {198, 199, 199}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
public final class ChannelsKt__DeprecatedKt$filter$1<E> extends SuspendLambda implements ik.p<q<? super E>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ ik.p<E, kotlin.coroutines.c<? super Boolean>, Object> $predicate;
    public final /* synthetic */ ReceiveChannel<E> $this_filter;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$filter$1(ReceiveChannel<? extends E> receiveChannel, ik.p<? super E, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar, kotlin.coroutines.c<? super ChannelsKt__DeprecatedKt$filter$1> cVar) {
        super(2, cVar);
        this.$this_filter = receiveChannel;
        this.$predicate = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        ChannelsKt__DeprecatedKt$filter$1 channelsKt__DeprecatedKt$filter$1 = new ChannelsKt__DeprecatedKt$filter$1(this.$this_filter, this.$predicate, cVar);
        channelsKt__DeprecatedKt$filter$1.L$0 = obj;
        return channelsKt__DeprecatedKt$filter$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0057, code lost:
    
        r11 = r0;
        r0 = r1;
        r1 = r6;
        r6 = r8;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0065 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a9  */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Object, kotlinx.coroutines.channels.s] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r9v0 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q0(@yt.k java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = yj.b.h()
            int r1 = r10.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L48
            if (r1 == r5) goto L38
            if (r1 == r4) goto L26
            if (r1 != r3) goto L1e
            java.lang.Object r1 = r10.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r10.L$0
            kotlinx.coroutines.channels.q r6 = (kotlinx.coroutines.channels.q) r6
            kotlin.u0.n(r11)
            goto L56
        L1e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L26:
            java.lang.Object r1 = r10.L$2
            java.lang.Object r6 = r10.L$1
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r10.L$0
            kotlinx.coroutines.channels.q r7 = (kotlinx.coroutines.channels.q) r7
            kotlin.u0.n(r11)
            r8 = r7
            r7 = r1
            r1 = r0
            r0 = r10
            goto L8d
        L38:
            java.lang.Object r1 = r10.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r10.L$0
            kotlinx.coroutines.channels.q r6 = (kotlinx.coroutines.channels.q) r6
            kotlin.u0.n(r11)
            r7 = r6
            r6 = r1
            r1 = r0
            r0 = r10
            goto L6c
        L48:
            kotlin.u0.n(r11)
            java.lang.Object r11 = r10.L$0
            kotlinx.coroutines.channels.q r11 = (kotlinx.coroutines.channels.q) r11
            kotlinx.coroutines.channels.ReceiveChannel<E> r1 = r10.$this_filter
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r6 = r11
        L56:
            r11 = r10
        L57:
            r11.L$0 = r6
            r11.L$1 = r1
            r11.L$2 = r2
            r11.label = r5
            java.lang.Object r7 = r1.a(r11)
            if (r7 != r0) goto L66
            return r0
        L66:
            r9 = r0
            r0 = r11
            r11 = r7
            r7 = r6
            r6 = r1
            r1 = r9
        L6c:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto La9
            java.lang.Object r11 = r6.next()
            ik.p<E, kotlin.coroutines.c<? super java.lang.Boolean>, java.lang.Object> r8 = r0.$predicate
            r0.L$0 = r7
            r0.L$1 = r6
            r0.L$2 = r11
            r0.label = r4
            java.lang.Object r8 = r8.r0(r11, r0)
            if (r8 != r1) goto L89
            return r1
        L89:
            r9 = r7
            r7 = r11
            r11 = r8
            r8 = r9
        L8d:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto La4
            r0.L$0 = r8
            r0.L$1 = r6
            r0.L$2 = r2
            r0.label = r3
            java.lang.Object r11 = r8.G(r7, r0)
            if (r11 != r1) goto La4
            return r1
        La4:
            r11 = r0
            r0 = r1
            r1 = r6
            r6 = r8
            goto L57
        La9:
            kotlin.z1 r11 = kotlin.z1.f38230a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k q<? super E> qVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((ChannelsKt__DeprecatedKt$filter$1) M(qVar, cVar)).q0(z1.f38230a);
    }
}
