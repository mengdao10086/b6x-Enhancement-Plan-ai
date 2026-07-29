package ri;

import io.objectbox.query.Query;
import io.reactivex.BackpressureStrategy;
import java.util.List;
import java.util.Objects;
import xi.b0;
import xi.c0;
import xi.i0;
import xi.k0;
import xi.l;
import xi.m;
import xi.m0;
import xi.z;

/* JADX INFO: loaded from: classes5.dex */
public abstract class k {
    public static <T> void g(Query<T> query, final l<T> lVar) {
        pi.d dVarF = query.J2().f(new pi.a() { // from class: ri.e
            @Override // pi.a
            public final void b(Object obj) {
                k.j(lVar, (List) obj);
            }
        });
        Objects.requireNonNull(dVarF);
        lVar.b(new a(dVarF));
    }

    public static <T> xi.j<T> h(Query<T> query) {
        return i(query, BackpressureStrategy.BUFFER);
    }

    public static <T> xi.j<T> i(final Query<T> query, BackpressureStrategy backpressureStrategy) {
        return xi.j.w1(new m() { // from class: ri.h
            @Override // xi.m
            public final void a(l lVar) {
                k.g(query, lVar);
            }
        }, backpressureStrategy);
    }

    public static /* synthetic */ void j(l lVar, List list) {
        for (Object obj : list) {
            if (lVar.isCancelled()) {
                return;
            } else {
                lVar.onNext(obj);
            }
        }
        if (lVar.isCancelled()) {
            return;
        }
        lVar.onComplete();
    }

    public static /* synthetic */ void l(b0 b0Var, List list) {
        if (b0Var.isDisposed()) {
            return;
        }
        b0Var.onNext(list);
    }

    public static /* synthetic */ void m(Query query, final b0 b0Var) throws Exception {
        pi.d dVarF = query.J2().f(new pi.a() { // from class: ri.f
            @Override // pi.a
            public final void b(Object obj) {
                k.l(b0Var, (List) obj);
            }
        });
        Objects.requireNonNull(dVarF);
        b0Var.b(new a(dVarF));
    }

    public static /* synthetic */ void n(k0 k0Var, List list) {
        if (k0Var.isDisposed()) {
            return;
        }
        k0Var.onSuccess(list);
    }

    public static /* synthetic */ void o(Query query, final k0 k0Var) throws Exception {
        query.J2().j().f(new pi.a() { // from class: ri.g
            @Override // pi.a
            public final void b(Object obj) {
                k.n(k0Var, (List) obj);
            }
        });
    }

    public static <T> z<List<T>> p(final Query<T> query) {
        return z.r1(new c0() { // from class: ri.i
            @Override // xi.c0
            public final void a(b0 b0Var) throws Exception {
                k.m(query, b0Var);
            }
        });
    }

    public static <T> i0<List<T>> q(final Query<T> query) {
        return i0.A(new m0() { // from class: ri.j
            @Override // xi.m0
            public final void a(k0 k0Var) throws Exception {
                k.o(query, k0Var);
            }
        });
    }
}
