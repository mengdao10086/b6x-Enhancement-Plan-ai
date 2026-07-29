package bl;

import ik.p;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import kotlin.coroutines.c;
import kotlin.z1;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.g;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;
import yj.b;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
public final class a {
    public static final long a(Duration duration) {
        if (duration.compareTo(Duration.ZERO) <= 0) {
            return 0L;
        }
        if (duration.compareTo(ChronoUnit.MILLIS.getDuration()) <= 0) {
            return 1L;
        }
        if (duration.getSeconds() < 9223372036854775L || (duration.getSeconds() == 9223372036854775L && duration.getNano() < 807000000)) {
            return duration.toMillis();
        }
        return Long.MAX_VALUE;
    }

    @k
    @t1
    public static final <T> e<T> b(@k e<? extends T> eVar, @k Duration duration) {
        return g.a0(eVar, a(duration));
    }

    @l
    public static final Object c(@k Duration duration, @k c<? super z1> cVar) {
        Object objB = DelayKt.b(a(duration), cVar);
        return objB == b.h() ? objB : z1.f38230a;
    }

    public static final <R> void d(@k kotlinx.coroutines.selects.b<? super R> bVar, @k Duration duration, @k ik.l<? super c<? super R>, ? extends Object> lVar) {
        kotlinx.coroutines.selects.a.a(bVar, a(duration), lVar);
    }

    @k
    @t1
    public static final <T> e<T> e(@k e<? extends T> eVar, @k Duration duration) {
        return g.B1(eVar, a(duration));
    }

    @l
    public static final <T> Object f(@k Duration duration, @k p<? super o0, ? super c<? super T>, ? extends Object> pVar, @k c<? super T> cVar) {
        return TimeoutKt.c(a(duration), pVar, cVar);
    }

    @l
    public static final <T> Object g(@k Duration duration, @k p<? super o0, ? super c<? super T>, ? extends Object> pVar, @k c<? super T> cVar) {
        return TimeoutKt.e(a(duration), pVar, cVar);
    }
}
