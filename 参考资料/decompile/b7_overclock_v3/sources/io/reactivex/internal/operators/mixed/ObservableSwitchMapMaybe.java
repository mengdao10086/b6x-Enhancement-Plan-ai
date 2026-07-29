package io.reactivex.internal.operators.mixed;

import dj.o;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import xi.g0;
import xi.t;
import xi.w;
import xi.z;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableSwitchMapMaybe<T, R> extends z<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z<T> f34095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o<? super T, ? extends w<? extends R>> f34096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f34097c;

    public static final class SwitchMapMaybeMainObserver<T, R> extends AtomicInteger implements g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SwitchMapMaybeObserver<Object> f34098a = new SwitchMapMaybeObserver<>(null);
        private static final long serialVersionUID = -5402190102429853762L;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public volatile boolean done;
        public final g0<? super R> downstream;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final AtomicReference<SwitchMapMaybeObserver<R>> inner = new AtomicReference<>();
        public final o<? super T, ? extends w<? extends R>> mapper;
        public io.reactivex.disposables.b upstream;

        public static final class SwitchMapMaybeObserver<R> extends AtomicReference<io.reactivex.disposables.b> implements t<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            public volatile R item;
            public final SwitchMapMaybeMainObserver<?, R> parent;

            public SwitchMapMaybeObserver(SwitchMapMaybeMainObserver<?, R> switchMapMaybeMainObserver) {
                this.parent = switchMapMaybeMainObserver;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            @Override // xi.t
            public void onComplete() {
                this.parent.c(this);
            }

            @Override // xi.t
            public void onError(Throwable th2) {
                this.parent.d(this, th2);
            }

            @Override // xi.t
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // xi.t
            public void onSuccess(R r10) {
                this.item = r10;
                this.parent.b();
            }
        }

        public SwitchMapMaybeMainObserver(g0<? super R> g0Var, o<? super T, ? extends w<? extends R>> oVar, boolean z10) {
            this.downstream = g0Var;
            this.mapper = oVar;
            this.delayErrors = z10;
        }

        public void a() {
            AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.inner;
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver = f34098a;
            SwitchMapMaybeObserver<R> andSet = atomicReference.getAndSet((SwitchMapMaybeObserver<R>) switchMapMaybeObserver);
            if (andSet == null || andSet == switchMapMaybeObserver) {
                return;
            }
            andSet.a();
        }

        public void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            g0<? super R> g0Var = this.downstream;
            AtomicThrowable atomicThrowable = this.errors;
            AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.inner;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (atomicThrowable.get() != null && !this.delayErrors) {
                    g0Var.onError(atomicThrowable.c());
                    return;
                }
                boolean z10 = this.done;
                SwitchMapMaybeObserver<R> switchMapMaybeObserver = atomicReference.get();
                boolean z11 = switchMapMaybeObserver == null;
                if (z10 && z11) {
                    Throwable thC = atomicThrowable.c();
                    if (thC != null) {
                        g0Var.onError(thC);
                        return;
                    } else {
                        g0Var.onComplete();
                        return;
                    }
                }
                if (z11 || switchMapMaybeObserver.item == null) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    atomicReference.compareAndSet(switchMapMaybeObserver, null);
                    g0Var.onNext(switchMapMaybeObserver.item);
                }
            }
        }

        public void c(SwitchMapMaybeObserver<R> switchMapMaybeObserver) {
            if (this.inner.compareAndSet(switchMapMaybeObserver, null)) {
                b();
            }
        }

        public void d(SwitchMapMaybeObserver<R> switchMapMaybeObserver, Throwable th2) {
            if (!this.inner.compareAndSet(switchMapMaybeObserver, null) || !this.errors.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            if (!this.delayErrors) {
                this.upstream.dispose();
                a();
            }
            b();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            a();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // xi.g0
        public void onComplete() {
            this.done = true;
            b();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (!this.errors.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            if (!this.delayErrors) {
                a();
            }
            this.done = true;
            b();
        }

        @Override // xi.g0
        public void onNext(T t10) {
            SwitchMapMaybeObserver<R> switchMapMaybeObserver;
            SwitchMapMaybeObserver<R> switchMapMaybeObserver2 = this.inner.get();
            if (switchMapMaybeObserver2 != null) {
                switchMapMaybeObserver2.a();
            }
            try {
                w wVar = (w) io.reactivex.internal.functions.a.g(this.mapper.apply(t10), "The mapper returned a null MaybeSource");
                SwitchMapMaybeObserver<R> switchMapMaybeObserver3 = new SwitchMapMaybeObserver<>(this);
                do {
                    switchMapMaybeObserver = this.inner.get();
                    if (switchMapMaybeObserver == f34098a) {
                        return;
                    }
                } while (!this.inner.compareAndSet(switchMapMaybeObserver, switchMapMaybeObserver3));
                wVar.a(switchMapMaybeObserver3);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.upstream.dispose();
                this.inner.getAndSet((SwitchMapMaybeObserver<R>) f34098a);
                onError(th2);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMapMaybe(z<T> zVar, o<? super T, ? extends w<? extends R>> oVar, boolean z10) {
        this.f34095a = zVar;
        this.f34096b = oVar;
        this.f34097c = z10;
    }

    @Override // xi.z
    public void I5(g0<? super R> g0Var) {
        if (b.b(this.f34095a, this.f34096b, g0Var)) {
            return;
        }
        this.f34095a.c(new SwitchMapMaybeMainObserver(g0Var, this.f34096b, this.f34097c));
    }
}
