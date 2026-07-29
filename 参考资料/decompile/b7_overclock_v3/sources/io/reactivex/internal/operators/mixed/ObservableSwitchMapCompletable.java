package io.reactivex.internal.operators.mixed;

import dj.o;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import xi.d;
import xi.g;
import xi.g0;
import xi.z;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableSwitchMapCompletable<T> extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z<T> f34084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o<? super T, ? extends g> f34085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f34086c;

    public static final class SwitchMapCompletableObserver<T> implements g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final SwitchMapInnerObserver f34087h = new SwitchMapInnerObserver(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f34088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final o<? super T, ? extends g> f34089b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f34090c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicThrowable f34091d = new AtomicThrowable();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicReference<SwitchMapInnerObserver> f34092e = new AtomicReference<>();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public volatile boolean f34093f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public io.reactivex.disposables.b f34094g;

        public static final class SwitchMapInnerObserver extends AtomicReference<io.reactivex.disposables.b> implements d {
            private static final long serialVersionUID = -8003404460084760287L;
            public final SwitchMapCompletableObserver<?> parent;

            public SwitchMapInnerObserver(SwitchMapCompletableObserver<?> switchMapCompletableObserver) {
                this.parent = switchMapCompletableObserver;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            @Override // xi.d, xi.t
            public void onComplete() {
                this.parent.b(this);
            }

            @Override // xi.d
            public void onError(Throwable th2) {
                this.parent.c(this, th2);
            }

            @Override // xi.d
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }
        }

        public SwitchMapCompletableObserver(d dVar, o<? super T, ? extends g> oVar, boolean z10) {
            this.f34088a = dVar;
            this.f34089b = oVar;
            this.f34090c = z10;
        }

        public void a() {
            AtomicReference<SwitchMapInnerObserver> atomicReference = this.f34092e;
            SwitchMapInnerObserver switchMapInnerObserver = f34087h;
            SwitchMapInnerObserver andSet = atomicReference.getAndSet(switchMapInnerObserver);
            if (andSet == null || andSet == switchMapInnerObserver) {
                return;
            }
            andSet.a();
        }

        public void b(SwitchMapInnerObserver switchMapInnerObserver) {
            if (this.f34092e.compareAndSet(switchMapInnerObserver, null) && this.f34093f) {
                Throwable thC = this.f34091d.c();
                if (thC == null) {
                    this.f34088a.onComplete();
                } else {
                    this.f34088a.onError(thC);
                }
            }
        }

        public void c(SwitchMapInnerObserver switchMapInnerObserver, Throwable th2) {
            if (!this.f34092e.compareAndSet(switchMapInnerObserver, null) || !this.f34091d.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            if (this.f34090c) {
                if (this.f34093f) {
                    this.f34088a.onError(this.f34091d.c());
                    return;
                }
                return;
            }
            dispose();
            Throwable thC = this.f34091d.c();
            if (thC != ExceptionHelper.f35249a) {
                this.f34088a.onError(thC);
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34094g.dispose();
            a();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34092e.get() == f34087h;
        }

        @Override // xi.g0
        public void onComplete() {
            this.f34093f = true;
            if (this.f34092e.get() == null) {
                Throwable thC = this.f34091d.c();
                if (thC == null) {
                    this.f34088a.onComplete();
                } else {
                    this.f34088a.onError(thC);
                }
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (!this.f34091d.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            if (this.f34090c) {
                onComplete();
                return;
            }
            a();
            Throwable thC = this.f34091d.c();
            if (thC != ExceptionHelper.f35249a) {
                this.f34088a.onError(thC);
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            SwitchMapInnerObserver switchMapInnerObserver;
            try {
                g gVar = (g) io.reactivex.internal.functions.a.g(this.f34089b.apply(t10), "The mapper returned a null CompletableSource");
                SwitchMapInnerObserver switchMapInnerObserver2 = new SwitchMapInnerObserver(this);
                do {
                    switchMapInnerObserver = this.f34092e.get();
                    if (switchMapInnerObserver == f34087h) {
                        return;
                    }
                } while (!this.f34092e.compareAndSet(switchMapInnerObserver, switchMapInnerObserver2));
                if (switchMapInnerObserver != null) {
                    switchMapInnerObserver.a();
                }
                gVar.a(switchMapInnerObserver2);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f34094g.dispose();
                onError(th2);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34094g, bVar)) {
                this.f34094g = bVar;
                this.f34088a.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMapCompletable(z<T> zVar, o<? super T, ? extends g> oVar, boolean z10) {
        this.f34084a = zVar;
        this.f34085b = oVar;
        this.f34086c = z10;
    }

    @Override // xi.a
    public void I0(d dVar) {
        if (b.a(this.f34084a, this.f34085b, dVar)) {
            return;
        }
        this.f34084a.c(new SwitchMapCompletableObserver(dVar, this.f34085b, this.f34086c));
    }
}
