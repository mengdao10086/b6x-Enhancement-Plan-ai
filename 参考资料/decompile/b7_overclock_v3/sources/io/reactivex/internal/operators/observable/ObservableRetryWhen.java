package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableRetryWhen<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super xi.z<Throwable>, ? extends xi.e0<?>> f34305b;

    public static final class RepeatWhenObserver<T> extends AtomicInteger implements xi.g0<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 802743776666017014L;
        public volatile boolean active;
        public final xi.g0<? super T> downstream;
        public final io.reactivex.subjects.c<Throwable> signaller;
        public final xi.e0<T> source;
        public final AtomicInteger wip = new AtomicInteger();
        public final AtomicThrowable error = new AtomicThrowable();
        public final RepeatWhenObserver<T>.InnerRepeatObserver inner = new InnerRepeatObserver();
        public final AtomicReference<io.reactivex.disposables.b> upstream = new AtomicReference<>();

        public final class InnerRepeatObserver extends AtomicReference<io.reactivex.disposables.b> implements xi.g0<Object> {
            private static final long serialVersionUID = 3254781284376480842L;

            public InnerRepeatObserver() {
            }

            @Override // xi.g0
            public void onComplete() {
                RepeatWhenObserver.this.a();
            }

            @Override // xi.g0
            public void onError(Throwable th2) {
                RepeatWhenObserver.this.b(th2);
            }

            @Override // xi.g0
            public void onNext(Object obj) {
                RepeatWhenObserver.this.c();
            }

            @Override // xi.g0
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }
        }

        public RepeatWhenObserver(xi.g0<? super T> g0Var, io.reactivex.subjects.c<Throwable> cVar, xi.e0<T> e0Var) {
            this.downstream = g0Var;
            this.signaller = cVar;
            this.source = e0Var;
        }

        public void a() {
            DisposableHelper.dispose(this.upstream);
            io.reactivex.internal.util.g.b(this.downstream, this, this.error);
        }

        public void b(Throwable th2) {
            DisposableHelper.dispose(this.upstream);
            io.reactivex.internal.util.g.d(this.downstream, th2, this, this.error);
        }

        public void c() {
            d();
        }

        public void d() {
            if (this.wip.getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.active) {
                        this.active = true;
                        this.source.c(this);
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.inner);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // xi.g0
        public void onComplete() {
            DisposableHelper.dispose(this.inner);
            io.reactivex.internal.util.g.b(this.downstream, this, this.error);
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            DisposableHelper.replace(this.upstream, null);
            this.active = false;
            this.signaller.onNext(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            io.reactivex.internal.util.g.f(this.downstream, t10, this, this.error);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.replace(this.upstream, bVar);
        }
    }

    public ObservableRetryWhen(xi.e0<T> e0Var, dj.o<? super xi.z<Throwable>, ? extends xi.e0<?>> oVar) {
        super(e0Var);
        this.f34305b = oVar;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        io.reactivex.subjects.c<T> cVarM8 = PublishSubject.o8().m8();
        try {
            xi.e0 e0Var = (xi.e0) io.reactivex.internal.functions.a.g(this.f34305b.apply(cVarM8), "The handler returned a null ObservableSource");
            RepeatWhenObserver repeatWhenObserver = new RepeatWhenObserver(g0Var, cVarM8, this.f34421a);
            g0Var.onSubscribe(repeatWhenObserver);
            e0Var.c(repeatWhenObserver.inner);
            repeatWhenObserver.d();
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, g0Var);
        }
    }
}
