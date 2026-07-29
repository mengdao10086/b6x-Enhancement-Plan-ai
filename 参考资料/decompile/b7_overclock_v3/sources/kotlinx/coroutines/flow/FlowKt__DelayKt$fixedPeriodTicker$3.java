package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.z1;
import w.w;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$fixedPeriodTicker$3", f = "Delay.kt", i = {0, 1, 2}, l = {313, 315, w.a.f53655q}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$0"})
public final class FlowKt__DelayKt$fixedPeriodTicker$3 extends SuspendLambda implements ik.p<kotlinx.coroutines.channels.q<? super z1>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ long $delayMillis;
    public final /* synthetic */ long $initialDelayMillis;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$fixedPeriodTicker$3(long j10, long j11, kotlin.coroutines.c<? super FlowKt__DelayKt$fixedPeriodTicker$3> cVar) {
        super(2, cVar);
        this.$initialDelayMillis = j10;
        this.$delayMillis = j11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        FlowKt__DelayKt$fixedPeriodTicker$3 flowKt__DelayKt$fixedPeriodTicker$3 = new FlowKt__DelayKt$fixedPeriodTicker$3(this.$initialDelayMillis, this.$delayMillis, cVar);
        flowKt__DelayKt$fixedPeriodTicker$3.L$0 = obj;
        return flowKt__DelayKt$fixedPeriodTicker$3;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0050 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005d A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005b -> B:15:0x0040). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q0(@yt.k java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = yj.b.h()
            int r1 = r7.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L2a
            if (r1 == r4) goto L11
            if (r1 == r3) goto L21
            if (r1 != r2) goto L19
        L11:
            java.lang.Object r1 = r7.L$0
            kotlinx.coroutines.channels.q r1 = (kotlinx.coroutines.channels.q) r1
            kotlin.u0.n(r8)
            goto L3f
        L19:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L21:
            java.lang.Object r1 = r7.L$0
            kotlinx.coroutines.channels.q r1 = (kotlinx.coroutines.channels.q) r1
            kotlin.u0.n(r8)
            r8 = r7
            goto L51
        L2a:
            kotlin.u0.n(r8)
            java.lang.Object r8 = r7.L$0
            r1 = r8
            kotlinx.coroutines.channels.q r1 = (kotlinx.coroutines.channels.q) r1
            long r5 = r7.$initialDelayMillis
            r7.L$0 = r1
            r7.label = r4
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.b(r5, r7)
            if (r8 != r0) goto L3f
            return r0
        L3f:
            r8 = r7
        L40:
            kotlinx.coroutines.channels.s r4 = r1.i()
            kotlin.z1 r5 = kotlin.z1.f38230a
            r8.L$0 = r1
            r8.label = r3
            java.lang.Object r4 = r4.G(r5, r8)
            if (r4 != r0) goto L51
            return r0
        L51:
            long r4 = r8.$delayMillis
            r8.L$0 = r1
            r8.label = r2
            java.lang.Object r4 = kotlinx.coroutines.DelayKt.b(r4, r8)
            if (r4 != r0) goto L40
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$fixedPeriodTicker$3.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k kotlinx.coroutines.channels.q<? super z1> qVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((FlowKt__DelayKt$fixedPeriodTicker$3) M(qVar, cVar)).q0(z1.f38230a);
    }
}
