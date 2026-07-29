package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableCreate<T> extends xi.z<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.c0<T> f34154a;

    public static final class CreateEmitter<T> extends AtomicReference<io.reactivex.disposables.b> implements xi.b0<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -3434801548987643227L;
        public final xi.g0<? super T> observer;

        public CreateEmitter(xi.g0<? super T> g0Var) {
            this.observer = g0Var;
        }

        @Override // xi.b0
        public boolean a(Throwable th2) {
            if (th2 == null) {
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isDisposed()) {
                return false;
            }
            try {
                this.observer.onError(th2);
                dispose();
                return true;
            } catch (Throwable th3) {
                dispose();
                throw th3;
            }
        }

        @Override // xi.b0
        public void b(dj.f fVar) {
            c(new CancellableDisposable(fVar));
        }

        @Override // xi.b0
        public void c(io.reactivex.disposables.b bVar) {
            DisposableHelper.set(this, bVar);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // xi.b0, io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // xi.i
        public void onComplete() {
            if (isDisposed()) {
                return;
            }
            try {
                this.observer.onComplete();
            } finally {
                dispose();
            }
        }

        @Override // xi.i
        public void onError(Throwable th2) {
            if (a(th2)) {
                return;
            }
            kj.a.Y(th2);
        }

        @Override // xi.i
        public void onNext(T t10) {
            if (t10 == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                if (isDisposed()) {
                    return;
                }
                this.observer.onNext(t10);
            }
        }

        @Override // xi.b0
        public xi.b0<T> serialize() {
            return new SerializedEmitter(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", CreateEmitter.class.getSimpleName(), super.toString());
        }
    }

    public static final class SerializedEmitter<T> extends AtomicInteger implements xi.b0<T> {
        private static final long serialVersionUID = 4883307006032401862L;
        public volatile boolean done;
        public final xi.b0<T> emitter;
        public final AtomicThrowable error = new AtomicThrowable();
        public final io.reactivex.internal.queue.a<T> queue = new io.reactivex.internal.queue.a<>(16);

        public SerializedEmitter(xi.b0<T> b0Var) {
            this.emitter = b0Var;
        }

        @Override // xi.b0
        public boolean a(Throwable th2) {
            if (!this.emitter.isDisposed() && !this.done) {
                if (th2 == null) {
                    th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
                }
                if (this.error.a(th2)) {
                    this.done = true;
                    f();
                    return true;
                }
            }
            return false;
        }

        @Override // xi.b0
        public void b(dj.f fVar) {
            this.emitter.b(fVar);
        }

        @Override // xi.b0
        public void c(io.reactivex.disposables.b bVar) {
            this.emitter.c(bVar);
        }

        public void f() {
            if (getAndIncrement() == 0) {
                h();
            }
        }

        public void h() {
            xi.b0<T> b0Var = this.emitter;
            io.reactivex.internal.queue.a<T> aVar = this.queue;
            AtomicThrowable atomicThrowable = this.error;
            int iAddAndGet = 1;
            while (!b0Var.isDisposed()) {
                if (atomicThrowable.get() != null) {
                    aVar.clear();
                    b0Var.onError(atomicThrowable.c());
                    return;
                }
                boolean z10 = this.done;
                T tPoll = aVar.poll();
                boolean z11 = tPoll == null;
                if (z10 && z11) {
                    b0Var.onComplete();
                    return;
                } else if (z11) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    b0Var.onNext(tPoll);
                }
            }
            aVar.clear();
        }

        @Override // xi.b0, io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.emitter.isDisposed();
        }

        @Override // xi.i
        public void onComplete() {
            if (this.emitter.isDisposed() || this.done) {
                return;
            }
            this.done = true;
            f();
        }

        @Override // xi.i
        public void onError(Throwable th2) {
            if (a(th2)) {
                return;
            }
            kj.a.Y(th2);
        }

        @Override // xi.i
        public void onNext(T t10) {
            if (this.emitter.isDisposed() || this.done) {
                return;
            }
            if (t10 == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            if (get() == 0 && compareAndSet(0, 1)) {
                this.emitter.onNext(t10);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                io.reactivex.internal.queue.a<T> aVar = this.queue;
                synchronized (aVar) {
                    aVar.offer(t10);
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            h();
        }

        @Override // xi.b0
        public xi.b0<T> serialize() {
            return this;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public String toString() {
            return this.emitter.toString();
        }
    }

    public ObservableCreate(xi.c0<T> c0Var) {
        this.f34154a = c0Var;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        CreateEmitter createEmitter = new CreateEmitter(g0Var);
        g0Var.onSubscribe(createEmitter);
        try {
            this.f34154a.a(createEmitter);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            createEmitter.onError(th2);
        }
    }
}
