package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.f0;
import kotlin.t0;
import kotlinx.coroutines.internal.n0;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.y0;

/* JADX INFO: loaded from: classes5.dex */
public interface ReceiveChannel<E> {

    public static final class DefaultImpls {
        public static /* synthetic */ void b(ReceiveChannel receiveChannel, CancellationException cancellationException, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i10 & 1) != 0) {
                cancellationException = null;
            }
            receiveChannel.h(cancellationException);
        }

        public static /* synthetic */ boolean c(ReceiveChannel receiveChannel, Throwable th2, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i10 & 1) != 0) {
                th2 = null;
            }
            return receiveChannel.d(th2);
        }

        @yt.k
        public static <E> kotlinx.coroutines.selects.e<E> d(@yt.k ReceiveChannel<? extends E> receiveChannel) {
            f0.n(receiveChannel, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel<E of kotlinx.coroutines.channels.ReceiveChannel>");
            return ((BufferedChannel) receiveChannel).q();
        }

        @kotlin.k(level = DeprecationLevel.ERROR, message = "Deprecated in favor of onReceiveCatching extension", replaceWith = @t0(expression = "onReceiveCatching", imports = {}))
        public static /* synthetic */ void e() {
        }

        @y0
        public static /* synthetic */ void f() {
        }

        @s1
        public static /* synthetic */ void g() {
        }

        @kotlin.k(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @t0(expression = "tryReceive().getOrNull()", imports = {}))
        @yt.l
        public static <E> E h(@yt.k ReceiveChannel<? extends E> receiveChannel) throws Throwable {
            Object objS = receiveChannel.s();
            if (j.m(objS)) {
                return (E) j.i(objS);
            }
            Throwable thF = j.f(objS);
            if (thF == null) {
                return null;
            }
            throw n0.o(thF);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @kotlin.k(level = kotlin.DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @kotlin.t0(expression = "receiveCatching().getOrNull()", imports = {}))
        @yt.l
        @bk.h
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static <E> java.lang.Object i(@yt.k kotlinx.coroutines.channels.ReceiveChannel<? extends E> r4, @yt.k kotlin.coroutines.c<? super E> r5) throws java.lang.Throwable {
            /*
                boolean r0 = r5 instanceof kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1
                if (r0 == 0) goto L13
                r0 = r5
                kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1 r0 = (kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1 r0 = new kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1
                r0.<init>(r5)
            L18:
                java.lang.Object r5 = r0.result
                java.lang.Object r1 = yj.b.h()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L37
                if (r2 != r3) goto L2f
                kotlin.u0.n(r5)
                kotlinx.coroutines.channels.j r5 = (kotlinx.coroutines.channels.j) r5
                java.lang.Object r4 = r5.o()
                goto L43
            L2f:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L37:
                kotlin.u0.n(r5)
                r0.label = r3
                java.lang.Object r4 = r4.v(r0)
                if (r4 != r1) goto L43
                return r1
            L43:
                java.lang.Object r4 = kotlinx.coroutines.channels.j.h(r4)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.i(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.c):java.lang.Object");
        }
    }

    @yt.l
    Object A(@yt.k kotlin.coroutines.c<? super E> cVar);

    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ void cancel();

    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ boolean d(Throwable th2);

    boolean e();

    void h(@yt.l CancellationException cancellationException);

    boolean isEmpty();

    @yt.k
    ChannelIterator<E> iterator();

    @yt.k
    kotlinx.coroutines.selects.e<E> j();

    @yt.k
    kotlinx.coroutines.selects.e<j<E>> o();

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @t0(expression = "tryReceive().getOrNull()", imports = {}))
    @yt.l
    E poll();

    @yt.k
    kotlinx.coroutines.selects.e<E> q();

    @yt.k
    Object s();

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @t0(expression = "receiveCatching().getOrNull()", imports = {}))
    @yt.l
    @bk.h
    Object t(@yt.k kotlin.coroutines.c<? super E> cVar);

    @yt.l
    Object v(@yt.k kotlin.coroutines.c<? super j<? extends E>> cVar);
}
