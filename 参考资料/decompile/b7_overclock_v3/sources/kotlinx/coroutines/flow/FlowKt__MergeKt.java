package kotlinx.coroutines.flow;

import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import kotlinx.coroutines.flow.internal.ChannelFlowMerge;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge;
import kotlinx.coroutines.internal.r0;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.t1;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nMerge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,218:1\n53#2:219\n55#2:223\n53#2:224\n55#2:228\n50#3:220\n55#3:222\n50#3:225\n55#3:227\n106#4:221\n106#4:226\n106#4:229\n1#5:230\n*S KotlinDebug\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt\n*L\n47#1:219\n47#1:223\n74#1:224\n74#1:228\n47#1:220\n47#1:222\n74#1:225\n74#1:227\n47#1:221\n74#1:226\n82#1:229\n*E\n"})
public final /* synthetic */ class FlowKt__MergeKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38556a = r0.b(g.f38672a, 16, 1, Integer.MAX_VALUE);

    /* JADX INFO: Add missing generic type declarations: [T] */
    @t0({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt\n*L\n1#1,112:1\n83#2,2:113\n*E\n"})
    public static final class a<T> implements e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f38557a;

        public a(e eVar) {
            this.f38557a = eVar;
        }

        @Override // kotlinx.coroutines.flow.e
        @yt.l
        public Object a(@yt.k f<? super T> fVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
            Object objA = this.f38557a.a(new FlowKt__MergeKt$flattenConcat$1$1(fVar), cVar);
            return objA == yj.b.h() ? objA : z1.f38230a;
        }
    }

    @s1
    @yt.k
    public static final <T, R> e<R> a(@yt.k final e<? extends T> eVar, @yt.k final ik.p<? super T, ? super kotlin.coroutines.c<? super e<? extends R>>, ? extends Object> pVar) {
        return g.G0(new e<e<? extends R>>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2, reason: invalid class name */
            @t0({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n54#2:223\n*E\n"})
            public static final class AnonymousClass2<T> implements f {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ f f38560a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ ik.p f38561b;

                /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1, reason: invalid class name */
                @t0({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                @zj.d(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2", f = "Merge.kt", i = {}, l = {223, 223}, m = "emit", n = {}, s = {})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    public Object L$0;
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
                    this.f38560a = fVar;
                    this.f38561b = pVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.f
                @yt.l
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object f(java.lang.Object r7, @yt.k kotlin.coroutines.c r8) throws java.lang.Throwable {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.result
                        java.lang.Object r1 = yj.b.h()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L3c
                        if (r2 == r4) goto L34
                        if (r2 != r3) goto L2c
                        kotlin.u0.n(r8)
                        goto L5d
                    L2c:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L34:
                        java.lang.Object r7 = r0.L$0
                        kotlinx.coroutines.flow.f r7 = (kotlinx.coroutines.flow.f) r7
                        kotlin.u0.n(r8)
                        goto L51
                    L3c:
                        kotlin.u0.n(r8)
                        kotlinx.coroutines.flow.f r8 = r6.f38560a
                        ik.p r2 = r6.f38561b
                        r0.L$0 = r8
                        r0.label = r4
                        java.lang.Object r7 = r2.r0(r7, r0)
                        if (r7 != r1) goto L4e
                        return r1
                    L4e:
                        r5 = r8
                        r8 = r7
                        r7 = r5
                    L51:
                        r2 = 0
                        r0.L$0 = r2
                        r0.label = r3
                        java.lang.Object r7 = r7.f(r8, r0)
                        if (r7 != r1) goto L5d
                        return r1
                    L5d:
                        kotlin.z1 r7 = kotlin.z1.f38230a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.AnonymousClass2.f(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.e
            @yt.l
            public Object a(@yt.k f fVar, @yt.k kotlin.coroutines.c cVar) {
                Object objA = eVar.a(new AnonymousClass2(fVar, pVar), cVar);
                return objA == yj.b.h() ? objA : z1.f38230a;
            }
        });
    }

    @s1
    @yt.k
    public static final <T, R> e<R> b(@yt.k e<? extends T> eVar, @kotlin.b @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super e<? extends R>>, ? extends Object> pVar) {
        return g.d2(eVar, new FlowKt__MergeKt$flatMapLatest$1(pVar, null));
    }

    @s1
    @yt.k
    public static final <T, R> e<R> c(@yt.k final e<? extends T> eVar, int i10, @yt.k final ik.p<? super T, ? super kotlin.coroutines.c<? super e<? extends R>>, ? extends Object> pVar) {
        return g.H0(new e<e<? extends R>>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2, reason: invalid class name */
            @t0({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n54#2:223\n*E\n"})
            public static final class AnonymousClass2<T> implements f {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ f f38564a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ ik.p f38565b;

                /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1, reason: invalid class name */
                @t0({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                @zj.d(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2", f = "Merge.kt", i = {}, l = {223, 223}, m = "emit", n = {}, s = {})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    public Object L$0;
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
                    this.f38564a = fVar;
                    this.f38565b = pVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.f
                @yt.l
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object f(java.lang.Object r7, @yt.k kotlin.coroutines.c r8) throws java.lang.Throwable {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.result
                        java.lang.Object r1 = yj.b.h()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L3c
                        if (r2 == r4) goto L34
                        if (r2 != r3) goto L2c
                        kotlin.u0.n(r8)
                        goto L5d
                    L2c:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L34:
                        java.lang.Object r7 = r0.L$0
                        kotlinx.coroutines.flow.f r7 = (kotlinx.coroutines.flow.f) r7
                        kotlin.u0.n(r8)
                        goto L51
                    L3c:
                        kotlin.u0.n(r8)
                        kotlinx.coroutines.flow.f r8 = r6.f38564a
                        ik.p r2 = r6.f38565b
                        r0.L$0 = r8
                        r0.label = r4
                        java.lang.Object r7 = r2.r0(r7, r0)
                        if (r7 != r1) goto L4e
                        return r1
                    L4e:
                        r5 = r8
                        r8 = r7
                        r7 = r5
                    L51:
                        r2 = 0
                        r0.L$0 = r2
                        r0.label = r3
                        java.lang.Object r7 = r7.f(r8, r0)
                        if (r7 != r1) goto L5d
                        return r1
                    L5d:
                        kotlin.z1 r7 = kotlin.z1.f38230a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2.f(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.e
            @yt.l
            public Object a(@yt.k f fVar, @yt.k kotlin.coroutines.c cVar) {
                Object objA = eVar.a(new AnonymousClass2(fVar, pVar), cVar);
                return objA == yj.b.h() ? objA : z1.f38230a;
            }
        }, i10);
    }

    public static /* synthetic */ e d(e eVar, int i10, ik.p pVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = f38556a;
        }
        return g.D0(eVar, i10, pVar);
    }

    @s1
    @yt.k
    public static final <T> e<T> e(@yt.k e<? extends e<? extends T>> eVar) {
        return new a(eVar);
    }

    @s1
    @yt.k
    public static final <T> e<T> f(@yt.k e<? extends e<? extends T>> eVar, int i10) {
        if (i10 > 0) {
            return i10 == 1 ? g.G0(eVar) : new ChannelFlowMerge(eVar, i10, null, 0, null, 28, null);
        }
        throw new IllegalArgumentException(("Expected positive concurrency level, but had " + i10).toString());
    }

    public static /* synthetic */ e g(e eVar, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = f38556a;
        }
        return g.H0(eVar, i10);
    }

    public static final int h() {
        return f38556a;
    }

    @t1
    public static /* synthetic */ void i() {
    }

    @t1
    public static /* synthetic */ void j() {
    }

    @s1
    @yt.k
    public static final <T, R> e<R> k(@yt.k e<? extends T> eVar, @kotlin.b @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        return g.d2(eVar, new FlowKt__MergeKt$mapLatest$1(pVar, null));
    }

    @yt.k
    public static final <T> e<T> l(@yt.k Iterable<? extends e<? extends T>> iterable) {
        return new ChannelLimitedFlowMerge(iterable, null, 0, null, 14, null);
    }

    @yt.k
    public static final <T> e<T> m(@yt.k e<? extends T>... eVarArr) {
        return g.Z0(ArraysKt___ArraysKt.c6(eVarArr));
    }

    @s1
    @yt.k
    public static final <T, R> e<R> n(@yt.k e<? extends T> eVar, @kotlin.b @yt.k ik.q<? super f<? super R>, ? super T, ? super kotlin.coroutines.c<? super z1>, ? extends Object> qVar) {
        return new ChannelFlowTransformLatest(qVar, eVar, null, 0, null, 28, null);
    }
}
