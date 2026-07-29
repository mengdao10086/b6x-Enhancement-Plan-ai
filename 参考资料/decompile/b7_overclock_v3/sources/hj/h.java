package hj;

import fj.n;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import xi.o;

/* JADX INFO: loaded from: classes5.dex */
public abstract class h<T, U, V> extends l implements o<T>, io.reactivex.internal.util.m<U, V> {
    public final bu.d<? super V> M7;
    public final n<U> N7;
    public volatile boolean O7;
    public volatile boolean P7;
    public Throwable Q7;

    public h(bu.d<? super V> dVar, n<U> nVar) {
        this.M7 = dVar;
        this.N7 = nVar;
    }

    @Override // io.reactivex.internal.util.m
    public final boolean a() {
        return this.f31343p.getAndIncrement() == 0;
    }

    @Override // io.reactivex.internal.util.m
    public final boolean b() {
        return this.P7;
    }

    @Override // io.reactivex.internal.util.m
    public final boolean c() {
        return this.O7;
    }

    @Override // io.reactivex.internal.util.m
    public final long d() {
        return this.K0.get();
    }

    @Override // io.reactivex.internal.util.m
    public final Throwable e() {
        return this.Q7;
    }

    @Override // io.reactivex.internal.util.m
    public final int f(int i10) {
        return this.f31343p.addAndGet(i10);
    }

    @Override // io.reactivex.internal.util.m
    public final long g(long j10) {
        return this.K0.addAndGet(-j10);
    }

    @Override // io.reactivex.internal.util.m
    public boolean h(bu.d<? super V> dVar, U u6) {
        return false;
    }

    public final boolean i() {
        return this.f31343p.get() == 0 && this.f31343p.compareAndSet(0, 1);
    }

    public final void j(U u6, boolean z10, io.reactivex.disposables.b bVar) {
        bu.d<? super V> dVar = this.M7;
        n<U> nVar = this.N7;
        if (i()) {
            long j10 = this.K0.get();
            if (j10 == 0) {
                bVar.dispose();
                dVar.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            } else {
                if (h(dVar, u6) && j10 != Long.MAX_VALUE) {
                    g(1L);
                }
                if (f(-1) == 0) {
                    return;
                }
            }
        } else {
            nVar.offer(u6);
            if (!a()) {
                return;
            }
        }
        io.reactivex.internal.util.n.e(nVar, dVar, z10, bVar, this);
    }

    public final void k(U u6, boolean z10, io.reactivex.disposables.b bVar) {
        bu.d<? super V> dVar = this.M7;
        n<U> nVar = this.N7;
        if (i()) {
            long j10 = this.K0.get();
            if (j10 == 0) {
                this.O7 = true;
                bVar.dispose();
                dVar.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            } else if (nVar.isEmpty()) {
                if (h(dVar, u6) && j10 != Long.MAX_VALUE) {
                    g(1L);
                }
                if (f(-1) == 0) {
                    return;
                }
            } else {
                nVar.offer(u6);
            }
        } else {
            nVar.offer(u6);
            if (!a()) {
                return;
            }
        }
        io.reactivex.internal.util.n.e(nVar, dVar, z10, bVar, this);
    }

    public final void l(long j10) {
        if (SubscriptionHelper.validate(j10)) {
            io.reactivex.internal.util.b.a(this.K0, j10);
        }
    }
}
