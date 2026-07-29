package io.reactivex.internal.operators.maybe;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class h<T> extends io.reactivex.internal.operators.maybe.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.b<? super T, ? super Throwable> f33952b;

    public static final class a<T> implements xi.t<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.t<? super T> f33953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.b<? super T, ? super Throwable> f33954b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f33955c;

        public a(xi.t<? super T> tVar, dj.b<? super T, ? super Throwable> bVar) {
            this.f33953a = tVar;
            this.f33954b = bVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f33955c.dispose();
            this.f33955c = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33955c.isDisposed();
        }

        @Override // xi.t
        public void onComplete() {
            this.f33955c = DisposableHelper.DISPOSED;
            try {
                this.f33954b.a(null, null);
                this.f33953a.onComplete();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f33953a.onError(th2);
            }
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            this.f33955c = DisposableHelper.DISPOSED;
            try {
                this.f33954b.a(null, th2);
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f33953a.onError(th2);
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f33955c, bVar)) {
                this.f33955c = bVar;
                this.f33953a.onSubscribe(this);
            }
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            this.f33955c = DisposableHelper.DISPOSED;
            try {
                this.f33954b.a(t10, null);
                this.f33953a.onSuccess(t10);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f33953a.onError(th2);
            }
        }
    }

    public h(xi.w<T> wVar, dj.b<? super T, ? super Throwable> bVar) {
        super(wVar);
        this.f33952b = bVar;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        this.f33914a.a(new a(tVar, this.f33952b));
    }
}
