package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.DeprecationLevel;
import kotlin.t0;
import kotlinx.coroutines.channels.s;
import kotlinx.coroutines.r2;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.k(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
@r2
public interface d<E> extends s<E> {

    public static final class a {
        public static /* synthetic */ void a(d dVar, CancellationException cancellationException, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i10 & 1) != 0) {
                cancellationException = null;
            }
            dVar.h(cancellationException);
        }

        public static /* synthetic */ boolean b(d dVar, Throwable th2, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i10 & 1) != 0) {
                th2 = null;
            }
            return dVar.d(th2);
        }

        @kotlin.k(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @t0(expression = "trySend(element).isSuccess", imports = {}))
        public static <E> boolean c(@yt.k d<E> dVar, E e10) {
            return s.a.c(dVar, e10);
        }
    }

    @yt.k
    ReceiveChannel<E> E();

    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Binary compatibility only")
    /* synthetic */ boolean d(Throwable th2);

    void h(@yt.l CancellationException cancellationException);
}
