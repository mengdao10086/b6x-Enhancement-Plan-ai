package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import xi.l0;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeEqualSingle<T> extends xi.i0<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.w<? extends T> f33852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.w<? extends T> f33853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.d<? super T, ? super T> f33854c;

    public static final class EqualCoordinator<T> extends AtomicInteger implements io.reactivex.disposables.b {
        public final l0<? super Boolean> downstream;
        public final dj.d<? super T, ? super T> isEqual;
        public final EqualObserver<T> observer1;
        public final EqualObserver<T> observer2;

        public EqualCoordinator(l0<? super Boolean> l0Var, dj.d<? super T, ? super T> dVar) {
            super(2);
            this.downstream = l0Var;
            this.isEqual = dVar;
            this.observer1 = new EqualObserver<>(this);
            this.observer2 = new EqualObserver<>(this);
        }

        public void a() {
            if (decrementAndGet() == 0) {
                Object obj = this.observer1.value;
                Object obj2 = this.observer2.value;
                if (obj == null || obj2 == null) {
                    this.downstream.onSuccess(Boolean.valueOf(obj == null && obj2 == null));
                    return;
                }
                try {
                    this.downstream.onSuccess(Boolean.valueOf(this.isEqual.a(obj, obj2)));
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.downstream.onError(th2);
                }
            }
        }

        public void b(EqualObserver<T> equalObserver, Throwable th2) {
            if (getAndSet(0) <= 0) {
                kj.a.Y(th2);
                return;
            }
            EqualObserver<T> equalObserver2 = this.observer1;
            if (equalObserver == equalObserver2) {
                this.observer2.a();
            } else {
                equalObserver2.a();
            }
            this.downstream.onError(th2);
        }

        public void c(xi.w<? extends T> wVar, xi.w<? extends T> wVar2) {
            wVar.a(this.observer1);
            wVar2.a(this.observer2);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.observer1.a();
            this.observer2.a();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.observer1.get());
        }
    }

    public static final class EqualObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xi.t<T> {
        private static final long serialVersionUID = -3031974433025990931L;
        public final EqualCoordinator<T> parent;
        public Object value;

        public EqualObserver(EqualCoordinator<T> equalCoordinator) {
            this.parent = equalCoordinator;
        }

        public void a() {
            DisposableHelper.dispose(this);
        }

        @Override // xi.t
        public void onComplete() {
            this.parent.a();
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            this.parent.b(this, th2);
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            this.value = t10;
            this.parent.a();
        }
    }

    public MaybeEqualSingle(xi.w<? extends T> wVar, xi.w<? extends T> wVar2, dj.d<? super T, ? super T> dVar) {
        this.f33852a = wVar;
        this.f33853b = wVar2;
        this.f33854c = dVar;
    }

    @Override // xi.i0
    public void b1(l0<? super Boolean> l0Var) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(l0Var, this.f33854c);
        l0Var.onSubscribe(equalCoordinator);
        equalCoordinator.c(this.f33852a, this.f33853b);
    }
}
