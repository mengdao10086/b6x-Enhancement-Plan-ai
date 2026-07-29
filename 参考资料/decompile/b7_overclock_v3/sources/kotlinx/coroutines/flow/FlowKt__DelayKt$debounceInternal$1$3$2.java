package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$2\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n*L\n1#1,405:1\n514#2,6:406\n530#2,4:412\n534#2:418\n1#3:416\n18#4:417\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$2\n*L\n238#1:406,6\n239#1:412,4\n239#1:418\n242#1:417\n*E\n"})
@zj.d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2", f = "Delay.kt", i = {0}, l = {m9.m.f40854e0}, m = "invokeSuspend", n = {"$this$onFailure_u2dWpGqRn0$iv"}, s = {"L$0"})
public final class FlowKt__DelayKt$debounceInternal$1$3$2 extends SuspendLambda implements ik.p<kotlinx.coroutines.channels.j<? extends Object>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ f<T> $downstream;
    public final /* synthetic */ Ref.ObjectRef<Object> $lastValue;
    public /* synthetic */ Object L$0;
    public Object L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$debounceInternal$1$3$2(Ref.ObjectRef<Object> objectRef, f<? super T> fVar, kotlin.coroutines.c<? super FlowKt__DelayKt$debounceInternal$1$3$2> cVar) {
        super(2, cVar);
        this.$lastValue = objectRef;
        this.$downstream = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        FlowKt__DelayKt$debounceInternal$1$3$2 flowKt__DelayKt$debounceInternal$1$3$2 = new FlowKt__DelayKt$debounceInternal$1$3$2(this.$lastValue, this.$downstream, cVar);
        flowKt__DelayKt$debounceInternal$1$3$2.L$0 = obj;
        return flowKt__DelayKt$debounceInternal$1$3$2;
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.c to kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2 for r6v1 'this'  kotlin.coroutines.c
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final java.lang.Object q0(@yt.k java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = yj.b.h()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L1b
            if (r1 != r2) goto L13
            java.lang.Object r0 = r6.L$1
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            kotlin.u0.n(r7)
            goto L4f
        L13:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1b:
            kotlin.u0.n(r7)
            java.lang.Object r7 = r6.L$0
            kotlinx.coroutines.channels.j r7 = (kotlinx.coroutines.channels.j) r7
            java.lang.Object r7 = r7.o()
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r1 = r6.$lastValue
            boolean r3 = r7 instanceof kotlinx.coroutines.channels.j.c
            if (r3 != 0) goto L2e
            r1.element = r7
        L2e:
            kotlinx.coroutines.flow.f<T> r4 = r6.$downstream
            if (r3 == 0) goto L56
            java.lang.Throwable r3 = kotlinx.coroutines.channels.j.f(r7)
            if (r3 != 0) goto L55
            T r3 = r1.element
            if (r3 == 0) goto L50
            kotlinx.coroutines.internal.o0 r5 = kotlinx.coroutines.flow.internal.l.f38719a
            if (r3 != r5) goto L41
            r3 = 0
        L41:
            r6.L$0 = r7
            r6.L$1 = r1
            r6.label = r2
            java.lang.Object r7 = r4.f(r3, r6)
            if (r7 != r0) goto L4e
            return r0
        L4e:
            r0 = r1
        L4f:
            r1 = r0
        L50:
            kotlinx.coroutines.internal.o0 r7 = kotlinx.coroutines.flow.internal.l.f38721c
            r1.element = r7
            goto L56
        L55:
            throw r3
        L56:
            kotlin.z1 r7 = kotlin.z1.f38230a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.p
    public /* bridge */ /* synthetic */ Object r0(kotlinx.coroutines.channels.j<? extends Object> jVar, kotlin.coroutines.c<? super z1> cVar) {
        return x0(jVar.o(), cVar);
    }

    @yt.l
    public final Object x0(@yt.k Object obj, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$2) M(kotlinx.coroutines.channels.j.b(obj), cVar)).q0(z1.f38230a);
    }
}
