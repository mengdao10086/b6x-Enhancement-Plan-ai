package o5;

import java.util.concurrent.TimeUnit;
import xi.e0;
import xi.f0;
import xi.z;

/* JADX INFO: loaded from: classes2.dex */
public class l {
    public static <T> f0<T, T> d() {
        return new f0() { // from class: o5.k
            @Override // xi.f0
            public final e0 c(z zVar) {
                return l.g(zVar);
            }
        };
    }

    public static <T> xi.p<T, T> e() {
        return new xi.p() { // from class: o5.j
            @Override // xi.p
            public final bu.c a(xi.j jVar) {
                return l.h(jVar);
            }
        };
    }

    public static z<Long> f(final int i10) {
        return z.g3(1L, TimeUnit.SECONDS).a6(i10).A3(new dj.o() { // from class: o5.i
            @Override // dj.o
            public final Object apply(Object obj) {
                return l.i(i10, (Long) obj);
            }
        }).J5(lj.b.a());
    }

    public static /* synthetic */ e0 g(z zVar) {
        return zVar.J5(lj.b.d()).b4(aj.a.c());
    }

    public static /* synthetic */ bu.c h(xi.j jVar) {
        return jVar.l6(lj.b.d()).l4(aj.a.c());
    }

    public static /* synthetic */ Long i(int i10, Long l10) throws Exception {
        return Long.valueOf(((long) i10) - l10.longValue());
    }
}
