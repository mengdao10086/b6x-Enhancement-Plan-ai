package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,141:1\n1#2:142\n106#3:143\n106#3:144\n106#3:145\n106#3:146\n*S KotlinDebug\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n22#1:143\n33#1:144\n52#1:145\n83#1:146\n*E\n"})
public final /* synthetic */ class FlowKt__LimitKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @t0({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n1#1,112:1\n23#2,5:113\n*E\n"})
    public static final class a<T> implements e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f38534a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f38535b;

        public a(e eVar, int i10) {
            this.f38534a = eVar;
            this.f38535b = i10;
        }

        @Override // kotlinx.coroutines.flow.e
        @yt.l
        public Object a(@yt.k f<? super T> fVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
            Object objA = this.f38534a.a(new FlowKt__LimitKt$drop$2$1(new Ref.IntRef(), this.f38535b, fVar), cVar);
            return objA == yj.b.h() ? objA : z1.f38230a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @t0({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n1#1,112:1\n34#2,10:113\n*E\n"})
    public static final class b<T> implements e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f38536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ik.p f38537b;

        public b(e eVar, ik.p pVar) {
            this.f38536a = eVar;
            this.f38537b = pVar;
        }

        @Override // kotlinx.coroutines.flow.e
        @yt.l
        public Object a(@yt.k f<? super T> fVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
            Object objA = this.f38536a.a(new FlowKt__LimitKt$dropWhile$1$1(new Ref.BooleanRef(), fVar, this.f38537b), cVar);
            return objA == yj.b.h() ? objA : z1.f38230a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object b(@yt.k kotlinx.coroutines.flow.e<? extends T> r4, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super java.lang.Boolean>, ? extends java.lang.Object> r5, @yt.k kotlin.coroutines.c<? super kotlin.z1> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1 r4 = (kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1) r4
            kotlin.u0.n(r6)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L2d
            goto L4f
        L2d:
            r5 = move-exception
            goto L4c
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.u0.n(r6)
            kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1 r6 = new kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1
            r6.<init>(r5)
            r0.L$0 = r6     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L4a
            r0.label = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L4a
            java.lang.Object r4 = r4.a(r6, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L4a
            if (r4 != r1) goto L4f
            return r1
        L4a:
            r5 = move-exception
            r4 = r6
        L4c:
            kotlinx.coroutines.flow.internal.h.b(r5, r4)
        L4f:
            kotlin.z1 r4 = kotlin.z1.f38230a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt.b(kotlinx.coroutines.flow.e, ik.p, kotlin.coroutines.c):java.lang.Object");
    }

    public static final <T> Object c(e<? extends T> eVar, ik.p<? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar, kotlin.coroutines.c<? super z1> cVar) {
        FlowKt__LimitKt$collectWhile$collector$1 flowKt__LimitKt$collectWhile$collector$1 = new FlowKt__LimitKt$collectWhile$collector$1(pVar);
        try {
            c0.e(0);
            eVar.a(flowKt__LimitKt$collectWhile$collector$1, cVar);
            c0.e(1);
        } catch (AbortFlowException e10) {
            kotlinx.coroutines.flow.internal.h.b(e10, flowKt__LimitKt$collectWhile$collector$1);
        }
        return z1.f38230a;
    }

    @yt.k
    public static final <T> e<T> d(@yt.k e<? extends T> eVar, int i10) {
        if (i10 >= 0) {
            return new a(eVar, i10);
        }
        throw new IllegalArgumentException(("Drop count should be non-negative, but had " + i10).toString());
    }

    @yt.k
    public static final <T> e<T> e(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar) {
        return new b(eVar, pVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object f(kotlinx.coroutines.flow.f<? super T> r4, T r5, kotlin.coroutines.c<? super kotlin.z1> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$emitAbort$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__LimitKt$emitAbort$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$emitAbort$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__LimitKt$emitAbort$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$emitAbort$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2d:
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.flow.f r4 = (kotlinx.coroutines.flow.f) r4
            kotlin.u0.n(r6)
            goto L43
        L35:
            kotlin.u0.n(r6)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.f(r5, r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            kotlinx.coroutines.flow.internal.AbortFlowException r5 = new kotlinx.coroutines.flow.internal.AbortFlowException
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt.f(kotlinx.coroutines.flow.f, java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }

    @yt.k
    public static final <T> e<T> g(@yt.k e<? extends T> eVar, int i10) {
        if (i10 > 0) {
            return new FlowKt__LimitKt$take$$inlined$unsafeFlow$1(eVar, i10);
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " should be positive").toString());
    }

    @yt.k
    public static final <T> e<T> h(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar) {
        return new FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1(eVar, pVar);
    }

    @yt.k
    public static final <T, R> e<R> i(@yt.k e<? extends T> eVar, @kotlin.b @yt.k ik.q<? super f<? super R>, ? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> qVar) {
        return g.J0(new FlowKt__LimitKt$transformWhile$1(eVar, qVar, null));
    }
}
