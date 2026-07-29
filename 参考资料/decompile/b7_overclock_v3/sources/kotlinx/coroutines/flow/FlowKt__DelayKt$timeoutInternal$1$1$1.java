package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1$1$1\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n*L\n1#1,405:1\n514#2,6:406\n548#2,5:412\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1$1$1\n*L\n393#1:406,6\n395#1:412,5\n*E\n"})
@zj.d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1", f = "Delay.kt", i = {0}, l = {gg.b.A}, m = "invokeSuspend", n = {"$this$onSuccess_u2dWpGqRn0$iv"}, s = {"L$0"})
public final class FlowKt__DelayKt$timeoutInternal$1$1$1<T> extends SuspendLambda implements ik.p<kotlinx.coroutines.channels.j<? extends T>, kotlin.coroutines.c<? super Boolean>, Object> {
    public final /* synthetic */ f<T> $downStream;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$timeoutInternal$1$1$1(f<? super T> fVar, kotlin.coroutines.c<? super FlowKt__DelayKt$timeoutInternal$1$1$1> cVar) {
        super(2, cVar);
        this.$downStream = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        FlowKt__DelayKt$timeoutInternal$1$1$1 flowKt__DelayKt$timeoutInternal$1$1$1 = new FlowKt__DelayKt$timeoutInternal$1$1$1(this.$downStream, cVar);
        flowKt__DelayKt$timeoutInternal$1$1$1.L$0 = obj;
        return flowKt__DelayKt$timeoutInternal$1$1$1;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.c to kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1<T> for r4v1 'this'  kotlin.coroutines.c
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final java.lang.Object q0(@yt.k java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = yj.b.h()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L19
            if (r1 != r2) goto L11
            java.lang.Object r0 = r4.L$0
            kotlin.u0.n(r5)
            goto L36
        L11:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L19:
            kotlin.u0.n(r5)
            java.lang.Object r5 = r4.L$0
            kotlinx.coroutines.channels.j r5 = (kotlinx.coroutines.channels.j) r5
            java.lang.Object r5 = r5.o()
            kotlinx.coroutines.flow.f<T> r1 = r4.$downStream
            boolean r3 = r5 instanceof kotlinx.coroutines.channels.j.c
            if (r3 != 0) goto L37
            r4.L$0 = r5
            r4.label = r2
            java.lang.Object r1 = r1.f(r5, r4)
            if (r1 != r0) goto L35
            return r0
        L35:
            r0 = r5
        L36:
            r5 = r0
        L37:
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.j.a
            if (r0 == 0) goto L45
            kotlinx.coroutines.channels.j.f(r5)
            r5 = 0
            java.lang.Boolean r5 = zj.a.a(r5)
            return r5
        L45:
            java.lang.Boolean r5 = zj.a.a(r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.p
    public /* bridge */ /* synthetic */ Object r0(Object obj, kotlin.coroutines.c<? super Boolean> cVar) {
        return x0(((kotlinx.coroutines.channels.j) obj).o(), cVar);
    }

    @yt.l
    public final Object x0(@yt.k Object obj, @yt.l kotlin.coroutines.c<? super Boolean> cVar) {
        return ((FlowKt__DelayKt$timeoutInternal$1$1$1) M(kotlinx.coroutines.channels.j.b(obj), cVar)).q0(z1.f38230a);
    }
}
