package kotlinx.coroutines.channels;

import kotlin.DeprecationLevel;
import kotlin.t0;
import kotlin.z1;
import kotlinx.coroutines.internal.n0;
import kotlinx.coroutines.y0;

/* JADX INFO: loaded from: classes5.dex */
public interface s<E> {

    public static final class a {
        public static /* synthetic */ boolean a(s sVar, Throwable th2, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
            }
            if ((i10 & 1) != 0) {
                th2 = null;
            }
            return sVar.C(th2);
        }

        @y0
        public static /* synthetic */ void b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @kotlin.k(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @t0(expression = "trySend(element).isSuccess", imports = {}))
        public static <E> boolean c(@yt.k s<? super E> sVar, E e10) throws Throwable {
            Object objF = sVar.F(e10);
            if (j.m(objF)) {
                return true;
            }
            Throwable thF = j.f(objF);
            if (thF == null) {
                return false;
            }
            throw n0.o(thF);
        }
    }

    boolean C(@yt.l Throwable th2);

    @yt.k
    Object F(E e10);

    @yt.l
    Object G(E e10, @yt.k kotlin.coroutines.c<? super z1> cVar);

    boolean H();

    void g(@yt.k ik.l<? super Throwable, z1> lVar);

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @t0(expression = "trySend(element).isSuccess", imports = {}))
    boolean offer(E e10);

    @yt.k
    kotlinx.coroutines.selects.g<E, s<E>> y();
}
