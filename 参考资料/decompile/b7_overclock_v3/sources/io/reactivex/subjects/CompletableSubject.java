package io.reactivex.subjects;

import bj.e;
import bj.f;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import xi.d;

/* JADX INFO: loaded from: classes5.dex */
public final class CompletableSubject extends xi.a implements d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CompletableDisposable[] f35386d = new CompletableDisposable[0];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final CompletableDisposable[] f35387e = new CompletableDisposable[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Throwable f35390c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f35389b = new AtomicBoolean();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<CompletableDisposable[]> f35388a = new AtomicReference<>(f35386d);

    public static final class CompletableDisposable extends AtomicReference<CompletableSubject> implements io.reactivex.disposables.b {
        private static final long serialVersionUID = -7650903191002190468L;
        public final d downstream;

        public CompletableDisposable(d dVar, CompletableSubject completableSubject) {
            this.downstream = dVar;
            lazySet(completableSubject);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            CompletableSubject andSet = getAndSet(null);
            if (andSet != null) {
                andSet.o1(this);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == null;
        }
    }

    @bj.c
    @e
    public static CompletableSubject i1() {
        return new CompletableSubject();
    }

    @Override // xi.a
    public void I0(d dVar) {
        CompletableDisposable completableDisposable = new CompletableDisposable(dVar, this);
        dVar.onSubscribe(completableDisposable);
        if (h1(completableDisposable)) {
            if (completableDisposable.isDisposed()) {
                o1(completableDisposable);
            }
        } else {
            Throwable th2 = this.f35390c;
            if (th2 != null) {
                dVar.onError(th2);
            } else {
                dVar.onComplete();
            }
        }
    }

    public boolean h1(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.f35388a.get();
            if (completableDisposableArr == f35387e) {
                return false;
            }
            int length = completableDisposableArr.length;
            completableDisposableArr2 = new CompletableDisposable[length + 1];
            System.arraycopy(completableDisposableArr, 0, completableDisposableArr2, 0, length);
            completableDisposableArr2[length] = completableDisposable;
        } while (!this.f35388a.compareAndSet(completableDisposableArr, completableDisposableArr2));
        return true;
    }

    @f
    public Throwable j1() {
        if (this.f35388a.get() == f35387e) {
            return this.f35390c;
        }
        return null;
    }

    public boolean k1() {
        return this.f35388a.get() == f35387e && this.f35390c == null;
    }

    public boolean l1() {
        return this.f35388a.get().length != 0;
    }

    public boolean m1() {
        return this.f35388a.get() == f35387e && this.f35390c != null;
    }

    public int n1() {
        return this.f35388a.get().length;
    }

    public void o1(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.f35388a.get();
            int length = completableDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i10 = -1;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (completableDisposableArr[i11] == completableDisposable) {
                    i10 = i11;
                    break;
                }
                i11++;
            }
            if (i10 < 0) {
                return;
            }
            if (length == 1) {
                completableDisposableArr2 = f35386d;
            } else {
                CompletableDisposable[] completableDisposableArr3 = new CompletableDisposable[length - 1];
                System.arraycopy(completableDisposableArr, 0, completableDisposableArr3, 0, i10);
                System.arraycopy(completableDisposableArr, i10 + 1, completableDisposableArr3, i10, (length - i10) - 1);
                completableDisposableArr2 = completableDisposableArr3;
            }
        } while (!this.f35388a.compareAndSet(completableDisposableArr, completableDisposableArr2));
    }

    @Override // xi.d, xi.t
    public void onComplete() {
        if (this.f35389b.compareAndSet(false, true)) {
            for (CompletableDisposable completableDisposable : this.f35388a.getAndSet(f35387e)) {
                completableDisposable.downstream.onComplete();
            }
        }
    }

    @Override // xi.d
    public void onError(Throwable th2) {
        io.reactivex.internal.functions.a.g(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f35389b.compareAndSet(false, true)) {
            kj.a.Y(th2);
            return;
        }
        this.f35390c = th2;
        for (CompletableDisposable completableDisposable : this.f35388a.getAndSet(f35387e)) {
            completableDisposable.downstream.onError(th2);
        }
    }

    @Override // xi.d
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        if (this.f35388a.get() == f35387e) {
            bVar.dispose();
        }
    }
}
