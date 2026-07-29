package kotlinx.coroutines.flow;

import kotlin.collections.h0;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nTransform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 3 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,136:1\n21#1:143\n23#1:147\n21#1:148\n23#1:152\n50#2:137\n55#2:139\n50#2:140\n55#2:142\n50#2:144\n55#2:146\n50#2:149\n55#2:151\n50#2:153\n55#2:155\n50#2:156\n55#2:158\n50#2:159\n55#2:161\n50#2:163\n55#2:165\n106#3:138\n106#3:141\n106#3:145\n106#3:150\n106#3:154\n106#3:157\n106#3:160\n106#3:162\n106#3:164\n106#3:166\n106#3:167\n*S KotlinDebug\n*F\n+ 1 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n36#1:143\n36#1:147\n41#1:148\n41#1:152\n21#1:137\n21#1:139\n28#1:140\n28#1:142\n36#1:144\n36#1:146\n41#1:149\n41#1:151\n46#1:153\n46#1:155\n53#1:156\n53#1:158\n60#1:159\n60#1:161\n78#1:163\n78#1:165\n21#1:138\n28#1:141\n36#1:145\n41#1:150\n46#1:154\n53#1:157\n60#1:160\n68#1:162\n78#1:164\n105#1:166\n125#1:167\n*E\n"})
public final /* synthetic */ class FlowKt__TransformKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @t0({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,112:1\n126#2,10:113\n*E\n"})
    public static final class a<T> implements e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f38586a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ik.q f38587b;

        public a(e eVar, ik.q qVar) {
            this.f38586a = eVar;
            this.f38587b = qVar;
        }

        @Override // kotlinx.coroutines.flow.e
        @yt.l
        public Object a(@yt.k f<? super T> fVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = (T) kotlinx.coroutines.flow.internal.l.f38719a;
            Object objA = this.f38586a.a(new FlowKt__TransformKt$runningReduce$1$1(objectRef, this.f38587b, fVar), cVar);
            return objA == yj.b.h() ? objA : z1.f38230a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @t0({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,112:1\n69#2,5:113\n*E\n"})
    public static final class b<T> implements e<h0<? extends T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f38588a;

        public b(e eVar) {
            this.f38588a = eVar;
        }

        @Override // kotlinx.coroutines.flow.e
        @yt.l
        public Object a(@yt.k f<? super h0<? extends T>> fVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
            Object objA = this.f38588a.a(new FlowKt__TransformKt$withIndex$1$1(fVar, new Ref.IntRef()), cVar);
            return objA == yj.b.h() ? objA : z1.f38230a;
        }
    }

    @yt.k
    public static final <T> e<T> a(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar) {
        return new FlowKt__TransformKt$filter$$inlined$unsafeTransform$1(eVar, pVar);
    }

    public static final /* synthetic */ <R> e<R> b(e<?> eVar) {
        f0.w();
        return new FlowKt__TransformKt$filterIsInstance$$inlined$filter$1(eVar);
    }

    @yt.k
    public static final <R> e<R> c(@yt.k final e<?> eVar, @yt.k final kotlin.reflect.d<R> dVar) {
        return (e<R>) new e<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2, reason: invalid class name */
            @t0({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n22#2:223\n41#2:224\n23#2:225\n*E\n"})
            public static final class AnonymousClass2<T> implements f {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ f f38597a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ kotlin.reflect.d f38598b;

                /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2$1, reason: invalid class name */
                @t0({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                @zj.d(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2", f = "Transform.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    public Object L$0;
                    public Object L$1;
                    public int label;
                    public /* synthetic */ Object result;

                    public AnonymousClass1(kotlin.coroutines.c cVar) {
                        super(cVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @yt.l
                    public final Object q0(@yt.k Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.f(null, this);
                    }
                }

                public AnonymousClass2(f fVar, kotlin.reflect.d dVar) {
                    this.f38597a = fVar;
                    this.f38598b = dVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.f
                @yt.l
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object f(java.lang.Object r5, @yt.k kotlin.coroutines.c r6) throws java.lang.Throwable {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = yj.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.u0.n(r6)
                        goto L47
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.u0.n(r6)
                        kotlinx.coroutines.flow.f r6 = r4.f38597a
                        kotlin.reflect.d r2 = r4.f38598b
                        boolean r2 = r2.x0(r5)
                        if (r2 == 0) goto L47
                        r0.label = r3
                        java.lang.Object r5 = r6.f(r5, r0)
                        if (r5 != r1) goto L47
                        return r1
                    L47:
                        kotlin.z1 r5 = kotlin.z1.f38230a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2.AnonymousClass2.f(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.e
            @yt.l
            public Object a(@yt.k f<? super Object> fVar, @yt.k kotlin.coroutines.c cVar) {
                Object objA = eVar.a(new AnonymousClass2(fVar, dVar), cVar);
                return objA == yj.b.h() ? objA : z1.f38230a;
            }
        };
    }

    @yt.k
    public static final <T> e<T> d(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar) {
        return new FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1(eVar, pVar);
    }

    @yt.k
    public static final <T> e<T> e(@yt.k final e<? extends T> eVar) {
        return new e<T>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2, reason: invalid class name */
            @t0({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n47#2,2:223\n*E\n"})
            public static final class AnonymousClass2<T> implements f {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ f f38604a;

                /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1, reason: invalid class name */
                @t0({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                @zj.d(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2", f = "Transform.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    public int label;
                    public /* synthetic */ Object result;

                    public AnonymousClass1(kotlin.coroutines.c cVar) {
                        super(cVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @yt.l
                    public final Object q0(@yt.k Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.f(null, this);
                    }
                }

                public AnonymousClass2(f fVar) {
                    this.f38604a = fVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.f
                @yt.l
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object f(T r5, @yt.k kotlin.coroutines.c<? super kotlin.z1> r6) throws java.lang.Throwable {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = yj.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.u0.n(r6)
                        goto L41
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.u0.n(r6)
                        kotlinx.coroutines.flow.f r6 = r4.f38604a
                        if (r5 == 0) goto L41
                        r0.label = r3
                        java.lang.Object r5 = r6.f(r5, r0)
                        if (r5 != r1) goto L41
                        return r1
                    L41:
                        kotlin.z1 r5 = kotlin.z1.f38230a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1.AnonymousClass2.f(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.e
            @yt.l
            public Object a(@yt.k f fVar, @yt.k kotlin.coroutines.c cVar) {
                Object objA = eVar.a(new AnonymousClass2(fVar), cVar);
                return objA == yj.b.h() ? objA : z1.f38230a;
            }
        };
    }

    @yt.k
    public static final <T, R> e<R> f(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        return new FlowKt__TransformKt$map$$inlined$unsafeTransform$1(eVar, pVar);
    }

    @yt.k
    public static final <T, R> e<R> g(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        return new FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1(eVar, pVar);
    }

    @yt.k
    public static final <T> e<T> h(@yt.k final e<? extends T> eVar, @yt.k final ik.p<? super T, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar) {
        return new e<T>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2, reason: invalid class name */
            @t0({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n79#2,2:223\n*E\n"})
            public static final class AnonymousClass2<T> implements f {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ f f38615a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ ik.p f38616b;

                /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1, reason: invalid class name */
                @t0({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                @zj.d(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2", f = "Transform.kt", i = {0, 0}, l = {223, 224}, m = "emit", n = {"value", "$this$onEach_u24lambda_u248"}, s = {"L$0", "L$1"})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    public Object L$0;
                    public Object L$1;
                    public int label;
                    public /* synthetic */ Object result;

                    public AnonymousClass1(kotlin.coroutines.c cVar) {
                        super(cVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @yt.l
                    public final Object q0(@yt.k Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.f(null, this);
                    }
                }

                public AnonymousClass2(f fVar, ik.p pVar) {
                    this.f38615a = fVar;
                    this.f38616b = pVar;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.f
                @yt.l
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object f(T r6, @yt.k kotlin.coroutines.c<? super kotlin.z1> r7) throws java.lang.Throwable {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        java.lang.Object r1 = yj.b.h()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L3e
                        if (r2 == r4) goto L34
                        if (r2 != r3) goto L2c
                        kotlin.u0.n(r7)
                        goto L6a
                    L2c:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L34:
                        java.lang.Object r6 = r0.L$1
                        kotlinx.coroutines.flow.f r6 = (kotlinx.coroutines.flow.f) r6
                        java.lang.Object r2 = r0.L$0
                        kotlin.u0.n(r7)
                        goto L5c
                    L3e:
                        kotlin.u0.n(r7)
                        kotlinx.coroutines.flow.f r7 = r5.f38615a
                        ik.p r2 = r5.f38616b
                        r0.L$0 = r6
                        r0.L$1 = r7
                        r0.label = r4
                        r4 = 6
                        kotlin.jvm.internal.c0.e(r4)
                        java.lang.Object r2 = r2.r0(r6, r0)
                        r4 = 7
                        kotlin.jvm.internal.c0.e(r4)
                        if (r2 != r1) goto L5a
                        return r1
                    L5a:
                        r2 = r6
                        r6 = r7
                    L5c:
                        r7 = 0
                        r0.L$0 = r7
                        r0.L$1 = r7
                        r0.label = r3
                        java.lang.Object r6 = r6.f(r2, r0)
                        if (r6 != r1) goto L6a
                        return r1
                    L6a:
                        kotlin.z1 r6 = kotlin.z1.f38230a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2.f(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.e
            @yt.l
            public Object a(@yt.k f fVar, @yt.k kotlin.coroutines.c cVar) {
                Object objA = eVar.a(new AnonymousClass2(fVar, pVar), cVar);
                return objA == yj.b.h() ? objA : z1.f38230a;
            }
        };
    }

    @yt.k
    public static final <T, R> e<R> i(@yt.k e<? extends T> eVar, R r10, @kotlin.b @yt.k ik.q<? super R, ? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar) {
        return new FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1(r10, eVar, qVar);
    }

    @yt.k
    public static final <T> e<T> j(@yt.k e<? extends T> eVar, @yt.k ik.q<? super T, ? super T, ? super kotlin.coroutines.c<? super T>, ? extends Object> qVar) {
        return new a(eVar, qVar);
    }

    @yt.k
    public static final <T, R> e<R> k(@yt.k e<? extends T> eVar, R r10, @kotlin.b @yt.k ik.q<? super R, ? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar) {
        return g.z1(eVar, r10, qVar);
    }

    @yt.k
    public static final <T> e<h0<T>> l(@yt.k e<? extends T> eVar) {
        return new b(eVar);
    }
}
