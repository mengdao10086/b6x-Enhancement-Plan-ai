package kotlinx.coroutines.channels;

import com.flydigi.sdk.waspwing.WaspWingInfo;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.channels.BroadcastChannelImpl", f = "BroadcastChannel.kt", i = {0, 0}, l = {WaspWingInfo.EXPERIMENTAL_RUN_MODE_COLD_LEVEL}, m = "send", n = {"this", "element"}, s = {"L$0", "L$1"})
public final class BroadcastChannelImpl$send$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ BroadcastChannelImpl<E> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BroadcastChannelImpl$send$1(BroadcastChannelImpl<E> broadcastChannelImpl, kotlin.coroutines.c<? super BroadcastChannelImpl$send$1> cVar) {
        super(cVar);
        this.this$0 = broadcastChannelImpl;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.c to kotlinx.coroutines.channels.BroadcastChannelImpl$send$1 for r1v1 'this'  kotlin.coroutines.c
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final java.lang.Object q0(@yt.k java.lang.Object r2) {
        /*
            r1 = this;
            r1.result = r2
            int r2 = r1.label
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 | r0
            r1.label = r2
            kotlinx.coroutines.channels.BroadcastChannelImpl<E> r2 = r1.this$0
            r0 = 0
            java.lang.Object r2 = r2.G(r0, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BroadcastChannelImpl$send$1.q0(java.lang.Object):java.lang.Object");
    }
}
