package kotlinx.coroutines.channels;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import kotlinx.coroutines.d1;
import kotlinx.coroutines.r2;
import kotlinx.coroutines.u1;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nTickerChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TickerChannels.kt\nkotlinx/coroutines/channels/TickerChannelsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,112:1\n1#2:113\n*E\n"})
public final class TickerChannelsKt {
    /* JADX WARN: Removed duplicated region for block: B:24:0x0071 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x007d -> B:14:0x0034). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(long r6, long r8, kotlinx.coroutines.channels.s<? super kotlin.z1> r10, kotlin.coroutines.c<? super kotlin.z1> r11) throws java.lang.Throwable {
        /*
            boolean r0 = r11 instanceof kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1
            if (r0 == 0) goto L13
            r0 = r11
            kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1 r0 = (kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1 r0 = new kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L53
            if (r2 == r5) goto L48
            if (r2 == r4) goto L3e
            if (r2 != r3) goto L36
            long r6 = r0.J$0
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.channels.s r8 = (kotlinx.coroutines.channels.s) r8
            kotlin.u0.n(r11)
        L34:
            r10 = r8
            goto L63
        L36:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3e:
            long r6 = r0.J$0
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.channels.s r8 = (kotlinx.coroutines.channels.s) r8
            kotlin.u0.n(r11)
            goto L73
        L48:
            long r6 = r0.J$0
            java.lang.Object r8 = r0.L$0
            r10 = r8
            kotlinx.coroutines.channels.s r10 = (kotlinx.coroutines.channels.s) r10
            kotlin.u0.n(r11)
            goto L63
        L53:
            kotlin.u0.n(r11)
            r0.L$0 = r10
            r0.J$0 = r6
            r0.label = r5
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.b(r8, r0)
            if (r8 != r1) goto L63
            return r1
        L63:
            kotlin.z1 r8 = kotlin.z1.f38230a
            r0.L$0 = r10
            r0.J$0 = r6
            r0.label = r4
            java.lang.Object r8 = r10.G(r8, r0)
            if (r8 != r1) goto L72
            return r1
        L72:
            r8 = r10
        L73:
            r0.L$0 = r8
            r0.J$0 = r6
            r0.label = r3
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.b(r6, r0)
            if (r9 != r1) goto L34
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.TickerChannelsKt.c(long, long, kotlinx.coroutines.channels.s, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Path cross not found for [B:40:0x00d7, B:46:0x00fa], limit reached: 49 */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00f3 -> B:18:0x0052). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x010c -> B:18:0x0052). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(long r18, long r20, kotlinx.coroutines.channels.s<? super kotlin.z1> r22, kotlin.coroutines.c<? super kotlin.z1> r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.TickerChannelsKt.d(long, long, kotlinx.coroutines.channels.s, kotlin.coroutines.c):java.lang.Object");
    }

    @r2
    @yt.k
    public static final ReceiveChannel<z1> e(long j10, long j11, @yt.k CoroutineContext coroutineContext, @yt.k TickerMode tickerMode) {
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(("Expected non-negative delay, but has " + j10 + " ms").toString());
        }
        if (j11 >= 0) {
            return ProduceKt.c(u1.f39074a, d1.g().L(coroutineContext), 0, new TickerChannelsKt$ticker$3(tickerMode, j10, j11, null));
        }
        throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j11 + " ms").toString());
    }

    public static /* synthetic */ ReceiveChannel f(long j10, long j11, CoroutineContext coroutineContext, TickerMode tickerMode, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j11 = j10;
        }
        if ((i10 & 4) != 0) {
            coroutineContext = EmptyCoroutineContext.f37755a;
        }
        if ((i10 & 8) != 0) {
            tickerMode = TickerMode.FIXED_PERIOD;
        }
        return e(j10, j11, coroutineContext, tickerMode);
    }
}
