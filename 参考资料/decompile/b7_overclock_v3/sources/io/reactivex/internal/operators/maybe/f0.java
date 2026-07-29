package io.reactivex.internal.operators.maybe;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class f0<T> extends io.reactivex.internal.operators.maybe.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.r<? super Throwable> f33940b;

    public static final class a<T> implements xi.t<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.t<? super T> f33941a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.r<? super Throwable> f33942b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f33943c;

        public a(xi.t<? super T> tVar, dj.r<? super Throwable> rVar) {
            this.f33941a = tVar;
            this.f33942b = rVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f33943c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33943c.isDisposed();
        }

        @Override // xi.t
        public void onComplete() {
            this.f33941a.onComplete();
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            try {
                if (this.f33942b.a(th2)) {
                    this.f33941a.onComplete();
                } else {
                    this.f33941a.onError(th2);
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                this.f33941a.onError(new CompositeException(th2, th3));
            }
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f33943c, bVar)) {
                this.f33943c = bVar;
                this.f33941a.onSubscribe(this);
            }
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            this.f33941a.onSuccess(t10);
        }
    }

    public f0(xi.w<T> wVar, dj.r<? super Throwable> rVar) {
        super(wVar);
        this.f33940b = rVar;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        this.f33914a.a(new a(tVar, this.f33940b));
    }
}
