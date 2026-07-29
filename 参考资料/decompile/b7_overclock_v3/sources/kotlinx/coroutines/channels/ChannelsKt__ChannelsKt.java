package kotlinx.coroutines.channels;

import kotlin.DeprecationLevel;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import kotlinx.coroutines.channels.j;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/channels/ChannelsKt__ChannelsKt\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n*L\n1#1,61:1\n514#2,6:62\n*S KotlinDebug\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/channels/ChannelsKt__ChannelsKt\n*L\n37#1:62,6\n*E\n"})
public final /* synthetic */ class ChannelsKt__ChannelsKt {
    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Deprecated in the favour of 'trySendBlocking'. Consider handling the result of 'trySendBlocking' explicitly and rethrow exception if necessary", replaceWith = @kotlin.t0(expression = "trySendBlocking(element)", imports = {}))
    public static final /* synthetic */ void a(s sVar, Object obj) throws InterruptedException {
        if (j.m(sVar.F(obj))) {
            return;
        }
        kotlinx.coroutines.i.b(null, new ChannelsKt__ChannelsKt$sendBlocking$1(sVar, obj, null), 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <E> Object b(@yt.k s<? super E> sVar, E e10) {
        Object objF = sVar.F(e10);
        if (objF instanceof j.c) {
            return ((j) kotlinx.coroutines.i.b(null, new ChannelsKt__ChannelsKt$trySendBlocking$2(sVar, e10, null), 1, null)).o();
        }
        return j.f38377b.c(z1.f38230a);
    }
}
