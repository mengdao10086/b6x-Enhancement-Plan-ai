package kotlinx.coroutines.channels;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {hr.a.f31427a, 212, 212}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "e", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "L$2", "I$0", "L$0", "I$0"})
public final class ChannelsKt__DeprecatedKt$filterIndexed$1 extends SuspendLambda implements ik.p<q<Object>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ ik.q<Integer, Object, kotlin.coroutines.c<? super Boolean>, Object> $predicate;
    public final /* synthetic */ ReceiveChannel<Object> $this_filterIndexed;
    public int I$0;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$filterIndexed$1(ReceiveChannel<Object> receiveChannel, ik.q<? super Integer, Object, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> qVar, kotlin.coroutines.c<? super ChannelsKt__DeprecatedKt$filterIndexed$1> cVar) {
        super(2, cVar);
        this.$this_filterIndexed = receiveChannel;
        this.$predicate = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        ChannelsKt__DeprecatedKt$filterIndexed$1 channelsKt__DeprecatedKt$filterIndexed$1 = new ChannelsKt__DeprecatedKt$filterIndexed$1(this.$this_filterIndexed, this.$predicate, cVar);
        channelsKt__DeprecatedKt$filterIndexed$1.L$0 = obj;
        return channelsKt__DeprecatedKt$filterIndexed$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0062, code lost:
    
        r13 = r0;
        r0 = r1;
        r7 = r8;
        r1 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0072 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c1  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q0(@yt.k java.lang.Object r13) throws java.lang.Throwable {
        /*
            r12 = this;
            java.lang.Object r0 = yj.b.h()
            int r1 = r12.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L52
            if (r1 == r5) goto L3f
            if (r1 == r4) goto L28
            if (r1 != r3) goto L20
            int r1 = r12.I$0
            java.lang.Object r6 = r12.L$1
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r12.L$0
            kotlinx.coroutines.channels.q r7 = (kotlinx.coroutines.channels.q) r7
            kotlin.u0.n(r13)
            goto L61
        L20:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L28:
            int r1 = r12.I$0
            java.lang.Object r6 = r12.L$2
            java.lang.Object r7 = r12.L$1
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r8 = r12.L$0
            kotlinx.coroutines.channels.q r8 = (kotlinx.coroutines.channels.q) r8
            kotlin.u0.n(r13)
            r10 = r1
            r1 = r0
            r0 = r12
            r11 = r7
            r7 = r6
        L3c:
            r6 = r11
            goto La3
        L3f:
            int r1 = r12.I$0
            java.lang.Object r6 = r12.L$1
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r12.L$0
            kotlinx.coroutines.channels.q r7 = (kotlinx.coroutines.channels.q) r7
            kotlin.u0.n(r13)
            r8 = r7
            r7 = r6
            r6 = r1
            r1 = r0
            r0 = r12
            goto L7a
        L52:
            kotlin.u0.n(r13)
            java.lang.Object r13 = r12.L$0
            kotlinx.coroutines.channels.q r13 = (kotlinx.coroutines.channels.q) r13
            r1 = 0
            kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> r6 = r12.$this_filterIndexed
            kotlinx.coroutines.channels.ChannelIterator r6 = r6.iterator()
            r7 = r13
        L61:
            r13 = r12
        L62:
            r13.L$0 = r7
            r13.L$1 = r6
            r13.L$2 = r2
            r13.I$0 = r1
            r13.label = r5
            java.lang.Object r8 = r6.a(r13)
            if (r8 != r0) goto L73
            return r0
        L73:
            r11 = r0
            r0 = r13
            r13 = r8
            r8 = r7
            r7 = r6
            r6 = r1
            r1 = r11
        L7a:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto Lc1
            java.lang.Object r13 = r7.next()
            ik.q<java.lang.Integer, java.lang.Object, kotlin.coroutines.c<? super java.lang.Boolean>, java.lang.Object> r9 = r0.$predicate
            int r10 = r6 + 1
            java.lang.Integer r6 = zj.a.f(r6)
            r0.L$0 = r8
            r0.L$1 = r7
            r0.L$2 = r13
            r0.I$0 = r10
            r0.label = r4
            java.lang.Object r6 = r9.A(r6, r13, r0)
            if (r6 != r1) goto L9f
            return r1
        L9f:
            r11 = r7
            r7 = r13
            r13 = r6
            goto L3c
        La3:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto Lbc
            r0.L$0 = r8
            r0.L$1 = r6
            r0.L$2 = r2
            r0.I$0 = r10
            r0.label = r3
            java.lang.Object r13 = r8.G(r7, r0)
            if (r13 != r1) goto Lbc
            return r1
        Lbc:
            r13 = r0
            r0 = r1
            r7 = r8
            r1 = r10
            goto L62
        Lc1:
            kotlin.z1 r13 = kotlin.z1.f38230a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k q<Object> qVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((ChannelsKt__DeprecatedKt$filterIndexed$1) M(qVar, cVar)).q0(z1.f38230a);
    }
}
