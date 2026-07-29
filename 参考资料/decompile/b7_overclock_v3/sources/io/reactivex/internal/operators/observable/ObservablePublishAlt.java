package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservablePublishAlt<T> extends ij.a<T> implements fj.g<T>, ej.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.e0<T> f34262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<PublishConnection<T>> f34263b = new AtomicReference<>();

    public static final class InnerDisposable<T> extends AtomicReference<PublishConnection<T>> implements io.reactivex.disposables.b {
        private static final long serialVersionUID = 7463222674719692880L;
        public final xi.g0<? super T> downstream;

        public InnerDisposable(xi.g0<? super T> g0Var, PublishConnection<T> publishConnection) {
            this.downstream = g0Var;
            lazySet(publishConnection);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            PublishConnection<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.b(this);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == null;
        }
    }

    public static final class PublishConnection<T> extends AtomicReference<InnerDisposable<T>[]> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final InnerDisposable[] f34264a = new InnerDisposable[0];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final InnerDisposable[] f34265b = new InnerDisposable[0];
        private static final long serialVersionUID = -3251430252873581268L;
        public final AtomicReference<PublishConnection<T>> current;
        public Throwable error;
        public final AtomicBoolean connect = new AtomicBoolean();
        public final AtomicReference<io.reactivex.disposables.b> upstream = new AtomicReference<>();

        public PublishConnection(AtomicReference<PublishConnection<T>> atomicReference) {
            this.current = atomicReference;
            lazySet(f34264a);
        }

        public boolean a(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = get();
                if (innerDisposableArr == f34265b) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[length + 1];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!compareAndSet(innerDisposableArr, innerDisposableArr2));
            return true;
        }

        public void b(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = get();
                int length = innerDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i10 = -1;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    }
                    if (innerDisposableArr[i11] == innerDisposable) {
                        i10 = i11;
                        break;
                    }
                    i11++;
                }
                if (i10 < 0) {
                    return;
                }
                innerDisposableArr2 = f34264a;
                if (length != 1) {
                    innerDisposableArr2 = new InnerDisposable[length - 1];
                    System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, i10);
                    System.arraycopy(innerDisposableArr, i10 + 1, innerDisposableArr2, i10, (length - i10) - 1);
                }
            } while (!compareAndSet(innerDisposableArr, innerDisposableArr2));
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            getAndSet(f34265b);
            this.current.compareAndSet(this, null);
            DisposableHelper.dispose(this.upstream);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == f34265b;
        }

        @Override // xi.g0
        public void onComplete() {
            this.upstream.lazySet(DisposableHelper.DISPOSED);
            for (InnerDisposable<T> innerDisposable : getAndSet(f34265b)) {
                innerDisposable.downstream.onComplete();
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.error = th2;
            this.upstream.lazySet(DisposableHelper.DISPOSED);
            for (InnerDisposable<T> innerDisposable : getAndSet(f34265b)) {
                innerDisposable.downstream.onError(th2);
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            for (InnerDisposable<T> innerDisposable : get()) {
                innerDisposable.downstream.onNext(t10);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }
    }

    public ObservablePublishAlt(xi.e0<T> e0Var) {
        this.f34262a = e0Var;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        PublishConnection<T> publishConnection;
        while (true) {
            publishConnection = this.f34263b.get();
            if (publishConnection != null) {
                break;
            }
            PublishConnection<T> publishConnection2 = new PublishConnection<>(this.f34263b);
            if (this.f34263b.compareAndSet(publishConnection, publishConnection2)) {
                publishConnection = publishConnection2;
                break;
            }
        }
        InnerDisposable<T> innerDisposable = new InnerDisposable<>(g0Var, publishConnection);
        g0Var.onSubscribe(innerDisposable);
        if (publishConnection.a(innerDisposable)) {
            if (innerDisposable.isDisposed()) {
                publishConnection.b(innerDisposable);
            }
        } else {
            Throwable th2 = publishConnection.error;
            if (th2 != null) {
                g0Var.onError(th2);
            } else {
                g0Var.onComplete();
            }
        }
    }

    @Override // ej.c
    public void e(io.reactivex.disposables.b bVar) {
        this.f34263b.compareAndSet((PublishConnection) bVar, null);
    }

    @Override // ij.a
    public void m8(dj.g<? super io.reactivex.disposables.b> gVar) {
        PublishConnection<T> publishConnection;
        while (true) {
            publishConnection = this.f34263b.get();
            if (publishConnection != null && !publishConnection.isDisposed()) {
                break;
            }
            PublishConnection<T> publishConnection2 = new PublishConnection<>(this.f34263b);
            if (this.f34263b.compareAndSet(publishConnection, publishConnection2)) {
                publishConnection = publishConnection2;
                break;
            }
        }
        boolean z10 = !publishConnection.connect.get() && publishConnection.connect.compareAndSet(false, true);
        try {
            gVar.accept(publishConnection);
            if (z10) {
                this.f34262a.c(publishConnection);
            }
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            throw ExceptionHelper.f(th2);
        }
    }

    @Override // fj.g
    public xi.e0<T> source() {
        return this.f34262a;
    }
}
