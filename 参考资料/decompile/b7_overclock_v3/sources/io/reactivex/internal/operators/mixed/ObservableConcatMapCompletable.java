package io.reactivex.internal.operators.mixed;

import dj.o;
import fj.j;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import xi.d;
import xi.g;
import xi.g0;
import xi.z;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableConcatMapCompletable<T> extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z<T> f34066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o<? super T, ? extends g> f34067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ErrorMode f34068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f34069d;

    public static final class ConcatMapCompletableObserver<T> extends AtomicInteger implements g0<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 3610901111000061034L;
        public volatile boolean active;
        public volatile boolean disposed;
        public volatile boolean done;
        public final d downstream;
        public final ErrorMode errorMode;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final ConcatMapInnerObserver inner = new ConcatMapInnerObserver(this);
        public final o<? super T, ? extends g> mapper;
        public final int prefetch;
        public fj.o<T> queue;
        public io.reactivex.disposables.b upstream;

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
        }

        public void a() {
            boolean z10;
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicThrowable atomicThrowable = this.errors;
            ErrorMode errorMode = this.errorMode;
            while (!this.disposed) {
                if (!this.active) {
                    if (errorMode == ErrorMode.BOUNDARY && atomicThrowable.get() != null) {
                        this.disposed = true;
                        this.queue.clear();
                        this.downstream.onError(atomicThrowable.c());
                        return;
                    }
                    boolean z11 = this.done;
                    g gVar = null;
                    try {
                        T tPoll = this.queue.poll();
                        if (tPoll != null) {
                            gVar = (g) io.reactivex.internal.functions.a.g(this.mapper.apply(tPoll), "The mapper returned a null CompletableSource");
                            z10 = false;
                        } else {
                            z10 = true;
                        }
                        if (z11 && z10) {
                            this.disposed = true;
                            Throwable thC = atomicThrowable.c();
                            if (thC != null) {
                                this.downstream.onError(thC);
                                return;
                            } else {
                                this.downstream.onComplete();
                                return;
                            }
                        }
                        if (!z10) {
                            this.active = true;
                            gVar.a(this.inner);
                        }
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        this.disposed = true;
                        this.queue.clear();
                        this.upstream.dispose();
                        atomicThrowable.a(th2);
                        this.downstream.onError(atomicThrowable.c());
                        return;
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
            this.disposed = true;
            this.upstream.dispose();
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
            this.upstream.dispose();
            this.inner.a();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // xi.g0
        public void onComplete() {
            this.done = true;
            a();
        }

        @Override // xi.g0
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
            this.disposed = true;
            this.inner.a();
            Throwable thC = this.errors.c();
            if (thC != ExceptionHelper.f35249a) {
                this.downstream.onError(thC);
            }
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (t10 != null) {
                this.queue.offer(t10);
            }
            a();
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                if (bVar instanceof j) {
                    j jVar = (j) bVar;
                    int iRequestFusion = jVar.requestFusion(3);
                    if (iRequestFusion == 1) {
                        this.queue = jVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        a();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.queue = jVar;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new io.reactivex.internal.queue.a(this.prefetch);
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapCompletable(z<T> zVar, o<? super T, ? extends g> oVar, ErrorMode errorMode, int i10) {
        this.f34066a = zVar;
        this.f34067b = oVar;
        this.f34068c = errorMode;
        this.f34069d = i10;
    }

    @Override // xi.a
    public void I0(d dVar) {
        if (b.a(this.f34066a, this.f34067b, dVar)) {
            return;
        }
        this.f34066a.c(new ConcatMapCompletableObserver(dVar, this.f34067b, this.f34068c, this.f34069d));
    }
}
