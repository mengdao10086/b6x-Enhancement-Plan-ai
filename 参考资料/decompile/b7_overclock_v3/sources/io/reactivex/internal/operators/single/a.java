package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicBoolean;
import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class a<T> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<? extends T>[] f34994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Iterable<? extends o0<? extends T>> f34995b;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.single.a$a, reason: collision with other inner class name */
    public static final class C0395a<T> implements l0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final io.reactivex.disposables.a f34996a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final l0<? super T> f34997b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicBoolean f34998c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public io.reactivex.disposables.b f34999d;

        public C0395a(l0<? super T> l0Var, io.reactivex.disposables.a aVar, AtomicBoolean atomicBoolean) {
            this.f34997b = l0Var;
            this.f34996a = aVar;
            this.f34998c = atomicBoolean;
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            if (!this.f34998c.compareAndSet(false, true)) {
                kj.a.Y(th2);
                return;
            }
            this.f34996a.c(this.f34999d);
            this.f34996a.dispose();
            this.f34997b.onError(th2);
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f34999d = bVar;
            this.f34996a.b(bVar);
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            if (this.f34998c.compareAndSet(false, true)) {
                this.f34996a.c(this.f34999d);
                this.f34996a.dispose();
                this.f34997b.onSuccess(t10);
            }
        }
    }

    public a(o0<? extends T>[] o0VarArr, Iterable<? extends o0<? extends T>> iterable) {
        this.f34994a = o0VarArr;
        this.f34995b = iterable;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        int length;
        o0<? extends T>[] o0VarArr = this.f34994a;
        if (o0VarArr == null) {
            o0VarArr = new o0[8];
            try {
                length = 0;
                for (o0<? extends T> o0Var : this.f34995b) {
                    if (o0Var == null) {
                        EmptyDisposable.error(new NullPointerException("One of the sources is null"), l0Var);
                        return;
                    }
                    if (length == o0VarArr.length) {
                        o0<? extends T>[] o0VarArr2 = new o0[(length >> 2) + length];
                        System.arraycopy(o0VarArr, 0, o0VarArr2, 0, length);
                        o0VarArr = o0VarArr2;
                    }
                    int i10 = length + 1;
                    o0VarArr[length] = o0Var;
                    length = i10;
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                EmptyDisposable.error(th2, l0Var);
                return;
            }
        } else {
            length = o0VarArr.length;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        io.reactivex.disposables.a aVar = new io.reactivex.disposables.a();
        l0Var.onSubscribe(aVar);
        for (int i11 = 0; i11 < length; i11++) {
            o0<? extends T> o0Var2 = o0VarArr[i11];
            if (aVar.isDisposed()) {
                return;
            }
            if (o0Var2 == null) {
                aVar.dispose();
                NullPointerException nullPointerException = new NullPointerException("One of the sources is null");
                if (atomicBoolean.compareAndSet(false, true)) {
                    l0Var.onError(nullPointerException);
                    return;
                } else {
                    kj.a.Y(nullPointerException);
                    return;
                }
            }
            o0Var2.a(new C0395a(l0Var, aVar, atomicBoolean));
        }
    }
}
