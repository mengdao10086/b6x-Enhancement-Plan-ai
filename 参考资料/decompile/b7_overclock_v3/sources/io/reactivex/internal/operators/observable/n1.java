package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class n1<T, U> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.e0<U> f34623b;

    public final class a implements xi.g0<U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayCompositeDisposable f34624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b<T> f34625b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final io.reactivex.observers.l<T> f34626c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public io.reactivex.disposables.b f34627d;

        public a(ArrayCompositeDisposable arrayCompositeDisposable, b<T> bVar, io.reactivex.observers.l<T> lVar) {
            this.f34624a = arrayCompositeDisposable;
            this.f34625b = bVar;
            this.f34626c = lVar;
        }

        @Override // xi.g0
        public void onComplete() {
            this.f34625b.f34632d = true;
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.f34624a.dispose();
            this.f34626c.onError(th2);
        }

        @Override // xi.g0
        public void onNext(U u6) {
            this.f34627d.dispose();
            this.f34625b.f34632d = true;
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34627d, bVar)) {
                this.f34627d = bVar;
                this.f34624a.b(1, bVar);
            }
        }
    }

    public static final class b<T> implements xi.g0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super T> f34629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayCompositeDisposable f34630b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f34631c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile boolean f34632d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f34633e;

        public b(xi.g0<? super T> g0Var, ArrayCompositeDisposable arrayCompositeDisposable) {
            this.f34629a = g0Var;
            this.f34630b = arrayCompositeDisposable;
        }

        @Override // xi.g0
        public void onComplete() {
            this.f34630b.dispose();
            this.f34629a.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.f34630b.dispose();
            this.f34629a.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.f34633e) {
                this.f34629a.onNext(t10);
            } else if (this.f34632d) {
                this.f34633e = true;
                this.f34629a.onNext(t10);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34631c, bVar)) {
                this.f34631c = bVar;
                this.f34630b.b(0, bVar);
            }
        }
    }

    public n1(xi.e0<T> e0Var, xi.e0<U> e0Var2) {
        super(e0Var);
        this.f34623b = e0Var2;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        io.reactivex.observers.l lVar = new io.reactivex.observers.l(g0Var);
        ArrayCompositeDisposable arrayCompositeDisposable = new ArrayCompositeDisposable(2);
        lVar.onSubscribe(arrayCompositeDisposable);
        b bVar = new b(lVar, arrayCompositeDisposable);
        this.f34623b.c(new a(arrayCompositeDisposable, bVar, lVar));
        this.f34421a.c(bVar);
    }
}
