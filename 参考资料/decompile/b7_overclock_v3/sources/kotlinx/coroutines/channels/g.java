package kotlinx.coroutines.channels;

import kotlin.DeprecationLevel;
import kotlin.t0;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.s;
import kotlinx.coroutines.internal.r0;

/* JADX INFO: loaded from: classes5.dex */
public interface g<E> extends s<E>, ReceiveChannel<E> {
    public static final int A2 = 0;
    public static final int B2 = -1;
    public static final int D2 = -2;
    public static final int E2 = -3;

    @yt.k
    public static final String F2 = "kotlinx.coroutines.channels.defaultBuffer";

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    @yt.k
    public static final b f38366y2 = b.f38368a;

    /* JADX INFO: renamed from: z2, reason: collision with root package name */
    public static final int f38367z2 = Integer.MAX_VALUE;

    public static final class a {
        @yt.k
        public static <E> kotlinx.coroutines.selects.e<E> b(@yt.k g<E> gVar) {
            return ReceiveChannel.DefaultImpls.d(gVar);
        }

        @kotlin.k(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @t0(expression = "trySend(element).isSuccess", imports = {}))
        public static <E> boolean c(@yt.k g<E> gVar, E e10) {
            return s.a.c(gVar, e10);
        }

        @kotlin.k(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @t0(expression = "tryReceive().getOrNull()", imports = {}))
        @yt.l
        public static <E> E d(@yt.k g<E> gVar) {
            return (E) ReceiveChannel.DefaultImpls.h(gVar);
        }

        @kotlin.k(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @t0(expression = "receiveCatching().getOrNull()", imports = {}))
        @yt.l
        @bk.h
        public static <E> Object e(@yt.k g<E> gVar, @yt.k kotlin.coroutines.c<? super E> cVar) {
            return ReceiveChannel.DefaultImpls.i(gVar, cVar);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f38369b = Integer.MAX_VALUE;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f38370c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f38371d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f38372e = -2;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f38373f = -3;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @yt.k
        public static final String f38374g = "kotlinx.coroutines.channels.defaultBuffer";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f38368a = new b();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f38375h = r0.b("kotlinx.coroutines.channels.defaultBuffer", 64, 1, 2147483646);

        public final int a() {
            return f38375h;
        }
    }
}
