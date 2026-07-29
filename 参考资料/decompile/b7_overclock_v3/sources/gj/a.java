package gj;

import io.reactivex.internal.disposables.DisposableHelper;
import xi.g0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a<T, R> implements g0<T>, fj.j<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g0<? super R> f29560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public io.reactivex.disposables.b f29561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public fj.j<T> f29562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f29563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f29564e;

    public a(g0<? super R> g0Var) {
        this.f29560a = g0Var;
    }

    public void a() {
    }

    public boolean b() {
        return true;
    }

    public final void c(Throwable th2) {
        io.reactivex.exceptions.a.b(th2);
        this.f29561b.dispose();
        onError(th2);
    }

    @Override // fj.o
    public void clear() {
        this.f29562c.clear();
    }

    public final int d(int i10) {
        fj.j<T> jVar = this.f29562c;
        if (jVar == null || (i10 & 4) != 0) {
            return 0;
        }
        int iRequestFusion = jVar.requestFusion(i10);
        if (iRequestFusion != 0) {
            this.f29564e = iRequestFusion;
        }
        return iRequestFusion;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.f29561b.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.f29561b.isDisposed();
    }

    @Override // fj.o
    public boolean isEmpty() {
        return this.f29562c.isEmpty();
    }

    @Override // fj.o
    public final boolean offer(R r10) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // xi.g0
    public void onComplete() {
        if (this.f29563d) {
            return;
        }
        this.f29563d = true;
        this.f29560a.onComplete();
    }

    @Override // xi.g0
    public void onError(Throwable th2) {
        if (this.f29563d) {
            kj.a.Y(th2);
        } else {
            this.f29563d = true;
            this.f29560a.onError(th2);
        }
    }

    @Override // xi.g0
    public final void onSubscribe(io.reactivex.disposables.b bVar) {
        if (DisposableHelper.validate(this.f29561b, bVar)) {
            this.f29561b = bVar;
            if (bVar instanceof fj.j) {
                this.f29562c = (fj.j) bVar;
            }
            if (b()) {
                this.f29560a.onSubscribe(this);
                a();
            }
        }
    }

    @Override // fj.o
    public final boolean offer(R r10, R r11) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
