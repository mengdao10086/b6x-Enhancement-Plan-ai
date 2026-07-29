package kotlinx.coroutines.channels;

import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.d1;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.r2;
import kotlinx.coroutines.u1;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nBroadcast.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Broadcast.kt\nkotlinx/coroutines/channels/BroadcastKt\n+ 2 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n*L\n1#1,202:1\n48#2,4:203\n*S KotlinDebug\n*F\n+ 1 Broadcast.kt\nkotlinx/coroutines/channels/BroadcastKt\n*L\n51#1:203,4\n*E\n"})
public final class BroadcastKt {

    @t0({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1\n+ 2 Broadcast.kt\nkotlinx/coroutines/channels/BroadcastKt\n*L\n1#1,110:1\n51#2:111\n*E\n"})
    public static final class a extends kotlin.coroutines.a implements k0 {
        public a(k0.b bVar) {
            super(bVar);
        }

        @Override // kotlinx.coroutines.k0
        public void V1(@yt.k CoroutineContext coroutineContext, @yt.k Throwable th2) {
        }
    }

    @kotlin.k(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    @r2
    @yt.k
    public static final <E> d<E> a(@yt.k o0 o0Var, @yt.k CoroutineContext coroutineContext, int i10, @yt.k CoroutineStart coroutineStart, @yt.l ik.l<? super Throwable, z1> lVar, @kotlin.b @yt.k ik.p<? super q<? super E>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar) {
        CoroutineContext coroutineContextE = CoroutineContextKt.e(o0Var, coroutineContext);
        d dVarA = e.a(i10);
        f oVar = coroutineStart.isLazy() ? new o(coroutineContextE, dVarA, pVar) : new f(coroutineContextE, dVarA, true);
        if (lVar != null) {
            ((JobSupport) oVar).L1(lVar);
        }
        ((kotlinx.coroutines.a) oVar).I1(coroutineStart, oVar, pVar);
        return (d<E>) oVar;
    }

    @kotlin.k(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    @r2
    @yt.k
    public static final <E> d<E> b(@yt.k final ReceiveChannel<? extends E> receiveChannel, int i10, @yt.k CoroutineStart coroutineStart) {
        return c(p0.m(p0.m(u1.f39074a, d1.g()), new a(k0.f38888w2)), null, i10, coroutineStart, new ik.l<Throwable, z1>() { // from class: kotlinx.coroutines.channels.BroadcastKt$broadcast$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public final void b(@yt.l Throwable th2) {
                l.b(receiveChannel, th2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        }, new BroadcastKt$broadcast$2(receiveChannel, null), 1, null);
    }

    public static /* synthetic */ d c(o0 o0Var, CoroutineContext coroutineContext, int i10, CoroutineStart coroutineStart, ik.l lVar, ik.p pVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f37755a;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        int i12 = (i11 & 2) != 0 ? 1 : i10;
        if ((i11 & 4) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i11 & 8) != 0) {
            lVar = null;
        }
        return a(o0Var, coroutineContext2, i12, coroutineStart2, lVar, pVar);
    }

    public static /* synthetic */ d d(ReceiveChannel receiveChannel, int i10, CoroutineStart coroutineStart, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        if ((i11 & 2) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        return b(receiveChannel, i10, coroutineStart);
    }
}
