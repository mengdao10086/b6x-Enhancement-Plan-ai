package gj;

import xi.g0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class k<T, U, V> extends m implements g0<T>, io.reactivex.internal.util.j<U, V> {
    public volatile boolean C1;
    public final g0<? super V> K0;
    public Throwable K1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public final fj.n<U> f29583k1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public volatile boolean f29584v1;

    public k(g0<? super V> g0Var, fj.n<U> nVar) {
        this.K0 = g0Var;
        this.f29583k1 = nVar;
    }

    @Override // io.reactivex.internal.util.j
    public final boolean a() {
        return this.f29611p.getAndIncrement() == 0;
    }

    @Override // io.reactivex.internal.util.j
    public final boolean b() {
        return this.C1;
    }

    @Override // io.reactivex.internal.util.j
    public final boolean c() {
        return this.f29584v1;
    }

    public final boolean d() {
        return this.f29611p.get() == 0 && this.f29611p.compareAndSet(0, 1);
    }

    @Override // io.reactivex.internal.util.j
    public final Throwable e() {
        return this.K1;
    }

    @Override // io.reactivex.internal.util.j
    public final int f(int i10) {
        return this.f29611p.addAndGet(i10);
    }

    @Override // io.reactivex.internal.util.j
    public void g(g0<? super V> g0Var, U u6) {
    }

    public final void h(U u6, boolean z10, io.reactivex.disposables.b bVar) {
        g0<? super V> g0Var = this.K0;
        fj.n<U> nVar = this.f29583k1;
        if (this.f29611p.get() == 0 && this.f29611p.compareAndSet(0, 1)) {
            g(g0Var, u6);
            if (f(-1) == 0) {
                return;
            }
        } else {
            nVar.offer(u6);
            if (!a()) {
                return;
            }
        }
        io.reactivex.internal.util.n.d(nVar, g0Var, z10, bVar, this);
    }

    public final void i(U u6, boolean z10, io.reactivex.disposables.b bVar) {
        g0<? super V> g0Var = this.K0;
        fj.n<U> nVar = this.f29583k1;
        if (this.f29611p.get() != 0 || !this.f29611p.compareAndSet(0, 1)) {
            nVar.offer(u6);
            if (!a()) {
                return;
            }
        } else if (nVar.isEmpty()) {
            g(g0Var, u6);
            if (f(-1) == 0) {
                return;
            }
        } else {
            nVar.offer(u6);
        }
        io.reactivex.internal.util.n.d(nVar, g0Var, z10, bVar, this);
    }
}
