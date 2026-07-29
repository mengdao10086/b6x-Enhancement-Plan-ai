package kotlinx.coroutines.flow;

import androidx.lifecycle.r0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import kotlinx.coroutines.o0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1\n+ 2 WhileSelect.kt\nkotlinx/coroutines/selects/WhileSelectKt\n+ 3 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,405:1\n31#2:406\n32#2:415\n55#3,8:407\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1\n*L\n391#1:406\n391#1:415\n391#1:407,8\n*E\n"})
@zj.d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1", f = "Delay.kt", i = {0, 0}, l = {414}, m = "invokeSuspend", n = {"downStream", r0.f6236g}, s = {"L$0", "L$1"})
public final class FlowKt__DelayKt$timeoutInternal$1<T> extends SuspendLambda implements ik.q<o0, f<? super T>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ e<T> $this_timeoutInternal;
    public final /* synthetic */ long $timeout;
    public long J$0;
    private /* synthetic */ Object L$0;
    public /* synthetic */ Object L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$timeoutInternal$1(long j10, e<? extends T> eVar, kotlin.coroutines.c<? super FlowKt__DelayKt$timeoutInternal$1> cVar) {
        super(3, cVar);
        this.$timeout = j10;
        this.$this_timeoutInternal = eVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x007c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x007d -> B:15:0x0084). Please report as a decompilation issue!!! */
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
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L27
            if (r1 != r2) goto L1f
            long r4 = r11.J$0
            java.lang.Object r1 = r11.L$1
            kotlinx.coroutines.channels.ReceiveChannel r1 = (kotlinx.coroutines.channels.ReceiveChannel) r1
            java.lang.Object r6 = r11.L$0
            kotlinx.coroutines.flow.f r6 = (kotlinx.coroutines.flow.f) r6
            kotlin.u0.n(r12)
            r7 = r6
            r5 = r4
            r4 = r1
            r1 = r0
            r0 = r11
            goto L84
        L1f:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L27:
            kotlin.u0.n(r12)
            java.lang.Object r12 = r11.L$0
            kotlinx.coroutines.o0 r12 = (kotlinx.coroutines.o0) r12
            java.lang.Object r1 = r11.L$1
            kotlinx.coroutines.flow.f r1 = (kotlinx.coroutines.flow.f) r1
            long r4 = r11.$timeout
            uk.e$a r6 = uk.e.f52169b
            long r6 = r6.W()
            int r4 = uk.e.j(r4, r6)
            if (r4 <= 0) goto L95
            kotlinx.coroutines.flow.e<T> r4 = r11.$this_timeoutInternal
            r5 = 0
            r6 = 2
            kotlinx.coroutines.flow.e r4 = kotlinx.coroutines.flow.g.q(r4, r5, r3, r6, r3)
            kotlinx.coroutines.channels.ReceiveChannel r12 = kotlinx.coroutines.flow.g.o1(r4, r12)
            long r4 = r11.$timeout
            r6 = r1
            r1 = r12
            r12 = r11
        L51:
            kotlinx.coroutines.selects.SelectImplementation r7 = new kotlinx.coroutines.selects.SelectImplementation
            kotlin.coroutines.CoroutineContext r8 = r12.b()
            r7.<init>(r8)
            kotlinx.coroutines.selects.e r8 = r1.o()
            kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1 r9 = new kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1
            r9.<init>(r6, r3)
            r7.p(r8, r9)
            kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$2 r8 = new kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$2
            r8.<init>(r4, r3)
            kotlinx.coroutines.selects.a.b(r7, r4, r8)
            r12.L$0 = r6
            r12.L$1 = r1
            r12.J$0 = r4
            r12.label = r2
            java.lang.Object r7 = r7.R(r12)
            if (r7 != r0) goto L7d
            return r0
        L7d:
            r10 = r0
            r0 = r12
            r12 = r7
            r7 = r6
            r5 = r4
            r4 = r1
            r1 = r10
        L84:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 != 0) goto L8f
            kotlin.z1 r12 = kotlin.z1.f38230a
            return r12
        L8f:
            r12 = r0
            r0 = r1
            r1 = r4
            r4 = r5
            r6 = r7
            goto L51
        L95:
            kotlinx.coroutines.TimeoutCancellationException r12 = new kotlinx.coroutines.TimeoutCancellationException
            java.lang.String r0 = "Timed out immediately"
            r12.<init>(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.q
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object A(@yt.k o0 o0Var, @yt.k f<? super T> fVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        FlowKt__DelayKt$timeoutInternal$1 flowKt__DelayKt$timeoutInternal$1 = new FlowKt__DelayKt$timeoutInternal$1(this.$timeout, this.$this_timeoutInternal, cVar);
        flowKt__DelayKt$timeoutInternal$1.L$0 = o0Var;
        flowKt__DelayKt$timeoutInternal$1.L$1 = fVar;
        return flowKt__DelayKt$timeoutInternal$1.q0(z1.f38230a);
    }
}
