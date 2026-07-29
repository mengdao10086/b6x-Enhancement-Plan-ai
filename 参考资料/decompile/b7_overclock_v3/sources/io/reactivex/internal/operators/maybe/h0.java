package io.reactivex.internal.operators.maybe;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;

/* JADX INFO: loaded from: classes5.dex */
public final class h0<T> extends io.reactivex.internal.operators.maybe.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.g<? super io.reactivex.disposables.b> f33956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.g<? super T> f33957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dj.g<? super Throwable> f33958d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final dj.a f33959e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final dj.a f33960f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final dj.a f33961g;

    public static final class a<T> implements xi.t<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.t<? super T> f33962a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h0<T> f33963b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f33964c;

        public a(xi.t<? super T> tVar, h0<T> h0Var) {
            this.f33962a = tVar;
            this.f33963b = h0Var;
        }

        public void a() {
            try {
                this.f33963b.f33960f.run();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                kj.a.Y(th2);
            }
        }

        public void b(Throwable th2) {
            try {
                this.f33963b.f33958d.accept(th2);
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f33964c = DisposableHelper.DISPOSED;
            this.f33962a.onError(th2);
            a();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            try {
                this.f33963b.f33961g.run();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                kj.a.Y(th2);
            }
            this.f33964c.dispose();
            this.f33964c = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33964c.isDisposed();
        }

        @Override // xi.t
        public void onComplete() {
            io.reactivex.disposables.b bVar = this.f33964c;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar == disposableHelper) {
                return;
            }
            try {
                this.f33963b.f33959e.run();
                this.f33964c = disposableHelper;
                this.f33962a.onComplete();
                a();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                b(th2);
            }
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            if (this.f33964c == DisposableHelper.DISPOSED) {
                kj.a.Y(th2);
            } else {
                b(th2);
            }
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f33964c, bVar)) {
                try {
                    this.f33963b.f33956b.accept(bVar);
                    this.f33964c = bVar;
                    this.f33962a.onSubscribe(this);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    bVar.dispose();
                    this.f33964c = DisposableHelper.DISPOSED;
                    EmptyDisposable.error(th2, this.f33962a);
                }
            }
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            io.reactivex.disposables.b bVar = this.f33964c;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar == disposableHelper) {
                return;
            }
            try {
                this.f33963b.f33957c.accept(t10);
                this.f33964c = disposableHelper;
                this.f33962a.onSuccess(t10);
                a();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                b(th2);
            }
        }
    }

    public h0(xi.w<T> wVar, dj.g<? super io.reactivex.disposables.b> gVar, dj.g<? super T> gVar2, dj.g<? super Throwable> gVar3, dj.a aVar, dj.a aVar2, dj.a aVar3) {
        super(wVar);
        this.f33956b = gVar;
        this.f33957c = gVar2;
        this.f33958d = gVar3;
        this.f33959e = aVar;
        this.f33960f = aVar2;
        this.f33961g = aVar3;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        this.f33914a.a(new a(tVar, this));
    }
}
