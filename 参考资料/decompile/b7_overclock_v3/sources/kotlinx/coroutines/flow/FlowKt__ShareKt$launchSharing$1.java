package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.o0;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1", f = "Share.kt", i = {}, l = {214, 218, 219, 225}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__ShareKt$launchSharing$1 extends SuspendLambda implements ik.p<o0, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ T $initialValue;
    public final /* synthetic */ i<T> $shared;
    public final /* synthetic */ r $started;
    public final /* synthetic */ e<T> $upstream;
    public int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1, reason: invalid class name */
    @zj.d(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1", f = "Share.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements ik.p<Integer, kotlin.coroutines.c<? super Boolean>, Object> {
        public /* synthetic */ int I$0;
        public int label;

        public AnonymousClass1(kotlin.coroutines.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @yt.k
        public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(cVar);
            anonymousClass1.I$0 = ((Number) obj).intValue();
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @yt.l
        public final Object q0(@yt.k Object obj) throws Throwable {
            yj.b.h();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u0.n(obj);
            return zj.a.a(this.I$0 > 0);
        }

        @Override // ik.p
        public /* bridge */ /* synthetic */ Object r0(Integer num, kotlin.coroutines.c<? super Boolean> cVar) {
            return x0(num.intValue(), cVar);
        }

        @yt.l
        public final Object x0(int i10, @yt.l kotlin.coroutines.c<? super Boolean> cVar) {
            return ((AnonymousClass1) M(Integer.valueOf(i10), cVar)).q0(z1.f38230a);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2, reason: invalid class name */
    @zj.d(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2", f = "Share.kt", i = {}, l = {227}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements ik.p<SharingCommand, kotlin.coroutines.c<? super z1>, Object> {
        public final /* synthetic */ T $initialValue;
        public final /* synthetic */ i<T> $shared;
        public final /* synthetic */ e<T> $upstream;
        public /* synthetic */ Object L$0;
        public int label;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2$a */
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f38582a;

            static {
                int[] iArr = new int[SharingCommand.values().length];
                try {
                    iArr[SharingCommand.START.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SharingCommand.STOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[SharingCommand.STOP_AND_RESET_REPLAY_CACHE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f38582a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(e<? extends T> eVar, i<T> iVar, T t10, kotlin.coroutines.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$upstream = eVar;
            this.$shared = iVar;
            this.$initialValue = t10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @yt.k
        public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$upstream, this.$shared, this.$initialValue, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

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
        public final Object q0(@yt.k Object obj) throws Throwable {
            Object objH = yj.b.h();
            int i10 = this.label;
            if (i10 == 0) {
                u0.n(obj);
                int i11 = a.f38582a[((SharingCommand) this.L$0).ordinal()];
                if (i11 == 1) {
                    e<T> eVar = this.$upstream;
                    f fVar = this.$shared;
                    this.label = 1;
                    if (eVar.a(fVar, this) == objH) {
                        return objH;
                    }
                } else if (i11 == 3) {
                    T t10 = this.$initialValue;
                    if (t10 == o.f38730a) {
                        this.$shared.k();
                    } else {
                        this.$shared.z(t10);
                    }
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
        public final Object r0(@yt.k SharingCommand sharingCommand, @yt.l kotlin.coroutines.c<? super z1> cVar) {
            return ((AnonymousClass2) M(sharingCommand, cVar)).q0(z1.f38230a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ShareKt$launchSharing$1(r rVar, e<? extends T> eVar, i<T> iVar, T t10, kotlin.coroutines.c<? super FlowKt__ShareKt$launchSharing$1> cVar) {
        super(2, cVar);
        this.$started = rVar;
        this.$upstream = eVar;
        this.$shared = iVar;
        this.$initialValue = t10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        return new FlowKt__ShareKt$launchSharing$1(this.$started, this.$upstream, this.$shared, this.$initialValue, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0068 A[RETURN] */
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
    public final java.lang.Object q0(@yt.k java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = yj.b.h()
            int r1 = r7.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L25
            if (r1 == r5) goto L21
            if (r1 == r4) goto L1d
            if (r1 == r3) goto L21
            if (r1 != r2) goto L15
            goto L21
        L15:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1d:
            kotlin.u0.n(r8)
            goto L5c
        L21:
            kotlin.u0.n(r8)
            goto L8d
        L25:
            kotlin.u0.n(r8)
            kotlinx.coroutines.flow.r r8 = r7.$started
            kotlinx.coroutines.flow.r$a r1 = kotlinx.coroutines.flow.r.f38737a
            kotlinx.coroutines.flow.r r6 = r1.c()
            if (r8 != r6) goto L3f
            kotlinx.coroutines.flow.e<T> r8 = r7.$upstream
            kotlinx.coroutines.flow.i<T> r1 = r7.$shared
            r7.label = r5
            java.lang.Object r8 = r8.a(r1, r7)
            if (r8 != r0) goto L8d
            return r0
        L3f:
            kotlinx.coroutines.flow.r r8 = r7.$started
            kotlinx.coroutines.flow.r r1 = r1.d()
            r5 = 0
            if (r8 != r1) goto L69
            kotlinx.coroutines.flow.i<T> r8 = r7.$shared
            kotlinx.coroutines.flow.u r8 = r8.I()
            kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1 r1 = new kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1
            r1.<init>(r5)
            r7.label = r4
            java.lang.Object r8 = kotlinx.coroutines.flow.g.u0(r8, r1, r7)
            if (r8 != r0) goto L5c
            return r0
        L5c:
            kotlinx.coroutines.flow.e<T> r8 = r7.$upstream
            kotlinx.coroutines.flow.i<T> r1 = r7.$shared
            r7.label = r3
            java.lang.Object r8 = r8.a(r1, r7)
            if (r8 != r0) goto L8d
            return r0
        L69:
            kotlinx.coroutines.flow.r r8 = r7.$started
            kotlinx.coroutines.flow.i<T> r1 = r7.$shared
            kotlinx.coroutines.flow.u r1 = r1.I()
            kotlinx.coroutines.flow.e r8 = r8.a(r1)
            kotlinx.coroutines.flow.e r8 = kotlinx.coroutines.flow.g.g0(r8)
            kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2 r1 = new kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2
            kotlinx.coroutines.flow.e<T> r3 = r7.$upstream
            kotlinx.coroutines.flow.i<T> r4 = r7.$shared
            T r6 = r7.$initialValue
            r1.<init>(r3, r4, r6, r5)
            r7.label = r2
            java.lang.Object r8 = kotlinx.coroutines.flow.g.A(r8, r1, r7)
            if (r8 != r0) goto L8d
            return r0
        L8d:
            kotlin.z1 r8 = kotlin.z1.f38230a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k o0 o0Var, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((FlowKt__ShareKt$launchSharing$1) M(o0Var, cVar)).q0(z1.f38230a);
    }
}
