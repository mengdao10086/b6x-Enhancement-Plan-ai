package io.reactivex.subjects;

import bj.e;
import bj.f;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import xi.q;
import xi.t;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeSubject<T> extends q<T> implements t<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final MaybeDisposable[] f35391e = new MaybeDisposable[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final MaybeDisposable[] f35392f = new MaybeDisposable[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f35395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Throwable f35396d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f35394b = new AtomicBoolean();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<MaybeDisposable<T>[]> f35393a = new AtomicReference<>(f35391e);

    public static final class MaybeDisposable<T> extends AtomicReference<MaybeSubject<T>> implements io.reactivex.disposables.b {
        private static final long serialVersionUID = -7650903191002190468L;
        public final t<? super T> downstream;

        public MaybeDisposable(t<? super T> tVar, MaybeSubject<T> maybeSubject) {
            this.downstream = tVar;
            lazySet(maybeSubject);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            MaybeSubject<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.n2(this);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == null;
        }
    }

    @bj.c
    @e
    public static <T> MaybeSubject<T> f2() {
        return new MaybeSubject<>();
    }

    public boolean e2(MaybeDisposable<T> maybeDisposable) {
        MaybeDisposable<T>[] maybeDisposableArr;
        MaybeDisposable<T>[] maybeDisposableArr2;
        do {
            maybeDisposableArr = this.f35393a.get();
            if (maybeDisposableArr == f35392f) {
                return false;
            }
            int length = maybeDisposableArr.length;
            maybeDisposableArr2 = new MaybeDisposable[length + 1];
            System.arraycopy(maybeDisposableArr, 0, maybeDisposableArr2, 0, length);
            maybeDisposableArr2[length] = maybeDisposable;
        } while (!this.f35393a.compareAndSet(maybeDisposableArr, maybeDisposableArr2));
        return true;
    }

    @f
    public Throwable g2() {
        if (this.f35393a.get() == f35392f) {
            return this.f35396d;
        }
        return null;
    }

    @f
    public T h2() {
        if (this.f35393a.get() == f35392f) {
            return this.f35395c;
        }
        return null;
    }

    public boolean i2() {
        return this.f35393a.get() == f35392f && this.f35395c == null && this.f35396d == null;
    }

    public boolean j2() {
        return this.f35393a.get().length != 0;
    }

    public boolean k2() {
        return this.f35393a.get() == f35392f && this.f35396d != null;
    }

    public boolean l2() {
        return this.f35393a.get() == f35392f && this.f35395c != null;
    }

    public int m2() {
        return this.f35393a.get().length;
    }

    public void n2(MaybeDisposable<T> maybeDisposable) {
        MaybeDisposable<T>[] maybeDisposableArr;
        MaybeDisposable<T>[] maybeDisposableArr2;
        do {
            maybeDisposableArr = this.f35393a.get();
            int length = maybeDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i10 = -1;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (maybeDisposableArr[i11] == maybeDisposable) {
                    i10 = i11;
                    break;
                }
                i11++;
            }
            if (i10 < 0) {
                return;
            }
            if (length == 1) {
                maybeDisposableArr2 = f35391e;
            } else {
                MaybeDisposable<T>[] maybeDisposableArr3 = new MaybeDisposable[length - 1];
                System.arraycopy(maybeDisposableArr, 0, maybeDisposableArr3, 0, i10);
                System.arraycopy(maybeDisposableArr, i10 + 1, maybeDisposableArr3, i10, (length - i10) - 1);
                maybeDisposableArr2 = maybeDisposableArr3;
            }
        } while (!this.f35393a.compareAndSet(maybeDisposableArr, maybeDisposableArr2));
    }

    @Override // xi.t
    public void onComplete() {
        if (this.f35394b.compareAndSet(false, true)) {
            for (MaybeDisposable<T> maybeDisposable : this.f35393a.getAndSet(f35392f)) {
                maybeDisposable.downstream.onComplete();
            }
        }
    }

    @Override // xi.t
    public void onError(Throwable th2) {
        io.reactivex.internal.functions.a.g(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f35394b.compareAndSet(false, true)) {
            kj.a.Y(th2);
            return;
        }
        this.f35396d = th2;
        for (MaybeDisposable<T> maybeDisposable : this.f35393a.getAndSet(f35392f)) {
            maybeDisposable.downstream.onError(th2);
        }
    }

    @Override // xi.t
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        if (this.f35393a.get() == f35392f) {
            bVar.dispose();
        }
    }

    @Override // xi.t
    public void onSuccess(T t10) {
        io.reactivex.internal.functions.a.g(t10, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f35394b.compareAndSet(false, true)) {
            this.f35395c = t10;
            for (MaybeDisposable<T> maybeDisposable : this.f35393a.getAndSet(f35392f)) {
                maybeDisposable.downstream.onSuccess(t10);
            }
        }
    }

    @Override // xi.q
    public void q1(t<? super T> tVar) {
        MaybeDisposable<T> maybeDisposable = new MaybeDisposable<>(tVar, this);
        tVar.onSubscribe(maybeDisposable);
        if (e2(maybeDisposable)) {
            if (maybeDisposable.isDisposed()) {
                n2(maybeDisposable);
                return;
            }
            return;
        }
        Throwable th2 = this.f35396d;
        if (th2 != null) {
            tVar.onError(th2);
            return;
        }
        T t10 = this.f35395c;
        if (t10 == null) {
            tVar.onComplete();
        } else {
            tVar.onSuccess(t10);
        }
    }
}
