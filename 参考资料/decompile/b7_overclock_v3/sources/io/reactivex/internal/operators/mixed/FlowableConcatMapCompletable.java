package io.reactivex.internal.operators.mixed;

import bu.e;
import dj.o;
import fj.n;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import xi.d;
import xi.g;
import xi.j;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableConcatMapCompletable<T> extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j<T> f34025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o<? super T, ? extends g> f34026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ErrorMode f34027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f34028d;

    public static final class ConcatMapCompletableObserver<T> extends AtomicInteger implements xi.o<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 3610901111000061034L;
        public volatile boolean active;
        public int consumed;
        public volatile boolean disposed;
        public volatile boolean done;
        public final d downstream;
        public final ErrorMode errorMode;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final ConcatMapInnerObserver inner = new ConcatMapInnerObserver(this);
        public final o<? super T, ? extends g> mapper;
        public final int prefetch;
        public final n<T> queue;
        public e upstream;

        public static final class ConcatMapInnerObserver extends AtomicReference<io.reactivex.disposables.b> implements d {
            private static final long serialVersionUID = 5638352172918776687L;
            public final ConcatMapCompletableObserver<?> parent;

            public ConcatMapInnerObserver(ConcatMapCompletableObserver<?> concatMapCompletableObserver) {
                this.parent = concatMapCompletableObserver;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            @Override // xi.d, xi.t
            public void onComplete() {
                this.parent.b();
            }

            @Override // xi.d
            public void onError(Throwable th2) {
                this.parent.c(th2);
            }

            @Override // xi.d
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.replace(this, bVar);
            }
        }

        public ConcatMapCompletableObserver(d dVar, o<? super T, ? extends g> oVar, ErrorMode errorMode, int i10) {
            this.downstream = dVar;
            this.mapper = oVar;
            this.errorMode = errorMode;
            this.prefetch = i10;
            this.queue = new SpscArrayQueue(i10);
        }

        public void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!this.disposed) {
                if (!this.active) {
                    if (this.errorMode == ErrorMode.BOUNDARY && this.errors.get() != null) {
                        this.queue.clear();
                        this.downstream.onError(this.errors.c());
                        return;
                    }
                    boolean z10 = this.done;
                    T tPoll = this.queue.poll();
                    boolean z11 = tPoll == null;
                    if (z10 && z11) {
                        Throwable thC = this.errors.c();
                        if (thC != null) {
                            this.downstream.onError(thC);
                            return;
                        } else {
                            this.downstream.onComplete();
                            return;
                        }
                    }
                    if (!z11) {
                        int i10 = this.prefetch;
                        int i11 = i10 - (i10 >> 1);
                        int i12 = this.consumed + 1;
                        if (i12 == i11) {
                            this.consumed = 0;
                            this.upstream.request(i11);
                        } else {
                            this.consumed = i12;
                        }
                        try {
                            g gVar = (g) io.reactivex.internal.functions.a.g(this.mapper.apply(tPoll), "The mapper returned a null CompletableSource");
                            this.active = true;
                            gVar.a(this.inner);
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.b(th2);
                            this.queue.clear();
                            this.upstream.cancel();
                            this.errors.a(th2);
                            this.downstream.onError(this.errors.c());
                            return;
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.queue.clear();
        }

        public void b() {
            this.active = false;
            a();
        }

        public void c(Throwable th2) {
            if (!this.errors.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            if (this.errorMode != ErrorMode.IMMEDIATE) {
                this.active = false;
                a();
                return;
            }
            this.upstream.cancel();
            Throwable thC = this.errors.c();
            if (thC != ExceptionHelper.f35249a) {
                this.downstream.onError(thC);
            }
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.disposed = true;
            this.upstream.cancel();
            this.inner.a();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // bu.d
        public void onComplete() {
            this.done = true;
            a();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (!this.errors.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            if (this.errorMode != ErrorMode.IMMEDIATE) {
                this.done = true;
                a();
                return;
            }
            this.inner.a();
            Throwable thC = this.errors.c();
            if (thC != ExceptionHelper.f35249a) {
                this.downstream.onError(thC);
            }
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.queue.offer(t10)) {
                a();
            } else {
                this.upstream.cancel();
                onError(new MissingBackpressureException("Queue full?!"));
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.downstream.onSubscribe(this);
                eVar.request(this.prefetch);
            }
        }
    }

    public FlowableConcatMapCompletable(j<T> jVar, o<? super T, ? extends g> oVar, ErrorMode errorMode, int i10) {
        this.f34025a = jVar;
        this.f34026b = oVar;
        this.f34027c = errorMode;
        this.f34028d = i10;
    }

    @Override // xi.a
    public void I0(d dVar) {
        this.f34025a.j6(new ConcatMapCompletableObserver(dVar, this.f34026b, this.f34027c, this.f34028d));
    }
}
