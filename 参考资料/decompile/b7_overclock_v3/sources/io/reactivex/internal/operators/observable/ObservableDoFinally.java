package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableDoFinally<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.a f34166b;

    public static final class DoFinallyObserver<T> extends BasicIntQueueDisposable<T> implements xi.g0<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        public final xi.g0<? super T> downstream;
        public final dj.a onFinally;

        /* JADX INFO: renamed from: qd, reason: collision with root package name */
        public fj.j<T> f34167qd;
        public boolean syncFused;
        public io.reactivex.disposables.b upstream;

        public DoFinallyObserver(xi.g0<? super T> g0Var, dj.a aVar) {
            this.downstream = g0Var;
            this.onFinally = aVar;
        }

        public void a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    kj.a.Y(th2);
                }
            }
        }

        @Override // fj.o
        public void clear() {
            this.f34167qd.clear();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.dispose();
            a();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // fj.o
        public boolean isEmpty() {
            return this.f34167qd.isEmpty();
        }

        @Override // xi.g0
        public void onComplete() {
            this.downstream.onComplete();
            a();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
            a();
        }

        @Override // xi.g0
        public void onNext(T t10) {
            this.downstream.onNext(t10);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                if (bVar instanceof fj.j) {
                    this.f34167qd = (fj.j) bVar;
                }
                this.downstream.onSubscribe(this);
            }
        }

        @Override // fj.o
        @bj.f
        public T poll() throws Exception {
            T tPoll = this.f34167qd.poll();
            if (tPoll == null && this.syncFused) {
                a();
            }
            return tPoll;
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            fj.j<T> jVar = this.f34167qd;
            if (jVar == null || (i10 & 4) != 0) {
                return 0;
            }
            int iRequestFusion = jVar.requestFusion(i10);
            if (iRequestFusion != 0) {
                this.syncFused = iRequestFusion == 1;
            }
            return iRequestFusion;
        }
    }

    public ObservableDoFinally(xi.e0<T> e0Var, dj.a aVar) {
        super(e0Var);
        this.f34166b = aVar;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34421a.c(new DoFinallyObserver(g0Var, this.f34166b));
    }
}
