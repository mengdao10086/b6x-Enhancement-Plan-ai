package kotlinx.coroutines.channels;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.z1;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.channels.BroadcastKt$broadcast$2", f = "Broadcast.kt", i = {0, 1}, l = {56, 57}, m = "invokeSuspend", n = {"$this$broadcast", "$this$broadcast"}, s = {"L$0", "L$0"})
public final class BroadcastKt$broadcast$2<E> extends SuspendLambda implements ik.p<q<? super E>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ ReceiveChannel<E> $channel;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BroadcastKt$broadcast$2(ReceiveChannel<? extends E> receiveChannel, kotlin.coroutines.c<? super BroadcastKt$broadcast$2> cVar) {
        super(2, cVar);
        this.$channel = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        BroadcastKt$broadcast$2 broadcastKt$broadcast$2 = new BroadcastKt$broadcast$2(this.$channel, cVar);
        broadcastKt$broadcast$2.L$0 = obj;
        return broadcastKt$broadcast$2;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0068 -> B:12:0x003e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q0(@yt.k java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = yj.b.h()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L30
            if (r1 == r3) goto L23
            if (r1 != r2) goto L1b
            java.lang.Object r1 = r7.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r7.L$0
            kotlinx.coroutines.channels.q r4 = (kotlinx.coroutines.channels.q) r4
            kotlin.u0.n(r8)
            r8 = r4
            goto L3d
        L1b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L23:
            java.lang.Object r1 = r7.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r7.L$0
            kotlinx.coroutines.channels.q r4 = (kotlinx.coroutines.channels.q) r4
            kotlin.u0.n(r8)
            r5 = r7
            goto L4f
        L30:
            kotlin.u0.n(r8)
            java.lang.Object r8 = r7.L$0
            kotlinx.coroutines.channels.q r8 = (kotlinx.coroutines.channels.q) r8
            kotlinx.coroutines.channels.ReceiveChannel<E> r1 = r7.$channel
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
        L3d:
            r4 = r7
        L3e:
            r4.L$0 = r8
            r4.L$1 = r1
            r4.label = r3
            java.lang.Object r5 = r1.a(r4)
            if (r5 != r0) goto L4b
            return r0
        L4b:
            r6 = r4
            r4 = r8
            r8 = r5
            r5 = r6
        L4f:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L6b
            java.lang.Object r8 = r1.next()
            r5.L$0 = r4
            r5.L$1 = r1
            r5.label = r2
            java.lang.Object r8 = r4.G(r8, r5)
            if (r8 != r0) goto L68
            return r0
        L68:
            r8 = r4
            r4 = r5
            goto L3e
        L6b:
            kotlin.z1 r8 = kotlin.z1.f38230a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BroadcastKt$broadcast$2.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k q<? super E> qVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((BroadcastKt$broadcast$2) M(qVar, cVar)).q0(z1.f38230a);
    }
}
