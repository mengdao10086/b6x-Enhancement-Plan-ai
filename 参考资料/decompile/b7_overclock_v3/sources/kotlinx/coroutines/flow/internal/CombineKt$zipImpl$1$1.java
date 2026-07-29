package kotlinx.coroutines.flow.internal;

import ik.p;
import ik.q;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.s;
import kotlinx.coroutines.h2;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.o0;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1", f = "Combine.kt", i = {0}, l = {126}, m = "invokeSuspend", n = {"second"}, s = {"L$0"})
public final class CombineKt$zipImpl$1$1 extends SuspendLambda implements p<o0, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ kotlinx.coroutines.flow.e<T1> $flow;
    public final /* synthetic */ kotlinx.coroutines.flow.e<T2> $flow2;
    public final /* synthetic */ kotlinx.coroutines.flow.f<R> $this_unsafeFlow;
    public final /* synthetic */ q<T1, T2, kotlin.coroutines.c<? super R>, Object> $transform;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2, reason: invalid class name */
    @zj.d(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2", f = "Combine.kt", i = {}, l = {127}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements p<z1, kotlin.coroutines.c<? super z1>, Object> {
        public final /* synthetic */ Object $cnt;
        public final /* synthetic */ kotlinx.coroutines.flow.e<T1> $flow;
        public final /* synthetic */ CoroutineContext $scopeContext;
        public final /* synthetic */ ReceiveChannel<Object> $second;
        public final /* synthetic */ kotlinx.coroutines.flow.f<R> $this_unsafeFlow;
        public final /* synthetic */ q<T1, T2, kotlin.coroutines.c<? super R>, Object> $transform;
        public int label;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CoroutineContext f38695a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Object f38696b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ReceiveChannel<Object> f38697c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ kotlinx.coroutines.flow.f<R> f38698d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ q<T1, T2, kotlin.coroutines.c<? super R>, Object> f38699e;

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1, reason: invalid class name and collision with other inner class name */
            @t0({"SMAP\nCombine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$2$1$1\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n*L\n1#1,143:1\n501#2,5:144\n18#3:149\n*S KotlinDebug\n*F\n+ 1 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$2$1$1\n*L\n129#1:144,5\n132#1:149\n*E\n"})
            @zj.d(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1", f = "Combine.kt", i = {}, l = {129, 132, 132}, m = "invokeSuspend", n = {}, s = {})
            public static final class C04371 extends SuspendLambda implements p<z1, kotlin.coroutines.c<? super z1>, Object> {
                public final /* synthetic */ ReceiveChannel<Object> $second;
                public final /* synthetic */ kotlinx.coroutines.flow.f<R> $this_unsafeFlow;
                public final /* synthetic */ q<T1, T2, kotlin.coroutines.c<? super R>, Object> $transform;
                public final /* synthetic */ T1 $value;
                public Object L$0;
                public int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C04371(ReceiveChannel<? extends Object> receiveChannel, kotlinx.coroutines.flow.f<? super R> fVar, q<? super T1, ? super T2, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar, T1 t12, kotlin.coroutines.c<? super C04371> cVar) {
                    super(2, cVar);
                    this.$second = receiveChannel;
                    this.$this_unsafeFlow = fVar;
                    this.$transform = qVar;
                    this.$value = t12;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @yt.k
                public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
                    return new C04371(this.$second, this.$this_unsafeFlow, this.$transform, this.$value, cVar);
                }

                /* JADX WARN: Removed duplicated region for block: B:29:0x006e A[RETURN] */
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
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
                        r2 = 0
                        r3 = 3
                        r4 = 2
                        r5 = 1
                        if (r1 == 0) goto L30
                        if (r1 == r5) goto L26
                        if (r1 == r4) goto L1e
                        if (r1 != r3) goto L16
                        kotlin.u0.n(r9)
                        goto L6f
                    L16:
                        java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r9.<init>(r0)
                        throw r9
                    L1e:
                        java.lang.Object r1 = r8.L$0
                        kotlinx.coroutines.flow.f r1 = (kotlinx.coroutines.flow.f) r1
                        kotlin.u0.n(r9)
                        goto L64
                    L26:
                        kotlin.u0.n(r9)
                        kotlinx.coroutines.channels.j r9 = (kotlinx.coroutines.channels.j) r9
                        java.lang.Object r9 = r9.o()
                        goto L3e
                    L30:
                        kotlin.u0.n(r9)
                        kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> r9 = r8.$second
                        r8.label = r5
                        java.lang.Object r9 = r9.v(r8)
                        if (r9 != r0) goto L3e
                        return r0
                    L3e:
                        kotlinx.coroutines.flow.f<R> r1 = r8.$this_unsafeFlow
                        boolean r5 = r9 instanceof kotlinx.coroutines.channels.j.c
                        if (r5 == 0) goto L50
                        java.lang.Throwable r9 = kotlinx.coroutines.channels.j.f(r9)
                        if (r9 != 0) goto L4f
                        kotlinx.coroutines.flow.internal.AbortFlowException r9 = new kotlinx.coroutines.flow.internal.AbortFlowException
                        r9.<init>(r1)
                    L4f:
                        throw r9
                    L50:
                        ik.q<T1, T2, kotlin.coroutines.c<? super R>, java.lang.Object> r5 = r8.$transform
                        T1 r6 = r8.$value
                        kotlinx.coroutines.internal.o0 r7 = kotlinx.coroutines.flow.internal.l.f38719a
                        if (r9 != r7) goto L59
                        r9 = r2
                    L59:
                        r8.L$0 = r1
                        r8.label = r4
                        java.lang.Object r9 = r5.A(r6, r9, r8)
                        if (r9 != r0) goto L64
                        return r0
                    L64:
                        r8.L$0 = r2
                        r8.label = r3
                        java.lang.Object r9 = r1.f(r9, r8)
                        if (r9 != r0) goto L6f
                        return r0
                    L6f:
                        kotlin.z1 r9 = kotlin.z1.f38230a
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.AnonymousClass2.AnonymousClass1.C04371.q0(java.lang.Object):java.lang.Object");
                }

                @Override // ik.p
                @yt.l
                /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
                public final Object r0(@yt.k z1 z1Var, @yt.l kotlin.coroutines.c<? super z1> cVar) {
                    return ((C04371) M(z1Var, cVar)).q0(z1.f38230a);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(CoroutineContext coroutineContext, Object obj, ReceiveChannel<? extends Object> receiveChannel, kotlinx.coroutines.flow.f<? super R> fVar, q<? super T1, ? super T2, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar) {
                this.f38695a = coroutineContext;
                this.f38696b = obj;
                this.f38697c = receiveChannel;
                this.f38698d = fVar;
                this.f38699e = qVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.f
            @yt.l
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object f(T1 r13, @yt.k kotlin.coroutines.c<? super kotlin.z1> r14) throws java.lang.Throwable {
                /*
                    r12 = this;
                    boolean r0 = r14 instanceof kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1
                    if (r0 == 0) goto L13
                    r0 = r14
                    kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L18
                L13:
                    kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1
                    r0.<init>(r12, r14)
                L18:
                    java.lang.Object r14 = r0.result
                    java.lang.Object r1 = yj.b.h()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    kotlin.u0.n(r14)
                    goto L51
                L29:
                    java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                    java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                    r13.<init>(r14)
                    throw r13
                L31:
                    kotlin.u0.n(r14)
                    kotlin.coroutines.CoroutineContext r14 = r12.f38695a
                    kotlin.z1 r2 = kotlin.z1.f38230a
                    java.lang.Object r4 = r12.f38696b
                    kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1 r11 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1
                    kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> r6 = r12.f38697c
                    kotlinx.coroutines.flow.f<R> r7 = r12.f38698d
                    ik.q<T1, T2, kotlin.coroutines.c<? super R>, java.lang.Object> r8 = r12.f38699e
                    r10 = 0
                    r5 = r11
                    r9 = r13
                    r5.<init>(r6, r7, r8, r9, r10)
                    r0.label = r3
                    java.lang.Object r13 = kotlinx.coroutines.flow.internal.d.c(r14, r2, r4, r11, r0)
                    if (r13 != r1) goto L51
                    return r1
                L51:
                    kotlin.z1 r13 = kotlin.z1.f38230a
                    return r13
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.AnonymousClass2.AnonymousClass1.f(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(kotlinx.coroutines.flow.e<? extends T1> eVar, CoroutineContext coroutineContext, Object obj, ReceiveChannel<? extends Object> receiveChannel, kotlinx.coroutines.flow.f<? super R> fVar, q<? super T1, ? super T2, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar, kotlin.coroutines.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$flow = eVar;
            this.$scopeContext = coroutineContext;
            this.$cnt = obj;
            this.$second = receiveChannel;
            this.$this_unsafeFlow = fVar;
            this.$transform = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @yt.k
        public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass2(this.$flow, this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform, cVar);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.c to kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2 for r9v1 'this'  kotlin.coroutines.c
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @yt.l
        public final java.lang.Object q0(@yt.k java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = yj.b.h()
                int r1 = r9.label
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.u0.n(r10)
                goto L35
            Lf:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L17:
                kotlin.u0.n(r10)
                kotlinx.coroutines.flow.e<T1> r10 = r9.$flow
                kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1 r1 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1
                kotlin.coroutines.CoroutineContext r4 = r9.$scopeContext
                java.lang.Object r5 = r9.$cnt
                kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> r6 = r9.$second
                kotlinx.coroutines.flow.f<R> r7 = r9.$this_unsafeFlow
                ik.q<T1, T2, kotlin.coroutines.c<? super R>, java.lang.Object> r8 = r9.$transform
                r3 = r1
                r3.<init>(r4, r5, r6, r7, r8)
                r9.label = r2
                java.lang.Object r10 = r10.a(r1, r9)
                if (r10 != r0) goto L35
                return r0
            L35:
                kotlin.z1 r10 = kotlin.z1.f38230a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.AnonymousClass2.q0(java.lang.Object):java.lang.Object");
        }

        @Override // ik.p
        @yt.l
        /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
        public final Object r0(@yt.k z1 z1Var, @yt.l kotlin.coroutines.c<? super z1> cVar) {
            return ((AnonymousClass2) M(z1Var, cVar)).q0(z1.f38230a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$zipImpl$1$1(kotlinx.coroutines.flow.f<? super R> fVar, kotlinx.coroutines.flow.e<? extends T2> eVar, kotlinx.coroutines.flow.e<? extends T1> eVar2, q<? super T1, ? super T2, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar, kotlin.coroutines.c<? super CombineKt$zipImpl$1$1> cVar) {
        super(2, cVar);
        this.$this_unsafeFlow = fVar;
        this.$flow2 = eVar;
        this.$flow = eVar2;
        this.$transform = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        CombineKt$zipImpl$1$1 combineKt$zipImpl$1$1 = new CombineKt$zipImpl$1$1(this.$this_unsafeFlow, this.$flow2, this.$flow, this.$transform, cVar);
        combineKt$zipImpl$1$1.L$0 = obj;
        return combineKt$zipImpl$1$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r1v5 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        ReceiveChannel receiveChannel;
        ReceiveChannel receiveChannel2;
        CoroutineContext coroutineContextL;
        z1 z1Var;
        AnonymousClass2 anonymousClass2;
        Object objH = yj.b.h();
        ?? r12 = this.label;
        try {
            if (r12 != 0) {
                if (r12 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                receiveChannel2 = (ReceiveChannel) this.L$0;
                try {
                    u0.n(obj);
                    r12 = receiveChannel2;
                } catch (AbortFlowException e10) {
                    e = e10;
                    h.b(e, this.$this_unsafeFlow);
                    r12 = receiveChannel2;
                }
                ReceiveChannel.DefaultImpls.b(r12, null, 1, null);
                return z1.f38230a;
            }
            u0.n(obj);
            o0 o0Var = (o0) this.L$0;
            ReceiveChannel receiveChannelF = ProduceKt.f(o0Var, null, 0, new CombineKt$zipImpl$1$1$second$1(this.$flow2, null), 3, null);
            final a0 a0VarC = h2.c(null, 1, null);
            f0.n(receiveChannelF, "null cannot be cast to non-null type kotlinx.coroutines.channels.SendChannel<*>");
            final kotlinx.coroutines.flow.f fVar = this.$this_unsafeFlow;
            ((s) receiveChannelF).g(new ik.l<Throwable, z1>() { // from class: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                public final void b(@yt.l Throwable th2) {
                    if (a0VarC.isActive()) {
                        a0VarC.h(new AbortFlowException(fVar));
                    }
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                    b(th2);
                    return z1.f38230a;
                }
            });
            try {
                CoroutineContext coroutineContextW = o0Var.W();
                Object objB = ThreadContextKt.b(coroutineContextW);
                coroutineContextL = o0Var.W().L(a0VarC);
                z1Var = z1.f38230a;
                anonymousClass2 = new AnonymousClass2(this.$flow, coroutineContextW, objB, receiveChannelF, this.$this_unsafeFlow, this.$transform, null);
                this.L$0 = receiveChannelF;
                this.label = 1;
                receiveChannel = receiveChannelF;
            } catch (AbortFlowException e11) {
                e = e11;
                receiveChannel = receiveChannelF;
            } catch (Throwable th2) {
                th = th2;
                receiveChannel = receiveChannelF;
            }
            try {
            } catch (AbortFlowException e12) {
                e = e12;
                receiveChannel2 = receiveChannel;
                h.b(e, this.$this_unsafeFlow);
                r12 = receiveChannel2;
            } catch (Throwable th3) {
                th = th3;
                r12 = receiveChannel;
                ReceiveChannel.DefaultImpls.b(r12, null, 1, null);
                throw th;
            }
            if (d.d(coroutineContextL, z1Var, null, anonymousClass2, this, 4, null) == objH) {
                return objH;
            }
            r12 = receiveChannel;
            ReceiveChannel.DefaultImpls.b(r12, null, 1, null);
            return z1.f38230a;
            h.b(e, this.$this_unsafeFlow);
            r12 = receiveChannel2;
            ReceiveChannel.DefaultImpls.b(r12, null, 1, null);
            return z1.f38230a;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k o0 o0Var, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((CombineKt$zipImpl$1$1) M(o0Var, cVar)).q0(z1.f38230a);
    }
}
