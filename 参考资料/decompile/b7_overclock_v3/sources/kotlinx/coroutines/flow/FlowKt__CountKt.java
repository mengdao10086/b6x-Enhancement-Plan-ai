package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Ref;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FlowKt__CountKt {

    public static final class a<T> implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f38505a;

        public a(Ref.IntRef intRef) {
            this.f38505a = intRef;
        }

        @Override // kotlinx.coroutines.flow.f
        @yt.l
        public final Object f(T t10, @yt.k kotlin.coroutines.c<? super z1> cVar) {
            this.f38505a.element++;
            return z1.f38230a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object a(@yt.k kotlinx.coroutines.flow.e<? extends T> r4, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super java.lang.Boolean>, ? extends java.lang.Object> r5, @yt.k kotlin.coroutines.c<? super java.lang.Integer> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__CountKt$count$3
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__CountKt$count$3 r0 = (kotlinx.coroutines.flow.FlowKt__CountKt$count$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__CountKt$count$3 r0 = new kotlinx.coroutines.flow.FlowKt__CountKt$count$3
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            kotlin.jvm.internal.Ref$IntRef r4 = (kotlin.jvm.internal.Ref.IntRef) r4
            kotlin.u0.n(r6)
            goto L4e
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.u0.n(r6)
            kotlin.jvm.internal.Ref$IntRef r6 = new kotlin.jvm.internal.Ref$IntRef
            r6.<init>()
            kotlinx.coroutines.flow.FlowKt__CountKt$count$4 r2 = new kotlinx.coroutines.flow.FlowKt__CountKt$count$4
            r2.<init>(r5, r6)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r4 = r4.a(r2, r0)
            if (r4 != r1) goto L4d
            return r1
        L4d:
            r4 = r6
        L4e:
            int r4 = r4.element
            java.lang.Integer r4 = zj.a.f(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__CountKt.a(kotlinx.coroutines.flow.e, ik.p, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object b(@yt.k kotlinx.coroutines.flow.e<? extends T> r4, @yt.k kotlin.coroutines.c<? super java.lang.Integer> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.FlowKt__CountKt$count$1
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__CountKt$count$1 r0 = (kotlinx.coroutines.flow.FlowKt__CountKt$count$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__CountKt$count$1 r0 = new kotlinx.coroutines.flow.FlowKt__CountKt$count$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            kotlin.jvm.internal.Ref$IntRef r4 = (kotlin.jvm.internal.Ref.IntRef) r4
            kotlin.u0.n(r5)
            goto L4e
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.u0.n(r5)
            kotlin.jvm.internal.Ref$IntRef r5 = new kotlin.jvm.internal.Ref$IntRef
            r5.<init>()
            kotlinx.coroutines.flow.FlowKt__CountKt$a r2 = new kotlinx.coroutines.flow.FlowKt__CountKt$a
            r2.<init>(r5)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r4 = r4.a(r2, r0)
            if (r4 != r1) goto L4d
            return r1
        L4d:
            r4 = r5
        L4e:
            int r4 = r4.element
            java.lang.Integer r4 = zj.a.f(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__CountKt.b(kotlinx.coroutines.flow.e, kotlin.coroutines.c):java.lang.Object");
    }
}
