package kotlinx.coroutines.channels;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$take$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,479:1\n1#2:480\n*E\n"})
@zj.d(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {254, 255}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "remaining"}, s = {"L$0", "I$0", "L$0", "I$0"})
public final class ChannelsKt__DeprecatedKt$take$1 extends SuspendLambda implements ik.p<q<Object>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ int $n;
    public final /* synthetic */ ReceiveChannel<Object> $this_take;
    public int I$0;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$take$1(int i10, ReceiveChannel<Object> receiveChannel, kotlin.coroutines.c<? super ChannelsKt__DeprecatedKt$take$1> cVar) {
        super(2, cVar);
        this.$n = i10;
        this.$this_take = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        ChannelsKt__DeprecatedKt$take$1 channelsKt__DeprecatedKt$take$1 = new ChannelsKt__DeprecatedKt$take$1(this.$n, this.$this_take, cVar);
        channelsKt__DeprecatedKt$take$1.L$0 = obj;
        return channelsKt__DeprecatedKt$take$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0060 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0089  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0080 -> B:29:0x0082). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q0(@yt.k java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = yj.b.h()
            int r1 = r8.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L36
            if (r1 == r3) goto L27
            if (r1 != r2) goto L1f
            int r1 = r8.I$0
            java.lang.Object r4 = r8.L$1
            kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
            java.lang.Object r5 = r8.L$0
            kotlinx.coroutines.channels.q r5 = (kotlinx.coroutines.channels.q) r5
            kotlin.u0.n(r9)
            r9 = r5
            r5 = r8
            goto L82
        L1f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L27:
            int r1 = r8.I$0
            java.lang.Object r4 = r8.L$1
            kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
            java.lang.Object r5 = r8.L$0
            kotlinx.coroutines.channels.q r5 = (kotlinx.coroutines.channels.q) r5
            kotlin.u0.n(r9)
            r6 = r8
            goto L65
        L36:
            kotlin.u0.n(r9)
            java.lang.Object r9 = r8.L$0
            kotlinx.coroutines.channels.q r9 = (kotlinx.coroutines.channels.q) r9
            int r1 = r8.$n
            if (r1 != 0) goto L44
            kotlin.z1 r9 = kotlin.z1.f38230a
            return r9
        L44:
            if (r1 < 0) goto L48
            r4 = 1
            goto L49
        L48:
            r4 = 0
        L49:
            if (r4 == 0) goto L8c
            kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> r4 = r8.$this_take
            kotlinx.coroutines.channels.ChannelIterator r4 = r4.iterator()
            r5 = r8
        L52:
            r5.L$0 = r9
            r5.L$1 = r4
            r5.I$0 = r1
            r5.label = r3
            java.lang.Object r6 = r4.a(r5)
            if (r6 != r0) goto L61
            return r0
        L61:
            r7 = r5
            r5 = r9
            r9 = r6
            r6 = r7
        L65:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L89
            java.lang.Object r9 = r4.next()
            r6.L$0 = r5
            r6.L$1 = r4
            r6.I$0 = r1
            r6.label = r2
            java.lang.Object r9 = r5.G(r9, r6)
            if (r9 != r0) goto L80
            return r0
        L80:
            r9 = r5
            r5 = r6
        L82:
            int r1 = r1 + (-1)
            if (r1 != 0) goto L52
            kotlin.z1 r9 = kotlin.z1.f38230a
            return r9
        L89:
            kotlin.z1 r9 = kotlin.z1.f38230a
            return r9
        L8c:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "Requested element count "
            r9.append(r0)
            r9.append(r1)
            java.lang.String r0 = " is less than zero."
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k q<Object> qVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((ChannelsKt__DeprecatedKt$take$1) M(qVar, cVar)).q0(z1.f38230a);
    }
}
