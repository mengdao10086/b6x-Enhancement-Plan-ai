package kotlinx.coroutines.channels;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.y1;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nProduce.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Produce.kt\nkotlinx/coroutines/channels/ProduceKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,151:1\n1#2:152\n314#3,11:153\n*S KotlinDebug\n*F\n+ 1 Produce.kt\nkotlinx/coroutines/channels/ProduceKt\n*L\n48#1:153,11\n*E\n"})
public final class ProduceKt {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(@yt.k kotlinx.coroutines.channels.q<?> r4, @yt.k ik.a<kotlin.z1> r5, @yt.k kotlin.coroutines.c<? super kotlin.z1> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.channels.ProduceKt$awaitClose$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.channels.ProduceKt$awaitClose$1 r0 = (kotlinx.coroutines.channels.ProduceKt$awaitClose$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.ProduceKt$awaitClose$1 r0 = new kotlinx.coroutines.channels.ProduceKt$awaitClose$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r4 = r0.L$1
            r5 = r4
            ik.a r5 = (ik.a) r5
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.channels.q r4 = (kotlinx.coroutines.channels.q) r4
            kotlin.u0.n(r6)     // Catch: java.lang.Throwable -> L32
            goto L7a
        L32:
            r4 = move-exception
            goto L80
        L34:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3c:
            kotlin.u0.n(r6)
            kotlin.coroutines.CoroutineContext r6 = r0.b()
            kotlinx.coroutines.c2$b r2 = kotlinx.coroutines.c2.f38296x2
            kotlin.coroutines.CoroutineContext$a r6 = r6.c(r2)
            if (r6 != r4) goto L4d
            r6 = 1
            goto L4e
        L4d:
            r6 = 0
        L4e:
            if (r6 == 0) goto L84
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L32
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L32
            r0.label = r3     // Catch: java.lang.Throwable -> L32
            kotlinx.coroutines.p r6 = new kotlinx.coroutines.p     // Catch: java.lang.Throwable -> L32
            kotlin.coroutines.c r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.d(r0)     // Catch: java.lang.Throwable -> L32
            r6.<init>(r2, r3)     // Catch: java.lang.Throwable -> L32
            r6.Q()     // Catch: java.lang.Throwable -> L32
            kotlinx.coroutines.channels.ProduceKt$awaitClose$4$1 r2 = new kotlinx.coroutines.channels.ProduceKt$awaitClose$4$1     // Catch: java.lang.Throwable -> L32
            r2.<init>()     // Catch: java.lang.Throwable -> L32
            r4.g(r2)     // Catch: java.lang.Throwable -> L32
            java.lang.Object r4 = r6.C()     // Catch: java.lang.Throwable -> L32
            java.lang.Object r6 = yj.b.h()     // Catch: java.lang.Throwable -> L32
            if (r4 != r6) goto L77
            zj.f.c(r0)     // Catch: java.lang.Throwable -> L32
        L77:
            if (r4 != r1) goto L7a
            return r1
        L7a:
            r5.o()
            kotlin.z1 r4 = kotlin.z1.f38230a
            return r4
        L80:
            r5.o()
            throw r4
        L84:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ProduceKt.a(kotlinx.coroutines.channels.q, ik.a, kotlin.coroutines.c):java.lang.Object");
    }

    public static /* synthetic */ Object b(q qVar, ik.a aVar, kotlin.coroutines.c cVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            aVar = new ik.a<z1>() { // from class: kotlinx.coroutines.channels.ProduceKt$awaitClose$2
                public final void b() {
                }

                @Override // ik.a
                public /* bridge */ /* synthetic */ z1 o() {
                    b();
                    return z1.f38230a;
                }
            };
        }
        return a(qVar, aVar, cVar);
    }

    @s1
    @yt.k
    public static final <E> ReceiveChannel<E> c(@yt.k o0 o0Var, @yt.k CoroutineContext coroutineContext, int i10, @kotlin.b @yt.k ik.p<? super q<? super E>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar) {
        return e(o0Var, coroutineContext, i10, BufferOverflow.SUSPEND, CoroutineStart.DEFAULT, null, pVar);
    }

    @y1
    @yt.k
    public static final <E> ReceiveChannel<E> d(@yt.k o0 o0Var, @yt.k CoroutineContext coroutineContext, int i10, @yt.k CoroutineStart coroutineStart, @yt.l ik.l<? super Throwable, z1> lVar, @kotlin.b @yt.k ik.p<? super q<? super E>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar) {
        return e(o0Var, coroutineContext, i10, BufferOverflow.SUSPEND, coroutineStart, lVar, pVar);
    }

    @yt.k
    public static final <E> ReceiveChannel<E> e(@yt.k o0 o0Var, @yt.k CoroutineContext coroutineContext, int i10, @yt.k BufferOverflow bufferOverflow, @yt.k CoroutineStart coroutineStart, @yt.l ik.l<? super Throwable, z1> lVar, @kotlin.b @yt.k ik.p<? super q<? super E>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar) {
        p pVar2 = new p(CoroutineContextKt.e(o0Var, coroutineContext), i.d(i10, bufferOverflow, null, 4, null));
        if (lVar != null) {
            pVar2.L1(lVar);
        }
        pVar2.I1(coroutineStart, pVar2, pVar);
        return pVar2;
    }

    public static /* synthetic */ ReceiveChannel f(o0 o0Var, CoroutineContext coroutineContext, int i10, ik.p pVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f37755a;
        }
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return c(o0Var, coroutineContext, i10, pVar);
    }

    public static /* synthetic */ ReceiveChannel g(o0 o0Var, CoroutineContext coroutineContext, int i10, CoroutineStart coroutineStart, ik.l lVar, ik.p pVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f37755a;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        int i12 = (i11 & 2) != 0 ? 0 : i10;
        if ((i11 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i11 & 8) != 0) {
            lVar = null;
        }
        return d(o0Var, coroutineContext2, i12, coroutineStart2, lVar, pVar);
    }

    public static /* synthetic */ ReceiveChannel h(o0 o0Var, CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow, CoroutineStart coroutineStart, ik.l lVar, ik.p pVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f37755a;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        int i12 = (i11 & 2) != 0 ? 0 : i10;
        if ((i11 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        BufferOverflow bufferOverflow2 = bufferOverflow;
        if ((i11 & 8) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i11 & 16) != 0) {
            lVar = null;
        }
        return e(o0Var, coroutineContext2, i12, bufferOverflow2, coroutineStart2, lVar, pVar);
    }
}
