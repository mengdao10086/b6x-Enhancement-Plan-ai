package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableSwitchMap<T, R> extends a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super T, ? extends xi.e0<? extends R>> f34350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f34351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f34352d;

    public static final class SwitchMapInnerObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements xi.g0<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        public final int bufferSize;
        public volatile boolean done;
        public final long index;
        public final SwitchMapObserver<T, R> parent;
        public volatile fj.o<R> queue;

        public SwitchMapInnerObserver(SwitchMapObserver<T, R> switchMapObserver, long j10, int i10) {
            this.parent = switchMapObserver;
            this.index = j10;
            this.bufferSize = i10;
        }

        public void a() {
            DisposableHelper.dispose(this);
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.index == this.parent.unique) {
                this.done = true;
                this.parent.b();
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.parent.c(this, th2);
        }

        @Override // xi.g0
        public void onNext(R r10) {
            if (this.index == this.parent.unique) {
                if (r10 != null) {
                    this.queue.offer(r10);
                }
                this.parent.b();
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                if (bVar instanceof fj.j) {
                    fj.j jVar = (fj.j) bVar;
                    int iRequestFusion = jVar.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.queue = jVar;
                        this.done = true;
                        this.parent.b();
                        return;
                    } else if (iRequestFusion == 2) {
                        this.queue = jVar;
                        return;
                    }
                }
                this.queue = new io.reactivex.internal.queue.a(this.bufferSize);
            }
        }
    }

    public static final class SwitchMapObserver<T, R> extends AtomicInteger implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SwitchMapInnerObserver<Object, Object> f34353a;
        private static final long serialVersionUID = -3491074160481096299L;
        public final int bufferSize;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public volatile boolean done;
        public final xi.g0<? super R> downstream;
        public final dj.o<? super T, ? extends xi.e0<? extends R>> mapper;
        public volatile long unique;
        public io.reactivex.disposables.b upstream;
        public final AtomicReference<SwitchMapInnerObserver<T, R>> active = new AtomicReference<>();
        public final AtomicThrowable errors = new AtomicThrowable();

        static {
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver = new SwitchMapInnerObserver<>(null, -1L, 1);
            f34353a = switchMapInnerObserver;
            switchMapInnerObserver.a();
        }

        public SwitchMapObserver(xi.g0<? super R> g0Var, dj.o<? super T, ? extends xi.e0<? extends R>> oVar, int i10, boolean z10) {
            this.downstream = g0Var;
            this.mapper = oVar;
            this.bufferSize = i10;
            this.delayErrors = z10;
        }

        public void a() {
            SwitchMapInnerObserver<T, R> andSet;
            SwitchMapInnerObserver<T, R> switchMapInnerObserver = this.active.get();
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver2 = f34353a;
            if (switchMapInnerObserver == switchMapInnerObserver2 || (andSet = this.active.getAndSet((SwitchMapInnerObserver<T, R>) switchMapInnerObserver2)) == switchMapInnerObserver2 || andSet == null) {
                return;
            }
            andSet.a();
        }

        /* JADX WARN: Removed duplicated region for block: B:101:0x000f A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:95:0x00e9 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void b() {
            /*
                Method dump skipped, instruction units count: 241
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapObserver.b():void");
        }

        public void c(SwitchMapInnerObserver<T, R> switchMapInnerObserver, Throwable th2) {
            if (switchMapInnerObserver.index != this.unique || !this.errors.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            if (!this.delayErrors) {
                this.upstream.dispose();
                this.done = true;
            }
            switchMapInnerObserver.done = true;
            b();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled) {
                return;
            }
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
            if (this.done) {
                return;
            }
            this.done = true;
            b();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.done || !this.errors.a(th2)) {
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
            SwitchMapInnerObserver<T, R> switchMapInnerObserver;
            long j10 = this.unique + 1;
            this.unique = j10;
            SwitchMapInnerObserver<T, R> switchMapInnerObserver2 = this.active.get();
            if (switchMapInnerObserver2 != null) {
                switchMapInnerObserver2.a();
            }
            try {
                xi.e0 e0Var = (xi.e0) io.reactivex.internal.functions.a.g(this.mapper.apply(t10), "The ObservableSource returned is null");
                SwitchMapInnerObserver<T, R> switchMapInnerObserver3 = new SwitchMapInnerObserver<>(this, j10, this.bufferSize);
                do {
                    switchMapInnerObserver = this.active.get();
                    if (switchMapInnerObserver == f34353a) {
                        return;
                    }
                } while (!this.active.compareAndSet(switchMapInnerObserver, switchMapInnerObserver3));
                e0Var.c(switchMapInnerObserver3);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.upstream.dispose();
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

    public ObservableSwitchMap(xi.e0<T> e0Var, dj.o<? super T, ? extends xi.e0<? extends R>> oVar, int i10, boolean z10) {
        super(e0Var);
        this.f34350b = oVar;
        this.f34351c = i10;
        this.f34352d = z10;
    }

    @Override // xi.z
    public void I5(xi.g0<? super R> g0Var) {
        if (ObservableScalarXMap.b(this.f34421a, g0Var, this.f34350b)) {
            return;
        }
        this.f34421a.c(new SwitchMapObserver(g0Var, this.f34350b, this.f34351c, this.f34352d));
    }
}
