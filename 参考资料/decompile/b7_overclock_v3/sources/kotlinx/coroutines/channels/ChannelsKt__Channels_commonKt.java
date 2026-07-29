package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.s0;
import kotlin.z1;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.p1;
import kotlinx.coroutines.r2;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nChannels.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,141:1\n82#1,11:142\n105#1:153\n82#1,6:154\n106#1,2:160\n92#1:162\n88#1,3:163\n33#1,5:166\n*S KotlinDebug\n*F\n+ 1 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n105#1:142,11\n116#1:153\n116#1:154,6\n116#1:160,2\n116#1:162\n116#1:163,3\n129#1:166,5\n*E\n"})
public final /* synthetic */ class ChannelsKt__Channels_commonKt {
    @s0
    public static final void a(@yt.k ReceiveChannel<?> receiveChannel, @yt.l Throwable th2) {
        if (th2 != null) {
            cancellationExceptionA = th2 instanceof CancellationException ? (CancellationException) th2 : null;
            if (cancellationExceptionA == null) {
                cancellationExceptionA = p1.a("Channel was consumed, consumer had failed", th2);
            }
        }
        receiveChannel.h(cancellationExceptionA);
    }

    @kotlin.k(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    @r2
    public static final <E, R> R b(@yt.k d<E> dVar, @yt.k ik.l<? super ReceiveChannel<? extends E>, ? extends R> lVar) {
        ReceiveChannel<E> receiveChannelE = dVar.E();
        try {
            return lVar.i(receiveChannelE);
        } finally {
            c0.d(1);
            ReceiveChannel.DefaultImpls.b(receiveChannelE, null, 1, null);
            c0.c(1);
        }
    }

    public static final <E, R> R c(@yt.k ReceiveChannel<? extends E> receiveChannel, @yt.k ik.l<? super ReceiveChannel<? extends E>, ? extends R> lVar) {
        try {
            R rI = lVar.i(receiveChannel);
            c0.d(1);
            l.b(receiveChannel, null);
            c0.c(1);
            return rI;
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006e A[Catch: all -> 0x0085, TryCatch #0 {all -> 0x0085, blocks: (B:26:0x0066, B:28:0x006e, B:29:0x0079), top: B:40:0x0066 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0079 A[Catch: all -> 0x0085, TRY_LEAVE, TryCatch #0 {all -> 0x0085, blocks: (B:26:0x0066, B:28:0x006e, B:29:0x0079), top: B:40:0x0066 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0062 -> B:14:0x0038). Please report as a decompilation issue!!! */
    @kotlin.k(level = kotlin.DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <E> java.lang.Object d(@yt.k kotlinx.coroutines.channels.d<E> r6, @yt.k ik.l<? super E, kotlin.z1> r7, @yt.k kotlin.coroutines.c<? super kotlin.z1> r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$3
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$3 r0 = (kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$3 r0 = new kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$3
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L45
            if (r2 != r4) goto L3d
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.L$0
            ik.l r2 = (ik.l) r2
            kotlin.u0.n(r8)     // Catch: java.lang.Throwable -> L3b
            r5 = r0
            r0 = r7
            r7 = r2
        L38:
            r2 = r1
            r1 = r5
            goto L66
        L3b:
            r6 = move-exception
            goto L8f
        L3d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L45:
            kotlin.u0.n(r8)
            kotlinx.coroutines.channels.ReceiveChannel r6 = r6.E()
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch: java.lang.Throwable -> L8b
            r5 = r8
            r8 = r6
            r6 = r5
        L53:
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L88
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L88
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L88
            r0.label = r4     // Catch: java.lang.Throwable -> L88
            java.lang.Object r2 = r6.a(r0)     // Catch: java.lang.Throwable -> L88
            if (r2 != r1) goto L62
            return r1
        L62:
            r5 = r0
            r0 = r8
            r8 = r2
            goto L38
        L66:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L85
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L85
            if (r8 == 0) goto L79
            java.lang.Object r8 = r6.next()     // Catch: java.lang.Throwable -> L85
            r7.i(r8)     // Catch: java.lang.Throwable -> L85
            r8 = r0
            r0 = r1
            r1 = r2
            goto L53
        L79:
            kotlin.z1 r6 = kotlin.z1.f38230a     // Catch: java.lang.Throwable -> L85
            kotlin.jvm.internal.c0.d(r4)
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.b(r0, r3, r4, r3)
            kotlin.jvm.internal.c0.c(r4)
            return r6
        L85:
            r6 = move-exception
            r7 = r0
            goto L8f
        L88:
            r6 = move-exception
            r7 = r8
            goto L8f
        L8b:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L8f:
            kotlin.jvm.internal.c0.d(r4)
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.b(r7, r3, r4, r3)
            kotlin.jvm.internal.c0.c(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.d(kotlinx.coroutines.channels.d, ik.l, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0065 A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:12:0x0031, B:25:0x005c, B:27:0x0065, B:21:0x004a, B:28:0x006e), top: B:37:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006e A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #0 {all -> 0x0035, blocks: (B:12:0x0031, B:25:0x005c, B:27:0x0065, B:21:0x004a, B:28:0x006e), top: B:37:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0059 -> B:25:0x005c). Please report as a decompilation issue!!! */
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <E> java.lang.Object e(@yt.k kotlinx.coroutines.channels.ReceiveChannel<? extends E> r6, @yt.k ik.l<? super E, kotlin.z1> r7, @yt.k kotlin.coroutines.c<? super kotlin.z1> r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.L$0
            ik.l r2 = (ik.l) r2
            kotlin.u0.n(r8)     // Catch: java.lang.Throwable -> L35
            goto L5c
        L35:
            r6 = move-exception
            goto L7e
        L37:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3f:
            kotlin.u0.n(r8)
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch: java.lang.Throwable -> L7a
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L4a:
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L35
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L35
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L35
            r0.label = r3     // Catch: java.lang.Throwable -> L35
            java.lang.Object r2 = r6.a(r0)     // Catch: java.lang.Throwable -> L35
            if (r2 != r1) goto L59
            return r1
        L59:
            r5 = r2
            r2 = r8
            r8 = r5
        L5c:
            r4 = 0
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L35
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L35
            if (r8 == 0) goto L6e
            java.lang.Object r8 = r6.next()     // Catch: java.lang.Throwable -> L35
            r2.i(r8)     // Catch: java.lang.Throwable -> L35
            r8 = r2
            goto L4a
        L6e:
            kotlin.z1 r6 = kotlin.z1.f38230a     // Catch: java.lang.Throwable -> L35
            kotlin.jvm.internal.c0.d(r3)
            kotlinx.coroutines.channels.l.b(r7, r4)
            kotlin.jvm.internal.c0.c(r3)
            return r6
        L7a:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L7e:
            throw r6     // Catch: java.lang.Throwable -> L7f
        L7f:
            r8 = move-exception
            kotlin.jvm.internal.c0.d(r3)
            kotlinx.coroutines.channels.l.b(r7, r6)
            kotlin.jvm.internal.c0.c(r3)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.e(kotlinx.coroutines.channels.ReceiveChannel, ik.l, kotlin.coroutines.c):java.lang.Object");
    }

    @kotlin.k(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E> Object f(d<E> dVar, ik.l<? super E, z1> lVar, kotlin.coroutines.c<? super z1> cVar) {
        ReceiveChannel<E> receiveChannelE = dVar.E();
        try {
            ChannelIterator<E> it2 = receiveChannelE.iterator();
            while (true) {
                c0.e(3);
                c0.e(0);
                Object objA = it2.a(null);
                c0.e(1);
                if (!((Boolean) objA).booleanValue()) {
                    return z1.f38230a;
                }
                lVar.i(it2.next());
            }
        } finally {
            c0.d(1);
            ReceiveChannel.DefaultImpls.b(receiveChannelE, null, 1, null);
            c0.c(1);
        }
    }

    public static final <E> Object g(ReceiveChannel<? extends E> receiveChannel, ik.l<? super E, z1> lVar, kotlin.coroutines.c<? super z1> cVar) {
        try {
            ChannelIterator<? extends E> it2 = receiveChannel.iterator();
            while (true) {
                c0.e(3);
                c0.e(0);
                Object objA = it2.a(null);
                c0.e(1);
                if (!((Boolean) objA).booleanValue()) {
                    z1 z1Var = z1.f38230a;
                    c0.d(1);
                    l.b(receiveChannel, null);
                    c0.c(1);
                    return z1Var;
                }
                lVar.i(it2.next());
            }
        } finally {
        }
    }

    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Deprecated in the favour of 'onReceiveCatching'")
    public static final /* synthetic */ kotlinx.coroutines.selects.e h(ReceiveChannel receiveChannel) {
        f0.n(receiveChannel, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.onReceiveOrNull?>");
        return receiveChannel.q();
    }

    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Deprecated in the favour of 'receiveCatching'", replaceWith = @kotlin.t0(expression = "receiveCatching().getOrNull()", imports = {}))
    public static final /* synthetic */ Object i(ReceiveChannel receiveChannel, kotlin.coroutines.c cVar) {
        f0.n(receiveChannel, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.receiveOrNull?>");
        return receiveChannel.t(cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0070 A[Catch: all -> 0x0039, TryCatch #2 {all -> 0x0039, blocks: (B:12:0x0035, B:26:0x0068, B:28:0x0070, B:29:0x0079), top: B:44:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0079 A[Catch: all -> 0x0039, TRY_LEAVE, TryCatch #2 {all -> 0x0039, blocks: (B:12:0x0035, B:26:0x0068, B:28:0x0070, B:29:0x0079), top: B:44:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0064 -> B:25:0x0067). Please report as a decompilation issue!!! */
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <E> java.lang.Object j(@yt.k kotlinx.coroutines.channels.ReceiveChannel<? extends E> r8, @yt.k kotlin.coroutines.c<? super java.util.List<? extends E>> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1
            if (r0 == 0) goto L13
            r0 = r9
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L44
            if (r2 != r3) goto L3c
            java.lang.Object r8 = r0.L$3
            kotlinx.coroutines.channels.ChannelIterator r8 = (kotlinx.coroutines.channels.ChannelIterator) r8
            java.lang.Object r2 = r0.L$2
            kotlinx.coroutines.channels.ReceiveChannel r2 = (kotlinx.coroutines.channels.ReceiveChannel) r2
            java.lang.Object r4 = r0.L$1
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r5 = r0.L$0
            java.util.List r5 = (java.util.List) r5
            kotlin.u0.n(r9)     // Catch: java.lang.Throwable -> L39
            goto L67
        L39:
            r8 = move-exception
            r9 = r2
            goto L89
        L3c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L44:
            kotlin.u0.n(r9)
            java.util.List r9 = kotlin.collections.s.i()
            kotlinx.coroutines.channels.ChannelIterator r2 = r8.iterator()     // Catch: java.lang.Throwable -> L85
            r4 = r9
            r5 = r4
            r9 = r8
            r8 = r2
        L53:
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L83
            r0.L$1 = r4     // Catch: java.lang.Throwable -> L83
            r0.L$2 = r9     // Catch: java.lang.Throwable -> L83
            r0.L$3 = r8     // Catch: java.lang.Throwable -> L83
            r0.label = r3     // Catch: java.lang.Throwable -> L83
            java.lang.Object r2 = r8.a(r0)     // Catch: java.lang.Throwable -> L83
            if (r2 != r1) goto L64
            return r1
        L64:
            r7 = r2
            r2 = r9
            r9 = r7
        L67:
            r6 = 0
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L39
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L39
            if (r9 == 0) goto L79
            java.lang.Object r9 = r8.next()     // Catch: java.lang.Throwable -> L39
            r4.add(r9)     // Catch: java.lang.Throwable -> L39
            r9 = r2
            goto L53
        L79:
            kotlin.z1 r8 = kotlin.z1.f38230a     // Catch: java.lang.Throwable -> L39
            kotlinx.coroutines.channels.l.b(r2, r6)
            java.util.List r8 = kotlin.collections.s.a(r5)
            return r8
        L83:
            r8 = move-exception
            goto L89
        L85:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
        L89:
            throw r8     // Catch: java.lang.Throwable -> L8a
        L8a:
            r0 = move-exception
            kotlinx.coroutines.channels.l.b(r9, r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.j(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.c):java.lang.Object");
    }
}
