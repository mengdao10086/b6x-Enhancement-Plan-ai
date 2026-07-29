package io.reactivex.internal.operators.mixed;

import bu.e;
import dj.o;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import xi.d;
import xi.g;
import xi.j;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableSwitchMapCompletable<T> extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j<T> f34043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o<? super T, ? extends g> f34044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f34045c;

    public static final class SwitchMapCompletableObserver<T> implements xi.o<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final SwitchMapInnerObserver f34046h = new SwitchMapInnerObserver(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f34047a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final o<? super T, ? extends g> f34048b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f34049c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicThrowable f34050d = new AtomicThrowable();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicReference<SwitchMapInnerObserver> f34051e = new AtomicReference<>();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public volatile boolean f34052f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public e f34053g;

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
            this.f34047a = dVar;
            this.f34048b = oVar;
            this.f34049c = z10;
        }

        public void a() {
            AtomicReference<SwitchMapInnerObserver> atomicReference = this.f34051e;
            SwitchMapInnerObserver switchMapInnerObserver = f34046h;
            SwitchMapInnerObserver andSet = atomicReference.getAndSet(switchMapInnerObserver);
            if (andSet == null || andSet == switchMapInnerObserver) {
                return;
            }
            andSet.a();
        }

        public void b(SwitchMapInnerObserver switchMapInnerObserver) {
            if (this.f34051e.compareAndSet(switchMapInnerObserver, null) && this.f34052f) {
                Throwable thC = this.f34050d.c();
                if (thC == null) {
                    this.f34047a.onComplete();
                } else {
                    this.f34047a.onError(thC);
                }
            }
        }

        public void c(SwitchMapInnerObserver switchMapInnerObserver, Throwable th2) {
            if (!this.f34051e.compareAndSet(switchMapInnerObserver, null) || !this.f34050d.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            if (this.f34049c) {
                if (this.f34052f) {
                    this.f34047a.onError(this.f34050d.c());
                    return;
                }
                return;
            }
            dispose();
            Throwable thC = this.f34050d.c();
            if (thC != ExceptionHelper.f35249a) {
                this.f34047a.onError(thC);
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34053g.cancel();
            a();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34051e.get() == f34046h;
        }

        @Override // bu.d
        public void onComplete() {
            this.f34052f = true;
            if (this.f34051e.get() == null) {
                Throwable thC = this.f34050d.c();
                if (thC == null) {
                    this.f34047a.onComplete();
                } else {
                    this.f34047a.onError(thC);
                }
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (!this.f34050d.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            if (this.f34049c) {
                onComplete();
                return;
            }
            a();
            Throwable thC = this.f34050d.c();
            if (thC != ExceptionHelper.f35249a) {
                this.f34047a.onError(thC);
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            SwitchMapInnerObserver switchMapInnerObserver;
            try {
                g gVar = (g) io.reactivex.internal.functions.a.g(this.f34048b.apply(t10), "The mapper returned a null CompletableSource");
                SwitchMapInnerObserver switchMapInnerObserver2 = new SwitchMapInnerObserver(this);
                do {
                    switchMapInnerObserver = this.f34051e.get();
                    if (switchMapInnerObserver == f34046h) {
                        return;
                    }
                } while (!this.f34051e.compareAndSet(switchMapInnerObserver, switchMapInnerObserver2));
                if (switchMapInnerObserver != null) {
                    switchMapInnerObserver.a();
                }
                gVar.a(switchMapInnerObserver2);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f34053g.cancel();
                onError(th2);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(e eVar) {
            if (SubscriptionHelper.validate(this.f34053g, eVar)) {
                this.f34053g = eVar;
                this.f34047a.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableSwitchMapCompletable(j<T> jVar, o<? super T, ? extends g> oVar, boolean z10) {
        this.f34043a = jVar;
        this.f34044b = oVar;
        this.f34045c = z10;
    }

    @Override // xi.a
    public void I0(d dVar) {
        this.f34043a.j6(new SwitchMapCompletableObserver(dVar, this.f34044b, this.f34045c));
    }
}
