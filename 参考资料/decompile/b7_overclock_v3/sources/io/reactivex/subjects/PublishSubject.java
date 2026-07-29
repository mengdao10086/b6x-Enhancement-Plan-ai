package io.reactivex.subjects;

import bj.e;
import bj.f;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import xi.g0;

/* JADX INFO: loaded from: classes5.dex */
public final class PublishSubject<T> extends c<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final PublishDisposable[] f35397c = new PublishDisposable[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final PublishDisposable[] f35398d = new PublishDisposable[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<PublishDisposable<T>[]> f35399a = new AtomicReference<>(f35398d);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Throwable f35400b;

    public static final class PublishDisposable<T> extends AtomicBoolean implements io.reactivex.disposables.b {
        private static final long serialVersionUID = 3562861878281475070L;
        public final g0<? super T> downstream;
        public final PublishSubject<T> parent;

        public PublishDisposable(g0<? super T> g0Var, PublishSubject<T> publishSubject) {
            this.downstream = g0Var;
            this.parent = publishSubject;
        }

        public void a() {
            if (get()) {
                return;
            }
            this.downstream.onComplete();
        }

        public void b(Throwable th2) {
            if (get()) {
                kj.a.Y(th2);
            } else {
                this.downstream.onError(th2);
            }
        }

        public void c(T t10) {
            if (get()) {
                return;
            }
            this.downstream.onNext(t10);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.p8(this);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get();
        }
    }

    @bj.c
    @e
    public static <T> PublishSubject<T> o8() {
        return new PublishSubject<>();
    }

    @Override // xi.z
    public void I5(g0<? super T> g0Var) {
        PublishDisposable<T> publishDisposable = new PublishDisposable<>(g0Var, this);
        g0Var.onSubscribe(publishDisposable);
        if (n8(publishDisposable)) {
            if (publishDisposable.isDisposed()) {
                p8(publishDisposable);
            }
        } else {
            Throwable th2 = this.f35400b;
            if (th2 != null) {
                g0Var.onError(th2);
            } else {
                g0Var.onComplete();
            }
        }
    }

    @Override // io.reactivex.subjects.c
    @f
    public Throwable i8() {
        if (this.f35399a.get() == f35397c) {
            return this.f35400b;
        }
        return null;
    }

    @Override // io.reactivex.subjects.c
    public boolean j8() {
        return this.f35399a.get() == f35397c && this.f35400b == null;
    }

    @Override // io.reactivex.subjects.c
    public boolean k8() {
        return this.f35399a.get().length != 0;
    }

    @Override // io.reactivex.subjects.c
    public boolean l8() {
        return this.f35399a.get() == f35397c && this.f35400b != null;
    }

    public boolean n8(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable<T>[] publishDisposableArr2;
        do {
            publishDisposableArr = this.f35399a.get();
            if (publishDisposableArr == f35397c) {
                return false;
            }
            int length = publishDisposableArr.length;
            publishDisposableArr2 = new PublishDisposable[length + 1];
            System.arraycopy(publishDisposableArr, 0, publishDisposableArr2, 0, length);
            publishDisposableArr2[length] = publishDisposable;
        } while (!this.f35399a.compareAndSet(publishDisposableArr, publishDisposableArr2));
        return true;
    }

    @Override // xi.g0
    public void onComplete() {
        PublishDisposable<T>[] publishDisposableArr = this.f35399a.get();
        PublishDisposable<T>[] publishDisposableArr2 = f35397c;
        if (publishDisposableArr == publishDisposableArr2) {
            return;
        }
        for (PublishDisposable<T> publishDisposable : this.f35399a.getAndSet(publishDisposableArr2)) {
            publishDisposable.a();
        }
    }

    @Override // xi.g0
    public void onError(Throwable th2) {
        io.reactivex.internal.functions.a.g(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishDisposable<T>[] publishDisposableArr = this.f35399a.get();
        PublishDisposable<T>[] publishDisposableArr2 = f35397c;
        if (publishDisposableArr == publishDisposableArr2) {
            kj.a.Y(th2);
            return;
        }
        this.f35400b = th2;
        for (PublishDisposable<T> publishDisposable : this.f35399a.getAndSet(publishDisposableArr2)) {
            publishDisposable.b(th2);
        }
    }

    @Override // xi.g0
    public void onNext(T t10) {
        io.reactivex.internal.functions.a.g(t10, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (PublishDisposable<T> publishDisposable : this.f35399a.get()) {
            publishDisposable.c(t10);
        }
    }

    @Override // xi.g0
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        if (this.f35399a.get() == f35397c) {
            bVar.dispose();
        }
    }

    public void p8(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable<T>[] publishDisposableArr2;
        do {
            publishDisposableArr = this.f35399a.get();
            if (publishDisposableArr == f35397c || publishDisposableArr == f35398d) {
                return;
            }
            int length = publishDisposableArr.length;
            int i10 = -1;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (publishDisposableArr[i11] == publishDisposable) {
                    i10 = i11;
                    break;
                }
                i11++;
            }
            if (i10 < 0) {
                return;
            }
            if (length == 1) {
                publishDisposableArr2 = f35398d;
            } else {
                PublishDisposable<T>[] publishDisposableArr3 = new PublishDisposable[length - 1];
                System.arraycopy(publishDisposableArr, 0, publishDisposableArr3, 0, i10);
                System.arraycopy(publishDisposableArr, i10 + 1, publishDisposableArr3, i10, (length - i10) - 1);
                publishDisposableArr2 = publishDisposableArr3;
            }
        } while (!this.f35399a.compareAndSet(publishDisposableArr, publishDisposableArr2));
    }
}
