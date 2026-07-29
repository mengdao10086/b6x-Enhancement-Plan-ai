package kotlinx.coroutines.flow;

import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,332:1\n272#1,3:334\n272#1,3:337\n261#1:340\n263#1:342\n272#1,3:343\n261#1:346\n263#1:348\n272#1,3:349\n261#1:352\n263#1:354\n272#1,3:355\n106#2:333\n106#2:341\n106#2:347\n106#2:353\n106#2:358\n106#2:359\n106#2:362\n37#3,2:360\n37#3,2:363\n*S KotlinDebug\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n75#1:334,3\n103#1:337,3\n119#1:340\n119#1:342\n138#1:343,3\n156#1:346\n156#1:348\n177#1:349,3\n197#1:352\n197#1:354\n220#1:355,3\n32#1:333\n119#1:341\n156#1:347\n197#1:353\n237#1:358\n261#1:359\n288#1:362\n287#1:360,2\n306#1:363,2\n*E\n"})
public final /* synthetic */ class FlowKt__ZipKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    @t0({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,112:1\n33#2,2:113\n*E\n"})
    public static final class a<R> implements e<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f38628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f38629b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ik.q f38630c;

        public a(e eVar, e eVar2, ik.q qVar) {
            this.f38628a = eVar;
            this.f38629b = eVar2;
            this.f38630c = qVar;
        }

        @Override // kotlinx.coroutines.flow.e
        @yt.l
        public Object a(@yt.k f<? super R> fVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
            Object objA = CombineKt.a(fVar, new e[]{this.f38628a, this.f38629b}, FlowKt__ZipKt.r(), new FlowKt__ZipKt$combine$1$1(this.f38630c, null), cVar);
            return objA == yj.b.h() ? objA : z1.f38230a;
        }
    }

    public static final /* synthetic */ <T, R> e<R> b(Iterable<? extends e<? extends T>> iterable, ik.p<? super T[], ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        e[] eVarArr = (e[]) CollectionsKt___CollectionsKt.Q5(iterable).toArray(new e[0]);
        f0.w();
        return new FlowKt__ZipKt$combine$$inlined$unsafeFlow$3(eVarArr, pVar);
    }

    @yt.k
    public static final <T1, T2, R> e<R> c(@yt.k e<? extends T1> eVar, @yt.k e<? extends T2> eVar2, @yt.k ik.q<? super T1, ? super T2, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar) {
        return g.K0(eVar, eVar2, qVar);
    }

    @yt.k
    public static final <T1, T2, T3, R> e<R> d(@yt.k e<? extends T1> eVar, @yt.k e<? extends T2> eVar2, @yt.k e<? extends T3> eVar3, @kotlin.b @yt.k final ik.r<? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.c<? super R>, ? extends Object> rVar) {
        final e[] eVarArr = {eVar, eVar2, eVar3};
        return new e<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2, reason: invalid class name */
            @t0({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$1$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,332:1\n120#2,4:333\n*E\n"})
            @zj.d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2", f = "Zip.kt", i = {}, l = {333, gg.b.f29481r}, m = "invokeSuspend", n = {}, s = {})
            public static final class AnonymousClass2 extends SuspendLambda implements ik.q<f<? super R>, Object[], kotlin.coroutines.c<? super z1>, Object> {
                public final /* synthetic */ ik.r $transform$inlined;
                private /* synthetic */ Object L$0;
                public /* synthetic */ Object L$1;
                public int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(kotlin.coroutines.c cVar, ik.r rVar) {
                    super(3, cVar);
                    this.$transform$inlined = rVar;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @yt.l
                public final Object q0(@yt.k Object obj) throws Throwable {
                    f fVar;
                    Object objH = yj.b.h();
                    int i10 = this.label;
                    if (i10 == 0) {
                        u0.n(obj);
                        fVar = (f) this.L$0;
                        Object[] objArr = (Object[]) this.L$1;
                        ik.r rVar = this.$transform$inlined;
                        Object obj2 = objArr[0];
                        Object obj3 = objArr[1];
                        Object obj4 = objArr[2];
                        this.L$0 = fVar;
                        this.label = 1;
                        c0.e(6);
                        obj = rVar.N(obj2, obj3, obj4, this);
                        c0.e(7);
                        if (obj == objH) {
                            return objH;
                        }
                    } else {
                        if (i10 != 1) {
                            if (i10 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            u0.n(obj);
                            return z1.f38230a;
                        }
                        fVar = (f) this.L$0;
                        u0.n(obj);
                    }
                    this.L$0 = null;
                    this.label = 2;
                    if (fVar.f(obj, this) == objH) {
                        return objH;
                    }
                    return z1.f38230a;
                }

                @Override // ik.q
                @yt.l
                /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
                public final Object A(@yt.k f<? super R> fVar, @yt.k Object[] objArr, @yt.l kotlin.coroutines.c<? super z1> cVar) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(cVar, this.$transform$inlined);
                    anonymousClass2.L$0 = fVar;
                    anonymousClass2.L$1 = objArr;
                    return anonymousClass2.q0(z1.f38230a);
                }
            }

            @Override // kotlinx.coroutines.flow.e
            @yt.l
            public Object a(@yt.k f fVar, @yt.k kotlin.coroutines.c cVar) {
                Object objA = CombineKt.a(fVar, eVarArr, FlowKt__ZipKt.r(), new AnonymousClass2(null, rVar), cVar);
                return objA == yj.b.h() ? objA : z1.f38230a;
            }
        };
    }

    @yt.k
    public static final <T1, T2, T3, T4, R> e<R> e(@yt.k e<? extends T1> eVar, @yt.k e<? extends T2> eVar2, @yt.k e<? extends T3> eVar3, @yt.k e<? extends T4> eVar4, @yt.k final ik.s<? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.c<? super R>, ? extends Object> sVar) {
        final e[] eVarArr = {eVar, eVar2, eVar3, eVar4};
        return new e<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2, reason: invalid class name */
            @t0({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$1$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,332:1\n157#2,5:333\n*E\n"})
            @zj.d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2", f = "Zip.kt", i = {}, l = {333, gg.b.f29481r}, m = "invokeSuspend", n = {}, s = {})
            public static final class AnonymousClass2 extends SuspendLambda implements ik.q<f<? super R>, Object[], kotlin.coroutines.c<? super z1>, Object> {
                public final /* synthetic */ ik.s $transform$inlined;
                private /* synthetic */ Object L$0;
                public /* synthetic */ Object L$1;
                public int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(kotlin.coroutines.c cVar, ik.s sVar) {
                    super(3, cVar);
                    this.$transform$inlined = sVar;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @yt.l
                public final Object q0(@yt.k Object obj) throws Throwable {
                    f fVar;
                    Object objH = yj.b.h();
                    int i10 = this.label;
                    if (i10 == 0) {
                        u0.n(obj);
                        fVar = (f) this.L$0;
                        Object[] objArr = (Object[]) this.L$1;
                        ik.s sVar = this.$transform$inlined;
                        Object obj2 = objArr[0];
                        Object obj3 = objArr[1];
                        Object obj4 = objArr[2];
                        Object obj5 = objArr[3];
                        this.L$0 = fVar;
                        this.label = 1;
                        c0.e(6);
                        obj = sVar.w0(obj2, obj3, obj4, obj5, this);
                        c0.e(7);
                        if (obj == objH) {
                            return objH;
                        }
                    } else {
                        if (i10 != 1) {
                            if (i10 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            u0.n(obj);
                            return z1.f38230a;
                        }
                        fVar = (f) this.L$0;
                        u0.n(obj);
                    }
                    this.L$0 = null;
                    this.label = 2;
                    if (fVar.f(obj, this) == objH) {
                        return objH;
                    }
                    return z1.f38230a;
                }

                @Override // ik.q
                @yt.l
                /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
                public final Object A(@yt.k f<? super R> fVar, @yt.k Object[] objArr, @yt.l kotlin.coroutines.c<? super z1> cVar) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(cVar, this.$transform$inlined);
                    anonymousClass2.L$0 = fVar;
                    anonymousClass2.L$1 = objArr;
                    return anonymousClass2.q0(z1.f38230a);
                }
            }

            @Override // kotlinx.coroutines.flow.e
            @yt.l
            public Object a(@yt.k f fVar, @yt.k kotlin.coroutines.c cVar) {
                Object objA = CombineKt.a(fVar, eVarArr, FlowKt__ZipKt.r(), new AnonymousClass2(null, sVar), cVar);
                return objA == yj.b.h() ? objA : z1.f38230a;
            }
        };
    }

    @yt.k
    public static final <T1, T2, T3, T4, T5, R> e<R> f(@yt.k e<? extends T1> eVar, @yt.k e<? extends T2> eVar2, @yt.k e<? extends T3> eVar3, @yt.k e<? extends T4> eVar4, @yt.k e<? extends T5> eVar5, @yt.k final ik.t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.c<? super R>, ? extends Object> tVar) {
        final e[] eVarArr = {eVar, eVar2, eVar3, eVar4, eVar5};
        return new e<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$2, reason: invalid class name */
            @t0({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$1$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,332:1\n198#2,6:333\n*E\n"})
            @zj.d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$2", f = "Zip.kt", i = {}, l = {333, gg.b.f29481r}, m = "invokeSuspend", n = {}, s = {})
            public static final class AnonymousClass2 extends SuspendLambda implements ik.q<f<? super R>, Object[], kotlin.coroutines.c<? super z1>, Object> {
                public final /* synthetic */ ik.t $transform$inlined;
                private /* synthetic */ Object L$0;
                public /* synthetic */ Object L$1;
                public int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(kotlin.coroutines.c cVar, ik.t tVar) {
                    super(3, cVar);
                    this.$transform$inlined = tVar;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @yt.l
                public final Object q0(@yt.k Object obj) throws Throwable {
                    f fVar;
                    Object objH = yj.b.h();
                    int i10 = this.label;
                    if (i10 == 0) {
                        u0.n(obj);
                        fVar = (f) this.L$0;
                        Object[] objArr = (Object[]) this.L$1;
                        ik.t tVar = this.$transform$inlined;
                        Object obj2 = objArr[0];
                        Object obj3 = objArr[1];
                        Object obj4 = objArr[2];
                        Object obj5 = objArr[3];
                        Object obj6 = objArr[4];
                        this.L$0 = fVar;
                        this.label = 1;
                        c0.e(6);
                        obj = tVar.m0(obj2, obj3, obj4, obj5, obj6, this);
                        c0.e(7);
                        if (obj == objH) {
                            return objH;
                        }
                    } else {
                        if (i10 != 1) {
                            if (i10 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            u0.n(obj);
                            return z1.f38230a;
                        }
                        fVar = (f) this.L$0;
                        u0.n(obj);
                    }
                    this.L$0 = null;
                    this.label = 2;
                    if (fVar.f(obj, this) == objH) {
                        return objH;
                    }
                    return z1.f38230a;
                }

                @Override // ik.q
                @yt.l
                /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
                public final Object A(@yt.k f<? super R> fVar, @yt.k Object[] objArr, @yt.l kotlin.coroutines.c<? super z1> cVar) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(cVar, this.$transform$inlined);
                    anonymousClass2.L$0 = fVar;
                    anonymousClass2.L$1 = objArr;
                    return anonymousClass2.q0(z1.f38230a);
                }
            }

            @Override // kotlinx.coroutines.flow.e
            @yt.l
            public Object a(@yt.k f fVar, @yt.k kotlin.coroutines.c cVar) {
                Object objA = CombineKt.a(fVar, eVarArr, FlowKt__ZipKt.r(), new AnonymousClass2(null, tVar), cVar);
                return objA == yj.b.h() ? objA : z1.f38230a;
            }
        };
    }

    public static final /* synthetic */ <T, R> e<R> g(e<? extends T>[] eVarArr, ik.p<? super T[], ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        f0.w();
        return new FlowKt__ZipKt$combine$$inlined$unsafeFlow$2(eVarArr, pVar);
    }

    public static final /* synthetic */ <T, R> e<R> h(Iterable<? extends e<? extends T>> iterable, @kotlin.b ik.q<? super f<? super R>, ? super T[], ? super kotlin.coroutines.c<? super z1>, ? extends Object> qVar) {
        e[] eVarArr = (e[]) CollectionsKt___CollectionsKt.Q5(iterable).toArray(new e[0]);
        f0.w();
        return g.J0(new FlowKt__ZipKt$combineTransform$7(eVarArr, qVar, null));
    }

    @yt.k
    public static final <T1, T2, R> e<R> i(@yt.k e<? extends T1> eVar, @yt.k e<? extends T2> eVar2, @kotlin.b @yt.k ik.r<? super f<? super R>, ? super T1, ? super T2, ? super kotlin.coroutines.c<? super z1>, ? extends Object> rVar) {
        return g.J0(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$2(new e[]{eVar, eVar2}, null, rVar));
    }

    @yt.k
    public static final <T1, T2, T3, R> e<R> j(@yt.k e<? extends T1> eVar, @yt.k e<? extends T2> eVar2, @yt.k e<? extends T3> eVar3, @kotlin.b @yt.k ik.s<? super f<? super R>, ? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.c<? super z1>, ? extends Object> sVar) {
        return g.J0(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3(new e[]{eVar, eVar2, eVar3}, null, sVar));
    }

    @yt.k
    public static final <T1, T2, T3, T4, R> e<R> k(@yt.k e<? extends T1> eVar, @yt.k e<? extends T2> eVar2, @yt.k e<? extends T3> eVar3, @yt.k e<? extends T4> eVar4, @kotlin.b @yt.k ik.t<? super f<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.c<? super z1>, ? extends Object> tVar) {
        return g.J0(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4(new e[]{eVar, eVar2, eVar3, eVar4}, null, tVar));
    }

    @yt.k
    public static final <T1, T2, T3, T4, T5, R> e<R> l(@yt.k e<? extends T1> eVar, @yt.k e<? extends T2> eVar2, @yt.k e<? extends T3> eVar3, @yt.k e<? extends T4> eVar4, @yt.k e<? extends T5> eVar5, @kotlin.b @yt.k ik.u<? super f<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.c<? super z1>, ? extends Object> uVar) {
        return g.J0(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5(new e[]{eVar, eVar2, eVar3, eVar4, eVar5}, null, uVar));
    }

    public static final /* synthetic */ <T, R> e<R> m(e<? extends T>[] eVarArr, @kotlin.b ik.q<? super f<? super R>, ? super T[], ? super kotlin.coroutines.c<? super z1>, ? extends Object> qVar) {
        f0.w();
        return g.J0(new FlowKt__ZipKt$combineTransform$6(eVarArr, qVar, null));
    }

    public static final /* synthetic */ <T, R> e<R> n(e<? extends T>[] eVarArr, @kotlin.b ik.q<? super f<? super R>, ? super T[], ? super kotlin.coroutines.c<? super z1>, ? extends Object> qVar) {
        f0.w();
        return g.J0(new FlowKt__ZipKt$combineTransformUnsafe$1(eVarArr, qVar, null));
    }

    public static final /* synthetic */ <T, R> e<R> o(e<? extends T>[] eVarArr, ik.p<? super T[], ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        f0.w();
        return new FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1(eVarArr, pVar);
    }

    @hk.h(name = "flowCombine")
    @yt.k
    public static final <T1, T2, R> e<R> p(@yt.k e<? extends T1> eVar, @yt.k e<? extends T2> eVar2, @yt.k ik.q<? super T1, ? super T2, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar) {
        return new a(eVar, eVar2, qVar);
    }

    @hk.h(name = "flowCombineTransform")
    @yt.k
    public static final <T1, T2, R> e<R> q(@yt.k e<? extends T1> eVar, @yt.k e<? extends T2> eVar2, @kotlin.b @yt.k ik.r<? super f<? super R>, ? super T1, ? super T2, ? super kotlin.coroutines.c<? super z1>, ? extends Object> rVar) {
        return g.J0(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$1(new e[]{eVar, eVar2}, null, rVar));
    }

    public static final <T> ik.a<T[]> r() {
        return new ik.a() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$nullArrayFactory$1
            @Override // ik.a
            @yt.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Void o() {
                return null;
            }
        };
    }

    @yt.k
    public static final <T1, T2, R> e<R> s(@yt.k e<? extends T1> eVar, @yt.k e<? extends T2> eVar2, @yt.k ik.q<? super T1, ? super T2, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar) {
        return CombineKt.b(eVar, eVar2, qVar);
    }
}
