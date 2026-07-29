package io.reactivex.internal.operators.mixed;

import dj.o;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import xi.g0;
import xi.l0;
import xi.o0;
import xi.z;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableSwitchMapSingle<T, R> extends z<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z<T> f34099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o<? super T, ? extends o0<? extends R>> f34100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f34101c;

    public static final class SwitchMapSingleMainObserver<T, R> extends AtomicInteger implements g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SwitchMapSingleObserver<Object> f34102a = new SwitchMapSingleObserver<>(null);
        private static final long serialVersionUID = -5402190102429853762L;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public volatile boolean done;
        public final g0<? super R> downstream;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final AtomicReference<SwitchMapSingleObserver<R>> inner = new AtomicReference<>();
        public final o<? super T, ? extends o0<? extends R>> mapper;
        public io.reactivex.disposables.b upstream;

        public static final class SwitchMapSingleObserver<R> extends AtomicReference<io.reactivex.disposables.b> implements l0<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            public volatile R item;
            public final SwitchMapSingleMainObserver<?, R> parent;

            public SwitchMapSingleObserver(SwitchMapSingleMainObserver<?, R> switchMapSingleMainObserver) {
                this.parent = switchMapSingleMainObserver;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            @Override // xi.l0
            public void onError(Throwable th2) {
                this.parent.c(this, th2);
            }

            @Override // xi.l0
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // xi.l0
            public void onSuccess(R r10) {
                this.item = r10;
                this.parent.b();
            }
        }

        public SwitchMapSingleMainObserver(g0<? super R> g0Var, o<? super T, ? extends o0<? extends R>> oVar, boolean z10) {
            this.downstream = g0Var;
            this.mapper = oVar;
            this.delayErrors = z10;
        }

        public void a() {
            AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.inner;
            SwitchMapSingleObserver<Object> switchMapSingleObserver = f34102a;
            SwitchMapSingleObserver<R> andSet = atomicReference.getAndSet((SwitchMapSingleObserver<R>) switchMapSingleObserver);
            if (andSet == null || andSet == switchMapSingleObserver) {
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
            AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.inner;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (atomicThrowable.get() != null && !this.delayErrors) {
                    g0Var.onError(atomicThrowable.c());
                    return;
                }
                boolean z10 = this.done;
                SwitchMapSingleObserver<R> switchMapSingleObserver = atomicReference.get();
                boolean z11 = switchMapSingleObserver == null;
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
                if (z11 || switchMapSingleObserver.item == null) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    atomicReference.compareAndSet(switchMapSingleObserver, null);
                    g0Var.onNext(switchMapSingleObserver.item);
                }
            }
        }

        public void c(SwitchMapSingleObserver<R> switchMapSingleObserver, Throwable th2) {
            if (!this.inner.compareAndSet(switchMapSingleObserver, null) || !this.errors.a(th2)) {
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
            SwitchMapSingleObserver<R> switchMapSingleObserver;
            SwitchMapSingleObserver<R> switchMapSingleObserver2 = this.inner.get();
            if (switchMapSingleObserver2 != null) {
                switchMapSingleObserver2.a();
            }
            try {
                o0 o0Var = (o0) io.reactivex.internal.functions.a.g(this.mapper.apply(t10), "The mapper returned a null SingleSource");
                SwitchMapSingleObserver<R> switchMapSingleObserver3 = new SwitchMapSingleObserver<>(this);
                do {
                    switchMapSingleObserver = this.inner.get();
                    if (switchMapSingleObserver == f34102a) {
                        return;
                    }
                } while (!this.inner.compareAndSet(switchMapSingleObserver, switchMapSingleObserver3));
                o0Var.a(switchMapSingleObserver3);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.upstream.dispose();
                this.inner.getAndSet((SwitchMapSingleObserver<R>) f34102a);
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

    public ObservableSwitchMapSingle(z<T> zVar, o<? super T, ? extends o0<? extends R>> oVar, boolean z10) {
        this.f34099a = zVar;
        this.f34100b = oVar;
        this.f34101c = z10;
    }

    @Override // xi.z
    public void I5(g0<? super R> g0Var) {
        if (b.c(this.f34099a, this.f34100b, g0Var)) {
            return;
        }
        this.f34099a.c(new SwitchMapSingleMainObserver(g0Var, this.f34100b, this.f34101c));
    }
}
