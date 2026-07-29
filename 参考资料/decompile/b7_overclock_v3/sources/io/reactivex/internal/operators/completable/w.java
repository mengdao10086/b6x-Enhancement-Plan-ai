package io.reactivex.internal.operators.completable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;

/* JADX INFO: loaded from: classes5.dex */
public final class w extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.g f33127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.g<? super io.reactivex.disposables.b> f33128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.g<? super Throwable> f33129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dj.a f33130d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final dj.a f33131e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final dj.a f33132f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final dj.a f33133g;

    public final class a implements xi.d, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.d f33134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public io.reactivex.disposables.b f33135b;

        public a(xi.d dVar) {
            this.f33134a = dVar;
        }

        public void a() {
            try {
                w.this.f33132f.run();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                kj.a.Y(th2);
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            try {
                w.this.f33133g.run();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                kj.a.Y(th2);
            }
            this.f33135b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33135b.isDisposed();
        }

        @Override // xi.d, xi.t
        public void onComplete() {
            if (this.f33135b == DisposableHelper.DISPOSED) {
                return;
            }
            try {
                w.this.f33130d.run();
                w.this.f33131e.run();
                this.f33134a.onComplete();
                a();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f33134a.onError(th2);
            }
        }

        @Override // xi.d
        public void onError(Throwable th2) {
            if (this.f33135b == DisposableHelper.DISPOSED) {
                kj.a.Y(th2);
                return;
            }
            try {
                w.this.f33129c.accept(th2);
                w.this.f33131e.run();
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f33134a.onError(th2);
            a();
        }

        @Override // xi.d
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            try {
                w.this.f33128b.accept(bVar);
                if (DisposableHelper.validate(this.f33135b, bVar)) {
                    this.f33135b = bVar;
                    this.f33134a.onSubscribe(this);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                bVar.dispose();
                this.f33135b = DisposableHelper.DISPOSED;
                EmptyDisposable.error(th2, this.f33134a);
            }
        }
    }

    public w(xi.g gVar, dj.g<? super io.reactivex.disposables.b> gVar2, dj.g<? super Throwable> gVar3, dj.a aVar, dj.a aVar2, dj.a aVar3, dj.a aVar4) {
        this.f33127a = gVar;
        this.f33128b = gVar2;
        this.f33129c = gVar3;
        this.f33130d = aVar;
        this.f33131e = aVar2;
        this.f33132f = aVar3;
        this.f33133g = aVar4;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        this.f33127a.a(new a(dVar));
    }
}
