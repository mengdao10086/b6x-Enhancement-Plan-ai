package kotlinx.coroutines.flow;

import kotlin.DeprecationLevel;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.o0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/flow/FlowKt__ChannelsKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,176:1\n106#2:177\n*S KotlinDebug\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/flow/FlowKt__ChannelsKt\n*L\n153#1:177\n*E\n"})
public final /* synthetic */ class FlowKt__ChannelsKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @t0({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Channels.kt\nkotlinx/coroutines/flow/FlowKt__ChannelsKt\n*L\n1#1,112:1\n154#2,2:113\n*E\n"})
    public static final class a<T> implements e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.channels.d f38500a;

        public a(kotlinx.coroutines.channels.d dVar) {
            this.f38500a = dVar;
        }

        @Override // kotlinx.coroutines.flow.e
        @yt.l
        public Object a(@yt.k f<? super T> fVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
            Object objL0 = g.l0(fVar, this.f38500a.E(), cVar);
            return objL0 == yj.b.h() ? objL0 : z1.f38230a;
        }
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "'BroadcastChannel' is obsolete and all corresponding operators are deprecated in the favour of StateFlow and SharedFlow")
    @yt.k
    public static final <T> e<T> b(@yt.k kotlinx.coroutines.channels.d<T> dVar) {
        return new a(dVar);
    }

    @yt.k
    public static final <T> e<T> c(@yt.k ReceiveChannel<? extends T> receiveChannel) {
        return new b(receiveChannel, true, null, 0, null, 28, null);
    }

    @yt.l
    public static final <T> Object d(@yt.k f<? super T> fVar, @yt.k ReceiveChannel<? extends T> receiveChannel, @yt.k kotlin.coroutines.c<? super z1> cVar) throws Throwable {
        Object objE = e(fVar, receiveChannel, true, cVar);
        return objE == yj.b.h() ? objE : z1.f38230a;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0070 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007e A[Catch: all -> 0x009b, TRY_LEAVE, TryCatch #0 {all -> 0x009b, blocks: (B:13:0x0036, B:22:0x0060, B:26:0x0075, B:28:0x007e, B:18:0x0052, B:21:0x005c), top: B:41:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0090 -> B:14:0x0039). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object e(kotlinx.coroutines.flow.f<? super T> r7, kotlinx.coroutines.channels.ReceiveChannel<? extends T> r8, boolean r9, kotlin.coroutines.c<? super kotlin.z1> r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            if (r0 == 0) goto L13
            r0 = r10
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = (kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = new kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L56
            if (r2 == r4) goto L44
            if (r2 != r3) goto L3c
            boolean r9 = r0.Z$0
            java.lang.Object r7 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.f r2 = (kotlinx.coroutines.flow.f) r2
            kotlin.u0.n(r10)     // Catch: java.lang.Throwable -> L9b
        L39:
            r10 = r7
            r7 = r2
            goto L60
        L3c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L44:
            boolean r9 = r0.Z$0
            java.lang.Object r7 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.f r2 = (kotlinx.coroutines.flow.f) r2
            kotlin.u0.n(r10)     // Catch: java.lang.Throwable -> L9b
            goto L75
        L56:
            kotlin.u0.n(r10)
            kotlinx.coroutines.flow.g.o0(r7)
            kotlinx.coroutines.channels.ChannelIterator r10 = r8.iterator()     // Catch: java.lang.Throwable -> L9b
        L60:
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L9b
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L9b
            r0.L$2 = r10     // Catch: java.lang.Throwable -> L9b
            r0.Z$0 = r9     // Catch: java.lang.Throwable -> L9b
            r0.label = r4     // Catch: java.lang.Throwable -> L9b
            java.lang.Object r2 = r10.a(r0)     // Catch: java.lang.Throwable -> L9b
            if (r2 != r1) goto L71
            return r1
        L71:
            r6 = r2
            r2 = r7
            r7 = r10
            r10 = r6
        L75:
            r5 = 0
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L9b
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L9b
            if (r10 == 0) goto L93
            java.lang.Object r10 = r7.next()     // Catch: java.lang.Throwable -> L9b
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L9b
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L9b
            r0.L$2 = r7     // Catch: java.lang.Throwable -> L9b
            r0.Z$0 = r9     // Catch: java.lang.Throwable -> L9b
            r0.label = r3     // Catch: java.lang.Throwable -> L9b
            java.lang.Object r10 = r2.f(r10, r0)     // Catch: java.lang.Throwable -> L9b
            if (r10 != r1) goto L39
            return r1
        L93:
            if (r9 == 0) goto L98
            kotlinx.coroutines.channels.l.b(r8, r5)
        L98:
            kotlin.z1 r7 = kotlin.z1.f38230a
            return r7
        L9b:
            r7 = move-exception
            throw r7     // Catch: java.lang.Throwable -> L9d
        L9d:
            r10 = move-exception
            if (r9 == 0) goto La3
            kotlinx.coroutines.channels.l.b(r8, r7)
        La3:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ChannelsKt.e(kotlinx.coroutines.flow.f, kotlinx.coroutines.channels.ReceiveChannel, boolean, kotlin.coroutines.c):java.lang.Object");
    }

    @yt.k
    public static final <T> ReceiveChannel<T> f(@yt.k e<? extends T> eVar, @yt.k o0 o0Var) {
        return kotlinx.coroutines.flow.internal.d.b(eVar).m(o0Var);
    }

    @yt.k
    public static final <T> e<T> g(@yt.k ReceiveChannel<? extends T> receiveChannel) {
        return new b(receiveChannel, false, null, 0, null, 28, null);
    }
}
