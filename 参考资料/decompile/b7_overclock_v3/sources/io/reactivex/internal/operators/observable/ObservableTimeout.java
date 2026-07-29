package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableTimeout<T, U, V> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.e0<U> f34369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super T, ? extends xi.e0<V>> f34370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final xi.e0<? extends T> f34371d;

    public static final class TimeoutConsumer extends AtomicReference<io.reactivex.disposables.b> implements xi.g0<Object>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 8708641127342403073L;
        public final long idx;
        public final a parent;

        public TimeoutConsumer(long j10, a aVar) {
            this.idx = j10;
            this.parent = aVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // xi.g0
        public void onComplete() {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                this.parent.a(this.idx);
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj == disposableHelper) {
                kj.a.Y(th2);
            } else {
                lazySet(disposableHelper);
                this.parent.b(this.idx, th2);
            }
        }

        @Override // xi.g0
        public void onNext(Object obj) {
            io.reactivex.disposables.b bVar = (io.reactivex.disposables.b) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar != disposableHelper) {
                bVar.dispose();
                lazySet(disposableHelper);
                this.parent.a(this.idx);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public static final class TimeoutFallbackObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xi.g0<T>, io.reactivex.disposables.b, a {
        private static final long serialVersionUID = -7508389464265974549L;
        public final xi.g0<? super T> downstream;
        public xi.e0<? extends T> fallback;
        public final dj.o<? super T, ? extends xi.e0<?>> itemTimeoutIndicator;
        public final SequentialDisposable task = new SequentialDisposable();
        public final AtomicLong index = new AtomicLong();
        public final AtomicReference<io.reactivex.disposables.b> upstream = new AtomicReference<>();

        public TimeoutFallbackObserver(xi.g0<? super T> g0Var, dj.o<? super T, ? extends xi.e0<?>> oVar, xi.e0<? extends T> e0Var) {
            this.downstream = g0Var;
            this.itemTimeoutIndicator = oVar;
            this.fallback = e0Var;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.b
        public void a(long j10) {
            if (this.index.compareAndSet(j10, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.upstream);
                xi.e0<? extends T> e0Var = this.fallback;
                this.fallback = null;
                e0Var.c(new ObservableTimeoutTimed.a(this.downstream, this));
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.a
        public void b(long j10, Throwable th2) {
            if (!this.index.compareAndSet(j10, Long.MAX_VALUE)) {
                kj.a.Y(th2);
            } else {
                DisposableHelper.dispose(this);
                this.downstream.onError(th2);
            }
        }

        public void c(xi.e0<?> e0Var) {
            if (e0Var != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0L, this);
                if (this.task.a(timeoutConsumer)) {
                    e0Var.c(timeoutConsumer);
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
            this.task.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
                this.task.dispose();
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                kj.a.Y(th2);
                return;
            }
            this.task.dispose();
            this.downstream.onError(th2);
            this.task.dispose();
        }

        @Override // xi.g0
        public void onNext(T t10) {
            long j10 = this.index.get();
            if (j10 != Long.MAX_VALUE) {
                long j11 = 1 + j10;
                if (this.index.compareAndSet(j10, j11)) {
                    io.reactivex.disposables.b bVar = this.task.get();
                    if (bVar != null) {
                        bVar.dispose();
                    }
                    this.downstream.onNext(t10);
                    try {
                        xi.e0 e0Var = (xi.e0) io.reactivex.internal.functions.a.g(this.itemTimeoutIndicator.apply(t10), "The itemTimeoutIndicator returned a null ObservableSource.");
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j11, this);
                        if (this.task.a(timeoutConsumer)) {
                            e0Var.c(timeoutConsumer);
                        }
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        this.upstream.get().dispose();
                        this.index.getAndSet(Long.MAX_VALUE);
                        this.downstream.onError(th2);
                    }
                }
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }
    }

    public static final class TimeoutObserver<T> extends AtomicLong implements xi.g0<T>, io.reactivex.disposables.b, a {
        private static final long serialVersionUID = 3764492702657003550L;
        public final xi.g0<? super T> downstream;
        public final dj.o<? super T, ? extends xi.e0<?>> itemTimeoutIndicator;
        public final SequentialDisposable task = new SequentialDisposable();
        public final AtomicReference<io.reactivex.disposables.b> upstream = new AtomicReference<>();

        public TimeoutObserver(xi.g0<? super T> g0Var, dj.o<? super T, ? extends xi.e0<?>> oVar) {
            this.downstream = g0Var;
            this.itemTimeoutIndicator = oVar;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.b
        public void a(long j10) {
            if (compareAndSet(j10, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.upstream);
                this.downstream.onError(new TimeoutException());
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.a
        public void b(long j10, Throwable th2) {
            if (!compareAndSet(j10, Long.MAX_VALUE)) {
                kj.a.Y(th2);
            } else {
                DisposableHelper.dispose(this.upstream);
                this.downstream.onError(th2);
            }
        }

        public void c(xi.e0<?> e0Var) {
            if (e0Var != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0L, this);
                if (this.task.a(timeoutConsumer)) {
                    e0Var.c(timeoutConsumer);
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            this.task.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // xi.g0
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                kj.a.Y(th2);
            } else {
                this.task.dispose();
                this.downstream.onError(th2);
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            long j10 = get();
            if (j10 != Long.MAX_VALUE) {
                long j11 = 1 + j10;
                if (compareAndSet(j10, j11)) {
                    io.reactivex.disposables.b bVar = this.task.get();
                    if (bVar != null) {
                        bVar.dispose();
                    }
                    this.downstream.onNext(t10);
                    try {
                        xi.e0 e0Var = (xi.e0) io.reactivex.internal.functions.a.g(this.itemTimeoutIndicator.apply(t10), "The itemTimeoutIndicator returned a null ObservableSource.");
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j11, this);
                        if (this.task.a(timeoutConsumer)) {
                            e0Var.c(timeoutConsumer);
                        }
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        this.upstream.get().dispose();
                        getAndSet(Long.MAX_VALUE);
                        this.downstream.onError(th2);
                    }
                }
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }
    }

    public interface a extends ObservableTimeoutTimed.b {
        void b(long j10, Throwable th2);
    }

    public ObservableTimeout(xi.z<T> zVar, xi.e0<U> e0Var, dj.o<? super T, ? extends xi.e0<V>> oVar, xi.e0<? extends T> e0Var2) {
        super(zVar);
        this.f34369b = e0Var;
        this.f34370c = oVar;
        this.f34371d = e0Var2;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        if (this.f34371d == null) {
            TimeoutObserver timeoutObserver = new TimeoutObserver(g0Var, this.f34370c);
            g0Var.onSubscribe(timeoutObserver);
            timeoutObserver.c(this.f34369b);
            this.f34421a.c(timeoutObserver);
            return;
        }
        TimeoutFallbackObserver timeoutFallbackObserver = new TimeoutFallbackObserver(g0Var, this.f34370c, this.f34371d);
        g0Var.onSubscribe(timeoutFallbackObserver);
        timeoutFallbackObserver.c(this.f34369b);
        this.f34421a.c(timeoutFallbackObserver);
    }
}
