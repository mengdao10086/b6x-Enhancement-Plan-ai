package kotlinx.coroutines.channels;

import kotlin.DeprecationLevel;
import kotlin.t0;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.r2;

/* JADX INFO: loaded from: classes5.dex */
@r2
public interface c<E> extends o0, ReceiveChannel<E> {

    public static final class a {
        @yt.k
        public static <E> kotlinx.coroutines.selects.e<E> b(@yt.k c<E> cVar) {
            return ReceiveChannel.DefaultImpls.d(cVar);
        }

        @kotlin.k(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @t0(expression = "tryReceive().getOrNull()", imports = {}))
        @yt.l
        public static <E> E c(@yt.k c<E> cVar) {
            return (E) ReceiveChannel.DefaultImpls.h(cVar);
        }

        @kotlin.k(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @t0(expression = "receiveCatching().getOrNull()", imports = {}))
        @yt.l
        @bk.h
        public static <E> Object d(@yt.k c<E> cVar, @yt.k kotlin.coroutines.c<? super E> cVar2) {
            return ReceiveChannel.DefaultImpls.i(cVar, cVar2);
        }
    }

    @yt.k
    g<E> i();
}
