package kotlinx.coroutines.channels;

import kotlin.collections.h0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {370, 371}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "I$0"})
public final class ChannelsKt__DeprecatedKt$withIndex$1 extends SuspendLambda implements ik.p<q<? super h0<Object>>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ ReceiveChannel<Object> $this_withIndex;
    public int I$0;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$withIndex$1(ReceiveChannel<Object> receiveChannel, kotlin.coroutines.c<? super ChannelsKt__DeprecatedKt$withIndex$1> cVar) {
        super(2, cVar);
        this.$this_withIndex = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        ChannelsKt__DeprecatedKt$withIndex$1 channelsKt__DeprecatedKt$withIndex$1 = new ChannelsKt__DeprecatedKt$withIndex$1(this.$this_withIndex, cVar);
        channelsKt__DeprecatedKt$withIndex$1.L$0 = obj;
        return channelsKt__DeprecatedKt$withIndex$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0051 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0078 -> B:12:0x0043). Please report as a decompilation issue!!! */
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
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L34
            if (r1 == r3) goto L25
            if (r1 != r2) goto L1d
            int r1 = r10.I$0
            java.lang.Object r4 = r10.L$1
            kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
            java.lang.Object r5 = r10.L$0
            kotlinx.coroutines.channels.q r5 = (kotlinx.coroutines.channels.q) r5
            kotlin.u0.n(r11)
            r11 = r5
            goto L42
        L1d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L25:
            int r1 = r10.I$0
            java.lang.Object r4 = r10.L$1
            kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
            java.lang.Object r5 = r10.L$0
            kotlinx.coroutines.channels.q r5 = (kotlinx.coroutines.channels.q) r5
            kotlin.u0.n(r11)
            r6 = r10
            goto L56
        L34:
            kotlin.u0.n(r11)
            java.lang.Object r11 = r10.L$0
            kotlinx.coroutines.channels.q r11 = (kotlinx.coroutines.channels.q) r11
            r1 = 0
            kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> r4 = r10.$this_withIndex
            kotlinx.coroutines.channels.ChannelIterator r4 = r4.iterator()
        L42:
            r5 = r10
        L43:
            r5.L$0 = r11
            r5.L$1 = r4
            r5.I$0 = r1
            r5.label = r3
            java.lang.Object r6 = r4.a(r5)
            if (r6 != r0) goto L52
            return r0
        L52:
            r9 = r5
            r5 = r11
            r11 = r6
            r6 = r9
        L56:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L7c
            java.lang.Object r11 = r4.next()
            kotlin.collections.h0 r7 = new kotlin.collections.h0
            int r8 = r1 + 1
            r7.<init>(r1, r11)
            r6.L$0 = r5
            r6.L$1 = r4
            r6.I$0 = r8
            r6.label = r2
            java.lang.Object r11 = r5.G(r7, r6)
            if (r11 != r0) goto L78
            return r0
        L78:
            r11 = r5
            r5 = r6
            r1 = r8
            goto L43
        L7c:
            kotlin.z1 r11 = kotlin.z1.f38230a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k q<? super h0<Object>> qVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((ChannelsKt__DeprecatedKt$withIndex$1) M(qVar, cVar)).q0(z1.f38230a);
    }
}
