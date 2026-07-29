package kotlinx.coroutines.selects;

import ik.p;
import kotlin.DeprecationLevel;
import kotlin.t0;
import kotlinx.coroutines.s1;

/* JADX INFO: loaded from: classes5.dex */
public interface b<R> {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static <R, P, Q> void a(@yt.k b<? super R> bVar, @yt.k g<? super P, ? extends Q> gVar, @yt.k p<? super Q, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
            bVar.j(gVar, null, pVar);
        }

        @s1
        @kotlin.k(level = DeprecationLevel.ERROR, message = "Replaced with the same extension function", replaceWith = @t0(expression = "onTimeout", imports = {"kotlinx.coroutines.selects.onTimeout"}))
        @bk.h
        public static <R> void b(@yt.k b<? super R> bVar, long j10, @yt.k ik.l<? super kotlin.coroutines.c<? super R>, ? extends Object> lVar) {
            kotlinx.coroutines.selects.a.a(bVar, j10, lVar);
        }
    }

    <P, Q> void e(@yt.k g<? super P, ? extends Q> gVar, @yt.k p<? super Q, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar);

    @s1
    @kotlin.k(level = DeprecationLevel.ERROR, message = "Replaced with the same extension function", replaceWith = @t0(expression = "onTimeout", imports = {"kotlinx.coroutines.selects.onTimeout"}))
    @bk.h
    void f(long j10, @yt.k ik.l<? super kotlin.coroutines.c<? super R>, ? extends Object> lVar);

    <P, Q> void j(@yt.k g<? super P, ? extends Q> gVar, P p10, @yt.k p<? super Q, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar);

    void k(@yt.k c cVar, @yt.k ik.l<? super kotlin.coroutines.c<? super R>, ? extends Object> lVar);

    <Q> void p(@yt.k e<? extends Q> eVar, @yt.k p<? super Q, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar);
}
