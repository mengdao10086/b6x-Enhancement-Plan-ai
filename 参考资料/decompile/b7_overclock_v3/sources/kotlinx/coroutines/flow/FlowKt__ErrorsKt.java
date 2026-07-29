package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import kotlinx.coroutines.c2;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nErrors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Errors.kt\nkotlinx/coroutines/flow/FlowKt__ErrorsKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,224:1\n106#2:225\n106#2:227\n1#3:226\n162#4:228\n*S KotlinDebug\n*F\n+ 1 Errors.kt\nkotlinx/coroutines/flow/FlowKt__ErrorsKt\n*L\n58#1:225\n132#1:227\n221#1:228\n*E\n"})
public final /* synthetic */ class FlowKt__ErrorsKt {
    @yt.k
    public static final <T> e<T> a(@yt.k e<? extends T> eVar, @yt.k ik.q<? super f<? super T>, ? super Throwable, ? super kotlin.coroutines.c<? super z1>, ? extends Object> qVar) {
        return new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(eVar, qVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object b(@yt.k kotlinx.coroutines.flow.e<? extends T> r4, @yt.k kotlinx.coroutines.flow.f<? super T> r5, @yt.k kotlin.coroutines.c<? super java.lang.Throwable> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1 r0 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1 r0 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.L$0
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            kotlin.u0.n(r6)     // Catch: java.lang.Throwable -> L2d
            goto L4f
        L2d:
            r5 = move-exception
            goto L53
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.u0.n(r6)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2 r2 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2     // Catch: java.lang.Throwable -> L51
            r2.<init>(r5, r6)     // Catch: java.lang.Throwable -> L51
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L51
            r0.label = r3     // Catch: java.lang.Throwable -> L51
            java.lang.Object r4 = r4.a(r2, r0)     // Catch: java.lang.Throwable -> L51
            if (r4 != r1) goto L4f
            return r1
        L4f:
            r4 = 0
            return r4
        L51:
            r5 = move-exception
            r4 = r6
        L53:
            T r4 = r4.element
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            boolean r6 = d(r5, r4)
            if (r6 != 0) goto L76
            kotlin.coroutines.CoroutineContext r6 = r0.b()
            boolean r6 = c(r5, r6)
            if (r6 != 0) goto L76
            if (r4 != 0) goto L6a
            return r5
        L6a:
            boolean r6 = r5 instanceof java.util.concurrent.CancellationException
            if (r6 == 0) goto L72
            kotlin.o.a(r4, r5)
            throw r4
        L72:
            kotlin.o.a(r5, r4)
            throw r5
        L76:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt.b(kotlinx.coroutines.flow.e, kotlinx.coroutines.flow.f, kotlin.coroutines.c):java.lang.Object");
    }

    public static final boolean c(Throwable th2, CoroutineContext coroutineContext) {
        c2 c2Var = (c2) coroutineContext.c(c2.f38296x2);
        if (c2Var == null || !c2Var.isCancelled()) {
            return false;
        }
        return d(th2, c2Var.Z());
    }

    public static final boolean d(Throwable th2, Throwable th3) {
        return th3 != null && f0.g(th3, th2);
    }

    @yt.k
    public static final <T> e<T> e(@yt.k e<? extends T> eVar, long j10, @yt.k ik.p<? super Throwable, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar) {
        if (j10 > 0) {
            return g.y1(eVar, new FlowKt__ErrorsKt$retry$3(j10, pVar, null));
        }
        throw new IllegalArgumentException(("Expected positive amount of retries, but had " + j10).toString());
    }

    public static /* synthetic */ e f(e eVar, long j10, ik.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = Long.MAX_VALUE;
        }
        if ((i10 & 2) != 0) {
            pVar = new FlowKt__ErrorsKt$retry$1(null);
        }
        return g.w1(eVar, j10, pVar);
    }

    @yt.k
    public static final <T> e<T> g(@yt.k e<? extends T> eVar, @yt.k ik.r<? super f<? super T>, ? super Throwable, ? super Long, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> rVar) {
        return new FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(eVar, rVar);
    }
}
