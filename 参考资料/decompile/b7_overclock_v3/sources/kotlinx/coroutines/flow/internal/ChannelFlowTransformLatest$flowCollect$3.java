package kotlinx.coroutines.flow.internal;

import ik.p;
import ik.q;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.c2;
import kotlinx.coroutines.o0;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3", f = "Merge.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
public final class ChannelFlowTransformLatest$flowCollect$3 extends SuspendLambda implements p<o0, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ kotlinx.coroutines.flow.f<R> $collector;
    private /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ ChannelFlowTransformLatest<T, R> this$0;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<c2> f38685a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o0 f38686b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ChannelFlowTransformLatest<T, R> f38687c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.flow.f<R> f38688d;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2, reason: invalid class name */
        @zj.d(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2", f = "Merge.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements p<o0, kotlin.coroutines.c<? super z1>, Object> {
            public final /* synthetic */ kotlinx.coroutines.flow.f<R> $collector;
            public final /* synthetic */ T $value;
            public int label;
            public final /* synthetic */ ChannelFlowTransformLatest<T, R> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass2(ChannelFlowTransformLatest<T, R> channelFlowTransformLatest, kotlinx.coroutines.flow.f<? super R> fVar, T t10, kotlin.coroutines.c<? super AnonymousClass2> cVar) {
                super(2, cVar);
                this.this$0 = channelFlowTransformLatest;
                this.$collector = fVar;
                this.$value = t10;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @yt.k
            public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
                return new AnonymousClass2(this.this$0, this.$collector, this.$value, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @yt.l
            public final Object q0(@yt.k Object obj) throws Throwable {
                Object objH = yj.b.h();
                int i10 = this.label;
                if (i10 == 0) {
                    u0.n(obj);
                    q qVar = this.this$0.f38684e;
                    Object obj2 = this.$collector;
                    T t10 = this.$value;
                    this.label = 1;
                    if (qVar.A(obj2, t10, this) == objH) {
                        return objH;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u0.n(obj);
                }
                return z1.f38230a;
            }

            @Override // ik.p
            @yt.l
            /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
            public final Object r0(@yt.k o0 o0Var, @yt.l kotlin.coroutines.c<? super z1> cVar) {
                return ((AnonymousClass2) M(o0Var, cVar)).q0(z1.f38230a);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Ref.ObjectRef<c2> objectRef, o0 o0Var, ChannelFlowTransformLatest<T, R> channelFlowTransformLatest, kotlinx.coroutines.flow.f<? super R> fVar) {
            this.f38685a = objectRef;
            this.f38686b = o0Var;
            this.f38687c = channelFlowTransformLatest;
            this.f38688d = fVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.f
        @yt.l
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object f(T r8, @yt.k kotlin.coroutines.c<? super kotlin.z1> r9) throws java.lang.Throwable {
            /*
                r7 = this;
                boolean r0 = r9 instanceof kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1
                if (r0 == 0) goto L13
                r0 = r9
                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1
                r0.<init>(r7, r9)
            L18:
                java.lang.Object r9 = r0.result
                java.lang.Object r1 = yj.b.h()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L3b
                if (r2 != r3) goto L33
                java.lang.Object r8 = r0.L$2
                kotlinx.coroutines.c2 r8 = (kotlinx.coroutines.c2) r8
                java.lang.Object r8 = r0.L$1
                java.lang.Object r0 = r0.L$0
                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3.AnonymousClass1) r0
                kotlin.u0.n(r9)
                goto L5e
            L33:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L3b:
                kotlin.u0.n(r9)
                kotlin.jvm.internal.Ref$ObjectRef<kotlinx.coroutines.c2> r9 = r7.f38685a
                T r9 = r9.element
                kotlinx.coroutines.c2 r9 = (kotlinx.coroutines.c2) r9
                if (r9 == 0) goto L5d
                kotlinx.coroutines.flow.internal.ChildCancelledException r2 = new kotlinx.coroutines.flow.internal.ChildCancelledException
                r2.<init>()
                r9.h(r2)
                r0.L$0 = r7
                r0.L$1 = r8
                r0.L$2 = r9
                r0.label = r3
                java.lang.Object r9 = r9.T(r0)
                if (r9 != r1) goto L5d
                return r1
            L5d:
                r0 = r7
            L5e:
                kotlin.jvm.internal.Ref$ObjectRef<kotlinx.coroutines.c2> r9 = r0.f38685a
                kotlinx.coroutines.o0 r1 = r0.f38686b
                r2 = 0
                kotlinx.coroutines.CoroutineStart r3 = kotlinx.coroutines.CoroutineStart.UNDISPATCHED
                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2 r4 = new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2
                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest<T, R> r5 = r0.f38687c
                kotlinx.coroutines.flow.f<R> r0 = r0.f38688d
                r6 = 0
                r4.<init>(r5, r0, r8, r6)
                r5 = 1
                kotlinx.coroutines.c2 r8 = kotlinx.coroutines.h.e(r1, r2, r3, r4, r5, r6)
                r9.element = r8
                kotlin.z1 r8 = kotlin.z1.f38230a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3.AnonymousClass1.f(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowTransformLatest$flowCollect$3(ChannelFlowTransformLatest<T, R> channelFlowTransformLatest, kotlinx.coroutines.flow.f<? super R> fVar, kotlin.coroutines.c<? super ChannelFlowTransformLatest$flowCollect$3> cVar) {
        super(2, cVar);
        this.this$0 = channelFlowTransformLatest;
        this.$collector = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        ChannelFlowTransformLatest$flowCollect$3 channelFlowTransformLatest$flowCollect$3 = new ChannelFlowTransformLatest$flowCollect$3(this.this$0, this.$collector, cVar);
        channelFlowTransformLatest$flowCollect$3.L$0 = obj;
        return channelFlowTransformLatest$flowCollect$3;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.c to kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3 for r7v1 'this'  kotlin.coroutines.c
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final java.lang.Object q0(@yt.k java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = yj.b.h()
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 != r2) goto Lf
            kotlin.u0.n(r8)
            goto L37
        Lf:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L17:
            kotlin.u0.n(r8)
            java.lang.Object r8 = r7.L$0
            kotlinx.coroutines.o0 r8 = (kotlinx.coroutines.o0) r8
            kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
            r1.<init>()
            kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest<T, R> r3 = r7.this$0
            kotlinx.coroutines.flow.e<S> r4 = r3.f38683d
            kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1 r5 = new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1
            kotlinx.coroutines.flow.f<R> r6 = r7.$collector
            r5.<init>(r1, r8, r3, r6)
            r7.label = r2
            java.lang.Object r8 = r4.a(r5, r7)
            if (r8 != r0) goto L37
            return r0
        L37:
            kotlin.z1 r8 = kotlin.z1.f38230a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k o0 o0Var, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((ChannelFlowTransformLatest$flowCollect$3) M(o0Var, cVar)).q0(z1.f38230a);
    }
}
