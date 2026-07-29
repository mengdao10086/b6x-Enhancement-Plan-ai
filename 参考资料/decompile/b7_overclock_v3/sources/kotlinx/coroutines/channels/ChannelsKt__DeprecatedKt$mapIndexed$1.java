package kotlinx.coroutines.channels;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.z1;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {344, 345, 345}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
public final class ChannelsKt__DeprecatedKt$mapIndexed$1<R> extends SuspendLambda implements ik.p<q<? super R>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ ReceiveChannel<E> $this_mapIndexed;
    public final /* synthetic */ ik.q<Integer, E, kotlin.coroutines.c<? super R>, Object> $transform;
    public int I$0;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$mapIndexed$1(ReceiveChannel<? extends E> receiveChannel, ik.q<? super Integer, ? super E, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar, kotlin.coroutines.c<? super ChannelsKt__DeprecatedKt$mapIndexed$1> cVar) {
        super(2, cVar);
        this.$this_mapIndexed = receiveChannel;
        this.$transform = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        ChannelsKt__DeprecatedKt$mapIndexed$1 channelsKt__DeprecatedKt$mapIndexed$1 = new ChannelsKt__DeprecatedKt$mapIndexed$1(this.$this_mapIndexed, this.$transform, cVar);
        channelsKt__DeprecatedKt$mapIndexed$1.L$0 = obj;
        return channelsKt__DeprecatedKt$mapIndexed$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ac  */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00a8 -> B:14:0x0059). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q0(@yt.k java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = yj.b.h()
            int r1 = r11.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L4a
            if (r1 == r4) goto L3b
            if (r1 == r3) goto L28
            if (r1 != r2) goto L20
            int r1 = r11.I$0
            java.lang.Object r5 = r11.L$1
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r11.L$0
            kotlinx.coroutines.channels.q r6 = (kotlinx.coroutines.channels.q) r6
            kotlin.u0.n(r12)
            r12 = r6
            goto L58
        L20:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L28:
            int r1 = r11.I$0
            java.lang.Object r5 = r11.L$2
            kotlinx.coroutines.channels.q r5 = (kotlinx.coroutines.channels.q) r5
            java.lang.Object r6 = r11.L$1
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r11.L$0
            kotlinx.coroutines.channels.q r7 = (kotlinx.coroutines.channels.q) r7
            kotlin.u0.n(r12)
            r8 = r11
            goto L96
        L3b:
            int r1 = r11.I$0
            java.lang.Object r5 = r11.L$1
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r11.L$0
            kotlinx.coroutines.channels.q r6 = (kotlinx.coroutines.channels.q) r6
            kotlin.u0.n(r12)
            r7 = r11
            goto L6c
        L4a:
            kotlin.u0.n(r12)
            java.lang.Object r12 = r11.L$0
            kotlinx.coroutines.channels.q r12 = (kotlinx.coroutines.channels.q) r12
            r1 = 0
            kotlinx.coroutines.channels.ReceiveChannel<E> r5 = r11.$this_mapIndexed
            kotlinx.coroutines.channels.ChannelIterator r5 = r5.iterator()
        L58:
            r6 = r11
        L59:
            r6.L$0 = r12
            r6.L$1 = r5
            r6.I$0 = r1
            r6.label = r4
            java.lang.Object r7 = r5.a(r6)
            if (r7 != r0) goto L68
            return r0
        L68:
            r10 = r6
            r6 = r12
            r12 = r7
            r7 = r10
        L6c:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto Lac
            java.lang.Object r12 = r5.next()
            ik.q<java.lang.Integer, E, kotlin.coroutines.c<? super R>, java.lang.Object> r8 = r7.$transform
            int r9 = r1 + 1
            java.lang.Integer r1 = zj.a.f(r1)
            r7.L$0 = r6
            r7.L$1 = r5
            r7.L$2 = r6
            r7.I$0 = r9
            r7.label = r3
            java.lang.Object r12 = r8.A(r1, r12, r7)
            if (r12 != r0) goto L91
            return r0
        L91:
            r8 = r7
            r1 = r9
            r7 = r6
            r6 = r5
            r5 = r7
        L96:
            r8.L$0 = r7
            r8.L$1 = r6
            r9 = 0
            r8.L$2 = r9
            r8.I$0 = r1
            r8.label = r2
            java.lang.Object r12 = r5.G(r12, r8)
            if (r12 != r0) goto La8
            return r0
        La8:
            r5 = r6
            r12 = r7
            r6 = r8
            goto L59
        Lac:
            kotlin.z1 r12 = kotlin.z1.f38230a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k q<? super R> qVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((ChannelsKt__DeprecatedKt$mapIndexed$1) M(qVar, cVar)).q0(z1.f38230a);
    }
}
