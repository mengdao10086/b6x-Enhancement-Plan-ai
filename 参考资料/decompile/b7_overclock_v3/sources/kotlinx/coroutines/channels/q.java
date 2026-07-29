package kotlinx.coroutines.channels;

import kotlin.DeprecationLevel;
import kotlin.t0;
import kotlinx.coroutines.channels.s;
import kotlinx.coroutines.o0;

/* JADX INFO: loaded from: classes5.dex */
public interface q<E> extends o0, s<E> {

    public static final class a {
        @kotlin.k(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @t0(expression = "trySend(element).isSuccess", imports = {}))
        public static <E> boolean a(@yt.k q<? super E> qVar, E e10) {
            return s.a.c(qVar, e10);
        }
    }

    @yt.k
    s<E> i();
}
