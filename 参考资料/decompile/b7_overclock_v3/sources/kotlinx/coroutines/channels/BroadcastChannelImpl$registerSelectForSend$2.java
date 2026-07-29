package kotlinx.coroutines.channels;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import kotlinx.coroutines.o0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nBroadcastChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl$registerSelectForSend$2\n+ 2 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,414:1\n15#2:415\n1#3:416\n*S KotlinDebug\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl$registerSelectForSend$2\n*L\n304#1:415\n*E\n"})
@zj.d(c = "kotlinx.coroutines.channels.BroadcastChannelImpl$registerSelectForSend$2", f = "BroadcastChannel.kt", i = {}, l = {291}, m = "invokeSuspend", n = {}, s = {})
public final class BroadcastChannelImpl$registerSelectForSend$2 extends SuspendLambda implements ik.p<o0, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ Object $element;
    public final /* synthetic */ kotlinx.coroutines.selects.j<?> $select;
    public int label;
    public final /* synthetic */ BroadcastChannelImpl<E> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BroadcastChannelImpl$registerSelectForSend$2(BroadcastChannelImpl<E> broadcastChannelImpl, Object obj, kotlinx.coroutines.selects.j<?> jVar, kotlin.coroutines.c<? super BroadcastChannelImpl$registerSelectForSend$2> cVar) {
        super(2, cVar);
        this.this$0 = broadcastChannelImpl;
        this.$element = obj;
        this.$select = jVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        return new BroadcastChannelImpl$registerSelectForSend$2(this.this$0, this.$element, this.$select, cVar);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.c to kotlinx.coroutines.channels.BroadcastChannelImpl$registerSelectForSend$2 for r5v1 'this'  kotlin.coroutines.c
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final java.lang.Object q0(@yt.k java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = yj.b.h()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L19
            if (r1 != r2) goto L11
            kotlin.u0.n(r6)     // Catch: java.lang.Throwable -> Lf
            goto L3e
        Lf:
            r6 = move-exception
            goto L29
        L11:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L19:
            kotlin.u0.n(r6)
            kotlinx.coroutines.channels.BroadcastChannelImpl<E> r6 = r5.this$0     // Catch: java.lang.Throwable -> Lf
            java.lang.Object r1 = r5.$element     // Catch: java.lang.Throwable -> Lf
            r5.label = r2     // Catch: java.lang.Throwable -> Lf
            java.lang.Object r6 = r6.G(r1, r5)     // Catch: java.lang.Throwable -> Lf
            if (r6 != r0) goto L3e
            return r0
        L29:
            kotlinx.coroutines.channels.BroadcastChannelImpl<E> r0 = r5.this$0
            boolean r0 = r0.H()
            if (r0 == 0) goto L80
            boolean r0 = r6 instanceof kotlinx.coroutines.channels.ClosedSendChannelException
            if (r0 != 0) goto L3d
            kotlinx.coroutines.channels.BroadcastChannelImpl<E> r0 = r5.this$0
            java.lang.Throwable r0 = r0.o0()
            if (r0 != r6) goto L80
        L3d:
            r2 = 0
        L3e:
            kotlinx.coroutines.channels.BroadcastChannelImpl<E> r6 = r5.this$0
            java.util.concurrent.locks.ReentrantLock r6 = kotlinx.coroutines.channels.BroadcastChannelImpl.I1(r6)
            kotlinx.coroutines.channels.BroadcastChannelImpl<E> r0 = r5.this$0
            kotlinx.coroutines.selects.j<?> r1 = r5.$select
            r6.lock()
            java.util.HashMap r3 = kotlinx.coroutines.channels.BroadcastChannelImpl.J1(r0)     // Catch: java.lang.Throwable -> L7b
            if (r2 == 0) goto L54
            kotlin.z1 r2 = kotlin.z1.f38230a     // Catch: java.lang.Throwable -> L7b
            goto L58
        L54:
            kotlinx.coroutines.internal.o0 r2 = kotlinx.coroutines.channels.BufferedChannelKt.z()     // Catch: java.lang.Throwable -> L7b
        L58:
            r3.put(r1, r2)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r2 = "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>"
            kotlin.jvm.internal.f0.n(r1, r2)     // Catch: java.lang.Throwable -> L7b
            r2 = r1
            kotlinx.coroutines.selects.SelectImplementation r2 = (kotlinx.coroutines.selects.SelectImplementation) r2     // Catch: java.lang.Throwable -> L7b
            r2 = r1
            kotlinx.coroutines.selects.SelectImplementation r2 = (kotlinx.coroutines.selects.SelectImplementation) r2     // Catch: java.lang.Throwable -> L7b
            kotlin.z1 r3 = kotlin.z1.f38230a     // Catch: java.lang.Throwable -> L7b
            kotlinx.coroutines.selects.TrySelectDetailedResult r2 = r2.h0(r0, r3)     // Catch: java.lang.Throwable -> L7b
            kotlinx.coroutines.selects.TrySelectDetailedResult r4 = kotlinx.coroutines.selects.TrySelectDetailedResult.REREGISTER     // Catch: java.lang.Throwable -> L7b
            if (r2 == r4) goto L77
            java.util.HashMap r0 = kotlinx.coroutines.channels.BroadcastChannelImpl.J1(r0)     // Catch: java.lang.Throwable -> L7b
            r0.remove(r1)     // Catch: java.lang.Throwable -> L7b
        L77:
            r6.unlock()
            return r3
        L7b:
            r0 = move-exception
            r6.unlock()
            throw r0
        L80:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BroadcastChannelImpl$registerSelectForSend$2.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k o0 o0Var, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((BroadcastChannelImpl$registerSelectForSend$2) M(o0Var, cVar)).q0(z1.f38230a);
    }
}
