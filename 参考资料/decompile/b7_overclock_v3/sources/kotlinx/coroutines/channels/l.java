package kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.DeprecationLevel;
import kotlin.Pair;
import kotlin.coroutines.CoroutineContext;
import kotlin.s0;
import kotlin.z1;
import kotlinx.coroutines.r2;

/* JADX INFO: loaded from: classes5.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final String f38383a = "Channel was closed";

    @s0
    @yt.k
    public static final <E, R> ReceiveChannel<R> J(@yt.k ReceiveChannel<? extends E> receiveChannel, @yt.k CoroutineContext coroutineContext, @yt.k ik.p<? super E, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        return ChannelsKt__DeprecatedKt.E(receiveChannel, coroutineContext, pVar);
    }

    @s0
    @yt.k
    public static final <E, R> ReceiveChannel<R> L(@yt.k ReceiveChannel<? extends E> receiveChannel, @yt.k CoroutineContext coroutineContext, @yt.k ik.q<? super Integer, ? super E, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar) {
        return ChannelsKt__DeprecatedKt.G(receiveChannel, coroutineContext, qVar);
    }

    @s0
    public static final void b(@yt.k ReceiveChannel<?> receiveChannel, @yt.l Throwable th2) {
        ChannelsKt__Channels_commonKt.a(receiveChannel, th2);
    }

    @kotlin.k(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    @r2
    public static final <E, R> R c(@yt.k d<E> dVar, @yt.k ik.l<? super ReceiveChannel<? extends E>, ? extends R> lVar) {
        return (R) ChannelsKt__Channels_commonKt.b(dVar, lVar);
    }

    public static final <E, R> R d(@yt.k ReceiveChannel<? extends E> receiveChannel, @yt.k ik.l<? super ReceiveChannel<? extends E>, ? extends R> lVar) {
        return (R) ChannelsKt__Channels_commonKt.c(receiveChannel, lVar);
    }

    @kotlin.k(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    @yt.l
    public static final <E> Object e(@yt.k d<E> dVar, @yt.k ik.l<? super E, z1> lVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        return ChannelsKt__Channels_commonKt.d(dVar, lVar, cVar);
    }

    @yt.l
    @s0
    public static final <E, C extends s<? super E>> Object e0(@yt.k ReceiveChannel<? extends E> receiveChannel, @yt.k C c10, @yt.k kotlin.coroutines.c<? super C> cVar) {
        return ChannelsKt__DeprecatedKt.W(receiveChannel, c10, cVar);
    }

    @yt.l
    public static final <E> Object f(@yt.k ReceiveChannel<? extends E> receiveChannel, @yt.k ik.l<? super E, z1> lVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        return ChannelsKt__Channels_commonKt.e(receiveChannel, lVar, cVar);
    }

    @yt.l
    @s0
    public static final <E, C extends Collection<? super E>> Object f0(@yt.k ReceiveChannel<? extends E> receiveChannel, @yt.k C c10, @yt.k kotlin.coroutines.c<? super C> cVar) {
        return ChannelsKt__DeprecatedKt.X(receiveChannel, c10, cVar);
    }

    @s0
    @yt.k
    public static final ik.l<Throwable, z1> g(@yt.k ReceiveChannel<?> receiveChannel) {
        return ChannelsKt__DeprecatedKt.b(receiveChannel);
    }

    @yt.l
    public static final <E> Object g0(@yt.k ReceiveChannel<? extends E> receiveChannel, @yt.k kotlin.coroutines.c<? super List<? extends E>> cVar) {
        return ChannelsKt__Channels_commonKt.j(receiveChannel, cVar);
    }

    @s0
    @yt.k
    public static final ik.l<Throwable, z1> h(@yt.k ReceiveChannel<?>... receiveChannelArr) {
        return ChannelsKt__DeprecatedKt.c(receiveChannelArr);
    }

    @yt.l
    @s0
    public static final <K, V, M extends Map<? super K, ? super V>> Object h0(@yt.k ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, @yt.k M m10, @yt.k kotlin.coroutines.c<? super M> cVar) {
        return ChannelsKt__DeprecatedKt.Y(receiveChannel, m10, cVar);
    }

    @s0
    @yt.k
    public static final <E, K> ReceiveChannel<E> k(@yt.k ReceiveChannel<? extends E> receiveChannel, @yt.k CoroutineContext coroutineContext, @yt.k ik.p<? super E, ? super kotlin.coroutines.c<? super K>, ? extends Object> pVar) {
        return ChannelsKt__DeprecatedKt.f(receiveChannel, coroutineContext, pVar);
    }

    @yt.l
    @s0
    public static final <E> Object k0(@yt.k ReceiveChannel<? extends E> receiveChannel, @yt.k kotlin.coroutines.c<? super Set<E>> cVar) {
        return ChannelsKt__DeprecatedKt.b0(receiveChannel, cVar);
    }

    @yt.k
    public static final <E> Object m0(@yt.k s<? super E> sVar, E e10) {
        return ChannelsKt__ChannelsKt.b(sVar, e10);
    }

    @s0
    @yt.k
    public static final <E, R, V> ReceiveChannel<V> q0(@yt.k ReceiveChannel<? extends E> receiveChannel, @yt.k ReceiveChannel<? extends R> receiveChannel2, @yt.k CoroutineContext coroutineContext, @yt.k ik.p<? super E, ? super R, ? extends V> pVar) {
        return ChannelsKt__DeprecatedKt.g0(receiveChannel, receiveChannel2, coroutineContext, pVar);
    }

    @s0
    @yt.k
    public static final <E> ReceiveChannel<E> s(@yt.k ReceiveChannel<? extends E> receiveChannel, @yt.k CoroutineContext coroutineContext, @yt.k ik.p<? super E, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar) {
        return ChannelsKt__DeprecatedKt.n(receiveChannel, coroutineContext, pVar);
    }

    @s0
    @yt.k
    public static final <E> ReceiveChannel<E> y(@yt.k ReceiveChannel<? extends E> receiveChannel) {
        return ChannelsKt__DeprecatedKt.t(receiveChannel);
    }
}
