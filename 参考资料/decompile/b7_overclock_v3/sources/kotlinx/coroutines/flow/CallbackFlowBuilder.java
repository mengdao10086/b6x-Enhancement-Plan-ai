package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.z1;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlow;

/* JADX INFO: loaded from: classes5.dex */
public final class CallbackFlowBuilder<T> extends c<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final ik.p<kotlinx.coroutines.channels.q<? super T>, kotlin.coroutines.c<? super z1>, Object> f38479e;

    public /* synthetic */ CallbackFlowBuilder(ik.p pVar, CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow, int i11, kotlin.jvm.internal.u uVar) {
        this(pVar, (i11 & 2) != 0 ? EmptyCoroutineContext.f37755a : coroutineContext, (i11 & 4) != 0 ? -2 : i10, (i11 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.c, kotlinx.coroutines.flow.internal.ChannelFlow
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object g(@yt.k kotlinx.coroutines.channels.q<? super T> r5, @yt.k kotlin.coroutines.c<? super kotlin.z1> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1 r0 = (kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1 r0 = new kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.channels.q r5 = (kotlinx.coroutines.channels.q) r5
            kotlin.u0.n(r6)
            goto L43
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.u0.n(r6)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = super.g(r5, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            boolean r5 = r5.H()
            if (r5 == 0) goto L4c
            kotlin.z1 r5 = kotlin.z1.f38230a
            return r5
        L4c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.CallbackFlowBuilder.g(kotlinx.coroutines.channels.q, kotlin.coroutines.c):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.c, kotlinx.coroutines.flow.internal.ChannelFlow
    @yt.k
    public ChannelFlow<T> h(@yt.k CoroutineContext coroutineContext, int i10, @yt.k BufferOverflow bufferOverflow) {
        return new CallbackFlowBuilder(this.f38479e, coroutineContext, i10, bufferOverflow);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CallbackFlowBuilder(@yt.k ik.p<? super kotlinx.coroutines.channels.q<? super T>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar, @yt.k CoroutineContext coroutineContext, int i10, @yt.k BufferOverflow bufferOverflow) {
        super(pVar, coroutineContext, i10, bufferOverflow);
        this.f38479e = pVar;
    }
}
