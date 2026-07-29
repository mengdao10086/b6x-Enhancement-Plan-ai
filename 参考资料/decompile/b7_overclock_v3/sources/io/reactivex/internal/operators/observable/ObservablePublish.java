package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservablePublish<T> extends ij.a<T> implements fj.g<T>, d1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.e0<T> f34252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<a<T>> f34253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xi.e0<T> f34254c;

    public static final class InnerDisposable<T> extends AtomicReference<Object> implements io.reactivex.disposables.b {
        private static final long serialVersionUID = -1100270633763673112L;
        public final xi.g0<? super T> child;

        public InnerDisposable(xi.g0<? super T> g0Var) {
            this.child = g0Var;
        }

        public void a(a<T> aVar) {
            if (compareAndSet(null, aVar)) {
                return;
            }
            aVar.b(this);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            Object andSet = getAndSet(this);
            if (andSet == null || andSet == this) {
                return;
            }
            ((a) andSet).b(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == this;
        }
    }

    public static final class a<T> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final InnerDisposable[] f34255e = new InnerDisposable[0];

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final InnerDisposable[] f34256f = new InnerDisposable[0];

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReference<a<T>> f34257a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicReference<io.reactivex.disposables.b> f34260d = new AtomicReference<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReference<InnerDisposable<T>[]> f34258b = new AtomicReference<>(f34255e);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicBoolean f34259c = new AtomicBoolean();

        public a(AtomicReference<a<T>> atomicReference) {
            this.f34257a = atomicReference;
        }

        public boolean a(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable<T>[] innerDisposableArr2;
            do {
                innerDisposableArr = this.f34258b.get();
                if (innerDisposableArr == f34256f) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[length + 1];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!this.f34258b.compareAndSet(innerDisposableArr, innerDisposableArr2));
            return true;
        }

        public void b(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable<T>[] innerDisposableArr2;
            do {
                innerDisposableArr = this.f34258b.get();
                int length = innerDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i10 = -1;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    }
                    if (innerDisposableArr[i11].equals(innerDisposable)) {
                        i10 = i11;
                        break;
                    }
                    i11++;
                }
                if (i10 < 0) {
                    return;
                }
                if (length == 1) {
                    innerDisposableArr2 = f34255e;
                } else {
                    InnerDisposable<T>[] innerDisposableArr3 = new InnerDisposable[length - 1];
                    System.arraycopy(innerDisposableArr, 0, innerDisposableArr3, 0, i10);
                    System.arraycopy(innerDisposableArr, i10 + 1, innerDisposableArr3, i10, (length - i10) - 1);
                    innerDisposableArr2 = innerDisposableArr3;
                }
            } while (!this.f34258b.compareAndSet(innerDisposableArr, innerDisposableArr2));
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            AtomicReference<InnerDisposable<T>[]> atomicReference = this.f34258b;
            InnerDisposable<T>[] innerDisposableArr = f34256f;
            if (atomicReference.getAndSet(innerDisposableArr) != innerDisposableArr) {
                this.f34257a.compareAndSet(this, null);
                DisposableHelper.dispose(this.f34260d);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34258b.get() == f34256f;
        }

        @Override // xi.g0
        public void onComplete() {
            this.f34257a.compareAndSet(this, null);
            for (InnerDisposable<T> innerDisposable : this.f34258b.getAndSet(f34256f)) {
                innerDisposable.child.onComplete();
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.f34257a.compareAndSet(this, null);
            InnerDisposable<T>[] andSet = this.f34258b.getAndSet(f34256f);
            if (andSet.length == 0) {
                kj.a.Y(th2);
                return;
            }
            for (InnerDisposable<T> innerDisposable : andSet) {
                innerDisposable.child.onError(th2);
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            for (InnerDisposable<T> innerDisposable : this.f34258b.get()) {
                innerDisposable.child.onNext(t10);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.f34260d, bVar);
        }
    }

    public static final class b<T> implements xi.e0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReference<a<T>> f34261a;

        public b(AtomicReference<a<T>> atomicReference) {
            this.f34261a = atomicReference;
        }

        @Override // xi.e0
        public void c(xi.g0<? super T> g0Var) {
            InnerDisposable innerDisposable = new InnerDisposable(g0Var);
            g0Var.onSubscribe(innerDisposable);
            while (true) {
                a<T> aVar = this.f34261a.get();
                if (aVar == null || aVar.isDisposed()) {
                    a<T> aVar2 = new a<>(this.f34261a);
                    if (this.f34261a.compareAndSet(aVar, aVar2)) {
                        aVar = aVar2;
                    } else {
                        continue;
                    }
                }
                if (aVar.a(innerDisposable)) {
                    innerDisposable.a(aVar);
                    return;
                }
            }
        }
    }

    public ObservablePublish(xi.e0<T> e0Var, xi.e0<T> e0Var2, AtomicReference<a<T>> atomicReference) {
        this.f34254c = e0Var;
        this.f34252a = e0Var2;
        this.f34253b = atomicReference;
    }

    public static <T> ij.a<T> u8(xi.e0<T> e0Var) {
        AtomicReference atomicReference = new AtomicReference();
        return kj.a.P(new ObservablePublish(new b(atomicReference), e0Var, atomicReference));
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34254c.c(g0Var);
    }

    @Override // io.reactivex.internal.operators.observable.d1
    public xi.e0<T> b() {
        return this.f34252a;
    }

    @Override // ij.a
    public void m8(dj.g<? super io.reactivex.disposables.b> gVar) {
        a<T> aVar;
        while (true) {
            aVar = this.f34253b.get();
            if (aVar != null && !aVar.isDisposed()) {
                break;
            }
            a<T> aVar2 = new a<>(this.f34253b);
            if (this.f34253b.compareAndSet(aVar, aVar2)) {
                aVar = aVar2;
                break;
            }
        }
        boolean z10 = !aVar.f34259c.get() && aVar.f34259c.compareAndSet(false, true);
        try {
            gVar.accept(aVar);
            if (z10) {
                this.f34252a.c(aVar);
            }
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            throw ExceptionHelper.f(th2);
        }
    }

    @Override // fj.g
    public xi.e0<T> source() {
        return this.f34252a;
    }
}
