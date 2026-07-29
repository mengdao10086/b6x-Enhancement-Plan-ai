package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nReduce.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt$fold$2\n*L\n1#1,172:1\n*E\n"})
public final class FlowKt__ReduceKt$fold$2<T> implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<R> f38578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ik.q<R, T, kotlin.coroutines.c<? super R>, Object> f38579b;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ReduceKt$fold$2(Ref.ObjectRef<R> objectRef, ik.q<? super R, ? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar) {
        this.f38578a = objectRef;
        this.f38579b = qVar;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @yt.l
    public final Object a(T t10, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        c0.e(4);
        new FlowKt__ReduceKt$fold$2$emit$1(this, cVar);
        c0.e(5);
        Ref.ObjectRef<R> objectRef = this.f38578a;
        objectRef.element = (T) this.f38579b.A((R) objectRef.element, t10, (kotlin.coroutines.c<? super R>) cVar);
        return z1.f38230a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlinx.coroutines.flow.f
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(T r7, @yt.k kotlin.coroutines.c<? super kotlin.z1> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2$emit$1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2$emit$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r7 = r0.L$0
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            kotlin.u0.n(r8)
            goto L4c
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.u0.n(r8)
            kotlin.jvm.internal.Ref$ObjectRef<R> r8 = r6.f38578a
            ik.q<R, T, kotlin.coroutines.c<? super R>, java.lang.Object> r2 = r6.f38579b
            T r4 = r8.element
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r7 = r2.A(r4, r7, r0)
            if (r7 != r1) goto L49
            return r1
        L49:
            r5 = r8
            r8 = r7
            r7 = r5
        L4c:
            r7.element = r8
            kotlin.z1 r7 = kotlin.z1.f38230a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2.f(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }
}
