package gj;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import xi.g0;

/* JADX INFO: loaded from: classes5.dex */
public final class g<T> implements g0<T>, io.reactivex.disposables.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g0<? super T> f29573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.g<? super io.reactivex.disposables.b> f29574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.a f29575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public io.reactivex.disposables.b f29576d;

    public g(g0<? super T> g0Var, dj.g<? super io.reactivex.disposables.b> gVar, dj.a aVar) {
        this.f29573a = g0Var;
        this.f29574b = gVar;
        this.f29575c = aVar;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        io.reactivex.disposables.b bVar = this.f29576d;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar != disposableHelper) {
            this.f29576d = disposableHelper;
            try {
                this.f29575c.run();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                kj.a.Y(th2);
            }
            bVar.dispose();
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.f29576d.isDisposed();
    }

    @Override // xi.g0
    public void onComplete() {
        io.reactivex.disposables.b bVar = this.f29576d;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar != disposableHelper) {
            this.f29576d = disposableHelper;
            this.f29573a.onComplete();
        }
    }

    @Override // xi.g0
    public void onError(Throwable th2) {
        io.reactivex.disposables.b bVar = this.f29576d;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar == disposableHelper) {
            kj.a.Y(th2);
        } else {
            this.f29576d = disposableHelper;
            this.f29573a.onError(th2);
        }
    }

    @Override // xi.g0
    public void onNext(T t10) {
        this.f29573a.onNext(t10);
    }

    @Override // xi.g0
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        try {
            this.f29574b.accept(bVar);
            if (DisposableHelper.validate(this.f29576d, bVar)) {
                this.f29576d = bVar;
                this.f29573a.onSubscribe(this);
            }
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            bVar.dispose();
            this.f29576d = DisposableHelper.DISPOSED;
            EmptyDisposable.error(th2, this.f29573a);
        }
    }
}
