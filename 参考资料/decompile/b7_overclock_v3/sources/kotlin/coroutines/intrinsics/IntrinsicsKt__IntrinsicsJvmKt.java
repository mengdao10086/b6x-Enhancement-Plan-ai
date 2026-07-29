package kotlin.coroutines.intrinsics;

import ik.l;
import ik.p;
import ik.q;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.w0;
import kotlin.u0;
import kotlin.v0;
import kotlin.z1;
import yt.k;
import zj.f;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nIntrinsicsJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntrinsicsJvm.kt\nkotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt\n*L\n1#1,204:1\n165#1,4:205\n186#1:209\n165#1,4:210\n186#1:214\n*S KotlinDebug\n*F\n+ 1 IntrinsicsJvm.kt\nkotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt\n*L\n91#1:205,4\n91#1:209\n126#1:210,4\n126#1:214\n*E\n"})
public class IntrinsicsKt__IntrinsicsJvmKt {
    @v0(version = "1.3")
    public static final <T> c<z1> a(final c<? super T> cVar, final l<? super c<? super T>, ? extends Object> lVar) {
        final CoroutineContext coroutineContextB = cVar.b();
        return coroutineContextB == EmptyCoroutineContext.f37755a ? new RestrictedContinuationImpl(cVar, lVar) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1
            public final /* synthetic */ l<c<? super T>, Object> $block;
            private int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(cVar);
                this.$block = lVar;
                f0.n(cVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1 for r2v1 'this'  java.lang.Object
                	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
                	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
                	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
                	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
                	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
                */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @yt.l
            public java.lang.Object q0(@yt.k java.lang.Object r3) {
                /*
                    r2 = this;
                    int r0 = r2.label
                    r1 = 1
                    if (r0 == 0) goto L1a
                    if (r0 != r1) goto Le
                    r0 = 2
                    r2.label = r0
                    kotlin.u0.n(r3)
                    goto L25
                Le:
                    java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                    java.lang.String r0 = "This coroutine had already completed"
                    java.lang.String r0 = r0.toString()
                    r3.<init>(r0)
                    throw r3
                L1a:
                    r2.label = r1
                    kotlin.u0.n(r3)
                    ik.l<kotlin.coroutines.c<? super T>, java.lang.Object> r3 = r2.$block
                    java.lang.Object r3 = r3.i(r2)
                L25:
                    return r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1.q0(java.lang.Object):java.lang.Object");
            }
        } : new ContinuationImpl(cVar, coroutineContextB, lVar) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2
            public final /* synthetic */ l<c<? super T>, Object> $block;
            private int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(cVar, coroutineContextB);
                this.$block = lVar;
                f0.n(cVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2 for r2v1 'this'  java.lang.Object
                	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
                	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
                	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
                	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
                	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
                */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @yt.l
            public java.lang.Object q0(@yt.k java.lang.Object r3) {
                /*
                    r2 = this;
                    int r0 = r2.label
                    r1 = 1
                    if (r0 == 0) goto L1a
                    if (r0 != r1) goto Le
                    r0 = 2
                    r2.label = r0
                    kotlin.u0.n(r3)
                    goto L25
                Le:
                    java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                    java.lang.String r0 = "This coroutine had already completed"
                    java.lang.String r0 = r0.toString()
                    r3.<init>(r0)
                    throw r3
                L1a:
                    r2.label = r1
                    kotlin.u0.n(r3)
                    ik.l<kotlin.coroutines.c<? super T>, java.lang.Object> r3 = r2.$block
                    java.lang.Object r3 = r3.i(r2)
                L25:
                    return r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2.q0(java.lang.Object):java.lang.Object");
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @v0(version = "1.3")
    @k
    public static final <T> c<z1> b(@k final l<? super c<? super T>, ? extends Object> lVar, @k c<? super T> completion) {
        f0.p(lVar, "<this>");
        f0.p(completion, "completion");
        final c<?> cVarA = f.a(completion);
        if (lVar instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) lVar).T(cVarA);
        }
        final CoroutineContext coroutineContextB = cVarA.b();
        return coroutineContextB == EmptyCoroutineContext.f37755a ? new RestrictedContinuationImpl(cVarA, lVar) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1
            public final /* synthetic */ l $this_createCoroutineUnintercepted$inlined;
            private int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(cVarA);
                this.$this_createCoroutineUnintercepted$inlined = lVar;
                f0.n(cVarA, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @yt.l
            public Object q0(@k Object obj) throws Throwable {
                int i10 = this.label;
                if (i10 == 0) {
                    this.label = 1;
                    u0.n(obj);
                    f0.n(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$0>, kotlin.Any?>");
                    return ((l) w0.q(this.$this_createCoroutineUnintercepted$inlined, 1)).i(this);
                }
                if (i10 != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                u0.n(obj);
                return obj;
            }
        } : new ContinuationImpl(cVarA, coroutineContextB, lVar) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2
            public final /* synthetic */ l $this_createCoroutineUnintercepted$inlined;
            private int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(cVarA, coroutineContextB);
                this.$this_createCoroutineUnintercepted$inlined = lVar;
                f0.n(cVarA, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @yt.l
            public Object q0(@k Object obj) throws Throwable {
                int i10 = this.label;
                if (i10 == 0) {
                    this.label = 1;
                    u0.n(obj);
                    f0.n(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$0>, kotlin.Any?>");
                    return ((l) w0.q(this.$this_createCoroutineUnintercepted$inlined, 1)).i(this);
                }
                if (i10 != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                u0.n(obj);
                return obj;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @v0(version = "1.3")
    @k
    public static final <R, T> c<z1> c(@k final p<? super R, ? super c<? super T>, ? extends Object> pVar, final R r10, @k c<? super T> completion) {
        f0.p(pVar, "<this>");
        f0.p(completion, "completion");
        final c<?> cVarA = f.a(completion);
        if (pVar instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) pVar).M(r10, cVarA);
        }
        final CoroutineContext coroutineContextB = cVarA.b();
        return coroutineContextB == EmptyCoroutineContext.f37755a ? new RestrictedContinuationImpl(cVarA, pVar, r10) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3
            public final /* synthetic */ Object $receiver$inlined;
            public final /* synthetic */ p $this_createCoroutineUnintercepted$inlined;
            private int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(cVarA);
                this.$this_createCoroutineUnintercepted$inlined = pVar;
                this.$receiver$inlined = r10;
                f0.n(cVarA, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @yt.l
            public Object q0(@k Object obj) throws Throwable {
                int i10 = this.label;
                if (i10 == 0) {
                    this.label = 1;
                    u0.n(obj);
                    f0.n(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                    return ((p) w0.q(this.$this_createCoroutineUnintercepted$inlined, 2)).r0(this.$receiver$inlined, this);
                }
                if (i10 != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                u0.n(obj);
                return obj;
            }
        } : new ContinuationImpl(cVarA, coroutineContextB, pVar, r10) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4
            public final /* synthetic */ Object $receiver$inlined;
            public final /* synthetic */ p $this_createCoroutineUnintercepted$inlined;
            private int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(cVarA, coroutineContextB);
                this.$this_createCoroutineUnintercepted$inlined = pVar;
                this.$receiver$inlined = r10;
                f0.n(cVarA, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @yt.l
            public Object q0(@k Object obj) throws Throwable {
                int i10 = this.label;
                if (i10 == 0) {
                    this.label = 1;
                    u0.n(obj);
                    f0.n(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                    return ((p) w0.q(this.$this_createCoroutineUnintercepted$inlined, 2)).r0(this.$receiver$inlined, this);
                }
                if (i10 != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                u0.n(obj);
                return obj;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @v0(version = "1.3")
    @k
    public static final <T> c<T> d(@k c<? super T> cVar) {
        c<T> cVar2;
        f0.p(cVar, "<this>");
        ContinuationImpl continuationImpl = cVar instanceof ContinuationImpl ? (ContinuationImpl) cVar : null;
        return (continuationImpl == null || (cVar2 = (c<T>) continuationImpl.v0()) == null) ? cVar : cVar2;
    }

    @bk.f
    @v0(version = "1.3")
    public static final <T> Object e(l<? super c<? super T>, ? extends Object> lVar, c<? super T> completion) {
        f0.p(lVar, "<this>");
        f0.p(completion, "completion");
        return ((l) w0.q(lVar, 1)).i(completion);
    }

    @bk.f
    @v0(version = "1.3")
    public static final <R, T> Object f(p<? super R, ? super c<? super T>, ? extends Object> pVar, R r10, c<? super T> completion) {
        f0.p(pVar, "<this>");
        f0.p(completion, "completion");
        return ((p) w0.q(pVar, 2)).r0(r10, completion);
    }

    @bk.f
    public static final <R, P, T> Object g(q<? super R, ? super P, ? super c<? super T>, ? extends Object> qVar, R r10, P p10, c<? super T> completion) {
        f0.p(qVar, "<this>");
        f0.p(completion, "completion");
        return ((q) w0.q(qVar, 3)).A(r10, p10, completion);
    }
}
